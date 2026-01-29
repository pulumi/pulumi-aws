---
name: provider-code-review
description: Code review guidelines for Pulumi provider repositories - reviewing patches, resources.go changes, SDK changes, and CI workflows
disable-model-invocation: true
---

# Code Review Guidelines

When reviewing pull requests in this repository, follow these guidelines based on the types of files changed.

## Review Rules by File Type

### Patches (`patches/*.patch`)

Changes to patch files require special handling to review effectively.

See [patches.md](./patches.md) for detailed instructions.

### Provider Resources (`provider/resources.go`)

The resources.go file defines resource mappings between Terraform and Pulumi.

### Generated SDK Files (`sdk/**`)

These are generated SDK files and SHOULD NOT be reviewed. When reviewing the diff these files
should be excluded since they will add a lot of noise to the review.
