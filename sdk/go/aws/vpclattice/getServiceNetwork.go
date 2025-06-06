// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package vpclattice

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Data source for managing an AWS VPC Lattice Service Network.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/vpclattice"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := vpclattice.LookupServiceNetwork(ctx, &vpclattice.LookupServiceNetworkArgs{
//				ServiceNetworkIdentifier: "snsa-01112223334445556",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupServiceNetwork(ctx *pulumi.Context, args *LookupServiceNetworkArgs, opts ...pulumi.InvokeOption) (*LookupServiceNetworkResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupServiceNetworkResult
	err := ctx.Invoke("aws:vpclattice/getServiceNetwork:getServiceNetwork", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getServiceNetwork.
type LookupServiceNetworkArgs struct {
	// Identifier of the service network.
	ServiceNetworkIdentifier string            `pulumi:"serviceNetworkIdentifier"`
	Tags                     map[string]string `pulumi:"tags"`
}

// A collection of values returned by getServiceNetwork.
type LookupServiceNetworkResult struct {
	// ARN of the Service Network.
	Arn string `pulumi:"arn"`
	// Authentication type for the service network. Either `NONE` or `AWS_IAM`.
	AuthType string `pulumi:"authType"`
	// Date and time the service network was created.
	CreatedAt string `pulumi:"createdAt"`
	// The provider-assigned unique ID for this managed resource.
	Id string `pulumi:"id"`
	// Date and time the service network was last updated.
	LastUpdatedAt string `pulumi:"lastUpdatedAt"`
	// Name of the service network.
	Name string `pulumi:"name"`
	// Number of services associated with this service network.
	NumberOfAssociatedServices int `pulumi:"numberOfAssociatedServices"`
	// Number of VPCs associated with this service network.
	NumberOfAssociatedVpcs   int               `pulumi:"numberOfAssociatedVpcs"`
	ServiceNetworkIdentifier string            `pulumi:"serviceNetworkIdentifier"`
	Tags                     map[string]string `pulumi:"tags"`
}

func LookupServiceNetworkOutput(ctx *pulumi.Context, args LookupServiceNetworkOutputArgs, opts ...pulumi.InvokeOption) LookupServiceNetworkResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupServiceNetworkResultOutput, error) {
			args := v.(LookupServiceNetworkArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:vpclattice/getServiceNetwork:getServiceNetwork", args, LookupServiceNetworkResultOutput{}, options).(LookupServiceNetworkResultOutput), nil
		}).(LookupServiceNetworkResultOutput)
}

// A collection of arguments for invoking getServiceNetwork.
type LookupServiceNetworkOutputArgs struct {
	// Identifier of the service network.
	ServiceNetworkIdentifier pulumi.StringInput    `pulumi:"serviceNetworkIdentifier"`
	Tags                     pulumi.StringMapInput `pulumi:"tags"`
}

func (LookupServiceNetworkOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupServiceNetworkArgs)(nil)).Elem()
}

// A collection of values returned by getServiceNetwork.
type LookupServiceNetworkResultOutput struct{ *pulumi.OutputState }

func (LookupServiceNetworkResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupServiceNetworkResult)(nil)).Elem()
}

func (o LookupServiceNetworkResultOutput) ToLookupServiceNetworkResultOutput() LookupServiceNetworkResultOutput {
	return o
}

func (o LookupServiceNetworkResultOutput) ToLookupServiceNetworkResultOutputWithContext(ctx context.Context) LookupServiceNetworkResultOutput {
	return o
}

// ARN of the Service Network.
func (o LookupServiceNetworkResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupServiceNetworkResult) string { return v.Arn }).(pulumi.StringOutput)
}

// Authentication type for the service network. Either `NONE` or `AWS_IAM`.
func (o LookupServiceNetworkResultOutput) AuthType() pulumi.StringOutput {
	return o.ApplyT(func(v LookupServiceNetworkResult) string { return v.AuthType }).(pulumi.StringOutput)
}

// Date and time the service network was created.
func (o LookupServiceNetworkResultOutput) CreatedAt() pulumi.StringOutput {
	return o.ApplyT(func(v LookupServiceNetworkResult) string { return v.CreatedAt }).(pulumi.StringOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o LookupServiceNetworkResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupServiceNetworkResult) string { return v.Id }).(pulumi.StringOutput)
}

// Date and time the service network was last updated.
func (o LookupServiceNetworkResultOutput) LastUpdatedAt() pulumi.StringOutput {
	return o.ApplyT(func(v LookupServiceNetworkResult) string { return v.LastUpdatedAt }).(pulumi.StringOutput)
}

// Name of the service network.
func (o LookupServiceNetworkResultOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v LookupServiceNetworkResult) string { return v.Name }).(pulumi.StringOutput)
}

// Number of services associated with this service network.
func (o LookupServiceNetworkResultOutput) NumberOfAssociatedServices() pulumi.IntOutput {
	return o.ApplyT(func(v LookupServiceNetworkResult) int { return v.NumberOfAssociatedServices }).(pulumi.IntOutput)
}

// Number of VPCs associated with this service network.
func (o LookupServiceNetworkResultOutput) NumberOfAssociatedVpcs() pulumi.IntOutput {
	return o.ApplyT(func(v LookupServiceNetworkResult) int { return v.NumberOfAssociatedVpcs }).(pulumi.IntOutput)
}

func (o LookupServiceNetworkResultOutput) ServiceNetworkIdentifier() pulumi.StringOutput {
	return o.ApplyT(func(v LookupServiceNetworkResult) string { return v.ServiceNetworkIdentifier }).(pulumi.StringOutput)
}

func (o LookupServiceNetworkResultOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v LookupServiceNetworkResult) map[string]string { return v.Tags }).(pulumi.StringMapOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupServiceNetworkResultOutput{})
}
