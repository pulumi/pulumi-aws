// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package sagemaker

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a SageMaker AI Workforce resource.
//
// ## Example Usage
//
// ### Cognito Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/cognito"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/sagemaker"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			exampleUserPool, err := cognito.NewUserPool(ctx, "example", &cognito.UserPoolArgs{
//				Name: pulumi.String("example"),
//			})
//			if err != nil {
//				return err
//			}
//			exampleUserPoolClient, err := cognito.NewUserPoolClient(ctx, "example", &cognito.UserPoolClientArgs{
//				Name:           pulumi.String("example"),
//				GenerateSecret: pulumi.Bool(true),
//				UserPoolId:     exampleUserPool.ID(),
//			})
//			if err != nil {
//				return err
//			}
//			exampleUserPoolDomain, err := cognito.NewUserPoolDomain(ctx, "example", &cognito.UserPoolDomainArgs{
//				Domain:     pulumi.String("example"),
//				UserPoolId: exampleUserPool.ID(),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = sagemaker.NewWorkforce(ctx, "example", &sagemaker.WorkforceArgs{
//				WorkforceName: pulumi.String("example"),
//				CognitoConfig: &sagemaker.WorkforceCognitoConfigArgs{
//					ClientId: exampleUserPoolClient.ID(),
//					UserPool: exampleUserPoolDomain.UserPoolId,
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
// ### Oidc Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/sagemaker"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := sagemaker.NewWorkforce(ctx, "example", &sagemaker.WorkforceArgs{
//				WorkforceName: pulumi.String("example"),
//				OidcConfig: &sagemaker.WorkforceOidcConfigArgs{
//					AuthorizationEndpoint: pulumi.String("https://example.com"),
//					ClientId:              pulumi.String("example"),
//					ClientSecret:          pulumi.String("example"),
//					Issuer:                pulumi.String("https://example.com"),
//					JwksUri:               pulumi.String("https://example.com"),
//					LogoutEndpoint:        pulumi.String("https://example.com"),
//					TokenEndpoint:         pulumi.String("https://example.com"),
//					UserInfoEndpoint:      pulumi.String("https://example.com"),
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
// Using `pulumi import`, import SageMaker AI Workforces using the `workforce_name`. For example:
//
// ```sh
// $ pulumi import aws:sagemaker/workforce:Workforce example example
// ```
type Workforce struct {
	pulumi.CustomResourceState

	// The Amazon Resource Name (ARN) assigned by AWS to this Workforce.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Use this parameter to configure an Amazon Cognito private workforce. A single Cognito workforce is created using and corresponds to a single Amazon Cognito user pool. Conflicts with `oidcConfig`. see Cognito Config details below.
	CognitoConfig WorkforceCognitoConfigPtrOutput `pulumi:"cognitoConfig"`
	// Use this parameter to configure a private workforce using your own OIDC Identity Provider. Conflicts with `cognitoConfig`. see OIDC Config details below.
	OidcConfig WorkforceOidcConfigPtrOutput `pulumi:"oidcConfig"`
	// A list of IP address ranges Used to create an allow list of IP addresses for a private workforce. By default, a workforce isn't restricted to specific IP addresses. see Source Ip Config details below.
	SourceIpConfig WorkforceSourceIpConfigOutput `pulumi:"sourceIpConfig"`
	// The subdomain for your OIDC Identity Provider.
	Subdomain pulumi.StringOutput `pulumi:"subdomain"`
	// The name of the Workforce (must be unique).
	WorkforceName pulumi.StringOutput `pulumi:"workforceName"`
	// configure a workforce using VPC. see Workforce VPC Config details below.
	WorkforceVpcConfig WorkforceWorkforceVpcConfigPtrOutput `pulumi:"workforceVpcConfig"`
}

