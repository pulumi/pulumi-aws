// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package securityhub

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Disable/enable Security Hub standards control in the current region.
//
// The `securityhub.StandardsControl` behaves differently from normal resources, in that
// Pulumi does not _create_ this resource, but instead "adopts" it
// into management. When you _delete_ this resource configuration, Pulumi "abandons" resource as is and just removes it from the state.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/securityhub"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			example, err := securityhub.NewAccount(ctx, "example", nil)
//			if err != nil {
//				return err
//			}
//			cisAwsFoundationsBenchmark, err := securityhub.NewStandardsSubscription(ctx, "cis_aws_foundations_benchmark", &securityhub.StandardsSubscriptionArgs{
//				StandardsArn: pulumi.String("arn:aws:securityhub:::ruleset/cis-aws-foundations-benchmark/v/1.2.0"),
//			}, pulumi.DependsOn([]pulumi.Resource{
//				example,
//			}))
//			if err != nil {
//				return err
//			}
//			_, err = securityhub.NewStandardsControl(ctx, "ensure_iam_password_policy_prevents_password_reuse", &securityhub.StandardsControlArgs{
//				StandardsControlArn: pulumi.String("arn:aws:securityhub:us-east-1:111111111111:control/cis-aws-foundations-benchmark/v/1.2.0/1.10"),
//				ControlStatus:       pulumi.String("DISABLED"),
//				DisabledReason:      pulumi.String("We handle password policies within Okta"),
//			}, pulumi.DependsOn([]pulumi.Resource{
//				cisAwsFoundationsBenchmark,
//			}))
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
type StandardsControl struct {
	pulumi.CustomResourceState

	// The identifier of the security standard control.
	ControlId pulumi.StringOutput `pulumi:"controlId"`
	// The control status could be `ENABLED` or `DISABLED`. You have to specify `disabledReason` argument for `DISABLED` control status.
	ControlStatus pulumi.StringOutput `pulumi:"controlStatus"`
	// The date and time that the status of the security standard control was most recently updated.
	ControlStatusUpdatedAt pulumi.StringOutput `pulumi:"controlStatusUpdatedAt"`
	// The standard control longer description. Provides information about what the control is checking for.
	Description pulumi.StringOutput `pulumi:"description"`
	// A description of the reason why you are disabling a security standard control. If you specify this attribute, `controlStatus` will be set to `DISABLED` automatically.
	DisabledReason pulumi.StringOutput `pulumi:"disabledReason"`
	// The list of requirements that are related to this control.
	RelatedRequirements pulumi.StringArrayOutput `pulumi:"relatedRequirements"`
	// A link to remediation information for the control in the Security Hub user documentation.
	RemediationUrl pulumi.StringOutput `pulumi:"remediationUrl"`
	// The severity of findings generated from this security standard control.
	SeverityRating pulumi.StringOutput `pulumi:"severityRating"`
	// The standards control ARN. See the AWS documentation for how to list existing controls using [`get-enabled-standards`](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/securityhub/get-enabled-standards.html) and [`describe-standards-controls`](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/securityhub/describe-standards-controls.html).
	StandardsControlArn pulumi.StringOutput `pulumi:"standardsControlArn"`
	// The standard control title.
	Title pulumi.StringOutput `pulumi:"title"`
}

