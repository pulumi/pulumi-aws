// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package lakeformation

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Manages an attachment between one or more existing LF-tags and an existing Lake Formation resource.
//
// ## Example Usage
//
// ### Database Example
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/lakeformation"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			example, err := lakeformation.NewLfTag(ctx, "example", &lakeformation.LfTagArgs{
//				Key: pulumi.String("right"),
//				Values: pulumi.StringArray{
//					pulumi.String("abbey"),
//					pulumi.String("village"),
//					pulumi.String("luffield"),
//					pulumi.String("woodcote"),
//					pulumi.String("copse"),
//					pulumi.String("chapel"),
//					pulumi.String("stowe"),
//					pulumi.String("club"),
//				},
//			})
//			if err != nil {
//				return err
//			}
//			_, err = lakeformation.NewResourceLfTags(ctx, "example", &lakeformation.ResourceLfTagsArgs{
//				Database: &lakeformation.ResourceLfTagsDatabaseArgs{
//					Name: pulumi.Any(exampleAwsGlueCatalogDatabase.Name),
//				},
//				LfTags: lakeformation.ResourceLfTagsLfTagArray{
//					&lakeformation.ResourceLfTagsLfTagArgs{
//						Key:   example.Key,
//						Value: pulumi.String("stowe"),
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
// ### Multiple Tags Example
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/lakeformation"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := lakeformation.NewLfTag(ctx, "example", &lakeformation.LfTagArgs{
//				Key: pulumi.String("right"),
//				Values: pulumi.StringArray{
//					pulumi.String("abbey"),
//					pulumi.String("village"),
//					pulumi.String("luffield"),
//					pulumi.String("woodcote"),
//					pulumi.String("copse"),
//					pulumi.String("chapel"),
//					pulumi.String("stowe"),
//					pulumi.String("club"),
//				},
//			})
//			if err != nil {
//				return err
//			}
//			_, err = lakeformation.NewLfTag(ctx, "example2", &lakeformation.LfTagArgs{
//				Key: pulumi.String("left"),
//				Values: pulumi.StringArray{
//					pulumi.String("farm"),
//					pulumi.String("theloop"),
//					pulumi.String("aintree"),
//					pulumi.String("brooklands"),
//					pulumi.String("maggotts"),
//					pulumi.String("becketts"),
//					pulumi.String("vale"),
//				},
//			})
//			if err != nil {
//				return err
//			}
//			_, err = lakeformation.NewResourceLfTags(ctx, "example", &lakeformation.ResourceLfTagsArgs{
//				Database: &lakeformation.ResourceLfTagsDatabaseArgs{
//					Name: pulumi.Any(exampleAwsGlueCatalogDatabase.Name),
//				},
//				LfTags: lakeformation.ResourceLfTagsLfTagArray{
//					&lakeformation.ResourceLfTagsLfTagArgs{
//						Key:   pulumi.String("right"),
//						Value: pulumi.String("luffield"),
//					},
//					&lakeformation.ResourceLfTagsLfTagArgs{
//						Key:   pulumi.String("left"),
//						Value: pulumi.String("aintree"),
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
type ResourceLfTags struct {
	pulumi.CustomResourceState

	// Identifier for the Data Catalog. By default, the account ID. The Data Catalog is the persistent metadata store. It contains database definitions, table definitions, and other control information to manage your Lake Formation environment.
	CatalogId pulumi.StringOutput `pulumi:"catalogId"`
	// Configuration block for a database resource. See below.
	Database ResourceLfTagsDatabaseOutput `pulumi:"database"`
	// Set of LF-tags to attach to the resource. See below.
	//
	// Exactly one of the following is required:
	LfTags ResourceLfTagsLfTagArrayOutput `pulumi:"lfTags"`
	// Configuration block for a table resource. See below.
	Table ResourceLfTagsTableOutput `pulumi:"table"`
	// Configuration block for a table with columns resource. See below.
	//
	// The following arguments are optional:
	TableWithColumns ResourceLfTagsTableWithColumnsOutput `pulumi:"tableWithColumns"`
}

