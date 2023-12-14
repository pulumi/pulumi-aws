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
# - make upstream.rebase
# - ./script/patch_computed_only.sh
# - (cd upstream && git add . && git commit -m 'Fix tags_all Computed for PF resources')
# - make upstream.finalize
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
    replace="s/names.AttrTagsAll: tftags.TagsAttributeComputedOnly/names.AttrTagsAll: tftags.TagsAttribute/g"
    perl -i -p -e "$replace" "upstream/$f"
done
