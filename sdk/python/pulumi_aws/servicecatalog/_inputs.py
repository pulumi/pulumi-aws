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

__all__ = [
    'ProductProvisioningArtifactParametersArgs',
    'ProductProvisioningArtifactParametersArgsDict',
    'ProvisionedProductOutputArgs',
    'ProvisionedProductOutputArgsDict',
    'ProvisionedProductProvisioningParameterArgs',
    'ProvisionedProductProvisioningParameterArgsDict',
    'ProvisionedProductStackSetProvisioningPreferencesArgs',
    'ProvisionedProductStackSetProvisioningPreferencesArgsDict',
    'ServiceActionDefinitionArgs',
    'ServiceActionDefinitionArgsDict',
]

MYPY = False

if not MYPY:
    class ProductProvisioningArtifactParametersArgsDict(TypedDict):
        description: NotRequired[pulumi.Input[builtins.str]]
        """
        Description of the provisioning artifact (i.e., version), including how it differs from the previous provisioning artifact.
        """
        disable_template_validation: NotRequired[pulumi.Input[builtins.bool]]
        """
        Whether AWS Service Catalog stops validating the specified provisioning artifact template even if it is invalid.
        """
        name: NotRequired[pulumi.Input[builtins.str]]
        """
        Name of the provisioning artifact (for example, `v1`, `v2beta`). No spaces are allowed.
        """
        template_physical_id: NotRequired[pulumi.Input[builtins.str]]
        """
        Template source as the physical ID of the resource that contains the template. Currently only supports CloudFormation stack ARN. Specify the physical ID as `arn:[partition]:cloudformation:[region]:[account ID]:stack/[stack name]/[resource ID]`.
        """
        template_url: NotRequired[pulumi.Input[builtins.str]]
        """
        Template source as URL of the CloudFormation template in Amazon S3.
        """
        type: NotRequired[pulumi.Input[builtins.str]]
        """
        Type of provisioning artifact. See [AWS Docs](https://docs.aws.amazon.com/servicecatalog/latest/dg/API_ProvisioningArtifactProperties.html) for valid list of values.
        """
