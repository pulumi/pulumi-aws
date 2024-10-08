// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dlm.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class LifecyclePolicyPolicyDetailsScheduleShareRuleArgs extends com.pulumi.resources.ResourceArgs {

    public static final LifecyclePolicyPolicyDetailsScheduleShareRuleArgs Empty = new LifecyclePolicyPolicyDetailsScheduleShareRuleArgs();

    /**
     * The IDs of the AWS accounts with which to share the snapshots.
     * 
     */
    @Import(name="targetAccounts", required=true)
    private Output<List<String>> targetAccounts;

    /**
     * @return The IDs of the AWS accounts with which to share the snapshots.
     * 
     */
    public Output<List<String>> targetAccounts() {
        return this.targetAccounts;
    }

    /**
     * The period after which snapshots that are shared with other AWS accounts are automatically unshared.
     * 
     */
    @Import(name="unshareInterval")
    private @Nullable Output<Integer> unshareInterval;

    /**
     * @return The period after which snapshots that are shared with other AWS accounts are automatically unshared.
     * 
     */
    public Optional<Output<Integer>> unshareInterval() {
        return Optional.ofNullable(this.unshareInterval);
    }

    /**
     * The unit of time for the automatic unsharing interval. Valid values are `DAYS`, `WEEKS`, `MONTHS`, `YEARS`.
     * 
     */
    @Import(name="unshareIntervalUnit")
    private @Nullable Output<String> unshareIntervalUnit;

    /**
     * @return The unit of time for the automatic unsharing interval. Valid values are `DAYS`, `WEEKS`, `MONTHS`, `YEARS`.
     * 
     */
    public Optional<Output<String>> unshareIntervalUnit() {
        return Optional.ofNullable(this.unshareIntervalUnit);
    }

    private LifecyclePolicyPolicyDetailsScheduleShareRuleArgs() {}

    private LifecyclePolicyPolicyDetailsScheduleShareRuleArgs(LifecyclePolicyPolicyDetailsScheduleShareRuleArgs $) {
        this.targetAccounts = $.targetAccounts;
        this.unshareInterval = $.unshareInterval;
        this.unshareIntervalUnit = $.unshareIntervalUnit;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(LifecyclePolicyPolicyDetailsScheduleShareRuleArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private LifecyclePolicyPolicyDetailsScheduleShareRuleArgs $;

        public Builder() {
            $ = new LifecyclePolicyPolicyDetailsScheduleShareRuleArgs();
        }

        public Builder(LifecyclePolicyPolicyDetailsScheduleShareRuleArgs defaults) {
            $ = new LifecyclePolicyPolicyDetailsScheduleShareRuleArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param targetAccounts The IDs of the AWS accounts with which to share the snapshots.
         * 
         * @return builder
         * 
         */
        public Builder targetAccounts(Output<List<String>> targetAccounts) {
            $.targetAccounts = targetAccounts;
            return this;
        }

        /**
         * @param targetAccounts The IDs of the AWS accounts with which to share the snapshots.
         * 
         * @return builder
         * 
         */
        public Builder targetAccounts(List<String> targetAccounts) {
            return targetAccounts(Output.of(targetAccounts));
        }

        /**
         * @param targetAccounts The IDs of the AWS accounts with which to share the snapshots.
         * 
         * @return builder
         * 
         */
        public Builder targetAccounts(String... targetAccounts) {
            return targetAccounts(List.of(targetAccounts));
        }

        /**
         * @param unshareInterval The period after which snapshots that are shared with other AWS accounts are automatically unshared.
         * 
         * @return builder
         * 
         */
        public Builder unshareInterval(@Nullable Output<Integer> unshareInterval) {
            $.unshareInterval = unshareInterval;
            return this;
        }

        /**
         * @param unshareInterval The period after which snapshots that are shared with other AWS accounts are automatically unshared.
         * 
         * @return builder
         * 
         */
        public Builder unshareInterval(Integer unshareInterval) {
            return unshareInterval(Output.of(unshareInterval));
        }

        /**
         * @param unshareIntervalUnit The unit of time for the automatic unsharing interval. Valid values are `DAYS`, `WEEKS`, `MONTHS`, `YEARS`.
         * 
         * @return builder
         * 
         */
        public Builder unshareIntervalUnit(@Nullable Output<String> unshareIntervalUnit) {
            $.unshareIntervalUnit = unshareIntervalUnit;
            return this;
        }

        /**
         * @param unshareIntervalUnit The unit of time for the automatic unsharing interval. Valid values are `DAYS`, `WEEKS`, `MONTHS`, `YEARS`.
         * 
         * @return builder
         * 
         */
        public Builder unshareIntervalUnit(String unshareIntervalUnit) {
            return unshareIntervalUnit(Output.of(unshareIntervalUnit));
        }

        public LifecyclePolicyPolicyDetailsScheduleShareRuleArgs build() {
            if ($.targetAccounts == null) {
                throw new MissingRequiredPropertyException("LifecyclePolicyPolicyDetailsScheduleShareRuleArgs", "targetAccounts");
            }
            return $;
        }
    }

}
