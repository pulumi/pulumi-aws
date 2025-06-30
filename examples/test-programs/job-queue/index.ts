import * as aws from "@pulumi/aws";

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

new aws.iam.RolePolicyAttachment("awsBatchServiceRoleRolePolicyAttachment", {
    role: batchRole.name,
    policyArn: "arn:aws:iam::aws:policy/service-role/AWSBatchServiceRole",
});


const vpc = new aws.ec2.Vpc("sampleVpc", { cidrBlock: "10.1.0.0/16" });

const sg = new aws.ec2.SecurityGroup("sampleSecurityGroup", {
    egress: [{
        cidrBlocks: ["0.0.0.0/0"],
        fromPort: 0,
        protocol: "-1",
        toPort: 0,
    }],
    vpcId: vpc.id,
});
const subnet = new aws.ec2.Subnet("sampleSubnet", {
    cidrBlock: "10.1.1.0/24",
    vpcId: vpc.id,
});

const computeEnvironment = new aws.batch.ComputeEnvironment("sampleComputeEnvironment", {
    computeEnvironmentNamePrefix: "test-",
    computeResources: {
        securityGroupIds: [sg.id],
        type: 'FARGATE',
        maxVcpus: 16,
        subnets: [subnet.id],
    },
    serviceRole: batchRole.arn,
    type: "MANAGED",
});


const jobQueue = new aws.batch.JobQueue("testQueue", {
    computeEnvironments: [computeEnvironment.arn],
    priority: 1,
    state: "ENABLED",
});
