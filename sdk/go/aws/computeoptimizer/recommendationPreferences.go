// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package computeoptimizer

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Manages AWS Compute Optimizer recommendation preferences.
//
// ## Example Usage
//
// ### Lookback Period Preference
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/computeoptimizer"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := computeoptimizer.NewRecommendationPreferences(ctx, "example", &computeoptimizer.RecommendationPreferencesArgs{
//				ResourceType: pulumi.String("Ec2Instance"),
//				Scope: &computeoptimizer.RecommendationPreferencesScopeArgs{
//					Name:  pulumi.String("AccountId"),
//					Value: pulumi.String("123456789012"),
//				},
//				LookBackPeriod: pulumi.String("DAYS_32"),
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
// ### Multiple Preferences
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/computeoptimizer"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := computeoptimizer.NewRecommendationPreferences(ctx, "example", &computeoptimizer.RecommendationPreferencesArgs{
//				ResourceType: pulumi.String("Ec2Instance"),
//				Scope: &computeoptimizer.RecommendationPreferencesScopeArgs{
//					Name:  pulumi.String("AccountId"),
//					Value: pulumi.String("123456789012"),
//				},
//				EnhancedInfrastructureMetrics: pulumi.String("Active"),
//				ExternalMetricsPreference: &computeoptimizer.RecommendationPreferencesExternalMetricsPreferenceArgs{
//					Source: pulumi.String("Datadog"),
//				},
//				PreferredResources: computeoptimizer.RecommendationPreferencesPreferredResourceArray{
//					&computeoptimizer.RecommendationPreferencesPreferredResourceArgs{
//						IncludeLists: pulumi.StringArray{
//							pulumi.String("m5.xlarge"),
//							pulumi.String("r5"),
//						},
//						Name: pulumi.String("Ec2InstanceTypes"),
//					},
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
// Using `pulumi import`, import recommendation preferences using the resource type, scope name and scope value. For example:
//
// ```sh
// $ pulumi import aws:computeoptimizer/recommendationPreferences:RecommendationPreferences example Ec2Instance,AccountId,123456789012
// ```
type RecommendationPreferences struct {
	pulumi.CustomResourceState

	// The status of the enhanced infrastructure metrics recommendation preference. Valid values: `Active`, `Inactive`.
	EnhancedInfrastructureMetrics pulumi.StringPtrOutput `pulumi:"enhancedInfrastructureMetrics"`
	// The provider of the external metrics recommendation preference. See External Metrics Preference below.
	ExternalMetricsPreference RecommendationPreferencesExternalMetricsPreferencePtrOutput `pulumi:"externalMetricsPreference"`
	// The status of the inferred workload types recommendation preference. Valid values: `Active`, `Inactive`.
	InferredWorkloadTypes pulumi.StringPtrOutput `pulumi:"inferredWorkloadTypes"`
	// The preference to control the number of days the utilization metrics of the AWS resource are analyzed. Valid values: `DAYS_14`, `DAYS_32`, `DAYS_93`.
	LookBackPeriod pulumi.StringOutput `pulumi:"lookBackPeriod"`
	// The preference to control which resource type values are considered when generating rightsizing recommendations. See Preferred Resources below.
	PreferredResources RecommendationPreferencesPreferredResourceArrayOutput `pulumi:"preferredResources"`
	// The target resource type of the recommendation preferences. Valid values: `Ec2Instance`, `AutoScalingGroup`, `RdsDBInstance`.
	ResourceType pulumi.StringOutput `pulumi:"resourceType"`
	// The status of the savings estimation mode preference. Valid values: `AfterDiscounts`, `BeforeDiscounts`.
	SavingsEstimationMode pulumi.StringPtrOutput `pulumi:"savingsEstimationMode"`
	// The scope of the recommendation preferences. See Scope below.
	Scope RecommendationPreferencesScopePtrOutput `pulumi:"scope"`
	// The preference to control the resource’s CPU utilization threshold, CPU utilization headroom, and memory utilization headroom. See Utilization Preferences below.
	UtilizationPreferences RecommendationPreferencesUtilizationPreferenceArrayOutput `pulumi:"utilizationPreferences"`
}

// NewRecommendationPreferences registers a new resource with the given unique name, arguments, and options.
func NewRecommendationPreferences(ctx *pulumi.Context,
	name string, args *RecommendationPreferencesArgs, opts ...pulumi.ResourceOption) (*RecommendationPreferences, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.ResourceType == nil {
		return nil, errors.New("invalid value for required argument 'ResourceType'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource RecommendationPreferences
	err := ctx.RegisterResource("aws:computeoptimizer/recommendationPreferences:RecommendationPreferences", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetRecommendationPreferences gets an existing RecommendationPreferences resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetRecommendationPreferences(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *RecommendationPreferencesState, opts ...pulumi.ResourceOption) (*RecommendationPreferences, error) {
	var resource RecommendationPreferences
	err := ctx.ReadResource("aws:computeoptimizer/recommendationPreferences:RecommendationPreferences", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering RecommendationPreferences resources.
type recommendationPreferencesState struct {
	// The status of the enhanced infrastructure metrics recommendation preference. Valid values: `Active`, `Inactive`.
	EnhancedInfrastructureMetrics *string `pulumi:"enhancedInfrastructureMetrics"`
	// The provider of the external metrics recommendation preference. See External Metrics Preference below.
	ExternalMetricsPreference *RecommendationPreferencesExternalMetricsPreference `pulumi:"externalMetricsPreference"`
	// The status of the inferred workload types recommendation preference. Valid values: `Active`, `Inactive`.
	InferredWorkloadTypes *string `pulumi:"inferredWorkloadTypes"`
	// The preference to control the number of days the utilization metrics of the AWS resource are analyzed. Valid values: `DAYS_14`, `DAYS_32`, `DAYS_93`.
	LookBackPeriod *string `pulumi:"lookBackPeriod"`
	// The preference to control which resource type values are considered when generating rightsizing recommendations. See Preferred Resources below.
	PreferredResources []RecommendationPreferencesPreferredResource `pulumi:"preferredResources"`
	// The target resource type of the recommendation preferences. Valid values: `Ec2Instance`, `AutoScalingGroup`, `RdsDBInstance`.
	ResourceType *string `pulumi:"resourceType"`
	// The status of the savings estimation mode preference. Valid values: `AfterDiscounts`, `BeforeDiscounts`.
	SavingsEstimationMode *string `pulumi:"savingsEstimationMode"`
	// The scope of the recommendation preferences. See Scope below.
	Scope *RecommendationPreferencesScope `pulumi:"scope"`
	// The preference to control the resource’s CPU utilization threshold, CPU utilization headroom, and memory utilization headroom. See Utilization Preferences below.
	UtilizationPreferences []RecommendationPreferencesUtilizationPreference `pulumi:"utilizationPreferences"`
}

type RecommendationPreferencesState struct {
	// The status of the enhanced infrastructure metrics recommendation preference. Valid values: `Active`, `Inactive`.
	EnhancedInfrastructureMetrics pulumi.StringPtrInput
	// The provider of the external metrics recommendation preference. See External Metrics Preference below.
	ExternalMetricsPreference RecommendationPreferencesExternalMetricsPreferencePtrInput
	// The status of the inferred workload types recommendation preference. Valid values: `Active`, `Inactive`.
	InferredWorkloadTypes pulumi.StringPtrInput
	// The preference to control the number of days the utilization metrics of the AWS resource are analyzed. Valid values: `DAYS_14`, `DAYS_32`, `DAYS_93`.
	LookBackPeriod pulumi.StringPtrInput
	// The preference to control which resource type values are considered when generating rightsizing recommendations. See Preferred Resources below.
	PreferredResources RecommendationPreferencesPreferredResourceArrayInput
	// The target resource type of the recommendation preferences. Valid values: `Ec2Instance`, `AutoScalingGroup`, `RdsDBInstance`.
	ResourceType pulumi.StringPtrInput
	// The status of the savings estimation mode preference. Valid values: `AfterDiscounts`, `BeforeDiscounts`.
	SavingsEstimationMode pulumi.StringPtrInput
	// The scope of the recommendation preferences. See Scope below.
	Scope RecommendationPreferencesScopePtrInput
	// The preference to control the resource’s CPU utilization threshold, CPU utilization headroom, and memory utilization headroom. See Utilization Preferences below.
	UtilizationPreferences RecommendationPreferencesUtilizationPreferenceArrayInput
}

func (RecommendationPreferencesState) ElementType() reflect.Type {
	return reflect.TypeOf((*recommendationPreferencesState)(nil)).Elem()
}

type recommendationPreferencesArgs struct {
	// The status of the enhanced infrastructure metrics recommendation preference. Valid values: `Active`, `Inactive`.
	EnhancedInfrastructureMetrics *string `pulumi:"enhancedInfrastructureMetrics"`
	// The provider of the external metrics recommendation preference. See External Metrics Preference below.
	ExternalMetricsPreference *RecommendationPreferencesExternalMetricsPreference `pulumi:"externalMetricsPreference"`
	// The status of the inferred workload types recommendation preference. Valid values: `Active`, `Inactive`.
	InferredWorkloadTypes *string `pulumi:"inferredWorkloadTypes"`
	// The preference to control the number of days the utilization metrics of the AWS resource are analyzed. Valid values: `DAYS_14`, `DAYS_32`, `DAYS_93`.
	LookBackPeriod *string `pulumi:"lookBackPeriod"`
	// The preference to control which resource type values are considered when generating rightsizing recommendations. See Preferred Resources below.
	PreferredResources []RecommendationPreferencesPreferredResource `pulumi:"preferredResources"`
	// The target resource type of the recommendation preferences. Valid values: `Ec2Instance`, `AutoScalingGroup`, `RdsDBInstance`.
	ResourceType string `pulumi:"resourceType"`
	// The status of the savings estimation mode preference. Valid values: `AfterDiscounts`, `BeforeDiscounts`.
	SavingsEstimationMode *string `pulumi:"savingsEstimationMode"`
	// The scope of the recommendation preferences. See Scope below.
	Scope *RecommendationPreferencesScope `pulumi:"scope"`
	// The preference to control the resource’s CPU utilization threshold, CPU utilization headroom, and memory utilization headroom. See Utilization Preferences below.
	UtilizationPreferences []RecommendationPreferencesUtilizationPreference `pulumi:"utilizationPreferences"`
}

// The set of arguments for constructing a RecommendationPreferences resource.
type RecommendationPreferencesArgs struct {
	// The status of the enhanced infrastructure metrics recommendation preference. Valid values: `Active`, `Inactive`.
	EnhancedInfrastructureMetrics pulumi.StringPtrInput
	// The provider of the external metrics recommendation preference. See External Metrics Preference below.
	ExternalMetricsPreference RecommendationPreferencesExternalMetricsPreferencePtrInput
	// The status of the inferred workload types recommendation preference. Valid values: `Active`, `Inactive`.
	InferredWorkloadTypes pulumi.StringPtrInput
	// The preference to control the number of days the utilization metrics of the AWS resource are analyzed. Valid values: `DAYS_14`, `DAYS_32`, `DAYS_93`.
	LookBackPeriod pulumi.StringPtrInput
	// The preference to control which resource type values are considered when generating rightsizing recommendations. See Preferred Resources below.
	PreferredResources RecommendationPreferencesPreferredResourceArrayInput
	// The target resource type of the recommendation preferences. Valid values: `Ec2Instance`, `AutoScalingGroup`, `RdsDBInstance`.
	ResourceType pulumi.StringInput
	// The status of the savings estimation mode preference. Valid values: `AfterDiscounts`, `BeforeDiscounts`.
	SavingsEstimationMode pulumi.StringPtrInput
	// The scope of the recommendation preferences. See Scope below.
	Scope RecommendationPreferencesScopePtrInput
	// The preference to control the resource’s CPU utilization threshold, CPU utilization headroom, and memory utilization headroom. See Utilization Preferences below.
	UtilizationPreferences RecommendationPreferencesUtilizationPreferenceArrayInput
}

func (RecommendationPreferencesArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*recommendationPreferencesArgs)(nil)).Elem()
}

type RecommendationPreferencesInput interface {
	pulumi.Input

	ToRecommendationPreferencesOutput() RecommendationPreferencesOutput
	ToRecommendationPreferencesOutputWithContext(ctx context.Context) RecommendationPreferencesOutput
}

func (*RecommendationPreferences) ElementType() reflect.Type {
	return reflect.TypeOf((**RecommendationPreferences)(nil)).Elem()
}

func (i *RecommendationPreferences) ToRecommendationPreferencesOutput() RecommendationPreferencesOutput {
	return i.ToRecommendationPreferencesOutputWithContext(context.Background())
}

func (i *RecommendationPreferences) ToRecommendationPreferencesOutputWithContext(ctx context.Context) RecommendationPreferencesOutput {
	return pulumi.ToOutputWithContext(ctx, i).(RecommendationPreferencesOutput)
}

// RecommendationPreferencesArrayInput is an input type that accepts RecommendationPreferencesArray and RecommendationPreferencesArrayOutput values.
// You can construct a concrete instance of `RecommendationPreferencesArrayInput` via:
//
//	RecommendationPreferencesArray{ RecommendationPreferencesArgs{...} }
type RecommendationPreferencesArrayInput interface {
	pulumi.Input

	ToRecommendationPreferencesArrayOutput() RecommendationPreferencesArrayOutput
	ToRecommendationPreferencesArrayOutputWithContext(context.Context) RecommendationPreferencesArrayOutput
}

type RecommendationPreferencesArray []RecommendationPreferencesInput

func (RecommendationPreferencesArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*RecommendationPreferences)(nil)).Elem()
}

func (i RecommendationPreferencesArray) ToRecommendationPreferencesArrayOutput() RecommendationPreferencesArrayOutput {
	return i.ToRecommendationPreferencesArrayOutputWithContext(context.Background())
}

func (i RecommendationPreferencesArray) ToRecommendationPreferencesArrayOutputWithContext(ctx context.Context) RecommendationPreferencesArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(RecommendationPreferencesArrayOutput)
}

// RecommendationPreferencesMapInput is an input type that accepts RecommendationPreferencesMap and RecommendationPreferencesMapOutput values.
// You can construct a concrete instance of `RecommendationPreferencesMapInput` via:
//
//	RecommendationPreferencesMap{ "key": RecommendationPreferencesArgs{...} }
type RecommendationPreferencesMapInput interface {
	pulumi.Input

	ToRecommendationPreferencesMapOutput() RecommendationPreferencesMapOutput
	ToRecommendationPreferencesMapOutputWithContext(context.Context) RecommendationPreferencesMapOutput
}

type RecommendationPreferencesMap map[string]RecommendationPreferencesInput

func (RecommendationPreferencesMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*RecommendationPreferences)(nil)).Elem()
}

func (i RecommendationPreferencesMap) ToRecommendationPreferencesMapOutput() RecommendationPreferencesMapOutput {
	return i.ToRecommendationPreferencesMapOutputWithContext(context.Background())
}

func (i RecommendationPreferencesMap) ToRecommendationPreferencesMapOutputWithContext(ctx context.Context) RecommendationPreferencesMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(RecommendationPreferencesMapOutput)
}

type RecommendationPreferencesOutput struct{ *pulumi.OutputState }

func (RecommendationPreferencesOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**RecommendationPreferences)(nil)).Elem()
}

func (o RecommendationPreferencesOutput) ToRecommendationPreferencesOutput() RecommendationPreferencesOutput {
	return o
}

func (o RecommendationPreferencesOutput) ToRecommendationPreferencesOutputWithContext(ctx context.Context) RecommendationPreferencesOutput {
	return o
}

// The status of the enhanced infrastructure metrics recommendation preference. Valid values: `Active`, `Inactive`.
func (o RecommendationPreferencesOutput) EnhancedInfrastructureMetrics() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *RecommendationPreferences) pulumi.StringPtrOutput { return v.EnhancedInfrastructureMetrics }).(pulumi.StringPtrOutput)
}

// The provider of the external metrics recommendation preference. See External Metrics Preference below.
func (o RecommendationPreferencesOutput) ExternalMetricsPreference() RecommendationPreferencesExternalMetricsPreferencePtrOutput {
	return o.ApplyT(func(v *RecommendationPreferences) RecommendationPreferencesExternalMetricsPreferencePtrOutput {
		return v.ExternalMetricsPreference
	}).(RecommendationPreferencesExternalMetricsPreferencePtrOutput)
}

// The status of the inferred workload types recommendation preference. Valid values: `Active`, `Inactive`.
func (o RecommendationPreferencesOutput) InferredWorkloadTypes() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *RecommendationPreferences) pulumi.StringPtrOutput { return v.InferredWorkloadTypes }).(pulumi.StringPtrOutput)
}

// The preference to control the number of days the utilization metrics of the AWS resource are analyzed. Valid values: `DAYS_14`, `DAYS_32`, `DAYS_93`.
func (o RecommendationPreferencesOutput) LookBackPeriod() pulumi.StringOutput {
	return o.ApplyT(func(v *RecommendationPreferences) pulumi.StringOutput { return v.LookBackPeriod }).(pulumi.StringOutput)
}

// The preference to control which resource type values are considered when generating rightsizing recommendations. See Preferred Resources below.
func (o RecommendationPreferencesOutput) PreferredResources() RecommendationPreferencesPreferredResourceArrayOutput {
	return o.ApplyT(func(v *RecommendationPreferences) RecommendationPreferencesPreferredResourceArrayOutput {
		return v.PreferredResources
	}).(RecommendationPreferencesPreferredResourceArrayOutput)
}

// The target resource type of the recommendation preferences. Valid values: `Ec2Instance`, `AutoScalingGroup`, `RdsDBInstance`.
func (o RecommendationPreferencesOutput) ResourceType() pulumi.StringOutput {
	return o.ApplyT(func(v *RecommendationPreferences) pulumi.StringOutput { return v.ResourceType }).(pulumi.StringOutput)
}

