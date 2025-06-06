// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package apigateway

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a settings of an API Gateway Account. Settings is applied region-wide per `provider` block.
//
// > **Note:** By default, destroying this resource will keep your account settings intact. Set `resetOnDelete` to `true` to reset the account setttings to default. In a future major version of the provider, destroying the resource will reset account settings.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/apigateway"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/iam"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			assumeRole, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
//				Statements: []iam.GetPolicyDocumentStatement{
//					{
//						Effect: pulumi.StringRef("Allow"),
//						Principals: []iam.GetPolicyDocumentStatementPrincipal{
//							{
//								Type: "Service",
//								Identifiers: []string{
//									"apigateway.amazonaws.com",
//								},
//							},
//						},
//						Actions: []string{
//							"sts:AssumeRole",
//						},
//					},
//				},
//			}, nil)
//			if err != nil {
//				return err
//			}
//			cloudwatchRole, err := iam.NewRole(ctx, "cloudwatch", &iam.RoleArgs{
//				Name:             pulumi.String("api_gateway_cloudwatch_global"),
//				AssumeRolePolicy: pulumi.String(assumeRole.Json),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = apigateway.NewAccount(ctx, "demo", &apigateway.AccountArgs{
//				CloudwatchRoleArn: cloudwatchRole.Arn,
//			})
//			if err != nil {
//				return err
//			}
//			cloudwatch, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
//				Statements: []iam.GetPolicyDocumentStatement{
//					{
//						Effect: pulumi.StringRef("Allow"),
//						Actions: []string{
//							"logs:CreateLogGroup",
//							"logs:CreateLogStream",
//							"logs:DescribeLogGroups",
//							"logs:DescribeLogStreams",
//							"logs:PutLogEvents",
//							"logs:GetLogEvents",
//							"logs:FilterLogEvents",
//						},
//						Resources: []string{
//							"*",
//						},
//					},
//				},
//			}, nil)
//			if err != nil {
//				return err
//			}
//			_, err = iam.NewRolePolicy(ctx, "cloudwatch", &iam.RolePolicyArgs{
//				Name:   pulumi.String("default"),
//				Role:   cloudwatchRole.ID(),
//				Policy: pulumi.String(cloudwatch.Json),
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
// Using `pulumi import`, import API Gateway Accounts using the word `api-gateway-account`. For example:
//
// ```sh
// $ pulumi import aws:apigateway/account:Account demo api-gateway-account
// ```
type Account struct {
	pulumi.CustomResourceState

	// The version of the API keys used for the account.
	ApiKeyVersion pulumi.StringOutput `pulumi:"apiKeyVersion"`
	// ARN of an IAM role for CloudWatch (to allow logging & monitoring). See more [in AWS Docs](https://docs.aws.amazon.com/apigateway/latest/developerguide/how-to-stage-settings.html#how-to-stage-settings-console). Logging & monitoring can be enabled/disabled and otherwise tuned on the API Gateway Stage level.
	CloudwatchRoleArn pulumi.StringOutput `pulumi:"cloudwatchRoleArn"`
	// A list of features supported for the account.
	Features pulumi.StringArrayOutput `pulumi:"features"`
	// If `true`, destroying the resource will reset account settings to default, otherwise account settings are not modified.
	// Defaults to `false`.
	// Will be removed in a future major version of the provider.
	//
	// Deprecated: The "resetOnDelete" attribute will be removed in a future version of the provider
	ResetOnDelete pulumi.BoolPtrOutput `pulumi:"resetOnDelete"`
	// Account-Level throttle settings. See exported fields below.
	ThrottleSettings AccountThrottleSettingArrayOutput `pulumi:"throttleSettings"`
}

