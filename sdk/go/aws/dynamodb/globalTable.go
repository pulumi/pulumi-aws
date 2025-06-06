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

// Manages [DynamoDB Global Tables V1 (version 2017.11.29)](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/globaltables.V1.html). These are layered on top of existing DynamoDB Tables.
//
// > **NOTE:** To instead manage [DynamoDB Global Tables V2 (version 2019.11.21)](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/globaltables.V2.html), use the `dynamodb.Table` resource `replica` configuration block.
//
// > Note: There are many restrictions before you can properly create DynamoDB Global Tables in multiple regions. See the [AWS DynamoDB Global Table Requirements](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/globaltables_reqs_bestpractices.html) for more information.
//
// ## Example Usage
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
//			us_east_1, err := dynamodb.NewTable(ctx, "us-east-1", &dynamodb.TableArgs{
//				HashKey:        pulumi.String("myAttribute"),
//				Name:           pulumi.String("myTable"),
//				StreamEnabled:  pulumi.Bool(true),
//				StreamViewType: pulumi.String("NEW_AND_OLD_IMAGES"),
//				ReadCapacity:   pulumi.Int(1),
//				WriteCapacity:  pulumi.Int(1),
//				Attributes: dynamodb.TableAttributeArray{
//					&dynamodb.TableAttributeArgs{
//						Name: pulumi.String("myAttribute"),
//						Type: pulumi.String("S"),
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			us_west_2, err := dynamodb.NewTable(ctx, "us-west-2", &dynamodb.TableArgs{
//				HashKey:        pulumi.String("myAttribute"),
//				Name:           pulumi.String("myTable"),
//				StreamEnabled:  pulumi.Bool(true),
//				StreamViewType: pulumi.String("NEW_AND_OLD_IMAGES"),
//				ReadCapacity:   pulumi.Int(1),
//				WriteCapacity:  pulumi.Int(1),
//				Attributes: dynamodb.TableAttributeArray{
//					&dynamodb.TableAttributeArgs{
//						Name: pulumi.String("myAttribute"),
//						Type: pulumi.String("S"),
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			_, err = dynamodb.NewGlobalTable(ctx, "myTable", &dynamodb.GlobalTableArgs{
//				Name: pulumi.String("myTable"),
//				Replicas: dynamodb.GlobalTableReplicaArray{
//					&dynamodb.GlobalTableReplicaArgs{
//						RegionName: pulumi.String("us-east-1"),
//					},
//					&dynamodb.GlobalTableReplicaArgs{
//						RegionName: pulumi.String("us-west-2"),
//					},
//				},
//			}, pulumi.DependsOn([]pulumi.Resource{
//				us_east_1,
//				us_west_2,
//			}))
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
// Using `pulumi import`, import DynamoDB Global Tables using the global table name. For example:
//
// ```sh
// $ pulumi import aws:dynamodb/globalTable:GlobalTable MyTable MyTable
// ```
type GlobalTable struct {
	pulumi.CustomResourceState

	// The ARN of the DynamoDB Global Table
	Arn pulumi.StringOutput `pulumi:"arn"`
	// The name of the global table. Must match underlying DynamoDB Table names in all regions.
	Name pulumi.StringOutput `pulumi:"name"`
	// Underlying DynamoDB Table. At least 1 replica must be defined. See below.
	Replicas GlobalTableReplicaArrayOutput `pulumi:"replicas"`
}

// NewGlobalTable registers a new resource with the given unique name, arguments, and options.
func NewGlobalTable(ctx *pulumi.Context,
	name string, args *GlobalTableArgs, opts ...pulumi.ResourceOption) (*GlobalTable, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.Replicas == nil {
		return nil, errors.New("invalid value for required argument 'Replicas'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource GlobalTable
	err := ctx.RegisterResource("aws:dynamodb/globalTable:GlobalTable", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetGlobalTable gets an existing GlobalTable resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetGlobalTable(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *GlobalTableState, opts ...pulumi.ResourceOption) (*GlobalTable, error) {
	var resource GlobalTable
	err := ctx.ReadResource("aws:dynamodb/globalTable:GlobalTable", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering GlobalTable resources.
type globalTableState struct {
	// The ARN of the DynamoDB Global Table
	Arn *string `pulumi:"arn"`
	// The name of the global table. Must match underlying DynamoDB Table names in all regions.
	Name *string `pulumi:"name"`
	// Underlying DynamoDB Table. At least 1 replica must be defined. See below.
	Replicas []GlobalTableReplica `pulumi:"replicas"`
}

type GlobalTableState struct {
	// The ARN of the DynamoDB Global Table
	Arn pulumi.StringPtrInput
	// The name of the global table. Must match underlying DynamoDB Table names in all regions.
	Name pulumi.StringPtrInput
	// Underlying DynamoDB Table. At least 1 replica must be defined. See below.
	Replicas GlobalTableReplicaArrayInput
}

func (GlobalTableState) ElementType() reflect.Type {
	return reflect.TypeOf((*globalTableState)(nil)).Elem()
}

type globalTableArgs struct {
	// The name of the global table. Must match underlying DynamoDB Table names in all regions.
	Name *string `pulumi:"name"`
	// Underlying DynamoDB Table. At least 1 replica must be defined. See below.
	Replicas []GlobalTableReplica `pulumi:"replicas"`
}

// The set of arguments for constructing a GlobalTable resource.
type GlobalTableArgs struct {
	// The name of the global table. Must match underlying DynamoDB Table names in all regions.
	Name pulumi.StringPtrInput
	// Underlying DynamoDB Table. At least 1 replica must be defined. See below.
	Replicas GlobalTableReplicaArrayInput
}

func (GlobalTableArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*globalTableArgs)(nil)).Elem()
}

type GlobalTableInput interface {
	pulumi.Input

	ToGlobalTableOutput() GlobalTableOutput
	ToGlobalTableOutputWithContext(ctx context.Context) GlobalTableOutput
}

func (*GlobalTable) ElementType() reflect.Type {
	return reflect.TypeOf((**GlobalTable)(nil)).Elem()
}

func (i *GlobalTable) ToGlobalTableOutput() GlobalTableOutput {
	return i.ToGlobalTableOutputWithContext(context.Background())
}

func (i *GlobalTable) ToGlobalTableOutputWithContext(ctx context.Context) GlobalTableOutput {
	return pulumi.ToOutputWithContext(ctx, i).(GlobalTableOutput)
}

// GlobalTableArrayInput is an input type that accepts GlobalTableArray and GlobalTableArrayOutput values.
// You can construct a concrete instance of `GlobalTableArrayInput` via:
//
//	GlobalTableArray{ GlobalTableArgs{...} }
type GlobalTableArrayInput interface {
	pulumi.Input

	ToGlobalTableArrayOutput() GlobalTableArrayOutput
	ToGlobalTableArrayOutputWithContext(context.Context) GlobalTableArrayOutput
}

type GlobalTableArray []GlobalTableInput

func (GlobalTableArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*GlobalTable)(nil)).Elem()
}

func (i GlobalTableArray) ToGlobalTableArrayOutput() GlobalTableArrayOutput {
	return i.ToGlobalTableArrayOutputWithContext(context.Background())
}

func (i GlobalTableArray) ToGlobalTableArrayOutputWithContext(ctx context.Context) GlobalTableArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(GlobalTableArrayOutput)
}

// GlobalTableMapInput is an input type that accepts GlobalTableMap and GlobalTableMapOutput values.
// You can construct a concrete instance of `GlobalTableMapInput` via:
//
//	GlobalTableMap{ "key": GlobalTableArgs{...} }
type GlobalTableMapInput interface {
	pulumi.Input

	ToGlobalTableMapOutput() GlobalTableMapOutput
	ToGlobalTableMapOutputWithContext(context.Context) GlobalTableMapOutput
}

type GlobalTableMap map[string]GlobalTableInput

func (GlobalTableMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*GlobalTable)(nil)).Elem()
}

func (i GlobalTableMap) ToGlobalTableMapOutput() GlobalTableMapOutput {
	return i.ToGlobalTableMapOutputWithContext(context.Background())
}

func (i GlobalTableMap) ToGlobalTableMapOutputWithContext(ctx context.Context) GlobalTableMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(GlobalTableMapOutput)
}

type GlobalTableOutput struct{ *pulumi.OutputState }

func (GlobalTableOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**GlobalTable)(nil)).Elem()
}

