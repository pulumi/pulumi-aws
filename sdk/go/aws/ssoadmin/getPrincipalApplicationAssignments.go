// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package ssoadmin

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Data source for viewing AWS SSO Admin Principal Application Assignments.
//
// ## Example Usage
//
// ### Basic Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/ssoadmin"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := ssoadmin.GetPrincipalApplicationAssignments(ctx, &ssoadmin.GetPrincipalApplicationAssignmentsArgs{
//				InstanceArn:   test.Arns[0],
//				PrincipalId:   testAwsIdentitystoreUser.UserId,
//				PrincipalType: "USER",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func GetPrincipalApplicationAssignments(ctx *pulumi.Context, args *GetPrincipalApplicationAssignmentsArgs, opts ...pulumi.InvokeOption) (*GetPrincipalApplicationAssignmentsResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv GetPrincipalApplicationAssignmentsResult
	err := ctx.Invoke("aws:ssoadmin/getPrincipalApplicationAssignments:getPrincipalApplicationAssignments", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getPrincipalApplicationAssignments.
type GetPrincipalApplicationAssignmentsArgs struct {
	// List of principals assigned to the application. See the `applicationAssignments` attribute reference below.
	ApplicationAssignments []GetPrincipalApplicationAssignmentsApplicationAssignment `pulumi:"applicationAssignments"`
	// ARN of the instance of IAM Identity Center.
	InstanceArn string `pulumi:"instanceArn"`
	// An identifier for an object in IAM Identity Center, such as a user or group.
	PrincipalId string `pulumi:"principalId"`
	// Entity type for which the assignment will be created. Valid values are `USER` or `GROUP`.
	PrincipalType string `pulumi:"principalType"`
}

// A collection of values returned by getPrincipalApplicationAssignments.
type GetPrincipalApplicationAssignmentsResult struct {
	// List of principals assigned to the application. See the `applicationAssignments` attribute reference below.
	ApplicationAssignments []GetPrincipalApplicationAssignmentsApplicationAssignment `pulumi:"applicationAssignments"`
	Id                     string                                                    `pulumi:"id"`
	InstanceArn            string                                                    `pulumi:"instanceArn"`
	// An identifier for an object in IAM Identity Center, such as a user or group.
	PrincipalId string `pulumi:"principalId"`
	// Entity type for which the assignment will be created. Valid values are `USER` or `GROUP`.
	PrincipalType string `pulumi:"principalType"`
}

func GetPrincipalApplicationAssignmentsOutput(ctx *pulumi.Context, args GetPrincipalApplicationAssignmentsOutputArgs, opts ...pulumi.InvokeOption) GetPrincipalApplicationAssignmentsResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (GetPrincipalApplicationAssignmentsResultOutput, error) {
			args := v.(GetPrincipalApplicationAssignmentsArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:ssoadmin/getPrincipalApplicationAssignments:getPrincipalApplicationAssignments", args, GetPrincipalApplicationAssignmentsResultOutput{}, options).(GetPrincipalApplicationAssignmentsResultOutput), nil
		}).(GetPrincipalApplicationAssignmentsResultOutput)
}

// A collection of arguments for invoking getPrincipalApplicationAssignments.
type GetPrincipalApplicationAssignmentsOutputArgs struct {
	// List of principals assigned to the application. See the `applicationAssignments` attribute reference below.
	ApplicationAssignments GetPrincipalApplicationAssignmentsApplicationAssignmentArrayInput `pulumi:"applicationAssignments"`
	// ARN of the instance of IAM Identity Center.
	InstanceArn pulumi.StringInput `pulumi:"instanceArn"`
	// An identifier for an object in IAM Identity Center, such as a user or group.
	PrincipalId pulumi.StringInput `pulumi:"principalId"`
	// Entity type for which the assignment will be created. Valid values are `USER` or `GROUP`.
	PrincipalType pulumi.StringInput `pulumi:"principalType"`
}

func (GetPrincipalApplicationAssignmentsOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*GetPrincipalApplicationAssignmentsArgs)(nil)).Elem()
}

// A collection of values returned by getPrincipalApplicationAssignments.
type GetPrincipalApplicationAssignmentsResultOutput struct{ *pulumi.OutputState }

func (GetPrincipalApplicationAssignmentsResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*GetPrincipalApplicationAssignmentsResult)(nil)).Elem()
}

func (o GetPrincipalApplicationAssignmentsResultOutput) ToGetPrincipalApplicationAssignmentsResultOutput() GetPrincipalApplicationAssignmentsResultOutput {
	return o
}

func (o GetPrincipalApplicationAssignmentsResultOutput) ToGetPrincipalApplicationAssignmentsResultOutputWithContext(ctx context.Context) GetPrincipalApplicationAssignmentsResultOutput {
	return o
}

// List of principals assigned to the application. See the `applicationAssignments` attribute reference below.
func (o GetPrincipalApplicationAssignmentsResultOutput) ApplicationAssignments() GetPrincipalApplicationAssignmentsApplicationAssignmentArrayOutput {
	return o.ApplyT(func(v GetPrincipalApplicationAssignmentsResult) []GetPrincipalApplicationAssignmentsApplicationAssignment {
		return v.ApplicationAssignments
	}).(GetPrincipalApplicationAssignmentsApplicationAssignmentArrayOutput)
}

func (o GetPrincipalApplicationAssignmentsResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v GetPrincipalApplicationAssignmentsResult) string { return v.Id }).(pulumi.StringOutput)
}

func (o GetPrincipalApplicationAssignmentsResultOutput) InstanceArn() pulumi.StringOutput {
	return o.ApplyT(func(v GetPrincipalApplicationAssignmentsResult) string { return v.InstanceArn }).(pulumi.StringOutput)
}

// An identifier for an object in IAM Identity Center, such as a user or group.
func (o GetPrincipalApplicationAssignmentsResultOutput) PrincipalId() pulumi.StringOutput {
	return o.ApplyT(func(v GetPrincipalApplicationAssignmentsResult) string { return v.PrincipalId }).(pulumi.StringOutput)
}

// Entity type for which the assignment will be created. Valid values are `USER` or `GROUP`.
func (o GetPrincipalApplicationAssignmentsResultOutput) PrincipalType() pulumi.StringOutput {
	return o.ApplyT(func(v GetPrincipalApplicationAssignmentsResult) string { return v.PrincipalType }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(GetPrincipalApplicationAssignmentsResultOutput{})
}
