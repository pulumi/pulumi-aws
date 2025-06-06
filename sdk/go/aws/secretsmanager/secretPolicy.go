// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package secretsmanager

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a resource to manage AWS Secrets Manager secret policy.
//
// ## Example Usage
//
// ### Basic
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/iam"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/secretsmanager"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			exampleSecret, err := secretsmanager.NewSecret(ctx, "example", &secretsmanager.SecretArgs{
//				Name: pulumi.String("example"),
//			})
//			if err != nil {
//				return err
//			}
//			example, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
//				Statements: []iam.GetPolicyDocumentStatement{
//					{
//						Sid:    pulumi.StringRef("EnableAnotherAWSAccountToReadTheSecret"),
//						Effect: pulumi.StringRef("Allow"),
//						Principals: []iam.GetPolicyDocumentStatementPrincipal{
//							{
//								Type: "AWS",
//								Identifiers: []string{
//									"arn:aws:iam::123456789012:root",
//								},
//							},
//						},
//						Actions: []string{
//							"secretsmanager:GetSecretValue",
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
//			_, err = secretsmanager.NewSecretPolicy(ctx, "example", &secretsmanager.SecretPolicyArgs{
//				SecretArn: exampleSecret.Arn,
//				Policy:    pulumi.String(example.Json),
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
// Using `pulumi import`, import `aws_secretsmanager_secret_policy` using the secret Amazon Resource Name (ARN). For example:
//
// ```sh
// $ pulumi import aws:secretsmanager/secretPolicy:SecretPolicy example arn:aws:secretsmanager:us-east-1:123456789012:secret:example-123456
// ```
type SecretPolicy struct {
	pulumi.CustomResourceState

	// Makes an optional API call to Zelkova to validate the Resource Policy to prevent broad access to your secret.
	BlockPublicPolicy pulumi.BoolPtrOutput `pulumi:"blockPublicPolicy"`
	// Valid JSON document representing a [resource policy](https://docs.aws.amazon.com/secretsmanager/latest/userguide/auth-and-access_resource-based-policies.html). Unlike `secretsmanager.Secret`, where `policy` can be set to `"{}"` to delete the policy, `"{}"` is not a valid policy since `policy` is required.
	Policy pulumi.StringOutput `pulumi:"policy"`
	// Secret ARN.
	//
	// The following arguments are optional:
	SecretArn pulumi.StringOutput `pulumi:"secretArn"`
}

// NewSecretPolicy registers a new resource with the given unique name, arguments, and options.
func NewSecretPolicy(ctx *pulumi.Context,
	name string, args *SecretPolicyArgs, opts ...pulumi.ResourceOption) (*SecretPolicy, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.Policy == nil {
		return nil, errors.New("invalid value for required argument 'Policy'")
	}
	if args.SecretArn == nil {
		return nil, errors.New("invalid value for required argument 'SecretArn'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource SecretPolicy
	err := ctx.RegisterResource("aws:secretsmanager/secretPolicy:SecretPolicy", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetSecretPolicy gets an existing SecretPolicy resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetSecretPolicy(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *SecretPolicyState, opts ...pulumi.ResourceOption) (*SecretPolicy, error) {
	var resource SecretPolicy
	err := ctx.ReadResource("aws:secretsmanager/secretPolicy:SecretPolicy", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering SecretPolicy resources.
type secretPolicyState struct {
	// Makes an optional API call to Zelkova to validate the Resource Policy to prevent broad access to your secret.
	BlockPublicPolicy *bool `pulumi:"blockPublicPolicy"`
	// Valid JSON document representing a [resource policy](https://docs.aws.amazon.com/secretsmanager/latest/userguide/auth-and-access_resource-based-policies.html). Unlike `secretsmanager.Secret`, where `policy` can be set to `"{}"` to delete the policy, `"{}"` is not a valid policy since `policy` is required.
	Policy *string `pulumi:"policy"`
	// Secret ARN.
	//
	// The following arguments are optional:
	SecretArn *string `pulumi:"secretArn"`
}

type SecretPolicyState struct {
	// Makes an optional API call to Zelkova to validate the Resource Policy to prevent broad access to your secret.
	BlockPublicPolicy pulumi.BoolPtrInput
	// Valid JSON document representing a [resource policy](https://docs.aws.amazon.com/secretsmanager/latest/userguide/auth-and-access_resource-based-policies.html). Unlike `secretsmanager.Secret`, where `policy` can be set to `"{}"` to delete the policy, `"{}"` is not a valid policy since `policy` is required.
	Policy pulumi.StringPtrInput
	// Secret ARN.
	//
	// The following arguments are optional:
	SecretArn pulumi.StringPtrInput
}

func (SecretPolicyState) ElementType() reflect.Type {
	return reflect.TypeOf((*secretPolicyState)(nil)).Elem()
}

type secretPolicyArgs struct {
	// Makes an optional API call to Zelkova to validate the Resource Policy to prevent broad access to your secret.
	BlockPublicPolicy *bool `pulumi:"blockPublicPolicy"`
	// Valid JSON document representing a [resource policy](https://docs.aws.amazon.com/secretsmanager/latest/userguide/auth-and-access_resource-based-policies.html). Unlike `secretsmanager.Secret`, where `policy` can be set to `"{}"` to delete the policy, `"{}"` is not a valid policy since `policy` is required.
	Policy string `pulumi:"policy"`
	// Secret ARN.
	//
	// The following arguments are optional:
	SecretArn string `pulumi:"secretArn"`
}

// The set of arguments for constructing a SecretPolicy resource.
type SecretPolicyArgs struct {
	// Makes an optional API call to Zelkova to validate the Resource Policy to prevent broad access to your secret.
	BlockPublicPolicy pulumi.BoolPtrInput
	// Valid JSON document representing a [resource policy](https://docs.aws.amazon.com/secretsmanager/latest/userguide/auth-and-access_resource-based-policies.html). Unlike `secretsmanager.Secret`, where `policy` can be set to `"{}"` to delete the policy, `"{}"` is not a valid policy since `policy` is required.
	Policy pulumi.StringInput
	// Secret ARN.
	//
	// The following arguments are optional:
	SecretArn pulumi.StringInput
}

func (SecretPolicyArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*secretPolicyArgs)(nil)).Elem()
}

type SecretPolicyInput interface {
	pulumi.Input

	ToSecretPolicyOutput() SecretPolicyOutput
	ToSecretPolicyOutputWithContext(ctx context.Context) SecretPolicyOutput
}

func (*SecretPolicy) ElementType() reflect.Type {
	return reflect.TypeOf((**SecretPolicy)(nil)).Elem()
}

func (i *SecretPolicy) ToSecretPolicyOutput() SecretPolicyOutput {
	return i.ToSecretPolicyOutputWithContext(context.Background())
}

func (i *SecretPolicy) ToSecretPolicyOutputWithContext(ctx context.Context) SecretPolicyOutput {
	return pulumi.ToOutputWithContext(ctx, i).(SecretPolicyOutput)
}

// SecretPolicyArrayInput is an input type that accepts SecretPolicyArray and SecretPolicyArrayOutput values.
// You can construct a concrete instance of `SecretPolicyArrayInput` via:
//
//	SecretPolicyArray{ SecretPolicyArgs{...} }
type SecretPolicyArrayInput interface {
	pulumi.Input

	ToSecretPolicyArrayOutput() SecretPolicyArrayOutput
	ToSecretPolicyArrayOutputWithContext(context.Context) SecretPolicyArrayOutput
}

type SecretPolicyArray []SecretPolicyInput

func (SecretPolicyArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*SecretPolicy)(nil)).Elem()
}

func (i SecretPolicyArray) ToSecretPolicyArrayOutput() SecretPolicyArrayOutput {
	return i.ToSecretPolicyArrayOutputWithContext(context.Background())
}

func (i SecretPolicyArray) ToSecretPolicyArrayOutputWithContext(ctx context.Context) SecretPolicyArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(SecretPolicyArrayOutput)
}

// SecretPolicyMapInput is an input type that accepts SecretPolicyMap and SecretPolicyMapOutput values.
// You can construct a concrete instance of `SecretPolicyMapInput` via:
//
//	SecretPolicyMap{ "key": SecretPolicyArgs{...} }
type SecretPolicyMapInput interface {
	pulumi.Input

	ToSecretPolicyMapOutput() SecretPolicyMapOutput
	ToSecretPolicyMapOutputWithContext(context.Context) SecretPolicyMapOutput
}

type SecretPolicyMap map[string]SecretPolicyInput

func (SecretPolicyMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*SecretPolicy)(nil)).Elem()
}

func (i SecretPolicyMap) ToSecretPolicyMapOutput() SecretPolicyMapOutput {
	return i.ToSecretPolicyMapOutputWithContext(context.Background())
}

func (i SecretPolicyMap) ToSecretPolicyMapOutputWithContext(ctx context.Context) SecretPolicyMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(SecretPolicyMapOutput)
}

