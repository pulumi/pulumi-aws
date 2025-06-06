// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package synthetics

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a Synthetics Group Association resource.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/synthetics"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := synthetics.NewGroupAssociation(ctx, "example", &synthetics.GroupAssociationArgs{
//				GroupName: pulumi.Any(exampleAwsSyntheticsGroup.Name),
//				CanaryArn: pulumi.Any(exampleAwsSyntheticsCanary.Arn),
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
// Using `pulumi import`, import CloudWatch Synthetics Group Association using the `canary_arn,group_name`. For example:
//
// ```sh
// $ pulumi import aws:synthetics/groupAssociation:GroupAssociation example arn:aws:synthetics:us-west-2:123456789012:canary:tf-acc-test-abcd1234,examplename
// ```
type GroupAssociation struct {
	pulumi.CustomResourceState

	// ARN of the canary.
	CanaryArn pulumi.StringOutput `pulumi:"canaryArn"`
	GroupArn  pulumi.StringOutput `pulumi:"groupArn"`
	// ID of the Group.
	GroupId pulumi.StringOutput `pulumi:"groupId"`
	// Name of the group that the canary will be associated with.
	GroupName pulumi.StringOutput `pulumi:"groupName"`
}

// NewGroupAssociation registers a new resource with the given unique name, arguments, and options.
func NewGroupAssociation(ctx *pulumi.Context,
	name string, args *GroupAssociationArgs, opts ...pulumi.ResourceOption) (*GroupAssociation, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.CanaryArn == nil {
		return nil, errors.New("invalid value for required argument 'CanaryArn'")
	}
	if args.GroupName == nil {
		return nil, errors.New("invalid value for required argument 'GroupName'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource GroupAssociation
	err := ctx.RegisterResource("aws:synthetics/groupAssociation:GroupAssociation", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetGroupAssociation gets an existing GroupAssociation resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetGroupAssociation(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *GroupAssociationState, opts ...pulumi.ResourceOption) (*GroupAssociation, error) {
	var resource GroupAssociation
	err := ctx.ReadResource("aws:synthetics/groupAssociation:GroupAssociation", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering GroupAssociation resources.
type groupAssociationState struct {
	// ARN of the canary.
	CanaryArn *string `pulumi:"canaryArn"`
	GroupArn  *string `pulumi:"groupArn"`
	// ID of the Group.
	GroupId *string `pulumi:"groupId"`
	// Name of the group that the canary will be associated with.
	GroupName *string `pulumi:"groupName"`
}

type GroupAssociationState struct {
	// ARN of the canary.
	CanaryArn pulumi.StringPtrInput
	GroupArn  pulumi.StringPtrInput
	// ID of the Group.
	GroupId pulumi.StringPtrInput
	// Name of the group that the canary will be associated with.
	GroupName pulumi.StringPtrInput
}

func (GroupAssociationState) ElementType() reflect.Type {
	return reflect.TypeOf((*groupAssociationState)(nil)).Elem()
}

type groupAssociationArgs struct {
	// ARN of the canary.
	CanaryArn string `pulumi:"canaryArn"`
	// Name of the group that the canary will be associated with.
	GroupName string `pulumi:"groupName"`
}

// The set of arguments for constructing a GroupAssociation resource.
type GroupAssociationArgs struct {
	// ARN of the canary.
	CanaryArn pulumi.StringInput
	// Name of the group that the canary will be associated with.
	GroupName pulumi.StringInput
}

func (GroupAssociationArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*groupAssociationArgs)(nil)).Elem()
}

type GroupAssociationInput interface {
	pulumi.Input

	ToGroupAssociationOutput() GroupAssociationOutput
	ToGroupAssociationOutputWithContext(ctx context.Context) GroupAssociationOutput
}

func (*GroupAssociation) ElementType() reflect.Type {
	return reflect.TypeOf((**GroupAssociation)(nil)).Elem()
}

func (i *GroupAssociation) ToGroupAssociationOutput() GroupAssociationOutput {
	return i.ToGroupAssociationOutputWithContext(context.Background())
}

func (i *GroupAssociation) ToGroupAssociationOutputWithContext(ctx context.Context) GroupAssociationOutput {
	return pulumi.ToOutputWithContext(ctx, i).(GroupAssociationOutput)
}

// GroupAssociationArrayInput is an input type that accepts GroupAssociationArray and GroupAssociationArrayOutput values.
// You can construct a concrete instance of `GroupAssociationArrayInput` via:
//
//	GroupAssociationArray{ GroupAssociationArgs{...} }
type GroupAssociationArrayInput interface {
	pulumi.Input

	ToGroupAssociationArrayOutput() GroupAssociationArrayOutput
	ToGroupAssociationArrayOutputWithContext(context.Context) GroupAssociationArrayOutput
}

type GroupAssociationArray []GroupAssociationInput

func (GroupAssociationArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*GroupAssociation)(nil)).Elem()
}

func (i GroupAssociationArray) ToGroupAssociationArrayOutput() GroupAssociationArrayOutput {
	return i.ToGroupAssociationArrayOutputWithContext(context.Background())
}

func (i GroupAssociationArray) ToGroupAssociationArrayOutputWithContext(ctx context.Context) GroupAssociationArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(GroupAssociationArrayOutput)
}

// GroupAssociationMapInput is an input type that accepts GroupAssociationMap and GroupAssociationMapOutput values.
// You can construct a concrete instance of `GroupAssociationMapInput` via:
//
//	GroupAssociationMap{ "key": GroupAssociationArgs{...} }
type GroupAssociationMapInput interface {
	pulumi.Input

	ToGroupAssociationMapOutput() GroupAssociationMapOutput
	ToGroupAssociationMapOutputWithContext(context.Context) GroupAssociationMapOutput
}

type GroupAssociationMap map[string]GroupAssociationInput

func (GroupAssociationMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*GroupAssociation)(nil)).Elem()
}

