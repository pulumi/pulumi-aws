import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const config = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: <aws.Region>config.require("envRegion") }) };

let vpc = new aws.ec2.Vpc("vpc", {
    cidrBlock: "10.0.0.0/24",
}, providerOpts);

export let foo = vpc.defaultRouteTableId.apply(rtbid => {
    return aws.ec2.getRoute({ routeTableId: rtbid })
});
