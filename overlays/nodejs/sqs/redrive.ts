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

// This file defines schema for SQS redrive policies:
// http://docs.aws.amazon.com/AWSSimpleQueueService/latest/APIReference/API_CreateQueue.html#API_CreateQueue_RequestParameters


/**
 * The string that includes the parameters for the dead-letter queue functionality of the source queue. For more
 * information about the redrive policy and dead-letter queues, see Using Amazon SQS Dead-Letter Queues in the Amazon
 * Simple Queue Service Developer Guide:
 * http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-dead-letter-queues.html.
 */
export interface RedrivePolicy {
    /**
     * The Amazon Resource Name (ARN) of the dead-letter queue to which Amazon SQS moves messages after the value of
     * `maxReceiveCount` is exceeded.
     */
    deadLetterTargetArn: string;
    /**
     * The number of times a message is delivered to the source queue before being moved to the dead-letter queue.
     *
     * Note: The dead-letter queue of a FIFO queue must also be a FIFO queue. Similarly, the dead-letter queue of a
     * standard queue must also be a standard queue.
     */
    maxReceiveCount: number;
}

