import * as lumi from "@lumi/lumi";
export declare class Object extends lumi.NamedResource implements ObjectArgs {
    readonly acl?: string;
    readonly bucket: string;
    readonly cacheControl?: string;
    readonly content?: string;
    readonly contentDisposition?: string;
    readonly contentEncoding?: string;
    readonly contentLanguage?: string;
    readonly contentType: string;
    readonly etag: string;
    readonly key: string;
    readonly kmsKeyId?: string;
    readonly serverSideEncryption: string;
    readonly source?: string;
    readonly storageClass: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly versionId: string;
    readonly websiteRedirect?: string;
    constructor(name: string, args: ObjectArgs);
}
export interface ObjectArgs {
    readonly acl?: string;
    readonly bucket: string;
    readonly cacheControl?: string;
    readonly content?: string;
    readonly contentDisposition?: string;
    readonly contentEncoding?: string;
    readonly contentLanguage?: string;
    readonly contentType?: string;
    readonly etag?: string;
    readonly key: string;
    readonly kmsKeyId?: string;
    readonly serverSideEncryption?: string;
    readonly source?: string;
    readonly storageClass?: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly websiteRedirect?: string;
}

