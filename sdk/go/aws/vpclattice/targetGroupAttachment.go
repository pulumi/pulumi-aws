// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package vpclattice

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides the ability to register a target with an AWS VPC Lattice Target Group.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/vpclattice"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := vpclattice.NewTargetGroupAttachment(ctx, "example", &vpclattice.TargetGroupAttachmentArgs{
//				TargetGroupIdentifier: pulumi.Any(exampleAwsVpclatticeTargetGroup.Id),
//				Target: &vpclattice.TargetGroupAttachmentTargetArgs{
//					Id:   pulumi.Any(exampleAwsLb.Arn),
//					Port: pulumi.Int(80),
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
type TargetGroupAttachment struct {
	pulumi.CustomResourceState

	// The target.
	Target TargetGroupAttachmentTargetOutput `pulumi:"target"`
	// The ID or Amazon Resource Name (ARN) of the target group.
	TargetGroupIdentifier pulumi.StringOutput `pulumi:"targetGroupIdentifier"`
}

// NewTargetGroupAttachment registers a new resource with the given unique name, arguments, and options.
func NewTargetGroupAttachment(ctx *pulumi.Context,
	name string, args *TargetGroupAttachmentArgs, opts ...pulumi.ResourceOption) (*TargetGroupAttachment, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.Target == nil {
		return nil, errors.New("invalid value for required argument 'Target'")
	}
	if args.TargetGroupIdentifier == nil {
		return nil, errors.New("invalid value for required argument 'TargetGroupIdentifier'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource TargetGroupAttachment
	err := ctx.RegisterResource("aws:vpclattice/targetGroupAttachment:TargetGroupAttachment", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetTargetGroupAttachment gets an existing TargetGroupAttachment resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetTargetGroupAttachment(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *TargetGroupAttachmentState, opts ...pulumi.ResourceOption) (*TargetGroupAttachment, error) {
	var resource TargetGroupAttachment
	err := ctx.ReadResource("aws:vpclattice/targetGroupAttachment:TargetGroupAttachment", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering TargetGroupAttachment resources.
type targetGroupAttachmentState struct {
	// The target.
	Target *TargetGroupAttachmentTarget `pulumi:"target"`
	// The ID or Amazon Resource Name (ARN) of the target group.
	TargetGroupIdentifier *string `pulumi:"targetGroupIdentifier"`
}

type TargetGroupAttachmentState struct {
	// The target.
	Target TargetGroupAttachmentTargetPtrInput
	// The ID or Amazon Resource Name (ARN) of the target group.
	TargetGroupIdentifier pulumi.StringPtrInput
}

func (TargetGroupAttachmentState) ElementType() reflect.Type {
	return reflect.TypeOf((*targetGroupAttachmentState)(nil)).Elem()
}

type targetGroupAttachmentArgs struct {
	// The target.
	Target TargetGroupAttachmentTarget `pulumi:"target"`
	// The ID or Amazon Resource Name (ARN) of the target group.
	TargetGroupIdentifier string `pulumi:"targetGroupIdentifier"`
}

// The set of arguments for constructing a TargetGroupAttachment resource.
type TargetGroupAttachmentArgs struct {
	// The target.
	Target TargetGroupAttachmentTargetInput
	// The ID or Amazon Resource Name (ARN) of the target group.
	TargetGroupIdentifier pulumi.StringInput
}

func (TargetGroupAttachmentArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*targetGroupAttachmentArgs)(nil)).Elem()
}

type TargetGroupAttachmentInput interface {
	pulumi.Input

	ToTargetGroupAttachmentOutput() TargetGroupAttachmentOutput
	ToTargetGroupAttachmentOutputWithContext(ctx context.Context) TargetGroupAttachmentOutput
}

func (*TargetGroupAttachment) ElementType() reflect.Type {
	return reflect.TypeOf((**TargetGroupAttachment)(nil)).Elem()
}

func (i *TargetGroupAttachment) ToTargetGroupAttachmentOutput() TargetGroupAttachmentOutput {
	return i.ToTargetGroupAttachmentOutputWithContext(context.Background())
}

func (i *TargetGroupAttachment) ToTargetGroupAttachmentOutputWithContext(ctx context.Context) TargetGroupAttachmentOutput {
	return pulumi.ToOutputWithContext(ctx, i).(TargetGroupAttachmentOutput)
}

// TargetGroupAttachmentArrayInput is an input type that accepts TargetGroupAttachmentArray and TargetGroupAttachmentArrayOutput values.
// You can construct a concrete instance of `TargetGroupAttachmentArrayInput` via:
//
//	TargetGroupAttachmentArray{ TargetGroupAttachmentArgs{...} }
type TargetGroupAttachmentArrayInput interface {
	pulumi.Input

	ToTargetGroupAttachmentArrayOutput() TargetGroupAttachmentArrayOutput
	ToTargetGroupAttachmentArrayOutputWithContext(context.Context) TargetGroupAttachmentArrayOutput
}

type TargetGroupAttachmentArray []TargetGroupAttachmentInput

func (TargetGroupAttachmentArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*TargetGroupAttachment)(nil)).Elem()
}

func (i TargetGroupAttachmentArray) ToTargetGroupAttachmentArrayOutput() TargetGroupAttachmentArrayOutput {
	return i.ToTargetGroupAttachmentArrayOutputWithContext(context.Background())
}

func (i TargetGroupAttachmentArray) ToTargetGroupAttachmentArrayOutputWithContext(ctx context.Context) TargetGroupAttachmentArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(TargetGroupAttachmentArrayOutput)
}

// TargetGroupAttachmentMapInput is an input type that accepts TargetGroupAttachmentMap and TargetGroupAttachmentMapOutput values.
// You can construct a concrete instance of `TargetGroupAttachmentMapInput` via:
//
//	TargetGroupAttachmentMap{ "key": TargetGroupAttachmentArgs{...} }
type TargetGroupAttachmentMapInput interface {
	pulumi.Input

	ToTargetGroupAttachmentMapOutput() TargetGroupAttachmentMapOutput
	ToTargetGroupAttachmentMapOutputWithContext(context.Context) TargetGroupAttachmentMapOutput
}

type TargetGroupAttachmentMap map[string]TargetGroupAttachmentInput

func (TargetGroupAttachmentMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*TargetGroupAttachment)(nil)).Elem()
}

