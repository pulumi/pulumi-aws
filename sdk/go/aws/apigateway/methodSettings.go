// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package apigateway

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Manages API Gateway Stage Method Settings. For example, CloudWatch logging and metrics.
//
// > **NOTE:** We recommend using this resource in conjunction with the `apigateway.Stage` resource instead of a stage managed by the `apigateway.Deployment` resource optional `stageName` argument. Stages managed by the `apigateway.Deployment` resource are recreated on redeployment and this resource will require a second apply to recreate the method settings.
//
// ## Example Usage
//
// ### End-to-end
//
// ### Off
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/apigateway"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := apigateway.NewMethodSettings(ctx, "path_specific", &apigateway.MethodSettingsArgs{
//				RestApi:    pulumi.Any(example.Id),
//				StageName:  pulumi.Any(exampleAwsApiGatewayStage.StageName),
//				MethodPath: pulumi.String("path1/GET"),
//				Settings: &apigateway.MethodSettingsSettingsArgs{
//					LoggingLevel: pulumi.String("OFF"),
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
// ### Errors Only
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/apigateway"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := apigateway.NewMethodSettings(ctx, "path_specific", &apigateway.MethodSettingsArgs{
//				RestApi:    pulumi.Any(example.Id),
//				StageName:  pulumi.Any(exampleAwsApiGatewayStage.StageName),
//				MethodPath: pulumi.String("path1/GET"),
//				Settings: &apigateway.MethodSettingsSettingsArgs{
//					LoggingLevel:     pulumi.String("ERROR"),
//					MetricsEnabled:   pulumi.Bool(true),
//					DataTraceEnabled: pulumi.Bool(false),
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
// ### Errors and Info Logs
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/apigateway"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := apigateway.NewMethodSettings(ctx, "path_specific", &apigateway.MethodSettingsArgs{
//				RestApi:    pulumi.Any(example.Id),
//				StageName:  pulumi.Any(exampleAwsApiGatewayStage.StageName),
//				MethodPath: pulumi.String("path1/GET"),
//				Settings: &apigateway.MethodSettingsSettingsArgs{
//					LoggingLevel:     pulumi.String("INFO"),
//					MetricsEnabled:   pulumi.Bool(true),
//					DataTraceEnabled: pulumi.Bool(false),
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
// ### Full Request and Response Logs
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/apigateway"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := apigateway.NewMethodSettings(ctx, "path_specific", &apigateway.MethodSettingsArgs{
//				RestApi:    pulumi.Any(example.Id),
//				StageName:  pulumi.Any(exampleAwsApiGatewayStage.StageName),
//				MethodPath: pulumi.String("path1/GET"),
//				Settings: &apigateway.MethodSettingsSettingsArgs{
//					LoggingLevel:     pulumi.String("INFO"),
//					MetricsEnabled:   pulumi.Bool(true),
//					DataTraceEnabled: pulumi.Bool(true),
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
// Using `pulumi import`, import `aws_api_gateway_method_settings` using `REST-API-ID/STAGE-NAME/METHOD-PATH`. For example:
//
// ```sh
// $ pulumi import aws:apigateway/methodSettings:MethodSettings example 12345abcde/example/test/GET
// ```
type MethodSettings struct {
	pulumi.CustomResourceState

	// Method path defined as `{resource_path}/{http_method}` for an individual method override, or `*/*` for overriding all methods in the stage. Ensure to trim any leading forward slashes in the path (e.g., `trimprefix(aws_api_gateway_resource.example.path, "/")`).
	MethodPath pulumi.StringOutput `pulumi:"methodPath"`
	// ID of the REST API
	RestApi pulumi.StringOutput `pulumi:"restApi"`
	// Settings block, see below.
	Settings MethodSettingsSettingsOutput `pulumi:"settings"`
	// Name of the stage
	StageName pulumi.StringOutput `pulumi:"stageName"`
}

