# Pulumi AWS Provider Runtime

Pulumi AWS is a bridged provider. For most resources, this repository does not
implement the resource lifecycle: the Pulumi engine selects operations, the
Terraform bridge translates provider RPCs, and the Terraform AWS provider
implements resource behavior. This document identifies the narrower behavior
owned by `pulumi-aws` and where to change it.

## Upstream contracts

Use the Pulumi developer documentation for behavior owned by the engine:

- [Resource providers](https://pulumi-developer-docs.readthedocs.io/latest/docs/architecture/providers/README.html)
- [ResourceProvider gRPC protocol](https://pulumi-developer-docs.readthedocs.io/latest/docs/_generated/proto/provider.html)
- [Resource registration and diffing](https://pulumi-developer-docs.readthedocs.io/latest/docs/architecture/deployment-execution/resource-registration.html)
- [Deployment steps, including refresh and import](https://pulumi-developer-docs.readthedocs.io/latest/docs/architecture/deployment-execution/steps.html)

Use the Terraform Bridge developer documentation for Terraform-to-Pulumi
translation:

- [Bridge developer documentation](https://pulumi-developer-docs.readthedocs.io/projects/pulumi-terraform-bridge/en/latest/docs/README.html)
- [Resource IDs](https://pulumi-developer-docs.readthedocs.io/projects/pulumi-terraform-bridge/en/latest/docs/guides/resource-ids.html)
- [Provider metadata](https://pulumi-developer-docs.readthedocs.io/projects/pulumi-terraform-bridge/en/latest/docs/guides/metadata.html)
- [Automatic aliasing](https://pulumi-developer-docs.readthedocs.io/projects/pulumi-terraform-bridge/en/latest/docs/guides/auto-aliasing.html)
- [Automatic token mapping](https://pulumi-developer-docs.readthedocs.io/projects/pulumi-terraform-bridge/en/latest/docs/guides/automatic-token-mapping.html)
- [Muxing providers](https://pulumi-developer-docs.readthedocs.io/projects/pulumi-terraform-bridge/en/latest/docs/guides/muxwith.html)
- [Schema overlays](https://pulumi-developer-docs.readthedocs.io/projects/pulumi-terraform-bridge/en/latest/docs/guides/overlays.html)
- [Generated documentation edits](https://pulumi-developer-docs.readthedocs.io/projects/pulumi-terraform-bridge/en/latest/docs/guides/docs-edits.html)
- [Testing bridged providers](https://pulumi-developer-docs.readthedocs.io/projects/pulumi-terraform-bridge/en/latest/docs/guides/testing.html)

The Terraform AWS provider under [`upstream/`](../upstream/) owns its resource
schemas, CRUD and import implementations, state upgrades, retries, waiters, and
AWS API calls. AWS service APIs own remote behavior. A local patch changes the
upstream provider seen by Pulumi; follow
[`docs/upstream-patches.md`](./upstream-patches.md) before creating one.

## System boundary

```text
Pulumi program
    |
    v
Pulumi engine                     operation planning and state management
    |
    | ResourceProvider gRPC
    v
Pulumi Terraform Bridge           Terraform/Pulumi value and lifecycle translation
    |
    | ProviderInfo customizations from this repository
    v
Muxed Terraform AWS provider      SDKv2 and Plugin Framework resources
    |
    v
AWS service APIs
```

The same provider construction also feeds schema generation:

```text
Terraform AWS schemas + ProviderInfo + overlays
    |
    v
Pulumi package schema and bridge metadata
    |
    v
Generated SDKs and runtime provider
```

A `ProviderInfo` change may therefore affect schema generation, runtime
translation, or both. Determine which consumer reads the field before choosing
a test or regeneration command.

## Repository-owned control surfaces

| Control surface | Entry point | What changes here |
| --- | --- | --- |
| Upstream provider assembly | [`provider/upstream_provider.go`](../provider/upstream_provider.go), [`provider/pkg/iam/`](../provider/pkg/iam/), and [`provider/pkg/rds/`](../provider/pkg/rds/) | Adjustments applied to the SDKv2 or Plugin Framework provider before the bridge consumes it. This constructor runs during schema generation and runtime startup. |
| Bridge configuration | [`provider/resources.go`](../provider/resources.go) | Provider configuration, Terraform-to-Pulumi tokens, field overrides, autonaming, aliases, ID overrides, and input/output or state transforms. |
| Pulumi-side input handling | [`provider/region.go`](../provider/region.go), [`provider/tags.go`](../provider/tags.go), and the pre-configure callback in `provider/resources.go` | Behavior that must run before upstream Terraform logic, such as provider credential diagnostics or Pulumi-specific `Check` inputs. |
| Schema additions and post-processing | [`provider/overlays.go`](../provider/overlays.go), [`provider/types.go`](../provider/types.go), and [`provider/enums.go`](../provider/enums.go) | Pulumi-only resources and types, generated API shape, and schema transformations not supplied by upstream. |
| Generated documentation edits | [`provider/doc_edits.go`](../provider/doc_edits.go) and [`provider/replacements.json`](../provider/replacements.json) | Targeted changes to converted upstream documentation. |
| Runtime assembly and metadata | [`provider/cmd/pulumi-resource-aws/`](../provider/cmd/pulumi-resource-aws/), [`provider/cmd/pulumi-tfgen-aws/`](../provider/cmd/pulumi-tfgen-aws/), and [`provider/pkg/minimalschema/`](../provider/pkg/minimalschema/) | SDKv2/Plugin Framework mux startup, embedded schema, and generated bridge/runtime metadata. Generated JSON files are outputs, not editing points. |
| Carried upstream behavior | [`patches/`](../patches/) | Temporary or intentional divergence from the released Terraform AWS provider. Develop the source change in `upstream/`, then generate the patch. |

## Route a change

- When the engine chooses an unexpected operation or orders operations
  unexpectedly, start with the engine deployment and provider-protocol docs.
- When Terraform and Pulumi differ without a `pulumi-aws` override, investigate
  the bridge translation before adding local behavior.
- When CRUD, import, state upgrade, retry, waiter, or AWS API behavior comes from
  a Terraform resource, the owning implementation is under `upstream/`.
- When the behavior comes from a token, field override, alias, transform,
  provider callback, overlay, or documentation edit, change the corresponding
  local control surface above.
- When generated schema, metadata, or SDKs are wrong, trace them back to
  `ProviderInfo`, an overlay, or upstream schema rather than editing generated
  output.

Use [`TESTING.md`](../TESTING.md) to select the lowest repository test layer
that proves a local change. Use the issue-triage skills referenced by
[`AGENTS.md`](../AGENTS.md) when the owning layer is not yet established.
