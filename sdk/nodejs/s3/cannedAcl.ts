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

// This file contains two categories of exports:
//
//     1) A union type, CannedAcl, that accepts any valid canned ACL type
//     2) Individual constants for each such canned ACL type
//
// These give a better developer experience and are just sugared strings.

import {CannedAcl} from ".";

/** @deprecated Use CannedAcl.Private instead. */
export let PrivateAcl:                CannedAcl = "private";
/** @deprecated Use CannedAcl.PublicRead instead. */
export let PublicReadAcl:             CannedAcl = "public-read";
/** @deprecated Use CannedAcl.PublicReadWrite instead. */
export let PublicReadWriteAcl:        CannedAcl = "public-read-write";
/** @deprecated Use CannedAcl.AwsExecRead instead. */
export let AwsExecReadAcl:            CannedAcl = "aws-exec-read";
/** @deprecated Use CannedAcl.AuthenticatedRead instead. */
export let AuthenticatedReadAcl:      CannedAcl = "authenticated-read";
/** @deprecated Use CannedAcl.BucketOwnerRead instead. */
export let BucketOwnerReadAcl:        CannedAcl = "bucket-owner-read";
/** @deprecated Use CannedAcl.BucketOwnerFullControl instead. */
export let BucketOwnerFullControlAcl: CannedAcl = "bucket-owner-full-control";
/** @deprecated Use CannedAcl.LogDeliveryWrite instead. */
export let LogDeliveryWriteAcl:       CannedAcl = "log-delivery-write";
