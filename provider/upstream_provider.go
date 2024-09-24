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

package provider

import (
	"context"

	awsShim "github.com/hashicorp/terraform-provider-aws/shim"
	"github.com/pulumi/pulumi-aws/provider/v6/pkg/rds"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
)

// Initialize a representation of the upstream provider.
//
// Lightly modifies the upstream provider to fix behavior that did not yet make it upstream.
//
// NOTE that this code runs in two contexts, during schema generation and during provider startup at runtime. The
// runtime startup is somewhat performance sensitive. Therefore any modifications undertaken here should complete
// quickly.
func newUpstreamProvider(ctx context.Context) awsShim.UpstreamProvider {
	upstreamProvider, err := awsShim.NewUpstreamProvider(ctx)
	contract.AssertNoErrorf(err, "NewUpstreamProvider failed to initialize")
	rds.ReconfigureResources(upstreamProvider.SDKV2Provider)
	return upstreamProvider
}
