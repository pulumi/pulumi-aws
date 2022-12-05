#!/usr/bin/env bash
yarn install --frozen-lockfile
cd ../terraform-provider-aws && git checkout . && cd - || exit
yarn tf-patch apply --cwd ../terraform-provider-aws
