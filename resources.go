// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package aws

import (
	"strings"
	"unicode"

	"github.com/hashicorp/terraform/helper/schema"
	"github.com/pulumi/pulumi-fabric/pkg/resource"
	"github.com/pulumi/pulumi-fabric/pkg/tokens"
	"github.com/pulumi/pulumi-terraform/pkg/tfbridge"
	"github.com/terraform-providers/terraform-provider-aws/aws"
)

// all of the AWS token components used below.
const (
	// packages:
	awsPkg = "aws"
	// modules:
	awsMod               = "index"                  // the root index.
	apigatewayMod        = "apigateway"             // API Gateway
	appautoscalingMod    = "appautoscaling"         // Application Auto Scaling
	autoscalingMod       = "autoscaling"            // Auto Scaling
	cloudformationMod    = "cloudformation"         // Cloud Formation
	cloudfrontMod        = "cloudfront"             // Cloud Front
	cloudtrailMod        = "cloudtrail"             // Cloud Trail
	cloudwatchMod        = "cloudwatch"             // Cloud Watch
	codebuildMod         = "codebuild"              // Code Build
	codecommitMod        = "codecommit"             // Code Commit
	codedeployMod        = "codedeploy"             // Code Deploy
	codepipelineMod      = "codepipeline"           // Code Pipeline
	cognitoMod           = "cognito"                // Cognito
	cfgMod               = "cfg"                    // Resource Config
	devicefarmMod        = "devicefarm"             // Device Farm
	directoryserviceMod  = "directoryservice"       // Directory Services
	dynamodbMod          = "dynamodb"               // DynamoDB
	dmsMod               = "dms"                    // Data Migraiton Services
	ebsMod               = "ebs"                    // Elastic Block Store
	ec2Mod               = "ec2"                    // EC2
	ecrMod               = "ecr"                    // Elastic Container Registry
	ecsMod               = "ecs"                    // Elastic Container Service
	efsMod               = "efs"                    // Elastic Filesystem
	elasticacheMod       = "elasticache"            // ElastiCache
	elasticbeanstalkMod  = "elasticbeanstalk"       // Elastic Beanstalk
	elasticsearchMod     = "elasticsearch"          // ElasticSearch
	elastictranscoderMod = "elastictranscoder"      // Elastic Transcoder
	elbMod               = "elasticloadbalancing"   // Elastic Load Balancing
	elbv2Mod             = "elasticloadbalancingv2" // Elastic Load Balancing (V2: Application)
	emrMod               = "emr"                    // Elastic MapReduce
	glacierMod           = "glacier"                // Glacier
	iamMod               = "iam"                    // Identity and Access Management (IAM)
	inspectorMod         = "inspector"              // Inspector
	iotMod               = "iot"                    // Internet of Things (IoT)
	kinesisMod           = "kinesis"                // Kinesis
	kmsMod               = "kms"                    // Key Management Service (KMS)
	lambdaMod            = "lambda"                 // Lambda
	lightsailMod         = "lightsail"              // LightSail
	opsworksMod          = "opsworks"               // OpsWorks
	rdsMod               = "rds"                    // Relational Database Service (RDS)
	redshiftMod          = "redshift"               // RedShift
	route53Mod           = "route53"                // Route 53 (DNS)
	sesMod               = "ses"                    // Simple Email Service (SES)
	s3Mod                = "s3"                     // Simple Storage (S3)
	ssmMod               = "ssm"                    // System Manager
	sfnMod               = "sfn"                    // Step Functions (SFN)
	simpledbMod          = "simpledb"               // Simple DB
	snsMod               = "sns"                    // Simple Notification Service (SNS)
	sqsMod               = "sqs"                    // Simple Queueing Service (SQS)
	wafMod               = "waf"                    // Web Application Firewall (WAF)
	wafregionalMod       = "wafregional"            // Web Application Firewall (WAF) Regional
)

// awstok manufactures a type token for the AWS package and the given module and type.
func awstok(mod string, typ string) tokens.Type {
	return tokens.Type(awsPkg + ":" + mod + ":" + typ)
}

// awsrestok manufactures a standard resource token given a module and resource name.  It automatically uses the AWS
// package and names the file by simply lower casing the resource's first character.
func awsrestok(mod string, res string) tokens.Type {
	fn := string(unicode.ToLower(rune(res[0]))) + res[1:]
	return awstok(mod+"/"+fn, res)
}