// NewResourceLfTags registers a new resource with the given unique name, arguments, and options.
func NewResourceLfTags(ctx *pulumi.Context,
	name string, args *ResourceLfTagsArgs, opts ...pulumi.ResourceOption) (*ResourceLfTags, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.LfTags == nil {
		return nil, errors.New("invalid value for required argument 'LfTags'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource ResourceLfTags
	err := ctx.RegisterResource("aws:lakeformation/resourceLfTags:ResourceLfTags", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetResourceLfTags gets an existing ResourceLfTags resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetResourceLfTags(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ResourceLfTagsState, opts ...pulumi.ResourceOption) (*ResourceLfTags, error) {
	var resource ResourceLfTags
	err := ctx.ReadResource("aws:lakeformation/resourceLfTags:ResourceLfTags", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering ResourceLfTags resources.
type resourceLfTagsState struct {
	// Identifier for the Data Catalog. By default, the account ID. The Data Catalog is the persistent metadata store. It contains database definitions, table definitions, and other control information to manage your Lake Formation environment.
	CatalogId *string `pulumi:"catalogId"`
	// Configuration block for a database resource. See below.
	Database *ResourceLfTagsDatabase `pulumi:"database"`
	// Set of LF-tags to attach to the resource. See below.
	//
	// Exactly one of the following is required:
	LfTags []ResourceLfTagsLfTag `pulumi:"lfTags"`
	// Configuration block for a table resource. See below.
	Table *ResourceLfTagsTable `pulumi:"table"`
	// Configuration block for a table with columns resource. See below.
	//
	// The following arguments are optional:
	TableWithColumns *ResourceLfTagsTableWithColumns `pulumi:"tableWithColumns"`
}

type ResourceLfTagsState struct {
	// Identifier for the Data Catalog. By default, the account ID. The Data Catalog is the persistent metadata store. It contains database definitions, table definitions, and other control information to manage your Lake Formation environment.
	CatalogId pulumi.StringPtrInput
	// Configuration block for a database resource. See below.
	Database ResourceLfTagsDatabasePtrInput
	// Set of LF-tags to attach to the resource. See below.
	//
	// Exactly one of the following is required:
	LfTags ResourceLfTagsLfTagArrayInput
	// Configuration block for a table resource. See below.
	Table ResourceLfTagsTablePtrInput
	// Configuration block for a table with columns resource. See below.
	//
	// The following arguments are optional:
	TableWithColumns ResourceLfTagsTableWithColumnsPtrInput
}

func (ResourceLfTagsState) ElementType() reflect.Type {
	return reflect.TypeOf((*resourceLfTagsState)(nil)).Elem()
}

type resourceLfTagsArgs struct {
	// Identifier for the Data Catalog. By default, the account ID. The Data Catalog is the persistent metadata store. It contains database definitions, table definitions, and other control information to manage your Lake Formation environment.
	CatalogId *string `pulumi:"catalogId"`
	// Configuration block for a database resource. See below.
	Database *ResourceLfTagsDatabase `pulumi:"database"`
	// Set of LF-tags to attach to the resource. See below.
	//
	// Exactly one of the following is required:
	LfTags []ResourceLfTagsLfTag `pulumi:"lfTags"`
	// Configuration block for a table resource. See below.
	Table *ResourceLfTagsTable `pulumi:"table"`
	// Configuration block for a table with columns resource. See below.
	//
	// The following arguments are optional:
	TableWithColumns *ResourceLfTagsTableWithColumns `pulumi:"tableWithColumns"`
}

// The set of arguments for constructing a ResourceLfTags resource.
type ResourceLfTagsArgs struct {
	// Identifier for the Data Catalog. By default, the account ID. The Data Catalog is the persistent metadata store. It contains database definitions, table definitions, and other control information to manage your Lake Formation environment.
	CatalogId pulumi.StringPtrInput
	// Configuration block for a database resource. See below.
	Database ResourceLfTagsDatabasePtrInput
	// Set of LF-tags to attach to the resource. See below.
	//
	// Exactly one of the following is required:
	LfTags ResourceLfTagsLfTagArrayInput
	// Configuration block for a table resource. See below.
	Table ResourceLfTagsTablePtrInput
	// Configuration block for a table with columns resource. See below.
	//
	// The following arguments are optional:
	TableWithColumns ResourceLfTagsTableWithColumnsPtrInput
}

func (ResourceLfTagsArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*resourceLfTagsArgs)(nil)).Elem()
}

type ResourceLfTagsInput interface {
	pulumi.Input

	ToResourceLfTagsOutput() ResourceLfTagsOutput
	ToResourceLfTagsOutputWithContext(ctx context.Context) ResourceLfTagsOutput
}

func (*ResourceLfTags) ElementType() reflect.Type {
	return reflect.TypeOf((**ResourceLfTags)(nil)).Elem()
}

func (i *ResourceLfTags) ToResourceLfTagsOutput() ResourceLfTagsOutput {
	return i.ToResourceLfTagsOutputWithContext(context.Background())
}

func (i *ResourceLfTags) ToResourceLfTagsOutputWithContext(ctx context.Context) ResourceLfTagsOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ResourceLfTagsOutput)
}

// ResourceLfTagsArrayInput is an input type that accepts ResourceLfTagsArray and ResourceLfTagsArrayOutput values.
// You can construct a concrete instance of `ResourceLfTagsArrayInput` via:
//
//	ResourceLfTagsArray{ ResourceLfTagsArgs{...} }
type ResourceLfTagsArrayInput interface {
	pulumi.Input

	ToResourceLfTagsArrayOutput() ResourceLfTagsArrayOutput
	ToResourceLfTagsArrayOutputWithContext(context.Context) ResourceLfTagsArrayOutput
}

type ResourceLfTagsArray []ResourceLfTagsInput

func (ResourceLfTagsArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ResourceLfTags)(nil)).Elem()
}

