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

// Resource for managing an AWS User Notifications Notification Configuration.
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
//			_, err := notifications.NewNotificationConfiguration(ctx, "example", &notifications.NotificationConfigurationArgs{
//				Name:        pulumi.String("example"),
//				Description: pulumi.String("Example notification configuration"),
//				Tags: pulumi.StringMap{
//					"Environment": pulumi.String("production"),
//					"Project":     pulumi.String("example"),
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
// ### With Aggregation Duration
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
//			_, err := notifications.NewNotificationConfiguration(ctx, "example", &notifications.NotificationConfigurationArgs{
//				Name:                pulumi.String("example-aggregation"),
//				Description:         pulumi.String("Example notification configuration with aggregation"),
//				AggregationDuration: pulumi.String("SHORT"),
//				Tags: pulumi.StringMap{
//					"Environment": pulumi.String("production"),
//					"Project":     pulumi.String("example"),
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
// Using `pulumi import`, import User Notifications Notification Configuration using the `arn`. For example:
//
// ```sh
// $ pulumi import aws:notifications/notificationConfiguration:NotificationConfiguration example arn:aws:notifications::123456789012:configuration/abcdef1234567890abcdef1234567890
// ```
type NotificationConfiguration struct {
	pulumi.CustomResourceState

	// Aggregation preference of the NotificationConfiguration. Valid values: `LONG` (
	// aggregate notifications for 12 hours), `SHORT` (aggregate notifications for 5 minutes), `NONE` (don't aggregate
	// notifications). Default: `NONE`.
	AggregationDuration pulumi.StringOutput `pulumi:"aggregationDuration"`
	// Amazon Resource Name (ARN) of the NotificationConfiguration.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Description of the NotificationConfiguration. Length constraints: Minimum length of 0,
	// maximum length of 256.
	Description pulumi.StringOutput `pulumi:"description"`
	// Name of the NotificationConfiguration. Supports RFC 3986's unreserved characters. Length
	// constraints: Minimum length of 1, maximum length of 64. Pattern: `[A-Za-z0-9_\-]+`.
	//
	// The following arguments are optional:
	Name pulumi.StringOutput `pulumi:"name"`
	// Map of tags to assign to the resource. A tag is a string-to-string map of key-value pairs. If
	// configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those
	// defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags`
	// configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewNotificationConfiguration registers a new resource with the given unique name, arguments, and options.
func NewNotificationConfiguration(ctx *pulumi.Context,
	name string, args *NotificationConfigurationArgs, opts ...pulumi.ResourceOption) (*NotificationConfiguration, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.Description == nil {
		return nil, errors.New("invalid value for required argument 'Description'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource NotificationConfiguration
	err := ctx.RegisterResource("aws:notifications/notificationConfiguration:NotificationConfiguration", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetNotificationConfiguration gets an existing NotificationConfiguration resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetNotificationConfiguration(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *NotificationConfigurationState, opts ...pulumi.ResourceOption) (*NotificationConfiguration, error) {
	var resource NotificationConfiguration
	err := ctx.ReadResource("aws:notifications/notificationConfiguration:NotificationConfiguration", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering NotificationConfiguration resources.
type notificationConfigurationState struct {
	// Aggregation preference of the NotificationConfiguration. Valid values: `LONG` (
	// aggregate notifications for 12 hours), `SHORT` (aggregate notifications for 5 minutes), `NONE` (don't aggregate
	// notifications). Default: `NONE`.
	AggregationDuration *string `pulumi:"aggregationDuration"`
	// Amazon Resource Name (ARN) of the NotificationConfiguration.
	Arn *string `pulumi:"arn"`
	// Description of the NotificationConfiguration. Length constraints: Minimum length of 0,
	// maximum length of 256.
	Description *string `pulumi:"description"`
	// Name of the NotificationConfiguration. Supports RFC 3986's unreserved characters. Length
	// constraints: Minimum length of 1, maximum length of 64. Pattern: `[A-Za-z0-9_\-]+`.
	//
	// The following arguments are optional:
	Name *string `pulumi:"name"`
	// Map of tags to assign to the resource. A tag is a string-to-string map of key-value pairs. If
	// configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those
	// defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags`
	// configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type NotificationConfigurationState struct {
	// Aggregation preference of the NotificationConfiguration. Valid values: `LONG` (
	// aggregate notifications for 12 hours), `SHORT` (aggregate notifications for 5 minutes), `NONE` (don't aggregate
	// notifications). Default: `NONE`.
	AggregationDuration pulumi.StringPtrInput
	// Amazon Resource Name (ARN) of the NotificationConfiguration.
	Arn pulumi.StringPtrInput
	// Description of the NotificationConfiguration. Length constraints: Minimum length of 0,
	// maximum length of 256.
	Description pulumi.StringPtrInput
	// Name of the NotificationConfiguration. Supports RFC 3986's unreserved characters. Length
	// constraints: Minimum length of 1, maximum length of 64. Pattern: `[A-Za-z0-9_\-]+`.
	//
	// The following arguments are optional:
	Name pulumi.StringPtrInput
	// Map of tags to assign to the resource. A tag is a string-to-string map of key-value pairs. If
	// configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those
	// defined at the provider-level.
	Tags pulumi.StringMapInput
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags`
	// configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (NotificationConfigurationState) ElementType() reflect.Type {
	return reflect.TypeOf((*notificationConfigurationState)(nil)).Elem()
}

type notificationConfigurationArgs struct {
	// Aggregation preference of the NotificationConfiguration. Valid values: `LONG` (
	// aggregate notifications for 12 hours), `SHORT` (aggregate notifications for 5 minutes), `NONE` (don't aggregate
	// notifications). Default: `NONE`.
	AggregationDuration *string `pulumi:"aggregationDuration"`
	// Description of the NotificationConfiguration. Length constraints: Minimum length of 0,
	// maximum length of 256.
	Description string `pulumi:"description"`
	// Name of the NotificationConfiguration. Supports RFC 3986's unreserved characters. Length
	// constraints: Minimum length of 1, maximum length of 64. Pattern: `[A-Za-z0-9_\-]+`.
	//
	// The following arguments are optional:
	Name *string `pulumi:"name"`
	// Map of tags to assign to the resource. A tag is a string-to-string map of key-value pairs. If
	// configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those
	// defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a NotificationConfiguration resource.
type NotificationConfigurationArgs struct {
	// Aggregation preference of the NotificationConfiguration. Valid values: `LONG` (
	// aggregate notifications for 12 hours), `SHORT` (aggregate notifications for 5 minutes), `NONE` (don't aggregate
	// notifications). Default: `NONE`.
	AggregationDuration pulumi.StringPtrInput
	// Description of the NotificationConfiguration. Length constraints: Minimum length of 0,
	// maximum length of 256.
	Description pulumi.StringInput
	// Name of the NotificationConfiguration. Supports RFC 3986's unreserved characters. Length
	// constraints: Minimum length of 1, maximum length of 64. Pattern: `[A-Za-z0-9_\-]+`.
	//
	// The following arguments are optional:
	Name pulumi.StringPtrInput
	// Map of tags to assign to the resource. A tag is a string-to-string map of key-value pairs. If
	// configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those
	// defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (NotificationConfigurationArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*notificationConfigurationArgs)(nil)).Elem()
}

type NotificationConfigurationInput interface {
	pulumi.Input

	ToNotificationConfigurationOutput() NotificationConfigurationOutput
	ToNotificationConfigurationOutputWithContext(ctx context.Context) NotificationConfigurationOutput
}

func (*NotificationConfiguration) ElementType() reflect.Type {
	return reflect.TypeOf((**NotificationConfiguration)(nil)).Elem()
}

func (i *NotificationConfiguration) ToNotificationConfigurationOutput() NotificationConfigurationOutput {
	return i.ToNotificationConfigurationOutputWithContext(context.Background())
}

func (i *NotificationConfiguration) ToNotificationConfigurationOutputWithContext(ctx context.Context) NotificationConfigurationOutput {
	return pulumi.ToOutputWithContext(ctx, i).(NotificationConfigurationOutput)
}

// NotificationConfigurationArrayInput is an input type that accepts NotificationConfigurationArray and NotificationConfigurationArrayOutput values.
// You can construct a concrete instance of `NotificationConfigurationArrayInput` via:
//
//	NotificationConfigurationArray{ NotificationConfigurationArgs{...} }
type NotificationConfigurationArrayInput interface {
	pulumi.Input

	ToNotificationConfigurationArrayOutput() NotificationConfigurationArrayOutput
	ToNotificationConfigurationArrayOutputWithContext(context.Context) NotificationConfigurationArrayOutput
}

type NotificationConfigurationArray []NotificationConfigurationInput

func (NotificationConfigurationArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*NotificationConfiguration)(nil)).Elem()
}

func (i NotificationConfigurationArray) ToNotificationConfigurationArrayOutput() NotificationConfigurationArrayOutput {
	return i.ToNotificationConfigurationArrayOutputWithContext(context.Background())
}

func (i NotificationConfigurationArray) ToNotificationConfigurationArrayOutputWithContext(ctx context.Context) NotificationConfigurationArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(NotificationConfigurationArrayOutput)
}

// NotificationConfigurationMapInput is an input type that accepts NotificationConfigurationMap and NotificationConfigurationMapOutput values.
// You can construct a concrete instance of `NotificationConfigurationMapInput` via:
//
//	NotificationConfigurationMap{ "key": NotificationConfigurationArgs{...} }
type NotificationConfigurationMapInput interface {
	pulumi.Input

	ToNotificationConfigurationMapOutput() NotificationConfigurationMapOutput
	ToNotificationConfigurationMapOutputWithContext(context.Context) NotificationConfigurationMapOutput
}

type NotificationConfigurationMap map[string]NotificationConfigurationInput

func (NotificationConfigurationMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*NotificationConfiguration)(nil)).Elem()
}

func (i NotificationConfigurationMap) ToNotificationConfigurationMapOutput() NotificationConfigurationMapOutput {
	return i.ToNotificationConfigurationMapOutputWithContext(context.Background())
}

func (i NotificationConfigurationMap) ToNotificationConfigurationMapOutputWithContext(ctx context.Context) NotificationConfigurationMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(NotificationConfigurationMapOutput)
}

type NotificationConfigurationOutput struct{ *pulumi.OutputState }

func (NotificationConfigurationOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**NotificationConfiguration)(nil)).Elem()
}

func (o NotificationConfigurationOutput) ToNotificationConfigurationOutput() NotificationConfigurationOutput {
	return o
}

func (o NotificationConfigurationOutput) ToNotificationConfigurationOutputWithContext(ctx context.Context) NotificationConfigurationOutput {
	return o
}

// Aggregation preference of the NotificationConfiguration. Valid values: `LONG` (
// aggregate notifications for 12 hours), `SHORT` (aggregate notifications for 5 minutes), `NONE` (don't aggregate
// notifications). Default: `NONE`.
func (o NotificationConfigurationOutput) AggregationDuration() pulumi.StringOutput {
	return o.ApplyT(func(v *NotificationConfiguration) pulumi.StringOutput { return v.AggregationDuration }).(pulumi.StringOutput)
}

// Amazon Resource Name (ARN) of the NotificationConfiguration.
func (o NotificationConfigurationOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *NotificationConfiguration) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Description of the NotificationConfiguration. Length constraints: Minimum length of 0,
// maximum length of 256.
func (o NotificationConfigurationOutput) Description() pulumi.StringOutput {
	return o.ApplyT(func(v *NotificationConfiguration) pulumi.StringOutput { return v.Description }).(pulumi.StringOutput)
}

// Name of the NotificationConfiguration. Supports RFC 3986's unreserved characters. Length
// constraints: Minimum length of 1, maximum length of 64. Pattern: `[A-Za-z0-9_\-]+`.
//
// The following arguments are optional:
func (o NotificationConfigurationOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *NotificationConfiguration) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// Map of tags to assign to the resource. A tag is a string-to-string map of key-value pairs. If
// configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those
// defined at the provider-level.
func (o NotificationConfigurationOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *NotificationConfiguration) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Map of tags assigned to the resource, including those inherited from the provider `defaultTags`
// configuration block.
//
// Deprecated: Please use `tags` instead.
func (o NotificationConfigurationOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *NotificationConfiguration) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type NotificationConfigurationArrayOutput struct{ *pulumi.OutputState }

func (NotificationConfigurationArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*NotificationConfiguration)(nil)).Elem()
}

func (o NotificationConfigurationArrayOutput) ToNotificationConfigurationArrayOutput() NotificationConfigurationArrayOutput {
	return o
}

func (o NotificationConfigurationArrayOutput) ToNotificationConfigurationArrayOutputWithContext(ctx context.Context) NotificationConfigurationArrayOutput {
	return o
}

func (o NotificationConfigurationArrayOutput) Index(i pulumi.IntInput) NotificationConfigurationOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *NotificationConfiguration {
		return vs[0].([]*NotificationConfiguration)[vs[1].(int)]
	}).(NotificationConfigurationOutput)
}

type NotificationConfigurationMapOutput struct{ *pulumi.OutputState }

func (NotificationConfigurationMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*NotificationConfiguration)(nil)).Elem()
}

func (o NotificationConfigurationMapOutput) ToNotificationConfigurationMapOutput() NotificationConfigurationMapOutput {
	return o
}

func (o NotificationConfigurationMapOutput) ToNotificationConfigurationMapOutputWithContext(ctx context.Context) NotificationConfigurationMapOutput {
	return o
}

func (o NotificationConfigurationMapOutput) MapIndex(k pulumi.StringInput) NotificationConfigurationOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *NotificationConfiguration {
		return vs[0].(map[string]*NotificationConfiguration)[vs[1].(string)]
	}).(NotificationConfigurationOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*NotificationConfigurationInput)(nil)).Elem(), &NotificationConfiguration{})
	pulumi.RegisterInputType(reflect.TypeOf((*NotificationConfigurationArrayInput)(nil)).Elem(), NotificationConfigurationArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*NotificationConfigurationMapInput)(nil)).Elem(), NotificationConfigurationMap{})
	pulumi.RegisterOutputType(NotificationConfigurationOutput{})
	pulumi.RegisterOutputType(NotificationConfigurationArrayOutput{})
	pulumi.RegisterOutputType(NotificationConfigurationMapOutput{})
}
