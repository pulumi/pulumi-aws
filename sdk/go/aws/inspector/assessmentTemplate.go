// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package inspector

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides an Inspector Classic Assessment Template
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/inspector"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := inspector.NewAssessmentTemplate(ctx, "example", &inspector.AssessmentTemplateArgs{
//				Name:      pulumi.String("example"),
//				TargetArn: pulumi.Any(exampleAwsInspectorAssessmentTarget.Arn),
//				Duration:  pulumi.Int(3600),
//				RulesPackageArns: pulumi.StringArray{
//					pulumi.String("arn:aws:inspector:us-west-2:758058086616:rulespackage/0-9hgA516p"),
//					pulumi.String("arn:aws:inspector:us-west-2:758058086616:rulespackage/0-H5hpSawc"),
//					pulumi.String("arn:aws:inspector:us-west-2:758058086616:rulespackage/0-JJOtZiqQ"),
//					pulumi.String("arn:aws:inspector:us-west-2:758058086616:rulespackage/0-vg5GGHSD"),
//				},
//				EventSubscriptions: inspector.AssessmentTemplateEventSubscriptionArray{
//					&inspector.AssessmentTemplateEventSubscriptionArgs{
//						Event:    pulumi.String("ASSESSMENT_RUN_COMPLETED"),
//						TopicArn: pulumi.Any(exampleAwsSnsTopic.Arn),
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
// Using `pulumi import`, import `aws_inspector_assessment_template` using the template assessment ARN. For example:
//
// ```sh
// $ pulumi import aws:inspector/assessmentTemplate:AssessmentTemplate example arn:aws:inspector:us-west-2:123456789012:target/0-9IaAzhGR/template/0-WEcjR8CH
// ```
type AssessmentTemplate struct {
	pulumi.CustomResourceState

	// The template assessment ARN.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// The duration of the inspector run.
	Duration pulumi.IntOutput `pulumi:"duration"`
	// A block that enables sending notifications about a specified assessment template event to a designated SNS topic. See Event Subscriptions for details.
	EventSubscriptions AssessmentTemplateEventSubscriptionArrayOutput `pulumi:"eventSubscriptions"`
	// The name of the assessment template.
	Name pulumi.StringOutput `pulumi:"name"`
	// The rules to be used during the run.
	RulesPackageArns pulumi.StringArrayOutput `pulumi:"rulesPackageArns"`
	// Key-value map of tags for the Inspector assessment template. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	// The assessment target ARN to attach the template to.
	TargetArn pulumi.StringOutput `pulumi:"targetArn"`
}

