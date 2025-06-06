// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package ebs

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Creates a Snapshot of a snapshot.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/ebs"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			example, err := ebs.NewVolume(ctx, "example", &ebs.VolumeArgs{
//				AvailabilityZone: pulumi.String("us-west-2a"),
//				Size:             pulumi.Int(40),
//				Tags: pulumi.StringMap{
//					"Name": pulumi.String("HelloWorld"),
//				},
//			})
//			if err != nil {
//				return err
//			}
//			exampleSnapshot, err := ebs.NewSnapshot(ctx, "example_snapshot", &ebs.SnapshotArgs{
//				VolumeId: example.ID(),
//				Tags: pulumi.StringMap{
//					"Name": pulumi.String("HelloWorld_snap"),
//				},
//			})
//			if err != nil {
//				return err
//			}
//			_, err = ebs.NewSnapshotCopy(ctx, "example_copy", &ebs.SnapshotCopyArgs{
//				SourceSnapshotId: exampleSnapshot.ID(),
//				SourceRegion:     pulumi.String("us-west-2"),
//				Tags: pulumi.StringMap{
//					"Name": pulumi.String("HelloWorld_copy_snap"),
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
type SnapshotCopy struct {
	pulumi.CustomResourceState

	// Amazon Resource Name (ARN) of the EBS Snapshot.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Specifies a completion duration to initiate a time-based snapshot copy. Time-based snapshot copy operations complete within the specified duration.  Value must be between 15 and 2880 minutes, in 15 minute increments only.
	CompletionDurationMinutes pulumi.IntPtrOutput `pulumi:"completionDurationMinutes"`
	// The data encryption key identifier for the snapshot.
	DataEncryptionKeyId pulumi.StringOutput `pulumi:"dataEncryptionKeyId"`
	// A description of what the snapshot is.
	Description pulumi.StringPtrOutput `pulumi:"description"`
	// Whether the snapshot is encrypted.
	Encrypted pulumi.BoolPtrOutput `pulumi:"encrypted"`
	// The ARN for the KMS encryption key.
	KmsKeyId   pulumi.StringPtrOutput `pulumi:"kmsKeyId"`
	OutpostArn pulumi.StringOutput    `pulumi:"outpostArn"`
	// Value from an Amazon-maintained list (`amazon`, `aws-marketplace`, `microsoft`) of snapshot owners.
	OwnerAlias pulumi.StringOutput `pulumi:"ownerAlias"`
	// The AWS account ID of the snapshot owner.
	OwnerId pulumi.StringOutput `pulumi:"ownerId"`
	// Indicates whether to permanently restore an archived snapshot.
	PermanentRestore pulumi.BoolPtrOutput `pulumi:"permanentRestore"`
	// The region of the source snapshot.
	SourceRegion pulumi.StringOutput `pulumi:"sourceRegion"`
	// The ARN for the snapshot to be copied.
	SourceSnapshotId pulumi.StringOutput `pulumi:"sourceSnapshotId"`
	// The name of the storage tier. Valid values are `archive` and `standard`. Default value is `standard`.
	StorageTier pulumi.StringOutput `pulumi:"storageTier"`
	// A map of tags for the snapshot.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	// Specifies the number of days for which to temporarily restore an archived snapshot. Required for temporary restores only. The snapshot will be automatically re-archived after this period.
	TemporaryRestoreDays pulumi.IntPtrOutput `pulumi:"temporaryRestoreDays"`
	VolumeId             pulumi.StringOutput `pulumi:"volumeId"`
	// The size of the drive in GiBs.
	VolumeSize pulumi.IntOutput `pulumi:"volumeSize"`
}

