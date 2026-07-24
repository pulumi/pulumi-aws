## Summary
- Problem:
- Change:
- Related issue/PR:

## Change Type
- [ ] Provider logic only (`provider/`)
- [ ] Schema or mapping change (may require SDK regeneration)
- [ ] Upstream or patch pipeline change (`upstream/`, `patches/`, `scripts/upstream.sh`)
- [ ] CI workflow source change (`.ci-mgmt.yaml`)

## Carried Upstream Patch
Complete this section only when adding or changing a patch under `patches/`. See [`docs/upstream-patches.md`](https://github.com/pulumi/pulumi-aws/blob/master/docs/upstream-patches.md).

- [ ] Patch tracking issue created:
- [ ] Owning-project issue or pull request linked:
- [ ] Differences from the owning-project change explained:
- [ ] Compatibility and removal risks documented:
- [ ] Required upstream acceptance test added:
- [ ] Test selected in `.github/workflows/aws-upstream-tests.yml`:
- [ ] Pulumi regression test added:
- [ ] Provider-upgrade coverage added, if required:

## Validation Evidence
Paste exact commands and outcomes. Include outcomes for the patch tests above, and identify tests that were skipped, not selected, or blocked by credentials.

- [ ] `make lint`
- [ ] `make test_provider`
- [ ] If schema-affecting: `make schema`
- [ ] If schema-affecting: `make build_sdks`
- [ ] If CI source changed: `make ci-mgmt`

### Command output snippets
```text
[paste output]
```

## Risk
- Blast radius:
- Edge cases:

## Rollback
- Revert plan:
- Follow-up cleanup:
