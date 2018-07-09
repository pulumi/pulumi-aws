#!/bin/bash
# publish_tgz.sh builds and publishes the tarballs that our other repositories consume.
set -o nounset -o errexit -o pipefail

ROOT=$(dirname $0)/..
PUBLISH_GOOS=("linux" "windows" "darwin")
PUBLISH_GOARCH=("amd64")

echo "Publishing plugin archive to s3://rel.pulumi.com/:"
for OS in "${PUBLISH_GOOS[@]}"
do
    for ARCH in "${PUBLISH_GOARCH[@]}"
    do
        export GOOS=${OS}
        export GOARCH=${ARCH}

        ${ROOT}/scripts/publish-plugin.sh
    done
done
