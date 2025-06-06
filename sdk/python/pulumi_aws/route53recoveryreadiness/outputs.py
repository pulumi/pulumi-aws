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

__all__ = [
    'ResourceSetResource',
    'ResourceSetResourceDnsTargetResource',
    'ResourceSetResourceDnsTargetResourceTargetResource',
    'ResourceSetResourceDnsTargetResourceTargetResourceNlbResource',
    'ResourceSetResourceDnsTargetResourceTargetResourceR53Resource',
]

@pulumi.output_type
class ResourceSetResource(dict):
    @staticmethod
    def __key_warning(key: str):
        suggest = None
        if key == "componentId":
            suggest = "component_id"
        elif key == "dnsTargetResource":
            suggest = "dns_target_resource"
        elif key == "readinessScopes":
            suggest = "readiness_scopes"
        elif key == "resourceArn":
            suggest = "resource_arn"

        if suggest:
            pulumi.log.warn(f"Key '{key}' not found in ResourceSetResource. Access the value via the '{suggest}' property getter instead.")

    def __getitem__(self, key: str) -> Any:
        ResourceSetResource.__key_warning(key)
        return super().__getitem__(key)

    def get(self, key: str, default = None) -> Any:
        ResourceSetResource.__key_warning(key)
        return super().get(key, default)

    def __init__(__self__, *,
                 component_id: Optional[builtins.str] = None,
                 dns_target_resource: Optional['outputs.ResourceSetResourceDnsTargetResource'] = None,
                 readiness_scopes: Optional[Sequence[builtins.str]] = None,
                 resource_arn: Optional[builtins.str] = None):
        """
        :param 'ResourceSetResourceDnsTargetResourceArgs' dns_target_resource: Component for DNS/Routing Control Readiness Checks.
        :param Sequence[builtins.str] readiness_scopes: Recovery group ARN or cell ARN that contains this resource set.
        :param builtins.str resource_arn: ARN of the resource.
        """
        if component_id is not None:
            pulumi.set(__self__, "component_id", component_id)
        if dns_target_resource is not None:
            pulumi.set(__self__, "dns_target_resource", dns_target_resource)
        if readiness_scopes is not None:
            pulumi.set(__self__, "readiness_scopes", readiness_scopes)
        if resource_arn is not None:
            pulumi.set(__self__, "resource_arn", resource_arn)

    @property
    @pulumi.getter(name="componentId")
    def component_id(self) -> Optional[builtins.str]:
        return pulumi.get(self, "component_id")

    @property
    @pulumi.getter(name="dnsTargetResource")
    def dns_target_resource(self) -> Optional['outputs.ResourceSetResourceDnsTargetResource']:
        """
        Component for DNS/Routing Control Readiness Checks.
        """
        return pulumi.get(self, "dns_target_resource")

    @property
    @pulumi.getter(name="readinessScopes")
    def readiness_scopes(self) -> Optional[Sequence[builtins.str]]:
        """
        Recovery group ARN or cell ARN that contains this resource set.
        """
        return pulumi.get(self, "readiness_scopes")

    @property
    @pulumi.getter(name="resourceArn")
    def resource_arn(self) -> Optional[builtins.str]:
        """
        ARN of the resource.
        """
        return pulumi.get(self, "resource_arn")


@pulumi.output_type
class ResourceSetResourceDnsTargetResource(dict):
    @staticmethod
    def __key_warning(key: str):
        suggest = None
        if key == "domainName":
            suggest = "domain_name"
        elif key == "hostedZoneArn":
            suggest = "hosted_zone_arn"
        elif key == "recordSetId":
            suggest = "record_set_id"
        elif key == "recordType":
            suggest = "record_type"
        elif key == "targetResource":
            suggest = "target_resource"

        if suggest:
            pulumi.log.warn(f"Key '{key}' not found in ResourceSetResourceDnsTargetResource. Access the value via the '{suggest}' property getter instead.")

    def __getitem__(self, key: str) -> Any:
        ResourceSetResourceDnsTargetResource.__key_warning(key)
        return super().__getitem__(key)

    def get(self, key: str, default = None) -> Any:
        ResourceSetResourceDnsTargetResource.__key_warning(key)
        return super().get(key, default)

    def __init__(__self__, *,
                 domain_name: builtins.str,
                 hosted_zone_arn: Optional[builtins.str] = None,
                 record_set_id: Optional[builtins.str] = None,
                 record_type: Optional[builtins.str] = None,
                 target_resource: Optional['outputs.ResourceSetResourceDnsTargetResourceTargetResource'] = None):
        """
        :param builtins.str domain_name: DNS Name that acts as the ingress point to a portion of application.
        :param builtins.str hosted_zone_arn: Hosted Zone ARN that contains the DNS record with the provided name of target resource.
        :param builtins.str record_set_id: Route53 record set id to uniquely identify a record given a `domain_name` and a `record_type`.
        :param builtins.str record_type: Type of DNS Record of target resource.
        :param 'ResourceSetResourceDnsTargetResourceTargetResourceArgs' target_resource: Target resource the R53 record specified with the above params points to.
        """
        pulumi.set(__self__, "domain_name", domain_name)
        if hosted_zone_arn is not None:
            pulumi.set(__self__, "hosted_zone_arn", hosted_zone_arn)
        if record_set_id is not None:
            pulumi.set(__self__, "record_set_id", record_set_id)
        if record_type is not None:
            pulumi.set(__self__, "record_type", record_type)
        if target_resource is not None:
            pulumi.set(__self__, "target_resource", target_resource)

    @property
    @pulumi.getter(name="domainName")
    def domain_name(self) -> builtins.str:
        """
        DNS Name that acts as the ingress point to a portion of application.
        """
        return pulumi.get(self, "domain_name")

    @property
    @pulumi.getter(name="hostedZoneArn")
    def hosted_zone_arn(self) -> Optional[builtins.str]:
        """
        Hosted Zone ARN that contains the DNS record with the provided name of target resource.
        """
        return pulumi.get(self, "hosted_zone_arn")

    @property
    @pulumi.getter(name="recordSetId")
    def record_set_id(self) -> Optional[builtins.str]:
        """
        Route53 record set id to uniquely identify a record given a `domain_name` and a `record_type`.
        """
        return pulumi.get(self, "record_set_id")

    @property
    @pulumi.getter(name="recordType")
    def record_type(self) -> Optional[builtins.str]:
        """
        Type of DNS Record of target resource.
        """
        return pulumi.get(self, "record_type")

    @property
    @pulumi.getter(name="targetResource")
    def target_resource(self) -> Optional['outputs.ResourceSetResourceDnsTargetResourceTargetResource']:
        """
        Target resource the R53 record specified with the above params points to.
        """
        return pulumi.get(self, "target_resource")


