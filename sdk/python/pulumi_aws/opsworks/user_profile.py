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

__all__ = ['UserProfileArgs', 'UserProfile']

@pulumi.input_type
class UserProfileArgs:
    def __init__(__self__, *,
                 ssh_username: pulumi.Input[builtins.str],
                 user_arn: pulumi.Input[builtins.str],
                 allow_self_management: Optional[pulumi.Input[builtins.bool]] = None,
                 ssh_public_key: Optional[pulumi.Input[builtins.str]] = None):
        """
        The set of arguments for constructing a UserProfile resource.
        :param pulumi.Input[builtins.str] ssh_username: The ssh username, with witch this user wants to log in
        :param pulumi.Input[builtins.str] user_arn: The user's IAM ARN
        :param pulumi.Input[builtins.bool] allow_self_management: Whether users can specify their own SSH public key through the My Settings page
        :param pulumi.Input[builtins.str] ssh_public_key: The users public key
        """
        pulumi.set(__self__, "ssh_username", ssh_username)
        pulumi.set(__self__, "user_arn", user_arn)
        if allow_self_management is not None:
            pulumi.set(__self__, "allow_self_management", allow_self_management)
        if ssh_public_key is not None:
            pulumi.set(__self__, "ssh_public_key", ssh_public_key)

    @property
    @pulumi.getter(name="sshUsername")
    def ssh_username(self) -> pulumi.Input[builtins.str]:
        """
        The ssh username, with witch this user wants to log in
        """
        return pulumi.get(self, "ssh_username")

    @ssh_username.setter
    def ssh_username(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "ssh_username", value)

    @property
    @pulumi.getter(name="userArn")
    def user_arn(self) -> pulumi.Input[builtins.str]:
        """
        The user's IAM ARN
        """
        return pulumi.get(self, "user_arn")

    @user_arn.setter
    def user_arn(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "user_arn", value)

    @property
    @pulumi.getter(name="allowSelfManagement")
    def allow_self_management(self) -> Optional[pulumi.Input[builtins.bool]]:
        """
        Whether users can specify their own SSH public key through the My Settings page
        """
        return pulumi.get(self, "allow_self_management")

    @allow_self_management.setter
    def allow_self_management(self, value: Optional[pulumi.Input[builtins.bool]]):
        pulumi.set(self, "allow_self_management", value)

    @property
    @pulumi.getter(name="sshPublicKey")
    def ssh_public_key(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The users public key
        """
        return pulumi.get(self, "ssh_public_key")

    @ssh_public_key.setter
    def ssh_public_key(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "ssh_public_key", value)


@pulumi.input_type
class _UserProfileState:
    def __init__(__self__, *,
                 allow_self_management: Optional[pulumi.Input[builtins.bool]] = None,
                 ssh_public_key: Optional[pulumi.Input[builtins.str]] = None,
                 ssh_username: Optional[pulumi.Input[builtins.str]] = None,
                 user_arn: Optional[pulumi.Input[builtins.str]] = None):
        """
        Input properties used for looking up and filtering UserProfile resources.
        :param pulumi.Input[builtins.bool] allow_self_management: Whether users can specify their own SSH public key through the My Settings page
        :param pulumi.Input[builtins.str] ssh_public_key: The users public key
        :param pulumi.Input[builtins.str] ssh_username: The ssh username, with witch this user wants to log in
        :param pulumi.Input[builtins.str] user_arn: The user's IAM ARN
        """
        if allow_self_management is not None:
            pulumi.set(__self__, "allow_self_management", allow_self_management)
        if ssh_public_key is not None:
            pulumi.set(__self__, "ssh_public_key", ssh_public_key)
        if ssh_username is not None:
            pulumi.set(__self__, "ssh_username", ssh_username)
        if user_arn is not None:
            pulumi.set(__self__, "user_arn", user_arn)

    @property
    @pulumi.getter(name="allowSelfManagement")
    def allow_self_management(self) -> Optional[pulumi.Input[builtins.bool]]:
        """
        Whether users can specify their own SSH public key through the My Settings page
        """
        return pulumi.get(self, "allow_self_management")

    @allow_self_management.setter
    def allow_self_management(self, value: Optional[pulumi.Input[builtins.bool]]):
        pulumi.set(self, "allow_self_management", value)

    @property
    @pulumi.getter(name="sshPublicKey")
    def ssh_public_key(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The users public key
        """
        return pulumi.get(self, "ssh_public_key")

    @ssh_public_key.setter
    def ssh_public_key(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "ssh_public_key", value)

    @property
    @pulumi.getter(name="sshUsername")
    def ssh_username(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The ssh username, with witch this user wants to log in
        """
        return pulumi.get(self, "ssh_username")

    @ssh_username.setter
    def ssh_username(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "ssh_username", value)

    @property
    @pulumi.getter(name="userArn")
    def user_arn(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The user's IAM ARN
        """
        return pulumi.get(self, "user_arn")

    @user_arn.setter
    def user_arn(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "user_arn", value)


@pulumi.type_token("aws:opsworks/userProfile:UserProfile")
class UserProfile(pulumi.CustomResource):
    @overload
    def __init__(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 allow_self_management: Optional[pulumi.Input[builtins.bool]] = None,
                 ssh_public_key: Optional[pulumi.Input[builtins.str]] = None,
                 ssh_username: Optional[pulumi.Input[builtins.str]] = None,
                 user_arn: Optional[pulumi.Input[builtins.str]] = None,
                 __props__=None):
        """
        ## Example Usage

        ```python
        import pulumi
        import pulumi_aws as aws

        my_profile = aws.opsworks.UserProfile("my_profile",
            user_arn=user["arn"],
            ssh_username="my_user")
        ```

        :param str resource_name: The name of the resource.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[builtins.bool] allow_self_management: Whether users can specify their own SSH public key through the My Settings page
        :param pulumi.Input[builtins.str] ssh_public_key: The users public key
        :param pulumi.Input[builtins.str] ssh_username: The ssh username, with witch this user wants to log in
        :param pulumi.Input[builtins.str] user_arn: The user's IAM ARN
        """
        ...
    @overload
    def __init__(__self__,
                 resource_name: str,
                 args: UserProfileArgs,
                 opts: Optional[pulumi.ResourceOptions] = None):
        """
        ## Example Usage

        ```python
        import pulumi
        import pulumi_aws as aws

        my_profile = aws.opsworks.UserProfile("my_profile",
            user_arn=user["arn"],
            ssh_username="my_user")
        ```

        :param str resource_name: The name of the resource.
        :param UserProfileArgs args: The arguments to use to populate this resource's properties.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        ...
    def __init__(__self__, resource_name: str, *args, **kwargs):
        resource_args, opts = _utilities.get_resource_args_opts(UserProfileArgs, pulumi.ResourceOptions, *args, **kwargs)
        if resource_args is not None:
            __self__._internal_init(resource_name, opts, **resource_args.__dict__)
        else:
            __self__._internal_init(resource_name, *args, **kwargs)

    def _internal_init(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 allow_self_management: Optional[pulumi.Input[builtins.bool]] = None,
                 ssh_public_key: Optional[pulumi.Input[builtins.str]] = None,
                 ssh_username: Optional[pulumi.Input[builtins.str]] = None,
                 user_arn: Optional[pulumi.Input[builtins.str]] = None,
                 __props__=None):
        opts = pulumi.ResourceOptions.merge(_utilities.get_resource_opts_defaults(), opts)
        if not isinstance(opts, pulumi.ResourceOptions):
            raise TypeError('Expected resource options to be a ResourceOptions instance')
        if opts.id is None:
            if __props__ is not None:
                raise TypeError('__props__ is only valid when passed in combination with a valid opts.id to get an existing resource')
            __props__ = UserProfileArgs.__new__(UserProfileArgs)

            __props__.__dict__["allow_self_management"] = allow_self_management
            __props__.__dict__["ssh_public_key"] = ssh_public_key
            if ssh_username is None and not opts.urn:
                raise TypeError("Missing required property 'ssh_username'")
            __props__.__dict__["ssh_username"] = ssh_username
            if user_arn is None and not opts.urn:
                raise TypeError("Missing required property 'user_arn'")
            __props__.__dict__["user_arn"] = user_arn
        super(UserProfile, __self__).__init__(
            'aws:opsworks/userProfile:UserProfile',
            resource_name,
            __props__,
            opts)

    @staticmethod
    def get(resource_name: str,
            id: pulumi.Input[str],
            opts: Optional[pulumi.ResourceOptions] = None,
            allow_self_management: Optional[pulumi.Input[builtins.bool]] = None,
            ssh_public_key: Optional[pulumi.Input[builtins.str]] = None,
            ssh_username: Optional[pulumi.Input[builtins.str]] = None,
            user_arn: Optional[pulumi.Input[builtins.str]] = None) -> 'UserProfile':
        """
        Get an existing UserProfile resource's state with the given name, id, and optional extra
        properties used to qualify the lookup.

        :param str resource_name: The unique name of the resulting resource.
        :param pulumi.Input[str] id: The unique provider ID of the resource to lookup.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[builtins.bool] allow_self_management: Whether users can specify their own SSH public key through the My Settings page
        :param pulumi.Input[builtins.str] ssh_public_key: The users public key
        :param pulumi.Input[builtins.str] ssh_username: The ssh username, with witch this user wants to log in
        :param pulumi.Input[builtins.str] user_arn: The user's IAM ARN
        """
        opts = pulumi.ResourceOptions.merge(opts, pulumi.ResourceOptions(id=id))

        __props__ = _UserProfileState.__new__(_UserProfileState)

        __props__.__dict__["allow_self_management"] = allow_self_management
        __props__.__dict__["ssh_public_key"] = ssh_public_key
        __props__.__dict__["ssh_username"] = ssh_username
        __props__.__dict__["user_arn"] = user_arn
        return UserProfile(resource_name, opts=opts, __props__=__props__)

    @property
    @pulumi.getter(name="allowSelfManagement")
    def allow_self_management(self) -> pulumi.Output[Optional[builtins.bool]]:
        """
        Whether users can specify their own SSH public key through the My Settings page
        """
        return pulumi.get(self, "allow_self_management")

    @property
    @pulumi.getter(name="sshPublicKey")
    def ssh_public_key(self) -> pulumi.Output[Optional[builtins.str]]:
        """
        The users public key
        """
        return pulumi.get(self, "ssh_public_key")

    @property
    @pulumi.getter(name="sshUsername")
    def ssh_username(self) -> pulumi.Output[builtins.str]:
        """
        The ssh username, with witch this user wants to log in
        """
        return pulumi.get(self, "ssh_username")

    @property
    @pulumi.getter(name="userArn")
    def user_arn(self) -> pulumi.Output[builtins.str]:
        """
        The user's IAM ARN
        """
        return pulumi.get(self, "user_arn")

