// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package ebs

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// `ebs.getEbsVolumes` provides identifying information for EBS volumes matching given criteria.
//
// This data source can be useful for getting a list of volume IDs with (for example) matching tags.
func GetEbsVolumes(ctx *pulumi.Context, args *GetEbsVolumesArgs, opts ...pulumi.InvokeOption) (*GetEbsVolumesResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv GetEbsVolumesResult
	err := ctx.Invoke("aws:ebs/getEbsVolumes:getEbsVolumes", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getEbsVolumes.
type GetEbsVolumesArgs struct {
	// Custom filter block as described below.
	Filters []GetEbsVolumesFilter `pulumi:"filters"`
	// Map of tags, each pair of which must exactly match
	// a pair on the desired volumes.
	//
	// More complex filters can be expressed using one or more `filter` sub-blocks,
	// which take the following arguments:
	Tags map[string]string `pulumi:"tags"`
}

// A collection of values returned by getEbsVolumes.
type GetEbsVolumesResult struct {
	Filters []GetEbsVolumesFilter `pulumi:"filters"`
	// The provider-assigned unique ID for this managed resource.
	Id string `pulumi:"id"`
	// Set of all the EBS Volume IDs found. This data source will fail if
	// no volumes match the provided criteria.
	Ids  []string          `pulumi:"ids"`
	Tags map[string]string `pulumi:"tags"`
}

func GetEbsVolumesOutput(ctx *pulumi.Context, args GetEbsVolumesOutputArgs, opts ...pulumi.InvokeOption) GetEbsVolumesResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (GetEbsVolumesResultOutput, error) {
			args := v.(GetEbsVolumesArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:ebs/getEbsVolumes:getEbsVolumes", args, GetEbsVolumesResultOutput{}, options).(GetEbsVolumesResultOutput), nil
		}).(GetEbsVolumesResultOutput)
}

// A collection of arguments for invoking getEbsVolumes.
type GetEbsVolumesOutputArgs struct {
	// Custom filter block as described below.
	Filters GetEbsVolumesFilterArrayInput `pulumi:"filters"`
	// Map of tags, each pair of which must exactly match
	// a pair on the desired volumes.
	//
	// More complex filters can be expressed using one or more `filter` sub-blocks,
	// which take the following arguments:
	Tags pulumi.StringMapInput `pulumi:"tags"`
}

func (GetEbsVolumesOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*GetEbsVolumesArgs)(nil)).Elem()
}

// A collection of values returned by getEbsVolumes.
type GetEbsVolumesResultOutput struct{ *pulumi.OutputState }

func (GetEbsVolumesResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*GetEbsVolumesResult)(nil)).Elem()
}

func (o GetEbsVolumesResultOutput) ToGetEbsVolumesResultOutput() GetEbsVolumesResultOutput {
	return o
}

func (o GetEbsVolumesResultOutput) ToGetEbsVolumesResultOutputWithContext(ctx context.Context) GetEbsVolumesResultOutput {
	return o
}

func (o GetEbsVolumesResultOutput) Filters() GetEbsVolumesFilterArrayOutput {
	return o.ApplyT(func(v GetEbsVolumesResult) []GetEbsVolumesFilter { return v.Filters }).(GetEbsVolumesFilterArrayOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o GetEbsVolumesResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v GetEbsVolumesResult) string { return v.Id }).(pulumi.StringOutput)
}

// Set of all the EBS Volume IDs found. This data source will fail if
// no volumes match the provided criteria.
func (o GetEbsVolumesResultOutput) Ids() pulumi.StringArrayOutput {
	return o.ApplyT(func(v GetEbsVolumesResult) []string { return v.Ids }).(pulumi.StringArrayOutput)
}

func (o GetEbsVolumesResultOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v GetEbsVolumesResult) map[string]string { return v.Tags }).(pulumi.StringMapOutput)
}

func init() {
	pulumi.RegisterOutputType(GetEbsVolumesResultOutput{})
}
