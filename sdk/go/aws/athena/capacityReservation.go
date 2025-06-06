// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package athena

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS Athena Capacity Reservation.
//
// > Destruction of this resource will both [cancel](https://docs.aws.amazon.com/athena/latest/ug/capacity-management-cancelling-a-capacity-reservation.html) and [delete](https://docs.aws.amazon.com/athena/latest/ug/capacity-management-deleting-a-capacity-reservation.html) the capacity reservation.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/athena"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := athena.NewCapacityReservation(ctx, "example", &athena.CapacityReservationArgs{
//				Name:       pulumi.String("example-reservation"),
//				TargetDpus: pulumi.Int(24),
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
// Using `pulumi import`, import Athena Capacity Reservation using the `name`. For example:
//
// ```sh
// $ pulumi import aws:athena/capacityReservation:CapacityReservation example example-reservation
// ```
type CapacityReservation struct {
	pulumi.CustomResourceState

	// Number of data processing units currently allocated.
	AllocatedDpus pulumi.IntOutput `pulumi:"allocatedDpus"`
	// ARN of the Capacity Reservation.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Name of the capacity reservation.
	Name pulumi.StringOutput `pulumi:"name"`
	// Status of the capacity reservation.
	Status pulumi.StringOutput `pulumi:"status"`
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	// Number of data processing units requested. Must be at least `24` units.
	//
	// The following arguments are optional:
	TargetDpus pulumi.IntOutput                     `pulumi:"targetDpus"`
	Timeouts   CapacityReservationTimeoutsPtrOutput `pulumi:"timeouts"`
}

// NewCapacityReservation registers a new resource with the given unique name, arguments, and options.
func NewCapacityReservation(ctx *pulumi.Context,
	name string, args *CapacityReservationArgs, opts ...pulumi.ResourceOption) (*CapacityReservation, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.TargetDpus == nil {
		return nil, errors.New("invalid value for required argument 'TargetDpus'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource CapacityReservation
	err := ctx.RegisterResource("aws:athena/capacityReservation:CapacityReservation", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetCapacityReservation gets an existing CapacityReservation resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetCapacityReservation(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *CapacityReservationState, opts ...pulumi.ResourceOption) (*CapacityReservation, error) {
	var resource CapacityReservation
	err := ctx.ReadResource("aws:athena/capacityReservation:CapacityReservation", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering CapacityReservation resources.
type capacityReservationState struct {
	// Number of data processing units currently allocated.
	AllocatedDpus *int `pulumi:"allocatedDpus"`
	// ARN of the Capacity Reservation.
	Arn *string `pulumi:"arn"`
	// Name of the capacity reservation.
	Name *string `pulumi:"name"`
	// Status of the capacity reservation.
	Status *string `pulumi:"status"`
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	// Number of data processing units requested. Must be at least `24` units.
	//
	// The following arguments are optional:
	TargetDpus *int                         `pulumi:"targetDpus"`
	Timeouts   *CapacityReservationTimeouts `pulumi:"timeouts"`
}

type CapacityReservationState struct {
	// Number of data processing units currently allocated.
	AllocatedDpus pulumi.IntPtrInput
	// ARN of the Capacity Reservation.
	Arn pulumi.StringPtrInput
	// Name of the capacity reservation.
	Name pulumi.StringPtrInput
	// Status of the capacity reservation.
	Status pulumi.StringPtrInput
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	// Number of data processing units requested. Must be at least `24` units.
	//
	// The following arguments are optional:
	TargetDpus pulumi.IntPtrInput
	Timeouts   CapacityReservationTimeoutsPtrInput
}

func (CapacityReservationState) ElementType() reflect.Type {
	return reflect.TypeOf((*capacityReservationState)(nil)).Elem()
}

type capacityReservationArgs struct {
	// Name of the capacity reservation.
	Name *string `pulumi:"name"`
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Number of data processing units requested. Must be at least `24` units.
	//
	// The following arguments are optional:
	TargetDpus int                          `pulumi:"targetDpus"`
	Timeouts   *CapacityReservationTimeouts `pulumi:"timeouts"`
}

// The set of arguments for constructing a CapacityReservation resource.
type CapacityReservationArgs struct {
	// Name of the capacity reservation.
	Name pulumi.StringPtrInput
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Number of data processing units requested. Must be at least `24` units.
	//
	// The following arguments are optional:
	TargetDpus pulumi.IntInput
	Timeouts   CapacityReservationTimeoutsPtrInput
}

func (CapacityReservationArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*capacityReservationArgs)(nil)).Elem()
}

type CapacityReservationInput interface {
	pulumi.Input

	ToCapacityReservationOutput() CapacityReservationOutput
	ToCapacityReservationOutputWithContext(ctx context.Context) CapacityReservationOutput
}

func (*CapacityReservation) ElementType() reflect.Type {
	return reflect.TypeOf((**CapacityReservation)(nil)).Elem()
}

func (i *CapacityReservation) ToCapacityReservationOutput() CapacityReservationOutput {
	return i.ToCapacityReservationOutputWithContext(context.Background())
}

func (i *CapacityReservation) ToCapacityReservationOutputWithContext(ctx context.Context) CapacityReservationOutput {
	return pulumi.ToOutputWithContext(ctx, i).(CapacityReservationOutput)
}

// CapacityReservationArrayInput is an input type that accepts CapacityReservationArray and CapacityReservationArrayOutput values.
// You can construct a concrete instance of `CapacityReservationArrayInput` via:
//
//	CapacityReservationArray{ CapacityReservationArgs{...} }
type CapacityReservationArrayInput interface {
	pulumi.Input

	ToCapacityReservationArrayOutput() CapacityReservationArrayOutput
	ToCapacityReservationArrayOutputWithContext(context.Context) CapacityReservationArrayOutput
}

type CapacityReservationArray []CapacityReservationInput

func (CapacityReservationArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*CapacityReservation)(nil)).Elem()
}

func (i CapacityReservationArray) ToCapacityReservationArrayOutput() CapacityReservationArrayOutput {
	return i.ToCapacityReservationArrayOutputWithContext(context.Background())
}

func (i CapacityReservationArray) ToCapacityReservationArrayOutputWithContext(ctx context.Context) CapacityReservationArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(CapacityReservationArrayOutput)
}

// CapacityReservationMapInput is an input type that accepts CapacityReservationMap and CapacityReservationMapOutput values.
// You can construct a concrete instance of `CapacityReservationMapInput` via:
//
//	CapacityReservationMap{ "key": CapacityReservationArgs{...} }
type CapacityReservationMapInput interface {
	pulumi.Input

	ToCapacityReservationMapOutput() CapacityReservationMapOutput
	ToCapacityReservationMapOutputWithContext(context.Context) CapacityReservationMapOutput
}

type CapacityReservationMap map[string]CapacityReservationInput

func (CapacityReservationMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*CapacityReservation)(nil)).Elem()
}

