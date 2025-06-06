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

__all__ = [
    'GetDelegatedServicesResult',
    'AwaitableGetDelegatedServicesResult',
    'get_delegated_services',
    'get_delegated_services_output',
]

@pulumi.output_type
class GetDelegatedServicesResult:
    """
    A collection of values returned by getDelegatedServices.
    """
    def __init__(__self__, account_id=None, delegated_services=None, id=None):
        if account_id and not isinstance(account_id, str):
            raise TypeError("Expected argument 'account_id' to be a str")
        pulumi.set(__self__, "account_id", account_id)
        if delegated_services and not isinstance(delegated_services, list):
            raise TypeError("Expected argument 'delegated_services' to be a list")
        pulumi.set(__self__, "delegated_services", delegated_services)
        if id and not isinstance(id, str):
            raise TypeError("Expected argument 'id' to be a str")
        pulumi.set(__self__, "id", id)

    @property
    @pulumi.getter(name="accountId")
    def account_id(self) -> builtins.str:
        return pulumi.get(self, "account_id")

    @property
    @pulumi.getter(name="delegatedServices")
    def delegated_services(self) -> Sequence['outputs.GetDelegatedServicesDelegatedServiceResult']:
        """
        Services for which the account is a delegated administrator, which have the following attributes:
        """
        return pulumi.get(self, "delegated_services")

    @property
    @pulumi.getter
    def id(self) -> builtins.str:
        """
        The provider-assigned unique ID for this managed resource.
        """
        return pulumi.get(self, "id")


class AwaitableGetDelegatedServicesResult(GetDelegatedServicesResult):
    # pylint: disable=using-constant-test
    def __await__(self):
        if False:
            yield self
        return GetDelegatedServicesResult(
            account_id=self.account_id,
            delegated_services=self.delegated_services,
            id=self.id)


def get_delegated_services(account_id: Optional[builtins.str] = None,
                           opts: Optional[pulumi.InvokeOptions] = None) -> AwaitableGetDelegatedServicesResult:
    """
    Get a list the AWS services for which the specified account is a delegated administrator

    ## Example Usage

    ```python
    import pulumi
    import pulumi_aws as aws

    example = aws.organizations.get_delegated_services(account_id="AWS ACCOUNT ID")
    ```


    :param builtins.str account_id: Account ID number of a delegated administrator account in the organization.
    """
    __args__ = dict()
    __args__['accountId'] = account_id
    opts = pulumi.InvokeOptions.merge(_utilities.get_invoke_opts_defaults(), opts)
    __ret__ = pulumi.runtime.invoke('aws:organizations/getDelegatedServices:getDelegatedServices', __args__, opts=opts, typ=GetDelegatedServicesResult).value

    return AwaitableGetDelegatedServicesResult(
        account_id=pulumi.get(__ret__, 'account_id'),
        delegated_services=pulumi.get(__ret__, 'delegated_services'),
        id=pulumi.get(__ret__, 'id'))
def get_delegated_services_output(account_id: Optional[pulumi.Input[builtins.str]] = None,
                                  opts: Optional[Union[pulumi.InvokeOptions, pulumi.InvokeOutputOptions]] = None) -> pulumi.Output[GetDelegatedServicesResult]:
    """
    Get a list the AWS services for which the specified account is a delegated administrator

    ## Example Usage

    ```python
    import pulumi
    import pulumi_aws as aws

    example = aws.organizations.get_delegated_services(account_id="AWS ACCOUNT ID")
    ```


    :param builtins.str account_id: Account ID number of a delegated administrator account in the organization.
    """
    __args__ = dict()
    __args__['accountId'] = account_id
    opts = pulumi.InvokeOutputOptions.merge(_utilities.get_invoke_opts_defaults(), opts)
    __ret__ = pulumi.runtime.invoke_output('aws:organizations/getDelegatedServices:getDelegatedServices', __args__, opts=opts, typ=GetDelegatedServicesResult)
    return __ret__.apply(lambda __response__: GetDelegatedServicesResult(
        account_id=pulumi.get(__response__, 'account_id'),
        delegated_services=pulumi.get(__response__, 'delegated_services'),
        id=pulumi.get(__response__, 'id')))