// NewSnapshotCopy registers a new resource with the given unique name, arguments, and options.
func NewSnapshotCopy(ctx *pulumi.Context,
	name string, args *SnapshotCopyArgs, opts ...pulumi.ResourceOption) (*SnapshotCopy, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.SourceRegion == nil {
		return nil, errors.New("invalid value for required argument 'SourceRegion'")
	}
	if args.SourceSnapshotId == nil {
		return nil, errors.New("invalid value for required argument 'SourceSnapshotId'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource SnapshotCopy
	err := ctx.RegisterResource("aws:ebs/snapshotCopy:SnapshotCopy", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetSnapshotCopy gets an existing SnapshotCopy resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetSnapshotCopy(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *SnapshotCopyState, opts ...pulumi.ResourceOption) (*SnapshotCopy, error) {
	var resource SnapshotCopy
	err := ctx.ReadResource("aws:ebs/snapshotCopy:SnapshotCopy", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering SnapshotCopy resources.
type snapshotCopyState struct {
	// Amazon Resource Name (ARN) of the EBS Snapshot.
	Arn *string `pulumi:"arn"`
	// Specifies a completion duration to initiate a time-based snapshot copy. Time-based snapshot copy operations complete within the specified duration.  Value must be between 15 and 2880 minutes, in 15 minute increments only.
	CompletionDurationMinutes *int `pulumi:"completionDurationMinutes"`
	// The data encryption key identifier for the snapshot.
	DataEncryptionKeyId *string `pulumi:"dataEncryptionKeyId"`
	// A description of what the snapshot is.
	Description *string `pulumi:"description"`
	// Whether the snapshot is encrypted.
	Encrypted *bool `pulumi:"encrypted"`
	// The ARN for the KMS encryption key.
	KmsKeyId   *string `pulumi:"kmsKeyId"`
	OutpostArn *string `pulumi:"outpostArn"`
	// Value from an Amazon-maintained list (`amazon`, `aws-marketplace`, `microsoft`) of snapshot owners.
	OwnerAlias *string `pulumi:"ownerAlias"`
	// The AWS account ID of the snapshot owner.
	OwnerId *string `pulumi:"ownerId"`
	// Indicates whether to permanently restore an archived snapshot.
	PermanentRestore *bool `pulumi:"permanentRestore"`
	// The region of the source snapshot.
	SourceRegion *string `pulumi:"sourceRegion"`
	// The ARN for the snapshot to be copied.
	SourceSnapshotId *string `pulumi:"sourceSnapshotId"`
	// The name of the storage tier. Valid values are `archive` and `standard`. Default value is `standard`.
	StorageTier *string `pulumi:"storageTier"`
	// A map of tags for the snapshot.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	// Specifies the number of days for which to temporarily restore an archived snapshot. Required for temporary restores only. The snapshot will be automatically re-archived after this period.
	TemporaryRestoreDays *int    `pulumi:"temporaryRestoreDays"`
	VolumeId             *string `pulumi:"volumeId"`
	// The size of the drive in GiBs.
	VolumeSize *int `pulumi:"volumeSize"`
}

type SnapshotCopyState struct {
	// Amazon Resource Name (ARN) of the EBS Snapshot.
	Arn pulumi.StringPtrInput
	// Specifies a completion duration to initiate a time-based snapshot copy. Time-based snapshot copy operations complete within the specified duration.  Value must be between 15 and 2880 minutes, in 15 minute increments only.
	CompletionDurationMinutes pulumi.IntPtrInput
	// The data encryption key identifier for the snapshot.
	DataEncryptionKeyId pulumi.StringPtrInput
	// A description of what the snapshot is.
	Description pulumi.StringPtrInput
	// Whether the snapshot is encrypted.
	Encrypted pulumi.BoolPtrInput
	// The ARN for the KMS encryption key.
	KmsKeyId   pulumi.StringPtrInput
	OutpostArn pulumi.StringPtrInput
	// Value from an Amazon-maintained list (`amazon`, `aws-marketplace`, `microsoft`) of snapshot owners.
	OwnerAlias pulumi.StringPtrInput
	// The AWS account ID of the snapshot owner.
	OwnerId pulumi.StringPtrInput
	// Indicates whether to permanently restore an archived snapshot.
	PermanentRestore pulumi.BoolPtrInput
	// The region of the source snapshot.
	SourceRegion pulumi.StringPtrInput
	// The ARN for the snapshot to be copied.
	SourceSnapshotId pulumi.StringPtrInput
	// The name of the storage tier. Valid values are `archive` and `standard`. Default value is `standard`.
	StorageTier pulumi.StringPtrInput
	// A map of tags for the snapshot.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	// Specifies the number of days for which to temporarily restore an archived snapshot. Required for temporary restores only. The snapshot will be automatically re-archived after this period.
	TemporaryRestoreDays pulumi.IntPtrInput
	VolumeId             pulumi.StringPtrInput
	// The size of the drive in GiBs.
	VolumeSize pulumi.IntPtrInput
}

func (SnapshotCopyState) ElementType() reflect.Type {
	return reflect.TypeOf((*snapshotCopyState)(nil)).Elem()
}

type snapshotCopyArgs struct {
	// Specifies a completion duration to initiate a time-based snapshot copy. Time-based snapshot copy operations complete within the specified duration.  Value must be between 15 and 2880 minutes, in 15 minute increments only.
	CompletionDurationMinutes *int `pulumi:"completionDurationMinutes"`
	// A description of what the snapshot is.
	Description *string `pulumi:"description"`
	// Whether the snapshot is encrypted.
	Encrypted *bool `pulumi:"encrypted"`
	// The ARN for the KMS encryption key.
	KmsKeyId *string `pulumi:"kmsKeyId"`
	// Indicates whether to permanently restore an archived snapshot.
	PermanentRestore *bool `pulumi:"permanentRestore"`
	// The region of the source snapshot.
	SourceRegion string `pulumi:"sourceRegion"`
	// The ARN for the snapshot to be copied.
	SourceSnapshotId string `pulumi:"sourceSnapshotId"`
	// The name of the storage tier. Valid values are `archive` and `standard`. Default value is `standard`.
	StorageTier *string `pulumi:"storageTier"`
	// A map of tags for the snapshot.
	Tags map[string]string `pulumi:"tags"`
	// Specifies the number of days for which to temporarily restore an archived snapshot. Required for temporary restores only. The snapshot will be automatically re-archived after this period.
	TemporaryRestoreDays *int `pulumi:"temporaryRestoreDays"`
}

// The set of arguments for constructing a SnapshotCopy resource.
type SnapshotCopyArgs struct {
	// Specifies a completion duration to initiate a time-based snapshot copy. Time-based snapshot copy operations complete within the specified duration.  Value must be between 15 and 2880 minutes, in 15 minute increments only.
	CompletionDurationMinutes pulumi.IntPtrInput
	// A description of what the snapshot is.
	Description pulumi.StringPtrInput
	// Whether the snapshot is encrypted.
	Encrypted pulumi.BoolPtrInput
	// The ARN for the KMS encryption key.
	KmsKeyId pulumi.StringPtrInput
	// Indicates whether to permanently restore an archived snapshot.
	PermanentRestore pulumi.BoolPtrInput
	// The region of the source snapshot.
	SourceRegion pulumi.StringInput
	// The ARN for the snapshot to be copied.
	SourceSnapshotId pulumi.StringInput
	// The name of the storage tier. Valid values are `archive` and `standard`. Default value is `standard`.
	StorageTier pulumi.StringPtrInput
	// A map of tags for the snapshot.
	Tags pulumi.StringMapInput
	// Specifies the number of days for which to temporarily restore an archived snapshot. Required for temporary restores only. The snapshot will be automatically re-archived after this period.
	TemporaryRestoreDays pulumi.IntPtrInput
}

func (SnapshotCopyArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*snapshotCopyArgs)(nil)).Elem()
}

type SnapshotCopyInput interface {
	pulumi.Input

	ToSnapshotCopyOutput() SnapshotCopyOutput
	ToSnapshotCopyOutputWithContext(ctx context.Context) SnapshotCopyOutput
}

func (*SnapshotCopy) ElementType() reflect.Type {
	return reflect.TypeOf((**SnapshotCopy)(nil)).Elem()
}

func (i *SnapshotCopy) ToSnapshotCopyOutput() SnapshotCopyOutput {
	return i.ToSnapshotCopyOutputWithContext(context.Background())
}

func (i *SnapshotCopy) ToSnapshotCopyOutputWithContext(ctx context.Context) SnapshotCopyOutput {
	return pulumi.ToOutputWithContext(ctx, i).(SnapshotCopyOutput)
}

// SnapshotCopyArrayInput is an input type that accepts SnapshotCopyArray and SnapshotCopyArrayOutput values.
// You can construct a concrete instance of `SnapshotCopyArrayInput` via:
//
//	SnapshotCopyArray{ SnapshotCopyArgs{...} }
type SnapshotCopyArrayInput interface {
	pulumi.Input

	ToSnapshotCopyArrayOutput() SnapshotCopyArrayOutput
	ToSnapshotCopyArrayOutputWithContext(context.Context) SnapshotCopyArrayOutput
}

type SnapshotCopyArray []SnapshotCopyInput

func (SnapshotCopyArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*SnapshotCopy)(nil)).Elem()
}

func (i SnapshotCopyArray) ToSnapshotCopyArrayOutput() SnapshotCopyArrayOutput {
	return i.ToSnapshotCopyArrayOutputWithContext(context.Background())
}

func (i SnapshotCopyArray) ToSnapshotCopyArrayOutputWithContext(ctx context.Context) SnapshotCopyArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(SnapshotCopyArrayOutput)
}

// SnapshotCopyMapInput is an input type that accepts SnapshotCopyMap and SnapshotCopyMapOutput values.
// You can construct a concrete instance of `SnapshotCopyMapInput` via:
//
//	SnapshotCopyMap{ "key": SnapshotCopyArgs{...} }
type SnapshotCopyMapInput interface {
	pulumi.Input

	ToSnapshotCopyMapOutput() SnapshotCopyMapOutput
	ToSnapshotCopyMapOutputWithContext(context.Context) SnapshotCopyMapOutput
}

type SnapshotCopyMap map[string]SnapshotCopyInput

func (SnapshotCopyMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*SnapshotCopy)(nil)).Elem()
}

