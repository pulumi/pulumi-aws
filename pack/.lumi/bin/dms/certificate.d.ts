import * as lumi from "@lumi/lumi";
export declare class Certificate extends lumi.NamedResource implements CertificateArgs {
    readonly certificateArn: string;
    readonly certificateId: string;
    readonly certificatePem?: string;
    readonly certificateWallet?: string;
    constructor(name: string, args: CertificateArgs);
}
export interface CertificateArgs {
    readonly certificateId: string;
    readonly certificatePem?: string;
    readonly certificateWallet?: string;
}

