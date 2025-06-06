// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package rds

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS RDS (Relational Database) Export Task.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/rds"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := rds.NewExportTask(ctx, "example", &rds.ExportTaskArgs{
//				ExportTaskIdentifier: pulumi.String("example"),
//				SourceArn:            pulumi.Any(exampleAwsDbSnapshot.DbSnapshotArn),
//				S3BucketName:         pulumi.Any(exampleAwsS3Bucket.Id),
//				IamRoleArn:           pulumi.Any(exampleAwsIamRole.Arn),
//				KmsKeyId:             pulumi.Any(exampleAwsKmsKey.Arn),
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
// ### Complete Usage
//
// ```go
// package main
//
// import (
//
//	"encoding/json"
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/iam"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/kms"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/rds"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/s3"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			exampleBucketV2, err := s3.NewBucketV2(ctx, "example", &s3.BucketV2Args{
//				Bucket:       pulumi.String("example"),
//				ForceDestroy: pulumi.Bool(true),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = s3.NewBucketAclV2(ctx, "example", &s3.BucketAclV2Args{
//				Bucket: exampleBucketV2.ID(),
//				Acl:    pulumi.String("private"),
//			})
//			if err != nil {
//				return err
//			}
//			tmpJSON0, err := json.Marshal(map[string]interface{}{
//				"Version": "2012-10-17",
//				"Statement": []map[string]interface{}{
//					map[string]interface{}{
//						"Action": "sts:AssumeRole",
//						"Effect": "Allow",
//						"Sid":    "",
//						"Principal": map[string]interface{}{
//							"Service": "export.rds.amazonaws.com",
//						},
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			json0 := string(tmpJSON0)
//			exampleRole, err := iam.NewRole(ctx, "example", &iam.RoleArgs{
//				Name:             pulumi.String("example"),
//				AssumeRolePolicy: pulumi.String(json0),
//			})
//			if err != nil {
//				return err
//			}
//			example := iam.GetPolicyDocumentOutput(ctx, iam.GetPolicyDocumentOutputArgs{
//				Statements: iam.GetPolicyDocumentStatementArray{
//					&iam.GetPolicyDocumentStatementArgs{
//						Actions: pulumi.StringArray{
//							pulumi.String("s3:ListAllMyBuckets"),
//						},
//						Resources: pulumi.StringArray{
//							pulumi.String("*"),
//						},
//					},
//					&iam.GetPolicyDocumentStatementArgs{
//						Actions: pulumi.StringArray{
//							pulumi.String("s3:GetBucketLocation"),
//							pulumi.String("s3:ListBucket"),
//						},
//						Resources: pulumi.StringArray{
//							exampleBucketV2.Arn,
//						},
//					},
//					&iam.GetPolicyDocumentStatementArgs{
//						Actions: pulumi.StringArray{
//							pulumi.String("s3:GetObject"),
//							pulumi.String("s3:PutObject"),
//							pulumi.String("s3:DeleteObject"),
//						},
//						Resources: pulumi.StringArray{
//							exampleBucketV2.Arn.ApplyT(func(arn string) (string, error) {
//								return fmt.Sprintf("%v/*", arn), nil
//							}).(pulumi.StringOutput),
//						},
//					},
//				},
//			}, nil)
//			examplePolicy, err := iam.NewPolicy(ctx, "example", &iam.PolicyArgs{
//				Name: pulumi.String("example"),
//				Policy: pulumi.String(example.ApplyT(func(example iam.GetPolicyDocumentResult) (*string, error) {
//					return &example.Json, nil
//				}).(pulumi.StringPtrOutput)),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = iam.NewRolePolicyAttachment(ctx, "example", &iam.RolePolicyAttachmentArgs{
//				Role:      exampleRole.Name,
//				PolicyArn: examplePolicy.Arn,
//			})
//			if err != nil {
//				return err
//			}
//			exampleKey, err := kms.NewKey(ctx, "example", &kms.KeyArgs{
//				DeletionWindowInDays: pulumi.Int(10),
//			})
//			if err != nil {
//				return err
//			}
//			exampleInstance, err := rds.NewInstance(ctx, "example", &rds.InstanceArgs{
//				Identifier:         pulumi.String("example"),
//				AllocatedStorage:   pulumi.Int(10),
//				DbName:             pulumi.String("test"),
//				Engine:             pulumi.String("mysql"),
//				EngineVersion:      pulumi.String("5.7"),
//				InstanceClass:      pulumi.String(rds.InstanceType_T3_Micro),
//				Username:           pulumi.String("foo"),
//				Password:           pulumi.String("foobarbaz"),
//				ParameterGroupName: pulumi.String("default.mysql5.7"),
//				SkipFinalSnapshot:  pulumi.Bool(true),
//			})
//			if err != nil {
//				return err
//			}
//			exampleSnapshot, err := rds.NewSnapshot(ctx, "example", &rds.SnapshotArgs{
//				DbInstanceIdentifier: exampleInstance.Identifier,
//				DbSnapshotIdentifier: pulumi.String("example"),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = rds.NewExportTask(ctx, "example", &rds.ExportTaskArgs{
//				ExportTaskIdentifier: pulumi.String("example"),
//				SourceArn:            exampleSnapshot.DbSnapshotArn,
//				S3BucketName:         exampleBucketV2.ID(),
//				IamRoleArn:           exampleRole.Arn,
//				KmsKeyId:             exampleKey.Arn,
//				ExportOnlies: pulumi.StringArray{
//					pulumi.String("database"),
//				},
//				S3Prefix: pulumi.String("my_prefix/example"),
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
// Using `pulumi import`, import a RDS (Relational Database) Export Task using the `export_task_identifier`. For example:
//
// ```sh
// $ pulumi import aws:rds/exportTask:ExportTask example example
// ```
type ExportTask struct {
	pulumi.CustomResourceState

	// Data to be exported from the snapshot. If this parameter is not provided, all the snapshot data is exported. Valid values are documented in the [AWS StartExportTask API documentation](https://docs.aws.amazon.com/AmazonRDS/latest/APIReference/API_StartExportTask.html#API_StartExportTask_RequestParameters).
	ExportOnlies pulumi.StringArrayOutput `pulumi:"exportOnlies"`
	// Unique identifier for the snapshot export task.
	ExportTaskIdentifier pulumi.StringOutput `pulumi:"exportTaskIdentifier"`
	// Reason the export failed, if it failed.
	FailureCause pulumi.StringOutput `pulumi:"failureCause"`
	// ARN of the IAM role to use for writing to the Amazon S3 bucket.
	IamRoleArn pulumi.StringOutput `pulumi:"iamRoleArn"`
	// ID of the Amazon Web Services KMS key to use to encrypt the snapshot.
	KmsKeyId pulumi.StringOutput `pulumi:"kmsKeyId"`
	// Progress of the snapshot export task as a percentage.
	PercentProgress pulumi.IntOutput `pulumi:"percentProgress"`
	// Name of the Amazon S3 bucket to export the snapshot to.
	S3BucketName pulumi.StringOutput `pulumi:"s3BucketName"`
	// Amazon S3 bucket prefix to use as the file name and path of the exported snapshot.
	S3Prefix pulumi.StringOutput `pulumi:"s3Prefix"`
	// Time that the snapshot was created.
	SnapshotTime pulumi.StringOutput `pulumi:"snapshotTime"`
	// Amazon Resource Name (ARN) of the snapshot to export.
	//
	// The following arguments are optional:
	SourceArn pulumi.StringOutput `pulumi:"sourceArn"`
	// Type of source for the export.
	SourceType pulumi.StringOutput `pulumi:"sourceType"`
	// Status of the export task.
	Status pulumi.StringOutput `pulumi:"status"`
	// Time that the snapshot export task completed.
	TaskEndTime pulumi.StringOutput `pulumi:"taskEndTime"`
	// Time that the snapshot export task started.
	TaskStartTime pulumi.StringOutput         `pulumi:"taskStartTime"`
	Timeouts      ExportTaskTimeoutsPtrOutput `pulumi:"timeouts"`
	// Warning about the snapshot export task, if any.
	WarningMessage pulumi.StringOutput `pulumi:"warningMessage"`
}

// NewExportTask registers a new resource with the given unique name, arguments, and options.
func NewExportTask(ctx *pulumi.Context,
	name string, args *ExportTaskArgs, opts ...pulumi.ResourceOption) (*ExportTask, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.ExportTaskIdentifier == nil {
		return nil, errors.New("invalid value for required argument 'ExportTaskIdentifier'")
	}
	if args.IamRoleArn == nil {
		return nil, errors.New("invalid value for required argument 'IamRoleArn'")
	}
	if args.KmsKeyId == nil {
		return nil, errors.New("invalid value for required argument 'KmsKeyId'")
	}
	if args.S3BucketName == nil {
		return nil, errors.New("invalid value for required argument 'S3BucketName'")
	}
	if args.SourceArn == nil {
		return nil, errors.New("invalid value for required argument 'SourceArn'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource ExportTask
	err := ctx.RegisterResource("aws:rds/exportTask:ExportTask", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetExportTask gets an existing ExportTask resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetExportTask(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ExportTaskState, opts ...pulumi.ResourceOption) (*ExportTask, error) {
	var resource ExportTask
	err := ctx.ReadResource("aws:rds/exportTask:ExportTask", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering ExportTask resources.
type exportTaskState struct {
	// Data to be exported from the snapshot. If this parameter is not provided, all the snapshot data is exported. Valid values are documented in the [AWS StartExportTask API documentation](https://docs.aws.amazon.com/AmazonRDS/latest/APIReference/API_StartExportTask.html#API_StartExportTask_RequestParameters).
	ExportOnlies []string `pulumi:"exportOnlies"`
	// Unique identifier for the snapshot export task.
	ExportTaskIdentifier *string `pulumi:"exportTaskIdentifier"`
	// Reason the export failed, if it failed.
	FailureCause *string `pulumi:"failureCause"`
	// ARN of the IAM role to use for writing to the Amazon S3 bucket.
	IamRoleArn *string `pulumi:"iamRoleArn"`
	// ID of the Amazon Web Services KMS key to use to encrypt the snapshot.
	KmsKeyId *string `pulumi:"kmsKeyId"`
	// Progress of the snapshot export task as a percentage.
	PercentProgress *int `pulumi:"percentProgress"`
	// Name of the Amazon S3 bucket to export the snapshot to.
	S3BucketName *string `pulumi:"s3BucketName"`
	// Amazon S3 bucket prefix to use as the file name and path of the exported snapshot.
	S3Prefix *string `pulumi:"s3Prefix"`
	// Time that the snapshot was created.
	SnapshotTime *string `pulumi:"snapshotTime"`
	// Amazon Resource Name (ARN) of the snapshot to export.
	//
	// The following arguments are optional:
	SourceArn *string `pulumi:"sourceArn"`
	// Type of source for the export.
	SourceType *string `pulumi:"sourceType"`
	// Status of the export task.
	Status *string `pulumi:"status"`
	// Time that the snapshot export task completed.
	TaskEndTime *string `pulumi:"taskEndTime"`
	// Time that the snapshot export task started.
	TaskStartTime *string             `pulumi:"taskStartTime"`
	Timeouts      *ExportTaskTimeouts `pulumi:"timeouts"`
	// Warning about the snapshot export task, if any.
	WarningMessage *string `pulumi:"warningMessage"`
}

type ExportTaskState struct {
	// Data to be exported from the snapshot. If this parameter is not provided, all the snapshot data is exported. Valid values are documented in the [AWS StartExportTask API documentation](https://docs.aws.amazon.com/AmazonRDS/latest/APIReference/API_StartExportTask.html#API_StartExportTask_RequestParameters).
	ExportOnlies pulumi.StringArrayInput
	// Unique identifier for the snapshot export task.
	ExportTaskIdentifier pulumi.StringPtrInput
	// Reason the export failed, if it failed.
	FailureCause pulumi.StringPtrInput
	// ARN of the IAM role to use for writing to the Amazon S3 bucket.
	IamRoleArn pulumi.StringPtrInput
	// ID of the Amazon Web Services KMS key to use to encrypt the snapshot.
	KmsKeyId pulumi.StringPtrInput
	// Progress of the snapshot export task as a percentage.
	PercentProgress pulumi.IntPtrInput
	// Name of the Amazon S3 bucket to export the snapshot to.
	S3BucketName pulumi.StringPtrInput
	// Amazon S3 bucket prefix to use as the file name and path of the exported snapshot.
	S3Prefix pulumi.StringPtrInput
	// Time that the snapshot was created.
	SnapshotTime pulumi.StringPtrInput
	// Amazon Resource Name (ARN) of the snapshot to export.
	//
	// The following arguments are optional:
	SourceArn pulumi.StringPtrInput
	// Type of source for the export.
	SourceType pulumi.StringPtrInput
	// Status of the export task.
	Status pulumi.StringPtrInput
	// Time that the snapshot export task completed.
	TaskEndTime pulumi.StringPtrInput
	// Time that the snapshot export task started.
	TaskStartTime pulumi.StringPtrInput
	Timeouts      ExportTaskTimeoutsPtrInput
	// Warning about the snapshot export task, if any.
	WarningMessage pulumi.StringPtrInput
}

func (ExportTaskState) ElementType() reflect.Type {
	return reflect.TypeOf((*exportTaskState)(nil)).Elem()
}

type exportTaskArgs struct {
	// Data to be exported from the snapshot. If this parameter is not provided, all the snapshot data is exported. Valid values are documented in the [AWS StartExportTask API documentation](https://docs.aws.amazon.com/AmazonRDS/latest/APIReference/API_StartExportTask.html#API_StartExportTask_RequestParameters).
	ExportOnlies []string `pulumi:"exportOnlies"`
	// Unique identifier for the snapshot export task.
	ExportTaskIdentifier string `pulumi:"exportTaskIdentifier"`
	// ARN of the IAM role to use for writing to the Amazon S3 bucket.
	IamRoleArn string `pulumi:"iamRoleArn"`
	// ID of the Amazon Web Services KMS key to use to encrypt the snapshot.
	KmsKeyId string `pulumi:"kmsKeyId"`
	// Name of the Amazon S3 bucket to export the snapshot to.
	S3BucketName string `pulumi:"s3BucketName"`
	// Amazon S3 bucket prefix to use as the file name and path of the exported snapshot.
	S3Prefix *string `pulumi:"s3Prefix"`
	// Amazon Resource Name (ARN) of the snapshot to export.
	//
	// The following arguments are optional:
	SourceArn string              `pulumi:"sourceArn"`
	Timeouts  *ExportTaskTimeouts `pulumi:"timeouts"`
}

// The set of arguments for constructing a ExportTask resource.
type ExportTaskArgs struct {
	// Data to be exported from the snapshot. If this parameter is not provided, all the snapshot data is exported. Valid values are documented in the [AWS StartExportTask API documentation](https://docs.aws.amazon.com/AmazonRDS/latest/APIReference/API_StartExportTask.html#API_StartExportTask_RequestParameters).
	ExportOnlies pulumi.StringArrayInput
	// Unique identifier for the snapshot export task.
	ExportTaskIdentifier pulumi.StringInput
	// ARN of the IAM role to use for writing to the Amazon S3 bucket.
	IamRoleArn pulumi.StringInput
	// ID of the Amazon Web Services KMS key to use to encrypt the snapshot.
	KmsKeyId pulumi.StringInput
	// Name of the Amazon S3 bucket to export the snapshot to.
	S3BucketName pulumi.StringInput
	// Amazon S3 bucket prefix to use as the file name and path of the exported snapshot.
	S3Prefix pulumi.StringPtrInput
	// Amazon Resource Name (ARN) of the snapshot to export.
	//
	// The following arguments are optional:
	SourceArn pulumi.StringInput
	Timeouts  ExportTaskTimeoutsPtrInput
}

func (ExportTaskArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*exportTaskArgs)(nil)).Elem()
}

type ExportTaskInput interface {
	pulumi.Input

	ToExportTaskOutput() ExportTaskOutput
	ToExportTaskOutputWithContext(ctx context.Context) ExportTaskOutput
}

func (*ExportTask) ElementType() reflect.Type {
	return reflect.TypeOf((**ExportTask)(nil)).Elem()
}

func (i *ExportTask) ToExportTaskOutput() ExportTaskOutput {
	return i.ToExportTaskOutputWithContext(context.Background())
}

func (i *ExportTask) ToExportTaskOutputWithContext(ctx context.Context) ExportTaskOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ExportTaskOutput)
}

// ExportTaskArrayInput is an input type that accepts ExportTaskArray and ExportTaskArrayOutput values.
// You can construct a concrete instance of `ExportTaskArrayInput` via:
//
//	ExportTaskArray{ ExportTaskArgs{...} }
type ExportTaskArrayInput interface {
	pulumi.Input

	ToExportTaskArrayOutput() ExportTaskArrayOutput
	ToExportTaskArrayOutputWithContext(context.Context) ExportTaskArrayOutput
}

type ExportTaskArray []ExportTaskInput

func (ExportTaskArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ExportTask)(nil)).Elem()
}

func (i ExportTaskArray) ToExportTaskArrayOutput() ExportTaskArrayOutput {
	return i.ToExportTaskArrayOutputWithContext(context.Background())
}

func (i ExportTaskArray) ToExportTaskArrayOutputWithContext(ctx context.Context) ExportTaskArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ExportTaskArrayOutput)
}

