// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package pinpoint

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a Pinpoint APNs Channel resource.
//
// > **Note:** All arguments, including certificates and tokens, will be stored in the raw state as plain-text.
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/pinpoint"
//	"github.com/pulumi/pulumi-std/sdk/go/std"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			app, err := pinpoint.NewApp(ctx, "app", nil)
//			if err != nil {
//				return err
//			}
//			invokeFile, err := std.File(ctx, &std.FileArgs{
//				Input: "./certificate.pem",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			invokeFile1, err := std.File(ctx, &std.FileArgs{
//				Input: "./private_key.key",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			_, err = pinpoint.NewApnsChannel(ctx, "apns", &pinpoint.ApnsChannelArgs{
//				ApplicationId: app.ApplicationId,
//				Certificate:   pulumi.String(invokeFile.Result),
//				PrivateKey:    pulumi.String(invokeFile1.Result),
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
// Using `pulumi import`, import Pinpoint APNs Channel using the `application-id`. For example:
//
// ```sh
// $ pulumi import aws:pinpoint/apnsChannel:ApnsChannel apns application-id
// ```
type ApnsChannel struct {
	pulumi.CustomResourceState

	// The application ID.
	ApplicationId pulumi.StringOutput `pulumi:"applicationId"`
	// The ID assigned to your iOS app. To find this value, choose Certificates, IDs & Profiles, choose App IDs in the Identifiers section, and choose your app.
	BundleId pulumi.StringPtrOutput `pulumi:"bundleId"`
	// The pem encoded TLS Certificate from Apple.
	Certificate pulumi.StringPtrOutput `pulumi:"certificate"`
	// The default authentication method used for APNs.
	// __NOTE__: Amazon Pinpoint uses this default for every APNs push notification that you send using the console.
	// You can override the default when you send a message programmatically using the Amazon Pinpoint API, the AWS CLI, or an AWS SDK.
	// If your default authentication type fails, Amazon Pinpoint doesn't attempt to use the other authentication type.
	//
	// One of the following sets of credentials is also required.
	//
	// If you choose to use __Certificate credentials__ you will have to provide:
	DefaultAuthenticationMethod pulumi.StringPtrOutput `pulumi:"defaultAuthenticationMethod"`
	// Whether the channel is enabled or disabled. Defaults to `true`.
	Enabled pulumi.BoolPtrOutput `pulumi:"enabled"`
	// The Certificate Private Key file (ie. `.key` file).
	//
	// If you choose to use __Key credentials__ you will have to provide:
	PrivateKey pulumi.StringPtrOutput `pulumi:"privateKey"`
	// The ID assigned to your Apple developer account team. This value is provided on the Membership page.
	TeamId pulumi.StringPtrOutput `pulumi:"teamId"`
	// The `.p8` file that you download from your Apple developer account when you create an authentication key.
	TokenKey pulumi.StringPtrOutput `pulumi:"tokenKey"`
	// The ID assigned to your signing key. To find this value, choose Certificates, IDs & Profiles, and choose your key in the Keys section.
	TokenKeyId pulumi.StringPtrOutput `pulumi:"tokenKeyId"`
}

