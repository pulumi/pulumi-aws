// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package inspector2

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for associating accounts to existing Inspector instances.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/inspector2"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := inspector2.NewMemberAssociation(ctx, "example", &inspector2.MemberAssociationArgs{
//				AccountId: pulumi.String("123456789012"),
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
// Using `pulumi import`, import Amazon Inspector Member Association using the `account_id`. For example:
//
// ```sh
// $ pulumi import aws:inspector2/memberAssociation:MemberAssociation example 123456789012
// ```
type MemberAssociation struct {
	pulumi.CustomResourceState

	// ID of the account to associate
	AccountId pulumi.StringOutput `pulumi:"accountId"`
	// Account ID of the delegated administrator account
	DelegatedAdminAccountId pulumi.StringOutput `pulumi:"delegatedAdminAccountId"`
	// Status of the member relationship
	RelationshipStatus pulumi.StringOutput `pulumi:"relationshipStatus"`
	// Date and time of the last update of the relationship
	UpdatedAt pulumi.StringOutput `pulumi:"updatedAt"`
}

// NewMemberAssociation registers a new resource with the given unique name, arguments, and options.
func NewMemberAssociation(ctx *pulumi.Context,
	name string, args *MemberAssociationArgs, opts ...pulumi.ResourceOption) (*MemberAssociation, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.AccountId == nil {
		return nil, errors.New("invalid value for required argument 'AccountId'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource MemberAssociation
	err := ctx.RegisterResource("aws:inspector2/memberAssociation:MemberAssociation", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetMemberAssociation gets an existing MemberAssociation resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetMemberAssociation(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *MemberAssociationState, opts ...pulumi.ResourceOption) (*MemberAssociation, error) {
	var resource MemberAssociation
	err := ctx.ReadResource("aws:inspector2/memberAssociation:MemberAssociation", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering MemberAssociation resources.
type memberAssociationState struct {
	// ID of the account to associate
	AccountId *string `pulumi:"accountId"`
	// Account ID of the delegated administrator account
	DelegatedAdminAccountId *string `pulumi:"delegatedAdminAccountId"`
	// Status of the member relationship
	RelationshipStatus *string `pulumi:"relationshipStatus"`
	// Date and time of the last update of the relationship
	UpdatedAt *string `pulumi:"updatedAt"`
}

type MemberAssociationState struct {
	// ID of the account to associate
	AccountId pulumi.StringPtrInput
	// Account ID of the delegated administrator account
	DelegatedAdminAccountId pulumi.StringPtrInput
	// Status of the member relationship
	RelationshipStatus pulumi.StringPtrInput
	// Date and time of the last update of the relationship
	UpdatedAt pulumi.StringPtrInput
}

func (MemberAssociationState) ElementType() reflect.Type {
	return reflect.TypeOf((*memberAssociationState)(nil)).Elem()
}

type memberAssociationArgs struct {
	// ID of the account to associate
	AccountId string `pulumi:"accountId"`
}

// The set of arguments for constructing a MemberAssociation resource.
type MemberAssociationArgs struct {
	// ID of the account to associate
	AccountId pulumi.StringInput
}

func (MemberAssociationArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*memberAssociationArgs)(nil)).Elem()
}

type MemberAssociationInput interface {
	pulumi.Input

	ToMemberAssociationOutput() MemberAssociationOutput
	ToMemberAssociationOutputWithContext(ctx context.Context) MemberAssociationOutput
}

func (*MemberAssociation) ElementType() reflect.Type {
	return reflect.TypeOf((**MemberAssociation)(nil)).Elem()
}

func (i *MemberAssociation) ToMemberAssociationOutput() MemberAssociationOutput {
	return i.ToMemberAssociationOutputWithContext(context.Background())
}

func (i *MemberAssociation) ToMemberAssociationOutputWithContext(ctx context.Context) MemberAssociationOutput {
	return pulumi.ToOutputWithContext(ctx, i).(MemberAssociationOutput)
}

// MemberAssociationArrayInput is an input type that accepts MemberAssociationArray and MemberAssociationArrayOutput values.
// You can construct a concrete instance of `MemberAssociationArrayInput` via:
//
//	MemberAssociationArray{ MemberAssociationArgs{...} }
type MemberAssociationArrayInput interface {
	pulumi.Input

	ToMemberAssociationArrayOutput() MemberAssociationArrayOutput
	ToMemberAssociationArrayOutputWithContext(context.Context) MemberAssociationArrayOutput
}

type MemberAssociationArray []MemberAssociationInput

func (MemberAssociationArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*MemberAssociation)(nil)).Elem()
}

func (i MemberAssociationArray) ToMemberAssociationArrayOutput() MemberAssociationArrayOutput {
	return i.ToMemberAssociationArrayOutputWithContext(context.Background())
}

func (i MemberAssociationArray) ToMemberAssociationArrayOutputWithContext(ctx context.Context) MemberAssociationArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(MemberAssociationArrayOutput)
}

// MemberAssociationMapInput is an input type that accepts MemberAssociationMap and MemberAssociationMapOutput values.
// You can construct a concrete instance of `MemberAssociationMapInput` via:
//
//	MemberAssociationMap{ "key": MemberAssociationArgs{...} }
type MemberAssociationMapInput interface {
	pulumi.Input

	ToMemberAssociationMapOutput() MemberAssociationMapOutput
	ToMemberAssociationMapOutputWithContext(context.Context) MemberAssociationMapOutput
}

type MemberAssociationMap map[string]MemberAssociationInput

func (MemberAssociationMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*MemberAssociation)(nil)).Elem()
}

