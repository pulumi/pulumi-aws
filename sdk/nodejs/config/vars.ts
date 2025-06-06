// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

import {Region} from "..";

declare var exports: any;
const __config = new pulumi.Config("aws");

/**
 * The access key for API operations. You can retrieve this from the 'Security & Credentials' section of the AWS console.
 */
export declare const accessKey: string | undefined;
Object.defineProperty(exports, "accessKey", {
    get() {
        return __config.get("accessKey");
    },
    enumerable: true,
});

export declare const allowedAccountIds: string[] | undefined;
Object.defineProperty(exports, "allowedAccountIds", {
    get() {
        return __config.getObject<string[]>("allowedAccountIds");
    },
    enumerable: true,
});

export declare const assumeRole: outputs.config.AssumeRole | undefined;
Object.defineProperty(exports, "assumeRole", {
    get() {
        return __config.getObject<outputs.config.AssumeRole>("assumeRole");
    },
    enumerable: true,
});

export declare const assumeRoleWithWebIdentity: outputs.config.AssumeRoleWithWebIdentity | undefined;
Object.defineProperty(exports, "assumeRoleWithWebIdentity", {
    get() {
        return __config.getObject<outputs.config.AssumeRoleWithWebIdentity>("assumeRoleWithWebIdentity");
    },
    enumerable: true,
});

/**
 * File containing custom root and intermediate certificates. Can also be configured using the `AWS_CA_BUNDLE` environment
 * variable. (Setting `caBundle` in the shared config file is not supported.)
 */
export declare const customCaBundle: string | undefined;
Object.defineProperty(exports, "customCaBundle", {
    get() {
        return __config.get("customCaBundle");
    },
    enumerable: true,
});

/**
 * Configuration block with settings to default resource tags across all resources.
 */
export declare const defaultTags: outputs.config.DefaultTags | undefined;
Object.defineProperty(exports, "defaultTags", {
    get() {
        return __config.getObject<outputs.config.DefaultTags>("defaultTags");
    },
    enumerable: true,
});

/**
 * Address of the EC2 metadata service endpoint to use. Can also be configured using the
 * `AWS_EC2_METADATA_SERVICE_ENDPOINT` environment variable.
 */
export declare const ec2MetadataServiceEndpoint: string | undefined;
Object.defineProperty(exports, "ec2MetadataServiceEndpoint", {
    get() {
        return __config.get("ec2MetadataServiceEndpoint");
    },
    enumerable: true,
});

/**
 * Protocol to use with EC2 metadata service endpoint.Valid values are `IPv4` and `IPv6`. Can also be configured using the
 * `AWS_EC2_METADATA_SERVICE_ENDPOINT_MODE` environment variable.
 */
export declare const ec2MetadataServiceEndpointMode: string | undefined;
Object.defineProperty(exports, "ec2MetadataServiceEndpointMode", {
    get() {
        return __config.get("ec2MetadataServiceEndpointMode");
    },
    enumerable: true,
});

export declare const endpoints: outputs.config.Endpoints[] | undefined;
Object.defineProperty(exports, "endpoints", {
    get() {
        return __config.getObject<outputs.config.Endpoints[]>("endpoints");
    },
    enumerable: true,
});

export declare const forbiddenAccountIds: string[] | undefined;
Object.defineProperty(exports, "forbiddenAccountIds", {
    get() {
        return __config.getObject<string[]>("forbiddenAccountIds");
    },
    enumerable: true,
});

/**
 * URL of a proxy to use for HTTP requests when accessing the AWS API. Can also be set using the `HTTP_PROXY` or
 * `httpProxy` environment variables.
 */
export declare const httpProxy: string | undefined;
Object.defineProperty(exports, "httpProxy", {
    get() {
        return __config.get("httpProxy");
    },
    enumerable: true,
});

/**
 * URL of a proxy to use for HTTPS requests when accessing the AWS API. Can also be set using the `HTTPS_PROXY` or
 * `httpsProxy` environment variables.
 */
export declare const httpsProxy: string | undefined;
Object.defineProperty(exports, "httpsProxy", {
    get() {
        return __config.get("httpsProxy");
    },
    enumerable: true,
});

/**
 * Configuration block with settings to ignore resource tags across all resources.
 */
export declare const ignoreTags: outputs.config.IgnoreTags | undefined;
Object.defineProperty(exports, "ignoreTags", {
    get() {
        return __config.getObject<outputs.config.IgnoreTags>("ignoreTags");
    },
    enumerable: true,
});

/**
 * Explicitly allow the provider to perform "insecure" SSL requests. If omitted, default value is `false`
 */
export declare const insecure: boolean | undefined;
Object.defineProperty(exports, "insecure", {
    get() {
        return __config.getObject<boolean>("insecure");
    },
    enumerable: true,
});

/**
 * The maximum number of times an AWS API request is being executed. If the API request still fails, an error is thrown.
 */
export declare const maxRetries: number | undefined;
Object.defineProperty(exports, "maxRetries", {
    get() {
        return __config.getObject<number>("maxRetries");
    },
    enumerable: true,
});

/**
 * Comma-separated list of hosts that should not use HTTP or HTTPS proxies. Can also be set using the `NO_PROXY` or
 * `noProxy` environment variables.
 */
export declare const noProxy: string | undefined;
Object.defineProperty(exports, "noProxy", {
    get() {
        return __config.get("noProxy");
    },
    enumerable: true,
});

/**
 * The profile for API operations. If not set, the default profile created with `aws configure` will be used.
 */
export declare const profile: string | undefined;
Object.defineProperty(exports, "profile", {
    get() {
        return __config.get("profile");
    },
    enumerable: true,
});

