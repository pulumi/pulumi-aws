// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package bedrockfoundation

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Data source for managing an AWS Bedrock Foundation Model.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/bedrockfoundation"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			test, err := bedrockfoundation.GetModels(ctx, &bedrockfoundation.GetModelsArgs{}, nil)
//			if err != nil {
//				return err
//			}
//			_, err = bedrockfoundation.GetModel(ctx, &bedrockfoundation.GetModelArgs{
//				ModelId: test.ModelSummaries[0].ModelId,
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func GetModel(ctx *pulumi.Context, args *GetModelArgs, opts ...pulumi.InvokeOption) (*GetModelResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv GetModelResult
	err := ctx.Invoke("aws:bedrockfoundation/getModel:getModel", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getModel.
type GetModelArgs struct {
	// Model identifier.
	ModelId string `pulumi:"modelId"`
}

// A collection of values returned by getModel.
type GetModelResult struct {
	// Customizations that the model supports.
	CustomizationsSupporteds []string `pulumi:"customizationsSupporteds"`
	Id                       string   `pulumi:"id"`
	// Inference types that the model supports.
	InferenceTypesSupporteds []string `pulumi:"inferenceTypesSupporteds"`
	// Input modalities that the model supports.
	InputModalities []string `pulumi:"inputModalities"`
	// Model ARN.
	ModelArn string `pulumi:"modelArn"`
	ModelId  string `pulumi:"modelId"`
	// Model name.
	ModelName string `pulumi:"modelName"`
	// Output modalities that the model supports.
	OutputModalities []string `pulumi:"outputModalities"`
	// Model provider name.
	ProviderName string `pulumi:"providerName"`
	// Indicates whether the model supports streaming.
	ResponseStreamingSupported bool `pulumi:"responseStreamingSupported"`
}

func GetModelOutput(ctx *pulumi.Context, args GetModelOutputArgs, opts ...pulumi.InvokeOption) GetModelResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (GetModelResultOutput, error) {
			args := v.(GetModelArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:bedrockfoundation/getModel:getModel", args, GetModelResultOutput{}, options).(GetModelResultOutput), nil
		}).(GetModelResultOutput)
}

// A collection of arguments for invoking getModel.
type GetModelOutputArgs struct {
	// Model identifier.
	ModelId pulumi.StringInput `pulumi:"modelId"`
}

func (GetModelOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*GetModelArgs)(nil)).Elem()
}

// A collection of values returned by getModel.
type GetModelResultOutput struct{ *pulumi.OutputState }

func (GetModelResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*GetModelResult)(nil)).Elem()
}

func (o GetModelResultOutput) ToGetModelResultOutput() GetModelResultOutput {
	return o
}

func (o GetModelResultOutput) ToGetModelResultOutputWithContext(ctx context.Context) GetModelResultOutput {
	return o
}

// Customizations that the model supports.
func (o GetModelResultOutput) CustomizationsSupporteds() pulumi.StringArrayOutput {
	return o.ApplyT(func(v GetModelResult) []string { return v.CustomizationsSupporteds }).(pulumi.StringArrayOutput)
}

func (o GetModelResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v GetModelResult) string { return v.Id }).(pulumi.StringOutput)
}

// Inference types that the model supports.
func (o GetModelResultOutput) InferenceTypesSupporteds() pulumi.StringArrayOutput {
	return o.ApplyT(func(v GetModelResult) []string { return v.InferenceTypesSupporteds }).(pulumi.StringArrayOutput)
}

// Input modalities that the model supports.
func (o GetModelResultOutput) InputModalities() pulumi.StringArrayOutput {
	return o.ApplyT(func(v GetModelResult) []string { return v.InputModalities }).(pulumi.StringArrayOutput)
}

// Model ARN.
func (o GetModelResultOutput) ModelArn() pulumi.StringOutput {
	return o.ApplyT(func(v GetModelResult) string { return v.ModelArn }).(pulumi.StringOutput)
}

func (o GetModelResultOutput) ModelId() pulumi.StringOutput {
	return o.ApplyT(func(v GetModelResult) string { return v.ModelId }).(pulumi.StringOutput)
}

// Model name.
func (o GetModelResultOutput) ModelName() pulumi.StringOutput {
	return o.ApplyT(func(v GetModelResult) string { return v.ModelName }).(pulumi.StringOutput)
}

// Output modalities that the model supports.
func (o GetModelResultOutput) OutputModalities() pulumi.StringArrayOutput {
	return o.ApplyT(func(v GetModelResult) []string { return v.OutputModalities }).(pulumi.StringArrayOutput)
}

// Model provider name.
func (o GetModelResultOutput) ProviderName() pulumi.StringOutput {
	return o.ApplyT(func(v GetModelResult) string { return v.ProviderName }).(pulumi.StringOutput)
}

// Indicates whether the model supports streaming.
func (o GetModelResultOutput) ResponseStreamingSupported() pulumi.BoolOutput {
	return o.ApplyT(func(v GetModelResult) bool { return v.ResponseStreamingSupported }).(pulumi.BoolOutput)
}

func init() {
	pulumi.RegisterOutputType(GetModelResultOutput{})
}
