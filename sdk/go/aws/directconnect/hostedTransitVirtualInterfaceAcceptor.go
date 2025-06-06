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

// Provides a resource to manage the accepter's side of a Direct Connect hosted transit virtual interface.
// This resource accepts ownership of a transit virtual interface created by another AWS account.
//
// > **NOTE:** AWS allows a Direct Connect hosted transit virtual interface to be deleted from either the allocator's or accepter's side. However, this provider only allows the Direct Connect hosted transit virtual interface to be deleted from the allocator's side by removing the corresponding `directconnect.HostedTransitVirtualInterface` resource from your configuration. Removing a `directconnect.HostedTransitVirtualInterfaceAcceptor` resource from your configuration will remove it from your statefile and management, **but will not delete the Direct Connect virtual interface.**
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/directconnect"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			accepter, err := aws.GetCallerIdentity(ctx, &aws.GetCallerIdentityArgs{}, nil)
//			if err != nil {
//				return err
//			}
//			// Accepter's side of the VIF.
//			example, err := directconnect.NewGateway(ctx, "example", &directconnect.GatewayArgs{
//				Name:          pulumi.String("tf-dxg-example"),
//				AmazonSideAsn: pulumi.String("64512"),
//			})
//			if err != nil {
//				return err
//			}
//			// Creator's side of the VIF
//			creator, err := directconnect.NewHostedTransitVirtualInterface(ctx, "creator", &directconnect.HostedTransitVirtualInterfaceArgs{
//				ConnectionId:   pulumi.String("dxcon-zzzzzzzz"),
//				OwnerAccountId: pulumi.String(accepter.AccountId),
//				Name:           pulumi.String("tf-transit-vif-example"),
//				Vlan:           pulumi.Int(4094),
//				AddressFamily:  pulumi.String("ipv4"),
//				BgpAsn:         pulumi.Int(65352),
//			}, pulumi.DependsOn([]pulumi.Resource{
//				example,
//			}))
//			if err != nil {
//				return err
//			}
//			_, err = directconnect.NewHostedTransitVirtualInterfaceAcceptor(ctx, "accepter", &directconnect.HostedTransitVirtualInterfaceAcceptorArgs{
//				VirtualInterfaceId: creator.ID(),
//				DxGatewayId:        example.ID(),
//				Tags: pulumi.StringMap{
//					"Side": pulumi.String("Accepter"),
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
// Using `pulumi import`, import Direct Connect hosted transit virtual interfaces using the VIF `id`. For example:
//
// ```sh
// $ pulumi import aws:directconnect/hostedTransitVirtualInterfaceAcceptor:HostedTransitVirtualInterfaceAcceptor test dxvif-33cc44dd
// ```
type HostedTransitVirtualInterfaceAcceptor struct {
	pulumi.CustomResourceState

	// The ARN of the virtual interface.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// The ID of the Direct Connect gateway to which to connect the virtual interface.
	DxGatewayId pulumi.StringOutput `pulumi:"dxGatewayId"`
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	// The ID of the Direct Connect virtual interface to accept.
	VirtualInterfaceId pulumi.StringOutput `pulumi:"virtualInterfaceId"`
}

