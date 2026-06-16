package provider

import (
	"context"
	"regexp"
	"strings"
	"testing"

	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge/info"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"

	shim "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfshim"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
)

func Test_parseAssumeRoles(t *testing.T) {
	t.Parallel()

	t.Run("parses correctly", func(t *testing.T) {
		vars := resource.PropertyMap{
			"assumeRoles": resource.NewArrayProperty([]resource.PropertyValue{
				resource.NewObjectProperty(resource.PropertyMap{
					"roleArn": resource.NewStringProperty("arn:aws:iam::12345678912:root"),
				}),
			}),
		}

		res, err := parseAssumeRoles(vars)
		assert.NoError(t, err)
		assert.Equal(t, 1, len(res))
		assert.Equal(t, "arn:aws:iam::12345678912:root", res[0].RoleARN)
	})

	t.Run("handles incorrect type", func(t *testing.T) {
		vars := resource.PropertyMap{
			"assumeRoles": resource.NewObjectProperty(resource.PropertyMap{
				"roleArn": resource.NewStringProperty("arn:aws:iam::12345678912:root"),
			}),
		}

		_, err := parseAssumeRoles(vars)
		assert.ErrorContains(t, err, "expected aws:assumeRoles to be an array, got object")
	})

	t.Run("rejects legacy singular config key", func(t *testing.T) {
		vars := resource.PropertyMap{
			"assumeRole": resource.NewObjectProperty(resource.PropertyMap{
				"roleArn": resource.NewStringProperty("arn:aws:iam::12345678912:root"),
			}),
		}

		_, err := parseAssumeRoles(vars)
		assert.ErrorContains(t, err, "invalid config key 'aws:assumeRole', should be 'aws:assumeRoles'")
	})
}

func TestParseDuration(t *testing.T) {
	t.Parallel()

	for _, v := range []string{
		"1",
		"60",
		"3600",
		"86400",
		"1s",
		"60s",
		"3600s",
	} {
		valid := resource.PropertyMap{
			"durationSeconds": resource.NewStringProperty(v),
		}
		d, err := durationFromConfig(valid, "durationSeconds")
		assert.NoError(t, err)
		assert.NotNil(t, d)
	}
}

func TestHasNonComputedTagsAndTagsAllOptimized(t *testing.T) {
	t.Parallel()

	p := Provider()
	p.P.ResourcesMap().Range(func(key string, value shim.Resource) bool {
		actual := awsResourceMetadatas[key].HasTagsAndTagsAll
		expected := hasNonComputedTagsAndTagsAll(key, value)
		assert.Equal(t, expected, actual, "%q", key)
		return true
	})
}

func TestHasOptionalOrRequiredNamePropertyOptimized(t *testing.T) {
	t.Parallel()

	p := Provider()
	p.P.ResourcesMap().Range(func(key string, _ shim.Resource) bool {
		actual := hasOptionalOrRequiredNameProperty(p.P, key)
		expected := awsResourceMetadatas[key].HasInputName
		assert.Equal(t, expected, actual, "%q", key)
		return true
	})
}

func TestHasUsableRegionMetadata(t *testing.T) {
	t.Parallel()

	p := Provider()
	p.P.ResourcesMap().Range(func(key string, value shim.Resource) bool {
		region, ok := value.Schema().GetOk("region")
		expected := ok && region.Deprecated() == ""
		actual := awsResourceMetadatas[key].HasUsableRegion
		assert.Equal(t, expected, actual, "%q", key)
		return true
	})
}

func TestRegionPreCheckCallbackInstalledFromMetadata(t *testing.T) {
	t.Parallel()

	p := Provider()
	key := findProviderResource(t, p, "resource with usable region", func(key string) bool {
		return awsResourceMetadatas[key].HasUsableRegion
	})

	callback := p.Resources[key].PreCheckCallback
	assert.NotNil(t, callback, "%q", key)

	config := resource.PropertyMap{
		"region": resource.NewStringProperty("us-east-1"),
	}
	meta := resource.PropertyMap{
		"region": resource.NewStringProperty("us-west-2"),
	}
	actual, err := callback(context.Background(), config, meta)
	assert.NoError(t, err, "%q", key)
	assert.Equal(t, "us-east-1", actual["region"].StringValue(), "%q", key)
}

