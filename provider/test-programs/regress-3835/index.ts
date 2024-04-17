import * as aws from "@pulumi/aws";

const proxyRole = new aws.iam.Role(
  "role",
  {
    assumeRolePolicy: aws.iam.assumeRolePolicyForPrincipal(
      aws.iam.Principals.RdsPrincipal,
    ),
    managedPolicyArns: [],
  },
  {},
);

const vpc = new aws.ec2.Vpc("vpc", {
  cidrBlock: "10.0.0.0/16",
});

const subnet = new aws.ec2.Subnet("subnet", {
  vpcId: vpc.id,
  cidrBlock: "10.0.1.0/24",
  availabilityZone: "us-west-2a",
});

const anotherSubnet = new aws.ec2.Subnet("another-subnet", {
  vpcId: vpc.id,
  cidrBlock: "10.0.2.0/24",
  availabilityZone: "us-west-2b",
});

const example = new aws.rds.Proxy("example", {
  name: "example",
  debugLogging: false,
  engineFamily: "MYSQL",
  idleClientTimeout: 1800,
  requireTls: true,
  roleArn: proxyRole.arn,
  vpcSubnetIds: [subnet.id, anotherSubnet.id],
  auths: [{}],
  tags: {
    Name: "example",
    Key: "value",
  },
});

export const exmapleID = example.id;
