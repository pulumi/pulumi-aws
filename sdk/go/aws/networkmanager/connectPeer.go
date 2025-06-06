// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package networkmanager

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS Network Manager Connect Peer.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/networkmanager"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
// func main() {
// pulumi.Run(func(ctx *pulumi.Context) error {
// var splat0 []interface{}
// for _, val0 := range exampleAwsSubnet {
// splat0 = append(splat0, val0.Arn)
// }
// example, err := networkmanager.NewVpcAttachment(ctx, "example", &networkmanager.VpcAttachmentArgs{
// SubnetArns: toPulumiArray(splat0),
// CoreNetworkId: pulumi.Any(exampleAwsccNetworkmanagerCoreNetwork.Id),
// VpcArn: pulumi.Any(exampleAwsVpc.Arn),
// })
// if err != nil {
// return err
// }
// exampleConnectAttachment, err := networkmanager.NewConnectAttachment(ctx, "example", &networkmanager.ConnectAttachmentArgs{
// CoreNetworkId: pulumi.Any(exampleAwsccNetworkmanagerCoreNetwork.Id),
// TransportAttachmentId: example.ID(),
// EdgeLocation: example.EdgeLocation,
// Options: &networkmanager.ConnectAttachmentOptionsArgs{
// Protocol: pulumi.String("GRE"),
// },
// })
// if err != nil {
// return err
// }
// _, err = networkmanager.NewConnectPeer(ctx, "example", &networkmanager.ConnectPeerArgs{
// ConnectAttachmentId: exampleConnectAttachment.ID(),
// PeerAddress: pulumi.String("127.0.0.1"),
// BgpOptions: &networkmanager.ConnectPeerBgpOptionsArgs{
// PeerAsn: pulumi.Int(65000),
// },
// InsideCidrBlocks: pulumi.StringArray{
// pulumi.String("172.16.0.0/16"),
// },
// })
// if err != nil {
// return err
// }
// return nil
// })
// }
// func toPulumiArray(arr []) pulumi.Array {
// var pulumiArr pulumi.Array
// for _, v := range arr {
// pulumiArr = append(pulumiArr, pulumi.(v))
// }
// return pulumiArr
// }
// ```
//
// ### Usage with attachment accepter
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/networkmanager"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
// func main() {
// pulumi.Run(func(ctx *pulumi.Context) error {
// var splat0 []interface{}
// for _, val0 := range exampleAwsSubnet {
// splat0 = append(splat0, val0.Arn)
// }
// example, err := networkmanager.NewVpcAttachment(ctx, "example", &networkmanager.VpcAttachmentArgs{
// SubnetArns: toPulumiArray(splat0),
// CoreNetworkId: pulumi.Any(exampleAwsccNetworkmanagerCoreNetwork.Id),
// VpcArn: pulumi.Any(exampleAwsVpc.Arn),
// })
// if err != nil {
// return err
// }
// _, err = networkmanager.NewAttachmentAccepter(ctx, "example", &networkmanager.AttachmentAccepterArgs{
// AttachmentId: example.ID(),
// AttachmentType: example.AttachmentType,
// })
// if err != nil {
// return err
// }
// exampleConnectAttachment, err := networkmanager.NewConnectAttachment(ctx, "example", &networkmanager.ConnectAttachmentArgs{
// CoreNetworkId: pulumi.Any(exampleAwsccNetworkmanagerCoreNetwork.Id),
// TransportAttachmentId: example.ID(),
// EdgeLocation: example.EdgeLocation,
// Options: &networkmanager.ConnectAttachmentOptionsArgs{
// Protocol: pulumi.String("GRE"),
// },
// }, pulumi.DependsOn([]pulumi.Resource{
// test,
// }))
// if err != nil {
// return err
// }
// example2, err := networkmanager.NewAttachmentAccepter(ctx, "example2", &networkmanager.AttachmentAccepterArgs{
// AttachmentId: exampleConnectAttachment.ID(),
// AttachmentType: exampleConnectAttachment.AttachmentType,
// })
// if err != nil {
// return err
// }
// _, err = networkmanager.NewConnectPeer(ctx, "example", &networkmanager.ConnectPeerArgs{
// ConnectAttachmentId: exampleConnectAttachment.ID(),
// PeerAddress: pulumi.String("127.0.0.1"),
// BgpOptions: &networkmanager.ConnectPeerBgpOptionsArgs{
// PeerAsn: pulumi.Int(65500),
// },
// InsideCidrBlocks: pulumi.StringArray{
// pulumi.String("172.16.0.0/16"),
// },
// }, pulumi.DependsOn([]pulumi.Resource{
// example2,
// }))
// if err != nil {
// return err
// }
// return nil
// })
// }
// func toPulumiArray(arr []) pulumi.Array {
// var pulumiArr pulumi.Array
// for _, v := range arr {
// pulumiArr = append(pulumiArr, pulumi.(v))
// }
// return pulumiArr
// }
// ```
//
// ### Usage with a Tunnel-less Connect attachment
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/networkmanager"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
// func main() {
// pulumi.Run(func(ctx *pulumi.Context) error {
// var splat0 []interface{}
// for _, val0 := range exampleAwsSubnet {
// splat0 = append(splat0, val0.Arn)
// }
// example, err := networkmanager.NewVpcAttachment(ctx, "example", &networkmanager.VpcAttachmentArgs{
// SubnetArns: toPulumiArray(splat0),
// CoreNetworkId: pulumi.Any(exampleAwsccNetworkmanagerCoreNetwork.Id),
// VpcArn: pulumi.Any(exampleAwsVpc.Arn),
// })
// if err != nil {
// return err
// }
// exampleConnectAttachment, err := networkmanager.NewConnectAttachment(ctx, "example", &networkmanager.ConnectAttachmentArgs{
// CoreNetworkId: pulumi.Any(exampleAwsccNetworkmanagerCoreNetwork.Id),
// TransportAttachmentId: example.ID(),
// EdgeLocation: example.EdgeLocation,
// Options: &networkmanager.ConnectAttachmentOptionsArgs{
// Protocol: pulumi.String("NO_ENCAP"),
// },
// })
// if err != nil {
// return err
// }
// _, err = networkmanager.NewConnectPeer(ctx, "example", &networkmanager.ConnectPeerArgs{
// ConnectAttachmentId: exampleConnectAttachment.ID(),
// PeerAddress: pulumi.String("127.0.0.1"),
// BgpOptions: &networkmanager.ConnectPeerBgpOptionsArgs{
// PeerAsn: pulumi.Int(65000),
// },
// SubnetArn: pulumi.Any(test2.Arn),
// })
// if err != nil {
// return err
// }
// return nil
// })
// }
// func toPulumiArray(arr []) pulumi.Array {
// var pulumiArr pulumi.Array
// for _, v := range arr {
// pulumiArr = append(pulumiArr, pulumi.(v))
// }
// return pulumiArr
// }
// ```
//
// ## Import
//
// Using `pulumi import`, import `aws_networkmanager_connect_peer` using the connect peer ID. For example:
//
// ```sh
// $ pulumi import aws:networkmanager/connectPeer:ConnectPeer example connect-peer-061f3e96275db1acc
// ```
type ConnectPeer struct {
	pulumi.CustomResourceState

	// The ARN of the attachment.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// The Connect peer BGP options.
	BgpOptions ConnectPeerBgpOptionsPtrOutput `pulumi:"bgpOptions"`
	// The configuration of the Connect peer.
	Configurations ConnectPeerConfigurationArrayOutput `pulumi:"configurations"`
	// The ID of the connection attachment.
	ConnectAttachmentId pulumi.StringOutput `pulumi:"connectAttachmentId"`
	ConnectPeerId       pulumi.StringOutput `pulumi:"connectPeerId"`
	// A Connect peer core network address.
	CoreNetworkAddress pulumi.StringPtrOutput `pulumi:"coreNetworkAddress"`
	// The ID of a core network.
	CoreNetworkId pulumi.StringOutput `pulumi:"coreNetworkId"`
	CreatedAt     pulumi.StringOutput `pulumi:"createdAt"`
	// The Region where the peer is located.
	EdgeLocation pulumi.StringOutput `pulumi:"edgeLocation"`
	// The inside IP addresses used for BGP peering. Required when the Connect attachment protocol is `GRE`. See `networkmanager.ConnectAttachment` for details.
	InsideCidrBlocks pulumi.StringArrayOutput `pulumi:"insideCidrBlocks"`
	// The Connect peer address.
	//
	// The following arguments are optional:
	PeerAddress pulumi.StringOutput `pulumi:"peerAddress"`
	// The state of the Connect peer.
	State pulumi.StringOutput `pulumi:"state"`
	// The subnet ARN for the Connect peer. Required when the Connect attachment protocol is `NO_ENCAP`. See `networkmanager.ConnectAttachment` for details.
	SubnetArn pulumi.StringPtrOutput `pulumi:"subnetArn"`
	// Key-value tags for the attachment. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewConnectPeer registers a new resource with the given unique name, arguments, and options.
func NewConnectPeer(ctx *pulumi.Context,
	name string, args *ConnectPeerArgs, opts ...pulumi.ResourceOption) (*ConnectPeer, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.ConnectAttachmentId == nil {
		return nil, errors.New("invalid value for required argument 'ConnectAttachmentId'")
	}
	if args.PeerAddress == nil {
		return nil, errors.New("invalid value for required argument 'PeerAddress'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource ConnectPeer
	err := ctx.RegisterResource("aws:networkmanager/connectPeer:ConnectPeer", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetConnectPeer gets an existing ConnectPeer resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetConnectPeer(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ConnectPeerState, opts ...pulumi.ResourceOption) (*ConnectPeer, error) {
	var resource ConnectPeer
	err := ctx.ReadResource("aws:networkmanager/connectPeer:ConnectPeer", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering ConnectPeer resources.
type connectPeerState struct {
	// The ARN of the attachment.
	Arn *string `pulumi:"arn"`
	// The Connect peer BGP options.
	BgpOptions *ConnectPeerBgpOptions `pulumi:"bgpOptions"`
	// The configuration of the Connect peer.
	Configurations []ConnectPeerConfiguration `pulumi:"configurations"`
	// The ID of the connection attachment.
	ConnectAttachmentId *string `pulumi:"connectAttachmentId"`
	ConnectPeerId       *string `pulumi:"connectPeerId"`
	// A Connect peer core network address.
	CoreNetworkAddress *string `pulumi:"coreNetworkAddress"`
	// The ID of a core network.
	CoreNetworkId *string `pulumi:"coreNetworkId"`
	CreatedAt     *string `pulumi:"createdAt"`
	// The Region where the peer is located.
	EdgeLocation *string `pulumi:"edgeLocation"`
	// The inside IP addresses used for BGP peering. Required when the Connect attachment protocol is `GRE`. See `networkmanager.ConnectAttachment` for details.
	InsideCidrBlocks []string `pulumi:"insideCidrBlocks"`
	// The Connect peer address.
	//
	// The following arguments are optional:
	PeerAddress *string `pulumi:"peerAddress"`
	// The state of the Connect peer.
	State *string `pulumi:"state"`
	// The subnet ARN for the Connect peer. Required when the Connect attachment protocol is `NO_ENCAP`. See `networkmanager.ConnectAttachment` for details.
	SubnetArn *string `pulumi:"subnetArn"`
	// Key-value tags for the attachment. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type ConnectPeerState struct {
	// The ARN of the attachment.
	Arn pulumi.StringPtrInput
	// The Connect peer BGP options.
	BgpOptions ConnectPeerBgpOptionsPtrInput
	// The configuration of the Connect peer.
	Configurations ConnectPeerConfigurationArrayInput
	// The ID of the connection attachment.
	ConnectAttachmentId pulumi.StringPtrInput
	ConnectPeerId       pulumi.StringPtrInput
	// A Connect peer core network address.
	CoreNetworkAddress pulumi.StringPtrInput
	// The ID of a core network.
	CoreNetworkId pulumi.StringPtrInput
	CreatedAt     pulumi.StringPtrInput
	// The Region where the peer is located.
	EdgeLocation pulumi.StringPtrInput
	// The inside IP addresses used for BGP peering. Required when the Connect attachment protocol is `GRE`. See `networkmanager.ConnectAttachment` for details.
	InsideCidrBlocks pulumi.StringArrayInput
	// The Connect peer address.
	//
	// The following arguments are optional:
	PeerAddress pulumi.StringPtrInput
	// The state of the Connect peer.
	State pulumi.StringPtrInput
	// The subnet ARN for the Connect peer. Required when the Connect attachment protocol is `NO_ENCAP`. See `networkmanager.ConnectAttachment` for details.
	SubnetArn pulumi.StringPtrInput
	// Key-value tags for the attachment. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (ConnectPeerState) ElementType() reflect.Type {
	return reflect.TypeOf((*connectPeerState)(nil)).Elem()
}

type connectPeerArgs struct {
	// The Connect peer BGP options.
	BgpOptions *ConnectPeerBgpOptions `pulumi:"bgpOptions"`
	// The ID of the connection attachment.
	ConnectAttachmentId string `pulumi:"connectAttachmentId"`
	// A Connect peer core network address.
	CoreNetworkAddress *string `pulumi:"coreNetworkAddress"`
	// The inside IP addresses used for BGP peering. Required when the Connect attachment protocol is `GRE`. See `networkmanager.ConnectAttachment` for details.
	InsideCidrBlocks []string `pulumi:"insideCidrBlocks"`
	// The Connect peer address.
	//
	// The following arguments are optional:
	PeerAddress string `pulumi:"peerAddress"`
	// The subnet ARN for the Connect peer. Required when the Connect attachment protocol is `NO_ENCAP`. See `networkmanager.ConnectAttachment` for details.
	SubnetArn *string `pulumi:"subnetArn"`
	// Key-value tags for the attachment. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a ConnectPeer resource.
type ConnectPeerArgs struct {
	// The Connect peer BGP options.
	BgpOptions ConnectPeerBgpOptionsPtrInput
	// The ID of the connection attachment.
	ConnectAttachmentId pulumi.StringInput
	// A Connect peer core network address.
	CoreNetworkAddress pulumi.StringPtrInput
	// The inside IP addresses used for BGP peering. Required when the Connect attachment protocol is `GRE`. See `networkmanager.ConnectAttachment` for details.
	InsideCidrBlocks pulumi.StringArrayInput
	// The Connect peer address.
	//
	// The following arguments are optional:
	PeerAddress pulumi.StringInput
	// The subnet ARN for the Connect peer. Required when the Connect attachment protocol is `NO_ENCAP`. See `networkmanager.ConnectAttachment` for details.
	SubnetArn pulumi.StringPtrInput
	// Key-value tags for the attachment. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (ConnectPeerArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*connectPeerArgs)(nil)).Elem()
}

type ConnectPeerInput interface {
	pulumi.Input

	ToConnectPeerOutput() ConnectPeerOutput
	ToConnectPeerOutputWithContext(ctx context.Context) ConnectPeerOutput
}

func (*ConnectPeer) ElementType() reflect.Type {
	return reflect.TypeOf((**ConnectPeer)(nil)).Elem()
}

func (i *ConnectPeer) ToConnectPeerOutput() ConnectPeerOutput {
	return i.ToConnectPeerOutputWithContext(context.Background())
}

func (i *ConnectPeer) ToConnectPeerOutputWithContext(ctx context.Context) ConnectPeerOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ConnectPeerOutput)
}

// ConnectPeerArrayInput is an input type that accepts ConnectPeerArray and ConnectPeerArrayOutput values.
// You can construct a concrete instance of `ConnectPeerArrayInput` via:
//
//	ConnectPeerArray{ ConnectPeerArgs{...} }
type ConnectPeerArrayInput interface {
	pulumi.Input

	ToConnectPeerArrayOutput() ConnectPeerArrayOutput
	ToConnectPeerArrayOutputWithContext(context.Context) ConnectPeerArrayOutput
}

type ConnectPeerArray []ConnectPeerInput

func (ConnectPeerArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ConnectPeer)(nil)).Elem()
}

func (i ConnectPeerArray) ToConnectPeerArrayOutput() ConnectPeerArrayOutput {
	return i.ToConnectPeerArrayOutputWithContext(context.Background())
}

func (i ConnectPeerArray) ToConnectPeerArrayOutputWithContext(ctx context.Context) ConnectPeerArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ConnectPeerArrayOutput)
}

// ConnectPeerMapInput is an input type that accepts ConnectPeerMap and ConnectPeerMapOutput values.
// You can construct a concrete instance of `ConnectPeerMapInput` via:
//
//	ConnectPeerMap{ "key": ConnectPeerArgs{...} }
type ConnectPeerMapInput interface {
	pulumi.Input

	ToConnectPeerMapOutput() ConnectPeerMapOutput
	ToConnectPeerMapOutputWithContext(context.Context) ConnectPeerMapOutput
}

type ConnectPeerMap map[string]ConnectPeerInput

func (ConnectPeerMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ConnectPeer)(nil)).Elem()
}

