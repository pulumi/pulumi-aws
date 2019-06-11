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

export abstract class RecordTypes {
    public static A:     RecordType = "A";
    public static AAAA:  RecordType = "AAAA";
    public static CNAME: RecordType = "CNAME";
    public static CAA:   RecordType = "CAA";
    public static MX:    RecordType = "MX";
    public static NAPTR: RecordType = "NAPTR";
    public static NS:    RecordType = "NS";
    public static PTR:   RecordType = "PTR";
    public static SOA:   RecordType = "SOA";
    public static SPF:   RecordType = "SPF";
    public static SRV:   RecordType = "SRV";
    public static TXT:   RecordType = "TXT";
}

export type RecordType =
    "A"     |
    "AAAA"  |
    "CNAME" |
    "CAA"   |
    "MX"    |
    "NAPTR" |
    "NS"    |
    "PTR"   |
    "SOA"   |
    "SPF"   |
    "SRV"   |
    "TXT"   ;


