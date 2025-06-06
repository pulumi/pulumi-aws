// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package lambda

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS Lambda Runtime Management Config.
//
// Refer to the [AWS Lambda documentation](https://docs.aws.amazon.com/lambda/latest/dg/lambda-runtimes.html) for supported runtimes.
//
// > Deletion of this resource returns the runtime update mode to `Auto` (the default behavior).
// To leave the configured runtime management options in-place, use a `removed` block with the destroy lifecycle set to `false`.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/lambda"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := lambda.NewRuntimeManagementConfig(ctx, "example", &lambda.RuntimeManagementConfigArgs{
//				FunctionName:    pulumi.Any(test.FunctionName),
//				UpdateRuntimeOn: pulumi.String("FunctionUpdate"),
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
// ### `Manual` Update
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/lambda"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := lambda.NewRuntimeManagementConfig(ctx, "example", &lambda.RuntimeManagementConfigArgs{
//				FunctionName:      pulumi.Any(test.FunctionName),
//				UpdateRuntimeOn:   pulumi.String("Manual"),
//				RuntimeVersionArn: pulumi.String("arn:aws:lambda:us-east-1::runtime:abcd1234"),
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
// > Once the runtime update mode is set to `Manual`, the `lambda.Function` `runtime` cannot be updated. To upgrade a runtime, the `updateRuntimeOn` argument must be set to `Auto` or `FunctionUpdate` prior to changing the function's `runtime` argument.
//
// ## Import
//
// Using `pulumi import`, import Lambda Runtime Management Config using a comma-delimited string combining `function_name` and `qualifier`. For example:
//
// ```sh
// $ pulumi import aws:lambda/runtimeManagementConfig:RuntimeManagementConfig example my-function,$LATEST
// ```
type RuntimeManagementConfig struct {
	pulumi.CustomResourceState

	// ARN of the function.
	FunctionArn pulumi.StringOutput `pulumi:"functionArn"`
	// Name or ARN of the Lambda function.
	//
	// The following arguments are optional:
	FunctionName pulumi.StringOutput `pulumi:"functionName"`
	// Version of the function. This can be `$LATEST` or a published version number. If omitted, this resource will manage the runtime configuration for `$LATEST`.
	Qualifier pulumi.StringPtrOutput `pulumi:"qualifier"`
	// ARN of the runtime version. Only required when `updateRuntimeOn` is `Manual`.
	RuntimeVersionArn pulumi.StringPtrOutput `pulumi:"runtimeVersionArn"`
	// Runtime update mode. Valid values are `Auto`, `FunctionUpdate`, and `Manual`. When a function is created, the default mode is `Auto`.
	UpdateRuntimeOn pulumi.StringPtrOutput `pulumi:"updateRuntimeOn"`
}

