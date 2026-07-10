---
name: upstream-patches
description: Create, amend, remove, and rebase patches for Terraform provider submodules using `./scripts/upstream.sh`. Use when `upgrade-provider` or manual patch work needs owning-patch lookup, patch conflict fixes, patch/hunk removal, or upstream rebase.
---

# Upstream Patches

`upstream/` is a git submodule pointing to the upstream Terraform provider. `patches/` contains patch files applied on top of it. Use `./scripts/upstream.sh` to manage patch state.

## Default Behavior

- If fixing a regression introduced by an existing patch, amend the owning patch commit.
- Do not create a new patch unless the user explicitly asks.

## Commands Reference

| Command | Description |
|---------|-------------|
| `./scripts/upstream.sh init` | Initialize upstream and apply patches to working directory |
| `./scripts/upstream.sh init -f` | Force re-initialize, discarding any changes |
| `./scripts/upstream.sh checkout` | Create branch with patches as commits for editing |
| `./scripts/upstream.sh rebase -i` | Interactively edit patch commits |
| `./scripts/upstream.sh rebase -o <commit>` | Rebase patches onto a new upstream commit |
| `./scripts/upstream.sh check_in` | Write commits back to patches and exit checkout mode |

## Guardrails

- Never commit directly to `upstream/` without `checkout/check_in`.
- Direct edits under `upstream/` outside checkout are ephemeral during `upgrade-provider`; the tool resets submodule state.
- Do not hand-edit `patches/*.patch` unless intentionally doing raw patch surgery.
- Prefer non-interactive rewrite flow over interactive rebase for agents.

## Find Owning Patch First

Before editing patch content, identify the owning patch/commit.

```bash
./scripts/upstream.sh checkout

# Find candidate patch files by touched file path or unique hunk text
rg -n "path/to/file|unique_symbol" patches/*.patch

# Optional: inspect candidate patch header/hunks
sed -n '1,120p' patches/00NN-Example.patch

# Map patch file to commit in upstream checkout branch
patch=patches/00NN-Example.patch
subject=$(sed -n 's/^Subject: \[PATCH\] //p' "$patch" | head -n1)
cd upstream
git log --oneline pulumi/patch-checkout --grep "$subject"

# If needed, disambiguate by touched path
git log --oneline pulumi/patch-checkout -- path/to/file
cd ..
```

Set `target_sha` to the owning commit and edit that commit, not `HEAD`.

## Amend Existing Patch (Preferred, Non-Interactive)

```bash
./scripts/upstream.sh checkout
cd upstream

target_sha=<owning-commit-sha>
base_sha=$(git rev-parse "${target_sha}^")
tmp_branch="rewrite-${target_sha:0:8}"

# Rebuild history from parent of target commit
git checkout -b "$tmp_branch" "$base_sha"
git cherry-pick "$target_sha"

# Apply fix and amend target commit
# ...edit files...
git add <files>
git commit --amend --no-edit

# Replay remaining commits
git cherry-pick "${target_sha}..pulumi/patch-checkout"

# If cherry-pick conflicts occur:
#   resolve files
#   git add <resolved files>
#   git cherry-pick --continue

# Move checkout branch to rewritten history
git branch -f pulumi/patch-checkout HEAD
git checkout pulumi/patch-checkout
git branch -D "$tmp_branch"
cd ..
```

Interactive fallback:

```bash
./scripts/upstream.sh checkout
./scripts/upstream.sh rebase -i
# mark target commit as edit, amend, then continue
```

## Remove Entire Patch

Use when a patch should be deleted completely.

```bash
rm patches/00NN-Description.patch
./scripts/upstream.sh checkout
./scripts/upstream.sh check_in
```

## Remove Part of a Patch

Use when only selected hunks/files should be removed from an existing patch.

1. Find owning patch/commit (`target_sha`) and use the amend workflow above.
2. Revert only unwanted changes from the target commit, then amend.

Example during amend step:

```bash
cd upstream
# Restore specific docs-only files from parent of amended commit
git checkout HEAD^ -- path/to/docs-only-file path/to/another-doc-file
git add path/to/docs-only-file path/to/another-doc-file
git commit --amend --no-edit
cd ..
```

## Create New Patch (Only If Requested)

```bash
./scripts/upstream.sh checkout
cd upstream
# ...make changes...
git add <files>
git commit -m "Describe new patch"
cd ..
./scripts/upstream.sh check_in
```

## Rebasing Patches to a New Upstream Version

```bash
./scripts/upstream.sh checkout

# Rebase onto the new upstream commit
./scripts/upstream.sh rebase -o <new_commit_sha>
# Resolve any conflicts that arise

# Write updated patch files
./scripts/upstream.sh check_in
```

## Verification Checklist

Before `check_in`:

- Confirm expected patch count change (`0` by default; `-1` for full patch removal).
- Confirm whether target patch should remain present (default yes) or be removed (explicit deletion case).
- Confirm you are editing the owning commit, not adding a new commit by accident.

After `check_in`:

- Verify patch count matches expectation.
- Verify target patch number/purpose is still present when expected.
- Verify no unexpected new `00NN-*.patch` was introduced.

If checkout mode is stuck, use `./scripts/upstream.sh init -f` to reset.
