// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package fis

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides an FIS Experiment Template, which can be used to run an experiment.
// An experiment template contains one or more actions to run on specified targets during an experiment.
// It also contains the stop conditions that prevent the experiment from going out of bounds.
// See [Amazon Fault Injection Simulator](https://docs.aws.amazon.com/fis/index.html)
// for more information.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/fis"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := fis.NewExperimentTemplate(ctx, "example", &fis.ExperimentTemplateArgs{
//				Description: pulumi.String("example"),
//				RoleArn:     pulumi.Any(exampleAwsIamRole.Arn),
//				StopConditions: fis.ExperimentTemplateStopConditionArray{
//					&fis.ExperimentTemplateStopConditionArgs{
//						Source: pulumi.String("none"),
//					},
//				},
//				Actions: fis.ExperimentTemplateActionArray{
//					&fis.ExperimentTemplateActionArgs{
//						Name:     pulumi.String("example-action"),
//						ActionId: pulumi.String("aws:ec2:terminate-instances"),
//						Target: &fis.ExperimentTemplateActionTargetArgs{
//							Key:   pulumi.String("Instances"),
//							Value: pulumi.String("example-target"),
//						},
//					},
//				},
//				Targets: fis.ExperimentTemplateTargetArray{
//					&fis.ExperimentTemplateTargetArgs{
//						Name:          pulumi.String("example-target"),
//						ResourceType:  pulumi.String("aws:ec2:instance"),
//						SelectionMode: pulumi.String("COUNT(1)"),
//						ResourceTags: fis.ExperimentTemplateTargetResourceTagArray{
//							&fis.ExperimentTemplateTargetResourceTagArgs{
//								Key:   pulumi.String("env"),
//								Value: pulumi.String("example"),
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
// ### With Report Configuration
//
// ```go
// package main
//
// import (
//
//	"encoding/json"
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/fis"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/iam"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			current, err := aws.GetPartition(ctx, &aws.GetPartitionArgs{}, nil)
//			if err != nil {
//				return err
//			}
//			tmpJSON0, err := json.Marshal(map[string]interface{}{
//				"Statement": []map[string]interface{}{
//					map[string]interface{}{
//						"Action": "sts:AssumeRole",
//						"Effect": "Allow",
//						"Principal": map[string]interface{}{
//							"Service": []string{
//								fmt.Sprintf("fis.%v", current.DnsSuffix),
//							},
//						},
//					},
//				},
//				"Version": "2012-10-17",
//			})
//			if err != nil {
//				return err
//			}
//			json0 := string(tmpJSON0)
//			example, err := iam.NewRole(ctx, "example", &iam.RoleArgs{
//				Name:             pulumi.String("example"),
//				AssumeRolePolicy: pulumi.String(json0),
//			})
//			if err != nil {
//				return err
//			}
//			reportAccess, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
//				Version: pulumi.StringRef("2012-10-17"),
//				Statements: []iam.GetPolicyDocumentStatement{
//					{
//						Sid:    pulumi.StringRef("logsDelivery"),
//						Effect: pulumi.StringRef("Allow"),
//						Actions: []string{
//							"logs:CreateLogDelivery",
//						},
//						Resources: []string{
//							"*",
//						},
//					},
//					{
//						Sid:    pulumi.StringRef("ReportsBucket"),
//						Effect: pulumi.StringRef("Allow"),
//						Actions: []string{
//							"s3:PutObject",
//							"s3:GetObject",
//						},
//						Resources: []string{
//							"*",
//						},
//					},
//					{
//						Sid:    pulumi.StringRef("GetDashboard"),
//						Effect: pulumi.StringRef("Allow"),
//						Actions: []string{
//							"cloudwatch:GetDashboard",
//						},
//						Resources: []string{
//							"*",
//						},
//					},
//					{
//						Sid:    pulumi.StringRef("GetDashboardData"),
//						Effect: pulumi.StringRef("Allow"),
//						Actions: []string{
//							"cloudwatch:getMetricWidgetImage",
//						},
//						Resources: []string{
//							"*",
//						},
//					},
//				},
//			}, nil)
//			if err != nil {
//				return err
//			}
//			reportAccessPolicy, err := iam.NewPolicy(ctx, "report_access", &iam.PolicyArgs{
//				Name:   pulumi.String("report_access"),
//				Policy: pulumi.String(reportAccess.Json),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = iam.NewRolePolicyAttachment(ctx, "report_access", &iam.RolePolicyAttachmentArgs{
//				Role:      pulumi.Any(test.Name),
//				PolicyArn: reportAccessPolicy.Arn,
//			})
//			if err != nil {
//				return err
//			}
//			_, err = fis.NewExperimentTemplate(ctx, "example", &fis.ExperimentTemplateArgs{
//				Description: pulumi.String("example"),
//				RoleArn:     example.Arn,
//				StopConditions: fis.ExperimentTemplateStopConditionArray{
//					&fis.ExperimentTemplateStopConditionArgs{
//						Source: pulumi.String("none"),
//					},
//				},
//				Actions: fis.ExperimentTemplateActionArray{
//					&fis.ExperimentTemplateActionArgs{
//						Name:     pulumi.String("example-action"),
//						ActionId: pulumi.String("aws:ec2:terminate-instances"),
//						Target: &fis.ExperimentTemplateActionTargetArgs{
//							Key:   pulumi.String("Instances"),
//							Value: pulumi.String("example-target"),
//						},
//					},
//				},
//				Targets: fis.ExperimentTemplateTargetArray{
//					&fis.ExperimentTemplateTargetArgs{
//						Name:          pulumi.String("example-target"),
//						ResourceType:  pulumi.String("aws:ec2:instance"),
//						SelectionMode: pulumi.String("COUNT(1)"),
//						ResourceTags: fis.ExperimentTemplateTargetResourceTagArray{
//							&fis.ExperimentTemplateTargetResourceTagArgs{
//								Key:   pulumi.String("env"),
//								Value: pulumi.String("example"),
//							},
//						},
//					},
//				},
//				ExperimentReportConfiguration: &fis.ExperimentTemplateExperimentReportConfigurationArgs{
//					DataSources: &fis.ExperimentTemplateExperimentReportConfigurationDataSourcesArgs{
//						CloudwatchDashboards: fis.ExperimentTemplateExperimentReportConfigurationDataSourcesCloudwatchDashboardArray{
//							&fis.ExperimentTemplateExperimentReportConfigurationDataSourcesCloudwatchDashboardArgs{
//								DashboardArn: pulumi.Any(exampleAwsCloudwatchDashboard.DashboardArn),
//							},
//						},
//					},
//					Outputs: &fis.ExperimentTemplateExperimentReportConfigurationOutputsArgs{
//						S3Configuration: &fis.ExperimentTemplateExperimentReportConfigurationOutputsS3ConfigurationArgs{
//							BucketName: pulumi.Any(exampleAwsS3Bucket.Bucket),
//							Prefix:     pulumi.String("fis-example-reports"),
//						},
//					},
//					PostExperimentDuration: pulumi.String("PT10M"),
//					PreExperimentDuration:  pulumi.String("PT10M"),
//				},
//				Tags: pulumi.StringMap{
//					"Name": pulumi.String("example"),
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
// Using `pulumi import`, import FIS Experiment Templates using the `id`. For example:
//
// ```sh
// $ pulumi import aws:fis/experimentTemplate:ExperimentTemplate template EXT123AbCdEfGhIjK
// ```
type ExperimentTemplate struct {
	pulumi.CustomResourceState

	// Action to be performed during an experiment. See below.
	Actions ExperimentTemplateActionArrayOutput `pulumi:"actions"`
	// Description for the experiment template.
	Description pulumi.StringOutput `pulumi:"description"`
	// The experiment options for the experiment template. See experimentOptions below for more details!
	ExperimentOptions ExperimentTemplateExperimentOptionsOutput `pulumi:"experimentOptions"`
	// The configuration for [experiment reporting](https://docs.aws.amazon.com/fis/latest/userguide/experiment-report-configuration.html). See below.
	ExperimentReportConfiguration ExperimentTemplateExperimentReportConfigurationPtrOutput `pulumi:"experimentReportConfiguration"`
	// The configuration for experiment logging. See below.
	LogConfiguration ExperimentTemplateLogConfigurationPtrOutput `pulumi:"logConfiguration"`
	// ARN of an IAM role that grants the AWS FIS service permission to perform service actions on your behalf.
	RoleArn pulumi.StringOutput `pulumi:"roleArn"`
	// When an ongoing experiment should be stopped. See below.
	//
	// The following arguments are optional:
	StopConditions ExperimentTemplateStopConditionArrayOutput `pulumi:"stopConditions"`
	// Key-value mapping of tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	// Target of an action. See below.
	Targets ExperimentTemplateTargetArrayOutput `pulumi:"targets"`
}

