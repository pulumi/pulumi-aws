// Copyright 2016-2018, Pulumi Corporation.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

import * as aws from "@pulumi/aws";

const clusterRole = new aws.iam.Role('test-cluster-role', {
    assumeRolePolicy: {
        Version: '2012-10-17',
        Statement: [{
            Principal: {
                Service: 'eks.amazonaws.com',
            },
            Effect: 'Allow',
            Action: 'sts:AssumeRole',
        }]
    }
});

new aws.iam.RolePolicyAttachment('attachment', {
    policyArn: aws.iam.ManagedPolicy.AmazonEKSClusterPolicy,
    role: clusterRole.name,
});

const vpc = new aws.ec2.Vpc('test-vpc', {
    cidrBlock: '10.192.0.0/16'
});

const azs = aws.getAvailabilityZonesOutput({
    state: 'available',
    allAvailabilityZones: false,
    filters: [
        {
            name: 'opt-in-status',
            values: ['opt-in-not-required'],
        },
    ],
});

const subnet1 = new aws.ec2.Subnet('test-subnet1', {
    vpcId: vpc.id,
    cidrBlock: '10.192.20.0/24',
    availabilityZone: azs.apply(az => az.names[0]),
    mapPublicIpOnLaunch: false,
});

const subnet2 = new aws.ec2.Subnet('test-subnet2', {
    vpcId: vpc.id,
    availabilityZone: azs.apply(az => az.names[1]),
    cidrBlock: '10.192.21.0/24',
    mapPublicIpOnLaunch: false,
});

const cluster = new aws.eks.Cluster('test-cluster', {
    roleArn: clusterRole.arn,
    vpcConfig: {
        subnetIds: [subnet1.id, subnet2.id],
    },
    bootstrapSelfManagedAddons: false,
});

// TODO: example needs node group
// const corednsVersion = aws.eks.getAddonVersionOutput({
//   addonName: "coredns",
//   kubernetesVersion: cluster.version,
//   mostRecent: true,
// });
//
// new aws.eks.Addon("coredns", {
//   clusterName: cluster.name,
//   addonName: "coredns",
//   addonVersion: corednsVersion.version,
//   resolveConflictsOnUpdate: "PRESERVE",
//   configurationValues: JSON.stringify({
//     replicaCount: 4,
//     resources: {
//       limits: {
//         cpu: "100m",
//         memory: "150Mi",
//       },
//       requests: {
//         cpu: "100m",
//         memory: "150Mi",
//       },
//     },
//   }),
// });

const cluster2 = new aws.eks.Cluster('test-cluster2', {
    roleArn: clusterRole.arn,
    vpcConfig: {
        subnetIds: [subnet1.id, subnet2.id],
    },
    defaultAddonsToRemoves: ['vpc-cni', 'kube-proxy'],
});
