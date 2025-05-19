import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

// Create an Elastic Beanstalk Application
const app = new aws.elasticbeanstalk.Application("myApp", {
    description: "My Elastic Beanstalk app",
});

const solutionStack = aws.elasticbeanstalk.getSolutionStack({
    mostRecent: true,
    nameRegex: "64bit Amazon Linux .* running Python .*"
});
// Create the service role for Elastic Beanstalk
const serviceRole = new aws.iam.Role("elasticbeanstalk-service-role", {
    assumeRolePolicy: JSON.stringify({
        Version: "2012-10-17",
        Statement: [{
            Action: "sts:AssumeRole",
            Effect: "Allow",
            Principal: {
                Service: "elasticbeanstalk.amazonaws.com",
            },
        }],
    }),
});

// Attach the required policy to the service role
const serviceRolePolicy = new aws.iam.RolePolicyAttachment("elasticbeanstalk-service-policy", {
    role: serviceRole.name,
    policyArn: "arn:aws:iam::aws:policy/service-role/AWSElasticBeanstalkService",
});

// Create the instance profile role
const instanceRole = new aws.iam.Role("elasticbeanstalk-instance-role", {
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

// Attach the required policies to the instance role
const webTierPolicy = new aws.iam.RolePolicyAttachment("elasticbeanstalk-web-tier", {
    role: instanceRole.name,
    policyArn: "arn:aws:iam::aws:policy/AWSElasticBeanstalkWebTier",
});

// Create the instance profile
const instanceProfile = new aws.iam.InstanceProfile("elasticbeanstalk-instance-profile", {
    role: instanceRole.name,
});

// Create an Environment with all required settings
const env = new aws.elasticbeanstalk.Environment("myEnv", {
    application: app,
    solutionStackName: solutionStack.then(stack => stack.name),
    description: "Test environment for debugging",
    settings: [
        {
            namespace: "aws:autoscaling:launchconfiguration",
            name: "IamInstanceProfile",
            value: instanceProfile.name,
        },
        {
            namespace: "aws:elasticbeanstalk:environment",
            name: "EnvironmentType",
            value: "SingleInstance",
        },
        {
            namespace: "aws:ec2:instances",
            name: "InstanceTypes",
            value: "t2.micro",
        },
        {
            namespace: "aws:elasticbeanstalk:environment",
            name: "ServiceRole",
            value: serviceRole.name,
        }
    ],
    waitForReadyTimeout: "20m",
});

export const version = env.application