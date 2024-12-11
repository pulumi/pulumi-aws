import * as aws from "@pulumi/aws";
import * as awsx from "@pulumi/awsx";
import * as pulumi from "@pulumi/pulumi";

const cfg = new pulumi.Config();

const targetGroupCount = cfg.requireNumber("targetGroupCount");

const vpc = new awsx.ec2.Vpc("lb-vpc", {
  cidrBlock: "10.0.0.0/16",
  subnetStrategy: "Auto",
  subnetSpecs: [
    {
      type: "Public",
      name: "ecs-public-subnet",
    },
  ],
  numberOfAvailabilityZones: 2,
  natGateways: {
    strategy: "None"
  }
});

const lbSecurityGroup = new aws.ec2.SecurityGroup("lbSg", {
    vpcId: vpc.vpcId,
    ingress: [{
        protocol: "tcp",
        fromPort: 80,
        toPort: 80,
        cidrBlocks: ["0.0.0.0/0"]
    },
],
    egress: [{
        protocol: "-1",
        fromPort: 0,
        toPort: 0,
        cidrBlocks: ["0.0.0.0/0"]
    }]
});

const lb = new aws.lb.LoadBalancer("lb", {
    securityGroups: [lbSecurityGroup.id],
    subnets: vpc.publicSubnetIds,
});

const tg = new aws.lb.TargetGroup("tg", {
    port: 8080,
    protocol: "HTTP",
    targetType: "ip",
    vpcId: vpc.vpcId,
    deregistrationDelay: 5
}, {dependsOn: [lb]});

const tg2 = new aws.lb.TargetGroup("tg2", {
    port: 8080,
    protocol: "HTTP",
    targetType: "ip",
    vpcId: vpc.vpcId,
    deregistrationDelay: 5
}, {dependsOn: [lb]});

const targetGroups = (targetGroupCount === 1)
    ?  [
        {
            arn: tg.arn,
            weight: 1,
        },
    ] : [
        {
            arn: tg.arn,
            weight: 1,
        },
        {
            arn: tg2.arn,
            weight: 2,
        },
    ];

const listener = new aws.lb.Listener("listener", {
    loadBalancerArn: lb.arn,
    port: 80,
    defaultActions: [{
        type: "forward",
        forward: {
            targetGroups: targetGroups,
          },
    }]
}, {ignoreChanges: ["defaultActions[*].forward.targetGroups[*].weight"]});


export const lburl = lb.dnsName;
export const listenerId = listener.id;
export const listenerARN = listener.arn;