// NewExperimentTemplate registers a new resource with the given unique name, arguments, and options.
func NewExperimentTemplate(ctx *pulumi.Context,
	name string, args *ExperimentTemplateArgs, opts ...pulumi.ResourceOption) (*ExperimentTemplate, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.Actions == nil {
		return nil, errors.New("invalid value for required argument 'Actions'")
	}
	if args.Description == nil {
		return nil, errors.New("invalid value for required argument 'Description'")
	}
	if args.RoleArn == nil {
		return nil, errors.New("invalid value for required argument 'RoleArn'")
	}
	if args.StopConditions == nil {
		return nil, errors.New("invalid value for required argument 'StopConditions'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource ExperimentTemplate
	err := ctx.RegisterResource("aws:fis/experimentTemplate:ExperimentTemplate", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetExperimentTemplate gets an existing ExperimentTemplate resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetExperimentTemplate(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ExperimentTemplateState, opts ...pulumi.ResourceOption) (*ExperimentTemplate, error) {
	var resource ExperimentTemplate
	err := ctx.ReadResource("aws:fis/experimentTemplate:ExperimentTemplate", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering ExperimentTemplate resources.
type experimentTemplateState struct {
	// Action to be performed during an experiment. See below.
	Actions []ExperimentTemplateAction `pulumi:"actions"`
	// Description for the experiment template.
	Description *string `pulumi:"description"`
	// The experiment options for the experiment template. See experimentOptions below for more details!
	ExperimentOptions *ExperimentTemplateExperimentOptions `pulumi:"experimentOptions"`
	// The configuration for [experiment reporting](https://docs.aws.amazon.com/fis/latest/userguide/experiment-report-configuration.html). See below.
	ExperimentReportConfiguration *ExperimentTemplateExperimentReportConfiguration `pulumi:"experimentReportConfiguration"`
	// The configuration for experiment logging. See below.
	LogConfiguration *ExperimentTemplateLogConfiguration `pulumi:"logConfiguration"`
	// ARN of an IAM role that grants the AWS FIS service permission to perform service actions on your behalf.
	RoleArn *string `pulumi:"roleArn"`
	// When an ongoing experiment should be stopped. See below.
	//
	// The following arguments are optional:
	StopConditions []ExperimentTemplateStopCondition `pulumi:"stopConditions"`
	// Key-value mapping of tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	// Target of an action. See below.
	Targets []ExperimentTemplateTarget `pulumi:"targets"`
}

type ExperimentTemplateState struct {
	// Action to be performed during an experiment. See below.
	Actions ExperimentTemplateActionArrayInput
	// Description for the experiment template.
	Description pulumi.StringPtrInput
	// The experiment options for the experiment template. See experimentOptions below for more details!
	ExperimentOptions ExperimentTemplateExperimentOptionsPtrInput
	// The configuration for [experiment reporting](https://docs.aws.amazon.com/fis/latest/userguide/experiment-report-configuration.html). See below.
	ExperimentReportConfiguration ExperimentTemplateExperimentReportConfigurationPtrInput
	// The configuration for experiment logging. See below.
	LogConfiguration ExperimentTemplateLogConfigurationPtrInput
	// ARN of an IAM role that grants the AWS FIS service permission to perform service actions on your behalf.
	RoleArn pulumi.StringPtrInput
	// When an ongoing experiment should be stopped. See below.
	//
	// The following arguments are optional:
	StopConditions ExperimentTemplateStopConditionArrayInput
	// Key-value mapping of tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	// Target of an action. See below.
	Targets ExperimentTemplateTargetArrayInput
}

func (ExperimentTemplateState) ElementType() reflect.Type {
	return reflect.TypeOf((*experimentTemplateState)(nil)).Elem()
}

type experimentTemplateArgs struct {
	// Action to be performed during an experiment. See below.
	Actions []ExperimentTemplateAction `pulumi:"actions"`
	// Description for the experiment template.
	Description string `pulumi:"description"`
	// The experiment options for the experiment template. See experimentOptions below for more details!
	ExperimentOptions *ExperimentTemplateExperimentOptions `pulumi:"experimentOptions"`
	// The configuration for [experiment reporting](https://docs.aws.amazon.com/fis/latest/userguide/experiment-report-configuration.html). See below.
	ExperimentReportConfiguration *ExperimentTemplateExperimentReportConfiguration `pulumi:"experimentReportConfiguration"`
	// The configuration for experiment logging. See below.
	LogConfiguration *ExperimentTemplateLogConfiguration `pulumi:"logConfiguration"`
	// ARN of an IAM role that grants the AWS FIS service permission to perform service actions on your behalf.
	RoleArn string `pulumi:"roleArn"`
	// When an ongoing experiment should be stopped. See below.
	//
	// The following arguments are optional:
	StopConditions []ExperimentTemplateStopCondition `pulumi:"stopConditions"`
	// Key-value mapping of tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Target of an action. See below.
	Targets []ExperimentTemplateTarget `pulumi:"targets"`
}

// The set of arguments for constructing a ExperimentTemplate resource.
type ExperimentTemplateArgs struct {
	// Action to be performed during an experiment. See below.
	Actions ExperimentTemplateActionArrayInput
	// Description for the experiment template.
	Description pulumi.StringInput
	// The experiment options for the experiment template. See experimentOptions below for more details!
	ExperimentOptions ExperimentTemplateExperimentOptionsPtrInput
	// The configuration for [experiment reporting](https://docs.aws.amazon.com/fis/latest/userguide/experiment-report-configuration.html). See below.
	ExperimentReportConfiguration ExperimentTemplateExperimentReportConfigurationPtrInput
	// The configuration for experiment logging. See below.
	LogConfiguration ExperimentTemplateLogConfigurationPtrInput
	// ARN of an IAM role that grants the AWS FIS service permission to perform service actions on your behalf.
	RoleArn pulumi.StringInput
	// When an ongoing experiment should be stopped. See below.
	//
	// The following arguments are optional:
	StopConditions ExperimentTemplateStopConditionArrayInput
	// Key-value mapping of tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Target of an action. See below.
	Targets ExperimentTemplateTargetArrayInput
}

func (ExperimentTemplateArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*experimentTemplateArgs)(nil)).Elem()
}

type ExperimentTemplateInput interface {
	pulumi.Input

	ToExperimentTemplateOutput() ExperimentTemplateOutput
	ToExperimentTemplateOutputWithContext(ctx context.Context) ExperimentTemplateOutput
}

func (*ExperimentTemplate) ElementType() reflect.Type {
	return reflect.TypeOf((**ExperimentTemplate)(nil)).Elem()
}

func (i *ExperimentTemplate) ToExperimentTemplateOutput() ExperimentTemplateOutput {
	return i.ToExperimentTemplateOutputWithContext(context.Background())
}

func (i *ExperimentTemplate) ToExperimentTemplateOutputWithContext(ctx context.Context) ExperimentTemplateOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ExperimentTemplateOutput)
}

// ExperimentTemplateArrayInput is an input type that accepts ExperimentTemplateArray and ExperimentTemplateArrayOutput values.
// You can construct a concrete instance of `ExperimentTemplateArrayInput` via:
//
//	ExperimentTemplateArray{ ExperimentTemplateArgs{...} }
type ExperimentTemplateArrayInput interface {
	pulumi.Input

	ToExperimentTemplateArrayOutput() ExperimentTemplateArrayOutput
	ToExperimentTemplateArrayOutputWithContext(context.Context) ExperimentTemplateArrayOutput
}

type ExperimentTemplateArray []ExperimentTemplateInput

func (ExperimentTemplateArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ExperimentTemplate)(nil)).Elem()
}

