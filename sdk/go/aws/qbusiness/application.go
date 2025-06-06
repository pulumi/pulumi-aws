// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package qbusiness

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a Q Business Application resource.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/qbusiness"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := qbusiness.NewApplication(ctx, "example", &qbusiness.ApplicationArgs{
//				DisplayName:               pulumi.String("example-app"),
//				IamServiceRoleArn:         pulumi.Any(exampleAwsIamRole.Arn),
//				IdentityCenterInstanceArn: pulumi.Any(exampleAwsSsoadminInstances.Arns[0]),
//				AttachmentsConfiguration: &qbusiness.ApplicationAttachmentsConfigurationArgs{
//					AttachmentsControlMode: pulumi.String("ENABLED"),
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
// Using `pulumi import`, import a Q Business Application using the `id`. For example:
//
// ```sh
// $ pulumi import aws:qbusiness/application:Application example id-12345678
// ```
type Application struct {
	pulumi.CustomResourceState

	// ARN of the Q Business application.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Information about whether file upload functionality is activated or deactivated for your end user. See `attachmentsConfiguration` below.
	AttachmentsConfiguration ApplicationAttachmentsConfigurationPtrOutput `pulumi:"attachmentsConfiguration"`
	// Description of the Amazon Q application.
	Description pulumi.StringPtrOutput `pulumi:"description"`
	// Name of the Amazon Q application.
	DisplayName pulumi.StringOutput `pulumi:"displayName"`
	// Information about encryption configuration. See `encryptionConfiguration` below.
	EncryptionConfiguration ApplicationEncryptionConfigurationPtrOutput `pulumi:"encryptionConfiguration"`
	// ARN of an IAM role with permissions to access your Amazon CloudWatch logs and metrics.
	IamServiceRoleArn pulumi.StringOutput `pulumi:"iamServiceRoleArn"`
	// ARN of the AWS IAM Identity Center application attached to your Amazon Q Business application.
	IdentityCenterApplicationArn pulumi.StringOutput `pulumi:"identityCenterApplicationArn"`
	// ARN of the IAM Identity Center instance you are either creating for — or connecting to — your Amazon Q Business application.
	//
	// The following arguments are optional:
	IdentityCenterInstanceArn pulumi.StringOutput    `pulumi:"identityCenterInstanceArn"`
	Tags                      pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll  pulumi.StringMapOutput       `pulumi:"tagsAll"`
	Timeouts ApplicationTimeoutsPtrOutput `pulumi:"timeouts"`
}

