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

/* tslint:disable:max-line-length ordered-imports variable-name */
import {ARN} from "../arn";

/** Use ManagedPolicy instead. */
export module ManagedPolicies {
    /** Use ManagedPolicy.AWSAccountActivityAccess instead. */
    export const AWSAccountActivityAccess: ARN = "arn:aws:iam::aws:policy/AWSAccountActivityAccess";
    /** Use ManagedPolicy.AWSAccountUsageReportAccess instead. */
    export const AWSAccountUsageReportAccess: ARN = "arn:aws:iam::aws:policy/AWSAccountUsageReportAccess";
    /** Use ManagedPolicy.AWSAgentlessDiscoveryService instead. */
    export const AWSAgentlessDiscoveryService: ARN = "arn:aws:iam::aws:policy/AWSAgentlessDiscoveryService";
    /** Use ManagedPolicy.AWSApplicationDiscoveryAgentAccess instead. */
    export const AWSApplicationDiscoveryAgentAccess: ARN = "arn:aws:iam::aws:policy/AWSApplicationDiscoveryAgentAccess";
    /** Use ManagedPolicy.AWSApplicationDiscoveryServiceFullAccess instead. */
    export const AWSApplicationDiscoveryServiceFullAccess: ARN = "arn:aws:iam::aws:policy/AWSApplicationDiscoveryServiceFullAccess";
    /** Use ManagedPolicy.AWSBatchFullAccess instead. */
    export const AWSBatchFullAccess: ARN = "arn:aws:iam::aws:policy/AWSBatchFullAccess";
    /** Use ManagedPolicy.AWSBatchServiceRole instead. */
    export const AWSBatchServiceRole: ARN = "arn:aws:iam::aws:policy/service-role/AWSBatchServiceRole";
    /** Use ManagedPolicy.AWSCertificateManagerFullAccess instead. */
    export const AWSCertificateManagerFullAccess: ARN = "arn:aws:iam::aws:policy/AWSCertificateManagerFullAccess";
    /** Use ManagedPolicy.AWSCertificateManagerReadOnly instead. */
    export const AWSCertificateManagerReadOnly: ARN = "arn:aws:iam::aws:policy/AWSCertificateManagerReadOnly";
    /** Use ManagedPolicy.AWSCloudFormationReadOnlyAccess instead. */
    export const AWSCloudFormationReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AWSCloudFormationReadOnlyAccess";
    /** Use ManagedPolicy.AWSCloudHSMFullAccess instead. */
    export const AWSCloudHSMFullAccess: ARN = "arn:aws:iam::aws:policy/AWSCloudHSMFullAccess";
    /** Use ManagedPolicy.AWSCloudHSMReadOnlyAccess instead. */
    export const AWSCloudHSMReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AWSCloudHSMReadOnlyAccess";
    /** Use ManagedPolicy.AWSCloudHSMRole instead. */
    export const AWSCloudHSMRole: ARN = "arn:aws:iam::aws:policy/service-role/AWSCloudHSMRole";
    /** Use ManagedPolicy.AWSCloudTrailFullAccess instead. */
    export const AWSCloudTrailFullAccess: ARN = "arn:aws:iam::aws:policy/AWSCloudTrailFullAccess";
    /** Use ManagedPolicy.AWSCloudTrailReadOnlyAccess instead. */
    export const AWSCloudTrailReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AWSCloudTrailReadOnlyAccess";
    /** Use ManagedPolicy.AWSCodeBuildAdminAccess instead. */
    export const AWSCodeBuildAdminAccess: ARN = "arn:aws:iam::aws:policy/AWSCodeBuildAdminAccess";
    /** Use ManagedPolicy.AWSCodeBuildDeveloperAccess instead. */
    export const AWSCodeBuildDeveloperAccess: ARN = "arn:aws:iam::aws:policy/AWSCodeBuildDeveloperAccess";
    /** Use ManagedPolicy.AWSCodeBuildReadOnlyAccess instead. */
    export const AWSCodeBuildReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AWSCodeBuildReadOnlyAccess";
    /** Use ManagedPolicy.AWSCodeCommitFullAccess instead. */
    export const AWSCodeCommitFullAccess: ARN = "arn:aws:iam::aws:policy/AWSCodeCommitFullAccess";
    /** Use ManagedPolicy.AWSCodeCommitPowerUser instead. */
    export const AWSCodeCommitPowerUser: ARN = "arn:aws:iam::aws:policy/AWSCodeCommitPowerUser";
    /** Use ManagedPolicy.AWSCodeCommitReadOnly instead. */
    export const AWSCodeCommitReadOnly: ARN = "arn:aws:iam::aws:policy/AWSCodeCommitReadOnly";
    /** Use ManagedPolicy.AWSCodeDeployDeployerAccess instead. */
    export const AWSCodeDeployDeployerAccess: ARN = "arn:aws:iam::aws:policy/AWSCodeDeployDeployerAccess";
    /** Use ManagedPolicy.AWSCodeDeployFullAccess instead. */
    export const AWSCodeDeployFullAccess: ARN = "arn:aws:iam::aws:policy/AWSCodeDeployFullAccess";
    /** Use ManagedPolicy.AWSCodeDeployReadOnlyAccess instead. */
    export const AWSCodeDeployReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AWSCodeDeployReadOnlyAccess";
    /** Use ManagedPolicy.AWSCodeDeployRole instead. */
    export const AWSCodeDeployRole: ARN = "arn:aws:iam::aws:policy/service-role/AWSCodeDeployRole";
    /** Use ManagedPolicy.AWSCodeDeployRoleForECS instead. */
    export const AWSCodeDeployRoleForECS: ARN = "arn:aws:iam::aws:policy/AWSCodeDeployRoleForECS";
    /** Use ManagedPolicy.AWSCodePipelineApproverAccess instead. */
    export const AWSCodePipelineApproverAccess: ARN = "arn:aws:iam::aws:policy/AWSCodePipelineApproverAccess";
    /** Use ManagedPolicy.AWSCodePipelineCustomActionAccess instead. */
    export const AWSCodePipelineCustomActionAccess: ARN = "arn:aws:iam::aws:policy/AWSCodePipelineCustomActionAccess";
    /** Use ManagedPolicy.AWSCodePipelineFullAccess instead. */
    export const AWSCodePipelineFullAccess: ARN = "arn:aws:iam::aws:policy/AWSCodePipelineFullAccess";
    /** Use ManagedPolicy.AWSCodePipelineReadOnlyAccess instead. */
    export const AWSCodePipelineReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AWSCodePipelineReadOnlyAccess";
    /** Use ManagedPolicy.AWSCodeStarFullAccess instead. */
    export const AWSCodeStarFullAccess: ARN = "arn:aws:iam::aws:policy/AWSCodeStarFullAccess";
    /** Use ManagedPolicy.AWSCodeStarServiceRole instead. */
    export const AWSCodeStarServiceRole: ARN = "arn:aws:iam::aws:policy/service-role/AWSCodeStarServiceRole";
    /** Use ManagedPolicy.AWSConfigRole instead. */
    export const AWSConfigRole: ARN = "arn:aws:iam::aws:policy/service-role/AWSConfigRole";
    /** Use ManagedPolicy.AWSConfigRulesExecutionRole instead. */
    export const AWSConfigRulesExecutionRole: ARN = "arn:aws:iam::aws:policy/service-role/AWSConfigRulesExecutionRole";
    /** Use ManagedPolicy.AWSConfigUserAccess instead. */
    export const AWSConfigUserAccess: ARN = "arn:aws:iam::aws:policy/AWSConfigUserAccess";
    /** Use ManagedPolicy. AWSConnector instead. */
    export const AWSConnector: ARN = "arn:aws:iam::aws:policy/AWSConnector";
    /** Use ManagedPolicy.AWSDataPipelineRole instead. */
    export const AWSDataPipelineRole: ARN = "arn:aws:iam::aws:policy/service-role/AWSDataPipelineRole";
    /** Use ManagedPolicy.AWSDataPipeline_FullAccess instead. */
    export const AWSDataPipeline_FullAccess: ARN = "arn:aws:iam::aws:policy/AWSDataPipeline_FullAccess";
    /** Use ManagedPolicy.AWSDataPipeline_PowerUser instead. */
    export const AWSDataPipeline_PowerUser: ARN = "arn:aws:iam::aws:policy/AWSDataPipeline_PowerUser";
    /** Use ManagedPolicy.AWSDeviceFarmFullAccess instead. */
    export const AWSDeviceFarmFullAccess: ARN = "arn:aws:iam::aws:policy/AWSDeviceFarmFullAccess";
    /** Use ManagedPolicy.AWSDirectConnectFullAccess instead. */
    export const AWSDirectConnectFullAccess: ARN = "arn:aws:iam::aws:policy/AWSDirectConnectFullAccess";
    /** Use ManagedPolicy.AWSDirectConnectReadOnlyAccess instead. */
    export const AWSDirectConnectReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AWSDirectConnectReadOnlyAccess";
    /** Use ManagedPolicy.AWSDirectoryServiceFullAccess instead. */
    export const AWSDirectoryServiceFullAccess: ARN = "arn:aws:iam::aws:policy/AWSDirectoryServiceFullAccess";
    /** Use ManagedPolicy.AWSDirectoryServiceReadOnlyAccess instead. */
    export const AWSDirectoryServiceReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AWSDirectoryServiceReadOnlyAccess";
    /** Use ManagedPolicy.AWSElasticBeanstalkCustomPlatformforEC2Role instead. */
    export const AWSElasticBeanstalkCustomPlatformforEC2Role: ARN = "arn:aws:iam::aws:policy/AWSElasticBeanstalkCustomPlatformforEC2Role";
    /** Use ManagedPolicy.AWSElasticBeanstalkEnhancedHealth instead. */
    export const AWSElasticBeanstalkEnhancedHealth: ARN = "arn:aws:iam::aws:policy/service-role/AWSElasticBeanstalkEnhancedHealth";
    /** Use ManagedPolicy.AWSElasticBeanstalkFullAccess instead. */
    export const AWSElasticBeanstalkFullAccess: ARN = "arn:aws:iam::aws:policy/AWSElasticBeanstalkFullAccess";
    /** Use ManagedPolicy.AWSElasticBeanstalkMulticontainerDocker instead. */
    export const AWSElasticBeanstalkMulticontainerDocker: ARN = "arn:aws:iam::aws:policy/AWSElasticBeanstalkMulticontainerDocker";
    /** Use ManagedPolicy.AWSElasticBeanstalkReadOnlyAccess instead. */
    export const AWSElasticBeanstalkReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AWSElasticBeanstalkReadOnlyAccess";
    /** Use ManagedPolicy.AWSElasticBeanstalkService instead. */
    export const AWSElasticBeanstalkService: ARN = "arn:aws:iam::aws:policy/service-role/AWSElasticBeanstalkService";
    /** Use ManagedPolicy.AWSElasticBeanstalkWebTier instead. */
    export const AWSElasticBeanstalkWebTier: ARN = "arn:aws:iam::aws:policy/AWSElasticBeanstalkWebTier";
    /** Use ManagedPolicy.AWSElasticBeanstalkWorkerTier instead. */
    export const AWSElasticBeanstalkWorkerTier: ARN = "arn:aws:iam::aws:policy/AWSElasticBeanstalkWorkerTier";
    /** Use ManagedPolicy.AWSGreengrassFullAccess instead. */
    export const AWSGreengrassFullAccess: ARN = "arn:aws:iam::aws:policy/AWSGreengrassFullAccess";
    /** Use ManagedPolicy.AWSGreengrassResourceAccessRolePolicy instead. */
    export const AWSGreengrassResourceAccessRolePolicy: ARN = "arn:aws:iam::aws:policy/service-role/AWSGreengrassResourceAccessRolePolicy";
    /** Use ManagedPolicy.AWSHealthFullAccess instead. */
    export const AWSHealthFullAccess: ARN = "arn:aws:iam::aws:policy/AWSHealthFullAccess";
    /** Use ManagedPolicy.AWSImportExportFullAccess instead. */
    export const AWSImportExportFullAccess: ARN = "arn:aws:iam::aws:policy/AWSImportExportFullAccess";
    /** Use ManagedPolicy.AWSImportExportReadOnlyAccess instead. */
    export const AWSImportExportReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AWSImportExportReadOnlyAccess";
    /** Use ManagedPolicy.AWSIoTConfigAccess instead. */
    export const AWSIoTConfigAccess: ARN = "arn:aws:iam::aws:policy/AWSIoTConfigAccess";
    /** Use ManagedPolicy.AWSIoTConfigReadOnlyAccess instead. */
    export const AWSIoTConfigReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AWSIoTConfigReadOnlyAccess";
    /** Use ManagedPolicy.AWSIoTDataAccess instead. */
    export const AWSIoTDataAccess: ARN = "arn:aws:iam::aws:policy/AWSIoTDataAccess";
    /** Use ManagedPolicy.AWSIoTFullAccess instead. */
    export const AWSIoTFullAccess: ARN = "arn:aws:iam::aws:policy/AWSIoTFullAccess";
    /** Use ManagedPolicy.AWSIoTLogging instead. */
    export const AWSIoTLogging: ARN = "arn:aws:iam::aws:policy/service-role/AWSIoTLogging";
    /** Use ManagedPolicy.AWSIoTRuleActions instead. */
    export const AWSIoTRuleActions: ARN = "arn:aws:iam::aws:policy/service-role/AWSIoTRuleActions";
    /** Use ManagedPolicy.AWSKeyManagementServicePowerUser instead. */
    export const AWSKeyManagementServicePowerUser: ARN = "arn:aws:iam::aws:policy/AWSKeyManagementServicePowerUser";
    /** Use ManagedPolicy.AWSLambdaBasicExecutionRole instead. */
    export const AWSLambdaBasicExecutionRole: ARN = "arn:aws:iam::aws:policy/service-role/AWSLambdaBasicExecutionRole";
    /** Use ManagedPolicy.AWSLambdaDynamoDBExecutionRole instead. */
    export const AWSLambdaDynamoDBExecutionRole: ARN = "arn:aws:iam::aws:policy/service-role/AWSLambdaDynamoDBExecutionRole";
    /** Use ManagedPolicy.AWSLambdaENIManagementAccess instead. */
    export const AWSLambdaENIManagementAccess: ARN = "arn:aws:iam::aws:policy/service-role/AWSLambdaENIManagementAccess";
    /** Use ManagedPolicy.AWSLambdaExecute instead. */
    export const AWSLambdaExecute: ARN = "arn:aws:iam::aws:policy/AWSLambdaExecute";
    /** Use ManagedPolicy.AWSLambdaFullAccess instead. */
    export const AWSLambdaFullAccess: ARN = "arn:aws:iam::aws:policy/AWSLambdaFullAccess";
    /** Use ManagedPolicy.AWSLambdaInvocationDynamoDB instead. */
    export const AWSLambdaInvocationDynamoDB: ARN = "arn:aws:iam::aws:policy/AWSLambdaInvocation-DynamoDB";
    /** Use ManagedPolicy.AWSLambdaKinesisExecutionRole instead. */
    export const AWSLambdaKinesisExecutionRole: ARN = "arn:aws:iam::aws:policy/service-role/AWSLambdaKinesisExecutionRole";
    /** Use ManagedPolicy.AWSLambdaReadOnlyAccess instead. */
    export const AWSLambdaReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AWSLambdaReadOnlyAccess";
    /** Use ManagedPolicy.AWSLambdaRole instead. */
    export const AWSLambdaRole: ARN = "arn:aws:iam::aws:policy/service-role/AWSLambdaRole";
    /** Use ManagedPolicy.AWSLambdaVPCAccessExecutionRole instead. */
    export const AWSLambdaVPCAccessExecutionRole: ARN = "arn:aws:iam::aws:policy/service-role/AWSLambdaVPCAccessExecutionRole";
    /** Use ManagedPolicy.AWSMarketplaceFullAccess instead. */
    export const AWSMarketplaceFullAccess: ARN = "arn:aws:iam::aws:policy/AWSMarketplaceFullAccess";
    /** Use ManagedPolicy.AWSMarketplaceGetEntitlements instead. */
    export const AWSMarketplaceGetEntitlements: ARN = "arn:aws:iam::aws:policy/AWSMarketplaceGetEntitlements";
    /** Use ManagedPolicy.AWSMarketplaceManageSubscriptions instead. */
    export const AWSMarketplaceManageSubscriptions: ARN = "arn:aws:iam::aws:policy/AWSMarketplaceManageSubscriptions";
    /** Use ManagedPolicy.AWSMarketplaceMeteringFullAccess instead. */
    export const AWSMarketplaceMeteringFullAccess: ARN = "arn:aws:iam::aws:policy/AWSMarketplaceMeteringFullAccess";
    /** Use ManagedPolicy.AWSMarketplaceReadonly instead. */
    export const AWSMarketplaceReadonly: ARN = "arn:aws:iam::aws:policy/AWSMarketplaceRead-only";
    /** Use ManagedPolicy.AWSMobileHub_FullAccess instead. */
    export const AWSMobileHub_FullAccess: ARN = "arn:aws:iam::aws:policy/AWSMobileHub_FullAccess";
    /** Use ManagedPolicy.AWSMobileHub_ReadOnly instead. */
    export const AWSMobileHub_ReadOnly: ARN = "arn:aws:iam::aws:policy/AWSMobileHub_ReadOnly";
    /** Use ManagedPolicy.AWSMobileHub_ServiceUseOnly instead. */
    export const AWSMobileHub_ServiceUseOnly: ARN = "arn:aws:iam::aws:policy/service-role/AWSMobileHub_ServiceUseOnly";
    /** Use ManagedPolicy.AWSOpsWorksCMInstanceProfileRole instead. */
    export const AWSOpsWorksCMInstanceProfileRole: ARN = "arn:aws:iam::aws:policy/AWSOpsWorksCMInstanceProfileRole";
    /** Use ManagedPolicy.AWSOpsWorksCMServiceRole instead. */
    export const AWSOpsWorksCMServiceRole: ARN = "arn:aws:iam::aws:policy/service-role/AWSOpsWorksCMServiceRole";
    /** Use ManagedPolicy.AWSOpsWorksCloudWatchLogs instead. */
    export const AWSOpsWorksCloudWatchLogs: ARN = "arn:aws:iam::aws:policy/AWSOpsWorksCloudWatchLogs";
    /** Use ManagedPolicy.AWSOpsWorksFullAccess instead. */
    export const AWSOpsWorksFullAccess: ARN = "arn:aws:iam::aws:policy/AWSOpsWorksFullAccess";
    /** Use ManagedPolicy.AWSOpsWorksInstanceRegistration instead. */
    export const AWSOpsWorksInstanceRegistration: ARN = "arn:aws:iam::aws:policy/AWSOpsWorksInstanceRegistration";
    /** Use ManagedPolicy.AWSOpsWorksRegisterCLI instead. */
    export const AWSOpsWorksRegisterCLI: ARN = "arn:aws:iam::aws:policy/AWSOpsWorksRegisterCLI";
    /** Use ManagedPolicy.AWSOpsWorksRole instead. */
    export const AWSOpsWorksRole: ARN = "arn:aws:iam::aws:policy/service-role/AWSOpsWorksRole";
    /** Use ManagedPolicy.AWSQuickSightDescribeRDS instead. */
    export const AWSQuickSightDescribeRDS: ARN = "arn:aws:iam::aws:policy/service-role/AWSQuickSightDescribeRDS";
    /** Use ManagedPolicy.AWSQuickSightDescribeRedshift instead. */
    export const AWSQuickSightDescribeRedshift: ARN = "arn:aws:iam::aws:policy/service-role/AWSQuickSightDescribeRedshift";
    /** Use ManagedPolicy.AWSQuickSightListIAM instead. */
    export const AWSQuickSightListIAM: ARN = "arn:aws:iam::aws:policy/service-role/AWSQuickSightListIAM";
    /** Use ManagedPolicy.AWSQuicksightAthenaAccess instead. */
    export const AWSQuicksightAthenaAccess: ARN = "arn:aws:iam::aws:policy/service-role/AWSQuicksightAthenaAccess";
    /** Use ManagedPolicy.AWSStepFunctionsConsoleFullAccess instead. */
    export const AWSStepFunctionsConsoleFullAccess: ARN = "arn:aws:iam::aws:policy/AWSStepFunctionsConsoleFullAccess";
    /** Use ManagedPolicy.AWSStepFunctionsFullAccess instead. */
    export const AWSStepFunctionsFullAccess: ARN = "arn:aws:iam::aws:policy/AWSStepFunctionsFullAccess";
    /** Use ManagedPolicy.AWSStepFunctionsReadOnlyAccess instead. */
    export const AWSStepFunctionsReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AWSStepFunctionsReadOnlyAccess";
    /** Use ManagedPolicy.AWSStorageGatewayFullAccess instead. */
    export const AWSStorageGatewayFullAccess: ARN = "arn:aws:iam::aws:policy/AWSStorageGatewayFullAccess";
    /** Use ManagedPolicy.AWSStorageGatewayReadOnlyAccess instead. */
    export const AWSStorageGatewayReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AWSStorageGatewayReadOnlyAccess";
    /** Use ManagedPolicy.AWSSupportAccess instead. */
    export const AWSSupportAccess: ARN = "arn:aws:iam::aws:policy/AWSSupportAccess";
    /** Use ManagedPolicy.AWSWAFFullAccess instead. */
    export const AWSWAFFullAccess: ARN = "arn:aws:iam::aws:policy/AWSWAFFullAccess";
    /** Use ManagedPolicy.AWSWAFReadOnlyAccess instead. */
    export const AWSWAFReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AWSWAFReadOnlyAccess";
    /** Use ManagedPolicy.AWSXrayFullAccess instead. */
    export const AWSXrayFullAccess: ARN = "arn:aws:iam::aws:policy/AWSXrayFullAccess";
    /** Use ManagedPolicy.AWSXrayReadOnlyAccess instead. */
    export const AWSXrayReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AWSXrayReadOnlyAccess";
    /** Use ManagedPolicy.AWSXrayWriteOnlyAccess instead. */
    export const AWSXrayWriteOnlyAccess: ARN = "arn:aws:iam::aws:policy/AWSXrayWriteOnlyAccess";
    /** Use ManagedPolicy.AWSXRayDaemonWriteAccess instead. */
    export const AWSXRayDaemonWriteAccess: ARN = "arn:aws:iam::aws:policy/AWSXRayDaemonWriteAccess";
    /** Use ManagedPolicy.AdministratorAccess instead. */
    export const AdministratorAccess: ARN = "arn:aws:iam::aws:policy/AdministratorAccess";
    /** Use ManagedPolicy.AmazonAPIGatewayAdministrator instead. */
    export const AmazonAPIGatewayAdministrator: ARN = "arn:aws:iam::aws:policy/AmazonAPIGatewayAdministrator";
    /** Use ManagedPolicy.AmazonAPIGatewayInvokeFullAccess instead. */
    export const AmazonAPIGatewayInvokeFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonAPIGatewayInvokeFullAccess";
    /** Use ManagedPolicy.AmazonAPIGatewayPushToCloudWatchLogs instead. */
    export const AmazonAPIGatewayPushToCloudWatchLogs: ARN = "arn:aws:iam::aws:policy/service-role/AmazonAPIGatewayPushToCloudWatchLogs";
    /** Use ManagedPolicy.AmazonAppStreamFullAccess instead. */
    export const AmazonAppStreamFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonAppStreamFullAccess";
    /** Use ManagedPolicy.AmazonAppStreamReadOnlyAccess instead. */
    export const AmazonAppStreamReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonAppStreamReadOnlyAccess";
    /** Use ManagedPolicy.AmazonAppStreamServiceAccess instead. */
    export const AmazonAppStreamServiceAccess: ARN = "arn:aws:iam::aws:policy/service-role/AmazonAppStreamServiceAccess";
    /** Use ManagedPolicy.AmazonAthenaFullAccess instead. */
    export const AmazonAthenaFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonAthenaFullAccess";
    /** Use ManagedPolicy.AmazonCloudDirectoryFullAccess instead. */
    export const AmazonCloudDirectoryFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonCloudDirectoryFullAccess";
    /** Use ManagedPolicy.AmazonCloudDirectoryReadOnlyAccess instead. */
    export const AmazonCloudDirectoryReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonCloudDirectoryReadOnlyAccess";
    /** Use ManagedPolicy.AmazonCognitoDeveloperAuthenticatedIdentities instead. */
    export const AmazonCognitoDeveloperAuthenticatedIdentities: ARN = "arn:aws:iam::aws:policy/AmazonCognitoDeveloperAuthenticatedIdentities";
    /** Use ManagedPolicy.AmazonCognitoPowerUser instead. */
    export const AmazonCognitoPowerUser: ARN = "arn:aws:iam::aws:policy/AmazonCognitoPowerUser";
    /** Use ManagedPolicy.AmazonCognitoReadOnly instead. */
    export const AmazonCognitoReadOnly: ARN = "arn:aws:iam::aws:policy/AmazonCognitoReadOnly";
    /** Use ManagedPolicy.AmazonDMSCloudWatchLogsRole instead. */
    export const AmazonDMSCloudWatchLogsRole: ARN = "arn:aws:iam::aws:policy/service-role/AmazonDMSCloudWatchLogsRole";
    /** Use ManagedPolicy.AmazonDMSRedshiftS3Role instead. */
    export const AmazonDMSRedshiftS3Role: ARN = "arn:aws:iam::aws:policy/service-role/AmazonDMSRedshiftS3Role";
    /** Use ManagedPolicy.AmazonDMSVPCManagementRole instead. */
    export const AmazonDMSVPCManagementRole: ARN = "arn:aws:iam::aws:policy/service-role/AmazonDMSVPCManagementRole";
    /** Use ManagedPolicy.AmazonDRSVPCManagement instead. */
    export const AmazonDRSVPCManagement: ARN = "arn:aws:iam::aws:policy/AmazonDRSVPCManagement";
    /** Use ManagedPolicy.AmazonDynamoDBFullAccess instead. */
    export const AmazonDynamoDBFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonDynamoDBFullAccess";
    /** Use ManagedPolicy.AmazonDynamoDBFullAccesswithDataPipeline instead. */
    export const AmazonDynamoDBFullAccesswithDataPipeline: ARN = "arn:aws:iam::aws:policy/AmazonDynamoDBFullAccesswithDataPipeline";
    /** Use ManagedPolicy.AmazonDynamoDBReadOnlyAccess instead. */
    export const AmazonDynamoDBReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonDynamoDBReadOnlyAccess";
    /** Use ManagedPolicy.AmazonEC2ContainerRegistryFullAccess instead. */
    export const AmazonEC2ContainerRegistryFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonEC2ContainerRegistryFullAccess";
    /** Use ManagedPolicy.AmazonEC2ContainerRegistryPowerUser instead. */
    export const AmazonEC2ContainerRegistryPowerUser: ARN = "arn:aws:iam::aws:policy/AmazonEC2ContainerRegistryPowerUser";
    /** Use ManagedPolicy.AmazonEC2ContainerRegistryReadOnly instead. */
    export const AmazonEC2ContainerRegistryReadOnly: ARN = "arn:aws:iam::aws:policy/AmazonEC2ContainerRegistryReadOnly";
    /** Use ManagedPolicy.AmazonEC2ContainerServiceAutoscaleRole instead. */
    export const AmazonEC2ContainerServiceAutoscaleRole: ARN = "arn:aws:iam::aws:policy/service-role/AmazonEC2ContainerServiceAutoscaleRole";
    /** Use ManagedPolicy.AmazonEC2ContainerServiceFullAccess instead. */
    export const AmazonEC2ContainerServiceFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonEC2ContainerServiceFullAccess";
    /** Use ManagedPolicy.AmazonEC2ContainerServiceRole instead. */
    export const AmazonEC2ContainerServiceRole: ARN = "arn:aws:iam::aws:policy/service-role/AmazonEC2ContainerServiceRole";
    /** Use ManagedPolicy.AmazonEC2ContainerServiceforEC2Role instead. */
    export const AmazonEC2ContainerServiceforEC2Role: ARN = "arn:aws:iam::aws:policy/service-role/AmazonEC2ContainerServiceforEC2Role";
    /** Use ManagedPolicy.AmazonEC2FullAccess instead. */
    export const AmazonEC2FullAccess: ARN = "arn:aws:iam::aws:policy/AmazonEC2FullAccess";
    /** Use ManagedPolicy.AmazonEC2ReadOnlyAccess instead. */
    export const AmazonEC2ReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonEC2ReadOnlyAccess";
    /** Use ManagedPolicy.AmazonEC2ReportsAccess instead. */
    export const AmazonEC2ReportsAccess: ARN = "arn:aws:iam::aws:policy/AmazonEC2ReportsAccess";
    /** Use ManagedPolicy.AmazonEC2RoleforAWSCodeDeploy instead. */
    export const AmazonEC2RoleforAWSCodeDeploy: ARN = "arn:aws:iam::aws:policy/service-role/AmazonEC2RoleforAWSCodeDeploy";
    /** Use ManagedPolicy.AmazonEC2RoleforDataPipelineRole instead. */
    export const AmazonEC2RoleforDataPipelineRole: ARN = "arn:aws:iam::aws:policy/service-role/AmazonEC2RoleforDataPipelineRole";
    /** Use ManagedPolicy.AmazonEC2RoleforSSM instead. */
    export const AmazonEC2RoleforSSM: ARN = "arn:aws:iam::aws:policy/service-role/AmazonEC2RoleforSSM";
    /** Use ManagedPolicy.AmazonEC2SpotFleetAutoscaleRole instead. */
    export const AmazonEC2SpotFleetAutoscaleRole: ARN = "arn:aws:iam::aws:policy/service-role/AmazonEC2SpotFleetAutoscaleRole";
    /** Use ManagedPolicy.AmazonEC2SpotFleetRole instead. */
    export const AmazonEC2SpotFleetRole: ARN = "arn:aws:iam::aws:policy/service-role/AmazonEC2SpotFleetRole";
    /** Use ManagedPolicy.AmazonEC2SpotFleetTaggingRole instead. */
    export const AmazonEC2SpotFleetTaggingRole: ARN = "arn:aws:iam::aws:policy/service-role/AmazonEC2SpotFleetTaggingRole";
    /** Use ManagedPolicy.AmazonESFullAccess instead. */
    export const AmazonESFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonESFullAccess";
    /** Use ManagedPolicy.AmazonESReadOnlyAccess instead. */
    export const AmazonESReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonESReadOnlyAccess";
    /** Use ManagedPolicy.AmazonElastiCacheFullAccess instead. */
    export const AmazonElastiCacheFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonElastiCacheFullAccess";
    /** Use ManagedPolicy.AmazonElastiCacheReadOnlyAccess instead. */
    export const AmazonElastiCacheReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonElastiCacheReadOnlyAccess";
    /** Use ManagedPolicy.AmazonElasticFileSystemFullAccess instead. */
    export const AmazonElasticFileSystemFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonElasticFileSystemFullAccess";
    /** Use ManagedPolicy.AmazonElasticFileSystemReadOnlyAccess instead. */
    export const AmazonElasticFileSystemReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonElasticFileSystemReadOnlyAccess";
    /** Use ManagedPolicy.AmazonElasticMapReduceFullAccess instead. */
    export const AmazonElasticMapReduceFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonElasticMapReduceFullAccess";
    /** Use ManagedPolicy.AmazonElasticMapReduceReadOnlyAccess instead. */
    export const AmazonElasticMapReduceReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonElasticMapReduceReadOnlyAccess";
    /** Use ManagedPolicy.AmazonElasticMapReduceRole instead. */
    export const AmazonElasticMapReduceRole: ARN = "arn:aws:iam::aws:policy/service-role/AmazonElasticMapReduceRole";
    /** Use ManagedPolicy.AmazonElasticMapReduceforAutoScalingRole instead. */
    export const AmazonElasticMapReduceforAutoScalingRole: ARN = "arn:aws:iam::aws:policy/service-role/AmazonElasticMapReduceforAutoScalingRole";
    /** Use ManagedPolicy.AmazonElasticMapReduceforEC2Role instead. */
    export const AmazonElasticMapReduceforEC2Role: ARN = "arn:aws:iam::aws:policy/service-role/AmazonElasticMapReduceforEC2Role";
    /** Use ManagedPolicy.AmazonElasticTranscoderFullAccess instead. */
    export const AmazonElasticTranscoderFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonElasticTranscoderFullAccess";
    /** Use ManagedPolicy.AmazonElasticTranscoderJobsSubmitter instead. */
    export const AmazonElasticTranscoderJobsSubmitter: ARN = "arn:aws:iam::aws:policy/AmazonElasticTranscoderJobsSubmitter";
    /** Use ManagedPolicy.AmazonElasticTranscoderReadOnlyAccess instead. */
    export const AmazonElasticTranscoderReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonElasticTranscoderReadOnlyAccess";
    /** Use ManagedPolicy.AmazonElasticTranscoderRole instead. */
    export const AmazonElasticTranscoderRole: ARN = "arn:aws:iam::aws:policy/service-role/AmazonElasticTranscoderRole";
    /** Use ManagedPolicy.AmazonGlacierFullAccess instead. */
    export const AmazonGlacierFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonGlacierFullAccess";
    /** Use ManagedPolicy.AmazonGlacierReadOnlyAccess instead. */
    export const AmazonGlacierReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonGlacierReadOnlyAccess";
    /** Use ManagedPolicy.AmazonInspectorFullAccess instead. */
    export const AmazonInspectorFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonInspectorFullAccess";
    /** Use ManagedPolicy.AmazonInspectorReadOnlyAccess instead. */
    export const AmazonInspectorReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonInspectorReadOnlyAccess";
    /** Use ManagedPolicy.AmazonKinesisAnalyticsFullAccess instead. */
    export const AmazonKinesisAnalyticsFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonKinesisAnalyticsFullAccess";
    /** Use ManagedPolicy.AmazonKinesisAnalyticsReadOnly instead. */
    export const AmazonKinesisAnalyticsReadOnly: ARN = "arn:aws:iam::aws:policy/AmazonKinesisAnalyticsReadOnly";
    /** Use ManagedPolicy.AmazonKinesisFirehoseFullAccess instead. */
    export const AmazonKinesisFirehoseFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonKinesisFirehoseFullAccess";
    /** Use ManagedPolicy.AmazonKinesisFirehoseReadOnlyAccess instead. */
    export const AmazonKinesisFirehoseReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonKinesisFirehoseReadOnlyAccess";
    /** Use ManagedPolicy.AmazonKinesisFullAccess instead. */
    export const AmazonKinesisFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonKinesisFullAccess";
    /** Use ManagedPolicy.AmazonKinesisReadOnlyAccess instead. */
    export const AmazonKinesisReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonKinesisReadOnlyAccess";
    /** Use ManagedPolicy.AmazonLexFullAccess instead. */
    export const AmazonLexFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonLexFullAccess";
    /** Use ManagedPolicy.AmazonLexReadOnly instead. */
    export const AmazonLexReadOnly: ARN = "arn:aws:iam::aws:policy/AmazonLexReadOnly";
    /** Use ManagedPolicy.AmazonLexRunBotsOnly instead. */
    export const AmazonLexRunBotsOnly: ARN = "arn:aws:iam::aws:policy/AmazonLexRunBotsOnly";
    /** Use ManagedPolicy.AmazonMachineLearningBatchPredictionsAccess instead. */
    export const AmazonMachineLearningBatchPredictionsAccess: ARN = "arn:aws:iam::aws:policy/AmazonMachineLearningBatchPredictionsAccess";
    /** Use ManagedPolicy.AmazonMachineLearningCreateOnlyAccess instead. */
    export const AmazonMachineLearningCreateOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonMachineLearningCreateOnlyAccess";
    /** Use ManagedPolicy.AmazonMachineLearningFullAccess instead. */
    export const AmazonMachineLearningFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonMachineLearningFullAccess";
    /** Use ManagedPolicy.AmazonMachineLearningManageRealTimeEndpointOnlyAccess instead. */
    export const AmazonMachineLearningManageRealTimeEndpointOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonMachineLearningManageRealTimeEndpointOnlyAccess";
    /** Use ManagedPolicy.AmazonMachineLearningReadOnlyAccess instead. */
    export const AmazonMachineLearningReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonMachineLearningReadOnlyAccess";
    /** Use ManagedPolicy.AmazonMachineLearningRealTimePredictionOnlyAccess instead. */
    export const AmazonMachineLearningRealTimePredictionOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonMachineLearningRealTimePredictionOnlyAccess";
    /** Use ManagedPolicy.AmazonMachineLearningRoleforRedshiftDataSource instead. */
    export const AmazonMachineLearningRoleforRedshiftDataSource: ARN = "arn:aws:iam::aws:policy/service-role/AmazonMachineLearningRoleforRedshiftDataSource";
    /** Use ManagedPolicy.AmazonMechanicalTurkFullAccess instead. */
    export const AmazonMechanicalTurkFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonMechanicalTurkFullAccess";
    /** Use ManagedPolicy.AmazonMechanicalTurkReadOnly instead. */
    export const AmazonMechanicalTurkReadOnly: ARN = "arn:aws:iam::aws:policy/AmazonMechanicalTurkReadOnly";
    /** Use ManagedPolicy.AmazonMobileAnalyticsFinancialReportAccess instead. */
    export const AmazonMobileAnalyticsFinancialReportAccess: ARN = "arn:aws:iam::aws:policy/AmazonMobileAnalyticsFinancialReportAccess";
    /** Use ManagedPolicy.AmazonMobileAnalyticsFullAccess instead. */
    export const AmazonMobileAnalyticsFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonMobileAnalyticsFullAccess";
    /** Use ManagedPolicy.AmazonMobileAnalyticsNonfinancialReportAccess instead. */
    export const AmazonMobileAnalyticsNonfinancialReportAccess: ARN = "arn:aws:iam::aws:policy/AmazonMobileAnalyticsNon-financialReportAccess";
    /** Use ManagedPolicy.AmazonMobileAnalyticsWriteOnlyAccess instead. */
    export const AmazonMobileAnalyticsWriteOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonMobileAnalyticsWriteOnlyAccess";
    /** Use ManagedPolicy.AmazonPollyFullAccess instead. */
    export const AmazonPollyFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonPollyFullAccess";
    /** Use ManagedPolicy.AmazonPollyReadOnlyAccess instead. */
    export const AmazonPollyReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonPollyReadOnlyAccess";
    /** Use ManagedPolicy.AmazonRDSDirectoryServiceAccess instead. */
    export const AmazonRDSDirectoryServiceAccess: ARN = "arn:aws:iam::aws:policy/service-role/AmazonRDSDirectoryServiceAccess";
    /** Use ManagedPolicy.AmazonRDSEnhancedMonitoringRole instead. */
    export const AmazonRDSEnhancedMonitoringRole: ARN = "arn:aws:iam::aws:policy/service-role/AmazonRDSEnhancedMonitoringRole";
    /** Use ManagedPolicy.AmazonRDSDataFullAccess instead. */
    export const AmazonRDSDataFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonRDSDataFullAccess";
    /** Use ManagedPolicy.AmazonRDSFullAccess instead. */
    export const AmazonRDSFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonRDSFullAccess";
    /** Use ManagedPolicy.AmazonRDSReadOnlyAccess instead. */
    export const AmazonRDSReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonRDSReadOnlyAccess";
    /** Use ManagedPolicy.AmazonRedshiftFullAccess instead. */
    export const AmazonRedshiftFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonRedshiftFullAccess";
    /** Use ManagedPolicy.AmazonRedshiftReadOnlyAccess instead. */
    export const AmazonRedshiftReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonRedshiftReadOnlyAccess";
    /** Use ManagedPolicy.AmazonRekognitionFullAccess instead. */
    export const AmazonRekognitionFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonRekognitionFullAccess";
    /** Use ManagedPolicy.AmazonRekognitionReadOnlyAccess instead. */
    export const AmazonRekognitionReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonRekognitionReadOnlyAccess";
    /** Use ManagedPolicy.AmazonRoute53DomainsFullAccess instead. */
    export const AmazonRoute53DomainsFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonRoute53DomainsFullAccess";
    /** Use ManagedPolicy.AmazonRoute53DomainsReadOnlyAccess instead. */
    export const AmazonRoute53DomainsReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonRoute53DomainsReadOnlyAccess";
    /** Use ManagedPolicy.AmazonRoute53FullAccess instead. */
    export const AmazonRoute53FullAccess: ARN = "arn:aws:iam::aws:policy/AmazonRoute53FullAccess";
    /** Use ManagedPolicy.AmazonRoute53ReadOnlyAccess instead. */
    export const AmazonRoute53ReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonRoute53ReadOnlyAccess";
    /** Use ManagedPolicy.AmazonS3FullAccess instead. */
    export const AmazonS3FullAccess: ARN = "arn:aws:iam::aws:policy/AmazonS3FullAccess";
    /** Use ManagedPolicy.AmazonS3ReadOnlyAccess instead. */
    export const AmazonS3ReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonS3ReadOnlyAccess";
    /** Use ManagedPolicy.AmazonSESFullAccess instead. */
    export const AmazonSESFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonSESFullAccess";
    /** Use ManagedPolicy.AmazonSESReadOnlyAccess instead. */
    export const AmazonSESReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonSESReadOnlyAccess";
    /** Use ManagedPolicy.AmazonSNSFullAccess instead. */
    export const AmazonSNSFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonSNSFullAccess";
    /** Use ManagedPolicy.AmazonSNSReadOnlyAccess instead. */
    export const AmazonSNSReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonSNSReadOnlyAccess";
    /** Use ManagedPolicy.AmazonSNSRole instead. */
    export const AmazonSNSRole: ARN = "arn:aws:iam::aws:policy/service-role/AmazonSNSRole";
    /** Use ManagedPolicy.AmazonSQSFullAccess instead. */
    export const AmazonSQSFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonSQSFullAccess";
    /** Use ManagedPolicy.AmazonSQSReadOnlyAccess instead. */
    export const AmazonSQSReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonSQSReadOnlyAccess";
    /** Use ManagedPolicy.AmazonSSMAutomationRole instead. */
    export const AmazonSSMAutomationRole: ARN = "arn:aws:iam::aws:policy/service-role/AmazonSSMAutomationRole";
    /** Use ManagedPolicy.AmazonSSMFullAccess instead. */
    export const AmazonSSMFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonSSMFullAccess";
    /** Use ManagedPolicy.AmazonSSMMaintenanceWindowRole instead. */
    export const AmazonSSMMaintenanceWindowRole: ARN = "arn:aws:iam::aws:policy/service-role/AmazonSSMMaintenanceWindowRole";
    /** Use ManagedPolicy.AmazonSSMReadOnlyAccess instead. */
    export const AmazonSSMReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonSSMReadOnlyAccess";
    /** Use ManagedPolicy.AmazonSSMManagedInstanceCore instead. */
    export const AmazonSSMManagedInstanceCore: ARN = "arn:aws:iam::aws:policy/AmazonSSMManagedInstanceCore";
    /** Use ManagedPolicy.AmazonVPCFullAccess instead. */
    export const AmazonVPCFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonVPCFullAccess";
    /** Use ManagedPolicy.AmazonVPCReadOnlyAccess instead. */
    export const AmazonVPCReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonVPCReadOnlyAccess";
    /** Use ManagedPolicy.AmazonWorkMailFullAccess instead. */
    export const AmazonWorkMailFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonWorkMailFullAccess";
    /** Use ManagedPolicy.AmazonWorkMailReadOnlyAccess instead. */
    export const AmazonWorkMailReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonWorkMailReadOnlyAccess";
    /** Use ManagedPolicy.AmazonWorkSpacesAdmin instead. */
    export const AmazonWorkSpacesAdmin: ARN = "arn:aws:iam::aws:policy/AmazonWorkSpacesAdmin";
    /** Use ManagedPolicy.AmazonWorkSpacesApplicationManagerAdminAccess instead. */
    export const AmazonWorkSpacesApplicationManagerAdminAccess: ARN = "arn:aws:iam::aws:policy/AmazonWorkSpacesApplicationManagerAdminAccess";
    /** Use ManagedPolicy.AmazonZocaloFullAccess instead. */
    export const AmazonZocaloFullAccess: ARN = "arn:aws:iam::aws:policy/AmazonZocaloFullAccess";
    /** Use ManagedPolicy.AmazonZocaloReadOnlyAccess instead. */
    export const AmazonZocaloReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AmazonZocaloReadOnlyAccess";
    /** Use ManagedPolicy.ApplicationAutoScalingForAmazonAppStreamAccess instead. */
    export const ApplicationAutoScalingForAmazonAppStreamAccess: ARN = "arn:aws:iam::aws:policy/service-role/ApplicationAutoScalingForAmazonAppStreamAccess";
    /** Use ManagedPolicy.AutoScalingConsoleFullAccess instead. */
    export const AutoScalingConsoleFullAccess: ARN = "arn:aws:iam::aws:policy/AutoScalingConsoleFullAccess";
    /** Use ManagedPolicy.AutoScalingConsoleReadOnlyAccess instead. */
    export const AutoScalingConsoleReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AutoScalingConsoleReadOnlyAccess";
    /** Use ManagedPolicy.AutoScalingFullAccess instead. */
    export const AutoScalingFullAccess: ARN = "arn:aws:iam::aws:policy/AutoScalingFullAccess";
    /** Use ManagedPolicy.AutoScalingNotificationAccessRole instead. */
    export const AutoScalingNotificationAccessRole: ARN = "arn:aws:iam::aws:policy/service-role/AutoScalingNotificationAccessRole";
    /** Use ManagedPolicy.AutoScalingReadOnlyAccess instead. */
    export const AutoScalingReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/AutoScalingReadOnlyAccess";
    /** Use ManagedPolicy. Billing instead. */
    export const Billing: ARN = "arn:aws:iam::aws:policy/job-function/Billing";
    /** Use ManagedPolicy.CloudFrontFullAccess instead. */
    export const CloudFrontFullAccess: ARN = "arn:aws:iam::aws:policy/CloudFrontFullAccess";
    /** Use ManagedPolicy.CloudFrontReadOnlyAccess instead. */
    export const CloudFrontReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/CloudFrontReadOnlyAccess";
    /** Use ManagedPolicy.CloudSearchFullAccess instead. */
    export const CloudSearchFullAccess: ARN = "arn:aws:iam::aws:policy/CloudSearchFullAccess";
    /** Use ManagedPolicy.CloudSearchReadOnlyAccess instead. */
    export const CloudSearchReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/CloudSearchReadOnlyAccess";
    /** Use ManagedPolicy.CloudWatchActionsEC2Access instead. */
    export const CloudWatchActionsEC2Access: ARN = "arn:aws:iam::aws:policy/CloudWatchActionsEC2Access";
    /** Use ManagedPolicy.CloudWatchEventsBuiltInTargetExecutionAccess instead. */
    export const CloudWatchEventsBuiltInTargetExecutionAccess: ARN = "arn:aws:iam::aws:policy/service-role/CloudWatchEventsBuiltInTargetExecutionAccess";
    /** Use ManagedPolicy.CloudWatchEventsFullAccess instead. */
    export const CloudWatchEventsFullAccess: ARN = "arn:aws:iam::aws:policy/CloudWatchEventsFullAccess";
    /** Use ManagedPolicy.CloudWatchEventsInvocationAccess instead. */
    export const CloudWatchEventsInvocationAccess: ARN = "arn:aws:iam::aws:policy/service-role/CloudWatchEventsInvocationAccess";
    /** Use ManagedPolicy.CloudWatchEventsReadOnlyAccess instead. */
    export const CloudWatchEventsReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/CloudWatchEventsReadOnlyAccess";
    /** Use ManagedPolicy.CloudWatchFullAccess instead. */
    export const CloudWatchFullAccess: ARN = "arn:aws:iam::aws:policy/CloudWatchFullAccess";
    /** Use ManagedPolicy.CloudWatchLogsFullAccess instead. */
    export const CloudWatchLogsFullAccess: ARN = "arn:aws:iam::aws:policy/CloudWatchLogsFullAccess";
    /** Use ManagedPolicy.CloudWatchLogsReadOnlyAccess instead. */
    export const CloudWatchLogsReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/CloudWatchLogsReadOnlyAccess";
    /** Use ManagedPolicy.CloudWatchReadOnlyAccess instead. */
    export const CloudWatchReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/CloudWatchReadOnlyAccess";
    /** Use ManagedPolicy.DataScientist instead. */
    export const DataScientist: ARN = "arn:aws:iam::aws:policy/job-function/DataScientist";
    /** Use ManagedPolicy.DatabaseAdministrator instead. */
    export const DatabaseAdministrator: ARN = "arn:aws:iam::aws:policy/job-function/DatabaseAdministrator";
    /** Use ManagedPolicy.IAMFullAccess instead. */
    export const IAMFullAccess: ARN = "arn:aws:iam::aws:policy/IAMFullAccess";
    /** Use ManagedPolicy.IAMReadOnlyAccess instead. */
    export const IAMReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/IAMReadOnlyAccess";
    /** Use ManagedPolicy.IAMSelfManageServiceSpecificCredentials instead. */
    export const IAMSelfManageServiceSpecificCredentials: ARN = "arn:aws:iam::aws:policy/IAMSelfManageServiceSpecificCredentials";
    /** Use ManagedPolicy.IAMUserChangePassword instead. */
    export const IAMUserChangePassword: ARN = "arn:aws:iam::aws:policy/IAMUserChangePassword";
    /** Use ManagedPolicy.IAMUserSSHKeys instead. */
    export const IAMUserSSHKeys: ARN = "arn:aws:iam::aws:policy/IAMUserSSHKeys";
    /** Use ManagedPolicy.NetworkAdministrator instead. */
    export const NetworkAdministrator: ARN = "arn:aws:iam::aws:policy/job-function/NetworkAdministrator";
    /** Use ManagedPolicy.PowerUserAccess instead. */
    export const PowerUserAccess: ARN = "arn:aws:iam::aws:policy/PowerUserAccess";
    /** Use ManagedPolicy.RDSCloudHsmAuthorizationRole instead. */
    export const RDSCloudHsmAuthorizationRole: ARN = "arn:aws:iam::aws:policy/service-role/RDSCloudHsmAuthorizationRole";
    /** Use ManagedPolicy.ReadOnlyAccess instead. */
    export const ReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/ReadOnlyAccess";
    /** Use ManagedPolicy.ResourceGroupsandTagEditorFullAccess instead. */
    export const ResourceGroupsandTagEditorFullAccess: ARN = "arn:aws:iam::aws:policy/ResourceGroupsandTagEditorFullAccess";
    /** Use ManagedPolicy.ResourceGroupsandTagEditorReadOnlyAccess instead. */
    export const ResourceGroupsandTagEditorReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/ResourceGroupsandTagEditorReadOnlyAccess";
    /** Use ManagedPolicy.SecurityAudit instead. */
    export const SecurityAudit: ARN = "arn:aws:iam::aws:policy/SecurityAudit";
    /** Use ManagedPolicy.ServerMigrationConnector instead. */
    export const ServerMigrationConnector: ARN = "arn:aws:iam::aws:policy/ServerMigrationConnector";
    /** Use ManagedPolicy.ServerMigrationServiceRole instead. */
    export const ServerMigrationServiceRole: ARN = "arn:aws:iam::aws:policy/service-role/ServerMigrationServiceRole";
    /** Use ManagedPolicy.ServiceCatalogAdminFullAccess instead. */
    export const ServiceCatalogAdminFullAccess: ARN = "arn:aws:iam::aws:policy/ServiceCatalogAdminFullAccess";
    /** Use ManagedPolicy.ServiceCatalogAdminReadOnlyAccess instead. */
    export const ServiceCatalogAdminReadOnlyAccess: ARN = "arn:aws:iam::aws:policy/ServiceCatalogAdminReadOnlyAccess";
    /** Use ManagedPolicy.ServiceCatalogEndUserAccess instead. */
    export const ServiceCatalogEndUserAccess: ARN = "arn:aws:iam::aws:policy/ServiceCatalogEndUserAccess";
    /** Use ManagedPolicy.ServiceCatalogEndUserFullAccess instead. */
    export const ServiceCatalogEndUserFullAccess: ARN = "arn:aws:iam::aws:policy/ServiceCatalogEndUserFullAccess";
    /** Use ManagedPolicy.SimpleWorkflowFullAccess instead. */
    export const SimpleWorkflowFullAccess: ARN = "arn:aws:iam::aws:policy/SimpleWorkflowFullAccess";
    /** Use ManagedPolicy. SupportUser instead. */
    export const SupportUser: ARN = "arn:aws:iam::aws:policy/job-function/SupportUser";
    /** Use ManagedPolicy.SystemAdministrator instead. */
    export const SystemAdministrator: ARN = "arn:aws:iam::aws:policy/job-function/SystemAdministrator";
    /** Use ManagedPolicy.VMImportExportRoleForAWSConnector instead. */
    export const VMImportExportRoleForAWSConnector: ARN = "arn:aws:iam::aws:policy/service-role/VMImportExportRoleForAWSConnector";
    /** Use ManagedPolicy.ViewOnlyAccess instead. */
    export const ViewOnlyAccess: ARN = "arn:aws:iam::aws:policy/job-function/ViewOnlyAccess";
}
