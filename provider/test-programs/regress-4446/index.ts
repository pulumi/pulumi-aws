import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const amiId = pulumi.interpolate`/aws/service/eks/optimized-ami/1.30/amazon-linux-2023/x86_64/standard/recommended/image_id`.apply(name =>
    aws.ssm.getParameter({ name }, { async: true })
  ).apply(result => result.value);

const userData = `#!/bin/bash

/etc/eks/bootstrap.sh
`;

const nodeLaunchConfiguration = new aws.ec2.LaunchConfiguration("test",
    {
        associatePublicIpAddress: true,
        imageId: amiId,
        instanceType: "t2.medium",
        userData: userData,
    }
);
