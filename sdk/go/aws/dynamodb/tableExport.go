// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package dynamodb

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// ## Example Usage
//
// ### Basic Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/dynamodb"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/s3"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			example, err := s3.NewBucketV2(ctx, "example", &s3.BucketV2Args{
//				BucketPrefix: pulumi.String("example"),
//				ForceDestroy: pulumi.Bool(true),
//			})
//			if err != nil {
//				return err
//			}
//			exampleTable, err := dynamodb.NewTable(ctx, "example", &dynamodb.TableArgs{
//				Name:        pulumi.String("example-table-1"),
//				BillingMode: pulumi.String("PAY_PER_REQUEST"),
//				HashKey:     pulumi.String("user_id"),
//				Attributes: dynamodb.TableAttributeArray{
//					&dynamodb.TableAttributeArgs{
//						Name: pulumi.String("user_id"),
//						Type: pulumi.String("S"),
//					},
//				},
//				PointInTimeRecovery: &dynamodb.TablePointInTimeRecoveryArgs{
//					Enabled: pulumi.Bool(true),
//				},
//			})
//			if err != nil {
//				return err
//			}
//			_, err = dynamodb.NewTableExport(ctx, "example", &dynamodb.TableExportArgs{
//				TableArn: exampleTable.Arn,
//				S3Bucket: example.ID(),
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
// ### Example with export time
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/dynamodb"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := dynamodb.NewTableExport(ctx, "example", &dynamodb.TableExportArgs{
//				ExportTime: pulumi.String("2023-04-02T11:30:13+01:00"),
//				S3Bucket:   pulumi.Any(exampleAwsS3Bucket.Id),
//				TableArn:   pulumi.Any(exampleAwsDynamodbTable.Arn),
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
// ### Incremental export
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/dynamodb"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := dynamodb.NewTableExport(ctx, "example", &dynamodb.TableExportArgs{
//				ExportType: pulumi.String("INCREMENTAL_EXPORT"),
//				S3Bucket:   pulumi.Any(exampleAwsS3Bucket.Id),
//				TableArn:   pulumi.Any(exampleAwsDynamodbTable.Arn),
//				IncrementalExportSpecification: &dynamodb.TableExportIncrementalExportSpecificationArgs{
//					ExportFromTime: pulumi.String("2025-02-09T12:00:00+01:00"),
//					ExportToTime:   pulumi.String("2025-02-09T13:00:00+01:00"),
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
// Using `pulumi import`, import DynamoDB table exports using the `arn`. For example:
//
// ```sh
// $ pulumi import aws:dynamodb/tableExport:TableExport example arn:aws:dynamodb:us-west-2:12345678911:table/my-table-1/export/01580735656614-2c2f422e
// ```
type TableExport struct {
	pulumi.CustomResourceState

	// ARN of the Table Export.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Billable size of the table export.
	BilledSizeInBytes pulumi.IntOutput `pulumi:"billedSizeInBytes"`
	// Time at which the export task completed.
	EndTime pulumi.StringOutput `pulumi:"endTime"`
	// Format for the exported data. Valid values are: `DYNAMODB_JSON`, `ION`. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport.Output.html#S3DataExport.Output_Data) for more information on these export formats. Default is `DYNAMODB_JSON`.
	ExportFormat pulumi.StringPtrOutput `pulumi:"exportFormat"`
	// Status of the export - export can be in one of the following states `IN_PROGRESS`, `COMPLETED`, or `FAILED`.
	ExportStatus pulumi.StringOutput `pulumi:"exportStatus"`
	// Time in RFC3339 format from which to export table data. The table export will be a snapshot of the table's state at this point in time. Omitting this value will result in a snapshot from the current time.
	ExportTime pulumi.StringOutput `pulumi:"exportTime"`
	// Whether to execute as a full export or incremental export. Valid values are: `FULL_EXPORT`, `INCREMENTAL_EXPORT`. Defaults to `FULL_EXPORT`. If `INCREMENTAL_EXPORT` is provided, the `incrementalExportSpecification` argument must also be provided.
	// `incrementalExportSpecification` - (Optional, Forces new resource) Parameters specific to an incremental export. See `incrementalExportSpecification` Block for details.
	ExportType                     pulumi.StringOutput                                `pulumi:"exportType"`
	IncrementalExportSpecification TableExportIncrementalExportSpecificationPtrOutput `pulumi:"incrementalExportSpecification"`
	// Number of items exported.
	ItemCount pulumi.IntOutput `pulumi:"itemCount"`
	// Name of the manifest file for the export task. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport.Output.html#S3DataExport.Output_Manifest) for more information on this manifest file.
	ManifestFilesS3Key pulumi.StringOutput `pulumi:"manifestFilesS3Key"`
	// Name of the Amazon S3 bucket to export the snapshot to. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport_Requesting.html#S3DataExport_Requesting_Permissions) for information on how configure this S3 bucket.
	S3Bucket pulumi.StringOutput `pulumi:"s3Bucket"`
	// ID of the AWS account that owns the bucket the export will be stored in.
	S3BucketOwner pulumi.StringOutput `pulumi:"s3BucketOwner"`
	// Amazon S3 bucket prefix to use as the file name and path of the exported snapshot.
	S3Prefix pulumi.StringOutput `pulumi:"s3Prefix"`
	// Type of encryption used on the bucket where export data will be stored. Valid values are: `AES256`, `KMS`.
	S3SseAlgorithm pulumi.StringOutput `pulumi:"s3SseAlgorithm"`
	// ID of the AWS KMS managed key used to encrypt the S3 bucket where export data will be stored (if applicable).
	S3SseKmsKeyId pulumi.StringPtrOutput `pulumi:"s3SseKmsKeyId"`
	// Time at which the export task began.
	StartTime pulumi.StringOutput `pulumi:"startTime"`
	// ARN associated with the table to export.
	//
	// The following arguments are optional:
	TableArn pulumi.StringOutput `pulumi:"tableArn"`
}

