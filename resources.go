// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package aws

import (
	"strings"
	"unicode"

	"github.com/hashicorp/terraform/helper/schema"
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
	apigatewayMod        = "apigateway"               // API Gateway
	appautoscalingMod    = "appautoscaling"           // Application Auto Scaling
	autoscalingMod       = "autoscaling"              // Auto Scaling
	batchMod             = "batch"                    // Batch
	cloudformationMod    = "cloudformation"           // Cloud Formation
	cloudfrontMod        = "cloudfront"               // Cloud Front
	cloudtrailMod        = "cloudtrail"               // Cloud Trail
	cloudwatchMod        = "cloudwatch"               // Cloud Watch
	codebuildMod         = "codebuild"                // Code Build
	codecommitMod        = "codecommit"               // Code Commit
	codedeployMod        = "codedeploy"               // Code Deploy
	codepipelineMod      = "codepipeline"             // Code Pipeline
	cognitoMod           = "cognito"                  // Cognito
	cfgMod               = "cfg"                      // Resource Config
	devicefarmMod        = "devicefarm"               // Device Farm
	directoryserviceMod  = "directoryservice"         // Directory Services
	dynamodbMod          = "dynamodb"                 // DynamoDB
	dmsMod               = "dms"                      // Data Migraiton Services
	ebsMod               = "ebs"                      // Elastic Block Store
	ec2Mod               = "ec2"                      // EC2
	ecrMod               = "ecr"                      // Elastic Container Registry
	ecsMod               = "ecs"                      // Elastic Container Service
	efsMod               = "efs"                      // Elastic Filesystem
	elasticacheMod       = "elasticache"              // ElastiCache
	elasticbeanstalkMod  = "elasticbeanstalk"         // Elastic Beanstalk
	elasticsearchMod     = "elasticsearch"            // ElasticSearch
	elastictranscoderMod = "elastictranscoder"        // Elastic Transcoder
	elbMod               = "elasticloadbalancing"     // Elastic Load Balancing
	albMod               = "applicationloadbalancing" // Elastic Load Balancing (V2: Application)
	elbv2Mod             = "elasticloadbalancingv2"   // Elastic Load Balancing (V2: Application and Network)
	emrMod               = "emr"                      // Elastic MapReduce
	glacierMod           = "glacier"                  // Glacier
	iamMod               = "iam"                      // Identity and Access Management (IAM)
	inspectorMod         = "inspector"                // Inspector
	iotMod               = "iot"                      // Internet of Things (IoT)
	kinesisMod           = "kinesis"                  // Kinesis
	kmsMod               = "kms"                      // Key Management Service (KMS)
	lambdaMod            = "lambda"                   // Lambda
	lightsailMod         = "lightsail"                // LightSail
	opsworksMod          = "opsworks"                 // OpsWorks
	rdsMod               = "rds"                      // Relational Database Service (RDS)
	redshiftMod          = "redshift"                 // RedShift
	route53Mod           = "route53"                  // Route 53 (DNS)
	sesMod               = "ses"                      // Simple Email Service (SES)
	s3Mod                = "s3"                       // Simple Storage (S3)
	ssmMod               = "ssm"                      // System Manager
	sfnMod               = "sfn"                      // Step Functions (SFN)
	simpledbMod          = "simpledb"                 // Simple DB
	snsMod               = "sns"                      // Simple Notification Service (SNS)
	sqsMod               = "sqs"                      // Simple Queueing Service (SQS)
	wafMod               = "waf"                      // Web Application Firewall (WAF)
	wafregionalMod       = "wafregional"              // Web Application Firewall (WAF) Regional
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

// Provider returns additional overlaid schema and metadata associated with the aws package.
func Provider() tfbridge.ProviderInfo {
	p := aws.Provider().(*schema.Provider)
	prov := tfbridge.ProviderInfo{
		P:    p,
		Name: "aws",
		Config: map[string]*tfbridge.SchemaInfo{
			"region": {
				Type: awsType("region", "Region"),
			},
		},
		Resources: map[string]*tfbridge.ResourceInfo{
			// API Gateway
			"aws_api_gateway_account": {Tok: awsResource(apigatewayMod, "Account")},
			"aws_api_gateway_api_key": {
				Tok: awsResource(apigatewayMod, "ApiKey"),
				Fields: map[string]*tfbridge.SchemaInfo{
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
			"aws_api_gateway_domain_name": {Tok: awsResource(apigatewayMod, "DomainName")},
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
			// Application Auto Scaling
			"aws_appautoscaling_target": {Tok: awsResource(appautoscalingMod, "Target")},
			"aws_appautoscaling_policy": {Tok: awsResource(appautoscalingMod, "Policy")},
			// Auto Scaling
			"aws_autoscaling_attachment": {Tok: awsResource(autoscalingMod, "Attachment")},
			"aws_autoscaling_group":      {Tok: awsResource(autoscalingMod, "Group")},
			"aws_autoscaling_lifecycle_hook": {
				Tok: awsResource(autoscalingMod, "LifecycleHook"),
				Docs: &tfbridge.DocInfo{
					Source: "autoscaling_lifecycle_hooks.html.markdown",
				},
			},
			"aws_autoscaling_notification": {Tok: awsResource(autoscalingMod, "Notification")},
			"aws_autoscaling_policy":       {Tok: awsResource(autoscalingMod, "Policy")},
			"aws_autoscaling_schedule":     {Tok: awsResource(autoscalingMod, "Schedule")},
			// Batch
			"aws_batch_compute_environment": {Tok: awsResource(batchMod, "ComputeEnvironment")},
			// CloudFormation
			"aws_cloudformation_stack": {Tok: awsResource(cloudformationMod, "Stack")},
			// CloudFront
			"aws_cloudfront_distribution":           {Tok: awsResource(cloudfrontMod, "Distribution")},
			"aws_cloudfront_origin_access_identity": {Tok: awsResource(cloudfrontMod, "OriginAccessIdentity")},
			// CloudTrail
			"aws_cloudtrail": {Tok: awsResource(cloudtrailMod, "Trail")},
			// CloudWatch
			"aws_cloudwatch_dashboard":              {Tok: awsResource(cloudwatchMod, "Dashboard")},
			"aws_cloudwatch_event_rule":             {Tok: awsResource(cloudwatchMod, "EventRule")},
			"aws_cloudwatch_event_target":           {Tok: awsResource(cloudwatchMod, "EventTarget")},
			"aws_cloudwatch_log_destination":        {Tok: awsResource(cloudwatchMod, "LogDestination")},
			"aws_cloudwatch_log_destination_policy": {Tok: awsResource(cloudwatchMod, "LogDestinationPolicy")},
			"aws_cloudwatch_log_group": {
				IDFields: []string{"name"},
				Tok:      awsResource(cloudwatchMod, "LogGroup"),
			},
			"aws_cloudwatch_log_metric_filter": {Tok: awsResource(cloudwatchMod, "LogMetricFilter")},
			"aws_cloudwatch_log_stream":        {Tok: awsResource(cloudwatchMod, "LogStream")},
			"aws_cloudwatch_log_subscription_filter": {
				Tok: awsResource(cloudwatchMod, "LogSubscriptionFilter"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"log_group_name": {
						Name: "logGroup",
						Type: awsResource(cloudwatchMod, "LogGroup"),
					},
				},
			},
			"aws_cloudwatch_metric_alarm": {
				Tok: awsResource(cloudwatchMod, "MetricAlarm"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"alarm_name": tfbridge.AutoName("name", 255),
					"alarm_actions": {
						Elem: &tfbridge.SchemaInfo{
							Type: awsResource(snsMod, "Topic"),
						},
					},
					"insufficient_data_actions": {
						Elem: &tfbridge.SchemaInfo{
							Type: awsResource(snsMod, "Topic"),
						},
					},
					"ok_actions": {
						Elem: &tfbridge.SchemaInfo{
							Type: awsResource(snsMod, "Topic"),
						},
					},
				},
			},
			// CodeBuild
			"aws_codebuild_project": {Tok: awsResource(codebuildMod, "Project")},
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
			"aws_codepipeline": {Tok: awsResource(codepipelineMod, "Pipeline")},
			// Cognito
			"aws_cognito_identity_pool": {Tok: awsResource(cognitoMod, "IdentityPool")},
			// Config
			"aws_config_config_rule":                   {Tok: awsResource(cfgMod, "Rule")},
			"aws_config_configuration_recorder":        {Tok: awsResource(cfgMod, "Recorder")},
			"aws_config_configuration_recorder_status": {Tok: awsResource(cfgMod, "RecorderStatus")},
			"aws_config_delivery_channel":              {Tok: awsResource(cfgMod, "DeliveryChannel")},
			// Data Migration Service
			"aws_dms_certificate":              {Tok: awsResource(dmsMod, "Certificate")},
			"aws_dms_endpoint":                 {Tok: awsResource(dmsMod, "Endpoint")},
			"aws_dms_replication_instance":     {Tok: awsResource(dmsMod, "ReplicationInstance")},
			"aws_dms_replication_subnet_group": {Tok: awsResource(dmsMod, "ReplicationSubnetGroup")},
			"aws_dms_replication_task":         {Tok: awsResource(dmsMod, "ReplicationTask")},
			// DeviceFarm
			"aws_devicefarm_project": {Tok: awsResource(devicefarmMod, "Project")},
			// DirectoryService
			"aws_directory_service_directory": {Tok: awsResource(directoryserviceMod, "Directory")},
			// DynamoDB
			"aws_dynamodb_table": {Tok: awsResource(dynamodbMod, "Table")},
			// Elastic Beanstalk
			"aws_elastic_beanstalk_application": {Tok: awsResource(elasticbeanstalkMod, "Application")},
			"aws_elastic_beanstalk_application_version": {
				Tok: awsResource(elasticbeanstalkMod, "ApplicationVersion"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"application": {Type: awsResource(elasticbeanstalkMod, "Application")},
					"bucket":      {Type: awsResource(s3Mod, "Bucket")},
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
			"aws_ebs_snapshot": {Tok: awsResource(ebsMod, "Snapshot")},
			"aws_ebs_volume":   {Tok: awsResource(ebsMod, "Volume")},
			// ElastiCache
			"aws_elasticache_cluster":           {Tok: awsResource(elasticacheMod, "Cluster")},
			"aws_elasticache_parameter_group":   {Tok: awsResource(elasticacheMod, "ParameterGroup")},
			"aws_elasticache_replication_group": {Tok: awsResource(elasticacheMod, "ReplicationGroup")},
			"aws_elasticache_security_group":    {Tok: awsResource(elasticacheMod, "SecurityGroup")},
			"aws_elasticache_subnet_group":      {Tok: awsResource(elasticacheMod, "SubnetGroup")},
			// Elastic Compute (EC2)
			"aws_ami": {
				Tok: awsResource(ec2Mod, "Ami"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "amiId"},
				},
			},
			"aws_ami_copy": {
				Tok: awsResource(ec2Mod, "AmiCopy"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "amiId"},
				},
				Docs: &tfbridge.DocInfo{
					IncludeArgumentsFrom:           "aws_ami",
					IncludeAttributesFromArguments: "aws_ami",
				},
			},
			"aws_ami_from_instance": {
				Tok: awsResource(ec2Mod, "AmiFromInstance"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "amiId"},
				},
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
					"instance_type": {
						Type: awsType(ec2Mod+"/instanceType", "InstanceType"),
					},
				},
			},
			"aws_internet_gateway": {Tok: awsResource(ec2Mod, "InternetGateway")},
			"aws_key_pair":         {Tok: awsResource(ec2Mod, "KeyPair")},
			"aws_launch_configuration": {
				Tok: awsResource(ec2Mod, "LaunchConfiguration"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"ebs_block_device": {Name: "ebsBlockDevices"},
				},
			},
			"aws_main_route_table_association": {
				Tok: awsResource(ec2Mod, "MainRouteTableAssociation"),
				Docs: &tfbridge.DocInfo{
					Source: "main_route_table_assoc.html.markdown",
				},
			},
			"aws_nat_gateway":                       {Tok: awsResource(ec2Mod, "NatGateway")},
			"aws_network_acl":                       {Tok: awsResource(ec2Mod, "NetworkAcl")},
			"aws_default_network_acl":               {Tok: awsResource(ec2Mod, "DefaultNetworkAcl")},
			"aws_network_acl_rule":                  {Tok: awsResource(ec2Mod, "NetworkAclRule")},
			"aws_network_interface":                 {Tok: awsResource(ec2Mod, "NetworkInterface")},
			"aws_network_interface_attachment":      {Tok: awsResource(ec2Mod, "NetworkInterfaceAttachment")},
			"aws_placement_group":                   {Tok: awsResource(ec2Mod, "PlacementGroup")},
			"aws_proxy_protocol_policy":             {Tok: awsResource(ec2Mod, "ProxyProtocolPolicy")},
			"aws_route":                             {Tok: awsResource(ec2Mod, "Route")},
			"aws_route_table":                       {Tok: awsResource(ec2Mod, "RouteTable")},
			"aws_default_route_table":               {Tok: awsResource(ec2Mod, "DefaultRouteTable")},
			"aws_route_table_association":           {Tok: awsResource(ec2Mod, "RouteTableAssociation")},
			"aws_security_group":                    {Tok: awsResource(ec2Mod, "SecurityGroup")},
			"aws_network_interface_sg_attachment":   {Tok: awsResource(ec2Mod, "NetworkInterfaceSecurityGroupAttachment")},
			"aws_default_security_group":            {Tok: awsResource(ec2Mod, "DefaultSecurityGroup")},
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
			"aws_default_vpc":                          {Tok: awsResource(ec2Mod, "DefaultVpc")},
			"aws_vpc":                                  {Tok: awsResource(ec2Mod, "Vpc")},
			"aws_vpc_endpoint":                         {Tok: awsResource(ec2Mod, "VpcEndpoint")},
			"aws_vpc_endpoint_route_table_association": {Tok: awsResource(ec2Mod, "VpcEndpointRouteTableAssociation")},
			"aws_vpn_connection":                       {Tok: awsResource(ec2Mod, "VpnConnection")},
			"aws_vpn_connection_route":                 {Tok: awsResource(ec2Mod, "VpnConnectionRoute")},
			"aws_vpn_gateway":                          {Tok: awsResource(ec2Mod, "VpnGateway")},
			"aws_vpn_gateway_attachment":               {Tok: awsResource(ec2Mod, "VpnGatewayAttachment")},
			"aws_vpn_gateway_route_propagation":        {Tok: awsResource(ec2Mod, "VpnGatewayRoutePropagation")},
			// Elastic Container Registry
			"aws_ecr_repository":        {Tok: awsResource(ecrMod, "Repository")},
			"aws_ecr_repository_policy": {Tok: awsResource(ecrMod, "RepositoryPolicy")},
			// Elastic Container Service
			"aws_ecs_cluster": {Tok: awsResource(ecsMod, "Cluster")},
			"aws_ecs_service": {
				Tok: awsResource(ecsMod, "Service"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"load_balancer": {Name: "loadBalancers"},
				},
			},
			"aws_ecs_task_definition": {Tok: awsResource(ecsMod, "TaskDefinition")},
			// Elastic File System
			"aws_efs_file_system":  {Tok: awsResource(efsMod, "FileSystem")},
			"aws_efs_mount_target": {Tok: awsResource(efsMod, "MountTarget")},
			// Elastic Load Balancing
			"aws_app_cookie_stickiness_policy":        {Tok: awsResource(elbMod, "CookieStickinessPolicy")},
			"aws_elb":                                 {Tok: awsResource(elbMod, "LoadBalancer")},
			"aws_elb_attachment":                      {Tok: awsResource(elbMod, "Attachment")},
			"aws_lb_cookie_stickiness_policy":         {Tok: awsResource(elbMod, "CookieStickinessPolicy")},
			"aws_load_balancer_policy":                {Tok: awsResource(elbMod, "LoadBalancerPolicy")},
			"aws_load_balancer_backend_server_policy": {Tok: awsResource(elbMod, "LoadBalancerBackendServerPolicy")},
			"aws_load_balancer_listener_policy":       {Tok: awsResource(elbMod, "ListenerPolicy")},
			"aws_lb_ssl_negotiation_policy":           {Tok: awsResource(elbMod, "SslNegotiationPolicy")},
			// Elastic Load Balancing (V2: Application)
			"aws_alb": {Tok: awsResource(albMod, "LoadBalancer")},
			"aws_alb_listener": {
				Tok: awsResource(albMod, "Listener"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"default_action": {Name: "defaultActions"},
				},
			},
			"aws_alb_listener_rule": {
				Tok: awsResource(albMod, "ListenerRule"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"action":    {Name: "actions"},
					"condition": {Name: "conditions"},
				},
			},
			"aws_alb_target_group": {
				Tok: awsResource(albMod, "TargetGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"health_check": {Name: "healthChecks"},
				},
			},
			"aws_alb_target_group_attachment": {Tok: awsResource(albMod, "TargetGroupAttachment")},
			// Load Balancing (Application and Network)
			"aws_lb": {Tok: awsResource(elbv2Mod, "LoadBalancer")},
			"aws_lb_listener": {
				Tok: awsResource(elbv2Mod, "Listener"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"default_action": {Name: "defaultActions"},
				},
			},
			"aws_lb_listener_rule": {
				Tok: awsResource(elbv2Mod, "ListenerRule"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"action":    {Name: "actions"},
					"condition": {Name: "conditions"},
				},
			},
			"aws_lb_target_group": {
				Tok: awsResource(elbv2Mod, "TargetGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"health_check": {Name: "healthChecks"},
				},
			},
			"aws_lb_target_group_attachment": {Tok: awsResource(elbv2Mod, "TargetGroupAttachment")},
			// Elastic Search
			"aws_elasticsearch_domain":        {Tok: awsResource(elasticsearchMod, "Domain")},
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
			// Glacier
			"aws_glacier_vault": {Tok: awsResource(glacierMod, "Vault")},
			// Identity and Access Management (IAM)
			"aws_iam_access_key":              {Tok: awsResource(iamMod, "AccessKey")},
			"aws_iam_account_alias":           {Tok: awsResource(iamMod, "AccountAlias")},
			"aws_iam_account_password_policy": {Tok: awsResource(iamMod, "AccountPasswordPolicy")},
			"aws_iam_group_policy":            {Tok: awsResource(iamMod, "GroupPolicy")},
			"aws_iam_group":                   {Tok: awsResource(iamMod, "Group")},
			"aws_iam_group_membership":        {Tok: awsResource(iamMod, "GroupMembership")},
			"aws_iam_group_policy_attachment": {
				Tok: awsResource(iamMod, "GroupPolicyAttachment"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"group": {Type: awsType(iamMod+"/group", "Group")},
					"policy_arn": {
						Name: "policyArn",
						Type: awsType(awsMod, "ARN"),
					},
				},
			},
			"aws_iam_instance_profile": {
				Tok: awsResource(iamMod, "InstanceProfile"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"role": {Type: awsResource(iamMod, "Role")},
					"roles": {
						Elem: &tfbridge.SchemaInfo{Type: awsResource(iamMod, "Role")},
					},
				},
			},
			"aws_iam_openid_connect_provider": {Tok: awsResource(iamMod, "OpenIdConnectProvider")},
			"aws_iam_policy":                  {Tok: awsResource(iamMod, "Policy")},
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
			},
			"aws_iam_role_policy_attachment": {
				Tok: awsResource(iamMod, "RolePolicyAttachment"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"role": {Type: awsType(iamMod+"/role", "Role")},
					"policy_arn": {
						Name: "policyArn",
						Type: awsType(awsMod, "ARN"),
					},
				},
			},
			"aws_iam_role_policy": {Tok: awsResource(iamMod, "RolePolicy")},
			"aws_iam_role": {
				Tok: awsResource(iamMod, "Role"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"name": tfbridge.AutoName("name", 64),
					"role": {Type: awsType(awsMod, "ARN")},
				},
			},
			"aws_iam_saml_provider":      {Tok: awsResource(iamMod, "SamlProvider")},
			"aws_iam_server_certificate": {Tok: awsResource(iamMod, "ServerCertificate")},
			"aws_iam_user_policy_attachment": {
				Tok: awsResource(iamMod, "UserPolicyAttachment"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"user": {Type: awsType(iamMod+"/user", "User")},
					"policy_arn": {
						Name: "policyArn",
						Type: awsType(awsMod, "ARN"),
					},
				},
			},
			"aws_iam_user_policy":        {Tok: awsResource(iamMod, "UserPolicy")},
			"aws_iam_user_ssh_key":       {Tok: awsResource(iamMod, "SshKey")},
			"aws_iam_user":               {Tok: awsResource(iamMod, "User")},
			"aws_iam_user_login_profile": {Tok: awsResource(iamMod, "UserLoginProfile")},
			// Inspector
			"aws_inspector_assessment_target":   {Tok: awsResource(inspectorMod, "AssessmentTarget")},
			"aws_inspector_assessment_template": {Tok: awsResource(inspectorMod, "AssessmentTemplate")},
			"aws_inspector_resource_group":      {Tok: awsResource(inspectorMod, "ResourceGroup")},
			// IoT
			"aws_iot_certificate": {Tok: awsResource(iotMod, "Certificate")},
			"aws_iot_policy": {
				Tok:      awsResource(iotMod, "Policy"),
				IDFields: []string{"name"},
			},
			// Kinesis
			"aws_kinesis_firehose_delivery_stream": {Tok: awsResource(kinesisMod, "FirehoseDeliveryStream")},
			"aws_kinesis_stream":                   {Tok: awsResource(kinesisMod, "Stream")},
			// Key Management Service (KMS)
			"aws_kms_alias": {Tok: awsResource(kmsMod, "Alias")},
			"aws_kms_key":   {Tok: awsResource(kmsMod, "Key")},
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
			"aws_lambda_event_source_mapping": {Tok: awsResource(lambdaMod, "EventSourceMapping")},
			"aws_lambda_alias":                {Tok: awsResource(lambdaMod, "Alias")},
			"aws_lambda_permission": {
				Tok:      awsResource(lambdaMod, "Permission"),
				IDFields: []string{"statement_id"},
				Fields: map[string]*tfbridge.SchemaInfo{
					"function_name": {
						Name: "function",
						Type: awsType(lambdaMod+"/function", "Function"),
					},
					"statement_id": tfbridge.AutoName("statementId", 100),
				},
			},
			// LightSail
			"aws_lightsail_domain":               {Tok: awsResource(lightsailMod, "Domain")},
			"aws_lightsail_instance":             {Tok: awsResource(lightsailMod, "Instance")},
			"aws_lightsail_key_pair":             {Tok: awsResource(lightsailMod, "KeyPair")},
			"aws_lightsail_static_ip":            {Tok: awsResource(lightsailMod, "StaticIp")},
			"aws_lightsail_static_ip_attachment": {Tok: awsResource(lightsailMod, "StaticIpAttachment")},
			// OpsWorks
			"aws_opsworks_application": {
				Tok: awsResource(opsworksMod, "Application"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "applicationId"},
				},
			},
			"aws_opsworks_stack": {
				Tok: awsResource(opsworksMod, "Stack"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "stackId"},
				},
			},
			"aws_opsworks_java_app_layer": {
				Tok: awsResource(opsworksMod, "JavaAppLayer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "layerId"},
				},
			},
			"aws_opsworks_haproxy_layer": {
				Tok: awsResource(opsworksMod, "HaproxyLayer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "layerId"},
				},
			},
			"aws_opsworks_static_web_layer": {
				Tok: awsResource(opsworksMod, "StaticWebLayer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "layerId"},
				},
			},
			"aws_opsworks_php_app_layer": {
				Tok: awsResource(opsworksMod, "PhpAppLayer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "layerId"},
				},
			},
			"aws_opsworks_rails_app_layer": {
				Tok: awsResource(opsworksMod, "RailsAppLayer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "layerId"},
				},
			},
			"aws_opsworks_nodejs_app_layer": {
				Tok: awsResource(opsworksMod, "NodejsAppLayer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "layerId"},
				},
			},
			"aws_opsworks_memcached_layer": {
				Tok: awsResource(opsworksMod, "MemcachedLayer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "layerId"},
				},
			},
			"aws_opsworks_mysql_layer": {
				Tok: awsResource(opsworksMod, "MysqlLayer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "layerId"},
				},
			},
			"aws_opsworks_ganglia_layer": {
				Tok: awsResource(opsworksMod, "GangliaLayer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "layerId"},
				},
			},
			"aws_opsworks_custom_layer": {
				Tok: awsResource(opsworksMod, "CustomLayer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "layerId"},
				},
			},
			"aws_opsworks_instance": {
				Tok: awsResource(opsworksMod, "Instance"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "instanceId"},
				},
			},
			"aws_opsworks_user_profile": {
				Tok: awsResource(opsworksMod, "UserProfile"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "profileId"},
				},
			},
			"aws_opsworks_permission": {
				Tok: awsResource(opsworksMod, "Permission"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "permissionId"},
				},
			},
			"aws_opsworks_rds_db_instance": {
				Tok: awsResource(opsworksMod, "RdsDbInstance"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "instanceId"},
				},
			},
			// Relational Database Service (RDS)
			"aws_rds_cluster":                 {Tok: awsResource(rdsMod, "Cluster")},
			"aws_rds_cluster_instance":        {Tok: awsResource(rdsMod, "ClusterInstance")},
			"aws_rds_cluster_parameter_group": {Tok: awsResource(rdsMod, "ClusterParameterGroup")},
			"aws_db_event_subscription":       {Tok: awsResource(rdsMod, "EventSubscription")},
			"aws_db_instance":                 {Tok: awsResource(rdsMod, "Instance")},
			"aws_db_option_group":             {Tok: awsResource(rdsMod, "OptionGroup")},
			"aws_db_parameter_group":          {Tok: awsResource(rdsMod, "ParameterGroup")},
			"aws_db_security_group":           {Tok: awsResource(rdsMod, "SecurityGroup")},
			"aws_db_snapshot":                 {Tok: awsResource(rdsMod, "Snapshot")},
			"aws_db_subnet_group":             {Tok: awsResource(rdsMod, "SubnetGroup")},
			// RedShift
			"aws_redshift_cluster":         {Tok: awsResource(redshiftMod, "Cluster")},
			"aws_redshift_security_group":  {Tok: awsResource(redshiftMod, "SecurityGroup")},
			"aws_redshift_parameter_group": {Tok: awsResource(redshiftMod, "ParameterGroup")},
			"aws_redshift_subnet_group":    {Tok: awsResource(redshiftMod, "SubnetGroup")},
			// Route53
			"aws_route53_delegation_set":   {Tok: awsResource(route53Mod, "DelegationSet")},
			"aws_route53_record":           {Tok: awsResource(route53Mod, "Record")},
			"aws_route53_zone_association": {Tok: awsResource(route53Mod, "ZoneAssociation")},
			"aws_route53_zone":             {Tok: awsResource(route53Mod, "Zone")},
			"aws_route53_health_check":     {Tok: awsResource(route53Mod, "HealthCheck")},
			// Simple Email Service (SES)
			"aws_ses_active_receipt_rule_set": {Tok: awsResource(sesMod, "ActiveReceiptRuleSet")},
			"aws_ses_domain_identity":         {Tok: awsResource(sesMod, "DomainIdentity")},
			"aws_ses_receipt_filter":          {Tok: awsResource(sesMod, "ReceiptFilter")},
			"aws_ses_receipt_rule":            {Tok: awsResource(sesMod, "ReceiptRule")},
			"aws_ses_receipt_rule_set":        {Tok: awsResource(sesMod, "ReceiptRuleSet")},
			"aws_ses_configuration_set":       {Tok: awsResource(sesMod, "ConfgurationSet")},
			"aws_ses_event_destination":       {Tok: awsResource(sesMod, "EventDestination")},
			// S3
			"aws_s3_bucket": {
				Tok: awsResource(s3Mod, "Bucket"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"bucket": tfbridge.AutoNameTransform("bucket", 63, func(name string) string {
						return strings.ToLower(name)
					}),
				},
			},
			"aws_s3_bucket_policy": {Tok: awsResource(s3Mod, "BucketPolicy")},
			"aws_s3_bucket_object": {
				Tok:      awsResource(s3Mod, "BucketObject"),
				IDFields: []string{"bucket", "key"},
				Fields: map[string]*tfbridge.SchemaInfo{
					"bucket": {Type: awsResource(s3Mod, "Bucket")},
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
			"aws_s3_bucket_notification": {Tok: awsResource(s3Mod, "BucketNotification")},
			// Systems Manager (SSM)
			"aws_ssm_activation":                {Tok: awsResource(ssmMod, "Activation")},
			"aws_ssm_association":               {Tok: awsResource(ssmMod, "Association")},
			"aws_ssm_document":                  {Tok: awsResource(ssmMod, "Document")},
			"aws_ssm_maintenance_window":        {Tok: awsResource(ssmMod, "MaintenanceWindow")},
			"aws_ssm_maintenance_window_target": {Tok: awsResource(ssmMod, "MaintenanceWindowTarget")},
			"aws_ssm_maintenance_window_task":   {Tok: awsResource(ssmMod, "MaintenanceWindowTask")},
			"aws_ssm_patch_baseline":            {Tok: awsResource(ssmMod, "PatchBaseline")},
			"aws_ssm_patch_group":               {Tok: awsResource(ssmMod, "PatchGroup")},
			"aws_ssm_parameter":                 {Tok: awsResource(ssmMod, "Parameter")},
			// SimpleDB
			"aws_simpledb_domain": {Tok: awsResource(simpledbMod, "Domain")},
			// Simple Queuing Service (SQS)
			"aws_sqs_queue":        {Tok: awsResource(sqsMod, "Queue")},
			"aws_sqs_queue_policy": {Tok: awsResource(sqsMod, "QueuePolicy")},
			// Simple Notification Service (SNS)
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
			// Web Application Firewall (WAF)
			"aws_waf_byte_match_set":          {Tok: awsResource(wafMod, "ByteMatchSet")},
			"aws_waf_ipset":                   {Tok: awsResource(wafMod, "IpSet")},
			"aws_waf_rate_based_rule":         {Tok: awsResource(wafMod, "RateBasedRule")},
			"aws_waf_rule":                    {Tok: awsResource(wafMod, "Rule")},
			"aws_waf_size_constraint_set":     {Tok: awsResource(wafMod, "SizeConstraintSet")},
			"aws_waf_web_acl":                 {Tok: awsResource(wafMod, "WebAcl")},
			"aws_waf_xss_match_set":           {Tok: awsResource(wafMod, "XssMatchSet")},
			"aws_waf_sql_injection_match_set": {Tok: awsResource(wafMod, "SqlInjectionMatchSet")},
			// Web Application Firewall (WAF) Regional
			"aws_wafregional_byte_match_set": {Tok: awsResource(wafregionalMod, "ByteMatchSet")},
			"aws_wafregional_ipset":          {Tok: awsResource(wafregionalMod, "IpSet")},
		},
		DataSources: map[string]*tfbridge.DataSourceInfo{
			// AWS
			"aws_ami":                     {Tok: awsDataSource(awsMod, "getAmi")},
			"aws_ami_ids":                 {Tok: awsDataSource(awsMod, "getAmiIds")},
			"aws_autoscaling_groups":      {Tok: awsDataSource(awsMod, "getAutoscalingGroups")},
			"aws_availability_zone":       {Tok: awsDataSource(awsMod, "getAvailabilityZone")},
			"aws_availability_zones":      {Tok: awsDataSource(awsMod, "getAvailabilityZones")},
			"aws_billing_service_account": {Tok: awsDataSource(awsMod, "getBillingServiceAccount")},
			"aws_caller_identity":         {Tok: awsDataSource(awsMod, "getCallerIdentity")},
			"aws_canonical_user_id":       {Tok: awsDataSource(awsMod, "getCanonicalUserId")},
			"aws_eip":                     {Tok: awsDataSource(awsMod, "getElasticIp")},
			"aws_ip_ranges":               {Tok: awsDataSource(awsMod, "getIpRanges")},
			"aws_partition":               {Tok: awsDataSource(awsMod, "getPartition")},
			"aws_prefix_list":             {Tok: awsDataSource(awsMod, "getPrefixList")},
			"aws_region":                  {Tok: awsDataSource(awsMod, "getRegion")},
			// AWS Certificate Manager
			"aws_acm_certificate": {Tok: awsDataSource(acmMod, "getCertificate")},
			// CloudFormation
			"aws_cloudformation_stack": {Tok: awsDataSource(cloudformationMod, "getStack")},
			// EC2
			"aws_instance":               {Tok: awsDataSource(ec2Mod, "getInstance")},
			"aws_internet_gateway":       {Tok: awsDataSource(ec2Mod, "getInternetGateway")},
			"aws_route_table":            {Tok: awsDataSource(ec2Mod, "getRouteTable")},
			"aws_security_group":         {Tok: awsDataSource(ec2Mod, "getSecurityGroup")},
			"aws_subnet":                 {Tok: awsDataSource(ec2Mod, "getSubnet")},
			"aws_subnet_ids":             {Tok: awsDataSource(ec2Mod, "getSubnetIds")},
			"aws_vpc":                    {Tok: awsDataSource(ec2Mod, "getVpc")},
			"aws_vpc_endpoint":           {Tok: awsDataSource(ec2Mod, "getVpcEndpoint")},
			"aws_vpc_endpoint_service":   {Tok: awsDataSource(ec2Mod, "getVpcEndpointService")},
			"aws_vpc_peering_connection": {Tok: awsDataSource(ec2Mod, "getVpcPeeringConnection")},
			"aws_vpn_gateway":            {Tok: awsDataSource(ec2Mod, "getVpnGateway")},
			// Elastic Block Storage
			"aws_ebs_snapshot":     {Tok: awsDataSource(ebsMod, "getSnapshot")},
			"aws_ebs_snapshot_ids": {Tok: awsDataSource(ebsMod, "getSnapshotIds")},
			"aws_ebs_volume":       {Tok: awsDataSource(ebsMod, "getVolume")},
			// Elastic Container Registry
			"aws_ecr_credentials": {Tok: awsDataSource(ecrMod, "getCredentials")},
			"aws_ecr_repository":  {Tok: awsDataSource(ecrMod, "getRepository")},
			// Elastic Container Service
			"aws_ecs_cluster":              {Tok: awsDataSource(ecsMod, "getCluster")},
			"aws_ecs_container_definition": {Tok: awsDataSource(ecsMod, "getContainerDefinition")},
			"aws_ecs_task_definition":      {Tok: awsDataSource(ecsMod, "getTaskDefinition")},
			// Elastic Filesystem
			"aws_efs_file_system":  {Tok: awsDataSource(efsMod, "getFileSystem")},
			"aws_efs_mount_target": {Tok: awsDataSource(efsMod, "getMountTarget")},
			// Elastic Beanstalk
			"aws_elastic_beanstalk_solution_stack": {Tok: awsDataSource(elasticbeanstalkMod, "getSolutionStack")},
			// ElastiCache
			"aws_elasticache_cluster": {Tok: awsDataSource(elasticacheMod, "getCluster")},
			// Elastic Load Balancing
			"aws_elb_hosted_zone_id":  {Tok: awsDataSource(elbMod, "getHostedZoneId")},
			"aws_elb_service_account": {Tok: awsDataSource(elbMod, "getServiceAccount")},
			// Elastic Load Balancing (v2: Application)
			"aws_alb":              {Tok: awsDataSource(albMod, "getLoadBalancerInfo")},
			"aws_alb_listener":     {Tok: awsDataSource(albMod, "getListenerInfo")},
			"aws_alb_target_group": {Tok: awsDataSource(albMod, "getTargetGroupInfo")},
			// Load Balancing (Application and Network)
			"aws_lb":              {Tok: awsDataSource(elbv2Mod, "getLoadBalancerInfo")},
			"aws_lb_listener":     {Tok: awsDataSource(elbv2Mod, "getListenerInfo")},
			"aws_lb_target_group": {Tok: awsDataSource(elbv2Mod, "getTargetGroupInfo")},
			// IAM
			"aws_iam_account_alias":      {Tok: awsDataSource(iamMod, "getAccountAlias")},
			"aws_iam_group":              {Tok: awsDataSource(iamMod, "getGroup")},
			"aws_iam_instance_profile":   {Tok: awsDataSource(iamMod, "getInstanceProfile")},
			"aws_iam_policy_document":    {Tok: awsDataSource(iamMod, "getPolicyDocument")},
			"aws_iam_role":               {Tok: awsDataSource(iamMod, "getRole")},
			"aws_iam_server_certificate": {Tok: awsDataSource(iamMod, "getServerCertificate")},
			// Kinesis
			"aws_kinesis_stream": {Tok: awsDataSource(kinesisMod, "getStream")},
			// Key Management Service
			"aws_kms_alias":      {Tok: awsDataSource(kmsMod, "getAlias")},
			"aws_kms_ciphertext": {Tok: awsDataSource(kmsMod, "getCipherText")},
			"aws_kms_secret":     {Tok: awsDataSource(kmsMod, "getSecret")},
			// RDS
			"aws_db_instance": {Tok: awsDataSource(rdsMod, "getInstance")},
			"aws_db_snapshot": {Tok: awsDataSource(rdsMod, "getSnapshot")},
			// RedShift
			"aws_redshift_service_account": {Tok: awsDataSource(redshiftMod, "getServiceAccount")},
			// Route53
			"aws_route53_zone": {Tok: awsDataSource(route53Mod, "getZone")},
			// S3
			"aws_s3_bucket_object": {Tok: awsDataSource(s3Mod, "getBucketObject")},
			// SNS
			"aws_sns_topic": {Tok: awsDataSource(snsMod, "getTopic")},
			// SSM
			"aws_ssm_parameter": {Tok: awsDataSource(ssmMod, "getParameter")},
		},
		Overlay: &tfbridge.OverlayInfo{
			Files: []string{
				"arn.ts",    // ARN typedef
				"region.ts", // Region union type and constants
			},
			Modules: map[string]*tfbridge.OverlayInfo{
				"config": {
					Files: []string{
						"require.ts", // requireRegion helpers for validating proper config
					},
				},
				"ec2": {
					Files: []string{
						"instanceMaps.ts", // getLinuxAMI helper for looking up AMIs
						"instanceType.ts", // InstanceType union type and constants
					},
				},
				"iam": {
					Files: []string{
						"documents.ts",       // policy document schemas.
						"managedPolicies.ts", // handy constants that predefine all known managed policies.
					},
				},
				"lambda": {
					Files: []string{
						"runtimes.ts", // a union type and constants for available Lambda runtimes.
					},
				},
				"serverless": {
					Files: []string{
						"function.ts", // a union type and constants for available Lambda runtimes.
					},
				},
			},
			Dependencies: map[string]string{
				"@types/node": "^8.0.25", // so we can access strongly typed node definitions.
			},
		},
	}

	// For all resources with name properties, we will add an auto-name property.  Make sure to skip those that
	// already have a name mapping entry, since those may have custom overrides set above (e.g., for length).
	const awsName = "name"
	for resname, res := range prov.Resources {
		if schema := p.ResourcesMap[resname]; schema != nil {
			if _, has := schema.Schema[awsName]; has {
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
