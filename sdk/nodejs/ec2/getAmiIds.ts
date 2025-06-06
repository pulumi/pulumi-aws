// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Use this data source to get a list of AMI IDs matching the specified criteria.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const ubuntu = aws.ec2.getAmiIds({
 *     owners: ["099720109477"],
 *     filters: [{
 *         name: "name",
 *         values: ["ubuntu/images/ubuntu-*-*-amd64-server-*"],
 *     }],
 * });
 * ```
 */
export function getAmiIds(args: GetAmiIdsArgs, opts?: pulumi.InvokeOptions): Promise<GetAmiIdsResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:ec2/getAmiIds:getAmiIds", {
        "executableUsers": args.executableUsers,
        "filters": args.filters,
        "includeDeprecated": args.includeDeprecated,
        "nameRegex": args.nameRegex,
        "owners": args.owners,
        "sortAscending": args.sortAscending,
    }, opts);
}

/**
 * A collection of arguments for invoking getAmiIds.
 */
export interface GetAmiIdsArgs {
    /**
     * Limit search to users with *explicit* launch
     * permission on  the image. Valid items are the numeric account ID or `self`.
     */
    executableUsers?: string[];
    /**
     * One or more name/value pairs to filter off of. There
     * are several valid keys, for a full reference, check out
     * [describe-images in the AWS CLI reference][1].
     */
    filters?: inputs.ec2.GetAmiIdsFilter[];
    /**
     * If true, all deprecated AMIs are included in the response.
     * If false, no deprecated AMIs are included in the response. If no value is specified, the default value is `false`.
     */
    includeDeprecated?: boolean;
    /**
     * Regex string to apply to the AMI list returned
     * by AWS. This allows more advanced filtering not supported from the AWS API.
     * This filtering is done locally on what AWS returns, and could have a performance
     * impact if the result is large. Combine this with other
     * options to narrow down the list AWS returns.
     */
    nameRegex?: string;
    /**
     * List of AMI owners to limit search. At least 1 value must be specified. Valid values: an AWS account ID, `self` (the current account), or an AWS owner alias (e.g., `amazon`, `aws-marketplace`, `microsoft`).
     */
    owners: string[];
    /**
     * Used to sort AMIs by creation time.
     * If no value is specified, the default value is `false`.
     */
    sortAscending?: boolean;
}

/**
 * A collection of values returned by getAmiIds.
 */
export interface GetAmiIdsResult {
    readonly executableUsers?: string[];
    readonly filters?: outputs.ec2.GetAmiIdsFilter[];
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * is set to the list of AMI IDs, sorted by creation time according to `sortAscending`.
     */
    readonly ids: string[];
    readonly includeDeprecated?: boolean;
    readonly nameRegex?: string;
    readonly owners: string[];
    readonly sortAscending?: boolean;
}
/**
 * Use this data source to get a list of AMI IDs matching the specified criteria.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const ubuntu = aws.ec2.getAmiIds({
 *     owners: ["099720109477"],
 *     filters: [{
 *         name: "name",
 *         values: ["ubuntu/images/ubuntu-*-*-amd64-server-*"],
 *     }],
 * });
 * ```
 */
export function getAmiIdsOutput(args: GetAmiIdsOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetAmiIdsResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:ec2/getAmiIds:getAmiIds", {
        "executableUsers": args.executableUsers,
        "filters": args.filters,
        "includeDeprecated": args.includeDeprecated,
        "nameRegex": args.nameRegex,
        "owners": args.owners,
        "sortAscending": args.sortAscending,
    }, opts);
}

/**
 * A collection of arguments for invoking getAmiIds.
 */
export interface GetAmiIdsOutputArgs {
    /**
     * Limit search to users with *explicit* launch
     * permission on  the image. Valid items are the numeric account ID or `self`.
     */
    executableUsers?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * One or more name/value pairs to filter off of. There
     * are several valid keys, for a full reference, check out
     * [describe-images in the AWS CLI reference][1].
     */
    filters?: pulumi.Input<pulumi.Input<inputs.ec2.GetAmiIdsFilterArgs>[]>;
    /**
     * If true, all deprecated AMIs are included in the response.
     * If false, no deprecated AMIs are included in the response. If no value is specified, the default value is `false`.
     */
    includeDeprecated?: pulumi.Input<boolean>;
    /**
     * Regex string to apply to the AMI list returned
     * by AWS. This allows more advanced filtering not supported from the AWS API.
     * This filtering is done locally on what AWS returns, and could have a performance
     * impact if the result is large. Combine this with other
     * options to narrow down the list AWS returns.
     */
    nameRegex?: pulumi.Input<string>;
    /**
     * List of AMI owners to limit search. At least 1 value must be specified. Valid values: an AWS account ID, `self` (the current account), or an AWS owner alias (e.g., `amazon`, `aws-marketplace`, `microsoft`).
     */
    owners: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Used to sort AMIs by creation time.
     * If no value is specified, the default value is `false`.
     */
    sortAscending?: pulumi.Input<boolean>;
}
