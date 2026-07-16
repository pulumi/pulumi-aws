---
name: pulumi-upgrade-provider
description: Automate Pulumi provider repo upgrades with the `upgrade-provider` tool. Use when upgrading a pulumi provider repository to a new upstream version, running `upgrade-provider`, and addressing its common failure modes like patch conflicts or missing module mappings.
---

# Pulumi Upgrade Provider

## Overview

Run `upgrade-provider --no-submit`, fix known failures, and rerun until success. During the run loop, the tool owns branch and generated-commit state but does not push or mutate GitHub. After success, review and correct the local result before submitting it using the plan printed by the tool.

## Preflight

1. Record existing changes as the pre-upgrade baseline:

```bash
baseline_file="${TMPDIR:-/tmp}/upgrade-provider-$(basename "$PWD")-baseline.txt"
git status --short --untracked-files=all | tee "$baseline_file"
```

Existing changes do not block the upgrade, but the tool stages broadly and may include them in generated commits. If practical, isolate clearly unrelated work in another branch or worktree, move local-only files, or add untracked local artifacts to `.git/info/exclude`. Otherwise proceed and carry this baseline into the final review. Do not add a repository `.gitignore` rule unless the path should be ignored for all contributors.

2. Keep the run log outside the repository so the tool cannot stage it.

## Run Loop

1. Run from repo root:

```bash
log_file="${TMPDIR:-/tmp}/upgrade-provider-$(basename "$PWD").log"
upgrade-provider $ORG/$REPO --repo-path . --no-submit > "$log_file" 2> /dev/null
```

Preserve `--no-submit` on every retry.

2. Wait for completion (can take up to 10 minutes).
3. Check for errors by scanning the log for lines starting with `error: `:

```bash
if command -v rg >/dev/null 2>&1; then
  rg -n '^error: ' "$log_file" || true
else
  grep -n '^error: ' "$log_file" || true
fi
```

4. On a successful exit, first check whether the tool found that no upgrade was required:

```bash
if grep -Fq 'No actions needed' "$log_file"; then
  echo 'No actions needed'
fi
```

If present, report that the provider is already current or the requested target is not an upgrade, then stop successfully. There is no local upgrade to review or submit.

5. Otherwise, extract and read the complete local-completion report from the captured stdout:

```bash
awk '/^Upgrade completed locally;/{found=1} found' "$log_file"
```

This includes the proposed PR body and metadata, review commands, and every skipped submission action.

6. If failed, fix using this skill's `references/upgrade-provider-errors.md` (from the skill folder, not the repo), then rerun with `--no-submit`. If upstream migrated from Terraform Plugin SDKv2 to Plugin Framework, use the migration-guide routing in that reference instead of treating the framework change alone as an architectural blocker. For upstream `go get` failures involving ignored `replace` directives or `unknown revision v0.0.0`, rerun with `--target-version` after applying the documented `provider/go.mod` replacements; preserve the original major/non-major intent and add `--major` only for actual major version upgrades.
7. If a fix requires creating/amending/removing/rebasing patches, use the `upstream-patches` skill for the patch workflow. Interrupted patch workflows must be checked in before rerunning.
8. If you fixed a conflict, report exact edits (file paths + concrete changes or preserved intent).
9. Repeat until the tool prints `No actions needed` or the local-completion report and proposed PR plan. This run must not push or mutate GitHub; a branch or PR from an earlier run may already exist.

## When to Stop and Report Failure

Stop iterating and report failure if any of these conditions are met:

1. **Command not found (exit code 127)**: The `upgrade-provider` tool is not in PATH.
2. **Same error 3 times**: You've attempted to fix the same error 3 times without success.
3. **Unknown error pattern**: The error is not covered in `references/upgrade-provider-errors.md` and you cannot determine a safe fix.
4. **Ambiguous patch state**: You cannot prove that every patch was applied and the target rebase completed.
5. **Requires human judgment**: The fix needs user input, such as choosing between multiple valid implementation approaches or making an architectural decision about module organization. Upstream breaking changes, deprecations, or framework migrations do not by themselves require stopping; stop only when implementing the upgrade presents an unresolved choice.

When stopping, report:
1. The error(s) encountered.
2. What fixes were attempted (with file paths and changes).
3. Why human intervention is needed.
4. Any partial progress.

## Review the Local Upgrade

Use the tool's final report as the source of truth for the base branch, working branch, proposed PR title/body/metadata, and skipped submission actions.

1. Review a bounded summary first:

```bash
default_branch=$(gh repo view --json defaultBranchRef --jq .defaultBranchRef.name)
base_ref="origin/$default_branch"
git status --short --untracked-files=all
git log --oneline "$base_ref"..HEAD
git diff --shortstat "$base_ref"...HEAD
git diff --name-only "$base_ref"...HEAD | awk -F/ '{print $1}' | sort | uniq -c
```

Provider upgrades can change thousands of generated SDK files. Do not print the full branch diff by default. Use path-limited `git diff "$base_ref"...HEAD -- <paths>` commands to inspect source, configuration, patch, schema, and unexpected directories. For generated SDKs, inspect summaries or targeted files unless a full diff is necessary.

