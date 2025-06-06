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

__all__ = [
    'GetSecretResult',
    'AwaitableGetSecretResult',
    'get_secret',
    'get_secret_output',
]

@pulumi.output_type
class GetSecretResult:
    """
    A collection of values returned by getSecret.
    """
    def __init__(__self__, id=None, secrets=None):
        if id and not isinstance(id, str):
            raise TypeError("Expected argument 'id' to be a str")
        pulumi.set(__self__, "id", id)
        if secrets and not isinstance(secrets, list):
            raise TypeError("Expected argument 'secrets' to be a list")
        pulumi.set(__self__, "secrets", secrets)

    @property
    @pulumi.getter
    def id(self) -> builtins.str:
        """
        The provider-assigned unique ID for this managed resource.
        """
        return pulumi.get(self, "id")

    @property
    @pulumi.getter
    def secrets(self) -> Sequence['outputs.GetSecretSecretResult']:
        return pulumi.get(self, "secrets")


class AwaitableGetSecretResult(GetSecretResult):
    # pylint: disable=using-constant-test
    def __await__(self):
        if False:
            yield self
        return GetSecretResult(
            id=self.id,
            secrets=self.secrets)


def get_secret(secrets: Optional[Sequence[Union['GetSecretSecretArgs', 'GetSecretSecretArgsDict']]] = None,
               opts: Optional[pulumi.InvokeOptions] = None) -> AwaitableGetSecretResult:
    """
    Use this data source to access information about an existing resource.
    """
    __args__ = dict()
    __args__['secrets'] = secrets
    opts = pulumi.InvokeOptions.merge(_utilities.get_invoke_opts_defaults(), opts)
    __ret__ = pulumi.runtime.invoke('aws:kms/getSecret:getSecret', __args__, opts=opts, typ=GetSecretResult).value

    return AwaitableGetSecretResult(
        id=pulumi.get(__ret__, 'id'),
        secrets=pulumi.get(__ret__, 'secrets'))
def get_secret_output(secrets: Optional[pulumi.Input[Sequence[Union['GetSecretSecretArgs', 'GetSecretSecretArgsDict']]]] = None,
                      opts: Optional[Union[pulumi.InvokeOptions, pulumi.InvokeOutputOptions]] = None) -> pulumi.Output[GetSecretResult]:
    """
    Use this data source to access information about an existing resource.
    """
    __args__ = dict()
    __args__['secrets'] = secrets
    opts = pulumi.InvokeOutputOptions.merge(_utilities.get_invoke_opts_defaults(), opts)
    __ret__ = pulumi.runtime.invoke_output('aws:kms/getSecret:getSecret', __args__, opts=opts, typ=GetSecretResult)
    return __ret__.apply(lambda __response__: GetSecretResult(
        id=pulumi.get(__response__, 'id'),
        secrets=pulumi.get(__response__, 'secrets')))
