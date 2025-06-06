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

__all__ = ['DelegatedAdministratorArgs', 'DelegatedAdministrator']

@pulumi.input_type
class DelegatedAdministratorArgs:
    def __init__(__self__, *,
                 account_id: pulumi.Input[builtins.str],
                 service_principal: pulumi.Input[builtins.str]):
        """
        The set of arguments for constructing a DelegatedAdministrator resource.
        :param pulumi.Input[builtins.str] account_id: The account ID number of the member account in the organization to register as a delegated administrator.
        :param pulumi.Input[builtins.str] service_principal: The service principal of the AWS service for which you want to make the member account a delegated administrator.
        """
        pulumi.set(__self__, "account_id", account_id)
        pulumi.set(__self__, "service_principal", service_principal)

    @property
    @pulumi.getter(name="accountId")
    def account_id(self) -> pulumi.Input[builtins.str]:
        """
        The account ID number of the member account in the organization to register as a delegated administrator.
        """
        return pulumi.get(self, "account_id")

    @account_id.setter
    def account_id(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "account_id", value)

    @property
    @pulumi.getter(name="servicePrincipal")
    def service_principal(self) -> pulumi.Input[builtins.str]:
        """
        The service principal of the AWS service for which you want to make the member account a delegated administrator.
        """
        return pulumi.get(self, "service_principal")

    @service_principal.setter
    def service_principal(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "service_principal", value)


