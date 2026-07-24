# Carrying Upstream Patches

Use this policy before creating a new patch or materially changing the behavior or public commitment of an existing patch. Repository guidance supplies local commands, test paths, workflows, labels, and templates.

## Avoid patches by default

A carried patch adds recurring cost and risk to every upstream upgrade:

- changes to the same upstream files can require a manual rebase;
- a bad conflict resolution can introduce behavior that neither Pulumi nor upstream tested;
- a patched property, resource, or behavior can become a public contract that Pulumi must maintain indefinitely;
- upstream may later solve the same problem with an incompatible API or state representation;
- cross-cutting patches can be difficult to test completely and difficult to remove safely.

Prefer waiting for an acceptable upstream release, using bridge or provider configuration, or offering a documented workaround when those choices meet the user need. Severity may justify carrying a patch proactively, but urgency does not remove the compatibility and evidence requirements below.

## Identify the owner

Classify the behavior before designing the patch.

### Upstream-owned behavior

When the change fixes behavior in the upstream Terraform provider:

- develop the correct solution in the upstream source, not directly in a generated patch file;
- submit the change upstream in parallel with the Pulumi patch;
- assess an existing upstream pull request rather than assuming it is safe to carry;
- create a higher-quality upstream change when the existing proposal is incomplete;
- carry the same change submitted upstream and explain any necessary differences.

Do not weaken the upstream solution merely to make the Pulumi patch easier to remove.

Every upstream-owned patch that changes resource behavior requires:

1. An upstream acceptance test in the patch that reproduces the affected lifecycle or API behavior. Unit tests may supplement this test but do not replace it.
2. Selection of that acceptance test in the Pulumi provider repository's targeted upstream-test CI.
3. A Pulumi regression test that fails without the patch and passes with it.

Assert the affected behavior directly. A successful deployment alone may not prove the regression.

### Pulumi-specific behavior

Some patches work around behavior owned by the bridge, a Pulumi provider, code generation, or the Pulumi engine. For these patches:

- link the issue in the repository that owns the underlying problem;
- explain why the change must be made in upstream provider code rather than bridge configuration or local provider code;
- limit the patch to the incompatibility between Terraform and Pulumi behavior;
- add a Pulumi regression test that fails without the patch;
- add provider-upgrade coverage when the patch changes schema, diff, or state behavior consumed by existing Pulumi state;
- state whether the divergence is temporary or intentionally permanent.

Do not submit an upstream pull request for behavior that would be incorrect or irrelevant in Terraform.

### Repository integration

Some patches support Pulumi-specific integration such as a shim, provider identity, documentation generation, or repository build tooling.

Prefer local provider configuration, documentation changes, or build orchestration when those can express the change. If upstream code is the only practical extension point, explain why in the tracking issue.

Use validation specific to the integration. Do not add upstream acceptance or Pulumi lifecycle tests that cannot exercise the change.

## Assess compatibility and maintenance risk

Record known risks and unknowns in the tracking issue and patch pull request.

### Public API changes

If users adopt a property or resource added by a patch, Pulumi may have to support it even if upstream later chooses another name or design. Compare an upstream-owned patched API with the upstream submission. For Pulumi-specific behavior, state whether the divergence is an intentional permanent contract.

Prefer patches that can be removed without changing Pulumi programs or state. Treat a patch that creates permanent surface area as an exceptional compatibility commitment, not a temporary backport.

### State migrations

Terraform records a schema version with resource state and selects state upgraders using that version. The bridge also records the Terraform schema version in Pulumi state.

