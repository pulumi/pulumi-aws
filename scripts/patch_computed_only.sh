#!/usr/bin/env bash

# Edit upstream Plugin Framework resources to ensure names.AttrTagsAll maps to tags attributes that
# are no longer computed, because Pulumi needs them to not be computed.

set -euo pipefail

FILES=$(cd upstream && git grep TagsAttributeComputedOnly |
        grep -v data_source |
        grep -v tools/ |
        grep -v tags/framework |
        grep -v docs/ |
        grep -v skaff/ |
        awk -F: '{print $1}')


for f in $FILES; do
    replace="s/names.AttrTagsAll: tftags.TagsAttributeComputedOnly/names.AttrTagsAll: tftags.TagsAttribute/g"
    perl -i -p -e "$replace" "upstream/$f"
done
