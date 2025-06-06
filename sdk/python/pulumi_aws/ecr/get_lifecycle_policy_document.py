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
    'GetLifecyclePolicyDocumentResult',
    'AwaitableGetLifecyclePolicyDocumentResult',
    'get_lifecycle_policy_document',
    'get_lifecycle_policy_document_output',
]

@pulumi.output_type
class GetLifecyclePolicyDocumentResult:
    """
    A collection of values returned by getLifecyclePolicyDocument.
    """
    def __init__(__self__, id=None, json=None, rules=None):
        if id and not isinstance(id, str):
            raise TypeError("Expected argument 'id' to be a str")
        pulumi.set(__self__, "id", id)
        if json and not isinstance(json, str):
            raise TypeError("Expected argument 'json' to be a str")
        pulumi.set(__self__, "json", json)
        if rules and not isinstance(rules, list):
            raise TypeError("Expected argument 'rules' to be a list")
        pulumi.set(__self__, "rules", rules)

    @property
    @pulumi.getter
    def id(self) -> builtins.str:
        """
        The provider-assigned unique ID for this managed resource.
        """
        return pulumi.get(self, "id")

    @property
    @pulumi.getter
    def json(self) -> builtins.str:
        """
        The above arguments serialized as a standard JSON policy document.
        """
        return pulumi.get(self, "json")

    @property
    @pulumi.getter
    def rules(self) -> Optional[Sequence['outputs.GetLifecyclePolicyDocumentRuleResult']]:
        return pulumi.get(self, "rules")


class AwaitableGetLifecyclePolicyDocumentResult(GetLifecyclePolicyDocumentResult):
    # pylint: disable=using-constant-test
    def __await__(self):
        if False:
            yield self
        return GetLifecyclePolicyDocumentResult(
            id=self.id,
            json=self.json,
            rules=self.rules)


def get_lifecycle_policy_document(rules: Optional[Sequence[Union['GetLifecyclePolicyDocumentRuleArgs', 'GetLifecyclePolicyDocumentRuleArgsDict']]] = None,
                                  opts: Optional[pulumi.InvokeOptions] = None) -> AwaitableGetLifecyclePolicyDocumentResult:
    """
    Generates an ECR lifecycle policy document in JSON format. Can be used with resources such as the `ecr.LifecyclePolicy` resource.

    > For more information about building AWS ECR lifecycle policy documents, see the [AWS ECR Lifecycle Policy Document Guide](https://docs.aws.amazon.com/AmazonECR/latest/userguide/LifecyclePolicies.html).

    ## Example Usage

    ```python
    import pulumi
    import pulumi_aws as aws

    example = aws.ecr.get_lifecycle_policy_document(rules=[{
        "priority": 1,
        "description": "This is a test.",
        "selection": {
            "tag_status": "tagged",
            "tag_prefix_lists": ["prod"],
            "count_type": "imageCountMoreThan",
            "count_number": 100,
        },
    }])
    example_lifecycle_policy = aws.ecr.LifecyclePolicy("example",
        repository=example_aws_ecr_repository["name"],
        policy=example.json)
    ```
    """
    __args__ = dict()
    __args__['rules'] = rules
    opts = pulumi.InvokeOptions.merge(_utilities.get_invoke_opts_defaults(), opts)
    __ret__ = pulumi.runtime.invoke('aws:ecr/getLifecyclePolicyDocument:getLifecyclePolicyDocument', __args__, opts=opts, typ=GetLifecyclePolicyDocumentResult).value

    return AwaitableGetLifecyclePolicyDocumentResult(
        id=pulumi.get(__ret__, 'id'),
        json=pulumi.get(__ret__, 'json'),
        rules=pulumi.get(__ret__, 'rules'))
def get_lifecycle_policy_document_output(rules: Optional[pulumi.Input[Optional[Sequence[Union['GetLifecyclePolicyDocumentRuleArgs', 'GetLifecyclePolicyDocumentRuleArgsDict']]]]] = None,
                                         opts: Optional[Union[pulumi.InvokeOptions, pulumi.InvokeOutputOptions]] = None) -> pulumi.Output[GetLifecyclePolicyDocumentResult]:
    """
    Generates an ECR lifecycle policy document in JSON format. Can be used with resources such as the `ecr.LifecyclePolicy` resource.

    > For more information about building AWS ECR lifecycle policy documents, see the [AWS ECR Lifecycle Policy Document Guide](https://docs.aws.amazon.com/AmazonECR/latest/userguide/LifecyclePolicies.html).

    ## Example Usage

    ```python
    import pulumi
    import pulumi_aws as aws

    example = aws.ecr.get_lifecycle_policy_document(rules=[{
        "priority": 1,
        "description": "This is a test.",
        "selection": {
            "tag_status": "tagged",
            "tag_prefix_lists": ["prod"],
            "count_type": "imageCountMoreThan",
            "count_number": 100,
        },
    }])
    example_lifecycle_policy = aws.ecr.LifecyclePolicy("example",
        repository=example_aws_ecr_repository["name"],
        policy=example.json)
    ```
    """
    __args__ = dict()
    __args__['rules'] = rules
    opts = pulumi.InvokeOutputOptions.merge(_utilities.get_invoke_opts_defaults(), opts)
    __ret__ = pulumi.runtime.invoke_output('aws:ecr/getLifecyclePolicyDocument:getLifecyclePolicyDocument', __args__, opts=opts, typ=GetLifecyclePolicyDocumentResult)
    return __ret__.apply(lambda __response__: GetLifecyclePolicyDocumentResult(
        id=pulumi.get(__response__, 'id'),
        json=pulumi.get(__response__, 'json'),
        rules=pulumi.get(__response__, 'rules')))
