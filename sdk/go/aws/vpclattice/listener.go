// Code generated by the Pulumi Terraform Bridge (tfgen) Tool DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package vpclattice

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS VPC Lattice Listener.
//
// ## Example Usage
// ### Forward action
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/vpclattice"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := vpclattice.NewService(ctx, "test", nil)
//			if err != nil {
//				return err
//			}
//			exampleTargetGroup, err := vpclattice.NewTargetGroup(ctx, "exampleTargetGroup", &vpclattice.TargetGroupArgs{
//				Type: pulumi.String("INSTANCE"),
//				Config: &vpclattice.TargetGroupConfigArgs{
//					Port:          pulumi.Int(80),
//					Protocol:      pulumi.String("HTTP"),
//					VpcIdentifier: pulumi.Any(aws_vpc.Test.Id),
//				},
//			})
//			if err != nil {
//				return err
//			}
//			_, err = vpclattice.NewListener(ctx, "exampleListener", &vpclattice.ListenerArgs{
//				Protocol:          pulumi.String("HTTP"),
//				ServiceIdentifier: pulumi.Any(aws_vpclattice_service.Example.Id),
//				DefaultAction: &vpclattice.ListenerDefaultActionArgs{
//					Forwards: vpclattice.ListenerDefaultActionForwardArray{
//						&vpclattice.ListenerDefaultActionForwardArgs{
//							TargetGroups: vpclattice.ListenerDefaultActionForwardTargetGroupArray{
//								&vpclattice.ListenerDefaultActionForwardTargetGroupArgs{
//									TargetGroupIdentifier: exampleTargetGroup.ID(),
//								},
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
// ### Forward action with weighted target groups
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/vpclattice"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := vpclattice.NewService(ctx, "test", nil)
//			if err != nil {
//				return err
//			}
//			example1, err := vpclattice.NewTargetGroup(ctx, "example1", &vpclattice.TargetGroupArgs{
//				Type: pulumi.String("INSTANCE"),
//				Config: &vpclattice.TargetGroupConfigArgs{
//					Port:          pulumi.Int(80),
//					Protocol:      pulumi.String("HTTP"),
//					VpcIdentifier: pulumi.Any(aws_vpc.Test.Id),
//				},
//			})
//			if err != nil {
//				return err
//			}
//			example2, err := vpclattice.NewTargetGroup(ctx, "example2", &vpclattice.TargetGroupArgs{
//				Type: pulumi.String("INSTANCE"),
//				Config: &vpclattice.TargetGroupConfigArgs{
//					Port:          pulumi.Int(8080),
//					Protocol:      pulumi.String("HTTP"),
//					VpcIdentifier: pulumi.Any(aws_vpc.Test.Id),
//				},
//			})
//			if err != nil {
//				return err
//			}
//			_, err = vpclattice.NewListener(ctx, "example", &vpclattice.ListenerArgs{
//				Protocol:          pulumi.String("HTTP"),
//				ServiceIdentifier: pulumi.Any(aws_vpclattice_service.Example.Id),
//				DefaultAction: &vpclattice.ListenerDefaultActionArgs{
//					Forwards: vpclattice.ListenerDefaultActionForwardArray{
//						&vpclattice.ListenerDefaultActionForwardArgs{
//							TargetGroups: vpclattice.ListenerDefaultActionForwardTargetGroupArray{
//								&vpclattice.ListenerDefaultActionForwardTargetGroupArgs{
//									TargetGroupIdentifier: example1.ID(),
//									Weight:                pulumi.Int(80),
//								},
//								&vpclattice.ListenerDefaultActionForwardTargetGroupArgs{
//									TargetGroupIdentifier: example2.ID(),
//									Weight:                pulumi.Int(20),
//								},
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
// ## Import
//
// VPC Lattice Listener can be imported by using the `listener_id` of the listener and the `id` of the VPC Lattice service combined with a `/` character, e.g.
//
// ```sh
//
//	$ pulumi import aws:vpclattice/listener:Listener example svc-1a2b3c4d/listener-987654321
//
// ```
type Listener struct {
	pulumi.CustomResourceState

	// ARN of the listener.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Date and time that the listener was created, specified in ISO-8601 format.
	CreatedAt pulumi.StringOutput `pulumi:"createdAt"`
	// Default action block for the default listener rule. Default action blocks are defined below.
	DefaultAction ListenerDefaultActionOutput `pulumi:"defaultAction"`
	LastUpdatedAt pulumi.StringOutput         `pulumi:"lastUpdatedAt"`
	// Standalone ID of the listener, e.g. `listener-0a1b2c3d4e5f6g`.
	ListenerId pulumi.StringOutput `pulumi:"listenerId"`
	// Name of the listener. A listener name must be unique within a service. Valid characters are a-z, 0-9, and hyphens (-). You can't use a hyphen as the first or last character, or immediately after another hyphen.
	Name pulumi.StringOutput `pulumi:"name"`
	// Listener port. You can specify a value from 1 to 65535. If `port` is not specified and `protocol` is HTTP, the value will default to 80. If `port` is not specified and `protocol` is HTTPS, the value will default to 443.
	Port pulumi.IntOutput `pulumi:"port"`
	// Protocol for the listener. Supported values are `HTTP` or `HTTPS`
	Protocol pulumi.StringOutput `pulumi:"protocol"`
	// Amazon Resource Name (ARN) of the VPC Lattice service. You must include either the `serviceArn` or `serviceIdentifier` arguments.
	ServiceArn pulumi.StringOutput `pulumi:"serviceArn"`
	// ID of the VPC Lattice service. You must include either the `serviceArn` or `serviceIdentifier` arguments.
	// > **NOTE:** You must specify one of the following arguments: `serviceArn` or `serviceIdentifier`.
	ServiceIdentifier pulumi.StringOutput `pulumi:"serviceIdentifier"`
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags    pulumi.StringMapOutput `pulumi:"tags"`
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewListener registers a new resource with the given unique name, arguments, and options.
func NewListener(ctx *pulumi.Context,
	name string, args *ListenerArgs, opts ...pulumi.ResourceOption) (*Listener, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.DefaultAction == nil {
		return nil, errors.New("invalid value for required argument 'DefaultAction'")
	}
	if args.Protocol == nil {
		return nil, errors.New("invalid value for required argument 'Protocol'")
	}
	var resource Listener
	err := ctx.RegisterResource("aws:vpclattice/listener:Listener", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetListener gets an existing Listener resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetListener(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ListenerState, opts ...pulumi.ResourceOption) (*Listener, error) {
	var resource Listener
	err := ctx.ReadResource("aws:vpclattice/listener:Listener", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Listener resources.
type listenerState struct {
	// ARN of the listener.
	Arn *string `pulumi:"arn"`
	// Date and time that the listener was created, specified in ISO-8601 format.
	CreatedAt *string `pulumi:"createdAt"`
	// Default action block for the default listener rule. Default action blocks are defined below.
	DefaultAction *ListenerDefaultAction `pulumi:"defaultAction"`
	LastUpdatedAt *string                `pulumi:"lastUpdatedAt"`
	// Standalone ID of the listener, e.g. `listener-0a1b2c3d4e5f6g`.
	ListenerId *string `pulumi:"listenerId"`
	// Name of the listener. A listener name must be unique within a service. Valid characters are a-z, 0-9, and hyphens (-). You can't use a hyphen as the first or last character, or immediately after another hyphen.
	Name *string `pulumi:"name"`
	// Listener port. You can specify a value from 1 to 65535. If `port` is not specified and `protocol` is HTTP, the value will default to 80. If `port` is not specified and `protocol` is HTTPS, the value will default to 443.
	Port *int `pulumi:"port"`
	// Protocol for the listener. Supported values are `HTTP` or `HTTPS`
	Protocol *string `pulumi:"protocol"`
	// Amazon Resource Name (ARN) of the VPC Lattice service. You must include either the `serviceArn` or `serviceIdentifier` arguments.
	ServiceArn *string `pulumi:"serviceArn"`
	// ID of the VPC Lattice service. You must include either the `serviceArn` or `serviceIdentifier` arguments.
	// > **NOTE:** You must specify one of the following arguments: `serviceArn` or `serviceIdentifier`.
	ServiceIdentifier *string `pulumi:"serviceIdentifier"`
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags    map[string]string `pulumi:"tags"`
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type ListenerState struct {
	// ARN of the listener.
	Arn pulumi.StringPtrInput
	// Date and time that the listener was created, specified in ISO-8601 format.
	CreatedAt pulumi.StringPtrInput
	// Default action block for the default listener rule. Default action blocks are defined below.
	DefaultAction ListenerDefaultActionPtrInput
	LastUpdatedAt pulumi.StringPtrInput
	// Standalone ID of the listener, e.g. `listener-0a1b2c3d4e5f6g`.
	ListenerId pulumi.StringPtrInput
	// Name of the listener. A listener name must be unique within a service. Valid characters are a-z, 0-9, and hyphens (-). You can't use a hyphen as the first or last character, or immediately after another hyphen.
	Name pulumi.StringPtrInput
	// Listener port. You can specify a value from 1 to 65535. If `port` is not specified and `protocol` is HTTP, the value will default to 80. If `port` is not specified and `protocol` is HTTPS, the value will default to 443.
	Port pulumi.IntPtrInput
	// Protocol for the listener. Supported values are `HTTP` or `HTTPS`
	Protocol pulumi.StringPtrInput
	// Amazon Resource Name (ARN) of the VPC Lattice service. You must include either the `serviceArn` or `serviceIdentifier` arguments.
	ServiceArn pulumi.StringPtrInput
	// ID of the VPC Lattice service. You must include either the `serviceArn` or `serviceIdentifier` arguments.
	// > **NOTE:** You must specify one of the following arguments: `serviceArn` or `serviceIdentifier`.
	ServiceIdentifier pulumi.StringPtrInput
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags    pulumi.StringMapInput
	TagsAll pulumi.StringMapInput
}

func (ListenerState) ElementType() reflect.Type {
	return reflect.TypeOf((*listenerState)(nil)).Elem()
}

type listenerArgs struct {
	// Default action block for the default listener rule. Default action blocks are defined below.
	DefaultAction ListenerDefaultAction `pulumi:"defaultAction"`
	// Name of the listener. A listener name must be unique within a service. Valid characters are a-z, 0-9, and hyphens (-). You can't use a hyphen as the first or last character, or immediately after another hyphen.
	Name *string `pulumi:"name"`
	// Listener port. You can specify a value from 1 to 65535. If `port` is not specified and `protocol` is HTTP, the value will default to 80. If `port` is not specified and `protocol` is HTTPS, the value will default to 443.
	Port *int `pulumi:"port"`
	// Protocol for the listener. Supported values are `HTTP` or `HTTPS`
	Protocol string `pulumi:"protocol"`
	// Amazon Resource Name (ARN) of the VPC Lattice service. You must include either the `serviceArn` or `serviceIdentifier` arguments.
	ServiceArn *string `pulumi:"serviceArn"`
	// ID of the VPC Lattice service. You must include either the `serviceArn` or `serviceIdentifier` arguments.
	// > **NOTE:** You must specify one of the following arguments: `serviceArn` or `serviceIdentifier`.
	ServiceIdentifier *string `pulumi:"serviceIdentifier"`
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags    map[string]string `pulumi:"tags"`
	TagsAll map[string]string `pulumi:"tagsAll"`
}

// The set of arguments for constructing a Listener resource.
type ListenerArgs struct {
	// Default action block for the default listener rule. Default action blocks are defined below.
	DefaultAction ListenerDefaultActionInput
	// Name of the listener. A listener name must be unique within a service. Valid characters are a-z, 0-9, and hyphens (-). You can't use a hyphen as the first or last character, or immediately after another hyphen.
	Name pulumi.StringPtrInput
	// Listener port. You can specify a value from 1 to 65535. If `port` is not specified and `protocol` is HTTP, the value will default to 80. If `port` is not specified and `protocol` is HTTPS, the value will default to 443.
	Port pulumi.IntPtrInput
	// Protocol for the listener. Supported values are `HTTP` or `HTTPS`
	Protocol pulumi.StringInput
	// Amazon Resource Name (ARN) of the VPC Lattice service. You must include either the `serviceArn` or `serviceIdentifier` arguments.
	ServiceArn pulumi.StringPtrInput
	// ID of the VPC Lattice service. You must include either the `serviceArn` or `serviceIdentifier` arguments.
	// > **NOTE:** You must specify one of the following arguments: `serviceArn` or `serviceIdentifier`.
	ServiceIdentifier pulumi.StringPtrInput
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags    pulumi.StringMapInput
	TagsAll pulumi.StringMapInput
}

func (ListenerArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*listenerArgs)(nil)).Elem()
}

type ListenerInput interface {
	pulumi.Input

	ToListenerOutput() ListenerOutput
	ToListenerOutputWithContext(ctx context.Context) ListenerOutput
}

func (*Listener) ElementType() reflect.Type {
	return reflect.TypeOf((**Listener)(nil)).Elem()
}

func (i *Listener) ToListenerOutput() ListenerOutput {
	return i.ToListenerOutputWithContext(context.Background())
}

func (i *Listener) ToListenerOutputWithContext(ctx context.Context) ListenerOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ListenerOutput)
}

// ListenerArrayInput is an input type that accepts ListenerArray and ListenerArrayOutput values.
// You can construct a concrete instance of `ListenerArrayInput` via:
//
//	ListenerArray{ ListenerArgs{...} }
type ListenerArrayInput interface {
	pulumi.Input

	ToListenerArrayOutput() ListenerArrayOutput
	ToListenerArrayOutputWithContext(context.Context) ListenerArrayOutput
}

type ListenerArray []ListenerInput

func (ListenerArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Listener)(nil)).Elem()
}

