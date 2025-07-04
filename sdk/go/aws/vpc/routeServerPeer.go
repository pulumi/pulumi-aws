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

// Provides a resource for managing a VPC (Virtual Private Cloud) Route Server Peer.
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
//			_, err := vpc.NewRouteServerPeer(ctx, "test", &vpc.RouteServerPeerArgs{
//				RouteServerEndpointId: pulumi.Any(example.RouteServerEndpointId),
//				PeerAddress:           pulumi.String("10.0.1.250"),
//				BgpOptions: &vpc.RouteServerPeerBgpOptionsArgs{
//					PeerAsn: pulumi.Int(65200),
//				},
//				Tags: pulumi.StringMap{
//					"Name": pulumi.String("Appliance 1"),
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
// ### Complete Configuration
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/vpc"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			test, err := vpc.NewRouteServer(ctx, "test", &vpc.RouteServerArgs{
//				AmazonSideAsn: pulumi.Int(4294967294),
//				Tags: pulumi.StringMap{
//					"Name": pulumi.String("Test"),
//				},
//			})
//			if err != nil {
//				return err
//			}
//			testVpcRouteServerAssociation, err := aws.NewVpcRouteServerAssociation(ctx, "test", &aws.VpcRouteServerAssociationArgs{
//				RouteServerId: test.RouteServerId,
//				VpcId:         testAwsVpc.Id,
//			})
//			if err != nil {
//				return err
//			}
//			testRouteServerEndpoint, err := vpc.NewRouteServerEndpoint(ctx, "test", &vpc.RouteServerEndpointArgs{
//				RouteServerId: test.RouteServerId,
//				SubnetId:      pulumi.Any(testAwsSubnet.Id),
//				Tags: pulumi.StringMap{
//					"Name": pulumi.String("Test Endpoint"),
//				},
//			}, pulumi.DependsOn([]pulumi.Resource{
//				testVpcRouteServerAssociation,
//			}))
//			if err != nil {
//				return err
//			}
//			_, err = vpc.NewRouteServerPropagation(ctx, "test", &vpc.RouteServerPropagationArgs{
//				RouteServerId: test.RouteServerId,
//				RouteTableId:  pulumi.Any(testAwsRouteTable.Id),
//			}, pulumi.DependsOn([]pulumi.Resource{
//				testVpcRouteServerAssociation,
//			}))
//			if err != nil {
//				return err
//			}
//			_, err = vpc.NewRouteServerPeer(ctx, "test", &vpc.RouteServerPeerArgs{
//				RouteServerEndpointId: testRouteServerEndpoint.RouteServerEndpointId,
//				PeerAddress:           pulumi.String("10.0.1.250"),
//				BgpOptions: &vpc.RouteServerPeerBgpOptionsArgs{
//					PeerAsn:               pulumi.Int(65000),
//					PeerLivenessDetection: pulumi.String("bgp-keepalive"),
//				},
//				Tags: pulumi.StringMap{
//					"Name": pulumi.String("Test Appliance"),
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
// Using `pulumi import`, import VPC (Virtual Private Cloud) Route Server using the `route_server_peer_id`. For example:
//
// ```sh
// $ pulumi import aws:vpc/routeServerPeer:RouteServerPeer example rsp-12345678
// ```
type RouteServerPeer struct {
	pulumi.CustomResourceState

	// The ARN of the route server peer.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// The BGP options for the peer, including ASN (Autonomous System Number) and BFD (Bidrectional Forwarding Detection) settings. Configuration block with BGP Options configuration Detailed below
	BgpOptions RouteServerPeerBgpOptionsPtrOutput `pulumi:"bgpOptions"`
	// The IP address of the Elastic network interface for the route server endpoint.
	EndpointEniAddress pulumi.StringOutput `pulumi:"endpointEniAddress"`
	// The ID of the Elastic network interface for the route server endpoint.
	EndpointEniId pulumi.StringOutput `pulumi:"endpointEniId"`
	// The IPv4 address of the peer device.
	PeerAddress pulumi.StringOutput `pulumi:"peerAddress"`
	// The ID of the route server endpoint for which to create a peer.
	RouteServerEndpointId pulumi.StringOutput `pulumi:"routeServerEndpointId"`
	// The ID of the route server associated with this peer.
	RouteServerId pulumi.StringOutput `pulumi:"routeServerId"`
	// The unique identifier of the route server peer.
	RouteServerPeerId pulumi.StringOutput `pulumi:"routeServerPeerId"`
	// The ID of the subnet containing the route server peer.
	SubnetId pulumi.StringOutput    `pulumi:"subnetId"`
	Tags     pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll  pulumi.StringMapOutput           `pulumi:"tagsAll"`
	Timeouts RouteServerPeerTimeoutsPtrOutput `pulumi:"timeouts"`
	// The ID of the VPC containing the route server peer.
	VpcId pulumi.StringOutput `pulumi:"vpcId"`
}

