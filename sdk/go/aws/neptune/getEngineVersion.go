// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package neptune

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Information about a Neptune engine version.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/neptune"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := neptune.GetEngineVersion(ctx, &neptune.GetEngineVersionArgs{
//				PreferredVersions: []string{
//					"1.0.3.0",
//					"1.0.2.2",
//					"1.0.2.1",
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
func GetEngineVersion(ctx *pulumi.Context, args *GetEngineVersionArgs, opts ...pulumi.InvokeOption) (*GetEngineVersionResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv GetEngineVersionResult
	err := ctx.Invoke("aws:neptune/getEngineVersion:getEngineVersion", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getEngineVersion.
type GetEngineVersionArgs struct {
	// DB engine. (Default: `neptune`)
	Engine *string `pulumi:"engine"`
	// Name of a specific DB parameter group family. An example parameter group family is `neptune1`.
	ParameterGroupFamily *string `pulumi:"parameterGroupFamily"`
	// Ordered list of preferred engine versions. The first match in this list will be returned. If no preferred matches are found and the original search returned more than one result, an error is returned. If both the `version` and `preferredVersions` arguments are not configured, the data source will return the default version for the engine.
	PreferredVersions []string `pulumi:"preferredVersions"`
	// Version of the DB engine. For example, `1.0.1.0`, `1.0.2.2`, and `1.0.3.0`. If both the `version` and `preferredVersions` arguments are not configured, the data source will return the default version for the engine.
	Version *string `pulumi:"version"`
}

// A collection of values returned by getEngineVersion.
type GetEngineVersionResult struct {
	Engine *string `pulumi:"engine"`
	// Description of the database engine.
	EngineDescription string `pulumi:"engineDescription"`
	// Set of log types that the database engine has available for export to CloudWatch Logs.
	ExportableLogTypes []string `pulumi:"exportableLogTypes"`
	// The provider-assigned unique ID for this managed resource.
	Id                   string   `pulumi:"id"`
	ParameterGroupFamily string   `pulumi:"parameterGroupFamily"`
	PreferredVersions    []string `pulumi:"preferredVersions"`
	// Set of the time zones supported by this engine.
	SupportedTimezones []string `pulumi:"supportedTimezones"`
	// Indicates whether the engine version supports exporting the log types specified by `exportableLogTypes` to CloudWatch Logs.
	SupportsLogExportsToCloudwatch bool `pulumi:"supportsLogExportsToCloudwatch"`
	// Indicates whether the database engine version supports read replicas.
	SupportsReadReplica bool `pulumi:"supportsReadReplica"`
	// Set of engine versions that this database engine version can be upgraded to.
	ValidUpgradeTargets []string `pulumi:"validUpgradeTargets"`
	Version             string   `pulumi:"version"`
	// Description of the database engine version.
	VersionDescription string `pulumi:"versionDescription"`
}

func GetEngineVersionOutput(ctx *pulumi.Context, args GetEngineVersionOutputArgs, opts ...pulumi.InvokeOption) GetEngineVersionResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (GetEngineVersionResultOutput, error) {
			args := v.(GetEngineVersionArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:neptune/getEngineVersion:getEngineVersion", args, GetEngineVersionResultOutput{}, options).(GetEngineVersionResultOutput), nil
		}).(GetEngineVersionResultOutput)
}

// A collection of arguments for invoking getEngineVersion.
type GetEngineVersionOutputArgs struct {
	// DB engine. (Default: `neptune`)
	Engine pulumi.StringPtrInput `pulumi:"engine"`
	// Name of a specific DB parameter group family. An example parameter group family is `neptune1`.
	ParameterGroupFamily pulumi.StringPtrInput `pulumi:"parameterGroupFamily"`
	// Ordered list of preferred engine versions. The first match in this list will be returned. If no preferred matches are found and the original search returned more than one result, an error is returned. If both the `version` and `preferredVersions` arguments are not configured, the data source will return the default version for the engine.
	PreferredVersions pulumi.StringArrayInput `pulumi:"preferredVersions"`
	// Version of the DB engine. For example, `1.0.1.0`, `1.0.2.2`, and `1.0.3.0`. If both the `version` and `preferredVersions` arguments are not configured, the data source will return the default version for the engine.
	Version pulumi.StringPtrInput `pulumi:"version"`
}

func (GetEngineVersionOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*GetEngineVersionArgs)(nil)).Elem()
}

