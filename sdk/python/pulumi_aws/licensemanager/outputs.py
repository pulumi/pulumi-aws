# coding=utf-8
# *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
# *** Do not edit by hand unless you're certain you know what you are doing! ***

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
    'GetLicenseGrantsFilterResult',
    'GetReceivedLicenseConsumptionConfigurationResult',
    'GetReceivedLicenseConsumptionConfigurationBorrowConfigurationResult',
    'GetReceivedLicenseConsumptionConfigurationProvisionalConfigurationResult',
    'GetReceivedLicenseEntitlementResult',
    'GetReceivedLicenseIssuerResult',
    'GetReceivedLicenseLicenseMetadataResult',
    'GetReceivedLicenseReceivedMetadataResult',
    'GetReceivedLicenseValidityResult',
    'GetReceivedLicensesFilterResult',
]

@pulumi.output_type
class GetLicenseGrantsFilterResult(dict):
    def __init__(__self__, *,
                 name: str,
                 values: Sequence[str]):
        """
        :param str name: Name of the field to filter by, as defined by
               [the underlying AWS API](https://docs.aws.amazon.com/license-manager/latest/APIReference/API_ListReceivedGrants.html#API_ListReceivedGrants_RequestSyntax).
               For example, if filtering using `ProductSKU`, use:
               
               ```python
               import pulumi
               import pulumi_aws as aws
               
               selected = aws.licensemanager.get_license_grants(filters=[{
                   "name": "ProductSKU",
                   "values": [""],
               }])
               ```
        :param Sequence[str] values: Set of values that are accepted for the given field.
        """
        pulumi.set(__self__, "name", name)
        pulumi.set(__self__, "values", values)

    @property
    @pulumi.getter
    def name(self) -> str:
        """
        Name of the field to filter by, as defined by
        [the underlying AWS API](https://docs.aws.amazon.com/license-manager/latest/APIReference/API_ListReceivedGrants.html#API_ListReceivedGrants_RequestSyntax).
        For example, if filtering using `ProductSKU`, use:

        ```python
        import pulumi
        import pulumi_aws as aws

        selected = aws.licensemanager.get_license_grants(filters=[{
            "name": "ProductSKU",
            "values": [""],
        }])
        ```
        """
        return pulumi.get(self, "name")

    @property
    @pulumi.getter
    def values(self) -> Sequence[str]:
        """
        Set of values that are accepted for the given field.
        """
        return pulumi.get(self, "values")


@pulumi.output_type
class GetReceivedLicenseConsumptionConfigurationResult(dict):
    def __init__(__self__, *,
                 borrow_configurations: Sequence['outputs.GetReceivedLicenseConsumptionConfigurationBorrowConfigurationResult'],
                 provisional_configurations: Sequence['outputs.GetReceivedLicenseConsumptionConfigurationProvisionalConfigurationResult'],
                 renew_type: str):
        """
        :param Sequence['GetReceivedLicenseConsumptionConfigurationBorrowConfigurationArgs'] borrow_configurations: Details about a borrow configuration. Detailed below
        :param Sequence['GetReceivedLicenseConsumptionConfigurationProvisionalConfigurationArgs'] provisional_configurations: Details about a provisional configuration. Detailed below
        """
        pulumi.set(__self__, "borrow_configurations", borrow_configurations)
        pulumi.set(__self__, "provisional_configurations", provisional_configurations)
        pulumi.set(__self__, "renew_type", renew_type)

    @property
    @pulumi.getter(name="borrowConfigurations")
    def borrow_configurations(self) -> Sequence['outputs.GetReceivedLicenseConsumptionConfigurationBorrowConfigurationResult']:
        """
        Details about a borrow configuration. Detailed below
        """
        return pulumi.get(self, "borrow_configurations")

    @property
    @pulumi.getter(name="provisionalConfigurations")
    def provisional_configurations(self) -> Sequence['outputs.GetReceivedLicenseConsumptionConfigurationProvisionalConfigurationResult']:
        """
        Details about a provisional configuration. Detailed below
        """
        return pulumi.get(self, "provisional_configurations")

    @property
    @pulumi.getter(name="renewType")
    def renew_type(self) -> str:
        return pulumi.get(self, "renew_type")