// NewAccount registers a new resource with the given unique name, arguments, and options.
func NewAccount(ctx *pulumi.Context,
	name string, args *AccountArgs, opts ...pulumi.ResourceOption) (*Account, error) {
	if args == nil {
		args = &AccountArgs{}
	}

	opts = internal.PkgResourceDefaultOpts(opts)
	var resource Account
	err := ctx.RegisterResource("aws:apigateway/account:Account", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetAccount gets an existing Account resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetAccount(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *AccountState, opts ...pulumi.ResourceOption) (*Account, error) {
	var resource Account
	err := ctx.ReadResource("aws:apigateway/account:Account", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Account resources.
type accountState struct {
	// The version of the API keys used for the account.
	ApiKeyVersion *string `pulumi:"apiKeyVersion"`
	// ARN of an IAM role for CloudWatch (to allow logging & monitoring). See more [in AWS Docs](https://docs.aws.amazon.com/apigateway/latest/developerguide/how-to-stage-settings.html#how-to-stage-settings-console). Logging & monitoring can be enabled/disabled and otherwise tuned on the API Gateway Stage level.
	CloudwatchRoleArn *string `pulumi:"cloudwatchRoleArn"`
	// A list of features supported for the account.
	Features []string `pulumi:"features"`
	// If `true`, destroying the resource will reset account settings to default, otherwise account settings are not modified.
	// Defaults to `false`.
	// Will be removed in a future major version of the provider.
	//
	// Deprecated: The "resetOnDelete" attribute will be removed in a future version of the provider
	ResetOnDelete *bool `pulumi:"resetOnDelete"`
	// Account-Level throttle settings. See exported fields below.
	ThrottleSettings []AccountThrottleSetting `pulumi:"throttleSettings"`
}

type AccountState struct {
	// The version of the API keys used for the account.
	ApiKeyVersion pulumi.StringPtrInput
	// ARN of an IAM role for CloudWatch (to allow logging & monitoring). See more [in AWS Docs](https://docs.aws.amazon.com/apigateway/latest/developerguide/how-to-stage-settings.html#how-to-stage-settings-console). Logging & monitoring can be enabled/disabled and otherwise tuned on the API Gateway Stage level.
	CloudwatchRoleArn pulumi.StringPtrInput
	// A list of features supported for the account.
	Features pulumi.StringArrayInput
	// If `true`, destroying the resource will reset account settings to default, otherwise account settings are not modified.
	// Defaults to `false`.
	// Will be removed in a future major version of the provider.
	//
	// Deprecated: The "resetOnDelete" attribute will be removed in a future version of the provider
	ResetOnDelete pulumi.BoolPtrInput
	// Account-Level throttle settings. See exported fields below.
	ThrottleSettings AccountThrottleSettingArrayInput
}

func (AccountState) ElementType() reflect.Type {
	return reflect.TypeOf((*accountState)(nil)).Elem()
}

type accountArgs struct {
	// ARN of an IAM role for CloudWatch (to allow logging & monitoring). See more [in AWS Docs](https://docs.aws.amazon.com/apigateway/latest/developerguide/how-to-stage-settings.html#how-to-stage-settings-console). Logging & monitoring can be enabled/disabled and otherwise tuned on the API Gateway Stage level.
	CloudwatchRoleArn *string `pulumi:"cloudwatchRoleArn"`
	// If `true`, destroying the resource will reset account settings to default, otherwise account settings are not modified.
	// Defaults to `false`.
	// Will be removed in a future major version of the provider.
	//
	// Deprecated: The "resetOnDelete" attribute will be removed in a future version of the provider
	ResetOnDelete *bool `pulumi:"resetOnDelete"`
}

// The set of arguments for constructing a Account resource.
type AccountArgs struct {
	// ARN of an IAM role for CloudWatch (to allow logging & monitoring). See more [in AWS Docs](https://docs.aws.amazon.com/apigateway/latest/developerguide/how-to-stage-settings.html#how-to-stage-settings-console). Logging & monitoring can be enabled/disabled and otherwise tuned on the API Gateway Stage level.
	CloudwatchRoleArn pulumi.StringPtrInput
	// If `true`, destroying the resource will reset account settings to default, otherwise account settings are not modified.
	// Defaults to `false`.
	// Will be removed in a future major version of the provider.
	//
	// Deprecated: The "resetOnDelete" attribute will be removed in a future version of the provider
	ResetOnDelete pulumi.BoolPtrInput
}

func (AccountArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*accountArgs)(nil)).Elem()
}

type AccountInput interface {
	pulumi.Input

	ToAccountOutput() AccountOutput
	ToAccountOutputWithContext(ctx context.Context) AccountOutput
}

func (*Account) ElementType() reflect.Type {
	return reflect.TypeOf((**Account)(nil)).Elem()
}

func (i *Account) ToAccountOutput() AccountOutput {
	return i.ToAccountOutputWithContext(context.Background())
}

func (i *Account) ToAccountOutputWithContext(ctx context.Context) AccountOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AccountOutput)
}

// AccountArrayInput is an input type that accepts AccountArray and AccountArrayOutput values.
// You can construct a concrete instance of `AccountArrayInput` via:
//
//	AccountArray{ AccountArgs{...} }
type AccountArrayInput interface {
	pulumi.Input

	ToAccountArrayOutput() AccountArrayOutput
	ToAccountArrayOutputWithContext(context.Context) AccountArrayOutput
}

type AccountArray []AccountInput

func (AccountArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Account)(nil)).Elem()
}

