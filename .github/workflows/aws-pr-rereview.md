---
on:
  slash_command:
    events:
    - pull_request_comment
    - pull_request_review_comment
    name: review-again
permissions:
  contents: read
  id-token: write
  pull-requests: read
imports:
- shared/review.md
- shared/plugins/code-review/code-review.md
description: Run PR re-review on explicit maintainer slash command.
source: pulumi-labs/gh-aw-internal/.github/workflows/gh-aw-pr-rereview.md@9a981e07d7134a447fac35073f0857f8512f16c4
strict: true
timeout-minutes: 15
---
# Internal PR Re-Review (Slash Command)
