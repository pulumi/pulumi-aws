// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package cloudformation

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// ## Example Usage
//
// ### Basic Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/cloudformation"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := cloudformation.NewStackInstances(ctx, "example", &cloudformation.StackInstancesArgs{
//				Accounts: pulumi.StringArray{
//					pulumi.String("123456789012"),
//					pulumi.String("234567890123"),
//				},
//				Regions: pulumi.StringArray{
//					pulumi.String("us-east-1"),
//					pulumi.String("us-west-2"),
//				},
//				StackSetName: pulumi.Any(exampleAwsCloudformationStackSet.Name),
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// ### Example IAM Setup in Target Account
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/iam"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
// func main() {
// pulumi.Run(func(ctx *pulumi.Context) error {
// aWSCloudFormationStackSetExecutionRoleAssumeRolePolicy, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
// Statements: []iam.GetPolicyDocumentStatement{
// {
// Actions: []string{
// "sts:AssumeRole",
// },
// Effect: pulumi.StringRef("Allow"),
// Principals: []iam.GetPolicyDocumentStatementPrincipal{
// {
// Identifiers: interface{}{
// aWSCloudFormationStackSetAdministrationRole.Arn,
// },
// Type: "AWS",
// },
// },
// },
// },
// }, nil);
// if err != nil {
// return err
// }
// aWSCloudFormationStackSetExecutionRole, err := iam.NewRole(ctx, "AWSCloudFormationStackSetExecutionRole", &iam.RoleArgs{
// AssumeRolePolicy: pulumi.String(aWSCloudFormationStackSetExecutionRoleAssumeRolePolicy.Json),
// Name: pulumi.String("AWSCloudFormationStackSetExecutionRole"),
// })
// if err != nil {
// return err
// }
// // Documentation: https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/stacksets-prereqs.html
// // Additional IAM permissions necessary depend on the resources defined in the StackSet template
// aWSCloudFormationStackSetExecutionRoleMinimumExecutionPolicy, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
// Statements: []iam.GetPolicyDocumentStatement{
// {
// Actions: []string{
// "cloudformation:*",
// "s3:*",
// "sns:*",
// },
// Effect: pulumi.StringRef("Allow"),
// Resources: []string{
// "*",
// },
// },
// },
// }, nil);
// if err != nil {
// return err
// }
// _, err = iam.NewRolePolicy(ctx, "AWSCloudFormationStackSetExecutionRole_MinimumExecutionPolicy", &iam.RolePolicyArgs{
// Name: pulumi.String("MinimumExecutionPolicy"),
// Policy: pulumi.String(aWSCloudFormationStackSetExecutionRoleMinimumExecutionPolicy.Json),
// Role: aWSCloudFormationStackSetExecutionRole.Name,
// })
// if err != nil {
// return err
// }
// return nil
// })
// }
// ```
//
// ### Example Deployment across Organizations account
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/cloudformation"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := cloudformation.NewStackInstances(ctx, "example", &cloudformation.StackInstancesArgs{
//				DeploymentTargets: &cloudformation.StackInstancesDeploymentTargetsArgs{
//					OrganizationalUnitIds: pulumi.StringArray{
//						exampleAwsOrganizationsOrganization.Roots[0].Id,
//					},
//				},
//				Regions: pulumi.StringArray{
//					pulumi.String("us-west-2"),
//					pulumi.String("us-east-1"),
//				},
//				StackSetName: pulumi.Any(exampleAwsCloudformationStackSet.Name),
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// ## Import
//
// Import CloudFormation stack instances that target OUs, using the stack set name, `call_as`, and "OU" separated by commas (`,`). For example:
//
// Using `pulumi import`, import CloudFormation stack instances using the stack set name and `call_as` separated by commas (`,`). If you are importing a stack instance targeting OUs, see the example below. For example:
//
// ```sh
// $ pulumi import aws:cloudformation/stackInstances:StackInstances example example,SELF
// ```
// Using `pulumi import`, Import CloudFormation stack instances that target OUs, using the stack set name, `call_as`, and "OU" separated by commas (`,`). For example:
//
// ```sh
// $ pulumi import aws:cloudformation/stackInstances:StackInstances example example,SELF,OU
// ```
type StackInstances struct {
	pulumi.CustomResourceState

	// Accounts where you want to create stack instances in the specified `regions`. You can specify either `accounts` or `deploymentTargets`, but not both.
	Accounts pulumi.StringArrayOutput `pulumi:"accounts"`
	// Whether you are acting as an account administrator in the organization's management account or as a delegated administrator in a member account. Valid values: `SELF` (default), `DELEGATED_ADMIN`.
	CallAs pulumi.StringPtrOutput `pulumi:"callAs"`
	// AWS Organizations accounts for which to create stack instances in the `regions`. stack sets doesn't deploy stack instances to the organization management account, even if the organization management account is in your organization or in an OU in your organization. Drift detection is not possible for most of this argument. See deploymentTargets below.
	DeploymentTargets StackInstancesDeploymentTargetsPtrOutput `pulumi:"deploymentTargets"`
	// Preferences for how AWS CloudFormation performs a stack set operation. See operationPreferences below.
	OperationPreferences StackInstancesOperationPreferencesPtrOutput `pulumi:"operationPreferences"`
	// Key-value map of input parameters to override from the stack set for these instances. This argument's drift detection is limited to the first account and region since each instance can have unique parameters.
	ParameterOverrides pulumi.StringMapOutput `pulumi:"parameterOverrides"`
	// Regions where you want to create stack instances in the specified `accounts`.
	Regions pulumi.StringArrayOutput `pulumi:"regions"`
	// Whether to remove the stack instances from the stack set, but not delete the stacks. You can't reassociate a retained stack or add an existing, saved stack to a new stack set. To retain the stack, ensure `retainStacks = true` has been successfully applied _before_ an apply that would destroy the resource. Defaults to `false`.
	RetainStacks pulumi.BoolPtrOutput `pulumi:"retainStacks"`
	// List of stack instances created from an organizational unit deployment target. This may not always be set depending on whether CloudFormation returns summaries for your configuration. See `stackInstanceSummaries`.
	StackInstanceSummaries StackInstancesStackInstanceSummaryArrayOutput `pulumi:"stackInstanceSummaries"`
	// Name or unique ID of the stack set that the stack instance is associated with.
	StackSetId pulumi.StringOutput `pulumi:"stackSetId"`
	// Name of the stack set.
	//
	// The following arguments are optional:
	StackSetName pulumi.StringOutput `pulumi:"stackSetName"`
}

