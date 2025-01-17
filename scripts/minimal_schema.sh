#!/usr/bin/env bash

set -euo pipefail

: ${VERSION?"Environment variable VERSION must be set"}

(cd provider/cmd/pulumi-resource-aws && PULUMI_AWS_MINIMAL_SCHEMA=true VERSION=${VERSION} go generate)
