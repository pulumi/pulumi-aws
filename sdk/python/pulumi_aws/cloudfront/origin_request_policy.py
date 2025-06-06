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

__all__ = ['OriginRequestPolicyArgs', 'OriginRequestPolicy']

@pulumi.input_type
class OriginRequestPolicyArgs:
    def __init__(__self__, *,
                 cookies_config: pulumi.Input['OriginRequestPolicyCookiesConfigArgs'],
                 headers_config: pulumi.Input['OriginRequestPolicyHeadersConfigArgs'],
                 query_strings_config: pulumi.Input['OriginRequestPolicyQueryStringsConfigArgs'],
                 comment: Optional[pulumi.Input[builtins.str]] = None,
                 name: Optional[pulumi.Input[builtins.str]] = None):
        """
        The set of arguments for constructing a OriginRequestPolicy resource.
        :param pulumi.Input['OriginRequestPolicyCookiesConfigArgs'] cookies_config: Object that determines whether any cookies in viewer requests (and if so, which cookies) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Cookies Config for more information.
        :param pulumi.Input['OriginRequestPolicyHeadersConfigArgs'] headers_config: Object that determines whether any HTTP headers (and if so, which headers) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Headers Config for more information.
        :param pulumi.Input['OriginRequestPolicyQueryStringsConfigArgs'] query_strings_config: Object that determines whether any URL query strings in viewer requests (and if so, which query strings) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Query String Config for more information.
        :param pulumi.Input[builtins.str] comment: Comment to describe the origin request policy.
        :param pulumi.Input[builtins.str] name: Unique name to identify the origin request policy.
        """
        pulumi.set(__self__, "cookies_config", cookies_config)
        pulumi.set(__self__, "headers_config", headers_config)
        pulumi.set(__self__, "query_strings_config", query_strings_config)
        if comment is not None:
            pulumi.set(__self__, "comment", comment)
        if name is not None:
            pulumi.set(__self__, "name", name)

    @property
    @pulumi.getter(name="cookiesConfig")
    def cookies_config(self) -> pulumi.Input['OriginRequestPolicyCookiesConfigArgs']:
        """
        Object that determines whether any cookies in viewer requests (and if so, which cookies) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Cookies Config for more information.
        """
        return pulumi.get(self, "cookies_config")

    @cookies_config.setter
    def cookies_config(self, value: pulumi.Input['OriginRequestPolicyCookiesConfigArgs']):
        pulumi.set(self, "cookies_config", value)

    @property
    @pulumi.getter(name="headersConfig")
    def headers_config(self) -> pulumi.Input['OriginRequestPolicyHeadersConfigArgs']:
        """
        Object that determines whether any HTTP headers (and if so, which headers) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Headers Config for more information.
        """
        return pulumi.get(self, "headers_config")

    @headers_config.setter
    def headers_config(self, value: pulumi.Input['OriginRequestPolicyHeadersConfigArgs']):
        pulumi.set(self, "headers_config", value)

    @property
    @pulumi.getter(name="queryStringsConfig")
    def query_strings_config(self) -> pulumi.Input['OriginRequestPolicyQueryStringsConfigArgs']:
        """
        Object that determines whether any URL query strings in viewer requests (and if so, which query strings) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Query String Config for more information.
        """
        return pulumi.get(self, "query_strings_config")

    @query_strings_config.setter
    def query_strings_config(self, value: pulumi.Input['OriginRequestPolicyQueryStringsConfigArgs']):
        pulumi.set(self, "query_strings_config", value)

    @property
    @pulumi.getter
    def comment(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Comment to describe the origin request policy.
        """
        return pulumi.get(self, "comment")

    @comment.setter
    def comment(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "comment", value)

    @property
    @pulumi.getter
    def name(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Unique name to identify the origin request policy.
        """
        return pulumi.get(self, "name")

    @name.setter
    def name(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "name", value)


@pulumi.input_type
class _OriginRequestPolicyState:
    def __init__(__self__, *,
                 arn: Optional[pulumi.Input[builtins.str]] = None,
                 comment: Optional[pulumi.Input[builtins.str]] = None,
                 cookies_config: Optional[pulumi.Input['OriginRequestPolicyCookiesConfigArgs']] = None,
                 etag: Optional[pulumi.Input[builtins.str]] = None,
                 headers_config: Optional[pulumi.Input['OriginRequestPolicyHeadersConfigArgs']] = None,
                 name: Optional[pulumi.Input[builtins.str]] = None,
                 query_strings_config: Optional[pulumi.Input['OriginRequestPolicyQueryStringsConfigArgs']] = None):
        """
        Input properties used for looking up and filtering OriginRequestPolicy resources.
        :param pulumi.Input[builtins.str] arn: The origin request policy ARN.
        :param pulumi.Input[builtins.str] comment: Comment to describe the origin request policy.
        :param pulumi.Input['OriginRequestPolicyCookiesConfigArgs'] cookies_config: Object that determines whether any cookies in viewer requests (and if so, which cookies) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Cookies Config for more information.
        :param pulumi.Input[builtins.str] etag: The current version of the origin request policy.
        :param pulumi.Input['OriginRequestPolicyHeadersConfigArgs'] headers_config: Object that determines whether any HTTP headers (and if so, which headers) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Headers Config for more information.
        :param pulumi.Input[builtins.str] name: Unique name to identify the origin request policy.
        :param pulumi.Input['OriginRequestPolicyQueryStringsConfigArgs'] query_strings_config: Object that determines whether any URL query strings in viewer requests (and if so, which query strings) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Query String Config for more information.
        """
        if arn is not None:
            pulumi.set(__self__, "arn", arn)
        if comment is not None:
            pulumi.set(__self__, "comment", comment)
        if cookies_config is not None:
            pulumi.set(__self__, "cookies_config", cookies_config)
        if etag is not None:
            pulumi.set(__self__, "etag", etag)
        if headers_config is not None:
            pulumi.set(__self__, "headers_config", headers_config)
        if name is not None:
            pulumi.set(__self__, "name", name)
        if query_strings_config is not None:
            pulumi.set(__self__, "query_strings_config", query_strings_config)

    @property
    @pulumi.getter
    def arn(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The origin request policy ARN.
        """
        return pulumi.get(self, "arn")

    @arn.setter
    def arn(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "arn", value)

    @property
    @pulumi.getter
    def comment(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Comment to describe the origin request policy.
        """
        return pulumi.get(self, "comment")

    @comment.setter
    def comment(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "comment", value)

    @property
    @pulumi.getter(name="cookiesConfig")
    def cookies_config(self) -> Optional[pulumi.Input['OriginRequestPolicyCookiesConfigArgs']]:
        """
        Object that determines whether any cookies in viewer requests (and if so, which cookies) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Cookies Config for more information.
        """
        return pulumi.get(self, "cookies_config")

    @cookies_config.setter
    def cookies_config(self, value: Optional[pulumi.Input['OriginRequestPolicyCookiesConfigArgs']]):
        pulumi.set(self, "cookies_config", value)

    @property
    @pulumi.getter
    def etag(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The current version of the origin request policy.
        """
        return pulumi.get(self, "etag")

    @etag.setter
    def etag(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "etag", value)

    @property
    @pulumi.getter(name="headersConfig")
    def headers_config(self) -> Optional[pulumi.Input['OriginRequestPolicyHeadersConfigArgs']]:
        """
        Object that determines whether any HTTP headers (and if so, which headers) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Headers Config for more information.
        """
        return pulumi.get(self, "headers_config")

    @headers_config.setter
    def headers_config(self, value: Optional[pulumi.Input['OriginRequestPolicyHeadersConfigArgs']]):
        pulumi.set(self, "headers_config", value)

    @property
    @pulumi.getter
    def name(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Unique name to identify the origin request policy.
        """
        return pulumi.get(self, "name")

    @name.setter
    def name(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "name", value)

    @property
    @pulumi.getter(name="queryStringsConfig")
    def query_strings_config(self) -> Optional[pulumi.Input['OriginRequestPolicyQueryStringsConfigArgs']]:
        """
        Object that determines whether any URL query strings in viewer requests (and if so, which query strings) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Query String Config for more information.
        """
        return pulumi.get(self, "query_strings_config")

    @query_strings_config.setter
    def query_strings_config(self, value: Optional[pulumi.Input['OriginRequestPolicyQueryStringsConfigArgs']]):
        pulumi.set(self, "query_strings_config", value)


@pulumi.type_token("aws:cloudfront/originRequestPolicy:OriginRequestPolicy")
class OriginRequestPolicy(pulumi.CustomResource):
    @overload
    def __init__(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 comment: Optional[pulumi.Input[builtins.str]] = None,
                 cookies_config: Optional[pulumi.Input[Union['OriginRequestPolicyCookiesConfigArgs', 'OriginRequestPolicyCookiesConfigArgsDict']]] = None,
                 headers_config: Optional[pulumi.Input[Union['OriginRequestPolicyHeadersConfigArgs', 'OriginRequestPolicyHeadersConfigArgsDict']]] = None,
                 name: Optional[pulumi.Input[builtins.str]] = None,
                 query_strings_config: Optional[pulumi.Input[Union['OriginRequestPolicyQueryStringsConfigArgs', 'OriginRequestPolicyQueryStringsConfigArgsDict']]] = None,
                 __props__=None):
        """
        ## Example Usage

        The following example below creates a CloudFront origin request policy.

        ```python
        import pulumi
        import pulumi_aws as aws

        example = aws.cloudfront.OriginRequestPolicy("example",
            name="example-policy",
            comment="example comment",
            cookies_config={
                "cookie_behavior": "whitelist",
                "cookies": {
                    "items": ["example"],
                },
            },
            headers_config={
                "header_behavior": "whitelist",
                "headers": {
                    "items": ["example"],
                },
            },
            query_strings_config={
                "query_string_behavior": "whitelist",
                "query_strings": {
                    "items": ["example"],
                },
            })
        ```

        ## Import

        Using `pulumi import`, import Cloudfront Origin Request Policies using the `id`. For example:

        ```sh
        $ pulumi import aws:cloudfront/originRequestPolicy:OriginRequestPolicy policy ccca32ef-dce3-4df3-80df-1bd3000bc4d3
        ```

        :param str resource_name: The name of the resource.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[builtins.str] comment: Comment to describe the origin request policy.
        :param pulumi.Input[Union['OriginRequestPolicyCookiesConfigArgs', 'OriginRequestPolicyCookiesConfigArgsDict']] cookies_config: Object that determines whether any cookies in viewer requests (and if so, which cookies) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Cookies Config for more information.
        :param pulumi.Input[Union['OriginRequestPolicyHeadersConfigArgs', 'OriginRequestPolicyHeadersConfigArgsDict']] headers_config: Object that determines whether any HTTP headers (and if so, which headers) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Headers Config for more information.
        :param pulumi.Input[builtins.str] name: Unique name to identify the origin request policy.
        :param pulumi.Input[Union['OriginRequestPolicyQueryStringsConfigArgs', 'OriginRequestPolicyQueryStringsConfigArgsDict']] query_strings_config: Object that determines whether any URL query strings in viewer requests (and if so, which query strings) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Query String Config for more information.
        """
        ...
    @overload
    def __init__(__self__,
                 resource_name: str,
                 args: OriginRequestPolicyArgs,
                 opts: Optional[pulumi.ResourceOptions] = None):
        """
        ## Example Usage

        The following example below creates a CloudFront origin request policy.

        ```python
        import pulumi
        import pulumi_aws as aws

        example = aws.cloudfront.OriginRequestPolicy("example",
            name="example-policy",
            comment="example comment",
            cookies_config={
                "cookie_behavior": "whitelist",
                "cookies": {
                    "items": ["example"],
                },
            },
            headers_config={
                "header_behavior": "whitelist",
                "headers": {
                    "items": ["example"],
                },
            },
            query_strings_config={
                "query_string_behavior": "whitelist",
                "query_strings": {
                    "items": ["example"],
                },
            })
        ```

        ## Import

        Using `pulumi import`, import Cloudfront Origin Request Policies using the `id`. For example:

        ```sh
        $ pulumi import aws:cloudfront/originRequestPolicy:OriginRequestPolicy policy ccca32ef-dce3-4df3-80df-1bd3000bc4d3
        ```

        :param str resource_name: The name of the resource.
        :param OriginRequestPolicyArgs args: The arguments to use to populate this resource's properties.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        ...
    def __init__(__self__, resource_name: str, *args, **kwargs):
        resource_args, opts = _utilities.get_resource_args_opts(OriginRequestPolicyArgs, pulumi.ResourceOptions, *args, **kwargs)
        if resource_args is not None:
            __self__._internal_init(resource_name, opts, **resource_args.__dict__)
        else:
            __self__._internal_init(resource_name, *args, **kwargs)

    def _internal_init(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 comment: Optional[pulumi.Input[builtins.str]] = None,
                 cookies_config: Optional[pulumi.Input[Union['OriginRequestPolicyCookiesConfigArgs', 'OriginRequestPolicyCookiesConfigArgsDict']]] = None,
                 headers_config: Optional[pulumi.Input[Union['OriginRequestPolicyHeadersConfigArgs', 'OriginRequestPolicyHeadersConfigArgsDict']]] = None,
                 name: Optional[pulumi.Input[builtins.str]] = None,
                 query_strings_config: Optional[pulumi.Input[Union['OriginRequestPolicyQueryStringsConfigArgs', 'OriginRequestPolicyQueryStringsConfigArgsDict']]] = None,
                 __props__=None):
        opts = pulumi.ResourceOptions.merge(_utilities.get_resource_opts_defaults(), opts)
        if not isinstance(opts, pulumi.ResourceOptions):
            raise TypeError('Expected resource options to be a ResourceOptions instance')
        if opts.id is None:
            if __props__ is not None:
                raise TypeError('__props__ is only valid when passed in combination with a valid opts.id to get an existing resource')
            __props__ = OriginRequestPolicyArgs.__new__(OriginRequestPolicyArgs)

            __props__.__dict__["comment"] = comment
            if cookies_config is None and not opts.urn:
                raise TypeError("Missing required property 'cookies_config'")
            __props__.__dict__["cookies_config"] = cookies_config
            if headers_config is None and not opts.urn:
                raise TypeError("Missing required property 'headers_config'")
            __props__.__dict__["headers_config"] = headers_config
            __props__.__dict__["name"] = name
            if query_strings_config is None and not opts.urn:
                raise TypeError("Missing required property 'query_strings_config'")
            __props__.__dict__["query_strings_config"] = query_strings_config
            __props__.__dict__["arn"] = None
            __props__.__dict__["etag"] = None
        super(OriginRequestPolicy, __self__).__init__(
            'aws:cloudfront/originRequestPolicy:OriginRequestPolicy',
            resource_name,
            __props__,
            opts)

    @staticmethod
    def get(resource_name: str,
            id: pulumi.Input[str],
            opts: Optional[pulumi.ResourceOptions] = None,
            arn: Optional[pulumi.Input[builtins.str]] = None,
            comment: Optional[pulumi.Input[builtins.str]] = None,
            cookies_config: Optional[pulumi.Input[Union['OriginRequestPolicyCookiesConfigArgs', 'OriginRequestPolicyCookiesConfigArgsDict']]] = None,
            etag: Optional[pulumi.Input[builtins.str]] = None,
            headers_config: Optional[pulumi.Input[Union['OriginRequestPolicyHeadersConfigArgs', 'OriginRequestPolicyHeadersConfigArgsDict']]] = None,
            name: Optional[pulumi.Input[builtins.str]] = None,
            query_strings_config: Optional[pulumi.Input[Union['OriginRequestPolicyQueryStringsConfigArgs', 'OriginRequestPolicyQueryStringsConfigArgsDict']]] = None) -> 'OriginRequestPolicy':
        """
        Get an existing OriginRequestPolicy resource's state with the given name, id, and optional extra
        properties used to qualify the lookup.

        :param str resource_name: The unique name of the resulting resource.
        :param pulumi.Input[str] id: The unique provider ID of the resource to lookup.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[builtins.str] arn: The origin request policy ARN.
        :param pulumi.Input[builtins.str] comment: Comment to describe the origin request policy.
        :param pulumi.Input[Union['OriginRequestPolicyCookiesConfigArgs', 'OriginRequestPolicyCookiesConfigArgsDict']] cookies_config: Object that determines whether any cookies in viewer requests (and if so, which cookies) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Cookies Config for more information.
        :param pulumi.Input[builtins.str] etag: The current version of the origin request policy.
        :param pulumi.Input[Union['OriginRequestPolicyHeadersConfigArgs', 'OriginRequestPolicyHeadersConfigArgsDict']] headers_config: Object that determines whether any HTTP headers (and if so, which headers) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Headers Config for more information.
        :param pulumi.Input[builtins.str] name: Unique name to identify the origin request policy.
        :param pulumi.Input[Union['OriginRequestPolicyQueryStringsConfigArgs', 'OriginRequestPolicyQueryStringsConfigArgsDict']] query_strings_config: Object that determines whether any URL query strings in viewer requests (and if so, which query strings) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Query String Config for more information.
        """
        opts = pulumi.ResourceOptions.merge(opts, pulumi.ResourceOptions(id=id))

        __props__ = _OriginRequestPolicyState.__new__(_OriginRequestPolicyState)

        __props__.__dict__["arn"] = arn
        __props__.__dict__["comment"] = comment
        __props__.__dict__["cookies_config"] = cookies_config
        __props__.__dict__["etag"] = etag
        __props__.__dict__["headers_config"] = headers_config
        __props__.__dict__["name"] = name
        __props__.__dict__["query_strings_config"] = query_strings_config
        return OriginRequestPolicy(resource_name, opts=opts, __props__=__props__)

    @property
    @pulumi.getter
    def arn(self) -> pulumi.Output[builtins.str]:
        """
        The origin request policy ARN.
        """
        return pulumi.get(self, "arn")

    @property
    @pulumi.getter
    def comment(self) -> pulumi.Output[Optional[builtins.str]]:
        """
        Comment to describe the origin request policy.
        """
        return pulumi.get(self, "comment")

    @property
    @pulumi.getter(name="cookiesConfig")
    def cookies_config(self) -> pulumi.Output['outputs.OriginRequestPolicyCookiesConfig']:
        """
        Object that determines whether any cookies in viewer requests (and if so, which cookies) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Cookies Config for more information.
        """
        return pulumi.get(self, "cookies_config")

    @property
    @pulumi.getter
    def etag(self) -> pulumi.Output[builtins.str]:
        """
        The current version of the origin request policy.
        """
        return pulumi.get(self, "etag")

    @property
    @pulumi.getter(name="headersConfig")
    def headers_config(self) -> pulumi.Output['outputs.OriginRequestPolicyHeadersConfig']:
        """
        Object that determines whether any HTTP headers (and if so, which headers) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Headers Config for more information.
        """
        return pulumi.get(self, "headers_config")

    @property
    @pulumi.getter
    def name(self) -> pulumi.Output[builtins.str]:
        """
        Unique name to identify the origin request policy.
        """
        return pulumi.get(self, "name")

    @property
    @pulumi.getter(name="queryStringsConfig")
    def query_strings_config(self) -> pulumi.Output['outputs.OriginRequestPolicyQueryStringsConfig']:
        """
        Object that determines whether any URL query strings in viewer requests (and if so, which query strings) are included in the origin request key and automatically included in requests that CloudFront sends to the origin. See Query String Config for more information.
        """
        return pulumi.get(self, "query_strings_config")