// ExportTaskMapInput is an input type that accepts ExportTaskMap and ExportTaskMapOutput values.
// You can construct a concrete instance of `ExportTaskMapInput` via:
//
//	ExportTaskMap{ "key": ExportTaskArgs{...} }
type ExportTaskMapInput interface {
	pulumi.Input

	ToExportTaskMapOutput() ExportTaskMapOutput
	ToExportTaskMapOutputWithContext(context.Context) ExportTaskMapOutput
}

type ExportTaskMap map[string]ExportTaskInput

func (ExportTaskMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ExportTask)(nil)).Elem()
}

func (i ExportTaskMap) ToExportTaskMapOutput() ExportTaskMapOutput {
	return i.ToExportTaskMapOutputWithContext(context.Background())
}

func (i ExportTaskMap) ToExportTaskMapOutputWithContext(ctx context.Context) ExportTaskMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ExportTaskMapOutput)
}

type ExportTaskOutput struct{ *pulumi.OutputState }

func (ExportTaskOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**ExportTask)(nil)).Elem()
}

func (o ExportTaskOutput) ToExportTaskOutput() ExportTaskOutput {
	return o
}

func (o ExportTaskOutput) ToExportTaskOutputWithContext(ctx context.Context) ExportTaskOutput {
	return o
}

