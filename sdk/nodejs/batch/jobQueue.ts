// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides a Batch Job Queue resource.
 *
 * ## Example Usage
 *
 * ### Basic Job Queue
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const testQueue = new aws.batch.JobQueue("test_queue", {
 *     name: "tf-test-batch-job-queue",
 *     state: "ENABLED",
 *     priority: 1,
 *     computeEnvironmentOrders: [
 *         {
 *             order: 1,
 *             computeEnvironment: testEnvironment1.arn,
 *         },
 *         {
 *             order: 2,
 *             computeEnvironment: testEnvironment2.arn,
 *         },
 *     ],
 * });
 * ```
 *
 * ### Job Queue with a fair share scheduling policy
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.batch.SchedulingPolicy("example", {
 *     name: "example",
 *     fairSharePolicy: {
 *         computeReservation: 1,
 *         shareDecaySeconds: 3600,
 *         shareDistributions: [{
 *             shareIdentifier: "A1*",
 *             weightFactor: 0.1,
 *         }],
 *     },
 * });
 * const exampleJobQueue = new aws.batch.JobQueue("example", {
 *     name: "tf-test-batch-job-queue",
 *     schedulingPolicyArn: example.arn,
 *     state: "ENABLED",
 *     priority: 1,
 *     computeEnvironmentOrders: [
 *         {
 *             order: 1,
 *             computeEnvironment: testEnvironment1.arn,
 *         },
 *         {
 *             order: 2,
 *             computeEnvironment: testEnvironment2.arn,
 *         },
 *     ],
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Batch Job Queue using the `arn`. For example:
 *
 * ```sh
 * $ pulumi import aws:batch/jobQueue:JobQueue test_queue arn:aws:batch:us-east-1:123456789012:job-queue/sample
 * ```
 */
export class JobQueue extends pulumi.CustomResource {
    /**
     * Get an existing JobQueue resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: JobQueueState, opts?: pulumi.CustomResourceOptions): JobQueue {
        return new JobQueue(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:batch/jobQueue:JobQueue';

    /**
     * Returns true if the given object is an instance of JobQueue.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is JobQueue {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === JobQueue.__pulumiType;
    }

    /**
     * The Amazon Resource Name of the job queue.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * The set of compute environments mapped to a job queue and their order relative to each other. The job scheduler uses this parameter to determine which compute environment runs a specific job. Compute environments must be in the VALID state before you can associate them with a job queue. You can associate up to three compute environments with a job queue.
     */
    public readonly computeEnvironmentOrders!: pulumi.Output<outputs.batch.JobQueueComputeEnvironmentOrder[] | undefined>;
    /**
     * (Optional) This parameter is deprecated, please use `computeEnvironmentOrder` instead. List of compute environment ARNs mapped to a job queue. The position of the compute environments in the list will dictate the order. When importing a AWS Batch Job Queue, the parameter `computeEnvironments` will always be used over `computeEnvironmentOrder`. Please adjust your HCL accordingly.
     *
     * @deprecated This parameter will be replaced by `computeEnvironmentOrder`.
     */
    public readonly computeEnvironments!: pulumi.Output<string[] | undefined>;
    /**
     * The set of job state time limit actions mapped to a job queue. Specifies an action that AWS Batch will take after the job has remained at the head of the queue in the specified state for longer than the specified time.
     */
    public readonly jobStateTimeLimitActions!: pulumi.Output<outputs.batch.JobQueueJobStateTimeLimitAction[] | undefined>;
    /**
     * Specifies the name of the job queue.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * The priority of the job queue. Job queues with a higher priority
     * are evaluated first when associated with the same compute environment.
     */
    public readonly priority!: pulumi.Output<number>;
    /**
     * The ARN of the fair share scheduling policy. If this parameter is specified, the job queue uses a fair share scheduling policy. If this parameter isn't specified, the job queue uses a first in, first out (FIFO) scheduling policy. After a job queue is created, you can replace but can't remove the fair share scheduling policy.
     */
    public readonly schedulingPolicyArn!: pulumi.Output<string | undefined>;
    /**
     * The state of the job queue. Must be one of: `ENABLED` or `DISABLED`
     */
    public readonly state!: pulumi.Output<string>;
    /**
     * Key-value map of resource tags. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    public readonly timeouts!: pulumi.Output<outputs.batch.JobQueueTimeouts | undefined>;

    /**
     * Create a JobQueue resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: JobQueueArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: JobQueueArgs | JobQueueState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as JobQueueState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["computeEnvironmentOrders"] = state ? state.computeEnvironmentOrders : undefined;
            resourceInputs["computeEnvironments"] = state ? state.computeEnvironments : undefined;
            resourceInputs["jobStateTimeLimitActions"] = state ? state.jobStateTimeLimitActions : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["priority"] = state ? state.priority : undefined;
            resourceInputs["schedulingPolicyArn"] = state ? state.schedulingPolicyArn : undefined;
            resourceInputs["state"] = state ? state.state : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["timeouts"] = state ? state.timeouts : undefined;
        } else {
            const args = argsOrState as JobQueueArgs | undefined;
            if ((!args || args.priority === undefined) && !opts.urn) {
                throw new Error("Missing required property 'priority'");
            }
            if ((!args || args.state === undefined) && !opts.urn) {
                throw new Error("Missing required property 'state'");
            }
            resourceInputs["computeEnvironmentOrders"] = args ? args.computeEnvironmentOrders : undefined;
            resourceInputs["computeEnvironments"] = args ? args.computeEnvironments : undefined;
            resourceInputs["jobStateTimeLimitActions"] = args ? args.jobStateTimeLimitActions : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["priority"] = args ? args.priority : undefined;
            resourceInputs["schedulingPolicyArn"] = args ? args.schedulingPolicyArn : undefined;
            resourceInputs["state"] = args ? args.state : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["timeouts"] = args ? args.timeouts : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(JobQueue.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering JobQueue resources.
 */
export interface JobQueueState {
    /**
     * The Amazon Resource Name of the job queue.
     */
    arn?: pulumi.Input<string>;
    /**
     * The set of compute environments mapped to a job queue and their order relative to each other. The job scheduler uses this parameter to determine which compute environment runs a specific job. Compute environments must be in the VALID state before you can associate them with a job queue. You can associate up to three compute environments with a job queue.
     */
    computeEnvironmentOrders?: pulumi.Input<pulumi.Input<inputs.batch.JobQueueComputeEnvironmentOrder>[]>;
    /**
     * (Optional) This parameter is deprecated, please use `computeEnvironmentOrder` instead. List of compute environment ARNs mapped to a job queue. The position of the compute environments in the list will dictate the order. When importing a AWS Batch Job Queue, the parameter `computeEnvironments` will always be used over `computeEnvironmentOrder`. Please adjust your HCL accordingly.
     *
     * @deprecated This parameter will be replaced by `computeEnvironmentOrder`.
     */
    computeEnvironments?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * The set of job state time limit actions mapped to a job queue. Specifies an action that AWS Batch will take after the job has remained at the head of the queue in the specified state for longer than the specified time.
     */
    jobStateTimeLimitActions?: pulumi.Input<pulumi.Input<inputs.batch.JobQueueJobStateTimeLimitAction>[]>;
    /**
     * Specifies the name of the job queue.
     */
    name?: pulumi.Input<string>;
    /**
     * The priority of the job queue. Job queues with a higher priority
     * are evaluated first when associated with the same compute environment.
     */
    priority?: pulumi.Input<number>;
    /**
     * The ARN of the fair share scheduling policy. If this parameter is specified, the job queue uses a fair share scheduling policy. If this parameter isn't specified, the job queue uses a first in, first out (FIFO) scheduling policy. After a job queue is created, you can replace but can't remove the fair share scheduling policy.
     */
    schedulingPolicyArn?: pulumi.Input<string>;
    /**
     * The state of the job queue. Must be one of: `ENABLED` or `DISABLED`
     */
    state?: pulumi.Input<string>;
    /**
     * Key-value map of resource tags. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    timeouts?: pulumi.Input<inputs.batch.JobQueueTimeouts>;
}

/**
 * The set of arguments for constructing a JobQueue resource.
 */
export interface JobQueueArgs {
    /**
     * The set of compute environments mapped to a job queue and their order relative to each other. The job scheduler uses this parameter to determine which compute environment runs a specific job. Compute environments must be in the VALID state before you can associate them with a job queue. You can associate up to three compute environments with a job queue.
     */
    computeEnvironmentOrders?: pulumi.Input<pulumi.Input<inputs.batch.JobQueueComputeEnvironmentOrder>[]>;
    /**
     * (Optional) This parameter is deprecated, please use `computeEnvironmentOrder` instead. List of compute environment ARNs mapped to a job queue. The position of the compute environments in the list will dictate the order. When importing a AWS Batch Job Queue, the parameter `computeEnvironments` will always be used over `computeEnvironmentOrder`. Please adjust your HCL accordingly.
     *
     * @deprecated This parameter will be replaced by `computeEnvironmentOrder`.
     */
    computeEnvironments?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * The set of job state time limit actions mapped to a job queue. Specifies an action that AWS Batch will take after the job has remained at the head of the queue in the specified state for longer than the specified time.
     */
    jobStateTimeLimitActions?: pulumi.Input<pulumi.Input<inputs.batch.JobQueueJobStateTimeLimitAction>[]>;
    /**
     * Specifies the name of the job queue.
     */
    name?: pulumi.Input<string>;
    /**
     * The priority of the job queue. Job queues with a higher priority
     * are evaluated first when associated with the same compute environment.
     */
    priority: pulumi.Input<number>;
    /**
     * The ARN of the fair share scheduling policy. If this parameter is specified, the job queue uses a fair share scheduling policy. If this parameter isn't specified, the job queue uses a first in, first out (FIFO) scheduling policy. After a job queue is created, you can replace but can't remove the fair share scheduling policy.
     */
    schedulingPolicyArn?: pulumi.Input<string>;
    /**
     * The state of the job queue. Must be one of: `ENABLED` or `DISABLED`
     */
    state: pulumi.Input<string>;
    /**
     * Key-value map of resource tags. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    timeouts?: pulumi.Input<inputs.batch.JobQueueTimeouts>;
}
