# Testing `pulumi-aws`

Test the owning behavior at the cheapest layer that can prove it. The language and AWS resource used in a bug report do not determine the test: a Node.js program that exposes an AWS provider `Diff` bug may become a credential-free provider RPC replay if neither Node.js nor AWS is part of the invariant.

For the shared test APIs, see the [`pulumitest` documentation](https://github.com/pulumi/providertest/blob/main/pulumitest/README.md). This guide explains which test belongs in this repository and gives the repository-specific setup for each test type.

## Quick reference

| Behavior to prove | Test to write | Location | AWS credentials |
| --- | --- | --- | --- |
| Pure helper, mapping, transform, or metadata rule | Provider unit test | `provider/*_test.go` | No |
| Small `CheckConfig`, `Configure`, or other RPC with hand-built inputs | Direct provider server test | `provider/*_test.go` | No; use `httptest` for AWS requests |
| Exact `Check`, `Diff`, or configuration RPC regression | Raw provider RPC replay | `provider/replay_regressions_test.go` or `provider/configure_test.go` | No |
| Pulumi schema or generated API shape | Schema/codegen test and generated SDK build | `provider/`, `provider/cmd/`, and generated artifacts | No |
| State written by an older provider | Provider-upgrade test | `examples/*_test.go` and `examples/testdata/recorded/` | Baseline recording: yes; replay may still need config credentials |
| Real AWS CRUD, refresh, import, auth, or runtime behavior | YAML acceptance test | `examples/examples_yaml_test.go` and `examples/test-programs/` | Yes |
| Generated package or language-runtime behavior | Language SDK test | Corresponding `examples/examples_<language>_test.go` | Only if the assertion also needs AWS |

## Decide where the test belongs

This guide covers tests for behavior owned or carried by `pulumi-aws`. Before writing one, state the failed invariant in one sentence and choose the lowest repository test layer that can observe it:

1. If the behavior comes from `provider/`, a mapping, or an overlay, prefer a provider unit or RPC-level test.
2. If the invariant begins with state written by an older Pulumi AWS provider, use a provider-upgrade test.
3. If the Pulumi lifecycle or an AWS response is part of the invariant, use a focused program test under `examples/`.
4. If the assertion concerns a generated class, function signature, package, or language runtime, use an SDK test.
5. Use live AWS only when an AWS response, persisted remote state, authentication flow, or deployed runtime is part of the assertion.

For a carried patch, follow [`docs/upstream-patches.md`](./docs/upstream-patches.md) in addition to this guide. If ownership has not been established, investigate it before adding a broad Pulumi test as a proxy for behavior owned elsewhere.

A test that only proves that a common resource deployed is broad smoke. Add broad smoke only when it covers a missing packaging, runtime, authentication, or release boundary.

## Provider unit tests

Use a provider unit test when the relevant input can be constructed directly in Go. This is the preferred test for parsing, metadata, callbacks, and deterministic transforms because a failure points at provider-owned code without involving the engine or AWS.

```go
func TestParseAssumeRolesRejectsLegacyKey(t *testing.T) {
    vars := resource.PropertyMap{
        "assumeRole": resource.NewObjectProperty(resource.PropertyMap{
            "roleArn": resource.NewStringProperty(
                "arn:aws:iam::123456789012:role/example"),
        }),
    }

    _, err := parseAssumeRoles(vars)
    require.ErrorContains(t, err,
        "invalid config key 'aws:assumeRole', should be 'aws:assumeRoles'")
}
```

Put tests for the root provider package beside the code they exercise. Use an invariant test over all resources when the rule is provider-wide; `provider/resources_test.go` contains examples that compare generated resource metadata with the upstream schema.

`make test_provider` currently runs `go test .` from `provider/`, so it does not execute tests under `provider/pkg/...` or `provider/cmd/...`. Those package-local tests exist, but do not treat them as CI coverage until the target is changed to include subpackages.

Run root provider tests with:

```sh
make test_provider
```

Run one provider test with:

```sh
make test_provider GO_TEST_EXEC="go test -run '^TestName\\z' -count=1"
```

## Direct provider server tests

Call the provider server directly when the RPC request is small and does not need to come from a real Pulumi program. This is useful for provider configuration and for behavior that makes a bounded AWS request which can be served by `httptest`.

```go
func TestCheckConfigRejectsLegacyAssumeRole(t *testing.T) {
    unsetAWSEnv()
    t.Setenv("AWS_ACCESS_KEY_ID", "test")
    t.Setenv("AWS_SECRET_ACCESS_KEY", "test")
    t.Setenv("AWS_REGION", "us-west-2")
    t.Setenv("AWS_SKIP_CREDENTIALS_VALIDATION", "true")

    provider, err := testProviderServer()
    require.NoError(t, err)

    _, err = provider.CheckConfig(context.Background(), &pulumirpc.CheckRequest{
        Urn:  "urn:pulumi:test::project::pulumi:providers:aws::default",
        Olds: mustStruct(t, map[string]any{}),
        News: mustStruct(t, map[string]any{
            "accessKey": "test",
            "assumeRole": map[string]any{
                "roleArn": "arn:aws:iam::123456789012:role/example",
            },
            "region":    "us-west-2",
            "secretKey": "test",
        }),
    })

    require.ErrorContains(t, err, "invalid config key 'aws:assumeRole'")
}
```

If the exact engine-shaped request or old state is the regression input, use the existing raw RPC replay helper instead.

## Raw provider RPC replay tests

`replaySequence` sends complete recorded RPC requests to the current in-process provider and compares its responses with the embedded expectations. It is useful for a narrow `Check`, `Diff`, `CheckConfig`, `DiffConfig`, or `Configure` regression that would otherwise require a live Pulumi program.

```go
func TestCheckConfigWithUnknownKeys(t *testing.T) {
    t.Parallel()

    replaySequence(t, `[
      {
        "method": "/pulumirpc.ResourceProvider/CheckConfig",
        "request": {
          "urn": "urn:pulumi:test::project::pulumi:providers:aws::default",
          "olds": {},
          "news": {
            "unknownKey": "injected",
            "accessKey": "test",
            "region": "us-east-1",
            "secretKey": "test",
            "skipCredentialsValidation": "true",
            "skipRequestingAccountId": "true"
          }
        },
        "response": {
          "inputs": "*",
          "failures": [{"reason": "*"}]
        }
      }
    ]`)
}
```

Use `setReplayAWSEnv` when the provider needs configuration but the RPC should not contact AWS. `replaySequence` constructs the real muxed provider server with an empty schema, which avoids the cost of loading the generated schema for methods that do not need it.

The replay JSON is both input and assertion: `request` defines the regression scenario and `response` is the expected current behavior. Keep only the RPCs needed by the invariant. Large multi-method transcripts make failures harder to attribute and couple the test to unrelated provider output.

To derive a replay from a real lifecycle:

1. Reproduce the behavior with a focused `pulumitest` test; gRPC logging is enabled by default.
2. Take the completed provider entry from `grpc.json`, not the `request_started` entry.
3. Reduce it to the request fields needed to reproduce and the response fields that express the invariant.
4. Replace account-specific identifiers with inert values and inspect the result for credentials or resource data.
5. Put the test in `provider/replay_regressions_test.go`, or in `provider/configure_test.go` for configuration RPCs.

There is no repository helper today that records, filters, or updates raw replay fixtures. The JSON is maintained in the Go test. If reducing the recording would require inventing old state or weakening the expected response with broad wildcards, keep a focused `pulumitest` test instead.

Run a replay as a provider test:

```sh
make test_provider GO_TEST_EXEC="go test -run '^TestCheckConfigWithUnknownKeys\\z' -count=1"
```

## Schema and code-generation tests

A provider mapping change can be wrong even when its Go implementation compiles. If a change affects resource tokens, fields, types, aliases, defaults, overlays, or generated documentation:

1. Add a focused Go test for nontrivial transformation logic.
2. Regenerate the schema.
3. Inspect the schema diff for the intended public API change.
4. Build generated SDKs to prove each language accepts the new schema.

```sh
make schema
make build_sdks
```

Inspect the generated diff before committing; CI regenerates each SDK and fails if committed output is stale. Do not manually edit files under `sdk/`.

Use a language smoke test only when schema inspection and SDK compilation cannot prove the assertion—for example, an overlay must package a Node.js callback or generated Python import code must execute.

## Provider-upgrade tests

Use an upgrade test when the invariant begins with state produced by an older provider. Ordinary acceptance tests create state with the local provider and cannot prove upgrade compatibility.

```go
func TestQueueUpgrade(t *testing.T) {
    testProviderUpgrade(t,
        filepath.Join("test-programs", "queue-upgrade"), nil)
}
```

The helper restores recorded baseline state, switches to the local provider, and previews the existing stack. By default it asserts that the upgrade does not replace resources.

Add explicit assertions when the intended migration allows some changes:

```go
test, _ := testProviderUpgrade(t, program, opts,
    optproviderupgrade.NewSourcePath(filepath.Join(program, "step1")))

result := test.Up(t, optup.Diff())
assertup.HasNoReplacements(t, result)
require.NotNil(t, result.Summary.ResourceChanges)
require.NotZero(t, (*result.Summary.ResourceChanges)["update"])
```

Keep baseline fixtures stable. Refreshing them changes the historical state being tested and can hide the incompatibility the test was created to detect. Record a new baseline only when the baseline version or scenario intentionally changes, and review both `stack.json` and `grpc.json`.

Run one upgrade test with:

```sh
make GOTESTARGS="-run '^TestQueueUpgrade$' -count=1" test
```

## Live AWS acceptance tests

Use a live acceptance test when the assertion requires AWS itself. Examples include remote defaults observed during refresh, IAM role chaining, IMDS, Lambda callback execution, ECR image publishing, and CRUD behavior changed by a carried upstream patch.

Provider behavior should use YAML unless a generated SDK or language runtime is part of the assertion. Put new regression programs under `examples/test-programs/<name>`.

```go
func TestAccExample(t *testing.T) {
    cwd := getCwd(t)
    test := pulumitest.NewPulumiTest(t,
        filepath.Join(cwd, "test-programs", "example"),
        opttest.SkipInstall(),
        opttest.LocalProviderPath("aws", filepath.Join(cwd, "..", "bin")),
    )
    test.SetConfig(t, "aws:region", getEnvRegion(t))

    runExampleLifecycle(t, test, exampleLifecycleOptions{})
}
```

`runExampleLifecycle` performs the standard contract:

1. Preview and update.
2. Export and re-import state.
3. Preview and update again, expecting no changes.
4. Run optional output or AWS API validation.
5. Refresh, expecting no changes.

Use lifecycle options only when the test names the reason:

- `skipRefresh` when refresh is known not to converge.
- `allowEmptyPreviewChanges` or `allowEmptyUpdateChanges` when a no-op operation legitimately reports changes.
- `validate` when outputs or the backing AWS API are the assertion.

Expected-failure tests must match the intended diagnostic. An assertion that accepts any update failure can pass because of an account quota or transient AWS error:

```go
_, err := test.UpErr(t)
require.ErrorContains(t, err, "the diagnostic this regression protects")
```

For import, source edits, multiple stacks, or another materially different lifecycle, call `pulumitest` operations directly rather than adding switches to `runExampleLifecycle`.

Configure AWS credentials and run one test at a time:

```sh
AWS_REGION=us-west-2 \
make GOTESTARGS="-run '^TestAccExample$' -count=1" test
```

Do not run unfiltered `make test` unless you intend to create resources for the full acceptance suite.

## Generated SDK and runtime tests

Keep a language test only when the language boundary contributes to the behavior. Use the repository's local SDK setup rather than a published package:

| Language | Local SDK setup | Reference |
| --- | --- | --- |
| Node.js | `opttest.YarnLink("@pulumi/aws")` | `newJSExampleTest` |
| Python | Install `sdk/python/bin` into the program's declared virtualenv | `newPythonExampleTest` |
| Go | `opttest.GoModReplacement`, followed by `go mod tidy` | `TestReleaseVerificationGo` |
| .NET | `opttest.DotNetReference` | `TestReleaseVerificationCs` |

The extra Go tidy is required because `GoModReplacement` edits `go.mod` but does not resolve transitive dependencies from the local SDK. Python uses explicit setup because `opttest.PythonLink` installs into the ambient interpreter, not necessarily the virtualenv declared in `Pulumi.yaml`.

Build and install the required SDK before running its test. For example:

```sh
make build_nodejs install_nodejs_sdk
AWS_REGION=us-west-2 \
make GOTESTARGS="-run '^TestNodeSDKBehavior$' -count=1" test
```

Do not copy a provider-behavior test into several languages. SDK compilation plus one smoke test per language covers package integration; duplicated cloud lifecycles increase cost without testing a new boundary.

## What to test for common changes

| Change | Required evidence |
| --- | --- |
| Pure helper or config parser | Provider unit test covering success and failure inputs |
| Provider `Check` transform | Unit test when inputs are simple; raw RPC replay when the engine-shaped request matters |
| Diff suppression | Raw RPC replay with a suppressed-diff case and a negative control that still updates |
| Resource mapping, alias, field, or type | Focused provider/codegen test, regenerated schema, and SDK builds |
| Upstream provider version bump | Provider-upgrade suite plus tests tied to patches affected by the rebase |
| Carried upstream patch | Follow `docs/upstream-patches.md`; add the required focused Pulumi regression under `examples/` |
| Real refresh, import, auth, or runtime behavior | Focused YAML acceptance test |
| Overlay or generated SDK API | Relevant language test; add live AWS only when runtime or cloud behavior is asserted |
| Published package or plugin acquisition | Release-verification workflow, not an ordinary provider regression test |

## Confirm execution evidence

A test is useful evidence only when its execution path is known:

1. **Defined:** the test and a direct assertion exist.
2. **Selected:** the documented command or CI workflow discovers that test.
3. **Executed:** the test ran rather than skipping because of short mode, missing configuration, credentials, or another guard.
4. **Asserted:** execution reached and passed the intended invariant.

`make test_provider` selects only the root `provider` package. A test under `provider/pkg/**` or `provider/cmd/**` requires separate selection until that target changes.

The `examples/` package mixes live AWS tests, provider-upgrade tests, local checks, and tests with skip conditions. After a focused local or CI run, inspect the named test result rather than inferring execution from a passing package or workflow. Report exact commands and outcomes, including skipped, unselected, or credential-blocked tests.

## Compile without running cloud tests

Compile the examples test package without executing tests:

```sh
GITHUB_ACTIONS=1 make TESTTAGS= GOTESTARGS="-run '^$'" test
```

This catches fixture-driver and SDK-linking compile failures but does not validate provider behavior. Record the exact focused tests and generation commands run in the pull request description.
