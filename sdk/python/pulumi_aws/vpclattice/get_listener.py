# coding=utf-8
# *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
# *** Do not edit by hand unless you're certain you know what you are doing! ***

import copy
import warnings
import pulumi
import pulumi.runtime
from typing import Any, Mapping, Optional, Sequence, Union, overload
from .. import _utilities
from . import outputs

__all__ = [
    'GetListenerResult',
    'AwaitableGetListenerResult',
    'get_listener',
    'get_listener_output',
]

@pulumi.output_type
class GetListenerResult:
    """
    A collection of values returned by getListener.
    """
    def __init__(__self__, arn=None, created_at=None, default_actions=None, id=None, last_updated_at=None, listener_id=None, listener_identifier=None, name=None, port=None, protocol=None, service_arn=None, service_id=None, service_identifier=None, tags=None):
        if arn and not isinstance(arn, str):
            raise TypeError("Expected argument 'arn' to be a str")
        pulumi.set(__self__, "arn", arn)
        if created_at and not isinstance(created_at, str):
            raise TypeError("Expected argument 'created_at' to be a str")
        pulumi.set(__self__, "created_at", created_at)
        if default_actions and not isinstance(default_actions, list):
            raise TypeError("Expected argument 'default_actions' to be a list")
        pulumi.set(__self__, "default_actions", default_actions)
        if id and not isinstance(id, str):
            raise TypeError("Expected argument 'id' to be a str")
        pulumi.set(__self__, "id", id)
        if last_updated_at and not isinstance(last_updated_at, str):
            raise TypeError("Expected argument 'last_updated_at' to be a str")
        pulumi.set(__self__, "last_updated_at", last_updated_at)
        if listener_id and not isinstance(listener_id, str):
            raise TypeError("Expected argument 'listener_id' to be a str")
        pulumi.set(__self__, "listener_id", listener_id)
        if listener_identifier and not isinstance(listener_identifier, str):
            raise TypeError("Expected argument 'listener_identifier' to be a str")
        pulumi.set(__self__, "listener_identifier", listener_identifier)
        if name and not isinstance(name, str):
            raise TypeError("Expected argument 'name' to be a str")
        pulumi.set(__self__, "name", name)
        if port and not isinstance(port, int):
            raise TypeError("Expected argument 'port' to be a int")
        pulumi.set(__self__, "port", port)
        if protocol and not isinstance(protocol, str):
            raise TypeError("Expected argument 'protocol' to be a str")
        pulumi.set(__self__, "protocol", protocol)
        if service_arn and not isinstance(service_arn, str):
            raise TypeError("Expected argument 'service_arn' to be a str")
        pulumi.set(__self__, "service_arn", service_arn)
        if service_id and not isinstance(service_id, str):
            raise TypeError("Expected argument 'service_id' to be a str")
        pulumi.set(__self__, "service_id", service_id)
        if service_identifier and not isinstance(service_identifier, str):
            raise TypeError("Expected argument 'service_identifier' to be a str")
        pulumi.set(__self__, "service_identifier", service_identifier)
        if tags and not isinstance(tags, dict):
            raise TypeError("Expected argument 'tags' to be a dict")
        pulumi.set(__self__, "tags", tags)

    @property
    @pulumi.getter
    def arn(self) -> str:
        """
        ARN of the listener.
        """
        return pulumi.get(self, "arn")

    @property
    @pulumi.getter(name="createdAt")
    def created_at(self) -> str:
        """
        The date and time that the listener was created.
        """
        return pulumi.get(self, "created_at")

    @property
    @pulumi.getter(name="defaultActions")
    def default_actions(self) -> Sequence['outputs.GetListenerDefaultActionResult']:
        """
        The actions for the default listener rule.
        """
        return pulumi.get(self, "default_actions")

    @property
    @pulumi.getter
    def id(self) -> str:
        """
        The provider-assigned unique ID for this managed resource.
        """
        return pulumi.get(self, "id")

    @property
    @pulumi.getter(name="lastUpdatedAt")
    def last_updated_at(self) -> str:
        """
        The date and time the listener was last updated.
        """
        return pulumi.get(self, "last_updated_at")

    @property
    @pulumi.getter(name="listenerId")
    def listener_id(self) -> str:
        """
        The ID of the listener.
        """
        return pulumi.get(self, "listener_id")

    @property
    @pulumi.getter(name="listenerIdentifier")
    def listener_identifier(self) -> str:
        return pulumi.get(self, "listener_identifier")

    @property
    @pulumi.getter
    def name(self) -> str:
        """
        The name of the listener.
        """
        return pulumi.get(self, "name")

    @property
    @pulumi.getter
    def port(self) -> int:
        """
        The listener port.
        """
        return pulumi.get(self, "port")

    @property
    @pulumi.getter
    def protocol(self) -> str:
        """
        The listener protocol. Either `HTTPS` or `HTTP`.
        """
        return pulumi.get(self, "protocol")

    @property
    @pulumi.getter(name="serviceArn")
    def service_arn(self) -> str:
        """
        The ARN of the service.
        """
        return pulumi.get(self, "service_arn")

    @property
    @pulumi.getter(name="serviceId")
    def service_id(self) -> str:
        """
        The ID of the service.
        """
        return pulumi.get(self, "service_id")

    @property
    @pulumi.getter(name="serviceIdentifier")
    def service_identifier(self) -> str:
        return pulumi.get(self, "service_identifier")

    @property
    @pulumi.getter
    def tags(self) -> Mapping[str, str]:
        """
        List of tags associated with the listener.
        """
        return pulumi.get(self, "tags")