func (i ConnectPeerMap) ToConnectPeerMapOutput() ConnectPeerMapOutput {
	return i.ToConnectPeerMapOutputWithContext(context.Background())
}

func (i ConnectPeerMap) ToConnectPeerMapOutputWithContext(ctx context.Context) ConnectPeerMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ConnectPeerMapOutput)
}

type ConnectPeerOutput struct{ *pulumi.OutputState }

func (ConnectPeerOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**ConnectPeer)(nil)).Elem()
}

func (o ConnectPeerOutput) ToConnectPeerOutput() ConnectPeerOutput {
	return o
}

func (o ConnectPeerOutput) ToConnectPeerOutputWithContext(ctx context.Context) ConnectPeerOutput {
	return o
}

// The ARN of the attachment.
func (o ConnectPeerOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *ConnectPeer) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// The Connect peer BGP options.
func (o ConnectPeerOutput) BgpOptions() ConnectPeerBgpOptionsPtrOutput {
	return o.ApplyT(func(v *ConnectPeer) ConnectPeerBgpOptionsPtrOutput { return v.BgpOptions }).(ConnectPeerBgpOptionsPtrOutput)
}

// The configuration of the Connect peer.
func (o ConnectPeerOutput) Configurations() ConnectPeerConfigurationArrayOutput {
	return o.ApplyT(func(v *ConnectPeer) ConnectPeerConfigurationArrayOutput { return v.Configurations }).(ConnectPeerConfigurationArrayOutput)
}

