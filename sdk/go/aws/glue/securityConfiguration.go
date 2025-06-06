// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package glue

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Manages a Glue Security Configuration.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/glue"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := glue.NewSecurityConfiguration(ctx, "example", &glue.SecurityConfigurationArgs{
//				Name: pulumi.String("example"),
//				EncryptionConfiguration: &glue.SecurityConfigurationEncryptionConfigurationArgs{
//					CloudwatchEncryption: &glue.SecurityConfigurationEncryptionConfigurationCloudwatchEncryptionArgs{
//						CloudwatchEncryptionMode: pulumi.String("DISABLED"),
//					},
//					JobBookmarksEncryption: &glue.SecurityConfigurationEncryptionConfigurationJobBookmarksEncryptionArgs{
//						JobBookmarksEncryptionMode: pulumi.String("DISABLED"),
//					},
//					S3Encryption: &glue.SecurityConfigurationEncryptionConfigurationS3EncryptionArgs{
//						KmsKeyArn:        pulumi.Any(exampleAwsKmsKey.Arn),
//						S3EncryptionMode: pulumi.String("SSE-KMS"),
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
// Using `pulumi import`, import Glue Security Configurations using `name`. For example:
//
// ```sh
// $ pulumi import aws:glue/securityConfiguration:SecurityConfiguration example example
// ```
type SecurityConfiguration struct {
	pulumi.CustomResourceState

	// Configuration block containing encryption configuration. Detailed below.
	EncryptionConfiguration SecurityConfigurationEncryptionConfigurationOutput `pulumi:"encryptionConfiguration"`
	// Name of the security configuration.
	Name pulumi.StringOutput `pulumi:"name"`
}

// NewSecurityConfiguration registers a new resource with the given unique name, arguments, and options.
func NewSecurityConfiguration(ctx *pulumi.Context,
	name string, args *SecurityConfigurationArgs, opts ...pulumi.ResourceOption) (*SecurityConfiguration, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.EncryptionConfiguration == nil {
		return nil, errors.New("invalid value for required argument 'EncryptionConfiguration'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource SecurityConfiguration
	err := ctx.RegisterResource("aws:glue/securityConfiguration:SecurityConfiguration", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetSecurityConfiguration gets an existing SecurityConfiguration resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetSecurityConfiguration(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *SecurityConfigurationState, opts ...pulumi.ResourceOption) (*SecurityConfiguration, error) {
	var resource SecurityConfiguration
	err := ctx.ReadResource("aws:glue/securityConfiguration:SecurityConfiguration", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering SecurityConfiguration resources.
type securityConfigurationState struct {
	// Configuration block containing encryption configuration. Detailed below.
	EncryptionConfiguration *SecurityConfigurationEncryptionConfiguration `pulumi:"encryptionConfiguration"`
	// Name of the security configuration.
	Name *string `pulumi:"name"`
}

type SecurityConfigurationState struct {
	// Configuration block containing encryption configuration. Detailed below.
	EncryptionConfiguration SecurityConfigurationEncryptionConfigurationPtrInput
	// Name of the security configuration.
	Name pulumi.StringPtrInput
}

func (SecurityConfigurationState) ElementType() reflect.Type {
	return reflect.TypeOf((*securityConfigurationState)(nil)).Elem()
}

type securityConfigurationArgs struct {
	// Configuration block containing encryption configuration. Detailed below.
	EncryptionConfiguration SecurityConfigurationEncryptionConfiguration `pulumi:"encryptionConfiguration"`
	// Name of the security configuration.
	Name *string `pulumi:"name"`
}

// The set of arguments for constructing a SecurityConfiguration resource.
type SecurityConfigurationArgs struct {
	// Configuration block containing encryption configuration. Detailed below.
	EncryptionConfiguration SecurityConfigurationEncryptionConfigurationInput
	// Name of the security configuration.
	Name pulumi.StringPtrInput
}

func (SecurityConfigurationArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*securityConfigurationArgs)(nil)).Elem()
}

type SecurityConfigurationInput interface {
	pulumi.Input

	ToSecurityConfigurationOutput() SecurityConfigurationOutput
	ToSecurityConfigurationOutputWithContext(ctx context.Context) SecurityConfigurationOutput
}

func (*SecurityConfiguration) ElementType() reflect.Type {
	return reflect.TypeOf((**SecurityConfiguration)(nil)).Elem()
}

func (i *SecurityConfiguration) ToSecurityConfigurationOutput() SecurityConfigurationOutput {
	return i.ToSecurityConfigurationOutputWithContext(context.Background())
}

func (i *SecurityConfiguration) ToSecurityConfigurationOutputWithContext(ctx context.Context) SecurityConfigurationOutput {
	return pulumi.ToOutputWithContext(ctx, i).(SecurityConfigurationOutput)
}

// SecurityConfigurationArrayInput is an input type that accepts SecurityConfigurationArray and SecurityConfigurationArrayOutput values.
// You can construct a concrete instance of `SecurityConfigurationArrayInput` via:
//
//	SecurityConfigurationArray{ SecurityConfigurationArgs{...} }
type SecurityConfigurationArrayInput interface {
	pulumi.Input

	ToSecurityConfigurationArrayOutput() SecurityConfigurationArrayOutput
	ToSecurityConfigurationArrayOutputWithContext(context.Context) SecurityConfigurationArrayOutput
}

type SecurityConfigurationArray []SecurityConfigurationInput

func (SecurityConfigurationArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*SecurityConfiguration)(nil)).Elem()
}

func (i SecurityConfigurationArray) ToSecurityConfigurationArrayOutput() SecurityConfigurationArrayOutput {
	return i.ToSecurityConfigurationArrayOutputWithContext(context.Background())
}

func (i SecurityConfigurationArray) ToSecurityConfigurationArrayOutputWithContext(ctx context.Context) SecurityConfigurationArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(SecurityConfigurationArrayOutput)
}

// SecurityConfigurationMapInput is an input type that accepts SecurityConfigurationMap and SecurityConfigurationMapOutput values.
// You can construct a concrete instance of `SecurityConfigurationMapInput` via:
//
//	SecurityConfigurationMap{ "key": SecurityConfigurationArgs{...} }
type SecurityConfigurationMapInput interface {
	pulumi.Input

	ToSecurityConfigurationMapOutput() SecurityConfigurationMapOutput
	ToSecurityConfigurationMapOutputWithContext(context.Context) SecurityConfigurationMapOutput
}

type SecurityConfigurationMap map[string]SecurityConfigurationInput

func (SecurityConfigurationMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*SecurityConfiguration)(nil)).Elem()
}