// NewApnsChannel registers a new resource with the given unique name, arguments, and options.
func NewApnsChannel(ctx *pulumi.Context,
	name string, args *ApnsChannelArgs, opts ...pulumi.ResourceOption) (*ApnsChannel, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.ApplicationId == nil {
		return nil, errors.New("invalid value for required argument 'ApplicationId'")
	}
	if args.BundleId != nil {
		args.BundleId = pulumi.ToSecret(args.BundleId).(pulumi.StringPtrInput)
	}
	if args.Certificate != nil {
		args.Certificate = pulumi.ToSecret(args.Certificate).(pulumi.StringPtrInput)
	}
	if args.PrivateKey != nil {
		args.PrivateKey = pulumi.ToSecret(args.PrivateKey).(pulumi.StringPtrInput)
	}
	if args.TeamId != nil {
		args.TeamId = pulumi.ToSecret(args.TeamId).(pulumi.StringPtrInput)
	}
	if args.TokenKey != nil {
		args.TokenKey = pulumi.ToSecret(args.TokenKey).(pulumi.StringPtrInput)
	}
	if args.TokenKeyId != nil {
		args.TokenKeyId = pulumi.ToSecret(args.TokenKeyId).(pulumi.StringPtrInput)
	}
	secrets := pulumi.AdditionalSecretOutputs([]string{
		"bundleId",
		"certificate",
		"privateKey",
		"teamId",
		"tokenKey",
		"tokenKeyId",
	})
	opts = append(opts, secrets)
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource ApnsChannel
	err := ctx.RegisterResource("aws:pinpoint/apnsChannel:ApnsChannel", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetApnsChannel gets an existing ApnsChannel resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetApnsChannel(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ApnsChannelState, opts ...pulumi.ResourceOption) (*ApnsChannel, error) {
	var resource ApnsChannel
	err := ctx.ReadResource("aws:pinpoint/apnsChannel:ApnsChannel", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering ApnsChannel resources.
type apnsChannelState struct {
	// The application ID.
	ApplicationId *string `pulumi:"applicationId"`
	// The ID assigned to your iOS app. To find this value, choose Certificates, IDs & Profiles, choose App IDs in the Identifiers section, and choose your app.
	BundleId *string `pulumi:"bundleId"`
	// The pem encoded TLS Certificate from Apple.
	Certificate *string `pulumi:"certificate"`
	// The default authentication method used for APNs.
	// __NOTE__: Amazon Pinpoint uses this default for every APNs push notification that you send using the console.
	// You can override the default when you send a message programmatically using the Amazon Pinpoint API, the AWS CLI, or an AWS SDK.
	// If your default authentication type fails, Amazon Pinpoint doesn't attempt to use the other authentication type.
	//
	// One of the following sets of credentials is also required.
	//
	// If you choose to use __Certificate credentials__ you will have to provide:
	DefaultAuthenticationMethod *string `pulumi:"defaultAuthenticationMethod"`
	// Whether the channel is enabled or disabled. Defaults to `true`.
	Enabled *bool `pulumi:"enabled"`
	// The Certificate Private Key file (ie. `.key` file).
	//
	// If you choose to use __Key credentials__ you will have to provide:
	PrivateKey *string `pulumi:"privateKey"`
	// The ID assigned to your Apple developer account team. This value is provided on the Membership page.
	TeamId *string `pulumi:"teamId"`
	// The `.p8` file that you download from your Apple developer account when you create an authentication key.
	TokenKey *string `pulumi:"tokenKey"`
	// The ID assigned to your signing key. To find this value, choose Certificates, IDs & Profiles, and choose your key in the Keys section.
	TokenKeyId *string `pulumi:"tokenKeyId"`
}

type ApnsChannelState struct {
	// The application ID.
	ApplicationId pulumi.StringPtrInput
	// The ID assigned to your iOS app. To find this value, choose Certificates, IDs & Profiles, choose App IDs in the Identifiers section, and choose your app.
	BundleId pulumi.StringPtrInput
	// The pem encoded TLS Certificate from Apple.
	Certificate pulumi.StringPtrInput
	// The default authentication method used for APNs.
	// __NOTE__: Amazon Pinpoint uses this default for every APNs push notification that you send using the console.
	// You can override the default when you send a message programmatically using the Amazon Pinpoint API, the AWS CLI, or an AWS SDK.
	// If your default authentication type fails, Amazon Pinpoint doesn't attempt to use the other authentication type.
	//
	// One of the following sets of credentials is also required.
	//
	// If you choose to use __Certificate credentials__ you will have to provide:
	DefaultAuthenticationMethod pulumi.StringPtrInput
	// Whether the channel is enabled or disabled. Defaults to `true`.
	Enabled pulumi.BoolPtrInput
	// The Certificate Private Key file (ie. `.key` file).
	//
	// If you choose to use __Key credentials__ you will have to provide:
	PrivateKey pulumi.StringPtrInput
	// The ID assigned to your Apple developer account team. This value is provided on the Membership page.
	TeamId pulumi.StringPtrInput
	// The `.p8` file that you download from your Apple developer account when you create an authentication key.
	TokenKey pulumi.StringPtrInput
	// The ID assigned to your signing key. To find this value, choose Certificates, IDs & Profiles, and choose your key in the Keys section.
	TokenKeyId pulumi.StringPtrInput
}

func (ApnsChannelState) ElementType() reflect.Type {
	return reflect.TypeOf((*apnsChannelState)(nil)).Elem()
}

type apnsChannelArgs struct {
	// The application ID.
	ApplicationId string `pulumi:"applicationId"`
	// The ID assigned to your iOS app. To find this value, choose Certificates, IDs & Profiles, choose App IDs in the Identifiers section, and choose your app.
	BundleId *string `pulumi:"bundleId"`
	// The pem encoded TLS Certificate from Apple.
	Certificate *string `pulumi:"certificate"`
	// The default authentication method used for APNs.
	// __NOTE__: Amazon Pinpoint uses this default for every APNs push notification that you send using the console.
	// You can override the default when you send a message programmatically using the Amazon Pinpoint API, the AWS CLI, or an AWS SDK.
	// If your default authentication type fails, Amazon Pinpoint doesn't attempt to use the other authentication type.
	//
	// One of the following sets of credentials is also required.
	//
	// If you choose to use __Certificate credentials__ you will have to provide:
	DefaultAuthenticationMethod *string `pulumi:"defaultAuthenticationMethod"`
	// Whether the channel is enabled or disabled. Defaults to `true`.
	Enabled *bool `pulumi:"enabled"`
	// The Certificate Private Key file (ie. `.key` file).
	//
	// If you choose to use __Key credentials__ you will have to provide:
	PrivateKey *string `pulumi:"privateKey"`
	// The ID assigned to your Apple developer account team. This value is provided on the Membership page.
	TeamId *string `pulumi:"teamId"`
	// The `.p8` file that you download from your Apple developer account when you create an authentication key.
	TokenKey *string `pulumi:"tokenKey"`
	// The ID assigned to your signing key. To find this value, choose Certificates, IDs & Profiles, and choose your key in the Keys section.
	TokenKeyId *string `pulumi:"tokenKeyId"`
}

// The set of arguments for constructing a ApnsChannel resource.
type ApnsChannelArgs struct {
	// The application ID.
	ApplicationId pulumi.StringInput
	// The ID assigned to your iOS app. To find this value, choose Certificates, IDs & Profiles, choose App IDs in the Identifiers section, and choose your app.
	BundleId pulumi.StringPtrInput
	// The pem encoded TLS Certificate from Apple.
	Certificate pulumi.StringPtrInput
	// The default authentication method used for APNs.
	// __NOTE__: Amazon Pinpoint uses this default for every APNs push notification that you send using the console.
	// You can override the default when you send a message programmatically using the Amazon Pinpoint API, the AWS CLI, or an AWS SDK.
	// If your default authentication type fails, Amazon Pinpoint doesn't attempt to use the other authentication type.
	//
	// One of the following sets of credentials is also required.
	//
	// If you choose to use __Certificate credentials__ you will have to provide:
	DefaultAuthenticationMethod pulumi.StringPtrInput
	// Whether the channel is enabled or disabled. Defaults to `true`.
	Enabled pulumi.BoolPtrInput
	// The Certificate Private Key file (ie. `.key` file).
	//
	// If you choose to use __Key credentials__ you will have to provide:
	PrivateKey pulumi.StringPtrInput
	// The ID assigned to your Apple developer account team. This value is provided on the Membership page.
	TeamId pulumi.StringPtrInput
	// The `.p8` file that you download from your Apple developer account when you create an authentication key.
	TokenKey pulumi.StringPtrInput
	// The ID assigned to your signing key. To find this value, choose Certificates, IDs & Profiles, and choose your key in the Keys section.
	TokenKeyId pulumi.StringPtrInput
}

func (ApnsChannelArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*apnsChannelArgs)(nil)).Elem()
}

type ApnsChannelInput interface {
	pulumi.Input

	ToApnsChannelOutput() ApnsChannelOutput
	ToApnsChannelOutputWithContext(ctx context.Context) ApnsChannelOutput
}

func (*ApnsChannel) ElementType() reflect.Type {
	return reflect.TypeOf((**ApnsChannel)(nil)).Elem()
}

func (i *ApnsChannel) ToApnsChannelOutput() ApnsChannelOutput {
	return i.ToApnsChannelOutputWithContext(context.Background())
}

func (i *ApnsChannel) ToApnsChannelOutputWithContext(ctx context.Context) ApnsChannelOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ApnsChannelOutput)
}

