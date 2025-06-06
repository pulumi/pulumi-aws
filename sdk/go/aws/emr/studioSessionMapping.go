// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package emr

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides an Elastic MapReduce Studio Session Mapping.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/emr"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := emr.NewStudioSessionMapping(ctx, "example", &emr.StudioSessionMappingArgs{
//				StudioId:         pulumi.Any(exampleAwsEmrStudio.Id),
//				IdentityType:     pulumi.String("USER"),
//				IdentityId:       pulumi.String("example"),
//				SessionPolicyArn: pulumi.Any(exampleAwsIamPolicy.Arn),
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
// Using `pulumi import`, import EMR studio session mappings using `studio-id:identity-type:identity-id`. For example:
//
// ```sh
// $ pulumi import aws:emr/studioSessionMapping:StudioSessionMapping example es-xxxxx:USER:xxxxx-xxx-xxx
// ```
type StudioSessionMapping struct {
	pulumi.CustomResourceState

	// The globally unique identifier (GUID) of the user or group from the Amazon Web Services SSO Identity Store.
	IdentityId pulumi.StringOutput `pulumi:"identityId"`
	// The name of the user or group from the Amazon Web Services SSO Identity Store.
	IdentityName pulumi.StringOutput `pulumi:"identityName"`
	// Specifies whether the identity to map to the Amazon EMR Studio is a `USER` or a `GROUP`.
	IdentityType pulumi.StringOutput `pulumi:"identityType"`
	// The Amazon Resource Name (ARN) for the session policy that will be applied to the user or group. You should specify the ARN for the session policy that you want to apply, not the ARN of your user role.
	SessionPolicyArn pulumi.StringOutput `pulumi:"sessionPolicyArn"`
	// The ID of the Amazon EMR Studio to which the user or group will be mapped.
	StudioId pulumi.StringOutput `pulumi:"studioId"`
}

