// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package lambda

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Gives an external source (like an EventBridge Rule, SNS, or S3) permission to access the Lambda function.
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
//	"encoding/json"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/iam"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/lambda"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			tmpJSON0, err := json.Marshal(map[string]interface{}{
//				"Version": "2012-10-17",
//				"Statement": []map[string]interface{}{
//					map[string]interface{}{
//						"Action": "sts:AssumeRole",
//						"Effect": "Allow",
//						"Sid":    "",
//						"Principal": map[string]interface{}{
//							"Service": "lambda.amazonaws.com",
//						},
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			json0 := string(tmpJSON0)
//			iamForLambda, err := iam.NewRole(ctx, "iam_for_lambda", &iam.RoleArgs{
//				Name:             pulumi.String("iam_for_lambda"),
//				AssumeRolePolicy: pulumi.String(json0),
//			})
//			if err != nil {
//				return err
//			}
//			testLambda, err := lambda.NewFunction(ctx, "test_lambda", &lambda.FunctionArgs{
//				Code:    pulumi.NewFileArchive("lambdatest.zip"),
//				Name:    pulumi.String("lambda_function_name"),
//				Role:    iamForLambda.Arn,
//				Handler: pulumi.String("exports.handler"),
//				Runtime: pulumi.String(lambda.RuntimeNodeJS20dX),
//			})
//			if err != nil {
//				return err
//			}
//			testAlias, err := lambda.NewAlias(ctx, "test_alias", &lambda.AliasArgs{
//				Name:            pulumi.String("testalias"),
//				Description:     pulumi.String("a sample description"),
//				FunctionName:    testLambda.Name,
//				FunctionVersion: pulumi.String("$LATEST"),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = lambda.NewPermission(ctx, "allow_cloudwatch", &lambda.PermissionArgs{
//				StatementId: pulumi.String("AllowExecutionFromCloudWatch"),
//				Action:      pulumi.String("lambda:InvokeFunction"),
//				Function:    testLambda.Name,
//				Principal:   pulumi.String("events.amazonaws.com"),
//				SourceArn:   pulumi.String("arn:aws:events:eu-west-1:111122223333:rule/RunDaily"),
//				Qualifier:   testAlias.Name,
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
// ### With SNS
//
// ```go
// package main
//
// import (
//
//	"encoding/json"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/iam"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/lambda"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/sns"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_default, err := sns.NewTopic(ctx, "default", &sns.TopicArgs{
//				Name: pulumi.String("call-lambda-maybe"),
//			})
//			if err != nil {
//				return err
//			}
//			tmpJSON0, err := json.Marshal(map[string]interface{}{
//				"Version": "2012-10-17",
//				"Statement": []map[string]interface{}{
//					map[string]interface{}{
//						"Action": "sts:AssumeRole",
//						"Effect": "Allow",
//						"Sid":    "",
//						"Principal": map[string]interface{}{
//							"Service": "lambda.amazonaws.com",
//						},
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			json0 := string(tmpJSON0)
//			defaultRole, err := iam.NewRole(ctx, "default", &iam.RoleArgs{
//				Name:             pulumi.String("iam_for_lambda_with_sns"),
//				AssumeRolePolicy: pulumi.String(json0),
//			})
//			if err != nil {
//				return err
//			}
//			_func, err := lambda.NewFunction(ctx, "func", &lambda.FunctionArgs{
//				Code:    pulumi.NewFileArchive("lambdatest.zip"),
//				Name:    pulumi.String("lambda_called_from_sns"),
//				Role:    defaultRole.Arn,
//				Handler: pulumi.String("exports.handler"),
//				Runtime: pulumi.String(lambda.RuntimePython3d12),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = lambda.NewPermission(ctx, "with_sns", &lambda.PermissionArgs{
//				StatementId: pulumi.String("AllowExecutionFromSNS"),
//				Action:      pulumi.String("lambda:InvokeFunction"),
//				Function:    _func.Name,
//				Principal:   pulumi.String("sns.amazonaws.com"),
//				SourceArn:   _default.Arn,
//			})
//			if err != nil {
//				return err
//			}
//			_, err = sns.NewTopicSubscription(ctx, "lambda", &sns.TopicSubscriptionArgs{
//				Topic:    _default.Arn,
//				Protocol: pulumi.String("lambda"),
//				Endpoint: _func.Arn,
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
// ### With API Gateway REST API
//
// ```go
// package main
//
// import (
//
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/apigateway"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/lambda"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			myDemoAPI, err := apigateway.NewRestApi(ctx, "MyDemoAPI", &apigateway.RestApiArgs{
//				Name:        pulumi.String("MyDemoAPI"),
//				Description: pulumi.String("This is my API for demonstration purposes"),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = lambda.NewPermission(ctx, "lambda_permission", &lambda.PermissionArgs{
//				StatementId: pulumi.String("AllowMyDemoAPIInvoke"),
//				Action:      pulumi.String("lambda:InvokeFunction"),
//				Function:    pulumi.Any("MyDemoFunction"),
//				Principal:   pulumi.String("apigateway.amazonaws.com"),
//				SourceArn: myDemoAPI.ExecutionArn.ApplyT(func(executionArn string) (string, error) {
//					return fmt.Sprintf("%v/*", executionArn), nil
//				}).(pulumi.StringOutput),
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
// ### With CloudWatch Log Group
//
// ```go
// package main
//
// import (
//
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/cloudwatch"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/iam"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/lambda"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_default, err := cloudwatch.NewLogGroup(ctx, "default", &cloudwatch.LogGroupArgs{
//				Name: pulumi.String("/default"),
//			})
//			if err != nil {
//				return err
//			}
//			assumeRole, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
//				Statements: []iam.GetPolicyDocumentStatement{
//					{
//						Effect: pulumi.StringRef("Allow"),
//						Principals: []iam.GetPolicyDocumentStatementPrincipal{
//							{
//								Type: "Service",
//								Identifiers: []string{
//									"lambda.amazonaws.com",
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
//			defaultRole, err := iam.NewRole(ctx, "default", &iam.RoleArgs{
//				Name:             pulumi.String("iam_for_lambda_called_from_cloudwatch_logs"),
//				AssumeRolePolicy: pulumi.String(assumeRole.Json),
//			})
//			if err != nil {
//				return err
//			}
//			loggingFunction, err := lambda.NewFunction(ctx, "logging", &lambda.FunctionArgs{
//				Code:    pulumi.NewFileArchive("lamba_logging.zip"),
//				Name:    pulumi.String("lambda_called_from_cloudwatch_logs"),
//				Handler: pulumi.String("exports.handler"),
//				Role:    defaultRole.Arn,
//				Runtime: pulumi.String(lambda.RuntimePython3d12),
//			})
//			if err != nil {
//				return err
//			}
//			logging, err := lambda.NewPermission(ctx, "logging", &lambda.PermissionArgs{
//				Action:    pulumi.String("lambda:InvokeFunction"),
//				Function:  loggingFunction.Name,
//				Principal: pulumi.String("logs.eu-west-1.amazonaws.com"),
//				SourceArn: _default.Arn.ApplyT(func(arn string) (string, error) {
//					return fmt.Sprintf("%v:*", arn), nil
//				}).(pulumi.StringOutput),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = cloudwatch.NewLogSubscriptionFilter(ctx, "logging", &cloudwatch.LogSubscriptionFilterArgs{
//				DestinationArn: loggingFunction.Arn,
//				FilterPattern:  pulumi.String(""),
//				LogGroup:       _default.Name,
//				Name:           pulumi.String("logging_default"),
//			}, pulumi.DependsOn([]pulumi.Resource{
//				logging,
//			}))
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// ### With Cross-Account Invocation Policy
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/lambda"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := lambda.NewFunctionUrl(ctx, "url", &lambda.FunctionUrlArgs{
//				FunctionName:      pulumi.Any(example.FunctionName),
//				AuthorizationType: pulumi.String("AWS_IAM"),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = lambda.NewPermission(ctx, "url", &lambda.PermissionArgs{
//				Action:              pulumi.String("lambda:InvokeFunctionUrl"),
//				Function:            pulumi.Any(example.FunctionName),
//				Principal:           pulumi.String("arn:aws:iam::444455556666:role/example"),
//				SourceAccount:       pulumi.String("444455556666"),
//				FunctionUrlAuthType: pulumi.String("AWS_IAM"),
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
// Using `pulumi import`, import Lambda permission statements using function_name/statement_id with an optional qualifier. For example:
//
// ```sh
// $ pulumi import aws:lambda/permission:Permission test_lambda_permission my_test_lambda_function/AllowExecutionFromCloudWatch
// ```
// ```sh
// $ pulumi import aws:lambda/permission:Permission test_lambda_permission my_test_lambda_function:qualifier_name/AllowExecutionFromCloudWatch
// ```
type Permission struct {
	pulumi.CustomResourceState

	// The AWS Lambda action you want to allow in this statement. (e.g., `lambda:InvokeFunction`)
	Action pulumi.StringOutput `pulumi:"action"`
	// The Event Source Token to validate.  Used with [Alexa Skills](https://developer.amazon.com/docs/custom-skills/host-a-custom-skill-as-an-aws-lambda-function.html#use-aws-cli).
	EventSourceToken pulumi.StringPtrOutput `pulumi:"eventSourceToken"`
	// Name of the Lambda function whose resource policy you are updating
	Function pulumi.StringOutput `pulumi:"function"`
	// Lambda Function URLs [authentication type](https://docs.aws.amazon.com/lambda/latest/dg/urls-auth.html). Valid values are: `AWS_IAM` or `NONE`. Only supported for `lambda:InvokeFunctionUrl` action.
	FunctionUrlAuthType pulumi.StringPtrOutput `pulumi:"functionUrlAuthType"`
	// The principal who is getting this permission e.g., `s3.amazonaws.com`, an AWS account ID, or AWS IAM principal, or AWS service principal such as `events.amazonaws.com` or `sns.amazonaws.com`.
	Principal pulumi.StringOutput `pulumi:"principal"`
	// The identifier for your organization in AWS Organizations. Use this to grant permissions to all the AWS accounts under this organization.
	//
	// [1]: https://developer.amazon.com/docs/custom-skills/host-a-custom-skill-as-an-aws-lambda-function.html#use-aws-cli
	// [2]: https://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-control-access-using-iam-policies-to-invoke-api.html
	// [3]: https://docs.aws.amazon.com/lambda/latest/dg/urls-auth.html
	PrincipalOrgId pulumi.StringPtrOutput `pulumi:"principalOrgId"`
	// Query parameter to specify function version or alias name. The permission will then apply to the specific qualified ARN e.g., `arn:aws:lambda:aws-region:acct-id:function:function-name:2`
	Qualifier pulumi.StringPtrOutput `pulumi:"qualifier"`
	// This parameter is used when allowing cross-account access, or for S3 and SES. The AWS account ID (without a hyphen) of the source owner.
	SourceAccount pulumi.StringPtrOutput `pulumi:"sourceAccount"`
	// When the principal is an AWS service, the ARN of the specific resource within that service to grant permission to.
	// Without this, any resource from `principal` will be granted permission – even if that resource is from another account.
	// For S3, this should be the ARN of the S3 Bucket.
	// For EventBridge events, this should be the ARN of the EventBridge Rule.
	// For API Gateway, this should be the ARN of the API, as described [here](https://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-control-access-using-iam-policies-to-invoke-api.html).
	SourceArn pulumi.StringPtrOutput `pulumi:"sourceArn"`
	// A unique statement identifier. By default generated by the provider.
	StatementId pulumi.StringOutput `pulumi:"statementId"`
	// A statement identifier prefix. The provider will generate a unique suffix. Conflicts with `statementId`.
	StatementIdPrefix pulumi.StringOutput `pulumi:"statementIdPrefix"`
}

// NewPermission registers a new resource with the given unique name, arguments, and options.
func NewPermission(ctx *pulumi.Context,
	name string, args *PermissionArgs, opts ...pulumi.ResourceOption) (*Permission, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.Action == nil {
		return nil, errors.New("invalid value for required argument 'Action'")
	}
	if args.Function == nil {
		return nil, errors.New("invalid value for required argument 'Function'")
	}
	if args.Principal == nil {
		return nil, errors.New("invalid value for required argument 'Principal'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource Permission
	err := ctx.RegisterResource("aws:lambda/permission:Permission", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetPermission gets an existing Permission resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetPermission(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *PermissionState, opts ...pulumi.ResourceOption) (*Permission, error) {
	var resource Permission
	err := ctx.ReadResource("aws:lambda/permission:Permission", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Permission resources.
type permissionState struct {
	// The AWS Lambda action you want to allow in this statement. (e.g., `lambda:InvokeFunction`)
	Action *string `pulumi:"action"`
	// The Event Source Token to validate.  Used with [Alexa Skills](https://developer.amazon.com/docs/custom-skills/host-a-custom-skill-as-an-aws-lambda-function.html#use-aws-cli).
	EventSourceToken *string `pulumi:"eventSourceToken"`
	// Name of the Lambda function whose resource policy you are updating
	Function interface{} `pulumi:"function"`
	// Lambda Function URLs [authentication type](https://docs.aws.amazon.com/lambda/latest/dg/urls-auth.html). Valid values are: `AWS_IAM` or `NONE`. Only supported for `lambda:InvokeFunctionUrl` action.
	FunctionUrlAuthType *string `pulumi:"functionUrlAuthType"`
	// The principal who is getting this permission e.g., `s3.amazonaws.com`, an AWS account ID, or AWS IAM principal, or AWS service principal such as `events.amazonaws.com` or `sns.amazonaws.com`.
	Principal *string `pulumi:"principal"`
	// The identifier for your organization in AWS Organizations. Use this to grant permissions to all the AWS accounts under this organization.
	//
	// [1]: https://developer.amazon.com/docs/custom-skills/host-a-custom-skill-as-an-aws-lambda-function.html#use-aws-cli
	// [2]: https://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-control-access-using-iam-policies-to-invoke-api.html
	// [3]: https://docs.aws.amazon.com/lambda/latest/dg/urls-auth.html
	PrincipalOrgId *string `pulumi:"principalOrgId"`
	// Query parameter to specify function version or alias name. The permission will then apply to the specific qualified ARN e.g., `arn:aws:lambda:aws-region:acct-id:function:function-name:2`
	Qualifier *string `pulumi:"qualifier"`
	// This parameter is used when allowing cross-account access, or for S3 and SES. The AWS account ID (without a hyphen) of the source owner.
	SourceAccount *string `pulumi:"sourceAccount"`
	// When the principal is an AWS service, the ARN of the specific resource within that service to grant permission to.
	// Without this, any resource from `principal` will be granted permission – even if that resource is from another account.
	// For S3, this should be the ARN of the S3 Bucket.
	// For EventBridge events, this should be the ARN of the EventBridge Rule.
	// For API Gateway, this should be the ARN of the API, as described [here](https://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-control-access-using-iam-policies-to-invoke-api.html).
	SourceArn *string `pulumi:"sourceArn"`
	// A unique statement identifier. By default generated by the provider.
	StatementId *string `pulumi:"statementId"`
	// A statement identifier prefix. The provider will generate a unique suffix. Conflicts with `statementId`.
	StatementIdPrefix *string `pulumi:"statementIdPrefix"`
}

type PermissionState struct {
	// The AWS Lambda action you want to allow in this statement. (e.g., `lambda:InvokeFunction`)
	Action pulumi.StringPtrInput
	// The Event Source Token to validate.  Used with [Alexa Skills](https://developer.amazon.com/docs/custom-skills/host-a-custom-skill-as-an-aws-lambda-function.html#use-aws-cli).
	EventSourceToken pulumi.StringPtrInput
	// Name of the Lambda function whose resource policy you are updating
	Function pulumi.Input
	// Lambda Function URLs [authentication type](https://docs.aws.amazon.com/lambda/latest/dg/urls-auth.html). Valid values are: `AWS_IAM` or `NONE`. Only supported for `lambda:InvokeFunctionUrl` action.
	FunctionUrlAuthType pulumi.StringPtrInput
	// The principal who is getting this permission e.g., `s3.amazonaws.com`, an AWS account ID, or AWS IAM principal, or AWS service principal such as `events.amazonaws.com` or `sns.amazonaws.com`.
	Principal pulumi.StringPtrInput
	// The identifier for your organization in AWS Organizations. Use this to grant permissions to all the AWS accounts under this organization.
	//
	// [1]: https://developer.amazon.com/docs/custom-skills/host-a-custom-skill-as-an-aws-lambda-function.html#use-aws-cli
	// [2]: https://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-control-access-using-iam-policies-to-invoke-api.html
	// [3]: https://docs.aws.amazon.com/lambda/latest/dg/urls-auth.html
	PrincipalOrgId pulumi.StringPtrInput
	// Query parameter to specify function version or alias name. The permission will then apply to the specific qualified ARN e.g., `arn:aws:lambda:aws-region:acct-id:function:function-name:2`
	Qualifier pulumi.StringPtrInput
	// This parameter is used when allowing cross-account access, or for S3 and SES. The AWS account ID (without a hyphen) of the source owner.
	SourceAccount pulumi.StringPtrInput
	// When the principal is an AWS service, the ARN of the specific resource within that service to grant permission to.
	// Without this, any resource from `principal` will be granted permission – even if that resource is from another account.
	// For S3, this should be the ARN of the S3 Bucket.
	// For EventBridge events, this should be the ARN of the EventBridge Rule.
	// For API Gateway, this should be the ARN of the API, as described [here](https://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-control-access-using-iam-policies-to-invoke-api.html).
	SourceArn pulumi.StringPtrInput
	// A unique statement identifier. By default generated by the provider.
	StatementId pulumi.StringPtrInput
	// A statement identifier prefix. The provider will generate a unique suffix. Conflicts with `statementId`.
	StatementIdPrefix pulumi.StringPtrInput
}

func (PermissionState) ElementType() reflect.Type {
	return reflect.TypeOf((*permissionState)(nil)).Elem()
}

type permissionArgs struct {
	// The AWS Lambda action you want to allow in this statement. (e.g., `lambda:InvokeFunction`)
	Action string `pulumi:"action"`
	// The Event Source Token to validate.  Used with [Alexa Skills](https://developer.amazon.com/docs/custom-skills/host-a-custom-skill-as-an-aws-lambda-function.html#use-aws-cli).
	EventSourceToken *string `pulumi:"eventSourceToken"`
	// Name of the Lambda function whose resource policy you are updating
	Function interface{} `pulumi:"function"`
	// Lambda Function URLs [authentication type](https://docs.aws.amazon.com/lambda/latest/dg/urls-auth.html). Valid values are: `AWS_IAM` or `NONE`. Only supported for `lambda:InvokeFunctionUrl` action.
	FunctionUrlAuthType *string `pulumi:"functionUrlAuthType"`
	// The principal who is getting this permission e.g., `s3.amazonaws.com`, an AWS account ID, or AWS IAM principal, or AWS service principal such as `events.amazonaws.com` or `sns.amazonaws.com`.
	Principal string `pulumi:"principal"`
	// The identifier for your organization in AWS Organizations. Use this to grant permissions to all the AWS accounts under this organization.
	//
	// [1]: https://developer.amazon.com/docs/custom-skills/host-a-custom-skill-as-an-aws-lambda-function.html#use-aws-cli
	// [2]: https://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-control-access-using-iam-policies-to-invoke-api.html
	// [3]: https://docs.aws.amazon.com/lambda/latest/dg/urls-auth.html
	PrincipalOrgId *string `pulumi:"principalOrgId"`
	// Query parameter to specify function version or alias name. The permission will then apply to the specific qualified ARN e.g., `arn:aws:lambda:aws-region:acct-id:function:function-name:2`
	Qualifier *string `pulumi:"qualifier"`
	// This parameter is used when allowing cross-account access, or for S3 and SES. The AWS account ID (without a hyphen) of the source owner.
	SourceAccount *string `pulumi:"sourceAccount"`
	// When the principal is an AWS service, the ARN of the specific resource within that service to grant permission to.
	// Without this, any resource from `principal` will be granted permission – even if that resource is from another account.
	// For S3, this should be the ARN of the S3 Bucket.
	// For EventBridge events, this should be the ARN of the EventBridge Rule.
	// For API Gateway, this should be the ARN of the API, as described [here](https://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-control-access-using-iam-policies-to-invoke-api.html).
	SourceArn *string `pulumi:"sourceArn"`
	// A unique statement identifier. By default generated by the provider.
	StatementId *string `pulumi:"statementId"`
	// A statement identifier prefix. The provider will generate a unique suffix. Conflicts with `statementId`.
	StatementIdPrefix *string `pulumi:"statementIdPrefix"`
}

// The set of arguments for constructing a Permission resource.
type PermissionArgs struct {
	// The AWS Lambda action you want to allow in this statement. (e.g., `lambda:InvokeFunction`)
	Action pulumi.StringInput
	// The Event Source Token to validate.  Used with [Alexa Skills](https://developer.amazon.com/docs/custom-skills/host-a-custom-skill-as-an-aws-lambda-function.html#use-aws-cli).
	EventSourceToken pulumi.StringPtrInput
	// Name of the Lambda function whose resource policy you are updating
	Function pulumi.Input
	// Lambda Function URLs [authentication type](https://docs.aws.amazon.com/lambda/latest/dg/urls-auth.html). Valid values are: `AWS_IAM` or `NONE`. Only supported for `lambda:InvokeFunctionUrl` action.
	FunctionUrlAuthType pulumi.StringPtrInput
	// The principal who is getting this permission e.g., `s3.amazonaws.com`, an AWS account ID, or AWS IAM principal, or AWS service principal such as `events.amazonaws.com` or `sns.amazonaws.com`.
	Principal pulumi.StringInput
	// The identifier for your organization in AWS Organizations. Use this to grant permissions to all the AWS accounts under this organization.
	//
	// [1]: https://developer.amazon.com/docs/custom-skills/host-a-custom-skill-as-an-aws-lambda-function.html#use-aws-cli
	// [2]: https://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-control-access-using-iam-policies-to-invoke-api.html
	// [3]: https://docs.aws.amazon.com/lambda/latest/dg/urls-auth.html
	PrincipalOrgId pulumi.StringPtrInput
	// Query parameter to specify function version or alias name. The permission will then apply to the specific qualified ARN e.g., `arn:aws:lambda:aws-region:acct-id:function:function-name:2`
	Qualifier pulumi.StringPtrInput
	// This parameter is used when allowing cross-account access, or for S3 and SES. The AWS account ID (without a hyphen) of the source owner.
	SourceAccount pulumi.StringPtrInput
	// When the principal is an AWS service, the ARN of the specific resource within that service to grant permission to.
	// Without this, any resource from `principal` will be granted permission – even if that resource is from another account.
	// For S3, this should be the ARN of the S3 Bucket.
	// For EventBridge events, this should be the ARN of the EventBridge Rule.
	// For API Gateway, this should be the ARN of the API, as described [here](https://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-control-access-using-iam-policies-to-invoke-api.html).
	SourceArn pulumi.StringPtrInput
	// A unique statement identifier. By default generated by the provider.
	StatementId pulumi.StringPtrInput
	// A statement identifier prefix. The provider will generate a unique suffix. Conflicts with `statementId`.
	StatementIdPrefix pulumi.StringPtrInput
}

func (PermissionArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*permissionArgs)(nil)).Elem()
}

type PermissionInput interface {
	pulumi.Input

	ToPermissionOutput() PermissionOutput
	ToPermissionOutputWithContext(ctx context.Context) PermissionOutput
}

func (*Permission) ElementType() reflect.Type {
	return reflect.TypeOf((**Permission)(nil)).Elem()
}

func (i *Permission) ToPermissionOutput() PermissionOutput {
	return i.ToPermissionOutputWithContext(context.Background())
}

func (i *Permission) ToPermissionOutputWithContext(ctx context.Context) PermissionOutput {
	return pulumi.ToOutputWithContext(ctx, i).(PermissionOutput)
}

// PermissionArrayInput is an input type that accepts PermissionArray and PermissionArrayOutput values.
// You can construct a concrete instance of `PermissionArrayInput` via:
//
//	PermissionArray{ PermissionArgs{...} }
type PermissionArrayInput interface {
	pulumi.Input

	ToPermissionArrayOutput() PermissionArrayOutput
	ToPermissionArrayOutputWithContext(context.Context) PermissionArrayOutput
}

type PermissionArray []PermissionInput

func (PermissionArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Permission)(nil)).Elem()
}

func (i PermissionArray) ToPermissionArrayOutput() PermissionArrayOutput {
	return i.ToPermissionArrayOutputWithContext(context.Background())
}

func (i PermissionArray) ToPermissionArrayOutputWithContext(ctx context.Context) PermissionArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(PermissionArrayOutput)
}

// PermissionMapInput is an input type that accepts PermissionMap and PermissionMapOutput values.
// You can construct a concrete instance of `PermissionMapInput` via:
//
//	PermissionMap{ "key": PermissionArgs{...} }
type PermissionMapInput interface {
	pulumi.Input

	ToPermissionMapOutput() PermissionMapOutput
	ToPermissionMapOutputWithContext(context.Context) PermissionMapOutput
}

type PermissionMap map[string]PermissionInput

func (PermissionMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Permission)(nil)).Elem()
}

func (i PermissionMap) ToPermissionMapOutput() PermissionMapOutput {
	return i.ToPermissionMapOutputWithContext(context.Background())
}

func (i PermissionMap) ToPermissionMapOutputWithContext(ctx context.Context) PermissionMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(PermissionMapOutput)
}

