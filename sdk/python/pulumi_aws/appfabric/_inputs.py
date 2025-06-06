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
    'AppAuthorizationConnectionAuthRequestArgs',
    'AppAuthorizationConnectionAuthRequestArgsDict',
    'AppAuthorizationConnectionTenantArgs',
    'AppAuthorizationConnectionTenantArgsDict',
    'AppAuthorizationConnectionTimeoutsArgs',
    'AppAuthorizationConnectionTimeoutsArgsDict',
    'AppAuthorizationCredentialArgs',
    'AppAuthorizationCredentialArgsDict',
    'AppAuthorizationCredentialApiKeyCredentialArgs',
    'AppAuthorizationCredentialApiKeyCredentialArgsDict',
    'AppAuthorizationCredentialOauth2CredentialArgs',
    'AppAuthorizationCredentialOauth2CredentialArgsDict',
    'AppAuthorizationTenantArgs',
    'AppAuthorizationTenantArgsDict',
    'AppAuthorizationTimeoutsArgs',
    'AppAuthorizationTimeoutsArgsDict',
    'IngestionDestinationDestinationConfigurationArgs',
    'IngestionDestinationDestinationConfigurationArgsDict',
    'IngestionDestinationDestinationConfigurationAuditLogArgs',
    'IngestionDestinationDestinationConfigurationAuditLogArgsDict',
    'IngestionDestinationDestinationConfigurationAuditLogDestinationArgs',
    'IngestionDestinationDestinationConfigurationAuditLogDestinationArgsDict',
    'IngestionDestinationDestinationConfigurationAuditLogDestinationFirehoseStreamArgs',
    'IngestionDestinationDestinationConfigurationAuditLogDestinationFirehoseStreamArgsDict',
    'IngestionDestinationDestinationConfigurationAuditLogDestinationS3BucketArgs',
    'IngestionDestinationDestinationConfigurationAuditLogDestinationS3BucketArgsDict',
    'IngestionDestinationProcessingConfigurationArgs',
    'IngestionDestinationProcessingConfigurationArgsDict',
    'IngestionDestinationProcessingConfigurationAuditLogArgs',
    'IngestionDestinationProcessingConfigurationAuditLogArgsDict',
    'IngestionDestinationTimeoutsArgs',
    'IngestionDestinationTimeoutsArgsDict',
]

MYPY = False

if not MYPY:
    class AppAuthorizationConnectionAuthRequestArgsDict(TypedDict):
        code: pulumi.Input[builtins.str]
        """
        The authorization code returned by the application after permission is granted in the application OAuth page (after clicking on the AuthURL)..
        """
        redirect_uri: pulumi.Input[builtins.str]
        """
        The redirect URL that is specified in the AuthURL and the application client.
        """
elif False:
    AppAuthorizationConnectionAuthRequestArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class AppAuthorizationConnectionAuthRequestArgs:
    def __init__(__self__, *,
                 code: pulumi.Input[builtins.str],
                 redirect_uri: pulumi.Input[builtins.str]):
        """
        :param pulumi.Input[builtins.str] code: The authorization code returned by the application after permission is granted in the application OAuth page (after clicking on the AuthURL)..
        :param pulumi.Input[builtins.str] redirect_uri: The redirect URL that is specified in the AuthURL and the application client.
        """
        pulumi.set(__self__, "code", code)
        pulumi.set(__self__, "redirect_uri", redirect_uri)

    @property
    @pulumi.getter
    def code(self) -> pulumi.Input[builtins.str]:
        """
        The authorization code returned by the application after permission is granted in the application OAuth page (after clicking on the AuthURL)..
        """
        return pulumi.get(self, "code")

    @code.setter
    def code(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "code", value)

    @property
    @pulumi.getter(name="redirectUri")
    def redirect_uri(self) -> pulumi.Input[builtins.str]:
        """
        The redirect URL that is specified in the AuthURL and the application client.
        """
        return pulumi.get(self, "redirect_uri")

    @redirect_uri.setter
    def redirect_uri(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "redirect_uri", value)


if not MYPY:
    class AppAuthorizationConnectionTenantArgsDict(TypedDict):
        tenant_display_name: pulumi.Input[builtins.str]
        tenant_identifier: pulumi.Input[builtins.str]
