// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package resourcegroups

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

var _ = internal.GetEnvOrDefault

type GroupConfiguration struct {
	// A collection of parameters for this group configuration item. See below for details.
	Parameters []GroupConfigurationParameter `pulumi:"parameters"`
	// Specifies the type of group configuration item.
	Type string `pulumi:"type"`
}

// GroupConfigurationInput is an input type that accepts GroupConfigurationArgs and GroupConfigurationOutput values.
// You can construct a concrete instance of `GroupConfigurationInput` via:
//
//	GroupConfigurationArgs{...}
type GroupConfigurationInput interface {
	pulumi.Input

	ToGroupConfigurationOutput() GroupConfigurationOutput
	ToGroupConfigurationOutputWithContext(context.Context) GroupConfigurationOutput
}

type GroupConfigurationArgs struct {
	// A collection of parameters for this group configuration item. See below for details.
	Parameters GroupConfigurationParameterArrayInput `pulumi:"parameters"`
	// Specifies the type of group configuration item.
	Type pulumi.StringInput `pulumi:"type"`
}

func (GroupConfigurationArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*GroupConfiguration)(nil)).Elem()
}

func (i GroupConfigurationArgs) ToGroupConfigurationOutput() GroupConfigurationOutput {
	return i.ToGroupConfigurationOutputWithContext(context.Background())
}

func (i GroupConfigurationArgs) ToGroupConfigurationOutputWithContext(ctx context.Context) GroupConfigurationOutput {
	return pulumi.ToOutputWithContext(ctx, i).(GroupConfigurationOutput)
}

// GroupConfigurationArrayInput is an input type that accepts GroupConfigurationArray and GroupConfigurationArrayOutput values.
// You can construct a concrete instance of `GroupConfigurationArrayInput` via:
//
//	GroupConfigurationArray{ GroupConfigurationArgs{...} }
type GroupConfigurationArrayInput interface {
	pulumi.Input

	ToGroupConfigurationArrayOutput() GroupConfigurationArrayOutput
	ToGroupConfigurationArrayOutputWithContext(context.Context) GroupConfigurationArrayOutput
}

type GroupConfigurationArray []GroupConfigurationInput

func (GroupConfigurationArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]GroupConfiguration)(nil)).Elem()
}

func (i GroupConfigurationArray) ToGroupConfigurationArrayOutput() GroupConfigurationArrayOutput {
	return i.ToGroupConfigurationArrayOutputWithContext(context.Background())
}

func (i GroupConfigurationArray) ToGroupConfigurationArrayOutputWithContext(ctx context.Context) GroupConfigurationArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(GroupConfigurationArrayOutput)
}

type GroupConfigurationOutput struct{ *pulumi.OutputState }

func (GroupConfigurationOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*GroupConfiguration)(nil)).Elem()
}

func (o GroupConfigurationOutput) ToGroupConfigurationOutput() GroupConfigurationOutput {
	return o
}

func (o GroupConfigurationOutput) ToGroupConfigurationOutputWithContext(ctx context.Context) GroupConfigurationOutput {
	return o
}

// A collection of parameters for this group configuration item. See below for details.
func (o GroupConfigurationOutput) Parameters() GroupConfigurationParameterArrayOutput {
	return o.ApplyT(func(v GroupConfiguration) []GroupConfigurationParameter { return v.Parameters }).(GroupConfigurationParameterArrayOutput)
}

// Specifies the type of group configuration item.
func (o GroupConfigurationOutput) Type() pulumi.StringOutput {
	return o.ApplyT(func(v GroupConfiguration) string { return v.Type }).(pulumi.StringOutput)
}

type GroupConfigurationArrayOutput struct{ *pulumi.OutputState }

func (GroupConfigurationArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]GroupConfiguration)(nil)).Elem()
}

func (o GroupConfigurationArrayOutput) ToGroupConfigurationArrayOutput() GroupConfigurationArrayOutput {
	return o
}

func (o GroupConfigurationArrayOutput) ToGroupConfigurationArrayOutputWithContext(ctx context.Context) GroupConfigurationArrayOutput {
	return o
}

