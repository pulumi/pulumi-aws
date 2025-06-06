// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package directconnect

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a confirmation of the creation of the specified hosted connection on an interconnect.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/directconnect"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := directconnect.NewConnectionConfirmation(ctx, "confirmation", &directconnect.ConnectionConfirmationArgs{
//				ConnectionId: pulumi.String("dxcon-ffabc123"),
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
type ConnectionConfirmation struct {
	pulumi.CustomResourceState

	// The ID of the hosted connection.
	ConnectionId pulumi.StringOutput `pulumi:"connectionId"`
}

// NewConnectionConfirmation registers a new resource with the given unique name, arguments, and options.
func NewConnectionConfirmation(ctx *pulumi.Context,
	name string, args *ConnectionConfirmationArgs, opts ...pulumi.ResourceOption) (*ConnectionConfirmation, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.ConnectionId == nil {
		return nil, errors.New("invalid value for required argument 'ConnectionId'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource ConnectionConfirmation
	err := ctx.RegisterResource("aws:directconnect/connectionConfirmation:ConnectionConfirmation", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetConnectionConfirmation gets an existing ConnectionConfirmation resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetConnectionConfirmation(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ConnectionConfirmationState, opts ...pulumi.ResourceOption) (*ConnectionConfirmation, error) {
	var resource ConnectionConfirmation
	err := ctx.ReadResource("aws:directconnect/connectionConfirmation:ConnectionConfirmation", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering ConnectionConfirmation resources.
type connectionConfirmationState struct {
	// The ID of the hosted connection.
	ConnectionId *string `pulumi:"connectionId"`
}

type ConnectionConfirmationState struct {
	// The ID of the hosted connection.
	ConnectionId pulumi.StringPtrInput
}

func (ConnectionConfirmationState) ElementType() reflect.Type {
	return reflect.TypeOf((*connectionConfirmationState)(nil)).Elem()
}

type connectionConfirmationArgs struct {
	// The ID of the hosted connection.
	ConnectionId string `pulumi:"connectionId"`
}

// The set of arguments for constructing a ConnectionConfirmation resource.
type ConnectionConfirmationArgs struct {
	// The ID of the hosted connection.
	ConnectionId pulumi.StringInput
}

func (ConnectionConfirmationArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*connectionConfirmationArgs)(nil)).Elem()
}

type ConnectionConfirmationInput interface {
	pulumi.Input

	ToConnectionConfirmationOutput() ConnectionConfirmationOutput
	ToConnectionConfirmationOutputWithContext(ctx context.Context) ConnectionConfirmationOutput
}

func (*ConnectionConfirmation) ElementType() reflect.Type {
	return reflect.TypeOf((**ConnectionConfirmation)(nil)).Elem()
}

func (i *ConnectionConfirmation) ToConnectionConfirmationOutput() ConnectionConfirmationOutput {
	return i.ToConnectionConfirmationOutputWithContext(context.Background())
}

func (i *ConnectionConfirmation) ToConnectionConfirmationOutputWithContext(ctx context.Context) ConnectionConfirmationOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ConnectionConfirmationOutput)
}

// ConnectionConfirmationArrayInput is an input type that accepts ConnectionConfirmationArray and ConnectionConfirmationArrayOutput values.
// You can construct a concrete instance of `ConnectionConfirmationArrayInput` via:
//
//	ConnectionConfirmationArray{ ConnectionConfirmationArgs{...} }
type ConnectionConfirmationArrayInput interface {
	pulumi.Input

	ToConnectionConfirmationArrayOutput() ConnectionConfirmationArrayOutput
	ToConnectionConfirmationArrayOutputWithContext(context.Context) ConnectionConfirmationArrayOutput
}

type ConnectionConfirmationArray []ConnectionConfirmationInput

func (ConnectionConfirmationArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ConnectionConfirmation)(nil)).Elem()
}

func (i ConnectionConfirmationArray) ToConnectionConfirmationArrayOutput() ConnectionConfirmationArrayOutput {
	return i.ToConnectionConfirmationArrayOutputWithContext(context.Background())
}

func (i ConnectionConfirmationArray) ToConnectionConfirmationArrayOutputWithContext(ctx context.Context) ConnectionConfirmationArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ConnectionConfirmationArrayOutput)
}

