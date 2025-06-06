// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package route53

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a Route53 CIDR location resource.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/route53"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			example, err := route53.NewCidrCollection(ctx, "example", &route53.CidrCollectionArgs{
//				Name: pulumi.String("collection-1"),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = route53.NewCidrLocation(ctx, "example", &route53.CidrLocationArgs{
//				CidrCollectionId: example.ID(),
//				Name:             pulumi.String("office"),
//				CidrBlocks: pulumi.StringArray{
//					pulumi.String("200.5.3.0/24"),
//					pulumi.String("200.6.3.0/24"),
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
// Using `pulumi import`, import CIDR locations using their the CIDR collection ID and location name. For example:
//
// ```sh
// $ pulumi import aws:route53/cidrLocation:CidrLocation example 9ac32814-3e67-0932-6048-8d779cc6f511,office
// ```
type CidrLocation struct {
	pulumi.CustomResourceState

	// CIDR blocks for the location.
	CidrBlocks pulumi.StringArrayOutput `pulumi:"cidrBlocks"`
	// The ID of the CIDR collection to update.
	CidrCollectionId pulumi.StringOutput `pulumi:"cidrCollectionId"`
	// Name for the CIDR location.
	Name pulumi.StringOutput `pulumi:"name"`
}

// NewCidrLocation registers a new resource with the given unique name, arguments, and options.
func NewCidrLocation(ctx *pulumi.Context,
	name string, args *CidrLocationArgs, opts ...pulumi.ResourceOption) (*CidrLocation, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.CidrBlocks == nil {
		return nil, errors.New("invalid value for required argument 'CidrBlocks'")
	}
	if args.CidrCollectionId == nil {
		return nil, errors.New("invalid value for required argument 'CidrCollectionId'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource CidrLocation
	err := ctx.RegisterResource("aws:route53/cidrLocation:CidrLocation", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetCidrLocation gets an existing CidrLocation resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetCidrLocation(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *CidrLocationState, opts ...pulumi.ResourceOption) (*CidrLocation, error) {
	var resource CidrLocation
	err := ctx.ReadResource("aws:route53/cidrLocation:CidrLocation", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering CidrLocation resources.
type cidrLocationState struct {
	// CIDR blocks for the location.
	CidrBlocks []string `pulumi:"cidrBlocks"`
	// The ID of the CIDR collection to update.
	CidrCollectionId *string `pulumi:"cidrCollectionId"`
	// Name for the CIDR location.
	Name *string `pulumi:"name"`
}

type CidrLocationState struct {
	// CIDR blocks for the location.
	CidrBlocks pulumi.StringArrayInput
	// The ID of the CIDR collection to update.
	CidrCollectionId pulumi.StringPtrInput
	// Name for the CIDR location.
	Name pulumi.StringPtrInput
}

func (CidrLocationState) ElementType() reflect.Type {
	return reflect.TypeOf((*cidrLocationState)(nil)).Elem()
}

type cidrLocationArgs struct {
	// CIDR blocks for the location.
	CidrBlocks []string `pulumi:"cidrBlocks"`
	// The ID of the CIDR collection to update.
	CidrCollectionId string `pulumi:"cidrCollectionId"`
	// Name for the CIDR location.
	Name *string `pulumi:"name"`
}

// The set of arguments for constructing a CidrLocation resource.
type CidrLocationArgs struct {
	// CIDR blocks for the location.
	CidrBlocks pulumi.StringArrayInput
	// The ID of the CIDR collection to update.
	CidrCollectionId pulumi.StringInput
	// Name for the CIDR location.
	Name pulumi.StringPtrInput
}

func (CidrLocationArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*cidrLocationArgs)(nil)).Elem()
}

type CidrLocationInput interface {
	pulumi.Input

	ToCidrLocationOutput() CidrLocationOutput
	ToCidrLocationOutputWithContext(ctx context.Context) CidrLocationOutput
}

func (*CidrLocation) ElementType() reflect.Type {
	return reflect.TypeOf((**CidrLocation)(nil)).Elem()
}

func (i *CidrLocation) ToCidrLocationOutput() CidrLocationOutput {
	return i.ToCidrLocationOutputWithContext(context.Background())
}

func (i *CidrLocation) ToCidrLocationOutputWithContext(ctx context.Context) CidrLocationOutput {
	return pulumi.ToOutputWithContext(ctx, i).(CidrLocationOutput)
}

// CidrLocationArrayInput is an input type that accepts CidrLocationArray and CidrLocationArrayOutput values.
// You can construct a concrete instance of `CidrLocationArrayInput` via:
//
//	CidrLocationArray{ CidrLocationArgs{...} }
type CidrLocationArrayInput interface {
	pulumi.Input

	ToCidrLocationArrayOutput() CidrLocationArrayOutput
	ToCidrLocationArrayOutputWithContext(context.Context) CidrLocationArrayOutput
}

type CidrLocationArray []CidrLocationInput

func (CidrLocationArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*CidrLocation)(nil)).Elem()
}

func (i CidrLocationArray) ToCidrLocationArrayOutput() CidrLocationArrayOutput {
	return i.ToCidrLocationArrayOutputWithContext(context.Background())
}

func (i CidrLocationArray) ToCidrLocationArrayOutputWithContext(ctx context.Context) CidrLocationArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(CidrLocationArrayOutput)
}

// CidrLocationMapInput is an input type that accepts CidrLocationMap and CidrLocationMapOutput values.
// You can construct a concrete instance of `CidrLocationMapInput` via:
//
//	CidrLocationMap{ "key": CidrLocationArgs{...} }
type CidrLocationMapInput interface {
	pulumi.Input

	ToCidrLocationMapOutput() CidrLocationMapOutput
	ToCidrLocationMapOutputWithContext(context.Context) CidrLocationMapOutput
}

type CidrLocationMap map[string]CidrLocationInput

func (CidrLocationMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*CidrLocation)(nil)).Elem()
}

