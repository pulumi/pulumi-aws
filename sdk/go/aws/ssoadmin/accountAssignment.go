// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package ssoadmin

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a Single Sign-On (SSO) Account Assignment resource
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/identitystore"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/ssoadmin"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			example, err := ssoadmin.GetInstances(ctx, map[string]interface{}{}, nil)
//			if err != nil {
//				return err
//			}
//			exampleGetPermissionSet, err := ssoadmin.LookupPermissionSet(ctx, &ssoadmin.LookupPermissionSetArgs{
//				InstanceArn: example.Arns[0],
//				Name:        pulumi.StringRef("AWSReadOnlyAccess"),
//			}, nil)
//			if err != nil {
//				return err
//			}
//			exampleGetGroup, err := identitystore.LookupGroup(ctx, &identitystore.LookupGroupArgs{
//				IdentityStoreId: example.IdentityStoreIds[0],
//				AlternateIdentifier: identitystore.GetGroupAlternateIdentifier{
//					UniqueAttribute: identitystore.GetGroupAlternateIdentifierUniqueAttribute{
//						AttributePath:  "DisplayName",
//						AttributeValue: "ExampleGroup",
//					},
//				},
//			}, nil)
//			if err != nil {
//				return err
//			}
//			_, err = ssoadmin.NewAccountAssignment(ctx, "example", &ssoadmin.AccountAssignmentArgs{
//				InstanceArn:      pulumi.String(example.Arns[0]),
//				PermissionSetArn: pulumi.String(exampleGetPermissionSet.Arn),
//				PrincipalId:      pulumi.String(exampleGetGroup.GroupId),
//				PrincipalType:    pulumi.String("GROUP"),
//				TargetId:         pulumi.String("123456789012"),
//				TargetType:       pulumi.String("AWS_ACCOUNT"),
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
// ### With Managed Policy Attachment
//
// > Because destruction of a managed policy attachment resource also re-provisions the associated permission set to all accounts, explicitly indicating the dependency with the account assignment resource via the `dependsOn` meta argument is necessary to ensure proper deletion order when these resources are used together.
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/identitystore"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/ssoadmin"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			example, err := ssoadmin.GetInstances(ctx, map[string]interface{}{}, nil)
//			if err != nil {
//				return err
//			}
//			examplePermissionSet, err := ssoadmin.NewPermissionSet(ctx, "example", &ssoadmin.PermissionSetArgs{
//				Name:        pulumi.String("Example"),
//				InstanceArn: pulumi.String(example.Arns[0]),
//			})
//			if err != nil {
//				return err
//			}
//			exampleGroup, err := identitystore.NewGroup(ctx, "example", &identitystore.GroupArgs{
//				IdentityStoreId: pulumi.String(example.IdentityStoreIds[0]),
//				DisplayName:     pulumi.String("Admin"),
//				Description:     pulumi.String("Admin Group"),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = ssoadmin.NewAccountAssignment(ctx, "account_assignment", &ssoadmin.AccountAssignmentArgs{
//				InstanceArn:      pulumi.String(example.Arns[0]),
//				PermissionSetArn: examplePermissionSet.Arn,
//				PrincipalId:      exampleGroup.GroupId,
//				PrincipalType:    pulumi.String("GROUP"),
//				TargetId:         pulumi.String("123456789012"),
//				TargetType:       pulumi.String("AWS_ACCOUNT"),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = ssoadmin.NewManagedPolicyAttachment(ctx, "example", &ssoadmin.ManagedPolicyAttachmentArgs{
//				InstanceArn:      pulumi.String(example.Arns[0]),
//				ManagedPolicyArn: pulumi.String("arn:aws:iam::aws:policy/AlexaForBusinessDeviceSetup"),
//				PermissionSetArn: examplePermissionSet.Arn,
//			}, pulumi.DependsOn([]pulumi.Resource{
//				exampleAwsSsoadminAccountAssignment,
//			}))
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
// Using `pulumi import`, import SSO Account Assignments using the `principal_id`, `principal_type`, `target_id`, `target_type`, `permission_set_arn`, `instance_arn` separated by commas (`,`). For example:
//
// ```sh
// $ pulumi import aws:ssoadmin/accountAssignment:AccountAssignment example f81d4fae-7dec-11d0-a765-00a0c91e6bf6,GROUP,1234567890,AWS_ACCOUNT,arn:aws:sso:::permissionSet/ssoins-0123456789abcdef/ps-0123456789abcdef,arn:aws:sso:::instance/ssoins-0123456789abcdef
// ```
type AccountAssignment struct {
	pulumi.CustomResourceState

	// The Amazon Resource Name (ARN) of the SSO Instance.
	InstanceArn pulumi.StringOutput `pulumi:"instanceArn"`
	// The Amazon Resource Name (ARN) of the Permission Set that the admin wants to grant the principal access to.
	PermissionSetArn pulumi.StringOutput `pulumi:"permissionSetArn"`
	// An identifier for an object in SSO, such as a user or group. PrincipalIds are GUIDs (For example, `f81d4fae-7dec-11d0-a765-00a0c91e6bf6`).
	PrincipalId pulumi.StringOutput `pulumi:"principalId"`
	// The entity type for which the assignment will be created. Valid values: `USER`, `GROUP`.
	PrincipalType pulumi.StringOutput `pulumi:"principalType"`
	// An AWS account identifier, typically a 10-12 digit string.
	TargetId pulumi.StringOutput `pulumi:"targetId"`
	// The entity type for which the assignment will be created. Valid values: `AWS_ACCOUNT`.
	TargetType pulumi.StringPtrOutput `pulumi:"targetType"`
}