elif False:
    AppAuthorizationConnectionTenantArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class AppAuthorizationConnectionTenantArgs:
    def __init__(__self__, *,
                 tenant_display_name: pulumi.Input[builtins.str],
                 tenant_identifier: pulumi.Input[builtins.str]):
        pulumi.set(__self__, "tenant_display_name", tenant_display_name)
        pulumi.set(__self__, "tenant_identifier", tenant_identifier)

    @property
    @pulumi.getter(name="tenantDisplayName")
    def tenant_display_name(self) -> pulumi.Input[builtins.str]:
        return pulumi.get(self, "tenant_display_name")

    @tenant_display_name.setter
    def tenant_display_name(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "tenant_display_name", value)

    @property
    @pulumi.getter(name="tenantIdentifier")
    def tenant_identifier(self) -> pulumi.Input[builtins.str]:
        return pulumi.get(self, "tenant_identifier")

    @tenant_identifier.setter
    def tenant_identifier(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "tenant_identifier", value)


if not MYPY:
    class AppAuthorizationConnectionTimeoutsArgsDict(TypedDict):
        create: NotRequired[pulumi.Input[builtins.str]]
        """
        A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours).
        """
elif False:
    AppAuthorizationConnectionTimeoutsArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class AppAuthorizationConnectionTimeoutsArgs:
    def __init__(__self__, *,
                 create: Optional[pulumi.Input[builtins.str]] = None):
        """
        :param pulumi.Input[builtins.str] create: A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours).
        """
        if create is not None:
            pulumi.set(__self__, "create", create)

    @property
    @pulumi.getter
    def create(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours).
        """
        return pulumi.get(self, "create")

    @create.setter
    def create(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "create", value)


if not MYPY:
    class AppAuthorizationCredentialArgsDict(TypedDict):
        api_key_credentials: NotRequired[pulumi.Input[Sequence[pulumi.Input['AppAuthorizationCredentialApiKeyCredentialArgsDict']]]]
        """
        Contains API key credential information.
        """
        oauth2_credential: NotRequired[pulumi.Input['AppAuthorizationCredentialOauth2CredentialArgsDict']]
        """
        Contains OAuth2 client credential information.
        """
elif False:
    AppAuthorizationCredentialArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class AppAuthorizationCredentialArgs:
    def __init__(__self__, *,
                 api_key_credentials: Optional[pulumi.Input[Sequence[pulumi.Input['AppAuthorizationCredentialApiKeyCredentialArgs']]]] = None,
                 oauth2_credential: Optional[pulumi.Input['AppAuthorizationCredentialOauth2CredentialArgs']] = None):
        """
        :param pulumi.Input[Sequence[pulumi.Input['AppAuthorizationCredentialApiKeyCredentialArgs']]] api_key_credentials: Contains API key credential information.
        :param pulumi.Input['AppAuthorizationCredentialOauth2CredentialArgs'] oauth2_credential: Contains OAuth2 client credential information.
        """
        if api_key_credentials is not None:
            pulumi.set(__self__, "api_key_credentials", api_key_credentials)
        if oauth2_credential is not None:
            pulumi.set(__self__, "oauth2_credential", oauth2_credential)

    @property
    @pulumi.getter(name="apiKeyCredentials")
    def api_key_credentials(self) -> Optional[pulumi.Input[Sequence[pulumi.Input['AppAuthorizationCredentialApiKeyCredentialArgs']]]]:
        """
        Contains API key credential information.
        """
        return pulumi.get(self, "api_key_credentials")

    @api_key_credentials.setter
    def api_key_credentials(self, value: Optional[pulumi.Input[Sequence[pulumi.Input['AppAuthorizationCredentialApiKeyCredentialArgs']]]]):
        pulumi.set(self, "api_key_credentials", value)

    @property
    @pulumi.getter(name="oauth2Credential")
    def oauth2_credential(self) -> Optional[pulumi.Input['AppAuthorizationCredentialOauth2CredentialArgs']]:
        """
        Contains OAuth2 client credential information.
        """
        return pulumi.get(self, "oauth2_credential")

    @oauth2_credential.setter
    def oauth2_credential(self, value: Optional[pulumi.Input['AppAuthorizationCredentialOauth2CredentialArgs']]):
        pulumi.set(self, "oauth2_credential", value)


if not MYPY:
    class AppAuthorizationCredentialApiKeyCredentialArgsDict(TypedDict):
        api_key: pulumi.Input[builtins.str]
        """
        Contains API key credential information.
        """
elif False:
    AppAuthorizationCredentialApiKeyCredentialArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class AppAuthorizationCredentialApiKeyCredentialArgs:
    def __init__(__self__, *,
                 api_key: pulumi.Input[builtins.str]):
        """
        :param pulumi.Input[builtins.str] api_key: Contains API key credential information.
        """
        pulumi.set(__self__, "api_key", api_key)

    @property
    @pulumi.getter(name="apiKey")
    def api_key(self) -> pulumi.Input[builtins.str]:
        """
        Contains API key credential information.
        """
        return pulumi.get(self, "api_key")

    @api_key.setter
    def api_key(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "api_key", value)


if not MYPY:
    class AppAuthorizationCredentialOauth2CredentialArgsDict(TypedDict):
        client_id: pulumi.Input[builtins.str]
        """
        The client ID of the client application.
        """
        client_secret: pulumi.Input[builtins.str]
        """
        The client secret of the client application.
        """
elif False:
    AppAuthorizationCredentialOauth2CredentialArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class AppAuthorizationCredentialOauth2CredentialArgs:
    def __init__(__self__, *,
                 client_id: pulumi.Input[builtins.str],
                 client_secret: pulumi.Input[builtins.str]):
        """
        :param pulumi.Input[builtins.str] client_id: The client ID of the client application.
        :param pulumi.Input[builtins.str] client_secret: The client secret of the client application.
        """
        pulumi.set(__self__, "client_id", client_id)
        pulumi.set(__self__, "client_secret", client_secret)

    @property
    @pulumi.getter(name="clientId")
    def client_id(self) -> pulumi.Input[builtins.str]:
        """
        The client ID of the client application.
        """
        return pulumi.get(self, "client_id")

    @client_id.setter
    def client_id(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "client_id", value)

    @property
    @pulumi.getter(name="clientSecret")
    def client_secret(self) -> pulumi.Input[builtins.str]:
        """
        The client secret of the client application.
        """
        return pulumi.get(self, "client_secret")

    @client_secret.setter
    def client_secret(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "client_secret", value)


if not MYPY:
    class AppAuthorizationTenantArgsDict(TypedDict):
        tenant_display_name: pulumi.Input[builtins.str]
        """
        The display name of the tenant.
        """
        tenant_identifier: pulumi.Input[builtins.str]
        """
        The ID of the application tenant.
        """
elif False:
    AppAuthorizationTenantArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class AppAuthorizationTenantArgs:
    def __init__(__self__, *,
                 tenant_display_name: pulumi.Input[builtins.str],
                 tenant_identifier: pulumi.Input[builtins.str]):
        """
        :param pulumi.Input[builtins.str] tenant_display_name: The display name of the tenant.
        :param pulumi.Input[builtins.str] tenant_identifier: The ID of the application tenant.
        """
        pulumi.set(__self__, "tenant_display_name", tenant_display_name)
        pulumi.set(__self__, "tenant_identifier", tenant_identifier)

    @property
    @pulumi.getter(name="tenantDisplayName")
    def tenant_display_name(self) -> pulumi.Input[builtins.str]:
        """
        The display name of the tenant.
        """
        return pulumi.get(self, "tenant_display_name")

    @tenant_display_name.setter
    def tenant_display_name(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "tenant_display_name", value)

    @property
    @pulumi.getter(name="tenantIdentifier")
    def tenant_identifier(self) -> pulumi.Input[builtins.str]:
        """
        The ID of the application tenant.
        """
        return pulumi.get(self, "tenant_identifier")

    @tenant_identifier.setter
    def tenant_identifier(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "tenant_identifier", value)


if not MYPY:
    class AppAuthorizationTimeoutsArgsDict(TypedDict):
        create: NotRequired[pulumi.Input[builtins.str]]
        """
        A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours).
        """
        delete: NotRequired[pulumi.Input[builtins.str]]
        """
        A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours). Setting a timeout for a Delete operation is only applicable if changes are saved into state before the destroy operation occurs.
        """
        update: NotRequired[pulumi.Input[builtins.str]]
        """
        A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours).
        """
elif False:
    AppAuthorizationTimeoutsArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class AppAuthorizationTimeoutsArgs:
    def __init__(__self__, *,
                 create: Optional[pulumi.Input[builtins.str]] = None,
                 delete: Optional[pulumi.Input[builtins.str]] = None,
                 update: Optional[pulumi.Input[builtins.str]] = None):
        """
        :param pulumi.Input[builtins.str] create: A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours).
        :param pulumi.Input[builtins.str] delete: A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours). Setting a timeout for a Delete operation is only applicable if changes are saved into state before the destroy operation occurs.
        :param pulumi.Input[builtins.str] update: A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours).
        """
        if create is not None:
            pulumi.set(__self__, "create", create)
        if delete is not None:
            pulumi.set(__self__, "delete", delete)
        if update is not None:
            pulumi.set(__self__, "update", update)

    @property
    @pulumi.getter
    def create(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours).
        """
        return pulumi.get(self, "create")

    @create.setter
    def create(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "create", value)

    @property
    @pulumi.getter
    def delete(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours). Setting a timeout for a Delete operation is only applicable if changes are saved into state before the destroy operation occurs.
        """
        return pulumi.get(self, "delete")

    @delete.setter
    def delete(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "delete", value)

    @property
    @pulumi.getter
    def update(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours).
        """
        return pulumi.get(self, "update")

    @update.setter
    def update(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "update", value)


