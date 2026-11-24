# Copyright 2016-2026, Pulumi Corporation.  All rights reserved.

from pulumi_aws import ssm

# AWS keeps this parameter pointed at the current Amazon Linux 2023 AMI in each region.
# Pinned AMI IDs stop working once AWS retires the image.
LINUX_AMI_PARAMETER = "/aws/service/ami-amazon-linux-latest/al2023-ami-kernel-default-x86_64"


def get_linux_ami():
    """Gets the current Amazon Linux 2023 AMI in the current AWS region."""
    return ssm.get_parameter(name=LINUX_AMI_PARAMETER).value
