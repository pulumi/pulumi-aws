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

__all__ = ['CidrLocationArgs', 'CidrLocation']

@pulumi.input_type
class CidrLocationArgs:
    def __init__(__self__, *,
                 cidr_blocks: pulumi.Input[Sequence[pulumi.Input[builtins.str]]],
                 cidr_collection_id: pulumi.Input[builtins.str],
                 name: Optional[pulumi.Input[builtins.str]] = None):
        """
        The set of arguments for constructing a CidrLocation resource.
        :param pulumi.Input[Sequence[pulumi.Input[builtins.str]]] cidr_blocks: CIDR blocks for the location.
        :param pulumi.Input[builtins.str] cidr_collection_id: The ID of the CIDR collection to update.
        :param pulumi.Input[builtins.str] name: Name for the CIDR location.
        """
        pulumi.set(__self__, "cidr_blocks", cidr_blocks)
        pulumi.set(__self__, "cidr_collection_id", cidr_collection_id)
        if name is not None:
            pulumi.set(__self__, "name", name)

    @property
    @pulumi.getter(name="cidrBlocks")
    def cidr_blocks(self) -> pulumi.Input[Sequence[pulumi.Input[builtins.str]]]:
        """
        CIDR blocks for the location.
        """
        return pulumi.get(self, "cidr_blocks")

    @cidr_blocks.setter
    def cidr_blocks(self, value: pulumi.Input[Sequence[pulumi.Input[builtins.str]]]):
        pulumi.set(self, "cidr_blocks", value)

    @property
    @pulumi.getter(name="cidrCollectionId")
    def cidr_collection_id(self) -> pulumi.Input[builtins.str]:
        """
        The ID of the CIDR collection to update.
        """
        return pulumi.get(self, "cidr_collection_id")

    @cidr_collection_id.setter
    def cidr_collection_id(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "cidr_collection_id", value)

    @property
    @pulumi.getter
    def name(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Name for the CIDR location.
        """
        return pulumi.get(self, "name")

    @name.setter
    def name(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "name", value)


@pulumi.input_type
class _CidrLocationState:
    def __init__(__self__, *,
                 cidr_blocks: Optional[pulumi.Input[Sequence[pulumi.Input[builtins.str]]]] = None,
                 cidr_collection_id: Optional[pulumi.Input[builtins.str]] = None,
                 name: Optional[pulumi.Input[builtins.str]] = None):
        """
        Input properties used for looking up and filtering CidrLocation resources.
        :param pulumi.Input[Sequence[pulumi.Input[builtins.str]]] cidr_blocks: CIDR blocks for the location.
        :param pulumi.Input[builtins.str] cidr_collection_id: The ID of the CIDR collection to update.
        :param pulumi.Input[builtins.str] name: Name for the CIDR location.
        """
        if cidr_blocks is not None:
            pulumi.set(__self__, "cidr_blocks", cidr_blocks)
        if cidr_collection_id is not None:
            pulumi.set(__self__, "cidr_collection_id", cidr_collection_id)
        if name is not None:
            pulumi.set(__self__, "name", name)

    @property
    @pulumi.getter(name="cidrBlocks")
    def cidr_blocks(self) -> Optional[pulumi.Input[Sequence[pulumi.Input[builtins.str]]]]:
        """
        CIDR blocks for the location.
        """
        return pulumi.get(self, "cidr_blocks")

    @cidr_blocks.setter
    def cidr_blocks(self, value: Optional[pulumi.Input[Sequence[pulumi.Input[builtins.str]]]]):
        pulumi.set(self, "cidr_blocks", value)

    @property
    @pulumi.getter(name="cidrCollectionId")
    def cidr_collection_id(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The ID of the CIDR collection to update.
        """
        return pulumi.get(self, "cidr_collection_id")

    @cidr_collection_id.setter
    def cidr_collection_id(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "cidr_collection_id", value)

    @property
    @pulumi.getter
    def name(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Name for the CIDR location.
        """
        return pulumi.get(self, "name")

    @name.setter
    def name(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "name", value)


@pulumi.type_token("aws:route53/cidrLocation:CidrLocation")
class CidrLocation(pulumi.CustomResource):
    @overload
    def __init__(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 cidr_blocks: Optional[pulumi.Input[Sequence[pulumi.Input[builtins.str]]]] = None,
                 cidr_collection_id: Optional[pulumi.Input[builtins.str]] = None,
                 name: Optional[pulumi.Input[builtins.str]] = None,
                 __props__=None):
        """
        Provides a Route53 CIDR location resource.

        ## Example Usage

        ```python
        import pulumi
        import pulumi_aws as aws

        example = aws.route53.CidrCollection("example", name="collection-1")
        example_cidr_location = aws.route53.CidrLocation("example",
            cidr_collection_id=example.id,
            name="office",
            cidr_blocks=[
                "200.5.3.0/24",
                "200.6.3.0/24",
            ])
        ```

        ## Import

        Using `pulumi import`, import CIDR locations using their the CIDR collection ID and location name. For example:

        ```sh
        $ pulumi import aws:route53/cidrLocation:CidrLocation example 9ac32814-3e67-0932-6048-8d779cc6f511,office
        ```

        :param str resource_name: The name of the resource.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[Sequence[pulumi.Input[builtins.str]]] cidr_blocks: CIDR blocks for the location.
        :param pulumi.Input[builtins.str] cidr_collection_id: The ID of the CIDR collection to update.
        :param pulumi.Input[builtins.str] name: Name for the CIDR location.
        """
        ...
    @overload
    def __init__(__self__,
                 resource_name: str,
                 args: CidrLocationArgs,
                 opts: Optional[pulumi.ResourceOptions] = None):
        """
        Provides a Route53 CIDR location resource.

        ## Example Usage

        ```python
        import pulumi
        import pulumi_aws as aws

        example = aws.route53.CidrCollection("example", name="collection-1")
        example_cidr_location = aws.route53.CidrLocation("example",
            cidr_collection_id=example.id,
            name="office",
            cidr_blocks=[
                "200.5.3.0/24",
                "200.6.3.0/24",
            ])
        ```

        ## Import

        Using `pulumi import`, import CIDR locations using their the CIDR collection ID and location name. For example:

        ```sh
        $ pulumi import aws:route53/cidrLocation:CidrLocation example 9ac32814-3e67-0932-6048-8d779cc6f511,office
        ```

        :param str resource_name: The name of the resource.
        :param CidrLocationArgs args: The arguments to use to populate this resource's properties.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        ...
    def __init__(__self__, resource_name: str, *args, **kwargs):
        resource_args, opts = _utilities.get_resource_args_opts(CidrLocationArgs, pulumi.ResourceOptions, *args, **kwargs)
        if resource_args is not None:
            __self__._internal_init(resource_name, opts, **resource_args.__dict__)
        else:
            __self__._internal_init(resource_name, *args, **kwargs)

    def _internal_init(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 cidr_blocks: Optional[pulumi.Input[Sequence[pulumi.Input[builtins.str]]]] = None,
                 cidr_collection_id: Optional[pulumi.Input[builtins.str]] = None,
                 name: Optional[pulumi.Input[builtins.str]] = None,
                 __props__=None):
        opts = pulumi.ResourceOptions.merge(_utilities.get_resource_opts_defaults(), opts)
        if not isinstance(opts, pulumi.ResourceOptions):
            raise TypeError('Expected resource options to be a ResourceOptions instance')
        if opts.id is None:
            if __props__ is not None:
                raise TypeError('__props__ is only valid when passed in combination with a valid opts.id to get an existing resource')
            __props__ = CidrLocationArgs.__new__(CidrLocationArgs)

            if cidr_blocks is None and not opts.urn:
                raise TypeError("Missing required property 'cidr_blocks'")
            __props__.__dict__["cidr_blocks"] = cidr_blocks
            if cidr_collection_id is None and not opts.urn:
                raise TypeError("Missing required property 'cidr_collection_id'")
            __props__.__dict__["cidr_collection_id"] = cidr_collection_id
            __props__.__dict__["name"] = name
        super(CidrLocation, __self__).__init__(
            'aws:route53/cidrLocation:CidrLocation',
            resource_name,
            __props__,
            opts)

    @staticmethod
    def get(resource_name: str,
            id: pulumi.Input[str],
            opts: Optional[pulumi.ResourceOptions] = None,
            cidr_blocks: Optional[pulumi.Input[Sequence[pulumi.Input[builtins.str]]]] = None,
            cidr_collection_id: Optional[pulumi.Input[builtins.str]] = None,
            name: Optional[pulumi.Input[builtins.str]] = None) -> 'CidrLocation':
        """
        Get an existing CidrLocation resource's state with the given name, id, and optional extra
        properties used to qualify the lookup.

        :param str resource_name: The unique name of the resulting resource.
        :param pulumi.Input[str] id: The unique provider ID of the resource to lookup.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[Sequence[pulumi.Input[builtins.str]]] cidr_blocks: CIDR blocks for the location.
        :param pulumi.Input[builtins.str] cidr_collection_id: The ID of the CIDR collection to update.
        :param pulumi.Input[builtins.str] name: Name for the CIDR location.
        """
        opts = pulumi.ResourceOptions.merge(opts, pulumi.ResourceOptions(id=id))

        __props__ = _CidrLocationState.__new__(_CidrLocationState)

        __props__.__dict__["cidr_blocks"] = cidr_blocks
        __props__.__dict__["cidr_collection_id"] = cidr_collection_id
        __props__.__dict__["name"] = name
        return CidrLocation(resource_name, opts=opts, __props__=__props__)

    @property
    @pulumi.getter(name="cidrBlocks")
    def cidr_blocks(self) -> pulumi.Output[Sequence[builtins.str]]:
        """
        CIDR blocks for the location.
        """
        return pulumi.get(self, "cidr_blocks")

    @property
    @pulumi.getter(name="cidrCollectionId")
    def cidr_collection_id(self) -> pulumi.Output[builtins.str]:
        """
        The ID of the CIDR collection to update.
        """
        return pulumi.get(self, "cidr_collection_id")

    @property
    @pulumi.getter
    def name(self) -> pulumi.Output[builtins.str]:
        """
        Name for the CIDR location.
        """
        return pulumi.get(self, "name")

