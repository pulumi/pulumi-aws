package provider

import (
	"fmt"
	"strings"
	"sync"
	"unicode"

	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	tks "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge/tokens"
	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge/tokens/fallbackstrat"
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
	appFabricMod                = "AppFabric"                // AppFabric
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
	arcRegionSwitchMod          = "ArcRegionSwitch"          // ARC Region Switch
	arcZonalShiftMod            = "ArcZonalShift"            // ARC Zonal Shift
	athenaMod                   = "Athena"                   // Athena
	auditmanagerMod             = "Auditmanager"             // Audit Manager
	autoscalingMod              = "AutoScaling"              // Auto Scaling
	autoscalingPlansMod         = "AutoScalingPlans"         // Auto Scaling Plans
	backupMod                   = "Backup"                   // Backup
	batchMod                    = "Batch"                    // Batch
	bedrockFoundationMod        = "BedrockFoundation"        // BedrockFoundation
	bedrockModelMod             = "BedrockModel"             // BedrockModel
	bedrockMod                  = "Bedrock"                  // Bedrock
	billingMod                  = "Billing"                  // Billing
	bcmDataMod                  = "BcmData"                  // Billing and Cost Management Data
	budgetsMod                  = "Budgets"                  // Budgets
	chatbotMod                  = "Chatbot"                  // Chatbot
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
	codeconnectionsMod          = "CodeConnections"          // Code Connections
	codedeployMod               = "CodeDeploy"               // Code Deploy
	codeguruReviewerMod         = "CodeGuruReviewer"         // CodeGuru Reviewer
	codepipelineMod             = "CodePipeline"             // Code Pipeline
	codestarConnectionsMod      = "CodeStarConnections"      // CodeStar Connections
	codestarNotificationsMod    = "CodeStarNotifications"    // CodeStar Notifications
	computeOptimizerMod         = "ComputeOptimizer"         // Compute Optimizer
	costOptimizationHubMod      = "CostOptimizationHub"      // Cost Optimization Hub
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
	datazoneMod                 = "DataZone"                 // DataZone
	daxMod                      = "Dax"                      // DynamoDB Accelerator
	devopsGuruMod               = "DevOpsGuru"               // DevOps Guru
	dlmMod                      = "Dlm"                      // Data Lifecycle Manager
	detectiveMod                = "Detective"                // Detective
	devicefarmMod               = "DeviceFarm"               // Device Farm
	directoryserviceMod         = "DirectoryService"         // Directory Services
	docdbMod                    = "DocDB"                    // Document DB
	drsMod                      = "Drs"                      // Elastic Disaster Recovery (DRS)
	dsqlMod                     = "Dsql"                     // Amazon Aurora DSQL
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
	mailManagerMod              = "MailManager"              // SES Mail Manager
	mediaconvertMod             = "MediaConvert"             // Media Convert
	medialiveMod                = "MediaLive"                // Media Live
	mediapackageMod             = "MediaPackage"             // Elemental MediaPackage
	mediapackagev2Mod           = "MediaPackageV2"           // Elemental MediaPackage Version 2
	mediastoreMod               = "MediaStore"               // Elemental MediaStore
	memoryDbMod                 = "MemoryDb"                 // Memory DB
	mqMod                       = "Mq"                       // MQ
	mskMod                      = "Msk"                      // MSK
	mskConnectMod               = "MskConnect"               // MSK Connect
	mwaaMod                     = "Mwaa"                     // Managed Workflows for Apache Airflow
	neptuneMod                  = "Neptune"                  // Neptune
	neptuneGraphMod             = "NeptuneGraph"             // Neptune Graph
	networkFirewallMod          = "NetworkFirewall"          // Network Firewall
	networkManagerMod           = "NetworkManager"           // Network Manager
	networkMonitorMod           = "NetworkMonitor"           // Network Monitor
	notificationsMod            = "Notifications"            // Notifications
	notificationsContactsMod    = "NotificationsContacts"    // Notifications Contacts
	oamMod                      = "Oam"                      // Observability Access Manager
	odbMod                      = "Odb"                      // Oracle Database@AWS
	opensearchMod               = "OpenSearch"               // OpenSearch
	organizationsMod            = "Organizations"            // Organizations
	osisMod                     = "OpenSearchIngest"         // Open Search Ingestion Service
	outpostsMod                 = "Outposts"                 // Outposts
	paymentCryptographyMod      = "PaymentCryptography"      // Payment Cryptography
	pinpointMod                 = "Pinpoint"                 // Pinpoint
	pipesMod                    = "Pipes"                    // Pipes
	pricingMod                  = "Pricing"                  // Pricing
	pricingPlanManagerMod       = "PricingPlanManager"       // Pricing Plan Manager
	qldbMod                     = "Qldb"                     // QLDB
	quicksightMod               = "Quicksight"               // Quicksight
	ramMod                      = "Ram"                      // Resource Access Manager
	resilienceHubMod            = "ResilienceHub"            // Resilience Hub
	rbinMod                     = "Rbin"                     // Recycle Bin
	rdsMod                      = "Rds"                      // Relational Database Service (RDS)
	rekognitionMod              = "Rekognition"              // Amazon Rekognition"
	redshiftMod                 = "RedShift"                 // RedShift
	redshiftDataMod             = "RedshiftData"             // RedshiftData
	redshiftServerlessMod       = "RedshiftServerless"       // Redshift Serverless
	resourcegroupsMod           = "ResourceGroups"           // Resource Groups
	resourcegroupsTaggingAPIMod = "ResourceGroupsTaggingApi" // Resource Groups Tagging Api
	rolesAnywhereMod            = "RolesAnywhere"            // Roles Anywhere
	route53Mod                  = "Route53"                  // Route 53 (DNS)
	route53RecoveryControlMod   = "Route53RecoveryControl"   // Route 53 Recovery Control
	route53RecoveryReadinessMod = "Route53RecoveryReadiness" // Route 53 Recovery Readiness
	route53DomainsMod           = "Route53Domains"           // Route 53 Domains
	rumMod                      = "Rum"                      // RUM
	sagemakerMod                = "Sagemaker"                // Sagemaker
	savingsPlansMod             = "SavingsPlans"             // Savings Plans
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
	s3TablesMod                 = "S3Tables"                 // S3 Tables
	ssmMod                      = "Ssm"                      // System Manager
	ssmContactsMod              = "SsmContacts"              // Systems Manager Incident Manager Contacts
	ssmIncidentsMod             = "SsmIncidents"             // Systems Manager Incident Manager
	secretsmanagerMod           = "SecretsManager"           // Secrets Manager
	servicecatalogMod           = "ServiceCatalog"           // Service Catalog
	servicediscoveryMod         = "ServiceDiscovery"         // Service Discovery
	servicequotasMod            = "ServiceQuotas"            // Service Quotas
	sfnMod                      = "Sfn"                      // Step Functions (SFN)
	shieldMod                   = "Shield"                   // Shield
	snsMod                      = "Sns"                      // Simple Notification Service (SNS)
	sqsMod                      = "Sqs"                      // Simple Queueing Service (SQS)
	ssoAdminMod                 = "SsoAdmin"                 // SSO Admin
	storagegatewayMod           = "StorageGateway"           // Storage Gateway
	swfMod                      = "Swf"                      // Simple Workflow Service (SWF)
	syntheticsMod               = "Synthetics"               // Synthetics
	timestreamInfluxDBMod       = "TimestreamInfluxDB"       // Timestream Influx DB
	timestreamWriteMod          = "TimestreamWrite"          // Timestream Write
	timestreamQuery             = "TimestreamQuery"          // Timestream Query"
	transcribeMod               = "Transcribe"               // Transcribe
	transferMod                 = "Transfer"                 // Transfer Service
	uxcMod                      = "Uxc"                      // User Experience Customization
	verifiedpermissionsMod      = "VerifiedPermissions"      // Verified Permissions
	verifiedaccessMod           = "VerifiedAccess"           // Verified Access
	vpcMod                      = "Vpc"                      // VPC
	vpclatticeMod               = "VpcLattice"               // VPC Lattice
	wafMod                      = "Waf"                      // Web Application Firewall (WAF)
	wafV2Mod                    = "WafV2"                    // Web Application Firewall V2 (WAFV2)
	wafregionalMod              = "WafRegional"              // Web Application Firewall (WAF) Regional
	workmailMod                 = "WorkMail"                 // WorkMail
	workspacesMod               = "Workspaces"               // Workspaces
	workspaceswebMod            = "WorkSpacesWeb"            // WorkSpaces Web
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
	"appfabric":                       appFabricMod,
	"appflow":                         appFlowMod,
	"appintegrations":                 appIntegrationsMod,
	"applicationinsights":             applicationInsightsMod,
	"appmesh":                         appmeshMod,
	"apprunner":                       appRunnerMod,
	"appstream":                       appStreamMod,
	"appsync":                         appsyncMod,
	"arcregionswitch":                 arcRegionSwitchMod,
	"arczonalshift":                   arcZonalShiftMod,
	"athena":                          athenaMod,
	"auditmanager":                    auditmanagerMod,
	"autoscaling":                     autoscalingMod,
	"autoscalingplans":                autoscalingPlansMod,
	"backup":                          backupMod,
	"batch":                           batchMod,
	"bedrock_foundation":              bedrockFoundationMod,
	"bedrock_model":                   bedrockModelMod,
	"bedrock":                         bedrockMod,
	"billing":                         billingMod,
	"bcmdataexports":                  bcmDataMod,
	"budgets":                         budgetsMod,
	"ce":                              costExplorerMod,
	"chatbot":                         chatbotMod,
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
	"codeconnections":                 codeconnectionsMod,
	"codedeploy":                      codedeployMod,
	"codeguruprofiler":                "CodeGuruProfiler",
	"codegurureviewer":                codeguruReviewerMod,
	"codepipeline":                    codepipelineMod,
	"codestarconnections":             codestarConnectionsMod,
	"codestarnotifications":           codestarNotificationsMod,
	"computeoptimizer":                computeOptimizerMod,
	"costoptimizationhub":             costOptimizationHubMod,
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
	"datazone":                        datazoneMod,
	"dax":                             daxMod,
	"devopsguru":                      devopsGuruMod,
	"db":                              rdsMod,
	"detective":                       detectiveMod,
	"devicefarm":                      devicefarmMod,
	"directory_service":               directoryserviceMod,
	"dlm":                             dlmMod,
	"dms":                             dmsMod,
	"docdb":                           docdbMod,
	"dsql":                            dsqlMod,
	"drs":                             drsMod,
	"dx":                              dxMod,
	"dynamodb":                        dynamodbMod,
	"ebs":                             ebsMod,
	"ec2":                             ec2Mod,
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
	"invoicing":                       "Invoicing",
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
	"mailmanager":                     mailManagerMod,
	"media_convert":                   mediaconvertMod,
	"media_package":                   mediapackageMod,
	"media_packagev2":                 mediapackagev2Mod,
	"media_store":                     mediastoreMod,
	"medialive":                       medialiveMod,
	"memorydb":                        memoryDbMod,
	"mq":                              mqMod,
	"msk":                             mskMod,
	"mskconnect":                      mskConnectMod,
	"mwaa":                            mwaaMod,
	"neptune":                         neptuneMod,
	"neptunegraph":                    neptuneGraphMod,
	"networkfirewall":                 networkFirewallMod,
	"networkmanager":                  networkManagerMod,
	"networkmonitor":                  networkMonitorMod,
	"networkflowmonitor":              "Networkflowmonitor",
	"notifications":                   notificationsMod,
	"notificationsContacts":           notificationsContactsMod,
	"oam":                             oamMod,
	"observabilityadmin":              "Observabilityadmin",
	"odb":                             odbMod,
	"opensearch":                      opensearchMod,
	"organizations":                   organizationsMod,
	"osis":                            osisMod,
	"outposts":                        outpostsMod,
	"paymentcryptography":             paymentCryptographyMod,
	"pinpoint":                        pinpointMod,
	"pipes":                           pipesMod,
	"polly":                           "Polly",
	"pricing":                         pricingMod,
	"pricingplanmanager":              pricingPlanManagerMod,
	"prometheus":                      ampMod,
	"qbusiness":                       "Qbusiness",
	"qldb":                            qldbMod,
	"quicksight":                      quicksightMod,
	"ram":                             ramMod,
	"rbin":                            rbinMod,
	"rds":                             rdsMod,
	"redshift":                        redshiftMod,
	"redshiftdata":                    redshiftDataMod,
	"redshiftserverless":              redshiftServerlessMod,
	"rekognition":                     rekognitionMod,
	"resiliencehub":                   resilienceHubMod,
	"resourceexplorer2":               "ResourceExplorer",
	"resourcegroups":                  resourcegroupsMod,
	"resourcegroupstaggingapi":        resourcegroupsTaggingAPIMod,
	"rolesanywhere":                   rolesAnywhereMod,
	"route53":                         route53Mod,
	"route53domains":                  route53DomainsMod,
	"route53recoverycontrolconfig":    route53RecoveryControlMod,
	"route53recoveryreadiness":        route53RecoveryReadinessMod,
	"rum":                             rumMod,
	"s3":                              s3Mod,
	"s3control":                       s3ControlMod,
	"s3outposts":                      s3OutpostsMod,
	"s3tables":                        s3TablesMod,
	"sagemaker":                       sagemakerMod,
	"savingsplans":                    savingsPlansMod,
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
	"sns":                             snsMod,
	"sqs":                             sqsMod,
	"ssm":                             ssmMod,
	"ssmincidents":                    ssmIncidentsMod,
	"ssoadmin":                        ssoAdminMod,
	"storagegateway":                  storagegatewayMod,
	"swf":                             swfMod,
	"synthetics":                      syntheticsMod,
	"timestreaminfluxdb":              timestreamInfluxDBMod,
	"timestreamwrite":                 timestreamWriteMod,
	"timestreamquery":                 timestreamQuery,
	"transcribe":                      transcribeMod,
	"transfer":                        transferMod,
	"uxc":                             uxcMod,
	"verifiedaccess":                  verifiedaccessMod,
	"verifiedpermissions":             verifiedpermissionsMod,
	"vpc":                             vpcMod,
	"vpclattice":                      vpclatticeMod,
	"waf":                             wafMod,
	"wafregional":                     wafregionalMod,
	"wafv2":                           wafV2Mod,
	"workmail":                        workmailMod,
	"workspaces":                      workspacesMod,
	"workspacesweb":                   workspaceswebMod,
	"xray":                            xrayMod,
}

