#!/usr/bin/env bash

set -euo pipefail


pulumi config set state1 '{"defaultTags": {"a": "b"}, "resourceTags": {"c": "d"}}'

pulumi up --yes
