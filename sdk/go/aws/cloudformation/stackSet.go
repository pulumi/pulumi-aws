// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package cloudformation

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Manages a CloudFormation StackSet. StackSets allow CloudFormation templates to be easily deployed across multiple accounts and regions via StackSet Instances (`cloudformation.StackSetInstance` resource). Additional information about StackSets can be found in the [AWS CloudFormation User Guide](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/what-is-cfnstacksets.html).
//
// > **NOTE:** All template parameters, including those with a `Default`, must be configured or ignored with the `lifecycle` configuration block `ignoreChanges` argument.
//
// > **NOTE:** All `NoEcho` template parameters must be ignored with the `lifecycle` configuration block `ignoreChanges` argument.
//
// > **NOTE:** When using a delegated administrator account, ensure that your IAM User or Role has the `organizations:ListDelegatedAdministrators` permission. Otherwise, you may get an error like `ValidationError: Account used is not a delegated administrator`.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"encoding/json"
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/cloudformation"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/iam"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			aWSCloudFormationStackSetAdministrationRoleAssumeRolePolicy, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
//				Statements: []iam.GetPolicyDocumentStatement{
//					{
//						Actions: []string{
//							"sts:AssumeRole",
//						},
//						Effect: pulumi.StringRef("Allow"),
//						Principals: []iam.GetPolicyDocumentStatementPrincipal{
//							{
//								Identifiers: []string{
//									"cloudformation.amazonaws.com",
//								},
//								Type: "Service",
//							},
//						},
//					},
//				},
//			}, nil)
//			if err != nil {
//				return err
//			}
//			aWSCloudFormationStackSetAdministrationRole, err := iam.NewRole(ctx, "AWSCloudFormationStackSetAdministrationRole", &iam.RoleArgs{
//				AssumeRolePolicy: pulumi.String(aWSCloudFormationStackSetAdministrationRoleAssumeRolePolicy.Json),
//				Name:             pulumi.String("AWSCloudFormationStackSetAdministrationRole"),
//			})
//			if err != nil {
//				return err
//			}
//			tmpJSON0, err := json.Marshal(map[string]interface{}{
//				"Parameters": map[string]interface{}{
//					"VPCCidr": map[string]interface{}{
//						"Type":        "String",
//						"Default":     "10.0.0.0/16",
//						"Description": "Enter the CIDR block for the VPC. Default is 10.0.0.0/16.",
//					},
//				},
//				"Resources": map[string]interface{}{
//					"myVpc": map[string]interface{}{
//						"Type": "AWS::EC2::VPC",
//						"Properties": map[string]interface{}{
//							"CidrBlock": map[string]interface{}{
//								"Ref": "VPCCidr",
//							},
//							"Tags": []map[string]interface{}{
//								map[string]interface{}{
//									"Key":   "Name",
//									"Value": "Primary_CF_VPC",
//								},
//							},
//						},
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			json0 := string(tmpJSON0)
//			example, err := cloudformation.NewStackSet(ctx, "example", &cloudformation.StackSetArgs{
//				AdministrationRoleArn: aWSCloudFormationStackSetAdministrationRole.Arn,
//				Name:                  pulumi.String("example"),
//				Parameters: pulumi.StringMap{
//					"VPCCidr": pulumi.String("10.0.0.0/16"),
//				},
//				TemplateBody: pulumi.String(json0),
//			})
//			if err != nil {
//				return err
//			}
//			aWSCloudFormationStackSetAdministrationRoleExecutionPolicy := iam.GetPolicyDocumentOutput(ctx, iam.GetPolicyDocumentOutputArgs{
//				Statements: iam.GetPolicyDocumentStatementArray{
//					&iam.GetPolicyDocumentStatementArgs{
//						Actions: pulumi.StringArray{
//							pulumi.String("sts:AssumeRole"),
//						},
//						Effect: pulumi.String("Allow"),
//						Resources: pulumi.StringArray{
//							example.ExecutionRoleName.ApplyT(func(executionRoleName string) (string, error) {
//								return fmt.Sprintf("arn:aws:iam::*:role/%v", executionRoleName), nil
//							}).(pulumi.StringOutput),
//						},
//					},
//				},
//			}, nil)
//			_, err = iam.NewRolePolicy(ctx, "AWSCloudFormationStackSetAdministrationRole_ExecutionPolicy", &iam.RolePolicyArgs{
//				Name: pulumi.String("ExecutionPolicy"),
//				Policy: pulumi.String(aWSCloudFormationStackSetAdministrationRoleExecutionPolicy.ApplyT(func(aWSCloudFormationStackSetAdministrationRoleExecutionPolicy iam.GetPolicyDocumentResult) (*string, error) {
//					return &aWSCloudFormationStackSetAdministrationRoleExecutionPolicy.Json, nil
//				}).(pulumi.StringPtrOutput)),
//				Role: aWSCloudFormationStackSetAdministrationRole.Name,
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
// Import CloudFormation StackSets when acting a delegated administrator in a member account using the `name` and `call_as` values separated by a comma (`,`). For example:
//
// Using `pulumi import`, import CloudFormation StackSets using the `name`. For example:
//
// ```sh
// $ pulumi import aws:cloudformation/stackSet:StackSet example example
// ```
// Using `pulumi import`, import CloudFormation StackSets when acting a delegated administrator in a member account using the `name` and `call_as` values separated by a comma (`,`). For example:
//
// ```sh
// $ pulumi import aws:cloudformation/stackSet:StackSet example example,DELEGATED_ADMIN
// ```
type StackSet struct {
	pulumi.CustomResourceState

	// Amazon Resource Number (ARN) of the IAM Role in the administrator account. This must be defined when using the `SELF_MANAGED` permission model.
	AdministrationRoleArn pulumi.StringPtrOutput `pulumi:"administrationRoleArn"`
	// Amazon Resource Name (ARN) of the StackSet.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Configuration block containing the auto-deployment model for your StackSet. This can only be defined when using the `SERVICE_MANAGED` permission model.
	AutoDeployment StackSetAutoDeploymentPtrOutput `pulumi:"autoDeployment"`
	// Specifies whether you are acting as an account administrator in the organization's management account or as a delegated administrator in a member account. Valid values: `SELF` (default), `DELEGATED_ADMIN`.
	CallAs pulumi.StringPtrOutput `pulumi:"callAs"`
	// A list of capabilities. Valid values: `CAPABILITY_IAM`, `CAPABILITY_NAMED_IAM`, `CAPABILITY_AUTO_EXPAND`.
	Capabilities pulumi.StringArrayOutput `pulumi:"capabilities"`
	// Description of the StackSet.
	Description pulumi.StringPtrOutput `pulumi:"description"`
	// Name of the IAM Role in all target accounts for StackSet operations. Defaults to `AWSCloudFormationStackSetExecutionRole` when using the `SELF_MANAGED` permission model. This should not be defined when using the `SERVICE_MANAGED` permission model.
	ExecutionRoleName pulumi.StringOutput `pulumi:"executionRoleName"`
	// Configuration block to allow StackSets to perform non-conflicting operations concurrently and queues conflicting operations.
	ManagedExecution StackSetManagedExecutionPtrOutput `pulumi:"managedExecution"`
	// Name of the StackSet. The name must be unique in the region where you create your StackSet. The name can contain only alphanumeric characters (case-sensitive) and hyphens. It must start with an alphabetic character and cannot be longer than 128 characters.
	Name pulumi.StringOutput `pulumi:"name"`
	// Preferences for how AWS CloudFormation performs a stack set update.
	OperationPreferences StackSetOperationPreferencesPtrOutput `pulumi:"operationPreferences"`
	// Key-value map of input parameters for the StackSet template. All template parameters, including those with a `Default`, must be configured or ignored with `lifecycle` configuration block `ignoreChanges` argument. All `NoEcho` template parameters must be ignored with the `lifecycle` configuration block `ignoreChanges` argument.
	Parameters pulumi.StringMapOutput `pulumi:"parameters"`
	// Describes how the IAM roles required for your StackSet are created. Valid values: `SELF_MANAGED` (default), `SERVICE_MANAGED`.
	PermissionModel pulumi.StringPtrOutput `pulumi:"permissionModel"`
	// Unique identifier of the StackSet.
	StackSetId pulumi.StringOutput `pulumi:"stackSetId"`
	// Key-value map of tags to associate with this StackSet and the Stacks created from it. AWS CloudFormation also propagates these tags to supported resources that are created in the Stacks. A maximum number of 50 tags can be specified. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	// String containing the CloudFormation template body. Maximum size: 51,200 bytes. Conflicts with `templateUrl`.
	TemplateBody pulumi.StringOutput `pulumi:"templateBody"`
	// String containing the location of a file containing the CloudFormation template body. The URL must point to a template that is located in an Amazon S3 bucket. Maximum location file size: 460,800 bytes. Conflicts with `templateBody`.
	TemplateUrl pulumi.StringPtrOutput `pulumi:"templateUrl"`
}

