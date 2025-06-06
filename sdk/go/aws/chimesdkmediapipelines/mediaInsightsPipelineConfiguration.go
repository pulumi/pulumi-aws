// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package chimesdkmediapipelines

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS Chime SDK Media Pipelines Media Insights Pipeline Configuration.
// Consult the [Call analytics developer guide](https://docs.aws.amazon.com/chime-sdk/latest/dg/call-analytics.html) for more detailed information about usage.
//
// ## Example Usage
//
// ### Basic Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/chimesdkmediapipelines"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/iam"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/kinesis"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			example, err := kinesis.NewStream(ctx, "example", &kinesis.StreamArgs{
//				Name:       pulumi.String("example"),
//				ShardCount: pulumi.Int(2),
//			})
//			if err != nil {
//				return err
//			}
//			mediaPipelinesAssumeRole, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
//				Statements: []iam.GetPolicyDocumentStatement{
//					{
//						Effect: pulumi.StringRef("Allow"),
//						Principals: []iam.GetPolicyDocumentStatementPrincipal{
//							{
//								Type: "Service",
//								Identifiers: []string{
//									"mediapipelines.chime.amazonaws.com",
//								},
//							},
//						},
//						Actions: []string{
//							"sts:AssumeRole",
//						},
//					},
//				},
//			}, nil)
//			if err != nil {
//				return err
//			}
//			callAnalyticsRole, err := iam.NewRole(ctx, "call_analytics_role", &iam.RoleArgs{
//				Name:             pulumi.String("CallAnalyticsRole"),
//				AssumeRolePolicy: pulumi.String(mediaPipelinesAssumeRole.Json),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = chimesdkmediapipelines.NewMediaInsightsPipelineConfiguration(ctx, "my_configuration", &chimesdkmediapipelines.MediaInsightsPipelineConfigurationArgs{
//				Name:                  pulumi.String("MyBasicConfiguration"),
//				ResourceAccessRoleArn: callAnalyticsRole.Arn,
//				Elements: chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementArray{
//					&chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementArgs{
//						Type: pulumi.String("AmazonTranscribeCallAnalyticsProcessor"),
//						AmazonTranscribeCallAnalyticsProcessorConfiguration: &chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementAmazonTranscribeCallAnalyticsProcessorConfigurationArgs{
//							LanguageCode: pulumi.String("en-US"),
//						},
//					},
//					&chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementArgs{
//						Type: pulumi.String("KinesisDataStreamSink"),
//						KinesisDataStreamSinkConfiguration: &chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementKinesisDataStreamSinkConfigurationArgs{
//							InsightsTarget: example.Arn,
//						},
//					},
//				},
//				Tags: pulumi.StringMap{
//					"Key1": pulumi.String("Value1"),
//					"Key2": pulumi.String("Value2"),
//				},
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// - The required policies on `callAnalyticsRole` will vary based on the selected processors. See [Call analytics resource access role](https://docs.aws.amazon.com/chime-sdk/latest/dg/ca-resource-access-role.html) for directions on choosing appropriate policies.
//
// ### Transcribe Call Analytics processor usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/chimesdkmediapipelines"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/iam"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			transcribeAssumeRole, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
//				Statements: []iam.GetPolicyDocumentStatement{
//					{
//						Effect: pulumi.StringRef("Allow"),
//						Principals: []iam.GetPolicyDocumentStatementPrincipal{
//							{
//								Type: "Service",
//								Identifiers: []string{
//									"transcribe.amazonaws.com",
//								},
//							},
//						},
//						Actions: []string{
//							"sts:AssumeRole",
//						},
//					},
//				},
//			}, nil)
//			if err != nil {
//				return err
//			}
//			postCallRole, err := iam.NewRole(ctx, "post_call_role", &iam.RoleArgs{
//				Name:             pulumi.String("PostCallAccessRole"),
//				AssumeRolePolicy: pulumi.String(transcribeAssumeRole.Json),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = chimesdkmediapipelines.NewMediaInsightsPipelineConfiguration(ctx, "my_configuration", &chimesdkmediapipelines.MediaInsightsPipelineConfigurationArgs{
//				Name:                  pulumi.String("MyCallAnalyticsConfiguration"),
//				ResourceAccessRoleArn: pulumi.Any(exampleAwsIamRole.Arn),
//				Elements: chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementArray{
//					&chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementArgs{
//						Type: pulumi.String("AmazonTranscribeCallAnalyticsProcessor"),
//						AmazonTranscribeCallAnalyticsProcessorConfiguration: &chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementAmazonTranscribeCallAnalyticsProcessorConfigurationArgs{
//							CallAnalyticsStreamCategories: pulumi.StringArray{
//								pulumi.String("category_1"),
//								pulumi.String("category_2"),
//							},
//							ContentRedactionType:              pulumi.String("PII"),
//							EnablePartialResultsStabilization: pulumi.Bool(true),
//							FilterPartialResults:              pulumi.Bool(true),
//							LanguageCode:                      pulumi.String("en-US"),
//							LanguageModelName:                 pulumi.String("MyLanguageModel"),
//							PartialResultsStability:           pulumi.String("high"),
//							PiiEntityTypes:                    pulumi.String("ADDRESS,BANK_ACCOUNT_NUMBER"),
//							PostCallAnalyticsSettings: &chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementAmazonTranscribeCallAnalyticsProcessorConfigurationPostCallAnalyticsSettingsArgs{
//								ContentRedactionOutput:   pulumi.String("redacted"),
//								DataAccessRoleArn:        postCallRole.Arn,
//								OutputEncryptionKmsKeyId: pulumi.String("MyKmsKeyId"),
//								OutputLocation:           pulumi.String("s3://MyBucket"),
//							},
//							VocabularyFilterMethod: pulumi.String("mask"),
//							VocabularyFilterName:   pulumi.String("MyVocabularyFilter"),
//							VocabularyName:         pulumi.String("MyVocabulary"),
//						},
//					},
//					&chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementArgs{
//						Type: pulumi.String("KinesisDataStreamSink"),
//						KinesisDataStreamSinkConfiguration: &chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementKinesisDataStreamSinkConfigurationArgs{
//							InsightsTarget: pulumi.Any(example.Arn),
//						},
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// ### Real time alerts usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/chimesdkmediapipelines"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := chimesdkmediapipelines.NewMediaInsightsPipelineConfiguration(ctx, "my_configuration", &chimesdkmediapipelines.MediaInsightsPipelineConfigurationArgs{
//				Name:                  pulumi.String("MyRealTimeAlertConfiguration"),
//				ResourceAccessRoleArn: pulumi.Any(callAnalyticsRole.Arn),
//				Elements: chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementArray{
//					&chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementArgs{
//						Type: pulumi.String("AmazonTranscribeCallAnalyticsProcessor"),
//						AmazonTranscribeCallAnalyticsProcessorConfiguration: &chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementAmazonTranscribeCallAnalyticsProcessorConfigurationArgs{
//							LanguageCode: pulumi.String("en-US"),
//						},
//					},
//					&chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementArgs{
//						Type: pulumi.String("KinesisDataStreamSink"),
//						KinesisDataStreamSinkConfiguration: &chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementKinesisDataStreamSinkConfigurationArgs{
//							InsightsTarget: pulumi.Any(example.Arn),
//						},
//					},
//				},
//				RealTimeAlertConfiguration: &chimesdkmediapipelines.MediaInsightsPipelineConfigurationRealTimeAlertConfigurationArgs{
//					Disabled: pulumi.Bool(false),
//					Rules: chimesdkmediapipelines.MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleArray{
//						&chimesdkmediapipelines.MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleArgs{
//							Type: pulumi.String("IssueDetection"),
//							IssueDetectionConfiguration: &chimesdkmediapipelines.MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleIssueDetectionConfigurationArgs{
//								RuleName: pulumi.String("MyIssueDetectionRule"),
//							},
//						},
//						&chimesdkmediapipelines.MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleArgs{
//							Type: pulumi.String("KeywordMatch"),
//							KeywordMatchConfiguration: &chimesdkmediapipelines.MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleKeywordMatchConfigurationArgs{
//								Keywords: pulumi.StringArray{
//									pulumi.String("keyword1"),
//									pulumi.String("keyword2"),
//								},
//								Negate:   pulumi.Bool(false),
//								RuleName: pulumi.String("MyKeywordMatchRule"),
//							},
//						},
//						&chimesdkmediapipelines.MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleArgs{
//							Type: pulumi.String("Sentiment"),
//							SentimentConfiguration: &chimesdkmediapipelines.MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleSentimentConfigurationArgs{
//								RuleName:      pulumi.String("MySentimentRule"),
//								SentimentType: pulumi.String("NEGATIVE"),
//								TimePeriod:    pulumi.Int(60),
//							},
//						},
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// ### Transcribe processor usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/chimesdkmediapipelines"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := chimesdkmediapipelines.NewMediaInsightsPipelineConfiguration(ctx, "my_configuration", &chimesdkmediapipelines.MediaInsightsPipelineConfigurationArgs{
//				Name:                  pulumi.String("MyTranscribeConfiguration"),
//				ResourceAccessRoleArn: pulumi.Any(exampleAwsIamRole.Arn),
//				Elements: chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementArray{
//					&chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementArgs{
//						Type: pulumi.String("AmazonTranscribeProcessor"),
//						AmazonTranscribeProcessorConfiguration: &chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementAmazonTranscribeProcessorConfigurationArgs{
//							ContentIdentificationType:         pulumi.String("PII"),
//							EnablePartialResultsStabilization: pulumi.Bool(true),
//							FilterPartialResults:              pulumi.Bool(true),
//							LanguageCode:                      pulumi.String("en-US"),
//							LanguageModelName:                 pulumi.String("MyLanguageModel"),
//							PartialResultsStability:           pulumi.String("high"),
//							PiiEntityTypes:                    pulumi.String("ADDRESS,BANK_ACCOUNT_NUMBER"),
//							ShowSpeakerLabel:                  pulumi.Bool(true),
//							VocabularyFilterMethod:            pulumi.String("mask"),
//							VocabularyFilterName:              pulumi.String("MyVocabularyFilter"),
//							VocabularyName:                    pulumi.String("MyVocabulary"),
//						},
//					},
//					&chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementArgs{
//						Type: pulumi.String("KinesisDataStreamSink"),
//						KinesisDataStreamSinkConfiguration: &chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementKinesisDataStreamSinkConfigurationArgs{
//							InsightsTarget: pulumi.Any(example.Arn),
//						},
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// ### Voice analytics processor usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/chimesdkmediapipelines"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := chimesdkmediapipelines.NewMediaInsightsPipelineConfiguration(ctx, "my_configuration", &chimesdkmediapipelines.MediaInsightsPipelineConfigurationArgs{
//				Name:                  pulumi.String("MyVoiceAnalyticsConfiguration"),
//				ResourceAccessRoleArn: pulumi.Any(example.Arn),
//				Elements: chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementArray{
//					&chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementArgs{
//						Type: pulumi.String("VoiceAnalyticsProcessor"),
//						VoiceAnalyticsProcessorConfiguration: &chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementVoiceAnalyticsProcessorConfigurationArgs{
//							SpeakerSearchStatus:     pulumi.String("Enabled"),
//							VoiceToneAnalysisStatus: pulumi.String("Enabled"),
//						},
//					},
//					&chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementArgs{
//						Type: pulumi.String("LambdaFunctionSink"),
//						LambdaFunctionSinkConfiguration: &chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementLambdaFunctionSinkConfigurationArgs{
//							InsightsTarget: pulumi.String("arn:aws:lambda:us-west-2:1111111111:function:MyFunction"),
//						},
//					},
//					&chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementArgs{
//						Type: pulumi.String("SnsTopicSink"),
//						SnsTopicSinkConfiguration: &chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementSnsTopicSinkConfigurationArgs{
//							InsightsTarget: pulumi.String("arn:aws:sns:us-west-2:1111111111:topic/MyTopic"),
//						},
//					},
//					&chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementArgs{
//						Type: pulumi.String("SqsQueueSink"),
//						SqsQueueSinkConfiguration: &chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementSqsQueueSinkConfigurationArgs{
//							InsightsTarget: pulumi.String("arn:aws:sqs:us-west-2:1111111111:queue/MyQueue"),
//						},
//					},
//					&chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementArgs{
//						Type: pulumi.String("KinesisDataStreamSink"),
//						KinesisDataStreamSinkConfiguration: &chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementKinesisDataStreamSinkConfigurationArgs{
//							InsightsTarget: pulumi.Any(test.Arn),
//						},
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// ### S3 Recording sink usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/chimesdkmediapipelines"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := chimesdkmediapipelines.NewMediaInsightsPipelineConfiguration(ctx, "my_configuration", &chimesdkmediapipelines.MediaInsightsPipelineConfigurationArgs{
//				Name:                  pulumi.String("MyS3RecordingConfiguration"),
//				ResourceAccessRoleArn: pulumi.Any(example.Arn),
//				Elements: chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementArray{
//					&chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementArgs{
//						Type: pulumi.String("S3RecordingSink"),
//						S3RecordingSinkConfiguration: &chimesdkmediapipelines.MediaInsightsPipelineConfigurationElementS3RecordingSinkConfigurationArgs{
//							Destination: pulumi.String("arn:aws:s3:::MyBucket"),
//						},
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// ## Import
//
// Using `pulumi import`, import Chime SDK Media Pipelines Media Insights Pipeline Configuration using the `id`. For example:
//
// ```sh
// $ pulumi import aws:chimesdkmediapipelines/mediaInsightsPipelineConfiguration:MediaInsightsPipelineConfiguration example abcdef123456
// ```
type MediaInsightsPipelineConfiguration struct {
	pulumi.CustomResourceState

	// ARN of the Media Insights Pipeline Configuration.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Collection of processors and sinks to transform media and deliver data.
	Elements MediaInsightsPipelineConfigurationElementArrayOutput `pulumi:"elements"`
	// Configuration name.
	Name pulumi.StringOutput `pulumi:"name"`
	// Configuration for real-time alert rules to send EventBridge notifications when certain conditions are met.
	RealTimeAlertConfiguration MediaInsightsPipelineConfigurationRealTimeAlertConfigurationPtrOutput `pulumi:"realTimeAlertConfiguration"`
	// ARN of IAM Role used by service to invoke processors and sinks specified by configuration elements.
	ResourceAccessRoleArn pulumi.StringOutput `pulumi:"resourceAccessRoleArn"`
	// Key-value map of tags for the resource.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewMediaInsightsPipelineConfiguration registers a new resource with the given unique name, arguments, and options.
func NewMediaInsightsPipelineConfiguration(ctx *pulumi.Context,
	name string, args *MediaInsightsPipelineConfigurationArgs, opts ...pulumi.ResourceOption) (*MediaInsightsPipelineConfiguration, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.Elements == nil {
		return nil, errors.New("invalid value for required argument 'Elements'")
	}
	if args.ResourceAccessRoleArn == nil {
		return nil, errors.New("invalid value for required argument 'ResourceAccessRoleArn'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource MediaInsightsPipelineConfiguration
	err := ctx.RegisterResource("aws:chimesdkmediapipelines/mediaInsightsPipelineConfiguration:MediaInsightsPipelineConfiguration", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetMediaInsightsPipelineConfiguration gets an existing MediaInsightsPipelineConfiguration resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetMediaInsightsPipelineConfiguration(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *MediaInsightsPipelineConfigurationState, opts ...pulumi.ResourceOption) (*MediaInsightsPipelineConfiguration, error) {
	var resource MediaInsightsPipelineConfiguration
	err := ctx.ReadResource("aws:chimesdkmediapipelines/mediaInsightsPipelineConfiguration:MediaInsightsPipelineConfiguration", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering MediaInsightsPipelineConfiguration resources.
type mediaInsightsPipelineConfigurationState struct {
	// ARN of the Media Insights Pipeline Configuration.
	Arn *string `pulumi:"arn"`
	// Collection of processors and sinks to transform media and deliver data.
	Elements []MediaInsightsPipelineConfigurationElement `pulumi:"elements"`
	// Configuration name.
	Name *string `pulumi:"name"`
	// Configuration for real-time alert rules to send EventBridge notifications when certain conditions are met.
	RealTimeAlertConfiguration *MediaInsightsPipelineConfigurationRealTimeAlertConfiguration `pulumi:"realTimeAlertConfiguration"`
	// ARN of IAM Role used by service to invoke processors and sinks specified by configuration elements.
	ResourceAccessRoleArn *string `pulumi:"resourceAccessRoleArn"`
	// Key-value map of tags for the resource.
	Tags map[string]string `pulumi:"tags"`
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type MediaInsightsPipelineConfigurationState struct {
	// ARN of the Media Insights Pipeline Configuration.
	Arn pulumi.StringPtrInput
	// Collection of processors and sinks to transform media and deliver data.
	Elements MediaInsightsPipelineConfigurationElementArrayInput
	// Configuration name.
	Name pulumi.StringPtrInput
	// Configuration for real-time alert rules to send EventBridge notifications when certain conditions are met.
	RealTimeAlertConfiguration MediaInsightsPipelineConfigurationRealTimeAlertConfigurationPtrInput
	// ARN of IAM Role used by service to invoke processors and sinks specified by configuration elements.
	ResourceAccessRoleArn pulumi.StringPtrInput
	// Key-value map of tags for the resource.
	Tags pulumi.StringMapInput
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (MediaInsightsPipelineConfigurationState) ElementType() reflect.Type {
	return reflect.TypeOf((*mediaInsightsPipelineConfigurationState)(nil)).Elem()
}

type mediaInsightsPipelineConfigurationArgs struct {
	// Collection of processors and sinks to transform media and deliver data.
	Elements []MediaInsightsPipelineConfigurationElement `pulumi:"elements"`
	// Configuration name.
	Name *string `pulumi:"name"`
	// Configuration for real-time alert rules to send EventBridge notifications when certain conditions are met.
	RealTimeAlertConfiguration *MediaInsightsPipelineConfigurationRealTimeAlertConfiguration `pulumi:"realTimeAlertConfiguration"`
	// ARN of IAM Role used by service to invoke processors and sinks specified by configuration elements.
	ResourceAccessRoleArn string `pulumi:"resourceAccessRoleArn"`
	// Key-value map of tags for the resource.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a MediaInsightsPipelineConfiguration resource.
type MediaInsightsPipelineConfigurationArgs struct {
	// Collection of processors and sinks to transform media and deliver data.
	Elements MediaInsightsPipelineConfigurationElementArrayInput
	// Configuration name.
	Name pulumi.StringPtrInput
	// Configuration for real-time alert rules to send EventBridge notifications when certain conditions are met.
	RealTimeAlertConfiguration MediaInsightsPipelineConfigurationRealTimeAlertConfigurationPtrInput
	// ARN of IAM Role used by service to invoke processors and sinks specified by configuration elements.
	ResourceAccessRoleArn pulumi.StringInput
	// Key-value map of tags for the resource.
	Tags pulumi.StringMapInput
}

func (MediaInsightsPipelineConfigurationArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*mediaInsightsPipelineConfigurationArgs)(nil)).Elem()
}

type MediaInsightsPipelineConfigurationInput interface {
	pulumi.Input

	ToMediaInsightsPipelineConfigurationOutput() MediaInsightsPipelineConfigurationOutput
	ToMediaInsightsPipelineConfigurationOutputWithContext(ctx context.Context) MediaInsightsPipelineConfigurationOutput
}

func (*MediaInsightsPipelineConfiguration) ElementType() reflect.Type {
	return reflect.TypeOf((**MediaInsightsPipelineConfiguration)(nil)).Elem()
}

func (i *MediaInsightsPipelineConfiguration) ToMediaInsightsPipelineConfigurationOutput() MediaInsightsPipelineConfigurationOutput {
	return i.ToMediaInsightsPipelineConfigurationOutputWithContext(context.Background())
}

func (i *MediaInsightsPipelineConfiguration) ToMediaInsightsPipelineConfigurationOutputWithContext(ctx context.Context) MediaInsightsPipelineConfigurationOutput {
	return pulumi.ToOutputWithContext(ctx, i).(MediaInsightsPipelineConfigurationOutput)
}

// MediaInsightsPipelineConfigurationArrayInput is an input type that accepts MediaInsightsPipelineConfigurationArray and MediaInsightsPipelineConfigurationArrayOutput values.
// You can construct a concrete instance of `MediaInsightsPipelineConfigurationArrayInput` via:
//
//	MediaInsightsPipelineConfigurationArray{ MediaInsightsPipelineConfigurationArgs{...} }
type MediaInsightsPipelineConfigurationArrayInput interface {
	pulumi.Input

	ToMediaInsightsPipelineConfigurationArrayOutput() MediaInsightsPipelineConfigurationArrayOutput
	ToMediaInsightsPipelineConfigurationArrayOutputWithContext(context.Context) MediaInsightsPipelineConfigurationArrayOutput
}

type MediaInsightsPipelineConfigurationArray []MediaInsightsPipelineConfigurationInput

func (MediaInsightsPipelineConfigurationArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*MediaInsightsPipelineConfiguration)(nil)).Elem()
}

func (i MediaInsightsPipelineConfigurationArray) ToMediaInsightsPipelineConfigurationArrayOutput() MediaInsightsPipelineConfigurationArrayOutput {
	return i.ToMediaInsightsPipelineConfigurationArrayOutputWithContext(context.Background())
}

func (i MediaInsightsPipelineConfigurationArray) ToMediaInsightsPipelineConfigurationArrayOutputWithContext(ctx context.Context) MediaInsightsPipelineConfigurationArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(MediaInsightsPipelineConfigurationArrayOutput)
}

// MediaInsightsPipelineConfigurationMapInput is an input type that accepts MediaInsightsPipelineConfigurationMap and MediaInsightsPipelineConfigurationMapOutput values.
// You can construct a concrete instance of `MediaInsightsPipelineConfigurationMapInput` via:
//
//	MediaInsightsPipelineConfigurationMap{ "key": MediaInsightsPipelineConfigurationArgs{...} }
type MediaInsightsPipelineConfigurationMapInput interface {
	pulumi.Input

	ToMediaInsightsPipelineConfigurationMapOutput() MediaInsightsPipelineConfigurationMapOutput
	ToMediaInsightsPipelineConfigurationMapOutputWithContext(context.Context) MediaInsightsPipelineConfigurationMapOutput
}

type MediaInsightsPipelineConfigurationMap map[string]MediaInsightsPipelineConfigurationInput

func (MediaInsightsPipelineConfigurationMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*MediaInsightsPipelineConfiguration)(nil)).Elem()
}

func (i MediaInsightsPipelineConfigurationMap) ToMediaInsightsPipelineConfigurationMapOutput() MediaInsightsPipelineConfigurationMapOutput {
	return i.ToMediaInsightsPipelineConfigurationMapOutputWithContext(context.Background())
}

func (i MediaInsightsPipelineConfigurationMap) ToMediaInsightsPipelineConfigurationMapOutputWithContext(ctx context.Context) MediaInsightsPipelineConfigurationMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(MediaInsightsPipelineConfigurationMapOutput)
}

type MediaInsightsPipelineConfigurationOutput struct{ *pulumi.OutputState }

func (MediaInsightsPipelineConfigurationOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**MediaInsightsPipelineConfiguration)(nil)).Elem()
}

