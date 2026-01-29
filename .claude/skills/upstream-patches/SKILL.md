---
name: upstream-patches
description: Working with upstream patches - creating, editing, deleting, and rebasing patches for the Terraform provider submodule in the upstream/ directory
user-invocable: false
---

# Working with Upstream Patches

The `upstream/` directory is a git submodule pointing to the upstream Terraform provider. We maintain patches in the `patches/` directory that are applied on top of the upstream code. Use `./scripts/upstream.sh` to manage patches.

## Commands Reference

| Command | Description |
|---------|-------------|
| `./scripts/upstream.sh init` | Initialize upstream and apply patches to working directory |
| `./scripts/upstream.sh init -f` | Force re-initialize, discarding any changes |
| `./scripts/upstream.sh checkout` | Create branch with patches as commits for editing |
| `./scripts/upstream.sh rebase -i` | Interactively edit patch commits |
| `./scripts/upstream.sh rebase -o <commit>` | Rebase patches onto a new upstream commit |
| `./scripts/upstream.sh check_in` | Write commits back to patches and exit checkout mode |

## Creating a New Patch

```bash
# 1. Enter checkout mode (converts patches to commits)
./scripts/upstream.sh checkout

# 2. Make changes in the upstream/ directory
cd upstream
# ... make your changes ...

# 3. Commit your changes
git commit -am "Description of the change"

# 4. Exit checkout mode (converts commits back to patches)
cd ..
./scripts/upstream.sh check_in

# 5. The new patch is now in patches/ and staged for commit
```

## Deleting a Patch

```bash
# 1. Enter checkout mode
./scripts/upstream.sh checkout

# 2. Interactive rebase to delete the commit
./scripts/upstream.sh rebase -i
# In the editor, delete or 'drop' the line for the patch you want to remove

# 3. Exit checkout mode
./scripts/upstream.sh check_in
```

## Editing an Existing Patch

```bash
# 1. Enter checkout mode
./scripts/upstream.sh checkout

# 2. Interactive rebase
./scripts/upstream.sh rebase -i
# Mark the commit as 'edit' in the editor

# 3. Make your changes, then amend the commit
git commit --amend

# 4. Continue the rebase
git rebase --continue

# 5. Exit checkout mode
./scripts/upstream.sh check_in
```

## Rebasing Patches to a New Upstream Version

```bash
# 1. Enter checkout mode
./scripts/upstream.sh checkout

# 2. Rebase onto the new upstream commit
./scripts/upstream.sh rebase -o <new_commit_sha>
# Resolve any conflicts that arise

# 3. Exit checkout mode
./scripts/upstream.sh check_in

# 4. Both patches/ and upstream are staged for commit
```

## Reviewing Patches

Patches are stored in `patches/` as numbered `.patch` files:
- `0001-Description.patch`
- `0002-Another-change.patch`

To understand what a patch does:
1. Read the patch file directly - it's a standard git diff format
2. Or enter checkout mode and use `git log` to see commits

## Important Notes

- **Never commit directly to `upstream/`** - Always use the checkout/check_in workflow
- **Patches are applied in order** - Numbering matters
- **After `check_in`**, both `patches/` and `upstream` changes are staged
- **If checkout mode is stuck**, use `./scripts/upstream.sh init -f` to reset