var namespaceMap = map[string]string{
	"aws": "Aws",
}

var _nslock = sync.Mutex{}

// awsMember manufactures a type token for the AWS package and the given module, file name, and type.
func awsMember(moduleTitle string, fn string, mem string) tokens.ModuleMember {
	moduleName := strings.ToLower(moduleTitle)
	_nslock.Lock()
	defer _nslock.Unlock()
	namespaceMap[moduleName] = moduleTitle
	if fn != "" {
		moduleName += "/" + fn
	}
	return tokens.ModuleMember(awsPkg + ":" + moduleName + ":" + mem)
}

// awsType manufactures a type token for the AWS package and the given module, file name, and type.
func awsType(mod string, fileName string, typ string) tokens.Type {
	return tokens.Type(awsMember(mod, fileName, typ))
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

func awsTokenStrategy(prov *tfbridge.ProviderInfo) tks.Strategy {
	finalize := func(mod, name string) (string, error) {
		if name == "" {
			return "", fmt.Errorf("cannot make an AWS token with an empty name in module %q", mod)
		}
		return awsResource(mod, name).String(), nil
	}

	strategy, err := fallbackstrat.MappedModulesWithInferredFallback(
		prov, "aws_", "", moduleMap, finalize)
	contract.AssertNoErrorf(err, "failed to compute token strategy")

	// The fallback helper currently omits the top-level Terraform function strategy.
	// Preserve MappedModules' function behavior until the bridge helper includes it.
	strategy.Function = tks.MappedModules("aws_", "", moduleMap, finalize).Function
	return strategy
}
