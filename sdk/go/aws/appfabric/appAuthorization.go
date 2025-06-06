// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package appfabric

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS AppFabric App Authorization.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/appfabric"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := appfabric.NewAppAuthorization(ctx, "example", &appfabric.AppAuthorizationArgs{
//				App:          pulumi.String("TERRAFORMCLOUD"),
//				AppBundleArn: pulumi.Any(arn),
//				AuthType:     pulumi.String("apiKey"),
//				Credential: &appfabric.AppAuthorizationCredentialArgs{
//					ApiKeyCredentials: appfabric.AppAuthorizationCredentialApiKeyCredentialArray{
//						&appfabric.AppAuthorizationCredentialApiKeyCredentialArgs{
//							ApiKey: pulumi.String("exampleapikeytoken"),
//						},
//					},
//				},
//				Tenants: appfabric.AppAuthorizationTenantArray{
//					&appfabric.AppAuthorizationTenantArgs{
//						TenantDisplayName: pulumi.String("example"),
//						TenantIdentifier:  pulumi.String("example"),
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
type AppAuthorization struct {
	pulumi.CustomResourceState

	// The name of the application for valid values see https://docs.aws.amazon.com/appfabric/latest/api/API_CreateAppAuthorization.html.
	App pulumi.StringOutput `pulumi:"app"`
	// The Amazon Resource Name (ARN) of the app bundle to use for the request.
	AppBundleArn pulumi.StringOutput `pulumi:"appBundleArn"`
	// ARN of the App Authorization. Do not begin the description with "An", "The", "Defines", "Indicates", or "Specifies," as these are verbose. In other words, "Indicates the amount of storage," can be rewritten as "Amount of storage," without losing any information.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// The authorization type for the app authorization valid values are oauth2 and apiKey.
	AuthType pulumi.StringOutput `pulumi:"authType"`
	// The application URL for the OAuth flow.
	AuthUrl   pulumi.StringOutput `pulumi:"authUrl"`
	CreatedAt pulumi.StringOutput `pulumi:"createdAt"`
	// Contains credentials for the application, such as an API key or OAuth2 client ID and secret.
	// Specify credentials that match the authorization type for your request. For example, if the authorization type for your request is OAuth2 (oauth2), then you should provide only the OAuth2 credentials.
	Credential AppAuthorizationCredentialPtrOutput `pulumi:"credential"`
	// The user persona of the app authorization.
	Persona pulumi.StringOutput    `pulumi:"persona"`
	Tags    pulumi.StringMapOutput `pulumi:"tags"`
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	// Contains information about an application tenant, such as the application display name and identifier.
	Tenants   AppAuthorizationTenantArrayOutput `pulumi:"tenants"`
	Timeouts  AppAuthorizationTimeoutsPtrOutput `pulumi:"timeouts"`
	UpdatedAt pulumi.StringOutput               `pulumi:"updatedAt"`
}

