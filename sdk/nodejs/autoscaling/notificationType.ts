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

// This file contains individual constants for each autoscaling Notification type.
//
// These constants will not be updated with new values.
// It is recommended to use NotificationType.[Value] instead.

import {NotificationType} from ".";

/** Use NotificationType.InstanceLaunch instead. */
export let InstanceLaunchNotification:         NotificationType = "autoscaling:EC2_INSTANCE_LAUNCH";
/** Use NotificationType.InstanceTerminate instead. */
export let InstanceTerminateNotification:      NotificationType = "autoscaling:EC2_INSTANCE_TERMINATE";
/** Use NotificationType.InstanceLaunchError instead. */
export let InstanceLaunchErrorNotification:    NotificationType = "autoscaling:EC2_INSTANCE_LAUNCH_ERROR";
/** Use NotificationType.InstanceTerminateError instead. */
export let InstanceTerminateErrorNotification: NotificationType = "autoscaling:EC2_INSTANCE_TERMINATE_ERROR";
/** Use NotificationType.TestNotification instead. */
export let TestNotification:                   NotificationType = "autoscaling:TEST_NOTIFICATION";