func (i SnapshotCopyMap) ToSnapshotCopyMapOutput() SnapshotCopyMapOutput {
	return i.ToSnapshotCopyMapOutputWithContext(context.Background())
}

func (i SnapshotCopyMap) ToSnapshotCopyMapOutputWithContext(ctx context.Context) SnapshotCopyMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(SnapshotCopyMapOutput)
}

type SnapshotCopyOutput struct{ *pulumi.OutputState }

func (SnapshotCopyOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**SnapshotCopy)(nil)).Elem()
}

func (o SnapshotCopyOutput) ToSnapshotCopyOutput() SnapshotCopyOutput {
	return o
}

func (o SnapshotCopyOutput) ToSnapshotCopyOutputWithContext(ctx context.Context) SnapshotCopyOutput {
	return o
}

// Amazon Resource Name (ARN) of the EBS Snapshot.
func (o SnapshotCopyOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *SnapshotCopy) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Specifies a completion duration to initiate a time-based snapshot copy. Time-based snapshot copy operations complete within the specified duration.  Value must be between 15 and 2880 minutes, in 15 minute increments only.
func (o SnapshotCopyOutput) CompletionDurationMinutes() pulumi.IntPtrOutput {
	return o.ApplyT(func(v *SnapshotCopy) pulumi.IntPtrOutput { return v.CompletionDurationMinutes }).(pulumi.IntPtrOutput)
}