// The ID of the connection attachment.
func (o ConnectPeerOutput) ConnectAttachmentId() pulumi.StringOutput {
	return o.ApplyT(func(v *ConnectPeer) pulumi.StringOutput { return v.ConnectAttachmentId }).(pulumi.StringOutput)
}

func (o ConnectPeerOutput) ConnectPeerId() pulumi.StringOutput {
	return o.ApplyT(func(v *ConnectPeer) pulumi.StringOutput { return v.ConnectPeerId }).(pulumi.StringOutput)
}

// A Connect peer core network address.
func (o ConnectPeerOutput) CoreNetworkAddress() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *ConnectPeer) pulumi.StringPtrOutput { return v.CoreNetworkAddress }).(pulumi.StringPtrOutput)
}

// The ID of a core network.
func (o ConnectPeerOutput) CoreNetworkId() pulumi.StringOutput {
	return o.ApplyT(func(v *ConnectPeer) pulumi.StringOutput { return v.CoreNetworkId }).(pulumi.StringOutput)
}

func (o ConnectPeerOutput) CreatedAt() pulumi.StringOutput {
	return o.ApplyT(func(v *ConnectPeer) pulumi.StringOutput { return v.CreatedAt }).(pulumi.StringOutput)
}

// The Region where the peer is located.
func (o ConnectPeerOutput) EdgeLocation() pulumi.StringOutput {
	return o.ApplyT(func(v *ConnectPeer) pulumi.StringOutput { return v.EdgeLocation }).(pulumi.StringOutput)
}

