// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package connect

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides an Amazon Connect Quick Connect resource. For more information see
// [Amazon Connect: Getting Started](https://docs.aws.amazon.com/connect/latest/adminguide/amazon-connect-get-started.html)
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/connect"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := connect.NewQuickConnect(ctx, "test", &connect.QuickConnectArgs{
//				InstanceId:  pulumi.String("aaaaaaaa-bbbb-cccc-dddd-111111111111"),
//				Name:        pulumi.String("Example Name"),
//				Description: pulumi.String("quick connect phone number"),
//				QuickConnectConfig: &connect.QuickConnectQuickConnectConfigArgs{
//					QuickConnectType: pulumi.String("PHONE_NUMBER"),
//					PhoneConfigs: connect.QuickConnectQuickConnectConfigPhoneConfigArray{
//						&connect.QuickConnectQuickConnectConfigPhoneConfigArgs{
//							PhoneNumber: pulumi.String("+12345678912"),
//						},
//					},
//				},
//				Tags: pulumi.StringMap{
//					"Name": pulumi.String("Example Quick Connect"),
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
// Using `pulumi import`, import Amazon Connect Quick Connects using the `instance_id` and `quick_connect_id` separated by a colon (`:`). For example:
//
// ```sh
// $ pulumi import aws:connect/quickConnect:QuickConnect example f1288a1f-6193-445a-b47e-af739b2:c1d4e5f6-1b3c-1b3c-1b3c-c1d4e5f6c1d4e5
// ```
type QuickConnect struct {
	pulumi.CustomResourceState

	// The Amazon Resource Name (ARN) of the Quick Connect.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Specifies the description of the Quick Connect.
	Description pulumi.StringPtrOutput `pulumi:"description"`
	// Specifies the identifier of the hosting Amazon Connect Instance.
	InstanceId pulumi.StringOutput `pulumi:"instanceId"`
	// Specifies the name of the Quick Connect.
	Name pulumi.StringOutput `pulumi:"name"`
	// A block that defines the configuration information for the Quick Connect: `quickConnectType` and one of `phoneConfig`, `queueConfig`, `userConfig` . The Quick Connect Config block is documented below.
	QuickConnectConfig QuickConnectQuickConnectConfigOutput `pulumi:"quickConnectConfig"`
	// The identifier for the Quick Connect.
	QuickConnectId pulumi.StringOutput `pulumi:"quickConnectId"`
	// Tags to apply to the Quick Connect. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewQuickConnect registers a new resource with the given unique name, arguments, and options.
func NewQuickConnect(ctx *pulumi.Context,
	name string, args *QuickConnectArgs, opts ...pulumi.ResourceOption) (*QuickConnect, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.InstanceId == nil {
		return nil, errors.New("invalid value for required argument 'InstanceId'")
	}
	if args.QuickConnectConfig == nil {
		return nil, errors.New("invalid value for required argument 'QuickConnectConfig'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource QuickConnect
	err := ctx.RegisterResource("aws:connect/quickConnect:QuickConnect", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetQuickConnect gets an existing QuickConnect resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetQuickConnect(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *QuickConnectState, opts ...pulumi.ResourceOption) (*QuickConnect, error) {
	var resource QuickConnect
	err := ctx.ReadResource("aws:connect/quickConnect:QuickConnect", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering QuickConnect resources.
type quickConnectState struct {
	// The Amazon Resource Name (ARN) of the Quick Connect.
	Arn *string `pulumi:"arn"`
	// Specifies the description of the Quick Connect.
	Description *string `pulumi:"description"`
	// Specifies the identifier of the hosting Amazon Connect Instance.
	InstanceId *string `pulumi:"instanceId"`
	// Specifies the name of the Quick Connect.
	Name *string `pulumi:"name"`
	// A block that defines the configuration information for the Quick Connect: `quickConnectType` and one of `phoneConfig`, `queueConfig`, `userConfig` . The Quick Connect Config block is documented below.
	QuickConnectConfig *QuickConnectQuickConnectConfig `pulumi:"quickConnectConfig"`
	// The identifier for the Quick Connect.
	QuickConnectId *string `pulumi:"quickConnectId"`
	// Tags to apply to the Quick Connect. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type QuickConnectState struct {
	// The Amazon Resource Name (ARN) of the Quick Connect.
	Arn pulumi.StringPtrInput
	// Specifies the description of the Quick Connect.
	Description pulumi.StringPtrInput
	// Specifies the identifier of the hosting Amazon Connect Instance.
	InstanceId pulumi.StringPtrInput
	// Specifies the name of the Quick Connect.
	Name pulumi.StringPtrInput
	// A block that defines the configuration information for the Quick Connect: `quickConnectType` and one of `phoneConfig`, `queueConfig`, `userConfig` . The Quick Connect Config block is documented below.
	QuickConnectConfig QuickConnectQuickConnectConfigPtrInput
	// The identifier for the Quick Connect.
	QuickConnectId pulumi.StringPtrInput
	// Tags to apply to the Quick Connect. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (QuickConnectState) ElementType() reflect.Type {
	return reflect.TypeOf((*quickConnectState)(nil)).Elem()
}

type quickConnectArgs struct {
	// Specifies the description of the Quick Connect.
	Description *string `pulumi:"description"`
	// Specifies the identifier of the hosting Amazon Connect Instance.
	InstanceId string `pulumi:"instanceId"`
	// Specifies the name of the Quick Connect.
	Name *string `pulumi:"name"`
	// A block that defines the configuration information for the Quick Connect: `quickConnectType` and one of `phoneConfig`, `queueConfig`, `userConfig` . The Quick Connect Config block is documented below.
	QuickConnectConfig QuickConnectQuickConnectConfig `pulumi:"quickConnectConfig"`
	// Tags to apply to the Quick Connect. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a QuickConnect resource.
type QuickConnectArgs struct {
	// Specifies the description of the Quick Connect.
	Description pulumi.StringPtrInput
	// Specifies the identifier of the hosting Amazon Connect Instance.
	InstanceId pulumi.StringInput
	// Specifies the name of the Quick Connect.
	Name pulumi.StringPtrInput
	// A block that defines the configuration information for the Quick Connect: `quickConnectType` and one of `phoneConfig`, `queueConfig`, `userConfig` . The Quick Connect Config block is documented below.
	QuickConnectConfig QuickConnectQuickConnectConfigInput
	// Tags to apply to the Quick Connect. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (QuickConnectArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*quickConnectArgs)(nil)).Elem()
}

type QuickConnectInput interface {
	pulumi.Input

	ToQuickConnectOutput() QuickConnectOutput
	ToQuickConnectOutputWithContext(ctx context.Context) QuickConnectOutput
}

func (*QuickConnect) ElementType() reflect.Type {
	return reflect.TypeOf((**QuickConnect)(nil)).Elem()
}

func (i *QuickConnect) ToQuickConnectOutput() QuickConnectOutput {
	return i.ToQuickConnectOutputWithContext(context.Background())
}

func (i *QuickConnect) ToQuickConnectOutputWithContext(ctx context.Context) QuickConnectOutput {
	return pulumi.ToOutputWithContext(ctx, i).(QuickConnectOutput)
}

// QuickConnectArrayInput is an input type that accepts QuickConnectArray and QuickConnectArrayOutput values.
// You can construct a concrete instance of `QuickConnectArrayInput` via:
//
//	QuickConnectArray{ QuickConnectArgs{...} }
type QuickConnectArrayInput interface {
	pulumi.Input

	ToQuickConnectArrayOutput() QuickConnectArrayOutput
	ToQuickConnectArrayOutputWithContext(context.Context) QuickConnectArrayOutput
}

type QuickConnectArray []QuickConnectInput

func (QuickConnectArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*QuickConnect)(nil)).Elem()
}

func (i QuickConnectArray) ToQuickConnectArrayOutput() QuickConnectArrayOutput {
	return i.ToQuickConnectArrayOutputWithContext(context.Background())
}

func (i QuickConnectArray) ToQuickConnectArrayOutputWithContext(ctx context.Context) QuickConnectArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(QuickConnectArrayOutput)
}

// QuickConnectMapInput is an input type that accepts QuickConnectMap and QuickConnectMapOutput values.
// You can construct a concrete instance of `QuickConnectMapInput` via:
//
//	QuickConnectMap{ "key": QuickConnectArgs{...} }
type QuickConnectMapInput interface {
	pulumi.Input

	ToQuickConnectMapOutput() QuickConnectMapOutput
	ToQuickConnectMapOutputWithContext(context.Context) QuickConnectMapOutput
}

type QuickConnectMap map[string]QuickConnectInput

func (QuickConnectMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*QuickConnect)(nil)).Elem()
}

func (i QuickConnectMap) ToQuickConnectMapOutput() QuickConnectMapOutput {
	return i.ToQuickConnectMapOutputWithContext(context.Background())
}

func (i QuickConnectMap) ToQuickConnectMapOutputWithContext(ctx context.Context) QuickConnectMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(QuickConnectMapOutput)
}

type QuickConnectOutput struct{ *pulumi.OutputState }

func (QuickConnectOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**QuickConnect)(nil)).Elem()
}