if not MYPY:
    class IngestionDestinationDestinationConfigurationArgsDict(TypedDict):
        audit_log: NotRequired[pulumi.Input['IngestionDestinationDestinationConfigurationAuditLogArgsDict']]
        """
        Contains information about an audit log processing configuration.
        """
elif False:
    IngestionDestinationDestinationConfigurationArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class IngestionDestinationDestinationConfigurationArgs:
    def __init__(__self__, *,
                 audit_log: Optional[pulumi.Input['IngestionDestinationDestinationConfigurationAuditLogArgs']] = None):
        """
        :param pulumi.Input['IngestionDestinationDestinationConfigurationAuditLogArgs'] audit_log: Contains information about an audit log processing configuration.
        """
        if audit_log is not None:
            pulumi.set(__self__, "audit_log", audit_log)

    @property
    @pulumi.getter(name="auditLog")
    def audit_log(self) -> Optional[pulumi.Input['IngestionDestinationDestinationConfigurationAuditLogArgs']]:
        """
        Contains information about an audit log processing configuration.
        """
        return pulumi.get(self, "audit_log")

    @audit_log.setter
    def audit_log(self, value: Optional[pulumi.Input['IngestionDestinationDestinationConfigurationAuditLogArgs']]):
        pulumi.set(self, "audit_log", value)


