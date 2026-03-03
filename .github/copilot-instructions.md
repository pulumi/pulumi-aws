# Pulumi AWS Provider Copilot Instructions

Use `AGENTS.md` in the repository root as the source of truth.
If this file and `AGENTS.md` conflict, follow `AGENTS.md`.

## Working effectively
- Use `make` targets for build, lint, test, and generation tasks.
- Do not edit `sdk/` files directly; they are generated artifacts.
- Keep provider behavior changes in `provider/`.

## Canonical commands
- `make upstream`
- `make lint`
- `make test_provider`
- `make provider`
- `make schema`
- `make build_sdks`

## If you change...
- Any `.go` file in `provider/`: run `make lint && make test_provider`.
- `provider/resources.go` or schema shaping logic: run `make schema && make provider && make build_sdks`.
- `provider/go.mod` or `provider/go.sum`: run `cd provider && go mod tidy`.
- Files in `patches/` or `upstream/`: run `./scripts/upstream.sh init -f` then `make schema && make test_provider`.
- `.ci-mgmt.yaml`: run `make ci-mgmt` and include generated workflow updates.

## Escalate immediately if
- Patch application fails in upstream workflows.
- Regeneration commands produce large unrelated diffs.
- Requirements are ambiguous or conflict with existing behavior.
- You are unsure how to map provider resources in `provider/resources.go`.
