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

__all__ = ['ServiceSpecificCredentialArgs', 'ServiceSpecificCredential']

@pulumi.input_type
class ServiceSpecificCredentialArgs:
    def __init__(__self__, *,
                 service_name: pulumi.Input[builtins.str],
                 user_name: pulumi.Input[builtins.str],
                 status: Optional[pulumi.Input[builtins.str]] = None):
        """
        The set of arguments for constructing a ServiceSpecificCredential resource.
        :param pulumi.Input[builtins.str] service_name: The name of the AWS service that is to be associated with the credentials. The service you specify here is the only service that can be accessed using these credentials.
        :param pulumi.Input[builtins.str] user_name: The name of the IAM user that is to be associated with the credentials. The new service-specific credentials have the same permissions as the associated user except that they can be used only to access the specified service.
        :param pulumi.Input[builtins.str] status: The status to be assigned to the service-specific credential. Valid values are `Active` and `Inactive`. Default value is `Active`.
        """
        pulumi.set(__self__, "service_name", service_name)
        pulumi.set(__self__, "user_name", user_name)
        if status is not None:
            pulumi.set(__self__, "status", status)

    @property
    @pulumi.getter(name="serviceName")
    def service_name(self) -> pulumi.Input[builtins.str]:
        """
        The name of the AWS service that is to be associated with the credentials. The service you specify here is the only service that can be accessed using these credentials.
        """
        return pulumi.get(self, "service_name")

    @service_name.setter
    def service_name(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "service_name", value)

    @property
    @pulumi.getter(name="userName")
    def user_name(self) -> pulumi.Input[builtins.str]:
        """
        The name of the IAM user that is to be associated with the credentials. The new service-specific credentials have the same permissions as the associated user except that they can be used only to access the specified service.
        """
        return pulumi.get(self, "user_name")

    @user_name.setter
    def user_name(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "user_name", value)

    @property
    @pulumi.getter
    def status(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The status to be assigned to the service-specific credential. Valid values are `Active` and `Inactive`. Default value is `Active`.
        """
        return pulumi.get(self, "status")

    @status.setter
    def status(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "status", value)


@pulumi.input_type
class _ServiceSpecificCredentialState:
    def __init__(__self__, *,
                 service_name: Optional[pulumi.Input[builtins.str]] = None,
                 service_password: Optional[pulumi.Input[builtins.str]] = None,
                 service_specific_credential_id: Optional[pulumi.Input[builtins.str]] = None,
                 service_user_name: Optional[pulumi.Input[builtins.str]] = None,
                 status: Optional[pulumi.Input[builtins.str]] = None,
                 user_name: Optional[pulumi.Input[builtins.str]] = None):
        """
        Input properties used for looking up and filtering ServiceSpecificCredential resources.
        :param pulumi.Input[builtins.str] service_name: The name of the AWS service that is to be associated with the credentials. The service you specify here is the only service that can be accessed using these credentials.
        :param pulumi.Input[builtins.str] service_password: The generated password for the service-specific credential.
        :param pulumi.Input[builtins.str] service_specific_credential_id: The unique identifier for the service-specific credential.
        :param pulumi.Input[builtins.str] service_user_name: The generated user name for the service-specific credential. This value is generated by combining the IAM user's name combined with the ID number of the AWS account, as in `jane-at-123456789012`, for example.
        :param pulumi.Input[builtins.str] status: The status to be assigned to the service-specific credential. Valid values are `Active` and `Inactive`. Default value is `Active`.
        :param pulumi.Input[builtins.str] user_name: The name of the IAM user that is to be associated with the credentials. The new service-specific credentials have the same permissions as the associated user except that they can be used only to access the specified service.
        """
        if service_name is not None:
            pulumi.set(__self__, "service_name", service_name)
        if service_password is not None:
            pulumi.set(__self__, "service_password", service_password)
        if service_specific_credential_id is not None:
            pulumi.set(__self__, "service_specific_credential_id", service_specific_credential_id)
        if service_user_name is not None:
            pulumi.set(__self__, "service_user_name", service_user_name)
        if status is not None:
            pulumi.set(__self__, "status", status)
        if user_name is not None:
            pulumi.set(__self__, "user_name", user_name)

    @property
    @pulumi.getter(name="serviceName")
    def service_name(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The name of the AWS service that is to be associated with the credentials. The service you specify here is the only service that can be accessed using these credentials.
        """
        return pulumi.get(self, "service_name")

    @service_name.setter
    def service_name(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "service_name", value)

    @property
    @pulumi.getter(name="servicePassword")
    def service_password(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The generated password for the service-specific credential.
        """
        return pulumi.get(self, "service_password")

    @service_password.setter
    def service_password(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "service_password", value)

    @property
    @pulumi.getter(name="serviceSpecificCredentialId")
    def service_specific_credential_id(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The unique identifier for the service-specific credential.
        """
        return pulumi.get(self, "service_specific_credential_id")

    @service_specific_credential_id.setter
    def service_specific_credential_id(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "service_specific_credential_id", value)

    @property
    @pulumi.getter(name="serviceUserName")
    def service_user_name(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The generated user name for the service-specific credential. This value is generated by combining the IAM user's name combined with the ID number of the AWS account, as in `jane-at-123456789012`, for example.
        """
        return pulumi.get(self, "service_user_name")

    @service_user_name.setter
    def service_user_name(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "service_user_name", value)

    @property
    @pulumi.getter
    def status(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The status to be assigned to the service-specific credential. Valid values are `Active` and `Inactive`. Default value is `Active`.
        """
        return pulumi.get(self, "status")

    @status.setter
    def status(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "status", value)

    @property
    @pulumi.getter(name="userName")
    def user_name(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The name of the IAM user that is to be associated with the credentials. The new service-specific credentials have the same permissions as the associated user except that they can be used only to access the specified service.
        """
        return pulumi.get(self, "user_name")

    @user_name.setter
    def user_name(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "user_name", value)


@pulumi.type_token("aws:iam/serviceSpecificCredential:ServiceSpecificCredential")
class ServiceSpecificCredential(pulumi.CustomResource):
    @overload
    def __init__(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 service_name: Optional[pulumi.Input[builtins.str]] = None,
                 status: Optional[pulumi.Input[builtins.str]] = None,
                 user_name: Optional[pulumi.Input[builtins.str]] = None,
                 __props__=None):
        """
        Provides an IAM Service Specific Credential.

        ## Example Usage

        ```python
        import pulumi
        import pulumi_aws as aws

        example = aws.iam.User("example", name="example")
        example_service_specific_credential = aws.iam.ServiceSpecificCredential("example",
            service_name="codecommit.amazonaws.com",
            user_name=example.name)
        ```

        ## Import

        Using `pulumi import`, import IAM Service Specific Credentials using the `service_name:user_name:service_specific_credential_id`. For example:

        ```sh
        $ pulumi import aws:iam/serviceSpecificCredential:ServiceSpecificCredential default `codecommit.amazonaws.com:example:some-id`
        ```

        :param str resource_name: The name of the resource.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[builtins.str] service_name: The name of the AWS service that is to be associated with the credentials. The service you specify here is the only service that can be accessed using these credentials.
        :param pulumi.Input[builtins.str] status: The status to be assigned to the service-specific credential. Valid values are `Active` and `Inactive`. Default value is `Active`.
        :param pulumi.Input[builtins.str] user_name: The name of the IAM user that is to be associated with the credentials. The new service-specific credentials have the same permissions as the associated user except that they can be used only to access the specified service.
        """
        ...
    @overload
    def __init__(__self__,
                 resource_name: str,
                 args: ServiceSpecificCredentialArgs,
                 opts: Optional[pulumi.ResourceOptions] = None):
        """
        Provides an IAM Service Specific Credential.

        ## Example Usage

        ```python
        import pulumi
        import pulumi_aws as aws

        example = aws.iam.User("example", name="example")
        example_service_specific_credential = aws.iam.ServiceSpecificCredential("example",
            service_name="codecommit.amazonaws.com",
            user_name=example.name)
        ```

        ## Import

        Using `pulumi import`, import IAM Service Specific Credentials using the `service_name:user_name:service_specific_credential_id`. For example:

        ```sh
        $ pulumi import aws:iam/serviceSpecificCredential:ServiceSpecificCredential default `codecommit.amazonaws.com:example:some-id`
        ```

        :param str resource_name: The name of the resource.
        :param ServiceSpecificCredentialArgs args: The arguments to use to populate this resource's properties.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        ...
    def __init__(__self__, resource_name: str, *args, **kwargs):
        resource_args, opts = _utilities.get_resource_args_opts(ServiceSpecificCredentialArgs, pulumi.ResourceOptions, *args, **kwargs)
        if resource_args is not None:
            __self__._internal_init(resource_name, opts, **resource_args.__dict__)
        else:
            __self__._internal_init(resource_name, *args, **kwargs)

    def _internal_init(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 service_name: Optional[pulumi.Input[builtins.str]] = None,
                 status: Optional[pulumi.Input[builtins.str]] = None,
                 user_name: Optional[pulumi.Input[builtins.str]] = None,
                 __props__=None):
        opts = pulumi.ResourceOptions.merge(_utilities.get_resource_opts_defaults(), opts)
        if not isinstance(opts, pulumi.ResourceOptions):
            raise TypeError('Expected resource options to be a ResourceOptions instance')
        if opts.id is None:
            if __props__ is not None:
                raise TypeError('__props__ is only valid when passed in combination with a valid opts.id to get an existing resource')
            __props__ = ServiceSpecificCredentialArgs.__new__(ServiceSpecificCredentialArgs)

            if service_name is None and not opts.urn:
                raise TypeError("Missing required property 'service_name'")
            __props__.__dict__["service_name"] = service_name
            __props__.__dict__["status"] = status
            if user_name is None and not opts.urn:
                raise TypeError("Missing required property 'user_name'")
            __props__.__dict__["user_name"] = user_name
            __props__.__dict__["service_password"] = None
            __props__.__dict__["service_specific_credential_id"] = None
            __props__.__dict__["service_user_name"] = None
        secret_opts = pulumi.ResourceOptions(additional_secret_outputs=["servicePassword"])
        opts = pulumi.ResourceOptions.merge(opts, secret_opts)
        super(ServiceSpecificCredential, __self__).__init__(
            'aws:iam/serviceSpecificCredential:ServiceSpecificCredential',
            resource_name,
            __props__,
            opts)

    @staticmethod
    def get(resource_name: str,
            id: pulumi.Input[str],
            opts: Optional[pulumi.ResourceOptions] = None,
            service_name: Optional[pulumi.Input[builtins.str]] = None,
            service_password: Optional[pulumi.Input[builtins.str]] = None,
            service_specific_credential_id: Optional[pulumi.Input[builtins.str]] = None,
            service_user_name: Optional[pulumi.Input[builtins.str]] = None,
            status: Optional[pulumi.Input[builtins.str]] = None,
            user_name: Optional[pulumi.Input[builtins.str]] = None) -> 'ServiceSpecificCredential':
        """
        Get an existing ServiceSpecificCredential resource's state with the given name, id, and optional extra
        properties used to qualify the lookup.

        :param str resource_name: The unique name of the resulting resource.
        :param pulumi.Input[str] id: The unique provider ID of the resource to lookup.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[builtins.str] service_name: The name of the AWS service that is to be associated with the credentials. The service you specify here is the only service that can be accessed using these credentials.
        :param pulumi.Input[builtins.str] service_password: The generated password for the service-specific credential.
        :param pulumi.Input[builtins.str] service_specific_credential_id: The unique identifier for the service-specific credential.
        :param pulumi.Input[builtins.str] service_user_name: The generated user name for the service-specific credential. This value is generated by combining the IAM user's name combined with the ID number of the AWS account, as in `jane-at-123456789012`, for example.
        :param pulumi.Input[builtins.str] status: The status to be assigned to the service-specific credential. Valid values are `Active` and `Inactive`. Default value is `Active`.
        :param pulumi.Input[builtins.str] user_name: The name of the IAM user that is to be associated with the credentials. The new service-specific credentials have the same permissions as the associated user except that they can be used only to access the specified service.
        """
        opts = pulumi.ResourceOptions.merge(opts, pulumi.ResourceOptions(id=id))

        __props__ = _ServiceSpecificCredentialState.__new__(_ServiceSpecificCredentialState)

        __props__.__dict__["service_name"] = service_name
        __props__.__dict__["service_password"] = service_password
        __props__.__dict__["service_specific_credential_id"] = service_specific_credential_id
        __props__.__dict__["service_user_name"] = service_user_name
        __props__.__dict__["status"] = status
        __props__.__dict__["user_name"] = user_name
        return ServiceSpecificCredential(resource_name, opts=opts, __props__=__props__)

    @property
    @pulumi.getter(name="serviceName")
    def service_name(self) -> pulumi.Output[builtins.str]:
        """
        The name of the AWS service that is to be associated with the credentials. The service you specify here is the only service that can be accessed using these credentials.
        """
        return pulumi.get(self, "service_name")

    @property
    @pulumi.getter(name="servicePassword")
    def service_password(self) -> pulumi.Output[builtins.str]:
        """
        The generated password for the service-specific credential.
        """
        return pulumi.get(self, "service_password")

    @property
    @pulumi.getter(name="serviceSpecificCredentialId")
    def service_specific_credential_id(self) -> pulumi.Output[builtins.str]:
        """
        The unique identifier for the service-specific credential.
        """
        return pulumi.get(self, "service_specific_credential_id")

    @property
    @pulumi.getter(name="serviceUserName")
    def service_user_name(self) -> pulumi.Output[builtins.str]:
        """
        The generated user name for the service-specific credential. This value is generated by combining the IAM user's name combined with the ID number of the AWS account, as in `jane-at-123456789012`, for example.
        """
        return pulumi.get(self, "service_user_name")

    @property
    @pulumi.getter
    def status(self) -> pulumi.Output[Optional[builtins.str]]:
        """
        The status to be assigned to the service-specific credential. Valid values are `Active` and `Inactive`. Default value is `Active`.
        """
        return pulumi.get(self, "status")

    @property
    @pulumi.getter(name="userName")
    def user_name(self) -> pulumi.Output[builtins.str]:
        """
        The name of the IAM user that is to be associated with the credentials. The new service-specific credentials have the same permissions as the associated user except that they can be used only to access the specified service.
        """
        return pulumi.get(self, "user_name")

