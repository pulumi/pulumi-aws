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
from ._inputs import *

__all__ = ['RefreshScheduleArgs', 'RefreshSchedule']

@pulumi.input_type
class RefreshScheduleArgs:
    def __init__(__self__, *,
                 data_set_id: pulumi.Input[str],
                 schedule_id: pulumi.Input[str],
                 aws_account_id: Optional[pulumi.Input[str]] = None,
                 schedule: Optional[pulumi.Input['RefreshScheduleScheduleArgs']] = None):
        """
        The set of arguments for constructing a RefreshSchedule resource.
        :param pulumi.Input[str] data_set_id: The ID of the dataset.
        :param pulumi.Input[str] schedule_id: The ID of the refresh schedule.
        :param pulumi.Input[str] aws_account_id: AWS account ID.
        :param pulumi.Input['RefreshScheduleScheduleArgs'] schedule: The [refresh schedule](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_RefreshSchedule.html). See schedule
        """
        pulumi.set(__self__, "data_set_id", data_set_id)
        pulumi.set(__self__, "schedule_id", schedule_id)
        if aws_account_id is not None:
            pulumi.set(__self__, "aws_account_id", aws_account_id)
        if schedule is not None:
            pulumi.set(__self__, "schedule", schedule)

    @property
    @pulumi.getter(name="dataSetId")
    def data_set_id(self) -> pulumi.Input[str]:
        """
        The ID of the dataset.
        """
        return pulumi.get(self, "data_set_id")

    @data_set_id.setter
    def data_set_id(self, value: pulumi.Input[str]):
        pulumi.set(self, "data_set_id", value)

    @property
    @pulumi.getter(name="scheduleId")
    def schedule_id(self) -> pulumi.Input[str]:
        """
        The ID of the refresh schedule.
        """
        return pulumi.get(self, "schedule_id")

    @schedule_id.setter
    def schedule_id(self, value: pulumi.Input[str]):
        pulumi.set(self, "schedule_id", value)

    @property
    @pulumi.getter(name="awsAccountId")
    def aws_account_id(self) -> Optional[pulumi.Input[str]]:
        """
        AWS account ID.
        """
        return pulumi.get(self, "aws_account_id")

    @aws_account_id.setter
    def aws_account_id(self, value: Optional[pulumi.Input[str]]):
        pulumi.set(self, "aws_account_id", value)

    @property
    @pulumi.getter
    def schedule(self) -> Optional[pulumi.Input['RefreshScheduleScheduleArgs']]:
        """
        The [refresh schedule](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_RefreshSchedule.html). See schedule
        """
        return pulumi.get(self, "schedule")

    @schedule.setter
    def schedule(self, value: Optional[pulumi.Input['RefreshScheduleScheduleArgs']]):
        pulumi.set(self, "schedule", value)


@pulumi.input_type
class _RefreshScheduleState:
    def __init__(__self__, *,
                 arn: Optional[pulumi.Input[str]] = None,
                 aws_account_id: Optional[pulumi.Input[str]] = None,
                 data_set_id: Optional[pulumi.Input[str]] = None,
                 schedule: Optional[pulumi.Input['RefreshScheduleScheduleArgs']] = None,
                 schedule_id: Optional[pulumi.Input[str]] = None):
        """
        Input properties used for looking up and filtering RefreshSchedule resources.
        :param pulumi.Input[str] arn: Amazon Resource Name (ARN) of the refresh schedule.
        :param pulumi.Input[str] aws_account_id: AWS account ID.
        :param pulumi.Input[str] data_set_id: The ID of the dataset.
        :param pulumi.Input['RefreshScheduleScheduleArgs'] schedule: The [refresh schedule](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_RefreshSchedule.html). See schedule
        :param pulumi.Input[str] schedule_id: The ID of the refresh schedule.
        """
        if arn is not None:
            pulumi.set(__self__, "arn", arn)
        if aws_account_id is not None:
            pulumi.set(__self__, "aws_account_id", aws_account_id)
        if data_set_id is not None:
            pulumi.set(__self__, "data_set_id", data_set_id)
        if schedule is not None:
            pulumi.set(__self__, "schedule", schedule)
        if schedule_id is not None:
            pulumi.set(__self__, "schedule_id", schedule_id)

    @property
    @pulumi.getter
    def arn(self) -> Optional[pulumi.Input[str]]:
        """
        Amazon Resource Name (ARN) of the refresh schedule.
        """
        return pulumi.get(self, "arn")

    @arn.setter
    def arn(self, value: Optional[pulumi.Input[str]]):
        pulumi.set(self, "arn", value)

    @property
    @pulumi.getter(name="awsAccountId")
    def aws_account_id(self) -> Optional[pulumi.Input[str]]:
        """
        AWS account ID.
        """
        return pulumi.get(self, "aws_account_id")

    @aws_account_id.setter
    def aws_account_id(self, value: Optional[pulumi.Input[str]]):
        pulumi.set(self, "aws_account_id", value)

    @property
    @pulumi.getter(name="dataSetId")
    def data_set_id(self) -> Optional[pulumi.Input[str]]:
        """
        The ID of the dataset.
        """
        return pulumi.get(self, "data_set_id")

    @data_set_id.setter
    def data_set_id(self, value: Optional[pulumi.Input[str]]):
        pulumi.set(self, "data_set_id", value)

    @property
    @pulumi.getter
    def schedule(self) -> Optional[pulumi.Input['RefreshScheduleScheduleArgs']]:
        """
        The [refresh schedule](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_RefreshSchedule.html). See schedule
        """
        return pulumi.get(self, "schedule")

    @schedule.setter
    def schedule(self, value: Optional[pulumi.Input['RefreshScheduleScheduleArgs']]):
        pulumi.set(self, "schedule", value)

    @property
    @pulumi.getter(name="scheduleId")
    def schedule_id(self) -> Optional[pulumi.Input[str]]:
        """
        The ID of the refresh schedule.
        """
        return pulumi.get(self, "schedule_id")

    @schedule_id.setter
    def schedule_id(self, value: Optional[pulumi.Input[str]]):
        pulumi.set(self, "schedule_id", value)