func (i ListenerArray) ToListenerArrayOutput() ListenerArrayOutput {
	return i.ToListenerArrayOutputWithContext(context.Background())
}

func (i ListenerArray) ToListenerArrayOutputWithContext(ctx context.Context) ListenerArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ListenerArrayOutput)
}

// ListenerMapInput is an input type that accepts ListenerMap and ListenerMapOutput values.
// You can construct a concrete instance of `ListenerMapInput` via:
//
//	ListenerMap{ "key": ListenerArgs{...} }
type ListenerMapInput interface {
	pulumi.Input

	ToListenerMapOutput() ListenerMapOutput
	ToListenerMapOutputWithContext(context.Context) ListenerMapOutput
}

type ListenerMap map[string]ListenerInput

func (ListenerMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Listener)(nil)).Elem()
}

func (i ListenerMap) ToListenerMapOutput() ListenerMapOutput {
	return i.ToListenerMapOutputWithContext(context.Background())
}

func (i ListenerMap) ToListenerMapOutputWithContext(ctx context.Context) ListenerMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ListenerMapOutput)
}

type ListenerOutput struct{ *pulumi.OutputState }

func (ListenerOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**Listener)(nil)).Elem()
}

func (o ListenerOutput) ToListenerOutput() ListenerOutput {
	return o
}

