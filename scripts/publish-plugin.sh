#!/bin/bash
# publish-plugin.sh builds and publishes a package containing the resource provider to
# s3://rel.pulumi.com/releases/plugins.
set -o nounset -o errexit -o pipefail

ROOT=$(dirname $0)/..
WORK_PATH=$(mktemp -d)
VERSION=$(jq -r '.version' < "${ROOT}/sdk/nodejs/bin/package.json")
PLUGIN_PACKAGE_NAME="pulumi-resource-aws-${VERSION}-$(go env GOOS)-$(go env GOARCH).tar.gz"
PLUGIN_PACKAGE_DIR="$(mktemp -d)"
PLUGIN_PACKAGE_PATH="${PLUGIN_PACKAGE_DIR}/${PLUGIN_PACKAGE_NAME}"

# When crossbuilding, we want to ensure we have .exe for the windows binaries.
BIN_SUFFIX=
if [ "$(go env GOOS)" = "windows" ]; then
    BIN_SUFFIX=".exe"
fi

go build \
   -ldflags "-X github.com/pulumi/pulumi-aws/pkg/version.Version=${VERSION}" \
   -o "${WORK_PATH}/pulumi-resource-aws${BIN_SUFFIX}" \
   "${ROOT}/cmd/pulumi-resource-aws"

# Tar up the plugin
tar -czf ${PLUGIN_PACKAGE_PATH} -C ${WORK_PATH} .

# rel.pulumi.com is in our production account, so assume that role first
CREDS_JSON=$(aws sts assume-role \
                 --role-arn "arn:aws:iam::058607598222:role/UploadPulumiReleases" \
                 --role-session-name "upload-plugin-pulumi-resource-aws" \
                 --external-id "upload-pulumi-release")

# Use the credentials we just assumed
export AWS_ACCESS_KEY_ID=$(echo ${CREDS_JSON}     | jq ".Credentials.AccessKeyId" --raw-output)
export AWS_SECRET_ACCESS_KEY=$(echo ${CREDS_JSON} | jq ".Credentials.SecretAccessKey" --raw-output)
export AWS_SECURITY_TOKEN=$(echo ${CREDS_JSON}    | jq ".Credentials.SessionToken" --raw-output)

echo "Uploading ${PLUGIN_PACKAGE_NAME}..."

aws s3 cp --only-show-errors "${PLUGIN_PACKAGE_PATH}" "s3://rel.pulumi.com/releases/plugins/${PLUGIN_PACKAGE_NAME}"

rm -rf "${PLUGIN_PACKAGE_DIR}"
rm -rf "${WORK_PATH}"