// NewStackSet registers a new resource with the given unique name, arguments, and options.
func NewStackSet(ctx *pulumi.Context,
	name string, args *StackSetArgs, opts ...pulumi.ResourceOption) (*StackSet, error) {
	if args == nil {
		args = &StackSetArgs{}
	}

	opts = internal.PkgResourceDefaultOpts(opts)
	var resource StackSet
	err := ctx.RegisterResource("aws:cloudformation/stackSet:StackSet", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetStackSet gets an existing StackSet resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetStackSet(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *StackSetState, opts ...pulumi.ResourceOption) (*StackSet, error) {
	var resource StackSet
	err := ctx.ReadResource("aws:cloudformation/stackSet:StackSet", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering StackSet resources.
type stackSetState struct {
	// Amazon Resource Number (ARN) of the IAM Role in the administrator account. This must be defined when using the `SELF_MANAGED` permission model.
	AdministrationRoleArn *string `pulumi:"administrationRoleArn"`
	// Amazon Resource Name (ARN) of the StackSet.
	Arn *string `pulumi:"arn"`
	// Configuration block containing the auto-deployment model for your StackSet. This can only be defined when using the `SERVICE_MANAGED` permission model.
	AutoDeployment *StackSetAutoDeployment `pulumi:"autoDeployment"`
	// Specifies whether you are acting as an account administrator in the organization's management account or as a delegated administrator in a member account. Valid values: `SELF` (default), `DELEGATED_ADMIN`.
	CallAs *string `pulumi:"callAs"`
	// A list of capabilities. Valid values: `CAPABILITY_IAM`, `CAPABILITY_NAMED_IAM`, `CAPABILITY_AUTO_EXPAND`.
	Capabilities []string `pulumi:"capabilities"`
	// Description of the StackSet.
	Description *string `pulumi:"description"`
	// Name of the IAM Role in all target accounts for StackSet operations. Defaults to `AWSCloudFormationStackSetExecutionRole` when using the `SELF_MANAGED` permission model. This should not be defined when using the `SERVICE_MANAGED` permission model.
	ExecutionRoleName *string `pulumi:"executionRoleName"`
	// Configuration block to allow StackSets to perform non-conflicting operations concurrently and queues conflicting operations.
	ManagedExecution *StackSetManagedExecution `pulumi:"managedExecution"`
	// Name of the StackSet. The name must be unique in the region where you create your StackSet. The name can contain only alphanumeric characters (case-sensitive) and hyphens. It must start with an alphabetic character and cannot be longer than 128 characters.
	Name *string `pulumi:"name"`
	// Preferences for how AWS CloudFormation performs a stack set update.
	OperationPreferences *StackSetOperationPreferences `pulumi:"operationPreferences"`
	// Key-value map of input parameters for the StackSet template. All template parameters, including those with a `Default`, must be configured or ignored with `lifecycle` configuration block `ignoreChanges` argument. All `NoEcho` template parameters must be ignored with the `lifecycle` configuration block `ignoreChanges` argument.
	Parameters map[string]string `pulumi:"parameters"`
	// Describes how the IAM roles required for your StackSet are created. Valid values: `SELF_MANAGED` (default), `SERVICE_MANAGED`.
	PermissionModel *string `pulumi:"permissionModel"`
	// Unique identifier of the StackSet.
	StackSetId *string `pulumi:"stackSetId"`
	// Key-value map of tags to associate with this StackSet and the Stacks created from it. AWS CloudFormation also propagates these tags to supported resources that are created in the Stacks. A maximum number of 50 tags can be specified. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	// String containing the CloudFormation template body. Maximum size: 51,200 bytes. Conflicts with `templateUrl`.
	TemplateBody *string `pulumi:"templateBody"`
	// String containing the location of a file containing the CloudFormation template body. The URL must point to a template that is located in an Amazon S3 bucket. Maximum location file size: 460,800 bytes. Conflicts with `templateBody`.
	TemplateUrl *string `pulumi:"templateUrl"`
}

type StackSetState struct {
	// Amazon Resource Number (ARN) of the IAM Role in the administrator account. This must be defined when using the `SELF_MANAGED` permission model.
	AdministrationRoleArn pulumi.StringPtrInput
	// Amazon Resource Name (ARN) of the StackSet.
	Arn pulumi.StringPtrInput
	// Configuration block containing the auto-deployment model for your StackSet. This can only be defined when using the `SERVICE_MANAGED` permission model.
	AutoDeployment StackSetAutoDeploymentPtrInput
	// Specifies whether you are acting as an account administrator in the organization's management account or as a delegated administrator in a member account. Valid values: `SELF` (default), `DELEGATED_ADMIN`.
	CallAs pulumi.StringPtrInput
	// A list of capabilities. Valid values: `CAPABILITY_IAM`, `CAPABILITY_NAMED_IAM`, `CAPABILITY_AUTO_EXPAND`.
	Capabilities pulumi.StringArrayInput
	// Description of the StackSet.
	Description pulumi.StringPtrInput
	// Name of the IAM Role in all target accounts for StackSet operations. Defaults to `AWSCloudFormationStackSetExecutionRole` when using the `SELF_MANAGED` permission model. This should not be defined when using the `SERVICE_MANAGED` permission model.
	ExecutionRoleName pulumi.StringPtrInput
	// Configuration block to allow StackSets to perform non-conflicting operations concurrently and queues conflicting operations.
	ManagedExecution StackSetManagedExecutionPtrInput
	// Name of the StackSet. The name must be unique in the region where you create your StackSet. The name can contain only alphanumeric characters (case-sensitive) and hyphens. It must start with an alphabetic character and cannot be longer than 128 characters.
	Name pulumi.StringPtrInput
	// Preferences for how AWS CloudFormation performs a stack set update.
	OperationPreferences StackSetOperationPreferencesPtrInput
	// Key-value map of input parameters for the StackSet template. All template parameters, including those with a `Default`, must be configured or ignored with `lifecycle` configuration block `ignoreChanges` argument. All `NoEcho` template parameters must be ignored with the `lifecycle` configuration block `ignoreChanges` argument.
	Parameters pulumi.StringMapInput
	// Describes how the IAM roles required for your StackSet are created. Valid values: `SELF_MANAGED` (default), `SERVICE_MANAGED`.
	PermissionModel pulumi.StringPtrInput
	// Unique identifier of the StackSet.
	StackSetId pulumi.StringPtrInput
	// Key-value map of tags to associate with this StackSet and the Stacks created from it. AWS CloudFormation also propagates these tags to supported resources that are created in the Stacks. A maximum number of 50 tags can be specified. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	// String containing the CloudFormation template body. Maximum size: 51,200 bytes. Conflicts with `templateUrl`.
	TemplateBody pulumi.StringPtrInput
	// String containing the location of a file containing the CloudFormation template body. The URL must point to a template that is located in an Amazon S3 bucket. Maximum location file size: 460,800 bytes. Conflicts with `templateBody`.
	TemplateUrl pulumi.StringPtrInput
}

func (StackSetState) ElementType() reflect.Type {
	return reflect.TypeOf((*stackSetState)(nil)).Elem()
}

type stackSetArgs struct {
	// Amazon Resource Number (ARN) of the IAM Role in the administrator account. This must be defined when using the `SELF_MANAGED` permission model.
	AdministrationRoleArn *string `pulumi:"administrationRoleArn"`
	// Configuration block containing the auto-deployment model for your StackSet. This can only be defined when using the `SERVICE_MANAGED` permission model.
	AutoDeployment *StackSetAutoDeployment `pulumi:"autoDeployment"`
	// Specifies whether you are acting as an account administrator in the organization's management account or as a delegated administrator in a member account. Valid values: `SELF` (default), `DELEGATED_ADMIN`.
	CallAs *string `pulumi:"callAs"`
	// A list of capabilities. Valid values: `CAPABILITY_IAM`, `CAPABILITY_NAMED_IAM`, `CAPABILITY_AUTO_EXPAND`.
	Capabilities []string `pulumi:"capabilities"`
	// Description of the StackSet.
	Description *string `pulumi:"description"`
	// Name of the IAM Role in all target accounts for StackSet operations. Defaults to `AWSCloudFormationStackSetExecutionRole` when using the `SELF_MANAGED` permission model. This should not be defined when using the `SERVICE_MANAGED` permission model.
	ExecutionRoleName *string `pulumi:"executionRoleName"`
	// Configuration block to allow StackSets to perform non-conflicting operations concurrently and queues conflicting operations.
	ManagedExecution *StackSetManagedExecution `pulumi:"managedExecution"`
	// Name of the StackSet. The name must be unique in the region where you create your StackSet. The name can contain only alphanumeric characters (case-sensitive) and hyphens. It must start with an alphabetic character and cannot be longer than 128 characters.
	Name *string `pulumi:"name"`
	// Preferences for how AWS CloudFormation performs a stack set update.
	OperationPreferences *StackSetOperationPreferences `pulumi:"operationPreferences"`
	// Key-value map of input parameters for the StackSet template. All template parameters, including those with a `Default`, must be configured or ignored with `lifecycle` configuration block `ignoreChanges` argument. All `NoEcho` template parameters must be ignored with the `lifecycle` configuration block `ignoreChanges` argument.
	Parameters map[string]string `pulumi:"parameters"`
	// Describes how the IAM roles required for your StackSet are created. Valid values: `SELF_MANAGED` (default), `SERVICE_MANAGED`.
	PermissionModel *string `pulumi:"permissionModel"`
	// Key-value map of tags to associate with this StackSet and the Stacks created from it. AWS CloudFormation also propagates these tags to supported resources that are created in the Stacks. A maximum number of 50 tags can be specified. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// String containing the CloudFormation template body. Maximum size: 51,200 bytes. Conflicts with `templateUrl`.
	TemplateBody *string `pulumi:"templateBody"`
	// String containing the location of a file containing the CloudFormation template body. The URL must point to a template that is located in an Amazon S3 bucket. Maximum location file size: 460,800 bytes. Conflicts with `templateBody`.
	TemplateUrl *string `pulumi:"templateUrl"`
}

// The set of arguments for constructing a StackSet resource.
type StackSetArgs struct {
	// Amazon Resource Number (ARN) of the IAM Role in the administrator account. This must be defined when using the `SELF_MANAGED` permission model.
	AdministrationRoleArn pulumi.StringPtrInput
	// Configuration block containing the auto-deployment model for your StackSet. This can only be defined when using the `SERVICE_MANAGED` permission model.
	AutoDeployment StackSetAutoDeploymentPtrInput
	// Specifies whether you are acting as an account administrator in the organization's management account or as a delegated administrator in a member account. Valid values: `SELF` (default), `DELEGATED_ADMIN`.
	CallAs pulumi.StringPtrInput
	// A list of capabilities. Valid values: `CAPABILITY_IAM`, `CAPABILITY_NAMED_IAM`, `CAPABILITY_AUTO_EXPAND`.
	Capabilities pulumi.StringArrayInput
	// Description of the StackSet.
	Description pulumi.StringPtrInput
	// Name of the IAM Role in all target accounts for StackSet operations. Defaults to `AWSCloudFormationStackSetExecutionRole` when using the `SELF_MANAGED` permission model. This should not be defined when using the `SERVICE_MANAGED` permission model.
	ExecutionRoleName pulumi.StringPtrInput
	// Configuration block to allow StackSets to perform non-conflicting operations concurrently and queues conflicting operations.
	ManagedExecution StackSetManagedExecutionPtrInput
	// Name of the StackSet. The name must be unique in the region where you create your StackSet. The name can contain only alphanumeric characters (case-sensitive) and hyphens. It must start with an alphabetic character and cannot be longer than 128 characters.
	Name pulumi.StringPtrInput
	// Preferences for how AWS CloudFormation performs a stack set update.
	OperationPreferences StackSetOperationPreferencesPtrInput
	// Key-value map of input parameters for the StackSet template. All template parameters, including those with a `Default`, must be configured or ignored with `lifecycle` configuration block `ignoreChanges` argument. All `NoEcho` template parameters must be ignored with the `lifecycle` configuration block `ignoreChanges` argument.
	Parameters pulumi.StringMapInput
	// Describes how the IAM roles required for your StackSet are created. Valid values: `SELF_MANAGED` (default), `SERVICE_MANAGED`.
	PermissionModel pulumi.StringPtrInput
	// Key-value map of tags to associate with this StackSet and the Stacks created from it. AWS CloudFormation also propagates these tags to supported resources that are created in the Stacks. A maximum number of 50 tags can be specified. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// String containing the CloudFormation template body. Maximum size: 51,200 bytes. Conflicts with `templateUrl`.
	TemplateBody pulumi.StringPtrInput
	// String containing the location of a file containing the CloudFormation template body. The URL must point to a template that is located in an Amazon S3 bucket. Maximum location file size: 460,800 bytes. Conflicts with `templateBody`.
	TemplateUrl pulumi.StringPtrInput
}

func (StackSetArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*stackSetArgs)(nil)).Elem()
}

type StackSetInput interface {
	pulumi.Input

	ToStackSetOutput() StackSetOutput
	ToStackSetOutputWithContext(ctx context.Context) StackSetOutput
}

func (*StackSet) ElementType() reflect.Type {
	return reflect.TypeOf((**StackSet)(nil)).Elem()
}

func (i *StackSet) ToStackSetOutput() StackSetOutput {
	return i.ToStackSetOutputWithContext(context.Background())
}

func (i *StackSet) ToStackSetOutputWithContext(ctx context.Context) StackSetOutput {
	return pulumi.ToOutputWithContext(ctx, i).(StackSetOutput)
}

// StackSetArrayInput is an input type that accepts StackSetArray and StackSetArrayOutput values.
// You can construct a concrete instance of `StackSetArrayInput` via:
//
//	StackSetArray{ StackSetArgs{...} }
type StackSetArrayInput interface {
	pulumi.Input

	ToStackSetArrayOutput() StackSetArrayOutput
	ToStackSetArrayOutputWithContext(context.Context) StackSetArrayOutput
}

type StackSetArray []StackSetInput

func (StackSetArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*StackSet)(nil)).Elem()
}