// NewAssessmentTemplate registers a new resource with the given unique name, arguments, and options.
func NewAssessmentTemplate(ctx *pulumi.Context,
	name string, args *AssessmentTemplateArgs, opts ...pulumi.ResourceOption) (*AssessmentTemplate, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.Duration == nil {
		return nil, errors.New("invalid value for required argument 'Duration'")
	}
	if args.RulesPackageArns == nil {
		return nil, errors.New("invalid value for required argument 'RulesPackageArns'")
	}
	if args.TargetArn == nil {
		return nil, errors.New("invalid value for required argument 'TargetArn'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource AssessmentTemplate
	err := ctx.RegisterResource("aws:inspector/assessmentTemplate:AssessmentTemplate", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetAssessmentTemplate gets an existing AssessmentTemplate resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetAssessmentTemplate(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *AssessmentTemplateState, opts ...pulumi.ResourceOption) (*AssessmentTemplate, error) {
	var resource AssessmentTemplate
	err := ctx.ReadResource("aws:inspector/assessmentTemplate:AssessmentTemplate", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering AssessmentTemplate resources.
type assessmentTemplateState struct {
	// The template assessment ARN.
	Arn *string `pulumi:"arn"`
	// The duration of the inspector run.
	Duration *int `pulumi:"duration"`
	// A block that enables sending notifications about a specified assessment template event to a designated SNS topic. See Event Subscriptions for details.
	EventSubscriptions []AssessmentTemplateEventSubscription `pulumi:"eventSubscriptions"`
	// The name of the assessment template.
	Name *string `pulumi:"name"`
	// The rules to be used during the run.
	RulesPackageArns []string `pulumi:"rulesPackageArns"`
	// Key-value map of tags for the Inspector assessment template. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	// The assessment target ARN to attach the template to.
	TargetArn *string `pulumi:"targetArn"`
}

type AssessmentTemplateState struct {
	// The template assessment ARN.
	Arn pulumi.StringPtrInput
	// The duration of the inspector run.
	Duration pulumi.IntPtrInput
	// A block that enables sending notifications about a specified assessment template event to a designated SNS topic. See Event Subscriptions for details.
	EventSubscriptions AssessmentTemplateEventSubscriptionArrayInput
	// The name of the assessment template.
	Name pulumi.StringPtrInput
	// The rules to be used during the run.
	RulesPackageArns pulumi.StringArrayInput
	// Key-value map of tags for the Inspector assessment template. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	// The assessment target ARN to attach the template to.
	TargetArn pulumi.StringPtrInput
}

func (AssessmentTemplateState) ElementType() reflect.Type {
	return reflect.TypeOf((*assessmentTemplateState)(nil)).Elem()
}

type assessmentTemplateArgs struct {
	// The duration of the inspector run.
	Duration int `pulumi:"duration"`
	// A block that enables sending notifications about a specified assessment template event to a designated SNS topic. See Event Subscriptions for details.
	EventSubscriptions []AssessmentTemplateEventSubscription `pulumi:"eventSubscriptions"`
	// The name of the assessment template.
	Name *string `pulumi:"name"`
	// The rules to be used during the run.
	RulesPackageArns []string `pulumi:"rulesPackageArns"`
	// Key-value map of tags for the Inspector assessment template. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// The assessment target ARN to attach the template to.
	TargetArn string `pulumi:"targetArn"`
}

// The set of arguments for constructing a AssessmentTemplate resource.
type AssessmentTemplateArgs struct {
	// The duration of the inspector run.
	Duration pulumi.IntInput
	// A block that enables sending notifications about a specified assessment template event to a designated SNS topic. See Event Subscriptions for details.
	EventSubscriptions AssessmentTemplateEventSubscriptionArrayInput
	// The name of the assessment template.
	Name pulumi.StringPtrInput
	// The rules to be used during the run.
	RulesPackageArns pulumi.StringArrayInput
	// Key-value map of tags for the Inspector assessment template. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// The assessment target ARN to attach the template to.
	TargetArn pulumi.StringInput
}

func (AssessmentTemplateArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*assessmentTemplateArgs)(nil)).Elem()
}

type AssessmentTemplateInput interface {
	pulumi.Input

	ToAssessmentTemplateOutput() AssessmentTemplateOutput
	ToAssessmentTemplateOutputWithContext(ctx context.Context) AssessmentTemplateOutput
}

func (*AssessmentTemplate) ElementType() reflect.Type {
	return reflect.TypeOf((**AssessmentTemplate)(nil)).Elem()
}

func (i *AssessmentTemplate) ToAssessmentTemplateOutput() AssessmentTemplateOutput {
	return i.ToAssessmentTemplateOutputWithContext(context.Background())
}

func (i *AssessmentTemplate) ToAssessmentTemplateOutputWithContext(ctx context.Context) AssessmentTemplateOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AssessmentTemplateOutput)
}

// AssessmentTemplateArrayInput is an input type that accepts AssessmentTemplateArray and AssessmentTemplateArrayOutput values.
// You can construct a concrete instance of `AssessmentTemplateArrayInput` via:
//
//	AssessmentTemplateArray{ AssessmentTemplateArgs{...} }
type AssessmentTemplateArrayInput interface {
	pulumi.Input

	ToAssessmentTemplateArrayOutput() AssessmentTemplateArrayOutput
	ToAssessmentTemplateArrayOutputWithContext(context.Context) AssessmentTemplateArrayOutput
}

type AssessmentTemplateArray []AssessmentTemplateInput

func (AssessmentTemplateArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*AssessmentTemplate)(nil)).Elem()
}

func (i AssessmentTemplateArray) ToAssessmentTemplateArrayOutput() AssessmentTemplateArrayOutput {
	return i.ToAssessmentTemplateArrayOutputWithContext(context.Background())
}

func (i AssessmentTemplateArray) ToAssessmentTemplateArrayOutputWithContext(ctx context.Context) AssessmentTemplateArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AssessmentTemplateArrayOutput)
}

// AssessmentTemplateMapInput is an input type that accepts AssessmentTemplateMap and AssessmentTemplateMapOutput values.
// You can construct a concrete instance of `AssessmentTemplateMapInput` via:
//
//	AssessmentTemplateMap{ "key": AssessmentTemplateArgs{...} }
type AssessmentTemplateMapInput interface {
	pulumi.Input

	ToAssessmentTemplateMapOutput() AssessmentTemplateMapOutput
	ToAssessmentTemplateMapOutputWithContext(context.Context) AssessmentTemplateMapOutput
}

type AssessmentTemplateMap map[string]AssessmentTemplateInput

