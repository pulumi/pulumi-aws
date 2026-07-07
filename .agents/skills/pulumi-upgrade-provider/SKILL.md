---
name: pulumi-upgrade-provider
description: Automate Pulumi provider repo upgrades with the `upgrade-provider` tool. Use when upgrading a pulumi provider repository to a new upstream version, running `upgrade-provider`, and addressing its common failure modes like patch conflicts or missing module mappings.
---

# Pulumi Upgrade Provider

## Overview

Run `upgrade-provider`, fix known failures, and rerun until success. Keep git operations read-only in the repo; the tool owns branch/commit/PR state.

## Run Loop

1. Create output directory:

```bash
mkdir -p .pulumi
```

2. Run from repo root:

```bash
upgrade-provider $ORG/$REPO --repo-path . > .pulumi/upgrade-provider-stdout.txt 2> /dev/null
```

3. Wait for completion (can take up to 10 minutes).
4. Check for errors by scanning `.pulumi/upgrade-provider-stdout.txt` lines starting with `error: `.
5. If failed, fix using this skill's `references/upgrade-provider-errors.md` (from the skill folder, not the repo), then rerun. For upstream `go get` failures involving ignored `replace` directives or `unknown revision v0.0.0`, rerun with `--target-version` after applying the documented `provider/go.mod` replacements; preserve the original major/non-major intent and add `--major` only for actual major version upgrades.
6. If a fix requires creating/amending/removing/rebasing patches, use the `upstream-patches` skill for the patch workflow.
7. If you fixed a conflict, report exact edits (file paths + concrete changes or preserved intent).
8. If the upgrade changed patches, run `./scripts/upstream.sh checkout` and review applied `upstream` commits:
   - List commit SHAs/titles from `upstream`.
   - Summarize the intent of each commit in plain language.
   - Call out any behavioral changes or risks.
9. On success, proceed to Post-run Tasks.

## When to Stop and Report Failure

Stop iterating and report failure if any of these conditions are met:

1. **Command not found (exit code 127)**: The `upgrade-provider` tool is not in PATH.
2. **Same error 3 times**: You've attempted to fix the same error 3 times without success.
3. **Unknown error pattern**: The error is not covered in `references/upgrade-provider-errors.md` and you cannot determine a safe fix.
4. **Requires human judgment**: The fix needs user input, such as:
   - Choosing between multiple valid approaches
   - Breaking changes that affect public API
   - Deprecation strategies
   - Architectural decisions about module organization

When stopping, report:
1. The error(s) encountered.
2. What fixes were attempted (with file paths and changes).
3. Why human intervention is needed.
4. Any partial progress.

## Post-run Tasks

The tool creates a PR on successful upgrade.

1. MUST fetch the PR URL for the current branch using read-only commands:

```console
gh pr view --json url --jq .url || gh pr list --head "$(git branch --show-current)" --json url --jq '.[0].url'
```

2. MUST audit generated doc replacements for unresolved placeholders:

```console
if [ -f provider/replacements.json ]; then
  rg -n '"new":.*TODO|TODO' provider/replacements.json || true
fi
```

If any `TODO` is found in `provider/replacements.json`:
- Treat it as a post-upgrade blocker; replacement values render into generated docs.
- Inspect each `old`/`new` pair and replace `TODO` with concrete Pulumi-facing wording, usually `Pulumi`, `this provider`, or `the provider`.
- Run focused validation if the repo has the test:

```console
cd provider && go test -v -run TestReplacementDoesNotIncludeTodos .
```

After the upgrade-provider tool has created the PR, fix these placeholders as normal follow-up work.

3. MUST append a "Fixes applied to unblock upgrade" section to the existing PR body if any fixes were applied (do not overwrite):

```console
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

- Never commit, push, or create branches manually during the upgrade-provider run loop; only run read-only git commands.
- After the tool creates a PR, follow-up commits are permitted for post-run fixes.
- `./scripts/upstream.sh checkout|rebase|check_in` are allowed because the tool manages git state.
- Do not stash changes; the tool manages git state.

## References

- Use this skill's `references/upgrade-provider-errors.md` (from the skill folder, not the repo) for patch conflict, ignored upstream replacement, vendored upstream dependency, .NET duplicate file, and new module mapping fixes.
