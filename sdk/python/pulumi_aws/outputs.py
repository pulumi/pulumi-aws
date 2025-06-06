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
from . import _utilities
from ._enums import *

__all__ = [
    'GetAvailabilityZoneFilterResult',
    'GetAvailabilityZonesFilterResult',
    'GetRegionsFilterResult',
]

@pulumi.output_type
class GetAvailabilityZoneFilterResult(dict):
    def __init__(__self__, *,
                 name: builtins.str,
                 values: Sequence[builtins.str]):
        """
        :param builtins.str name: Name of the filter field. Valid values can be found in the [EC2 DescribeAvailabilityZones API Reference](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeAvailabilityZones.html).
        :param Sequence[builtins.str] values: Set of values that are accepted for the given filter field. Results will be selected if any given value matches.
        """
        pulumi.set(__self__, "name", name)
        pulumi.set(__self__, "values", values)

    @property
    @pulumi.getter
    def name(self) -> builtins.str:
        """
        Name of the filter field. Valid values can be found in the [EC2 DescribeAvailabilityZones API Reference](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeAvailabilityZones.html).
        """
        return pulumi.get(self, "name")

    @property
    @pulumi.getter
    def values(self) -> Sequence[builtins.str]:
        """
        Set of values that are accepted for the given filter field. Results will be selected if any given value matches.
        """
        return pulumi.get(self, "values")


@pulumi.output_type
class GetAvailabilityZonesFilterResult(dict):
    def __init__(__self__, *,
                 name: builtins.str,
                 values: Sequence[builtins.str]):
        """
        :param builtins.str name: Name of the filter field. Valid values can be found in the [EC2 DescribeAvailabilityZones API Reference](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeAvailabilityZones.html).
        :param Sequence[builtins.str] values: Set of values that are accepted for the given filter field. Results will be selected if any given value matches.
        """
        pulumi.set(__self__, "name", name)
        pulumi.set(__self__, "values", values)

    @property
    @pulumi.getter
    def name(self) -> builtins.str:
        """
        Name of the filter field. Valid values can be found in the [EC2 DescribeAvailabilityZones API Reference](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeAvailabilityZones.html).
        """
        return pulumi.get(self, "name")

    @property
    @pulumi.getter
    def values(self) -> Sequence[builtins.str]:
        """
        Set of values that are accepted for the given filter field. Results will be selected if any given value matches.
        """
        return pulumi.get(self, "values")


@pulumi.output_type
class GetRegionsFilterResult(dict):
    def __init__(__self__, *,
                 name: builtins.str,
                 values: Sequence[builtins.str]):
        """
        :param builtins.str name: Name of the filter field. Valid values can be found in the [describe-regions AWS CLI Reference][1].
        :param Sequence[builtins.str] values: Set of values that are accepted for the given filter field. Results will be selected if any given value matches.
        """
        pulumi.set(__self__, "name", name)
        pulumi.set(__self__, "values", values)

    @property
    @pulumi.getter
    def name(self) -> builtins.str:
        """
        Name of the filter field. Valid values can be found in the [describe-regions AWS CLI Reference][1].
        """
        return pulumi.get(self, "name")

    @property
    @pulumi.getter
    def values(self) -> Sequence[builtins.str]:
        """
        Set of values that are accepted for the given filter field. Results will be selected if any given value matches.
        """
        return pulumi.get(self, "values")