func (i StackSetArray) ToStackSetArrayOutput() StackSetArrayOutput {
	return i.ToStackSetArrayOutputWithContext(context.Background())
}

func (i StackSetArray) ToStackSetArrayOutputWithContext(ctx context.Context) StackSetArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(StackSetArrayOutput)
}

// StackSetMapInput is an input type that accepts StackSetMap and StackSetMapOutput values.
// You can construct a concrete instance of `StackSetMapInput` via:
//
//	StackSetMap{ "key": StackSetArgs{...} }
type StackSetMapInput interface {
	pulumi.Input

	ToStackSetMapOutput() StackSetMapOutput
	ToStackSetMapOutputWithContext(context.Context) StackSetMapOutput
}

type StackSetMap map[string]StackSetInput

func (StackSetMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*StackSet)(nil)).Elem()
}

func (i StackSetMap) ToStackSetMapOutput() StackSetMapOutput {
	return i.ToStackSetMapOutputWithContext(context.Background())
}

func (i StackSetMap) ToStackSetMapOutputWithContext(ctx context.Context) StackSetMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(StackSetMapOutput)
}

type StackSetOutput struct{ *pulumi.OutputState }

func (StackSetOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**StackSet)(nil)).Elem()
}

func (o StackSetOutput) ToStackSetOutput() StackSetOutput {
	return o
}