func (o ListenerOutput) ToListenerOutputWithContext(ctx context.Context) ListenerOutput {
	return o
}

// ARN of the listener.
func (o ListenerOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *Listener) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Date and time that the listener was created, specified in ISO-8601 format.
func (o ListenerOutput) CreatedAt() pulumi.StringOutput {
	return o.ApplyT(func(v *Listener) pulumi.StringOutput { return v.CreatedAt }).(pulumi.StringOutput)
}

// Default action block for the default listener rule. Default action blocks are defined below.
func (o ListenerOutput) DefaultAction() ListenerDefaultActionOutput {
	return o.ApplyT(func(v *Listener) ListenerDefaultActionOutput { return v.DefaultAction }).(ListenerDefaultActionOutput)
}

func (o ListenerOutput) LastUpdatedAt() pulumi.StringOutput {
	return o.ApplyT(func(v *Listener) pulumi.StringOutput { return v.LastUpdatedAt }).(pulumi.StringOutput)
}

// Standalone ID of the listener, e.g. `listener-0a1b2c3d4e5f6g`.
func (o ListenerOutput) ListenerId() pulumi.StringOutput {
	return o.ApplyT(func(v *Listener) pulumi.StringOutput { return v.ListenerId }).(pulumi.StringOutput)
}

// Name of the listener. A listener name must be unique within a service. Valid characters are a-z, 0-9, and hyphens (-). You can't use a hyphen as the first or last character, or immediately after another hyphen.
func (o ListenerOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *Listener) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// Listener port. You can specify a value from 1 to 65535. If `port` is not specified and `protocol` is HTTP, the value will default to 80. If `port` is not specified and `protocol` is HTTPS, the value will default to 443.
func (o ListenerOutput) Port() pulumi.IntOutput {
	return o.ApplyT(func(v *Listener) pulumi.IntOutput { return v.Port }).(pulumi.IntOutput)
}

