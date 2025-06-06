// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package elasticache

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides information about a ElastiCache Subnet Group.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/elasticache"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := elasticache.LookupSubnetGroup(ctx, &elasticache.LookupSubnetGroupArgs{
//				Name: "my-subnet-group",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupSubnetGroup(ctx *pulumi.Context, args *LookupSubnetGroupArgs, opts ...pulumi.InvokeOption) (*LookupSubnetGroupResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupSubnetGroupResult
	err := ctx.Invoke("aws:elasticache/getSubnetGroup:getSubnetGroup", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getSubnetGroup.
type LookupSubnetGroupArgs struct {
	// Name of the subnet group.
	Name string `pulumi:"name"`
	// Map of tags assigned to the subnet group.
	Tags map[string]string `pulumi:"tags"`
}

// A collection of values returned by getSubnetGroup.
type LookupSubnetGroupResult struct {
	// ARN of the subnet group.
	Arn string `pulumi:"arn"`
	// Description of the subnet group.
	Description string `pulumi:"description"`
	// The provider-assigned unique ID for this managed resource.
	Id   string `pulumi:"id"`
	Name string `pulumi:"name"`
	// Set of VPC Subnet ID-s of the subnet group.
	SubnetIds []string `pulumi:"subnetIds"`
	// Map of tags assigned to the subnet group.
	Tags map[string]string `pulumi:"tags"`
	// The Amazon Virtual Private Cloud identifier (VPC ID) of the cache subnet group.
	VpcId string `pulumi:"vpcId"`
}

func LookupSubnetGroupOutput(ctx *pulumi.Context, args LookupSubnetGroupOutputArgs, opts ...pulumi.InvokeOption) LookupSubnetGroupResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupSubnetGroupResultOutput, error) {
			args := v.(LookupSubnetGroupArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:elasticache/getSubnetGroup:getSubnetGroup", args, LookupSubnetGroupResultOutput{}, options).(LookupSubnetGroupResultOutput), nil
		}).(LookupSubnetGroupResultOutput)
}

// A collection of arguments for invoking getSubnetGroup.
type LookupSubnetGroupOutputArgs struct {
	// Name of the subnet group.
	Name pulumi.StringInput `pulumi:"name"`
	// Map of tags assigned to the subnet group.
	Tags pulumi.StringMapInput `pulumi:"tags"`
}

func (LookupSubnetGroupOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupSubnetGroupArgs)(nil)).Elem()
}

// A collection of values returned by getSubnetGroup.
type LookupSubnetGroupResultOutput struct{ *pulumi.OutputState }

func (LookupSubnetGroupResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupSubnetGroupResult)(nil)).Elem()
}

func (o LookupSubnetGroupResultOutput) ToLookupSubnetGroupResultOutput() LookupSubnetGroupResultOutput {
	return o
}

func (o LookupSubnetGroupResultOutput) ToLookupSubnetGroupResultOutputWithContext(ctx context.Context) LookupSubnetGroupResultOutput {
	return o
}

// ARN of the subnet group.
func (o LookupSubnetGroupResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupSubnetGroupResult) string { return v.Arn }).(pulumi.StringOutput)
}

// Description of the subnet group.
func (o LookupSubnetGroupResultOutput) Description() pulumi.StringOutput {
	return o.ApplyT(func(v LookupSubnetGroupResult) string { return v.Description }).(pulumi.StringOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o LookupSubnetGroupResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupSubnetGroupResult) string { return v.Id }).(pulumi.StringOutput)
}

func (o LookupSubnetGroupResultOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v LookupSubnetGroupResult) string { return v.Name }).(pulumi.StringOutput)
}

// Set of VPC Subnet ID-s of the subnet group.
func (o LookupSubnetGroupResultOutput) SubnetIds() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupSubnetGroupResult) []string { return v.SubnetIds }).(pulumi.StringArrayOutput)
}

// Map of tags assigned to the subnet group.
func (o LookupSubnetGroupResultOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v LookupSubnetGroupResult) map[string]string { return v.Tags }).(pulumi.StringMapOutput)
}

// The Amazon Virtual Private Cloud identifier (VPC ID) of the cache subnet group.
func (o LookupSubnetGroupResultOutput) VpcId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupSubnetGroupResult) string { return v.VpcId }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupSubnetGroupResultOutput{})
}
