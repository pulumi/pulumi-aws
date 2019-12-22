import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as awsx from "@pulumi/awsx";

const managedPolicyArns: string[] = [
    "arn:aws:iam::aws:policy/AmazonEKSClusterPolicy",
    "arn:aws:iam::aws:policy/AmazonEKSServicePolicy",
];

const eksRole = new aws.iam.Role("eks-role", {
    assumeRolePolicy: aws.iam.assumeRolePolicyForPrincipal({
        Service: "eks.amazonaws.com",
    }),
});

let counter = 0;
for (const policy of managedPolicyArns) {
    // Create RolePolicyAttachment without returning it.
    const rpa = new aws.iam.RolePolicyAttachment(`eks-role-policy-${counter++}`,
        { policyArn: policy, role: eksRole },
    );
};

const vpc = new awsx.ec2.Vpc("my-vpc");

const cluster = new aws.eks.Cluster("my-cluster", {
    roleArn: eksRole.arn,
    vpcConfig: {
        subnetIds: vpc.publicSubnetIds
    }
});

export const x = cluster.certificateAuthority.data;

export const kubeConfig = cluster.kubeconfig;



