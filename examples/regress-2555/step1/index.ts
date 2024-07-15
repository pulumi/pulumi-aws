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

import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

let config = new pulumi.Config();
let step = config.getNumber("step") || 1;

const doc = `
---
schemaVersion: "0.3"
description: Executes a patching event on the instance followed by a healthcheck
parameters:
  InstanceIds:
    type: StringList
    description: The instance to target
mainSteps:
  - name: InvokePatchEvent
    action: aws:runCommand
    inputs:
      DocumentName: AWS-RunPatchBaseline
      InstanceIds: "{{ InstanceIds }}"
      OutputS3BucketName: "{output_s3_bucket_name}"
      OutputS3KeyPrefix: "{STEP}"
      Parameters:
        Operation: Scan
`;

let content = doc.replace("{STEP}", String(step));

// Create the SSM Automation Runbook
const nodeBuildRunbookDoc = new aws.ssm.Document('nodeBuildRunbook-doc', {
    content: content,
    documentType: 'Automation',
    documentFormat: 'YAML',
});

export const docName = nodeBuildRunbookDoc.name;