// NewTableExport registers a new resource with the given unique name, arguments, and options.
func NewTableExport(ctx *pulumi.Context,
	name string, args *TableExportArgs, opts ...pulumi.ResourceOption) (*TableExport, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.S3Bucket == nil {
		return nil, errors.New("invalid value for required argument 'S3Bucket'")
	}
	if args.TableArn == nil {
		return nil, errors.New("invalid value for required argument 'TableArn'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource TableExport
	err := ctx.RegisterResource("aws:dynamodb/tableExport:TableExport", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetTableExport gets an existing TableExport resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetTableExport(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *TableExportState, opts ...pulumi.ResourceOption) (*TableExport, error) {
	var resource TableExport
	err := ctx.ReadResource("aws:dynamodb/tableExport:TableExport", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering TableExport resources.
type tableExportState struct {
	// ARN of the Table Export.
	Arn *string `pulumi:"arn"`
	// Billable size of the table export.
	BilledSizeInBytes *int `pulumi:"billedSizeInBytes"`
	// Time at which the export task completed.
	EndTime *string `pulumi:"endTime"`
	// Format for the exported data. Valid values are: `DYNAMODB_JSON`, `ION`. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport.Output.html#S3DataExport.Output_Data) for more information on these export formats. Default is `DYNAMODB_JSON`.
	ExportFormat *string `pulumi:"exportFormat"`
	// Status of the export - export can be in one of the following states `IN_PROGRESS`, `COMPLETED`, or `FAILED`.
	ExportStatus *string `pulumi:"exportStatus"`
	// Time in RFC3339 format from which to export table data. The table export will be a snapshot of the table's state at this point in time. Omitting this value will result in a snapshot from the current time.
	ExportTime *string `pulumi:"exportTime"`
	// Whether to execute as a full export or incremental export. Valid values are: `FULL_EXPORT`, `INCREMENTAL_EXPORT`. Defaults to `FULL_EXPORT`. If `INCREMENTAL_EXPORT` is provided, the `incrementalExportSpecification` argument must also be provided.
	// `incrementalExportSpecification` - (Optional, Forces new resource) Parameters specific to an incremental export. See `incrementalExportSpecification` Block for details.
	ExportType                     *string                                    `pulumi:"exportType"`
	IncrementalExportSpecification *TableExportIncrementalExportSpecification `pulumi:"incrementalExportSpecification"`
	// Number of items exported.
	ItemCount *int `pulumi:"itemCount"`
	// Name of the manifest file for the export task. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport.Output.html#S3DataExport.Output_Manifest) for more information on this manifest file.
	ManifestFilesS3Key *string `pulumi:"manifestFilesS3Key"`
	// Name of the Amazon S3 bucket to export the snapshot to. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport_Requesting.html#S3DataExport_Requesting_Permissions) for information on how configure this S3 bucket.
	S3Bucket *string `pulumi:"s3Bucket"`
	// ID of the AWS account that owns the bucket the export will be stored in.
	S3BucketOwner *string `pulumi:"s3BucketOwner"`
	// Amazon S3 bucket prefix to use as the file name and path of the exported snapshot.
	S3Prefix *string `pulumi:"s3Prefix"`
	// Type of encryption used on the bucket where export data will be stored. Valid values are: `AES256`, `KMS`.
	S3SseAlgorithm *string `pulumi:"s3SseAlgorithm"`
	// ID of the AWS KMS managed key used to encrypt the S3 bucket where export data will be stored (if applicable).
	S3SseKmsKeyId *string `pulumi:"s3SseKmsKeyId"`
	// Time at which the export task began.
	StartTime *string `pulumi:"startTime"`
	// ARN associated with the table to export.
	//
	// The following arguments are optional:
	TableArn *string `pulumi:"tableArn"`
}

type TableExportState struct {
	// ARN of the Table Export.
	Arn pulumi.StringPtrInput
	// Billable size of the table export.
	BilledSizeInBytes pulumi.IntPtrInput
	// Time at which the export task completed.
	EndTime pulumi.StringPtrInput
	// Format for the exported data. Valid values are: `DYNAMODB_JSON`, `ION`. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport.Output.html#S3DataExport.Output_Data) for more information on these export formats. Default is `DYNAMODB_JSON`.
	ExportFormat pulumi.StringPtrInput
	// Status of the export - export can be in one of the following states `IN_PROGRESS`, `COMPLETED`, or `FAILED`.
	ExportStatus pulumi.StringPtrInput
	// Time in RFC3339 format from which to export table data. The table export will be a snapshot of the table's state at this point in time. Omitting this value will result in a snapshot from the current time.
	ExportTime pulumi.StringPtrInput
	// Whether to execute as a full export or incremental export. Valid values are: `FULL_EXPORT`, `INCREMENTAL_EXPORT`. Defaults to `FULL_EXPORT`. If `INCREMENTAL_EXPORT` is provided, the `incrementalExportSpecification` argument must also be provided.
	// `incrementalExportSpecification` - (Optional, Forces new resource) Parameters specific to an incremental export. See `incrementalExportSpecification` Block for details.
	ExportType                     pulumi.StringPtrInput
	IncrementalExportSpecification TableExportIncrementalExportSpecificationPtrInput
	// Number of items exported.
	ItemCount pulumi.IntPtrInput
	// Name of the manifest file for the export task. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport.Output.html#S3DataExport.Output_Manifest) for more information on this manifest file.
	ManifestFilesS3Key pulumi.StringPtrInput
	// Name of the Amazon S3 bucket to export the snapshot to. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport_Requesting.html#S3DataExport_Requesting_Permissions) for information on how configure this S3 bucket.
	S3Bucket pulumi.StringPtrInput
	// ID of the AWS account that owns the bucket the export will be stored in.
	S3BucketOwner pulumi.StringPtrInput
	// Amazon S3 bucket prefix to use as the file name and path of the exported snapshot.
	S3Prefix pulumi.StringPtrInput
	// Type of encryption used on the bucket where export data will be stored. Valid values are: `AES256`, `KMS`.
	S3SseAlgorithm pulumi.StringPtrInput
	// ID of the AWS KMS managed key used to encrypt the S3 bucket where export data will be stored (if applicable).
	S3SseKmsKeyId pulumi.StringPtrInput
	// Time at which the export task began.
	StartTime pulumi.StringPtrInput
	// ARN associated with the table to export.
	//
	// The following arguments are optional:
	TableArn pulumi.StringPtrInput
}

func (TableExportState) ElementType() reflect.Type {
	return reflect.TypeOf((*tableExportState)(nil)).Elem()
}

type tableExportArgs struct {
	// Format for the exported data. Valid values are: `DYNAMODB_JSON`, `ION`. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport.Output.html#S3DataExport.Output_Data) for more information on these export formats. Default is `DYNAMODB_JSON`.
	ExportFormat *string `pulumi:"exportFormat"`
	// Time in RFC3339 format from which to export table data. The table export will be a snapshot of the table's state at this point in time. Omitting this value will result in a snapshot from the current time.
	ExportTime *string `pulumi:"exportTime"`
	// Whether to execute as a full export or incremental export. Valid values are: `FULL_EXPORT`, `INCREMENTAL_EXPORT`. Defaults to `FULL_EXPORT`. If `INCREMENTAL_EXPORT` is provided, the `incrementalExportSpecification` argument must also be provided.
	// `incrementalExportSpecification` - (Optional, Forces new resource) Parameters specific to an incremental export. See `incrementalExportSpecification` Block for details.
	ExportType                     *string                                    `pulumi:"exportType"`
	IncrementalExportSpecification *TableExportIncrementalExportSpecification `pulumi:"incrementalExportSpecification"`
	// Name of the Amazon S3 bucket to export the snapshot to. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport_Requesting.html#S3DataExport_Requesting_Permissions) for information on how configure this S3 bucket.
	S3Bucket string `pulumi:"s3Bucket"`
	// ID of the AWS account that owns the bucket the export will be stored in.
	S3BucketOwner *string `pulumi:"s3BucketOwner"`
	// Amazon S3 bucket prefix to use as the file name and path of the exported snapshot.
	S3Prefix *string `pulumi:"s3Prefix"`
	// Type of encryption used on the bucket where export data will be stored. Valid values are: `AES256`, `KMS`.
	S3SseAlgorithm *string `pulumi:"s3SseAlgorithm"`
	// ID of the AWS KMS managed key used to encrypt the S3 bucket where export data will be stored (if applicable).
	S3SseKmsKeyId *string `pulumi:"s3SseKmsKeyId"`
	// ARN associated with the table to export.
	//
	// The following arguments are optional:
	TableArn string `pulumi:"tableArn"`
}

// The set of arguments for constructing a TableExport resource.
type TableExportArgs struct {
	// Format for the exported data. Valid values are: `DYNAMODB_JSON`, `ION`. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport.Output.html#S3DataExport.Output_Data) for more information on these export formats. Default is `DYNAMODB_JSON`.
	ExportFormat pulumi.StringPtrInput
	// Time in RFC3339 format from which to export table data. The table export will be a snapshot of the table's state at this point in time. Omitting this value will result in a snapshot from the current time.
	ExportTime pulumi.StringPtrInput
	// Whether to execute as a full export or incremental export. Valid values are: `FULL_EXPORT`, `INCREMENTAL_EXPORT`. Defaults to `FULL_EXPORT`. If `INCREMENTAL_EXPORT` is provided, the `incrementalExportSpecification` argument must also be provided.
	// `incrementalExportSpecification` - (Optional, Forces new resource) Parameters specific to an incremental export. See `incrementalExportSpecification` Block for details.
	ExportType                     pulumi.StringPtrInput
	IncrementalExportSpecification TableExportIncrementalExportSpecificationPtrInput
	// Name of the Amazon S3 bucket to export the snapshot to. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport_Requesting.html#S3DataExport_Requesting_Permissions) for information on how configure this S3 bucket.
	S3Bucket pulumi.StringInput
	// ID of the AWS account that owns the bucket the export will be stored in.
	S3BucketOwner pulumi.StringPtrInput
	// Amazon S3 bucket prefix to use as the file name and path of the exported snapshot.
	S3Prefix pulumi.StringPtrInput
	// Type of encryption used on the bucket where export data will be stored. Valid values are: `AES256`, `KMS`.
	S3SseAlgorithm pulumi.StringPtrInput
	// ID of the AWS KMS managed key used to encrypt the S3 bucket where export data will be stored (if applicable).
	S3SseKmsKeyId pulumi.StringPtrInput
	// ARN associated with the table to export.
	//
	// The following arguments are optional:
	TableArn pulumi.StringInput
}

func (TableExportArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*tableExportArgs)(nil)).Elem()
}

type TableExportInput interface {
	pulumi.Input

	ToTableExportOutput() TableExportOutput
	ToTableExportOutputWithContext(ctx context.Context) TableExportOutput
}

func (*TableExport) ElementType() reflect.Type {
	return reflect.TypeOf((**TableExport)(nil)).Elem()
}

func (i *TableExport) ToTableExportOutput() TableExportOutput {
	return i.ToTableExportOutputWithContext(context.Background())
}

func (i *TableExport) ToTableExportOutputWithContext(ctx context.Context) TableExportOutput {
	return pulumi.ToOutputWithContext(ctx, i).(TableExportOutput)
}

// TableExportArrayInput is an input type that accepts TableExportArray and TableExportArrayOutput values.
// You can construct a concrete instance of `TableExportArrayInput` via:
//
//	TableExportArray{ TableExportArgs{...} }
type TableExportArrayInput interface {
	pulumi.Input

	ToTableExportArrayOutput() TableExportArrayOutput
	ToTableExportArrayOutputWithContext(context.Context) TableExportArrayOutput
}

type TableExportArray []TableExportInput

func (TableExportArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*TableExport)(nil)).Elem()
}

func (i TableExportArray) ToTableExportArrayOutput() TableExportArrayOutput {
	return i.ToTableExportArrayOutputWithContext(context.Background())
}

func (i TableExportArray) ToTableExportArrayOutputWithContext(ctx context.Context) TableExportArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(TableExportArrayOutput)
}

// TableExportMapInput is an input type that accepts TableExportMap and TableExportMapOutput values.
// You can construct a concrete instance of `TableExportMapInput` via:
//
//	TableExportMap{ "key": TableExportArgs{...} }
type TableExportMapInput interface {
	pulumi.Input

	ToTableExportMapOutput() TableExportMapOutput
	ToTableExportMapOutputWithContext(context.Context) TableExportMapOutput
}

type TableExportMap map[string]TableExportInput

func (TableExportMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*TableExport)(nil)).Elem()
}