func (i SecurityConfigurationMap) ToSecurityConfigurationMapOutput() SecurityConfigurationMapOutput {
	return i.ToSecurityConfigurationMapOutputWithContext(context.Background())
}

func (i SecurityConfigurationMap) ToSecurityConfigurationMapOutputWithContext(ctx context.Context) SecurityConfigurationMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(SecurityConfigurationMapOutput)
}

type SecurityConfigurationOutput struct{ *pulumi.OutputState }

func (SecurityConfigurationOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**SecurityConfiguration)(nil)).Elem()
}

func (o SecurityConfigurationOutput) ToSecurityConfigurationOutput() SecurityConfigurationOutput {
	return o
}

func (o SecurityConfigurationOutput) ToSecurityConfigurationOutputWithContext(ctx context.Context) SecurityConfigurationOutput {
	return o
}

// Configuration block containing encryption configuration. Detailed below.
func (o SecurityConfigurationOutput) EncryptionConfiguration() SecurityConfigurationEncryptionConfigurationOutput {
	return o.ApplyT(func(v *SecurityConfiguration) SecurityConfigurationEncryptionConfigurationOutput {
		return v.EncryptionConfiguration
	}).(SecurityConfigurationEncryptionConfigurationOutput)
}

// Name of the security configuration.
func (o SecurityConfigurationOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *SecurityConfiguration) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

type SecurityConfigurationArrayOutput struct{ *pulumi.OutputState }

func (SecurityConfigurationArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*SecurityConfiguration)(nil)).Elem()
}

func (o SecurityConfigurationArrayOutput) ToSecurityConfigurationArrayOutput() SecurityConfigurationArrayOutput {
	return o
}

func (o SecurityConfigurationArrayOutput) ToSecurityConfigurationArrayOutputWithContext(ctx context.Context) SecurityConfigurationArrayOutput {
	return o
}

func (o SecurityConfigurationArrayOutput) Index(i pulumi.IntInput) SecurityConfigurationOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *SecurityConfiguration {
		return vs[0].([]*SecurityConfiguration)[vs[1].(int)]
	}).(SecurityConfigurationOutput)
}

type SecurityConfigurationMapOutput struct{ *pulumi.OutputState }

func (SecurityConfigurationMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*SecurityConfiguration)(nil)).Elem()
}

func (o SecurityConfigurationMapOutput) ToSecurityConfigurationMapOutput() SecurityConfigurationMapOutput {
	return o
}

func (o SecurityConfigurationMapOutput) ToSecurityConfigurationMapOutputWithContext(ctx context.Context) SecurityConfigurationMapOutput {
	return o
}

func (o SecurityConfigurationMapOutput) MapIndex(k pulumi.StringInput) SecurityConfigurationOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *SecurityConfiguration {
		return vs[0].(map[string]*SecurityConfiguration)[vs[1].(string)]
	}).(SecurityConfigurationOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*SecurityConfigurationInput)(nil)).Elem(), &SecurityConfiguration{})
	pulumi.RegisterInputType(reflect.TypeOf((*SecurityConfigurationArrayInput)(nil)).Elem(), SecurityConfigurationArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*SecurityConfigurationMapInput)(nil)).Elem(), SecurityConfigurationMap{})
	pulumi.RegisterOutputType(SecurityConfigurationOutput{})
	pulumi.RegisterOutputType(SecurityConfigurationArrayOutput{})
	pulumi.RegisterOutputType(SecurityConfigurationMapOutput{})
}
