# Carrying Upstream Patches in Pulumi AWS

Use the `upstream-patches` skill before deciding, creating, or materially changing a carried patch. Its carried-patch policy defines the shared ownership, compatibility, state, evidence, tracking, and removal requirements for bridged providers. The skill also owns `./scripts/upstream.sh` patch mechanics.

This document adds Pulumi AWS-specific repository and test requirements.

## Track the patch

Create the tracking issue with [the upstream patch issue form](../.github/ISSUE_TEMPLATE/upstream-patch.yaml). Apply:

- `area/patch`; and
- the applicable owner label: `awaiting-upstream`, `awaiting/bridge`, `awaiting/core`, or `awaiting/codegen`.

Use the carried-patch section of [the pull request template](../.github/pull_request_template.md) to link the tracking issue and owning-project change, record compatibility and removal decisions, and name the required tests.

## Add regression coverage

Every upstream-owned patch that changes resource behavior requires all of the following in Pulumi AWS:

1. Include an upstream acceptance test in the patch that reproduces the affected lifecycle or AWS API behavior.
2. Select that exact test in `.github/workflows/aws-upstream-tests.yml`. A passing service job does not prove a new test ran unless its test expression includes the test.
3. Add a Pulumi regression test under `examples/` that fails without the patch and passes with it.

Put Pulumi regression tests required for Pulumi-specific patches under `examples/` as well. Add a provider-upgrade test when the shared policy requires coverage of schema, diff, identifier, or state compatibility.

Assert the affected field or lifecycle transition directly. A successful deployment alone may not prove the regression.

## Handle live AWS tests safely

Upstream acceptance and Pulumi examples tests may create real AWS resources. Before running one:

- inspect the fixture and cleanup path;
- assess cost, concurrency, permissions, and blast radius;
- account for asynchronous cleanup and recovery after interruption;
- follow `upstream/AGENTS.md` for upstream acceptance tests;
- report tests blocked by credentials or unsafe fixtures rather than implying they executed.

## Develop and report the patch

Develop upstream-owned changes in `upstream/` and use the `upstream-patches` skill to generate or amend the patch; do not edit `patches/*.patch` directly for ordinary development.

Submit the owner-side change in parallel when the behavior belongs upstream. In the Pulumi AWS pull request, report exact test commands and outcomes, including tests that were defined but not selected, skipped, or blocked by credentials.
