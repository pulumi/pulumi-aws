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

	"github.com/stretchr/testify/require"
	"pgregory.net/rapid"

	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
)

func TestApplyTags(t *testing.T) {
	ctx := context.Background()

	type gen = *rapid.Generator[resource.PropertyValue]
	type pk = resource.PropertyKey
	type pv = resource.PropertyValue
	type pm = resource.PropertyMap

	maybeNullSecretOutputComputed := func(x gen) gen {
		return rapid.OneOf(
			rapid.Just(resource.NewNullProperty()),
			x,
			rapid.Map(x, resource.MakeSecret),
			rapid.Map(x, resource.MakeComputed),
			rapid.Map(x, resource.MakeOutput),
		)
	}

	str := maybeNullSecretOutputComputed(rapid.OneOf(
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

	keyValueTags := maybeNullSecretOutputComputed(
		rapid.Map(rapid.MapOfN[pk, pv](keys, str, 0, 3), makeObj))

	config := rapid.Map(keyValueTags, func(tags pv) pm {
		return resource.PropertyMap{
			"tags": tags,
		}
	})

	defaultConfig := maybeNullSecretOutputComputed(rapid.Map(config,
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
	}

	for _, tc := range testCases {
		t.Run(tc.name, func(t *testing.T) {
			r, err := applyTags(ctx, tc.config, tc.meta)
			require.NoError(t, err)
			require.Equal(t, tc.expect, r)
		})
	}
}