// NewRuntimeManagementConfig registers a new resource with the given unique name, arguments, and options.
func NewRuntimeManagementConfig(ctx *pulumi.Context,
	name string, args *RuntimeManagementConfigArgs, opts ...pulumi.ResourceOption) (*RuntimeManagementConfig, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.FunctionName == nil {
		return nil, errors.New("invalid value for required argument 'FunctionName'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource RuntimeManagementConfig
	err := ctx.RegisterResource("aws:lambda/runtimeManagementConfig:RuntimeManagementConfig", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetRuntimeManagementConfig gets an existing RuntimeManagementConfig resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetRuntimeManagementConfig(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *RuntimeManagementConfigState, opts ...pulumi.ResourceOption) (*RuntimeManagementConfig, error) {
	var resource RuntimeManagementConfig
	err := ctx.ReadResource("aws:lambda/runtimeManagementConfig:RuntimeManagementConfig", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering RuntimeManagementConfig resources.
type runtimeManagementConfigState struct {
	// ARN of the function.
	FunctionArn *string `pulumi:"functionArn"`
	// Name or ARN of the Lambda function.
	//
	// The following arguments are optional:
	FunctionName *string `pulumi:"functionName"`
	// Version of the function. This can be `$LATEST` or a published version number. If omitted, this resource will manage the runtime configuration for `$LATEST`.
	Qualifier *string `pulumi:"qualifier"`
	// ARN of the runtime version. Only required when `updateRuntimeOn` is `Manual`.
	RuntimeVersionArn *string `pulumi:"runtimeVersionArn"`
	// Runtime update mode. Valid values are `Auto`, `FunctionUpdate`, and `Manual`. When a function is created, the default mode is `Auto`.
	UpdateRuntimeOn *string `pulumi:"updateRuntimeOn"`
}

type RuntimeManagementConfigState struct {
	// ARN of the function.
	FunctionArn pulumi.StringPtrInput
	// Name or ARN of the Lambda function.
	//
	// The following arguments are optional:
	FunctionName pulumi.StringPtrInput
	// Version of the function. This can be `$LATEST` or a published version number. If omitted, this resource will manage the runtime configuration for `$LATEST`.
	Qualifier pulumi.StringPtrInput
	// ARN of the runtime version. Only required when `updateRuntimeOn` is `Manual`.
	RuntimeVersionArn pulumi.StringPtrInput
	// Runtime update mode. Valid values are `Auto`, `FunctionUpdate`, and `Manual`. When a function is created, the default mode is `Auto`.
	UpdateRuntimeOn pulumi.StringPtrInput
}

func (RuntimeManagementConfigState) ElementType() reflect.Type {
	return reflect.TypeOf((*runtimeManagementConfigState)(nil)).Elem()
}

type runtimeManagementConfigArgs struct {
	// Name or ARN of the Lambda function.
	//
	// The following arguments are optional:
	FunctionName string `pulumi:"functionName"`
	// Version of the function. This can be `$LATEST` or a published version number. If omitted, this resource will manage the runtime configuration for `$LATEST`.
	Qualifier *string `pulumi:"qualifier"`
	// ARN of the runtime version. Only required when `updateRuntimeOn` is `Manual`.
	RuntimeVersionArn *string `pulumi:"runtimeVersionArn"`
	// Runtime update mode. Valid values are `Auto`, `FunctionUpdate`, and `Manual`. When a function is created, the default mode is `Auto`.
	UpdateRuntimeOn *string `pulumi:"updateRuntimeOn"`
}

// The set of arguments for constructing a RuntimeManagementConfig resource.
type RuntimeManagementConfigArgs struct {
	// Name or ARN of the Lambda function.
	//
	// The following arguments are optional:
	FunctionName pulumi.StringInput
	// Version of the function. This can be `$LATEST` or a published version number. If omitted, this resource will manage the runtime configuration for `$LATEST`.
	Qualifier pulumi.StringPtrInput
	// ARN of the runtime version. Only required when `updateRuntimeOn` is `Manual`.
	RuntimeVersionArn pulumi.StringPtrInput
	// Runtime update mode. Valid values are `Auto`, `FunctionUpdate`, and `Manual`. When a function is created, the default mode is `Auto`.
	UpdateRuntimeOn pulumi.StringPtrInput
}

func (RuntimeManagementConfigArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*runtimeManagementConfigArgs)(nil)).Elem()
}

type RuntimeManagementConfigInput interface {
	pulumi.Input

	ToRuntimeManagementConfigOutput() RuntimeManagementConfigOutput
	ToRuntimeManagementConfigOutputWithContext(ctx context.Context) RuntimeManagementConfigOutput
}

func (*RuntimeManagementConfig) ElementType() reflect.Type {
	return reflect.TypeOf((**RuntimeManagementConfig)(nil)).Elem()
}

func (i *RuntimeManagementConfig) ToRuntimeManagementConfigOutput() RuntimeManagementConfigOutput {
	return i.ToRuntimeManagementConfigOutputWithContext(context.Background())
}

func (i *RuntimeManagementConfig) ToRuntimeManagementConfigOutputWithContext(ctx context.Context) RuntimeManagementConfigOutput {
	return pulumi.ToOutputWithContext(ctx, i).(RuntimeManagementConfigOutput)
}

// RuntimeManagementConfigArrayInput is an input type that accepts RuntimeManagementConfigArray and RuntimeManagementConfigArrayOutput values.
// You can construct a concrete instance of `RuntimeManagementConfigArrayInput` via:
//
//	RuntimeManagementConfigArray{ RuntimeManagementConfigArgs{...} }
type RuntimeManagementConfigArrayInput interface {
	pulumi.Input

	ToRuntimeManagementConfigArrayOutput() RuntimeManagementConfigArrayOutput
	ToRuntimeManagementConfigArrayOutputWithContext(context.Context) RuntimeManagementConfigArrayOutput
}

type RuntimeManagementConfigArray []RuntimeManagementConfigInput

func (RuntimeManagementConfigArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*RuntimeManagementConfig)(nil)).Elem()
}

func (i RuntimeManagementConfigArray) ToRuntimeManagementConfigArrayOutput() RuntimeManagementConfigArrayOutput {
	return i.ToRuntimeManagementConfigArrayOutputWithContext(context.Background())
}

func (i RuntimeManagementConfigArray) ToRuntimeManagementConfigArrayOutputWithContext(ctx context.Context) RuntimeManagementConfigArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(RuntimeManagementConfigArrayOutput)
}

// RuntimeManagementConfigMapInput is an input type that accepts RuntimeManagementConfigMap and RuntimeManagementConfigMapOutput values.
// You can construct a concrete instance of `RuntimeManagementConfigMapInput` via:
//
//	RuntimeManagementConfigMap{ "key": RuntimeManagementConfigArgs{...} }
type RuntimeManagementConfigMapInput interface {
	pulumi.Input

	ToRuntimeManagementConfigMapOutput() RuntimeManagementConfigMapOutput
	ToRuntimeManagementConfigMapOutputWithContext(context.Context) RuntimeManagementConfigMapOutput
}

type RuntimeManagementConfigMap map[string]RuntimeManagementConfigInput

func (RuntimeManagementConfigMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*RuntimeManagementConfig)(nil)).Elem()
}