class AwaitableGetListenerResult(GetListenerResult):
    # pylint: disable=using-constant-test
    def __await__(self):
        if False:
            yield self
        return GetListenerResult(
            arn=self.arn,
            created_at=self.created_at,
            default_actions=self.default_actions,
            id=self.id,
            last_updated_at=self.last_updated_at,
            listener_id=self.listener_id,
            listener_identifier=self.listener_identifier,
            name=self.name,
            port=self.port,
            protocol=self.protocol,
            service_arn=self.service_arn,
            service_id=self.service_id,
            service_identifier=self.service_identifier,
            tags=self.tags)


def get_listener(listener_identifier: Optional[str] = None,
                 service_identifier: Optional[str] = None,
                 tags: Optional[Mapping[str, str]] = None,
                 opts: Optional[pulumi.InvokeOptions] = None) -> AwaitableGetListenerResult:
    """
    Data source for managing an AWS VPC Lattice Listener.

    ## Example Usage
    ### Basic Usage
    ```python
    import pulumi
    import pulumi_aws as aws

    example = aws.vpclattice.get_listener()
    ```


    :param str listener_identifier: ID or Amazon Resource Name (ARN) of the listener
    :param str service_identifier: ID or Amazon Resource Name (ARN) of the service network
    :param Mapping[str, str] tags: List of tags associated with the listener.
    """
    __args__ = dict()
    __args__['listenerIdentifier'] = listener_identifier
    __args__['serviceIdentifier'] = service_identifier
    __args__['tags'] = tags
    opts = pulumi.InvokeOptions.merge(_utilities.get_invoke_opts_defaults(), opts)
    __ret__ = pulumi.runtime.invoke('aws:vpclattice/getListener:getListener', __args__, opts=opts, typ=GetListenerResult).value

    return AwaitableGetListenerResult(
        arn=__ret__.arn,
        created_at=__ret__.created_at,
        default_actions=__ret__.default_actions,
        id=__ret__.id,
        last_updated_at=__ret__.last_updated_at,
        listener_id=__ret__.listener_id,
        listener_identifier=__ret__.listener_identifier,
        name=__ret__.name,
        port=__ret__.port,
        protocol=__ret__.protocol,
        service_arn=__ret__.service_arn,
        service_id=__ret__.service_id,
        service_identifier=__ret__.service_identifier,
        tags=__ret__.tags)


@_utilities.lift_output_func(get_listener)
def get_listener_output(listener_identifier: Optional[pulumi.Input[str]] = None,
                        service_identifier: Optional[pulumi.Input[str]] = None,
                        tags: Optional[pulumi.Input[Optional[Mapping[str, str]]]] = None,
                        opts: Optional[pulumi.InvokeOptions] = None) -> pulumi.Output[GetListenerResult]:
    """
    Data source for managing an AWS VPC Lattice Listener.

    ## Example Usage
    ### Basic Usage
    ```python
    import pulumi
    import pulumi_aws as aws

    example = aws.vpclattice.get_listener()
    ```


    :param str listener_identifier: ID or Amazon Resource Name (ARN) of the listener
    :param str service_identifier: ID or Amazon Resource Name (ARN) of the service network
    :param Mapping[str, str] tags: List of tags associated with the listener.
    """
    ...