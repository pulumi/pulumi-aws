import * as aws from "@pulumi/aws";

const vpc = new aws.ec2.Vpc("test", { cidrBlock: "10.99.0.0/16" });

const availabilityZones = ["us-west-2a", "us-west-2b", "us-west-2c"];

const subnets = [0, 1, 2].map(i => new aws.ec2.Subnet(`test-${i}`, {
    vpcId: vpc.id,
    cidrBlock: `10.99.${i}.0/24`,
    availabilityZone: availabilityZones[i],
}));

const subnetGroup = new aws.rds.SubnetGroup("test", {
    subnetIds: subnets.map(s => s.id),
});

const cluster = new aws.rds.Cluster("test", {
    engine: "postgres",
    dbClusterInstanceClass: "db.r6gd.large",
    dbSubnetGroupName: subnetGroup.name,
    storageType: "gp3",
    allocatedStorage: 400,
    iops: 12000,
    masterUsername: "test",
    masterPassword: "mustbeeightcharaters",
    skipFinalSnapshot: true,
});

export const clusterId = cluster.id;
export const clusterStorageType = cluster.storageType;