// Data to be exported from the snapshot. If this parameter is not provided, all the snapshot data is exported. Valid values are documented in the [AWS StartExportTask API documentation](https://docs.aws.amazon.com/AmazonRDS/latest/APIReference/API_StartExportTask.html#API_StartExportTask_RequestParameters).
func (o ExportTaskOutput) ExportOnlies() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *ExportTask) pulumi.StringArrayOutput { return v.ExportOnlies }).(pulumi.StringArrayOutput)
}

// Unique identifier for the snapshot export task.
func (o ExportTaskOutput) ExportTaskIdentifier() pulumi.StringOutput {
	return o.ApplyT(func(v *ExportTask) pulumi.StringOutput { return v.ExportTaskIdentifier }).(pulumi.StringOutput)
}

// Reason the export failed, if it failed.
func (o ExportTaskOutput) FailureCause() pulumi.StringOutput {
	return o.ApplyT(func(v *ExportTask) pulumi.StringOutput { return v.FailureCause }).(pulumi.StringOutput)
}

// ARN of the IAM role to use for writing to the Amazon S3 bucket.
func (o ExportTaskOutput) IamRoleArn() pulumi.StringOutput {
	return o.ApplyT(func(v *ExportTask) pulumi.StringOutput { return v.IamRoleArn }).(pulumi.StringOutput)
}

