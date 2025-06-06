// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package costoptimizationhub

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing AWS Cost Optimization Hub Enrollment Status.
//
// > **TIP:** The Cost Optimization Hub only has a `us-east-1` endpoint. However, you can access the service globally with the AWS Provider from other regions. Other tools, such as the [AWS CLI](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/cost-optimization-hub/index.html), may require you to specify the `us-east-1` region when using the service.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/costoptimizationhub"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := costoptimizationhub.NewEnrollmentStatus(ctx, "example", nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// ### Usage with all the arguments
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/costoptimizationhub"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := costoptimizationhub.NewEnrollmentStatus(ctx, "example", &costoptimizationhub.EnrollmentStatusArgs{
//				IncludeMemberAccounts: pulumi.Bool(true),
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
// Using `pulumi import`, import Cost Optimization Hub Enrollment Status using your AWS account ID. For example:
//
// ```sh
// $ pulumi import aws:costoptimizationhub/enrollmentStatus:EnrollmentStatus example 111222333444
// ```
type EnrollmentStatus struct {
	pulumi.CustomResourceState

	// Flag to enroll member accounts of the organization if the account is the management account. No drift detection is currently supported for this argument. Default value is `false`.
	IncludeMemberAccounts pulumi.BoolOutput   `pulumi:"includeMemberAccounts"`
	Status                pulumi.StringOutput `pulumi:"status"`
}

// NewEnrollmentStatus registers a new resource with the given unique name, arguments, and options.
func NewEnrollmentStatus(ctx *pulumi.Context,
	name string, args *EnrollmentStatusArgs, opts ...pulumi.ResourceOption) (*EnrollmentStatus, error) {
	if args == nil {
		args = &EnrollmentStatusArgs{}
	}

	opts = internal.PkgResourceDefaultOpts(opts)
	var resource EnrollmentStatus
	err := ctx.RegisterResource("aws:costoptimizationhub/enrollmentStatus:EnrollmentStatus", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetEnrollmentStatus gets an existing EnrollmentStatus resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetEnrollmentStatus(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *EnrollmentStatusState, opts ...pulumi.ResourceOption) (*EnrollmentStatus, error) {
	var resource EnrollmentStatus
	err := ctx.ReadResource("aws:costoptimizationhub/enrollmentStatus:EnrollmentStatus", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering EnrollmentStatus resources.
type enrollmentStatusState struct {
	// Flag to enroll member accounts of the organization if the account is the management account. No drift detection is currently supported for this argument. Default value is `false`.
	IncludeMemberAccounts *bool   `pulumi:"includeMemberAccounts"`
	Status                *string `pulumi:"status"`
}

type EnrollmentStatusState struct {
	// Flag to enroll member accounts of the organization if the account is the management account. No drift detection is currently supported for this argument. Default value is `false`.
	IncludeMemberAccounts pulumi.BoolPtrInput
	Status                pulumi.StringPtrInput
}

func (EnrollmentStatusState) ElementType() reflect.Type {
	return reflect.TypeOf((*enrollmentStatusState)(nil)).Elem()
}

type enrollmentStatusArgs struct {
	// Flag to enroll member accounts of the organization if the account is the management account. No drift detection is currently supported for this argument. Default value is `false`.
	IncludeMemberAccounts *bool `pulumi:"includeMemberAccounts"`
}

// The set of arguments for constructing a EnrollmentStatus resource.
type EnrollmentStatusArgs struct {
	// Flag to enroll member accounts of the organization if the account is the management account. No drift detection is currently supported for this argument. Default value is `false`.
	IncludeMemberAccounts pulumi.BoolPtrInput
}

func (EnrollmentStatusArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*enrollmentStatusArgs)(nil)).Elem()
}

type EnrollmentStatusInput interface {
	pulumi.Input

	ToEnrollmentStatusOutput() EnrollmentStatusOutput
	ToEnrollmentStatusOutputWithContext(ctx context.Context) EnrollmentStatusOutput
}

func (*EnrollmentStatus) ElementType() reflect.Type {
	return reflect.TypeOf((**EnrollmentStatus)(nil)).Elem()
}

func (i *EnrollmentStatus) ToEnrollmentStatusOutput() EnrollmentStatusOutput {
	return i.ToEnrollmentStatusOutputWithContext(context.Background())
}

func (i *EnrollmentStatus) ToEnrollmentStatusOutputWithContext(ctx context.Context) EnrollmentStatusOutput {
	return pulumi.ToOutputWithContext(ctx, i).(EnrollmentStatusOutput)
}

// EnrollmentStatusArrayInput is an input type that accepts EnrollmentStatusArray and EnrollmentStatusArrayOutput values.
// You can construct a concrete instance of `EnrollmentStatusArrayInput` via:
//
//	EnrollmentStatusArray{ EnrollmentStatusArgs{...} }
type EnrollmentStatusArrayInput interface {
	pulumi.Input

	ToEnrollmentStatusArrayOutput() EnrollmentStatusArrayOutput
	ToEnrollmentStatusArrayOutputWithContext(context.Context) EnrollmentStatusArrayOutput
}

type EnrollmentStatusArray []EnrollmentStatusInput

func (EnrollmentStatusArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*EnrollmentStatus)(nil)).Elem()
}