// The data encryption key identifier for the snapshot.
func (o SnapshotCopyOutput) DataEncryptionKeyId() pulumi.StringOutput {
	return o.ApplyT(func(v *SnapshotCopy) pulumi.StringOutput { return v.DataEncryptionKeyId }).(pulumi.StringOutput)
}

// A description of what the snapshot is.
func (o SnapshotCopyOutput) Description() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *SnapshotCopy) pulumi.StringPtrOutput { return v.Description }).(pulumi.StringPtrOutput)
}

// Whether the snapshot is encrypted.
func (o SnapshotCopyOutput) Encrypted() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v *SnapshotCopy) pulumi.BoolPtrOutput { return v.Encrypted }).(pulumi.BoolPtrOutput)
}

// The ARN for the KMS encryption key.
func (o SnapshotCopyOutput) KmsKeyId() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *SnapshotCopy) pulumi.StringPtrOutput { return v.KmsKeyId }).(pulumi.StringPtrOutput)
}

func (o SnapshotCopyOutput) OutpostArn() pulumi.StringOutput {
	return o.ApplyT(func(v *SnapshotCopy) pulumi.StringOutput { return v.OutpostArn }).(pulumi.StringOutput)
}

// Value from an Amazon-maintained list (`amazon`, `aws-marketplace`, `microsoft`) of snapshot owners.
func (o SnapshotCopyOutput) OwnerAlias() pulumi.StringOutput {
	return o.ApplyT(func(v *SnapshotCopy) pulumi.StringOutput { return v.OwnerAlias }).(pulumi.StringOutput)
}

// The AWS account ID of the snapshot owner.
func (o SnapshotCopyOutput) OwnerId() pulumi.StringOutput {
	return o.ApplyT(func(v *SnapshotCopy) pulumi.StringOutput { return v.OwnerId }).(pulumi.StringOutput)
}