func (o MediaInsightsPipelineConfigurationOutput) ToMediaInsightsPipelineConfigurationOutput() MediaInsightsPipelineConfigurationOutput {
	return o
}

func (o MediaInsightsPipelineConfigurationOutput) ToMediaInsightsPipelineConfigurationOutputWithContext(ctx context.Context) MediaInsightsPipelineConfigurationOutput {
	return o
}

// ARN of the Media Insights Pipeline Configuration.
func (o MediaInsightsPipelineConfigurationOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *MediaInsightsPipelineConfiguration) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Collection of processors and sinks to transform media and deliver data.
func (o MediaInsightsPipelineConfigurationOutput) Elements() MediaInsightsPipelineConfigurationElementArrayOutput {
	return o.ApplyT(func(v *MediaInsightsPipelineConfiguration) MediaInsightsPipelineConfigurationElementArrayOutput {
		return v.Elements
	}).(MediaInsightsPipelineConfigurationElementArrayOutput)
}

// Configuration name.
func (o MediaInsightsPipelineConfigurationOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *MediaInsightsPipelineConfiguration) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// Configuration for real-time alert rules to send EventBridge notifications when certain conditions are met.
func (o MediaInsightsPipelineConfigurationOutput) RealTimeAlertConfiguration() MediaInsightsPipelineConfigurationRealTimeAlertConfigurationPtrOutput {
	return o.ApplyT(func(v *MediaInsightsPipelineConfiguration) MediaInsightsPipelineConfigurationRealTimeAlertConfigurationPtrOutput {
		return v.RealTimeAlertConfiguration
	}).(MediaInsightsPipelineConfigurationRealTimeAlertConfigurationPtrOutput)
}

