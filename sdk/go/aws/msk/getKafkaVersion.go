// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package msk

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Get information on a Amazon MSK Kafka Version
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/msk"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := msk.GetKafkaVersion(ctx, &msk.GetKafkaVersionArgs{
//				PreferredVersions: []string{
//					"2.4.1.1",
//					"2.4.1",
//					"2.2.1",
//				},
//			}, nil)
//			if err != nil {
//				return err
//			}
//			_, err = msk.GetKafkaVersion(ctx, &msk.GetKafkaVersionArgs{
//				Version: pulumi.StringRef("2.8.0"),
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func GetKafkaVersion(ctx *pulumi.Context, args *GetKafkaVersionArgs, opts ...pulumi.InvokeOption) (*GetKafkaVersionResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv GetKafkaVersionResult
	err := ctx.Invoke("aws:msk/getKafkaVersion:getKafkaVersion", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getKafkaVersion.
type GetKafkaVersionArgs struct {
	// Ordered list of preferred Kafka versions. The first match in this list will be returned. Either `preferredVersions` or `version` must be set.
	PreferredVersions []string `pulumi:"preferredVersions"`
	// Version of MSK Kafka. For example 2.4.1.1 or "2.2.1" etc. Either `preferredVersions` or `version` must be set.
	Version *string `pulumi:"version"`
}

// A collection of values returned by getKafkaVersion.
type GetKafkaVersionResult struct {
	// The provider-assigned unique ID for this managed resource.
	Id                string   `pulumi:"id"`
	PreferredVersions []string `pulumi:"preferredVersions"`
	// Status of the MSK Kafka version eg. `ACTIVE` or `DEPRECATED`.
	Status  string `pulumi:"status"`
	Version string `pulumi:"version"`
}

func GetKafkaVersionOutput(ctx *pulumi.Context, args GetKafkaVersionOutputArgs, opts ...pulumi.InvokeOption) GetKafkaVersionResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (GetKafkaVersionResultOutput, error) {
			args := v.(GetKafkaVersionArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:msk/getKafkaVersion:getKafkaVersion", args, GetKafkaVersionResultOutput{}, options).(GetKafkaVersionResultOutput), nil
		}).(GetKafkaVersionResultOutput)
}

// A collection of arguments for invoking getKafkaVersion.
type GetKafkaVersionOutputArgs struct {
	// Ordered list of preferred Kafka versions. The first match in this list will be returned. Either `preferredVersions` or `version` must be set.
	PreferredVersions pulumi.StringArrayInput `pulumi:"preferredVersions"`
	// Version of MSK Kafka. For example 2.4.1.1 or "2.2.1" etc. Either `preferredVersions` or `version` must be set.
	Version pulumi.StringPtrInput `pulumi:"version"`
}

func (GetKafkaVersionOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*GetKafkaVersionArgs)(nil)).Elem()
}

// A collection of values returned by getKafkaVersion.
type GetKafkaVersionResultOutput struct{ *pulumi.OutputState }

func (GetKafkaVersionResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*GetKafkaVersionResult)(nil)).Elem()
}

func (o GetKafkaVersionResultOutput) ToGetKafkaVersionResultOutput() GetKafkaVersionResultOutput {
	return o
}

func (o GetKafkaVersionResultOutput) ToGetKafkaVersionResultOutputWithContext(ctx context.Context) GetKafkaVersionResultOutput {
	return o
}

// The provider-assigned unique ID for this managed resource.
func (o GetKafkaVersionResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v GetKafkaVersionResult) string { return v.Id }).(pulumi.StringOutput)
}

func (o GetKafkaVersionResultOutput) PreferredVersions() pulumi.StringArrayOutput {
	return o.ApplyT(func(v GetKafkaVersionResult) []string { return v.PreferredVersions }).(pulumi.StringArrayOutput)
}

// Status of the MSK Kafka version eg. `ACTIVE` or `DEPRECATED`.
func (o GetKafkaVersionResultOutput) Status() pulumi.StringOutput {
	return o.ApplyT(func(v GetKafkaVersionResult) string { return v.Status }).(pulumi.StringOutput)
}

func (o GetKafkaVersionResultOutput) Version() pulumi.StringOutput {
	return o.ApplyT(func(v GetKafkaVersionResult) string { return v.Version }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(GetKafkaVersionResultOutput{})
}
