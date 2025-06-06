// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package imagebuilder

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides details about an Image Builder Distribution Configuration.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/imagebuilder"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := imagebuilder.LookupDistributionConfiguration(ctx, &imagebuilder.LookupDistributionConfigurationArgs{
//				Arn: "arn:aws:imagebuilder:us-west-2:aws:distribution-configuration/example",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupDistributionConfiguration(ctx *pulumi.Context, args *LookupDistributionConfigurationArgs, opts ...pulumi.InvokeOption) (*LookupDistributionConfigurationResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupDistributionConfigurationResult
	err := ctx.Invoke("aws:imagebuilder/getDistributionConfiguration:getDistributionConfiguration", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getDistributionConfiguration.
type LookupDistributionConfigurationArgs struct {
	// ARN of the distribution configuration.
	Arn string `pulumi:"arn"`
	// Key-value map of resource tags for the distribution configuration.
	Tags map[string]string `pulumi:"tags"`
}

// A collection of values returned by getDistributionConfiguration.
type LookupDistributionConfigurationResult struct {
	Arn string `pulumi:"arn"`
	// Date the distribution configuration was created.
	DateCreated string `pulumi:"dateCreated"`
	// Date the distribution configuration was updated.
	DateUpdated string `pulumi:"dateUpdated"`
	// Description of the container distribution configuration.
	Description string `pulumi:"description"`
	// Set of distributions.
	Distributions []GetDistributionConfigurationDistribution `pulumi:"distributions"`
	// The provider-assigned unique ID for this managed resource.
	Id string `pulumi:"id"`
	// Name of the distribution configuration.
	Name string `pulumi:"name"`
	// Key-value map of resource tags for the distribution configuration.
	Tags map[string]string `pulumi:"tags"`
}

func LookupDistributionConfigurationOutput(ctx *pulumi.Context, args LookupDistributionConfigurationOutputArgs, opts ...pulumi.InvokeOption) LookupDistributionConfigurationResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupDistributionConfigurationResultOutput, error) {
			args := v.(LookupDistributionConfigurationArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:imagebuilder/getDistributionConfiguration:getDistributionConfiguration", args, LookupDistributionConfigurationResultOutput{}, options).(LookupDistributionConfigurationResultOutput), nil
		}).(LookupDistributionConfigurationResultOutput)
}

// A collection of arguments for invoking getDistributionConfiguration.
type LookupDistributionConfigurationOutputArgs struct {
	// ARN of the distribution configuration.
	Arn pulumi.StringInput `pulumi:"arn"`
	// Key-value map of resource tags for the distribution configuration.
	Tags pulumi.StringMapInput `pulumi:"tags"`
}

func (LookupDistributionConfigurationOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupDistributionConfigurationArgs)(nil)).Elem()
}

// A collection of values returned by getDistributionConfiguration.
type LookupDistributionConfigurationResultOutput struct{ *pulumi.OutputState }

func (LookupDistributionConfigurationResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupDistributionConfigurationResult)(nil)).Elem()
}

func (o LookupDistributionConfigurationResultOutput) ToLookupDistributionConfigurationResultOutput() LookupDistributionConfigurationResultOutput {
	return o
}

func (o LookupDistributionConfigurationResultOutput) ToLookupDistributionConfigurationResultOutputWithContext(ctx context.Context) LookupDistributionConfigurationResultOutput {
	return o
}

func (o LookupDistributionConfigurationResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDistributionConfigurationResult) string { return v.Arn }).(pulumi.StringOutput)
}

// Date the distribution configuration was created.
func (o LookupDistributionConfigurationResultOutput) DateCreated() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDistributionConfigurationResult) string { return v.DateCreated }).(pulumi.StringOutput)
}

// Date the distribution configuration was updated.
func (o LookupDistributionConfigurationResultOutput) DateUpdated() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDistributionConfigurationResult) string { return v.DateUpdated }).(pulumi.StringOutput)
}

// Description of the container distribution configuration.
func (o LookupDistributionConfigurationResultOutput) Description() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDistributionConfigurationResult) string { return v.Description }).(pulumi.StringOutput)
}

// Set of distributions.
func (o LookupDistributionConfigurationResultOutput) Distributions() GetDistributionConfigurationDistributionArrayOutput {
	return o.ApplyT(func(v LookupDistributionConfigurationResult) []GetDistributionConfigurationDistribution {
		return v.Distributions
	}).(GetDistributionConfigurationDistributionArrayOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o LookupDistributionConfigurationResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDistributionConfigurationResult) string { return v.Id }).(pulumi.StringOutput)
}

// Name of the distribution configuration.
func (o LookupDistributionConfigurationResultOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDistributionConfigurationResult) string { return v.Name }).(pulumi.StringOutput)
}

// Key-value map of resource tags for the distribution configuration.
func (o LookupDistributionConfigurationResultOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v LookupDistributionConfigurationResult) map[string]string { return v.Tags }).(pulumi.StringMapOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupDistributionConfigurationResultOutput{})
}