// ApnsChannelArrayInput is an input type that accepts ApnsChannelArray and ApnsChannelArrayOutput values.
// You can construct a concrete instance of `ApnsChannelArrayInput` via:
//
//	ApnsChannelArray{ ApnsChannelArgs{...} }
type ApnsChannelArrayInput interface {
	pulumi.Input

	ToApnsChannelArrayOutput() ApnsChannelArrayOutput
	ToApnsChannelArrayOutputWithContext(context.Context) ApnsChannelArrayOutput
}

type ApnsChannelArray []ApnsChannelInput

func (ApnsChannelArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ApnsChannel)(nil)).Elem()
}

func (i ApnsChannelArray) ToApnsChannelArrayOutput() ApnsChannelArrayOutput {
	return i.ToApnsChannelArrayOutputWithContext(context.Background())
}

func (i ApnsChannelArray) ToApnsChannelArrayOutputWithContext(ctx context.Context) ApnsChannelArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ApnsChannelArrayOutput)
}

// ApnsChannelMapInput is an input type that accepts ApnsChannelMap and ApnsChannelMapOutput values.
// You can construct a concrete instance of `ApnsChannelMapInput` via:
//
//	ApnsChannelMap{ "key": ApnsChannelArgs{...} }
type ApnsChannelMapInput interface {
	pulumi.Input

	ToApnsChannelMapOutput() ApnsChannelMapOutput
	ToApnsChannelMapOutputWithContext(context.Context) ApnsChannelMapOutput
}

