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

// Creates a snapshot copy grant that allows AWS Redshift to encrypt copied snapshots with a customer master key from AWS KMS in a destination region.
//
// Note that the grant must exist in the destination region, and not in the region of the cluster.
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
//			test, err := redshift.NewSnapshotCopyGrant(ctx, "test", &redshift.SnapshotCopyGrantArgs{
//				SnapshotCopyGrantName: pulumi.String("my-grant"),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = redshift.NewCluster(ctx, "test", &redshift.ClusterArgs{
//				SnapshotCopy: &redshift.ClusterSnapshotCopyArgs{
//					DestinationRegion: pulumi.String("us-east-2"),
//					GrantName:         test.SnapshotCopyGrantName,
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
// Using `pulumi import`, import Redshift Snapshot Copy Grants by name. For example:
//
// ```sh
// $ pulumi import aws:redshift/snapshotCopyGrant:SnapshotCopyGrant test my-grant
// ```
type SnapshotCopyGrant struct {
	pulumi.CustomResourceState

	// Amazon Resource Name (ARN) of snapshot copy grant
	Arn pulumi.StringOutput `pulumi:"arn"`
	// The unique identifier for the customer master key (CMK) that the grant applies to. Specify the key ID or the Amazon Resource Name (ARN) of the CMK. To specify a CMK in a different AWS account, you must use the key ARN. If not specified, the default key is used.
	KmsKeyId pulumi.StringOutput `pulumi:"kmsKeyId"`
	// A friendly name for identifying the grant.
	SnapshotCopyGrantName pulumi.StringOutput `pulumi:"snapshotCopyGrantName"`
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewSnapshotCopyGrant registers a new resource with the given unique name, arguments, and options.
func NewSnapshotCopyGrant(ctx *pulumi.Context,
	name string, args *SnapshotCopyGrantArgs, opts ...pulumi.ResourceOption) (*SnapshotCopyGrant, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.SnapshotCopyGrantName == nil {
		return nil, errors.New("invalid value for required argument 'SnapshotCopyGrantName'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource SnapshotCopyGrant
	err := ctx.RegisterResource("aws:redshift/snapshotCopyGrant:SnapshotCopyGrant", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetSnapshotCopyGrant gets an existing SnapshotCopyGrant resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetSnapshotCopyGrant(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *SnapshotCopyGrantState, opts ...pulumi.ResourceOption) (*SnapshotCopyGrant, error) {
	var resource SnapshotCopyGrant
	err := ctx.ReadResource("aws:redshift/snapshotCopyGrant:SnapshotCopyGrant", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering SnapshotCopyGrant resources.
type snapshotCopyGrantState struct {
	// Amazon Resource Name (ARN) of snapshot copy grant
	Arn *string `pulumi:"arn"`
	// The unique identifier for the customer master key (CMK) that the grant applies to. Specify the key ID or the Amazon Resource Name (ARN) of the CMK. To specify a CMK in a different AWS account, you must use the key ARN. If not specified, the default key is used.
	KmsKeyId *string `pulumi:"kmsKeyId"`
	// A friendly name for identifying the grant.
	SnapshotCopyGrantName *string `pulumi:"snapshotCopyGrantName"`
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type SnapshotCopyGrantState struct {
	// Amazon Resource Name (ARN) of snapshot copy grant
	Arn pulumi.StringPtrInput
	// The unique identifier for the customer master key (CMK) that the grant applies to. Specify the key ID or the Amazon Resource Name (ARN) of the CMK. To specify a CMK in a different AWS account, you must use the key ARN. If not specified, the default key is used.
	KmsKeyId pulumi.StringPtrInput
	// A friendly name for identifying the grant.
	SnapshotCopyGrantName pulumi.StringPtrInput
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (SnapshotCopyGrantState) ElementType() reflect.Type {
	return reflect.TypeOf((*snapshotCopyGrantState)(nil)).Elem()
}

type snapshotCopyGrantArgs struct {
	// The unique identifier for the customer master key (CMK) that the grant applies to. Specify the key ID or the Amazon Resource Name (ARN) of the CMK. To specify a CMK in a different AWS account, you must use the key ARN. If not specified, the default key is used.
	KmsKeyId *string `pulumi:"kmsKeyId"`
	// A friendly name for identifying the grant.
	SnapshotCopyGrantName string `pulumi:"snapshotCopyGrantName"`
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a SnapshotCopyGrant resource.
type SnapshotCopyGrantArgs struct {
	// The unique identifier for the customer master key (CMK) that the grant applies to. Specify the key ID or the Amazon Resource Name (ARN) of the CMK. To specify a CMK in a different AWS account, you must use the key ARN. If not specified, the default key is used.
	KmsKeyId pulumi.StringPtrInput
	// A friendly name for identifying the grant.
	SnapshotCopyGrantName pulumi.StringInput
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (SnapshotCopyGrantArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*snapshotCopyGrantArgs)(nil)).Elem()
}

type SnapshotCopyGrantInput interface {
	pulumi.Input

	ToSnapshotCopyGrantOutput() SnapshotCopyGrantOutput
	ToSnapshotCopyGrantOutputWithContext(ctx context.Context) SnapshotCopyGrantOutput
}

func (*SnapshotCopyGrant) ElementType() reflect.Type {
	return reflect.TypeOf((**SnapshotCopyGrant)(nil)).Elem()
}

func (i *SnapshotCopyGrant) ToSnapshotCopyGrantOutput() SnapshotCopyGrantOutput {
	return i.ToSnapshotCopyGrantOutputWithContext(context.Background())
}

func (i *SnapshotCopyGrant) ToSnapshotCopyGrantOutputWithContext(ctx context.Context) SnapshotCopyGrantOutput {
	return pulumi.ToOutputWithContext(ctx, i).(SnapshotCopyGrantOutput)
}

// SnapshotCopyGrantArrayInput is an input type that accepts SnapshotCopyGrantArray and SnapshotCopyGrantArrayOutput values.
// You can construct a concrete instance of `SnapshotCopyGrantArrayInput` via:
//
//	SnapshotCopyGrantArray{ SnapshotCopyGrantArgs{...} }
type SnapshotCopyGrantArrayInput interface {
	pulumi.Input

	ToSnapshotCopyGrantArrayOutput() SnapshotCopyGrantArrayOutput
	ToSnapshotCopyGrantArrayOutputWithContext(context.Context) SnapshotCopyGrantArrayOutput
}

type SnapshotCopyGrantArray []SnapshotCopyGrantInput

func (SnapshotCopyGrantArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*SnapshotCopyGrant)(nil)).Elem()
}

func (i SnapshotCopyGrantArray) ToSnapshotCopyGrantArrayOutput() SnapshotCopyGrantArrayOutput {
	return i.ToSnapshotCopyGrantArrayOutputWithContext(context.Background())
}

func (i SnapshotCopyGrantArray) ToSnapshotCopyGrantArrayOutputWithContext(ctx context.Context) SnapshotCopyGrantArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(SnapshotCopyGrantArrayOutput)
}

// SnapshotCopyGrantMapInput is an input type that accepts SnapshotCopyGrantMap and SnapshotCopyGrantMapOutput values.
// You can construct a concrete instance of `SnapshotCopyGrantMapInput` via:
//
//	SnapshotCopyGrantMap{ "key": SnapshotCopyGrantArgs{...} }
type SnapshotCopyGrantMapInput interface {
	pulumi.Input

	ToSnapshotCopyGrantMapOutput() SnapshotCopyGrantMapOutput
	ToSnapshotCopyGrantMapOutputWithContext(context.Context) SnapshotCopyGrantMapOutput
}

type SnapshotCopyGrantMap map[string]SnapshotCopyGrantInput

func (SnapshotCopyGrantMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*SnapshotCopyGrant)(nil)).Elem()
}

func (i SnapshotCopyGrantMap) ToSnapshotCopyGrantMapOutput() SnapshotCopyGrantMapOutput {
	return i.ToSnapshotCopyGrantMapOutputWithContext(context.Background())
}

func (i SnapshotCopyGrantMap) ToSnapshotCopyGrantMapOutputWithContext(ctx context.Context) SnapshotCopyGrantMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(SnapshotCopyGrantMapOutput)
}

type SnapshotCopyGrantOutput struct{ *pulumi.OutputState }

func (SnapshotCopyGrantOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**SnapshotCopyGrant)(nil)).Elem()
}

func (o SnapshotCopyGrantOutput) ToSnapshotCopyGrantOutput() SnapshotCopyGrantOutput {
	return o
}

func (o SnapshotCopyGrantOutput) ToSnapshotCopyGrantOutputWithContext(ctx context.Context) SnapshotCopyGrantOutput {
	return o
}

// Amazon Resource Name (ARN) of snapshot copy grant
func (o SnapshotCopyGrantOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *SnapshotCopyGrant) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// The unique identifier for the customer master key (CMK) that the grant applies to. Specify the key ID or the Amazon Resource Name (ARN) of the CMK. To specify a CMK in a different AWS account, you must use the key ARN. If not specified, the default key is used.
func (o SnapshotCopyGrantOutput) KmsKeyId() pulumi.StringOutput {
	return o.ApplyT(func(v *SnapshotCopyGrant) pulumi.StringOutput { return v.KmsKeyId }).(pulumi.StringOutput)
}

// A friendly name for identifying the grant.
func (o SnapshotCopyGrantOutput) SnapshotCopyGrantName() pulumi.StringOutput {
	return o.ApplyT(func(v *SnapshotCopyGrant) pulumi.StringOutput { return v.SnapshotCopyGrantName }).(pulumi.StringOutput)
}

// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o SnapshotCopyGrantOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *SnapshotCopyGrant) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o SnapshotCopyGrantOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *SnapshotCopyGrant) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type SnapshotCopyGrantArrayOutput struct{ *pulumi.OutputState }

func (SnapshotCopyGrantArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*SnapshotCopyGrant)(nil)).Elem()
}

