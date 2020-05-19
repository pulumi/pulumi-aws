#!/bin/bash
# publish-plugin.sh builds and publishes a package containing the resource provider to
# s3://rel.pulumi.com/releases/plugins.
set -o nounset -o errexit -o pipefail

# Update this with the name of the provider
PROVIDER_NAME="aws"

ROOT=$(dirname $0)/..
WORK_PATH=$(mktemp -d)
VERSION=$(jq -r '.version' < "${ROOT}/sdk/nodejs/bin/package.json")
PLUGIN_PACKAGE_NAME="pulumi-resource-${PROVIDER_NAME}-${VERSION}-$(go env GOOS)-$(go env GOARCH).tar.gz"
PLUGIN_PACKAGE_DIR="$(mktemp -d)"
PLUGIN_PACKAGE_PATH="${PLUGIN_PACKAGE_DIR}/${PLUGIN_PACKAGE_NAME}"

# When crossbuilding, we want to ensure we have .exe for the windows binaries.
BIN_SUFFIX=
if [ "$(go env GOOS)" = "windows" ]; then
    BIN_SUFFIX=".exe"
fi

(cd provider && go build \
   -ldflags "-X github.com/pulumi/pulumi-${PROVIDER_NAME}/provider/v2/pkg/version.Version=${VERSION}" \
   -o "${WORK_PATH}/pulumi-resource-${PROVIDER_NAME}${BIN_SUFFIX}" \
   "${ROOT}/cmd/pulumi-resource-${PROVIDER_NAME}")

# Tar up the plugin
tar -czf ${PLUGIN_PACKAGE_PATH} -C ${WORK_PATH} .

# Assume the provided role using the session name and (optional) external ID.
# Uses the "default" credentials, ignoring AWS_PROFILE if set.
# Usage: assume_iam_role <role-arn> <session-name> [external-id]
function assume_iam_role() {
    local ROLE_ARN=${1}
    local SESSION_NAME=${2}
    local EXTERNAL_ID=${3}

    echo "Assuming IAM Role '${ROLE_ARN}"
    echo "    Session    : ${SESSION_NAME}"
    echo "    External ID: ${EXTERNAL_ID}"

    local CREDS_JSON="{}"
    if [ -z ${EXTERNAL_ID} ]; then
        CREDS_JSON=$(aws sts assume-role \
                 --profile "default" \
                 --role-arn "${ROLE_ARN}" \
                 --role-session-name "${SESSION_NAME}" )
    else
        CREDS_JSON=$(aws sts assume-role \
                 --profile "default" \
                 --role-arn "${ROLE_ARN}" \
                 --role-session-name "${SESSION_NAME}" \
                 --external-id "${EXTERNAL_ID}" )
    fi

    export AWS_ACCESS_KEY_ID=$(echo ${CREDS_JSON}     | jq ".Credentials.AccessKeyId" --raw-output)
    export AWS_SECRET_ACCESS_KEY=$(echo ${CREDS_JSON} | jq ".Credentials.SecretAccessKey" --raw-output)
    export AWS_SECURITY_TOKEN=$(echo ${CREDS_JSON}    | jq ".Credentials.SessionToken" --raw-output)
}

# Clear the environment variables set after calling assume_iam_role to get back to
# the initial state. (Using the "default" profile.)
function unassume_iam_role() {
    unset {AWS_ACCESS_KEY_ID,AWS_SECRET_ACCESS_KEY,AWS_SECURITY_TOKEN}
}

echo "Uploading ${PLUGIN_PACKAGE_NAME} to s3://rel.pulumi.com..."
assume_iam_role \
     "arn:aws:iam::058607598222:role/UploadPulumiReleases" \
     "upload-plugin-pulumi-resource-${PROVIDER_NAME}" \
     "upload-pulumi-release"
aws s3 cp --only-show-errors "${PLUGIN_PACKAGE_PATH}" "s3://rel.pulumi.com/releases/plugins/${PLUGIN_PACKAGE_NAME}"
unassume_iam_role

# Assume the role to publish plugins to s3://get.pulumi.com. We upload the plugins to two buckets while
# we transition to only publishing/serving them from get.pulumi.com.
echo "Uploading ${PLUGIN_PACKAGE_NAME} to s3://get.pulumi.com..."
assume_iam_role \
     "arn:aws:iam::058607598222:role/PulumiUploadRelease" \
     "upload-plugin-pulumi-resource-${PROVIDER_NAME}" \
     "upload-pulumi-release"
aws s3 cp \
    --only-show-errors --acl public-read \
    "${PLUGIN_PACKAGE_PATH}" "s3://get.pulumi.com/releases/plugins/${PLUGIN_PACKAGE_NAME}"
unassume_iam_role

rm -rf "${PLUGIN_PACKAGE_DIR}"
rm -rf "${WORK_PATH}"
