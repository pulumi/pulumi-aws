// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package lex

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// ## Import
//
// Using `pulumi import`, import Lex V2 Models Slot using the `id`. For example:
//
// ```sh
// $ pulumi import aws:lex/v2modelsSlot:V2modelsSlot example bot-1234,1,intent-5678,en-US,slot-9012
// ```
type V2modelsSlot struct {
	pulumi.CustomResourceState

	// Identifier of the bot associated with the slot.
	BotId pulumi.StringOutput `pulumi:"botId"`
	// Version of the bot associated with the slot.
	BotVersion pulumi.StringOutput `pulumi:"botVersion"`
	// Description of the slot.
	Description pulumi.StringPtrOutput `pulumi:"description"`
	// Identifier of the intent that contains the slot.
	IntentId pulumi.StringOutput `pulumi:"intentId"`
	// Identifier of the language and locale that the slot will be used in.
	LocaleId pulumi.StringOutput `pulumi:"localeId"`
	// Whether the slot returns multiple values in one response.
	// See the `multipleValuesSetting` argument reference below.
	MultipleValuesSettings V2modelsSlotMultipleValuesSettingArrayOutput `pulumi:"multipleValuesSettings"`
	// Name of the slot.
	Name pulumi.StringOutput `pulumi:"name"`
	// Determines how slot values are used in Amazon CloudWatch logs.
	// See the `obfuscationSetting` argument reference below.
	ObfuscationSettings V2modelsSlotObfuscationSettingArrayOutput `pulumi:"obfuscationSettings"`
	// Unique identifier associated with the slot.
	SlotId pulumi.StringOutput `pulumi:"slotId"`
	// Unique identifier for the slot type associated with this slot.
	SlotTypeId pulumi.StringOutput `pulumi:"slotTypeId"`
	// Specifications for the constituent sub slots and the expression for the composite slot.
	// See the `subSlotSetting` argument reference below.
	SubSlotSettings         V2modelsSlotSubSlotSettingArrayOutput        `pulumi:"subSlotSettings"`
	Timeouts                V2modelsSlotTimeoutsPtrOutput                `pulumi:"timeouts"`
	ValueElicitationSetting V2modelsSlotValueElicitationSettingPtrOutput `pulumi:"valueElicitationSetting"`
}