// NewMethodSettings registers a new resource with the given unique name, arguments, and options.
func NewMethodSettings(ctx *pulumi.Context,
	name string, args *MethodSettingsArgs, opts ...pulumi.ResourceOption) (*MethodSettings, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.MethodPath == nil {
		return nil, errors.New("invalid value for required argument 'MethodPath'")
	}
	if args.RestApi == nil {
		return nil, errors.New("invalid value for required argument 'RestApi'")
	}
	if args.Settings == nil {
		return nil, errors.New("invalid value for required argument 'Settings'")
	}
	if args.StageName == nil {
		return nil, errors.New("invalid value for required argument 'StageName'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource MethodSettings
	err := ctx.RegisterResource("aws:apigateway/methodSettings:MethodSettings", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetMethodSettings gets an existing MethodSettings resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetMethodSettings(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *MethodSettingsState, opts ...pulumi.ResourceOption) (*MethodSettings, error) {
	var resource MethodSettings
	err := ctx.ReadResource("aws:apigateway/methodSettings:MethodSettings", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering MethodSettings resources.
type methodSettingsState struct {
	// Method path defined as `{resource_path}/{http_method}` for an individual method override, or `*/*` for overriding all methods in the stage. Ensure to trim any leading forward slashes in the path (e.g., `trimprefix(aws_api_gateway_resource.example.path, "/")`).
	MethodPath *string `pulumi:"methodPath"`
	// ID of the REST API
	RestApi interface{} `pulumi:"restApi"`
	// Settings block, see below.
	Settings *MethodSettingsSettings `pulumi:"settings"`
	// Name of the stage
	StageName *string `pulumi:"stageName"`
}

type MethodSettingsState struct {
	// Method path defined as `{resource_path}/{http_method}` for an individual method override, or `*/*` for overriding all methods in the stage. Ensure to trim any leading forward slashes in the path (e.g., `trimprefix(aws_api_gateway_resource.example.path, "/")`).
	MethodPath pulumi.StringPtrInput
	// ID of the REST API
	RestApi pulumi.Input
	// Settings block, see below.
	Settings MethodSettingsSettingsPtrInput
	// Name of the stage
	StageName pulumi.StringPtrInput
}

func (MethodSettingsState) ElementType() reflect.Type {
	return reflect.TypeOf((*methodSettingsState)(nil)).Elem()
}

type methodSettingsArgs struct {
	// Method path defined as `{resource_path}/{http_method}` for an individual method override, or `*/*` for overriding all methods in the stage. Ensure to trim any leading forward slashes in the path (e.g., `trimprefix(aws_api_gateway_resource.example.path, "/")`).
	MethodPath string `pulumi:"methodPath"`
	// ID of the REST API
	RestApi interface{} `pulumi:"restApi"`
	// Settings block, see below.
	Settings MethodSettingsSettings `pulumi:"settings"`
	// Name of the stage
	StageName string `pulumi:"stageName"`
}

// The set of arguments for constructing a MethodSettings resource.
type MethodSettingsArgs struct {
	// Method path defined as `{resource_path}/{http_method}` for an individual method override, or `*/*` for overriding all methods in the stage. Ensure to trim any leading forward slashes in the path (e.g., `trimprefix(aws_api_gateway_resource.example.path, "/")`).
	MethodPath pulumi.StringInput
	// ID of the REST API
	RestApi pulumi.Input
	// Settings block, see below.
	Settings MethodSettingsSettingsInput
	// Name of the stage
	StageName pulumi.StringInput
}

func (MethodSettingsArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*methodSettingsArgs)(nil)).Elem()
}

type MethodSettingsInput interface {
	pulumi.Input

	ToMethodSettingsOutput() MethodSettingsOutput
	ToMethodSettingsOutputWithContext(ctx context.Context) MethodSettingsOutput
}

func (*MethodSettings) ElementType() reflect.Type {
	return reflect.TypeOf((**MethodSettings)(nil)).Elem()
}

func (i *MethodSettings) ToMethodSettingsOutput() MethodSettingsOutput {
	return i.ToMethodSettingsOutputWithContext(context.Background())
}

func (i *MethodSettings) ToMethodSettingsOutputWithContext(ctx context.Context) MethodSettingsOutput {
	return pulumi.ToOutputWithContext(ctx, i).(MethodSettingsOutput)
}

// MethodSettingsArrayInput is an input type that accepts MethodSettingsArray and MethodSettingsArrayOutput values.
// You can construct a concrete instance of `MethodSettingsArrayInput` via:
//
//	MethodSettingsArray{ MethodSettingsArgs{...} }
type MethodSettingsArrayInput interface {
	pulumi.Input

	ToMethodSettingsArrayOutput() MethodSettingsArrayOutput
	ToMethodSettingsArrayOutputWithContext(context.Context) MethodSettingsArrayOutput
}

type MethodSettingsArray []MethodSettingsInput

func (MethodSettingsArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*MethodSettings)(nil)).Elem()
}

func (i MethodSettingsArray) ToMethodSettingsArrayOutput() MethodSettingsArrayOutput {
	return i.ToMethodSettingsArrayOutputWithContext(context.Background())
}

func (i MethodSettingsArray) ToMethodSettingsArrayOutputWithContext(ctx context.Context) MethodSettingsArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(MethodSettingsArrayOutput)
}

// MethodSettingsMapInput is an input type that accepts MethodSettingsMap and MethodSettingsMapOutput values.
// You can construct a concrete instance of `MethodSettingsMapInput` via:
//
//	MethodSettingsMap{ "key": MethodSettingsArgs{...} }
type MethodSettingsMapInput interface {
	pulumi.Input

	ToMethodSettingsMapOutput() MethodSettingsMapOutput
	ToMethodSettingsMapOutputWithContext(context.Context) MethodSettingsMapOutput
}

type MethodSettingsMap map[string]MethodSettingsInput

func (MethodSettingsMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*MethodSettings)(nil)).Elem()
}

