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

// Provides a Cognito Risk Configuration resource.
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
//			_, err := cognito.NewRiskConfiguration(ctx, "example", &cognito.RiskConfigurationArgs{
//				UserPoolId: pulumi.Any(exampleAwsCognitoUserPool.Id),
//				RiskExceptionConfiguration: &cognito.RiskConfigurationRiskExceptionConfigurationArgs{
//					BlockedIpRangeLists: pulumi.StringArray{
//						pulumi.String("10.10.10.10/32"),
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
// Import using the user pool ID and Client ID separated by a `:`:
//
// __Using `pulumi import` to import__ Cognito Risk Configurations using the user pool ID or the user pool ID and Client Id separated by a `:`. For example:
//
// Import using the user pool ID:
//
// ```sh
// $ pulumi import aws:cognito/riskConfiguration:RiskConfiguration main example
// ```
// Import using the user pool ID and Client ID separated by a `:`:
//
// ```sh
// $ pulumi import aws:cognito/riskConfiguration:RiskConfiguration main example:example
// ```
type RiskConfiguration struct {
	pulumi.CustomResourceState

	// The account takeover risk configuration. See details below.
	AccountTakeoverRiskConfiguration RiskConfigurationAccountTakeoverRiskConfigurationPtrOutput `pulumi:"accountTakeoverRiskConfiguration"`
	// The app client ID. When the client ID is not provided, the same risk configuration is applied to all the clients in the User Pool.
	ClientId pulumi.StringPtrOutput `pulumi:"clientId"`
	// The compromised credentials risk configuration. See details below.
	CompromisedCredentialsRiskConfiguration RiskConfigurationCompromisedCredentialsRiskConfigurationPtrOutput `pulumi:"compromisedCredentialsRiskConfiguration"`
	// The configuration to override the risk decision. See details below.
	RiskExceptionConfiguration RiskConfigurationRiskExceptionConfigurationPtrOutput `pulumi:"riskExceptionConfiguration"`
	// The user pool ID.
	UserPoolId pulumi.StringOutput `pulumi:"userPoolId"`
}