// NewStackInstances registers a new resource with the given unique name, arguments, and options.
func NewStackInstances(ctx *pulumi.Context,
	name string, args *StackInstancesArgs, opts ...pulumi.ResourceOption) (*StackInstances, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.StackSetName == nil {
		return nil, errors.New("invalid value for required argument 'StackSetName'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource StackInstances
	err := ctx.RegisterResource("aws:cloudformation/stackInstances:StackInstances", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetStackInstances gets an existing StackInstances resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetStackInstances(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *StackInstancesState, opts ...pulumi.ResourceOption) (*StackInstances, error) {
	var resource StackInstances
	err := ctx.ReadResource("aws:cloudformation/stackInstances:StackInstances", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering StackInstances resources.
type stackInstancesState struct {
	// Accounts where you want to create stack instances in the specified `regions`. You can specify either `accounts` or `deploymentTargets`, but not both.
	Accounts []string `pulumi:"accounts"`
	// Whether you are acting as an account administrator in the organization's management account or as a delegated administrator in a member account. Valid values: `SELF` (default), `DELEGATED_ADMIN`.
	CallAs *string `pulumi:"callAs"`
	// AWS Organizations accounts for which to create stack instances in the `regions`. stack sets doesn't deploy stack instances to the organization management account, even if the organization management account is in your organization or in an OU in your organization. Drift detection is not possible for most of this argument. See deploymentTargets below.
	DeploymentTargets *StackInstancesDeploymentTargets `pulumi:"deploymentTargets"`
	// Preferences for how AWS CloudFormation performs a stack set operation. See operationPreferences below.
	OperationPreferences *StackInstancesOperationPreferences `pulumi:"operationPreferences"`
	// Key-value map of input parameters to override from the stack set for these instances. This argument's drift detection is limited to the first account and region since each instance can have unique parameters.
	ParameterOverrides map[string]string `pulumi:"parameterOverrides"`
	// Regions where you want to create stack instances in the specified `accounts`.
	Regions []string `pulumi:"regions"`
	// Whether to remove the stack instances from the stack set, but not delete the stacks. You can't reassociate a retained stack or add an existing, saved stack to a new stack set. To retain the stack, ensure `retainStacks = true` has been successfully applied _before_ an apply that would destroy the resource. Defaults to `false`.
	RetainStacks *bool `pulumi:"retainStacks"`
	// List of stack instances created from an organizational unit deployment target. This may not always be set depending on whether CloudFormation returns summaries for your configuration. See `stackInstanceSummaries`.
	StackInstanceSummaries []StackInstancesStackInstanceSummary `pulumi:"stackInstanceSummaries"`
	// Name or unique ID of the stack set that the stack instance is associated with.
	StackSetId *string `pulumi:"stackSetId"`
	// Name of the stack set.
	//
	// The following arguments are optional:
	StackSetName *string `pulumi:"stackSetName"`
}

type StackInstancesState struct {
	// Accounts where you want to create stack instances in the specified `regions`. You can specify either `accounts` or `deploymentTargets`, but not both.
	Accounts pulumi.StringArrayInput
	// Whether you are acting as an account administrator in the organization's management account or as a delegated administrator in a member account. Valid values: `SELF` (default), `DELEGATED_ADMIN`.
	CallAs pulumi.StringPtrInput
	// AWS Organizations accounts for which to create stack instances in the `regions`. stack sets doesn't deploy stack instances to the organization management account, even if the organization management account is in your organization or in an OU in your organization. Drift detection is not possible for most of this argument. See deploymentTargets below.
	DeploymentTargets StackInstancesDeploymentTargetsPtrInput
	// Preferences for how AWS CloudFormation performs a stack set operation. See operationPreferences below.
	OperationPreferences StackInstancesOperationPreferencesPtrInput
	// Key-value map of input parameters to override from the stack set for these instances. This argument's drift detection is limited to the first account and region since each instance can have unique parameters.
	ParameterOverrides pulumi.StringMapInput
	// Regions where you want to create stack instances in the specified `accounts`.
	Regions pulumi.StringArrayInput
	// Whether to remove the stack instances from the stack set, but not delete the stacks. You can't reassociate a retained stack or add an existing, saved stack to a new stack set. To retain the stack, ensure `retainStacks = true` has been successfully applied _before_ an apply that would destroy the resource. Defaults to `false`.
	RetainStacks pulumi.BoolPtrInput
	// List of stack instances created from an organizational unit deployment target. This may not always be set depending on whether CloudFormation returns summaries for your configuration. See `stackInstanceSummaries`.
	StackInstanceSummaries StackInstancesStackInstanceSummaryArrayInput
	// Name or unique ID of the stack set that the stack instance is associated with.
	StackSetId pulumi.StringPtrInput
	// Name of the stack set.
	//
	// The following arguments are optional:
	StackSetName pulumi.StringPtrInput
}

func (StackInstancesState) ElementType() reflect.Type {
	return reflect.TypeOf((*stackInstancesState)(nil)).Elem()
}

type stackInstancesArgs struct {
	// Accounts where you want to create stack instances in the specified `regions`. You can specify either `accounts` or `deploymentTargets`, but not both.
	Accounts []string `pulumi:"accounts"`
	// Whether you are acting as an account administrator in the organization's management account or as a delegated administrator in a member account. Valid values: `SELF` (default), `DELEGATED_ADMIN`.
	CallAs *string `pulumi:"callAs"`
	// AWS Organizations accounts for which to create stack instances in the `regions`. stack sets doesn't deploy stack instances to the organization management account, even if the organization management account is in your organization or in an OU in your organization. Drift detection is not possible for most of this argument. See deploymentTargets below.
	DeploymentTargets *StackInstancesDeploymentTargets `pulumi:"deploymentTargets"`
	// Preferences for how AWS CloudFormation performs a stack set operation. See operationPreferences below.
	OperationPreferences *StackInstancesOperationPreferences `pulumi:"operationPreferences"`
	// Key-value map of input parameters to override from the stack set for these instances. This argument's drift detection is limited to the first account and region since each instance can have unique parameters.
	ParameterOverrides map[string]string `pulumi:"parameterOverrides"`
	// Regions where you want to create stack instances in the specified `accounts`.
	Regions []string `pulumi:"regions"`
	// Whether to remove the stack instances from the stack set, but not delete the stacks. You can't reassociate a retained stack or add an existing, saved stack to a new stack set. To retain the stack, ensure `retainStacks = true` has been successfully applied _before_ an apply that would destroy the resource. Defaults to `false`.
	RetainStacks *bool `pulumi:"retainStacks"`
	// Name of the stack set.
	//
	// The following arguments are optional:
	StackSetName string `pulumi:"stackSetName"`
}

// The set of arguments for constructing a StackInstances resource.
type StackInstancesArgs struct {
	// Accounts where you want to create stack instances in the specified `regions`. You can specify either `accounts` or `deploymentTargets`, but not both.
	Accounts pulumi.StringArrayInput
	// Whether you are acting as an account administrator in the organization's management account or as a delegated administrator in a member account. Valid values: `SELF` (default), `DELEGATED_ADMIN`.
	CallAs pulumi.StringPtrInput
	// AWS Organizations accounts for which to create stack instances in the `regions`. stack sets doesn't deploy stack instances to the organization management account, even if the organization management account is in your organization or in an OU in your organization. Drift detection is not possible for most of this argument. See deploymentTargets below.
	DeploymentTargets StackInstancesDeploymentTargetsPtrInput
	// Preferences for how AWS CloudFormation performs a stack set operation. See operationPreferences below.
	OperationPreferences StackInstancesOperationPreferencesPtrInput
	// Key-value map of input parameters to override from the stack set for these instances. This argument's drift detection is limited to the first account and region since each instance can have unique parameters.
	ParameterOverrides pulumi.StringMapInput
	// Regions where you want to create stack instances in the specified `accounts`.
	Regions pulumi.StringArrayInput
	// Whether to remove the stack instances from the stack set, but not delete the stacks. You can't reassociate a retained stack or add an existing, saved stack to a new stack set. To retain the stack, ensure `retainStacks = true` has been successfully applied _before_ an apply that would destroy the resource. Defaults to `false`.
	RetainStacks pulumi.BoolPtrInput
	// Name of the stack set.
	//
	// The following arguments are optional:
	StackSetName pulumi.StringInput
}

func (StackInstancesArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*stackInstancesArgs)(nil)).Elem()
}

type StackInstancesInput interface {
	pulumi.Input

	ToStackInstancesOutput() StackInstancesOutput
	ToStackInstancesOutputWithContext(ctx context.Context) StackInstancesOutput
}

func (*StackInstances) ElementType() reflect.Type {
	return reflect.TypeOf((**StackInstances)(nil)).Elem()
}

func (i *StackInstances) ToStackInstancesOutput() StackInstancesOutput {
	return i.ToStackInstancesOutputWithContext(context.Background())
}

func (i *StackInstances) ToStackInstancesOutputWithContext(ctx context.Context) StackInstancesOutput {
	return pulumi.ToOutputWithContext(ctx, i).(StackInstancesOutput)
}

// StackInstancesArrayInput is an input type that accepts StackInstancesArray and StackInstancesArrayOutput values.
// You can construct a concrete instance of `StackInstancesArrayInput` via:
//
//	StackInstancesArray{ StackInstancesArgs{...} }
type StackInstancesArrayInput interface {
	pulumi.Input

	ToStackInstancesArrayOutput() StackInstancesArrayOutput
	ToStackInstancesArrayOutputWithContext(context.Context) StackInstancesArrayOutput
}

type StackInstancesArray []StackInstancesInput

func (StackInstancesArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*StackInstances)(nil)).Elem()
}

func (i StackInstancesArray) ToStackInstancesArrayOutput() StackInstancesArrayOutput {
	return i.ToStackInstancesArrayOutputWithContext(context.Background())
}

func (i StackInstancesArray) ToStackInstancesArrayOutputWithContext(ctx context.Context) StackInstancesArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(StackInstancesArrayOutput)
}

// StackInstancesMapInput is an input type that accepts StackInstancesMap and StackInstancesMapOutput values.
// You can construct a concrete instance of `StackInstancesMapInput` via:
//
//	StackInstancesMap{ "key": StackInstancesArgs{...} }
type StackInstancesMapInput interface {
	pulumi.Input

	ToStackInstancesMapOutput() StackInstancesMapOutput
	ToStackInstancesMapOutputWithContext(context.Context) StackInstancesMapOutput
}

type StackInstancesMap map[string]StackInstancesInput

func (StackInstancesMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*StackInstances)(nil)).Elem()
}

