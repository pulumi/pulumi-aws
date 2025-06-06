// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package redshift

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Creates a new Amazon Redshift Usage Limit.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/redshift"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := redshift.NewUsageLimit(ctx, "example", &redshift.UsageLimitArgs{
//				ClusterIdentifier: pulumi.Any(exampleAwsRedshiftCluster.Id),
//				FeatureType:       pulumi.String("concurrency-scaling"),
//				LimitType:         pulumi.String("time"),
//				Amount:            pulumi.Int(60),
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
// Using `pulumi import`, import Redshift usage limits using the `id`. For example:
//
// ```sh
// $ pulumi import aws:redshift/usageLimit:UsageLimit example example-id
// ```
type UsageLimit struct {
	pulumi.CustomResourceState

	// The limit amount. If time-based, this amount is in minutes. If data-based, this amount is in terabytes (TB). The value must be a positive number.
	Amount pulumi.IntOutput `pulumi:"amount"`
	// Amazon Resource Name (ARN) of the Redshift Usage Limit.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// The action that Amazon Redshift takes when the limit is reached. The default is `log`. Valid values are `log`, `emit-metric`, and `disable`.
	BreachAction pulumi.StringPtrOutput `pulumi:"breachAction"`
	// The identifier of the cluster that you want to limit usage.
	ClusterIdentifier pulumi.StringOutput `pulumi:"clusterIdentifier"`
	// The Amazon Redshift feature that you want to limit. Valid values are `spectrum`, `concurrency-scaling`, and `cross-region-datasharing`.
	FeatureType pulumi.StringOutput `pulumi:"featureType"`
	// The type of limit. Depending on the feature type, this can be based on a time duration or data size. If FeatureType is `spectrum`, then LimitType must be `data-scanned`. If FeatureType is `concurrency-scaling`, then LimitType must be `time`. If FeatureType is `cross-region-datasharing`, then LimitType must be `data-scanned`. Valid values are `data-scanned`, and `time`.
	LimitType pulumi.StringOutput `pulumi:"limitType"`
	// The time period that the amount applies to. A weekly period begins on Sunday. The default is `monthly`. Valid values are `daily`, `weekly`, and `monthly`.
	Period pulumi.StringPtrOutput `pulumi:"period"`
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewUsageLimit registers a new resource with the given unique name, arguments, and options.
func NewUsageLimit(ctx *pulumi.Context,
	name string, args *UsageLimitArgs, opts ...pulumi.ResourceOption) (*UsageLimit, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.Amount == nil {
		return nil, errors.New("invalid value for required argument 'Amount'")
	}
	if args.ClusterIdentifier == nil {
		return nil, errors.New("invalid value for required argument 'ClusterIdentifier'")
	}
	if args.FeatureType == nil {
		return nil, errors.New("invalid value for required argument 'FeatureType'")
	}
	if args.LimitType == nil {
		return nil, errors.New("invalid value for required argument 'LimitType'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource UsageLimit
	err := ctx.RegisterResource("aws:redshift/usageLimit:UsageLimit", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetUsageLimit gets an existing UsageLimit resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetUsageLimit(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *UsageLimitState, opts ...pulumi.ResourceOption) (*UsageLimit, error) {
	var resource UsageLimit
	err := ctx.ReadResource("aws:redshift/usageLimit:UsageLimit", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering UsageLimit resources.
type usageLimitState struct {
	// The limit amount. If time-based, this amount is in minutes. If data-based, this amount is in terabytes (TB). The value must be a positive number.
	Amount *int `pulumi:"amount"`
	// Amazon Resource Name (ARN) of the Redshift Usage Limit.
	Arn *string `pulumi:"arn"`
	// The action that Amazon Redshift takes when the limit is reached. The default is `log`. Valid values are `log`, `emit-metric`, and `disable`.
	BreachAction *string `pulumi:"breachAction"`
	// The identifier of the cluster that you want to limit usage.
	ClusterIdentifier *string `pulumi:"clusterIdentifier"`
	// The Amazon Redshift feature that you want to limit. Valid values are `spectrum`, `concurrency-scaling`, and `cross-region-datasharing`.
	FeatureType *string `pulumi:"featureType"`
	// The type of limit. Depending on the feature type, this can be based on a time duration or data size. If FeatureType is `spectrum`, then LimitType must be `data-scanned`. If FeatureType is `concurrency-scaling`, then LimitType must be `time`. If FeatureType is `cross-region-datasharing`, then LimitType must be `data-scanned`. Valid values are `data-scanned`, and `time`.
	LimitType *string `pulumi:"limitType"`
	// The time period that the amount applies to. A weekly period begins on Sunday. The default is `monthly`. Valid values are `daily`, `weekly`, and `monthly`.
	Period *string `pulumi:"period"`
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type UsageLimitState struct {
	// The limit amount. If time-based, this amount is in minutes. If data-based, this amount is in terabytes (TB). The value must be a positive number.
	Amount pulumi.IntPtrInput
	// Amazon Resource Name (ARN) of the Redshift Usage Limit.
	Arn pulumi.StringPtrInput
	// The action that Amazon Redshift takes when the limit is reached. The default is `log`. Valid values are `log`, `emit-metric`, and `disable`.
	BreachAction pulumi.StringPtrInput
	// The identifier of the cluster that you want to limit usage.
	ClusterIdentifier pulumi.StringPtrInput
	// The Amazon Redshift feature that you want to limit. Valid values are `spectrum`, `concurrency-scaling`, and `cross-region-datasharing`.
	FeatureType pulumi.StringPtrInput
	// The type of limit. Depending on the feature type, this can be based on a time duration or data size. If FeatureType is `spectrum`, then LimitType must be `data-scanned`. If FeatureType is `concurrency-scaling`, then LimitType must be `time`. If FeatureType is `cross-region-datasharing`, then LimitType must be `data-scanned`. Valid values are `data-scanned`, and `time`.
	LimitType pulumi.StringPtrInput
	// The time period that the amount applies to. A weekly period begins on Sunday. The default is `monthly`. Valid values are `daily`, `weekly`, and `monthly`.
	Period pulumi.StringPtrInput
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (UsageLimitState) ElementType() reflect.Type {
	return reflect.TypeOf((*usageLimitState)(nil)).Elem()
}

type usageLimitArgs struct {
	// The limit amount. If time-based, this amount is in minutes. If data-based, this amount is in terabytes (TB). The value must be a positive number.
	Amount int `pulumi:"amount"`
	// The action that Amazon Redshift takes when the limit is reached. The default is `log`. Valid values are `log`, `emit-metric`, and `disable`.
	BreachAction *string `pulumi:"breachAction"`
	// The identifier of the cluster that you want to limit usage.
	ClusterIdentifier string `pulumi:"clusterIdentifier"`
	// The Amazon Redshift feature that you want to limit. Valid values are `spectrum`, `concurrency-scaling`, and `cross-region-datasharing`.
	FeatureType string `pulumi:"featureType"`
	// The type of limit. Depending on the feature type, this can be based on a time duration or data size. If FeatureType is `spectrum`, then LimitType must be `data-scanned`. If FeatureType is `concurrency-scaling`, then LimitType must be `time`. If FeatureType is `cross-region-datasharing`, then LimitType must be `data-scanned`. Valid values are `data-scanned`, and `time`.
	LimitType string `pulumi:"limitType"`
	// The time period that the amount applies to. A weekly period begins on Sunday. The default is `monthly`. Valid values are `daily`, `weekly`, and `monthly`.
	Period *string `pulumi:"period"`
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a UsageLimit resource.
type UsageLimitArgs struct {
	// The limit amount. If time-based, this amount is in minutes. If data-based, this amount is in terabytes (TB). The value must be a positive number.
	Amount pulumi.IntInput
	// The action that Amazon Redshift takes when the limit is reached. The default is `log`. Valid values are `log`, `emit-metric`, and `disable`.
	BreachAction pulumi.StringPtrInput
	// The identifier of the cluster that you want to limit usage.
	ClusterIdentifier pulumi.StringInput
	// The Amazon Redshift feature that you want to limit. Valid values are `spectrum`, `concurrency-scaling`, and `cross-region-datasharing`.
	FeatureType pulumi.StringInput
	// The type of limit. Depending on the feature type, this can be based on a time duration or data size. If FeatureType is `spectrum`, then LimitType must be `data-scanned`. If FeatureType is `concurrency-scaling`, then LimitType must be `time`. If FeatureType is `cross-region-datasharing`, then LimitType must be `data-scanned`. Valid values are `data-scanned`, and `time`.
	LimitType pulumi.StringInput
	// The time period that the amount applies to. A weekly period begins on Sunday. The default is `monthly`. Valid values are `daily`, `weekly`, and `monthly`.
	Period pulumi.StringPtrInput
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (UsageLimitArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*usageLimitArgs)(nil)).Elem()
}

type UsageLimitInput interface {
	pulumi.Input

	ToUsageLimitOutput() UsageLimitOutput
	ToUsageLimitOutputWithContext(ctx context.Context) UsageLimitOutput
}

func (*UsageLimit) ElementType() reflect.Type {
	return reflect.TypeOf((**UsageLimit)(nil)).Elem()
}

func (i *UsageLimit) ToUsageLimitOutput() UsageLimitOutput {
	return i.ToUsageLimitOutputWithContext(context.Background())
}

func (i *UsageLimit) ToUsageLimitOutputWithContext(ctx context.Context) UsageLimitOutput {
	return pulumi.ToOutputWithContext(ctx, i).(UsageLimitOutput)
}

// UsageLimitArrayInput is an input type that accepts UsageLimitArray and UsageLimitArrayOutput values.
// You can construct a concrete instance of `UsageLimitArrayInput` via:
//
//	UsageLimitArray{ UsageLimitArgs{...} }
type UsageLimitArrayInput interface {
	pulumi.Input

	ToUsageLimitArrayOutput() UsageLimitArrayOutput
	ToUsageLimitArrayOutputWithContext(context.Context) UsageLimitArrayOutput
}

type UsageLimitArray []UsageLimitInput

func (UsageLimitArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*UsageLimit)(nil)).Elem()
}

func (i UsageLimitArray) ToUsageLimitArrayOutput() UsageLimitArrayOutput {
	return i.ToUsageLimitArrayOutputWithContext(context.Background())
}

func (i UsageLimitArray) ToUsageLimitArrayOutputWithContext(ctx context.Context) UsageLimitArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(UsageLimitArrayOutput)
}

// UsageLimitMapInput is an input type that accepts UsageLimitMap and UsageLimitMapOutput values.
// You can construct a concrete instance of `UsageLimitMapInput` via:
//
//	UsageLimitMap{ "key": UsageLimitArgs{...} }
type UsageLimitMapInput interface {
	pulumi.Input

	ToUsageLimitMapOutput() UsageLimitMapOutput
	ToUsageLimitMapOutputWithContext(context.Context) UsageLimitMapOutput
}

type UsageLimitMap map[string]UsageLimitInput

func (UsageLimitMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*UsageLimit)(nil)).Elem()
}

func (i UsageLimitMap) ToUsageLimitMapOutput() UsageLimitMapOutput {
	return i.ToUsageLimitMapOutputWithContext(context.Background())
}

func (i UsageLimitMap) ToUsageLimitMapOutputWithContext(ctx context.Context) UsageLimitMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(UsageLimitMapOutput)
}

type UsageLimitOutput struct{ *pulumi.OutputState }

func (UsageLimitOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**UsageLimit)(nil)).Elem()
}

func (o UsageLimitOutput) ToUsageLimitOutput() UsageLimitOutput {
	return o
}

func (o UsageLimitOutput) ToUsageLimitOutputWithContext(ctx context.Context) UsageLimitOutput {
	return o
}

// The limit amount. If time-based, this amount is in minutes. If data-based, this amount is in terabytes (TB). The value must be a positive number.
func (o UsageLimitOutput) Amount() pulumi.IntOutput {
	return o.ApplyT(func(v *UsageLimit) pulumi.IntOutput { return v.Amount }).(pulumi.IntOutput)
}

// Amazon Resource Name (ARN) of the Redshift Usage Limit.
func (o UsageLimitOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *UsageLimit) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// The action that Amazon Redshift takes when the limit is reached. The default is `log`. Valid values are `log`, `emit-metric`, and `disable`.
func (o UsageLimitOutput) BreachAction() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *UsageLimit) pulumi.StringPtrOutput { return v.BreachAction }).(pulumi.StringPtrOutput)
}

