// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.amp.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ScraperSourceEksArgs extends com.pulumi.resources.ResourceArgs {

    public static final ScraperSourceEksArgs Empty = new ScraperSourceEksArgs();

    @Import(name="clusterArn", required=true)
    private Output<String> clusterArn;

    public Output<String> clusterArn() {
        return this.clusterArn;
    }

    /**
     * List of the security group IDs for the Amazon EKS cluster VPC configuration.
     * 
     */
    @Import(name="securityGroupIds")
    private @Nullable Output<List<String>> securityGroupIds;

    /**
     * @return List of the security group IDs for the Amazon EKS cluster VPC configuration.
     * 
     */
    public Optional<Output<List<String>>> securityGroupIds() {
        return Optional.ofNullable(this.securityGroupIds);
    }

    /**
     * List of subnet IDs. Must be in at least two different availability zones.
     * 
     */
    @Import(name="subnetIds", required=true)
    private Output<List<String>> subnetIds;

    /**
     * @return List of subnet IDs. Must be in at least two different availability zones.
     * 
     */
    public Output<List<String>> subnetIds() {
        return this.subnetIds;
    }

    private ScraperSourceEksArgs() {}

    private ScraperSourceEksArgs(ScraperSourceEksArgs $) {
        this.clusterArn = $.clusterArn;
        this.securityGroupIds = $.securityGroupIds;
        this.subnetIds = $.subnetIds;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ScraperSourceEksArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ScraperSourceEksArgs $;

        public Builder() {
            $ = new ScraperSourceEksArgs();
        }

        public Builder(ScraperSourceEksArgs defaults) {
            $ = new ScraperSourceEksArgs(Objects.requireNonNull(defaults));
        }

        public Builder clusterArn(Output<String> clusterArn) {
            $.clusterArn = clusterArn;
            return this;
        }

        public Builder clusterArn(String clusterArn) {
            return clusterArn(Output.of(clusterArn));
        }

        /**
         * @param securityGroupIds List of the security group IDs for the Amazon EKS cluster VPC configuration.
         * 
         * @return builder
         * 
         */
        public Builder securityGroupIds(@Nullable Output<List<String>> securityGroupIds) {
            $.securityGroupIds = securityGroupIds;
            return this;
        }

        /**
         * @param securityGroupIds List of the security group IDs for the Amazon EKS cluster VPC configuration.
         * 
         * @return builder
         * 
         */
        public Builder securityGroupIds(List<String> securityGroupIds) {
            return securityGroupIds(Output.of(securityGroupIds));
        }

        /**
         * @param securityGroupIds List of the security group IDs for the Amazon EKS cluster VPC configuration.
         * 
         * @return builder
         * 
         */
        public Builder securityGroupIds(String... securityGroupIds) {
            return securityGroupIds(List.of(securityGroupIds));
        }

        /**
         * @param subnetIds List of subnet IDs. Must be in at least two different availability zones.
         * 
         * @return builder
         * 
         */
        public Builder subnetIds(Output<List<String>> subnetIds) {
            $.subnetIds = subnetIds;
            return this;
        }

        /**
         * @param subnetIds List of subnet IDs. Must be in at least two different availability zones.
         * 
         * @return builder
         * 
         */
        public Builder subnetIds(List<String> subnetIds) {
            return subnetIds(Output.of(subnetIds));
        }

        /**
         * @param subnetIds List of subnet IDs. Must be in at least two different availability zones.
         * 
         * @return builder
         * 
         */
        public Builder subnetIds(String... subnetIds) {
            return subnetIds(List.of(subnetIds));
        }

        public ScraperSourceEksArgs build() {
            if ($.clusterArn == null) {
                throw new MissingRequiredPropertyException("ScraperSourceEksArgs", "clusterArn");
            }
            if ($.subnetIds == null) {
                throw new MissingRequiredPropertyException("ScraperSourceEksArgs", "subnetIds");
            }
            return $;
        }
    }

}
