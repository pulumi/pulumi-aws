// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package glue

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a Glue Data Quality Ruleset Resource. You can refer to the [Glue Developer Guide](https://docs.aws.amazon.com/glue/latest/dg/glue-data-quality.html) for a full explanation of the Glue Data Quality Ruleset functionality
//
// ## Example Usage
//
// ### Basic
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/glue"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := glue.NewDataQualityRuleset(ctx, "example", &glue.DataQualityRulesetArgs{
//				Name:    pulumi.String("example"),
//				Ruleset: pulumi.String("Rules = [Completeness \"colA\" between 0.4 and 0.8]"),
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
// ### With description
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/glue"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := glue.NewDataQualityRuleset(ctx, "example", &glue.DataQualityRulesetArgs{
//				Name:        pulumi.String("example"),
//				Description: pulumi.String("example"),
//				Ruleset:     pulumi.String("Rules = [Completeness \"colA\" between 0.4 and 0.8]"),
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
// ### With tags
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/glue"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := glue.NewDataQualityRuleset(ctx, "example", &glue.DataQualityRulesetArgs{
//				Name:    pulumi.String("example"),
//				Ruleset: pulumi.String("Rules = [Completeness \"colA\" between 0.4 and 0.8]"),
//				Tags: pulumi.StringMap{
//					"hello": pulumi.String("world"),
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
// ### With targetTable
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/glue"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := glue.NewDataQualityRuleset(ctx, "example", &glue.DataQualityRulesetArgs{
//				Name:    pulumi.String("example"),
//				Ruleset: pulumi.String("Rules = [Completeness \"colA\" between 0.4 and 0.8]"),
//				TargetTable: &glue.DataQualityRulesetTargetTableArgs{
//					DatabaseName: pulumi.Any(exampleAwsGlueCatalogDatabase.Name),
//					TableName:    pulumi.Any(exampleAwsGlueCatalogTable.Name),
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
// Using `pulumi import`, import Glue Data Quality Ruleset using the `name`. For example:
//
// ```sh
// $ pulumi import aws:glue/dataQualityRuleset:DataQualityRuleset example exampleName
// ```
type DataQualityRuleset struct {
	pulumi.CustomResourceState

	// ARN of the Glue Data Quality Ruleset.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// The time and date that this data quality ruleset was created.
	CreatedOn pulumi.StringOutput `pulumi:"createdOn"`
	// Description of the data quality ruleset.
	Description pulumi.StringPtrOutput `pulumi:"description"`
	// The time and date that this data quality ruleset was created.
	LastModifiedOn pulumi.StringOutput `pulumi:"lastModifiedOn"`
	// Name of the data quality ruleset.
	Name pulumi.StringOutput `pulumi:"name"`
	// When a ruleset was created from a recommendation run, this run ID is generated to link the two together.
	RecommendationRunId pulumi.StringOutput `pulumi:"recommendationRunId"`
	// A Data Quality Definition Language (DQDL) ruleset. For more information, see the AWS Glue developer guide.
	Ruleset pulumi.StringOutput `pulumi:"ruleset"`
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	// A Configuration block specifying a target table associated with the data quality ruleset. See `targetTable` below.
	TargetTable DataQualityRulesetTargetTablePtrOutput `pulumi:"targetTable"`
}

// NewDataQualityRuleset registers a new resource with the given unique name, arguments, and options.
func NewDataQualityRuleset(ctx *pulumi.Context,
	name string, args *DataQualityRulesetArgs, opts ...pulumi.ResourceOption) (*DataQualityRuleset, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.Ruleset == nil {
		return nil, errors.New("invalid value for required argument 'Ruleset'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource DataQualityRuleset
	err := ctx.RegisterResource("aws:glue/dataQualityRuleset:DataQualityRuleset", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetDataQualityRuleset gets an existing DataQualityRuleset resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetDataQualityRuleset(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *DataQualityRulesetState, opts ...pulumi.ResourceOption) (*DataQualityRuleset, error) {
	var resource DataQualityRuleset
	err := ctx.ReadResource("aws:glue/dataQualityRuleset:DataQualityRuleset", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering DataQualityRuleset resources.
type dataQualityRulesetState struct {
	// ARN of the Glue Data Quality Ruleset.
	Arn *string `pulumi:"arn"`
	// The time and date that this data quality ruleset was created.
	CreatedOn *string `pulumi:"createdOn"`
	// Description of the data quality ruleset.
	Description *string `pulumi:"description"`
	// The time and date that this data quality ruleset was created.
	LastModifiedOn *string `pulumi:"lastModifiedOn"`
	// Name of the data quality ruleset.
	Name *string `pulumi:"name"`
	// When a ruleset was created from a recommendation run, this run ID is generated to link the two together.
	RecommendationRunId *string `pulumi:"recommendationRunId"`
	// A Data Quality Definition Language (DQDL) ruleset. For more information, see the AWS Glue developer guide.
	Ruleset *string `pulumi:"ruleset"`
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	// A Configuration block specifying a target table associated with the data quality ruleset. See `targetTable` below.
	TargetTable *DataQualityRulesetTargetTable `pulumi:"targetTable"`
}

type DataQualityRulesetState struct {
	// ARN of the Glue Data Quality Ruleset.
	Arn pulumi.StringPtrInput
	// The time and date that this data quality ruleset was created.
	CreatedOn pulumi.StringPtrInput
	// Description of the data quality ruleset.
	Description pulumi.StringPtrInput
	// The time and date that this data quality ruleset was created.
	LastModifiedOn pulumi.StringPtrInput
	// Name of the data quality ruleset.
	Name pulumi.StringPtrInput
	// When a ruleset was created from a recommendation run, this run ID is generated to link the two together.
	RecommendationRunId pulumi.StringPtrInput
	// A Data Quality Definition Language (DQDL) ruleset. For more information, see the AWS Glue developer guide.
	Ruleset pulumi.StringPtrInput
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	// A Configuration block specifying a target table associated with the data quality ruleset. See `targetTable` below.
	TargetTable DataQualityRulesetTargetTablePtrInput
}

func (DataQualityRulesetState) ElementType() reflect.Type {
	return reflect.TypeOf((*dataQualityRulesetState)(nil)).Elem()
}

type dataQualityRulesetArgs struct {
	// Description of the data quality ruleset.
	Description *string `pulumi:"description"`
	// Name of the data quality ruleset.
	Name *string `pulumi:"name"`
	// A Data Quality Definition Language (DQDL) ruleset. For more information, see the AWS Glue developer guide.
	Ruleset string `pulumi:"ruleset"`
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A Configuration block specifying a target table associated with the data quality ruleset. See `targetTable` below.
	TargetTable *DataQualityRulesetTargetTable `pulumi:"targetTable"`
}

// The set of arguments for constructing a DataQualityRuleset resource.
type DataQualityRulesetArgs struct {
	// Description of the data quality ruleset.
	Description pulumi.StringPtrInput
	// Name of the data quality ruleset.
	Name pulumi.StringPtrInput
	// A Data Quality Definition Language (DQDL) ruleset. For more information, see the AWS Glue developer guide.
	Ruleset pulumi.StringInput
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A Configuration block specifying a target table associated with the data quality ruleset. See `targetTable` below.
	TargetTable DataQualityRulesetTargetTablePtrInput
}

func (DataQualityRulesetArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*dataQualityRulesetArgs)(nil)).Elem()
}

type DataQualityRulesetInput interface {
	pulumi.Input

	ToDataQualityRulesetOutput() DataQualityRulesetOutput
	ToDataQualityRulesetOutputWithContext(ctx context.Context) DataQualityRulesetOutput
}

func (*DataQualityRuleset) ElementType() reflect.Type {
	return reflect.TypeOf((**DataQualityRuleset)(nil)).Elem()
}

func (i *DataQualityRuleset) ToDataQualityRulesetOutput() DataQualityRulesetOutput {
	return i.ToDataQualityRulesetOutputWithContext(context.Background())
}

func (i *DataQualityRuleset) ToDataQualityRulesetOutputWithContext(ctx context.Context) DataQualityRulesetOutput {
	return pulumi.ToOutputWithContext(ctx, i).(DataQualityRulesetOutput)
}

// DataQualityRulesetArrayInput is an input type that accepts DataQualityRulesetArray and DataQualityRulesetArrayOutput values.
// You can construct a concrete instance of `DataQualityRulesetArrayInput` via:
//
//	DataQualityRulesetArray{ DataQualityRulesetArgs{...} }
type DataQualityRulesetArrayInput interface {
	pulumi.Input

	ToDataQualityRulesetArrayOutput() DataQualityRulesetArrayOutput
	ToDataQualityRulesetArrayOutputWithContext(context.Context) DataQualityRulesetArrayOutput
}

type DataQualityRulesetArray []DataQualityRulesetInput

func (DataQualityRulesetArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*DataQualityRuleset)(nil)).Elem()
}

func (i DataQualityRulesetArray) ToDataQualityRulesetArrayOutput() DataQualityRulesetArrayOutput {
	return i.ToDataQualityRulesetArrayOutputWithContext(context.Background())
}

func (i DataQualityRulesetArray) ToDataQualityRulesetArrayOutputWithContext(ctx context.Context) DataQualityRulesetArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(DataQualityRulesetArrayOutput)
}

// DataQualityRulesetMapInput is an input type that accepts DataQualityRulesetMap and DataQualityRulesetMapOutput values.
// You can construct a concrete instance of `DataQualityRulesetMapInput` via:
//
//	DataQualityRulesetMap{ "key": DataQualityRulesetArgs{...} }
type DataQualityRulesetMapInput interface {
	pulumi.Input

	ToDataQualityRulesetMapOutput() DataQualityRulesetMapOutput
	ToDataQualityRulesetMapOutputWithContext(context.Context) DataQualityRulesetMapOutput
}

type DataQualityRulesetMap map[string]DataQualityRulesetInput

func (DataQualityRulesetMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*DataQualityRuleset)(nil)).Elem()
}