// Indicates whether to permanently restore an archived snapshot.
func (o SnapshotCopyOutput) PermanentRestore() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v *SnapshotCopy) pulumi.BoolPtrOutput { return v.PermanentRestore }).(pulumi.BoolPtrOutput)
}

// The region of the source snapshot.
func (o SnapshotCopyOutput) SourceRegion() pulumi.StringOutput {
	return o.ApplyT(func(v *SnapshotCopy) pulumi.StringOutput { return v.SourceRegion }).(pulumi.StringOutput)
}

// The ARN for the snapshot to be copied.
func (o SnapshotCopyOutput) SourceSnapshotId() pulumi.StringOutput {
	return o.ApplyT(func(v *SnapshotCopy) pulumi.StringOutput { return v.SourceSnapshotId }).(pulumi.StringOutput)
}

// The name of the storage tier. Valid values are `archive` and `standard`. Default value is `standard`.
func (o SnapshotCopyOutput) StorageTier() pulumi.StringOutput {
	return o.ApplyT(func(v *SnapshotCopy) pulumi.StringOutput { return v.StorageTier }).(pulumi.StringOutput)
}

// A map of tags for the snapshot.
func (o SnapshotCopyOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *SnapshotCopy) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o SnapshotCopyOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *SnapshotCopy) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

// Specifies the number of days for which to temporarily restore an archived snapshot. Required for temporary restores only. The snapshot will be automatically re-archived after this period.
func (o SnapshotCopyOutput) TemporaryRestoreDays() pulumi.IntPtrOutput {
	return o.ApplyT(func(v *SnapshotCopy) pulumi.IntPtrOutput { return v.TemporaryRestoreDays }).(pulumi.IntPtrOutput)
}

func (o SnapshotCopyOutput) VolumeId() pulumi.StringOutput {
	return o.ApplyT(func(v *SnapshotCopy) pulumi.StringOutput { return v.VolumeId }).(pulumi.StringOutput)
}

// The size of the drive in GiBs.
func (o SnapshotCopyOutput) VolumeSize() pulumi.IntOutput {
	return o.ApplyT(func(v *SnapshotCopy) pulumi.IntOutput { return v.VolumeSize }).(pulumi.IntOutput)
}

type SnapshotCopyArrayOutput struct{ *pulumi.OutputState }

func (SnapshotCopyArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*SnapshotCopy)(nil)).Elem()
}

func (o SnapshotCopyArrayOutput) ToSnapshotCopyArrayOutput() SnapshotCopyArrayOutput {
	return o
}

func (o SnapshotCopyArrayOutput) ToSnapshotCopyArrayOutputWithContext(ctx context.Context) SnapshotCopyArrayOutput {
	return o
}

func (o SnapshotCopyArrayOutput) Index(i pulumi.IntInput) SnapshotCopyOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *SnapshotCopy {
		return vs[0].([]*SnapshotCopy)[vs[1].(int)]
	}).(SnapshotCopyOutput)
}

type SnapshotCopyMapOutput struct{ *pulumi.OutputState }

func (SnapshotCopyMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*SnapshotCopy)(nil)).Elem()
}

func (o SnapshotCopyMapOutput) ToSnapshotCopyMapOutput() SnapshotCopyMapOutput {
	return o
}

func (o SnapshotCopyMapOutput) ToSnapshotCopyMapOutputWithContext(ctx context.Context) SnapshotCopyMapOutput {
	return o
}

func (o SnapshotCopyMapOutput) MapIndex(k pulumi.StringInput) SnapshotCopyOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *SnapshotCopy {
		return vs[0].(map[string]*SnapshotCopy)[vs[1].(string)]
	}).(SnapshotCopyOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*SnapshotCopyInput)(nil)).Elem(), &SnapshotCopy{})
	pulumi.RegisterInputType(reflect.TypeOf((*SnapshotCopyArrayInput)(nil)).Elem(), SnapshotCopyArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*SnapshotCopyMapInput)(nil)).Elem(), SnapshotCopyMap{})
	pulumi.RegisterOutputType(SnapshotCopyOutput{})
	pulumi.RegisterOutputType(SnapshotCopyArrayOutput{})
	pulumi.RegisterOutputType(SnapshotCopyMapOutput{})
}