// NewApplication registers a new resource with the given unique name, arguments, and options.
func NewApplication(ctx *pulumi.Context,
	name string, args *ApplicationArgs, opts ...pulumi.ResourceOption) (*Application, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.DisplayName == nil {
		return nil, errors.New("invalid value for required argument 'DisplayName'")
	}
	if args.IamServiceRoleArn == nil {
		return nil, errors.New("invalid value for required argument 'IamServiceRoleArn'")
	}
	if args.IdentityCenterInstanceArn == nil {
		return nil, errors.New("invalid value for required argument 'IdentityCenterInstanceArn'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource Application
	err := ctx.RegisterResource("aws:qbusiness/application:Application", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetApplication gets an existing Application resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetApplication(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ApplicationState, opts ...pulumi.ResourceOption) (*Application, error) {
	var resource Application
	err := ctx.ReadResource("aws:qbusiness/application:Application", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Application resources.
type applicationState struct {
	// ARN of the Q Business application.
	Arn *string `pulumi:"arn"`
	// Information about whether file upload functionality is activated or deactivated for your end user. See `attachmentsConfiguration` below.
	AttachmentsConfiguration *ApplicationAttachmentsConfiguration `pulumi:"attachmentsConfiguration"`
	// Description of the Amazon Q application.
	Description *string `pulumi:"description"`
	// Name of the Amazon Q application.
	DisplayName *string `pulumi:"displayName"`
	// Information about encryption configuration. See `encryptionConfiguration` below.
	EncryptionConfiguration *ApplicationEncryptionConfiguration `pulumi:"encryptionConfiguration"`
	// ARN of an IAM role with permissions to access your Amazon CloudWatch logs and metrics.
	IamServiceRoleArn *string `pulumi:"iamServiceRoleArn"`
	// ARN of the AWS IAM Identity Center application attached to your Amazon Q Business application.
	IdentityCenterApplicationArn *string `pulumi:"identityCenterApplicationArn"`
	// ARN of the IAM Identity Center instance you are either creating for — or connecting to — your Amazon Q Business application.
	//
	// The following arguments are optional:
	IdentityCenterInstanceArn *string           `pulumi:"identityCenterInstanceArn"`
	Tags                      map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll  map[string]string    `pulumi:"tagsAll"`
	Timeouts *ApplicationTimeouts `pulumi:"timeouts"`
}

type ApplicationState struct {
	// ARN of the Q Business application.
	Arn pulumi.StringPtrInput
	// Information about whether file upload functionality is activated or deactivated for your end user. See `attachmentsConfiguration` below.
	AttachmentsConfiguration ApplicationAttachmentsConfigurationPtrInput
	// Description of the Amazon Q application.
	Description pulumi.StringPtrInput
	// Name of the Amazon Q application.
	DisplayName pulumi.StringPtrInput
	// Information about encryption configuration. See `encryptionConfiguration` below.
	EncryptionConfiguration ApplicationEncryptionConfigurationPtrInput
	// ARN of an IAM role with permissions to access your Amazon CloudWatch logs and metrics.
	IamServiceRoleArn pulumi.StringPtrInput
	// ARN of the AWS IAM Identity Center application attached to your Amazon Q Business application.
	IdentityCenterApplicationArn pulumi.StringPtrInput
	// ARN of the IAM Identity Center instance you are either creating for — or connecting to — your Amazon Q Business application.
	//
	// The following arguments are optional:
	IdentityCenterInstanceArn pulumi.StringPtrInput
	Tags                      pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll  pulumi.StringMapInput
	Timeouts ApplicationTimeoutsPtrInput
}

func (ApplicationState) ElementType() reflect.Type {
	return reflect.TypeOf((*applicationState)(nil)).Elem()
}

type applicationArgs struct {
	// Information about whether file upload functionality is activated or deactivated for your end user. See `attachmentsConfiguration` below.
	AttachmentsConfiguration *ApplicationAttachmentsConfiguration `pulumi:"attachmentsConfiguration"`
	// Description of the Amazon Q application.
	Description *string `pulumi:"description"`
	// Name of the Amazon Q application.
	DisplayName string `pulumi:"displayName"`
	// Information about encryption configuration. See `encryptionConfiguration` below.
	EncryptionConfiguration *ApplicationEncryptionConfiguration `pulumi:"encryptionConfiguration"`
	// ARN of an IAM role with permissions to access your Amazon CloudWatch logs and metrics.
	IamServiceRoleArn string `pulumi:"iamServiceRoleArn"`
	// ARN of the IAM Identity Center instance you are either creating for — or connecting to — your Amazon Q Business application.
	//
	// The following arguments are optional:
	IdentityCenterInstanceArn string               `pulumi:"identityCenterInstanceArn"`
	Tags                      map[string]string    `pulumi:"tags"`
	Timeouts                  *ApplicationTimeouts `pulumi:"timeouts"`
}

// The set of arguments for constructing a Application resource.
type ApplicationArgs struct {
	// Information about whether file upload functionality is activated or deactivated for your end user. See `attachmentsConfiguration` below.
	AttachmentsConfiguration ApplicationAttachmentsConfigurationPtrInput
	// Description of the Amazon Q application.
	Description pulumi.StringPtrInput
	// Name of the Amazon Q application.
	DisplayName pulumi.StringInput
	// Information about encryption configuration. See `encryptionConfiguration` below.
	EncryptionConfiguration ApplicationEncryptionConfigurationPtrInput
	// ARN of an IAM role with permissions to access your Amazon CloudWatch logs and metrics.
	IamServiceRoleArn pulumi.StringInput
	// ARN of the IAM Identity Center instance you are either creating for — or connecting to — your Amazon Q Business application.
	//
	// The following arguments are optional:
	IdentityCenterInstanceArn pulumi.StringInput
	Tags                      pulumi.StringMapInput
	Timeouts                  ApplicationTimeoutsPtrInput
}

func (ApplicationArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*applicationArgs)(nil)).Elem()
}

type ApplicationInput interface {
	pulumi.Input

	ToApplicationOutput() ApplicationOutput
	ToApplicationOutputWithContext(ctx context.Context) ApplicationOutput
}

func (*Application) ElementType() reflect.Type {
	return reflect.TypeOf((**Application)(nil)).Elem()
}

func (i *Application) ToApplicationOutput() ApplicationOutput {
	return i.ToApplicationOutputWithContext(context.Background())
}

func (i *Application) ToApplicationOutputWithContext(ctx context.Context) ApplicationOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ApplicationOutput)
}

// ApplicationArrayInput is an input type that accepts ApplicationArray and ApplicationArrayOutput values.
// You can construct a concrete instance of `ApplicationArrayInput` via:
//
//	ApplicationArray{ ApplicationArgs{...} }
type ApplicationArrayInput interface {
	pulumi.Input

	ToApplicationArrayOutput() ApplicationArrayOutput
	ToApplicationArrayOutputWithContext(context.Context) ApplicationArrayOutput
}

type ApplicationArray []ApplicationInput

func (ApplicationArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Application)(nil)).Elem()
}

