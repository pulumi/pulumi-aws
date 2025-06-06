// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package notifications

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS User Notifications Notification Hub.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/notifications"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := notifications.NewNotificationHub(ctx, "example", &notifications.NotificationHubArgs{
//				NotificationHubRegion: pulumi.String("us-west-2"),
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
// Using `pulumi import`, import User Notifications Notification Hub using the `notification_hub_region`. For example:
//
// ```sh
// $ pulumi import aws:notifications/notificationHub:NotificationHub example us-west-2
// ```
type NotificationHub struct {
	pulumi.CustomResourceState

	// Notification Hub region.
	NotificationHubRegion pulumi.StringOutput              `pulumi:"notificationHubRegion"`
	Timeouts              NotificationHubTimeoutsPtrOutput `pulumi:"timeouts"`
}

// NewNotificationHub registers a new resource with the given unique name, arguments, and options.
func NewNotificationHub(ctx *pulumi.Context,
	name string, args *NotificationHubArgs, opts ...pulumi.ResourceOption) (*NotificationHub, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.NotificationHubRegion == nil {
		return nil, errors.New("invalid value for required argument 'NotificationHubRegion'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource NotificationHub
	err := ctx.RegisterResource("aws:notifications/notificationHub:NotificationHub", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetNotificationHub gets an existing NotificationHub resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetNotificationHub(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *NotificationHubState, opts ...pulumi.ResourceOption) (*NotificationHub, error) {
	var resource NotificationHub
	err := ctx.ReadResource("aws:notifications/notificationHub:NotificationHub", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering NotificationHub resources.
type notificationHubState struct {
	// Notification Hub region.
	NotificationHubRegion *string                  `pulumi:"notificationHubRegion"`
	Timeouts              *NotificationHubTimeouts `pulumi:"timeouts"`
}

type NotificationHubState struct {
	// Notification Hub region.
	NotificationHubRegion pulumi.StringPtrInput
	Timeouts              NotificationHubTimeoutsPtrInput
}

func (NotificationHubState) ElementType() reflect.Type {
	return reflect.TypeOf((*notificationHubState)(nil)).Elem()
}

type notificationHubArgs struct {
	// Notification Hub region.
	NotificationHubRegion string                   `pulumi:"notificationHubRegion"`
	Timeouts              *NotificationHubTimeouts `pulumi:"timeouts"`
}

// The set of arguments for constructing a NotificationHub resource.
type NotificationHubArgs struct {
	// Notification Hub region.
	NotificationHubRegion pulumi.StringInput
	Timeouts              NotificationHubTimeoutsPtrInput
}

func (NotificationHubArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*notificationHubArgs)(nil)).Elem()
}

type NotificationHubInput interface {
	pulumi.Input

	ToNotificationHubOutput() NotificationHubOutput
	ToNotificationHubOutputWithContext(ctx context.Context) NotificationHubOutput
}

func (*NotificationHub) ElementType() reflect.Type {
	return reflect.TypeOf((**NotificationHub)(nil)).Elem()
}

func (i *NotificationHub) ToNotificationHubOutput() NotificationHubOutput {
	return i.ToNotificationHubOutputWithContext(context.Background())
}

func (i *NotificationHub) ToNotificationHubOutputWithContext(ctx context.Context) NotificationHubOutput {
	return pulumi.ToOutputWithContext(ctx, i).(NotificationHubOutput)
}

// NotificationHubArrayInput is an input type that accepts NotificationHubArray and NotificationHubArrayOutput values.
// You can construct a concrete instance of `NotificationHubArrayInput` via:
//
//	NotificationHubArray{ NotificationHubArgs{...} }
type NotificationHubArrayInput interface {
	pulumi.Input

	ToNotificationHubArrayOutput() NotificationHubArrayOutput
	ToNotificationHubArrayOutputWithContext(context.Context) NotificationHubArrayOutput
}

type NotificationHubArray []NotificationHubInput

func (NotificationHubArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*NotificationHub)(nil)).Elem()
}

func (i NotificationHubArray) ToNotificationHubArrayOutput() NotificationHubArrayOutput {
	return i.ToNotificationHubArrayOutputWithContext(context.Background())
}

func (i NotificationHubArray) ToNotificationHubArrayOutputWithContext(ctx context.Context) NotificationHubArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(NotificationHubArrayOutput)
}

// NotificationHubMapInput is an input type that accepts NotificationHubMap and NotificationHubMapOutput values.
// You can construct a concrete instance of `NotificationHubMapInput` via:
//
//	NotificationHubMap{ "key": NotificationHubArgs{...} }
type NotificationHubMapInput interface {
	pulumi.Input

	ToNotificationHubMapOutput() NotificationHubMapOutput
	ToNotificationHubMapOutputWithContext(context.Context) NotificationHubMapOutput
}

type NotificationHubMap map[string]NotificationHubInput

func (NotificationHubMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*NotificationHub)(nil)).Elem()
}

