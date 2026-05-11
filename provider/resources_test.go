package provider

import (
	"context"
	"strings"
	"testing"

	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	"github.com/stretchr/testify/assert"

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
		actual := hasNonComputedTagsAndTagsAllOptimized(key, value)
		expected := hasNonComputedTagsAndTagsAll(key, value)
		assert.Equal(t, expected, actual, "%q", key)
		return true
	})
	ctx := context.Background()
	upstreamProvider := newUpstreamProvider(ctx)
	for rn, r := range upstreamProvider.SDKV2Provider.ResourcesMap {
		if r.SchemaFunc != nil {
			res, ok := p.P.ResourcesMap().GetOk(rn)
			if ok {
				v := hasNonComputedTagsAndTagsAll(rn, res)
				t.Logf("Should cache %v: %s", v, rn)
			}
		}
	}
}

func TestHasOptionalOrRequiredNamePropertyOptimized(t *testing.T) {
	t.Parallel()

	p := Provider()
	p.P.ResourcesMap().Range(func(key string, _ shim.Resource) bool {
		actual := hasOptionalOrRequiredNameProperty(p.P, key)
		expected := hasOptionalOrRequiredNamePropertyOptimized(p.P, key)
		assert.Equal(t, expected, actual, "%q", key)
		return true
	})
	ctx := context.Background()
	upstreamProvider := newUpstreamProvider(ctx)
	for rn, r := range upstreamProvider.SDKV2Provider.ResourcesMap {
		if r.SchemaFunc != nil {
			v := hasOptionalOrRequiredNameProperty(p.P, rn)
			t.Logf("Should cache %v: %s", v, rn)
		}
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