// ARN of IAM Role used by service to invoke processors and sinks specified by configuration elements.
func (o MediaInsightsPipelineConfigurationOutput) ResourceAccessRoleArn() pulumi.StringOutput {
	return o.ApplyT(func(v *MediaInsightsPipelineConfiguration) pulumi.StringOutput { return v.ResourceAccessRoleArn }).(pulumi.StringOutput)
}

// Key-value map of tags for the resource.
func (o MediaInsightsPipelineConfigurationOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *MediaInsightsPipelineConfiguration) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Deprecated: Please use `tags` instead.
func (o MediaInsightsPipelineConfigurationOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *MediaInsightsPipelineConfiguration) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type MediaInsightsPipelineConfigurationArrayOutput struct{ *pulumi.OutputState }

func (MediaInsightsPipelineConfigurationArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*MediaInsightsPipelineConfiguration)(nil)).Elem()
}

func (o MediaInsightsPipelineConfigurationArrayOutput) ToMediaInsightsPipelineConfigurationArrayOutput() MediaInsightsPipelineConfigurationArrayOutput {
	return o
}

func (o MediaInsightsPipelineConfigurationArrayOutput) ToMediaInsightsPipelineConfigurationArrayOutputWithContext(ctx context.Context) MediaInsightsPipelineConfigurationArrayOutput {
	return o
}

