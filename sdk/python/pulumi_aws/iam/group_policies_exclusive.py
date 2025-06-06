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

__all__ = ['GroupPoliciesExclusiveArgs', 'GroupPoliciesExclusive']

@pulumi.input_type
class GroupPoliciesExclusiveArgs:
    def __init__(__self__, *,
                 group_name: pulumi.Input[builtins.str],
                 policy_names: pulumi.Input[Sequence[pulumi.Input[builtins.str]]]):
        """
        The set of arguments for constructing a GroupPoliciesExclusive resource.
        :param pulumi.Input[builtins.str] group_name: IAM group name.
        :param pulumi.Input[Sequence[pulumi.Input[builtins.str]]] policy_names: A list of inline policy names to be assigned to the group. Policies attached to this group but not configured in this argument will be removed.
        """
        pulumi.set(__self__, "group_name", group_name)
        pulumi.set(__self__, "policy_names", policy_names)

    @property
    @pulumi.getter(name="groupName")
    def group_name(self) -> pulumi.Input[builtins.str]:
        """
        IAM group name.
        """
        return pulumi.get(self, "group_name")

    @group_name.setter
    def group_name(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "group_name", value)

    @property
    @pulumi.getter(name="policyNames")
    def policy_names(self) -> pulumi.Input[Sequence[pulumi.Input[builtins.str]]]:
        """
        A list of inline policy names to be assigned to the group. Policies attached to this group but not configured in this argument will be removed.
        """
        return pulumi.get(self, "policy_names")

    @policy_names.setter
    def policy_names(self, value: pulumi.Input[Sequence[pulumi.Input[builtins.str]]]):
        pulumi.set(self, "policy_names", value)


