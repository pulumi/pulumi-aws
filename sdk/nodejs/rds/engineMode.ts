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

// This file contains individual constants for each RDS Engine mode.
//
// These constants will not be updated with new values.
// It is recommended to use EngineMode.[Value] instead.

import {EngineMode} from ".";

/** Use EngineMode.Provisioned instead. */
export let ProvisionedEngine:   EngineMode = "provisioned";
/** Use EngineMode.Serverless instead. */
export let ServerlessEngine:    EngineMode = "serverless";
/** Use EngineMode.ParallelQuery instead. */
export let ParallelQueryEngine: EngineMode = "parallelquery";
/** Use EngineMode.Global instead. */
export let GlobalEngine:        EngineMode = "global";