func (i StackInstancesMap) ToStackInstancesMapOutput() StackInstancesMapOutput {
	return i.ToStackInstancesMapOutputWithContext(context.Background())
}

func (i StackInstancesMap) ToStackInstancesMapOutputWithContext(ctx context.Context) StackInstancesMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(StackInstancesMapOutput)
}

type StackInstancesOutput struct{ *pulumi.OutputState }

func (StackInstancesOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**StackInstances)(nil)).Elem()
}

func (o StackInstancesOutput) ToStackInstancesOutput() StackInstancesOutput {
	return o
}

func (o StackInstancesOutput) ToStackInstancesOutputWithContext(ctx context.Context) StackInstancesOutput {
	return o
}

// Accounts where you want to create stack instances in the specified `regions`. You can specify either `accounts` or `deploymentTargets`, but not both.
func (o StackInstancesOutput) Accounts() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *StackInstances) pulumi.StringArrayOutput { return v.Accounts }).(pulumi.StringArrayOutput)
}

// Whether you are acting as an account administrator in the organization's management account or as a delegated administrator in a member account. Valid values: `SELF` (default), `DELEGATED_ADMIN`.
func (o StackInstancesOutput) CallAs() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *StackInstances) pulumi.StringPtrOutput { return v.CallAs }).(pulumi.StringPtrOutput)
}

