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

__all__ = ['AliasArgs', 'Alias']

@pulumi.input_type
class AliasArgs:
    def __init__(__self__, *,
                 function_name: pulumi.Input[builtins.str],
                 function_version: pulumi.Input[builtins.str],
                 description: Optional[pulumi.Input[builtins.str]] = None,
                 name: Optional[pulumi.Input[builtins.str]] = None,
                 routing_config: Optional[pulumi.Input['AliasRoutingConfigArgs']] = None):
        """
        The set of arguments for constructing a Alias resource.
        :param pulumi.Input[builtins.str] function_name: Lambda Function name or ARN.
        :param pulumi.Input[builtins.str] function_version: Lambda function version for which you are creating the alias. Pattern: `(\\$LATEST|[0-9]+)`.
        :param pulumi.Input[builtins.str] description: Description of the alias.
        :param pulumi.Input[builtins.str] name: Name for the alias you are creating. Pattern: `(?!^[0-9]+$)([a-zA-Z0-9-_]+)`
        :param pulumi.Input['AliasRoutingConfigArgs'] routing_config: The Lambda alias' route configuration settings. Fields documented below
        """
        pulumi.set(__self__, "function_name", function_name)
        pulumi.set(__self__, "function_version", function_version)
        if description is not None:
            pulumi.set(__self__, "description", description)
        if name is not None:
            pulumi.set(__self__, "name", name)
        if routing_config is not None:
            pulumi.set(__self__, "routing_config", routing_config)

    @property
    @pulumi.getter(name="functionName")
    def function_name(self) -> pulumi.Input[builtins.str]:
        """
        Lambda Function name or ARN.
        """
        return pulumi.get(self, "function_name")

    @function_name.setter
    def function_name(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "function_name", value)

    @property
    @pulumi.getter(name="functionVersion")
    def function_version(self) -> pulumi.Input[builtins.str]:
        """
        Lambda function version for which you are creating the alias. Pattern: `(\\$LATEST|[0-9]+)`.
        """
        return pulumi.get(self, "function_version")

    @function_version.setter
    def function_version(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "function_version", value)

    @property
    @pulumi.getter
    def description(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Description of the alias.
        """
        return pulumi.get(self, "description")

    @description.setter
    def description(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "description", value)

    @property
    @pulumi.getter
    def name(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Name for the alias you are creating. Pattern: `(?!^[0-9]+$)([a-zA-Z0-9-_]+)`
        """
        return pulumi.get(self, "name")

    @name.setter
    def name(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "name", value)

    @property
    @pulumi.getter(name="routingConfig")
    def routing_config(self) -> Optional[pulumi.Input['AliasRoutingConfigArgs']]:
        """
        The Lambda alias' route configuration settings. Fields documented below
        """
        return pulumi.get(self, "routing_config")

    @routing_config.setter
    def routing_config(self, value: Optional[pulumi.Input['AliasRoutingConfigArgs']]):
        pulumi.set(self, "routing_config", value)


@pulumi.input_type
class _AliasState:
    def __init__(__self__, *,
                 arn: Optional[pulumi.Input[builtins.str]] = None,
                 description: Optional[pulumi.Input[builtins.str]] = None,
                 function_name: Optional[pulumi.Input[builtins.str]] = None,
                 function_version: Optional[pulumi.Input[builtins.str]] = None,
                 invoke_arn: Optional[pulumi.Input[builtins.str]] = None,
                 name: Optional[pulumi.Input[builtins.str]] = None,
                 routing_config: Optional[pulumi.Input['AliasRoutingConfigArgs']] = None):
        """
        Input properties used for looking up and filtering Alias resources.
        :param pulumi.Input[builtins.str] arn: The Amazon Resource Name (ARN) identifying your Lambda function alias.
        :param pulumi.Input[builtins.str] description: Description of the alias.
        :param pulumi.Input[builtins.str] function_name: Lambda Function name or ARN.
        :param pulumi.Input[builtins.str] function_version: Lambda function version for which you are creating the alias. Pattern: `(\\$LATEST|[0-9]+)`.
        :param pulumi.Input[builtins.str] invoke_arn: The ARN to be used for invoking Lambda Function from API Gateway - to be used in `apigateway.Integration`'s `uri`
        :param pulumi.Input[builtins.str] name: Name for the alias you are creating. Pattern: `(?!^[0-9]+$)([a-zA-Z0-9-_]+)`
        :param pulumi.Input['AliasRoutingConfigArgs'] routing_config: The Lambda alias' route configuration settings. Fields documented below
        """
        if arn is not None:
            pulumi.set(__self__, "arn", arn)
        if description is not None:
            pulumi.set(__self__, "description", description)
        if function_name is not None:
            pulumi.set(__self__, "function_name", function_name)
        if function_version is not None:
            pulumi.set(__self__, "function_version", function_version)
        if invoke_arn is not None:
            pulumi.set(__self__, "invoke_arn", invoke_arn)
        if name is not None:
            pulumi.set(__self__, "name", name)
        if routing_config is not None:
            pulumi.set(__self__, "routing_config", routing_config)

    @property
    @pulumi.getter
    def arn(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The Amazon Resource Name (ARN) identifying your Lambda function alias.
        """
        return pulumi.get(self, "arn")

    @arn.setter
    def arn(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "arn", value)

    @property
    @pulumi.getter
    def description(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Description of the alias.
        """
        return pulumi.get(self, "description")

    @description.setter
    def description(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "description", value)

    @property
    @pulumi.getter(name="functionName")
    def function_name(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Lambda Function name or ARN.
        """
        return pulumi.get(self, "function_name")

    @function_name.setter
    def function_name(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "function_name", value)

    @property
    @pulumi.getter(name="functionVersion")
    def function_version(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Lambda function version for which you are creating the alias. Pattern: `(\\$LATEST|[0-9]+)`.
        """
        return pulumi.get(self, "function_version")

    @function_version.setter
    def function_version(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "function_version", value)

    @property
    @pulumi.getter(name="invokeArn")
    def invoke_arn(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The ARN to be used for invoking Lambda Function from API Gateway - to be used in `apigateway.Integration`'s `uri`
        """
        return pulumi.get(self, "invoke_arn")

    @invoke_arn.setter
    def invoke_arn(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "invoke_arn", value)

    @property
    @pulumi.getter
    def name(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Name for the alias you are creating. Pattern: `(?!^[0-9]+$)([a-zA-Z0-9-_]+)`
        """
        return pulumi.get(self, "name")

    @name.setter
    def name(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "name", value)

    @property
    @pulumi.getter(name="routingConfig")
    def routing_config(self) -> Optional[pulumi.Input['AliasRoutingConfigArgs']]:
        """
        The Lambda alias' route configuration settings. Fields documented below
        """
        return pulumi.get(self, "routing_config")

    @routing_config.setter
    def routing_config(self, value: Optional[pulumi.Input['AliasRoutingConfigArgs']]):
        pulumi.set(self, "routing_config", value)


@pulumi.type_token("aws:lambda/alias:Alias")
class Alias(pulumi.CustomResource):
    @overload
    def __init__(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 description: Optional[pulumi.Input[builtins.str]] = None,
                 function_name: Optional[pulumi.Input[builtins.str]] = None,
                 function_version: Optional[pulumi.Input[builtins.str]] = None,
                 name: Optional[pulumi.Input[builtins.str]] = None,
                 routing_config: Optional[pulumi.Input[Union['AliasRoutingConfigArgs', 'AliasRoutingConfigArgsDict']]] = None,
                 __props__=None):
        """
        Creates a Lambda function alias. Creates an alias that points to the specified Lambda function version.

        For information about Lambda and how to use it, see [What is AWS Lambda?](http://docs.aws.amazon.com/lambda/latest/dg/welcome.html)
        For information about function aliases, see [CreateAlias](http://docs.aws.amazon.com/lambda/latest/dg/API_CreateAlias.html) and [AliasRoutingConfiguration](https://docs.aws.amazon.com/lambda/latest/dg/API_AliasRoutingConfiguration.html) in the API docs.

        ## Example Usage

        ```python
        import pulumi
        import pulumi_aws as aws

        test_lambda_alias = aws.lambda_.Alias("test_lambda_alias",
            name="my_alias",
            description="a sample description",
            function_name=lambda_function_test["arn"],
            function_version="1",
            routing_config={
                "additional_version_weights": {
                    "2": 0.5,
                },
            })
        ```

        ## Import

        Using `pulumi import`, import Lambda Function Aliases using the `function_name/alias`. For example:

        ```sh
        $ pulumi import aws:lambda/alias:Alias test_lambda_alias my_test_lambda_function/my_alias
        ```

        :param str resource_name: The name of the resource.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[builtins.str] description: Description of the alias.
        :param pulumi.Input[builtins.str] function_name: Lambda Function name or ARN.
        :param pulumi.Input[builtins.str] function_version: Lambda function version for which you are creating the alias. Pattern: `(\\$LATEST|[0-9]+)`.
        :param pulumi.Input[builtins.str] name: Name for the alias you are creating. Pattern: `(?!^[0-9]+$)([a-zA-Z0-9-_]+)`
        :param pulumi.Input[Union['AliasRoutingConfigArgs', 'AliasRoutingConfigArgsDict']] routing_config: The Lambda alias' route configuration settings. Fields documented below
        """
        ...
    @overload
    def __init__(__self__,
                 resource_name: str,
                 args: AliasArgs,
                 opts: Optional[pulumi.ResourceOptions] = None):
        """
        Creates a Lambda function alias. Creates an alias that points to the specified Lambda function version.

        For information about Lambda and how to use it, see [What is AWS Lambda?](http://docs.aws.amazon.com/lambda/latest/dg/welcome.html)
        For information about function aliases, see [CreateAlias](http://docs.aws.amazon.com/lambda/latest/dg/API_CreateAlias.html) and [AliasRoutingConfiguration](https://docs.aws.amazon.com/lambda/latest/dg/API_AliasRoutingConfiguration.html) in the API docs.

        ## Example Usage

        ```python
        import pulumi
        import pulumi_aws as aws

        test_lambda_alias = aws.lambda_.Alias("test_lambda_alias",
            name="my_alias",
            description="a sample description",
            function_name=lambda_function_test["arn"],
            function_version="1",
            routing_config={
                "additional_version_weights": {
                    "2": 0.5,
                },
            })
        ```

        ## Import

        Using `pulumi import`, import Lambda Function Aliases using the `function_name/alias`. For example:

        ```sh
        $ pulumi import aws:lambda/alias:Alias test_lambda_alias my_test_lambda_function/my_alias
        ```

        :param str resource_name: The name of the resource.
        :param AliasArgs args: The arguments to use to populate this resource's properties.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        ...
    def __init__(__self__, resource_name: str, *args, **kwargs):
        resource_args, opts = _utilities.get_resource_args_opts(AliasArgs, pulumi.ResourceOptions, *args, **kwargs)
        if resource_args is not None:
            __self__._internal_init(resource_name, opts, **resource_args.__dict__)
        else:
            __self__._internal_init(resource_name, *args, **kwargs)

    def _internal_init(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 description: Optional[pulumi.Input[builtins.str]] = None,
                 function_name: Optional[pulumi.Input[builtins.str]] = None,
                 function_version: Optional[pulumi.Input[builtins.str]] = None,
                 name: Optional[pulumi.Input[builtins.str]] = None,
                 routing_config: Optional[pulumi.Input[Union['AliasRoutingConfigArgs', 'AliasRoutingConfigArgsDict']]] = None,
                 __props__=None):
        opts = pulumi.ResourceOptions.merge(_utilities.get_resource_opts_defaults(), opts)
        if not isinstance(opts, pulumi.ResourceOptions):
            raise TypeError('Expected resource options to be a ResourceOptions instance')
        if opts.id is None:
            if __props__ is not None:
                raise TypeError('__props__ is only valid when passed in combination with a valid opts.id to get an existing resource')
            __props__ = AliasArgs.__new__(AliasArgs)

            __props__.__dict__["description"] = description
            if function_name is None and not opts.urn:
                raise TypeError("Missing required property 'function_name'")
            __props__.__dict__["function_name"] = function_name
            if function_version is None and not opts.urn:
                raise TypeError("Missing required property 'function_version'")
            __props__.__dict__["function_version"] = function_version
            __props__.__dict__["name"] = name
            __props__.__dict__["routing_config"] = routing_config
            __props__.__dict__["arn"] = None
            __props__.__dict__["invoke_arn"] = None
        super(Alias, __self__).__init__(
            'aws:lambda/alias:Alias',
            resource_name,
            __props__,
            opts)

    @staticmethod
    def get(resource_name: str,
            id: pulumi.Input[str],
            opts: Optional[pulumi.ResourceOptions] = None,
            arn: Optional[pulumi.Input[builtins.str]] = None,
            description: Optional[pulumi.Input[builtins.str]] = None,
            function_name: Optional[pulumi.Input[builtins.str]] = None,
            function_version: Optional[pulumi.Input[builtins.str]] = None,
            invoke_arn: Optional[pulumi.Input[builtins.str]] = None,
            name: Optional[pulumi.Input[builtins.str]] = None,
            routing_config: Optional[pulumi.Input[Union['AliasRoutingConfigArgs', 'AliasRoutingConfigArgsDict']]] = None) -> 'Alias':
        """
        Get an existing Alias resource's state with the given name, id, and optional extra
        properties used to qualify the lookup.

        :param str resource_name: The unique name of the resulting resource.
        :param pulumi.Input[str] id: The unique provider ID of the resource to lookup.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[builtins.str] arn: The Amazon Resource Name (ARN) identifying your Lambda function alias.
        :param pulumi.Input[builtins.str] description: Description of the alias.
        :param pulumi.Input[builtins.str] function_name: Lambda Function name or ARN.
        :param pulumi.Input[builtins.str] function_version: Lambda function version for which you are creating the alias. Pattern: `(\\$LATEST|[0-9]+)`.
        :param pulumi.Input[builtins.str] invoke_arn: The ARN to be used for invoking Lambda Function from API Gateway - to be used in `apigateway.Integration`'s `uri`
        :param pulumi.Input[builtins.str] name: Name for the alias you are creating. Pattern: `(?!^[0-9]+$)([a-zA-Z0-9-_]+)`
        :param pulumi.Input[Union['AliasRoutingConfigArgs', 'AliasRoutingConfigArgsDict']] routing_config: The Lambda alias' route configuration settings. Fields documented below
        """
        opts = pulumi.ResourceOptions.merge(opts, pulumi.ResourceOptions(id=id))

        __props__ = _AliasState.__new__(_AliasState)

        __props__.__dict__["arn"] = arn
        __props__.__dict__["description"] = description
        __props__.__dict__["function_name"] = function_name
        __props__.__dict__["function_version"] = function_version
        __props__.__dict__["invoke_arn"] = invoke_arn
        __props__.__dict__["name"] = name
        __props__.__dict__["routing_config"] = routing_config
        return Alias(resource_name, opts=opts, __props__=__props__)

    @property
    @pulumi.getter
    def arn(self) -> pulumi.Output[builtins.str]:
        """
        The Amazon Resource Name (ARN) identifying your Lambda function alias.
        """
        return pulumi.get(self, "arn")

    @property
    @pulumi.getter
    def description(self) -> pulumi.Output[Optional[builtins.str]]:
        """
        Description of the alias.
        """
        return pulumi.get(self, "description")

    @property
    @pulumi.getter(name="functionName")
    def function_name(self) -> pulumi.Output[builtins.str]:
        """
        Lambda Function name or ARN.
        """
        return pulumi.get(self, "function_name")

    @property
    @pulumi.getter(name="functionVersion")
    def function_version(self) -> pulumi.Output[builtins.str]:
        """
        Lambda function version for which you are creating the alias. Pattern: `(\\$LATEST|[0-9]+)`.
        """
        return pulumi.get(self, "function_version")

    @property
    @pulumi.getter(name="invokeArn")
    def invoke_arn(self) -> pulumi.Output[builtins.str]:
        """
        The ARN to be used for invoking Lambda Function from API Gateway - to be used in `apigateway.Integration`'s `uri`
        """
        return pulumi.get(self, "invoke_arn")

    @property
    @pulumi.getter
    def name(self) -> pulumi.Output[builtins.str]:
        """
        Name for the alias you are creating. Pattern: `(?!^[0-9]+$)([a-zA-Z0-9-_]+)`
        """
        return pulumi.get(self, "name")

    @property
    @pulumi.getter(name="routingConfig")
    def routing_config(self) -> pulumi.Output[Optional['outputs.AliasRoutingConfig']]:
        """
        The Lambda alias' route configuration settings. Fields documented below
        """
        return pulumi.get(self, "routing_config")

