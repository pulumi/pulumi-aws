# coding=utf-8
# *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
# *** Do not edit by hand unless you're certain you know what you are doing! ***

import copy
import warnings
import pulumi
import pulumi.runtime
from typing import Any, Mapping, Optional, Sequence, Union, overload
from .. import _utilities
from . import outputs

__all__ = [
    'GetWindowsFileSystemResult',
    'AwaitableGetWindowsFileSystemResult',
    'get_windows_file_system',
    'get_windows_file_system_output',
]

@pulumi.output_type
class GetWindowsFileSystemResult:
    """
    A collection of values returned by getWindowsFileSystem.
    """
    def __init__(__self__, active_directory_id=None, aliases=None, arn=None, audit_log_configurations=None, automatic_backup_retention_days=None, backup_id=None, copy_tags_to_backups=None, daily_automatic_backup_start_time=None, deployment_type=None, dns_name=None, id=None, kms_key_id=None, network_interface_ids=None, owner_id=None, preferred_file_server_ip=None, preferred_subnet_id=None, security_group_ids=None, skip_final_backup=None, storage_capacity=None, storage_type=None, subnet_ids=None, tags=None, throughput_capacity=None, vpc_id=None, weekly_maintenance_start_time=None):
        if active_directory_id and not isinstance(active_directory_id, str):
            raise TypeError("Expected argument 'active_directory_id' to be a str")
        pulumi.set(__self__, "active_directory_id", active_directory_id)
        if aliases and not isinstance(aliases, list):
            raise TypeError("Expected argument 'aliases' to be a list")
        pulumi.set(__self__, "aliases", aliases)
        if arn and not isinstance(arn, str):
            raise TypeError("Expected argument 'arn' to be a str")
        pulumi.set(__self__, "arn", arn)
        if audit_log_configurations and not isinstance(audit_log_configurations, list):
            raise TypeError("Expected argument 'audit_log_configurations' to be a list")
        pulumi.set(__self__, "audit_log_configurations", audit_log_configurations)
        if automatic_backup_retention_days and not isinstance(automatic_backup_retention_days, int):
            raise TypeError("Expected argument 'automatic_backup_retention_days' to be a int")
        pulumi.set(__self__, "automatic_backup_retention_days", automatic_backup_retention_days)
        if backup_id and not isinstance(backup_id, str):
            raise TypeError("Expected argument 'backup_id' to be a str")
        pulumi.set(__self__, "backup_id", backup_id)
        if copy_tags_to_backups and not isinstance(copy_tags_to_backups, bool):
            raise TypeError("Expected argument 'copy_tags_to_backups' to be a bool")
        pulumi.set(__self__, "copy_tags_to_backups", copy_tags_to_backups)
        if daily_automatic_backup_start_time and not isinstance(daily_automatic_backup_start_time, str):
            raise TypeError("Expected argument 'daily_automatic_backup_start_time' to be a str")
        pulumi.set(__self__, "daily_automatic_backup_start_time", daily_automatic_backup_start_time)
        if deployment_type and not isinstance(deployment_type, str):
            raise TypeError("Expected argument 'deployment_type' to be a str")
        pulumi.set(__self__, "deployment_type", deployment_type)
        if dns_name and not isinstance(dns_name, str):
            raise TypeError("Expected argument 'dns_name' to be a str")
        pulumi.set(__self__, "dns_name", dns_name)
        if id and not isinstance(id, str):
            raise TypeError("Expected argument 'id' to be a str")
        pulumi.set(__self__, "id", id)
        if kms_key_id and not isinstance(kms_key_id, str):
            raise TypeError("Expected argument 'kms_key_id' to be a str")
        pulumi.set(__self__, "kms_key_id", kms_key_id)
        if network_interface_ids and not isinstance(network_interface_ids, list):
            raise TypeError("Expected argument 'network_interface_ids' to be a list")
        pulumi.set(__self__, "network_interface_ids", network_interface_ids)
        if owner_id and not isinstance(owner_id, str):
            raise TypeError("Expected argument 'owner_id' to be a str")
        pulumi.set(__self__, "owner_id", owner_id)
        if preferred_file_server_ip and not isinstance(preferred_file_server_ip, str):
            raise TypeError("Expected argument 'preferred_file_server_ip' to be a str")
        pulumi.set(__self__, "preferred_file_server_ip", preferred_file_server_ip)
        if preferred_subnet_id and not isinstance(preferred_subnet_id, str):
            raise TypeError("Expected argument 'preferred_subnet_id' to be a str")
        pulumi.set(__self__, "preferred_subnet_id", preferred_subnet_id)
        if security_group_ids and not isinstance(security_group_ids, list):
            raise TypeError("Expected argument 'security_group_ids' to be a list")
        pulumi.set(__self__, "security_group_ids", security_group_ids)
        if skip_final_backup and not isinstance(skip_final_backup, bool):
            raise TypeError("Expected argument 'skip_final_backup' to be a bool")
        pulumi.set(__self__, "skip_final_backup", skip_final_backup)
        if storage_capacity and not isinstance(storage_capacity, int):
            raise TypeError("Expected argument 'storage_capacity' to be a int")
        pulumi.set(__self__, "storage_capacity", storage_capacity)
        if storage_type and not isinstance(storage_type, str):
            raise TypeError("Expected argument 'storage_type' to be a str")
        pulumi.set(__self__, "storage_type", storage_type)
        if subnet_ids and not isinstance(subnet_ids, list):
            raise TypeError("Expected argument 'subnet_ids' to be a list")
        pulumi.set(__self__, "subnet_ids", subnet_ids)
        if tags and not isinstance(tags, dict):
            raise TypeError("Expected argument 'tags' to be a dict")
        pulumi.set(__self__, "tags", tags)
        if throughput_capacity and not isinstance(throughput_capacity, int):
            raise TypeError("Expected argument 'throughput_capacity' to be a int")
        pulumi.set(__self__, "throughput_capacity", throughput_capacity)
        if vpc_id and not isinstance(vpc_id, str):
            raise TypeError("Expected argument 'vpc_id' to be a str")
        pulumi.set(__self__, "vpc_id", vpc_id)
        if weekly_maintenance_start_time and not isinstance(weekly_maintenance_start_time, str):
            raise TypeError("Expected argument 'weekly_maintenance_start_time' to be a str")
        pulumi.set(__self__, "weekly_maintenance_start_time", weekly_maintenance_start_time)

    @property
    @pulumi.getter(name="activeDirectoryId")
    def active_directory_id(self) -> str:
        """
        The ID for Microsoft Active Directory instance that the file system is join to.
        """
        return pulumi.get(self, "active_directory_id")

    @property
    @pulumi.getter
    def aliases(self) -> Sequence[str]:
        """
        An array DNS alias names associated with the Amazon FSx file system.
        """
        return pulumi.get(self, "aliases")

    @property
    @pulumi.getter
    def arn(self) -> str:
        """
        Amazon Resource Name of the file system.
        """
        return pulumi.get(self, "arn")

    @property
    @pulumi.getter(name="auditLogConfigurations")
    def audit_log_configurations(self) -> Sequence['outputs.GetWindowsFileSystemAuditLogConfigurationResult']:
        """
        The configuration that Amazon FSx for Windows File Server uses to audit and log user accesses of files, folders, and file shares on the Amazon FSx for Windows File Server file system.
        """
        return pulumi.get(self, "audit_log_configurations")

    @property
    @pulumi.getter(name="automaticBackupRetentionDays")
    def automatic_backup_retention_days(self) -> int:
        """
        The number of days to retain automatic backups.
        """
        return pulumi.get(self, "automatic_backup_retention_days")

    @property
    @pulumi.getter(name="backupId")
    def backup_id(self) -> str:
        return pulumi.get(self, "backup_id")

    @property
    @pulumi.getter(name="copyTagsToBackups")
    def copy_tags_to_backups(self) -> bool:
        """
        A boolean flag indicating whether tags on the file system should be copied to backups.
        """
        return pulumi.get(self, "copy_tags_to_backups")

    @property
    @pulumi.getter(name="dailyAutomaticBackupStartTime")
    def daily_automatic_backup_start_time(self) -> str:
        """
        The preferred time (in `HH:MM` format) to take daily automatic backups, in the UTC time zone.
        """
        return pulumi.get(self, "daily_automatic_backup_start_time")

    @property
    @pulumi.getter(name="deploymentType")
    def deployment_type(self) -> str:
        """
        The file system deployment type.
        """
        return pulumi.get(self, "deployment_type")

    @property
    @pulumi.getter(name="dnsName")
    def dns_name(self) -> str:
        """
        DNS name for the file system (e.g. `fs-12345678.corp.example.com`).
        """
        return pulumi.get(self, "dns_name")

    @property
    @pulumi.getter
    def id(self) -> str:
        """
        Identifier of the file system (e.g. `fs-12345678`).
        """
        return pulumi.get(self, "id")

    @property
    @pulumi.getter(name="kmsKeyId")
    def kms_key_id(self) -> str:
        """
        ARN for the KMS Key to encrypt the file system at rest.
        """
        return pulumi.get(self, "kms_key_id")

    @property
    @pulumi.getter(name="networkInterfaceIds")
    def network_interface_ids(self) -> Sequence[str]:
        return pulumi.get(self, "network_interface_ids")

    @property
    @pulumi.getter(name="ownerId")
    def owner_id(self) -> str:
        """
        AWS account identifier that created the file system.
        """
        return pulumi.get(self, "owner_id")

    @property
    @pulumi.getter(name="preferredFileServerIp")
    def preferred_file_server_ip(self) -> str:
        """
        The IP address of the primary, or preferred, file server.
        """
        return pulumi.get(self, "preferred_file_server_ip")

    @property
    @pulumi.getter(name="preferredSubnetId")
    def preferred_subnet_id(self) -> str:
        """
        Specifies the subnet in which you want the preferred file server to be located.
        """
        return pulumi.get(self, "preferred_subnet_id")

    @property
    @pulumi.getter(name="securityGroupIds")
    def security_group_ids(self) -> Sequence[str]:
        return pulumi.get(self, "security_group_ids")

    @property
    @pulumi.getter(name="skipFinalBackup")
    def skip_final_backup(self) -> bool:
        return pulumi.get(self, "skip_final_backup")

    @property
    @pulumi.getter(name="storageCapacity")
    def storage_capacity(self) -> int:
        """
        The storage capacity of the file system in gibibytes (GiB).
        """
        return pulumi.get(self, "storage_capacity")

    @property
    @pulumi.getter(name="storageType")
    def storage_type(self) -> str:
        """
        The type of storage the file system is using. If set to `SSD`, the file system uses solid state drive storage. If set to `HDD`, the file system uses hard disk drive storage.
        """
        return pulumi.get(self, "storage_type")

    @property
    @pulumi.getter(name="subnetIds")
    def subnet_ids(self) -> Sequence[str]:
        """
        Specifies the IDs of the subnets that the file system is accessible from.
        """
        return pulumi.get(self, "subnet_ids")

    @property
    @pulumi.getter
    def tags(self) -> Mapping[str, str]:
        """
        The tags to associate with the file system.
        """
        return pulumi.get(self, "tags")

    @property
    @pulumi.getter(name="throughputCapacity")
    def throughput_capacity(self) -> int:
        """
        Throughput (megabytes per second) of the file system in power of 2 increments. Minimum of `8` and maximum of `2048`.
        """
        return pulumi.get(self, "throughput_capacity")

    @property
    @pulumi.getter(name="vpcId")
    def vpc_id(self) -> str:
        """
        The ID of the primary virtual private cloud (VPC) for the file system.
        """
        return pulumi.get(self, "vpc_id")

    @property
    @pulumi.getter(name="weeklyMaintenanceStartTime")
    def weekly_maintenance_start_time(self) -> str:
        """
        The preferred start time (in `d:HH:MM` format) to perform weekly maintenance, in the UTC time zone.
        """
        return pulumi.get(self, "weekly_maintenance_start_time")


