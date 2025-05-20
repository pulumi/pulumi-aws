import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const app = new aws.elasticbeanstalk.Application("myApp", {
    description: "My Elastic Beanstalk app",
});

const solutionStack = aws.elasticbeanstalk.getSolutionStack({
    mostRecent: true,
    nameRegex: "64bit Amazon Linux .* running Python .*"
});
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

const serviceRolePolicy = new aws.iam.RolePolicyAttachment("elasticbeanstalk-service-policy", {
    role: serviceRole.name,
    policyArn: "arn:aws:iam::aws:policy/service-role/AWSElasticBeanstalkService",
});

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

const webTierPolicy = new aws.iam.RolePolicyAttachment("elasticbeanstalk-web-tier", {
    role: instanceRole.name,
    policyArn: "arn:aws:iam::aws:policy/AWSElasticBeanstalkWebTier",
});

const instanceProfile = new aws.iam.InstanceProfile("elasticbeanstalk-instance-profile", {
    role: instanceRole.name,
});

const appBucket = new aws.s3.Bucket("elasticbeanstalk-app-bucket", {
    forceDestroy: true,
});

const appObject = new aws.s3.BucketObject("application.zip", {
    bucket: appBucket.id,
    key: "application.zip",
    source: new pulumi.asset.AssetArchive({
        "application.py": new pulumi.asset.StringAsset(`
from flask import Flask
application = Flask(__name__)

@application.route('/')
def hello():
    return 'Hello World!'

if __name__ == '__main__':
    application.run(host='0.0.0.0')
`),
        "requirements.txt": new pulumi.asset.StringAsset("flask==2.0.1"),
        "Procfile": new pulumi.asset.StringAsset("web: python application.py")
    })
});

const appVersion = new aws.elasticbeanstalk.ApplicationVersion("myAppVersion", {
    application: app.name,
    bucket: appBucket.id,
    key: appObject.key
});

const env = new aws.elasticbeanstalk.Environment("myEnv", {
    application: app.name,
    version: appVersion,
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