@pulumi.input_type
class _DelegatedAdministratorState:
    def __init__(__self__, *,
                 account_id: Optional[pulumi.Input[builtins.str]] = None,
                 arn: Optional[pulumi.Input[builtins.str]] = None,
                 delegation_enabled_date: Optional[pulumi.Input[builtins.str]] = None,
                 email: Optional[pulumi.Input[builtins.str]] = None,
                 joined_method: Optional[pulumi.Input[builtins.str]] = None,
                 joined_timestamp: Optional[pulumi.Input[builtins.str]] = None,
                 name: Optional[pulumi.Input[builtins.str]] = None,
                 service_principal: Optional[pulumi.Input[builtins.str]] = None,
                 status: Optional[pulumi.Input[builtins.str]] = None):
        """
        Input properties used for looking up and filtering DelegatedAdministrator resources.
        :param pulumi.Input[builtins.str] account_id: The account ID number of the member account in the organization to register as a delegated administrator.
        :param pulumi.Input[builtins.str] arn: The Amazon Resource Name (ARN) of the delegated administrator's account.
        :param pulumi.Input[builtins.str] delegation_enabled_date: The date when the account was made a delegated administrator.
        :param pulumi.Input[builtins.str] email: The email address that is associated with the delegated administrator's AWS account.
        :param pulumi.Input[builtins.str] joined_method: The method by which the delegated administrator's account joined the organization.
        :param pulumi.Input[builtins.str] joined_timestamp: The date when the delegated administrator's account became a part of the organization.
        :param pulumi.Input[builtins.str] name: The friendly name of the delegated administrator's account.
        :param pulumi.Input[builtins.str] service_principal: The service principal of the AWS service for which you want to make the member account a delegated administrator.
        :param pulumi.Input[builtins.str] status: The status of the delegated administrator's account in the organization.
        """
        if account_id is not None:
            pulumi.set(__self__, "account_id", account_id)
        if arn is not None:
            pulumi.set(__self__, "arn", arn)
        if delegation_enabled_date is not None:
            pulumi.set(__self__, "delegation_enabled_date", delegation_enabled_date)
        if email is not None:
            pulumi.set(__self__, "email", email)
        if joined_method is not None:
            pulumi.set(__self__, "joined_method", joined_method)
        if joined_timestamp is not None:
            pulumi.set(__self__, "joined_timestamp", joined_timestamp)
        if name is not None:
            pulumi.set(__self__, "name", name)
        if service_principal is not None:
            pulumi.set(__self__, "service_principal", service_principal)
        if status is not None:
            pulumi.set(__self__, "status", status)

    @property
    @pulumi.getter(name="accountId")
    def account_id(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The account ID number of the member account in the organization to register as a delegated administrator.
        """
        return pulumi.get(self, "account_id")

    @account_id.setter
    def account_id(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "account_id", value)

    @property
    @pulumi.getter
    def arn(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The Amazon Resource Name (ARN) of the delegated administrator's account.
        """
        return pulumi.get(self, "arn")

    @arn.setter
    def arn(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "arn", value)

    @property
    @pulumi.getter(name="delegationEnabledDate")
    def delegation_enabled_date(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The date when the account was made a delegated administrator.
        """
        return pulumi.get(self, "delegation_enabled_date")

    @delegation_enabled_date.setter
    def delegation_enabled_date(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "delegation_enabled_date", value)

    @property
    @pulumi.getter
    def email(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The email address that is associated with the delegated administrator's AWS account.
        """
        return pulumi.get(self, "email")

    @email.setter
    def email(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "email", value)

    @property
    @pulumi.getter(name="joinedMethod")
    def joined_method(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The method by which the delegated administrator's account joined the organization.
        """
        return pulumi.get(self, "joined_method")

    @joined_method.setter
    def joined_method(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "joined_method", value)

    @property
    @pulumi.getter(name="joinedTimestamp")
    def joined_timestamp(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The date when the delegated administrator's account became a part of the organization.
        """
        return pulumi.get(self, "joined_timestamp")

    @joined_timestamp.setter
    def joined_timestamp(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "joined_timestamp", value)

    @property
    @pulumi.getter
    def name(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The friendly name of the delegated administrator's account.
        """
        return pulumi.get(self, "name")

    @name.setter
    def name(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "name", value)

    @property
    @pulumi.getter(name="servicePrincipal")
    def service_principal(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The service principal of the AWS service for which you want to make the member account a delegated administrator.
        """
        return pulumi.get(self, "service_principal")

    @service_principal.setter
    def service_principal(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "service_principal", value)

    @property
    @pulumi.getter
    def status(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The status of the delegated administrator's account in the organization.
        """
        return pulumi.get(self, "status")

    @status.setter
    def status(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "status", value)


@pulumi.type_token("aws:organizations/delegatedAdministrator:DelegatedAdministrator")
class DelegatedAdministrator(pulumi.CustomResource):
    @overload
    def __init__(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 account_id: Optional[pulumi.Input[builtins.str]] = None,
                 service_principal: Optional[pulumi.Input[builtins.str]] = None,
                 __props__=None):
        """
        Provides a resource to manage an [AWS Organizations Delegated Administrator](https://docs.aws.amazon.com/organizations/latest/APIReference/API_RegisterDelegatedAdministrator.html).

        ## Example Usage

        ```python
        import pulumi
        import pulumi_aws as aws

        example = aws.organizations.DelegatedAdministrator("example",
            account_id="123456789012",
            service_principal="principal")
        ```

        ## Import

        Using `pulumi import`, import `aws_organizations_delegated_administrator` using the account ID and its service principal. For example:

        ```sh
        $ pulumi import aws:organizations/delegatedAdministrator:DelegatedAdministrator example 123456789012/config.amazonaws.com
        ```

        :param str resource_name: The name of the resource.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[builtins.str] account_id: The account ID number of the member account in the organization to register as a delegated administrator.
        :param pulumi.Input[builtins.str] service_principal: The service principal of the AWS service for which you want to make the member account a delegated administrator.
        """
        ...
    @overload
    def __init__(__self__,
                 resource_name: str,
                 args: DelegatedAdministratorArgs,
                 opts: Optional[pulumi.ResourceOptions] = None):
        """
        Provides a resource to manage an [AWS Organizations Delegated Administrator](https://docs.aws.amazon.com/organizations/latest/APIReference/API_RegisterDelegatedAdministrator.html).

        ## Example Usage

        ```python
        import pulumi
        import pulumi_aws as aws

        example = aws.organizations.DelegatedAdministrator("example",
            account_id="123456789012",
            service_principal="principal")
        ```

        ## Import

        Using `pulumi import`, import `aws_organizations_delegated_administrator` using the account ID and its service principal. For example:

        ```sh
        $ pulumi import aws:organizations/delegatedAdministrator:DelegatedAdministrator example 123456789012/config.amazonaws.com
        ```

        :param str resource_name: The name of the resource.
        :param DelegatedAdministratorArgs args: The arguments to use to populate this resource's properties.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        ...
    def __init__(__self__, resource_name: str, *args, **kwargs):
        resource_args, opts = _utilities.get_resource_args_opts(DelegatedAdministratorArgs, pulumi.ResourceOptions, *args, **kwargs)
        if resource_args is not None:
            __self__._internal_init(resource_name, opts, **resource_args.__dict__)
        else:
            __self__._internal_init(resource_name, *args, **kwargs)

    def _internal_init(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 account_id: Optional[pulumi.Input[builtins.str]] = None,
                 service_principal: Optional[pulumi.Input[builtins.str]] = None,
                 __props__=None):
        opts = pulumi.ResourceOptions.merge(_utilities.get_resource_opts_defaults(), opts)
        if not isinstance(opts, pulumi.ResourceOptions):
            raise TypeError('Expected resource options to be a ResourceOptions instance')
        if opts.id is None:
            if __props__ is not None:
                raise TypeError('__props__ is only valid when passed in combination with a valid opts.id to get an existing resource')
            __props__ = DelegatedAdministratorArgs.__new__(DelegatedAdministratorArgs)

            if account_id is None and not opts.urn:
                raise TypeError("Missing required property 'account_id'")
            __props__.__dict__["account_id"] = account_id
            if service_principal is None and not opts.urn:
                raise TypeError("Missing required property 'service_principal'")
            __props__.__dict__["service_principal"] = service_principal
            __props__.__dict__["arn"] = None
            __props__.__dict__["delegation_enabled_date"] = None
            __props__.__dict__["email"] = None
            __props__.__dict__["joined_method"] = None
            __props__.__dict__["joined_timestamp"] = None
            __props__.__dict__["name"] = None
            __props__.__dict__["status"] = None
        super(DelegatedAdministrator, __self__).__init__(
            'aws:organizations/delegatedAdministrator:DelegatedAdministrator',
            resource_name,
            __props__,
            opts)

    @staticmethod
    def get(resource_name: str,
            id: pulumi.Input[str],
            opts: Optional[pulumi.ResourceOptions] = None,
            account_id: Optional[pulumi.Input[builtins.str]] = None,
            arn: Optional[pulumi.Input[builtins.str]] = None,
            delegation_enabled_date: Optional[pulumi.Input[builtins.str]] = None,
            email: Optional[pulumi.Input[builtins.str]] = None,
            joined_method: Optional[pulumi.Input[builtins.str]] = None,
            joined_timestamp: Optional[pulumi.Input[builtins.str]] = None,
            name: Optional[pulumi.Input[builtins.str]] = None,
            service_principal: Optional[pulumi.Input[builtins.str]] = None,
            status: Optional[pulumi.Input[builtins.str]] = None) -> 'DelegatedAdministrator':
        """
        Get an existing DelegatedAdministrator resource's state with the given name, id, and optional extra
        properties used to qualify the lookup.

        :param str resource_name: The unique name of the resulting resource.
        :param pulumi.Input[str] id: The unique provider ID of the resource to lookup.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[builtins.str] account_id: The account ID number of the member account in the organization to register as a delegated administrator.
        :param pulumi.Input[builtins.str] arn: The Amazon Resource Name (ARN) of the delegated administrator's account.
        :param pulumi.Input[builtins.str] delegation_enabled_date: The date when the account was made a delegated administrator.
        :param pulumi.Input[builtins.str] email: The email address that is associated with the delegated administrator's AWS account.
        :param pulumi.Input[builtins.str] joined_method: The method by which the delegated administrator's account joined the organization.
        :param pulumi.Input[builtins.str] joined_timestamp: The date when the delegated administrator's account became a part of the organization.
        :param pulumi.Input[builtins.str] name: The friendly name of the delegated administrator's account.
        :param pulumi.Input[builtins.str] service_principal: The service principal of the AWS service for which you want to make the member account a delegated administrator.
        :param pulumi.Input[builtins.str] status: The status of the delegated administrator's account in the organization.
        """
        opts = pulumi.ResourceOptions.merge(opts, pulumi.ResourceOptions(id=id))

        __props__ = _DelegatedAdministratorState.__new__(_DelegatedAdministratorState)

        __props__.__dict__["account_id"] = account_id
        __props__.__dict__["arn"] = arn
        __props__.__dict__["delegation_enabled_date"] = delegation_enabled_date
        __props__.__dict__["email"] = email
        __props__.__dict__["joined_method"] = joined_method
        __props__.__dict__["joined_timestamp"] = joined_timestamp
        __props__.__dict__["name"] = name
        __props__.__dict__["service_principal"] = service_principal
        __props__.__dict__["status"] = status
        return DelegatedAdministrator(resource_name, opts=opts, __props__=__props__)

    @property
    @pulumi.getter(name="accountId")
    def account_id(self) -> pulumi.Output[builtins.str]:
        """
        The account ID number of the member account in the organization to register as a delegated administrator.
        """
        return pulumi.get(self, "account_id")

    @property
    @pulumi.getter
    def arn(self) -> pulumi.Output[builtins.str]:
        """
        The Amazon Resource Name (ARN) of the delegated administrator's account.
        """
        return pulumi.get(self, "arn")

    @property
    @pulumi.getter(name="delegationEnabledDate")
    def delegation_enabled_date(self) -> pulumi.Output[builtins.str]:
        """
        The date when the account was made a delegated administrator.
        """
        return pulumi.get(self, "delegation_enabled_date")

    @property
    @pulumi.getter
    def email(self) -> pulumi.Output[builtins.str]:
        """
        The email address that is associated with the delegated administrator's AWS account.
        """
        return pulumi.get(self, "email")

    @property
    @pulumi.getter(name="joinedMethod")
    def joined_method(self) -> pulumi.Output[builtins.str]:
        """
        The method by which the delegated administrator's account joined the organization.
        """
        return pulumi.get(self, "joined_method")

    @property
    @pulumi.getter(name="joinedTimestamp")
    def joined_timestamp(self) -> pulumi.Output[builtins.str]:
        """
        The date when the delegated administrator's account became a part of the organization.
        """
        return pulumi.get(self, "joined_timestamp")

    @property
    @pulumi.getter
    def name(self) -> pulumi.Output[builtins.str]:
        """
        The friendly name of the delegated administrator's account.
        """
        return pulumi.get(self, "name")

    @property
    @pulumi.getter(name="servicePrincipal")
    def service_principal(self) -> pulumi.Output[builtins.str]:
        """
        The service principal of the AWS service for which you want to make the member account a delegated administrator.
        """
        return pulumi.get(self, "service_principal")

    @property
    @pulumi.getter
    def status(self) -> pulumi.Output[builtins.str]:
        """
        The status of the delegated administrator's account in the organization.
        """
        return pulumi.get(self, "status")