// NewAccountAssignment registers a new resource with the given unique name, arguments, and options.
func NewAccountAssignment(ctx *pulumi.Context,
	name string, args *AccountAssignmentArgs, opts ...pulumi.ResourceOption) (*AccountAssignment, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.InstanceArn == nil {
		return nil, errors.New("invalid value for required argument 'InstanceArn'")
	}
	if args.PermissionSetArn == nil {
		return nil, errors.New("invalid value for required argument 'PermissionSetArn'")
	}
	if args.PrincipalId == nil {
		return nil, errors.New("invalid value for required argument 'PrincipalId'")
	}
	if args.PrincipalType == nil {
		return nil, errors.New("invalid value for required argument 'PrincipalType'")
	}
	if args.TargetId == nil {
		return nil, errors.New("invalid value for required argument 'TargetId'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource AccountAssignment
	err := ctx.RegisterResource("aws:ssoadmin/accountAssignment:AccountAssignment", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetAccountAssignment gets an existing AccountAssignment resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetAccountAssignment(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *AccountAssignmentState, opts ...pulumi.ResourceOption) (*AccountAssignment, error) {
	var resource AccountAssignment
	err := ctx.ReadResource("aws:ssoadmin/accountAssignment:AccountAssignment", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering AccountAssignment resources.
type accountAssignmentState struct {
	// The Amazon Resource Name (ARN) of the SSO Instance.
	InstanceArn *string `pulumi:"instanceArn"`
	// The Amazon Resource Name (ARN) of the Permission Set that the admin wants to grant the principal access to.
	PermissionSetArn *string `pulumi:"permissionSetArn"`
	// An identifier for an object in SSO, such as a user or group. PrincipalIds are GUIDs (For example, `f81d4fae-7dec-11d0-a765-00a0c91e6bf6`).
	PrincipalId *string `pulumi:"principalId"`
	// The entity type for which the assignment will be created. Valid values: `USER`, `GROUP`.
	PrincipalType *string `pulumi:"principalType"`
	// An AWS account identifier, typically a 10-12 digit string.
	TargetId *string `pulumi:"targetId"`
	// The entity type for which the assignment will be created. Valid values: `AWS_ACCOUNT`.
	TargetType *string `pulumi:"targetType"`
}

type AccountAssignmentState struct {
	// The Amazon Resource Name (ARN) of the SSO Instance.
	InstanceArn pulumi.StringPtrInput
	// The Amazon Resource Name (ARN) of the Permission Set that the admin wants to grant the principal access to.
	PermissionSetArn pulumi.StringPtrInput
	// An identifier for an object in SSO, such as a user or group. PrincipalIds are GUIDs (For example, `f81d4fae-7dec-11d0-a765-00a0c91e6bf6`).
	PrincipalId pulumi.StringPtrInput
	// The entity type for which the assignment will be created. Valid values: `USER`, `GROUP`.
	PrincipalType pulumi.StringPtrInput
	// An AWS account identifier, typically a 10-12 digit string.
	TargetId pulumi.StringPtrInput
	// The entity type for which the assignment will be created. Valid values: `AWS_ACCOUNT`.
	TargetType pulumi.StringPtrInput
}

func (AccountAssignmentState) ElementType() reflect.Type {
	return reflect.TypeOf((*accountAssignmentState)(nil)).Elem()
}

type accountAssignmentArgs struct {
	// The Amazon Resource Name (ARN) of the SSO Instance.
	InstanceArn string `pulumi:"instanceArn"`
	// The Amazon Resource Name (ARN) of the Permission Set that the admin wants to grant the principal access to.
	PermissionSetArn string `pulumi:"permissionSetArn"`
	// An identifier for an object in SSO, such as a user or group. PrincipalIds are GUIDs (For example, `f81d4fae-7dec-11d0-a765-00a0c91e6bf6`).
	PrincipalId string `pulumi:"principalId"`
	// The entity type for which the assignment will be created. Valid values: `USER`, `GROUP`.
	PrincipalType string `pulumi:"principalType"`
	// An AWS account identifier, typically a 10-12 digit string.
	TargetId string `pulumi:"targetId"`
	// The entity type for which the assignment will be created. Valid values: `AWS_ACCOUNT`.
	TargetType *string `pulumi:"targetType"`
}

// The set of arguments for constructing a AccountAssignment resource.
type AccountAssignmentArgs struct {
	// The Amazon Resource Name (ARN) of the SSO Instance.
	InstanceArn pulumi.StringInput
	// The Amazon Resource Name (ARN) of the Permission Set that the admin wants to grant the principal access to.
	PermissionSetArn pulumi.StringInput
	// An identifier for an object in SSO, such as a user or group. PrincipalIds are GUIDs (For example, `f81d4fae-7dec-11d0-a765-00a0c91e6bf6`).
	PrincipalId pulumi.StringInput
	// The entity type for which the assignment will be created. Valid values: `USER`, `GROUP`.
	PrincipalType pulumi.StringInput
	// An AWS account identifier, typically a 10-12 digit string.
	TargetId pulumi.StringInput
	// The entity type for which the assignment will be created. Valid values: `AWS_ACCOUNT`.
	TargetType pulumi.StringPtrInput
}

func (AccountAssignmentArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*accountAssignmentArgs)(nil)).Elem()
}

type AccountAssignmentInput interface {
	pulumi.Input

	ToAccountAssignmentOutput() AccountAssignmentOutput
	ToAccountAssignmentOutputWithContext(ctx context.Context) AccountAssignmentOutput
}

func (*AccountAssignment) ElementType() reflect.Type {
	return reflect.TypeOf((**AccountAssignment)(nil)).Elem()
}

func (i *AccountAssignment) ToAccountAssignmentOutput() AccountAssignmentOutput {
	return i.ToAccountAssignmentOutputWithContext(context.Background())
}

func (i *AccountAssignment) ToAccountAssignmentOutputWithContext(ctx context.Context) AccountAssignmentOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AccountAssignmentOutput)
}

// AccountAssignmentArrayInput is an input type that accepts AccountAssignmentArray and AccountAssignmentArrayOutput values.
// You can construct a concrete instance of `AccountAssignmentArrayInput` via:
//
//	AccountAssignmentArray{ AccountAssignmentArgs{...} }
type AccountAssignmentArrayInput interface {
	pulumi.Input

	ToAccountAssignmentArrayOutput() AccountAssignmentArrayOutput
	ToAccountAssignmentArrayOutputWithContext(context.Context) AccountAssignmentArrayOutput
}

type AccountAssignmentArray []AccountAssignmentInput

func (AccountAssignmentArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*AccountAssignment)(nil)).Elem()
}

