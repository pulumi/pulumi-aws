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

	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
	"github.com/stretchr/testify/require"
	"pgregory.net/rapid"
)

func TestApplyTags(t *testing.T) {
	ctx := context.Background()

	type gen = *rapid.Generator[resource.PropertyValue]
	type pk = resource.PropertyKey
	type pv = resource.PropertyValue

	maybeNullSecretOutputComputed := func(x gen) gen {
		return rapid.OneOf(
			//rapid.Just(resource.NewNullProperty()),
			x,
			//rapid.Map(x, resource.MakeSecret),
			//rapid.Map(x, resource.MakeComputed),
			//rapid.Map(x, resource.MakeOutput),
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

	defaultConfig := maybeNullSecretOutputComputed(rapid.Map(keyValueTags, func(tags pv) pv {
		return resource.NewObjectProperty(resource.PropertyMap{
			"tags": tags,
		})
	}))

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

	meta := rapid.Custom[pv](func(t *rapid.T) pv {
		i := ignoreConfig.Draw(t, "ignoreConfig")
		d := defaultConfig.Draw(t, "defaultConfig")
		m := resource.PropertyMap{}
		if !i.IsNull() {
			m["ignoreConfig"] = i
		}
		if !d.IsNull() {
			m["defaultConfig"] = d
		}
		return resource.NewObjectProperty(m)
	})

	type args struct {
		meta   resource.PropertyValue
		config resource.PropertyValue
	}

	argsGen := rapid.Custom[args](func(t *rapid.T) args {
		m := meta.Draw(t, "meta")
		c := defaultConfig.Draw(t, "config")
		return args{meta: m, config: c}
	})

	rapid.Check(t, func(t *rapid.T) {

		args := argsGen.Draw(t, "args")

		_, err := applyTags(ctx, args.config.ObjectValue(), args.meta.ObjectValue())
		require.NoError(t, err)
	})
}

// type generator struct {
// }

// func (*generator) Generate() []resource.PropertyValue {
// 	return nil
// }

// func stringMapGenerator(value *generator) *generator {
// 	return nil
// }

// func objectGenerator(valueGenerators map[string]*generator, required []string) *generator {
// 	return nil
// }
