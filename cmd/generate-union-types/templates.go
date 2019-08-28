package main

const ec2InstanceTypeTemplate = `// Copyright 2016-2018, Pulumi Corporation.
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
//     1) A union type, InstanceType, that accepts any valid EC2 instance type.
//     2) Individual constants for each such EC2 instance type.
//
// These just give a better developer experience and are just sugared strings.

/* tslint:disable:max-line-length ordered-imports variable-name */

export module InstanceTypes {
    {{ range $i, $v := . }}
    export const {{$v | formatInstanceType}}: InstanceType = "{{$v}}";
    {{- end}}
}

export type InstanceType =
	{{- $size := len . -}}
	{{- range $i, $v := . }}
	"{{$v}}" {{if IsLast $i $size}};{{else}}|{{end}}{{end}}
`

const ec2RegionTemplate = `// Copyright 2016-2018, Pulumi Corporation.
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

/* tslint:disable:max-line-length ordered-imports variable-name */
{{ range $i, $v := . }}
export let {{$v | formatRegionName}}: Region = "{{$v}}";
{{- end}}

export type Region =
	{{- $size := len . -}}
	{{- range $i, $v := . }}
	"{{$v}}" {{if IsLast $i $size}};{{else}}|{{end}}{{end}}
`
