// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package directconnect

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Data source for retrieving Router Configuration instructions for a given AWS Direct Connect Virtual Interface and Router Type.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/directconnect"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := directconnect.GetRouterConfiguration(ctx, &directconnect.GetRouterConfigurationArgs{
//				VirtualInterfaceId:   "dxvif-abcde123",
//				RouterTypeIdentifier: "CiscoSystemsInc-2900SeriesRouters-IOS124",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func GetRouterConfiguration(ctx *pulumi.Context, args *GetRouterConfigurationArgs, opts ...pulumi.InvokeOption) (*GetRouterConfigurationResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv GetRouterConfigurationResult
	err := ctx.Invoke("aws:directconnect/getRouterConfiguration:getRouterConfiguration", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getRouterConfiguration.
type GetRouterConfigurationArgs struct {
	// ID of the Router Type. For example: `CiscoSystemsInc-2900SeriesRouters-IOS124`
	//
	// There is currently no AWS API to retrieve the full list of `routerTypeIdentifier` values. Here is a list of known `RouterType` objects that can be used:
	RouterTypeIdentifier string `pulumi:"routerTypeIdentifier"`
	// ID of the Direct Connect Virtual Interface
	VirtualInterfaceId string `pulumi:"virtualInterfaceId"`
}

// A collection of values returned by getRouterConfiguration.
type GetRouterConfigurationResult struct {
	// Instructions for configuring your router
	CustomerRouterConfig string `pulumi:"customerRouterConfig"`
	// The provider-assigned unique ID for this managed resource.
	Id string `pulumi:"id"`
	// Router type identifier
	RouterTypeIdentifier string `pulumi:"routerTypeIdentifier"`
	// Block of the router type details
	Routers              []GetRouterConfigurationRouter `pulumi:"routers"`
	VirtualInterfaceId   string                         `pulumi:"virtualInterfaceId"`
	VirtualInterfaceName string                         `pulumi:"virtualInterfaceName"`
}

func GetRouterConfigurationOutput(ctx *pulumi.Context, args GetRouterConfigurationOutputArgs, opts ...pulumi.InvokeOption) GetRouterConfigurationResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (GetRouterConfigurationResultOutput, error) {
			args := v.(GetRouterConfigurationArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:directconnect/getRouterConfiguration:getRouterConfiguration", args, GetRouterConfigurationResultOutput{}, options).(GetRouterConfigurationResultOutput), nil
		}).(GetRouterConfigurationResultOutput)
}

// A collection of arguments for invoking getRouterConfiguration.
type GetRouterConfigurationOutputArgs struct {
	// ID of the Router Type. For example: `CiscoSystemsInc-2900SeriesRouters-IOS124`
	//
	// There is currently no AWS API to retrieve the full list of `routerTypeIdentifier` values. Here is a list of known `RouterType` objects that can be used:
	RouterTypeIdentifier pulumi.StringInput `pulumi:"routerTypeIdentifier"`
	// ID of the Direct Connect Virtual Interface
	VirtualInterfaceId pulumi.StringInput `pulumi:"virtualInterfaceId"`
}

func (GetRouterConfigurationOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*GetRouterConfigurationArgs)(nil)).Elem()
}

// A collection of values returned by getRouterConfiguration.
type GetRouterConfigurationResultOutput struct{ *pulumi.OutputState }

func (GetRouterConfigurationResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*GetRouterConfigurationResult)(nil)).Elem()
}

func (o GetRouterConfigurationResultOutput) ToGetRouterConfigurationResultOutput() GetRouterConfigurationResultOutput {
	return o
}

func (o GetRouterConfigurationResultOutput) ToGetRouterConfigurationResultOutputWithContext(ctx context.Context) GetRouterConfigurationResultOutput {
	return o
}

// Instructions for configuring your router
func (o GetRouterConfigurationResultOutput) CustomerRouterConfig() pulumi.StringOutput {
	return o.ApplyT(func(v GetRouterConfigurationResult) string { return v.CustomerRouterConfig }).(pulumi.StringOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o GetRouterConfigurationResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v GetRouterConfigurationResult) string { return v.Id }).(pulumi.StringOutput)
}

// Router type identifier
func (o GetRouterConfigurationResultOutput) RouterTypeIdentifier() pulumi.StringOutput {
	return o.ApplyT(func(v GetRouterConfigurationResult) string { return v.RouterTypeIdentifier }).(pulumi.StringOutput)
}

// Block of the router type details
func (o GetRouterConfigurationResultOutput) Routers() GetRouterConfigurationRouterArrayOutput {
	return o.ApplyT(func(v GetRouterConfigurationResult) []GetRouterConfigurationRouter { return v.Routers }).(GetRouterConfigurationRouterArrayOutput)
}

func (o GetRouterConfigurationResultOutput) VirtualInterfaceId() pulumi.StringOutput {
	return o.ApplyT(func(v GetRouterConfigurationResult) string { return v.VirtualInterfaceId }).(pulumi.StringOutput)
}

func (o GetRouterConfigurationResultOutput) VirtualInterfaceName() pulumi.StringOutput {
	return o.ApplyT(func(v GetRouterConfigurationResult) string { return v.VirtualInterfaceName }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(GetRouterConfigurationResultOutput{})
}
