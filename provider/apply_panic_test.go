package provider

import (
	"context"
	"testing"

	"github.com/hashicorp/go-cty/cty"
	"github.com/hashicorp/terraform-plugin-sdk/terraform"
	"github.com/hashicorp/terraform-provider-aws/shim"
	sdkv2 "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfshim/sdk-v2"
	"github.com/stretchr/testify/require"
)

func TestApplyPanic(t *testing.T) {
	ctx := context.Background()
	upstreamProvider, err := shim.NewUpstreamProvider(ctx)
	require.NoError(t, err)
	prov := sdkv2.NewProvider(upstreamProvider.SDKV2Provider)

	s := sdkv2.v2InstanceState{
		resource: &aws_instance_resource,
		tf: &terraform.InstanceState{
			ID:         "i-07e26eab09fca921d",
			Attributes: map[string]string{"ami": "ami-094a0fafc1bf73bd6", "arn": "arn:aws:ec2:us-west-2:616138583583:instance/i-07e26eab09fca921d", "associate_public_ip_address": "true", "availability_zone": "us-west-2d", "capacity_reservation_specification.#": "1", "capacity_reservation_specification.0.%": "2", "capacity_reservation_specification.0.capacity_reservation_preference": "open", "capacity_reservation_specification.0.capacity_reservation_target.#": "0", "cpu_core_count": "1", "cpu_options.#": "1", "cpu_options.0.%": "3", "cpu_options.0.amd_sev_snp": "", "cpu_options.0.core_count": "1", "cpu_options.0.threads_per_core": "2", "cpu_threads_per_core": "2", "credit_specification.#": "1", "credit_specification.0.%": "1", "credit_specification.0.cpu_credits": "unlimited", "disable_api_stop": "false", "disable_api_termination": "false", "ebs_block_device.#": "0", "ebs_optimized": "false", "enclave_options.#": "1", "enclave_options.0.%": "1", "enclave_options.0.enabled": "false", "ephemeral_block_device.#": "0", "get_password_data": "false", "hibernation": "false", "host_id": "", "iam_instance_profile": "", "id": "i-07e26eab09fca921d", "instance_initiated_shutdown_behavior": "stop", "instance_lifecycle": "", "instance_market_options.#": "0", "instance_state": "running", "instance_type": "t3.micro", "ipv6_address_count": "0", "ipv6_addresses.#": "0", "key_name": "", "launch_template.#": "0", "maintenance_options.#": "1", "maintenance_options.0.%": "1", "maintenance_options.0.auto_recovery": "default", "metadata_options.#": "1", "metadata_options.0.%": "5", "metadata_options.0.http_endpoint": "enabled", "metadata_options.0.http_protocol_ipv6": "disabled", "metadata_options.0.http_put_response_hop_limit": "1", "metadata_options.0.http_tokens": "optional", "metadata_options.0.instance_metadata_tags": "disabled", "monitoring": "false", "network_interface.#": "0", "outpost_arn": "", "password_data": "", "placement_group": "", "placement_partition_number": "0", "primary_network_interface_id": "eni-0b08d5cf1c9b70a46", "private_dns": "ip-10-0-1-241.us-west-2.compute.internal", "private_dns_name_options.#": "1", "private_dns_name_options.0.%": "3", "private_dns_name_options.0.enable_resource_name_dns_a_record": "false", "private_dns_name_options.0.enable_resource_name_dns_aaaa_record": "false", "private_dns_name_options.0.hostname_type": "ip-name", "private_ip": "10.0.1.241", "public_dns": "ec2-35-87-189-53.us-west-2.compute.amazonaws.com", "public_ip": "35.87.189.53", "root_block_device.#": "1", "root_block_device.0.%": "10", "root_block_device.0.delete_on_termination": "true", "root_block_device.0.device_name": "/dev/xvda", "root_block_device.0.encrypted": "false", "root_block_device.0.iops": "100", "root_block_device.0.kms_key_id": "", "root_block_device.0.tags.%": "0", "root_block_device.0.throughput": "0", "root_block_device.0.volume_id": "vol-0d83034b801b9787a", "root_block_device.0.volume_size": "8", "root_block_device.0.volume_type": "gp2", "secondary_private_ips.#": "0", "security_groups.#": "0", "source_dest_check": "true", "spot_instance_request_id": "", "subnet_id": "subnet-0bba237d66b0762e1", "tags.%": "1", "tags.Name": "webserver", "tags_all.%": "1", "tags_all.Name": "webserver", "tenancy": "default", "user_data": "dc9d70b75c68b91337b8375b3278056770a7bb8d", "user_data_replace_on_change": "false", "vpc_security_group_ids.#": "1", "vpc_security_group_ids.1004350052": "sg-00e3988f2bd4cb2ce"},
			Ephemeral:  terraform.EphemeralState{},
			Meta: map[string]interface{}{
				"e2bfb730-ecaa-11e6-8f88-34363bc7c4c0": map[string]interface{}{
					"create": float64(6e+11),
					"delete": float64(1.2e+12),
					"update": float64(6e+11),
				},
				"schema_version": "1",
			},
			ProviderMeta: cty.Value{},
			RawConfig:    cty.Value{},
			RawState:     cty.Value{},
			RawPlan:      cty.Value{},
			Tainted:      false,
		},
		diff: (*terraform.InstanceDiff)(nil),
	}
	d := sdkv2.v2InstanceDiff{
		tf: &terraform.InstanceDiff{
			Attributes:     map[string]*terraform.ResourceAttrDiff{},
			Destroy:        false,
			DestroyDeposed: false,
			DestroyTainted: false,
			RawConfig:      cty.Value{},
			// 	ty: cty.Type{
			// 		typeImpl: cty.typeObject{
			// 			typeImplSigil: cty.typeImplSigil{},
			// 			AttrTypes: {
			// 				"ami": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"arn": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"associate_public_ip_address": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x42,
			// 					},
			// 				},
			// 				"availability_zone": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"capacity_reservation_specification": {
			// 					typeImpl: cty.typeList{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						ElementTypeT: cty.Type{
			// 							typeImpl: cty.typeObject{
			// 								typeImplSigil: cty.typeImplSigil{},
			// 								AttrTypes: {
			// 									"capacity_reservation_preference": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 									"capacity_reservation_target": {
			// 										typeImpl: cty.typeList{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											ElementTypeT: cty.Type{
			// 												typeImpl: cty.typeObject{
			// 													typeImplSigil: cty.typeImplSigil{},
			// 													AttrTypes: {
			// 														"capacity_reservation_id": {
			// 															typeImpl: cty.primitiveType{
			// 																typeImplSigil: cty.typeImplSigil{},
			// 																Kind:          0x53,
			// 															},
			// 														},
			// 														"capacity_reservation_resource_group_arn": {
			// 															typeImpl: cty.primitiveType{
			// 																typeImplSigil: cty.typeImplSigil{},
			// 																Kind:          0x53,
			// 															},
			// 														},
			// 													},
			// 												},
			// 											},
			// 										},
			// 									},
			// 								},
			// 							},
			// 						},
			// 					},
			// 				},
			// 				"cpu_core_count": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x4e,
			// 					},
			// 				},
			// 				"cpu_options": {
			// 					typeImpl: cty.typeList{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						ElementTypeT: cty.Type{
			// 							typeImpl: cty.typeObject{
			// 								typeImplSigil: cty.typeImplSigil{},
			// 								AttrTypes: {
			// 									"amd_sev_snp": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 									"core_count": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x4e,
			// 										},
			// 									},
			// 									"threads_per_core": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x4e,
			// 										},
			// 									},
			// 								},
			// 							},
			// 						},
			// 					},
			// 				},
			// 				"cpu_threads_per_core": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x4e,
			// 					},
			// 				},
			// 				"credit_specification": {
			// 					typeImpl: cty.typeList{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						ElementTypeT: cty.Type{
			// 							typeImpl: cty.typeObject{
			// 								typeImplSigil: cty.typeImplSigil{},
			// 								AttrTypes: {
			// 									"cpu_credits": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 								},
			// 							},
			// 						},
			// 					},
			// 				},
			// 				"disable_api_stop": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x42,
			// 					},
			// 				},
			// 				"disable_api_termination": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x42,
			// 					},
			// 				},
			// 				"ebs_block_device": {
			// 					typeImpl: cty.typeSet{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						ElementTypeT: cty.Type{
			// 							typeImpl: cty.typeObject{
			// 								typeImplSigil: cty.typeImplSigil{},
			// 								AttrTypes: {
			// 									"delete_on_termination": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x42,
			// 										},
			// 									},
			// 									"device_name": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 									"encrypted": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x42,
			// 										},
			// 									},
			// 									"iops": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x4e,
			// 										},
			// 									},
			// 									"kms_key_id": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 									"snapshot_id": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 									"tags": {
			// 										typeImpl: cty.typeMap{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											ElementTypeT: cty.Type{
			// 												typeImpl: cty.primitiveType{
			// 													typeImplSigil: cty.typeImplSigil{},
			// 													Kind:          0x53,
			// 												},
			// 											},
			// 										},
			// 									},
			// 									"throughput": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x4e,
			// 										},
			// 									},
			// 									"volume_id": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 									"volume_size": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x4e,
			// 										},
			// 									},
			// 									"volume_type": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 								},
			// 							},
			// 						},
			// 					},
			// 				},
			// 				"ebs_optimized": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x42,
			// 					},
			// 				},
			// 				"enclave_options": {
			// 					typeImpl: cty.typeList{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						ElementTypeT: cty.Type{
			// 							typeImpl: cty.typeObject{
			// 								typeImplSigil: cty.typeImplSigil{},
			// 								AttrTypes: {
			// 									"enabled": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x42,
			// 										},
			// 									},
			// 								},
			// 							},
			// 						},
			// 					},
			// 				},
			// 				"ephemeral_block_device": {
			// 					typeImpl: cty.typeSet{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						ElementTypeT: cty.Type{
			// 							typeImpl: cty.typeObject{
			// 								typeImplSigil: cty.typeImplSigil{},
			// 								AttrTypes: {
			// 									"device_name": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 									"no_device": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x42,
			// 										},
			// 									},
			// 									"virtual_name": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 								},
			// 							},
			// 						},
			// 					},
			// 				},
			// 				"get_password_data": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x42,
			// 					},
			// 				},
			// 				"hibernation": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x42,
			// 					},
			// 				},
			// 				"host_id": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"host_resource_group_arn": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"iam_instance_profile": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"id": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"instance_initiated_shutdown_behavior": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"instance_lifecycle": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"instance_market_options": {
			// 					typeImpl: cty.typeList{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						ElementTypeT: cty.Type{
			// 							typeImpl: cty.typeObject{
			// 								typeImplSigil: cty.typeImplSigil{},
			// 								AttrTypes: {
			// 									"market_type": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 									"spot_options": {
			// 										typeImpl: cty.typeList{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											ElementTypeT: cty.Type{
			// 												typeImpl: cty.typeObject{
			// 													typeImplSigil: cty.typeImplSigil{},
			// 													AttrTypes: {
			// 														"instance_interruption_behavior": {
			// 															typeImpl: cty.primitiveType{
			// 																typeImplSigil: cty.typeImplSigil{},
			// 																Kind:          0x53,
			// 															},
			// 														},
			// 														"max_price": {
			// 															typeImpl: cty.primitiveType{
			// 																typeImplSigil: cty.typeImplSigil{},
			// 																Kind:          0x53,
			// 															},
			// 														},
			// 														"spot_instance_type": {
			// 															typeImpl: cty.primitiveType{
			// 																typeImplSigil: cty.typeImplSigil{},
			// 																Kind:          0x53,
			// 															},
			// 														},
			// 														"valid_until": {
			// 															typeImpl: cty.primitiveType{
			// 																typeImplSigil: cty.typeImplSigil{},
			// 																Kind:          0x53,
			// 															},
			// 														},
			// 													},
			// 												},
			// 											},
			// 										},
			// 									},
			// 								},
			// 							},
			// 						},
			// 					},
			// 				},
			// 				"instance_state": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"instance_type": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"ipv6_address_count": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x4e,
			// 					},
			// 				},
			// 				"ipv6_addresses": {
			// 					typeImpl: cty.typeList{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						ElementTypeT: cty.Type{
			// 							typeImpl: cty.primitiveType{
			// 								typeImplSigil: cty.typeImplSigil{},
			// 								Kind:          0x53,
			// 							},
			// 						},
			// 					},
			// 				},
			// 				"key_name": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"launch_template": {
			// 					typeImpl: cty.typeList{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						ElementTypeT: cty.Type{
			// 							typeImpl: cty.typeObject{
			// 								typeImplSigil: cty.typeImplSigil{},
			// 								AttrTypes: {
			// 									"id": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 									"name": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 									"version": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 								},
			// 							},
			// 						},
			// 					},
			// 				},
			// 				"maintenance_options": {
			// 					typeImpl: cty.typeList{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						ElementTypeT: cty.Type{
			// 							typeImpl: cty.typeObject{
			// 								typeImplSigil: cty.typeImplSigil{},
			// 								AttrTypes: {
			// 									"auto_recovery": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 								},
			// 							},
			// 						},
			// 					},
			// 				},
			// 				"metadata_options": {
			// 					typeImpl: cty.typeList{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						ElementTypeT: cty.Type{
			// 							typeImpl: cty.typeObject{
			// 								typeImplSigil: cty.typeImplSigil{},
			// 								AttrTypes: {
			// 									"http_endpoint": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 									"http_protocol_ipv6": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 									"http_put_response_hop_limit": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x4e,
			// 										},
			// 									},
			// 									"http_tokens": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 									"instance_metadata_tags": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 								},
			// 							},
			// 						},
			// 					},
			// 				},
			// 				"monitoring": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x42,
			// 					},
			// 				},
			// 				"network_interface": {
			// 					typeImpl: cty.typeSet{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						ElementTypeT: cty.Type{
			// 							typeImpl: cty.typeObject{
			// 								typeImplSigil: cty.typeImplSigil{},
			// 								AttrTypes: {
			// 									"delete_on_termination": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x42,
			// 										},
			// 									},
			// 									"device_index": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x4e,
			// 										},
			// 									},
			// 									"network_card_index": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x4e,
			// 										},
			// 									},
			// 									"network_interface_id": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 								},
			// 							},
			// 						},
			// 					},
			// 				},
			// 				"outpost_arn": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"password_data": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"placement_group": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"placement_partition_number": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x4e,
			// 					},
			// 				},
			// 				"primary_network_interface_id": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"private_dns": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"private_dns_name_options": {
			// 					typeImpl: cty.typeList{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						ElementTypeT: cty.Type{
			// 							typeImpl: cty.typeObject{
			// 								typeImplSigil: cty.typeImplSigil{},
			// 								AttrTypes: {
			// 									"enable_resource_name_dns_a_record": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x42,
			// 										},
			// 									},
			// 									"enable_resource_name_dns_aaaa_record": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x42,
			// 										},
			// 									},
			// 									"hostname_type": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 								},
			// 							},
			// 						},
			// 					},
			// 				},
			// 				"private_ip": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"public_dns": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"public_ip": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"root_block_device": {
			// 					typeImpl: cty.typeList{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						ElementTypeT: cty.Type{
			// 							typeImpl: cty.typeObject{
			// 								typeImplSigil: cty.typeImplSigil{},
			// 								AttrTypes: {
			// 									"delete_on_termination": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x42,
			// 										},
			// 									},
			// 									"device_name": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 									"encrypted": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x42,
			// 										},
			// 									},
			// 									"iops": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x4e,
			// 										},
			// 									},
			// 									"kms_key_id": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 									"tags": {
			// 										typeImpl: cty.typeMap{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											ElementTypeT: cty.Type{
			// 												typeImpl: cty.primitiveType{
			// 													typeImplSigil: cty.typeImplSigil{},
			// 													Kind:          0x53,
			// 												},
			// 											},
			// 										},
			// 									},
			// 									"throughput": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x4e,
			// 										},
			// 									},
			// 									"volume_id": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 									"volume_size": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x4e,
			// 										},
			// 									},
			// 									"volume_type": {
			// 										typeImpl: cty.primitiveType{
			// 											typeImplSigil: cty.typeImplSigil{},
			// 											Kind:          0x53,
			// 										},
			// 									},
			// 								},
			// 							},
			// 						},
			// 					},
			// 				},
			// 				"secondary_private_ips": {
			// 					typeImpl: cty.typeSet{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						ElementTypeT: cty.Type{
			// 							typeImpl: cty.primitiveType{
			// 								typeImplSigil: cty.typeImplSigil{},
			// 								Kind:          0x53,
			// 							},
			// 						},
			// 					},
			// 				},
			// 				"security_groups": {
			// 					typeImpl: cty.typeSet{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						ElementTypeT: cty.Type{
			// 							typeImpl: cty.primitiveType{
			// 								typeImplSigil: cty.typeImplSigil{},
			// 								Kind:          0x53,
			// 							},
			// 						},
			// 					},
			// 				},
			// 				"source_dest_check": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x42,
			// 					},
			// 				},
			// 				"spot_instance_request_id": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"subnet_id": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"tags": {
			// 					typeImpl: cty.typeMap{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						ElementTypeT: cty.Type{
			// 							typeImpl: cty.primitiveType{
			// 								typeImplSigil: cty.typeImplSigil{},
			// 								Kind:          0x53,
			// 							},
			// 						},
			// 					},
			// 				},
			// 				"tags_all": {
			// 					typeImpl: cty.typeMap{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						ElementTypeT: cty.Type{
			// 							typeImpl: cty.primitiveType{
			// 								typeImplSigil: cty.typeImplSigil{},
			// 								Kind:          0x53,
			// 							},
			// 						},
			// 					},
			// 				},
			// 				"tenancy": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"timeouts": {
			// 					typeImpl: cty.typeObject{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						AttrTypes: {
			// 							"create": {
			// 								typeImpl: cty.primitiveType{
			// 									typeImplSigil: cty.typeImplSigil{},
			// 									Kind:          0x53,
			// 								},
			// 							},
			// 							"delete": {
			// 								typeImpl: cty.primitiveType{
			// 									typeImplSigil: cty.typeImplSigil{},
			// 									Kind:          0x53,
			// 								},
			// 							},
			// 							"update": {
			// 								typeImpl: cty.primitiveType{
			// 									typeImplSigil: cty.typeImplSigil{},
			// 									Kind:          0x53,
			// 								},
			// 							},
			// 						},
			// 					},
			// 				},
			// 				"user_data": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"user_data_base64": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 				"user_data_replace_on_change": {
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x42,
			// 					},
			// 				},
			// 				"volume_tags": {
			// 					typeImpl: cty.typeMap{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						ElementTypeT: cty.Type{
			// 							typeImpl: cty.primitiveType{
			// 								typeImplSigil: cty.typeImplSigil{},
			// 								Kind:          0x53,
			// 							},
			// 						},
			// 					},
			// 				},
			// 				"vpc_security_group_ids": {
			// 					typeImpl: cty.typeSet{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						ElementTypeT: cty.Type{
			// 							typeImpl: cty.primitiveType{
			// 								typeImplSigil: cty.typeImplSigil{},
			// 								Kind:          0x53,
			// 							},
			// 						},
			// 					},
			// 				},
			// 			},
			// 		},
			// 	},
			// 	v: map[string]interface{}{
			// 		"ami":                                  "ami-094a0fafc1bf73bd6",
			// 		"arn":                                  nil,
			// 		"associate_public_ip_address":          nil,
			// 		"availability_zone":                    nil,
			// 		"capacity_reservation_specification":   nil,
			// 		"cpu_core_count":                       nil,
			// 		"cpu_options":                          nil,
			// 		"cpu_threads_per_core":                 nil,
			// 		"credit_specification":                 nil,
			// 		"disable_api_stop":                     nil,
			// 		"disable_api_termination":              nil,
			// 		"ebs_block_device":                     nil,
			// 		"ebs_optimized":                        nil,
			// 		"enclave_options":                      nil,
			// 		"ephemeral_block_device":               nil,
			// 		"get_password_data":                    bool(false),
			// 		"hibernation":                          nil,
			// 		"host_id":                              nil,
			// 		"host_resource_group_arn":              nil,
			// 		"iam_instance_profile":                 nil,
			// 		"id":                                   nil,
			// 		"instance_initiated_shutdown_behavior": nil,
			// 		"instance_lifecycle":                   nil,
			// 		"instance_market_options":              nil,
			// 		"instance_state":                       nil,
			// 		"instance_type":                        "t3.micro",
			// 		"ipv6_address_count":                   nil,
			// 		"ipv6_addresses":                       nil,
			// 		"key_name":                             nil,
			// 		"launch_template":                      nil,
			// 		"maintenance_options":                  nil,
			// 		"metadata_options":                     nil,
			// 		"monitoring":                           nil,
			// 		"network_interface":                    nil,
			// 		"outpost_arn":                          nil,
			// 		"password_data":                        nil,
			// 		"placement_group":                      nil,
			// 		"placement_partition_number":           nil,
			// 		"primary_network_interface_id":         nil,
			// 		"private_dns":                          nil,
			// 		"private_dns_name_options":             nil,
			// 		"private_ip":                           nil,
			// 		"public_dns":                           nil,
			// 		"public_ip":                            nil,
			// 		"root_block_device":                    nil,
			// 		"secondary_private_ips":                nil,
			// 		"security_groups":                      nil,
			// 		"source_dest_check":                    bool(true),
			// 		"spot_instance_request_id":             nil,
			// 		"subnet_id":                            "subnet-0bba237d66b0762e1",
			// 		"tags": map[string]interface{}{
			// 			"Name": "webserver",
			// 		},
			// 		"tags_all": map[string]interface{}{
			// 			"Name": "webserver",
			// 		},
			// 		"tenancy":                     nil,
			// 		"timeouts":                    nil,
			// 		"user_data":                   "#!/bin/bash\n# v2\necho \"Hello, World from Pulumi!\" > index.html\nnohup python -m SimpleHTTPServer 80 &\n",
			// 		"user_data_base64":            nil,
			// 		"user_data_replace_on_change": bool(false),
			// 		"volume_tags":                 nil,
			// 		"vpc_security_group_ids": set.Set{
			// 			vals: {
			// 				40171818: {
			// 					"sg-00e3988f2bd4cb2ce",
			// 				},
			// 			},
			// 			rules: cty.setRules{
			// 				Type: cty.Type{
			// 					typeImpl: cty.primitiveType{
			// 						typeImplSigil: cty.typeImplSigil{},
			// 						Kind:          0x53,
			// 					},
			// 				},
			// 			},
			// 		},
			// 	},
			// },
			RawState: cty.Value{},
			RawPlan:  cty.Value{},
			Meta:     map[string]interface{}{},
		},
	}
	_, err = prov.Apply("aws_instance", s, d)
	require.NoError(t, err)
}
