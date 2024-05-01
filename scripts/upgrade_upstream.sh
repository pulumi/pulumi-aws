#!/usr/bin/env bash

set -euo pipefail

: "${NEW_VERSION?Need to set NEW_VERSION, example: 'v5.47.0'}"

# After this command ./upstream will be on pulumi-patch branch with every patch as commit.
make upstream.rebase

# Now it is possible to use Git tools to rebase the patches-as-commits onto a new version.
(cd upstream && git rebase --onto "$NEW_VERSION" local pulumi-patch)

echo "Please finish Git rebase of ./upstream and call ./scripts/upgrade_upstream_done.sh"