// The status of the savings estimation mode preference. Valid values: `AfterDiscounts`, `BeforeDiscounts`.
func (o RecommendationPreferencesOutput) SavingsEstimationMode() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *RecommendationPreferences) pulumi.StringPtrOutput { return v.SavingsEstimationMode }).(pulumi.StringPtrOutput)
}

// The scope of the recommendation preferences. See Scope below.
func (o RecommendationPreferencesOutput) Scope() RecommendationPreferencesScopePtrOutput {
	return o.ApplyT(func(v *RecommendationPreferences) RecommendationPreferencesScopePtrOutput { return v.Scope }).(RecommendationPreferencesScopePtrOutput)
}

// The preference to control the resource’s CPU utilization threshold, CPU utilization headroom, and memory utilization headroom. See Utilization Preferences below.
func (o RecommendationPreferencesOutput) UtilizationPreferences() RecommendationPreferencesUtilizationPreferenceArrayOutput {
	return o.ApplyT(func(v *RecommendationPreferences) RecommendationPreferencesUtilizationPreferenceArrayOutput {
		return v.UtilizationPreferences
	}).(RecommendationPreferencesUtilizationPreferenceArrayOutput)
}

type RecommendationPreferencesArrayOutput struct{ *pulumi.OutputState }

func (RecommendationPreferencesArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*RecommendationPreferences)(nil)).Elem()
}

func (o RecommendationPreferencesArrayOutput) ToRecommendationPreferencesArrayOutput() RecommendationPreferencesArrayOutput {
	return o
}

func (o RecommendationPreferencesArrayOutput) ToRecommendationPreferencesArrayOutputWithContext(ctx context.Context) RecommendationPreferencesArrayOutput {
	return o
}

func (o RecommendationPreferencesArrayOutput) Index(i pulumi.IntInput) RecommendationPreferencesOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *RecommendationPreferences {
		return vs[0].([]*RecommendationPreferences)[vs[1].(int)]
	}).(RecommendationPreferencesOutput)
}

type RecommendationPreferencesMapOutput struct{ *pulumi.OutputState }

func (RecommendationPreferencesMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*RecommendationPreferences)(nil)).Elem()
}

func (o RecommendationPreferencesMapOutput) ToRecommendationPreferencesMapOutput() RecommendationPreferencesMapOutput {
	return o
}

func (o RecommendationPreferencesMapOutput) ToRecommendationPreferencesMapOutputWithContext(ctx context.Context) RecommendationPreferencesMapOutput {
	return o
}

func (o RecommendationPreferencesMapOutput) MapIndex(k pulumi.StringInput) RecommendationPreferencesOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *RecommendationPreferences {
		return vs[0].(map[string]*RecommendationPreferences)[vs[1].(string)]
	}).(RecommendationPreferencesOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*RecommendationPreferencesInput)(nil)).Elem(), &RecommendationPreferences{})
	pulumi.RegisterInputType(reflect.TypeOf((*RecommendationPreferencesArrayInput)(nil)).Elem(), RecommendationPreferencesArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*RecommendationPreferencesMapInput)(nil)).Elem(), RecommendationPreferencesMap{})
	pulumi.RegisterOutputType(RecommendationPreferencesOutput{})
	pulumi.RegisterOutputType(RecommendationPreferencesArrayOutput{})
	pulumi.RegisterOutputType(RecommendationPreferencesMapOutput{})
}
