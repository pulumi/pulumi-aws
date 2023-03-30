#! /bin/bash

ACCOUNT='pulumi'
OS=$(uname -s | tr '[:upper:]' '[:lower:]')
ARCH=$(uname -m|tr '[:upper:]' '[:lower:]')
VERSION=$1

RELEASE_ARTIFACT="schema-tools-${VERSION}-${OS}-${ARCH}.tar.gz"
ARTIFACT_URL="https://github.com/${ACCOUNT}/schema-tools/releases/download/${VERSION}/${RELEASE_ARTIFACT}"

CURRENT_VERSION=$(./bin/schema-tools version 2>/dev/null)
echo "Downloading schema-tools ${VERSION} for ${OS} ${ARCH}..."

if [ CURRENT_VERSION == VERSION ]; then
    echo "schema-tools ${VERSION} is already installed."
    exit 0
else
    echo "schema-tools ${CURRENT_VERSION} is installed. Installing ${VERSION}..."
    curl -L -o ./bin/${RELEASE_ARTIFACT} ${ARTIFACT_URL}
    tar -xzf ./bin/${RELEASE_ARTIFACT} -C ./bin
    rm ./bin/${RELEASE_ARTIFACT}
fi