func (o QuickConnectOutput) ToQuickConnectOutput() QuickConnectOutput {
	return o
}

func (o QuickConnectOutput) ToQuickConnectOutputWithContext(ctx context.Context) QuickConnectOutput {
	return o
}

// The Amazon Resource Name (ARN) of the Quick Connect.
func (o QuickConnectOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *QuickConnect) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Specifies the description of the Quick Connect.
func (o QuickConnectOutput) Description() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *QuickConnect) pulumi.StringPtrOutput { return v.Description }).(pulumi.StringPtrOutput)
}

// Specifies the identifier of the hosting Amazon Connect Instance.
func (o QuickConnectOutput) InstanceId() pulumi.StringOutput {
	return o.ApplyT(func(v *QuickConnect) pulumi.StringOutput { return v.InstanceId }).(pulumi.StringOutput)
}

// Specifies the name of the Quick Connect.
func (o QuickConnectOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *QuickConnect) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// A block that defines the configuration information for the Quick Connect: `quickConnectType` and one of `phoneConfig`, `queueConfig`, `userConfig` . The Quick Connect Config block is documented below.
func (o QuickConnectOutput) QuickConnectConfig() QuickConnectQuickConnectConfigOutput {
	return o.ApplyT(func(v *QuickConnect) QuickConnectQuickConnectConfigOutput { return v.QuickConnectConfig }).(QuickConnectQuickConnectConfigOutput)
}

