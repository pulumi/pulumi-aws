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
	"fmt"
	"path/filepath"
	"sync/atomic"

	tfdiag "github.com/hashicorp/terraform-plugin-sdk/v2/diag"
	tfschema "github.com/hashicorp/terraform-plugin-sdk/v2/helper/schema"
	pftfbridge "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/pf/tfbridge"
	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	shim "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfshim"
	shimv2 "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfshim/sdk-v2"
	"github.com/pulumi/pulumi/pkg/v3/codegen/schema"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"

	"github.com/pulumi/pulumi-aws/provider/v7/pkg/version"
)

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
func ProviderFromMeta(metaInfo *tfbridge.MetadataInfo) *tfbridge.ProviderInfo { //nolint:revive
	return providerFromMeta(metaInfo, embeddedAWSResourceMetadata)
}

// ProviderFromMetaForTfgen builds provider metadata using live schema facts while tfgen updates
// generated metadata. Runtime provider construction must use ProviderFromMeta so it reads the
// embedded metadata file and avoids eager schema inspection.
func ProviderFromMetaForTfgen(metaInfo *tfbridge.MetadataInfo) *tfbridge.ProviderInfo {
	return providerFromMeta(metaInfo, schemaAWSResourceMetadata)
}

// aws_ecr_credentials was a resource that existing in v6 as an upstream patch.
// we removed the patch in v7, but we are adding back the resource as a shim/proxy to
// the newer official aws_ecr_authorization_token resource
func addLegacyECRCredentialsDataSource(up *tfschema.Provider) {
	source, ok := up.DataSourcesMap["aws_ecr_authorization_token"]
	contract.Assertf(ok, "aws_ecr_authorization_token data source not found")

	legacy := *source
	read := legacy.ReadWithoutTimeout
	contract.Assertf(read != nil, "aws_ecr_authorization_token has no read function")

	legacy.ReadWithoutTimeout = func(
		ctx context.Context,
		d *tfschema.ResourceData,
		meta any,
	) tfdiag.Diagnostics {
		// in v6 this resource set id equal to the registry_id. The aws_ecr_authorization_token resource in v7
		// sets it equal to the region. This maintains complete backwards compatibility
		diags := read(ctx, d, meta)
		if !diags.HasError() {
			d.SetId(d.Get("registry_id").(string))
		}
		return diags
	}

	up.DataSourcesMap["aws_ecr_credentials"] = &legacy
}