func (i ResourceLfTagsArray) ToResourceLfTagsArrayOutput() ResourceLfTagsArrayOutput {
	return i.ToResourceLfTagsArrayOutputWithContext(context.Background())
}

func (i ResourceLfTagsArray) ToResourceLfTagsArrayOutputWithContext(ctx context.Context) ResourceLfTagsArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ResourceLfTagsArrayOutput)
}

// ResourceLfTagsMapInput is an input type that accepts ResourceLfTagsMap and ResourceLfTagsMapOutput values.
// You can construct a concrete instance of `ResourceLfTagsMapInput` via:
//
//	ResourceLfTagsMap{ "key": ResourceLfTagsArgs{...} }
type ResourceLfTagsMapInput interface {
	pulumi.Input

	ToResourceLfTagsMapOutput() ResourceLfTagsMapOutput
	ToResourceLfTagsMapOutputWithContext(context.Context) ResourceLfTagsMapOutput
}

type ResourceLfTagsMap map[string]ResourceLfTagsInput

func (ResourceLfTagsMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ResourceLfTags)(nil)).Elem()
}

func (i ResourceLfTagsMap) ToResourceLfTagsMapOutput() ResourceLfTagsMapOutput {
	return i.ToResourceLfTagsMapOutputWithContext(context.Background())
}

func (i ResourceLfTagsMap) ToResourceLfTagsMapOutputWithContext(ctx context.Context) ResourceLfTagsMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ResourceLfTagsMapOutput)
}

type ResourceLfTagsOutput struct{ *pulumi.OutputState }

func (ResourceLfTagsOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**ResourceLfTags)(nil)).Elem()
}

func (o ResourceLfTagsOutput) ToResourceLfTagsOutput() ResourceLfTagsOutput {
	return o
}

func (o ResourceLfTagsOutput) ToResourceLfTagsOutputWithContext(ctx context.Context) ResourceLfTagsOutput {
	return o
}