func (i TargetGroupAttachmentMap) ToTargetGroupAttachmentMapOutput() TargetGroupAttachmentMapOutput {
	return i.ToTargetGroupAttachmentMapOutputWithContext(context.Background())
}

func (i TargetGroupAttachmentMap) ToTargetGroupAttachmentMapOutputWithContext(ctx context.Context) TargetGroupAttachmentMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(TargetGroupAttachmentMapOutput)
}

type TargetGroupAttachmentOutput struct{ *pulumi.OutputState }

func (TargetGroupAttachmentOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**TargetGroupAttachment)(nil)).Elem()
}

func (o TargetGroupAttachmentOutput) ToTargetGroupAttachmentOutput() TargetGroupAttachmentOutput {
	return o
}

func (o TargetGroupAttachmentOutput) ToTargetGroupAttachmentOutputWithContext(ctx context.Context) TargetGroupAttachmentOutput {
	return o
}

// The target.
func (o TargetGroupAttachmentOutput) Target() TargetGroupAttachmentTargetOutput {
	return o.ApplyT(func(v *TargetGroupAttachment) TargetGroupAttachmentTargetOutput { return v.Target }).(TargetGroupAttachmentTargetOutput)
}

// The ID or Amazon Resource Name (ARN) of the target group.
func (o TargetGroupAttachmentOutput) TargetGroupIdentifier() pulumi.StringOutput {
	return o.ApplyT(func(v *TargetGroupAttachment) pulumi.StringOutput { return v.TargetGroupIdentifier }).(pulumi.StringOutput)
}

type TargetGroupAttachmentArrayOutput struct{ *pulumi.OutputState }

func (TargetGroupAttachmentArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*TargetGroupAttachment)(nil)).Elem()
}

func (o TargetGroupAttachmentArrayOutput) ToTargetGroupAttachmentArrayOutput() TargetGroupAttachmentArrayOutput {
	return o
}

func (o TargetGroupAttachmentArrayOutput) ToTargetGroupAttachmentArrayOutputWithContext(ctx context.Context) TargetGroupAttachmentArrayOutput {
	return o
}

func (o TargetGroupAttachmentArrayOutput) Index(i pulumi.IntInput) TargetGroupAttachmentOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *TargetGroupAttachment {
		return vs[0].([]*TargetGroupAttachment)[vs[1].(int)]
	}).(TargetGroupAttachmentOutput)
}

type TargetGroupAttachmentMapOutput struct{ *pulumi.OutputState }

func (TargetGroupAttachmentMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*TargetGroupAttachment)(nil)).Elem()
}

func (o TargetGroupAttachmentMapOutput) ToTargetGroupAttachmentMapOutput() TargetGroupAttachmentMapOutput {
	return o
}

func (o TargetGroupAttachmentMapOutput) ToTargetGroupAttachmentMapOutputWithContext(ctx context.Context) TargetGroupAttachmentMapOutput {
	return o
}

func (o TargetGroupAttachmentMapOutput) MapIndex(k pulumi.StringInput) TargetGroupAttachmentOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *TargetGroupAttachment {
		return vs[0].(map[string]*TargetGroupAttachment)[vs[1].(string)]
	}).(TargetGroupAttachmentOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*TargetGroupAttachmentInput)(nil)).Elem(), &TargetGroupAttachment{})
	pulumi.RegisterInputType(reflect.TypeOf((*TargetGroupAttachmentArrayInput)(nil)).Elem(), TargetGroupAttachmentArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*TargetGroupAttachmentMapInput)(nil)).Elem(), TargetGroupAttachmentMap{})
	pulumi.RegisterOutputType(TargetGroupAttachmentOutput{})
	pulumi.RegisterOutputType(TargetGroupAttachmentArrayOutput{})
	pulumi.RegisterOutputType(TargetGroupAttachmentMapOutput{})
}
