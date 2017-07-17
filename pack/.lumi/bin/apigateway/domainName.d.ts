import * as lumi from "@lumi/lumi";
export declare class DomainName extends lumi.NamedResource implements DomainNameArgs {
    readonly certificateArn?: string;
    readonly certificateBody?: string;
    readonly certificateChain?: string;
    readonly certificateName?: string;
    readonly certificatePrivateKey?: string;
    readonly certificateUploadDate: string;
    readonly cloudfrontDomainName: string;
    readonly cloudfrontZoneId: string;
    readonly domainName: string;
    constructor(name: string, args: DomainNameArgs);
}
export interface DomainNameArgs {
    readonly certificateArn?: string;
    readonly certificateBody?: string;
    readonly certificateChain?: string;
    readonly certificateName?: string;
    readonly certificatePrivateKey?: string;
    readonly domainName: string;
}

