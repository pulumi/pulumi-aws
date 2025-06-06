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

__all__ = ['LayerVersionPermissionArgs', 'LayerVersionPermission']

@pulumi.input_type
class LayerVersionPermissionArgs:
    def __init__(__self__, *,
                 action: pulumi.Input[builtins.str],
                 layer_name: pulumi.Input[builtins.str],
                 principal: pulumi.Input[builtins.str],
                 statement_id: pulumi.Input[builtins.str],
                 version_number: pulumi.Input[builtins.int],
                 organization_id: Optional[pulumi.Input[builtins.str]] = None,
                 skip_destroy: Optional[pulumi.Input[builtins.bool]] = None):
        """
        The set of arguments for constructing a LayerVersionPermission resource.
        :param pulumi.Input[builtins.str] action: Action, which will be allowed. `lambda:GetLayerVersion` value is suggested by AWS documantation.
        :param pulumi.Input[builtins.str] layer_name: The name or ARN of the Lambda Layer, which you want to grant access to.
        :param pulumi.Input[builtins.str] principal: AWS account ID which should be able to use your Lambda Layer. `*` can be used here, if you want to share your Lambda Layer widely.
        :param pulumi.Input[builtins.str] statement_id: The name of Lambda Layer Permission, for example `dev-account` - human readable note about what is this permission for.
        :param pulumi.Input[builtins.int] version_number: Version of Lambda Layer, which you want to grant access to. Note: permissions only apply to a single version of a layer.
        :param pulumi.Input[builtins.str] organization_id: An identifier of AWS Organization, which should be able to use your Lambda Layer. `principal` should be equal to `*` if `organization_id` provided.
        :param pulumi.Input[builtins.bool] skip_destroy: Whether to retain the old version of a previously deployed Lambda Layer. Default is `false`. When this is not set to `true`, changing any of `compatible_architectures`, `compatible_runtimes`, `description`, `filename`, `layer_name`, `license_info`, `s3_bucket`, `s3_key`, `s3_object_version`, or `source_code_hash` forces deletion of the existing layer version and creation of a new layer version.
        """
        pulumi.set(__self__, "action", action)
        pulumi.set(__self__, "layer_name", layer_name)
        pulumi.set(__self__, "principal", principal)
        pulumi.set(__self__, "statement_id", statement_id)
        pulumi.set(__self__, "version_number", version_number)
        if organization_id is not None:
            pulumi.set(__self__, "organization_id", organization_id)
        if skip_destroy is not None:
            pulumi.set(__self__, "skip_destroy", skip_destroy)

    @property
    @pulumi.getter
    def action(self) -> pulumi.Input[builtins.str]:
        """
        Action, which will be allowed. `lambda:GetLayerVersion` value is suggested by AWS documantation.
        """
        return pulumi.get(self, "action")

    @action.setter
    def action(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "action", value)

    @property
    @pulumi.getter(name="layerName")
    def layer_name(self) -> pulumi.Input[builtins.str]:
        """
        The name or ARN of the Lambda Layer, which you want to grant access to.
        """
        return pulumi.get(self, "layer_name")

    @layer_name.setter
    def layer_name(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "layer_name", value)

    @property
    @pulumi.getter
    def principal(self) -> pulumi.Input[builtins.str]:
        """
        AWS account ID which should be able to use your Lambda Layer. `*` can be used here, if you want to share your Lambda Layer widely.
        """
        return pulumi.get(self, "principal")

    @principal.setter
    def principal(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "principal", value)

    @property
    @pulumi.getter(name="statementId")
    def statement_id(self) -> pulumi.Input[builtins.str]:
        """
        The name of Lambda Layer Permission, for example `dev-account` - human readable note about what is this permission for.
        """
        return pulumi.get(self, "statement_id")

    @statement_id.setter
    def statement_id(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "statement_id", value)

    @property
    @pulumi.getter(name="versionNumber")
    def version_number(self) -> pulumi.Input[builtins.int]:
        """
        Version of Lambda Layer, which you want to grant access to. Note: permissions only apply to a single version of a layer.
        """
        return pulumi.get(self, "version_number")

    @version_number.setter
    def version_number(self, value: pulumi.Input[builtins.int]):
        pulumi.set(self, "version_number", value)

    @property
    @pulumi.getter(name="organizationId")
    def organization_id(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        An identifier of AWS Organization, which should be able to use your Lambda Layer. `principal` should be equal to `*` if `organization_id` provided.
        """
        return pulumi.get(self, "organization_id")

    @organization_id.setter
    def organization_id(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "organization_id", value)

    @property
    @pulumi.getter(name="skipDestroy")
    def skip_destroy(self) -> Optional[pulumi.Input[builtins.bool]]:
        """
        Whether to retain the old version of a previously deployed Lambda Layer. Default is `false`. When this is not set to `true`, changing any of `compatible_architectures`, `compatible_runtimes`, `description`, `filename`, `layer_name`, `license_info`, `s3_bucket`, `s3_key`, `s3_object_version`, or `source_code_hash` forces deletion of the existing layer version and creation of a new layer version.
        """
        return pulumi.get(self, "skip_destroy")

    @skip_destroy.setter
    def skip_destroy(self, value: Optional[pulumi.Input[builtins.bool]]):
        pulumi.set(self, "skip_destroy", value)


@pulumi.input_type
class _LayerVersionPermissionState:
    def __init__(__self__, *,
                 action: Optional[pulumi.Input[builtins.str]] = None,
                 layer_name: Optional[pulumi.Input[builtins.str]] = None,
                 organization_id: Optional[pulumi.Input[builtins.str]] = None,
                 policy: Optional[pulumi.Input[builtins.str]] = None,
                 principal: Optional[pulumi.Input[builtins.str]] = None,
                 revision_id: Optional[pulumi.Input[builtins.str]] = None,
                 skip_destroy: Optional[pulumi.Input[builtins.bool]] = None,
                 statement_id: Optional[pulumi.Input[builtins.str]] = None,
                 version_number: Optional[pulumi.Input[builtins.int]] = None):
        """
        Input properties used for looking up and filtering LayerVersionPermission resources.
        :param pulumi.Input[builtins.str] action: Action, which will be allowed. `lambda:GetLayerVersion` value is suggested by AWS documantation.
        :param pulumi.Input[builtins.str] layer_name: The name or ARN of the Lambda Layer, which you want to grant access to.
        :param pulumi.Input[builtins.str] organization_id: An identifier of AWS Organization, which should be able to use your Lambda Layer. `principal` should be equal to `*` if `organization_id` provided.
        :param pulumi.Input[builtins.str] policy: Full Lambda Layer Permission policy.
        :param pulumi.Input[builtins.str] principal: AWS account ID which should be able to use your Lambda Layer. `*` can be used here, if you want to share your Lambda Layer widely.
        :param pulumi.Input[builtins.str] revision_id: A unique identifier for the current revision of the policy.
        :param pulumi.Input[builtins.bool] skip_destroy: Whether to retain the old version of a previously deployed Lambda Layer. Default is `false`. When this is not set to `true`, changing any of `compatible_architectures`, `compatible_runtimes`, `description`, `filename`, `layer_name`, `license_info`, `s3_bucket`, `s3_key`, `s3_object_version`, or `source_code_hash` forces deletion of the existing layer version and creation of a new layer version.
        :param pulumi.Input[builtins.str] statement_id: The name of Lambda Layer Permission, for example `dev-account` - human readable note about what is this permission for.
        :param pulumi.Input[builtins.int] version_number: Version of Lambda Layer, which you want to grant access to. Note: permissions only apply to a single version of a layer.
        """
        if action is not None:
            pulumi.set(__self__, "action", action)
        if layer_name is not None:
            pulumi.set(__self__, "layer_name", layer_name)
        if organization_id is not None:
            pulumi.set(__self__, "organization_id", organization_id)
        if policy is not None:
            pulumi.set(__self__, "policy", policy)
        if principal is not None:
            pulumi.set(__self__, "principal", principal)
        if revision_id is not None:
            pulumi.set(__self__, "revision_id", revision_id)
        if skip_destroy is not None:
            pulumi.set(__self__, "skip_destroy", skip_destroy)
        if statement_id is not None:
            pulumi.set(__self__, "statement_id", statement_id)
        if version_number is not None:
            pulumi.set(__self__, "version_number", version_number)

    @property
    @pulumi.getter
    def action(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Action, which will be allowed. `lambda:GetLayerVersion` value is suggested by AWS documantation.
        """
        return pulumi.get(self, "action")

    @action.setter
    def action(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "action", value)

    @property
    @pulumi.getter(name="layerName")
    def layer_name(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The name or ARN of the Lambda Layer, which you want to grant access to.
        """
        return pulumi.get(self, "layer_name")

    @layer_name.setter
    def layer_name(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "layer_name", value)

    @property
    @pulumi.getter(name="organizationId")
    def organization_id(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        An identifier of AWS Organization, which should be able to use your Lambda Layer. `principal` should be equal to `*` if `organization_id` provided.
        """
        return pulumi.get(self, "organization_id")

    @organization_id.setter
    def organization_id(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "organization_id", value)

    @property
    @pulumi.getter
    def policy(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Full Lambda Layer Permission policy.
        """
        return pulumi.get(self, "policy")

    @policy.setter
    def policy(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "policy", value)

    @property
    @pulumi.getter
    def principal(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        AWS account ID which should be able to use your Lambda Layer. `*` can be used here, if you want to share your Lambda Layer widely.
        """
        return pulumi.get(self, "principal")

    @principal.setter
    def principal(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "principal", value)

    @property
    @pulumi.getter(name="revisionId")
    def revision_id(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        A unique identifier for the current revision of the policy.
        """
        return pulumi.get(self, "revision_id")

    @revision_id.setter
    def revision_id(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "revision_id", value)

    @property
    @pulumi.getter(name="skipDestroy")
    def skip_destroy(self) -> Optional[pulumi.Input[builtins.bool]]:
        """
        Whether to retain the old version of a previously deployed Lambda Layer. Default is `false`. When this is not set to `true`, changing any of `compatible_architectures`, `compatible_runtimes`, `description`, `filename`, `layer_name`, `license_info`, `s3_bucket`, `s3_key`, `s3_object_version`, or `source_code_hash` forces deletion of the existing layer version and creation of a new layer version.
        """
        return pulumi.get(self, "skip_destroy")

    @skip_destroy.setter
    def skip_destroy(self, value: Optional[pulumi.Input[builtins.bool]]):
        pulumi.set(self, "skip_destroy", value)

    @property
    @pulumi.getter(name="statementId")
    def statement_id(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The name of Lambda Layer Permission, for example `dev-account` - human readable note about what is this permission for.
        """
        return pulumi.get(self, "statement_id")

    @statement_id.setter
    def statement_id(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "statement_id", value)

    @property
    @pulumi.getter(name="versionNumber")
    def version_number(self) -> Optional[pulumi.Input[builtins.int]]:
        """
        Version of Lambda Layer, which you want to grant access to. Note: permissions only apply to a single version of a layer.
        """
        return pulumi.get(self, "version_number")

    @version_number.setter
    def version_number(self, value: Optional[pulumi.Input[builtins.int]]):
        pulumi.set(self, "version_number", value)


@pulumi.type_token("aws:lambda/layerVersionPermission:LayerVersionPermission")
class LayerVersionPermission(pulumi.CustomResource):
    @overload
    def __init__(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 action: Optional[pulumi.Input[builtins.str]] = None,
                 layer_name: Optional[pulumi.Input[builtins.str]] = None,
                 organization_id: Optional[pulumi.Input[builtins.str]] = None,
                 principal: Optional[pulumi.Input[builtins.str]] = None,
                 skip_destroy: Optional[pulumi.Input[builtins.bool]] = None,
                 statement_id: Optional[pulumi.Input[builtins.str]] = None,
                 version_number: Optional[pulumi.Input[builtins.int]] = None,
                 __props__=None):
        """
        Provides a Lambda Layer Version Permission resource. It allows you to share you own Lambda Layers to another account by account ID, to all accounts in AWS organization or even to all AWS accounts.

        For information about Lambda Layer Permissions and how to use them, see [Using Resource-based Policies for AWS Lambda][1]

        > **NOTE:** Setting `skip_destroy` to `true` means that the AWS Provider will _not_ destroy any layer version permission, even when running `pulumi destroy`. Layer version permissions are thus intentional dangling resources that are _not_ managed by Pulumi and may incur extra expense in your AWS account.

        ## Example Usage

        ```python
        import pulumi
        import pulumi_aws as aws

        lambda_layer_permission = aws.lambda_.LayerVersionPermission("lambda_layer_permission",
            layer_name="arn:aws:lambda:us-west-2:123456654321:layer:test_layer1",
            version_number=1,
            principal="111111111111",
            action="lambda:GetLayerVersion",
            statement_id="dev-account")
        ```

        ## Import

        Using `pulumi import`, import Lambda Layer Permissions using `layer_name` and `version_number`, separated by a comma (`,`). For example:

        ```sh
        $ pulumi import aws:lambda/layerVersionPermission:LayerVersionPermission example arn:aws:lambda:us-west-2:123456654321:layer:test_layer1,1
        ```

        :param str resource_name: The name of the resource.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[builtins.str] action: Action, which will be allowed. `lambda:GetLayerVersion` value is suggested by AWS documantation.
        :param pulumi.Input[builtins.str] layer_name: The name or ARN of the Lambda Layer, which you want to grant access to.
        :param pulumi.Input[builtins.str] organization_id: An identifier of AWS Organization, which should be able to use your Lambda Layer. `principal` should be equal to `*` if `organization_id` provided.
        :param pulumi.Input[builtins.str] principal: AWS account ID which should be able to use your Lambda Layer. `*` can be used here, if you want to share your Lambda Layer widely.
        :param pulumi.Input[builtins.bool] skip_destroy: Whether to retain the old version of a previously deployed Lambda Layer. Default is `false`. When this is not set to `true`, changing any of `compatible_architectures`, `compatible_runtimes`, `description`, `filename`, `layer_name`, `license_info`, `s3_bucket`, `s3_key`, `s3_object_version`, or `source_code_hash` forces deletion of the existing layer version and creation of a new layer version.
        :param pulumi.Input[builtins.str] statement_id: The name of Lambda Layer Permission, for example `dev-account` - human readable note about what is this permission for.
        :param pulumi.Input[builtins.int] version_number: Version of Lambda Layer, which you want to grant access to. Note: permissions only apply to a single version of a layer.
        """
        ...
    @overload
    def __init__(__self__,
                 resource_name: str,
                 args: LayerVersionPermissionArgs,
                 opts: Optional[pulumi.ResourceOptions] = None):
        """
        Provides a Lambda Layer Version Permission resource. It allows you to share you own Lambda Layers to another account by account ID, to all accounts in AWS organization or even to all AWS accounts.

        For information about Lambda Layer Permissions and how to use them, see [Using Resource-based Policies for AWS Lambda][1]

        > **NOTE:** Setting `skip_destroy` to `true` means that the AWS Provider will _not_ destroy any layer version permission, even when running `pulumi destroy`. Layer version permissions are thus intentional dangling resources that are _not_ managed by Pulumi and may incur extra expense in your AWS account.

        ## Example Usage

        ```python
        import pulumi
        import pulumi_aws as aws

        lambda_layer_permission = aws.lambda_.LayerVersionPermission("lambda_layer_permission",
            layer_name="arn:aws:lambda:us-west-2:123456654321:layer:test_layer1",
            version_number=1,
            principal="111111111111",
            action="lambda:GetLayerVersion",
            statement_id="dev-account")
        ```

        ## Import

        Using `pulumi import`, import Lambda Layer Permissions using `layer_name` and `version_number`, separated by a comma (`,`). For example:

        ```sh
        $ pulumi import aws:lambda/layerVersionPermission:LayerVersionPermission example arn:aws:lambda:us-west-2:123456654321:layer:test_layer1,1
        ```

        :param str resource_name: The name of the resource.
        :param LayerVersionPermissionArgs args: The arguments to use to populate this resource's properties.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        ...
    def __init__(__self__, resource_name: str, *args, **kwargs):
        resource_args, opts = _utilities.get_resource_args_opts(LayerVersionPermissionArgs, pulumi.ResourceOptions, *args, **kwargs)
        if resource_args is not None:
            __self__._internal_init(resource_name, opts, **resource_args.__dict__)
        else:
            __self__._internal_init(resource_name, *args, **kwargs)

    def _internal_init(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 action: Optional[pulumi.Input[builtins.str]] = None,
                 layer_name: Optional[pulumi.Input[builtins.str]] = None,
                 organization_id: Optional[pulumi.Input[builtins.str]] = None,
                 principal: Optional[pulumi.Input[builtins.str]] = None,
                 skip_destroy: Optional[pulumi.Input[builtins.bool]] = None,
                 statement_id: Optional[pulumi.Input[builtins.str]] = None,
                 version_number: Optional[pulumi.Input[builtins.int]] = None,
                 __props__=None):
        opts = pulumi.ResourceOptions.merge(_utilities.get_resource_opts_defaults(), opts)
        if not isinstance(opts, pulumi.ResourceOptions):
            raise TypeError('Expected resource options to be a ResourceOptions instance')
        if opts.id is None:
            if __props__ is not None:
                raise TypeError('__props__ is only valid when passed in combination with a valid opts.id to get an existing resource')
            __props__ = LayerVersionPermissionArgs.__new__(LayerVersionPermissionArgs)

            if action is None and not opts.urn:
                raise TypeError("Missing required property 'action'")
            __props__.__dict__["action"] = action
            if layer_name is None and not opts.urn:
                raise TypeError("Missing required property 'layer_name'")
            __props__.__dict__["layer_name"] = layer_name
            __props__.__dict__["organization_id"] = organization_id
            if principal is None and not opts.urn:
                raise TypeError("Missing required property 'principal'")
            __props__.__dict__["principal"] = principal
            __props__.__dict__["skip_destroy"] = skip_destroy
            if statement_id is None and not opts.urn:
                raise TypeError("Missing required property 'statement_id'")
            __props__.__dict__["statement_id"] = statement_id
            if version_number is None and not opts.urn:
                raise TypeError("Missing required property 'version_number'")
            __props__.__dict__["version_number"] = version_number
            __props__.__dict__["policy"] = None
            __props__.__dict__["revision_id"] = None
        super(LayerVersionPermission, __self__).__init__(
            'aws:lambda/layerVersionPermission:LayerVersionPermission',
            resource_name,
            __props__,
            opts)

    @staticmethod
    def get(resource_name: str,
            id: pulumi.Input[str],
            opts: Optional[pulumi.ResourceOptions] = None,
            action: Optional[pulumi.Input[builtins.str]] = None,
            layer_name: Optional[pulumi.Input[builtins.str]] = None,
            organization_id: Optional[pulumi.Input[builtins.str]] = None,
            policy: Optional[pulumi.Input[builtins.str]] = None,
            principal: Optional[pulumi.Input[builtins.str]] = None,
            revision_id: Optional[pulumi.Input[builtins.str]] = None,
            skip_destroy: Optional[pulumi.Input[builtins.bool]] = None,
            statement_id: Optional[pulumi.Input[builtins.str]] = None,
            version_number: Optional[pulumi.Input[builtins.int]] = None) -> 'LayerVersionPermission':
        """
        Get an existing LayerVersionPermission resource's state with the given name, id, and optional extra
        properties used to qualify the lookup.

        :param str resource_name: The unique name of the resulting resource.
        :param pulumi.Input[str] id: The unique provider ID of the resource to lookup.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[builtins.str] action: Action, which will be allowed. `lambda:GetLayerVersion` value is suggested by AWS documantation.
        :param pulumi.Input[builtins.str] layer_name: The name or ARN of the Lambda Layer, which you want to grant access to.
        :param pulumi.Input[builtins.str] organization_id: An identifier of AWS Organization, which should be able to use your Lambda Layer. `principal` should be equal to `*` if `organization_id` provided.
        :param pulumi.Input[builtins.str] policy: Full Lambda Layer Permission policy.
        :param pulumi.Input[builtins.str] principal: AWS account ID which should be able to use your Lambda Layer. `*` can be used here, if you want to share your Lambda Layer widely.
        :param pulumi.Input[builtins.str] revision_id: A unique identifier for the current revision of the policy.
        :param pulumi.Input[builtins.bool] skip_destroy: Whether to retain the old version of a previously deployed Lambda Layer. Default is `false`. When this is not set to `true`, changing any of `compatible_architectures`, `compatible_runtimes`, `description`, `filename`, `layer_name`, `license_info`, `s3_bucket`, `s3_key`, `s3_object_version`, or `source_code_hash` forces deletion of the existing layer version and creation of a new layer version.
        :param pulumi.Input[builtins.str] statement_id: The name of Lambda Layer Permission, for example `dev-account` - human readable note about what is this permission for.
        :param pulumi.Input[builtins.int] version_number: Version of Lambda Layer, which you want to grant access to. Note: permissions only apply to a single version of a layer.
        """
        opts = pulumi.ResourceOptions.merge(opts, pulumi.ResourceOptions(id=id))

        __props__ = _LayerVersionPermissionState.__new__(_LayerVersionPermissionState)

        __props__.__dict__["action"] = action
        __props__.__dict__["layer_name"] = layer_name
        __props__.__dict__["organization_id"] = organization_id
        __props__.__dict__["policy"] = policy
        __props__.__dict__["principal"] = principal
        __props__.__dict__["revision_id"] = revision_id
        __props__.__dict__["skip_destroy"] = skip_destroy
        __props__.__dict__["statement_id"] = statement_id
        __props__.__dict__["version_number"] = version_number
        return LayerVersionPermission(resource_name, opts=opts, __props__=__props__)

    @property
    @pulumi.getter
    def action(self) -> pulumi.Output[builtins.str]:
        """
        Action, which will be allowed. `lambda:GetLayerVersion` value is suggested by AWS documantation.
        """
        return pulumi.get(self, "action")

    @property
    @pulumi.getter(name="layerName")
    def layer_name(self) -> pulumi.Output[builtins.str]:
        """
        The name or ARN of the Lambda Layer, which you want to grant access to.
        """
        return pulumi.get(self, "layer_name")

    @property
    @pulumi.getter(name="organizationId")
    def organization_id(self) -> pulumi.Output[Optional[builtins.str]]:
        """
        An identifier of AWS Organization, which should be able to use your Lambda Layer. `principal` should be equal to `*` if `organization_id` provided.
        """
        return pulumi.get(self, "organization_id")

    @property
    @pulumi.getter
    def policy(self) -> pulumi.Output[builtins.str]:
        """
        Full Lambda Layer Permission policy.
        """
        return pulumi.get(self, "policy")

    @property
    @pulumi.getter
    def principal(self) -> pulumi.Output[builtins.str]:
        """
        AWS account ID which should be able to use your Lambda Layer. `*` can be used here, if you want to share your Lambda Layer widely.
        """
        return pulumi.get(self, "principal")

    @property
    @pulumi.getter(name="revisionId")
    def revision_id(self) -> pulumi.Output[builtins.str]:
        """
        A unique identifier for the current revision of the policy.
        """
        return pulumi.get(self, "revision_id")

    @property
    @pulumi.getter(name="skipDestroy")
    def skip_destroy(self) -> pulumi.Output[Optional[builtins.bool]]:
        """
        Whether to retain the old version of a previously deployed Lambda Layer. Default is `false`. When this is not set to `true`, changing any of `compatible_architectures`, `compatible_runtimes`, `description`, `filename`, `layer_name`, `license_info`, `s3_bucket`, `s3_key`, `s3_object_version`, or `source_code_hash` forces deletion of the existing layer version and creation of a new layer version.
        """
        return pulumi.get(self, "skip_destroy")

    @property
    @pulumi.getter(name="statementId")
    def statement_id(self) -> pulumi.Output[builtins.str]:
        """
        The name of Lambda Layer Permission, for example `dev-account` - human readable note about what is this permission for.
        """
        return pulumi.get(self, "statement_id")

    @property
    @pulumi.getter(name="versionNumber")
    def version_number(self) -> pulumi.Output[builtins.int]:
        """
        Version of Lambda Layer, which you want to grant access to. Note: permissions only apply to a single version of a layer.
        """
        return pulumi.get(self, "version_number")

