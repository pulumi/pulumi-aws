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

// Provides a Direct Connect transit virtual interface resource.
// A transit virtual interface is a VLAN that transports traffic from a Direct Connect gateway to one or more transit gateways.
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
//			example, err := directconnect.NewGateway(ctx, "example", &directconnect.GatewayArgs{
//				Name:          pulumi.String("tf-dxg-example"),
//				AmazonSideAsn: pulumi.String("64512"),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = directconnect.NewTransitVirtualInterface(ctx, "example", &directconnect.TransitVirtualInterfaceArgs{
//				ConnectionId:  pulumi.Any(exampleAwsDxConnection.Id),
//				DxGatewayId:   example.ID(),
//				Name:          pulumi.String("tf-transit-vif-example"),
//				Vlan:          pulumi.Int(4094),
//				AddressFamily: pulumi.String("ipv4"),
//				BgpAsn:        pulumi.Int(65352),
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
// Using `pulumi import`, import Direct Connect transit virtual interfaces using the VIF `id`. For example:
//
// ```sh
// $ pulumi import aws:directconnect/transitVirtualInterface:TransitVirtualInterface test dxvif-33cc44dd
// ```
type TransitVirtualInterface struct {
	pulumi.CustomResourceState

	// The address family for the BGP peer. ` ipv4  ` or `ipv6`.
	AddressFamily pulumi.StringOutput `pulumi:"addressFamily"`
	// The IPv4 CIDR address to use to send traffic to Amazon. Required for IPv4 BGP peers.
	AmazonAddress pulumi.StringOutput `pulumi:"amazonAddress"`
	AmazonSideAsn pulumi.StringOutput `pulumi:"amazonSideAsn"`
	// The ARN of the virtual interface.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// The Direct Connect endpoint on which the virtual interface terminates.
	AwsDevice pulumi.StringOutput `pulumi:"awsDevice"`
	// The autonomous system (AS) number for Border Gateway Protocol (BGP) configuration.
	BgpAsn pulumi.IntOutput `pulumi:"bgpAsn"`
	// The authentication key for BGP configuration.
	BgpAuthKey pulumi.StringOutput `pulumi:"bgpAuthKey"`
	// The ID of the Direct Connect connection (or LAG) on which to create the virtual interface.
	ConnectionId pulumi.StringOutput `pulumi:"connectionId"`
	// The IPv4 CIDR destination address to which Amazon should send traffic. Required for IPv4 BGP peers.
	CustomerAddress pulumi.StringOutput `pulumi:"customerAddress"`
	// The ID of the Direct Connect gateway to which to connect the virtual interface.
	DxGatewayId pulumi.StringOutput `pulumi:"dxGatewayId"`
	// Indicates whether jumbo frames (8500 MTU) are supported.
	JumboFrameCapable pulumi.BoolOutput `pulumi:"jumboFrameCapable"`
	// The maximum transmission unit (MTU) is the size, in bytes, of the largest permissible packet that can be passed over the connection.
	// The MTU of a virtual transit interface can be either `1500` or `8500` (jumbo frames). Default is `1500`.
	Mtu pulumi.IntPtrOutput `pulumi:"mtu"`
	// The name for the virtual interface.
	Name pulumi.StringOutput `pulumi:"name"`
	// Indicates whether to enable or disable SiteLink.
	SitelinkEnabled pulumi.BoolPtrOutput `pulumi:"sitelinkEnabled"`
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	// The VLAN ID.
	Vlan pulumi.IntOutput `pulumi:"vlan"`
}