// NewStandardsControl registers a new resource with the given unique name, arguments, and options.
func NewStandardsControl(ctx *pulumi.Context,
	name string, args *StandardsControlArgs, opts ...pulumi.ResourceOption) (*StandardsControl, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.ControlStatus == nil {
		return nil, errors.New("invalid value for required argument 'ControlStatus'")
	}
	if args.StandardsControlArn == nil {
		return nil, errors.New("invalid value for required argument 'StandardsControlArn'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource StandardsControl
	err := ctx.RegisterResource("aws:securityhub/standardsControl:StandardsControl", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetStandardsControl gets an existing StandardsControl resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetStandardsControl(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *StandardsControlState, opts ...pulumi.ResourceOption) (*StandardsControl, error) {
	var resource StandardsControl
	err := ctx.ReadResource("aws:securityhub/standardsControl:StandardsControl", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering StandardsControl resources.
type standardsControlState struct {
	// The identifier of the security standard control.
	ControlId *string `pulumi:"controlId"`
	// The control status could be `ENABLED` or `DISABLED`. You have to specify `disabledReason` argument for `DISABLED` control status.
	ControlStatus *string `pulumi:"controlStatus"`
	// The date and time that the status of the security standard control was most recently updated.
	ControlStatusUpdatedAt *string `pulumi:"controlStatusUpdatedAt"`
	// The standard control longer description. Provides information about what the control is checking for.
	Description *string `pulumi:"description"`
	// A description of the reason why you are disabling a security standard control. If you specify this attribute, `controlStatus` will be set to `DISABLED` automatically.
	DisabledReason *string `pulumi:"disabledReason"`
	// The list of requirements that are related to this control.
	RelatedRequirements []string `pulumi:"relatedRequirements"`
	// A link to remediation information for the control in the Security Hub user documentation.
	RemediationUrl *string `pulumi:"remediationUrl"`
	// The severity of findings generated from this security standard control.
	SeverityRating *string `pulumi:"severityRating"`
	// The standards control ARN. See the AWS documentation for how to list existing controls using [`get-enabled-standards`](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/securityhub/get-enabled-standards.html) and [`describe-standards-controls`](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/securityhub/describe-standards-controls.html).
	StandardsControlArn *string `pulumi:"standardsControlArn"`
	// The standard control title.
	Title *string `pulumi:"title"`
}

type StandardsControlState struct {
	// The identifier of the security standard control.
	ControlId pulumi.StringPtrInput
	// The control status could be `ENABLED` or `DISABLED`. You have to specify `disabledReason` argument for `DISABLED` control status.
	ControlStatus pulumi.StringPtrInput
	// The date and time that the status of the security standard control was most recently updated.
	ControlStatusUpdatedAt pulumi.StringPtrInput
	// The standard control longer description. Provides information about what the control is checking for.
	Description pulumi.StringPtrInput
	// A description of the reason why you are disabling a security standard control. If you specify this attribute, `controlStatus` will be set to `DISABLED` automatically.
	DisabledReason pulumi.StringPtrInput
	// The list of requirements that are related to this control.
	RelatedRequirements pulumi.StringArrayInput
	// A link to remediation information for the control in the Security Hub user documentation.
	RemediationUrl pulumi.StringPtrInput
	// The severity of findings generated from this security standard control.
	SeverityRating pulumi.StringPtrInput
	// The standards control ARN. See the AWS documentation for how to list existing controls using [`get-enabled-standards`](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/securityhub/get-enabled-standards.html) and [`describe-standards-controls`](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/securityhub/describe-standards-controls.html).
	StandardsControlArn pulumi.StringPtrInput
	// The standard control title.
	Title pulumi.StringPtrInput
}

func (StandardsControlState) ElementType() reflect.Type {
	return reflect.TypeOf((*standardsControlState)(nil)).Elem()
}

type standardsControlArgs struct {
	// The control status could be `ENABLED` or `DISABLED`. You have to specify `disabledReason` argument for `DISABLED` control status.
	ControlStatus string `pulumi:"controlStatus"`
	// A description of the reason why you are disabling a security standard control. If you specify this attribute, `controlStatus` will be set to `DISABLED` automatically.
	DisabledReason *string `pulumi:"disabledReason"`
	// The standards control ARN. See the AWS documentation for how to list existing controls using [`get-enabled-standards`](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/securityhub/get-enabled-standards.html) and [`describe-standards-controls`](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/securityhub/describe-standards-controls.html).
	StandardsControlArn string `pulumi:"standardsControlArn"`
}

// The set of arguments for constructing a StandardsControl resource.
type StandardsControlArgs struct {
	// The control status could be `ENABLED` or `DISABLED`. You have to specify `disabledReason` argument for `DISABLED` control status.
	ControlStatus pulumi.StringInput
	// A description of the reason why you are disabling a security standard control. If you specify this attribute, `controlStatus` will be set to `DISABLED` automatically.
	DisabledReason pulumi.StringPtrInput
	// The standards control ARN. See the AWS documentation for how to list existing controls using [`get-enabled-standards`](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/securityhub/get-enabled-standards.html) and [`describe-standards-controls`](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/securityhub/describe-standards-controls.html).
	StandardsControlArn pulumi.StringInput
}

func (StandardsControlArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*standardsControlArgs)(nil)).Elem()
}

type StandardsControlInput interface {
	pulumi.Input

	ToStandardsControlOutput() StandardsControlOutput
	ToStandardsControlOutputWithContext(ctx context.Context) StandardsControlOutput
}

func (*StandardsControl) ElementType() reflect.Type {
	return reflect.TypeOf((**StandardsControl)(nil)).Elem()
}

func (i *StandardsControl) ToStandardsControlOutput() StandardsControlOutput {
	return i.ToStandardsControlOutputWithContext(context.Background())
}

func (i *StandardsControl) ToStandardsControlOutputWithContext(ctx context.Context) StandardsControlOutput {
	return pulumi.ToOutputWithContext(ctx, i).(StandardsControlOutput)
}

// StandardsControlArrayInput is an input type that accepts StandardsControlArray and StandardsControlArrayOutput values.
// You can construct a concrete instance of `StandardsControlArrayInput` via:
//
//	StandardsControlArray{ StandardsControlArgs{...} }
type StandardsControlArrayInput interface {
	pulumi.Input

	ToStandardsControlArrayOutput() StandardsControlArrayOutput
	ToStandardsControlArrayOutputWithContext(context.Context) StandardsControlArrayOutput
}

type StandardsControlArray []StandardsControlInput

func (StandardsControlArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*StandardsControl)(nil)).Elem()
}

func (i StandardsControlArray) ToStandardsControlArrayOutput() StandardsControlArrayOutput {
	return i.ToStandardsControlArrayOutputWithContext(context.Background())
}

func (i StandardsControlArray) ToStandardsControlArrayOutputWithContext(ctx context.Context) StandardsControlArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(StandardsControlArrayOutput)
}

// StandardsControlMapInput is an input type that accepts StandardsControlMap and StandardsControlMapOutput values.
// You can construct a concrete instance of `StandardsControlMapInput` via:
//
//	StandardsControlMap{ "key": StandardsControlArgs{...} }
type StandardsControlMapInput interface {
	pulumi.Input

	ToStandardsControlMapOutput() StandardsControlMapOutput
	ToStandardsControlMapOutputWithContext(context.Context) StandardsControlMapOutput
}

type StandardsControlMap map[string]StandardsControlInput

func (StandardsControlMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*StandardsControl)(nil)).Elem()
}

