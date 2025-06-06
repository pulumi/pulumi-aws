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

// Resource for managing an AWS User Notifications Channel Association. This resource associates a channel (such as an email contact) with a notification configuration.
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
//			example, err := notifications.NewNotificationConfiguration(ctx, "example", &notifications.NotificationConfigurationArgs{
//				Name:        pulumi.String("example-notification-config"),
//				Description: pulumi.String("Example notification configuration"),
//			})
//			if err != nil {
//				return err
//			}
//			exampleContactsEmailContact, err := notifications.NewContactsEmailContact(ctx, "example", &notifications.ContactsEmailContactArgs{
//				Name:         pulumi.String("example-contact"),
//				EmailAddress: pulumi.String("example@example.com"),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = notifications.NewChannelAssociation(ctx, "example", &notifications.ChannelAssociationArgs{
//				Arn:                          exampleContactsEmailContact.Arn,
//				NotificationConfigurationArn: example.Arn,
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
// Using `pulumi import`, import User Notifications Channel Association using the `notification_configuration_arn,channel_arn` format. For example:
//
// ```sh
// $ pulumi import aws:notifications/channelAssociation:ChannelAssociation example arn:aws:notifications:us-west-2:123456789012:configuration:example-notification-config,arn:aws:notificationscontacts:us-west-2:123456789012:emailcontact:example-contact
// ```
type ChannelAssociation struct {
	pulumi.CustomResourceState

	// ARN of the channel to associate with the notification configuration. This can be an email contact ARN.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// ARN of the notification configuration to associate the channel with.
	NotificationConfigurationArn pulumi.StringOutput `pulumi:"notificationConfigurationArn"`
}

// NewChannelAssociation registers a new resource with the given unique name, arguments, and options.
func NewChannelAssociation(ctx *pulumi.Context,
	name string, args *ChannelAssociationArgs, opts ...pulumi.ResourceOption) (*ChannelAssociation, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.Arn == nil {
		return nil, errors.New("invalid value for required argument 'Arn'")
	}
	if args.NotificationConfigurationArn == nil {
		return nil, errors.New("invalid value for required argument 'NotificationConfigurationArn'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource ChannelAssociation
	err := ctx.RegisterResource("aws:notifications/channelAssociation:ChannelAssociation", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetChannelAssociation gets an existing ChannelAssociation resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetChannelAssociation(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ChannelAssociationState, opts ...pulumi.ResourceOption) (*ChannelAssociation, error) {
	var resource ChannelAssociation
	err := ctx.ReadResource("aws:notifications/channelAssociation:ChannelAssociation", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering ChannelAssociation resources.
type channelAssociationState struct {
	// ARN of the channel to associate with the notification configuration. This can be an email contact ARN.
	Arn *string `pulumi:"arn"`
	// ARN of the notification configuration to associate the channel with.
	NotificationConfigurationArn *string `pulumi:"notificationConfigurationArn"`
}

type ChannelAssociationState struct {
	// ARN of the channel to associate with the notification configuration. This can be an email contact ARN.
	Arn pulumi.StringPtrInput
	// ARN of the notification configuration to associate the channel with.
	NotificationConfigurationArn pulumi.StringPtrInput
}

func (ChannelAssociationState) ElementType() reflect.Type {
	return reflect.TypeOf((*channelAssociationState)(nil)).Elem()
}

type channelAssociationArgs struct {
	// ARN of the channel to associate with the notification configuration. This can be an email contact ARN.
	Arn string `pulumi:"arn"`
	// ARN of the notification configuration to associate the channel with.
	NotificationConfigurationArn string `pulumi:"notificationConfigurationArn"`
}

// The set of arguments for constructing a ChannelAssociation resource.
type ChannelAssociationArgs struct {
	// ARN of the channel to associate with the notification configuration. This can be an email contact ARN.
	Arn pulumi.StringInput
	// ARN of the notification configuration to associate the channel with.
	NotificationConfigurationArn pulumi.StringInput
}

func (ChannelAssociationArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*channelAssociationArgs)(nil)).Elem()
}

type ChannelAssociationInput interface {
	pulumi.Input

	ToChannelAssociationOutput() ChannelAssociationOutput
	ToChannelAssociationOutputWithContext(ctx context.Context) ChannelAssociationOutput
}

func (*ChannelAssociation) ElementType() reflect.Type {
	return reflect.TypeOf((**ChannelAssociation)(nil)).Elem()
}

func (i *ChannelAssociation) ToChannelAssociationOutput() ChannelAssociationOutput {
	return i.ToChannelAssociationOutputWithContext(context.Background())
}

func (i *ChannelAssociation) ToChannelAssociationOutputWithContext(ctx context.Context) ChannelAssociationOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ChannelAssociationOutput)
}

// ChannelAssociationArrayInput is an input type that accepts ChannelAssociationArray and ChannelAssociationArrayOutput values.
// You can construct a concrete instance of `ChannelAssociationArrayInput` via:
//
//	ChannelAssociationArray{ ChannelAssociationArgs{...} }
type ChannelAssociationArrayInput interface {
	pulumi.Input

	ToChannelAssociationArrayOutput() ChannelAssociationArrayOutput
	ToChannelAssociationArrayOutputWithContext(context.Context) ChannelAssociationArrayOutput
}

type ChannelAssociationArray []ChannelAssociationInput

func (ChannelAssociationArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ChannelAssociation)(nil)).Elem()
}

