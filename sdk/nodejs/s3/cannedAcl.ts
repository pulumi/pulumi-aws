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

export let PrivateAcl:                CannedAcl = "private";
export let PublicReadAcl:             CannedAcl = "public-read";
export let PublicReadWriteAcl:        CannedAcl = "public-read-write";
export let AwsExecReadAcl:            CannedAcl = "aws-exec-read";
export let AuthenticatedReadAcl:      CannedAcl = "authenticated-read";
export let BucketOwnerReadAcl:        CannedAcl = "bucket-owner-read";
export let BucketOwnerFullControlAcl: CannedAcl = "bucket-owner-full-control";
export let LogDeliveryWriteAcl:       CannedAcl = "log-delivery-write";

// See https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html#canned-acl
export type CannedAcl =
    "private" |
    "public-read" |
    "public-read-write" |
    "aws-exec-read" |
    "authenticated-read" |
    "bucket-owner-read" |
    "bucket-owner-full-control" |
    "log-delivery-write"
