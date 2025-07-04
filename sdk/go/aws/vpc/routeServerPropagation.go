// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package vpc

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a resource for managing propagation between VPC (Virtual Private Cloud) route server and a route table.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/vpc"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := vpc.NewRouteServerPropagation(ctx, "example", &vpc.RouteServerPropagationArgs{
//				RouteServerId: pulumi.Any(exampleAwsVpcRouteServer.RouteServerId),
//				RouteTableId:  pulumi.Any(exampleAwsRouteTable.Id),
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
// Using `pulumi import`, to  to import VPC (Virtual Private Cloud) Route Server Propagation using the associated resource ID and route table ID separated by a comma (,). For example:
//
// ```sh
// $ pulumi import aws:vpc/routeServerPropagation:RouteServerPropagation example rs-12345678,rtb-656c65616e6f72
// ```
type RouteServerPropagation struct {
	pulumi.CustomResourceState

	// The unique identifier for the route server to be associated.
	RouteServerId pulumi.StringOutput `pulumi:"routeServerId"`
	// The ID of the route table to which route server will propagate routes.
	RouteTableId pulumi.StringOutput                     `pulumi:"routeTableId"`
	Timeouts     RouteServerPropagationTimeoutsPtrOutput `pulumi:"timeouts"`
}

// NewRouteServerPropagation registers a new resource with the given unique name, arguments, and options.
func NewRouteServerPropagation(ctx *pulumi.Context,
	name string, args *RouteServerPropagationArgs, opts ...pulumi.ResourceOption) (*RouteServerPropagation, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.RouteServerId == nil {
		return nil, errors.New("invalid value for required argument 'RouteServerId'")
	}
	if args.RouteTableId == nil {
		return nil, errors.New("invalid value for required argument 'RouteTableId'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource RouteServerPropagation
	err := ctx.RegisterResource("aws:vpc/routeServerPropagation:RouteServerPropagation", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetRouteServerPropagation gets an existing RouteServerPropagation resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetRouteServerPropagation(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *RouteServerPropagationState, opts ...pulumi.ResourceOption) (*RouteServerPropagation, error) {
	var resource RouteServerPropagation
	err := ctx.ReadResource("aws:vpc/routeServerPropagation:RouteServerPropagation", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering RouteServerPropagation resources.
type routeServerPropagationState struct {
	// The unique identifier for the route server to be associated.
	RouteServerId *string `pulumi:"routeServerId"`
	// The ID of the route table to which route server will propagate routes.
	RouteTableId *string                         `pulumi:"routeTableId"`
	Timeouts     *RouteServerPropagationTimeouts `pulumi:"timeouts"`
}

type RouteServerPropagationState struct {
	// The unique identifier for the route server to be associated.
	RouteServerId pulumi.StringPtrInput
	// The ID of the route table to which route server will propagate routes.
	RouteTableId pulumi.StringPtrInput
	Timeouts     RouteServerPropagationTimeoutsPtrInput
}

func (RouteServerPropagationState) ElementType() reflect.Type {
	return reflect.TypeOf((*routeServerPropagationState)(nil)).Elem()
}

type routeServerPropagationArgs struct {
	// The unique identifier for the route server to be associated.
	RouteServerId string `pulumi:"routeServerId"`
	// The ID of the route table to which route server will propagate routes.
	RouteTableId string                          `pulumi:"routeTableId"`
	Timeouts     *RouteServerPropagationTimeouts `pulumi:"timeouts"`
}

// The set of arguments for constructing a RouteServerPropagation resource.
type RouteServerPropagationArgs struct {
	// The unique identifier for the route server to be associated.
	RouteServerId pulumi.StringInput
	// The ID of the route table to which route server will propagate routes.
	RouteTableId pulumi.StringInput
	Timeouts     RouteServerPropagationTimeoutsPtrInput
}

func (RouteServerPropagationArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*routeServerPropagationArgs)(nil)).Elem()
}

type RouteServerPropagationInput interface {
	pulumi.Input

	ToRouteServerPropagationOutput() RouteServerPropagationOutput
	ToRouteServerPropagationOutputWithContext(ctx context.Context) RouteServerPropagationOutput
}

func (*RouteServerPropagation) ElementType() reflect.Type {
	return reflect.TypeOf((**RouteServerPropagation)(nil)).Elem()
}

func (i *RouteServerPropagation) ToRouteServerPropagationOutput() RouteServerPropagationOutput {
	return i.ToRouteServerPropagationOutputWithContext(context.Background())
}

func (i *RouteServerPropagation) ToRouteServerPropagationOutputWithContext(ctx context.Context) RouteServerPropagationOutput {
	return pulumi.ToOutputWithContext(ctx, i).(RouteServerPropagationOutput)
}

// RouteServerPropagationArrayInput is an input type that accepts RouteServerPropagationArray and RouteServerPropagationArrayOutput values.
// You can construct a concrete instance of `RouteServerPropagationArrayInput` via:
//
//	RouteServerPropagationArray{ RouteServerPropagationArgs{...} }
type RouteServerPropagationArrayInput interface {
	pulumi.Input

	ToRouteServerPropagationArrayOutput() RouteServerPropagationArrayOutput
	ToRouteServerPropagationArrayOutputWithContext(context.Context) RouteServerPropagationArrayOutput
}

type RouteServerPropagationArray []RouteServerPropagationInput

func (RouteServerPropagationArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*RouteServerPropagation)(nil)).Elem()
}

func (i RouteServerPropagationArray) ToRouteServerPropagationArrayOutput() RouteServerPropagationArrayOutput {
	return i.ToRouteServerPropagationArrayOutputWithContext(context.Background())
}

func (i RouteServerPropagationArray) ToRouteServerPropagationArrayOutputWithContext(ctx context.Context) RouteServerPropagationArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(RouteServerPropagationArrayOutput)
}

// RouteServerPropagationMapInput is an input type that accepts RouteServerPropagationMap and RouteServerPropagationMapOutput values.
// You can construct a concrete instance of `RouteServerPropagationMapInput` via:
//
//	RouteServerPropagationMap{ "key": RouteServerPropagationArgs{...} }
type RouteServerPropagationMapInput interface {
	pulumi.Input

	ToRouteServerPropagationMapOutput() RouteServerPropagationMapOutput
	ToRouteServerPropagationMapOutputWithContext(context.Context) RouteServerPropagationMapOutput
}

type RouteServerPropagationMap map[string]RouteServerPropagationInput

func (RouteServerPropagationMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*RouteServerPropagation)(nil)).Elem()
}

