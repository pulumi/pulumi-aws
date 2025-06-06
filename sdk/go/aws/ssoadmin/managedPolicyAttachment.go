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

// Provides an IAM managed policy for a Single Sign-On (SSO) Permission Set resource
//
// > **NOTE:** Creating this resource will automatically [Provision the Permission Set](https://docs.aws.amazon.com/singlesignon/latest/APIReference/API_ProvisionPermissionSet.html) to apply the corresponding updates to all assigned accounts.
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
//			_, err = ssoadmin.NewManagedPolicyAttachment(ctx, "example", &ssoadmin.ManagedPolicyAttachmentArgs{
//				InstanceArn:      pulumi.String(example.Arns[0]),
//				ManagedPolicyArn: pulumi.String("arn:aws:iam::aws:policy/AlexaForBusinessDeviceSetup"),
//				PermissionSetArn: examplePermissionSet.Arn,
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
// ### With Account Assignment
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
//			exampleAccountAssignment, err := ssoadmin.NewAccountAssignment(ctx, "example", &ssoadmin.AccountAssignmentArgs{
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
//				exampleAccountAssignment,
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
// Using `pulumi import`, import SSO Managed Policy Attachments using the `managed_policy_arn`, `permission_set_arn`, and `instance_arn` separated by a comma (`,`). For example:
//
// ```sh
// $ pulumi import aws:ssoadmin/managedPolicyAttachment:ManagedPolicyAttachment example arn:aws:iam::aws:policy/AlexaForBusinessDeviceSetup,arn:aws:sso:::permissionSet/ssoins-2938j0x8920sbj72/ps-80383020jr9302rk,arn:aws:sso:::instance/ssoins-2938j0x8920sbj72
// ```
type ManagedPolicyAttachment struct {
	pulumi.CustomResourceState

	// The Amazon Resource Name (ARN) of the SSO Instance under which the operation will be executed.
	InstanceArn pulumi.StringOutput `pulumi:"instanceArn"`
	// The IAM managed policy Amazon Resource Name (ARN) to be attached to the Permission Set.
	ManagedPolicyArn pulumi.StringOutput `pulumi:"managedPolicyArn"`
	// The name of the IAM Managed Policy.
	ManagedPolicyName pulumi.StringOutput `pulumi:"managedPolicyName"`
	// The Amazon Resource Name (ARN) of the Permission Set.
	PermissionSetArn pulumi.StringOutput `pulumi:"permissionSetArn"`
}

