// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package apigateway

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Data source for managing AWS API Gateway API Keys.
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
//			_, err := apigateway.GetApiKeys(ctx, &apigateway.GetApiKeysArgs{}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func GetApiKeys(ctx *pulumi.Context, args *GetApiKeysArgs, opts ...pulumi.InvokeOption) (*GetApiKeysResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv GetApiKeysResult
	err := ctx.Invoke("aws:apigateway/getApiKeys:getApiKeys", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getApiKeys.
type GetApiKeysArgs struct {
	// Amazon Web Services Marketplace customer identifier, when integrating with the Amazon Web Services SaaS Marketplace.
	CustomerId *string `pulumi:"customerId"`
	// Set this value to `true` if you wish the result contains the key value. Defaults to `false`.
	IncludeValues *bool `pulumi:"includeValues"`
}

// A collection of values returned by getApiKeys.
type GetApiKeysResult struct {
	// Amazon Web Services Marketplace customer identifier, when integrating with the Amazon Web Services SaaS Marketplace.
	CustomerId *string `pulumi:"customerId"`
	// ID of the API Key.
	Id            string `pulumi:"id"`
	IncludeValues *bool  `pulumi:"includeValues"`
	// List of objects containing API Key information. See below.
	Items []GetApiKeysItem `pulumi:"items"`
}

func GetApiKeysOutput(ctx *pulumi.Context, args GetApiKeysOutputArgs, opts ...pulumi.InvokeOption) GetApiKeysResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (GetApiKeysResultOutput, error) {
			args := v.(GetApiKeysArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:apigateway/getApiKeys:getApiKeys", args, GetApiKeysResultOutput{}, options).(GetApiKeysResultOutput), nil
		}).(GetApiKeysResultOutput)
}

// A collection of arguments for invoking getApiKeys.
type GetApiKeysOutputArgs struct {
	// Amazon Web Services Marketplace customer identifier, when integrating with the Amazon Web Services SaaS Marketplace.
	CustomerId pulumi.StringPtrInput `pulumi:"customerId"`
	// Set this value to `true` if you wish the result contains the key value. Defaults to `false`.
	IncludeValues pulumi.BoolPtrInput `pulumi:"includeValues"`
}

func (GetApiKeysOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*GetApiKeysArgs)(nil)).Elem()
}

// A collection of values returned by getApiKeys.
type GetApiKeysResultOutput struct{ *pulumi.OutputState }

func (GetApiKeysResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*GetApiKeysResult)(nil)).Elem()
}

func (o GetApiKeysResultOutput) ToGetApiKeysResultOutput() GetApiKeysResultOutput {
	return o
}

func (o GetApiKeysResultOutput) ToGetApiKeysResultOutputWithContext(ctx context.Context) GetApiKeysResultOutput {
	return o
}

// Amazon Web Services Marketplace customer identifier, when integrating with the Amazon Web Services SaaS Marketplace.
func (o GetApiKeysResultOutput) CustomerId() pulumi.StringPtrOutput {
	return o.ApplyT(func(v GetApiKeysResult) *string { return v.CustomerId }).(pulumi.StringPtrOutput)
}

// ID of the API Key.
func (o GetApiKeysResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v GetApiKeysResult) string { return v.Id }).(pulumi.StringOutput)
}

func (o GetApiKeysResultOutput) IncludeValues() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v GetApiKeysResult) *bool { return v.IncludeValues }).(pulumi.BoolPtrOutput)
}

// List of objects containing API Key information. See below.
func (o GetApiKeysResultOutput) Items() GetApiKeysItemArrayOutput {
	return o.ApplyT(func(v GetApiKeysResult) []GetApiKeysItem { return v.Items }).(GetApiKeysItemArrayOutput)
}

func init() {
	pulumi.RegisterOutputType(GetApiKeysResultOutput{})
}