func TestTagsPreCheckCallbackAppliesOnlyToSDKV2Resources(t *testing.T) {
	t.Parallel()

	p := Provider()
	upstreamProvider := newUpstreamProvider(context.Background())

	sdkv2Key := findProviderResource(t, p, "SDKv2 resource with tags", func(key string) bool {
		_, isSDKV2 := upstreamProvider.SDKV2Provider.ResourcesMap[key]
		return isSDKV2 && awsResourceMetadatas[key].HasTagsAndTagsAll
	})
	sdkv2Res := p.Resources[sdkv2Key]
	assert.NotNil(t, sdkv2Res.PreCheckCallback, "%q", sdkv2Key)

	tagsAllField := sdkv2Res.GetFields()["tags_all"]
	assert.NotNil(t, tagsAllField, "%q", sdkv2Key)
	assertBoolPtr(t, tagsAllField.MarkAsComputedOnly, true, "%q", sdkv2Key)
	assertBoolPtr(t, tagsAllField.MarkAsOptional, false, "%q", sdkv2Key)

	config := resource.PropertyMap{
		"tags": resource.NewObjectProperty(resource.PropertyMap{
			"explicit": resource.NewStringProperty("from-resource"),
			"shared":   resource.NewStringProperty("from-resource"),
		}),
	}
	meta := resource.PropertyMap{
		"defaultTags": resource.NewObjectProperty(resource.PropertyMap{
			"tags": resource.NewObjectProperty(resource.PropertyMap{
				"default": resource.NewStringProperty("from-default"),
				"shared":  resource.NewStringProperty("from-default"),
			}),
		}),
	}
	actual, err := sdkv2Res.PreCheckCallback(context.Background(), config, meta)
	assert.NoError(t, err, "%q", sdkv2Key)
	tagsAll := actual["tagsAll"]
	assert.True(t, tagsAll.IsObject(), "%q", sdkv2Key)
	assert.Equal(t, "from-default", tagsAll.ObjectValue()["default"].StringValue(), "%q", sdkv2Key)
	assert.Equal(t, "from-resource", tagsAll.ObjectValue()["explicit"].StringValue(), "%q", sdkv2Key)
	assert.Equal(t, "from-resource", tagsAll.ObjectValue()["shared"].StringValue(), "%q", sdkv2Key)

	pfKey := findProviderResource(t, p, "PF resource with tags", func(key string) bool {
		_, isSDKV2 := upstreamProvider.SDKV2Provider.ResourcesMap[key]
		return !isSDKV2 && awsResourceMetadatas[key].HasTagsAndTagsAll
	})
	pfRes := p.Resources[pfKey]
	if fields := pfRes.GetFields(); fields != nil {
		if tagsAllField := fields["tags_all"]; tagsAllField != nil && tagsAllField.MarkAsComputedOnly != nil {
			assert.False(t, *tagsAllField.MarkAsComputedOnly, "%q", pfKey)
		}
	}
	if pfRes.PreCheckCallback != nil {
		actual, err := pfRes.PreCheckCallback(context.Background(), config, meta)
		assert.NoError(t, err, "%q", pfKey)
		assert.False(t, actual["tagsAll"].IsObject(), "%q", pfKey)
	}
}

func TestSetAutonamingAddsGenericNameWithoutOverwritingFields(t *testing.T) {
	t.Parallel()

	explicitNameField := &tfbridge.SchemaInfo{}
	p := &tfbridge.ProviderInfo{
		Resources: map[string]*tfbridge.ResourceInfo{
			"aws_needs_name": {},
			"aws_has_name": {
				Fields: map[string]*tfbridge.SchemaInfo{
					nameProperty: explicitNameField,
				},
			},
			"aws_no_name": {},
		},
	}

	setAutonaming(p, func(_ shim.Provider, key string, _ shim.Resource) awsResourceMetadata {
		return awsResourceMetadata{HasInputName: key != "aws_no_name"}
	})

	assert.NotNil(t, p.Resources["aws_needs_name"].Fields[nameProperty].Default)
	assert.Same(t, explicitNameField, p.Resources["aws_has_name"].Fields[nameProperty])
	assert.Nil(t, p.Resources["aws_no_name"].Fields)
}