func (i ApplicationArray) ToApplicationArrayOutput() ApplicationArrayOutput {
	return i.ToApplicationArrayOutputWithContext(context.Background())
}

func (i ApplicationArray) ToApplicationArrayOutputWithContext(ctx context.Context) ApplicationArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ApplicationArrayOutput)
}

// ApplicationMapInput is an input type that accepts ApplicationMap and ApplicationMapOutput values.
// You can construct a concrete instance of `ApplicationMapInput` via:
//
//	ApplicationMap{ "key": ApplicationArgs{...} }
type ApplicationMapInput interface {
	pulumi.Input

	ToApplicationMapOutput() ApplicationMapOutput
	ToApplicationMapOutputWithContext(context.Context) ApplicationMapOutput
}

type ApplicationMap map[string]ApplicationInput

func (ApplicationMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Application)(nil)).Elem()
}

func (i ApplicationMap) ToApplicationMapOutput() ApplicationMapOutput {
	return i.ToApplicationMapOutputWithContext(context.Background())
}

func (i ApplicationMap) ToApplicationMapOutputWithContext(ctx context.Context) ApplicationMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ApplicationMapOutput)
}

type ApplicationOutput struct{ *pulumi.OutputState }

func (ApplicationOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**Application)(nil)).Elem()
}

func (o ApplicationOutput) ToApplicationOutput() ApplicationOutput {
	return o
}

func (o ApplicationOutput) ToApplicationOutputWithContext(ctx context.Context) ApplicationOutput {
	return o
}

// ARN of the Q Business application.
func (o ApplicationOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *Application) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Information about whether file upload functionality is activated or deactivated for your end user. See `attachmentsConfiguration` below.
func (o ApplicationOutput) AttachmentsConfiguration() ApplicationAttachmentsConfigurationPtrOutput {
	return o.ApplyT(func(v *Application) ApplicationAttachmentsConfigurationPtrOutput { return v.AttachmentsConfiguration }).(ApplicationAttachmentsConfigurationPtrOutput)
}

