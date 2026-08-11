package provider

import (
	"strings"

	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge/info"
	shim "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfshim"
	"github.com/pulumi/pulumi/sdk/v3/go/common/tokens"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
)

func applyCompatibilityOverrides(prov *tfbridge.ProviderInfo) {
	legacyInfo := &info.Resource{
		Tok:                awsResource(s3Mod, "BucketV2"),
		DeprecationMessage: "s3.BucketV2 has been deprecated in favor of s3.Bucket",
		Docs: &info.Doc{
			Source: "s3_bucket.html.markdown",
		},
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
	}
	prov.Resources["aws_s3_bucket_v2_compat"] = legacyInfo
	err := shim.CloneResource(prov.P.ResourcesMap(), "aws_s3_bucket", "aws_s3_bucket_v2_compat")
	contract.AssertNoErrorf(err, "Failed to clone aws_s3_bucket to aws_s3_bucket_v2_compat")

	policyDocumentResources := map[string]map[string]string{
		cloudwatchMod: {
			"aws_cloudwatch_log_resource_policy": "policy_document",
		},
		ecrMod: {
			"aws_ecr_repository_policy": "policy",
			"aws_ecr_registry_policy":   "policy",
		},
		elasticsearchMod: {
			"aws_elasticsearch_domain":        "access_policies",
			"aws_elasticsearch_domain_policy": "access_policies",
		},
		s3Mod: {
			"aws_s3_bucket_policy": "policy",
			"aws_s3_bucket":        "policy",
		},
		snsMod: {
			"aws_sns_topic_policy": "policy",
		},
		sqsMod: {
			"aws_sqs_queue_policy": "policy",
		},
	}

	// TODO[pulumi/pulumi#8324] Required workaround since these module do not already import from iam
	iamDoc, ok := prov.ExtraTypes["aws:iam/PolicyDocument:PolicyDocument"]
	contract.Assertf(ok, "aws:iam/PolicyDocument:PolicyDocument type not found")
	for mod, resources := range policyDocumentResources {
		typ := awsType(mod, "PolicyDocument", "PolicyDocument")
		prov.ExtraTypes[typ.String()] = iamDoc
		for name, prop := range resources {
			res := prov.Resources[name]
			res.Fields[prop].AltTypes = []tokens.Type{typ}
			prov.Resources[name] = res
		}
	}
}