// NewTransitVirtualInterface registers a new resource with the given unique name, arguments, and options.
func NewTransitVirtualInterface(ctx *pulumi.Context,
	name string, args *TransitVirtualInterfaceArgs, opts ...pulumi.ResourceOption) (*TransitVirtualInterface, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.AddressFamily == nil {
		return nil, errors.New("invalid value for required argument 'AddressFamily'")
	}
	if args.BgpAsn == nil {
		return nil, errors.New("invalid value for required argument 'BgpAsn'")
	}
	if args.ConnectionId == nil {
		return nil, errors.New("invalid value for required argument 'ConnectionId'")
	}
	if args.DxGatewayId == nil {
		return nil, errors.New("invalid value for required argument 'DxGatewayId'")
	}
	if args.Vlan == nil {
		return nil, errors.New("invalid value for required argument 'Vlan'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource TransitVirtualInterface
	err := ctx.RegisterResource("aws:directconnect/transitVirtualInterface:TransitVirtualInterface", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetTransitVirtualInterface gets an existing TransitVirtualInterface resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetTransitVirtualInterface(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *TransitVirtualInterfaceState, opts ...pulumi.ResourceOption) (*TransitVirtualInterface, error) {
	var resource TransitVirtualInterface
	err := ctx.ReadResource("aws:directconnect/transitVirtualInterface:TransitVirtualInterface", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering TransitVirtualInterface resources.
type transitVirtualInterfaceState struct {
	// The address family for the BGP peer. ` ipv4  ` or `ipv6`.
	AddressFamily *string `pulumi:"addressFamily"`
	// The IPv4 CIDR address to use to send traffic to Amazon. Required for IPv4 BGP peers.
	AmazonAddress *string `pulumi:"amazonAddress"`
	AmazonSideAsn *string `pulumi:"amazonSideAsn"`
	// The ARN of the virtual interface.
	Arn *string `pulumi:"arn"`
	// The Direct Connect endpoint on which the virtual interface terminates.
	AwsDevice *string `pulumi:"awsDevice"`
	// The autonomous system (AS) number for Border Gateway Protocol (BGP) configuration.
	BgpAsn *int `pulumi:"bgpAsn"`
	// The authentication key for BGP configuration.
	BgpAuthKey *string `pulumi:"bgpAuthKey"`
	// The ID of the Direct Connect connection (or LAG) on which to create the virtual interface.
	ConnectionId *string `pulumi:"connectionId"`
	// The IPv4 CIDR destination address to which Amazon should send traffic. Required for IPv4 BGP peers.
	CustomerAddress *string `pulumi:"customerAddress"`
	// The ID of the Direct Connect gateway to which to connect the virtual interface.
	DxGatewayId *string `pulumi:"dxGatewayId"`
	// Indicates whether jumbo frames (8500 MTU) are supported.
	JumboFrameCapable *bool `pulumi:"jumboFrameCapable"`
	// The maximum transmission unit (MTU) is the size, in bytes, of the largest permissible packet that can be passed over the connection.
	// The MTU of a virtual transit interface can be either `1500` or `8500` (jumbo frames). Default is `1500`.
	Mtu *int `pulumi:"mtu"`
	// The name for the virtual interface.
	Name *string `pulumi:"name"`
	// Indicates whether to enable or disable SiteLink.
	SitelinkEnabled *bool `pulumi:"sitelinkEnabled"`
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	// The VLAN ID.
	Vlan *int `pulumi:"vlan"`
}

type TransitVirtualInterfaceState struct {
	// The address family for the BGP peer. ` ipv4  ` or `ipv6`.
	AddressFamily pulumi.StringPtrInput
	// The IPv4 CIDR address to use to send traffic to Amazon. Required for IPv4 BGP peers.
	AmazonAddress pulumi.StringPtrInput
	AmazonSideAsn pulumi.StringPtrInput
	// The ARN of the virtual interface.
	Arn pulumi.StringPtrInput
	// The Direct Connect endpoint on which the virtual interface terminates.
	AwsDevice pulumi.StringPtrInput
	// The autonomous system (AS) number for Border Gateway Protocol (BGP) configuration.
	BgpAsn pulumi.IntPtrInput
	// The authentication key for BGP configuration.
	BgpAuthKey pulumi.StringPtrInput
	// The ID of the Direct Connect connection (or LAG) on which to create the virtual interface.
	ConnectionId pulumi.StringPtrInput
	// The IPv4 CIDR destination address to which Amazon should send traffic. Required for IPv4 BGP peers.
	CustomerAddress pulumi.StringPtrInput
	// The ID of the Direct Connect gateway to which to connect the virtual interface.
	DxGatewayId pulumi.StringPtrInput
	// Indicates whether jumbo frames (8500 MTU) are supported.
	JumboFrameCapable pulumi.BoolPtrInput
	// The maximum transmission unit (MTU) is the size, in bytes, of the largest permissible packet that can be passed over the connection.
	// The MTU of a virtual transit interface can be either `1500` or `8500` (jumbo frames). Default is `1500`.
	Mtu pulumi.IntPtrInput
	// The name for the virtual interface.
	Name pulumi.StringPtrInput
	// Indicates whether to enable or disable SiteLink.
	SitelinkEnabled pulumi.BoolPtrInput
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	// The VLAN ID.
	Vlan pulumi.IntPtrInput
}

func (TransitVirtualInterfaceState) ElementType() reflect.Type {
	return reflect.TypeOf((*transitVirtualInterfaceState)(nil)).Elem()
}

type transitVirtualInterfaceArgs struct {
	// The address family for the BGP peer. ` ipv4  ` or `ipv6`.
	AddressFamily string `pulumi:"addressFamily"`
	// The IPv4 CIDR address to use to send traffic to Amazon. Required for IPv4 BGP peers.
	AmazonAddress *string `pulumi:"amazonAddress"`
	// The autonomous system (AS) number for Border Gateway Protocol (BGP) configuration.
	BgpAsn int `pulumi:"bgpAsn"`
	// The authentication key for BGP configuration.
	BgpAuthKey *string `pulumi:"bgpAuthKey"`
	// The ID of the Direct Connect connection (or LAG) on which to create the virtual interface.
	ConnectionId string `pulumi:"connectionId"`
	// The IPv4 CIDR destination address to which Amazon should send traffic. Required for IPv4 BGP peers.
	CustomerAddress *string `pulumi:"customerAddress"`
	// The ID of the Direct Connect gateway to which to connect the virtual interface.
	DxGatewayId string `pulumi:"dxGatewayId"`
	// The maximum transmission unit (MTU) is the size, in bytes, of the largest permissible packet that can be passed over the connection.
	// The MTU of a virtual transit interface can be either `1500` or `8500` (jumbo frames). Default is `1500`.
	Mtu *int `pulumi:"mtu"`
	// The name for the virtual interface.
	Name *string `pulumi:"name"`
	// Indicates whether to enable or disable SiteLink.
	SitelinkEnabled *bool `pulumi:"sitelinkEnabled"`
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// The VLAN ID.
	Vlan int `pulumi:"vlan"`
}

// The set of arguments for constructing a TransitVirtualInterface resource.
type TransitVirtualInterfaceArgs struct {
	// The address family for the BGP peer. ` ipv4  ` or `ipv6`.
	AddressFamily pulumi.StringInput
	// The IPv4 CIDR address to use to send traffic to Amazon. Required for IPv4 BGP peers.
	AmazonAddress pulumi.StringPtrInput
	// The autonomous system (AS) number for Border Gateway Protocol (BGP) configuration.
	BgpAsn pulumi.IntInput
	// The authentication key for BGP configuration.
	BgpAuthKey pulumi.StringPtrInput
	// The ID of the Direct Connect connection (or LAG) on which to create the virtual interface.
	ConnectionId pulumi.StringInput
	// The IPv4 CIDR destination address to which Amazon should send traffic. Required for IPv4 BGP peers.
	CustomerAddress pulumi.StringPtrInput
	// The ID of the Direct Connect gateway to which to connect the virtual interface.
	DxGatewayId pulumi.StringInput
	// The maximum transmission unit (MTU) is the size, in bytes, of the largest permissible packet that can be passed over the connection.
	// The MTU of a virtual transit interface can be either `1500` or `8500` (jumbo frames). Default is `1500`.
	Mtu pulumi.IntPtrInput
	// The name for the virtual interface.
	Name pulumi.StringPtrInput
	// Indicates whether to enable or disable SiteLink.
	SitelinkEnabled pulumi.BoolPtrInput
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// The VLAN ID.
	Vlan pulumi.IntInput
}

func (TransitVirtualInterfaceArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*transitVirtualInterfaceArgs)(nil)).Elem()
}

type TransitVirtualInterfaceInput interface {
	pulumi.Input

	ToTransitVirtualInterfaceOutput() TransitVirtualInterfaceOutput
	ToTransitVirtualInterfaceOutputWithContext(ctx context.Context) TransitVirtualInterfaceOutput
}

func (*TransitVirtualInterface) ElementType() reflect.Type {
	return reflect.TypeOf((**TransitVirtualInterface)(nil)).Elem()
}

func (i *TransitVirtualInterface) ToTransitVirtualInterfaceOutput() TransitVirtualInterfaceOutput {
	return i.ToTransitVirtualInterfaceOutputWithContext(context.Background())
}

func (i *TransitVirtualInterface) ToTransitVirtualInterfaceOutputWithContext(ctx context.Context) TransitVirtualInterfaceOutput {
	return pulumi.ToOutputWithContext(ctx, i).(TransitVirtualInterfaceOutput)
}

// TransitVirtualInterfaceArrayInput is an input type that accepts TransitVirtualInterfaceArray and TransitVirtualInterfaceArrayOutput values.
// You can construct a concrete instance of `TransitVirtualInterfaceArrayInput` via:
//
//	TransitVirtualInterfaceArray{ TransitVirtualInterfaceArgs{...} }
type TransitVirtualInterfaceArrayInput interface {
	pulumi.Input

	ToTransitVirtualInterfaceArrayOutput() TransitVirtualInterfaceArrayOutput
	ToTransitVirtualInterfaceArrayOutputWithContext(context.Context) TransitVirtualInterfaceArrayOutput
}

type TransitVirtualInterfaceArray []TransitVirtualInterfaceInput

func (TransitVirtualInterfaceArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*TransitVirtualInterface)(nil)).Elem()
}

func (i TransitVirtualInterfaceArray) ToTransitVirtualInterfaceArrayOutput() TransitVirtualInterfaceArrayOutput {
	return i.ToTransitVirtualInterfaceArrayOutputWithContext(context.Background())
}

func (i TransitVirtualInterfaceArray) ToTransitVirtualInterfaceArrayOutputWithContext(ctx context.Context) TransitVirtualInterfaceArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(TransitVirtualInterfaceArrayOutput)
}

// TransitVirtualInterfaceMapInput is an input type that accepts TransitVirtualInterfaceMap and TransitVirtualInterfaceMapOutput values.
// You can construct a concrete instance of `TransitVirtualInterfaceMapInput` via:
//
//	TransitVirtualInterfaceMap{ "key": TransitVirtualInterfaceArgs{...} }
type TransitVirtualInterfaceMapInput interface {
	pulumi.Input

	ToTransitVirtualInterfaceMapOutput() TransitVirtualInterfaceMapOutput
	ToTransitVirtualInterfaceMapOutputWithContext(context.Context) TransitVirtualInterfaceMapOutput
}

type TransitVirtualInterfaceMap map[string]TransitVirtualInterfaceInput

func (TransitVirtualInterfaceMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*TransitVirtualInterface)(nil)).Elem()
}

