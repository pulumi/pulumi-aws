---
description: Automated PR review for trusted internal contributors.
timeout-minutes: 15
strict: true
permissions:
  contents: read
  pull-requests: read
  id-token: write
on:
  pull_request:
    types: [opened]
  workflow_dispatch:
    inputs:
      pr_number:
        description: "Pull request number to review"
        required: true
        type: string
imports:
  - shared/review.md
  - shared/plugins/code-review/code-review.md
source: pulumi-labs/gh-aw-internal/.github/workflows/gh-aw-pr-review.md@734ef41746387a6818fd8ac3e619c9fd81ac6957
---

# Internal Trusted PR Reviewer