// ConnectionConfirmationMapInput is an input type that accepts ConnectionConfirmationMap and ConnectionConfirmationMapOutput values.
// You can construct a concrete instance of `ConnectionConfirmationMapInput` via:
//
//	ConnectionConfirmationMap{ "key": ConnectionConfirmationArgs{...} }
type ConnectionConfirmationMapInput interface {
	pulumi.Input

	ToConnectionConfirmationMapOutput() ConnectionConfirmationMapOutput
	ToConnectionConfirmationMapOutputWithContext(context.Context) ConnectionConfirmationMapOutput
}

type ConnectionConfirmationMap map[string]ConnectionConfirmationInput

func (ConnectionConfirmationMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ConnectionConfirmation)(nil)).Elem()
}

func (i ConnectionConfirmationMap) ToConnectionConfirmationMapOutput() ConnectionConfirmationMapOutput {
	return i.ToConnectionConfirmationMapOutputWithContext(context.Background())
}

func (i ConnectionConfirmationMap) ToConnectionConfirmationMapOutputWithContext(ctx context.Context) ConnectionConfirmationMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ConnectionConfirmationMapOutput)
}

type ConnectionConfirmationOutput struct{ *pulumi.OutputState }

func (ConnectionConfirmationOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**ConnectionConfirmation)(nil)).Elem()
}

func (o ConnectionConfirmationOutput) ToConnectionConfirmationOutput() ConnectionConfirmationOutput {
	return o
}

func (o ConnectionConfirmationOutput) ToConnectionConfirmationOutputWithContext(ctx context.Context) ConnectionConfirmationOutput {
	return o
}

// The ID of the hosted connection.
func (o ConnectionConfirmationOutput) ConnectionId() pulumi.StringOutput {
	return o.ApplyT(func(v *ConnectionConfirmation) pulumi.StringOutput { return v.ConnectionId }).(pulumi.StringOutput)
}

type ConnectionConfirmationArrayOutput struct{ *pulumi.OutputState }

func (ConnectionConfirmationArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ConnectionConfirmation)(nil)).Elem()
}

func (o ConnectionConfirmationArrayOutput) ToConnectionConfirmationArrayOutput() ConnectionConfirmationArrayOutput {
	return o
}

func (o ConnectionConfirmationArrayOutput) ToConnectionConfirmationArrayOutputWithContext(ctx context.Context) ConnectionConfirmationArrayOutput {
	return o
}

func (o ConnectionConfirmationArrayOutput) Index(i pulumi.IntInput) ConnectionConfirmationOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *ConnectionConfirmation {
		return vs[0].([]*ConnectionConfirmation)[vs[1].(int)]
	}).(ConnectionConfirmationOutput)
}

type ConnectionConfirmationMapOutput struct{ *pulumi.OutputState }

func (ConnectionConfirmationMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ConnectionConfirmation)(nil)).Elem()
}

func (o ConnectionConfirmationMapOutput) ToConnectionConfirmationMapOutput() ConnectionConfirmationMapOutput {
	return o
}

func (o ConnectionConfirmationMapOutput) ToConnectionConfirmationMapOutputWithContext(ctx context.Context) ConnectionConfirmationMapOutput {
	return o
}

func (o ConnectionConfirmationMapOutput) MapIndex(k pulumi.StringInput) ConnectionConfirmationOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *ConnectionConfirmation {
		return vs[0].(map[string]*ConnectionConfirmation)[vs[1].(string)]
	}).(ConnectionConfirmationOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ConnectionConfirmationInput)(nil)).Elem(), &ConnectionConfirmation{})
	pulumi.RegisterInputType(reflect.TypeOf((*ConnectionConfirmationArrayInput)(nil)).Elem(), ConnectionConfirmationArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ConnectionConfirmationMapInput)(nil)).Elem(), ConnectionConfirmationMap{})
	pulumi.RegisterOutputType(ConnectionConfirmationOutput{})
	pulumi.RegisterOutputType(ConnectionConfirmationArrayOutput{})
	pulumi.RegisterOutputType(ConnectionConfirmationMapOutput{})
}