type ApnsChannelMap map[string]ApnsChannelInput

func (ApnsChannelMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ApnsChannel)(nil)).Elem()
}

func (i ApnsChannelMap) ToApnsChannelMapOutput() ApnsChannelMapOutput {
	return i.ToApnsChannelMapOutputWithContext(context.Background())
}

func (i ApnsChannelMap) ToApnsChannelMapOutputWithContext(ctx context.Context) ApnsChannelMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ApnsChannelMapOutput)
}

type ApnsChannelOutput struct{ *pulumi.OutputState }

func (ApnsChannelOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**ApnsChannel)(nil)).Elem()
}

func (o ApnsChannelOutput) ToApnsChannelOutput() ApnsChannelOutput {
	return o
}

func (o ApnsChannelOutput) ToApnsChannelOutputWithContext(ctx context.Context) ApnsChannelOutput {
	return o
}

// The application ID.
func (o ApnsChannelOutput) ApplicationId() pulumi.StringOutput {
	return o.ApplyT(func(v *ApnsChannel) pulumi.StringOutput { return v.ApplicationId }).(pulumi.StringOutput)
}

// The ID assigned to your iOS app. To find this value, choose Certificates, IDs & Profiles, choose App IDs in the Identifiers section, and choose your app.
func (o ApnsChannelOutput) BundleId() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *ApnsChannel) pulumi.StringPtrOutput { return v.BundleId }).(pulumi.StringPtrOutput)
}

// The pem encoded TLS Certificate from Apple.
func (o ApnsChannelOutput) Certificate() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *ApnsChannel) pulumi.StringPtrOutput { return v.Certificate }).(pulumi.StringPtrOutput)
}

