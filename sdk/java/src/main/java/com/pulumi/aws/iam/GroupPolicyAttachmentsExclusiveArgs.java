// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.iam;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;


public final class GroupPolicyAttachmentsExclusiveArgs extends com.pulumi.resources.ResourceArgs {

    public static final GroupPolicyAttachmentsExclusiveArgs Empty = new GroupPolicyAttachmentsExclusiveArgs();

    /**
     * IAM group name.
     * 
     */
    @Import(name="groupName", required=true)
    private Output<String> groupName;

    /**
     * @return IAM group name.
     * 
     */
    public Output<String> groupName() {
        return this.groupName;
    }

    /**
     * A list of managed IAM policy ARNs to be attached to the group. Policies attached to this group but not configured in this argument will be removed.
     * 
     */
    @Import(name="policyArns", required=true)
    private Output<List<String>> policyArns;

    /**
     * @return A list of managed IAM policy ARNs to be attached to the group. Policies attached to this group but not configured in this argument will be removed.
     * 
     */
    public Output<List<String>> policyArns() {
        return this.policyArns;
    }

    private GroupPolicyAttachmentsExclusiveArgs() {}

    private GroupPolicyAttachmentsExclusiveArgs(GroupPolicyAttachmentsExclusiveArgs $) {
        this.groupName = $.groupName;
        this.policyArns = $.policyArns;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GroupPolicyAttachmentsExclusiveArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GroupPolicyAttachmentsExclusiveArgs $;

        public Builder() {
            $ = new GroupPolicyAttachmentsExclusiveArgs();
        }

        public Builder(GroupPolicyAttachmentsExclusiveArgs defaults) {
            $ = new GroupPolicyAttachmentsExclusiveArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param groupName IAM group name.
         * 
         * @return builder
         * 
         */
        public Builder groupName(Output<String> groupName) {
            $.groupName = groupName;
            return this;
        }

        /**
         * @param groupName IAM group name.
         * 
         * @return builder
         * 
         */
        public Builder groupName(String groupName) {
            return groupName(Output.of(groupName));
        }

        /**
         * @param policyArns A list of managed IAM policy ARNs to be attached to the group. Policies attached to this group but not configured in this argument will be removed.
         * 
         * @return builder
         * 
         */
        public Builder policyArns(Output<List<String>> policyArns) {
            $.policyArns = policyArns;
            return this;
        }

        /**
         * @param policyArns A list of managed IAM policy ARNs to be attached to the group. Policies attached to this group but not configured in this argument will be removed.
         * 
         * @return builder
         * 
         */
        public Builder policyArns(List<String> policyArns) {
            return policyArns(Output.of(policyArns));
        }

        /**
         * @param policyArns A list of managed IAM policy ARNs to be attached to the group. Policies attached to this group but not configured in this argument will be removed.
         * 
         * @return builder
         * 
         */
        public Builder policyArns(String... policyArns) {
            return policyArns(List.of(policyArns));
        }

        public GroupPolicyAttachmentsExclusiveArgs build() {
            if ($.groupName == null) {
                throw new MissingRequiredPropertyException("GroupPolicyAttachmentsExclusiveArgs", "groupName");
            }
            if ($.policyArns == null) {
                throw new MissingRequiredPropertyException("GroupPolicyAttachmentsExclusiveArgs", "policyArns");
            }
            return $;
        }
    }

}
