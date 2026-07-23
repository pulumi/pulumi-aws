# `examples/*` Test Harness Migration Decision Context

## Motivation and Desired Outcome

Migrate all `examples/*` tests from `github.com/pulumi/pulumi/pkg/v3/testing/integration` to the newer `github.com/pulumi/providertest/pulumitest` harness. The outcome is no remaining use of the integration test harness under `examples/`, while preserving meaningful lifecycle and regression coverage and keeping each review easy to compare with the behavior it replaces.

## Relevant Evidence

- There are 21 active `integration.ProgramTest` call sites across Node.js, Python, Go, .NET, and YAML tests.
- Six files import the integration package.
- `ProgramTest` implicitly runs preview, update, export/import, no-op checks, validation, refresh, edits, and cleanup. `pulumitest` exposes these operations as primitives rather than as one equivalent entry point.
- Python needs special handling because `opttest.PythonLink` installs into the ambient interpreter rather than the virtual environment declared by these examples.
- Two Node.js tests use `RunUpdateTest` to deploy with the package-declared SDK, link the local SDK, and repeat the lifecycle against the same stack.
- Removing integration imports will not remove `github.com/pulumi/pulumi/pkg/v3` from `examples/go.mod`; `minimal_schema_test.go` still uses its codegen packages.

## Decisions and Rationale

- Preserve existing lifecycle coverage during the initial migration rather than silently simplifying tests.
- Eliminate integration-package usage, not the entire `pulumi/pkg/v3` module dependency.
- Use `pulumitest`'s isolated local file backend. The migrated examples do not need to preserve the old harness's potential use of the Pulumi Service in credentialed CI.
- Upgrade `examples` to `providertest` v0.7, matching `provider/go.mod` and gaining the newer error-returning operations and cleanup behavior.
- Use one PR with focused commits so each migration pattern can be reviewed independently.
- Keep unusual lifecycle cases explicit instead of recreating the full `ProgramTestOptions` API.
- Avoid unrelated renames, fixture edits, assertion changes, formatting churn, or parallelization during the migration.

## Review Structure

Use one PR with independently reviewable commits:

1. **Foundation and simple smoke tests**
   - Upgrade `providertest`.
   - Add a narrow lifecycle helper.
   - Migrate representative straightforward Go, .NET, and Node.js tests.
2. **Node.js tests**
   - Migrate ordinary cases and explicitly handle custom environments, preview-only behavior, permitted no-op changes, and two-pass SDK-update coverage.
3. **Python tests**
   - Generalize the existing virtualenv setup and install the local Python SDK into the declared environment.
4. **YAML edits and final cleanup**
   - Preserve additive edit and per-step validation behavior, then remove the remaining integration imports and integration-only helpers.

Keep each migration pattern in a focused commit so reviewers can compare preview, update, round-trip, no-op, refresh, edit, and validation behavior with the lifecycle it replaces.

## Tradeoffs, Limitations, and Non-Goals

- A narrow shared helper is useful, but rebuilding all of `ProgramTestOptions` would create another legacy harness and obscure special behavior.
- Credentialed example tests continue to run in CI rather than locally.
- The migration does not alter generated SDKs or example program fixtures.
- The migration is not an opportunity for broad test cleanup; follow-up simplification can happen after parity is established.

## Current Status

Implementation and local review are complete. The migration is organized as focused commits on a single branch for one pull request.