// The inside IP addresses used for BGP peering. Required when the Connect attachment protocol is `GRE`. See `networkmanager.ConnectAttachment` for details.
func (o ConnectPeerOutput) InsideCidrBlocks() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *ConnectPeer) pulumi.StringArrayOutput { return v.InsideCidrBlocks }).(pulumi.StringArrayOutput)
}

// The Connect peer address.
//
// The following arguments are optional:
func (o ConnectPeerOutput) PeerAddress() pulumi.StringOutput {
	return o.ApplyT(func(v *ConnectPeer) pulumi.StringOutput { return v.PeerAddress }).(pulumi.StringOutput)
}

// The state of the Connect peer.
func (o ConnectPeerOutput) State() pulumi.StringOutput {
	return o.ApplyT(func(v *ConnectPeer) pulumi.StringOutput { return v.State }).(pulumi.StringOutput)
}

// The subnet ARN for the Connect peer. Required when the Connect attachment protocol is `NO_ENCAP`. See `networkmanager.ConnectAttachment` for details.
func (o ConnectPeerOutput) SubnetArn() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *ConnectPeer) pulumi.StringPtrOutput { return v.SubnetArn }).(pulumi.StringPtrOutput)
}

// Key-value tags for the attachment. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o ConnectPeerOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *ConnectPeer) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o ConnectPeerOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *ConnectPeer) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type ConnectPeerArrayOutput struct{ *pulumi.OutputState }