func (o GlobalTableOutput) ToGlobalTableOutput() GlobalTableOutput {
	return o
}

func (o GlobalTableOutput) ToGlobalTableOutputWithContext(ctx context.Context) GlobalTableOutput {
	return o
}

// The ARN of the DynamoDB Global Table
func (o GlobalTableOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *GlobalTable) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// The name of the global table. Must match underlying DynamoDB Table names in all regions.
func (o GlobalTableOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *GlobalTable) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// Underlying DynamoDB Table. At least 1 replica must be defined. See below.
func (o GlobalTableOutput) Replicas() GlobalTableReplicaArrayOutput {
	return o.ApplyT(func(v *GlobalTable) GlobalTableReplicaArrayOutput { return v.Replicas }).(GlobalTableReplicaArrayOutput)
}

type GlobalTableArrayOutput struct{ *pulumi.OutputState }

func (GlobalTableArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*GlobalTable)(nil)).Elem()
}

func (o GlobalTableArrayOutput) ToGlobalTableArrayOutput() GlobalTableArrayOutput {
	return o
}

func (o GlobalTableArrayOutput) ToGlobalTableArrayOutputWithContext(ctx context.Context) GlobalTableArrayOutput {
	return o
}

func (o GlobalTableArrayOutput) Index(i pulumi.IntInput) GlobalTableOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *GlobalTable {
		return vs[0].([]*GlobalTable)[vs[1].(int)]
	}).(GlobalTableOutput)
}

type GlobalTableMapOutput struct{ *pulumi.OutputState }

func (GlobalTableMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*GlobalTable)(nil)).Elem()
}

func (o GlobalTableMapOutput) ToGlobalTableMapOutput() GlobalTableMapOutput {
	return o
}

func (o GlobalTableMapOutput) ToGlobalTableMapOutputWithContext(ctx context.Context) GlobalTableMapOutput {
	return o
}

func (o GlobalTableMapOutput) MapIndex(k pulumi.StringInput) GlobalTableOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *GlobalTable {
		return vs[0].(map[string]*GlobalTable)[vs[1].(string)]
	}).(GlobalTableOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*GlobalTableInput)(nil)).Elem(), &GlobalTable{})
	pulumi.RegisterInputType(reflect.TypeOf((*GlobalTableArrayInput)(nil)).Elem(), GlobalTableArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*GlobalTableMapInput)(nil)).Elem(), GlobalTableMap{})
	pulumi.RegisterOutputType(GlobalTableOutput{})
	pulumi.RegisterOutputType(GlobalTableArrayOutput{})
	pulumi.RegisterOutputType(GlobalTableMapOutput{})
}
