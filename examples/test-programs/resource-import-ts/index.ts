import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const config = new pulumi.Config();
const imported_queue_arn = config.get("queue_arn");
const imported_reportgroup_arn = config.get("report_group_arn")
const importRegion = config.get("import_region");
const imported_vpc_id = config.get("vpc_id")
const imported_subnet_id = config.get("subnet_id")
const imported_compute_env_arn = config.get("compute_env_arn")
const imported_security_group_id = config.get("security_group_id");
const imported_role_name = config.get("role_name");
const imported_policy_attachment_arn = config.get("policy_attachment_arn");

const provider = new aws.Provider('aws', {
    region: aws.config.requireRegion(),
});

const opts: pulumi.CustomResourceOptions = {
    provider,
}

const vpc = new aws.ec2.Vpc("sampleVpc", {
    region: importRegion,
    cidrBlock: "10.1.0.0/16",
}, {
    ...opts,
    import: getImport(imported_vpc_id, importRegion),
});

const sg = new aws.ec2.SecurityGroup("sampleSecurityGroup", {
    vpcId: vpc.id,
    region: importRegion,
    egress: [{
        cidrBlocks: ["0.0.0.0/0"],
        fromPort: 0,
        protocol: "-1",
        toPort: 0,
    }],
}, {
    ...opts,
    import: getImport(imported_security_group_id, importRegion),
});

const subnet = new aws.ec2.Subnet("sampleSubnet", {
    region: importRegion,
    cidrBlock: "10.1.1.0/24",
    vpcId: vpc.id,
}, {
    ...opts,
    import: getImport(imported_subnet_id, importRegion),
});

const batchRole = new aws.iam.Role("awsBatchServiceRoleRole", {
    assumeRolePolicy: aws.iam.assumeRolePolicyForPrincipal(aws.iam.Principals.BatchPrincipal),
}, {
    ...opts,
    import: imported_role_name,
});

const batchPolicyAttachment = new aws.iam.RolePolicyAttachment("awsBatchServiceRoleRolePolicyAttachment", {
    role: batchRole.name,
    policyArn: "arn:aws:iam::aws:policy/service-role/AWSBatchServiceRole",
}, {
    ...opts,
    import: imported_role_name ? `${imported_role_name}/${imported_policy_attachment_arn}` : undefined,
});

const computeEnvironment = new aws.batch.ComputeEnvironment("sampleComputeEnvironment", {
    region: importRegion,
    type: 'MANAGED',
    serviceRole: batchRole.arn,
    computeResources: {
        securityGroupIds: [sg.id],
        type: 'FARGATE',
        maxVcpus: 16,
        subnets: [subnet.id],
    },
}, {
    ...opts,
    // TODO: the region should come from the arn soon...
    import: getImport(imported_compute_env_arn, importRegion),
});

// framework resource
const jobQueue = new aws.batch.JobQueue("testQueue", {
    computeEnvironmentOrders: [{
        computeEnvironment: computeEnvironment.arn,
        order: 0,
    }],
    region: importRegion,
    priority: 1,
    state: "ENABLED",
}, {
    ...opts,
    import: imported_queue_arn,
});

// sdk resource
const reportGroup = new aws.codebuild.ReportGroup("testReportGroup", {
    exportConfig: {
        type: 'NO_EXPORT',
    },
    type: 'TEST',
    region: importRegion,
}, {
    ...opts,
    import: imported_reportgroup_arn,
});

function getImport(id?: string, region?: string): string | undefined {
    if (region) {
        return `${id}@${region}`;
    }
    return id;
}

export const queue_arn = jobQueue.arn;
export const report_group_arn = reportGroup.arn;
export const vpc_id = vpc.id;
export const subnet_id = subnet.id;
export const compute_env_arn = computeEnvironment.arn;
export const security_group_id = sg.id;
export const role_name = batchRole.name;
export const policy_attachment_arn = batchPolicyAttachment.policyArn;