func (i DataQualityRulesetMap) ToDataQualityRulesetMapOutput() DataQualityRulesetMapOutput {
	return i.ToDataQualityRulesetMapOutputWithContext(context.Background())
}

func (i DataQualityRulesetMap) ToDataQualityRulesetMapOutputWithContext(ctx context.Context) DataQualityRulesetMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(DataQualityRulesetMapOutput)
}

type DataQualityRulesetOutput struct{ *pulumi.OutputState }

func (DataQualityRulesetOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**DataQualityRuleset)(nil)).Elem()
}

func (o DataQualityRulesetOutput) ToDataQualityRulesetOutput() DataQualityRulesetOutput {
	return o
}

func (o DataQualityRulesetOutput) ToDataQualityRulesetOutputWithContext(ctx context.Context) DataQualityRulesetOutput {
	return o
}

// ARN of the Glue Data Quality Ruleset.
func (o DataQualityRulesetOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *DataQualityRuleset) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// The time and date that this data quality ruleset was created.
func (o DataQualityRulesetOutput) CreatedOn() pulumi.StringOutput {
	return o.ApplyT(func(v *DataQualityRuleset) pulumi.StringOutput { return v.CreatedOn }).(pulumi.StringOutput)
}

// Description of the data quality ruleset.
func (o DataQualityRulesetOutput) Description() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *DataQualityRuleset) pulumi.StringPtrOutput { return v.Description }).(pulumi.StringPtrOutput)
}