func (i TableExportMap) ToTableExportMapOutput() TableExportMapOutput {
	return i.ToTableExportMapOutputWithContext(context.Background())
}

func (i TableExportMap) ToTableExportMapOutputWithContext(ctx context.Context) TableExportMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(TableExportMapOutput)
}

type TableExportOutput struct{ *pulumi.OutputState }

func (TableExportOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**TableExport)(nil)).Elem()
}

func (o TableExportOutput) ToTableExportOutput() TableExportOutput {
	return o
}

func (o TableExportOutput) ToTableExportOutputWithContext(ctx context.Context) TableExportOutput {
	return o
}

// ARN of the Table Export.
func (o TableExportOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *TableExport) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Billable size of the table export.
func (o TableExportOutput) BilledSizeInBytes() pulumi.IntOutput {
	return o.ApplyT(func(v *TableExport) pulumi.IntOutput { return v.BilledSizeInBytes }).(pulumi.IntOutput)
}

// Time at which the export task completed.
func (o TableExportOutput) EndTime() pulumi.StringOutput {
	return o.ApplyT(func(v *TableExport) pulumi.StringOutput { return v.EndTime }).(pulumi.StringOutput)
}

// Format for the exported data. Valid values are: `DYNAMODB_JSON`, `ION`. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport.Output.html#S3DataExport.Output_Data) for more information on these export formats. Default is `DYNAMODB_JSON`.
func (o TableExportOutput) ExportFormat() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *TableExport) pulumi.StringPtrOutput { return v.ExportFormat }).(pulumi.StringPtrOutput)
}