// NewAppAuthorization registers a new resource with the given unique name, arguments, and options.
func NewAppAuthorization(ctx *pulumi.Context,
	name string, args *AppAuthorizationArgs, opts ...pulumi.ResourceOption) (*AppAuthorization, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.App == nil {
		return nil, errors.New("invalid value for required argument 'App'")
	}
	if args.AppBundleArn == nil {
		return nil, errors.New("invalid value for required argument 'AppBundleArn'")
	}
	if args.AuthType == nil {
		return nil, errors.New("invalid value for required argument 'AuthType'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource AppAuthorization
	err := ctx.RegisterResource("aws:appfabric/appAuthorization:AppAuthorization", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetAppAuthorization gets an existing AppAuthorization resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetAppAuthorization(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *AppAuthorizationState, opts ...pulumi.ResourceOption) (*AppAuthorization, error) {
	var resource AppAuthorization
	err := ctx.ReadResource("aws:appfabric/appAuthorization:AppAuthorization", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering AppAuthorization resources.
type appAuthorizationState struct {
	// The name of the application for valid values see https://docs.aws.amazon.com/appfabric/latest/api/API_CreateAppAuthorization.html.
	App *string `pulumi:"app"`
	// The Amazon Resource Name (ARN) of the app bundle to use for the request.
	AppBundleArn *string `pulumi:"appBundleArn"`
	// ARN of the App Authorization. Do not begin the description with "An", "The", "Defines", "Indicates", or "Specifies," as these are verbose. In other words, "Indicates the amount of storage," can be rewritten as "Amount of storage," without losing any information.
	Arn *string `pulumi:"arn"`
	// The authorization type for the app authorization valid values are oauth2 and apiKey.
	AuthType *string `pulumi:"authType"`
	// The application URL for the OAuth flow.
	AuthUrl   *string `pulumi:"authUrl"`
	CreatedAt *string `pulumi:"createdAt"`
	// Contains credentials for the application, such as an API key or OAuth2 client ID and secret.
	// Specify credentials that match the authorization type for your request. For example, if the authorization type for your request is OAuth2 (oauth2), then you should provide only the OAuth2 credentials.
	Credential *AppAuthorizationCredential `pulumi:"credential"`
	// The user persona of the app authorization.
	Persona *string           `pulumi:"persona"`
	Tags    map[string]string `pulumi:"tags"`
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	// Contains information about an application tenant, such as the application display name and identifier.
	Tenants   []AppAuthorizationTenant  `pulumi:"tenants"`
	Timeouts  *AppAuthorizationTimeouts `pulumi:"timeouts"`
	UpdatedAt *string                   `pulumi:"updatedAt"`
}

type AppAuthorizationState struct {
	// The name of the application for valid values see https://docs.aws.amazon.com/appfabric/latest/api/API_CreateAppAuthorization.html.
	App pulumi.StringPtrInput
	// The Amazon Resource Name (ARN) of the app bundle to use for the request.
	AppBundleArn pulumi.StringPtrInput
	// ARN of the App Authorization. Do not begin the description with "An", "The", "Defines", "Indicates", or "Specifies," as these are verbose. In other words, "Indicates the amount of storage," can be rewritten as "Amount of storage," without losing any information.
	Arn pulumi.StringPtrInput
	// The authorization type for the app authorization valid values are oauth2 and apiKey.
	AuthType pulumi.StringPtrInput
	// The application URL for the OAuth flow.
	AuthUrl   pulumi.StringPtrInput
	CreatedAt pulumi.StringPtrInput
	// Contains credentials for the application, such as an API key or OAuth2 client ID and secret.
	// Specify credentials that match the authorization type for your request. For example, if the authorization type for your request is OAuth2 (oauth2), then you should provide only the OAuth2 credentials.
	Credential AppAuthorizationCredentialPtrInput
	// The user persona of the app authorization.
	Persona pulumi.StringPtrInput
	Tags    pulumi.StringMapInput
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	// Contains information about an application tenant, such as the application display name and identifier.
	Tenants   AppAuthorizationTenantArrayInput
	Timeouts  AppAuthorizationTimeoutsPtrInput
	UpdatedAt pulumi.StringPtrInput
}

func (AppAuthorizationState) ElementType() reflect.Type {
	return reflect.TypeOf((*appAuthorizationState)(nil)).Elem()
}

type appAuthorizationArgs struct {
	// The name of the application for valid values see https://docs.aws.amazon.com/appfabric/latest/api/API_CreateAppAuthorization.html.
	App string `pulumi:"app"`
	// The Amazon Resource Name (ARN) of the app bundle to use for the request.
	AppBundleArn string `pulumi:"appBundleArn"`
	// The authorization type for the app authorization valid values are oauth2 and apiKey.
	AuthType string `pulumi:"authType"`
	// Contains credentials for the application, such as an API key or OAuth2 client ID and secret.
	// Specify credentials that match the authorization type for your request. For example, if the authorization type for your request is OAuth2 (oauth2), then you should provide only the OAuth2 credentials.
	Credential *AppAuthorizationCredential `pulumi:"credential"`
	Tags       map[string]string           `pulumi:"tags"`
	// Contains information about an application tenant, such as the application display name and identifier.
	Tenants  []AppAuthorizationTenant  `pulumi:"tenants"`
	Timeouts *AppAuthorizationTimeouts `pulumi:"timeouts"`
}

// The set of arguments for constructing a AppAuthorization resource.
type AppAuthorizationArgs struct {
	// The name of the application for valid values see https://docs.aws.amazon.com/appfabric/latest/api/API_CreateAppAuthorization.html.
	App pulumi.StringInput
	// The Amazon Resource Name (ARN) of the app bundle to use for the request.
	AppBundleArn pulumi.StringInput
	// The authorization type for the app authorization valid values are oauth2 and apiKey.
	AuthType pulumi.StringInput
	// Contains credentials for the application, such as an API key or OAuth2 client ID and secret.
	// Specify credentials that match the authorization type for your request. For example, if the authorization type for your request is OAuth2 (oauth2), then you should provide only the OAuth2 credentials.
	Credential AppAuthorizationCredentialPtrInput
	Tags       pulumi.StringMapInput
	// Contains information about an application tenant, such as the application display name and identifier.
	Tenants  AppAuthorizationTenantArrayInput
	Timeouts AppAuthorizationTimeoutsPtrInput
}

func (AppAuthorizationArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*appAuthorizationArgs)(nil)).Elem()
}

type AppAuthorizationInput interface {
	pulumi.Input

	ToAppAuthorizationOutput() AppAuthorizationOutput
	ToAppAuthorizationOutputWithContext(ctx context.Context) AppAuthorizationOutput
}

func (*AppAuthorization) ElementType() reflect.Type {
	return reflect.TypeOf((**AppAuthorization)(nil)).Elem()
}

func (i *AppAuthorization) ToAppAuthorizationOutput() AppAuthorizationOutput {
	return i.ToAppAuthorizationOutputWithContext(context.Background())
}

func (i *AppAuthorization) ToAppAuthorizationOutputWithContext(ctx context.Context) AppAuthorizationOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AppAuthorizationOutput)
}

// AppAuthorizationArrayInput is an input type that accepts AppAuthorizationArray and AppAuthorizationArrayOutput values.
// You can construct a concrete instance of `AppAuthorizationArrayInput` via:
//
//	AppAuthorizationArray{ AppAuthorizationArgs{...} }
type AppAuthorizationArrayInput interface {
	pulumi.Input

	ToAppAuthorizationArrayOutput() AppAuthorizationArrayOutput
	ToAppAuthorizationArrayOutputWithContext(context.Context) AppAuthorizationArrayOutput
}

type AppAuthorizationArray []AppAuthorizationInput

func (AppAuthorizationArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*AppAuthorization)(nil)).Elem()
}