// NewRiskConfiguration registers a new resource with the given unique name, arguments, and options.
func NewRiskConfiguration(ctx *pulumi.Context,
	name string, args *RiskConfigurationArgs, opts ...pulumi.ResourceOption) (*RiskConfiguration, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.UserPoolId == nil {
		return nil, errors.New("invalid value for required argument 'UserPoolId'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource RiskConfiguration
	err := ctx.RegisterResource("aws:cognito/riskConfiguration:RiskConfiguration", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetRiskConfiguration gets an existing RiskConfiguration resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetRiskConfiguration(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *RiskConfigurationState, opts ...pulumi.ResourceOption) (*RiskConfiguration, error) {
	var resource RiskConfiguration
	err := ctx.ReadResource("aws:cognito/riskConfiguration:RiskConfiguration", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering RiskConfiguration resources.
type riskConfigurationState struct {
	// The account takeover risk configuration. See details below.
	AccountTakeoverRiskConfiguration *RiskConfigurationAccountTakeoverRiskConfiguration `pulumi:"accountTakeoverRiskConfiguration"`
	// The app client ID. When the client ID is not provided, the same risk configuration is applied to all the clients in the User Pool.
	ClientId *string `pulumi:"clientId"`
	// The compromised credentials risk configuration. See details below.
	CompromisedCredentialsRiskConfiguration *RiskConfigurationCompromisedCredentialsRiskConfiguration `pulumi:"compromisedCredentialsRiskConfiguration"`
	// The configuration to override the risk decision. See details below.
	RiskExceptionConfiguration *RiskConfigurationRiskExceptionConfiguration `pulumi:"riskExceptionConfiguration"`
	// The user pool ID.
	UserPoolId *string `pulumi:"userPoolId"`
}

type RiskConfigurationState struct {
	// The account takeover risk configuration. See details below.
	AccountTakeoverRiskConfiguration RiskConfigurationAccountTakeoverRiskConfigurationPtrInput
	// The app client ID. When the client ID is not provided, the same risk configuration is applied to all the clients in the User Pool.
	ClientId pulumi.StringPtrInput
	// The compromised credentials risk configuration. See details below.
	CompromisedCredentialsRiskConfiguration RiskConfigurationCompromisedCredentialsRiskConfigurationPtrInput
	// The configuration to override the risk decision. See details below.
	RiskExceptionConfiguration RiskConfigurationRiskExceptionConfigurationPtrInput
	// The user pool ID.
	UserPoolId pulumi.StringPtrInput
}

func (RiskConfigurationState) ElementType() reflect.Type {
	return reflect.TypeOf((*riskConfigurationState)(nil)).Elem()
}

type riskConfigurationArgs struct {
	// The account takeover risk configuration. See details below.
	AccountTakeoverRiskConfiguration *RiskConfigurationAccountTakeoverRiskConfiguration `pulumi:"accountTakeoverRiskConfiguration"`
	// The app client ID. When the client ID is not provided, the same risk configuration is applied to all the clients in the User Pool.
	ClientId *string `pulumi:"clientId"`
	// The compromised credentials risk configuration. See details below.
	CompromisedCredentialsRiskConfiguration *RiskConfigurationCompromisedCredentialsRiskConfiguration `pulumi:"compromisedCredentialsRiskConfiguration"`
	// The configuration to override the risk decision. See details below.
	RiskExceptionConfiguration *RiskConfigurationRiskExceptionConfiguration `pulumi:"riskExceptionConfiguration"`
	// The user pool ID.
	UserPoolId string `pulumi:"userPoolId"`
}

// The set of arguments for constructing a RiskConfiguration resource.
type RiskConfigurationArgs struct {
	// The account takeover risk configuration. See details below.
	AccountTakeoverRiskConfiguration RiskConfigurationAccountTakeoverRiskConfigurationPtrInput
	// The app client ID. When the client ID is not provided, the same risk configuration is applied to all the clients in the User Pool.
	ClientId pulumi.StringPtrInput
	// The compromised credentials risk configuration. See details below.
	CompromisedCredentialsRiskConfiguration RiskConfigurationCompromisedCredentialsRiskConfigurationPtrInput
	// The configuration to override the risk decision. See details below.
	RiskExceptionConfiguration RiskConfigurationRiskExceptionConfigurationPtrInput
	// The user pool ID.
	UserPoolId pulumi.StringInput
}

func (RiskConfigurationArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*riskConfigurationArgs)(nil)).Elem()
}

type RiskConfigurationInput interface {
	pulumi.Input

	ToRiskConfigurationOutput() RiskConfigurationOutput
	ToRiskConfigurationOutputWithContext(ctx context.Context) RiskConfigurationOutput
}

func (*RiskConfiguration) ElementType() reflect.Type {
	return reflect.TypeOf((**RiskConfiguration)(nil)).Elem()
}

func (i *RiskConfiguration) ToRiskConfigurationOutput() RiskConfigurationOutput {
	return i.ToRiskConfigurationOutputWithContext(context.Background())
}

func (i *RiskConfiguration) ToRiskConfigurationOutputWithContext(ctx context.Context) RiskConfigurationOutput {
	return pulumi.ToOutputWithContext(ctx, i).(RiskConfigurationOutput)
}

// RiskConfigurationArrayInput is an input type that accepts RiskConfigurationArray and RiskConfigurationArrayOutput values.
// You can construct a concrete instance of `RiskConfigurationArrayInput` via:
//
//	RiskConfigurationArray{ RiskConfigurationArgs{...} }
type RiskConfigurationArrayInput interface {
	pulumi.Input

	ToRiskConfigurationArrayOutput() RiskConfigurationArrayOutput
	ToRiskConfigurationArrayOutputWithContext(context.Context) RiskConfigurationArrayOutput
}

type RiskConfigurationArray []RiskConfigurationInput

func (RiskConfigurationArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*RiskConfiguration)(nil)).Elem()
}

func (i RiskConfigurationArray) ToRiskConfigurationArrayOutput() RiskConfigurationArrayOutput {
	return i.ToRiskConfigurationArrayOutputWithContext(context.Background())
}

func (i RiskConfigurationArray) ToRiskConfigurationArrayOutputWithContext(ctx context.Context) RiskConfigurationArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(RiskConfigurationArrayOutput)
}

// RiskConfigurationMapInput is an input type that accepts RiskConfigurationMap and RiskConfigurationMapOutput values.
// You can construct a concrete instance of `RiskConfigurationMapInput` via:
//
//	RiskConfigurationMap{ "key": RiskConfigurationArgs{...} }
type RiskConfigurationMapInput interface {
	pulumi.Input

	ToRiskConfigurationMapOutput() RiskConfigurationMapOutput
	ToRiskConfigurationMapOutputWithContext(context.Context) RiskConfigurationMapOutput
}

type RiskConfigurationMap map[string]RiskConfigurationInput

func (RiskConfigurationMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*RiskConfiguration)(nil)).Elem()
}

func (i RiskConfigurationMap) ToRiskConfigurationMapOutput() RiskConfigurationMapOutput {
	return i.ToRiskConfigurationMapOutputWithContext(context.Background())
}