// Description of the Amazon Q application.
func (o ApplicationOutput) Description() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *Application) pulumi.StringPtrOutput { return v.Description }).(pulumi.StringPtrOutput)
}

// Name of the Amazon Q application.
func (o ApplicationOutput) DisplayName() pulumi.StringOutput {
	return o.ApplyT(func(v *Application) pulumi.StringOutput { return v.DisplayName }).(pulumi.StringOutput)
}

// Information about encryption configuration. See `encryptionConfiguration` below.
func (o ApplicationOutput) EncryptionConfiguration() ApplicationEncryptionConfigurationPtrOutput {
	return o.ApplyT(func(v *Application) ApplicationEncryptionConfigurationPtrOutput { return v.EncryptionConfiguration }).(ApplicationEncryptionConfigurationPtrOutput)
}

// ARN of an IAM role with permissions to access your Amazon CloudWatch logs and metrics.
func (o ApplicationOutput) IamServiceRoleArn() pulumi.StringOutput {
	return o.ApplyT(func(v *Application) pulumi.StringOutput { return v.IamServiceRoleArn }).(pulumi.StringOutput)
}

// ARN of the AWS IAM Identity Center application attached to your Amazon Q Business application.
func (o ApplicationOutput) IdentityCenterApplicationArn() pulumi.StringOutput {
	return o.ApplyT(func(v *Application) pulumi.StringOutput { return v.IdentityCenterApplicationArn }).(pulumi.StringOutput)
}

// ARN of the IAM Identity Center instance you are either creating for — or connecting to — your Amazon Q Business application.
//
// The following arguments are optional:
func (o ApplicationOutput) IdentityCenterInstanceArn() pulumi.StringOutput {
	return o.ApplyT(func(v *Application) pulumi.StringOutput { return v.IdentityCenterInstanceArn }).(pulumi.StringOutput)
}

func (o ApplicationOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Application) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o ApplicationOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Application) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

func (o ApplicationOutput) Timeouts() ApplicationTimeoutsPtrOutput {
	return o.ApplyT(func(v *Application) ApplicationTimeoutsPtrOutput { return v.Timeouts }).(ApplicationTimeoutsPtrOutput)
}

type ApplicationArrayOutput struct{ *pulumi.OutputState }

func (ApplicationArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Application)(nil)).Elem()
}

func (o ApplicationArrayOutput) ToApplicationArrayOutput() ApplicationArrayOutput {
	return o
}

func (o ApplicationArrayOutput) ToApplicationArrayOutputWithContext(ctx context.Context) ApplicationArrayOutput {
	return o
}

func (o ApplicationArrayOutput) Index(i pulumi.IntInput) ApplicationOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *Application {
		return vs[0].([]*Application)[vs[1].(int)]
	}).(ApplicationOutput)
}

type ApplicationMapOutput struct{ *pulumi.OutputState }

func (ApplicationMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Application)(nil)).Elem()
}

func (o ApplicationMapOutput) ToApplicationMapOutput() ApplicationMapOutput {
	return o
}

func (o ApplicationMapOutput) ToApplicationMapOutputWithContext(ctx context.Context) ApplicationMapOutput {
	return o
}

func (o ApplicationMapOutput) MapIndex(k pulumi.StringInput) ApplicationOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *Application {
		return vs[0].(map[string]*Application)[vs[1].(string)]
	}).(ApplicationOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ApplicationInput)(nil)).Elem(), &Application{})
	pulumi.RegisterInputType(reflect.TypeOf((*ApplicationArrayInput)(nil)).Elem(), ApplicationArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ApplicationMapInput)(nil)).Elem(), ApplicationMap{})
	pulumi.RegisterOutputType(ApplicationOutput{})
	pulumi.RegisterOutputType(ApplicationArrayOutput{})
	pulumi.RegisterOutputType(ApplicationMapOutput{})
}
