// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package route53recoverycontrol

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

var _ = internal.GetEnvOrDefault

type ClusterClusterEndpoint struct {
	// Cluster endpoint.
	Endpoint *string `pulumi:"endpoint"`
	// Region of the endpoint.
	Region *string `pulumi:"region"`
}

// ClusterClusterEndpointInput is an input type that accepts ClusterClusterEndpointArgs and ClusterClusterEndpointOutput values.
// You can construct a concrete instance of `ClusterClusterEndpointInput` via:
//
//	ClusterClusterEndpointArgs{...}
type ClusterClusterEndpointInput interface {
	pulumi.Input

	ToClusterClusterEndpointOutput() ClusterClusterEndpointOutput
	ToClusterClusterEndpointOutputWithContext(context.Context) ClusterClusterEndpointOutput
}

type ClusterClusterEndpointArgs struct {
	// Cluster endpoint.
	Endpoint pulumi.StringPtrInput `pulumi:"endpoint"`
	// Region of the endpoint.
	Region pulumi.StringPtrInput `pulumi:"region"`
}

func (ClusterClusterEndpointArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*ClusterClusterEndpoint)(nil)).Elem()
}

func (i ClusterClusterEndpointArgs) ToClusterClusterEndpointOutput() ClusterClusterEndpointOutput {
	return i.ToClusterClusterEndpointOutputWithContext(context.Background())
}

func (i ClusterClusterEndpointArgs) ToClusterClusterEndpointOutputWithContext(ctx context.Context) ClusterClusterEndpointOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ClusterClusterEndpointOutput)
}

// ClusterClusterEndpointArrayInput is an input type that accepts ClusterClusterEndpointArray and ClusterClusterEndpointArrayOutput values.
// You can construct a concrete instance of `ClusterClusterEndpointArrayInput` via:
//
//	ClusterClusterEndpointArray{ ClusterClusterEndpointArgs{...} }
type ClusterClusterEndpointArrayInput interface {
	pulumi.Input

	ToClusterClusterEndpointArrayOutput() ClusterClusterEndpointArrayOutput
	ToClusterClusterEndpointArrayOutputWithContext(context.Context) ClusterClusterEndpointArrayOutput
}

type ClusterClusterEndpointArray []ClusterClusterEndpointInput

func (ClusterClusterEndpointArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]ClusterClusterEndpoint)(nil)).Elem()
}

func (i ClusterClusterEndpointArray) ToClusterClusterEndpointArrayOutput() ClusterClusterEndpointArrayOutput {
	return i.ToClusterClusterEndpointArrayOutputWithContext(context.Background())
}

func (i ClusterClusterEndpointArray) ToClusterClusterEndpointArrayOutputWithContext(ctx context.Context) ClusterClusterEndpointArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ClusterClusterEndpointArrayOutput)
}

type ClusterClusterEndpointOutput struct{ *pulumi.OutputState }

func (ClusterClusterEndpointOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*ClusterClusterEndpoint)(nil)).Elem()
}

func (o ClusterClusterEndpointOutput) ToClusterClusterEndpointOutput() ClusterClusterEndpointOutput {
	return o
}

func (o ClusterClusterEndpointOutput) ToClusterClusterEndpointOutputWithContext(ctx context.Context) ClusterClusterEndpointOutput {
	return o
}

// Cluster endpoint.
func (o ClusterClusterEndpointOutput) Endpoint() pulumi.StringPtrOutput {
	return o.ApplyT(func(v ClusterClusterEndpoint) *string { return v.Endpoint }).(pulumi.StringPtrOutput)
}

// Region of the endpoint.
func (o ClusterClusterEndpointOutput) Region() pulumi.StringPtrOutput {
	return o.ApplyT(func(v ClusterClusterEndpoint) *string { return v.Region }).(pulumi.StringPtrOutput)
}

type ClusterClusterEndpointArrayOutput struct{ *pulumi.OutputState }

func (ClusterClusterEndpointArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]ClusterClusterEndpoint)(nil)).Elem()
}

func (o ClusterClusterEndpointArrayOutput) ToClusterClusterEndpointArrayOutput() ClusterClusterEndpointArrayOutput {
	return o
}

func (o ClusterClusterEndpointArrayOutput) ToClusterClusterEndpointArrayOutputWithContext(ctx context.Context) ClusterClusterEndpointArrayOutput {
	return o
}

func (o ClusterClusterEndpointArrayOutput) Index(i pulumi.IntInput) ClusterClusterEndpointOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) ClusterClusterEndpoint {
		return vs[0].([]ClusterClusterEndpoint)[vs[1].(int)]
	}).(ClusterClusterEndpointOutput)
}

