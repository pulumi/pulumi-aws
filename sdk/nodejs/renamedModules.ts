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

// Export elasticloadbalancingv2 as elbv2 fo brevity.  But keep around the old module for compat.
// Note: it's easier for us to generate into elasticloadbalancingv2 and then rexport as elbv2 (as
// opposed to the opposite), as this means no urns change and thus need aliases.
export { elasticloadbalancing as elb } from ".";
export { elasticloadbalancingv2 as elbv2 } from ".";