func (i ExperimentTemplateArray) ToExperimentTemplateArrayOutput() ExperimentTemplateArrayOutput {
	return i.ToExperimentTemplateArrayOutputWithContext(context.Background())
}

func (i ExperimentTemplateArray) ToExperimentTemplateArrayOutputWithContext(ctx context.Context) ExperimentTemplateArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ExperimentTemplateArrayOutput)
}

// ExperimentTemplateMapInput is an input type that accepts ExperimentTemplateMap and ExperimentTemplateMapOutput values.
// You can construct a concrete instance of `ExperimentTemplateMapInput` via:
//
//	ExperimentTemplateMap{ "key": ExperimentTemplateArgs{...} }
type ExperimentTemplateMapInput interface {
	pulumi.Input

	ToExperimentTemplateMapOutput() ExperimentTemplateMapOutput
	ToExperimentTemplateMapOutputWithContext(context.Context) ExperimentTemplateMapOutput
}

type ExperimentTemplateMap map[string]ExperimentTemplateInput

func (ExperimentTemplateMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ExperimentTemplate)(nil)).Elem()
}

func (i ExperimentTemplateMap) ToExperimentTemplateMapOutput() ExperimentTemplateMapOutput {
	return i.ToExperimentTemplateMapOutputWithContext(context.Background())
}

