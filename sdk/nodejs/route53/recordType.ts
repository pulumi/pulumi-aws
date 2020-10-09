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

import {RecordType} from ".";

export module RecordTypes {
    /** @deprecated Use RecordType.A instead. */
    export const A:     RecordType = "A";
    /** @deprecated Use RecordType.AAAA instead. */
    export const AAAA:  RecordType = "AAAA";
    /** @deprecated Use RecordType.CNAME instead. */
    export const CNAME: RecordType = "CNAME";
    /** @deprecated Use RecordType.CAA instead. */
    export const CAA:   RecordType = "CAA";
    /** @deprecated Use RecordType.MX instead. */
    export const MX:    RecordType = "MX";
    /** @deprecated Use RecordType.NAPTR instead. */
    export const NAPTR: RecordType = "NAPTR";
    /** @deprecated Use RecordType.NS instead. */
    export const NS:    RecordType = "NS";
    /** @deprecated Use RecordType.PTR instead. */
    export const PTR:   RecordType = "PTR";
    /** @deprecated Use RecordType.SOA instead. */
    export const SOA:   RecordType = "SOA";
    /** @deprecated Use RecordType.SPF instead. */
    export const SPF:   RecordType = "SPF";
    /** @deprecated Use RecordType.SRV instead. */
    export const SRV:   RecordType = "SRV";
    /** @deprecated Use RecordType.TXT instead. */
    export const TXT:   RecordType = "TXT";
}