// NewManagedPolicyAttachment registers a new resource with the given unique name, arguments, and options.
func NewManagedPolicyAttachment(ctx *pulumi.Context,
	name string, args *ManagedPolicyAttachmentArgs, opts ...pulumi.ResourceOption) (*ManagedPolicyAttachment, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.InstanceArn == nil {
		return nil, errors.New("invalid value for required argument 'InstanceArn'")
	}
	if args.ManagedPolicyArn == nil {
		return nil, errors.New("invalid value for required argument 'ManagedPolicyArn'")
	}
	if args.PermissionSetArn == nil {
		return nil, errors.New("invalid value for required argument 'PermissionSetArn'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource ManagedPolicyAttachment
	err := ctx.RegisterResource("aws:ssoadmin/managedPolicyAttachment:ManagedPolicyAttachment", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetManagedPolicyAttachment gets an existing ManagedPolicyAttachment resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetManagedPolicyAttachment(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ManagedPolicyAttachmentState, opts ...pulumi.ResourceOption) (*ManagedPolicyAttachment, error) {
	var resource ManagedPolicyAttachment
	err := ctx.ReadResource("aws:ssoadmin/managedPolicyAttachment:ManagedPolicyAttachment", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering ManagedPolicyAttachment resources.
type managedPolicyAttachmentState struct {
	// The Amazon Resource Name (ARN) of the SSO Instance under which the operation will be executed.
	InstanceArn *string `pulumi:"instanceArn"`
	// The IAM managed policy Amazon Resource Name (ARN) to be attached to the Permission Set.
	ManagedPolicyArn *string `pulumi:"managedPolicyArn"`
	// The name of the IAM Managed Policy.
	ManagedPolicyName *string `pulumi:"managedPolicyName"`
	// The Amazon Resource Name (ARN) of the Permission Set.
	PermissionSetArn *string `pulumi:"permissionSetArn"`
}

type ManagedPolicyAttachmentState struct {
	// The Amazon Resource Name (ARN) of the SSO Instance under which the operation will be executed.
	InstanceArn pulumi.StringPtrInput
	// The IAM managed policy Amazon Resource Name (ARN) to be attached to the Permission Set.
	ManagedPolicyArn pulumi.StringPtrInput
	// The name of the IAM Managed Policy.
	ManagedPolicyName pulumi.StringPtrInput
	// The Amazon Resource Name (ARN) of the Permission Set.
	PermissionSetArn pulumi.StringPtrInput
}

func (ManagedPolicyAttachmentState) ElementType() reflect.Type {
	return reflect.TypeOf((*managedPolicyAttachmentState)(nil)).Elem()
}

type managedPolicyAttachmentArgs struct {
	// The Amazon Resource Name (ARN) of the SSO Instance under which the operation will be executed.
	InstanceArn string `pulumi:"instanceArn"`
	// The IAM managed policy Amazon Resource Name (ARN) to be attached to the Permission Set.
	ManagedPolicyArn string `pulumi:"managedPolicyArn"`
	// The Amazon Resource Name (ARN) of the Permission Set.
	PermissionSetArn string `pulumi:"permissionSetArn"`
}

// The set of arguments for constructing a ManagedPolicyAttachment resource.
type ManagedPolicyAttachmentArgs struct {
	// The Amazon Resource Name (ARN) of the SSO Instance under which the operation will be executed.
	InstanceArn pulumi.StringInput
	// The IAM managed policy Amazon Resource Name (ARN) to be attached to the Permission Set.
	ManagedPolicyArn pulumi.StringInput
	// The Amazon Resource Name (ARN) of the Permission Set.
	PermissionSetArn pulumi.StringInput
}

func (ManagedPolicyAttachmentArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*managedPolicyAttachmentArgs)(nil)).Elem()
}

type ManagedPolicyAttachmentInput interface {
	pulumi.Input

	ToManagedPolicyAttachmentOutput() ManagedPolicyAttachmentOutput
	ToManagedPolicyAttachmentOutputWithContext(ctx context.Context) ManagedPolicyAttachmentOutput
}

func (*ManagedPolicyAttachment) ElementType() reflect.Type {
	return reflect.TypeOf((**ManagedPolicyAttachment)(nil)).Elem()
}

func (i *ManagedPolicyAttachment) ToManagedPolicyAttachmentOutput() ManagedPolicyAttachmentOutput {
	return i.ToManagedPolicyAttachmentOutputWithContext(context.Background())
}

func (i *ManagedPolicyAttachment) ToManagedPolicyAttachmentOutputWithContext(ctx context.Context) ManagedPolicyAttachmentOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ManagedPolicyAttachmentOutput)
}

// ManagedPolicyAttachmentArrayInput is an input type that accepts ManagedPolicyAttachmentArray and ManagedPolicyAttachmentArrayOutput values.
// You can construct a concrete instance of `ManagedPolicyAttachmentArrayInput` via:
//
//	ManagedPolicyAttachmentArray{ ManagedPolicyAttachmentArgs{...} }
type ManagedPolicyAttachmentArrayInput interface {
	pulumi.Input

	ToManagedPolicyAttachmentArrayOutput() ManagedPolicyAttachmentArrayOutput
	ToManagedPolicyAttachmentArrayOutputWithContext(context.Context) ManagedPolicyAttachmentArrayOutput
}

type ManagedPolicyAttachmentArray []ManagedPolicyAttachmentInput

func (ManagedPolicyAttachmentArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ManagedPolicyAttachment)(nil)).Elem()
}

func (i ManagedPolicyAttachmentArray) ToManagedPolicyAttachmentArrayOutput() ManagedPolicyAttachmentArrayOutput {
	return i.ToManagedPolicyAttachmentArrayOutputWithContext(context.Background())
}

func (i ManagedPolicyAttachmentArray) ToManagedPolicyAttachmentArrayOutputWithContext(ctx context.Context) ManagedPolicyAttachmentArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ManagedPolicyAttachmentArrayOutput)
}

// ManagedPolicyAttachmentMapInput is an input type that accepts ManagedPolicyAttachmentMap and ManagedPolicyAttachmentMapOutput values.
// You can construct a concrete instance of `ManagedPolicyAttachmentMapInput` via:
//
//	ManagedPolicyAttachmentMap{ "key": ManagedPolicyAttachmentArgs{...} }
type ManagedPolicyAttachmentMapInput interface {
	pulumi.Input

	ToManagedPolicyAttachmentMapOutput() ManagedPolicyAttachmentMapOutput
	ToManagedPolicyAttachmentMapOutputWithContext(context.Context) ManagedPolicyAttachmentMapOutput
}

type ManagedPolicyAttachmentMap map[string]ManagedPolicyAttachmentInput

func (ManagedPolicyAttachmentMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ManagedPolicyAttachment)(nil)).Elem()
}

