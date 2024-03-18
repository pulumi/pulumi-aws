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

import {Principal} from "./documents";

export module Principals {
    /**
     * Service Principal for Amazon Certificate Manager
     */
    export const AcmServicePrincipal: Principal = {Service: "acm.amazonaws.com"};

    /**
     * Service Principal for API Gateway
     */
    export const ApiGatewayPrincipal: Principal = {Service: "apigateway.amazonaws.com"};

    /**
     * Service Principal for AppSync Gateway
     */
     export const AppSyncPrincipal: Principal = {Service: "appsync.amazonaws.com"};

    /**
     * Service Principal for Athena
     */
    export const AthenaPrincipal: Principal = {Service: "athena.amazonaws.com"};

    /**
     * Service Principal for Autoscaling
     */
    export const AutoscalingPrincipal: Principal = {Service: "autoscaling.amazonaws.com"};

    /**
     * Service Principal for Batch
     */
    export const BatchPrincipal: Principal = {Service: "batch.amazonaws.com"};

    /**
     * Service Principal for Cloud Directory
     */
    export const CloudDirectoryPrincipal: Principal = {Service: "clouddirectory.amazonaws.com"};

    /**
     * Service Principal for Cloudformation
     */
    export const CloudformationPrincipal: Principal = {Service: "cloudformation.amazonaws.com"};

    /**
     * Service Principal for Cloudfront
     */
    export const CloudfrontPrincipal: Principal = {Service: "cloudfront.amazonaws.com"};

    /**
     * Service Principal for Cloud Search
     */
    export const CloudSearchPrincipal: Principal = {Service: "cloudsearch.amazonaws.com"};

    /**
     * Service Principal for Cloudtrail
     */
    export const CloudtrailPrincipal: Principal = {Service: "cloudtrail.amazonaws.com"};

    /**
     * Service Principal for CodeCommit
     */
    export const CodeCommitPrincipal: Principal = {Service: "codecommit.amazonaws.com"};

    /**
     * Service Principal for CodeBuild
     */
    export const CodeBuildPrincipal: Principal = {Service: "codebuild.amazonaws.com"};

    /**
     * Service Principal for CodeDeploy
     */
    export const CodeDeployPrincipal: Principal = {Service: "codedeploy.amazonaws.com"};

    /**
     * Service Principal for CodePipeline
     */
    export const CodePipelinePrincipal: Principal = {Service: "codepipeline.amazonaws.com"};

    /**
     * Service Principal for EC2 Config Service
     */
    export const ConfigPrincipal: Principal = {Service: "config.amazonaws.com"};

    /**
     * Service Principal for Data Pipeline
     */
    export const DataPipelinePrincipal: Principal = {Service: "datapipeline.amazonaws.com"};

    /**
     * Service Principal for DirectConnect
     */
    export const DirectConnectPrincipal: Principal = {Service: "directconnect.amazonaws.com"};

    /**
     * Service Principal for Directory Services
     */
    export const DirectoryServicesPrincipal: Principal = {Service: "ds.amazonaws.com"};

    /**
     * Service Principal for DynamoDB
     */
    export const DynamoDbPrincipal: Principal = {Service: "dynamodb.amazonaws.com"};

    /**
     * Service Principal for EC2
     */
    export const Ec2Principal: Principal = {Service: "ec2.amazonaws.com"};

    /**
     * Service Principal for Elastic Container Registry
     */
    export const EcrPrincipal: Principal = {Service: "ecr.amazonaws.com"};

    /**
     * Service Principal for Elastic Container Service
     */
    export const EcsPrincipal: Principal = {Service: "ecs.amazonaws.com"};

    /**
     * Service Principal for Elastic Container Service Tasks
     * Usage: https://docs.aws.amazon.com/AmazonECS/latest/developerguide/task-iam-roles.html
    */
    export const EcsTasksPrincipal: Principal = {Service: "ecs-tasks.amazonaws.com"};

    /**
     * Service Principal for Edge Lambda
     */
    export const EdgeLambdaPrincipal: Principal = {Service: "edgelambda.amazonaws.com"};
    
    /**
     * Service Principal for Elastic Kubernetes Service
     */
    export const EksPrincipal: Principal = {Service: "eks.amazonaws.com"};

    /**
     * Service Principal for Elasticache
     */
    export const ElasticachePrincipal: Principal = {Service: "elasticache.amazonaws.com"};

    /**
     * Service Principal for Elastic Beanstalk
     */
    export const ElasticBeanstalkPrincipal: Principal = {Service: "elasticbeanstalk.amazonaws.com"};

    /**
     * Service Principal for Elastic File System
     */
    export const ElasticFileSystemPrincipal: Principal = {Service: "elasticfilesystem.amazonaws.com"};

    /**
     * Service Principal for Elastic Load Balancing
     */
    export const ElasticLoadBalancingPrincipal: Principal = {Service: "elasticloadbalancing.amazonaws.com"};