func (o SnapshotCopyGrantArrayOutput) ToSnapshotCopyGrantArrayOutput() SnapshotCopyGrantArrayOutput {
	return o
}

func (o SnapshotCopyGrantArrayOutput) ToSnapshotCopyGrantArrayOutputWithContext(ctx context.Context) SnapshotCopyGrantArrayOutput {
	return o
}

func (o SnapshotCopyGrantArrayOutput) Index(i pulumi.IntInput) SnapshotCopyGrantOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *SnapshotCopyGrant {
		return vs[0].([]*SnapshotCopyGrant)[vs[1].(int)]
	}).(SnapshotCopyGrantOutput)
}

type SnapshotCopyGrantMapOutput struct{ *pulumi.OutputState }

func (SnapshotCopyGrantMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*SnapshotCopyGrant)(nil)).Elem()
}

func (o SnapshotCopyGrantMapOutput) ToSnapshotCopyGrantMapOutput() SnapshotCopyGrantMapOutput {
	return o
}

func (o SnapshotCopyGrantMapOutput) ToSnapshotCopyGrantMapOutputWithContext(ctx context.Context) SnapshotCopyGrantMapOutput {
	return o
}

func (o SnapshotCopyGrantMapOutput) MapIndex(k pulumi.StringInput) SnapshotCopyGrantOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *SnapshotCopyGrant {
		return vs[0].(map[string]*SnapshotCopyGrant)[vs[1].(string)]
	}).(SnapshotCopyGrantOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*SnapshotCopyGrantInput)(nil)).Elem(), &SnapshotCopyGrant{})
	pulumi.RegisterInputType(reflect.TypeOf((*SnapshotCopyGrantArrayInput)(nil)).Elem(), SnapshotCopyGrantArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*SnapshotCopyGrantMapInput)(nil)).Elem(), SnapshotCopyGrantMap{})
	pulumi.RegisterOutputType(SnapshotCopyGrantOutput{})
	pulumi.RegisterOutputType(SnapshotCopyGrantArrayOutput{})
	pulumi.RegisterOutputType(SnapshotCopyGrantMapOutput{})
}
