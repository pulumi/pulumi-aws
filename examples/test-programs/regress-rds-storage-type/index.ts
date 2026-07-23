import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

// Regress pulumi/pulumi-aws: changing storage_type on a non-Aurora Multi-AZ
// RDS cluster must update in place, not force a replacement. Run once with
// storageType=io1, then again with storageType=gp3, and assert no replace.
const config = new pulumi.Config();
const storageType = config.get("storageType") || "io1";

const vpc = new aws.ec2.Vpc("test", { cidrBlock: "10.99.0.0/16" });

const azs = aws.getAvailabilityZonesOutput({ state: "available" });

const subnets = [0, 1, 2].map(i => new aws.ec2.Subnet(`test-${i}`, {
    vpcId: vpc.id,
    cidrBlock: `10.99.${i}.0/24`,
    availabilityZone: azs.apply(a => a.names[i]),
}));

const subnetGroup = new aws.rds.SubnetGroup("test", {
    subnetIds: subnets.map(s => s.id),
});

const cluster = new aws.rds.Cluster("test", {
    engine: aws.rds.EngineType.Postgres,
    dbClusterInstanceClass: "db.r6gd.xlarge",
    dbSubnetGroupName: subnetGroup.name,
    storageType: storageType,
    allocatedStorage: 100,
    iops: storageType === "gp3" ? undefined : 1000,
    masterUsername: "test",
    masterPassword: "mustbeeightcharaters",
    skipFinalSnapshot: true,
});

export const clusterId = cluster.id;
export const clusterStorageType = cluster.storageType;
