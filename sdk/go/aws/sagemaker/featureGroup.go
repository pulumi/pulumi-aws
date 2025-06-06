// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package sagemaker

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a SageMaker AI Feature Group resource.
//
// ## Example Usage
//
// Basic usage:
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/sagemaker"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := sagemaker.NewFeatureGroup(ctx, "example", &sagemaker.FeatureGroupArgs{
//				FeatureGroupName:            pulumi.String("example"),
//				RecordIdentifierFeatureName: pulumi.String("example"),
//				EventTimeFeatureName:        pulumi.String("example"),
//				RoleArn:                     pulumi.Any(test.Arn),
//				FeatureDefinitions: sagemaker.FeatureGroupFeatureDefinitionArray{
//					&sagemaker.FeatureGroupFeatureDefinitionArgs{
//						FeatureName: pulumi.String("example"),
//						FeatureType: pulumi.String("String"),
//					},
//				},
//				OnlineStoreConfig: &sagemaker.FeatureGroupOnlineStoreConfigArgs{
//					EnableOnlineStore: pulumi.Bool(true),
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
// Using `pulumi import`, import Feature Groups using the `name`. For example:
//
// ```sh
// $ pulumi import aws:sagemaker/featureGroup:FeatureGroup test_feature_group feature_group-foo
// ```
type FeatureGroup struct {
	pulumi.CustomResourceState

	// The Amazon Resource Name (ARN) assigned by AWS to this feature_group.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// A free-form description of a Feature Group.
	Description pulumi.StringPtrOutput `pulumi:"description"`
	// The name of the feature that stores the EventTime of a Record in a Feature Group.
	EventTimeFeatureName pulumi.StringOutput `pulumi:"eventTimeFeatureName"`
	// A list of Feature names and types. See Feature Definition Below.
	FeatureDefinitions FeatureGroupFeatureDefinitionArrayOutput `pulumi:"featureDefinitions"`
	// The name of the Feature Group. The name must be unique within an AWS Region in an AWS account.
	FeatureGroupName pulumi.StringOutput `pulumi:"featureGroupName"`
	// The Offline Feature Store Configuration. See Offline Store Config Below.
	OfflineStoreConfig FeatureGroupOfflineStoreConfigPtrOutput `pulumi:"offlineStoreConfig"`
	// The Online Feature Store Configuration. See Online Store Config Below.
	OnlineStoreConfig FeatureGroupOnlineStoreConfigPtrOutput `pulumi:"onlineStoreConfig"`
	// The name of the Feature whose value uniquely identifies a Record defined in the Feature Store. Only the latest record per identifier value will be stored in the Online Store.
	RecordIdentifierFeatureName pulumi.StringOutput `pulumi:"recordIdentifierFeatureName"`
	// The Amazon Resource Name (ARN) of the IAM execution role used to persist data into the Offline Store if an `offlineStoreConfig` is provided.
	RoleArn pulumi.StringOutput `pulumi:"roleArn"`
	// Map of resource tags for the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll          pulumi.StringMapOutput             `pulumi:"tagsAll"`
	ThroughputConfig FeatureGroupThroughputConfigOutput `pulumi:"throughputConfig"`
}

