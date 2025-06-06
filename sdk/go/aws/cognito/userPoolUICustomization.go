// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package cognito

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a Cognito User Pool UI Customization resource.
//
// > **Note:** To use this resource, the user pool must have a domain associated with it. For more information, see the Amazon Cognito Developer Guide on [Customizing the Built-in Sign-In and Sign-up Webpages](https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-user-pools-app-ui-customization.html).
//
// ## Example Usage
//
// ### UI customization settings for a single client
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/cognito"
//	"github.com/pulumi/pulumi-std/sdk/go/std"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			example, err := cognito.NewUserPool(ctx, "example", &cognito.UserPoolArgs{
//				Name: pulumi.String("example"),
//			})
//			if err != nil {
//				return err
//			}
//			exampleUserPoolDomain, err := cognito.NewUserPoolDomain(ctx, "example", &cognito.UserPoolDomainArgs{
//				Domain:     pulumi.String("example"),
//				UserPoolId: example.ID(),
//			})
//			if err != nil {
//				return err
//			}
//			exampleUserPoolClient, err := cognito.NewUserPoolClient(ctx, "example", &cognito.UserPoolClientArgs{
//				Name:       pulumi.String("example"),
//				UserPoolId: example.ID(),
//			})
//			if err != nil {
//				return err
//			}
//			invokeFilebase64, err := std.Filebase64(ctx, &std.Filebase64Args{
//				Input: "logo.png",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			_, err = cognito.NewUserPoolUICustomization(ctx, "example", &cognito.UserPoolUICustomizationArgs{
//				ClientId:   exampleUserPoolClient.ID(),
//				Css:        pulumi.String(".label-customizable {font-weight: 400;}"),
//				ImageFile:  pulumi.String(invokeFilebase64.Result),
//				UserPoolId: exampleUserPoolDomain.UserPoolId,
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
// ### UI customization settings for all clients
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/cognito"
//	"github.com/pulumi/pulumi-std/sdk/go/std"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			example, err := cognito.NewUserPool(ctx, "example", &cognito.UserPoolArgs{
//				Name: pulumi.String("example"),
//			})
//			if err != nil {
//				return err
//			}
//			exampleUserPoolDomain, err := cognito.NewUserPoolDomain(ctx, "example", &cognito.UserPoolDomainArgs{
//				Domain:     pulumi.String("example"),
//				UserPoolId: example.ID(),
//			})
//			if err != nil {
//				return err
//			}
//			invokeFilebase64, err := std.Filebase64(ctx, &std.Filebase64Args{
//				Input: "logo.png",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			_, err = cognito.NewUserPoolUICustomization(ctx, "example", &cognito.UserPoolUICustomizationArgs{
//				Css:        pulumi.String(".label-customizable {font-weight: 400;}"),
//				ImageFile:  pulumi.String(invokeFilebase64.Result),
//				UserPoolId: exampleUserPoolDomain.UserPoolId,
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
// Using `pulumi import`, import Cognito User Pool UI Customizations using the `user_pool_id` and `client_id` separated by `,`. For example:
//
// ```sh
// $ pulumi import aws:cognito/userPoolUICustomization:UserPoolUICustomization example us-west-2_ZCTarbt5C,12bu4fuk3mlgqa2rtrujgp6egq
// ```
type UserPoolUICustomization struct {
	pulumi.CustomResourceState

	// The client ID for the client app. Defaults to `ALL`. If `ALL` is specified, the `css` and/or `imageFile` settings will be used for every client that has no UI customization set previously.
	ClientId pulumi.StringPtrOutput `pulumi:"clientId"`
	// The creation date in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) for the UI customization.
	CreationDate pulumi.StringOutput `pulumi:"creationDate"`
	// The CSS values in the UI customization, provided as a String. At least one of `css` or `imageFile` is required.
	Css pulumi.StringPtrOutput `pulumi:"css"`
	// The CSS version number.
	CssVersion pulumi.StringOutput `pulumi:"cssVersion"`
	// The uploaded logo image for the UI customization, provided as a base64-encoded String. Drift detection is not possible for this argument. At least one of `css` or `imageFile` is required.
	ImageFile pulumi.StringPtrOutput `pulumi:"imageFile"`
	// The logo image URL for the UI customization.
	ImageUrl pulumi.StringOutput `pulumi:"imageUrl"`
	// The last-modified date in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) for the UI customization.
	LastModifiedDate pulumi.StringOutput `pulumi:"lastModifiedDate"`
	// The user pool ID for the user pool.
	UserPoolId pulumi.StringOutput `pulumi:"userPoolId"`
}