func (o StackSetOutput) ToStackSetOutputWithContext(ctx context.Context) StackSetOutput {
	return o
}

// Amazon Resource Number (ARN) of the IAM Role in the administrator account. This must be defined when using the `SELF_MANAGED` permission model.
func (o StackSetOutput) AdministrationRoleArn() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *StackSet) pulumi.StringPtrOutput { return v.AdministrationRoleArn }).(pulumi.StringPtrOutput)
}

// Amazon Resource Name (ARN) of the StackSet.
func (o StackSetOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *StackSet) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Configuration block containing the auto-deployment model for your StackSet. This can only be defined when using the `SERVICE_MANAGED` permission model.
func (o StackSetOutput) AutoDeployment() StackSetAutoDeploymentPtrOutput {
	return o.ApplyT(func(v *StackSet) StackSetAutoDeploymentPtrOutput { return v.AutoDeployment }).(StackSetAutoDeploymentPtrOutput)
}

// Specifies whether you are acting as an account administrator in the organization's management account or as a delegated administrator in a member account. Valid values: `SELF` (default), `DELEGATED_ADMIN`.
func (o StackSetOutput) CallAs() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *StackSet) pulumi.StringPtrOutput { return v.CallAs }).(pulumi.StringPtrOutput)
}

// A list of capabilities. Valid values: `CAPABILITY_IAM`, `CAPABILITY_NAMED_IAM`, `CAPABILITY_AUTO_EXPAND`.
func (o StackSetOutput) Capabilities() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *StackSet) pulumi.StringArrayOutput { return v.Capabilities }).(pulumi.StringArrayOutput)
}

