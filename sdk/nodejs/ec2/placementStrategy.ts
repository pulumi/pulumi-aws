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
//     1) A union type, PlacementStrategy, that accepts any valid Placement Strategy type
//     2) Individual constants for each such Placement Strategy type
//
// These give a better developer experience and are just sugared strings.

/**
 *  A `spread` placement group places instances on distinct hardware.
 */
export let SpreadStrategy: PlacementStrategy = "spread";

/**
 * A `cluster` placement group is a logical grouping of instances within a single 
 * Availability Zone that benefit from low network latency, high network throughput.
 */
export let ClusterStrategy: PlacementStrategy = "cluster";

/**
 * The strategy of the placement group determines how the instances are organized
 * within the group.
 *
 * See https://docs.aws.amazon.com/cli/latest/reference/ec2/create-placement-group.html
 */
export type PlacementStrategy =
    "spread" |
    "cluster";
