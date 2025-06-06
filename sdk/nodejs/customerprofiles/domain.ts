// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Resource for managing an Amazon Customer Profiles Domain.
 * See the [Create Domain](https://docs.aws.amazon.com/customerprofiles/latest/APIReference/API_CreateDomain.html) for more information.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.customerprofiles.Domain("example", {domainName: "example"});
 * ```
 *
 * ### With SQS DLQ and KMS set
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.sqs.Queue("example", {
 *     name: "example",
 *     policy: JSON.stringify({
 *         Version: "2012-10-17",
 *         Statement: [{
 *             Sid: "Customer Profiles SQS policy",
 *             Effect: "Allow",
 *             Action: ["sqs:SendMessage"],
 *             Resource: "*",
 *             Principal: {
 *                 Service: "profile.amazonaws.com",
 *             },
 *         }],
 *     }),
 * });
 * const exampleKey = new aws.kms.Key("example", {
 *     description: "example",
 *     deletionWindowInDays: 10,
 * });
 * const exampleBucketV2 = new aws.s3.BucketV2("example", {
 *     bucket: "example",
 *     forceDestroy: true,
 * });
 * const exampleBucketPolicy = new aws.s3.BucketPolicy("example", {
 *     bucket: exampleBucketV2.id,
 *     policy: pulumi.jsonStringify({
 *         Version: "2012-10-17",
 *         Statement: [{
 *             Sid: "Customer Profiles S3 policy",
 *             Effect: "Allow",
 *             Action: [
 *                 "s3:GetObject",
 *                 "s3:PutObject",
 *                 "s3:ListBucket",
 *             ],
 *             Resource: [
 *                 exampleBucketV2.arn,
 *                 pulumi.interpolate`${exampleBucketV2.arn}/*`,
 *             ],
 *             Principal: {
 *                 Service: "profile.amazonaws.com",
 *             },
 *         }],
 *     }),
 * });
 * const test = new aws.customerprofiles.Domain("test", {
 *     domainName: example,
 *     deadLetterQueueUrl: example.id,
 *     defaultEncryptionKey: exampleKey.arn,
 *     defaultExpirationDays: 365,
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Amazon Customer Profiles Domain using the resource `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:customerprofiles/domain:Domain example e6f777be-22d0-4b40-b307-5d2720ef16b2
 * ```
 */
export class Domain extends pulumi.CustomResource {
    /**
     * Get an existing Domain resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: DomainState, opts?: pulumi.CustomResourceOptions): Domain {
        return new Domain(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:customerprofiles/domain:Domain';

    /**
     * Returns true if the given object is an instance of Domain.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Domain {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Domain.__pulumiType;
    }

    /**
     * The Amazon Resource Name (ARN) of the Customer Profiles Domain.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * The URL of the SQS dead letter queue, which is used for reporting errors associated with ingesting data from third party applications.
     */
    public readonly deadLetterQueueUrl!: pulumi.Output<string | undefined>;
    /**
     * The default encryption key, which is an AWS managed key, is used when no specific type of encryption key is specified. It is used to encrypt all data before it is placed in permanent or semi-permanent storage.
     */
    public readonly defaultEncryptionKey!: pulumi.Output<string | undefined>;
    /**
     * The default number of days until the data within the domain expires.
     *
     * The following arguments are optional:
     */
    public readonly defaultExpirationDays!: pulumi.Output<number>;
    /**
     * The name for your Customer Profile domain. It must be unique for your AWS account.
     */
    public readonly domainName!: pulumi.Output<string>;
    /**
     * A block that specifies the process of matching duplicate profiles. Documented below.
     */
    public readonly matching!: pulumi.Output<outputs.customerprofiles.DomainMatching | undefined>;
    /**
     * A block that specifies the process of matching duplicate profiles using the Rule-Based matching. Documented below.
     */
    public readonly ruleBasedMatching!: pulumi.Output<outputs.customerprofiles.DomainRuleBasedMatching | undefined>;
    /**
     * Tags to apply to the domain. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;

    /**
     * Create a Domain resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: DomainArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: DomainArgs | DomainState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as DomainState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["deadLetterQueueUrl"] = state ? state.deadLetterQueueUrl : undefined;
            resourceInputs["defaultEncryptionKey"] = state ? state.defaultEncryptionKey : undefined;
            resourceInputs["defaultExpirationDays"] = state ? state.defaultExpirationDays : undefined;
            resourceInputs["domainName"] = state ? state.domainName : undefined;
            resourceInputs["matching"] = state ? state.matching : undefined;
            resourceInputs["ruleBasedMatching"] = state ? state.ruleBasedMatching : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as DomainArgs | undefined;
            if ((!args || args.defaultExpirationDays === undefined) && !opts.urn) {
                throw new Error("Missing required property 'defaultExpirationDays'");
            }
            if ((!args || args.domainName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'domainName'");
            }
            resourceInputs["deadLetterQueueUrl"] = args ? args.deadLetterQueueUrl : undefined;
            resourceInputs["defaultEncryptionKey"] = args ? args.defaultEncryptionKey : undefined;
            resourceInputs["defaultExpirationDays"] = args ? args.defaultExpirationDays : undefined;
            resourceInputs["domainName"] = args ? args.domainName : undefined;
            resourceInputs["matching"] = args ? args.matching : undefined;
            resourceInputs["ruleBasedMatching"] = args ? args.ruleBasedMatching : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Domain.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Domain resources.
 */
export interface DomainState {
    /**
     * The Amazon Resource Name (ARN) of the Customer Profiles Domain.
     */
    arn?: pulumi.Input<string>;
    /**
     * The URL of the SQS dead letter queue, which is used for reporting errors associated with ingesting data from third party applications.
     */
    deadLetterQueueUrl?: pulumi.Input<string>;
    /**
     * The default encryption key, which is an AWS managed key, is used when no specific type of encryption key is specified. It is used to encrypt all data before it is placed in permanent or semi-permanent storage.
     */
    defaultEncryptionKey?: pulumi.Input<string>;
    /**
     * The default number of days until the data within the domain expires.
     *
     * The following arguments are optional:
     */
    defaultExpirationDays?: pulumi.Input<number>;
    /**
     * The name for your Customer Profile domain. It must be unique for your AWS account.
     */
    domainName?: pulumi.Input<string>;
    /**
     * A block that specifies the process of matching duplicate profiles. Documented below.
     */
    matching?: pulumi.Input<inputs.customerprofiles.DomainMatching>;
    /**
     * A block that specifies the process of matching duplicate profiles using the Rule-Based matching. Documented below.
     */
    ruleBasedMatching?: pulumi.Input<inputs.customerprofiles.DomainRuleBasedMatching>;
    /**
     * Tags to apply to the domain. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
 * The set of arguments for constructing a Domain resource.
 */
export interface DomainArgs {
    /**
     * The URL of the SQS dead letter queue, which is used for reporting errors associated with ingesting data from third party applications.
     */
    deadLetterQueueUrl?: pulumi.Input<string>;
    /**
     * The default encryption key, which is an AWS managed key, is used when no specific type of encryption key is specified. It is used to encrypt all data before it is placed in permanent or semi-permanent storage.
     */
    defaultEncryptionKey?: pulumi.Input<string>;
    /**
     * The default number of days until the data within the domain expires.
     *
     * The following arguments are optional:
     */
    defaultExpirationDays: pulumi.Input<number>;
    /**
     * The name for your Customer Profile domain. It must be unique for your AWS account.
     */
    domainName: pulumi.Input<string>;
    /**
     * A block that specifies the process of matching duplicate profiles. Documented below.
     */
    matching?: pulumi.Input<inputs.customerprofiles.DomainMatching>;
    /**
     * A block that specifies the process of matching duplicate profiles using the Rule-Based matching. Documented below.
     */
    ruleBasedMatching?: pulumi.Input<inputs.customerprofiles.DomainRuleBasedMatching>;
    /**
     * Tags to apply to the domain. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
