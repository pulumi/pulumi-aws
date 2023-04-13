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

package main

import (
	"context"
	"log"

	aws "github.com/pulumi/pulumi-aws/provider/v5"
	"github.com/pulumi/pulumi-aws/provider/v5/pkg/version"
	pftfbridge "github.com/pulumi/pulumi-terraform-bridge/pf/tfbridge"
	pftfgen "github.com/pulumi/pulumi-terraform-bridge/pf/tfgen"
	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfgen"
	"github.com/pulumi/pulumi-terraform-bridge/v3/unstable/metadata"
)

func main() {
	ctx := context.Background()
	muxed, err := aws.MuxedProvider(ctx)
	if err != nil {
		log.Fatal(err)
	}

	var baselineProvider *tfbridge.ProviderInfo
	var pfProviderOverride *pftfbridge.ProviderInfo

	for _, m := range muxed {
		if m.PF != nil {
			pfProviderOverride = m.PF
		} else if m.SDK != nil {
			baselineProvider = m.SDK
		}
	}

	extensionProvider := pftfgen.SchemaOnlyPluginFrameworkProvider(ctx, pfProviderOverride.NewProvider())

	rExtension := pftfgen.NewResourceExtension(extensionProvider, pfProviderOverride.Resources)
	dExtension := pftfgen.NewDataSourceExtension(extensionProvider, pfProviderOverride.DataSources)

	dispatchTable := pftfgen.ComputeExtendedDispatchTable(0, /*baslineProviderIndex*/
		pftfgen.ExtensionWithIndex{
			Extension:     rExtension,
			ProviderIndex: 1,
		},
		pftfgen.ExtensionWithIndex{
			Extension:     dExtension,
			ProviderIndex: 1,
		},
	)

	extendedInfo, err := pftfgen.Extend(baselineProvider, rExtension, dExtension)
	if err != nil {
		log.Fatal(err)
	}

	if err := metadata.StoreDispatchTable(extendedInfo.GetMetadata(), dispatchTable); err != nil {
		log.Fatal(err)
	}

	tfgen.Main("aws", version.Version, *extendedInfo)
}
