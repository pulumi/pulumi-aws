// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * The ECS Service data source allows access to details of a specific
 * Service within a AWS ECS Cluster.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.ecs.getService({
 *     serviceName: "example",
 *     clusterArn: exampleAwsEcsCluster.arn,
 * });
 * ```
 */
export function getService(args: GetServiceArgs, opts?: pulumi.InvokeOptions): Promise<GetServiceResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:ecs/getService:getService", {
        "clusterArn": args.clusterArn,
        "serviceName": args.serviceName,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getService.
 */
export interface GetServiceArgs {
    /**
     * ARN of the ECS Cluster
     */
    clusterArn: string;
    /**
     * Name of the ECS Service
     */
    serviceName: string;
    /**
     * Resource tags.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getService.
 */
export interface GetServiceResult {
    /**
     * ARN of the ECS Service
     */
    readonly arn: string;
    readonly availabilityZoneRebalancing: string;
    readonly clusterArn: string;
    /**
     * Number of tasks for the ECS Service
     */
    readonly desiredCount: number;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * Launch type for the ECS Service
     */
    readonly launchType: string;
    /**
     * Scheduling strategy for the ECS Service
     */
    readonly schedulingStrategy: string;
    readonly serviceName: string;
    /**
     * Resource tags.
     */
    readonly tags: {[key: string]: string};
    /**
     * Family for the latest ACTIVE revision or full ARN of the task definition.
     */
    readonly taskDefinition: string;
}
/**
 * The ECS Service data source allows access to details of a specific
 * Service within a AWS ECS Cluster.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.ecs.getService({
 *     serviceName: "example",
 *     clusterArn: exampleAwsEcsCluster.arn,
 * });
 * ```
 */
export function getServiceOutput(args: GetServiceOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetServiceResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:ecs/getService:getService", {
        "clusterArn": args.clusterArn,
        "serviceName": args.serviceName,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getService.
 */
export interface GetServiceOutputArgs {
    /**
     * ARN of the ECS Cluster
     */
    clusterArn: pulumi.Input<string>;
    /**
     * Name of the ECS Service
     */
    serviceName: pulumi.Input<string>;
    /**
     * Resource tags.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