// NewWorkforce registers a new resource with the given unique name, arguments, and options.
func NewWorkforce(ctx *pulumi.Context,
	name string, args *WorkforceArgs, opts ...pulumi.ResourceOption) (*Workforce, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.WorkforceName == nil {
		return nil, errors.New("invalid value for required argument 'WorkforceName'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource Workforce
	err := ctx.RegisterResource("aws:sagemaker/workforce:Workforce", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetWorkforce gets an existing Workforce resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetWorkforce(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *WorkforceState, opts ...pulumi.ResourceOption) (*Workforce, error) {
	var resource Workforce
	err := ctx.ReadResource("aws:sagemaker/workforce:Workforce", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Workforce resources.
type workforceState struct {
	// The Amazon Resource Name (ARN) assigned by AWS to this Workforce.
	Arn *string `pulumi:"arn"`
	// Use this parameter to configure an Amazon Cognito private workforce. A single Cognito workforce is created using and corresponds to a single Amazon Cognito user pool. Conflicts with `oidcConfig`. see Cognito Config details below.
	CognitoConfig *WorkforceCognitoConfig `pulumi:"cognitoConfig"`
	// Use this parameter to configure a private workforce using your own OIDC Identity Provider. Conflicts with `cognitoConfig`. see OIDC Config details below.
	OidcConfig *WorkforceOidcConfig `pulumi:"oidcConfig"`
	// A list of IP address ranges Used to create an allow list of IP addresses for a private workforce. By default, a workforce isn't restricted to specific IP addresses. see Source Ip Config details below.
	SourceIpConfig *WorkforceSourceIpConfig `pulumi:"sourceIpConfig"`
	// The subdomain for your OIDC Identity Provider.
	Subdomain *string `pulumi:"subdomain"`
	// The name of the Workforce (must be unique).
	WorkforceName *string `pulumi:"workforceName"`
	// configure a workforce using VPC. see Workforce VPC Config details below.
	WorkforceVpcConfig *WorkforceWorkforceVpcConfig `pulumi:"workforceVpcConfig"`
}

type WorkforceState struct {
	// The Amazon Resource Name (ARN) assigned by AWS to this Workforce.
	Arn pulumi.StringPtrInput
	// Use this parameter to configure an Amazon Cognito private workforce. A single Cognito workforce is created using and corresponds to a single Amazon Cognito user pool. Conflicts with `oidcConfig`. see Cognito Config details below.
	CognitoConfig WorkforceCognitoConfigPtrInput
	// Use this parameter to configure a private workforce using your own OIDC Identity Provider. Conflicts with `cognitoConfig`. see OIDC Config details below.
	OidcConfig WorkforceOidcConfigPtrInput
	// A list of IP address ranges Used to create an allow list of IP addresses for a private workforce. By default, a workforce isn't restricted to specific IP addresses. see Source Ip Config details below.
	SourceIpConfig WorkforceSourceIpConfigPtrInput
	// The subdomain for your OIDC Identity Provider.
	Subdomain pulumi.StringPtrInput
	// The name of the Workforce (must be unique).
	WorkforceName pulumi.StringPtrInput
	// configure a workforce using VPC. see Workforce VPC Config details below.
	WorkforceVpcConfig WorkforceWorkforceVpcConfigPtrInput
}

func (WorkforceState) ElementType() reflect.Type {
	return reflect.TypeOf((*workforceState)(nil)).Elem()
}

type workforceArgs struct {
	// Use this parameter to configure an Amazon Cognito private workforce. A single Cognito workforce is created using and corresponds to a single Amazon Cognito user pool. Conflicts with `oidcConfig`. see Cognito Config details below.
	CognitoConfig *WorkforceCognitoConfig `pulumi:"cognitoConfig"`
	// Use this parameter to configure a private workforce using your own OIDC Identity Provider. Conflicts with `cognitoConfig`. see OIDC Config details below.
	OidcConfig *WorkforceOidcConfig `pulumi:"oidcConfig"`
	// A list of IP address ranges Used to create an allow list of IP addresses for a private workforce. By default, a workforce isn't restricted to specific IP addresses. see Source Ip Config details below.
	SourceIpConfig *WorkforceSourceIpConfig `pulumi:"sourceIpConfig"`
	// The name of the Workforce (must be unique).
	WorkforceName string `pulumi:"workforceName"`
	// configure a workforce using VPC. see Workforce VPC Config details below.
	WorkforceVpcConfig *WorkforceWorkforceVpcConfig `pulumi:"workforceVpcConfig"`
}

// The set of arguments for constructing a Workforce resource.
type WorkforceArgs struct {
	// Use this parameter to configure an Amazon Cognito private workforce. A single Cognito workforce is created using and corresponds to a single Amazon Cognito user pool. Conflicts with `oidcConfig`. see Cognito Config details below.
	CognitoConfig WorkforceCognitoConfigPtrInput
	// Use this parameter to configure a private workforce using your own OIDC Identity Provider. Conflicts with `cognitoConfig`. see OIDC Config details below.
	OidcConfig WorkforceOidcConfigPtrInput
	// A list of IP address ranges Used to create an allow list of IP addresses for a private workforce. By default, a workforce isn't restricted to specific IP addresses. see Source Ip Config details below.
	SourceIpConfig WorkforceSourceIpConfigPtrInput
	// The name of the Workforce (must be unique).
	WorkforceName pulumi.StringInput
	// configure a workforce using VPC. see Workforce VPC Config details below.
	WorkforceVpcConfig WorkforceWorkforceVpcConfigPtrInput
}

func (WorkforceArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*workforceArgs)(nil)).Elem()
}

type WorkforceInput interface {
	pulumi.Input

	ToWorkforceOutput() WorkforceOutput
	ToWorkforceOutputWithContext(ctx context.Context) WorkforceOutput
}

func (*Workforce) ElementType() reflect.Type {
	return reflect.TypeOf((**Workforce)(nil)).Elem()
}

func (i *Workforce) ToWorkforceOutput() WorkforceOutput {
	return i.ToWorkforceOutputWithContext(context.Background())
}

func (i *Workforce) ToWorkforceOutputWithContext(ctx context.Context) WorkforceOutput {
	return pulumi.ToOutputWithContext(ctx, i).(WorkforceOutput)
}

// WorkforceArrayInput is an input type that accepts WorkforceArray and WorkforceArrayOutput values.
// You can construct a concrete instance of `WorkforceArrayInput` via:
//
//	WorkforceArray{ WorkforceArgs{...} }
type WorkforceArrayInput interface {
	pulumi.Input

	ToWorkforceArrayOutput() WorkforceArrayOutput
	ToWorkforceArrayOutputWithContext(context.Context) WorkforceArrayOutput
}

type WorkforceArray []WorkforceInput

func (WorkforceArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Workforce)(nil)).Elem()
}

func (i WorkforceArray) ToWorkforceArrayOutput() WorkforceArrayOutput {
	return i.ToWorkforceArrayOutputWithContext(context.Background())
}

func (i WorkforceArray) ToWorkforceArrayOutputWithContext(ctx context.Context) WorkforceArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(WorkforceArrayOutput)
}

// WorkforceMapInput is an input type that accepts WorkforceMap and WorkforceMapOutput values.
// You can construct a concrete instance of `WorkforceMapInput` via:
//
//	WorkforceMap{ "key": WorkforceArgs{...} }
type WorkforceMapInput interface {
	pulumi.Input

	ToWorkforceMapOutput() WorkforceMapOutput
	ToWorkforceMapOutputWithContext(context.Context) WorkforceMapOutput
}

type WorkforceMap map[string]WorkforceInput

func (WorkforceMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Workforce)(nil)).Elem()
}