// NewFeatureGroup registers a new resource with the given unique name, arguments, and options.
func NewFeatureGroup(ctx *pulumi.Context,
	name string, args *FeatureGroupArgs, opts ...pulumi.ResourceOption) (*FeatureGroup, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.EventTimeFeatureName == nil {
		return nil, errors.New("invalid value for required argument 'EventTimeFeatureName'")
	}
	if args.FeatureDefinitions == nil {
		return nil, errors.New("invalid value for required argument 'FeatureDefinitions'")
	}
	if args.FeatureGroupName == nil {
		return nil, errors.New("invalid value for required argument 'FeatureGroupName'")
	}
	if args.RecordIdentifierFeatureName == nil {
		return nil, errors.New("invalid value for required argument 'RecordIdentifierFeatureName'")
	}
	if args.RoleArn == nil {
		return nil, errors.New("invalid value for required argument 'RoleArn'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource FeatureGroup
	err := ctx.RegisterResource("aws:sagemaker/featureGroup:FeatureGroup", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetFeatureGroup gets an existing FeatureGroup resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetFeatureGroup(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *FeatureGroupState, opts ...pulumi.ResourceOption) (*FeatureGroup, error) {
	var resource FeatureGroup
	err := ctx.ReadResource("aws:sagemaker/featureGroup:FeatureGroup", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering FeatureGroup resources.
type featureGroupState struct {
	// The Amazon Resource Name (ARN) assigned by AWS to this feature_group.
	Arn *string `pulumi:"arn"`
	// A free-form description of a Feature Group.
	Description *string `pulumi:"description"`
	// The name of the feature that stores the EventTime of a Record in a Feature Group.
	EventTimeFeatureName *string `pulumi:"eventTimeFeatureName"`
	// A list of Feature names and types. See Feature Definition Below.
	FeatureDefinitions []FeatureGroupFeatureDefinition `pulumi:"featureDefinitions"`
	// The name of the Feature Group. The name must be unique within an AWS Region in an AWS account.
	FeatureGroupName *string `pulumi:"featureGroupName"`
	// The Offline Feature Store Configuration. See Offline Store Config Below.
	OfflineStoreConfig *FeatureGroupOfflineStoreConfig `pulumi:"offlineStoreConfig"`
	// The Online Feature Store Configuration. See Online Store Config Below.
	OnlineStoreConfig *FeatureGroupOnlineStoreConfig `pulumi:"onlineStoreConfig"`
	// The name of the Feature whose value uniquely identifies a Record defined in the Feature Store. Only the latest record per identifier value will be stored in the Online Store.
	RecordIdentifierFeatureName *string `pulumi:"recordIdentifierFeatureName"`
	// The Amazon Resource Name (ARN) of the IAM execution role used to persist data into the Offline Store if an `offlineStoreConfig` is provided.
	RoleArn *string `pulumi:"roleArn"`
	// Map of resource tags for the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll          map[string]string             `pulumi:"tagsAll"`
	ThroughputConfig *FeatureGroupThroughputConfig `pulumi:"throughputConfig"`
}

type FeatureGroupState struct {
	// The Amazon Resource Name (ARN) assigned by AWS to this feature_group.
	Arn pulumi.StringPtrInput
	// A free-form description of a Feature Group.
	Description pulumi.StringPtrInput
	// The name of the feature that stores the EventTime of a Record in a Feature Group.
	EventTimeFeatureName pulumi.StringPtrInput
	// A list of Feature names and types. See Feature Definition Below.
	FeatureDefinitions FeatureGroupFeatureDefinitionArrayInput
	// The name of the Feature Group. The name must be unique within an AWS Region in an AWS account.
	FeatureGroupName pulumi.StringPtrInput
	// The Offline Feature Store Configuration. See Offline Store Config Below.
	OfflineStoreConfig FeatureGroupOfflineStoreConfigPtrInput
	// The Online Feature Store Configuration. See Online Store Config Below.
	OnlineStoreConfig FeatureGroupOnlineStoreConfigPtrInput
	// The name of the Feature whose value uniquely identifies a Record defined in the Feature Store. Only the latest record per identifier value will be stored in the Online Store.
	RecordIdentifierFeatureName pulumi.StringPtrInput
	// The Amazon Resource Name (ARN) of the IAM execution role used to persist data into the Offline Store if an `offlineStoreConfig` is provided.
	RoleArn pulumi.StringPtrInput
	// Map of resource tags for the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll          pulumi.StringMapInput
	ThroughputConfig FeatureGroupThroughputConfigPtrInput
}

func (FeatureGroupState) ElementType() reflect.Type {
	return reflect.TypeOf((*featureGroupState)(nil)).Elem()
}

type featureGroupArgs struct {
	// A free-form description of a Feature Group.
	Description *string `pulumi:"description"`
	// The name of the feature that stores the EventTime of a Record in a Feature Group.
	EventTimeFeatureName string `pulumi:"eventTimeFeatureName"`
	// A list of Feature names and types. See Feature Definition Below.
	FeatureDefinitions []FeatureGroupFeatureDefinition `pulumi:"featureDefinitions"`
	// The name of the Feature Group. The name must be unique within an AWS Region in an AWS account.
	FeatureGroupName string `pulumi:"featureGroupName"`
	// The Offline Feature Store Configuration. See Offline Store Config Below.
	OfflineStoreConfig *FeatureGroupOfflineStoreConfig `pulumi:"offlineStoreConfig"`
	// The Online Feature Store Configuration. See Online Store Config Below.
	OnlineStoreConfig *FeatureGroupOnlineStoreConfig `pulumi:"onlineStoreConfig"`
	// The name of the Feature whose value uniquely identifies a Record defined in the Feature Store. Only the latest record per identifier value will be stored in the Online Store.
	RecordIdentifierFeatureName string `pulumi:"recordIdentifierFeatureName"`
	// The Amazon Resource Name (ARN) of the IAM execution role used to persist data into the Offline Store if an `offlineStoreConfig` is provided.
	RoleArn string `pulumi:"roleArn"`
	// Map of resource tags for the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags             map[string]string             `pulumi:"tags"`
	ThroughputConfig *FeatureGroupThroughputConfig `pulumi:"throughputConfig"`
}

// The set of arguments for constructing a FeatureGroup resource.
type FeatureGroupArgs struct {
	// A free-form description of a Feature Group.
	Description pulumi.StringPtrInput
	// The name of the feature that stores the EventTime of a Record in a Feature Group.
	EventTimeFeatureName pulumi.StringInput
	// A list of Feature names and types. See Feature Definition Below.
	FeatureDefinitions FeatureGroupFeatureDefinitionArrayInput
	// The name of the Feature Group. The name must be unique within an AWS Region in an AWS account.
	FeatureGroupName pulumi.StringInput
	// The Offline Feature Store Configuration. See Offline Store Config Below.
	OfflineStoreConfig FeatureGroupOfflineStoreConfigPtrInput
	// The Online Feature Store Configuration. See Online Store Config Below.
	OnlineStoreConfig FeatureGroupOnlineStoreConfigPtrInput
	// The name of the Feature whose value uniquely identifies a Record defined in the Feature Store. Only the latest record per identifier value will be stored in the Online Store.
	RecordIdentifierFeatureName pulumi.StringInput
	// The Amazon Resource Name (ARN) of the IAM execution role used to persist data into the Offline Store if an `offlineStoreConfig` is provided.
	RoleArn pulumi.StringInput
	// Map of resource tags for the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags             pulumi.StringMapInput
	ThroughputConfig FeatureGroupThroughputConfigPtrInput
}

func (FeatureGroupArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*featureGroupArgs)(nil)).Elem()
}

type FeatureGroupInput interface {
	pulumi.Input

	ToFeatureGroupOutput() FeatureGroupOutput
	ToFeatureGroupOutputWithContext(ctx context.Context) FeatureGroupOutput
}

func (*FeatureGroup) ElementType() reflect.Type {
	return reflect.TypeOf((**FeatureGroup)(nil)).Elem()
}

func (i *FeatureGroup) ToFeatureGroupOutput() FeatureGroupOutput {
	return i.ToFeatureGroupOutputWithContext(context.Background())
}

func (i *FeatureGroup) ToFeatureGroupOutputWithContext(ctx context.Context) FeatureGroupOutput {
	return pulumi.ToOutputWithContext(ctx, i).(FeatureGroupOutput)
}

// FeatureGroupArrayInput is an input type that accepts FeatureGroupArray and FeatureGroupArrayOutput values.
// You can construct a concrete instance of `FeatureGroupArrayInput` via:
//
//	FeatureGroupArray{ FeatureGroupArgs{...} }
type FeatureGroupArrayInput interface {
	pulumi.Input

	ToFeatureGroupArrayOutput() FeatureGroupArrayOutput
	ToFeatureGroupArrayOutputWithContext(context.Context) FeatureGroupArrayOutput
}

type FeatureGroupArray []FeatureGroupInput

func (FeatureGroupArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*FeatureGroup)(nil)).Elem()
}

func (i FeatureGroupArray) ToFeatureGroupArrayOutput() FeatureGroupArrayOutput {
	return i.ToFeatureGroupArrayOutputWithContext(context.Background())
}

func (i FeatureGroupArray) ToFeatureGroupArrayOutputWithContext(ctx context.Context) FeatureGroupArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(FeatureGroupArrayOutput)
}

// FeatureGroupMapInput is an input type that accepts FeatureGroupMap and FeatureGroupMapOutput values.
// You can construct a concrete instance of `FeatureGroupMapInput` via:
//
//	FeatureGroupMap{ "key": FeatureGroupArgs{...} }
type FeatureGroupMapInput interface {
	pulumi.Input

	ToFeatureGroupMapOutput() FeatureGroupMapOutput
	ToFeatureGroupMapOutputWithContext(context.Context) FeatureGroupMapOutput
}

type FeatureGroupMap map[string]FeatureGroupInput

func (FeatureGroupMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*FeatureGroup)(nil)).Elem()
}