func findProviderResource(
	t *testing.T,
	p *tfbridge.ProviderInfo,
	description string,
	predicate func(string) bool,
) string {
	t.Helper()

	for key := range p.Resources {
		if predicate(key) {
			return key
		}
	}
	t.Fatalf("could not find %s", description)
	return ""
}

func assertBoolPtr(t *testing.T, actual *bool, expected bool, msgAndArgs ...interface{}) {
	t.Helper()

	if assert.NotNil(t, actual, msgAndArgs...) {
		assert.Equal(t, expected, *actual, msgAndArgs...)
	}
}

func TestCustomAutoNameTransforms(t *testing.T) {
	t.Parallel()

	tests := []struct {
		name       string
		resource   string
		properties resource.PropertyMap
		urnName    string
		prefix     string
		suffix     string
	}{
		{
			name:     "SQS FIFO queue name ends with fifo suffix",
			resource: "aws_sqs_queue",
			properties: resource.PropertyMap{
				"fifoQueue": resource.NewBoolProperty(true),
			},
			urnName: "queue",
			prefix:  "queue-",
			suffix:  ".fifo",
		},
		{
			name:     "SQS standard queue name omits fifo suffix",
			resource: "aws_sqs_queue",
			properties: resource.PropertyMap{
				"fifoQueue": resource.NewBoolProperty(false),
			},
			urnName: "queue",
			prefix:  "queue-",
		},
		{
			name:     "KMS alias name has required alias prefix",
			resource: "aws_kms_alias",
			urnName:  "key",
			prefix:   "alias/key-",
		},
	}

	for _, tt := range tests {
		tt := tt
		t.Run(tt.name, func(t *testing.T) {
			t.Parallel()

			field := Provider().Resources[tt.resource].Fields["name"]
			actual, err := field.Default.ComputeDefault(context.Background(), tfbridge.ComputeDefaultOptions{
				URN:        resource.NewURN("stack", "project", "", "aws:index/resource:Resource", tt.urnName),
				Properties: tt.properties,
				Seed:       []byte("test-seed"),
			})
			assert.NoError(t, err)

			name, ok := actual.(string)
			assert.True(t, ok)
			assert.Truef(t, strings.HasPrefix(name, tt.prefix), "expected %q to have prefix %q", name, tt.prefix)
			if tt.suffix != "" {
				assert.Truef(t, strings.HasSuffix(name, tt.suffix), "expected %q to have suffix %q", name, tt.suffix)
			} else {
				assert.Falsef(t, strings.HasSuffix(name, ".fifo"), "expected %q to omit .fifo suffix", name)
			}
		})
	}
}

func TestRdsInstanceIdentifierAutonaming(t *testing.T) {
	t.Parallel()

	field := Provider().Resources["aws_db_instance"].Fields["identifier"]
	require.NotNil(t, field.Default)
	assert.True(t, field.Default.AutoNamed)
	require.NotNil(t, field.Default.ComputeDefault)

	tests := []struct {
		name        string
		opts        tfbridge.ComputeDefaultOptions
		want        string
		wantPattern *regexp.Regexp
		wantErr     string
	}{
		{
			name: "default keeps legacy name shape",
			opts: rdsIdentifierDefaultOptions("rds", resource.PropertyMap{}),
			wantPattern: regexp.MustCompile(
				`^rds[0-9a-f]{7}$`),
		},
		{
			name: "propose uses configured name",
			opts: withRdsIdentifierAutonaming(
				rdsIdentifierDefaultOptions("rds", resource.PropertyMap{}),
				"dev-rds", info.ComputeDefaultAutonamingModePropose),
			want: "dev-rds",
		},
		{
			name: "enforce uses exact configured name",
			opts: withRdsIdentifierAutonaming(
				rdsIdentifierDefaultOptions("rds", resource.PropertyMap{}),
				"Dev_RDS", info.ComputeDefaultAutonamingModeEnforce),
			want: "Dev_RDS",
		},
		{
			name: "disable errors when identifier is absent",
			opts: withRdsIdentifierAutonaming(
				rdsIdentifierDefaultOptions("rds", resource.PropertyMap{}),
				"dev-rds", info.ComputeDefaultAutonamingModeDisable),
			wantErr: "automatic naming is disabled",
		},
		{
			name: "sqlserver default preserves shorter legacy suffix",
			opts: rdsIdentifierDefaultOptions("sqlserver-db", resource.PropertyMap{
				"engine": resource.NewStringProperty("sqlserver-ex"),
			}),
			wantPattern: regexp.MustCompile(
				`^sqlserver-db[0-9a-f]{3}$`),
		},
		{
			name: "prior state reuses existing identifier",
			opts: withRdsIdentifierAutonaming(
				withRdsIdentifierPriorValue(
					rdsIdentifierDefaultOptions("rds", resource.PropertyMap{}), "existing-rds"),
				"dev-rds", info.ComputeDefaultAutonamingModePropose),
			want: "existing-rds",
		},
	}

	for _, tt := range tests {
		tt := tt
		t.Run(tt.name, func(t *testing.T) {
			t.Parallel()

			actual, err := field.Default.ComputeDefault(context.Background(), tt.opts)
			if tt.wantErr != "" {
				require.ErrorContains(t, err, tt.wantErr)
				return
			}
			require.NoError(t, err)
			name, ok := actual.(string)
			require.Truef(t, ok, "expected string result, got %T", actual)
			if tt.want != "" {
				assert.Equal(t, tt.want, name)
			}
			if tt.wantPattern != nil {
				assert.Regexp(t, tt.wantPattern, name)
			}
		})
	}
}