func (i WorkforceMap) ToWorkforceMapOutput() WorkforceMapOutput {
	return i.ToWorkforceMapOutputWithContext(context.Background())
}

func (i WorkforceMap) ToWorkforceMapOutputWithContext(ctx context.Context) WorkforceMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(WorkforceMapOutput)
}

type WorkforceOutput struct{ *pulumi.OutputState }

func (WorkforceOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**Workforce)(nil)).Elem()
}

func (o WorkforceOutput) ToWorkforceOutput() WorkforceOutput {
	return o
}

func (o WorkforceOutput) ToWorkforceOutputWithContext(ctx context.Context) WorkforceOutput {
	return o
}

// The Amazon Resource Name (ARN) assigned by AWS to this Workforce.
func (o WorkforceOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *Workforce) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Use this parameter to configure an Amazon Cognito private workforce. A single Cognito workforce is created using and corresponds to a single Amazon Cognito user pool. Conflicts with `oidcConfig`. see Cognito Config details below.
func (o WorkforceOutput) CognitoConfig() WorkforceCognitoConfigPtrOutput {
	return o.ApplyT(func(v *Workforce) WorkforceCognitoConfigPtrOutput { return v.CognitoConfig }).(WorkforceCognitoConfigPtrOutput)
}

// Use this parameter to configure a private workforce using your own OIDC Identity Provider. Conflicts with `cognitoConfig`. see OIDC Config details below.
func (o WorkforceOutput) OidcConfig() WorkforceOidcConfigPtrOutput {
	return o.ApplyT(func(v *Workforce) WorkforceOidcConfigPtrOutput { return v.OidcConfig }).(WorkforceOidcConfigPtrOutput)
}

