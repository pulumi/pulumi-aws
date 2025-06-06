// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package servicecatalog

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Use this data source to retrieve information about a Service Catalog product.
//
// > **NOTE:** A "provisioning artifact" is also known as a "version," and a "distributor" is also known as a "vendor."
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/servicecatalog"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := servicecatalog.LookupProduct(ctx, &servicecatalog.LookupProductArgs{
//				Id: "prod-dnigbtea24ste",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupProduct(ctx *pulumi.Context, args *LookupProductArgs, opts ...pulumi.InvokeOption) (*LookupProductResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupProductResult
	err := ctx.Invoke("aws:servicecatalog/getProduct:getProduct", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getProduct.
type LookupProductArgs struct {
	// Language code. Valid values are `en` (English), `jp` (Japanese), `zh` (Chinese). The default value is `en`.
	AcceptLanguage *string `pulumi:"acceptLanguage"`
	// ID of the product.
	//
	// The following arguments are optional:
	Id string `pulumi:"id"`
	// Tags applied to the product.
	Tags map[string]string `pulumi:"tags"`
}

// A collection of values returned by getProduct.
type LookupProductResult struct {
	AcceptLanguage *string `pulumi:"acceptLanguage"`
	// ARN of the product.
	Arn string `pulumi:"arn"`
	// Time when the product was created.
	CreatedTime string `pulumi:"createdTime"`
	// Description of the product.
	Description string `pulumi:"description"`
	// Vendor of the product.
	Distributor string `pulumi:"distributor"`
	// Whether the product has a default path.
	HasDefaultPath bool   `pulumi:"hasDefaultPath"`
	Id             string `pulumi:"id"`
	// Name of the product.
	Name string `pulumi:"name"`
	// Owner of the product.
	Owner string `pulumi:"owner"`
	// Status of the product.
	Status string `pulumi:"status"`
	// Field that provides support information about the product.
	SupportDescription string `pulumi:"supportDescription"`
	// Contact email for product support.
	SupportEmail string `pulumi:"supportEmail"`
	// Contact URL for product support.
	SupportUrl string `pulumi:"supportUrl"`
	// Tags applied to the product.
	Tags map[string]string `pulumi:"tags"`
	// Type of product.
	Type string `pulumi:"type"`
}

func LookupProductOutput(ctx *pulumi.Context, args LookupProductOutputArgs, opts ...pulumi.InvokeOption) LookupProductResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupProductResultOutput, error) {
			args := v.(LookupProductArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:servicecatalog/getProduct:getProduct", args, LookupProductResultOutput{}, options).(LookupProductResultOutput), nil
		}).(LookupProductResultOutput)
}

// A collection of arguments for invoking getProduct.
type LookupProductOutputArgs struct {
	// Language code. Valid values are `en` (English), `jp` (Japanese), `zh` (Chinese). The default value is `en`.
	AcceptLanguage pulumi.StringPtrInput `pulumi:"acceptLanguage"`
	// ID of the product.
	//
	// The following arguments are optional:
	Id pulumi.StringInput `pulumi:"id"`
	// Tags applied to the product.
	Tags pulumi.StringMapInput `pulumi:"tags"`
}

func (LookupProductOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupProductArgs)(nil)).Elem()
}

// A collection of values returned by getProduct.
type LookupProductResultOutput struct{ *pulumi.OutputState }

func (LookupProductResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupProductResult)(nil)).Elem()
}

func (o LookupProductResultOutput) ToLookupProductResultOutput() LookupProductResultOutput {
	return o
}

func (o LookupProductResultOutput) ToLookupProductResultOutputWithContext(ctx context.Context) LookupProductResultOutput {
	return o
}

func (o LookupProductResultOutput) AcceptLanguage() pulumi.StringPtrOutput {
	return o.ApplyT(func(v LookupProductResult) *string { return v.AcceptLanguage }).(pulumi.StringPtrOutput)
}

// ARN of the product.
func (o LookupProductResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupProductResult) string { return v.Arn }).(pulumi.StringOutput)
}

// Time when the product was created.
func (o LookupProductResultOutput) CreatedTime() pulumi.StringOutput {
	return o.ApplyT(func(v LookupProductResult) string { return v.CreatedTime }).(pulumi.StringOutput)
}

// Description of the product.
func (o LookupProductResultOutput) Description() pulumi.StringOutput {
	return o.ApplyT(func(v LookupProductResult) string { return v.Description }).(pulumi.StringOutput)
}

// Vendor of the product.
func (o LookupProductResultOutput) Distributor() pulumi.StringOutput {
	return o.ApplyT(func(v LookupProductResult) string { return v.Distributor }).(pulumi.StringOutput)
}

// Whether the product has a default path.
func (o LookupProductResultOutput) HasDefaultPath() pulumi.BoolOutput {
	return o.ApplyT(func(v LookupProductResult) bool { return v.HasDefaultPath }).(pulumi.BoolOutput)
}

func (o LookupProductResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupProductResult) string { return v.Id }).(pulumi.StringOutput)
}

// Name of the product.
func (o LookupProductResultOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v LookupProductResult) string { return v.Name }).(pulumi.StringOutput)
}

// Owner of the product.
func (o LookupProductResultOutput) Owner() pulumi.StringOutput {
	return o.ApplyT(func(v LookupProductResult) string { return v.Owner }).(pulumi.StringOutput)
}

// Status of the product.
func (o LookupProductResultOutput) Status() pulumi.StringOutput {
	return o.ApplyT(func(v LookupProductResult) string { return v.Status }).(pulumi.StringOutput)
}

// Field that provides support information about the product.
func (o LookupProductResultOutput) SupportDescription() pulumi.StringOutput {
	return o.ApplyT(func(v LookupProductResult) string { return v.SupportDescription }).(pulumi.StringOutput)
}

// Contact email for product support.
func (o LookupProductResultOutput) SupportEmail() pulumi.StringOutput {
	return o.ApplyT(func(v LookupProductResult) string { return v.SupportEmail }).(pulumi.StringOutput)
}

// Contact URL for product support.
func (o LookupProductResultOutput) SupportUrl() pulumi.StringOutput {
	return o.ApplyT(func(v LookupProductResult) string { return v.SupportUrl }).(pulumi.StringOutput)
}

// Tags applied to the product.
func (o LookupProductResultOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v LookupProductResult) map[string]string { return v.Tags }).(pulumi.StringMapOutput)
}

// Type of product.
func (o LookupProductResultOutput) Type() pulumi.StringOutput {
	return o.ApplyT(func(v LookupProductResult) string { return v.Type }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupProductResultOutput{})
}
