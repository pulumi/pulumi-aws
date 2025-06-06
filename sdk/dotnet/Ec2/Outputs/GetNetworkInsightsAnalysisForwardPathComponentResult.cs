// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2.Outputs
{

    [OutputType]
    public sealed class GetNetworkInsightsAnalysisForwardPathComponentResult
    {
        public readonly ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentAclRuleResult> AclRules;
        public readonly ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentAdditionalDetailResult> AdditionalDetails;
        public readonly ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentAttachedToResult> AttachedTos;
        public readonly ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentComponentResult> Components;
        public readonly ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentDestinationVpcResult> DestinationVpcs;
        public readonly ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentInboundHeaderResult> InboundHeaders;
        public readonly ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentOutboundHeaderResult> OutboundHeaders;
        public readonly ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentRouteTableRouteResult> RouteTableRoutes;
        public readonly ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentSecurityGroupRuleResult> SecurityGroupRules;
        public readonly int SequenceNumber;
        public readonly ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentSourceVpcResult> SourceVpcs;
        public readonly ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentSubnetResult> Subnets;
        public readonly ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentTransitGatewayRouteTableRouteResult> TransitGatewayRouteTableRoutes;
        public readonly ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentTransitGatewayResult> TransitGateways;
        public readonly ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentVpcResult> Vpcs;

        [OutputConstructor]
        private GetNetworkInsightsAnalysisForwardPathComponentResult(
            ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentAclRuleResult> aclRules,

            ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentAdditionalDetailResult> additionalDetails,

            ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentAttachedToResult> attachedTos,

            ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentComponentResult> components,

            ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentDestinationVpcResult> destinationVpcs,

            ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentInboundHeaderResult> inboundHeaders,

            ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentOutboundHeaderResult> outboundHeaders,

            ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentRouteTableRouteResult> routeTableRoutes,

            ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentSecurityGroupRuleResult> securityGroupRules,

            int sequenceNumber,

            ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentSourceVpcResult> sourceVpcs,

            ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentSubnetResult> subnets,

            ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentTransitGatewayRouteTableRouteResult> transitGatewayRouteTableRoutes,

            ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentTransitGatewayResult> transitGateways,

            ImmutableArray<Outputs.GetNetworkInsightsAnalysisForwardPathComponentVpcResult> vpcs)
        {
            AclRules = aclRules;
            AdditionalDetails = additionalDetails;
            AttachedTos = attachedTos;
            Components = components;
            DestinationVpcs = destinationVpcs;
            InboundHeaders = inboundHeaders;
            OutboundHeaders = outboundHeaders;
            RouteTableRoutes = routeTableRoutes;
            SecurityGroupRules = securityGroupRules;
            SequenceNumber = sequenceNumber;
            SourceVpcs = sourceVpcs;
            Subnets = subnets;
            TransitGatewayRouteTableRoutes = transitGatewayRouteTableRoutes;
            TransitGateways = transitGateways;
            Vpcs = vpcs;
        }
    }
}
