# Reviewing Patch Changes

Patch files (`patches/*.patch`) are difficult to review directly because they show a diff of a diff. To review patch changes effectively, convert them to actual code diffs.

## Review Process

### 1. Enter Checkout Mode

```bash
./scripts/upstream.sh checkout
```

This converts all patches to git commits on the `pulumi/patch-checkout` branch in the `upstream/` directory.

### 2. View the Actual Diff

For each changed patch file, find the corresponding commit and view its diff:

```bash
cd upstream

# List all patch commits
git log --oneline pulumi/checkout-base..HEAD

# View a specific commit's diff
git show <commit-sha>
```

The commit messages correspond to patch file names (e.g., `0005-Add-dedicated_host-docs.patch` becomes a commit with message "Add dedicated_host docs").

### 3. Comment with the Real Diff

When reviewing, add an inline comment on the patch file that includes:

1. **The actual diff** - Show what the patch does to the upstream code
2. **Analysis** - Explain what the change accomplishes and why it's needed
3. **Concerns** - Note any potential issues (conflicts with future upstream updates, side effects, etc.)

Example comment format:

```markdown
This patch modifies the upstream code as follows:

\`\`\`diff
- old code
+ new code
\`\`\`

**Analysis**: This change [explanation of what it does and why].

**Considerations**:
- [Any concerns about the change]
- [Potential for conflicts with upstream updates]
```

### 4. Exit Checkout Mode

After reviewing, exit checkout mode:

```bash
cd ..
./scripts/upstream.sh init -f
```

## Patch Requirements

Patches should only be created when ALL of the following are true:
- **Sufficient priority** - P1/P0 or red/orange customer request
- **No alternative** - Cannot be solved without patching upstream (no workarounds via bridge config)
- **Timing** - Upstream or bridge cannot fix in a timely manner

Each patch must have:
- A GitHub issue labeled `kind/patch`
- Link to the user-facing issue the patch addresses
- Link to the upstream issue (if applicable) that made the patch necessary
- An associated test that confirms the patch works (test should fail if patch is removed)

## Reviewing New Patches

New patches require strict documentation in the commit message:

**Required commit format:**
```
Short description (50 chars or less)

Detailed explanation of:
- What issue this patch addresses
- Why the patch is necessary (not fixable upstream/bridge in time)
- How the patch solves the issue

Fixes: <link to user-facing issue>
Upstream: <link to upstream issue if applicable>
Test: <name of test that validates the patch>
```

**Reject new patches that:**
- Have only a single-line commit message without explanation
- Don't link to a tracking issue
- Don't explain why patching is the only option
- Don't have an associated test

## Reviewing Modified Patches

Modified patches typically result from upstream changes causing patch conflicts. Key concerns:

### Check if patch is still needed
The upstream changes that caused the conflict may have **fixed the original issue**. Before approving:
- Review the upstream changes that caused the conflict
- Check if the original issue is now resolved upstream
- If so, the patch should be deleted, not updated

### Check if patch logic is still correct
The upstream changes may make the **original patch logic incorrect**:
- The conflict may be "resolved" but result in non-working code
- Verify the patched code still achieves its original intent

**Ask these questions:**
1. Does the updated patch still solve the original problem?
2. Has the surrounding code changed in ways that affect the patch's behavior?
3. Is there a test that validates this patch? Does it still pass?

## Reviewing Deleted Patches

Verify the patch removal is safe:
- Was the issue fixed upstream?
- Is the associated test being removed or updated?
- Are there any dependent patches that assume this patch exists?
