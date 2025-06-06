// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides a Single Sign-On (SSO) ABAC Resource: https://docs.aws.amazon.com/singlesignon/latest/userguide/abac.html
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.ssoadmin.getInstances({});
 * const exampleInstanceAccessControlAttributes = new aws.ssoadmin.InstanceAccessControlAttributes("example", {
 *     instanceArn: example.then(example => example.arns?.[0]),
 *     attributes: [
 *         {
 *             key: "name",
 *             values: [{
 *                 sources: ["${path:name.givenName}"],
 *             }],
 *         },
 *         {
 *             key: "last",
 *             values: [{
 *                 sources: ["${path:name.familyName}"],
 *             }],
 *         },
 *     ],
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import SSO Account Assignments using the `instance_arn`. For example:
 *
 * ```sh
 * $ pulumi import aws:ssoadmin/instanceAccessControlAttributes:InstanceAccessControlAttributes example arn:aws:sso:::instance/ssoins-0123456789abcdef
 * ```
 */
export class InstanceAccessControlAttributes extends pulumi.CustomResource {
    /**
     * Get an existing InstanceAccessControlAttributes resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: InstanceAccessControlAttributesState, opts?: pulumi.CustomResourceOptions): InstanceAccessControlAttributes {
        return new InstanceAccessControlAttributes(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ssoadmin/instanceAccessControlAttributes:InstanceAccessControlAttributes';

    /**
     * Returns true if the given object is an instance of InstanceAccessControlAttributes.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is InstanceAccessControlAttributes {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === InstanceAccessControlAttributes.__pulumiType;
    }

    /**
     * See AccessControlAttribute for more details.
     */
    public readonly attributes!: pulumi.Output<outputs.ssoadmin.InstanceAccessControlAttributesAttribute[]>;
    /**
     * The Amazon Resource Name (ARN) of the SSO Instance.
     */
    public readonly instanceArn!: pulumi.Output<string>;
    public /*out*/ readonly status!: pulumi.Output<string>;
    public /*out*/ readonly statusReason!: pulumi.Output<string>;

    /**
     * Create a InstanceAccessControlAttributes resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: InstanceAccessControlAttributesArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: InstanceAccessControlAttributesArgs | InstanceAccessControlAttributesState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as InstanceAccessControlAttributesState | undefined;
            resourceInputs["attributes"] = state ? state.attributes : undefined;
            resourceInputs["instanceArn"] = state ? state.instanceArn : undefined;
            resourceInputs["status"] = state ? state.status : undefined;
            resourceInputs["statusReason"] = state ? state.statusReason : undefined;
        } else {
            const args = argsOrState as InstanceAccessControlAttributesArgs | undefined;
            if ((!args || args.attributes === undefined) && !opts.urn) {
                throw new Error("Missing required property 'attributes'");
            }
            if ((!args || args.instanceArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'instanceArn'");
            }
            resourceInputs["attributes"] = args ? args.attributes : undefined;
            resourceInputs["instanceArn"] = args ? args.instanceArn : undefined;
            resourceInputs["status"] = undefined /*out*/;
            resourceInputs["statusReason"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(InstanceAccessControlAttributes.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering InstanceAccessControlAttributes resources.
 */
export interface InstanceAccessControlAttributesState {
    /**
     * See AccessControlAttribute for more details.
     */
    attributes?: pulumi.Input<pulumi.Input<inputs.ssoadmin.InstanceAccessControlAttributesAttribute>[]>;
    /**
     * The Amazon Resource Name (ARN) of the SSO Instance.
     */
    instanceArn?: pulumi.Input<string>;
    status?: pulumi.Input<string>;
    statusReason?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a InstanceAccessControlAttributes resource.
 */
export interface InstanceAccessControlAttributesArgs {
    /**
     * See AccessControlAttribute for more details.
     */
    attributes: pulumi.Input<pulumi.Input<inputs.ssoadmin.InstanceAccessControlAttributesAttribute>[]>;
    /**
     * The Amazon Resource Name (ARN) of the SSO Instance.
     */
    instanceArn: pulumi.Input<string>;
}