type SecretPolicyOutput struct{ *pulumi.OutputState }

func (SecretPolicyOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**SecretPolicy)(nil)).Elem()
}

func (o SecretPolicyOutput) ToSecretPolicyOutput() SecretPolicyOutput {
	return o
}

func (o SecretPolicyOutput) ToSecretPolicyOutputWithContext(ctx context.Context) SecretPolicyOutput {
	return o
}

// Makes an optional API call to Zelkova to validate the Resource Policy to prevent broad access to your secret.
func (o SecretPolicyOutput) BlockPublicPolicy() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v *SecretPolicy) pulumi.BoolPtrOutput { return v.BlockPublicPolicy }).(pulumi.BoolPtrOutput)
}

// Valid JSON document representing a [resource policy](https://docs.aws.amazon.com/secretsmanager/latest/userguide/auth-and-access_resource-based-policies.html). Unlike `secretsmanager.Secret`, where `policy` can be set to `"{}"` to delete the policy, `"{}"` is not a valid policy since `policy` is required.
func (o SecretPolicyOutput) Policy() pulumi.StringOutput {
	return o.ApplyT(func(v *SecretPolicy) pulumi.StringOutput { return v.Policy }).(pulumi.StringOutput)
}

// Secret ARN.
//
// The following arguments are optional:
func (o SecretPolicyOutput) SecretArn() pulumi.StringOutput {
	return o.ApplyT(func(v *SecretPolicy) pulumi.StringOutput { return v.SecretArn }).(pulumi.StringOutput)
}