// ID of the Amazon Web Services KMS key to use to encrypt the snapshot.
func (o ExportTaskOutput) KmsKeyId() pulumi.StringOutput {
	return o.ApplyT(func(v *ExportTask) pulumi.StringOutput { return v.KmsKeyId }).(pulumi.StringOutput)
}

// Progress of the snapshot export task as a percentage.
func (o ExportTaskOutput) PercentProgress() pulumi.IntOutput {
	return o.ApplyT(func(v *ExportTask) pulumi.IntOutput { return v.PercentProgress }).(pulumi.IntOutput)
}

// Name of the Amazon S3 bucket to export the snapshot to.
func (o ExportTaskOutput) S3BucketName() pulumi.StringOutput {
	return o.ApplyT(func(v *ExportTask) pulumi.StringOutput { return v.S3BucketName }).(pulumi.StringOutput)
}

// Amazon S3 bucket prefix to use as the file name and path of the exported snapshot.
func (o ExportTaskOutput) S3Prefix() pulumi.StringOutput {
	return o.ApplyT(func(v *ExportTask) pulumi.StringOutput { return v.S3Prefix }).(pulumi.StringOutput)
}

// Time that the snapshot was created.
func (o ExportTaskOutput) SnapshotTime() pulumi.StringOutput {
	return o.ApplyT(func(v *ExportTask) pulumi.StringOutput { return v.SnapshotTime }).(pulumi.StringOutput)
}

