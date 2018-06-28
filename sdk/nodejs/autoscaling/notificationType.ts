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
//     1) A union type, NotificationType, that accepts any valid AutoScaling Notification type
//     2) Individual constants for each such AutoScaling Notification type
//
// These give a better developer experience and are just sugared strings.

export let InstanceLaunchNotification:         NotificationType = "autoscaling:EC2_INSTANCE_LAUNCH";
export let InstanceTerminateNotification:      NotificationType = "autoscaling:EC2_INSTANCE_TERMINATE";
export let InstanceLaunchErrorNotification:    NotificationType = "autoscaling:EC2_INSTANCE_LAUNCH_ERROR";
export let InstanceTerminateErrorNotification: NotificationType = "autoscaling:EC2_INSTANCE_TERMINATE_ERROR";
export let TestNotification:                   NotificationType = "autoscaling:TEST_NOTIFICATION";

// See https://docs.aws.amazon.com/autoscaling/ec2/APIReference/API_NotificationConfiguration.html
export type NotificationType =
    "autoscaling:EC2_INSTANCE_LAUNCH" |
    "autoscaling:EC2_INSTANCE_TERMINATE" |
    "autoscaling:EC2_INSTANCE_LAUNCH_ERROR" |
    "autoscaling:EC2_INSTANCE_TERMINATE_ERROR" |
    "autoscaling:TEST_NOTIFICATION"
