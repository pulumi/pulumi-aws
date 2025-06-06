// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package timestreamwrite

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a Timestream database resource.
//
// ## Example Usage
//
// ### Basic usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/timestreamwrite"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := timestreamwrite.NewDatabase(ctx, "example", &timestreamwrite.DatabaseArgs{
//				DatabaseName: pulumi.String("database-example"),
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
// ### Full usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/timestreamwrite"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := timestreamwrite.NewDatabase(ctx, "example", &timestreamwrite.DatabaseArgs{
//				DatabaseName: pulumi.String("database-example"),
//				KmsKeyId:     pulumi.Any(exampleAwsKmsKey.Arn),
//				Tags: pulumi.StringMap{
//					"Name": pulumi.String("value"),
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
// Using `pulumi import`, import Timestream databases using the `database_name`. For example:
//
// ```sh
// $ pulumi import aws:timestreamwrite/database:Database example example
// ```
type Database struct {
	pulumi.CustomResourceState

	// The ARN that uniquely identifies this database.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// The name of the Timestream database. Minimum length of 3. Maximum length of 64.
	DatabaseName pulumi.StringOutput `pulumi:"databaseName"`
	// The ARN (not Alias ARN) of the KMS key to be used to encrypt the data stored in the database. If the KMS key is not specified, the database will be encrypted with a Timestream managed KMS key located in your account. Refer to [AWS managed KMS keys](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk) for more info.
	KmsKeyId pulumi.StringOutput `pulumi:"kmsKeyId"`
	// The total number of tables found within the Timestream database.
	TableCount pulumi.IntOutput `pulumi:"tableCount"`
	// Map of tags to assign to this resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewDatabase registers a new resource with the given unique name, arguments, and options.
func NewDatabase(ctx *pulumi.Context,
	name string, args *DatabaseArgs, opts ...pulumi.ResourceOption) (*Database, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.DatabaseName == nil {
		return nil, errors.New("invalid value for required argument 'DatabaseName'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource Database
	err := ctx.RegisterResource("aws:timestreamwrite/database:Database", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetDatabase gets an existing Database resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetDatabase(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *DatabaseState, opts ...pulumi.ResourceOption) (*Database, error) {
	var resource Database
	err := ctx.ReadResource("aws:timestreamwrite/database:Database", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Database resources.
type databaseState struct {
	// The ARN that uniquely identifies this database.
	Arn *string `pulumi:"arn"`
	// The name of the Timestream database. Minimum length of 3. Maximum length of 64.
	DatabaseName *string `pulumi:"databaseName"`
	// The ARN (not Alias ARN) of the KMS key to be used to encrypt the data stored in the database. If the KMS key is not specified, the database will be encrypted with a Timestream managed KMS key located in your account. Refer to [AWS managed KMS keys](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk) for more info.
	KmsKeyId *string `pulumi:"kmsKeyId"`
	// The total number of tables found within the Timestream database.
	TableCount *int `pulumi:"tableCount"`
	// Map of tags to assign to this resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type DatabaseState struct {
	// The ARN that uniquely identifies this database.
	Arn pulumi.StringPtrInput
	// The name of the Timestream database. Minimum length of 3. Maximum length of 64.
	DatabaseName pulumi.StringPtrInput
	// The ARN (not Alias ARN) of the KMS key to be used to encrypt the data stored in the database. If the KMS key is not specified, the database will be encrypted with a Timestream managed KMS key located in your account. Refer to [AWS managed KMS keys](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk) for more info.
	KmsKeyId pulumi.StringPtrInput
	// The total number of tables found within the Timestream database.
	TableCount pulumi.IntPtrInput
	// Map of tags to assign to this resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (DatabaseState) ElementType() reflect.Type {
	return reflect.TypeOf((*databaseState)(nil)).Elem()
}

type databaseArgs struct {
	// The name of the Timestream database. Minimum length of 3. Maximum length of 64.
	DatabaseName string `pulumi:"databaseName"`
	// The ARN (not Alias ARN) of the KMS key to be used to encrypt the data stored in the database. If the KMS key is not specified, the database will be encrypted with a Timestream managed KMS key located in your account. Refer to [AWS managed KMS keys](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk) for more info.
	KmsKeyId *string `pulumi:"kmsKeyId"`
	// Map of tags to assign to this resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a Database resource.
type DatabaseArgs struct {
	// The name of the Timestream database. Minimum length of 3. Maximum length of 64.
	DatabaseName pulumi.StringInput
	// The ARN (not Alias ARN) of the KMS key to be used to encrypt the data stored in the database. If the KMS key is not specified, the database will be encrypted with a Timestream managed KMS key located in your account. Refer to [AWS managed KMS keys](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk) for more info.
	KmsKeyId pulumi.StringPtrInput
	// Map of tags to assign to this resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (DatabaseArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*databaseArgs)(nil)).Elem()
}

type DatabaseInput interface {
	pulumi.Input

	ToDatabaseOutput() DatabaseOutput
	ToDatabaseOutputWithContext(ctx context.Context) DatabaseOutput
}

func (*Database) ElementType() reflect.Type {
	return reflect.TypeOf((**Database)(nil)).Elem()
}

func (i *Database) ToDatabaseOutput() DatabaseOutput {
	return i.ToDatabaseOutputWithContext(context.Background())
}

func (i *Database) ToDatabaseOutputWithContext(ctx context.Context) DatabaseOutput {
	return pulumi.ToOutputWithContext(ctx, i).(DatabaseOutput)
}

// DatabaseArrayInput is an input type that accepts DatabaseArray and DatabaseArrayOutput values.
// You can construct a concrete instance of `DatabaseArrayInput` via:
//
//	DatabaseArray{ DatabaseArgs{...} }
type DatabaseArrayInput interface {
	pulumi.Input

	ToDatabaseArrayOutput() DatabaseArrayOutput
	ToDatabaseArrayOutputWithContext(context.Context) DatabaseArrayOutput
}

type DatabaseArray []DatabaseInput

func (DatabaseArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Database)(nil)).Elem()
}

func (i DatabaseArray) ToDatabaseArrayOutput() DatabaseArrayOutput {
	return i.ToDatabaseArrayOutputWithContext(context.Background())
}

func (i DatabaseArray) ToDatabaseArrayOutputWithContext(ctx context.Context) DatabaseArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(DatabaseArrayOutput)
}

// DatabaseMapInput is an input type that accepts DatabaseMap and DatabaseMapOutput values.
// You can construct a concrete instance of `DatabaseMapInput` via:
//
//	DatabaseMap{ "key": DatabaseArgs{...} }
type DatabaseMapInput interface {
	pulumi.Input

	ToDatabaseMapOutput() DatabaseMapOutput
	ToDatabaseMapOutputWithContext(context.Context) DatabaseMapOutput
}

type DatabaseMap map[string]DatabaseInput

func (DatabaseMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Database)(nil)).Elem()
}

func (i DatabaseMap) ToDatabaseMapOutput() DatabaseMapOutput {
	return i.ToDatabaseMapOutputWithContext(context.Background())
}

func (i DatabaseMap) ToDatabaseMapOutputWithContext(ctx context.Context) DatabaseMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(DatabaseMapOutput)
}

type DatabaseOutput struct{ *pulumi.OutputState }

func (DatabaseOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**Database)(nil)).Elem()
}

