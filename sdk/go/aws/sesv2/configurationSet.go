// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package sesv2

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS SESv2 (Simple Email V2) Configuration Set.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/sesv2"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := sesv2.NewConfigurationSet(ctx, "example", &sesv2.ConfigurationSetArgs{
//				ConfigurationSetName: pulumi.String("example"),
//				DeliveryOptions: &sesv2.ConfigurationSetDeliveryOptionsArgs{
//					MaxDeliverySeconds: pulumi.Int(300),
//					TlsPolicy:          pulumi.String("REQUIRE"),
//				},
//				ReputationOptions: &sesv2.ConfigurationSetReputationOptionsArgs{
//					ReputationMetricsEnabled: pulumi.Bool(false),
//				},
//				SendingOptions: &sesv2.ConfigurationSetSendingOptionsArgs{
//					SendingEnabled: pulumi.Bool(true),
//				},
//				SuppressionOptions: &sesv2.ConfigurationSetSuppressionOptionsArgs{
//					SuppressedReasons: pulumi.StringArray{
//						pulumi.String("BOUNCE"),
//						pulumi.String("COMPLAINT"),
//					},
//				},
//				TrackingOptions: &sesv2.ConfigurationSetTrackingOptionsArgs{
//					CustomRedirectDomain: pulumi.String("example.com"),
//					HttpsPolicy:          pulumi.String("REQUIRE"),
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
// Using `pulumi import`, import SESv2 (Simple Email V2) Configuration Set using the `configuration_set_name`. For example:
//
// ```sh
// $ pulumi import aws:sesv2/configurationSet:ConfigurationSet example example
// ```
type ConfigurationSet struct {
	pulumi.CustomResourceState

	// ARN of the Configuration Set.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// The name of the configuration set.
	ConfigurationSetName pulumi.StringOutput `pulumi:"configurationSetName"`
	// An object that defines the dedicated IP pool that is used to send emails that you send using the configuration set. See `deliveryOptions` Block for details.
	DeliveryOptions ConfigurationSetDeliveryOptionsPtrOutput `pulumi:"deliveryOptions"`
	// An object that defines whether or not Amazon SES collects reputation metrics for the emails that you send that use the configuration set. See `reputationOptions` Block for details.
	ReputationOptions ConfigurationSetReputationOptionsOutput `pulumi:"reputationOptions"`
	// An object that defines whether or not Amazon SES can send email that you send using the configuration set. See `sendingOptions` Block for details.
	SendingOptions ConfigurationSetSendingOptionsOutput `pulumi:"sendingOptions"`
	// An object that contains information about the suppression list preferences for your account. See `suppressionOptions` Block for details.
	SuppressionOptions ConfigurationSetSuppressionOptionsPtrOutput `pulumi:"suppressionOptions"`
	// A map of tags to assign to the service. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	// An object that defines the open and click tracking options for emails that you send using the configuration set. See `trackingOptions` Block for details.
	TrackingOptions ConfigurationSetTrackingOptionsPtrOutput `pulumi:"trackingOptions"`
	// An object that defines the VDM settings that apply to emails that you send using the configuration set. See `vdmOptions` Block for details.
	VdmOptions ConfigurationSetVdmOptionsPtrOutput `pulumi:"vdmOptions"`
}

