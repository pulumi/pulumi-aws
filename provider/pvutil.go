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
	"github.com/pulumi/pulumi-terraform-bridge/v3/unstable/propertyvalue"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
)

// Assits building transformations on PropertyValue that do not want to deal with Secret, Computed,
// or Output values.
//
// The usage pattern looks like this:
//
//	composePropertyValue[T](func (c *pvComposer) (resource.PropertyValue, T, error) {
//	      x, _ := c.Simplify(pv1)
//	      y, _ := c.SimplifyPropertyMap(pv2) // etc
//	      return resource.NewArrayProperty([]resource.PropertyValue{x, y}), result, nil
//	})
//
// User code accessing values that passed through Simplify is guaranteed to never observe Secret,
// Computed, or Output values. All the metadata bits about these is floated to top-level and
// re-applied to the value the user code receives out of composePropertyValue.
func composePropertyValue[T any](
	f func(c *pvComposer) (resource.PropertyValue, T, error),
) (resource.PropertyValue, T, error) {
	c := &pvComposer{}
	v, r, err := f(c)
	fv, err := c.finalize(v, err)
	return fv, r, err
}

type pvComposer struct {
	secret bool
	deps   []resource.URN
}

func (c *pvComposer) Simplify(
	pv resource.PropertyValue,
) (resource.PropertyValue, error) {
	return propertyvalue.TransformErr(c.simplifyOne, pv)
}

func (c *pvComposer) SimplifyPropertyMap(
	pm resource.PropertyMap,
) (resource.PropertyMap, error) {
	res := resource.PropertyMap{}
	for k, v := range pm {
		sv, err := c.Simplify(v)
		if err != nil {
			return nil, err
		}
		res[k] = sv
	}
	return res, nil
}

func (c *pvComposer) simplifyOne(
	pv resource.PropertyValue,
) (resource.PropertyValue, error) {
	for {
		switch {
		case pv.IsSecret():
			pv = pv.SecretValue().Element
			c.secret = true
		case pv.IsComputed():
			return resource.PropertyValue{}, &foundUnknownError{}
		case pv.IsOutput():
			if !pv.OutputValue().Known {
				return resource.PropertyValue{}, &foundUnknownError{}
			}
			ov := pv.OutputValue()
			c.secret = c.secret || ov.Secret
			c.deps = append(c.deps, ov.Dependencies...)
			pv = ov.Element
		default:
			return pv, nil
		}
	}
}

func (c *pvComposer) finalize(
	pv resource.PropertyValue,
	err error,
) (resource.PropertyValue, error) {
	if _, unk := err.(*foundUnknownError); unk {
		return resource.NewOutputProperty(resource.Output{
			Known: false,
		}), nil
	}
	if err != nil {
		return pv, err
	}
	if c.deps != nil || c.secret {
		return resource.NewOutputProperty(resource.Output{
			Element:      pv,
			Known:        true,
			Secret:       c.secret,
			Dependencies: c.deps,
		}), nil
	}
	return pv, nil
}

type foundUnknownError struct{}

func (m *foundUnknownError) Error() string {
	return "foundUnknownError"
}
