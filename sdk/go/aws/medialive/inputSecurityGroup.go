// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package medialive

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS MediaLive InputSecurityGroup.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/medialive"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := medialive.NewInputSecurityGroup(ctx, "example", &medialive.InputSecurityGroupArgs{
//				WhitelistRules: medialive.InputSecurityGroupWhitelistRuleArray{
//					&medialive.InputSecurityGroupWhitelistRuleArgs{
//						Cidr: pulumi.String("10.0.0.8/32"),
//					},
//				},
//				Tags: pulumi.StringMap{
//					"ENVIRONMENT": pulumi.String("prod"),
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
// Using `pulumi import`, import MediaLive InputSecurityGroup using the `id`. For example:
//
// ```sh
// $ pulumi import aws:medialive/inputSecurityGroup:InputSecurityGroup example 123456
// ```
type InputSecurityGroup struct {
	pulumi.CustomResourceState

	// ARN of the InputSecurityGroup.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// The list of inputs currently using this InputSecurityGroup.
	Inputs pulumi.StringArrayOutput `pulumi:"inputs"`
	// A map of tags to assign to the InputSecurityGroup. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	// Whitelist rules. See Whitelist Rules for more details.
	//
	// The following arguments are optional:
	WhitelistRules InputSecurityGroupWhitelistRuleArrayOutput `pulumi:"whitelistRules"`
}

// NewInputSecurityGroup registers a new resource with the given unique name, arguments, and options.
func NewInputSecurityGroup(ctx *pulumi.Context,
	name string, args *InputSecurityGroupArgs, opts ...pulumi.ResourceOption) (*InputSecurityGroup, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.WhitelistRules == nil {
		return nil, errors.New("invalid value for required argument 'WhitelistRules'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource InputSecurityGroup
	err := ctx.RegisterResource("aws:medialive/inputSecurityGroup:InputSecurityGroup", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetInputSecurityGroup gets an existing InputSecurityGroup resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetInputSecurityGroup(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *InputSecurityGroupState, opts ...pulumi.ResourceOption) (*InputSecurityGroup, error) {
	var resource InputSecurityGroup
	err := ctx.ReadResource("aws:medialive/inputSecurityGroup:InputSecurityGroup", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering InputSecurityGroup resources.
type inputSecurityGroupState struct {
	// ARN of the InputSecurityGroup.
	Arn *string `pulumi:"arn"`
	// The list of inputs currently using this InputSecurityGroup.
	Inputs []string `pulumi:"inputs"`
	// A map of tags to assign to the InputSecurityGroup. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	// Whitelist rules. See Whitelist Rules for more details.
	//
	// The following arguments are optional:
	WhitelistRules []InputSecurityGroupWhitelistRule `pulumi:"whitelistRules"`
}

type InputSecurityGroupState struct {
	// ARN of the InputSecurityGroup.
	Arn pulumi.StringPtrInput
	// The list of inputs currently using this InputSecurityGroup.
	Inputs pulumi.StringArrayInput
	// A map of tags to assign to the InputSecurityGroup. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	// Whitelist rules. See Whitelist Rules for more details.
	//
	// The following arguments are optional:
	WhitelistRules InputSecurityGroupWhitelistRuleArrayInput
}

func (InputSecurityGroupState) ElementType() reflect.Type {
	return reflect.TypeOf((*inputSecurityGroupState)(nil)).Elem()
}

type inputSecurityGroupArgs struct {
	// A map of tags to assign to the InputSecurityGroup. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Whitelist rules. See Whitelist Rules for more details.
	//
	// The following arguments are optional:
	WhitelistRules []InputSecurityGroupWhitelistRule `pulumi:"whitelistRules"`
}

// The set of arguments for constructing a InputSecurityGroup resource.
type InputSecurityGroupArgs struct {
	// A map of tags to assign to the InputSecurityGroup. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Whitelist rules. See Whitelist Rules for more details.
	//
	// The following arguments are optional:
	WhitelistRules InputSecurityGroupWhitelistRuleArrayInput
}

func (InputSecurityGroupArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*inputSecurityGroupArgs)(nil)).Elem()
}

type InputSecurityGroupInput interface {
	pulumi.Input

	ToInputSecurityGroupOutput() InputSecurityGroupOutput
	ToInputSecurityGroupOutputWithContext(ctx context.Context) InputSecurityGroupOutput
}

func (*InputSecurityGroup) ElementType() reflect.Type {
	return reflect.TypeOf((**InputSecurityGroup)(nil)).Elem()
}

func (i *InputSecurityGroup) ToInputSecurityGroupOutput() InputSecurityGroupOutput {
	return i.ToInputSecurityGroupOutputWithContext(context.Background())
}

func (i *InputSecurityGroup) ToInputSecurityGroupOutputWithContext(ctx context.Context) InputSecurityGroupOutput {
	return pulumi.ToOutputWithContext(ctx, i).(InputSecurityGroupOutput)
}

// InputSecurityGroupArrayInput is an input type that accepts InputSecurityGroupArray and InputSecurityGroupArrayOutput values.
// You can construct a concrete instance of `InputSecurityGroupArrayInput` via:
//
//	InputSecurityGroupArray{ InputSecurityGroupArgs{...} }
type InputSecurityGroupArrayInput interface {
	pulumi.Input

	ToInputSecurityGroupArrayOutput() InputSecurityGroupArrayOutput
	ToInputSecurityGroupArrayOutputWithContext(context.Context) InputSecurityGroupArrayOutput
}

type InputSecurityGroupArray []InputSecurityGroupInput

func (InputSecurityGroupArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*InputSecurityGroup)(nil)).Elem()
}

func (i InputSecurityGroupArray) ToInputSecurityGroupArrayOutput() InputSecurityGroupArrayOutput {
	return i.ToInputSecurityGroupArrayOutputWithContext(context.Background())
}

func (i InputSecurityGroupArray) ToInputSecurityGroupArrayOutputWithContext(ctx context.Context) InputSecurityGroupArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(InputSecurityGroupArrayOutput)
}

// InputSecurityGroupMapInput is an input type that accepts InputSecurityGroupMap and InputSecurityGroupMapOutput values.
// You can construct a concrete instance of `InputSecurityGroupMapInput` via:
//
//	InputSecurityGroupMap{ "key": InputSecurityGroupArgs{...} }
type InputSecurityGroupMapInput interface {
	pulumi.Input

	ToInputSecurityGroupMapOutput() InputSecurityGroupMapOutput
	ToInputSecurityGroupMapOutputWithContext(context.Context) InputSecurityGroupMapOutput
}

type InputSecurityGroupMap map[string]InputSecurityGroupInput

func (InputSecurityGroupMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*InputSecurityGroup)(nil)).Elem()
}