func (i ExperimentTemplateMap) ToExperimentTemplateMapOutputWithContext(ctx context.Context) ExperimentTemplateMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ExperimentTemplateMapOutput)
}

type ExperimentTemplateOutput struct{ *pulumi.OutputState }

func (ExperimentTemplateOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**ExperimentTemplate)(nil)).Elem()
}

func (o ExperimentTemplateOutput) ToExperimentTemplateOutput() ExperimentTemplateOutput {
	return o
}

func (o ExperimentTemplateOutput) ToExperimentTemplateOutputWithContext(ctx context.Context) ExperimentTemplateOutput {
	return o
}

// Action to be performed during an experiment. See below.
func (o ExperimentTemplateOutput) Actions() ExperimentTemplateActionArrayOutput {
	return o.ApplyT(func(v *ExperimentTemplate) ExperimentTemplateActionArrayOutput { return v.Actions }).(ExperimentTemplateActionArrayOutput)
}

// Description for the experiment template.
func (o ExperimentTemplateOutput) Description() pulumi.StringOutput {
	return o.ApplyT(func(v *ExperimentTemplate) pulumi.StringOutput { return v.Description }).(pulumi.StringOutput)
}

// The experiment options for the experiment template. See experimentOptions below for more details!
func (o ExperimentTemplateOutput) ExperimentOptions() ExperimentTemplateExperimentOptionsOutput {
	return o.ApplyT(func(v *ExperimentTemplate) ExperimentTemplateExperimentOptionsOutput { return v.ExperimentOptions }).(ExperimentTemplateExperimentOptionsOutput)
}