// NewV2modelsSlot registers a new resource with the given unique name, arguments, and options.
func NewV2modelsSlot(ctx *pulumi.Context,
	name string, args *V2modelsSlotArgs, opts ...pulumi.ResourceOption) (*V2modelsSlot, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.BotId == nil {
		return nil, errors.New("invalid value for required argument 'BotId'")
	}
	if args.BotVersion == nil {
		return nil, errors.New("invalid value for required argument 'BotVersion'")
	}
	if args.IntentId == nil {
		return nil, errors.New("invalid value for required argument 'IntentId'")
	}
	if args.LocaleId == nil {
		return nil, errors.New("invalid value for required argument 'LocaleId'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource V2modelsSlot
	err := ctx.RegisterResource("aws:lex/v2modelsSlot:V2modelsSlot", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetV2modelsSlot gets an existing V2modelsSlot resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetV2modelsSlot(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *V2modelsSlotState, opts ...pulumi.ResourceOption) (*V2modelsSlot, error) {
	var resource V2modelsSlot
	err := ctx.ReadResource("aws:lex/v2modelsSlot:V2modelsSlot", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering V2modelsSlot resources.
type v2modelsSlotState struct {
	// Identifier of the bot associated with the slot.
	BotId *string `pulumi:"botId"`
	// Version of the bot associated with the slot.
	BotVersion *string `pulumi:"botVersion"`
	// Description of the slot.
	Description *string `pulumi:"description"`
	// Identifier of the intent that contains the slot.
	IntentId *string `pulumi:"intentId"`
	// Identifier of the language and locale that the slot will be used in.
	LocaleId *string `pulumi:"localeId"`
	// Whether the slot returns multiple values in one response.
	// See the `multipleValuesSetting` argument reference below.
	MultipleValuesSettings []V2modelsSlotMultipleValuesSetting `pulumi:"multipleValuesSettings"`
	// Name of the slot.
	Name *string `pulumi:"name"`
	// Determines how slot values are used in Amazon CloudWatch logs.
	// See the `obfuscationSetting` argument reference below.
	ObfuscationSettings []V2modelsSlotObfuscationSetting `pulumi:"obfuscationSettings"`
	// Unique identifier associated with the slot.
	SlotId *string `pulumi:"slotId"`
	// Unique identifier for the slot type associated with this slot.
	SlotTypeId *string `pulumi:"slotTypeId"`
	// Specifications for the constituent sub slots and the expression for the composite slot.
	// See the `subSlotSetting` argument reference below.
	SubSlotSettings         []V2modelsSlotSubSlotSetting         `pulumi:"subSlotSettings"`
	Timeouts                *V2modelsSlotTimeouts                `pulumi:"timeouts"`
	ValueElicitationSetting *V2modelsSlotValueElicitationSetting `pulumi:"valueElicitationSetting"`
}

type V2modelsSlotState struct {
	// Identifier of the bot associated with the slot.
	BotId pulumi.StringPtrInput
	// Version of the bot associated with the slot.
	BotVersion pulumi.StringPtrInput
	// Description of the slot.
	Description pulumi.StringPtrInput
	// Identifier of the intent that contains the slot.
	IntentId pulumi.StringPtrInput
	// Identifier of the language and locale that the slot will be used in.
	LocaleId pulumi.StringPtrInput
	// Whether the slot returns multiple values in one response.
	// See the `multipleValuesSetting` argument reference below.
	MultipleValuesSettings V2modelsSlotMultipleValuesSettingArrayInput
	// Name of the slot.
	Name pulumi.StringPtrInput
	// Determines how slot values are used in Amazon CloudWatch logs.
	// See the `obfuscationSetting` argument reference below.
	ObfuscationSettings V2modelsSlotObfuscationSettingArrayInput
	// Unique identifier associated with the slot.
	SlotId pulumi.StringPtrInput
	// Unique identifier for the slot type associated with this slot.
	SlotTypeId pulumi.StringPtrInput
	// Specifications for the constituent sub slots and the expression for the composite slot.
	// See the `subSlotSetting` argument reference below.
	SubSlotSettings         V2modelsSlotSubSlotSettingArrayInput
	Timeouts                V2modelsSlotTimeoutsPtrInput
	ValueElicitationSetting V2modelsSlotValueElicitationSettingPtrInput
}

func (V2modelsSlotState) ElementType() reflect.Type {
	return reflect.TypeOf((*v2modelsSlotState)(nil)).Elem()
}

type v2modelsSlotArgs struct {
	// Identifier of the bot associated with the slot.
	BotId string `pulumi:"botId"`
	// Version of the bot associated with the slot.
	BotVersion string `pulumi:"botVersion"`
	// Description of the slot.
	Description *string `pulumi:"description"`
	// Identifier of the intent that contains the slot.
	IntentId string `pulumi:"intentId"`
	// Identifier of the language and locale that the slot will be used in.
	LocaleId string `pulumi:"localeId"`
	// Whether the slot returns multiple values in one response.
	// See the `multipleValuesSetting` argument reference below.
	MultipleValuesSettings []V2modelsSlotMultipleValuesSetting `pulumi:"multipleValuesSettings"`
	// Name of the slot.
	Name *string `pulumi:"name"`
	// Determines how slot values are used in Amazon CloudWatch logs.
	// See the `obfuscationSetting` argument reference below.
	ObfuscationSettings []V2modelsSlotObfuscationSetting `pulumi:"obfuscationSettings"`
	// Unique identifier for the slot type associated with this slot.
	SlotTypeId *string `pulumi:"slotTypeId"`
	// Specifications for the constituent sub slots and the expression for the composite slot.
	// See the `subSlotSetting` argument reference below.
	SubSlotSettings         []V2modelsSlotSubSlotSetting         `pulumi:"subSlotSettings"`
	Timeouts                *V2modelsSlotTimeouts                `pulumi:"timeouts"`
	ValueElicitationSetting *V2modelsSlotValueElicitationSetting `pulumi:"valueElicitationSetting"`
}

// The set of arguments for constructing a V2modelsSlot resource.
type V2modelsSlotArgs struct {
	// Identifier of the bot associated with the slot.
	BotId pulumi.StringInput
	// Version of the bot associated with the slot.
	BotVersion pulumi.StringInput
	// Description of the slot.
	Description pulumi.StringPtrInput
	// Identifier of the intent that contains the slot.
	IntentId pulumi.StringInput
	// Identifier of the language and locale that the slot will be used in.
	LocaleId pulumi.StringInput
	// Whether the slot returns multiple values in one response.
	// See the `multipleValuesSetting` argument reference below.
	MultipleValuesSettings V2modelsSlotMultipleValuesSettingArrayInput
	// Name of the slot.
	Name pulumi.StringPtrInput
	// Determines how slot values are used in Amazon CloudWatch logs.
	// See the `obfuscationSetting` argument reference below.
	ObfuscationSettings V2modelsSlotObfuscationSettingArrayInput
	// Unique identifier for the slot type associated with this slot.
	SlotTypeId pulumi.StringPtrInput
	// Specifications for the constituent sub slots and the expression for the composite slot.
	// See the `subSlotSetting` argument reference below.
	SubSlotSettings         V2modelsSlotSubSlotSettingArrayInput
	Timeouts                V2modelsSlotTimeoutsPtrInput
	ValueElicitationSetting V2modelsSlotValueElicitationSettingPtrInput
}

func (V2modelsSlotArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*v2modelsSlotArgs)(nil)).Elem()
}

type V2modelsSlotInput interface {
	pulumi.Input

	ToV2modelsSlotOutput() V2modelsSlotOutput
	ToV2modelsSlotOutputWithContext(ctx context.Context) V2modelsSlotOutput
}

func (*V2modelsSlot) ElementType() reflect.Type {
	return reflect.TypeOf((**V2modelsSlot)(nil)).Elem()
}

func (i *V2modelsSlot) ToV2modelsSlotOutput() V2modelsSlotOutput {
	return i.ToV2modelsSlotOutputWithContext(context.Background())
}

func (i *V2modelsSlot) ToV2modelsSlotOutputWithContext(ctx context.Context) V2modelsSlotOutput {
	return pulumi.ToOutputWithContext(ctx, i).(V2modelsSlotOutput)
}

// V2modelsSlotArrayInput is an input type that accepts V2modelsSlotArray and V2modelsSlotArrayOutput values.
// You can construct a concrete instance of `V2modelsSlotArrayInput` via:
//
//	V2modelsSlotArray{ V2modelsSlotArgs{...} }
type V2modelsSlotArrayInput interface {
	pulumi.Input

	ToV2modelsSlotArrayOutput() V2modelsSlotArrayOutput
	ToV2modelsSlotArrayOutputWithContext(context.Context) V2modelsSlotArrayOutput
}

type V2modelsSlotArray []V2modelsSlotInput

func (V2modelsSlotArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*V2modelsSlot)(nil)).Elem()
}

func (i V2modelsSlotArray) ToV2modelsSlotArrayOutput() V2modelsSlotArrayOutput {
	return i.ToV2modelsSlotArrayOutputWithContext(context.Background())
}

func (i V2modelsSlotArray) ToV2modelsSlotArrayOutputWithContext(ctx context.Context) V2modelsSlotArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(V2modelsSlotArrayOutput)
}

// V2modelsSlotMapInput is an input type that accepts V2modelsSlotMap and V2modelsSlotMapOutput values.
// You can construct a concrete instance of `V2modelsSlotMapInput` via:
//
//	V2modelsSlotMap{ "key": V2modelsSlotArgs{...} }
type V2modelsSlotMapInput interface {
	pulumi.Input

	ToV2modelsSlotMapOutput() V2modelsSlotMapOutput
	ToV2modelsSlotMapOutputWithContext(context.Context) V2modelsSlotMapOutput
}

type V2modelsSlotMap map[string]V2modelsSlotInput

func (V2modelsSlotMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*V2modelsSlot)(nil)).Elem()
}