@pulumi.input_type
class _GroupPoliciesExclusiveState:
    def __init__(__self__, *,
                 group_name: Optional[pulumi.Input[builtins.str]] = None,
                 policy_names: Optional[pulumi.Input[Sequence[pulumi.Input[builtins.str]]]] = None):
        """
        Input properties used for looking up and filtering GroupPoliciesExclusive resources.
        :param pulumi.Input[builtins.str] group_name: IAM group name.
        :param pulumi.Input[Sequence[pulumi.Input[builtins.str]]] policy_names: A list of inline policy names to be assigned to the group. Policies attached to this group but not configured in this argument will be removed.
        """
        if group_name is not None:
            pulumi.set(__self__, "group_name", group_name)
        if policy_names is not None:
            pulumi.set(__self__, "policy_names", policy_names)

    @property
    @pulumi.getter(name="groupName")
    def group_name(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        IAM group name.
        """
        return pulumi.get(self, "group_name")

    @group_name.setter
    def group_name(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "group_name", value)

    @property
    @pulumi.getter(name="policyNames")
    def policy_names(self) -> Optional[pulumi.Input[Sequence[pulumi.Input[builtins.str]]]]:
        """
        A list of inline policy names to be assigned to the group. Policies attached to this group but not configured in this argument will be removed.
        """
        return pulumi.get(self, "policy_names")

    @policy_names.setter
    def policy_names(self, value: Optional[pulumi.Input[Sequence[pulumi.Input[builtins.str]]]]):
        pulumi.set(self, "policy_names", value)


@pulumi.type_token("aws:iam/groupPoliciesExclusive:GroupPoliciesExclusive")
class GroupPoliciesExclusive(pulumi.CustomResource):
    @overload
    def __init__(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 group_name: Optional[pulumi.Input[builtins.str]] = None,
                 policy_names: Optional[pulumi.Input[Sequence[pulumi.Input[builtins.str]]]] = None,
                 __props__=None):
        """
        ## Import

        Using `pulumi import`, import exclusive management of inline policy assignments using the `group_name`. For example:

        ```sh
        $ pulumi import aws:iam/groupPoliciesExclusive:GroupPoliciesExclusive example MyGroup
        ```

        :param str resource_name: The name of the resource.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[builtins.str] group_name: IAM group name.
        :param pulumi.Input[Sequence[pulumi.Input[builtins.str]]] policy_names: A list of inline policy names to be assigned to the group. Policies attached to this group but not configured in this argument will be removed.
        """
        ...
    @overload
    def __init__(__self__,
                 resource_name: str,
                 args: GroupPoliciesExclusiveArgs,
                 opts: Optional[pulumi.ResourceOptions] = None):
        """
        ## Import

        Using `pulumi import`, import exclusive management of inline policy assignments using the `group_name`. For example:

        ```sh
        $ pulumi import aws:iam/groupPoliciesExclusive:GroupPoliciesExclusive example MyGroup
        ```

        :param str resource_name: The name of the resource.
        :param GroupPoliciesExclusiveArgs args: The arguments to use to populate this resource's properties.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        ...
    def __init__(__self__, resource_name: str, *args, **kwargs):
        resource_args, opts = _utilities.get_resource_args_opts(GroupPoliciesExclusiveArgs, pulumi.ResourceOptions, *args, **kwargs)
        if resource_args is not None:
            __self__._internal_init(resource_name, opts, **resource_args.__dict__)
        else:
            __self__._internal_init(resource_name, *args, **kwargs)

    def _internal_init(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 group_name: Optional[pulumi.Input[builtins.str]] = None,
                 policy_names: Optional[pulumi.Input[Sequence[pulumi.Input[builtins.str]]]] = None,
                 __props__=None):
        opts = pulumi.ResourceOptions.merge(_utilities.get_resource_opts_defaults(), opts)
        if not isinstance(opts, pulumi.ResourceOptions):
            raise TypeError('Expected resource options to be a ResourceOptions instance')
        if opts.id is None:
            if __props__ is not None:
                raise TypeError('__props__ is only valid when passed in combination with a valid opts.id to get an existing resource')
            __props__ = GroupPoliciesExclusiveArgs.__new__(GroupPoliciesExclusiveArgs)

            if group_name is None and not opts.urn:
                raise TypeError("Missing required property 'group_name'")
            __props__.__dict__["group_name"] = group_name
            if policy_names is None and not opts.urn:
                raise TypeError("Missing required property 'policy_names'")
            __props__.__dict__["policy_names"] = policy_names
        super(GroupPoliciesExclusive, __self__).__init__(
            'aws:iam/groupPoliciesExclusive:GroupPoliciesExclusive',
            resource_name,
            __props__,
            opts)

    @staticmethod
    def get(resource_name: str,
            id: pulumi.Input[str],
            opts: Optional[pulumi.ResourceOptions] = None,
            group_name: Optional[pulumi.Input[builtins.str]] = None,
            policy_names: Optional[pulumi.Input[Sequence[pulumi.Input[builtins.str]]]] = None) -> 'GroupPoliciesExclusive':
        """
        Get an existing GroupPoliciesExclusive resource's state with the given name, id, and optional extra
        properties used to qualify the lookup.

        :param str resource_name: The unique name of the resulting resource.
        :param pulumi.Input[str] id: The unique provider ID of the resource to lookup.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[builtins.str] group_name: IAM group name.
        :param pulumi.Input[Sequence[pulumi.Input[builtins.str]]] policy_names: A list of inline policy names to be assigned to the group. Policies attached to this group but not configured in this argument will be removed.
        """
        opts = pulumi.ResourceOptions.merge(opts, pulumi.ResourceOptions(id=id))

        __props__ = _GroupPoliciesExclusiveState.__new__(_GroupPoliciesExclusiveState)

        __props__.__dict__["group_name"] = group_name
        __props__.__dict__["policy_names"] = policy_names
        return GroupPoliciesExclusive(resource_name, opts=opts, __props__=__props__)

    @property
    @pulumi.getter(name="groupName")
    def group_name(self) -> pulumi.Output[builtins.str]:
        """
        IAM group name.
        """
        return pulumi.get(self, "group_name")

    @property
    @pulumi.getter(name="policyNames")
    def policy_names(self) -> pulumi.Output[Sequence[builtins.str]]:
        """
        A list of inline policy names to be assigned to the group. Policies attached to this group but not configured in this argument will be removed.
        """
        return pulumi.get(self, "policy_names")

