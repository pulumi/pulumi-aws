// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package main

import (
	"github.com/pulumi/pulumi-aws/sdk/go/aws"
	"github.com/pulumi/pulumi-aws/sdk/go/aws/apigateway"
	"github.com/pulumi/pulumi-aws/sdk/go/aws/cloudwatch"
	"github.com/pulumi/pulumi-aws/sdk/go/aws/dynamodb"
	"github.com/pulumi/pulumi-aws/sdk/go/aws/iam"
	"github.com/pulumi/pulumi-aws/sdk/go/aws/lambda"
	"github.com/pulumi/pulumi/sdk/go/pulumi"
	"github.com/pulumi/pulumi/sdk/go/pulumi/config"
)

const lambdaFullAccess = "arn:aws:iam::aws:policy/AWSLambdaFullAccess"
const nodeJS12dXRuntime = "nodejs12.x"

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		cfg := config.New(ctx, "aws")
		region := cfg.Require("envRegion")
		provider, err := aws.NewProvider(ctx, "prov", &aws.ProviderArgs{
			Region: pulumi.String(region),
		})
		if err != nil {
			return err
		}
		providerOpts := []pulumi.ResourceOption{pulumi.Provider(provider)}

		role, err := iam.NewRole(ctx, "mylambda-role", &iam.RoleArgs{
			AssumeRolePolicy: pulumi.Any(map[string]interface{}{
				"Version": "2012-10-17",
				"Statement": []interface{}{
					map[string]interface{}{
						"Action": "sts:AssumeRole",
						"Principal": map[string]interface{}{
							"Service": "lambda.amazonaws.com",
						},
						"Effect": "Allow",
						"Sid":    "",
					},
				},
			}),
		}, providerOpts...)
		if err != nil {
			return err
		}

		_, err = iam.NewRolePolicyAttachment(ctx, "mylambda-access", &iam.RolePolicyAttachmentArgs{
			Role:      role.ID(),
			PolicyArn: pulumi.String(lambdaFullAccess),
		}, providerOpts...)
		if err != nil {
			return err
		}

		lambdaFn, err := lambda.NewFunction(ctx, "mylambda", &lambda.FunctionArgs{
			Code: pulumi.NewAssetArchive(map[string]interface{}{
				"index.js": pulumi.NewStringAsset(
					"exports.handler = (e, c, cb) => {console.log(JSON.stringify(e)); cb(null, {statusCode: 200, body: 'Hello, world!'});};",
				),
			}),
			Role:    role.Arn,
			Handler: pulumi.String("index.handler"),
			Runtime: pulumi.String(nodeJS12dXRuntime),
		}, providerOpts...)
		if err != nil {
			return err
		}

		logGroup, err := cloudwatch.NewLogGroup(ctx, "/aws/lambda/mylambda", &cloudwatch.LogGroupArgs{
			RetentionInDays: pulumi.Int(7),
		}, providerOpts...)
		if err != nil {
			return err
		}

		logCollector, err := lambda.NewFunction(ctx, "mylambda-logcollector", &lambda.FunctionArgs{
			Code: pulumi.NewAssetArchive(map[string]interface{}{
				"index.js": pulumi.NewStringAsset("exports.handler = (e, c, cb) => console.log(e);"),
			}),
			Role:    role.Arn,
			Handler: pulumi.String("index.handler"),
			Runtime: pulumi.String(nodeJS12dXRuntime),
		}, providerOpts...)
		if err != nil {
			return err
		}

		_, err = lambda.NewPermission(ctx, "logcollector-permission", &lambda.PermissionArgs{
			Action:    pulumi.String("lambda:InvokeFunction"),
			Principal: pulumi.String("logs." + region + ".amazonaws.com"),
			SourceArn: logGroup.Arn,
			Function:  logCollector.ID(),
		}, providerOpts...)
		if err != nil {
			return err
		}

		_, err = cloudwatch.NewLogSubscriptionFilter(ctx, "logsubscription", &cloudwatch.LogSubscriptionFilterArgs{
			DestinationArn: logCollector.Arn,
			LogGroup:       logGroup.ID(),
			FilterPattern:  pulumi.String(""),
		}, providerOpts...)
		if err != nil {
			return err
		}

		_, err = dynamodb.NewTable(ctx, "music", &dynamodb.TableArgs{
			Attributes: dynamodb.TableAttributeArray{
				dynamodb.TableAttributeArgs{Name: pulumi.String("Album"), Type: pulumi.String("S")},
				dynamodb.TableAttributeArgs{Name: pulumi.String("Artist"), Type: pulumi.String("S")},
			},
			HashKey:       pulumi.String("Album"),
			RangeKey:      pulumi.String("Artist"),
			ReadCapacity:  pulumi.Int(1),
			WriteCapacity: pulumi.Int(1),
		}, providerOpts...)
		if err != nil {
			return err
		}

		restApi, err := apigateway.NewRestApi(ctx, "myrestapi", &apigateway.RestApiArgs{}, providerOpts...)
		if err != nil {
			return err
		}

		resource, err := apigateway.NewResource(ctx, "myrestapi-resource", &apigateway.ResourceArgs{
			RestApi:  restApi.ID(),
			PathPart: pulumi.String("bambam"),
			ParentId: restApi.RootResourceId,
		}, providerOpts...)
		if err != nil {
			return err
		}

		method, err := apigateway.NewMethod(ctx, "myrestapi-method", &apigateway.MethodArgs{
			RestApi:       restApi.ID(),
			ResourceId:    resource.ID(),
			HttpMethod:    pulumi.String("ANY"),
			Authorization: pulumi.String("NONE"),
		}, providerOpts...)
		if err != nil {
			return err
		}

		integration, err := apigateway.NewIntegration(ctx, "myrestapi-integration", &apigateway.IntegrationArgs{
			RestApi:               restApi.ID(),
			ResourceId:            resource.ID(),
			HttpMethod:            pulumi.String("ANY"),
			Type:                  pulumi.String("AWS_PROXY"),
			IntegrationHttpMethod: pulumi.String("POST"),
			PassthroughBehavior:   pulumi.String("WHEN_NO_MATCH"),
			Uri:                   pulumi.Sprintf("arn:aws:apigateway:%s:lambda:path/2015-03-01/functions/%s/invocations", region, lambdaFn.Arn),
		}, pulumi.DependsOn([]pulumi.Resource{method}), pulumi.Provider(provider))
		if err != nil {
			return err
		}

		deployment, err := apigateway.NewDeployment(ctx, "myrestapi-deployment-prod", &apigateway.DeploymentArgs{
			RestApi:     restApi.ID(),
			Description: pulumi.String("my deployment"),
			StageName:   pulumi.String("prod"),
		}, pulumi.DependsOn([]pulumi.Resource{integration}), pulumi.Provider(provider))
		if err != nil {
			return err
		}

		ctx.Export("url", deployment.InvokeUrl)
		return nil
	})
}
