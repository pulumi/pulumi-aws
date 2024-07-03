// Copyright 2016-2023, Pulumi Corporation.
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
	"testing"

	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
	"pgregory.net/rapid"

	tfshim "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfshim"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
)

func TestApplyTags(t *testing.T) {
	ctx := context.Background()

	type gen = *rapid.Generator[resource.PropertyValue]
	type pk = resource.PropertyKey
	type pv = resource.PropertyValue
	type pm = resource.PropertyMap

	maybeNullOrUnknown := func(x gen) gen {
		return rapid.OneOf(
			rapid.Just(resource.NewNullProperty()),
			x,
			rapid.Map(x, resource.MakeComputed),
		)
	}

	str := maybeNullOrUnknown(rapid.OneOf(
		rapid.Just(resource.NewStringProperty("")),
		rapid.Just(resource.NewStringProperty("foo")),
		rapid.Just(resource.NewStringProperty("bar")),
	))

	keys := rapid.Map(rapid.OneOf[string](
		rapid.Just(""),
		rapid.Just("a"),
		rapid.Just("b"),
	), func(s string) pk {
		return resource.PropertyKey(s)
	})

	makeObj := func(m map[pk]resource.PropertyValue) resource.PropertyValue {
		return resource.NewObjectProperty(resource.PropertyMap(m))
	}

	keyValueTags := maybeNullOrUnknown(
		rapid.Map(rapid.MapOfN[pk, pv](keys, str, 0, 3), makeObj))

	config := rapid.Map(keyValueTags, func(tags pv) pm {
		return resource.PropertyMap{
			"tags": tags,
		}
	})

	defaultConfig := maybeNullOrUnknown(rapid.Map(config,
		resource.NewObjectProperty))

	ignoreConfig := rapid.Custom[pv](func(t *rapid.T) pv {
		keys := keyValueTags.Draw(t, "keys")
		keyPrefixes := keyValueTags.Draw(t, "keyPrefixes")
		m := resource.PropertyMap{}
		if !keys.IsNull() {
			m["keys"] = keys
		}
		if !keyPrefixes.IsNull() {
			m["keyPrefixes"] = keyPrefixes
		}
		return resource.NewObjectProperty(m)
	})

	meta := rapid.Custom[pm](func(t *rapid.T) pm {
		i := ignoreConfig.Draw(t, "ignoreConfig")
		d := defaultConfig.Draw(t, "defaultConfig")
		m := resource.PropertyMap{}
		if !i.IsNull() {
			m["ignoreConfig"] = i
		}
		if !d.IsNull() {
			m["defaultConfig"] = d
		}
		return m
	})

	type args struct {
		meta   resource.PropertyMap
		config resource.PropertyMap
	}

	argsGen := rapid.Custom[args](func(t *rapid.T) args {
		m := meta.Draw(t, "meta")
		c := config.Draw(t, "config")
		return args{meta: m, config: c}
	})

	t.Run("no panics", func(t *testing.T) {
		rapid.Check(t, func(t *rapid.T) {
			args := argsGen.Draw(t, "args")
			_, err := applyTags(ctx, args.config, args.meta)
			require.NoError(t, err)
		})
	})

	type testCase struct {
		name   string
		config resource.PropertyMap
		meta   resource.PropertyMap
		expect resource.PropertyMap
	}

	testCases := []testCase{
		{
			name: "resource tags propagate",
			config: resource.PropertyMap{
				"tags": resource.NewObjectProperty(resource.PropertyMap{
					"tag1": resource.NewStringProperty("tag1v"),
				}),
			},
			meta: resource.PropertyMap{},
			expect: resource.PropertyMap{
				"tags": resource.NewObjectProperty(resource.PropertyMap{
					"tag1": resource.NewStringProperty("tag1v"),
				}),
			},
		},
		{
			name:   "provier sets a tag",
			config: resource.PropertyMap{},
			meta: resource.PropertyMap{
				"defaultTags": resource.NewObjectProperty(resource.PropertyMap{
					"tags": resource.NewObjectProperty(resource.PropertyMap{
						"tag2": resource.NewStringProperty("tag2v"),
					}),
				}),
			},
			expect: resource.PropertyMap{
				"tags": resource.NewObjectProperty(resource.PropertyMap{
					"tag2": resource.NewStringProperty("tag2v"),
				}),
			},
		},
		{
			name: "provider adds a tag to resource tags",
			config: resource.PropertyMap{
				"tags": resource.NewObjectProperty(resource.PropertyMap{
					"tag1": resource.NewStringProperty("tag1v"),
				}),
			},
			meta: resource.PropertyMap{
				"defaultTags": resource.NewObjectProperty(resource.PropertyMap{
					"tags": resource.NewObjectProperty(resource.PropertyMap{
						"tag2": resource.NewStringProperty("tag2v"),
					}),
				}),
			},
			expect: resource.PropertyMap{
				"tags": resource.NewObjectProperty(resource.PropertyMap{
					"tag1": resource.NewStringProperty("tag1v"),
					"tag2": resource.NewStringProperty("tag2v"),
				}),
			},
		},
		{
			name: "provider cannot change a resource tag",
			config: resource.PropertyMap{
				"tags": resource.NewObjectProperty(resource.PropertyMap{
					"tag1": resource.NewStringProperty("tag1v"),
				}),
			},
			meta: resource.PropertyMap{
				"defaultTags": resource.NewObjectProperty(resource.PropertyMap{
					"tags": resource.NewObjectProperty(resource.PropertyMap{
						"tag1": resource.NewStringProperty("tag2v"),
					}),
				}),
			},
			expect: resource.PropertyMap{
				"tags": resource.NewObjectProperty(resource.PropertyMap{
					"tag1": resource.NewStringProperty("tag1v"),
				}),
			},
		},
		{
			name: "unknowns mark the entire computation unknown",
			config: resource.PropertyMap{
				"tags": resource.NewObjectProperty(resource.PropertyMap{
					"tag1": resource.MakeComputed(resource.PropertyValue{}),
				}),
			},
			expect: resource.PropertyMap{
				"tags": resource.NewOutputProperty(resource.Output{Known: false}),
			},
		},
	}

	for _, tc := range testCases {
		t.Run(tc.name, func(t *testing.T) {
			r, err := applyTags(ctx, tc.config, tc.meta)
			require.NoError(t, err)
			// Expect tagsAll to be copied from tags.
			tc.expect["tagsAll"] = tc.expect["tags"]
			require.Equal(t, tc.expect, r)
		})
	}
}

