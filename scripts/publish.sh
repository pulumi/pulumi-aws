#!/bin/bash
# publish.sh will publish the current bits from the usual build location to an S3 build share.

set -e

# Default the Lumi root to the right place, but let it be overridden.
if [ -z "${LUMIROOT}" ]; then
    LUMIROOT=/usr/local/lumi
fi
LUMILIB=${LUMIROOT}/packs

PUBDIR=$(mktemp -du)
GITVER=$(git rev-parse HEAD)
PUBFILE=$(dirname ${PUBDIR})/${GITVER}.tgz
PUBPREFIX=s3://eng.pulumi.com/releases/aws
declare -a PUBTARGETS=(${GITVER} $(git describe --tags 2>/dev/null) $(git rev-parse --abbrev-ref HEAD))

ROOT=$(dirname $0)/..

# Make sure the repo isn't dirty.
git diff-index --quiet HEAD -- || \
    test -n "${PUBFORCE}" || \
    (echo "error: Cannot publish a dirty repo; set PUBFORCE=true to override" && exit 99)

# If it isn't, or publication was forced, do it.
mkdir -p ${PUBDIR}/cmd ${PUBDIR}/packs
cp -R ${LUMILIB}/aws ${PUBDIR}/packs/aws

# Tar up the release and upload it to our S3 bucket.
tar -czf ${PUBFILE} -C ${PUBDIR} .
for target in ${PUBTARGETS[@]}; do
    PUBTARGET=${PUBPREFIX}/${target}.tgz
    echo Publishing ${GITVER} to: ${PUBTARGET}
    if [ -z "${FIRSTTARGET}" ]; then
        # Upload the first one for real.
        aws s3 cp ${PUBFILE} ${PUBTARGET}
        FIRSTTARGET=${PUBTARGET}
    else
        # For all others, reuse the first target to avoid re-uploading.
        aws s3 cp ${FIRSTTARGET} ${PUBTARGET}
    fi
done

