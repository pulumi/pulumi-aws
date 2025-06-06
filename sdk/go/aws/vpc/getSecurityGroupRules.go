// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package vpc

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// This resource can be useful for getting back a set of security group rule IDs.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/vpc"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
// func main() {
// pulumi.Run(func(ctx *pulumi.Context) error {
// _, err := vpc.GetSecurityGroupRules(ctx, &vpc.GetSecurityGroupRulesArgs{
// Filters: []vpc.GetSecurityGroupRulesFilter{
// {
// Name: "group-id",
// Values: interface{}{
// securityGroupId,
// },
// },
// },
// }, nil);
// if err != nil {
// return err
// }
// return nil
// })
// }
// ```
func GetSecurityGroupRules(ctx *pulumi.Context, args *GetSecurityGroupRulesArgs, opts ...pulumi.InvokeOption) (*GetSecurityGroupRulesResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv GetSecurityGroupRulesResult
	err := ctx.Invoke("aws:vpc/getSecurityGroupRules:getSecurityGroupRules", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getSecurityGroupRules.
type GetSecurityGroupRulesArgs struct {
	// Custom filter block as described below.
	Filters []GetSecurityGroupRulesFilter `pulumi:"filters"`
	// Map of tags, each pair of which must exactly match
	// a pair on the desired security group rule.
	Tags map[string]string `pulumi:"tags"`
}

// A collection of values returned by getSecurityGroupRules.
type GetSecurityGroupRulesResult struct {
	Filters []GetSecurityGroupRulesFilter `pulumi:"filters"`
	Id      string                        `pulumi:"id"`
	// List of all the security group rule IDs found.
	Ids  []string          `pulumi:"ids"`
	Tags map[string]string `pulumi:"tags"`
}

func GetSecurityGroupRulesOutput(ctx *pulumi.Context, args GetSecurityGroupRulesOutputArgs, opts ...pulumi.InvokeOption) GetSecurityGroupRulesResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (GetSecurityGroupRulesResultOutput, error) {
			args := v.(GetSecurityGroupRulesArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:vpc/getSecurityGroupRules:getSecurityGroupRules", args, GetSecurityGroupRulesResultOutput{}, options).(GetSecurityGroupRulesResultOutput), nil
		}).(GetSecurityGroupRulesResultOutput)
}

// A collection of arguments for invoking getSecurityGroupRules.
type GetSecurityGroupRulesOutputArgs struct {
	// Custom filter block as described below.
	Filters GetSecurityGroupRulesFilterArrayInput `pulumi:"filters"`
	// Map of tags, each pair of which must exactly match
	// a pair on the desired security group rule.
	Tags pulumi.StringMapInput `pulumi:"tags"`
}

func (GetSecurityGroupRulesOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*GetSecurityGroupRulesArgs)(nil)).Elem()
}

// A collection of values returned by getSecurityGroupRules.
type GetSecurityGroupRulesResultOutput struct{ *pulumi.OutputState }

func (GetSecurityGroupRulesResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*GetSecurityGroupRulesResult)(nil)).Elem()
}

func (o GetSecurityGroupRulesResultOutput) ToGetSecurityGroupRulesResultOutput() GetSecurityGroupRulesResultOutput {
	return o
}

func (o GetSecurityGroupRulesResultOutput) ToGetSecurityGroupRulesResultOutputWithContext(ctx context.Context) GetSecurityGroupRulesResultOutput {
	return o
}

func (o GetSecurityGroupRulesResultOutput) Filters() GetSecurityGroupRulesFilterArrayOutput {
	return o.ApplyT(func(v GetSecurityGroupRulesResult) []GetSecurityGroupRulesFilter { return v.Filters }).(GetSecurityGroupRulesFilterArrayOutput)
}

func (o GetSecurityGroupRulesResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v GetSecurityGroupRulesResult) string { return v.Id }).(pulumi.StringOutput)
}

// List of all the security group rule IDs found.
func (o GetSecurityGroupRulesResultOutput) Ids() pulumi.StringArrayOutput {
	return o.ApplyT(func(v GetSecurityGroupRulesResult) []string { return v.Ids }).(pulumi.StringArrayOutput)
}

func (o GetSecurityGroupRulesResultOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v GetSecurityGroupRulesResult) map[string]string { return v.Tags }).(pulumi.StringMapOutput)
}

func init() {
	pulumi.RegisterOutputType(GetSecurityGroupRulesResultOutput{})
}
