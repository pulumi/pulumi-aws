// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides an Amazon Connect Hours of Operation resource. For more information see
 * [Amazon Connect: Getting Started](https://docs.aws.amazon.com/connect/latest/adminguide/amazon-connect-get-started.html)
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const test = new aws.connect.HoursOfOperation("test", {
 *     instanceId: "aaaaaaaa-bbbb-cccc-dddd-111111111111",
 *     name: "Office Hours",
 *     description: "Monday office hours",
 *     timeZone: "EST",
 *     configs: [
 *         {
 *             day: "MONDAY",
 *             endTime: {
 *                 hours: 23,
 *                 minutes: 8,
 *             },
 *             startTime: {
 *                 hours: 8,
 *                 minutes: 0,
 *             },
 *         },
 *         {
 *             day: "TUESDAY",
 *             endTime: {
 *                 hours: 21,
 *                 minutes: 0,
 *             },
 *             startTime: {
 *                 hours: 9,
 *                 minutes: 0,
 *             },
 *         },
 *     ],
 *     tags: {
 *         Name: "Example Hours of Operation",
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Amazon Connect Hours of Operations using the `instance_id` and `hours_of_operation_id` separated by a colon (`:`). For example:
 *
 * ```sh
 * $ pulumi import aws:connect/hoursOfOperation:HoursOfOperation example f1288a1f-6193-445a-b47e-af739b2:c1d4e5f6-1b3c-1b3c-1b3c-c1d4e5f6c1d4e5
 * ```
 */
export class HoursOfOperation extends pulumi.CustomResource {
    /**
     * Get an existing HoursOfOperation resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: HoursOfOperationState, opts?: pulumi.CustomResourceOptions): HoursOfOperation {
        return new HoursOfOperation(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:connect/hoursOfOperation:HoursOfOperation';

    /**
     * Returns true if the given object is an instance of HoursOfOperation.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is HoursOfOperation {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === HoursOfOperation.__pulumiType;
    }

    /**
     * The Amazon Resource Name (ARN) of the Hours of Operation.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * One or more config blocks which define the configuration information for the hours of operation: day, start time, and end time . Config blocks are documented below.
     */
    public readonly configs!: pulumi.Output<outputs.connect.HoursOfOperationConfig[]>;
    /**
     * Specifies the description of the Hours of Operation.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * The identifier for the hours of operation.
     */
    public /*out*/ readonly hoursOfOperationId!: pulumi.Output<string>;
    /**
     * Specifies the identifier of the hosting Amazon Connect Instance.
     */
    public readonly instanceId!: pulumi.Output<string>;
    /**
     * Specifies the name of the Hours of Operation.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * Tags to apply to the Hours of Operation. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * Specifies the time zone of the Hours of Operation.
     */
    public readonly timeZone!: pulumi.Output<string>;

    /**
     * Create a HoursOfOperation resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: HoursOfOperationArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: HoursOfOperationArgs | HoursOfOperationState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as HoursOfOperationState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["configs"] = state ? state.configs : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["hoursOfOperationId"] = state ? state.hoursOfOperationId : undefined;
            resourceInputs["instanceId"] = state ? state.instanceId : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["timeZone"] = state ? state.timeZone : undefined;
        } else {
            const args = argsOrState as HoursOfOperationArgs | undefined;
            if ((!args || args.configs === undefined) && !opts.urn) {
                throw new Error("Missing required property 'configs'");
            }
            if ((!args || args.instanceId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'instanceId'");
            }
            if ((!args || args.timeZone === undefined) && !opts.urn) {
                throw new Error("Missing required property 'timeZone'");
            }
            resourceInputs["configs"] = args ? args.configs : undefined;
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["instanceId"] = args ? args.instanceId : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["timeZone"] = args ? args.timeZone : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["hoursOfOperationId"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(HoursOfOperation.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering HoursOfOperation resources.
 */
export interface HoursOfOperationState {
    /**
     * The Amazon Resource Name (ARN) of the Hours of Operation.
     */
    arn?: pulumi.Input<string>;
    /**
     * One or more config blocks which define the configuration information for the hours of operation: day, start time, and end time . Config blocks are documented below.
     */
    configs?: pulumi.Input<pulumi.Input<inputs.connect.HoursOfOperationConfig>[]>;
    /**
     * Specifies the description of the Hours of Operation.
     */
    description?: pulumi.Input<string>;
    /**
     * The identifier for the hours of operation.
     */
    hoursOfOperationId?: pulumi.Input<string>;
    /**
     * Specifies the identifier of the hosting Amazon Connect Instance.
     */
    instanceId?: pulumi.Input<string>;
    /**
     * Specifies the name of the Hours of Operation.
     */
    name?: pulumi.Input<string>;
    /**
     * Tags to apply to the Hours of Operation. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Specifies the time zone of the Hours of Operation.
     */
    timeZone?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a HoursOfOperation resource.
 */
export interface HoursOfOperationArgs {
    /**
     * One or more config blocks which define the configuration information for the hours of operation: day, start time, and end time . Config blocks are documented below.
     */
    configs: pulumi.Input<pulumi.Input<inputs.connect.HoursOfOperationConfig>[]>;
    /**
     * Specifies the description of the Hours of Operation.
     */
    description?: pulumi.Input<string>;
    /**
     * Specifies the identifier of the hosting Amazon Connect Instance.
     */
    instanceId: pulumi.Input<string>;
    /**
     * Specifies the name of the Hours of Operation.
     */
    name?: pulumi.Input<string>;
    /**
     * Tags to apply to the Hours of Operation. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Specifies the time zone of the Hours of Operation.
     */
    timeZone: pulumi.Input<string>;
}
