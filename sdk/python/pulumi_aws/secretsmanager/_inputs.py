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
    'SecretReplicaArgs',
    'SecretReplicaArgsDict',
    'SecretRotationRotationRulesArgs',
    'SecretRotationRotationRulesArgsDict',
    'GetSecretsFilterArgs',
    'GetSecretsFilterArgsDict',
]

MYPY = False

if not MYPY:
    class SecretReplicaArgsDict(TypedDict):
        region: pulumi.Input[builtins.str]
        """
        Region for replicating the secret.
        """
        kms_key_id: NotRequired[pulumi.Input[builtins.str]]
        """
        ARN, Key ID, or Alias of the AWS KMS key within the region secret is replicated to. If one is not specified, then Secrets Manager defaults to using the AWS account's default KMS key (`aws/secretsmanager`) in the region or creates one for use if non-existent.
        """
        last_accessed_date: NotRequired[pulumi.Input[builtins.str]]
        """
        Date that you last accessed the secret in the Region.
        """
        status: NotRequired[pulumi.Input[builtins.str]]
        """
        Status can be `InProgress`, `Failed`, or `InSync`.
        """
        status_message: NotRequired[pulumi.Input[builtins.str]]
        """
        Message such as `Replication succeeded` or `Secret with this name already exists in this region`.
        """
