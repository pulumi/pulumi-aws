// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package autoscalingplans

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Manages an AWS Auto Scaling scaling plan.
// More information can be found in the [AWS Auto Scaling User Guide](https://docs.aws.amazon.com/autoscaling/plans/userguide/what-is-aws-auto-scaling.html).
//
// > **NOTE:** The AWS Auto Scaling service uses an AWS IAM service-linked role to manage predictive scaling of Amazon EC2 Auto Scaling groups. The service attempts to automatically create this role the first time a scaling plan with predictive scaling enabled is created.
// An `iam.ServiceLinkedRole` resource can be used to manually manage this role.
// See the [AWS documentation](https://docs.aws.amazon.com/autoscaling/plans/userguide/aws-auto-scaling-service-linked-roles.html#create-service-linked-role-manual) for more details.
//
// ## Example Usage
//
// ## Import
//
// Using `pulumi import`, import Auto Scaling scaling plans using the `name`. For example:
//
// ```sh
// $ pulumi import aws:autoscalingplans/scalingPlan:ScalingPlan example MyScale1
// ```
type ScalingPlan struct {
	pulumi.CustomResourceState

	// CloudFormation stack or set of tags. You can create one scaling plan per application source.
	ApplicationSource ScalingPlanApplicationSourceOutput `pulumi:"applicationSource"`
	// Name of the scaling plan. Names cannot contain vertical bars, colons, or forward slashes.
	Name pulumi.StringOutput `pulumi:"name"`
	// Scaling instructions. More details can be found in the [AWS Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/plans/APIReference/API_ScalingInstruction.html).
	ScalingInstructions ScalingPlanScalingInstructionArrayOutput `pulumi:"scalingInstructions"`
	// The version number of the scaling plan. This value is always 1.
	ScalingPlanVersion pulumi.IntOutput `pulumi:"scalingPlanVersion"`
}

