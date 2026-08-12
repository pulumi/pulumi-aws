package provider

import (
	"context"
	"fmt"
	"strings"

	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge/info"
	shim "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfshim"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
	"github.com/pulumi/pulumi/sdk/v3/go/common/tokens"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"

	"github.com/pulumi/pulumi-aws/provider/v7/pkg/batch"
	"github.com/pulumi/pulumi-aws/provider/v7/pkg/rds"
)

func resourceOverrides(p shim.Provider) map[string]*tfbridge.ResourceInfo {
	return map[string]*tfbridge.ResourceInfo{
		// AWS Private Certificate Authority
		"aws_acmpca_certificate": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"certificate": {
					CSharpName: "CertificateDetails",
				},
			},
		},
		"aws_acmpca_policy": {
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
			Fields: map[string]*tfbridge.SchemaInfo{
				"description": {
					Default: managedByPulumi,
				},
			},
		},
		"aws_appsync_function": {
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
			Fields: map[string]*tfbridge.SchemaInfo{
				"domain_name": {
					CSharpName: "Name",
				},
			},
		},

		// API Gateway
		"aws_api_gateway_api_key": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"description": {
					Default: managedByPulumi,
				},
			},
		},
		"aws_api_gateway_authorizer": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"rest_api_id": {
					Name:     "restApi",
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(apigatewayMod, "RestApi")},
				},
			},
		},
		"aws_api_gateway_base_path_mapping": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"api_id": {
					Name:     "restApi",
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(apigatewayMod, "RestApi")},
				},
			},
		},

		"aws_api_gateway_deployment": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"rest_api_id": {
					Name:     "restApi",
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(apigatewayMod, "RestApi")},
				},
			},
		},

		"aws_api_gateway_domain_name": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"domain_name": {
					CSharpName: "Domain",
				},
			},
		},
		"aws_api_gateway_integration": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"rest_api_id": {
					Name:     "restApi",
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(apigatewayMod, "RestApi")},
				},
			},
			DeleteBeforeReplace: true,
		},
		"aws_api_gateway_integration_response": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"rest_api_id": {
					Name:     "restApi",
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(apigatewayMod, "RestApi")},
				},
			},
		},
		"aws_api_gateway_method": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"rest_api_id": {
					Name:     "restApi",
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(apigatewayMod, "RestApi")},
				},
			},
		},
		"aws_api_gateway_method_response": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"rest_api_id": {
					Name:     "restApi",
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(apigatewayMod, "RestApi")},
				},
			},
		},
		"aws_api_gateway_method_settings": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"rest_api_id": {
					Name:     "restApi",
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(apigatewayMod, "RestApi")},
				},
			},
		},
		"aws_api_gateway_model": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"rest_api_id": {
					Name:     "restApi",
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(apigatewayMod, "RestApi")},
				},
			},
		},
		"aws_api_gateway_request_validator": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"rest_api_id": {
					Name:     "restApi",
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(apigatewayMod, "RestApi")},
				},
			},
		},
		"aws_api_gateway_resource": {
			Fields: map[string]*tfbridge.SchemaInfo{
				// TODO[pulumi/terraform-bridge#5] Strongly type the parent refernence to align with other uses
				// "parent_id": {
				// 	Name: "parent",
				// 	Type: awsTypeDefaultFile(apigatewayMod, "Resource"),
				// },
				"rest_api_id": {
					Name:     "restApi",
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(apigatewayMod, "RestApi")},
				},
			},
		},
		"aws_api_gateway_gateway_response": {Tok: awsResource(apigatewayMod, "Response")},

		"aws_api_gateway_stage": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"deployment_id": {
					Name:     "deployment",
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(apigatewayMod, "Deployment")},
				},
				"rest_api_id": {
					Name:     "restApi",
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(apigatewayMod, "RestApi")},
				},
			},
		},

		"aws_api_gateway_vpc_link": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"target_arns": {Name: "targetArn"},
			},
		},
		// API Gateway v2
		"aws_apigatewayv2_domain_name": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"domain_name": {
					CSharpName: "Domain",
				},
			},
		},

		// Application Auto Scaling
		"aws_appautoscaling_scheduled_action": {
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

		// Athena
		"aws_athena_database": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"name": {
					Default: &tfbridge.DefaultInfo{
						From: func(res *tfbridge.PulumiResource) (any, error) {
							return resource.NewUniqueHex(res.URN.Name()+"_", 7, 255)
						},
					},
				},
			},
		},

		// Auto Scaling
		"aws_autoscaling_group": {
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
					Elem: &tfbridge.SchemaInfo{Type: awsType(autoscalingMod, "Metric", "Metric")},
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
			TransformOutputs: (func() func(ctx context.Context, pm resource.PropertyMap) (resource.PropertyMap, error) {
				r, ok := p.ResourcesMap().GetOk("aws_autoscaling_group")
				contract.Assertf(ok, "Expected aws_autoscaling_resource to be defined")
				defaultValue := func(rawPropName string) resource.PropertyValue {
					prop, ok := r.Schema().GetOk(rawPropName)
					contract.Assertf(ok, "Expected property %q to be defined", prop)
					def := prop.Default()
					contract.Assertf(def != nil, "Expected property %q Default() to be defined", prop)
					switch prop.Type() {
					case shim.TypeString:
						defs, ok := def.(string)
						contract.Assertf(ok, "Expected property %q Default() to be a string", prop)
						return resource.NewStringProperty(defs)
					case shim.TypeBool:
						defb, ok := def.(bool)
						contract.Assertf(ok, "Expected property %q Default() to be a bool", prop)
						return resource.NewBoolProperty(defb)
					default:
						contract.Failf("Types other than string and bool are not supported yet")
						return resource.NewNullProperty()
					}
				}
				defaults := map[string]resource.PropertyValue{
					"forceDelete":                    defaultValue("force_delete"),
					"forceDeleteWarmPool":            defaultValue("force_delete_warm_pool"),
					"ignoreFailedScailingActivities": defaultValue("ignore_failed_scaling_activities"),
					"waitForCapacityTimeout":         defaultValue("wait_for_capacity_timeout"),
				}
				return func(_ context.Context, pm resource.PropertyMap) (resource.PropertyMap, error) {
					r := pm.Copy()
					for k, v := range defaults {
						if value, defined := pm[resource.PropertyKey(k)]; defined && !value.IsNull() {
							continue
						}
						r[resource.PropertyKey(k)] = v
					}
					return r, nil
				}
			})(),
		},
		"aws_autoscaling_lifecycle_hook": {
			Docs: &tfbridge.DocInfo{
				Source: "autoscaling_lifecycle_hooks.html.markdown",
			},
		},
		"aws_autoscaling_notification": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"notifications": {
					Elem: &tfbridge.SchemaInfo{Type: awsType(autoscalingMod, "NotificationType", "NotificationType")},
				},
			},
		},

		"aws_autoscaling_group_tag": {
			Tok: awsResource(autoscalingMod, "Tag"),
			Fields: map[string]*tfbridge.SchemaInfo{
				"tag": {
					CSharpName: "TagDetails",
				},
			},
		},
		// Backup
		"aws_backup_global_settings": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"global_settings": {
					CSharpName: "GlobalSettingsList",
				},
			},
		},
		"aws_backup_restore_testing_plan": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"name": tfbridge.AutoName("name", 255, "_"),
			},
		},
		// Batch
		"aws_batch_compute_environment": batch.ComputeEnvironment(awsResource(batchMod, "ComputeEnvironment"), tfbridge.GetLogger), //nolint:lll

		// BCM
		"aws_bcmdataexports_export": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"export": {
					CSharpName: "ExportDetails",
				},
			},
		},
		// Cloud9
		"aws_cloud9_environment_ec2": {Tok: awsResource(cloud9Mod, "EnvironmentEC2")},

		// CloudFormation
		"aws_cloudformation_type": {Tok: awsResource(cloudformationMod, "CloudFormationType")},
		// CloudHSM
		"aws_cloudhsm_v2_cluster": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"cluster_state": {
					CSharpName: "State",
				},
			},
		},
		"aws_cloudhsm_v2_hsm": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"hsm_state": {
					CSharpName: "State",
				},
			},
		},
		// CloudFront
		"aws_cloudfront_monitoring_subscription": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"monitoring_subscription": {
					CSharpName: "MonitoringSubscriptionDetails",
				},
			},
		},

		// CloudTrail
		"aws_cloudtrail": {Tok: awsResource(cloudtrailMod, "Trail")},

		// CloudWatch
		"aws_cloudwatch_event_rule": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"name": tfbridge.AutoName("name", 64, "-"),
			},
		},
		"aws_cloudwatch_event_target": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"target_id": tfbridge.AutoName("targetId", 255, "-"),
			},
		},

		"aws_cloudwatch_log_group": {
			IDFields: []string{"name"},
		},

		"aws_cloudwatch_log_resource_policy": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"policy_document": {
					Type:      "string",
					Transform: tfbridge.TransformJSONDocument,
				},
			},
		},

		"aws_cloudwatch_log_subscription_filter": {
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

		// https://aws.amazon.com/blogs/networking-and-content-delivery/introducing-amazon-cloudwatch-internet-monitor/
		"aws_internetmonitor_monitor": {Tok: awsResource(cloudwatchMod, "InternetMonitor")},

		// CodeDeploy
		"aws_codedeploy_app": {Tok: awsResource(codedeployMod, "Application")},
		"aws_codedeploy_deployment_config": {
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

		// CodeCommit
		"aws_codecommit_repository": {
			Docs: &tfbridge.DocInfo{
				Source: "code_commit_repository.html.markdown",
			},
		},
		"aws_codecommit_trigger": {
			Docs: &tfbridge.DocInfo{
				Source: "code_commit_trigger.html.markdown",
			},
		},

		// CodePipeline
		"aws_codepipeline": {Tok: awsResource(codepipelineMod, "Pipeline")},

		// Cognito
		"aws_cognito_identity_pool_roles_attachment": {Tok: awsResource(cognitoMod, "IdentityPoolRoleAttachment")},

		"aws_cognito_user_pool_ui_customization": {Tok: awsResource(cognitoMod, "UserPoolUICustomization")},

		// Connect
		"aws_connect_phone_number": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"phone_number": {
					CSharpName: "PhoneNumberValue",
				},
			},
		},

		// Config
		"aws_config_config_rule": {Tok: awsResource(cfgMod, "Rule")},

		"aws_config_configuration_recorder":        {Tok: awsResource(cfgMod, "Recorder")},
		"aws_config_configuration_recorder_status": {Tok: awsResource(cfgMod, "RecorderStatus")},

		// DataSync
		"aws_datasync_location_efs": {
			Tok: awsResource(datasyncMod, "EfsLocation"),
		},
		"aws_datasync_location_nfs": {Tok: awsResource(datasyncMod, "NfsLocation")},
		"aws_datasync_location_s3": {
			Tok: awsResource(datasyncMod, "S3Location"),
		},

		"aws_datasync_location_fsx_windows_file_system": {Tok: awsResource(datasyncMod, "LocationFsxWindows")},
		"aws_datasync_location_fsx_lustre_file_system":  {Tok: awsResource(datasyncMod, "LocationFsxLustre")},

		"aws_datasync_location_fsx_openzfs_file_system": {Tok: awsResource(datasyncMod, "FsxOpenZfsFileSystem")},

		// Data Lifecycle Manager
		"aws_dlm_lifecycle_policy": {
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

		// DirectoryService
		"aws_directory_service_directory": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"name": {Name: "name"},
			},
		},

		"aws_directory_service_region": {Tok: awsResource(directoryserviceMod, "ServiceRegion")},

		"aws_directory_service_trust": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"trust_state": {
					// Without this rename, C# compilation fails as there is a TrustState
					// class generated in the SDK that now conflicts with TrustState field.
					CSharpName: "Truststate",
				},
			},
		},

		// Document DB
		"aws_docdb_subnet_group": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"description": {
					Default: managedByPulumi,
				},
			},
		},

		// Direct Connect
		"aws_dx_lag": {Tok: awsResource(dxMod, "LinkAggregationGroup")},

		"aws_dx_hosted_transit_virtual_interface_accepter": {
			Tok: awsResource(dxMod, "HostedTransitVirtualInterfaceAcceptor"),
		},

		// DynamoDB
		"aws_dynamodb_table": {
			Fields: map[string]*tfbridge.SchemaInfo{
				// Override default pluralization ("indices") to match AWS APIs
				"global_secondary_index": {Name: "globalSecondaryIndexes"},
				"local_secondary_index":  {Name: "localSecondaryIndexes"},
			},
		},

		// Elastic Beanstalk
		"aws_elastic_beanstalk_application_version": {
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

		"aws_elastic_beanstalk_environment": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"name": tfbridge.AutoName("name", 40, "-"),
				"application": {
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(elasticbeanstalkMod, "Application")},
				},
				"version_label": {
					Name:     "version",
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(elasticbeanstalkMod, "ApplicationVersion")},
				},
			},
		},
		// ElastiCache
		"aws_elasticache_cluster": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"cluster_id": tfbridge.AutoNameTransform("clusterId", 50, func(name string) string {
					return strings.ToLower(name)
				}),
			},
		},
		"aws_elasticache_parameter_group": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"description": {
					Default: managedByPulumi,
				},
			},
		},
		"aws_elasticache_replication_group": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"replication_group_id": tfbridge.AutoNameTransform("replicationGroupId", 40, strings.ToLower),
				"at_rest_encryption_enabled": {
					Type: "boolean",
				},
				"auto_minor_version_upgrade": {
					Type: "boolean",
				},
			},
		},
		"aws_elasticache_subnet_group": {
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
		"aws_eip_domain_name":              {Tok: awsResource(ec2Mod, "EipDomainName")},
		"aws_flow_log":                     {Tok: awsResource(ec2Mod, "FlowLog")},
		"aws_instance": {
			Tok: awsResource(ec2Mod, "Instance"),
			Fields: map[string]*tfbridge.SchemaInfo{
				"iam_instance_profile": {
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(iamMod, "InstanceProfile")},
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
		"aws_internet_gateway":            {Tok: awsResource(ec2Mod, "InternetGateway")},
		"aws_internet_gateway_attachment": {Tok: awsResource(ec2Mod, "InternetGatewayAttachment")},

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
					AltTypes: []tokens.Type{awsResource(iamMod, "InstanceProfile")},
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
		"aws_nat_gateway":                 {Tok: awsResource(ec2Mod, "NatGateway")},
		"aws_nat_gateway_eip_association": {Tok: awsResource(ec2Mod, "NatGatewayEipAssociation")},
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
		"aws_network_interface_permission": {Tok: awsResource(ec2Mod, "NetworkInterfacePermission")},
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
				"ingress": {
					Name: "ingress",
				},
				"egress": {
					Name: "egress",
				},
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
		"aws_vpc_security_group_rules_exclusive": {Tok: awsResource(ec2Mod, "VpcSecurityGroupRulesExclusive")},
		"aws_snapshot_create_volume_permission":  {Tok: awsResource(ec2Mod, "SnapshotCreateVolumePermission")},
		"aws_spot_datafeed_subscription":         {Tok: awsResource(ec2Mod, "SpotDatafeedSubscription")},
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
		"aws_default_vpc":            {Tok: awsResource(ec2Mod, "DefaultVpc")},
		"aws_vpc":                    {Tok: awsResource(ec2Mod, vpcMod)},
		"aws_vpc_encryption_control": {Tok: awsResource(ec2Mod, "VpcEncryptionControl")},
		"aws_vpc_endpoint":           {Tok: awsResource(ec2Mod, "VpcEndpoint")},
		"aws_vpc_endpoint_connection_notification":    {Tok: awsResource(ec2Mod, "VpcEndpointConnectionNotification")},
		"aws_vpc_endpoint_route_table_association":    {Tok: awsResource(ec2Mod, "VpcEndpointRouteTableAssociation")},
		"aws_vpc_endpoint_service":                    {Tok: awsResource(ec2Mod, "VpcEndpointService")},
		"aws_vpc_endpoint_service_allowed_principal":  {Tok: awsResource(ec2Mod, "VpcEndpointServiceAllowedPrinciple")},
		"aws_vpc_endpoint_subnet_association":         {Tok: awsResource(ec2Mod, "VpcEndpointSubnetAssociation")},
		"aws_vpc_endpoint_policy":                     {Tok: awsResource(ec2Mod, "VpcEndpointPolicy")},
		"aws_vpc_endpoint_security_group_association": {Tok: awsResource(ec2Mod, "SecurityGroupAssociation")},
		"aws_vpc_ipv4_cidr_block_association":         {Tok: awsResource(ec2Mod, "VpcIpv4CidrBlockAssociation")},
		"aws_vpc_network_performance_metric_subscription": {
			Tok: awsResource(ec2Mod, "VpcNetworkPerformanceMetricSubscription"),
		},

		"aws_vpn_concentrator":              {Tok: awsResource(ec2Mod, "VpnConcentrator")},
		"aws_vpn_connection":                {Tok: awsResource(ec2Mod, "VpnConnection")},
		"aws_vpn_connection_route":          {Tok: awsResource(ec2Mod, "VpnConnectionRoute")},
		"aws_vpn_gateway":                   {Tok: awsResource(ec2Mod, "VpnGateway")},
		"aws_vpn_gateway_attachment":        {Tok: awsResource(ec2Mod, "VpnGatewayAttachment")},
		"aws_vpn_gateway_route_propagation": {Tok: awsResource(ec2Mod, "VpnGatewayRoutePropagation")},

		"aws_ec2_host": {Tok: awsResource(ec2Mod, "DedicatedHost")},

		"aws_vpc_ipam":                        {Tok: awsResource(ec2Mod, "VpcIpam")},
		"aws_vpc_ipam_pool":                   {Tok: awsResource(ec2Mod, "VpcIpamPool")},
		"aws_vpc_ipam_scope":                  {Tok: awsResource(ec2Mod, "VpcIpamScope")},
		"aws_vpc_ipam_pool_cidr":              {Tok: awsResource(ec2Mod, "VpcIpamPoolCidr")},
		"aws_vpc_ipam_pool_cidr_allocation":   {Tok: awsResource(ec2Mod, "VpcIpamPoolCidrAllocation")},
		"aws_vpc_ipv6_cidr_block_association": {Tok: awsResource(ec2Mod, "VpcIpv6CidrBlockAssociation")},

		"aws_vpc_endpoint_connection_accepter":    {Tok: awsResource(ec2Mod, "VpcEndpointConnectionAccepter")},
		"aws_vpc_ipam_organization_admin_account": {Tok: awsResource(ec2Mod, "VpcIpamOrganizationAdminAccount")},
		"aws_vpc_ipam_preview_next_cidr":          {Tok: awsResource(ec2Mod, "VpcIpamPreviewNextCidr")},

		"aws_vpc_ipam_resource_discovery":             {Tok: awsResource(ec2Mod, "VpcIpamResourceDiscovery")},
		"aws_vpc_ipam_resource_discovery_association": {Tok: awsResource(ec2Mod, "VpcIpamResourceDiscoveryAssociation")},
		"aws_vpc_block_public_access_exclusion":       {Tok: awsResource(ec2Mod, "VpcBlockPublicAccessExclusion")},
		"aws_vpc_block_public_access_options":         {Tok: awsResource(ec2Mod, "VpcBlockPublicAccessOptions")},

		// EC2 Transit Gateway
		"aws_ec2_transit_gateway": {
			Tok: awsResource(ec2TransitGatewayMod, "TransitGateway"),
		},

		"aws_ec2_transit_gateway_vpc_attachment": {

			DeleteBeforeReplace: true,
		},

		"aws_ec2_instance_state":            {Tok: awsResource(ec2TransitGatewayMod, "InstanceState")},
		"aws_ec2_instance_connect_endpoint": {Tok: awsResource(ec2TransitGatewayMod, "InstanceConnectEndpoint")},
		// Elastic Container Registry
		"aws_ecr_repository_policy": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"policy": {
					Type:      "string",
					Transform: tfbridge.TransformJSONDocument,
				},
			},
		},
		"aws_ecr_lifecycle_policy": {

			DeleteBeforeReplace: true,
			Fields: map[string]*tfbridge.SchemaInfo{
				"policy": {
					Type:      "string",
					AltTypes:  []tokens.Type{awsType(ecrMod, "LifecyclePolicyDocument", "LifecyclePolicyDocument")},
					Transform: tfbridge.TransformJSONDocument,
				},
			},
		},
		"aws_ecr_registry_policy": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"policy": {
					Type:      "string",
					Transform: tfbridge.TransformJSONDocument,
				},
			},
		},
		"aws_ecr_replication_configuration": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"replication_configuration": {
					CSharpName: "ReplicationConfigurationDetails",
				},
			},
		},

		// Elastic Container Service
		"aws_ecs_service": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"load_balancer": {
					// Even though only one is currently supported, the AWS API is designed to support multiple, so
					// force this to project as an array (and assign a plural name).
					Name:        "loadBalancers",
					MaxItemsOne: new(false),
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

		// Elastic File System
		"aws_efs_file_system": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"creation_token": tfbridge.AutoName("creationToken", 255, "-"),
			},
		},
		"aws_efs_mount_target": {

			DeleteBeforeReplace: true, // only 1 mount target per AZ.
		},

		"aws_efs_backup_policy": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"backup_policy": {
					CSharpName: "BackupPolicyDetails",
				},
			},
		},
		// ECS for Kubernetes
		"aws_eks_node_group": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"node_group_name": tfbridge.AutoName("nodeGroupName", 255, "-"),
			},
		},
		"aws_eks_cluster": {
			Fields: map[string]*info.Schema{
				"certificate_authority": {
					Name: "certificateAuthority",
					// The upstream API only returns a single item
					MaxItemsOne: tfbridge.True(),
				},
			},
			TransformFromState: func(_ context.Context, pm resource.PropertyMap) (resource.PropertyMap, error) {
				// if the defaultOutboundAccessEnabled property is not set, set it to the default value of true
				// this prevents an unnecessary replacement when upgrading the provider
				// There is a TF migration which should handle this but due to [pulumi/pulumi-terraform-bridge#1667]
				// it does not work as expected.
				if _, ok := pm["bootstrapSelfManagedAddons"]; !ok {
					pm["bootstrapSelfManagedAddons"] = resource.NewBoolProperty(true)
				}
				return pm, nil
			},
		},
		"aws_eks_fargate_profile": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"fargate_profile_name": tfbridge.AutoName("fargateProfileName", 255, "-"),
			},
		},

		// Elastic Search
		"aws_elasticsearch_domain": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"domain_name": tfbridge.AutoNameTransform("domainName", 28, func(name string) string {
					return strings.ToLower(name)
				}),
				"cluster_config":   {Name: "clusterConfig"},
				"ebs_options":      {Name: "ebsOptions"},
				"snapshot_options": {Name: "snapshotOptions"},
				"access_policies": {
					Type:      "string",
					Transform: tfbridge.TransformJSONDocument,
				},
			},
		},
		"aws_elasticsearch_domain_policy": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"access_policies": {
					Type:      "string",
					Transform: tfbridge.TransformJSONDocument,
				},
			},
		},

		// Elastic Transcoder
		"aws_elastictranscoder_pipeline": {
			Docs: &tfbridge.DocInfo{
				Source: "elastic_transcoder_pipeline.html.markdown",
			},
		},
		"aws_elastictranscoder_preset": {
			Docs: &tfbridge.DocInfo{
				Source: "elastic_transcoder_preset.html.markdown",
			},
		},
		// Elastic MapReduce
		"aws_emr_cluster": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"cluster_state": {
					CSharpName: "State",
				},
			},
		},

		// FSX
		"aws_fsx_openzfs_file_system": {
			Tok: awsResource(fsxMod, "OpenZfsFileSystem"),
			TransformFromState: func(_ context.Context, state resource.PropertyMap) (resource.PropertyMap, error) {
				if val, ok := state["subnetIds"]; ok {
					if val.IsString() {
						state["subnetIds"] = resource.NewArrayProperty([]resource.PropertyValue{val})
					}
				}
				return state, nil
			},
			Fields: map[string]*info.Schema{
				"subnet_ids": {
					MaxItemsOne: tfbridge.False(),
				},
			},
		},
		"aws_fsx_openzfs_snapshot": {Tok: awsResource(fsxMod, "OpenZfsSnapshot")},
		"aws_fsx_openzfs_volume":   {Tok: awsResource(fsxMod, "OpenZfsVolume")},

		// Glue
		"aws_glue_catalog_database": {
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

		"aws_glue_data_catalog_encryption_settings": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"data_catalog_encryption_settings": {
					CSharpName: "DataCatalogEncryptionSettingsConfig",
				},
			},
		},
		"aws_glue_ml_transform": {Tok: awsResource(glueMod, "MLTransform")},

		"aws_glue_partition_index": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"partition_index": {
					CSharpName: "PartitionIndexConfig",
				},
			},
		},
		// GuardDuty
		"aws_guardduty_ipset": {Tok: awsResource(guarddutyMod, "IPSet")},

		"aws_guardduty_threatintelset": {Tok: awsResource(guarddutyMod, "ThreatIntelSet")},

		// Identity and Access Management (IAM)
		"aws_iam_account_alias": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"account_alias": {
					CSharpName: "Alias",
				},
			},
			DeleteBeforeReplace: true,
		},

		"aws_iam_group_policy": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"policy": {
					Type:      "string",
					AltTypes:  []tokens.Type{awsType(iamMod, "PolicyDocument", "PolicyDocument")},
					Transform: tfbridge.TransformJSONDocument,
				},
			},
		},

		"aws_iam_group_policy_attachment": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"group": {
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(iamMod, "Group")},
				},
				"policy_arn": {
					Name: "policyArn",
				},
			},
			// We pass delete-before-replace: this is a leaf node and a create followed by a delete actually
			// deletes the same attachment we just created, since it is structurally equivalent!
			DeleteBeforeReplace: true,
		},
		"aws_iam_instance_profile": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"role": {
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(iamMod, "Role")},
				},
			},
		},
		"aws_iam_openid_connect_provider": {Tok: awsResource(iamMod, "OpenIdConnectProvider")},
		"aws_iam_policy": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"policy": {
					Type:       "string",
					AltTypes:   []tokens.Type{awsType(iamMod, "PolicyDocument", "PolicyDocument")},
					Transform:  tfbridge.TransformJSONDocument,
					CSharpName: "PolicyDocument",
				},
			},
		},
		"aws_iam_policy_attachment": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"users": {
					Elem: &tfbridge.SchemaInfo{
						Type:     "string",
						AltTypes: []tokens.Type{awsResource(iamMod, "User")},
					},
				},
				"roles": {
					Elem: &tfbridge.SchemaInfo{
						Type:     "string",
						AltTypes: []tokens.Type{awsResource(iamMod, "Role")},
					},
				},
				"groups": {
					Elem: &tfbridge.SchemaInfo{
						Type:     "string",
						AltTypes: []tokens.Type{awsResource(iamMod, "Group")},
					},
				},
				"policy_arn": {
					Name: "policyArn",
				},
			},
			// We pass delete-before-replace: this is a leaf node and a create followed by a delete actually
			// deletes the same attachment we just created, since it is structurally equivalent!
			DeleteBeforeReplace: true,
		},
		"aws_iam_role_policy_attachment": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"role": {
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(iamMod, "Role")},
				},
				"policy_arn": {
					Name: "policyArn",
				},
			},
			// We pass delete-before-replace: this is a leaf node and a create followed by a delete actually
			// deletes the same attachment we just created, since it is structurally equivalent!
			DeleteBeforeReplace: true,
		},
		"aws_iam_role_policy": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"role": {
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(iamMod, "Role")},
				},
				"policy": {
					Type:      "string",
					AltTypes:  []tokens.Type{awsType(iamMod, "PolicyDocument", "PolicyDocument")},
					Transform: tfbridge.TransformJSONDocument,
				},
			},
		},
		"aws_iam_role": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"name": tfbridge.AutoName("name", 64, "-"),
				"assume_role_policy": {
					Type:      "string",
					AltTypes:  []tokens.Type{awsType(iamMod, "PolicyDocument", "PolicyDocument")},
					Transform: tfbridge.TransformJSONDocument,
				},
				"inline_policy": {
					// inline_policy is an array of policy objects. The user is allowed to provided an empty list
					//   inlinePolicies: []
					// or a list with empty objects
					//   inlinePolicies: [{}]
					// If an empty list is provided for inline policies then the provider will not manage any inline
					// policies in this resource.
					// Providing a list with an empty object will cause the provider to remove all inline policies
					// If a policy is provided, then both the `policy` and the `name` fields are required.
					// If one is provided and the other is not, then no error will be thrown and no inline policy
					// will be created.
					Transform: func(pv resource.PropertyValue) (resource.PropertyValue, error) {
						if pv.IsArray() {
							inlinePolicy := []resource.PropertyValue{}
							for _, value := range pv.ArrayValue() {
								if value.IsObject() {
									policy := value.ObjectValue()
									// Filter out policies with no policy document. This can happens due to the auto-naming
									// of the inline policy. It is not valid and will end up with no policy being created in AWS, but will show
									// a perpetual diff which is confusing to users.
									// An absent policy document is the one exception because it is the delete marker.
									if policy.HasValue("policy") && policy["policy"].IsString() && policy["policy"].StringValue() != "" {
										inlinePolicy = append(inlinePolicy, value)
									} else if !policy.HasValue("policy") || policy["policy"].IsNull() {
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

		"aws_iam_user_policy_attachment": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"user": {
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(iamMod, "User")},
				},
				"policy_arn": {
					Name: "policyArn",
				},
			},
			// We pass delete-before-replace: this is a leaf node and a create followed by a delete actually
			// deletes the same attachment we just created, since it is structurally equivalent!
			DeleteBeforeReplace: true,
		},
		"aws_iam_user_policy": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"policy": {
					Type:      "string",
					AltTypes:  []tokens.Type{awsType(iamMod, "PolicyDocument", "PolicyDocument")},
					Transform: tfbridge.TransformJSONDocument,
				},
			},
		},
		"aws_iam_user_ssh_key": {Tok: awsResource(iamMod, "SshKey")},

		// IOT
		"aws_iot_event_configurations": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"event_configurations": {
					CSharpName: "Configurations",
				},
			},
		},
		"aws_iot_policy": {
			IDFields: []string{"name"},
			Fields: map[string]*tfbridge.SchemaInfo{
				"policy": {
					CSharpName: "PolicyDocument",
				},
			},
		},
		"aws_iot_policy_attachment": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"policy": {
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(iotMod, "Policy")},
				},
			},
		},

		"aws_iot_topic_rule": {
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

		// Key Management Service (KMS)
		"aws_kms_alias": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"name": tfbridge.AutoNameWithCustomOptions("name", tfbridge.AutoNameOptions{
					Separator: "-",
					Maxlen:    238,
					Randlen:   7,
					// KMS Key alias names must be prefixed with "alias/" - see format documentation at
					// https://docs.aws.amazon.com/kms/latest/APIReference/API_CreateAlias.html
					PostTransform: func(_ *tfbridge.PulumiResource, name string) (string, error) {
						if strings.HasPrefix(name, "alias/") {
							return name, nil
						}

						return fmt.Sprintf("alias/%s", name), nil
					},
				}),
			},
		},

		// Lambda
		"aws_lambda_function": {
			IDFields: []string{"function_name"},
			Fields: map[string]*tfbridge.SchemaInfo{
				"function_name": tfbridge.AutoName("name", 64, "-"),
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
			Fields: map[string]*tfbridge.SchemaInfo{
				"function_url": {
					CSharpName: "FunctionUrlResult",
				},
			},
		},
		"aws_lambda_function_scaling_config": {
			Fields: map[string]*tfbridge.SchemaInfo{
				// The `function_scaling_config` block would generate a C# property named
				// `FunctionScalingConfig`, colliding with the enclosing resource class of the
				// same name (CS0542). Rename the .NET property to avoid the clash.
				"function_scaling_config": {
					CSharpName: "FunctionScalingConfigDetails",
				},
			},
		},

		"aws_lambda_layer_version": {
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
			IDFields: []string{"statement_id"},
			Fields: map[string]*tfbridge.SchemaInfo{
				"function_name": {
					Name:     "function",
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(lambdaMod, "Function")},
				},
				"statement_id": tfbridge.AutoName("statementId", 100, "-"),
			},
		},

		// License Manager
		"aws_licensemanager_grant":          {Tok: awsResource(licensemanagerMod, "LicenseGrant")},
		"aws_licensemanager_grant_accepter": {Tok: awsResource(licensemanagerMod, "LicenseGrantAccepter")},

		// LightSail
		"aws_lightsail_disk_attachment": {Tok: awsResource(lightsailMod, "Disk_attachment")},

		// Location
		"aws_location_route_calculator": {Tok: awsResource(locationMod, "RouteCalculation")},

		// Macie
		"aws_macie2_custom_data_identifier": {Tok: awsResource(macieMod, "CustomDataIdentifier")},
		"aws_macie2_findings_filter":        {Tok: awsResource(macieMod, "FindingsFilter")},
		// Elemental MediaPackage
		"aws_media_package_channel": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"description": {
					Default: managedByPulumi,
				},
			},
		},
		// MQ
		"aws_mq_broker": {
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

		// Neptune
		"aws_neptune_subnet_group": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"description": {
					Default: managedByPulumi,
				},
			},
		},
		// OpenSearch
		"aws_opensearch_domain": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"domain_name": tfbridge.AutoName("domainName", 255, "-"),
			},
		},

		// Payment Cryptography
		"aws_paymentcryptography_key": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"key_state": {
					CSharpName: "State",
				},
			},
		},
		// Relational Database Service (RDS)
		"aws_rds_cluster": {
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
		"aws_rds_instance_state": {
			// Pulumi cannot call this resource InstanceState because SDKs such as the Node SDK
			// reserve the name to an auxiliary structure for the Instance resource.
			Tok: awsResource(rdsMod, "InstanceDesiredState"),
		},

		"aws_rds_cluster_instance": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"engine": {
					Type: awsType(rdsMod, "EngineType", "EngineType"),
				},
				"instance_class": {
					Type:     "string",
					AltTypes: []tokens.Type{awsType(rdsMod, "InstanceType", "InstanceType")},
				},
			},
		},
		"aws_rds_cluster_parameter_group": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"description": {
					Default: managedByPulumi,
				},
			},
		},

		"aws_db_instance": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"identifier": {
					Default: &tfbridge.DefaultInfo{
						AutoNamed: true,
						ComputeDefault: func(ctx context.Context, opts tfbridge.ComputeDefaultOptions) (any, error) {
							rand, maxlen := 7, 255
							if engine, ok := opts.Properties["engine"]; ok && engine.IsString() {
								if strings.Contains(strings.ToLower(engine.StringValue()), "sqlserver") {
									// SQL Server identifiers are capped at 15 characters.
									rand, maxlen = 3, 15
								}
							}
							return tfbridge.ComputeAutoNameDefault(ctx, tfbridge.AutoNameOptions{
								Randlen: rand,
								Maxlen:  maxlen,
							}, opts)
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
			},
			PreCheckCallback: func(
				ctx context.Context, config resource.PropertyMap, _ resource.PropertyMap,
			) (resource.PropertyMap, error) {
				if name, ok := config["name"]; ok {
					// Both `name` and `dbName` are set, so error
					if _, ok := config["dbName"]; ok {
						return nil, fmt.Errorf("cannot specify both name and dbName, " +
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
					delete(state, "name")
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
			Fields: map[string]*tfbridge.SchemaInfo{
				"option_group_description": {
					Default: managedByPulumi,
				},
			},
		},
		"aws_db_parameter_group": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"description": {
					Default: managedByPulumi,
				},
				"parameter": {
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

		"aws_db_subnet_group": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"description": {
					Default: managedByPulumi,
				},
			},
		},

		// RedShift
		"aws_redshift_parameter_group": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"description": {
					Default: managedByPulumi,
				},
			},
		},

		"aws_redshift_subnet_group": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"description": {
					Default: managedByPulumi,
				},
			},
		},

		"aws_redshift_integration": {
			ComputeID: tfbridge.DelegateIDField("arn", "aws", "https://github.com/pulumi/pulumi-aws"),
		},
		// Route53
		"aws_route53_record": {
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

		"aws_route53_zone": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"comment": {
					Default: managedByPulumi,
				},
			},
		},

		"aws_route53_hosted_zone_dnssec": {Tok: awsResource(route53Mod, "HostedZoneDnsSec")},

		"aws_route53_resolver_dnssec_config": {Tok: awsResource(route53Mod, "ResolverDnsSecConfig")},

		// Sagemaker
		"aws_sagemaker_human_task_ui": {Tok: awsResource(sagemakerMod, "HumanTaskUI")},

		"aws_sagemaker_device": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"device": {
					CSharpName: "DeviceDetails",
				},
			},
		},

		// Security Hub
		"aws_securityhub_configuration_policy": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"configuration_policy": {
					// Workaround CS0542 that prohibits member names matching class names.
					CSharpName: "ConfigurationPolicyDetails",
				},
			},
		},

		"aws_securityhub_organization_configuration": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"organization_configuration": {
					// Workaround CS0542 that prohibits member names matching class names.
					CSharpName: "OrganizationConfigurationDetails",
				},
			},
		},

		// Simple Email Service (SES)
		"aws_ses_domain_mail_from": {Tok: awsResource(sesMod, "MailFrom")},

		"aws_sesv2_email_identity": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"email_identity": {
					CSharpName: "EmailIdentityDetails",
				},
			},
		},

		// S3
		"aws_s3_bucket": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"acl": {
					Type:     "string",
					AltTypes: []tokens.Type{awsType(s3Mod, "CannedAcl", "CannedAcl")},
				},
				"bucket": tfbridge.AutoNameTransform("bucket", 63, func(name string) string {
					return strings.ToLower(name)
				}),
				"policy": {
					Type:      "string",
					AltTypes:  []tokens.Type{awsType(iamMod, "PolicyDocument", "PolicyDocument")},
					Transform: tfbridge.TransformJSONDocument,
				},
			},
			Aliases: []tfbridge.AliasInfo{
				{
					Type: new("aws:s3/bucketV2:BucketV2"),
				},
			},
		},
		"aws_s3_bucket_accelerate_configuration": {
			Aliases: []tfbridge.AliasInfo{
				{Type: new("aws:s3/bucketAccelerateConfigurationV2:BucketAccelerateConfigurationV2")},
			},
		},
		"aws_s3_bucket_acl": {
			Aliases: []tfbridge.AliasInfo{
				{Type: new("aws:s3/bucketAclV2:BucketAclV2")},
			},
		},
		"aws_s3_bucket_cors_configuration": {
			Aliases: []tfbridge.AliasInfo{
				{Type: new("aws:s3/bucketCorsConfigurationV2:BucketCorsConfigurationV2")},
			},
		},
		"aws_s3_bucket_lifecycle_configuration": {
			Aliases: []tfbridge.AliasInfo{
				{Type: new("aws:s3/bucketLifecycleConfigurationV2:BucketLifecycleConfigurationV2")},
			},
		},
		"aws_s3_bucket_logging": {
			Aliases: []tfbridge.AliasInfo{
				{Type: new("aws:s3/bucketLoggingV2:BucketLoggingV2")},
			},
		},
		"aws_s3_bucket_object_lock_configuration": {
			Aliases: []tfbridge.AliasInfo{
				{Type: new("aws:s3/bucketObjectLockConfigurationV2:BucketObjectLockConfigurationV2")},
			},
		},
		"aws_s3_bucket_request_payment_configuration": {
			Aliases: []tfbridge.AliasInfo{
				{Type: new("aws:s3/bucketRequestPaymentConfigurationV2:BucketRequestPaymentConfigurationV2")},
			},
		},
		"aws_s3_bucket_server_side_encryption_configuration": {
			Aliases: []tfbridge.AliasInfo{
				{Type: new("aws:s3/bucketServerSideEncryptionConfigurationV2:BucketServerSideEncryptionConfigurationV2")},
			},
		},
		"aws_s3_bucket_versioning": {
			Aliases: []tfbridge.AliasInfo{
				{Type: new("aws:s3/bucketVersioningV2:BucketVersioningV2")},
			},
		},
		"aws_s3_bucket_website_configuration": {
			Aliases: []tfbridge.AliasInfo{
				{Type: new("aws:s3/bucketWebsiteConfigurationV2:BucketWebsiteConfigurationV2")},
			},
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
					Type: new("aws:s3/BucketObject:BucketObject"),
				},
			},
		},
		"aws_s3_bucket_inventory": {Tok: awsResource(s3Mod, "Inventory")},

		"aws_s3_bucket_object": {
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
			Fields: map[string]*tfbridge.SchemaInfo{
				"policy": {
					Type:      "string",
					Transform: tfbridge.TransformJSONDocument,
				},
			},
		},

		"aws_s3_bucket_analytics_configuration": {
			Tok: awsResource(s3Mod, "AnalyticsConfiguration"),
			Docs: &tfbridge.DocInfo{
				Source: "s3_bucket_analysis_configuration.html.markdown",
			},
		},

		"aws_s3_bucket_replication_configuration": {Tok: awsResource(s3Mod, "BucketReplicationConfig")},
		// S3 Control
		"aws_s3control_bucket": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"bucket": {
					CSharpName: "BucketName",
				},
			},
		},

		"aws_s3control_storage_lens_configuration": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"storage_lens_configuration": {
					CSharpName: "StorageLensConfigurationDetail",
				},
			},
		},
		// S3 Tables
		"aws_s3tables_namespace": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"namespace": {
					// Avoid conflict with "Namespace" class name that breaks compilation.
					CSharpName: "NameSpace",
				},
			},
		},

		// Systems Manager (SSM)
		"aws_ssm_patch_group": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"patch_group": {
					CSharpName: "PatchGroupName",
				},
			},
		},
		"aws_ssm_parameter": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"type": {
					Type:     "string",
					AltTypes: []tokens.Type{awsType(ssmMod, "ParameterType", "ParameterType")},
				},
			},
		},

		// SSM Contacts
		"aws_ssmcontacts_contact":         {Tok: awsResource(ssmContactsMod, "Contact")},
		"aws_ssmcontacts_contact_channel": {Tok: awsResource(ssmContactsMod, "ContactChannel")},
		"aws_ssmcontacts_plan":            {Tok: awsResource(ssmContactsMod, "Plan")},

		// Simple Queuing Service (SQS)
		"aws_sqs_queue": {
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
			Fields: map[string]*tfbridge.SchemaInfo{
				"policy": {
					Type:      "string",
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
		"aws_storagegateway_cached_iscsi_volume": {Tok: awsResource(storagegatewayMod, "CachesIscsiVolume")},

		// Simple Notification Service (SNS)
		"aws_sns_topic": {
			Fields: map[string]*tfbridge.SchemaInfo{
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
			Fields: map[string]*tfbridge.SchemaInfo{
				"policy": {
					Type:      "string",
					Transform: tfbridge.TransformJSONDocument,
				},
			},
		},
		"aws_sns_topic_subscription": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"topic_arn": {
					Name:     "topic",
					Type:     "string",
					AltTypes: []tokens.Type{awsResource(snsMod, "Topic")},
				},
			},
		},
		"aws_sns_topic_data_protection_policy": {Tok: awsResource(snsMod, "DataProtectionPolicy")},
		// Transfer Service
		"aws_transfer_certificate": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"certificate": {CSharpName: "CertificateFile"},
			},
		},
		// Web Application Firewall (WAF)
		"aws_waf_ipset": {Tok: awsResource(wafMod, "IpSet")},

		// Web Application Firewall V2 (WAFv2)
		"aws_wafv2_api_key": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"api_key": {
					CSharpName: "Key",
				},
			},
		},

		// Web Application Firewall (WAF) Regional
		"aws_wafregional_byte_match_set": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"byte_match_tuples": {
					Name: "byteMatchTuples",
				},
			},
		},

		"aws_wafregional_ipset": {Tok: awsResource(wafregionalMod, "IpSet")},

		// MSK
		"aws_msk_cluster": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"cluster_name": tfbridge.AutoName("clusterName", 255, "-"),
			},
		},

		"aws_msk_replicator": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"log_delivery": {
					Elem: &tfbridge.SchemaInfo{
						Fields: map[string]*tfbridge.SchemaInfo{
							"replicator_log_delivery": {
								CSharpName: "LogDelivery",
							},
						},
					},
				},
			},
		},

		"aws_msk_serverless_cluster": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"cluster_name": tfbridge.AutoName("clusterName", 255, "-"),
			},
		},
		// Quicksight
		"aws_quicksight_namespace": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"namespace": {
					// Avoid conflict with "Namespace" class name that breaks compilation.
					CSharpName: "NameSpace",
				},
			},
		},
		"aws_quicksight_template": {
			Fields: map[string]*tfbridge.SchemaInfo{
				// HACK: remove this field for now as it breaks dotnet codegen due to our current type naming strategy.
				// https://github.com/pulumi/pulumi-terraform-bridge/issues/1118
				"definition": {Omit: true},
			},
		},
		"aws_quicksight_analysis": {
			Fields: map[string]*tfbridge.SchemaInfo{
				// HACK: remove this field for now as it breaks dotnet and java codegen due to our current type naming strategy.
				// https://github.com/pulumi/pulumi-terraform-bridge/issues/1118
				"definition": {Omit: true},
			},
		},
		"aws_quicksight_dashboard": {
			Fields: map[string]*tfbridge.SchemaInfo{
				// HACK: remove this field for now as it breaks dotnet and java codegen due to our current type naming strategy.
				// https://github.com/pulumi/pulumi-terraform-bridge/issues/1118
				"definition": {Omit: true},
			},
		},
		// Lex
		"aws_lex_slot_type": {
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
			Fields: map[string]*tfbridge.SchemaInfo{
				"domain": {
					CSharpName: "DomainName",
				},
			},
		},
		"aws_codeartifact_repository": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"repository": {
					CSharpName: "RepositoryName",
				},
			},
		},
		"aws_codeartifact_domain_permissions_policy": {Tok: awsResource(codeartifactMod, "DomainPermissions")},

		// Network firewall
		"aws_networkfirewall_firewall_policy": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"firewall_policy": {
					CSharpName: "FirewallPolicyConfiguration",
				},
			},
		},
		"aws_networkfirewall_logging_configuration": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"logging_configuration": {
					CSharpName: "LoggingConfig",
				},
			},
		},
		"aws_networkfirewall_rule_group": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"rule_group": {
					CSharpName: "RuleGroupConfiguration",
				},
			},
		},
		"aws_networkfirewall_resource_policy": {
			Docs: &tfbridge.DocInfo{
				ImportDetails: "Using `pulumi import`, import Network Firewall Resource Policies using the `resource arn`. For example: \n" + //nolint:lll
					"```sh\n" +
					"$ pulumi import aws:networkfirewall/resourcePolicy:ResourcePolicy example arn:aws:network-firewall:us-west-1:123456789012:stateful-rulegroup/example\n" + //nolint:lll
					"```\n",
			},
		},
		"aws_networkfirewall_tls_inspection_configuration": {
			Fields: map[string]*info.Schema{
				"tls_inspection_configuration": {
					CSharpName: "TlsInspectionConfig",
				},
			},
		},

		// ServerlessRepository
		"aws_serverlessapplicationrepository_cloudformation_stack": {
			Tok: awsResource(serverlessRepositoryMod, "CloudFormationStack"),
		},

		// Lakeformation
		"aws_lakeformation_permissions": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"permissions": {
					CSharpName: "PermissionDetails",
				},
			},
		},

		// SSO Admin
		"aws_ssoadmin_region": {
			Fields: map[string]*tfbridge.SchemaInfo{
				// This resource is named `Region`, so the cross-cutting `region` field would
				// generate a C# property named `Region`, colliding with the enclosing resource
				// class of the same name (CS0542). Rename the .NET property to avoid the clash.
				"region": {
					CSharpName: "AwsRegion",
				},
			},
		},
		// AppIntegrations
		// EventIntegration was originally published in appconfig; preserve that token for compatibility.
		"aws_appintegrations_event_integration": {Tok: awsResource(appConfigMod, "EventIntegration")},

		// controlTower
		"aws_controltower_control": {Tok: awsResource(controlTowerMod, "ControlTowerControl")},
	}
}
