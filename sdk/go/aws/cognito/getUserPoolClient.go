// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package cognito

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a Cognito User Pool Client resource.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/cognito"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := cognito.LookupUserPoolClient(ctx, &cognito.LookupUserPoolClientArgs{
//				ClientId:   "38fjsnc484p94kpqsnet7mpld0",
//				UserPoolId: "us-west-2_aaaaaaaaa",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupUserPoolClient(ctx *pulumi.Context, args *LookupUserPoolClientArgs, opts ...pulumi.InvokeOption) (*LookupUserPoolClientResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupUserPoolClientResult
	err := ctx.Invoke("aws:cognito/getUserPoolClient:getUserPoolClient", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getUserPoolClient.
type LookupUserPoolClientArgs struct {
	// Client Id of the user pool.
	ClientId string `pulumi:"clientId"`
	// User pool the client belongs to.
	UserPoolId string `pulumi:"userPoolId"`
}

// A collection of values returned by getUserPoolClient.
type LookupUserPoolClientResult struct {
	// (Optional) Time limit, between 5 minutes and 1 day, after which the access token is no longer valid and cannot be used. This value will be overridden if you have entered a value in `tokenValidityUnits`.
	AccessTokenValidity int `pulumi:"accessTokenValidity"`
	// (Optional) List of allowed OAuth flows (code, implicit, client_credentials).
	AllowedOauthFlows []string `pulumi:"allowedOauthFlows"`
	// (Optional) Whether the client is allowed to follow the OAuth protocol when interacting with Cognito user pools.
	AllowedOauthFlowsUserPoolClient bool `pulumi:"allowedOauthFlowsUserPoolClient"`
	// (Optional) List of allowed OAuth scopes (phone, email, openid, profile, and aws.cognito.signin.user.admin).
	AllowedOauthScopes []string `pulumi:"allowedOauthScopes"`
	// (Optional) Configuration block for Amazon Pinpoint analytics for collecting metrics for this user pool. Detailed below.
	AnalyticsConfigurations []GetUserPoolClientAnalyticsConfiguration `pulumi:"analyticsConfigurations"`
	// (Optional) List of allowed callback URLs for the identity providers.
	CallbackUrls []string `pulumi:"callbackUrls"`
	ClientId     string   `pulumi:"clientId"`
	// Client secret of the user pool client.
	ClientSecret string `pulumi:"clientSecret"`
	// (Optional) Default redirect URI. Must be in the list of callback URLs.
	DefaultRedirectUri                       string `pulumi:"defaultRedirectUri"`
	EnablePropagateAdditionalUserContextData bool   `pulumi:"enablePropagateAdditionalUserContextData"`
	// (Optional) Enables or disables token revocation.
	EnableTokenRevocation bool `pulumi:"enableTokenRevocation"`
	// (Optional) List of authentication flows (ADMIN_NO_SRP_AUTH, CUSTOM_AUTH_FLOW_ONLY, USER_PASSWORD_AUTH, ALLOW_ADMIN_USER_PASSWORD_AUTH, ALLOW_CUSTOM_AUTH, ALLOW_USER_PASSWORD_AUTH, ALLOW_USER_SRP_AUTH, ALLOW_REFRESH_TOKEN_AUTH).
	ExplicitAuthFlows []string `pulumi:"explicitAuthFlows"`
	// (Optional) Should an application secret be generated.
	GenerateSecret bool `pulumi:"generateSecret"`
	// The provider-assigned unique ID for this managed resource.
	Id string `pulumi:"id"`
	// (Optional) Time limit, between 5 minutes and 1 day, after which the ID token is no longer valid and cannot be used. This value will be overridden if you have entered a value in `tokenValidityUnits`.
	IdTokenValidity int `pulumi:"idTokenValidity"`
	// (Optional) List of allowed logout URLs for the identity providers.
	LogoutUrls []string `pulumi:"logoutUrls"`
	Name       string   `pulumi:"name"`
	// (Optional) Choose which errors and responses are returned by Cognito APIs during authentication, account confirmation, and password recovery when the user does not exist in the user pool. When set to `ENABLED` and the user does not exist, authentication returns an error indicating either the username or password was incorrect, and account confirmation and password recovery return a response indicating a code was sent to a simulated destination. When set to `LEGACY`, those APIs will return a `UserNotFoundException` exception if the user does not exist in the user pool.
	PreventUserExistenceErrors string `pulumi:"preventUserExistenceErrors"`
	// (Optional) List of user pool attributes the application client can read from.
	ReadAttributes []string `pulumi:"readAttributes"`
	// (Optional) A block that specifies the configuration of refresh token rotation. Detailed below.
	RefreshTokenRotations []GetUserPoolClientRefreshTokenRotation `pulumi:"refreshTokenRotations"`
	// (Optional) Time limit in days refresh tokens are valid for.
	RefreshTokenValidity int `pulumi:"refreshTokenValidity"`
	// (Optional) List of provider names for the identity providers that are supported on this client. Uses the `providerName` attribute of `cognito.IdentityProvider` resource(s), or the equivalent string(s).
	SupportedIdentityProviders []string `pulumi:"supportedIdentityProviders"`
	// (Optional) Configuration block for units in which the validity times are represented in. Detailed below.
	TokenValidityUnits []GetUserPoolClientTokenValidityUnit `pulumi:"tokenValidityUnits"`
	UserPoolId         string                               `pulumi:"userPoolId"`
	// (Optional) List of user pool attributes the application client can write to.
	WriteAttributes []string `pulumi:"writeAttributes"`
}

func LookupUserPoolClientOutput(ctx *pulumi.Context, args LookupUserPoolClientOutputArgs, opts ...pulumi.InvokeOption) LookupUserPoolClientResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupUserPoolClientResultOutput, error) {
			args := v.(LookupUserPoolClientArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:cognito/getUserPoolClient:getUserPoolClient", args, LookupUserPoolClientResultOutput{}, options).(LookupUserPoolClientResultOutput), nil
		}).(LookupUserPoolClientResultOutput)
}

