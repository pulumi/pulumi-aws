// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package lightsail

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Manages a Lightsail Load Balancer Attachment. Use this resource to attach Lightsail instances to a load balancer for distributing traffic across multiple instances.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/lightsail"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			available, err := aws.GetAvailabilityZones(ctx, &aws.GetAvailabilityZonesArgs{
//				State: pulumi.StringRef("available"),
//				Filters: []aws.GetAvailabilityZonesFilter{
//					{
//						Name: "opt-in-status",
//						Values: []string{
//							"opt-in-not-required",
//						},
//					},
//				},
//			}, nil)
//			if err != nil {
//				return err
//			}
//			example, err := lightsail.NewLb(ctx, "example", &lightsail.LbArgs{
//				Name:            pulumi.String("example-load-balancer"),
//				HealthCheckPath: pulumi.String("/"),
//				InstancePort:    pulumi.Int(80),
//				Tags: pulumi.StringMap{
//					"foo": pulumi.String("bar"),
//				},
//			})
//			if err != nil {
//				return err
//			}
//			exampleInstance, err := lightsail.NewInstance(ctx, "example", &lightsail.InstanceArgs{
//				Name:             pulumi.String("example-instance"),
//				AvailabilityZone: pulumi.String(available.Names[0]),
//				BlueprintId:      pulumi.String("amazon_linux_2"),
//				BundleId:         pulumi.String("nano_3_0"),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = lightsail.NewLbAttachment(ctx, "example", &lightsail.LbAttachmentArgs{
//				LbName:       example.Name,
//				InstanceName: exampleInstance.Name,
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
// Using `pulumi import`, import `aws_lightsail_lb_attachment` using the name attribute. For example:
//
// ```sh
// $ pulumi import aws:lightsail/lbAttachment:LbAttachment example example-load-balancer,example-instance
// ```
type LbAttachment struct {
	pulumi.CustomResourceState

	// Name of the instance to attach to the load balancer.
	InstanceName pulumi.StringOutput `pulumi:"instanceName"`
	// Name of the Lightsail load balancer.
	LbName pulumi.StringOutput `pulumi:"lbName"`
}

// NewLbAttachment registers a new resource with the given unique name, arguments, and options.
func NewLbAttachment(ctx *pulumi.Context,
	name string, args *LbAttachmentArgs, opts ...pulumi.ResourceOption) (*LbAttachment, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.InstanceName == nil {
		return nil, errors.New("invalid value for required argument 'InstanceName'")
	}
	if args.LbName == nil {
		return nil, errors.New("invalid value for required argument 'LbName'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource LbAttachment
	err := ctx.RegisterResource("aws:lightsail/lbAttachment:LbAttachment", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetLbAttachment gets an existing LbAttachment resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetLbAttachment(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *LbAttachmentState, opts ...pulumi.ResourceOption) (*LbAttachment, error) {
	var resource LbAttachment
	err := ctx.ReadResource("aws:lightsail/lbAttachment:LbAttachment", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering LbAttachment resources.
type lbAttachmentState struct {
	// Name of the instance to attach to the load balancer.
	InstanceName *string `pulumi:"instanceName"`
	// Name of the Lightsail load balancer.
	LbName *string `pulumi:"lbName"`
}

type LbAttachmentState struct {
	// Name of the instance to attach to the load balancer.
	InstanceName pulumi.StringPtrInput
	// Name of the Lightsail load balancer.
	LbName pulumi.StringPtrInput
}

func (LbAttachmentState) ElementType() reflect.Type {
	return reflect.TypeOf((*lbAttachmentState)(nil)).Elem()
}

type lbAttachmentArgs struct {
	// Name of the instance to attach to the load balancer.
	InstanceName string `pulumi:"instanceName"`
	// Name of the Lightsail load balancer.
	LbName string `pulumi:"lbName"`
}

// The set of arguments for constructing a LbAttachment resource.
type LbAttachmentArgs struct {
	// Name of the instance to attach to the load balancer.
	InstanceName pulumi.StringInput
	// Name of the Lightsail load balancer.
	LbName pulumi.StringInput
}

func (LbAttachmentArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*lbAttachmentArgs)(nil)).Elem()
}

type LbAttachmentInput interface {
	pulumi.Input

	ToLbAttachmentOutput() LbAttachmentOutput
	ToLbAttachmentOutputWithContext(ctx context.Context) LbAttachmentOutput
}

func (*LbAttachment) ElementType() reflect.Type {
	return reflect.TypeOf((**LbAttachment)(nil)).Elem()
}

func (i *LbAttachment) ToLbAttachmentOutput() LbAttachmentOutput {
	return i.ToLbAttachmentOutputWithContext(context.Background())
}

func (i *LbAttachment) ToLbAttachmentOutputWithContext(ctx context.Context) LbAttachmentOutput {
	return pulumi.ToOutputWithContext(ctx, i).(LbAttachmentOutput)
}

// LbAttachmentArrayInput is an input type that accepts LbAttachmentArray and LbAttachmentArrayOutput values.
// You can construct a concrete instance of `LbAttachmentArrayInput` via:
//
//	LbAttachmentArray{ LbAttachmentArgs{...} }
type LbAttachmentArrayInput interface {
	pulumi.Input

	ToLbAttachmentArrayOutput() LbAttachmentArrayOutput
	ToLbAttachmentArrayOutputWithContext(context.Context) LbAttachmentArrayOutput
}

type LbAttachmentArray []LbAttachmentInput

func (LbAttachmentArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*LbAttachment)(nil)).Elem()
}

func (i LbAttachmentArray) ToLbAttachmentArrayOutput() LbAttachmentArrayOutput {
	return i.ToLbAttachmentArrayOutputWithContext(context.Background())
}

func (i LbAttachmentArray) ToLbAttachmentArrayOutputWithContext(ctx context.Context) LbAttachmentArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(LbAttachmentArrayOutput)
}

// LbAttachmentMapInput is an input type that accepts LbAttachmentMap and LbAttachmentMapOutput values.
// You can construct a concrete instance of `LbAttachmentMapInput` via:
//
//	LbAttachmentMap{ "key": LbAttachmentArgs{...} }
type LbAttachmentMapInput interface {
	pulumi.Input

	ToLbAttachmentMapOutput() LbAttachmentMapOutput
	ToLbAttachmentMapOutputWithContext(context.Context) LbAttachmentMapOutput
}

type LbAttachmentMap map[string]LbAttachmentInput

func (LbAttachmentMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*LbAttachment)(nil)).Elem()
}

