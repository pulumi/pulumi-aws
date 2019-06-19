// Copyright 2016-2018, Pulumi Corporation.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package aws

import (
	"errors"
	"strings"
	"unicode"

	awsbase "github.com/hashicorp/aws-sdk-go-base"
	"github.com/hashicorp/terraform/helper/schema"
	"github.com/hashicorp/terraform/terraform"
	homedir "github.com/mitchellh/go-homedir"
	"github.com/pulumi/pulumi-terraform/pkg/tfbridge"
	"github.com/pulumi/pulumi/pkg/resource"
	"github.com/pulumi/pulumi/pkg/tokens"
	"github.com/terraform-providers/terraform-provider-aws/aws"
)

// all of the AWS token components used below.
const (
	// packages:
	awsPkg = "aws"
	// modules:
	awsMod               = "index"                    // the root index.
	acmMod               = "acm"                      // AWS Certificate Manager
	acmpcaMod            = "acmpca"                   // AWS Priviate Certificate Authority
	appsyncMod           = "appsync"                  // AppSync
	appmeshMod           = "appmesh"                  // AppMesh
	apigatewayMod        = "apigateway"               // API Gateway
	appautoscalingMod    = "appautoscaling"           // Application Auto Scaling
	athenaMod            = "athena"                   // Athena
	autoscalingMod       = "autoscaling"              // Auto Scaling
	backupMod            = "backup"                   // Backup
	batchMod             = "batch"                    // Batch
	budgetsMod           = "budgets"                  // Budgets
	cloud9Mod            = "cloud9"                   // Cloud9
	cloudformationMod    = "cloudformation"           // Cloud Formation
	cloudhsmv2Mod        = "cloudhsmv2"               // Cloud HSM
	cloudfrontMod        = "cloudfront"               // Cloud Front
	cloudtrailMod        = "cloudtrail"               // Cloud Trail
	cloudwatchMod        = "cloudwatch"               // Cloud Watch
	codebuildMod         = "codebuild"                // Code Build
	codecommitMod        = "codecommit"               // Code Commit
	codedeployMod        = "codedeploy"               // Code Deploy
	codepipelineMod      = "codepipeline"             // Code Pipeline
	cognitoMod           = "cognito"                  // Cognito
	curMod               = "cur"                      // Cost and Usage Report
	cfgMod               = "cfg"                      // Resource Config
	datasyncMod          = "datasync"                 // DataSync
	dlmMod               = "dlm"                      // Data Lifecycle Manager
	daxMod               = "dax"                      // DynamoDB Accelerator
	devicefarmMod        = "devicefarm"               // Device Farm
	directoryserviceMod  = "directoryservice"         // Directory Services
	docdbMod             = "docdb"                    // Document DB
	dynamodbMod          = "dynamodb"                 // DynamoDB
	dxMod                = "directconnect"            // Direct Connect
	dmsMod               = "dms"                      // Data Migraiton Services
	ebsMod               = "ebs"                      // Elastic Block Store
	ec2Mod               = "ec2"                      // EC2
	ec2ClientVpnMod      = "ec2clientvpn"             // EC2 Client VPN
	ec2TransitGatewayMod = "ec2transitgateway"        // EC2 Transit Gateway
	ecrMod               = "ecr"                      // Elastic Container Registry
	ecsMod               = "ecs"                      // Elastic Container Service
	efsMod               = "efs"                      // Elastic Filesystem
	eksMod               = "eks"                      // ECS for Kubernetes
	elasticacheMod       = "elasticache"              // ElastiCache
	elasticbeanstalkMod  = "elasticbeanstalk"         // Elastic Beanstalk
	elasticsearchMod     = "elasticsearch"            // ElasticSearch
	elastictranscoderMod = "elastictranscoder"        // Elastic Transcoder
	elbMod               = "elasticloadbalancing"     // Elastic Load Balancing
	albMod               = "applicationloadbalancing" // Elastic Load Balancing (V2: Application)
	elbv2Mod             = "elasticloadbalancingv2"   // Elastic Load Balancing (V2: Application and Network)
	emrMod               = "emr"                      // Elastic MapReduce
	gameliftMod          = "gamelift"                 // Gamelift
	glacierMod           = "glacier"                  // Glacier
	globalacceleratorMod = "globalaccelerator"        // Global Accelerator
	glueMod              = "glue"                     // Glue
	guarddutyMod         = "guardduty"                // Guard Duty
	iamMod               = "iam"                      // Identity and Access Management (IAM)
	inspectorMod         = "inspector"                // Inspector
	iotMod               = "iot"                      // Internet of Things (IoT)
	kinesisMod           = "kinesis"                  // Kinesis
	kmsMod               = "kms"                      // Key Management Service (KMS)
	lambdaMod            = "lambda"                   // Lambda
	licensemanagerMod    = "licensemanager"           // License Manager
	lightsailMod         = "lightsail"                // LightSail
	macieMod             = "macie"                    // Macie
	mediapackageMod      = "mediapackage"             // Elemental MediaPackage
	mediastoreMod        = "mediastore"               // Elemental MediaStore
	mqMod                = "mq"                       // MQ
	mskMod               = "msk"                      // MSK
	neptuneMod           = "neptune"                  // Neptune
	opsworksMod          = "opsworks"                 // OpsWorks
	organizationsMod     = "organizations"            // Organizations
	pinpointMod          = "pinpoint"                 // Pinpoint
	pricingMod           = "pricing"                  // Pricing
	ramMod               = "ram"                      // Resource Access Manager
	rdsMod               = "rds"                      // Relational Database Service (RDS)
	redshiftMod          = "redshift"                 // RedShift
	resourcegroupsMod    = "resourcegroups"           // Resource Groups
	route53Mod           = "route53"                  // Route 53 (DNS)
	sagemakerMod         = "sagemaker"                // Sagemaker
	securityhubMod       = "securityhub"              // SecurityHub
	sesMod               = "ses"                      // Simple Email Service (SES)
	s3Mod                = "s3"                       // Simple Storage (S3)
	ssmMod               = "ssm"                      // System Manager
	secretsmanagerMod    = "secretsmanager"           // Secrets Manager
	servicecatalogMod    = "servicecatalog"           // Service Catalog
	servicediscoveryMod  = "servicediscovery"         // Service Discovery
	sfnMod               = "sfn"                      // Step Functions (SFN)
	shieldMod            = "shield"                   // Shield
	simpledbMod          = "simpledb"                 // Simple DB
	snsMod               = "sns"                      // Simple Notification Service (SNS)
	sqsMod               = "sqs"                      // Simple Queueing Service (SQS)
	storagegatewayMod    = "storagegateway"           // Storage Gateway
	swfMod               = "swf"                      // Simple Workflow Service (SWF)
	transferMod          = "transfer"                 // Transfer Service
	wafMod               = "waf"                      // Web Application Firewall (WAF)
	wafregionalMod       = "wafregional"              // Web Application Firewall (WAF) Regional
	worklinkMod          = "worklink"                 // Worklink
	workspacesMod        = "workspaces"               // Workspaces
	xrayMod              = "xray"                     // X-Ray
)

// awsMember manufactures a type token for the AWS package and the given module and type.
func awsMember(mod string, mem string) tokens.ModuleMember {
	return tokens.ModuleMember(awsPkg + ":" + mod + ":" + mem)
}

// awsType manufactures a type token for the AWS package and the given module and type.
func awsType(mod string, typ string) tokens.Type {
	return tokens.Type(awsMember(mod, typ))
}

// awsDataSource manufactures a standard resource token given a module and resource name.  It automatically uses the AWS
// package and names the file by simply lower casing the data source's first character.
func awsDataSource(mod string, res string) tokens.ModuleMember {
	fn := string(unicode.ToLower(rune(res[0]))) + res[1:]
	return awsMember(mod+"/"+fn, res)
}

// awsResource manufactures a standard resource token given a module and resource name.  It automatically uses the AWS
// package and names the file by simply lower casing the resource's first character.
func awsResource(mod string, res string) tokens.Type {
	fn := string(unicode.ToLower(rune(res[0]))) + res[1:]
	return awsType(mod+"/"+fn, res)
}

// boolRef returns a reference to the bool argument.
func boolRef(b bool) *bool {
	return &b
}

// stringValue gets a string value from a property map if present, else ""
func stringValue(vars resource.PropertyMap, prop resource.PropertyKey) string {
	val, ok := vars[prop]
	if ok && val.IsString() {
		return val.StringValue()
	}
	return ""
}

// preConfigureCallback validates that AWS credentials can be successfully discovered. This emulates the credentials
// configuration subset of `github.com/terraform-providers/terraform-provider-aws/aws.providerConfigure`.  We do this
// before passing control to the TF provider to ensure we can report actionable errors.
func preConfigureCallback(vars resource.PropertyMap, c *terraform.ResourceConfig) error {
	config := &awsbase.Config{
		AccessKey: stringValue(vars, "accessKey"),
		SecretKey: stringValue(vars, "secretKey"),
		Profile:   stringValue(vars, "profile"),
		Token:     stringValue(vars, "token"),
		Region:    stringValue(vars, "region"),
	}

	credsPath, err := homedir.Expand(stringValue(vars, "sharedCredentialsFile"))
	if err != nil {
		return err
	}
	config.CredsFilename = credsPath

	if _, err := awsbase.GetCredentials(config); err != nil {
		return errors.New("unable to discover AWS AccessKeyID and/or SecretAccessKey " +
			"- see https://pulumi.io/install/aws.html for details on configuration")
	}

	return nil
}

// managedByPulumi is a default used for some managed resources, in the absence of something more meaningful.
var managedByPulumi = &tfbridge.DefaultInfo{Value: "Managed by Pulumi"}

