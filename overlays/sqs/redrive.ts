// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

// This file defines schema for SQS redrive policies:
// http://docs.aws.amazon.com/AWSSimpleQueueService/latest/APIReference/API_CreateQueue.html#API_CreateQueue_RequestParameters

import { ARN } from "../arn";

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
    deadLetterTargetArn: ARN;
    /**
     * The number of times a message is delivered to the source queue before being moved to the dead-letter queue.
     *
     * Note: The dead-letter queue of a FIFO queue must also be a FIFO queue. Similarly, the dead-letter queue of a
     * standard queue must also be a standard queue.
     */
    maxReceiveCount: number;
}

