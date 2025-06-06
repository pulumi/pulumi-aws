// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package datazone

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Data source for managing an AWS DataZone Domain.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/datazone"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := datazone.LookupDomain(ctx, &datazone.LookupDomainArgs{
//				Name: pulumi.StringRef("example_domain"),
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupDomain(ctx *pulumi.Context, args *LookupDomainArgs, opts ...pulumi.InvokeOption) (*LookupDomainResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupDomainResult
	err := ctx.Invoke("aws:datazone/getDomain:getDomain", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getDomain.
type LookupDomainArgs struct {
	// ID of the Domain. One of `name` or `id` is required
	Id *string `pulumi:"id"`
	// Name of the Domain. One of `name` or `id` is required.
	Name *string `pulumi:"name"`
}

// A collection of values returned by getDomain.
type LookupDomainResult struct {
	// ARN of the Domain.
	Arn string `pulumi:"arn"`
	// The date and time the Domain was created.
	CreatedAt string `pulumi:"createdAt"`
	// Description of the Domain.
	Description string `pulumi:"description"`
	// Version of the Domain.
	DomainVersion string `pulumi:"domainVersion"`
	Id            string `pulumi:"id"`
	// The date and time the Domain was last updated.
	LastUpdatedAt string `pulumi:"lastUpdatedAt"`
	// The AWS account ID that owns the Domain.
	ManagedAccountId string `pulumi:"managedAccountId"`
	Name             string `pulumi:"name"`
	// URL of the Domain.
	PortalUrl string `pulumi:"portalUrl"`
	// Status of the Domain.
	Status string `pulumi:"status"`
}

func LookupDomainOutput(ctx *pulumi.Context, args LookupDomainOutputArgs, opts ...pulumi.InvokeOption) LookupDomainResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupDomainResultOutput, error) {
			args := v.(LookupDomainArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:datazone/getDomain:getDomain", args, LookupDomainResultOutput{}, options).(LookupDomainResultOutput), nil
		}).(LookupDomainResultOutput)
}

// A collection of arguments for invoking getDomain.
type LookupDomainOutputArgs struct {
	// ID of the Domain. One of `name` or `id` is required
	Id pulumi.StringPtrInput `pulumi:"id"`
	// Name of the Domain. One of `name` or `id` is required.
	Name pulumi.StringPtrInput `pulumi:"name"`
}

func (LookupDomainOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupDomainArgs)(nil)).Elem()
}

// A collection of values returned by getDomain.
type LookupDomainResultOutput struct{ *pulumi.OutputState }

func (LookupDomainResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupDomainResult)(nil)).Elem()
}

func (o LookupDomainResultOutput) ToLookupDomainResultOutput() LookupDomainResultOutput {
	return o
}

func (o LookupDomainResultOutput) ToLookupDomainResultOutputWithContext(ctx context.Context) LookupDomainResultOutput {
	return o
}

// ARN of the Domain.
func (o LookupDomainResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDomainResult) string { return v.Arn }).(pulumi.StringOutput)
}

// The date and time the Domain was created.
func (o LookupDomainResultOutput) CreatedAt() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDomainResult) string { return v.CreatedAt }).(pulumi.StringOutput)
}

// Description of the Domain.
func (o LookupDomainResultOutput) Description() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDomainResult) string { return v.Description }).(pulumi.StringOutput)
}

// Version of the Domain.
func (o LookupDomainResultOutput) DomainVersion() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDomainResult) string { return v.DomainVersion }).(pulumi.StringOutput)
}

func (o LookupDomainResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDomainResult) string { return v.Id }).(pulumi.StringOutput)
}

// The date and time the Domain was last updated.
func (o LookupDomainResultOutput) LastUpdatedAt() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDomainResult) string { return v.LastUpdatedAt }).(pulumi.StringOutput)
}

// The AWS account ID that owns the Domain.
func (o LookupDomainResultOutput) ManagedAccountId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDomainResult) string { return v.ManagedAccountId }).(pulumi.StringOutput)
}

func (o LookupDomainResultOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDomainResult) string { return v.Name }).(pulumi.StringOutput)
}

// URL of the Domain.
func (o LookupDomainResultOutput) PortalUrl() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDomainResult) string { return v.PortalUrl }).(pulumi.StringOutput)
}

// Status of the Domain.
func (o LookupDomainResultOutput) Status() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDomainResult) string { return v.Status }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupDomainResultOutput{})
}