// Description of the StackSet.
func (o StackSetOutput) Description() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *StackSet) pulumi.StringPtrOutput { return v.Description }).(pulumi.StringPtrOutput)
}

// Name of the IAM Role in all target accounts for StackSet operations. Defaults to `AWSCloudFormationStackSetExecutionRole` when using the `SELF_MANAGED` permission model. This should not be defined when using the `SERVICE_MANAGED` permission model.
func (o StackSetOutput) ExecutionRoleName() pulumi.StringOutput {
	return o.ApplyT(func(v *StackSet) pulumi.StringOutput { return v.ExecutionRoleName }).(pulumi.StringOutput)
}

// Configuration block to allow StackSets to perform non-conflicting operations concurrently and queues conflicting operations.
func (o StackSetOutput) ManagedExecution() StackSetManagedExecutionPtrOutput {
	return o.ApplyT(func(v *StackSet) StackSetManagedExecutionPtrOutput { return v.ManagedExecution }).(StackSetManagedExecutionPtrOutput)
}

// Name of the StackSet. The name must be unique in the region where you create your StackSet. The name can contain only alphanumeric characters (case-sensitive) and hyphens. It must start with an alphabetic character and cannot be longer than 128 characters.
func (o StackSetOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *StackSet) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// Preferences for how AWS CloudFormation performs a stack set update.
func (o StackSetOutput) OperationPreferences() StackSetOperationPreferencesPtrOutput {
	return o.ApplyT(func(v *StackSet) StackSetOperationPreferencesPtrOutput { return v.OperationPreferences }).(StackSetOperationPreferencesPtrOutput)
}