// The time and date that this data quality ruleset was created.
func (o DataQualityRulesetOutput) LastModifiedOn() pulumi.StringOutput {
	return o.ApplyT(func(v *DataQualityRuleset) pulumi.StringOutput { return v.LastModifiedOn }).(pulumi.StringOutput)
}

// Name of the data quality ruleset.
func (o DataQualityRulesetOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *DataQualityRuleset) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// When a ruleset was created from a recommendation run, this run ID is generated to link the two together.
func (o DataQualityRulesetOutput) RecommendationRunId() pulumi.StringOutput {
	return o.ApplyT(func(v *DataQualityRuleset) pulumi.StringOutput { return v.RecommendationRunId }).(pulumi.StringOutput)
}

// A Data Quality Definition Language (DQDL) ruleset. For more information, see the AWS Glue developer guide.
func (o DataQualityRulesetOutput) Ruleset() pulumi.StringOutput {
	return o.ApplyT(func(v *DataQualityRuleset) pulumi.StringOutput { return v.Ruleset }).(pulumi.StringOutput)
}

// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o DataQualityRulesetOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *DataQualityRuleset) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o DataQualityRulesetOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *DataQualityRuleset) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

// A Configuration block specifying a target table associated with the data quality ruleset. See `targetTable` below.
func (o DataQualityRulesetOutput) TargetTable() DataQualityRulesetTargetTablePtrOutput {
	return o.ApplyT(func(v *DataQualityRuleset) DataQualityRulesetTargetTablePtrOutput { return v.TargetTable }).(DataQualityRulesetTargetTablePtrOutput)
}

type DataQualityRulesetArrayOutput struct{ *pulumi.OutputState }

func (DataQualityRulesetArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*DataQualityRuleset)(nil)).Elem()
}

func (o DataQualityRulesetArrayOutput) ToDataQualityRulesetArrayOutput() DataQualityRulesetArrayOutput {
	return o
}

func (o DataQualityRulesetArrayOutput) ToDataQualityRulesetArrayOutputWithContext(ctx context.Context) DataQualityRulesetArrayOutput {
	return o
}

func (o DataQualityRulesetArrayOutput) Index(i pulumi.IntInput) DataQualityRulesetOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *DataQualityRuleset {
		return vs[0].([]*DataQualityRuleset)[vs[1].(int)]
	}).(DataQualityRulesetOutput)
}

type DataQualityRulesetMapOutput struct{ *pulumi.OutputState }

func (DataQualityRulesetMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*DataQualityRuleset)(nil)).Elem()
}

func (o DataQualityRulesetMapOutput) ToDataQualityRulesetMapOutput() DataQualityRulesetMapOutput {
	return o
}

func (o DataQualityRulesetMapOutput) ToDataQualityRulesetMapOutputWithContext(ctx context.Context) DataQualityRulesetMapOutput {
	return o
}

func (o DataQualityRulesetMapOutput) MapIndex(k pulumi.StringInput) DataQualityRulesetOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *DataQualityRuleset {
		return vs[0].(map[string]*DataQualityRuleset)[vs[1].(string)]
	}).(DataQualityRulesetOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*DataQualityRulesetInput)(nil)).Elem(), &DataQualityRuleset{})
	pulumi.RegisterInputType(reflect.TypeOf((*DataQualityRulesetArrayInput)(nil)).Elem(), DataQualityRulesetArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*DataQualityRulesetMapInput)(nil)).Elem(), DataQualityRulesetMap{})
	pulumi.RegisterOutputType(DataQualityRulesetOutput{})
	pulumi.RegisterOutputType(DataQualityRulesetArrayOutput{})
	pulumi.RegisterOutputType(DataQualityRulesetMapOutput{})
}
