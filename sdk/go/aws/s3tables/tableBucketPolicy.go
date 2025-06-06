// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package s3tables

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an Amazon S3 Tables Table Bucket Policy.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/iam"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/s3tables"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			example, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
//				Statements: []iam.GetPolicyDocumentStatement{
//					{},
//				},
//			}, nil)
//			if err != nil {
//				return err
//			}
//			_, err = s3tables.NewTableBucketPolicy(ctx, "example", &s3tables.TableBucketPolicyArgs{
//				ResourcePolicy: pulumi.String(example.Json),
//				TableBucketArn: pulumi.Any(exampleAwsS3tablesTableBucket.Arn),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = s3tables.NewTableBucket(ctx, "test", &s3tables.TableBucketArgs{
//				Name: pulumi.String("example-bucket"),
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
// Using `pulumi import`, import S3 Tables Table Bucket Policy using the `table_bucket_arn`. For example:
//
// ```sh
// $ pulumi import aws:s3tables/tableBucketPolicy:TableBucketPolicy example 'arn:aws:s3tables:us-west-2:123456789012:bucket/example-bucket;example-namespace'
// ```
type TableBucketPolicy struct {
	pulumi.CustomResourceState

	// Amazon Web Services resource-based policy document in JSON format.
	ResourcePolicy pulumi.StringOutput `pulumi:"resourcePolicy"`
	// ARN referencing the Table Bucket that owns this policy.
	TableBucketArn pulumi.StringOutput `pulumi:"tableBucketArn"`
}

// NewTableBucketPolicy registers a new resource with the given unique name, arguments, and options.
func NewTableBucketPolicy(ctx *pulumi.Context,
	name string, args *TableBucketPolicyArgs, opts ...pulumi.ResourceOption) (*TableBucketPolicy, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.ResourcePolicy == nil {
		return nil, errors.New("invalid value for required argument 'ResourcePolicy'")
	}
	if args.TableBucketArn == nil {
		return nil, errors.New("invalid value for required argument 'TableBucketArn'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource TableBucketPolicy
	err := ctx.RegisterResource("aws:s3tables/tableBucketPolicy:TableBucketPolicy", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetTableBucketPolicy gets an existing TableBucketPolicy resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetTableBucketPolicy(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *TableBucketPolicyState, opts ...pulumi.ResourceOption) (*TableBucketPolicy, error) {
	var resource TableBucketPolicy
	err := ctx.ReadResource("aws:s3tables/tableBucketPolicy:TableBucketPolicy", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering TableBucketPolicy resources.
type tableBucketPolicyState struct {
	// Amazon Web Services resource-based policy document in JSON format.
	ResourcePolicy *string `pulumi:"resourcePolicy"`
	// ARN referencing the Table Bucket that owns this policy.
	TableBucketArn *string `pulumi:"tableBucketArn"`
}

type TableBucketPolicyState struct {
	// Amazon Web Services resource-based policy document in JSON format.
	ResourcePolicy pulumi.StringPtrInput
	// ARN referencing the Table Bucket that owns this policy.
	TableBucketArn pulumi.StringPtrInput
}

func (TableBucketPolicyState) ElementType() reflect.Type {
	return reflect.TypeOf((*tableBucketPolicyState)(nil)).Elem()
}

type tableBucketPolicyArgs struct {
	// Amazon Web Services resource-based policy document in JSON format.
	ResourcePolicy string `pulumi:"resourcePolicy"`
	// ARN referencing the Table Bucket that owns this policy.
	TableBucketArn string `pulumi:"tableBucketArn"`
}

// The set of arguments for constructing a TableBucketPolicy resource.
type TableBucketPolicyArgs struct {
	// Amazon Web Services resource-based policy document in JSON format.
	ResourcePolicy pulumi.StringInput
	// ARN referencing the Table Bucket that owns this policy.
	TableBucketArn pulumi.StringInput
}

func (TableBucketPolicyArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*tableBucketPolicyArgs)(nil)).Elem()
}

type TableBucketPolicyInput interface {
	pulumi.Input

	ToTableBucketPolicyOutput() TableBucketPolicyOutput
	ToTableBucketPolicyOutputWithContext(ctx context.Context) TableBucketPolicyOutput
}

func (*TableBucketPolicy) ElementType() reflect.Type {
	return reflect.TypeOf((**TableBucketPolicy)(nil)).Elem()
}

func (i *TableBucketPolicy) ToTableBucketPolicyOutput() TableBucketPolicyOutput {
	return i.ToTableBucketPolicyOutputWithContext(context.Background())
}

func (i *TableBucketPolicy) ToTableBucketPolicyOutputWithContext(ctx context.Context) TableBucketPolicyOutput {
	return pulumi.ToOutputWithContext(ctx, i).(TableBucketPolicyOutput)
}

// TableBucketPolicyArrayInput is an input type that accepts TableBucketPolicyArray and TableBucketPolicyArrayOutput values.
// You can construct a concrete instance of `TableBucketPolicyArrayInput` via:
//
//	TableBucketPolicyArray{ TableBucketPolicyArgs{...} }
type TableBucketPolicyArrayInput interface {
	pulumi.Input

	ToTableBucketPolicyArrayOutput() TableBucketPolicyArrayOutput
	ToTableBucketPolicyArrayOutputWithContext(context.Context) TableBucketPolicyArrayOutput
}

type TableBucketPolicyArray []TableBucketPolicyInput

func (TableBucketPolicyArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*TableBucketPolicy)(nil)).Elem()
}

func (i TableBucketPolicyArray) ToTableBucketPolicyArrayOutput() TableBucketPolicyArrayOutput {
	return i.ToTableBucketPolicyArrayOutputWithContext(context.Background())
}

func (i TableBucketPolicyArray) ToTableBucketPolicyArrayOutputWithContext(ctx context.Context) TableBucketPolicyArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(TableBucketPolicyArrayOutput)
}

// TableBucketPolicyMapInput is an input type that accepts TableBucketPolicyMap and TableBucketPolicyMapOutput values.
// You can construct a concrete instance of `TableBucketPolicyMapInput` via:
//
//	TableBucketPolicyMap{ "key": TableBucketPolicyArgs{...} }
type TableBucketPolicyMapInput interface {
	pulumi.Input

	ToTableBucketPolicyMapOutput() TableBucketPolicyMapOutput
	ToTableBucketPolicyMapOutputWithContext(context.Context) TableBucketPolicyMapOutput
}

type TableBucketPolicyMap map[string]TableBucketPolicyInput

func (TableBucketPolicyMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*TableBucketPolicy)(nil)).Elem()
}