type SafetyRuleRuleConfig struct {
	// Logical negation of the rule.
	Inverted bool `pulumi:"inverted"`
	// Number of controls that must be set when you specify an `ATLEAST` type rule.
	Threshold int `pulumi:"threshold"`
	// Rule type. Valid values are `ATLEAST`, `AND`, and `OR`.
	Type string `pulumi:"type"`
}

// SafetyRuleRuleConfigInput is an input type that accepts SafetyRuleRuleConfigArgs and SafetyRuleRuleConfigOutput values.
// You can construct a concrete instance of `SafetyRuleRuleConfigInput` via:
//
//	SafetyRuleRuleConfigArgs{...}
type SafetyRuleRuleConfigInput interface {
	pulumi.Input

	ToSafetyRuleRuleConfigOutput() SafetyRuleRuleConfigOutput
	ToSafetyRuleRuleConfigOutputWithContext(context.Context) SafetyRuleRuleConfigOutput
}

type SafetyRuleRuleConfigArgs struct {
	// Logical negation of the rule.
	Inverted pulumi.BoolInput `pulumi:"inverted"`
	// Number of controls that must be set when you specify an `ATLEAST` type rule.
	Threshold pulumi.IntInput `pulumi:"threshold"`
	// Rule type. Valid values are `ATLEAST`, `AND`, and `OR`.
	Type pulumi.StringInput `pulumi:"type"`
}

func (SafetyRuleRuleConfigArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*SafetyRuleRuleConfig)(nil)).Elem()
}

func (i SafetyRuleRuleConfigArgs) ToSafetyRuleRuleConfigOutput() SafetyRuleRuleConfigOutput {
	return i.ToSafetyRuleRuleConfigOutputWithContext(context.Background())
}

func (i SafetyRuleRuleConfigArgs) ToSafetyRuleRuleConfigOutputWithContext(ctx context.Context) SafetyRuleRuleConfigOutput {
	return pulumi.ToOutputWithContext(ctx, i).(SafetyRuleRuleConfigOutput)
}

func (i SafetyRuleRuleConfigArgs) ToSafetyRuleRuleConfigPtrOutput() SafetyRuleRuleConfigPtrOutput {
	return i.ToSafetyRuleRuleConfigPtrOutputWithContext(context.Background())
}

func (i SafetyRuleRuleConfigArgs) ToSafetyRuleRuleConfigPtrOutputWithContext(ctx context.Context) SafetyRuleRuleConfigPtrOutput {
	return pulumi.ToOutputWithContext(ctx, i).(SafetyRuleRuleConfigOutput).ToSafetyRuleRuleConfigPtrOutputWithContext(ctx)
}

// SafetyRuleRuleConfigPtrInput is an input type that accepts SafetyRuleRuleConfigArgs, SafetyRuleRuleConfigPtr and SafetyRuleRuleConfigPtrOutput values.
// You can construct a concrete instance of `SafetyRuleRuleConfigPtrInput` via:
//
//	        SafetyRuleRuleConfigArgs{...}
//
//	or:
//
//	        nil
type SafetyRuleRuleConfigPtrInput interface {
	pulumi.Input

	ToSafetyRuleRuleConfigPtrOutput() SafetyRuleRuleConfigPtrOutput
	ToSafetyRuleRuleConfigPtrOutputWithContext(context.Context) SafetyRuleRuleConfigPtrOutput
}

type safetyRuleRuleConfigPtrType SafetyRuleRuleConfigArgs

func SafetyRuleRuleConfigPtr(v *SafetyRuleRuleConfigArgs) SafetyRuleRuleConfigPtrInput {
	return (*safetyRuleRuleConfigPtrType)(v)
}

func (*safetyRuleRuleConfigPtrType) ElementType() reflect.Type {
	return reflect.TypeOf((**SafetyRuleRuleConfig)(nil)).Elem()
}

func (i *safetyRuleRuleConfigPtrType) ToSafetyRuleRuleConfigPtrOutput() SafetyRuleRuleConfigPtrOutput {
	return i.ToSafetyRuleRuleConfigPtrOutputWithContext(context.Background())
}

func (i *safetyRuleRuleConfigPtrType) ToSafetyRuleRuleConfigPtrOutputWithContext(ctx context.Context) SafetyRuleRuleConfigPtrOutput {
	return pulumi.ToOutputWithContext(ctx, i).(SafetyRuleRuleConfigPtrOutput)
}

type SafetyRuleRuleConfigOutput struct{ *pulumi.OutputState }

func (SafetyRuleRuleConfigOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*SafetyRuleRuleConfig)(nil)).Elem()
}

