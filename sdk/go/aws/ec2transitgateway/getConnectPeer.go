// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package ec2transitgateway

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Get information on an EC2 Transit Gateway Connect Peer.
//
// ## Example Usage
//
// ### By Filter
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/ec2transitgateway"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := ec2transitgateway.LookupConnectPeer(ctx, &ec2transitgateway.LookupConnectPeerArgs{
//				Filters: []ec2transitgateway.GetConnectPeerFilter{
//					{
//						Name: "transit-gateway-attachment-id",
//						Values: []string{
//							"tgw-attach-12345678",
//						},
//					},
//				},
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// ### By Identifier
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/ec2transitgateway"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := ec2transitgateway.LookupConnectPeer(ctx, &ec2transitgateway.LookupConnectPeerArgs{
//				TransitGatewayConnectPeerId: pulumi.StringRef("tgw-connect-peer-12345678"),
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupConnectPeer(ctx *pulumi.Context, args *LookupConnectPeerArgs, opts ...pulumi.InvokeOption) (*LookupConnectPeerResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupConnectPeerResult
	err := ctx.Invoke("aws:ec2transitgateway/getConnectPeer:getConnectPeer", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getConnectPeer.
type LookupConnectPeerArgs struct {
	// One or more configuration blocks containing name-values filters. Detailed below.
	Filters []GetConnectPeerFilter `pulumi:"filters"`
	// Key-value tags for the EC2 Transit Gateway Connect Peer
	Tags map[string]string `pulumi:"tags"`
	// Identifier of the EC2 Transit Gateway Connect Peer.
	TransitGatewayConnectPeerId *string `pulumi:"transitGatewayConnectPeerId"`
}

// A collection of values returned by getConnectPeer.
type LookupConnectPeerResult struct {
	// EC2 Transit Gateway Connect Peer ARN
	Arn string `pulumi:"arn"`
	// BGP ASN number assigned customer device
	BgpAsn string `pulumi:"bgpAsn"`
	// The IP address assigned to customer device, which is used as BGP IP address.
	BgpPeerAddress string `pulumi:"bgpPeerAddress"`
	// The IP addresses assigned to Transit Gateway, which are used as BGP IP addresses.
	BgpTransitGatewayAddresses []string               `pulumi:"bgpTransitGatewayAddresses"`
	Filters                    []GetConnectPeerFilter `pulumi:"filters"`
	// The provider-assigned unique ID for this managed resource.
	Id string `pulumi:"id"`
	// CIDR blocks that will be used for addressing within the tunnel.
	InsideCidrBlocks []string `pulumi:"insideCidrBlocks"`
	// IP addressed assigned to customer device, which is used as tunnel endpoint
	PeerAddress string `pulumi:"peerAddress"`
	// Key-value tags for the EC2 Transit Gateway Connect Peer
	Tags map[string]string `pulumi:"tags"`
	// The IP address assigned to Transit Gateway, which is used as tunnel endpoint.
	TransitGatewayAddress string `pulumi:"transitGatewayAddress"`
	// The Transit Gateway Connect
	TransitGatewayAttachmentId  string `pulumi:"transitGatewayAttachmentId"`
	TransitGatewayConnectPeerId string `pulumi:"transitGatewayConnectPeerId"`
}

func LookupConnectPeerOutput(ctx *pulumi.Context, args LookupConnectPeerOutputArgs, opts ...pulumi.InvokeOption) LookupConnectPeerResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupConnectPeerResultOutput, error) {
			args := v.(LookupConnectPeerArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:ec2transitgateway/getConnectPeer:getConnectPeer", args, LookupConnectPeerResultOutput{}, options).(LookupConnectPeerResultOutput), nil
		}).(LookupConnectPeerResultOutput)
}