func (i StandardsControlMap) ToStandardsControlMapOutput() StandardsControlMapOutput {
	return i.ToStandardsControlMapOutputWithContext(context.Background())
}

func (i StandardsControlMap) ToStandardsControlMapOutputWithContext(ctx context.Context) StandardsControlMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(StandardsControlMapOutput)
}

type StandardsControlOutput struct{ *pulumi.OutputState }

func (StandardsControlOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**StandardsControl)(nil)).Elem()
}

func (o StandardsControlOutput) ToStandardsControlOutput() StandardsControlOutput {
	return o
}

func (o StandardsControlOutput) ToStandardsControlOutputWithContext(ctx context.Context) StandardsControlOutput {
	return o
}

// The identifier of the security standard control.
func (o StandardsControlOutput) ControlId() pulumi.StringOutput {
	return o.ApplyT(func(v *StandardsControl) pulumi.StringOutput { return v.ControlId }).(pulumi.StringOutput)
}

// The control status could be `ENABLED` or `DISABLED`. You have to specify `disabledReason` argument for `DISABLED` control status.
func (o StandardsControlOutput) ControlStatus() pulumi.StringOutput {
	return o.ApplyT(func(v *StandardsControl) pulumi.StringOutput { return v.ControlStatus }).(pulumi.StringOutput)
}