func (i AccountAssignmentArray) ToAccountAssignmentArrayOutput() AccountAssignmentArrayOutput {
	return i.ToAccountAssignmentArrayOutputWithContext(context.Background())
}

func (i AccountAssignmentArray) ToAccountAssignmentArrayOutputWithContext(ctx context.Context) AccountAssignmentArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AccountAssignmentArrayOutput)
}

// AccountAssignmentMapInput is an input type that accepts AccountAssignmentMap and AccountAssignmentMapOutput values.
// You can construct a concrete instance of `AccountAssignmentMapInput` via:
//
//	AccountAssignmentMap{ "key": AccountAssignmentArgs{...} }
type AccountAssignmentMapInput interface {
	pulumi.Input

	ToAccountAssignmentMapOutput() AccountAssignmentMapOutput
	ToAccountAssignmentMapOutputWithContext(context.Context) AccountAssignmentMapOutput
}

type AccountAssignmentMap map[string]AccountAssignmentInput

func (AccountAssignmentMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*AccountAssignment)(nil)).Elem()
}

func (i AccountAssignmentMap) ToAccountAssignmentMapOutput() AccountAssignmentMapOutput {
	return i.ToAccountAssignmentMapOutputWithContext(context.Background())
}

func (i AccountAssignmentMap) ToAccountAssignmentMapOutputWithContext(ctx context.Context) AccountAssignmentMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AccountAssignmentMapOutput)
}

