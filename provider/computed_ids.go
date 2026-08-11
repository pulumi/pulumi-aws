package provider

import (
	"context"
	"strings"

	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge/info"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
)

func setupComputedIDs(prov *tfbridge.ProviderInfo) {
	attrWithSeparator := func(state resource.PropertyMap, sep string, attrs ...resource.PropertyKey) resource.ID {
		parts := []string{}
		stateResource := resource.NewObjectProperty(state)
		for _, a := range attrs {
			path, err := resource.ParsePropertyPath(string(a))
			contract.AssertNoErrorf(err, "failed to parse property path %s", a)
			if v, ok := path.Get(stateResource); ok {
				if v.IsString() && v.StringValue() != "" {
					parts = append(parts, v.StringValue())
				}
			}
		}
		s := strings.Join(parts, sep)
		if s == "" {
			s = "id"
		}
		return resource.ID(s)
	}

	// Helper function that returns a ComputeID function
	computeIDWith := func(sep string, attrs ...resource.PropertyKey) func(context.Context, resource.PropertyMap) (resource.ID, error) { //nolint:lll
		return func(_ context.Context, state resource.PropertyMap) (resource.ID, error) {
			return attrWithSeparator(state, sep, attrs...), nil
		}
	}

	// Helper for default separator
	computeID := func(attrs ...resource.PropertyKey) func(context.Context, resource.PropertyMap) (resource.ID, error) {
		return computeIDWith(",", attrs...)
	}

	computeIDConfigs := map[string]func(context.Context, resource.PropertyMap) (resource.ID, error){
		"aws_cloudwatch_log_index_policy":                                  computeID("logGroupName"),
		"aws_cloudwatch_log_delivery_source":                               computeID("name"),
		"aws_cloudwatch_log_delivery_destination_policy":                   computeID("deliveryDestinationName"),
		"aws_cloudwatch_log_delivery_destination":                          computeID("name"),
		"aws_media_packagev2_channel_group":                                computeID("name"),
		"aws_timestreamquery_scheduled_query":                              computeID("arn"),
		"aws_route53domains_domain":                                        computeID("domainName"),
		"aws_api_gateway_rest_api_put":                                     computeID("restApiId"),
		"aws_ec2_default_credit_specification":                             computeID("instanceFamily"),
		"aws_inspector2_filter":                                            computeID("arn"),
		"aws_cloudfrontkeyvaluestore_keys_exclusive":                       computeID("keyValueStoreArn"),
		"aws_workspacesweb_network_settings":                               computeID("networkSettingsArn"),
		"aws_workspacesweb_browser_settings":                               computeID("browserSettingsArn"),
		"aws_workspacesweb_user_settings":                                  computeID("userSettingsArn"),
		"aws_workspacesweb_data_protection_settings":                       computeID("dataProtectionSettingsArn"),
		"aws_workspacesweb_user_access_logging_settings":                   computeID("userAccessLoggingSettingsArn"),
		"aws_workspacesweb_ip_access_settings":                             computeID("ipAccessSettingsArn"),
		"aws_quicksight_account_settings":                                  computeID("awsAccountId"),
		"aws_notificationscontacts_email_contact":                          computeID("arn"),
		"aws_notifications_notification_configuration":                     computeID("arn"),
		"aws_notifications_notification_hub":                               computeID("notificationHubRegion"),
		"aws_notifications_event_rule":                                     computeID("arn"),
		"aws_notifications_channel_association":                            computeIDWith("__", "notificationConfigurationArn", "arn"), //nolint:lll
		"aws_prometheus_workspace_configuration":                           computeID("workspaceId"),
		"aws_vpc_route_server":                                             computeID("routeServerId"),
		"aws_vpc_route_server_propagation":                                 computeID("routeServerPropagationId"),
		"aws_vpc_route_server_endpoint":                                    computeID("routeServerEndpointId"),
		"aws_vpc_route_server_peer":                                        computeID("routeServerPeerId"),
		"aws_dsql_cluster_peering":                                         computeID("identifier"),
		"aws_dsql_cluster":                                                 computeID("identifier"),
		"aws_prometheus_query_logging_configuration":                       computeID("workspaceId"),
		"aws_fsx_s3_access_point_attachment":                               computeID("name"),
		"aws_cognito_log_delivery_configuration":                           computeID("userPoolId"),
		"aws_s3_bucket_metadata_configuration":                             computeID("bucket"),
		"aws_networkfirewall_firewall_transit_gateway_attachment_accepter": computeID("id"),
		"aws_connect_phone_number_contact_flow_association":                computeIDWith("__", "phoneNumberId", "instanceId", "contractFlowId"), //nolint:lll
		"aws_quicksight_ip_restriction":                                    computeID("awsAccountId"),
		"aws_quicksight_key_registration":                                  computeID("awsAccountId"),
		"aws_nat_gateway_eip_association":                                  computeID("natGatewayId", "allocationId"),
		"aws_vpc_route_server_vpc_association":                             computeID("routeServerId", "vpcId"),
		"aws_s3control_directory_bucket_access_point_scope":                computeID("name", "accountId"),
		"aws_wafv2_api_key":                                                computeID("apiKey", "scope"),
		"aws_athena_capacity_reservation":                                  computeID("name"),
		"aws_route53_records_exclusive":                                    computeID("zoneId"),
		"aws_network_interface_permission":                                 computeID("networkInterfacePermissionId"),
		"aws_lakeformation_opt_in":                                         computeID("principal.dataLakePrincipalIdentifier"), //nolint:lll
		"aws_lakeformation_lf_tag_expression":                              computeIDWith("__", "catalogId", "name"),
		"aws_rds_shard_group":                                              computeID("dbShardGroupIdentifier"),
		"aws_macie2_organization_configuration":                            computeID("autoEnable"),
		"aws_xray_resource_policy":                                         computeID("policyName"),
		"aws_quicksight_role_membership":                                   computeID("awsAccountId", "namespace", "role", "memberName"), //nolint:lll
		"aws_cloudwatch_contributor_managed_insight_rule":                  computeID("arn"),
		"aws_cloudwatch_contributor_insight_rule":                          computeID("name"),
		"aws_guardduty_member_detector_feature":                            computeID("detectorId", "accountId", "name"),
		"aws_memorydb_multi_region_cluster":                                computeID("multiRegionClusterName"),
		"aws_cloudwatch_log_anomaly_detector":                              computeID("arn"),
		"aws_ecr_account_setting":                                          computeID("name"),
		"aws_servicecatalogappregistry_attribute_group_association":        computeID("applicationId", "attributeGroupId"),
		"aws_s3tables_table_bucket_policy":                                 computeID("tableBucketArn"),
		"aws_s3tables_namespace":                                           computeIDWith(";", "tableBucketArn", "namespace"),
		"aws_s3tables_table":                                               computeIDWith(";", "tableBucketArn", "namespace", "name"), //nolint:lll
		"aws_s3tables_table_policy":                                        computeIDWith(";", "tableBucketArn", "namespace", "name"), //nolint:lll
		"aws_s3tables_table_bucket":                                        computeID("arn"),
		"aws_rds_instance_state":                                           computeID("identifier"),
		"aws_vpc_security_group_vpc_association":                           computeID("id"),
		"aws_opensearch_authorize_vpc_endpoint_access":                     computeID("domainName"),
		"aws_ssmquicksetup_configuration_manager":                          computeID("managerARN"),
		"aws_resiliencehub_resiliency_policy":                              computeID("arn"),
		"aws_iam_user_policy_attachments_exclusive":                        computeID("userName"),
		"aws_iam_group_policy_attachments_exclusive":                       computeID("groupName"),
		"aws_iam_role_policy_attachments_exclusive":                        computeID("roleName"),
		"aws_backup_restore_testing_selection":                             computeIDWith(":", "name", "restoreTestingPlanName"), //nolint:lll
		"aws_backup_restore_testing_plan":                                  computeID("name"),
		"aws_iam_user_policies_exclusive":                                  computeID("userName"),
		"aws_iam_group_policies_exclusive":                                 computeID("groupName"),
		"aws_bedrock_guardrail_version":                                    computeID("guardrailArn", "version"),
		"aws_elasticache_reserved_cache_node":                              computeID("id"),
		"aws_iam_role_policies_exclusive":                                  computeID("roleName"),
		"aws_lambda_function_recursion_config":                             computeID("functionName"),
		"aws_datazone_asset_type":                                          computeIDWith("__", "domainIdentifier", "name"),
		"aws_glue_catalog_table_optimizer":                                 computeIDWith("__", "catalogId", "databaseName", "tableName", "type"), //nolint:lll
		"aws_pinpoint_email_template":                                      computeID("templateName"),
		"aws_datazone_form_type":                                           computeIDWith("__", "domainIdentifier", "name", "revision"), //nolint:lll
		"aws_bedrock_guardrail":                                            computeIDWith("__", "guardrailId", "version"),
		"aws_chatbot_teams_channel_configuration":                          computeID("configurationName"),
		"aws_chatbot_slack_channel_configuration":                          computeID("configurationName"),
		"aws_rekognition_stream_processor":                                 computeID("name"),
		"aws_vpc_endpoint_private_dns":                                     computeID("vpcEndpointId"),
		"aws_vpc_endpoint_service_private_dns_verification":                computeID("serviceId"),
		"aws_datazone_environment_blueprint_configuration":                 computeIDWith("__", "domainId", "environmentBlueprintId"), //nolint:lll
		"aws_lambda_runtime_management_config":                             computeIDWith("__", "functionName", "qualifier"),
		"aws_quicksight_role_custom_permission":                            computeID("awsAccountId", "namespace", "role"),
		"aws_wafv2_web_acl_rule_group_association":                         computeID("webAclArn", "ruleGroupArn", "ruleName"), //nolint:lll
		"aws_networkfirewall_vpc_endpoint_association":                     computeID("vpcEndpointAssociationArn"),
		"aws_quicksight_custom_permissions":                                computeID("awsAccountId", "customPermissionsName"), //nolint:lll
		"aws_quicksight_user_custom_permission":                            computeID("awsAccountId", "namespace", "userName"), //nolint:lll
		"aws_appsync_api":                                                  computeID("apiId"),
		"aws_appsync_channel_namespace":                                    computeID("apiId", "name"),
		"aws_workspacesweb_portal":                                         computeID("portalArn"),
		"aws_workspacesweb_identity_provider":                              computeID("identityProviderArn"),
		"aws_workspacesweb_trust_store":                                    computeID("trustStoreArn"),
		"aws_workspacesweb_session_logger":                                 computeID("sessionLoggerArn"),
		"aws_workspacesweb_browser_settings_association":                   computeID("browserSettingsArn", "portalArn"),
		"aws_workspacesweb_network_settings_association":                   computeID("networkSettingsArn", "portalArn"),
		"aws_workspacesweb_trust_store_association":                        computeID("trustStoreArn", "portalArn"),
		"aws_workspacesweb_data_protection_settings_association":           computeID("dataProtectionSettingsArn", "portalArn"),    //nolint:lll
		"aws_workspacesweb_user_access_logging_settings_association":       computeID("userAccessLoggingSettingsArn", "portalArn"), //nolint:lll
		"aws_workspacesweb_user_settings_association":                      computeID("userSettingsArn", "portalArn"),
		"aws_workspacesweb_session_logger_association":                     computeID("sessionLoggerArn", "portalArn"),
		"aws_workspacesweb_ip_access_settings_association":                 computeID("ipAccessSettingsArn", "portalArn"),
		"aws_cognito_managed_login_branding":                               computeID("userPoolId", "managedLoginBrandingId"),
		"aws_controltower_baseline":                                        computeID("arn"),
	}

	// Apply configurations
	for tfResourceID, computeIDFunc := range computeIDConfigs {
		if _, ok := prov.Resources[tfResourceID]; !ok {
			prov.Resources[tfResourceID] = &info.Resource{}
		}
		prov.Resources[tfResourceID].ComputeID = computeIDFunc
	}
}
