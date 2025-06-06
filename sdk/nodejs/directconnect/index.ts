// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

// Export members:
export { BgpPeerArgs, BgpPeerState } from "./bgpPeer";
export type BgpPeer = import("./bgpPeer").BgpPeer;
export const BgpPeer: typeof import("./bgpPeer").BgpPeer = null as any;
utilities.lazyLoad(exports, ["BgpPeer"], () => require("./bgpPeer"));

export { ConnectionArgs, ConnectionState } from "./connection";
export type Connection = import("./connection").Connection;
export const Connection: typeof import("./connection").Connection = null as any;
utilities.lazyLoad(exports, ["Connection"], () => require("./connection"));

export { ConnectionAssociationArgs, ConnectionAssociationState } from "./connectionAssociation";
export type ConnectionAssociation = import("./connectionAssociation").ConnectionAssociation;
export const ConnectionAssociation: typeof import("./connectionAssociation").ConnectionAssociation = null as any;
utilities.lazyLoad(exports, ["ConnectionAssociation"], () => require("./connectionAssociation"));

export { ConnectionConfirmationArgs, ConnectionConfirmationState } from "./connectionConfirmation";
export type ConnectionConfirmation = import("./connectionConfirmation").ConnectionConfirmation;
export const ConnectionConfirmation: typeof import("./connectionConfirmation").ConnectionConfirmation = null as any;
utilities.lazyLoad(exports, ["ConnectionConfirmation"], () => require("./connectionConfirmation"));

export { GatewayArgs, GatewayState } from "./gateway";
export type Gateway = import("./gateway").Gateway;
export const Gateway: typeof import("./gateway").Gateway = null as any;
utilities.lazyLoad(exports, ["Gateway"], () => require("./gateway"));

export { GatewayAssociationArgs, GatewayAssociationState } from "./gatewayAssociation";
export type GatewayAssociation = import("./gatewayAssociation").GatewayAssociation;
export const GatewayAssociation: typeof import("./gatewayAssociation").GatewayAssociation = null as any;
utilities.lazyLoad(exports, ["GatewayAssociation"], () => require("./gatewayAssociation"));

export { GatewayAssociationProposalArgs, GatewayAssociationProposalState } from "./gatewayAssociationProposal";
export type GatewayAssociationProposal = import("./gatewayAssociationProposal").GatewayAssociationProposal;
export const GatewayAssociationProposal: typeof import("./gatewayAssociationProposal").GatewayAssociationProposal = null as any;
utilities.lazyLoad(exports, ["GatewayAssociationProposal"], () => require("./gatewayAssociationProposal"));

export { GetConnectionArgs, GetConnectionResult, GetConnectionOutputArgs } from "./getConnection";
export const getConnection: typeof import("./getConnection").getConnection = null as any;
export const getConnectionOutput: typeof import("./getConnection").getConnectionOutput = null as any;
utilities.lazyLoad(exports, ["getConnection","getConnectionOutput"], () => require("./getConnection"));

export { GetGatewayArgs, GetGatewayResult, GetGatewayOutputArgs } from "./getGateway";
export const getGateway: typeof import("./getGateway").getGateway = null as any;
export const getGatewayOutput: typeof import("./getGateway").getGatewayOutput = null as any;
utilities.lazyLoad(exports, ["getGateway","getGatewayOutput"], () => require("./getGateway"));

export { GetLocationArgs, GetLocationResult, GetLocationOutputArgs } from "./getLocation";
export const getLocation: typeof import("./getLocation").getLocation = null as any;
export const getLocationOutput: typeof import("./getLocation").getLocationOutput = null as any;
utilities.lazyLoad(exports, ["getLocation","getLocationOutput"], () => require("./getLocation"));

export { GetLocationsResult } from "./getLocations";
export const getLocations: typeof import("./getLocations").getLocations = null as any;
export const getLocationsOutput: typeof import("./getLocations").getLocationsOutput = null as any;
utilities.lazyLoad(exports, ["getLocations","getLocationsOutput"], () => require("./getLocations"));

