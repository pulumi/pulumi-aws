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

__all__ = [
    'GetApplicationAssignmentsResult',
    'AwaitableGetApplicationAssignmentsResult',
    'get_application_assignments',
    'get_application_assignments_output',
]

@pulumi.output_type
class GetApplicationAssignmentsResult:
    """
    A collection of values returned by getApplicationAssignments.
    """
    def __init__(__self__, application_arn=None, application_assignments=None, id=None):
        if application_arn and not isinstance(application_arn, str):
            raise TypeError("Expected argument 'application_arn' to be a str")
        pulumi.set(__self__, "application_arn", application_arn)
        if application_assignments and not isinstance(application_assignments, list):
            raise TypeError("Expected argument 'application_assignments' to be a list")
        pulumi.set(__self__, "application_assignments", application_assignments)
        if id and not isinstance(id, str):
            raise TypeError("Expected argument 'id' to be a str")
        pulumi.set(__self__, "id", id)

    @property
    @pulumi.getter(name="applicationArn")
    def application_arn(self) -> builtins.str:
        """
        ARN of the application.
        """
        return pulumi.get(self, "application_arn")

    @property
    @pulumi.getter(name="applicationAssignments")
    def application_assignments(self) -> Optional[Sequence['outputs.GetApplicationAssignmentsApplicationAssignmentResult']]:
        """
        List of principals assigned to the application. See the `application_assignments` attribute reference below.
        """
        return pulumi.get(self, "application_assignments")

    @property
    @pulumi.getter
    def id(self) -> builtins.str:
        return pulumi.get(self, "id")


class AwaitableGetApplicationAssignmentsResult(GetApplicationAssignmentsResult):
    # pylint: disable=using-constant-test
    def __await__(self):
        if False:
            yield self
        return GetApplicationAssignmentsResult(
            application_arn=self.application_arn,
            application_assignments=self.application_assignments,
            id=self.id)


def get_application_assignments(application_arn: Optional[builtins.str] = None,
                                application_assignments: Optional[Sequence[Union['GetApplicationAssignmentsApplicationAssignmentArgs', 'GetApplicationAssignmentsApplicationAssignmentArgsDict']]] = None,
                                opts: Optional[pulumi.InvokeOptions] = None) -> AwaitableGetApplicationAssignmentsResult:
    """
    Data source for managing AWS SSO Admin Application Assignments.

    ## Example Usage

    ### Basic Usage

    ```python
    import pulumi
    import pulumi_aws as aws

    example = aws.ssoadmin.get_application_assignments(application_arn=example_aws_ssoadmin_application["applicationArn"])
    ```


    :param builtins.str application_arn: ARN of the application.
    :param Sequence[Union['GetApplicationAssignmentsApplicationAssignmentArgs', 'GetApplicationAssignmentsApplicationAssignmentArgsDict']] application_assignments: List of principals assigned to the application. See the `application_assignments` attribute reference below.
    """
    __args__ = dict()
    __args__['applicationArn'] = application_arn
    __args__['applicationAssignments'] = application_assignments
    opts = pulumi.InvokeOptions.merge(_utilities.get_invoke_opts_defaults(), opts)
    __ret__ = pulumi.runtime.invoke('aws:ssoadmin/getApplicationAssignments:getApplicationAssignments', __args__, opts=opts, typ=GetApplicationAssignmentsResult).value

    return AwaitableGetApplicationAssignmentsResult(
        application_arn=pulumi.get(__ret__, 'application_arn'),
        application_assignments=pulumi.get(__ret__, 'application_assignments'),
        id=pulumi.get(__ret__, 'id'))
def get_application_assignments_output(application_arn: Optional[pulumi.Input[builtins.str]] = None,
                                       application_assignments: Optional[pulumi.Input[Optional[Sequence[Union['GetApplicationAssignmentsApplicationAssignmentArgs', 'GetApplicationAssignmentsApplicationAssignmentArgsDict']]]]] = None,
                                       opts: Optional[Union[pulumi.InvokeOptions, pulumi.InvokeOutputOptions]] = None) -> pulumi.Output[GetApplicationAssignmentsResult]:
    """
    Data source for managing AWS SSO Admin Application Assignments.

    ## Example Usage

    ### Basic Usage

    ```python
    import pulumi
    import pulumi_aws as aws

    example = aws.ssoadmin.get_application_assignments(application_arn=example_aws_ssoadmin_application["applicationArn"])
    ```


    :param builtins.str application_arn: ARN of the application.
    :param Sequence[Union['GetApplicationAssignmentsApplicationAssignmentArgs', 'GetApplicationAssignmentsApplicationAssignmentArgsDict']] application_assignments: List of principals assigned to the application. See the `application_assignments` attribute reference below.
    """
    __args__ = dict()
    __args__['applicationArn'] = application_arn
    __args__['applicationAssignments'] = application_assignments
    opts = pulumi.InvokeOutputOptions.merge(_utilities.get_invoke_opts_defaults(), opts)
    __ret__ = pulumi.runtime.invoke_output('aws:ssoadmin/getApplicationAssignments:getApplicationAssignments', __args__, opts=opts, typ=GetApplicationAssignmentsResult)
    return __ret__.apply(lambda __response__: GetApplicationAssignmentsResult(
        application_arn=pulumi.get(__response__, 'application_arn'),
        application_assignments=pulumi.get(__response__, 'application_assignments'),
        id=pulumi.get(__response__, 'id')))
