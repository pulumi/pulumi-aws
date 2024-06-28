import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as awsx from "@pulumi/awsx";

const vpc = new awsx.ec2.Vpc("lb-vpc", {
    cidrBlock: "10.0.0.0/16",
    subnetStrategy: "Auto",
    subnetSpecs: [
      {
        type: "Public",
        name: "public-subnet",
      },
    ],
    numberOfAvailabilityZones: 3,
    natGateways: {
      strategy: "None"
    }
  });

const secGroup = new aws.ec2.SecurityGroup("allowTls", {
    description: "Allow TLS inbound traffic and all outbound traffic",
    vpcId: vpc.vpcId,
    tags: {
        Name: "allow_tls",
    },
});

const loadbalancer = new aws.lb.LoadBalancer("my-lb", {
    loadBalancerType: "application",
    securityGroups: [secGroup.id],
    subnets: vpc.publicSubnetIds,
    internal: true,
});

const targetGroup = new aws.lb.TargetGroup("my-tg", {
    port: 80,
    protocol: "HTTP",
    targetType: "ip",
    vpcId: vpc.vpcId,
});

const listener = new aws.lb.Listener("my-listener", {
    loadBalancerArn: loadbalancer.arn,
    port: 80,
    defaultActions: [{
        type: "forward",
        targetGroupArn: targetGroup.arn,
    }],
});

const listenerRule = new aws.lb.ListenerRule("my-listener-rule", {
    listenerArn: listener.arn,
    priority: 100,
    actions: [{
        type: "forward",
        targetGroupArn: targetGroup.arn,
    }],
    conditions: [{
        pathPattern: {
            values: ["/path/*"],
        },
    }],
});

const alb = new aws.alb.LoadBalancer("my-alb", {
    securityGroups: [secGroup.id],
    subnets: vpc.publicSubnetIds,
    internal: true,
});

const albTg = new aws.alb.TargetGroup("my-alb-tg", {
    port: 80,
    protocol: "HTTP",
    targetType: "ip",
    vpcId: vpc.vpcId,
});

const albListener = new aws.lb.Listener("my-alb-listener", {
    loadBalancerArn: alb.arn,
    port: 80,
    defaultActions: [{
        type: "forward",
        targetGroupArn: albTg.arn,
    }],
});

const albRule = new aws.alb.ListenerRule("my-alb-listener-rule", {
    listenerArn: albListener.arn,
    priority: 100,
    actions: [{
        type: "forward",
        targetGroupArn: albTg.arn,
    }],
    conditions: [{
        pathPattern: {
            values: ["/path/*"],
        },
    }],
});
