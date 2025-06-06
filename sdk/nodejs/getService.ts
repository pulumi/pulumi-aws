// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "./utilities";

/**
 * Use this data source to compose and decompose AWS service DNS names.
 *
 * ## Example Usage
 *
 * ### Get Service DNS Name
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const current = aws.getRegion({});
 * const test = current.then(current => aws.getService({
 *     region: current.name,
 *     serviceId: "ec2",
 * }));
 * ```
 *
 * ### Use Service Reverse DNS Name to Get Components
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const s3 = aws.getService({
 *     reverseDnsName: "cn.com.amazonaws.cn-north-1.s3",
 * });
 * ```
 *
 * ### Determine Regional Support for a Service
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const s3 = aws.getService({
 *     reverseDnsName: "com.amazonaws.us-gov-west-1.waf",
 * });
 * ```
 */
export function getService(args?: GetServiceArgs, opts?: pulumi.InvokeOptions): Promise<GetServiceResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:index/getService:getService", {
        "dnsName": args.dnsName,
        "id": args.id,
        "region": args.region,
        "reverseDnsName": args.reverseDnsName,
        "reverseDnsPrefix": args.reverseDnsPrefix,
        "serviceId": args.serviceId,
    }, opts);
}

/**
 * A collection of arguments for invoking getService.
 */
export interface GetServiceArgs {
    /**
     * DNS name of the service (_e.g.,_ `rds.us-east-1.amazonaws.com`). One of `dnsName`, `reverseDnsName`, or `serviceId` is required.
     */
    dnsName?: string;
    id?: string;
    /**
     * Region of the service (_e.g.,_ `us-west-2`, `ap-northeast-1`).
     */
    region?: string;
    /**
     * Reverse DNS name of the service (_e.g.,_ `com.amazonaws.us-west-2.s3`). One of `dnsName`, `reverseDnsName`, or `serviceId` is required.
     */
    reverseDnsName?: string;
    /**
     * Prefix of the service (_e.g.,_ `com.amazonaws` in AWS Commercial, `cn.com.amazonaws` in AWS China).
     */
    reverseDnsPrefix?: string;
    /**
     * Service endpoint ID (_e.g.,_ `s3`, `rds`, `ec2`). One of `dnsName`, `reverseDnsName`, or `serviceId` is required. A service's endpoint ID can be found in the [_AWS General Reference_](https://docs.aws.amazon.com/general/latest/gr/aws-service-information.html).
     */
    serviceId?: string;
}

/**
 * A collection of values returned by getService.
 */
export interface GetServiceResult {
    readonly dnsName: string;
    readonly id: string;
    readonly partition: string;
    readonly region: string;
    readonly reverseDnsName: string;
    readonly reverseDnsPrefix: string;
    readonly serviceId: string;
    /**
     * Whether the service is supported in the region's partition. New services may not be listed immediately as supported.
     */
    readonly supported: boolean;
}
/**
 * Use this data source to compose and decompose AWS service DNS names.
 *
 * ## Example Usage
 *
 * ### Get Service DNS Name
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const current = aws.getRegion({});
 * const test = current.then(current => aws.getService({
 *     region: current.name,
 *     serviceId: "ec2",
 * }));
 * ```
 *
 * ### Use Service Reverse DNS Name to Get Components
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const s3 = aws.getService({
 *     reverseDnsName: "cn.com.amazonaws.cn-north-1.s3",
 * });
 * ```
 *
 * ### Determine Regional Support for a Service
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const s3 = aws.getService({
 *     reverseDnsName: "com.amazonaws.us-gov-west-1.waf",
 * });
 * ```
 */
export function getServiceOutput(args?: GetServiceOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetServiceResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:index/getService:getService", {
        "dnsName": args.dnsName,
        "id": args.id,
        "region": args.region,
        "reverseDnsName": args.reverseDnsName,
        "reverseDnsPrefix": args.reverseDnsPrefix,
        "serviceId": args.serviceId,
    }, opts);
}

/**
 * A collection of arguments for invoking getService.
 */
export interface GetServiceOutputArgs {
    /**
     * DNS name of the service (_e.g.,_ `rds.us-east-1.amazonaws.com`). One of `dnsName`, `reverseDnsName`, or `serviceId` is required.
     */
    dnsName?: pulumi.Input<string>;
    id?: pulumi.Input<string>;
    /**
     * Region of the service (_e.g.,_ `us-west-2`, `ap-northeast-1`).
     */
    region?: pulumi.Input<string>;
    /**
     * Reverse DNS name of the service (_e.g.,_ `com.amazonaws.us-west-2.s3`). One of `dnsName`, `reverseDnsName`, or `serviceId` is required.
     */
    reverseDnsName?: pulumi.Input<string>;
    /**
     * Prefix of the service (_e.g.,_ `com.amazonaws` in AWS Commercial, `cn.com.amazonaws` in AWS China).
     */
    reverseDnsPrefix?: pulumi.Input<string>;
    /**
     * Service endpoint ID (_e.g.,_ `s3`, `rds`, `ec2`). One of `dnsName`, `reverseDnsName`, or `serviceId` is required. A service's endpoint ID can be found in the [_AWS General Reference_](https://docs.aws.amazon.com/general/latest/gr/aws-service-information.html).
     */
    serviceId?: pulumi.Input<string>;
}
