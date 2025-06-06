// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package backup

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Use this data source to get information on an existing backup plan.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/backup"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := backup.LookupPlan(ctx, &backup.LookupPlanArgs{
//				PlanId: "my_example_backup_plan_id",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupPlan(ctx *pulumi.Context, args *LookupPlanArgs, opts ...pulumi.InvokeOption) (*LookupPlanResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupPlanResult
	err := ctx.Invoke("aws:backup/getPlan:getPlan", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getPlan.
type LookupPlanArgs struct {
	// Backup plan ID.
	PlanId string `pulumi:"planId"`
	// Metadata that you can assign to help organize the plans you create.
	Tags map[string]string `pulumi:"tags"`
}

// A collection of values returned by getPlan.
type LookupPlanResult struct {
	// ARN of the backup plan.
	Arn string `pulumi:"arn"`
	// The provider-assigned unique ID for this managed resource.
	Id string `pulumi:"id"`
	// Display name of a backup plan.
	Name   string `pulumi:"name"`
	PlanId string `pulumi:"planId"`
	// Rules of a backup plan.
	Rules []GetPlanRule `pulumi:"rules"`
	// Metadata that you can assign to help organize the plans you create.
	Tags map[string]string `pulumi:"tags"`
	// Unique, randomly generated, Unicode, UTF-8 encoded string that serves as the version ID of the backup plan.
	Version string `pulumi:"version"`
}

func LookupPlanOutput(ctx *pulumi.Context, args LookupPlanOutputArgs, opts ...pulumi.InvokeOption) LookupPlanResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupPlanResultOutput, error) {
			args := v.(LookupPlanArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:backup/getPlan:getPlan", args, LookupPlanResultOutput{}, options).(LookupPlanResultOutput), nil
		}).(LookupPlanResultOutput)
}

// A collection of arguments for invoking getPlan.
type LookupPlanOutputArgs struct {
	// Backup plan ID.
	PlanId pulumi.StringInput `pulumi:"planId"`
	// Metadata that you can assign to help organize the plans you create.
	Tags pulumi.StringMapInput `pulumi:"tags"`
}

func (LookupPlanOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupPlanArgs)(nil)).Elem()
}

// A collection of values returned by getPlan.
type LookupPlanResultOutput struct{ *pulumi.OutputState }

func (LookupPlanResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupPlanResult)(nil)).Elem()
}

func (o LookupPlanResultOutput) ToLookupPlanResultOutput() LookupPlanResultOutput {
	return o
}

func (o LookupPlanResultOutput) ToLookupPlanResultOutputWithContext(ctx context.Context) LookupPlanResultOutput {
	return o
}

// ARN of the backup plan.
func (o LookupPlanResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupPlanResult) string { return v.Arn }).(pulumi.StringOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o LookupPlanResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupPlanResult) string { return v.Id }).(pulumi.StringOutput)
}

// Display name of a backup plan.
func (o LookupPlanResultOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v LookupPlanResult) string { return v.Name }).(pulumi.StringOutput)
}

func (o LookupPlanResultOutput) PlanId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupPlanResult) string { return v.PlanId }).(pulumi.StringOutput)
}

// Rules of a backup plan.
func (o LookupPlanResultOutput) Rules() GetPlanRuleArrayOutput {
	return o.ApplyT(func(v LookupPlanResult) []GetPlanRule { return v.Rules }).(GetPlanRuleArrayOutput)
}

// Metadata that you can assign to help organize the plans you create.
func (o LookupPlanResultOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v LookupPlanResult) map[string]string { return v.Tags }).(pulumi.StringMapOutput)
}

// Unique, randomly generated, Unicode, UTF-8 encoded string that serves as the version ID of the backup plan.
func (o LookupPlanResultOutput) Version() pulumi.StringOutput {
	return o.ApplyT(func(v LookupPlanResult) string { return v.Version }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupPlanResultOutput{})
}