// NewRouteServerPeer registers a new resource with the given unique name, arguments, and options.
func NewRouteServerPeer(ctx *pulumi.Context,
	name string, args *RouteServerPeerArgs, opts ...pulumi.ResourceOption) (*RouteServerPeer, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.PeerAddress == nil {
		return nil, errors.New("invalid value for required argument 'PeerAddress'")
	}
	if args.RouteServerEndpointId == nil {
		return nil, errors.New("invalid value for required argument 'RouteServerEndpointId'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource RouteServerPeer
	err := ctx.RegisterResource("aws:vpc/routeServerPeer:RouteServerPeer", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetRouteServerPeer gets an existing RouteServerPeer resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetRouteServerPeer(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *RouteServerPeerState, opts ...pulumi.ResourceOption) (*RouteServerPeer, error) {
	var resource RouteServerPeer
	err := ctx.ReadResource("aws:vpc/routeServerPeer:RouteServerPeer", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering RouteServerPeer resources.
type routeServerPeerState struct {
	// The ARN of the route server peer.
	Arn *string `pulumi:"arn"`
	// The BGP options for the peer, including ASN (Autonomous System Number) and BFD (Bidrectional Forwarding Detection) settings. Configuration block with BGP Options configuration Detailed below
	BgpOptions *RouteServerPeerBgpOptions `pulumi:"bgpOptions"`
	// The IP address of the Elastic network interface for the route server endpoint.
	EndpointEniAddress *string `pulumi:"endpointEniAddress"`
	// The ID of the Elastic network interface for the route server endpoint.
	EndpointEniId *string `pulumi:"endpointEniId"`
	// The IPv4 address of the peer device.
	PeerAddress *string `pulumi:"peerAddress"`
	// The ID of the route server endpoint for which to create a peer.
	RouteServerEndpointId *string `pulumi:"routeServerEndpointId"`
	// The ID of the route server associated with this peer.
	RouteServerId *string `pulumi:"routeServerId"`
	// The unique identifier of the route server peer.
	RouteServerPeerId *string `pulumi:"routeServerPeerId"`
	// The ID of the subnet containing the route server peer.
	SubnetId *string           `pulumi:"subnetId"`
	Tags     map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll  map[string]string        `pulumi:"tagsAll"`
	Timeouts *RouteServerPeerTimeouts `pulumi:"timeouts"`
	// The ID of the VPC containing the route server peer.
	VpcId *string `pulumi:"vpcId"`
}

type RouteServerPeerState struct {
	// The ARN of the route server peer.
	Arn pulumi.StringPtrInput
	// The BGP options for the peer, including ASN (Autonomous System Number) and BFD (Bidrectional Forwarding Detection) settings. Configuration block with BGP Options configuration Detailed below
	BgpOptions RouteServerPeerBgpOptionsPtrInput
	// The IP address of the Elastic network interface for the route server endpoint.
	EndpointEniAddress pulumi.StringPtrInput
	// The ID of the Elastic network interface for the route server endpoint.
	EndpointEniId pulumi.StringPtrInput
	// The IPv4 address of the peer device.
	PeerAddress pulumi.StringPtrInput
	// The ID of the route server endpoint for which to create a peer.
	RouteServerEndpointId pulumi.StringPtrInput
	// The ID of the route server associated with this peer.
	RouteServerId pulumi.StringPtrInput
	// The unique identifier of the route server peer.
	RouteServerPeerId pulumi.StringPtrInput
	// The ID of the subnet containing the route server peer.
	SubnetId pulumi.StringPtrInput
	Tags     pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll  pulumi.StringMapInput
	Timeouts RouteServerPeerTimeoutsPtrInput
	// The ID of the VPC containing the route server peer.
	VpcId pulumi.StringPtrInput
}

func (RouteServerPeerState) ElementType() reflect.Type {
	return reflect.TypeOf((*routeServerPeerState)(nil)).Elem()
}

type routeServerPeerArgs struct {
	// The BGP options for the peer, including ASN (Autonomous System Number) and BFD (Bidrectional Forwarding Detection) settings. Configuration block with BGP Options configuration Detailed below
	BgpOptions *RouteServerPeerBgpOptions `pulumi:"bgpOptions"`
	// The IPv4 address of the peer device.
	PeerAddress string `pulumi:"peerAddress"`
	// The ID of the route server endpoint for which to create a peer.
	RouteServerEndpointId string                   `pulumi:"routeServerEndpointId"`
	Tags                  map[string]string        `pulumi:"tags"`
	Timeouts              *RouteServerPeerTimeouts `pulumi:"timeouts"`
}

// The set of arguments for constructing a RouteServerPeer resource.
type RouteServerPeerArgs struct {
	// The BGP options for the peer, including ASN (Autonomous System Number) and BFD (Bidrectional Forwarding Detection) settings. Configuration block with BGP Options configuration Detailed below
	BgpOptions RouteServerPeerBgpOptionsPtrInput
	// The IPv4 address of the peer device.
	PeerAddress pulumi.StringInput
	// The ID of the route server endpoint for which to create a peer.
	RouteServerEndpointId pulumi.StringInput
	Tags                  pulumi.StringMapInput
	Timeouts              RouteServerPeerTimeoutsPtrInput
}

func (RouteServerPeerArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*routeServerPeerArgs)(nil)).Elem()
}

type RouteServerPeerInput interface {
	pulumi.Input

	ToRouteServerPeerOutput() RouteServerPeerOutput
	ToRouteServerPeerOutputWithContext(ctx context.Context) RouteServerPeerOutput
}

func (*RouteServerPeer) ElementType() reflect.Type {
	return reflect.TypeOf((**RouteServerPeer)(nil)).Elem()
}

func (i *RouteServerPeer) ToRouteServerPeerOutput() RouteServerPeerOutput {
	return i.ToRouteServerPeerOutputWithContext(context.Background())
}

func (i *RouteServerPeer) ToRouteServerPeerOutputWithContext(ctx context.Context) RouteServerPeerOutput {
	return pulumi.ToOutputWithContext(ctx, i).(RouteServerPeerOutput)
}

// RouteServerPeerArrayInput is an input type that accepts RouteServerPeerArray and RouteServerPeerArrayOutput values.
// You can construct a concrete instance of `RouteServerPeerArrayInput` via:
//
//	RouteServerPeerArray{ RouteServerPeerArgs{...} }
type RouteServerPeerArrayInput interface {
	pulumi.Input

	ToRouteServerPeerArrayOutput() RouteServerPeerArrayOutput
	ToRouteServerPeerArrayOutputWithContext(context.Context) RouteServerPeerArrayOutput
}

type RouteServerPeerArray []RouteServerPeerInput

func (RouteServerPeerArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*RouteServerPeer)(nil)).Elem()
}

func (i RouteServerPeerArray) ToRouteServerPeerArrayOutput() RouteServerPeerArrayOutput {
	return i.ToRouteServerPeerArrayOutputWithContext(context.Background())
}

func (i RouteServerPeerArray) ToRouteServerPeerArrayOutputWithContext(ctx context.Context) RouteServerPeerArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(RouteServerPeerArrayOutput)
}

// RouteServerPeerMapInput is an input type that accepts RouteServerPeerMap and RouteServerPeerMapOutput values.
// You can construct a concrete instance of `RouteServerPeerMapInput` via:
//
//	RouteServerPeerMap{ "key": RouteServerPeerArgs{...} }
type RouteServerPeerMapInput interface {
	pulumi.Input

	ToRouteServerPeerMapOutput() RouteServerPeerMapOutput
	ToRouteServerPeerMapOutputWithContext(context.Context) RouteServerPeerMapOutput
}

type RouteServerPeerMap map[string]RouteServerPeerInput

func (RouteServerPeerMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*RouteServerPeer)(nil)).Elem()
}

