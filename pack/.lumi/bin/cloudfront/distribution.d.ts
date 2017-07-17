import * as lumi from "@lumi/lumi";
export declare class Distribution extends lumi.NamedResource implements DistributionArgs {
    readonly activeTrustedSigners: {
        [key: string]: any;
    };
    readonly aliases?: string[];
    readonly arn: string;
    readonly cacheBehavior?: {
        allowedMethods: string[];
        cachedMethods: string[];
        compress?: boolean;
        defaultTtl: number;
        forwardedValues: {
            cookies: {
                forward: string;
                whitelistedNames?: string[];
            }[];
            headers?: string[];
            queryString: boolean;
            queryStringCacheKeys?: string[];
        }[];
        lambdaFunctionAssociation?: {
            eventType: string;
            lambdaArn: string;
        }[];
        maxTtl: number;
        minTtl: number;
        pathPattern: string;
        smoothStreaming?: boolean;
        targetOriginId: string;
        trustedSigners?: string[];
        viewerProtocolPolicy: string;
    }[];
    readonly callerReference: string;
    readonly comment?: string;
    readonly customErrorResponse?: {
        errorCachingMinTtl?: number;
        errorCode: number;
        responseCode?: number;
        responsePagePath?: string;
    }[];
    readonly defaultCacheBehavior: {
        allowedMethods: string[];
        cachedMethods: string[];
        compress?: boolean;
        defaultTtl: number;
        forwardedValues: {
            cookies: {
                forward: string;
                whitelistedNames?: string[];
            }[];
            headers?: string[];
            queryString: boolean;
            queryStringCacheKeys?: string[];
        }[];
        lambdaFunctionAssociation?: {
            eventType: string;
            lambdaArn: string;
        }[];
        maxTtl: number;
        minTtl: number;
        smoothStreaming?: boolean;
        targetOriginId: string;
        trustedSigners?: string[];
        viewerProtocolPolicy: string;
    }[];
    readonly defaultRootObject?: string;
    readonly domainName: string;
    readonly enabled: boolean;
    readonly etag: string;
    readonly hostedZoneId: string;
    readonly httpVersion?: string;
    readonly inProgressValidationBatches: number;
    readonly isIpv6Enabled?: boolean;
    readonly lastModifiedTime: string;
    readonly loggingConfig?: {
        bucket: string;
        includeCookies?: boolean;
        prefix?: string;
    }[];
    readonly origin: {
        customHeader?: {
            name: string;
            value: string;
        }[];
        customOriginConfig?: {
            httpPort: number;
            httpsPort: number;
            originKeepaliveTimeout?: number;
            originProtocolPolicy: string;
            originReadTimeout?: number;
            originSslProtocols: string[];
        }[];
        domainName: string;
        originId: string;
        originPath?: string;
        s3OriginConfig?: {
            originAccessIdentity: string;
        }[];
    }[];
    readonly priceClass?: string;
    readonly restrictions: {
        geoRestriction: {
            locations?: string[];
            restrictionType: string;
        }[];
    }[];
    readonly retainOnDelete?: boolean;
    readonly status: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly viewerCertificate: {
        acmCertificateArn?: string;
        cloudfrontDefaultCertificate?: boolean;
        iamCertificateId?: string;
        minimumProtocolVersion?: string;
        sslSupportMethod?: string;
    }[];
    readonly webAclId?: string;
    constructor(name: string, args: DistributionArgs);
}
export interface DistributionArgs {
    readonly aliases?: string[];
    readonly cacheBehavior?: {
        allowedMethods: string[];
        cachedMethods: string[];
        compress?: boolean;
        defaultTtl: number;
        forwardedValues: {
            cookies: {
                forward: string;
                whitelistedNames?: string[];
            }[];
            headers?: string[];
            queryString: boolean;
            queryStringCacheKeys?: string[];
        }[];
        lambdaFunctionAssociation?: {
            eventType: string;
            lambdaArn: string;
        }[];
        maxTtl: number;
        minTtl: number;
        pathPattern: string;
        smoothStreaming?: boolean;
        targetOriginId: string;
        trustedSigners?: string[];
        viewerProtocolPolicy: string;
    }[];
    readonly comment?: string;
    readonly customErrorResponse?: {
        errorCachingMinTtl?: number;
        errorCode: number;
        responseCode?: number;
        responsePagePath?: string;
    }[];
    readonly defaultCacheBehavior: {
        allowedMethods: string[];
        cachedMethods: string[];
        compress?: boolean;
        defaultTtl: number;
        forwardedValues: {
            cookies: {
                forward: string;
                whitelistedNames?: string[];
            }[];
            headers?: string[];
            queryString: boolean;
            queryStringCacheKeys?: string[];
        }[];
        lambdaFunctionAssociation?: {
            eventType: string;
            lambdaArn: string;
        }[];
        maxTtl: number;
        minTtl: number;
        smoothStreaming?: boolean;
        targetOriginId: string;
        trustedSigners?: string[];
        viewerProtocolPolicy: string;
    }[];
    readonly defaultRootObject?: string;
    readonly enabled: boolean;
    readonly httpVersion?: string;
    readonly isIpv6Enabled?: boolean;
    readonly loggingConfig?: {
        bucket: string;
        includeCookies?: boolean;
        prefix?: string;
    }[];
    readonly origin: {
        customHeader?: {
            name: string;
            value: string;
        }[];
        customOriginConfig?: {
            httpPort: number;
            httpsPort: number;
            originKeepaliveTimeout?: number;
            originProtocolPolicy: string;
            originReadTimeout?: number;
            originSslProtocols: string[];
        }[];
        domainName: string;
        originId: string;
        originPath?: string;
        s3OriginConfig?: {
            originAccessIdentity: string;
        }[];
    }[];
    readonly priceClass?: string;
    readonly restrictions: {
        geoRestriction: {
            locations?: string[];
            restrictionType: string;
        }[];
    }[];
    readonly retainOnDelete?: boolean;
    readonly tags?: {
        [key: string]: any;
    };
    readonly viewerCertificate: {
        acmCertificateArn?: string;
        cloudfrontDefaultCertificate?: boolean;
        iamCertificateId?: string;
        minimumProtocolVersion?: string;
        sslSupportMethod?: string;
    }[];
    readonly webAclId?: string;
}