// The identifier for the Quick Connect.
func (o QuickConnectOutput) QuickConnectId() pulumi.StringOutput {
	return o.ApplyT(func(v *QuickConnect) pulumi.StringOutput { return v.QuickConnectId }).(pulumi.StringOutput)
}

// Tags to apply to the Quick Connect. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o QuickConnectOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *QuickConnect) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o QuickConnectOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *QuickConnect) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type QuickConnectArrayOutput struct{ *pulumi.OutputState }

func (QuickConnectArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*QuickConnect)(nil)).Elem()
}

func (o QuickConnectArrayOutput) ToQuickConnectArrayOutput() QuickConnectArrayOutput {
	return o
}

func (o QuickConnectArrayOutput) ToQuickConnectArrayOutputWithContext(ctx context.Context) QuickConnectArrayOutput {
	return o
}

func (o QuickConnectArrayOutput) Index(i pulumi.IntInput) QuickConnectOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *QuickConnect {
		return vs[0].([]*QuickConnect)[vs[1].(int)]
	}).(QuickConnectOutput)
}

type QuickConnectMapOutput struct{ *pulumi.OutputState }

func (QuickConnectMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*QuickConnect)(nil)).Elem()
}

func (o QuickConnectMapOutput) ToQuickConnectMapOutput() QuickConnectMapOutput {
	return o
}

func (o QuickConnectMapOutput) ToQuickConnectMapOutputWithContext(ctx context.Context) QuickConnectMapOutput {
	return o
}

func (o QuickConnectMapOutput) MapIndex(k pulumi.StringInput) QuickConnectOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *QuickConnect {
		return vs[0].(map[string]*QuickConnect)[vs[1].(string)]
	}).(QuickConnectOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*QuickConnectInput)(nil)).Elem(), &QuickConnect{})
	pulumi.RegisterInputType(reflect.TypeOf((*QuickConnectArrayInput)(nil)).Elem(), QuickConnectArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*QuickConnectMapInput)(nil)).Elem(), QuickConnectMap{})
	pulumi.RegisterOutputType(QuickConnectOutput{})
	pulumi.RegisterOutputType(QuickConnectArrayOutput{})
	pulumi.RegisterOutputType(QuickConnectMapOutput{})
}
