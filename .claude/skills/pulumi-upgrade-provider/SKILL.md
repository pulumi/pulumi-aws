---
name: pulumi-upgrade-provider
description: Automate Pulumi provider repo upgrades with the `upgrade-provider` tool. Use when upgrading a pulumi provider repository to a new upstream version, running `upgrade-provider`, and addressing its common failure modes like patch conflicts or missing module mappings.
---

# Pulumi Upgrade Provider

## Prerequisites

First, install the `upgrade-provider` tool:

```bash
go install github.com/pulumi/upgrade-provider@latest
```

After installation, the tool will be in your PATH and you can run it directly as `upgrade-provider`.

**IMPORTANT:**
- Do NOT try to modify PATH or use absolute paths to run the tool
- Do NOT try to find where the tool was installed
- Just run `upgrade-provider` directly after installing - if it's not found (exit code 127), report this as an environment configuration issue and stop

## CRITICAL: Session Completion Requirements

**DO NOT end this session until one of these conditions is met:**

1. **Success**: The `upgrade-provider` command completes successfully AND you have retrieved the PR URL
2. **Explicit failure**: You have hit a stopping condition listed in "When to Stop and Report Failure" below

**You MUST NOT end the session if:**
- A command is still running or you haven't checked its output
- You encountered an error but haven't attempted to fix it
- You haven't yet run `upgrade-provider` at least once
- The upgrade-provider command failed but you haven't exhausted the error-fixing loop

**Long-running commands**: The `upgrade-provider` command can take up to 10 minutes. You MUST wait for it to complete. Use `timeout: 600000` when running it via Bash.

## Overview

Drive Pulumi provider upgrades by running the `upgrade-provider` tool and iterating on failures until the tool succeeds. Keep all git operations read-only in the repo; the tool owns branches, commits, and PRs.

## Error Tracking

Track errors across iterations to avoid infinite loops:
- Maintain a mental list of errors encountered and fixes attempted
- An error is "the same" if it has the same error message and affects the same file/resource
- After 3 failed attempts at the same error, stop and report failure

## Run Loop

1. Create the output directory first:

```bash
mkdir -p .pulumi
```

2. Run the upgrade tool from the repo root with a 10-minute timeout:

```bash
upgrade-provider pulumi/pulumi-digitalocean --repo-path . > .pulumi/upgrade-provider-stdout.txt 2> /dev/null
```

Use `timeout: 600000` (10 minutes) when invoking via Bash.

**If exit code is 127 (command not found):** This is an environment configuration issue. Report failure immediately - do NOT try to install the tool or find it manually.

3. **Wait for the command to fully complete** (can take up to 10 minutes). Do not proceed or end the session until you see the final output.

4. Read the output file to check for errors:

```bash
cat .pulumi/upgrade-provider-stdout.txt
```

5. Scan the output for lines starting with `error: `.
6. If failed:
   - Compare the error to previous attempts
   - If you've seen the **same error 3 times**, stop and report failure (see "When to Stop")
   - If this is a new/different error, fix it using `references/upgrade-provider-errors.md`
   - Rerun the command (go back to step 2)
7. If a conflict was fixed, report exactly what changed (file paths + concrete edits or kept intent).
8. If the upgrade required changes to patches, run `./scripts/upstream.sh checkout` and review the applied commits:
   - List commit SHAs/titles from `upstream`.
   - Summarize the intent of each commit in plain language.
   - Call out any behavioral changes or risks.
9. When the tool completes successfully, proceed to Post-run Tasks.

## When to Stop and Report Failure

Stop iterating and exit with failure if any of these conditions are met:

1. **Command not found (exit code 127)**: The `upgrade-provider` tool is not in PATH. This is an environment configuration issue - do NOT try to install the tool yourself
2. **Same error 3 times**: You've attempted to fix the same error 3 times without success
3. **Unknown error pattern**: The error is not covered in `references/upgrade-provider-errors.md` and you cannot determine a safe fix
4. **Requires human judgment**: The fix requires decisions that need human input, such as:
   - Choosing between multiple valid approaches
   - Breaking changes that affect public API
   - Deprecation strategies
   - Architectural decisions about module organization
5. **Circular issues**: Fix A causes error B, fix B causes error A
6. **Complexity escalation**: Each fix attempt reveals more issues, suggesting deeper problems

When stopping, you MUST report:
1. The error(s) encountered
2. What fixes were attempted (with file paths and changes)
3. Why you believe human intervention is needed
4. Any partial progress that was made

## Post-run Tasks

The tool creates a PR when the upgrade completes successfully.

1. MUST fetch the PR URL for the current branch using read-only commands:

```console
gh pr view --json url --jq .url || gh pr list --head "$(git branch --show-current)" --json url --jq '.[0].url'
```

2. MUST append a "Fixes applied to unblock upgrade" section to the existing PR body if any fixes were applied (do not overwrite):

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

Use REST (`gh api`) instead of `gh pr edit` to avoid GraphQL project-card errors. Keep the original content intact; only append the new section.

## Notes

- `git rebase --continue --no-edit` is not supported in older git versions. Use `git rebase --continue` and accept the existing commit message when prompted.
- To avoid the editor prompt during `git rebase --continue`, run it with `GIT_EDITOR=true` (or `GIT_EDITOR=:`).

## Working Directory

**IMPORTANT: Always run commands from the repository root.** Do NOT use `cd` to change directories - it causes state confusion and is not allowed.

### Working with the `upstream` submodule

The `upstream/` directory is a git submodule containing the Terraform provider source. Use these patterns:

**Git commands** - use `-C upstream`:
```bash
# Check status
git -C upstream status

# View log
git -C upstream log --oneline -10

# Check current branch
git -C upstream branch --show-current

# Continue a rebase (with auto-accept message)
GIT_EDITOR=: git -C upstream rebase --continue

# Stage files after resolving conflicts
git -C upstream add <file>
```

**Reading files** - use the Read tool with path from repo root:
```
Read upstream/docs/resources/droplet.md
Read upstream/go.mod
```

**Editing files** - use the Edit tool with path from repo root:
```
Edit upstream/docs/resources/droplet.md
```

**Listing files** - use full paths:
```bash
ls -la upstream/
ls -la upstream/vendor/github.com/digitalocean/godo/
```

**Scripts** - run from repo root:
```bash
./scripts/upstream.sh checkout
./scripts/upstream.sh rebase -o refs/tags/v2.75.0
./scripts/upstream.sh check_in
```

## Guardrails

- Never commit, push, or create branches manually; only run read-only git commands.
- `./scripts/upstream.sh checkout|rebase|check_in` are allowed because the tool manages git state.
- Do not stash changes; the tool manages git state.
- **Do not use `cd`** - always work from the repository root.

## References

- Use this skill's `references/upgrade-provider-errors.md` for patch conflict and new module mapping fixes.

## Final Reminder

Before ending this session, verify:
- [ ] You ran `upgrade-provider` and waited for it to complete
- [ ] If it failed, you attempted fixes per the error reference guide
- [ ] If it succeeded, you retrieved and reported the PR URL
- [ ] If stopping due to failure, you documented the error, attempted fixes, and why human intervention is needed

**Do not end the session without completing one of the outcomes above.**