func (i CapacityReservationMap) ToCapacityReservationMapOutput() CapacityReservationMapOutput {
	return i.ToCapacityReservationMapOutputWithContext(context.Background())
}

func (i CapacityReservationMap) ToCapacityReservationMapOutputWithContext(ctx context.Context) CapacityReservationMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(CapacityReservationMapOutput)
}

type CapacityReservationOutput struct{ *pulumi.OutputState }

func (CapacityReservationOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**CapacityReservation)(nil)).Elem()
}

func (o CapacityReservationOutput) ToCapacityReservationOutput() CapacityReservationOutput {
	return o
}

func (o CapacityReservationOutput) ToCapacityReservationOutputWithContext(ctx context.Context) CapacityReservationOutput {
	return o
}

// Number of data processing units currently allocated.
func (o CapacityReservationOutput) AllocatedDpus() pulumi.IntOutput {
	return o.ApplyT(func(v *CapacityReservation) pulumi.IntOutput { return v.AllocatedDpus }).(pulumi.IntOutput)
}

// ARN of the Capacity Reservation.
func (o CapacityReservationOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *CapacityReservation) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Name of the capacity reservation.
func (o CapacityReservationOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *CapacityReservation) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// Status of the capacity reservation.
func (o CapacityReservationOutput) Status() pulumi.StringOutput {
	return o.ApplyT(func(v *CapacityReservation) pulumi.StringOutput { return v.Status }).(pulumi.StringOutput)
}

// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o CapacityReservationOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *CapacityReservation) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o CapacityReservationOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *CapacityReservation) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

// Number of data processing units requested. Must be at least `24` units.
//
// The following arguments are optional:
func (o CapacityReservationOutput) TargetDpus() pulumi.IntOutput {
	return o.ApplyT(func(v *CapacityReservation) pulumi.IntOutput { return v.TargetDpus }).(pulumi.IntOutput)
}

func (o CapacityReservationOutput) Timeouts() CapacityReservationTimeoutsPtrOutput {
	return o.ApplyT(func(v *CapacityReservation) CapacityReservationTimeoutsPtrOutput { return v.Timeouts }).(CapacityReservationTimeoutsPtrOutput)
}

type CapacityReservationArrayOutput struct{ *pulumi.OutputState }

func (CapacityReservationArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*CapacityReservation)(nil)).Elem()
}

func (o CapacityReservationArrayOutput) ToCapacityReservationArrayOutput() CapacityReservationArrayOutput {
	return o
}

func (o CapacityReservationArrayOutput) ToCapacityReservationArrayOutputWithContext(ctx context.Context) CapacityReservationArrayOutput {
	return o
}

func (o CapacityReservationArrayOutput) Index(i pulumi.IntInput) CapacityReservationOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *CapacityReservation {
		return vs[0].([]*CapacityReservation)[vs[1].(int)]
	}).(CapacityReservationOutput)
}

type CapacityReservationMapOutput struct{ *pulumi.OutputState }

func (CapacityReservationMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*CapacityReservation)(nil)).Elem()
}

func (o CapacityReservationMapOutput) ToCapacityReservationMapOutput() CapacityReservationMapOutput {
	return o
}

func (o CapacityReservationMapOutput) ToCapacityReservationMapOutputWithContext(ctx context.Context) CapacityReservationMapOutput {
	return o
}

func (o CapacityReservationMapOutput) MapIndex(k pulumi.StringInput) CapacityReservationOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *CapacityReservation {
		return vs[0].(map[string]*CapacityReservation)[vs[1].(string)]
	}).(CapacityReservationOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*CapacityReservationInput)(nil)).Elem(), &CapacityReservation{})
	pulumi.RegisterInputType(reflect.TypeOf((*CapacityReservationArrayInput)(nil)).Elem(), CapacityReservationArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*CapacityReservationMapInput)(nil)).Elem(), CapacityReservationMap{})
	pulumi.RegisterOutputType(CapacityReservationOutput{})
	pulumi.RegisterOutputType(CapacityReservationArrayOutput{})
	pulumi.RegisterOutputType(CapacityReservationMapOutput{})
}
