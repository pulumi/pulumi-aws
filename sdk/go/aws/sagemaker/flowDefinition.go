// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package sagemaker

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a SageMaker AI Flow Definition resource.
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
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/sagemaker"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := sagemaker.NewFlowDefinition(ctx, "example", &sagemaker.FlowDefinitionArgs{
//				FlowDefinitionName: pulumi.String("example"),
//				RoleArn:            pulumi.Any(exampleAwsIamRole.Arn),
//				HumanLoopConfig: &sagemaker.FlowDefinitionHumanLoopConfigArgs{
//					HumanTaskUiArn:                    pulumi.Any(exampleAwsSagemakerHumanTaskUi.Arn),
//					TaskAvailabilityLifetimeInSeconds: pulumi.Int(1),
//					TaskCount:                         pulumi.Int(1),
//					TaskDescription:                   pulumi.String("example"),
//					TaskTitle:                         pulumi.String("example"),
//					WorkteamArn:                       pulumi.Any(exampleAwsSagemakerWorkteam.Arn),
//				},
//				OutputConfig: &sagemaker.FlowDefinitionOutputConfigArgs{
//					S3OutputPath: pulumi.Sprintf("s3://%v/", exampleAwsS3Bucket.Bucket),
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
// ### Public Workteam Usage
//
// ```go
// package main
//
// import (
//
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/sagemaker"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := sagemaker.NewFlowDefinition(ctx, "example", &sagemaker.FlowDefinitionArgs{
//				FlowDefinitionName: pulumi.String("example"),
//				RoleArn:            pulumi.Any(exampleAwsIamRole.Arn),
//				HumanLoopConfig: &sagemaker.FlowDefinitionHumanLoopConfigArgs{
//					HumanTaskUiArn:                    pulumi.Any(exampleAwsSagemakerHumanTaskUi.Arn),
//					TaskAvailabilityLifetimeInSeconds: pulumi.Int(1),
//					TaskCount:                         pulumi.Int(1),
//					TaskDescription:                   pulumi.String("example"),
//					TaskTitle:                         pulumi.String("example"),
//					WorkteamArn:                       pulumi.Sprintf("arn:aws:sagemaker:%v:394669845002:workteam/public-crowd/default", current.Name),
//					PublicWorkforceTaskPrice: &sagemaker.FlowDefinitionHumanLoopConfigPublicWorkforceTaskPriceArgs{
//						AmountInUsd: &sagemaker.FlowDefinitionHumanLoopConfigPublicWorkforceTaskPriceAmountInUsdArgs{
//							Cents:                 pulumi.Int(1),
//							TenthFractionsOfACent: pulumi.Int(2),
//						},
//					},
//				},
//				OutputConfig: &sagemaker.FlowDefinitionOutputConfigArgs{
//					S3OutputPath: pulumi.Sprintf("s3://%v/", exampleAwsS3Bucket.Bucket),
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
// ### Human Loop Activation Config Usage
//
// ```go
// package main
//
// import (
//
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/sagemaker"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := sagemaker.NewFlowDefinition(ctx, "example", &sagemaker.FlowDefinitionArgs{
//				FlowDefinitionName: pulumi.String("example"),
//				RoleArn:            pulumi.Any(exampleAwsIamRole.Arn),
//				HumanLoopConfig: &sagemaker.FlowDefinitionHumanLoopConfigArgs{
//					HumanTaskUiArn:                    pulumi.Any(exampleAwsSagemakerHumanTaskUi.Arn),
//					TaskAvailabilityLifetimeInSeconds: pulumi.Int(1),
//					TaskCount:                         pulumi.Int(1),
//					TaskDescription:                   pulumi.String("example"),
//					TaskTitle:                         pulumi.String("example"),
//					WorkteamArn:                       pulumi.Any(exampleAwsSagemakerWorkteam.Arn),
//				},
//				HumanLoopRequestSource: &sagemaker.FlowDefinitionHumanLoopRequestSourceArgs{
//					AwsManagedHumanLoopRequestSource: pulumi.String("AWS/Textract/AnalyzeDocument/Forms/V1"),
//				},
//				HumanLoopActivationConfig: &sagemaker.FlowDefinitionHumanLoopActivationConfigArgs{
//					HumanLoopActivationConditionsConfig: &sagemaker.FlowDefinitionHumanLoopActivationConfigHumanLoopActivationConditionsConfigArgs{
//						HumanLoopActivationConditions: pulumi.String(`        {
//				"Conditions": [
//				  {
//					"ConditionType": "Sampling",
//					"ConditionParameters": {
//					  "RandomSamplingPercentage": 5
//					}
//				  }
//				]
//			}
//
// `),
//
//					},
//				},
//				OutputConfig: &sagemaker.FlowDefinitionOutputConfigArgs{
//					S3OutputPath: pulumi.Sprintf("s3://%v/", exampleAwsS3Bucket.Bucket),
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
// Using `pulumi import`, import SageMaker AI Flow Definitions using the `flow_definition_name`. For example:
//
// ```sh
// $ pulumi import aws:sagemaker/flowDefinition:FlowDefinition example example
// ```
type FlowDefinition struct {
	pulumi.CustomResourceState

	// The Amazon Resource Name (ARN) assigned by AWS to this Flow Definition.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// The name of your flow definition.
	FlowDefinitionName pulumi.StringOutput `pulumi:"flowDefinitionName"`
	// An object containing information about the events that trigger a human workflow. See Human Loop Activation Config details below.
	HumanLoopActivationConfig FlowDefinitionHumanLoopActivationConfigPtrOutput `pulumi:"humanLoopActivationConfig"`
	// An object containing information about the tasks the human reviewers will perform. See Human Loop Config details below.
	HumanLoopConfig FlowDefinitionHumanLoopConfigOutput `pulumi:"humanLoopConfig"`
	// Container for configuring the source of human task requests. Use to specify if Amazon Rekognition or Amazon Textract is used as an integration source. See Human Loop Request Source details below.
	HumanLoopRequestSource FlowDefinitionHumanLoopRequestSourcePtrOutput `pulumi:"humanLoopRequestSource"`
	// An object containing information about where the human review results will be uploaded. See Output Config details below.
	OutputConfig FlowDefinitionOutputConfigOutput `pulumi:"outputConfig"`
	// The Amazon Resource Name (ARN) of the role needed to call other services on your behalf.
	RoleArn pulumi.StringOutput `pulumi:"roleArn"`
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewFlowDefinition registers a new resource with the given unique name, arguments, and options.
func NewFlowDefinition(ctx *pulumi.Context,
	name string, args *FlowDefinitionArgs, opts ...pulumi.ResourceOption) (*FlowDefinition, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.FlowDefinitionName == nil {
		return nil, errors.New("invalid value for required argument 'FlowDefinitionName'")
	}
	if args.HumanLoopConfig == nil {
		return nil, errors.New("invalid value for required argument 'HumanLoopConfig'")
	}
	if args.OutputConfig == nil {
		return nil, errors.New("invalid value for required argument 'OutputConfig'")
	}
	if args.RoleArn == nil {
		return nil, errors.New("invalid value for required argument 'RoleArn'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource FlowDefinition
	err := ctx.RegisterResource("aws:sagemaker/flowDefinition:FlowDefinition", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetFlowDefinition gets an existing FlowDefinition resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetFlowDefinition(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *FlowDefinitionState, opts ...pulumi.ResourceOption) (*FlowDefinition, error) {
	var resource FlowDefinition
	err := ctx.ReadResource("aws:sagemaker/flowDefinition:FlowDefinition", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering FlowDefinition resources.
type flowDefinitionState struct {
	// The Amazon Resource Name (ARN) assigned by AWS to this Flow Definition.
	Arn *string `pulumi:"arn"`
	// The name of your flow definition.
	FlowDefinitionName *string `pulumi:"flowDefinitionName"`
	// An object containing information about the events that trigger a human workflow. See Human Loop Activation Config details below.
	HumanLoopActivationConfig *FlowDefinitionHumanLoopActivationConfig `pulumi:"humanLoopActivationConfig"`
	// An object containing information about the tasks the human reviewers will perform. See Human Loop Config details below.
	HumanLoopConfig *FlowDefinitionHumanLoopConfig `pulumi:"humanLoopConfig"`
	// Container for configuring the source of human task requests. Use to specify if Amazon Rekognition or Amazon Textract is used as an integration source. See Human Loop Request Source details below.
	HumanLoopRequestSource *FlowDefinitionHumanLoopRequestSource `pulumi:"humanLoopRequestSource"`
	// An object containing information about where the human review results will be uploaded. See Output Config details below.
	OutputConfig *FlowDefinitionOutputConfig `pulumi:"outputConfig"`
	// The Amazon Resource Name (ARN) of the role needed to call other services on your behalf.
	RoleArn *string `pulumi:"roleArn"`
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type FlowDefinitionState struct {
	// The Amazon Resource Name (ARN) assigned by AWS to this Flow Definition.
	Arn pulumi.StringPtrInput
	// The name of your flow definition.
	FlowDefinitionName pulumi.StringPtrInput
	// An object containing information about the events that trigger a human workflow. See Human Loop Activation Config details below.
	HumanLoopActivationConfig FlowDefinitionHumanLoopActivationConfigPtrInput
	// An object containing information about the tasks the human reviewers will perform. See Human Loop Config details below.
	HumanLoopConfig FlowDefinitionHumanLoopConfigPtrInput
	// Container for configuring the source of human task requests. Use to specify if Amazon Rekognition or Amazon Textract is used as an integration source. See Human Loop Request Source details below.
	HumanLoopRequestSource FlowDefinitionHumanLoopRequestSourcePtrInput
	// An object containing information about where the human review results will be uploaded. See Output Config details below.
	OutputConfig FlowDefinitionOutputConfigPtrInput
	// The Amazon Resource Name (ARN) of the role needed to call other services on your behalf.
	RoleArn pulumi.StringPtrInput
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (FlowDefinitionState) ElementType() reflect.Type {
	return reflect.TypeOf((*flowDefinitionState)(nil)).Elem()
}

type flowDefinitionArgs struct {
	// The name of your flow definition.
	FlowDefinitionName string `pulumi:"flowDefinitionName"`
	// An object containing information about the events that trigger a human workflow. See Human Loop Activation Config details below.
	HumanLoopActivationConfig *FlowDefinitionHumanLoopActivationConfig `pulumi:"humanLoopActivationConfig"`
	// An object containing information about the tasks the human reviewers will perform. See Human Loop Config details below.
	HumanLoopConfig FlowDefinitionHumanLoopConfig `pulumi:"humanLoopConfig"`
	// Container for configuring the source of human task requests. Use to specify if Amazon Rekognition or Amazon Textract is used as an integration source. See Human Loop Request Source details below.
	HumanLoopRequestSource *FlowDefinitionHumanLoopRequestSource `pulumi:"humanLoopRequestSource"`
	// An object containing information about where the human review results will be uploaded. See Output Config details below.
	OutputConfig FlowDefinitionOutputConfig `pulumi:"outputConfig"`
	// The Amazon Resource Name (ARN) of the role needed to call other services on your behalf.
	RoleArn string `pulumi:"roleArn"`
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a FlowDefinition resource.
type FlowDefinitionArgs struct {
	// The name of your flow definition.
	FlowDefinitionName pulumi.StringInput
	// An object containing information about the events that trigger a human workflow. See Human Loop Activation Config details below.
	HumanLoopActivationConfig FlowDefinitionHumanLoopActivationConfigPtrInput
	// An object containing information about the tasks the human reviewers will perform. See Human Loop Config details below.
	HumanLoopConfig FlowDefinitionHumanLoopConfigInput
	// Container for configuring the source of human task requests. Use to specify if Amazon Rekognition or Amazon Textract is used as an integration source. See Human Loop Request Source details below.
	HumanLoopRequestSource FlowDefinitionHumanLoopRequestSourcePtrInput
	// An object containing information about where the human review results will be uploaded. See Output Config details below.
	OutputConfig FlowDefinitionOutputConfigInput
	// The Amazon Resource Name (ARN) of the role needed to call other services on your behalf.
	RoleArn pulumi.StringInput
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (FlowDefinitionArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*flowDefinitionArgs)(nil)).Elem()
}

type FlowDefinitionInput interface {
	pulumi.Input

	ToFlowDefinitionOutput() FlowDefinitionOutput
	ToFlowDefinitionOutputWithContext(ctx context.Context) FlowDefinitionOutput
}

func (*FlowDefinition) ElementType() reflect.Type {
	return reflect.TypeOf((**FlowDefinition)(nil)).Elem()
}

func (i *FlowDefinition) ToFlowDefinitionOutput() FlowDefinitionOutput {
	return i.ToFlowDefinitionOutputWithContext(context.Background())
}

func (i *FlowDefinition) ToFlowDefinitionOutputWithContext(ctx context.Context) FlowDefinitionOutput {
	return pulumi.ToOutputWithContext(ctx, i).(FlowDefinitionOutput)
}

// FlowDefinitionArrayInput is an input type that accepts FlowDefinitionArray and FlowDefinitionArrayOutput values.
// You can construct a concrete instance of `FlowDefinitionArrayInput` via:
//
//	FlowDefinitionArray{ FlowDefinitionArgs{...} }
type FlowDefinitionArrayInput interface {
	pulumi.Input

	ToFlowDefinitionArrayOutput() FlowDefinitionArrayOutput
	ToFlowDefinitionArrayOutputWithContext(context.Context) FlowDefinitionArrayOutput
}

type FlowDefinitionArray []FlowDefinitionInput

func (FlowDefinitionArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*FlowDefinition)(nil)).Elem()
}

func (i FlowDefinitionArray) ToFlowDefinitionArrayOutput() FlowDefinitionArrayOutput {
	return i.ToFlowDefinitionArrayOutputWithContext(context.Background())
}

func (i FlowDefinitionArray) ToFlowDefinitionArrayOutputWithContext(ctx context.Context) FlowDefinitionArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(FlowDefinitionArrayOutput)
}

// FlowDefinitionMapInput is an input type that accepts FlowDefinitionMap and FlowDefinitionMapOutput values.
// You can construct a concrete instance of `FlowDefinitionMapInput` via:
//
//	FlowDefinitionMap{ "key": FlowDefinitionArgs{...} }
type FlowDefinitionMapInput interface {
	pulumi.Input

	ToFlowDefinitionMapOutput() FlowDefinitionMapOutput
	ToFlowDefinitionMapOutputWithContext(context.Context) FlowDefinitionMapOutput
}

type FlowDefinitionMap map[string]FlowDefinitionInput

func (FlowDefinitionMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*FlowDefinition)(nil)).Elem()
}

func (i FlowDefinitionMap) ToFlowDefinitionMapOutput() FlowDefinitionMapOutput {
	return i.ToFlowDefinitionMapOutputWithContext(context.Background())
}

func (i FlowDefinitionMap) ToFlowDefinitionMapOutputWithContext(ctx context.Context) FlowDefinitionMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(FlowDefinitionMapOutput)
}

type FlowDefinitionOutput struct{ *pulumi.OutputState }

func (FlowDefinitionOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**FlowDefinition)(nil)).Elem()
}

func (o FlowDefinitionOutput) ToFlowDefinitionOutput() FlowDefinitionOutput {
	return o
}

func (o FlowDefinitionOutput) ToFlowDefinitionOutputWithContext(ctx context.Context) FlowDefinitionOutput {
	return o
}

// The Amazon Resource Name (ARN) assigned by AWS to this Flow Definition.
func (o FlowDefinitionOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *FlowDefinition) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// The name of your flow definition.
func (o FlowDefinitionOutput) FlowDefinitionName() pulumi.StringOutput {
	return o.ApplyT(func(v *FlowDefinition) pulumi.StringOutput { return v.FlowDefinitionName }).(pulumi.StringOutput)
}

// An object containing information about the events that trigger a human workflow. See Human Loop Activation Config details below.
func (o FlowDefinitionOutput) HumanLoopActivationConfig() FlowDefinitionHumanLoopActivationConfigPtrOutput {
	return o.ApplyT(func(v *FlowDefinition) FlowDefinitionHumanLoopActivationConfigPtrOutput {
		return v.HumanLoopActivationConfig
	}).(FlowDefinitionHumanLoopActivationConfigPtrOutput)
}

// An object containing information about the tasks the human reviewers will perform. See Human Loop Config details below.
func (o FlowDefinitionOutput) HumanLoopConfig() FlowDefinitionHumanLoopConfigOutput {
	return o.ApplyT(func(v *FlowDefinition) FlowDefinitionHumanLoopConfigOutput { return v.HumanLoopConfig }).(FlowDefinitionHumanLoopConfigOutput)
}

// Container for configuring the source of human task requests. Use to specify if Amazon Rekognition or Amazon Textract is used as an integration source. See Human Loop Request Source details below.
func (o FlowDefinitionOutput) HumanLoopRequestSource() FlowDefinitionHumanLoopRequestSourcePtrOutput {
	return o.ApplyT(func(v *FlowDefinition) FlowDefinitionHumanLoopRequestSourcePtrOutput { return v.HumanLoopRequestSource }).(FlowDefinitionHumanLoopRequestSourcePtrOutput)
}

// An object containing information about where the human review results will be uploaded. See Output Config details below.
func (o FlowDefinitionOutput) OutputConfig() FlowDefinitionOutputConfigOutput {
	return o.ApplyT(func(v *FlowDefinition) FlowDefinitionOutputConfigOutput { return v.OutputConfig }).(FlowDefinitionOutputConfigOutput)
}

// The Amazon Resource Name (ARN) of the role needed to call other services on your behalf.
func (o FlowDefinitionOutput) RoleArn() pulumi.StringOutput {
	return o.ApplyT(func(v *FlowDefinition) pulumi.StringOutput { return v.RoleArn }).(pulumi.StringOutput)
}

// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o FlowDefinitionOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *FlowDefinition) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o FlowDefinitionOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *FlowDefinition) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type FlowDefinitionArrayOutput struct{ *pulumi.OutputState }

func (FlowDefinitionArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*FlowDefinition)(nil)).Elem()
}