// A list of IP address ranges Used to create an allow list of IP addresses for a private workforce. By default, a workforce isn't restricted to specific IP addresses. see Source Ip Config details below.
func (o WorkforceOutput) SourceIpConfig() WorkforceSourceIpConfigOutput {
	return o.ApplyT(func(v *Workforce) WorkforceSourceIpConfigOutput { return v.SourceIpConfig }).(WorkforceSourceIpConfigOutput)
}

// The subdomain for your OIDC Identity Provider.
func (o WorkforceOutput) Subdomain() pulumi.StringOutput {
	return o.ApplyT(func(v *Workforce) pulumi.StringOutput { return v.Subdomain }).(pulumi.StringOutput)
}

// The name of the Workforce (must be unique).
func (o WorkforceOutput) WorkforceName() pulumi.StringOutput {
	return o.ApplyT(func(v *Workforce) pulumi.StringOutput { return v.WorkforceName }).(pulumi.StringOutput)
}

// configure a workforce using VPC. see Workforce VPC Config details below.
func (o WorkforceOutput) WorkforceVpcConfig() WorkforceWorkforceVpcConfigPtrOutput {
	return o.ApplyT(func(v *Workforce) WorkforceWorkforceVpcConfigPtrOutput { return v.WorkforceVpcConfig }).(WorkforceWorkforceVpcConfigPtrOutput)
}

type WorkforceArrayOutput struct{ *pulumi.OutputState }

func (WorkforceArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Workforce)(nil)).Elem()
}

func (o WorkforceArrayOutput) ToWorkforceArrayOutput() WorkforceArrayOutput {
	return o
}

func (o WorkforceArrayOutput) ToWorkforceArrayOutputWithContext(ctx context.Context) WorkforceArrayOutput {
	return o
}

func (o WorkforceArrayOutput) Index(i pulumi.IntInput) WorkforceOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *Workforce {
		return vs[0].([]*Workforce)[vs[1].(int)]
	}).(WorkforceOutput)
}

type WorkforceMapOutput struct{ *pulumi.OutputState }

func (WorkforceMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Workforce)(nil)).Elem()
}

func (o WorkforceMapOutput) ToWorkforceMapOutput() WorkforceMapOutput {
	return o
}

func (o WorkforceMapOutput) ToWorkforceMapOutputWithContext(ctx context.Context) WorkforceMapOutput {
	return o
}

func (o WorkforceMapOutput) MapIndex(k pulumi.StringInput) WorkforceOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *Workforce {
		return vs[0].(map[string]*Workforce)[vs[1].(string)]
	}).(WorkforceOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*WorkforceInput)(nil)).Elem(), &Workforce{})
	pulumi.RegisterInputType(reflect.TypeOf((*WorkforceArrayInput)(nil)).Elem(), WorkforceArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*WorkforceMapInput)(nil)).Elem(), WorkforceMap{})
	pulumi.RegisterOutputType(WorkforceOutput{})
	pulumi.RegisterOutputType(WorkforceArrayOutput{})
	pulumi.RegisterOutputType(WorkforceMapOutput{})
}