func (o GroupConfigurationArrayOutput) Index(i pulumi.IntInput) GroupConfigurationOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) GroupConfiguration {
		return vs[0].([]GroupConfiguration)[vs[1].(int)]
	}).(GroupConfigurationOutput)
}

type GroupConfigurationParameter struct {
	// The name of the group configuration parameter.
	Name string `pulumi:"name"`
	// The value or values to be used for the specified parameter.
	Values []string `pulumi:"values"`
}

// GroupConfigurationParameterInput is an input type that accepts GroupConfigurationParameterArgs and GroupConfigurationParameterOutput values.
// You can construct a concrete instance of `GroupConfigurationParameterInput` via:
//
//	GroupConfigurationParameterArgs{...}
type GroupConfigurationParameterInput interface {
	pulumi.Input

	ToGroupConfigurationParameterOutput() GroupConfigurationParameterOutput
	ToGroupConfigurationParameterOutputWithContext(context.Context) GroupConfigurationParameterOutput
}

type GroupConfigurationParameterArgs struct {
	// The name of the group configuration parameter.
	Name pulumi.StringInput `pulumi:"name"`
	// The value or values to be used for the specified parameter.
	Values pulumi.StringArrayInput `pulumi:"values"`
}

func (GroupConfigurationParameterArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*GroupConfigurationParameter)(nil)).Elem()
}

func (i GroupConfigurationParameterArgs) ToGroupConfigurationParameterOutput() GroupConfigurationParameterOutput {
	return i.ToGroupConfigurationParameterOutputWithContext(context.Background())
}

func (i GroupConfigurationParameterArgs) ToGroupConfigurationParameterOutputWithContext(ctx context.Context) GroupConfigurationParameterOutput {
	return pulumi.ToOutputWithContext(ctx, i).(GroupConfigurationParameterOutput)
}

// GroupConfigurationParameterArrayInput is an input type that accepts GroupConfigurationParameterArray and GroupConfigurationParameterArrayOutput values.
// You can construct a concrete instance of `GroupConfigurationParameterArrayInput` via:
//
//	GroupConfigurationParameterArray{ GroupConfigurationParameterArgs{...} }
type GroupConfigurationParameterArrayInput interface {
	pulumi.Input

	ToGroupConfigurationParameterArrayOutput() GroupConfigurationParameterArrayOutput
	ToGroupConfigurationParameterArrayOutputWithContext(context.Context) GroupConfigurationParameterArrayOutput
}

type GroupConfigurationParameterArray []GroupConfigurationParameterInput

func (GroupConfigurationParameterArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]GroupConfigurationParameter)(nil)).Elem()
}

func (i GroupConfigurationParameterArray) ToGroupConfigurationParameterArrayOutput() GroupConfigurationParameterArrayOutput {
	return i.ToGroupConfigurationParameterArrayOutputWithContext(context.Background())
}

func (i GroupConfigurationParameterArray) ToGroupConfigurationParameterArrayOutputWithContext(ctx context.Context) GroupConfigurationParameterArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(GroupConfigurationParameterArrayOutput)
}

type GroupConfigurationParameterOutput struct{ *pulumi.OutputState }

func (GroupConfigurationParameterOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*GroupConfigurationParameter)(nil)).Elem()
}

func (o GroupConfigurationParameterOutput) ToGroupConfigurationParameterOutput() GroupConfigurationParameterOutput {
	return o
}

func (o GroupConfigurationParameterOutput) ToGroupConfigurationParameterOutputWithContext(ctx context.Context) GroupConfigurationParameterOutput {
	return o
}

// The name of the group configuration parameter.
func (o GroupConfigurationParameterOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v GroupConfigurationParameter) string { return v.Name }).(pulumi.StringOutput)
}

// The value or values to be used for the specified parameter.
func (o GroupConfigurationParameterOutput) Values() pulumi.StringArrayOutput {
	return o.ApplyT(func(v GroupConfigurationParameter) []string { return v.Values }).(pulumi.StringArrayOutput)
}

type GroupConfigurationParameterArrayOutput struct{ *pulumi.OutputState }

