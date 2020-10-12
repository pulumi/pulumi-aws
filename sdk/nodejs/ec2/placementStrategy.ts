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

// This file contains individual constants for each EC2 Placement strategy.
//
// These constants will not be updated with new values.
// It is recommended to use PlacementStrategy.[Value] instead.

import {PlacementStrategy} from ".";

/**
 * A `spread` placement group places instances on distinct hardware.
 *
 * Use PlacementStrategy.Spread instead.
 */
export let SpreadStrategy: PlacementStrategy = "spread";

/**
 * A `cluster` placement group is a logical grouping of instances within a single
 * Availability Zone that benefit from low network latency, high network throughput.
 *
 * Use PlacementStrategy.Cluster instead.
 */
export let ClusterStrategy: PlacementStrategy = "cluster";