@pulumi.output_type
class ResourceSetResourceDnsTargetResourceTargetResource(dict):
    @staticmethod
    def __key_warning(key: str):
        suggest = None
        if key == "nlbResource":
            suggest = "nlb_resource"
        elif key == "r53Resource":
            suggest = "r53_resource"

        if suggest:
            pulumi.log.warn(f"Key '{key}' not found in ResourceSetResourceDnsTargetResourceTargetResource. Access the value via the '{suggest}' property getter instead.")

    def __getitem__(self, key: str) -> Any:
        ResourceSetResourceDnsTargetResourceTargetResource.__key_warning(key)
        return super().__getitem__(key)

    def get(self, key: str, default = None) -> Any:
        ResourceSetResourceDnsTargetResourceTargetResource.__key_warning(key)
        return super().get(key, default)

    def __init__(__self__, *,
                 nlb_resource: Optional['outputs.ResourceSetResourceDnsTargetResourceTargetResourceNlbResource'] = None,
                 r53_resource: Optional['outputs.ResourceSetResourceDnsTargetResourceTargetResourceR53Resource'] = None):
        """
        :param 'ResourceSetResourceDnsTargetResourceTargetResourceNlbResourceArgs' nlb_resource: NLB resource a DNS Target Resource points to. Required if `r53_resource` is not set.
        :param 'ResourceSetResourceDnsTargetResourceTargetResourceR53ResourceArgs' r53_resource: Route53 resource a DNS Target Resource record points to.
        """
        if nlb_resource is not None:
            pulumi.set(__self__, "nlb_resource", nlb_resource)
        if r53_resource is not None:
            pulumi.set(__self__, "r53_resource", r53_resource)

    @property
    @pulumi.getter(name="nlbResource")
    def nlb_resource(self) -> Optional['outputs.ResourceSetResourceDnsTargetResourceTargetResourceNlbResource']:
        """
        NLB resource a DNS Target Resource points to. Required if `r53_resource` is not set.
        """
        return pulumi.get(self, "nlb_resource")

    @property
    @pulumi.getter(name="r53Resource")
    def r53_resource(self) -> Optional['outputs.ResourceSetResourceDnsTargetResourceTargetResourceR53Resource']:
        """
        Route53 resource a DNS Target Resource record points to.
        """
        return pulumi.get(self, "r53_resource")


@pulumi.output_type
class ResourceSetResourceDnsTargetResourceTargetResourceNlbResource(dict):
    def __init__(__self__, *,
                 arn: Optional[builtins.str] = None):
        """
        :param builtins.str arn: NLB resource ARN.
        """
        if arn is not None:
            pulumi.set(__self__, "arn", arn)

    @property
    @pulumi.getter
    def arn(self) -> Optional[builtins.str]:
        """
        NLB resource ARN.
        """
        return pulumi.get(self, "arn")


@pulumi.output_type
class ResourceSetResourceDnsTargetResourceTargetResourceR53Resource(dict):
    @staticmethod
    def __key_warning(key: str):
        suggest = None
        if key == "domainName":
            suggest = "domain_name"
        elif key == "recordSetId":
            suggest = "record_set_id"

        if suggest:
            pulumi.log.warn(f"Key '{key}' not found in ResourceSetResourceDnsTargetResourceTargetResourceR53Resource. Access the value via the '{suggest}' property getter instead.")

    def __getitem__(self, key: str) -> Any:
        ResourceSetResourceDnsTargetResourceTargetResourceR53Resource.__key_warning(key)
        return super().__getitem__(key)

    def get(self, key: str, default = None) -> Any:
        ResourceSetResourceDnsTargetResourceTargetResourceR53Resource.__key_warning(key)
        return super().get(key, default)

    def __init__(__self__, *,
                 domain_name: Optional[builtins.str] = None,
                 record_set_id: Optional[builtins.str] = None):
        """
        :param builtins.str domain_name: Domain name that is targeted.
        :param builtins.str record_set_id: Resource record set ID that is targeted.
        """
        if domain_name is not None:
            pulumi.set(__self__, "domain_name", domain_name)
        if record_set_id is not None:
            pulumi.set(__self__, "record_set_id", record_set_id)

    @property
    @pulumi.getter(name="domainName")
    def domain_name(self) -> Optional[builtins.str]:
        """
        Domain name that is targeted.
        """
        return pulumi.get(self, "domain_name")

    @property
    @pulumi.getter(name="recordSetId")
    def record_set_id(self) -> Optional[builtins.str]:
        """
        Resource record set ID that is targeted.
        """
        return pulumi.get(self, "record_set_id")


