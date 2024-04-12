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

package provider

import (
	"context"
	_ "embed"
	"fmt"
	"log"
	"os"
	"path/filepath"
	"strconv"
	"strings"
	"sync/atomic"
	"time"
	"unicode"

	"github.com/aws/aws-sdk-go-v2/feature/ec2/imds"
	awsbase "github.com/hashicorp/aws-sdk-go-base/v2"
	tfschema "github.com/hashicorp/terraform-plugin-sdk/v2/helper/schema"
	"github.com/mitchellh/go-homedir"
	"github.com/pulumi/pulumi-aws/provider/v6/pkg/rds"
	"github.com/pulumi/pulumi-aws/provider/v6/pkg/version"

	pftfbridge "github.com/pulumi/pulumi-terraform-bridge/pf/tfbridge"
	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	tks "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge/tokens"
	shim "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfshim"
	shimv2 "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfshim/sdk-v2"
	"github.com/pulumi/pulumi/pkg/v3/codegen/schema"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
	"github.com/pulumi/pulumi/sdk/v3/go/common/tokens"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
)

// all of the AWS token components used below.
const (
	// packages:
	awsPkg = "aws"
	// modules:
	awsMod                      = "index"                    // the root index.
	acmMod                      = "Acm"                      // AWS Certificate Manager
	acmpcaMod                   = "Acmpca"                   // AWS Private Certificate Authority
	accountMod                  = "Account"                  // Account
	accessAnalyzerMod           = "AccessAnalyzer"           // Access Analyzer
	ampMod                      = "Amp"                      // Amp
	amplifyMod                  = "Amplify"                  // Amplify
	appFlowMod                  = "AppFlow"                  // AppFlow
	appConfigMod                = "AppConfig"                // AppConfig
	appIntegrationsMod          = "AppIntegrations"          // AppIntegrations
	applicationInsightsMod      = "ApplicationInsights"      // Cloudwatch Application Insights
	appStreamMod                = "AppStream"                // AppStream
	appsyncMod                  = "AppSync"                  // AppSync
	appmeshMod                  = "AppMesh"                  // AppMesh
	apigatewayMod               = "ApiGateway"               // API Gateway
	apigatewayv2Mod             = "ApiGatewayV2"             // API Gateway V2
	appautoscalingMod           = "AppAutoScaling"           // Application Auto Scaling
	appRunnerMod                = "AppRunner"                // AppRunner
	athenaMod                   = "Athena"                   // Athena
	auditmanagerMod             = "Auditmanager"             // Audit Manager
	autoscalingMod              = "AutoScaling"              // Auto Scaling
	autoscalingPlansMod         = "AutoScalingPlans"         // Auto Scaling Plans
	backupMod                   = "Backup"                   // Backup
	batchMod                    = "Batch"                    // Batch
	bedrockFoundationMod        = "BedrockFoundation"        // BedrockFoundation
	bedrockModelMod             = "BedrockModel"             // BedrockModel
	bedrockMod                  = "Bedrock"                  // Bedrock
	budgetsMod                  = "Budgets"                  // Budgets
	chimeMod                    = "Chime"                    // Chime
	chimeSDKMediaPipelinesMod   = "ChimeSDKMediaPipelines"   // Chime SDK Media Pipelines
	cloud9Mod                   = "Cloud9"                   // Cloud9
	cloudControlMod             = "CloudControl"             // CloudControl API
	cloudformationMod           = "CloudFormation"           // Cloud Formation
	cloudhsmv2Mod               = "CloudHsmV2"               // Cloud HSM
	cloudfrontMod               = "CloudFront"               // Cloud Front
	cloudsearchMod              = "CloudSearch"              // Cloud Search
	cloudtrailMod               = "CloudTrail"               // Cloud Trail
	cloudwatchMod               = "CloudWatch"               // Cloud Watch
	codeartifactMod             = "CodeArtifact"             // CodeArtifact
	codebuildMod                = "CodeBuild"                // Code Build
	codecatalystMod             = "CodeCatalyst"             // Code Catalyst
	codecommitMod               = "CodeCommit"               // Code Commit
	codedeployMod               = "CodeDeploy"               // Code Deploy
	codeguruReviewerMod         = "CodeGuruReviewer"         // CodeGuru Reviewer
	codepipelineMod             = "CodePipeline"             // Code Pipeline
	codestarConnectionsMod      = "CodeStarConnections"      // CodeStar Connections
	codestarNotificationsMod    = "CodeStarNotifications"    // CodeStar Notifications
	cognitoMod                  = "Cognito"                  // Cognito
	comprehendMod               = "Comprehend"               // Comprehend
	connectMod                  = "Connect"                  // Connect
	controlTowerMod             = "ControlTower"             // Control Tower
	costExplorerMod             = "CostExplorer"             // CostExplorer
	curMod                      = "Cur"                      // Cost and Usage Report
	cfgMod                      = "Cfg"                      // Resource Config
	dataexchangeMod             = "DataExchange"             // Data exchange
	datapipelineMod             = "DataPipeline"             // Data Pipeline
	datasyncMod                 = "DataSync"                 // DataSync
	daxMod                      = "Dax"                      // DynamoDB Accelerator
	devopsGuruMod               = "DevOpsGuru"               // DevOps Guru
	dlmMod                      = "Dlm"                      // Data Lifecycle Manager
	detectiveMod                = "Detective"                // Detective
	devicefarmMod               = "DeviceFarm"               // Device Farm
	directoryserviceMod         = "DirectoryService"         // Directory Services
	docdbMod                    = "DocDB"                    // Document DB
	dynamodbMod                 = "DynamoDB"                 // DynamoDB
	dxMod                       = "DirectConnect"            // Direct Connect
	dmsMod                      = "Dms"                      // Data Migraiton Services
	ebsMod                      = "Ebs"                      // Elastic Block Store
	ec2Mod                      = "Ec2"                      // EC2
	ec2ClientVpnMod             = "Ec2ClientVpn"             // EC2 Client VPN
	ec2TransitGatewayMod        = "Ec2TransitGateway"        // EC2 Transit Gateway
	ecrMod                      = "Ecr"                      // Elastic Container Registry
	ecrPublicMod                = "EcrPublic"                // ECR Public
	ecsMod                      = "Ecs"                      // Elastic Container Service
	efsMod                      = "Efs"                      // Elastic Filesystem
	eksMod                      = "Eks"                      // ECS for Kubernetes
	elasticacheMod              = "ElastiCache"              // ElastiCache
	elasticbeanstalkMod         = "ElasticBeanstalk"         // Elastic Beanstalk
	elasticsearchMod            = "ElasticSearch"            // ElasticSearch
	elastictranscoderMod        = "ElasticTranscoder"        // Elastic Transcoder
	elbMod                      = "Elb"                      // Elastic Load Balancing
	evidentlyMod                = "Evidently"                // Cloud Watch Evidently
	albMod                      = "Alb"                      // Elastic Load Balancing (V2: Application)
	lbMod                       = "LB"                       // Elastic Load Balancing (V2: Application and Network)
	emrMod                      = "Emr"                      // Elastic MapReduce
	emrContainersMod            = "EmrContainers"            // Elastic MapReduce Containers
	emrServerlessMod            = "EmrServerless"            // Elastic MapReduce Serverless
	fisMod                      = "Fis"                      // Fault Injection System
	fmsMod                      = "Fms"                      // FMS
	fsxMod                      = "Fsx"                      // FSX
	gameliftMod                 = "GameLift"                 // Gamelift
	glacierMod                  = "Glacier"                  // Glacier
	globalacceleratorMod        = "GlobalAccelerator"        // Global Accelerator
	glueMod                     = "Glue"                     // Glue
	grafanaMod                  = "Grafana"                  // Grafana
	guarddutyMod                = "GuardDuty"                // Guard Duty
	iamMod                      = "Iam"                      // Identity and Access Management (IAM)
	identityStoreMod            = "IdentityStore"            // Identity Store
	imageBuilderMod             = "ImageBuilder"             // ImageBuilder
	inspectorMod                = "Inspector"                // Inspector
	inspector2Mod               = "Inspector2"               // Inspector V2
	iotMod                      = "Iot"                      // Internet of Things (IoT)
	ivsMod                      = "Ivs"                      // Interactive Video Service
	ivsChatMod                  = "IvsChat"                  // Interactive Video Service Chat
	kendraMod                   = "Kendra"                   // Kendra
	keyspacesMod                = "Keyspaces"                // Keyspaces
	kinesisMod                  = "Kinesis"                  // Kinesis
	kinesisAnalyticsMod         = "KinesisAnalyticsV2"       // Kinesis Analytics V2
	kmsMod                      = "Kms"                      // Key Management Service (KMS)
	lakeFormationMod            = "LakeFormation"            // LakeFormation
	lambdaMod                   = "Lambda"                   // Lambda
	lexMod                      = "Lex"                      // Lex
	licensemanagerMod           = "LicenseManager"           // License Manager
	lightsailMod                = "LightSail"                // LightSail
	locationMod                 = "Location"                 // Location
	m2Mod                       = "M2"                       // Mainframe Modernisation
	macieMod                    = "Macie"                    // Macie (Classic)
	macie2Mod                   = "Macie2"                   // Macie2
	mediaconvertMod             = "MediaConvert"             // Media Convert
	medialiveMod                = "MediaLive"                // Media Live
	mediapackageMod             = "MediaPackage"             // Elemental MediaPackage
	mediastoreMod               = "MediaStore"               // Elemental MediaStore
	memoryDbMod                 = "MemoryDb"                 // Memory DB
	mqMod                       = "Mq"                       // MQ
	mskMod                      = "Msk"                      // MSK
	mskConnectMod               = "MskConnect"               // MSK Connect
	mwaaMod                     = "Mwaa"                     // Managed Workflows for Apache Airflow
	neptuneMod                  = "Neptune"                  // Neptune
	networkFirewallMod          = "NetworkFirewall"          // Network Firewall
	networkManagerMod           = "NetworkManager"           // Network Manager
	oamMod                      = "Oam"                      // Observability Access Manager
	opensearchMod               = "OpenSearch"               // OpenSearch
	opsworksMod                 = "OpsWorks"                 // OpsWorks
	organizationsMod            = "Organizations"            // Organizations
	osisMod                     = "OpenSearchIngest"         // Open Search Ingestion Service
	outpostsMod                 = "Outposts"                 // Outposts
	pinpointMod                 = "Pinpoint"                 // Pinpoint
	pipesMod                    = "Pipes"                    // Pipes
	pricingMod                  = "Pricing"                  // Pricing
	qldbMod                     = "Qldb"                     // QLDB
	quicksightMod               = "Quicksight"               // Quicksight
	ramMod                      = "Ram"                      // Resource Access Manager
	rbinMod                     = "Rbin"                     // Recycle Bin
	rdsMod                      = "Rds"                      // Relational Database Service (RDS)
	rekognitionMod              = "Rekognition"              //Amazon Rekognition"
	redshiftMod                 = "RedShift"                 // RedShift
	redshiftDataMod             = "RedshiftData"             // RedshiftData
	redshiftServerlessMod       = "RedshiftServerless"       // Redshift Serverless
	resourcegroupsMod           = "ResourceGroups"           // Resource Groups
	resourcegroupsTaggingApiMod = "ResourceGroupsTaggingApi" // Resource Groups Tagging Api
	rolesAnywhereMod            = "RolesAnywhere"            // Roles Anywhere
	route53Mod                  = "Route53"                  // Route 53 (DNS)
	route53RecoveryControlMod   = "Route53RecoveryControl"   // Route 53 Recovery Control
	route53RecoveryReadinessMod = "Route53RecoveryReadiness" // Route 53 Recovery Readiness
	route53DomainsMod           = "Route53Domains"           // Route 53 Domains
	rumMod                      = "Rum"                      // RUM
	sagemakerMod                = "Sagemaker"                // Sagemaker
	schedulerMod                = "Scheduler"                // EventBridge Scheduler
	schemasMod                  = "Schemas"                  // Schemas
	securityhubMod              = "SecurityHub"              // SecurityHub
	serverlessRepositoryMod     = "ServerlessRepository"     // ServerlessRepository
	sesMod                      = "Ses"                      // Simple Email Service (SES)
	sesV2Mod                    = "SesV2"                    // Simple Email Service V2 (SES)
	signerMod                   = "Signer"                   // Signer
	s3Mod                       = "S3"                       // Simple Storage (S3)
	s3ControlMod                = "S3Control"                // S3 Control
	s3OutpostsMod               = "S3Outposts"               // S3 Outposts
	ssmMod                      = "Ssm"                      // System Manager
	ssmContactsMod              = "SsmContacts"              // Systems Manager Incident Manager Contacts
	ssmIncidentsMod             = "SsmIncidents"             // Systems Manager Incident Manager
	secretsmanagerMod           = "SecretsManager"           // Secrets Manager
	servicecatalogMod           = "ServiceCatalog"           // Service Catalog
	servicediscoveryMod         = "ServiceDiscovery"         // Service Discovery
	servicequotasMod            = "ServiceQuotas"            // Service Quotas
	sfnMod                      = "Sfn"                      // Step Functions (SFN)
	shieldMod                   = "Shield"                   // Shield
	simpledbMod                 = "SimpleDB"                 // Simple DB
	snsMod                      = "Sns"                      // Simple Notification Service (SNS)
	sqsMod                      = "Sqs"                      // Simple Queueing Service (SQS)
	ssoAdminMod                 = "SsoAdmin"                 // SSO Admin
	storagegatewayMod           = "StorageGateway"           // Storage Gateway
	swfMod                      = "Swf"                      // Simple Workflow Service (SWF)
	syntheticsMod               = "Synthetics"               // Synthetics
	timestreamWriteMod          = "TimestreamWrite"          // Timestream Write
	transcribeMod               = "Transcribe"               // Transcribe
	transferMod                 = "Transfer"                 // Transfer Service
	verifiedpermissionsMod      = "VerifiedPermissions"      // Verified Permissions
	verifiedaccessMod           = "VerifiedAccess"           // Verified Access
	vpclatticeMod               = "VpcLattice"               // VPC Lattice
	wafMod                      = "Waf"                      // Web Application Firewall (WAF)
	wafV2Mod                    = "WafV2"                    // Web Application Firewall V2 (WAFV2)
	wafregionalMod              = "WafRegional"              // Web Application Firewall (WAF) Regional
	worklinkMod                 = "WorkLink"                 // Worklink
	workspacesMod               = "Workspaces"               // Workspaces
	xrayMod                     = "Xray"                     // X-Ray

	// Legacy Mods
	legacyElbMod   = "ElasticLoadBalancing"
	legacyAlbMod   = "ApplicationLoadBalancing"
	legacyElbv2Mod = "ElasticLoadBalancingV2"
)

var moduleMap = map[string]string{
	// Ignored: ec2Mod. The ec2Mod includes tokens from:
	// - "aws_eip"
	// - "aws_flow_log"
	// - "aws_ami_copy"
	//
	// It's not clear what the auto-token should be.

	// We don't map legacy modules

	"accessanalyzer":                  accessAnalyzerMod,
	"account":                         accountMod,
	"acm":                             acmMod,
	"acmpca":                          acmpcaMod,
	"alb":                             albMod,
	"amplify":                         amplifyMod,
	"api_gateway":                     apigatewayMod,
	"apigatewayv2":                    apigatewayv2Mod,
	"appautoscaling":                  appautoscalingMod,
	"appconfig":                       appConfigMod,
	"appflow":                         appFlowMod,
	"appintegrations":                 appIntegrationsMod,
	"applicationinsights":             applicationInsightsMod,
	"appmesh":                         appmeshMod,
	"apprunner":                       appRunnerMod,
	"appstream":                       appStreamMod,
	"appsync":                         appsyncMod,
	"athena":                          athenaMod,
	"autoscaling":                     autoscalingMod,
	"autoscalingplans":                autoscalingPlansMod,
	"backup":                          backupMod,
	"batch":                           batchMod,
	"bedrock_foundation":              bedrockFoundationMod,
	"bedrock_model":                   bedrockModelMod,
	"bedrock":                         bedrockMod,
	"budgets":                         budgetsMod,
	"ce":                              costExplorerMod,
	"chime":                           chimeMod,
	"chimesdkmediapipelines":          chimeSDKMediaPipelinesMod,
	"cleanrooms":                      "CleanRooms",
	"cloud9":                          cloud9Mod,
	"cloudcontrolapi":                 cloudControlMod,
	"cloudformation":                  cloudformationMod,
	"cloudfront":                      cloudfrontMod,
	"cloudhsm_v2":                     cloudhsmv2Mod,
	"cloudsearch":                     cloudsearchMod,
	"cloudtrail":                      cloudtrailMod,
	"cloudwatch":                      cloudwatchMod,
	"codeartifact":                    codeartifactMod,
	"codebuild":                       codebuildMod,
	"codecatalyst":                    codecatalystMod,
	"codecommit":                      codecommitMod,
	"codedeploy":                      codedeployMod,
	"codeguruprofiler":                "CodeGuruProfiler",
	"codegurureviewer":                codeguruReviewerMod,
	"codepipeline":                    codepipelineMod,
	"codestarconnections":             codestarConnectionsMod,
	"codestarnotifications":           codestarNotificationsMod,
	"cognito":                         cognitoMod,
	"comprehend":                      comprehendMod,
	"config":                          cfgMod,
	"connect":                         connectMod,
	"controltower":                    controlTowerMod,
	"cur":                             curMod,
	"customerprofiles":                "CustomerProfiles",
	"dataexchange":                    dataexchangeMod,
	"datapipeline":                    datapipelineMod,
	"datasync":                        datasyncMod,
	"dax":                             daxMod,
	"devopsguru":                      devopsGuruMod,
	"db":                              rdsMod,
	"detective":                       detectiveMod,
	"devicefarm":                      devicefarmMod,
	"directory_service":               directoryserviceMod,
	"dlm":                             dlmMod,
	"dms":                             dmsMod,
	"docdb":                           docdbMod,
	"dx":                              dxMod,
	"dynamodb":                        dynamodbMod,
	"ebs":                             ebsMod,
	"ec2_client_vpn":                  ec2ClientVpnMod,
	"ec2_transit_gateway":             ec2TransitGatewayMod,
	"ecr":                             ecrMod,
	"ecrpublic":                       ecrPublicMod,
	"ecs":                             ecsMod,
	"efs":                             efsMod,
	"eks":                             eksMod,
	"elastic_beanstalk":               elasticbeanstalkMod,
	"elasticache":                     elasticacheMod,
	"elasticsearch":                   elasticsearchMod,
	"elastictranscoder":               elastictranscoderMod,
	"elb":                             elbMod,
	"emr":                             emrMod,
	"emrcontainers":                   emrContainersMod,
	"emrserverless":                   emrServerlessMod,
	"evidently":                       evidentlyMod,
	"finspace":                        "FinSpace",
	"fis":                             fisMod,
	"fms":                             fmsMod,
	"fsx":                             fsxMod,
	"gamelift":                        gameliftMod,
	"glacier":                         glacierMod,
	"globalaccelerator":               globalacceleratorMod,
	"glue":                            glueMod,
	"grafana":                         grafanaMod,
	"guardduty":                       guarddutyMod,
	"iam":                             iamMod,
	"identitystore":                   identityStoreMod,
	"imagebuilder":                    imageBuilderMod,
	"inspector":                       inspectorMod,
	"inspector2":                      inspector2Mod,
	"iot":                             iotMod,
	"ivs":                             ivsMod,
	"ivschat":                         ivsChatMod,
	"kendra":                          kendraMod,
	"keyspaces":                       keyspacesMod,
	"kinesis":                         kinesisMod,
	"kinesisanalyticsv2":              kinesisAnalyticsMod,
	"kms":                             kmsMod,
	"lakeformation":                   lakeFormationMod,
	"lambda":                          lambdaMod,
	"lb":                              lbMod,
	"lex":                             lexMod,
	"licensemanager":                  licensemanagerMod,
	"lightsail":                       lightsailMod,
	"location":                        locationMod,
	"m2":                              m2Mod,
	"macie":                           macieMod,
	"macie2":                          macie2Mod,
	"media_convert":                   mediaconvertMod,
	"media_package":                   mediapackageMod,
	"media_store":                     mediastoreMod,
	"medialive":                       medialiveMod,
	"memorydb":                        memoryDbMod,
	"mq":                              mqMod,
	"msk":                             mskMod,
	"mskconnect":                      mskConnectMod,
	"mwaa":                            mwaaMod,
	"neptune":                         neptuneMod,
	"networkfirewall":                 networkFirewallMod,
	"networkmanager":                  networkManagerMod,
	"oam":                             oamMod,
	"opensearch":                      opensearchMod,
	"opsworks":                        opsworksMod,
	"organizations":                   organizationsMod,
	"osis":                            osisMod,
	"outposts":                        outpostsMod,
	"pinpoint":                        pinpointMod,
	"pipes":                           pipesMod,
	"polly":                           "Polly",
	"pricing":                         pricingMod,
	"prometheus":                      ampMod,
	"qldb":                            qldbMod,
	"quicksight":                      quicksightMod,
	"ram":                             ramMod,
	"rbin":                            rbinMod,
	"rds":                             rdsMod,
	"redshift":                        redshiftMod,
	"redshiftdata":                    redshiftDataMod,
	"redshiftserverless":              redshiftServerlessMod,
	"rekognition":                     rekognitionMod,
	"resourcegroups":                  resourcegroupsMod,
	"resourcegroupstaggingapi":        resourcegroupsTaggingApiMod,
	"rolesanywhere":                   rolesAnywhereMod,
	"route53":                         route53Mod,
	"route53domains":                  route53DomainsMod,
	"route53recoverycontrolconfig":    route53RecoveryControlMod,
	"route53recoveryreadiness":        route53RecoveryReadinessMod,
	"rum":                             rumMod,
	"s3":                              s3Mod,
	"s3control":                       s3ControlMod,
	"s3outposts":                      s3OutpostsMod,
	"sagemaker":                       sagemakerMod,
	"scheduler":                       schedulerMod,
	"schemas":                         schemasMod,
	"secretsmanager":                  secretsmanagerMod,
	"securityhub":                     securityhubMod,
	"securitylake":                    "SecurityLake",
	"serverlessapplicationrepository": serverlessRepositoryMod,
	"service_discovery":               servicediscoveryMod,
	"servicecatalog":                  servicecatalogMod,
	"servicequotas":                   servicequotasMod,
	"ses":                             sesMod,
	"sesv2":                           sesV2Mod,
	"sfn":                             sfnMod,
	"shield":                          shieldMod,
	"signer":                          signerMod,
	"simpledb":                        simpledbMod,
	"sns":                             snsMod,
	"sqs":                             sqsMod,
	"ssm":                             ssmMod,
	"ssmincidents":                    ssmIncidentsMod,
	"ssoadmin":                        ssoAdminMod,
	"storagegateway":                  storagegatewayMod,
	"swf":                             swfMod,
	"synthetics":                      syntheticsMod,
	"timestreamwrite":                 timestreamWriteMod,
	"transcribe":                      transcribeMod,
	"transfer":                        transferMod,
	"verifiedaccess":                  verifiedaccessMod,
	"verifiedpermissions":             verifiedpermissionsMod,
	"vpclattice":                      vpclatticeMod,
	"waf":                             wafMod,
	"wafregional":                     wafregionalMod,
	"wafv2":                           wafV2Mod,
	"worklink":                        worklinkMod,
	"workspaces":                      workspacesMod,
	"xray":                            xrayMod,
}

var namespaceMap = map[string]string{
	"aws": "Aws",
}

// awsMember manufactures a type token for the AWS package and the given module, file name, and type.
func awsMember(moduleTitle string, fn string, mem string) tokens.ModuleMember {
	moduleName := strings.ToLower(moduleTitle)
	namespaceMap[moduleName] = moduleTitle
	if fn != "" {
		moduleName += "/" + fn
	}
	return tokens.ModuleMember(awsPkg + ":" + moduleName + ":" + mem)
}

// awsType manufactures a type token for the AWS package and the given module, file name, and type.
func awsType(mod string, fn string, typ string) tokens.Type {
	return tokens.Type(awsMember(mod, fn, typ))
}

// awsResource manufactures a standard resource token given a module and resource name.  It automatically uses the AWS
// package and names the file by simply lower casing the type's first character.
func awsTypeDefaultFile(mod string, typ string) tokens.Type {
	fn := string(unicode.ToLower(rune(typ[0]))) + typ[1:]
	return awsType(mod, fn, typ)
}

// awsDataSource manufactures a standard resource token given a module and resource name.  It automatically uses the AWS
// package and names the file by simply lower casing the data source's first character.
func awsDataSource(mod string, res string) tokens.ModuleMember {
	fn := string(unicode.ToLower(rune(res[0]))) + res[1:]
	return awsMember(mod, fn, res)
}

// awsResource manufactures a standard resource token given a module and resource name.
func awsResource(mod string, res string) tokens.Type {
	return awsTypeDefaultFile(mod, res)
}

func ref[T any](value T) *T { return &value }

// stringValue gets a string value from a property map if present, else ""
func stringValue(vars resource.PropertyMap, prop resource.PropertyKey, envs []string) string {
	val, ok := vars[prop]
	if ok && val.IsString() {
		return val.StringValue()
	}
	for _, env := range envs {
		val, ok := os.LookupEnv(env)
		if ok {
			return val
		}
	}
	return ""
}

// boolValue gets a bool value from a property map if present, else false
func boolValue(vars resource.PropertyMap, prop resource.PropertyKey, envs []string) bool {
	val, ok := vars[prop]
	if ok && val.IsBool() {
		return val.BoolValue()
	}
	for _, env := range envs {
		val, ok := os.LookupEnv(env)
		if ok {
			boolValue, err := strconv.ParseBool(val)
			if err != nil {
				return false
			}
			return boolValue
		}
	}
	return false
}

func arrayValue(vars resource.PropertyMap, prop resource.PropertyKey, envs []string) []string {
	val, ok := vars[prop]
	var vals []string
	if ok && val.IsArray() {
		for _, v := range val.ArrayValue() {
			vals = append(vals, v.StringValue())
		}
		return vals
	}

	for _, env := range envs {
		val, ok := os.LookupEnv(env)
		if ok {
			return strings.Split(val, ";")
		}
	}
	return vals
}

// returns a pointer so we can distinguish between a zero value and a missing value
func durationFromConfig(vars resource.PropertyMap, prop resource.PropertyKey) (*time.Duration, error) {
	val, ok := vars[prop]
	if ok && val.IsString() {
		secondsString := val.StringValue()
		if !strings.HasSuffix(secondsString, "s") {
			secondsString += "s"
		}
		dur, err := time.ParseDuration(secondsString)
		if err != nil {
			return nil, err
		}
		return &dur, nil
	}

	return nil, nil
}

//go:embed errors/no_credentials.txt
var noCredentialsError string

//go:embed errors/invalid_credentials.txt
var invalidCredentialsError string

//go:embed errors/no_region.txt
var noRegionError string

//go:embed errors/expired_sso.txt
var expiredSSOError string

func validateCredentials(vars resource.PropertyMap, c shim.ResourceConfig) error {
	config := &awsbase.Config{
		AccessKey: stringValue(vars, "accessKey", []string{"AWS_ACCESS_KEY_ID"}),
		SecretKey: stringValue(vars, "secretKey", []string{"AWS_SECRET_ACCESS_KEY"}),
		Profile:   stringValue(vars, "profile", []string{"AWS_PROFILE"}),
		Token:     stringValue(vars, "token", []string{"AWS_SESSION_TOKEN"}),
		Region:    stringValue(vars, "region", []string{"AWS_REGION", "AWS_DEFAULT_REGION"}),

		CallerName:             "Pulumi AWS Classic",
		CallerDocumentationURL: "https://www.pulumi.com/registry/packages/aws/installation-configuration/",
	}

	if details, ok := vars["assumeRole"]; ok {
		assumeRole := awsbase.AssumeRole{
			RoleARN:           stringValue(details.ObjectValue(), "roleArn", []string{}),
			ExternalID:        stringValue(details.ObjectValue(), "externalId", []string{}),
			Policy:            stringValue(details.ObjectValue(), "policy", []string{}),
			PolicyARNs:        arrayValue(details.ObjectValue(), "policyArns", []string{}),
			SessionName:       stringValue(details.ObjectValue(), "sessionName", []string{}),
			SourceIdentity:    stringValue(details.ObjectValue(), "sourceIdentity", []string{}),
			TransitiveTagKeys: arrayValue(details.ObjectValue(), "transitiveTagKeys", []string{}),
		}
		duration, err := durationFromConfig(details.ObjectValue(), "durationSeconds")
		if err != nil {
			return err
		}
		if duration != nil {
			assumeRole.Duration = *duration
		}

		config.AssumeRole = &assumeRole
	}

	if details, ok := vars["assumeRoleWithWebIdentity"]; ok {
		assumeRole := awsbase.AssumeRoleWithWebIdentity{
			RoleARN:              stringValue(details.ObjectValue(), "roleArn", []string{}),
			Policy:               stringValue(details.ObjectValue(), "policy", []string{}),
			PolicyARNs:           arrayValue(details.ObjectValue(), "policyArns", []string{}),
			SessionName:          stringValue(details.ObjectValue(), "sessionName", []string{}),
			WebIdentityToken:     stringValue(details.ObjectValue(), "webIdentityToken", []string{}),
			WebIdentityTokenFile: stringValue(details.ObjectValue(), "webIdentityTokenFile", []string{}),
		}
		duration, err := durationFromConfig(details.ObjectValue(), "durationSeconds")
		if err != nil {
			return err
		}
		if duration != nil {
			assumeRole.Duration = *duration
		}
		config.AssumeRoleWithWebIdentity = &assumeRole
	}

	// By default `skipMetadataApiCheck` is true for Pulumi to speed operations
	// if we want to authenticate against the AWS API Metadata Service then the user
	// will specify that skipMetadataApiCheck: false
	// therefore, if we have skipMetadataApiCheck false, then we are enabling the imds client
	config.EC2MetadataServiceEnableState = imds.ClientDisabled
	skipMetadataApiCheck := boolValue(vars, "skipMetadataApiCheck",
		[]string{"AWS_SKIP_METADATA_API_CHECK"})
	if !skipMetadataApiCheck {
		config.EC2MetadataServiceEnableState = imds.ClientEnabled
	}

	// lastly let's set the sharedCreds and sharedConfig file. If these are not found then let's default to the
	// locations that AWS cli will store these values.
	var sharedCredentialsFilePaths []string
	sharedCredentialsFile := stringValue(vars, "sharedCredentialsFile", []string{"AWS_SHARED_CREDENTIALS_FILE"})
	if sharedCredentialsFile != "" {
		sharedCredentialsFilePaths = append(sharedCredentialsFilePaths, sharedCredentialsFile)
	}

	sharedCredentialsFiles := arrayValue(vars, "sharedCredentialsFiles",
		[]string{"AWS_SHARED_CREDENTIALS_FILE", "AWS_SHARED_CREDENTIALS_FILES"})
	if len(sharedCredentialsFiles) > 0 {
		sharedCredentialsFilePaths = append(sharedCredentialsFilePaths, sharedCredentialsFiles...)
	}

	if len(sharedCredentialsFilePaths) == 0 {
		sharedCredentialsFile := "~/.aws/credentials"
		credsPath, err := homedir.Expand(sharedCredentialsFile)
		if err != nil {
			return err
		}

		sharedCredentialsFilePaths = append(sharedCredentialsFilePaths, credsPath)
	}
	config.SharedCredentialsFiles = sharedCredentialsFilePaths

	sharedConfigFile := stringValue(vars, "sharedConfigFile", []string{"AWS_CONFIG_FILE"})
	if sharedConfigFile == "" {
		sharedConfigFile = "~/.aws/config"
	}
	configPath, err := homedir.Expand(sharedConfigFile)
	if err != nil {
		return err
	}

	config.SharedConfigFiles = []string{configPath}

	if _, _, diag := awsbase.GetAwsConfig(context.Background(), config); diag != nil && diag.HasError() {
		formattedDiag := formatDiags(diag)
		// Normally it'd query sts.REGION.amazonaws.com
		// but if we query sts..amazonaws.com, then we don't have a region.
		if strings.Contains(formattedDiag, "endpoint rule error, Invalid Configuration: Missing Region") {
			return tfbridge.CheckFailureError{
				Failures: []tfbridge.CheckFailureErrorElement{
					{
						Reason:   noRegionError,
						Property: "",
					},
				},
			}
		}
		if strings.Contains(formattedDiag, "no EC2 IMDS role found") {
			return tfbridge.CheckFailureError{
				Failures: []tfbridge.CheckFailureErrorElement{
					{
						Reason:   noCredentialsError,
						Property: "",
					},
				},
			}
		}
		if strings.Contains(formattedDiag, "The security token included in the request is invalid") {
			return tfbridge.CheckFailureError{
				Failures: []tfbridge.CheckFailureErrorElement{
					{
						Reason:   invalidCredentialsError,
						Property: "",
					},
				},
			}
		}
		if strings.Contains(formattedDiag, "failed to refresh cached credentials") {
			return tfbridge.CheckFailureError{
				Failures: []tfbridge.CheckFailureErrorElement{
					{
						Reason:   expiredSSOError,
						Property: "",
					},
				},
			}
		}

		return tfbridge.CheckFailureError{
			Failures: []tfbridge.CheckFailureErrorElement{
				{
					Reason:   fmt.Sprintf("unable to validate AWS credentials.\nDetails: %s\n", formattedDiag),
					Property: "",
				},
			},
		}
	}

	return nil
}

// preConfigureCallback validates that AWS credentials can be successfully discovered. This emulates the credentials
// configuration subset of `github.com/terraform-providers/terraform-provider-aws/aws.providerConfigure`.  We do this
// before passing control to the TF provider to ensure we can report actionable errors.
func preConfigureCallback(alreadyRun *atomic.Bool) func(vars resource.PropertyMap, c shim.ResourceConfig) error {
	return func(vars resource.PropertyMap, c shim.ResourceConfig) error {
		skipCredentialsValidation := boolValue(vars, "skipCredentialsValidation",
			[]string{"AWS_SKIP_CREDENTIALS_VALIDATION"})

		// if we skipCredentialsValidation then we don't need to do anything in
		// preConfigureCallback as this is an explicit operation
		if skipCredentialsValidation {
			log.Printf("[INFO] pulumi-aws: skip credentials validation")
			return nil
		}

		var err error
		if alreadyRun.CompareAndSwap(false, true) {
			log.Printf("[INFO] pulumi-aws: starting to validate credentials. " +
				"Disable this by AWS_SKIP_CREDENTIALS_VALIDATION or " +
				"skipCredentialsValidation option")
			err = validateCredentials(vars, c)
			if err == nil {
				log.Printf("[INFO] pulumi-aws: credentials are valid")
			} else {
				log.Printf("[INFO] pulumi-aws: error validating credentials: %v", err)
			}
		}
		return err
	}
}

// managedByPulumi is a default used for some managed resources, in the absence of something more meaningful.
var managedByPulumi = &tfbridge.DefaultInfo{Value: "Managed by Pulumi"}

//go:embed cmd/pulumi-resource-aws/runtime-bridge-metadata.json
var runtimeMetadata []byte

// Provider returns additional overlaid schema and metadata associated with the aws package.
func Provider() *tfbridge.ProviderInfo {
	return ProviderFromMeta(tfbridge.NewProviderMetadata(runtimeMetadata))
}

func deprecateRuntime(value, name string) schema.EnumValueSpec {
	s := schema.EnumValueSpec{Value: value, Name: name}
	s.DeprecationMessage = "This runtime is now deprecated"
	return s
}

// Provider returns additional overlaid schema and metadata associated with the aws package.
func ProviderFromMeta(metaInfo *tfbridge.MetadataInfo) *tfbridge.ProviderInfo {
	ctx := context.Background()
	upstreamProvider := newUpstreamProvider(ctx)

	v2p := shimv2.NewProvider(upstreamProvider.SDKV2Provider,
		shimv2.WithDiffStrategy(shimv2.PlanState),
		shimv2.WithPlanResourceChange(func(s string) bool {
			switch s {
			case "aws_ssm_document",
				"aws_wafv2_web_acl",
				"aws_launch_template":
				return true
			default:
				return false
			}
		}))

	p := pftfbridge.MuxShimWithDisjointgPF(ctx, v2p, upstreamProvider.PluginFrameworkProvider)

	// We should only run the validation once to avoid duplicating the reported errors.
	var credentialsValidationRun atomic.Bool

	prov := tfbridge.ProviderInfo{
		P:                p,
		Name:             "aws",
		Description:      "A Pulumi package for creating and managing Amazon Web Services (AWS) cloud resources.",
		Keywords:         []string{"pulumi", "aws"},
		License:          "Apache-2.0",
		Homepage:         "https://pulumi.io",
		Repository:       "https://github.com/pulumi/pulumi-aws",
		Version:          version.Version,
		GitHubOrg:        "hashicorp",
		UpstreamRepoPath: "./upstream",
		DocRules:         &tfbridge.DocRuleInfo{EditRules: editRules},

		// See pulumi/pulumi-aws#2880
		SkipValidateProviderConfigForPluginFramework: true,

		// Generate a trimmed down runtime-only metadata
		GenerateRuntimeMetadata: true,

		MetadataInfo: metaInfo,

		Config: map[string]*tfbridge.SchemaInfo{
			"region": {
				Type: awsTypeDefaultFile(awsMod, "Region"),
				Default: &tfbridge.DefaultInfo{
					EnvVars: []string{"AWS_REGION", "AWS_DEFAULT_REGION"},
				},
			},
			"skip_region_validation": {
				Default: &tfbridge.DefaultInfo{
					Value: true,
				},
			},
			"skip_credentials_validation": {
				Default: &tfbridge.DefaultInfo{
					// This is required to now be false! When this is true, we defer
					// the AWS credentials validation check to happen at resource
					// creation time. Although it may be a little slower validating
					// this upfront, we genuinely need to do this to ensure a good
					// user experience. If we don't validate upfront, then we can
					// be in a situation where a user can be waiting for a resource
					// creation timeout (default up to 30mins) to find out that they
					// have not got valid credentials
					Value: false,
				},
			},
			"skip_metadata_api_check": {
				Type: "boolean",
				Default: &tfbridge.DefaultInfo{
					Value: true,
				},
			},
		},
		PreConfigureCallback: preConfigureCallback(&credentialsValidationRun),
		Resources: map[string]*tfbridge.ResourceInfo{
			// AWS Private Certificate Authority
			"aws_acmpca_certificate_authority": {Tok: awsResource(acmpcaMod, "CertificateAuthority")},
			"aws_acmpca_certificate": {
				Tok: awsResource(acmpcaMod, "Certificate"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"certificate": {
						CSharpName: "CertificateDetails",
					},
				},
			},
			"aws_acmpca_policy": {
				Tok: awsResource(acmpcaMod, "Policy"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"policy": {
						CSharpName: "PolicyDetails",
					},
				},
			},
			// Account
			"aws_account_alternate_contact": {Tok: awsResource(accountMod, "AlternativeContact")},
			// AppSync
			"aws_appsync_api_key": {
				Tok: awsResource(appsyncMod, "ApiKey"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"description": {
						Default: managedByPulumi,
					},
				},
			},
			"aws_appsync_function": {
				Tok: awsResource(appsyncMod, "Function"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"name": {
						Default: &tfbridge.DefaultInfo{
							// This is taken from
							// https://docs.aws.amazon.com/appsync/latest/APIReference/API_CreateFunction.html
							From: tfbridge.FromName(tfbridge.AutoNameOptions{
								Separator: "_",
								Maxlen:    255,
								Randlen:   7,
							}),
						},
					},
				},
			},
			"aws_appsync_graphql_api": {Tok: awsResource(appsyncMod, "GraphQLApi")},
			"aws_appsync_datasource": {
				Tok: awsResource(appsyncMod, "DataSource"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"name": {
						Default: &tfbridge.DefaultInfo{
							// This is taken from
							// https://docs.aws.amazon.com/appsync/latest/APIReference/API_CreateDataSource.html
							From: tfbridge.FromName(tfbridge.AutoNameOptions{
								Separator: "_",
								Maxlen:    255,
								Randlen:   7,
							}),
						},
					},
				},
			},
			"aws_appsync_domain_name": {
				Tok: awsResource(appsyncMod, "DomainName"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"domain_name": {
						CSharpName: "Name",
					},
				},
			},
			"aws_appsync_domain_name_api_association": {Tok: awsResource(appsyncMod, "DomainNameApiAssociation")},
			"aws_appsync_type":                        {Tok: awsResource(appsyncMod, "Type")},

			// AppMesh
			"aws_appmesh_mesh":            {Tok: awsResource(appmeshMod, "Mesh")},
			"aws_appmesh_route":           {Tok: awsResource(appmeshMod, "Route")},
			"aws_appmesh_virtual_node":    {Tok: awsResource(appmeshMod, "VirtualNode")},
			"aws_appmesh_virtual_router":  {Tok: awsResource(appmeshMod, "VirtualRouter")},
			"aws_appmesh_virtual_service": {Tok: awsResource(appmeshMod, "VirtualService")},
			"aws_appmesh_gateway_route":   {Tok: awsResource(appmeshMod, "GatewayRoute")},
			"aws_appmesh_virtual_gateway": {Tok: awsResource(appmeshMod, "VirtualGateway")},
			// API Gateway
			"aws_api_gateway_account": {Tok: awsResource(apigatewayMod, "Account")},
			"aws_api_gateway_api_key": {
				Tok: awsResource(apigatewayMod, "ApiKey"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"description": {
						Default: managedByPulumi,
					},
				},
			},
			"aws_api_gateway_authorizer": {
				Tok: awsResource(apigatewayMod, "Authorizer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name:     "restApi",
						Type:     "string",
						AltTypes: []tokens.Type{awsTypeDefaultFile(apigatewayMod, "RestApi")},
					},
				},
			},
			"aws_api_gateway_base_path_mapping": {
				Tok: awsResource(apigatewayMod, "BasePathMapping"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"api_id": {
						Name:     "restApi",
						Type:     "string",
						AltTypes: []tokens.Type{awsTypeDefaultFile(apigatewayMod, "RestApi")},
					},
				},
			},
			"aws_api_gateway_client_certificate": {Tok: awsResource(apigatewayMod, "ClientCertificate")},
			"aws_api_gateway_deployment": {
				Tok: awsResource(apigatewayMod, "Deployment"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name:     "restApi",
						Type:     "string",
						AltTypes: []tokens.Type{awsTypeDefaultFile(apigatewayMod, "RestApi")},
					},
				},
			},
			"aws_api_gateway_documentation_part":    {Tok: awsResource(apigatewayMod, "DocumentationPart")},
			"aws_api_gateway_documentation_version": {Tok: awsResource(apigatewayMod, "DocumentationVersion")},
			"aws_api_gateway_domain_name": {
				Tok: awsResource(apigatewayMod, "DomainName"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"domain_name": {
						CSharpName: "Domain",
					},
				},
			},
			"aws_api_gateway_integration": {
				Tok: awsResource(apigatewayMod, "Integration"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name:     "restApi",
						Type:     "string",
						AltTypes: []tokens.Type{awsTypeDefaultFile(apigatewayMod, "RestApi")},
					},
				},
				DeleteBeforeReplace: true,
			},
			"aws_api_gateway_integration_response": {
				Tok: awsResource(apigatewayMod, "IntegrationResponse"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name:     "restApi",
						Type:     "string",
						AltTypes: []tokens.Type{awsTypeDefaultFile(apigatewayMod, "RestApi")},
					},
				},
			},
			"aws_api_gateway_method": {
				Tok: awsResource(apigatewayMod, "Method"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name:     "restApi",
						Type:     "string",
						AltTypes: []tokens.Type{awsTypeDefaultFile(apigatewayMod, "RestApi")},
					},
				},
			},
			"aws_api_gateway_method_response": {
				Tok: awsResource(apigatewayMod, "MethodResponse"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name:     "restApi",
						Type:     "string",
						AltTypes: []tokens.Type{awsTypeDefaultFile(apigatewayMod, "RestApi")},
					},
				},
			},
			"aws_api_gateway_method_settings": {
				Tok: awsResource(apigatewayMod, "MethodSettings"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name:     "restApi",
						Type:     "string",
						AltTypes: []tokens.Type{awsTypeDefaultFile(apigatewayMod, "RestApi")},
					},
				},
			},
			"aws_api_gateway_model": {
				Tok: awsResource(apigatewayMod, "Model"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name:     "restApi",
						Type:     "string",
						AltTypes: []tokens.Type{awsTypeDefaultFile(apigatewayMod, "RestApi")},
					},
				},
			},
			"aws_api_gateway_request_validator": {
				Tok: awsResource(apigatewayMod, "RequestValidator"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rest_api_id": {
						Name:     "restApi",
						Type:     "string",
						AltTypes: []tokens.Type{awsTypeDefaultFile(apigatewayMod, "RestApi")},
					},
				},
			},
			"aws_api_gateway_resource": {
				Tok: awsResource(apigatewayMod, "Resource"),
				Fields: map[string]*tfbridge.SchemaInfo{
					// TODO[pulumi/terraform-bridge#5] Strongly type the parent refernence to align with other uses
					// "parent_id": {
					// 	Name: "parent",
					// 	Type: awsTypeDefaultFile(apigatewayMod, "Resource"),
					// },
					"rest_api_id": {
						Name:     "restApi",
						Type:     "string",
						AltTypes: []tokens.Type{awsTypeDefaultFile(apigatewayMod, "RestApi")},
					},
				},
			},
			"aws_api_gateway_gateway_response": {Tok: awsResource(apigatewayMod, "Response")},
			"aws_api_gateway_rest_api":         {Tok: awsResource(apigatewayMod, "RestApi")},
			"aws_api_gateway_stage": {
				Tok: awsResource(apigatewayMod, "Stage"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"deployment_id": {
						Name:     "deployment",
						Type:     "string",
						AltTypes: []tokens.Type{awsTypeDefaultFile(apigatewayMod, "Deployment")},
					},
					"rest_api_id": {
						Name:     "restApi",
						Type:     "string",
						AltTypes: []tokens.Type{awsTypeDefaultFile(apigatewayMod, "RestApi")},
					},
				},
			},
			"aws_api_gateway_usage_plan":      {Tok: awsResource(apigatewayMod, "UsagePlan")},
			"aws_api_gateway_usage_plan_key":  {Tok: awsResource(apigatewayMod, "UsagePlanKey")},
			"aws_api_gateway_rest_api_policy": {Tok: awsResource(apigatewayMod, "RestApiPolicy")},
			"aws_api_gateway_vpc_link": {
				Tok: awsResource(apigatewayMod, "VpcLink"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"target_arns": {Name: "targetArn"},
				},
			},
			// API Gateway v2
			"aws_apigatewayv2_api":         {Tok: awsResource(apigatewayv2Mod, "Api")},
			"aws_apigatewayv2_authorizer":  {Tok: awsResource(apigatewayv2Mod, "Authorizer")},
			"aws_apigatewayv2_integration": {Tok: awsResource(apigatewayv2Mod, "Integration")},
			"aws_apigatewayv2_model":       {Tok: awsResource(apigatewayv2Mod, "Model")},
			"aws_apigatewayv2_deployment":  {Tok: awsResource(apigatewayv2Mod, "Deployment")},
			"aws_apigatewayv2_domain_name": {
				Tok: awsResource(apigatewayv2Mod, "DomainName"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"domain_name": {
						CSharpName: "Domain",
					},
				},
			},
			"aws_apigatewayv2_integration_response": {Tok: awsResource(apigatewayv2Mod, "IntegrationResponse")},
			"aws_apigatewayv2_route":                {Tok: awsResource(apigatewayv2Mod, "Route")},
			"aws_apigatewayv2_route_response":       {Tok: awsResource(apigatewayv2Mod, "RouteResponse")},
			"aws_apigatewayv2_stage":                {Tok: awsResource(apigatewayv2Mod, "Stage")},
			"aws_apigatewayv2_api_mapping":          {Tok: awsResource(apigatewayv2Mod, "ApiMapping")},
			"aws_apigatewayv2_vpc_link":             {Tok: awsResource(apigatewayv2Mod, "VpcLink")},
			// Application Auto Scaling
			"aws_appautoscaling_policy": {Tok: awsResource(appautoscalingMod, "Policy")},
			"aws_appautoscaling_scheduled_action": {
				Tok: awsResource(appautoscalingMod, "ScheduledAction"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"scalable_target_action": {
						Elem: &tfbridge.SchemaInfo{
							Fields: map[string]*tfbridge.SchemaInfo{
								"max_capacity": {
									Type: "integer",
								},
								"min_capacity": {
									Type: "integer",
								},
							},
						},
					},
				},
			},
			"aws_appautoscaling_target": {Tok: awsResource(appautoscalingMod, "Target")},

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
			"aws_athena_named_query":  {Tok: awsResource(athenaMod, "NamedQuery")},
			"aws_athena_workgroup":    {Tok: awsResource(athenaMod, "Workgroup")},
			"aws_athena_data_catalog": {Tok: awsResource(athenaMod, "DataCatalog")},

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
						Elem: &tfbridge.SchemaInfo{Type: awsType(autoscalingMod, "metrics", "Metric")},
					},
					"metrics_granularity": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(autoscalingMod, "MetricsGranularity", "MetricsGranularity")},
					},
					"tag": {
						// Explicitly map tag => tags to avoid confusion with tags => tagsCollection below.
						Name: "tags",
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
						Elem: &tfbridge.SchemaInfo{Type: awsTypeDefaultFile(autoscalingMod, "NotificationType")},
					},
				},
			},
			"aws_autoscaling_policy":   {Tok: awsResource(autoscalingMod, "Policy")},
			"aws_autoscaling_schedule": {Tok: awsResource(autoscalingMod, "Schedule")},
			"aws_autoscaling_group_tag": {
				Tok: awsResource(autoscalingMod, "Tag"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"tag": {
						CSharpName: "TagDetails",
					},
				},
			},
			// Autoscaling Plans
			"aws_autoscalingplans_scaling_plan": {Tok: awsResource(autoscalingPlansMod, "ScalingPlan")},
			// Backup
			"aws_backup_plan":                     {Tok: awsResource(backupMod, "Plan")},
			"aws_backup_selection":                {Tok: awsResource(backupMod, "Selection")},
			"aws_backup_vault":                    {Tok: awsResource(backupMod, "Vault")},
			"aws_backup_vault_notifications":      {Tok: awsResource(backupMod, "VaultNotifications")},
			"aws_backup_vault_policy":             {Tok: awsResource(backupMod, "VaultPolicy")},
			"aws_backup_vault_lock_configuration": {Tok: awsResource(backupMod, "VaultLockConfiguration")},
			"aws_backup_region_settings":          {Tok: awsResource(backupMod, "RegionSettings")},
			"aws_backup_framework":                {Tok: awsResource(backupMod, "Framework")},
			"aws_backup_report_plan":              {Tok: awsResource(backupMod, "ReportPlan")},
			"aws_backup_global_settings": {
				Tok: awsResource(backupMod, "GlobalSettings"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"global_settings": {
						CSharpName: "GlobalSettingsList",
					},
				},
			},
			// Batch
			"aws_batch_compute_environment": {Tok: awsResource(batchMod, "ComputeEnvironment")},
			"aws_batch_job_definition":      {Tok: awsResource(batchMod, "JobDefinition")},
			"aws_batch_job_queue":           {Tok: awsResource(batchMod, "JobQueue")},
			"aws_batch_scheduling_policy":   {Tok: awsResource(batchMod, "SchedulingPolicy")},
			// Chime
			"aws_chime_voice_connector":                         {Tok: awsResource(chimeMod, "VoiceConnector")},
			"aws_chime_voice_connector_group":                   {Tok: awsResource(chimeMod, "VoiceConnectorGroup")},
			"aws_chime_voice_connector_origination":             {Tok: awsResource(chimeMod, "VoiceConnectorOrganization")},
			"aws_chime_voice_connector_termination":             {Tok: awsResource(chimeMod, "VoiceConnectorTermination")},
			"aws_chime_voice_connector_logging":                 {Tok: awsResource(chimeMod, "VoiceConnectorLogging")},
			"aws_chime_voice_connector_streaming":               {Tok: awsResource(chimeMod, "VoiceConnectorStreaming")},
			"aws_chime_voice_connector_termination_credentials": {Tok: awsResource(chimeMod, "VoiceConnectorTerminationCredentials")},
			// Chime SDK Media Pipelines
			"aws_chimesdkmediapipelines_media_insights_pipeline_configuration": {
				Tok: awsResource(chimeSDKMediaPipelinesMod, "MediaInsightsPipelineConfiguration"),
			},
			// Cloud9
			"aws_cloud9_environment_ec2":        {Tok: awsResource(cloud9Mod, "EnvironmentEC2")},
			"aws_cloud9_environment_membership": {Tok: awsResource(cloud9Mod, "EnvironmentMembership")},
			// Cloud Control API
			"aws_cloudcontrolapi_resource": {Tok: awsResource(cloudControlMod, "Resource")},
			// CloudFormation
			"aws_cloudformation_stack":              {Tok: awsResource(cloudformationMod, "Stack")},
			"aws_cloudformation_stack_set":          {Tok: awsResource(cloudformationMod, "StackSet")},
			"aws_cloudformation_stack_set_instance": {Tok: awsResource(cloudformationMod, "StackSetInstance")},
			"aws_cloudformation_type":               {Tok: awsResource(cloudformationMod, "CloudFormationType")},
			// CloudHSM
			"aws_cloudhsm_v2_cluster": {
				Tok: awsResource(cloudhsmv2Mod, "Cluster"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"cluster_state": {
						CSharpName: "State",
					},
				},
			},
			"aws_cloudhsm_v2_hsm": {
				Tok: awsResource(cloudhsmv2Mod, "Hsm"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"hsm_state": {
						CSharpName: "State",
					},
				},
			},
			// CloudFront
			"aws_cloudfront_origin_access_identity": {Tok: awsResource(cloudfrontMod, "OriginAccessIdentity")},
			"aws_cloudfront_origin_request_policy":  {Tok: awsResource(cloudfrontMod, "OriginRequestPolicy")},
			"aws_cloudfront_cache_policy":           {Tok: awsResource(cloudfrontMod, "CachePolicy")},
			"aws_cloudfront_realtime_log_config":    {Tok: awsResource(cloudfrontMod, "RealtimeLogConfig")},
			"aws_cloudfront_key_group":              {Tok: awsResource(cloudfrontMod, "KeyGroup")},
			"aws_cloudfront_function":               {Tok: awsResource(cloudfrontMod, "Function")},
			"aws_cloudfront_monitoring_subscription": {
				Tok: awsResource(cloudfrontMod, "MonitoringSubscription"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"monitoring_subscription": {
						CSharpName: "MonitoringSubscriptionDetails",
					},
				},
			},
			"aws_cloudfront_response_headers_policy":        {Tok: awsResource(cloudfrontMod, "ResponseHeadersPolicy")},
			"aws_cloudfront_field_level_encryption_config":  {Tok: awsResource(cloudfrontMod, "FieldLevelEncryptionConfig")},
			"aws_cloudfront_field_level_encryption_profile": {Tok: awsResource(cloudfrontMod, "FieldLevelEncryptionProfile")},
			"aws_cloudfront_origin_access_control":          {Tok: awsResource(cloudfrontMod, "OriginAccessControl")},

			// CloudSearch
			"aws_cloudsearch_domain":                       {Tok: awsResource(cloudsearchMod, "Domain")},
			"aws_cloudsearch_domain_service_access_policy": {Tok: awsResource(cloudsearchMod, "DomainServiceAccessPolicy")},

			// CloudTrail
			"aws_cloudtrail":                  {Tok: awsResource(cloudtrailMod, "Trail")},
			"aws_cloudtrail_event_data_store": {Tok: awsResource(cloudtrailMod, "EventDataStore")},
			// CloudWatch
			"aws_cloudwatch_dashboard":        {Tok: awsResource(cloudwatchMod, "Dashboard")},
			"aws_cloudwatch_event_permission": {Tok: awsResource(cloudwatchMod, "EventPermission")},
			"aws_cloudwatch_event_rule": {
				Tok: awsResource(cloudwatchMod, "EventRule"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"name": tfbridge.AutoName("name", 64, "-"),
				},
			},
			"aws_cloudwatch_event_target": {
				Tok: awsResource(cloudwatchMod, "EventTarget"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"target_id": tfbridge.AutoName("targetId", 255, "-"),
				},
			},
			"aws_cloudwatch_log_destination":        {Tok: awsResource(cloudwatchMod, "LogDestination")},
			"aws_cloudwatch_log_destination_policy": {Tok: awsResource(cloudwatchMod, "LogDestinationPolicy")},
			"aws_cloudwatch_log_group": {
				IDFields: []string{"name"},
				Tok:      awsResource(cloudwatchMod, "LogGroup"),
			},
			"aws_cloudwatch_log_metric_filter": {Tok: awsResource(cloudwatchMod, "LogMetricFilter")},
			"aws_cloudwatch_log_resource_policy": {
				Tok: awsResource(cloudwatchMod, "LogResourcePolicy"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"policy_document": {
						Type:      "string",
						AltTypes:  []tokens.Type{awsType(iamMod, "documents", "PolicyDocument")},
						Transform: tfbridge.TransformJSONDocument,
					},
				},
			},
			"aws_cloudwatch_log_stream":      {Tok: awsResource(cloudwatchMod, "LogStream")},
			"aws_cloudwatch_event_bus":       {Tok: awsResource(cloudwatchMod, "EventBus")},
			"aws_cloudwatch_composite_alarm": {Tok: awsResource(cloudwatchMod, "CompositeAlarm")},
			"aws_cloudwatch_event_archive":   {Tok: awsResource(cloudwatchMod, "EventArchive")},
			"aws_cloudwatch_event_endpoint":  {Tok: awsResource(cloudwatchMod, "EventEndpoint")},
			"aws_cloudwatch_log_subscription_filter": {
				Tok: awsResource(cloudwatchMod, "LogSubscriptionFilter"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"log_group_name": {
						Name:     "logGroup",
						Type:     "string",
						AltTypes: []tokens.Type{awsResource(cloudwatchMod, "LogGroup")},
					},
				},
				DeleteBeforeReplace: true, // only 1 active filter is legal at once
			},
			"aws_cloudwatch_metric_alarm": {
				Tok: awsResource(cloudwatchMod, "MetricAlarm"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"alarm_name": tfbridge.AutoName("name", 255, "-"),
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
			"aws_cloudwatch_query_definition":           {Tok: awsResource(cloudwatchMod, "QueryDefinition")},
			"aws_cloudwatch_metric_stream":              {Tok: awsResource(cloudwatchMod, "MetricStream")},
			"aws_cloudwatch_event_api_destination":      {Tok: awsResource(cloudwatchMod, "EventApiDestination")},
			"aws_cloudwatch_event_connection":           {Tok: awsResource(cloudwatchMod, "EventConnection")},
			"aws_cloudwatch_event_bus_policy":           {Tok: awsResource(cloudwatchMod, "EventBusPolicy")},
			"aws_cloudwatch_log_data_protection_policy": {Tok: awsResource(cloudwatchMod, "LogDataProtectionPolicy")},
			// https://aws.amazon.com/blogs/networking-and-content-delivery/introducing-amazon-cloudwatch-internet-monitor/
			"aws_internetmonitor_monitor": {Tok: awsResource(cloudwatchMod, "InternetMonitor")},

			// CodeBuild
			"aws_codebuild_project":           {Tok: awsResource(codebuildMod, "Project")},
			"aws_codebuild_webhook":           {Tok: awsResource(codebuildMod, "Webhook")},
			"aws_codebuild_source_credential": {Tok: awsResource(codebuildMod, "SourceCredential")},
			"aws_codebuild_report_group":      {Tok: awsResource(codebuildMod, "ReportGroup")},
			"aws_codebuild_resource_policy":   {Tok: awsResource(codebuildMod, "ResourcePolicy")},
			// CodeDeploy
			"aws_codedeploy_app": {Tok: awsResource(codedeployMod, "Application")},
			"aws_codedeploy_deployment_config": {
				Tok: awsResource(codedeployMod, "DeploymentConfig"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"deployment_config_name": {
						Default: &tfbridge.DefaultInfo{
							// This is taken from
							// https://docs.aws.amazon.com/codedeploy/latest/APIReference/API_CreateDeployment.html
							From: tfbridge.FromName(tfbridge.AutoNameOptions{
								Separator: "_",
								Maxlen:    100,
								Randlen:   7,
							}),
						},
					},
				},
			},
			"aws_codedeploy_deployment_group": {Tok: awsResource(codedeployMod, "DeploymentGroup")},
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
			"aws_codecommit_approval_rule_template": {Tok: awsResource(codecommitMod, "ApprovalRuleTemplate")},
			"aws_codecommit_approval_rule_template_association": {
				Tok: awsResource(codecommitMod, "ApprovalRuleTemplateAssociation"),
			},
			// CodeGuruReviewer
			"aws_codegurureviewer_repository_association": {Tok: awsResource(codeguruReviewerMod, "RepositoryAssociation")},
			// CodePipeline
			"aws_codepipeline":                    {Tok: awsResource(codepipelineMod, "Pipeline")},
			"aws_codepipeline_custom_action_type": {Tok: awsResource(codepipelineMod, "CustomActionType")},
			"aws_codepipeline_webhook":            {Tok: awsResource(codepipelineMod, "Webhook")},

			// Cognito
			"aws_cognito_identity_pool":                        {Tok: awsResource(cognitoMod, "IdentityPool")},
			"aws_cognito_identity_pool_roles_attachment":       {Tok: awsResource(cognitoMod, "IdentityPoolRoleAttachment")},
			"aws_cognito_identity_provider":                    {Tok: awsResource(cognitoMod, "IdentityProvider")},
			"aws_cognito_resource_server":                      {Tok: awsResource(cognitoMod, "ResourceServer")},
			"aws_cognito_user_group":                           {Tok: awsResource(cognitoMod, "UserGroup")},
			"aws_cognito_user_pool":                            {Tok: awsResource(cognitoMod, "UserPool")},
			"aws_cognito_user_pool_client":                     {Tok: awsResource(cognitoMod, "UserPoolClient")},
			"aws_cognito_user_pool_domain":                     {Tok: awsResource(cognitoMod, "UserPoolDomain")},
			"aws_cognito_user_pool_ui_customization":           {Tok: awsResource(cognitoMod, "UserPoolUICustomization")},
			"aws_cognito_identity_pool_provider_principal_tag": {Tok: awsResource(cognitoMod, "IdentityPoolProviderPrincipalTag")},
			"aws_cognito_user":                                 {Tok: awsResource(cognitoMod, "User")},
			"aws_cognito_user_in_group":                        {Tok: awsResource(cognitoMod, "UserInGroup")},
			"aws_cognito_risk_configuration":                   {Tok: awsResource(cognitoMod, "RiskConfiguration")},

			// Comprehend
			"aws_comprehend_document_classifier": {Tok: awsResource(comprehendMod, "DocumentClassifier")},
			"aws_comprehend_entity_recognizer":   {Tok: awsResource(comprehendMod, "EntityRecognizer")},

			// Connect
			"aws_connect_bot_association":             {Tok: awsResource(connectMod, "BotAssociation")},
			"aws_connect_contact_flow_module":         {Tok: awsResource(connectMod, "ContactFlowModule")},
			"aws_connect_contact_flow":                {Tok: awsResource(connectMod, "ContactFlow")},
			"aws_connect_hours_of_operation":          {Tok: awsResource(connectMod, "HoursOfOperation")},
			"aws_connect_instance_storage_config":     {Tok: awsResource(connectMod, "InstanceStorageConfig")},
			"aws_connect_instance":                    {Tok: awsResource(connectMod, "Instance")},
			"aws_connect_lambda_function_association": {Tok: awsResource(connectMod, "LambdaFunctionAssociation")},
			"aws_connect_phone_number": {
				Tok: awsResource(connectMod, "PhoneNumber"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"phone_number": {
						CSharpName: "PhoneNumberValue",
					},
				},
			},
			"aws_connect_queue":                    {Tok: awsResource(connectMod, "Queue")},
			"aws_connect_quick_connect":            {Tok: awsResource(connectMod, "QuickConnect")},
			"aws_connect_routing_profile":          {Tok: awsResource(connectMod, "RoutingProfile")},
			"aws_connect_security_profile":         {Tok: awsResource(connectMod, "SecurityProfile")},
			"aws_connect_user_hierarchy_group":     {Tok: awsResource(connectMod, "UserHierarchyGroup")},
			"aws_connect_user_hierarchy_structure": {Tok: awsResource(connectMod, "UserHierarchyStructure")},
			"aws_connect_user":                     {Tok: awsResource(connectMod, "User")},
			"aws_connect_vocabulary":               {Tok: awsResource(connectMod, "Vocabulary")},

			// Config
			"aws_config_aggregate_authorization":         {Tok: awsResource(cfgMod, "AggregateAuthorization")},
			"aws_config_config_rule":                     {Tok: awsResource(cfgMod, "Rule")},
			"aws_config_configuration_aggregator":        {Tok: awsResource(cfgMod, "ConfigurationAggregator")},
			"aws_config_configuration_recorder":          {Tok: awsResource(cfgMod, "Recorder")},
			"aws_config_configuration_recorder_status":   {Tok: awsResource(cfgMod, "RecorderStatus")},
			"aws_config_delivery_channel":                {Tok: awsResource(cfgMod, "DeliveryChannel")},
			"aws_config_organization_custom_rule":        {Tok: awsResource(cfgMod, "OrganizationCustomRule")},
			"aws_config_organization_managed_rule":       {Tok: awsResource(cfgMod, "OrganizationManagedRule")},
			"aws_config_remediation_configuration":       {Tok: awsResource(cfgMod, "RemediationConfiguration")},
			"aws_config_conformance_pack":                {Tok: awsResource(cfgMod, "ConformancePack")},
			"aws_config_organization_conformance_pack":   {Tok: awsResource(cfgMod, "OrganizationConformancePack")},
			"aws_config_organization_custom_policy_rule": {Tok: awsResource(cfgMod, "OrganizationCustomPolicyRule")},

			// Cost and Usage Report
			"aws_cur_report_definition": {Tok: awsResource(curMod, "ReportDefinition")},

			// CostExplorer
			"aws_ce_cost_category":        {Tok: awsResource(costExplorerMod, "CostCategory")},
			"aws_ce_anomaly_monitor":      {Tok: awsResource(costExplorerMod, "AnomalyMonitor")},
			"aws_ce_anomaly_subscription": {Tok: awsResource(costExplorerMod, "AnomalySubscription")},
			"aws_ce_cost_allocation_tag":  {Tok: awsResource(costExplorerMod, "CostAllocationTag")},

			// DataExchange
			"aws_dataexchange_data_set": {Tok: awsResource(dataexchangeMod, "DataSet")},
			"aws_dataexchange_revision": {Tok: awsResource(dataexchangeMod, "Revision")},

			// Datapipeline
			"aws_datapipeline_pipeline_definition": {Tok: awsResource(datapipelineMod, "PipelineDefinition")},

			// DataSync
			"aws_datasync_agent": {Tok: awsResource(datasyncMod, "Agent")},
			"aws_datasync_location_efs": {
				Tok: awsResource(datasyncMod, "EfsLocation"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"efs_file_system_arn": {Type: awsTypeDefaultFile(awsMod, "ARN")},
				},
			},
			"aws_datasync_location_nfs": {Tok: awsResource(datasyncMod, "NfsLocation")},
			"aws_datasync_location_s3": {
				Tok: awsResource(datasyncMod, "S3Location"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"s3_bucket_arn": {Type: awsTypeDefaultFile(awsMod, "ARN")},
				},
			},
			"aws_datasync_task": {
				Tok: awsResource(datasyncMod, "Task"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"destination_location_arn": {Type: awsTypeDefaultFile(awsMod, "ARN")},
					"source_location_arn":      {Type: awsTypeDefaultFile(awsMod, "ARN")},
					"cloudwatch_log_group_arn": {Type: awsTypeDefaultFile(awsMod, "ARN")},
				},
			},
			"aws_datasync_location_smb":                     {Tok: awsResource(datasyncMod, "LocationSmb")},
			"aws_datasync_location_fsx_windows_file_system": {Tok: awsResource(datasyncMod, "LocationFsxWindows")},
			"aws_datasync_location_fsx_lustre_file_system":  {Tok: awsResource(datasyncMod, "LocationFsxLustre")},
			"aws_datasync_location_hdfs":                    {Tok: awsResource(datasyncMod, "LocationHdfs")},
			"aws_datasync_location_fsx_openzfs_file_system": {Tok: awsResource(datasyncMod, "FsxOpenZfsFileSystem")},
			"aws_datasync_location_object_storage":          {Tok: awsResource(datasyncMod, "LocationObjectStorage")},
			// Data Lifecycle Manager
			"aws_dlm_lifecycle_policy": {
				Tok: awsResource(dlmMod, "LifecyclePolicy"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"policy_details": {
						Elem: &tfbridge.SchemaInfo{
							Fields: map[string]*tfbridge.SchemaInfo{
								"resource_types": {
									MaxItemsOne: tfbridge.False(),
								},
							},
						},
					},
				},
			},

			// Detective
			"aws_detective_graph":               {Tok: awsResource(detectiveMod, "Graph")},
			"aws_detective_invitation_accepter": {Tok: awsResource(detectiveMod, "InvitationAccepter")},
			"aws_detective_member":              {Tok: awsResource(detectiveMod, "Member")},

			// Data Migration Service
			"aws_dms_certificate":              {Tok: awsResource(dmsMod, "Certificate")},
			"aws_dms_endpoint":                 {Tok: awsResource(dmsMod, "Endpoint")},
			"aws_dms_s3_endpoint":              {Tok: awsResource(dmsMod, "S3Endpoint")},
			"aws_dms_replication_instance":     {Tok: awsResource(dmsMod, "ReplicationInstance")},
			"aws_dms_replication_subnet_group": {Tok: awsResource(dmsMod, "ReplicationSubnetGroup")},
			"aws_dms_replication_task":         {Tok: awsResource(dmsMod, "ReplicationTask")},
			"aws_dms_event_subscription":       {Tok: awsResource(dmsMod, "EventSubscription")},
			// DAX
			"aws_dax_cluster":         {Tok: awsResource(daxMod, "Cluster")},
			"aws_dax_parameter_group": {Tok: awsResource(daxMod, "ParameterGroup")},
			"aws_dax_subnet_group":    {Tok: awsResource(daxMod, "SubnetGroup")},

			// DeviceFarm
			"aws_devicefarm_project":           {Tok: awsResource(devicefarmMod, "Project")},
			"aws_devicefarm_device_pool":       {Tok: awsResource(devicefarmMod, "DevicePool")},
			"aws_devicefarm_network_profile":   {Tok: awsResource(devicefarmMod, "NetworkProfile")},
			"aws_devicefarm_upload":            {Tok: awsResource(devicefarmMod, "Upload")},
			"aws_devicefarm_instance_profile":  {Tok: awsResource(devicefarmMod, "InstanceProfile")},
			"aws_devicefarm_test_grid_project": {Tok: awsResource(devicefarmMod, "TestGridProject")},

			// DirectoryService
			"aws_directory_service_conditional_forwarder": {Tok: awsResource(directoryserviceMod, "ConditionalForwader")},
			"aws_directory_service_directory": {
				Tok: awsResource(directoryserviceMod, "Directory"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"name": {Name: "name"},
				},
			},
			"aws_directory_service_log_subscription":          {Tok: awsResource(directoryserviceMod, "LogService")},
			"aws_directory_service_shared_directory":          {Tok: awsResource(directoryserviceMod, "SharedDirectory")},
			"aws_directory_service_shared_directory_accepter": {Tok: awsResource(directoryserviceMod, "SharedDirectoryAccepter")},
			"aws_directory_service_radius_settings":           {Tok: awsResource(directoryserviceMod, "RadiusSettings")},
			"aws_directory_service_region":                    {Tok: awsResource(directoryserviceMod, "ServiceRegion")},

			"aws_directory_service_trust": {
				Tok: awsResource(directoryserviceMod, "Trust"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"trust_state": {
						// Without this rename, C# compilation fails as there is a TrustState
						// class generated in the SDK that now conflicts with TrustState field.
						CSharpName: "Truststate",
					},
				},
			},

			// Document DB
			"aws_docdb_cluster":                 {Tok: awsResource(docdbMod, "Cluster")},
			"aws_docdb_cluster_instance":        {Tok: awsResource(docdbMod, "ClusterInstance")},
			"aws_docdb_cluster_parameter_group": {Tok: awsResource(docdbMod, "ClusterParameterGroup")},
			"aws_docdb_cluster_snapshot":        {Tok: awsResource(docdbMod, "ClusterSnapshot")},
			"aws_docdb_subnet_group": {
				Tok: awsResource(docdbMod, "SubnetGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"description": {
						Default: managedByPulumi,
					},
				},
			},
			"aws_docdb_global_cluster":     {Tok: awsResource(docdbMod, "GlobalCluster")},
			"aws_docdb_event_subscription": {Tok: awsResource(docdbMod, "EventSubscription")},

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
			"aws_dx_private_virtual_interface":        {Tok: awsResource(dxMod, "PrivateVirtualInterface")},
			"aws_dx_public_virtual_interface":         {Tok: awsResource(dxMod, "PublicVirtualInterface")},
			"aws_dx_lag":                              {Tok: awsResource(dxMod, "LinkAggregationGroup")},
			"aws_dx_transit_virtual_interface":        {Tok: awsResource(dxMod, "TransitVirtualInterface")},
			"aws_dx_hosted_transit_virtual_interface": {Tok: awsResource(dxMod, "HostedTransitVirtualInterface")},
			"aws_dx_connection_confirmation":          {Tok: awsResource(dxMod, "ConnectionConfirmation")},
			"aws_dx_hosted_connection":                {Tok: awsResource(dxMod, "HostedConnection")},
			"aws_dx_hosted_transit_virtual_interface_accepter": {
				Tok: awsResource(dxMod, "HostedTransitVirtualInterfaceAcceptor"),
			},
			"aws_dx_macsec_key_association": {Tok: awsResource(dxMod, "MacsecKeyAssociation")},
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
			"aws_dynamodb_table_item":                    {Tok: awsResource(dynamodbMod, "TableItem")},
			"aws_dynamodb_kinesis_streaming_destination": {Tok: awsResource(dynamodbMod, "KinesisStreamingDestination")},
			"aws_dynamodb_tag":                           {Tok: awsResource(dynamodbMod, "Tag")},
			"aws_dynamodb_contributor_insights":          {Tok: awsResource(dynamodbMod, "ContributorInsights")},
			"aws_dynamodb_table_replica":                 {Tok: awsResource(dynamodbMod, "TableReplica")},
			// Elastic Beanstalk
			"aws_elastic_beanstalk_application": {Tok: awsResource(elasticbeanstalkMod, "Application")},
			"aws_elastic_beanstalk_application_version": {
				Tok: awsResource(elasticbeanstalkMod, "ApplicationVersion"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"application": {
						Type:     "string",
						AltTypes: []tokens.Type{awsResource(elasticbeanstalkMod, "Application")},
					},
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
					"name": tfbridge.AutoName("name", 40, "-"),
					"application": {
						Type:     "string",
						AltTypes: []tokens.Type{awsResource(elasticbeanstalkMod, "Application")},
					},
					"version_label": {
						Name: "version",
						Type: awsResource(elasticbeanstalkMod, "ApplicationVersion"),
					},
				},
			},
			// Elastic Block Store
			"aws_ebs_default_kms_key":       {Tok: awsResource(ebsMod, "DefaultKmsKey")},
			"aws_ebs_encryption_by_default": {Tok: awsResource(ebsMod, "EncryptionByDefault")},
			"aws_ebs_snapshot":              {Tok: awsResource(ebsMod, "Snapshot")},
			"aws_ebs_snapshot_copy":         {Tok: awsResource(ebsMod, "SnapshotCopy")},
			"aws_ebs_volume":                {Tok: awsResource(ebsMod, "Volume")},
			"aws_ebs_snapshot_import":       {Tok: awsResource(ebsMod, "SnapshotImport")},
			// ElastiCache
			"aws_elasticache_cluster": {
				Tok: awsResource(elasticacheMod, "Cluster"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"cluster_id": tfbridge.AutoNameTransform("clusterId", 50, func(name string) string {
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
					"replication_group_id": tfbridge.AutoNameTransform("replicationGroupId", 40, strings.ToLower),
					"auto_minor_version_upgrade": {
						Type: "boolean",
					},
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
			"aws_elasticache_global_replication_group": {Tok: awsResource(elasticacheMod, "GlobalReplicationGroup")},
			"aws_elasticache_user":                     {Tok: awsResource(elasticacheMod, "User")},
			"aws_elasticache_user_group":               {Tok: awsResource(elasticacheMod, "UserGroup")},
			"aws_elasticache_user_group_association":   {Tok: awsResource(elasticacheMod, "UserGroupAssociation")},
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
						AltTypes: []tokens.Type{awsTypeDefaultFile(iamMod, "InstanceProfile")},
					},
					"instance_type": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(ec2Mod, "InstanceType", "InstanceType")},
					},
					"instance_state": {
						CSharpName: "State",
					},
					"security_groups": {
						DeprecationMessage: "Use of `securityGroups` is discouraged as it does not allow for changes and" +
							" will force your instance to be replaced if changes are made. To avoid this," +
							" use `vpcSecurityGroupIds` which allows for updates.",
					},
					"tenancy": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(ec2Mod, "Tenancy", "Tenancy")},
					},
				},
			},
			"aws_internet_gateway":               {Tok: awsResource(ec2Mod, "InternetGateway")},
			"aws_internet_gateway_attachment":    {Tok: awsResource(ec2Mod, "InternetGatewayAttachment")},
			"aws_ec2_image_block_public_access":  {Tok: awsResource(ec2Mod, "ImageBlockPublicAccess")},
			"aws_ec2_instance_metadata_defaults": {Tok: awsResource(ec2Mod, "InstanceMetadataDefaults")},
			"aws_key_pair": {
				Tok: awsResource(ec2Mod, "KeyPair"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"key_name": tfbridge.AutoName("keyName", 255, "-"),
				},
			},
			"aws_launch_configuration": {
				Tok: awsResource(ec2Mod, "LaunchConfiguration"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"iam_instance_profile": {
						Type:     "string",
						AltTypes: []tokens.Type{awsTypeDefaultFile(iamMod, "InstanceProfile")},
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
			"aws_network_acl_association":      {Tok: awsResource(ec2Mod, "NetworkAclAssociation")},
			"aws_network_interface":            {Tok: awsResource(ec2Mod, "NetworkInterface")},
			"aws_network_interface_attachment": {Tok: awsResource(ec2Mod, "NetworkInterfaceAttachment")},
			"aws_placement_group": {
				Tok: awsResource(ec2Mod, "PlacementGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"strategy": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(ec2Mod, "PlacementStrategy", "PlacementStrategy")},
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
						Type:     "string",
						AltTypes: []tokens.Type{awsType(ec2Mod, "InstanceType", "InstanceType")},
					},
					"instance_platform": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(ec2Mod, "InstancePlatform", "InstancePlatform")},
					},
					"tenancy": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(ec2Mod, "Tenancy", "Tenancy")},
					},
				},
			},
			"aws_ec2_fleet": {
				Tok: awsResource(ec2Mod, "Fleet"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"fleet_state": {
						CSharpName: "State",
					},
				},
			},
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
			"aws_security_group_rule": {
				Tok:                 awsResource(ec2Mod, "SecurityGroupRule"),
				DeleteBeforeReplace: true,
				Fields: map[string]*tfbridge.SchemaInfo{
					"protocol": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(ec2Mod, "ProtocolType", "ProtocolType")},
					},
				},
			},
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
			"aws_vpc_endpoint_connection_notification":        {Tok: awsResource(ec2Mod, "VpcEndpointConnectionNotification")},
			"aws_vpc_endpoint_route_table_association":        {Tok: awsResource(ec2Mod, "VpcEndpointRouteTableAssociation")},
			"aws_vpc_endpoint_service":                        {Tok: awsResource(ec2Mod, "VpcEndpointService")},
			"aws_vpc_endpoint_service_allowed_principal":      {Tok: awsResource(ec2Mod, "VpcEndpointServiceAllowedPrinciple")},
			"aws_vpc_endpoint_subnet_association":             {Tok: awsResource(ec2Mod, "VpcEndpointSubnetAssociation")},
			"aws_vpc_endpoint_policy":                         {Tok: awsResource(ec2Mod, "VpcEndpointPolicy")},
			"aws_vpc_endpoint_security_group_association":     {Tok: awsResource(ec2Mod, "SecurityGroupAssociation")},
			"aws_vpc_ipv4_cidr_block_association":             {Tok: awsResource(ec2Mod, "VpcIpv4CidrBlockAssociation")},
			"aws_vpc_network_performance_metric_subscription": {Tok: awsResource(ec2Mod, "VpcNetworkPerformanceMetricSubscription")},
			"aws_vpn_connection":                              {Tok: awsResource(ec2Mod, "VpnConnection")},
			"aws_vpn_connection_route":                        {Tok: awsResource(ec2Mod, "VpnConnectionRoute")},
			"aws_vpn_gateway":                                 {Tok: awsResource(ec2Mod, "VpnGateway")},
			"aws_vpn_gateway_attachment":                      {Tok: awsResource(ec2Mod, "VpnGatewayAttachment")},
			"aws_vpn_gateway_route_propagation":               {Tok: awsResource(ec2Mod, "VpnGatewayRoutePropagation")},
			"aws_ec2_traffic_mirror_filter":                   {Tok: awsResource(ec2Mod, "TrafficMirrorFilter")},
			"aws_ec2_traffic_mirror_filter_rule":              {Tok: awsResource(ec2Mod, "TrafficMirrorFilterRule")},
			"aws_ec2_traffic_mirror_session":                  {Tok: awsResource(ec2Mod, "TrafficMirrorSession")},
			"aws_ec2_traffic_mirror_target":                   {Tok: awsResource(ec2Mod, "TrafficMirrorTarget")},
			"aws_ec2_availability_zone_group":                 {Tok: awsResource(ec2Mod, "AvailabilityZoneGroup")},
			"aws_ec2_local_gateway_route":                     {Tok: awsResource(ec2Mod, "LocalGatewayRoute")},
			"aws_ec2_local_gateway_route_table_vpc_association": {
				Tok: awsResource(ec2Mod, "LocalGatewayRouteTableVpcAssociation"),
			},
			"aws_ec2_tag":                             {Tok: awsResource(ec2Mod, "Tag")},
			"aws_ec2_host":                            {Tok: awsResource(ec2Mod, "DedicatedHost")},
			"aws_ec2_managed_prefix_list":             {Tok: awsResource(ec2Mod, "ManagedPrefixList")},
			"aws_ec2_carrier_gateway":                 {Tok: awsResource(ec2Mod, "CarrierGateway")},
			"aws_ec2_managed_prefix_list_entry":       {Tok: awsResource(ec2Mod, "ManagedPrefixListEntry")},
			"aws_vpc_ipam":                            {Tok: awsResource(ec2Mod, "VpcIpam")},
			"aws_vpc_ipam_pool":                       {Tok: awsResource(ec2Mod, "VpcIpamPool")},
			"aws_vpc_ipam_scope":                      {Tok: awsResource(ec2Mod, "VpcIpamScope")},
			"aws_vpc_ipam_pool_cidr":                  {Tok: awsResource(ec2Mod, "VpcIpamPoolCidr")},
			"aws_vpc_ipam_pool_cidr_allocation":       {Tok: awsResource(ec2Mod, "VpcIpamPoolCidrAllocation")},
			"aws_vpc_ipv6_cidr_block_association":     {Tok: awsResource(ec2Mod, "VpcIpv6CidrBlockAssociation")},
			"aws_ec2_subnet_cidr_reservation":         {Tok: awsResource(ec2Mod, "SubnetCidrReservation")},
			"aws_vpc_endpoint_connection_accepter":    {Tok: awsResource(ec2Mod, "VpcEndpointConnectionAccepter")},
			"aws_vpc_ipam_organization_admin_account": {Tok: awsResource(ec2Mod, "VpcIpamOrganizationAdminAccount")},
			"aws_vpc_ipam_preview_next_cidr":          {Tok: awsResource(ec2Mod, "VpcIpamPreviewNextCidr")},
			"aws_ec2_network_insights_path":           {Tok: awsResource(ec2Mod, "NetworkInsightsPath")},
			"aws_ec2_serial_console_access":           {Tok: awsResource(ec2Mod, "SerialConsoleAccess")},
			"aws_ec2_network_insights_analysis":       {Tok: awsResource(ec2Mod, "NetworkInsightsAnalysis")},

			"aws_vpc_ipam_resource_discovery":             {Tok: awsResource(ec2Mod, "VpcIpamResourceDiscovery")},
			"aws_vpc_ipam_resource_discovery_association": {Tok: awsResource(ec2Mod, "VpcIpamResourceDiscoveryAssociation")},

			// EC2 Client VPN
			"aws_ec2_client_vpn_endpoint":            {Tok: awsResource(ec2ClientVpnMod, "Endpoint")},
			"aws_ec2_client_vpn_network_association": {Tok: awsResource(ec2ClientVpnMod, "NetworkAssociation")},
			"aws_ec2_client_vpn_authorization_rule":  {Tok: awsResource(ec2ClientVpnMod, "AuthorizationRule")},
			"aws_ec2_client_vpn_route":               {Tok: awsResource(ec2ClientVpnMod, "Route")},
			// EC2 Transit Gateway
			"aws_ec2_transit_gateway": {
				Tok: awsResource(ec2TransitGatewayMod, "TransitGateway"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"arn": {Type: awsTypeDefaultFile(awsMod, "ARN")},
				},
			},
			"aws_ec2_transit_gateway_route": {
				Tok: awsResource(ec2TransitGatewayMod, "Route"),
			},
			"aws_ec2_transit_gateway_route_table":           {Tok: awsResource(ec2TransitGatewayMod, "RouteTable")},
			"aws_ec2_transit_gateway_prefix_list_reference": {Tok: awsResource(ec2TransitGatewayMod, "PrefixListReference")},
			"aws_ec2_transit_gateway_route_table_association": {
				Tok: awsResource(ec2TransitGatewayMod, "RouteTableAssociation"),
			},
			"aws_ec2_transit_gateway_route_table_propagation": {
				Tok: awsResource(ec2TransitGatewayMod, "RouteTablePropagation"),
			},
			"aws_ec2_transit_gateway_vpc_attachment": {
				Tok:                 awsResource(ec2TransitGatewayMod, "VpcAttachment"),
				DeleteBeforeReplace: true,
			},
			"aws_ec2_transit_gateway_vpc_attachment_accepter":      {Tok: awsResource(ec2TransitGatewayMod, "VpcAttachmentAccepter")},
			"aws_ec2_transit_gateway_peering_attachment":           {Tok: awsResource(ec2TransitGatewayMod, "PeeringAttachment")},
			"aws_ec2_transit_gateway_connect":                      {Tok: awsResource(ec2TransitGatewayMod, "Connect")},
			"aws_ec2_transit_gateway_connect_peer":                 {Tok: awsResource(ec2TransitGatewayMod, "ConnectPeer")},
			"aws_ec2_transit_gateway_multicast_domain":             {Tok: awsResource(ec2TransitGatewayMod, "MulticastDomain")},
			"aws_ec2_transit_gateway_multicast_domain_association": {Tok: awsResource(ec2TransitGatewayMod, "MulticastDomainAssociation")},
			"aws_ec2_transit_gateway_multicast_group_member":       {Tok: awsResource(ec2TransitGatewayMod, "MulticastGroupMember")},
			"aws_ec2_transit_gateway_multicast_group_source":       {Tok: awsResource(ec2TransitGatewayMod, "MulticastGroupSource")},
			"aws_ec2_transit_gateway_policy_table":                 {Tok: awsResource(ec2TransitGatewayMod, "PolicyTable")},
			"aws_ec2_transit_gateway_policy_table_association":     {Tok: awsResource(ec2TransitGatewayMod, "PolicyTableAssociation")},
			"aws_ec2_instance_state":                               {Tok: awsResource(ec2TransitGatewayMod, "InstanceState")},
			"aws_ec2_instance_connect_endpoint":                    {Tok: awsResource(ec2TransitGatewayMod, "InstanceConnectEndpoint")},
			// Elastic Container Registry
			"aws_ecr_repository": {Tok: awsResource(ecrMod, "Repository")},
			"aws_ecr_repository_policy": {
				Tok: awsResource(ecrMod, "RepositoryPolicy"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"policy": {
						Type:      "string",
						AltTypes:  []tokens.Type{awsType(iamMod, "documents", "PolicyDocument")},
						Transform: tfbridge.TransformJSONDocument,
					},
				},
			},
			"aws_ecr_lifecycle_policy": {
				Tok:                 awsResource(ecrMod, "LifecyclePolicy"),
				DeleteBeforeReplace: true,
				Fields: map[string]*tfbridge.SchemaInfo{
					"policy": {
						Type:      "string",
						AltTypes:  []tokens.Type{awsTypeDefaultFile(ecrMod, "LifecyclePolicyDocument")},
						Transform: tfbridge.TransformJSONDocument,
					},
				},
			},
			"aws_ecr_registry_policy": {
				Tok: awsResource(ecrMod, "RegistryPolicy"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"policy": {
						Type:      "string",
						AltTypes:  []tokens.Type{awsType(iamMod, "documents", "PolicyDocument")},
						Transform: tfbridge.TransformJSONDocument,
					},
				},
			},
			"aws_ecr_replication_configuration": {
				Tok: awsResource(ecrMod, "ReplicationConfiguration"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"replication_configuration": {
						CSharpName: "ReplicationConfigurationDetails",
					},
				},
			},
			"aws_ecr_pull_through_cache_rule": {Tok: awsResource(ecrMod, "PullThroughCacheRule")},
			"aws_ecr_registry_scanning_configuration": {
				Tok: awsResource(ecrMod, "RegistryScanningConfiguration"),
			},
			// ecr public
			"aws_ecrpublic_repository":        {Tok: awsResource(ecrPublicMod, "Repository")},
			"aws_ecrpublic_repository_policy": {Tok: awsResource(ecrPublicMod, "RepositoryPolicy")},
			// Elastic Container Service
			"aws_ecs_cluster": {Tok: awsResource(ecsMod, "Cluster")},
			"aws_ecs_service": {
				Tok: awsResource(ecsMod, "Service"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"load_balancer": {
						// Even though only one is currently supported, the AWS API is designed to support multiple, so
						// force this to project as an array (and assign a plural name).
						Name:        "loadBalancers",
						MaxItemsOne: ref(false),
					},
					"service_connect_configuration": {
						Elem: &tfbridge.SchemaInfo{
							Fields: map[string]*tfbridge.SchemaInfo{
								"service": {
									Elem: &tfbridge.SchemaInfo{
										Fields: map[string]*tfbridge.SchemaInfo{
											"client_alias": {
												Name:        "clientAlias",
												MaxItemsOne: tfbridge.False(),
											},
										},
									},
								},
							},
						},
					},
				},
			},
			"aws_ecs_task_definition":            {Tok: awsResource(ecsMod, "TaskDefinition")},
			"aws_ecs_capacity_provider":          {Tok: awsResource(ecsMod, "CapacityProvider")},
			"aws_ecs_tag":                        {Tok: awsResource(ecsMod, "Tag")},
			"aws_ecs_account_setting_default":    {Tok: awsResource(ecsMod, "AccountSettingDefault")},
			"aws_ecs_task_set":                   {Tok: awsResource(ecsMod, "TaskSet")},
			"aws_ecs_cluster_capacity_providers": {Tok: awsResource(ecsMod, "ClusterCapacityProviders")},
			// Elastic File System
			"aws_efs_file_system": {
				Tok: awsResource(efsMod, "FileSystem"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"creation_token": tfbridge.AutoName("creationToken", 255, "-"),
				},
			},
			"aws_efs_mount_target": {
				Tok:                 awsResource(efsMod, "MountTarget"),
				DeleteBeforeReplace: true, // only 1 mount target per AZ.
			},
			"aws_efs_access_point":              {Tok: awsResource(efsMod, "AccessPoint")},
			"aws_efs_file_system_policy":        {Tok: awsResource(efsMod, "FileSystemPolicy")},
			"aws_efs_replication_configuration": {Tok: awsResource(efsMod, "ReplicationConfiguration")},
			"aws_efs_backup_policy": {
				Tok: awsResource(efsMod, "BackupPolicy"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"backup_policy": {
						CSharpName: "BackupPolicyDetails",
					},
				},
			},
			// ECS for Kubernetes
			"aws_eks_node_group": {
				Tok: awsResource(eksMod, "NodeGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"node_group_name": tfbridge.AutoName("nodeGroupName", 255, "-"),
				},
			},
			"aws_eks_fargate_profile": {
				Tok: awsResource(eksMod, "FargateProfile"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"fargate_profile_name": tfbridge.AutoName("fargateProfileName", 255, "-"),
				},
			},
			"aws_eks_addon":                    {Tok: awsResource(eksMod, "Addon")},
			"aws_eks_identity_provider_config": {Tok: awsResource(eksMod, "IdentityProviderConfig")},
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
					"access_policies": {
						Type:      "string",
						AltTypes:  []tokens.Type{awsType(iamMod, "documents", "PolicyDocument")},
						Transform: tfbridge.TransformJSONDocument,
					},
				},
			},
			"aws_elasticsearch_domain_policy": {
				Tok: awsResource(elasticsearchMod, "DomainPolicy"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"access_policies": {
						Type:      "string",
						AltTypes:  []tokens.Type{awsType(iamMod, "documents", "PolicyDocument")},
						Transform: tfbridge.TransformJSONDocument,
					},
				},
			},
			"aws_elasticsearch_domain_saml_options": {Tok: awsResource(elasticsearchMod, "DomainSamlOptions")},
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
			"aws_emr_block_public_access_configuration": {Tok: awsResource(emrMod, "BlockPublicAccessConfiguration")},
			"aws_emr_cluster": {
				Tok: awsResource(emrMod, "Cluster"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"cluster_state": {
						CSharpName: "State",
					},
				},
			},
			"aws_emr_instance_group":         {Tok: awsResource(emrMod, "InstanceGroup")},
			"aws_emr_security_configuration": {Tok: awsResource(emrMod, "SecurityConfiguration")},
			"aws_emr_managed_scaling_policy": {Tok: awsResource(emrMod, "ManagedScalingPolicy")},
			"aws_emr_instance_fleet":         {Tok: awsResource(emrMod, "InstanceFleet")},
			"aws_emr_studio":                 {Tok: awsResource(emrMod, "Studio")},
			"aws_emr_studio_session_mapping": {Tok: awsResource(emrMod, "StudioSessionMapping")},

			// EMR Containers
			"aws_emrcontainers_virtual_cluster": {Tok: awsResource(emrContainersMod, "VirtualCluster")},

			// EMR Serverless
			"aws_emrserverless_application": {Tok: awsResource(emrServerlessMod, "Application")},

			// Cloudwatch Evidently
			"aws_evidently_project": {Tok: awsResource(evidentlyMod, "Project")},
			"aws_evidently_segment": {Tok: awsResource(evidentlyMod, "Segment")},
			"aws_evidently_feature": {Tok: awsResource(evidentlyMod, "Feature")},
			"aws_evidently_launch":  {Tok: awsResource(evidentlyMod, "Launch")},

			// FSX
			"aws_fsx_backup":                        {Tok: awsResource(fsxMod, "Backup")},
			"aws_fsx_data_repository_association":   {Tok: awsResource(fsxMod, "DataRepositoryAssociation")},
			"aws_fsx_file_cache":                    {Tok: awsResource(fsxMod, "FileCache")},
			"aws_fsx_lustre_file_system":            {Tok: awsResource(fsxMod, "LustreFileSystem")},
			"aws_fsx_ontap_file_system":             {Tok: awsResource(fsxMod, "OntapFileSystem")},
			"aws_fsx_ontap_storage_virtual_machine": {Tok: awsResource(fsxMod, "OntapStorageVirtualMachine")},
			"aws_fsx_ontap_volume":                  {Tok: awsResource(fsxMod, "OntapVolume")},
			"aws_fsx_openzfs_file_system":           {Tok: awsResource(fsxMod, "OpenZfsFileSystem")},
			"aws_fsx_openzfs_snapshot":              {Tok: awsResource(fsxMod, "OpenZfsSnapshot")},
			"aws_fsx_openzfs_volume":                {Tok: awsResource(fsxMod, "OpenZfsVolume")},
			"aws_fsx_windows_file_system":           {Tok: awsResource(fsxMod, "WindowsFileSystem")},

			// GameLift

			"aws_gamelift_alias":                     {Tok: awsResource(gameliftMod, "Alias")},
			"aws_gamelift_build":                     {Tok: awsResource(gameliftMod, "Build")},
			"aws_gamelift_fleet":                     {Tok: awsResource(gameliftMod, "Fleet")},
			"aws_gamelift_game_session_queue":        {Tok: awsResource(gameliftMod, "GameSessionQueue")},
			"aws_gamelift_game_server_group":         {Tok: awsResource(gameliftMod, "GameServerGroup")},
			"aws_gamelift_script":                    {Tok: awsResource(gameliftMod, "Script")},
			"aws_gamelift_matchmaking_configuration": {Tok: awsResource(gameliftMod, "MatchmakingConfiguration")},
			"aws_gamelift_matchmaking_rule_set":      {Tok: awsResource(gameliftMod, "MatchmakingRuleSet")},

			// Glacier
			"aws_glacier_vault":      {Tok: awsResource(glacierMod, "Vault")},
			"aws_glacier_vault_lock": {Tok: awsResource(glacierMod, "VaultLock")},
			// Global Accelerator
			"aws_globalaccelerator_accelerator":    {Tok: awsResource(globalacceleratorMod, "Accelerator")},
			"aws_globalaccelerator_endpoint_group": {Tok: awsResource(globalacceleratorMod, "EndpointGroup")},
			"aws_globalaccelerator_listener":       {Tok: awsResource(globalacceleratorMod, "Listener")},
			// Glue
			"aws_glue_catalog_database": {
				Tok: awsResource(glueMod, "CatalogDatabase"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"name": {
						Default: &tfbridge.DefaultInfo{
							// This means the name will adhere to ^[a-z]+(_[a-z]+)*$  as per
							// https://docs.aws.amazon.com/athena/latest/ug/tables-databases-columns-names.html
							From: tfbridge.FromName(tfbridge.AutoNameOptions{
								Separator: "_",
								Charset:   []rune("abcdefghijklmnopqrstuvwxyz"),
								Randlen:   8,
								Transform: func(name string) string {
									return strings.ToLower(name)
								},
							}),
						},
					},
				},
			},
			"aws_glue_catalog_table": {
				Tok: awsResource(glueMod, "CatalogTable"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"name": {
						Default: &tfbridge.DefaultInfo{
							// This means the name will adhere to ^[a-z]+(_[a-z]+)*$  as per
							// https://docs.aws.amazon.com/athena/latest/ug/tables-databases-columns-names.html
							From: tfbridge.FromName(tfbridge.AutoNameOptions{
								Separator: "_",
								Charset:   []rune("abcdefghijklmnopqrstuvwxyz"),
								Randlen:   8,
								Transform: func(name string) string {
									return strings.ToLower(name)
								},
							}),
						},
					},
				},
			},
			"aws_glue_classifier":             {Tok: awsResource(glueMod, "Classifier")},
			"aws_glue_connection":             {Tok: awsResource(glueMod, "Connection")},
			"aws_glue_crawler":                {Tok: awsResource(glueMod, "Crawler")},
			"aws_glue_job":                    {Tok: awsResource(glueMod, "Job")},
			"aws_glue_security_configuration": {Tok: awsResource(glueMod, "SecurityConfiguration")},
			"aws_glue_trigger":                {Tok: awsResource(glueMod, "Trigger")},
			"aws_glue_workflow":               {Tok: awsResource(glueMod, "Workflow")},
			"aws_glue_user_defined_function":  {Tok: awsResource(glueMod, "UserDefinedFunction")},
			"aws_glue_data_catalog_encryption_settings": {
				Tok: awsResource(glueMod, "DataCatalogEncryptionSettings"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"data_catalog_encryption_settings": {
						CSharpName: "DataCatalogEncryptionSettingsConfig",
					},
				},
			},
			"aws_glue_ml_transform":    {Tok: awsResource(glueMod, "MLTransform")},
			"aws_glue_partition":       {Tok: awsResource(glueMod, "Partition")},
			"aws_glue_resource_policy": {Tok: awsResource(glueMod, "ResourcePolicy")},
			"aws_glue_dev_endpoint":    {Tok: awsResource(glueMod, "DevEndpoint")},
			"aws_glue_registry":        {Tok: awsResource(glueMod, "Registry")},
			"aws_glue_schema":          {Tok: awsResource(glueMod, "Schema")},
			"aws_glue_partition_index": {
				Tok: awsResource(glueMod, "PartitionIndex"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"partition_index": {
						CSharpName: "PartitionIndexConfig",
					},
				},
			},
			// Grafana
			"aws_grafana_license_association":          {Tok: awsResource(grafanaMod, "LicenseAssociation")},
			"aws_grafana_workspace":                    {Tok: awsResource(grafanaMod, "Workspace")},
			"aws_grafana_workspace_saml_configuration": {Tok: awsResource(grafanaMod, "WorkspaceSamlConfiguration")},
			"aws_grafana_role_association":             {Tok: awsResource(grafanaMod, "RoleAssociation")},
			"aws_grafana_workspace_api_key":            {Tok: awsResource(grafanaMod, "WorkspaceApiKey")},
			// GuardDuty
			"aws_guardduty_detector":                   {Tok: awsResource(guarddutyMod, "Detector")},
			"aws_guardduty_invite_accepter":            {Tok: awsResource(guarddutyMod, "InviteAccepter")},
			"aws_guardduty_ipset":                      {Tok: awsResource(guarddutyMod, "IPSet")},
			"aws_guardduty_member":                     {Tok: awsResource(guarddutyMod, "Member")},
			"aws_guardduty_threatintelset":             {Tok: awsResource(guarddutyMod, "ThreatIntelSet")},
			"aws_guardduty_organization_admin_account": {Tok: awsResource(guarddutyMod, "OrganizationAdminAccount")},
			"aws_guardduty_organization_configuration": {Tok: awsResource(guarddutyMod, "OrganizationConfiguration")},
			"aws_guardduty_publishing_destination":     {Tok: awsResource(guarddutyMod, "PublishingDestination")},
			"aws_guardduty_filter":                     {Tok: awsResource(guarddutyMod, "Filter")},
			// Identity and Access Management (IAM)
			"aws_iam_access_key": {Tok: awsResource(iamMod, "AccessKey")},
			"aws_iam_account_alias": {
				Tok: awsResource(iamMod, "AccountAlias"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"account_alias": {
						CSharpName: "Alias",
					},
				},
				DeleteBeforeReplace: true,
			},
			"aws_iam_account_password_policy": {Tok: awsResource(iamMod, "AccountPasswordPolicy")},
			"aws_iam_group_policy": {
				Tok: awsResource(iamMod, "GroupPolicy"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"policy": {
						Type:      "string",
						AltTypes:  []tokens.Type{awsType(iamMod, "documents", "PolicyDocument")},
						Transform: tfbridge.TransformJSONDocument,
					},
				},
			},
			"aws_iam_group":            {Tok: awsResource(iamMod, "Group")},
			"aws_iam_group_membership": {Tok: awsResource(iamMod, "GroupMembership")},
			"aws_iam_group_policy_attachment": {
				Tok: awsResource(iamMod, "GroupPolicyAttachment"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"group": {
						Type:     "string",
						AltTypes: []tokens.Type{awsTypeDefaultFile(iamMod, "Group")},
					},
					"policy_arn": {
						Name: "policyArn",
						Type: awsTypeDefaultFile(awsMod, "ARN"),
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
						AltTypes: []tokens.Type{awsTypeDefaultFile(iamMod, "Role")},
					},
				},
			},
			"aws_iam_openid_connect_provider": {Tok: awsResource(iamMod, "OpenIdConnectProvider")},
			"aws_iam_policy": {
				Tok: awsResource(iamMod, "Policy"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"policy": {
						Type:       "string",
						AltTypes:   []tokens.Type{awsType(iamMod, "documents", "PolicyDocument")},
						Transform:  tfbridge.TransformJSONDocument,
						CSharpName: "PolicyDocument",
					},
				},
			},
			"aws_iam_policy_attachment": {
				Tok: awsResource(iamMod, "PolicyAttachment"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"users": {
						Elem: &tfbridge.SchemaInfo{
							Type:     "string",
							AltTypes: []tokens.Type{awsTypeDefaultFile(iamMod, "User")},
						},
					},
					"roles": {
						Elem: &tfbridge.SchemaInfo{
							Type:     "string",
							AltTypes: []tokens.Type{awsTypeDefaultFile(iamMod, "Role")},
						},
					},
					"groups": {
						Elem: &tfbridge.SchemaInfo{
							Type:     "string",
							AltTypes: []tokens.Type{awsTypeDefaultFile(iamMod, "Group")},
						},
					},
					"policy_arn": {
						Name: "policyArn",
						Type: awsTypeDefaultFile(awsMod, "ARN"),
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
						AltTypes: []tokens.Type{awsTypeDefaultFile(iamMod, "Role")},
					},
					"policy_arn": {
						Name: "policyArn",
						Type: awsTypeDefaultFile(awsMod, "ARN"),
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
						AltTypes: []tokens.Type{awsTypeDefaultFile(iamMod, "Role")},
					},
					"policy": {
						Type:      "string",
						AltTypes:  []tokens.Type{awsType(iamMod, "documents", "PolicyDocument")},
						Transform: tfbridge.TransformJSONDocument,
					},
				},
			},
			"aws_iam_role": {
				Tok: awsResource(iamMod, "Role"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"name": tfbridge.AutoName("name", 64, "-"),
					"assume_role_policy": {
						Type:      "string",
						AltTypes:  []tokens.Type{awsType(iamMod, "documents", "PolicyDocument")},
						Transform: tfbridge.TransformJSONDocument,
					},
					"inline_policy": {
						// inline_policy is an array of policy objects. The user is allowed to provided an empty list
						//   inlinePolicies: []
						// or a list with empty objects
						//   inlinePolicies: [{}]
						// In both cases the role will be created _without_ any inline policies attached.
						// If a policy is provided, then both the `policy` and the `name` fields are required.
						// If one is provided and the other is not, then no error will be thrown and no inline policy
						// will be created.
						Transform: func(pv resource.PropertyValue) (resource.PropertyValue, error) {
							if pv.IsArray() {
								inlinePolicy := []resource.PropertyValue{}
								for _, value := range pv.ArrayValue() {
									if value.IsObject() {
										policy := value.ObjectValue()
										if policy.HasValue("policy") && policy["policy"].IsString() && policy["policy"].StringValue() != "" {
											inlinePolicy = append(inlinePolicy, value)
										}
									}
								}
								return resource.NewArrayProperty(inlinePolicy), nil
							}
							return pv, nil
						},
						Elem: &tfbridge.SchemaInfo{
							Fields: map[string]*tfbridge.SchemaInfo{
								"name": tfbridge.AutoName("name", 128, "-"),
							},
						},
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
					"user": {
						Type:     "string",
						AltTypes: []tokens.Type{awsTypeDefaultFile(iamMod, "User")},
					},
					"policy_arn": {
						Name: "policyArn",
						Type: awsTypeDefaultFile(awsMod, "ARN"),
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
						AltTypes:  []tokens.Type{awsType(iamMod, "documents", "PolicyDocument")},
						Transform: tfbridge.TransformJSONDocument,
					},
				},
			},
			"aws_iam_user_ssh_key":                {Tok: awsResource(iamMod, "SshKey")},
			"aws_iam_user":                        {Tok: awsResource(iamMod, "User")},
			"aws_iam_user_login_profile":          {Tok: awsResource(iamMod, "UserLoginProfile")},
			"aws_iam_service_specific_credential": {Tok: awsResource(iamMod, "ServiceSpecificCredential")},
			"aws_iam_signing_certificate":         {Tok: awsResource(iamMod, "SigningCertificate")},
			"aws_iam_virtual_mfa_device":          {Tok: awsResource(iamMod, "VirtualMfaDevice")},

			// Identity Store
			"aws_identitystore_group":            {Tok: awsResource(identityStoreMod, "Group")},
			"aws_identitystore_group_membership": {Tok: awsResource(identityStoreMod, "GroupMembership")},
			"aws_identitystore_user":             {Tok: awsResource(identityStoreMod, "User")},

			// Inspector
			"aws_inspector_assessment_target":   {Tok: awsResource(inspectorMod, "AssessmentTarget")},
			"aws_inspector_assessment_template": {Tok: awsResource(inspectorMod, "AssessmentTemplate")},
			"aws_inspector_resource_group":      {Tok: awsResource(inspectorMod, "ResourceGroup")},

			// Inspector V2
			"aws_inspector2_delegated_admin_account":    {Tok: awsResource(inspector2Mod, "DelegatedAdminAccount")},
			"aws_inspector2_enabler":                    {Tok: awsResource(inspector2Mod, "Enabler")},
			"aws_inspector2_member_association":         {Tok: awsResource(inspector2Mod, "MemberAssociation")},
			"aws_inspector2_organization_configuration": {Tok: awsResource(inspector2Mod, "OrganizationConfiguration")},

			// IOT
			"aws_iot_certificate": {Tok: awsResource(iotMod, "Certificate")},
			"aws_iot_event_configurations": {
				Fields: map[string]*tfbridge.SchemaInfo{
					"event_configurations": {
						CSharpName: "Configurations",
					},
				},
			},
			"aws_iot_policy": {
				Tok:      awsResource(iotMod, "Policy"),
				IDFields: []string{"name"},
				Fields: map[string]*tfbridge.SchemaInfo{
					"policy": {
						CSharpName: "PolicyDocument",
					},
				},
			},
			"aws_iot_policy_attachment": {
				Tok: awsResource(iotMod, "PolicyAttachment"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"policy": {
						Type:     "string",
						AltTypes: []tokens.Type{awsTypeDefaultFile(iotMod, "Policy")},
					},
					"target": {
						Type: awsTypeDefaultFile(awsMod, "ARN"),
					},
				},
			},
			"aws_iot_role_alias": {Tok: awsResource(iotMod, "RoleAlias")},
			"aws_iot_thing":      {Tok: awsResource(iotMod, "Thing")},
			"aws_iot_thing_principal_attachment": {
				Tok: awsResource(iotMod, "ThingPrincipalAttachment"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"principal": {
						Type: awsTypeDefaultFile(awsMod, "ARN"),
					},
				},
			},
			"aws_iot_thing_type": {Tok: awsResource(iotMod, "ThingType")},
			"aws_iot_authorizer": {Tok: awsResource(iotMod, "Authorizer")},
			"aws_iot_topic_rule": {
				Tok: awsResource(iotMod, "TopicRule"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"name": tfbridge.AutoNameWithCustomOptions("name",
						tfbridge.AutoNameOptions{
							Separator: "_",
						}),
					"kinesis": {Elem: &tfbridge.SchemaInfo{
						NestedType: "TopicRuleKinesis",
					}},
					"s3": {
						// Fix pluralization: `s3s` is confusing, so we hardcode `s3`.
						Name: "s3",
						// To minimize the diff, we instruct the nested type to revert
						// to it's prior name.
						Elem: &tfbridge.SchemaInfo{NestedType: "TopicRuleS3"},
					},
					"sns": {
						// Singularization converts `sns` to `sn`, which is wrong.
						Elem: &tfbridge.SchemaInfo{NestedType: "TopicRuleSns"},
					},
					"sqs": {
						// Singularization converts `sqs` to `sq`, which is wrong.
						Elem: &tfbridge.SchemaInfo{NestedType: "TopicRuleSqs"},
					},
					"elasticsearch": {
						// The service is called "ElasticSearch", so pluralizing it to
						// "elasticsearches" doesn't really make sense.
						Name: "elasticsearch",
					},
				},
			},
			"aws_iot_thing_group":            {Tok: awsResource(iotMod, "ThingGroup")},
			"aws_iot_thing_group_membership": {Tok: awsResource(iotMod, "ThingGroupMembership")},
			"aws_iot_indexing_configuration": {Tok: awsResource(iotMod, "IndexingConfiguration")},
			"aws_iot_logging_options":        {Tok: awsResource(iotMod, "LoggingOptions")},
			"aws_iot_provisioning_template":  {Tok: awsResource(iotMod, "ProvisioningTemplate")},
			"aws_iot_topic_rule_destination": {Tok: awsResource(iotMod, "TopicRuleDestination")},

			// IVS
			"aws_ivs_playback_key_pair":       {Tok: awsResource(ivsMod, "PlaybackKeyPair")},
			"aws_ivs_recording_configuration": {Tok: awsResource(ivsMod, "RecordingConfiguration")},
			"aws_ivs_channel":                 {Tok: awsResource(ivsMod, "Channel")},

			// IVS Chat
			"aws_ivschat_logging_configuration": {Tok: awsResource(ivsChatMod, "LoggingConfiguration")},
			"aws_ivschat_room":                  {Tok: awsResource(ivsChatMod, "Room")},

			// Kendra
			"aws_kendra_index":                        {Tok: awsResource(kendraMod, "Index")},
			"aws_kendra_experience":                   {Tok: awsResource(kendraMod, "Experience")},
			"aws_kendra_faq":                          {Tok: awsResource(kendraMod, "Faq")},
			"aws_kendra_query_suggestions_block_list": {Tok: awsResource(kendraMod, "QuerySuggestionsBlockList")},
			"aws_kendra_thesaurus":                    {Tok: awsResource(kendraMod, "Thesaurus")},
			"aws_kendra_data_source":                  {Tok: awsResource(kendraMod, "DataSource")},

			// Keyspaces
			"aws_keyspaces_keyspace": {Tok: awsResource(keyspacesMod, "Keyspace")},
			"aws_keyspaces_table":    {Tok: awsResource(keyspacesMod, "Table")},
			// Kinesis
			"aws_kinesis_firehose_delivery_stream": {Tok: awsResource(kinesisMod, "FirehoseDeliveryStream")},
			"aws_kinesis_stream":                   {Tok: awsResource(kinesisMod, "Stream")},
			"aws_kinesis_stream_consumer":          {Tok: awsResource(kinesisMod, "StreamConsumer")},
			"aws_kinesis_video_stream":             {Tok: awsResource(kinesisMod, "VideoStream")},
			"aws_kinesis_analytics_application": {
				Tok: awsResource(kinesisMod, "AnalyticsApplication"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"arn": {
						Type: awsTypeDefaultFile(awsMod, "ARN"),
					},
				},
			},
			// Kinesis Data Analytics V2
			"aws_kinesisanalyticsv2_application":          {Tok: awsResource(kinesisAnalyticsMod, "Application")},
			"aws_kinesisanalyticsv2_application_snapshot": {Tok: awsResource(kinesisAnalyticsMod, "ApplicationSnapshot")},
			// Key Management Service (KMS)
			"aws_kms_alias": {
				Tok: awsResource(kmsMod, "Alias"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"name": tfbridge.AutoNameWithCustomOptions("name", tfbridge.AutoNameOptions{
						Separator: "-",
						Maxlen:    238,
						Randlen:   7,
						// KMS Key alias names must be prefixed with "alias/" - see format documentation at
						// https://docs.aws.amazon.com/kms/latest/APIReference/API_CreateAlias.html
						PostTransform: func(res *tfbridge.PulumiResource, name string) (string, error) {
							if strings.HasPrefix(name, "alias/") {
								return name, nil
							}

							return fmt.Sprintf("alias/%s", name), nil
						},
					}),
				},
			},
			"aws_kms_ciphertext":           {Tok: awsResource(kmsMod, "Ciphertext")},
			"aws_kms_custom_key_store":     {Tok: awsResource(kmsMod, "CustomKeyStore")},
			"aws_kms_external_key":         {Tok: awsResource(kmsMod, "ExternalKey")},
			"aws_kms_grant":                {Tok: awsResource(kmsMod, "Grant")},
			"aws_kms_key":                  {Tok: awsResource(kmsMod, "Key")},
			"aws_kms_key_policy":           {Tok: awsResource(kmsMod, "KeyPolicy")},
			"aws_kms_replica_external_key": {Tok: awsResource(kmsMod, "ReplicaExternalKey")},
			"aws_kms_replica_key":          {Tok: awsResource(kmsMod, "ReplicaKey")},
			// Lambda
			"aws_lambda_function": {
				Tok:      awsResource(lambdaMod, "Function"),
				IDFields: []string{"function_name"},
				Fields: map[string]*tfbridge.SchemaInfo{
					"function_name": tfbridge.AutoName("name", 64, "-"),
					"role":          {Type: awsTypeDefaultFile(awsMod, "ARN")},
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
					"runtime": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(lambdaMod, "Runtime", "Runtime")},
					},
					"architectures": {
						MaxItemsOne: tfbridge.False(),
						Name:        "architectures",
					},
				},
			},
			"aws_lambda_function_url": {
				Tok: awsResource(lambdaMod, "FunctionUrl"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"function_url": {
						CSharpName: "FunctionUrlResult",
					},
				},
			},
			"aws_lambda_alias":                {Tok: awsResource(lambdaMod, "Alias")},
			"aws_lambda_event_source_mapping": {Tok: awsResource(lambdaMod, "EventSourceMapping")},
			"aws_lambda_layer_version": {
				Tok: awsResource(lambdaMod, "LayerVersion"),
				Fields: map[string]*tfbridge.SchemaInfo{
					// We will hijack the filename property. A Pulumi archive is passed in its stead and we will turn
					// around and emit the archive as a temp file that Terraform can read. We also automatically
					// populate the asset hash property as this is used in diffs/updates/etc.
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
			"aws_lambda_permission": {
				Tok:      awsResource(lambdaMod, "Permission"),
				IDFields: []string{"statement_id"},
				Fields: map[string]*tfbridge.SchemaInfo{
					"function_name": {
						Name:     "function",
						Type:     "string",
						AltTypes: []tokens.Type{awsTypeDefaultFile(lambdaMod, "Function")},
					},
					"statement_id": tfbridge.AutoName("statementId", 100, "-"),
				},
			},
			"aws_lambda_provisioned_concurrency_config": {Tok: awsResource(lambdaMod, "ProvisionedConcurrencyConfig")},
			"aws_lambda_function_event_invoke_config":   {Tok: awsResource(lambdaMod, "FunctionEventInvokeConfig")},
			"aws_lambda_code_signing_config":            {Tok: awsResource(lambdaMod, "CodeSigningConfig")},
			"aws_lambda_layer_version_permission":       {Tok: awsResource(lambdaMod, "LayerVersionPermission")},
			"aws_lambda_invocation":                     {Tok: awsResource(lambdaMod, "Invocation")},

			// License Manager
			"aws_licensemanager_association":           {Tok: awsResource(licensemanagerMod, "Association")},
			"aws_licensemanager_license_configuration": {Tok: awsResource(licensemanagerMod, "LicenseConfiguration")},
			"aws_licensemanager_grant":                 {Tok: awsResource(licensemanagerMod, "LicenseGrant")},
			"aws_licensemanager_grant_accepter":        {Tok: awsResource(licensemanagerMod, "LicenseGrantAccepter")},

			// LightSail
			"aws_lightsail_certificate":                          {Tok: awsResource(lightsailMod, "Certificate")},
			"aws_lightsail_container_service_deployment_version": {Tok: awsResource(lightsailMod, "ContainerServiceDeploymentVersion")},
			"aws_lightsail_container_service":                    {Tok: awsResource(lightsailMod, "ContainerService")},
			"aws_lightsail_database":                             {Tok: awsResource(lightsailMod, "Database")},
			"aws_lightsail_distribution":                         {Tok: awsResource(lightsailMod, "Distribution")},
			"aws_lightsail_disk_attachment":                      {Tok: awsResource(lightsailMod, "Disk_attachment")},
			"aws_lightsail_disk":                                 {Tok: awsResource(lightsailMod, "Disk")},
			"aws_lightsail_domain_entry":                         {Tok: awsResource(lightsailMod, "DomainEntry")},
			"aws_lightsail_domain":                               {Tok: awsResource(lightsailMod, "Domain")},
			"aws_lightsail_instance_public_ports":                {Tok: awsResource(lightsailMod, "InstancePublicPorts")},
			"aws_lightsail_instance":                             {Tok: awsResource(lightsailMod, "Instance")},
			"aws_lightsail_key_pair":                             {Tok: awsResource(lightsailMod, "KeyPair")},
			"aws_lightsail_lb_attachment":                        {Tok: awsResource(lightsailMod, "LbAttachment")},
			"aws_lightsail_lb_certificate_attachment":            {Tok: awsResource(lightsailMod, "LbCertificateAttachment")},
			"aws_lightsail_lb_certificate":                       {Tok: awsResource(lightsailMod, "LbCertificate")},
			"aws_lightsail_lb_https_redirection_policy":          {Tok: awsResource(lightsailMod, "LbHttpsRedirectionPolicy")},
			"aws_lightsail_lb_stickiness_policy":                 {Tok: awsResource(lightsailMod, "LbStickinessPolicy")},
			"aws_lightsail_lb":                                   {Tok: awsResource(lightsailMod, "Lb")},
			"aws_lightsail_static_ip_attachment":                 {Tok: awsResource(lightsailMod, "StaticIpAttachment")},
			"aws_lightsail_static_ip":                            {Tok: awsResource(lightsailMod, "StaticIp")},
			"aws_lightsail_bucket":                               {Tok: awsResource(lightsailMod, "Bucket")},
			"aws_lightsail_bucket_access_key":                    {Tok: awsResource(lightsailMod, "BucketAccessKey")},
			"aws_lightsail_bucket_resource_access":               {Tok: awsResource(lightsailMod, "BucketResourceAccess")},

			// Location
			"aws_location_map":                 {Tok: awsResource(locationMod, "Map")},
			"aws_location_place_index":         {Tok: awsResource(locationMod, "PlaceIndex")},
			"aws_location_route_calculator":    {Tok: awsResource(locationMod, "RouteCalculation")},
			"aws_location_tracker":             {Tok: awsResource(locationMod, "Tracker")},
			"aws_location_geofence_collection": {Tok: awsResource(locationMod, "GeofenceCollection")},
			"aws_location_tracker_association": {Tok: awsResource(locationMod, "TrackerAssociation")},

			// Macie
			"aws_macie2_custom_data_identifier": {Tok: awsResource(macieMod, "CustomDataIdentifier")},
			"aws_macie2_findings_filter":        {Tok: awsResource(macieMod, "FindingsFilter")},
			// Macie2
			"aws_macie2_account":                             {Tok: awsResource(macie2Mod, "Account")},
			"aws_macie2_classification_job":                  {Tok: awsResource(macie2Mod, "ClassificationJob")},
			"aws_macie2_invitation_accepter":                 {Tok: awsResource(macie2Mod, "InvitationAccepter")},
			"aws_macie2_member":                              {Tok: awsResource(macie2Mod, "Member")},
			"aws_macie2_organization_admin_account":          {Tok: awsResource(macie2Mod, "OrganizationAdminAccount")},
			"aws_macie2_classification_export_configuration": {Tok: awsResource(macie2Mod, "ClassificationExportConfiguration")},
			// Elemental MediaPackage
			"aws_media_package_channel": {
				Tok: awsResource(mediapackageMod, "Channel"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"description": {
						Default: managedByPulumi,
					},
				},
			},
			// MediaConvert
			"aws_media_convert_queue": {Tok: awsResource(mediaconvertMod, "Queue")},

			// MediaLive
			"aws_medialive_channel":              {Tok: awsResource(medialiveMod, "Channel")},
			"aws_medialive_input":                {Tok: awsResource(medialiveMod, "Input")},
			"aws_medialive_input_security_group": {Tok: awsResource(medialiveMod, "InputSecurityGroup")},
			"aws_medialive_multiplex":            {Tok: awsResource(medialiveMod, "Multiplex")},

			// Elemental MediaStore
			"aws_media_store_container":        {Tok: awsResource(mediastoreMod, "Container")},
			"aws_media_store_container_policy": {Tok: awsResource(mediastoreMod, "ContainerPolicy")},

			// MemoryDB
			"aws_memorydb_cluster":         {Tok: awsResource(memoryDbMod, "Cluster")},
			"aws_memorydb_parameter_group": {Tok: awsResource(memoryDbMod, "ParameterGroup")},
			"aws_memorydb_subnet_group":    {Tok: awsResource(memoryDbMod, "SubnetGroup")},
			"aws_memorydb_user":            {Tok: awsResource(memoryDbMod, "User")},
			"aws_memorydb_acl":             {Tok: awsResource(memoryDbMod, "Acl")},
			"aws_memorydb_snapshot":        {Tok: awsResource(memoryDbMod, "Snapshot")},

			// MQ
			"aws_mq_broker": {
				Tok: awsResource(mqMod, "Broker"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"logs": {
						Elem: &tfbridge.SchemaInfo{
							Fields: map[string]*tfbridge.SchemaInfo{
								"audit": {
									Type: "boolean",
								},
							},
						},
					},
					// 1-50 characters long, must contain only letters, numbers, dashes, and underscores, and must not
					// contain white spaces, brackets, wildcard characters, or special characters.
					// https://awscli.amazonaws.com/v2/documentation/api/latest/reference/mq/create-broker.html#options
					"broker_name": tfbridge.AutoName("brokerName", 55, "-"),
				},
			},
			"aws_mq_configuration": {Tok: awsResource(mqMod, "Configuration")},

			// Neptune
			"aws_neptune_cluster":                 {Tok: awsResource(neptuneMod, "Cluster")},
			"aws_neptune_cluster_instance":        {Tok: awsResource(neptuneMod, "ClusterInstance")},
			"aws_neptune_cluster_parameter_group": {Tok: awsResource(neptuneMod, "ClusterParameterGroup")},
			"aws_neptune_cluster_snapshot":        {Tok: awsResource(neptuneMod, "ClusterSnapshot")},
			"aws_neptune_global_cluster":          {Tok: awsResource(neptuneMod, "GlobalCluster")},
			"aws_neptune_event_subscription":      {Tok: awsResource(neptuneMod, "EventSubscription")},
			"aws_neptune_parameter_group":         {Tok: awsResource(neptuneMod, "ParameterGroup")},
			"aws_neptune_cluster_endpoint":        {Tok: awsResource(neptuneMod, "ClusterEndpoint")},
			"aws_neptune_subnet_group": {
				Tok: awsResource(neptuneMod, "SubnetGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"description": {
						Default: managedByPulumi,
					},
				},
			},
			// Network manager
			"aws_networkmanager_connection":                               {Tok: awsResource(networkManagerMod, "Connection")},
			"aws_networkmanager_core_network":                             {Tok: awsResource(networkManagerMod, "CoreNetwork")},
			"aws_networkmanager_customer_gateway_association":             {Tok: awsResource(networkManagerMod, "CustomerGatewayAssociation")},
			"aws_networkmanager_device":                                   {Tok: awsResource(networkManagerMod, "Device")},
			"aws_networkmanager_global_network":                           {Tok: awsResource(networkManagerMod, "GlobalNetwork")},
			"aws_networkmanager_link":                                     {Tok: awsResource(networkManagerMod, "Link")},
			"aws_networkmanager_link_association":                         {Tok: awsResource(networkManagerMod, "LinkAssociation")},
			"aws_networkmanager_site_to_site_vpn_attachment":              {Tok: awsResource(networkManagerMod, "SiteToSiteVpnAttachment")},
			"aws_networkmanager_site":                                     {Tok: awsResource(networkManagerMod, "Site")},
			"aws_networkmanager_transit_gateway_connect_peer_association": {Tok: awsResource(networkManagerMod, "TransitGatewayConnectPeerAssociation")},
			"aws_networkmanager_transit_gateway_registration":             {Tok: awsResource(networkManagerMod, "TransitGatewayRegistration")},
			"aws_networkmanager_attachment_accepter":                      {Tok: awsResource(networkManagerMod, "AttachmentAccepter")},
			"aws_networkmanager_vpc_attachment":                           {Tok: awsResource(networkManagerMod, "VpcAttachment")},
			"aws_networkmanager_transit_gateway_peering":                  {Tok: awsResource(networkManagerMod, "TransitGatewayPeering")},
			"aws_networkmanager_transit_gateway_route_table_attachment":   {Tok: awsResource(networkManagerMod, "TransitGatewayRouteTableAttachment")},
			"aws_networkmanager_connect_attachment":                       {Tok: awsResource(networkManagerMod, "ConnectAttachment")},
			"aws_networkmanager_connect_peer":                             {Tok: awsResource(networkManagerMod, "ConnectPeer")},
			"aws_networkmanager_core_network_policy_attachment":           {Tok: awsResource(networkManagerMod, "CoreNetworkPolicyAttachment")},

			// OpenSearch
			"aws_opensearch_domain": {
				Tok: awsResource(opensearchMod, "Domain"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"domain_name": tfbridge.AutoName("domainName", 255, "-"),
				},
			},
			"aws_opensearch_domain_policy":               {Tok: awsResource(opensearchMod, "DomainPolicy")},
			"aws_opensearch_domain_saml_options":         {Tok: awsResource(opensearchMod, "DomainSamlOptions")},
			"aws_opensearch_inbound_connection_accepter": {Tok: awsResource(opensearchMod, "InboundConnectionAccepter")},
			"aws_opensearch_outbound_connection":         {Tok: awsResource(opensearchMod, "OutboundConnection")},

			// OpsWorks
			"aws_opsworks_application": {Tok: awsResource(opsworksMod, "Application")},
			"aws_opsworks_stack": {
				Tok: awsResource(opsworksMod, "Stack"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"custom_cookbooks_source": {
						MaxItemsOne: tfbridge.False(),
						Name:        "customCookbooksSources",
					},
				},
			},
			"aws_opsworks_java_app_layer":    {Tok: awsResource(opsworksMod, "JavaAppLayer")},
			"aws_opsworks_haproxy_layer":     {Tok: awsResource(opsworksMod, "HaproxyLayer")},
			"aws_opsworks_static_web_layer":  {Tok: awsResource(opsworksMod, "StaticWebLayer")},
			"aws_opsworks_php_app_layer":     {Tok: awsResource(opsworksMod, "PhpAppLayer")},
			"aws_opsworks_rails_app_layer":   {Tok: awsResource(opsworksMod, "RailsAppLayer")},
			"aws_opsworks_nodejs_app_layer":  {Tok: awsResource(opsworksMod, "NodejsAppLayer")},
			"aws_opsworks_memcached_layer":   {Tok: awsResource(opsworksMod, "MemcachedLayer")},
			"aws_opsworks_mysql_layer":       {Tok: awsResource(opsworksMod, "MysqlLayer")},
			"aws_opsworks_ganglia_layer":     {Tok: awsResource(opsworksMod, "GangliaLayer")},
			"aws_opsworks_custom_layer":      {Tok: awsResource(opsworksMod, "CustomLayer")},
			"aws_opsworks_instance":          {Tok: awsResource(opsworksMod, "Instance")},
			"aws_opsworks_user_profile":      {Tok: awsResource(opsworksMod, "UserProfile")},
			"aws_opsworks_permission":        {Tok: awsResource(opsworksMod, "Permission")},
			"aws_opsworks_rds_db_instance":   {Tok: awsResource(opsworksMod, "RdsDbInstance")},
			"aws_opsworks_ecs_cluster_layer": {Tok: awsResource(opsworksMod, "EcsClusterLayer")},
			// Organizations
			"aws_organizations_account":                 {Tok: awsResource(organizationsMod, "Account")},
			"aws_organizations_organization":            {Tok: awsResource(organizationsMod, "Organization")},
			"aws_organizations_organizational_unit":     {Tok: awsResource(organizationsMod, "OrganizationalUnit")},
			"aws_organizations_policy":                  {Tok: awsResource(organizationsMod, "Policy")},
			"aws_organizations_policy_attachment":       {Tok: awsResource(organizationsMod, "PolicyAttachment")},
			"aws_organizations_delegated_administrator": {Tok: awsResource(organizationsMod, "DelegatedAdministrator")},
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
			"aws_ram_resource_share":          {Tok: awsResource(ramMod, "ResourceShare")},
			"aws_ram_resource_share_accepter": {Tok: awsResource(ramMod, "ResourceShareAccepter")},
			"aws_ram_principal_association":   {Tok: awsResource(ramMod, "PrincipalAssociation")},
			"aws_ram_resource_association":    {Tok: awsResource(ramMod, "ResourceAssociation")},
			// Relational Database Service (RDS)
			"aws_rds_cluster": {
				Tok: awsResource(rdsMod, "Cluster"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"engine": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(rdsMod, "EngineType", "EngineType")},
					},
					"engine_mode": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(rdsMod, "EngineMode", "EngineMode")},
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
					"instance_class": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(rdsMod, "InstanceType", "InstanceType")},
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
			"aws_rds_global_cluster":           {Tok: awsResource(rdsMod, "GlobalCluster")},
			"aws_rds_cluster_role_association": {Tok: awsResource(rdsMod, "ClusterRoleAssociation")},
			"aws_rds_cluster_activity_stream":  {Tok: awsResource(rdsMod, "ClusterActivityStream")},
			"aws_rds_reserved_instance":        {Tok: awsResource(rdsMod, "ReservedInstance")},
			"aws_db_cluster_snapshot":          {Tok: awsResource(rdsMod, "ClusterSnapshot")},
			"aws_db_event_subscription":        {Tok: awsResource(rdsMod, "EventSubscription")},
			"aws_db_instance": {
				Tok: awsResource(rdsMod, "Instance"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"identifier": {
						Default: &tfbridge.DefaultInfo{
							From: func(res *tfbridge.PulumiResource) (interface{}, error) {
								name, rand, maxlen := string(res.URN.Name()), 7, 255
								if engine, ok := res.Properties["engine"]; ok && engine.IsString() {
									if strings.Contains(strings.ToLower(engine.StringValue()), "sqlserver") {
										// SQL Server identifiers are capped at 15 characters.
										rand, maxlen = 3, 15
									}
								}
								return resource.NewUniqueHex(name, rand, maxlen)
							},
						},
					},
					"instance_class": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(rdsMod, "InstanceType", "InstanceType")},
					},
					"storage_type": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(rdsMod, "StorageType", "StorageType")},
					},
					"name": {
						Name: func() string {
							// We inject `name` into the underlying provider so it shows
							// up in the schema. It is never observed non-nil by the
							// upstream provider and we warn when you set it.

							p.ResourcesMap().Get("aws_db_instance").Schema().
								Set("name", shimv2.NewSchema(&tfschema.Schema{
									Type:     tfschema.TypeString,
									Optional: true,
									ForceNew: true,
								}))
							return "name"
						}(),
						DeprecationMessage: "This property has been deprecated. " +
							"Please use 'dbName' instead.",
					},
				},
				PreCheckCallback: func(
					ctx context.Context, config resource.PropertyMap, meta resource.PropertyMap,
				) (resource.PropertyMap, error) {
					if name, ok := config["name"]; ok {
						// Both `name` and `dbName` are set, so error
						if _, ok := config["dbName"]; ok {
							return nil, fmt.Errorf("Cannot specify both name and dbName, " +
								"please set only dbName")
						}
						tfbridge.GetLogger(ctx).Warn(`"name" is deprecated, use "dbName" instead.`)
						// Name doesn't actually exist on the underlying provider anymore,
						// so we make sure it only sees `dbName`, not `name`.
						config["dbName"] = name
						delete(config, "name")
					}
					return config, nil
				},
				TransformFromState: func(ctx context.Context, state resource.PropertyMap) (resource.PropertyMap, error) {
					if _, ok := state["dbName"]; ok {
						return state, nil
					}
					name, ok := state["name"]
					if !ok {
						// It's seems like inputs are not in a valid state
						return state, nil
					}
					tfbridge.GetLogger(ctx).Debug(`migrating from "name" to "dbName"`)
					state["dbName"] = name
					delete(state, "name")
					return state, nil
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
					"parameter" : {
						Elem: &tfbridge.SchemaInfo{
							Fields: map[string]*tfbridge.SchemaInfo{
								"apply_method": {
									// We set the default value in the overlay since
									// we remove it in the TF schema in 
									// provider/pkg/rds/parameter_group.go
									Default: &tfbridge.DefaultInfo{Value: "immediate"},
								},
							},
						},
					},
				},
				Docs: rds.ParameterGroupDocs("upstream"),
			},
			"aws_db_instance_role_association": {
				Tok: awsResource(rdsMod, "RoleAssociation"),
			},
			"aws_db_snapshot": {Tok: awsResource(rdsMod, "Snapshot")},
			"aws_db_subnet_group": {
				Tok: awsResource(rdsMod, "SubnetGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"description": {
						Default: managedByPulumi,
					},
				},
			},
			"aws_db_proxy":                                  {Tok: awsResource(rdsMod, "Proxy")},
			"aws_db_proxy_default_target_group":             {Tok: awsResource(rdsMod, "ProxyDefaultTargetGroup")},
			"aws_db_proxy_target":                           {Tok: awsResource(rdsMod, "ProxyTarget")},
			"aws_db_proxy_endpoint":                         {Tok: awsResource(rdsMod, "ProxyEndpoint")},
			"aws_db_instance_automated_backups_replication": {Tok: awsResource(rdsMod, "InstanceAutomatedBackupsReplication")},
			"aws_db_snapshot_copy":                          {Tok: awsResource(rdsMod, "SnapshotCopy")},

			// OAM
			"aws_oam_sink":        {Tok: awsResource(oamMod, "Sink")},
			"aws_oam_sink_policy": {Tok: awsResource(oamMod, "SinkPolicy")},
			"aws_oam_link":        {Tok: awsResource(oamMod, "Link")},

			// Pipes
			"aws_pipes_pipe": {Tok: awsResource(pipesMod, "Pipe")},

			// RedShift
			"aws_redshift_cluster":            {Tok: awsResource(redshiftMod, "Cluster")},
			"aws_redshift_scheduled_action":   {Tok: awsResource(redshiftMod, "ScheduledAction")},
			"aws_redshift_event_subscription": {Tok: awsResource(redshiftMod, "EventSubscription")},
			"aws_redshift_parameter_group": {
				Tok: awsResource(redshiftMod, "ParameterGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"description": {
						Default: managedByPulumi,
					},
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
			"aws_redshift_snapshot_schedule":             {Tok: awsResource(redshiftMod, "SnapshotSchedule")},
			"aws_redshift_snapshot_schedule_association": {Tok: awsResource(redshiftMod, "SnapshotScheduleAssociation")},
			"aws_redshift_authentication_profile":        {Tok: awsResource(redshiftMod, "AuthenticationProfile")},
			"aws_redshift_endpoint_access":               {Tok: awsResource(redshiftMod, "EndpointAccess")},
			"aws_redshift_endpoint_authorization":        {Tok: awsResource(redshiftMod, "EndpointAuthorization")},
			"aws_redshift_hsm_client_certificate":        {Tok: awsResource(redshiftMod, "HsmClientCertificate")},
			"aws_redshift_usage_limit":                   {Tok: awsResource(redshiftMod, "UsageLimit")},
			"aws_redshift_cluster_iam_roles":             {Tok: awsResource(redshiftMod, "ClusterIamRoles")},
			"aws_redshift_hsm_configuration":             {Tok: awsResource(redshiftMod, "HsmConfiguration")},
			"aws_redshift_partner":                       {Tok: awsResource(redshiftMod, "Partner")},
			"aws_redshift_cluster_snapshot":              {Tok: awsResource(redshiftMod, "ClusterSnapshot")},

			// RedshiftData
			"aws_redshiftdata_statement": {Tok: awsResource(redshiftDataMod, "Statement")},

			// Redshift serverless
			"aws_redshiftserverless_endpoint_access": {Tok: awsResource(redshiftServerlessMod, "EndpointAccess")},
			"aws_redshiftserverless_namespace":       {Tok: awsResource(redshiftServerlessMod, "Namespace")},
			"aws_redshiftserverless_snapshot":        {Tok: awsResource(redshiftServerlessMod, "Snapshot")},
			"aws_redshiftserverless_usage_limit":     {Tok: awsResource(redshiftServerlessMod, "UsageLimit")},
			"aws_redshiftserverless_workgroup":       {Tok: awsResource(redshiftServerlessMod, "Workgroup")},
			"aws_redshiftserverless_resource_policy": {Tok: awsResource(redshiftServerlessMod, "ResourcePolicy")},
			// Resource Groups
			"aws_resourcegroups_group": {Tok: awsResource(resourcegroupsMod, "Group")},
			// Roles Anywhere
			"aws_rolesanywhere_profile":      {Tok: awsResource(rolesAnywhereMod, "Profile")},
			"aws_rolesanywhere_trust_anchor": {Tok: awsResource(rolesAnywhereMod, "TrustAnchor")},
			// Route53
			"aws_route53_delegation_set": {Tok: awsResource(route53Mod, "DelegationSet")},
			"aws_route53_record": {
				Tok: awsResource(route53Mod, "Record"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"type": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(route53Mod, "RecordType", "RecordType")},
					},
					// Do not autoname Route53 records, as the "name" of these is actually the true
					// domain name of the DNS record.
					"name": {Name: "name"},
					"alias": {
						MaxItemsOne: tfbridge.False(),
						Name:        "aliases",
					},
					"geolocation_routing_policy": {
						MaxItemsOne: tfbridge.False(),
						Name:        "geolocationRoutingPolicies",
					},
					"latency_routing_policy": {
						MaxItemsOne: tfbridge.False(),
						Name:        "latencyRoutingPolicies",
					},
					"failover_routing_policy": {
						MaxItemsOne: tfbridge.False(),
						Name:        "failoverRoutingPolicies",
					},
					"weighted_routing_policy": {
						MaxItemsOne: tfbridge.False(),
						Name:        "weightedRoutingPolicies",
					},
				},
			},
			"aws_route53_resolver_config":               {Tok: awsResource(route53Mod, "ResolverConfig")},
			"aws_route53_resolver_endpoint":             {Tok: awsResource(route53Mod, "ResolverEndpoint")},
			"aws_route53_resolver_rule":                 {Tok: awsResource(route53Mod, "ResolverRule")},
			"aws_route53_resolver_rule_association":     {Tok: awsResource(route53Mod, "ResolverRuleAssociation")},
			"aws_route53_query_log":                     {Tok: awsResource(route53Mod, "QueryLog")},
			"aws_route53_zone_association":              {Tok: awsResource(route53Mod, "ZoneAssociation")},
			"aws_route53_vpc_association_authorization": {Tok: awsResource(route53Mod, "VpcAssociationAuthorization")},
			"aws_route53_zone": {
				Tok: awsResource(route53Mod, "Zone"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"comment": {
						Default: managedByPulumi,
					},
				},
			},
			"aws_route53_health_check":              {Tok: awsResource(route53Mod, "HealthCheck")},
			"aws_route53_hosted_zone_dnssec":        {Tok: awsResource(route53Mod, "HostedZoneDnsSec")},
			"aws_route53_key_signing_key":           {Tok: awsResource(route53Mod, "KeySigningKey")},
			"aws_route53_resolver_dnssec_config":    {Tok: awsResource(route53Mod, "ResolverDnsSecConfig")},
			"aws_route53_resolver_query_log_config": {Tok: awsResource(route53Mod, "ResolverQueryLogConfig")},
			"aws_route53_resolver_query_log_config_association": {
				Tok: awsResource(route53Mod, "ResolverQueryLogConfigAssociation"),
			},
			"aws_route53_resolver_firewall_rule_group": {
				Tok: awsResource(route53Mod, "ResolverFirewallRuleGroup"),
			},
			"aws_route53_resolver_firewall_domain_list": {Tok: awsResource(route53Mod, "ResolverFirewallDomainList")},
			"aws_route53_resolver_firewall_rule":        {Tok: awsResource(route53Mod, "ResolverFirewallRule")},
			"aws_route53_resolver_firewall_rule_group_association": {
				Tok: awsResource(route53Mod, "ResolverFirewallRuleGroupAssociation"),
			},
			"aws_route53_resolver_firewall_config": {Tok: awsResource(route53Mod, "ResolverFirewallConfig")},
			"aws_route53_traffic_policy":           {Tok: awsResource(route53Mod, "TrafficPolicy")},
			"aws_route53_traffic_policy_instance":  {Tok: awsResource(route53Mod, "TrafficPolicyInstance")},
			// Rout53 Recovery Control
			"aws_route53recoverycontrolconfig_cluster":         {Tok: awsResource(route53RecoveryControlMod, "Cluster")},
			"aws_route53recoverycontrolconfig_control_panel":   {Tok: awsResource(route53RecoveryControlMod, "ControlPanel")},
			"aws_route53recoverycontrolconfig_routing_control": {Tok: awsResource(route53RecoveryControlMod, "RoutingControl")},
			"aws_route53recoverycontrolconfig_safety_rule":     {Tok: awsResource(route53RecoveryControlMod, "SafetyRule")},
			// Route53 Recovery Readiness
			"aws_route53recoveryreadiness_cell":            {Tok: awsResource(route53RecoveryReadinessMod, "Cell")},
			"aws_route53recoveryreadiness_readiness_check": {Tok: awsResource(route53RecoveryReadinessMod, "ReadinessCheck")},
			"aws_route53recoveryreadiness_recovery_group":  {Tok: awsResource(route53RecoveryReadinessMod, "RecoveryGroup")},
			"aws_route53recoveryreadiness_resource_set":    {Tok: awsResource(route53RecoveryReadinessMod, "ResourceSet")},
			// Route53 Domains
			"aws_route53domains_registered_domain": {Tok: awsResource(route53DomainsMod, "RegisteredDomain")},
			// RUM
			"aws_rum_app_monitor":         {Tok: awsResource(rumMod, "AppMonitor")},
			"aws_rum_metrics_destination": {Tok: awsResource(rumMod, "MetricsDestination")},
			// Sagemaker
			"aws_sagemaker_endpoint":               {Tok: awsResource(sagemakerMod, "Endpoint")},
			"aws_sagemaker_endpoint_configuration": {Tok: awsResource(sagemakerMod, "EndpointConfiguration")},
			"aws_sagemaker_model":                  {Tok: awsResource(sagemakerMod, "Model")},
			"aws_sagemaker_notebook_instance":      {Tok: awsResource(sagemakerMod, "NotebookInstance")},
			"aws_sagemaker_code_repository":        {Tok: awsResource(sagemakerMod, "CodeRepository")},
			"aws_sagemaker_image":                  {Tok: awsResource(sagemakerMod, "Image")},
			"aws_sagemaker_domain":                 {Tok: awsResource(sagemakerMod, "Domain")},
			"aws_sagemaker_feature_group":          {Tok: awsResource(sagemakerMod, "FeatureGroup")},
			"aws_sagemaker_image_version":          {Tok: awsResource(sagemakerMod, "ImageVersion")},
			"aws_sagemaker_user_profile":           {Tok: awsResource(sagemakerMod, "UserProfile")},
			"aws_sagemaker_app_image_config":       {Tok: awsResource(sagemakerMod, "AppImageConfig")},
			"aws_sagemaker_model_package_group":    {Tok: awsResource(sagemakerMod, "ModelPackageGroup")},
			"aws_sagemaker_app":                    {Tok: awsResource(sagemakerMod, "App")},
			"aws_sagemaker_workforce":              {Tok: awsResource(sagemakerMod, "Workforce")},
			"aws_sagemaker_workteam":               {Tok: awsResource(sagemakerMod, "Workteam")},
			"aws_sagemaker_notebook_instance_lifecycle_configuration": {
				Tok: awsResource(sagemakerMod, "NotebookInstanceLifecycleConfiguration"),
			},
			"aws_sagemaker_device_fleet":                    {Tok: awsResource(sagemakerMod, "DeviceFleet")},
			"aws_sagemaker_human_task_ui":                   {Tok: awsResource(sagemakerMod, "HumanTaskUI")},
			"aws_sagemaker_flow_definition":                 {Tok: awsResource(sagemakerMod, "FlowDefinition")},
			"aws_sagemaker_servicecatalog_portfolio_status": {Tok: awsResource(sagemakerMod, "ServicecatalogPortfolioStatus")},
			"aws_sagemaker_studio_lifecycle_config":         {Tok: awsResource(sagemakerMod, "StudioLifecycleConfig")},
			"aws_sagemaker_model_package_group_policy":      {Tok: awsResource(sagemakerMod, "ModelPackageGroupPolicy")},
			"aws_sagemaker_device": {
				Tok: awsResource(sagemakerMod, "Device"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"device": {
						CSharpName: "DeviceDetails",
					},
				},
			},
			"aws_sagemaker_project":                     {Tok: awsResource(sagemakerMod, "Project")},
			"aws_sagemaker_space":                       {Tok: awsResource(sagemakerMod, "Space")},
			"aws_sagemaker_data_quality_job_definition": {Tok: awsResource(sagemakerMod, "DataQualityJobDefinition")},
			"aws_sagemaker_monitoring_schedule":         {Tok: awsResource(sagemakerMod, "MonitoringSchedule")},
			// Schemas
			"aws_schemas_discoverer":      {Tok: awsResource(schemasMod, "Discoverer")},
			"aws_schemas_registry":        {Tok: awsResource(schemasMod, "Registry")},
			"aws_schemas_registry_policy": {Tok: awsResource(schemasMod, "RegistryPolicy")},
			"aws_schemas_schema":          {Tok: awsResource(schemasMod, "Schema")},
			// Secrets Manager
			"aws_secretsmanager_secret":          {Tok: awsResource(secretsmanagerMod, "Secret")},
			"aws_secretsmanager_secret_version":  {Tok: awsResource(secretsmanagerMod, "SecretVersion")},
			"aws_secretsmanager_secret_rotation": {Tok: awsResource(secretsmanagerMod, "SecretRotation")},
			"aws_secretsmanager_secret_policy":   {Tok: awsResource(secretsmanagerMod, "SecretPolicy")},
			// Service Catalog
			"aws_servicecatalog_portfolio":            {Tok: awsResource(servicecatalogMod, "Portfolio")},
			"aws_servicecatalog_product":              {Tok: awsResource(servicecatalogMod, "Product")},
			"aws_servicecatalog_tag_option":           {Tok: awsResource(servicecatalogMod, "TagOption")},
			"aws_servicecatalog_organizations_access": {Tok: awsResource(servicecatalogMod, "OrganizationsAccess")},
			"aws_servicecatalog_portfolio_share":      {Tok: awsResource(servicecatalogMod, "PortfolioShare")},
			"aws_servicecatalog_constraint":           {Tok: awsResource(servicecatalogMod, "Constraint")},
			"aws_servicecatalog_product_portfolio_association": {
				Tok: awsResource(servicecatalogMod, "ProductPortfolioAssociation"),
			},
			"aws_servicecatalog_service_action": {Tok: awsResource(servicecatalogMod, "ServiceAction")},
			"aws_servicecatalog_budget_resource_association": {
				Tok: awsResource(servicecatalogMod, "BudgetResourceAssociation"),
			},
			"aws_servicecatalog_provisioning_artifact": {Tok: awsResource(servicecatalogMod, "ProvisioningArtifact")},
			"aws_servicecatalog_tag_option_resource_association": {
				Tok: awsResource(servicecatalogMod, "TagOptionResourceAssociation"),
			},
			"aws_servicecatalog_principal_portfolio_association": {
				Tok: awsResource(servicecatalogMod, "PrincipalPortfolioAssociation"),
			},
			"aws_servicecatalog_provisioned_product": {Tok: awsResource(servicecatalogMod, "ProvisionedProduct")},
			// Security Hub
			"aws_securityhub_account": {Tok: awsResource(securityhubMod, "Account")},
			"aws_securityhub_configuration_policy": {
				Tok: awsResource(securityhubMod, "ConfigurationPolicy"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"configuration_policy": {
						// Workaround CS0542 that prohibits member names matching class names.
						CSharpName: "ConfigurationPolicyDetails",
					},
				},
			},
			"aws_securityhub_product_subscription":       {Tok: awsResource(securityhubMod, "ProductSubscription")},
			"aws_securityhub_standards_subscription":     {Tok: awsResource(securityhubMod, "StandardsSubscription")},
			"aws_securityhub_member":                     {Tok: awsResource(securityhubMod, "Member")},
			"aws_securityhub_action_target":              {Tok: awsResource(securityhubMod, "ActionTarget")},
			"aws_securityhub_organization_admin_account": {Tok: awsResource(securityhubMod, "OrganizationAdminAccount")},
			"aws_securityhub_invite_accepter":            {Tok: awsResource(securityhubMod, "InviteAccepter")},
			"aws_securityhub_insight":                    {Tok: awsResource(securityhubMod, "Insight")},
			"aws_securityhub_organization_configuration": {
				Tok: awsResource(securityhubMod, "OrganizationConfiguration"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"organization_configuration": {
						// Workaround CS0542 that prohibits member names matching class names.
						CSharpName: "OrganizationConfigurationDetails",
					},
				},
			},
			"aws_securityhub_standards_control":  {Tok: awsResource(securityhubMod, "StandardsControl")},
			"aws_securityhub_finding_aggregator": {Tok: awsResource(securityhubMod, "FindingAggregator")},
			// Service Discovery
			"aws_service_discovery_http_namespace":        {Tok: awsResource(servicediscoveryMod, "HttpNamespace")},
			"aws_service_discovery_private_dns_namespace": {Tok: awsResource(servicediscoveryMod, "PrivateDnsNamespace")},
			"aws_service_discovery_public_dns_namespace":  {Tok: awsResource(servicediscoveryMod, "PublicDnsNamespace")},
			"aws_service_discovery_service":               {Tok: awsResource(servicediscoveryMod, "Service")},
			"aws_service_discovery_instance":              {Tok: awsResource(servicediscoveryMod, "Instance")},
			// Simple Email Service (SES)
			"aws_ses_active_receipt_rule_set":      {Tok: awsResource(sesMod, "ActiveReceiptRuleSet")},
			"aws_ses_domain_dkim":                  {Tok: awsResource(sesMod, "DomainDkim")},
			"aws_ses_domain_identity":              {Tok: awsResource(sesMod, "DomainIdentity")},
			"aws_ses_domain_identity_verification": {Tok: awsResource(sesMod, "DomainIdentityVerification")},
			"aws_ses_domain_mail_from":             {Tok: awsResource(sesMod, "MailFrom")},
			"aws_ses_email_identity":               {Tok: awsResource(sesMod, "EmailIdentity")},
			"aws_ses_identity_notification_topic":  {Tok: awsResource(sesMod, "IdentityNotificationTopic")},
			"aws_ses_identity_policy":              {Tok: awsResource(sesMod, "IdentityPolicy")},
			"aws_ses_receipt_filter":               {Tok: awsResource(sesMod, "ReceiptFilter")},
			"aws_ses_receipt_rule":                 {Tok: awsResource(sesMod, "ReceiptRule")},
			"aws_ses_receipt_rule_set":             {Tok: awsResource(sesMod, "ReceiptRuleSet")},
			"aws_ses_event_destination":            {Tok: awsResource(sesMod, "EventDestination")},
			"aws_ses_template":                     {Tok: awsResource(sesMod, "Template")},

			"aws_sesv2_configuration_set":                   {Tok: awsResource(sesV2Mod, "ConfigurationSet")},
			"aws_sesv2_configuration_set_event_destination": {Tok: awsResource(sesV2Mod, "ConfigurationSetEventDestination")},
			"aws_sesv2_dedicated_ip_assignment":             {Tok: awsResource(sesV2Mod, "DedicatedIpAssignment")},
			"aws_sesv2_dedicated_ip_pool":                   {Tok: awsResource(sesV2Mod, "DedicatedIpPool")},
			"aws_sesv2_email_identity_feedback_attributes":  {Tok: awsResource(sesV2Mod, "EmailIdentityFeedbackAttributes")},
			"aws_sesv2_email_identity_mail_from_attributes": {Tok: awsResource(sesV2Mod, "EmailIdentityMailFromAttributes")},
			"aws_sesv2_email_identity": {
				Tok: awsResource(sesV2Mod, "EmailIdentity"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"email_identity": {
						CSharpName: "EmailIdentityDetails",
					},
				},
			},
			"aws_sesv2_contact_list": {Tok: awsResource(sesV2Mod, "ContactList")},

			// Shield
			"aws_shield_protection":                          {Tok: awsResource(shieldMod, "Protection")},
			"aws_shield_protection_group":                    {Tok: awsResource(shieldMod, "ProtectionGroup")},
			"aws_shield_protection_health_check_association": {Tok: awsResource(shieldMod, "ProtectionHealthCheckAssociation")},

			// S3
			"aws_s3_account_public_access_block": {Tok: awsResource(s3Mod, "AccountPublicAccessBlock")},
			"aws_s3_bucket": {
				Tok: awsResource(s3Mod, "BucketV2"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"bucket": tfbridge.AutoNameTransform("bucket", 63, func(name string) string {
						return strings.ToLower(name)
					}),
					"logging": {
						MaxItemsOne: tfbridge.False(),
						Name:        "loggings",
					},
					"versioning": {
						MaxItemsOne: tfbridge.False(),
						Name:        "versionings",
					},
					"website": {
						MaxItemsOne: tfbridge.False(),
						Name:        "websites",
					},
					"server_side_encryption_configuration": {
						MaxItemsOne: tfbridge.False(),
						Name:        "serverSideEncryptionConfigurations",
						Elem: &tfbridge.SchemaInfo{
							Fields: map[string]*tfbridge.SchemaInfo{
								"rule": {
									MaxItemsOne: tfbridge.False(),
									Name:        "rules",
									Elem: &tfbridge.SchemaInfo{
										Fields: map[string]*tfbridge.SchemaInfo{
											"apply_server_side_encryption_by_default": {
												Name:        "applyServerSideEncryptionByDefaults",
												MaxItemsOne: tfbridge.False(),
											},
										},
									},
								},
							},
						},
					},
					"lifecycle_rule": {
						Elem: &tfbridge.SchemaInfo{
							Fields: map[string]*tfbridge.SchemaInfo{
								"expiration": {
									MaxItemsOne: tfbridge.False(),
									Name:        "expirations",
								},
								"noncurrent_version_expiration": {
									MaxItemsOne: tfbridge.False(),
									Name:        "noncurrentVersionExpirations",
								},
							},
						},
					},
					"object_lock_configuration": {
						Elem: &tfbridge.SchemaInfo{
							Fields: map[string]*tfbridge.SchemaInfo{
								"rule": {
									Name:        "rules",
									MaxItemsOne: tfbridge.False(),
									Elem: &tfbridge.SchemaInfo{
										Fields: map[string]*tfbridge.SchemaInfo{
											"default_retention": {
												Name:        "defaultRetentions",
												MaxItemsOne: tfbridge.False(),
											},
										},
									},
								},
							},
						},
					},
					"replication_configuration": {
						MaxItemsOne: tfbridge.False(),
						Name:        "replicationConfigurations",
						Elem: &tfbridge.SchemaInfo{
							Fields: map[string]*tfbridge.SchemaInfo{
								"rules": {
									Elem: &tfbridge.SchemaInfo{
										Fields: map[string]*tfbridge.SchemaInfo{
											"filter": {
												MaxItemsOne: tfbridge.False(),
												Name:        "filters",
											},
											"source_selection_criteria": {
												MaxItemsOne: tfbridge.False(),
												Name:        "sourceSelectionCriterias",
												Elem: &tfbridge.SchemaInfo{
													Fields: map[string]*tfbridge.SchemaInfo{
														"sse_kms_encrypted_objects": {
															Name:        "sseKmsEncryptedObjects",
															MaxItemsOne: tfbridge.False(),
														},
													},
												},
											},
											"destination": {
												MaxItemsOne: tfbridge.False(),
												Name:        "destinations",
												Elem: &tfbridge.SchemaInfo{
													Fields: map[string]*tfbridge.SchemaInfo{
														"metrics": {
															MaxItemsOne: tfbridge.False(),
														},
														"replication_time": {
															MaxItemsOne: tfbridge.False(),
															Name:        "replicationTimes",
														},
														"access_control_translation": {
															MaxItemsOne: tfbridge.False(),
															Name:        "accessControlTranslations",
														},
													},
												},
											},
										},
									},
								},
							},
						},
					},
				},
				Aliases: []tfbridge.AliasInfo{
					{
						Type: ref("aws:s3/bucket:Bucket"),
					},
				},
			},
			"aws_s3_bucket_accelerate_configuration":             {Tok: awsResource(s3Mod, "BucketAccelerateConfigurationV2")},
			"aws_s3_bucket_acl":                                  {Tok: awsResource(s3Mod, "BucketAclV2")},
			"aws_s3_bucket_cors_configuration":                   {Tok: awsResource(s3Mod, "BucketCorsConfigurationV2")},
			"aws_s3_bucket_lifecycle_configuration":              {Tok: awsResource(s3Mod, "BucketLifecycleConfigurationV2")},
			"aws_s3_bucket_logging":                              {Tok: awsResource(s3Mod, "BucketLoggingV2")},
			"aws_s3_bucket_object_lock_configuration":            {Tok: awsResource(s3Mod, "BucketObjectLockConfigurationV2")},
			"aws_s3_bucket_request_payment_configuration":        {Tok: awsResource(s3Mod, "BucketRequestPaymentConfigurationV2")},
			"aws_s3_bucket_server_side_encryption_configuration": {Tok: awsResource(s3Mod, "BucketServerSideEncryptionConfigurationV2")},
			"aws_s3_bucket_versioning":                           {Tok: awsResource(s3Mod, "BucketVersioningV2")},
			"aws_s3_bucket_website_configuration": {
				Tok: awsResource(s3Mod, "BucketWebsiteConfigurationV2"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"routing_rules": {
						Name: "routingRuleDetails",
					},
					"routing_rule": {
						Name: "routingRules",
					},
				},
			},
			"aws_s3_object": {
				Tok:      awsResource(s3Mod, "BucketObjectv2"),
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
							From: tfbridge.FromName(tfbridge.AutoNameOptions{
								Maxlen:    0,
								Randlen:   0,
								Transform: nil,
							}),
						},
					},
					"source": {
						Asset: &tfbridge.AssetTranslation{
							Kind: tfbridge.FileAsset,
						},
					},
				},
				Aliases: []tfbridge.AliasInfo{
					{
						Type: ref("aws:s3/BucketObject:BucketObject"),
					},
				},
			},
			"aws_s3_bucket_legacy": {
				Tok: awsResource(s3Mod, "Bucket"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"acl": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(s3Mod, "CannedAcl", "CannedAcl")},
					},
					"bucket": tfbridge.AutoNameTransform("bucket", 63, func(name string) string {
						return strings.ToLower(name)
					}),
					// Website only accepts a single value in the AWS
					// API but is not marked MaxItems==1 in the TF
					// provider.
					"website": {
						Name: "website",
						Elem: &tfbridge.SchemaInfo{
							Fields: map[string]*tfbridge.SchemaInfo{
								"routing_rules": {
									Name:      "routingRules",
									Type:      "string",
									AltTypes:  []tokens.Type{awsType(s3Mod, "routingRules", "RoutingRule[]")},
									Transform: tfbridge.TransformJSONDocument,
								},
							},
						},
					},
					"policy": {
						Type:      "string",
						AltTypes:  []tokens.Type{awsType(iamMod, "documents", "PolicyDocument")},
						Transform: tfbridge.TransformJSONDocument,
					},
				},
				Docs: &tfbridge.DocInfo{Source: "../../../../docs/resource/aws_s3_bucket_legacy.md"},
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
							From: tfbridge.FromName(tfbridge.AutoNameOptions{
								Maxlen:    0,
								Randlen:   0,
								Transform: nil,
							}),
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
						AltTypes:  []tokens.Type{awsType(iamMod, "documents", "PolicyDocument")},
						Transform: tfbridge.TransformJSONDocument,
					},
				},
			},
			"aws_s3_bucket_public_access_block": {Tok: awsResource(s3Mod, "BucketPublicAccessBlock")},
			"aws_s3_bucket_analytics_configuration": {
				Tok: awsResource(s3Mod, "AnalyticsConfiguration"),
				Docs: &tfbridge.DocInfo{
					Source: "s3_bucket_analysis_configuration.html.markdown",
				},
			},
			"aws_s3_access_point":              {Tok: awsResource(s3Mod, "AccessPoint")},
			"aws_s3_bucket_ownership_controls": {Tok: awsResource(s3Mod, "BucketOwnershipControls")},
			"aws_s3_object_copy":               {Tok: awsResource(s3Mod, "ObjectCopy")},
			"aws_s3_bucket_intelligent_tiering_configuration": {
				Tok: awsResource(s3Mod, "BucketIntelligentTieringConfiguration"),
			},
			"aws_s3_bucket_replication_configuration": {Tok: awsResource(s3Mod, "BucketReplicationConfig")},
			// S3 Control
			"aws_s3control_bucket": {
				Tok: awsResource(s3ControlMod, "Bucket"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"bucket": {
						CSharpName: "BucketName",
					},
				},
			},
			"aws_s3control_bucket_lifecycle_configuration":    {Tok: awsResource(s3ControlMod, "BucketLifecycleConfiguration")},
			"aws_s3control_bucket_policy":                     {Tok: awsResource(s3ControlMod, "BucketPolicy")},
			"aws_s3control_access_point_policy":               {Tok: awsResource(s3ControlMod, "AccessPointPolicy")},
			"aws_s3control_multi_region_access_point":         {Tok: awsResource(s3ControlMod, "MultiRegionAccessPoint")},
			"aws_s3control_multi_region_access_point_policy":  {Tok: awsResource(s3ControlMod, "MultiRegionAccessPointPolicy")},
			"aws_s3control_object_lambda_access_point":        {Tok: awsResource(s3ControlMod, "ObjectLambdaAccessPoint")},
			"aws_s3control_object_lambda_access_point_policy": {Tok: awsResource(s3ControlMod, "ObjectLambdaAccessPointPolicy")},
			"aws_s3control_storage_lens_configuration": {
				Tok: awsResource(s3ControlMod, "StorageLensConfiguration"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"storage_lens_configuration": {
						CSharpName: "StorageLensConfigurationDetail",
					},
				},
			},
			// S3 Outposts
			"aws_s3outposts_endpoint": {Tok: awsResource(s3OutpostsMod, "Endpoint")},
			// Systems Manager (SSM)
			"aws_ssm_activation":                {Tok: awsResource(ssmMod, "Activation")},
			"aws_ssm_association":               {Tok: awsResource(ssmMod, "Association")},
			"aws_ssm_default_patch_baseline":    {Tok: awsResource(ssmMod, "DefaultPatchBaseline")},
			"aws_ssm_document":                  {Tok: awsResource(ssmMod, "Document")},
			"aws_ssm_maintenance_window":        {Tok: awsResource(ssmMod, "MaintenanceWindow")},
			"aws_ssm_maintenance_window_target": {Tok: awsResource(ssmMod, "MaintenanceWindowTarget")},
			"aws_ssm_maintenance_window_task":   {Tok: awsResource(ssmMod, "MaintenanceWindowTask")},
			"aws_ssm_patch_baseline":            {Tok: awsResource(ssmMod, "PatchBaseline")},
			"aws_ssm_patch_group": {
				Tok: awsResource(ssmMod, "PatchGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"patch_group": {
						CSharpName: "PatchGroupName",
					},
				},
			},
			"aws_ssm_parameter": {
				Tok: awsResource(ssmMod, "Parameter"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"type": {
						Type:     "string",
						AltTypes: []tokens.Type{awsType(ssmMod, "ParameterType", "ParameterType")},
					},
				},
			},
			"aws_ssm_resource_data_sync": {Tok: awsResource(ssmMod, "ResourceDataSync")},
			"aws_ssm_service_setting":    {Tok: awsResource(ssmMod, "ServiceSetting")},

			// SSM Incidents
			"aws_ssmincidents_replication_set": {Tok: awsResource(ssmIncidentsMod, "ReplicationSet")},
			"aws_ssmincidents_response_plan":   {Tok: awsResource(ssmIncidentsMod, "ResponsePlan")},

			// SSM Contacts
			"aws_ssmcontacts_contact":         {Tok: awsResource(ssmContactsMod, "Contact")},
			"aws_ssmcontacts_contact_channel": {Tok: awsResource(ssmContactsMod, "ContactChannel")},
			"aws_ssmcontacts_plan":            {Tok: awsResource(ssmContactsMod, "Plan")},

			// SimpleDB
			"aws_simpledb_domain": {Tok: awsResource(simpledbMod, "Domain")},
			// Simple Queuing Service (SQS)
			"aws_sqs_queue": {
				Tok: awsResource(sqsMod, "Queue"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"name": tfbridge.AutoNameWithCustomOptions("name", tfbridge.AutoNameOptions{
						Separator: "-",
						Maxlen:    80,
						Randlen:   7,
						// If this is a FIFO Queue, it's name must end with `.fifo`
						PostTransform: func(res *tfbridge.PulumiResource, name string) (string, error) {
							if fifo, hasfifo := res.Properties["fifoQueue"]; hasfifo {
								if fifo.IsBool() && fifo.BoolValue() {
									return name + ".fifo", nil
								}
							}
							return name, nil
						},
					}),
				},
			},
			"aws_sqs_queue_policy": {
				Tok: awsResource(sqsMod, "QueuePolicy"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"policy": {
						Type:      "string",
						AltTypes:  []tokens.Type{awsType(iamMod, "documents", "PolicyDocument")},
						Transform: tfbridge.TransformJSONDocument,
					},
				},
			},
			"aws_sqs_queue_redrive_allow_policy": {
				Tok: awsResource(sqsMod, "RedriveAllowPolicy"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"redrive_allow_policy": {
						CSharpName: "RedriveAllowPolicyName",
					},
				},
			},
			"aws_sqs_queue_redrive_policy": {
				Tok: awsResource(sqsMod, "RedrivePolicy"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"redrive_policy": {
						CSharpName: "RedrivePolicyName",
					},
				},
			},
			// Storage Gateway
			"aws_storagegateway_gateway":             {Tok: awsResource(storagegatewayMod, "Gateway")},
			"aws_storagegateway_cache":               {Tok: awsResource(storagegatewayMod, "Cache")},
			"aws_storagegateway_cached_iscsi_volume": {Tok: awsResource(storagegatewayMod, "CachesIscsiVolume")},
			"aws_storagegateway_nfs_file_share":      {Tok: awsResource(storagegatewayMod, "NfsFileShare")},
			"aws_storagegateway_smb_file_share":      {Tok: awsResource(storagegatewayMod, "SmbFileShare")},
			"aws_storagegateway_upload_buffer":       {Tok: awsResource(storagegatewayMod, "UploadBuffer")},
			"aws_storagegateway_working_storage":     {Tok: awsResource(storagegatewayMod, "WorkingStorage")},
			"aws_storagegateway_stored_iscsi_volume": {Tok: awsResource(storagegatewayMod, "StoredIscsiVolume")},
			"aws_storagegateway_tape_pool":           {Tok: awsResource(storagegatewayMod, "TapePool")},
			"aws_storagegateway_file_system_association": {
				Tok: awsResource(storagegatewayMod, "FileSystemAssociation"),
			},
			// Simple Notification Service (SNS)
			"aws_sns_platform_application": {Tok: awsResource(snsMod, "PlatformApplication")},
			"aws_sns_sms_preferences":      {Tok: awsResource(snsMod, "SmsPreferences")},
			"aws_sns_topic": {
				Tok: awsResource(snsMod, "Topic"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"arn": {Type: awsTypeDefaultFile(awsMod, "ARN")},
					"name": tfbridge.AutoNameWithCustomOptions("name", tfbridge.AutoNameOptions{
						Separator: "-",
						Maxlen:    80,
						Randlen:   7,
						// If this is a FIFO topic, it's name must end with `.fifo`
						PostTransform: func(res *tfbridge.PulumiResource, name string) (string, error) {
							if fifo, hasfifo := res.Properties["fifoTopic"]; hasfifo {
								if fifo.IsBool() && fifo.BoolValue() {
									return name + ".fifo", nil
								}
							}
							return name, nil
						},
					}),
				},
			},
			"aws_sns_topic_policy": {
				Tok: awsResource(snsMod, "TopicPolicy"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"policy": {
						Type:      "string",
						AltTypes:  []tokens.Type{awsType(iamMod, "documents", "PolicyDocument")},
						Transform: tfbridge.TransformJSONDocument,
					},
				},
			},
			"aws_sns_topic_subscription": {
				Tok: awsResource(snsMod, "TopicSubscription"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"topic_arn": {
						Name:     "topic",
						Type:     "string",
						AltTypes: []tokens.Type{awsResource(snsMod, "Topic")},
					},
				},
			},
			"aws_sns_topic_data_protection_policy": {Tok: awsResource(snsMod, "DataProtectionPolicy")},
			// Step Functions (SFN)
			"aws_sfn_activity":      {Tok: awsResource(sfnMod, "Activity")},
			"aws_sfn_state_machine": {Tok: awsResource(sfnMod, "StateMachine")},
			// Simple Workflow Service (SWF)
			"aws_swf_domain": {Tok: awsResource(swfMod, "Domain")},
			// Synthetics
			"aws_synthetics_canary":            {Tok: awsResource(syntheticsMod, "Canary")},
			"aws_synthetics_group":             {Tok: awsResource(syntheticsMod, "Group")},
			"aws_synthetics_group_association": {Tok: awsResource(syntheticsMod, "GroupAssociation")},
			// Transcribe
			"aws_transcribe_medical_vocabulary": {Tok: awsResource(transcribeMod, "MedicalVocabulary")},
			"aws_transcribe_vocabulary":         {Tok: awsResource(transcribeMod, "Vocabulary")},
			"aws_transcribe_vocabulary_filter":  {Tok: awsResource(transcribeMod, "VocabularyFilter")},
			"aws_transcribe_language_model":     {Tok: awsResource(transcribeMod, "LanguageModel")},
			// Transfer Service
			"aws_transfer_server":   {Tok: awsResource(transferMod, "Server")},
			"aws_transfer_ssh_key":  {Tok: awsResource(transferMod, "SshKey")},
			"aws_transfer_user":     {Tok: awsResource(transferMod, "User")},
			"aws_transfer_access":   {Tok: awsResource(transferMod, "Access")},
			"aws_transfer_workflow": {Tok: awsResource(transferMod, "Workflow")},
			"aws_transfer_tag":      {Tok: awsResource(transferMod, "Tag")},
			"aws_transfer_certificate": {
				Tok: awsResource(transferMod, "Certificate"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"certificate": {CSharpName: "CertificateFile"},
				},
			},
			// TimestreamWrite
			"aws_timestreamwrite_database": {Tok: awsResource(timestreamWriteMod, "Database")},
			"aws_timestreamwrite_table":    {Tok: awsResource(timestreamWriteMod, "Table")},
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
			// Web Application Firewall V2 (WAFv2)
			"aws_wafv2_ip_set":                        {Tok: awsResource(wafV2Mod, "IpSet")},
			"aws_wafv2_regex_pattern_set":             {Tok: awsResource(wafV2Mod, "RegexPatternSet")},
			"aws_wafv2_web_acl_association":           {Tok: awsResource(wafV2Mod, "WebAclAssociation")},
			"aws_wafv2_rule_group":                    {Tok: awsResource(wafV2Mod, "RuleGroup")},
			"aws_wafv2_web_acl":                       {Tok: awsResource(wafV2Mod, "WebAcl")},
			"aws_wafv2_web_acl_logging_configuration": {Tok: awsResource(wafV2Mod, "WebAclLoggingConfiguration")},
			// Web Application Firewall (WAF) Regional
			"aws_wafregional_byte_match_set": {
				Tok: awsResource(wafregionalMod, "ByteMatchSet"),
				Fields: map[string]*tfbridge.SchemaInfo{
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
			// Xray
			"aws_xray_sampling_rule":     {Tok: awsResource(xrayMod, "SamplingRule")},
			"aws_xray_encryption_config": {Tok: awsResource(xrayMod, "EncryptionConfig")},
			"aws_xray_group":             {Tok: awsResource(xrayMod, "Group")},
			// MSK
			"aws_msk_cluster": {
				Tok: awsResource(mskMod, "Cluster"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"cluster_name": tfbridge.AutoName("clusterName", 255, "-"),
				},
			},
			"aws_msk_configuration":            {Tok: awsResource(mskMod, "Configuration")},
			"aws_msk_scram_secret_association": {Tok: awsResource(mskMod, "ScramSecretAssociation")},
			"aws_msk_serverless_cluster": {
				Tok: awsResource(mskMod, "ServerlessCluster"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"cluster_name": tfbridge.AutoName("clusterName", 255, "-"),
				},
			},
			// MSKConnect
			"aws_mskconnect_custom_plugin":        {Tok: awsResource(mskConnectMod, "CustomPlugin")},
			"aws_mskconnect_worker_configuration": {Tok: awsResource(mskConnectMod, "WorkerConfiguration")},
			"aws_mskconnect_connector":            {Tok: awsResource(mskConnectMod, "Connector")},
			// Datapipeline
			"aws_datapipeline_pipeline": {Tok: awsResource(datapipelineMod, "Pipeline")},
			// Quicksight
			"aws_quicksight_account_subscription": {Tok: awsResource(quicksightMod, "AccountSubscription")},
			"aws_quicksight_data_set":             {Tok: awsResource(quicksightMod, "DataSet")},
			"aws_quicksight_group":                {Tok: awsResource(quicksightMod, "Group")},
			"aws_quicksight_user":                 {Tok: awsResource(quicksightMod, "User")},
			"aws_quicksight_group_membership":     {Tok: awsResource(quicksightMod, "GroupMembership")},
			"aws_quicksight_data_source":          {Tok: awsResource(quicksightMod, "DataSource")},
			"aws_quicksight_folder":               {Tok: awsResource(quicksightMod, "Folder")},
			"aws_quicksight_template": {
				Tok: awsResource(quicksightMod, "Template"),
				Fields: map[string]*tfbridge.SchemaInfo{
					// HACK: remove this field for now as it breaks dotnet codegen due to our current type naming strategy.
					// https://github.com/pulumi/pulumi-terraform-bridge/issues/1118
					"definition": {Omit: true},
				},
			},
			"aws_quicksight_analysis": {
				Tok: awsResource(quicksightMod, "Analysis"),
				Fields: map[string]*tfbridge.SchemaInfo{
					// HACK: remove this field for now as it breaks dotnet and java codegen due to our current type naming strategy.
					// https://github.com/pulumi/pulumi-terraform-bridge/issues/1118
					"definition": {Omit: true},
				},
			},
			"aws_quicksight_dashboard": {
				Tok: awsResource(quicksightMod, "Dashboard"),
				Fields: map[string]*tfbridge.SchemaInfo{
					// HACK: remove this field for now as it breaks dotnet and java codegen due to our current type naming strategy.
					// https://github.com/pulumi/pulumi-terraform-bridge/issues/1118
					"definition": {Omit: true},
				},
			},
			// Service Quotas
			"aws_servicequotas_service_quota": {Tok: awsResource(servicequotasMod, "ServiceQuota")},
			// Fis
			"aws_fis_experiment_template": {Tok: awsResource(fisMod, "ExperimentTemplate")},
			// FMS
			"aws_fms_admin_account": {Tok: awsResource(fmsMod, "AdminAccount")},
			"aws_fms_policy":        {Tok: awsResource(fmsMod, "Policy")},
			// QLDB
			"aws_qldb_ledger": {Tok: awsResource(qldbMod, "Ledger")},
			"aws_qldb_stream": {Tok: awsResource(qldbMod, "Stream")},
			// Workspaces
			"aws_workspaces_ip_group":  {Tok: awsResource(workspacesMod, "IpGroup")},
			"aws_workspaces_directory": {Tok: awsResource(workspacesMod, "Directory")},
			"aws_workspaces_workspace": {Tok: awsResource(workspacesMod, "Workspace")},
			// Access Analyzer
			"aws_accessanalyzer_analyzer":     {Tok: awsResource(accessAnalyzerMod, "Analyzer")},
			"aws_accessanalyzer_archive_rule": {Tok: awsResource(accessAnalyzerMod, "ArchiveRule")},
			// CodeStar Notifications
			"aws_codestarnotifications_notification_rule": {
				Tok: awsResource(codestarNotificationsMod, "NotificationRule"),
			},
			// Lex
			"aws_lex_slot_type": {
				Tok: awsResource(lexMod, "SlotType"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"name": {
						Default: &tfbridge.DefaultInfo{
							// This means the name will adhere to ^([A-Za-z]_?)+$  as per
							// https://docs.aws.amazon.com/lex/latest/dg/API_PutSlotType.html
							From: tfbridge.FromName(tfbridge.AutoNameOptions{
								Separator: "_",
								Charset:   []rune("abcdefghijklmnopqrstuvwxyz"),
								Randlen:   8,
							}),
						},
					},
				},
			},
			"aws_lex_bot": {
				Tok: awsResource(lexMod, "Bot"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"name": {
						Default: &tfbridge.DefaultInfo{
							// This means the name will adhere to ^([A-Za-z]_?)+$  as per
							// https://docs.aws.amazon.com/lex/latest/dg/API_PutBot.html
							From: tfbridge.FromName(tfbridge.AutoNameOptions{
								Separator: "_",
								Charset:   []rune("abcdefghijklmnopqrstuvwxyz"),
								Randlen:   8,
							}),
						},
					},
				},
			},
			"aws_lex_intent": {
				Tok: awsResource(lexMod, "Intent"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"name": {
						Default: &tfbridge.DefaultInfo{
							// This means the name will adhere to ^([A-Za-z]_?)+$  as per
							// https://docs.aws.amazon.com/lex/latest/dg/API_PutIntent.html
							From: tfbridge.FromName(tfbridge.AutoNameOptions{
								Separator: "_",
								Charset:   []rune("abcdefghijklmnopqrstuvwxyz"),
								Randlen:   8,
							}),
						},
					},
				},
			},
			"aws_lex_bot_alias": {
				Tok: awsResource(lexMod, "BotAlias"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"name": {
						Default: &tfbridge.DefaultInfo{
							// This means the name will adhere to ^([A-Za-z]_?)+$  as per
							// https://docs.aws.amazon.com/lex/latest/dg/API_PutBotAlias.html
							From: tfbridge.FromName(tfbridge.AutoNameOptions{
								Separator: "_",
								Charset:   []rune("abcdefghijklmnopqrstuvwxyz"),
								Randlen:   8,
							}),
						},
					},
				},
			},
			// Codeartifact
			"aws_codeartifact_domain": {
				Tok: awsResource(codeartifactMod, "Domain"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"domain": {
						CSharpName: "DomainName",
					},
				},
			},
			"aws_codeartifact_repository": {
				Tok: awsResource(codeartifactMod, "Repository"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"repository": {
						CSharpName: "RepositoryName",
					},
				},
			},
			"aws_codeartifact_domain_permissions_policy": {Tok: awsResource(codeartifactMod, "DomainPermissions")},
			"aws_codeartifact_repository_permissions_policy": {
				Tok: awsResource(codeartifactMod, "RepositoryPermissionsPolicy"),
			},

			// Imagebuilder
			"aws_imagebuilder_image":          {Tok: awsResource(imageBuilderMod, "Image")},
			"aws_imagebuilder_component":      {Tok: awsResource(imageBuilderMod, "Component")},
			"aws_imagebuilder_image_pipeline": {Tok: awsResource(imageBuilderMod, "ImagePipeline")},
			"aws_imagebuilder_image_recipe":   {Tok: awsResource(imageBuilderMod, "ImageRecipe")},
			"aws_imagebuilder_distribution_configuration": {
				Tok: awsResource(imageBuilderMod, "DistributionConfiguration"),
			},
			"aws_imagebuilder_infrastructure_configuration": {
				Tok: awsResource(imageBuilderMod, "InfrastructureConfiguration"),
			},
			"aws_imagebuilder_container_recipe": {Tok: awsResource(imageBuilderMod, "ContainerRecipe")},

			// Network firewall
			"aws_networkfirewall_firewall": {Tok: awsResource(networkFirewallMod, "Firewall")},
			"aws_networkfirewall_firewall_policy": {
				Tok: awsResource(networkFirewallMod, "FirewallPolicy"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"firewall_policy": {
						CSharpName: "FirewallPolicyConfiguration",
					},
				},
			},
			"aws_networkfirewall_logging_configuration": {
				Tok: awsResource(networkFirewallMod, "LoggingConfiguration"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"logging_configuration": {
						CSharpName: "LoggingConfig",
					},
				},
			},
			"aws_networkfirewall_rule_group": {
				Tok: awsResource(networkFirewallMod, "RuleGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"rule_group": {
						CSharpName: "RuleGroupConfiguration",
					},
				},
			},
			"aws_networkfirewall_resource_policy": {
				Tok: awsResource(networkFirewallMod, "ResourcePolicy"),
				Docs: &tfbridge.DocInfo{
					ImportDetails: "Using `pulumi import`, import Network Firewall Resource Policies using the `resource arn`. For example: \n" +
						"```sh\n" +
						"$ pulumi import aws:networkfirewall/resourcePolicy:ResourcePolicy example arn:aws:network-firewall:us-west-1:123456789012:stateful-rulegroup/example\n" +
						"```\n",
				},
			},

			// signer
			"aws_signer_signing_job":                {Tok: awsResource(signerMod, "SigningJob")},
			"aws_signer_signing_profile":            {Tok: awsResource(signerMod, "SigningProfile")},
			"aws_signer_signing_profile_permission": {Tok: awsResource(signerMod, "SigningProfilePermission")},

			// ServerlessRepository
			"aws_serverlessapplicationrepository_cloudformation_stack": {
				Tok: awsResource(serverlessRepositoryMod, "CloudFormationStack"),
			},

			// Lakeformation
			"aws_lakeformation_data_lake_settings": {Tok: awsResource(lakeFormationMod, "DataLakeSettings")},
			"aws_lakeformation_permissions": {
				Tok: awsResource(lakeFormationMod, "Permissions"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"permissions": {
						CSharpName: "PermissionDetails",
					},
				},
			},
			"aws_lakeformation_resource":         {Tok: awsResource(lakeFormationMod, "Resource")},
			"aws_lakeformation_lf_tag":           {Tok: awsResource(lakeFormationMod, "LfTag")},
			"aws_lakeformation_resource_lf_tags": {Tok: awsResource(lakeFormationMod, "ResourceLfTags")},

			// codestar connections
			"aws_codestarconnections_connection": {Tok: awsResource(codestarConnectionsMod, "Connection")},
			"aws_codestarconnections_host":       {Tok: awsResource(codestarConnectionsMod, "Host")},

			// SSO Admin
			"aws_ssoadmin_managed_policy_attachment":          {Tok: awsResource(ssoAdminMod, "ManagedPolicyAttachment")},
			"aws_ssoadmin_permission_set":                     {Tok: awsResource(ssoAdminMod, "PermissionSet")},
			"aws_ssoadmin_permission_set_inline_policy":       {Tok: awsResource(ssoAdminMod, "PermissionSetInlinePolicy")},
			"aws_ssoadmin_account_assignment":                 {Tok: awsResource(ssoAdminMod, "AccountAssignment")},
			"aws_ssoadmin_customer_managed_policy_attachment": {Tok: awsResource(ssoAdminMod, "CustomerManagedPolicyAttachment")},
			"aws_ssoadmin_permissions_boundary_attachment":    {Tok: awsResource(ssoAdminMod, "PermissionsBoundaryAttachment")},
			"aws_ssoadmin_instance_access_control_attributes": {Tok: awsResource(ssoAdminMod, "InstanceAccessControlAttributes")},
			// AMP (Managed Prometheus)
			"aws_prometheus_workspace":                {Tok: awsResource(ampMod, "Workspace")},
			"aws_prometheus_alert_manager_definition": {Tok: awsResource(ampMod, "AlertManagerDefinition")},
			"aws_prometheus_rule_group_namespace":     {Tok: awsResource(ampMod, "RuleGroupNamespace")},

			// Amplify
			"aws_amplify_app":                 {Tok: awsResource(amplifyMod, "App")},
			"aws_amplify_backend_environment": {Tok: awsResource(amplifyMod, "BackendEnvironment")},
			"aws_amplify_branch":              {Tok: awsResource(amplifyMod, "Branch")},
			"aws_amplify_domain_association":  {Tok: awsResource(amplifyMod, "DomainAssociation")},
			"aws_amplify_webhook":             {Tok: awsResource(amplifyMod, "Webhook")},

			// AppFlow
			"aws_appflow_connector_profile": {Tok: awsResource(appFlowMod, "ConnectorProfile")},
			"aws_appflow_flow":              {Tok: awsResource(appFlowMod, "Flow")},

			// appconfig
			"aws_appconfig_application":                  {Tok: awsResource(appConfigMod, "Application")},
			"aws_appconfig_configuration_profile":        {Tok: awsResource(appConfigMod, "ConfigurationProfile")},
			"aws_appconfig_deployment_strategy":          {Tok: awsResource(appConfigMod, "DeploymentStrategy")},
			"aws_appconfig_environment":                  {Tok: awsResource(appConfigMod, "Environment")},
			"aws_appconfig_hosted_configuration_version": {Tok: awsResource(appConfigMod, "HostedConfigurationVersion")},
			"aws_appconfig_deployment":                   {Tok: awsResource(appConfigMod, "Deployment")},
			"aws_appconfig_extension":                    {Tok: awsResource(appConfigMod, "Extension")},
			"aws_appconfig_extension_association":        {Tok: awsResource(appConfigMod, "ExtensionAssociation")},

			// AppIntegrations
			"aws_appintegrations_event_integration": {Tok: awsResource(appConfigMod, "EventIntegration")},

			// Application Insights
			"aws_applicationinsights_application": {Tok: awsResource(applicationInsightsMod, "Application")},

			// AppStream
			"aws_appstream_stack":                   {Tok: awsResource(appStreamMod, "Stack")},
			"aws_appstream_fleet":                   {Tok: awsResource(appStreamMod, "Fleet")},
			"aws_appstream_image_builder":           {Tok: awsResource(appStreamMod, "ImageBuilder")},
			"aws_appstream_directory_config":        {Tok: awsResource(appStreamMod, "DirectoryConfig")},
			"aws_appstream_fleet_stack_association": {Tok: awsResource(appStreamMod, "FleetStackAssociation")},
			"aws_appstream_user_stack_association":  {Tok: awsResource(appStreamMod, "UserStackAssociation")},
			"aws_appstream_user":                    {Tok: awsResource(appStreamMod, "User")},

			// mwaa
			"aws_mwaa_environment": {Tok: awsResource(mwaaMod, "Environment")},

			// apprunner
			"aws_apprunner_auto_scaling_configuration_version": {Tok: awsResource(appRunnerMod, "AutoScalingConfigurationVersion")},
			"aws_apprunner_connection":                         {Tok: awsResource(appRunnerMod, "Connection")},
			"aws_apprunner_custom_domain_association":          {Tok: awsResource(appRunnerMod, "CustomDomainAssociation")},
			"aws_apprunner_service":                            {Tok: awsResource(appRunnerMod, "Service")},
			"aws_apprunner_vpc_connector":                      {Tok: awsResource(appRunnerMod, "VpcConnector")},
			"aws_apprunner_vpc_ingress_connection":             {Tok: awsResource(appRunnerMod, "VpcIngressConnection")},
			"aws_apprunner_observability_configuration":        {Tok: awsResource(appRunnerMod, "ObservabilityConfiguration")},

			// scheduler
			"aws_scheduler_schedule":       {Tok: awsResource(schedulerMod, "Schedule")},
			"aws_scheduler_schedule_group": {Tok: awsResource(schedulerMod, "ScheduleGroup")},

			// controlTower
			"aws_controltower_control": {Tok: awsResource(controlTowerMod, "ControlTowerControl")},

			// rbin
			"aws_rbin_rule": {Tok: awsResource(rbinMod, "Rule")},

			// vpclattice
			"aws_vpclattice_service":                             {Tok: awsResource(vpclatticeMod, "Service")},
			"aws_vpclattice_service_network":                     {Tok: awsResource(vpclatticeMod, "ServiceNetwork")},
			"aws_vpclattice_service_network_service_association": {Tok: awsResource(vpclatticeMod, "ServiceNetworkServiceAssociation")},
			"aws_vpclattice_service_network_vpc_association":     {Tok: awsResource(vpclatticeMod, "ServiceNetworkVpcAssociation")},
			"aws_vpclattice_target_group":                        {Tok: awsResource(vpclatticeMod, "TargetGroup")},
			"aws_vpclattice_listener":                            {Tok: awsResource(vpclatticeMod, "Listener")},
			"aws_vpclattice_listener_rule":                       {Tok: awsResource(vpclatticeMod, "ListenerRule")},
		},
		ExtraTypes: map[string]schema.ComplexTypeSpec{
			"aws:index/Region:Region": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Type:        "string",
					Description: "A Region represents any valid Amazon region that may be targeted with deployments.",
				},
				Enum: []schema.EnumValueSpec{
					{Value: "af-south-1", Name: "AFSouth1"},
					{Value: "ap-east-1", Name: "APEast1"},
					{Value: "ap-northeast-1", Name: "APNortheast1"},
					{Value: "ap-northeast-2", Name: "APNortheast2"},
					{Value: "ap-northeast-3", Name: "APNortheast3"},
					{Value: "ap-south-1", Name: "APSouth1"},
					{Value: "ap-south-2", Name: "APSouth2"},
					{Value: "ap-southeast-1", Name: "APSoutheast1"},
					{Value: "ap-southeast-2", Name: "APSoutheast2"},
					{Value: "ap-southeast-3", Name: "APSoutheast3"},
					{Value: "ap-southeast-4", Name: "APSoutheast4"},
					{Value: "ca-central-1", Name: "CACentral"},
					{Value: "ca-west-1", Name: "CAWest1"},
					{Value: "cn-north-1", Name: "CNNorth1"},
					{Value: "cn-northwest-1", Name: "CNNorthwest1"},
					{Value: "eu-central-1", Name: "EUCentral1"},
					{Value: "eu-central-2", Name: "EUCentral2"},
					{Value: "eu-north-1", Name: "EUNorth1"},
					{Value: "eu-south-1", Name: "EUSouth1"},
					{Value: "eu-south-2", Name: "EUSouth2"},
					{Value: "eu-west-1", Name: "EUWest1"},
					{Value: "eu-west-2", Name: "EUWest2"},
					{Value: "eu-west-3", Name: "EUWest3"},
					{Value: "me-central-1", Name: "MECentral1"},
					{Value: "me-south-1", Name: "MESouth1"},
					{Value: "sa-east-1", Name: "SAEast1"},
					{Value: "us-gov-east-1", Name: "USGovEast1"},
					{Value: "us-gov-west-1", Name: "USGovWest1"},
					{Value: "us-east-1", Name: "USEast1"},
					{Value: "us-east-2", Name: "USEast2"},
					{Value: "us-west-1", Name: "USWest1"},
					{Value: "us-west-2", Name: "USWest2"},
				},
			},
			"aws:autoscaling/MetricsGranularity:MetricsGranularity": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Type:        "string",
					Description: "See https://docs.aws.amazon.com/autoscaling/ec2/APIReference/API_EnableMetricsCollection.html",
				},
				Enum: []schema.EnumValueSpec{
					{Value: "1Minute", Name: "OneMinute"},
				},
			},
			"aws:autoscaling/Metric:Metric": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Type:        "string",
					Description: "See https://docs.aws.amazon.com/autoscaling/ec2/APIReference/API_EnableMetricsCollection.html",
				},
				Enum: []schema.EnumValueSpec{
					{Value: "GroupMinSize"},
					{Value: "GroupMaxSize"},
					{Value: "GroupDesiredCapacity"},
					{Value: "GroupInServiceInstances"},
					{Value: "GroupInServiceCapacity"},
					{Value: "GroupPendingInstances"},
					{Value: "GroupPendingCapacity"},
					{Value: "GroupStandbyInstances"},
					{Value: "GroupStandbyCapacity"},
					{Value: "GroupTerminatingInstances"},
					{Value: "GroupTerminatingCapacity"},
					{Value: "GroupTotalInstances"},
					{Value: "GroupTotalCapacity"},
					{Value: "WarmPoolDesiredCapacity"},
					{Value: "WarmPoolWarmedCapacity"},
					{Value: "WarmPoolPendingCapacity"},
					{Value: "WarmPoolTerminatingCapacity"},
					{Value: "WarmPoolTotalCapacity"},
					{Value: "GroupAndWarmPoolDesiredCapacity"},
					{Value: "GroupAndWarmPoolTotalCapacity"},
				},
			},
			"aws:autoscaling/NotificationType:NotificationType": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Type:        "string",
					Description: "See https://docs.aws.amazon.com/autoscaling/ec2/APIReference/API_NotificationConfiguration.html",
				},
				Enum: []schema.EnumValueSpec{
					{Name: "InstanceLaunch", Value: "autoscaling:EC2_INSTANCE_LAUNCH"},
					{Name: "InstanceTerminate", Value: "autoscaling:EC2_INSTANCE_TERMINATE"},
					{Name: "InstanceLaunchError", Value: "autoscaling:EC2_INSTANCE_LAUNCH_ERROR"},
					{Name: "InstanceTerminateError", Value: "autoscaling:EC2_INSTANCE_TERMINATE_ERROR"},
					{Name: "TestNotification", Value: "autoscaling:TEST_NOTIFICATION"},
				},
			},
			"aws:alb/IpAddressType:IpAddressType": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Type: "string",
				},
				Enum: []schema.EnumValueSpec{
					{Name: "Ipv4", Value: "ipv4"},
					{Name: "Dualstack", Value: "dualstack"},
				},
			},
			"aws:alb/LoadBalancerType:LoadBalancerType": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Type: "string",
				},
				Enum: []schema.EnumValueSpec{
					{Name: "Application", Value: "application"},
					{Name: "Network", Value: "network"},
				},
			},
			"aws:applicationloadbalancing/IpAddressType:IpAddressType": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Type: "string",
				},
				Enum: []schema.EnumValueSpec{
					{Name: "Ipv4", Value: "ipv4"},
					{Name: "Dualstack", Value: "dualstack"},
				},
			},
			"aws:applicationloadbalancing/LoadBalancerType:LoadBalancerType": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Type: "string",
				},
				Enum: []schema.EnumValueSpec{
					{Name: "Application", Value: "application"},
					{Name: "Network", Value: "network"},
				},
			},
			"aws:ec2/InstancePlatform:InstancePlatform": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Type: "string",
				},
				Enum: []schema.EnumValueSpec{
					{Name: "LinuxUnix", Value: "Linux/UNIX"},
					{Name: "RedHatEnterpriseLinux", Value: "Red Hat Enterprise Linux"},
					{Name: "SuseLinux", Value: "SUSE Linux"},
					{Name: "Windows", Value: "Windows"},
					{Name: "WindowsWithSqlServer", Value: "Windows with SQL Server"},
					{Name: "WindowsWithSqlServerEnterprise", Value: "Windows with SQL Server Enterprise"},
					{Name: "WindowsWithSqlServerStandard", Value: "Windows with SQL Server Standard"},
					{Name: "WindowsWithSqlServerWeb", Value: "Windows with SQL Server Web"},
				},
			},
			"aws:ec2/InstanceType:InstanceType": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Type: "string",
				},
				Enum: []schema.EnumValueSpec{
					{Name: "A1_2XLarge", Value: "a1.2xlarge"},
					{Name: "A1_4XLarge", Value: "a1.4xlarge"},
					{Name: "A1_Large", Value: "a1.large"},
					{Name: "A1_Medium", Value: "a1.medium"},
					{Name: "A1_Metal", Value: "a1.metal"},
					{Name: "A1_XLarge", Value: "a1.xlarge"},
					{Name: "C1_Medium", Value: "c1.medium"},
					{Name: "C1_XLarge", Value: "c1.xlarge"},
					{Name: "C3_2XLarge", Value: "c3.2xlarge"},
					{Name: "C3_4XLarge", Value: "c3.4xlarge"},
					{Name: "C3_8XLarge", Value: "c3.8xlarge"},
					{Name: "C3_Large", Value: "c3.large"},
					{Name: "C3_XLarge", Value: "c3.xlarge"},
					{Name: "C4_2XLarge", Value: "c4.2xlarge"},
					{Name: "C4_4XLarge", Value: "c4.4xlarge"},
					{Name: "C4_8XLarge", Value: "c4.8xlarge"},
					{Name: "C4_Large", Value: "c4.large"},
					{Name: "C4_XLarge", Value: "c4.xlarge"},
					{Name: "C5_12XLarge", Value: "c5.12xlarge"},
					{Name: "C5_18XLarge", Value: "c5.18xlarge"},
					{Name: "C5_24XLarge", Value: "c5.24xlarge"},
					{Name: "C5_2XLarge", Value: "c5.2xlarge"},
					{Name: "C5_4XLarge", Value: "c5.4xlarge"},
					{Name: "C5_9XLarge", Value: "c5.9xlarge"},
					{Name: "C5_Large", Value: "c5.large"},
					{Name: "C5_Metal", Value: "c5.metal"},
					{Name: "C5_XLarge", Value: "c5.xlarge"},
					{Name: "C5a_12XLarge", Value: "c5a.12xlarge"},
					{Name: "C5a_16XLarge", Value: "c5a.16xlarge"},
					{Name: "C5a_24XLarge", Value: "c5a.24xlarge"},
					{Name: "C5a_2XLarge", Value: "c5a.2xlarge"},
					{Name: "C5a_4XLarge", Value: "c5a.4xlarge"},
					{Name: "C5a_8XLarge", Value: "c5a.8xlarge"},
					{Name: "C5a_Large", Value: "c5a.large"},
					{Name: "C5a_XLarge", Value: "c5a.xlarge"},
					{Name: "C5ad_12XLarge", Value: "c5ad.12xlarge"},
					{Name: "C5ad_16XLarge", Value: "c5ad.16xlarge"},
					{Name: "C5ad_24XLarge", Value: "c5ad.24xlarge"},
					{Name: "C5ad_2XLarge", Value: "c5ad.2xlarge"},
					{Name: "C5ad_4XLarge", Value: "c5ad.4xlarge"},
					{Name: "C5ad_8XLarge", Value: "c5ad.8xlarge"},
					{Name: "C5ad_Large", Value: "c5ad.large"},
					{Name: "C5ad_XLarge", Value: "c5ad.xlarge"},
					{Name: "C5d_12XLarge", Value: "c5d.12xlarge"},
					{Name: "C5d_18XLarge", Value: "c5d.18xlarge"},
					{Name: "C5d_24XLarge", Value: "c5d.24xlarge"},
					{Name: "C5d_2XLarge", Value: "c5d.2xlarge"},
					{Name: "C5d_4XLarge", Value: "c5d.4xlarge"},
					{Name: "C5d_9XLarge", Value: "c5d.9xlarge"},
					{Name: "C5d_Large", Value: "c5d.large"},
					{Name: "C5d_Metal", Value: "c5d.metal"},
					{Name: "C5d_XLarge", Value: "c5d.xlarge"},
					{Name: "C5n_18XLarge", Value: "c5n.18xlarge"},
					{Name: "C5n_2XLarge", Value: "c5n.2xlarge"},
					{Name: "C5n_4XLarge", Value: "c5n.4xlarge"},
					{Name: "C5n_9XLarge", Value: "c5n.9xlarge"},
					{Name: "C5n_Large", Value: "c5n.large"},
					{Name: "C5n_Metal", Value: "c5n.metal"},
					{Name: "C5n_XLarge", Value: "c5n.xlarge"},
					{Name: "C6a_Large", Value: "c6a.large"},
					{Name: "C6a_Metal", Value: "c6a.metal"},
					{Name: "C6a_XLarge", Value: "c6a.xlarge"},
					{Name: "C6a_2XLarge", Value: "c6a.2xlarge"},
					{Name: "C6a_4XLarge", Value: "c6a.4xlarge"},
					{Name: "C6a_8XLarge", Value: "c6a.8xlarge"},
					{Name: "C6a_12XLarge", Value: "c6a.12xlarge"},
					{Name: "C6a_16XLarge", Value: "c6a.16xlarge"},
					{Name: "C6a_24XLarge", Value: "c6a.24xlarge"},
					{Name: "C6a_32XLarge", Value: "c6a.32xlarge"},
					{Name: "C6a_48XLarge", Value: "c6a.48xlarge"},
					{Name: "C6g_12XLarge", Value: "c6g.12xlarge"},
					{Name: "C6g_16XLarge", Value: "c6g.16xlarge"},
					{Name: "C6g_2XLarge", Value: "c6g.2xlarge"},
					{Name: "C6g_4XLarge", Value: "c6g.4xlarge"},
					{Name: "C6g_8XLarge", Value: "c6g.8xlarge"},
					{Name: "C6g_Large", Value: "c6g.large"},
					{Name: "C6g_Medium", Value: "c6g.medium"},
					{Name: "C6g_Metal", Value: "c6g.metal"},
					{Name: "C6g_XLarge", Value: "c6g.xlarge"},
					{Name: "C6gd_12XLarge", Value: "c6gd.12xlarge"},
					{Name: "C6gd_16XLarge", Value: "c6gd.16xlarge"},
					{Name: "C6gd_2XLarge", Value: "c6gd.2xlarge"},
					{Name: "C6gd_4XLarge", Value: "c6gd.4xlarge"},
					{Name: "C6gd_8XLarge", Value: "c6gd.8xlarge"},
					{Name: "C6gd_Large", Value: "c6gd.large"},
					{Name: "C6gd_Medium", Value: "c6gd.medium"},
					{Name: "C6gd_Metal", Value: "c6gd.metal"},
					{Name: "C6gd_XLarge", Value: "c6gd.xlarge"},
					{Name: "C6i_Large", Value: "c6i.large"},
					{Name: "C6i_XLarge", Value: "c6i.xlarge"},
					{Name: "C6i_2XLarge", Value: "c6i.2xlarge"},
					{Name: "C6i_4XLarge", Value: "c6i.4xlarge"},
					{Name: "C6i_8XLarge", Value: "c6i.8xlarge"},
					{Name: "C6i_12XLarge", Value: "c6i.12xlarge"},
					{Name: "C6i_16XLarge", Value: "c6i.16xlarge"},
					{Name: "C6i_24XLarge", Value: "c6i.24xlarge"},
					{Name: "C6i_32XLarge", Value: "c6i.32xlarge"},
					{Name: "C6i_Metal", Value: "c6i.metal"},
					{Name: "C6id_Large", Value: "c6id.large"},
					{Name: "C6id_XLarge", Value: "c6id.xlarge"},
					{Name: "C6id_2XLarge", Value: "c6id.2xlarge"},
					{Name: "C6id_4XLarge", Value: "c6id.4xlarge"},
					{Name: "C6id_8XLarge", Value: "c6id.8xlarge"},
					{Name: "C6id_12XLarge", Value: "c6id.12xlarge"},
					{Name: "C6id_16XLarge", Value: "c6id.16xlarge"},
					{Name: "C6id_24XLarge", Value: "c6id.24xlarge"},
					{Name: "C6id_32XLarge", Value: "c6id.32xlarge"},
					{Name: "C6id_Metal", Value: "c6id.metal"},
					{Name: "C7a_Medium", Value: "c7a.medium"},
					{Name: "C7a_Large", Value: "c7a.large"},
					{Name: "C7a_XLarge", Value: "c7a.xlarge"},
					{Name: "C7a_2XLarge", Value: "c7a.2xlarge"},
					{Name: "C7a_4XLarge", Value: "c7a.4xlarge"},
					{Name: "C7a_8XLarge", Value: "c7a.8xlarge"},
					{Name: "C7a_12XLarge", Value: "c7a.12xlarge"},
					{Name: "C7a_16XLarge", Value: "c7a.16xlarge"},
					{Name: "C7a_24XLarge", Value: "c7a.24xlarge"},
					{Name: "C7a_32XLarge", Value: "c7a.32xlarge"},
					{Name: "C7a_48XLarge", Value: "c7a.48xlarge"},
					{Name: "C7a_Metal", Value: "c7a.metal-48xl"},
					{Name: "Cc2_8XLarge", Value: "cc2.8xlarge"},
					{Name: "D2_2XLarge", Value: "d2.2xlarge"},
					{Name: "D2_4XLarge", Value: "d2.4xlarge"},
					{Name: "D2_8XLarge", Value: "d2.8xlarge"},
					{Name: "D2_XLarge", Value: "d2.xlarge"},
					{Name: "D3_2XLarge", Value: "d3.2xlarge"},
					{Name: "D3_4XLarge", Value: "d3.4xlarge"},
					{Name: "D3_8XLarge", Value: "d3.8xlarge"},
					{Name: "D3_XLarge", Value: "d3.xlarge"},
					{Name: "D3en_12XLarge", Value: "d3en.12xlarge"},
					{Name: "D3en_2XLarge", Value: "d3en.2xlarge"},
					{Name: "D3en_4XLarge", Value: "d3en.4xlarge"},
					{Name: "D3en_6XLarge", Value: "d3en.6xlarge"},
					{Name: "D3en_8XLarge", Value: "d3en.8xlarge"},
					{Name: "D3en_XLarge", Value: "d3en.xlarge"},
					{Name: "F1_16XLarge", Value: "f1.16xlarge"},
					{Name: "F1_2XLarge", Value: "f1.2xlarge"},
					{Name: "F1_4XLarge", Value: "f1.4xlarge"},
					{Name: "G2_2XLarge", Value: "g2.2xlarge"},
					{Name: "G2_8XLarge", Value: "g2.8xlarge"},
					{Name: "G3_16XLarge", Value: "g3.16xlarge"},
					{Name: "G3_4XLarge", Value: "g3.4xlarge"},
					{Name: "G3_8XLarge", Value: "g3.8xlarge"},
					{Name: "G3s_XLarge", Value: "g3s.xlarge"},
					{Name: "G4ad_16XLarge", Value: "g4ad.16xlarge"},
					{Name: "G4ad_XLarge", Value: "g4ad.xlarge"},
					{Name: "G4ad_2XLarge", Value: "g4ad.2xlarge"},
					{Name: "G4ad_4XLarge", Value: "g4ad.4xlarge"},
					{Name: "G4ad_8XLarge", Value: "g4ad.8xlarge"},
					{Name: "G4dn_12XLarge", Value: "g4dn.12xlarge"},
					{Name: "G4dn_16XLarge", Value: "g4dn.16xlarge"},
					{Name: "G4dn_2XLarge", Value: "g4dn.2xlarge"},
					{Name: "G4dn_4XLarge", Value: "g4dn.4xlarge"},
					{Name: "G4dn_8XLarge", Value: "g4dn.8xlarge"},
					{Name: "G4dn_Metal", Value: "g4dn.metal"},
					{Name: "G4dn_XLarge", Value: "g4dn.xlarge"},
					{Name: "G5_XLarge", Value: "g5.xlarge"},
					{Name: "G5_2XLarge", Value: "g5.2xlarge"},
					{Name: "G5_4XLarge", Value: "g5.4xlarge"},
					{Name: "G5_8XLarge", Value: "g5.8xlarge"},
					{Name: "G5_12XLarge", Value: "g5.12xlarge"},
					{Name: "G5_16XLarge", Value: "g5.16xlarge"},
					{Name: "G5_24XLarge", Value: "g5.24xlarge"},
					{Name: "G5_48XLarge", Value: "g5.48xlarge"},
					{Name: "H1_16XLarge", Value: "h1.16xlarge"},
					{Name: "H1_2XLarge", Value: "h1.2xlarge"},
					{Name: "H1_4XLarge", Value: "h1.4xlarge"},
					{Name: "H1_8XLarge", Value: "h1.8xlarge"},
					{Name: "I2_2XLarge", Value: "i2.2xlarge"},
					{Name: "I2_4XLarge", Value: "i2.4xlarge"},
					{Name: "I2_8XLarge", Value: "i2.8xlarge"},
					{Name: "I2_XLarge", Value: "i2.xlarge"},
					{Name: "I3_16XLarge", Value: "i3.16xlarge"},
					{Name: "I3_2XLarge", Value: "i3.2xlarge"},
					{Name: "I3_4XLarge", Value: "i3.4xlarge"},
					{Name: "I3_8XLarge", Value: "i3.8xlarge"},
					{Name: "I3_Large", Value: "i3.large"},
					{Name: "I3_XLarge", Value: "i3.xlarge"},
					{Name: "I3_Metal", Value: "i3.metal"},
					{Name: "I3en_12XLarge", Value: "i3en.12xlarge"},
					{Name: "I3en_24XLarge", Value: "i3en.24xlarge"},
					{Name: "I3en_2XLarge", Value: "i3en.2xlarge"},
					{Name: "I3en_3XLarge", Value: "i3en.3xlarge"},
					{Name: "I3en_6XLarge", Value: "i3en.6xlarge"},
					{Name: "I3en_Large", Value: "i3en.large"},
					{Name: "I3en_Metal", Value: "i3en.metal"},
					{Name: "I3en_XLarge", Value: "i3en.xlarge"},
					{Name: "Inf1_24XLarge", Value: "inf1.24xlarge"},
					{Name: "Inf1_2XLarge", Value: "inf1.2xlarge"},
					{Name: "Inf1_6XLarge", Value: "inf1.6xlarge"},
					{Name: "Inf1_XLarge", Value: "inf1.xlarge"},
					{Name: "M1_Large", Value: "m1.large"},
					{Name: "M1_Medium", Value: "m1.medium"},
					{Name: "M1_Small", Value: "m1.small"},
					{Name: "M1_XLarge", Value: "m1.xlarge"},
					{Name: "M2_2XLarge", Value: "m2.2xlarge"},
					{Name: "M2_4XLarge", Value: "m2.4xlarge"},
					{Name: "M2_XLarge", Value: "m2.xlarge"},
					{Name: "M3_2XLarge", Value: "m3.2xlarge"},
					{Name: "M3_Large", Value: "m3.large"},
					{Name: "M3_Medium", Value: "m3.medium"},
					{Name: "M3_XLarge", Value: "m3.xlarge"},
					{Name: "M4_10XLarge", Value: "m4.10xlarge"},
					{Name: "M4_16XLarge", Value: "m4.16xlarge"},
					{Name: "M4_2XLarge", Value: "m4.2xlarge"},
					{Name: "M4_4XLarge", Value: "m4.4xlarge"},
					{Name: "M4_Large", Value: "m4.large"},
					{Name: "M4_XLarge", Value: "m4.xlarge"},
					{Name: "M5_12XLarge", Value: "m5.12xlarge"},
					{Name: "M5_16XLarge", Value: "m5.16xlarge"},
					{Name: "M5_24XLarge", Value: "m5.24xlarge"},
					{Name: "M5_2XLarge", Value: "m5.2xlarge"},
					{Name: "M5_4XLarge", Value: "m5.4xlarge"},
					{Name: "M5_8XLarge", Value: "m5.8xlarge"},
					{Name: "M5_Large", Value: "m5.large"},
					{Name: "M5_Metal", Value: "m5.metal"},
					{Name: "M5_XLarge", Value: "m5.xlarge"},
					{Name: "M5a_12XLarge", Value: "m5a.12xlarge"},
					{Name: "M5a_16XLarge", Value: "m5a.16xlarge"},
					{Name: "M5a_24XLarge", Value: "m5a.24xlarge"},
					{Name: "M5a_2XLarge", Value: "m5a.2xlarge"},
					{Name: "M5a_4XLarge", Value: "m5a.4xlarge"},
					{Name: "M5a_8XLarge", Value: "m5a.8xlarge"},
					{Name: "M5a_Large", Value: "m5a.large"},
					{Name: "M5a_XLarge", Value: "m5a.xlarge"},
					{Name: "M5ad_12XLarge", Value: "m5ad.12xlarge"},
					{Name: "M5ad_16XLarge", Value: "m5ad.16xlarge"},
					{Name: "M5ad_24XLarge", Value: "m5ad.24xlarge"},
					{Name: "M5ad_2XLarge", Value: "m5ad.2xlarge"},
					{Name: "M5ad_4XLarge", Value: "m5ad.4xlarge"},
					{Name: "M5ad_8XLarge", Value: "m5ad.8xlarge"},
					{Name: "M5ad_Large", Value: "m5ad.large"},
					{Name: "M5as_XLarge", Value: "m5ad.xlarge"},
					{Name: "M5d_12XLarge", Value: "m5d.12xlarge"},
					{Name: "M5d_16XLarge", Value: "m5d.16xlarge"},
					{Name: "M5d_24XLarge", Value: "m5d.24xlarge"},
					{Name: "M5d_2XLarge", Value: "m5d.2xlarge"},
					{Name: "M5d_4XLarge", Value: "m5d.4xlarge"},
					{Name: "M5d_8XLarge", Value: "m5d.8xlarge"},
					{Name: "M5d_Large", Value: "m5d.large"},
					{Name: "M5d_Metal", Value: "m5d.metal"},
					{Name: "M5d_XLarge", Value: "m5d.xlarge"},
					{Name: "M5dn_12XLarge", Value: "m5dn.12xlarge"},
					{Name: "M5dn_16XLarge", Value: "m5dn.16xlarge"},
					{Name: "M5dn_24XLarge", Value: "m5dn.24xlarge"},
					{Name: "M5dn_2XLarge", Value: "m5dn.2xlarge"},
					{Name: "M5dn_4XLarge", Value: "m5dn.4xlarge"},
					{Name: "M5dn_8XLarge", Value: "m5dn.8xlarge"},
					{Name: "M5dn_Large", Value: "m5dn.large"},
					{Name: "M5dn_XLarge", Value: "m5dn.xlarge"},
					{Name: "M5n_12XLarge", Value: "m5n.12xlarge"},
					{Name: "M5n_16XLarge", Value: "m5n.16xlarge"},
					{Name: "M5n_24XLarge", Value: "m5n.24xlarge"},
					{Name: "M5n_2XLarge", Value: "m5n.2xlarge"},
					{Name: "M5n_4XLarge", Value: "m5n.4xlarge"},
					{Name: "M5n_8XLarge", Value: "m5n.8xlarge"},
					{Name: "M5n_Large", Value: "m5n.large"},
					{Name: "M5n_XLarge", Value: "m5n.xlarge"},
					{Name: "M5zn_12XLarge", Value: "m5zn.12xlarge"},
					{Name: "M5zn_2XLarge", Value: "m5zn.2xlarge"},
					{Name: "M5zn_3XLarge", Value: "m5zn.3xlarge"},
					{Name: "M5zn_6XLarge", Value: "m5zn.6xlarge"},
					{Name: "M5zn_Large", Value: "m5zn.large"},
					{Name: "M5zn_Metal", Value: "m5zn.metal"},
					{Name: "M5zn_XLarge", Value: "m5zn.xlarge"},

					{Name: "M6a_Large", Value: "m6a.large"},
					{Name: "M6a_Metal", Value: "m6a.metal"},
					{Name: "M6a_XLarge", Value: "m6a.xlarge"},
					{Name: "M6a_2XLarge", Value: "m6a.2xlarge"},
					{Name: "M6a_4XLarge", Value: "m6a.4xlarge"},
					{Name: "M6a_8XLarge", Value: "m6a.8xlarge"},
					{Name: "M6a_12XLarge", Value: "m6a.12xlarge"},
					{Name: "M6a_16XLarge", Value: "m6a.16xlarge"},
					{Name: "M6a_24XLarge", Value: "m6a.24xlarge"},
					{Name: "M6a_32XLarge", Value: "m6a.32xlarge"},
					{Name: "M6a_48XLarge", Value: "m6a.48xlarge"},
					{Name: "M6g_12XLarge", Value: "m6g.12xlarge"},
					{Name: "M6g_16XLarge", Value: "m6g.16xlarge"},
					{Name: "M6g_2XLarge", Value: "m6g.2xlarge"},
					{Name: "M6g_4XLarge", Value: "m6g.4xlarge"},
					{Name: "M6g_8XLarge", Value: "m6g.8xlarge"},
					{Name: "M6g_Large", Value: "m6g.large"},
					{Name: "M6g_Medium", Value: "m6g.medium"},
					{Name: "M6g_Metal", Value: "m6g.metal"},
					{Name: "M6g_XLarge", Value: "m6g.xlarge"},
					{Name: "M6gd_12XLarge", Value: "m6gd.12xlarge"},
					{Name: "M6gd_16XLarge", Value: "m6gd.16xlarge"},
					{Name: "M6gd_2XLarge", Value: "m6gd.2xlarge"},
					{Name: "M6gd_4XLarge", Value: "m6gd.4xlarge"},
					{Name: "M6gd_8XLarge", Value: "m6gd.8xlarge"},
					{Name: "M6gd_Large", Value: "m6gd.large"},
					{Name: "M6gd_Medium", Value: "m6gd.medium"},
					{Name: "M6gd_Metal", Value: "m6gd.metal"},
					{Name: "M6gd_XLarge", Value: "m6gd.xlarge"},
					{Name: "M6i_Large", Value: "m6i.large"},
					{Name: "M6i_XLarge", Value: "m6i.xlarge"},
					{Name: "M6i_2XLarge", Value: "m6i.2xlarge"},
					{Name: "M6i_4XLarge", Value: "m6i.4xlarge"},
					{Name: "M6i_8XLarge", Value: "m6i.8xlarge"},
					{Name: "M6i_12XLarge", Value: "m6i.12xlarge"},
					{Name: "M6i_16XLarge", Value: "m6i.16xlarge"},
					{Name: "M6i_24XLarge", Value: "m6i.24xlarge"},
					{Name: "M6i_32XLarge", Value: "m6i.32xlarge"},
					{Name: "M6i_Metal", Value: "m6i.metal"},
					{Name: "M6id_Large", Value: "m6id.large"},
					{Name: "M6id_XLarge", Value: "m6id.xlarge"},
					{Name: "M6id_2XLarge", Value: "m6id.2xlarge"},
					{Name: "M6id_4XLarge", Value: "m6id.4xlarge"},
					{Name: "M6id_8XLarge", Value: "m6id.8xlarge"},
					{Name: "M6id_12XLarge", Value: "m6id.12xlarge"},
					{Name: "M6id_16XLarge", Value: "m6id.16xlarge"},
					{Name: "M6id_24XLarge", Value: "m6id.24xlarge"},
					{Name: "M6id_32XLarge", Value: "m6id.32xlarge"},
					{Name: "M6id_Metal", Value: "m6id.metal"},
					{Name: "M7a_Medium", Value: "m7a.medium"},
					{Name: "M7a_Large", Value: "m7a.large"},
					{Name: "M7a_XLarge", Value: "m7a.xlarge"},
					{Name: "M7a_2XLarge", Value: "m7a.2xlarge"},
					{Name: "M7a_4XLarge", Value: "m7a.4xlarge"},
					{Name: "M7a_8XLarge", Value: "m7a.8xlarge"},
					{Name: "M7a_12XLarge", Value: "m7a.12xlarge"},
					{Name: "M7a_16XLarge", Value: "m7a.16xlarge"},
					{Name: "M7a_24XLarge", Value: "m7a.24xlarge"},
					{Name: "M7a_32XLarge", Value: "m7a.32xlarge"},
					{Name: "M7a_48XLarge", Value: "m7a.48xlarge"},
					{Name: "M7a_Metal", Value: "m7a.metal-48xl"},
					{Name: "Mac1_Metal", Value: "mac1.metal"},
					{Name: "P2_16XLarge", Value: "p2.16xlarge"},
					{Name: "P2_8XLarge", Value: "p2.8xlarge"},
					{Name: "P2_XLarge", Value: "p2.xlarge"},
					{Name: "P3_16XLarge", Value: "p3.16xlarge"},
					{Name: "P3_2XLarge", Value: "p3.2xlarge"},
					{Name: "P3_8XLarge", Value: "p3.8xlarge"},
					{Name: "P3dn_24XLarge", Value: "p3dn.24xlarge"},
					{Name: "P4d_24XLarge", Value: "p4d.24xlarge"},
					{Name: "R3_2XLarge", Value: "r3.2xlarge"},
					{Name: "R3_4XLarge", Value: "r3.4xlarge"},
					{Name: "R3_8XLarge", Value: "r3.8xlarge"},
					{Name: "R3_Large", Value: "r3.large"},
					{Name: "R3_XLarge", Value: "r3.xlarge"},
					{Name: "R4_16XLarge", Value: "r4.16xlarge"},
					{Name: "R4_2XLarge", Value: "r4.2xlarge"},
					{Name: "R4_4XLarge", Value: "r4.4xlarge"},
					{Name: "R4_8XLarge", Value: "r4.8xlarge"},
					{Name: "R4_Large", Value: "r4.large"},
					{Name: "R4_XLarge", Value: "r4.xlarge"},
					{Name: "R5_12XLarge", Value: "r5.12xlarge"},
					{Name: "R5_16XLarge", Value: "r5.16xlarge"},
					{Name: "R5_24XLarge", Value: "r5.24xlarge"},
					{Name: "R5_2XLarge", Value: "r5.2xlarge"},
					{Name: "R5_4XLarge", Value: "r5.4xlarge"},
					{Name: "R5_8XLarge", Value: "r5.8xlarge"},
					{Name: "R5_Large", Value: "r5.large"},
					{Name: "R5_Metal", Value: "r5.metal"},
					{Name: "R5_XLarge", Value: "r5.xlarge"},
					{Name: "R5a_12XLarge", Value: "r5a.12xlarge"},
					{Name: "R5a_16XLarge", Value: "r5a.16xlarge"},
					{Name: "R5a_24XLarge", Value: "r5a.24xlarge"},
					{Name: "R5a_2XLarge", Value: "r5a.2xlarge"},
					{Name: "R5a_4XLarge", Value: "r5a.4xlarge"},
					{Name: "R5a_8XLarge", Value: "r5a.8xlarge"},
					{Name: "R5a_Large", Value: "r5a.large"},
					{Name: "R5a_XLarge", Value: "r5a.xlarge"},
					{Name: "R5ad_12XLarge", Value: "r5ad.12xlarge"},
					{Name: "R5ad_16XLarge", Value: "r5ad.16xlarge"},
					{Name: "R5ad_24XLarge", Value: "r5ad.24xlarge"},
					{Name: "R5ad_2XLarge", Value: "r5ad.2xlarge"},
					{Name: "R5ad_4XLarge", Value: "r5ad.4xlarge"},
					{Name: "R5ad_8XLarge", Value: "r5ad.8xlarge"},
					{Name: "R5ad_Large", Value: "r5ad.large"},
					{Name: "R5ad_XLarge", Value: "r5ad.xlarge"},
					{Name: "R5b_12XLarge", Value: "r5b.12xlarge"},
					{Name: "R5b_16XLarge", Value: "r5b.16xlarge"},
					{Name: "R5b_24XLarge", Value: "r5b.24xlarge"},
					{Name: "R5b_2XLarge", Value: "r5b.2xlarge"},
					{Name: "R5b_4XLarge", Value: "r5b.4xlarge"},
					{Name: "R5b_8XLarge", Value: "r5b.8xlarge"},
					{Name: "R5b_Large", Value: "r5b.large"},
					{Name: "R5b_Metal", Value: "r5b.metal"},
					{Name: "R5b_XLarge", Value: "r5b.xlarge"},
					{Name: "R5d_12XLarge", Value: "r5d.12xlarge"},
					{Name: "R5d_16XLarge", Value: "r5d.16xlarge"},
					{Name: "R5d_24XLarge", Value: "r5d.24xlarge"},
					{Name: "R5d_2XLarge", Value: "r5d.2xlarge"},
					{Name: "R5d_4XLarge", Value: "r5d.4xlarge"},
					{Name: "R5d_8XLarge", Value: "r5d.8xlarge"},
					{Name: "R5d_Large", Value: "r5d.large"},
					{Name: "R5d_Metal", Value: "r5d.metal"},
					{Name: "R5d_XLarge", Value: "r5d.xlarge"},
					{Name: "R5dn_12XLarge", Value: "r5dn.12xlarge"},
					{Name: "R5dn_16XLarge", Value: "r5dn.16xlarge"},
					{Name: "R5dn_24XLarge", Value: "r5dn.24xlarge"},
					{Name: "R5dn_2XLarge", Value: "r5dn.2xlarge"},
					{Name: "R5dn_4XLarge", Value: "r5dn.4xlarge"},
					{Name: "R5dn_8XLarge", Value: "r5dn.8xlarge"},
					{Name: "R5dn_Large", Value: "r5dn.large"},
					{Name: "R5dn_XLarge", Value: "r5dn.xlarge"},
					{Name: "R5dn_Metal", Value: "r5dn.metal"},
					{Name: "R5n_12XLarge", Value: "r5n.12xlarge"},
					{Name: "R5n_16XLarge", Value: "r5n.16xlarge"},
					{Name: "R5n_24XLarge", Value: "r5n.24xlarge"},
					{Name: "R5n_2XLarge", Value: "r5n.2xlarge"},
					{Name: "R5n_4XLarge", Value: "r5n.4xlarge"},
					{Name: "R5n_8XLarge", Value: "r5n.8xlarge"},
					{Name: "R5n_Large", Value: "r5n.large"},
					{Name: "R5n_XLarge", Value: "r5n.xlarge"},
					{Name: "R6g_12XLarge", Value: "r6g.12xlarge"},
					{Name: "R6g_16XLarge", Value: "r6g.16xlarge"},
					{Name: "R6g_2XLarge", Value: "r6g.2xlarge"},
					{Name: "R6g_4XLarge", Value: "r6g.4xlarge"},
					{Name: "R6g_8XLarge", Value: "r6g.8xlarge"},
					{Name: "R6g_Large", Value: "r6g.large"},
					{Name: "R6g_Medium", Value: "r6g.medium"},
					{Name: "R6g_Metal", Value: "r6g.metal"},
					{Name: "R6g_XLarge", Value: "r6g.xlarge"},
					{Name: "R6gd_12XLarge", Value: "r6gd.12xlarge"},
					{Name: "R6gd_16XLarge", Value: "r6gd.16xlarge"},
					{Name: "R6gd_2XLarge", Value: "r6gd.2xlarge"},
					{Name: "R6gd_4XLarge", Value: "r6gd.4xlarge"},
					{Name: "R6gd_8XLarge", Value: "r6gd.8xlarge"},
					{Name: "R6gd_Large", Value: "r6gd.large"},
					{Name: "R6gd_Medium", Value: "r6gd.medium"},
					{Name: "R6gd_Metal", Value: "r6gd.metal"},
					{Name: "R6gd_XLarge", Value: "r6gd.xlarge"},
					{Name: "R6i_Large", Value: "r6i.large"},
					{Name: "R6i_XLarge", Value: "r6i.xlarge"},
					{Name: "R6i_2XLarge", Value: "r6i.2xlarge"},
					{Name: "R6i_4XLarge", Value: "r6i.4xlarge"},
					{Name: "R6i_8XLarge", Value: "r6i.8xlarge"},
					{Name: "R6i_12XLarge", Value: "r6i.12xlarge"},
					{Name: "R6i_16XLarge", Value: "r6i.16xlarge"},
					{Name: "R6i_24XLarge", Value: "r6i.24xlarge"},
					{Name: "R6i_32XLarge", Value: "r6i.32xlarge"},
					{Name: "R6i_Metal", Value: "r6i.metal"},
					{Name: "R6id_Large", Value: "r6id.large"},
					{Name: "R6id_XLarge", Value: "r6id.xlarge"},
					{Name: "R6id_2XLarge", Value: "r6id.2xlarge"},
					{Name: "R6id_4XLarge", Value: "r6id.4xlarge"},
					{Name: "R6id_8XLarge", Value: "r6id.8xlarge"},
					{Name: "R6id_12XLarge", Value: "r6id.12xlarge"},
					{Name: "R6id_16XLarge", Value: "r6id.16xlarge"},
					{Name: "R6id_24XLarge", Value: "r6id.24xlarge"},
					{Name: "R6id_32XLarge", Value: "r6id.32xlarge"},
					{Name: "R6id_Metal", Value: "r6id.metal"},
					{Name: "T1_Micro", Value: "t1.micro"},
					{Name: "T2_2XLarge", Value: "t2.2xlarge"},
					{Name: "T2_Large", Value: "t2.large"},
					{Name: "T2_Medium", Value: "t2.medium"},
					{Name: "T2_Micro", Value: "t2.micro"},
					{Name: "T2_Nano", Value: "t2.nano"},
					{Name: "T2_Small", Value: "t2.small"},
					{Name: "T2_XLarge", Value: "t2.xlarge"},
					{Name: "T3_2XLarge", Value: "t3.2xlarge"},
					{Name: "T3_Large", Value: "t3.large"},
					{Name: "T3_Medium", Value: "t3.medium"},
					{Name: "T3_Micro", Value: "t3.micro"},
					{Name: "T3_Nano", Value: "t3.nano"},
					{Name: "T3_Small", Value: "t3.small"},
					{Name: "T3_XLarge", Value: "t3.xlarge"},
					{Name: "T3a_2XLarge", Value: "t3a.2xlarge"},
					{Name: "T3a_Large", Value: "t3a.large"},
					{Name: "T3a_Medium", Value: "t3a.medium"},
					{Name: "T3a_Micro", Value: "t3a.micro"},
					{Name: "T3a_Nano", Value: "t3a.nano"},
					{Name: "T3a_Small", Value: "t3a.small"},
					{Name: "T3a_XLarge", Value: "t3a.xlarge"},
					{Name: "T4g_2XLarge", Value: "t4g.2xlarge"},
					{Name: "T4g_Large", Value: "t4g.large"},
					{Name: "T4g_Medium", Value: "t4g.medium"},
					{Name: "T4g_Micro", Value: "t4g.micro"},
					{Name: "T4g_Nano", Value: "t4g.nano"},
					{Name: "T4g_Small", Value: "t4g.small"},
					{Name: "T4g_XLarge", Value: "t4g.xlarge"},
					{Name: "X1_16XLarge", Value: "x1.16xlarge"},
					{Name: "X1_32XLarge", Value: "x1.32xlarge"},
					{Name: "X1e_16XLarge", Value: "x1e.16xlarge"},
					{Name: "X1e_2XLarge", Value: "x1e.2xlarge"},
					{Name: "X1e_32XLarge", Value: "x1e.32xlarge"},
					{Name: "X1e_4XLarge", Value: "x1e.4xlarge"},
					{Name: "X1e_8XLarge", Value: "x1e.8xlarge"},
					{Name: "X1e_XLarge", Value: "x1e.xlarge"},
					{Name: "Z1d_12XLarge", Value: "z1d.12xlarge"},
					{Name: "Z1d_2XLarge", Value: "z1d.2xlarge"},
					{Name: "Z1d_3XLarge", Value: "z1d.3xlarge"},
					{Name: "Z1d_6XLarge", Value: "z1d.6xlarge"},
					{Name: "Z1d_Large", Value: "z1d.large"},
					{Name: "Z1d_Metal", Value: "z1d.metal"},
					{Name: "Z1d_XLarge", Value: "z1d.xlarge"},

					// Deprecated
					{Name: "U_12tb1Metal", Value: "u-12tb1.metal", DeprecationMessage: "This instancetype has been deprecated"},
					{Name: "U_6tb1Metal", Value: "u-6tb1.metal", DeprecationMessage: "This instancetype has been deprecated"},
					{Name: "U_9tb1Metal", Value: "u-9tb1.metal", DeprecationMessage: "This instancetype has been deprecated"},
					{Name: "Hs1_8XLarge", Value: "hs1.8xlarge", DeprecationMessage: "This instancetype has been deprecated"},
				},
			},
			"aws:ec2/PlacementStrategy:PlacementStrategy": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Type:        "string",
					Description: "The strategy of the placement group determines how the instances are organized within the group.\nSee https://docs.aws.amazon.com/cli/latest/reference/ec2/create-placement-group.html",
				},
				Enum: []schema.EnumValueSpec{
					{Name: "Spread", Value: "spread", Description: "A `spread` placement group places instances on distinct hardware."},
					{Name: "Cluster", Value: "cluster", Description: "A `cluster` placement group is a logical grouping of instances within a single\nAvailability Zone that benefit from low network latency, high network throughput."},
				},
			},
			"aws:ec2/ProtocolType:ProtocolType": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Type: "string",
				},
				Enum: []schema.EnumValueSpec{
					{Name: "All", Value: "all"},
					{Name: "TCP", Value: "tcp"},
					{Name: "UDP", Value: "udp"},
					{Name: "ICMP", Value: "icmp"},
				},
			},
			"aws:ec2/Tenancy:Tenancy": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Type: "string",
				},
				Enum: []schema.EnumValueSpec{
					{Name: "Default", Value: "default"},
					{Name: "Dedicated", Value: "dedicated"},
				},
			},
			"aws:iam/ManagedPolicy:ManagedPolicy": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Type: "string",
				},
				Enum: iamManagedPolicyValues(),
			},
			"aws:lambda/Runtime:Runtime": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Type:        "string",
					Description: "See https://docs.aws.amazon.com/lambda/latest/dg/lambda-runtimes.html",
				},
				Enum: []schema.EnumValueSpec{
					{Value: "dotnet6", Name: "Dotnet6"},
					{Value: "dotnet7", Name: "Dotnet7"},
					{Value: "dotnet8", Name: "Dotnet8"},
					{Value: "java11", Name: "Java11"},
					{Value: "java17", Name: "Java17"},
					{Value: "java21", Name: "Java21"},
					{Value: "java8.al2", Name: "Java8AL2"},
					{Value: "nodejs16.x", Name: "NodeJS16dX"},
					{Value: "nodejs18.x", Name: "NodeJS18dX"},
					{Value: "nodejs20.x", Name: "NodeJS20dX"},
					{Value: "provided.al2", Name: "CustomAL2"},
					{Value: "provided.al2023", Name: "CustomAL2023"},
					{Value: "python3.10", Name: "Python3d10"},
					{Value: "python3.11", Name: "Python3d11"},
					{Value: "python3.12", Name: "Python3d12"},
					{Value: "python3.8", Name: "Python3d8"},
					{Value: "python3.9", Name: "Python3d9"},
					{Value: "ruby3.2", Name: "Ruby3d2"},

					deprecateRuntime("dotnet5.0", "Dotnet5d0"),
					deprecateRuntime("dotnetcore2.1", "DotnetCore2d1"),
					deprecateRuntime("dotnetcore3.1", "DotnetCore3d1"),
					deprecateRuntime("go1.x", "Go1dx"),
					deprecateRuntime("java8", "Java8"),
					deprecateRuntime("nodejs10.x", "NodeJS10dX"),
					deprecateRuntime("nodejs12.x", "NodeJS12dX"),
					deprecateRuntime("nodejs14.x", "NodeJS14dX"),
					deprecateRuntime("provided", "Custom"),
					deprecateRuntime("python2.7", "Python2d7"),
					deprecateRuntime("python3.6", "Python3d6"),
					deprecateRuntime("python3.7", "Python3d7"),
					deprecateRuntime("ruby2.5", "Ruby2d5"),
					deprecateRuntime("ruby2.7", "Ruby2d7"),
				},
			},
			"aws:rds/EngineMode:EngineMode": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Type: "string",
				},
				Enum: []schema.EnumValueSpec{
					{Name: "Provisioned", Value: "provisioned"},
					{Name: "Serverless", Value: "serverless"},
					{Name: "ParallelQuery", Value: "parallelquery"},
					{Name: "Global", Value: "global"},
				},
			},
			"aws:rds/EngineType:EngineType": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Type: "string",
				},
				Enum: []schema.EnumValueSpec{
					{Name: "Aurora", Value: "aurora"},
					{Name: "AuroraMysql", Value: "aurora-mysql"},
					{Name: "AuroraPostgresql", Value: "aurora-postgresql"},
				},
			},
			"aws:rds/InstanceType:InstanceType": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Type: "string",
				},
				Enum: []schema.EnumValueSpec{
					{Name: "T4G_Micro", Value: "db.t4g.micro"},
					{Name: "T4G_Small", Value: "db.t4g.small"},
					{Name: "T4G_Medium", Value: "db.t4g.medium"},
					{Name: "T4G_Large", Value: "db.t4g.large"},
					{Name: "T4G_XLarge", Value: "db.t4g.xlarge"},
					{Name: "T4G_2XLarge", Value: "db.t4g.2xlarge"},
					{Name: "T3_Micro", Value: "db.t3.micro"},
					{Name: "T3_Small", Value: "db.t3.small"},
					{Name: "T3_Medium", Value: "db.t3.medium"},
					{Name: "T3_Large", Value: "db.t3.large"},
					{Name: "T3_XLarge", Value: "db.t3.xlarge"},
					{Name: "T3_2XLarge", Value: "db.t3.2xlarge"},
					{Name: "T2_Micro", Value: "db.t2.micro"},
					{Name: "T2_Small", Value: "db.t2.small"},
					{Name: "T2_Medium", Value: "db.t2.medium"},
					{Name: "T2_Large", Value: "db.t2.large"},
					{Name: "T2_XLarge", Value: "db.t2.xlarge"},
					{Name: "T2_2XLarge", Value: "db.t2.2xlarge"},
					{Name: "M1_Small", Value: "db.m1.small"},
					{Name: "M1_Medium", Value: "db.m1.medium"},
					{Name: "M1_Large", Value: "db.m1.large"},
					{Name: "M1_XLarge", Value: "db.m1.xlarge"},
					{Name: "M2_XLarge", Value: "db.m2.xlarge"},
					{Name: "M2_2XLarge", Value: "db.m2.2xlarge"},
					{Name: "M2_4XLarge", Value: "db.m2.4xlarge"},
					{Name: "M3_Medium", Value: "db.m3.medium"},
					{Name: "M3_Large", Value: "db.m3.large"},
					{Name: "M3_XLarge", Value: "db.m3.xlarge"},
					{Name: "M3_2XLarge", Value: "db.m3.2xlarge"},
					{Name: "M4_Large", Value: "db.m4.large"},
					{Name: "M4_XLarge", Value: "db.m4.xlarge"},
					{Name: "M4_2XLarge", Value: "db.m4.2xlarge"},
					{Name: "M4_4XLarge", Value: "db.m4.4xlarge"},
					{Name: "M4_10XLarge", Value: "db.m4.10xlarge"},
					{Name: "M4_16XLarge", Value: "db.m4.10xlarge"},
					{Name: "M5_Large", Value: "db.m5.large"},
					{Name: "M5_XLarge", Value: "db.m5.xlarge"},
					{Name: "M5_2XLarge", Value: "db.m5.2xlarge"},
					{Name: "M5_4XLarge", Value: "db.m5.4xlarge"},
					{Name: "M5_12XLarge", Value: "db.m5.12xlarge"},
					{Name: "M5_24XLarge", Value: "db.m5.24xlarge"},
					{Name: "M6G_Large", Value: "db.m6g.large"},
					{Name: "M6G_XLarge", Value: "db.m6g.xlarge"},
					{Name: "M6G_2XLarge", Value: "db.m6g.2xlarge"},
					{Name: "M6G_4XLarge", Value: "db.m6g.4xlarge"},
					{Name: "M6G_8XLarge", Value: "db.m6g.8xlarge"},
					{Name: "M6G_12XLarge", Value: "db.m6g.12xlarge"},
					{Name: "M6G_16XLarge", Value: "db.m6g.16xlarge"},
					{Name: "R3_Large", Value: "db.r3.large"},
					{Name: "R3_XLarge", Value: "db.r3.xlarge"},
					{Name: "R3_2XLarge", Value: "db.r3.2xlarge"},
					{Name: "R3_4XLarge", Value: "db.r3.4xlarge"},
					{Name: "R3_8XLarge", Value: "db.r3.8xlarge"},
					{Name: "R4_Large", Value: "db.r4.large"},
					{Name: "R4_XLarge", Value: "db.r4.xlarge"},
					{Name: "R4_2XLarge", Value: "db.r4.2xlarge"},
					{Name: "R4_4XLarge", Value: "db.r4.4xlarge"},
					{Name: "R4_8XLarge", Value: "db.r4.8xlarge"},
					{Name: "R4_16XLarge", Value: "db.r4.16xlarge"},
					{Name: "R5_Large", Value: "db.r5.large"},
					{Name: "R5_XLarge", Value: "db.r5.xlarge"},
					{Name: "R5_2XLarge", Value: "db.r5.2xlarge"},
					{Name: "R5_4XLarge", Value: "db.r5.4xlarge"},
					{Name: "R5_12XLarge", Value: "db.r5.12xlarge"},
					{Name: "R5_24XLarge", Value: "db.r5.24xlarge"},
					{Name: "R6G_Large", Value: "db.r6g.large"},
					{Name: "R6G_XLarge", Value: "db.r6g.xlarge"},
					{Name: "R6G_2XLarge", Value: "db.r6g.2xlarge"},
					{Name: "R6G_4XLarge", Value: "db.r6g.4xlarge"},
					{Name: "R6G_8XLarge", Value: "db.r6g.8xlarge"},
					{Name: "R6G_12XLarge", Value: "db.r6g.12xlarge"},
					{Name: "R6G_16XLarge", Value: "db.r6g.16xlarge"},
					{Name: "X1_16XLarge", Value: "db.x1.16xlarge"},
					{Name: "X1_32XLarge", Value: "db.x1.32xlarge"},
					{Name: "X1E_XLarge", Value: "db.x1e.xlarge"},
					{Name: "X1E_2XLarge", Value: "db.x1e.2xlarge"},
					{Name: "X1E_4XLarge", Value: "db.x1e.4xlarge"},
					{Name: "X1E_8XLarge", Value: "db.x1e.8xlarge"},
					{Name: "X1E_32XLarge", Value: "db.x1e.32xlarge"},
				},
			},
			"aws:rds/StorageType:StorageType": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Type: "string",
				},
				Enum: []schema.EnumValueSpec{
					{Name: "Standard", Value: "standard"},
					{Name: "GP2", Value: "gp2"},
					{Name: "GP3", Value: "gp3"},
					{Name: "IO1", Value: "io1"},
				},
			},
			"aws:route53/RecordType:RecordType": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Type: "string",
				},
				Enum: []schema.EnumValueSpec{
					{Value: "A"},
					{Value: "AAAA"},
					{Value: "CNAME"},
					{Value: "CAA"},
					{Value: "MX"},
					{Value: "NAPTR"},
					{Value: "NS"},
					{Value: "PTR"},
					{Value: "SOA"},
					{Value: "SPF"},
					{Value: "SRV"},
					{Value: "TXT"},
				},
			},
			"aws:s3/CannedAcl:CannedAcl": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Type:        "string",
					Description: "See https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html#canned-acl",
				},
				Enum: []schema.EnumValueSpec{
					{Name: "Private", Value: "private"},
					{Name: "PublicRead", Value: "public-read"},
					{Name: "PublicReadWrite", Value: "public-read-write"},
					{Name: "AwsExecRead", Value: "aws-exec-read"},
					{Name: "AuthenticatedRead", Value: "authenticated-read"},
					{Name: "BucketOwnerRead", Value: "bucket-owner-read"},
					{Name: "BucketOwnerFullControl", Value: "bucket-owner-full-control"},
					{Name: "LogDeliveryWrite", Value: "log-delivery-write"},
				},
			},
			"aws:ssm/ParameterType:ParameterType": {
				ObjectTypeSpec: schema.ObjectTypeSpec{
					Type: "string",
				},
				Enum: []schema.EnumValueSpec{
					{Value: "String"},
					{Value: "StringList"},
					{Value: "SecureString"},
				},
			},
		},
		DataSources: map[string]*tfbridge.DataSourceInfo{
			"aws_auditmanager_control": {
				Tok: awsDataSource(auditmanagerMod, "getControl"),
			},
			"aws_auditmanager_framework": {
				Tok: awsDataSource(auditmanagerMod, "getFramework"),
			},
			"aws_vpc_security_group_rule": {
				Tok: awsDataSource("Vpc", "getSecurityGroupRule"),
			},
			"aws_vpc_security_group_rules": {
				Tok: awsDataSource("Vpc", "getSecurityGroupRules"),
			},

			// AWS
			"aws_arn":                     {Tok: awsDataSource(awsMod, "getArn")},
			"aws_availability_zone":       {Tok: awsDataSource(awsMod, "getAvailabilityZone")},
			"aws_availability_zones":      {Tok: awsDataSource(awsMod, "getAvailabilityZones")},
			"aws_billing_service_account": {Tok: awsDataSource(awsMod, "getBillingServiceAccount")},
			"aws_caller_identity":         {Tok: awsDataSource(awsMod, "getCallerIdentity")},
			"aws_cur_report_definition":   {Tok: awsDataSource(curMod, "getReportDefinition")},
			"aws_ip_ranges":               {Tok: awsDataSource(awsMod, "getIpRanges")},
			"aws_partition":               {Tok: awsDataSource(awsMod, "getPartition")},
			"aws_region":                  {Tok: awsDataSource(awsMod, "getRegion")},
			"aws_regions":                 {Tok: awsDataSource(awsMod, "getRegions")},
			"aws_default_tags":            {Tok: awsDataSource(awsMod, "getDefaultTags")},
			"aws_service":                 {Tok: awsDataSource(awsMod, "getService")},
			// AWS Certificate Manager
			"aws_acm_certificate": {Tok: awsDataSource(acmMod, "getCertificate")},
			// AWS Private Certificate Authority
			"aws_acmpca_certificate_authority": {Tok: awsDataSource(acmpcaMod, "getCertificateAuthority")},
			"aws_acmpca_certificate":           {Tok: awsDataSource(acmpcaMod, "getCertificate")},
			// Amp
			"aws_prometheus_workspace":  {Tok: awsDataSource(ampMod, "getWorkspace")},
			"aws_prometheus_workspaces": {Tok: awsDataSource(ampMod, "getWorkspaces")},
			// AppConfig
			"aws_appconfig_configuration_profile":  {Tok: awsDataSource(appConfigMod, "getConfigurationProfile")},
			"aws_appconfig_configuration_profiles": {Tok: awsDataSource(appConfigMod, "getConfigurationProfiles")},
			"aws_appconfig_environment":            {Tok: awsDataSource(appConfigMod, "getEnvironment")},
			"aws_appconfig_environments":           {Tok: awsDataSource(appConfigMod, "getEnvironments")},
			// AppMesh
			"aws_appmesh_mesh":            {Tok: awsDataSource(appmeshMod, "getMesh")},
			"aws_appmesh_virtual_service": {Tok: awsDataSource(appmeshMod, "getVirtualService")},
			"aws_appmesh_route":           {Tok: awsDataSource(appmeshMod, "getRoute")},
			"aws_appmesh_virtual_gateway": {Tok: awsDataSource(appmeshMod, "getVirtualGateway")},
			"aws_appmesh_gateway_route":   {Tok: awsDataSource(appmeshMod, "getGatewayRoute")},
			"aws_appmesh_virtual_node":    {Tok: awsDataSource(appmeshMod, "getVirtualNode")},
			"aws_appmesh_virtual_router":  {Tok: awsDataSource(appmeshMod, "getVirtualRouter")},
			// API Gateway
			"aws_api_gateway_api_key":     {Tok: awsDataSource(apigatewayMod, "getKey")},
			"aws_api_gateway_resource":    {Tok: awsDataSource(apigatewayMod, "getResource")},
			"aws_api_gateway_rest_api":    {Tok: awsDataSource(apigatewayMod, "getRestApi")},
			"aws_api_gateway_vpc_link":    {Tok: awsDataSource(apigatewayMod, "getVpcLink")},
			"aws_api_gateway_domain_name": {Tok: awsDataSource(apigatewayMod, "getDomainName")},
			"aws_api_gateway_export":      {Tok: awsDataSource(apigatewayMod, "getExport")},
			"aws_api_gateway_sdk":         {Tok: awsDataSource(apigatewayMod, "getSdk")},
			"aws_api_gateway_authorizer":  {Tok: awsDataSource(apigatewayMod, "getAuthorizer")},
			"aws_api_gateway_authorizers": {Tok: awsDataSource(apigatewayMod, "getAuthorizers")},

			// API Gateway v2
			"aws_apigatewayv2_export": {Tok: awsDataSource(apigatewayv2Mod, "getExport")},

			// Autoscaling
			"aws_autoscaling_group": {Tok: awsDataSource(autoscalingMod, "getGroup")},
			// Batch
			"aws_batch_compute_environment": {Tok: awsDataSource(batchMod, "getComputeEnvironment")},
			"aws_batch_job_queue":           {Tok: awsDataSource(batchMod, "getJobQueue")},
			"aws_batch_scheduling_policy":   {Tok: awsDataSource(batchMod, "getSchedulingPolicy")},
			// cloud control api
			"aws_cloudcontrolapi_resource": {Tok: awsDataSource(cloudControlMod, "getResource")},
			// CloudFormation
			"aws_cloudformation_stack":  {Tok: awsDataSource(cloudformationMod, "getStack")},
			"aws_cloudformation_export": {Tok: awsDataSource(cloudformationMod, "getExport")},
			"aws_cloudformation_type":   {Tok: awsDataSource(cloudformationMod, "getCloudFormationType")},
			// CloudHSM
			"aws_cloudhsm_v2_cluster": {Tok: awsDataSource(cloudhsmv2Mod, "getCluster")},
			// CloudTrail
			"aws_cloudtrail_service_account": {Tok: awsDataSource(cloudtrailMod, "getServiceAccount")},
			// CloudWatch
			"aws_cloudwatch_log_group":                           {Tok: awsDataSource(cloudwatchMod, "getLogGroup")},
			"aws_cloudwatch_log_groups":                          {Tok: awsDataSource(cloudwatchMod, "getLogGroups")},
			"aws_cloudwatch_event_source":                        {Tok: awsDataSource(cloudwatchMod, "getEventSource")},
			"aws_cloudwatch_event_connection":                    {Tok: awsDataSource(cloudwatchMod, "getEventConnection")},
			"aws_cloudwatch_event_bus":                           {Tok: awsDataSource(cloudwatchMod, "getEventBus")},
			"aws_cloudwatch_log_data_protection_policy_document": {Tok: awsDataSource(cloudwatchMod, "getLogDataProtectionPolicyDocument")},
			// CodeCommit
			"aws_codecommit_repository":             {Tok: awsDataSource(codecommitMod, "getRepository")},
			"aws_codecommit_approval_rule_template": {Tok: awsDataSource(codecommitMod, "getApprovalRuleTemplate")},

			// Cognito
			"aws_cognito_user_pools":                    {Tok: awsDataSource(cognitoMod, "getUserPools")},
			"aws_cognito_user_pool_clients":             {Tok: awsDataSource(cognitoMod, "getUserPoolClients")},
			"aws_cognito_user_pool_signing_certificate": {Tok: awsDataSource(cognitoMod, "getUserPoolSigningCertificate")},
			"aws_cognito_user_pool_client":              {Tok: awsDataSource(cognitoMod, "getUserPoolClient")},

			// Connect
			"aws_connect_contact_flow":                {Tok: awsDataSource(connectMod, "getContactFlow")},
			"aws_connect_instance_storage_config":     {Tok: awsDataSource(connectMod, "getInstanceStorageConfig")},
			"aws_connect_instance":                    {Tok: awsDataSource(connectMod, "getInstance")},
			"aws_connect_bot_association":             {Tok: awsDataSource(connectMod, "getBotAssociation")},
			"aws_connect_hours_of_operation":          {Tok: awsDataSource(connectMod, "getHoursOfOperation")},
			"aws_connect_lambda_function_association": {Tok: awsDataSource(connectMod, "getLambdaFunctionAssociation")},
			"aws_connect_contact_flow_module":         {Tok: awsDataSource(connectMod, "getContactFlowModule")},
			"aws_connect_prompt":                      {Tok: awsDataSource(connectMod, "getPrompt")},
			"aws_connect_quick_connect":               {Tok: awsDataSource(connectMod, "getQuickConnect")},
			"aws_connect_queue":                       {Tok: awsDataSource(connectMod, "getQueue")},
			"aws_connect_routing_profile":             {Tok: awsDataSource(connectMod, "getRoutingProfile")},
			"aws_connect_security_profile":            {Tok: awsDataSource(connectMod, "getSecurityProfile")},
			"aws_connect_user_hierarchy_structure":    {Tok: awsDataSource(connectMod, "getUserHierarchyStructure")},
			"aws_connect_user_hierarchy_group":        {Tok: awsDataSource(connectMod, "getUserHierarchyGroup")},

			// Cost Explorer
			"aws_ce_cost_category": {Tok: awsDataSource(costExplorerMod, "getCostCategory")},
			"aws_ce_tags":          {Tok: awsDataSource(costExplorerMod, "getTags")},

			// Datapipeline
			"aws_datapipeline_pipeline":            {Tok: awsDataSource(datapipelineMod, "getPipeline")},
			"aws_datapipeline_pipeline_definition": {Tok: awsDataSource(datapipelineMod, "getPipelineDefinition")},

			// Data Migration Service
			"aws_dms_certificate":              {Tok: awsDataSource(dmsMod, "getCertificate")},
			"aws_dms_endpoint":                 {Tok: awsDataSource(dmsMod, "getEndpoint")},
			"aws_dms_replication_subnet_group": {Tok: awsDataSource(dmsMod, "getReplicationSubnetGroup")},
			"aws_dms_replication_task":         {Tok: awsDataSource(dmsMod, "getReplicationTask")},

			// DynamoDB
			"aws_dynamodb_table": {
				Tok: awsDataSource(dynamodbMod, "getTable"),
				Fields: map[string]*tfbridge.SchemaInfo{
					// Override default pluralization ("indices") to match AWS APIs
					"global_secondary_index": {Name: "globalSecondaryIndexes"},
					"local_secondary_index":  {Name: "localSecondaryIndexes"},
					// These are one field per table in the AWS API,
					// so we enforce that at the Pulumi API as
					// well. See
					// https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/time-to-live-ttl-how-to.html
					"ttl":                    {MaxItemsOne: ref(true)},
					"point_in_time_recovery": {MaxItemsOne: ref(true)},
				},
			},
			"aws_dynamodb_table_item": {Tok: awsDataSource(dynamodbMod, "getTableItem")},

			// DX
			"aws_dx_connection":           {Tok: awsDataSource(dxMod, "getConnection")},
			"aws_dx_gateway":              {Tok: awsDataSource(dxMod, "getGateway")},
			"aws_dx_location":             {Tok: awsDataSource(dxMod, "getLocation")},
			"aws_dx_locations":            {Tok: awsDataSource(dxMod, "getLocations")},
			"aws_dx_router_configuration": {Tok: awsDataSource(dxMod, "getRouterConfiguration")},

			// EC2
			"aws_ami":                   {Tok: awsDataSource(ec2Mod, "getAmi")},
			"aws_ami_ids":               {Tok: awsDataSource(ec2Mod, "getAmiIds")},
			"aws_eip":                   {Tok: awsDataSource(ec2Mod, "getElasticIp")},
			"aws_prefix_list":           {Tok: awsDataSource(ec2Mod, "getPrefixList")},
			"aws_customer_gateway":      {Tok: awsDataSource(ec2Mod, "getCustomerGateway")},
			"aws_instance":              {Tok: awsDataSource(ec2Mod, "getInstance")},
			"aws_ec2_instance_type":     {Tok: awsDataSource(ec2Mod, "getInstanceType")},
			"aws_ec2_public_ipv4_pool":  {Tok: awsDataSource(ec2Mod, "getPublicIpv4Pool")},
			"aws_ec2_public_ipv4_pools": {Tok: awsDataSource(ec2Mod, "getPublicIpv4Pools")},
			"aws_instances":             {Tok: awsDataSource(ec2Mod, "getInstances")},
			"aws_internet_gateway":      {Tok: awsDataSource(ec2Mod, "getInternetGateway")},
			"aws_launch_configuration":  {Tok: awsDataSource(ec2Mod, "getLaunchConfiguration")},
			"aws_launch_template": {
				Tok: awsDataSource(ec2Mod, "getLaunchTemplate"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"network_interfaces": {
						Elem: &tfbridge.SchemaInfo{
							Fields: map[string]*tfbridge.SchemaInfo{
								"associate_public_ip_address": {
									Type:           "boolean",
									MarkAsOptional: ref(true),
								},
								"delete_on_termination": {
									Type:           "boolean",
									MarkAsOptional: ref(true),
								},
							},
						},
					},
				},
			},
			"aws_nat_gateway":                         {Tok: awsDataSource(ec2Mod, "getNatGateway")},
			"aws_nat_gateways":                        {Tok: awsDataSource(ec2Mod, "getNatGateways")},
			"aws_network_acls":                        {Tok: awsDataSource(ec2Mod, "getNetworkAcls")},
			"aws_network_interface":                   {Tok: awsDataSource(ec2Mod, "getNetworkInterface")},
			"aws_network_interfaces":                  {Tok: awsDataSource(ec2Mod, "getNetworkInterfaces")},
			"aws_route":                               {Tok: awsDataSource(ec2Mod, "getRoute")},
			"aws_route_table":                         {Tok: awsDataSource(ec2Mod, "getRouteTable")},
			"aws_route_tables":                        {Tok: awsDataSource(ec2Mod, "getRouteTables")},
			"aws_security_group":                      {Tok: awsDataSource(ec2Mod, "getSecurityGroup")},
			"aws_security_groups":                     {Tok: awsDataSource(ec2Mod, "getSecurityGroups")},
			"aws_subnet":                              {Tok: awsDataSource(ec2Mod, "getSubnet")},
			"aws_key_pair":                            {Tok: awsDataSource(ec2Mod, "getKeyPair")},
			"aws_subnets":                             {Tok: awsDataSource(ec2Mod, "getSubnets")},
			"aws_vpc":                                 {Tok: awsDataSource(ec2Mod, "getVpc")},
			"aws_vpc_dhcp_options":                    {Tok: awsDataSource(ec2Mod, "getVpcDhcpOptions")},
			"aws_vpc_endpoint":                        {Tok: awsDataSource(ec2Mod, "getVpcEndpoint")},
			"aws_vpc_endpoint_service":                {Tok: awsDataSource(ec2Mod, "getVpcEndpointService")},
			"aws_vpc_peering_connection":              {Tok: awsDataSource(ec2Mod, "getVpcPeeringConnection")},
			"aws_vpc_peering_connections":             {Tok: awsDataSource(ec2Mod, "getVpcPeeringConnections")},
			"aws_vpcs":                                {Tok: awsDataSource(ec2Mod, "getVpcs")},
			"aws_vpn_gateway":                         {Tok: awsDataSource(ec2Mod, "getVpnGateway")},
			"aws_ec2_spot_price":                      {Tok: awsDataSource(ec2Mod, "getSpotPrice")},
			"aws_ec2_instance_type_offering":          {Tok: awsDataSource(ec2Mod, "getInstanceTypeOffering")},
			"aws_ec2_instance_type_offerings":         {Tok: awsDataSource(ec2Mod, "getInstanceTypeOfferings")},
			"aws_ec2_coip_pool":                       {Tok: awsDataSource(ec2Mod, "getCoipPool")},
			"aws_ec2_coip_pools":                      {Tok: awsDataSource(ec2Mod, "getCoipPools")},
			"aws_ec2_local_gateway":                   {Tok: awsDataSource(ec2Mod, "getLocalGateway")},
			"aws_ec2_local_gateways":                  {Tok: awsDataSource(ec2Mod, "getLocalGateways")},
			"aws_ec2_local_gateway_route_table":       {Tok: awsDataSource(ec2Mod, "getLocalGatewayRouteTable")},
			"aws_ec2_local_gateway_route_tables":      {Tok: awsDataSource(ec2Mod, "getLocalGatewayRouteTables")},
			"aws_ec2_local_gateway_virtual_interface": {Tok: awsDataSource(ec2Mod, "getLocalGatewayVirtualInterface")},
			"aws_ec2_local_gateway_virtual_interface_group": {
				Tok: awsDataSource(ec2Mod, "getLocalGatewayVirtualInterfaceGroup"),
			},
			"aws_ec2_local_gateway_virtual_interface_groups": {
				Tok: awsDataSource(ec2Mod, "getLocalGatewayVirtualInterfaceGroups"),
			},
			"aws_ec2_host":                         {Tok: awsDataSource(ec2Mod, "getDedicatedHost")},
			"aws_ec2_managed_prefix_list":          {Tok: awsDataSource(ec2Mod, "getManagedPrefixList")},
			"aws_ec2_transit_gateway_route_tables": {Tok: awsDataSource(ec2Mod, "getTransitGatewayRouteTables")},
			"aws_ec2_instance_types":               {Tok: awsDataSource(ec2Mod, "getInstanceTypes")},
			"aws_vpc_ipam_pool":                    {Tok: awsDataSource(ec2Mod, "getVpcIpamPool")},
			"aws_vpc_ipam_pools":                   {Tok: awsDataSource(ec2Mod, "getVpcIpamPools")},
			"aws_vpc_ipam_pool_cidrs":              {Tok: awsDataSource(ec2Mod, "getVpcIpamPoolCidrs")},
			"aws_vpc_ipam_preview_next_cidr":       {Tok: awsDataSource(ec2Mod, "getIpamPreviewNextCidr")},
			"aws_eips":                             {Tok: awsDataSource(ec2Mod, "getEips")},
			"aws_ec2_serial_console_access":        {Tok: awsDataSource(ec2Mod, "getSerialConsoleAccess")},
			"aws_ec2_network_insights_analysis":    {Tok: awsDataSource(ec2Mod, "getNetworkInsightsAnalysis")},
			"aws_ec2_network_insights_path":        {Tok: awsDataSource(ec2Mod, "getNetworkInsightsPath")},
			"aws_ec2_managed_prefix_lists":         {Tok: awsDataSource(ec2Mod, "getManagedPrefixLists")},

			// Ec2 Client
			"aws_ec2_client_vpn_endpoint": {Tok: awsDataSource(ec2ClientVpnMod, "getEndpoint")},

			// EC2 Transit Gateway
			"aws_ec2_transit_gateway":                          {Tok: awsDataSource(ec2TransitGatewayMod, "getTransitGateway")},
			"aws_ec2_transit_gateway_attachments":              {Tok: awsDataSource(ec2TransitGatewayMod, "getAttachments")},
			"aws_ec2_transit_gateway_route_table_associations": {Tok: awsDataSource(ec2TransitGatewayMod, "getRouteTableAssociations")},
			"aws_ec2_transit_gateway_route_table_propagations": {Tok: awsDataSource(ec2TransitGatewayMod, "getRouteTablePropagations")},
			"aws_ec2_transit_gateway_dx_gateway_attachment": {
				Tok: awsDataSource(ec2TransitGatewayMod, "getDirectConnectGatewayAttachment"),
			},
			"aws_ec2_transit_gateway_route_table":      {Tok: awsDataSource(ec2TransitGatewayMod, "getRouteTable")},
			"aws_ec2_transit_gateway_vpc_attachment":   {Tok: awsDataSource(ec2TransitGatewayMod, "getVpcAttachment")},
			"aws_ec2_transit_gateway_vpn_attachment":   {Tok: awsDataSource(ec2TransitGatewayMod, "getVpnAttachment")},
			"aws_ec2_transit_gateway_connect":          {Tok: awsDataSource(ec2TransitGatewayMod, "getConnect")},
			"aws_ec2_transit_gateway_connect_peer":     {Tok: awsDataSource(ec2TransitGatewayMod, "getConnectPeer")},
			"aws_ec2_transit_gateway_multicast_domain": {Tok: awsDataSource(ec2TransitGatewayMod, "getMulticastDomain")},
			"aws_ec2_transit_gateway_vpc_attachments":  {Tok: awsDataSource(ec2TransitGatewayMod, "getVpcAttachments")},
			"aws_ec2_transit_gateway_peering_attachment": {
				Tok: awsDataSource(ec2TransitGatewayMod, "getPeeringAttachment"),
			},
			"aws_ec2_transit_gateway_attachment": {Tok: awsDataSource(ec2TransitGatewayMod, "getAttachment")},
			// Elastic Beanstalk
			"aws_elastic_beanstalk_application": {
				Tok: awsDataSource(elasticbeanstalkMod, "getApplication"),
				Fields: map[string]*tfbridge.SchemaInfo{
					// This attribute is flattened upstream, so we
					// only show one item in the Pulumi
					// API. https://github.com/hashicorp/terraform-provider-aws/blob/71ac1fa8dd1c0aea46877437921d7443edbe0aa7/internal/service/elasticbeanstalk/application_data_source.go#L73
					"appversion_lifecycle": {MaxItemsOne: ref(true)},
				},
			},

			// Elastic Load Balancer
			"aws_elb_hosted_zone_id":  {Tok: awsDataSource(elbMod, "getHostedZoneId")},
			"aws_elb_service_account": {Tok: awsDataSource(elbMod, "getServiceAccount")},
			"aws_elb": {
				Tok: awsDataSource(elbMod, "getLoadBalancer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					// This attribute is flattened upstream:
					// https://github.com/hashicorp/terraform-provider-aws/blob/c14a7fe82ab84aaa9db676c9ee4242e20fb33145/internal/service/elb/load_balancer_data_source.go#L302.
					"access_logs": {MaxItemsOne: ref(true)},
					// This attribute is flattened upstream:
					// https://github.com/hashicorp/terraform-provider-aws/blob/c14a7fe82ab84aaa9db676c9ee4242e20fb33145/internal/service/elb/load_balancer_data_source.go#L327
					"health_check": {MaxItemsOne: ref(true)},
				},
			},

			// Elastic Block Storage
			"aws_ebs_default_kms_key":       {Tok: awsDataSource(ebsMod, "getDefaultKmsKey")},
			"aws_ebs_encryption_by_default": {Tok: awsDataSource(ebsMod, "getEncryptionByDefault")},
			"aws_ebs_snapshot":              {Tok: awsDataSource(ebsMod, "getSnapshot")},
			"aws_ebs_snapshot_ids":          {Tok: awsDataSource(ebsMod, "getSnapshotIds")},
			"aws_ebs_volume":                {Tok: awsDataSource(ebsMod, "getVolume")},
			"aws_ebs_volumes":               {Tok: awsDataSource(ebsMod, "getEbsVolumes")},
			// Elastic Container Registry
			"aws_ecr_credentials": {
				Tok: awsDataSource(ecrMod, "getCredentials"),
				// aws_ecr_credentials is a custom data source implemented by Pulumi, thus it has no docs in the
				// upstream provider. We set to a whitespace string so that the build will pass.
				Docs: &tfbridge.DocInfo{
					Markdown: []byte(" "),
				},
			},
			"aws_ecr_image":               {Tok: awsDataSource(ecrMod, "getImage")},
			"aws_ecr_repository":          {Tok: awsDataSource(ecrMod, "getRepository")},
			"aws_ecr_authorization_token": {Tok: awsDataSource(ecrMod, "getAuthorizationToken")},
			// ecrpublic
			"aws_ecrpublic_authorization_token": {Tok: awsDataSource(ecrPublicMod, "getAuthorizationToken")},
			// Elastic Container Service
			"aws_ecs_cluster":              {Tok: awsDataSource(ecsMod, "getCluster")},
			"aws_ecs_container_definition": {Tok: awsDataSource(ecsMod, "getContainerDefinition")},
			"aws_ecs_service":              {Tok: awsDataSource(ecsMod, "getService")},
			"aws_ecs_task_definition":      {Tok: awsDataSource(ecsMod, "getTaskDefinition")},
			"aws_ecs_task_execution":       {Tok: awsDataSource(ecsMod, "getTaskExecution")},

			// Elastic Filesystem
			"aws_efs_file_system": {
				Tok: awsDataSource(efsMod, "getFileSystem"),
				Fields: map[string]*tfbridge.SchemaInfo{
					// Removing `MaxItems: 1`, Seems to be a hedge
					// against the future, but does not become present
					// in the TF API. See
					// https://github.com/hashicorp/terraform-provider-aws/commit/362c03ec27e839a571de312060e87657d617038b
					// for details.
					"lifecycle_policy": {MaxItemsOne: ref(true)},
				},
			},
			"aws_efs_mount_target":  {Tok: awsDataSource(efsMod, "getMountTarget")},
			"aws_efs_access_point":  {Tok: awsDataSource(efsMod, "getAccessPoint")},
			"aws_efs_access_points": {Tok: awsDataSource(efsMod, "getAccessPoints")},
			// ECS for Kubernetes
			"aws_eks_cluster": {
				Tok: awsDataSource(eksMod, "getCluster"),
				Fields: map[string]*tfbridge.SchemaInfo{
					// This attribute is flattened upstream. See
					// https://github.com/hashicorp/terraform-provider-aws/blob/c14a7fe82ab84aaa9db676c9ee4242e20fb33145/internal/service/eks/cluster_data_source.go#L231
					// for details.
					"vpc_config": {MaxItemsOne: ref(true)},
				},
			},
			"aws_eks_cluster_auth":  {Tok: awsDataSource(eksMod, "getClusterAuth")},
			"aws_eks_addon":         {Tok: awsDataSource(eksMod, "getAddon")},
			"aws_eks_addon_version": {Tok: awsDataSource(eksMod, "getAddonVersion")},
			"aws_eks_clusters":      {Tok: awsDataSource(eksMod, "getClusters")},
			"aws_eks_node_group":    {Tok: awsDataSource(eksMod, "getNodeGroup")},
			"aws_eks_node_groups":   {Tok: awsDataSource(eksMod, "getNodeGroups")},
			// Elastic Beanstalk
			"aws_elastic_beanstalk_solution_stack": {Tok: awsDataSource(elasticbeanstalkMod, "getSolutionStack")},
			"aws_elastic_beanstalk_hosted_zone":    {Tok: awsDataSource(elasticbeanstalkMod, "getHostedZone")},
			// ElastiCache
			"aws_elasticache_cluster":           {Tok: awsDataSource(elasticacheMod, "getCluster")},
			"aws_elasticache_replication_group": {Tok: awsDataSource(elasticacheMod, "getReplicationGroup")},
			"aws_elasticache_subnet_group":      {Tok: awsDataSource(elasticacheMod, "getSubnetGroup")},
			"aws_elasticache_user":              {Tok: awsDataSource(elasticacheMod, "getUser")},

			// EMR
			"aws_emr_release_labels": {Tok: awsDataSource(emrMod, "getReleaseLabels")},

			// EMR Containers
			"aws_emrcontainers_virtual_cluster": {Tok: awsDataSource(emrContainersMod, "getVirtualCluster")},

			// Fsx
			"aws_fsx_openzfs_snapshot":    {Tok: awsDataSource(fsxMod, "getOpenZfsSnapshot")},
			"aws_fsx_windows_file_system": {Tok: awsDataSource(fsxMod, "getWindowsFileSystem")},

			// Global Accelerator
			"aws_globalaccelerator_accelerator": {Tok: awsDataSource(globalacceleratorMod, "getAccelerator")},
			// grafana
			"aws_grafana_workspace": {Tok: awsDataSource(grafanaMod, "getWorkspace")},
			// Glue
			"aws_glue_script":                           {Tok: awsDataSource(glueMod, "getScript")},
			"aws_glue_connection":                       {Tok: awsDataSource(glueMod, "getConnection")},
			"aws_glue_data_catalog_encryption_settings": {Tok: awsDataSource(glueMod, "getDataCatalogEncryptionSettings")},
			"aws_glue_catalog_table":                    {Tok: awsDataSource(glueMod, "getCatalogTable")},
			// IOT
			"aws_iot_endpoint": {Tok: awsDataSource(iotMod, "getEndpoint")},
			// Lambda
			"aws_lambda_function": {
				Tok: awsDataSource(lambdaMod, "getFunction"),
				Fields: map[string]*tfbridge.SchemaInfo{
					// This item is flattened upstream. See
					// https://github.com/hashicorp/terraform-provider-aws/blob/71ac1fa8dd1c0aea46877437921d7443edbe0aa7/internal/service/lambda/function_data_source.go#L263-L273
					"dead_letter_config": {MaxItemsOne: ref(true)},
					// This item is flattened upstream. See
					// https://github.com/hashicorp/terraform-provider-aws/blob/71ac1fa8dd1c0aea46877437921d7443edbe0aa7/internal/service/lambda/function_data_source.go#L321-L323
					"vpc_config": {MaxItemsOne: ref(true)},
					// This item is flattened upstream. See
					// https://github.com/hashicorp/terraform-provider-aws/blob/71ac1fa8dd1c0aea46877437921d7443edbe0aa7/internal/service/lambda/function_data_source.go#L275-L277
					"environment": {MaxItemsOne: ref(true)},
					// This item is flattened upstream. See
					// https://github.com/hashicorp/terraform-provider-aws/blob/71ac1fa8dd1c0aea46877437921d7443edbe0aa7/internal/service/lambda/function_data_source.go#L313-L319
					"tracing_config": {MaxItemsOne: ref(true)},
				},
			},
			"aws_lambda_functions":           {Tok: awsDataSource(lambdaMod, "getFunctions")},
			"aws_lambda_function_url":        {Tok: awsDataSource(lambdaMod, "getFunctionUrl")},
			"aws_lambda_invocation":          {Tok: awsDataSource(lambdaMod, "getInvocation")},
			"aws_lambda_layer_version":       {Tok: awsDataSource(lambdaMod, "getLayerVersion")},
			"aws_lambda_alias":               {Tok: awsDataSource(lambdaMod, "getAlias")},
			"aws_lambda_code_signing_config": {Tok: awsDataSource(lambdaMod, "getCodeSigningConfig")},
			// MemoryDB
			"aws_memorydb_acl":             {Tok: awsDataSource(memoryDbMod, "getAcl")},
			"aws_memorydb_cluster":         {Tok: awsDataSource(memoryDbMod, "getCluster")},
			"aws_memorydb_parameter_group": {Tok: awsDataSource(memoryDbMod, "getParameterGroup")},
			"aws_memorydb_snapshot":        {Tok: awsDataSource(memoryDbMod, "getSnapshot")},
			"aws_memorydb_subnet_group":    {Tok: awsDataSource(memoryDbMod, "getSubnetGroup")},
			"aws_memorydb_user":            {Tok: awsDataSource(memoryDbMod, "getUser")},

			// MQ
			"aws_mq_broker": {
				Tok: awsDataSource(mqMod, "getBroker"),
				Fields: map[string]*tfbridge.SchemaInfo{
					// This attribute is flattened upstream. See
					// https://github.com/hashicorp/terraform-provider-aws/blob/c14a7fe82ab84aaa9db676c9ee4242e20fb33145/internal/service/mq/broker_data_source.go#L315-L317
					"configuration": {MaxItemsOne: ref(true)},
					// This attribute is flattened upstream. See
					// https://github.com/hashicorp/terraform-provider-aws/blob/c14a7fe82ab84aaa9db676c9ee4242e20fb33145/internal/service/mq/broker_data_source.go#L336-L338.
					"maintenance_window_start_time": {MaxItemsOne: ref(true)},
					// This attribute is flattened upstream.
					"logs": {
						MaxItemsOne: ref(true),
						Elem: &tfbridge.SchemaInfo{
							Fields: map[string]*tfbridge.SchemaInfo{
								"audit": {
									Type: "boolean",
								},
							},
						},
					},
				},
			},
			"aws_mq_broker_instance_type_offerings": {Tok: awsDataSource(mqMod, "getInstanceTypeOfferings")},

			// IAM
			"aws_iam_account_alias":           {Tok: awsDataSource(iamMod, "getAccountAlias")},
			"aws_iam_group":                   {Tok: awsDataSource(iamMod, "getGroup")},
			"aws_iam_instance_profile":        {Tok: awsDataSource(iamMod, "getInstanceProfile")},
			"aws_iam_policy":                  {Tok: awsDataSource(iamMod, "getPolicy")},
			"aws_iam_policy_document":         {Tok: awsDataSource(iamMod, "getPolicyDocument")},
			"aws_iam_role":                    {Tok: awsDataSource(iamMod, "getRole")},
			"aws_iam_server_certificate":      {Tok: awsDataSource(iamMod, "getServerCertificate")},
			"aws_iam_user":                    {Tok: awsDataSource(iamMod, "getUser")},
			"aws_iam_users":                   {Tok: awsDataSource(iamMod, "getUsers")},
			"aws_iam_session_context":         {Tok: awsDataSource(iamMod, "getSessionContext")},
			"aws_iam_roles":                   {Tok: awsDataSource(iamMod, "getRoles")},
			"aws_iam_user_ssh_key":            {Tok: awsDataSource(iamMod, "getUserSshKey")},
			"aws_iam_openid_connect_provider": {Tok: awsDataSource(iamMod, "getOpenIdConnectProvider")},
			"aws_iam_saml_provider":           {Tok: awsDataSource(iamMod, "getSamlProvider")},
			"aws_iam_instance_profiles":       {Tok: awsDataSource(iamMod, "getInstanceProfiles")},
			"aws_iam_access_keys":             {Tok: awsDataSource(iamMod, "getAccessKeys")},

			// IdentityStore
			"aws_identitystore_group": {Tok: awsDataSource(identityStoreMod, "getGroup")},
			"aws_identitystore_user":  {Tok: awsDataSource(identityStoreMod, "getUser")},
			// Inspector
			"aws_inspector_rules_packages": {Tok: awsDataSource(inspectorMod, "getRulesPackages")},
			// Kendra
			"aws_kendra_experience":                   {Tok: awsDataSource(kendraMod, "getExperience")},
			"aws_kendra_faq":                          {Tok: awsDataSource(kendraMod, "getFaq")},
			"aws_kendra_index":                        {Tok: awsDataSource(kendraMod, "getIndex")},
			"aws_kendra_query_suggestions_block_list": {Tok: awsDataSource(kendraMod, "getQuerySuggestionsBlockList")},
			"aws_kendra_thesaurus":                    {Tok: awsDataSource(kendraMod, "getThesaurus")},
			// Kinesis
			"aws_kinesis_stream":                   {Tok: awsDataSource(kinesisMod, "getStream")},
			"aws_kinesis_stream_consumer":          {Tok: awsDataSource(kinesisMod, "getStreamConsumer")},
			"aws_kinesis_firehose_delivery_stream": {Tok: awsDataSource(kinesisMod, "getFirehoseDeliveryStream")},
			// Key Management Service
			"aws_kms_alias":            {Tok: awsDataSource(kmsMod, "getAlias")},
			"aws_kms_custom_key_store": {Tok: awsDataSource(kmsMod, "getCustomKeyStore")},
			"aws_kms_ciphertext":       {Tok: awsDataSource(kmsMod, "getCipherText")},
			"aws_kms_key":              {Tok: awsDataSource(kmsMod, "getKey")},
			"aws_kms_secret":           {Tok: awsDataSource(kmsMod, "getSecret")},
			"aws_kms_secrets":          {Tok: awsDataSource(kmsMod, "getSecrets")},
			"aws_kms_public_key":       {Tok: awsDataSource(kmsMod, "getPublicKey")},

			// LicenseManager NB slightly inconsistent translation of the names, to be close to the
			// resource names, but avoid repeating 'license'.
			"aws_licensemanager_grants":            {Tok: awsDataSource(licensemanagerMod, "getLicenseGrants")},
			"aws_licensemanager_received_license":  {Tok: awsDataSource(licensemanagerMod, "getReceivedLicense")},
			"aws_licensemanager_received_licenses": {Tok: awsDataSource(licensemanagerMod, "getReceivedLicenses")},

			// Location
			"aws_location_map":                  {Tok: awsDataSource(locationMod, "getMap")},
			"aws_location_place_index":          {Tok: awsDataSource(locationMod, "getPlaceIndex")},
			"aws_location_route_calculator":     {Tok: awsDataSource(locationMod, "getRouteCalculator")},
			"aws_location_tracker":              {Tok: awsDataSource(locationMod, "getTracker")},
			"aws_location_geofence_collection":  {Tok: awsDataSource(locationMod, "getGeofenceCollection")},
			"aws_location_tracker_association":  {Tok: awsDataSource(locationMod, "getTrackerAssociation")},
			"aws_location_tracker_associations": {Tok: awsDataSource(locationMod, "getTrackerAssociations")},

			// Pricing
			"aws_pricing_product": {Tok: awsDataSource(pricingMod, "getProduct")},
			// RDS
			"aws_rds_cluster":                    {Tok: awsDataSource(rdsMod, "getCluster")},
			"aws_rds_clusters":                   {Tok: awsDataSource(rdsMod, "getClusters")},
			"aws_db_cluster_snapshot":            {Tok: awsDataSource(rdsMod, "getClusterSnapshot")},
			"aws_db_event_categories":            {Tok: awsDataSource(rdsMod, "getEventCategories")},
			"aws_db_instance":                    {Tok: awsDataSource(rdsMod, "getInstance")},
			"aws_db_instances":                   {Tok: awsDataSource(rdsMod, "getInstances")},
			"aws_db_snapshot":                    {Tok: awsDataSource(rdsMod, "getSnapshot")},
			"aws_db_subnet_group":                {Tok: awsDataSource(rdsMod, "getSubnetGroup")},
			"aws_rds_orderable_db_instance":      {Tok: awsDataSource(rdsMod, "getOrderableDbInstance")},
			"aws_rds_engine_version":             {Tok: awsDataSource(rdsMod, "getEngineVersion")},
			"aws_rds_certificate":                {Tok: awsDataSource(rdsMod, "getCertificate")},
			"aws_rds_reserved_instance_offering": {Tok: awsDataSource(rdsMod, "getReservedInstanceOffering")},
			"aws_db_proxy":                       {Tok: awsDataSource(rdsMod, "getProxy")},
			// Ram
			"aws_ram_resource_share": {Tok: awsDataSource(ramMod, "getResourceShare")},
			// OAM
			"aws_oam_sink":  {Tok: awsDataSource(oamMod, "getSink")},
			"aws_oam_sinks": {Tok: awsDataSource(oamMod, "getSinks")},
			"aws_oam_link":  {Tok: awsDataSource(oamMod, "getLink")},
			"aws_oam_links": {Tok: awsDataSource(oamMod, "getLinks")},
			// RedShift
			"aws_redshift_cluster":             {Tok: awsDataSource(redshiftMod, "getCluster")},
			"aws_redshift_service_account":     {Tok: awsDataSource(redshiftMod, "getServiceAccount")},
			"aws_redshift_orderable_cluster":   {Tok: awsDataSource(redshiftMod, "getOrderableCluster")},
			"aws_redshift_subnet_group":        {Tok: awsDataSource(redshiftMod, "getSubnetGroup")},
			"aws_redshift_cluster_credentials": {Tok: awsDataSource(redshiftMod, "getClusterCredentials")},
			// RedShift Serverless
			"aws_redshiftserverless_credentials": {Tok: awsDataSource(redshiftServerlessMod, "getCredentials")},
			"aws_redshiftserverless_workgroup":   {Tok: awsDataSource(redshiftServerlessMod, "getWorkgroup")},
			// Route53
			"aws_route53_zone":                                     {Tok: awsDataSource(route53Mod, "getZone")},
			"aws_route53_delegation_set":                           {Tok: awsDataSource(route53Mod, "getDelegationSet")},
			"aws_route53_resolver_firewall_config":                 {Tok: awsDataSource(route53Mod, "getResolverFirewallConfig")},
			"aws_route53_resolver_firewall_domain_list":            {Tok: awsDataSource(route53Mod, "getResolverFirewallDomainList")},
			"aws_route53_resolver_firewall_rule_group":             {Tok: awsDataSource(route53Mod, "getResolverFirewallRuleGroup")},
			"aws_route53_resolver_firewall_rule_group_association": {Tok: awsDataSource(route53Mod, "getResolverFirewallRuleGroupAssociation")},
			"aws_route53_resolver_firewall_rules":                  {Tok: awsDataSource(route53Mod, "getResolverFirewallRules")},
			"aws_route53_resolver_rule":                            {Tok: awsDataSource(route53Mod, "getResolverRule")},
			"aws_route53_resolver_rules":                           {Tok: awsDataSource(route53Mod, "getResolverRules")},
			"aws_route53_resolver_endpoint":                        {Tok: awsDataSource(route53Mod, "getResolverEndpoint")},
			"aws_route53_resolver_query_log_config":                {Tok: awsDataSource(route53Mod, "getQueryLogConfig")},
			"aws_route53_traffic_policy_document":                  {Tok: awsDataSource(route53Mod, "getTrafficPolicyDocument")},
			// S3
			"aws_canonical_user_id": {Tok: awsDataSource(s3Mod, "getCanonicalUserId")},
			"aws_s3_account_public_access_block": {
				Tok: awsDataSource(s3Mod, "getAccountPublicAccessBlock"),
			},
			"aws_s3_bucket":         {Tok: awsDataSource(s3Mod, "getBucket")},
			"aws_s3_bucket_object":  {Tok: awsDataSource(s3Mod, "getBucketObject")},
			"aws_s3_bucket_objects": {Tok: awsDataSource(s3Mod, "getBucketObjects")},
			"aws_s3_bucket_policy":  {Tok: awsDataSource(s3Mod, "getBucketPolicy")},
			"aws_s3_object":         {Tok: awsDataSource(s3Mod, "getObject")},
			"aws_s3_objects":        {Tok: awsDataSource(s3Mod, "getObjects")},

			// S3Control
			"aws_s3control_multi_region_access_point": {Tok: awsDataSource(s3ControlMod, "getMultiRegionAccessPoint")},
			// Secrets Manager
			"aws_secretsmanager_secret":          {Tok: awsDataSource(secretsmanagerMod, "getSecret")},
			"aws_secretsmanager_secret_version":  {Tok: awsDataSource(secretsmanagerMod, "getSecretVersion")},
			"aws_secretsmanager_secret_rotation": {Tok: awsDataSource(secretsmanagerMod, "getSecretRotation")},
			"aws_secretsmanager_secrets":         {Tok: awsDataSource(secretsmanagerMod, "getSecrets")},
			"aws_secretsmanager_random_password": {Tok: awsDataSource(secretsmanagerMod, "getRandomPassword")},

			// SNS
			"aws_sns_topic": {Tok: awsDataSource(snsMod, "getTopic")},
			// SQS
			"aws_sqs_queue":  {Tok: awsDataSource(sqsMod, "getQueue")},
			"aws_sqs_queues": {Tok: awsDataSource(sqsMod, "getQueues")},
			// SSM
			"aws_ssm_document":            {Tok: awsDataSource(ssmMod, "getDocument")},
			"aws_ssm_parameter":           {Tok: awsDataSource(ssmMod, "getParameter")},
			"aws_ssm_patch_baseline":      {Tok: awsDataSource(ssmMod, "getPatchBaseline")},
			"aws_ssm_parameters_by_path":  {Tok: awsDataSource(ssmMod, "getParametersByPath")},
			"aws_ssm_instances":           {Tok: awsDataSource(ssmMod, "getInstances")},
			"aws_ssm_maintenance_windows": {Tok: awsDataSource(ssmMod, "getMaintenanceWindows")},
			// SSM Incidents
			"aws_ssmincidents_replication_set": {Tok: awsDataSource(ssmIncidentsMod, "getReplicationSet")},
			"aws_ssmincidents_response_plan":   {Tok: awsDataSource(ssmIncidentsMod, "getResponsePlan")},
			// SSM Contacts
			"aws_ssmcontacts_contact":         {Tok: awsDataSource(ssmContactsMod, "getContact")},
			"aws_ssmcontacts_contact_channel": {Tok: awsDataSource(ssmContactsMod, "getContactChannel")},
			"aws_ssmcontacts_plan":            {Tok: awsDataSource(ssmContactsMod, "getPlan")},
			// Storage Gateway
			"aws_storagegateway_local_disk": {Tok: awsDataSource(storagegatewayMod, "getLocalDisk")},
			// Transfer
			"aws_transfer_server": {Tok: awsDataSource(transferMod, "getServer")},
			// Workspaces
			"aws_workspaces_bundle":    {Tok: awsDataSource(workspacesMod, "getBundle")},
			"aws_workspaces_directory": {Tok: awsDataSource(workspacesMod, "getDirectory")},
			"aws_workspaces_image":     {Tok: awsDataSource(workspacesMod, "getImage")},
			"aws_workspaces_workspace": {Tok: awsDataSource(workspacesMod, "getWorkspace")},
			// MSK
			"aws_msk_cluster": {Tok: awsDataSource(mskMod, "getCluster")},
			// Service Quotas
			"aws_servicequotas_service":       {Tok: awsDataSource(servicequotasMod, "getService")},
			"aws_servicequotas_service_quota": {Tok: awsDataSource(servicequotasMod, "getServiceQuota")},
			// MSK
			"aws_msk_configuration": {Tok: awsDataSource(mskMod, "getConfiguration")},
			"aws_msk_broker_nodes":  {Tok: awsDataSource(mskMod, "getBrokerNodes")},
			"aws_msk_kafka_version": {Tok: awsDataSource(mskMod, "getKafkaVersion")},
			// MSK Connect
			"aws_mskconnect_custom_plugin":        {Tok: awsDataSource(mskConnectMod, "getCustomPlugin")},
			"aws_mskconnect_worker_configuration": {Tok: awsDataSource(mskConnectMod, "getWorkerConfiguration")},
			"aws_mskconnect_connector":            {Tok: awsDataSource(mskConnectMod, "getConnector")},
			// WAF
			"aws_waf_rule":                  {Tok: awsDataSource(wafMod, "getRule")},
			"aws_waf_web_acl":               {Tok: awsDataSource(wafMod, "getWebAcl")},
			"aws_waf_ipset":                 {Tok: awsDataSource(wafMod, "getIpset")},
			"aws_waf_rate_based_rule":       {Tok: awsDataSource(wafMod, "getRateBasedRule")},
			"aws_waf_subscribed_rule_group": {Tok: awsDataSource(wafMod, "getSubscribedRuleGroup")},
			// WAF Regional
			"aws_wafregional_rule":                  {Tok: awsDataSource(wafregionalMod, "getRule")},
			"aws_wafregional_web_acl":               {Tok: awsDataSource(wafregionalMod, "getWebAcl")},
			"aws_wafregional_ipset":                 {Tok: awsDataSource(wafregionalMod, "getIpset")},
			"aws_wafregional_rate_based_rule":       {Tok: awsDataSource(wafregionalMod, "getRateBasedMod")},
			"aws_wafregional_subscribed_rule_group": {Tok: awsDataSource(wafregionalMod, "getSubscribedRuleGroup")},
			// Organizations
			"aws_organizations_organization": {Tok: awsDataSource(organizationsMod, "getOrganization")},
			"aws_organizations_organizational_units": {
				Tok: awsDataSource(organizationsMod, "getOrganizationalUnits"),
				Fields: map[string]*tfbridge.SchemaInfo{
					// The inflector incorrectly pluralizes this to
					// "childrens".
					"children": {Name: "children"},
				},
			},
			"aws_organizations_organizational_unit_child_accounts":      {Tok: awsDataSource(organizationsMod, "getOrganizationalUnitChildAccounts")},
			"aws_organizations_organizational_unit_descendant_accounts": {Tok: awsDataSource(organizationsMod, "getOrganizationalUnitDescendantAccounts")},
			"aws_organizations_delegated_services":                      {Tok: awsDataSource(organizationsMod, "getDelegatedServices")},
			"aws_organizations_delegated_administrators":                {Tok: awsDataSource(organizationsMod, "getDelegatedAdministrators")},
			"aws_organizations_resource_tags":                           {Tok: awsDataSource(organizationsMod, "getResourceTags")},
			// ElasticSearch
			"aws_elasticsearch_domain": {Tok: awsDataSource(elasticsearchMod, "getDomain")},
			// QLDB
			"aws_qldb_ledger": {Tok: awsDataSource(qldbMod, "getLedger")},
			// GuardDuty
			"aws_guardduty_detector": {Tok: awsDataSource(guarddutyMod, "getDetector")},
			// Directory Service
			"aws_directory_service_directory": {Tok: awsDataSource(directoryserviceMod, "getDirectory")},
			// SFN
			"aws_sfn_activity":      {Tok: awsDataSource(sfnMod, "getActivity")},
			"aws_sfn_state_machine": {Tok: awsDataSource(sfnMod, "getStateMachine")},

			// Cloudfront
			"aws_cloudfront_distribution":          {Tok: awsDataSource(cloudfrontMod, "getDistribution")},
			"aws_cloudfront_origin_request_policy": {Tok: awsDataSource(cloudfrontMod, "getOriginRequestPolicy")},
			"aws_cloudfront_cache_policy":          {Tok: awsDataSource(cloudfrontMod, "getCachePolicy")},
			"aws_cloudfront_log_delivery_canonical_user_id": {
				Tok: awsDataSource(cloudfrontMod, "getLogDeliveryCanonicalUserId"),
			},
			"aws_cloudfront_response_headers_policy":  {Tok: awsDataSource(cloudfrontMod, "getResponseHeadersPolicy")},
			"aws_cloudfront_origin_access_identity":   {Tok: awsDataSource(cloudfrontMod, "getOriginAccessIdentity")},
			"aws_cloudfront_realtime_log_config":      {Tok: awsDataSource(cloudfrontMod, "getRealtimeLogConfig")},
			"aws_cloudfront_origin_access_identities": {Tok: awsDataSource(cloudfrontMod, "getOriginAccessIdentities")},
			"aws_cloudfront_function":                 {Tok: awsDataSource(cloudfrontMod, "getFunction")},

			// Backup
			"aws_backup_plan":        {Tok: awsDataSource(backupMod, "getPlan")},
			"aws_backup_selection":   {Tok: awsDataSource(backupMod, "getSelection")},
			"aws_backup_vault":       {Tok: awsDataSource(backupMod, "getVault")},
			"aws_backup_framework":   {Tok: awsDataSource(backupMod, "getFramework")},
			"aws_backup_report_plan": {Tok: awsDataSource(backupMod, "getReportPlan")},
			// WAF V2
			"aws_wafv2_ip_set":            {Tok: awsDataSource(wafV2Mod, "getIpSet")},
			"aws_wafv2_regex_pattern_set": {Tok: awsDataSource(wafV2Mod, "getRegexPatternSet")},
			"aws_wafv2_web_acl":           {Tok: awsDataSource(wafV2Mod, "getWebAcl")},
			"aws_wafv2_rule_group":        {Tok: awsDataSource(wafV2Mod, "getRuleGroup")},
			// networkfirewall
			"aws_networkfirewall_firewall_policy": {Tok: awsDataSource(networkFirewallMod, "getFirewallPolicy")},
			"aws_networkfirewall_firewall":        {Tok: awsDataSource(networkFirewallMod, "getFirewall")},
			"aws_networkfirewall_resource_policy": {Tok: awsDataSource(networkFirewallMod, "getResourcePolicy")},
			// networkmanager
			"aws_networkmanager_connection":                   {Tok: awsDataSource(networkManagerMod, "getConnection")},
			"aws_networkmanager_connections":                  {Tok: awsDataSource(networkManagerMod, "getConnections")},
			"aws_networkmanager_device":                       {Tok: awsDataSource(networkManagerMod, "getDevice")},
			"aws_networkmanager_devices":                      {Tok: awsDataSource(networkManagerMod, "getDevices")},
			"aws_networkmanager_global_network":               {Tok: awsDataSource(networkManagerMod, "getGlobalNetwork")},
			"aws_networkmanager_global_networks":              {Tok: awsDataSource(networkManagerMod, "getGlobalNetworks")},
			"aws_networkmanager_link":                         {Tok: awsDataSource(networkManagerMod, "getLink")},
			"aws_networkmanager_links":                        {Tok: awsDataSource(networkManagerMod, "getLinks")},
			"aws_networkmanager_site":                         {Tok: awsDataSource(networkManagerMod, "getSite")},
			"aws_networkmanager_sites":                        {Tok: awsDataSource(networkManagerMod, "getSites")},
			"aws_networkmanager_core_network_policy_document": {Tok: awsDataSource(networkManagerMod, "getCoreNetworkPolicyDocument")},
			// OpenSearch
			"aws_opensearch_domain": {Tok: awsDataSource(opensearchMod, "getDomain")},
			// Outposts
			"aws_outposts_outpost":                {Tok: awsDataSource(outpostsMod, "getOutpost")},
			"aws_outposts_outposts":               {Tok: awsDataSource(outpostsMod, "getOutposts")},
			"aws_outposts_outpost_instance_type":  {Tok: awsDataSource(outpostsMod, "getOutpostInstanceType")},
			"aws_outposts_outpost_instance_types": {Tok: awsDataSource(outpostsMod, "getOutpostInstanceTypes")},
			"aws_outposts_site":                   {Tok: awsDataSource(outpostsMod, "getSite")},
			"aws_outposts_sites":                  {Tok: awsDataSource(outpostsMod, "getSites")},
			"aws_outposts_asset":                  {Tok: awsDataSource(outpostsMod, "getAsset")},
			"aws_outposts_assets":                 {Tok: awsDataSource(outpostsMod, "getAssets")},
			// docdb
			"aws_docdb_orderable_db_instance":      {Tok: awsDataSource(docdbMod, "getOrderableDbInstance")},
			"aws_docdb_engine_version":             {Tok: awsDataSource(docdbMod, "getEngineVersion")},
			"aws_lex_slot_type":                    {Tok: awsDataSource(lexMod, "getSlotType")},
			"aws_lex_bot":                          {Tok: awsDataSource(lexMod, "getBot")},
			"aws_lex_bot_alias":                    {Tok: awsDataSource(lexMod, "getBotAlias")},
			"aws_lex_intent":                       {Tok: awsDataSource(lexMod, "getIntent")},
			"aws_neptune_orderable_db_instance":    {Tok: awsDataSource(neptuneMod, "getOrderableDbInstance")},
			"aws_neptune_engine_version":           {Tok: awsDataSource(neptuneMod, "getEngineVersion")},
			"aws_codeartifact_authorization_token": {Tok: awsDataSource(codeartifactMod, "getAuthorizationToken")},
			"aws_codeartifact_repository_endpoint": {Tok: awsDataSource(codeartifactMod, "getRepositoryEndpoint")},
			"aws_sagemaker_prebuilt_ecr_image":     {Tok: awsDataSource(sagemakerMod, "getPrebuiltEcrImage")},
			"aws_imagebuilder_component":           {Tok: awsDataSource(imageBuilderMod, "getComponent")},
			"aws_imagebuilder_distribution_configuration": {
				Tok: awsDataSource(imageBuilderMod, "getDistributionConfiguration"),
			},
			"aws_imagebuilder_infrastructure_configuration": {
				Tok: awsDataSource(imageBuilderMod, "getInfrastructureConfiguration"),
			},
			"aws_imagebuilder_image_pipeline":                {Tok: awsDataSource(imageBuilderMod, "getImagePipeline")},
			"aws_imagebuilder_image_recipe":                  {Tok: awsDataSource(imageBuilderMod, "getImageRecipe")},
			"aws_imagebuilder_image":                         {Tok: awsDataSource(imageBuilderMod, "getImage")},
			"aws_imagebuilder_image_recipes":                 {Tok: awsDataSource(imageBuilderMod, "getImageRecipes")},
			"aws_imagebuilder_components":                    {Tok: awsDataSource(imageBuilderMod, "getComponents")},
			"aws_imagebuilder_distribution_configurations":   {Tok: awsDataSource(imageBuilderMod, "getDistributionConfigurations")},
			"aws_imagebuilder_infrastructure_configurations": {Tok: awsDataSource(imageBuilderMod, "getInfrastructureConfigurations")},
			"aws_imagebuilder_container_recipe":              {Tok: awsDataSource(imageBuilderMod, "getContainerRecipe")},
			"aws_imagebuilder_container_recipes":             {Tok: awsDataSource(imageBuilderMod, "getContainerRecipes")},
			"aws_imagebuilder_image_pipelines":               {Tok: awsDataSource(imageBuilderMod, "getImagePipelines")},

			// ses
			"aws_ses_active_receipt_rule_set": {Tok: awsDataSource(sesMod, "getActiveReceiptRuleSet")},
			"aws_ses_domain_identity":         {Tok: awsDataSource(sesMod, "getDomainIdentity")},
			"aws_ses_email_identity":          {Tok: awsDataSource(sesMod, "getEmailIdentity")},
			// signer
			"aws_signer_signing_job":     {Tok: awsDataSource(signerMod, "getSigningJob")},
			"aws_signer_signing_profile": {Tok: awsDataSource(signerMod, "getSigningProfile")},
			// serverless repository
			"aws_serverlessapplicationrepository_application": {
				Tok: awsDataSource(serverlessRepositoryMod, "getApplication"),
			},
			// servicecatalog
			"aws_servicecatalog_constraint":             {Tok: awsDataSource(servicecatalogMod, "getConstraint")},
			"aws_servicecatalog_portfolio":              {Tok: awsDataSource(servicecatalogMod, "getPortfolio")},
			"aws_servicecatalog_product":                {Tok: awsDataSource(servicecatalogMod, "getProduct")},
			"aws_servicecatalog_launch_paths":           {Tok: awsDataSource(servicecatalogMod, "getLaunchPaths")},
			"aws_servicecatalog_portfolio_constraints":  {Tok: awsDataSource(servicecatalogMod, "getPortfolioConstraints")},
			"aws_servicecatalog_provisioning_artifacts": {Tok: awsDataSource(servicecatalogMod, "getProvisioningArtifacts")},

			// LakeFormation
			"aws_lakeformation_data_lake_settings": {Tok: awsDataSource(lakeFormationMod, "getDataLakeSettings")},
			"aws_lakeformation_permissions":        {Tok: awsDataSource(lakeFormationMod, "getPermissions")},
			"aws_lakeformation_resource":           {Tok: awsDataSource(lakeFormationMod, "getResource")},

			// SSO Admin
			"aws_ssoadmin_instances":      {Tok: awsDataSource(ssoAdminMod, "getInstances")},
			"aws_ssoadmin_permission_set": {Tok: awsDataSource(ssoAdminMod, "getPermissionSet")},

			// ApiGateway V2
			"aws_apigatewayv2_api":  {Tok: awsDataSource(apigatewayv2Mod, "getApi")},
			"aws_apigatewayv2_apis": {Tok: awsDataSource(apigatewayv2Mod, "getApis")},

			// ALB
			"aws_alb": {
				Tok:  awsDataSource(albMod, "getLoadBalancer"),
				Docs: &tfbridge.DocInfo{Source: "lb.html.markdown"},
				Fields: map[string]*tfbridge.SchemaInfo{
					// This attribute is flattened upstream. See
					// https://github.com/hashicorp/terraform-provider-aws/blob/c14a7fe82ab84aaa9db676c9ee4242e20fb33145/internal/service/elbv2/load_balancer_data_source.go#L319
					"access_logs": {MaxItemsOne: ref(true)},
				},
			},
			"aws_alb_listener": {
				Tok:  awsDataSource(albMod, "getListener"),
				Docs: &tfbridge.DocInfo{Source: "lb_listener.html.markdown"},
			},
			"aws_alb_target_group": {
				Tok:  awsDataSource(albMod, "getTargetGroup"),
				Docs: &tfbridge.DocInfo{Source: "lb_target_group.html.markdown"},
				Fields: map[string]*tfbridge.SchemaInfo{
					"health_check": {MaxItemsOne: ref(true)},
					"stickiness":   {MaxItemsOne: ref(true)},
				},
			},

			// Autoscaling
			"aws_autoscaling_groups": {Tok: awsDataSource(autoscalingMod, "getAmiIds")},

			// codestar connections
			"aws_codestarconnections_connection": {Tok: awsDataSource(codestarConnectionsMod, "getConnection")},

			// Resource groups tagging api
			"aws_resourcegroupstaggingapi_resources": {
				Tok: awsDataSource(resourcegroupsTaggingApiMod, "getResources"),
			},

			// Service Discovery
			"aws_service_discovery_dns_namespace":  {Tok: awsDataSource(servicediscoveryMod, "getDnsNamespace")},
			"aws_service_discovery_http_namespace": {Tok: awsDataSource(servicediscoveryMod, "getHttpNamespace")},
			"aws_service_discovery_service":        {Tok: awsDataSource(servicediscoveryMod, "getService")},

			// lb mod
			"aws_lb_hosted_zone_id": {Tok: awsDataSource(lbMod, "getHostedZoneId")},
			"aws_lbs":               {Tok: awsDataSource(lbMod, "getLbs")},
			"aws_lb": {
				Tok: awsDataSource(lbMod, "getLoadBalancer"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"access_logs": {
						MaxItemsOne: ref(true),
					},
				},
			},
			"aws_lb_listener": {Tok: awsDataSource(lbMod, "getListener")},
			"aws_lb_target_group": {
				Tok: awsDataSource(lbMod, "getTargetGroup"),
				Fields: map[string]*tfbridge.SchemaInfo{
					"stickiness": {
						MaxItemsOne: ref(true),
					},
					"health_check": {
						MaxItemsOne: ref(true),
					},
				},
			},

			// SES v2
			"aws_sesv2_dedicated_ip_pool": {Tok: awsDataSource(sesV2Mod, "getDedicatedIpPool")},
			"aws_sesv2_configuration_set": {Tok: awsDataSource(sesV2Mod, "getConfigurationSet")},

			// Control Tower
			"aws_controltower_controls": {Tok: awsDataSource(controlTowerMod, "getControls")},

			// Interactive Video Service
			"aws_ivs_stream_key": {Tok: awsDataSource(ivsMod, "getStreamKey")},

			// Quicksight
			"aws_quicksight_data_set": {Tok: awsDataSource(quicksightMod, "getDataSet")},
			"aws_quicksight_group":    {Tok: awsDataSource(quicksightMod, "getQuicksightGroup")},
			"aws_quicksight_user":     {Tok: awsDataSource(quicksightMod, "getQuicksightUser")},

			// VpcLattice
			"aws_vpclattice_service":  {Tok: awsDataSource(vpclatticeMod, "getService")},
			"aws_vpclattice_listener": {Tok: awsDataSource(vpclatticeMod, "getListener")},

			// Resource Explorer 2
			"aws_resourceexplorer2_search": {
				Tok: awsDataSource("ResourceExplorer", "Search"),
			},
		},
		JavaScript: &tfbridge.JavaScriptInfo{
			Dependencies: map[string]string{
				"@pulumi/pulumi":  "^3.0.0",
				"mime":            "^2.0.0",
				"builtin-modules": "3.0.0",
				"resolve":         "^1.7.1",
			},
			DevDependencies: map[string]string{
				"@types/node": "^10.0.0", // so we can access strongly typed node definitions.
				"@types/mime": "^2.0.0",
			},
			Overlay: &tfbridge.OverlayInfo{
				DestFiles: []string{
					"arn.ts",    // ARN typedef
					"region.ts", // Region constants
					"tags.ts",   // Tags typedef (currently unused but left for compatibility)
					"utils.ts",  // Helpers
				},
				Modules: map[string]*tfbridge.OverlayInfo{
					"autoscaling": {
						DestFiles: []string{
							"metrics.ts",          // Metric and MetricsGranularity constants
							"notificationType.ts", // NotificationType constants
						},
					},
					"alb": {
						DestFiles: []string{
							"ipAddressType.ts",    // IpAddressType constants
							"loadBalancerType.ts", // LoadBalancerType constants
						},
					},
					"applicationloadbalancing": {
						DestFiles: []string{
							"ipAddressType.ts",    // IpAddressType constants
							"loadBalancerType.ts", // LoadBalancerType constants
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
							"instanceType.ts",      // InstanceType constants
							"instancePlatform.ts",  // InstancePlatform constants
							"placementStrategy.ts", // PlacementStrategy constants
							"protocolType.ts",      // ProtocolType constants
							"tenancy.ts",           // Tenancy constants
						},
					},
					"ecr": {
						DestFiles: []string{
							"lifecyclePolicyDocument.ts",
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
							"managedPolicies.ts", // Deprecated ManagedPolicy constants.
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
							"runtimes.ts", // Runtime constants
							"lambdaMixins.ts",
						},
					},
					"rds": {
						DestFiles: []string{
							"engineMode.ts",   // EngineMode constants
							"engineType.ts",   // EngineType constants
							"instanceType.ts", // InstanceType constants
							"storageType.ts",  // StorageType constants
						},
					},
					"route53": {
						DestFiles: []string{
							"recordType.ts", // RecordType constants
						},
					},
					"s3": {
						DestFiles: []string{
							"cannedAcl.ts", // CannedAcl constants
							"routingRules.ts",
							"s3Mixins.ts",
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
							"parameterType.ts", // Deprecated ParameterType constants
						},
					},
				},
			},
		},
		Python: &tfbridge.PythonInfo{
			Requires: map[string]string{
				"pulumi": ">=3.0.0,<4.0.0",
			},
			PyProject: struct{ Enabled bool }{true},
		},
		Golang: &tfbridge.GolangInfo{
			ImportBasePath: filepath.Join(
				fmt.Sprintf("github.com/pulumi/pulumi-%[1]s/sdk/", awsPkg),
				tfbridge.GetModuleMajorVersion(version.Version),
				"go",
				awsPkg,
			),
			GenerateResourceContainerTypes: true,
		},
		CSharp: &tfbridge.CSharpInfo{
			PackageReferences: map[string]string{
				"Pulumi": "3.*",
			},
			Namespaces: namespaceMap,
		},
	}

	rAlias := func(token string, prev, current tokens.Type, info *tfbridge.ResourceInfo) {
		_, ok := prov.Resources[token]
		contract.Assertf(!ok, "We don't alias an existing resource")
		if info == nil {
			info = new(tfbridge.ResourceInfo)
		}
		info.Tok = current
		info.Aliases = append(info.Aliases, tfbridge.AliasInfo{Type: ref(string(prev))})
		prov.Resources[token] = info
	}

	// Fix the spelling mistake on `aws_ses_configuration_set` Tok
	rAlias("aws_ses_configuration_set",
		awsResource(sesMod, "ConfgurationSet"), awsResource(sesMod, "ConfigurationSet"),
		nil)

	// Define the tf `elb` resources.  For legacy compat we also export them from the `elasticloadbalancing` module
	// not just the `elb` module.
	rAlias("aws_app_cookie_stickiness_policy",
		awsResource(legacyElbMod, "AppCookieStickinessPolicy"),
		awsResource(elbMod, "AppCookieStickinessPolicy"),
		nil)
	rAlias("aws_elb",
		awsResource(legacyElbMod, "LoadBalancer"), awsResource(elbMod, "LoadBalancer"),
		nil)
	rAlias("aws_elb_attachment",
		awsResource(legacyElbMod, "Attachment"), awsResource(elbMod, "Attachment"),
		nil)
	rAlias("aws_lb_cookie_stickiness_policy",
		awsResource(legacyElbMod, "LoadBalancerCookieStickinessPolicy"),
		awsResource(elbMod, "LoadBalancerCookieStickinessPolicy"),
		nil)
	rAlias("aws_load_balancer_policy",
		awsResource(legacyElbMod, "LoadBalancerPolicy"), awsResource(elbMod, "LoadBalancerPolicy"),
		nil)
	rAlias("aws_load_balancer_listener_policy",
		awsResource(legacyElbMod, "ListenerPolicy"), awsResource(elbMod, "ListenerPolicy"),
		nil)
	rAlias("aws_lb_ssl_negotiation_policy",
		awsResource(legacyElbMod, "SslNegotiationPolicy"), awsResource(elbMod, "SslNegotiationPolicy"),
		nil)
	rAlias("aws_load_balancer_backend_server_policy",
		awsResource(legacyElbMod, "LoadBalancerBackendServerPolicy"),
		awsResource(elbMod, "LoadBalancerBackendServerPolicy"),
		nil)

	// Define the tf `lb` resources.  For legacy compat we also export them from the
	// `elasticloadbalancingv2` module not just the `lb` module.
	rAlias("aws_lb",
		awsResource(legacyElbv2Mod, "LoadBalancer"), awsResource(lbMod, "LoadBalancer"),
		nil)
	rAlias("aws_lb_listener",
		awsResource(legacyElbv2Mod, "Listener"), awsResource(lbMod, "Listener"),
		nil)
	rAlias("aws_lb_listener_certificate",
		awsResource(legacyElbv2Mod, "ListenerCertificate"), awsResource(lbMod, "ListenerCertificate"),
		nil)
	rAlias("aws_lb_listener_rule",
		awsResource(legacyElbv2Mod, "ListenerRule"), awsResource(lbMod, "ListenerRule"),
		nil)
	rAlias("aws_lb_target_group",
		awsResource(legacyElbv2Mod, "TargetGroup"),
		awsResource(lbMod, "TargetGroup"),
		&tfbridge.ResourceInfo{
			Fields: map[string]*tfbridge.SchemaInfo{
				// https://docs.aws.amazon.com/elasticloadbalancing/latest/APIReference/API_CreateTargetGroup.html
				"name": tfbridge.AutoName("name", 32, "-"),
				"deregistration_delay": {
					Type: "integer",
				},
			},
		})
	rAlias("aws_lb_target_group_attachment",
		awsResource(legacyElbv2Mod, "TargetGroupAttachment"), awsResource(lbMod, "TargetGroupAttachment"),
		nil)

	// Ec2 Transit Gateway
	rAlias("aws_ec2_transit_gateway_peering_attachment_accepter",
		awsResource(ec2Mod, "TransitGatewayPeeringAttachmentAccepter"),
		awsResource(ec2TransitGatewayMod, "PeeringAttachmentAccepter"),
		nil)

	// Define the tf `alb` resources.  For legacy compat we also export them from the `applicationloadbalancing` module
	// not just the `alb` module.
	rAlias("aws_alb", awsResource(legacyAlbMod, "LoadBalancer"),
		awsResource(albMod, "LoadBalancer"), &tfbridge.ResourceInfo{
			Fields: map[string]*tfbridge.SchemaInfo{
				"load_balancer_type": {Type: awsResource(albMod, "LoadBalancerType")},
				"ip_address_type":    {Type: awsResource(albMod, "IpAddressType")},
			},
			Docs: &tfbridge.DocInfo{Source: "lb.html.markdown"},
		})
	rAlias("aws_alb_listener", awsResource(legacyAlbMod, "Listener"),
		awsResource(albMod, "Listener"), &tfbridge.ResourceInfo{
			Docs: &tfbridge.DocInfo{Source: "lb_listener.html.markdown"},
		})
	rAlias("aws_alb_listener_certificate", awsResource(legacyAlbMod, "ListenerCertificate"),
		awsResource(albMod, "ListenerCertificate"), &tfbridge.ResourceInfo{
			Docs: &tfbridge.DocInfo{Source: "lb_listener_certificate.html.markdown"},
		})
	rAlias("aws_alb_listener_rule", awsResource(legacyAlbMod, "ListenerRule"),
		awsResource(albMod, "ListenerRule"), &tfbridge.ResourceInfo{
			Docs: &tfbridge.DocInfo{Source: "lb_listener_rule.html.markdown"},
		})
	rAlias("aws_alb_target_group", awsResource(legacyAlbMod, "TargetGroup"),
		awsResource(albMod, "TargetGroup"), &tfbridge.ResourceInfo{
			Docs: &tfbridge.DocInfo{Source: "lb_target_group.html.markdown"},
			Fields: map[string]*tfbridge.SchemaInfo{
				"deregistration_delay": {
					Type: "integer",
				},
			},
		})
	rAlias("aws_alb_target_group_attachment", awsResource(legacyAlbMod, "TargetGroupAttachment"),
		awsResource(albMod, "TargetGroupAttachment"), &tfbridge.ResourceInfo{
			Docs: &tfbridge.DocInfo{Source: "lb_target_group_attachment.html.markdown"},
		})

	// Add a CSharp-specific override for aws_s3_bucket.bucket.
	prov.Resources["aws_s3_bucket_legacy"].Fields["bucket"].CSharpName = "BucketName"

	pluginFrameworkResoures := map[string]*tfbridge.ResourceInfo{
		"aws_auditmanager_account_registration": {
			Tok: awsResource(auditmanagerMod, "AccountRegistration"),
		},
		"aws_auditmanager_assessment": {
			Tok: awsResource(auditmanagerMod, "Assessment"),
		},
		"aws_auditmanager_assessment_delegation": {
			Tok: awsResource(auditmanagerMod, "AssessmentDelegation"),
		},
		"aws_auditmanager_assessment_report": {
			Tok: awsResource(auditmanagerMod, "AssessmentReport"),
		},
		"aws_auditmanager_control": {
			Tok: awsResource(auditmanagerMod, "Control"),
		},
		"aws_auditmanager_framework": {
			Tok: awsResource(auditmanagerMod, "Framework"),
		},
		"aws_auditmanager_framework_share": {
			Tok: awsResource(auditmanagerMod, "FrameworkShare"),
		},
		"aws_auditmanager_organization_admin_account_registration": {
			Tok: awsResource(auditmanagerMod, "OrganizationAdminAccountRegistration"),
		},
		"aws_medialive_multiplex_program": {
			Tok: awsResource(medialiveMod, "MultiplexProgram"),
		},
		"aws_rds_export_task": {
			Tok: awsResource(rdsMod, "ExportTask"),
		},
		"aws_resourceexplorer2_index": {
			Tok: awsResource("ResourceExplorer", "Index"),
		},
		"aws_resourceexplorer2_view": {
			Tok: awsResource("ResourceExplorer", "View"),
		},
		"aws_route53_cidr_collection": {
			Tok: awsResource(route53Mod, "CidrCollection"),
		},
		"aws_route53_cidr_location": {
			Tok: awsResource(route53Mod, "CidrLocation"),
		},
		"aws_vpc_security_group_egress_rule": {
			Tok: awsResource("Vpc", "SecurityGroupEgressRule"),
		},
		"aws_vpc_security_group_ingress_rule": {
			Tok: awsResource("Vpc", "SecurityGroupIngressRule"),
		},
		"aws_quicksight_iam_policy_assignment": {
			Tok: awsResource("QuickSight", "IamPolicyAssignment"),
		},
		"aws_quicksight_ingestion": {
			Tok: awsResource("QuickSight", "Ingestion"),
		},
		"aws_quicksight_namespace": {
			Tok: awsResource("QuickSight", "Namespace"),
			Fields: map[string]*tfbridge.SchemaInfo{
				"namespace": {
					// Avoid conflict with "Namespace" class name that breaks compilation.
					CSharpName: "NameSpace",
				},
			},
		},
		"aws_quicksight_folder_membership": {
			Tok: awsResource("QuickSight", "FolderMembership"),
		},
		"aws_quicksight_refresh_schedule": {
			Tok: awsResource("QuickSight", "RefreshSchedule"),
		},
	}

	for k, v := range pluginFrameworkResoures {
		if _, conflict := prov.Resources[k]; conflict {
			panic(fmt.Sprintf("Resoruce already defined: %s", k))
		}
		prov.Resources[k] = v
	}

	prov.MustComputeTokens(tks.MappedModules("aws_", "", moduleMap,
		func(mod, name string) (string, error) {
			return awsResource(mod, name).String(), nil
		}))

	prov.P.ResourcesMap().Range(func(key string, res shim.Resource) bool {
		if !hasNonComputedTagsAndTagsAllOptimized(key, res) {
			return true
		}

		// We have ensured that this resource is using upstream's generic tagging
		// mechanism, so override check so it works.
		if callback := prov.Resources[key].PreCheckCallback; callback != nil {
			prov.Resources[key].PreCheckCallback = func(
				ctx context.Context, config resource.PropertyMap, meta resource.PropertyMap,
			) (resource.PropertyMap, error) {
				config, err := callback(ctx, config, meta)
				if err != nil {
					return nil, err
				}
				return applyTags(ctx, config, meta)
			}
		} else {
			prov.Resources[key].PreCheckCallback = applyTags
		}

		if prov.Resources[key].GetFields() == nil {
			prov.Resources[key].Fields = map[string]*tfbridge.SchemaInfo{}
		}
		fields := prov.Resources[key].GetFields()

		if _, ok := fields["tags_all"]; !ok {
			fields["tags_all"] = &tfbridge.SchemaInfo{}
		}

		// Upstream provider is edited to unmark tags_all as computed internally so that
		// Pulumi provider internals can set it, but the user should not be able to set it.
		fields["tags_all"].MarkAsComputedOnly = tfbridge.True()
		fields["tags_all"].DeprecationMessage = "Please use `tags` instead."
		fields["tags_all"].MarkAsOptional = tfbridge.False()

		return true
	})

	prov.SkipExamples = func(args tfbridge.SkipExamplesArgs) bool {
		// These examples hang on Go generation. Issue tracking to unblock:
		// https://github.com/pulumi/pulumi-aws/issues/2598
		return args.ExamplePath == "#/resources/aws:wafv2/ruleGroup:RuleGroup" ||
			args.ExamplePath == "#/resources/aws:wafv2/webAcl:WebAcl" ||
			args.ExamplePath == "#/resources/aws:appsync/graphQLApi:GraphQLApi"
	}

	setAutonaming(&prov)

	prov.MustApplyAutoAliases()

	prov.XSkipDetailedDiffForChanges = true

	return &prov
}

const nameProperty = "name"

// prov.SetAutonaming is too inefficient for AWS as it forces SchemaFunc calls for large resources
// that use up RAM. Instead of doing prov.SetAutonaming(255, "-") we call a surgically crafted
// setAutonaming that avoids these calls.
func setAutonaming(p *tfbridge.ProviderInfo) {
	maxLength := 255
	separator := "-"
	for resname, res := range p.Resources {
		// Only apply auto-name to input properties (Optional || Required) named `name`
		if !hasOptionalOrRequiredNamePropertyOptimized(p.P, resname) {
			continue
		}
		if _, hasfield := res.Fields[nameProperty]; !hasfield {
			if res.Fields == nil {
				res.Fields = make(map[string]*tfbridge.SchemaInfo)
			}
			res.Fields[nameProperty] = tfbridge.AutoName(nameProperty, maxLength, separator)
		}
	}
}

func hasOptionalOrRequiredNameProperty(p shim.Provider, tfResourceName string) bool {
	if schema := p.ResourcesMap().Get(tfResourceName); schema != nil {
		// Only apply auto-name to input properties (Optional || Required) named `name`
		if sch := schema.Schema().Get(nameProperty); sch != nil && (sch.Optional() || sch.Required()) {
			return true
		}
	}
	return false
}

func hasOptionalOrRequiredNamePropertyOptimized(p shim.Provider, tfResourceName string) bool {
	switch tfResourceName {
	case
		"aws_quicksight_account_subscription",
		"aws_quicksight_group",
		"aws_quicksight_group_membership",
		"aws_quicksight_user",
		"aws_wafv2_web_acl_association",
		"aws_wafv2_web_acl_logging_configuration":
		return false
	case "aws_medialive_channel",
		"aws_opsworks_custom_layer",
		"aws_opsworks_ecs_cluster_layer",
		"aws_opsworks_ganglia_layer",
		"aws_opsworks_haproxy_layer",
		"aws_opsworks_java_app_layer",
		"aws_opsworks_memcached_layer",
		"aws_opsworks_mysql_layer",
		"aws_opsworks_nodejs_app_layer",
		"aws_opsworks_php_app_layer",
		"aws_opsworks_rails_app_layer",
		"aws_quicksight_analysis",
		"aws_quicksight_dashboard",
		"aws_quicksight_data_set",
		"aws_quicksight_data_source",
		"aws_quicksight_template",
		"aws_quicksight_theme",
		"aws_wafv2_ip_set",
		"aws_wafv2_regex_pattern_set",
		"aws_wafv2_rule_group",
		"aws_wafv2_web_acl",
		"aws_kinesis_firehose_delivery_stream",
		"aws_opsworks_static_web_layer":
		return true
	}
	return hasOptionalOrRequiredNameProperty(p, tfResourceName)
}

// Like hasNonComputedTagsAndTagsAll but optimized with an ad-hoc cache to avoid calling
// SchemaFunc() and allocating memory at startup.
func hasNonComputedTagsAndTagsAllOptimized(tfResourceName string, res shim.Resource) bool {
	switch tfResourceName {
	case "aws_kinesis_firehose_delivery_stream",
		"aws_opsworks_custom_layer",
		"aws_opsworks_ecs_cluster_layer",
		"aws_opsworks_ganglia_layer",
		"aws_opsworks_haproxy_layer",
		"aws_opsworks_java_app_layer",
		"aws_opsworks_memcached_layer",
		"aws_opsworks_mysql_layer",
		"aws_opsworks_nodejs_app_layer",
		"aws_opsworks_php_app_layer",
		"aws_opsworks_rails_app_layer",
		"aws_opsworks_static_web_layer",
		"aws_quicksight_analysis",
		"aws_quicksight_dashboard",
		"aws_quicksight_data_set",
		"aws_quicksight_data_source",
		"aws_quicksight_template",
		"aws_quicksight_theme",
		"aws_wafv2_ip_set",
		"aws_wafv2_regex_pattern_set",
		"aws_wafv2_rule_group",
		"aws_wafv2_web_acl",
		"aws_medialive_channel":
		return true
	case "aws_quicksight_user",
		"aws_wafv2_web_acl_logging_configuration",
		"aws_quicksight_group_membership",
		"aws_wafv2_web_acl_association",
		"aws_quicksight_group",
		"aws_quicksight_account_subscription":
		return false
	}

	return hasNonComputedTagsAndTagsAll(tfResourceName, res)
}

func hasNonComputedTagsAndTagsAll(tfResourceName string, res shim.Resource) bool {
	// Skip resources that don't have tags.
	tagsF, ok := res.Schema().GetOk("tags")
	if !ok {
		return false
	}
	// Skip resources that don't have tags_all.
	_, ok = res.Schema().GetOk("tags_all")
	if !ok {
		return false
	}
	// tags must be non-computed.
	if tagsF.Computed() {
		return false
	}
	return true
}