func (o FlowDefinitionArrayOutput) ToFlowDefinitionArrayOutput() FlowDefinitionArrayOutput {
	return o
}

func (o FlowDefinitionArrayOutput) ToFlowDefinitionArrayOutputWithContext(ctx context.Context) FlowDefinitionArrayOutput {
	return o
}

func (o FlowDefinitionArrayOutput) Index(i pulumi.IntInput) FlowDefinitionOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *FlowDefinition {
		return vs[0].([]*FlowDefinition)[vs[1].(int)]
	}).(FlowDefinitionOutput)
}

type FlowDefinitionMapOutput struct{ *pulumi.OutputState }

func (FlowDefinitionMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*FlowDefinition)(nil)).Elem()
}

func (o FlowDefinitionMapOutput) ToFlowDefinitionMapOutput() FlowDefinitionMapOutput {
	return o
}

func (o FlowDefinitionMapOutput) ToFlowDefinitionMapOutputWithContext(ctx context.Context) FlowDefinitionMapOutput {
	return o
}

func (o FlowDefinitionMapOutput) MapIndex(k pulumi.StringInput) FlowDefinitionOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *FlowDefinition {
		return vs[0].(map[string]*FlowDefinition)[vs[1].(string)]
	}).(FlowDefinitionOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*FlowDefinitionInput)(nil)).Elem(), &FlowDefinition{})
	pulumi.RegisterInputType(reflect.TypeOf((*FlowDefinitionArrayInput)(nil)).Elem(), FlowDefinitionArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*FlowDefinitionMapInput)(nil)).Elem(), FlowDefinitionMap{})
	pulumi.RegisterOutputType(FlowDefinitionOutput{})
	pulumi.RegisterOutputType(FlowDefinitionArrayOutput{})
	pulumi.RegisterOutputType(FlowDefinitionMapOutput{})
}
