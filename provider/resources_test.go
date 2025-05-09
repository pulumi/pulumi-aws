package provider

import (
	"context"
	"testing"

	shim "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfshim"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
	"github.com/stretchr/testify/assert"
)

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
	p.P.ResourcesMap().Range(func(key string, value shim.Resource) bool {
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
