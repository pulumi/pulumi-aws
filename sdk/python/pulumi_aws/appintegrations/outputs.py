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
    'DataIntegrationScheduleConfig',
    'GetEventIntegrationEventFilterResult',
]

@pulumi.output_type
class DataIntegrationScheduleConfig(dict):
    @staticmethod
    def __key_warning(key: str):
        suggest = None
        if key == "firstExecutionFrom":
            suggest = "first_execution_from"
        elif key == "scheduleExpression":
            suggest = "schedule_expression"

        if suggest:
            pulumi.log.warn(f"Key '{key}' not found in DataIntegrationScheduleConfig. Access the value via the '{suggest}' property getter instead.")

    def __getitem__(self, key: str) -> Any:
        DataIntegrationScheduleConfig.__key_warning(key)
        return super().__getitem__(key)

    def get(self, key: str, default = None) -> Any:
        DataIntegrationScheduleConfig.__key_warning(key)
        return super().get(key, default)

    def __init__(__self__, *,
                 first_execution_from: builtins.str,
                 object: builtins.str,
                 schedule_expression: builtins.str):
        """
        :param builtins.str first_execution_from: The start date for objects to import in the first flow run as an Unix/epoch timestamp in milliseconds or in ISO-8601 format. This needs to be a time in the past, meaning that the data created or updated before this given date will not be downloaded.
        :param builtins.str object: The name of the object to pull from the data source. Examples of objects in Salesforce include `Case`, `Account`, or `Lead`.
        :param builtins.str schedule_expression: How often the data should be pulled from data source. Examples include `rate(1 hour)`, `rate(3 hours)`, `rate(1 day)`.
        """
        pulumi.set(__self__, "first_execution_from", first_execution_from)
        pulumi.set(__self__, "object", object)
        pulumi.set(__self__, "schedule_expression", schedule_expression)

    @property
    @pulumi.getter(name="firstExecutionFrom")
    def first_execution_from(self) -> builtins.str:
        """
        The start date for objects to import in the first flow run as an Unix/epoch timestamp in milliseconds or in ISO-8601 format. This needs to be a time in the past, meaning that the data created or updated before this given date will not be downloaded.
        """
        return pulumi.get(self, "first_execution_from")

    @property
    @pulumi.getter
    def object(self) -> builtins.str:
        """
        The name of the object to pull from the data source. Examples of objects in Salesforce include `Case`, `Account`, or `Lead`.
        """
        return pulumi.get(self, "object")

    @property
    @pulumi.getter(name="scheduleExpression")
    def schedule_expression(self) -> builtins.str:
        """
        How often the data should be pulled from data source. Examples include `rate(1 hour)`, `rate(3 hours)`, `rate(1 day)`.
        """
        return pulumi.get(self, "schedule_expression")


@pulumi.output_type
class GetEventIntegrationEventFilterResult(dict):
    def __init__(__self__, *,
                 source: builtins.str):
        """
        :param builtins.str source: The source of the events.
        """
        pulumi.set(__self__, "source", source)

    @property
    @pulumi.getter
    def source(self) -> builtins.str:
        """
        The source of the events.
        """
        return pulumi.get(self, "source")


