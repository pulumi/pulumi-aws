// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Resource for managing an AWS SSM Contact Plan.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.ssmcontacts.Plan("example", {
 *     contactId: "arn:aws:ssm-contacts:us-west-2:123456789012:contact/contactalias",
 *     stages: [{
 *         durationInMinutes: 1,
 *     }],
 * });
 * ```
 *
 * ### Usage with SSM Contact
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const contact = new aws.ssmcontacts.Contact("contact", {
 *     alias: "alias",
 *     type: "PERSONAL",
 * });
 * const plan = new aws.ssmcontacts.Plan("plan", {
 *     contactId: contact.arn,
 *     stages: [{
 *         durationInMinutes: 1,
 *     }],
 * });
 * ```
 *
 * ### Usage With All Fields
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const escalationPlan = new aws.ssmcontacts.Contact("escalation_plan", {
 *     alias: "escalation-plan-alias",
 *     type: "ESCALATION",
 * });
 * const contactOne = new aws.ssmcontacts.Contact("contact_one", {
 *     alias: "alias",
 *     type: "PERSONAL",
 * });
 * const contactTwo = new aws.ssmcontacts.Contact("contact_two", {
 *     alias: "alias",
 *     type: "PERSONAL",
 * });
 * const test = new aws.ssmcontacts.Plan("test", {
 *     contactId: escalationPlan.arn,
 *     stages: [{
 *         durationInMinutes: 0,
 *         targets: [
 *             {
 *                 contactTargetInfo: {
 *                     isEssential: false,
 *                     contactId: contactOne.arn,
 *                 },
 *             },
 *             {
 *                 contactTargetInfo: {
 *                     isEssential: true,
 *                     contactId: contactTwo.arn,
 *                 },
 *             },
 *             {
 *                 channelTargetInfo: {
 *                     retryIntervalInMinutes: 2,
 *                     contactChannelId: channel.arn,
 *                 },
 *             },
 *         ],
 *     }],
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import SSM Contact Plan using the Contact ARN. For example:
 *
 * ```sh
 * $ pulumi import aws:ssmcontacts/plan:Plan example {ARNValue}
 * ```
 */
export class Plan extends pulumi.CustomResource {
    /**
     * Get an existing Plan resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: PlanState, opts?: pulumi.CustomResourceOptions): Plan {
        return new Plan(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ssmcontacts/plan:Plan';

    /**
     * Returns true if the given object is an instance of Plan.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Plan {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Plan.__pulumiType;
    }

    /**
     * The Amazon Resource Name (ARN) of the contact or escalation plan.
     */
    public readonly contactId!: pulumi.Output<string>;
    /**
     * One or more configuration blocks for specifying a list of stages that the escalation plan or engagement plan uses to engage contacts and contact methods. See Stage below for more details.
     */
    public readonly stages!: pulumi.Output<outputs.ssmcontacts.PlanStage[]>;

    /**
     * Create a Plan resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: PlanArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: PlanArgs | PlanState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as PlanState | undefined;
            resourceInputs["contactId"] = state ? state.contactId : undefined;
            resourceInputs["stages"] = state ? state.stages : undefined;
        } else {
            const args = argsOrState as PlanArgs | undefined;
            if ((!args || args.contactId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'contactId'");
            }
            if ((!args || args.stages === undefined) && !opts.urn) {
                throw new Error("Missing required property 'stages'");
            }
            resourceInputs["contactId"] = args ? args.contactId : undefined;
            resourceInputs["stages"] = args ? args.stages : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Plan.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Plan resources.
 */
export interface PlanState {
    /**
     * The Amazon Resource Name (ARN) of the contact or escalation plan.
     */
    contactId?: pulumi.Input<string>;
    /**
     * One or more configuration blocks for specifying a list of stages that the escalation plan or engagement plan uses to engage contacts and contact methods. See Stage below for more details.
     */
    stages?: pulumi.Input<pulumi.Input<inputs.ssmcontacts.PlanStage>[]>;
}

/**
 * The set of arguments for constructing a Plan resource.
 */
export interface PlanArgs {
    /**
     * The Amazon Resource Name (ARN) of the contact or escalation plan.
     */
    contactId: pulumi.Input<string>;
    /**
     * One or more configuration blocks for specifying a list of stages that the escalation plan or engagement plan uses to engage contacts and contact methods. See Stage below for more details.
     */
    stages: pulumi.Input<pulumi.Input<inputs.ssmcontacts.PlanStage>[]>;
}
