// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Resource for managing a QuickSight Refresh Schedule.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.quicksight.RefreshSchedule("example", {
 *     dataSetId: "dataset-id",
 *     scheduleId: "schedule-id",
 *     schedule: {
 *         refreshType: "FULL_REFRESH",
 *         scheduleFrequency: {
 *             interval: "HOURLY",
 *         },
 *     },
 * });
 * ```
 *
 * ### With Weekly Refresh
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.quicksight.RefreshSchedule("example", {
 *     dataSetId: "dataset-id",
 *     scheduleId: "schedule-id",
 *     schedule: {
 *         refreshType: "INCREMENTAL_REFRESH",
 *         scheduleFrequency: {
 *             interval: "WEEKLY",
 *             timeOfTheDay: "01:00",
 *             timezone: "Europe/London",
 *             refreshOnDay: {
 *                 dayOfWeek: "MONDAY",
 *             },
 *         },
 *     },
 * });
 * ```
 *
 * ### With Monthly Refresh
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.quicksight.RefreshSchedule("example", {
 *     dataSetId: "dataset-id",
 *     scheduleId: "schedule-id",
 *     schedule: {
 *         refreshType: "INCREMENTAL_REFRESH",
 *         scheduleFrequency: {
 *             interval: "MONTHLY",
 *             timeOfTheDay: "01:00",
 *             timezone: "Europe/London",
 *             refreshOnDay: {
 *                 dayOfMonth: "1",
 *             },
 *         },
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import a QuickSight Refresh Schedule using the AWS account ID, data set ID and schedule ID separated by commas (`,`). For example:
 *
 * ```sh
 * $ pulumi import aws:quicksight/refreshSchedule:RefreshSchedule example 123456789012,dataset-id,schedule-id
 * ```
 */
export class RefreshSchedule extends pulumi.CustomResource {
    /**
     * Get an existing RefreshSchedule resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: RefreshScheduleState, opts?: pulumi.CustomResourceOptions): RefreshSchedule {
        return new RefreshSchedule(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:quicksight/refreshSchedule:RefreshSchedule';

    /**
     * Returns true if the given object is an instance of RefreshSchedule.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is RefreshSchedule {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === RefreshSchedule.__pulumiType;
    }

    /**
     * Amazon Resource Name (ARN) of the refresh schedule.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * AWS account ID.
     */
    public readonly awsAccountId!: pulumi.Output<string>;
    /**
     * The ID of the dataset.
     */
    public readonly dataSetId!: pulumi.Output<string>;
    /**
     * The [refresh schedule](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_RefreshSchedule.html). See schedule
     *
     * The following arguments are optional:
     */
    public readonly schedule!: pulumi.Output<outputs.quicksight.RefreshScheduleSchedule | undefined>;
    /**
     * The ID of the refresh schedule.
     */
    public readonly scheduleId!: pulumi.Output<string>;

    /**
     * Create a RefreshSchedule resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: RefreshScheduleArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: RefreshScheduleArgs | RefreshScheduleState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as RefreshScheduleState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["awsAccountId"] = state ? state.awsAccountId : undefined;
            resourceInputs["dataSetId"] = state ? state.dataSetId : undefined;
            resourceInputs["schedule"] = state ? state.schedule : undefined;
            resourceInputs["scheduleId"] = state ? state.scheduleId : undefined;
        } else {
            const args = argsOrState as RefreshScheduleArgs | undefined;
            if ((!args || args.dataSetId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'dataSetId'");
            }
            if ((!args || args.scheduleId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'scheduleId'");
            }
            resourceInputs["awsAccountId"] = args ? args.awsAccountId : undefined;
            resourceInputs["dataSetId"] = args ? args.dataSetId : undefined;
            resourceInputs["schedule"] = args ? args.schedule : undefined;
            resourceInputs["scheduleId"] = args ? args.scheduleId : undefined;
            resourceInputs["arn"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(RefreshSchedule.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering RefreshSchedule resources.
 */
export interface RefreshScheduleState {
    /**
     * Amazon Resource Name (ARN) of the refresh schedule.
     */
    arn?: pulumi.Input<string>;
    /**
     * AWS account ID.
     */
    awsAccountId?: pulumi.Input<string>;
    /**
     * The ID of the dataset.
     */
    dataSetId?: pulumi.Input<string>;
    /**
     * The [refresh schedule](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_RefreshSchedule.html). See schedule
     *
     * The following arguments are optional:
     */
    schedule?: pulumi.Input<inputs.quicksight.RefreshScheduleSchedule>;
    /**
     * The ID of the refresh schedule.
     */
    scheduleId?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a RefreshSchedule resource.
 */
export interface RefreshScheduleArgs {
    /**
     * AWS account ID.
     */
    awsAccountId?: pulumi.Input<string>;
    /**
     * The ID of the dataset.
     */
    dataSetId: pulumi.Input<string>;
    /**
     * The [refresh schedule](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_RefreshSchedule.html). See schedule
     *
     * The following arguments are optional:
     */
    schedule?: pulumi.Input<inputs.quicksight.RefreshScheduleSchedule>;
    /**
     * The ID of the refresh schedule.
     */
    scheduleId: pulumi.Input<string>;
}
