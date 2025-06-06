// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package vpc

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing Security Group VPC Associations.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/vpc"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := vpc.NewSecurityGroupVpcAssociation(ctx, "example", &vpc.SecurityGroupVpcAssociationArgs{
//				SecurityGroupId: pulumi.String("sg-05f1f54ab49bb39a3"),
//				VpcId:           pulumi.String("vpc-01df9d105095412ba"),
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
// Using `pulumi import`, import a Security Group VPC Association using the `security_group_id` and `vpc_id` arguments, separated by a comma (`,`). For example:
//
// ```sh
// $ pulumi import aws:vpc/securityGroupVpcAssociation:SecurityGroupVpcAssociation example sg-12345,vpc-67890
// ```
type SecurityGroupVpcAssociation struct {
	pulumi.CustomResourceState

	// The ID of the security group.
	SecurityGroupId pulumi.StringOutput `pulumi:"securityGroupId"`
	// State of the VPC association. See the [AWS documentation](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_SecurityGroupVpcAssociation.html) for possible values.
	State    pulumi.StringOutput                          `pulumi:"state"`
	Timeouts SecurityGroupVpcAssociationTimeoutsPtrOutput `pulumi:"timeouts"`
	// The ID of the VPC to make the association with.
	VpcId pulumi.StringOutput `pulumi:"vpcId"`
}