// Key-value map of input parameters for the StackSet template. All template parameters, including those with a `Default`, must be configured or ignored with `lifecycle` configuration block `ignoreChanges` argument. All `NoEcho` template parameters must be ignored with the `lifecycle` configuration block `ignoreChanges` argument.
func (o StackSetOutput) Parameters() pulumi.StringMapOutput {
	return o.ApplyT(func(v *StackSet) pulumi.StringMapOutput { return v.Parameters }).(pulumi.StringMapOutput)
}

// Describes how the IAM roles required for your StackSet are created. Valid values: `SELF_MANAGED` (default), `SERVICE_MANAGED`.
func (o StackSetOutput) PermissionModel() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *StackSet) pulumi.StringPtrOutput { return v.PermissionModel }).(pulumi.StringPtrOutput)
}

// Unique identifier of the StackSet.
func (o StackSetOutput) StackSetId() pulumi.StringOutput {
	return o.ApplyT(func(v *StackSet) pulumi.StringOutput { return v.StackSetId }).(pulumi.StringOutput)
}

// Key-value map of tags to associate with this StackSet and the Stacks created from it. AWS CloudFormation also propagates these tags to supported resources that are created in the Stacks. A maximum number of 50 tags can be specified. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o StackSetOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *StackSet) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o StackSetOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *StackSet) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