func (i RuntimeManagementConfigMap) ToRuntimeManagementConfigMapOutput() RuntimeManagementConfigMapOutput {
	return i.ToRuntimeManagementConfigMapOutputWithContext(context.Background())
}

func (i RuntimeManagementConfigMap) ToRuntimeManagementConfigMapOutputWithContext(ctx context.Context) RuntimeManagementConfigMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(RuntimeManagementConfigMapOutput)
}

type RuntimeManagementConfigOutput struct{ *pulumi.OutputState }

func (RuntimeManagementConfigOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**RuntimeManagementConfig)(nil)).Elem()
}

func (o RuntimeManagementConfigOutput) ToRuntimeManagementConfigOutput() RuntimeManagementConfigOutput {
	return o
}

func (o RuntimeManagementConfigOutput) ToRuntimeManagementConfigOutputWithContext(ctx context.Context) RuntimeManagementConfigOutput {
	return o
}

// ARN of the function.
func (o RuntimeManagementConfigOutput) FunctionArn() pulumi.StringOutput {
	return o.ApplyT(func(v *RuntimeManagementConfig) pulumi.StringOutput { return v.FunctionArn }).(pulumi.StringOutput)
}

// Name or ARN of the Lambda function.
//
// The following arguments are optional:
func (o RuntimeManagementConfigOutput) FunctionName() pulumi.StringOutput {
	return o.ApplyT(func(v *RuntimeManagementConfig) pulumi.StringOutput { return v.FunctionName }).(pulumi.StringOutput)
}

// Version of the function. This can be `$LATEST` or a published version number. If omitted, this resource will manage the runtime configuration for `$LATEST`.
func (o RuntimeManagementConfigOutput) Qualifier() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *RuntimeManagementConfig) pulumi.StringPtrOutput { return v.Qualifier }).(pulumi.StringPtrOutput)
}

// ARN of the runtime version. Only required when `updateRuntimeOn` is `Manual`.
func (o RuntimeManagementConfigOutput) RuntimeVersionArn() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *RuntimeManagementConfig) pulumi.StringPtrOutput { return v.RuntimeVersionArn }).(pulumi.StringPtrOutput)
}

// Runtime update mode. Valid values are `Auto`, `FunctionUpdate`, and `Manual`. When a function is created, the default mode is `Auto`.
func (o RuntimeManagementConfigOutput) UpdateRuntimeOn() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *RuntimeManagementConfig) pulumi.StringPtrOutput { return v.UpdateRuntimeOn }).(pulumi.StringPtrOutput)
}

type RuntimeManagementConfigArrayOutput struct{ *pulumi.OutputState }

func (RuntimeManagementConfigArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*RuntimeManagementConfig)(nil)).Elem()
}

func (o RuntimeManagementConfigArrayOutput) ToRuntimeManagementConfigArrayOutput() RuntimeManagementConfigArrayOutput {
	return o
}

func (o RuntimeManagementConfigArrayOutput) ToRuntimeManagementConfigArrayOutputWithContext(ctx context.Context) RuntimeManagementConfigArrayOutput {
	return o
}

func (o RuntimeManagementConfigArrayOutput) Index(i pulumi.IntInput) RuntimeManagementConfigOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *RuntimeManagementConfig {
		return vs[0].([]*RuntimeManagementConfig)[vs[1].(int)]
	}).(RuntimeManagementConfigOutput)
}

type RuntimeManagementConfigMapOutput struct{ *pulumi.OutputState }

func (RuntimeManagementConfigMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*RuntimeManagementConfig)(nil)).Elem()
}

func (o RuntimeManagementConfigMapOutput) ToRuntimeManagementConfigMapOutput() RuntimeManagementConfigMapOutput {
	return o
}

func (o RuntimeManagementConfigMapOutput) ToRuntimeManagementConfigMapOutputWithContext(ctx context.Context) RuntimeManagementConfigMapOutput {
	return o
}

func (o RuntimeManagementConfigMapOutput) MapIndex(k pulumi.StringInput) RuntimeManagementConfigOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *RuntimeManagementConfig {
		return vs[0].(map[string]*RuntimeManagementConfig)[vs[1].(string)]
	}).(RuntimeManagementConfigOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*RuntimeManagementConfigInput)(nil)).Elem(), &RuntimeManagementConfig{})
	pulumi.RegisterInputType(reflect.TypeOf((*RuntimeManagementConfigArrayInput)(nil)).Elem(), RuntimeManagementConfigArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*RuntimeManagementConfigMapInput)(nil)).Elem(), RuntimeManagementConfigMap{})
	pulumi.RegisterOutputType(RuntimeManagementConfigOutput{})
	pulumi.RegisterOutputType(RuntimeManagementConfigArrayOutput{})
	pulumi.RegisterOutputType(RuntimeManagementConfigMapOutput{})
}
