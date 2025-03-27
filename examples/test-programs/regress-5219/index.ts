import * as aws from "@pulumi/aws";
import * as awsx from "@pulumi/awsx";
import { SubnetAllocationStrategy } from "@pulumi/awsx/ec2";

// This will have 9 subnets (numberOfAvailabilityZones * subnetSpecs.length = 3 * 3 = 9).
//
// Over 10 subnets will trigger:
//    error: aws:route53/resolverEndpoint:ResolverEndpoint resource 're' has a problem: Too many list items.
//    Attribute ip_address supports 10 item maximum, but config has 12 declared.. Examine values at 're.ipAddresses'.
//
// Under 6 subnets is fine.
//
// With 6-10 subnets we currently have a hang.
const vpc = new awsx.ec2.Vpc("vpc", {
    numberOfAvailabilityZones: 3,
    subnetStrategy: SubnetAllocationStrategy.Auto,
    subnetSpecs: [
        {
            name: "private-1",
            type: "Private",
            cidrMask: 25,
        },
        {
            name: "private-2",
            type: "Private",
            cidrMask: 25,
        },
        {
            name: "public-1",
            type: "Public",
            cidrMask: 27,
        },
    ],
});

const securityGroup = new aws.ec2.SecurityGroup("s3ResolverSecurityGroup", {
    vpcId: vpc.vpcId,
    egress: [
        {
            protocol: "tcp",
            fromPort: 443,
            toPort: 443,
            cidrBlocks: ["0.0.0.0/0"],
            description: "Allow outbound HTTPS traffic to S3",
        },
    ],
});

const re = new aws.route53.ResolverEndpoint("re", {
    direction: "OUTBOUND",
    resolverEndpointType: "IPV4",
    protocols: ["Do53", "DoH"],

    // Every entry in ipAddresses must have a unique subnetid apparently.
    ipAddresses: vpc.subnets.apply(xs => xs.map(subnet => ({
        subnetId: subnet.id,
    }))),
    securityGroupIds: [securityGroup.id],
});

export const reIPS = re.ipAddresses;
export const reIPSLen = re.ipAddresses.apply(x => x.length);
export const subnetCount = vpc.subnets.apply(x => x.length);
