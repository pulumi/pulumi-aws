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
    'EndpointServicePrivateDnsVerificationTimeoutsArgs',
    'EndpointServicePrivateDnsVerificationTimeoutsArgsDict',
    'SecurityGroupVpcAssociationTimeoutsArgs',
    'SecurityGroupVpcAssociationTimeoutsArgsDict',
    'GetSecurityGroupRuleFilterArgs',
    'GetSecurityGroupRuleFilterArgsDict',
    'GetSecurityGroupRulesFilterArgs',
    'GetSecurityGroupRulesFilterArgsDict',
]

MYPY = False

if not MYPY:
    class EndpointServicePrivateDnsVerificationTimeoutsArgsDict(TypedDict):
        create: NotRequired[pulumi.Input[builtins.str]]
        """
        A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours).
        """
elif False:
    EndpointServicePrivateDnsVerificationTimeoutsArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class EndpointServicePrivateDnsVerificationTimeoutsArgs:
    def __init__(__self__, *,
                 create: Optional[pulumi.Input[builtins.str]] = None):
        """
        :param pulumi.Input[builtins.str] create: A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours).
        """
        if create is not None:
            pulumi.set(__self__, "create", create)

    @property
    @pulumi.getter
    def create(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours).
        """
        return pulumi.get(self, "create")

    @create.setter
    def create(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "create", value)


if not MYPY:
    class SecurityGroupVpcAssociationTimeoutsArgsDict(TypedDict):
        create: NotRequired[pulumi.Input[builtins.str]]
        """
        A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours).
        """
        delete: NotRequired[pulumi.Input[builtins.str]]
        """
        A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours). Setting a timeout for a Delete operation is only applicable if changes are saved into state before the destroy operation occurs.
        """
elif False:
    SecurityGroupVpcAssociationTimeoutsArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class SecurityGroupVpcAssociationTimeoutsArgs:
    def __init__(__self__, *,
                 create: Optional[pulumi.Input[builtins.str]] = None,
                 delete: Optional[pulumi.Input[builtins.str]] = None):
        """
        :param pulumi.Input[builtins.str] create: A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours).
        :param pulumi.Input[builtins.str] delete: A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours). Setting a timeout for a Delete operation is only applicable if changes are saved into state before the destroy operation occurs.
        """
        if create is not None:
            pulumi.set(__self__, "create", create)
        if delete is not None:
            pulumi.set(__self__, "delete", delete)

    @property
    @pulumi.getter
    def create(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours).
        """
        return pulumi.get(self, "create")

    @create.setter
    def create(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "create", value)

    @property
    @pulumi.getter
    def delete(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours). Setting a timeout for a Delete operation is only applicable if changes are saved into state before the destroy operation occurs.
        """
        return pulumi.get(self, "delete")

    @delete.setter
    def delete(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "delete", value)


if not MYPY:
    class GetSecurityGroupRuleFilterArgsDict(TypedDict):
        name: builtins.str
        """
        Name of the filter field. Valid values can be found in the EC2 [`DescribeSecurityGroupRules`](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeSecurityGroupRules.html) API Reference.
        """
        values: Sequence[builtins.str]
        """
        Set of values that are accepted for the given filter field. Results will be selected if any given value matches.
        """
elif False:
    GetSecurityGroupRuleFilterArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class GetSecurityGroupRuleFilterArgs:
    def __init__(__self__, *,
                 name: builtins.str,
                 values: Sequence[builtins.str]):
        """
        :param builtins.str name: Name of the filter field. Valid values can be found in the EC2 [`DescribeSecurityGroupRules`](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeSecurityGroupRules.html) API Reference.
        :param Sequence[builtins.str] values: Set of values that are accepted for the given filter field. Results will be selected if any given value matches.
        """
        pulumi.set(__self__, "name", name)
        pulumi.set(__self__, "values", values)

    @property
    @pulumi.getter
    def name(self) -> builtins.str:
        """
        Name of the filter field. Valid values can be found in the EC2 [`DescribeSecurityGroupRules`](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeSecurityGroupRules.html) API Reference.
        """
        return pulumi.get(self, "name")

    @name.setter
    def name(self, value: builtins.str):
        pulumi.set(self, "name", value)

    @property
    @pulumi.getter
    def values(self) -> Sequence[builtins.str]:
        """
        Set of values that are accepted for the given filter field. Results will be selected if any given value matches.
        """
        return pulumi.get(self, "values")

    @values.setter
    def values(self, value: Sequence[builtins.str]):
        pulumi.set(self, "values", value)


if not MYPY:
    class GetSecurityGroupRulesFilterArgsDict(TypedDict):
        name: builtins.str
        """
        Name of the field to filter by, as defined by
        [the underlying AWS API](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeSecurityGroupRules.html).
        """
        values: Sequence[builtins.str]
        """
        Set of values that are accepted for the given field.

        Security group rule IDs will be selected if any one of the given values match.
        """
elif False:
    GetSecurityGroupRulesFilterArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class GetSecurityGroupRulesFilterArgs:
    def __init__(__self__, *,
                 name: builtins.str,
                 values: Sequence[builtins.str]):
        """
        :param builtins.str name: Name of the field to filter by, as defined by
               [the underlying AWS API](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeSecurityGroupRules.html).
        :param Sequence[builtins.str] values: Set of values that are accepted for the given field.
               
               Security group rule IDs will be selected if any one of the given values match.
        """
        pulumi.set(__self__, "name", name)
        pulumi.set(__self__, "values", values)

    @property
    @pulumi.getter
    def name(self) -> builtins.str:
        """
        Name of the field to filter by, as defined by
        [the underlying AWS API](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeSecurityGroupRules.html).
        """
        return pulumi.get(self, "name")

    @name.setter
    def name(self, value: builtins.str):
        pulumi.set(self, "name", value)

    @property
    @pulumi.getter
    def values(self) -> Sequence[builtins.str]:
        """
        Set of values that are accepted for the given field.

        Security group rule IDs will be selected if any one of the given values match.
        """
        return pulumi.get(self, "values")

    @values.setter
    def values(self, value: Sequence[builtins.str]):
        pulumi.set(self, "values", value)