if not MYPY:
    class IngestionDestinationDestinationConfigurationAuditLogArgsDict(TypedDict):
        destination: NotRequired[pulumi.Input['IngestionDestinationDestinationConfigurationAuditLogDestinationArgsDict']]
        """
        Contains information about an audit log destination. Only one destination (Firehose Stream) or (S3 Bucket) can be specified.
        """
elif False:
    IngestionDestinationDestinationConfigurationAuditLogArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class IngestionDestinationDestinationConfigurationAuditLogArgs:
    def __init__(__self__, *,
                 destination: Optional[pulumi.Input['IngestionDestinationDestinationConfigurationAuditLogDestinationArgs']] = None):
        """
        :param pulumi.Input['IngestionDestinationDestinationConfigurationAuditLogDestinationArgs'] destination: Contains information about an audit log destination. Only one destination (Firehose Stream) or (S3 Bucket) can be specified.
        """
        if destination is not None:
            pulumi.set(__self__, "destination", destination)

    @property
    @pulumi.getter
    def destination(self) -> Optional[pulumi.Input['IngestionDestinationDestinationConfigurationAuditLogDestinationArgs']]:
        """
        Contains information about an audit log destination. Only one destination (Firehose Stream) or (S3 Bucket) can be specified.
        """
        return pulumi.get(self, "destination")

    @destination.setter
    def destination(self, value: Optional[pulumi.Input['IngestionDestinationDestinationConfigurationAuditLogDestinationArgs']]):
        pulumi.set(self, "destination", value)


if not MYPY:
    class IngestionDestinationDestinationConfigurationAuditLogDestinationArgsDict(TypedDict):
        firehose_stream: NotRequired[pulumi.Input['IngestionDestinationDestinationConfigurationAuditLogDestinationFirehoseStreamArgsDict']]
        """
        Contains information about an Amazon Data Firehose delivery stream.
        """
        s3_bucket: NotRequired[pulumi.Input['IngestionDestinationDestinationConfigurationAuditLogDestinationS3BucketArgsDict']]
        """
        Contains information about an Amazon S3 bucket.
        """
