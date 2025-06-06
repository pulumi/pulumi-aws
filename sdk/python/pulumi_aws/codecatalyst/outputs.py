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
    'DevEnvironmentIdes',
    'DevEnvironmentPersistentStorage',
    'DevEnvironmentRepository',
    'GetDevEnvironmentIdeResult',
    'GetDevEnvironmentPersistentStorageResult',
    'GetDevEnvironmentRepositoryResult',
]

@pulumi.output_type
class DevEnvironmentIdes(dict):
    def __init__(__self__, *,
                 name: Optional[builtins.str] = None,
                 runtime: Optional[builtins.str] = None):
        """
        :param builtins.str name: The name of the IDE. Valid values include Cloud9, IntelliJ, PyCharm, GoLand, and VSCode.
        :param builtins.str runtime: A link to the IDE runtime image. This parameter is not required if the name is VSCode. Values of the runtime can be for example public.ecr.aws/jetbrains/py,public.ecr.aws/jetbrains/go
        """
        if name is not None:
            pulumi.set(__self__, "name", name)
        if runtime is not None:
            pulumi.set(__self__, "runtime", runtime)

    @property
    @pulumi.getter
    def name(self) -> Optional[builtins.str]:
        """
        The name of the IDE. Valid values include Cloud9, IntelliJ, PyCharm, GoLand, and VSCode.
        """
        return pulumi.get(self, "name")

    @property
    @pulumi.getter
    def runtime(self) -> Optional[builtins.str]:
        """
        A link to the IDE runtime image. This parameter is not required if the name is VSCode. Values of the runtime can be for example public.ecr.aws/jetbrains/py,public.ecr.aws/jetbrains/go
        """
        return pulumi.get(self, "runtime")


@pulumi.output_type
class DevEnvironmentPersistentStorage(dict):
    def __init__(__self__, *,
                 size: builtins.int):
        """
        :param builtins.int size: The size of the persistent storage in gigabytes (specifically GiB). Valid values for storage are based on memory sizes in 16GB increments. Valid values are 16, 32, and 64.
        """
        pulumi.set(__self__, "size", size)

    @property
    @pulumi.getter
    def size(self) -> builtins.int:
        """
        The size of the persistent storage in gigabytes (specifically GiB). Valid values for storage are based on memory sizes in 16GB increments. Valid values are 16, 32, and 64.
        """
        return pulumi.get(self, "size")


@pulumi.output_type
class DevEnvironmentRepository(dict):
    @staticmethod
    def __key_warning(key: str):
        suggest = None
        if key == "repositoryName":
            suggest = "repository_name"
        elif key == "branchName":
            suggest = "branch_name"

        if suggest:
            pulumi.log.warn(f"Key '{key}' not found in DevEnvironmentRepository. Access the value via the '{suggest}' property getter instead.")

    def __getitem__(self, key: str) -> Any:
        DevEnvironmentRepository.__key_warning(key)
        return super().__getitem__(key)

    def get(self, key: str, default = None) -> Any:
        DevEnvironmentRepository.__key_warning(key)
        return super().get(key, default)

    def __init__(__self__, *,
                 repository_name: builtins.str,
                 branch_name: Optional[builtins.str] = None):
        """
        :param builtins.str repository_name: The name of the source repository.
        :param builtins.str branch_name: The name of the branch in a source repository.
               
               persistent storage (` persistent_storage`) supports the following:
        """
        pulumi.set(__self__, "repository_name", repository_name)
        if branch_name is not None:
            pulumi.set(__self__, "branch_name", branch_name)

    @property
    @pulumi.getter(name="repositoryName")
    def repository_name(self) -> builtins.str:
        """
        The name of the source repository.
        """
        return pulumi.get(self, "repository_name")

    @property
    @pulumi.getter(name="branchName")
    def branch_name(self) -> Optional[builtins.str]:
        """
        The name of the branch in a source repository.

        persistent storage (` persistent_storage`) supports the following:
        """
        return pulumi.get(self, "branch_name")


@pulumi.output_type
class GetDevEnvironmentIdeResult(dict):
    def __init__(__self__, *,
                 name: builtins.str,
                 runtime: builtins.str):
        pulumi.set(__self__, "name", name)
        pulumi.set(__self__, "runtime", runtime)

    @property
    @pulumi.getter
    def name(self) -> builtins.str:
        return pulumi.get(self, "name")

    @property
    @pulumi.getter
    def runtime(self) -> builtins.str:
        return pulumi.get(self, "runtime")


@pulumi.output_type
class GetDevEnvironmentPersistentStorageResult(dict):
    def __init__(__self__, *,
                 size: builtins.int):
        pulumi.set(__self__, "size", size)

    @property
    @pulumi.getter
    def size(self) -> builtins.int:
        return pulumi.get(self, "size")


@pulumi.output_type
class GetDevEnvironmentRepositoryResult(dict):
    def __init__(__self__, *,
                 branch_name: builtins.str,
                 repository_name: builtins.str):
        pulumi.set(__self__, "branch_name", branch_name)
        pulumi.set(__self__, "repository_name", repository_name)

    @property
    @pulumi.getter(name="branchName")
    def branch_name(self) -> builtins.str:
        return pulumi.get(self, "branch_name")

    @property
    @pulumi.getter(name="repositoryName")
    def repository_name(self) -> builtins.str:
        return pulumi.get(self, "repository_name")