Cross-check the final branch against the pre-upgrade baseline:

```bash
baseline_file="${TMPDIR:-/tmp}/upgrade-provider-$(basename "$PWD")-baseline.txt"
[ ! -f "$baseline_file" ] || cat "$baseline_file"
```

For every pre-existing path included in the branch, decide whether it belongs in the upgrade PR. Keep intentional paths; move unrelated work to another branch/worktree or remove it from the unpublished upgrade history before pushing. A separate commit on the same branch isolates history but does not remove the path from the PR, and unstaging alone is insufficient after the tool has committed it. Revoke any exposed credential even if the history is rewritten.

2. MUST audit generated doc replacements for unresolved placeholders before publication:

```bash
if [ -f provider/replacements.json ]; then
  if command -v rg >/dev/null 2>&1; then
    rg -n '"new":.*TODO|TODO' provider/replacements.json || true
  else
    grep -En '"new":.*TODO|TODO' provider/replacements.json || true
  fi
fi
```

If any `TODO` is found in `provider/replacements.json`:
- Treat it as a pre-submission blocker; replacement values render into generated docs.
- Inspect each `old`/`new` pair and replace `TODO` with concrete Pulumi-facing wording, usually `Pulumi`, `this provider`, or `the provider`.
- Run focused validation if the repo has the test:

```bash
cd provider && go test -v -run TestReplacementDoesNotIncludeTodos .
```

3. If the upgrade changed patches, review the applied commits and then exit checkout mode:

```bash
./scripts/upstream.sh checkout
git -C upstream log --oneline pulumi/checkout-base..pulumi/patch-checkout
# Inspect relevant commits with git -C upstream show <sha>.
./scripts/upstream.sh check_in
```

List commit SHAs/titles, summarize each intent, and call out behavioral changes or risks. `check_in` is mandatory after review; leaving `upstream` on `pulumi/patch-checkout` blocks the next safe tool run.

4. Run focused validation for every manual fix and add focused follow-up commits.
5. Require a clean working tree before submission.

## Submit the Reviewed Upgrade

The local-completion report lists the proposed PR metadata and every skipped action. MUST reproduce all applicable actions, not only PR creation:

1. Preserve the proposed title, body, release label, reviewers, and assignee. Never decide, infer, or change the release label: provider upgrades follow the upstream version transition, so the label represents that version delta rather than the agent's assessment of whether individual changes are breaking. For example, upstream `v0.9.0` to `v0.10.0` remains a minor upgrade even when it contains breaking behavioral changes. Use exactly the label emitted by `upgrade-provider`, report any concern to reviewers without changing the metadata, and never add `--major` unless the upstream target crosses the current upstream major version.
2. If fixes unblocked the upgrade, append this section to the proposed body before submission when practical:

```markdown
---

### Fixes applied to unblock upgrade

- <list concrete unblocker edits here, with file paths and intent>
```

3. Push only after review. The tool reports an unconditional force-push; manual submission intentionally uses the safer lease-protected equivalent unless the user explicitly approves overwriting newer remote work:

```bash
branch=$(git branch --show-current)
git push --set-upstream origin "$branch" --force-with-lease
```

4. Use `gh` to create or update the PR as described by the report.
5. Assign listed upgrade issues to the PR assignee when requested.
6. For bridge upgrades, close listed superseded bridge PRs and comment with the replacement PR URL.
7. Fetch and report the final PR URL:

```bash
gh pr view --json url --jq .url || gh pr list --head "$(git branch --show-current)" --json url --jq '.[0].url'
```

If the fixes section was not included before submission, append it without replacing the existing body:

```bash
repo=$(gh repo view --json nameWithOwner --jq .nameWithOwner)
pr_number=$(gh pr view --json number --jq .number)
gh pr view --json body --jq .body > /tmp/pr_body.txt

cat <<'EOF' >> /tmp/pr_body.txt

---

### Fixes applied to unblock upgrade

- <list concrete unblocker edits here, with file paths and intent>
EOF

gh api -X PATCH "repos/$repo/pulls/$pr_number" --raw-field body="$(cat /tmp/pr_body.txt)"
```

Use REST (`gh api`) instead of `gh pr edit` to avoid GraphQL project-card errors. Keep existing body content; only append.

## Notes

- `git rebase --continue --no-edit` is not supported in older git versions. Use `git rebase --continue` and accept the existing commit message.
- To avoid the editor prompt during `git rebase --continue`, run it with `GIT_EDITOR=true` (or `GIT_EDITOR=:`).

## Guardrails

- Never commit, push, or create branches manually during the upgrade-provider run loop.
- After `--no-submit` succeeds, focused correction commits and manual submission are permitted.
- Never use `./scripts/upstream.sh init -f` unless intentionally discarding interrupted patch work; it is destructive.
- Do not leave `upstream` in checkout or an active Git operation before submission.
- Do not stash changes; use a clean worktree or remove unrelated artifacts instead.

## References

- Use this skill's `references/upgrade-provider-errors.md` (from the skill folder, not the repo) for interrupted patch state, patch conflict, SDKv2-to-Plugin-Framework migration, ignored upstream replacement, vendored upstream dependency, .NET duplicate file, and new module mapping fixes.