func TestApplyTagsOutputs(t *testing.T) {
	ctx := context.Background()

	type gen = *rapid.Generator[resource.PropertyValue]
	type pk = resource.PropertyKey
	type pv = resource.PropertyValue
	type pm = resource.PropertyMap

	maybeNullOrUnknown := func(x gen) gen {
		return rapid.OneOf(
			rapid.Just(resource.NewNullProperty()),
			x,
			rapid.Map(x, resource.MakeComputed),
		)
	}

	str := maybeNullOrUnknown(rapid.OneOf(
		rapid.Just(resource.NewStringProperty("")),
		rapid.Just(resource.NewStringProperty("foo")),
		rapid.Just(resource.NewStringProperty("bar")),
	))

	keys := rapid.Map(rapid.OneOf[string](
		rapid.Just(""),
		rapid.Just("a"),
		rapid.Just("b"),
	), func(s string) pk {
		return resource.PropertyKey(s)
	})

	makeObj := func(m map[pk]resource.PropertyValue) resource.PropertyValue {
		return resource.NewObjectProperty(resource.PropertyMap(m))
	}

	keyValueTags := maybeNullOrUnknown(
		rapid.Map(rapid.MapOfN[pk, pv](keys, str, 0, 3), makeObj))

	config := rapid.Map(keyValueTags, func(tags pv) pm {
		return resource.PropertyMap{
			"tags": tags,
		}
	})

	defaultConfig := maybeNullOrUnknown(rapid.Map(config,
		resource.NewObjectProperty))

	ignoreConfig := rapid.Custom[pv](func(t *rapid.T) pv {
		keys := keyValueTags.Draw(t, "keys")
		keyPrefixes := keyValueTags.Draw(t, "keyPrefixes")
		m := resource.PropertyMap{}
		if !keys.IsNull() {
			m["keys"] = keys
		}
		if !keyPrefixes.IsNull() {
			m["keyPrefixes"] = keyPrefixes
		}
		return resource.NewObjectProperty(m)
	})

	meta := rapid.Custom[pm](func(t *rapid.T) pm {
		i := ignoreConfig.Draw(t, "ignoreConfig")
		d := defaultConfig.Draw(t, "defaultConfig")
		m := resource.PropertyMap{}
		if !i.IsNull() {
			m["ignoreConfig"] = i
		}
		if !d.IsNull() {
			m["defaultConfig"] = d
		}
		return m
	})

	type args struct {
		meta   resource.PropertyMap
		config resource.PropertyMap
	}

	argsGen := rapid.Custom[args](func(t *rapid.T) args {
		m := meta.Draw(t, "meta")
		c := config.Draw(t, "config")
		return args{meta: m, config: c}
	})

	t.Run("no panics", func(t *testing.T) {
		rapid.Check(t, func(t *rapid.T) {
			args := argsGen.Draw(t, "args")
			_, err := applyTags(ctx, args.config, args.meta)
			require.NoError(t, err)
		})
	})

	type testCase struct {
		name   string
		config resource.PropertyMap
		expect resource.PropertyMap
	}

	testCases := []testCase{
		{
			name: "resource tags propagate",
			config: resource.PropertyMap{
				"tags": resource.NewObjectProperty(resource.PropertyMap{
					"tag1": resource.NewStringProperty("tag1v"),
				}),
			},
			expect: resource.PropertyMap{
				"tags": resource.NewObjectProperty(resource.PropertyMap{
					"tag1": resource.NewStringProperty("tag1v"),
				}),
			},
		},
		{
			name: "provier sets a tag",
			config: resource.PropertyMap{
				"tagsAll": resource.NewObjectProperty(resource.PropertyMap{
					"tag2": resource.NewStringProperty("tag2v"),
				}),
			},
			expect: resource.PropertyMap{
				"tags": resource.NewObjectProperty(resource.PropertyMap{
					"tag2": resource.NewStringProperty("tag2v"),
				}),
			},
		},
		{
			name: "provider adds a tag to resource tags",
			config: resource.PropertyMap{
				"tags": resource.NewObjectProperty(resource.PropertyMap{
					"tag1": resource.NewStringProperty("tag1v"),
				}),
				"tagsAll": resource.NewObjectProperty(resource.PropertyMap{
					"tag2": resource.NewStringProperty("tag2v"),
				}),
			},
			expect: resource.PropertyMap{
				"tags": resource.NewObjectProperty(resource.PropertyMap{
					"tag1": resource.NewStringProperty("tag1v"),
					"tag2": resource.NewStringProperty("tag2v"),
				}),
			},
		},
		{
			name: "provider cannot change a resource tag",
			config: resource.PropertyMap{
				"tags": resource.NewObjectProperty(resource.PropertyMap{
					"tag1": resource.NewStringProperty("tag1v"),
				}),
				"tagsAll": resource.NewObjectProperty(resource.PropertyMap{
					"tag1": resource.NewStringProperty("tag2v"),
				}),
			},
			expect: resource.PropertyMap{
				"tags": resource.NewObjectProperty(resource.PropertyMap{
					"tag1": resource.NewStringProperty("tag1v"),
				}),
			},
		},
		{
			name: "unknowns mark the entire computation unknown",
			config: resource.PropertyMap{
				"tags": resource.NewObjectProperty(resource.PropertyMap{
					"tag1": resource.MakeComputed(resource.PropertyValue{}),
				}),
			},
			expect: resource.PropertyMap{
				"tags": resource.NewOutputProperty(resource.Output{Known: false}),
			},
		},
	}

	for _, tc := range testCases {
		t.Run(tc.name, func(t *testing.T) {
			r, err := applyTagsOutputs(ctx, tc.config)
			require.NoError(t, err)
			// Expect tagsAll to be copied from tags.
			tc.expect["tagsAll"] = tc.expect["tags"]
			require.Equal(t, tc.expect, r)
		})
	}
}

