// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package kendra

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides details about a specific Amazon Kendra Experience.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/kendra"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := kendra.LookupExperience(ctx, &kendra.LookupExperienceArgs{
//				ExperienceId: "87654321-1234-4321-4321-321987654321",
//				IndexId:      "12345678-1234-1234-1234-123456789123",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupExperience(ctx *pulumi.Context, args *LookupExperienceArgs, opts ...pulumi.InvokeOption) (*LookupExperienceResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupExperienceResult
	err := ctx.Invoke("aws:kendra/getExperience:getExperience", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getExperience.
type LookupExperienceArgs struct {
	// Identifier of the Experience.
	ExperienceId string `pulumi:"experienceId"`
	// Identifier of the index that contains the Experience.
	IndexId string `pulumi:"indexId"`
}

// A collection of values returned by getExperience.
type LookupExperienceResult struct {
	// ARN of the Experience.
	Arn string `pulumi:"arn"`
	// Block that specifies the configuration information for your Amazon Kendra Experience. This includes `contentSourceConfiguration`, which specifies the data source IDs and/or FAQ IDs, and `userIdentityConfiguration`, which specifies the user or group information to grant access to your Amazon Kendra Experience. Documented below.
	Configurations []GetExperienceConfiguration `pulumi:"configurations"`
	// Unix datetime that the Experience was created.
	CreatedAt string `pulumi:"createdAt"`
	// Description of the Experience.
	Description string `pulumi:"description"`
	// Shows the endpoint URLs for your Amazon Kendra Experiences. The URLs are unique and fully hosted by AWS. Documented below.
	Endpoints []GetExperienceEndpoint `pulumi:"endpoints"`
	// Reason your Amazon Kendra Experience could not properly process.
	ErrorMessage string `pulumi:"errorMessage"`
	ExperienceId string `pulumi:"experienceId"`
	// The provider-assigned unique ID for this managed resource.
	Id      string `pulumi:"id"`
	IndexId string `pulumi:"indexId"`
	// Name of the Experience.
	Name string `pulumi:"name"`
	// Shows the ARN of a role with permission to access `Query` API, `QuerySuggestions` API, `SubmitFeedback` API, and AWS SSO that stores your user and group information.
	RoleArn string `pulumi:"roleArn"`
	// Current processing status of your Amazon Kendra Experience. When the status is `ACTIVE`, your Amazon Kendra Experience is ready to use. When the status is `FAILED`, the `errorMessage` field contains the reason that this failed.
	Status string `pulumi:"status"`
	// Date and time that the Experience was last updated.
	UpdatedAt string `pulumi:"updatedAt"`
}

func LookupExperienceOutput(ctx *pulumi.Context, args LookupExperienceOutputArgs, opts ...pulumi.InvokeOption) LookupExperienceResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupExperienceResultOutput, error) {
			args := v.(LookupExperienceArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:kendra/getExperience:getExperience", args, LookupExperienceResultOutput{}, options).(LookupExperienceResultOutput), nil
		}).(LookupExperienceResultOutput)
}

// A collection of arguments for invoking getExperience.
type LookupExperienceOutputArgs struct {
	// Identifier of the Experience.
	ExperienceId pulumi.StringInput `pulumi:"experienceId"`
	// Identifier of the index that contains the Experience.
	IndexId pulumi.StringInput `pulumi:"indexId"`
}

func (LookupExperienceOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupExperienceArgs)(nil)).Elem()
}

// A collection of values returned by getExperience.
type LookupExperienceResultOutput struct{ *pulumi.OutputState }

func (LookupExperienceResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupExperienceResult)(nil)).Elem()
}

func (o LookupExperienceResultOutput) ToLookupExperienceResultOutput() LookupExperienceResultOutput {
	return o
}

func (o LookupExperienceResultOutput) ToLookupExperienceResultOutputWithContext(ctx context.Context) LookupExperienceResultOutput {
	return o
}

// ARN of the Experience.
func (o LookupExperienceResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupExperienceResult) string { return v.Arn }).(pulumi.StringOutput)
}

// Block that specifies the configuration information for your Amazon Kendra Experience. This includes `contentSourceConfiguration`, which specifies the data source IDs and/or FAQ IDs, and `userIdentityConfiguration`, which specifies the user or group information to grant access to your Amazon Kendra Experience. Documented below.
func (o LookupExperienceResultOutput) Configurations() GetExperienceConfigurationArrayOutput {
	return o.ApplyT(func(v LookupExperienceResult) []GetExperienceConfiguration { return v.Configurations }).(GetExperienceConfigurationArrayOutput)
}

// Unix datetime that the Experience was created.
func (o LookupExperienceResultOutput) CreatedAt() pulumi.StringOutput {
	return o.ApplyT(func(v LookupExperienceResult) string { return v.CreatedAt }).(pulumi.StringOutput)
}

// Description of the Experience.
func (o LookupExperienceResultOutput) Description() pulumi.StringOutput {
	return o.ApplyT(func(v LookupExperienceResult) string { return v.Description }).(pulumi.StringOutput)
}

// Shows the endpoint URLs for your Amazon Kendra Experiences. The URLs are unique and fully hosted by AWS. Documented below.
func (o LookupExperienceResultOutput) Endpoints() GetExperienceEndpointArrayOutput {
	return o.ApplyT(func(v LookupExperienceResult) []GetExperienceEndpoint { return v.Endpoints }).(GetExperienceEndpointArrayOutput)
}

// Reason your Amazon Kendra Experience could not properly process.
func (o LookupExperienceResultOutput) ErrorMessage() pulumi.StringOutput {
	return o.ApplyT(func(v LookupExperienceResult) string { return v.ErrorMessage }).(pulumi.StringOutput)
}

func (o LookupExperienceResultOutput) ExperienceId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupExperienceResult) string { return v.ExperienceId }).(pulumi.StringOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o LookupExperienceResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupExperienceResult) string { return v.Id }).(pulumi.StringOutput)
}

func (o LookupExperienceResultOutput) IndexId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupExperienceResult) string { return v.IndexId }).(pulumi.StringOutput)
}

// Name of the Experience.
func (o LookupExperienceResultOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v LookupExperienceResult) string { return v.Name }).(pulumi.StringOutput)
}

// Shows the ARN of a role with permission to access `Query` API, `QuerySuggestions` API, `SubmitFeedback` API, and AWS SSO that stores your user and group information.
func (o LookupExperienceResultOutput) RoleArn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupExperienceResult) string { return v.RoleArn }).(pulumi.StringOutput)
}

// Current processing status of your Amazon Kendra Experience. When the status is `ACTIVE`, your Amazon Kendra Experience is ready to use. When the status is `FAILED`, the `errorMessage` field contains the reason that this failed.
func (o LookupExperienceResultOutput) Status() pulumi.StringOutput {
	return o.ApplyT(func(v LookupExperienceResult) string { return v.Status }).(pulumi.StringOutput)
}

// Date and time that the Experience was last updated.
func (o LookupExperienceResultOutput) UpdatedAt() pulumi.StringOutput {
	return o.ApplyT(func(v LookupExperienceResult) string { return v.UpdatedAt }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupExperienceResultOutput{})
}
