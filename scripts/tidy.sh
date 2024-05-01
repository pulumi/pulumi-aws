#!/usr/bin/env bash

set -euo pipefail

gomod="$1"
(cd $(dirname "$gomod") && go mod tidy)
