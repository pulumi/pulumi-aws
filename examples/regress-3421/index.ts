import * as aws from "@pulumi/aws";

const vpc = new aws.ec2.Vpc("main", { cidrBlock: "10.0.0.0/16" });

const currentRegion = aws.getRegion({})
const subnet = new aws.ec2.Subnet("main", {
    vpcId: vpc.id,
    cidrBlock: "10.0.12.0/24",
    availabilityZone: currentRegion.then(region => region.name + "a")
});

const subnet2 = new aws.ec2.Subnet("subnet2", {
    vpcId: vpc.id,
    cidrBlock: "10.0.5.0/24",
    availabilityZone: currentRegion.then(region => region.name + "b")
});

const secGroup = new aws.ec2.SecurityGroup("allowTls", {
    description: "Allow TLS inbound traffic and all outbound traffic",
    vpcId: vpc.id,
    tags: {
        Name: "allow_tls",
    },
});

const loadbalancer = new aws.lb.LoadBalancer("payload-lb", {
    loadBalancerType: "application",
    securityGroups: [secGroup.id],
    subnets: [subnet.id, subnet2.id],
    internal: true,
});

const targetGroup = new aws.lb.TargetGroup("payload-tg", {
    port: 80,
    protocol: "HTTP",
    targetType: "ip",
    vpcId: vpc.id,
});

new aws.lb.Listener("payload-lb-listner-http", {
loadBalancerArn: loadbalancer.arn,
port: 80,
protocol: "HTTP",
defaultActions: [
    {
    type: "forward",
    targetGroupArn: targetGroup.arn,
    },
],
});