func (i AppAuthorizationArray) ToAppAuthorizationArrayOutput() AppAuthorizationArrayOutput {
	return i.ToAppAuthorizationArrayOutputWithContext(context.Background())
}

func (i AppAuthorizationArray) ToAppAuthorizationArrayOutputWithContext(ctx context.Context) AppAuthorizationArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AppAuthorizationArrayOutput)
}

// AppAuthorizationMapInput is an input type that accepts AppAuthorizationMap and AppAuthorizationMapOutput values.
// You can construct a concrete instance of `AppAuthorizationMapInput` via:
//
//	AppAuthorizationMap{ "key": AppAuthorizationArgs{...} }
type AppAuthorizationMapInput interface {
	pulumi.Input

	ToAppAuthorizationMapOutput() AppAuthorizationMapOutput
	ToAppAuthorizationMapOutputWithContext(context.Context) AppAuthorizationMapOutput
}

type AppAuthorizationMap map[string]AppAuthorizationInput

func (AppAuthorizationMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*AppAuthorization)(nil)).Elem()
}

func (i AppAuthorizationMap) ToAppAuthorizationMapOutput() AppAuthorizationMapOutput {
	return i.ToAppAuthorizationMapOutputWithContext(context.Background())
}

func (i AppAuthorizationMap) ToAppAuthorizationMapOutputWithContext(ctx context.Context) AppAuthorizationMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AppAuthorizationMapOutput)
}

type AppAuthorizationOutput struct{ *pulumi.OutputState }

func (AppAuthorizationOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**AppAuthorization)(nil)).Elem()
}

func (o AppAuthorizationOutput) ToAppAuthorizationOutput() AppAuthorizationOutput {
	return o
}

func (o AppAuthorizationOutput) ToAppAuthorizationOutputWithContext(ctx context.Context) AppAuthorizationOutput {
	return o
}

// The name of the application for valid values see https://docs.aws.amazon.com/appfabric/latest/api/API_CreateAppAuthorization.html.
func (o AppAuthorizationOutput) App() pulumi.StringOutput {
	return o.ApplyT(func(v *AppAuthorization) pulumi.StringOutput { return v.App }).(pulumi.StringOutput)
}

// The Amazon Resource Name (ARN) of the app bundle to use for the request.
func (o AppAuthorizationOutput) AppBundleArn() pulumi.StringOutput {
	return o.ApplyT(func(v *AppAuthorization) pulumi.StringOutput { return v.AppBundleArn }).(pulumi.StringOutput)
}

// ARN of the App Authorization. Do not begin the description with "An", "The", "Defines", "Indicates", or "Specifies," as these are verbose. In other words, "Indicates the amount of storage," can be rewritten as "Amount of storage," without losing any information.
func (o AppAuthorizationOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *AppAuthorization) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// The authorization type for the app authorization valid values are oauth2 and apiKey.
func (o AppAuthorizationOutput) AuthType() pulumi.StringOutput {
	return o.ApplyT(func(v *AppAuthorization) pulumi.StringOutput { return v.AuthType }).(pulumi.StringOutput)
}