func (i InputSecurityGroupMap) ToInputSecurityGroupMapOutput() InputSecurityGroupMapOutput {
	return i.ToInputSecurityGroupMapOutputWithContext(context.Background())
}

func (i InputSecurityGroupMap) ToInputSecurityGroupMapOutputWithContext(ctx context.Context) InputSecurityGroupMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(InputSecurityGroupMapOutput)
}

type InputSecurityGroupOutput struct{ *pulumi.OutputState }

func (InputSecurityGroupOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**InputSecurityGroup)(nil)).Elem()
}

func (o InputSecurityGroupOutput) ToInputSecurityGroupOutput() InputSecurityGroupOutput {
	return o
}

func (o InputSecurityGroupOutput) ToInputSecurityGroupOutputWithContext(ctx context.Context) InputSecurityGroupOutput {
	return o
}

// ARN of the InputSecurityGroup.
func (o InputSecurityGroupOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *InputSecurityGroup) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// The list of inputs currently using this InputSecurityGroup.
func (o InputSecurityGroupOutput) Inputs() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *InputSecurityGroup) pulumi.StringArrayOutput { return v.Inputs }).(pulumi.StringArrayOutput)
}

// A map of tags to assign to the InputSecurityGroup. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o InputSecurityGroupOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *InputSecurityGroup) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Deprecated: Please use `tags` instead.
func (o InputSecurityGroupOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *InputSecurityGroup) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

// Whitelist rules. See Whitelist Rules for more details.
//
// The following arguments are optional:
func (o InputSecurityGroupOutput) WhitelistRules() InputSecurityGroupWhitelistRuleArrayOutput {
	return o.ApplyT(func(v *InputSecurityGroup) InputSecurityGroupWhitelistRuleArrayOutput { return v.WhitelistRules }).(InputSecurityGroupWhitelistRuleArrayOutput)
}

type InputSecurityGroupArrayOutput struct{ *pulumi.OutputState }

func (InputSecurityGroupArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*InputSecurityGroup)(nil)).Elem()
}

func (o InputSecurityGroupArrayOutput) ToInputSecurityGroupArrayOutput() InputSecurityGroupArrayOutput {
	return o
}

func (o InputSecurityGroupArrayOutput) ToInputSecurityGroupArrayOutputWithContext(ctx context.Context) InputSecurityGroupArrayOutput {
	return o
}

func (o InputSecurityGroupArrayOutput) Index(i pulumi.IntInput) InputSecurityGroupOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *InputSecurityGroup {
		return vs[0].([]*InputSecurityGroup)[vs[1].(int)]
	}).(InputSecurityGroupOutput)
}

type InputSecurityGroupMapOutput struct{ *pulumi.OutputState }

func (InputSecurityGroupMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*InputSecurityGroup)(nil)).Elem()
}

func (o InputSecurityGroupMapOutput) ToInputSecurityGroupMapOutput() InputSecurityGroupMapOutput {
	return o
}

func (o InputSecurityGroupMapOutput) ToInputSecurityGroupMapOutputWithContext(ctx context.Context) InputSecurityGroupMapOutput {
	return o
}

func (o InputSecurityGroupMapOutput) MapIndex(k pulumi.StringInput) InputSecurityGroupOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *InputSecurityGroup {
		return vs[0].(map[string]*InputSecurityGroup)[vs[1].(string)]
	}).(InputSecurityGroupOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*InputSecurityGroupInput)(nil)).Elem(), &InputSecurityGroup{})
	pulumi.RegisterInputType(reflect.TypeOf((*InputSecurityGroupArrayInput)(nil)).Elem(), InputSecurityGroupArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*InputSecurityGroupMapInput)(nil)).Elem(), InputSecurityGroupMap{})
	pulumi.RegisterOutputType(InputSecurityGroupOutput{})
	pulumi.RegisterOutputType(InputSecurityGroupArrayOutput{})
	pulumi.RegisterOutputType(InputSecurityGroupMapOutput{})
}