// The default authentication method used for APNs.
// __NOTE__: Amazon Pinpoint uses this default for every APNs push notification that you send using the console.
// You can override the default when you send a message programmatically using the Amazon Pinpoint API, the AWS CLI, or an AWS SDK.
// If your default authentication type fails, Amazon Pinpoint doesn't attempt to use the other authentication type.
//
// One of the following sets of credentials is also required.
//
// If you choose to use __Certificate credentials__ you will have to provide:
func (o ApnsChannelOutput) DefaultAuthenticationMethod() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *ApnsChannel) pulumi.StringPtrOutput { return v.DefaultAuthenticationMethod }).(pulumi.StringPtrOutput)
}

// Whether the channel is enabled or disabled. Defaults to `true`.
func (o ApnsChannelOutput) Enabled() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v *ApnsChannel) pulumi.BoolPtrOutput { return v.Enabled }).(pulumi.BoolPtrOutput)
}

// The Certificate Private Key file (ie. `.key` file).
//
// If you choose to use __Key credentials__ you will have to provide:
func (o ApnsChannelOutput) PrivateKey() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *ApnsChannel) pulumi.StringPtrOutput { return v.PrivateKey }).(pulumi.StringPtrOutput)
}

// The ID assigned to your Apple developer account team. This value is provided on the Membership page.
func (o ApnsChannelOutput) TeamId() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *ApnsChannel) pulumi.StringPtrOutput { return v.TeamId }).(pulumi.StringPtrOutput)
}

// The `.p8` file that you download from your Apple developer account when you create an authentication key.
func (o ApnsChannelOutput) TokenKey() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *ApnsChannel) pulumi.StringPtrOutput { return v.TokenKey }).(pulumi.StringPtrOutput)
}

// The ID assigned to your signing key. To find this value, choose Certificates, IDs & Profiles, and choose your key in the Keys section.
func (o ApnsChannelOutput) TokenKeyId() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *ApnsChannel) pulumi.StringPtrOutput { return v.TokenKeyId }).(pulumi.StringPtrOutput)
}

type ApnsChannelArrayOutput struct{ *pulumi.OutputState }

func (ApnsChannelArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ApnsChannel)(nil)).Elem()
}

func (o ApnsChannelArrayOutput) ToApnsChannelArrayOutput() ApnsChannelArrayOutput {
	return o
}

func (o ApnsChannelArrayOutput) ToApnsChannelArrayOutputWithContext(ctx context.Context) ApnsChannelArrayOutput {
	return o
}

func (o ApnsChannelArrayOutput) Index(i pulumi.IntInput) ApnsChannelOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *ApnsChannel {
		return vs[0].([]*ApnsChannel)[vs[1].(int)]
	}).(ApnsChannelOutput)
}

type ApnsChannelMapOutput struct{ *pulumi.OutputState }

func (ApnsChannelMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ApnsChannel)(nil)).Elem()
}

func (o ApnsChannelMapOutput) ToApnsChannelMapOutput() ApnsChannelMapOutput {
	return o
}

func (o ApnsChannelMapOutput) ToApnsChannelMapOutputWithContext(ctx context.Context) ApnsChannelMapOutput {
	return o
}

func (o ApnsChannelMapOutput) MapIndex(k pulumi.StringInput) ApnsChannelOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *ApnsChannel {
		return vs[0].(map[string]*ApnsChannel)[vs[1].(string)]
	}).(ApnsChannelOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ApnsChannelInput)(nil)).Elem(), &ApnsChannel{})
	pulumi.RegisterInputType(reflect.TypeOf((*ApnsChannelArrayInput)(nil)).Elem(), ApnsChannelArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ApnsChannelMapInput)(nil)).Elem(), ApnsChannelMap{})
	pulumi.RegisterOutputType(ApnsChannelOutput{})
	pulumi.RegisterOutputType(ApnsChannelArrayOutput{})
	pulumi.RegisterOutputType(ApnsChannelMapOutput{})
}