type PermissionOutput struct{ *pulumi.OutputState }

func (PermissionOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**Permission)(nil)).Elem()
}

func (o PermissionOutput) ToPermissionOutput() PermissionOutput {
	return o
}

func (o PermissionOutput) ToPermissionOutputWithContext(ctx context.Context) PermissionOutput {
	return o
}

// The AWS Lambda action you want to allow in this statement. (e.g., `lambda:InvokeFunction`)
func (o PermissionOutput) Action() pulumi.StringOutput {
	return o.ApplyT(func(v *Permission) pulumi.StringOutput { return v.Action }).(pulumi.StringOutput)
}

// The Event Source Token to validate.  Used with [Alexa Skills](https://developer.amazon.com/docs/custom-skills/host-a-custom-skill-as-an-aws-lambda-function.html#use-aws-cli).
func (o PermissionOutput) EventSourceToken() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *Permission) pulumi.StringPtrOutput { return v.EventSourceToken }).(pulumi.StringPtrOutput)
}

// Name of the Lambda function whose resource policy you are updating
func (o PermissionOutput) Function() pulumi.StringOutput {
	return o.ApplyT(func(v *Permission) pulumi.StringOutput { return v.Function }).(pulumi.StringOutput)
}

// Lambda Function URLs [authentication type](https://docs.aws.amazon.com/lambda/latest/dg/urls-auth.html). Valid values are: `AWS_IAM` or `NONE`. Only supported for `lambda:InvokeFunctionUrl` action.
func (o PermissionOutput) FunctionUrlAuthType() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *Permission) pulumi.StringPtrOutput { return v.FunctionUrlAuthType }).(pulumi.StringPtrOutput)
}

