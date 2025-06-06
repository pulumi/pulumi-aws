// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Authorizes a VPC in a different account to be associated with a local Route53 Hosted Zone.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.ec2.Vpc("example", {
 *     cidrBlock: "10.6.0.0/16",
 *     enableDnsHostnames: true,
 *     enableDnsSupport: true,
 * });
 * const exampleZone = new aws.route53.Zone("example", {
 *     name: "example.com",
 *     vpcs: [{
 *         vpcId: example.id,
 *     }],
 * });
 * const alternate = new aws.ec2.Vpc("alternate", {
 *     cidrBlock: "10.7.0.0/16",
 *     enableDnsHostnames: true,
 *     enableDnsSupport: true,
 * });
 * const exampleVpcAssociationAuthorization = new aws.route53.VpcAssociationAuthorization("example", {
 *     vpcId: alternate.id,
 *     zoneId: exampleZone.id,
 * });
 * const exampleZoneAssociation = new aws.route53.ZoneAssociation("example", {
 *     vpcId: exampleVpcAssociationAuthorization.vpcId,
 *     zoneId: exampleVpcAssociationAuthorization.zoneId,
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Route 53 VPC Association Authorizations using the Hosted Zone ID and VPC ID, separated by a colon (`:`). For example:
 *
 * ```sh
 * $ pulumi import aws:route53/vpcAssociationAuthorization:VpcAssociationAuthorization example Z123456ABCDEFG:vpc-12345678
 * ```
 */
export class VpcAssociationAuthorization extends pulumi.CustomResource {
    /**
     * Get an existing VpcAssociationAuthorization resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: VpcAssociationAuthorizationState, opts?: pulumi.CustomResourceOptions): VpcAssociationAuthorization {
        return new VpcAssociationAuthorization(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:route53/vpcAssociationAuthorization:VpcAssociationAuthorization';

    /**
     * Returns true if the given object is an instance of VpcAssociationAuthorization.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is VpcAssociationAuthorization {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === VpcAssociationAuthorization.__pulumiType;
    }

    /**
     * The VPC to authorize for association with the private hosted zone.
     */
    public readonly vpcId!: pulumi.Output<string>;
    /**
     * The VPC's region. Defaults to the region of the AWS provider.
     */
    public readonly vpcRegion!: pulumi.Output<string>;
    /**
     * The ID of the private hosted zone that you want to authorize associating a VPC with.
     */
    public readonly zoneId!: pulumi.Output<string>;

    /**
     * Create a VpcAssociationAuthorization resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: VpcAssociationAuthorizationArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: VpcAssociationAuthorizationArgs | VpcAssociationAuthorizationState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as VpcAssociationAuthorizationState | undefined;
            resourceInputs["vpcId"] = state ? state.vpcId : undefined;
            resourceInputs["vpcRegion"] = state ? state.vpcRegion : undefined;
            resourceInputs["zoneId"] = state ? state.zoneId : undefined;
        } else {
            const args = argsOrState as VpcAssociationAuthorizationArgs | undefined;
            if ((!args || args.vpcId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'vpcId'");
            }
            if ((!args || args.zoneId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'zoneId'");
            }
            resourceInputs["vpcId"] = args ? args.vpcId : undefined;
            resourceInputs["vpcRegion"] = args ? args.vpcRegion : undefined;
            resourceInputs["zoneId"] = args ? args.zoneId : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(VpcAssociationAuthorization.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering VpcAssociationAuthorization resources.
 */
export interface VpcAssociationAuthorizationState {
    /**
     * The VPC to authorize for association with the private hosted zone.
     */
    vpcId?: pulumi.Input<string>;
    /**
     * The VPC's region. Defaults to the region of the AWS provider.
     */
    vpcRegion?: pulumi.Input<string>;
    /**
     * The ID of the private hosted zone that you want to authorize associating a VPC with.
     */
    zoneId?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a VpcAssociationAuthorization resource.
 */
export interface VpcAssociationAuthorizationArgs {
    /**
     * The VPC to authorize for association with the private hosted zone.
     */
    vpcId: pulumi.Input<string>;
    /**
     * The VPC's region. Defaults to the region of the AWS provider.
     */
    vpcRegion?: pulumi.Input<string>;
    /**
     * The ID of the private hosted zone that you want to authorize associating a VPC with.
     */
    zoneId: pulumi.Input<string>;
}
