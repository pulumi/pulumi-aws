---
description: Run PR re-review on explicit maintainer slash command.
timeout-minutes: 15
strict: true
on:
  slash_command:
    name: review-again
    events: [pull_request_comment, pull_request_review_comment]
imports:
  - shared/review.md
  - shared/plugins/code-review/code-review.md
permissions:
  contents: read
  pull-requests: read
  id-token: write
source: pulumi-labs/gh-aw-internal/.github/workflows/gh-aw-pr-rereview.md@734ef41746387a6818fd8ac3e619c9fd81ac6957
---

# Internal PR Re-Review (Slash Command)
