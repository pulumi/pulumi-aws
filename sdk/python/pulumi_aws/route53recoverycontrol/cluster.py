# coding=utf-8
# *** WARNING: this file was generated by pulumi-language-python. ***
# *** Do not edit by hand unless you're certain you know what you are doing! ***

import builtins
import copy
import warnings
import sys
import pulumi
import pulumi.runtime
from typing import Any, Mapping, Optional, Sequence, Union, overload
if sys.version_info >= (3, 11):
    from typing import NotRequired, TypedDict, TypeAlias
else:
    from typing_extensions import NotRequired, TypedDict, TypeAlias
from .. import _utilities
from . import outputs
from ._inputs import *

__all__ = ['ClusterArgs', 'Cluster']

@pulumi.input_type
class ClusterArgs:
    def __init__(__self__, *,
                 name: Optional[pulumi.Input[builtins.str]] = None):
        """
        The set of arguments for constructing a Cluster resource.
        :param pulumi.Input[builtins.str] name: Unique name describing the cluster.
        """
        if name is not None:
            pulumi.set(__self__, "name", name)

    @property
    @pulumi.getter
    def name(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Unique name describing the cluster.
        """
        return pulumi.get(self, "name")

    @name.setter
    def name(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "name", value)


@pulumi.input_type
class _ClusterState:
    def __init__(__self__, *,
                 arn: Optional[pulumi.Input[builtins.str]] = None,
                 cluster_endpoints: Optional[pulumi.Input[Sequence[pulumi.Input['ClusterClusterEndpointArgs']]]] = None,
                 name: Optional[pulumi.Input[builtins.str]] = None,
                 status: Optional[pulumi.Input[builtins.str]] = None):
        """
        Input properties used for looking up and filtering Cluster resources.
        :param pulumi.Input[builtins.str] arn: ARN of the cluster
        :param pulumi.Input[Sequence[pulumi.Input['ClusterClusterEndpointArgs']]] cluster_endpoints: List of 5 endpoints in 5 regions that can be used to talk to the cluster. See below.
        :param pulumi.Input[builtins.str] name: Unique name describing the cluster.
        :param pulumi.Input[builtins.str] status: Status of cluster. `PENDING` when it is being created, `PENDING_DELETION` when it is being deleted and `DEPLOYED` otherwise.
        """
        if arn is not None:
            pulumi.set(__self__, "arn", arn)
        if cluster_endpoints is not None:
            pulumi.set(__self__, "cluster_endpoints", cluster_endpoints)
        if name is not None:
            pulumi.set(__self__, "name", name)
        if status is not None:
            pulumi.set(__self__, "status", status)

    @property
    @pulumi.getter
    def arn(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        ARN of the cluster
        """
        return pulumi.get(self, "arn")

    @arn.setter
    def arn(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "arn", value)

    @property
    @pulumi.getter(name="clusterEndpoints")
    def cluster_endpoints(self) -> Optional[pulumi.Input[Sequence[pulumi.Input['ClusterClusterEndpointArgs']]]]:
        """
        List of 5 endpoints in 5 regions that can be used to talk to the cluster. See below.
        """
        return pulumi.get(self, "cluster_endpoints")

    @cluster_endpoints.setter
    def cluster_endpoints(self, value: Optional[pulumi.Input[Sequence[pulumi.Input['ClusterClusterEndpointArgs']]]]):
        pulumi.set(self, "cluster_endpoints", value)

    @property
    @pulumi.getter
    def name(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Unique name describing the cluster.
        """
        return pulumi.get(self, "name")

    @name.setter
    def name(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "name", value)

    @property
    @pulumi.getter
    def status(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Status of cluster. `PENDING` when it is being created, `PENDING_DELETION` when it is being deleted and `DEPLOYED` otherwise.
        """
        return pulumi.get(self, "status")

    @status.setter
    def status(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "status", value)


@pulumi.type_token("aws:route53recoverycontrol/cluster:Cluster")
class Cluster(pulumi.CustomResource):
    @overload
    def __init__(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 name: Optional[pulumi.Input[builtins.str]] = None,
                 __props__=None):
        """
        Provides an AWS Route 53 Recovery Control Config Cluster.

        ## Example Usage

        ```python
        import pulumi
        import pulumi_aws as aws

        example = aws.route53recoverycontrol.Cluster("example", name="georgefitzgerald")
        ```

        ## Import

        Using `pulumi import`, import Route53 Recovery Control Config cluster using the cluster ARN. For example:

        ```sh
        $ pulumi import aws:route53recoverycontrol/cluster:Cluster mycluster arn:aws:route53-recovery-control::313517334327:cluster/f9ae13be-a11e-4ec7-8522-94a70468e6ea
        ```

        :param str resource_name: The name of the resource.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[builtins.str] name: Unique name describing the cluster.
        """
        ...
    @overload
    def __init__(__self__,
                 resource_name: str,
                 args: Optional[ClusterArgs] = None,
                 opts: Optional[pulumi.ResourceOptions] = None):
        """
        Provides an AWS Route 53 Recovery Control Config Cluster.

        ## Example Usage

        ```python
        import pulumi
        import pulumi_aws as aws

        example = aws.route53recoverycontrol.Cluster("example", name="georgefitzgerald")
        ```

        ## Import

        Using `pulumi import`, import Route53 Recovery Control Config cluster using the cluster ARN. For example:

        ```sh
        $ pulumi import aws:route53recoverycontrol/cluster:Cluster mycluster arn:aws:route53-recovery-control::313517334327:cluster/f9ae13be-a11e-4ec7-8522-94a70468e6ea
        ```

        :param str resource_name: The name of the resource.
        :param ClusterArgs args: The arguments to use to populate this resource's properties.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        ...
    def __init__(__self__, resource_name: str, *args, **kwargs):
        resource_args, opts = _utilities.get_resource_args_opts(ClusterArgs, pulumi.ResourceOptions, *args, **kwargs)
        if resource_args is not None:
            __self__._internal_init(resource_name, opts, **resource_args.__dict__)
        else:
            __self__._internal_init(resource_name, *args, **kwargs)

    def _internal_init(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 name: Optional[pulumi.Input[builtins.str]] = None,
                 __props__=None):
        opts = pulumi.ResourceOptions.merge(_utilities.get_resource_opts_defaults(), opts)
        if not isinstance(opts, pulumi.ResourceOptions):
            raise TypeError('Expected resource options to be a ResourceOptions instance')
        if opts.id is None:
            if __props__ is not None:
                raise TypeError('__props__ is only valid when passed in combination with a valid opts.id to get an existing resource')
            __props__ = ClusterArgs.__new__(ClusterArgs)

            __props__.__dict__["name"] = name
            __props__.__dict__["arn"] = None
            __props__.__dict__["cluster_endpoints"] = None
            __props__.__dict__["status"] = None
        super(Cluster, __self__).__init__(
            'aws:route53recoverycontrol/cluster:Cluster',
            resource_name,
            __props__,
            opts)

    @staticmethod
    def get(resource_name: str,
            id: pulumi.Input[str],
            opts: Optional[pulumi.ResourceOptions] = None,
            arn: Optional[pulumi.Input[builtins.str]] = None,
            cluster_endpoints: Optional[pulumi.Input[Sequence[pulumi.Input[Union['ClusterClusterEndpointArgs', 'ClusterClusterEndpointArgsDict']]]]] = None,
            name: Optional[pulumi.Input[builtins.str]] = None,
            status: Optional[pulumi.Input[builtins.str]] = None) -> 'Cluster':
        """
        Get an existing Cluster resource's state with the given name, id, and optional extra
        properties used to qualify the lookup.

        :param str resource_name: The unique name of the resulting resource.
        :param pulumi.Input[str] id: The unique provider ID of the resource to lookup.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[builtins.str] arn: ARN of the cluster
        :param pulumi.Input[Sequence[pulumi.Input[Union['ClusterClusterEndpointArgs', 'ClusterClusterEndpointArgsDict']]]] cluster_endpoints: List of 5 endpoints in 5 regions that can be used to talk to the cluster. See below.
        :param pulumi.Input[builtins.str] name: Unique name describing the cluster.
        :param pulumi.Input[builtins.str] status: Status of cluster. `PENDING` when it is being created, `PENDING_DELETION` when it is being deleted and `DEPLOYED` otherwise.
        """
        opts = pulumi.ResourceOptions.merge(opts, pulumi.ResourceOptions(id=id))

        __props__ = _ClusterState.__new__(_ClusterState)

        __props__.__dict__["arn"] = arn
        __props__.__dict__["cluster_endpoints"] = cluster_endpoints
        __props__.__dict__["name"] = name
        __props__.__dict__["status"] = status
        return Cluster(resource_name, opts=opts, __props__=__props__)

    @property
    @pulumi.getter
    def arn(self) -> pulumi.Output[builtins.str]:
        """
        ARN of the cluster
        """
        return pulumi.get(self, "arn")

    @property
    @pulumi.getter(name="clusterEndpoints")
    def cluster_endpoints(self) -> pulumi.Output[Sequence['outputs.ClusterClusterEndpoint']]:
        """
        List of 5 endpoints in 5 regions that can be used to talk to the cluster. See below.
        """
        return pulumi.get(self, "cluster_endpoints")

    @property
    @pulumi.getter
    def name(self) -> pulumi.Output[builtins.str]:
        """
        Unique name describing the cluster.
        """
        return pulumi.get(self, "name")

    @property
    @pulumi.getter
    def status(self) -> pulumi.Output[builtins.str]:
        """
        Status of cluster. `PENDING` when it is being created, `PENDING_DELETION` when it is being deleted and `DEPLOYED` otherwise.
        """
        return pulumi.get(self, "status")

