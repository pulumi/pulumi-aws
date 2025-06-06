// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package appautoscaling

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides an Application AutoScaling ScalableTarget resource. To manage policies which get attached to the target, see the `appautoscaling.Policy` resource.
//
// > **NOTE:** Scalable targets created before 2023-03-20 may not have an assigned `arn`. These resource cannot use `tags` or participate in `defaultTags`. To prevent `pulumi preview` showing differences that can never be reconciled, use the `lifecycle.ignore_changes` meta-argument. See the example below.
//
// > **NOTE:** The [Application Auto Scaling service automatically attempts to manage IAM Service-Linked Roles](https://docs.aws.amazon.com/autoscaling/application/userguide/security_iam_service-with-iam.html#security_iam_service-with-iam-roles) when registering certain service namespaces for the first time. To manually manage this role, see the `iam.ServiceLinkedRole` resource.
//
// ## Example Usage
//
// ### DynamoDB Table Autoscaling
//
// ```go
// package main
//
// import (
//
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/appautoscaling"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := appautoscaling.NewTarget(ctx, "dynamodb_table_read_target", &appautoscaling.TargetArgs{
//				MaxCapacity:       pulumi.Int(100),
//				MinCapacity:       pulumi.Int(5),
//				ResourceId:        pulumi.Sprintf("table/%v", example.Name),
//				ScalableDimension: pulumi.String("dynamodb:table:ReadCapacityUnits"),
//				ServiceNamespace:  pulumi.String("dynamodb"),
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
// ### DynamoDB Index Autoscaling
//
// ```go
// package main
//
// import (
//
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/appautoscaling"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := appautoscaling.NewTarget(ctx, "dynamodb_index_read_target", &appautoscaling.TargetArgs{
//				MaxCapacity:       pulumi.Int(100),
//				MinCapacity:       pulumi.Int(5),
//				ResourceId:        pulumi.Sprintf("table/%v/index/%v", example.Name, indexName),
//				ScalableDimension: pulumi.String("dynamodb:index:ReadCapacityUnits"),
//				ServiceNamespace:  pulumi.String("dynamodb"),
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
// ### ECS Service Autoscaling
//
// ```go
// package main
//
// import (
//
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/appautoscaling"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := appautoscaling.NewTarget(ctx, "ecs_target", &appautoscaling.TargetArgs{
//				MaxCapacity:       pulumi.Int(4),
//				MinCapacity:       pulumi.Int(1),
//				ResourceId:        pulumi.Sprintf("service/%v/%v", example.Name, exampleAwsEcsService.Name),
//				ScalableDimension: pulumi.String("ecs:service:DesiredCount"),
//				ServiceNamespace:  pulumi.String("ecs"),
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
// ### Aurora Read Replica Autoscaling
//
// ```go
// package main
//
// import (
//
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/appautoscaling"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := appautoscaling.NewTarget(ctx, "replicas", &appautoscaling.TargetArgs{
//				ServiceNamespace:  pulumi.String("rds"),
//				ScalableDimension: pulumi.String("rds:cluster:ReadReplicaCount"),
//				ResourceId:        pulumi.Sprintf("cluster:%v", example.Id),
//				MinCapacity:       pulumi.Int(1),
//				MaxCapacity:       pulumi.Int(15),
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
// ### Suppressing `tagsAll` Differences For Older Resources
//
// ```go
// package main
//
// import (
//
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/appautoscaling"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := appautoscaling.NewTarget(ctx, "ecs_target", &appautoscaling.TargetArgs{
//				MaxCapacity:       pulumi.Int(4),
//				MinCapacity:       pulumi.Int(1),
//				ResourceId:        pulumi.Sprintf("service/%v/%v", example.Name, exampleAwsEcsService.Name),
//				ScalableDimension: pulumi.String("ecs:service:DesiredCount"),
//				ServiceNamespace:  pulumi.String("ecs"),
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
// ### MSK / Kafka Autoscaling
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/appautoscaling"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := appautoscaling.NewTarget(ctx, "msk_target", &appautoscaling.TargetArgs{
//				ServiceNamespace:  pulumi.String("kafka"),
//				ScalableDimension: pulumi.String("kafka:broker-storage:VolumeSize"),
//				ResourceId:        pulumi.Any(example.Arn),
//				MinCapacity:       pulumi.Int(1),
//				MaxCapacity:       pulumi.Int(8),
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
// Using `pulumi import`, import Application AutoScaling Target using the `service-namespace` , `resource-id` and `scalable-dimension` separated by `/`. For example:
//
// ```sh
// $ pulumi import aws:appautoscaling/target:Target test-target service-namespace/resource-id/scalable-dimension
// ```
type Target struct {
	pulumi.CustomResourceState

	// The ARN of the scalable target.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Max capacity of the scalable target.
	MaxCapacity pulumi.IntOutput `pulumi:"maxCapacity"`
	// Min capacity of the scalable target.
	MinCapacity pulumi.IntOutput `pulumi:"minCapacity"`
	// Resource type and unique identifier string for the resource associated with the scaling policy. Documentation can be found in the `ResourceId` parameter at: [AWS Application Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/application/APIReference/API_RegisterScalableTarget.html#API_RegisterScalableTarget_RequestParameters)
	ResourceId pulumi.StringOutput `pulumi:"resourceId"`
	// ARN of the IAM role that allows Application AutoScaling to modify your scalable target on your behalf. This defaults to an IAM Service-Linked Role for most services and custom IAM Roles are ignored by the API for those namespaces. See the [AWS Application Auto Scaling documentation](https://docs.aws.amazon.com/autoscaling/application/userguide/security_iam_service-with-iam.html#security_iam_service-with-iam-roles) for more information about how this service interacts with IAM.
	RoleArn pulumi.StringOutput `pulumi:"roleArn"`
	// Scalable dimension of the scalable target. Documentation can be found in the `ScalableDimension` parameter at: [AWS Application Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/application/APIReference/API_RegisterScalableTarget.html#API_RegisterScalableTarget_RequestParameters)
	ScalableDimension pulumi.StringOutput `pulumi:"scalableDimension"`
	// AWS service namespace of the scalable target. Documentation can be found in the `ServiceNamespace` parameter at: [AWS Application Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/application/APIReference/API_RegisterScalableTarget.html#API_RegisterScalableTarget_RequestParameters)
	ServiceNamespace pulumi.StringOutput `pulumi:"serviceNamespace"`
	// Specifies whether the scaling activities for a scalable target are in a suspended state.
	SuspendedState TargetSuspendedStateOutput `pulumi:"suspendedState"`
	// Map of tags to assign to the scalable target. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewTarget registers a new resource with the given unique name, arguments, and options.
func NewTarget(ctx *pulumi.Context,
	name string, args *TargetArgs, opts ...pulumi.ResourceOption) (*Target, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.MaxCapacity == nil {
		return nil, errors.New("invalid value for required argument 'MaxCapacity'")
	}
	if args.MinCapacity == nil {
		return nil, errors.New("invalid value for required argument 'MinCapacity'")
	}
	if args.ResourceId == nil {
		return nil, errors.New("invalid value for required argument 'ResourceId'")
	}
	if args.ScalableDimension == nil {
		return nil, errors.New("invalid value for required argument 'ScalableDimension'")
	}
	if args.ServiceNamespace == nil {
		return nil, errors.New("invalid value for required argument 'ServiceNamespace'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource Target
	err := ctx.RegisterResource("aws:appautoscaling/target:Target", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetTarget gets an existing Target resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetTarget(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *TargetState, opts ...pulumi.ResourceOption) (*Target, error) {
	var resource Target
	err := ctx.ReadResource("aws:appautoscaling/target:Target", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Target resources.
type targetState struct {
	// The ARN of the scalable target.
	Arn *string `pulumi:"arn"`
	// Max capacity of the scalable target.
	MaxCapacity *int `pulumi:"maxCapacity"`
	// Min capacity of the scalable target.
	MinCapacity *int `pulumi:"minCapacity"`
	// Resource type and unique identifier string for the resource associated with the scaling policy. Documentation can be found in the `ResourceId` parameter at: [AWS Application Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/application/APIReference/API_RegisterScalableTarget.html#API_RegisterScalableTarget_RequestParameters)
	ResourceId *string `pulumi:"resourceId"`
	// ARN of the IAM role that allows Application AutoScaling to modify your scalable target on your behalf. This defaults to an IAM Service-Linked Role for most services and custom IAM Roles are ignored by the API for those namespaces. See the [AWS Application Auto Scaling documentation](https://docs.aws.amazon.com/autoscaling/application/userguide/security_iam_service-with-iam.html#security_iam_service-with-iam-roles) for more information about how this service interacts with IAM.
	RoleArn *string `pulumi:"roleArn"`
	// Scalable dimension of the scalable target. Documentation can be found in the `ScalableDimension` parameter at: [AWS Application Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/application/APIReference/API_RegisterScalableTarget.html#API_RegisterScalableTarget_RequestParameters)
	ScalableDimension *string `pulumi:"scalableDimension"`
	// AWS service namespace of the scalable target. Documentation can be found in the `ServiceNamespace` parameter at: [AWS Application Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/application/APIReference/API_RegisterScalableTarget.html#API_RegisterScalableTarget_RequestParameters)
	ServiceNamespace *string `pulumi:"serviceNamespace"`
	// Specifies whether the scaling activities for a scalable target are in a suspended state.
	SuspendedState *TargetSuspendedState `pulumi:"suspendedState"`
	// Map of tags to assign to the scalable target. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type TargetState struct {
	// The ARN of the scalable target.
	Arn pulumi.StringPtrInput
	// Max capacity of the scalable target.
	MaxCapacity pulumi.IntPtrInput
	// Min capacity of the scalable target.
	MinCapacity pulumi.IntPtrInput
	// Resource type and unique identifier string for the resource associated with the scaling policy. Documentation can be found in the `ResourceId` parameter at: [AWS Application Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/application/APIReference/API_RegisterScalableTarget.html#API_RegisterScalableTarget_RequestParameters)
	ResourceId pulumi.StringPtrInput
	// ARN of the IAM role that allows Application AutoScaling to modify your scalable target on your behalf. This defaults to an IAM Service-Linked Role for most services and custom IAM Roles are ignored by the API for those namespaces. See the [AWS Application Auto Scaling documentation](https://docs.aws.amazon.com/autoscaling/application/userguide/security_iam_service-with-iam.html#security_iam_service-with-iam-roles) for more information about how this service interacts with IAM.
	RoleArn pulumi.StringPtrInput
	// Scalable dimension of the scalable target. Documentation can be found in the `ScalableDimension` parameter at: [AWS Application Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/application/APIReference/API_RegisterScalableTarget.html#API_RegisterScalableTarget_RequestParameters)
	ScalableDimension pulumi.StringPtrInput
	// AWS service namespace of the scalable target. Documentation can be found in the `ServiceNamespace` parameter at: [AWS Application Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/application/APIReference/API_RegisterScalableTarget.html#API_RegisterScalableTarget_RequestParameters)
	ServiceNamespace pulumi.StringPtrInput
	// Specifies whether the scaling activities for a scalable target are in a suspended state.
	SuspendedState TargetSuspendedStatePtrInput
	// Map of tags to assign to the scalable target. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (TargetState) ElementType() reflect.Type {
	return reflect.TypeOf((*targetState)(nil)).Elem()
}

type targetArgs struct {
	// Max capacity of the scalable target.
	MaxCapacity int `pulumi:"maxCapacity"`
	// Min capacity of the scalable target.
	MinCapacity int `pulumi:"minCapacity"`
	// Resource type and unique identifier string for the resource associated with the scaling policy. Documentation can be found in the `ResourceId` parameter at: [AWS Application Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/application/APIReference/API_RegisterScalableTarget.html#API_RegisterScalableTarget_RequestParameters)
	ResourceId string `pulumi:"resourceId"`
	// ARN of the IAM role that allows Application AutoScaling to modify your scalable target on your behalf. This defaults to an IAM Service-Linked Role for most services and custom IAM Roles are ignored by the API for those namespaces. See the [AWS Application Auto Scaling documentation](https://docs.aws.amazon.com/autoscaling/application/userguide/security_iam_service-with-iam.html#security_iam_service-with-iam-roles) for more information about how this service interacts with IAM.
	RoleArn *string `pulumi:"roleArn"`
	// Scalable dimension of the scalable target. Documentation can be found in the `ScalableDimension` parameter at: [AWS Application Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/application/APIReference/API_RegisterScalableTarget.html#API_RegisterScalableTarget_RequestParameters)
	ScalableDimension string `pulumi:"scalableDimension"`
	// AWS service namespace of the scalable target. Documentation can be found in the `ServiceNamespace` parameter at: [AWS Application Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/application/APIReference/API_RegisterScalableTarget.html#API_RegisterScalableTarget_RequestParameters)
	ServiceNamespace string `pulumi:"serviceNamespace"`
	// Specifies whether the scaling activities for a scalable target are in a suspended state.
	SuspendedState *TargetSuspendedState `pulumi:"suspendedState"`
	// Map of tags to assign to the scalable target. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a Target resource.
type TargetArgs struct {
	// Max capacity of the scalable target.
	MaxCapacity pulumi.IntInput
	// Min capacity of the scalable target.
	MinCapacity pulumi.IntInput
	// Resource type and unique identifier string for the resource associated with the scaling policy. Documentation can be found in the `ResourceId` parameter at: [AWS Application Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/application/APIReference/API_RegisterScalableTarget.html#API_RegisterScalableTarget_RequestParameters)
	ResourceId pulumi.StringInput
	// ARN of the IAM role that allows Application AutoScaling to modify your scalable target on your behalf. This defaults to an IAM Service-Linked Role for most services and custom IAM Roles are ignored by the API for those namespaces. See the [AWS Application Auto Scaling documentation](https://docs.aws.amazon.com/autoscaling/application/userguide/security_iam_service-with-iam.html#security_iam_service-with-iam-roles) for more information about how this service interacts with IAM.
	RoleArn pulumi.StringPtrInput
	// Scalable dimension of the scalable target. Documentation can be found in the `ScalableDimension` parameter at: [AWS Application Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/application/APIReference/API_RegisterScalableTarget.html#API_RegisterScalableTarget_RequestParameters)
	ScalableDimension pulumi.StringInput
	// AWS service namespace of the scalable target. Documentation can be found in the `ServiceNamespace` parameter at: [AWS Application Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/application/APIReference/API_RegisterScalableTarget.html#API_RegisterScalableTarget_RequestParameters)
	ServiceNamespace pulumi.StringInput
	// Specifies whether the scaling activities for a scalable target are in a suspended state.
	SuspendedState TargetSuspendedStatePtrInput
	// Map of tags to assign to the scalable target. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (TargetArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*targetArgs)(nil)).Elem()
}

type TargetInput interface {
	pulumi.Input

	ToTargetOutput() TargetOutput
	ToTargetOutputWithContext(ctx context.Context) TargetOutput
}

func (*Target) ElementType() reflect.Type {
	return reflect.TypeOf((**Target)(nil)).Elem()
}

func (i *Target) ToTargetOutput() TargetOutput {
	return i.ToTargetOutputWithContext(context.Background())
}

func (i *Target) ToTargetOutputWithContext(ctx context.Context) TargetOutput {
	return pulumi.ToOutputWithContext(ctx, i).(TargetOutput)
}

// TargetArrayInput is an input type that accepts TargetArray and TargetArrayOutput values.
// You can construct a concrete instance of `TargetArrayInput` via:
//
//	TargetArray{ TargetArgs{...} }
type TargetArrayInput interface {
	pulumi.Input

	ToTargetArrayOutput() TargetArrayOutput
	ToTargetArrayOutputWithContext(context.Context) TargetArrayOutput
}

type TargetArray []TargetInput

func (TargetArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Target)(nil)).Elem()
}

func (i TargetArray) ToTargetArrayOutput() TargetArrayOutput {
	return i.ToTargetArrayOutputWithContext(context.Background())
}

func (i TargetArray) ToTargetArrayOutputWithContext(ctx context.Context) TargetArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(TargetArrayOutput)
}

// TargetMapInput is an input type that accepts TargetMap and TargetMapOutput values.
// You can construct a concrete instance of `TargetMapInput` via:
//
//	TargetMap{ "key": TargetArgs{...} }
type TargetMapInput interface {
	pulumi.Input

	ToTargetMapOutput() TargetMapOutput
	ToTargetMapOutputWithContext(context.Context) TargetMapOutput
}

type TargetMap map[string]TargetInput

func (TargetMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Target)(nil)).Elem()
}

func (i TargetMap) ToTargetMapOutput() TargetMapOutput {
	return i.ToTargetMapOutputWithContext(context.Background())
}

func (i TargetMap) ToTargetMapOutputWithContext(ctx context.Context) TargetMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(TargetMapOutput)
}

type TargetOutput struct{ *pulumi.OutputState }

func (TargetOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**Target)(nil)).Elem()
}

