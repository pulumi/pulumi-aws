// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.redshiftserverless;

import com.pulumi.aws.redshiftserverless.inputs.WorkgroupConfigParameterArgs;
import com.pulumi.aws.redshiftserverless.inputs.WorkgroupPricePerformanceTargetArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class WorkgroupArgs extends com.pulumi.resources.ResourceArgs {

    public static final WorkgroupArgs Empty = new WorkgroupArgs();

    /**
     * The base data warehouse capacity of the workgroup in Redshift Processing Units (RPUs).
     * 
     */
    @Import(name="baseCapacity")
    private @Nullable Output<Integer> baseCapacity;

    /**
     * @return The base data warehouse capacity of the workgroup in Redshift Processing Units (RPUs).
     * 
     */
    public Optional<Output<Integer>> baseCapacity() {
        return Optional.ofNullable(this.baseCapacity);
    }

    /**
     * An array of parameters to set for more control over a serverless database. See `Config Parameter` below.
     * 
     */
    @Import(name="configParameters")
    private @Nullable Output<List<WorkgroupConfigParameterArgs>> configParameters;

    /**
     * @return An array of parameters to set for more control over a serverless database. See `Config Parameter` below.
     * 
     */
    public Optional<Output<List<WorkgroupConfigParameterArgs>>> configParameters() {
        return Optional.ofNullable(this.configParameters);
    }

    /**
     * The value that specifies whether to turn on enhanced virtual private cloud (VPC) routing, which forces Amazon Redshift Serverless to route traffic through your VPC instead of over the internet.
     * 
     */
    @Import(name="enhancedVpcRouting")
    private @Nullable Output<Boolean> enhancedVpcRouting;

    /**
     * @return The value that specifies whether to turn on enhanced virtual private cloud (VPC) routing, which forces Amazon Redshift Serverless to route traffic through your VPC instead of over the internet.
     * 
     */
    public Optional<Output<Boolean>> enhancedVpcRouting() {
        return Optional.ofNullable(this.enhancedVpcRouting);
    }

    /**
     * The maximum data-warehouse capacity Amazon Redshift Serverless uses to serve queries, specified in Redshift Processing Units (RPUs).
     * 
     */
    @Import(name="maxCapacity")
    private @Nullable Output<Integer> maxCapacity;

    /**
     * @return The maximum data-warehouse capacity Amazon Redshift Serverless uses to serve queries, specified in Redshift Processing Units (RPUs).
     * 
     */
    public Optional<Output<Integer>> maxCapacity() {
        return Optional.ofNullable(this.maxCapacity);
    }

    /**
     * The name of the namespace.
     * 
     */
    @Import(name="namespaceName", required=true)
    private Output<String> namespaceName;

    /**
     * @return The name of the namespace.
     * 
     */
    public Output<String> namespaceName() {
        return this.namespaceName;
    }

    /**
     * The port number on which the cluster accepts incoming connections.
     * 
     */
    @Import(name="port")
    private @Nullable Output<Integer> port;

    /**
     * @return The port number on which the cluster accepts incoming connections.
     * 
     */
    public Optional<Output<Integer>> port() {
        return Optional.ofNullable(this.port);
    }

    /**
     * Price-performance scaling for the workgroup. See `Price Performance Target` below.
     * 
     */
    @Import(name="pricePerformanceTarget")
    private @Nullable Output<WorkgroupPricePerformanceTargetArgs> pricePerformanceTarget;

    /**
     * @return Price-performance scaling for the workgroup. See `Price Performance Target` below.
     * 
     */
    public Optional<Output<WorkgroupPricePerformanceTargetArgs>> pricePerformanceTarget() {
        return Optional.ofNullable(this.pricePerformanceTarget);
    }

    /**
     * A value that specifies whether the workgroup can be accessed from a public network.
     * 
     */
    @Import(name="publiclyAccessible")
    private @Nullable Output<Boolean> publiclyAccessible;

    /**
     * @return A value that specifies whether the workgroup can be accessed from a public network.
     * 
     */
    public Optional<Output<Boolean>> publiclyAccessible() {
        return Optional.ofNullable(this.publiclyAccessible);
    }

    /**
     * An array of security group IDs to associate with the workgroup.
     * 
     */
    @Import(name="securityGroupIds")
    private @Nullable Output<List<String>> securityGroupIds;

    /**
     * @return An array of security group IDs to associate with the workgroup.
     * 
     */
    public Optional<Output<List<String>>> securityGroupIds() {
        return Optional.ofNullable(this.securityGroupIds);
    }

    /**
     * An array of VPC subnet IDs to associate with the workgroup. When set, must contain at least three subnets spanning three Availability Zones. A minimum number of IP addresses is required and scales with the Base Capacity. For more information, see the following [AWS document](https://docs.aws.amazon.com/redshift/latest/mgmt/serverless-known-issues.html).
     * 
     */
    @Import(name="subnetIds")
    private @Nullable Output<List<String>> subnetIds;

    /**
     * @return An array of VPC subnet IDs to associate with the workgroup. When set, must contain at least three subnets spanning three Availability Zones. A minimum number of IP addresses is required and scales with the Base Capacity. For more information, see the following [AWS document](https://docs.aws.amazon.com/redshift/latest/mgmt/serverless-known-issues.html).
     * 
     */
    public Optional<Output<List<String>>> subnetIds() {
        return Optional.ofNullable(this.subnetIds);
    }

    /**
     * A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * The name of the track for the workgroup. If it is `current`, you get the most up-to-date certified release version with the latest features, security updates, and performance enhancements. If it is `trailing`, you will be on the previous certified release. For more information, see the following [AWS document](https://docs.aws.amazon.com/redshift/latest/mgmt/tracks.html).
     * 
     */
    @Import(name="trackName")
    private @Nullable Output<String> trackName;

    /**
     * @return The name of the track for the workgroup. If it is `current`, you get the most up-to-date certified release version with the latest features, security updates, and performance enhancements. If it is `trailing`, you will be on the previous certified release. For more information, see the following [AWS document](https://docs.aws.amazon.com/redshift/latest/mgmt/tracks.html).
     * 
     */
    public Optional<Output<String>> trackName() {
        return Optional.ofNullable(this.trackName);
    }

    /**
     * The name of the workgroup.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="workgroupName", required=true)
    private Output<String> workgroupName;

    /**
     * @return The name of the workgroup.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> workgroupName() {
        return this.workgroupName;
    }

    private WorkgroupArgs() {}

    private WorkgroupArgs(WorkgroupArgs $) {
        this.baseCapacity = $.baseCapacity;
        this.configParameters = $.configParameters;
        this.enhancedVpcRouting = $.enhancedVpcRouting;
        this.maxCapacity = $.maxCapacity;
        this.namespaceName = $.namespaceName;
        this.port = $.port;
        this.pricePerformanceTarget = $.pricePerformanceTarget;
        this.publiclyAccessible = $.publiclyAccessible;
        this.securityGroupIds = $.securityGroupIds;
        this.subnetIds = $.subnetIds;
        this.tags = $.tags;
        this.trackName = $.trackName;
        this.workgroupName = $.workgroupName;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(WorkgroupArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private WorkgroupArgs $;

        public Builder() {
            $ = new WorkgroupArgs();
        }

        public Builder(WorkgroupArgs defaults) {
            $ = new WorkgroupArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param baseCapacity The base data warehouse capacity of the workgroup in Redshift Processing Units (RPUs).
         * 
         * @return builder
         * 
         */
        public Builder baseCapacity(@Nullable Output<Integer> baseCapacity) {
            $.baseCapacity = baseCapacity;
            return this;
        }

        /**
         * @param baseCapacity The base data warehouse capacity of the workgroup in Redshift Processing Units (RPUs).
         * 
         * @return builder
         * 
         */
        public Builder baseCapacity(Integer baseCapacity) {
            return baseCapacity(Output.of(baseCapacity));
        }

        /**
         * @param configParameters An array of parameters to set for more control over a serverless database. See `Config Parameter` below.
         * 
         * @return builder
         * 
         */
        public Builder configParameters(@Nullable Output<List<WorkgroupConfigParameterArgs>> configParameters) {
            $.configParameters = configParameters;
            return this;
        }

        /**
         * @param configParameters An array of parameters to set for more control over a serverless database. See `Config Parameter` below.
         * 
         * @return builder
         * 
         */
        public Builder configParameters(List<WorkgroupConfigParameterArgs> configParameters) {
            return configParameters(Output.of(configParameters));
        }

        /**
         * @param configParameters An array of parameters to set for more control over a serverless database. See `Config Parameter` below.
         * 
         * @return builder
         * 
         */
        public Builder configParameters(WorkgroupConfigParameterArgs... configParameters) {
            return configParameters(List.of(configParameters));
        }

        /**
         * @param enhancedVpcRouting The value that specifies whether to turn on enhanced virtual private cloud (VPC) routing, which forces Amazon Redshift Serverless to route traffic through your VPC instead of over the internet.
         * 
         * @return builder
         * 
         */
        public Builder enhancedVpcRouting(@Nullable Output<Boolean> enhancedVpcRouting) {
            $.enhancedVpcRouting = enhancedVpcRouting;
            return this;
        }

        /**
         * @param enhancedVpcRouting The value that specifies whether to turn on enhanced virtual private cloud (VPC) routing, which forces Amazon Redshift Serverless to route traffic through your VPC instead of over the internet.
         * 
         * @return builder
         * 
         */
        public Builder enhancedVpcRouting(Boolean enhancedVpcRouting) {
            return enhancedVpcRouting(Output.of(enhancedVpcRouting));
        }

        /**
         * @param maxCapacity The maximum data-warehouse capacity Amazon Redshift Serverless uses to serve queries, specified in Redshift Processing Units (RPUs).
         * 
         * @return builder
         * 
         */
        public Builder maxCapacity(@Nullable Output<Integer> maxCapacity) {
            $.maxCapacity = maxCapacity;
            return this;
        }

        /**
         * @param maxCapacity The maximum data-warehouse capacity Amazon Redshift Serverless uses to serve queries, specified in Redshift Processing Units (RPUs).
         * 
         * @return builder
         * 
         */
        public Builder maxCapacity(Integer maxCapacity) {
            return maxCapacity(Output.of(maxCapacity));
        }

        /**
         * @param namespaceName The name of the namespace.
         * 
         * @return builder
         * 
         */
        public Builder namespaceName(Output<String> namespaceName) {
            $.namespaceName = namespaceName;
            return this;
        }

        /**
         * @param namespaceName The name of the namespace.
         * 
         * @return builder
         * 
         */
        public Builder namespaceName(String namespaceName) {
            return namespaceName(Output.of(namespaceName));
        }

        /**
         * @param port The port number on which the cluster accepts incoming connections.
         * 
         * @return builder
         * 
         */
        public Builder port(@Nullable Output<Integer> port) {
            $.port = port;
            return this;
        }

        /**
         * @param port The port number on which the cluster accepts incoming connections.
         * 
         * @return builder
         * 
         */
        public Builder port(Integer port) {
            return port(Output.of(port));
        }

        /**
         * @param pricePerformanceTarget Price-performance scaling for the workgroup. See `Price Performance Target` below.
         * 
         * @return builder
         * 
         */
        public Builder pricePerformanceTarget(@Nullable Output<WorkgroupPricePerformanceTargetArgs> pricePerformanceTarget) {
            $.pricePerformanceTarget = pricePerformanceTarget;
            return this;
        }

        /**
         * @param pricePerformanceTarget Price-performance scaling for the workgroup. See `Price Performance Target` below.
         * 
         * @return builder
         * 
         */
        public Builder pricePerformanceTarget(WorkgroupPricePerformanceTargetArgs pricePerformanceTarget) {
            return pricePerformanceTarget(Output.of(pricePerformanceTarget));
        }

        /**
         * @param publiclyAccessible A value that specifies whether the workgroup can be accessed from a public network.
         * 
         * @return builder
         * 
         */
        public Builder publiclyAccessible(@Nullable Output<Boolean> publiclyAccessible) {
            $.publiclyAccessible = publiclyAccessible;
            return this;
        }

        /**
         * @param publiclyAccessible A value that specifies whether the workgroup can be accessed from a public network.
         * 
         * @return builder
         * 
         */
        public Builder publiclyAccessible(Boolean publiclyAccessible) {
            return publiclyAccessible(Output.of(publiclyAccessible));
        }

        /**
         * @param securityGroupIds An array of security group IDs to associate with the workgroup.
         * 
         * @return builder
         * 
         */
        public Builder securityGroupIds(@Nullable Output<List<String>> securityGroupIds) {
            $.securityGroupIds = securityGroupIds;
            return this;
        }

        /**
         * @param securityGroupIds An array of security group IDs to associate with the workgroup.
         * 
         * @return builder
         * 
         */
        public Builder securityGroupIds(List<String> securityGroupIds) {
            return securityGroupIds(Output.of(securityGroupIds));
        }

        /**
         * @param securityGroupIds An array of security group IDs to associate with the workgroup.
         * 
         * @return builder
         * 
         */
        public Builder securityGroupIds(String... securityGroupIds) {
            return securityGroupIds(List.of(securityGroupIds));
        }

        /**
         * @param subnetIds An array of VPC subnet IDs to associate with the workgroup. When set, must contain at least three subnets spanning three Availability Zones. A minimum number of IP addresses is required and scales with the Base Capacity. For more information, see the following [AWS document](https://docs.aws.amazon.com/redshift/latest/mgmt/serverless-known-issues.html).
         * 
         * @return builder
         * 
         */
        public Builder subnetIds(@Nullable Output<List<String>> subnetIds) {
            $.subnetIds = subnetIds;
            return this;
        }

        /**
         * @param subnetIds An array of VPC subnet IDs to associate with the workgroup. When set, must contain at least three subnets spanning three Availability Zones. A minimum number of IP addresses is required and scales with the Base Capacity. For more information, see the following [AWS document](https://docs.aws.amazon.com/redshift/latest/mgmt/serverless-known-issues.html).
         * 
         * @return builder
         * 
         */
        public Builder subnetIds(List<String> subnetIds) {
            return subnetIds(Output.of(subnetIds));
        }

        /**
         * @param subnetIds An array of VPC subnet IDs to associate with the workgroup. When set, must contain at least three subnets spanning three Availability Zones. A minimum number of IP addresses is required and scales with the Base Capacity. For more information, see the following [AWS document](https://docs.aws.amazon.com/redshift/latest/mgmt/serverless-known-issues.html).
         * 
         * @return builder
         * 
         */
        public Builder subnetIds(String... subnetIds) {
            return subnetIds(List.of(subnetIds));
        }

        /**
         * @param tags A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param trackName The name of the track for the workgroup. If it is `current`, you get the most up-to-date certified release version with the latest features, security updates, and performance enhancements. If it is `trailing`, you will be on the previous certified release. For more information, see the following [AWS document](https://docs.aws.amazon.com/redshift/latest/mgmt/tracks.html).
         * 
         * @return builder
         * 
         */
        public Builder trackName(@Nullable Output<String> trackName) {
            $.trackName = trackName;
            return this;
        }

        /**
         * @param trackName The name of the track for the workgroup. If it is `current`, you get the most up-to-date certified release version with the latest features, security updates, and performance enhancements. If it is `trailing`, you will be on the previous certified release. For more information, see the following [AWS document](https://docs.aws.amazon.com/redshift/latest/mgmt/tracks.html).
         * 
         * @return builder
         * 
         */
        public Builder trackName(String trackName) {
            return trackName(Output.of(trackName));
        }

        /**
         * @param workgroupName The name of the workgroup.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder workgroupName(Output<String> workgroupName) {
            $.workgroupName = workgroupName;
            return this;
        }

        /**
         * @param workgroupName The name of the workgroup.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder workgroupName(String workgroupName) {
            return workgroupName(Output.of(workgroupName));
        }

        public WorkgroupArgs build() {
            if ($.namespaceName == null) {
                throw new MissingRequiredPropertyException("WorkgroupArgs", "namespaceName");
            }
            if ($.workgroupName == null) {
                throw new MissingRequiredPropertyException("WorkgroupArgs", "workgroupName");
            }
            return $;
        }
    }

}