elif False:
    IngestionDestinationDestinationConfigurationAuditLogDestinationArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class IngestionDestinationDestinationConfigurationAuditLogDestinationArgs:
    def __init__(__self__, *,
                 firehose_stream: Optional[pulumi.Input['IngestionDestinationDestinationConfigurationAuditLogDestinationFirehoseStreamArgs']] = None,
                 s3_bucket: Optional[pulumi.Input['IngestionDestinationDestinationConfigurationAuditLogDestinationS3BucketArgs']] = None):
        """
        :param pulumi.Input['IngestionDestinationDestinationConfigurationAuditLogDestinationFirehoseStreamArgs'] firehose_stream: Contains information about an Amazon Data Firehose delivery stream.
        :param pulumi.Input['IngestionDestinationDestinationConfigurationAuditLogDestinationS3BucketArgs'] s3_bucket: Contains information about an Amazon S3 bucket.
        """
        if firehose_stream is not None:
            pulumi.set(__self__, "firehose_stream", firehose_stream)
        if s3_bucket is not None:
            pulumi.set(__self__, "s3_bucket", s3_bucket)

    @property
    @pulumi.getter(name="firehoseStream")
    def firehose_stream(self) -> Optional[pulumi.Input['IngestionDestinationDestinationConfigurationAuditLogDestinationFirehoseStreamArgs']]:
        """
        Contains information about an Amazon Data Firehose delivery stream.
        """
        return pulumi.get(self, "firehose_stream")

    @firehose_stream.setter
    def firehose_stream(self, value: Optional[pulumi.Input['IngestionDestinationDestinationConfigurationAuditLogDestinationFirehoseStreamArgs']]):
        pulumi.set(self, "firehose_stream", value)

    @property
    @pulumi.getter(name="s3Bucket")
    def s3_bucket(self) -> Optional[pulumi.Input['IngestionDestinationDestinationConfigurationAuditLogDestinationS3BucketArgs']]:
        """
        Contains information about an Amazon S3 bucket.
        """
        return pulumi.get(self, "s3_bucket")

    @s3_bucket.setter
    def s3_bucket(self, value: Optional[pulumi.Input['IngestionDestinationDestinationConfigurationAuditLogDestinationS3BucketArgs']]):
        pulumi.set(self, "s3_bucket", value)


if not MYPY:
    class IngestionDestinationDestinationConfigurationAuditLogDestinationFirehoseStreamArgsDict(TypedDict):
        stream_name: pulumi.Input[builtins.str]
elif False:
    IngestionDestinationDestinationConfigurationAuditLogDestinationFirehoseStreamArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class IngestionDestinationDestinationConfigurationAuditLogDestinationFirehoseStreamArgs:
    def __init__(__self__, *,
                 stream_name: pulumi.Input[builtins.str]):
        pulumi.set(__self__, "stream_name", stream_name)

    @property
    @pulumi.getter(name="streamName")
    def stream_name(self) -> pulumi.Input[builtins.str]:
        return pulumi.get(self, "stream_name")

    @stream_name.setter
    def stream_name(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "stream_name", value)


if not MYPY:
    class IngestionDestinationDestinationConfigurationAuditLogDestinationS3BucketArgsDict(TypedDict):
        bucket_name: pulumi.Input[builtins.str]
        prefix: NotRequired[pulumi.Input[builtins.str]]
        """
        The object key to use.
        """
