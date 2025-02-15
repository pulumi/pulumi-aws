// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.inputs;

import com.pulumi.aws.ec2.inputs.VpcBlockPublicAccessExclusionTimeoutsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class VpcBlockPublicAccessExclusionState extends com.pulumi.resources.ResourceArgs {

    public static final VpcBlockPublicAccessExclusionState Empty = new VpcBlockPublicAccessExclusionState();

    /**
     * Mode of exclusion from Block Public Access. The allowed values are `allow-egress` and `allow-bidirectional`.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="internetGatewayExclusionMode")
    private @Nullable Output<String> internetGatewayExclusionMode;

    /**
     * @return Mode of exclusion from Block Public Access. The allowed values are `allow-egress` and `allow-bidirectional`.
     * 
     * The following arguments are optional:
     * 
     */
    public Optional<Output<String>> internetGatewayExclusionMode() {
        return Optional.ofNullable(this.internetGatewayExclusionMode);
    }

    /**
     * The Amazon Resource Name (ARN) the excluded resource.
     * 
     */
    @Import(name="resourceArn")
    private @Nullable Output<String> resourceArn;

    /**
     * @return The Amazon Resource Name (ARN) the excluded resource.
     * 
     */
    public Optional<Output<String>> resourceArn() {
        return Optional.ofNullable(this.resourceArn);
    }

    /**
     * Id of the subnet to which this exclusion applies. Either this or the vpc_id needs to be provided.
     * 
     */
    @Import(name="subnetId")
    private @Nullable Output<String> subnetId;

    /**
     * @return Id of the subnet to which this exclusion applies. Either this or the vpc_id needs to be provided.
     * 
     */
    public Optional<Output<String>> subnetId() {
        return Optional.ofNullable(this.subnetId);
    }

    /**
     * A map of tags to assign to the exclusion. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return A map of tags to assign to the exclusion. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Import(name="tagsAll")
    private @Nullable Output<Map<String,String>> tagsAll;

    /**
     * @return A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    public Optional<Output<Map<String,String>>> tagsAll() {
        return Optional.ofNullable(this.tagsAll);
    }

    @Import(name="timeouts")
    private @Nullable Output<VpcBlockPublicAccessExclusionTimeoutsArgs> timeouts;

    public Optional<Output<VpcBlockPublicAccessExclusionTimeoutsArgs>> timeouts() {
        return Optional.ofNullable(this.timeouts);
    }

    /**
     * Id of the VPC to which this exclusion applies. Either this or the subnet_id needs to be provided.
     * 
     */
    @Import(name="vpcId")
    private @Nullable Output<String> vpcId;

    /**
     * @return Id of the VPC to which this exclusion applies. Either this or the subnet_id needs to be provided.
     * 
     */
    public Optional<Output<String>> vpcId() {
        return Optional.ofNullable(this.vpcId);
    }

    private VpcBlockPublicAccessExclusionState() {}

    private VpcBlockPublicAccessExclusionState(VpcBlockPublicAccessExclusionState $) {
        this.internetGatewayExclusionMode = $.internetGatewayExclusionMode;
        this.resourceArn = $.resourceArn;
        this.subnetId = $.subnetId;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
        this.timeouts = $.timeouts;
        this.vpcId = $.vpcId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(VpcBlockPublicAccessExclusionState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private VpcBlockPublicAccessExclusionState $;

        public Builder() {
            $ = new VpcBlockPublicAccessExclusionState();
        }

        public Builder(VpcBlockPublicAccessExclusionState defaults) {
            $ = new VpcBlockPublicAccessExclusionState(Objects.requireNonNull(defaults));
        }

        /**
         * @param internetGatewayExclusionMode Mode of exclusion from Block Public Access. The allowed values are `allow-egress` and `allow-bidirectional`.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder internetGatewayExclusionMode(@Nullable Output<String> internetGatewayExclusionMode) {
            $.internetGatewayExclusionMode = internetGatewayExclusionMode;
            return this;
        }

        /**
         * @param internetGatewayExclusionMode Mode of exclusion from Block Public Access. The allowed values are `allow-egress` and `allow-bidirectional`.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder internetGatewayExclusionMode(String internetGatewayExclusionMode) {
            return internetGatewayExclusionMode(Output.of(internetGatewayExclusionMode));
        }

        /**
         * @param resourceArn The Amazon Resource Name (ARN) the excluded resource.
         * 
         * @return builder
         * 
         */
        public Builder resourceArn(@Nullable Output<String> resourceArn) {
            $.resourceArn = resourceArn;
            return this;
        }

        /**
         * @param resourceArn The Amazon Resource Name (ARN) the excluded resource.
         * 
         * @return builder
         * 
         */
        public Builder resourceArn(String resourceArn) {
            return resourceArn(Output.of(resourceArn));
        }

        /**
         * @param subnetId Id of the subnet to which this exclusion applies. Either this or the vpc_id needs to be provided.
         * 
         * @return builder
         * 
         */
        public Builder subnetId(@Nullable Output<String> subnetId) {
            $.subnetId = subnetId;
            return this;
        }

        /**
         * @param subnetId Id of the subnet to which this exclusion applies. Either this or the vpc_id needs to be provided.
         * 
         * @return builder
         * 
         */
        public Builder subnetId(String subnetId) {
            return subnetId(Output.of(subnetId));
        }

        /**
         * @param tags A map of tags to assign to the exclusion. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags A map of tags to assign to the exclusion. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param tagsAll A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(@Nullable Output<Map<String,String>> tagsAll) {
            $.tagsAll = tagsAll;
            return this;
        }

        /**
         * @param tagsAll A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(Map<String,String> tagsAll) {
            return tagsAll(Output.of(tagsAll));
        }

        public Builder timeouts(@Nullable Output<VpcBlockPublicAccessExclusionTimeoutsArgs> timeouts) {
            $.timeouts = timeouts;
            return this;
        }

        public Builder timeouts(VpcBlockPublicAccessExclusionTimeoutsArgs timeouts) {
            return timeouts(Output.of(timeouts));
        }

        /**
         * @param vpcId Id of the VPC to which this exclusion applies. Either this or the subnet_id needs to be provided.
         * 
         * @return builder
         * 
         */
        public Builder vpcId(@Nullable Output<String> vpcId) {
            $.vpcId = vpcId;
            return this;
        }

        /**
         * @param vpcId Id of the VPC to which this exclusion applies. Either this or the subnet_id needs to be provided.
         * 
         * @return builder
         * 
         */
        public Builder vpcId(String vpcId) {
            return vpcId(Output.of(vpcId));
        }

        public VpcBlockPublicAccessExclusionState build() {
            return $;
        }
    }

}
