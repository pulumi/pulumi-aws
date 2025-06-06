// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides a resource to manage the [default AWS VPC](http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/default-vpc.html)
 * in the current AWS Region.
 *
 * If you created your AWS account after 2013-12-04 you have a default VPC in each AWS Region.
 *
 * **This is an advanced resource** and has special caveats to be aware of when using it. Please read this document in its entirety before using this resource.
 *
 * The `aws.ec2.DefaultVpc` resource behaves differently from normal resources in that if a default VPC exists, this provider does not _create_ this resource, but instead "adopts" it into management.
 * If no default VPC exists, the provider creates a new default VPC, which leads to the implicit creation of [other resources](https://docs.aws.amazon.com/vpc/latest/userguide/default-vpc.html#default-vpc-components).
 * By default, `pulumi destroy` does not delete the default VPC but does remove the resource from the state.
 * Set the `forceDestroy` argument to `true` to delete the default VPC.
 *
 * ## Example Usage
 *
 * Basic usage with tags:
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const _default = new aws.ec2.DefaultVpc("default", {tags: {
 *     Name: "Default VPC",
 * }});
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Default VPCs using the VPC `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:ec2/defaultVpc:DefaultVpc default vpc-a01106c2
 * ```
 */
export class DefaultVpc extends pulumi.CustomResource {
    /**
     * Get an existing DefaultVpc resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: DefaultVpcState, opts?: pulumi.CustomResourceOptions): DefaultVpc {
        return new DefaultVpc(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ec2/defaultVpc:DefaultVpc';

    /**
     * Returns true if the given object is an instance of DefaultVpc.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is DefaultVpc {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === DefaultVpc.__pulumiType;
    }

    public /*out*/ readonly arn!: pulumi.Output<string>;
    public readonly assignGeneratedIpv6CidrBlock!: pulumi.Output<boolean | undefined>;
    /**
     * The primary IPv4 CIDR block for the VPC
     */
    public /*out*/ readonly cidrBlock!: pulumi.Output<string>;
    public /*out*/ readonly defaultNetworkAclId!: pulumi.Output<string>;
    public /*out*/ readonly defaultRouteTableId!: pulumi.Output<string>;
    public /*out*/ readonly defaultSecurityGroupId!: pulumi.Output<string>;
    public /*out*/ readonly dhcpOptionsId!: pulumi.Output<string>;
    public readonly enableDnsHostnames!: pulumi.Output<boolean | undefined>;
    public readonly enableDnsSupport!: pulumi.Output<boolean | undefined>;
    public readonly enableNetworkAddressUsageMetrics!: pulumi.Output<boolean>;
    public /*out*/ readonly existingDefaultVpc!: pulumi.Output<boolean>;
    /**
     * Whether destroying the resource deletes the default VPC. Default: `false`
     */
    public readonly forceDestroy!: pulumi.Output<boolean | undefined>;
    /**
     * The allowed tenancy of instances launched into the VPC
     */
    public /*out*/ readonly instanceTenancy!: pulumi.Output<string>;
    public /*out*/ readonly ipv6AssociationId!: pulumi.Output<string>;
    public readonly ipv6CidrBlock!: pulumi.Output<string>;
    public readonly ipv6CidrBlockNetworkBorderGroup!: pulumi.Output<string>;
    public readonly ipv6IpamPoolId!: pulumi.Output<string | undefined>;
    public readonly ipv6NetmaskLength!: pulumi.Output<number | undefined>;
    public /*out*/ readonly mainRouteTableId!: pulumi.Output<string>;
    public /*out*/ readonly ownerId!: pulumi.Output<string>;
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;

    /**
     * Create a DefaultVpc resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args?: DefaultVpcArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: DefaultVpcArgs | DefaultVpcState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as DefaultVpcState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["assignGeneratedIpv6CidrBlock"] = state ? state.assignGeneratedIpv6CidrBlock : undefined;
            resourceInputs["cidrBlock"] = state ? state.cidrBlock : undefined;
            resourceInputs["defaultNetworkAclId"] = state ? state.defaultNetworkAclId : undefined;
            resourceInputs["defaultRouteTableId"] = state ? state.defaultRouteTableId : undefined;
            resourceInputs["defaultSecurityGroupId"] = state ? state.defaultSecurityGroupId : undefined;
            resourceInputs["dhcpOptionsId"] = state ? state.dhcpOptionsId : undefined;
            resourceInputs["enableDnsHostnames"] = state ? state.enableDnsHostnames : undefined;
            resourceInputs["enableDnsSupport"] = state ? state.enableDnsSupport : undefined;
            resourceInputs["enableNetworkAddressUsageMetrics"] = state ? state.enableNetworkAddressUsageMetrics : undefined;
            resourceInputs["existingDefaultVpc"] = state ? state.existingDefaultVpc : undefined;
            resourceInputs["forceDestroy"] = state ? state.forceDestroy : undefined;
            resourceInputs["instanceTenancy"] = state ? state.instanceTenancy : undefined;
            resourceInputs["ipv6AssociationId"] = state ? state.ipv6AssociationId : undefined;
            resourceInputs["ipv6CidrBlock"] = state ? state.ipv6CidrBlock : undefined;
            resourceInputs["ipv6CidrBlockNetworkBorderGroup"] = state ? state.ipv6CidrBlockNetworkBorderGroup : undefined;
            resourceInputs["ipv6IpamPoolId"] = state ? state.ipv6IpamPoolId : undefined;
            resourceInputs["ipv6NetmaskLength"] = state ? state.ipv6NetmaskLength : undefined;
            resourceInputs["mainRouteTableId"] = state ? state.mainRouteTableId : undefined;
            resourceInputs["ownerId"] = state ? state.ownerId : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as DefaultVpcArgs | undefined;
            resourceInputs["assignGeneratedIpv6CidrBlock"] = args ? args.assignGeneratedIpv6CidrBlock : undefined;
            resourceInputs["enableDnsHostnames"] = args ? args.enableDnsHostnames : undefined;
            resourceInputs["enableDnsSupport"] = args ? args.enableDnsSupport : undefined;
            resourceInputs["enableNetworkAddressUsageMetrics"] = args ? args.enableNetworkAddressUsageMetrics : undefined;
            resourceInputs["forceDestroy"] = args ? args.forceDestroy : undefined;
            resourceInputs["ipv6CidrBlock"] = args ? args.ipv6CidrBlock : undefined;
            resourceInputs["ipv6CidrBlockNetworkBorderGroup"] = args ? args.ipv6CidrBlockNetworkBorderGroup : undefined;
            resourceInputs["ipv6IpamPoolId"] = args ? args.ipv6IpamPoolId : undefined;
            resourceInputs["ipv6NetmaskLength"] = args ? args.ipv6NetmaskLength : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["cidrBlock"] = undefined /*out*/;
            resourceInputs["defaultNetworkAclId"] = undefined /*out*/;
            resourceInputs["defaultRouteTableId"] = undefined /*out*/;
            resourceInputs["defaultSecurityGroupId"] = undefined /*out*/;
            resourceInputs["dhcpOptionsId"] = undefined /*out*/;
            resourceInputs["existingDefaultVpc"] = undefined /*out*/;
            resourceInputs["instanceTenancy"] = undefined /*out*/;
            resourceInputs["ipv6AssociationId"] = undefined /*out*/;
            resourceInputs["mainRouteTableId"] = undefined /*out*/;
            resourceInputs["ownerId"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(DefaultVpc.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering DefaultVpc resources.
 */
export interface DefaultVpcState {
    arn?: pulumi.Input<string>;
    assignGeneratedIpv6CidrBlock?: pulumi.Input<boolean>;
    /**
     * The primary IPv4 CIDR block for the VPC
     */
    cidrBlock?: pulumi.Input<string>;
    defaultNetworkAclId?: pulumi.Input<string>;
    defaultRouteTableId?: pulumi.Input<string>;
    defaultSecurityGroupId?: pulumi.Input<string>;
    dhcpOptionsId?: pulumi.Input<string>;
    enableDnsHostnames?: pulumi.Input<boolean>;
    enableDnsSupport?: pulumi.Input<boolean>;
    enableNetworkAddressUsageMetrics?: pulumi.Input<boolean>;
    existingDefaultVpc?: pulumi.Input<boolean>;
    /**
     * Whether destroying the resource deletes the default VPC. Default: `false`
     */
    forceDestroy?: pulumi.Input<boolean>;
    /**
     * The allowed tenancy of instances launched into the VPC
     */
    instanceTenancy?: pulumi.Input<string>;
    ipv6AssociationId?: pulumi.Input<string>;
    ipv6CidrBlock?: pulumi.Input<string>;
    ipv6CidrBlockNetworkBorderGroup?: pulumi.Input<string>;
    ipv6IpamPoolId?: pulumi.Input<string>;
    ipv6NetmaskLength?: pulumi.Input<number>;
    mainRouteTableId?: pulumi.Input<string>;
    ownerId?: pulumi.Input<string>;
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}

/**
 * The set of arguments for constructing a DefaultVpc resource.
 */
export interface DefaultVpcArgs {
    assignGeneratedIpv6CidrBlock?: pulumi.Input<boolean>;
    enableDnsHostnames?: pulumi.Input<boolean>;
    enableDnsSupport?: pulumi.Input<boolean>;
    enableNetworkAddressUsageMetrics?: pulumi.Input<boolean>;
    /**
     * Whether destroying the resource deletes the default VPC. Default: `false`
     */
    forceDestroy?: pulumi.Input<boolean>;
    ipv6CidrBlock?: pulumi.Input<string>;
    ipv6CidrBlockNetworkBorderGroup?: pulumi.Input<string>;
    ipv6IpamPoolId?: pulumi.Input<string>;
    ipv6NetmaskLength?: pulumi.Input<number>;
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