// The application URL for the OAuth flow.
func (o AppAuthorizationOutput) AuthUrl() pulumi.StringOutput {
	return o.ApplyT(func(v *AppAuthorization) pulumi.StringOutput { return v.AuthUrl }).(pulumi.StringOutput)
}

func (o AppAuthorizationOutput) CreatedAt() pulumi.StringOutput {
	return o.ApplyT(func(v *AppAuthorization) pulumi.StringOutput { return v.CreatedAt }).(pulumi.StringOutput)
}

// Contains credentials for the application, such as an API key or OAuth2 client ID and secret.
// Specify credentials that match the authorization type for your request. For example, if the authorization type for your request is OAuth2 (oauth2), then you should provide only the OAuth2 credentials.
func (o AppAuthorizationOutput) Credential() AppAuthorizationCredentialPtrOutput {
	return o.ApplyT(func(v *AppAuthorization) AppAuthorizationCredentialPtrOutput { return v.Credential }).(AppAuthorizationCredentialPtrOutput)
}

// The user persona of the app authorization.
func (o AppAuthorizationOutput) Persona() pulumi.StringOutput {
	return o.ApplyT(func(v *AppAuthorization) pulumi.StringOutput { return v.Persona }).(pulumi.StringOutput)
}

func (o AppAuthorizationOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *AppAuthorization) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Deprecated: Please use `tags` instead.
func (o AppAuthorizationOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *AppAuthorization) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

// Contains information about an application tenant, such as the application display name and identifier.
func (o AppAuthorizationOutput) Tenants() AppAuthorizationTenantArrayOutput {
	return o.ApplyT(func(v *AppAuthorization) AppAuthorizationTenantArrayOutput { return v.Tenants }).(AppAuthorizationTenantArrayOutput)
}

func (o AppAuthorizationOutput) Timeouts() AppAuthorizationTimeoutsPtrOutput {
	return o.ApplyT(func(v *AppAuthorization) AppAuthorizationTimeoutsPtrOutput { return v.Timeouts }).(AppAuthorizationTimeoutsPtrOutput)
}

func (o AppAuthorizationOutput) UpdatedAt() pulumi.StringOutput {
	return o.ApplyT(func(v *AppAuthorization) pulumi.StringOutput { return v.UpdatedAt }).(pulumi.StringOutput)
}

type AppAuthorizationArrayOutput struct{ *pulumi.OutputState }

func (AppAuthorizationArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*AppAuthorization)(nil)).Elem()
}

func (o AppAuthorizationArrayOutput) ToAppAuthorizationArrayOutput() AppAuthorizationArrayOutput {
	return o
}

func (o AppAuthorizationArrayOutput) ToAppAuthorizationArrayOutputWithContext(ctx context.Context) AppAuthorizationArrayOutput {
	return o
}

func (o AppAuthorizationArrayOutput) Index(i pulumi.IntInput) AppAuthorizationOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *AppAuthorization {
		return vs[0].([]*AppAuthorization)[vs[1].(int)]
	}).(AppAuthorizationOutput)
}

type AppAuthorizationMapOutput struct{ *pulumi.OutputState }

func (AppAuthorizationMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*AppAuthorization)(nil)).Elem()
}

func (o AppAuthorizationMapOutput) ToAppAuthorizationMapOutput() AppAuthorizationMapOutput {
	return o
}

func (o AppAuthorizationMapOutput) ToAppAuthorizationMapOutputWithContext(ctx context.Context) AppAuthorizationMapOutput {
	return o
}

func (o AppAuthorizationMapOutput) MapIndex(k pulumi.StringInput) AppAuthorizationOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *AppAuthorization {
		return vs[0].(map[string]*AppAuthorization)[vs[1].(string)]
	}).(AppAuthorizationOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*AppAuthorizationInput)(nil)).Elem(), &AppAuthorization{})
	pulumi.RegisterInputType(reflect.TypeOf((*AppAuthorizationArrayInput)(nil)).Elem(), AppAuthorizationArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*AppAuthorizationMapInput)(nil)).Elem(), AppAuthorizationMap{})
	pulumi.RegisterOutputType(AppAuthorizationOutput{})
	pulumi.RegisterOutputType(AppAuthorizationArrayOutput{})
	pulumi.RegisterOutputType(AppAuthorizationMapOutput{})
}
