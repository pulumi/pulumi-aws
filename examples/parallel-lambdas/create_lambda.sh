#!/bin/bash

set -euo pipefail

temp_dir=$(mktemp -d)
trap "rm -rf $temp_dir" EXIT
pushd $temp_dir

printf "const { version } = require(\"@aws-sdk/client-s3/package.json\");\n\nexports.handler = async () => ({ version });\n" > index.js
dd if=/dev/urandom of=example.txt bs=25m count=1
zip lambda.zip index.js example.txt

# Check the size of lambda.zip
zip_size=$(stat -f %z lambda.zip)

# Compare the size with 25MB (25 * 1024 * 1024 bytes)
if [[ $zip_size -lt $((25 * 1024 * 1024)) ]]; then
    echo "lambda.zip is smaller than 25MB. Actual size $zip_size."
    exit 1
fi

popd
mv $temp_dir/lambda.zip .
