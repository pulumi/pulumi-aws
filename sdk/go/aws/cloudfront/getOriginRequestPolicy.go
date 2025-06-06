// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package cloudfront

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// ## Example Usage
//
// ### Basic Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/cloudfront"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := cloudfront.LookupOriginRequestPolicy(ctx, &cloudfront.LookupOriginRequestPolicyArgs{
//				Name: pulumi.StringRef("example-policy"),
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
// ### AWS-Managed Policies
//
// AWS managed origin request policy names are prefixed with `Managed-`:
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/cloudfront"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := cloudfront.LookupOriginRequestPolicy(ctx, &cloudfront.LookupOriginRequestPolicyArgs{
//				Name: pulumi.StringRef("Managed-UserAgentRefererHeaders"),
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupOriginRequestPolicy(ctx *pulumi.Context, args *LookupOriginRequestPolicyArgs, opts ...pulumi.InvokeOption) (*LookupOriginRequestPolicyResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupOriginRequestPolicyResult
	err := ctx.Invoke("aws:cloudfront/getOriginRequestPolicy:getOriginRequestPolicy", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getOriginRequestPolicy.
type LookupOriginRequestPolicyArgs struct {
	// Identifier for the origin request policy.
	Id *string `pulumi:"id"`
	// Unique name to identify the origin request policy.
	Name *string `pulumi:"name"`
}

// A collection of values returned by getOriginRequestPolicy.
type LookupOriginRequestPolicyResult struct {
	// The origin request policy ARN.
	Arn string `pulumi:"arn"`
	// Comment to describe the origin request policy.
	Comment string `pulumi:"comment"`
	// Object that determines whether any cookies in viewer requests (and if so, which cookies) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Cookies Config for more information.
	CookiesConfigs []GetOriginRequestPolicyCookiesConfig `pulumi:"cookiesConfigs"`
	// Current version of the origin request policy.
	Etag string `pulumi:"etag"`
	// Object that determines whether any HTTP headers (and if so, which headers) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Headers Config for more information.
	HeadersConfigs []GetOriginRequestPolicyHeadersConfig `pulumi:"headersConfigs"`
	Id             *string                               `pulumi:"id"`
	Name           *string                               `pulumi:"name"`
	// Object that determines whether any URL query strings in viewer requests (and if so, which query strings) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Query String Config for more information.
	QueryStringsConfigs []GetOriginRequestPolicyQueryStringsConfig `pulumi:"queryStringsConfigs"`
}

func LookupOriginRequestPolicyOutput(ctx *pulumi.Context, args LookupOriginRequestPolicyOutputArgs, opts ...pulumi.InvokeOption) LookupOriginRequestPolicyResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupOriginRequestPolicyResultOutput, error) {
			args := v.(LookupOriginRequestPolicyArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:cloudfront/getOriginRequestPolicy:getOriginRequestPolicy", args, LookupOriginRequestPolicyResultOutput{}, options).(LookupOriginRequestPolicyResultOutput), nil
		}).(LookupOriginRequestPolicyResultOutput)
}

// A collection of arguments for invoking getOriginRequestPolicy.
type LookupOriginRequestPolicyOutputArgs struct {
	// Identifier for the origin request policy.
	Id pulumi.StringPtrInput `pulumi:"id"`
	// Unique name to identify the origin request policy.
	Name pulumi.StringPtrInput `pulumi:"name"`
}

func (LookupOriginRequestPolicyOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupOriginRequestPolicyArgs)(nil)).Elem()
}

// A collection of values returned by getOriginRequestPolicy.
type LookupOriginRequestPolicyResultOutput struct{ *pulumi.OutputState }

func (LookupOriginRequestPolicyResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupOriginRequestPolicyResult)(nil)).Elem()
}

func (o LookupOriginRequestPolicyResultOutput) ToLookupOriginRequestPolicyResultOutput() LookupOriginRequestPolicyResultOutput {
	return o
}

func (o LookupOriginRequestPolicyResultOutput) ToLookupOriginRequestPolicyResultOutputWithContext(ctx context.Context) LookupOriginRequestPolicyResultOutput {
	return o
}

// The origin request policy ARN.
func (o LookupOriginRequestPolicyResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupOriginRequestPolicyResult) string { return v.Arn }).(pulumi.StringOutput)
}

// Comment to describe the origin request policy.
func (o LookupOriginRequestPolicyResultOutput) Comment() pulumi.StringOutput {
	return o.ApplyT(func(v LookupOriginRequestPolicyResult) string { return v.Comment }).(pulumi.StringOutput)
}

// Object that determines whether any cookies in viewer requests (and if so, which cookies) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Cookies Config for more information.
func (o LookupOriginRequestPolicyResultOutput) CookiesConfigs() GetOriginRequestPolicyCookiesConfigArrayOutput {
	return o.ApplyT(func(v LookupOriginRequestPolicyResult) []GetOriginRequestPolicyCookiesConfig { return v.CookiesConfigs }).(GetOriginRequestPolicyCookiesConfigArrayOutput)
}

// Current version of the origin request policy.
func (o LookupOriginRequestPolicyResultOutput) Etag() pulumi.StringOutput {
	return o.ApplyT(func(v LookupOriginRequestPolicyResult) string { return v.Etag }).(pulumi.StringOutput)
}

// Object that determines whether any HTTP headers (and if so, which headers) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Headers Config for more information.
func (o LookupOriginRequestPolicyResultOutput) HeadersConfigs() GetOriginRequestPolicyHeadersConfigArrayOutput {
	return o.ApplyT(func(v LookupOriginRequestPolicyResult) []GetOriginRequestPolicyHeadersConfig { return v.HeadersConfigs }).(GetOriginRequestPolicyHeadersConfigArrayOutput)
}

func (o LookupOriginRequestPolicyResultOutput) Id() pulumi.StringPtrOutput {
	return o.ApplyT(func(v LookupOriginRequestPolicyResult) *string { return v.Id }).(pulumi.StringPtrOutput)
}

func (o LookupOriginRequestPolicyResultOutput) Name() pulumi.StringPtrOutput {
	return o.ApplyT(func(v LookupOriginRequestPolicyResult) *string { return v.Name }).(pulumi.StringPtrOutput)
}

// Object that determines whether any URL query strings in viewer requests (and if so, which query strings) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Query String Config for more information.
func (o LookupOriginRequestPolicyResultOutput) QueryStringsConfigs() GetOriginRequestPolicyQueryStringsConfigArrayOutput {
	return o.ApplyT(func(v LookupOriginRequestPolicyResult) []GetOriginRequestPolicyQueryStringsConfig {
		return v.QueryStringsConfigs
	}).(GetOriginRequestPolicyQueryStringsConfigArrayOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupOriginRequestPolicyResultOutput{})
}