export { GetRouterConfigurationArgs, GetRouterConfigurationResult, GetRouterConfigurationOutputArgs } from "./getRouterConfiguration";
export const getRouterConfiguration: typeof import("./getRouterConfiguration").getRouterConfiguration = null as any;
export const getRouterConfigurationOutput: typeof import("./getRouterConfiguration").getRouterConfigurationOutput = null as any;
utilities.lazyLoad(exports, ["getRouterConfiguration","getRouterConfigurationOutput"], () => require("./getRouterConfiguration"));

export { HostedConnectionArgs, HostedConnectionState } from "./hostedConnection";
export type HostedConnection = import("./hostedConnection").HostedConnection;
export const HostedConnection: typeof import("./hostedConnection").HostedConnection = null as any;
utilities.lazyLoad(exports, ["HostedConnection"], () => require("./hostedConnection"));

export { HostedPrivateVirtualInterfaceArgs, HostedPrivateVirtualInterfaceState } from "./hostedPrivateVirtualInterface";
export type HostedPrivateVirtualInterface = import("./hostedPrivateVirtualInterface").HostedPrivateVirtualInterface;
export const HostedPrivateVirtualInterface: typeof import("./hostedPrivateVirtualInterface").HostedPrivateVirtualInterface = null as any;
utilities.lazyLoad(exports, ["HostedPrivateVirtualInterface"], () => require("./hostedPrivateVirtualInterface"));

export { HostedPrivateVirtualInterfaceAccepterArgs, HostedPrivateVirtualInterfaceAccepterState } from "./hostedPrivateVirtualInterfaceAccepter";
export type HostedPrivateVirtualInterfaceAccepter = import("./hostedPrivateVirtualInterfaceAccepter").HostedPrivateVirtualInterfaceAccepter;
export const HostedPrivateVirtualInterfaceAccepter: typeof import("./hostedPrivateVirtualInterfaceAccepter").HostedPrivateVirtualInterfaceAccepter = null as any;
utilities.lazyLoad(exports, ["HostedPrivateVirtualInterfaceAccepter"], () => require("./hostedPrivateVirtualInterfaceAccepter"));

export { HostedPublicVirtualInterfaceArgs, HostedPublicVirtualInterfaceState } from "./hostedPublicVirtualInterface";
export type HostedPublicVirtualInterface = import("./hostedPublicVirtualInterface").HostedPublicVirtualInterface;
export const HostedPublicVirtualInterface: typeof import("./hostedPublicVirtualInterface").HostedPublicVirtualInterface = null as any;
utilities.lazyLoad(exports, ["HostedPublicVirtualInterface"], () => require("./hostedPublicVirtualInterface"));

export { HostedPublicVirtualInterfaceAccepterArgs, HostedPublicVirtualInterfaceAccepterState } from "./hostedPublicVirtualInterfaceAccepter";
export type HostedPublicVirtualInterfaceAccepter = import("./hostedPublicVirtualInterfaceAccepter").HostedPublicVirtualInterfaceAccepter;
export const HostedPublicVirtualInterfaceAccepter: typeof import("./hostedPublicVirtualInterfaceAccepter").HostedPublicVirtualInterfaceAccepter = null as any;
utilities.lazyLoad(exports, ["HostedPublicVirtualInterfaceAccepter"], () => require("./hostedPublicVirtualInterfaceAccepter"));

export { HostedTransitVirtualInterfaceArgs, HostedTransitVirtualInterfaceState } from "./hostedTransitVirtualInterface";
export type HostedTransitVirtualInterface = import("./hostedTransitVirtualInterface").HostedTransitVirtualInterface;
export const HostedTransitVirtualInterface: typeof import("./hostedTransitVirtualInterface").HostedTransitVirtualInterface = null as any;
utilities.lazyLoad(exports, ["HostedTransitVirtualInterface"], () => require("./hostedTransitVirtualInterface"));

