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

__all__ = ['OrganizationConfigurationArgs', 'OrganizationConfiguration']

@pulumi.input_type
class OrganizationConfigurationArgs:
    def __init__(__self__, *,
                 detector_id: pulumi.Input[builtins.str],
                 auto_enable: Optional[pulumi.Input[builtins.bool]] = None,
                 auto_enable_organization_members: Optional[pulumi.Input[builtins.str]] = None,
                 datasources: Optional[pulumi.Input['OrganizationConfigurationDatasourcesArgs']] = None):
        """
        The set of arguments for constructing a OrganizationConfiguration resource.
        :param pulumi.Input[builtins.str] detector_id: The detector ID of the GuardDuty account.
        :param pulumi.Input[builtins.bool] auto_enable: *Deprecated:* Use `auto_enable_organization_members` instead. When this setting is enabled, all new accounts that are created in, or added to, the organization are added as a member accounts of the organization’s GuardDuty delegated administrator and GuardDuty is enabled in that AWS Region.
        :param pulumi.Input[builtins.str] auto_enable_organization_members: Indicates the auto-enablement configuration of GuardDuty for the member accounts in the organization. Valid values are `ALL`, `NEW`, `NONE`.
        :param pulumi.Input['OrganizationConfigurationDatasourcesArgs'] datasources: Configuration for the collected datasources. [Deprecated](https://docs.aws.amazon.com/guardduty/latest/ug/guardduty-feature-object-api-changes-march2023.html) in favor of `guardduty.OrganizationConfigurationFeature` resources.
               
               > **NOTE:** One of `auto_enable` or `auto_enable_organization_members` must be specified.
        """
        pulumi.set(__self__, "detector_id", detector_id)
        if auto_enable is not None:
            warnings.warn("""auto_enable is deprecated. Use auto_enable_organization_members instead.""", DeprecationWarning)
            pulumi.log.warn("""auto_enable is deprecated: auto_enable is deprecated. Use auto_enable_organization_members instead.""")
        if auto_enable is not None:
            pulumi.set(__self__, "auto_enable", auto_enable)
        if auto_enable_organization_members is not None:
            pulumi.set(__self__, "auto_enable_organization_members", auto_enable_organization_members)
        if datasources is not None:
            pulumi.set(__self__, "datasources", datasources)

    @property
    @pulumi.getter(name="detectorId")
    def detector_id(self) -> pulumi.Input[builtins.str]:
        """
        The detector ID of the GuardDuty account.
        """
        return pulumi.get(self, "detector_id")

    @detector_id.setter
    def detector_id(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "detector_id", value)

    @property
    @pulumi.getter(name="autoEnable")
    @_utilities.deprecated("""auto_enable is deprecated. Use auto_enable_organization_members instead.""")
    def auto_enable(self) -> Optional[pulumi.Input[builtins.bool]]:
        """
        *Deprecated:* Use `auto_enable_organization_members` instead. When this setting is enabled, all new accounts that are created in, or added to, the organization are added as a member accounts of the organization’s GuardDuty delegated administrator and GuardDuty is enabled in that AWS Region.
        """
        return pulumi.get(self, "auto_enable")

    @auto_enable.setter
    def auto_enable(self, value: Optional[pulumi.Input[builtins.bool]]):
        pulumi.set(self, "auto_enable", value)

    @property
    @pulumi.getter(name="autoEnableOrganizationMembers")
    def auto_enable_organization_members(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Indicates the auto-enablement configuration of GuardDuty for the member accounts in the organization. Valid values are `ALL`, `NEW`, `NONE`.
        """
        return pulumi.get(self, "auto_enable_organization_members")

    @auto_enable_organization_members.setter
    def auto_enable_organization_members(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "auto_enable_organization_members", value)

    @property
    @pulumi.getter
    def datasources(self) -> Optional[pulumi.Input['OrganizationConfigurationDatasourcesArgs']]:
        """
        Configuration for the collected datasources. [Deprecated](https://docs.aws.amazon.com/guardduty/latest/ug/guardduty-feature-object-api-changes-march2023.html) in favor of `guardduty.OrganizationConfigurationFeature` resources.

        > **NOTE:** One of `auto_enable` or `auto_enable_organization_members` must be specified.
        """
        return pulumi.get(self, "datasources")

    @datasources.setter
    def datasources(self, value: Optional[pulumi.Input['OrganizationConfigurationDatasourcesArgs']]):
        pulumi.set(self, "datasources", value)


@pulumi.input_type
class _OrganizationConfigurationState:
    def __init__(__self__, *,
                 auto_enable: Optional[pulumi.Input[builtins.bool]] = None,
                 auto_enable_organization_members: Optional[pulumi.Input[builtins.str]] = None,
                 datasources: Optional[pulumi.Input['OrganizationConfigurationDatasourcesArgs']] = None,
                 detector_id: Optional[pulumi.Input[builtins.str]] = None):
        """
        Input properties used for looking up and filtering OrganizationConfiguration resources.
        :param pulumi.Input[builtins.bool] auto_enable: *Deprecated:* Use `auto_enable_organization_members` instead. When this setting is enabled, all new accounts that are created in, or added to, the organization are added as a member accounts of the organization’s GuardDuty delegated administrator and GuardDuty is enabled in that AWS Region.
        :param pulumi.Input[builtins.str] auto_enable_organization_members: Indicates the auto-enablement configuration of GuardDuty for the member accounts in the organization. Valid values are `ALL`, `NEW`, `NONE`.
        :param pulumi.Input['OrganizationConfigurationDatasourcesArgs'] datasources: Configuration for the collected datasources. [Deprecated](https://docs.aws.amazon.com/guardduty/latest/ug/guardduty-feature-object-api-changes-march2023.html) in favor of `guardduty.OrganizationConfigurationFeature` resources.
               
               > **NOTE:** One of `auto_enable` or `auto_enable_organization_members` must be specified.
        :param pulumi.Input[builtins.str] detector_id: The detector ID of the GuardDuty account.
        """
        if auto_enable is not None:
            warnings.warn("""auto_enable is deprecated. Use auto_enable_organization_members instead.""", DeprecationWarning)
            pulumi.log.warn("""auto_enable is deprecated: auto_enable is deprecated. Use auto_enable_organization_members instead.""")
        if auto_enable is not None:
            pulumi.set(__self__, "auto_enable", auto_enable)
        if auto_enable_organization_members is not None:
            pulumi.set(__self__, "auto_enable_organization_members", auto_enable_organization_members)
        if datasources is not None:
            pulumi.set(__self__, "datasources", datasources)
        if detector_id is not None:
            pulumi.set(__self__, "detector_id", detector_id)

    @property
    @pulumi.getter(name="autoEnable")
    @_utilities.deprecated("""auto_enable is deprecated. Use auto_enable_organization_members instead.""")
    def auto_enable(self) -> Optional[pulumi.Input[builtins.bool]]:
        """
        *Deprecated:* Use `auto_enable_organization_members` instead. When this setting is enabled, all new accounts that are created in, or added to, the organization are added as a member accounts of the organization’s GuardDuty delegated administrator and GuardDuty is enabled in that AWS Region.
        """
        return pulumi.get(self, "auto_enable")

    @auto_enable.setter
    def auto_enable(self, value: Optional[pulumi.Input[builtins.bool]]):
        pulumi.set(self, "auto_enable", value)

    @property
    @pulumi.getter(name="autoEnableOrganizationMembers")
    def auto_enable_organization_members(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Indicates the auto-enablement configuration of GuardDuty for the member accounts in the organization. Valid values are `ALL`, `NEW`, `NONE`.
        """
        return pulumi.get(self, "auto_enable_organization_members")

    @auto_enable_organization_members.setter
    def auto_enable_organization_members(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "auto_enable_organization_members", value)

    @property
    @pulumi.getter
    def datasources(self) -> Optional[pulumi.Input['OrganizationConfigurationDatasourcesArgs']]:
        """
        Configuration for the collected datasources. [Deprecated](https://docs.aws.amazon.com/guardduty/latest/ug/guardduty-feature-object-api-changes-march2023.html) in favor of `guardduty.OrganizationConfigurationFeature` resources.

        > **NOTE:** One of `auto_enable` or `auto_enable_organization_members` must be specified.
        """
        return pulumi.get(self, "datasources")

    @datasources.setter
    def datasources(self, value: Optional[pulumi.Input['OrganizationConfigurationDatasourcesArgs']]):
        pulumi.set(self, "datasources", value)

    @property
    @pulumi.getter(name="detectorId")
    def detector_id(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The detector ID of the GuardDuty account.
        """
        return pulumi.get(self, "detector_id")

    @detector_id.setter
    def detector_id(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "detector_id", value)


@pulumi.type_token("aws:guardduty/organizationConfiguration:OrganizationConfiguration")
class OrganizationConfiguration(pulumi.CustomResource):
    @overload
    def __init__(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 auto_enable: Optional[pulumi.Input[builtins.bool]] = None,
                 auto_enable_organization_members: Optional[pulumi.Input[builtins.str]] = None,
                 datasources: Optional[pulumi.Input[Union['OrganizationConfigurationDatasourcesArgs', 'OrganizationConfigurationDatasourcesArgsDict']]] = None,
                 detector_id: Optional[pulumi.Input[builtins.str]] = None,
                 __props__=None):
        """
        Manages the GuardDuty Organization Configuration in the current AWS Region. The AWS account utilizing this resource must have been assigned as a delegated Organization administrator account, e.g., via the `guardduty.OrganizationAdminAccount` resource. More information about Organizations support in GuardDuty can be found in the [GuardDuty User Guide](https://docs.aws.amazon.com/guardduty/latest/ug/guardduty_organizations.html).

        > **NOTE:** This is an advanced resource. The provider will automatically assume management of the GuardDuty Organization Configuration without import and perform no actions on removal from the resource configuration.

        ## Example Usage

        ```python
        import pulumi
        import pulumi_aws as aws

        example = aws.guardduty.Detector("example", enable=True)
        example_organization_configuration = aws.guardduty.OrganizationConfiguration("example",
            auto_enable_organization_members="ALL",
            detector_id=example.id,
            datasources={
                "s3_logs": {
                    "auto_enable": True,
                },
                "kubernetes": {
                    "audit_logs": {
                        "enable": True,
                    },
                },
                "malware_protection": {
                    "scan_ec2_instance_with_findings": {
                        "ebs_volumes": {
                            "auto_enable": True,
                        },
                    },
                },
            })
        ```

        ## Import

        Using `pulumi import`, import GuardDuty Organization Configurations using the GuardDuty Detector ID. For example:

        ```sh
        $ pulumi import aws:guardduty/organizationConfiguration:OrganizationConfiguration example 00b00fd5aecc0ab60a708659477e9617
        ```

        :param str resource_name: The name of the resource.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[builtins.bool] auto_enable: *Deprecated:* Use `auto_enable_organization_members` instead. When this setting is enabled, all new accounts that are created in, or added to, the organization are added as a member accounts of the organization’s GuardDuty delegated administrator and GuardDuty is enabled in that AWS Region.
        :param pulumi.Input[builtins.str] auto_enable_organization_members: Indicates the auto-enablement configuration of GuardDuty for the member accounts in the organization. Valid values are `ALL`, `NEW`, `NONE`.
        :param pulumi.Input[Union['OrganizationConfigurationDatasourcesArgs', 'OrganizationConfigurationDatasourcesArgsDict']] datasources: Configuration for the collected datasources. [Deprecated](https://docs.aws.amazon.com/guardduty/latest/ug/guardduty-feature-object-api-changes-march2023.html) in favor of `guardduty.OrganizationConfigurationFeature` resources.
               
               > **NOTE:** One of `auto_enable` or `auto_enable_organization_members` must be specified.
        :param pulumi.Input[builtins.str] detector_id: The detector ID of the GuardDuty account.
        """
        ...
    @overload
    def __init__(__self__,
                 resource_name: str,
                 args: OrganizationConfigurationArgs,
                 opts: Optional[pulumi.ResourceOptions] = None):
        """
        Manages the GuardDuty Organization Configuration in the current AWS Region. The AWS account utilizing this resource must have been assigned as a delegated Organization administrator account, e.g., via the `guardduty.OrganizationAdminAccount` resource. More information about Organizations support in GuardDuty can be found in the [GuardDuty User Guide](https://docs.aws.amazon.com/guardduty/latest/ug/guardduty_organizations.html).

        > **NOTE:** This is an advanced resource. The provider will automatically assume management of the GuardDuty Organization Configuration without import and perform no actions on removal from the resource configuration.

        ## Example Usage

        ```python
        import pulumi
        import pulumi_aws as aws

        example = aws.guardduty.Detector("example", enable=True)
        example_organization_configuration = aws.guardduty.OrganizationConfiguration("example",
            auto_enable_organization_members="ALL",
            detector_id=example.id,
            datasources={
                "s3_logs": {
                    "auto_enable": True,
                },
                "kubernetes": {
                    "audit_logs": {
                        "enable": True,
                    },
                },
                "malware_protection": {
                    "scan_ec2_instance_with_findings": {
                        "ebs_volumes": {
                            "auto_enable": True,
                        },
                    },
                },
            })
        ```

        ## Import

        Using `pulumi import`, import GuardDuty Organization Configurations using the GuardDuty Detector ID. For example:

        ```sh
        $ pulumi import aws:guardduty/organizationConfiguration:OrganizationConfiguration example 00b00fd5aecc0ab60a708659477e9617
        ```

        :param str resource_name: The name of the resource.
        :param OrganizationConfigurationArgs args: The arguments to use to populate this resource's properties.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        ...
    def __init__(__self__, resource_name: str, *args, **kwargs):
        resource_args, opts = _utilities.get_resource_args_opts(OrganizationConfigurationArgs, pulumi.ResourceOptions, *args, **kwargs)
        if resource_args is not None:
            __self__._internal_init(resource_name, opts, **resource_args.__dict__)
        else:
            __self__._internal_init(resource_name, *args, **kwargs)

    def _internal_init(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 auto_enable: Optional[pulumi.Input[builtins.bool]] = None,
                 auto_enable_organization_members: Optional[pulumi.Input[builtins.str]] = None,
                 datasources: Optional[pulumi.Input[Union['OrganizationConfigurationDatasourcesArgs', 'OrganizationConfigurationDatasourcesArgsDict']]] = None,
                 detector_id: Optional[pulumi.Input[builtins.str]] = None,
                 __props__=None):
        opts = pulumi.ResourceOptions.merge(_utilities.get_resource_opts_defaults(), opts)
        if not isinstance(opts, pulumi.ResourceOptions):
            raise TypeError('Expected resource options to be a ResourceOptions instance')
        if opts.id is None:
            if __props__ is not None:
                raise TypeError('__props__ is only valid when passed in combination with a valid opts.id to get an existing resource')
            __props__ = OrganizationConfigurationArgs.__new__(OrganizationConfigurationArgs)

            __props__.__dict__["auto_enable"] = auto_enable
            __props__.__dict__["auto_enable_organization_members"] = auto_enable_organization_members
            __props__.__dict__["datasources"] = datasources
            if detector_id is None and not opts.urn:
                raise TypeError("Missing required property 'detector_id'")
            __props__.__dict__["detector_id"] = detector_id
        super(OrganizationConfiguration, __self__).__init__(
            'aws:guardduty/organizationConfiguration:OrganizationConfiguration',
            resource_name,
            __props__,
            opts)

    @staticmethod
    def get(resource_name: str,
            id: pulumi.Input[str],
            opts: Optional[pulumi.ResourceOptions] = None,
            auto_enable: Optional[pulumi.Input[builtins.bool]] = None,
            auto_enable_organization_members: Optional[pulumi.Input[builtins.str]] = None,
            datasources: Optional[pulumi.Input[Union['OrganizationConfigurationDatasourcesArgs', 'OrganizationConfigurationDatasourcesArgsDict']]] = None,
            detector_id: Optional[pulumi.Input[builtins.str]] = None) -> 'OrganizationConfiguration':
        """
        Get an existing OrganizationConfiguration resource's state with the given name, id, and optional extra
        properties used to qualify the lookup.

        :param str resource_name: The unique name of the resulting resource.
        :param pulumi.Input[str] id: The unique provider ID of the resource to lookup.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[builtins.bool] auto_enable: *Deprecated:* Use `auto_enable_organization_members` instead. When this setting is enabled, all new accounts that are created in, or added to, the organization are added as a member accounts of the organization’s GuardDuty delegated administrator and GuardDuty is enabled in that AWS Region.
        :param pulumi.Input[builtins.str] auto_enable_organization_members: Indicates the auto-enablement configuration of GuardDuty for the member accounts in the organization. Valid values are `ALL`, `NEW`, `NONE`.
        :param pulumi.Input[Union['OrganizationConfigurationDatasourcesArgs', 'OrganizationConfigurationDatasourcesArgsDict']] datasources: Configuration for the collected datasources. [Deprecated](https://docs.aws.amazon.com/guardduty/latest/ug/guardduty-feature-object-api-changes-march2023.html) in favor of `guardduty.OrganizationConfigurationFeature` resources.
               
               > **NOTE:** One of `auto_enable` or `auto_enable_organization_members` must be specified.
        :param pulumi.Input[builtins.str] detector_id: The detector ID of the GuardDuty account.
        """
        opts = pulumi.ResourceOptions.merge(opts, pulumi.ResourceOptions(id=id))

        __props__ = _OrganizationConfigurationState.__new__(_OrganizationConfigurationState)

        __props__.__dict__["auto_enable"] = auto_enable
        __props__.__dict__["auto_enable_organization_members"] = auto_enable_organization_members
        __props__.__dict__["datasources"] = datasources
        __props__.__dict__["detector_id"] = detector_id
        return OrganizationConfiguration(resource_name, opts=opts, __props__=__props__)

    @property
    @pulumi.getter(name="autoEnable")
    @_utilities.deprecated("""auto_enable is deprecated. Use auto_enable_organization_members instead.""")
    def auto_enable(self) -> pulumi.Output[builtins.bool]:
        """
        *Deprecated:* Use `auto_enable_organization_members` instead. When this setting is enabled, all new accounts that are created in, or added to, the organization are added as a member accounts of the organization’s GuardDuty delegated administrator and GuardDuty is enabled in that AWS Region.
        """
        return pulumi.get(self, "auto_enable")

    @property
    @pulumi.getter(name="autoEnableOrganizationMembers")
    def auto_enable_organization_members(self) -> pulumi.Output[builtins.str]:
        """
        Indicates the auto-enablement configuration of GuardDuty for the member accounts in the organization. Valid values are `ALL`, `NEW`, `NONE`.
        """
        return pulumi.get(self, "auto_enable_organization_members")

    @property
    @pulumi.getter
    def datasources(self) -> pulumi.Output['outputs.OrganizationConfigurationDatasources']:
        """
        Configuration for the collected datasources. [Deprecated](https://docs.aws.amazon.com/guardduty/latest/ug/guardduty-feature-object-api-changes-march2023.html) in favor of `guardduty.OrganizationConfigurationFeature` resources.

        > **NOTE:** One of `auto_enable` or `auto_enable_organization_members` must be specified.
        """
        return pulumi.get(self, "datasources")

    @property
    @pulumi.getter(name="detectorId")
    def detector_id(self) -> pulumi.Output[builtins.str]:
        """
        The detector ID of the GuardDuty account.
        """
        return pulumi.get(self, "detector_id")