elif False:
    SecretReplicaArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class SecretReplicaArgs:
    def __init__(__self__, *,
                 region: pulumi.Input[builtins.str],
                 kms_key_id: Optional[pulumi.Input[builtins.str]] = None,
                 last_accessed_date: Optional[pulumi.Input[builtins.str]] = None,
                 status: Optional[pulumi.Input[builtins.str]] = None,
                 status_message: Optional[pulumi.Input[builtins.str]] = None):
        """
        :param pulumi.Input[builtins.str] region: Region for replicating the secret.
        :param pulumi.Input[builtins.str] kms_key_id: ARN, Key ID, or Alias of the AWS KMS key within the region secret is replicated to. If one is not specified, then Secrets Manager defaults to using the AWS account's default KMS key (`aws/secretsmanager`) in the region or creates one for use if non-existent.
        :param pulumi.Input[builtins.str] last_accessed_date: Date that you last accessed the secret in the Region.
        :param pulumi.Input[builtins.str] status: Status can be `InProgress`, `Failed`, or `InSync`.
        :param pulumi.Input[builtins.str] status_message: Message such as `Replication succeeded` or `Secret with this name already exists in this region`.
        """
        pulumi.set(__self__, "region", region)
        if kms_key_id is not None:
            pulumi.set(__self__, "kms_key_id", kms_key_id)
        if last_accessed_date is not None:
            pulumi.set(__self__, "last_accessed_date", last_accessed_date)
        if status is not None:
            pulumi.set(__self__, "status", status)
        if status_message is not None:
            pulumi.set(__self__, "status_message", status_message)

    @property
    @pulumi.getter
    def region(self) -> pulumi.Input[builtins.str]:
        """
        Region for replicating the secret.
        """
        return pulumi.get(self, "region")

    @region.setter
    def region(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "region", value)

    @property
    @pulumi.getter(name="kmsKeyId")
    def kms_key_id(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        ARN, Key ID, or Alias of the AWS KMS key within the region secret is replicated to. If one is not specified, then Secrets Manager defaults to using the AWS account's default KMS key (`aws/secretsmanager`) in the region or creates one for use if non-existent.
        """
        return pulumi.get(self, "kms_key_id")

    @kms_key_id.setter
    def kms_key_id(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "kms_key_id", value)

    @property
    @pulumi.getter(name="lastAccessedDate")
    def last_accessed_date(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Date that you last accessed the secret in the Region.
        """
        return pulumi.get(self, "last_accessed_date")

    @last_accessed_date.setter
    def last_accessed_date(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "last_accessed_date", value)

    @property
    @pulumi.getter
    def status(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Status can be `InProgress`, `Failed`, or `InSync`.
        """
        return pulumi.get(self, "status")

    @status.setter
    def status(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "status", value)

    @property
    @pulumi.getter(name="statusMessage")
    def status_message(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Message such as `Replication succeeded` or `Secret with this name already exists in this region`.
        """
        return pulumi.get(self, "status_message")

    @status_message.setter
    def status_message(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "status_message", value)


if not MYPY:
    class SecretRotationRotationRulesArgsDict(TypedDict):
        automatically_after_days: NotRequired[pulumi.Input[builtins.int]]
        """
        Specifies the number of days between automatic scheduled rotations of the secret. Either `automatically_after_days` or `schedule_expression` must be specified.
        """
        duration: NotRequired[pulumi.Input[builtins.str]]
        """
        The length of the rotation window in hours. For example, `3h` for a three hour window.
        """
        schedule_expression: NotRequired[pulumi.Input[builtins.str]]
        """
        A `cron()` or `rate()` expression that defines the schedule for rotating your secret. Either `automatically_after_days` or `schedule_expression` must be specified.
        """
elif False:
    SecretRotationRotationRulesArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class SecretRotationRotationRulesArgs:
    def __init__(__self__, *,
                 automatically_after_days: Optional[pulumi.Input[builtins.int]] = None,
                 duration: Optional[pulumi.Input[builtins.str]] = None,
                 schedule_expression: Optional[pulumi.Input[builtins.str]] = None):
        """
        :param pulumi.Input[builtins.int] automatically_after_days: Specifies the number of days between automatic scheduled rotations of the secret. Either `automatically_after_days` or `schedule_expression` must be specified.
        :param pulumi.Input[builtins.str] duration: The length of the rotation window in hours. For example, `3h` for a three hour window.
        :param pulumi.Input[builtins.str] schedule_expression: A `cron()` or `rate()` expression that defines the schedule for rotating your secret. Either `automatically_after_days` or `schedule_expression` must be specified.
        """
        if automatically_after_days is not None:
            pulumi.set(__self__, "automatically_after_days", automatically_after_days)
        if duration is not None:
            pulumi.set(__self__, "duration", duration)
        if schedule_expression is not None:
            pulumi.set(__self__, "schedule_expression", schedule_expression)

    @property
    @pulumi.getter(name="automaticallyAfterDays")
    def automatically_after_days(self) -> Optional[pulumi.Input[builtins.int]]:
        """
        Specifies the number of days between automatic scheduled rotations of the secret. Either `automatically_after_days` or `schedule_expression` must be specified.
        """
        return pulumi.get(self, "automatically_after_days")

    @automatically_after_days.setter
    def automatically_after_days(self, value: Optional[pulumi.Input[builtins.int]]):
        pulumi.set(self, "automatically_after_days", value)

    @property
    @pulumi.getter
    def duration(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The length of the rotation window in hours. For example, `3h` for a three hour window.
        """
        return pulumi.get(self, "duration")

    @duration.setter
    def duration(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "duration", value)

    @property
    @pulumi.getter(name="scheduleExpression")
    def schedule_expression(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        A `cron()` or `rate()` expression that defines the schedule for rotating your secret. Either `automatically_after_days` or `schedule_expression` must be specified.
        """
        return pulumi.get(self, "schedule_expression")

    @schedule_expression.setter
    def schedule_expression(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "schedule_expression", value)


if not MYPY:
    class GetSecretsFilterArgsDict(TypedDict):
        name: builtins.str
        """
        Name of the filter field. Valid values can be found in the [Secrets Manager ListSecrets API Reference](https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_ListSecrets.html).
        """
        values: Sequence[builtins.str]
        """
        Set of values that are accepted for the given filter field. Results will be selected if any given value matches.
        """
elif False:
    GetSecretsFilterArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class GetSecretsFilterArgs:
    def __init__(__self__, *,
                 name: builtins.str,
                 values: Sequence[builtins.str]):
        """
        :param builtins.str name: Name of the filter field. Valid values can be found in the [Secrets Manager ListSecrets API Reference](https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_ListSecrets.html).
        :param Sequence[builtins.str] values: Set of values that are accepted for the given filter field. Results will be selected if any given value matches.
        """
        pulumi.set(__self__, "name", name)
        pulumi.set(__self__, "values", values)

    @property
    @pulumi.getter
    def name(self) -> builtins.str:
        """
        Name of the filter field. Valid values can be found in the [Secrets Manager ListSecrets API Reference](https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_ListSecrets.html).
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


