// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetRouteResult {
    private String carrierGatewayId;
    private String coreNetworkArn;
    private String destinationCidrBlock;
    private String destinationIpv6CidrBlock;
    private String destinationPrefixListId;
    private String egressOnlyGatewayId;
    private String gatewayId;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    private String instanceId;
    private String localGatewayId;
    private String natGatewayId;
    private String networkInterfaceId;
    private String routeTableId;
    private String transitGatewayId;
    private String vpcPeeringConnectionId;

    private GetRouteResult() {}
    public String carrierGatewayId() {
        return this.carrierGatewayId;
    }
    public String coreNetworkArn() {
        return this.coreNetworkArn;
    }
    public String destinationCidrBlock() {
        return this.destinationCidrBlock;
    }
    public String destinationIpv6CidrBlock() {
        return this.destinationIpv6CidrBlock;
    }
    public String destinationPrefixListId() {
        return this.destinationPrefixListId;
    }
    public String egressOnlyGatewayId() {
        return this.egressOnlyGatewayId;
    }
    public String gatewayId() {
        return this.gatewayId;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    public String instanceId() {
        return this.instanceId;
    }
    public String localGatewayId() {
        return this.localGatewayId;
    }
    public String natGatewayId() {
        return this.natGatewayId;
    }
    public String networkInterfaceId() {
        return this.networkInterfaceId;
    }
    public String routeTableId() {
        return this.routeTableId;
    }
    public String transitGatewayId() {
        return this.transitGatewayId;
    }
    public String vpcPeeringConnectionId() {
        return this.vpcPeeringConnectionId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetRouteResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String carrierGatewayId;
        private String coreNetworkArn;
        private String destinationCidrBlock;
        private String destinationIpv6CidrBlock;
        private String destinationPrefixListId;
        private String egressOnlyGatewayId;
        private String gatewayId;
        private String id;
        private String instanceId;
        private String localGatewayId;
        private String natGatewayId;
        private String networkInterfaceId;
        private String routeTableId;
        private String transitGatewayId;
        private String vpcPeeringConnectionId;
        public Builder() {}
        public Builder(GetRouteResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.carrierGatewayId = defaults.carrierGatewayId;
    	      this.coreNetworkArn = defaults.coreNetworkArn;
    	      this.destinationCidrBlock = defaults.destinationCidrBlock;
    	      this.destinationIpv6CidrBlock = defaults.destinationIpv6CidrBlock;
    	      this.destinationPrefixListId = defaults.destinationPrefixListId;
    	      this.egressOnlyGatewayId = defaults.egressOnlyGatewayId;
    	      this.gatewayId = defaults.gatewayId;
    	      this.id = defaults.id;
    	      this.instanceId = defaults.instanceId;
    	      this.localGatewayId = defaults.localGatewayId;
    	      this.natGatewayId = defaults.natGatewayId;
    	      this.networkInterfaceId = defaults.networkInterfaceId;
    	      this.routeTableId = defaults.routeTableId;
    	      this.transitGatewayId = defaults.transitGatewayId;
    	      this.vpcPeeringConnectionId = defaults.vpcPeeringConnectionId;
        }

        @CustomType.Setter
        public Builder carrierGatewayId(String carrierGatewayId) {
            if (carrierGatewayId == null) {
              throw new MissingRequiredPropertyException("GetRouteResult", "carrierGatewayId");
            }
            this.carrierGatewayId = carrierGatewayId;
            return this;
        }
        @CustomType.Setter
        public Builder coreNetworkArn(String coreNetworkArn) {
            if (coreNetworkArn == null) {
              throw new MissingRequiredPropertyException("GetRouteResult", "coreNetworkArn");
            }
            this.coreNetworkArn = coreNetworkArn;
            return this;
        }
        @CustomType.Setter
        public Builder destinationCidrBlock(String destinationCidrBlock) {
            if (destinationCidrBlock == null) {
              throw new MissingRequiredPropertyException("GetRouteResult", "destinationCidrBlock");
            }
            this.destinationCidrBlock = destinationCidrBlock;
            return this;
        }
        @CustomType.Setter
        public Builder destinationIpv6CidrBlock(String destinationIpv6CidrBlock) {
            if (destinationIpv6CidrBlock == null) {
              throw new MissingRequiredPropertyException("GetRouteResult", "destinationIpv6CidrBlock");
            }
            this.destinationIpv6CidrBlock = destinationIpv6CidrBlock;
            return this;
        }
        @CustomType.Setter
        public Builder destinationPrefixListId(String destinationPrefixListId) {
            if (destinationPrefixListId == null) {
              throw new MissingRequiredPropertyException("GetRouteResult", "destinationPrefixListId");
            }
            this.destinationPrefixListId = destinationPrefixListId;
            return this;
        }
        @CustomType.Setter
        public Builder egressOnlyGatewayId(String egressOnlyGatewayId) {
            if (egressOnlyGatewayId == null) {
              throw new MissingRequiredPropertyException("GetRouteResult", "egressOnlyGatewayId");
            }
            this.egressOnlyGatewayId = egressOnlyGatewayId;
            return this;
        }
        @CustomType.Setter
        public Builder gatewayId(String gatewayId) {
            if (gatewayId == null) {
              throw new MissingRequiredPropertyException("GetRouteResult", "gatewayId");
            }
            this.gatewayId = gatewayId;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetRouteResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder instanceId(String instanceId) {
            if (instanceId == null) {
              throw new MissingRequiredPropertyException("GetRouteResult", "instanceId");
            }
            this.instanceId = instanceId;
            return this;
        }
        @CustomType.Setter
        public Builder localGatewayId(String localGatewayId) {
            if (localGatewayId == null) {
              throw new MissingRequiredPropertyException("GetRouteResult", "localGatewayId");
            }
            this.localGatewayId = localGatewayId;
            return this;
        }
        @CustomType.Setter
        public Builder natGatewayId(String natGatewayId) {
            if (natGatewayId == null) {
              throw new MissingRequiredPropertyException("GetRouteResult", "natGatewayId");
            }
            this.natGatewayId = natGatewayId;
            return this;
        }
        @CustomType.Setter
        public Builder networkInterfaceId(String networkInterfaceId) {
            if (networkInterfaceId == null) {
              throw new MissingRequiredPropertyException("GetRouteResult", "networkInterfaceId");
            }
            this.networkInterfaceId = networkInterfaceId;
            return this;
        }
        @CustomType.Setter
        public Builder routeTableId(String routeTableId) {
            if (routeTableId == null) {
              throw new MissingRequiredPropertyException("GetRouteResult", "routeTableId");
            }
            this.routeTableId = routeTableId;
            return this;
        }
        @CustomType.Setter
        public Builder transitGatewayId(String transitGatewayId) {
            if (transitGatewayId == null) {
              throw new MissingRequiredPropertyException("GetRouteResult", "transitGatewayId");
            }
            this.transitGatewayId = transitGatewayId;
            return this;
        }
        @CustomType.Setter
        public Builder vpcPeeringConnectionId(String vpcPeeringConnectionId) {
            if (vpcPeeringConnectionId == null) {
              throw new MissingRequiredPropertyException("GetRouteResult", "vpcPeeringConnectionId");
            }
            this.vpcPeeringConnectionId = vpcPeeringConnectionId;
            return this;
        }
        public GetRouteResult build() {
            final var _resultValue = new GetRouteResult();
            _resultValue.carrierGatewayId = carrierGatewayId;
            _resultValue.coreNetworkArn = coreNetworkArn;
            _resultValue.destinationCidrBlock = destinationCidrBlock;
            _resultValue.destinationIpv6CidrBlock = destinationIpv6CidrBlock;
            _resultValue.destinationPrefixListId = destinationPrefixListId;
            _resultValue.egressOnlyGatewayId = egressOnlyGatewayId;
            _resultValue.gatewayId = gatewayId;
            _resultValue.id = id;
            _resultValue.instanceId = instanceId;
            _resultValue.localGatewayId = localGatewayId;
            _resultValue.natGatewayId = natGatewayId;
            _resultValue.networkInterfaceId = networkInterfaceId;
            _resultValue.routeTableId = routeTableId;
            _resultValue.transitGatewayId = transitGatewayId;
            _resultValue.vpcPeeringConnectionId = vpcPeeringConnectionId;
            return _resultValue;
        }
    }
}