// The configuration for [experiment reporting](https://docs.aws.amazon.com/fis/latest/userguide/experiment-report-configuration.html). See below.
func (o ExperimentTemplateOutput) ExperimentReportConfiguration() ExperimentTemplateExperimentReportConfigurationPtrOutput {
	return o.ApplyT(func(v *ExperimentTemplate) ExperimentTemplateExperimentReportConfigurationPtrOutput {
		return v.ExperimentReportConfiguration
	}).(ExperimentTemplateExperimentReportConfigurationPtrOutput)
}

// The configuration for experiment logging. See below.
func (o ExperimentTemplateOutput) LogConfiguration() ExperimentTemplateLogConfigurationPtrOutput {
	return o.ApplyT(func(v *ExperimentTemplate) ExperimentTemplateLogConfigurationPtrOutput { return v.LogConfiguration }).(ExperimentTemplateLogConfigurationPtrOutput)
}

// ARN of an IAM role that grants the AWS FIS service permission to perform service actions on your behalf.
func (o ExperimentTemplateOutput) RoleArn() pulumi.StringOutput {
	return o.ApplyT(func(v *ExperimentTemplate) pulumi.StringOutput { return v.RoleArn }).(pulumi.StringOutput)
}

// When an ongoing experiment should be stopped. See below.
//
// The following arguments are optional:
func (o ExperimentTemplateOutput) StopConditions() ExperimentTemplateStopConditionArrayOutput {
	return o.ApplyT(func(v *ExperimentTemplate) ExperimentTemplateStopConditionArrayOutput { return v.StopConditions }).(ExperimentTemplateStopConditionArrayOutput)
}

