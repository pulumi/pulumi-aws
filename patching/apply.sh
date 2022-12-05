#!/usr/bin/env bash

# Ensure dependencies are up-to-date
yarn install --frozen-lockfile --silent
# Reset all changes in the TF fork to avoid noise from already-applied changes
cd ../terraform-provider-aws && git checkout . && cd - || exit
yarn --silent run tf-patch apply --cwd ../terraform-provider-aws