// Provider returns additional overlaid schema and metadata associated with the aws package.
func Provider() tfbridge.ProviderInfo {
	p := aws.Provider().(*schema.Provider)
	prov := tfbridge.ProviderInfo{
		P:    p,
		Name: "aws",
		Config: map[string]*tfbridge.SchemaInfo{
			"region": {
				Type: awstok("region", "Region"),
			},
		},
		Resources: map[string]*tfbridge.ResourceInfo{
			// API Gateway
			"aws_api_gateway_account": {Tok: awsrestok(apigatewayMod, "Account")},
			"aws_api_gateway_api_key": {
				Tok: awsrestok(apigatewayMod, "ApiKey"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"stage_key": {
						Elem: &tfbridge.SchemaInfo{
							Fields: map[string]*tfbridge.SchemaInfo{
								"rest_api_id": {
									Name: "restApi",
									Type: awstok(apigatewayMod+"/restApi", "RestApi"),
								},
							},
						},
					},
				},
			},
			"aws_api_gateway_authorizer": {
				Tok: awsrestok(apigatewayMod, "Authorizer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name: "restApi",
						Type: awstok(apigatewayMod+"/restApi", "RestApi"),
					},
				},
			},
			"aws_api_gateway_base_path_mapping": {
				Tok: awsrestok(apigatewayMod, "BasePathMapping"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"api_id": {
						Name: "restApi",
						Type: awstok(apigatewayMod+"/restApi", "RestApi"),
					},
				},
			},
			"aws_api_gateway_client_certificate": {Tok: awsrestok(apigatewayMod, "ClientCertificate")},
			"aws_api_gateway_deployment": {
				Tok: awsrestok(apigatewayMod, "Deployment"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name: "restApi",
						Type: awstok(apigatewayMod+"/restApi", "RestApi"),
					},
				},
			},
			"aws_api_gateway_domain_name": {Tok: awsrestok(apigatewayMod, "DomainName")},
			"aws_api_gateway_integration": {
				Tok: awsrestok(apigatewayMod, "Integration"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name: "restApi",
						Type: awstok(apigatewayMod+"/restApi", "RestApi"),
					},
				},
			},
			"aws_api_gateway_integration_response": {
				Tok: awsrestok(apigatewayMod, "IntegrationResponse"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name: "restApi",
						Type: awstok(apigatewayMod+"/restApi", "RestApi"),
					},
				},
			},
			"aws_api_gateway_method": {
				Tok: awsrestok(apigatewayMod, "Method"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name: "restApi",
						Type: awstok(apigatewayMod+"/restApi", "RestApi"),
					},
				},
			},
			"aws_api_gateway_method_response": {
				Tok: awsrestok(apigatewayMod, "MethodResponse"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name: "restApi",
						Type: awstok(apigatewayMod+"/restApi", "RestApi"),
					},
				}},
			"aws_api_gateway_method_settings": {
				Tok: awsrestok(apigatewayMod, "MethodSettings"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name: "restApi",
						Type: awstok(apigatewayMod+"/restApi", "RestApi"),
					},
				}},
			"aws_api_gateway_model": {
				Tok: awsrestok(apigatewayMod, "Model"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name: "restApi",
						Type: awstok(apigatewayMod+"/restApi", "RestApi"),
					},
				}},
			"aws_api_gateway_request_validator": {
				Tok: awsrestok(apigatewayMod, "RequestValidator"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name: "restApi",
						Type: awstok(apigatewayMod+"/restApi", "RestApi"),
					},
				},
			},
			"aws_api_gateway_resource": {
				Tok: awsrestok(apigatewayMod, "Resource"),
				Fields: map[string]*tfbridge.SchemaInfo{
					// TODO[pulumi/terraform-bridge#5] Strongly type the parent refernence to align with other uses
					// "parent_id": {
					// 	Name: "parent",
					// 	Type: awstok(apigatewayMod+"/resource", "Resource"),
					// },
					"rest_api_id": {
						Name: "restApi",
						Type: awstok(apigatewayMod+"/restApi", "RestApi"),
					},
				},
			},
			"aws_api_gateway_gateway_response": {Tok: awsrestok(apigatewayMod, "Response")},
			"aws_api_gateway_rest_api":         {Tok: awsrestok(apigatewayMod, "RestApi")},
			"aws_api_gateway_stage": {
				Tok: awsrestok(apigatewayMod, "Stage"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"deployment_id": {
						Name: "deployment",
						Type: awstok(apigatewayMod+"/deployment", "Deployment"),
					},
					"rest_api_id": {
						Name: "restApi",
						Type: awstok(apigatewayMod+"/restApi", "RestApi"),
					},
				},
			},
			"aws_api_gateway_usage_plan":     {Tok: awsrestok(apigatewayMod, "UsagePlan")},
			"aws_api_gateway_usage_plan_key": {Tok: awsrestok(apigatewayMod, "UsagePlanKey")},
			// Application Auto Scaling
			"aws_appautoscaling_target": {Tok: awsrestok(appautoscalingMod, "Target")},
			"aws_appautoscaling_policy": {Tok: awsrestok(appautoscalingMod, "Policy")},
			// Auto Scaling
			"aws_autoscaling_attachment": {Tok: awsrestok(autoscalingMod, "Attachment")},
			"aws_autoscaling_group":      {Tok: awsrestok(autoscalingMod, "Group")},
			"aws_autoscaling_lifecycle_hook": {
				Tok: awsrestok(autoscalingMod, "LifecycleHook"),
				Docs: &tfbridge.DocInfo{
					Source: "autoscaling_lifecycle_hooks.html.markdown",
				},
			},
			"aws_autoscaling_notification": {Tok: awsrestok(autoscalingMod, "Notification")},
			"aws_autoscaling_policy":       {Tok: awsrestok(autoscalingMod, "Policy")},
			"aws_autoscaling_schedule":     {Tok: awsrestok(autoscalingMod, "Schedule")},
			// CloudFormation
			"aws_cloudformation_stack": {Tok: awsrestok(cloudformationMod, "Stack")},
			// CloudFront
			"aws_cloudfront_distribution":           {Tok: awsrestok(cloudfrontMod, "Distribution")},
			"aws_cloudfront_origin_access_identity": {Tok: awsrestok(cloudfrontMod, "OriginAccessIdentity")},
			// CloudTrail
			"aws_cloudtrail": {Tok: awsrestok(cloudtrailMod, "Trail")},
			// CloudWatch
			"aws_cloudwatch_event_rule":             {Tok: awsrestok(cloudwatchMod, "EventRule")},
			"aws_cloudwatch_event_target":           {Tok: awsrestok(cloudwatchMod, "EventTarget")},
			"aws_cloudwatch_log_destination":        {Tok: awsrestok(cloudwatchMod, "LogDestination")},
			"aws_cloudwatch_log_destination_policy": {Tok: awsrestok(cloudwatchMod, "LogDestinationPolicy")},
			"aws_cloudwatch_log_group": {
				IDFields: []string{"name"},
				Tok:      awsrestok(cloudwatchMod, "LogGroup"),
			},
			"aws_cloudwatch_log_metric_filter": {Tok: awsrestok(cloudwatchMod, "LogMetricFilter")},
			"aws_cloudwatch_log_stream":        {Tok: awsrestok(cloudwatchMod, "LogStream")},
			"aws_cloudwatch_log_subscription_filter": {
				Tok: awsrestok(cloudwatchMod, "LogSubscriptionFilter"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"log_group_name": {
						Name: "logGroup",
						Type: awsrestok(cloudwatchMod, "LogGroup"),
					},
				},
			},
			"aws_cloudwatch_metric_alarm": {
				Tok: awsrestok(cloudwatchMod, "MetricAlarm"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"alarm_name": tfbridge.AutoName("name", 255),
					"alarm_actions": {
						Elem: &tfbridge.SchemaInfo{
							Type: awsrestok(snsMod, "Topic"),
						},
					},
					"insufficient_data_actions": {
						Elem: &tfbridge.SchemaInfo{
							Type: awsrestok(snsMod, "Topic"),
						},
					},
					"ok_actions": {
						Elem: &tfbridge.SchemaInfo{
							Type: awsrestok(snsMod, "Topic"),
						},
					},
				},
			},
			// CodeBuild
			"aws_codebuild_project": {Tok: awsrestok(codebuildMod, "Project")},
			// CodeDeploy
			"aws_codedeploy_app":               {Tok: awsrestok(codedeployMod, "Application")},
			"aws_codedeploy_deployment_config": {Tok: awsrestok(codedeployMod, "DeploymentConfig")},
			"aws_codedeploy_deployment_group":  {Tok: awsrestok(codedeployMod, "DeploymentGroup")},
			// CodeCommit
			"aws_codecommit_repository": {
				Tok: awsrestok(codecommitMod, "Repository"),
				Docs: &tfbridge.DocInfo{
					Source: "code_commit_repository.html.markdown",
				},
			},
			"aws_codecommit_trigger": {
				Tok: awsrestok(codecommitMod, "Trigger"),
				Docs: &tfbridge.DocInfo{
					Source: "code_commit_trigger.html.markdown",
				},
			},
			// CodePipeline
			"aws_codepipeline": {Tok: awsrestok(codepipelineMod, "Pipeline")},
			// Cognito
			"aws_cognito_identity_pool": {Tok: awsrestok(cognitoMod, "IdentityPool")},
			// Config
			"aws_config_config_rule":                   {Tok: awsrestok(cfgMod, "Rule")},
			"aws_config_configuration_recorder":        {Tok: awsrestok(cfgMod, "Recorder")},
			"aws_config_configuration_recorder_status": {Tok: awsrestok(cfgMod, "RecorderStatus")},
			"aws_config_delivery_channel":              {Tok: awsrestok(cfgMod, "DeliveryChannel")},
			// Data Migration Service
			"aws_dms_certificate":              {Tok: awsrestok(dmsMod, "Certificate")},
			"aws_dms_endpoint":                 {Tok: awsrestok(dmsMod, "Endpoint")},
			"aws_dms_replication_instance":     {Tok: awsrestok(dmsMod, "ReplicationInstance")},
			"aws_dms_replication_subnet_group": {Tok: awsrestok(dmsMod, "ReplicationSubnetGroup")},
			"aws_dms_replication_task":         {Tok: awsrestok(dmsMod, "ReplicationTask")},
			// DeviceFarm
			"aws_devicefarm_project": {Tok: awsrestok(devicefarmMod, "Project")},
			// DirectoryService
			"aws_directory_service_directory": {Tok: awsrestok(directoryserviceMod, "Directory")},
			// DynamoDB
			"aws_dynamodb_table": {Tok: awsrestok(dynamodbMod, "Table")},
			// Elastic Beanstalk
			"aws_elastic_beanstalk_application": {Tok: awsrestok(elasticbeanstalkMod, "Application")},
			"aws_elastic_beanstalk_application_version": {
				Tok: awsrestok(elasticbeanstalkMod, "ApplicationVersion"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"application": {Type: awsrestok(elasticbeanstalkMod, "Application")},
					"bucket":      {Type: awsrestok(s3Mod, "Bucket")},
				},
			},
			"aws_elastic_beanstalk_configuration_template": {Tok: awsrestok(elasticbeanstalkMod, "ConfigurationTemplate")},
			"aws_elastic_beanstalk_environment": {
				Tok: awsrestok(elasticbeanstalkMod, "Environment"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"name":        tfbridge.AutoName("name", 40),
					"application": {Type: awsrestok(elasticbeanstalkMod, "Application")},
					"version_label": {
						Name: "version",
						Type: awsrestok(elasticbeanstalkMod, "ApplicationVersion"),
					},
				},
			},
			// Elastic Block Store
			"aws_ebs_snapshot": {Tok: awsrestok(ebsMod, "Snapshot")},
			"aws_ebs_volume":   {Tok: awsrestok(ebsMod, "Volume")},
			// ElastiCache
			"aws_elasticache_cluster":           {Tok: awsrestok(elasticacheMod, "Cluster")},
			"aws_elasticache_parameter_group":   {Tok: awsrestok(elasticacheMod, "ParameterGroup")},
			"aws_elasticache_replication_group": {Tok: awsrestok(elasticacheMod, "ReplicationGroup")},
			"aws_elasticache_security_group":    {Tok: awsrestok(elasticacheMod, "SecurityGroup")},
			"aws_elasticache_subnet_group":      {Tok: awsrestok(elasticacheMod, "SubnetGroup")},
			// Elastic Compute (EC2)
			"aws_ami": {
				Tok: awsrestok(ec2Mod, "Ami"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "amiId"},
				},
			},
			"aws_ami_copy": {
				Tok: awsrestok(ec2Mod, "AmiCopy"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "amiId"},
				},
				Docs: &tfbridge.DocInfo{
					IncludeArgumentsFrom:           "aws_ami",
					IncludeAttributesFromArguments: "aws_ami",
				},
			},
			"aws_ami_from_instance": {
				Tok: awsrestok(ec2Mod, "AmiFromInstance"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "amiId"},
				},
				Docs: &tfbridge.DocInfo{
					IncludeAttributesFromArguments: "aws_ami",
				},
			},
			"aws_ami_launch_permission":        {Tok: awsrestok(ec2Mod, "AmiLaunchPermission")},
			"aws_customer_gateway":             {Tok: awsrestok(ec2Mod, "CustomerGateway")},
			"aws_egress_only_internet_gateway": {Tok: awsrestok(ec2Mod, "EgressOnlyInternetGateway")},
			"aws_eip":                          {Tok: awsrestok(ec2Mod, "Eip")},
			"aws_eip_association":              {Tok: awsrestok(ec2Mod, "EipAssociation")},
			"aws_flow_log":                     {Tok: awsrestok(ec2Mod, "FlowLog")},
			"aws_instance": {
				Tok: awsrestok(ec2Mod, "Instance"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"instance_type": {
						Type: awstok(ec2Mod+"/instanceType", "InstanceType"),
					},
				},
			},
			"aws_internet_gateway": {Tok: awsrestok(ec2Mod, "InternetGateway")},
			"aws_iot_policy": {
				Tok:      awsrestok(iotMod, "Policy"),
				IDFields: []string{"name"},
			},
			"aws_key_pair": {Tok: awsrestok(ec2Mod, "KeyPair")},
			"aws_launch_configuration": {
				Tok: awsrestok(ec2Mod, "LaunchConfiguration"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"ebs_block_device": {Name: "ebsBlockDevices"},
				},
			},
			"aws_main_route_table_association": {
				Tok: awsrestok(ec2Mod, "MainRouteTableAssociation"),
				Docs: &tfbridge.DocInfo{
					Source: "main_route_table_assoc.html.markdown",
				},
			},
			"aws_nat_gateway":                       {Tok: awsrestok(ec2Mod, "NatGateway")},
			"aws_network_acl":                       {Tok: awsrestok(ec2Mod, "NetworkAcl")},
			"aws_default_network_acl":               {Tok: awsrestok(ec2Mod, "DefaultNetworkAcl")},
			"aws_network_acl_rule":                  {Tok: awsrestok(ec2Mod, "NetworkAclRule")},
			"aws_network_interface":                 {Tok: awsrestok(ec2Mod, "NetworkInterface")},
			"aws_network_interface_attachment":      {Tok: awsrestok(ec2Mod, "NetworkInterfaceAttachment")},
			"aws_placement_group":                   {Tok: awsrestok(ec2Mod, "PlacementGroup")},
			"aws_proxy_protocol_policy":             {Tok: awsrestok(ec2Mod, "ProxyProtocolPolicy")},
			"aws_route":                             {Tok: awsrestok(ec2Mod, "Route")},
			"aws_route_table":                       {Tok: awsrestok(ec2Mod, "RouteTable")},
			"aws_default_route_table":               {Tok: awsrestok(ec2Mod, "DefaultRouteTable")},
			"aws_route_table_association":           {Tok: awsrestok(ec2Mod, "RouteTableAssociation")},
			"aws_security_group":                    {Tok: awsrestok(ec2Mod, "SecurityGroup")},
			"aws_network_interface_sg_attachment":   {Tok: awsrestok(ec2Mod, "NetworkInterfaceSecurityGroupAttachment")},
			"aws_default_security_group":            {Tok: awsrestok(ec2Mod, "DefaultSecurityGroup")},
			"aws_security_group_rule":               {Tok: awsrestok(ec2Mod, "SecurityGroupRule")},
			"aws_snapshot_create_volume_permission": {Tok: awsrestok(ec2Mod, "SnapshotCreateVolumePermission")},
			"aws_spot_datafeed_subscription":        {Tok: awsrestok(ec2Mod, "SpotDatafeedSubscription")},
			"aws_spot_instance_request": {
				Tok: awsrestok(ec2Mod, "SpotInstanceRequest"),
				Docs: &tfbridge.DocInfo{
					IncludeArgumentsFrom: "aws_instance",
				},
			},
			"aws_spot_fleet_request":           {Tok: awsrestok(ec2Mod, "SpotFleetRequest")},
			"aws_default_subnet":               {Tok: awsrestok(ec2Mod, "DefaultSubnet")},
			"aws_subnet":                       {Tok: awsrestok(ec2Mod, "Subnet")},
			"aws_volume_attachment":            {Tok: awsrestok(ec2Mod, "VolumeAttachment")},
			"aws_vpc_dhcp_options_association": {Tok: awsrestok(ec2Mod, "VpcDhcpOptionsAssociation")},
			"aws_default_vpc_dhcp_options":     {Tok: awsrestok(ec2Mod, "DefaultVpcDhcpOptions")},
			"aws_vpc_dhcp_options":             {Tok: awsrestok(ec2Mod, "VpcDhcpOptions")},
			"aws_vpc_peering_connection": {
				Tok: awsrestok(ec2Mod, "VpcPeeringConnection"),
				Docs: &tfbridge.DocInfo{
					Source: "vpc_peering.html.markdown",
				},
			},
			"aws_vpc_peering_connection_accepter": {
				Tok: awsrestok(ec2Mod, "VpcPeeringConnectionAccepter"),
				Docs: &tfbridge.DocInfo{
					Source: "vpc_peering_accepter.html.markdown",
				},
			},
			"aws_default_vpc":                          {Tok: awsrestok(ec2Mod, "DefaultVpc")},
			"aws_vpc":                                  {Tok: awsrestok(ec2Mod, "Vpc")},
			"aws_vpc_endpoint":                         {Tok: awsrestok(ec2Mod, "VpcEndpoint")},
			"aws_vpc_endpoint_route_table_association": {Tok: awsrestok(ec2Mod, "VpcEndpointRouteTableAssociation")},
			"aws_vpn_connection":                       {Tok: awsrestok(ec2Mod, "VpnConnection")},
			"aws_vpn_connection_route":                 {Tok: awsrestok(ec2Mod, "VpnConnectionRoute")},
			"aws_vpn_gateway":                          {Tok: awsrestok(ec2Mod, "VpnGateway")},
			"aws_vpn_gateway_attachment":               {Tok: awsrestok(ec2Mod, "VpnGatewayAttachment")},
			"aws_vpn_gateway_route_propagation":        {Tok: awsrestok(ec2Mod, "VpnGatewayRoutePropagation")},
			// Elastic Container Registry
			"aws_ecr_repository":        {Tok: awsrestok(ecrMod, "Repository")},
			"aws_ecr_repository_policy": {Tok: awsrestok(ecrMod, "RepositoryPolicy")},
			// Elastic Container Service
			"aws_ecs_cluster": {Tok: awsrestok(ecsMod, "Cluster")},
			"aws_ecs_service": {
				Tok: awsrestok(ecsMod, "Service"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"load_balancer": {Name: "loadBalancers"},
				},
			},
			"aws_ecs_task_definition": {Tok: awsrestok(ecsMod, "TaskDefinition")},
			// Elastic File System
			"aws_efs_file_system":  {Tok: awsrestok(efsMod, "FileSystem")},
			"aws_efs_mount_target": {Tok: awsrestok(efsMod, "MountTarget")},
			// Elastic Load Balancing
			"aws_elb":                                 {Tok: awsrestok(elbMod, "LoadBalancer")},
			"aws_elb_attachment":                      {Tok: awsrestok(elbMod, "Attachment")},
			"aws_lb_cookie_stickiness_policy":         {Tok: awsrestok(elbMod, "CookieStickinessPolicy")},
			"aws_load_balancer_policy":                {Tok: awsrestok(elbMod, "LoadBalancerPolicy")},
			"aws_load_balancer_backend_server_policy": {Tok: awsrestok(elbMod, "LoadBalancerBackendServerPolicy")},
			"aws_load_balancer_listener_policy":       {Tok: awsrestok(elbMod, "ListenerPolicy")},
			"aws_lb_ssl_negotiation_policy":           {Tok: awsrestok(elbMod, "SslNegotiationPolicy")},
			// Elastic Load Balancing (V2: Application)
			"aws_app_cookie_stickiness_policy": {Tok: awsrestok(elbMod, "CookieStickinessPolicy")},
			"aws_alb":                          {Tok: awsrestok(elbv2Mod, "LoadBalancer")},
			"aws_alb_listener": {
				Tok: awsrestok(elbv2Mod, "Listener"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"default_action": {Name: "defaultActions"},
				},
			},
			"aws_alb_listener_rule": {
				Tok: awsrestok(elbv2Mod, "ListenerRule"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"action":    {Name: "actions"},
					"condition": {Name: "conditions"},
				},
			},
			"aws_alb_target_group": {
				Tok: awsrestok(elbv2Mod, "TargetGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"health_check": {Name: "healthChecks"},
				},
			},
			"aws_alb_target_group_attachment": {Tok: awsrestok(elbv2Mod, "TargetGroupAttachment")},
			// Elastic Search
			"aws_elasticsearch_domain":        {Tok: awsrestok(elasticsearchMod, "Domain")},
			"aws_elasticsearch_domain_policy": {Tok: awsrestok(elasticsearchMod, "DomainPolicy")},
			// Elastic Transcoder
			"aws_elastictranscoder_pipeline": {
				Tok: awsrestok(elastictranscoderMod, "Pipeline"),
				Docs: &tfbridge.DocInfo{
					Source: "elastic_transcoder_pipeline.html.markdown",
				},
			},
			"aws_elastictranscoder_preset": {
				Tok: awsrestok(elastictranscoderMod, "Preset"),
				Docs: &tfbridge.DocInfo{
					Source: "elastic_transcoder_preset.html.markdown",
				},
			},
			// Elastic MapReduce
			"aws_emr_cluster":                {Tok: awsrestok(emrMod, "Cluster")},
			"aws_emr_instance_group":         {Tok: awsrestok(emrMod, "InstanceGroup")},
			"aws_emr_security_configuration": {Tok: awsrestok(emrMod, "SecurityConfiguration")},
			// Glacier
			"aws_glacier_vault": {Tok: awsrestok(glacierMod, "Vault")},
			// Identity and Access Management (IAM)
			"aws_iam_access_key":              {Tok: awsrestok(iamMod, "AccessKey")},
			"aws_iam_account_alias":           {Tok: awsrestok(iamMod, "AccountAlias")},
			"aws_iam_account_password_policy": {Tok: awsrestok(iamMod, "AccountPasswordPolicy")},
			"aws_iam_group_policy":            {Tok: awsrestok(iamMod, "GroupPolicy")},
			"aws_iam_group":                   {Tok: awsrestok(iamMod, "Group")},
			"aws_iam_group_membership":        {Tok: awsrestok(iamMod, "GroupMembership")},
			"aws_iam_group_policy_attachment": {
				Tok: awsrestok(iamMod, "GroupPolicyAttachment"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"group": {Type: awstok(iamMod+"/group", "Group")},
					"policy_arn": {
						Name: "policyArn",
						Type: awstok(awsMod, "ARN"),
					},
				},
			},
			"aws_iam_instance_profile": {
				Tok: awsrestok(iamMod, "InstanceProfile"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"role": {Type: awsrestok(iamMod, "Role")},
					"roles": {
						Elem: &tfbridge.SchemaInfo{Type: awsrestok(iamMod, "Role")},
					},
				},
			},
			"aws_iam_openid_connect_provider": {Tok: awsrestok(iamMod, "OpenIdConnectProvider")},
			"aws_iam_policy":                  {Tok: awsrestok(iamMod, "Policy")},
			"aws_iam_policy_attachment": {
				Tok: awsrestok(iamMod, "PolicyAttachment"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"users": {
						Elem: &tfbridge.SchemaInfo{Type: awstok(iamMod+"/user", "User")},
					},
					"roles": {
						Elem: &tfbridge.SchemaInfo{Type: awstok(iamMod+"/role", "Role")},
					},
					"groups": {
						Elem: &tfbridge.SchemaInfo{Type: awstok(iamMod+"/group", "Group")},
					},
					"policy_arn": {
						Name: "policyArn",
						Type: awstok(awsMod, "ARN"),
					},
				},
			},
			"aws_iam_role_policy_attachment": {
				Tok: awsrestok(iamMod, "RolePolicyAttachment"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"role": {Type: awstok(iamMod+"/role", "Role")},
					"policy_arn": {
						Name: "policyArn",
						Type: awstok(awsMod, "ARN"),
					},
				},
			},
			"aws_iam_role_policy": {Tok: awsrestok(iamMod, "RolePolicy")},
			"aws_iam_role": {
				Tok: awsrestok(iamMod, "Role"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"name": tfbridge.AutoName("name", 64),
					"role": {Type: awstok(awsMod, "ARN")},
				},
			},
			"aws_iam_saml_provider":      {Tok: awsrestok(iamMod, "SamlProvider")},
			"aws_iam_server_certificate": {Tok: awsrestok(iamMod, "ServerCertificate")},
			"aws_iam_user_policy_attachment": {
				Tok: awsrestok(iamMod, "UserPolicyAttachment"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"user": {Type: awstok(iamMod+"/user", "User")},
					"policy_arn": {
						Name: "policyArn",
						Type: awstok(awsMod, "ARN"),
					},
				},
			},
			"aws_iam_user_policy":        {Tok: awsrestok(iamMod, "UserPolicy")},
			"aws_iam_user_ssh_key":       {Tok: awsrestok(iamMod, "SshKey")},
			"aws_iam_user":               {Tok: awsrestok(iamMod, "User")},
			"aws_iam_user_login_profile": {Tok: awsrestok(iamMod, "UserLoginProfile")},
			// Inspector
			"aws_inspector_assessment_target":   {Tok: awsrestok(inspectorMod, "AssessmentTarget")},
			"aws_inspector_assessment_template": {Tok: awsrestok(inspectorMod, "AssessmentTemplate")},
			"aws_inspector_resource_group":      {Tok: awsrestok(inspectorMod, "ResourceGroup")},
			// Kinesis
			"aws_kinesis_firehose_delivery_stream": {Tok: awsrestok(kinesisMod, "FirehoseDeliveryStream")},
			"aws_kinesis_stream":                   {Tok: awsrestok(kinesisMod, "Stream")},
			// Key Management Service (KMS)
			"aws_kms_alias": {Tok: awsrestok(kmsMod, "Alias")},
			"aws_kms_key":   {Tok: awsrestok(kmsMod, "Key")},
			// Lambda
			"aws_lambda_function": {
				Tok:      awsrestok(lambdaMod, "Function"),
				IDFields: []string{"function_name"},
				Fields: map[string]*tfbridge.SchemaInfo{
					"function_name": tfbridge.AutoName("name", 64),
					"role":          {Type: awstok(awsMod, "ARN")},
					// Terraform accepts two sources for lambdas: a local filename or a S3 bucket/object.  To bridge
					// with Lumi's asset model, we will hijack the filename property.  A Lumi archive is passed in its
					// stead and we will turn around and emit the archive as a temp file that Terraform can read.  We
					// also automatically populate the asset hash property as this is used in diffs/updates/etc.
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
			"aws_lambda_event_source_mapping": {Tok: awsrestok(lambdaMod, "EventSourceMapping")},
			"aws_lambda_alias":                {Tok: awsrestok(lambdaMod, "Alias")},
			"aws_lambda_permission": {
				Tok:      awsrestok(lambdaMod, "Permission"),
				IDFields: []string{"statement_id"},
				Fields: map[string]*tfbridge.SchemaInfo{
					"function_name": {
						Name: "function",
						Type: awstok(lambdaMod+"/function", "Function"),
					},
					"statement_id": tfbridge.AutoName("statementId", 100),
				},
			},
			// LightSail
			"aws_lightsail_domain":               {Tok: awsrestok(lightsailMod, "Domain")},
			"aws_lightsail_instance":             {Tok: awsrestok(lightsailMod, "Instance")},
			"aws_lightsail_key_pair":             {Tok: awsrestok(lightsailMod, "KeyPair")},
			"aws_lightsail_static_ip":            {Tok: awsrestok(lightsailMod, "StaticIp")},
			"aws_lightsail_static_ip_attachment": {Tok: awsrestok(lightsailMod, "StaticIpAttachment")},
			// OpsWorks
			"aws_opsworks_application": {
				Tok: awsrestok(opsworksMod, "Application"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "applicationId"},
				},
			},
			"aws_opsworks_stack": {
				Tok: awsrestok(opsworksMod, "Stack"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "stackId"},
				},
			},
			"aws_opsworks_java_app_layer": {
				Tok: awsrestok(opsworksMod, "JavaAppLayer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "layerId"},
				},
			},
			"aws_opsworks_haproxy_layer": {
				Tok: awsrestok(opsworksMod, "HaproxyLayer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "layerId"},
				},
			},
			"aws_opsworks_static_web_layer": {
				Tok: awsrestok(opsworksMod, "StaticWebLayer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "layerId"},
				},
			},
			"aws_opsworks_php_app_layer": {
				Tok: awsrestok(opsworksMod, "PhpAppLayer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "layerId"},
				},
			},
			"aws_opsworks_rails_app_layer": {
				Tok: awsrestok(opsworksMod, "RailsAppLayer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "layerId"},
				},
			},
			"aws_opsworks_nodejs_app_layer": {
				Tok: awsrestok(opsworksMod, "NodejsAppLayer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "layerId"},
				},
			},
			"aws_opsworks_memcached_layer": {
				Tok: awsrestok(opsworksMod, "MemcachedLayer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "layerId"},
				},
			},
			"aws_opsworks_mysql_layer": {
				Tok: awsrestok(opsworksMod, "MysqlLayer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "layerId"},
				},
			},
			"aws_opsworks_ganglia_layer": {
				Tok: awsrestok(opsworksMod, "GangliaLayer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "layerId"},
				},
			},
			"aws_opsworks_custom_layer": {
				Tok: awsrestok(opsworksMod, "CustomLayer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "layerId"},
				},
			},
			"aws_opsworks_instance": {
				Tok: awsrestok(opsworksMod, "Instance"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "instanceId"},
				},
			},
			"aws_opsworks_user_profile": {
				Tok: awsrestok(opsworksMod, "UserProfile"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "profileId"},
				},
			},
			"aws_opsworks_permission": {
				Tok: awsrestok(opsworksMod, "Permission"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "permissionId"},
				},
			},
			"aws_opsworks_rds_db_instance": {
				Tok: awsrestok(opsworksMod, "RdsDbInstance"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"id": {Name: "instanceId"},
				},
			},
			// Relational Database Service (RDS)
			"aws_rds_cluster":                 {Tok: awsrestok(rdsMod, "Cluster")},
			"aws_rds_cluster_instance":        {Tok: awsrestok(rdsMod, "ClusterInstance")},
			"aws_rds_cluster_parameter_group": {Tok: awsrestok(rdsMod, "ClusterParameterGroup")},
			"aws_db_event_subscription":       {Tok: awsrestok(rdsMod, "EventSubscription")},
			"aws_db_instance":                 {Tok: awsrestok(rdsMod, "Instance")},
			"aws_db_option_group":             {Tok: awsrestok(rdsMod, "OptionGroup")},
			"aws_db_parameter_group":          {Tok: awsrestok(rdsMod, "ParameterGroup")},
			"aws_db_security_group":           {Tok: awsrestok(rdsMod, "SecurityGroup")},
			"aws_db_snapshot":                 {Tok: awsrestok(rdsMod, "Snapshot")},
			"aws_db_subnet_group":             {Tok: awsrestok(rdsMod, "SubnetGroup")},
			// RedShift
			"aws_redshift_cluster":         {Tok: awsrestok(redshiftMod, "Cluster")},
			"aws_redshift_security_group":  {Tok: awsrestok(redshiftMod, "SecurityGroup")},
			"aws_redshift_parameter_group": {Tok: awsrestok(redshiftMod, "ParameterGroup")},
			"aws_redshift_subnet_group":    {Tok: awsrestok(redshiftMod, "SubnetGroup")},
			// Route53
			"aws_route53_delegation_set":   {Tok: awsrestok(route53Mod, "DelegationSet")},
			"aws_route53_record":           {Tok: awsrestok(route53Mod, "Record")},
			"aws_route53_zone_association": {Tok: awsrestok(route53Mod, "ZoneAssociation")},
			"aws_route53_zone":             {Tok: awsrestok(route53Mod, "Zone")},
			"aws_route53_health_check":     {Tok: awsrestok(route53Mod, "HealthCheck")},
			// Simple Email Service (SES)
			"aws_ses_active_receipt_rule_set": {Tok: awsrestok(sesMod, "ActiveReceiptRuleSet")},
			"aws_ses_domain_identity":         {Tok: awsrestok(sesMod, "DomainIdentity")},
			"aws_ses_receipt_filter":          {Tok: awsrestok(sesMod, "ReceiptFilter")},
			"aws_ses_receipt_rule":            {Tok: awsrestok(sesMod, "ReceiptRule")},
			"aws_ses_receipt_rule_set":        {Tok: awsrestok(sesMod, "ReceiptRuleSet")},
			"aws_ses_configuration_set":       {Tok: awsrestok(sesMod, "ConfgurationSet")},
			"aws_ses_event_destination":       {Tok: awsrestok(sesMod, "EventDestination")},
			// S3
			"aws_s3_bucket": {
				Tok: awsrestok(s3Mod, "Bucket"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"bucket": tfbridge.AutoNameTransform("bucket", 63, func(name string) string {
						return strings.ToLower(name)
					}),
				},
			},
			"aws_s3_bucket_policy": {Tok: awsrestok(s3Mod, "BucketPolicy")},
			"aws_s3_bucket_object": {
				Tok:      awsrestok(s3Mod, "BucketObject"),
				IDFields: []string{"bucket", "key"},
				Fields: map[string]*tfbridge.SchemaInfo{
					"bucket": {Type: awsrestok(s3Mod, "Bucket")},
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
			"aws_s3_bucket_notification": {Tok: awsrestok(s3Mod, "BucketNotification")},
			// Systems Manager (SSM)
			"aws_ssm_activation":                {Tok: awsrestok(ssmMod, "Activation")},
			"aws_ssm_association":               {Tok: awsrestok(ssmMod, "Association")},
			"aws_ssm_document":                  {Tok: awsrestok(ssmMod, "Document")},
			"aws_ssm_maintenance_window":        {Tok: awsrestok(ssmMod, "MaintenanceWindow")},
			"aws_ssm_maintenance_window_target": {Tok: awsrestok(ssmMod, "MaintenanceWindowTarget")},
			"aws_ssm_maintenance_window_task":   {Tok: awsrestok(ssmMod, "MaintenanceWindowTask")},
			"aws_ssm_patch_baseline":            {Tok: awsrestok(ssmMod, "PatchBaseline")},
			"aws_ssm_patch_group":               {Tok: awsrestok(ssmMod, "PatchGroup")},
			"aws_ssm_parameter":                 {Tok: awsrestok(ssmMod, "Parameter")},
			// SimpleDB
			"aws_simpledb_domain": {Tok: awsrestok(simpledbMod, "Domain")},
			// Simple Queuing Service (SQS)
			"aws_sqs_queue":        {Tok: awsrestok(sqsMod, "Queue")},
			"aws_sqs_queue_policy": {Tok: awsrestok(sqsMod, "QueuePolicy")},
			// Simple Notification Service (SNS)
			"aws_sns_topic": {
				Tok: awsrestok(snsMod, "Topic"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"arn": {Type: awstok(awsMod, "ARN")},
				},
			},
			"aws_sns_topic_policy": {Tok: awsrestok(snsMod, "TopicPolicy")},
			"aws_sns_topic_subscription": {
				Tok: awsrestok(snsMod, "TopicSubscription"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"topic_arn": {
						Name: "topic",
						Type: awsrestok(snsMod, "Topic"),
					},
				},
			},
			// Step Functions (SFN)
			"aws_sfn_activity":      {Tok: awsrestok(sfnMod, "Activity")},
			"aws_sfn_state_machine": {Tok: awsrestok(sfnMod, "StateMachine")},
			// Web Application Firewall (WAF)
			"aws_waf_byte_match_set":          {Tok: awsrestok(wafMod, "ByteMatchSet")},
			"aws_waf_ipset":                   {Tok: awsrestok(wafMod, "IpSet")},
			"aws_waf_rule":                    {Tok: awsrestok(wafMod, "Rule")},
			"aws_waf_size_constraint_set":     {Tok: awsrestok(wafMod, "SizeConstraintSet")},
			"aws_waf_web_acl":                 {Tok: awsrestok(wafMod, "WebAcl")},
			"aws_waf_xss_match_set":           {Tok: awsrestok(wafMod, "XssMatchSet")},
			"aws_waf_sql_injection_match_set": {Tok: awsrestok(wafMod, "SqlInjectionMatchSet")},
			// Web Application Firewall (WAF) Regional
			"aws_wafregional_byte_match_set": {Tok: awsrestok(wafregionalMod, "ByteMatchSet")},
			"aws_wafregional_ipset":          {Tok: awsrestok(wafregionalMod, "IpSet")},
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
