// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.vpc;

import com.pulumi.aws.vpc.inputs.SecurityGroupVpcAssociationTimeoutsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class SecurityGroupVpcAssociationArgs extends com.pulumi.resources.ResourceArgs {

    public static final SecurityGroupVpcAssociationArgs Empty = new SecurityGroupVpcAssociationArgs();

    /**
     * The ID of the security group.
     * 
     */
    @Import(name="securityGroupId", required=true)
    private Output<String> securityGroupId;

    /**
     * @return The ID of the security group.
     * 
     */
    public Output<String> securityGroupId() {
        return this.securityGroupId;
    }

    @Import(name="timeouts")
    private @Nullable Output<SecurityGroupVpcAssociationTimeoutsArgs> timeouts;

    public Optional<Output<SecurityGroupVpcAssociationTimeoutsArgs>> timeouts() {
        return Optional.ofNullable(this.timeouts);
    }

    /**
     * The ID of the VPC to make the association with.
     * 
     */
    @Import(name="vpcId", required=true)
    private Output<String> vpcId;

    /**
     * @return The ID of the VPC to make the association with.
     * 
     */
    public Output<String> vpcId() {
        return this.vpcId;
    }

    private SecurityGroupVpcAssociationArgs() {}

    private SecurityGroupVpcAssociationArgs(SecurityGroupVpcAssociationArgs $) {
        this.securityGroupId = $.securityGroupId;
        this.timeouts = $.timeouts;
        this.vpcId = $.vpcId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(SecurityGroupVpcAssociationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private SecurityGroupVpcAssociationArgs $;

        public Builder() {
            $ = new SecurityGroupVpcAssociationArgs();
        }

        public Builder(SecurityGroupVpcAssociationArgs defaults) {
            $ = new SecurityGroupVpcAssociationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param securityGroupId The ID of the security group.
         * 
         * @return builder
         * 
         */
        public Builder securityGroupId(Output<String> securityGroupId) {
            $.securityGroupId = securityGroupId;
            return this;
        }

        /**
         * @param securityGroupId The ID of the security group.
         * 
         * @return builder
         * 
         */
        public Builder securityGroupId(String securityGroupId) {
            return securityGroupId(Output.of(securityGroupId));
        }

        public Builder timeouts(@Nullable Output<SecurityGroupVpcAssociationTimeoutsArgs> timeouts) {
            $.timeouts = timeouts;
            return this;
        }

        public Builder timeouts(SecurityGroupVpcAssociationTimeoutsArgs timeouts) {
            return timeouts(Output.of(timeouts));
        }

        /**
         * @param vpcId The ID of the VPC to make the association with.
         * 
         * @return builder
         * 
         */
        public Builder vpcId(Output<String> vpcId) {
            $.vpcId = vpcId;
            return this;
        }

        /**
         * @param vpcId The ID of the VPC to make the association with.
         * 
         * @return builder
         * 
         */
        public Builder vpcId(String vpcId) {
            return vpcId(Output.of(vpcId));
        }

        public SecurityGroupVpcAssociationArgs build() {
            if ($.securityGroupId == null) {
                throw new MissingRequiredPropertyException("SecurityGroupVpcAssociationArgs", "securityGroupId");
            }
            if ($.vpcId == null) {
                throw new MissingRequiredPropertyException("SecurityGroupVpcAssociationArgs", "vpcId");
            }
            return $;
        }
    }

}