func providerFromMeta(
	metaInfo *tfbridge.MetadataInfo,
	resourceMetadata awsResourceMetadataLookup,
) *tfbridge.ProviderInfo {
	ctx := context.Background()
	upstreamProvider := newUpstreamProvider(ctx)

	up := upstreamProvider.SDKV2Provider
	// TODO[pulumi/pulumi-aws#5533] required for the v6-beta
	up.TerraformVersion = "1.0.0+compatible"
	addLegacyECRCredentialsDataSource(up)
	v2p := shimv2.NewProvider(up)

	p := pftfbridge.MuxShimWithDisjointgPF(ctx, v2p, upstreamProvider.PluginFrameworkProvider)

	// We should only run the validation once to avoid duplicating the reported errors.
	var credentialsValidationRun atomic.Bool

	prov := tfbridge.ProviderInfo{
		P:                p,
		Name:             "aws",
		DisplayName:      "AWS",
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
		SchemaPostProcessor: func(spec *schema.PackageSpec) {
			postProcessOverlays(spec)
		},

		Config: map[string]*tfbridge.SchemaInfo{
			"region": {
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
			},
			"access_key": {
				Secret: tfbridge.True(),
			},
			"secret_key": {
				Secret: tfbridge.True(),
			},
			"token": {
				Secret: tfbridge.True(),
			},
		},
		PreConfigureCallback: preConfigureCallback(&credentialsValidationRun),
		Resources:            resourceOverrides(p),
		ExtraResources:       resourceOverlays,
		ExtraTypes:           extraTypes,
		DataSources:          dataSourceOverrides(),
		JavaScript: &tfbridge.JavaScriptInfo{
			Dependencies: map[string]string{
				"mime": "^2.0.0",
			},
			DevDependencies: map[string]string{
				"@types/node": "^10.0.0", // so we can access strongly typed node definitions.
				"@types/mime": "^2.0.0",
			},
			Overlay: &tfbridge.OverlayInfo{
				DestFiles: []string{
					"tags.ts",  // Tags typedef (currently unused but left for compatibility)
					"utils.ts", // Helpers
				},
				Modules: map[string]*tfbridge.OverlayInfo{
					"applicationloadbalancing": {
						DestFiles: []string{
							"ipAddressType.ts",    // Deprecated IpAddressType constants
							"loadBalancerType.ts", // Deprecated LoadBalancerType constants
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
							"instanceType.ts",      // Deprecated InstanceType constants
							"instancePlatform.ts",  // Deprecated InstancePlatform constants
							"placementStrategy.ts", // Deprecated PlacementStrategy constants
							"protocolType.ts",      // Deprecated ProtocolType constants
							"tenancy.ts",           // Deprecated Tenancy constants
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
							"documents.ts",  // policy document schemas.
							"principals.ts", // Pre-defined objects representing Service Principals
						},
					},
					"kinesis": {
						DestFiles: []string{
							"kinesisMixins.ts",
						},
					},
					"lambda": {
						DestFiles: []string{
							"lambdaMixins.ts",
							"runtimes.ts",
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
							"recordType.ts", // Deprecated RecordType constants
						},
					},
					"s3": {
						DestFiles: []string{
							"cannedAcl.ts", // Deprecated CannedAcl constants
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
			RespectSchemaVersion: true,
		},
		Python: &tfbridge.PythonInfo{
			RespectSchemaVersion: true,
			PyProject:            struct{ Enabled bool }{true},
			InputTypes:           tfbridge.PythonInputTypeClassesAndDicts,
		},
		Golang: &tfbridge.GolangInfo{
			ImportBasePath: filepath.Join(
				fmt.Sprintf("github.com/pulumi/pulumi-%[1]s/sdk/", awsPkg),
				tfbridge.GetModuleMajorVersion(version.Version),
				"go",
				awsPkg,
			),
			GenerateResourceContainerTypes: true,
			RespectSchemaVersion:           true,
		},
		CSharp: &tfbridge.CSharpInfo{
			RespectSchemaVersion: true,
			PackageReferences: map[string]string{
				"Pulumi": "3.*",
			},
			Namespaces: namespaceMap,
		},
		EnableAccurateBridgePreview: true,
		EnableRawStateDelta:         true,
	}

	applyLegacyResourceAliases(&prov)

	// Add a CSharp-specific override for aws_s3_bucket.bucket.
	prov.Resources["aws_s3_bucket"].Fields["bucket"].CSharpName = "BucketName"

	prov.MustComputeTokens(awsTokenStrategy(&prov))

	// Runtime uses generated metadata here to avoid schema inspection. During tfgen, the same
	// provider wiring uses live schema metadata so callback/autonaming decisions and the refreshed
	// generated file are based on the same upstream provider.
	prov.P.ResourcesMap().Range(func(key string, res shim.Resource) bool {
		if _, ok := prov.Resources[key]; ok {
			metadata := resourceMetadata(prov.P, key, res)

			if metadata.HasUsableRegion {
				applyRegionPreCheckCallback(prov, key)
			}

			if _, isSDKV2 := up.ResourcesMap[key]; isSDKV2 && metadata.HasTagsAndTagsAll {
				applyTagsPreCheckCallback(prov, key)
			}
		}

		return true
	})

	applyCompatibilityOverrides(&prov)

	setAutonaming(&prov, resourceMetadata)

	prov.MustApplyAutoAliases()

	setupComputedIDs(&prov)

	return &prov
}
