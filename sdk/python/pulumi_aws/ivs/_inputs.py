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
    'RecordingConfigurationDestinationConfigurationArgs',
    'RecordingConfigurationDestinationConfigurationArgsDict',
    'RecordingConfigurationDestinationConfigurationS3Args',
    'RecordingConfigurationDestinationConfigurationS3ArgsDict',
    'RecordingConfigurationThumbnailConfigurationArgs',
    'RecordingConfigurationThumbnailConfigurationArgsDict',
]

MYPY = False

if not MYPY:
    class RecordingConfigurationDestinationConfigurationArgsDict(TypedDict):
        s3: pulumi.Input['RecordingConfigurationDestinationConfigurationS3ArgsDict']
        """
        S3 destination configuration where recorded videos will be stored.
        """
elif False:
    RecordingConfigurationDestinationConfigurationArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class RecordingConfigurationDestinationConfigurationArgs:
    def __init__(__self__, *,
                 s3: pulumi.Input['RecordingConfigurationDestinationConfigurationS3Args']):
        """
        :param pulumi.Input['RecordingConfigurationDestinationConfigurationS3Args'] s3: S3 destination configuration where recorded videos will be stored.
        """
        pulumi.set(__self__, "s3", s3)

    @property
    @pulumi.getter
    def s3(self) -> pulumi.Input['RecordingConfigurationDestinationConfigurationS3Args']:
        """
        S3 destination configuration where recorded videos will be stored.
        """
        return pulumi.get(self, "s3")

    @s3.setter
    def s3(self, value: pulumi.Input['RecordingConfigurationDestinationConfigurationS3Args']):
        pulumi.set(self, "s3", value)


if not MYPY:
    class RecordingConfigurationDestinationConfigurationS3ArgsDict(TypedDict):
        bucket_name: pulumi.Input[builtins.str]
        """
        S3 bucket name where recorded videos will be stored.

        The following arguments are optional:
        """
elif False:
    RecordingConfigurationDestinationConfigurationS3ArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class RecordingConfigurationDestinationConfigurationS3Args:
    def __init__(__self__, *,
                 bucket_name: pulumi.Input[builtins.str]):
        """
        :param pulumi.Input[builtins.str] bucket_name: S3 bucket name where recorded videos will be stored.
               
               The following arguments are optional:
        """
        pulumi.set(__self__, "bucket_name", bucket_name)

    @property
    @pulumi.getter(name="bucketName")
    def bucket_name(self) -> pulumi.Input[builtins.str]:
        """
        S3 bucket name where recorded videos will be stored.

        The following arguments are optional:
        """
        return pulumi.get(self, "bucket_name")

    @bucket_name.setter
    def bucket_name(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "bucket_name", value)


if not MYPY:
    class RecordingConfigurationThumbnailConfigurationArgsDict(TypedDict):
        recording_mode: NotRequired[pulumi.Input[builtins.str]]
        """
        Thumbnail recording mode. Valid values: `DISABLED`, `INTERVAL`.
        """
        target_interval_seconds: NotRequired[pulumi.Input[builtins.int]]
        """
        The targeted thumbnail-generation interval in seconds.
        """
elif False:
    RecordingConfigurationThumbnailConfigurationArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class RecordingConfigurationThumbnailConfigurationArgs:
    def __init__(__self__, *,
                 recording_mode: Optional[pulumi.Input[builtins.str]] = None,
                 target_interval_seconds: Optional[pulumi.Input[builtins.int]] = None):
        """
        :param pulumi.Input[builtins.str] recording_mode: Thumbnail recording mode. Valid values: `DISABLED`, `INTERVAL`.
        :param pulumi.Input[builtins.int] target_interval_seconds: The targeted thumbnail-generation interval in seconds.
        """
        if recording_mode is not None:
            pulumi.set(__self__, "recording_mode", recording_mode)
        if target_interval_seconds is not None:
            pulumi.set(__self__, "target_interval_seconds", target_interval_seconds)

    @property
    @pulumi.getter(name="recordingMode")
    def recording_mode(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Thumbnail recording mode. Valid values: `DISABLED`, `INTERVAL`.
        """
        return pulumi.get(self, "recording_mode")

    @recording_mode.setter
    def recording_mode(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "recording_mode", value)

    @property
    @pulumi.getter(name="targetIntervalSeconds")
    def target_interval_seconds(self) -> Optional[pulumi.Input[builtins.int]]:
        """
        The targeted thumbnail-generation interval in seconds.
        """
        return pulumi.get(self, "target_interval_seconds")

    @target_interval_seconds.setter
    def target_interval_seconds(self, value: Optional[pulumi.Input[builtins.int]]):
        pulumi.set(self, "target_interval_seconds", value)


