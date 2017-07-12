// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package tfbridge

import (
	"unicode"

	"github.com/hashicorp/terraform/helper/schema"
	"github.com/pulumi/lumi/pkg/tokens"

	"github.com/terraform-providers/terraform-provider-aws/aws"
)

// all of the AWS token components used below.
const (
	// packages:
	awsPkg = "tf-aws"
	// modules:
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

// awstok manufactures a standard resource token given a module and resource name.  It automatically uses the AWS
// package and names the file by simply lower casing the resource's first character.
func awstok(mod string, res string) tokens.Type {
	fn := string(unicode.ToLower(rune(res[0]))) + res[1:]
	return tokens.Type(awsPkg + ":" + mod + "/" + fn + ":" + res)
}

func awsProvider() ProviderInfo {
	git, err := getGitInfo("aws")
	if err != nil {
		panic(err)
	}
	return ProviderInfo{
		P:   aws.Provider().(*schema.Provider),
		Git: git,
		Resources: map[string]ResourceInfo{
			// API Gateway
			"aws_api_gateway_account":              {Tok: awstok(apigatewayMod, "Account")},
			"aws_api_gateway_api_key":              {Tok: awstok(apigatewayMod, "ApiKey")},
			"aws_api_gateway_authorizer":           {Tok: awstok(apigatewayMod, "Authorizer")},
			"aws_api_gateway_base_path_mapping":    {Tok: awstok(apigatewayMod, "BasePathMapping")},
			"aws_api_gateway_client_certificate":   {Tok: awstok(apigatewayMod, "ClientCertificate")},
			"aws_api_gateway_deployment":           {Tok: awstok(apigatewayMod, "Deployment")},
			"aws_api_gateway_domain_name":          {Tok: awstok(apigatewayMod, "DomainName")},
			"aws_api_gateway_integration":          {Tok: awstok(apigatewayMod, "Integration")},
			"aws_api_gateway_integration_response": {Tok: awstok(apigatewayMod, "IntegrationResponse")},
			"aws_api_gateway_method":               {Tok: awstok(apigatewayMod, "Method")},
			"aws_api_gateway_method_response":      {Tok: awstok(apigatewayMod, "MethodResponse")},
			"aws_api_gateway_method_settings":      {Tok: awstok(apigatewayMod, "MethodSettings")},
			"aws_api_gateway_model":                {Tok: awstok(apigatewayMod, "Model")},
			"aws_api_gateway_request_validator":    {Tok: awstok(apigatewayMod, "RequestValidator")},
			"aws_api_gateway_resource":             {Tok: awstok(apigatewayMod, "Resource")},
			"aws_api_gateway_rest_api":             {Tok: awstok(apigatewayMod, "RestApi")},
			"aws_api_gateway_stage":                {Tok: awstok(apigatewayMod, "Stage")},
			"aws_api_gateway_usage_plan":           {Tok: awstok(apigatewayMod, "UsagePlan")},
			"aws_api_gateway_usage_plan_key":       {Tok: awstok(apigatewayMod, "UsagePlanKey")},
			// Application Auto Scaling
			"aws_appautoscaling_target": {Tok: awstok(appautoscalingMod, "Target")},
			"aws_appautoscaling_policy": {Tok: awstok(appautoscalingMod, "Policy")},
			// Auto Scaling
			"aws_autoscaling_attachment":     {Tok: awstok(autoscalingMod, "Attachment")},
			"aws_autoscaling_group":          {Tok: awstok(autoscalingMod, "Group")},
			"aws_autoscaling_lifecycle_hook": {Tok: awstok(autoscalingMod, "LifecycleHook")},
			"aws_autoscaling_notification":   {Tok: awstok(autoscalingMod, "Notification")},
			"aws_autoscaling_policy":         {Tok: awstok(autoscalingMod, "Policy")},
			"aws_autoscaling_schedule":       {Tok: awstok(autoscalingMod, "Schedule")},
			// CloudFormation
			"aws_cloudformation_stack": {Tok: awstok(cloudformationMod, "Stack")},
			// CloudFront
			"aws_cloudfront_distribution":           {Tok: awstok(cloudfrontMod, "Distribution")},
			"aws_cloudfront_origin_access_identity": {Tok: awstok(cloudfrontMod, "OriginAccessIdentity")},
			// CloudTrail
			"aws_cloudtrail": {Tok: awstok(cloudtrailMod, "Trail")},
			// CloudWatch
			"aws_cloudwatch_event_rule":              {Tok: awstok(cloudwatchMod, "EventRule")},
			"aws_cloudwatch_event_target":            {Tok: awstok(cloudwatchMod, "EventTarget")},
			"aws_cloudwatch_log_destination":         {Tok: awstok(cloudwatchMod, "LogDestination")},
			"aws_cloudwatch_log_destination_policy":  {Tok: awstok(cloudwatchMod, "LogDestinationPolicy")},
			"aws_cloudwatch_log_group":               {Tok: awstok(cloudwatchMod, "LogGroup")},
			"aws_cloudwatch_log_metric_filter":       {Tok: awstok(cloudwatchMod, "LogMetricFilter")},
			"aws_cloudwatch_log_stream":              {Tok: awstok(cloudwatchMod, "LogStream")},
			"aws_cloudwatch_log_subscription_filter": {Tok: awstok(cloudwatchMod, "LogSubscriptionFilter")},
			"aws_cloudwatch_metric_alarm":            {Tok: awstok(cloudwatchMod, "MetricAlarm")},
			// CodeBuild
			"aws_codebuild_project": {Tok: awstok(codebuildMod, "Project")},
			// CodeDeploy
			"aws_codedeploy_app":               {Tok: awstok(codedeployMod, "Application")},
			"aws_codedeploy_deployment_config": {Tok: awstok(codedeployMod, "DeploymentConfig")},
			"aws_codedeploy_deployment_group":  {Tok: awstok(codedeployMod, "DeploymentGroup")},
			// CodeCommit
			"aws_codecommit_repository": {Tok: awstok(codecommitMod, "Repository")},
			"aws_codecommit_trigger":    {Tok: awstok(codecommitMod, "Trigger")},
			// CodePipeline
			"aws_codepipeline": {Tok: awstok(codepipelineMod, "Pipeline")},
			// Cognito
			"aws_cognito_identity_pool": {Tok: awstok(cognitoMod, "IdentityPool")},
			// Config
			"aws_config_config_rule":                   {Tok: awstok(cfgMod, "Rule")},
			"aws_config_configuration_recorder":        {Tok: awstok(cfgMod, "Recorder")},
			"aws_config_configuration_recorder_status": {Tok: awstok(cfgMod, "RecorderStatus")},
			"aws_config_delivery_channel":              {Tok: awstok(cfgMod, "DeliveryChannel")},
			// Data Migration Service
			"aws_dms_certificate":              {Tok: awstok(dmsMod, "Certificate")},
			"aws_dms_endpoint":                 {Tok: awstok(dmsMod, "Endpoint")},
			"aws_dms_replication_instance":     {Tok: awstok(dmsMod, "ReplicationInstance")},
			"aws_dms_replication_subnet_group": {Tok: awstok(dmsMod, "ReplicationSubnetGroup")},
			"aws_dms_replication_task":         {Tok: awstok(dmsMod, "ReplicationTask")},
			// DeviceFarm
			"aws_devicefarm_project": {Tok: awstok(devicefarmMod, "Project")},
			// DirectoryService
			"aws_directory_service_directory": {Tok: awstok(directoryserviceMod, "Directory")},
			// DynamoDB
			"aws_dynamodb_table": {Tok: awstok(dynamodbMod, "Table")},
			// Elastic Beanstalk
			"aws_elastic_beanstalk_application":            {Tok: awstok(elasticbeanstalkMod, "Application")},
			"aws_elastic_beanstalk_application_version":    {Tok: awstok(elasticbeanstalkMod, "ApplicationVersion")},
			"aws_elastic_beanstalk_configuration_template": {Tok: awstok(elasticbeanstalkMod, "ConfigurationTemplate")},
			"aws_elastic_beanstalk_environment":            {Tok: awstok(elasticbeanstalkMod, "Environment")},
			// Elastic Block Store
			"aws_ebs_snapshot": {Tok: awstok(ebsMod, "Snapshot")},
			"aws_ebs_volume":   {Tok: awstok(ebsMod, "Volume")},
			// ElastiCache
			"aws_elasticache_cluster":           {Tok: awstok(elasticacheMod, "Cluster")},
			"aws_elasticache_parameter_group":   {Tok: awstok(elasticacheMod, "ParameterGroup")},
			"aws_elasticache_replication_group": {Tok: awstok(elasticacheMod, "ReplicationGroup")},
			"aws_elasticache_security_group":    {Tok: awstok(elasticacheMod, "SecurityGroup")},
			"aws_elasticache_subnet_group":      {Tok: awstok(elasticacheMod, "SubnetGroup")},
			// Elastic Compute (EC2)
			"aws_ami":                                  {Tok: awstok(ec2Mod, "Ami")},
			"aws_ami_copy":                             {Tok: awstok(ec2Mod, "AmiCopy")},
			"aws_ami_from_instance":                    {Tok: awstok(ec2Mod, "AmiFromInstance")},
			"aws_ami_launch_permission":                {Tok: awstok(ec2Mod, "AmiLaunchPermission")},
			"aws_customer_gateway":                     {Tok: awstok(ec2Mod, "CustomerGateway")},
			"aws_egress_only_internet_gateway":         {Tok: awstok(ec2Mod, "EgressOnlyInternetGateway")},
			"aws_eip":                                  {Tok: awstok(ec2Mod, "Eip")},
			"aws_eip_association":                      {Tok: awstok(ec2Mod, "EipAssociation")},
			"aws_flow_log":                             {Tok: awstok(ec2Mod, "FlowLog")},
			"aws_instance":                             {Tok: awstok(ec2Mod, "Instance")},
			"aws_internet_gateway":                     {Tok: awstok(ec2Mod, "InternetGateway")},
			"aws_key_pair":                             {Tok: awstok(ec2Mod, "KeyPair")},
			"aws_launch_configuration":                 {Tok: awstok(ec2Mod, "LaunchConfiguration")},
			"aws_main_route_table_association":         {Tok: awstok(ec2Mod, "MainRouteTableAssociation")},
			"aws_nat_gateway":                          {Tok: awstok(ec2Mod, "NatGateway")},
			"aws_network_acl":                          {Tok: awstok(ec2Mod, "NetworkAcl")},
			"aws_default_network_acl":                  {Tok: awstok(ec2Mod, "DefaultNetworkAcl")},
			"aws_network_acl_rule":                     {Tok: awstok(ec2Mod, "NetworkAclRule")},
			"aws_network_interface":                    {Tok: awstok(ec2Mod, "NetworkInterface")},
			"aws_network_interface_attachment":         {Tok: awstok(ec2Mod, "NetworkInterfaceAttachment")},
			"aws_placement_group":                      {Tok: awstok(ec2Mod, "PlacementGroup")},
			"aws_proxy_protocol_policy":                {Tok: awstok(ec2Mod, "ProxyProtocolPolicy")},
			"aws_route":                                {Tok: awstok(ec2Mod, "Route")},
			"aws_route_table":                          {Tok: awstok(ec2Mod, "RouteTable")},
			"aws_default_route_table":                  {Tok: awstok(ec2Mod, "DefaultRouteTable")},
			"aws_route_table_association":              {Tok: awstok(ec2Mod, "RouteTableAssociation")},
			"aws_security_group":                       {Tok: awstok(ec2Mod, "SecurityGroup")},
			"aws_network_interface_sg_attachment":      {Tok: awstok(ec2Mod, "NetworkInterfaceSecurityGroupAttachment")},
			"aws_default_security_group":               {Tok: awstok(ec2Mod, "DefaultSecurityGroup")},
			"aws_security_group_rule":                  {Tok: awstok(ec2Mod, "SecurityGroupRule")},
			"aws_snapshot_create_volume_permission":    {Tok: awstok(ec2Mod, "SnapshotCreateVolumePermission")},
			"aws_spot_datafeed_subscription":           {Tok: awstok(ec2Mod, "SpotDatafeedSubscription")},
			"aws_spot_instance_request":                {Tok: awstok(ec2Mod, "SpotInstanceRequest")},
			"aws_spot_fleet_request":                   {Tok: awstok(ec2Mod, "SpotFleetRequest")},
			"aws_default_subnet":                       {Tok: awstok(ec2Mod, "DefaultSubnet")},
			"aws_subnet":                               {Tok: awstok(ec2Mod, "Subnet")},
			"aws_volume_attachment":                    {Tok: awstok(ec2Mod, "VolumeAttachment")},
			"aws_vpc_dhcp_options_association":         {Tok: awstok(ec2Mod, "VpcDhcpOptionsAssociation")},
			"aws_default_vpc_dhcp_options":             {Tok: awstok(ec2Mod, "DefaultVpcDhcpOptions")},
			"aws_vpc_dhcp_options":                     {Tok: awstok(ec2Mod, "VpcDhcpOptions")},
			"aws_vpc_peering_connection":               {Tok: awstok(ec2Mod, "VpcPeeringConnection")},
			"aws_vpc_peering_connection_accepter":      {Tok: awstok(ec2Mod, "VpcPeeringConnectionAccepter")},
			"aws_default_vpc":                          {Tok: awstok(ec2Mod, "DefaultVpc")},
			"aws_vpc":                                  {Tok: awstok(ec2Mod, "Vpc")},
			"aws_vpc_endpoint":                         {Tok: awstok(ec2Mod, "VpcEndpoint")},
			"aws_vpc_endpoint_route_table_association": {Tok: awstok(ec2Mod, "VpcEndpointRouteTableAssociation")},
			"aws_vpn_connection":                       {Tok: awstok(ec2Mod, "VpnConnection")},
			"aws_vpn_connection_route":                 {Tok: awstok(ec2Mod, "VpnConnectionRoute")},
			"aws_vpn_gateway":                          {Tok: awstok(ec2Mod, "VpnGateway")},
			"aws_vpn_gateway_attachment":               {Tok: awstok(ec2Mod, "VpnGatewayAttachment")},
			"aws_vpn_gateway_route_propagation":        {Tok: awstok(ec2Mod, "VpnGatewayRoutePropagation")},
			// Elastic Container Registry
			"aws_ecr_repository":        {Tok: awstok(ecrMod, "Repository")},
			"aws_ecr_repository_policy": {Tok: awstok(ecrMod, "RepositoryPolicy")},
			// Elastic Container Service
			"aws_ecs_cluster":         {Tok: awstok(ecsMod, "Cluster")},
			"aws_ecs_service":         {Tok: awstok(ecsMod, "Service")},
			"aws_ecs_task_definition": {Tok: awstok(ecsMod, "TaskDefinition")},
			// Elastic File System
			"aws_efs_file_system":  {Tok: awstok(efsMod, "FileSystem")},
			"aws_efs_mount_target": {Tok: awstok(efsMod, "MountTarget")},
			// Elastic Load Balancing
			"aws_elb":                                 {Tok: awstok(elbMod, "LoadBalancer")},
			"aws_elb_attachment":                      {Tok: awstok(elbMod, "Attachment")},
			"aws_lb_cookie_stickiness_policy":         {Tok: awstok(elbMod, "CookieStickinessPolicy")},
			"aws_load_balancer_policy":                {Tok: awstok(elbMod, "LoadBalancerPolicy")},
			"aws_load_balancer_backend_server_policy": {Tok: awstok(elbMod, "LoadBalancerBackendServerPolicy")},
			"aws_load_balancer_listener_policy":       {Tok: awstok(elbMod, "ListenerPolicy")},
			"aws_lb_ssl_negotiation_policy":           {Tok: awstok(elbMod, "SslNegotiationPolicy")},
			// Elastic Load Balancing (V2: Application)
			"aws_app_cookie_stickiness_policy": {Tok: awstok(elbMod, "CookieStickinessPolicy")},
			"aws_alb":                          {Tok: awstok(elbv2Mod, "LoadBalancer")},
			"aws_alb_listener":                 {Tok: awstok(elbv2Mod, "Listener")},
			"aws_alb_listener_rule":            {Tok: awstok(elbv2Mod, "ListenerRule")},
			"aws_alb_target_group":             {Tok: awstok(elbv2Mod, "TargetGroup")},
			"aws_alb_target_group_attachment":  {Tok: awstok(elbv2Mod, "TargetGroupAttachment")},
			// Elastic Search
			"aws_elasticsearch_domain":        {Tok: awstok(elasticsearchMod, "Domain")},
			"aws_elasticsearch_domain_policy": {Tok: awstok(elasticsearchMod, "DomainPolicy")},
			// Elastic Transcoder
			"aws_elastictranscoder_pipeline": {Tok: awstok(elastictranscoderMod, "Pipeline")},
			"aws_elastictranscoder_preset":   {Tok: awstok(elastictranscoderMod, "Preset")},
			// Elastic MapReduce
			"aws_emr_cluster":                {Tok: awstok(emrMod, "Cluster")},
			"aws_emr_instance_group":         {Tok: awstok(emrMod, "InstanceGroup")},
			"aws_emr_security_configuration": {Tok: awstok(emrMod, "SecurityConfiguration")},
			// Glacier
			"aws_glacier_vault": {Tok: awstok(glacierMod, "Vault")},
			// Identity and Access Management (IAM)
			"aws_iam_access_key":              {Tok: awstok(iamMod, "AccessKey")},
			"aws_iam_account_alias":           {Tok: awstok(iamMod, "AccountAlias")},
			"aws_iam_account_password_policy": {Tok: awstok(iamMod, "AccountPasswordPolicy")},
			"aws_iam_group_policy":            {Tok: awstok(iamMod, "GroupPolicy")},
			"aws_iam_group":                   {Tok: awstok(iamMod, "Group")},
			"aws_iam_group_membership":        {Tok: awstok(iamMod, "GroupMembership")},
			"aws_iam_group_policy_attachment": {Tok: awstok(iamMod, "GroupPolicyAttachment")},
			"aws_iam_instance_profile":        {Tok: awstok(iamMod, "InstanceProfile")},
			"aws_iam_openid_connect_provider": {Tok: awstok(iamMod, "OpenIdConnectProvider")},
			"aws_iam_policy":                  {Tok: awstok(iamMod, "Policy")},
			"aws_iam_policy_attachment":       {Tok: awstok(iamMod, "PolicyAttachment")},
			"aws_iam_role_policy_attachment":  {Tok: awstok(iamMod, "RolePolicyAttachment")},
			"aws_iam_role_policy":             {Tok: awstok(iamMod, "RolePolicy")},
			"aws_iam_role":                    {Tok: awstok(iamMod, "Role")},
			"aws_iam_saml_provider":           {Tok: awstok(iamMod, "SamlProvider")},
			"aws_iam_server_certificate":      {Tok: awstok(iamMod, "ServerCertificate")},
			"aws_iam_user_policy_attachment":  {Tok: awstok(iamMod, "UserPolicyAttachment")},
			"aws_iam_user_policy":             {Tok: awstok(iamMod, "UserPolicy")},
			"aws_iam_user_ssh_key":            {Tok: awstok(iamMod, "SshKey")},
			"aws_iam_user":                    {Tok: awstok(iamMod, "User")},
			"aws_iam_user_login_profile":      {Tok: awstok(iamMod, "UserLoginProfile")},
			// Inspector
			"aws_inspector_assessment_target":   {Tok: awstok(inspectorMod, "AssessmentTarget")},
			"aws_inspector_assessment_template": {Tok: awstok(inspectorMod, "AssessmentTemplate")},
			"aws_inspector_resource_group":      {Tok: awstok(inspectorMod, "ResourceGroup")},
			// Kinesis
			"aws_kinesis_firehose_delivery_stream": {Tok: awstok(kinesisMod, "FirehoseDeliveryStream")},
			"aws_kinesis_stream":                   {Tok: awstok(kinesisMod, "Stream")},
			// Key Management Service (KMS)
			"aws_kms_alias": {Tok: awstok(kmsMod, "Alias")},
			"aws_kms_key":   {Tok: awstok(kmsMod, "Key")},
			// Lambda
			"aws_lambda_function":             {Tok: awstok(lambdaMod, "Function")},
			"aws_lambda_event_source_mapping": {Tok: awstok(lambdaMod, "EventSourceMapping")},
			"aws_lambda_alias":                {Tok: awstok(lambdaMod, "Alias")},
			"aws_lambda_permission":           {Tok: awstok(lambdaMod, "Permission")},
			// LightSail
			"aws_lightsail_domain":               {Tok: awstok(lightsailMod, "Domain")},
			"aws_lightsail_instance":             {Tok: awstok(lightsailMod, "Instance")},
			"aws_lightsail_key_pair":             {Tok: awstok(lightsailMod, "KeyPair")},
			"aws_lightsail_static_ip":            {Tok: awstok(lightsailMod, "StaticIp")},
			"aws_lightsail_static_ip_attachment": {Tok: awstok(lightsailMod, "StaticIpAttachment")},
			// OpsWorks
			"aws_opsworks_application":      {Tok: awstok(opsworksMod, "Application")},
			"aws_opsworks_stack":            {Tok: awstok(opsworksMod, "Stack")},
			"aws_opsworks_java_app_layer":   {Tok: awstok(opsworksMod, "JavaAppLayer")},
			"aws_opsworks_haproxy_layer":    {Tok: awstok(opsworksMod, "HaproxyLayer")},
			"aws_opsworks_static_web_layer": {Tok: awstok(opsworksMod, "StaticWebLayer")},
			"aws_opsworks_php_app_layer":    {Tok: awstok(opsworksMod, "PhpAppLayer")},
			"aws_opsworks_rails_app_layer":  {Tok: awstok(opsworksMod, "RailsAppLayer")},
			"aws_opsworks_nodejs_app_layer": {Tok: awstok(opsworksMod, "NodejsAppLayer")},
			"aws_opsworks_memcached_layer":  {Tok: awstok(opsworksMod, "MemcachedLayer")},
			"aws_opsworks_mysql_layer":      {Tok: awstok(opsworksMod, "MysqlLayer")},
			"aws_opsworks_ganglia_layer":    {Tok: awstok(opsworksMod, "GangliaLayer")},
			"aws_opsworks_custom_layer":     {Tok: awstok(opsworksMod, "CustomLayer")},
			"aws_opsworks_instance":         {Tok: awstok(opsworksMod, "Instance")},
			"aws_opsworks_user_profile":     {Tok: awstok(opsworksMod, "UserProfile")},
			"aws_opsworks_permission":       {Tok: awstok(opsworksMod, "Permission")},
			"aws_opsworks_rds_db_instance":  {Tok: awstok(opsworksMod, "RdsDbInstance")},
			// Relational Database Service (RDS)
			"aws_rds_cluster":                 {Tok: awstok(rdsMod, "Cluster")},
			"aws_rds_cluster_instance":        {Tok: awstok(rdsMod, "ClusterInstance")},
			"aws_rds_cluster_parameter_group": {Tok: awstok(rdsMod, "ClusterParameterGroup")},
			"aws_db_event_subscription":       {Tok: awstok(rdsMod, "EventSubscription")},
			"aws_db_instance":                 {Tok: awstok(rdsMod, "Instance")},
			"aws_db_option_group":             {Tok: awstok(rdsMod, "OptionGroup")},
			"aws_db_parameter_group":          {Tok: awstok(rdsMod, "ParameterGroup")},
			"aws_db_security_group":           {Tok: awstok(rdsMod, "SecurityGroup")},
			"aws_db_snapshot":                 {Tok: awstok(rdsMod, "Snapshot")},
			"aws_db_subnet_group":             {Tok: awstok(rdsMod, "SubnetGroup")},
			// RedShift
			"aws_redshift_cluster":         {Tok: awstok(redshiftMod, "Cluster")},
			"aws_redshift_security_group":  {Tok: awstok(redshiftMod, "SecurityGroup")},
			"aws_redshift_parameter_group": {Tok: awstok(redshiftMod, "ParameterGroup")},
			"aws_redshift_subnet_group":    {Tok: awstok(redshiftMod, "SubnetGroup")},
			// Route53
			"aws_route53_delegation_set":   {Tok: awstok(route53Mod, "DelegationSet")},
			"aws_route53_record":           {Tok: awstok(route53Mod, "Record")},
			"aws_route53_zone_association": {Tok: awstok(route53Mod, "ZoneAssociation")},
			"aws_route53_zone":             {Tok: awstok(route53Mod, "Zone")},
			"aws_route53_health_check":     {Tok: awstok(route53Mod, "HealthCheck")},
			// Simple Email Service (SES)
			"aws_ses_active_receipt_rule_set": {Tok: awstok(sesMod, "ActiveReceiptRuleSet")},
			"aws_ses_domain_identity":         {Tok: awstok(sesMod, "DomainIdentity")},
			"aws_ses_receipt_filter":          {Tok: awstok(sesMod, "ReceiptFilter")},
			"aws_ses_receipt_rule":            {Tok: awstok(sesMod, "ReceiptRule")},
			"aws_ses_receipt_rule_set":        {Tok: awstok(sesMod, "ReceiptRuleSet")},
			"aws_ses_configuration_set":       {Tok: awstok(sesMod, "ConfgurationSet")},
			"aws_ses_event_destination":       {Tok: awstok(sesMod, "EventDestination")},
			// S3
			"aws_s3_bucket":              {Tok: awstok(s3Mod, "Bucket")},
			"aws_s3_bucket_policy":       {Tok: awstok(s3Mod, "BucketPolicy")},
			"aws_s3_bucket_object":       {Tok: awstok(s3Mod, "Object")},
			"aws_s3_bucket_notification": {Tok: awstok(s3Mod, "Notification")},
			// Systems Manager (SSM)
			"aws_ssm_activation":                {Tok: awstok(ssmMod, "Activation")},
			"aws_ssm_association":               {Tok: awstok(ssmMod, "Association")},
			"aws_ssm_document":                  {Tok: awstok(ssmMod, "Document")},
			"aws_ssm_maintenance_window":        {Tok: awstok(ssmMod, "MaintenanceWindow")},
			"aws_ssm_maintenance_window_target": {Tok: awstok(ssmMod, "MaintenanceWindowTarget")},
			"aws_ssm_maintenance_window_task":   {Tok: awstok(ssmMod, "MaintenanceWindowTask")},
			"aws_ssm_patch_baseline":            {Tok: awstok(ssmMod, "PatchBaseline")},
			"aws_ssm_patch_group":               {Tok: awstok(ssmMod, "PatchGroup")},
			"aws_ssm_parameter":                 {Tok: awstok(ssmMod, "Parameter")},
			// SimpleDB
			"aws_simpledb_domain": {Tok: awstok(simpledbMod, "Domain")},
			// Simple Queuing Service (SQS)
			"aws_sqs_queue":        {Tok: awstok(sqsMod, "Queue")},
			"aws_sqs_queue_policy": {Tok: awstok(sqsMod, "QueuePolicy")},
			// Simple Notification Service (SNS)
			"aws_sns_topic":              {Tok: awstok(snsMod, "Topic")},
			"aws_sns_topic_policy":       {Tok: awstok(snsMod, "TopicPolicy")},
			"aws_sns_topic_subscription": {Tok: awstok(snsMod, "TopicSubscription")},
			// Step Functions (SFN)
			"aws_sfn_activity":      {Tok: awstok(sfnMod, "Activity")},
			"aws_sfn_state_machine": {Tok: awstok(sfnMod, "StateMachine")},
			// Web Application Firewall (WAF)
			"aws_waf_byte_match_set":          {Tok: awstok(wafMod, "ByteMatchSet")},
			"aws_waf_ipset":                   {Tok: awstok(wafMod, "IpSet")},
			"aws_waf_rule":                    {Tok: awstok(wafMod, "Rule")},
			"aws_waf_size_constraint_set":     {Tok: awstok(wafMod, "SizeConstraintSet")},
			"aws_waf_web_acl":                 {Tok: awstok(wafMod, "WebAcl")},
			"aws_waf_xss_match_set":           {Tok: awstok(wafMod, "XssMatchSet")},
			"aws_waf_sql_injection_match_set": {Tok: awstok(wafMod, "SqlInjectionMatchSet")},
			// Web Application Firewall (WAF) Regional
			"aws_wafregional_byte_match_set": {Tok: awstok(wafregionalMod, "ByteMatchSet")},
			"aws_wafregional_ipset":          {Tok: awstok(wafregionalMod, "IpSet")},
		},
	}
}
