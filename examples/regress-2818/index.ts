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

// Original repro in https://github.com/pulumi/pulumi-aws/issues/2818
// Unfortunately CI cannot currently test aws.organizations.Account due to lack of permissions.
// The trimmed down repro simply tries to pass an unknown into assumeRole.
// It only works through preview.

import * as pulumi from '@pulumi/pulumi'
import * as aws from '@pulumi/aws'

// Dummy bucket to generate unknowns.
const b = new aws.s3.Bucket('bucket', {});

// Pass an unknown into assumeRole.roleArn.
const provider = new aws.Provider("provider", {
    assumeRole: {roleArn: b.id.apply(_ => "TODO")},
});

// If the bug is active, this fails because `pulumi preview` panics when trying to create the provider.
new aws.s3.Bucket('bucket2', {}, { provider })