// Protocol for the listener. Supported values are `HTTP` or `HTTPS`
func (o ListenerOutput) Protocol() pulumi.StringOutput {
	return o.ApplyT(func(v *Listener) pulumi.StringOutput { return v.Protocol }).(pulumi.StringOutput)
}

// Amazon Resource Name (ARN) of the VPC Lattice service. You must include either the `serviceArn` or `serviceIdentifier` arguments.
func (o ListenerOutput) ServiceArn() pulumi.StringOutput {
	return o.ApplyT(func(v *Listener) pulumi.StringOutput { return v.ServiceArn }).(pulumi.StringOutput)
}

// ID of the VPC Lattice service. You must include either the `serviceArn` or `serviceIdentifier` arguments.
// > **NOTE:** You must specify one of the following arguments: `serviceArn` or `serviceIdentifier`.
func (o ListenerOutput) ServiceIdentifier() pulumi.StringOutput {
	return o.ApplyT(func(v *Listener) pulumi.StringOutput { return v.ServiceIdentifier }).(pulumi.StringOutput)
}

// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o ListenerOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Listener) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

func (o ListenerOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Listener) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type ListenerArrayOutput struct{ *pulumi.OutputState }

func (ListenerArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Listener)(nil)).Elem()
}

func (o ListenerArrayOutput) ToListenerArrayOutput() ListenerArrayOutput {
	return o
}

