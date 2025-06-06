// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Resource for managing an AWS Data Exchange Event Action.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.dataexchange.EventAction("example", {
 *     event: {
 *         revisionPublished: {
 *             dataSetId: exampleAwsDataexchangeDataSet.id,
 *         },
 *     },
 *     action: {
 *         exportRevisionToS3: {
 *             revisionDestination: {
 *                 bucket: exampleAwsS3Bucket.bucket,
 *                 keyPattern: "${Revision.CreatedAt}/${Asset.Name}",
 *             },
 *             encryption: {
 *                 type: "aws:kms",
 *                 kmsKeyArn: exampleAwsKmsKey.arn,
 *             },
 *         },
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Data Exchange Event Action using the id. For example:
 *
 * ```sh
 * $ pulumi import aws:dataexchange/eventAction:EventAction example example-event-action-id
 * ```
 */
export class EventAction extends pulumi.CustomResource {
    /**
     * Get an existing EventAction resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: EventActionState, opts?: pulumi.CustomResourceOptions): EventAction {
        return new EventAction(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:dataexchange/eventAction:EventAction';

    /**
     * Returns true if the given object is an instance of EventAction.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is EventAction {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === EventAction.__pulumiType;
    }

    /**
     * Describes the action to take.
     * Described in `action` Configuration Block below.
     */
    public readonly action!: pulumi.Output<outputs.dataexchange.EventActionAction | undefined>;
    /**
     * Amazon Resource Name (ARN) of the event action.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * Date and time when the resource was created.
     */
    public /*out*/ readonly createdAt!: pulumi.Output<string>;
    /**
     * Describes the event that triggers the `action`.
     * Described in `event` Configuration Block below.
     */
    public readonly event!: pulumi.Output<outputs.dataexchange.EventActionEvent | undefined>;
    /**
     * Data and time when the resource was last updated.
     */
    public /*out*/ readonly updatedAt!: pulumi.Output<string>;

    /**
     * Create a EventAction resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args?: EventActionArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: EventActionArgs | EventActionState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as EventActionState | undefined;
            resourceInputs["action"] = state ? state.action : undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["createdAt"] = state ? state.createdAt : undefined;
            resourceInputs["event"] = state ? state.event : undefined;
            resourceInputs["updatedAt"] = state ? state.updatedAt : undefined;
        } else {
            const args = argsOrState as EventActionArgs | undefined;
            resourceInputs["action"] = args ? args.action : undefined;
            resourceInputs["event"] = args ? args.event : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["createdAt"] = undefined /*out*/;
            resourceInputs["updatedAt"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(EventAction.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering EventAction resources.
 */
export interface EventActionState {
    /**
     * Describes the action to take.
     * Described in `action` Configuration Block below.
     */
    action?: pulumi.Input<inputs.dataexchange.EventActionAction>;
    /**
     * Amazon Resource Name (ARN) of the event action.
     */
    arn?: pulumi.Input<string>;
    /**
     * Date and time when the resource was created.
     */
    createdAt?: pulumi.Input<string>;
    /**
     * Describes the event that triggers the `action`.
     * Described in `event` Configuration Block below.
     */
    event?: pulumi.Input<inputs.dataexchange.EventActionEvent>;
    /**
     * Data and time when the resource was last updated.
     */
    updatedAt?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a EventAction resource.
 */
export interface EventActionArgs {
    /**
     * Describes the action to take.
     * Described in `action` Configuration Block below.
     */
    action?: pulumi.Input<inputs.dataexchange.EventActionAction>;
    /**
     * Describes the event that triggers the `action`.
     * Described in `event` Configuration Block below.
     */
    event?: pulumi.Input<inputs.dataexchange.EventActionEvent>;
}
