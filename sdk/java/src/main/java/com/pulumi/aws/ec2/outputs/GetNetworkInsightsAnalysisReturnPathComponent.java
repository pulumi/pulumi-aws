// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.outputs;

import com.pulumi.aws.ec2.outputs.GetNetworkInsightsAnalysisReturnPathComponentAclRule;
import com.pulumi.aws.ec2.outputs.GetNetworkInsightsAnalysisReturnPathComponentAdditionalDetail;
import com.pulumi.aws.ec2.outputs.GetNetworkInsightsAnalysisReturnPathComponentAttachedTo;
import com.pulumi.aws.ec2.outputs.GetNetworkInsightsAnalysisReturnPathComponentComponent;
import com.pulumi.aws.ec2.outputs.GetNetworkInsightsAnalysisReturnPathComponentDestinationVpc;
import com.pulumi.aws.ec2.outputs.GetNetworkInsightsAnalysisReturnPathComponentInboundHeader;
import com.pulumi.aws.ec2.outputs.GetNetworkInsightsAnalysisReturnPathComponentOutboundHeader;
import com.pulumi.aws.ec2.outputs.GetNetworkInsightsAnalysisReturnPathComponentRouteTableRoute;
import com.pulumi.aws.ec2.outputs.GetNetworkInsightsAnalysisReturnPathComponentSecurityGroupRule;
import com.pulumi.aws.ec2.outputs.GetNetworkInsightsAnalysisReturnPathComponentSourceVpc;
import com.pulumi.aws.ec2.outputs.GetNetworkInsightsAnalysisReturnPathComponentSubnet;
import com.pulumi.aws.ec2.outputs.GetNetworkInsightsAnalysisReturnPathComponentTransitGateway;
import com.pulumi.aws.ec2.outputs.GetNetworkInsightsAnalysisReturnPathComponentTransitGatewayRouteTableRoute;
import com.pulumi.aws.ec2.outputs.GetNetworkInsightsAnalysisReturnPathComponentVpc;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetNetworkInsightsAnalysisReturnPathComponent {
    private List<GetNetworkInsightsAnalysisReturnPathComponentAclRule> aclRules;
    private List<GetNetworkInsightsAnalysisReturnPathComponentAdditionalDetail> additionalDetails;
    private List<GetNetworkInsightsAnalysisReturnPathComponentAttachedTo> attachedTos;
    private List<GetNetworkInsightsAnalysisReturnPathComponentComponent> components;
    private List<GetNetworkInsightsAnalysisReturnPathComponentDestinationVpc> destinationVpcs;
    private List<GetNetworkInsightsAnalysisReturnPathComponentInboundHeader> inboundHeaders;
    private List<GetNetworkInsightsAnalysisReturnPathComponentOutboundHeader> outboundHeaders;
    private List<GetNetworkInsightsAnalysisReturnPathComponentRouteTableRoute> routeTableRoutes;
    private List<GetNetworkInsightsAnalysisReturnPathComponentSecurityGroupRule> securityGroupRules;
    private Integer sequenceNumber;
    private List<GetNetworkInsightsAnalysisReturnPathComponentSourceVpc> sourceVpcs;
    private List<GetNetworkInsightsAnalysisReturnPathComponentSubnet> subnets;
    private List<GetNetworkInsightsAnalysisReturnPathComponentTransitGatewayRouteTableRoute> transitGatewayRouteTableRoutes;
    private List<GetNetworkInsightsAnalysisReturnPathComponentTransitGateway> transitGateways;
    private List<GetNetworkInsightsAnalysisReturnPathComponentVpc> vpcs;

    private GetNetworkInsightsAnalysisReturnPathComponent() {}
    public List<GetNetworkInsightsAnalysisReturnPathComponentAclRule> aclRules() {
        return this.aclRules;
    }
    public List<GetNetworkInsightsAnalysisReturnPathComponentAdditionalDetail> additionalDetails() {
        return this.additionalDetails;
    }
    public List<GetNetworkInsightsAnalysisReturnPathComponentAttachedTo> attachedTos() {
        return this.attachedTos;
    }
    public List<GetNetworkInsightsAnalysisReturnPathComponentComponent> components() {
        return this.components;
    }
    public List<GetNetworkInsightsAnalysisReturnPathComponentDestinationVpc> destinationVpcs() {
        return this.destinationVpcs;
    }
    public List<GetNetworkInsightsAnalysisReturnPathComponentInboundHeader> inboundHeaders() {
        return this.inboundHeaders;
    }
    public List<GetNetworkInsightsAnalysisReturnPathComponentOutboundHeader> outboundHeaders() {
        return this.outboundHeaders;
    }
    public List<GetNetworkInsightsAnalysisReturnPathComponentRouteTableRoute> routeTableRoutes() {
        return this.routeTableRoutes;
    }
    public List<GetNetworkInsightsAnalysisReturnPathComponentSecurityGroupRule> securityGroupRules() {
        return this.securityGroupRules;
    }
    public Integer sequenceNumber() {
        return this.sequenceNumber;
    }
    public List<GetNetworkInsightsAnalysisReturnPathComponentSourceVpc> sourceVpcs() {
        return this.sourceVpcs;
    }
    public List<GetNetworkInsightsAnalysisReturnPathComponentSubnet> subnets() {
        return this.subnets;
    }
    public List<GetNetworkInsightsAnalysisReturnPathComponentTransitGatewayRouteTableRoute> transitGatewayRouteTableRoutes() {
        return this.transitGatewayRouteTableRoutes;
    }
    public List<GetNetworkInsightsAnalysisReturnPathComponentTransitGateway> transitGateways() {
        return this.transitGateways;
    }
    public List<GetNetworkInsightsAnalysisReturnPathComponentVpc> vpcs() {
        return this.vpcs;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetNetworkInsightsAnalysisReturnPathComponent defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetNetworkInsightsAnalysisReturnPathComponentAclRule> aclRules;
        private List<GetNetworkInsightsAnalysisReturnPathComponentAdditionalDetail> additionalDetails;
        private List<GetNetworkInsightsAnalysisReturnPathComponentAttachedTo> attachedTos;
        private List<GetNetworkInsightsAnalysisReturnPathComponentComponent> components;
        private List<GetNetworkInsightsAnalysisReturnPathComponentDestinationVpc> destinationVpcs;
        private List<GetNetworkInsightsAnalysisReturnPathComponentInboundHeader> inboundHeaders;
        private List<GetNetworkInsightsAnalysisReturnPathComponentOutboundHeader> outboundHeaders;
        private List<GetNetworkInsightsAnalysisReturnPathComponentRouteTableRoute> routeTableRoutes;
        private List<GetNetworkInsightsAnalysisReturnPathComponentSecurityGroupRule> securityGroupRules;
        private Integer sequenceNumber;
        private List<GetNetworkInsightsAnalysisReturnPathComponentSourceVpc> sourceVpcs;
        private List<GetNetworkInsightsAnalysisReturnPathComponentSubnet> subnets;
        private List<GetNetworkInsightsAnalysisReturnPathComponentTransitGatewayRouteTableRoute> transitGatewayRouteTableRoutes;
        private List<GetNetworkInsightsAnalysisReturnPathComponentTransitGateway> transitGateways;
        private List<GetNetworkInsightsAnalysisReturnPathComponentVpc> vpcs;
        public Builder() {}
        public Builder(GetNetworkInsightsAnalysisReturnPathComponent defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.aclRules = defaults.aclRules;
    	      this.additionalDetails = defaults.additionalDetails;
    	      this.attachedTos = defaults.attachedTos;
    	      this.components = defaults.components;
    	      this.destinationVpcs = defaults.destinationVpcs;
    	      this.inboundHeaders = defaults.inboundHeaders;
    	      this.outboundHeaders = defaults.outboundHeaders;
    	      this.routeTableRoutes = defaults.routeTableRoutes;
    	      this.securityGroupRules = defaults.securityGroupRules;
    	      this.sequenceNumber = defaults.sequenceNumber;
    	      this.sourceVpcs = defaults.sourceVpcs;
    	      this.subnets = defaults.subnets;
    	      this.transitGatewayRouteTableRoutes = defaults.transitGatewayRouteTableRoutes;
    	      this.transitGateways = defaults.transitGateways;
    	      this.vpcs = defaults.vpcs;
        }

        @CustomType.Setter
        public Builder aclRules(List<GetNetworkInsightsAnalysisReturnPathComponentAclRule> aclRules) {
            if (aclRules == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisReturnPathComponent", "aclRules");
            }
            this.aclRules = aclRules;
            return this;
        }
        public Builder aclRules(GetNetworkInsightsAnalysisReturnPathComponentAclRule... aclRules) {
            return aclRules(List.of(aclRules));
        }
        @CustomType.Setter
        public Builder additionalDetails(List<GetNetworkInsightsAnalysisReturnPathComponentAdditionalDetail> additionalDetails) {
            if (additionalDetails == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisReturnPathComponent", "additionalDetails");
            }
            this.additionalDetails = additionalDetails;
            return this;
        }
        public Builder additionalDetails(GetNetworkInsightsAnalysisReturnPathComponentAdditionalDetail... additionalDetails) {
            return additionalDetails(List.of(additionalDetails));
        }
        @CustomType.Setter
        public Builder attachedTos(List<GetNetworkInsightsAnalysisReturnPathComponentAttachedTo> attachedTos) {
            if (attachedTos == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisReturnPathComponent", "attachedTos");
            }
            this.attachedTos = attachedTos;
            return this;
        }
        public Builder attachedTos(GetNetworkInsightsAnalysisReturnPathComponentAttachedTo... attachedTos) {
            return attachedTos(List.of(attachedTos));
        }
        @CustomType.Setter
        public Builder components(List<GetNetworkInsightsAnalysisReturnPathComponentComponent> components) {
            if (components == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisReturnPathComponent", "components");
            }
            this.components = components;
            return this;
        }
        public Builder components(GetNetworkInsightsAnalysisReturnPathComponentComponent... components) {
            return components(List.of(components));
        }
        @CustomType.Setter
        public Builder destinationVpcs(List<GetNetworkInsightsAnalysisReturnPathComponentDestinationVpc> destinationVpcs) {
            if (destinationVpcs == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisReturnPathComponent", "destinationVpcs");
            }
            this.destinationVpcs = destinationVpcs;
            return this;
        }
        public Builder destinationVpcs(GetNetworkInsightsAnalysisReturnPathComponentDestinationVpc... destinationVpcs) {
            return destinationVpcs(List.of(destinationVpcs));
        }
        @CustomType.Setter
        public Builder inboundHeaders(List<GetNetworkInsightsAnalysisReturnPathComponentInboundHeader> inboundHeaders) {
            if (inboundHeaders == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisReturnPathComponent", "inboundHeaders");
            }
            this.inboundHeaders = inboundHeaders;
            return this;
        }
        public Builder inboundHeaders(GetNetworkInsightsAnalysisReturnPathComponentInboundHeader... inboundHeaders) {
            return inboundHeaders(List.of(inboundHeaders));
        }
        @CustomType.Setter
        public Builder outboundHeaders(List<GetNetworkInsightsAnalysisReturnPathComponentOutboundHeader> outboundHeaders) {
            if (outboundHeaders == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisReturnPathComponent", "outboundHeaders");
            }
            this.outboundHeaders = outboundHeaders;
            return this;
        }
        public Builder outboundHeaders(GetNetworkInsightsAnalysisReturnPathComponentOutboundHeader... outboundHeaders) {
            return outboundHeaders(List.of(outboundHeaders));
        }
        @CustomType.Setter
        public Builder routeTableRoutes(List<GetNetworkInsightsAnalysisReturnPathComponentRouteTableRoute> routeTableRoutes) {
            if (routeTableRoutes == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisReturnPathComponent", "routeTableRoutes");
            }
            this.routeTableRoutes = routeTableRoutes;
            return this;
        }
        public Builder routeTableRoutes(GetNetworkInsightsAnalysisReturnPathComponentRouteTableRoute... routeTableRoutes) {
            return routeTableRoutes(List.of(routeTableRoutes));
        }
        @CustomType.Setter
        public Builder securityGroupRules(List<GetNetworkInsightsAnalysisReturnPathComponentSecurityGroupRule> securityGroupRules) {
            if (securityGroupRules == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisReturnPathComponent", "securityGroupRules");
            }
            this.securityGroupRules = securityGroupRules;
            return this;
        }
        public Builder securityGroupRules(GetNetworkInsightsAnalysisReturnPathComponentSecurityGroupRule... securityGroupRules) {
            return securityGroupRules(List.of(securityGroupRules));
        }
        @CustomType.Setter
        public Builder sequenceNumber(Integer sequenceNumber) {
            if (sequenceNumber == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisReturnPathComponent", "sequenceNumber");
            }
            this.sequenceNumber = sequenceNumber;
            return this;
        }
        @CustomType.Setter
        public Builder sourceVpcs(List<GetNetworkInsightsAnalysisReturnPathComponentSourceVpc> sourceVpcs) {
            if (sourceVpcs == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisReturnPathComponent", "sourceVpcs");
            }
            this.sourceVpcs = sourceVpcs;
            return this;
        }
        public Builder sourceVpcs(GetNetworkInsightsAnalysisReturnPathComponentSourceVpc... sourceVpcs) {
            return sourceVpcs(List.of(sourceVpcs));
        }
        @CustomType.Setter
        public Builder subnets(List<GetNetworkInsightsAnalysisReturnPathComponentSubnet> subnets) {
            if (subnets == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisReturnPathComponent", "subnets");
            }
            this.subnets = subnets;
            return this;
        }
        public Builder subnets(GetNetworkInsightsAnalysisReturnPathComponentSubnet... subnets) {
            return subnets(List.of(subnets));
        }
        @CustomType.Setter
        public Builder transitGatewayRouteTableRoutes(List<GetNetworkInsightsAnalysisReturnPathComponentTransitGatewayRouteTableRoute> transitGatewayRouteTableRoutes) {
            if (transitGatewayRouteTableRoutes == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisReturnPathComponent", "transitGatewayRouteTableRoutes");
            }
            this.transitGatewayRouteTableRoutes = transitGatewayRouteTableRoutes;
            return this;
        }
        public Builder transitGatewayRouteTableRoutes(GetNetworkInsightsAnalysisReturnPathComponentTransitGatewayRouteTableRoute... transitGatewayRouteTableRoutes) {
            return transitGatewayRouteTableRoutes(List.of(transitGatewayRouteTableRoutes));
        }
        @CustomType.Setter
        public Builder transitGateways(List<GetNetworkInsightsAnalysisReturnPathComponentTransitGateway> transitGateways) {
            if (transitGateways == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisReturnPathComponent", "transitGateways");
            }
            this.transitGateways = transitGateways;
            return this;
        }
        public Builder transitGateways(GetNetworkInsightsAnalysisReturnPathComponentTransitGateway... transitGateways) {
            return transitGateways(List.of(transitGateways));
        }
        @CustomType.Setter
        public Builder vpcs(List<GetNetworkInsightsAnalysisReturnPathComponentVpc> vpcs) {
            if (vpcs == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisReturnPathComponent", "vpcs");
            }
            this.vpcs = vpcs;
            return this;
        }
        public Builder vpcs(GetNetworkInsightsAnalysisReturnPathComponentVpc... vpcs) {
            return vpcs(List.of(vpcs));
        }
        public GetNetworkInsightsAnalysisReturnPathComponent build() {
            final var _resultValue = new GetNetworkInsightsAnalysisReturnPathComponent();
            _resultValue.aclRules = aclRules;
            _resultValue.additionalDetails = additionalDetails;
            _resultValue.attachedTos = attachedTos;
            _resultValue.components = components;
            _resultValue.destinationVpcs = destinationVpcs;
            _resultValue.inboundHeaders = inboundHeaders;
            _resultValue.outboundHeaders = outboundHeaders;
            _resultValue.routeTableRoutes = routeTableRoutes;
            _resultValue.securityGroupRules = securityGroupRules;
            _resultValue.sequenceNumber = sequenceNumber;
            _resultValue.sourceVpcs = sourceVpcs;
            _resultValue.subnets = subnets;
            _resultValue.transitGatewayRouteTableRoutes = transitGatewayRouteTableRoutes;
            _resultValue.transitGateways = transitGateways;
            _resultValue.vpcs = vpcs;
            return _resultValue;
        }
    }
}
