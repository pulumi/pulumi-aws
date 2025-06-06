// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package bedrock

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS Bedrock Guardrail Version.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/bedrock"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := bedrock.NewGuardrailVersion(ctx, "example", &bedrock.GuardrailVersionArgs{
//				Description:  pulumi.String("example"),
//				GuardrailArn: pulumi.Any(test.GuardrailArn),
//				SkipDestroy:  pulumi.Bool(true),
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
// Using `pulumi import`, import Amazon Bedrock Guardrail Version using using a comma-delimited string of `guardrail_arn` and `version`. For example:
//
// ```sh
// $ pulumi import aws:bedrock/guardrailVersion:GuardrailVersion example arn:aws:bedrock:us-west-2:123456789012:guardrail-id-12345678,1
// ```
type GuardrailVersion struct {
	pulumi.CustomResourceState

	// Description of the Guardrail version.
	Description pulumi.StringPtrOutput `pulumi:"description"`
	// Guardrail ARN.
	//
	// The following arguments are optional:
	GuardrailArn pulumi.StringOutput `pulumi:"guardrailArn"`
	// Whether to retain the old version of a previously deployed Guardrail. Default is `false`
	SkipDestroy pulumi.BoolPtrOutput              `pulumi:"skipDestroy"`
	Timeouts    GuardrailVersionTimeoutsPtrOutput `pulumi:"timeouts"`
	// Guardrail version.
	Version pulumi.StringOutput `pulumi:"version"`
}

// NewGuardrailVersion registers a new resource with the given unique name, arguments, and options.
func NewGuardrailVersion(ctx *pulumi.Context,
	name string, args *GuardrailVersionArgs, opts ...pulumi.ResourceOption) (*GuardrailVersion, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.GuardrailArn == nil {
		return nil, errors.New("invalid value for required argument 'GuardrailArn'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource GuardrailVersion
	err := ctx.RegisterResource("aws:bedrock/guardrailVersion:GuardrailVersion", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetGuardrailVersion gets an existing GuardrailVersion resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetGuardrailVersion(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *GuardrailVersionState, opts ...pulumi.ResourceOption) (*GuardrailVersion, error) {
	var resource GuardrailVersion
	err := ctx.ReadResource("aws:bedrock/guardrailVersion:GuardrailVersion", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering GuardrailVersion resources.
type guardrailVersionState struct {
	// Description of the Guardrail version.
	Description *string `pulumi:"description"`
	// Guardrail ARN.
	//
	// The following arguments are optional:
	GuardrailArn *string `pulumi:"guardrailArn"`
	// Whether to retain the old version of a previously deployed Guardrail. Default is `false`
	SkipDestroy *bool                     `pulumi:"skipDestroy"`
	Timeouts    *GuardrailVersionTimeouts `pulumi:"timeouts"`
	// Guardrail version.
	Version *string `pulumi:"version"`
}

type GuardrailVersionState struct {
	// Description of the Guardrail version.
	Description pulumi.StringPtrInput
	// Guardrail ARN.
	//
	// The following arguments are optional:
	GuardrailArn pulumi.StringPtrInput
	// Whether to retain the old version of a previously deployed Guardrail. Default is `false`
	SkipDestroy pulumi.BoolPtrInput
	Timeouts    GuardrailVersionTimeoutsPtrInput
	// Guardrail version.
	Version pulumi.StringPtrInput
}

func (GuardrailVersionState) ElementType() reflect.Type {
	return reflect.TypeOf((*guardrailVersionState)(nil)).Elem()
}

type guardrailVersionArgs struct {
	// Description of the Guardrail version.
	Description *string `pulumi:"description"`
	// Guardrail ARN.
	//
	// The following arguments are optional:
	GuardrailArn string `pulumi:"guardrailArn"`
	// Whether to retain the old version of a previously deployed Guardrail. Default is `false`
	SkipDestroy *bool                     `pulumi:"skipDestroy"`
	Timeouts    *GuardrailVersionTimeouts `pulumi:"timeouts"`
}

// The set of arguments for constructing a GuardrailVersion resource.
type GuardrailVersionArgs struct {
	// Description of the Guardrail version.
	Description pulumi.StringPtrInput
	// Guardrail ARN.
	//
	// The following arguments are optional:
	GuardrailArn pulumi.StringInput
	// Whether to retain the old version of a previously deployed Guardrail. Default is `false`
	SkipDestroy pulumi.BoolPtrInput
	Timeouts    GuardrailVersionTimeoutsPtrInput
}

func (GuardrailVersionArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*guardrailVersionArgs)(nil)).Elem()
}

type GuardrailVersionInput interface {
	pulumi.Input

	ToGuardrailVersionOutput() GuardrailVersionOutput
	ToGuardrailVersionOutputWithContext(ctx context.Context) GuardrailVersionOutput
}

func (*GuardrailVersion) ElementType() reflect.Type {
	return reflect.TypeOf((**GuardrailVersion)(nil)).Elem()
}

func (i *GuardrailVersion) ToGuardrailVersionOutput() GuardrailVersionOutput {
	return i.ToGuardrailVersionOutputWithContext(context.Background())
}

func (i *GuardrailVersion) ToGuardrailVersionOutputWithContext(ctx context.Context) GuardrailVersionOutput {
	return pulumi.ToOutputWithContext(ctx, i).(GuardrailVersionOutput)
}

// GuardrailVersionArrayInput is an input type that accepts GuardrailVersionArray and GuardrailVersionArrayOutput values.
// You can construct a concrete instance of `GuardrailVersionArrayInput` via:
//
//	GuardrailVersionArray{ GuardrailVersionArgs{...} }
type GuardrailVersionArrayInput interface {
	pulumi.Input

	ToGuardrailVersionArrayOutput() GuardrailVersionArrayOutput
	ToGuardrailVersionArrayOutputWithContext(context.Context) GuardrailVersionArrayOutput
}

type GuardrailVersionArray []GuardrailVersionInput

func (GuardrailVersionArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*GuardrailVersion)(nil)).Elem()
}

func (i GuardrailVersionArray) ToGuardrailVersionArrayOutput() GuardrailVersionArrayOutput {
	return i.ToGuardrailVersionArrayOutputWithContext(context.Background())
}

func (i GuardrailVersionArray) ToGuardrailVersionArrayOutputWithContext(ctx context.Context) GuardrailVersionArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(GuardrailVersionArrayOutput)
}

// GuardrailVersionMapInput is an input type that accepts GuardrailVersionMap and GuardrailVersionMapOutput values.
// You can construct a concrete instance of `GuardrailVersionMapInput` via:
//
//	GuardrailVersionMap{ "key": GuardrailVersionArgs{...} }
type GuardrailVersionMapInput interface {
	pulumi.Input

	ToGuardrailVersionMapOutput() GuardrailVersionMapOutput
	ToGuardrailVersionMapOutputWithContext(context.Context) GuardrailVersionMapOutput
}

type GuardrailVersionMap map[string]GuardrailVersionInput

func (GuardrailVersionMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*GuardrailVersion)(nil)).Elem()
}

