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

__all__ = ['CustomRoutingEndpointGroupArgs', 'CustomRoutingEndpointGroup']

@pulumi.input_type
class CustomRoutingEndpointGroupArgs:
    def __init__(__self__, *,
                 destination_configurations: pulumi.Input[Sequence[pulumi.Input['CustomRoutingEndpointGroupDestinationConfigurationArgs']]],
                 listener_arn: pulumi.Input[builtins.str],
                 endpoint_configurations: Optional[pulumi.Input[Sequence[pulumi.Input['CustomRoutingEndpointGroupEndpointConfigurationArgs']]]] = None,
                 endpoint_group_region: Optional[pulumi.Input[builtins.str]] = None):
        """
        The set of arguments for constructing a CustomRoutingEndpointGroup resource.
        :param pulumi.Input[Sequence[pulumi.Input['CustomRoutingEndpointGroupDestinationConfigurationArgs']]] destination_configurations: The port ranges and protocols for all endpoints in a custom routing endpoint group to accept client traffic on. Fields documented below.
        :param pulumi.Input[builtins.str] listener_arn: The Amazon Resource Name (ARN) of the custom routing listener.
        :param pulumi.Input[Sequence[pulumi.Input['CustomRoutingEndpointGroupEndpointConfigurationArgs']]] endpoint_configurations: The list of endpoint objects. Fields documented below.
        :param pulumi.Input[builtins.str] endpoint_group_region: The name of the AWS Region where the custom routing endpoint group is located.
        """
        pulumi.set(__self__, "destination_configurations", destination_configurations)
        pulumi.set(__self__, "listener_arn", listener_arn)
        if endpoint_configurations is not None:
            pulumi.set(__self__, "endpoint_configurations", endpoint_configurations)
        if endpoint_group_region is not None:
            pulumi.set(__self__, "endpoint_group_region", endpoint_group_region)

    @property
    @pulumi.getter(name="destinationConfigurations")
    def destination_configurations(self) -> pulumi.Input[Sequence[pulumi.Input['CustomRoutingEndpointGroupDestinationConfigurationArgs']]]:
        """
        The port ranges and protocols for all endpoints in a custom routing endpoint group to accept client traffic on. Fields documented below.
        """
        return pulumi.get(self, "destination_configurations")

    @destination_configurations.setter
    def destination_configurations(self, value: pulumi.Input[Sequence[pulumi.Input['CustomRoutingEndpointGroupDestinationConfigurationArgs']]]):
        pulumi.set(self, "destination_configurations", value)

    @property
    @pulumi.getter(name="listenerArn")
    def listener_arn(self) -> pulumi.Input[builtins.str]:
        """
        The Amazon Resource Name (ARN) of the custom routing listener.
        """
        return pulumi.get(self, "listener_arn")

    @listener_arn.setter
    def listener_arn(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "listener_arn", value)

    @property
    @pulumi.getter(name="endpointConfigurations")
    def endpoint_configurations(self) -> Optional[pulumi.Input[Sequence[pulumi.Input['CustomRoutingEndpointGroupEndpointConfigurationArgs']]]]:
        """
        The list of endpoint objects. Fields documented below.
        """
        return pulumi.get(self, "endpoint_configurations")

    @endpoint_configurations.setter
    def endpoint_configurations(self, value: Optional[pulumi.Input[Sequence[pulumi.Input['CustomRoutingEndpointGroupEndpointConfigurationArgs']]]]):
        pulumi.set(self, "endpoint_configurations", value)

    @property
    @pulumi.getter(name="endpointGroupRegion")
    def endpoint_group_region(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The name of the AWS Region where the custom routing endpoint group is located.
        """
        return pulumi.get(self, "endpoint_group_region")

    @endpoint_group_region.setter
    def endpoint_group_region(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "endpoint_group_region", value)


@pulumi.input_type
class _CustomRoutingEndpointGroupState:
    def __init__(__self__, *,
                 arn: Optional[pulumi.Input[builtins.str]] = None,
                 destination_configurations: Optional[pulumi.Input[Sequence[pulumi.Input['CustomRoutingEndpointGroupDestinationConfigurationArgs']]]] = None,
                 endpoint_configurations: Optional[pulumi.Input[Sequence[pulumi.Input['CustomRoutingEndpointGroupEndpointConfigurationArgs']]]] = None,
                 endpoint_group_region: Optional[pulumi.Input[builtins.str]] = None,
                 listener_arn: Optional[pulumi.Input[builtins.str]] = None):
        """
        Input properties used for looking up and filtering CustomRoutingEndpointGroup resources.
        :param pulumi.Input[builtins.str] arn: The Amazon Resource Name (ARN) of the custom routing endpoint group.
        :param pulumi.Input[Sequence[pulumi.Input['CustomRoutingEndpointGroupDestinationConfigurationArgs']]] destination_configurations: The port ranges and protocols for all endpoints in a custom routing endpoint group to accept client traffic on. Fields documented below.
        :param pulumi.Input[Sequence[pulumi.Input['CustomRoutingEndpointGroupEndpointConfigurationArgs']]] endpoint_configurations: The list of endpoint objects. Fields documented below.
        :param pulumi.Input[builtins.str] endpoint_group_region: The name of the AWS Region where the custom routing endpoint group is located.
        :param pulumi.Input[builtins.str] listener_arn: The Amazon Resource Name (ARN) of the custom routing listener.
        """
        if arn is not None:
            pulumi.set(__self__, "arn", arn)
        if destination_configurations is not None:
            pulumi.set(__self__, "destination_configurations", destination_configurations)
        if endpoint_configurations is not None:
            pulumi.set(__self__, "endpoint_configurations", endpoint_configurations)
        if endpoint_group_region is not None:
            pulumi.set(__self__, "endpoint_group_region", endpoint_group_region)
        if listener_arn is not None:
            pulumi.set(__self__, "listener_arn", listener_arn)

    @property
    @pulumi.getter
    def arn(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The Amazon Resource Name (ARN) of the custom routing endpoint group.
        """
        return pulumi.get(self, "arn")

    @arn.setter
    def arn(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "arn", value)

    @property
    @pulumi.getter(name="destinationConfigurations")
    def destination_configurations(self) -> Optional[pulumi.Input[Sequence[pulumi.Input['CustomRoutingEndpointGroupDestinationConfigurationArgs']]]]:
        """
        The port ranges and protocols for all endpoints in a custom routing endpoint group to accept client traffic on. Fields documented below.
        """
        return pulumi.get(self, "destination_configurations")

    @destination_configurations.setter
    def destination_configurations(self, value: Optional[pulumi.Input[Sequence[pulumi.Input['CustomRoutingEndpointGroupDestinationConfigurationArgs']]]]):
        pulumi.set(self, "destination_configurations", value)

    @property
    @pulumi.getter(name="endpointConfigurations")
    def endpoint_configurations(self) -> Optional[pulumi.Input[Sequence[pulumi.Input['CustomRoutingEndpointGroupEndpointConfigurationArgs']]]]:
        """
        The list of endpoint objects. Fields documented below.
        """
        return pulumi.get(self, "endpoint_configurations")

    @endpoint_configurations.setter
    def endpoint_configurations(self, value: Optional[pulumi.Input[Sequence[pulumi.Input['CustomRoutingEndpointGroupEndpointConfigurationArgs']]]]):
        pulumi.set(self, "endpoint_configurations", value)

    @property
    @pulumi.getter(name="endpointGroupRegion")
    def endpoint_group_region(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The name of the AWS Region where the custom routing endpoint group is located.
        """
        return pulumi.get(self, "endpoint_group_region")

    @endpoint_group_region.setter
    def endpoint_group_region(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "endpoint_group_region", value)

    @property
    @pulumi.getter(name="listenerArn")
    def listener_arn(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The Amazon Resource Name (ARN) of the custom routing listener.
        """
        return pulumi.get(self, "listener_arn")

    @listener_arn.setter
    def listener_arn(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "listener_arn", value)


@pulumi.type_token("aws:globalaccelerator/customRoutingEndpointGroup:CustomRoutingEndpointGroup")
class CustomRoutingEndpointGroup(pulumi.CustomResource):
    @overload
    def __init__(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 destination_configurations: Optional[pulumi.Input[Sequence[pulumi.Input[Union['CustomRoutingEndpointGroupDestinationConfigurationArgs', 'CustomRoutingEndpointGroupDestinationConfigurationArgsDict']]]]] = None,
                 endpoint_configurations: Optional[pulumi.Input[Sequence[pulumi.Input[Union['CustomRoutingEndpointGroupEndpointConfigurationArgs', 'CustomRoutingEndpointGroupEndpointConfigurationArgsDict']]]]] = None,
                 endpoint_group_region: Optional[pulumi.Input[builtins.str]] = None,
                 listener_arn: Optional[pulumi.Input[builtins.str]] = None,
                 __props__=None):
        """
        Provides a Global Accelerator custom routing endpoint group.

        ## Example Usage

        ```python
        import pulumi
        import pulumi_aws as aws

        example = aws.globalaccelerator.CustomRoutingEndpointGroup("example",
            listener_arn=example_aws_globalaccelerator_custom_routing_listener["arn"],
            destination_configurations=[{
                "from_port": 80,
                "to_port": 8080,
                "protocols": ["TCP"],
            }],
            endpoint_configurations=[{
                "endpoint_id": example_aws_subnet["id"],
            }])
        ```

        ## Import

        Using `pulumi import`, import Global Accelerator custom routing endpoint groups using the `id`. For example:

        ```sh
        $ pulumi import aws:globalaccelerator/customRoutingEndpointGroup:CustomRoutingEndpointGroup example arn:aws:globalaccelerator::111111111111:accelerator/xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx/listener/xxxxxxx/endpoint-group/xxxxxxxx
        ```

        :param str resource_name: The name of the resource.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[Sequence[pulumi.Input[Union['CustomRoutingEndpointGroupDestinationConfigurationArgs', 'CustomRoutingEndpointGroupDestinationConfigurationArgsDict']]]] destination_configurations: The port ranges and protocols for all endpoints in a custom routing endpoint group to accept client traffic on. Fields documented below.
        :param pulumi.Input[Sequence[pulumi.Input[Union['CustomRoutingEndpointGroupEndpointConfigurationArgs', 'CustomRoutingEndpointGroupEndpointConfigurationArgsDict']]]] endpoint_configurations: The list of endpoint objects. Fields documented below.
        :param pulumi.Input[builtins.str] endpoint_group_region: The name of the AWS Region where the custom routing endpoint group is located.
        :param pulumi.Input[builtins.str] listener_arn: The Amazon Resource Name (ARN) of the custom routing listener.
        """
        ...
    @overload
    def __init__(__self__,
                 resource_name: str,
                 args: CustomRoutingEndpointGroupArgs,
                 opts: Optional[pulumi.ResourceOptions] = None):
        """
        Provides a Global Accelerator custom routing endpoint group.

        ## Example Usage

        ```python
        import pulumi
        import pulumi_aws as aws

        example = aws.globalaccelerator.CustomRoutingEndpointGroup("example",
            listener_arn=example_aws_globalaccelerator_custom_routing_listener["arn"],
            destination_configurations=[{
                "from_port": 80,
                "to_port": 8080,
                "protocols": ["TCP"],
            }],
            endpoint_configurations=[{
                "endpoint_id": example_aws_subnet["id"],
            }])
        ```

        ## Import

        Using `pulumi import`, import Global Accelerator custom routing endpoint groups using the `id`. For example:

        ```sh
        $ pulumi import aws:globalaccelerator/customRoutingEndpointGroup:CustomRoutingEndpointGroup example arn:aws:globalaccelerator::111111111111:accelerator/xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx/listener/xxxxxxx/endpoint-group/xxxxxxxx
        ```

        :param str resource_name: The name of the resource.
        :param CustomRoutingEndpointGroupArgs args: The arguments to use to populate this resource's properties.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        ...
    def __init__(__self__, resource_name: str, *args, **kwargs):
        resource_args, opts = _utilities.get_resource_args_opts(CustomRoutingEndpointGroupArgs, pulumi.ResourceOptions, *args, **kwargs)
        if resource_args is not None:
            __self__._internal_init(resource_name, opts, **resource_args.__dict__)
        else:
            __self__._internal_init(resource_name, *args, **kwargs)

    def _internal_init(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 destination_configurations: Optional[pulumi.Input[Sequence[pulumi.Input[Union['CustomRoutingEndpointGroupDestinationConfigurationArgs', 'CustomRoutingEndpointGroupDestinationConfigurationArgsDict']]]]] = None,
                 endpoint_configurations: Optional[pulumi.Input[Sequence[pulumi.Input[Union['CustomRoutingEndpointGroupEndpointConfigurationArgs', 'CustomRoutingEndpointGroupEndpointConfigurationArgsDict']]]]] = None,
                 endpoint_group_region: Optional[pulumi.Input[builtins.str]] = None,
                 listener_arn: Optional[pulumi.Input[builtins.str]] = None,
                 __props__=None):
        opts = pulumi.ResourceOptions.merge(_utilities.get_resource_opts_defaults(), opts)
        if not isinstance(opts, pulumi.ResourceOptions):
            raise TypeError('Expected resource options to be a ResourceOptions instance')
        if opts.id is None:
            if __props__ is not None:
                raise TypeError('__props__ is only valid when passed in combination with a valid opts.id to get an existing resource')
            __props__ = CustomRoutingEndpointGroupArgs.__new__(CustomRoutingEndpointGroupArgs)

            if destination_configurations is None and not opts.urn:
                raise TypeError("Missing required property 'destination_configurations'")
            __props__.__dict__["destination_configurations"] = destination_configurations
            __props__.__dict__["endpoint_configurations"] = endpoint_configurations
            __props__.__dict__["endpoint_group_region"] = endpoint_group_region
            if listener_arn is None and not opts.urn:
                raise TypeError("Missing required property 'listener_arn'")
            __props__.__dict__["listener_arn"] = listener_arn
            __props__.__dict__["arn"] = None
        super(CustomRoutingEndpointGroup, __self__).__init__(
            'aws:globalaccelerator/customRoutingEndpointGroup:CustomRoutingEndpointGroup',
            resource_name,
            __props__,
            opts)

    @staticmethod
    def get(resource_name: str,
            id: pulumi.Input[str],
            opts: Optional[pulumi.ResourceOptions] = None,
            arn: Optional[pulumi.Input[builtins.str]] = None,
            destination_configurations: Optional[pulumi.Input[Sequence[pulumi.Input[Union['CustomRoutingEndpointGroupDestinationConfigurationArgs', 'CustomRoutingEndpointGroupDestinationConfigurationArgsDict']]]]] = None,
            endpoint_configurations: Optional[pulumi.Input[Sequence[pulumi.Input[Union['CustomRoutingEndpointGroupEndpointConfigurationArgs', 'CustomRoutingEndpointGroupEndpointConfigurationArgsDict']]]]] = None,
            endpoint_group_region: Optional[pulumi.Input[builtins.str]] = None,
            listener_arn: Optional[pulumi.Input[builtins.str]] = None) -> 'CustomRoutingEndpointGroup':
        """
        Get an existing CustomRoutingEndpointGroup resource's state with the given name, id, and optional extra
        properties used to qualify the lookup.

        :param str resource_name: The unique name of the resulting resource.
        :param pulumi.Input[str] id: The unique provider ID of the resource to lookup.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[builtins.str] arn: The Amazon Resource Name (ARN) of the custom routing endpoint group.
        :param pulumi.Input[Sequence[pulumi.Input[Union['CustomRoutingEndpointGroupDestinationConfigurationArgs', 'CustomRoutingEndpointGroupDestinationConfigurationArgsDict']]]] destination_configurations: The port ranges and protocols for all endpoints in a custom routing endpoint group to accept client traffic on. Fields documented below.
        :param pulumi.Input[Sequence[pulumi.Input[Union['CustomRoutingEndpointGroupEndpointConfigurationArgs', 'CustomRoutingEndpointGroupEndpointConfigurationArgsDict']]]] endpoint_configurations: The list of endpoint objects. Fields documented below.
        :param pulumi.Input[builtins.str] endpoint_group_region: The name of the AWS Region where the custom routing endpoint group is located.
        :param pulumi.Input[builtins.str] listener_arn: The Amazon Resource Name (ARN) of the custom routing listener.
        """
        opts = pulumi.ResourceOptions.merge(opts, pulumi.ResourceOptions(id=id))

        __props__ = _CustomRoutingEndpointGroupState.__new__(_CustomRoutingEndpointGroupState)

        __props__.__dict__["arn"] = arn
        __props__.__dict__["destination_configurations"] = destination_configurations
        __props__.__dict__["endpoint_configurations"] = endpoint_configurations
        __props__.__dict__["endpoint_group_region"] = endpoint_group_region
        __props__.__dict__["listener_arn"] = listener_arn
        return CustomRoutingEndpointGroup(resource_name, opts=opts, __props__=__props__)

    @property
    @pulumi.getter
    def arn(self) -> pulumi.Output[builtins.str]:
        """
        The Amazon Resource Name (ARN) of the custom routing endpoint group.
        """
        return pulumi.get(self, "arn")

    @property
    @pulumi.getter(name="destinationConfigurations")
    def destination_configurations(self) -> pulumi.Output[Sequence['outputs.CustomRoutingEndpointGroupDestinationConfiguration']]:
        """
        The port ranges and protocols for all endpoints in a custom routing endpoint group to accept client traffic on. Fields documented below.
        """
        return pulumi.get(self, "destination_configurations")

    @property
    @pulumi.getter(name="endpointConfigurations")
    def endpoint_configurations(self) -> pulumi.Output[Optional[Sequence['outputs.CustomRoutingEndpointGroupEndpointConfiguration']]]:
        """
        The list of endpoint objects. Fields documented below.
        """
        return pulumi.get(self, "endpoint_configurations")

    @property
    @pulumi.getter(name="endpointGroupRegion")
    def endpoint_group_region(self) -> pulumi.Output[builtins.str]:
        """
        The name of the AWS Region where the custom routing endpoint group is located.
        """
        return pulumi.get(self, "endpoint_group_region")

    @property
    @pulumi.getter(name="listenerArn")
    def listener_arn(self) -> pulumi.Output[builtins.str]:
        """
        The Amazon Resource Name (ARN) of the custom routing listener.
        """
        return pulumi.get(self, "listener_arn")

