// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Allows you to set a redrive policy of an SQS Queue
 * while referencing ARN of the dead letter queue inside the redrive policy.
 *
 * This is useful when you want to set a dedicated
 * dead letter queue for a standard or FIFO queue, but need
 * the dead letter queue to exist before setting the redrive policy.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const q = new aws.sqs.Queue("q", {name: "examplequeue"});
 * const ddl = new aws.sqs.Queue("ddl", {
 *     name: "examplequeue-ddl",
 *     redriveAllowPolicy: pulumi.jsonStringify({
 *         redrivePermission: "byQueue",
 *         sourceQueueArns: [q.arn],
 *     }),
 * });
 * const qRedrivePolicy = new aws.sqs.RedrivePolicy("q", {
 *     queueUrl: q.id,
 *     redrivePolicy: pulumi.jsonStringify({
 *         deadLetterTargetArn: ddl.arn,
 *         maxReceiveCount: 4,
 *     }),
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import SQS Queue Redrive Policies using the queue URL. For example:
 *
 * ```sh
 * $ pulumi import aws:sqs/redrivePolicy:RedrivePolicy test https://queue.amazonaws.com/123456789012/myqueue
 * ```
 */
export class RedrivePolicy extends pulumi.CustomResource {
    /**
     * Get an existing RedrivePolicy resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: RedrivePolicyState, opts?: pulumi.CustomResourceOptions): RedrivePolicy {
        return new RedrivePolicy(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:sqs/redrivePolicy:RedrivePolicy';

    /**
     * Returns true if the given object is an instance of RedrivePolicy.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is RedrivePolicy {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === RedrivePolicy.__pulumiType;
    }

    /**
     * The URL of the SQS Queue to which to attach the policy
     */
    public readonly queueUrl!: pulumi.Output<string>;
    /**
     * The JSON redrive policy for the SQS queue. Accepts two key/val pairs: `deadLetterTargetArn` and `maxReceiveCount`. Learn more in the [Amazon SQS dead-letter queues documentation](https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-dead-letter-queues.html).
     */
    public readonly redrivePolicy!: pulumi.Output<string>;

    /**
     * Create a RedrivePolicy resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: RedrivePolicyArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: RedrivePolicyArgs | RedrivePolicyState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as RedrivePolicyState | undefined;
            resourceInputs["queueUrl"] = state ? state.queueUrl : undefined;
            resourceInputs["redrivePolicy"] = state ? state.redrivePolicy : undefined;
        } else {
            const args = argsOrState as RedrivePolicyArgs | undefined;
            if ((!args || args.queueUrl === undefined) && !opts.urn) {
                throw new Error("Missing required property 'queueUrl'");
            }
            if ((!args || args.redrivePolicy === undefined) && !opts.urn) {
                throw new Error("Missing required property 'redrivePolicy'");
            }
            resourceInputs["queueUrl"] = args ? args.queueUrl : undefined;
            resourceInputs["redrivePolicy"] = args ? args.redrivePolicy : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(RedrivePolicy.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering RedrivePolicy resources.
 */
export interface RedrivePolicyState {
    /**
     * The URL of the SQS Queue to which to attach the policy
     */
    queueUrl?: pulumi.Input<string>;
    /**
     * The JSON redrive policy for the SQS queue. Accepts two key/val pairs: `deadLetterTargetArn` and `maxReceiveCount`. Learn more in the [Amazon SQS dead-letter queues documentation](https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-dead-letter-queues.html).
     */
    redrivePolicy?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a RedrivePolicy resource.
 */
export interface RedrivePolicyArgs {
    /**
     * The URL of the SQS Queue to which to attach the policy
     */
    queueUrl: pulumi.Input<string>;
    /**
     * The JSON redrive policy for the SQS queue. Accepts two key/val pairs: `deadLetterTargetArn` and `maxReceiveCount`. Learn more in the [Amazon SQS dead-letter queues documentation](https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-dead-letter-queues.html).
     */
    redrivePolicy: pulumi.Input<string>;
}