A migration that appears correct in Terraform may not be persisted by Pulumi. During a no-refresh `pulumi up`, the bridge can run the upgrader while computing the diff. If there is no diff, Pulumi does not call `Update`, so the upgraded state may not be written. A later deletion can therefore receive the old state. This behavior is tracked in [pulumi-terraform-bridge#3008](https://github.com/pulumi/pulumi-terraform-bridge/issues/3008).

A downstream migration can also collide with upstream. If a patch adds a `0 → 1` migration, patched state may be marked version `1`. If upstream later releases a different `0 → 1` migration, that upgrader is not called for state already marked version `1`.

Before carrying a state migration:

- confirm that migration is required instead of making provider operations compatible with state written by released versions;
- compare the schema version and migration with the upstream pull request when the behavior is upstream-owned;
- explain how each expected replacement for the patch will consume state written by it;
- add a Pulumi provider-upgrade test that creates state with a released provider and covers no-refresh update, refresh, and direct deletion;
- preserve identifiers needed by later operations unless live lifecycle evidence proves a migration is necessary.

### Cross-cutting changes

If a patch changes shared code or multiple resources, name the affected resources and their test coverage. List behavior that remains untested. Do not infer broad safety from one representative resource without explaining why that resource exercises the shared behavior.

## Track the patch lifecycle

Every patch requires a provider-repository tracking issue containing:

- why the patch is needed and which repository owns the underlying behavior;
- links to the user-facing issue and owning upstream, bridge, codegen, or Pulumi issue;
- the upstream pull request when the behavior is upstream-owned;
- compatibility risks and unknowns;
- exact regression test names and CI selection;
- whether the patch is temporary or intentionally permanent;
- observable removal conditions and the tests required to prove removal is safe.

“Remove when fixed upstream” is not a sufficient removal condition. The issue must explain how to establish that the upstream replacement is compatible with Pulumi programs and state written while the patch was present.

The patch pull request must link the tracking issue and relevant owner-side change, explain differences, and report exact test outcomes. Keep defined, selected, executed, asserted, skipped, and credential-blocked evidence distinct.

## Stop conditions

Stop and ask for maintainer judgment rather than silently proceeding when:

- the patch introduces or renames public schema without a clear long-term compatibility decision;
- the proposed patch differs materially from an unreviewed or incomplete upstream pull request;
- a cross-cutting change lacks credible regression coverage;
- required live infrastructure cannot be exercised safely;
- ownership or safe removal conditions remain unclear.

## Pulumi AWS repository requirements

The policy above applies together with these Pulumi AWS-specific repository and test requirements.

### Track the patch

Create the tracking issue with [the upstream patch issue form](../.github/ISSUE_TEMPLATE/upstream-patch.yaml). Apply:

- `area/patch`; and
- the applicable owner label: `awaiting-upstream`, `awaiting/bridge`, `awaiting/core`, or `awaiting/codegen`.

Use the carried-patch section of [the pull request template](../.github/pull_request_template.md) to link the tracking issue and owning-project change, record compatibility and removal decisions, and name the required tests.

### Add regression coverage

Every upstream-owned patch that changes resource behavior requires all of the following in Pulumi AWS:

1. Include an upstream acceptance test in the patch that reproduces the affected lifecycle or AWS API behavior.
2. Select that exact test in `.github/workflows/aws-upstream-tests.yml`. A passing service job does not prove a new test ran unless its test expression includes the test.
3. Add a Pulumi regression test under `examples/` that fails without the patch and passes with it.

Put Pulumi regression tests required for Pulumi-specific patches under `examples/` as well. Use [`TESTING.md`](../TESTING.md) to design the focused Pulumi regression and decide whether provider-upgrade or language-specific coverage is also needed. Add a provider-upgrade test when the policy requires coverage of schema, diff, identifier, or state compatibility.

Assert the affected field or lifecycle transition directly. A successful deployment alone may not prove the regression.

### Handle live AWS tests safely

Upstream acceptance and Pulumi examples tests may create real AWS resources. Before running one:

- inspect the fixture and cleanup path;
- assess cost, concurrency, permissions, and blast radius;
- account for asynchronous cleanup and recovery after interruption;
- follow `upstream/AGENTS.md` for upstream acceptance tests;
- report tests blocked by credentials or unsafe fixtures rather than implying they executed.

### Develop and report the patch

Develop upstream-owned changes in `upstream/` and use the `upstream-patches` skill to generate or amend the patch; do not edit `patches/*.patch` directly for ordinary development.

Submit the owner-side change in parallel when the behavior belongs upstream. In the Pulumi AWS pull request, report exact test commands and outcomes, including tests that were defined but not selected, skipped, or blocked by credentials.
