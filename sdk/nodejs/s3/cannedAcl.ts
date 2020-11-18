// Copyright 2016-2018, Pulumi Corporation.
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

// This file contains individual constants for each canned ACL type.
//
// These constants will not be updated with new values.
// It is recommended to use CannedAcl.[Value] instead.

import {CannedAcl} from ".";

/** Use CannedAcl.Private instead. */
export let PrivateAcl:                CannedAcl = "private";
/** Use CannedAcl.PublicRead instead. */
export let PublicReadAcl:             CannedAcl = "public-read";
/** Use CannedAcl.PublicReadWrite instead. */
export let PublicReadWriteAcl:        CannedAcl = "public-read-write";
/** Use CannedAcl.AwsExecRead instead. */
export let AwsExecReadAcl:            CannedAcl = "aws-exec-read";
/** Use CannedAcl.AuthenticatedRead instead. */
export let AuthenticatedReadAcl:      CannedAcl = "authenticated-read";
/** Use CannedAcl.BucketOwnerRead instead. */
export let BucketOwnerReadAcl:        CannedAcl = "bucket-owner-read";
/** Use CannedAcl.BucketOwnerFullControl instead. */
export let BucketOwnerFullControlAcl: CannedAcl = "bucket-owner-full-control";
/** Use CannedAcl.LogDeliveryWrite instead. */
export let LogDeliveryWriteAcl:       CannedAcl = "log-delivery-write";