func (i TransitVirtualInterfaceMap) ToTransitVirtualInterfaceMapOutput() TransitVirtualInterfaceMapOutput {
	return i.ToTransitVirtualInterfaceMapOutputWithContext(context.Background())
}

func (i TransitVirtualInterfaceMap) ToTransitVirtualInterfaceMapOutputWithContext(ctx context.Context) TransitVirtualInterfaceMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(TransitVirtualInterfaceMapOutput)
}

type TransitVirtualInterfaceOutput struct{ *pulumi.OutputState }

func (TransitVirtualInterfaceOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**TransitVirtualInterface)(nil)).Elem()
}

func (o TransitVirtualInterfaceOutput) ToTransitVirtualInterfaceOutput() TransitVirtualInterfaceOutput {
	return o
}

func (o TransitVirtualInterfaceOutput) ToTransitVirtualInterfaceOutputWithContext(ctx context.Context) TransitVirtualInterfaceOutput {
	return o
}

// The address family for the BGP peer. ` ipv4  ` or `ipv6`.
func (o TransitVirtualInterfaceOutput) AddressFamily() pulumi.StringOutput {
	return o.ApplyT(func(v *TransitVirtualInterface) pulumi.StringOutput { return v.AddressFamily }).(pulumi.StringOutput)
}