func (i MethodSettingsMap) ToMethodSettingsMapOutput() MethodSettingsMapOutput {
	return i.ToMethodSettingsMapOutputWithContext(context.Background())
}

func (i MethodSettingsMap) ToMethodSettingsMapOutputWithContext(ctx context.Context) MethodSettingsMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(MethodSettingsMapOutput)
}

type MethodSettingsOutput struct{ *pulumi.OutputState }

func (MethodSettingsOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**MethodSettings)(nil)).Elem()
}

func (o MethodSettingsOutput) ToMethodSettingsOutput() MethodSettingsOutput {
	return o
}

func (o MethodSettingsOutput) ToMethodSettingsOutputWithContext(ctx context.Context) MethodSettingsOutput {
	return o
}

// Method path defined as `{resource_path}/{http_method}` for an individual method override, or `*/*` for overriding all methods in the stage. Ensure to trim any leading forward slashes in the path (e.g., `trimprefix(aws_api_gateway_resource.example.path, "/")`).
func (o MethodSettingsOutput) MethodPath() pulumi.StringOutput {
	return o.ApplyT(func(v *MethodSettings) pulumi.StringOutput { return v.MethodPath }).(pulumi.StringOutput)
}

// ID of the REST API
func (o MethodSettingsOutput) RestApi() pulumi.StringOutput {
	return o.ApplyT(func(v *MethodSettings) pulumi.StringOutput { return v.RestApi }).(pulumi.StringOutput)
}

// Settings block, see below.
func (o MethodSettingsOutput) Settings() MethodSettingsSettingsOutput {
	return o.ApplyT(func(v *MethodSettings) MethodSettingsSettingsOutput { return v.Settings }).(MethodSettingsSettingsOutput)
}

// Name of the stage
func (o MethodSettingsOutput) StageName() pulumi.StringOutput {
	return o.ApplyT(func(v *MethodSettings) pulumi.StringOutput { return v.StageName }).(pulumi.StringOutput)
}

type MethodSettingsArrayOutput struct{ *pulumi.OutputState }

func (MethodSettingsArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*MethodSettings)(nil)).Elem()
}

func (o MethodSettingsArrayOutput) ToMethodSettingsArrayOutput() MethodSettingsArrayOutput {
	return o
}

func (o MethodSettingsArrayOutput) ToMethodSettingsArrayOutputWithContext(ctx context.Context) MethodSettingsArrayOutput {
	return o
}

func (o MethodSettingsArrayOutput) Index(i pulumi.IntInput) MethodSettingsOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *MethodSettings {
		return vs[0].([]*MethodSettings)[vs[1].(int)]
	}).(MethodSettingsOutput)
}

type MethodSettingsMapOutput struct{ *pulumi.OutputState }

func (MethodSettingsMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*MethodSettings)(nil)).Elem()
}

func (o MethodSettingsMapOutput) ToMethodSettingsMapOutput() MethodSettingsMapOutput {
	return o
}

func (o MethodSettingsMapOutput) ToMethodSettingsMapOutputWithContext(ctx context.Context) MethodSettingsMapOutput {
	return o
}

func (o MethodSettingsMapOutput) MapIndex(k pulumi.StringInput) MethodSettingsOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *MethodSettings {
		return vs[0].(map[string]*MethodSettings)[vs[1].(string)]
	}).(MethodSettingsOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*MethodSettingsInput)(nil)).Elem(), &MethodSettings{})
	pulumi.RegisterInputType(reflect.TypeOf((*MethodSettingsArrayInput)(nil)).Elem(), MethodSettingsArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*MethodSettingsMapInput)(nil)).Elem(), MethodSettingsMap{})
	pulumi.RegisterOutputType(MethodSettingsOutput{})
	pulumi.RegisterOutputType(MethodSettingsArrayOutput{})
	pulumi.RegisterOutputType(MethodSettingsMapOutput{})
}
