#!/bin/bash
# publish_packages.sh uploads our packages to package repositories like npm
set -o nounset -o errexit -o pipefail
ROOT=$(dirname $0)/..
if [[ "${TRAVIS_OS_NAME:-}" == "linux" ]]; then
    # Publish the NPM package.
    echo "Publishing NPM package to NPMjs.com:"

    # First, add an install script to our package.json
    node $(dirname $0)/promote.js < \
        ${ROOT}/sdk/nodejs/bin/package.json > \
        ${ROOT}/sdk/nodejs/bin/package.json.publish
    pushd ${ROOT}/sdk/nodejs/bin
    mv package.json package.json.dev
    mv package.json.publish package.json

    NPM_TAG="dev"

    # If the package doesn't have a pre-release tag, use the tag of latest instead of
    # dev. NPM uses this tag as the default version to add, so we want it to mean
    # the newest released version.
    if [[ $(jq -r .version < package.json) != *-* ]]; then
        NPM_TAG="latest"
    fi

    # Now, perform the publish.
    npm publish -tag ${NPM_TAG}
    npm info 2>/dev/null

    # And finally restore the original package.json.
    mv package.json package.json.publish
    mv package.json.dev package.json
    popd

    # Next, publish the PyPI package.
    echo "Publishing Pip package to pulumi.com:"
    twine upload \
        -u pulumi -p ${PYPI_PASSWORD} \
        ${ROOT}/sdk/python/bin/dist/*.tar.gz
fi