// A collection of arguments for invoking getUserPoolClient.
type LookupUserPoolClientOutputArgs struct {
	// Client Id of the user pool.
	ClientId pulumi.StringInput `pulumi:"clientId"`
	// User pool the client belongs to.
	UserPoolId pulumi.StringInput `pulumi:"userPoolId"`
}

func (LookupUserPoolClientOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupUserPoolClientArgs)(nil)).Elem()
}

// A collection of values returned by getUserPoolClient.
type LookupUserPoolClientResultOutput struct{ *pulumi.OutputState }

func (LookupUserPoolClientResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupUserPoolClientResult)(nil)).Elem()
}

func (o LookupUserPoolClientResultOutput) ToLookupUserPoolClientResultOutput() LookupUserPoolClientResultOutput {
	return o
}

func (o LookupUserPoolClientResultOutput) ToLookupUserPoolClientResultOutputWithContext(ctx context.Context) LookupUserPoolClientResultOutput {
	return o
}

// (Optional) Time limit, between 5 minutes and 1 day, after which the access token is no longer valid and cannot be used. This value will be overridden if you have entered a value in `tokenValidityUnits`.
func (o LookupUserPoolClientResultOutput) AccessTokenValidity() pulumi.IntOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) int { return v.AccessTokenValidity }).(pulumi.IntOutput)
}

// (Optional) List of allowed OAuth flows (code, implicit, client_credentials).
func (o LookupUserPoolClientResultOutput) AllowedOauthFlows() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) []string { return v.AllowedOauthFlows }).(pulumi.StringArrayOutput)
}

// (Optional) Whether the client is allowed to follow the OAuth protocol when interacting with Cognito user pools.
func (o LookupUserPoolClientResultOutput) AllowedOauthFlowsUserPoolClient() pulumi.BoolOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) bool { return v.AllowedOauthFlowsUserPoolClient }).(pulumi.BoolOutput)
}

// (Optional) List of allowed OAuth scopes (phone, email, openid, profile, and aws.cognito.signin.user.admin).
func (o LookupUserPoolClientResultOutput) AllowedOauthScopes() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) []string { return v.AllowedOauthScopes }).(pulumi.StringArrayOutput)
}

// (Optional) Configuration block for Amazon Pinpoint analytics for collecting metrics for this user pool. Detailed below.
func (o LookupUserPoolClientResultOutput) AnalyticsConfigurations() GetUserPoolClientAnalyticsConfigurationArrayOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) []GetUserPoolClientAnalyticsConfiguration {
		return v.AnalyticsConfigurations
	}).(GetUserPoolClientAnalyticsConfigurationArrayOutput)
}

// (Optional) List of allowed callback URLs for the identity providers.
func (o LookupUserPoolClientResultOutput) CallbackUrls() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) []string { return v.CallbackUrls }).(pulumi.StringArrayOutput)
}

func (o LookupUserPoolClientResultOutput) ClientId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) string { return v.ClientId }).(pulumi.StringOutput)
}

// Client secret of the user pool client.
func (o LookupUserPoolClientResultOutput) ClientSecret() pulumi.StringOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) string { return v.ClientSecret }).(pulumi.StringOutput)
}

// (Optional) Default redirect URI. Must be in the list of callback URLs.
func (o LookupUserPoolClientResultOutput) DefaultRedirectUri() pulumi.StringOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) string { return v.DefaultRedirectUri }).(pulumi.StringOutput)
}