// NewUserPoolUICustomization registers a new resource with the given unique name, arguments, and options.
func NewUserPoolUICustomization(ctx *pulumi.Context,
	name string, args *UserPoolUICustomizationArgs, opts ...pulumi.ResourceOption) (*UserPoolUICustomization, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.UserPoolId == nil {
		return nil, errors.New("invalid value for required argument 'UserPoolId'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource UserPoolUICustomization
	err := ctx.RegisterResource("aws:cognito/userPoolUICustomization:UserPoolUICustomization", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetUserPoolUICustomization gets an existing UserPoolUICustomization resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetUserPoolUICustomization(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *UserPoolUICustomizationState, opts ...pulumi.ResourceOption) (*UserPoolUICustomization, error) {
	var resource UserPoolUICustomization
	err := ctx.ReadResource("aws:cognito/userPoolUICustomization:UserPoolUICustomization", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering UserPoolUICustomization resources.
type userPoolUICustomizationState struct {
	// The client ID for the client app. Defaults to `ALL`. If `ALL` is specified, the `css` and/or `imageFile` settings will be used for every client that has no UI customization set previously.
	ClientId *string `pulumi:"clientId"`
	// The creation date in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) for the UI customization.
	CreationDate *string `pulumi:"creationDate"`
	// The CSS values in the UI customization, provided as a String. At least one of `css` or `imageFile` is required.
	Css *string `pulumi:"css"`
	// The CSS version number.
	CssVersion *string `pulumi:"cssVersion"`
	// The uploaded logo image for the UI customization, provided as a base64-encoded String. Drift detection is not possible for this argument. At least one of `css` or `imageFile` is required.
	ImageFile *string `pulumi:"imageFile"`
	// The logo image URL for the UI customization.
	ImageUrl *string `pulumi:"imageUrl"`
	// The last-modified date in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) for the UI customization.
	LastModifiedDate *string `pulumi:"lastModifiedDate"`
	// The user pool ID for the user pool.
	UserPoolId *string `pulumi:"userPoolId"`
}

type UserPoolUICustomizationState struct {
	// The client ID for the client app. Defaults to `ALL`. If `ALL` is specified, the `css` and/or `imageFile` settings will be used for every client that has no UI customization set previously.
	ClientId pulumi.StringPtrInput
	// The creation date in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) for the UI customization.
	CreationDate pulumi.StringPtrInput
	// The CSS values in the UI customization, provided as a String. At least one of `css` or `imageFile` is required.
	Css pulumi.StringPtrInput
	// The CSS version number.
	CssVersion pulumi.StringPtrInput
	// The uploaded logo image for the UI customization, provided as a base64-encoded String. Drift detection is not possible for this argument. At least one of `css` or `imageFile` is required.
	ImageFile pulumi.StringPtrInput
	// The logo image URL for the UI customization.
	ImageUrl pulumi.StringPtrInput
	// The last-modified date in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) for the UI customization.
	LastModifiedDate pulumi.StringPtrInput
	// The user pool ID for the user pool.
	UserPoolId pulumi.StringPtrInput
}

func (UserPoolUICustomizationState) ElementType() reflect.Type {
	return reflect.TypeOf((*userPoolUICustomizationState)(nil)).Elem()
}

type userPoolUICustomizationArgs struct {
	// The client ID for the client app. Defaults to `ALL`. If `ALL` is specified, the `css` and/or `imageFile` settings will be used for every client that has no UI customization set previously.
	ClientId *string `pulumi:"clientId"`
	// The CSS values in the UI customization, provided as a String. At least one of `css` or `imageFile` is required.
	Css *string `pulumi:"css"`
	// The uploaded logo image for the UI customization, provided as a base64-encoded String. Drift detection is not possible for this argument. At least one of `css` or `imageFile` is required.
	ImageFile *string `pulumi:"imageFile"`
	// The user pool ID for the user pool.
	UserPoolId string `pulumi:"userPoolId"`
}

// The set of arguments for constructing a UserPoolUICustomization resource.
type UserPoolUICustomizationArgs struct {
	// The client ID for the client app. Defaults to `ALL`. If `ALL` is specified, the `css` and/or `imageFile` settings will be used for every client that has no UI customization set previously.
	ClientId pulumi.StringPtrInput
	// The CSS values in the UI customization, provided as a String. At least one of `css` or `imageFile` is required.
	Css pulumi.StringPtrInput
	// The uploaded logo image for the UI customization, provided as a base64-encoded String. Drift detection is not possible for this argument. At least one of `css` or `imageFile` is required.
	ImageFile pulumi.StringPtrInput
	// The user pool ID for the user pool.
	UserPoolId pulumi.StringInput
}

func (UserPoolUICustomizationArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*userPoolUICustomizationArgs)(nil)).Elem()
}

type UserPoolUICustomizationInput interface {
	pulumi.Input

	ToUserPoolUICustomizationOutput() UserPoolUICustomizationOutput
	ToUserPoolUICustomizationOutputWithContext(ctx context.Context) UserPoolUICustomizationOutput
}

func (*UserPoolUICustomization) ElementType() reflect.Type {
	return reflect.TypeOf((**UserPoolUICustomization)(nil)).Elem()
}

func (i *UserPoolUICustomization) ToUserPoolUICustomizationOutput() UserPoolUICustomizationOutput {
	return i.ToUserPoolUICustomizationOutputWithContext(context.Background())
}

func (i *UserPoolUICustomization) ToUserPoolUICustomizationOutputWithContext(ctx context.Context) UserPoolUICustomizationOutput {
	return pulumi.ToOutputWithContext(ctx, i).(UserPoolUICustomizationOutput)
}

// UserPoolUICustomizationArrayInput is an input type that accepts UserPoolUICustomizationArray and UserPoolUICustomizationArrayOutput values.
// You can construct a concrete instance of `UserPoolUICustomizationArrayInput` via:
//
//	UserPoolUICustomizationArray{ UserPoolUICustomizationArgs{...} }
type UserPoolUICustomizationArrayInput interface {
	pulumi.Input

	ToUserPoolUICustomizationArrayOutput() UserPoolUICustomizationArrayOutput
	ToUserPoolUICustomizationArrayOutputWithContext(context.Context) UserPoolUICustomizationArrayOutput
}

type UserPoolUICustomizationArray []UserPoolUICustomizationInput

func (UserPoolUICustomizationArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*UserPoolUICustomization)(nil)).Elem()
}

func (i UserPoolUICustomizationArray) ToUserPoolUICustomizationArrayOutput() UserPoolUICustomizationArrayOutput {
	return i.ToUserPoolUICustomizationArrayOutputWithContext(context.Background())
}

func (i UserPoolUICustomizationArray) ToUserPoolUICustomizationArrayOutputWithContext(ctx context.Context) UserPoolUICustomizationArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(UserPoolUICustomizationArrayOutput)
}

// UserPoolUICustomizationMapInput is an input type that accepts UserPoolUICustomizationMap and UserPoolUICustomizationMapOutput values.
// You can construct a concrete instance of `UserPoolUICustomizationMapInput` via:
//
//	UserPoolUICustomizationMap{ "key": UserPoolUICustomizationArgs{...} }
type UserPoolUICustomizationMapInput interface {
	pulumi.Input

	ToUserPoolUICustomizationMapOutput() UserPoolUICustomizationMapOutput
	ToUserPoolUICustomizationMapOutputWithContext(context.Context) UserPoolUICustomizationMapOutput
}

type UserPoolUICustomizationMap map[string]UserPoolUICustomizationInput

func (UserPoolUICustomizationMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*UserPoolUICustomization)(nil)).Elem()
}

