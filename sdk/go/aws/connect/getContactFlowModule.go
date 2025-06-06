// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package connect

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides details about a specific Amazon Connect Contact Flow Module.
//
// ## Example Usage
//
// By `name`
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/connect"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := connect.LookupContactFlowModule(ctx, &connect.LookupContactFlowModuleArgs{
//				InstanceId: "aaaaaaaa-bbbb-cccc-dddd-111111111111",
//				Name:       pulumi.StringRef("example"),
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
// By `contactFlowModuleId`
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/connect"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := connect.LookupContactFlowModule(ctx, &connect.LookupContactFlowModuleArgs{
//				InstanceId:          "aaaaaaaa-bbbb-cccc-dddd-111111111111",
//				ContactFlowModuleId: pulumi.StringRef("cccccccc-bbbb-cccc-dddd-111111111111"),
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupContactFlowModule(ctx *pulumi.Context, args *LookupContactFlowModuleArgs, opts ...pulumi.InvokeOption) (*LookupContactFlowModuleResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupContactFlowModuleResult
	err := ctx.Invoke("aws:connect/getContactFlowModule:getContactFlowModule", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getContactFlowModule.
type LookupContactFlowModuleArgs struct {
	// Returns information on a specific Contact Flow Module by contact flow module id
	ContactFlowModuleId *string `pulumi:"contactFlowModuleId"`
	// Reference to the hosting Amazon Connect Instance
	InstanceId string `pulumi:"instanceId"`
	// Returns information on a specific Contact Flow Module by name
	//
	// > **NOTE:** `instanceId` and one of either `name` or `contactFlowModuleId` is required.
	Name *string `pulumi:"name"`
	// Map of tags to assign to the Contact Flow Module.
	Tags map[string]string `pulumi:"tags"`
}

// A collection of values returned by getContactFlowModule.
type LookupContactFlowModuleResult struct {
	// ARN of the Contact Flow Module.
	Arn                 string `pulumi:"arn"`
	ContactFlowModuleId string `pulumi:"contactFlowModuleId"`
	// Logic of the Contact Flow Module.
	Content string `pulumi:"content"`
	// Description of the Contact Flow Module.
	Description string `pulumi:"description"`
	// The provider-assigned unique ID for this managed resource.
	Id         string `pulumi:"id"`
	InstanceId string `pulumi:"instanceId"`
	Name       string `pulumi:"name"`
	// Type of Contact Flow Module Module. Values are either `ACTIVE` or `ARCHIVED`.
	State string `pulumi:"state"`
	// Status of the Contact Flow Module Module. Values are either `PUBLISHED` or `SAVED`.
	Status string `pulumi:"status"`
	// Map of tags to assign to the Contact Flow Module.
	Tags map[string]string `pulumi:"tags"`
}

func LookupContactFlowModuleOutput(ctx *pulumi.Context, args LookupContactFlowModuleOutputArgs, opts ...pulumi.InvokeOption) LookupContactFlowModuleResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupContactFlowModuleResultOutput, error) {
			args := v.(LookupContactFlowModuleArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:connect/getContactFlowModule:getContactFlowModule", args, LookupContactFlowModuleResultOutput{}, options).(LookupContactFlowModuleResultOutput), nil
		}).(LookupContactFlowModuleResultOutput)
}

// A collection of arguments for invoking getContactFlowModule.
type LookupContactFlowModuleOutputArgs struct {
	// Returns information on a specific Contact Flow Module by contact flow module id
	ContactFlowModuleId pulumi.StringPtrInput `pulumi:"contactFlowModuleId"`
	// Reference to the hosting Amazon Connect Instance
	InstanceId pulumi.StringInput `pulumi:"instanceId"`
	// Returns information on a specific Contact Flow Module by name
	//
	// > **NOTE:** `instanceId` and one of either `name` or `contactFlowModuleId` is required.
	Name pulumi.StringPtrInput `pulumi:"name"`
	// Map of tags to assign to the Contact Flow Module.
	Tags pulumi.StringMapInput `pulumi:"tags"`
}

func (LookupContactFlowModuleOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupContactFlowModuleArgs)(nil)).Elem()
}

// A collection of values returned by getContactFlowModule.
type LookupContactFlowModuleResultOutput struct{ *pulumi.OutputState }

func (LookupContactFlowModuleResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupContactFlowModuleResult)(nil)).Elem()
}

func (o LookupContactFlowModuleResultOutput) ToLookupContactFlowModuleResultOutput() LookupContactFlowModuleResultOutput {
	return o
}

func (o LookupContactFlowModuleResultOutput) ToLookupContactFlowModuleResultOutputWithContext(ctx context.Context) LookupContactFlowModuleResultOutput {
	return o
}

// ARN of the Contact Flow Module.
func (o LookupContactFlowModuleResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupContactFlowModuleResult) string { return v.Arn }).(pulumi.StringOutput)
}

func (o LookupContactFlowModuleResultOutput) ContactFlowModuleId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupContactFlowModuleResult) string { return v.ContactFlowModuleId }).(pulumi.StringOutput)
}

// Logic of the Contact Flow Module.
func (o LookupContactFlowModuleResultOutput) Content() pulumi.StringOutput {
	return o.ApplyT(func(v LookupContactFlowModuleResult) string { return v.Content }).(pulumi.StringOutput)
}

// Description of the Contact Flow Module.
func (o LookupContactFlowModuleResultOutput) Description() pulumi.StringOutput {
	return o.ApplyT(func(v LookupContactFlowModuleResult) string { return v.Description }).(pulumi.StringOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o LookupContactFlowModuleResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupContactFlowModuleResult) string { return v.Id }).(pulumi.StringOutput)
}

func (o LookupContactFlowModuleResultOutput) InstanceId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupContactFlowModuleResult) string { return v.InstanceId }).(pulumi.StringOutput)
}

func (o LookupContactFlowModuleResultOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v LookupContactFlowModuleResult) string { return v.Name }).(pulumi.StringOutput)
}

// Type of Contact Flow Module Module. Values are either `ACTIVE` or `ARCHIVED`.
func (o LookupContactFlowModuleResultOutput) State() pulumi.StringOutput {
	return o.ApplyT(func(v LookupContactFlowModuleResult) string { return v.State }).(pulumi.StringOutput)
}

// Status of the Contact Flow Module Module. Values are either `PUBLISHED` or `SAVED`.
func (o LookupContactFlowModuleResultOutput) Status() pulumi.StringOutput {
	return o.ApplyT(func(v LookupContactFlowModuleResult) string { return v.Status }).(pulumi.StringOutput)
}

// Map of tags to assign to the Contact Flow Module.
func (o LookupContactFlowModuleResultOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v LookupContactFlowModuleResult) map[string]string { return v.Tags }).(pulumi.StringMapOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupContactFlowModuleResultOutput{})
}
