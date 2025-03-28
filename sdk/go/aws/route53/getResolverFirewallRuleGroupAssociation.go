// Code generated by the Pulumi Terraform Bridge (tfgen) Tool DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package route53

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// `route53.ResolverFirewallRuleGroupAssociation` Retrieves the specified firewall rule group association.
//
// This data source allows to retrieve details about a specific a Route 53 Resolver DNS Firewall rule group association.
//
// ## Example Usage
//
// The following example shows how to get a firewall rule group association from its id.
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/route53"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := route53.LookupResolverFirewallRuleGroupAssociation(ctx, &route53.LookupResolverFirewallRuleGroupAssociationArgs{
//				FirewallRuleGroupAssociationId: "rslvr-frgassoc-example",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupResolverFirewallRuleGroupAssociation(ctx *pulumi.Context, args *LookupResolverFirewallRuleGroupAssociationArgs, opts ...pulumi.InvokeOption) (*LookupResolverFirewallRuleGroupAssociationResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupResolverFirewallRuleGroupAssociationResult
	err := ctx.Invoke("aws:route53/getResolverFirewallRuleGroupAssociation:getResolverFirewallRuleGroupAssociation", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getResolverFirewallRuleGroupAssociation.
type LookupResolverFirewallRuleGroupAssociationArgs struct {
	// The identifier for the association.
	//
	// The following attribute is additionally exported:
	FirewallRuleGroupAssociationId string `pulumi:"firewallRuleGroupAssociationId"`
}

// A collection of values returned by getResolverFirewallRuleGroupAssociation.
type LookupResolverFirewallRuleGroupAssociationResult struct {
	Arn                            string `pulumi:"arn"`
	CreationTime                   string `pulumi:"creationTime"`
	CreatorRequestId               string `pulumi:"creatorRequestId"`
	FirewallRuleGroupAssociationId string `pulumi:"firewallRuleGroupAssociationId"`
	FirewallRuleGroupId            string `pulumi:"firewallRuleGroupId"`
	// The provider-assigned unique ID for this managed resource.
	Id                 string `pulumi:"id"`
	ManagedOwnerName   string `pulumi:"managedOwnerName"`
	ModificationTime   string `pulumi:"modificationTime"`
	MutationProtection string `pulumi:"mutationProtection"`
	Name               string `pulumi:"name"`
	Priority           int    `pulumi:"priority"`
	Status             string `pulumi:"status"`
	StatusMessage      string `pulumi:"statusMessage"`
	VpcId              string `pulumi:"vpcId"`
}

func LookupResolverFirewallRuleGroupAssociationOutput(ctx *pulumi.Context, args LookupResolverFirewallRuleGroupAssociationOutputArgs, opts ...pulumi.InvokeOption) LookupResolverFirewallRuleGroupAssociationResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupResolverFirewallRuleGroupAssociationResultOutput, error) {
			args := v.(LookupResolverFirewallRuleGroupAssociationArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:route53/getResolverFirewallRuleGroupAssociation:getResolverFirewallRuleGroupAssociation", args, LookupResolverFirewallRuleGroupAssociationResultOutput{}, options).(LookupResolverFirewallRuleGroupAssociationResultOutput), nil
		}).(LookupResolverFirewallRuleGroupAssociationResultOutput)
}

// A collection of arguments for invoking getResolverFirewallRuleGroupAssociation.
type LookupResolverFirewallRuleGroupAssociationOutputArgs struct {
	// The identifier for the association.
	//
	// The following attribute is additionally exported:
	FirewallRuleGroupAssociationId pulumi.StringInput `pulumi:"firewallRuleGroupAssociationId"`
}

func (LookupResolverFirewallRuleGroupAssociationOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupResolverFirewallRuleGroupAssociationArgs)(nil)).Elem()
}

// A collection of values returned by getResolverFirewallRuleGroupAssociation.
type LookupResolverFirewallRuleGroupAssociationResultOutput struct{ *pulumi.OutputState }