// A collection of arguments for invoking getConnectPeer.
type LookupConnectPeerOutputArgs struct {
	// One or more configuration blocks containing name-values filters. Detailed below.
	Filters GetConnectPeerFilterArrayInput `pulumi:"filters"`
	// Key-value tags for the EC2 Transit Gateway Connect Peer
	Tags pulumi.StringMapInput `pulumi:"tags"`
	// Identifier of the EC2 Transit Gateway Connect Peer.
	TransitGatewayConnectPeerId pulumi.StringPtrInput `pulumi:"transitGatewayConnectPeerId"`
}

func (LookupConnectPeerOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupConnectPeerArgs)(nil)).Elem()
}

// A collection of values returned by getConnectPeer.
type LookupConnectPeerResultOutput struct{ *pulumi.OutputState }

func (LookupConnectPeerResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupConnectPeerResult)(nil)).Elem()
}

func (o LookupConnectPeerResultOutput) ToLookupConnectPeerResultOutput() LookupConnectPeerResultOutput {
	return o
}

func (o LookupConnectPeerResultOutput) ToLookupConnectPeerResultOutputWithContext(ctx context.Context) LookupConnectPeerResultOutput {
	return o
}

// EC2 Transit Gateway Connect Peer ARN
func (o LookupConnectPeerResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupConnectPeerResult) string { return v.Arn }).(pulumi.StringOutput)
}

// BGP ASN number assigned customer device
func (o LookupConnectPeerResultOutput) BgpAsn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupConnectPeerResult) string { return v.BgpAsn }).(pulumi.StringOutput)
}

// The IP address assigned to customer device, which is used as BGP IP address.
func (o LookupConnectPeerResultOutput) BgpPeerAddress() pulumi.StringOutput {
	return o.ApplyT(func(v LookupConnectPeerResult) string { return v.BgpPeerAddress }).(pulumi.StringOutput)
}

// The IP addresses assigned to Transit Gateway, which are used as BGP IP addresses.
func (o LookupConnectPeerResultOutput) BgpTransitGatewayAddresses() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupConnectPeerResult) []string { return v.BgpTransitGatewayAddresses }).(pulumi.StringArrayOutput)
}

func (o LookupConnectPeerResultOutput) Filters() GetConnectPeerFilterArrayOutput {
	return o.ApplyT(func(v LookupConnectPeerResult) []GetConnectPeerFilter { return v.Filters }).(GetConnectPeerFilterArrayOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o LookupConnectPeerResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupConnectPeerResult) string { return v.Id }).(pulumi.StringOutput)
}

// CIDR blocks that will be used for addressing within the tunnel.
func (o LookupConnectPeerResultOutput) InsideCidrBlocks() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupConnectPeerResult) []string { return v.InsideCidrBlocks }).(pulumi.StringArrayOutput)
}

// IP addressed assigned to customer device, which is used as tunnel endpoint
func (o LookupConnectPeerResultOutput) PeerAddress() pulumi.StringOutput {
	return o.ApplyT(func(v LookupConnectPeerResult) string { return v.PeerAddress }).(pulumi.StringOutput)
}

// Key-value tags for the EC2 Transit Gateway Connect Peer
func (o LookupConnectPeerResultOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v LookupConnectPeerResult) map[string]string { return v.Tags }).(pulumi.StringMapOutput)
}

// The IP address assigned to Transit Gateway, which is used as tunnel endpoint.
func (o LookupConnectPeerResultOutput) TransitGatewayAddress() pulumi.StringOutput {
	return o.ApplyT(func(v LookupConnectPeerResult) string { return v.TransitGatewayAddress }).(pulumi.StringOutput)
}

// The Transit Gateway Connect
func (o LookupConnectPeerResultOutput) TransitGatewayAttachmentId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupConnectPeerResult) string { return v.TransitGatewayAttachmentId }).(pulumi.StringOutput)
}

func (o LookupConnectPeerResultOutput) TransitGatewayConnectPeerId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupConnectPeerResult) string { return v.TransitGatewayConnectPeerId }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupConnectPeerResultOutput{})
}