func (i V2modelsSlotMap) ToV2modelsSlotMapOutput() V2modelsSlotMapOutput {
	return i.ToV2modelsSlotMapOutputWithContext(context.Background())
}

func (i V2modelsSlotMap) ToV2modelsSlotMapOutputWithContext(ctx context.Context) V2modelsSlotMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(V2modelsSlotMapOutput)
}

type V2modelsSlotOutput struct{ *pulumi.OutputState }

func (V2modelsSlotOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**V2modelsSlot)(nil)).Elem()
}

func (o V2modelsSlotOutput) ToV2modelsSlotOutput() V2modelsSlotOutput {
	return o
}

func (o V2modelsSlotOutput) ToV2modelsSlotOutputWithContext(ctx context.Context) V2modelsSlotOutput {
	return o
}

// Identifier of the bot associated with the slot.
func (o V2modelsSlotOutput) BotId() pulumi.StringOutput {
	return o.ApplyT(func(v *V2modelsSlot) pulumi.StringOutput { return v.BotId }).(pulumi.StringOutput)
}

// Version of the bot associated with the slot.
func (o V2modelsSlotOutput) BotVersion() pulumi.StringOutput {
	return o.ApplyT(func(v *V2modelsSlot) pulumi.StringOutput { return v.BotVersion }).(pulumi.StringOutput)
}

// Description of the slot.
func (o V2modelsSlotOutput) Description() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *V2modelsSlot) pulumi.StringPtrOutput { return v.Description }).(pulumi.StringPtrOutput)
}

// Identifier of the intent that contains the slot.
func (o V2modelsSlotOutput) IntentId() pulumi.StringOutput {
	return o.ApplyT(func(v *V2modelsSlot) pulumi.StringOutput { return v.IntentId }).(pulumi.StringOutput)
}

// Identifier of the language and locale that the slot will be used in.
func (o V2modelsSlotOutput) LocaleId() pulumi.StringOutput {
	return o.ApplyT(func(v *V2modelsSlot) pulumi.StringOutput { return v.LocaleId }).(pulumi.StringOutput)
}

