// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.iam.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class RolePolicyAttachmentsExclusiveState extends com.pulumi.resources.ResourceArgs {

    public static final RolePolicyAttachmentsExclusiveState Empty = new RolePolicyAttachmentsExclusiveState();

    /**
     * A list of managed IAM policy ARNs to be attached to the role. Policies attached to this role but not configured in this argument will be removed.
     * 
     */
    @Import(name="policyArns")
    private @Nullable Output<List<String>> policyArns;

    /**
     * @return A list of managed IAM policy ARNs to be attached to the role. Policies attached to this role but not configured in this argument will be removed.
     * 
     */
    public Optional<Output<List<String>>> policyArns() {
        return Optional.ofNullable(this.policyArns);
    }

    /**
     * IAM role name.
     * 
     */
    @Import(name="roleName")
    private @Nullable Output<String> roleName;

    /**
     * @return IAM role name.
     * 
     */
    public Optional<Output<String>> roleName() {
        return Optional.ofNullable(this.roleName);
    }

    private RolePolicyAttachmentsExclusiveState() {}

    private RolePolicyAttachmentsExclusiveState(RolePolicyAttachmentsExclusiveState $) {
        this.policyArns = $.policyArns;
        this.roleName = $.roleName;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RolePolicyAttachmentsExclusiveState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RolePolicyAttachmentsExclusiveState $;

        public Builder() {
            $ = new RolePolicyAttachmentsExclusiveState();
        }

        public Builder(RolePolicyAttachmentsExclusiveState defaults) {
            $ = new RolePolicyAttachmentsExclusiveState(Objects.requireNonNull(defaults));
        }

        /**
         * @param policyArns A list of managed IAM policy ARNs to be attached to the role. Policies attached to this role but not configured in this argument will be removed.
         * 
         * @return builder
         * 
         */
        public Builder policyArns(@Nullable Output<List<String>> policyArns) {
            $.policyArns = policyArns;
            return this;
        }

        /**
         * @param policyArns A list of managed IAM policy ARNs to be attached to the role. Policies attached to this role but not configured in this argument will be removed.
         * 
         * @return builder
         * 
         */
        public Builder policyArns(List<String> policyArns) {
            return policyArns(Output.of(policyArns));
        }

        /**
         * @param policyArns A list of managed IAM policy ARNs to be attached to the role. Policies attached to this role but not configured in this argument will be removed.
         * 
         * @return builder
         * 
         */
        public Builder policyArns(String... policyArns) {
            return policyArns(List.of(policyArns));
        }

        /**
         * @param roleName IAM role name.
         * 
         * @return builder
         * 
         */
        public Builder roleName(@Nullable Output<String> roleName) {
            $.roleName = roleName;
            return this;
        }

        /**
         * @param roleName IAM role name.
         * 
         * @return builder
         * 
         */
        public Builder roleName(String roleName) {
            return roleName(Output.of(roleName));
        }

        public RolePolicyAttachmentsExclusiveState build() {
            return $;
        }
    }

}