func (o MediaInsightsPipelineConfigurationArrayOutput) Index(i pulumi.IntInput) MediaInsightsPipelineConfigurationOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *MediaInsightsPipelineConfiguration {
		return vs[0].([]*MediaInsightsPipelineConfiguration)[vs[1].(int)]
	}).(MediaInsightsPipelineConfigurationOutput)
}

type MediaInsightsPipelineConfigurationMapOutput struct{ *pulumi.OutputState }

func (MediaInsightsPipelineConfigurationMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*MediaInsightsPipelineConfiguration)(nil)).Elem()
}

func (o MediaInsightsPipelineConfigurationMapOutput) ToMediaInsightsPipelineConfigurationMapOutput() MediaInsightsPipelineConfigurationMapOutput {
	return o
}

func (o MediaInsightsPipelineConfigurationMapOutput) ToMediaInsightsPipelineConfigurationMapOutputWithContext(ctx context.Context) MediaInsightsPipelineConfigurationMapOutput {
	return o
}

func (o MediaInsightsPipelineConfigurationMapOutput) MapIndex(k pulumi.StringInput) MediaInsightsPipelineConfigurationOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *MediaInsightsPipelineConfiguration {
		return vs[0].(map[string]*MediaInsightsPipelineConfiguration)[vs[1].(string)]
	}).(MediaInsightsPipelineConfigurationOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*MediaInsightsPipelineConfigurationInput)(nil)).Elem(), &MediaInsightsPipelineConfiguration{})
	pulumi.RegisterInputType(reflect.TypeOf((*MediaInsightsPipelineConfigurationArrayInput)(nil)).Elem(), MediaInsightsPipelineConfigurationArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*MediaInsightsPipelineConfigurationMapInput)(nil)).Elem(), MediaInsightsPipelineConfigurationMap{})
	pulumi.RegisterOutputType(MediaInsightsPipelineConfigurationOutput{})
	pulumi.RegisterOutputType(MediaInsightsPipelineConfigurationArrayOutput{})
	pulumi.RegisterOutputType(MediaInsightsPipelineConfigurationMapOutput{})
}