class AwaitableGetWindowsFileSystemResult(GetWindowsFileSystemResult):
    # pylint: disable=using-constant-test
    def __await__(self):
        if False:
            yield self
        return GetWindowsFileSystemResult(
            active_directory_id=self.active_directory_id,
            aliases=self.aliases,
            arn=self.arn,
            audit_log_configurations=self.audit_log_configurations,
            automatic_backup_retention_days=self.automatic_backup_retention_days,
            backup_id=self.backup_id,
            copy_tags_to_backups=self.copy_tags_to_backups,
            daily_automatic_backup_start_time=self.daily_automatic_backup_start_time,
            deployment_type=self.deployment_type,
            dns_name=self.dns_name,
            id=self.id,
            kms_key_id=self.kms_key_id,
            network_interface_ids=self.network_interface_ids,
            owner_id=self.owner_id,
            preferred_file_server_ip=self.preferred_file_server_ip,
            preferred_subnet_id=self.preferred_subnet_id,
            security_group_ids=self.security_group_ids,
            skip_final_backup=self.skip_final_backup,
            storage_capacity=self.storage_capacity,
            storage_type=self.storage_type,
            subnet_ids=self.subnet_ids,
            tags=self.tags,
            throughput_capacity=self.throughput_capacity,
            vpc_id=self.vpc_id,
            weekly_maintenance_start_time=self.weekly_maintenance_start_time)


