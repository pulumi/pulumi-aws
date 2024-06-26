// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class VpcEndpointRouteTableAssociationState extends com.pulumi.resources.ResourceArgs {

    public static final VpcEndpointRouteTableAssociationState Empty = new VpcEndpointRouteTableAssociationState();

    /**
     * Identifier of the EC2 Route Table to be associated with the VPC Endpoint.
     * 
     */
    @Import(name="routeTableId")
    private @Nullable Output<String> routeTableId;

    /**
     * @return Identifier of the EC2 Route Table to be associated with the VPC Endpoint.
     * 
     */
    public Optional<Output<String>> routeTableId() {
        return Optional.ofNullable(this.routeTableId);
    }

    /**
     * Identifier of the VPC Endpoint with which the EC2 Route Table will be associated.
     * 
     */
    @Import(name="vpcEndpointId")
    private @Nullable Output<String> vpcEndpointId;

    /**
     * @return Identifier of the VPC Endpoint with which the EC2 Route Table will be associated.
     * 
     */
    public Optional<Output<String>> vpcEndpointId() {
        return Optional.ofNullable(this.vpcEndpointId);
    }

    private VpcEndpointRouteTableAssociationState() {}

    private VpcEndpointRouteTableAssociationState(VpcEndpointRouteTableAssociationState $) {
        this.routeTableId = $.routeTableId;
        this.vpcEndpointId = $.vpcEndpointId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(VpcEndpointRouteTableAssociationState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private VpcEndpointRouteTableAssociationState $;

        public Builder() {
            $ = new VpcEndpointRouteTableAssociationState();
        }

        public Builder(VpcEndpointRouteTableAssociationState defaults) {
            $ = new VpcEndpointRouteTableAssociationState(Objects.requireNonNull(defaults));
        }

        /**
         * @param routeTableId Identifier of the EC2 Route Table to be associated with the VPC Endpoint.
         * 
         * @return builder
         * 
         */
        public Builder routeTableId(@Nullable Output<String> routeTableId) {
            $.routeTableId = routeTableId;
            return this;
        }

        /**
         * @param routeTableId Identifier of the EC2 Route Table to be associated with the VPC Endpoint.
         * 
         * @return builder
         * 
         */
        public Builder routeTableId(String routeTableId) {
            return routeTableId(Output.of(routeTableId));
        }

        /**
         * @param vpcEndpointId Identifier of the VPC Endpoint with which the EC2 Route Table will be associated.
         * 
         * @return builder
         * 
         */
        public Builder vpcEndpointId(@Nullable Output<String> vpcEndpointId) {
            $.vpcEndpointId = vpcEndpointId;
            return this;
        }

        /**
         * @param vpcEndpointId Identifier of the VPC Endpoint with which the EC2 Route Table will be associated.
         * 
         * @return builder
         * 
         */
        public Builder vpcEndpointId(String vpcEndpointId) {
            return vpcEndpointId(Output.of(vpcEndpointId));
        }

        public VpcEndpointRouteTableAssociationState build() {
            return $;
        }
    }

}
