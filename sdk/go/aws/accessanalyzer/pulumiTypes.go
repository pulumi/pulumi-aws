// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package accessanalyzer

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

var _ = internal.GetEnvOrDefault

type AnalyzerConfiguration struct {
	// A block that specifies the configuration of an unused access analyzer for an AWS organization or account. Documented below
	UnusedAccess *AnalyzerConfigurationUnusedAccess `pulumi:"unusedAccess"`
}

// AnalyzerConfigurationInput is an input type that accepts AnalyzerConfigurationArgs and AnalyzerConfigurationOutput values.
// You can construct a concrete instance of `AnalyzerConfigurationInput` via:
//
//	AnalyzerConfigurationArgs{...}
type AnalyzerConfigurationInput interface {
	pulumi.Input

	ToAnalyzerConfigurationOutput() AnalyzerConfigurationOutput
	ToAnalyzerConfigurationOutputWithContext(context.Context) AnalyzerConfigurationOutput
}

type AnalyzerConfigurationArgs struct {
	// A block that specifies the configuration of an unused access analyzer for an AWS organization or account. Documented below
	UnusedAccess AnalyzerConfigurationUnusedAccessPtrInput `pulumi:"unusedAccess"`
}

func (AnalyzerConfigurationArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*AnalyzerConfiguration)(nil)).Elem()
}

func (i AnalyzerConfigurationArgs) ToAnalyzerConfigurationOutput() AnalyzerConfigurationOutput {
	return i.ToAnalyzerConfigurationOutputWithContext(context.Background())
}

func (i AnalyzerConfigurationArgs) ToAnalyzerConfigurationOutputWithContext(ctx context.Context) AnalyzerConfigurationOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AnalyzerConfigurationOutput)
}

func (i AnalyzerConfigurationArgs) ToAnalyzerConfigurationPtrOutput() AnalyzerConfigurationPtrOutput {
	return i.ToAnalyzerConfigurationPtrOutputWithContext(context.Background())
}

func (i AnalyzerConfigurationArgs) ToAnalyzerConfigurationPtrOutputWithContext(ctx context.Context) AnalyzerConfigurationPtrOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AnalyzerConfigurationOutput).ToAnalyzerConfigurationPtrOutputWithContext(ctx)
}

// AnalyzerConfigurationPtrInput is an input type that accepts AnalyzerConfigurationArgs, AnalyzerConfigurationPtr and AnalyzerConfigurationPtrOutput values.
// You can construct a concrete instance of `AnalyzerConfigurationPtrInput` via:
//
//	        AnalyzerConfigurationArgs{...}
//
//	or:
//
//	        nil
type AnalyzerConfigurationPtrInput interface {
	pulumi.Input

	ToAnalyzerConfigurationPtrOutput() AnalyzerConfigurationPtrOutput
	ToAnalyzerConfigurationPtrOutputWithContext(context.Context) AnalyzerConfigurationPtrOutput
}

type analyzerConfigurationPtrType AnalyzerConfigurationArgs

func AnalyzerConfigurationPtr(v *AnalyzerConfigurationArgs) AnalyzerConfigurationPtrInput {
	return (*analyzerConfigurationPtrType)(v)
}

func (*analyzerConfigurationPtrType) ElementType() reflect.Type {
	return reflect.TypeOf((**AnalyzerConfiguration)(nil)).Elem()
}

func (i *analyzerConfigurationPtrType) ToAnalyzerConfigurationPtrOutput() AnalyzerConfigurationPtrOutput {
	return i.ToAnalyzerConfigurationPtrOutputWithContext(context.Background())
}

func (i *analyzerConfigurationPtrType) ToAnalyzerConfigurationPtrOutputWithContext(ctx context.Context) AnalyzerConfigurationPtrOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AnalyzerConfigurationPtrOutput)
}

type AnalyzerConfigurationOutput struct{ *pulumi.OutputState }

func (AnalyzerConfigurationOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*AnalyzerConfiguration)(nil)).Elem()
}

func (o AnalyzerConfigurationOutput) ToAnalyzerConfigurationOutput() AnalyzerConfigurationOutput {
	return o
}

func (o AnalyzerConfigurationOutput) ToAnalyzerConfigurationOutputWithContext(ctx context.Context) AnalyzerConfigurationOutput {
	return o
}

func (o AnalyzerConfigurationOutput) ToAnalyzerConfigurationPtrOutput() AnalyzerConfigurationPtrOutput {
	return o.ToAnalyzerConfigurationPtrOutputWithContext(context.Background())
}

func (o AnalyzerConfigurationOutput) ToAnalyzerConfigurationPtrOutputWithContext(ctx context.Context) AnalyzerConfigurationPtrOutput {
	return o.ApplyTWithContext(ctx, func(_ context.Context, v AnalyzerConfiguration) *AnalyzerConfiguration {
		return &v
	}).(AnalyzerConfigurationPtrOutput)
}

// A block that specifies the configuration of an unused access analyzer for an AWS organization or account. Documented below
func (o AnalyzerConfigurationOutput) UnusedAccess() AnalyzerConfigurationUnusedAccessPtrOutput {
	return o.ApplyT(func(v AnalyzerConfiguration) *AnalyzerConfigurationUnusedAccess { return v.UnusedAccess }).(AnalyzerConfigurationUnusedAccessPtrOutput)
}

type AnalyzerConfigurationPtrOutput struct{ *pulumi.OutputState }

func (AnalyzerConfigurationPtrOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**AnalyzerConfiguration)(nil)).Elem()
}

func (o AnalyzerConfigurationPtrOutput) ToAnalyzerConfigurationPtrOutput() AnalyzerConfigurationPtrOutput {
	return o
}

func (o AnalyzerConfigurationPtrOutput) ToAnalyzerConfigurationPtrOutputWithContext(ctx context.Context) AnalyzerConfigurationPtrOutput {
	return o
}

func (o AnalyzerConfigurationPtrOutput) Elem() AnalyzerConfigurationOutput {
	return o.ApplyT(func(v *AnalyzerConfiguration) AnalyzerConfiguration {
		if v != nil {
			return *v
		}
		var ret AnalyzerConfiguration
		return ret
	}).(AnalyzerConfigurationOutput)
}

// A block that specifies the configuration of an unused access analyzer for an AWS organization or account. Documented below
func (o AnalyzerConfigurationPtrOutput) UnusedAccess() AnalyzerConfigurationUnusedAccessPtrOutput {
	return o.ApplyT(func(v *AnalyzerConfiguration) *AnalyzerConfigurationUnusedAccess {
		if v == nil {
			return nil
		}
		return v.UnusedAccess
	}).(AnalyzerConfigurationUnusedAccessPtrOutput)
}

type AnalyzerConfigurationUnusedAccess struct {
	// A block for analysis rules. Documented below
	AnalysisRule *AnalyzerConfigurationUnusedAccessAnalysisRule `pulumi:"analysisRule"`
	// The specified access age in days for which to generate findings for unused access.
	UnusedAccessAge *int `pulumi:"unusedAccessAge"`
}

// AnalyzerConfigurationUnusedAccessInput is an input type that accepts AnalyzerConfigurationUnusedAccessArgs and AnalyzerConfigurationUnusedAccessOutput values.
// You can construct a concrete instance of `AnalyzerConfigurationUnusedAccessInput` via:
//
//	AnalyzerConfigurationUnusedAccessArgs{...}
type AnalyzerConfigurationUnusedAccessInput interface {
	pulumi.Input

	ToAnalyzerConfigurationUnusedAccessOutput() AnalyzerConfigurationUnusedAccessOutput
	ToAnalyzerConfigurationUnusedAccessOutputWithContext(context.Context) AnalyzerConfigurationUnusedAccessOutput
}

type AnalyzerConfigurationUnusedAccessArgs struct {
	// A block for analysis rules. Documented below
	AnalysisRule AnalyzerConfigurationUnusedAccessAnalysisRulePtrInput `pulumi:"analysisRule"`
	// The specified access age in days for which to generate findings for unused access.
	UnusedAccessAge pulumi.IntPtrInput `pulumi:"unusedAccessAge"`
}

func (AnalyzerConfigurationUnusedAccessArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*AnalyzerConfigurationUnusedAccess)(nil)).Elem()
}

func (i AnalyzerConfigurationUnusedAccessArgs) ToAnalyzerConfigurationUnusedAccessOutput() AnalyzerConfigurationUnusedAccessOutput {
	return i.ToAnalyzerConfigurationUnusedAccessOutputWithContext(context.Background())
}

func (i AnalyzerConfigurationUnusedAccessArgs) ToAnalyzerConfigurationUnusedAccessOutputWithContext(ctx context.Context) AnalyzerConfigurationUnusedAccessOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AnalyzerConfigurationUnusedAccessOutput)
}

func (i AnalyzerConfigurationUnusedAccessArgs) ToAnalyzerConfigurationUnusedAccessPtrOutput() AnalyzerConfigurationUnusedAccessPtrOutput {
	return i.ToAnalyzerConfigurationUnusedAccessPtrOutputWithContext(context.Background())
}

func (i AnalyzerConfigurationUnusedAccessArgs) ToAnalyzerConfigurationUnusedAccessPtrOutputWithContext(ctx context.Context) AnalyzerConfigurationUnusedAccessPtrOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AnalyzerConfigurationUnusedAccessOutput).ToAnalyzerConfigurationUnusedAccessPtrOutputWithContext(ctx)
}

// AnalyzerConfigurationUnusedAccessPtrInput is an input type that accepts AnalyzerConfigurationUnusedAccessArgs, AnalyzerConfigurationUnusedAccessPtr and AnalyzerConfigurationUnusedAccessPtrOutput values.
// You can construct a concrete instance of `AnalyzerConfigurationUnusedAccessPtrInput` via:
//
//	        AnalyzerConfigurationUnusedAccessArgs{...}
//
//	or:
//
//	        nil
type AnalyzerConfigurationUnusedAccessPtrInput interface {
	pulumi.Input

	ToAnalyzerConfigurationUnusedAccessPtrOutput() AnalyzerConfigurationUnusedAccessPtrOutput
	ToAnalyzerConfigurationUnusedAccessPtrOutputWithContext(context.Context) AnalyzerConfigurationUnusedAccessPtrOutput
}

type analyzerConfigurationUnusedAccessPtrType AnalyzerConfigurationUnusedAccessArgs

func AnalyzerConfigurationUnusedAccessPtr(v *AnalyzerConfigurationUnusedAccessArgs) AnalyzerConfigurationUnusedAccessPtrInput {
	return (*analyzerConfigurationUnusedAccessPtrType)(v)
}

func (*analyzerConfigurationUnusedAccessPtrType) ElementType() reflect.Type {
	return reflect.TypeOf((**AnalyzerConfigurationUnusedAccess)(nil)).Elem()
}

func (i *analyzerConfigurationUnusedAccessPtrType) ToAnalyzerConfigurationUnusedAccessPtrOutput() AnalyzerConfigurationUnusedAccessPtrOutput {
	return i.ToAnalyzerConfigurationUnusedAccessPtrOutputWithContext(context.Background())
}

func (i *analyzerConfigurationUnusedAccessPtrType) ToAnalyzerConfigurationUnusedAccessPtrOutputWithContext(ctx context.Context) AnalyzerConfigurationUnusedAccessPtrOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AnalyzerConfigurationUnusedAccessPtrOutput)
}

type AnalyzerConfigurationUnusedAccessOutput struct{ *pulumi.OutputState }

func (AnalyzerConfigurationUnusedAccessOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*AnalyzerConfigurationUnusedAccess)(nil)).Elem()
}

func (o AnalyzerConfigurationUnusedAccessOutput) ToAnalyzerConfigurationUnusedAccessOutput() AnalyzerConfigurationUnusedAccessOutput {
	return o
}

func (o AnalyzerConfigurationUnusedAccessOutput) ToAnalyzerConfigurationUnusedAccessOutputWithContext(ctx context.Context) AnalyzerConfigurationUnusedAccessOutput {
	return o
}

func (o AnalyzerConfigurationUnusedAccessOutput) ToAnalyzerConfigurationUnusedAccessPtrOutput() AnalyzerConfigurationUnusedAccessPtrOutput {
	return o.ToAnalyzerConfigurationUnusedAccessPtrOutputWithContext(context.Background())
}

func (o AnalyzerConfigurationUnusedAccessOutput) ToAnalyzerConfigurationUnusedAccessPtrOutputWithContext(ctx context.Context) AnalyzerConfigurationUnusedAccessPtrOutput {
	return o.ApplyTWithContext(ctx, func(_ context.Context, v AnalyzerConfigurationUnusedAccess) *AnalyzerConfigurationUnusedAccess {
		return &v
	}).(AnalyzerConfigurationUnusedAccessPtrOutput)
}

// A block for analysis rules. Documented below
func (o AnalyzerConfigurationUnusedAccessOutput) AnalysisRule() AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput {
	return o.ApplyT(func(v AnalyzerConfigurationUnusedAccess) *AnalyzerConfigurationUnusedAccessAnalysisRule {
		return v.AnalysisRule
	}).(AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput)
}

// The specified access age in days for which to generate findings for unused access.
func (o AnalyzerConfigurationUnusedAccessOutput) UnusedAccessAge() pulumi.IntPtrOutput {
	return o.ApplyT(func(v AnalyzerConfigurationUnusedAccess) *int { return v.UnusedAccessAge }).(pulumi.IntPtrOutput)
}

type AnalyzerConfigurationUnusedAccessPtrOutput struct{ *pulumi.OutputState }

func (AnalyzerConfigurationUnusedAccessPtrOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**AnalyzerConfigurationUnusedAccess)(nil)).Elem()
}

func (o AnalyzerConfigurationUnusedAccessPtrOutput) ToAnalyzerConfigurationUnusedAccessPtrOutput() AnalyzerConfigurationUnusedAccessPtrOutput {
	return o
}

func (o AnalyzerConfigurationUnusedAccessPtrOutput) ToAnalyzerConfigurationUnusedAccessPtrOutputWithContext(ctx context.Context) AnalyzerConfigurationUnusedAccessPtrOutput {
	return o
}

func (o AnalyzerConfigurationUnusedAccessPtrOutput) Elem() AnalyzerConfigurationUnusedAccessOutput {
	return o.ApplyT(func(v *AnalyzerConfigurationUnusedAccess) AnalyzerConfigurationUnusedAccess {
		if v != nil {
			return *v
		}
		var ret AnalyzerConfigurationUnusedAccess
		return ret
	}).(AnalyzerConfigurationUnusedAccessOutput)
}

// A block for analysis rules. Documented below
func (o AnalyzerConfigurationUnusedAccessPtrOutput) AnalysisRule() AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput {
	return o.ApplyT(func(v *AnalyzerConfigurationUnusedAccess) *AnalyzerConfigurationUnusedAccessAnalysisRule {
		if v == nil {
			return nil
		}
		return v.AnalysisRule
	}).(AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput)
}

// The specified access age in days for which to generate findings for unused access.
func (o AnalyzerConfigurationUnusedAccessPtrOutput) UnusedAccessAge() pulumi.IntPtrOutput {
	return o.ApplyT(func(v *AnalyzerConfigurationUnusedAccess) *int {
		if v == nil {
			return nil
		}
		return v.UnusedAccessAge
	}).(pulumi.IntPtrOutput)
}

type AnalyzerConfigurationUnusedAccessAnalysisRule struct {
	// A block for the analyzer rules containing criteria to exclude from analysis. Documented below
	Exclusions []AnalyzerConfigurationUnusedAccessAnalysisRuleExclusion `pulumi:"exclusions"`
}

// AnalyzerConfigurationUnusedAccessAnalysisRuleInput is an input type that accepts AnalyzerConfigurationUnusedAccessAnalysisRuleArgs and AnalyzerConfigurationUnusedAccessAnalysisRuleOutput values.
// You can construct a concrete instance of `AnalyzerConfigurationUnusedAccessAnalysisRuleInput` via:
//
//	AnalyzerConfigurationUnusedAccessAnalysisRuleArgs{...}
type AnalyzerConfigurationUnusedAccessAnalysisRuleInput interface {
	pulumi.Input

	ToAnalyzerConfigurationUnusedAccessAnalysisRuleOutput() AnalyzerConfigurationUnusedAccessAnalysisRuleOutput
	ToAnalyzerConfigurationUnusedAccessAnalysisRuleOutputWithContext(context.Context) AnalyzerConfigurationUnusedAccessAnalysisRuleOutput
}

type AnalyzerConfigurationUnusedAccessAnalysisRuleArgs struct {
	// A block for the analyzer rules containing criteria to exclude from analysis. Documented below
	Exclusions AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayInput `pulumi:"exclusions"`
}

func (AnalyzerConfigurationUnusedAccessAnalysisRuleArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*AnalyzerConfigurationUnusedAccessAnalysisRule)(nil)).Elem()
}

func (i AnalyzerConfigurationUnusedAccessAnalysisRuleArgs) ToAnalyzerConfigurationUnusedAccessAnalysisRuleOutput() AnalyzerConfigurationUnusedAccessAnalysisRuleOutput {
	return i.ToAnalyzerConfigurationUnusedAccessAnalysisRuleOutputWithContext(context.Background())
}

func (i AnalyzerConfigurationUnusedAccessAnalysisRuleArgs) ToAnalyzerConfigurationUnusedAccessAnalysisRuleOutputWithContext(ctx context.Context) AnalyzerConfigurationUnusedAccessAnalysisRuleOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AnalyzerConfigurationUnusedAccessAnalysisRuleOutput)
}

func (i AnalyzerConfigurationUnusedAccessAnalysisRuleArgs) ToAnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput() AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput {
	return i.ToAnalyzerConfigurationUnusedAccessAnalysisRulePtrOutputWithContext(context.Background())
}

func (i AnalyzerConfigurationUnusedAccessAnalysisRuleArgs) ToAnalyzerConfigurationUnusedAccessAnalysisRulePtrOutputWithContext(ctx context.Context) AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AnalyzerConfigurationUnusedAccessAnalysisRuleOutput).ToAnalyzerConfigurationUnusedAccessAnalysisRulePtrOutputWithContext(ctx)
}

// AnalyzerConfigurationUnusedAccessAnalysisRulePtrInput is an input type that accepts AnalyzerConfigurationUnusedAccessAnalysisRuleArgs, AnalyzerConfigurationUnusedAccessAnalysisRulePtr and AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput values.
// You can construct a concrete instance of `AnalyzerConfigurationUnusedAccessAnalysisRulePtrInput` via:
//
//	        AnalyzerConfigurationUnusedAccessAnalysisRuleArgs{...}
//
//	or:
//
//	        nil
type AnalyzerConfigurationUnusedAccessAnalysisRulePtrInput interface {
	pulumi.Input

	ToAnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput() AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput
	ToAnalyzerConfigurationUnusedAccessAnalysisRulePtrOutputWithContext(context.Context) AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput
}

type analyzerConfigurationUnusedAccessAnalysisRulePtrType AnalyzerConfigurationUnusedAccessAnalysisRuleArgs

func AnalyzerConfigurationUnusedAccessAnalysisRulePtr(v *AnalyzerConfigurationUnusedAccessAnalysisRuleArgs) AnalyzerConfigurationUnusedAccessAnalysisRulePtrInput {
	return (*analyzerConfigurationUnusedAccessAnalysisRulePtrType)(v)
}

func (*analyzerConfigurationUnusedAccessAnalysisRulePtrType) ElementType() reflect.Type {
	return reflect.TypeOf((**AnalyzerConfigurationUnusedAccessAnalysisRule)(nil)).Elem()
}

func (i *analyzerConfigurationUnusedAccessAnalysisRulePtrType) ToAnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput() AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput {
	return i.ToAnalyzerConfigurationUnusedAccessAnalysisRulePtrOutputWithContext(context.Background())
}

func (i *analyzerConfigurationUnusedAccessAnalysisRulePtrType) ToAnalyzerConfigurationUnusedAccessAnalysisRulePtrOutputWithContext(ctx context.Context) AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput)
}

type AnalyzerConfigurationUnusedAccessAnalysisRuleOutput struct{ *pulumi.OutputState }

func (AnalyzerConfigurationUnusedAccessAnalysisRuleOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*AnalyzerConfigurationUnusedAccessAnalysisRule)(nil)).Elem()
}

func (o AnalyzerConfigurationUnusedAccessAnalysisRuleOutput) ToAnalyzerConfigurationUnusedAccessAnalysisRuleOutput() AnalyzerConfigurationUnusedAccessAnalysisRuleOutput {
	return o
}

func (o AnalyzerConfigurationUnusedAccessAnalysisRuleOutput) ToAnalyzerConfigurationUnusedAccessAnalysisRuleOutputWithContext(ctx context.Context) AnalyzerConfigurationUnusedAccessAnalysisRuleOutput {
	return o
}

func (o AnalyzerConfigurationUnusedAccessAnalysisRuleOutput) ToAnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput() AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput {
	return o.ToAnalyzerConfigurationUnusedAccessAnalysisRulePtrOutputWithContext(context.Background())
}

func (o AnalyzerConfigurationUnusedAccessAnalysisRuleOutput) ToAnalyzerConfigurationUnusedAccessAnalysisRulePtrOutputWithContext(ctx context.Context) AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput {
	return o.ApplyTWithContext(ctx, func(_ context.Context, v AnalyzerConfigurationUnusedAccessAnalysisRule) *AnalyzerConfigurationUnusedAccessAnalysisRule {
		return &v
	}).(AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput)
}

// A block for the analyzer rules containing criteria to exclude from analysis. Documented below
func (o AnalyzerConfigurationUnusedAccessAnalysisRuleOutput) Exclusions() AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutput {
	return o.ApplyT(func(v AnalyzerConfigurationUnusedAccessAnalysisRule) []AnalyzerConfigurationUnusedAccessAnalysisRuleExclusion {
		return v.Exclusions
	}).(AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutput)
}

type AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput struct{ *pulumi.OutputState }

func (AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**AnalyzerConfigurationUnusedAccessAnalysisRule)(nil)).Elem()
}

func (o AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput) ToAnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput() AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput {
	return o
}

func (o AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput) ToAnalyzerConfigurationUnusedAccessAnalysisRulePtrOutputWithContext(ctx context.Context) AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput {
	return o
}

func (o AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput) Elem() AnalyzerConfigurationUnusedAccessAnalysisRuleOutput {
	return o.ApplyT(func(v *AnalyzerConfigurationUnusedAccessAnalysisRule) AnalyzerConfigurationUnusedAccessAnalysisRule {
		if v != nil {
			return *v
		}
		var ret AnalyzerConfigurationUnusedAccessAnalysisRule
		return ret
	}).(AnalyzerConfigurationUnusedAccessAnalysisRuleOutput)
}

// A block for the analyzer rules containing criteria to exclude from analysis. Documented below
func (o AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput) Exclusions() AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutput {
	return o.ApplyT(func(v *AnalyzerConfigurationUnusedAccessAnalysisRule) []AnalyzerConfigurationUnusedAccessAnalysisRuleExclusion {
		if v == nil {
			return nil
		}
		return v.Exclusions
	}).(AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutput)
}

type AnalyzerConfigurationUnusedAccessAnalysisRuleExclusion struct {
	// A list of account IDs to exclude from the analysis.
	AccountIds []string `pulumi:"accountIds"`
	// A list of key-value pairs for resource tags to exclude from the analysis.
	ResourceTags []map[string]string `pulumi:"resourceTags"`
}

// AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionInput is an input type that accepts AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArgs and AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutput values.
// You can construct a concrete instance of `AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionInput` via:
//
//	AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArgs{...}
type AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionInput interface {
	pulumi.Input

	ToAnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutput() AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutput
	ToAnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutputWithContext(context.Context) AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutput
}

type AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArgs struct {
	// A list of account IDs to exclude from the analysis.
	AccountIds pulumi.StringArrayInput `pulumi:"accountIds"`
	// A list of key-value pairs for resource tags to exclude from the analysis.
	ResourceTags pulumi.StringMapArrayInput `pulumi:"resourceTags"`
}

func (AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*AnalyzerConfigurationUnusedAccessAnalysisRuleExclusion)(nil)).Elem()
}

func (i AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArgs) ToAnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutput() AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutput {
	return i.ToAnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutputWithContext(context.Background())
}

func (i AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArgs) ToAnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutputWithContext(ctx context.Context) AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutput)
}

// AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayInput is an input type that accepts AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArray and AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutput values.
// You can construct a concrete instance of `AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayInput` via:
//
//	AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArray{ AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArgs{...} }
type AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayInput interface {
	pulumi.Input

	ToAnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutput() AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutput
	ToAnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutputWithContext(context.Context) AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutput
}

type AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArray []AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionInput

func (AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]AnalyzerConfigurationUnusedAccessAnalysisRuleExclusion)(nil)).Elem()
}

func (i AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArray) ToAnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutput() AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutput {
	return i.ToAnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutputWithContext(context.Background())
}

func (i AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArray) ToAnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutputWithContext(ctx context.Context) AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutput)
}

type AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutput struct{ *pulumi.OutputState }

func (AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*AnalyzerConfigurationUnusedAccessAnalysisRuleExclusion)(nil)).Elem()
}

func (o AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutput) ToAnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutput() AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutput {
	return o
}

func (o AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutput) ToAnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutputWithContext(ctx context.Context) AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutput {
	return o
}

// A list of account IDs to exclude from the analysis.
func (o AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutput) AccountIds() pulumi.StringArrayOutput {
	return o.ApplyT(func(v AnalyzerConfigurationUnusedAccessAnalysisRuleExclusion) []string { return v.AccountIds }).(pulumi.StringArrayOutput)
}

// A list of key-value pairs for resource tags to exclude from the analysis.
func (o AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutput) ResourceTags() pulumi.StringMapArrayOutput {
	return o.ApplyT(func(v AnalyzerConfigurationUnusedAccessAnalysisRuleExclusion) []map[string]string {
		return v.ResourceTags
	}).(pulumi.StringMapArrayOutput)
}

type AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutput struct{ *pulumi.OutputState }

func (AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]AnalyzerConfigurationUnusedAccessAnalysisRuleExclusion)(nil)).Elem()
}

func (o AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutput) ToAnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutput() AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutput {
	return o
}

func (o AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutput) ToAnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutputWithContext(ctx context.Context) AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutput {
	return o
}

func (o AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutput) Index(i pulumi.IntInput) AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) AnalyzerConfigurationUnusedAccessAnalysisRuleExclusion {
		return vs[0].([]AnalyzerConfigurationUnusedAccessAnalysisRuleExclusion)[vs[1].(int)]
	}).(AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutput)
}

type ArchiveRuleFilter struct {
	// Contains comparator.
	Contains []string `pulumi:"contains"`
	// Filter criteria.
	Criteria string `pulumi:"criteria"`
	// Equals comparator.
	Eqs []string `pulumi:"eqs"`
	// Boolean comparator.
	Exists *string `pulumi:"exists"`
	// Not Equals comparator.
	Neqs []string `pulumi:"neqs"`
}

// ArchiveRuleFilterInput is an input type that accepts ArchiveRuleFilterArgs and ArchiveRuleFilterOutput values.
// You can construct a concrete instance of `ArchiveRuleFilterInput` via:
//
//	ArchiveRuleFilterArgs{...}
type ArchiveRuleFilterInput interface {
	pulumi.Input

	ToArchiveRuleFilterOutput() ArchiveRuleFilterOutput
	ToArchiveRuleFilterOutputWithContext(context.Context) ArchiveRuleFilterOutput
}

type ArchiveRuleFilterArgs struct {
	// Contains comparator.
	Contains pulumi.StringArrayInput `pulumi:"contains"`
	// Filter criteria.
	Criteria pulumi.StringInput `pulumi:"criteria"`
	// Equals comparator.
	Eqs pulumi.StringArrayInput `pulumi:"eqs"`
	// Boolean comparator.
	Exists pulumi.StringPtrInput `pulumi:"exists"`
	// Not Equals comparator.
	Neqs pulumi.StringArrayInput `pulumi:"neqs"`
}

func (ArchiveRuleFilterArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*ArchiveRuleFilter)(nil)).Elem()
}

func (i ArchiveRuleFilterArgs) ToArchiveRuleFilterOutput() ArchiveRuleFilterOutput {
	return i.ToArchiveRuleFilterOutputWithContext(context.Background())
}

func (i ArchiveRuleFilterArgs) ToArchiveRuleFilterOutputWithContext(ctx context.Context) ArchiveRuleFilterOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ArchiveRuleFilterOutput)
}

// ArchiveRuleFilterArrayInput is an input type that accepts ArchiveRuleFilterArray and ArchiveRuleFilterArrayOutput values.
// You can construct a concrete instance of `ArchiveRuleFilterArrayInput` via:
//
//	ArchiveRuleFilterArray{ ArchiveRuleFilterArgs{...} }
type ArchiveRuleFilterArrayInput interface {
	pulumi.Input

	ToArchiveRuleFilterArrayOutput() ArchiveRuleFilterArrayOutput
	ToArchiveRuleFilterArrayOutputWithContext(context.Context) ArchiveRuleFilterArrayOutput
}

type ArchiveRuleFilterArray []ArchiveRuleFilterInput

func (ArchiveRuleFilterArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]ArchiveRuleFilter)(nil)).Elem()
}

func (i ArchiveRuleFilterArray) ToArchiveRuleFilterArrayOutput() ArchiveRuleFilterArrayOutput {
	return i.ToArchiveRuleFilterArrayOutputWithContext(context.Background())
}

func (i ArchiveRuleFilterArray) ToArchiveRuleFilterArrayOutputWithContext(ctx context.Context) ArchiveRuleFilterArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ArchiveRuleFilterArrayOutput)
}

type ArchiveRuleFilterOutput struct{ *pulumi.OutputState }

func (ArchiveRuleFilterOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*ArchiveRuleFilter)(nil)).Elem()
}

func (o ArchiveRuleFilterOutput) ToArchiveRuleFilterOutput() ArchiveRuleFilterOutput {
	return o
}

