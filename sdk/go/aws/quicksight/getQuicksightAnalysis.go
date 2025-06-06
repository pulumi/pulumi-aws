// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package quicksight

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Data source for managing an AWS QuickSight Analysis.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/quicksight"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := quicksight.GetQuicksightAnalysis(ctx, &quicksight.GetQuicksightAnalysisArgs{
//				AnalysisId: "example-id",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func GetQuicksightAnalysis(ctx *pulumi.Context, args *GetQuicksightAnalysisArgs, opts ...pulumi.InvokeOption) (*GetQuicksightAnalysisResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv GetQuicksightAnalysisResult
	err := ctx.Invoke("aws:quicksight/getQuicksightAnalysis:getQuicksightAnalysis", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getQuicksightAnalysis.
type GetQuicksightAnalysisArgs struct {
	// Identifier for the analysis.
	AnalysisId string `pulumi:"analysisId"`
	// AWS account ID.
	AwsAccountId *string           `pulumi:"awsAccountId"`
	Tags         map[string]string `pulumi:"tags"`
}

// A collection of values returned by getQuicksightAnalysis.
type GetQuicksightAnalysisResult struct {
	AnalysisId   string `pulumi:"analysisId"`
	Arn          string `pulumi:"arn"`
	AwsAccountId string `pulumi:"awsAccountId"`
	CreatedTime  string `pulumi:"createdTime"`
	// The provider-assigned unique ID for this managed resource.
	Id                string                            `pulumi:"id"`
	LastPublishedTime string                            `pulumi:"lastPublishedTime"`
	LastUpdatedTime   string                            `pulumi:"lastUpdatedTime"`
	Name              string                            `pulumi:"name"`
	Permissions       []GetQuicksightAnalysisPermission `pulumi:"permissions"`
	Status            string                            `pulumi:"status"`
	Tags              map[string]string                 `pulumi:"tags"`
	ThemeArn          string                            `pulumi:"themeArn"`
}

func GetQuicksightAnalysisOutput(ctx *pulumi.Context, args GetQuicksightAnalysisOutputArgs, opts ...pulumi.InvokeOption) GetQuicksightAnalysisResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (GetQuicksightAnalysisResultOutput, error) {
			args := v.(GetQuicksightAnalysisArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:quicksight/getQuicksightAnalysis:getQuicksightAnalysis", args, GetQuicksightAnalysisResultOutput{}, options).(GetQuicksightAnalysisResultOutput), nil
		}).(GetQuicksightAnalysisResultOutput)
}

// A collection of arguments for invoking getQuicksightAnalysis.
type GetQuicksightAnalysisOutputArgs struct {
	// Identifier for the analysis.
	AnalysisId pulumi.StringInput `pulumi:"analysisId"`
	// AWS account ID.
	AwsAccountId pulumi.StringPtrInput `pulumi:"awsAccountId"`
	Tags         pulumi.StringMapInput `pulumi:"tags"`
}

func (GetQuicksightAnalysisOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*GetQuicksightAnalysisArgs)(nil)).Elem()
}

// A collection of values returned by getQuicksightAnalysis.
type GetQuicksightAnalysisResultOutput struct{ *pulumi.OutputState }

func (GetQuicksightAnalysisResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*GetQuicksightAnalysisResult)(nil)).Elem()
}

func (o GetQuicksightAnalysisResultOutput) ToGetQuicksightAnalysisResultOutput() GetQuicksightAnalysisResultOutput {
	return o
}

func (o GetQuicksightAnalysisResultOutput) ToGetQuicksightAnalysisResultOutputWithContext(ctx context.Context) GetQuicksightAnalysisResultOutput {
	return o
}

func (o GetQuicksightAnalysisResultOutput) AnalysisId() pulumi.StringOutput {
	return o.ApplyT(func(v GetQuicksightAnalysisResult) string { return v.AnalysisId }).(pulumi.StringOutput)
}

func (o GetQuicksightAnalysisResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v GetQuicksightAnalysisResult) string { return v.Arn }).(pulumi.StringOutput)
}

func (o GetQuicksightAnalysisResultOutput) AwsAccountId() pulumi.StringOutput {
	return o.ApplyT(func(v GetQuicksightAnalysisResult) string { return v.AwsAccountId }).(pulumi.StringOutput)
}

func (o GetQuicksightAnalysisResultOutput) CreatedTime() pulumi.StringOutput {
	return o.ApplyT(func(v GetQuicksightAnalysisResult) string { return v.CreatedTime }).(pulumi.StringOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o GetQuicksightAnalysisResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v GetQuicksightAnalysisResult) string { return v.Id }).(pulumi.StringOutput)
}

func (o GetQuicksightAnalysisResultOutput) LastPublishedTime() pulumi.StringOutput {
	return o.ApplyT(func(v GetQuicksightAnalysisResult) string { return v.LastPublishedTime }).(pulumi.StringOutput)
}

func (o GetQuicksightAnalysisResultOutput) LastUpdatedTime() pulumi.StringOutput {
	return o.ApplyT(func(v GetQuicksightAnalysisResult) string { return v.LastUpdatedTime }).(pulumi.StringOutput)
}

func (o GetQuicksightAnalysisResultOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v GetQuicksightAnalysisResult) string { return v.Name }).(pulumi.StringOutput)
}

func (o GetQuicksightAnalysisResultOutput) Permissions() GetQuicksightAnalysisPermissionArrayOutput {
	return o.ApplyT(func(v GetQuicksightAnalysisResult) []GetQuicksightAnalysisPermission { return v.Permissions }).(GetQuicksightAnalysisPermissionArrayOutput)
}

func (o GetQuicksightAnalysisResultOutput) Status() pulumi.StringOutput {
	return o.ApplyT(func(v GetQuicksightAnalysisResult) string { return v.Status }).(pulumi.StringOutput)
}

func (o GetQuicksightAnalysisResultOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v GetQuicksightAnalysisResult) map[string]string { return v.Tags }).(pulumi.StringMapOutput)
}

func (o GetQuicksightAnalysisResultOutput) ThemeArn() pulumi.StringOutput {
	return o.ApplyT(func(v GetQuicksightAnalysisResult) string { return v.ThemeArn }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(GetQuicksightAnalysisResultOutput{})
}