/**
 * The region where AWS operations will take place. Examples are us-east-1, us-west-2, etc.
 */
export declare const region: Region | undefined;
Object.defineProperty(exports, "region", {
    get() {
        return <Region>__config.get("region") ?? <any>utilities.getEnv("AWS_REGION", "AWS_DEFAULT_REGION");
    },
    enumerable: true,
});

/**
 * Specifies how retries are attempted. Valid values are `standard` and `adaptive`. Can also be configured using the
 * `AWS_RETRY_MODE` environment variable.
 */
export declare const retryMode: string | undefined;
Object.defineProperty(exports, "retryMode", {
    get() {
        return __config.get("retryMode");
    },
    enumerable: true,
});

/**
 * Specifies whether S3 API calls in the `us-east-1` region use the legacy global endpoint or a regional endpoint. Valid
 * values are `legacy` or `regional`. Can also be configured using the `AWS_S3_US_EAST_1_REGIONAL_ENDPOINT` environment
 * variable or the `s3UsEast1RegionalEndpoint` shared config file parameter
 */
export declare const s3UsEast1RegionalEndpoint: string | undefined;
Object.defineProperty(exports, "s3UsEast1RegionalEndpoint", {
    get() {
        return __config.get("s3UsEast1RegionalEndpoint");
    },
    enumerable: true,
});

/**
 * Set this to true to enable the request to use path-style addressing, i.e., https://s3.amazonaws.com/BUCKET/KEY. By
 * default, the S3 client will use virtual hosted bucket addressing when possible (https://BUCKET.s3.amazonaws.com/KEY).
 * Specific to the Amazon S3 service.
 */
export declare const s3UsePathStyle: boolean | undefined;
Object.defineProperty(exports, "s3UsePathStyle", {
    get() {
        return __config.getObject<boolean>("s3UsePathStyle");
    },
    enumerable: true,
});

/**
 * The secret key for API operations. You can retrieve this from the 'Security & Credentials' section of the AWS console.
 */
export declare const secretKey: string | undefined;
Object.defineProperty(exports, "secretKey", {
    get() {
        return __config.get("secretKey");
    },
    enumerable: true,
});

/**
 * List of paths to shared config files. If not set, defaults to [~/.aws/config].
 */
export declare const sharedConfigFiles: string[] | undefined;
Object.defineProperty(exports, "sharedConfigFiles", {
    get() {
        return __config.getObject<string[]>("sharedConfigFiles");
    },
    enumerable: true,
});

/**
 * List of paths to shared credentials files. If not set, defaults to [~/.aws/credentials].
 */
export declare const sharedCredentialsFiles: string[] | undefined;
Object.defineProperty(exports, "sharedCredentialsFiles", {
    get() {
        return __config.getObject<string[]>("sharedCredentialsFiles");
    },
    enumerable: true,
});

/**
 * Skip the credentials validation via STS API. Used for AWS API implementations that do not have STS
 * available/implemented.
 */
export declare const skipCredentialsValidation: boolean;
Object.defineProperty(exports, "skipCredentialsValidation", {
    get() {
        return __config.getObject<boolean>("skipCredentialsValidation") ?? false;
    },
    enumerable: true,
});

/**
 * Skip the AWS Metadata API check. Used for AWS API implementations that do not have a metadata api endpoint.
 */
export declare const skipMetadataApiCheck: boolean | undefined;
Object.defineProperty(exports, "skipMetadataApiCheck", {
    get() {
        return __config.getObject<boolean>("skipMetadataApiCheck");
    },
    enumerable: true,
});

/**
 * Skip static validation of region name. Used by users of alternative AWS-like APIs or users w/ access to regions that are
 * not public (yet).
 */
export declare const skipRegionValidation: boolean;
Object.defineProperty(exports, "skipRegionValidation", {
    get() {
        return __config.getObject<boolean>("skipRegionValidation") ?? true;
    },
    enumerable: true,
});

/**
 * Skip requesting the account ID. Used for AWS API implementations that do not have IAM/STS API and/or metadata API.
 */
export declare const skipRequestingAccountId: boolean | undefined;
Object.defineProperty(exports, "skipRequestingAccountId", {
    get() {
        return __config.getObject<boolean>("skipRequestingAccountId");
    },
    enumerable: true,
});

/**
 * The region where AWS STS operations will take place. Examples are us-east-1 and us-west-2.
 */
export declare const stsRegion: string | undefined;
Object.defineProperty(exports, "stsRegion", {
    get() {
        return __config.get("stsRegion");
    },
    enumerable: true,
});

/**
 * session token. A session token is only required if you are using temporary security credentials.
 */
export declare const token: string | undefined;
Object.defineProperty(exports, "token", {
    get() {
        return __config.get("token");
    },
    enumerable: true,
});

/**
 * The capacity of the AWS SDK's token bucket rate limiter.
 */
export declare const tokenBucketRateLimiterCapacity: number | undefined;
Object.defineProperty(exports, "tokenBucketRateLimiterCapacity", {
    get() {
        return __config.getObject<number>("tokenBucketRateLimiterCapacity");
    },
    enumerable: true,
});

/**
 * Resolve an endpoint with DualStack capability
 */
export declare const useDualstackEndpoint: boolean | undefined;
Object.defineProperty(exports, "useDualstackEndpoint", {
    get() {
        return __config.getObject<boolean>("useDualstackEndpoint");
    },
    enumerable: true,
});

/**
 * Resolve an endpoint with FIPS capability
 */
export declare const useFipsEndpoint: boolean | undefined;
Object.defineProperty(exports, "useFipsEndpoint", {
    get() {
        return __config.getObject<boolean>("useFipsEndpoint");
    },
    enumerable: true,
});