func (i UserPoolUICustomizationMap) ToUserPoolUICustomizationMapOutput() UserPoolUICustomizationMapOutput {
	return i.ToUserPoolUICustomizationMapOutputWithContext(context.Background())
}

func (i UserPoolUICustomizationMap) ToUserPoolUICustomizationMapOutputWithContext(ctx context.Context) UserPoolUICustomizationMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(UserPoolUICustomizationMapOutput)
}

type UserPoolUICustomizationOutput struct{ *pulumi.OutputState }

func (UserPoolUICustomizationOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**UserPoolUICustomization)(nil)).Elem()
}

func (o UserPoolUICustomizationOutput) ToUserPoolUICustomizationOutput() UserPoolUICustomizationOutput {
	return o
}

func (o UserPoolUICustomizationOutput) ToUserPoolUICustomizationOutputWithContext(ctx context.Context) UserPoolUICustomizationOutput {
	return o
}

// The client ID for the client app. Defaults to `ALL`. If `ALL` is specified, the `css` and/or `imageFile` settings will be used for every client that has no UI customization set previously.
func (o UserPoolUICustomizationOutput) ClientId() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *UserPoolUICustomization) pulumi.StringPtrOutput { return v.ClientId }).(pulumi.StringPtrOutput)
}

// The creation date in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) for the UI customization.
func (o UserPoolUICustomizationOutput) CreationDate() pulumi.StringOutput {
	return o.ApplyT(func(v *UserPoolUICustomization) pulumi.StringOutput { return v.CreationDate }).(pulumi.StringOutput)
}