elif False:
    ProductProvisioningArtifactParametersArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class ProductProvisioningArtifactParametersArgs:
    def __init__(__self__, *,
                 description: Optional[pulumi.Input[builtins.str]] = None,
                 disable_template_validation: Optional[pulumi.Input[builtins.bool]] = None,
                 name: Optional[pulumi.Input[builtins.str]] = None,
                 template_physical_id: Optional[pulumi.Input[builtins.str]] = None,
                 template_url: Optional[pulumi.Input[builtins.str]] = None,
                 type: Optional[pulumi.Input[builtins.str]] = None):
        """
        :param pulumi.Input[builtins.str] description: Description of the provisioning artifact (i.e., version), including how it differs from the previous provisioning artifact.
        :param pulumi.Input[builtins.bool] disable_template_validation: Whether AWS Service Catalog stops validating the specified provisioning artifact template even if it is invalid.
        :param pulumi.Input[builtins.str] name: Name of the provisioning artifact (for example, `v1`, `v2beta`). No spaces are allowed.
        :param pulumi.Input[builtins.str] template_physical_id: Template source as the physical ID of the resource that contains the template. Currently only supports CloudFormation stack ARN. Specify the physical ID as `arn:[partition]:cloudformation:[region]:[account ID]:stack/[stack name]/[resource ID]`.
        :param pulumi.Input[builtins.str] template_url: Template source as URL of the CloudFormation template in Amazon S3.
        :param pulumi.Input[builtins.str] type: Type of provisioning artifact. See [AWS Docs](https://docs.aws.amazon.com/servicecatalog/latest/dg/API_ProvisioningArtifactProperties.html) for valid list of values.
        """
        if description is not None:
            pulumi.set(__self__, "description", description)
        if disable_template_validation is not None:
            pulumi.set(__self__, "disable_template_validation", disable_template_validation)
        if name is not None:
            pulumi.set(__self__, "name", name)
        if template_physical_id is not None:
            pulumi.set(__self__, "template_physical_id", template_physical_id)
        if template_url is not None:
            pulumi.set(__self__, "template_url", template_url)
        if type is not None:
            pulumi.set(__self__, "type", type)

    @property
    @pulumi.getter
    def description(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Description of the provisioning artifact (i.e., version), including how it differs from the previous provisioning artifact.
        """
        return pulumi.get(self, "description")

    @description.setter
    def description(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "description", value)

    @property
    @pulumi.getter(name="disableTemplateValidation")
    def disable_template_validation(self) -> Optional[pulumi.Input[builtins.bool]]:
        """
        Whether AWS Service Catalog stops validating the specified provisioning artifact template even if it is invalid.
        """
        return pulumi.get(self, "disable_template_validation")

    @disable_template_validation.setter
    def disable_template_validation(self, value: Optional[pulumi.Input[builtins.bool]]):
        pulumi.set(self, "disable_template_validation", value)

    @property
    @pulumi.getter
    def name(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Name of the provisioning artifact (for example, `v1`, `v2beta`). No spaces are allowed.
        """
        return pulumi.get(self, "name")

    @name.setter
    def name(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "name", value)

    @property
    @pulumi.getter(name="templatePhysicalId")
    def template_physical_id(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Template source as the physical ID of the resource that contains the template. Currently only supports CloudFormation stack ARN. Specify the physical ID as `arn:[partition]:cloudformation:[region]:[account ID]:stack/[stack name]/[resource ID]`.
        """
        return pulumi.get(self, "template_physical_id")

    @template_physical_id.setter
    def template_physical_id(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "template_physical_id", value)

    @property
    @pulumi.getter(name="templateUrl")
    def template_url(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Template source as URL of the CloudFormation template in Amazon S3.
        """
        return pulumi.get(self, "template_url")

    @template_url.setter
    def template_url(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "template_url", value)

    @property
    @pulumi.getter
    def type(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Type of provisioning artifact. See [AWS Docs](https://docs.aws.amazon.com/servicecatalog/latest/dg/API_ProvisioningArtifactProperties.html) for valid list of values.
        """
        return pulumi.get(self, "type")

    @type.setter
    def type(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "type", value)


if not MYPY:
    class ProvisionedProductOutputArgsDict(TypedDict):
        description: NotRequired[pulumi.Input[builtins.str]]
        """
        The description of the output.
        """
        key: NotRequired[pulumi.Input[builtins.str]]
        """
        The output key.
        """
        value: NotRequired[pulumi.Input[builtins.str]]
        """
        The output value.
        """
elif False:
    ProvisionedProductOutputArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class ProvisionedProductOutputArgs:
    def __init__(__self__, *,
                 description: Optional[pulumi.Input[builtins.str]] = None,
                 key: Optional[pulumi.Input[builtins.str]] = None,
                 value: Optional[pulumi.Input[builtins.str]] = None):
        """
        :param pulumi.Input[builtins.str] description: The description of the output.
        :param pulumi.Input[builtins.str] key: The output key.
        :param pulumi.Input[builtins.str] value: The output value.
        """
        if description is not None:
            pulumi.set(__self__, "description", description)
        if key is not None:
            pulumi.set(__self__, "key", key)
        if value is not None:
            pulumi.set(__self__, "value", value)

    @property
    @pulumi.getter
    def description(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The description of the output.
        """
        return pulumi.get(self, "description")

    @description.setter
    def description(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "description", value)

    @property
    @pulumi.getter
    def key(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The output key.
        """
        return pulumi.get(self, "key")

    @key.setter
    def key(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "key", value)

    @property
    @pulumi.getter
    def value(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The output value.
        """
        return pulumi.get(self, "value")

    @value.setter
    def value(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "value", value)


if not MYPY:
    class ProvisionedProductProvisioningParameterArgsDict(TypedDict):
        key: pulumi.Input[builtins.str]
        """
        Parameter key.
        """
        use_previous_value: NotRequired[pulumi.Input[builtins.bool]]
        """
        Whether to ignore `value` and keep the previous parameter value. Ignored when initially provisioning a product.
        """
        value: NotRequired[pulumi.Input[builtins.str]]
        """
        Parameter value.
        """
elif False:
    ProvisionedProductProvisioningParameterArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class ProvisionedProductProvisioningParameterArgs:
    def __init__(__self__, *,
                 key: pulumi.Input[builtins.str],
                 use_previous_value: Optional[pulumi.Input[builtins.bool]] = None,
                 value: Optional[pulumi.Input[builtins.str]] = None):
        """
        :param pulumi.Input[builtins.str] key: Parameter key.
        :param pulumi.Input[builtins.bool] use_previous_value: Whether to ignore `value` and keep the previous parameter value. Ignored when initially provisioning a product.
        :param pulumi.Input[builtins.str] value: Parameter value.
        """
        pulumi.set(__self__, "key", key)
        if use_previous_value is not None:
            pulumi.set(__self__, "use_previous_value", use_previous_value)
        if value is not None:
            pulumi.set(__self__, "value", value)

    @property
    @pulumi.getter
    def key(self) -> pulumi.Input[builtins.str]:
        """
        Parameter key.
        """
        return pulumi.get(self, "key")

    @key.setter
    def key(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "key", value)

    @property
    @pulumi.getter(name="usePreviousValue")
    def use_previous_value(self) -> Optional[pulumi.Input[builtins.bool]]:
        """
        Whether to ignore `value` and keep the previous parameter value. Ignored when initially provisioning a product.
        """
        return pulumi.get(self, "use_previous_value")

    @use_previous_value.setter
    def use_previous_value(self, value: Optional[pulumi.Input[builtins.bool]]):
        pulumi.set(self, "use_previous_value", value)

    @property
    @pulumi.getter
    def value(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Parameter value.
        """
        return pulumi.get(self, "value")

    @value.setter
    def value(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "value", value)


if not MYPY:
    class ProvisionedProductStackSetProvisioningPreferencesArgsDict(TypedDict):
        accounts: NotRequired[pulumi.Input[Sequence[pulumi.Input[builtins.str]]]]
        """
        One or more AWS accounts that will have access to the provisioned product. The AWS accounts specified should be within the list of accounts in the STACKSET constraint. To get the list of accounts in the STACKSET constraint, use the `aws_servicecatalog_provisioning_parameters` data source. If no values are specified, the default value is all accounts from the STACKSET constraint.
        """
        failure_tolerance_count: NotRequired[pulumi.Input[builtins.int]]
        """
        Number of accounts, per region, for which this operation can fail before AWS Service Catalog stops the operation in that region. If the operation is stopped in a region, AWS Service Catalog doesn't attempt the operation in any subsequent regions. You must specify either `failure_tolerance_count` or `failure_tolerance_percentage`, but not both. The default value is 0 if no value is specified.
        """
        failure_tolerance_percentage: NotRequired[pulumi.Input[builtins.int]]
        """
        Percentage of accounts, per region, for which this stack operation can fail before AWS Service Catalog stops the operation in that region. If the operation is stopped in a region, AWS Service Catalog doesn't attempt the operation in any subsequent regions. When calculating the number of accounts based on the specified percentage, AWS Service Catalog rounds down to the next whole number. You must specify either `failure_tolerance_count` or `failure_tolerance_percentage`, but not both.
        """
        max_concurrency_count: NotRequired[pulumi.Input[builtins.int]]
        """
        Maximum number of accounts in which to perform this operation at one time. This is dependent on the value of `failure_tolerance_count`. `max_concurrency_count` is at most one more than the `failure_tolerance_count`. Note that this setting lets you specify the maximum for operations. For large deployments, under certain circumstances the actual number of accounts acted upon concurrently may be lower due to service throttling. You must specify either `max_concurrency_count` or `max_concurrency_percentage`, but not both.
        """
        max_concurrency_percentage: NotRequired[pulumi.Input[builtins.int]]
        """
        Maximum percentage of accounts in which to perform this operation at one time. When calculating the number of accounts based on the specified percentage, AWS Service Catalog rounds down to the next whole number. This is true except in cases where rounding down would result is zero. In this case, AWS Service Catalog sets the number as 1 instead. Note that this setting lets you specify the maximum for operations. For large deployments, under certain circumstances the actual number of accounts acted upon concurrently may be lower due to service throttling. You must specify either `max_concurrency_count` or `max_concurrency_percentage`, but not both.
        """
        regions: NotRequired[pulumi.Input[Sequence[pulumi.Input[builtins.str]]]]
        """
        One or more AWS Regions where the provisioned product will be available. The specified regions should be within the list of regions from the STACKSET constraint. To get the list of regions in the STACKSET constraint, use the `aws_servicecatalog_provisioning_parameters` data source. If no values are specified, the default value is all regions from the STACKSET constraint.
        """
elif False:
    ProvisionedProductStackSetProvisioningPreferencesArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class ProvisionedProductStackSetProvisioningPreferencesArgs:
    def __init__(__self__, *,
                 accounts: Optional[pulumi.Input[Sequence[pulumi.Input[builtins.str]]]] = None,
                 failure_tolerance_count: Optional[pulumi.Input[builtins.int]] = None,
                 failure_tolerance_percentage: Optional[pulumi.Input[builtins.int]] = None,
                 max_concurrency_count: Optional[pulumi.Input[builtins.int]] = None,
                 max_concurrency_percentage: Optional[pulumi.Input[builtins.int]] = None,
                 regions: Optional[pulumi.Input[Sequence[pulumi.Input[builtins.str]]]] = None):
        """
        :param pulumi.Input[Sequence[pulumi.Input[builtins.str]]] accounts: One or more AWS accounts that will have access to the provisioned product. The AWS accounts specified should be within the list of accounts in the STACKSET constraint. To get the list of accounts in the STACKSET constraint, use the `aws_servicecatalog_provisioning_parameters` data source. If no values are specified, the default value is all accounts from the STACKSET constraint.
        :param pulumi.Input[builtins.int] failure_tolerance_count: Number of accounts, per region, for which this operation can fail before AWS Service Catalog stops the operation in that region. If the operation is stopped in a region, AWS Service Catalog doesn't attempt the operation in any subsequent regions. You must specify either `failure_tolerance_count` or `failure_tolerance_percentage`, but not both. The default value is 0 if no value is specified.
        :param pulumi.Input[builtins.int] failure_tolerance_percentage: Percentage of accounts, per region, for which this stack operation can fail before AWS Service Catalog stops the operation in that region. If the operation is stopped in a region, AWS Service Catalog doesn't attempt the operation in any subsequent regions. When calculating the number of accounts based on the specified percentage, AWS Service Catalog rounds down to the next whole number. You must specify either `failure_tolerance_count` or `failure_tolerance_percentage`, but not both.
        :param pulumi.Input[builtins.int] max_concurrency_count: Maximum number of accounts in which to perform this operation at one time. This is dependent on the value of `failure_tolerance_count`. `max_concurrency_count` is at most one more than the `failure_tolerance_count`. Note that this setting lets you specify the maximum for operations. For large deployments, under certain circumstances the actual number of accounts acted upon concurrently may be lower due to service throttling. You must specify either `max_concurrency_count` or `max_concurrency_percentage`, but not both.
        :param pulumi.Input[builtins.int] max_concurrency_percentage: Maximum percentage of accounts in which to perform this operation at one time. When calculating the number of accounts based on the specified percentage, AWS Service Catalog rounds down to the next whole number. This is true except in cases where rounding down would result is zero. In this case, AWS Service Catalog sets the number as 1 instead. Note that this setting lets you specify the maximum for operations. For large deployments, under certain circumstances the actual number of accounts acted upon concurrently may be lower due to service throttling. You must specify either `max_concurrency_count` or `max_concurrency_percentage`, but not both.
        :param pulumi.Input[Sequence[pulumi.Input[builtins.str]]] regions: One or more AWS Regions where the provisioned product will be available. The specified regions should be within the list of regions from the STACKSET constraint. To get the list of regions in the STACKSET constraint, use the `aws_servicecatalog_provisioning_parameters` data source. If no values are specified, the default value is all regions from the STACKSET constraint.
        """
        if accounts is not None:
            pulumi.set(__self__, "accounts", accounts)
        if failure_tolerance_count is not None:
            pulumi.set(__self__, "failure_tolerance_count", failure_tolerance_count)
        if failure_tolerance_percentage is not None:
            pulumi.set(__self__, "failure_tolerance_percentage", failure_tolerance_percentage)
        if max_concurrency_count is not None:
            pulumi.set(__self__, "max_concurrency_count", max_concurrency_count)
        if max_concurrency_percentage is not None:
            pulumi.set(__self__, "max_concurrency_percentage", max_concurrency_percentage)
        if regions is not None:
            pulumi.set(__self__, "regions", regions)

    @property
    @pulumi.getter
    def accounts(self) -> Optional[pulumi.Input[Sequence[pulumi.Input[builtins.str]]]]:
        """
        One or more AWS accounts that will have access to the provisioned product. The AWS accounts specified should be within the list of accounts in the STACKSET constraint. To get the list of accounts in the STACKSET constraint, use the `aws_servicecatalog_provisioning_parameters` data source. If no values are specified, the default value is all accounts from the STACKSET constraint.
        """
        return pulumi.get(self, "accounts")

    @accounts.setter
    def accounts(self, value: Optional[pulumi.Input[Sequence[pulumi.Input[builtins.str]]]]):
        pulumi.set(self, "accounts", value)

    @property
    @pulumi.getter(name="failureToleranceCount")
    def failure_tolerance_count(self) -> Optional[pulumi.Input[builtins.int]]:
        """
        Number of accounts, per region, for which this operation can fail before AWS Service Catalog stops the operation in that region. If the operation is stopped in a region, AWS Service Catalog doesn't attempt the operation in any subsequent regions. You must specify either `failure_tolerance_count` or `failure_tolerance_percentage`, but not both. The default value is 0 if no value is specified.
        """
        return pulumi.get(self, "failure_tolerance_count")

    @failure_tolerance_count.setter
    def failure_tolerance_count(self, value: Optional[pulumi.Input[builtins.int]]):
        pulumi.set(self, "failure_tolerance_count", value)

    @property
    @pulumi.getter(name="failureTolerancePercentage")
    def failure_tolerance_percentage(self) -> Optional[pulumi.Input[builtins.int]]:
        """
        Percentage of accounts, per region, for which this stack operation can fail before AWS Service Catalog stops the operation in that region. If the operation is stopped in a region, AWS Service Catalog doesn't attempt the operation in any subsequent regions. When calculating the number of accounts based on the specified percentage, AWS Service Catalog rounds down to the next whole number. You must specify either `failure_tolerance_count` or `failure_tolerance_percentage`, but not both.
        """
        return pulumi.get(self, "failure_tolerance_percentage")

    @failure_tolerance_percentage.setter
    def failure_tolerance_percentage(self, value: Optional[pulumi.Input[builtins.int]]):
        pulumi.set(self, "failure_tolerance_percentage", value)

    @property
    @pulumi.getter(name="maxConcurrencyCount")
    def max_concurrency_count(self) -> Optional[pulumi.Input[builtins.int]]:
        """
        Maximum number of accounts in which to perform this operation at one time. This is dependent on the value of `failure_tolerance_count`. `max_concurrency_count` is at most one more than the `failure_tolerance_count`. Note that this setting lets you specify the maximum for operations. For large deployments, under certain circumstances the actual number of accounts acted upon concurrently may be lower due to service throttling. You must specify either `max_concurrency_count` or `max_concurrency_percentage`, but not both.
        """
        return pulumi.get(self, "max_concurrency_count")

    @max_concurrency_count.setter
    def max_concurrency_count(self, value: Optional[pulumi.Input[builtins.int]]):
        pulumi.set(self, "max_concurrency_count", value)

    @property
    @pulumi.getter(name="maxConcurrencyPercentage")
    def max_concurrency_percentage(self) -> Optional[pulumi.Input[builtins.int]]:
        """
        Maximum percentage of accounts in which to perform this operation at one time. When calculating the number of accounts based on the specified percentage, AWS Service Catalog rounds down to the next whole number. This is true except in cases where rounding down would result is zero. In this case, AWS Service Catalog sets the number as 1 instead. Note that this setting lets you specify the maximum for operations. For large deployments, under certain circumstances the actual number of accounts acted upon concurrently may be lower due to service throttling. You must specify either `max_concurrency_count` or `max_concurrency_percentage`, but not both.
        """
        return pulumi.get(self, "max_concurrency_percentage")

    @max_concurrency_percentage.setter
    def max_concurrency_percentage(self, value: Optional[pulumi.Input[builtins.int]]):
        pulumi.set(self, "max_concurrency_percentage", value)

    @property
    @pulumi.getter
    def regions(self) -> Optional[pulumi.Input[Sequence[pulumi.Input[builtins.str]]]]:
        """
        One or more AWS Regions where the provisioned product will be available. The specified regions should be within the list of regions from the STACKSET constraint. To get the list of regions in the STACKSET constraint, use the `aws_servicecatalog_provisioning_parameters` data source. If no values are specified, the default value is all regions from the STACKSET constraint.
        """
        return pulumi.get(self, "regions")

    @regions.setter
    def regions(self, value: Optional[pulumi.Input[Sequence[pulumi.Input[builtins.str]]]]):
        pulumi.set(self, "regions", value)


if not MYPY:
    class ServiceActionDefinitionArgsDict(TypedDict):
        name: pulumi.Input[builtins.str]
        """
        Name of the SSM document. For example, `AWS-RestartEC2Instance`. If you are using a shared SSM document, you must provide the ARN instead of the name.
        """
        version: pulumi.Input[builtins.str]
        """
        SSM document version. For example, `1`.
        """
        assume_role: NotRequired[pulumi.Input[builtins.str]]
        """
        ARN of the role that performs the self-service actions on your behalf. For example, `arn:aws:iam::12345678910:role/ActionRole`. To reuse the provisioned product launch role, set to `LAUNCH_ROLE`.
        """
        parameters: NotRequired[pulumi.Input[builtins.str]]
        """
        List of parameters in JSON format. For example: `[{\\"Name\\":\\"InstanceId\\",\\"Type\\":\\"TARGET\\"}]` or `[{\\"Name\\":\\"InstanceId\\",\\"Type\\":\\"TEXT_VALUE\\"}]`.
        """
        type: NotRequired[pulumi.Input[builtins.str]]
        """
        Service action definition type. Valid value is `SSM_AUTOMATION`. Default is `SSM_AUTOMATION`.
        """
elif False:
    ServiceActionDefinitionArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class ServiceActionDefinitionArgs:
    def __init__(__self__, *,
                 name: pulumi.Input[builtins.str],
                 version: pulumi.Input[builtins.str],
                 assume_role: Optional[pulumi.Input[builtins.str]] = None,
                 parameters: Optional[pulumi.Input[builtins.str]] = None,
                 type: Optional[pulumi.Input[builtins.str]] = None):
        """
        :param pulumi.Input[builtins.str] name: Name of the SSM document. For example, `AWS-RestartEC2Instance`. If you are using a shared SSM document, you must provide the ARN instead of the name.
        :param pulumi.Input[builtins.str] version: SSM document version. For example, `1`.
        :param pulumi.Input[builtins.str] assume_role: ARN of the role that performs the self-service actions on your behalf. For example, `arn:aws:iam::12345678910:role/ActionRole`. To reuse the provisioned product launch role, set to `LAUNCH_ROLE`.
        :param pulumi.Input[builtins.str] parameters: List of parameters in JSON format. For example: `[{\\"Name\\":\\"InstanceId\\",\\"Type\\":\\"TARGET\\"}]` or `[{\\"Name\\":\\"InstanceId\\",\\"Type\\":\\"TEXT_VALUE\\"}]`.
        :param pulumi.Input[builtins.str] type: Service action definition type. Valid value is `SSM_AUTOMATION`. Default is `SSM_AUTOMATION`.
        """
        pulumi.set(__self__, "name", name)
        pulumi.set(__self__, "version", version)
        if assume_role is not None:
            pulumi.set(__self__, "assume_role", assume_role)
        if parameters is not None:
            pulumi.set(__self__, "parameters", parameters)
        if type is not None:
            pulumi.set(__self__, "type", type)

    @property
    @pulumi.getter
    def name(self) -> pulumi.Input[builtins.str]:
        """
        Name of the SSM document. For example, `AWS-RestartEC2Instance`. If you are using a shared SSM document, you must provide the ARN instead of the name.
        """
        return pulumi.get(self, "name")

    @name.setter
    def name(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "name", value)

    @property
    @pulumi.getter
    def version(self) -> pulumi.Input[builtins.str]:
        """
        SSM document version. For example, `1`.
        """
        return pulumi.get(self, "version")

    @version.setter
    def version(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "version", value)

    @property
    @pulumi.getter(name="assumeRole")
    def assume_role(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        ARN of the role that performs the self-service actions on your behalf. For example, `arn:aws:iam::12345678910:role/ActionRole`. To reuse the provisioned product launch role, set to `LAUNCH_ROLE`.
        """
        return pulumi.get(self, "assume_role")

    @assume_role.setter
    def assume_role(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "assume_role", value)

    @property
    @pulumi.getter
    def parameters(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        List of parameters in JSON format. For example: `[{\\"Name\\":\\"InstanceId\\",\\"Type\\":\\"TARGET\\"}]` or `[{\\"Name\\":\\"InstanceId\\",\\"Type\\":\\"TEXT_VALUE\\"}]`.
        """
        return pulumi.get(self, "parameters")

    @parameters.setter
    def parameters(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "parameters", value)

    @property
    @pulumi.getter
    def type(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Service action definition type. Valid value is `SSM_AUTOMATION`. Default is `SSM_AUTOMATION`.
        """
        return pulumi.get(self, "type")

    @type.setter
    def type(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "type", value)