// Amazon Resource Name (ARN) of the snapshot to export.
//
// The following arguments are optional:
func (o ExportTaskOutput) SourceArn() pulumi.StringOutput {
	return o.ApplyT(func(v *ExportTask) pulumi.StringOutput { return v.SourceArn }).(pulumi.StringOutput)
}

// Type of source for the export.
func (o ExportTaskOutput) SourceType() pulumi.StringOutput {
	return o.ApplyT(func(v *ExportTask) pulumi.StringOutput { return v.SourceType }).(pulumi.StringOutput)
}

// Status of the export task.
func (o ExportTaskOutput) Status() pulumi.StringOutput {
	return o.ApplyT(func(v *ExportTask) pulumi.StringOutput { return v.Status }).(pulumi.StringOutput)
}

// Time that the snapshot export task completed.
func (o ExportTaskOutput) TaskEndTime() pulumi.StringOutput {
	return o.ApplyT(func(v *ExportTask) pulumi.StringOutput { return v.TaskEndTime }).(pulumi.StringOutput)
}

// Time that the snapshot export task started.
func (o ExportTaskOutput) TaskStartTime() pulumi.StringOutput {
	return o.ApplyT(func(v *ExportTask) pulumi.StringOutput { return v.TaskStartTime }).(pulumi.StringOutput)
}

