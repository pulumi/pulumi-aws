import * as aws from "@pulumi/aws";

const cert = new aws.iot.Certificate("test-cert", {
    active: true,
});

const iotPolicy = new aws.iot.Policy("test-policy", {
    policy: JSON.stringify({
        Version: "2012-10-17",
        Statement: [{
            Effect: "Allow",
            Action: "iot:Connect",
            Resource: "*"
        }]
    })
});

const policyAttachment = new aws.iot.PolicyAttachment("test-policy-attachment", {
    policy: iotPolicy,
    target: cert.arn
});

export const policyName = iotPolicy.name;