func (o SafetyRuleRuleConfigOutput) ToSafetyRuleRuleConfigOutput() SafetyRuleRuleConfigOutput {
	return o
}

func (o SafetyRuleRuleConfigOutput) ToSafetyRuleRuleConfigOutputWithContext(ctx context.Context) SafetyRuleRuleConfigOutput {
	return o
}

func (o SafetyRuleRuleConfigOutput) ToSafetyRuleRuleConfigPtrOutput() SafetyRuleRuleConfigPtrOutput {
	return o.ToSafetyRuleRuleConfigPtrOutputWithContext(context.Background())
}

func (o SafetyRuleRuleConfigOutput) ToSafetyRuleRuleConfigPtrOutputWithContext(ctx context.Context) SafetyRuleRuleConfigPtrOutput {
	return o.ApplyTWithContext(ctx, func(_ context.Context, v SafetyRuleRuleConfig) *SafetyRuleRuleConfig {
		return &v
	}).(SafetyRuleRuleConfigPtrOutput)
}

// Logical negation of the rule.
func (o SafetyRuleRuleConfigOutput) Inverted() pulumi.BoolOutput {
	return o.ApplyT(func(v SafetyRuleRuleConfig) bool { return v.Inverted }).(pulumi.BoolOutput)
}

// Number of controls that must be set when you specify an `ATLEAST` type rule.
func (o SafetyRuleRuleConfigOutput) Threshold() pulumi.IntOutput {
	return o.ApplyT(func(v SafetyRuleRuleConfig) int { return v.Threshold }).(pulumi.IntOutput)
}

// Rule type. Valid values are `ATLEAST`, `AND`, and `OR`.
func (o SafetyRuleRuleConfigOutput) Type() pulumi.StringOutput {
	return o.ApplyT(func(v SafetyRuleRuleConfig) string { return v.Type }).(pulumi.StringOutput)
}

type SafetyRuleRuleConfigPtrOutput struct{ *pulumi.OutputState }

func (SafetyRuleRuleConfigPtrOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**SafetyRuleRuleConfig)(nil)).Elem()
}

func (o SafetyRuleRuleConfigPtrOutput) ToSafetyRuleRuleConfigPtrOutput() SafetyRuleRuleConfigPtrOutput {
	return o
}

func (o SafetyRuleRuleConfigPtrOutput) ToSafetyRuleRuleConfigPtrOutputWithContext(ctx context.Context) SafetyRuleRuleConfigPtrOutput {
	return o
}

func (o SafetyRuleRuleConfigPtrOutput) Elem() SafetyRuleRuleConfigOutput {
	return o.ApplyT(func(v *SafetyRuleRuleConfig) SafetyRuleRuleConfig {
		if v != nil {
			return *v
		}
		var ret SafetyRuleRuleConfig
		return ret
	}).(SafetyRuleRuleConfigOutput)
}

// Logical negation of the rule.
func (o SafetyRuleRuleConfigPtrOutput) Inverted() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v *SafetyRuleRuleConfig) *bool {
		if v == nil {
			return nil
		}
		return &v.Inverted
	}).(pulumi.BoolPtrOutput)
}

// Number of controls that must be set when you specify an `ATLEAST` type rule.
func (o SafetyRuleRuleConfigPtrOutput) Threshold() pulumi.IntPtrOutput {
	return o.ApplyT(func(v *SafetyRuleRuleConfig) *int {
		if v == nil {
			return nil
		}
		return &v.Threshold
	}).(pulumi.IntPtrOutput)
}

// Rule type. Valid values are `ATLEAST`, `AND`, and `OR`.
func (o SafetyRuleRuleConfigPtrOutput) Type() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *SafetyRuleRuleConfig) *string {
		if v == nil {
			return nil
		}
		return &v.Type
	}).(pulumi.StringPtrOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ClusterClusterEndpointInput)(nil)).Elem(), ClusterClusterEndpointArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*ClusterClusterEndpointArrayInput)(nil)).Elem(), ClusterClusterEndpointArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*SafetyRuleRuleConfigInput)(nil)).Elem(), SafetyRuleRuleConfigArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*SafetyRuleRuleConfigPtrInput)(nil)).Elem(), SafetyRuleRuleConfigArgs{})
	pulumi.RegisterOutputType(ClusterClusterEndpointOutput{})
	pulumi.RegisterOutputType(ClusterClusterEndpointArrayOutput{})
	pulumi.RegisterOutputType(SafetyRuleRuleConfigOutput{})
	pulumi.RegisterOutputType(SafetyRuleRuleConfigPtrOutput{})
}
