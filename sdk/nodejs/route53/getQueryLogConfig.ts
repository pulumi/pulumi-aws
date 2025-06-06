// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * `aws.route53.ResolverQueryLogConfig` provides details about a specific Route53 Resolver Query Logging Configuration.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.route53.getQueryLogConfig({
 *     resolverQueryLogConfigId: "rqlc-1abc2345ef678g91h",
 * });
 * ```
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.route53.getQueryLogConfig({
 *     filters: [
 *         {
 *             name: "Name",
 *             values: ["shared-query-log-config"],
 *         },
 *         {
 *             name: "ShareStatus",
 *             values: ["SHARED_WITH_ME"],
 *         },
 *     ],
 * });
 * ```
 */
export function getQueryLogConfig(args?: GetQueryLogConfigArgs, opts?: pulumi.InvokeOptions): Promise<GetQueryLogConfigResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:route53/getQueryLogConfig:getQueryLogConfig", {
        "filters": args.filters,
        "name": args.name,
        "resolverQueryLogConfigId": args.resolverQueryLogConfigId,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getQueryLogConfig.
 */
export interface GetQueryLogConfigArgs {
    /**
     * One or more name/value pairs to use as filters. There are
     * several valid keys, for a full reference, check out
     * [Route53resolver Filter value in the AWS API reference][1].
     */
    filters?: inputs.route53.GetQueryLogConfigFilter[];
    /**
     * The name of the query logging configuration.
     */
    name?: string;
    /**
     * ID of the Route53 Resolver Query Logging Configuration.
     */
    resolverQueryLogConfigId?: string;
    /**
     * Map of tags to assign to the service.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getQueryLogConfig.
 */
export interface GetQueryLogConfigResult {
    /**
     * Computed ARN of the Route53 Resolver Query Logging Configuration.
     */
    readonly arn: string;
    /**
     * The ARN of the resource that you want Resolver to send query logs: an Amazon S3 bucket, a CloudWatch Logs log group or a Kinesis Data Firehose delivery stream.
     */
    readonly destinationArn: string;
    readonly filters?: outputs.route53.GetQueryLogConfigFilter[];
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * The name of the query logging configuration.
     */
    readonly name?: string;
    /**
     * The AWS account ID for the account that created the query logging configuration.
     */
    readonly ownerId: string;
    readonly resolverQueryLogConfigId?: string;
    /**
     * An indication of whether the query logging configuration is shared with other AWS accounts or was shared with the current account by another AWS account.
     */
    readonly shareStatus: string;
    /**
     * Map of tags to assign to the service.
     */
    readonly tags: {[key: string]: string};
}
/**
 * `aws.route53.ResolverQueryLogConfig` provides details about a specific Route53 Resolver Query Logging Configuration.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.route53.getQueryLogConfig({
 *     resolverQueryLogConfigId: "rqlc-1abc2345ef678g91h",
 * });
 * ```
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.route53.getQueryLogConfig({
 *     filters: [
 *         {
 *             name: "Name",
 *             values: ["shared-query-log-config"],
 *         },
 *         {
 *             name: "ShareStatus",
 *             values: ["SHARED_WITH_ME"],
 *         },
 *     ],
 * });
 * ```
 */
export function getQueryLogConfigOutput(args?: GetQueryLogConfigOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetQueryLogConfigResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:route53/getQueryLogConfig:getQueryLogConfig", {
        "filters": args.filters,
        "name": args.name,
        "resolverQueryLogConfigId": args.resolverQueryLogConfigId,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getQueryLogConfig.
 */
export interface GetQueryLogConfigOutputArgs {
    /**
     * One or more name/value pairs to use as filters. There are
     * several valid keys, for a full reference, check out
     * [Route53resolver Filter value in the AWS API reference][1].
     */
    filters?: pulumi.Input<pulumi.Input<inputs.route53.GetQueryLogConfigFilterArgs>[]>;
    /**
     * The name of the query logging configuration.
     */
    name?: pulumi.Input<string>;
    /**
     * ID of the Route53 Resolver Query Logging Configuration.
     */
    resolverQueryLogConfigId?: pulumi.Input<string>;
    /**
     * Map of tags to assign to the service.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
