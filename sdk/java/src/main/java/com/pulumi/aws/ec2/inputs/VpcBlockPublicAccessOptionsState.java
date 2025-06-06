// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.inputs;

import com.pulumi.aws.ec2.inputs.VpcBlockPublicAccessOptionsTimeoutsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class VpcBlockPublicAccessOptionsState extends com.pulumi.resources.ResourceArgs {

    public static final VpcBlockPublicAccessOptionsState Empty = new VpcBlockPublicAccessOptionsState();

    /**
     * The AWS account id to which these options apply.
     * 
     */
    @Import(name="awsAccountId")
    private @Nullable Output<String> awsAccountId;

    /**
     * @return The AWS account id to which these options apply.
     * 
     */
    public Optional<Output<String>> awsAccountId() {
        return Optional.ofNullable(this.awsAccountId);
    }

    /**
     * The AWS region to which these options apply.
     * 
     */
    @Import(name="awsRegion")
    private @Nullable Output<String> awsRegion;

    /**
     * @return The AWS region to which these options apply.
     * 
     */
    public Optional<Output<String>> awsRegion() {
        return Optional.ofNullable(this.awsRegion);
    }

    /**
     * Block mode. Needs to be one of `block-bidirectional`, `block-ingress`, `off`. If this resource is deleted, then this value will be set to `off` in the AWS account and region.
     * 
     */
    @Import(name="internetGatewayBlockMode")
    private @Nullable Output<String> internetGatewayBlockMode;

    /**
     * @return Block mode. Needs to be one of `block-bidirectional`, `block-ingress`, `off`. If this resource is deleted, then this value will be set to `off` in the AWS account and region.
     * 
     */
    public Optional<Output<String>> internetGatewayBlockMode() {
        return Optional.ofNullable(this.internetGatewayBlockMode);
    }

    @Import(name="timeouts")
    private @Nullable Output<VpcBlockPublicAccessOptionsTimeoutsArgs> timeouts;

    public Optional<Output<VpcBlockPublicAccessOptionsTimeoutsArgs>> timeouts() {
        return Optional.ofNullable(this.timeouts);
    }

    private VpcBlockPublicAccessOptionsState() {}

    private VpcBlockPublicAccessOptionsState(VpcBlockPublicAccessOptionsState $) {
        this.awsAccountId = $.awsAccountId;
        this.awsRegion = $.awsRegion;
        this.internetGatewayBlockMode = $.internetGatewayBlockMode;
        this.timeouts = $.timeouts;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(VpcBlockPublicAccessOptionsState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private VpcBlockPublicAccessOptionsState $;

        public Builder() {
            $ = new VpcBlockPublicAccessOptionsState();
        }

        public Builder(VpcBlockPublicAccessOptionsState defaults) {
            $ = new VpcBlockPublicAccessOptionsState(Objects.requireNonNull(defaults));
        }

        /**
         * @param awsAccountId The AWS account id to which these options apply.
         * 
         * @return builder
         * 
         */
        public Builder awsAccountId(@Nullable Output<String> awsAccountId) {
            $.awsAccountId = awsAccountId;
            return this;
        }

        /**
         * @param awsAccountId The AWS account id to which these options apply.
         * 
         * @return builder
         * 
         */
        public Builder awsAccountId(String awsAccountId) {
            return awsAccountId(Output.of(awsAccountId));
        }

        /**
         * @param awsRegion The AWS region to which these options apply.
         * 
         * @return builder
         * 
         */
        public Builder awsRegion(@Nullable Output<String> awsRegion) {
            $.awsRegion = awsRegion;
            return this;
        }

        /**
         * @param awsRegion The AWS region to which these options apply.
         * 
         * @return builder
         * 
         */
        public Builder awsRegion(String awsRegion) {
            return awsRegion(Output.of(awsRegion));
        }

        /**
         * @param internetGatewayBlockMode Block mode. Needs to be one of `block-bidirectional`, `block-ingress`, `off`. If this resource is deleted, then this value will be set to `off` in the AWS account and region.
         * 
         * @return builder
         * 
         */
        public Builder internetGatewayBlockMode(@Nullable Output<String> internetGatewayBlockMode) {
            $.internetGatewayBlockMode = internetGatewayBlockMode;
            return this;
        }

        /**
         * @param internetGatewayBlockMode Block mode. Needs to be one of `block-bidirectional`, `block-ingress`, `off`. If this resource is deleted, then this value will be set to `off` in the AWS account and region.
         * 
         * @return builder
         * 
         */
        public Builder internetGatewayBlockMode(String internetGatewayBlockMode) {
            return internetGatewayBlockMode(Output.of(internetGatewayBlockMode));
        }

        public Builder timeouts(@Nullable Output<VpcBlockPublicAccessOptionsTimeoutsArgs> timeouts) {
            $.timeouts = timeouts;
            return this;
        }

        public Builder timeouts(VpcBlockPublicAccessOptionsTimeoutsArgs timeouts) {
            return timeouts(Output.of(timeouts));
        }

        public VpcBlockPublicAccessOptionsState build() {
            return $;
        }
    }

}