func TestAddingEmptyTagProducesChangeDiff(t *testing.T) {
	replayEvent := `
	[
	  {
	    "method": "/pulumirpc.ResourceProvider/Diff",
	    "request": {
	      "id": "vpc-4b82e033",
	      "urn": "urn:pulumi:testtags::tags-combinations-go::aws:ec2/defaultVpc:DefaultVpc::go-web-default-vpc",
	      "olds": {
		"__meta": "{\"schema_version\":\"1\"}",
		"arn": "arn:aws:ec2:us-west-2:616138583583:vpc/vpc-4b82e033",
		"assignGeneratedIpv6CidrBlock": false,
		"cidrBlock": "172.31.0.0/16",
		"defaultNetworkAclId": "acl-3b778d40",
		"defaultRouteTableId": "rtb-a05f10db",
		"defaultSecurityGroupId": "sg-4d436f12",
		"dhcpOptionsId": "dopt-1649d26e",
		"enableDnsHostnames": true,
		"enableDnsSupport": true,
		"enableNetworkAddressUsageMetrics": false,
		"existingDefaultVpc": true,
		"forceDestroy": false,
		"id": "vpc-4b82e033",
		"instanceTenancy": "default",
		"ipv6AssociationId": "",
		"ipv6CidrBlock": "",
		"ipv6CidrBlockNetworkBorderGroup": "",
		"ipv6IpamPoolId": "",
		"ipv6NetmaskLength": 0,
		"mainRouteTableId": "rtb-a05f10db",
		"ownerId": "616138583583",
		"tags": {
		  "x": "s"
		},
		"tagsAll": {
		  "x": "s"
		}
	      },
	      "news": {
		"__defaults": [
		  "enableDnsHostnames",
		  "enableDnsSupport",
		  "forceDestroy"
		],
		"enableDnsHostnames": true,
		"enableDnsSupport": true,
		"forceDestroy": false,
		"tags": {
		  "__defaults": [],
		  "x": "s",
		  "y": ""
		},
		"tagsAll": {
		  "__defaults": [],
		  "x": "s",
		  "y": ""
		}
	      },
	      "oldInputs": {
		"__defaults": [
		  "enableDnsHostnames",
		  "enableDnsSupport",
		  "forceDestroy"
		],
		"enableDnsHostnames": true,
		"enableDnsSupport": true,
		"forceDestroy": false,
		"tags": {
		  "__defaults": [],
		  "x": "s"
		},
		"tagsAll": {
		  "__defaults": [],
		  "x": "s"
		}
	      }
	    },
	    "response": {
	      "changes": "DIFF_SOME",
		  "hasDetailedDiff": true,
		  "detailedDiff": {
			"tags": {
			  "kind": "UPDATE"
			},
			"tagsAll": {
			  "kind": "UPDATE"
			}
		  },
		  "diffs": ["*", "*"]
	    }
	  }
	]`

	replaySequence(t, replayEvent)
}

func TestTagsAllNoLongerComputed(t *testing.T) {
	p := Provider().P
	p.ResourcesMap().Range(func(key string, res tfshim.Resource) bool {
		tagsAll, ok := res.Schema().GetOk("tags_all")
		if !ok {
			return true
		}
		assert.Falsef(t, tagsAll.Computed(), "Computed tags_all for resource: %s", key)
		return true
	})
}
