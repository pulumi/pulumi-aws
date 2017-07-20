// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import { Application, ApplicationVersion, Environment } from "@lumi/aws/elasticbeanstalk";
import * as iam from "@lumi/aws/iam";
import { Bucket, Object } from "@lumi/aws/s3";
import { File } from "@lumi/lumi/asset";
import { jsonStringify } from "@lumi/lumirt";

let sourceBucket = new Bucket("sourceBucket", {});
let source = new Object({
    bucket: sourceBucket,
    key: "testSource/app.zip",
    source: new File("app.zip"),
});

let myapp = new Application("myapp", {});
let myappversion = new ApplicationVersion("myappversion", {
    application: myapp,
    bucket: sourceBucket.name,
    key: source.key,
});

let instanceRolePolicyDocument = {
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "",
            "Effect": "Allow",
            "Principal": {
                "Service": "ec2.amazonaws.com",
            },
            "Action": "sts:AssumeRole",
        },
    ],
};
let instanceRole = new iam.Role("myapp-instanceRole", {
    assumeRolePolicy: jsonStringify(instanceRolePolicyDocument),
});
let instanceWebTierPolicyAttach = new iam.RolePolicyAttachment("myapp-instanceRole-webtierPolicy", {
    role: instanceRole,
    policyArn: iam.AWSElasticBeanstalkWebTier,
});
let instanceProfile = new iam.InstanceProfile("myapp-instanceProfile", {
    roles: [ instanceRole ],
});
let serviceRolePolicyDocument = {
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "",
            "Effect": "Allow",
            "Principal": {
                "Service": "elasticbeanstalk.amazonaws.com",
            },
            "Action": "sts:AssumeRole",
            "Condition": {
                "StringEquals": {
                    "sts:ExternalId": "elasticbeanstalk",
                },
            },
        },
    ],
};
let serviceRole = new iam.Role("myapp", {
    assumeRolePolicy: jsonStringify(serviceRolePolicyDocument),
});
let serviceServiceTierServiceHealthAttach = new iam.RolePolicyAttachment("myapp-healthPolicy", {
    role: serviceRole,
    policyArn: iam.AWSElasticBeanstalkEnhancedHealth,
});
let serviceServiceTierServicePolicyAttach = new iam.RolePolicyAttachment("myapp-servicePolicy", {
    role: serviceRole,
    policyArn: iam.AWSElasticBeanstalkService,
});
let myenv = new Environment("myenv", {
    application: myapp,
    version: myappversion,
    solutionStackName: "64bit Amazon Linux 2017.03 v4.1.0 running Node.js",
    setting: [
        {
            namespace: "aws:autoscaling:asg",
            name: "MinSize",
            value: "2",
        },
        {
            namespace: "aws:autoscaling:launchconfiguration",
            name: "InstanceType",
            value: "t2.nano",
        },
        {
            namespace: "aws:autoscaling:launchconfiguration",
            name: "IamInstanceProfile",
            value: instanceProfile.arn,
        },
        {
            namespace: "aws:elasticbeanstalk:environment",
            name: "ServiceRole",
            value: serviceRole.arn,
        },
    ],
});