// NewScalingPlan registers a new resource with the given unique name, arguments, and options.
func NewScalingPlan(ctx *pulumi.Context,
	name string, args *ScalingPlanArgs, opts ...pulumi.ResourceOption) (*ScalingPlan, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.ApplicationSource == nil {
		return nil, errors.New("invalid value for required argument 'ApplicationSource'")
	}
	if args.ScalingInstructions == nil {
		return nil, errors.New("invalid value for required argument 'ScalingInstructions'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource ScalingPlan
	err := ctx.RegisterResource("aws:autoscalingplans/scalingPlan:ScalingPlan", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetScalingPlan gets an existing ScalingPlan resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetScalingPlan(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ScalingPlanState, opts ...pulumi.ResourceOption) (*ScalingPlan, error) {
	var resource ScalingPlan
	err := ctx.ReadResource("aws:autoscalingplans/scalingPlan:ScalingPlan", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering ScalingPlan resources.
type scalingPlanState struct {
	// CloudFormation stack or set of tags. You can create one scaling plan per application source.
	ApplicationSource *ScalingPlanApplicationSource `pulumi:"applicationSource"`
	// Name of the scaling plan. Names cannot contain vertical bars, colons, or forward slashes.
	Name *string `pulumi:"name"`
	// Scaling instructions. More details can be found in the [AWS Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/plans/APIReference/API_ScalingInstruction.html).
	ScalingInstructions []ScalingPlanScalingInstruction `pulumi:"scalingInstructions"`
	// The version number of the scaling plan. This value is always 1.
	ScalingPlanVersion *int `pulumi:"scalingPlanVersion"`
}

type ScalingPlanState struct {
	// CloudFormation stack or set of tags. You can create one scaling plan per application source.
	ApplicationSource ScalingPlanApplicationSourcePtrInput
	// Name of the scaling plan. Names cannot contain vertical bars, colons, or forward slashes.
	Name pulumi.StringPtrInput
	// Scaling instructions. More details can be found in the [AWS Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/plans/APIReference/API_ScalingInstruction.html).
	ScalingInstructions ScalingPlanScalingInstructionArrayInput
	// The version number of the scaling plan. This value is always 1.
	ScalingPlanVersion pulumi.IntPtrInput
}

func (ScalingPlanState) ElementType() reflect.Type {
	return reflect.TypeOf((*scalingPlanState)(nil)).Elem()
}

type scalingPlanArgs struct {
	// CloudFormation stack or set of tags. You can create one scaling plan per application source.
	ApplicationSource ScalingPlanApplicationSource `pulumi:"applicationSource"`
	// Name of the scaling plan. Names cannot contain vertical bars, colons, or forward slashes.
	Name *string `pulumi:"name"`
	// Scaling instructions. More details can be found in the [AWS Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/plans/APIReference/API_ScalingInstruction.html).
	ScalingInstructions []ScalingPlanScalingInstruction `pulumi:"scalingInstructions"`
}

// The set of arguments for constructing a ScalingPlan resource.
type ScalingPlanArgs struct {
	// CloudFormation stack or set of tags. You can create one scaling plan per application source.
	ApplicationSource ScalingPlanApplicationSourceInput
	// Name of the scaling plan. Names cannot contain vertical bars, colons, or forward slashes.
	Name pulumi.StringPtrInput
	// Scaling instructions. More details can be found in the [AWS Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/plans/APIReference/API_ScalingInstruction.html).
	ScalingInstructions ScalingPlanScalingInstructionArrayInput
}

func (ScalingPlanArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*scalingPlanArgs)(nil)).Elem()
}

type ScalingPlanInput interface {
	pulumi.Input

	ToScalingPlanOutput() ScalingPlanOutput
	ToScalingPlanOutputWithContext(ctx context.Context) ScalingPlanOutput
}

func (*ScalingPlan) ElementType() reflect.Type {
	return reflect.TypeOf((**ScalingPlan)(nil)).Elem()
}

func (i *ScalingPlan) ToScalingPlanOutput() ScalingPlanOutput {
	return i.ToScalingPlanOutputWithContext(context.Background())
}

func (i *ScalingPlan) ToScalingPlanOutputWithContext(ctx context.Context) ScalingPlanOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ScalingPlanOutput)
}

// ScalingPlanArrayInput is an input type that accepts ScalingPlanArray and ScalingPlanArrayOutput values.
// You can construct a concrete instance of `ScalingPlanArrayInput` via:
//
//	ScalingPlanArray{ ScalingPlanArgs{...} }
type ScalingPlanArrayInput interface {
	pulumi.Input

	ToScalingPlanArrayOutput() ScalingPlanArrayOutput
	ToScalingPlanArrayOutputWithContext(context.Context) ScalingPlanArrayOutput
}

type ScalingPlanArray []ScalingPlanInput

func (ScalingPlanArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ScalingPlan)(nil)).Elem()
}

func (i ScalingPlanArray) ToScalingPlanArrayOutput() ScalingPlanArrayOutput {
	return i.ToScalingPlanArrayOutputWithContext(context.Background())
}

func (i ScalingPlanArray) ToScalingPlanArrayOutputWithContext(ctx context.Context) ScalingPlanArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ScalingPlanArrayOutput)
}

// ScalingPlanMapInput is an input type that accepts ScalingPlanMap and ScalingPlanMapOutput values.
// You can construct a concrete instance of `ScalingPlanMapInput` via:
//
//	ScalingPlanMap{ "key": ScalingPlanArgs{...} }
type ScalingPlanMapInput interface {
	pulumi.Input

	ToScalingPlanMapOutput() ScalingPlanMapOutput
	ToScalingPlanMapOutputWithContext(context.Context) ScalingPlanMapOutput
}

type ScalingPlanMap map[string]ScalingPlanInput

func (ScalingPlanMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ScalingPlan)(nil)).Elem()
}

