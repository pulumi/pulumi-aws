// Copyright 2016-2024, Pulumi Corporation.
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

package batch

import (
	"context"
	"fmt"

	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge/info"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
	"github.com/pulumi/pulumi/sdk/v3/go/common/tokens"
)

func ComputeEnvironment(token tokens.Type, logProvider func(context.Context) tfbridge.Logger) *info.Resource {
	return &info.Resource{
		Tok: token,
		TransformFromState: func(ctx context.Context, pm resource.PropertyMap) (resource.PropertyMap, error) {
			// computeResources.ec2Configurations should be a list
			// older versions of the provider like 5.42.0 used to write it out as an object
			r := pm.Copy()
			cr, ok := r["computeResources"]
			if !ok || !cr.IsObject() {
				return pm, nil
			}
			ec2c, ok := cr.ObjectValue()["ec2Configuration"]
			if !ok || !ec2c.IsObject() {
				return pm, nil
			}
			replacement := resource.NewArrayProperty([]resource.PropertyValue{ec2c})
			logProvider(ctx).Debug(fmt.Sprintf(
				"batch.ComputeEnvironment is wrapping old computeResources.ec2Configurations state in an array"))
			cr.ObjectValue()["ec2Configuration"] = replacement
			r["computeResources"] = cr
			return r, nil
		},
	}
}
