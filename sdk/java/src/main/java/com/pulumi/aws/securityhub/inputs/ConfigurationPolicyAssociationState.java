// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.securityhub.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ConfigurationPolicyAssociationState extends com.pulumi.resources.ResourceArgs {

    public static final ConfigurationPolicyAssociationState Empty = new ConfigurationPolicyAssociationState();

    /**
     * The universally unique identifier (UUID) of the configuration policy.
     * 
     */
    @Import(name="policyId")
    private @Nullable Output<String> policyId;

    /**
     * @return The universally unique identifier (UUID) of the configuration policy.
     * 
     */
    public Optional<Output<String>> policyId() {
        return Optional.ofNullable(this.policyId);
    }

    /**
     * The identifier of the target account, organizational unit, or the root to associate with the specified configuration.
     * 
     */
    @Import(name="targetId")
    private @Nullable Output<String> targetId;

    /**
     * @return The identifier of the target account, organizational unit, or the root to associate with the specified configuration.
     * 
     */
    public Optional<Output<String>> targetId() {
        return Optional.ofNullable(this.targetId);
    }

    private ConfigurationPolicyAssociationState() {}

    private ConfigurationPolicyAssociationState(ConfigurationPolicyAssociationState $) {
        this.policyId = $.policyId;
        this.targetId = $.targetId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ConfigurationPolicyAssociationState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ConfigurationPolicyAssociationState $;

        public Builder() {
            $ = new ConfigurationPolicyAssociationState();
        }

        public Builder(ConfigurationPolicyAssociationState defaults) {
            $ = new ConfigurationPolicyAssociationState(Objects.requireNonNull(defaults));
        }

        /**
         * @param policyId The universally unique identifier (UUID) of the configuration policy.
         * 
         * @return builder
         * 
         */
        public Builder policyId(@Nullable Output<String> policyId) {
            $.policyId = policyId;
            return this;
        }

        /**
         * @param policyId The universally unique identifier (UUID) of the configuration policy.
         * 
         * @return builder
         * 
         */
        public Builder policyId(String policyId) {
            return policyId(Output.of(policyId));
        }

        /**
         * @param targetId The identifier of the target account, organizational unit, or the root to associate with the specified configuration.
         * 
         * @return builder
         * 
         */
        public Builder targetId(@Nullable Output<String> targetId) {
            $.targetId = targetId;
            return this;
        }

        /**
         * @param targetId The identifier of the target account, organizational unit, or the root to associate with the specified configuration.
         * 
         * @return builder
         * 
         */
        public Builder targetId(String targetId) {
            return targetId(Output.of(targetId));
        }

        public ConfigurationPolicyAssociationState build() {
            return $;
        }
    }

}
