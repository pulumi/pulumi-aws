---
on:
  pull_request:
    types:
    - opened
    - ready_for_review
  workflow_dispatch:
    inputs:
      pr_number:
        description: Pull request number to review
        required: true
        type: string
permissions:
  contents: read
  id-token: write
  pull-requests: read
imports:
- shared/review.md
- shared/plugins/code-review/code-review.md
description: Automated PR review for trusted internal contributors.
source: pulumi-labs/gh-aw-internal/.github/workflows/gh-aw-pr-review.md@9a981e07d7134a447fac35073f0857f8512f16c4
strict: true
timeout-minutes: 15
---
# Internal Trusted PR Reviewer
