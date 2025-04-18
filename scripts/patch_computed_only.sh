#!/usr/bin/env bash

# Edit upstream Plugin Framework resources to ensure names.AttrTagsAll maps to tags attributes that
# are no longer computed, because Pulumi needs them to not be computed.
#
# When should I run this script?
#
# Currently whenever upstream puts more resources under Plugin Framework,
# TestTagsAllNoLongerComputed will start failing because these new resources will have tags_all
# attribute marked Computed but Pulumi tag handling no longer supports that. If that happens, the
# maintainer has to do the following sequence of steps:
#
# - ./upstream.sh checkout
# - ./scripts/patch_computed_only.sh
# - ./upstream.sh check_in
#
# TODO[pulumi/pulumi-aws#2962] automate this to not require intervention.

set -euo pipefail

FILES=$(cd upstream && git grep TagsAttributeComputedOnly |
        grep -v data_source |
        grep -v tools/ |
        grep -v tags/framework |
        grep -v docs/ |
        grep -v skaff/ |
        awk -F: '{print $1}')


for f in $FILES; do
    replace="s/names.AttrTagsAll:\s+tftags.TagsAttributeComputedOnly/names.AttrTagsAll: tftags.TagsAttribute/g"
    perl -i -p -e "$replace" "upstream/$f"
done

# Add the tags fixes to the existing commit that manages the tags_all attribute.
cd upstream
git add .
tags_all_commit=$(git log --pretty=format:"%h" --grep="Apply tags patches" -n 1)
git commit --fixup="$tags_all_commit"
git -c rebase --interactive --autosquash "$tags_all_commit^"