func (o LookupUserPoolClientResultOutput) EnablePropagateAdditionalUserContextData() pulumi.BoolOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) bool { return v.EnablePropagateAdditionalUserContextData }).(pulumi.BoolOutput)
}

// (Optional) Enables or disables token revocation.
func (o LookupUserPoolClientResultOutput) EnableTokenRevocation() pulumi.BoolOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) bool { return v.EnableTokenRevocation }).(pulumi.BoolOutput)
}

// (Optional) List of authentication flows (ADMIN_NO_SRP_AUTH, CUSTOM_AUTH_FLOW_ONLY, USER_PASSWORD_AUTH, ALLOW_ADMIN_USER_PASSWORD_AUTH, ALLOW_CUSTOM_AUTH, ALLOW_USER_PASSWORD_AUTH, ALLOW_USER_SRP_AUTH, ALLOW_REFRESH_TOKEN_AUTH).
func (o LookupUserPoolClientResultOutput) ExplicitAuthFlows() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) []string { return v.ExplicitAuthFlows }).(pulumi.StringArrayOutput)
}

// (Optional) Should an application secret be generated.
func (o LookupUserPoolClientResultOutput) GenerateSecret() pulumi.BoolOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) bool { return v.GenerateSecret }).(pulumi.BoolOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o LookupUserPoolClientResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) string { return v.Id }).(pulumi.StringOutput)
}

// (Optional) Time limit, between 5 minutes and 1 day, after which the ID token is no longer valid and cannot be used. This value will be overridden if you have entered a value in `tokenValidityUnits`.
func (o LookupUserPoolClientResultOutput) IdTokenValidity() pulumi.IntOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) int { return v.IdTokenValidity }).(pulumi.IntOutput)
}

// (Optional) List of allowed logout URLs for the identity providers.
func (o LookupUserPoolClientResultOutput) LogoutUrls() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) []string { return v.LogoutUrls }).(pulumi.StringArrayOutput)
}

func (o LookupUserPoolClientResultOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) string { return v.Name }).(pulumi.StringOutput)
}

// (Optional) Choose which errors and responses are returned by Cognito APIs during authentication, account confirmation, and password recovery when the user does not exist in the user pool. When set to `ENABLED` and the user does not exist, authentication returns an error indicating either the username or password was incorrect, and account confirmation and password recovery return a response indicating a code was sent to a simulated destination. When set to `LEGACY`, those APIs will return a `UserNotFoundException` exception if the user does not exist in the user pool.
func (o LookupUserPoolClientResultOutput) PreventUserExistenceErrors() pulumi.StringOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) string { return v.PreventUserExistenceErrors }).(pulumi.StringOutput)
}

// (Optional) List of user pool attributes the application client can read from.
func (o LookupUserPoolClientResultOutput) ReadAttributes() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) []string { return v.ReadAttributes }).(pulumi.StringArrayOutput)
}

// (Optional) A block that specifies the configuration of refresh token rotation. Detailed below.
func (o LookupUserPoolClientResultOutput) RefreshTokenRotations() GetUserPoolClientRefreshTokenRotationArrayOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) []GetUserPoolClientRefreshTokenRotation {
		return v.RefreshTokenRotations
	}).(GetUserPoolClientRefreshTokenRotationArrayOutput)
}

// (Optional) Time limit in days refresh tokens are valid for.
func (o LookupUserPoolClientResultOutput) RefreshTokenValidity() pulumi.IntOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) int { return v.RefreshTokenValidity }).(pulumi.IntOutput)
}

// (Optional) List of provider names for the identity providers that are supported on this client. Uses the `providerName` attribute of `cognito.IdentityProvider` resource(s), or the equivalent string(s).
func (o LookupUserPoolClientResultOutput) SupportedIdentityProviders() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) []string { return v.SupportedIdentityProviders }).(pulumi.StringArrayOutput)
}

// (Optional) Configuration block for units in which the validity times are represented in. Detailed below.
func (o LookupUserPoolClientResultOutput) TokenValidityUnits() GetUserPoolClientTokenValidityUnitArrayOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) []GetUserPoolClientTokenValidityUnit { return v.TokenValidityUnits }).(GetUserPoolClientTokenValidityUnitArrayOutput)
}

func (o LookupUserPoolClientResultOutput) UserPoolId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) string { return v.UserPoolId }).(pulumi.StringOutput)
}

// (Optional) List of user pool attributes the application client can write to.
func (o LookupUserPoolClientResultOutput) WriteAttributes() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupUserPoolClientResult) []string { return v.WriteAttributes }).(pulumi.StringArrayOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupUserPoolClientResultOutput{})
}
