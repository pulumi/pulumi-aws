// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package outposts

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides details about multiple Outposts.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/outposts"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := outposts.GetOutposts(ctx, &outposts.GetOutpostsArgs{
//				SiteId: pulumi.StringRef(id),
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func GetOutposts(ctx *pulumi.Context, args *GetOutpostsArgs, opts ...pulumi.InvokeOption) (*GetOutpostsResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv GetOutpostsResult
	err := ctx.Invoke("aws:outposts/getOutposts:getOutposts", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getOutposts.
type GetOutpostsArgs struct {
	// Availability Zone name.
	AvailabilityZone *string `pulumi:"availabilityZone"`
	// Availability Zone identifier.
	AvailabilityZoneId *string `pulumi:"availabilityZoneId"`
	// AWS Account identifier of the Outpost owner.
	OwnerId *string `pulumi:"ownerId"`
	// Site identifier.
	SiteId *string `pulumi:"siteId"`
}

// A collection of values returned by getOutposts.
type GetOutpostsResult struct {
	// Set of Amazon Resource Names (ARNs).
	Arns               []string `pulumi:"arns"`
	AvailabilityZone   string   `pulumi:"availabilityZone"`
	AvailabilityZoneId string   `pulumi:"availabilityZoneId"`
	// The provider-assigned unique ID for this managed resource.
	Id string `pulumi:"id"`
	// Set of identifiers.
	Ids     []string `pulumi:"ids"`
	OwnerId string   `pulumi:"ownerId"`
	SiteId  string   `pulumi:"siteId"`
}

func GetOutpostsOutput(ctx *pulumi.Context, args GetOutpostsOutputArgs, opts ...pulumi.InvokeOption) GetOutpostsResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (GetOutpostsResultOutput, error) {
			args := v.(GetOutpostsArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:outposts/getOutposts:getOutposts", args, GetOutpostsResultOutput{}, options).(GetOutpostsResultOutput), nil
		}).(GetOutpostsResultOutput)
}

// A collection of arguments for invoking getOutposts.
type GetOutpostsOutputArgs struct {
	// Availability Zone name.
	AvailabilityZone pulumi.StringPtrInput `pulumi:"availabilityZone"`
	// Availability Zone identifier.
	AvailabilityZoneId pulumi.StringPtrInput `pulumi:"availabilityZoneId"`
	// AWS Account identifier of the Outpost owner.
	OwnerId pulumi.StringPtrInput `pulumi:"ownerId"`
	// Site identifier.
	SiteId pulumi.StringPtrInput `pulumi:"siteId"`
}

func (GetOutpostsOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*GetOutpostsArgs)(nil)).Elem()
}

// A collection of values returned by getOutposts.
type GetOutpostsResultOutput struct{ *pulumi.OutputState }

func (GetOutpostsResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*GetOutpostsResult)(nil)).Elem()
}

func (o GetOutpostsResultOutput) ToGetOutpostsResultOutput() GetOutpostsResultOutput {
	return o
}

func (o GetOutpostsResultOutput) ToGetOutpostsResultOutputWithContext(ctx context.Context) GetOutpostsResultOutput {
	return o
}

// Set of Amazon Resource Names (ARNs).
func (o GetOutpostsResultOutput) Arns() pulumi.StringArrayOutput {
	return o.ApplyT(func(v GetOutpostsResult) []string { return v.Arns }).(pulumi.StringArrayOutput)
}

func (o GetOutpostsResultOutput) AvailabilityZone() pulumi.StringOutput {
	return o.ApplyT(func(v GetOutpostsResult) string { return v.AvailabilityZone }).(pulumi.StringOutput)
}

func (o GetOutpostsResultOutput) AvailabilityZoneId() pulumi.StringOutput {
	return o.ApplyT(func(v GetOutpostsResult) string { return v.AvailabilityZoneId }).(pulumi.StringOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o GetOutpostsResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v GetOutpostsResult) string { return v.Id }).(pulumi.StringOutput)
}

// Set of identifiers.
func (o GetOutpostsResultOutput) Ids() pulumi.StringArrayOutput {
	return o.ApplyT(func(v GetOutpostsResult) []string { return v.Ids }).(pulumi.StringArrayOutput)
}

func (o GetOutpostsResultOutput) OwnerId() pulumi.StringOutput {
	return o.ApplyT(func(v GetOutpostsResult) string { return v.OwnerId }).(pulumi.StringOutput)
}

func (o GetOutpostsResultOutput) SiteId() pulumi.StringOutput {
	return o.ApplyT(func(v GetOutpostsResult) string { return v.SiteId }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(GetOutpostsResultOutput{})
}