func (GroupConfigurationParameterArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]GroupConfigurationParameter)(nil)).Elem()
}

func (o GroupConfigurationParameterArrayOutput) ToGroupConfigurationParameterArrayOutput() GroupConfigurationParameterArrayOutput {
	return o
}

func (o GroupConfigurationParameterArrayOutput) ToGroupConfigurationParameterArrayOutputWithContext(ctx context.Context) GroupConfigurationParameterArrayOutput {
	return o
}

func (o GroupConfigurationParameterArrayOutput) Index(i pulumi.IntInput) GroupConfigurationParameterOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) GroupConfigurationParameter {
		return vs[0].([]GroupConfigurationParameter)[vs[1].(int)]
	}).(GroupConfigurationParameterOutput)
}

type GroupResourceQuery struct {
	// The resource query as a JSON string.
	Query string `pulumi:"query"`
	// The type of the resource query. Defaults to `TAG_FILTERS_1_0`.
	Type *string `pulumi:"type"`
}

// GroupResourceQueryInput is an input type that accepts GroupResourceQueryArgs and GroupResourceQueryOutput values.
// You can construct a concrete instance of `GroupResourceQueryInput` via:
//
//	GroupResourceQueryArgs{...}
type GroupResourceQueryInput interface {
	pulumi.Input

	ToGroupResourceQueryOutput() GroupResourceQueryOutput
	ToGroupResourceQueryOutputWithContext(context.Context) GroupResourceQueryOutput
}

type GroupResourceQueryArgs struct {
	// The resource query as a JSON string.
	Query pulumi.StringInput `pulumi:"query"`
	// The type of the resource query. Defaults to `TAG_FILTERS_1_0`.
	Type pulumi.StringPtrInput `pulumi:"type"`
}

func (GroupResourceQueryArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*GroupResourceQuery)(nil)).Elem()
}

func (i GroupResourceQueryArgs) ToGroupResourceQueryOutput() GroupResourceQueryOutput {
	return i.ToGroupResourceQueryOutputWithContext(context.Background())
}

func (i GroupResourceQueryArgs) ToGroupResourceQueryOutputWithContext(ctx context.Context) GroupResourceQueryOutput {
	return pulumi.ToOutputWithContext(ctx, i).(GroupResourceQueryOutput)
}

func (i GroupResourceQueryArgs) ToGroupResourceQueryPtrOutput() GroupResourceQueryPtrOutput {
	return i.ToGroupResourceQueryPtrOutputWithContext(context.Background())
}

func (i GroupResourceQueryArgs) ToGroupResourceQueryPtrOutputWithContext(ctx context.Context) GroupResourceQueryPtrOutput {
	return pulumi.ToOutputWithContext(ctx, i).(GroupResourceQueryOutput).ToGroupResourceQueryPtrOutputWithContext(ctx)
}

// GroupResourceQueryPtrInput is an input type that accepts GroupResourceQueryArgs, GroupResourceQueryPtr and GroupResourceQueryPtrOutput values.
// You can construct a concrete instance of `GroupResourceQueryPtrInput` via:
//
//	        GroupResourceQueryArgs{...}
//
//	or:
//
//	        nil
type GroupResourceQueryPtrInput interface {
	pulumi.Input

	ToGroupResourceQueryPtrOutput() GroupResourceQueryPtrOutput
	ToGroupResourceQueryPtrOutputWithContext(context.Context) GroupResourceQueryPtrOutput
}

type groupResourceQueryPtrType GroupResourceQueryArgs

func GroupResourceQueryPtr(v *GroupResourceQueryArgs) GroupResourceQueryPtrInput {
	return (*groupResourceQueryPtrType)(v)
}

func (*groupResourceQueryPtrType) ElementType() reflect.Type {
	return reflect.TypeOf((**GroupResourceQuery)(nil)).Elem()
}

func (i *groupResourceQueryPtrType) ToGroupResourceQueryPtrOutput() GroupResourceQueryPtrOutput {
	return i.ToGroupResourceQueryPtrOutputWithContext(context.Background())
}