func (o DatabaseOutput) ToDatabaseOutput() DatabaseOutput {
	return o
}

func (o DatabaseOutput) ToDatabaseOutputWithContext(ctx context.Context) DatabaseOutput {
	return o
}

// The ARN that uniquely identifies this database.
func (o DatabaseOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *Database) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// The name of the Timestream database. Minimum length of 3. Maximum length of 64.
func (o DatabaseOutput) DatabaseName() pulumi.StringOutput {
	return o.ApplyT(func(v *Database) pulumi.StringOutput { return v.DatabaseName }).(pulumi.StringOutput)
}

// The ARN (not Alias ARN) of the KMS key to be used to encrypt the data stored in the database. If the KMS key is not specified, the database will be encrypted with a Timestream managed KMS key located in your account. Refer to [AWS managed KMS keys](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk) for more info.
func (o DatabaseOutput) KmsKeyId() pulumi.StringOutput {
	return o.ApplyT(func(v *Database) pulumi.StringOutput { return v.KmsKeyId }).(pulumi.StringOutput)
}

// The total number of tables found within the Timestream database.
func (o DatabaseOutput) TableCount() pulumi.IntOutput {
	return o.ApplyT(func(v *Database) pulumi.IntOutput { return v.TableCount }).(pulumi.IntOutput)
}

// Map of tags to assign to this resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o DatabaseOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Database) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o DatabaseOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Database) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type DatabaseArrayOutput struct{ *pulumi.OutputState }

func (DatabaseArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Database)(nil)).Elem()
}

func (o DatabaseArrayOutput) ToDatabaseArrayOutput() DatabaseArrayOutput {
	return o
}

func (o DatabaseArrayOutput) ToDatabaseArrayOutputWithContext(ctx context.Context) DatabaseArrayOutput {
	return o
}

func (o DatabaseArrayOutput) Index(i pulumi.IntInput) DatabaseOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *Database {
		return vs[0].([]*Database)[vs[1].(int)]
	}).(DatabaseOutput)
}

type DatabaseMapOutput struct{ *pulumi.OutputState }

func (DatabaseMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Database)(nil)).Elem()
}

func (o DatabaseMapOutput) ToDatabaseMapOutput() DatabaseMapOutput {
	return o
}

func (o DatabaseMapOutput) ToDatabaseMapOutputWithContext(ctx context.Context) DatabaseMapOutput {
	return o
}

func (o DatabaseMapOutput) MapIndex(k pulumi.StringInput) DatabaseOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *Database {
		return vs[0].(map[string]*Database)[vs[1].(string)]
	}).(DatabaseOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*DatabaseInput)(nil)).Elem(), &Database{})
	pulumi.RegisterInputType(reflect.TypeOf((*DatabaseArrayInput)(nil)).Elem(), DatabaseArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*DatabaseMapInput)(nil)).Elem(), DatabaseMap{})
	pulumi.RegisterOutputType(DatabaseOutput{})
	pulumi.RegisterOutputType(DatabaseArrayOutput{})
	pulumi.RegisterOutputType(DatabaseMapOutput{})
}
