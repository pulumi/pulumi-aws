# CI Improvements Context

This branch is exploring ways to reduce wall-clock time for the
`run-acceptance-tests` workflow. The current draft PR is:

- https://github.com/pulumi/pulumi-aws/pull/6366

## Current Branch Changes

The branch currently applies the workflow-ordering idea from the earlier
experiment in PR #5785:

- Keep `prerequisites` focused on producing reusable build artifacts:
  - `make schema_embed`
  - `make tfgen_build_only`
  - upload prerequisites artifact
- Move provider unit tests into a separate `test_provider` job.
- Move schema comparison into a separate `build_schema` job.
- Let provider and SDK builds start after the lightweight prerequisites step.
- Restore Go cache in the examples test shards.
- Save one prerequisites Go cache and restore it read-only in downstream
  provider/schema jobs.
- Let examples tests run after provider and SDK builds without waiting for
  `test_provider`; `sentinel` aggregates `test_provider` instead.
- Move provider replay regressions out of `examples` and into `provider`.

This improves scheduling, but it does not yet remove the expensive Go compile
work from the examples test package.

## Main CI Bottleneck Hypothesis

Removing example test cases did not materially reduce total CI time because
test execution is not the only bottleneck. The examples job spends a large
amount of time compiling and loading the Go test package and its dependencies.

One representative log showed:

- `PASS Package . (15m35.557s)`
- `DONE 24 tests in 2115.423s`

That suggests roughly 15.6 minutes inside package test execution but about
35.3 minutes of command wall time. The remaining time is mostly setup,
compilation, linking, dependency loading, and related Go test overhead.

## Why Examples Compile So Much

The `examples` tests are one Go package and CI runs them with `-tags=all`.
Because of that, shared helper files pull heavy dependencies into every shard,
even when a shard only runs tests that do not logically need those dependencies.

Current package-level dependency facts:

- `examples/go.mod` directly requires:
  - `github.com/pulumi/providertest`
  - `github.com/pulumi/pulumi-aws/provider/v7`
  - `github.com/pulumi/pulumi-aws/sdk/v7`
  - `github.com/pulumi/pulumi-terraform-bridge/v3`
- `examples/go.mod` replaces:
  - `github.com/hashicorp/terraform-provider-aws => ../upstream`
  - `github.com/pulumi/pulumi-aws/provider/v7 => ../provider`
  - `github.com/pulumi/pulumi-aws/sdk/v7 => ../sdk`

These are not only transitive through `providertest`.

## Dependency Map

### Pulumi AWS Provider

`github.com/pulumi/pulumi-aws/provider/v7` is directly imported by:

- `examples/provider_test.go`
- `examples/examples_test.go`

It is used to call `aws.Provider()` and create an in-process provider server
for replay and attached-provider helpers. It is also passed as a local Go module
replacement for Go example tests.

### Pulumi Terraform Bridge

`github.com/pulumi/pulumi-terraform-bridge/v3/pkg/pf/tfbridge` is directly
imported by:

- `examples/provider_test.go`
- `examples/examples_test.go`

It is used with `pfbridge.MakeMuxedServer(...)` to wrap the provider into an
in-process `ResourceProviderServer`.

### Terraform AWS Provider

`github.com/hashicorp/terraform-provider-aws => ../upstream` is needed when the
local Pulumi AWS provider package is compiled because the provider wraps the
upstream Terraform provider. It is also passed as a Go module replacement for
some Go example tests.

YAML programs that run against an already-built `pulumi-resource-aws` binary do
not inherently need this at Go compile time.

### Pulumi AWS SDK

`github.com/pulumi/pulumi-aws/sdk/v7 => ../sdk` is needed for Go language
example tests and release verification. YAML programs do not need the generated
SDK.

Other language tests need SDK artifacts installed at runtime, but that is
separate from compiling the Go test harness.

### Providertest

`github.com/pulumi/providertest` is directly imported and backs provider upgrade
tests, `pulumitest`, replay helpers, local provider handling, and stack
orchestration. It is part of the heavy dependency story, but it is not the only
source of provider/bridge/upstream dependencies.

## Current Counts

From the current `examples` package:

- 95 `func Test...` definitions.
- 42 actual `testProviderUpgrade(...)` call sites.
- 3 actual `replay(...)` call sites.
- `inPlacePulumiTest(...)` and `providerServer(...)` are defined, but no direct
  call sites were found in `examples/*.go`.
- Go SDK tests use local module replacements:
  - `github.com/pulumi/pulumi-aws/sdk/v7 => ../sdk`
  - `github.com/pulumi/pulumi-aws/provider/v7 => ../provider`
  - `github.com/hashicorp/terraform-provider-aws => ../upstream`

## Candidate Work Items

### Move Replay Tests To Provider Package

Status: completed in this branch

Moved the replay tests from `examples/examples_yaml_test.go` into the `provider`
package so they run as part of the `test_provider` path.

Rationale:

- Replay tests directly instantiate the provider and bridge.
- The provider package already has this pattern in `provider/configure_test.go`.
- Keeping replay tests in `examples` forces every examples shard to compile the
  provider and bridge.
- Fake credentials and fake endpoints are already used in provider tests, so
  these tests should not need real AWS credentials.

Known replay call sites:

- `TestRegressUnknownTags`
- `TestSourceCodeHashImportedLambdaChecksCleanly`
- `TestRegressLandingZoneDiff`

Follow-up note:

- The moved tests set fake AWS environment variables explicitly.
- `TestRegressLandingZoneDiff` now sets `skipRequestingAccountId` in its replay
  sequence so it does not try live STS/IAM account discovery with fake
  credentials.

Expected impact:

- Removes `examples/examples_test.go` direct imports of the provider and bridge.
- Moves provider/bridge compile cost to `test_provider`, where it belongs.

### Remove Dead Attached-Provider Helper

Status: completed in this branch

Deleted `inPlacePulumiTest(...)` and `providerServer(...)` from
`examples/provider_test.go`.

Rationale:

- The helper uses `opttest.AttachProvider(...)` with an in-process provider.
- CI should prefer `opttest.LocalProviderPath(...)` and the built provider
  binary because that validates the artifact path we ship.
- No direct call sites were found in `examples/*.go`.

Expected impact:

- Removes another reason for `examples/provider_test.go` to import provider and
  bridge packages.

### Restore Prerequisites Go Cache Read-Only

Status: completed in this branch

The `prerequisites` job now owns the broad provider/schema Go cache. Downstream
provider/schema jobs restore that cache using `actions/cache/restore` instead of
creating their own save-on-success `setup-go` cache entries.

Rationale:

- The repo cache limit is small relative to the size of warmed Go caches.
- `test_provider` used to benefit from the same local runner cache when it lived
  inside `prerequisites`.
- After splitting jobs, restore-only cache reuse preserves that benefit without
  creating another large cache entry.

### Remove `test_provider` From Examples `needs`

Status: completed in this branch

The examples `test` job no longer depends on `test_provider`. `sentinel` depends
on both jobs instead.

Rationale:

- Examples need provider and SDK artifacts.
- Examples do not need provider unit tests to finish before starting.
- `sentinel` is the correct place to aggregate required job success.

### Split Provider Upgrade Helpers From General Examples

Status: candidate

The `testProviderUpgrade(...)` helper has 42 call sites and uses
`providertest`/`pulumitest` upgrade machinery. These tests still need the
provider binary and baseline provider handling.

Options:

- Keep upgrade tests in `examples`, but isolate them under a dedicated build tag
  or package so YAML-only tests do not compile the upgrade machinery.
- Move upgrade-oriented tests into a separate package/module if the test harness
  can still find example programs cleanly.

Expected impact:

- Potentially reduces compile cost for ordinary YAML/external-provider tests.
- Keeps upgrade test semantics intact.

### Rework Go Language Tests

Status: candidate

The Go language tests are currently mixed into the main `examples` test package
and use local module replacements for SDK, provider, and upstream.

Options:

- Return to per-example `go.mod` files for Go examples that need local SDK
  replacements.
- Move Go language tests into a separate package/module.
- Reduce Go language tests to a minimal release-verification smoke and cover
  provider behavior elsewhere.

Rationale:

- YAML examples do not need the generated Go SDK.
- Node/Python/.NET examples need their own SDK artifacts, but do not need the Go
  SDK test wiring at compile time.
- Isolating Go language tests would let a YAML lane avoid compiling local SDK,
  provider, and upstream replacements.

### Create A Lean YAML Lane

Status: candidate

Create a YAML-focused test lane that runs only YAML programs against the
already-built provider binary.

Requirements:

- The lane should avoid importing provider, bridge, upstream, and SDK packages
  in the Go test harness.
- It may need a separate Go package/module or stricter build tags.
- It should depend on provider build artifacts, not SDK build artifacts.

Expected impact:

- Allows YAML tests to start after provider build instead of waiting for SDK
  builds.
- Avoids much of the Go compile cost currently paid by every examples shard.

### Precompile Examples Test Binary

Status: lower priority

Precompiling the `examples` test binary could avoid compiling the same test
package separately in every shard.

Tradeoff:

- If done as a serialized prerequisite, it may just move time earlier.
- It is more valuable if it overlaps with other prerequisite work or if one
  compiled binary is reused across shards.
- Artifact freshness must be handled carefully, especially if generated SDK
  sources or provider artifacts differ from checkout state.

## Open Questions

- Which replay tests need fake AWS endpoints versus only fake credentials and
  skipped validation?
- Can the 42 upgrade tests be isolated without losing the current cached
  baseline-provider behavior?
- Should Go language tests remain broad, or should they become a small SDK
  release-verification lane?
- Should `ci-mgmt` be taught to generate the workflow fan-out, or should this
  remain a manual workflow experiment until the CI shape settles?

## Suggested Next Step

Start with the replay move and dead-helper deletion. That is the narrowest
change that should reduce examples compile dependencies without changing live
integration test behavior.