func (i NotificationHubMap) ToNotificationHubMapOutput() NotificationHubMapOutput {
	return i.ToNotificationHubMapOutputWithContext(context.Background())
}

func (i NotificationHubMap) ToNotificationHubMapOutputWithContext(ctx context.Context) NotificationHubMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(NotificationHubMapOutput)
}

type NotificationHubOutput struct{ *pulumi.OutputState }

func (NotificationHubOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**NotificationHub)(nil)).Elem()
}

func (o NotificationHubOutput) ToNotificationHubOutput() NotificationHubOutput {
	return o
}

func (o NotificationHubOutput) ToNotificationHubOutputWithContext(ctx context.Context) NotificationHubOutput {
	return o
}

// Notification Hub region.
func (o NotificationHubOutput) NotificationHubRegion() pulumi.StringOutput {
	return o.ApplyT(func(v *NotificationHub) pulumi.StringOutput { return v.NotificationHubRegion }).(pulumi.StringOutput)
}

func (o NotificationHubOutput) Timeouts() NotificationHubTimeoutsPtrOutput {
	return o.ApplyT(func(v *NotificationHub) NotificationHubTimeoutsPtrOutput { return v.Timeouts }).(NotificationHubTimeoutsPtrOutput)
}

type NotificationHubArrayOutput struct{ *pulumi.OutputState }

func (NotificationHubArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*NotificationHub)(nil)).Elem()
}

func (o NotificationHubArrayOutput) ToNotificationHubArrayOutput() NotificationHubArrayOutput {
	return o
}

func (o NotificationHubArrayOutput) ToNotificationHubArrayOutputWithContext(ctx context.Context) NotificationHubArrayOutput {
	return o
}

func (o NotificationHubArrayOutput) Index(i pulumi.IntInput) NotificationHubOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *NotificationHub {
		return vs[0].([]*NotificationHub)[vs[1].(int)]
	}).(NotificationHubOutput)
}

type NotificationHubMapOutput struct{ *pulumi.OutputState }

func (NotificationHubMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*NotificationHub)(nil)).Elem()
}

func (o NotificationHubMapOutput) ToNotificationHubMapOutput() NotificationHubMapOutput {
	return o
}

func (o NotificationHubMapOutput) ToNotificationHubMapOutputWithContext(ctx context.Context) NotificationHubMapOutput {
	return o
}

func (o NotificationHubMapOutput) MapIndex(k pulumi.StringInput) NotificationHubOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *NotificationHub {
		return vs[0].(map[string]*NotificationHub)[vs[1].(string)]
	}).(NotificationHubOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*NotificationHubInput)(nil)).Elem(), &NotificationHub{})
	pulumi.RegisterInputType(reflect.TypeOf((*NotificationHubArrayInput)(nil)).Elem(), NotificationHubArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*NotificationHubMapInput)(nil)).Elem(), NotificationHubMap{})
	pulumi.RegisterOutputType(NotificationHubOutput{})
	pulumi.RegisterOutputType(NotificationHubArrayOutput{})
	pulumi.RegisterOutputType(NotificationHubMapOutput{})
}
