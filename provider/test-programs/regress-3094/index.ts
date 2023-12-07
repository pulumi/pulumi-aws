import * as aws from '@pulumi/aws';

const myGroup = new aws.ec2.SecurityGroup('myGroup', {});

new aws.ec2.SecurityGroup('myGroup2', {
    ingress: myGroup.ingress,
});
