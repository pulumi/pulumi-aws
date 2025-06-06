// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package bcmdata

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS BCM Data Exports Export.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/bcmdata"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := bcmdata.NewExport(ctx, "test", &bcmdata.ExportArgs{
//				Export: &bcmdata.ExportExportArgs{
//					Name: pulumi.String("testexample"),
//					DataQueries: bcmdata.ExportExportDataQueryArray{
//						&bcmdata.ExportExportDataQueryArgs{
//							QueryStatement: pulumi.String("SELECT identity_line_item_id, identity_time_interval, line_item_product_code,line_item_unblended_cost FROM COST_AND_USAGE_REPORT"),
//							TableConfigurations: pulumi.StringMapMap{
//								"COST_AND_USAGE_REPORT": pulumi.StringMap{
//									"TIME_GRANULARITY":                      pulumi.String("HOURLY"),
//									"INCLUDE_RESOURCES":                     pulumi.String("FALSE"),
//									"INCLUDE_MANUAL_DISCOUNT_COMPATIBILITY": pulumi.String("FALSE"),
//									"INCLUDE_SPLIT_COST_ALLOCATION_DATA":    pulumi.String("FALSE"),
//								},
//							},
//						},
//					},
//					DestinationConfigurations: bcmdata.ExportExportDestinationConfigurationArray{
//						&bcmdata.ExportExportDestinationConfigurationArgs{
//							S3Destinations: bcmdata.ExportExportDestinationConfigurationS3DestinationArray{
//								&bcmdata.ExportExportDestinationConfigurationS3DestinationArgs{
//									S3Bucket: pulumi.Any(testAwsS3Bucket.Bucket),
//									S3Prefix: pulumi.Any(testAwsS3Bucket.BucketPrefix),
//									S3Region: pulumi.Any(testAwsS3Bucket.Region),
//									S3OutputConfigurations: bcmdata.ExportExportDestinationConfigurationS3DestinationS3OutputConfigurationArray{
//										&bcmdata.ExportExportDestinationConfigurationS3DestinationS3OutputConfigurationArgs{
//											Overwrite:   pulumi.String("OVERWRITE_REPORT"),
//											Format:      pulumi.String("TEXT_OR_CSV"),
//											Compression: pulumi.String("GZIP"),
//											OutputType:  pulumi.String("CUSTOM"),
//										},
//									},
//								},
//							},
//						},
//					},
//					RefreshCadences: bcmdata.ExportExportRefreshCadenceArray{
//						&bcmdata.ExportExportRefreshCadenceArgs{
//							Frequency: pulumi.String("SYNCHRONOUS"),
//						},
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
// Using `pulumi import`, import BCM Data Exports Export using the export ARN. For example:
//
// ```sh
// $ pulumi import aws:bcmdata/export:Export example arn:aws:bcm-data-exports:us-east-1:123456789012:export/CostUsageReport-9f1c75f3-f982-4d9a-b936-1e7ecab814b7
// ```
type Export struct {
	pulumi.CustomResourceState

	// The details of the export, including data query, name, description, and destination configuration.  See the `export` argument reference below.
	Export ExportExportPtrOutput  `pulumi:"export"`
	Tags   pulumi.StringMapOutput `pulumi:"tags"`
	// Deprecated: Please use `tags` instead.
	TagsAll  pulumi.StringMapOutput  `pulumi:"tagsAll"`
	Timeouts ExportTimeoutsPtrOutput `pulumi:"timeouts"`
}

// NewExport registers a new resource with the given unique name, arguments, and options.
func NewExport(ctx *pulumi.Context,
	name string, args *ExportArgs, opts ...pulumi.ResourceOption) (*Export, error) {
	if args == nil {
		args = &ExportArgs{}
	}

	opts = internal.PkgResourceDefaultOpts(opts)
	var resource Export
	err := ctx.RegisterResource("aws:bcmdata/export:Export", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetExport gets an existing Export resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetExport(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ExportState, opts ...pulumi.ResourceOption) (*Export, error) {
	var resource Export
	err := ctx.ReadResource("aws:bcmdata/export:Export", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Export resources.
type exportState struct {
	// The details of the export, including data query, name, description, and destination configuration.  See the `export` argument reference below.
	Export *ExportExport     `pulumi:"export"`
	Tags   map[string]string `pulumi:"tags"`
	// Deprecated: Please use `tags` instead.
	TagsAll  map[string]string `pulumi:"tagsAll"`
	Timeouts *ExportTimeouts   `pulumi:"timeouts"`
}

type ExportState struct {
	// The details of the export, including data query, name, description, and destination configuration.  See the `export` argument reference below.
	Export ExportExportPtrInput
	Tags   pulumi.StringMapInput
	// Deprecated: Please use `tags` instead.
	TagsAll  pulumi.StringMapInput
	Timeouts ExportTimeoutsPtrInput
}

func (ExportState) ElementType() reflect.Type {
	return reflect.TypeOf((*exportState)(nil)).Elem()
}

type exportArgs struct {
	// The details of the export, including data query, name, description, and destination configuration.  See the `export` argument reference below.
	Export   *ExportExport     `pulumi:"export"`
	Tags     map[string]string `pulumi:"tags"`
	Timeouts *ExportTimeouts   `pulumi:"timeouts"`
}

// The set of arguments for constructing a Export resource.
type ExportArgs struct {
	// The details of the export, including data query, name, description, and destination configuration.  See the `export` argument reference below.
	Export   ExportExportPtrInput
	Tags     pulumi.StringMapInput
	Timeouts ExportTimeoutsPtrInput
}

func (ExportArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*exportArgs)(nil)).Elem()
}

type ExportInput interface {
	pulumi.Input

	ToExportOutput() ExportOutput
	ToExportOutputWithContext(ctx context.Context) ExportOutput
}

func (*Export) ElementType() reflect.Type {
	return reflect.TypeOf((**Export)(nil)).Elem()
}

func (i *Export) ToExportOutput() ExportOutput {
	return i.ToExportOutputWithContext(context.Background())
}

func (i *Export) ToExportOutputWithContext(ctx context.Context) ExportOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ExportOutput)
}