// NewConfigurationSet registers a new resource with the given unique name, arguments, and options.
func NewConfigurationSet(ctx *pulumi.Context,
	name string, args *ConfigurationSetArgs, opts ...pulumi.ResourceOption) (*ConfigurationSet, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.ConfigurationSetName == nil {
		return nil, errors.New("invalid value for required argument 'ConfigurationSetName'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource ConfigurationSet
	err := ctx.RegisterResource("aws:sesv2/configurationSet:ConfigurationSet", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetConfigurationSet gets an existing ConfigurationSet resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetConfigurationSet(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ConfigurationSetState, opts ...pulumi.ResourceOption) (*ConfigurationSet, error) {
	var resource ConfigurationSet
	err := ctx.ReadResource("aws:sesv2/configurationSet:ConfigurationSet", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering ConfigurationSet resources.
type configurationSetState struct {
	// ARN of the Configuration Set.
	Arn *string `pulumi:"arn"`
	// The name of the configuration set.
	ConfigurationSetName *string `pulumi:"configurationSetName"`
	// An object that defines the dedicated IP pool that is used to send emails that you send using the configuration set. See `deliveryOptions` Block for details.
	DeliveryOptions *ConfigurationSetDeliveryOptions `pulumi:"deliveryOptions"`
	// An object that defines whether or not Amazon SES collects reputation metrics for the emails that you send that use the configuration set. See `reputationOptions` Block for details.
	ReputationOptions *ConfigurationSetReputationOptions `pulumi:"reputationOptions"`
	// An object that defines whether or not Amazon SES can send email that you send using the configuration set. See `sendingOptions` Block for details.
	SendingOptions *ConfigurationSetSendingOptions `pulumi:"sendingOptions"`
	// An object that contains information about the suppression list preferences for your account. See `suppressionOptions` Block for details.
	SuppressionOptions *ConfigurationSetSuppressionOptions `pulumi:"suppressionOptions"`
	// A map of tags to assign to the service. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	// An object that defines the open and click tracking options for emails that you send using the configuration set. See `trackingOptions` Block for details.
	TrackingOptions *ConfigurationSetTrackingOptions `pulumi:"trackingOptions"`
	// An object that defines the VDM settings that apply to emails that you send using the configuration set. See `vdmOptions` Block for details.
	VdmOptions *ConfigurationSetVdmOptions `pulumi:"vdmOptions"`
}

type ConfigurationSetState struct {
	// ARN of the Configuration Set.
	Arn pulumi.StringPtrInput
	// The name of the configuration set.
	ConfigurationSetName pulumi.StringPtrInput
	// An object that defines the dedicated IP pool that is used to send emails that you send using the configuration set. See `deliveryOptions` Block for details.
	DeliveryOptions ConfigurationSetDeliveryOptionsPtrInput
	// An object that defines whether or not Amazon SES collects reputation metrics for the emails that you send that use the configuration set. See `reputationOptions` Block for details.
	ReputationOptions ConfigurationSetReputationOptionsPtrInput
	// An object that defines whether or not Amazon SES can send email that you send using the configuration set. See `sendingOptions` Block for details.
	SendingOptions ConfigurationSetSendingOptionsPtrInput
	// An object that contains information about the suppression list preferences for your account. See `suppressionOptions` Block for details.
	SuppressionOptions ConfigurationSetSuppressionOptionsPtrInput
	// A map of tags to assign to the service. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	// An object that defines the open and click tracking options for emails that you send using the configuration set. See `trackingOptions` Block for details.
	TrackingOptions ConfigurationSetTrackingOptionsPtrInput
	// An object that defines the VDM settings that apply to emails that you send using the configuration set. See `vdmOptions` Block for details.
	VdmOptions ConfigurationSetVdmOptionsPtrInput
}

func (ConfigurationSetState) ElementType() reflect.Type {
	return reflect.TypeOf((*configurationSetState)(nil)).Elem()
}

type configurationSetArgs struct {
	// The name of the configuration set.
	ConfigurationSetName string `pulumi:"configurationSetName"`
	// An object that defines the dedicated IP pool that is used to send emails that you send using the configuration set. See `deliveryOptions` Block for details.
	DeliveryOptions *ConfigurationSetDeliveryOptions `pulumi:"deliveryOptions"`
	// An object that defines whether or not Amazon SES collects reputation metrics for the emails that you send that use the configuration set. See `reputationOptions` Block for details.
	ReputationOptions *ConfigurationSetReputationOptions `pulumi:"reputationOptions"`
	// An object that defines whether or not Amazon SES can send email that you send using the configuration set. See `sendingOptions` Block for details.
	SendingOptions *ConfigurationSetSendingOptions `pulumi:"sendingOptions"`
	// An object that contains information about the suppression list preferences for your account. See `suppressionOptions` Block for details.
	SuppressionOptions *ConfigurationSetSuppressionOptions `pulumi:"suppressionOptions"`
	// A map of tags to assign to the service. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// An object that defines the open and click tracking options for emails that you send using the configuration set. See `trackingOptions` Block for details.
	TrackingOptions *ConfigurationSetTrackingOptions `pulumi:"trackingOptions"`
	// An object that defines the VDM settings that apply to emails that you send using the configuration set. See `vdmOptions` Block for details.
	VdmOptions *ConfigurationSetVdmOptions `pulumi:"vdmOptions"`
}

// The set of arguments for constructing a ConfigurationSet resource.
type ConfigurationSetArgs struct {
	// The name of the configuration set.
	ConfigurationSetName pulumi.StringInput
	// An object that defines the dedicated IP pool that is used to send emails that you send using the configuration set. See `deliveryOptions` Block for details.
	DeliveryOptions ConfigurationSetDeliveryOptionsPtrInput
	// An object that defines whether or not Amazon SES collects reputation metrics for the emails that you send that use the configuration set. See `reputationOptions` Block for details.
	ReputationOptions ConfigurationSetReputationOptionsPtrInput
	// An object that defines whether or not Amazon SES can send email that you send using the configuration set. See `sendingOptions` Block for details.
	SendingOptions ConfigurationSetSendingOptionsPtrInput
	// An object that contains information about the suppression list preferences for your account. See `suppressionOptions` Block for details.
	SuppressionOptions ConfigurationSetSuppressionOptionsPtrInput
	// A map of tags to assign to the service. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// An object that defines the open and click tracking options for emails that you send using the configuration set. See `trackingOptions` Block for details.
	TrackingOptions ConfigurationSetTrackingOptionsPtrInput
	// An object that defines the VDM settings that apply to emails that you send using the configuration set. See `vdmOptions` Block for details.
	VdmOptions ConfigurationSetVdmOptionsPtrInput
}

func (ConfigurationSetArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*configurationSetArgs)(nil)).Elem()
}

type ConfigurationSetInput interface {
	pulumi.Input

	ToConfigurationSetOutput() ConfigurationSetOutput
	ToConfigurationSetOutputWithContext(ctx context.Context) ConfigurationSetOutput
}

func (*ConfigurationSet) ElementType() reflect.Type {
	return reflect.TypeOf((**ConfigurationSet)(nil)).Elem()
}

func (i *ConfigurationSet) ToConfigurationSetOutput() ConfigurationSetOutput {
	return i.ToConfigurationSetOutputWithContext(context.Background())
}

func (i *ConfigurationSet) ToConfigurationSetOutputWithContext(ctx context.Context) ConfigurationSetOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ConfigurationSetOutput)
}

// ConfigurationSetArrayInput is an input type that accepts ConfigurationSetArray and ConfigurationSetArrayOutput values.
// You can construct a concrete instance of `ConfigurationSetArrayInput` via:
//
//	ConfigurationSetArray{ ConfigurationSetArgs{...} }
type ConfigurationSetArrayInput interface {
	pulumi.Input

	ToConfigurationSetArrayOutput() ConfigurationSetArrayOutput
	ToConfigurationSetArrayOutputWithContext(context.Context) ConfigurationSetArrayOutput
}

type ConfigurationSetArray []ConfigurationSetInput

func (ConfigurationSetArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ConfigurationSet)(nil)).Elem()
}

