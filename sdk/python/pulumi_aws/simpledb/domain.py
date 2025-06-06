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

__all__ = ['DomainArgs', 'Domain']

@pulumi.input_type
class DomainArgs:
    def __init__(__self__, *,
                 name: Optional[pulumi.Input[builtins.str]] = None):
        """
        The set of arguments for constructing a Domain resource.
        :param pulumi.Input[builtins.str] name: The name of the SimpleDB domain
        """
        if name is not None:
            pulumi.set(__self__, "name", name)

    @property
    @pulumi.getter
    def name(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The name of the SimpleDB domain
        """
        return pulumi.get(self, "name")

    @name.setter
    def name(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "name", value)


@pulumi.input_type
class _DomainState:
    def __init__(__self__, *,
                 name: Optional[pulumi.Input[builtins.str]] = None):
        """
        Input properties used for looking up and filtering Domain resources.
        :param pulumi.Input[builtins.str] name: The name of the SimpleDB domain
        """
        if name is not None:
            pulumi.set(__self__, "name", name)

    @property
    @pulumi.getter
    def name(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The name of the SimpleDB domain
        """
        return pulumi.get(self, "name")

    @name.setter
    def name(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "name", value)


@pulumi.type_token("aws:simpledb/domain:Domain")
class Domain(pulumi.CustomResource):
    @overload
    def __init__(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 name: Optional[pulumi.Input[builtins.str]] = None,
                 __props__=None):
        """
        Provides a SimpleDB domain resource.

        !> **WARNING:** The `simpledb.Domain` resource has been deprecated and will be removed in a future version. Use Amazon DynamoDB instead.

        ## Example Usage

        ```python
        import pulumi
        import pulumi_aws as aws

        users = aws.simpledb.Domain("users", name="users")
        ```

        ## Import

        Using `pulumi import`, import SimpleDB Domains using the `name`. For example:

        ```sh
        $ pulumi import aws:simpledb/domain:Domain users users
        ```

        :param str resource_name: The name of the resource.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[builtins.str] name: The name of the SimpleDB domain
        """
        ...
    @overload
    def __init__(__self__,
                 resource_name: str,
                 args: Optional[DomainArgs] = None,
                 opts: Optional[pulumi.ResourceOptions] = None):
        """
        Provides a SimpleDB domain resource.

        !> **WARNING:** The `simpledb.Domain` resource has been deprecated and will be removed in a future version. Use Amazon DynamoDB instead.

        ## Example Usage

        ```python
        import pulumi
        import pulumi_aws as aws

        users = aws.simpledb.Domain("users", name="users")
        ```

        ## Import

        Using `pulumi import`, import SimpleDB Domains using the `name`. For example:

        ```sh
        $ pulumi import aws:simpledb/domain:Domain users users
        ```

        :param str resource_name: The name of the resource.
        :param DomainArgs args: The arguments to use to populate this resource's properties.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        ...
    def __init__(__self__, resource_name: str, *args, **kwargs):
        resource_args, opts = _utilities.get_resource_args_opts(DomainArgs, pulumi.ResourceOptions, *args, **kwargs)
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
            __props__ = DomainArgs.__new__(DomainArgs)

            __props__.__dict__["name"] = name
        super(Domain, __self__).__init__(
            'aws:simpledb/domain:Domain',
            resource_name,
            __props__,
            opts)

    @staticmethod
    def get(resource_name: str,
            id: pulumi.Input[str],
            opts: Optional[pulumi.ResourceOptions] = None,
            name: Optional[pulumi.Input[builtins.str]] = None) -> 'Domain':
        """
        Get an existing Domain resource's state with the given name, id, and optional extra
        properties used to qualify the lookup.

        :param str resource_name: The unique name of the resulting resource.
        :param pulumi.Input[str] id: The unique provider ID of the resource to lookup.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[builtins.str] name: The name of the SimpleDB domain
        """
        opts = pulumi.ResourceOptions.merge(opts, pulumi.ResourceOptions(id=id))

        __props__ = _DomainState.__new__(_DomainState)

        __props__.__dict__["name"] = name
        return Domain(resource_name, opts=opts, __props__=__props__)

    @property
    @pulumi.getter
    def name(self) -> pulumi.Output[builtins.str]:
        """
        The name of the SimpleDB domain
        """
        return pulumi.get(self, "name")

