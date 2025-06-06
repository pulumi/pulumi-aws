// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides details about a specific Amazon Kendra Index.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.kendra.getIndex({
 *     id: "12345678-1234-1234-1234-123456789123",
 * });
 * ```
 */
export function getIndex(args: GetIndexArgs, opts?: pulumi.InvokeOptions): Promise<GetIndexResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:kendra/getIndex:getIndex", {
        "id": args.id,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getIndex.
 */
export interface GetIndexArgs {
    /**
     * Returns information on a specific Index by id.
     */
    id: string;
    /**
     * Metadata that helps organize the Indices you create.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getIndex.
 */
export interface GetIndexResult {
    /**
     * ARN of the Index.
     */
    readonly arn: string;
    /**
     * Block that sets the number of additional document storage and query capacity units that should be used by the index. Documented below.
     */
    readonly capacityUnits: outputs.kendra.GetIndexCapacityUnit[];
    /**
     * Unix datetime that the index was created.
     */
    readonly createdAt: string;
    /**
     * Description of the Index.
     */
    readonly description: string;
    /**
     * One or more blocks that specify the configuration settings for any metadata applied to the documents in the index. Documented below.
     */
    readonly documentMetadataConfigurationUpdates: outputs.kendra.GetIndexDocumentMetadataConfigurationUpdate[];
    /**
     * Amazon Kendra edition for the index.
     */
    readonly edition: string;
    /**
     * When the Status field value is `FAILED`, this contains a message that explains why.
     */
    readonly errorMessage: string;
    /**
     * Identifier of the Index.
     */
    readonly id: string;
    /**
     * Block that provides information about the number of FAQ questions and answers and the number of text documents indexed. Documented below.
     */
    readonly indexStatistics: outputs.kendra.GetIndexIndexStatistic[];
    /**
     * Name of the index field. Minimum length of 1. Maximum length of 30.
     */
    readonly name: string;
    /**
     * An AWS Identity and Access Management (IAM) role that gives Amazon Kendra permissions to access your Amazon CloudWatch logs and metrics. This is also the role you use when you call the `BatchPutDocument` API to index documents from an Amazon S3 bucket.
     */
    readonly roleArn: string;
    /**
     * A block that specifies the identifier of the AWS KMS customer managed key (CMK) that's used to encrypt data indexed by Amazon Kendra. Amazon Kendra doesn't support asymmetric CMKs. Documented below.
     */
    readonly serverSideEncryptionConfigurations: outputs.kendra.GetIndexServerSideEncryptionConfiguration[];
    /**
     * Current status of the index. When the value is `ACTIVE`, the index is ready for use. If the Status field value is `FAILED`, the `errorMessage` field contains a message that explains why.
     */
    readonly status: string;
    /**
     * Metadata that helps organize the Indices you create.
     */
    readonly tags: {[key: string]: string};
    /**
     * Unix datetime that the index was last updated.
     */
    readonly updatedAt: string;
    /**
     * User context policy. Valid values are `ATTRIBUTE_FILTER` or `USER_TOKEN`. For more information, refer to [UserContextPolicy](https://docs.aws.amazon.com/kendra/latest/APIReference/API_CreateIndex.html#kendra-CreateIndex-request-UserContextPolicy).
     */
    readonly userContextPolicy: string;
    /**
     * A block that enables fetching access levels of groups and users from an AWS Single Sign-On identity source. Documented below.
     */
    readonly userGroupResolutionConfigurations: outputs.kendra.GetIndexUserGroupResolutionConfiguration[];
    /**
     * A block that specifies the user token configuration. Documented below.
     */
    readonly userTokenConfigurations: outputs.kendra.GetIndexUserTokenConfiguration[];
}
/**
 * Provides details about a specific Amazon Kendra Index.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.kendra.getIndex({
 *     id: "12345678-1234-1234-1234-123456789123",
 * });
 * ```
 */
export function getIndexOutput(args: GetIndexOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetIndexResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:kendra/getIndex:getIndex", {
        "id": args.id,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getIndex.
 */
export interface GetIndexOutputArgs {
    /**
     * Returns information on a specific Index by id.
     */
    id: pulumi.Input<string>;
    /**
     * Metadata that helps organize the Indices you create.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