func (AssessmentTemplateMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*AssessmentTemplate)(nil)).Elem()
}

func (i AssessmentTemplateMap) ToAssessmentTemplateMapOutput() AssessmentTemplateMapOutput {
	return i.ToAssessmentTemplateMapOutputWithContext(context.Background())
}

func (i AssessmentTemplateMap) ToAssessmentTemplateMapOutputWithContext(ctx context.Context) AssessmentTemplateMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AssessmentTemplateMapOutput)
}

type AssessmentTemplateOutput struct{ *pulumi.OutputState }

func (AssessmentTemplateOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**AssessmentTemplate)(nil)).Elem()
}

func (o AssessmentTemplateOutput) ToAssessmentTemplateOutput() AssessmentTemplateOutput {
	return o
}

func (o AssessmentTemplateOutput) ToAssessmentTemplateOutputWithContext(ctx context.Context) AssessmentTemplateOutput {
	return o
}

// The template assessment ARN.
func (o AssessmentTemplateOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *AssessmentTemplate) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// The duration of the inspector run.
func (o AssessmentTemplateOutput) Duration() pulumi.IntOutput {
	return o.ApplyT(func(v *AssessmentTemplate) pulumi.IntOutput { return v.Duration }).(pulumi.IntOutput)
}

// A block that enables sending notifications about a specified assessment template event to a designated SNS topic. See Event Subscriptions for details.
func (o AssessmentTemplateOutput) EventSubscriptions() AssessmentTemplateEventSubscriptionArrayOutput {
	return o.ApplyT(func(v *AssessmentTemplate) AssessmentTemplateEventSubscriptionArrayOutput {
		return v.EventSubscriptions
	}).(AssessmentTemplateEventSubscriptionArrayOutput)
}

// The name of the assessment template.
func (o AssessmentTemplateOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *AssessmentTemplate) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// The rules to be used during the run.
func (o AssessmentTemplateOutput) RulesPackageArns() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *AssessmentTemplate) pulumi.StringArrayOutput { return v.RulesPackageArns }).(pulumi.StringArrayOutput)
}

// Key-value map of tags for the Inspector assessment template. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o AssessmentTemplateOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *AssessmentTemplate) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o AssessmentTemplateOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *AssessmentTemplate) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

// The assessment target ARN to attach the template to.
func (o AssessmentTemplateOutput) TargetArn() pulumi.StringOutput {
	return o.ApplyT(func(v *AssessmentTemplate) pulumi.StringOutput { return v.TargetArn }).(pulumi.StringOutput)
}

type AssessmentTemplateArrayOutput struct{ *pulumi.OutputState }

func (AssessmentTemplateArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*AssessmentTemplate)(nil)).Elem()
}

func (o AssessmentTemplateArrayOutput) ToAssessmentTemplateArrayOutput() AssessmentTemplateArrayOutput {
	return o
}

func (o AssessmentTemplateArrayOutput) ToAssessmentTemplateArrayOutputWithContext(ctx context.Context) AssessmentTemplateArrayOutput {
	return o
}

func (o AssessmentTemplateArrayOutput) Index(i pulumi.IntInput) AssessmentTemplateOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *AssessmentTemplate {
		return vs[0].([]*AssessmentTemplate)[vs[1].(int)]
	}).(AssessmentTemplateOutput)
}

type AssessmentTemplateMapOutput struct{ *pulumi.OutputState }

func (AssessmentTemplateMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*AssessmentTemplate)(nil)).Elem()
}

func (o AssessmentTemplateMapOutput) ToAssessmentTemplateMapOutput() AssessmentTemplateMapOutput {
	return o
}

func (o AssessmentTemplateMapOutput) ToAssessmentTemplateMapOutputWithContext(ctx context.Context) AssessmentTemplateMapOutput {
	return o
}

func (o AssessmentTemplateMapOutput) MapIndex(k pulumi.StringInput) AssessmentTemplateOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *AssessmentTemplate {
		return vs[0].(map[string]*AssessmentTemplate)[vs[1].(string)]
	}).(AssessmentTemplateOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*AssessmentTemplateInput)(nil)).Elem(), &AssessmentTemplate{})
	pulumi.RegisterInputType(reflect.TypeOf((*AssessmentTemplateArrayInput)(nil)).Elem(), AssessmentTemplateArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*AssessmentTemplateMapInput)(nil)).Elem(), AssessmentTemplateMap{})
	pulumi.RegisterOutputType(AssessmentTemplateOutput{})
	pulumi.RegisterOutputType(AssessmentTemplateArrayOutput{})
	pulumi.RegisterOutputType(AssessmentTemplateMapOutput{})
}
