# Upgrade Provider Errors

Use this file when the `upgrade-provider` tool fails and you need concrete fixes.
For patch edits/removals/rebases, follow the `upstream-patches` skill workflow.

## Patch conflicts during rebase

The tool uses `scripts/upstream.sh` to apply patch commits in the `upstream` submodule. If a patch no longer applies cleanly, you will see rebase errors like:

```
error: could not apply 83b04967e... docs patching
hint: Resolve all conflicts manually, mark them as resolved with
hint: "git add/rm <conflicted_files>", then run "git rebase --continue".
```

Fix from the `upstream` directory, following `upstream-patches` defaults (edit the owning patch commit; do not create a new patch unless asked):

1. Identify conflicted files.
2. Resolve conflicts while preserving the intent of the patch in `patches/`.
3. Search for conflict markers and remove all of them before continuing.
4. `git add` the resolved files.
5. `git rebase --continue`.

If `git rebase --continue` opens an editor in automation contexts, run with `GIT_EDITOR=true`.

Avoid:

- Hand-editing `patches/*.patch` unless intentionally doing raw patch surgery.
- Direct edits under `upstream/` outside `checkout/check_in` workflow.

After the rebase completes, rerun `upgrade-provider` from the repo root.

### Patch intent guidance

- Docs-related patches usually replace or remove Terraform references. Preserve those changes when resolving conflicts.

## Upstream provider relies on ignored replace directives

When `upgrade-provider` fails during `Update TF Provider` with an upstream module resolution error like:

```
go get github.com/rancher/...: exit status 1:
go: github.com/rancher/terraform-provider-rancher2@... requires github.com/rancher/rancher@v0.0.0: unknown revision v0.0.0
```

the upstream provider may have invalid-looking `require` entries that are only made valid by its own `replace` directives. Go ignores `replace` directives from dependency modules; only the main module's `go.mod` replacements are honored.

Fix in the Pulumi provider repo:

1. Inspect upstream `go.mod` at the target tag or commit.
2. Add the narrowest necessary upstream `replace` directives to `provider/go.mod`.
3. Avoid copying the entire upstream `replace` block unless required; broad replacements can conflict with Pulumi or bridge dependencies.
4. Run `go mod tidy` from `provider/`.
5. Rerun `upgrade-provider` from the repo root with the target version explicit. Preserve the original major/non-major intent:

```bash
upgrade-provider pulumi/<provider> --repo-path . --target-version <version>
```

Add `--major` only when the target upstream version crosses the current upstream major version. Passing `--major` for a same-major target makes `upgrade-provider` fail and can trigger unwanted major-version rewrite behavior.

If repo tools are managed by `mise`, run under the repo environment so Go and converter plugins match CI:

```bash
eval "$(mise env)" && upgrade-provider pulumi/<provider> --repo-path . --target-version <version>
```

Example: `pulumi-rancher2` upgrading to upstream `terraform-provider-rancher2` `v14.1.0` needed main-module replacements like:

```go
replace (
  github.com/rancher/rancher => github.com/rancher/rancher v0.0.0-20260226161459-b186acea1a52
  github.com/rancher/rancher/pkg/apis => github.com/rancher/rancher/pkg/apis v0.0.0-20260226161459-b186acea1a52
  github.com/rancher/rancher/pkg/client => github.com/rancher/rancher/pkg/client v0.0.0-20260226161459-b186acea1a52
)
```

In that case, copying upstream OpenTelemetry replacements caused conflicts with Pulumi/bridge dependencies; the narrower Rancher-focused replacements were sufficient.

## Upstream provider edits vendored dependency but module graph is stale

When `make tfgen` or `upgrade-provider` fails compiling the upstream Terraform provider with missing fields or methods from one of its dependencies, check whether upstream edited a vendored copy of that dependency without publishing or requiring a matching module version.

Common symptoms:

```text
unknown field Destination in struct literal of type "github.com/f5devcentral/go-bigip".Gtmmonitor
client.CreateGtmMonitor undefined
client.GetGtmMonitor undefined
```

Confirm before fixing:

1. Identify the dependency package in the compiler errors.
2. Inspect the upstream provider tag or commit and compare its `vendor/<module>/...` files against the module version selected by `provider/go.mod`.
3. If the needed fields or methods exist only under upstream `vendor/`, treat this as an upstream vendored-dependency patch case.

Fix in the Pulumi provider repo:

1. Add or update the upstream Terraform provider submodule at `upstream`, pinned to the target upstream tag or commit.
2. Set `.gitmodules` for the submodule to include `ignore = dirty` so an applied patch queue does not leave top-level `git status` noisy.
3. Use the `upstream-patches` skill and `./scripts/upstream.sh checkout` / `check_in` workflow to add a new patch containing only minimal `go.mod` files in the affected vendored dependency directories. This is an allowed new-patch case because the provider needs durable vendored module metadata:

```bash
./scripts/upstream.sh checkout
cd upstream
# Add minimal go.mod files under vendor/<module>/...
git add vendor/<module>/go.mod
git commit -m "Add module metadata for vendored <module>"
cd ..
./scripts/upstream.sh check_in
```

4. Add narrow `replace` directives in `provider/go.mod` that point only the stale dependency modules at `../upstream/vendor/<module>`.
5. Run `go mod tidy` from `provider/`, then rerun `make tfgen` or `upgrade-provider`.

Example:

```go
replace github.com/f5devcentral/go-bigip => ../upstream/vendor/github.com/f5devcentral/go-bigip

replace github.com/f5devcentral/go-bigip/f5teem => ../upstream/vendor/github.com/f5devcentral/go-bigip/f5teem
```

Avoid:

- Copying the dependency into `provider/third_party` or another provider-owned vendor directory.
- Replacing the whole upstream Terraform provider module with `../upstream` unless necessary; this can break bridge documentation and example discovery because the module cache layout changes.
- Hand-editing `patches/*.patch` instead of using `upstream-patches`, unless intentionally doing raw patch surgery.

When adding this kind of patch, make the tracking issue explicit and de-duplicated:

1. Search existing issues first:

```bash
gh issue list --label "area/patch" --search "vendored dependency <module> in:title,body" --json number,title,url
```

2. If no matching issue exists, create one with `gh issue create`, labeled `area/patch`, explaining why the patch exists and when it can be removed:

```bash
gh issue create \
  --title "Track vendored dependency patch for <module>" \
  --label "area/patch" \
  --body "$(cat <<'EOF'
The provider upgrade needs a patch because upstream vendors dependency changes
that are not available from the published module graph.

Removal criteria:
- Upstream requires a published dependency module containing the vendored changes, or
- The provider no longer needs the dependency replace directives.

Verification:
- Delete the patch and related provider/go.mod replace directives.
- Run make tfgen.
EOF
)"
```

3. Link the issue from the upgrade PR's "Fixes applied to unblock upgrade" section.

Removal criteria should usually be: upstream requires a published dependency module containing the vendored changes, or the provider no longer needs the dependency `replace` directives. Verify removal by deleting the patch and `replace` directives, then rerunning `make tfgen`.

## New resources missing module mapping

When new upstream resources appear, token mapping can fail with errors like:

```
* "google_observability_trace_scope": could not find a module that prefixes 'observability_trace_scope' in '[...]'
```

Fix by updating `provider/resources.go` (or the repo-equivalent file):

1. Determine the Terraform module name (usually the first segment after the provider prefix). In the example, use `observability`.
2. Add a module mapping in `moduleMapping`:

```go
var moduleMapping = map[string]string{
  "observability": "Observability",
}
```

3. If related resources already map to a different module, map the new resource individually instead of adding a new module key. Example:

```go
DataSources: map[string]*tfbridge.DataSourceInfo{
  "aws_vpn_gateway": {Tok: awsDataSource(ec2Mod, "getVpnGateway")},
}
```

After updating, rerun `upgrade-provider`.

## .NET duplicate file from nested Get suffix collision

When `make generate_sdks` fails during .NET SDK generation with an error like:

```text
panic: fatal: An assertion has failed: duplicate file: Chaos/Inputs/ProbeTemplateHttpProbeMethodGetArgs.cs
```

look for a newly-added nested schema type where a parent type and a child field/type collide with the .NET generator's helper suffixes. Common pattern:

- Parent object type: `<X>`
- Child field/type: `<X>Get`
- .NET state helper for the parent: `<X>GetArgs.cs`
- .NET input helper for the child: `<X>GetArgs.cs`

Confirm the shape was introduced by the upstream bump before renaming. Compare the generated schema on the default branch with the upgrade branch. Derive the branch and schema path instead of assuming provider-specific names:

```bash
default_branch=$(git remote show origin | sed -n 's/.*HEAD branch: //p')
schema_path=$(find provider/cmd -path '*/schema.json' -print -quit)
git show "origin/${default_branch}:${schema_path}" | rg "<NestedTypeName>"
rg "<NestedTypeName>" "$schema_path"
```

Replace `<NestedTypeName>` with the colliding nested type prefix from the duplicate filename.

Fix by applying a normal bridge `Name` override in `provider/resources.go` to rename the smallest nested field that causes the collision. Do not use `CSharpName`; it only changes C# property labels and does not change generated nested type filenames. Avoid schema post-processors unless there is no ordinary bridge mapping available.

Example:

```go
"harness_chaos_probe_template": {
  Tok: harnessResource("chaos", "ProbeTemplate"),
  Fields: map[string]*tfbridge.SchemaInfo{
    "http_probe": {
      Elem: &tfbridge.SchemaInfo{
        Fields: map[string]*tfbridge.SchemaInfo{
          "method": {
            Elem: &tfbridge.SchemaInfo{
              Fields: map[string]*tfbridge.SchemaInfo{
                "get": {Name: "getMethod"},
              },
            },
          },
        },
      },
    },
  },
},
```

After updating the bridge mapping, rerun `upgrade-provider` from the repo root so schema and SDKs regenerate consistently.

## ID attribute wrong type (tfgen unresolved ID mapping)

When `make tfgen` fails with an error like:

```
error: Resource linode_producer_image_share_group has a problem: "id" attribute is of type "Int", expected type "string". To map this resource consider overriding the SchemaInfo.Type field or specifying ResourceInfo.ComputeID
error: There were 1 unresolved ID mapping errors
```

The upstream resource has an `id` attribute, but it is not a string. Fix it in `provider/resources.go` (or equivalent) by applying the override:

```go
prov.P.ResourcesMap().Range(func(key string, value shim.Resource) bool {
  if value.Schema().Get("id").Type() != shim.TypeString {
    r := prov.Resources[key]
    if r.Fields == nil {
      r.Fields = make(map[string]*tfbridge.SchemaInfo, 1)
    }
    r.Fields["id"] = &tfbridge.SchemaInfo{Type: "string"}
  }
  return true
})
```

- If the `id` type is not coercible to string, set `ResourceInfo.ComputeID` instead.

## ID attribute is input type (tfgen unresolved ID mapping)

When `make tfgen` fails with an error like:

```
error: Resource cloudflare_zero_trust_access_ai_controls_mcp_server has a problem: an "id" input attribute is not allowed. To map this resource specify SchemaInfo.Name and ResourceInfo.ComputeID
```

The upstream resource exposes `id` as Optional/Required. Remap the input field to `<resource_name>_id` and delegate the ID to that new property. Convert the field name to Pulumi camelCase (for example, `cloudflare_zero_trust_access_ai_controls_mcp_server` -> `zeroTrustAccessAiControlsMcpServerId`).

```go
"cloudflare_zero_trust_access_ai_controls_mcp_server": {
  Fields: map[string]*info.Schema{
    "id": {
      Name: "zeroTrustAccessAiControlsMcpServerId",
    },
  },
  ComputeID: tfbridge.DelegateIDField(resource.PropertyKey("zeroTrustAccessAiControlsMcpServerId"),
    "cloudflare", "https://github.com/pulumi/pulumi-cloudflare"),
},
```