// A collection of values returned by getEngineVersion.
type GetEngineVersionResultOutput struct{ *pulumi.OutputState }

func (GetEngineVersionResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*GetEngineVersionResult)(nil)).Elem()
}

func (o GetEngineVersionResultOutput) ToGetEngineVersionResultOutput() GetEngineVersionResultOutput {
	return o
}

func (o GetEngineVersionResultOutput) ToGetEngineVersionResultOutputWithContext(ctx context.Context) GetEngineVersionResultOutput {
	return o
}

func (o GetEngineVersionResultOutput) Engine() pulumi.StringPtrOutput {
	return o.ApplyT(func(v GetEngineVersionResult) *string { return v.Engine }).(pulumi.StringPtrOutput)
}

// Description of the database engine.
func (o GetEngineVersionResultOutput) EngineDescription() pulumi.StringOutput {
	return o.ApplyT(func(v GetEngineVersionResult) string { return v.EngineDescription }).(pulumi.StringOutput)
}

// Set of log types that the database engine has available for export to CloudWatch Logs.
func (o GetEngineVersionResultOutput) ExportableLogTypes() pulumi.StringArrayOutput {
	return o.ApplyT(func(v GetEngineVersionResult) []string { return v.ExportableLogTypes }).(pulumi.StringArrayOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o GetEngineVersionResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v GetEngineVersionResult) string { return v.Id }).(pulumi.StringOutput)
}

func (o GetEngineVersionResultOutput) ParameterGroupFamily() pulumi.StringOutput {
	return o.ApplyT(func(v GetEngineVersionResult) string { return v.ParameterGroupFamily }).(pulumi.StringOutput)
}

func (o GetEngineVersionResultOutput) PreferredVersions() pulumi.StringArrayOutput {
	return o.ApplyT(func(v GetEngineVersionResult) []string { return v.PreferredVersions }).(pulumi.StringArrayOutput)
}

// Set of the time zones supported by this engine.
func (o GetEngineVersionResultOutput) SupportedTimezones() pulumi.StringArrayOutput {
	return o.ApplyT(func(v GetEngineVersionResult) []string { return v.SupportedTimezones }).(pulumi.StringArrayOutput)
}

// Indicates whether the engine version supports exporting the log types specified by `exportableLogTypes` to CloudWatch Logs.
func (o GetEngineVersionResultOutput) SupportsLogExportsToCloudwatch() pulumi.BoolOutput {
	return o.ApplyT(func(v GetEngineVersionResult) bool { return v.SupportsLogExportsToCloudwatch }).(pulumi.BoolOutput)
}

// Indicates whether the database engine version supports read replicas.
func (o GetEngineVersionResultOutput) SupportsReadReplica() pulumi.BoolOutput {
	return o.ApplyT(func(v GetEngineVersionResult) bool { return v.SupportsReadReplica }).(pulumi.BoolOutput)
}

// Set of engine versions that this database engine version can be upgraded to.
func (o GetEngineVersionResultOutput) ValidUpgradeTargets() pulumi.StringArrayOutput {
	return o.ApplyT(func(v GetEngineVersionResult) []string { return v.ValidUpgradeTargets }).(pulumi.StringArrayOutput)
}

func (o GetEngineVersionResultOutput) Version() pulumi.StringOutput {
	return o.ApplyT(func(v GetEngineVersionResult) string { return v.Version }).(pulumi.StringOutput)
}

// Description of the database engine version.
func (o GetEngineVersionResultOutput) VersionDescription() pulumi.StringOutput {
	return o.ApplyT(func(v GetEngineVersionResult) string { return v.VersionDescription }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(GetEngineVersionResultOutput{})
}