// NewSecurityGroupVpcAssociation registers a new resource with the given unique name, arguments, and options.
func NewSecurityGroupVpcAssociation(ctx *pulumi.Context,
	name string, args *SecurityGroupVpcAssociationArgs, opts ...pulumi.ResourceOption) (*SecurityGroupVpcAssociation, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.SecurityGroupId == nil {
		return nil, errors.New("invalid value for required argument 'SecurityGroupId'")
	}
	if args.VpcId == nil {
		return nil, errors.New("invalid value for required argument 'VpcId'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource SecurityGroupVpcAssociation
	err := ctx.RegisterResource("aws:vpc/securityGroupVpcAssociation:SecurityGroupVpcAssociation", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetSecurityGroupVpcAssociation gets an existing SecurityGroupVpcAssociation resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetSecurityGroupVpcAssociation(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *SecurityGroupVpcAssociationState, opts ...pulumi.ResourceOption) (*SecurityGroupVpcAssociation, error) {
	var resource SecurityGroupVpcAssociation
	err := ctx.ReadResource("aws:vpc/securityGroupVpcAssociation:SecurityGroupVpcAssociation", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering SecurityGroupVpcAssociation resources.
type securityGroupVpcAssociationState struct {
	// The ID of the security group.
	SecurityGroupId *string `pulumi:"securityGroupId"`
	// State of the VPC association. See the [AWS documentation](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_SecurityGroupVpcAssociation.html) for possible values.
	State    *string                              `pulumi:"state"`
	Timeouts *SecurityGroupVpcAssociationTimeouts `pulumi:"timeouts"`
	// The ID of the VPC to make the association with.
	VpcId *string `pulumi:"vpcId"`
}

type SecurityGroupVpcAssociationState struct {
	// The ID of the security group.
	SecurityGroupId pulumi.StringPtrInput
	// State of the VPC association. See the [AWS documentation](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_SecurityGroupVpcAssociation.html) for possible values.
	State    pulumi.StringPtrInput
	Timeouts SecurityGroupVpcAssociationTimeoutsPtrInput
	// The ID of the VPC to make the association with.
	VpcId pulumi.StringPtrInput
}

func (SecurityGroupVpcAssociationState) ElementType() reflect.Type {
	return reflect.TypeOf((*securityGroupVpcAssociationState)(nil)).Elem()
}

type securityGroupVpcAssociationArgs struct {
	// The ID of the security group.
	SecurityGroupId string                               `pulumi:"securityGroupId"`
	Timeouts        *SecurityGroupVpcAssociationTimeouts `pulumi:"timeouts"`
	// The ID of the VPC to make the association with.
	VpcId string `pulumi:"vpcId"`
}

// The set of arguments for constructing a SecurityGroupVpcAssociation resource.
type SecurityGroupVpcAssociationArgs struct {
	// The ID of the security group.
	SecurityGroupId pulumi.StringInput
	Timeouts        SecurityGroupVpcAssociationTimeoutsPtrInput
	// The ID of the VPC to make the association with.
	VpcId pulumi.StringInput
}

func (SecurityGroupVpcAssociationArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*securityGroupVpcAssociationArgs)(nil)).Elem()
}

type SecurityGroupVpcAssociationInput interface {
	pulumi.Input

	ToSecurityGroupVpcAssociationOutput() SecurityGroupVpcAssociationOutput
	ToSecurityGroupVpcAssociationOutputWithContext(ctx context.Context) SecurityGroupVpcAssociationOutput
}

func (*SecurityGroupVpcAssociation) ElementType() reflect.Type {
	return reflect.TypeOf((**SecurityGroupVpcAssociation)(nil)).Elem()
}

func (i *SecurityGroupVpcAssociation) ToSecurityGroupVpcAssociationOutput() SecurityGroupVpcAssociationOutput {
	return i.ToSecurityGroupVpcAssociationOutputWithContext(context.Background())
}

func (i *SecurityGroupVpcAssociation) ToSecurityGroupVpcAssociationOutputWithContext(ctx context.Context) SecurityGroupVpcAssociationOutput {
	return pulumi.ToOutputWithContext(ctx, i).(SecurityGroupVpcAssociationOutput)
}

// SecurityGroupVpcAssociationArrayInput is an input type that accepts SecurityGroupVpcAssociationArray and SecurityGroupVpcAssociationArrayOutput values.
// You can construct a concrete instance of `SecurityGroupVpcAssociationArrayInput` via:
//
//	SecurityGroupVpcAssociationArray{ SecurityGroupVpcAssociationArgs{...} }
type SecurityGroupVpcAssociationArrayInput interface {
	pulumi.Input

	ToSecurityGroupVpcAssociationArrayOutput() SecurityGroupVpcAssociationArrayOutput
	ToSecurityGroupVpcAssociationArrayOutputWithContext(context.Context) SecurityGroupVpcAssociationArrayOutput
}

type SecurityGroupVpcAssociationArray []SecurityGroupVpcAssociationInput

func (SecurityGroupVpcAssociationArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*SecurityGroupVpcAssociation)(nil)).Elem()
}

func (i SecurityGroupVpcAssociationArray) ToSecurityGroupVpcAssociationArrayOutput() SecurityGroupVpcAssociationArrayOutput {
	return i.ToSecurityGroupVpcAssociationArrayOutputWithContext(context.Background())
}

func (i SecurityGroupVpcAssociationArray) ToSecurityGroupVpcAssociationArrayOutputWithContext(ctx context.Context) SecurityGroupVpcAssociationArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(SecurityGroupVpcAssociationArrayOutput)
}

// SecurityGroupVpcAssociationMapInput is an input type that accepts SecurityGroupVpcAssociationMap and SecurityGroupVpcAssociationMapOutput values.
// You can construct a concrete instance of `SecurityGroupVpcAssociationMapInput` via:
//
//	SecurityGroupVpcAssociationMap{ "key": SecurityGroupVpcAssociationArgs{...} }
type SecurityGroupVpcAssociationMapInput interface {
	pulumi.Input

	ToSecurityGroupVpcAssociationMapOutput() SecurityGroupVpcAssociationMapOutput
	ToSecurityGroupVpcAssociationMapOutputWithContext(context.Context) SecurityGroupVpcAssociationMapOutput
}

type SecurityGroupVpcAssociationMap map[string]SecurityGroupVpcAssociationInput

func (SecurityGroupVpcAssociationMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*SecurityGroupVpcAssociation)(nil)).Elem()
}

func (i SecurityGroupVpcAssociationMap) ToSecurityGroupVpcAssociationMapOutput() SecurityGroupVpcAssociationMapOutput {
	return i.ToSecurityGroupVpcAssociationMapOutputWithContext(context.Background())
}

func (i SecurityGroupVpcAssociationMap) ToSecurityGroupVpcAssociationMapOutputWithContext(ctx context.Context) SecurityGroupVpcAssociationMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(SecurityGroupVpcAssociationMapOutput)
}

type SecurityGroupVpcAssociationOutput struct{ *pulumi.OutputState }

func (SecurityGroupVpcAssociationOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**SecurityGroupVpcAssociation)(nil)).Elem()
}

