// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetRouteArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetRouteArgs Empty = new GetRouteArgs();

    /**
     * EC2 Carrier Gateway ID of the Route belonging to the Route Table.
     * 
     */
    @Import(name="carrierGatewayId")
    private @Nullable Output<String> carrierGatewayId;

    /**
     * @return EC2 Carrier Gateway ID of the Route belonging to the Route Table.
     * 
     */
    public Optional<Output<String>> carrierGatewayId() {
        return Optional.ofNullable(this.carrierGatewayId);
    }

    /**
     * Core network ARN of the Route belonging to the Route Table.
     * 
     */
    @Import(name="coreNetworkArn")
    private @Nullable Output<String> coreNetworkArn;

    /**
     * @return Core network ARN of the Route belonging to the Route Table.
     * 
     */
    public Optional<Output<String>> coreNetworkArn() {
        return Optional.ofNullable(this.coreNetworkArn);
    }

    /**
     * CIDR block of the Route belonging to the Route Table.
     * 
     */
    @Import(name="destinationCidrBlock")
    private @Nullable Output<String> destinationCidrBlock;

    /**
     * @return CIDR block of the Route belonging to the Route Table.
     * 
     */
    public Optional<Output<String>> destinationCidrBlock() {
        return Optional.ofNullable(this.destinationCidrBlock);
    }

    /**
     * IPv6 CIDR block of the Route belonging to the Route Table.
     * 
     */
    @Import(name="destinationIpv6CidrBlock")
    private @Nullable Output<String> destinationIpv6CidrBlock;

    /**
     * @return IPv6 CIDR block of the Route belonging to the Route Table.
     * 
     */
    public Optional<Output<String>> destinationIpv6CidrBlock() {
        return Optional.ofNullable(this.destinationIpv6CidrBlock);
    }

    /**
     * ID of a managed prefix list destination of the Route belonging to the Route Table.
     * 
     */
    @Import(name="destinationPrefixListId")
    private @Nullable Output<String> destinationPrefixListId;

    /**
     * @return ID of a managed prefix list destination of the Route belonging to the Route Table.
     * 
     */
    public Optional<Output<String>> destinationPrefixListId() {
        return Optional.ofNullable(this.destinationPrefixListId);
    }

    /**
     * Egress Only Gateway ID of the Route belonging to the Route Table.
     * 
     */
    @Import(name="egressOnlyGatewayId")
    private @Nullable Output<String> egressOnlyGatewayId;

    /**
     * @return Egress Only Gateway ID of the Route belonging to the Route Table.
     * 
     */
    public Optional<Output<String>> egressOnlyGatewayId() {
        return Optional.ofNullable(this.egressOnlyGatewayId);
    }

    /**
     * Gateway ID of the Route belonging to the Route Table.
     * 
     */
    @Import(name="gatewayId")
    private @Nullable Output<String> gatewayId;

    /**
     * @return Gateway ID of the Route belonging to the Route Table.
     * 
     */
    public Optional<Output<String>> gatewayId() {
        return Optional.ofNullable(this.gatewayId);
    }

    /**
     * Instance ID of the Route belonging to the Route Table.
     * 
     */
    @Import(name="instanceId")
    private @Nullable Output<String> instanceId;

    /**
     * @return Instance ID of the Route belonging to the Route Table.
     * 
     */
    public Optional<Output<String>> instanceId() {
        return Optional.ofNullable(this.instanceId);
    }

    /**
     * Local Gateway ID of the Route belonging to the Route Table.
     * 
     */
    @Import(name="localGatewayId")
    private @Nullable Output<String> localGatewayId;

    /**
     * @return Local Gateway ID of the Route belonging to the Route Table.
     * 
     */
    public Optional<Output<String>> localGatewayId() {
        return Optional.ofNullable(this.localGatewayId);
    }

    /**
     * NAT Gateway ID of the Route belonging to the Route Table.
     * 
     */
    @Import(name="natGatewayId")
    private @Nullable Output<String> natGatewayId;

    /**
     * @return NAT Gateway ID of the Route belonging to the Route Table.
     * 
     */
    public Optional<Output<String>> natGatewayId() {
        return Optional.ofNullable(this.natGatewayId);
    }

    /**
     * Network Interface ID of the Route belonging to the Route Table.
     * 
     */
    @Import(name="networkInterfaceId")
    private @Nullable Output<String> networkInterfaceId;

    /**
     * @return Network Interface ID of the Route belonging to the Route Table.
     * 
     */
    public Optional<Output<String>> networkInterfaceId() {
        return Optional.ofNullable(this.networkInterfaceId);
    }

    /**
     * ID of the specific Route Table containing the Route entry.
     * 
     */
    @Import(name="routeTableId", required=true)
    private Output<String> routeTableId;

    /**
     * @return ID of the specific Route Table containing the Route entry.
     * 
     */
    public Output<String> routeTableId() {
        return this.routeTableId;
    }

    /**
     * EC2 Transit Gateway ID of the Route belonging to the Route Table.
     * 
     */
    @Import(name="transitGatewayId")
    private @Nullable Output<String> transitGatewayId;

    /**
     * @return EC2 Transit Gateway ID of the Route belonging to the Route Table.
     * 
     */
    public Optional<Output<String>> transitGatewayId() {
        return Optional.ofNullable(this.transitGatewayId);
    }

    /**
     * VPC Peering Connection ID of the Route belonging to the Route Table.
     * 
     * The arguments of this data source act as filters for querying the available Route in the current region. The given filters must match exactly oneRoute whose data will be exported as attributes.
     * 
     */
    @Import(name="vpcPeeringConnectionId")
    private @Nullable Output<String> vpcPeeringConnectionId;

    /**
     * @return VPC Peering Connection ID of the Route belonging to the Route Table.
     * 
     * The arguments of this data source act as filters for querying the available Route in the current region. The given filters must match exactly oneRoute whose data will be exported as attributes.
     * 
     */
    public Optional<Output<String>> vpcPeeringConnectionId() {
        return Optional.ofNullable(this.vpcPeeringConnectionId);
    }

    private GetRouteArgs() {}

    private GetRouteArgs(GetRouteArgs $) {
        this.carrierGatewayId = $.carrierGatewayId;
        this.coreNetworkArn = $.coreNetworkArn;
        this.destinationCidrBlock = $.destinationCidrBlock;
        this.destinationIpv6CidrBlock = $.destinationIpv6CidrBlock;
        this.destinationPrefixListId = $.destinationPrefixListId;
        this.egressOnlyGatewayId = $.egressOnlyGatewayId;
        this.gatewayId = $.gatewayId;
        this.instanceId = $.instanceId;
        this.localGatewayId = $.localGatewayId;
        this.natGatewayId = $.natGatewayId;
        this.networkInterfaceId = $.networkInterfaceId;
        this.routeTableId = $.routeTableId;
        this.transitGatewayId = $.transitGatewayId;
        this.vpcPeeringConnectionId = $.vpcPeeringConnectionId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetRouteArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetRouteArgs $;

        public Builder() {
            $ = new GetRouteArgs();
        }

        public Builder(GetRouteArgs defaults) {
            $ = new GetRouteArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param carrierGatewayId EC2 Carrier Gateway ID of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder carrierGatewayId(@Nullable Output<String> carrierGatewayId) {
            $.carrierGatewayId = carrierGatewayId;
            return this;
        }

        /**
         * @param carrierGatewayId EC2 Carrier Gateway ID of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder carrierGatewayId(String carrierGatewayId) {
            return carrierGatewayId(Output.of(carrierGatewayId));
        }

        /**
         * @param coreNetworkArn Core network ARN of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder coreNetworkArn(@Nullable Output<String> coreNetworkArn) {
            $.coreNetworkArn = coreNetworkArn;
            return this;
        }

        /**
         * @param coreNetworkArn Core network ARN of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder coreNetworkArn(String coreNetworkArn) {
            return coreNetworkArn(Output.of(coreNetworkArn));
        }

        /**
         * @param destinationCidrBlock CIDR block of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder destinationCidrBlock(@Nullable Output<String> destinationCidrBlock) {
            $.destinationCidrBlock = destinationCidrBlock;
            return this;
        }

        /**
         * @param destinationCidrBlock CIDR block of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder destinationCidrBlock(String destinationCidrBlock) {
            return destinationCidrBlock(Output.of(destinationCidrBlock));
        }

        /**
         * @param destinationIpv6CidrBlock IPv6 CIDR block of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder destinationIpv6CidrBlock(@Nullable Output<String> destinationIpv6CidrBlock) {
            $.destinationIpv6CidrBlock = destinationIpv6CidrBlock;
            return this;
        }

        /**
         * @param destinationIpv6CidrBlock IPv6 CIDR block of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder destinationIpv6CidrBlock(String destinationIpv6CidrBlock) {
            return destinationIpv6CidrBlock(Output.of(destinationIpv6CidrBlock));
        }

        /**
         * @param destinationPrefixListId ID of a managed prefix list destination of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder destinationPrefixListId(@Nullable Output<String> destinationPrefixListId) {
            $.destinationPrefixListId = destinationPrefixListId;
            return this;
        }

        /**
         * @param destinationPrefixListId ID of a managed prefix list destination of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder destinationPrefixListId(String destinationPrefixListId) {
            return destinationPrefixListId(Output.of(destinationPrefixListId));
        }

        /**
         * @param egressOnlyGatewayId Egress Only Gateway ID of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder egressOnlyGatewayId(@Nullable Output<String> egressOnlyGatewayId) {
            $.egressOnlyGatewayId = egressOnlyGatewayId;
            return this;
        }

        /**
         * @param egressOnlyGatewayId Egress Only Gateway ID of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder egressOnlyGatewayId(String egressOnlyGatewayId) {
            return egressOnlyGatewayId(Output.of(egressOnlyGatewayId));
        }

        /**
         * @param gatewayId Gateway ID of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder gatewayId(@Nullable Output<String> gatewayId) {
            $.gatewayId = gatewayId;
            return this;
        }

        /**
         * @param gatewayId Gateway ID of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder gatewayId(String gatewayId) {
            return gatewayId(Output.of(gatewayId));
        }

        /**
         * @param instanceId Instance ID of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder instanceId(@Nullable Output<String> instanceId) {
            $.instanceId = instanceId;
            return this;
        }

        /**
         * @param instanceId Instance ID of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder instanceId(String instanceId) {
            return instanceId(Output.of(instanceId));
        }

        /**
         * @param localGatewayId Local Gateway ID of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder localGatewayId(@Nullable Output<String> localGatewayId) {
            $.localGatewayId = localGatewayId;
            return this;
        }

        /**
         * @param localGatewayId Local Gateway ID of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder localGatewayId(String localGatewayId) {
            return localGatewayId(Output.of(localGatewayId));
        }

        /**
         * @param natGatewayId NAT Gateway ID of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder natGatewayId(@Nullable Output<String> natGatewayId) {
            $.natGatewayId = natGatewayId;
            return this;
        }

        /**
         * @param natGatewayId NAT Gateway ID of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder natGatewayId(String natGatewayId) {
            return natGatewayId(Output.of(natGatewayId));
        }

        /**
         * @param networkInterfaceId Network Interface ID of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder networkInterfaceId(@Nullable Output<String> networkInterfaceId) {
            $.networkInterfaceId = networkInterfaceId;
            return this;
        }

        /**
         * @param networkInterfaceId Network Interface ID of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder networkInterfaceId(String networkInterfaceId) {
            return networkInterfaceId(Output.of(networkInterfaceId));
        }

        /**
         * @param routeTableId ID of the specific Route Table containing the Route entry.
         * 
         * @return builder
         * 
         */
        public Builder routeTableId(Output<String> routeTableId) {
            $.routeTableId = routeTableId;
            return this;
        }

        /**
         * @param routeTableId ID of the specific Route Table containing the Route entry.
         * 
         * @return builder
         * 
         */
        public Builder routeTableId(String routeTableId) {
            return routeTableId(Output.of(routeTableId));
        }

        /**
         * @param transitGatewayId EC2 Transit Gateway ID of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder transitGatewayId(@Nullable Output<String> transitGatewayId) {
            $.transitGatewayId = transitGatewayId;
            return this;
        }

        /**
         * @param transitGatewayId EC2 Transit Gateway ID of the Route belonging to the Route Table.
         * 
         * @return builder
         * 
         */
        public Builder transitGatewayId(String transitGatewayId) {
            return transitGatewayId(Output.of(transitGatewayId));
        }

        /**
         * @param vpcPeeringConnectionId VPC Peering Connection ID of the Route belonging to the Route Table.
         * 
         * The arguments of this data source act as filters for querying the available Route in the current region. The given filters must match exactly oneRoute whose data will be exported as attributes.
         * 
         * @return builder
         * 
         */
        public Builder vpcPeeringConnectionId(@Nullable Output<String> vpcPeeringConnectionId) {
            $.vpcPeeringConnectionId = vpcPeeringConnectionId;
            return this;
        }

        /**
         * @param vpcPeeringConnectionId VPC Peering Connection ID of the Route belonging to the Route Table.
         * 
         * The arguments of this data source act as filters for querying the available Route in the current region. The given filters must match exactly oneRoute whose data will be exported as attributes.
         * 
         * @return builder
         * 
         */
        public Builder vpcPeeringConnectionId(String vpcPeeringConnectionId) {
            return vpcPeeringConnectionId(Output.of(vpcPeeringConnectionId));
        }

        public GetRouteArgs build() {
            if ($.routeTableId == null) {
                throw new MissingRequiredPropertyException("GetRouteArgs", "routeTableId");
            }
            return $;
        }
    }

}
