// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.workspacesweb;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class NetworkSettingsArgs extends com.pulumi.resources.ResourceArgs {

    public static final NetworkSettingsArgs Empty = new NetworkSettingsArgs();

    /**
     * One or more security groups used to control access from streaming instances to your VPC.
     * 
     */
    @Import(name="securityGroupIds", required=true)
    private Output<List<String>> securityGroupIds;

    /**
     * @return One or more security groups used to control access from streaming instances to your VPC.
     * 
     */
    public Output<List<String>> securityGroupIds() {
        return this.securityGroupIds;
    }

    /**
     * The subnets in which network interfaces are created to connect streaming instances to your VPC. At least two subnet ids must be specified.
     * 
     */
    @Import(name="subnetIds", required=true)
    private Output<List<String>> subnetIds;

    /**
     * @return The subnets in which network interfaces are created to connect streaming instances to your VPC. At least two subnet ids must be specified.
     * 
     */
    public Output<List<String>> subnetIds() {
        return this.subnetIds;
    }

    /**
     * Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * The VPC that streaming instances will connect to.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="vpcId", required=true)
    private Output<String> vpcId;

    /**
     * @return The VPC that streaming instances will connect to.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> vpcId() {
        return this.vpcId;
    }

    private NetworkSettingsArgs() {}

    private NetworkSettingsArgs(NetworkSettingsArgs $) {
        this.securityGroupIds = $.securityGroupIds;
        this.subnetIds = $.subnetIds;
        this.tags = $.tags;
        this.vpcId = $.vpcId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(NetworkSettingsArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private NetworkSettingsArgs $;

        public Builder() {
            $ = new NetworkSettingsArgs();
        }

        public Builder(NetworkSettingsArgs defaults) {
            $ = new NetworkSettingsArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param securityGroupIds One or more security groups used to control access from streaming instances to your VPC.
         * 
         * @return builder
         * 
         */
        public Builder securityGroupIds(Output<List<String>> securityGroupIds) {
            $.securityGroupIds = securityGroupIds;
            return this;
        }

        /**
         * @param securityGroupIds One or more security groups used to control access from streaming instances to your VPC.
         * 
         * @return builder
         * 
         */
        public Builder securityGroupIds(List<String> securityGroupIds) {
            return securityGroupIds(Output.of(securityGroupIds));
        }

        /**
         * @param securityGroupIds One or more security groups used to control access from streaming instances to your VPC.
         * 
         * @return builder
         * 
         */
        public Builder securityGroupIds(String... securityGroupIds) {
            return securityGroupIds(List.of(securityGroupIds));
        }

        /**
         * @param subnetIds The subnets in which network interfaces are created to connect streaming instances to your VPC. At least two subnet ids must be specified.
         * 
         * @return builder
         * 
         */
        public Builder subnetIds(Output<List<String>> subnetIds) {
            $.subnetIds = subnetIds;
            return this;
        }

        /**
         * @param subnetIds The subnets in which network interfaces are created to connect streaming instances to your VPC. At least two subnet ids must be specified.
         * 
         * @return builder
         * 
         */
        public Builder subnetIds(List<String> subnetIds) {
            return subnetIds(Output.of(subnetIds));
        }

        /**
         * @param subnetIds The subnets in which network interfaces are created to connect streaming instances to your VPC. At least two subnet ids must be specified.
         * 
         * @return builder
         * 
         */
        public Builder subnetIds(String... subnetIds) {
            return subnetIds(List.of(subnetIds));
        }

        /**
         * @param tags Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param vpcId The VPC that streaming instances will connect to.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder vpcId(Output<String> vpcId) {
            $.vpcId = vpcId;
            return this;
        }

        /**
         * @param vpcId The VPC that streaming instances will connect to.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder vpcId(String vpcId) {
            return vpcId(Output.of(vpcId));
        }

        public NetworkSettingsArgs build() {
            if ($.securityGroupIds == null) {
                throw new MissingRequiredPropertyException("NetworkSettingsArgs", "securityGroupIds");
            }
            if ($.subnetIds == null) {
                throw new MissingRequiredPropertyException("NetworkSettingsArgs", "subnetIds");
            }
            if ($.vpcId == null) {
                throw new MissingRequiredPropertyException("NetworkSettingsArgs", "vpcId");
            }
            return $;
        }
    }

}
