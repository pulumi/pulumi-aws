// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;


public final class CustomModelVpcConfigArgs extends com.pulumi.resources.ResourceArgs {

    public static final CustomModelVpcConfigArgs Empty = new CustomModelVpcConfigArgs();

    /**
     * VPC configuration security group IDs.
     * 
     */
    @Import(name="securityGroupIds", required=true)
    private Output<List<String>> securityGroupIds;

    /**
     * @return VPC configuration security group IDs.
     * 
     */
    public Output<List<String>> securityGroupIds() {
        return this.securityGroupIds;
    }

    /**
     * VPC configuration subnets.
     * 
     */
    @Import(name="subnetIds", required=true)
    private Output<List<String>> subnetIds;

    /**
     * @return VPC configuration subnets.
     * 
     */
    public Output<List<String>> subnetIds() {
        return this.subnetIds;
    }

    private CustomModelVpcConfigArgs() {}

    private CustomModelVpcConfigArgs(CustomModelVpcConfigArgs $) {
        this.securityGroupIds = $.securityGroupIds;
        this.subnetIds = $.subnetIds;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(CustomModelVpcConfigArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private CustomModelVpcConfigArgs $;

        public Builder() {
            $ = new CustomModelVpcConfigArgs();
        }

        public Builder(CustomModelVpcConfigArgs defaults) {
            $ = new CustomModelVpcConfigArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param securityGroupIds VPC configuration security group IDs.
         * 
         * @return builder
         * 
         */
        public Builder securityGroupIds(Output<List<String>> securityGroupIds) {
            $.securityGroupIds = securityGroupIds;
            return this;
        }

        /**
         * @param securityGroupIds VPC configuration security group IDs.
         * 
         * @return builder
         * 
         */
        public Builder securityGroupIds(List<String> securityGroupIds) {
            return securityGroupIds(Output.of(securityGroupIds));
        }

        /**
         * @param securityGroupIds VPC configuration security group IDs.
         * 
         * @return builder
         * 
         */
        public Builder securityGroupIds(String... securityGroupIds) {
            return securityGroupIds(List.of(securityGroupIds));
        }

        /**
         * @param subnetIds VPC configuration subnets.
         * 
         * @return builder
         * 
         */
        public Builder subnetIds(Output<List<String>> subnetIds) {
            $.subnetIds = subnetIds;
            return this;
        }

        /**
         * @param subnetIds VPC configuration subnets.
         * 
         * @return builder
         * 
         */
        public Builder subnetIds(List<String> subnetIds) {
            return subnetIds(Output.of(subnetIds));
        }

        /**
         * @param subnetIds VPC configuration subnets.
         * 
         * @return builder
         * 
         */
        public Builder subnetIds(String... subnetIds) {
            return subnetIds(List.of(subnetIds));
        }

        public CustomModelVpcConfigArgs build() {
            if ($.securityGroupIds == null) {
                throw new MissingRequiredPropertyException("CustomModelVpcConfigArgs", "securityGroupIds");
            }
            if ($.subnetIds == null) {
                throw new MissingRequiredPropertyException("CustomModelVpcConfigArgs", "subnetIds");
            }
            return $;
        }
    }

}