func (LookupResolverFirewallRuleGroupAssociationResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupResolverFirewallRuleGroupAssociationResult)(nil)).Elem()
}

func (o LookupResolverFirewallRuleGroupAssociationResultOutput) ToLookupResolverFirewallRuleGroupAssociationResultOutput() LookupResolverFirewallRuleGroupAssociationResultOutput {
	return o
}

func (o LookupResolverFirewallRuleGroupAssociationResultOutput) ToLookupResolverFirewallRuleGroupAssociationResultOutputWithContext(ctx context.Context) LookupResolverFirewallRuleGroupAssociationResultOutput {
	return o
}

func (o LookupResolverFirewallRuleGroupAssociationResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupResolverFirewallRuleGroupAssociationResult) string { return v.Arn }).(pulumi.StringOutput)
}

func (o LookupResolverFirewallRuleGroupAssociationResultOutput) CreationTime() pulumi.StringOutput {
	return o.ApplyT(func(v LookupResolverFirewallRuleGroupAssociationResult) string { return v.CreationTime }).(pulumi.StringOutput)
}

func (o LookupResolverFirewallRuleGroupAssociationResultOutput) CreatorRequestId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupResolverFirewallRuleGroupAssociationResult) string { return v.CreatorRequestId }).(pulumi.StringOutput)
}

func (o LookupResolverFirewallRuleGroupAssociationResultOutput) FirewallRuleGroupAssociationId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupResolverFirewallRuleGroupAssociationResult) string {
		return v.FirewallRuleGroupAssociationId
	}).(pulumi.StringOutput)
}

func (o LookupResolverFirewallRuleGroupAssociationResultOutput) FirewallRuleGroupId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupResolverFirewallRuleGroupAssociationResult) string { return v.FirewallRuleGroupId }).(pulumi.StringOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o LookupResolverFirewallRuleGroupAssociationResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupResolverFirewallRuleGroupAssociationResult) string { return v.Id }).(pulumi.StringOutput)
}

func (o LookupResolverFirewallRuleGroupAssociationResultOutput) ManagedOwnerName() pulumi.StringOutput {
	return o.ApplyT(func(v LookupResolverFirewallRuleGroupAssociationResult) string { return v.ManagedOwnerName }).(pulumi.StringOutput)
}

func (o LookupResolverFirewallRuleGroupAssociationResultOutput) ModificationTime() pulumi.StringOutput {
	return o.ApplyT(func(v LookupResolverFirewallRuleGroupAssociationResult) string { return v.ModificationTime }).(pulumi.StringOutput)
}

func (o LookupResolverFirewallRuleGroupAssociationResultOutput) MutationProtection() pulumi.StringOutput {
	return o.ApplyT(func(v LookupResolverFirewallRuleGroupAssociationResult) string { return v.MutationProtection }).(pulumi.StringOutput)
}

func (o LookupResolverFirewallRuleGroupAssociationResultOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v LookupResolverFirewallRuleGroupAssociationResult) string { return v.Name }).(pulumi.StringOutput)
}

func (o LookupResolverFirewallRuleGroupAssociationResultOutput) Priority() pulumi.IntOutput {
	return o.ApplyT(func(v LookupResolverFirewallRuleGroupAssociationResult) int { return v.Priority }).(pulumi.IntOutput)
}

func (o LookupResolverFirewallRuleGroupAssociationResultOutput) Status() pulumi.StringOutput {
	return o.ApplyT(func(v LookupResolverFirewallRuleGroupAssociationResult) string { return v.Status }).(pulumi.StringOutput)
}

func (o LookupResolverFirewallRuleGroupAssociationResultOutput) StatusMessage() pulumi.StringOutput {
	return o.ApplyT(func(v LookupResolverFirewallRuleGroupAssociationResult) string { return v.StatusMessage }).(pulumi.StringOutput)
}

func (o LookupResolverFirewallRuleGroupAssociationResultOutput) VpcId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupResolverFirewallRuleGroupAssociationResult) string { return v.VpcId }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupResolverFirewallRuleGroupAssociationResultOutput{})
}