func (i GuardrailVersionMap) ToGuardrailVersionMapOutput() GuardrailVersionMapOutput {
	return i.ToGuardrailVersionMapOutputWithContext(context.Background())
}

func (i GuardrailVersionMap) ToGuardrailVersionMapOutputWithContext(ctx context.Context) GuardrailVersionMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(GuardrailVersionMapOutput)
}

type GuardrailVersionOutput struct{ *pulumi.OutputState }

func (GuardrailVersionOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**GuardrailVersion)(nil)).Elem()
}

func (o GuardrailVersionOutput) ToGuardrailVersionOutput() GuardrailVersionOutput {
	return o
}

func (o GuardrailVersionOutput) ToGuardrailVersionOutputWithContext(ctx context.Context) GuardrailVersionOutput {
	return o
}

// Description of the Guardrail version.
func (o GuardrailVersionOutput) Description() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *GuardrailVersion) pulumi.StringPtrOutput { return v.Description }).(pulumi.StringPtrOutput)
}

// Guardrail ARN.
//
// The following arguments are optional:
func (o GuardrailVersionOutput) GuardrailArn() pulumi.StringOutput {
	return o.ApplyT(func(v *GuardrailVersion) pulumi.StringOutput { return v.GuardrailArn }).(pulumi.StringOutput)
}

// Whether to retain the old version of a previously deployed Guardrail. Default is `false`
func (o GuardrailVersionOutput) SkipDestroy() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v *GuardrailVersion) pulumi.BoolPtrOutput { return v.SkipDestroy }).(pulumi.BoolPtrOutput)
}

func (o GuardrailVersionOutput) Timeouts() GuardrailVersionTimeoutsPtrOutput {
	return o.ApplyT(func(v *GuardrailVersion) GuardrailVersionTimeoutsPtrOutput { return v.Timeouts }).(GuardrailVersionTimeoutsPtrOutput)
}

// Guardrail version.
func (o GuardrailVersionOutput) Version() pulumi.StringOutput {
	return o.ApplyT(func(v *GuardrailVersion) pulumi.StringOutput { return v.Version }).(pulumi.StringOutput)
}

type GuardrailVersionArrayOutput struct{ *pulumi.OutputState }

func (GuardrailVersionArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*GuardrailVersion)(nil)).Elem()
}

func (o GuardrailVersionArrayOutput) ToGuardrailVersionArrayOutput() GuardrailVersionArrayOutput {
	return o
}

func (o GuardrailVersionArrayOutput) ToGuardrailVersionArrayOutputWithContext(ctx context.Context) GuardrailVersionArrayOutput {
	return o
}

func (o GuardrailVersionArrayOutput) Index(i pulumi.IntInput) GuardrailVersionOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *GuardrailVersion {
		return vs[0].([]*GuardrailVersion)[vs[1].(int)]
	}).(GuardrailVersionOutput)
}

type GuardrailVersionMapOutput struct{ *pulumi.OutputState }

func (GuardrailVersionMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*GuardrailVersion)(nil)).Elem()
}

func (o GuardrailVersionMapOutput) ToGuardrailVersionMapOutput() GuardrailVersionMapOutput {
	return o
}

func (o GuardrailVersionMapOutput) ToGuardrailVersionMapOutputWithContext(ctx context.Context) GuardrailVersionMapOutput {
	return o
}

func (o GuardrailVersionMapOutput) MapIndex(k pulumi.StringInput) GuardrailVersionOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *GuardrailVersion {
		return vs[0].(map[string]*GuardrailVersion)[vs[1].(string)]
	}).(GuardrailVersionOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*GuardrailVersionInput)(nil)).Elem(), &GuardrailVersion{})
	pulumi.RegisterInputType(reflect.TypeOf((*GuardrailVersionArrayInput)(nil)).Elem(), GuardrailVersionArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*GuardrailVersionMapInput)(nil)).Elem(), GuardrailVersionMap{})
	pulumi.RegisterOutputType(GuardrailVersionOutput{})
	pulumi.RegisterOutputType(GuardrailVersionArrayOutput{})
	pulumi.RegisterOutputType(GuardrailVersionMapOutput{})
}
