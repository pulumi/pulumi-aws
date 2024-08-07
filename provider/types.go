// Copyright 2016-2024, Pulumi Corporation.
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
	"maps"

	"github.com/pulumi/pulumi/pkg/v3/codegen/schema"
)

// extraTypes augment the types defined by the upstream AWS provider
var extraTypes = map[string]schema.ComplexTypeSpec{
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
		Enum: instanceTypes(),
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
}

func init() {
	maps.Copy(extraTypes, typeOverlays)
}