func (o ExportTaskOutput) Timeouts() ExportTaskTimeoutsPtrOutput {
	return o.ApplyT(func(v *ExportTask) ExportTaskTimeoutsPtrOutput { return v.Timeouts }).(ExportTaskTimeoutsPtrOutput)
}

// Warning about the snapshot export task, if any.
func (o ExportTaskOutput) WarningMessage() pulumi.StringOutput {
	return o.ApplyT(func(v *ExportTask) pulumi.StringOutput { return v.WarningMessage }).(pulumi.StringOutput)
}

type ExportTaskArrayOutput struct{ *pulumi.OutputState }

func (ExportTaskArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ExportTask)(nil)).Elem()
}

func (o ExportTaskArrayOutput) ToExportTaskArrayOutput() ExportTaskArrayOutput {
	return o
}

func (o ExportTaskArrayOutput) ToExportTaskArrayOutputWithContext(ctx context.Context) ExportTaskArrayOutput {
	return o
}

func (o ExportTaskArrayOutput) Index(i pulumi.IntInput) ExportTaskOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *ExportTask {
		return vs[0].([]*ExportTask)[vs[1].(int)]
	}).(ExportTaskOutput)
}

type ExportTaskMapOutput struct{ *pulumi.OutputState }

func (ExportTaskMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ExportTask)(nil)).Elem()
}

func (o ExportTaskMapOutput) ToExportTaskMapOutput() ExportTaskMapOutput {
	return o
}

func (o ExportTaskMapOutput) ToExportTaskMapOutputWithContext(ctx context.Context) ExportTaskMapOutput {
	return o
}

func (o ExportTaskMapOutput) MapIndex(k pulumi.StringInput) ExportTaskOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *ExportTask {
		return vs[0].(map[string]*ExportTask)[vs[1].(string)]
	}).(ExportTaskOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ExportTaskInput)(nil)).Elem(), &ExportTask{})
	pulumi.RegisterInputType(reflect.TypeOf((*ExportTaskArrayInput)(nil)).Elem(), ExportTaskArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ExportTaskMapInput)(nil)).Elem(), ExportTaskMap{})
	pulumi.RegisterOutputType(ExportTaskOutput{})
	pulumi.RegisterOutputType(ExportTaskArrayOutput{})
	pulumi.RegisterOutputType(ExportTaskMapOutput{})
}
