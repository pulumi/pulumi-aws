// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Creates a scope for AWS IPAM.
 *
 * ## Example Usage
 *
 * Basic usage:
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const current = aws.getRegion({});
 * const example = new aws.ec2.VpcIpam("example", {operatingRegions: [{
 *     regionName: current.then(current => current.name),
 * }]});
 * const exampleVpcIpamScope = new aws.ec2.VpcIpamScope("example", {
 *     ipamId: example.id,
 *     description: "Another Scope",
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import IPAMs using the `scope_id`. For example:
 *
 * ```sh
 * $ pulumi import aws:ec2/vpcIpamScope:VpcIpamScope example ipam-scope-0513c69f283d11dfb
 * ```
 */
export class VpcIpamScope extends pulumi.CustomResource {
    /**
     * Get an existing VpcIpamScope resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: VpcIpamScopeState, opts?: pulumi.CustomResourceOptions): VpcIpamScope {
        return new VpcIpamScope(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ec2/vpcIpamScope:VpcIpamScope';

    /**
     * Returns true if the given object is an instance of VpcIpamScope.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is VpcIpamScope {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === VpcIpamScope.__pulumiType;
    }

    /**
     * The Amazon Resource Name (ARN) of the scope.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * A description for the scope you're creating.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * The ARN of the IPAM for which you're creating this scope.
     */
    public /*out*/ readonly ipamArn!: pulumi.Output<string>;
    /**
     * The ID of the IPAM for which you're creating this scope.
     */
    public readonly ipamId!: pulumi.Output<string>;
    public /*out*/ readonly ipamScopeType!: pulumi.Output<string>;
    /**
     * Defines if the scope is the default scope or not.
     */
    public /*out*/ readonly isDefault!: pulumi.Output<boolean>;
    /**
     * The number of pools in the scope.
     */
    public /*out*/ readonly poolCount!: pulumi.Output<number>;
    /**
     * Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;

    /**
     * Create a VpcIpamScope resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: VpcIpamScopeArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: VpcIpamScopeArgs | VpcIpamScopeState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as VpcIpamScopeState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["ipamArn"] = state ? state.ipamArn : undefined;
            resourceInputs["ipamId"] = state ? state.ipamId : undefined;
            resourceInputs["ipamScopeType"] = state ? state.ipamScopeType : undefined;
            resourceInputs["isDefault"] = state ? state.isDefault : undefined;
            resourceInputs["poolCount"] = state ? state.poolCount : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as VpcIpamScopeArgs | undefined;
            if ((!args || args.ipamId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'ipamId'");
            }
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["ipamId"] = args ? args.ipamId : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["ipamArn"] = undefined /*out*/;
            resourceInputs["ipamScopeType"] = undefined /*out*/;
            resourceInputs["isDefault"] = undefined /*out*/;
            resourceInputs["poolCount"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(VpcIpamScope.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering VpcIpamScope resources.
 */
export interface VpcIpamScopeState {
    /**
     * The Amazon Resource Name (ARN) of the scope.
     */
    arn?: pulumi.Input<string>;
    /**
     * A description for the scope you're creating.
     */
    description?: pulumi.Input<string>;
    /**
     * The ARN of the IPAM for which you're creating this scope.
     */
    ipamArn?: pulumi.Input<string>;
    /**
     * The ID of the IPAM for which you're creating this scope.
     */
    ipamId?: pulumi.Input<string>;
    ipamScopeType?: pulumi.Input<string>;
    /**
     * Defines if the scope is the default scope or not.
     */
    isDefault?: pulumi.Input<boolean>;
    /**
     * The number of pools in the scope.
     */
    poolCount?: pulumi.Input<number>;
    /**
     * Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}

/**
 * The set of arguments for constructing a VpcIpamScope resource.
 */
export interface VpcIpamScopeArgs {
    /**
     * A description for the scope you're creating.
     */
    description?: pulumi.Input<string>;
    /**
     * The ID of the IPAM for which you're creating this scope.
     */
    ipamId: pulumi.Input<string>;
    /**
     * Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