// The principal who is getting this permission e.g., `s3.amazonaws.com`, an AWS account ID, or AWS IAM principal, or AWS service principal such as `events.amazonaws.com` or `sns.amazonaws.com`.
func (o PermissionOutput) Principal() pulumi.StringOutput {
	return o.ApplyT(func(v *Permission) pulumi.StringOutput { return v.Principal }).(pulumi.StringOutput)
}

// The identifier for your organization in AWS Organizations. Use this to grant permissions to all the AWS accounts under this organization.
//
// [1]: https://developer.amazon.com/docs/custom-skills/host-a-custom-skill-as-an-aws-lambda-function.html#use-aws-cli
// [2]: https://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-control-access-using-iam-policies-to-invoke-api.html
// [3]: https://docs.aws.amazon.com/lambda/latest/dg/urls-auth.html
func (o PermissionOutput) PrincipalOrgId() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *Permission) pulumi.StringPtrOutput { return v.PrincipalOrgId }).(pulumi.StringPtrOutput)
}

// Query parameter to specify function version or alias name. The permission will then apply to the specific qualified ARN e.g., `arn:aws:lambda:aws-region:acct-id:function:function-name:2`
func (o PermissionOutput) Qualifier() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *Permission) pulumi.StringPtrOutput { return v.Qualifier }).(pulumi.StringPtrOutput)
}