func (i MemberAssociationMap) ToMemberAssociationMapOutput() MemberAssociationMapOutput {
	return i.ToMemberAssociationMapOutputWithContext(context.Background())
}

func (i MemberAssociationMap) ToMemberAssociationMapOutputWithContext(ctx context.Context) MemberAssociationMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(MemberAssociationMapOutput)
}

type MemberAssociationOutput struct{ *pulumi.OutputState }

func (MemberAssociationOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**MemberAssociation)(nil)).Elem()
}

func (o MemberAssociationOutput) ToMemberAssociationOutput() MemberAssociationOutput {
	return o
}

func (o MemberAssociationOutput) ToMemberAssociationOutputWithContext(ctx context.Context) MemberAssociationOutput {
	return o
}

// ID of the account to associate
func (o MemberAssociationOutput) AccountId() pulumi.StringOutput {
	return o.ApplyT(func(v *MemberAssociation) pulumi.StringOutput { return v.AccountId }).(pulumi.StringOutput)
}

// Account ID of the delegated administrator account
func (o MemberAssociationOutput) DelegatedAdminAccountId() pulumi.StringOutput {
	return o.ApplyT(func(v *MemberAssociation) pulumi.StringOutput { return v.DelegatedAdminAccountId }).(pulumi.StringOutput)
}

// Status of the member relationship
func (o MemberAssociationOutput) RelationshipStatus() pulumi.StringOutput {
	return o.ApplyT(func(v *MemberAssociation) pulumi.StringOutput { return v.RelationshipStatus }).(pulumi.StringOutput)
}

// Date and time of the last update of the relationship
func (o MemberAssociationOutput) UpdatedAt() pulumi.StringOutput {
	return o.ApplyT(func(v *MemberAssociation) pulumi.StringOutput { return v.UpdatedAt }).(pulumi.StringOutput)
}

type MemberAssociationArrayOutput struct{ *pulumi.OutputState }

func (MemberAssociationArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*MemberAssociation)(nil)).Elem()
}

func (o MemberAssociationArrayOutput) ToMemberAssociationArrayOutput() MemberAssociationArrayOutput {
	return o
}

func (o MemberAssociationArrayOutput) ToMemberAssociationArrayOutputWithContext(ctx context.Context) MemberAssociationArrayOutput {
	return o
}

func (o MemberAssociationArrayOutput) Index(i pulumi.IntInput) MemberAssociationOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *MemberAssociation {
		return vs[0].([]*MemberAssociation)[vs[1].(int)]
	}).(MemberAssociationOutput)
}

type MemberAssociationMapOutput struct{ *pulumi.OutputState }

func (MemberAssociationMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*MemberAssociation)(nil)).Elem()
}

func (o MemberAssociationMapOutput) ToMemberAssociationMapOutput() MemberAssociationMapOutput {
	return o
}

func (o MemberAssociationMapOutput) ToMemberAssociationMapOutputWithContext(ctx context.Context) MemberAssociationMapOutput {
	return o
}

func (o MemberAssociationMapOutput) MapIndex(k pulumi.StringInput) MemberAssociationOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *MemberAssociation {
		return vs[0].(map[string]*MemberAssociation)[vs[1].(string)]
	}).(MemberAssociationOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*MemberAssociationInput)(nil)).Elem(), &MemberAssociation{})
	pulumi.RegisterInputType(reflect.TypeOf((*MemberAssociationArrayInput)(nil)).Elem(), MemberAssociationArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*MemberAssociationMapInput)(nil)).Elem(), MemberAssociationMap{})
	pulumi.RegisterOutputType(MemberAssociationOutput{})
	pulumi.RegisterOutputType(MemberAssociationArrayOutput{})
	pulumi.RegisterOutputType(MemberAssociationMapOutput{})
}