func (i RiskConfigurationMap) ToRiskConfigurationMapOutputWithContext(ctx context.Context) RiskConfigurationMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(RiskConfigurationMapOutput)
}

type RiskConfigurationOutput struct{ *pulumi.OutputState }

func (RiskConfigurationOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**RiskConfiguration)(nil)).Elem()
}

func (o RiskConfigurationOutput) ToRiskConfigurationOutput() RiskConfigurationOutput {
	return o
}

func (o RiskConfigurationOutput) ToRiskConfigurationOutputWithContext(ctx context.Context) RiskConfigurationOutput {
	return o
}

// The account takeover risk configuration. See details below.
func (o RiskConfigurationOutput) AccountTakeoverRiskConfiguration() RiskConfigurationAccountTakeoverRiskConfigurationPtrOutput {
	return o.ApplyT(func(v *RiskConfiguration) RiskConfigurationAccountTakeoverRiskConfigurationPtrOutput {
		return v.AccountTakeoverRiskConfiguration
	}).(RiskConfigurationAccountTakeoverRiskConfigurationPtrOutput)
}

// The app client ID. When the client ID is not provided, the same risk configuration is applied to all the clients in the User Pool.
func (o RiskConfigurationOutput) ClientId() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *RiskConfiguration) pulumi.StringPtrOutput { return v.ClientId }).(pulumi.StringPtrOutput)
}

// The compromised credentials risk configuration. See details below.
func (o RiskConfigurationOutput) CompromisedCredentialsRiskConfiguration() RiskConfigurationCompromisedCredentialsRiskConfigurationPtrOutput {
	return o.ApplyT(func(v *RiskConfiguration) RiskConfigurationCompromisedCredentialsRiskConfigurationPtrOutput {
		return v.CompromisedCredentialsRiskConfiguration
	}).(RiskConfigurationCompromisedCredentialsRiskConfigurationPtrOutput)
}

// The configuration to override the risk decision. See details below.
func (o RiskConfigurationOutput) RiskExceptionConfiguration() RiskConfigurationRiskExceptionConfigurationPtrOutput {
	return o.ApplyT(func(v *RiskConfiguration) RiskConfigurationRiskExceptionConfigurationPtrOutput {
		return v.RiskExceptionConfiguration
	}).(RiskConfigurationRiskExceptionConfigurationPtrOutput)
}

// The user pool ID.
func (o RiskConfigurationOutput) UserPoolId() pulumi.StringOutput {
	return o.ApplyT(func(v *RiskConfiguration) pulumi.StringOutput { return v.UserPoolId }).(pulumi.StringOutput)
}

type RiskConfigurationArrayOutput struct{ *pulumi.OutputState }

func (RiskConfigurationArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*RiskConfiguration)(nil)).Elem()
}

func (o RiskConfigurationArrayOutput) ToRiskConfigurationArrayOutput() RiskConfigurationArrayOutput {
	return o
}

func (o RiskConfigurationArrayOutput) ToRiskConfigurationArrayOutputWithContext(ctx context.Context) RiskConfigurationArrayOutput {
	return o
}

func (o RiskConfigurationArrayOutput) Index(i pulumi.IntInput) RiskConfigurationOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *RiskConfiguration {
		return vs[0].([]*RiskConfiguration)[vs[1].(int)]
	}).(RiskConfigurationOutput)
}

type RiskConfigurationMapOutput struct{ *pulumi.OutputState }

func (RiskConfigurationMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*RiskConfiguration)(nil)).Elem()
}

func (o RiskConfigurationMapOutput) ToRiskConfigurationMapOutput() RiskConfigurationMapOutput {
	return o
}

func (o RiskConfigurationMapOutput) ToRiskConfigurationMapOutputWithContext(ctx context.Context) RiskConfigurationMapOutput {
	return o
}

func (o RiskConfigurationMapOutput) MapIndex(k pulumi.StringInput) RiskConfigurationOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *RiskConfiguration {
		return vs[0].(map[string]*RiskConfiguration)[vs[1].(string)]
	}).(RiskConfigurationOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*RiskConfigurationInput)(nil)).Elem(), &RiskConfiguration{})
	pulumi.RegisterInputType(reflect.TypeOf((*RiskConfigurationArrayInput)(nil)).Elem(), RiskConfigurationArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*RiskConfigurationMapInput)(nil)).Elem(), RiskConfigurationMap{})
	pulumi.RegisterOutputType(RiskConfigurationOutput{})
	pulumi.RegisterOutputType(RiskConfigurationArrayOutput{})
	pulumi.RegisterOutputType(RiskConfigurationMapOutput{})
}