// NewHostedTransitVirtualInterfaceAcceptor registers a new resource with the given unique name, arguments, and options.
func NewHostedTransitVirtualInterfaceAcceptor(ctx *pulumi.Context,
	name string, args *HostedTransitVirtualInterfaceAcceptorArgs, opts ...pulumi.ResourceOption) (*HostedTransitVirtualInterfaceAcceptor, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.DxGatewayId == nil {
		return nil, errors.New("invalid value for required argument 'DxGatewayId'")
	}
	if args.VirtualInterfaceId == nil {
		return nil, errors.New("invalid value for required argument 'VirtualInterfaceId'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource HostedTransitVirtualInterfaceAcceptor
	err := ctx.RegisterResource("aws:directconnect/hostedTransitVirtualInterfaceAcceptor:HostedTransitVirtualInterfaceAcceptor", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetHostedTransitVirtualInterfaceAcceptor gets an existing HostedTransitVirtualInterfaceAcceptor resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetHostedTransitVirtualInterfaceAcceptor(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *HostedTransitVirtualInterfaceAcceptorState, opts ...pulumi.ResourceOption) (*HostedTransitVirtualInterfaceAcceptor, error) {
	var resource HostedTransitVirtualInterfaceAcceptor
	err := ctx.ReadResource("aws:directconnect/hostedTransitVirtualInterfaceAcceptor:HostedTransitVirtualInterfaceAcceptor", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering HostedTransitVirtualInterfaceAcceptor resources.
type hostedTransitVirtualInterfaceAcceptorState struct {
	// The ARN of the virtual interface.
	Arn *string `pulumi:"arn"`
	// The ID of the Direct Connect gateway to which to connect the virtual interface.
	DxGatewayId *string `pulumi:"dxGatewayId"`
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	// The ID of the Direct Connect virtual interface to accept.
	VirtualInterfaceId *string `pulumi:"virtualInterfaceId"`
}

type HostedTransitVirtualInterfaceAcceptorState struct {
	// The ARN of the virtual interface.
	Arn pulumi.StringPtrInput
	// The ID of the Direct Connect gateway to which to connect the virtual interface.
	DxGatewayId pulumi.StringPtrInput
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	// The ID of the Direct Connect virtual interface to accept.
	VirtualInterfaceId pulumi.StringPtrInput
}

func (HostedTransitVirtualInterfaceAcceptorState) ElementType() reflect.Type {
	return reflect.TypeOf((*hostedTransitVirtualInterfaceAcceptorState)(nil)).Elem()
}

type hostedTransitVirtualInterfaceAcceptorArgs struct {
	// The ID of the Direct Connect gateway to which to connect the virtual interface.
	DxGatewayId string `pulumi:"dxGatewayId"`
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// The ID of the Direct Connect virtual interface to accept.
	VirtualInterfaceId string `pulumi:"virtualInterfaceId"`
}

// The set of arguments for constructing a HostedTransitVirtualInterfaceAcceptor resource.
type HostedTransitVirtualInterfaceAcceptorArgs struct {
	// The ID of the Direct Connect gateway to which to connect the virtual interface.
	DxGatewayId pulumi.StringInput
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// The ID of the Direct Connect virtual interface to accept.
	VirtualInterfaceId pulumi.StringInput
}

func (HostedTransitVirtualInterfaceAcceptorArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*hostedTransitVirtualInterfaceAcceptorArgs)(nil)).Elem()
}

type HostedTransitVirtualInterfaceAcceptorInput interface {
	pulumi.Input

	ToHostedTransitVirtualInterfaceAcceptorOutput() HostedTransitVirtualInterfaceAcceptorOutput
	ToHostedTransitVirtualInterfaceAcceptorOutputWithContext(ctx context.Context) HostedTransitVirtualInterfaceAcceptorOutput
}

func (*HostedTransitVirtualInterfaceAcceptor) ElementType() reflect.Type {
	return reflect.TypeOf((**HostedTransitVirtualInterfaceAcceptor)(nil)).Elem()
}

func (i *HostedTransitVirtualInterfaceAcceptor) ToHostedTransitVirtualInterfaceAcceptorOutput() HostedTransitVirtualInterfaceAcceptorOutput {
	return i.ToHostedTransitVirtualInterfaceAcceptorOutputWithContext(context.Background())
}

func (i *HostedTransitVirtualInterfaceAcceptor) ToHostedTransitVirtualInterfaceAcceptorOutputWithContext(ctx context.Context) HostedTransitVirtualInterfaceAcceptorOutput {
	return pulumi.ToOutputWithContext(ctx, i).(HostedTransitVirtualInterfaceAcceptorOutput)
}

// HostedTransitVirtualInterfaceAcceptorArrayInput is an input type that accepts HostedTransitVirtualInterfaceAcceptorArray and HostedTransitVirtualInterfaceAcceptorArrayOutput values.
// You can construct a concrete instance of `HostedTransitVirtualInterfaceAcceptorArrayInput` via:
//
//	HostedTransitVirtualInterfaceAcceptorArray{ HostedTransitVirtualInterfaceAcceptorArgs{...} }
type HostedTransitVirtualInterfaceAcceptorArrayInput interface {
	pulumi.Input

	ToHostedTransitVirtualInterfaceAcceptorArrayOutput() HostedTransitVirtualInterfaceAcceptorArrayOutput
	ToHostedTransitVirtualInterfaceAcceptorArrayOutputWithContext(context.Context) HostedTransitVirtualInterfaceAcceptorArrayOutput
}

type HostedTransitVirtualInterfaceAcceptorArray []HostedTransitVirtualInterfaceAcceptorInput

func (HostedTransitVirtualInterfaceAcceptorArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*HostedTransitVirtualInterfaceAcceptor)(nil)).Elem()
}

func (i HostedTransitVirtualInterfaceAcceptorArray) ToHostedTransitVirtualInterfaceAcceptorArrayOutput() HostedTransitVirtualInterfaceAcceptorArrayOutput {
	return i.ToHostedTransitVirtualInterfaceAcceptorArrayOutputWithContext(context.Background())
}

func (i HostedTransitVirtualInterfaceAcceptorArray) ToHostedTransitVirtualInterfaceAcceptorArrayOutputWithContext(ctx context.Context) HostedTransitVirtualInterfaceAcceptorArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(HostedTransitVirtualInterfaceAcceptorArrayOutput)
}

// HostedTransitVirtualInterfaceAcceptorMapInput is an input type that accepts HostedTransitVirtualInterfaceAcceptorMap and HostedTransitVirtualInterfaceAcceptorMapOutput values.
// You can construct a concrete instance of `HostedTransitVirtualInterfaceAcceptorMapInput` via:
//
//	HostedTransitVirtualInterfaceAcceptorMap{ "key": HostedTransitVirtualInterfaceAcceptorArgs{...} }
type HostedTransitVirtualInterfaceAcceptorMapInput interface {
	pulumi.Input

	ToHostedTransitVirtualInterfaceAcceptorMapOutput() HostedTransitVirtualInterfaceAcceptorMapOutput
	ToHostedTransitVirtualInterfaceAcceptorMapOutputWithContext(context.Context) HostedTransitVirtualInterfaceAcceptorMapOutput
}

type HostedTransitVirtualInterfaceAcceptorMap map[string]HostedTransitVirtualInterfaceAcceptorInput

func (HostedTransitVirtualInterfaceAcceptorMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*HostedTransitVirtualInterfaceAcceptor)(nil)).Elem()
}