// AWS Organizations accounts for which to create stack instances in the `regions`. stack sets doesn't deploy stack instances to the organization management account, even if the organization management account is in your organization or in an OU in your organization. Drift detection is not possible for most of this argument. See deploymentTargets below.
func (o StackInstancesOutput) DeploymentTargets() StackInstancesDeploymentTargetsPtrOutput {
	return o.ApplyT(func(v *StackInstances) StackInstancesDeploymentTargetsPtrOutput { return v.DeploymentTargets }).(StackInstancesDeploymentTargetsPtrOutput)
}

// Preferences for how AWS CloudFormation performs a stack set operation. See operationPreferences below.
func (o StackInstancesOutput) OperationPreferences() StackInstancesOperationPreferencesPtrOutput {
	return o.ApplyT(func(v *StackInstances) StackInstancesOperationPreferencesPtrOutput { return v.OperationPreferences }).(StackInstancesOperationPreferencesPtrOutput)
}

// Key-value map of input parameters to override from the stack set for these instances. This argument's drift detection is limited to the first account and region since each instance can have unique parameters.
func (o StackInstancesOutput) ParameterOverrides() pulumi.StringMapOutput {
	return o.ApplyT(func(v *StackInstances) pulumi.StringMapOutput { return v.ParameterOverrides }).(pulumi.StringMapOutput)
}