// Whether the slot returns multiple values in one response.
// See the `multipleValuesSetting` argument reference below.
func (o V2modelsSlotOutput) MultipleValuesSettings() V2modelsSlotMultipleValuesSettingArrayOutput {
	return o.ApplyT(func(v *V2modelsSlot) V2modelsSlotMultipleValuesSettingArrayOutput { return v.MultipleValuesSettings }).(V2modelsSlotMultipleValuesSettingArrayOutput)
}

// Name of the slot.
func (o V2modelsSlotOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *V2modelsSlot) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// Determines how slot values are used in Amazon CloudWatch logs.
// See the `obfuscationSetting` argument reference below.
func (o V2modelsSlotOutput) ObfuscationSettings() V2modelsSlotObfuscationSettingArrayOutput {
	return o.ApplyT(func(v *V2modelsSlot) V2modelsSlotObfuscationSettingArrayOutput { return v.ObfuscationSettings }).(V2modelsSlotObfuscationSettingArrayOutput)
}

// Unique identifier associated with the slot.
func (o V2modelsSlotOutput) SlotId() pulumi.StringOutput {
	return o.ApplyT(func(v *V2modelsSlot) pulumi.StringOutput { return v.SlotId }).(pulumi.StringOutput)
}

// Unique identifier for the slot type associated with this slot.
func (o V2modelsSlotOutput) SlotTypeId() pulumi.StringOutput {
	return o.ApplyT(func(v *V2modelsSlot) pulumi.StringOutput { return v.SlotTypeId }).(pulumi.StringOutput)
}

// Specifications for the constituent sub slots and the expression for the composite slot.
// See the `subSlotSetting` argument reference below.
func (o V2modelsSlotOutput) SubSlotSettings() V2modelsSlotSubSlotSettingArrayOutput {
	return o.ApplyT(func(v *V2modelsSlot) V2modelsSlotSubSlotSettingArrayOutput { return v.SubSlotSettings }).(V2modelsSlotSubSlotSettingArrayOutput)
}

func (o V2modelsSlotOutput) Timeouts() V2modelsSlotTimeoutsPtrOutput {
	return o.ApplyT(func(v *V2modelsSlot) V2modelsSlotTimeoutsPtrOutput { return v.Timeouts }).(V2modelsSlotTimeoutsPtrOutput)
}

func (o V2modelsSlotOutput) ValueElicitationSetting() V2modelsSlotValueElicitationSettingPtrOutput {
	return o.ApplyT(func(v *V2modelsSlot) V2modelsSlotValueElicitationSettingPtrOutput { return v.ValueElicitationSetting }).(V2modelsSlotValueElicitationSettingPtrOutput)
}

type V2modelsSlotArrayOutput struct{ *pulumi.OutputState }

func (V2modelsSlotArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*V2modelsSlot)(nil)).Elem()
}

func (o V2modelsSlotArrayOutput) ToV2modelsSlotArrayOutput() V2modelsSlotArrayOutput {
	return o
}

func (o V2modelsSlotArrayOutput) ToV2modelsSlotArrayOutputWithContext(ctx context.Context) V2modelsSlotArrayOutput {
	return o
}

func (o V2modelsSlotArrayOutput) Index(i pulumi.IntInput) V2modelsSlotOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *V2modelsSlot {
		return vs[0].([]*V2modelsSlot)[vs[1].(int)]
	}).(V2modelsSlotOutput)
}

type V2modelsSlotMapOutput struct{ *pulumi.OutputState }

func (V2modelsSlotMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*V2modelsSlot)(nil)).Elem()
}

func (o V2modelsSlotMapOutput) ToV2modelsSlotMapOutput() V2modelsSlotMapOutput {
	return o
}

func (o V2modelsSlotMapOutput) ToV2modelsSlotMapOutputWithContext(ctx context.Context) V2modelsSlotMapOutput {
	return o
}

func (o V2modelsSlotMapOutput) MapIndex(k pulumi.StringInput) V2modelsSlotOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *V2modelsSlot {
		return vs[0].(map[string]*V2modelsSlot)[vs[1].(string)]
	}).(V2modelsSlotOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*V2modelsSlotInput)(nil)).Elem(), &V2modelsSlot{})
	pulumi.RegisterInputType(reflect.TypeOf((*V2modelsSlotArrayInput)(nil)).Elem(), V2modelsSlotArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*V2modelsSlotMapInput)(nil)).Elem(), V2modelsSlotMap{})
	pulumi.RegisterOutputType(V2modelsSlotOutput{})
	pulumi.RegisterOutputType(V2modelsSlotArrayOutput{})
	pulumi.RegisterOutputType(V2modelsSlotMapOutput{})
}
