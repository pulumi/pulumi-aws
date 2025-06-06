// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package apigateway

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides details about multiple API Gateway Authorizers.
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
//			_, err := apigateway.GetAuthorizers(ctx, &apigateway.GetAuthorizersArgs{
//				RestApiId: exampleAwsApiGatewayRestApi.Id,
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func GetAuthorizers(ctx *pulumi.Context, args *GetAuthorizersArgs, opts ...pulumi.InvokeOption) (*GetAuthorizersResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv GetAuthorizersResult
	err := ctx.Invoke("aws:apigateway/getAuthorizers:getAuthorizers", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getAuthorizers.
type GetAuthorizersArgs struct {
	// ID of the associated REST API.
	RestApiId string `pulumi:"restApiId"`
}

// A collection of values returned by getAuthorizers.
type GetAuthorizersResult struct {
	// The provider-assigned unique ID for this managed resource.
	Id string `pulumi:"id"`
	// List of Authorizer identifiers.
	Ids       []string `pulumi:"ids"`
	RestApiId string   `pulumi:"restApiId"`
}

func GetAuthorizersOutput(ctx *pulumi.Context, args GetAuthorizersOutputArgs, opts ...pulumi.InvokeOption) GetAuthorizersResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (GetAuthorizersResultOutput, error) {
			args := v.(GetAuthorizersArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:apigateway/getAuthorizers:getAuthorizers", args, GetAuthorizersResultOutput{}, options).(GetAuthorizersResultOutput), nil
		}).(GetAuthorizersResultOutput)
}

// A collection of arguments for invoking getAuthorizers.
type GetAuthorizersOutputArgs struct {
	// ID of the associated REST API.
	RestApiId pulumi.StringInput `pulumi:"restApiId"`
}

func (GetAuthorizersOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*GetAuthorizersArgs)(nil)).Elem()
}

// A collection of values returned by getAuthorizers.
type GetAuthorizersResultOutput struct{ *pulumi.OutputState }

func (GetAuthorizersResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*GetAuthorizersResult)(nil)).Elem()
}

func (o GetAuthorizersResultOutput) ToGetAuthorizersResultOutput() GetAuthorizersResultOutput {
	return o
}

func (o GetAuthorizersResultOutput) ToGetAuthorizersResultOutputWithContext(ctx context.Context) GetAuthorizersResultOutput {
	return o
}

// The provider-assigned unique ID for this managed resource.
func (o GetAuthorizersResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v GetAuthorizersResult) string { return v.Id }).(pulumi.StringOutput)
}

// List of Authorizer identifiers.
func (o GetAuthorizersResultOutput) Ids() pulumi.StringArrayOutput {
	return o.ApplyT(func(v GetAuthorizersResult) []string { return v.Ids }).(pulumi.StringArrayOutput)
}

func (o GetAuthorizersResultOutput) RestApiId() pulumi.StringOutput {
	return o.ApplyT(func(v GetAuthorizersResult) string { return v.RestApiId }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(GetAuthorizersResultOutput{})
}