func (i RouteServerPeerMap) ToRouteServerPeerMapOutput() RouteServerPeerMapOutput {
	return i.ToRouteServerPeerMapOutputWithContext(context.Background())
}

func (i RouteServerPeerMap) ToRouteServerPeerMapOutputWithContext(ctx context.Context) RouteServerPeerMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(RouteServerPeerMapOutput)
}

type RouteServerPeerOutput struct{ *pulumi.OutputState }

func (RouteServerPeerOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**RouteServerPeer)(nil)).Elem()
}

func (o RouteServerPeerOutput) ToRouteServerPeerOutput() RouteServerPeerOutput {
	return o
}

func (o RouteServerPeerOutput) ToRouteServerPeerOutputWithContext(ctx context.Context) RouteServerPeerOutput {
	return o
}

// The ARN of the route server peer.
func (o RouteServerPeerOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *RouteServerPeer) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// The BGP options for the peer, including ASN (Autonomous System Number) and BFD (Bidrectional Forwarding Detection) settings. Configuration block with BGP Options configuration Detailed below
func (o RouteServerPeerOutput) BgpOptions() RouteServerPeerBgpOptionsPtrOutput {
	return o.ApplyT(func(v *RouteServerPeer) RouteServerPeerBgpOptionsPtrOutput { return v.BgpOptions }).(RouteServerPeerBgpOptionsPtrOutput)
}

