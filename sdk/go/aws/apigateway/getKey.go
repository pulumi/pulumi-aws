// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package apigateway

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Use this data source to get the name and value of a pre-existing API Key, for
// example to supply credentials for a dependency microservice.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/apigateway"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := apigateway.GetKey(ctx, &apigateway.GetKeyArgs{
//				Id: "ru3mpjgse6",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func GetKey(ctx *pulumi.Context, args *GetKeyArgs, opts ...pulumi.InvokeOption) (*GetKeyResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv GetKeyResult
	err := ctx.Invoke("aws:apigateway/getKey:getKey", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getKey.
type GetKeyArgs struct {
	// ID of the API Key to look up.
	Id string `pulumi:"id"`
	// Map of tags for the resource.
	Tags map[string]string `pulumi:"tags"`
}

// A collection of values returned by getKey.
type GetKeyResult struct {
	Arn string `pulumi:"arn"`
	// Date and time when the API Key was created.
	CreatedDate string `pulumi:"createdDate"`
	// Amazon Web Services Marketplace customer identifier, when integrating with the Amazon Web Services SaaS Marketplace.
	CustomerId string `pulumi:"customerId"`
	// Description of the API Key.
	Description string `pulumi:"description"`
	// Whether the API Key is enabled.
	Enabled bool `pulumi:"enabled"`
	// Set to the ID of the API Key.
	Id string `pulumi:"id"`
	// Date and time when the API Key was last updated.
	LastUpdatedDate string `pulumi:"lastUpdatedDate"`
	// Set to the name of the API Key.
	Name string `pulumi:"name"`
	// Map of tags for the resource.
	Tags map[string]string `pulumi:"tags"`
	// Set to the value of the API Key.
	Value string `pulumi:"value"`
}

func GetKeyOutput(ctx *pulumi.Context, args GetKeyOutputArgs, opts ...pulumi.InvokeOption) GetKeyResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (GetKeyResultOutput, error) {
			args := v.(GetKeyArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:apigateway/getKey:getKey", args, GetKeyResultOutput{}, options).(GetKeyResultOutput), nil
		}).(GetKeyResultOutput)
}

// A collection of arguments for invoking getKey.
type GetKeyOutputArgs struct {
	// ID of the API Key to look up.
	Id pulumi.StringInput `pulumi:"id"`
	// Map of tags for the resource.
	Tags pulumi.StringMapInput `pulumi:"tags"`
}

func (GetKeyOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*GetKeyArgs)(nil)).Elem()
}

// A collection of values returned by getKey.
type GetKeyResultOutput struct{ *pulumi.OutputState }

func (GetKeyResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*GetKeyResult)(nil)).Elem()
}

func (o GetKeyResultOutput) ToGetKeyResultOutput() GetKeyResultOutput {
	return o
}

func (o GetKeyResultOutput) ToGetKeyResultOutputWithContext(ctx context.Context) GetKeyResultOutput {
	return o
}

func (o GetKeyResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v GetKeyResult) string { return v.Arn }).(pulumi.StringOutput)
}

// Date and time when the API Key was created.
func (o GetKeyResultOutput) CreatedDate() pulumi.StringOutput {
	return o.ApplyT(func(v GetKeyResult) string { return v.CreatedDate }).(pulumi.StringOutput)
}

// Amazon Web Services Marketplace customer identifier, when integrating with the Amazon Web Services SaaS Marketplace.
func (o GetKeyResultOutput) CustomerId() pulumi.StringOutput {
	return o.ApplyT(func(v GetKeyResult) string { return v.CustomerId }).(pulumi.StringOutput)
}

// Description of the API Key.
func (o GetKeyResultOutput) Description() pulumi.StringOutput {
	return o.ApplyT(func(v GetKeyResult) string { return v.Description }).(pulumi.StringOutput)
}

// Whether the API Key is enabled.
func (o GetKeyResultOutput) Enabled() pulumi.BoolOutput {
	return o.ApplyT(func(v GetKeyResult) bool { return v.Enabled }).(pulumi.BoolOutput)
}

// Set to the ID of the API Key.
func (o GetKeyResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v GetKeyResult) string { return v.Id }).(pulumi.StringOutput)
}

// Date and time when the API Key was last updated.
func (o GetKeyResultOutput) LastUpdatedDate() pulumi.StringOutput {
	return o.ApplyT(func(v GetKeyResult) string { return v.LastUpdatedDate }).(pulumi.StringOutput)
}

// Set to the name of the API Key.
func (o GetKeyResultOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v GetKeyResult) string { return v.Name }).(pulumi.StringOutput)
}

// Map of tags for the resource.
func (o GetKeyResultOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v GetKeyResult) map[string]string { return v.Tags }).(pulumi.StringMapOutput)
}

// Set to the value of the API Key.
func (o GetKeyResultOutput) Value() pulumi.StringOutput {
	return o.ApplyT(func(v GetKeyResult) string { return v.Value }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(GetKeyResultOutput{})
}
