#!/usr/bin/env bash
set -euo pipefail

# This script can be simplified to use go when https://github.com/jdx/mise/discussions/6374 is fixed
# e.g. go list -m -f '{{.GoVersion}}'

module_path="github.com/pulumi/pulumi/pkg/v3"
go_mod_path="provider"
gomod="go.mod"

if [[ "$go_mod_path" != "" && "$go_mod_path" != "." ]]; then
  gomod="$go_mod_path/$gomod"
fi

if [[ ! -f "$gomod" ]]; then
  echo "missing $gomod" >&2
  exit 1
fi

raw_version=$(awk -v module="$module_path" '
    $1 == module || $2 == module {
        for (i = 1; i <= NF; i++) {
            if ($i ~ /^v[0-9]/) {
                sub(/^v/, "", $i)
                print $i
                exit
            }
        }
    }
' "$gomod")

if [[ -z "${raw_version:-}" ]]; then
  echo "failed to determine Pulumi version from $gomod" >&2
  exit 1
fi

echo "PULUMI_VERSION_MISE=$raw_version"
export PULUMI_VERSION_MISE=$raw_version

# Prefer the toolchain directive if present, otherwise fall back to the `go` version line
go_toolchain=$(awk '/^toolchain[[:space:]]+go[0-9]/{ print $2; exit }' "$gomod")

if [[ -n "${go_toolchain:-}" ]]; then
  go_version=${go_toolchain#go}
else
  go_version=$(awk '/^go[[:space:]]+[0-9]/{ print $2; exit }' "$gomod")
fi

if [[ -z "${go_version:-}" ]]; then
  echo "failed to determine Go version from $gomod" >&2
  exit 1
fi

echo "GO_VERSION_MISE=$go_version"
export GO_VERSION_MISE=$go_version
