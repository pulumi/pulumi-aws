import * as aws from "@pulumi/aws";

const ec2AssumeRole = aws.iam.getPolicyDocument({
    statements: [{
        actions: ["sts:AssumeRole"],
        effect: "Allow",
        principals: [{
            identifiers: ["ec2.amazonaws.com"],
            type: "Service",
        }],
    }],
});

const ecsInstanceRole = new aws.iam.Role("ecsInstanceRoleRole", {
    assumeRolePolicy: ec2AssumeRole.then(policy => policy.json),
});

const ecsPolicyAttachment = new aws.iam.RolePolicyAttachment("ecsInstanceRoleRolePolicyAttachment", {
    role: ecsInstanceRole.name,
    policyArn: "arn:aws:iam::aws:policy/service-role/AmazonEC2ContainerServiceforEC2Role",
});

const ecsInstanceProfile = new aws.iam.InstanceProfile("ecsInstanceRoleInstanceProfile", {
    role: ecsInstanceRole.name,
});

const batchAssumeRole = aws.iam.getPolicyDocument({
    statements: [{
        actions: ["sts:AssumeRole"],
        effect: "Allow",
        principals: [{
            identifiers: ["batch.amazonaws.com"],
            type: "Service",
        }],
    }],
});

const batchRole = new aws.iam.Role("awsBatchServiceRoleRole", {
    assumeRolePolicy: batchAssumeRole.then(policy => policy.json),
});

const batchPolicyAttachment = new aws.iam.RolePolicyAttachment("awsBatchServiceRoleRolePolicyAttachment", {
    role: batchRole.name,
    policyArn: "arn:aws:iam::aws:policy/service-role/AWSBatchServiceRole",
});

const sg = new aws.ec2.SecurityGroup("sampleSecurityGroup", {
    egress: [{
        cidrBlocks: ["0.0.0.0/0"],
        fromPort: 0,
        protocol: "-1",
        toPort: 0,
    }],
});

const vpc = new aws.ec2.Vpc("sampleVpc", { cidrBlock: "10.1.0.0/16" });

const subnet = new aws.ec2.Subnet("sampleSubnet", {
    cidrBlock: "10.1.1.0/24",
    vpcId: vpc.id,
});

const computeEnvironment = new aws.batch.ComputeEnvironment("sampleComputeEnvironment", {
    computeResources: {
        instanceRole: ecsInstanceProfile.arn,
        instanceTypes: ["c4.large"],
        maxVcpus: 16,
        minVcpus: 0,
        securityGroupIds: [sg.id],
        subnets: [subnet.id],
        type: "EC2",
    },
    serviceRole: batchRole.arn,
    type: "MANAGED",
});


const jobQueue = new aws.batch.JobQueue("testQueue", {
    computeEnvironmentOrders: [{
        computeEnvironment: computeEnvironment.arn,
        order: 1,
    }],
    priority: 1,
    state: "ENABLED",
});
