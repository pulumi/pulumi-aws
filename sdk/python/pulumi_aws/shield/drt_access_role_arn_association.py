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

__all__ = ['DrtAccessRoleArnAssociationArgs', 'DrtAccessRoleArnAssociation']

@pulumi.input_type
class DrtAccessRoleArnAssociationArgs:
    def __init__(__self__, *,
                 role_arn: pulumi.Input[builtins.str],
                 timeouts: Optional[pulumi.Input['DrtAccessRoleArnAssociationTimeoutsArgs']] = None):
        """
        The set of arguments for constructing a DrtAccessRoleArnAssociation resource.
        :param pulumi.Input[builtins.str] role_arn: The Amazon Resource Name (ARN) of the role the SRT will use to access your AWS account. Prior to making the AssociateDRTRole request, you must attach the `AWSShieldDRTAccessPolicy` managed policy to this role.
        """
        pulumi.set(__self__, "role_arn", role_arn)
        if timeouts is not None:
            pulumi.set(__self__, "timeouts", timeouts)

    @property
    @pulumi.getter(name="roleArn")
    def role_arn(self) -> pulumi.Input[builtins.str]:
        """
        The Amazon Resource Name (ARN) of the role the SRT will use to access your AWS account. Prior to making the AssociateDRTRole request, you must attach the `AWSShieldDRTAccessPolicy` managed policy to this role.
        """
        return pulumi.get(self, "role_arn")

    @role_arn.setter
    def role_arn(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "role_arn", value)

    @property
    @pulumi.getter
    def timeouts(self) -> Optional[pulumi.Input['DrtAccessRoleArnAssociationTimeoutsArgs']]:
        return pulumi.get(self, "timeouts")

    @timeouts.setter
    def timeouts(self, value: Optional[pulumi.Input['DrtAccessRoleArnAssociationTimeoutsArgs']]):
        pulumi.set(self, "timeouts", value)