func (o TargetOutput) ToTargetOutput() TargetOutput {
	return o
}

func (o TargetOutput) ToTargetOutputWithContext(ctx context.Context) TargetOutput {
	return o
}

// The ARN of the scalable target.
func (o TargetOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *Target) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Max capacity of the scalable target.
func (o TargetOutput) MaxCapacity() pulumi.IntOutput {
	return o.ApplyT(func(v *Target) pulumi.IntOutput { return v.MaxCapacity }).(pulumi.IntOutput)
}

// Min capacity of the scalable target.
func (o TargetOutput) MinCapacity() pulumi.IntOutput {
	return o.ApplyT(func(v *Target) pulumi.IntOutput { return v.MinCapacity }).(pulumi.IntOutput)
}

// Resource type and unique identifier string for the resource associated with the scaling policy. Documentation can be found in the `ResourceId` parameter at: [AWS Application Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/application/APIReference/API_RegisterScalableTarget.html#API_RegisterScalableTarget_RequestParameters)
func (o TargetOutput) ResourceId() pulumi.StringOutput {
	return o.ApplyT(func(v *Target) pulumi.StringOutput { return v.ResourceId }).(pulumi.StringOutput)
}

// ARN of the IAM role that allows Application AutoScaling to modify your scalable target on your behalf. This defaults to an IAM Service-Linked Role for most services and custom IAM Roles are ignored by the API for those namespaces. See the [AWS Application Auto Scaling documentation](https://docs.aws.amazon.com/autoscaling/application/userguide/security_iam_service-with-iam.html#security_iam_service-with-iam-roles) for more information about how this service interacts with IAM.
func (o TargetOutput) RoleArn() pulumi.StringOutput {
	return o.ApplyT(func(v *Target) pulumi.StringOutput { return v.RoleArn }).(pulumi.StringOutput)
}