export { HostedTransitVirtualInterfaceAcceptorArgs, HostedTransitVirtualInterfaceAcceptorState } from "./hostedTransitVirtualInterfaceAcceptor";
export type HostedTransitVirtualInterfaceAcceptor = import("./hostedTransitVirtualInterfaceAcceptor").HostedTransitVirtualInterfaceAcceptor;
export const HostedTransitVirtualInterfaceAcceptor: typeof import("./hostedTransitVirtualInterfaceAcceptor").HostedTransitVirtualInterfaceAcceptor = null as any;
utilities.lazyLoad(exports, ["HostedTransitVirtualInterfaceAcceptor"], () => require("./hostedTransitVirtualInterfaceAcceptor"));

export { LinkAggregationGroupArgs, LinkAggregationGroupState } from "./linkAggregationGroup";
export type LinkAggregationGroup = import("./linkAggregationGroup").LinkAggregationGroup;
export const LinkAggregationGroup: typeof import("./linkAggregationGroup").LinkAggregationGroup = null as any;
utilities.lazyLoad(exports, ["LinkAggregationGroup"], () => require("./linkAggregationGroup"));

export { MacsecKeyAssociationArgs, MacsecKeyAssociationState } from "./macsecKeyAssociation";
export type MacsecKeyAssociation = import("./macsecKeyAssociation").MacsecKeyAssociation;
export const MacsecKeyAssociation: typeof import("./macsecKeyAssociation").MacsecKeyAssociation = null as any;
utilities.lazyLoad(exports, ["MacsecKeyAssociation"], () => require("./macsecKeyAssociation"));

export { PrivateVirtualInterfaceArgs, PrivateVirtualInterfaceState } from "./privateVirtualInterface";
export type PrivateVirtualInterface = import("./privateVirtualInterface").PrivateVirtualInterface;
export const PrivateVirtualInterface: typeof import("./privateVirtualInterface").PrivateVirtualInterface = null as any;
utilities.lazyLoad(exports, ["PrivateVirtualInterface"], () => require("./privateVirtualInterface"));

export { PublicVirtualInterfaceArgs, PublicVirtualInterfaceState } from "./publicVirtualInterface";
export type PublicVirtualInterface = import("./publicVirtualInterface").PublicVirtualInterface;
export const PublicVirtualInterface: typeof import("./publicVirtualInterface").PublicVirtualInterface = null as any;
utilities.lazyLoad(exports, ["PublicVirtualInterface"], () => require("./publicVirtualInterface"));

export { TransitVirtualInterfaceArgs, TransitVirtualInterfaceState } from "./transitVirtualInterface";
export type TransitVirtualInterface = import("./transitVirtualInterface").TransitVirtualInterface;
export const TransitVirtualInterface: typeof import("./transitVirtualInterface").TransitVirtualInterface = null as any;
utilities.lazyLoad(exports, ["TransitVirtualInterface"], () => require("./transitVirtualInterface"));