func (i *groupResourceQueryPtrType) ToGroupResourceQueryPtrOutputWithContext(ctx context.Context) GroupResourceQueryPtrOutput {
	return pulumi.ToOutputWithContext(ctx, i).(GroupResourceQueryPtrOutput)
}

type GroupResourceQueryOutput struct{ *pulumi.OutputState }

func (GroupResourceQueryOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*GroupResourceQuery)(nil)).Elem()
}

func (o GroupResourceQueryOutput) ToGroupResourceQueryOutput() GroupResourceQueryOutput {
	return o
}

func (o GroupResourceQueryOutput) ToGroupResourceQueryOutputWithContext(ctx context.Context) GroupResourceQueryOutput {
	return o
}

func (o GroupResourceQueryOutput) ToGroupResourceQueryPtrOutput() GroupResourceQueryPtrOutput {
	return o.ToGroupResourceQueryPtrOutputWithContext(context.Background())
}

func (o GroupResourceQueryOutput) ToGroupResourceQueryPtrOutputWithContext(ctx context.Context) GroupResourceQueryPtrOutput {
	return o.ApplyTWithContext(ctx, func(_ context.Context, v GroupResourceQuery) *GroupResourceQuery {
		return &v
	}).(GroupResourceQueryPtrOutput)
}

// The resource query as a JSON string.
func (o GroupResourceQueryOutput) Query() pulumi.StringOutput {
	return o.ApplyT(func(v GroupResourceQuery) string { return v.Query }).(pulumi.StringOutput)
}

// The type of the resource query. Defaults to `TAG_FILTERS_1_0`.
func (o GroupResourceQueryOutput) Type() pulumi.StringPtrOutput {
	return o.ApplyT(func(v GroupResourceQuery) *string { return v.Type }).(pulumi.StringPtrOutput)
}

type GroupResourceQueryPtrOutput struct{ *pulumi.OutputState }

func (GroupResourceQueryPtrOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**GroupResourceQuery)(nil)).Elem()
}

func (o GroupResourceQueryPtrOutput) ToGroupResourceQueryPtrOutput() GroupResourceQueryPtrOutput {
	return o
}

func (o GroupResourceQueryPtrOutput) ToGroupResourceQueryPtrOutputWithContext(ctx context.Context) GroupResourceQueryPtrOutput {
	return o
}

func (o GroupResourceQueryPtrOutput) Elem() GroupResourceQueryOutput {
	return o.ApplyT(func(v *GroupResourceQuery) GroupResourceQuery {
		if v != nil {
			return *v
		}
		var ret GroupResourceQuery
		return ret
	}).(GroupResourceQueryOutput)
}

// The resource query as a JSON string.
func (o GroupResourceQueryPtrOutput) Query() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *GroupResourceQuery) *string {
		if v == nil {
			return nil
		}
		return &v.Query
	}).(pulumi.StringPtrOutput)
}

// The type of the resource query. Defaults to `TAG_FILTERS_1_0`.
func (o GroupResourceQueryPtrOutput) Type() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *GroupResourceQuery) *string {
		if v == nil {
			return nil
		}
		return v.Type
	}).(pulumi.StringPtrOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*GroupConfigurationInput)(nil)).Elem(), GroupConfigurationArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*GroupConfigurationArrayInput)(nil)).Elem(), GroupConfigurationArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*GroupConfigurationParameterInput)(nil)).Elem(), GroupConfigurationParameterArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*GroupConfigurationParameterArrayInput)(nil)).Elem(), GroupConfigurationParameterArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*GroupResourceQueryInput)(nil)).Elem(), GroupResourceQueryArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*GroupResourceQueryPtrInput)(nil)).Elem(), GroupResourceQueryArgs{})
	pulumi.RegisterOutputType(GroupConfigurationOutput{})
	pulumi.RegisterOutputType(GroupConfigurationArrayOutput{})
	pulumi.RegisterOutputType(GroupConfigurationParameterOutput{})
	pulumi.RegisterOutputType(GroupConfigurationParameterArrayOutput{})
	pulumi.RegisterOutputType(GroupResourceQueryOutput{})
	pulumi.RegisterOutputType(GroupResourceQueryPtrOutput{})
}