func (o ArchiveRuleFilterOutput) ToArchiveRuleFilterOutputWithContext(ctx context.Context) ArchiveRuleFilterOutput {
	return o
}

// Contains comparator.
func (o ArchiveRuleFilterOutput) Contains() pulumi.StringArrayOutput {
	return o.ApplyT(func(v ArchiveRuleFilter) []string { return v.Contains }).(pulumi.StringArrayOutput)
}

// Filter criteria.
func (o ArchiveRuleFilterOutput) Criteria() pulumi.StringOutput {
	return o.ApplyT(func(v ArchiveRuleFilter) string { return v.Criteria }).(pulumi.StringOutput)
}

// Equals comparator.
func (o ArchiveRuleFilterOutput) Eqs() pulumi.StringArrayOutput {
	return o.ApplyT(func(v ArchiveRuleFilter) []string { return v.Eqs }).(pulumi.StringArrayOutput)
}

// Boolean comparator.
func (o ArchiveRuleFilterOutput) Exists() pulumi.StringPtrOutput {
	return o.ApplyT(func(v ArchiveRuleFilter) *string { return v.Exists }).(pulumi.StringPtrOutput)
}

// Not Equals comparator.
func (o ArchiveRuleFilterOutput) Neqs() pulumi.StringArrayOutput {
	return o.ApplyT(func(v ArchiveRuleFilter) []string { return v.Neqs }).(pulumi.StringArrayOutput)
}

type ArchiveRuleFilterArrayOutput struct{ *pulumi.OutputState }

func (ArchiveRuleFilterArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]ArchiveRuleFilter)(nil)).Elem()
}

func (o ArchiveRuleFilterArrayOutput) ToArchiveRuleFilterArrayOutput() ArchiveRuleFilterArrayOutput {
	return o
}

func (o ArchiveRuleFilterArrayOutput) ToArchiveRuleFilterArrayOutputWithContext(ctx context.Context) ArchiveRuleFilterArrayOutput {
	return o
}

func (o ArchiveRuleFilterArrayOutput) Index(i pulumi.IntInput) ArchiveRuleFilterOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) ArchiveRuleFilter {
		return vs[0].([]ArchiveRuleFilter)[vs[1].(int)]
	}).(ArchiveRuleFilterOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*AnalyzerConfigurationInput)(nil)).Elem(), AnalyzerConfigurationArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*AnalyzerConfigurationPtrInput)(nil)).Elem(), AnalyzerConfigurationArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*AnalyzerConfigurationUnusedAccessInput)(nil)).Elem(), AnalyzerConfigurationUnusedAccessArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*AnalyzerConfigurationUnusedAccessPtrInput)(nil)).Elem(), AnalyzerConfigurationUnusedAccessArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*AnalyzerConfigurationUnusedAccessAnalysisRuleInput)(nil)).Elem(), AnalyzerConfigurationUnusedAccessAnalysisRuleArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*AnalyzerConfigurationUnusedAccessAnalysisRulePtrInput)(nil)).Elem(), AnalyzerConfigurationUnusedAccessAnalysisRuleArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionInput)(nil)).Elem(), AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayInput)(nil)).Elem(), AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ArchiveRuleFilterInput)(nil)).Elem(), ArchiveRuleFilterArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*ArchiveRuleFilterArrayInput)(nil)).Elem(), ArchiveRuleFilterArray{})
	pulumi.RegisterOutputType(AnalyzerConfigurationOutput{})
	pulumi.RegisterOutputType(AnalyzerConfigurationPtrOutput{})
	pulumi.RegisterOutputType(AnalyzerConfigurationUnusedAccessOutput{})
	pulumi.RegisterOutputType(AnalyzerConfigurationUnusedAccessPtrOutput{})
	pulumi.RegisterOutputType(AnalyzerConfigurationUnusedAccessAnalysisRuleOutput{})
	pulumi.RegisterOutputType(AnalyzerConfigurationUnusedAccessAnalysisRulePtrOutput{})
	pulumi.RegisterOutputType(AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionOutput{})
	pulumi.RegisterOutputType(AnalyzerConfigurationUnusedAccessAnalysisRuleExclusionArrayOutput{})
	pulumi.RegisterOutputType(ArchiveRuleFilterOutput{})
	pulumi.RegisterOutputType(ArchiveRuleFilterArrayOutput{})
}
