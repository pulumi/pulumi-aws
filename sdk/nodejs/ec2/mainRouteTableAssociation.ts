// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides a resource for managing the main routing table of a VPC.
 *
 * > **NOTE:** **Do not** use both `aws.ec2.DefaultRouteTable` to manage a default route table **and** `aws.ec2.MainRouteTableAssociation` with the same VPC due to possible route conflicts. See aws.ec2.DefaultRouteTable documentation for more details.
 * For more information, see the Amazon VPC User Guide on [Route Tables][aws-route-tables]. For information about managing normal route tables in Pulumi, see [`aws.ec2.RouteTable`][tf-route-tables].
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const a = new aws.ec2.MainRouteTableAssociation("a", {
 *     vpcId: foo.id,
 *     routeTableId: bar.id,
 * });
 * ```
 *
 * ## Notes
 *
 * On VPC creation, the AWS API always creates an initial Main Route Table. This
 * resource records the ID of that Route Table under `originalRouteTableId`.
 * The "Delete" action for a `mainRouteTableAssociation` consists of resetting
 * this original table as the Main Route Table for the VPC. You'll see this
 * additional Route Table in the AWS console; it must remain intact in order for
 * the `mainRouteTableAssociation` delete to work properly.
 */
export class MainRouteTableAssociation extends pulumi.CustomResource {
    /**
     * Get an existing MainRouteTableAssociation resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: MainRouteTableAssociationState, opts?: pulumi.CustomResourceOptions): MainRouteTableAssociation {
        return new MainRouteTableAssociation(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ec2/mainRouteTableAssociation:MainRouteTableAssociation';

    /**
     * Returns true if the given object is an instance of MainRouteTableAssociation.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is MainRouteTableAssociation {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === MainRouteTableAssociation.__pulumiType;
    }

    /**
     * Used internally, see **Notes** below
     */
    public /*out*/ readonly originalRouteTableId!: pulumi.Output<string>;
    /**
     * The ID of the Route Table to set as the new
     * main route table for the target VPC
     */
    public readonly routeTableId!: pulumi.Output<string>;
    /**
     * The ID of the VPC whose main route table should be set
     */
    public readonly vpcId!: pulumi.Output<string>;

    /**
     * Create a MainRouteTableAssociation resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: MainRouteTableAssociationArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: MainRouteTableAssociationArgs | MainRouteTableAssociationState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as MainRouteTableAssociationState | undefined;
            resourceInputs["originalRouteTableId"] = state ? state.originalRouteTableId : undefined;
            resourceInputs["routeTableId"] = state ? state.routeTableId : undefined;
            resourceInputs["vpcId"] = state ? state.vpcId : undefined;
        } else {
            const args = argsOrState as MainRouteTableAssociationArgs | undefined;
            if ((!args || args.routeTableId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'routeTableId'");
            }
            if ((!args || args.vpcId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'vpcId'");
            }
            resourceInputs["routeTableId"] = args ? args.routeTableId : undefined;
            resourceInputs["vpcId"] = args ? args.vpcId : undefined;
            resourceInputs["originalRouteTableId"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(MainRouteTableAssociation.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering MainRouteTableAssociation resources.
 */
export interface MainRouteTableAssociationState {
    /**
     * Used internally, see **Notes** below
     */
    originalRouteTableId?: pulumi.Input<string>;
    /**
     * The ID of the Route Table to set as the new
     * main route table for the target VPC
     */
    routeTableId?: pulumi.Input<string>;
    /**
     * The ID of the VPC whose main route table should be set
     */
    vpcId?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a MainRouteTableAssociation resource.
 */
export interface MainRouteTableAssociationArgs {
    /**
     * The ID of the Route Table to set as the new
     * main route table for the target VPC
     */
    routeTableId: pulumi.Input<string>;
    /**
     * The ID of the VPC whose main route table should be set
     */
    vpcId: pulumi.Input<string>;
}
