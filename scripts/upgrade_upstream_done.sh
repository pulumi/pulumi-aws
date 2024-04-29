#!/usr/bin/env bash

set -euo pipefail

: "${NEW_VERSION?Need to set NEW_VERSION, example: 'v5.40.0'}"

cd upstream

# Now upstream will be moving
git checkout local
git reset --hard "$NEW_VERSION"
cd ..

git branch "upstream-${NEW_VERSION}"
git checkout "upstream-${NEW_VERSION}"
git add ./upstream
git commit -m "Moving ./upstream to $NEW_VERSION"
cd upstream
git checkout pulumi-patch
cd ..

# Convert ./upstream local..pulumi-patch diff back to patch files under ./patches
make upstream.finalize
git add ./patches
git commit -m 'Update patches'
