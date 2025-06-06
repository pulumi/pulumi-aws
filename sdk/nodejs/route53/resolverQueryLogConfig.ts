// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides a Route 53 Resolver query logging configuration resource.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.route53.ResolverQueryLogConfig("example", {
 *     name: "example",
 *     destinationArn: exampleAwsS3Bucket.arn,
 *     tags: {
 *         Environment: "Prod",
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import  Route 53 Resolver query logging configurations using the Route 53 Resolver query logging configuration ID. For example:
 *
 * ```sh
 * $ pulumi import aws:route53/resolverQueryLogConfig:ResolverQueryLogConfig example rqlc-92edc3b1838248bf
 * ```
 */
export class ResolverQueryLogConfig extends pulumi.CustomResource {
    /**
     * Get an existing ResolverQueryLogConfig resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ResolverQueryLogConfigState, opts?: pulumi.CustomResourceOptions): ResolverQueryLogConfig {
        return new ResolverQueryLogConfig(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:route53/resolverQueryLogConfig:ResolverQueryLogConfig';

    /**
     * Returns true if the given object is an instance of ResolverQueryLogConfig.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is ResolverQueryLogConfig {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === ResolverQueryLogConfig.__pulumiType;
    }

    /**
     * The ARN (Amazon Resource Name) of the Route 53 Resolver query logging configuration.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * The ARN of the resource that you want Route 53 Resolver to send query logs.
     * You can send query logs to an S3 bucket, a CloudWatch Logs log group, or a Kinesis Data Firehose delivery stream.
     */
    public readonly destinationArn!: pulumi.Output<string>;
    /**
     * The name of the Route 53 Resolver query logging configuration.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * The AWS account ID of the account that created the query logging configuration.
     */
    public /*out*/ readonly ownerId!: pulumi.Output<string>;
    /**
     * An indication of whether the query logging configuration is shared with other AWS accounts, or was shared with the current account by another AWS account.
     * Sharing is configured through AWS Resource Access Manager (AWS RAM).
     * Values are `NOT_SHARED`, `SHARED_BY_ME` or `SHARED_WITH_ME`
     */
    public /*out*/ readonly shareStatus!: pulumi.Output<string>;
    /**
     * A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;

    /**
     * Create a ResolverQueryLogConfig resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: ResolverQueryLogConfigArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ResolverQueryLogConfigArgs | ResolverQueryLogConfigState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ResolverQueryLogConfigState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["destinationArn"] = state ? state.destinationArn : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["ownerId"] = state ? state.ownerId : undefined;
            resourceInputs["shareStatus"] = state ? state.shareStatus : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as ResolverQueryLogConfigArgs | undefined;
            if ((!args || args.destinationArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'destinationArn'");
            }
            resourceInputs["destinationArn"] = args ? args.destinationArn : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["ownerId"] = undefined /*out*/;
            resourceInputs["shareStatus"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(ResolverQueryLogConfig.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering ResolverQueryLogConfig resources.
 */
export interface ResolverQueryLogConfigState {
    /**
     * The ARN (Amazon Resource Name) of the Route 53 Resolver query logging configuration.
     */
    arn?: pulumi.Input<string>;
    /**
     * The ARN of the resource that you want Route 53 Resolver to send query logs.
     * You can send query logs to an S3 bucket, a CloudWatch Logs log group, or a Kinesis Data Firehose delivery stream.
     */
    destinationArn?: pulumi.Input<string>;
    /**
     * The name of the Route 53 Resolver query logging configuration.
     */
    name?: pulumi.Input<string>;
    /**
     * The AWS account ID of the account that created the query logging configuration.
     */
    ownerId?: pulumi.Input<string>;
    /**
     * An indication of whether the query logging configuration is shared with other AWS accounts, or was shared with the current account by another AWS account.
     * Sharing is configured through AWS Resource Access Manager (AWS RAM).
     * Values are `NOT_SHARED`, `SHARED_BY_ME` or `SHARED_WITH_ME`
     */
    shareStatus?: pulumi.Input<string>;
    /**
     * A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}

/**
 * The set of arguments for constructing a ResolverQueryLogConfig resource.
 */
export interface ResolverQueryLogConfigArgs {
    /**
     * The ARN of the resource that you want Route 53 Resolver to send query logs.
     * You can send query logs to an S3 bucket, a CloudWatch Logs log group, or a Kinesis Data Firehose delivery stream.
     */
    destinationArn: pulumi.Input<string>;
    /**
     * The name of the Route 53 Resolver query logging configuration.
     */
    name?: pulumi.Input<string>;
    /**
     * A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
