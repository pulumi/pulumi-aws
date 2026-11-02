#!/usr/bin/env bash
# Older CLIs bundle Java and reject installing it as a language plugin.
version=$(pulumi version) || exit $?
if printf '%s\n' "$version" | awk -F '[.-]' '{ sub(/^v/, "", $1); exit !($1 > 3 || ($1 == 3 && ($2 > 269 || ($2 == 269 && $3 >= 0)))) }'; then
  pulumi plugin install language java
fi