// Status of the export - export can be in one of the following states `IN_PROGRESS`, `COMPLETED`, or `FAILED`.
func (o TableExportOutput) ExportStatus() pulumi.StringOutput {
	return o.ApplyT(func(v *TableExport) pulumi.StringOutput { return v.ExportStatus }).(pulumi.StringOutput)
}

// Time in RFC3339 format from which to export table data. The table export will be a snapshot of the table's state at this point in time. Omitting this value will result in a snapshot from the current time.
func (o TableExportOutput) ExportTime() pulumi.StringOutput {
	return o.ApplyT(func(v *TableExport) pulumi.StringOutput { return v.ExportTime }).(pulumi.StringOutput)
}

// Whether to execute as a full export or incremental export. Valid values are: `FULL_EXPORT`, `INCREMENTAL_EXPORT`. Defaults to `FULL_EXPORT`. If `INCREMENTAL_EXPORT` is provided, the `incrementalExportSpecification` argument must also be provided.
// `incrementalExportSpecification` - (Optional, Forces new resource) Parameters specific to an incremental export. See `incrementalExportSpecification` Block for details.
func (o TableExportOutput) ExportType() pulumi.StringOutput {
	return o.ApplyT(func(v *TableExport) pulumi.StringOutput { return v.ExportType }).(pulumi.StringOutput)
}