// Regions where you want to create stack instances in the specified `accounts`.
func (o StackInstancesOutput) Regions() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *StackInstances) pulumi.StringArrayOutput { return v.Regions }).(pulumi.StringArrayOutput)
}

// Whether to remove the stack instances from the stack set, but not delete the stacks. You can't reassociate a retained stack or add an existing, saved stack to a new stack set. To retain the stack, ensure `retainStacks = true` has been successfully applied _before_ an apply that would destroy the resource. Defaults to `false`.
func (o StackInstancesOutput) RetainStacks() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v *StackInstances) pulumi.BoolPtrOutput { return v.RetainStacks }).(pulumi.BoolPtrOutput)
}

// List of stack instances created from an organizational unit deployment target. This may not always be set depending on whether CloudFormation returns summaries for your configuration. See `stackInstanceSummaries`.
func (o StackInstancesOutput) StackInstanceSummaries() StackInstancesStackInstanceSummaryArrayOutput {
	return o.ApplyT(func(v *StackInstances) StackInstancesStackInstanceSummaryArrayOutput { return v.StackInstanceSummaries }).(StackInstancesStackInstanceSummaryArrayOutput)
}

// Name or unique ID of the stack set that the stack instance is associated with.
func (o StackInstancesOutput) StackSetId() pulumi.StringOutput {
	return o.ApplyT(func(v *StackInstances) pulumi.StringOutput { return v.StackSetId }).(pulumi.StringOutput)
}