// NewStudioSessionMapping registers a new resource with the given unique name, arguments, and options.
func NewStudioSessionMapping(ctx *pulumi.Context,
	name string, args *StudioSessionMappingArgs, opts ...pulumi.ResourceOption) (*StudioSessionMapping, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.IdentityType == nil {
		return nil, errors.New("invalid value for required argument 'IdentityType'")
	}
	if args.SessionPolicyArn == nil {
		return nil, errors.New("invalid value for required argument 'SessionPolicyArn'")
	}
	if args.StudioId == nil {
		return nil, errors.New("invalid value for required argument 'StudioId'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource StudioSessionMapping
	err := ctx.RegisterResource("aws:emr/studioSessionMapping:StudioSessionMapping", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetStudioSessionMapping gets an existing StudioSessionMapping resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetStudioSessionMapping(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *StudioSessionMappingState, opts ...pulumi.ResourceOption) (*StudioSessionMapping, error) {
	var resource StudioSessionMapping
	err := ctx.ReadResource("aws:emr/studioSessionMapping:StudioSessionMapping", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering StudioSessionMapping resources.
type studioSessionMappingState struct {
	// The globally unique identifier (GUID) of the user or group from the Amazon Web Services SSO Identity Store.
	IdentityId *string `pulumi:"identityId"`
	// The name of the user or group from the Amazon Web Services SSO Identity Store.
	IdentityName *string `pulumi:"identityName"`
	// Specifies whether the identity to map to the Amazon EMR Studio is a `USER` or a `GROUP`.
	IdentityType *string `pulumi:"identityType"`
	// The Amazon Resource Name (ARN) for the session policy that will be applied to the user or group. You should specify the ARN for the session policy that you want to apply, not the ARN of your user role.
	SessionPolicyArn *string `pulumi:"sessionPolicyArn"`
	// The ID of the Amazon EMR Studio to which the user or group will be mapped.
	StudioId *string `pulumi:"studioId"`
}

type StudioSessionMappingState struct {
	// The globally unique identifier (GUID) of the user or group from the Amazon Web Services SSO Identity Store.
	IdentityId pulumi.StringPtrInput
	// The name of the user or group from the Amazon Web Services SSO Identity Store.
	IdentityName pulumi.StringPtrInput
	// Specifies whether the identity to map to the Amazon EMR Studio is a `USER` or a `GROUP`.
	IdentityType pulumi.StringPtrInput
	// The Amazon Resource Name (ARN) for the session policy that will be applied to the user or group. You should specify the ARN for the session policy that you want to apply, not the ARN of your user role.
	SessionPolicyArn pulumi.StringPtrInput
	// The ID of the Amazon EMR Studio to which the user or group will be mapped.
	StudioId pulumi.StringPtrInput
}

func (StudioSessionMappingState) ElementType() reflect.Type {
	return reflect.TypeOf((*studioSessionMappingState)(nil)).Elem()
}

type studioSessionMappingArgs struct {
	// The globally unique identifier (GUID) of the user or group from the Amazon Web Services SSO Identity Store.
	IdentityId *string `pulumi:"identityId"`
	// The name of the user or group from the Amazon Web Services SSO Identity Store.
	IdentityName *string `pulumi:"identityName"`
	// Specifies whether the identity to map to the Amazon EMR Studio is a `USER` or a `GROUP`.
	IdentityType string `pulumi:"identityType"`
	// The Amazon Resource Name (ARN) for the session policy that will be applied to the user or group. You should specify the ARN for the session policy that you want to apply, not the ARN of your user role.
	SessionPolicyArn string `pulumi:"sessionPolicyArn"`
	// The ID of the Amazon EMR Studio to which the user or group will be mapped.
	StudioId string `pulumi:"studioId"`
}

// The set of arguments for constructing a StudioSessionMapping resource.
type StudioSessionMappingArgs struct {
	// The globally unique identifier (GUID) of the user or group from the Amazon Web Services SSO Identity Store.
	IdentityId pulumi.StringPtrInput
	// The name of the user or group from the Amazon Web Services SSO Identity Store.
	IdentityName pulumi.StringPtrInput
	// Specifies whether the identity to map to the Amazon EMR Studio is a `USER` or a `GROUP`.
	IdentityType pulumi.StringInput
	// The Amazon Resource Name (ARN) for the session policy that will be applied to the user or group. You should specify the ARN for the session policy that you want to apply, not the ARN of your user role.
	SessionPolicyArn pulumi.StringInput
	// The ID of the Amazon EMR Studio to which the user or group will be mapped.
	StudioId pulumi.StringInput
}

func (StudioSessionMappingArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*studioSessionMappingArgs)(nil)).Elem()
}

type StudioSessionMappingInput interface {
	pulumi.Input

	ToStudioSessionMappingOutput() StudioSessionMappingOutput
	ToStudioSessionMappingOutputWithContext(ctx context.Context) StudioSessionMappingOutput
}

func (*StudioSessionMapping) ElementType() reflect.Type {
	return reflect.TypeOf((**StudioSessionMapping)(nil)).Elem()
}

func (i *StudioSessionMapping) ToStudioSessionMappingOutput() StudioSessionMappingOutput {
	return i.ToStudioSessionMappingOutputWithContext(context.Background())
}

func (i *StudioSessionMapping) ToStudioSessionMappingOutputWithContext(ctx context.Context) StudioSessionMappingOutput {
	return pulumi.ToOutputWithContext(ctx, i).(StudioSessionMappingOutput)
}

// StudioSessionMappingArrayInput is an input type that accepts StudioSessionMappingArray and StudioSessionMappingArrayOutput values.
// You can construct a concrete instance of `StudioSessionMappingArrayInput` via:
//
//	StudioSessionMappingArray{ StudioSessionMappingArgs{...} }
type StudioSessionMappingArrayInput interface {
	pulumi.Input

	ToStudioSessionMappingArrayOutput() StudioSessionMappingArrayOutput
	ToStudioSessionMappingArrayOutputWithContext(context.Context) StudioSessionMappingArrayOutput
}

type StudioSessionMappingArray []StudioSessionMappingInput

func (StudioSessionMappingArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*StudioSessionMapping)(nil)).Elem()
}

func (i StudioSessionMappingArray) ToStudioSessionMappingArrayOutput() StudioSessionMappingArrayOutput {
	return i.ToStudioSessionMappingArrayOutputWithContext(context.Background())
}

func (i StudioSessionMappingArray) ToStudioSessionMappingArrayOutputWithContext(ctx context.Context) StudioSessionMappingArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(StudioSessionMappingArrayOutput)
}

// StudioSessionMappingMapInput is an input type that accepts StudioSessionMappingMap and StudioSessionMappingMapOutput values.
// You can construct a concrete instance of `StudioSessionMappingMapInput` via:
//
//	StudioSessionMappingMap{ "key": StudioSessionMappingArgs{...} }
type StudioSessionMappingMapInput interface {
	pulumi.Input

	ToStudioSessionMappingMapOutput() StudioSessionMappingMapOutput
	ToStudioSessionMappingMapOutputWithContext(context.Context) StudioSessionMappingMapOutput
}

type StudioSessionMappingMap map[string]StudioSessionMappingInput

func (StudioSessionMappingMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*StudioSessionMapping)(nil)).Elem()
}

