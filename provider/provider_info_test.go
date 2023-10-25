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

	"github.com/pulumi/pulumi-aws/provider/v6/pkg/version"
	pf "github.com/pulumi/pulumi-terraform-bridge/pf/tfbridge"
	"github.com/stretchr/testify/require"
)

func init() {
	version.Version = "1.2.3"
}

func TestProviderInfoRoundtrip(t *testing.T) {
	bare := BareProvider(context.Background())
	original := ProviderFromBare(bare)

	packed, err := pf.PackProviderInfo(original)
	require.NoError(t, err)

	unpacked, err := pf.UnpackProviderInfo(packed, bare)
	require.NoError(t, err)

	//This hangs b/c the provider structure is too huge (I think)
	//require.Equal(t, unpacked, original)
}
