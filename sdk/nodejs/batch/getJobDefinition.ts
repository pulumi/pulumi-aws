// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Data source for managing an AWS Batch Job Definition.
 *
 * ## Example Usage
 *
 * ### Lookup via Arn
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const arn = aws.batch.getJobDefinition({
 *     arn: "arn:aws:batch:us-east-1:012345678910:job-definition/example",
 * });
 * ```
 *
 * ### Lookup via Name
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const name = aws.batch.getJobDefinition({
 *     name: "example",
 *     revision: 2,
 * });
 * ```
 */
export function getJobDefinition(args?: GetJobDefinitionArgs, opts?: pulumi.InvokeOptions): Promise<GetJobDefinitionResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:batch/getJobDefinition:getJobDefinition", {
        "arn": args.arn,
        "name": args.name,
        "revision": args.revision,
        "status": args.status,
    }, opts);
}

/**
 * A collection of arguments for invoking getJobDefinition.
 */
export interface GetJobDefinitionArgs {
    /**
     * ARN of the Job Definition. Do not begin the description with "An", "The", "Defines", "Indicates", or "Specifies," as these are verbose. In other words, "Indicates the amount of storage," can be rewritten as "Amount of storage," without losing any information.
     */
    arn?: string;
    /**
     * The name of the job definition to register. It can be up to 128 letters long. It can contain uppercase and lowercase letters, numbers, hyphens (-), and underscores (_).
     */
    name?: string;
    /**
     * The revision of the job definition.
     */
    revision?: number;
    /**
     * The status of the job definition.
     */
    status?: string;
}

/**
 * A collection of values returned by getJobDefinition.
 */
export interface GetJobDefinitionResult {
    readonly arn?: string;
    readonly arnPrefix: string;
    /**
     * The orchestration type of the compute environment.
     */
    readonly containerOrchestrationType: string;
    /**
     * An object with various properties that are specific to Amazon EKS based jobs. This must not be specified for Amazon ECS based job definitions.
     */
    readonly eksProperties: outputs.batch.GetJobDefinitionEksProperty[];
    /**
     * The ARN
     */
    readonly id: string;
    /**
     * The name of the volume.
     */
    readonly name?: string;
    /**
     * An object with various properties specific to multi-node parallel jobs. If you specify node properties for a job, it becomes a multi-node parallel job. For more information, see Multi-node Parallel Jobs in the AWS Batch User Guide. If the job definition's type parameter is container, then you must specify either containerProperties or nodeProperties.
     */
    readonly nodeProperties: outputs.batch.GetJobDefinitionNodeProperty[];
    /**
     * The retry strategy to use for failed jobs that are submitted with this job definition. Any retry strategy that's specified during a SubmitJob operation overrides the retry strategy defined here. If a job is terminated due to a timeout, it isn't retried.
     */
    readonly retryStrategies: outputs.batch.GetJobDefinitionRetryStrategy[];
    readonly revision?: number;
    /**
     * The scheduling priority for jobs that are submitted with this job definition. This only affects jobs in job queues with a fair share policy. Jobs with a higher scheduling priority are scheduled before jobs with a lower scheduling priority.
     */
    readonly schedulingPriority: number;
    readonly status?: string;
    readonly tags: {[key: string]: string};
    /**
     * The timeout configuration for jobs that are submitted with this job definition, after which AWS Batch terminates your jobs if they have not finished. If a job is terminated due to a timeout, it isn't retried. The minimum value for the timeout is 60 seconds.
     */
    readonly timeouts: outputs.batch.GetJobDefinitionTimeout[];
    /**
     * The type of resource to assign to a container. The supported resources include `GPU`, `MEMORY`, and `VCPU`.
     */
    readonly type: string;
}
/**
 * Data source for managing an AWS Batch Job Definition.
 *
 * ## Example Usage
 *
 * ### Lookup via Arn
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const arn = aws.batch.getJobDefinition({
 *     arn: "arn:aws:batch:us-east-1:012345678910:job-definition/example",
 * });
 * ```
 *
 * ### Lookup via Name
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const name = aws.batch.getJobDefinition({
 *     name: "example",
 *     revision: 2,
 * });
 * ```
 */
export function getJobDefinitionOutput(args?: GetJobDefinitionOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetJobDefinitionResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:batch/getJobDefinition:getJobDefinition", {
        "arn": args.arn,
        "name": args.name,
        "revision": args.revision,
        "status": args.status,
    }, opts);
}

/**
 * A collection of arguments for invoking getJobDefinition.
 */
export interface GetJobDefinitionOutputArgs {
    /**
     * ARN of the Job Definition. Do not begin the description with "An", "The", "Defines", "Indicates", or "Specifies," as these are verbose. In other words, "Indicates the amount of storage," can be rewritten as "Amount of storage," without losing any information.
     */
    arn?: pulumi.Input<string>;
    /**
     * The name of the job definition to register. It can be up to 128 letters long. It can contain uppercase and lowercase letters, numbers, hyphens (-), and underscores (_).
     */
    name?: pulumi.Input<string>;
    /**
     * The revision of the job definition.
     */
    revision?: pulumi.Input<number>;
    /**
     * The status of the job definition.
     */
    status?: pulumi.Input<string>;
}