const _module = {
    version: utilities.getVersion(),
    construct: (name: string, type: string, urn: string): pulumi.Resource => {
        switch (type) {
            case "aws:directconnect/bgpPeer:BgpPeer":
                return new BgpPeer(name, <any>undefined, { urn })
            case "aws:directconnect/connection:Connection":
                return new Connection(name, <any>undefined, { urn })
            case "aws:directconnect/connectionAssociation:ConnectionAssociation":
                return new ConnectionAssociation(name, <any>undefined, { urn })
            case "aws:directconnect/connectionConfirmation:ConnectionConfirmation":
                return new ConnectionConfirmation(name, <any>undefined, { urn })
            case "aws:directconnect/gateway:Gateway":
                return new Gateway(name, <any>undefined, { urn })
            case "aws:directconnect/gatewayAssociation:GatewayAssociation":
                return new GatewayAssociation(name, <any>undefined, { urn })
            case "aws:directconnect/gatewayAssociationProposal:GatewayAssociationProposal":
                return new GatewayAssociationProposal(name, <any>undefined, { urn })
            case "aws:directconnect/hostedConnection:HostedConnection":
                return new HostedConnection(name, <any>undefined, { urn })
            case "aws:directconnect/hostedPrivateVirtualInterface:HostedPrivateVirtualInterface":
                return new HostedPrivateVirtualInterface(name, <any>undefined, { urn })
            case "aws:directconnect/hostedPrivateVirtualInterfaceAccepter:HostedPrivateVirtualInterfaceAccepter":
                return new HostedPrivateVirtualInterfaceAccepter(name, <any>undefined, { urn })
            case "aws:directconnect/hostedPublicVirtualInterface:HostedPublicVirtualInterface":
                return new HostedPublicVirtualInterface(name, <any>undefined, { urn })
            case "aws:directconnect/hostedPublicVirtualInterfaceAccepter:HostedPublicVirtualInterfaceAccepter":
                return new HostedPublicVirtualInterfaceAccepter(name, <any>undefined, { urn })
            case "aws:directconnect/hostedTransitVirtualInterface:HostedTransitVirtualInterface":
                return new HostedTransitVirtualInterface(name, <any>undefined, { urn })
            case "aws:directconnect/hostedTransitVirtualInterfaceAcceptor:HostedTransitVirtualInterfaceAcceptor":
                return new HostedTransitVirtualInterfaceAcceptor(name, <any>undefined, { urn })
            case "aws:directconnect/linkAggregationGroup:LinkAggregationGroup":
                return new LinkAggregationGroup(name, <any>undefined, { urn })
            case "aws:directconnect/macsecKeyAssociation:MacsecKeyAssociation":
                return new MacsecKeyAssociation(name, <any>undefined, { urn })
            case "aws:directconnect/privateVirtualInterface:PrivateVirtualInterface":
                return new PrivateVirtualInterface(name, <any>undefined, { urn })
            case "aws:directconnect/publicVirtualInterface:PublicVirtualInterface":
                return new PublicVirtualInterface(name, <any>undefined, { urn })
            case "aws:directconnect/transitVirtualInterface:TransitVirtualInterface":
                return new TransitVirtualInterface(name, <any>undefined, { urn })
            default:
                throw new Error(`unknown resource type ${type}`);
        }
    },
};
pulumi.runtime.registerResourceModule("aws", "directconnect/bgpPeer", _module)
pulumi.runtime.registerResourceModule("aws", "directconnect/connection", _module)
pulumi.runtime.registerResourceModule("aws", "directconnect/connectionAssociation", _module)
pulumi.runtime.registerResourceModule("aws", "directconnect/connectionConfirmation", _module)
pulumi.runtime.registerResourceModule("aws", "directconnect/gateway", _module)
pulumi.runtime.registerResourceModule("aws", "directconnect/gatewayAssociation", _module)
pulumi.runtime.registerResourceModule("aws", "directconnect/gatewayAssociationProposal", _module)
pulumi.runtime.registerResourceModule("aws", "directconnect/hostedConnection", _module)
pulumi.runtime.registerResourceModule("aws", "directconnect/hostedPrivateVirtualInterface", _module)
pulumi.runtime.registerResourceModule("aws", "directconnect/hostedPrivateVirtualInterfaceAccepter", _module)
pulumi.runtime.registerResourceModule("aws", "directconnect/hostedPublicVirtualInterface", _module)
pulumi.runtime.registerResourceModule("aws", "directconnect/hostedPublicVirtualInterfaceAccepter", _module)
pulumi.runtime.registerResourceModule("aws", "directconnect/hostedTransitVirtualInterface", _module)
pulumi.runtime.registerResourceModule("aws", "directconnect/hostedTransitVirtualInterfaceAcceptor", _module)
pulumi.runtime.registerResourceModule("aws", "directconnect/linkAggregationGroup", _module)
pulumi.runtime.registerResourceModule("aws", "directconnect/macsecKeyAssociation", _module)
pulumi.runtime.registerResourceModule("aws", "directconnect/privateVirtualInterface", _module)
pulumi.runtime.registerResourceModule("aws", "directconnect/publicVirtualInterface", _module)
pulumi.runtime.registerResourceModule("aws", "directconnect/transitVirtualInterface", _module)
