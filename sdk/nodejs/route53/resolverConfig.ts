// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides a Route 53 Resolver config resource.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.ec2.Vpc("example", {
 *     cidrBlock: "10.0.0.0/16",
 *     enableDnsSupport: true,
 *     enableDnsHostnames: true,
 * });
 * const exampleResolverConfig = new aws.route53.ResolverConfig("example", {
 *     resourceId: example.id,
 *     autodefinedReverseFlag: "DISABLE",
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Route 53 Resolver configs using the Route 53 Resolver config ID. For example:
 *
 * ```sh
 * $ pulumi import aws:route53/resolverConfig:ResolverConfig example rslvr-rc-715aa20c73a23da7
 * ```
 */
export class ResolverConfig extends pulumi.CustomResource {
    /**
     * Get an existing ResolverConfig resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ResolverConfigState, opts?: pulumi.CustomResourceOptions): ResolverConfig {
        return new ResolverConfig(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:route53/resolverConfig:ResolverConfig';

    /**
     * Returns true if the given object is an instance of ResolverConfig.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is ResolverConfig {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === ResolverConfig.__pulumiType;
    }

    /**
     * Indicates whether or not the Resolver will create autodefined rules for reverse DNS lookups. Valid values: `ENABLE`, `DISABLE`.
     */
    public readonly autodefinedReverseFlag!: pulumi.Output<string>;
    /**
     * The AWS account ID of the owner of the VPC that this resolver configuration applies to.
     */
    public /*out*/ readonly ownerId!: pulumi.Output<string>;
    /**
     * The ID of the VPC that the configuration is for.
     */
    public readonly resourceId!: pulumi.Output<string>;

    /**
     * Create a ResolverConfig resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: ResolverConfigArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ResolverConfigArgs | ResolverConfigState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ResolverConfigState | undefined;
            resourceInputs["autodefinedReverseFlag"] = state ? state.autodefinedReverseFlag : undefined;
            resourceInputs["ownerId"] = state ? state.ownerId : undefined;
            resourceInputs["resourceId"] = state ? state.resourceId : undefined;
        } else {
            const args = argsOrState as ResolverConfigArgs | undefined;
            if ((!args || args.autodefinedReverseFlag === undefined) && !opts.urn) {
                throw new Error("Missing required property 'autodefinedReverseFlag'");
            }
            if ((!args || args.resourceId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'resourceId'");
            }
            resourceInputs["autodefinedReverseFlag"] = args ? args.autodefinedReverseFlag : undefined;
            resourceInputs["resourceId"] = args ? args.resourceId : undefined;
            resourceInputs["ownerId"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(ResolverConfig.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering ResolverConfig resources.
 */
export interface ResolverConfigState {
    /**
     * Indicates whether or not the Resolver will create autodefined rules for reverse DNS lookups. Valid values: `ENABLE`, `DISABLE`.
     */
    autodefinedReverseFlag?: pulumi.Input<string>;
    /**
     * The AWS account ID of the owner of the VPC that this resolver configuration applies to.
     */
    ownerId?: pulumi.Input<string>;
    /**
     * The ID of the VPC that the configuration is for.
     */
    resourceId?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a ResolverConfig resource.
 */
export interface ResolverConfigArgs {
    /**
     * Indicates whether or not the Resolver will create autodefined rules for reverse DNS lookups. Valid values: `ENABLE`, `DISABLE`.
     */
    autodefinedReverseFlag: pulumi.Input<string>;
    /**
     * The ID of the VPC that the configuration is for.
     */
    resourceId: pulumi.Input<string>;
}