// The IP address of the Elastic network interface for the route server endpoint.
func (o RouteServerPeerOutput) EndpointEniAddress() pulumi.StringOutput {
	return o.ApplyT(func(v *RouteServerPeer) pulumi.StringOutput { return v.EndpointEniAddress }).(pulumi.StringOutput)
}

// The ID of the Elastic network interface for the route server endpoint.
func (o RouteServerPeerOutput) EndpointEniId() pulumi.StringOutput {
	return o.ApplyT(func(v *RouteServerPeer) pulumi.StringOutput { return v.EndpointEniId }).(pulumi.StringOutput)
}

// The IPv4 address of the peer device.
func (o RouteServerPeerOutput) PeerAddress() pulumi.StringOutput {
	return o.ApplyT(func(v *RouteServerPeer) pulumi.StringOutput { return v.PeerAddress }).(pulumi.StringOutput)
}

// The ID of the route server endpoint for which to create a peer.
func (o RouteServerPeerOutput) RouteServerEndpointId() pulumi.StringOutput {
	return o.ApplyT(func(v *RouteServerPeer) pulumi.StringOutput { return v.RouteServerEndpointId }).(pulumi.StringOutput)
}

// The ID of the route server associated with this peer.
func (o RouteServerPeerOutput) RouteServerId() pulumi.StringOutput {
	return o.ApplyT(func(v *RouteServerPeer) pulumi.StringOutput { return v.RouteServerId }).(pulumi.StringOutput)
}

// The unique identifier of the route server peer.
func (o RouteServerPeerOutput) RouteServerPeerId() pulumi.StringOutput {
	return o.ApplyT(func(v *RouteServerPeer) pulumi.StringOutput { return v.RouteServerPeerId }).(pulumi.StringOutput)
}

// The ID of the subnet containing the route server peer.
func (o RouteServerPeerOutput) SubnetId() pulumi.StringOutput {
	return o.ApplyT(func(v *RouteServerPeer) pulumi.StringOutput { return v.SubnetId }).(pulumi.StringOutput)
}

func (o RouteServerPeerOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *RouteServerPeer) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o RouteServerPeerOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *RouteServerPeer) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

func (o RouteServerPeerOutput) Timeouts() RouteServerPeerTimeoutsPtrOutput {
	return o.ApplyT(func(v *RouteServerPeer) RouteServerPeerTimeoutsPtrOutput { return v.Timeouts }).(RouteServerPeerTimeoutsPtrOutput)
}

// The ID of the VPC containing the route server peer.
func (o RouteServerPeerOutput) VpcId() pulumi.StringOutput {
	return o.ApplyT(func(v *RouteServerPeer) pulumi.StringOutput { return v.VpcId }).(pulumi.StringOutput)
}

type RouteServerPeerArrayOutput struct{ *pulumi.OutputState }

func (RouteServerPeerArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*RouteServerPeer)(nil)).Elem()
}

func (o RouteServerPeerArrayOutput) ToRouteServerPeerArrayOutput() RouteServerPeerArrayOutput {
	return o
}

func (o RouteServerPeerArrayOutput) ToRouteServerPeerArrayOutputWithContext(ctx context.Context) RouteServerPeerArrayOutput {
	return o
}

func (o RouteServerPeerArrayOutput) Index(i pulumi.IntInput) RouteServerPeerOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *RouteServerPeer {
		return vs[0].([]*RouteServerPeer)[vs[1].(int)]
	}).(RouteServerPeerOutput)
}

type RouteServerPeerMapOutput struct{ *pulumi.OutputState }

func (RouteServerPeerMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*RouteServerPeer)(nil)).Elem()
}

func (o RouteServerPeerMapOutput) ToRouteServerPeerMapOutput() RouteServerPeerMapOutput {
	return o
}

func (o RouteServerPeerMapOutput) ToRouteServerPeerMapOutputWithContext(ctx context.Context) RouteServerPeerMapOutput {
	return o
}

func (o RouteServerPeerMapOutput) MapIndex(k pulumi.StringInput) RouteServerPeerOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *RouteServerPeer {
		return vs[0].(map[string]*RouteServerPeer)[vs[1].(string)]
	}).(RouteServerPeerOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*RouteServerPeerInput)(nil)).Elem(), &RouteServerPeer{})
	pulumi.RegisterInputType(reflect.TypeOf((*RouteServerPeerArrayInput)(nil)).Elem(), RouteServerPeerArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*RouteServerPeerMapInput)(nil)).Elem(), RouteServerPeerMap{})
	pulumi.RegisterOutputType(RouteServerPeerOutput{})
	pulumi.RegisterOutputType(RouteServerPeerArrayOutput{})
	pulumi.RegisterOutputType(RouteServerPeerMapOutput{})
}