func (o TableExportOutput) IncrementalExportSpecification() TableExportIncrementalExportSpecificationPtrOutput {
	return o.ApplyT(func(v *TableExport) TableExportIncrementalExportSpecificationPtrOutput {
		return v.IncrementalExportSpecification
	}).(TableExportIncrementalExportSpecificationPtrOutput)
}

// Number of items exported.
func (o TableExportOutput) ItemCount() pulumi.IntOutput {
	return o.ApplyT(func(v *TableExport) pulumi.IntOutput { return v.ItemCount }).(pulumi.IntOutput)
}

// Name of the manifest file for the export task. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport.Output.html#S3DataExport.Output_Manifest) for more information on this manifest file.
func (o TableExportOutput) ManifestFilesS3Key() pulumi.StringOutput {
	return o.ApplyT(func(v *TableExport) pulumi.StringOutput { return v.ManifestFilesS3Key }).(pulumi.StringOutput)
}

// Name of the Amazon S3 bucket to export the snapshot to. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport_Requesting.html#S3DataExport_Requesting_Permissions) for information on how configure this S3 bucket.
func (o TableExportOutput) S3Bucket() pulumi.StringOutput {
	return o.ApplyT(func(v *TableExport) pulumi.StringOutput { return v.S3Bucket }).(pulumi.StringOutput)
}