@pulumi.output_type
class GetReceivedLicenseConsumptionConfigurationBorrowConfigurationResult(dict):
    def __init__(__self__, *,
                 allow_early_check_in: bool,
                 max_time_to_live_in_minutes: int):
        """
        :param bool allow_early_check_in: Indicates whether early check-ins are allowed.
        :param int max_time_to_live_in_minutes: Maximum time for the provisional configuration, in minutes.
        """
        pulumi.set(__self__, "allow_early_check_in", allow_early_check_in)
        pulumi.set(__self__, "max_time_to_live_in_minutes", max_time_to_live_in_minutes)

    @property
    @pulumi.getter(name="allowEarlyCheckIn")
    def allow_early_check_in(self) -> bool:
        """
        Indicates whether early check-ins are allowed.
        """
        return pulumi.get(self, "allow_early_check_in")

    @property
    @pulumi.getter(name="maxTimeToLiveInMinutes")
    def max_time_to_live_in_minutes(self) -> int:
        """
        Maximum time for the provisional configuration, in minutes.
        """
        return pulumi.get(self, "max_time_to_live_in_minutes")


@pulumi.output_type
class GetReceivedLicenseConsumptionConfigurationProvisionalConfigurationResult(dict):
    def __init__(__self__, *,
                 max_time_to_live_in_minutes: int):
        """
        :param int max_time_to_live_in_minutes: Maximum time for the provisional configuration, in minutes.
        """
        pulumi.set(__self__, "max_time_to_live_in_minutes", max_time_to_live_in_minutes)

    @property
    @pulumi.getter(name="maxTimeToLiveInMinutes")
    def max_time_to_live_in_minutes(self) -> int:
        """
        Maximum time for the provisional configuration, in minutes.
        """
        return pulumi.get(self, "max_time_to_live_in_minutes")


@pulumi.output_type
class GetReceivedLicenseEntitlementResult(dict):
    def __init__(__self__, *,
                 allow_check_in: bool,
                 max_count: int,
                 name: str,
                 overage: bool,
                 unit: str,
                 value: str):
        """
        :param bool allow_check_in: Indicates whether check-ins are allowed.
        :param int max_count: Maximum entitlement count. Use if the unit is not None.
        :param str name: The key name.
        :param bool overage: Indicates whether overages are allowed.
        :param str unit: Entitlement unit.
        :param str value: The value.
        """
        pulumi.set(__self__, "allow_check_in", allow_check_in)
        pulumi.set(__self__, "max_count", max_count)
        pulumi.set(__self__, "name", name)
        pulumi.set(__self__, "overage", overage)
        pulumi.set(__self__, "unit", unit)
        pulumi.set(__self__, "value", value)

    @property
    @pulumi.getter(name="allowCheckIn")
    def allow_check_in(self) -> bool:
        """
        Indicates whether check-ins are allowed.
        """
        return pulumi.get(self, "allow_check_in")

    @property
    @pulumi.getter(name="maxCount")
    def max_count(self) -> int:
        """
        Maximum entitlement count. Use if the unit is not None.
        """
        return pulumi.get(self, "max_count")

    @property
    @pulumi.getter
    def name(self) -> str:
        """
        The key name.
        """
        return pulumi.get(self, "name")

    @property
    @pulumi.getter
    def overage(self) -> bool:
        """
        Indicates whether overages are allowed.
        """
        return pulumi.get(self, "overage")

    @property
    @pulumi.getter
    def unit(self) -> str:
        """
        Entitlement unit.
        """
        return pulumi.get(self, "unit")

    @property
    @pulumi.getter
    def value(self) -> str:
        """
        The value.
        """
        return pulumi.get(self, "value")


@pulumi.output_type
class GetReceivedLicenseIssuerResult(dict):
    def __init__(__self__, *,
                 key_fingerprint: str,
                 name: str,
                 sign_key: str):
        """
        :param str key_fingerprint: Issuer key fingerprint.
        :param str name: The key name.
        :param str sign_key: Asymmetric KMS key from AWS Key Management Service. The KMS key must have a key usage of sign and verify, and support the RSASSA-PSS SHA-256 signing algorithm.
        """
        pulumi.set(__self__, "key_fingerprint", key_fingerprint)
        pulumi.set(__self__, "name", name)
        pulumi.set(__self__, "sign_key", sign_key)

    @property
    @pulumi.getter(name="keyFingerprint")
    def key_fingerprint(self) -> str:
        """
        Issuer key fingerprint.
        """
        return pulumi.get(self, "key_fingerprint")

    @property
    @pulumi.getter
    def name(self) -> str:
        """
        The key name.
        """
        return pulumi.get(self, "name")

    @property
    @pulumi.getter(name="signKey")
    def sign_key(self) -> str:
        """
        Asymmetric KMS key from AWS Key Management Service. The KMS key must have a key usage of sign and verify, and support the RSASSA-PSS SHA-256 signing algorithm.
        """
        return pulumi.get(self, "sign_key")