type SecretPolicyArrayOutput struct{ *pulumi.OutputState }

func (SecretPolicyArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*SecretPolicy)(nil)).Elem()
}

func (o SecretPolicyArrayOutput) ToSecretPolicyArrayOutput() SecretPolicyArrayOutput {
	return o
}

func (o SecretPolicyArrayOutput) ToSecretPolicyArrayOutputWithContext(ctx context.Context) SecretPolicyArrayOutput {
	return o
}

func (o SecretPolicyArrayOutput) Index(i pulumi.IntInput) SecretPolicyOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *SecretPolicy {
		return vs[0].([]*SecretPolicy)[vs[1].(int)]
	}).(SecretPolicyOutput)
}

type SecretPolicyMapOutput struct{ *pulumi.OutputState }

func (SecretPolicyMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*SecretPolicy)(nil)).Elem()
}

func (o SecretPolicyMapOutput) ToSecretPolicyMapOutput() SecretPolicyMapOutput {
	return o
}

func (o SecretPolicyMapOutput) ToSecretPolicyMapOutputWithContext(ctx context.Context) SecretPolicyMapOutput {
	return o
}

func (o SecretPolicyMapOutput) MapIndex(k pulumi.StringInput) SecretPolicyOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *SecretPolicy {
		return vs[0].(map[string]*SecretPolicy)[vs[1].(string)]
	}).(SecretPolicyOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*SecretPolicyInput)(nil)).Elem(), &SecretPolicy{})
	pulumi.RegisterInputType(reflect.TypeOf((*SecretPolicyArrayInput)(nil)).Elem(), SecretPolicyArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*SecretPolicyMapInput)(nil)).Elem(), SecretPolicyMap{})
	pulumi.RegisterOutputType(SecretPolicyOutput{})
	pulumi.RegisterOutputType(SecretPolicyArrayOutput{})
	pulumi.RegisterOutputType(SecretPolicyMapOutput{})
}