func (i FeatureGroupMap) ToFeatureGroupMapOutput() FeatureGroupMapOutput {
	return i.ToFeatureGroupMapOutputWithContext(context.Background())
}

func (i FeatureGroupMap) ToFeatureGroupMapOutputWithContext(ctx context.Context) FeatureGroupMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(FeatureGroupMapOutput)
}

type FeatureGroupOutput struct{ *pulumi.OutputState }

func (FeatureGroupOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**FeatureGroup)(nil)).Elem()
}

func (o FeatureGroupOutput) ToFeatureGroupOutput() FeatureGroupOutput {
	return o
}

func (o FeatureGroupOutput) ToFeatureGroupOutputWithContext(ctx context.Context) FeatureGroupOutput {
	return o
}

// The Amazon Resource Name (ARN) assigned by AWS to this feature_group.
func (o FeatureGroupOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *FeatureGroup) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// A free-form description of a Feature Group.
func (o FeatureGroupOutput) Description() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *FeatureGroup) pulumi.StringPtrOutput { return v.Description }).(pulumi.StringPtrOutput)
}

// The name of the feature that stores the EventTime of a Record in a Feature Group.
func (o FeatureGroupOutput) EventTimeFeatureName() pulumi.StringOutput {
	return o.ApplyT(func(v *FeatureGroup) pulumi.StringOutput { return v.EventTimeFeatureName }).(pulumi.StringOutput)
}

