#!/usr/bin/env bash

set -euo pipefail

(cd /Users/anton/code/ci-mgmt/provider-ci && make bin/provider-ci)
/Users/anton/code/ci-mgmt/provider-ci/bin/provider-ci generate --skip-migrations
