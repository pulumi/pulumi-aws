// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.iam;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;


public final class OrganizationsFeaturesArgs extends com.pulumi.resources.ResourceArgs {

    public static final OrganizationsFeaturesArgs Empty = new OrganizationsFeaturesArgs();

    /**
     * List of IAM features to enable. Valid values are `RootCredentialsManagement` and `RootSessions`.
     * 
     */
    @Import(name="enabledFeatures", required=true)
    private Output<List<String>> enabledFeatures;

    /**
     * @return List of IAM features to enable. Valid values are `RootCredentialsManagement` and `RootSessions`.
     * 
     */
    public Output<List<String>> enabledFeatures() {
        return this.enabledFeatures;
    }

    private OrganizationsFeaturesArgs() {}

    private OrganizationsFeaturesArgs(OrganizationsFeaturesArgs $) {
        this.enabledFeatures = $.enabledFeatures;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(OrganizationsFeaturesArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private OrganizationsFeaturesArgs $;

        public Builder() {
            $ = new OrganizationsFeaturesArgs();
        }

        public Builder(OrganizationsFeaturesArgs defaults) {
            $ = new OrganizationsFeaturesArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param enabledFeatures List of IAM features to enable. Valid values are `RootCredentialsManagement` and `RootSessions`.
         * 
         * @return builder
         * 
         */
        public Builder enabledFeatures(Output<List<String>> enabledFeatures) {
            $.enabledFeatures = enabledFeatures;
            return this;
        }

        /**
         * @param enabledFeatures List of IAM features to enable. Valid values are `RootCredentialsManagement` and `RootSessions`.
         * 
         * @return builder
         * 
         */
        public Builder enabledFeatures(List<String> enabledFeatures) {
            return enabledFeatures(Output.of(enabledFeatures));
        }

        /**
         * @param enabledFeatures List of IAM features to enable. Valid values are `RootCredentialsManagement` and `RootSessions`.
         * 
         * @return builder
         * 
         */
        public Builder enabledFeatures(String... enabledFeatures) {
            return enabledFeatures(List.of(enabledFeatures));
        }

        public OrganizationsFeaturesArgs build() {
            if ($.enabledFeatures == null) {
                throw new MissingRequiredPropertyException("OrganizationsFeaturesArgs", "enabledFeatures");
            }
            return $;
        }
    }

}
