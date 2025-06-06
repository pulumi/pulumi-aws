// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides a resource to manage a default route table of a VPC. This resource can manage the default route table of the default or a non-default VPC.
 *
 * > **NOTE:** This is an advanced resource with special caveats. Please read this document in its entirety before using this resource. The `aws.ec2.DefaultRouteTable` resource behaves differently from normal resources. This provider does not _create_ this resource but instead attempts to "adopt" it into management. **Do not** use both `aws.ec2.DefaultRouteTable` to manage a default route table **and** `aws.ec2.MainRouteTableAssociation` with the same VPC due to possible route conflicts. See aws.ec2.MainRouteTableAssociation documentation for more details.
 *
 * Every VPC has a default route table that can be managed but not destroyed. When the provider first adopts a default route table, it **immediately removes all defined routes**. It then proceeds to create any routes specified in the configuration. This step is required so that only the routes specified in the configuration exist in the default route table.
 *
 * For more information, see the Amazon VPC User Guide on [Route Tables](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_Route_Tables.html). For information about managing normal route tables in this provider, see `aws.ec2.RouteTable`.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.ec2.DefaultRouteTable("example", {
 *     defaultRouteTableId: exampleAwsVpc.defaultRouteTableId,
 *     routes: [
 *         {
 *             cidrBlock: "10.0.1.0/24",
 *             gatewayId: exampleAwsInternetGateway.id,
 *         },
 *         {
 *             ipv6CidrBlock: "::/0",
 *             egressOnlyGatewayId: exampleAwsEgressOnlyInternetGateway.id,
 *         },
 *     ],
 *     tags: {
 *         Name: "example",
 *     },
 * });
 * ```
 *
 * To subsequently remove all managed routes:
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.ec2.DefaultRouteTable("example", {
 *     defaultRouteTableId: exampleAwsVpc.defaultRouteTableId,
 *     routes: [],
 *     tags: {
 *         Name: "example",
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Default VPC route tables using the `vpc_id`. For example:
 *
 * ```sh
 * $ pulumi import aws:ec2/defaultRouteTable:DefaultRouteTable example vpc-33cc44dd
 * ```
 */
export class DefaultRouteTable extends pulumi.CustomResource {
    /**
     * Get an existing DefaultRouteTable resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: DefaultRouteTableState, opts?: pulumi.CustomResourceOptions): DefaultRouteTable {
        return new DefaultRouteTable(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ec2/defaultRouteTable:DefaultRouteTable';

    /**
     * Returns true if the given object is an instance of DefaultRouteTable.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is DefaultRouteTable {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === DefaultRouteTable.__pulumiType;
    }

    /**
     * The ARN of the route table.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * ID of the default route table.
     *
     * The following arguments are optional:
     */
    public readonly defaultRouteTableId!: pulumi.Output<string>;
    /**
     * ID of the AWS account that owns the route table.
     */
    public /*out*/ readonly ownerId!: pulumi.Output<string>;
    /**
     * List of virtual gateways for propagation.
     */
    public readonly propagatingVgws!: pulumi.Output<string[] | undefined>;
    /**
     * Set of objects. Detailed below
     */
    public readonly routes!: pulumi.Output<outputs.ec2.DefaultRouteTableRoute[]>;
    /**
     * Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * ID of the VPC.
     */
    public /*out*/ readonly vpcId!: pulumi.Output<string>;

    /**
     * Create a DefaultRouteTable resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: DefaultRouteTableArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: DefaultRouteTableArgs | DefaultRouteTableState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as DefaultRouteTableState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["defaultRouteTableId"] = state ? state.defaultRouteTableId : undefined;
            resourceInputs["ownerId"] = state ? state.ownerId : undefined;
            resourceInputs["propagatingVgws"] = state ? state.propagatingVgws : undefined;
            resourceInputs["routes"] = state ? state.routes : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["vpcId"] = state ? state.vpcId : undefined;
        } else {
            const args = argsOrState as DefaultRouteTableArgs | undefined;
            if ((!args || args.defaultRouteTableId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'defaultRouteTableId'");
            }
            resourceInputs["defaultRouteTableId"] = args ? args.defaultRouteTableId : undefined;
            resourceInputs["propagatingVgws"] = args ? args.propagatingVgws : undefined;
            resourceInputs["routes"] = args ? args.routes : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["ownerId"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
            resourceInputs["vpcId"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(DefaultRouteTable.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering DefaultRouteTable resources.
 */
export interface DefaultRouteTableState {
    /**
     * The ARN of the route table.
     */
    arn?: pulumi.Input<string>;
    /**
     * ID of the default route table.
     *
     * The following arguments are optional:
     */
    defaultRouteTableId?: pulumi.Input<string>;
    /**
     * ID of the AWS account that owns the route table.
     */
    ownerId?: pulumi.Input<string>;
    /**
     * List of virtual gateways for propagation.
     */
    propagatingVgws?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Set of objects. Detailed below
     */
    routes?: pulumi.Input<pulumi.Input<inputs.ec2.DefaultRouteTableRoute>[]>;
    /**
     * Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * ID of the VPC.
     */
    vpcId?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a DefaultRouteTable resource.
 */
export interface DefaultRouteTableArgs {
    /**
     * ID of the default route table.
     *
     * The following arguments are optional:
     */
    defaultRouteTableId: pulumi.Input<string>;
    /**
     * List of virtual gateways for propagation.
     */
    propagatingVgws?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Set of objects. Detailed below
     */
    routes?: pulumi.Input<pulumi.Input<inputs.ec2.DefaultRouteTableRoute>[]>;
    /**
     * Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
