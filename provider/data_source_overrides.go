package provider

import (
	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge/info"
)

func dataSourceOverrides() map[string]*tfbridge.DataSourceInfo {
	return map[string]*tfbridge.DataSourceInfo{
		// AWS
		"aws_arn":                     {Tok: awsDataSource(awsMod, "getArn")},
		"aws_availability_zone":       {Tok: awsDataSource(awsMod, "getAvailabilityZone")},
		"aws_availability_zones":      {Tok: awsDataSource(awsMod, "getAvailabilityZones")},
		"aws_billing_service_account": {Tok: awsDataSource(awsMod, "getBillingServiceAccount")},
		"aws_caller_identity":         {Tok: awsDataSource(awsMod, "getCallerIdentity")},

		"aws_ip_ranges":         {Tok: awsDataSource(awsMod, "getIpRanges")},
		"aws_partition":         {Tok: awsDataSource(awsMod, "getPartition")},
		"aws_region":            {Tok: awsDataSource(awsMod, "getRegion")},
		"aws_regions":           {Tok: awsDataSource(awsMod, "getRegions")},
		"aws_service_principal": {Tok: awsDataSource(awsMod, "getServicePrincipal")},
		"aws_default_tags":      {Tok: awsDataSource(awsMod, "getDefaultTags")},
		"aws_service":           {Tok: awsDataSource(awsMod, "getService")},
		// API Gateway
		"aws_api_gateway_api_key": {Tok: awsDataSource(apigatewayMod, "getKey")},

		// CloudFormation
		"aws_cloudformation_type": {Tok: awsDataSource(cloudformationMod, "getCloudFormationType")},
		// DynamoDB
		"aws_dynamodb_table": {
			Fields: map[string]*tfbridge.SchemaInfo{
				// Override default pluralization ("indices") to match AWS APIs
				"global_secondary_index": {Name: "globalSecondaryIndexes"},
				"local_secondary_index":  {Name: "localSecondaryIndexes"},
				// These are one field per table in the AWS API,
				// so we enforce that at the Pulumi API as
				// well. See
				// https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/time-to-live-ttl-how-to.html
				"ttl":                    {MaxItemsOne: new(true)},
				"point_in_time_recovery": {MaxItemsOne: new(true)},
			},
		},

		// EC2
		"aws_ami":              {Tok: awsDataSource(ec2Mod, "getAmi")},
		"aws_ami_ids":          {Tok: awsDataSource(ec2Mod, "getAmiIds")},
		"aws_eip":              {Tok: awsDataSource(ec2Mod, "getElasticIp")},
		"aws_prefix_list":      {Tok: awsDataSource(ec2Mod, "getPrefixList")},
		"aws_customer_gateway": {Tok: awsDataSource(ec2Mod, "getCustomerGateway")},
		"aws_instance":         {Tok: awsDataSource(ec2Mod, "getInstance")},

		"aws_instances":            {Tok: awsDataSource(ec2Mod, "getInstances")},
		"aws_internet_gateway":     {Tok: awsDataSource(ec2Mod, "getInternetGateway")},
		"aws_launch_configuration": {Tok: awsDataSource(ec2Mod, "getLaunchConfiguration")},
		"aws_launch_template": {
			Tok: awsDataSource(ec2Mod, "getLaunchTemplate"),
			Fields: map[string]*tfbridge.SchemaInfo{
				"network_interfaces": {
					Elem: &tfbridge.SchemaInfo{
						Fields: map[string]*tfbridge.SchemaInfo{
							"associate_public_ip_address": {
								Type:           "boolean",
								MarkAsOptional: new(true),
							},
							"delete_on_termination": {
								Type:           "boolean",
								MarkAsOptional: new(true),
							},
						},
					},
				},
			},
		},
		"aws_nat_gateway":             {Tok: awsDataSource(ec2Mod, "getNatGateway")},
		"aws_nat_gateways":            {Tok: awsDataSource(ec2Mod, "getNatGateways")},
		"aws_network_acls":            {Tok: awsDataSource(ec2Mod, "getNetworkAcls")},
		"aws_network_interface":       {Tok: awsDataSource(ec2Mod, "getNetworkInterface")},
		"aws_network_interfaces":      {Tok: awsDataSource(ec2Mod, "getNetworkInterfaces")},
		"aws_route":                   {Tok: awsDataSource(ec2Mod, "getRoute")},
		"aws_route_table":             {Tok: awsDataSource(ec2Mod, "getRouteTable")},
		"aws_route_tables":            {Tok: awsDataSource(ec2Mod, "getRouteTables")},
		"aws_security_group":          {Tok: awsDataSource(ec2Mod, "getSecurityGroup")},
		"aws_security_groups":         {Tok: awsDataSource(ec2Mod, "getSecurityGroups")},
		"aws_subnet":                  {Tok: awsDataSource(ec2Mod, "getSubnet")},
		"aws_key_pair":                {Tok: awsDataSource(ec2Mod, "getKeyPair")},
		"aws_subnets":                 {Tok: awsDataSource(ec2Mod, "getSubnets")},
		"aws_vpc":                     {Tok: awsDataSource(ec2Mod, "getVpc")},
		"aws_vpc_dhcp_options":        {Tok: awsDataSource(ec2Mod, "getVpcDhcpOptions")},
		"aws_vpc_endpoint":            {Tok: awsDataSource(ec2Mod, "getVpcEndpoint")},
		"aws_vpc_endpoint_service":    {Tok: awsDataSource(ec2Mod, "getVpcEndpointService")},
		"aws_vpc_peering_connection":  {Tok: awsDataSource(ec2Mod, "getVpcPeeringConnection")},
		"aws_vpc_peering_connections": {Tok: awsDataSource(ec2Mod, "getVpcPeeringConnections")},
		"aws_vpcs":                    {Tok: awsDataSource(ec2Mod, "getVpcs")},
		"aws_vpn_connection":          {Tok: awsDataSource(ec2Mod, "getVpnConnection")},
		"aws_vpn_gateway":             {Tok: awsDataSource(ec2Mod, "getVpnGateway")},

		"aws_ec2_host": {Tok: awsDataSource(ec2Mod, "getDedicatedHost")},

		"aws_ec2_transit_gateway_route_tables": {Tok: awsDataSource(ec2Mod, "getTransitGatewayRouteTables")},

		"aws_vpc_ipam":                   {Tok: awsDataSource(ec2Mod, "getVpcIpam")},
		"aws_vpc_ipams":                  {Tok: awsDataSource(ec2Mod, "getVpcIpams")},
		"aws_vpc_ipam_pool":              {Tok: awsDataSource(ec2Mod, "getVpcIpamPool")},
		"aws_vpc_ipam_pools":             {Tok: awsDataSource(ec2Mod, "getVpcIpamPools")},
		"aws_vpc_ipam_pool_cidrs":        {Tok: awsDataSource(ec2Mod, "getVpcIpamPoolCidrs")},
		"aws_vpc_ipam_preview_next_cidr": {Tok: awsDataSource(ec2Mod, "getIpamPreviewNextCidr")},
		"aws_eips":                       {Tok: awsDataSource(ec2Mod, "getEips")},

		// EC2 Transit Gateway
		"aws_ec2_transit_gateway": {Tok: awsDataSource(ec2TransitGatewayMod, "getTransitGateway")},

		"aws_ec2_transit_gateway_dx_gateway_attachment": {
			Tok: awsDataSource(ec2TransitGatewayMod, "getDirectConnectGatewayAttachment"),
		},

		// Elastic Beanstalk
		"aws_elastic_beanstalk_application": {
			Fields: map[string]*tfbridge.SchemaInfo{
				// This attribute is flattened upstream, so we
				// only show one item in the Pulumi
				// API. https://github.com/hashicorp/terraform-provider-aws/blob/71ac1fa8dd1c0aea46877437921d7443edbe0aa7/internal/service/elasticbeanstalk/application_data_source.go#L73
				"appversion_lifecycle": {MaxItemsOne: new(true)},
			},
		},

		// Elastic Load Balancer
		"aws_elb": {
			Tok: awsDataSource(elbMod, "getLoadBalancer"),
			Fields: map[string]*tfbridge.SchemaInfo{
				// This attribute is flattened upstream:
				// https://github.com/hashicorp/terraform-provider-aws/blob/c14a7fe82ab84aaa9db676c9ee4242e20fb33145/internal/service/elb/load_balancer_data_source.go#L302.
				"access_logs": {MaxItemsOne: new(true)},
				// This attribute is flattened upstream:
				// https://github.com/hashicorp/terraform-provider-aws/blob/c14a7fe82ab84aaa9db676c9ee4242e20fb33145/internal/service/elb/load_balancer_data_source.go#L327
				"health_check": {MaxItemsOne: new(true)},
			},
		},

		// Elastic Block Storage
		"aws_ebs_volumes": {Tok: awsDataSource(ebsMod, "getEbsVolumes")},
		// Elastic Container Registry
		"aws_ecr_credentials": {
			Docs: &info.Doc{
				AllowMissing: true,
			},
			Fields: map[string]*info.Schema{
				"registry_id": {
					MarkAsOptional: new(false),
				},
				"region": {
					Omit: true,
				},
				"authorization_token": {
					// Intentionally non-secret for v6 compatibility, even though it base64-encodes password.
					Secret: new(false),
				},
			},
		},
		// ECS for Kubernetes
		"aws_eks_cluster": {
			Fields: map[string]*tfbridge.SchemaInfo{
				// This attribute is flattened upstream. See
				// https://github.com/hashicorp/terraform-provider-aws/blob/c14a7fe82ab84aaa9db676c9ee4242e20fb33145/internal/service/eks/cluster_data_source.go#L231
				// for details.
				"vpc_config": {MaxItemsOne: new(true)},
			},
		},

		// Fsx
		"aws_fsx_openzfs_snapshot": {Tok: awsDataSource(fsxMod, "getOpenZfsSnapshot")},

		// Lambda
		"aws_lambda_function": {
			Fields: map[string]*tfbridge.SchemaInfo{
				// This item is flattened upstream. See
				// https://github.com/hashicorp/terraform-provider-aws/blob/71ac1fa8dd1c0aea46877437921d7443edbe0aa7/internal/service/lambda/function_data_source.go#L263-L273
				"dead_letter_config": {MaxItemsOne: new(true)},
				// This item is flattened upstream. See
				// https://github.com/hashicorp/terraform-provider-aws/blob/71ac1fa8dd1c0aea46877437921d7443edbe0aa7/internal/service/lambda/function_data_source.go#L321-L323
				"vpc_config": {MaxItemsOne: new(true)},
				// This item is flattened upstream. See
				// https://github.com/hashicorp/terraform-provider-aws/blob/71ac1fa8dd1c0aea46877437921d7443edbe0aa7/internal/service/lambda/function_data_source.go#L275-L277
				"environment": {MaxItemsOne: new(true)},
				// This item is flattened upstream. See
				// https://github.com/hashicorp/terraform-provider-aws/blob/71ac1fa8dd1c0aea46877437921d7443edbe0aa7/internal/service/lambda/function_data_source.go#L313-L319
				"tracing_config": {MaxItemsOne: new(true)},
			},
		},

		// MQ
		"aws_mq_broker": {
			Fields: map[string]*tfbridge.SchemaInfo{
				// This attribute is flattened upstream. See
				// https://github.com/hashicorp/terraform-provider-aws/blob/c14a7fe82ab84aaa9db676c9ee4242e20fb33145/internal/service/mq/broker_data_source.go#L315-L317
				"configuration": {MaxItemsOne: new(true)},
				// This attribute is flattened upstream. See
				// https://github.com/hashicorp/terraform-provider-aws/blob/c14a7fe82ab84aaa9db676c9ee4242e20fb33145/internal/service/mq/broker_data_source.go#L336-L338.
				"maintenance_window_start_time": {MaxItemsOne: new(true)},
				// This attribute is flattened upstream.
				"logs": {
					MaxItemsOne: new(true),
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
		"aws_iam_openid_connect_provider": {Tok: awsDataSource(iamMod, "getOpenIdConnectProvider")},

		// Key Management Service
		"aws_kms_ciphertext": {Tok: awsDataSource(kmsMod, "getCipherText")},

		// LicenseManager NB slightly inconsistent translation of the names, to be close to the
		// resource names, but avoid repeating 'license'.
		"aws_licensemanager_grants": {Tok: awsDataSource(licensemanagerMod, "getLicenseGrants")},

		// Route53
		"aws_route53_resolver_query_log_config": {Tok: awsDataSource(route53Mod, "getQueryLogConfig")},

		// S3
		"aws_canonical_user_id": {Tok: awsDataSource(s3Mod, "getCanonicalUserId")},

		// Secrets Manager
		"aws_spot_datafeed_subscription": {Tok: awsDataSource(ec2Mod, "getSpotDatafeedSubscription")},

		// SSM Contacts
		"aws_ssmcontacts_contact":         {Tok: awsDataSource(ssmContactsMod, "getContact")},
		"aws_ssmcontacts_contact_channel": {Tok: awsDataSource(ssmContactsMod, "getContactChannel")},
		"aws_ssmcontacts_plan":            {Tok: awsDataSource(ssmContactsMod, "getPlan")},
		// WAF Regional
		"aws_wafregional_rate_based_rule": {Tok: awsDataSource(wafregionalMod, "getRateBasedMod")},

		// Organizations
		"aws_organizations_organizational_units": {
			Fields: map[string]*tfbridge.SchemaInfo{
				// The inflector incorrectly pluralizes this to
				// "childrens".
				"children": {Name: "children"},
			},
		},

		// ALB
		"aws_alb": {
			Tok:  awsDataSource(albMod, "getLoadBalancer"),
			Docs: &tfbridge.DocInfo{Source: "lb.html.markdown"},
			Fields: map[string]*tfbridge.SchemaInfo{
				// This attribute is flattened upstream. See
				// https://github.com/hashicorp/terraform-provider-aws/blob/c14a7fe82ab84aaa9db676c9ee4242e20fb33145/internal/service/elbv2/load_balancer_data_source.go#L319
				"access_logs": {MaxItemsOne: new(true)},
			},
		},
		"aws_alb_listener": {
			Docs: &tfbridge.DocInfo{Source: "lb_listener.html.markdown"},
		},
		"aws_alb_target_group": {
			Docs: &tfbridge.DocInfo{Source: "lb_target_group.html.markdown"},
			Fields: map[string]*tfbridge.SchemaInfo{
				"health_check": {MaxItemsOne: new(true)},
				"stickiness":   {MaxItemsOne: new(true)},
			},
		},

		// Autoscaling
		"aws_autoscaling_groups": {Tok: awsDataSource(autoscalingMod, "getAmiIds")},

		// lb mod
		"aws_lbs": {Tok: awsDataSource(lbMod, "getLbs")},
		"aws_lb": {
			Tok: awsDataSource(lbMod, "getLoadBalancer"),
			Fields: map[string]*tfbridge.SchemaInfo{
				"access_logs": {
					MaxItemsOne: new(true),
				},
			},
		},

		"aws_lb_target_group": {
			Fields: map[string]*tfbridge.SchemaInfo{
				"stickiness": {
					MaxItemsOne: new(true),
				},
				"health_check": {
					MaxItemsOne: new(true),
				},
			},
		},

		// Quicksight
		"aws_quicksight_group": {Tok: awsDataSource(quicksightMod, "getQuicksightGroup")},
		"aws_quicksight_user":  {Tok: awsDataSource(quicksightMod, "getQuicksightUser")},

		"aws_quicksight_analysis": {
			Tok: awsDataSource(quicksightMod, "getQuicksightAnalysis"),
			Fields: map[string]*tfbridge.SchemaInfo{
				// HACK: remove this field for now as it breaks dotnet codegen due to our current type naming strategy.
				// https://github.com/pulumi/pulumi-terraform-bridge/issues/1118
				"definition": {Omit: true},
			},
		},

		// Resource Explorer 2
		"aws_resourceexplorer2_search": {
			Tok: awsDataSource("ResourceExplorer", "Search"),
		},
	}
}
