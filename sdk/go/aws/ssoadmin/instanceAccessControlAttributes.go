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

// Provides a Single Sign-On (SSO) ABAC Resource: https://docs.aws.amazon.com/singlesignon/latest/userguide/abac.html
//
// ## Example Usage
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
//			_, err = ssoadmin.NewInstanceAccessControlAttributes(ctx, "example", &ssoadmin.InstanceAccessControlAttributesArgs{
//				InstanceArn: pulumi.String(example.Arns[0]),
//				Attributes: ssoadmin.InstanceAccessControlAttributesAttributeArray{
//					&ssoadmin.InstanceAccessControlAttributesAttributeArgs{
//						Key: pulumi.String("name"),
//						Values: ssoadmin.InstanceAccessControlAttributesAttributeValueArray{
//							&ssoadmin.InstanceAccessControlAttributesAttributeValueArgs{
//								Sources: pulumi.StringArray{
//									pulumi.String("${path:name.givenName}"),
//								},
//							},
//						},
//					},
//					&ssoadmin.InstanceAccessControlAttributesAttributeArgs{
//						Key: pulumi.String("last"),
//						Values: ssoadmin.InstanceAccessControlAttributesAttributeValueArray{
//							&ssoadmin.InstanceAccessControlAttributesAttributeValueArgs{
//								Sources: pulumi.StringArray{
//									pulumi.String("${path:name.familyName}"),
//								},
//							},
//						},
//					},
//				},
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
// Using `pulumi import`, import SSO Account Assignments using the `instance_arn`. For example:
//
// ```sh
// $ pulumi import aws:ssoadmin/instanceAccessControlAttributes:InstanceAccessControlAttributes example arn:aws:sso:::instance/ssoins-0123456789abcdef
// ```
type InstanceAccessControlAttributes struct {
	pulumi.CustomResourceState

	// See AccessControlAttribute for more details.
	Attributes InstanceAccessControlAttributesAttributeArrayOutput `pulumi:"attributes"`
	// The Amazon Resource Name (ARN) of the SSO Instance.
	InstanceArn  pulumi.StringOutput `pulumi:"instanceArn"`
	Status       pulumi.StringOutput `pulumi:"status"`
	StatusReason pulumi.StringOutput `pulumi:"statusReason"`
}