func (i RouteServerPropagationMap) ToRouteServerPropagationMapOutput() RouteServerPropagationMapOutput {
	return i.ToRouteServerPropagationMapOutputWithContext(context.Background())
}

func (i RouteServerPropagationMap) ToRouteServerPropagationMapOutputWithContext(ctx context.Context) RouteServerPropagationMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(RouteServerPropagationMapOutput)
}

type RouteServerPropagationOutput struct{ *pulumi.OutputState }

func (RouteServerPropagationOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**RouteServerPropagation)(nil)).Elem()
}

func (o RouteServerPropagationOutput) ToRouteServerPropagationOutput() RouteServerPropagationOutput {
	return o
}

func (o RouteServerPropagationOutput) ToRouteServerPropagationOutputWithContext(ctx context.Context) RouteServerPropagationOutput {
	return o
}

// The unique identifier for the route server to be associated.
func (o RouteServerPropagationOutput) RouteServerId() pulumi.StringOutput {
	return o.ApplyT(func(v *RouteServerPropagation) pulumi.StringOutput { return v.RouteServerId }).(pulumi.StringOutput)
}

// The ID of the route table to which route server will propagate routes.
func (o RouteServerPropagationOutput) RouteTableId() pulumi.StringOutput {
	return o.ApplyT(func(v *RouteServerPropagation) pulumi.StringOutput { return v.RouteTableId }).(pulumi.StringOutput)
}

func (o RouteServerPropagationOutput) Timeouts() RouteServerPropagationTimeoutsPtrOutput {
	return o.ApplyT(func(v *RouteServerPropagation) RouteServerPropagationTimeoutsPtrOutput { return v.Timeouts }).(RouteServerPropagationTimeoutsPtrOutput)
}

type RouteServerPropagationArrayOutput struct{ *pulumi.OutputState }

func (RouteServerPropagationArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*RouteServerPropagation)(nil)).Elem()
}

func (o RouteServerPropagationArrayOutput) ToRouteServerPropagationArrayOutput() RouteServerPropagationArrayOutput {
	return o
}

func (o RouteServerPropagationArrayOutput) ToRouteServerPropagationArrayOutputWithContext(ctx context.Context) RouteServerPropagationArrayOutput {
	return o
}

func (o RouteServerPropagationArrayOutput) Index(i pulumi.IntInput) RouteServerPropagationOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *RouteServerPropagation {
		return vs[0].([]*RouteServerPropagation)[vs[1].(int)]
	}).(RouteServerPropagationOutput)
}

type RouteServerPropagationMapOutput struct{ *pulumi.OutputState }

func (RouteServerPropagationMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*RouteServerPropagation)(nil)).Elem()
}

func (o RouteServerPropagationMapOutput) ToRouteServerPropagationMapOutput() RouteServerPropagationMapOutput {
	return o
}

func (o RouteServerPropagationMapOutput) ToRouteServerPropagationMapOutputWithContext(ctx context.Context) RouteServerPropagationMapOutput {
	return o
}

func (o RouteServerPropagationMapOutput) MapIndex(k pulumi.StringInput) RouteServerPropagationOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *RouteServerPropagation {
		return vs[0].(map[string]*RouteServerPropagation)[vs[1].(string)]
	}).(RouteServerPropagationOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*RouteServerPropagationInput)(nil)).Elem(), &RouteServerPropagation{})
	pulumi.RegisterInputType(reflect.TypeOf((*RouteServerPropagationArrayInput)(nil)).Elem(), RouteServerPropagationArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*RouteServerPropagationMapInput)(nil)).Elem(), RouteServerPropagationMap{})
	pulumi.RegisterOutputType(RouteServerPropagationOutput{})
	pulumi.RegisterOutputType(RouteServerPropagationArrayOutput{})
	pulumi.RegisterOutputType(RouteServerPropagationMapOutput{})
}
