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
    'GetModelsModelSummaryResult',
]

@pulumi.output_type
class GetModelsModelSummaryResult(dict):
    def __init__(__self__, *,
                 customizations_supporteds: Sequence[builtins.str],
                 inference_types_supporteds: Sequence[builtins.str],
                 input_modalities: Sequence[builtins.str],
                 model_arn: builtins.str,
                 model_id: builtins.str,
                 model_name: builtins.str,
                 output_modalities: Sequence[builtins.str],
                 provider_name: builtins.str,
                 response_streaming_supported: builtins.bool):
        """
        :param Sequence[builtins.str] customizations_supporteds: Customizations that the model supports.
        :param Sequence[builtins.str] inference_types_supporteds: Inference types that the model supports.
        :param Sequence[builtins.str] input_modalities: Input modalities that the model supports.
        :param builtins.str model_arn: Model ARN.
        :param builtins.str model_id: Model identifier.
        :param builtins.str model_name: Model name.
        :param Sequence[builtins.str] output_modalities: Output modalities that the model supports.
        :param builtins.str provider_name: Model provider name.
        :param builtins.bool response_streaming_supported: Indicates whether the model supports streaming.
        """
        pulumi.set(__self__, "customizations_supporteds", customizations_supporteds)
        pulumi.set(__self__, "inference_types_supporteds", inference_types_supporteds)
        pulumi.set(__self__, "input_modalities", input_modalities)
        pulumi.set(__self__, "model_arn", model_arn)
        pulumi.set(__self__, "model_id", model_id)
        pulumi.set(__self__, "model_name", model_name)
        pulumi.set(__self__, "output_modalities", output_modalities)
        pulumi.set(__self__, "provider_name", provider_name)
        pulumi.set(__self__, "response_streaming_supported", response_streaming_supported)

    @property
    @pulumi.getter(name="customizationsSupporteds")
    def customizations_supporteds(self) -> Sequence[builtins.str]:
        """
        Customizations that the model supports.
        """
        return pulumi.get(self, "customizations_supporteds")

    @property
    @pulumi.getter(name="inferenceTypesSupporteds")
    def inference_types_supporteds(self) -> Sequence[builtins.str]:
        """
        Inference types that the model supports.
        """
        return pulumi.get(self, "inference_types_supporteds")

    @property
    @pulumi.getter(name="inputModalities")
    def input_modalities(self) -> Sequence[builtins.str]:
        """
        Input modalities that the model supports.
        """
        return pulumi.get(self, "input_modalities")

    @property
    @pulumi.getter(name="modelArn")
    def model_arn(self) -> builtins.str:
        """
        Model ARN.
        """
        return pulumi.get(self, "model_arn")

    @property
    @pulumi.getter(name="modelId")
    def model_id(self) -> builtins.str:
        """
        Model identifier.
        """
        return pulumi.get(self, "model_id")

    @property
    @pulumi.getter(name="modelName")
    def model_name(self) -> builtins.str:
        """
        Model name.
        """
        return pulumi.get(self, "model_name")

    @property
    @pulumi.getter(name="outputModalities")
    def output_modalities(self) -> Sequence[builtins.str]:
        """
        Output modalities that the model supports.
        """
        return pulumi.get(self, "output_modalities")

    @property
    @pulumi.getter(name="providerName")
    def provider_name(self) -> builtins.str:
        """
        Model provider name.
        """
        return pulumi.get(self, "provider_name")

    @property
    @pulumi.getter(name="responseStreamingSupported")
    def response_streaming_supported(self) -> builtins.bool:
        """
        Indicates whether the model supports streaming.
        """
        return pulumi.get(self, "response_streaming_supported")