// The CSS values in the UI customization, provided as a String. At least one of `css` or `imageFile` is required.
func (o UserPoolUICustomizationOutput) Css() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *UserPoolUICustomization) pulumi.StringPtrOutput { return v.Css }).(pulumi.StringPtrOutput)
}

// The CSS version number.
func (o UserPoolUICustomizationOutput) CssVersion() pulumi.StringOutput {
	return o.ApplyT(func(v *UserPoolUICustomization) pulumi.StringOutput { return v.CssVersion }).(pulumi.StringOutput)
}

// The uploaded logo image for the UI customization, provided as a base64-encoded String. Drift detection is not possible for this argument. At least one of `css` or `imageFile` is required.
func (o UserPoolUICustomizationOutput) ImageFile() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *UserPoolUICustomization) pulumi.StringPtrOutput { return v.ImageFile }).(pulumi.StringPtrOutput)
}

// The logo image URL for the UI customization.
func (o UserPoolUICustomizationOutput) ImageUrl() pulumi.StringOutput {
	return o.ApplyT(func(v *UserPoolUICustomization) pulumi.StringOutput { return v.ImageUrl }).(pulumi.StringOutput)
}

// The last-modified date in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) for the UI customization.
func (o UserPoolUICustomizationOutput) LastModifiedDate() pulumi.StringOutput {
	return o.ApplyT(func(v *UserPoolUICustomization) pulumi.StringOutput { return v.LastModifiedDate }).(pulumi.StringOutput)
}

// The user pool ID for the user pool.
func (o UserPoolUICustomizationOutput) UserPoolId() pulumi.StringOutput {
	return o.ApplyT(func(v *UserPoolUICustomization) pulumi.StringOutput { return v.UserPoolId }).(pulumi.StringOutput)
}

type UserPoolUICustomizationArrayOutput struct{ *pulumi.OutputState }

func (UserPoolUICustomizationArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*UserPoolUICustomization)(nil)).Elem()
}

func (o UserPoolUICustomizationArrayOutput) ToUserPoolUICustomizationArrayOutput() UserPoolUICustomizationArrayOutput {
	return o
}

func (o UserPoolUICustomizationArrayOutput) ToUserPoolUICustomizationArrayOutputWithContext(ctx context.Context) UserPoolUICustomizationArrayOutput {
	return o
}

func (o UserPoolUICustomizationArrayOutput) Index(i pulumi.IntInput) UserPoolUICustomizationOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *UserPoolUICustomization {
		return vs[0].([]*UserPoolUICustomization)[vs[1].(int)]
	}).(UserPoolUICustomizationOutput)
}

type UserPoolUICustomizationMapOutput struct{ *pulumi.OutputState }

func (UserPoolUICustomizationMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*UserPoolUICustomization)(nil)).Elem()
}

func (o UserPoolUICustomizationMapOutput) ToUserPoolUICustomizationMapOutput() UserPoolUICustomizationMapOutput {
	return o
}

func (o UserPoolUICustomizationMapOutput) ToUserPoolUICustomizationMapOutputWithContext(ctx context.Context) UserPoolUICustomizationMapOutput {
	return o
}

func (o UserPoolUICustomizationMapOutput) MapIndex(k pulumi.StringInput) UserPoolUICustomizationOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *UserPoolUICustomization {
		return vs[0].(map[string]*UserPoolUICustomization)[vs[1].(string)]
	}).(UserPoolUICustomizationOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*UserPoolUICustomizationInput)(nil)).Elem(), &UserPoolUICustomization{})
	pulumi.RegisterInputType(reflect.TypeOf((*UserPoolUICustomizationArrayInput)(nil)).Elem(), UserPoolUICustomizationArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*UserPoolUICustomizationMapInput)(nil)).Elem(), UserPoolUICustomizationMap{})
	pulumi.RegisterOutputType(UserPoolUICustomizationOutput{})
	pulumi.RegisterOutputType(UserPoolUICustomizationArrayOutput{})
	pulumi.RegisterOutputType(UserPoolUICustomizationMapOutput{})
}