func (i ChannelAssociationArray) ToChannelAssociationArrayOutput() ChannelAssociationArrayOutput {
	return i.ToChannelAssociationArrayOutputWithContext(context.Background())
}

func (i ChannelAssociationArray) ToChannelAssociationArrayOutputWithContext(ctx context.Context) ChannelAssociationArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ChannelAssociationArrayOutput)
}

// ChannelAssociationMapInput is an input type that accepts ChannelAssociationMap and ChannelAssociationMapOutput values.
// You can construct a concrete instance of `ChannelAssociationMapInput` via:
//
//	ChannelAssociationMap{ "key": ChannelAssociationArgs{...} }
type ChannelAssociationMapInput interface {
	pulumi.Input

	ToChannelAssociationMapOutput() ChannelAssociationMapOutput
	ToChannelAssociationMapOutputWithContext(context.Context) ChannelAssociationMapOutput
}

type ChannelAssociationMap map[string]ChannelAssociationInput

func (ChannelAssociationMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ChannelAssociation)(nil)).Elem()
}

func (i ChannelAssociationMap) ToChannelAssociationMapOutput() ChannelAssociationMapOutput {
	return i.ToChannelAssociationMapOutputWithContext(context.Background())
}

func (i ChannelAssociationMap) ToChannelAssociationMapOutputWithContext(ctx context.Context) ChannelAssociationMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ChannelAssociationMapOutput)
}

type ChannelAssociationOutput struct{ *pulumi.OutputState }

func (ChannelAssociationOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**ChannelAssociation)(nil)).Elem()
}

func (o ChannelAssociationOutput) ToChannelAssociationOutput() ChannelAssociationOutput {
	return o
}

func (o ChannelAssociationOutput) ToChannelAssociationOutputWithContext(ctx context.Context) ChannelAssociationOutput {
	return o
}

// ARN of the channel to associate with the notification configuration. This can be an email contact ARN.
func (o ChannelAssociationOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *ChannelAssociation) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// ARN of the notification configuration to associate the channel with.
func (o ChannelAssociationOutput) NotificationConfigurationArn() pulumi.StringOutput {
	return o.ApplyT(func(v *ChannelAssociation) pulumi.StringOutput { return v.NotificationConfigurationArn }).(pulumi.StringOutput)
}

type ChannelAssociationArrayOutput struct{ *pulumi.OutputState }

func (ChannelAssociationArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ChannelAssociation)(nil)).Elem()
}

func (o ChannelAssociationArrayOutput) ToChannelAssociationArrayOutput() ChannelAssociationArrayOutput {
	return o
}

func (o ChannelAssociationArrayOutput) ToChannelAssociationArrayOutputWithContext(ctx context.Context) ChannelAssociationArrayOutput {
	return o
}

func (o ChannelAssociationArrayOutput) Index(i pulumi.IntInput) ChannelAssociationOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *ChannelAssociation {
		return vs[0].([]*ChannelAssociation)[vs[1].(int)]
	}).(ChannelAssociationOutput)
}

type ChannelAssociationMapOutput struct{ *pulumi.OutputState }

func (ChannelAssociationMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ChannelAssociation)(nil)).Elem()
}

func (o ChannelAssociationMapOutput) ToChannelAssociationMapOutput() ChannelAssociationMapOutput {
	return o
}

func (o ChannelAssociationMapOutput) ToChannelAssociationMapOutputWithContext(ctx context.Context) ChannelAssociationMapOutput {
	return o
}

func (o ChannelAssociationMapOutput) MapIndex(k pulumi.StringInput) ChannelAssociationOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *ChannelAssociation {
		return vs[0].(map[string]*ChannelAssociation)[vs[1].(string)]
	}).(ChannelAssociationOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ChannelAssociationInput)(nil)).Elem(), &ChannelAssociation{})
	pulumi.RegisterInputType(reflect.TypeOf((*ChannelAssociationArrayInput)(nil)).Elem(), ChannelAssociationArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ChannelAssociationMapInput)(nil)).Elem(), ChannelAssociationMap{})
	pulumi.RegisterOutputType(ChannelAssociationOutput{})
	pulumi.RegisterOutputType(ChannelAssociationArrayOutput{})
	pulumi.RegisterOutputType(ChannelAssociationMapOutput{})
}
