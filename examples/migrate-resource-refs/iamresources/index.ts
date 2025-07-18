import * as aws from "@pulumi/aws";
import * as pulumi from "@pulumi/pulumi";

const user = new aws.iam.User("test-user");

const group = new aws.iam.Group("test-group");

const role = new aws.iam.Role("test-role", {
    assumeRolePolicy: JSON.stringify({
        Version: "2012-10-17",
        Statement: [{
            Action: "sts:AssumeRole",
            Effect: "Allow",
            Principal: {
                Service: "ec2.amazonaws.com",
            },
        }],
    }),
});

// Create an instance profile
const instanceProfile = new aws.iam.InstanceProfile("test-profile", {
    role: role,
});

const policy = new aws.iam.Policy("test-policy", {
    description: "Test policy",
    policy: JSON.stringify({
        Version: "2012-10-17",
        Statement: [{
            Action: ["s3:ListBucket"],
            Effect: "Allow",
            Resource: "*",
        }],
    }),
});

const rolePolicy = new aws.iam.RolePolicy("test-role-policy", {
    role: role,
    policy: JSON.stringify({
        Version: "2012-10-17",
        Statement: [{
            Action: ["ec2:DescribeInstances"],
            Effect: "Allow",
            Resource: "*",
        }],
    }),
});

const rolePolicyAttachment = new aws.iam.RolePolicyAttachment("test-role-policy-attachment", {
    role: role,
    policyArn: policy.arn,
});

const groupPolicyAttachment = new aws.iam.GroupPolicyAttachment("test-group-policy-attachment", {
    group: group,
    policyArn: policy.arn,
});

const userPolicyAttachment = new aws.iam.UserPolicyAttachment("test-user-policy-attachment", {
    user: user,
    policyArn: policy.arn,
});

const policyAttachment = new aws.iam.PolicyAttachment("test-policy-attachment", {
    users: [user],
    roles: [role],
    groups: [group],
    policyArn: policy.arn,
});

const launchConfig = new aws.ec2.LaunchConfiguration("test-lc", {
    imageId: "ami-0735c191cf914754d",
    instanceType: "t2.micro",
    iamInstanceProfile: instanceProfile,
});

const instance = new aws.ec2.Instance("test-instance", {
    ami: "ami-0735c191cf914754d",
    instanceType: "t2.micro",
    iamInstanceProfile: instanceProfile,
});

export const instanceId = instance.id;