// Key-value mapping of tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o ExperimentTemplateOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *ExperimentTemplate) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Deprecated: Please use `tags` instead.
func (o ExperimentTemplateOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *ExperimentTemplate) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

// Target of an action. See below.
func (o ExperimentTemplateOutput) Targets() ExperimentTemplateTargetArrayOutput {
	return o.ApplyT(func(v *ExperimentTemplate) ExperimentTemplateTargetArrayOutput { return v.Targets }).(ExperimentTemplateTargetArrayOutput)
}

type ExperimentTemplateArrayOutput struct{ *pulumi.OutputState }

func (ExperimentTemplateArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ExperimentTemplate)(nil)).Elem()
}

func (o ExperimentTemplateArrayOutput) ToExperimentTemplateArrayOutput() ExperimentTemplateArrayOutput {
	return o
}

func (o ExperimentTemplateArrayOutput) ToExperimentTemplateArrayOutputWithContext(ctx context.Context) ExperimentTemplateArrayOutput {
	return o
}

func (o ExperimentTemplateArrayOutput) Index(i pulumi.IntInput) ExperimentTemplateOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *ExperimentTemplate {
		return vs[0].([]*ExperimentTemplate)[vs[1].(int)]
	}).(ExperimentTemplateOutput)
}

type ExperimentTemplateMapOutput struct{ *pulumi.OutputState }

func (ExperimentTemplateMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ExperimentTemplate)(nil)).Elem()
}

func (o ExperimentTemplateMapOutput) ToExperimentTemplateMapOutput() ExperimentTemplateMapOutput {
	return o
}

func (o ExperimentTemplateMapOutput) ToExperimentTemplateMapOutputWithContext(ctx context.Context) ExperimentTemplateMapOutput {
	return o
}

func (o ExperimentTemplateMapOutput) MapIndex(k pulumi.StringInput) ExperimentTemplateOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *ExperimentTemplate {
		return vs[0].(map[string]*ExperimentTemplate)[vs[1].(string)]
	}).(ExperimentTemplateOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ExperimentTemplateInput)(nil)).Elem(), &ExperimentTemplate{})
	pulumi.RegisterInputType(reflect.TypeOf((*ExperimentTemplateArrayInput)(nil)).Elem(), ExperimentTemplateArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ExperimentTemplateMapInput)(nil)).Elem(), ExperimentTemplateMap{})
	pulumi.RegisterOutputType(ExperimentTemplateOutput{})
	pulumi.RegisterOutputType(ExperimentTemplateArrayOutput{})
	pulumi.RegisterOutputType(ExperimentTemplateMapOutput{})
}