func (o ListenerArrayOutput) ToListenerArrayOutputWithContext(ctx context.Context) ListenerArrayOutput {
	return o
}

func (o ListenerArrayOutput) Index(i pulumi.IntInput) ListenerOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *Listener {
		return vs[0].([]*Listener)[vs[1].(int)]
	}).(ListenerOutput)
}

type ListenerMapOutput struct{ *pulumi.OutputState }

func (ListenerMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Listener)(nil)).Elem()
}

func (o ListenerMapOutput) ToListenerMapOutput() ListenerMapOutput {
	return o
}

func (o ListenerMapOutput) ToListenerMapOutputWithContext(ctx context.Context) ListenerMapOutput {
	return o
}

func (o ListenerMapOutput) MapIndex(k pulumi.StringInput) ListenerOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *Listener {
		return vs[0].(map[string]*Listener)[vs[1].(string)]
	}).(ListenerOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ListenerInput)(nil)).Elem(), &Listener{})
	pulumi.RegisterInputType(reflect.TypeOf((*ListenerArrayInput)(nil)).Elem(), ListenerArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ListenerMapInput)(nil)).Elem(), ListenerMap{})
	pulumi.RegisterOutputType(ListenerOutput{})
	pulumi.RegisterOutputType(ListenerArrayOutput{})
	pulumi.RegisterOutputType(ListenerMapOutput{})
}