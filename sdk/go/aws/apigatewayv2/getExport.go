// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package apigatewayv2

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Exports a definition of an API in a particular output format and specification.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/apigatewayv2"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := apigatewayv2.GetExport(ctx, &apigatewayv2.GetExportArgs{
//				ApiId:         testAwsApigatewayv2Route.ApiId,
//				Specification: "OAS30",
//				OutputType:    "JSON",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func GetExport(ctx *pulumi.Context, args *GetExportArgs, opts ...pulumi.InvokeOption) (*GetExportResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv GetExportResult
	err := ctx.Invoke("aws:apigatewayv2/getExport:getExport", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getExport.
type GetExportArgs struct {
	// API identifier.
	ApiId string `pulumi:"apiId"`
	// Version of the API Gateway export algorithm. API Gateway uses the latest version by default. Currently, the only supported version is `1.0`.
	ExportVersion *string `pulumi:"exportVersion"`
	// Whether to include API Gateway extensions in the exported API definition. API Gateway extensions are included by default.
	IncludeExtensions *bool `pulumi:"includeExtensions"`
	// Output type of the exported definition file. Valid values are `JSON` and `YAML`.
	OutputType string `pulumi:"outputType"`
	// Version of the API specification to use. `OAS30`, for OpenAPI 3.0, is the only supported value.
	Specification string `pulumi:"specification"`
	// Name of the API stage to export. If you don't specify this property, a representation of the latest API configuration is exported.
	StageName *string `pulumi:"stageName"`
}

// A collection of values returned by getExport.
type GetExportResult struct {
	ApiId string `pulumi:"apiId"`
	// ID of the API.
	Body          string  `pulumi:"body"`
	ExportVersion *string `pulumi:"exportVersion"`
	// The provider-assigned unique ID for this managed resource.
	Id                string  `pulumi:"id"`
	IncludeExtensions *bool   `pulumi:"includeExtensions"`
	OutputType        string  `pulumi:"outputType"`
	Specification     string  `pulumi:"specification"`
	StageName         *string `pulumi:"stageName"`
}

func GetExportOutput(ctx *pulumi.Context, args GetExportOutputArgs, opts ...pulumi.InvokeOption) GetExportResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (GetExportResultOutput, error) {
			args := v.(GetExportArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:apigatewayv2/getExport:getExport", args, GetExportResultOutput{}, options).(GetExportResultOutput), nil
		}).(GetExportResultOutput)
}

// A collection of arguments for invoking getExport.
type GetExportOutputArgs struct {
	// API identifier.
	ApiId pulumi.StringInput `pulumi:"apiId"`
	// Version of the API Gateway export algorithm. API Gateway uses the latest version by default. Currently, the only supported version is `1.0`.
	ExportVersion pulumi.StringPtrInput `pulumi:"exportVersion"`
	// Whether to include API Gateway extensions in the exported API definition. API Gateway extensions are included by default.
	IncludeExtensions pulumi.BoolPtrInput `pulumi:"includeExtensions"`
	// Output type of the exported definition file. Valid values are `JSON` and `YAML`.
	OutputType pulumi.StringInput `pulumi:"outputType"`
	// Version of the API specification to use. `OAS30`, for OpenAPI 3.0, is the only supported value.
	Specification pulumi.StringInput `pulumi:"specification"`
	// Name of the API stage to export. If you don't specify this property, a representation of the latest API configuration is exported.
	StageName pulumi.StringPtrInput `pulumi:"stageName"`
}

func (GetExportOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*GetExportArgs)(nil)).Elem()
}

// A collection of values returned by getExport.
type GetExportResultOutput struct{ *pulumi.OutputState }

func (GetExportResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*GetExportResult)(nil)).Elem()
}

func (o GetExportResultOutput) ToGetExportResultOutput() GetExportResultOutput {
	return o
}

func (o GetExportResultOutput) ToGetExportResultOutputWithContext(ctx context.Context) GetExportResultOutput {
	return o
}

func (o GetExportResultOutput) ApiId() pulumi.StringOutput {
	return o.ApplyT(func(v GetExportResult) string { return v.ApiId }).(pulumi.StringOutput)
}

// ID of the API.
func (o GetExportResultOutput) Body() pulumi.StringOutput {
	return o.ApplyT(func(v GetExportResult) string { return v.Body }).(pulumi.StringOutput)
}

func (o GetExportResultOutput) ExportVersion() pulumi.StringPtrOutput {
	return o.ApplyT(func(v GetExportResult) *string { return v.ExportVersion }).(pulumi.StringPtrOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o GetExportResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v GetExportResult) string { return v.Id }).(pulumi.StringOutput)
}

func (o GetExportResultOutput) IncludeExtensions() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v GetExportResult) *bool { return v.IncludeExtensions }).(pulumi.BoolPtrOutput)
}

func (o GetExportResultOutput) OutputType() pulumi.StringOutput {
	return o.ApplyT(func(v GetExportResult) string { return v.OutputType }).(pulumi.StringOutput)
}

func (o GetExportResultOutput) Specification() pulumi.StringOutput {
	return o.ApplyT(func(v GetExportResult) string { return v.Specification }).(pulumi.StringOutput)
}

func (o GetExportResultOutput) StageName() pulumi.StringPtrOutput {
	return o.ApplyT(func(v GetExportResult) *string { return v.StageName }).(pulumi.StringPtrOutput)
}

func init() {
	pulumi.RegisterOutputType(GetExportResultOutput{})
}