@pulumi.output_type
class GetReceivedLicenseLicenseMetadataResult(dict):
    def __init__(__self__, *,
                 name: str,
                 value: str):
        """
        :param str name: The key name.
        :param str value: The value.
        """
        pulumi.set(__self__, "name", name)
        pulumi.set(__self__, "value", value)

    @property
    @pulumi.getter
    def name(self) -> str:
        """
        The key name.
        """
        return pulumi.get(self, "name")

    @property
    @pulumi.getter
    def value(self) -> str:
        """
        The value.
        """
        return pulumi.get(self, "value")


@pulumi.output_type
class GetReceivedLicenseReceivedMetadataResult(dict):
    def __init__(__self__, *,
                 allowed_operations: Sequence[str],
                 received_status: str,
                 received_status_reason: str):
        """
        :param Sequence[str] allowed_operations: A list of allowed operations.
        :param str received_status: Received status.
        :param str received_status_reason: Received status reason.
        """
        pulumi.set(__self__, "allowed_operations", allowed_operations)
        pulumi.set(__self__, "received_status", received_status)
        pulumi.set(__self__, "received_status_reason", received_status_reason)

    @property
    @pulumi.getter(name="allowedOperations")
    def allowed_operations(self) -> Sequence[str]:
        """
        A list of allowed operations.
        """
        return pulumi.get(self, "allowed_operations")

    @property
    @pulumi.getter(name="receivedStatus")
    def received_status(self) -> str:
        """
        Received status.
        """
        return pulumi.get(self, "received_status")

    @property
    @pulumi.getter(name="receivedStatusReason")
    def received_status_reason(self) -> str:
        """
        Received status reason.
        """
        return pulumi.get(self, "received_status_reason")


@pulumi.output_type
class GetReceivedLicenseValidityResult(dict):
    def __init__(__self__, *,
                 begin: str,
                 end: str):
        """
        :param str begin: Start of the validity time range.
        :param str end: End of the validity time range.
        """
        pulumi.set(__self__, "begin", begin)
        pulumi.set(__self__, "end", end)

    @property
    @pulumi.getter
    def begin(self) -> str:
        """
        Start of the validity time range.
        """
        return pulumi.get(self, "begin")

    @property
    @pulumi.getter
    def end(self) -> str:
        """
        End of the validity time range.
        """
        return pulumi.get(self, "end")


@pulumi.output_type
class GetReceivedLicensesFilterResult(dict):
    def __init__(__self__, *,
                 name: str,
                 values: Sequence[str]):
        """
        :param str name: Name of the field to filter by, as defined by
               [the underlying AWS API](https://docs.aws.amazon.com/license-manager/latest/APIReference/API_ListReceivedLicenses.html#API_ListReceivedLicenses_RequestSyntax).
               For example, if filtering using `ProductSKU`, use:
               
               ```python
               import pulumi
               import pulumi_aws as aws
               
               selected = aws.licensemanager.get_received_licenses(filters=[{
                   "name": "ProductSKU",
                   "values": [""],
               }])
               ```
        :param Sequence[str] values: Set of values that are accepted for the given field.
        """
        pulumi.set(__self__, "name", name)
        pulumi.set(__self__, "values", values)

    @property
    @pulumi.getter
    def name(self) -> str:
        """
        Name of the field to filter by, as defined by
        [the underlying AWS API](https://docs.aws.amazon.com/license-manager/latest/APIReference/API_ListReceivedLicenses.html#API_ListReceivedLicenses_RequestSyntax).
        For example, if filtering using `ProductSKU`, use:

        ```python
        import pulumi
        import pulumi_aws as aws

        selected = aws.licensemanager.get_received_licenses(filters=[{
            "name": "ProductSKU",
            "values": [""],
        }])
        ```
        """
        return pulumi.get(self, "name")

    @property
    @pulumi.getter
    def values(self) -> Sequence[str]:
        """
        Set of values that are accepted for the given field.
        """
        return pulumi.get(self, "values")