func (i ConfigurationSetArray) ToConfigurationSetArrayOutput() ConfigurationSetArrayOutput {
	return i.ToConfigurationSetArrayOutputWithContext(context.Background())
}

func (i ConfigurationSetArray) ToConfigurationSetArrayOutputWithContext(ctx context.Context) ConfigurationSetArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ConfigurationSetArrayOutput)
}

// ConfigurationSetMapInput is an input type that accepts ConfigurationSetMap and ConfigurationSetMapOutput values.
// You can construct a concrete instance of `ConfigurationSetMapInput` via:
//
//	ConfigurationSetMap{ "key": ConfigurationSetArgs{...} }
type ConfigurationSetMapInput interface {
	pulumi.Input

	ToConfigurationSetMapOutput() ConfigurationSetMapOutput
	ToConfigurationSetMapOutputWithContext(context.Context) ConfigurationSetMapOutput
}

type ConfigurationSetMap map[string]ConfigurationSetInput

func (ConfigurationSetMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ConfigurationSet)(nil)).Elem()
}

func (i ConfigurationSetMap) ToConfigurationSetMapOutput() ConfigurationSetMapOutput {
	return i.ToConfigurationSetMapOutputWithContext(context.Background())
}

func (i ConfigurationSetMap) ToConfigurationSetMapOutputWithContext(ctx context.Context) ConfigurationSetMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ConfigurationSetMapOutput)
}

type ConfigurationSetOutput struct{ *pulumi.OutputState }

func (ConfigurationSetOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**ConfigurationSet)(nil)).Elem()
}

func (o ConfigurationSetOutput) ToConfigurationSetOutput() ConfigurationSetOutput {
	return o
}

func (o ConfigurationSetOutput) ToConfigurationSetOutputWithContext(ctx context.Context) ConfigurationSetOutput {
	return o
}

// ARN of the Configuration Set.
func (o ConfigurationSetOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *ConfigurationSet) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// The name of the configuration set.
func (o ConfigurationSetOutput) ConfigurationSetName() pulumi.StringOutput {
	return o.ApplyT(func(v *ConfigurationSet) pulumi.StringOutput { return v.ConfigurationSetName }).(pulumi.StringOutput)
}