elif False:
    IngestionDestinationDestinationConfigurationAuditLogDestinationS3BucketArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class IngestionDestinationDestinationConfigurationAuditLogDestinationS3BucketArgs:
    def __init__(__self__, *,
                 bucket_name: pulumi.Input[builtins.str],
                 prefix: Optional[pulumi.Input[builtins.str]] = None):
        """
        :param pulumi.Input[builtins.str] prefix: The object key to use.
        """
        pulumi.set(__self__, "bucket_name", bucket_name)
        if prefix is not None:
            pulumi.set(__self__, "prefix", prefix)

    @property
    @pulumi.getter(name="bucketName")
    def bucket_name(self) -> pulumi.Input[builtins.str]:
        return pulumi.get(self, "bucket_name")

    @bucket_name.setter
    def bucket_name(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "bucket_name", value)

    @property
    @pulumi.getter
    def prefix(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The object key to use.
        """
        return pulumi.get(self, "prefix")

    @prefix.setter
    def prefix(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "prefix", value)


if not MYPY:
    class IngestionDestinationProcessingConfigurationArgsDict(TypedDict):
        audit_log: NotRequired[pulumi.Input['IngestionDestinationProcessingConfigurationAuditLogArgsDict']]
        """
        Contains information about an audit log processing configuration.
        """
elif False:
    IngestionDestinationProcessingConfigurationArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class IngestionDestinationProcessingConfigurationArgs:
    def __init__(__self__, *,
                 audit_log: Optional[pulumi.Input['IngestionDestinationProcessingConfigurationAuditLogArgs']] = None):
        """
        :param pulumi.Input['IngestionDestinationProcessingConfigurationAuditLogArgs'] audit_log: Contains information about an audit log processing configuration.
        """
        if audit_log is not None:
            pulumi.set(__self__, "audit_log", audit_log)

    @property
    @pulumi.getter(name="auditLog")
    def audit_log(self) -> Optional[pulumi.Input['IngestionDestinationProcessingConfigurationAuditLogArgs']]:
        """
        Contains information about an audit log processing configuration.
        """
        return pulumi.get(self, "audit_log")

    @audit_log.setter
    def audit_log(self, value: Optional[pulumi.Input['IngestionDestinationProcessingConfigurationAuditLogArgs']]):
        pulumi.set(self, "audit_log", value)


if not MYPY:
    class IngestionDestinationProcessingConfigurationAuditLogArgsDict(TypedDict):
        format: pulumi.Input[builtins.str]
        """
        The format in which the audit logs need to be formatted. Valid values: `json`, `parquet`.
        """
        schema: pulumi.Input[builtins.str]
        """
        The event schema in which the audit logs need to be formatted. Valid values: `ocsf`, `raw`.
        """
elif False:
    IngestionDestinationProcessingConfigurationAuditLogArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class IngestionDestinationProcessingConfigurationAuditLogArgs:
    def __init__(__self__, *,
                 format: pulumi.Input[builtins.str],
                 schema: pulumi.Input[builtins.str]):
        """
        :param pulumi.Input[builtins.str] format: The format in which the audit logs need to be formatted. Valid values: `json`, `parquet`.
        :param pulumi.Input[builtins.str] schema: The event schema in which the audit logs need to be formatted. Valid values: `ocsf`, `raw`.
        """
        pulumi.set(__self__, "format", format)
        pulumi.set(__self__, "schema", schema)

    @property
    @pulumi.getter
    def format(self) -> pulumi.Input[builtins.str]:
        """
        The format in which the audit logs need to be formatted. Valid values: `json`, `parquet`.
        """
        return pulumi.get(self, "format")

    @format.setter
    def format(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "format", value)

    @property
    @pulumi.getter
    def schema(self) -> pulumi.Input[builtins.str]:
        """
        The event schema in which the audit logs need to be formatted. Valid values: `ocsf`, `raw`.
        """
        return pulumi.get(self, "schema")

    @schema.setter
    def schema(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "schema", value)


if not MYPY:
    class IngestionDestinationTimeoutsArgsDict(TypedDict):
        create: NotRequired[pulumi.Input[builtins.str]]
        """
        A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours).
        """
        delete: NotRequired[pulumi.Input[builtins.str]]
        """
        A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours). Setting a timeout for a Delete operation is only applicable if changes are saved into state before the destroy operation occurs.
        """
        update: NotRequired[pulumi.Input[builtins.str]]
        """
        A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours).
        """
elif False:
    IngestionDestinationTimeoutsArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class IngestionDestinationTimeoutsArgs:
    def __init__(__self__, *,
                 create: Optional[pulumi.Input[builtins.str]] = None,
                 delete: Optional[pulumi.Input[builtins.str]] = None,
                 update: Optional[pulumi.Input[builtins.str]] = None):
        """
        :param pulumi.Input[builtins.str] create: A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours).
        :param pulumi.Input[builtins.str] delete: A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours). Setting a timeout for a Delete operation is only applicable if changes are saved into state before the destroy operation occurs.
        :param pulumi.Input[builtins.str] update: A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours).
        """
        if create is not None:
            pulumi.set(__self__, "create", create)
        if delete is not None:
            pulumi.set(__self__, "delete", delete)
        if update is not None:
            pulumi.set(__self__, "update", update)

    @property
    @pulumi.getter
    def create(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours).
        """
        return pulumi.get(self, "create")

    @create.setter
    def create(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "create", value)

    @property
    @pulumi.getter
    def delete(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours). Setting a timeout for a Delete operation is only applicable if changes are saved into state before the destroy operation occurs.
        """
        return pulumi.get(self, "delete")

    @delete.setter
    def delete(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "delete", value)

    @property
    @pulumi.getter
    def update(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        A string that can be [parsed as a duration](https://pkg.go.dev/time#ParseDuration) consisting of numbers and unit suffixes, such as "30s" or "2h45m". Valid time units are "s" (seconds), "m" (minutes), "h" (hours).
        """
        return pulumi.get(self, "update")

    @update.setter
    def update(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "update", value)


