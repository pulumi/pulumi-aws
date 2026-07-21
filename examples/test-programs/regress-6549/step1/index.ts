import * as aws from "@pulumi/aws";

const vpc = new aws.ec2.Vpc("test", { cidrBlock: "10.1.0.0/16" });
const igw = new aws.ec2.InternetGateway("test", { vpcId: vpc.id });
const routeTable = new aws.ec2.RouteTable("test", { vpcId: vpc.id });
const route = new aws.ec2.Route("test", {
    routeTableId: routeTable.id,
    destinationCidrBlock: "10.3.0.0/16",
    gatewayId: igw.id,
}, {
    customTimeouts: {
        create: "5m",
        delete: "5m",
    },
});

export const routeId = route.id;
