// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.inputs;

import com.pulumi.aws.ec2.inputs.PeeringConnectionOptionsAccepterArgs;
import com.pulumi.aws.ec2.inputs.PeeringConnectionOptionsRequesterArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class PeeringConnectionOptionsState extends com.pulumi.resources.ResourceArgs {

    public static final PeeringConnectionOptionsState Empty = new PeeringConnectionOptionsState();

    /**
     * An optional configuration block that allows for [VPC Peering Connection](https://docs.aws.amazon.com/vpc/latest/peering/what-is-vpc-peering.html) options to be set for the VPC that accepts the peering connection (a maximum of one).
     * 
     */
    @Import(name="accepter")
    private @Nullable Output<PeeringConnectionOptionsAccepterArgs> accepter;

    /**
     * @return An optional configuration block that allows for [VPC Peering Connection](https://docs.aws.amazon.com/vpc/latest/peering/what-is-vpc-peering.html) options to be set for the VPC that accepts the peering connection (a maximum of one).
     * 
     */
    public Optional<Output<PeeringConnectionOptionsAccepterArgs>> accepter() {
        return Optional.ofNullable(this.accepter);
    }

    /**
     * A optional configuration block that allows for [VPC Peering Connection](https://docs.aws.amazon.com/vpc/latest/peering/what-is-vpc-peering.html) options to be set for the VPC that requests the peering connection (a maximum of one).
     * 
     */
    @Import(name="requester")
    private @Nullable Output<PeeringConnectionOptionsRequesterArgs> requester;

    /**
     * @return A optional configuration block that allows for [VPC Peering Connection](https://docs.aws.amazon.com/vpc/latest/peering/what-is-vpc-peering.html) options to be set for the VPC that requests the peering connection (a maximum of one).
     * 
     */
    public Optional<Output<PeeringConnectionOptionsRequesterArgs>> requester() {
        return Optional.ofNullable(this.requester);
    }

    /**
     * The ID of the requester VPC peering connection.
     * 
     */
    @Import(name="vpcPeeringConnectionId")
    private @Nullable Output<String> vpcPeeringConnectionId;

    /**
     * @return The ID of the requester VPC peering connection.
     * 
     */
    public Optional<Output<String>> vpcPeeringConnectionId() {
        return Optional.ofNullable(this.vpcPeeringConnectionId);
    }

    private PeeringConnectionOptionsState() {}

    private PeeringConnectionOptionsState(PeeringConnectionOptionsState $) {
        this.accepter = $.accepter;
        this.requester = $.requester;
        this.vpcPeeringConnectionId = $.vpcPeeringConnectionId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(PeeringConnectionOptionsState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private PeeringConnectionOptionsState $;

        public Builder() {
            $ = new PeeringConnectionOptionsState();
        }

        public Builder(PeeringConnectionOptionsState defaults) {
            $ = new PeeringConnectionOptionsState(Objects.requireNonNull(defaults));
        }

        /**
         * @param accepter An optional configuration block that allows for [VPC Peering Connection](https://docs.aws.amazon.com/vpc/latest/peering/what-is-vpc-peering.html) options to be set for the VPC that accepts the peering connection (a maximum of one).
         * 
         * @return builder
         * 
         */
        public Builder accepter(@Nullable Output<PeeringConnectionOptionsAccepterArgs> accepter) {
            $.accepter = accepter;
            return this;
        }

        /**
         * @param accepter An optional configuration block that allows for [VPC Peering Connection](https://docs.aws.amazon.com/vpc/latest/peering/what-is-vpc-peering.html) options to be set for the VPC that accepts the peering connection (a maximum of one).
         * 
         * @return builder
         * 
         */
        public Builder accepter(PeeringConnectionOptionsAccepterArgs accepter) {
            return accepter(Output.of(accepter));
        }

        /**
         * @param requester A optional configuration block that allows for [VPC Peering Connection](https://docs.aws.amazon.com/vpc/latest/peering/what-is-vpc-peering.html) options to be set for the VPC that requests the peering connection (a maximum of one).
         * 
         * @return builder
         * 
         */
        public Builder requester(@Nullable Output<PeeringConnectionOptionsRequesterArgs> requester) {
            $.requester = requester;
            return this;
        }

        /**
         * @param requester A optional configuration block that allows for [VPC Peering Connection](https://docs.aws.amazon.com/vpc/latest/peering/what-is-vpc-peering.html) options to be set for the VPC that requests the peering connection (a maximum of one).
         * 
         * @return builder
         * 
         */
        public Builder requester(PeeringConnectionOptionsRequesterArgs requester) {
            return requester(Output.of(requester));
        }

        /**
         * @param vpcPeeringConnectionId The ID of the requester VPC peering connection.
         * 
         * @return builder
         * 
         */
        public Builder vpcPeeringConnectionId(@Nullable Output<String> vpcPeeringConnectionId) {
            $.vpcPeeringConnectionId = vpcPeeringConnectionId;
            return this;
        }

        /**
         * @param vpcPeeringConnectionId The ID of the requester VPC peering connection.
         * 
         * @return builder
         * 
         */
        public Builder vpcPeeringConnectionId(String vpcPeeringConnectionId) {
            return vpcPeeringConnectionId(Output.of(vpcPeeringConnectionId));
        }

        public PeeringConnectionOptionsState build() {
            return $;
        }
    }

}