func rdsIdentifierDefaultOptions(
	urnName string, properties resource.PropertyMap,
) tfbridge.ComputeDefaultOptions {
	return tfbridge.ComputeDefaultOptions{
		URN:        resource.NewURN("stack", "project", "", "aws:index/resource:Resource", urnName),
		Properties: properties,
		Seed:       []byte("test-seed"),
	}
}

func withRdsIdentifierAutonaming(
	opts tfbridge.ComputeDefaultOptions,
	proposedName string, mode info.ComputeDefaultAutonamingOptionsMode,
) tfbridge.ComputeDefaultOptions {
	opts.Autonaming = &info.ComputeDefaultAutonamingOptions{
		ProposedName: proposedName,
		Mode:         mode,
	}
	return opts
}

func withRdsIdentifierPriorValue(
	opts tfbridge.ComputeDefaultOptions, value string,
) tfbridge.ComputeDefaultOptions {
	opts.PriorState = resource.PropertyMap{
		"identifier": resource.NewStringProperty(value),
	}
	opts.PriorValue = resource.NewStringProperty(value)
	return opts
}

func TestExtractTags(t *testing.T) {
	t.Parallel()

	tests := []struct {
		name     string
		vars     resource.PropertyMap
		prop     resource.PropertyKey
		expected map[string]string
	}{
		{
			name: "valid tags",
			vars: resource.PropertyMap{
				"tags": resource.NewObjectProperty(resource.PropertyMap{
					"Name": resource.NewStringProperty("example"),
					"Env":  resource.NewStringProperty("production"),
				}),
			},
			prop: "tags",
			expected: map[string]string{
				"Name": "example",
				"Env":  "production",
			},
		},
		{
			name: "no tags",
			vars: resource.PropertyMap{
				"tags": resource.NewObjectProperty(resource.PropertyMap{}),
			},
			prop:     "tags",
			expected: map[string]string{},
		},
		{
			name: "non-string tags",
			vars: resource.PropertyMap{
				"tags": resource.NewObjectProperty(resource.PropertyMap{
					"Name":  resource.NewStringProperty("example"),
					"Count": resource.NewNumberProperty(1),
				}),
			},
			prop: "tags",
			expected: map[string]string{
				"Name": "example",
			},
		},
		{
			name:     "missing tags property",
			vars:     resource.PropertyMap{},
			prop:     "tags",
			expected: nil,
		},
		{
			name: "tags property is not an object",
			vars: resource.PropertyMap{
				"tags": resource.NewStringProperty("not-an-object"),
			},
			prop:     "tags",
			expected: nil,
		},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			actual := extractTags(tt.vars, tt.prop)
			assert.Equal(t, tt.expected, actual)
		})
	}
}
