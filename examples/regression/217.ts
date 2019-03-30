import * as aws from "@pulumi/aws";
let vpc = new aws.ec2.Vpc("vpc", {
    cidrBlock: "10.0.0.0/24",
});
export let foo = vpc.defaultRouteTableId.apply(rtbid => {
    return aws.ec2.getRoute({ routeTableId: rtbid })
});