// ExportArrayInput is an input type that accepts ExportArray and ExportArrayOutput values.
// You can construct a concrete instance of `ExportArrayInput` via:
//
//	ExportArray{ ExportArgs{...} }
type ExportArrayInput interface {
	pulumi.Input

	ToExportArrayOutput() ExportArrayOutput
	ToExportArrayOutputWithContext(context.Context) ExportArrayOutput
}

type ExportArray []ExportInput

func (ExportArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Export)(nil)).Elem()
}

func (i ExportArray) ToExportArrayOutput() ExportArrayOutput {
	return i.ToExportArrayOutputWithContext(context.Background())
}

func (i ExportArray) ToExportArrayOutputWithContext(ctx context.Context) ExportArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ExportArrayOutput)
}

// ExportMapInput is an input type that accepts ExportMap and ExportMapOutput values.
// You can construct a concrete instance of `ExportMapInput` via:
//
//	ExportMap{ "key": ExportArgs{...} }
type ExportMapInput interface {
	pulumi.Input

	ToExportMapOutput() ExportMapOutput
	ToExportMapOutputWithContext(context.Context) ExportMapOutput
}

type ExportMap map[string]ExportInput

func (ExportMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Export)(nil)).Elem()
}

func (i ExportMap) ToExportMapOutput() ExportMapOutput {
	return i.ToExportMapOutputWithContext(context.Background())
}

func (i ExportMap) ToExportMapOutputWithContext(ctx context.Context) ExportMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ExportMapOutput)
}

type ExportOutput struct{ *pulumi.OutputState }

func (ExportOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**Export)(nil)).Elem()
}

func (o ExportOutput) ToExportOutput() ExportOutput {
	return o
}

func (o ExportOutput) ToExportOutputWithContext(ctx context.Context) ExportOutput {
	return o
}

// The details of the export, including data query, name, description, and destination configuration.  See the `export` argument reference below.
func (o ExportOutput) Export() ExportExportPtrOutput {
	return o.ApplyT(func(v *Export) ExportExportPtrOutput { return v.Export }).(ExportExportPtrOutput)
}

func (o ExportOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Export) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Deprecated: Please use `tags` instead.
func (o ExportOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Export) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

func (o ExportOutput) Timeouts() ExportTimeoutsPtrOutput {
	return o.ApplyT(func(v *Export) ExportTimeoutsPtrOutput { return v.Timeouts }).(ExportTimeoutsPtrOutput)
}

type ExportArrayOutput struct{ *pulumi.OutputState }

func (ExportArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Export)(nil)).Elem()
}

func (o ExportArrayOutput) ToExportArrayOutput() ExportArrayOutput {
	return o
}

func (o ExportArrayOutput) ToExportArrayOutputWithContext(ctx context.Context) ExportArrayOutput {
	return o
}

func (o ExportArrayOutput) Index(i pulumi.IntInput) ExportOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *Export {
		return vs[0].([]*Export)[vs[1].(int)]
	}).(ExportOutput)
}

type ExportMapOutput struct{ *pulumi.OutputState }

func (ExportMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Export)(nil)).Elem()
}

func (o ExportMapOutput) ToExportMapOutput() ExportMapOutput {
	return o
}

func (o ExportMapOutput) ToExportMapOutputWithContext(ctx context.Context) ExportMapOutput {
	return o
}

func (o ExportMapOutput) MapIndex(k pulumi.StringInput) ExportOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *Export {
		return vs[0].(map[string]*Export)[vs[1].(string)]
	}).(ExportOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ExportInput)(nil)).Elem(), &Export{})
	pulumi.RegisterInputType(reflect.TypeOf((*ExportArrayInput)(nil)).Elem(), ExportArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ExportMapInput)(nil)).Elem(), ExportMap{})
	pulumi.RegisterOutputType(ExportOutput{})
	pulumi.RegisterOutputType(ExportArrayOutput{})
	pulumi.RegisterOutputType(ExportMapOutput{})
}