func (ConnectPeerArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ConnectPeer)(nil)).Elem()
}

func (o ConnectPeerArrayOutput) ToConnectPeerArrayOutput() ConnectPeerArrayOutput {
	return o
}

func (o ConnectPeerArrayOutput) ToConnectPeerArrayOutputWithContext(ctx context.Context) ConnectPeerArrayOutput {
	return o
}

func (o ConnectPeerArrayOutput) Index(i pulumi.IntInput) ConnectPeerOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *ConnectPeer {
		return vs[0].([]*ConnectPeer)[vs[1].(int)]
	}).(ConnectPeerOutput)
}

type ConnectPeerMapOutput struct{ *pulumi.OutputState }

func (ConnectPeerMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ConnectPeer)(nil)).Elem()
}

func (o ConnectPeerMapOutput) ToConnectPeerMapOutput() ConnectPeerMapOutput {
	return o
}

func (o ConnectPeerMapOutput) ToConnectPeerMapOutputWithContext(ctx context.Context) ConnectPeerMapOutput {
	return o
}

func (o ConnectPeerMapOutput) MapIndex(k pulumi.StringInput) ConnectPeerOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *ConnectPeer {
		return vs[0].(map[string]*ConnectPeer)[vs[1].(string)]
	}).(ConnectPeerOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ConnectPeerInput)(nil)).Elem(), &ConnectPeer{})
	pulumi.RegisterInputType(reflect.TypeOf((*ConnectPeerArrayInput)(nil)).Elem(), ConnectPeerArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ConnectPeerMapInput)(nil)).Elem(), ConnectPeerMap{})
	pulumi.RegisterOutputType(ConnectPeerOutput{})
	pulumi.RegisterOutputType(ConnectPeerArrayOutput{})
	pulumi.RegisterOutputType(ConnectPeerMapOutput{})
}