func (i TableBucketPolicyMap) ToTableBucketPolicyMapOutput() TableBucketPolicyMapOutput {
	return i.ToTableBucketPolicyMapOutputWithContext(context.Background())
}

func (i TableBucketPolicyMap) ToTableBucketPolicyMapOutputWithContext(ctx context.Context) TableBucketPolicyMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(TableBucketPolicyMapOutput)
}

type TableBucketPolicyOutput struct{ *pulumi.OutputState }

func (TableBucketPolicyOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**TableBucketPolicy)(nil)).Elem()
}

func (o TableBucketPolicyOutput) ToTableBucketPolicyOutput() TableBucketPolicyOutput {
	return o
}

func (o TableBucketPolicyOutput) ToTableBucketPolicyOutputWithContext(ctx context.Context) TableBucketPolicyOutput {
	return o
}

// Amazon Web Services resource-based policy document in JSON format.
func (o TableBucketPolicyOutput) ResourcePolicy() pulumi.StringOutput {
	return o.ApplyT(func(v *TableBucketPolicy) pulumi.StringOutput { return v.ResourcePolicy }).(pulumi.StringOutput)
}

// ARN referencing the Table Bucket that owns this policy.
func (o TableBucketPolicyOutput) TableBucketArn() pulumi.StringOutput {
	return o.ApplyT(func(v *TableBucketPolicy) pulumi.StringOutput { return v.TableBucketArn }).(pulumi.StringOutput)
}

type TableBucketPolicyArrayOutput struct{ *pulumi.OutputState }

func (TableBucketPolicyArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*TableBucketPolicy)(nil)).Elem()
}

func (o TableBucketPolicyArrayOutput) ToTableBucketPolicyArrayOutput() TableBucketPolicyArrayOutput {
	return o
}

func (o TableBucketPolicyArrayOutput) ToTableBucketPolicyArrayOutputWithContext(ctx context.Context) TableBucketPolicyArrayOutput {
	return o
}

func (o TableBucketPolicyArrayOutput) Index(i pulumi.IntInput) TableBucketPolicyOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *TableBucketPolicy {
		return vs[0].([]*TableBucketPolicy)[vs[1].(int)]
	}).(TableBucketPolicyOutput)
}

type TableBucketPolicyMapOutput struct{ *pulumi.OutputState }

func (TableBucketPolicyMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*TableBucketPolicy)(nil)).Elem()
}

func (o TableBucketPolicyMapOutput) ToTableBucketPolicyMapOutput() TableBucketPolicyMapOutput {
	return o
}

func (o TableBucketPolicyMapOutput) ToTableBucketPolicyMapOutputWithContext(ctx context.Context) TableBucketPolicyMapOutput {
	return o
}

func (o TableBucketPolicyMapOutput) MapIndex(k pulumi.StringInput) TableBucketPolicyOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *TableBucketPolicy {
		return vs[0].(map[string]*TableBucketPolicy)[vs[1].(string)]
	}).(TableBucketPolicyOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*TableBucketPolicyInput)(nil)).Elem(), &TableBucketPolicy{})
	pulumi.RegisterInputType(reflect.TypeOf((*TableBucketPolicyArrayInput)(nil)).Elem(), TableBucketPolicyArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*TableBucketPolicyMapInput)(nil)).Elem(), TableBucketPolicyMap{})
	pulumi.RegisterOutputType(TableBucketPolicyOutput{})
	pulumi.RegisterOutputType(TableBucketPolicyArrayOutput{})
	pulumi.RegisterOutputType(TableBucketPolicyMapOutput{})
}