// The IPv4 CIDR address to use to send traffic to Amazon. Required for IPv4 BGP peers.
func (o TransitVirtualInterfaceOutput) AmazonAddress() pulumi.StringOutput {
	return o.ApplyT(func(v *TransitVirtualInterface) pulumi.StringOutput { return v.AmazonAddress }).(pulumi.StringOutput)
}

func (o TransitVirtualInterfaceOutput) AmazonSideAsn() pulumi.StringOutput {
	return o.ApplyT(func(v *TransitVirtualInterface) pulumi.StringOutput { return v.AmazonSideAsn }).(pulumi.StringOutput)
}

// The ARN of the virtual interface.
func (o TransitVirtualInterfaceOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *TransitVirtualInterface) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// The Direct Connect endpoint on which the virtual interface terminates.
func (o TransitVirtualInterfaceOutput) AwsDevice() pulumi.StringOutput {
	return o.ApplyT(func(v *TransitVirtualInterface) pulumi.StringOutput { return v.AwsDevice }).(pulumi.StringOutput)
}

// The autonomous system (AS) number for Border Gateway Protocol (BGP) configuration.
func (o TransitVirtualInterfaceOutput) BgpAsn() pulumi.IntOutput {
	return o.ApplyT(func(v *TransitVirtualInterface) pulumi.IntOutput { return v.BgpAsn }).(pulumi.IntOutput)
}

