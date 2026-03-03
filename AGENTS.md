# Agent Instructions

## What this repo is
This repository builds the Pulumi AWS provider (`pulumi-resource-aws`) by bridging Terraform AWS provider code (`upstream/`) into Pulumi schema and generated SDKs (`sdk/`).

## Start here
- `Makefile` for canonical commands
- `provider/` for hand-written provider logic
- `provider/resources.go` for core resource and data source mappings
- `patches/` and `scripts/upstream.sh` for upstream patch management
- `.ci-mgmt.yaml` as source of truth for generated GitHub workflows
- `CONTRIBUTING.md` for contributor process details

## Command canon
- Prepare workspace: `make prepare_local_workspace`
- Lint provider code: `make lint`
- Fast targeted provider test: `cd provider && go test -run TestFast -short ./...`
- Provider tests: `make test_provider`
- Regenerate schema artifacts: `make schema`
- Build provider binary: `make provider`
- Build SDKs: `make build_sdks`

## Key invariants
- Do not edit files under `sdk/` manually; regenerate them.
- Keep behavior changes in `provider/`, not generated SDKs.
- Edit `.ci-mgmt.yaml` (not generated `.github/workflows/*.yml`) when changing CI design.

## If you change...
- Any `.go` file in `provider/`: run `make lint && make test_provider`.
- `provider/resources.go` or schema shaping logic: run `make schema && make provider && make build_sdks`.
- `provider/go.mod` or `provider/go.sum`: run `cd provider && go mod tidy` and commit both files.
- Files in `patches/` or `upstream/`: run `./scripts/upstream.sh init -f` and then `make schema && make test_provider`.
- `.ci-mgmt.yaml`: run `make ci-mgmt` and commit generated workflow updates.

## Forbidden actions
- Do not run destructive git commands (for example `git reset --hard`) unless explicitly requested.
- Do not claim tests pass without running them.
- Do not run `make test` unless AWS credentials and cloud cost impact are intended.

## Escalate immediately if
- `make schema` or `make build_sdks` creates large unrelated drift.
- `scripts/upstream.sh` workflow fails because of patch conflicts.
- Requirements are ambiguous or conflict with current behavior.
- You are unsure about a `provider/resources.go` mapping decision.
