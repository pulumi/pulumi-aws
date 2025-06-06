// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package datapipeline

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides details about a specific DataPipeline Pipeline Definition.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/datapipeline"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := datapipeline.LookupPipelineDefinition(ctx, &datapipeline.LookupPipelineDefinitionArgs{
//				PipelineId: "pipelineID",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupPipelineDefinition(ctx *pulumi.Context, args *LookupPipelineDefinitionArgs, opts ...pulumi.InvokeOption) (*LookupPipelineDefinitionResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupPipelineDefinitionResult
	err := ctx.Invoke("aws:datapipeline/getPipelineDefinition:getPipelineDefinition", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getPipelineDefinition.
type LookupPipelineDefinitionArgs struct {
	// Parameter values used in the pipeline definition. See below
	ParameterValues []GetPipelineDefinitionParameterValue `pulumi:"parameterValues"`
	// ID of the pipeline.
	PipelineId string `pulumi:"pipelineId"`
}

// A collection of values returned by getPipelineDefinition.
type LookupPipelineDefinitionResult struct {
	// The provider-assigned unique ID for this managed resource.
	Id string `pulumi:"id"`
	// Parameter objects used in the pipeline definition. See below
	ParameterObjects []GetPipelineDefinitionParameterObject `pulumi:"parameterObjects"`
	// Parameter values used in the pipeline definition. See below
	ParameterValues []GetPipelineDefinitionParameterValue `pulumi:"parameterValues"`
	PipelineId      string                                `pulumi:"pipelineId"`
	// Objects defined in the pipeline. See below
	PipelineObjects []GetPipelineDefinitionPipelineObject `pulumi:"pipelineObjects"`
}

func LookupPipelineDefinitionOutput(ctx *pulumi.Context, args LookupPipelineDefinitionOutputArgs, opts ...pulumi.InvokeOption) LookupPipelineDefinitionResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupPipelineDefinitionResultOutput, error) {
			args := v.(LookupPipelineDefinitionArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:datapipeline/getPipelineDefinition:getPipelineDefinition", args, LookupPipelineDefinitionResultOutput{}, options).(LookupPipelineDefinitionResultOutput), nil
		}).(LookupPipelineDefinitionResultOutput)
}

// A collection of arguments for invoking getPipelineDefinition.
type LookupPipelineDefinitionOutputArgs struct {
	// Parameter values used in the pipeline definition. See below
	ParameterValues GetPipelineDefinitionParameterValueArrayInput `pulumi:"parameterValues"`
	// ID of the pipeline.
	PipelineId pulumi.StringInput `pulumi:"pipelineId"`
}

func (LookupPipelineDefinitionOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupPipelineDefinitionArgs)(nil)).Elem()
}

// A collection of values returned by getPipelineDefinition.
type LookupPipelineDefinitionResultOutput struct{ *pulumi.OutputState }

func (LookupPipelineDefinitionResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupPipelineDefinitionResult)(nil)).Elem()
}

func (o LookupPipelineDefinitionResultOutput) ToLookupPipelineDefinitionResultOutput() LookupPipelineDefinitionResultOutput {
	return o
}

func (o LookupPipelineDefinitionResultOutput) ToLookupPipelineDefinitionResultOutputWithContext(ctx context.Context) LookupPipelineDefinitionResultOutput {
	return o
}

// The provider-assigned unique ID for this managed resource.
func (o LookupPipelineDefinitionResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupPipelineDefinitionResult) string { return v.Id }).(pulumi.StringOutput)
}

// Parameter objects used in the pipeline definition. See below
func (o LookupPipelineDefinitionResultOutput) ParameterObjects() GetPipelineDefinitionParameterObjectArrayOutput {
	return o.ApplyT(func(v LookupPipelineDefinitionResult) []GetPipelineDefinitionParameterObject {
		return v.ParameterObjects
	}).(GetPipelineDefinitionParameterObjectArrayOutput)
}

// Parameter values used in the pipeline definition. See below
func (o LookupPipelineDefinitionResultOutput) ParameterValues() GetPipelineDefinitionParameterValueArrayOutput {
	return o.ApplyT(func(v LookupPipelineDefinitionResult) []GetPipelineDefinitionParameterValue { return v.ParameterValues }).(GetPipelineDefinitionParameterValueArrayOutput)
}

func (o LookupPipelineDefinitionResultOutput) PipelineId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupPipelineDefinitionResult) string { return v.PipelineId }).(pulumi.StringOutput)
}

// Objects defined in the pipeline. See below
func (o LookupPipelineDefinitionResultOutput) PipelineObjects() GetPipelineDefinitionPipelineObjectArrayOutput {
	return o.ApplyT(func(v LookupPipelineDefinitionResult) []GetPipelineDefinitionPipelineObject { return v.PipelineObjects }).(GetPipelineDefinitionPipelineObjectArrayOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupPipelineDefinitionResultOutput{})
}