// The authentication key for BGP configuration.
func (o TransitVirtualInterfaceOutput) BgpAuthKey() pulumi.StringOutput {
	return o.ApplyT(func(v *TransitVirtualInterface) pulumi.StringOutput { return v.BgpAuthKey }).(pulumi.StringOutput)
}

// The ID of the Direct Connect connection (or LAG) on which to create the virtual interface.
func (o TransitVirtualInterfaceOutput) ConnectionId() pulumi.StringOutput {
	return o.ApplyT(func(v *TransitVirtualInterface) pulumi.StringOutput { return v.ConnectionId }).(pulumi.StringOutput)
}

// The IPv4 CIDR destination address to which Amazon should send traffic. Required for IPv4 BGP peers.
func (o TransitVirtualInterfaceOutput) CustomerAddress() pulumi.StringOutput {
	return o.ApplyT(func(v *TransitVirtualInterface) pulumi.StringOutput { return v.CustomerAddress }).(pulumi.StringOutput)
}

// The ID of the Direct Connect gateway to which to connect the virtual interface.
func (o TransitVirtualInterfaceOutput) DxGatewayId() pulumi.StringOutput {
	return o.ApplyT(func(v *TransitVirtualInterface) pulumi.StringOutput { return v.DxGatewayId }).(pulumi.StringOutput)
}