// Name of the stack set.
//
// The following arguments are optional:
func (o StackInstancesOutput) StackSetName() pulumi.StringOutput {
	return o.ApplyT(func(v *StackInstances) pulumi.StringOutput { return v.StackSetName }).(pulumi.StringOutput)
}

type StackInstancesArrayOutput struct{ *pulumi.OutputState }

func (StackInstancesArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*StackInstances)(nil)).Elem()
}

func (o StackInstancesArrayOutput) ToStackInstancesArrayOutput() StackInstancesArrayOutput {
	return o
}

func (o StackInstancesArrayOutput) ToStackInstancesArrayOutputWithContext(ctx context.Context) StackInstancesArrayOutput {
	return o
}

func (o StackInstancesArrayOutput) Index(i pulumi.IntInput) StackInstancesOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *StackInstances {
		return vs[0].([]*StackInstances)[vs[1].(int)]
	}).(StackInstancesOutput)
}

type StackInstancesMapOutput struct{ *pulumi.OutputState }

func (StackInstancesMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*StackInstances)(nil)).Elem()
}

func (o StackInstancesMapOutput) ToStackInstancesMapOutput() StackInstancesMapOutput {
	return o
}

func (o StackInstancesMapOutput) ToStackInstancesMapOutputWithContext(ctx context.Context) StackInstancesMapOutput {
	return o
}

func (o StackInstancesMapOutput) MapIndex(k pulumi.StringInput) StackInstancesOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *StackInstances {
		return vs[0].(map[string]*StackInstances)[vs[1].(string)]
	}).(StackInstancesOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*StackInstancesInput)(nil)).Elem(), &StackInstances{})
	pulumi.RegisterInputType(reflect.TypeOf((*StackInstancesArrayInput)(nil)).Elem(), StackInstancesArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*StackInstancesMapInput)(nil)).Elem(), StackInstancesMap{})
	pulumi.RegisterOutputType(StackInstancesOutput{})
	pulumi.RegisterOutputType(StackInstancesArrayOutput{})
	pulumi.RegisterOutputType(StackInstancesMapOutput{})
}
