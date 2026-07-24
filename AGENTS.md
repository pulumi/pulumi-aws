# Pulumi aws Provider

This is a Go-based Pulumi resource provider that bridges the Terraform provider to Pulumi. It generates SDKs for TypeScript/JavaScript, Python, .NET, Go, and Java. The provider uses the Terraform provider as an upstream source via git submodules.

## Build Commands

**Always use `make` targets. Never run custom commands unless explicitly instructed.**

### Primary Targets
- `make build` - Build provider and all SDKs
- `make provider` - Build provider binary
- `make schema` - Generate provider schema
- `make upstream` - Initialize upstream submodule

### SDK Targets
- `make build_sdks` - Build all SDK packages
- `make build_nodejs` - Build TypeScript/Node.js SDK
- `make build_python` - Build Python SDK
- `make build_dotnet` - Build .NET SDK
- `make build_go` - Build Go SDK
- `make build_java` - Build Java SDK

### Development Targets
- `make lint` - Lint provider Go code
- `make test_provider` - Run root provider package tests

## Repository Structure

```
provider/             -- Go provider implementation
sdk/                  -- Generated SDKs (never edit directly)
upstream/             -- Terraform provider submodule
patches/              -- Carried upstream patches
scripts/              -- Build utilities
examples/             -- Pulumi tests and programs
.ci-mgmt.yaml         -- Source for generated CI and Makefile
Makefile              -- Generated build orchestration
```

### Key Files
- `provider/resources.go` - Resource definitions
- `provider/resources_test.go` - Provider tests

## Development Workflow

1. Initialize repository: `make upstream`
2. Make changes in `provider/` or, for a carried upstream patch, `upstream/`
3. Lint: `make lint`
4. Test: `make test_provider`
5. Build provider: `make provider`
6. Build SDKs when schema changes: `make build_sdks`

## Investigation and Testing

- Start provider issue investigation with `triage-provider-issue`; invoke a narrower helper directly only when that route is already established.
- Use `docs/provider-runtime.md` to distinguish engine, bridge, upstream provider, and Pulumi AWS-owned behavior before choosing an editing point.
- Before adding or changing tests, read `TESTING.md` and use the lowest-cost test that directly proves the behavior.
- Before deciding, creating, or materially changing a carried patch, read `docs/upstream-patches.md` for the policy and Pulumi AWS-specific requirements, then use `upstream-patches` for patch mechanics.
- Use `pulumi-upgrade-provider` for provider upgrades.

## Rules

- **Never work directly in `sdk/` folders** - All SDK generation is automated through `make`
- **Never edit the generated `Makefile` or ci-mgmt-marked workflows directly** - Change `.ci-mgmt.yaml` and run `make ci-mgmt`
- **Never cancel running builds** - Builds may take several minutes
- **Do not run unfiltered `make test` by default** - The `examples/` package mixes local, recorded, and live AWS tests; inspect and run the focused test described in `TESTING.md`
- **Set timeouts to 300+ seconds** for build operations

## CI Notes

- The GitHub Action checks out the PR head automatically when the event is tied to a PR.
- Use `rg` for search. Avoid `cd ... &&` in bash; prefer `git -C`, `make -C`, or direct paths.
- Avoid Python scripts in CI; use `rg`, `grep`, `sed`, and `awk` instead.
- Good (CI-safe):
  - `rg "pattern" upstream/`
  - `git -C upstream log -1`
  - `make -C provider build`
- Bad (will often be blocked in CI):
  - `cd upstream && rg "pattern"`
  - `cd provider && go test ./...`
  - `python3 - <<'EOF' ... EOF`