// NewInstanceAccessControlAttributes registers a new resource with the given unique name, arguments, and options.
func NewInstanceAccessControlAttributes(ctx *pulumi.Context,
	name string, args *InstanceAccessControlAttributesArgs, opts ...pulumi.ResourceOption) (*InstanceAccessControlAttributes, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.Attributes == nil {
		return nil, errors.New("invalid value for required argument 'Attributes'")
	}
	if args.InstanceArn == nil {
		return nil, errors.New("invalid value for required argument 'InstanceArn'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource InstanceAccessControlAttributes
	err := ctx.RegisterResource("aws:ssoadmin/instanceAccessControlAttributes:InstanceAccessControlAttributes", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetInstanceAccessControlAttributes gets an existing InstanceAccessControlAttributes resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetInstanceAccessControlAttributes(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *InstanceAccessControlAttributesState, opts ...pulumi.ResourceOption) (*InstanceAccessControlAttributes, error) {
	var resource InstanceAccessControlAttributes
	err := ctx.ReadResource("aws:ssoadmin/instanceAccessControlAttributes:InstanceAccessControlAttributes", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering InstanceAccessControlAttributes resources.
type instanceAccessControlAttributesState struct {
	// See AccessControlAttribute for more details.
	Attributes []InstanceAccessControlAttributesAttribute `pulumi:"attributes"`
	// The Amazon Resource Name (ARN) of the SSO Instance.
	InstanceArn  *string `pulumi:"instanceArn"`
	Status       *string `pulumi:"status"`
	StatusReason *string `pulumi:"statusReason"`
}

type InstanceAccessControlAttributesState struct {
	// See AccessControlAttribute for more details.
	Attributes InstanceAccessControlAttributesAttributeArrayInput
	// The Amazon Resource Name (ARN) of the SSO Instance.
	InstanceArn  pulumi.StringPtrInput
	Status       pulumi.StringPtrInput
	StatusReason pulumi.StringPtrInput
}

func (InstanceAccessControlAttributesState) ElementType() reflect.Type {
	return reflect.TypeOf((*instanceAccessControlAttributesState)(nil)).Elem()
}

type instanceAccessControlAttributesArgs struct {
	// See AccessControlAttribute for more details.
	Attributes []InstanceAccessControlAttributesAttribute `pulumi:"attributes"`
	// The Amazon Resource Name (ARN) of the SSO Instance.
	InstanceArn string `pulumi:"instanceArn"`
}

// The set of arguments for constructing a InstanceAccessControlAttributes resource.
type InstanceAccessControlAttributesArgs struct {
	// See AccessControlAttribute for more details.
	Attributes InstanceAccessControlAttributesAttributeArrayInput
	// The Amazon Resource Name (ARN) of the SSO Instance.
	InstanceArn pulumi.StringInput
}

func (InstanceAccessControlAttributesArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*instanceAccessControlAttributesArgs)(nil)).Elem()
}

type InstanceAccessControlAttributesInput interface {
	pulumi.Input

	ToInstanceAccessControlAttributesOutput() InstanceAccessControlAttributesOutput
	ToInstanceAccessControlAttributesOutputWithContext(ctx context.Context) InstanceAccessControlAttributesOutput
}

func (*InstanceAccessControlAttributes) ElementType() reflect.Type {
	return reflect.TypeOf((**InstanceAccessControlAttributes)(nil)).Elem()
}

func (i *InstanceAccessControlAttributes) ToInstanceAccessControlAttributesOutput() InstanceAccessControlAttributesOutput {
	return i.ToInstanceAccessControlAttributesOutputWithContext(context.Background())
}

func (i *InstanceAccessControlAttributes) ToInstanceAccessControlAttributesOutputWithContext(ctx context.Context) InstanceAccessControlAttributesOutput {
	return pulumi.ToOutputWithContext(ctx, i).(InstanceAccessControlAttributesOutput)
}

// InstanceAccessControlAttributesArrayInput is an input type that accepts InstanceAccessControlAttributesArray and InstanceAccessControlAttributesArrayOutput values.
// You can construct a concrete instance of `InstanceAccessControlAttributesArrayInput` via:
//
//	InstanceAccessControlAttributesArray{ InstanceAccessControlAttributesArgs{...} }
type InstanceAccessControlAttributesArrayInput interface {
	pulumi.Input

	ToInstanceAccessControlAttributesArrayOutput() InstanceAccessControlAttributesArrayOutput
	ToInstanceAccessControlAttributesArrayOutputWithContext(context.Context) InstanceAccessControlAttributesArrayOutput
}

type InstanceAccessControlAttributesArray []InstanceAccessControlAttributesInput

func (InstanceAccessControlAttributesArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*InstanceAccessControlAttributes)(nil)).Elem()
}

func (i InstanceAccessControlAttributesArray) ToInstanceAccessControlAttributesArrayOutput() InstanceAccessControlAttributesArrayOutput {
	return i.ToInstanceAccessControlAttributesArrayOutputWithContext(context.Background())
}

func (i InstanceAccessControlAttributesArray) ToInstanceAccessControlAttributesArrayOutputWithContext(ctx context.Context) InstanceAccessControlAttributesArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(InstanceAccessControlAttributesArrayOutput)
}

// InstanceAccessControlAttributesMapInput is an input type that accepts InstanceAccessControlAttributesMap and InstanceAccessControlAttributesMapOutput values.
// You can construct a concrete instance of `InstanceAccessControlAttributesMapInput` via:
//
//	InstanceAccessControlAttributesMap{ "key": InstanceAccessControlAttributesArgs{...} }
type InstanceAccessControlAttributesMapInput interface {
	pulumi.Input

	ToInstanceAccessControlAttributesMapOutput() InstanceAccessControlAttributesMapOutput
	ToInstanceAccessControlAttributesMapOutputWithContext(context.Context) InstanceAccessControlAttributesMapOutput
}

type InstanceAccessControlAttributesMap map[string]InstanceAccessControlAttributesInput

func (InstanceAccessControlAttributesMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*InstanceAccessControlAttributes)(nil)).Elem()
}

func (i InstanceAccessControlAttributesMap) ToInstanceAccessControlAttributesMapOutput() InstanceAccessControlAttributesMapOutput {
	return i.ToInstanceAccessControlAttributesMapOutputWithContext(context.Background())
}

