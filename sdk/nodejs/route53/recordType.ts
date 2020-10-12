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

// This file contains individual constants for each Route53 Record Type.
//
// These constants will not be updated with new values.
// It is recommended to use RecordType.[Value] instead.

import {RecordType} from ".";

/** Use RecordType instead. */
export module RecordTypes {
    /** Use RecordType.A instead. */
    export const A:     RecordType = "A";
    /** Use RecordType.AAAA instead. */
    export const AAAA:  RecordType = "AAAA";
    /** Use RecordType.CNAME instead. */
    export const CNAME: RecordType = "CNAME";
    /** Use RecordType.CAA instead. */
    export const CAA:   RecordType = "CAA";
    /** Use RecordType.MX instead. */
    export const MX:    RecordType = "MX";
    /** Use RecordType.NAPTR instead. */
    export const NAPTR: RecordType = "NAPTR";
    /** Use RecordType.NS instead. */
    export const NS:    RecordType = "NS";
    /** Use RecordType.PTR instead. */
    export const PTR:   RecordType = "PTR";
    /** Use RecordType.SOA instead. */
    export const SOA:   RecordType = "SOA";
    /** Use RecordType.SPF instead. */
    export const SPF:   RecordType = "SPF";
    /** Use RecordType.SRV instead. */
    export const SRV:   RecordType = "SRV";
    /** Use RecordType.TXT instead. */
    export const TXT:   RecordType = "TXT";
}