// The date and time that the status of the security standard control was most recently updated.
func (o StandardsControlOutput) ControlStatusUpdatedAt() pulumi.StringOutput {
	return o.ApplyT(func(v *StandardsControl) pulumi.StringOutput { return v.ControlStatusUpdatedAt }).(pulumi.StringOutput)
}

// The standard control longer description. Provides information about what the control is checking for.
func (o StandardsControlOutput) Description() pulumi.StringOutput {
	return o.ApplyT(func(v *StandardsControl) pulumi.StringOutput { return v.Description }).(pulumi.StringOutput)
}

// A description of the reason why you are disabling a security standard control. If you specify this attribute, `controlStatus` will be set to `DISABLED` automatically.
func (o StandardsControlOutput) DisabledReason() pulumi.StringOutput {
	return o.ApplyT(func(v *StandardsControl) pulumi.StringOutput { return v.DisabledReason }).(pulumi.StringOutput)
}

// The list of requirements that are related to this control.
func (o StandardsControlOutput) RelatedRequirements() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *StandardsControl) pulumi.StringArrayOutput { return v.RelatedRequirements }).(pulumi.StringArrayOutput)
}

// A link to remediation information for the control in the Security Hub user documentation.
func (o StandardsControlOutput) RemediationUrl() pulumi.StringOutput {
	return o.ApplyT(func(v *StandardsControl) pulumi.StringOutput { return v.RemediationUrl }).(pulumi.StringOutput)
}

// The severity of findings generated from this security standard control.
func (o StandardsControlOutput) SeverityRating() pulumi.StringOutput {
	return o.ApplyT(func(v *StandardsControl) pulumi.StringOutput { return v.SeverityRating }).(pulumi.StringOutput)
}

// The standards control ARN. See the AWS documentation for how to list existing controls using [`get-enabled-standards`](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/securityhub/get-enabled-standards.html) and [`describe-standards-controls`](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/securityhub/describe-standards-controls.html).
func (o StandardsControlOutput) StandardsControlArn() pulumi.StringOutput {
	return o.ApplyT(func(v *StandardsControl) pulumi.StringOutput { return v.StandardsControlArn }).(pulumi.StringOutput)
}

// The standard control title.
func (o StandardsControlOutput) Title() pulumi.StringOutput {
	return o.ApplyT(func(v *StandardsControl) pulumi.StringOutput { return v.Title }).(pulumi.StringOutput)
}

type StandardsControlArrayOutput struct{ *pulumi.OutputState }

func (StandardsControlArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*StandardsControl)(nil)).Elem()
}

func (o StandardsControlArrayOutput) ToStandardsControlArrayOutput() StandardsControlArrayOutput {
	return o
}

func (o StandardsControlArrayOutput) ToStandardsControlArrayOutputWithContext(ctx context.Context) StandardsControlArrayOutput {
	return o
}

func (o StandardsControlArrayOutput) Index(i pulumi.IntInput) StandardsControlOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *StandardsControl {
		return vs[0].([]*StandardsControl)[vs[1].(int)]
	}).(StandardsControlOutput)
}

type StandardsControlMapOutput struct{ *pulumi.OutputState }

func (StandardsControlMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*StandardsControl)(nil)).Elem()
}

func (o StandardsControlMapOutput) ToStandardsControlMapOutput() StandardsControlMapOutput {
	return o
}

func (o StandardsControlMapOutput) ToStandardsControlMapOutputWithContext(ctx context.Context) StandardsControlMapOutput {
	return o
}

func (o StandardsControlMapOutput) MapIndex(k pulumi.StringInput) StandardsControlOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *StandardsControl {
		return vs[0].(map[string]*StandardsControl)[vs[1].(string)]
	}).(StandardsControlOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*StandardsControlInput)(nil)).Elem(), &StandardsControl{})
	pulumi.RegisterInputType(reflect.TypeOf((*StandardsControlArrayInput)(nil)).Elem(), StandardsControlArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*StandardsControlMapInput)(nil)).Elem(), StandardsControlMap{})
	pulumi.RegisterOutputType(StandardsControlOutput{})
	pulumi.RegisterOutputType(StandardsControlArrayOutput{})
	pulumi.RegisterOutputType(StandardsControlMapOutput{})
}