func (i ManagedPolicyAttachmentMap) ToManagedPolicyAttachmentMapOutput() ManagedPolicyAttachmentMapOutput {
	return i.ToManagedPolicyAttachmentMapOutputWithContext(context.Background())
}

func (i ManagedPolicyAttachmentMap) ToManagedPolicyAttachmentMapOutputWithContext(ctx context.Context) ManagedPolicyAttachmentMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ManagedPolicyAttachmentMapOutput)
}

type ManagedPolicyAttachmentOutput struct{ *pulumi.OutputState }

func (ManagedPolicyAttachmentOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**ManagedPolicyAttachment)(nil)).Elem()
}

func (o ManagedPolicyAttachmentOutput) ToManagedPolicyAttachmentOutput() ManagedPolicyAttachmentOutput {
	return o
}

func (o ManagedPolicyAttachmentOutput) ToManagedPolicyAttachmentOutputWithContext(ctx context.Context) ManagedPolicyAttachmentOutput {
	return o
}

// The Amazon Resource Name (ARN) of the SSO Instance under which the operation will be executed.
func (o ManagedPolicyAttachmentOutput) InstanceArn() pulumi.StringOutput {
	return o.ApplyT(func(v *ManagedPolicyAttachment) pulumi.StringOutput { return v.InstanceArn }).(pulumi.StringOutput)
}

// The IAM managed policy Amazon Resource Name (ARN) to be attached to the Permission Set.
func (o ManagedPolicyAttachmentOutput) ManagedPolicyArn() pulumi.StringOutput {
	return o.ApplyT(func(v *ManagedPolicyAttachment) pulumi.StringOutput { return v.ManagedPolicyArn }).(pulumi.StringOutput)
}

// The name of the IAM Managed Policy.
func (o ManagedPolicyAttachmentOutput) ManagedPolicyName() pulumi.StringOutput {
	return o.ApplyT(func(v *ManagedPolicyAttachment) pulumi.StringOutput { return v.ManagedPolicyName }).(pulumi.StringOutput)
}

// The Amazon Resource Name (ARN) of the Permission Set.
func (o ManagedPolicyAttachmentOutput) PermissionSetArn() pulumi.StringOutput {
	return o.ApplyT(func(v *ManagedPolicyAttachment) pulumi.StringOutput { return v.PermissionSetArn }).(pulumi.StringOutput)
}

type ManagedPolicyAttachmentArrayOutput struct{ *pulumi.OutputState }

func (ManagedPolicyAttachmentArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ManagedPolicyAttachment)(nil)).Elem()
}

func (o ManagedPolicyAttachmentArrayOutput) ToManagedPolicyAttachmentArrayOutput() ManagedPolicyAttachmentArrayOutput {
	return o
}

func (o ManagedPolicyAttachmentArrayOutput) ToManagedPolicyAttachmentArrayOutputWithContext(ctx context.Context) ManagedPolicyAttachmentArrayOutput {
	return o
}

func (o ManagedPolicyAttachmentArrayOutput) Index(i pulumi.IntInput) ManagedPolicyAttachmentOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *ManagedPolicyAttachment {
		return vs[0].([]*ManagedPolicyAttachment)[vs[1].(int)]
	}).(ManagedPolicyAttachmentOutput)
}

type ManagedPolicyAttachmentMapOutput struct{ *pulumi.OutputState }

func (ManagedPolicyAttachmentMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ManagedPolicyAttachment)(nil)).Elem()
}

func (o ManagedPolicyAttachmentMapOutput) ToManagedPolicyAttachmentMapOutput() ManagedPolicyAttachmentMapOutput {
	return o
}

func (o ManagedPolicyAttachmentMapOutput) ToManagedPolicyAttachmentMapOutputWithContext(ctx context.Context) ManagedPolicyAttachmentMapOutput {
	return o
}

func (o ManagedPolicyAttachmentMapOutput) MapIndex(k pulumi.StringInput) ManagedPolicyAttachmentOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *ManagedPolicyAttachment {
		return vs[0].(map[string]*ManagedPolicyAttachment)[vs[1].(string)]
	}).(ManagedPolicyAttachmentOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ManagedPolicyAttachmentInput)(nil)).Elem(), &ManagedPolicyAttachment{})
	pulumi.RegisterInputType(reflect.TypeOf((*ManagedPolicyAttachmentArrayInput)(nil)).Elem(), ManagedPolicyAttachmentArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ManagedPolicyAttachmentMapInput)(nil)).Elem(), ManagedPolicyAttachmentMap{})
	pulumi.RegisterOutputType(ManagedPolicyAttachmentOutput{})
	pulumi.RegisterOutputType(ManagedPolicyAttachmentArrayOutput{})
	pulumi.RegisterOutputType(ManagedPolicyAttachmentMapOutput{})
}
