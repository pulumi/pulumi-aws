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
	"encoding/json"
	"os"
	"strings"
	"testing"

	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
)

// Asserts that the replacements.json file does not include any TODOs.
func TestReplacementDoesNotIncludeTodos(t *testing.T) {
	t.Parallel()

	replacementsJSON, err := os.ReadFile("replacements.json")
	require.NoError(t, err, "Failed to read replacements.json")

	var replacementsFile replacementFile
	err = json.Unmarshal(replacementsJSON, &replacementsFile)
	require.NoError(t, err, "Failed to unmarshal replacements.json")

	for doc, replacements := range replacementsFile {
		for _, replacement := range replacements {
			assert.NotContainsf(t, replacement.New, "TODO", "Replacement value for '%s' contains 'TODO'. Replace the 'TODO' with an appropriate word.", doc)
		}
	}
}

func TestFixUpBucketReplicationConfig_InsertsNotesFromRuleSection(t *testing.T) {
	content := strings.Join([]string{
		"# Resource: aws_s3_bucket_replication_configuration",
		"",
		"## Argument Reference",
		"",
		"* `bucket` - (Required) Name of the source S3 bucket you want Amazon S3 to monitor.",
		"* `rule` - (Required) List of configuration blocks describing the rules managing the replication. [See below](#rule).",
		"* `token` - (Optional) Token to allow replication to be enabled on an Object Lock-enabled bucket.",
		"",
		"### rule",
		"",
		"~> **NOTE:** Replication to multiple destination buckets requires that `priority` is specified in the `rule` object.",
		"",
		"~> **NOTE:** Amazon S3's latest version of the replication configuration is V2, which includes the `filter` attribute for replication rules.",
		"",
		"~> **NOTE:** The `existing_object_replication` parameter is not supported by Amazon S3 at this time.",
		"To replicate existing objects, please refer to the [Replicating existing objects with S3 Batch Replication](https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-batch-replication-batch.html) documentation in the Amazon S3 User Guide.",
		"",
		"The `rule` configuration block supports the following arguments:",
	}, "\n")

	out, err := fixUpBucketReplicationConfig.Edit("s3_bucket_replication_configuration.html.markdown", []byte(content))
	if err != nil {
		t.Fatalf("edit failed: %v", err)
	}

	outStr := string(out)
	noteBlock := extractRuleNotes(out)
	if noteBlock == "" {
		t.Fatal("expected note block to be extracted")
	}

	needle := "* `rule` - (Required) List of configuration blocks describing the rules managing the replication. [See below](#rule).\n\n" + noteBlock
	if !strings.Contains(outStr, needle) {
		t.Fatalf("expected notes inserted after rule argument; missing:\n%s", needle)
	}
}

func TestFixUpBucketReplicationConfig_DoesNotDuplicateInsertedNotes(t *testing.T) {
	noteBlock := strings.Join([]string{
		"~> **NOTE:** Replication to multiple destination buckets requires that `priority` is specified in the `rule` object.",
		"",
		"~> **NOTE:** Amazon S3's latest version of the replication configuration is V2, which includes the `filter` attribute for replication rules.",
		"",
		"~> **NOTE:** The `existing_object_replication` parameter is not supported by Amazon S3 at this time.",
		"To replicate existing objects, please refer to the [Replicating existing objects with S3 Batch Replication](https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-batch-replication-batch.html) documentation in the Amazon S3 User Guide.",
	}, "\n")

	content := strings.Join([]string{
		"## Argument Reference",
		"",
		"* `rule` - (Required) List of configuration blocks describing the rules managing the replication. [See below](#rule).",
		"",
		noteBlock,
		"",
		"### rule",
		"",
		noteBlock,
		"",
		"The `rule` configuration block supports the following arguments:",
	}, "\n")

	out, err := fixUpBucketReplicationConfig.Edit("s3_bucket_replication_configuration.html.markdown", []byte(content))
	if err != nil {
		t.Fatalf("edit failed: %v", err)
	}

	outStr := string(out)
	if strings.Count(outStr, noteBlock) != 2 {
		t.Fatalf("expected exactly two note blocks (arg list + rule section), got %d", strings.Count(outStr, noteBlock))
	}
}