// Scalable dimension of the scalable target. Documentation can be found in the `ScalableDimension` parameter at: [AWS Application Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/application/APIReference/API_RegisterScalableTarget.html#API_RegisterScalableTarget_RequestParameters)
func (o TargetOutput) ScalableDimension() pulumi.StringOutput {
	return o.ApplyT(func(v *Target) pulumi.StringOutput { return v.ScalableDimension }).(pulumi.StringOutput)
}

// AWS service namespace of the scalable target. Documentation can be found in the `ServiceNamespace` parameter at: [AWS Application Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/application/APIReference/API_RegisterScalableTarget.html#API_RegisterScalableTarget_RequestParameters)
func (o TargetOutput) ServiceNamespace() pulumi.StringOutput {
	return o.ApplyT(func(v *Target) pulumi.StringOutput { return v.ServiceNamespace }).(pulumi.StringOutput)
}

// Specifies whether the scaling activities for a scalable target are in a suspended state.
func (o TargetOutput) SuspendedState() TargetSuspendedStateOutput {
	return o.ApplyT(func(v *Target) TargetSuspendedStateOutput { return v.SuspendedState }).(TargetSuspendedStateOutput)
}

// Map of tags to assign to the scalable target. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o TargetOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Target) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o TargetOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Target) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type TargetArrayOutput struct{ *pulumi.OutputState }