func (i ScalingPlanMap) ToScalingPlanMapOutput() ScalingPlanMapOutput {
	return i.ToScalingPlanMapOutputWithContext(context.Background())
}

func (i ScalingPlanMap) ToScalingPlanMapOutputWithContext(ctx context.Context) ScalingPlanMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ScalingPlanMapOutput)
}

type ScalingPlanOutput struct{ *pulumi.OutputState }

func (ScalingPlanOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**ScalingPlan)(nil)).Elem()
}

func (o ScalingPlanOutput) ToScalingPlanOutput() ScalingPlanOutput {
	return o
}

func (o ScalingPlanOutput) ToScalingPlanOutputWithContext(ctx context.Context) ScalingPlanOutput {
	return o
}

// CloudFormation stack or set of tags. You can create one scaling plan per application source.
func (o ScalingPlanOutput) ApplicationSource() ScalingPlanApplicationSourceOutput {
	return o.ApplyT(func(v *ScalingPlan) ScalingPlanApplicationSourceOutput { return v.ApplicationSource }).(ScalingPlanApplicationSourceOutput)
}

// Name of the scaling plan. Names cannot contain vertical bars, colons, or forward slashes.
func (o ScalingPlanOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *ScalingPlan) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// Scaling instructions. More details can be found in the [AWS Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/plans/APIReference/API_ScalingInstruction.html).
func (o ScalingPlanOutput) ScalingInstructions() ScalingPlanScalingInstructionArrayOutput {
	return o.ApplyT(func(v *ScalingPlan) ScalingPlanScalingInstructionArrayOutput { return v.ScalingInstructions }).(ScalingPlanScalingInstructionArrayOutput)
}

// The version number of the scaling plan. This value is always 1.
func (o ScalingPlanOutput) ScalingPlanVersion() pulumi.IntOutput {
	return o.ApplyT(func(v *ScalingPlan) pulumi.IntOutput { return v.ScalingPlanVersion }).(pulumi.IntOutput)
}

type ScalingPlanArrayOutput struct{ *pulumi.OutputState }

func (ScalingPlanArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ScalingPlan)(nil)).Elem()
}

func (o ScalingPlanArrayOutput) ToScalingPlanArrayOutput() ScalingPlanArrayOutput {
	return o
}

func (o ScalingPlanArrayOutput) ToScalingPlanArrayOutputWithContext(ctx context.Context) ScalingPlanArrayOutput {
	return o
}

func (o ScalingPlanArrayOutput) Index(i pulumi.IntInput) ScalingPlanOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *ScalingPlan {
		return vs[0].([]*ScalingPlan)[vs[1].(int)]
	}).(ScalingPlanOutput)
}

type ScalingPlanMapOutput struct{ *pulumi.OutputState }

func (ScalingPlanMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ScalingPlan)(nil)).Elem()
}

func (o ScalingPlanMapOutput) ToScalingPlanMapOutput() ScalingPlanMapOutput {
	return o
}

func (o ScalingPlanMapOutput) ToScalingPlanMapOutputWithContext(ctx context.Context) ScalingPlanMapOutput {
	return o
}

func (o ScalingPlanMapOutput) MapIndex(k pulumi.StringInput) ScalingPlanOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *ScalingPlan {
		return vs[0].(map[string]*ScalingPlan)[vs[1].(string)]
	}).(ScalingPlanOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ScalingPlanInput)(nil)).Elem(), &ScalingPlan{})
	pulumi.RegisterInputType(reflect.TypeOf((*ScalingPlanArrayInput)(nil)).Elem(), ScalingPlanArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ScalingPlanMapInput)(nil)).Elem(), ScalingPlanMap{})
	pulumi.RegisterOutputType(ScalingPlanOutput{})
	pulumi.RegisterOutputType(ScalingPlanArrayOutput{})
	pulumi.RegisterOutputType(ScalingPlanMapOutput{})
}
