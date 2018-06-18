#!/bin/bash
# publish_tgz.sh builds and publishes the tarballs that our other repositories consume.
set -o nounset -o errexit -o pipefail

ROOT=$(dirname $0)/..
PUBLISH=$GOPATH/src/github.com/pulumi/scripts/ci/publish.sh
PUBLISH_GOOS=("linux" "windows" "darwin")
PUBLISH_GOARCH=("amd64")
PUBLISH_PROJECT="pulumi-aws"

if [ ! -f $PUBLISH ]; then
    >&2 echo "error: Missing publish script at $PUBLISH"
    exit 1
fi

echo "Publishing SDK build to s3://eng.pulumi.com/:"
for OS in "${PUBLISH_GOOS[@]}"
do
    for ARCH in "${PUBLISH_GOARCH[@]}"
    do
        export GOOS=${OS}
        export GOARCH=${ARCH}

        RELEASE_INFO=($($(dirname $0)/make_release.sh))
        ${PUBLISH} ${RELEASE_INFO[0]} "${PUBLISH_PROJECT}/${OS}/${ARCH}" ${RELEASE_INFO[@]:1}
    done
done

echo "Publishing Plugin archive to s3://rel.pulumi.com/:"
for OS in "${PUBLISH_GOOS[@]}"
do
    for ARCH in "${PUBLISH_GOARCH[@]}"
    do
        export GOOS=${OS}
        export GOARCH=${ARCH}

        ${ROOT}/scripts/publish-plugin.sh
    done
done