// Indicates whether jumbo frames (8500 MTU) are supported.
func (o TransitVirtualInterfaceOutput) JumboFrameCapable() pulumi.BoolOutput {
	return o.ApplyT(func(v *TransitVirtualInterface) pulumi.BoolOutput { return v.JumboFrameCapable }).(pulumi.BoolOutput)
}

// The maximum transmission unit (MTU) is the size, in bytes, of the largest permissible packet that can be passed over the connection.
// The MTU of a virtual transit interface can be either `1500` or `8500` (jumbo frames). Default is `1500`.
func (o TransitVirtualInterfaceOutput) Mtu() pulumi.IntPtrOutput {
	return o.ApplyT(func(v *TransitVirtualInterface) pulumi.IntPtrOutput { return v.Mtu }).(pulumi.IntPtrOutput)
}

// The name for the virtual interface.
func (o TransitVirtualInterfaceOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *TransitVirtualInterface) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// Indicates whether to enable or disable SiteLink.
func (o TransitVirtualInterfaceOutput) SitelinkEnabled() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v *TransitVirtualInterface) pulumi.BoolPtrOutput { return v.SitelinkEnabled }).(pulumi.BoolPtrOutput)
}

// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o TransitVirtualInterfaceOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *TransitVirtualInterface) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o TransitVirtualInterfaceOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *TransitVirtualInterface) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

// The VLAN ID.
func (o TransitVirtualInterfaceOutput) Vlan() pulumi.IntOutput {
	return o.ApplyT(func(v *TransitVirtualInterface) pulumi.IntOutput { return v.Vlan }).(pulumi.IntOutput)
}

type TransitVirtualInterfaceArrayOutput struct{ *pulumi.OutputState }

func (TransitVirtualInterfaceArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*TransitVirtualInterface)(nil)).Elem()
}

func (o TransitVirtualInterfaceArrayOutput) ToTransitVirtualInterfaceArrayOutput() TransitVirtualInterfaceArrayOutput {
	return o
}

func (o TransitVirtualInterfaceArrayOutput) ToTransitVirtualInterfaceArrayOutputWithContext(ctx context.Context) TransitVirtualInterfaceArrayOutput {
	return o
}

func (o TransitVirtualInterfaceArrayOutput) Index(i pulumi.IntInput) TransitVirtualInterfaceOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *TransitVirtualInterface {
		return vs[0].([]*TransitVirtualInterface)[vs[1].(int)]
	}).(TransitVirtualInterfaceOutput)
}

type TransitVirtualInterfaceMapOutput struct{ *pulumi.OutputState }

func (TransitVirtualInterfaceMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*TransitVirtualInterface)(nil)).Elem()
}

func (o TransitVirtualInterfaceMapOutput) ToTransitVirtualInterfaceMapOutput() TransitVirtualInterfaceMapOutput {
	return o
}

func (o TransitVirtualInterfaceMapOutput) ToTransitVirtualInterfaceMapOutputWithContext(ctx context.Context) TransitVirtualInterfaceMapOutput {
	return o
}

func (o TransitVirtualInterfaceMapOutput) MapIndex(k pulumi.StringInput) TransitVirtualInterfaceOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *TransitVirtualInterface {
		return vs[0].(map[string]*TransitVirtualInterface)[vs[1].(string)]
	}).(TransitVirtualInterfaceOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*TransitVirtualInterfaceInput)(nil)).Elem(), &TransitVirtualInterface{})
	pulumi.RegisterInputType(reflect.TypeOf((*TransitVirtualInterfaceArrayInput)(nil)).Elem(), TransitVirtualInterfaceArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*TransitVirtualInterfaceMapInput)(nil)).Elem(), TransitVirtualInterfaceMap{})
	pulumi.RegisterOutputType(TransitVirtualInterfaceOutput{})
	pulumi.RegisterOutputType(TransitVirtualInterfaceArrayOutput{})
	pulumi.RegisterOutputType(TransitVirtualInterfaceMapOutput{})
}