// Provider returns additional overlaid schema and metadata associated with the aws package.
func Provider() tfbridge.ProviderInfo {
	p := aws.Provider().(*schema.Provider)
	prov := tfbridge.ProviderInfo{
		P:           p,
		Name:        "aws",
		Description: "A Pulumi package for creating and managing Amazon Web Services (AWS) cloud resources.",
		Keywords:    []string{"pulumi", "aws"},
		License:     "Apache-2.0",
		Homepage:    "https://pulumi.io",
		Repository:  "https://github.com/pulumi/pulumi-aws",
		Config: map[string]*tfbridge.SchemaInfo{
			"region": {
				Type: awsType("region", "Region"),
				Default: &tfbridge.DefaultInfo{
					EnvVars: []string{"AWS_REGION", "AWS_DEFAULT_REGION"},
				},
			},
			"profile": {
				Default: &tfbridge.DefaultInfo{
					EnvVars: []string{"AWS_PROFILE"},
				},
			},
		},
		PreConfigureCallback: preConfigureCallback,
		Resources: map[string]*tfbridge.ResourceInfo{
			// AWS Certificate Manager
			"aws_acm_certificate":            {Tok: awsResource(acmMod, "Certificate")},
			"aws_acm_certificate_validation": {Tok: awsResource(acmMod, "CertificateValidation")},
			// AWS Private Certificate Authority
			"aws_acmpca_certificate_authority": {Tok: awsResource(acmpcaMod, "CertificateAuthority")},
			// AppSync
			"aws_appsync_api_key":     {Tok: awsResource(appsyncMod, "ApiKey")},
			"aws_appsync_graphql_api": {Tok: awsResource(appsyncMod, "GraphQLApi")},
			"aws_appsync_datasource":  {Tok: awsResource(appsyncMod, "DataSource")},
			"aws_appsync_resolver":    {Tok: awsResource(appsyncMod, "Resolver")},
			// AppMesh
			"aws_appmesh_mesh":            {Tok: awsResource(appmeshMod, "Mesh")},
			"aws_appmesh_route":           {Tok: awsResource(appmeshMod, "Route")},
			"aws_appmesh_virtual_node":    {Tok: awsResource(appmeshMod, "VirtualNode")},
			"aws_appmesh_virtual_router":  {Tok: awsResource(appmeshMod, "VirtualRouter")},
			"aws_appmesh_virtual_service": {Tok: awsResource(appmeshMod, "VirtualService")},
			// API Gateway
			"aws_api_gateway_account": {Tok: awsResource(apigatewayMod, "Account")},
			"aws_api_gateway_api_key": {
				Tok: awsResource(apigatewayMod, "ApiKey"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"description": {
						Default: managedByPulumi,
					},
					"stage_key": {
						Elem: &tfbridge.SchemaInfo{
							Fields: map[string]*tfbridge.SchemaInfo{
								"rest_api_id": {
									Name: "restApi",
									Type: awsType(apigatewayMod+"/restApi", "RestApi"),
								},
							},
						},
					},
				},
			},
			"aws_api_gateway_authorizer": {
				Tok: awsResource(apigatewayMod, "Authorizer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name: "restApi",
						Type: awsType(apigatewayMod+"/restApi", "RestApi"),
					},
				},
			},
			"aws_api_gateway_base_path_mapping": {
				Tok: awsResource(apigatewayMod, "BasePathMapping"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"api_id": {
						Name: "restApi",
						Type: awsType(apigatewayMod+"/restApi", "RestApi"),
					},
				},
			},
			"aws_api_gateway_client_certificate": {Tok: awsResource(apigatewayMod, "ClientCertificate")},
			"aws_api_gateway_deployment": {
				Tok: awsResource(apigatewayMod, "Deployment"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name: "restApi",
						Type: awsType(apigatewayMod+"/restApi", "RestApi"),
					},
				},
			},
			"aws_api_gateway_documentation_part":    {Tok: awsResource(apigatewayMod, "DocumentationPart")},
			"aws_api_gateway_documentation_version": {Tok: awsResource(apigatewayMod, "DocumentationVersion")},
			"aws_api_gateway_domain_name":           {Tok: awsResource(apigatewayMod, "DomainName")},
			"aws_api_gateway_integration": {
				Tok: awsResource(apigatewayMod, "Integration"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name: "restApi",
						Type: awsType(apigatewayMod+"/restApi", "RestApi"),
					},
				},
			},
			"aws_api_gateway_integration_response": {
				Tok: awsResource(apigatewayMod, "IntegrationResponse"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name: "restApi",
						Type: awsType(apigatewayMod+"/restApi", "RestApi"),
					},
				},
			},
			"aws_api_gateway_method": {
				Tok: awsResource(apigatewayMod, "Method"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name: "restApi",
						Type: awsType(apigatewayMod+"/restApi", "RestApi"),
					},
				},
			},
			"aws_api_gateway_method_response": {
				Tok: awsResource(apigatewayMod, "MethodResponse"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name: "restApi",
						Type: awsType(apigatewayMod+"/restApi", "RestApi"),
					},
				}},
			"aws_api_gateway_method_settings": {
				Tok: awsResource(apigatewayMod, "MethodSettings"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name: "restApi",
						Type: awsType(apigatewayMod+"/restApi", "RestApi"),
					},
				}},
			"aws_api_gateway_model": {
				Tok: awsResource(apigatewayMod, "Model"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name: "restApi",
						Type: awsType(apigatewayMod+"/restApi", "RestApi"),
					},
				}},
			"aws_api_gateway_request_validator": {
				Tok: awsResource(apigatewayMod, "RequestValidator"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name: "restApi",
						Type: awsType(apigatewayMod+"/restApi", "RestApi"),
					},
				},
			},
			"aws_api_gateway_resource": {
				Tok: awsResource(apigatewayMod, "Resource"),
				Fields: map[string]*tfbridge.SchemaInfo{
					// TODO[pulumi/terraform-bridge#5] Strongly type the parent refernence to align with other uses
					// "parent_id": {
					// 	Name: "parent",
					// 	Type: awsType(apigatewayMod+"/resource", "Resource"),
					// },
					"rest_api_id": {
						Name: "restApi",
						Type: awsType(apigatewayMod+"/restApi", "RestApi"),
					},
				},
			},
			"aws_api_gateway_gateway_response": {Tok: awsResource(apigatewayMod, "Response")},
			"aws_api_gateway_rest_api":         {Tok: awsResource(apigatewayMod, "RestApi")},
			"aws_api_gateway_stage": {
				Tok: awsResource(apigatewayMod, "Stage"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"deployment_id": {
						Name: "deployment",
						Type: awsType(apigatewayMod+"/deployment", "Deployment"),
					},
					"rest_api_id": {
						Name: "restApi",
						Type: awsType(apigatewayMod+"/restApi", "RestApi"),
					},
				},
			},
			"aws_api_gateway_usage_plan":     {Tok: awsResource(apigatewayMod, "UsagePlan")},
			"aws_api_gateway_usage_plan_key": {Tok: awsResource(apigatewayMod, "UsagePlanKey")},
			"aws_api_gateway_vpc_link": {
				Tok: awsResource(apigatewayMod, "VpcLink"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"target_arns": {Name: "targetArn"},
				},
			},
			// Application Auto Scaling
			"aws_appautoscaling_policy":           {Tok: awsResource(appautoscalingMod, "Policy")},
			"aws_appautoscaling_scheduled_action": {Tok: awsResource(appautoscalingMod, "ScheduledAction")},
			"aws_appautoscaling_target":           {Tok: awsResource(appautoscalingMod, "Target")},
			// Athena
			"aws_athena_database": {
				Tok: awsResource(athenaMod, "Database"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"name": {
						Default: &tfbridge.DefaultInfo{
							From: func(res *tfbridge.PulumiResource) (interface{}, error) {
								return resource.NewUniqueHex(string(res.URN.Name())+"_", 7, 255)
							},
						},
					},
				},
			},
			"aws_athena_named_query": {Tok: awsResource(athenaMod, "NamedQuery")},
			// Auto Scaling
			"aws_autoscaling_attachment": {Tok: awsResource(autoscalingMod, "Attachment")},
			"aws_autoscaling_group": {
				Tok: awsResource(autoscalingMod, "Group"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"launch_configuration": {
						Type:     "string",
						AltTypes: []tokens.Type{awsResource(ec2Mod, "LaunchConfiguration")},
					},
					"placement_group": {
						Type:     "string",
						AltTypes: []tokens.Type{awsResource(ec2Mod, "PlacementGroup")},
					},
					"enabled_metrics": {
						Elem: &tfbridge.SchemaInfo{Type: awsType(autoscalingMod+"/metrics", "Metric")},
					},
					"metrics_granularity": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(autoscalingMod+"/metrics", "MetricsGranularity")},
					},
					"tag": {
						// Explicitly map tag => tags to avoid confusion with tags => tagsCollection below.
						Name: "tags",
					},
					"tags": {
						// Conflicts with the pluralized `tag` property, which is the more strongly typed option for
						// providing tags.  We keep this dynamically typed collection of tags as an option as well, but
						// give it a different name.
						Name: "tagsCollection",
					},
				},
			},
			"aws_autoscaling_lifecycle_hook": {
				Tok: awsResource(autoscalingMod, "LifecycleHook"),
				Docs: &tfbridge.DocInfo{
					Source: "autoscaling_lifecycle_hooks.html.markdown",
				},
			},
			"aws_autoscaling_notification": {
				Tok: awsResource(autoscalingMod, "Notification"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"notifications": {
						Elem: &tfbridge.SchemaInfo{Type: awsType(autoscalingMod+"/notificationType", "NotificationType")},
					},
				},
			},
			"aws_autoscaling_policy":   {Tok: awsResource(autoscalingMod, "Policy")},
			"aws_autoscaling_schedule": {Tok: awsResource(autoscalingMod, "Schedule")},
			// Backup
			"aws_backup_plan":      {Tok: awsResource(backupMod, "Plan")},
			"aws_backup_selection": {Tok: awsResource(backupMod, "Selection")},
			"aws_backup_vault":     {Tok: awsResource(backupMod, "Vault")},
			// Batch
			"aws_batch_compute_environment": {Tok: awsResource(batchMod, "ComputeEnvironment")},
			"aws_batch_job_definition":      {Tok: awsResource(batchMod, "JobDefinition")},
			"aws_batch_job_queue":           {Tok: awsResource(batchMod, "JobQueue")},
			// Budgets
			"aws_budgets_budget": {Tok: awsResource(budgetsMod, "Budget")},
			// Cloud9
			"aws_cloud9_environment_ec2": {Tok: awsResource(cloud9Mod, "EnvironmentEC2")},
			// CloudFormation
			"aws_cloudformation_stack":              {Tok: awsResource(cloudformationMod, "Stack")},
			"aws_cloudformation_stack_set":          {Tok: awsResource(cloudformationMod, "StackSet")},
			"aws_cloudformation_stack_set_instance": {Tok: awsResource(cloudformationMod, "StackSetInstance")},
			// CloudHSM
			"aws_cloudhsm_v2_cluster": {Tok: awsResource(cloudhsmv2Mod, "Cluster")},
			"aws_cloudhsm_v2_hsm":     {Tok: awsResource(cloudhsmv2Mod, "Hsm")},
			// CloudFront
			"aws_cloudfront_distribution":           {Tok: awsResource(cloudfrontMod, "Distribution")},
			"aws_cloudfront_public_key":             {Tok: awsResource(cloudfrontMod, "PublicKey")},
			"aws_cloudfront_origin_access_identity": {Tok: awsResource(cloudfrontMod, "OriginAccessIdentity")},
			// CloudTrail
			"aws_cloudtrail": {Tok: awsResource(cloudtrailMod, "Trail")},
			// CloudWatch
			"aws_cloudwatch_dashboard":        {Tok: awsResource(cloudwatchMod, "Dashboard")},
			"aws_cloudwatch_event_permission": {Tok: awsResource(cloudwatchMod, "EventPermission")},
			"aws_cloudwatch_event_rule": {
				Tok: awsResource(cloudwatchMod, "EventRule"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"name": tfbridge.AutoName("name", 64),
				},
			},
			"aws_cloudwatch_event_target": {
				Tok: awsResource(cloudwatchMod, "EventTarget"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"target_id": tfbridge.AutoName("targetId", 255),
				},
			},
			"aws_cloudwatch_log_destination":        {Tok: awsResource(cloudwatchMod, "LogDestination")},
			"aws_cloudwatch_log_destination_policy": {Tok: awsResource(cloudwatchMod, "LogDestinationPolicy")},
			"aws_cloudwatch_log_group": {
				IDFields: []string{"name"},
				Tok:      awsResource(cloudwatchMod, "LogGroup"),
			},
			"aws_cloudwatch_log_metric_filter":   {Tok: awsResource(cloudwatchMod, "LogMetricFilter")},
			"aws_cloudwatch_log_resource_policy": {Tok: awsResource(cloudwatchMod, "LogResourcePolicy")},
			"aws_cloudwatch_log_stream":          {Tok: awsResource(cloudwatchMod, "LogStream")},
			"aws_cloudwatch_log_subscription_filter": {
				Tok: awsResource(cloudwatchMod, "LogSubscriptionFilter"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"log_group_name": {
						Name: "logGroup",
						Type: awsResource(cloudwatchMod, "LogGroup"),
					},
				},
				DeleteBeforeReplace: true, // only 1 active filter is legal at once
			},
			"aws_cloudwatch_metric_alarm": {
				Tok: awsResource(cloudwatchMod, "MetricAlarm"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"alarm_name": tfbridge.AutoName("name", 255),
					"alarm_actions": {
						Elem: &tfbridge.SchemaInfo{
							Type:     "string",
							AltTypes: []tokens.Type{awsResource(snsMod, "Topic")},
						},
					},
					"insufficient_data_actions": {
						Elem: &tfbridge.SchemaInfo{
							Type:     "string",
							AltTypes: []tokens.Type{awsResource(snsMod, "Topic")},
						},
					},
					"ok_actions": {
						Elem: &tfbridge.SchemaInfo{
							Type:     "string",
							AltTypes: []tokens.Type{awsResource(snsMod, "Topic")},
						},
					},
				},
			},
			// CodeBuild
			"aws_codebuild_project": {Tok: awsResource(codebuildMod, "Project")},
			"aws_codebuild_webhook": {Tok: awsResource(codebuildMod, "Webhook")},
			// CodeDeploy
			"aws_codedeploy_app":               {Tok: awsResource(codedeployMod, "Application")},
			"aws_codedeploy_deployment_config": {Tok: awsResource(codedeployMod, "DeploymentConfig")},
			"aws_codedeploy_deployment_group":  {Tok: awsResource(codedeployMod, "DeploymentGroup")},
			// CodeCommit
			"aws_codecommit_repository": {
				Tok: awsResource(codecommitMod, "Repository"),
				Docs: &tfbridge.DocInfo{
					Source: "code_commit_repository.html.markdown",
				},
			},
			"aws_codecommit_trigger": {
				Tok: awsResource(codecommitMod, "Trigger"),
				Docs: &tfbridge.DocInfo{
					Source: "code_commit_trigger.html.markdown",
				},
			},
			// CodePipeline
			"aws_codepipeline":         {Tok: awsResource(codepipelineMod, "Pipeline")},
			"aws_codepipeline_webhook": {Tok: awsResource(codepipelineMod, "Webhook")},
			// Cognito
			"aws_cognito_identity_pool":                  {Tok: awsResource(cognitoMod, "IdentityPool")},
			"aws_cognito_identity_pool_roles_attachment": {Tok: awsResource(cognitoMod, "IdentityPoolRoleAttachment")},
			"aws_cognito_identity_provider":              {Tok: awsResource(cognitoMod, "IdentityProvider")},
			"aws_cognito_resource_server":                {Tok: awsResource(cognitoMod, "ResourceServer")},
			"aws_cognito_user_group":                     {Tok: awsResource(cognitoMod, "UserGroup")},
			"aws_cognito_user_pool":                      {Tok: awsResource(cognitoMod, "UserPool")},
			"aws_cognito_user_pool_client":               {Tok: awsResource(cognitoMod, "UserPoolClient")},
			"aws_cognito_user_pool_domain":               {Tok: awsResource(cognitoMod, "UserPoolDomain")},
			// Config
			"aws_config_aggregate_authorization":       {Tok: awsResource(cfgMod, "AggregateAuthorization")},
			"aws_config_config_rule":                   {Tok: awsResource(cfgMod, "Rule")},
			"aws_config_configuration_aggregator":      {Tok: awsResource(cfgMod, "ConfigurationAggregator")},
			"aws_config_configuration_recorder":        {Tok: awsResource(cfgMod, "Recorder")},
			"aws_config_configuration_recorder_status": {Tok: awsResource(cfgMod, "RecorderStatus")},
			"aws_config_delivery_channel":              {Tok: awsResource(cfgMod, "DeliveryChannel")},
			// Cost and Usage Report
			"aws_cur_report_definition": {Tok: awsResource(curMod, "ReportDefinition")},
			// DataSync
			"aws_datasync_agent": {Tok: awsResource(datasyncMod, "Agent")},
			"aws_datasync_location_efs": {
				Tok: awsResource(datasyncMod, "EfsLocation"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"efs_file_system_arn": {Type: awsType(awsMod, "ARN")},
				},
			},
			"aws_datasync_location_nfs": {Tok: awsResource(datasyncMod, "NfsLocation")},
			"aws_datasync_location_s3": {
				Tok: awsResource(datasyncMod, "S3Location"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"s3_bucket_arn": {Type: awsType(awsMod, "ARN")},
				},
			},
			"aws_datasync_task": {
				Tok: awsResource(datasyncMod, "Task"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"destination_location_arn": {Type: awsType(awsMod, "ARN")},
					"source_location_arn":      {Type: awsType(awsMod, "ARN")},
					"cloudwatch_log_group_arn": {Type: awsType(awsMod, "ARN")},
				},
			},
			// Data Lifecycle Manager
			"aws_dlm_lifecycle_policy": {Tok: awsResource(dlmMod, "LifecyclePolicy")},
			// Data Migration Service
			"aws_dms_certificate":              {Tok: awsResource(dmsMod, "Certificate")},
			"aws_dms_endpoint":                 {Tok: awsResource(dmsMod, "Endpoint")},
			"aws_dms_replication_instance":     {Tok: awsResource(dmsMod, "ReplicationInstance")},
			"aws_dms_replication_subnet_group": {Tok: awsResource(dmsMod, "ReplicationSubnetGroup")},
			"aws_dms_replication_task":         {Tok: awsResource(dmsMod, "ReplicationTask")},
			// DAX
			"aws_dax_cluster":         {Tok: awsResource(daxMod, "Cluster")},
			"aws_dax_parameter_group": {Tok: awsResource(daxMod, "ParameterGroup")},
			"aws_dax_subnet_group":    {Tok: awsResource(daxMod, "SubnetGroup")},
			// DeviceFarm
			"aws_devicefarm_project": {Tok: awsResource(devicefarmMod, "Project")},
			// DirectoryService
			"aws_directory_service_conditional_forwarder": {Tok: awsResource(directoryserviceMod, "ConditionalForwader")},
			"aws_directory_service_directory":             {Tok: awsResource(directoryserviceMod, "Directory")},
			// Document DB
			"aws_docdb_cluster":                 {Tok: awsResource(docdbMod, "Cluster")},
			"aws_docdb_cluster_instance":        {Tok: awsResource(docdbMod, "ClusterInstance")},
			"aws_docdb_cluster_parameter_group": {Tok: awsResource(docdbMod, "ClusterParameterGroup")},
			"aws_docdb_cluster_snapshot":        {Tok: awsResource(docdbMod, "ClusterSnapshot")},
			"aws_docdb_subnet_group":            {Tok: awsResource(docdbMod, "SubnetGroup")},
			// Direct Connect
			"aws_dx_bgp_peer":                         {Tok: awsResource(dxMod, "BgpPeer")},
			"aws_dx_connection":                       {Tok: awsResource(dxMod, "Connection")},
			"aws_dx_connection_association":           {Tok: awsResource(dxMod, "ConnectionAssociation")},
			"aws_dx_gateway":                          {Tok: awsResource(dxMod, "Gateway")},
			"aws_dx_gateway_association":              {Tok: awsResource(dxMod, "GatewayAssociation")},
			"aws_dx_gateway_association_proposal":     {Tok: awsResource(dxMod, "GatewayAssociationProposal")},
			"aws_dx_hosted_private_virtual_interface": {Tok: awsResource(dxMod, "HostedPrivateVirtualInterface")},
			"aws_dx_hosted_private_virtual_interface_accepter": {
				Tok: awsResource(dxMod, "HostedPrivateVirtualInterfaceAccepter"),
			},
			"aws_dx_hosted_public_virtual_interface": {Tok: awsResource(dxMod, "HostedPublicVirtualInterface")},
			"aws_dx_hosted_public_virtual_interface_accepter": {
				Tok: awsResource(dxMod, "HostedPublicVirtualInterfaceAccepter"),
			},
			"aws_dx_private_virtual_interface": {Tok: awsResource(dxMod, "PrivateVirtualInterface")},
			"aws_dx_public_virtual_interface":  {Tok: awsResource(dxMod, "PublicVirtualInterface")},
			"aws_dx_lag":                       {Tok: awsResource(dxMod, "LinkAggregationGroup")},
			// DynamoDB
			"aws_dynamodb_global_table": {Tok: awsResource(dynamodbMod, "GlobalTable")},
			"aws_dynamodb_table": {
				Tok: awsResource(dynamodbMod, "Table"),
				Fields: map[string]*tfbridge.SchemaInfo{
					// Override default pluralization ("indices") to match AWS APIs
					"global_secondary_index": {Name: "globalSecondaryIndexes"},
					"local_secondary_index":  {Name: "localSecondaryIndexes"},
				},
			},
			"aws_dynamodb_table_item": {Tok: awsResource(dynamodbMod, "TableItem")},
			// Elastic Beanstalk
			"aws_elastic_beanstalk_application": {Tok: awsResource(elasticbeanstalkMod, "Application")},
			"aws_elastic_beanstalk_application_version": {
				Tok: awsResource(elasticbeanstalkMod, "ApplicationVersion"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"application": {Type: awsResource(elasticbeanstalkMod, "Application")},
					"bucket": {
						Type:     "string",
						AltTypes: []tokens.Type{awsResource(s3Mod, "Bucket")},
					},
				},
			},
			"aws_elastic_beanstalk_configuration_template": {Tok: awsResource(elasticbeanstalkMod, "ConfigurationTemplate")},
			"aws_elastic_beanstalk_environment": {
				Tok: awsResource(elasticbeanstalkMod, "Environment"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"name":        tfbridge.AutoName("name", 40),
					"application": {Type: awsResource(elasticbeanstalkMod, "Application")},
					"version_label": {
						Name: "version",
						Type: awsResource(elasticbeanstalkMod, "ApplicationVersion"),
					},
				},
			},
			// Elastic Block Store
			"aws_ebs_snapshot":      {Tok: awsResource(ebsMod, "Snapshot")},
			"aws_ebs_snapshot_copy": {Tok: awsResource(ebsMod, "SnapshotCopy")},
			"aws_ebs_volume":        {Tok: awsResource(ebsMod, "Volume")},
			// ElastiCache
			"aws_elasticache_cluster": {
				Tok: awsResource(elasticacheMod, "Cluster"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"cluster_id": tfbridge.AutoNameTransform("clusterId", 20, func(name string) string {
						return strings.ToLower(name)
					}),
				},
			},
			"aws_elasticache_parameter_group": {
				Tok: awsResource(elasticacheMod, "ParameterGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"description": {
						Default: managedByPulumi,
					},
				},
			},
			"aws_elasticache_replication_group": {
				Tok: awsResource(elasticacheMod, "ReplicationGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"replication_group_id": tfbridge.AutoNameTransform("replicationGroupId", 20, strings.ToLower),
				},
			},
			"aws_elasticache_security_group": {
				Tok: awsResource(elasticacheMod, "SecurityGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"description": {Default: managedByPulumi},
					// // Use "ingress" instead of "ingresses" to match AWS APIs
					// "ingress": {Name: "ingress"},
				},
			},
			"aws_elasticache_subnet_group": {
				Tok: awsResource(elasticacheMod, "SubnetGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"description": {
						Default: managedByPulumi,
					},
				},
			},
			// Elastic Compute (EC2)
			"aws_ami": {
				Tok: awsResource(ec2Mod, "Ami"),
			},
			"aws_ami_copy": {
				Tok: awsResource(ec2Mod, "AmiCopy"),
				Docs: &tfbridge.DocInfo{
					IncludeArgumentsFrom:           "aws_ami",
					IncludeAttributesFromArguments: "aws_ami",
				},
			},
			"aws_ami_from_instance": {
				Tok: awsResource(ec2Mod, "AmiFromInstance"),
				Docs: &tfbridge.DocInfo{
					IncludeAttributesFromArguments: "aws_ami",
				},
			},
			"aws_ami_launch_permission":        {Tok: awsResource(ec2Mod, "AmiLaunchPermission")},
			"aws_customer_gateway":             {Tok: awsResource(ec2Mod, "CustomerGateway")},
			"aws_egress_only_internet_gateway": {Tok: awsResource(ec2Mod, "EgressOnlyInternetGateway")},
			"aws_eip":                          {Tok: awsResource(ec2Mod, "Eip")},
			"aws_eip_association":              {Tok: awsResource(ec2Mod, "EipAssociation")},
			"aws_flow_log":                     {Tok: awsResource(ec2Mod, "FlowLog")},
			"aws_instance": {
				Tok: awsResource(ec2Mod, "Instance"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"iam_instance_profile": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(iamMod, "InstanceProfile")},
					},
					"instance_type": {
						Type: awsType(ec2Mod+"/instanceType", "InstanceType"),
					},
				},
			},
			"aws_internet_gateway": {Tok: awsResource(ec2Mod, "InternetGateway")},
			"aws_key_pair": {
				Tok: awsResource(ec2Mod, "KeyPair"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"key_name": tfbridge.AutoName("keyName", 255),
				},
			},
			"aws_launch_configuration": {
				Tok: awsResource(ec2Mod, "LaunchConfiguration"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"iam_instance_profile": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(iamMod, "InstanceProfile")},
					},
				},
			},
			"aws_launch_template": {Tok: awsResource(ec2Mod, "LaunchTemplate")},
			"aws_main_route_table_association": {
				Tok: awsResource(ec2Mod, "MainRouteTableAssociation"),
				Docs: &tfbridge.DocInfo{
					Source: "main_route_table_assoc.html.markdown",
				},
			},
			"aws_nat_gateway": {Tok: awsResource(ec2Mod, "NatGateway")},
			"aws_network_acl": {
				Tok: awsResource(ec2Mod, "NetworkAcl"),
				Fields: map[string]*tfbridge.SchemaInfo{
					// Use "ingress" instead of "ingresses" to match AWS APIs
					"ingress": {Name: "ingress"},
					"egress":  {Name: "egress"},
				},
			},
			"aws_default_network_acl": {
				Tok: awsResource(ec2Mod, "DefaultNetworkAcl"),
				Fields: map[string]*tfbridge.SchemaInfo{
					// Use "ingress" instead of "ingresses" to match AWS APIs
					"ingress": {Name: "ingress"},
					"egress":  {Name: "egress"},
				},
			},
			"aws_network_acl_rule":             {Tok: awsResource(ec2Mod, "NetworkAclRule")},
			"aws_network_interface":            {Tok: awsResource(ec2Mod, "NetworkInterface")},
			"aws_network_interface_attachment": {Tok: awsResource(ec2Mod, "NetworkInterfaceAttachment")},
			"aws_placement_group": {
				Tok: awsResource(ec2Mod, "PlacementGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"strategy": {
						Type: awsType(ec2Mod+"/placementStrategy", "PlacementStrategy"),
					},
				},
			},
			"aws_proxy_protocol_policy": {Tok: awsResource(ec2Mod, "ProxyProtocolPolicy")},
			"aws_route":                 {Tok: awsResource(ec2Mod, "Route")},
			"aws_route_table":           {Tok: awsResource(ec2Mod, "RouteTable")},
			"aws_default_route_table":   {Tok: awsResource(ec2Mod, "DefaultRouteTable")},
			"aws_ec2_capacity_reservation": {
				Tok: awsResource(ec2Mod, "CapacityReservation"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"instance_type": {
						Type: awsType(ec2Mod+"/instanceType", "InstanceType"),
					},
					"instance_platform": {
						Type: awsType(ec2Mod+"/instancePlatform", "InstancePlatform"),
					},
					"tenancy": {
						Type: awsType(ec2Mod+"/tenancy", "Tenancy"),
					},
				},
			},
			"aws_ec2_fleet":               {Tok: awsResource(ec2Mod, "Fleet")},
			"aws_route_table_association": {Tok: awsResource(ec2Mod, "RouteTableAssociation")},
			"aws_security_group": {
				Tok: awsResource(ec2Mod, "SecurityGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"description": {Default: managedByPulumi},
					// Use "ingress" instead of "ingresses" to match AWS APIs
					"ingress": {Name: "ingress"},
					"egress":  {Name: "egress"},
				},
			},
			"aws_network_interface_sg_attachment": {Tok: awsResource(ec2Mod, "NetworkInterfaceSecurityGroupAttachment")},
			"aws_default_security_group": {
				Tok: awsResource(ec2Mod, "DefaultSecurityGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					// Use "ingress" instead of "ingresses" to match AWS APIs
					"ingress": {Name: "ingress"},
					"egress":  {Name: "egress"},
				},
			},
			"aws_security_group_rule":               {Tok: awsResource(ec2Mod, "SecurityGroupRule")},
			"aws_snapshot_create_volume_permission": {Tok: awsResource(ec2Mod, "SnapshotCreateVolumePermission")},
			"aws_spot_datafeed_subscription":        {Tok: awsResource(ec2Mod, "SpotDatafeedSubscription")},
			"aws_spot_instance_request": {
				Tok: awsResource(ec2Mod, "SpotInstanceRequest"),
				Docs: &tfbridge.DocInfo{
					IncludeArgumentsFrom: "aws_instance",
				},
			},
			"aws_spot_fleet_request":           {Tok: awsResource(ec2Mod, "SpotFleetRequest")},
			"aws_default_subnet":               {Tok: awsResource(ec2Mod, "DefaultSubnet")},
			"aws_subnet":                       {Tok: awsResource(ec2Mod, "Subnet")},
			"aws_volume_attachment":            {Tok: awsResource(ec2Mod, "VolumeAttachment")},
			"aws_vpc_dhcp_options_association": {Tok: awsResource(ec2Mod, "VpcDhcpOptionsAssociation")},
			"aws_default_vpc_dhcp_options":     {Tok: awsResource(ec2Mod, "DefaultVpcDhcpOptions")},
			"aws_vpc_dhcp_options":             {Tok: awsResource(ec2Mod, "VpcDhcpOptions")},
			"aws_vpc_peering_connection": {
				Tok: awsResource(ec2Mod, "VpcPeeringConnection"),
				Docs: &tfbridge.DocInfo{
					Source: "vpc_peering.html.markdown",
				},
			},
			"aws_vpc_peering_connection_accepter": {
				Tok: awsResource(ec2Mod, "VpcPeeringConnectionAccepter"),
				Docs: &tfbridge.DocInfo{
					Source: "vpc_peering_accepter.html.markdown",
				},
			},
			"aws_vpc_peering_connection_options": {
				Tok: awsResource(ec2Mod, "PeeringConnectionOptions"),
				Docs: &tfbridge.DocInfo{
					Source: "vpc_peering_options.html.markdown",
				},
			},
			"aws_default_vpc":  {Tok: awsResource(ec2Mod, "DefaultVpc")},
			"aws_vpc":          {Tok: awsResource(ec2Mod, "Vpc")},
			"aws_vpc_endpoint": {Tok: awsResource(ec2Mod, "VpcEndpoint")},
			"aws_vpc_endpoint_connection_notification":   {Tok: awsResource(ec2Mod, "VpcEndpointConnectionNotification")},
			"aws_vpc_endpoint_route_table_association":   {Tok: awsResource(ec2Mod, "VpcEndpointRouteTableAssociation")},
			"aws_vpc_endpoint_service":                   {Tok: awsResource(ec2Mod, "VpcEndpointService")},
			"aws_vpc_endpoint_service_allowed_principal": {Tok: awsResource(ec2Mod, "VpcEndpointServiceAllowedPrinciple")},
			"aws_vpc_endpoint_subnet_association":        {Tok: awsResource(ec2Mod, "VpcEndpointSubnetAssociation")},
			"aws_vpc_ipv4_cidr_block_association":        {Tok: awsResource(ec2Mod, "VpcIpv4CidrBlockAssociation")},
			"aws_vpn_connection":                         {Tok: awsResource(ec2Mod, "VpnConnection")},
			"aws_vpn_connection_route":                   {Tok: awsResource(ec2Mod, "VpnConnectionRoute")},
			"aws_vpn_gateway":                            {Tok: awsResource(ec2Mod, "VpnGateway")},
			"aws_vpn_gateway_attachment":                 {Tok: awsResource(ec2Mod, "VpnGatewayAttachment")},
			"aws_vpn_gateway_route_propagation":          {Tok: awsResource(ec2Mod, "VpnGatewayRoutePropagation")},
			// EC2 Client VPN
			"aws_ec2_client_vpn_endpoint":            {Tok: awsResource(ec2ClientVpnMod, "Endpoint")},
			"aws_ec2_client_vpn_network_association": {Tok: awsResource(ec2ClientVpnMod, "NetworkAssociation")},
			// EC2 Transit Gateway
			"aws_ec2_transit_gateway": {
				Tok: awsResource(ec2TransitGatewayMod, "TransitGateway"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"arn": {Type: awsType(awsMod, "ARN")},
				},
			},
			"aws_ec2_transit_gateway_route": {
				Tok: awsResource(ec2TransitGatewayMod, "Route"),
			},
			"aws_ec2_transit_gateway_route_table": {Tok: awsResource(ec2TransitGatewayMod, "RouteTable")},
			"aws_ec2_transit_gateway_route_table_association": {
				Tok: awsResource(ec2TransitGatewayMod, "RouteTableAssociation"),
			},
			"aws_ec2_transit_gateway_route_table_propagation": {
				Tok: awsResource(ec2TransitGatewayMod, "RouteTablePropagation"),
			},
			"aws_ec2_transit_gateway_vpc_attachment":          {Tok: awsResource(ec2TransitGatewayMod, "VpcAttachment")},
			"aws_ec2_transit_gateway_vpc_attachment_accepter": {Tok: awsResource(ec2TransitGatewayMod, "VpcAttachmentAccepter")},
			// Elastic Container Registry
			"aws_ecr_repository":        {Tok: awsResource(ecrMod, "Repository")},
			"aws_ecr_repository_policy": {Tok: awsResource(ecrMod, "RepositoryPolicy")},
			"aws_ecr_lifecycle_policy":  {Tok: awsResource(ecrMod, "LifecyclePolicy")},
			// Elastic Container Service
			"aws_ecs_cluster": {Tok: awsResource(ecsMod, "Cluster")},
			"aws_ecs_service": {
				Tok: awsResource(ecsMod, "Service"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"load_balancer": {
						// Even though only one is currently supported, the AWS API is designed to support multiple, so
						// force this to project as an array (and assign a plural name).
						Name:        "loadBalancers",
						MaxItemsOne: boolRef(false),
					},
				},
			},
			"aws_ecs_task_definition": {Tok: awsResource(ecsMod, "TaskDefinition")},
			// Elastic File System
			"aws_efs_file_system": {
				Tok: awsResource(efsMod, "FileSystem"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"creation_token": tfbridge.AutoName("creationToken", 255),
				},
			},
			"aws_efs_mount_target": {
				Tok:                 awsResource(efsMod, "MountTarget"),
				DeleteBeforeReplace: true, // only 1 mount target per AZ.
			},
			// Elastic Load Balancing
			"aws_app_cookie_stickiness_policy":        {Tok: awsResource(elbMod, "AppCookieStickinessPolicy")},
			"aws_elb":                                 {Tok: awsResource(elbMod, "LoadBalancer")},
			"aws_elb_attachment":                      {Tok: awsResource(elbMod, "Attachment")},
			"aws_lb_cookie_stickiness_policy":         {Tok: awsResource(elbMod, "LoadBalancerCookieStickinessPolicy")},
			"aws_load_balancer_policy":                {Tok: awsResource(elbMod, "LoadBalancerPolicy")},
			"aws_load_balancer_backend_server_policy": {Tok: awsResource(elbMod, "LoadBalancerBackendServerPolicy")},
			"aws_load_balancer_listener_policy":       {Tok: awsResource(elbMod, "ListenerPolicy")},
			"aws_lb_ssl_negotiation_policy":           {Tok: awsResource(elbMod, "SslNegotiationPolicy")},
			// Elastic Load Balancing (V2: Application)
			"aws_alb": {
				Tok: awsResource(albMod, "LoadBalancer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"load_balancer_type": {
						Type: awsResource(albMod, "LoadBalancerType"),
					},
					"ip_address_type": {
						Type: awsResource(albMod, "IpAddressType"),
					},
				},
				Docs: &tfbridge.DocInfo{
					Source: "lb.html.markdown",
				},
			},
			"aws_alb_listener": {
				Tok: awsResource(albMod, "Listener"),
				Docs: &tfbridge.DocInfo{
					Source: "lb_listener.html.markdown",
				},
			},
			"aws_alb_listener_certificate": {
				Tok: awsResource(albMod, "ListenerCertificate"),
				Docs: &tfbridge.DocInfo{
					Source: "lb_listener_certificate.html.markdown",
				},
			},
			"aws_alb_listener_rule": {
				Tok: awsResource(albMod, "ListenerRule"),
				Docs: &tfbridge.DocInfo{
					Source: "lb_listener_rule.html.markdown",
				},
			},
			"aws_alb_target_group": {
				Tok: awsResource(albMod, "TargetGroup"),
				Docs: &tfbridge.DocInfo{
					Source: "lb_target_group.html.markdown",
				},
			},
			"aws_alb_target_group_attachment": {
				Tok: awsResource(albMod, "TargetGroupAttachment"),
				Docs: &tfbridge.DocInfo{
					Source: "lb_target_group_attachment.html.markdown",
				},
			},
			// Load Balancing (Application and Network)
			"aws_lb":                         {Tok: awsResource(elbv2Mod, "LoadBalancer")},
			"aws_lb_listener":                {Tok: awsResource(elbv2Mod, "Listener")},
			"aws_lb_listener_certificate":    {Tok: awsResource(elbv2Mod, "ListenerCertificate")},
			"aws_lb_listener_rule":           {Tok: awsResource(elbv2Mod, "ListenerRule")},
			"aws_lb_target_group":            {Tok: awsResource(elbv2Mod, "TargetGroup")},
			"aws_lb_target_group_attachment": {Tok: awsResource(elbv2Mod, "TargetGroupAttachment")},
			// ECS for Kubernetes
			"aws_eks_cluster": {Tok: awsResource(eksMod, "Cluster")},
			// Elastic Search
			"aws_elasticsearch_domain": {
				Tok: awsResource(elasticsearchMod, "Domain"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"domain_name": tfbridge.AutoNameTransform("domainName", 28, func(name string) string {
						return strings.ToLower(name)
					}),
					"cluster_config":   {Name: "clusterConfig"},
					"ebs_options":      {Name: "ebsOptions"},
					"snapshot_options": {Name: "snapshotOptions"},
				},
			},
			"aws_elasticsearch_domain_policy": {Tok: awsResource(elasticsearchMod, "DomainPolicy")},
			// Elastic Transcoder
			"aws_elastictranscoder_pipeline": {
				Tok: awsResource(elastictranscoderMod, "Pipeline"),
				Docs: &tfbridge.DocInfo{
					Source: "elastic_transcoder_pipeline.html.markdown",
				},
			},
			"aws_elastictranscoder_preset": {
				Tok: awsResource(elastictranscoderMod, "Preset"),
				Docs: &tfbridge.DocInfo{
					Source: "elastic_transcoder_preset.html.markdown",
				},
			},
			// Elastic MapReduce
			"aws_emr_cluster":                {Tok: awsResource(emrMod, "Cluster")},
			"aws_emr_instance_group":         {Tok: awsResource(emrMod, "InstanceGroup")},
			"aws_emr_security_configuration": {Tok: awsResource(emrMod, "SecurityConfiguration")},
			// GameLift
			"aws_gamelift_alias":              {Tok: awsResource(gameliftMod, "Alias")},
			"aws_gamelift_build":              {Tok: awsResource(gameliftMod, "Build")},
			"aws_gamelift_fleet":              {Tok: awsResource(gameliftMod, "Fleet")},
			"aws_gamelift_game_session_queue": {Tok: awsResource(gameliftMod, "GameSessionQueue")},
			// Glacier
			"aws_glacier_vault":      {Tok: awsResource(glacierMod, "Vault")},
			"aws_glacier_vault_lock": {Tok: awsResource(glacierMod, "VaultLock")},
			// Global Accelerator
			"aws_globalaccelerator_accelerator": {Tok: awsResource(globalacceleratorMod, "Accelerator")},
			"aws_globalaccelerator_listener":    {Tok: awsResource(globalacceleratorMod, "Listener")},
			// Glue
			"aws_glue_catalog_database":       {Tok: awsResource(glueMod, "CatalogDatabase")},
			"aws_glue_catalog_table":          {Tok: awsResource(glueMod, "CatalogTable")},
			"aws_glue_classifier":             {Tok: awsResource(glueMod, "Classifier")},
			"aws_glue_connection":             {Tok: awsResource(glueMod, "Connection")},
			"aws_glue_crawler":                {Tok: awsResource(glueMod, "Crawler")},
			"aws_glue_job":                    {Tok: awsResource(glueMod, "Job")},
			"aws_glue_security_configuration": {Tok: awsResource(glueMod, "SecurityConfiguration")},
			"aws_glue_trigger":                {Tok: awsResource(glueMod, "Trigger")},
			// GuardDuty
			"aws_guardduty_detector":        {Tok: awsResource(guarddutyMod, "Detector")},
			"aws_guardduty_invite_accepter": {Tok: awsResource(guarddutyMod, "InviteAccepter")},
			"aws_guardduty_ipset":           {Tok: awsResource(guarddutyMod, "IPSet")},
			"aws_guardduty_member":          {Tok: awsResource(guarddutyMod, "Member")},
			"aws_guardduty_threatintelset":  {Tok: awsResource(guarddutyMod, "ThreatIntelSet")},
			// Identity and Access Management (IAM)
			"aws_iam_access_key":              {Tok: awsResource(iamMod, "AccessKey")},
			"aws_iam_account_alias":           {Tok: awsResource(iamMod, "AccountAlias")},
			"aws_iam_account_password_policy": {Tok: awsResource(iamMod, "AccountPasswordPolicy")},
			"aws_iam_group_policy": {
				Tok: awsResource(iamMod, "GroupPolicy"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"policy": {
						Type:      "string",
						AltTypes:  []tokens.Type{awsType(iamMod+"/documents", "PolicyDocument")},
						Transform: tfbridge.TransformJSONDocument,
					},
				},
			},
			"aws_iam_group":            {Tok: awsResource(iamMod, "Group")},
			"aws_iam_group_membership": {Tok: awsResource(iamMod, "GroupMembership")},
			"aws_iam_group_policy_attachment": {
				Tok: awsResource(iamMod, "GroupPolicyAttachment"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"group": {Type: awsType(iamMod+"/group", "Group")},
					"policy_arn": {
						Name: "policyArn",
						Type: awsType(awsMod, "ARN"),
					},
				},
				// We pass delete-before-replace: this is a leaf node and a create followed by a delete actually
				// deletes the same attachment we just created, since it is structurally equivalent!
				DeleteBeforeReplace: true,
			},
			"aws_iam_instance_profile": {
				Tok: awsResource(iamMod, "InstanceProfile"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"role": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(iamMod+"/role", "Role")},
					},
					"roles": {
						Elem: &tfbridge.SchemaInfo{
							Type:     "string",
							AltTypes: []tokens.Type{awsType(iamMod+"/role", "Role")},
						},
					},
				},
			},
			"aws_iam_openid_connect_provider": {Tok: awsResource(iamMod, "OpenIdConnectProvider")},
			"aws_iam_policy": {
				Tok: awsResource(iamMod, "Policy"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"policy": {
						Type:      "string",
						AltTypes:  []tokens.Type{awsType(iamMod+"/documents", "PolicyDocument")},
						Transform: tfbridge.TransformJSONDocument,
					},
				},
			},
			"aws_iam_policy_attachment": {
				Tok: awsResource(iamMod, "PolicyAttachment"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"users": {
						Elem: &tfbridge.SchemaInfo{Type: awsType(iamMod+"/user", "User")},
					},
					"roles": {
						Elem: &tfbridge.SchemaInfo{Type: awsType(iamMod+"/role", "Role")},
					},
					"groups": {
						Elem: &tfbridge.SchemaInfo{Type: awsType(iamMod+"/group", "Group")},
					},
					"policy_arn": {
						Name: "policyArn",
						Type: awsType(awsMod, "ARN"),
					},
				},
				// We pass delete-before-replace: this is a leaf node and a create followed by a delete actually
				// deletes the same attachment we just created, since it is structurally equivalent!
				DeleteBeforeReplace: true,
			},
			"aws_iam_role_policy_attachment": {
				Tok: awsResource(iamMod, "RolePolicyAttachment"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"role": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(iamMod+"/role", "Role")},
					},
					"policy_arn": {
						Name: "policyArn",
						Type: awsType(awsMod, "ARN"),
					},
				},
				// We pass delete-before-replace: this is a leaf node and a create followed by a delete actually
				// deletes the same attachment we just created, since it is structurally equivalent!
				DeleteBeforeReplace: true,
			},
			"aws_iam_role_policy": {
				Tok: awsResource(iamMod, "RolePolicy"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"role": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(iamMod+"/role", "Role")},
					},
					"policy": {
						Type:      "string",
						AltTypes:  []tokens.Type{awsType(iamMod+"/documents", "PolicyDocument")},
						Transform: tfbridge.TransformJSONDocument,
					},
				},
			},
			"aws_iam_role": {
				Tok: awsResource(iamMod, "Role"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"name": tfbridge.AutoName("name", 64),
					"assume_role_policy": {
						Type:      "string",
						AltTypes:  []tokens.Type{awsType(iamMod+"/documents", "PolicyDocument")},
						Transform: tfbridge.TransformJSONDocument,
					},
				},
			},
			"aws_iam_saml_provider":         {Tok: awsResource(iamMod, "SamlProvider")},
			"aws_iam_server_certificate":    {Tok: awsResource(iamMod, "ServerCertificate")},
			"aws_iam_service_linked_role":   {Tok: awsResource(iamMod, "ServiceLinkedRole")},
			"aws_iam_user_group_membership": {Tok: awsResource(iamMod, "UserGroupMembership")},
			"aws_iam_user_policy_attachment": {
				Tok: awsResource(iamMod, "UserPolicyAttachment"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"user": {Type: awsType(iamMod+"/user", "User")},
					"policy_arn": {
						Name: "policyArn",
						Type: awsType(awsMod, "ARN"),
					},
				},
				// We pass delete-before-replace: this is a leaf node and a create followed by a delete actually
				// deletes the same attachment we just created, since it is structurally equivalent!
				DeleteBeforeReplace: true,
			},
			"aws_iam_user_policy": {
				Tok: awsResource(iamMod, "UserPolicy"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"policy": {
						Type:      "string",
						AltTypes:  []tokens.Type{awsType(iamMod+"/documents", "PolicyDocument")},
						Transform: tfbridge.TransformJSONDocument,
					},
				},
			},
			"aws_iam_user_ssh_key":       {Tok: awsResource(iamMod, "SshKey")},
			"aws_iam_user":               {Tok: awsResource(iamMod, "User")},
			"aws_iam_user_login_profile": {Tok: awsResource(iamMod, "UserLoginProfile")},
			// Inspector
			"aws_inspector_assessment_target":   {Tok: awsResource(inspectorMod, "AssessmentTarget")},
			"aws_inspector_assessment_template": {Tok: awsResource(inspectorMod, "AssessmentTemplate")},
			"aws_inspector_resource_group":      {Tok: awsResource(inspectorMod, "ResourceGroup")},
			// IOT
			"aws_iot_certificate": {Tok: awsResource(iotMod, "Certificate")},
			"aws_iot_policy": {
				Tok:      awsResource(iotMod, "Policy"),
				IDFields: []string{"name"},
			},
			"aws_iot_policy_attachment": {
				Tok: awsResource(iotMod, "PolicyAttachment"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"policy": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(iotMod, "Policy")},
					},
					"target": {
						Type: awsType(awsMod, "ARN"),
					},
				},
			},
			"aws_iot_role_alias": {Tok: awsResource(iotMod, "RoleAlias")},
			"aws_iot_thing":      {Tok: awsResource(iotMod, "Thing")},
			"aws_iot_thing_principal_attachment": {
				Tok: awsResource(iotMod, "ThingPrincipalAttachment"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"principal": {
						Type: awsType(awsMod, "ARN"),
					},
				},
			},
			"aws_iot_thing_type": {Tok: awsResource(iotMod, "ThingType")},
			"aws_iot_topic_rule": {
				Tok: awsResource(iotMod, "TopicRule"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"cloudwatch_alarm":  {Name: "cloudwatchAlarm", MaxItemsOne: boolRef(true)},
					"cloudwatch_metric": {Name: "cloudwatchMetric", MaxItemsOne: boolRef(true)},
					"dynamodb":          {Name: "dynamodb", MaxItemsOne: boolRef(true)},
					"elasticsearch":     {Name: "elasticsearch", MaxItemsOne: boolRef(true)},
					"firehose":          {Name: "firehose", MaxItemsOne: boolRef(true)},
					"kinesis":           {Name: "kinesis", MaxItemsOne: boolRef(true)},
					"lambda":            {Name: "lambda", MaxItemsOne: boolRef(true)},
					"republish":         {Name: "republish", MaxItemsOne: boolRef(true)},
					"s3":                {Name: "s3", MaxItemsOne: boolRef(true)},
					"sns":               {Name: "sns", MaxItemsOne: boolRef(true)},
					"sqs":               {Name: "sqs", MaxItemsOne: boolRef(true)},
				},
			},
			// Kinesis
			"aws_kinesis_firehose_delivery_stream": {Tok: awsResource(kinesisMod, "FirehoseDeliveryStream")},
			"aws_kinesis_stream":                   {Tok: awsResource(kinesisMod, "Stream")},
			"aws_kinesis_analytics_application": {
				Tok: awsResource(kinesisMod, "AnalyticsApplication"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"arn": {
						Type: awsType(awsMod, "ARN"),
					},
				},
			},
			// Key Management Service (KMS)
			"aws_kms_alias":        {Tok: awsResource(kmsMod, "Alias")},
			"aws_kms_ciphertext":   {Tok: awsResource(kmsMod, "Ciphertext")},
			"aws_kms_external_key": {Tok: awsResource(kmsMod, "ExternalKey")},
			"aws_kms_grant":        {Tok: awsResource(kmsMod, "Grant")},
			"aws_kms_key":          {Tok: awsResource(kmsMod, "Key")},
			// Lambda
			"aws_lambda_function": {
				Tok:      awsResource(lambdaMod, "Function"),
				IDFields: []string{"function_name"},
				Fields: map[string]*tfbridge.SchemaInfo{
					"function_name": tfbridge.AutoName("name", 64),
					"role":          {Type: awsType(awsMod, "ARN")},
					// Terraform accepts two sources for lambdas: a local filename or a S3 bucket/object.  To bridge
					// with Pulumi's asset model, we will hijack the filename property.  A Pulumi archive is passed in
					// its stead and we will turn around and emit the archive as a temp file that Terraform can read.
					// We also automatically populate the asset hash property as this is used in diffs/updates/etc.
					"filename": {
						Name: "code",
						Asset: &tfbridge.AssetTranslation{
							Kind:      tfbridge.FileArchive,
							Format:    resource.ZIPArchive,
							HashField: "source_code_hash",
						},
					},
				},
			},
			"aws_lambda_alias":                {Tok: awsResource(lambdaMod, "Alias")},
			"aws_lambda_event_source_mapping": {Tok: awsResource(lambdaMod, "EventSourceMapping")},
			"aws_lambda_layer_version":        {Tok: awsResource(lambdaMod, "LayerVersion")},
			"aws_lambda_permission": {
				Tok:      awsResource(lambdaMod, "Permission"),
				IDFields: []string{"statement_id"},
				Fields: map[string]*tfbridge.SchemaInfo{
					"function_name": {
						Name:     "function",
						Type:     "string",
						AltTypes: []tokens.Type{awsType(lambdaMod+"/function", "Function")},
					},
					"statement_id": tfbridge.AutoName("statementId", 100),
				},
			},
			// License Manager
			"aws_licensemanager_association":           {Tok: awsResource(licensemanagerMod, "Association")},
			"aws_licensemanager_license_configuration": {Tok: awsResource(licensemanagerMod, "LicenseConfiguration")},
			// LightSail
			"aws_lightsail_domain":               {Tok: awsResource(lightsailMod, "Domain")},
			"aws_lightsail_instance":             {Tok: awsResource(lightsailMod, "Instance")},
			"aws_lightsail_key_pair":             {Tok: awsResource(lightsailMod, "KeyPair")},
			"aws_lightsail_static_ip":            {Tok: awsResource(lightsailMod, "StaticIp")},
			"aws_lightsail_static_ip_attachment": {Tok: awsResource(lightsailMod, "StaticIpAttachment")},
			// Macie
			"aws_macie_member_account_association": {Tok: awsResource(macieMod, "MemberAccountAssociation")},
			"aws_macie_s3_bucket_association":      {Tok: awsResource(macieMod, "S3BucketAssociation")},
			// Elemental MediaPackage
			"aws_media_package_channel": {Tok: awsResource(mediapackageMod, "Channel")},
			// Elemental MediaStore
			"aws_media_store_container":        {Tok: awsResource(mediastoreMod, "Container")},
			"aws_media_store_container_policy": {Tok: awsResource(mediastoreMod, "ContainerPolicy")},
			// MQ
			"aws_mq_broker":        {Tok: awsResource(mqMod, "Broker")},
			"aws_mq_configuration": {Tok: awsResource(mqMod, "Configuration")},
			// Neptune
			"aws_neptune_cluster":                 {Tok: awsResource(neptuneMod, "Cluster")},
			"aws_neptune_cluster_instance":        {Tok: awsResource(neptuneMod, "ClusterInstance")},
			"aws_neptune_cluster_parameter_group": {Tok: awsResource(neptuneMod, "ClusterParameterGroup")},
			"aws_neptune_cluster_snapshot":        {Tok: awsResource(neptuneMod, "ClusterSnapshot")},
			"aws_neptune_event_subscription":      {Tok: awsResource(neptuneMod, "EventSubscription")},
			"aws_neptune_parameter_group":         {Tok: awsResource(neptuneMod, "ParameterGroup")},
			"aws_neptune_subnet_group":            {Tok: awsResource(neptuneMod, "SubnetGroup")},
			// OpsWorks
			"aws_opsworks_application":      {Tok: awsResource(opsworksMod, "Application")},
			"aws_opsworks_stack":            {Tok: awsResource(opsworksMod, "Stack")},
			"aws_opsworks_java_app_layer":   {Tok: awsResource(opsworksMod, "JavaAppLayer")},
			"aws_opsworks_haproxy_layer":    {Tok: awsResource(opsworksMod, "HaproxyLayer")},
			"aws_opsworks_static_web_layer": {Tok: awsResource(opsworksMod, "StaticWebLayer")},
			"aws_opsworks_php_app_layer":    {Tok: awsResource(opsworksMod, "PhpAppLayer")},
			"aws_opsworks_rails_app_layer":  {Tok: awsResource(opsworksMod, "RailsAppLayer")},
			"aws_opsworks_nodejs_app_layer": {Tok: awsResource(opsworksMod, "NodejsAppLayer")},
			"aws_opsworks_memcached_layer":  {Tok: awsResource(opsworksMod, "MemcachedLayer")},
			"aws_opsworks_mysql_layer":      {Tok: awsResource(opsworksMod, "MysqlLayer")},
			"aws_opsworks_ganglia_layer":    {Tok: awsResource(opsworksMod, "GangliaLayer")},
			"aws_opsworks_custom_layer":     {Tok: awsResource(opsworksMod, "CustomLayer")},
			"aws_opsworks_instance":         {Tok: awsResource(opsworksMod, "Instance")},
			"aws_opsworks_user_profile":     {Tok: awsResource(opsworksMod, "UserProfile")},
			"aws_opsworks_permission":       {Tok: awsResource(opsworksMod, "Permission")},
			"aws_opsworks_rds_db_instance":  {Tok: awsResource(opsworksMod, "RdsDbInstance")},
			// Organizations
			"aws_organizations_account":             {Tok: awsResource(organizationsMod, "Account")},
			"aws_organizations_organization":        {Tok: awsResource(organizationsMod, "Organization")},
			"aws_organizations_organizational_unit": {Tok: awsResource(organizationsMod, "OrganizationalUnit")},
			"aws_organizations_policy":              {Tok: awsResource(organizationsMod, "Policy")},
			"aws_organizations_policy_attachment":   {Tok: awsResource(organizationsMod, "PolicyAttachment")},
			// Pinpoint
			"aws_pinpoint_adm_channel":               {Tok: awsResource(pinpointMod, "AdmChannel")},
			"aws_pinpoint_apns_channel":              {Tok: awsResource(pinpointMod, "ApnsChannel")},
			"aws_pinpoint_apns_sandbox_channel":      {Tok: awsResource(pinpointMod, "ApnsSandboxChannel")},
			"aws_pinpoint_apns_voip_channel":         {Tok: awsResource(pinpointMod, "ApnsVoipChannel")},
			"aws_pinpoint_apns_voip_sandbox_channel": {Tok: awsResource(pinpointMod, "ApnsVoipSandboxChannel")},
			"aws_pinpoint_app":                       {Tok: awsResource(pinpointMod, "App")},
			"aws_pinpoint_baidu_channel":             {Tok: awsResource(pinpointMod, "BaiduChannel")},
			"aws_pinpoint_email_channel":             {Tok: awsResource(pinpointMod, "EmailChannel")},
			"aws_pinpoint_event_stream":              {Tok: awsResource(pinpointMod, "EventStream")},
			"aws_pinpoint_gcm_channel":               {Tok: awsResource(pinpointMod, "GcmChannel")},
			"aws_pinpoint_sms_channel":               {Tok: awsResource(pinpointMod, "SmsChannel")},
			// Resource Access Manager
			"aws_ram_resource_share":        {Tok: awsResource(ramMod, "ResourceShare")},
			"aws_ram_principal_association": {Tok: awsResource(ramMod, "PrincipalAssociation")},
			"aws_ram_resource_association":  {Tok: awsResource(ramMod, "ResourceAssociation")},
			// Relational Database Service (RDS)
			"aws_rds_cluster": {
				Tok: awsResource(rdsMod, "Cluster"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"engine": {
						Type: awsResource(rdsMod, "EngineType"),
					},
					"engine_mode": {
						Type: awsResource(rdsMod, "EngineMode"),
					},
				},
			},
			"aws_rds_cluster_endpoint": {Tok: awsResource(rdsMod, "ClusterEndpoint")},
			"aws_rds_cluster_instance": {
				Tok: awsResource(rdsMod, "ClusterInstance"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"engine": {
						Type: awsResource(rdsMod, "EngineType"),
					},
				},
			},
			"aws_rds_cluster_parameter_group": {
				Tok: awsResource(rdsMod, "ClusterParameterGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"description": {
						Default: managedByPulumi,
					},
				},
			},
			"aws_rds_global_cluster":    {Tok: awsResource(rdsMod, "GlobalCluster")},
			"aws_db_cluster_snapshot":   {Tok: awsResource(rdsMod, "ClusterSnapshot")},
			"aws_db_event_subscription": {Tok: awsResource(rdsMod, "EventSubscription")},
			"aws_db_instance": {
				Tok: awsResource(rdsMod, "Instance"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"identifier": {
						Default: &tfbridge.DefaultInfo{
							From: func(res *tfbridge.PulumiResource) (interface{}, error) {
								name, rand, maxlen := string(res.URN.Name()), 7, 255
								if engine, ok := res.Properties["engine"]; ok && engine.IsString() {
									if strings.Contains(strings.ToLower(engine.StringValue()), "sqlserver") {
										// SQL Server identifers are capped at 15 characters.
										rand, maxlen = 3, 15
									}
								}
								return resource.NewUniqueHex(name, rand, maxlen)
							},
						},
					},
					"name": {Name: "name"},
				},
			},
			"aws_db_option_group": {
				Tok: awsResource(rdsMod, "OptionGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"option_group_description": {
						Default: managedByPulumi,
					},
				},
			},
			"aws_db_parameter_group": {
				Tok: awsResource(rdsMod, "ParameterGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"description": {
						Default: managedByPulumi,
					},
				},
			},
			"aws_db_instance_role_association": {
				Tok: awsResource(rdsMod, "RoleAssociation"),
			},
			"aws_db_security_group": {
				Tok: awsResource(rdsMod, "SecurityGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"description": {Default: managedByPulumi},
					// Use "ingress" instead of "ingresses" to match AWS APIs
					"ingress": {Name: "ingress"},
				},
			},
			"aws_db_snapshot":     {Tok: awsResource(rdsMod, "Snapshot")},
			"aws_db_subnet_group": {Tok: awsResource(rdsMod, "SubnetGroup")},
			// RedShift
			"aws_redshift_cluster":            {Tok: awsResource(redshiftMod, "Cluster")},
			"aws_redshift_event_subscription": {Tok: awsResource(redshiftMod, "EventSubscription")},
			"aws_redshift_parameter_group": {
				Tok: awsResource(redshiftMod, "ParameterGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"description": {
						Default: managedByPulumi,
					},
				},
			},
			"aws_redshift_security_group": {
				Tok: awsResource(redshiftMod, "SecurityGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"description": {Default: managedByPulumi},
					// Use "ingress" instead of "ingresses" to match AWS APIs
					"ingress": {Name: "ingress"},
				},
			},
			"aws_redshift_snapshot_copy_grant": {Tok: awsResource(redshiftMod, "SnapshotCopyGrant")},
			"aws_redshift_subnet_group": {
				Tok: awsResource(redshiftMod, "SubnetGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"description": {
						Default: managedByPulumi,
					},
				},
			},
			// Resource Groups
			"aws_resourcegroups_group": {Tok: awsResource(resourcegroupsMod, "Group")},
			// Route53
			"aws_route53_delegation_set": {Tok: awsResource(route53Mod, "DelegationSet")},
			"aws_route53_record": {
				Tok: awsResource(route53Mod, "Record"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"type": {
						Type: awsResource(route53Mod, "RecordType"),
					},
				},
			},
			"aws_route53_resolver_endpoint":         {Tok: awsResource(route53Mod, "ResolverEndpoint")},
			"aws_route53_resolver_rule":             {Tok: awsResource(route53Mod, "ResolverRule")},
			"aws_route53_resolver_rule_association": {Tok: awsResource(route53Mod, "ResolverRuleAssociation")},
			"aws_route53_query_log":                 {Tok: awsResource(route53Mod, "QueryLog")},
			"aws_route53_zone_association":          {Tok: awsResource(route53Mod, "ZoneAssociation")},
			"aws_route53_zone": {
				Tok: awsResource(route53Mod, "Zone"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"comment": {
						Default: managedByPulumi,
					},
				},
			},
			"aws_route53_health_check": {Tok: awsResource(route53Mod, "HealthCheck")},
			// Sagemaker
			"aws_sagemaker_endpoint":               {Tok: awsResource(sagemakerMod, "Endpoint")},
			"aws_sagemaker_endpoint_configuration": {Tok: awsResource(sagemakerMod, "EndpointConfiguration")},
			"aws_sagemaker_model":                  {Tok: awsResource(sagemakerMod, "Model")},
			"aws_sagemaker_notebook_instance":      {Tok: awsResource(sagemakerMod, "NotebookInstance")},
			"aws_sagemaker_notebook_instance_lifecycle_configuration": {
				Tok: awsResource(sagemakerMod, "NotebookInstanceLifecycleConfiguration"),
			},
			// Secrets Manager
			"aws_secretsmanager_secret":         {Tok: awsResource(secretsmanagerMod, "Secret")},
			"aws_secretsmanager_secret_version": {Tok: awsResource(secretsmanagerMod, "SecretVersion")},
			// Service Catalog
			"aws_servicecatalog_portfolio": {Tok: awsResource(servicecatalogMod, "Portfolio")},
			// Security Hub
			"aws_securityhub_account":                {Tok: awsResource(securityhubMod, "Account")},
			"aws_securityhub_product_subscription":   {Tok: awsResource(securityhubMod, "ProductSubscription")},
			"aws_securityhub_standards_subscription": {Tok: awsResource(securityhubMod, "StandardsSubscription")},
			// Service Discovery
			"aws_service_discovery_http_namespace":        {Tok: awsResource(servicediscoveryMod, "HttpNamespace")},
			"aws_service_discovery_private_dns_namespace": {Tok: awsResource(servicediscoveryMod, "PrivateDnsNamespace")},
			"aws_service_discovery_public_dns_namespace":  {Tok: awsResource(servicediscoveryMod, "PublicDnsNamespace")},
			"aws_service_discovery_service":               {Tok: awsResource(servicediscoveryMod, "Service")},
			// Simple Email Service (SES)
			"aws_ses_active_receipt_rule_set":      {Tok: awsResource(sesMod, "ActiveReceiptRuleSet")},
			"aws_ses_domain_dkim":                  {Tok: awsResource(sesMod, "DomainDkim")},
			"aws_ses_domain_identity":              {Tok: awsResource(sesMod, "DomainIdentity")},
			"aws_ses_domain_identity_verification": {Tok: awsResource(sesMod, "DomainIdentityVerification")},
			"aws_ses_domain_mail_from":             {Tok: awsResource(sesMod, "MailFrom")},
			"aws_ses_email_identity":               {Tok: awsResource(sesMod, "EmailIdentity")},
			"aws_ses_identity_notification_topic":  {Tok: awsResource(sesMod, "IdentityNotificationTopic")},
			"aws_ses_receipt_filter":               {Tok: awsResource(sesMod, "ReceiptFilter")},
			"aws_ses_receipt_rule":                 {Tok: awsResource(sesMod, "ReceiptRule")},
			"aws_ses_receipt_rule_set":             {Tok: awsResource(sesMod, "ReceiptRuleSet")},
			"aws_ses_configuration_set":            {Tok: awsResource(sesMod, "ConfgurationSet")},
			"aws_ses_event_destination":            {Tok: awsResource(sesMod, "EventDestination")},
			"aws_ses_template":                     {Tok: awsResource(sesMod, "Template")},
			// Shield
			"aws_shield_protection": {Tok: awsResource(shieldMod, "Protection")},
			// S3
			"aws_s3_account_public_access_block": {Tok: awsResource(s3Mod, "AccountPublicAccessBlock")},
			"aws_s3_bucket": {
				Tok: awsResource(s3Mod, "Bucket"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"acl": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(s3Mod+"/cannedAcl", "CannedAcl")},
					},
					"bucket": tfbridge.AutoNameTransform("bucket", 63, func(name string) string {
						return strings.ToLower(name)
					}),
					// Website only accepts a single value in the AWS API but is not marked MaxItems==1 in the TF
					// provider.
					"website": {Name: "website"},
					"policy": {
						Type:      "string",
						AltTypes:  []tokens.Type{awsType(iamMod+"/documents", "PolicyDocument")},
						Transform: tfbridge.TransformJSONDocument,
					},
				},
			},
			"aws_s3_bucket_inventory":    {Tok: awsResource(s3Mod, "Inventory")},
			"aws_s3_bucket_metric":       {Tok: awsResource(s3Mod, "BucketMetric")},
			"aws_s3_bucket_notification": {Tok: awsResource(s3Mod, "BucketNotification")},
			"aws_s3_bucket_object": {
				Tok:      awsResource(s3Mod, "BucketObject"),
				IDFields: []string{"bucket", "key"},
				Fields: map[string]*tfbridge.SchemaInfo{
					"bucket": {
						// Prefer a strongly typed Bucket reference.
						Type: "string",
						// But also permit a string in cases where all we have is a name.
						AltTypes: []tokens.Type{awsResource(s3Mod, "Bucket")},
					},
					"key": {
						// By default, use the name as the key.  It may of course be overridden.
						Default: &tfbridge.DefaultInfo{
							From: tfbridge.FromName(false, 0, nil),
						},
					},
					"source": {
						Asset: &tfbridge.AssetTranslation{
							Kind: tfbridge.FileAsset,
						},
					},
				},
			},
			"aws_s3_bucket_policy": {
				Tok: awsResource(s3Mod, "BucketPolicy"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"policy": {
						Type:      "string",
						AltTypes:  []tokens.Type{awsType(iamMod+"/documents", "PolicyDocument")},
						Transform: tfbridge.TransformJSONDocument,
					},
				},
			},
			"aws_s3_bucket_public_access_block": {Tok: awsResource(s3Mod, "BucketPublicAccessBlock")},
			// Systems Manager (SSM)
			"aws_ssm_activation":                {Tok: awsResource(ssmMod, "Activation")},
			"aws_ssm_association":               {Tok: awsResource(ssmMod, "Association")},
			"aws_ssm_document":                  {Tok: awsResource(ssmMod, "Document")},
			"aws_ssm_maintenance_window":        {Tok: awsResource(ssmMod, "MaintenanceWindow")},
			"aws_ssm_maintenance_window_target": {Tok: awsResource(ssmMod, "MaintenanceWindowTarget")},
			"aws_ssm_maintenance_window_task":   {Tok: awsResource(ssmMod, "MaintenanceWindowTask")},
			"aws_ssm_patch_baseline":            {Tok: awsResource(ssmMod, "PatchBaseline")},
			"aws_ssm_patch_group":               {Tok: awsResource(ssmMod, "PatchGroup")},
			"aws_ssm_parameter": {
				Tok: awsResource(ssmMod, "Parameter"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"type": {
						Type: awsType(ssmMod+"/parameterType", "ParameterType"),
					},
				},
			},
			"aws_ssm_resource_data_sync": {Tok: awsResource(ssmMod, "ResourceDataSync")},
			// SimpleDB
			"aws_simpledb_domain": {Tok: awsResource(simpledbMod, "Domain")},
			// Simple Queuing Service (SQS)
			"aws_sqs_queue": {
				Tok: awsResource(sqsMod, "Queue"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"name": tfbridge.AutoName("name", 80),
				},
			},
			"aws_sqs_queue_policy": {Tok: awsResource(sqsMod, "QueuePolicy")},
			// Storage Gateway
			"aws_storagegateway_gateway":             {Tok: awsResource(storagegatewayMod, "Gateway")},
			"aws_storagegateway_cache":               {Tok: awsResource(storagegatewayMod, "Cache")},
			"aws_storagegateway_cached_iscsi_volume": {Tok: awsResource(storagegatewayMod, "CachesIscsiVolume")},
			"aws_storagegateway_nfs_file_share":      {Tok: awsResource(storagegatewayMod, "NfsFileShare")},
			"aws_storagegateway_smb_file_share":      {Tok: awsResource(storagegatewayMod, "SmbFileShare")},
			"aws_storagegateway_upload_buffer":       {Tok: awsResource(storagegatewayMod, "UploadBuffer")},
			"aws_storagegateway_working_storage":     {Tok: awsResource(storagegatewayMod, "WorkingStorage")},
			// Simple Notification Service (SNS)
			"aws_sns_platform_application": {Tok: awsResource(snsMod, "PlatformApplication")},
			"aws_sns_sms_preferences":      {Tok: awsResource(snsMod, "SmsPreferences")},
			"aws_sns_topic": {
				Tok: awsResource(snsMod, "Topic"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"arn": {Type: awsType(awsMod, "ARN")},
				},
			},
			"aws_sns_topic_policy": {Tok: awsResource(snsMod, "TopicPolicy")},
			"aws_sns_topic_subscription": {
				Tok: awsResource(snsMod, "TopicSubscription"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"topic_arn": {
						Name: "topic",
						Type: awsResource(snsMod, "Topic"),
					},
				},
			},
			// Step Functions (SFN)
			"aws_sfn_activity":      {Tok: awsResource(sfnMod, "Activity")},
			"aws_sfn_state_machine": {Tok: awsResource(sfnMod, "StateMachine")},
			// Simple Workflow Service (SWF)
			"aws_swf_domain": {Tok: awsResource(swfMod, "Domain")},
			// Transfer Service
			"aws_transfer_server":  {Tok: awsResource(transferMod, "Server")},
			"aws_transfer_ssh_key": {Tok: awsResource(transferMod, "SshKey")},
			"aws_transfer_user":    {Tok: awsResource(transferMod, "User")},
			// Web Application Firewall (WAF)
			"aws_waf_byte_match_set":          {Tok: awsResource(wafMod, "ByteMatchSet")},
			"aws_waf_geo_match_set":           {Tok: awsResource(wafMod, "GeoMatchSet")},
			"aws_waf_ipset":                   {Tok: awsResource(wafMod, "IpSet")},
			"aws_waf_rate_based_rule":         {Tok: awsResource(wafMod, "RateBasedRule")},
			"aws_waf_regex_match_set":         {Tok: awsResource(wafMod, "RegexMatchSet")},
			"aws_waf_regex_pattern_set":       {Tok: awsResource(wafMod, "RegexPatternSet")},
			"aws_waf_rule":                    {Tok: awsResource(wafMod, "Rule")},
			"aws_waf_rule_group":              {Tok: awsResource(wafMod, "RuleGroup")},
			"aws_waf_size_constraint_set":     {Tok: awsResource(wafMod, "SizeConstraintSet")},
			"aws_waf_web_acl":                 {Tok: awsResource(wafMod, "WebAcl")},
			"aws_waf_xss_match_set":           {Tok: awsResource(wafMod, "XssMatchSet")},
			"aws_waf_sql_injection_match_set": {Tok: awsResource(wafMod, "SqlInjectionMatchSet")},
			// Web Application Firewall (WAF) Regional
			"aws_wafregional_byte_match_set": {
				Tok: awsResource(wafregionalMod, "ByteMatchSet"),
				Fields: map[string]*tfbridge.SchemaInfo{
					// This property is deprecated and renamed to `byte_match_tuples`.  Don't pluralize this depreacted
					// version so that it doesn't conflict with the replacement.
					"byte_match_tuple": {
						Name: "byte_match_tuple",
					},
					"byte_match_tuples": {
						Name: "byteMatchTuples",
					},
				},
			},
			"aws_wafregional_geo_match_set":           {Tok: awsResource(wafregionalMod, "GeoMatchSet")},
			"aws_wafregional_ipset":                   {Tok: awsResource(wafregionalMod, "IpSet")},
			"aws_wafregional_rate_based_rule":         {Tok: awsResource(wafregionalMod, "RateBasedRule")},
			"aws_wafregional_regex_match_set":         {Tok: awsResource(wafregionalMod, "RegexMatchSet")},
			"aws_wafregional_regex_pattern_set":       {Tok: awsResource(wafregionalMod, "RegexPatternSet")},
			"aws_wafregional_rule":                    {Tok: awsResource(wafregionalMod, "Rule")},
			"aws_wafregional_rule_group":              {Tok: awsResource(wafregionalMod, "RuleGroup")},
			"aws_wafregional_size_constraint_set":     {Tok: awsResource(wafregionalMod, "SizeConstraintSet")},
			"aws_wafregional_sql_injection_match_set": {Tok: awsResource(wafregionalMod, "SqlInjectionMatchSet")},
			"aws_wafregional_web_acl":                 {Tok: awsResource(wafregionalMod, "WebAcl")},
			"aws_wafregional_web_acl_association":     {Tok: awsResource(wafregionalMod, "WebAclAssociation")},
			"aws_wafregional_xss_match_set":           {Tok: awsResource(wafregionalMod, "XssMatchSet")},
			// Worklink
			"aws_worklink_fleet": {Tok: awsResource(worklinkMod, "Fleet")},
			"aws_worklink_website_certificate_authority_association": {
				Tok: awsResource(worklinkMod, "WebsiteCertificateAuthorityAssociation"),
			},
			"aws_xray_sampling_rule": {Tok: awsResource(xrayMod, "SamplingRule")},
			// MSK
			"aws_msk_cluster":       {Tok: awsResource(mskMod, "Cluster")},
			"aws_msk_configuration": {Tok: awsResource(mskMod, "Configuration")},
		},
		DataSources: map[string]*tfbridge.DataSourceInfo{
			// AWS
			"aws_ami":                     {Tok: awsDataSource(awsMod, "getAmi")},
			"aws_ami_ids":                 {Tok: awsDataSource(awsMod, "getAmiIds")},
			"aws_arn":                     {Tok: awsDataSource(awsMod, "getArn")},
			"aws_autoscaling_groups":      {Tok: awsDataSource(awsMod, "getAutoscalingGroups")},
			"aws_availability_zone":       {Tok: awsDataSource(awsMod, "getAvailabilityZone")},
			"aws_availability_zones":      {Tok: awsDataSource(awsMod, "getAvailabilityZones")},
			"aws_billing_service_account": {Tok: awsDataSource(awsMod, "getBillingServiceAccount")},
			"aws_caller_identity":         {Tok: awsDataSource(awsMod, "getCallerIdentity")},
			"aws_canonical_user_id":       {Tok: awsDataSource(awsMod, "getCanonicalUserId")},
			"aws_cur_report_definition":   {Tok: awsDataSource(curMod, "getReportDefinition")},
			"aws_eip":                     {Tok: awsDataSource(awsMod, "getElasticIp")},
			"aws_ip_ranges":               {Tok: awsDataSource(awsMod, "getIpRanges")},
			"aws_partition":               {Tok: awsDataSource(awsMod, "getPartition")},
			"aws_prefix_list":             {Tok: awsDataSource(awsMod, "getPrefixList")},
			"aws_region":                  {Tok: awsDataSource(awsMod, "getRegion")},
			// AWS Certificate Manager
			"aws_acm_certificate": {Tok: awsDataSource(acmMod, "getCertificate")},
			// AWS Private Certificate Authority
			"aws_acmpca_certificate_authority": {Tok: awsDataSource(acmpcaMod, "getCertificateAuthority")},
			// API Gateway
			"aws_api_gateway_api_key":  {Tok: awsDataSource(apigatewayMod, "getKey")},
			"aws_api_gateway_resource": {Tok: awsDataSource(apigatewayMod, "getResource")},
			"aws_api_gateway_rest_api": {Tok: awsDataSource(apigatewayMod, "getRestApi")},
			"aws_api_gateway_vpc_link": {Tok: awsDataSource(apigatewayMod, "getVpcLink")},
			// Autoscaling
			"aws_autoscaling_group": {Tok: awsDataSource(autoscalingMod, "getGroup")},
			// Batch
			"aws_batch_compute_environment": {Tok: awsDataSource(batchMod, "getComputeEnvironment")},
			"aws_batch_job_queue":           {Tok: awsDataSource(batchMod, "getJobQueue")},
			// CloudFormation
			"aws_cloudformation_stack":  {Tok: awsDataSource(cloudformationMod, "getStack")},
			"aws_cloudformation_export": {Tok: awsDataSource(cloudformationMod, "getExport")},
			// CloudHSM
			"aws_cloudhsm_v2_cluster": {Tok: awsDataSource(cloudhsmv2Mod, "getCluster")},
			// CloudTrail
			"aws_cloudtrail_service_account": {Tok: awsDataSource(cloudtrailMod, "getServiceAccount")},
			// CloudWatch
			"aws_cloudwatch_log_group": {Tok: awsDataSource(cloudwatchMod, "getLogGroup")},
			// CodeCommit
			"aws_codecommit_repository": {Tok: awsDataSource(codecommitMod, "getRepository")},
			// Cognito
			"aws_cognito_user_pools": {Tok: awsDataSource(cognitoMod, "getUserPools")},
			// DynamoDB
			"aws_dynamodb_table": {
				Tok: awsDataSource(dynamodbMod, "getTable"),
				Fields: map[string]*tfbridge.SchemaInfo{
					// Override default pluralization ("indices") to match AWS APIs
					"global_secondary_index": {Name: "globalSecondaryIndexes"},
					"local_secondary_index":  {Name: "localSecondaryIndexes"},
				},
			},
			// DX
			"aws_dx_gateway": {Tok: awsDataSource(dxMod, "getGateway")},
			// EC2
			"aws_customer_gateway":       {Tok: awsDataSource(ec2Mod, "getCustomerGateway")},
			"aws_instance":               {Tok: awsDataSource(ec2Mod, "getInstance")},
			"aws_instances":              {Tok: awsDataSource(ec2Mod, "getInstances")},
			"aws_internet_gateway":       {Tok: awsDataSource(ec2Mod, "getInternetGateway")},
			"aws_launch_configuration":   {Tok: awsDataSource(ec2Mod, "getLaunchConfiguration")},
			"aws_launch_template":        {Tok: awsDataSource(ec2Mod, "getLaunchTemplate")},
			"aws_nat_gateway":            {Tok: awsDataSource(ec2Mod, "getNatGateway")},
			"aws_network_acls":           {Tok: awsDataSource(ec2Mod, "getNetworkAcls")},
			"aws_network_interface":      {Tok: awsDataSource(ec2Mod, "getNetworkInterface")},
			"aws_network_interfaces":     {Tok: awsDataSource(ec2Mod, "getNetworkInterfaces")},
			"aws_route":                  {Tok: awsDataSource(ec2Mod, "getRoute")},
			"aws_route_table":            {Tok: awsDataSource(ec2Mod, "getRouteTable")},
			"aws_route_tables":           {Tok: awsDataSource(ec2Mod, "getRouteTables")},
			"aws_security_group":         {Tok: awsDataSource(ec2Mod, "getSecurityGroup")},
			"aws_security_groups":        {Tok: awsDataSource(ec2Mod, "getSecurityGroups")},
			"aws_subnet":                 {Tok: awsDataSource(ec2Mod, "getSubnet")},
			"aws_subnet_ids":             {Tok: awsDataSource(ec2Mod, "getSubnetIds")},
			"aws_vpc":                    {Tok: awsDataSource(ec2Mod, "getVpc")},
			"aws_vpc_dhcp_options":       {Tok: awsDataSource(ec2Mod, "getVpcDhcpOptions")},
			"aws_vpc_endpoint":           {Tok: awsDataSource(ec2Mod, "getVpcEndpoint")},
			"aws_vpc_endpoint_service":   {Tok: awsDataSource(ec2Mod, "getVpcEndpointService")},
			"aws_vpc_peering_connection": {Tok: awsDataSource(ec2Mod, "getVpcPeeringConnection")},
			"aws_vpcs":                   {Tok: awsDataSource(ec2Mod, "getVpcs")},
			"aws_vpn_gateway":            {Tok: awsDataSource(ec2Mod, "getVpnGateway")},
			// EC2 Transit Gateway
			"aws_ec2_transit_gateway": {Tok: awsDataSource(ec2TransitGatewayMod, "getTransitGateway")},
			"aws_ec2_transit_gateway_dx_gateway_attachment": {
				Tok: awsDataSource(ec2TransitGatewayMod, "getDirectConnectGatewayAttachment"),
			},
			"aws_ec2_transit_gateway_route_table":    {Tok: awsDataSource(ec2TransitGatewayMod, "getRouteTable")},
			"aws_ec2_transit_gateway_vpc_attachment": {Tok: awsDataSource(ec2TransitGatewayMod, "getVpcAttachment")},
			"aws_ec2_transit_gateway_vpn_attachment": {Tok: awsDataSource(ec2TransitGatewayMod, "getVpnAttachment")},
			// Elastic Beanstalk
			"aws_elastic_beanstalk_application": {Tok: awsDataSource(elasticbeanstalkMod, "getApplication")},
			// Elastic Block Storage
			"aws_ebs_snapshot":     {Tok: awsDataSource(ebsMod, "getSnapshot")},
			"aws_ebs_snapshot_ids": {Tok: awsDataSource(ebsMod, "getSnapshotIds")},
			"aws_ebs_volume":       {Tok: awsDataSource(ebsMod, "getVolume")},
			// Elastic Container Registry
			"aws_ecr_credentials": {Tok: awsDataSource(ecrMod, "getCredentials")},
			"aws_ecr_image":       {Tok: awsDataSource(ecrMod, "getImage")},
			"aws_ecr_repository":  {Tok: awsDataSource(ecrMod, "getRepository")},
			// Elastic Container Service
			"aws_ecs_cluster":              {Tok: awsDataSource(ecsMod, "getCluster")},
			"aws_ecs_container_definition": {Tok: awsDataSource(ecsMod, "getContainerDefinition")},
			"aws_ecs_service":              {Tok: awsDataSource(ecsMod, "getService")},
			"aws_ecs_task_definition":      {Tok: awsDataSource(ecsMod, "getTaskDefinition")},
			// Elastic Filesystem
			"aws_efs_file_system":  {Tok: awsDataSource(efsMod, "getFileSystem")},
			"aws_efs_mount_target": {Tok: awsDataSource(efsMod, "getMountTarget")},
			// ECS for Kubernetes
			"aws_eks_cluster":      {Tok: awsDataSource(eksMod, "getCluster")},
			"aws_eks_cluster_auth": {Tok: awsDataSource(eksMod, "getClusterAuth")},
			// Elastic Beanstalk
			"aws_elastic_beanstalk_solution_stack": {Tok: awsDataSource(elasticbeanstalkMod, "getSolutionStack")},
			"aws_elastic_beanstalk_hosted_zone":    {Tok: awsDataSource(elasticbeanstalkMod, "getHostedZone")},
			// ElastiCache
			"aws_elasticache_cluster":           {Tok: awsDataSource(elasticacheMod, "getCluster")},
			"aws_elasticache_replication_group": {Tok: awsDataSource(elasticacheMod, "getReplicationGroup")},
			// Elastic Load Balancing
			"aws_elb_hosted_zone_id":  {Tok: awsDataSource(elbMod, "getHostedZoneId")},
			"aws_elb_service_account": {Tok: awsDataSource(elbMod, "getServiceAccount")},
			"aws_elb":                 {Tok: awsDataSource(elbMod, "getLoadBalancer")},
			// Elastic Load Balancing (v2: Application)
			"aws_alb": {
				Tok: awsDataSource(albMod, "getLoadBalancer"),
				Docs: &tfbridge.DocInfo{
					Source: "lb.html.markdown",
				},
			},
			"aws_alb_listener": {
				Tok: awsDataSource(albMod, "getListener"),
				Docs: &tfbridge.DocInfo{
					Source: "lb_listener.html.markdown",
				},
			},
			"aws_alb_target_group": {
				Tok: awsDataSource(albMod, "getTargetGroup"),
				Docs: &tfbridge.DocInfo{
					Source: "lb_target_group.html.markdown",
				},
			},
			// Glue
			"aws_glue_script": {Tok: awsDataSource(glueMod, "getScript")},
			// IOT
			"aws_iot_endpoint": {Tok: awsDataSource(iotMod, "getEndpoint")},
			// Lambda
			"aws_lambda_function":      {Tok: awsDataSource(lambdaMod, "getFunction")},
			"aws_lambda_invocation":    {Tok: awsDataSource(lambdaMod, "getInvocation")},
			"aws_lambda_layer_version": {Tok: awsDataSource(lambdaMod, "getLayerVersion")},
			// Load Balancing (Application and Network)
			"aws_lb":              {Tok: awsDataSource(elbv2Mod, "getLoadBalancer")},
			"aws_lb_listener":     {Tok: awsDataSource(elbv2Mod, "getListener")},
			"aws_lb_target_group": {Tok: awsDataSource(elbv2Mod, "getTargetGroup")},
			// MQ
			"aws_mq_broker": {Tok: awsDataSource(mqMod, "getBroker")},
			// IAM
			"aws_iam_account_alias":      {Tok: awsDataSource(iamMod, "getAccountAlias")},
			"aws_iam_group":              {Tok: awsDataSource(iamMod, "getGroup")},
			"aws_iam_instance_profile":   {Tok: awsDataSource(iamMod, "getInstanceProfile")},
			"aws_iam_policy":             {Tok: awsDataSource(iamMod, "getPolicy")},
			"aws_iam_policy_document":    {Tok: awsDataSource(iamMod, "getPolicyDocument")},
			"aws_iam_role":               {Tok: awsDataSource(iamMod, "getRole")},
			"aws_iam_server_certificate": {Tok: awsDataSource(iamMod, "getServerCertificate")},
			"aws_iam_user":               {Tok: awsDataSource(iamMod, "getUser")},
			// Inspector
			"aws_inspector_rules_packages": {Tok: awsDataSource(inspectorMod, "getRulesPackages")},
			// Kinesis
			"aws_kinesis_stream": {Tok: awsDataSource(kinesisMod, "getStream")},
			// Key Management Service
			"aws_kms_alias":      {Tok: awsDataSource(kmsMod, "getAlias")},
			"aws_kms_ciphertext": {Tok: awsDataSource(kmsMod, "getCipherText")},
			"aws_kms_key":        {Tok: awsDataSource(kmsMod, "getKey")},
			"aws_kms_secret":     {Tok: awsDataSource(kmsMod, "getSecret")},
			"aws_kms_secrets":    {Tok: awsDataSource(kmsMod, "getSecrets")},
			// Pricing
			"aws_pricing_product": {Tok: awsDataSource(pricingMod, "getProduct")},
			// RDS
			"aws_rds_cluster":         {Tok: awsDataSource(rdsMod, "getCluster")},
			"aws_db_cluster_snapshot": {Tok: awsDataSource(rdsMod, "getClusterSnapshot")},
			"aws_db_event_categories": {Tok: awsDataSource(rdsMod, "getEventCategories")},
			"aws_db_instance":         {Tok: awsDataSource(rdsMod, "getInstance")},
			"aws_db_snapshot":         {Tok: awsDataSource(rdsMod, "getSnapshot")},
			// Ram
			"aws_ram_resource_share": {Tok: awsDataSource(ramMod, "getResourceShare")},
			// RedShift
			"aws_redshift_cluster":         {Tok: awsDataSource(redshiftMod, "getCluster")},
			"aws_redshift_service_account": {Tok: awsDataSource(redshiftMod, "getServiceAccount")},
			// Route53
			"aws_route53_zone":           {Tok: awsDataSource(route53Mod, "getZone")},
			"aws_route53_delegation_set": {Tok: awsDataSource(route53Mod, "getDelegationSet")},
			// S3
			"aws_s3_bucket":        {Tok: awsDataSource(s3Mod, "getBucket")},
			"aws_s3_bucket_object": {Tok: awsDataSource(s3Mod, "getBucketObject")},
			// Secrets Manager
			"aws_secretsmanager_secret":         {Tok: awsDataSource(secretsmanagerMod, "getSecret")},
			"aws_secretsmanager_secret_version": {Tok: awsDataSource(secretsmanagerMod, "getSecretVersion")},
			// SNS
			"aws_sns_topic": {Tok: awsDataSource(snsMod, "getTopic")},
			// SQS
			"aws_sqs_queue": {Tok: awsDataSource(sqsMod, "getQueue")},
			// SSM
			"aws_ssm_document":  {Tok: awsDataSource(ssmMod, "getDocument")},
			"aws_ssm_parameter": {Tok: awsDataSource(ssmMod, "getParameter")},
			// Storage Gateway
			"aws_storagegateway_local_disk": {Tok: awsDataSource(storagegatewayMod, "getLocalDisk")},
			// Transfer
			"aws_transfer_server": {Tok: awsDataSource(transferMod, "getServer")},
			// Workspaces
			"aws_workspaces_bundle": {Tok: awsDataSource(workspacesMod, "getBundle")},
			// MSK
			"aws_msk_cluster": {Tok: awsDataSource(mskMod, "getCluster")},
		},
		JavaScript: &tfbridge.JavaScriptInfo{
			Dependencies: map[string]string{
				"@pulumi/pulumi":    "^0.17.17",
				"aws-sdk":           "^2.0.0",
				"mime":              "^2.0.0",
				"builtin-modules":   "3.0.0",
				"read-package-tree": "^5.2.1",
				"resolve":           "^1.7.1",
			},
			DevDependencies: map[string]string{
				"@types/node": "^10.0.0", // so we can access strongly typed node definitions.
				"@types/mime": "^2.0.0",
			},
			Overlay: &tfbridge.OverlayInfo{
				DestFiles: []string{
					"arn.ts",    // ARN typedef
					"region.ts", // Region union type and constants
					"tags.ts",   // Tags typedef (currently unused but left for compatibility)
					"utils.ts",  // Helpers,
				},
				Modules: map[string]*tfbridge.OverlayInfo{
					"autoscaling": {
						DestFiles: []string{
							"metrics.ts",          // Metric and MetricsGranularity union types and constants
							"notificationType.ts", // NotificationType union type and constants
						},
					},
					"applicationloadbalancing": {
						DestFiles: []string{
							"ipAddressType.ts",
							"loadBalancerType.ts",
						},
					},
					"cloudwatch": {
						DestFiles: []string{
							"cloudwatchMixins.ts",
							"eventRuleMixins.ts",
							"logGroupMixins.ts",
						},
					},
					"config": {
						DestFiles: []string{
							"require.ts", // requireRegion helpers for validating proper config
						},
					},
					"dynamodb": {
						DestFiles: []string{
							"dynamodbMixins.ts",
						},
					},
					"ec2": {
						DestFiles: []string{
							"instanceType.ts",      // InstanceType union type and constants
							"instancePlatform.ts",  // InstancePlatform union type and constants
							"placementStrategy.ts", // PlacementStrategy union type and constants
							"protocolType.ts",
							"tenancy.ts", // Tenancy union type and constants
						},
					},
					"ecs": {
						DestFiles: []string{
							"container.ts", // Container definition JSON schema
						},
					},
					"iam": {
						DestFiles: []string{
							"documents.ts",       // policy document schemas.
							"managedPolicies.ts", // handy constants that predefine all known managed policies.
							"principals.ts",      // Pre-defined objects representing Service Principals
						},
					},
					"kinesis": {
						DestFiles: []string{
							"kinesisMixins.ts",
						},
					},
					"lambda": {
						DestFiles: []string{
							"runtimes.ts", // a union type and constants for available Lambda runtimes.
							"lambdaMixins.ts",
						},
					},
					"rds": {
						DestFiles: []string{
							"engineMode.ts",
							"engineType.ts",
						},
					},
					"route53": {
						DestFiles: []string{
							"recordType.ts",
						},
					},
					"s3": {
						DestFiles: []string{
							"cannedAcl.ts", // a union type and constants for canned ACL names.
							"s3Mixins.ts",
						},
					},
					"serverless": {
						DestFiles: []string{
							"function.ts", // a union type and constants for available Lambda runtimes.
						},
					},
					"sns": {
						DestFiles: []string{
							"snsMixins.ts",
						},
					},
					"sqs": {
						DestFiles: []string{
							"redrive.ts", // schema definitions for SQS redrive policies.
							"sqsMixins.ts",
						},
					},
					"ssm": {
						DestFiles: []string{
							"parameterType.ts",
						},
					},
				},
			},
		},
		Python: &tfbridge.PythonInfo{
			Requires: map[string]string{
				"pulumi": ">=0.17.12,<0.18.0",
			},
		},
	}

	// For all resources with name properties, we will add an auto-name property.  Make sure to skip those that
	// already have a name mapping entry, since those may have custom overrides set above (e.g., for length).
	const awsName = "name"
	for resname, res := range prov.Resources {
		if schema := p.ResourcesMap[resname]; schema != nil {
			// Only apply auto-name to input properties (Optional || Required) named `name`
			if tfs, has := schema.Schema[awsName]; has && (tfs.Optional || tfs.Required) {
				if _, hasfield := res.Fields[awsName]; !hasfield {
					if res.Fields == nil {
						res.Fields = make(map[string]*tfbridge.SchemaInfo)
					}
					res.Fields[awsName] = tfbridge.AutoName(awsName, 255)
				}
			}
		}
	}

	return prov
}
