import * as aws from "@pulumi/aws";
import * as pulumi from "@pulumi/pulumi";


// Create an SNS topic with a policy that references the managed policy
const snsTopic = new aws.sns.Topic("test-topic", {
    policy: JSON.stringify({
        Version: "2012-10-17",
        Statement: [{
            Effect: "Allow",
            Principal: {
                Service: "ecs.amazonaws.com"  // This service uses the AmazonEC2ContainerServiceforEC2Role
            },
            Action: "sns:Publish",
            Resource: "*",
            Condition: {
                ArnLike: {
                    "aws:SourceArn": aws.iam.ManagedPolicy.AmazonEC2ContainerServiceforEC2Role
                }
            }
        }],
    }),
});

export const snsTopicArn = snsTopic.arn;