type AccountAssignmentOutput struct{ *pulumi.OutputState }

func (AccountAssignmentOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**AccountAssignment)(nil)).Elem()
}

func (o AccountAssignmentOutput) ToAccountAssignmentOutput() AccountAssignmentOutput {
	return o
}

func (o AccountAssignmentOutput) ToAccountAssignmentOutputWithContext(ctx context.Context) AccountAssignmentOutput {
	return o
}

// The Amazon Resource Name (ARN) of the SSO Instance.
func (o AccountAssignmentOutput) InstanceArn() pulumi.StringOutput {
	return o.ApplyT(func(v *AccountAssignment) pulumi.StringOutput { return v.InstanceArn }).(pulumi.StringOutput)
}

// The Amazon Resource Name (ARN) of the Permission Set that the admin wants to grant the principal access to.
func (o AccountAssignmentOutput) PermissionSetArn() pulumi.StringOutput {
	return o.ApplyT(func(v *AccountAssignment) pulumi.StringOutput { return v.PermissionSetArn }).(pulumi.StringOutput)
}

// An identifier for an object in SSO, such as a user or group. PrincipalIds are GUIDs (For example, `f81d4fae-7dec-11d0-a765-00a0c91e6bf6`).
func (o AccountAssignmentOutput) PrincipalId() pulumi.StringOutput {
	return o.ApplyT(func(v *AccountAssignment) pulumi.StringOutput { return v.PrincipalId }).(pulumi.StringOutput)
}

// The entity type for which the assignment will be created. Valid values: `USER`, `GROUP`.
func (o AccountAssignmentOutput) PrincipalType() pulumi.StringOutput {
	return o.ApplyT(func(v *AccountAssignment) pulumi.StringOutput { return v.PrincipalType }).(pulumi.StringOutput)
}

// An AWS account identifier, typically a 10-12 digit string.
func (o AccountAssignmentOutput) TargetId() pulumi.StringOutput {
	return o.ApplyT(func(v *AccountAssignment) pulumi.StringOutput { return v.TargetId }).(pulumi.StringOutput)
}

// The entity type for which the assignment will be created. Valid values: `AWS_ACCOUNT`.
func (o AccountAssignmentOutput) TargetType() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *AccountAssignment) pulumi.StringPtrOutput { return v.TargetType }).(pulumi.StringPtrOutput)
}

type AccountAssignmentArrayOutput struct{ *pulumi.OutputState }

func (AccountAssignmentArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*AccountAssignment)(nil)).Elem()
}

func (o AccountAssignmentArrayOutput) ToAccountAssignmentArrayOutput() AccountAssignmentArrayOutput {
	return o
}

func (o AccountAssignmentArrayOutput) ToAccountAssignmentArrayOutputWithContext(ctx context.Context) AccountAssignmentArrayOutput {
	return o
}

func (o AccountAssignmentArrayOutput) Index(i pulumi.IntInput) AccountAssignmentOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *AccountAssignment {
		return vs[0].([]*AccountAssignment)[vs[1].(int)]
	}).(AccountAssignmentOutput)
}

type AccountAssignmentMapOutput struct{ *pulumi.OutputState }

func (AccountAssignmentMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*AccountAssignment)(nil)).Elem()
}

func (o AccountAssignmentMapOutput) ToAccountAssignmentMapOutput() AccountAssignmentMapOutput {
	return o
}

func (o AccountAssignmentMapOutput) ToAccountAssignmentMapOutputWithContext(ctx context.Context) AccountAssignmentMapOutput {
	return o
}

func (o AccountAssignmentMapOutput) MapIndex(k pulumi.StringInput) AccountAssignmentOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *AccountAssignment {
		return vs[0].(map[string]*AccountAssignment)[vs[1].(string)]
	}).(AccountAssignmentOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*AccountAssignmentInput)(nil)).Elem(), &AccountAssignment{})
	pulumi.RegisterInputType(reflect.TypeOf((*AccountAssignmentArrayInput)(nil)).Elem(), AccountAssignmentArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*AccountAssignmentMapInput)(nil)).Elem(), AccountAssignmentMap{})
	pulumi.RegisterOutputType(AccountAssignmentOutput{})
	pulumi.RegisterOutputType(AccountAssignmentArrayOutput{})
	pulumi.RegisterOutputType(AccountAssignmentMapOutput{})
}