func (i EnrollmentStatusArray) ToEnrollmentStatusArrayOutput() EnrollmentStatusArrayOutput {
	return i.ToEnrollmentStatusArrayOutputWithContext(context.Background())
}

func (i EnrollmentStatusArray) ToEnrollmentStatusArrayOutputWithContext(ctx context.Context) EnrollmentStatusArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(EnrollmentStatusArrayOutput)
}

// EnrollmentStatusMapInput is an input type that accepts EnrollmentStatusMap and EnrollmentStatusMapOutput values.
// You can construct a concrete instance of `EnrollmentStatusMapInput` via:
//
//	EnrollmentStatusMap{ "key": EnrollmentStatusArgs{...} }
type EnrollmentStatusMapInput interface {
	pulumi.Input

	ToEnrollmentStatusMapOutput() EnrollmentStatusMapOutput
	ToEnrollmentStatusMapOutputWithContext(context.Context) EnrollmentStatusMapOutput
}

type EnrollmentStatusMap map[string]EnrollmentStatusInput

func (EnrollmentStatusMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*EnrollmentStatus)(nil)).Elem()
}

func (i EnrollmentStatusMap) ToEnrollmentStatusMapOutput() EnrollmentStatusMapOutput {
	return i.ToEnrollmentStatusMapOutputWithContext(context.Background())
}

func (i EnrollmentStatusMap) ToEnrollmentStatusMapOutputWithContext(ctx context.Context) EnrollmentStatusMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(EnrollmentStatusMapOutput)
}

type EnrollmentStatusOutput struct{ *pulumi.OutputState }

func (EnrollmentStatusOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**EnrollmentStatus)(nil)).Elem()
}

func (o EnrollmentStatusOutput) ToEnrollmentStatusOutput() EnrollmentStatusOutput {
	return o
}

func (o EnrollmentStatusOutput) ToEnrollmentStatusOutputWithContext(ctx context.Context) EnrollmentStatusOutput {
	return o
}

// Flag to enroll member accounts of the organization if the account is the management account. No drift detection is currently supported for this argument. Default value is `false`.
func (o EnrollmentStatusOutput) IncludeMemberAccounts() pulumi.BoolOutput {
	return o.ApplyT(func(v *EnrollmentStatus) pulumi.BoolOutput { return v.IncludeMemberAccounts }).(pulumi.BoolOutput)
}

func (o EnrollmentStatusOutput) Status() pulumi.StringOutput {
	return o.ApplyT(func(v *EnrollmentStatus) pulumi.StringOutput { return v.Status }).(pulumi.StringOutput)
}

type EnrollmentStatusArrayOutput struct{ *pulumi.OutputState }

func (EnrollmentStatusArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*EnrollmentStatus)(nil)).Elem()
}

func (o EnrollmentStatusArrayOutput) ToEnrollmentStatusArrayOutput() EnrollmentStatusArrayOutput {
	return o
}

func (o EnrollmentStatusArrayOutput) ToEnrollmentStatusArrayOutputWithContext(ctx context.Context) EnrollmentStatusArrayOutput {
	return o
}

func (o EnrollmentStatusArrayOutput) Index(i pulumi.IntInput) EnrollmentStatusOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *EnrollmentStatus {
		return vs[0].([]*EnrollmentStatus)[vs[1].(int)]
	}).(EnrollmentStatusOutput)
}

type EnrollmentStatusMapOutput struct{ *pulumi.OutputState }

func (EnrollmentStatusMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*EnrollmentStatus)(nil)).Elem()
}

func (o EnrollmentStatusMapOutput) ToEnrollmentStatusMapOutput() EnrollmentStatusMapOutput {
	return o
}

func (o EnrollmentStatusMapOutput) ToEnrollmentStatusMapOutputWithContext(ctx context.Context) EnrollmentStatusMapOutput {
	return o
}

func (o EnrollmentStatusMapOutput) MapIndex(k pulumi.StringInput) EnrollmentStatusOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *EnrollmentStatus {
		return vs[0].(map[string]*EnrollmentStatus)[vs[1].(string)]
	}).(EnrollmentStatusOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*EnrollmentStatusInput)(nil)).Elem(), &EnrollmentStatus{})
	pulumi.RegisterInputType(reflect.TypeOf((*EnrollmentStatusArrayInput)(nil)).Elem(), EnrollmentStatusArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*EnrollmentStatusMapInput)(nil)).Elem(), EnrollmentStatusMap{})
	pulumi.RegisterOutputType(EnrollmentStatusOutput{})
	pulumi.RegisterOutputType(EnrollmentStatusArrayOutput{})
	pulumi.RegisterOutputType(EnrollmentStatusMapOutput{})
}