// This parameter is used when allowing cross-account access, or for S3 and SES. The AWS account ID (without a hyphen) of the source owner.
func (o PermissionOutput) SourceAccount() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *Permission) pulumi.StringPtrOutput { return v.SourceAccount }).(pulumi.StringPtrOutput)
}

// When the principal is an AWS service, the ARN of the specific resource within that service to grant permission to.
// Without this, any resource from `principal` will be granted permission – even if that resource is from another account.
// For S3, this should be the ARN of the S3 Bucket.
// For EventBridge events, this should be the ARN of the EventBridge Rule.
// For API Gateway, this should be the ARN of the API, as described [here](https://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-control-access-using-iam-policies-to-invoke-api.html).
func (o PermissionOutput) SourceArn() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *Permission) pulumi.StringPtrOutput { return v.SourceArn }).(pulumi.StringPtrOutput)
}

// A unique statement identifier. By default generated by the provider.
func (o PermissionOutput) StatementId() pulumi.StringOutput {
	return o.ApplyT(func(v *Permission) pulumi.StringOutput { return v.StatementId }).(pulumi.StringOutput)
}

// A statement identifier prefix. The provider will generate a unique suffix. Conflicts with `statementId`.
func (o PermissionOutput) StatementIdPrefix() pulumi.StringOutput {
	return o.ApplyT(func(v *Permission) pulumi.StringOutput { return v.StatementIdPrefix }).(pulumi.StringOutput)
}

type PermissionArrayOutput struct{ *pulumi.OutputState }

func (PermissionArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Permission)(nil)).Elem()
}

func (o PermissionArrayOutput) ToPermissionArrayOutput() PermissionArrayOutput {
	return o
}

func (o PermissionArrayOutput) ToPermissionArrayOutputWithContext(ctx context.Context) PermissionArrayOutput {
	return o
}

func (o PermissionArrayOutput) Index(i pulumi.IntInput) PermissionOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *Permission {
		return vs[0].([]*Permission)[vs[1].(int)]
	}).(PermissionOutput)
}

type PermissionMapOutput struct{ *pulumi.OutputState }

func (PermissionMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Permission)(nil)).Elem()
}

func (o PermissionMapOutput) ToPermissionMapOutput() PermissionMapOutput {
	return o
}

func (o PermissionMapOutput) ToPermissionMapOutputWithContext(ctx context.Context) PermissionMapOutput {
	return o
}

func (o PermissionMapOutput) MapIndex(k pulumi.StringInput) PermissionOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *Permission {
		return vs[0].(map[string]*Permission)[vs[1].(string)]
	}).(PermissionOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*PermissionInput)(nil)).Elem(), &Permission{})
	pulumi.RegisterInputType(reflect.TypeOf((*PermissionArrayInput)(nil)).Elem(), PermissionArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*PermissionMapInput)(nil)).Elem(), PermissionMap{})
	pulumi.RegisterOutputType(PermissionOutput{})
	pulumi.RegisterOutputType(PermissionArrayOutput{})
	pulumi.RegisterOutputType(PermissionMapOutput{})
}
