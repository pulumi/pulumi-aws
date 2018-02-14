#!/bin/bash
# publish.sh builds and publishes a release.
set -o nounset -o errexit -o pipefail

ROOT=$(dirname $0)/..
PUBLISH=$GOPATH/src/github.com/pulumi/home/scripts/publish.sh
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

echo "Publishing NPM package to NPMjs.com:"

# First create the package.json to publish.  This must be different than the one we use for development
# and testing the SDK, since we use symlinking for those workflows.  Namely, we must promote the SDK
# dependencies from peerDependencies that are resolved via those links, to real installable dependencies.
pushd ${ROOT}/pack/bin
node $(dirname $0)/promote.js @pulumi/pulumi < package.json > package.json.publish
mv package.json package.json.dev
mv package.json.publish package.json

# Now, perform the publish.
npm publish
npm info 2>/dev/null

# And finally restore the original package.json.
mv package.json package.json.publish
mv package.json.dev package.json
popd