@pulumi.input_type
class _DrtAccessRoleArnAssociationState:
    def __init__(__self__, *,
                 role_arn: Optional[pulumi.Input[builtins.str]] = None,
                 timeouts: Optional[pulumi.Input['DrtAccessRoleArnAssociationTimeoutsArgs']] = None):
        """
        Input properties used for looking up and filtering DrtAccessRoleArnAssociation resources.
        :param pulumi.Input[builtins.str] role_arn: The Amazon Resource Name (ARN) of the role the SRT will use to access your AWS account. Prior to making the AssociateDRTRole request, you must attach the `AWSShieldDRTAccessPolicy` managed policy to this role.
        """
        if role_arn is not None:
            pulumi.set(__self__, "role_arn", role_arn)
        if timeouts is not None:
            pulumi.set(__self__, "timeouts", timeouts)

    @property
    @pulumi.getter(name="roleArn")
    def role_arn(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The Amazon Resource Name (ARN) of the role the SRT will use to access your AWS account. Prior to making the AssociateDRTRole request, you must attach the `AWSShieldDRTAccessPolicy` managed policy to this role.
        """
        return pulumi.get(self, "role_arn")

    @role_arn.setter
    def role_arn(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "role_arn", value)

    @property
    @pulumi.getter
    def timeouts(self) -> Optional[pulumi.Input['DrtAccessRoleArnAssociationTimeoutsArgs']]:
        return pulumi.get(self, "timeouts")

    @timeouts.setter
    def timeouts(self, value: Optional[pulumi.Input['DrtAccessRoleArnAssociationTimeoutsArgs']]):
        pulumi.set(self, "timeouts", value)


@pulumi.type_token("aws:shield/drtAccessRoleArnAssociation:DrtAccessRoleArnAssociation")
class DrtAccessRoleArnAssociation(pulumi.CustomResource):
    @overload
    def __init__(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 role_arn: Optional[pulumi.Input[builtins.str]] = None,
                 timeouts: Optional[pulumi.Input[Union['DrtAccessRoleArnAssociationTimeoutsArgs', 'DrtAccessRoleArnAssociationTimeoutsArgsDict']]] = None,
                 __props__=None):
        """
        Authorizes the Shield Response Team (SRT) using the specified role, to access your AWS account to assist with DDoS attack mitigation during potential attacks.
        For more information see [Configure AWS SRT Support](https://docs.aws.amazon.com/waf/latest/developerguide/authorize-srt.html)

        ## Example Usage

        ### Basic Usage

        ```python
        import pulumi
        import json
        import pulumi_aws as aws

        example_role = aws.iam.Role("example",
            name="example-role",
            assume_role_policy=json.dumps({
                "Version": "2012-10-17",
                "Statement": [{
                    "Sid": "",
                    "Effect": "Allow",
                    "Principal": {
                        "Service": "drt.shield.amazonaws.com",
                    },
                    "Action": "sts:AssumeRole",
                }],
            }))
        example = aws.shield.DrtAccessRoleArnAssociation("example", role_arn=example_role.arn)
        example_role_policy_attachment = aws.iam.RolePolicyAttachment("example",
            role=example_role.name,
            policy_arn="arn:aws:iam::aws:policy/service-role/AWSShieldDRTAccessPolicy")
        ```

        ## Import

        Using `pulumi import`, import Shield DRT access role ARN association using the AWS account ID. For example:

        ```sh
        $ pulumi import aws:shield/drtAccessRoleArnAssociation:DrtAccessRoleArnAssociation example 123456789012
        ```

        :param str resource_name: The name of the resource.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[builtins.str] role_arn: The Amazon Resource Name (ARN) of the role the SRT will use to access your AWS account. Prior to making the AssociateDRTRole request, you must attach the `AWSShieldDRTAccessPolicy` managed policy to this role.
        """
        ...
    @overload
    def __init__(__self__,
                 resource_name: str,
                 args: DrtAccessRoleArnAssociationArgs,
                 opts: Optional[pulumi.ResourceOptions] = None):
        """
        Authorizes the Shield Response Team (SRT) using the specified role, to access your AWS account to assist with DDoS attack mitigation during potential attacks.
        For more information see [Configure AWS SRT Support](https://docs.aws.amazon.com/waf/latest/developerguide/authorize-srt.html)

        ## Example Usage

        ### Basic Usage

        ```python
        import pulumi
        import json
        import pulumi_aws as aws

        example_role = aws.iam.Role("example",
            name="example-role",
            assume_role_policy=json.dumps({
                "Version": "2012-10-17",
                "Statement": [{
                    "Sid": "",
                    "Effect": "Allow",
                    "Principal": {
                        "Service": "drt.shield.amazonaws.com",
                    },
                    "Action": "sts:AssumeRole",
                }],
            }))
        example = aws.shield.DrtAccessRoleArnAssociation("example", role_arn=example_role.arn)
        example_role_policy_attachment = aws.iam.RolePolicyAttachment("example",
            role=example_role.name,
            policy_arn="arn:aws:iam::aws:policy/service-role/AWSShieldDRTAccessPolicy")
        ```

        ## Import

        Using `pulumi import`, import Shield DRT access role ARN association using the AWS account ID. For example:

        ```sh
        $ pulumi import aws:shield/drtAccessRoleArnAssociation:DrtAccessRoleArnAssociation example 123456789012
        ```

        :param str resource_name: The name of the resource.
        :param DrtAccessRoleArnAssociationArgs args: The arguments to use to populate this resource's properties.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        ...
    def __init__(__self__, resource_name: str, *args, **kwargs):
        resource_args, opts = _utilities.get_resource_args_opts(DrtAccessRoleArnAssociationArgs, pulumi.ResourceOptions, *args, **kwargs)
        if resource_args is not None:
            __self__._internal_init(resource_name, opts, **resource_args.__dict__)
        else:
            __self__._internal_init(resource_name, *args, **kwargs)

    def _internal_init(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 role_arn: Optional[pulumi.Input[builtins.str]] = None,
                 timeouts: Optional[pulumi.Input[Union['DrtAccessRoleArnAssociationTimeoutsArgs', 'DrtAccessRoleArnAssociationTimeoutsArgsDict']]] = None,
                 __props__=None):
        opts = pulumi.ResourceOptions.merge(_utilities.get_resource_opts_defaults(), opts)
        if not isinstance(opts, pulumi.ResourceOptions):
            raise TypeError('Expected resource options to be a ResourceOptions instance')
        if opts.id is None:
            if __props__ is not None:
                raise TypeError('__props__ is only valid when passed in combination with a valid opts.id to get an existing resource')
            __props__ = DrtAccessRoleArnAssociationArgs.__new__(DrtAccessRoleArnAssociationArgs)

            if role_arn is None and not opts.urn:
                raise TypeError("Missing required property 'role_arn'")
            __props__.__dict__["role_arn"] = role_arn
            __props__.__dict__["timeouts"] = timeouts
        super(DrtAccessRoleArnAssociation, __self__).__init__(
            'aws:shield/drtAccessRoleArnAssociation:DrtAccessRoleArnAssociation',
            resource_name,
            __props__,
            opts)

    @staticmethod
    def get(resource_name: str,
            id: pulumi.Input[str],
            opts: Optional[pulumi.ResourceOptions] = None,
            role_arn: Optional[pulumi.Input[builtins.str]] = None,
            timeouts: Optional[pulumi.Input[Union['DrtAccessRoleArnAssociationTimeoutsArgs', 'DrtAccessRoleArnAssociationTimeoutsArgsDict']]] = None) -> 'DrtAccessRoleArnAssociation':
        """
        Get an existing DrtAccessRoleArnAssociation resource's state with the given name, id, and optional extra
        properties used to qualify the lookup.

        :param str resource_name: The unique name of the resulting resource.
        :param pulumi.Input[str] id: The unique provider ID of the resource to lookup.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[builtins.str] role_arn: The Amazon Resource Name (ARN) of the role the SRT will use to access your AWS account. Prior to making the AssociateDRTRole request, you must attach the `AWSShieldDRTAccessPolicy` managed policy to this role.
        """
        opts = pulumi.ResourceOptions.merge(opts, pulumi.ResourceOptions(id=id))

        __props__ = _DrtAccessRoleArnAssociationState.__new__(_DrtAccessRoleArnAssociationState)

        __props__.__dict__["role_arn"] = role_arn
        __props__.__dict__["timeouts"] = timeouts
        return DrtAccessRoleArnAssociation(resource_name, opts=opts, __props__=__props__)

    @property
    @pulumi.getter(name="roleArn")
    def role_arn(self) -> pulumi.Output[builtins.str]:
        """
        The Amazon Resource Name (ARN) of the role the SRT will use to access your AWS account. Prior to making the AssociateDRTRole request, you must attach the `AWSShieldDRTAccessPolicy` managed policy to this role.
        """
        return pulumi.get(self, "role_arn")

    @property
    @pulumi.getter
    def timeouts(self) -> pulumi.Output[Optional['outputs.DrtAccessRoleArnAssociationTimeouts']]:
        return pulumi.get(self, "timeouts")