func (i AccountArray) ToAccountArrayOutput() AccountArrayOutput {
	return i.ToAccountArrayOutputWithContext(context.Background())
}

func (i AccountArray) ToAccountArrayOutputWithContext(ctx context.Context) AccountArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AccountArrayOutput)
}

// AccountMapInput is an input type that accepts AccountMap and AccountMapOutput values.
// You can construct a concrete instance of `AccountMapInput` via:
//
//	AccountMap{ "key": AccountArgs{...} }
type AccountMapInput interface {
	pulumi.Input

	ToAccountMapOutput() AccountMapOutput
	ToAccountMapOutputWithContext(context.Context) AccountMapOutput
}

type AccountMap map[string]AccountInput

func (AccountMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Account)(nil)).Elem()
}

func (i AccountMap) ToAccountMapOutput() AccountMapOutput {
	return i.ToAccountMapOutputWithContext(context.Background())
}

func (i AccountMap) ToAccountMapOutputWithContext(ctx context.Context) AccountMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AccountMapOutput)
}

type AccountOutput struct{ *pulumi.OutputState }

func (AccountOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**Account)(nil)).Elem()
}

func (o AccountOutput) ToAccountOutput() AccountOutput {
	return o
}

func (o AccountOutput) ToAccountOutputWithContext(ctx context.Context) AccountOutput {
	return o
}

// The version of the API keys used for the account.
func (o AccountOutput) ApiKeyVersion() pulumi.StringOutput {
	return o.ApplyT(func(v *Account) pulumi.StringOutput { return v.ApiKeyVersion }).(pulumi.StringOutput)
}

// ARN of an IAM role for CloudWatch (to allow logging & monitoring). See more [in AWS Docs](https://docs.aws.amazon.com/apigateway/latest/developerguide/how-to-stage-settings.html#how-to-stage-settings-console). Logging & monitoring can be enabled/disabled and otherwise tuned on the API Gateway Stage level.
func (o AccountOutput) CloudwatchRoleArn() pulumi.StringOutput {
	return o.ApplyT(func(v *Account) pulumi.StringOutput { return v.CloudwatchRoleArn }).(pulumi.StringOutput)
}

// A list of features supported for the account.
func (o AccountOutput) Features() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *Account) pulumi.StringArrayOutput { return v.Features }).(pulumi.StringArrayOutput)
}

// If `true`, destroying the resource will reset account settings to default, otherwise account settings are not modified.
// Defaults to `false`.
// Will be removed in a future major version of the provider.
//
// Deprecated: The "resetOnDelete" attribute will be removed in a future version of the provider
func (o AccountOutput) ResetOnDelete() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v *Account) pulumi.BoolPtrOutput { return v.ResetOnDelete }).(pulumi.BoolPtrOutput)
}

// Account-Level throttle settings. See exported fields below.
func (o AccountOutput) ThrottleSettings() AccountThrottleSettingArrayOutput {
	return o.ApplyT(func(v *Account) AccountThrottleSettingArrayOutput { return v.ThrottleSettings }).(AccountThrottleSettingArrayOutput)
}

type AccountArrayOutput struct{ *pulumi.OutputState }

func (AccountArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Account)(nil)).Elem()
}

func (o AccountArrayOutput) ToAccountArrayOutput() AccountArrayOutput {
	return o
}

func (o AccountArrayOutput) ToAccountArrayOutputWithContext(ctx context.Context) AccountArrayOutput {
	return o
}

func (o AccountArrayOutput) Index(i pulumi.IntInput) AccountOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *Account {
		return vs[0].([]*Account)[vs[1].(int)]
	}).(AccountOutput)
}

type AccountMapOutput struct{ *pulumi.OutputState }

func (AccountMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Account)(nil)).Elem()
}

func (o AccountMapOutput) ToAccountMapOutput() AccountMapOutput {
	return o
}

func (o AccountMapOutput) ToAccountMapOutputWithContext(ctx context.Context) AccountMapOutput {
	return o
}

func (o AccountMapOutput) MapIndex(k pulumi.StringInput) AccountOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *Account {
		return vs[0].(map[string]*Account)[vs[1].(string)]
	}).(AccountOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*AccountInput)(nil)).Elem(), &Account{})
	pulumi.RegisterInputType(reflect.TypeOf((*AccountArrayInput)(nil)).Elem(), AccountArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*AccountMapInput)(nil)).Elem(), AccountMap{})
	pulumi.RegisterOutputType(AccountOutput{})
	pulumi.RegisterOutputType(AccountArrayOutput{})
	pulumi.RegisterOutputType(AccountMapOutput{})
}