func (i GroupAssociationMap) ToGroupAssociationMapOutput() GroupAssociationMapOutput {
	return i.ToGroupAssociationMapOutputWithContext(context.Background())
}

func (i GroupAssociationMap) ToGroupAssociationMapOutputWithContext(ctx context.Context) GroupAssociationMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(GroupAssociationMapOutput)
}

type GroupAssociationOutput struct{ *pulumi.OutputState }

func (GroupAssociationOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**GroupAssociation)(nil)).Elem()
}

func (o GroupAssociationOutput) ToGroupAssociationOutput() GroupAssociationOutput {
	return o
}

func (o GroupAssociationOutput) ToGroupAssociationOutputWithContext(ctx context.Context) GroupAssociationOutput {
	return o
}

// ARN of the canary.
func (o GroupAssociationOutput) CanaryArn() pulumi.StringOutput {
	return o.ApplyT(func(v *GroupAssociation) pulumi.StringOutput { return v.CanaryArn }).(pulumi.StringOutput)
}

func (o GroupAssociationOutput) GroupArn() pulumi.StringOutput {
	return o.ApplyT(func(v *GroupAssociation) pulumi.StringOutput { return v.GroupArn }).(pulumi.StringOutput)
}

// ID of the Group.
func (o GroupAssociationOutput) GroupId() pulumi.StringOutput {
	return o.ApplyT(func(v *GroupAssociation) pulumi.StringOutput { return v.GroupId }).(pulumi.StringOutput)
}

// Name of the group that the canary will be associated with.
func (o GroupAssociationOutput) GroupName() pulumi.StringOutput {
	return o.ApplyT(func(v *GroupAssociation) pulumi.StringOutput { return v.GroupName }).(pulumi.StringOutput)
}

type GroupAssociationArrayOutput struct{ *pulumi.OutputState }

func (GroupAssociationArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*GroupAssociation)(nil)).Elem()
}

func (o GroupAssociationArrayOutput) ToGroupAssociationArrayOutput() GroupAssociationArrayOutput {
	return o
}

func (o GroupAssociationArrayOutput) ToGroupAssociationArrayOutputWithContext(ctx context.Context) GroupAssociationArrayOutput {
	return o
}

func (o GroupAssociationArrayOutput) Index(i pulumi.IntInput) GroupAssociationOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *GroupAssociation {
		return vs[0].([]*GroupAssociation)[vs[1].(int)]
	}).(GroupAssociationOutput)
}

type GroupAssociationMapOutput struct{ *pulumi.OutputState }

func (GroupAssociationMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*GroupAssociation)(nil)).Elem()
}

func (o GroupAssociationMapOutput) ToGroupAssociationMapOutput() GroupAssociationMapOutput {
	return o
}

func (o GroupAssociationMapOutput) ToGroupAssociationMapOutputWithContext(ctx context.Context) GroupAssociationMapOutput {
	return o
}

func (o GroupAssociationMapOutput) MapIndex(k pulumi.StringInput) GroupAssociationOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *GroupAssociation {
		return vs[0].(map[string]*GroupAssociation)[vs[1].(string)]
	}).(GroupAssociationOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*GroupAssociationInput)(nil)).Elem(), &GroupAssociation{})
	pulumi.RegisterInputType(reflect.TypeOf((*GroupAssociationArrayInput)(nil)).Elem(), GroupAssociationArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*GroupAssociationMapInput)(nil)).Elem(), GroupAssociationMap{})
	pulumi.RegisterOutputType(GroupAssociationOutput{})
	pulumi.RegisterOutputType(GroupAssociationArrayOutput{})
	pulumi.RegisterOutputType(GroupAssociationMapOutput{})
}