def get_windows_file_system(id: Optional[str] = None,
                            tags: Optional[Mapping[str, str]] = None,
                            opts: Optional[pulumi.InvokeOptions] = None) -> AwaitableGetWindowsFileSystemResult:
    """
    Retrieve information on FSx Windows File System.

    ## Example Usage
    ### Root volume Example
    ```python
    import pulumi
    import pulumi_aws as aws

    example = aws.fsx.get_windows_file_system(id="fs-12345678")
    ```


    :param str id: Identifier of the file system (e.g. `fs-12345678`).
    :param Mapping[str, str] tags: The tags to associate with the file system.
    """
    __args__ = dict()
    __args__['id'] = id
    __args__['tags'] = tags
    opts = pulumi.InvokeOptions.merge(_utilities.get_invoke_opts_defaults(), opts)
    __ret__ = pulumi.runtime.invoke('aws:fsx/getWindowsFileSystem:getWindowsFileSystem', __args__, opts=opts, typ=GetWindowsFileSystemResult).value

    return AwaitableGetWindowsFileSystemResult(
        active_directory_id=__ret__.active_directory_id,
        aliases=__ret__.aliases,
        arn=__ret__.arn,
        audit_log_configurations=__ret__.audit_log_configurations,
        automatic_backup_retention_days=__ret__.automatic_backup_retention_days,
        backup_id=__ret__.backup_id,
        copy_tags_to_backups=__ret__.copy_tags_to_backups,
        daily_automatic_backup_start_time=__ret__.daily_automatic_backup_start_time,
        deployment_type=__ret__.deployment_type,
        dns_name=__ret__.dns_name,
        id=__ret__.id,
        kms_key_id=__ret__.kms_key_id,
        network_interface_ids=__ret__.network_interface_ids,
        owner_id=__ret__.owner_id,
        preferred_file_server_ip=__ret__.preferred_file_server_ip,
        preferred_subnet_id=__ret__.preferred_subnet_id,
        security_group_ids=__ret__.security_group_ids,
        skip_final_backup=__ret__.skip_final_backup,
        storage_capacity=__ret__.storage_capacity,
        storage_type=__ret__.storage_type,
        subnet_ids=__ret__.subnet_ids,
        tags=__ret__.tags,
        throughput_capacity=__ret__.throughput_capacity,
        vpc_id=__ret__.vpc_id,
        weekly_maintenance_start_time=__ret__.weekly_maintenance_start_time)


@_utilities.lift_output_func(get_windows_file_system)
def get_windows_file_system_output(id: Optional[pulumi.Input[str]] = None,
                                   tags: Optional[pulumi.Input[Optional[Mapping[str, str]]]] = None,
                                   opts: Optional[pulumi.InvokeOptions] = None) -> pulumi.Output[GetWindowsFileSystemResult]:
    """
    Retrieve information on FSx Windows File System.

    ## Example Usage
    ### Root volume Example
    ```python
    import pulumi
    import pulumi_aws as aws

    example = aws.fsx.get_windows_file_system(id="fs-12345678")
    ```


    :param str id: Identifier of the file system (e.g. `fs-12345678`).
    :param Mapping[str, str] tags: The tags to associate with the file system.
    """
    ...