func (i LbAttachmentMap) ToLbAttachmentMapOutput() LbAttachmentMapOutput {
	return i.ToLbAttachmentMapOutputWithContext(context.Background())
}

func (i LbAttachmentMap) ToLbAttachmentMapOutputWithContext(ctx context.Context) LbAttachmentMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(LbAttachmentMapOutput)
}

type LbAttachmentOutput struct{ *pulumi.OutputState }

func (LbAttachmentOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**LbAttachment)(nil)).Elem()
}

func (o LbAttachmentOutput) ToLbAttachmentOutput() LbAttachmentOutput {
	return o
}

func (o LbAttachmentOutput) ToLbAttachmentOutputWithContext(ctx context.Context) LbAttachmentOutput {
	return o
}

// Name of the instance to attach to the load balancer.
func (o LbAttachmentOutput) InstanceName() pulumi.StringOutput {
	return o.ApplyT(func(v *LbAttachment) pulumi.StringOutput { return v.InstanceName }).(pulumi.StringOutput)
}

// Name of the Lightsail load balancer.
func (o LbAttachmentOutput) LbName() pulumi.StringOutput {
	return o.ApplyT(func(v *LbAttachment) pulumi.StringOutput { return v.LbName }).(pulumi.StringOutput)
}

type LbAttachmentArrayOutput struct{ *pulumi.OutputState }

func (LbAttachmentArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*LbAttachment)(nil)).Elem()
}

func (o LbAttachmentArrayOutput) ToLbAttachmentArrayOutput() LbAttachmentArrayOutput {
	return o
}

func (o LbAttachmentArrayOutput) ToLbAttachmentArrayOutputWithContext(ctx context.Context) LbAttachmentArrayOutput {
	return o
}

func (o LbAttachmentArrayOutput) Index(i pulumi.IntInput) LbAttachmentOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *LbAttachment {
		return vs[0].([]*LbAttachment)[vs[1].(int)]
	}).(LbAttachmentOutput)
}

type LbAttachmentMapOutput struct{ *pulumi.OutputState }

func (LbAttachmentMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*LbAttachment)(nil)).Elem()
}

func (o LbAttachmentMapOutput) ToLbAttachmentMapOutput() LbAttachmentMapOutput {
	return o
}

func (o LbAttachmentMapOutput) ToLbAttachmentMapOutputWithContext(ctx context.Context) LbAttachmentMapOutput {
	return o
}

func (o LbAttachmentMapOutput) MapIndex(k pulumi.StringInput) LbAttachmentOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *LbAttachment {
		return vs[0].(map[string]*LbAttachment)[vs[1].(string)]
	}).(LbAttachmentOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*LbAttachmentInput)(nil)).Elem(), &LbAttachment{})
	pulumi.RegisterInputType(reflect.TypeOf((*LbAttachmentArrayInput)(nil)).Elem(), LbAttachmentArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*LbAttachmentMapInput)(nil)).Elem(), LbAttachmentMap{})
	pulumi.RegisterOutputType(LbAttachmentOutput{})
	pulumi.RegisterOutputType(LbAttachmentArrayOutput{})
	pulumi.RegisterOutputType(LbAttachmentMapOutput{})
}