func (i StudioSessionMappingMap) ToStudioSessionMappingMapOutput() StudioSessionMappingMapOutput {
	return i.ToStudioSessionMappingMapOutputWithContext(context.Background())
}

func (i StudioSessionMappingMap) ToStudioSessionMappingMapOutputWithContext(ctx context.Context) StudioSessionMappingMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(StudioSessionMappingMapOutput)
}

type StudioSessionMappingOutput struct{ *pulumi.OutputState }

func (StudioSessionMappingOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**StudioSessionMapping)(nil)).Elem()
}

func (o StudioSessionMappingOutput) ToStudioSessionMappingOutput() StudioSessionMappingOutput {
	return o
}

func (o StudioSessionMappingOutput) ToStudioSessionMappingOutputWithContext(ctx context.Context) StudioSessionMappingOutput {
	return o
}

// The globally unique identifier (GUID) of the user or group from the Amazon Web Services SSO Identity Store.
func (o StudioSessionMappingOutput) IdentityId() pulumi.StringOutput {
	return o.ApplyT(func(v *StudioSessionMapping) pulumi.StringOutput { return v.IdentityId }).(pulumi.StringOutput)
}

// The name of the user or group from the Amazon Web Services SSO Identity Store.
func (o StudioSessionMappingOutput) IdentityName() pulumi.StringOutput {
	return o.ApplyT(func(v *StudioSessionMapping) pulumi.StringOutput { return v.IdentityName }).(pulumi.StringOutput)
}

// Specifies whether the identity to map to the Amazon EMR Studio is a `USER` or a `GROUP`.
func (o StudioSessionMappingOutput) IdentityType() pulumi.StringOutput {
	return o.ApplyT(func(v *StudioSessionMapping) pulumi.StringOutput { return v.IdentityType }).(pulumi.StringOutput)
}

// The Amazon Resource Name (ARN) for the session policy that will be applied to the user or group. You should specify the ARN for the session policy that you want to apply, not the ARN of your user role.
func (o StudioSessionMappingOutput) SessionPolicyArn() pulumi.StringOutput {
	return o.ApplyT(func(v *StudioSessionMapping) pulumi.StringOutput { return v.SessionPolicyArn }).(pulumi.StringOutput)
}

// The ID of the Amazon EMR Studio to which the user or group will be mapped.
func (o StudioSessionMappingOutput) StudioId() pulumi.StringOutput {
	return o.ApplyT(func(v *StudioSessionMapping) pulumi.StringOutput { return v.StudioId }).(pulumi.StringOutput)
}

type StudioSessionMappingArrayOutput struct{ *pulumi.OutputState }

func (StudioSessionMappingArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*StudioSessionMapping)(nil)).Elem()
}

func (o StudioSessionMappingArrayOutput) ToStudioSessionMappingArrayOutput() StudioSessionMappingArrayOutput {
	return o
}

func (o StudioSessionMappingArrayOutput) ToStudioSessionMappingArrayOutputWithContext(ctx context.Context) StudioSessionMappingArrayOutput {
	return o
}

func (o StudioSessionMappingArrayOutput) Index(i pulumi.IntInput) StudioSessionMappingOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *StudioSessionMapping {
		return vs[0].([]*StudioSessionMapping)[vs[1].(int)]
	}).(StudioSessionMappingOutput)
}

type StudioSessionMappingMapOutput struct{ *pulumi.OutputState }

func (StudioSessionMappingMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*StudioSessionMapping)(nil)).Elem()
}

func (o StudioSessionMappingMapOutput) ToStudioSessionMappingMapOutput() StudioSessionMappingMapOutput {
	return o
}

func (o StudioSessionMappingMapOutput) ToStudioSessionMappingMapOutputWithContext(ctx context.Context) StudioSessionMappingMapOutput {
	return o
}

func (o StudioSessionMappingMapOutput) MapIndex(k pulumi.StringInput) StudioSessionMappingOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *StudioSessionMapping {
		return vs[0].(map[string]*StudioSessionMapping)[vs[1].(string)]
	}).(StudioSessionMappingOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*StudioSessionMappingInput)(nil)).Elem(), &StudioSessionMapping{})
	pulumi.RegisterInputType(reflect.TypeOf((*StudioSessionMappingArrayInput)(nil)).Elem(), StudioSessionMappingArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*StudioSessionMappingMapInput)(nil)).Elem(), StudioSessionMappingMap{})
	pulumi.RegisterOutputType(StudioSessionMappingOutput{})
	pulumi.RegisterOutputType(StudioSessionMappingArrayOutput{})
	pulumi.RegisterOutputType(StudioSessionMappingMapOutput{})
}