// The identifier of the cluster that you want to limit usage.
func (o UsageLimitOutput) ClusterIdentifier() pulumi.StringOutput {
	return o.ApplyT(func(v *UsageLimit) pulumi.StringOutput { return v.ClusterIdentifier }).(pulumi.StringOutput)
}

// The Amazon Redshift feature that you want to limit. Valid values are `spectrum`, `concurrency-scaling`, and `cross-region-datasharing`.
func (o UsageLimitOutput) FeatureType() pulumi.StringOutput {
	return o.ApplyT(func(v *UsageLimit) pulumi.StringOutput { return v.FeatureType }).(pulumi.StringOutput)
}

// The type of limit. Depending on the feature type, this can be based on a time duration or data size. If FeatureType is `spectrum`, then LimitType must be `data-scanned`. If FeatureType is `concurrency-scaling`, then LimitType must be `time`. If FeatureType is `cross-region-datasharing`, then LimitType must be `data-scanned`. Valid values are `data-scanned`, and `time`.
func (o UsageLimitOutput) LimitType() pulumi.StringOutput {
	return o.ApplyT(func(v *UsageLimit) pulumi.StringOutput { return v.LimitType }).(pulumi.StringOutput)
}

// The time period that the amount applies to. A weekly period begins on Sunday. The default is `monthly`. Valid values are `daily`, `weekly`, and `monthly`.
func (o UsageLimitOutput) Period() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *UsageLimit) pulumi.StringPtrOutput { return v.Period }).(pulumi.StringPtrOutput)
}

// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o UsageLimitOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *UsageLimit) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o UsageLimitOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *UsageLimit) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type UsageLimitArrayOutput struct{ *pulumi.OutputState }

func (UsageLimitArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*UsageLimit)(nil)).Elem()
}

func (o UsageLimitArrayOutput) ToUsageLimitArrayOutput() UsageLimitArrayOutput {
	return o
}

func (o UsageLimitArrayOutput) ToUsageLimitArrayOutputWithContext(ctx context.Context) UsageLimitArrayOutput {
	return o
}

func (o UsageLimitArrayOutput) Index(i pulumi.IntInput) UsageLimitOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *UsageLimit {
		return vs[0].([]*UsageLimit)[vs[1].(int)]
	}).(UsageLimitOutput)
}

type UsageLimitMapOutput struct{ *pulumi.OutputState }

func (UsageLimitMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*UsageLimit)(nil)).Elem()
}

func (o UsageLimitMapOutput) ToUsageLimitMapOutput() UsageLimitMapOutput {
	return o
}

func (o UsageLimitMapOutput) ToUsageLimitMapOutputWithContext(ctx context.Context) UsageLimitMapOutput {
	return o
}

func (o UsageLimitMapOutput) MapIndex(k pulumi.StringInput) UsageLimitOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *UsageLimit {
		return vs[0].(map[string]*UsageLimit)[vs[1].(string)]
	}).(UsageLimitOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*UsageLimitInput)(nil)).Elem(), &UsageLimit{})
	pulumi.RegisterInputType(reflect.TypeOf((*UsageLimitArrayInput)(nil)).Elem(), UsageLimitArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*UsageLimitMapInput)(nil)).Elem(), UsageLimitMap{})
	pulumi.RegisterOutputType(UsageLimitOutput{})
	pulumi.RegisterOutputType(UsageLimitArrayOutput{})
	pulumi.RegisterOutputType(UsageLimitMapOutput{})
}
