# Copyright 2016-2018, Pulumi Corporation.  All rights reserved.

import pulumi
from pulumi_aws import applicationloadbalancing

group = applicationloadbalancing.LoadBalancer('lb',
    load_balancer_type='application',
    internal=False)
