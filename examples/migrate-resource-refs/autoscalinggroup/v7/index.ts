import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const vpc = new aws.ec2.Vpc("test-vpc", {
    cidrBlock: "10.0.0.0/16",
    enableDnsHostnames: true,
    enableDnsSupport: true,
});

const subnet = new aws.ec2.Subnet("test-subnet", {
    vpcId: vpc.id,
    cidrBlock: "10.0.1.0/24",
    availabilityZone: "us-west-2a",
    mapPublicIpOnLaunch: true,
});

const internetGateway = new aws.ec2.InternetGateway("test-igw", {
    vpcId: vpc.id,
});

const routeTable = new aws.ec2.RouteTable("test-rt", {
    vpcId: vpc.id,
    routes: [{
        cidrBlock: "0.0.0.0/0",
        gatewayId: internetGateway.id,
    }],
});

const routeTableAssociation = new aws.ec2.RouteTableAssociation("test-rta", {
    subnetId: subnet.id,
    routeTableId: routeTable.id,
});

const securityGroup = new aws.ec2.SecurityGroup("test-sg", {
    vpcId: vpc.id,
    description: "Security group for test instances",
    egress: [{
        protocol: "-1",
        fromPort: 0,
        toPort: 0,
        cidrBlocks: ["0.0.0.0/0"],
    }],
});

const placementGroup = new aws.ec2.PlacementGroup("test-pg", {
    strategy: "spread",
});

const launchConfig = new aws.ec2.LaunchConfiguration("test-lc", {
    imageId: "ami-0735c191cf914754d", // Amazon Linux 2 AMI in us-west-2
    instanceType: "t2.micro",
    securityGroups: [securityGroup.id],
    placementTenancy: "default",

});

const asg = new aws.autoscaling.Group("test-asg", {
    launchConfiguration: launchConfig.name,
    minSize: 1,
    maxSize: 2,
    desiredCapacity: 1,
    vpcZoneIdentifiers: [subnet.id],
    placementGroup: placementGroup.name,
    tags: [{
        key: "Name",
        value: "test-instance",
        propagateAtLaunch: true,
    }],
});

export const asgName = asg.name;