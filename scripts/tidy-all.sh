#!/usr/bin/env bash

set -euo pipefail

git ls-files '**go.mod' | xargs -L 1 ./scripts/tidy.sh