    /**
     * Service Principal for Elastic MapReduce
     */
    export const ElasticMapReducePrincipal: Principal = {Service: "elasticmapreduce.amazonaws.com"};

    /**
     * Service Principal for Events
     */
    export const EventsPrincipal: Principal = {Service: "events.amazonaws.com"};

    /**
     * Service Principal for Health
     */
    export const HealthPrincipal: Principal = {Service: "health.amazonaws.com"};

    /**
     * Service Principal for IAM
     */
    export const IamPrincipal: Principal = {Service: "iam.amazonaws.com"};

    /**
     * Service Principal for AWS Inspector
     */
    export const InspectorPrincipal: Principal = {Service: "inspector.amazonaws.com"};

    /**
     * Service Principal for Kinesis
     */
    export const KinesisPrincipal: Principal = {Service: "kinesis.amazonaws.com"};

    /**
     * Service Principal for Key Mangaement Service
     */
    export const KmsPrincipal: Principal = {Service: "kms.amazonaws.com"};

    /**
     * Service Principal for Lambda
     */
    export const LambdaPrincipal: Principal = {Service: "lambda.amazonaws.com"};

    /**
     * Service Principal for Lightsail
     */
    export const LightsailPrincipal: Principal = {Service: "lightsail.amazonaws.com"};

    /**
     * Service Principal for Cloudwatch Logs
     */
    export const LogsPrincipal: Principal = {Service: "logs.amazonaws.com"};

    /**
     * Service Principal for Cloudwatch Monitoring
     */
    export const MonitoringPrincipal: Principal = {Service: "monitoring.amazonaws.com"};

    /**
     * Service Principal for Opsworks
     */
    export const OpsworksPrincipal: Principal = {Service: "opsworks.amazonaws.com"};

    /**
     * Service Principal for Organizations
     */
    export const OrganizationsPrincipal: Principal = {Service: "organizations.amazonaws.com"};

    /**
     * Service Principal for Relational Database Service
     */
    export const RdsPrincipal: Principal = {Service: "rds.amazonaws.com"};

    /**
     * Service Principal for Redshift
     */
    export const RedshiftPrincipal: Principal = {Service: "redshift.amazonaws.com"};

    /**
     * Service Principal for Route 53
     */
    export const Route53Principal: Principal = {Service: "route53.amazonaws.com"};

    /**
     * Service Principal for S3
     */
    export const S3Principal: Principal = {Service: "s3.amazonaws.com"};

    /**
     * Service Principal for Service Catalog
     */
    export const ServiceCatalogPrincipal: Principal = {Service: "servicecatalog.amazonaws.com"};

    /**
     * Service Principal for Simple Email Service
     */
    export const SesPrincipal: Principal = {Service: "ses.amazonaws.com"};

    /**
     * Service Principal for Signin Service
     */
    export const SigninPrincipal: Principal = {Service: "signin.amazonaws.com"};

    /**
     * Service Principal for Simple Notification Service
     */
    export const SnsPrincipal: Principal = {Service: "sns.amazonaws.com"};

    /**
     * Service Principal for Simple Queue Service
     */
    export const SqsPrincipal: Principal = {Service: "sqs.amazonaws.com"};

    /**
     * Service Principal for Spot Fleet
     */
    export const SpotFleetPrincipal: Principal = {Service: "spotfleet.amazonaws.com"};

    /**
     * Service Principal for Systems Manager
     */
    export const SsmPrincipal: Principal = {Service: "ssm.amazonaws.com"};

    /**
     * Service Principal for State Machine
     */
    export const StateMachinePrincipal: Principal = {Service: "states.amazonaws.com"};

    /**
     * Service Principal for Storage Gateway
     */
    export const StorageGatewayPrincipal: Principal = {Service: "storagegateway.amazonaws.com"};

    /**
     * Service Principal for Security Token Service
     */
    export const StsPrincipal: Principal = {Service: "sts.amazonaws.com"};

    /**
     * Service Principal for AWS Support
     */
    export const SupportPrincipal: Principal = {Service: "support.amazonaws.com"};

    /**
     * Service Principal for VM Import/Export
     */
    export const VmiePrincipal: Principal = {Service: "vmie.amazonaws.com"};

    /**
     * Service Principal for VPC Flow Logs
     */
    export const VpcFlowLogsPrincipal: Principal = {Service: "vpc-flow-logs.amazonaws.com"};

    /**
     * Service Principal for Web Application Firewall
     */
    export const WafPrincipal: Principal = {Service: "waf.amazonaws.com"};

    /**
     * Service Principal for WorkDocs
     */
    export const WorkDocsPrincipal: Principal = {Service: "workdocs.amazonaws.com"};

    /**
     * Service Principal for Workspaces
     */
    export const WorkspacesPrincipal: Principal = {Service: "workspaces.amazonaws.com"};
}