func (TargetArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Target)(nil)).Elem()
}

func (o TargetArrayOutput) ToTargetArrayOutput() TargetArrayOutput {
	return o
}

func (o TargetArrayOutput) ToTargetArrayOutputWithContext(ctx context.Context) TargetArrayOutput {
	return o
}

func (o TargetArrayOutput) Index(i pulumi.IntInput) TargetOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *Target {
		return vs[0].([]*Target)[vs[1].(int)]
	}).(TargetOutput)
}

type TargetMapOutput struct{ *pulumi.OutputState }

func (TargetMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Target)(nil)).Elem()
}

func (o TargetMapOutput) ToTargetMapOutput() TargetMapOutput {
	return o
}

func (o TargetMapOutput) ToTargetMapOutputWithContext(ctx context.Context) TargetMapOutput {
	return o
}

func (o TargetMapOutput) MapIndex(k pulumi.StringInput) TargetOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *Target {
		return vs[0].(map[string]*Target)[vs[1].(string)]
	}).(TargetOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*TargetInput)(nil)).Elem(), &Target{})
	pulumi.RegisterInputType(reflect.TypeOf((*TargetArrayInput)(nil)).Elem(), TargetArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*TargetMapInput)(nil)).Elem(), TargetMap{})
	pulumi.RegisterOutputType(TargetOutput{})
	pulumi.RegisterOutputType(TargetArrayOutput{})
	pulumi.RegisterOutputType(TargetMapOutput{})
}