// An object that defines the dedicated IP pool that is used to send emails that you send using the configuration set. See `deliveryOptions` Block for details.
func (o ConfigurationSetOutput) DeliveryOptions() ConfigurationSetDeliveryOptionsPtrOutput {
	return o.ApplyT(func(v *ConfigurationSet) ConfigurationSetDeliveryOptionsPtrOutput { return v.DeliveryOptions }).(ConfigurationSetDeliveryOptionsPtrOutput)
}

// An object that defines whether or not Amazon SES collects reputation metrics for the emails that you send that use the configuration set. See `reputationOptions` Block for details.
func (o ConfigurationSetOutput) ReputationOptions() ConfigurationSetReputationOptionsOutput {
	return o.ApplyT(func(v *ConfigurationSet) ConfigurationSetReputationOptionsOutput { return v.ReputationOptions }).(ConfigurationSetReputationOptionsOutput)
}

// An object that defines whether or not Amazon SES can send email that you send using the configuration set. See `sendingOptions` Block for details.
func (o ConfigurationSetOutput) SendingOptions() ConfigurationSetSendingOptionsOutput {
	return o.ApplyT(func(v *ConfigurationSet) ConfigurationSetSendingOptionsOutput { return v.SendingOptions }).(ConfigurationSetSendingOptionsOutput)
}

// An object that contains information about the suppression list preferences for your account. See `suppressionOptions` Block for details.
func (o ConfigurationSetOutput) SuppressionOptions() ConfigurationSetSuppressionOptionsPtrOutput {
	return o.ApplyT(func(v *ConfigurationSet) ConfigurationSetSuppressionOptionsPtrOutput { return v.SuppressionOptions }).(ConfigurationSetSuppressionOptionsPtrOutput)
}

// A map of tags to assign to the service. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o ConfigurationSetOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *ConfigurationSet) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Deprecated: Please use `tags` instead.
func (o ConfigurationSetOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *ConfigurationSet) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

// An object that defines the open and click tracking options for emails that you send using the configuration set. See `trackingOptions` Block for details.
func (o ConfigurationSetOutput) TrackingOptions() ConfigurationSetTrackingOptionsPtrOutput {
	return o.ApplyT(func(v *ConfigurationSet) ConfigurationSetTrackingOptionsPtrOutput { return v.TrackingOptions }).(ConfigurationSetTrackingOptionsPtrOutput)
}

// An object that defines the VDM settings that apply to emails that you send using the configuration set. See `vdmOptions` Block for details.
func (o ConfigurationSetOutput) VdmOptions() ConfigurationSetVdmOptionsPtrOutput {
	return o.ApplyT(func(v *ConfigurationSet) ConfigurationSetVdmOptionsPtrOutput { return v.VdmOptions }).(ConfigurationSetVdmOptionsPtrOutput)
}

type ConfigurationSetArrayOutput struct{ *pulumi.OutputState }

func (ConfigurationSetArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ConfigurationSet)(nil)).Elem()
}

func (o ConfigurationSetArrayOutput) ToConfigurationSetArrayOutput() ConfigurationSetArrayOutput {
	return o
}

func (o ConfigurationSetArrayOutput) ToConfigurationSetArrayOutputWithContext(ctx context.Context) ConfigurationSetArrayOutput {
	return o
}

func (o ConfigurationSetArrayOutput) Index(i pulumi.IntInput) ConfigurationSetOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *ConfigurationSet {
		return vs[0].([]*ConfigurationSet)[vs[1].(int)]
	}).(ConfigurationSetOutput)
}

type ConfigurationSetMapOutput struct{ *pulumi.OutputState }

func (ConfigurationSetMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ConfigurationSet)(nil)).Elem()
}

func (o ConfigurationSetMapOutput) ToConfigurationSetMapOutput() ConfigurationSetMapOutput {
	return o
}

func (o ConfigurationSetMapOutput) ToConfigurationSetMapOutputWithContext(ctx context.Context) ConfigurationSetMapOutput {
	return o
}

func (o ConfigurationSetMapOutput) MapIndex(k pulumi.StringInput) ConfigurationSetOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *ConfigurationSet {
		return vs[0].(map[string]*ConfigurationSet)[vs[1].(string)]
	}).(ConfigurationSetOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ConfigurationSetInput)(nil)).Elem(), &ConfigurationSet{})
	pulumi.RegisterInputType(reflect.TypeOf((*ConfigurationSetArrayInput)(nil)).Elem(), ConfigurationSetArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ConfigurationSetMapInput)(nil)).Elem(), ConfigurationSetMap{})
	pulumi.RegisterOutputType(ConfigurationSetOutput{})
	pulumi.RegisterOutputType(ConfigurationSetArrayOutput{})
	pulumi.RegisterOutputType(ConfigurationSetMapOutput{})
}