// ID of the AWS account that owns the bucket the export will be stored in.
func (o TableExportOutput) S3BucketOwner() pulumi.StringOutput {
	return o.ApplyT(func(v *TableExport) pulumi.StringOutput { return v.S3BucketOwner }).(pulumi.StringOutput)
}

// Amazon S3 bucket prefix to use as the file name and path of the exported snapshot.
func (o TableExportOutput) S3Prefix() pulumi.StringOutput {
	return o.ApplyT(func(v *TableExport) pulumi.StringOutput { return v.S3Prefix }).(pulumi.StringOutput)
}

// Type of encryption used on the bucket where export data will be stored. Valid values are: `AES256`, `KMS`.
func (o TableExportOutput) S3SseAlgorithm() pulumi.StringOutput {
	return o.ApplyT(func(v *TableExport) pulumi.StringOutput { return v.S3SseAlgorithm }).(pulumi.StringOutput)
}

// ID of the AWS KMS managed key used to encrypt the S3 bucket where export data will be stored (if applicable).
func (o TableExportOutput) S3SseKmsKeyId() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *TableExport) pulumi.StringPtrOutput { return v.S3SseKmsKeyId }).(pulumi.StringPtrOutput)
}

// Time at which the export task began.
func (o TableExportOutput) StartTime() pulumi.StringOutput {
	return o.ApplyT(func(v *TableExport) pulumi.StringOutput { return v.StartTime }).(pulumi.StringOutput)
}

// ARN associated with the table to export.
//
// The following arguments are optional:
func (o TableExportOutput) TableArn() pulumi.StringOutput {
	return o.ApplyT(func(v *TableExport) pulumi.StringOutput { return v.TableArn }).(pulumi.StringOutput)
}

type TableExportArrayOutput struct{ *pulumi.OutputState }

func (TableExportArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*TableExport)(nil)).Elem()
}

func (o TableExportArrayOutput) ToTableExportArrayOutput() TableExportArrayOutput {
	return o
}

func (o TableExportArrayOutput) ToTableExportArrayOutputWithContext(ctx context.Context) TableExportArrayOutput {
	return o
}

func (o TableExportArrayOutput) Index(i pulumi.IntInput) TableExportOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *TableExport {
		return vs[0].([]*TableExport)[vs[1].(int)]
	}).(TableExportOutput)
}

type TableExportMapOutput struct{ *pulumi.OutputState }

func (TableExportMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*TableExport)(nil)).Elem()
}

func (o TableExportMapOutput) ToTableExportMapOutput() TableExportMapOutput {
	return o
}

func (o TableExportMapOutput) ToTableExportMapOutputWithContext(ctx context.Context) TableExportMapOutput {
	return o
}

func (o TableExportMapOutput) MapIndex(k pulumi.StringInput) TableExportOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *TableExport {
		return vs[0].(map[string]*TableExport)[vs[1].(string)]
	}).(TableExportOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*TableExportInput)(nil)).Elem(), &TableExport{})
	pulumi.RegisterInputType(reflect.TypeOf((*TableExportArrayInput)(nil)).Elem(), TableExportArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*TableExportMapInput)(nil)).Elem(), TableExportMap{})
	pulumi.RegisterOutputType(TableExportOutput{})
	pulumi.RegisterOutputType(TableExportArrayOutput{})
	pulumi.RegisterOutputType(TableExportMapOutput{})
}
