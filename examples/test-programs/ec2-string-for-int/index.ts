import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const ubuntu = aws.ec2.getAmi({
    mostRecent: true,
    filters: [
        {
            name: "name",
            values: ["ubuntu/images/hvm-ssd/ubuntu-jammy-22.04-amd64-server-*"],
        },
        {
            name: "virtualization-type",
            values: ["hvm"],
        },
    ],
    owners: ["099720109477"],
});
const web = new aws.ec2.Instance("web", {
    ami: ubuntu.then(ubuntu => ubuntu.id),
    instanceType: aws.ec2.InstanceType.T3_Micro,
    // @ts-ignore
    cpuCoreCount: "2" 
});