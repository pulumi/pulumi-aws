// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package directconnect

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Retrieve information about the AWS Direct Connect locations in the current AWS Region.
// These are the locations that can be specified when configuring `directconnect.Connection` or `directconnect.LinkAggregationGroup` resources.
//
// > **Note:** This data source is different from the `directconnect.getLocation` data source which retrieves information about a specific AWS Direct Connect location in the current AWS Region.
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
//			_, err := directconnect.GetLocations(ctx, map[string]interface{}{}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func GetLocations(ctx *pulumi.Context, opts ...pulumi.InvokeOption) (*GetLocationsResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv GetLocationsResult
	err := ctx.Invoke("aws:directconnect/getLocations:getLocations", nil, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of values returned by getLocations.
type GetLocationsResult struct {
	// The provider-assigned unique ID for this managed resource.
	Id string `pulumi:"id"`
	// Code for the locations.
	LocationCodes []string `pulumi:"locationCodes"`
}

func GetLocationsOutput(ctx *pulumi.Context, opts ...pulumi.InvokeOption) GetLocationsResultOutput {
	return pulumi.ToOutput(0).ApplyT(func(int) (GetLocationsResultOutput, error) {
		options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
		return ctx.InvokeOutput("aws:directconnect/getLocations:getLocations", nil, GetLocationsResultOutput{}, options).(GetLocationsResultOutput), nil
	}).(GetLocationsResultOutput)
}

// A collection of values returned by getLocations.
type GetLocationsResultOutput struct{ *pulumi.OutputState }

func (GetLocationsResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*GetLocationsResult)(nil)).Elem()
}

func (o GetLocationsResultOutput) ToGetLocationsResultOutput() GetLocationsResultOutput {
	return o
}

func (o GetLocationsResultOutput) ToGetLocationsResultOutputWithContext(ctx context.Context) GetLocationsResultOutput {
	return o
}

// The provider-assigned unique ID for this managed resource.
func (o GetLocationsResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v GetLocationsResult) string { return v.Id }).(pulumi.StringOutput)
}

// Code for the locations.
func (o GetLocationsResultOutput) LocationCodes() pulumi.StringArrayOutput {
	return o.ApplyT(func(v GetLocationsResult) []string { return v.LocationCodes }).(pulumi.StringArrayOutput)
}

func init() {
	pulumi.RegisterOutputType(GetLocationsResultOutput{})
}