func (o SecurityGroupVpcAssociationOutput) ToSecurityGroupVpcAssociationOutput() SecurityGroupVpcAssociationOutput {
	return o
}

func (o SecurityGroupVpcAssociationOutput) ToSecurityGroupVpcAssociationOutputWithContext(ctx context.Context) SecurityGroupVpcAssociationOutput {
	return o
}

// The ID of the security group.
func (o SecurityGroupVpcAssociationOutput) SecurityGroupId() pulumi.StringOutput {
	return o.ApplyT(func(v *SecurityGroupVpcAssociation) pulumi.StringOutput { return v.SecurityGroupId }).(pulumi.StringOutput)
}

// State of the VPC association. See the [AWS documentation](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_SecurityGroupVpcAssociation.html) for possible values.
func (o SecurityGroupVpcAssociationOutput) State() pulumi.StringOutput {
	return o.ApplyT(func(v *SecurityGroupVpcAssociation) pulumi.StringOutput { return v.State }).(pulumi.StringOutput)
}

func (o SecurityGroupVpcAssociationOutput) Timeouts() SecurityGroupVpcAssociationTimeoutsPtrOutput {
	return o.ApplyT(func(v *SecurityGroupVpcAssociation) SecurityGroupVpcAssociationTimeoutsPtrOutput { return v.Timeouts }).(SecurityGroupVpcAssociationTimeoutsPtrOutput)
}

// The ID of the VPC to make the association with.
func (o SecurityGroupVpcAssociationOutput) VpcId() pulumi.StringOutput {
	return o.ApplyT(func(v *SecurityGroupVpcAssociation) pulumi.StringOutput { return v.VpcId }).(pulumi.StringOutput)
}

type SecurityGroupVpcAssociationArrayOutput struct{ *pulumi.OutputState }

func (SecurityGroupVpcAssociationArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*SecurityGroupVpcAssociation)(nil)).Elem()
}

func (o SecurityGroupVpcAssociationArrayOutput) ToSecurityGroupVpcAssociationArrayOutput() SecurityGroupVpcAssociationArrayOutput {
	return o
}

func (o SecurityGroupVpcAssociationArrayOutput) ToSecurityGroupVpcAssociationArrayOutputWithContext(ctx context.Context) SecurityGroupVpcAssociationArrayOutput {
	return o
}

func (o SecurityGroupVpcAssociationArrayOutput) Index(i pulumi.IntInput) SecurityGroupVpcAssociationOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *SecurityGroupVpcAssociation {
		return vs[0].([]*SecurityGroupVpcAssociation)[vs[1].(int)]
	}).(SecurityGroupVpcAssociationOutput)
}

type SecurityGroupVpcAssociationMapOutput struct{ *pulumi.OutputState }

func (SecurityGroupVpcAssociationMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*SecurityGroupVpcAssociation)(nil)).Elem()
}

func (o SecurityGroupVpcAssociationMapOutput) ToSecurityGroupVpcAssociationMapOutput() SecurityGroupVpcAssociationMapOutput {
	return o
}

func (o SecurityGroupVpcAssociationMapOutput) ToSecurityGroupVpcAssociationMapOutputWithContext(ctx context.Context) SecurityGroupVpcAssociationMapOutput {
	return o
}

func (o SecurityGroupVpcAssociationMapOutput) MapIndex(k pulumi.StringInput) SecurityGroupVpcAssociationOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *SecurityGroupVpcAssociation {
		return vs[0].(map[string]*SecurityGroupVpcAssociation)[vs[1].(string)]
	}).(SecurityGroupVpcAssociationOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*SecurityGroupVpcAssociationInput)(nil)).Elem(), &SecurityGroupVpcAssociation{})
	pulumi.RegisterInputType(reflect.TypeOf((*SecurityGroupVpcAssociationArrayInput)(nil)).Elem(), SecurityGroupVpcAssociationArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*SecurityGroupVpcAssociationMapInput)(nil)).Elem(), SecurityGroupVpcAssociationMap{})
	pulumi.RegisterOutputType(SecurityGroupVpcAssociationOutput{})
	pulumi.RegisterOutputType(SecurityGroupVpcAssociationArrayOutput{})
	pulumi.RegisterOutputType(SecurityGroupVpcAssociationMapOutput{})
}