// A list of Feature names and types. See Feature Definition Below.
func (o FeatureGroupOutput) FeatureDefinitions() FeatureGroupFeatureDefinitionArrayOutput {
	return o.ApplyT(func(v *FeatureGroup) FeatureGroupFeatureDefinitionArrayOutput { return v.FeatureDefinitions }).(FeatureGroupFeatureDefinitionArrayOutput)
}

// The name of the Feature Group. The name must be unique within an AWS Region in an AWS account.
func (o FeatureGroupOutput) FeatureGroupName() pulumi.StringOutput {
	return o.ApplyT(func(v *FeatureGroup) pulumi.StringOutput { return v.FeatureGroupName }).(pulumi.StringOutput)
}

// The Offline Feature Store Configuration. See Offline Store Config Below.
func (o FeatureGroupOutput) OfflineStoreConfig() FeatureGroupOfflineStoreConfigPtrOutput {
	return o.ApplyT(func(v *FeatureGroup) FeatureGroupOfflineStoreConfigPtrOutput { return v.OfflineStoreConfig }).(FeatureGroupOfflineStoreConfigPtrOutput)
}

// The Online Feature Store Configuration. See Online Store Config Below.
func (o FeatureGroupOutput) OnlineStoreConfig() FeatureGroupOnlineStoreConfigPtrOutput {
	return o.ApplyT(func(v *FeatureGroup) FeatureGroupOnlineStoreConfigPtrOutput { return v.OnlineStoreConfig }).(FeatureGroupOnlineStoreConfigPtrOutput)
}