class RefreshSchedule(pulumi.CustomResource):
    @overload
    def __init__(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 aws_account_id: Optional[pulumi.Input[str]] = None,
                 data_set_id: Optional[pulumi.Input[str]] = None,
                 schedule: Optional[pulumi.Input[pulumi.InputType['RefreshScheduleScheduleArgs']]] = None,
                 schedule_id: Optional[pulumi.Input[str]] = None,
                 __props__=None):
        """
        Resource for managing a QuickSight Refresh Schedule.

        ## Example Usage
        ### Basic Usage
        ```python
        import pulumi
        import pulumi_aws as aws

        example = aws.quicksight.RefreshSchedule("example",
            data_set_id="dataset-id",
            schedule=aws.quicksight.RefreshScheduleScheduleArgs(
                refresh_type="FULL_REFRESH",
                schedule_frequency=aws.quicksight.RefreshScheduleScheduleScheduleFrequencyArgs(
                    interval="HOURLY",
                ),
            ),
            schedule_id="schedule-id")
        ```

        ## Import

        A QuickSight Refresh Schedule can be imported using the AWS account ID, data set ID and schedule ID separated by commas (`,`) e.g.,

        ```sh
         $ pulumi import aws:quicksight/refreshSchedule:RefreshSchedule example 123456789012,dataset-id,schedule-id
        ```

        :param str resource_name: The name of the resource.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[str] aws_account_id: AWS account ID.
        :param pulumi.Input[str] data_set_id: The ID of the dataset.
        :param pulumi.Input[pulumi.InputType['RefreshScheduleScheduleArgs']] schedule: The [refresh schedule](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_RefreshSchedule.html). See schedule
        :param pulumi.Input[str] schedule_id: The ID of the refresh schedule.
        """
        ...
    @overload
    def __init__(__self__,
                 resource_name: str,
                 args: RefreshScheduleArgs,
                 opts: Optional[pulumi.ResourceOptions] = None):
        """
        Resource for managing a QuickSight Refresh Schedule.

        ## Example Usage
        ### Basic Usage
        ```python
        import pulumi
        import pulumi_aws as aws

        example = aws.quicksight.RefreshSchedule("example",
            data_set_id="dataset-id",
            schedule=aws.quicksight.RefreshScheduleScheduleArgs(
                refresh_type="FULL_REFRESH",
                schedule_frequency=aws.quicksight.RefreshScheduleScheduleScheduleFrequencyArgs(
                    interval="HOURLY",
                ),
            ),
            schedule_id="schedule-id")
        ```

        ## Import

        A QuickSight Refresh Schedule can be imported using the AWS account ID, data set ID and schedule ID separated by commas (`,`) e.g.,

        ```sh
         $ pulumi import aws:quicksight/refreshSchedule:RefreshSchedule example 123456789012,dataset-id,schedule-id
        ```

        :param str resource_name: The name of the resource.
        :param RefreshScheduleArgs args: The arguments to use to populate this resource's properties.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        ...
    def __init__(__self__, resource_name: str, *args, **kwargs):
        resource_args, opts = _utilities.get_resource_args_opts(RefreshScheduleArgs, pulumi.ResourceOptions, *args, **kwargs)
        if resource_args is not None:
            __self__._internal_init(resource_name, opts, **resource_args.__dict__)
        else:
            __self__._internal_init(resource_name, *args, **kwargs)

    def _internal_init(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 aws_account_id: Optional[pulumi.Input[str]] = None,
                 data_set_id: Optional[pulumi.Input[str]] = None,
                 schedule: Optional[pulumi.Input[pulumi.InputType['RefreshScheduleScheduleArgs']]] = None,
                 schedule_id: Optional[pulumi.Input[str]] = None,
                 __props__=None):
        opts = pulumi.ResourceOptions.merge(_utilities.get_resource_opts_defaults(), opts)
        if not isinstance(opts, pulumi.ResourceOptions):
            raise TypeError('Expected resource options to be a ResourceOptions instance')
        if opts.id is None:
            if __props__ is not None:
                raise TypeError('__props__ is only valid when passed in combination with a valid opts.id to get an existing resource')
            __props__ = RefreshScheduleArgs.__new__(RefreshScheduleArgs)

            __props__.__dict__["aws_account_id"] = aws_account_id
            if data_set_id is None and not opts.urn:
                raise TypeError("Missing required property 'data_set_id'")
            __props__.__dict__["data_set_id"] = data_set_id
            __props__.__dict__["schedule"] = schedule
            if schedule_id is None and not opts.urn:
                raise TypeError("Missing required property 'schedule_id'")
            __props__.__dict__["schedule_id"] = schedule_id
            __props__.__dict__["arn"] = None
        super(RefreshSchedule, __self__).__init__(
            'aws:quicksight/refreshSchedule:RefreshSchedule',
            resource_name,
            __props__,
            opts)

    @staticmethod
    def get(resource_name: str,
            id: pulumi.Input[str],
            opts: Optional[pulumi.ResourceOptions] = None,
            arn: Optional[pulumi.Input[str]] = None,
            aws_account_id: Optional[pulumi.Input[str]] = None,
            data_set_id: Optional[pulumi.Input[str]] = None,
            schedule: Optional[pulumi.Input[pulumi.InputType['RefreshScheduleScheduleArgs']]] = None,
            schedule_id: Optional[pulumi.Input[str]] = None) -> 'RefreshSchedule':
        """
        Get an existing RefreshSchedule resource's state with the given name, id, and optional extra
        properties used to qualify the lookup.

        :param str resource_name: The unique name of the resulting resource.
        :param pulumi.Input[str] id: The unique provider ID of the resource to lookup.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[str] arn: Amazon Resource Name (ARN) of the refresh schedule.
        :param pulumi.Input[str] aws_account_id: AWS account ID.
        :param pulumi.Input[str] data_set_id: The ID of the dataset.
        :param pulumi.Input[pulumi.InputType['RefreshScheduleScheduleArgs']] schedule: The [refresh schedule](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_RefreshSchedule.html). See schedule
        :param pulumi.Input[str] schedule_id: The ID of the refresh schedule.
        """
        opts = pulumi.ResourceOptions.merge(opts, pulumi.ResourceOptions(id=id))

        __props__ = _RefreshScheduleState.__new__(_RefreshScheduleState)

        __props__.__dict__["arn"] = arn
        __props__.__dict__["aws_account_id"] = aws_account_id
        __props__.__dict__["data_set_id"] = data_set_id
        __props__.__dict__["schedule"] = schedule
        __props__.__dict__["schedule_id"] = schedule_id
        return RefreshSchedule(resource_name, opts=opts, __props__=__props__)

    @property
    @pulumi.getter
    def arn(self) -> pulumi.Output[str]:
        """
        Amazon Resource Name (ARN) of the refresh schedule.
        """
        return pulumi.get(self, "arn")

    @property
    @pulumi.getter(name="awsAccountId")
    def aws_account_id(self) -> pulumi.Output[str]:
        """
        AWS account ID.
        """
        return pulumi.get(self, "aws_account_id")

    @property
    @pulumi.getter(name="dataSetId")
    def data_set_id(self) -> pulumi.Output[str]:
        """
        The ID of the dataset.
        """
        return pulumi.get(self, "data_set_id")

    @property
    @pulumi.getter
    def schedule(self) -> pulumi.Output[Optional['outputs.RefreshScheduleSchedule']]:
        """
        The [refresh schedule](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_RefreshSchedule.html). See schedule
        """
        return pulumi.get(self, "schedule")

    @property
    @pulumi.getter(name="scheduleId")
    def schedule_id(self) -> pulumi.Output[str]:
        """
        The ID of the refresh schedule.
        """
        return pulumi.get(self, "schedule_id")
