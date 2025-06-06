// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Resource for managing an AWS Chime SDK Media Pipelines Media Insights Pipeline Configuration.
 * Consult the [Call analytics developer guide](https://docs.aws.amazon.com/chime-sdk/latest/dg/call-analytics.html) for more detailed information about usage.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.kinesis.Stream("example", {
 *     name: "example",
 *     shardCount: 2,
 * });
 * const mediaPipelinesAssumeRole = aws.iam.getPolicyDocument({
 *     statements: [{
 *         effect: "Allow",
 *         principals: [{
 *             type: "Service",
 *             identifiers: ["mediapipelines.chime.amazonaws.com"],
 *         }],
 *         actions: ["sts:AssumeRole"],
 *     }],
 * });
 * const callAnalyticsRole = new aws.iam.Role("call_analytics_role", {
 *     name: "CallAnalyticsRole",
 *     assumeRolePolicy: mediaPipelinesAssumeRole.then(mediaPipelinesAssumeRole => mediaPipelinesAssumeRole.json),
 * });
 * const myConfiguration = new aws.chimesdkmediapipelines.MediaInsightsPipelineConfiguration("my_configuration", {
 *     name: "MyBasicConfiguration",
 *     resourceAccessRoleArn: callAnalyticsRole.arn,
 *     elements: [
 *         {
 *             type: "AmazonTranscribeCallAnalyticsProcessor",
 *             amazonTranscribeCallAnalyticsProcessorConfiguration: {
 *                 languageCode: "en-US",
 *             },
 *         },
 *         {
 *             type: "KinesisDataStreamSink",
 *             kinesisDataStreamSinkConfiguration: {
 *                 insightsTarget: example.arn,
 *             },
 *         },
 *     ],
 *     tags: {
 *         Key1: "Value1",
 *         Key2: "Value2",
 *     },
 * });
 * ```
 *
 * - The required policies on `callAnalyticsRole` will vary based on the selected processors. See [Call analytics resource access role](https://docs.aws.amazon.com/chime-sdk/latest/dg/ca-resource-access-role.html) for directions on choosing appropriate policies.
 *
 * ### Transcribe Call Analytics processor usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const transcribeAssumeRole = aws.iam.getPolicyDocument({
 *     statements: [{
 *         effect: "Allow",
 *         principals: [{
 *             type: "Service",
 *             identifiers: ["transcribe.amazonaws.com"],
 *         }],
 *         actions: ["sts:AssumeRole"],
 *     }],
 * });
 * const postCallRole = new aws.iam.Role("post_call_role", {
 *     name: "PostCallAccessRole",
 *     assumeRolePolicy: transcribeAssumeRole.then(transcribeAssumeRole => transcribeAssumeRole.json),
 * });
 * const myConfiguration = new aws.chimesdkmediapipelines.MediaInsightsPipelineConfiguration("my_configuration", {
 *     name: "MyCallAnalyticsConfiguration",
 *     resourceAccessRoleArn: exampleAwsIamRole.arn,
 *     elements: [
 *         {
 *             type: "AmazonTranscribeCallAnalyticsProcessor",
 *             amazonTranscribeCallAnalyticsProcessorConfiguration: {
 *                 callAnalyticsStreamCategories: [
 *                     "category_1",
 *                     "category_2",
 *                 ],
 *                 contentRedactionType: "PII",
 *                 enablePartialResultsStabilization: true,
 *                 filterPartialResults: true,
 *                 languageCode: "en-US",
 *                 languageModelName: "MyLanguageModel",
 *                 partialResultsStability: "high",
 *                 piiEntityTypes: "ADDRESS,BANK_ACCOUNT_NUMBER",
 *                 postCallAnalyticsSettings: {
 *                     contentRedactionOutput: "redacted",
 *                     dataAccessRoleArn: postCallRole.arn,
 *                     outputEncryptionKmsKeyId: "MyKmsKeyId",
 *                     outputLocation: "s3://MyBucket",
 *                 },
 *                 vocabularyFilterMethod: "mask",
 *                 vocabularyFilterName: "MyVocabularyFilter",
 *                 vocabularyName: "MyVocabulary",
 *             },
 *         },
 *         {
 *             type: "KinesisDataStreamSink",
 *             kinesisDataStreamSinkConfiguration: {
 *                 insightsTarget: example.arn,
 *             },
 *         },
 *     ],
 * });
 * ```
 *
 * ### Real time alerts usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const myConfiguration = new aws.chimesdkmediapipelines.MediaInsightsPipelineConfiguration("my_configuration", {
 *     name: "MyRealTimeAlertConfiguration",
 *     resourceAccessRoleArn: callAnalyticsRole.arn,
 *     elements: [
 *         {
 *             type: "AmazonTranscribeCallAnalyticsProcessor",
 *             amazonTranscribeCallAnalyticsProcessorConfiguration: {
 *                 languageCode: "en-US",
 *             },
 *         },
 *         {
 *             type: "KinesisDataStreamSink",
 *             kinesisDataStreamSinkConfiguration: {
 *                 insightsTarget: example.arn,
 *             },
 *         },
 *     ],
 *     realTimeAlertConfiguration: {
 *         disabled: false,
 *         rules: [
 *             {
 *                 type: "IssueDetection",
 *                 issueDetectionConfiguration: {
 *                     ruleName: "MyIssueDetectionRule",
 *                 },
 *             },
 *             {
 *                 type: "KeywordMatch",
 *                 keywordMatchConfiguration: {
 *                     keywords: [
 *                         "keyword1",
 *                         "keyword2",
 *                     ],
 *                     negate: false,
 *                     ruleName: "MyKeywordMatchRule",
 *                 },
 *             },
 *             {
 *                 type: "Sentiment",
 *                 sentimentConfiguration: {
 *                     ruleName: "MySentimentRule",
 *                     sentimentType: "NEGATIVE",
 *                     timePeriod: 60,
 *                 },
 *             },
 *         ],
 *     },
 * });
 * ```
 *
 * ### Transcribe processor usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const myConfiguration = new aws.chimesdkmediapipelines.MediaInsightsPipelineConfiguration("my_configuration", {
 *     name: "MyTranscribeConfiguration",
 *     resourceAccessRoleArn: exampleAwsIamRole.arn,
 *     elements: [
 *         {
 *             type: "AmazonTranscribeProcessor",
 *             amazonTranscribeProcessorConfiguration: {
 *                 contentIdentificationType: "PII",
 *                 enablePartialResultsStabilization: true,
 *                 filterPartialResults: true,
 *                 languageCode: "en-US",
 *                 languageModelName: "MyLanguageModel",
 *                 partialResultsStability: "high",
 *                 piiEntityTypes: "ADDRESS,BANK_ACCOUNT_NUMBER",
 *                 showSpeakerLabel: true,
 *                 vocabularyFilterMethod: "mask",
 *                 vocabularyFilterName: "MyVocabularyFilter",
 *                 vocabularyName: "MyVocabulary",
 *             },
 *         },
 *         {
 *             type: "KinesisDataStreamSink",
 *             kinesisDataStreamSinkConfiguration: {
 *                 insightsTarget: example.arn,
 *             },
 *         },
 *     ],
 * });
 * ```
 *
 * ### Voice analytics processor usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const myConfiguration = new aws.chimesdkmediapipelines.MediaInsightsPipelineConfiguration("my_configuration", {
 *     name: "MyVoiceAnalyticsConfiguration",
 *     resourceAccessRoleArn: example.arn,
 *     elements: [
 *         {
 *             type: "VoiceAnalyticsProcessor",
 *             voiceAnalyticsProcessorConfiguration: {
 *                 speakerSearchStatus: "Enabled",
 *                 voiceToneAnalysisStatus: "Enabled",
 *             },
 *         },
 *         {
 *             type: "LambdaFunctionSink",
 *             lambdaFunctionSinkConfiguration: {
 *                 insightsTarget: "arn:aws:lambda:us-west-2:1111111111:function:MyFunction",
 *             },
 *         },
 *         {
 *             type: "SnsTopicSink",
 *             snsTopicSinkConfiguration: {
 *                 insightsTarget: "arn:aws:sns:us-west-2:1111111111:topic/MyTopic",
 *             },
 *         },
 *         {
 *             type: "SqsQueueSink",
 *             sqsQueueSinkConfiguration: {
 *                 insightsTarget: "arn:aws:sqs:us-west-2:1111111111:queue/MyQueue",
 *             },
 *         },
 *         {
 *             type: "KinesisDataStreamSink",
 *             kinesisDataStreamSinkConfiguration: {
 *                 insightsTarget: test.arn,
 *             },
 *         },
 *     ],
 * });
 * ```
 *
 * ### S3 Recording sink usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const myConfiguration = new aws.chimesdkmediapipelines.MediaInsightsPipelineConfiguration("my_configuration", {
 *     name: "MyS3RecordingConfiguration",
 *     resourceAccessRoleArn: example.arn,
 *     elements: [{
 *         type: "S3RecordingSink",
 *         s3RecordingSinkConfiguration: {
 *             destination: "arn:aws:s3:::MyBucket",
 *         },
 *     }],
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Chime SDK Media Pipelines Media Insights Pipeline Configuration using the `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:chimesdkmediapipelines/mediaInsightsPipelineConfiguration:MediaInsightsPipelineConfiguration example abcdef123456
 * ```
 */
export class MediaInsightsPipelineConfiguration extends pulumi.CustomResource {
    /**
     * Get an existing MediaInsightsPipelineConfiguration resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: MediaInsightsPipelineConfigurationState, opts?: pulumi.CustomResourceOptions): MediaInsightsPipelineConfiguration {
        return new MediaInsightsPipelineConfiguration(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:chimesdkmediapipelines/mediaInsightsPipelineConfiguration:MediaInsightsPipelineConfiguration';

    /**
     * Returns true if the given object is an instance of MediaInsightsPipelineConfiguration.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is MediaInsightsPipelineConfiguration {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === MediaInsightsPipelineConfiguration.__pulumiType;
    }

    /**
     * ARN of the Media Insights Pipeline Configuration.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * Collection of processors and sinks to transform media and deliver data.
     */
    public readonly elements!: pulumi.Output<outputs.chimesdkmediapipelines.MediaInsightsPipelineConfigurationElement[]>;
    /**
     * Configuration name.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * Configuration for real-time alert rules to send EventBridge notifications when certain conditions are met.
     */
    public readonly realTimeAlertConfiguration!: pulumi.Output<outputs.chimesdkmediapipelines.MediaInsightsPipelineConfigurationRealTimeAlertConfiguration | undefined>;
    /**
     * ARN of IAM Role used by service to invoke processors and sinks specified by configuration elements.
     */
    public readonly resourceAccessRoleArn!: pulumi.Output<string>;
    /**
     * Key-value map of tags for the resource.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;

    /**
     * Create a MediaInsightsPipelineConfiguration resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: MediaInsightsPipelineConfigurationArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: MediaInsightsPipelineConfigurationArgs | MediaInsightsPipelineConfigurationState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as MediaInsightsPipelineConfigurationState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["elements"] = state ? state.elements : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["realTimeAlertConfiguration"] = state ? state.realTimeAlertConfiguration : undefined;
            resourceInputs["resourceAccessRoleArn"] = state ? state.resourceAccessRoleArn : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as MediaInsightsPipelineConfigurationArgs | undefined;
            if ((!args || args.elements === undefined) && !opts.urn) {
                throw new Error("Missing required property 'elements'");
            }
            if ((!args || args.resourceAccessRoleArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'resourceAccessRoleArn'");
            }
            resourceInputs["elements"] = args ? args.elements : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["realTimeAlertConfiguration"] = args ? args.realTimeAlertConfiguration : undefined;
            resourceInputs["resourceAccessRoleArn"] = args ? args.resourceAccessRoleArn : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(MediaInsightsPipelineConfiguration.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering MediaInsightsPipelineConfiguration resources.
 */
export interface MediaInsightsPipelineConfigurationState {
    /**
     * ARN of the Media Insights Pipeline Configuration.
     */
    arn?: pulumi.Input<string>;
    /**
     * Collection of processors and sinks to transform media and deliver data.
     */
    elements?: pulumi.Input<pulumi.Input<inputs.chimesdkmediapipelines.MediaInsightsPipelineConfigurationElement>[]>;
    /**
     * Configuration name.
     */
    name?: pulumi.Input<string>;
    /**
     * Configuration for real-time alert rules to send EventBridge notifications when certain conditions are met.
     */
    realTimeAlertConfiguration?: pulumi.Input<inputs.chimesdkmediapipelines.MediaInsightsPipelineConfigurationRealTimeAlertConfiguration>;
    /**
     * ARN of IAM Role used by service to invoke processors and sinks specified by configuration elements.
     */
    resourceAccessRoleArn?: pulumi.Input<string>;
    /**
     * Key-value map of tags for the resource.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}

/**
 * The set of arguments for constructing a MediaInsightsPipelineConfiguration resource.
 */
export interface MediaInsightsPipelineConfigurationArgs {
    /**
     * Collection of processors and sinks to transform media and deliver data.
     */
    elements: pulumi.Input<pulumi.Input<inputs.chimesdkmediapipelines.MediaInsightsPipelineConfigurationElement>[]>;
    /**
     * Configuration name.
     */
    name?: pulumi.Input<string>;
    /**
     * Configuration for real-time alert rules to send EventBridge notifications when certain conditions are met.
     */
    realTimeAlertConfiguration?: pulumi.Input<inputs.chimesdkmediapipelines.MediaInsightsPipelineConfigurationRealTimeAlertConfiguration>;
    /**
     * ARN of IAM Role used by service to invoke processors and sinks specified by configuration elements.
     */
    resourceAccessRoleArn: pulumi.Input<string>;
    /**
     * Key-value map of tags for the resource.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
