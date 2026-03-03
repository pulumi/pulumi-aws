# Pulumi AWS Provider

Use [AGENTS.md](../AGENTS.md) as the primary instruction contract.
If this file and `AGENTS.md` differ, follow `AGENTS.md`.

## Command quick reference
- `make upstream` to initialize upstream submodule
- `make lint` to lint provider Go code
- `make test_provider` to run provider tests
- `make provider` to build the provider binary
- `make schema` to regenerate schema artifacts
- `make build_sdks` to build SDKs

## Repository structure
- `provider/` for provider implementation
- `sdk/` for generated SDKs (never edit directly)
- `upstream/` for Terraform provider submodule
- `patches/` and `scripts/` for upstream and build utilities
- `.ci-mgmt.yaml` for generated CI workflow source

## Development workflow
1. Initialize repository: `make upstream`
2. Make changes in `provider/` or related source files
3. Lint: `make lint`
4. Test: `make test_provider`
5. Build provider and/or SDKs as needed

## If you change...
- Any `.go` file in `provider/`: run `make lint && make test_provider`.
- `provider/resources.go` or schema shaping logic: run `make schema && make provider && make build_sdks`.
- `provider/go.mod` or `provider/go.sum`: run `cd provider && go mod tidy`.
- Files in `patches/` or `upstream/`: run `./scripts/upstream.sh init -f` then `make schema && make test_provider`.
- `.ci-mgmt.yaml`: run `make ci-mgmt` and include generated workflow updates.

## Escalate immediately if
- Patch application fails during upstream init/rebase workflows.
- `make schema` or `make build_sdks` produces large unrelated diffs.
- Requirements are ambiguous or conflict with current behavior.
- You are unsure about `provider/resources.go` mapping choices.

## Rules
- Never edit `sdk/` outputs manually.
- Do not run destructive git operations without explicit approval.
- Do not run example integration tests unless explicitly requested.