func (i InstanceAccessControlAttributesMap) ToInstanceAccessControlAttributesMapOutputWithContext(ctx context.Context) InstanceAccessControlAttributesMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(InstanceAccessControlAttributesMapOutput)
}

type InstanceAccessControlAttributesOutput struct{ *pulumi.OutputState }

func (InstanceAccessControlAttributesOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**InstanceAccessControlAttributes)(nil)).Elem()
}

func (o InstanceAccessControlAttributesOutput) ToInstanceAccessControlAttributesOutput() InstanceAccessControlAttributesOutput {
	return o
}

func (o InstanceAccessControlAttributesOutput) ToInstanceAccessControlAttributesOutputWithContext(ctx context.Context) InstanceAccessControlAttributesOutput {
	return o
}

// See AccessControlAttribute for more details.
func (o InstanceAccessControlAttributesOutput) Attributes() InstanceAccessControlAttributesAttributeArrayOutput {
	return o.ApplyT(func(v *InstanceAccessControlAttributes) InstanceAccessControlAttributesAttributeArrayOutput {
		return v.Attributes
	}).(InstanceAccessControlAttributesAttributeArrayOutput)
}

// The Amazon Resource Name (ARN) of the SSO Instance.
func (o InstanceAccessControlAttributesOutput) InstanceArn() pulumi.StringOutput {
	return o.ApplyT(func(v *InstanceAccessControlAttributes) pulumi.StringOutput { return v.InstanceArn }).(pulumi.StringOutput)
}

func (o InstanceAccessControlAttributesOutput) Status() pulumi.StringOutput {
	return o.ApplyT(func(v *InstanceAccessControlAttributes) pulumi.StringOutput { return v.Status }).(pulumi.StringOutput)
}

func (o InstanceAccessControlAttributesOutput) StatusReason() pulumi.StringOutput {
	return o.ApplyT(func(v *InstanceAccessControlAttributes) pulumi.StringOutput { return v.StatusReason }).(pulumi.StringOutput)
}

type InstanceAccessControlAttributesArrayOutput struct{ *pulumi.OutputState }

func (InstanceAccessControlAttributesArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*InstanceAccessControlAttributes)(nil)).Elem()
}

func (o InstanceAccessControlAttributesArrayOutput) ToInstanceAccessControlAttributesArrayOutput() InstanceAccessControlAttributesArrayOutput {
	return o
}

func (o InstanceAccessControlAttributesArrayOutput) ToInstanceAccessControlAttributesArrayOutputWithContext(ctx context.Context) InstanceAccessControlAttributesArrayOutput {
	return o
}

func (o InstanceAccessControlAttributesArrayOutput) Index(i pulumi.IntInput) InstanceAccessControlAttributesOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *InstanceAccessControlAttributes {
		return vs[0].([]*InstanceAccessControlAttributes)[vs[1].(int)]
	}).(InstanceAccessControlAttributesOutput)
}

type InstanceAccessControlAttributesMapOutput struct{ *pulumi.OutputState }

func (InstanceAccessControlAttributesMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*InstanceAccessControlAttributes)(nil)).Elem()
}

func (o InstanceAccessControlAttributesMapOutput) ToInstanceAccessControlAttributesMapOutput() InstanceAccessControlAttributesMapOutput {
	return o
}

func (o InstanceAccessControlAttributesMapOutput) ToInstanceAccessControlAttributesMapOutputWithContext(ctx context.Context) InstanceAccessControlAttributesMapOutput {
	return o
}

func (o InstanceAccessControlAttributesMapOutput) MapIndex(k pulumi.StringInput) InstanceAccessControlAttributesOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *InstanceAccessControlAttributes {
		return vs[0].(map[string]*InstanceAccessControlAttributes)[vs[1].(string)]
	}).(InstanceAccessControlAttributesOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*InstanceAccessControlAttributesInput)(nil)).Elem(), &InstanceAccessControlAttributes{})
	pulumi.RegisterInputType(reflect.TypeOf((*InstanceAccessControlAttributesArrayInput)(nil)).Elem(), InstanceAccessControlAttributesArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*InstanceAccessControlAttributesMapInput)(nil)).Elem(), InstanceAccessControlAttributesMap{})
	pulumi.RegisterOutputType(InstanceAccessControlAttributesOutput{})
	pulumi.RegisterOutputType(InstanceAccessControlAttributesArrayOutput{})
	pulumi.RegisterOutputType(InstanceAccessControlAttributesMapOutput{})
}