func (i CidrLocationMap) ToCidrLocationMapOutput() CidrLocationMapOutput {
	return i.ToCidrLocationMapOutputWithContext(context.Background())
}

func (i CidrLocationMap) ToCidrLocationMapOutputWithContext(ctx context.Context) CidrLocationMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(CidrLocationMapOutput)
}

type CidrLocationOutput struct{ *pulumi.OutputState }

func (CidrLocationOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**CidrLocation)(nil)).Elem()
}

func (o CidrLocationOutput) ToCidrLocationOutput() CidrLocationOutput {
	return o
}

func (o CidrLocationOutput) ToCidrLocationOutputWithContext(ctx context.Context) CidrLocationOutput {
	return o
}

// CIDR blocks for the location.
func (o CidrLocationOutput) CidrBlocks() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *CidrLocation) pulumi.StringArrayOutput { return v.CidrBlocks }).(pulumi.StringArrayOutput)
}

// The ID of the CIDR collection to update.
func (o CidrLocationOutput) CidrCollectionId() pulumi.StringOutput {
	return o.ApplyT(func(v *CidrLocation) pulumi.StringOutput { return v.CidrCollectionId }).(pulumi.StringOutput)
}

// Name for the CIDR location.
func (o CidrLocationOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *CidrLocation) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

type CidrLocationArrayOutput struct{ *pulumi.OutputState }

func (CidrLocationArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*CidrLocation)(nil)).Elem()
}

func (o CidrLocationArrayOutput) ToCidrLocationArrayOutput() CidrLocationArrayOutput {
	return o
}

func (o CidrLocationArrayOutput) ToCidrLocationArrayOutputWithContext(ctx context.Context) CidrLocationArrayOutput {
	return o
}

func (o CidrLocationArrayOutput) Index(i pulumi.IntInput) CidrLocationOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *CidrLocation {
		return vs[0].([]*CidrLocation)[vs[1].(int)]
	}).(CidrLocationOutput)
}

type CidrLocationMapOutput struct{ *pulumi.OutputState }

func (CidrLocationMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*CidrLocation)(nil)).Elem()
}

func (o CidrLocationMapOutput) ToCidrLocationMapOutput() CidrLocationMapOutput {
	return o
}

func (o CidrLocationMapOutput) ToCidrLocationMapOutputWithContext(ctx context.Context) CidrLocationMapOutput {
	return o
}

func (o CidrLocationMapOutput) MapIndex(k pulumi.StringInput) CidrLocationOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *CidrLocation {
		return vs[0].(map[string]*CidrLocation)[vs[1].(string)]
	}).(CidrLocationOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*CidrLocationInput)(nil)).Elem(), &CidrLocation{})
	pulumi.RegisterInputType(reflect.TypeOf((*CidrLocationArrayInput)(nil)).Elem(), CidrLocationArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*CidrLocationMapInput)(nil)).Elem(), CidrLocationMap{})
	pulumi.RegisterOutputType(CidrLocationOutput{})
	pulumi.RegisterOutputType(CidrLocationArrayOutput{})
	pulumi.RegisterOutputType(CidrLocationMapOutput{})
}
