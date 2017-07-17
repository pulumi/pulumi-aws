import * as lumi from "@lumi/lumi";
export declare class Bucket extends lumi.NamedResource implements BucketArgs {
    readonly accelerationStatus: string;
    readonly acl?: string;
    readonly arn: string;
    readonly bucket: string;
    readonly bucketDomainName: string;
    readonly bucketPrefix?: string;
    readonly corsRule?: {
        allowedHeaders?: string[];
        allowedMethods: string[];
        allowedOrigins: string[];
        exposeHeaders?: string[];
        maxAgeSeconds?: number;
    }[];
    readonly forceDestroy?: boolean;
    readonly hostedZoneId: string;
    readonly lifecycleRule?: {
        abortIncompleteMultipartUploadDays?: number;
        enabled: boolean;
        expiration?: {
            date?: string;
            days?: number;
            expiredObjectDeleteMarker?: boolean;
        }[];
        id: string;
        noncurrentVersionExpiration?: {
            days?: number;
        }[];
        noncurrentVersionTransition?: {
            days?: number;
            storageClass: string;
        }[];
        prefix?: string;
        tags?: {
            [key: string]: any;
        };
        transition?: {
            date?: string;
            days?: number;
            storageClass: string;
        }[];
    }[];
    readonly logging?: {
        targetBucket: string;
        targetPrefix?: string;
    }[];
    readonly policy?: string;
    readonly region: string;
    readonly replicationConfiguration?: {
        role: string;
        rules: {
            destination: {
                bucket: string;
                storageClass?: string;
            }[];
            id?: string;
            prefix: string;
            status: string;
        }[];
    }[];
    readonly requestPayer: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly versioning: {
        enabled?: boolean;
        mfaDelete?: boolean;
    }[];
    readonly website?: {
        errorDocument?: string;
        indexDocument?: string;
        redirectAllRequestsTo?: string;
        routingRules?: string;
    }[];
    readonly websiteDomain: string;
    readonly websiteEndpoint: string;
    constructor(name: string, args: BucketArgs);
}
export interface BucketArgs {
    readonly accelerationStatus?: string;
    readonly acl?: string;
    readonly arn?: string;
    readonly bucket?: string;
    readonly bucketPrefix?: string;
    readonly corsRule?: {
        allowedHeaders?: string[];
        allowedMethods: string[];
        allowedOrigins: string[];
        exposeHeaders?: string[];
        maxAgeSeconds?: number;
    }[];
    readonly forceDestroy?: boolean;
    readonly hostedZoneId?: string;
    readonly lifecycleRule?: {
        abortIncompleteMultipartUploadDays?: number;
        enabled: boolean;
        expiration?: {
            date?: string;
            days?: number;
            expiredObjectDeleteMarker?: boolean;
        }[];
        id: string;
        noncurrentVersionExpiration?: {
            days?: number;
        }[];
        noncurrentVersionTransition?: {
            days?: number;
            storageClass: string;
        }[];
        prefix?: string;
        tags?: {
            [key: string]: any;
        };
        transition?: {
            date?: string;
            days?: number;
            storageClass: string;
        }[];
    }[];
    readonly logging?: {
        targetBucket: string;
        targetPrefix?: string;
    }[];
    readonly policy?: string;
    readonly region?: string;
    readonly replicationConfiguration?: {
        role: string;
        rules: {
            destination: {
                bucket: string;
                storageClass?: string;
            }[];
            id?: string;
            prefix: string;
            status: string;
        }[];
    }[];
    readonly requestPayer?: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly versioning?: {
        enabled?: boolean;
        mfaDelete?: boolean;
    }[];
    readonly website?: {
        errorDocument?: string;
        indexDocument?: string;
        redirectAllRequestsTo?: string;
        routingRules?: string;
    }[];
    readonly websiteDomain?: string;
    readonly websiteEndpoint?: string;
}

