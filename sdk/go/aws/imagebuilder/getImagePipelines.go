// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package imagebuilder

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Use this data source to get the ARNs and names of Image Builder Image Pipelines matching the specified criteria.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/imagebuilder"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := imagebuilder.GetImagePipelines(ctx, &imagebuilder.GetImagePipelinesArgs{
//				Filters: []imagebuilder.GetImagePipelinesFilter{
//					{
//						Name: "name",
//						Values: []string{
//							"example",
//						},
//					},
//				},
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func GetImagePipelines(ctx *pulumi.Context, args *GetImagePipelinesArgs, opts ...pulumi.InvokeOption) (*GetImagePipelinesResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv GetImagePipelinesResult
	err := ctx.Invoke("aws:imagebuilder/getImagePipelines:getImagePipelines", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getImagePipelines.
type GetImagePipelinesArgs struct {
	// Configuration block(s) for filtering. Detailed below.
	Filters []GetImagePipelinesFilter `pulumi:"filters"`
}

// A collection of values returned by getImagePipelines.
type GetImagePipelinesResult struct {
	// Set of ARNs of the matched Image Builder Image Pipelines.
	Arns    []string                  `pulumi:"arns"`
	Filters []GetImagePipelinesFilter `pulumi:"filters"`
	// The provider-assigned unique ID for this managed resource.
	Id string `pulumi:"id"`
	// Set of names of the matched Image Builder Image Pipelines.
	Names []string `pulumi:"names"`
}

func GetImagePipelinesOutput(ctx *pulumi.Context, args GetImagePipelinesOutputArgs, opts ...pulumi.InvokeOption) GetImagePipelinesResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (GetImagePipelinesResultOutput, error) {
			args := v.(GetImagePipelinesArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:imagebuilder/getImagePipelines:getImagePipelines", args, GetImagePipelinesResultOutput{}, options).(GetImagePipelinesResultOutput), nil
		}).(GetImagePipelinesResultOutput)
}

// A collection of arguments for invoking getImagePipelines.
type GetImagePipelinesOutputArgs struct {
	// Configuration block(s) for filtering. Detailed below.
	Filters GetImagePipelinesFilterArrayInput `pulumi:"filters"`
}

func (GetImagePipelinesOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*GetImagePipelinesArgs)(nil)).Elem()
}

// A collection of values returned by getImagePipelines.
type GetImagePipelinesResultOutput struct{ *pulumi.OutputState }

func (GetImagePipelinesResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*GetImagePipelinesResult)(nil)).Elem()
}

func (o GetImagePipelinesResultOutput) ToGetImagePipelinesResultOutput() GetImagePipelinesResultOutput {
	return o
}

func (o GetImagePipelinesResultOutput) ToGetImagePipelinesResultOutputWithContext(ctx context.Context) GetImagePipelinesResultOutput {
	return o
}

// Set of ARNs of the matched Image Builder Image Pipelines.
func (o GetImagePipelinesResultOutput) Arns() pulumi.StringArrayOutput {
	return o.ApplyT(func(v GetImagePipelinesResult) []string { return v.Arns }).(pulumi.StringArrayOutput)
}

func (o GetImagePipelinesResultOutput) Filters() GetImagePipelinesFilterArrayOutput {
	return o.ApplyT(func(v GetImagePipelinesResult) []GetImagePipelinesFilter { return v.Filters }).(GetImagePipelinesFilterArrayOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o GetImagePipelinesResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v GetImagePipelinesResult) string { return v.Id }).(pulumi.StringOutput)
}

// Set of names of the matched Image Builder Image Pipelines.
func (o GetImagePipelinesResultOutput) Names() pulumi.StringArrayOutput {
	return o.ApplyT(func(v GetImagePipelinesResult) []string { return v.Names }).(pulumi.StringArrayOutput)
}

func init() {
	pulumi.RegisterOutputType(GetImagePipelinesResultOutput{})
}