// The name of the Feature whose value uniquely identifies a Record defined in the Feature Store. Only the latest record per identifier value will be stored in the Online Store.
func (o FeatureGroupOutput) RecordIdentifierFeatureName() pulumi.StringOutput {
	return o.ApplyT(func(v *FeatureGroup) pulumi.StringOutput { return v.RecordIdentifierFeatureName }).(pulumi.StringOutput)
}

// The Amazon Resource Name (ARN) of the IAM execution role used to persist data into the Offline Store if an `offlineStoreConfig` is provided.
func (o FeatureGroupOutput) RoleArn() pulumi.StringOutput {
	return o.ApplyT(func(v *FeatureGroup) pulumi.StringOutput { return v.RoleArn }).(pulumi.StringOutput)
}

// Map of resource tags for the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o FeatureGroupOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *FeatureGroup) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o FeatureGroupOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *FeatureGroup) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

func (o FeatureGroupOutput) ThroughputConfig() FeatureGroupThroughputConfigOutput {
	return o.ApplyT(func(v *FeatureGroup) FeatureGroupThroughputConfigOutput { return v.ThroughputConfig }).(FeatureGroupThroughputConfigOutput)
}

type FeatureGroupArrayOutput struct{ *pulumi.OutputState }

func (FeatureGroupArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*FeatureGroup)(nil)).Elem()
}

func (o FeatureGroupArrayOutput) ToFeatureGroupArrayOutput() FeatureGroupArrayOutput {
	return o
}

func (o FeatureGroupArrayOutput) ToFeatureGroupArrayOutputWithContext(ctx context.Context) FeatureGroupArrayOutput {
	return o
}

func (o FeatureGroupArrayOutput) Index(i pulumi.IntInput) FeatureGroupOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *FeatureGroup {
		return vs[0].([]*FeatureGroup)[vs[1].(int)]
	}).(FeatureGroupOutput)
}

type FeatureGroupMapOutput struct{ *pulumi.OutputState }

func (FeatureGroupMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*FeatureGroup)(nil)).Elem()
}

func (o FeatureGroupMapOutput) ToFeatureGroupMapOutput() FeatureGroupMapOutput {
	return o
}

func (o FeatureGroupMapOutput) ToFeatureGroupMapOutputWithContext(ctx context.Context) FeatureGroupMapOutput {
	return o
}

func (o FeatureGroupMapOutput) MapIndex(k pulumi.StringInput) FeatureGroupOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *FeatureGroup {
		return vs[0].(map[string]*FeatureGroup)[vs[1].(string)]
	}).(FeatureGroupOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*FeatureGroupInput)(nil)).Elem(), &FeatureGroup{})
	pulumi.RegisterInputType(reflect.TypeOf((*FeatureGroupArrayInput)(nil)).Elem(), FeatureGroupArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*FeatureGroupMapInput)(nil)).Elem(), FeatureGroupMap{})
	pulumi.RegisterOutputType(FeatureGroupOutput{})
	pulumi.RegisterOutputType(FeatureGroupArrayOutput{})
	pulumi.RegisterOutputType(FeatureGroupMapOutput{})
}