// Identifier for the Data Catalog. By default, the account ID. The Data Catalog is the persistent metadata store. It contains database definitions, table definitions, and other control information to manage your Lake Formation environment.
func (o ResourceLfTagsOutput) CatalogId() pulumi.StringOutput {
	return o.ApplyT(func(v *ResourceLfTags) pulumi.StringOutput { return v.CatalogId }).(pulumi.StringOutput)
}

// Configuration block for a database resource. See below.
func (o ResourceLfTagsOutput) Database() ResourceLfTagsDatabaseOutput {
	return o.ApplyT(func(v *ResourceLfTags) ResourceLfTagsDatabaseOutput { return v.Database }).(ResourceLfTagsDatabaseOutput)
}

// Set of LF-tags to attach to the resource. See below.
//
// Exactly one of the following is required:
func (o ResourceLfTagsOutput) LfTags() ResourceLfTagsLfTagArrayOutput {
	return o.ApplyT(func(v *ResourceLfTags) ResourceLfTagsLfTagArrayOutput { return v.LfTags }).(ResourceLfTagsLfTagArrayOutput)
}

// Configuration block for a table resource. See below.
func (o ResourceLfTagsOutput) Table() ResourceLfTagsTableOutput {
	return o.ApplyT(func(v *ResourceLfTags) ResourceLfTagsTableOutput { return v.Table }).(ResourceLfTagsTableOutput)
}

// Configuration block for a table with columns resource. See below.
//
// The following arguments are optional:
func (o ResourceLfTagsOutput) TableWithColumns() ResourceLfTagsTableWithColumnsOutput {
	return o.ApplyT(func(v *ResourceLfTags) ResourceLfTagsTableWithColumnsOutput { return v.TableWithColumns }).(ResourceLfTagsTableWithColumnsOutput)
}

type ResourceLfTagsArrayOutput struct{ *pulumi.OutputState }

func (ResourceLfTagsArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ResourceLfTags)(nil)).Elem()
}

func (o ResourceLfTagsArrayOutput) ToResourceLfTagsArrayOutput() ResourceLfTagsArrayOutput {
	return o
}

func (o ResourceLfTagsArrayOutput) ToResourceLfTagsArrayOutputWithContext(ctx context.Context) ResourceLfTagsArrayOutput {
	return o
}

func (o ResourceLfTagsArrayOutput) Index(i pulumi.IntInput) ResourceLfTagsOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *ResourceLfTags {
		return vs[0].([]*ResourceLfTags)[vs[1].(int)]
	}).(ResourceLfTagsOutput)
}

type ResourceLfTagsMapOutput struct{ *pulumi.OutputState }

func (ResourceLfTagsMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ResourceLfTags)(nil)).Elem()
}

func (o ResourceLfTagsMapOutput) ToResourceLfTagsMapOutput() ResourceLfTagsMapOutput {
	return o
}

func (o ResourceLfTagsMapOutput) ToResourceLfTagsMapOutputWithContext(ctx context.Context) ResourceLfTagsMapOutput {
	return o
}

func (o ResourceLfTagsMapOutput) MapIndex(k pulumi.StringInput) ResourceLfTagsOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *ResourceLfTags {
		return vs[0].(map[string]*ResourceLfTags)[vs[1].(string)]
	}).(ResourceLfTagsOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ResourceLfTagsInput)(nil)).Elem(), &ResourceLfTags{})
	pulumi.RegisterInputType(reflect.TypeOf((*ResourceLfTagsArrayInput)(nil)).Elem(), ResourceLfTagsArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ResourceLfTagsMapInput)(nil)).Elem(), ResourceLfTagsMap{})
	pulumi.RegisterOutputType(ResourceLfTagsOutput{})
	pulumi.RegisterOutputType(ResourceLfTagsArrayOutput{})
	pulumi.RegisterOutputType(ResourceLfTagsMapOutput{})
}