func (i HostedTransitVirtualInterfaceAcceptorMap) ToHostedTransitVirtualInterfaceAcceptorMapOutput() HostedTransitVirtualInterfaceAcceptorMapOutput {
	return i.ToHostedTransitVirtualInterfaceAcceptorMapOutputWithContext(context.Background())
}

func (i HostedTransitVirtualInterfaceAcceptorMap) ToHostedTransitVirtualInterfaceAcceptorMapOutputWithContext(ctx context.Context) HostedTransitVirtualInterfaceAcceptorMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(HostedTransitVirtualInterfaceAcceptorMapOutput)
}

type HostedTransitVirtualInterfaceAcceptorOutput struct{ *pulumi.OutputState }

func (HostedTransitVirtualInterfaceAcceptorOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**HostedTransitVirtualInterfaceAcceptor)(nil)).Elem()
}

func (o HostedTransitVirtualInterfaceAcceptorOutput) ToHostedTransitVirtualInterfaceAcceptorOutput() HostedTransitVirtualInterfaceAcceptorOutput {
	return o
}

func (o HostedTransitVirtualInterfaceAcceptorOutput) ToHostedTransitVirtualInterfaceAcceptorOutputWithContext(ctx context.Context) HostedTransitVirtualInterfaceAcceptorOutput {
	return o
}