// String containing the CloudFormation template body. Maximum size: 51,200 bytes. Conflicts with `templateUrl`.
func (o StackSetOutput) TemplateBody() pulumi.StringOutput {
	return o.ApplyT(func(v *StackSet) pulumi.StringOutput { return v.TemplateBody }).(pulumi.StringOutput)
}

// String containing the location of a file containing the CloudFormation template body. The URL must point to a template that is located in an Amazon S3 bucket. Maximum location file size: 460,800 bytes. Conflicts with `templateBody`.
func (o StackSetOutput) TemplateUrl() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *StackSet) pulumi.StringPtrOutput { return v.TemplateUrl }).(pulumi.StringPtrOutput)
}

type StackSetArrayOutput struct{ *pulumi.OutputState }

func (StackSetArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*StackSet)(nil)).Elem()
}

func (o StackSetArrayOutput) ToStackSetArrayOutput() StackSetArrayOutput {
	return o
}

func (o StackSetArrayOutput) ToStackSetArrayOutputWithContext(ctx context.Context) StackSetArrayOutput {
	return o
}

func (o StackSetArrayOutput) Index(i pulumi.IntInput) StackSetOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *StackSet {
		return vs[0].([]*StackSet)[vs[1].(int)]
	}).(StackSetOutput)
}

type StackSetMapOutput struct{ *pulumi.OutputState }

func (StackSetMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*StackSet)(nil)).Elem()
}

func (o StackSetMapOutput) ToStackSetMapOutput() StackSetMapOutput {
	return o
}

func (o StackSetMapOutput) ToStackSetMapOutputWithContext(ctx context.Context) StackSetMapOutput {
	return o
}

func (o StackSetMapOutput) MapIndex(k pulumi.StringInput) StackSetOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *StackSet {
		return vs[0].(map[string]*StackSet)[vs[1].(string)]
	}).(StackSetOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*StackSetInput)(nil)).Elem(), &StackSet{})
	pulumi.RegisterInputType(reflect.TypeOf((*StackSetArrayInput)(nil)).Elem(), StackSetArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*StackSetMapInput)(nil)).Elem(), StackSetMap{})
	pulumi.RegisterOutputType(StackSetOutput{})
	pulumi.RegisterOutputType(StackSetArrayOutput{})
	pulumi.RegisterOutputType(StackSetMapOutput{})
}
