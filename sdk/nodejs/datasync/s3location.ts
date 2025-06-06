// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

import {ARN} from "..";

/**
 * Manages an S3 Location within AWS DataSync.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.datasync.S3Location("example", {
 *     s3BucketArn: exampleAwsS3Bucket.arn,
 *     subdirectory: "/example/prefix",
 *     s3Config: {
 *         bucketAccessRoleArn: exampleAwsIamRole.arn,
 *     },
 * });
 * ```
 *
 * ### S3 Bucket on AWS Outposts
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const destination = new aws.datasync.S3Location("destination", {
 *     agentArns: [exampleAwsDatasyncAgent.arn],
 *     s3BucketArn: exampleAwsS3AccessPoint.arn,
 *     s3StorageClass: "OUTPOSTS",
 *     subdirectory: "/example/prefix",
 *     s3Config: {
 *         bucketAccessRoleArn: example.arn,
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import `aws_datasync_location_s3` using the DataSync Task Amazon Resource Name (ARN). For example:
 *
 * ```sh
 * $ pulumi import aws:datasync/s3Location:S3Location example arn:aws:datasync:us-east-1:123456789012:location/loc-12345678901234567
 * ```
 */
export class S3Location extends pulumi.CustomResource {
    /**
     * Get an existing S3Location resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: S3LocationState, opts?: pulumi.CustomResourceOptions): S3Location {
        return new S3Location(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:datasync/s3Location:S3Location';

    /**
     * Returns true if the given object is an instance of S3Location.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is S3Location {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === S3Location.__pulumiType;
    }

    /**
     * (Amazon S3 on Outposts only) Amazon Resource Name (ARN) of the DataSync agent on the Outpost.
     */
    public readonly agentArns!: pulumi.Output<string[] | undefined>;
    /**
     * Amazon Resource Name (ARN) of the DataSync Location.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * Amazon Resource Name (ARN) of the S3 bucket, or the Amazon S3 access point if the S3 bucket is located on an AWS Outposts resource.
     */
    public readonly s3BucketArn!: pulumi.Output<ARN>;
    /**
     * Configuration block containing information for connecting to S3.
     */
    public readonly s3Config!: pulumi.Output<outputs.datasync.S3LocationS3Config>;
    /**
     * Amazon S3 storage class that you want to store your files in when this location is used as a task destination. [Valid values](https://docs.aws.amazon.com/datasync/latest/userguide/create-s3-location.html#using-storage-classes)
     */
    public readonly s3StorageClass!: pulumi.Output<string>;
    /**
     * Prefix to perform actions as source or destination.
     */
    public readonly subdirectory!: pulumi.Output<string>;
    /**
     * Key-value pairs of resource tags to assign to the DataSync Location. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    public /*out*/ readonly uri!: pulumi.Output<string>;

    /**
     * Create a S3Location resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: S3LocationArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: S3LocationArgs | S3LocationState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as S3LocationState | undefined;
            resourceInputs["agentArns"] = state ? state.agentArns : undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["s3BucketArn"] = state ? state.s3BucketArn : undefined;
            resourceInputs["s3Config"] = state ? state.s3Config : undefined;
            resourceInputs["s3StorageClass"] = state ? state.s3StorageClass : undefined;
            resourceInputs["subdirectory"] = state ? state.subdirectory : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["uri"] = state ? state.uri : undefined;
        } else {
            const args = argsOrState as S3LocationArgs | undefined;
            if ((!args || args.s3BucketArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 's3BucketArn'");
            }
            if ((!args || args.s3Config === undefined) && !opts.urn) {
                throw new Error("Missing required property 's3Config'");
            }
            if ((!args || args.subdirectory === undefined) && !opts.urn) {
                throw new Error("Missing required property 'subdirectory'");
            }
            resourceInputs["agentArns"] = args ? args.agentArns : undefined;
            resourceInputs["s3BucketArn"] = args ? args.s3BucketArn : undefined;
            resourceInputs["s3Config"] = args ? args.s3Config : undefined;
            resourceInputs["s3StorageClass"] = args ? args.s3StorageClass : undefined;
            resourceInputs["subdirectory"] = args ? args.subdirectory : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
            resourceInputs["uri"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(S3Location.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering S3Location resources.
 */
export interface S3LocationState {
    /**
     * (Amazon S3 on Outposts only) Amazon Resource Name (ARN) of the DataSync agent on the Outpost.
     */
    agentArns?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Amazon Resource Name (ARN) of the DataSync Location.
     */
    arn?: pulumi.Input<string>;
    /**
     * Amazon Resource Name (ARN) of the S3 bucket, or the Amazon S3 access point if the S3 bucket is located on an AWS Outposts resource.
     */
    s3BucketArn?: pulumi.Input<ARN>;
    /**
     * Configuration block containing information for connecting to S3.
     */
    s3Config?: pulumi.Input<inputs.datasync.S3LocationS3Config>;
    /**
     * Amazon S3 storage class that you want to store your files in when this location is used as a task destination. [Valid values](https://docs.aws.amazon.com/datasync/latest/userguide/create-s3-location.html#using-storage-classes)
     */
    s3StorageClass?: pulumi.Input<string>;
    /**
     * Prefix to perform actions as source or destination.
     */
    subdirectory?: pulumi.Input<string>;
    /**
     * Key-value pairs of resource tags to assign to the DataSync Location. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    uri?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a S3Location resource.
 */
export interface S3LocationArgs {
    /**
     * (Amazon S3 on Outposts only) Amazon Resource Name (ARN) of the DataSync agent on the Outpost.
     */
    agentArns?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Amazon Resource Name (ARN) of the S3 bucket, or the Amazon S3 access point if the S3 bucket is located on an AWS Outposts resource.
     */
    s3BucketArn: pulumi.Input<ARN>;
    /**
     * Configuration block containing information for connecting to S3.
     */
    s3Config: pulumi.Input<inputs.datasync.S3LocationS3Config>;
    /**
     * Amazon S3 storage class that you want to store your files in when this location is used as a task destination. [Valid values](https://docs.aws.amazon.com/datasync/latest/userguide/create-s3-location.html#using-storage-classes)
     */
    s3StorageClass?: pulumi.Input<string>;
    /**
     * Prefix to perform actions as source or destination.
     */
    subdirectory: pulumi.Input<string>;
    /**
     * Key-value pairs of resource tags to assign to the DataSync Location. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