// The ARN of the virtual interface.
func (o HostedTransitVirtualInterfaceAcceptorOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *HostedTransitVirtualInterfaceAcceptor) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// The ID of the Direct Connect gateway to which to connect the virtual interface.
func (o HostedTransitVirtualInterfaceAcceptorOutput) DxGatewayId() pulumi.StringOutput {
	return o.ApplyT(func(v *HostedTransitVirtualInterfaceAcceptor) pulumi.StringOutput { return v.DxGatewayId }).(pulumi.StringOutput)
}

// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o HostedTransitVirtualInterfaceAcceptorOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *HostedTransitVirtualInterfaceAcceptor) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o HostedTransitVirtualInterfaceAcceptorOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *HostedTransitVirtualInterfaceAcceptor) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

// The ID of the Direct Connect virtual interface to accept.
func (o HostedTransitVirtualInterfaceAcceptorOutput) VirtualInterfaceId() pulumi.StringOutput {
	return o.ApplyT(func(v *HostedTransitVirtualInterfaceAcceptor) pulumi.StringOutput { return v.VirtualInterfaceId }).(pulumi.StringOutput)
}

type HostedTransitVirtualInterfaceAcceptorArrayOutput struct{ *pulumi.OutputState }

func (HostedTransitVirtualInterfaceAcceptorArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*HostedTransitVirtualInterfaceAcceptor)(nil)).Elem()
}

func (o HostedTransitVirtualInterfaceAcceptorArrayOutput) ToHostedTransitVirtualInterfaceAcceptorArrayOutput() HostedTransitVirtualInterfaceAcceptorArrayOutput {
	return o
}

func (o HostedTransitVirtualInterfaceAcceptorArrayOutput) ToHostedTransitVirtualInterfaceAcceptorArrayOutputWithContext(ctx context.Context) HostedTransitVirtualInterfaceAcceptorArrayOutput {
	return o
}

func (o HostedTransitVirtualInterfaceAcceptorArrayOutput) Index(i pulumi.IntInput) HostedTransitVirtualInterfaceAcceptorOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *HostedTransitVirtualInterfaceAcceptor {
		return vs[0].([]*HostedTransitVirtualInterfaceAcceptor)[vs[1].(int)]
	}).(HostedTransitVirtualInterfaceAcceptorOutput)
}

type HostedTransitVirtualInterfaceAcceptorMapOutput struct{ *pulumi.OutputState }

func (HostedTransitVirtualInterfaceAcceptorMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*HostedTransitVirtualInterfaceAcceptor)(nil)).Elem()
}

func (o HostedTransitVirtualInterfaceAcceptorMapOutput) ToHostedTransitVirtualInterfaceAcceptorMapOutput() HostedTransitVirtualInterfaceAcceptorMapOutput {
	return o
}

func (o HostedTransitVirtualInterfaceAcceptorMapOutput) ToHostedTransitVirtualInterfaceAcceptorMapOutputWithContext(ctx context.Context) HostedTransitVirtualInterfaceAcceptorMapOutput {
	return o
}

func (o HostedTransitVirtualInterfaceAcceptorMapOutput) MapIndex(k pulumi.StringInput) HostedTransitVirtualInterfaceAcceptorOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *HostedTransitVirtualInterfaceAcceptor {
		return vs[0].(map[string]*HostedTransitVirtualInterfaceAcceptor)[vs[1].(string)]
	}).(HostedTransitVirtualInterfaceAcceptorOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*HostedTransitVirtualInterfaceAcceptorInput)(nil)).Elem(), &HostedTransitVirtualInterfaceAcceptor{})
	pulumi.RegisterInputType(reflect.TypeOf((*HostedTransitVirtualInterfaceAcceptorArrayInput)(nil)).Elem(), HostedTransitVirtualInterfaceAcceptorArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*HostedTransitVirtualInterfaceAcceptorMapInput)(nil)).Elem(), HostedTransitVirtualInterfaceAcceptorMap{})
	pulumi.RegisterOutputType(HostedTransitVirtualInterfaceAcceptorOutput{})
	pulumi.RegisterOutputType(HostedTransitVirtualInterfaceAcceptorArrayOutput{})
	pulumi.RegisterOutputType(HostedTransitVirtualInterfaceAcceptorMapOutput{})
}
