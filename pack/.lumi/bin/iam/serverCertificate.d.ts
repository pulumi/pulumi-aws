import * as lumi from "@lumi/lumi";
export declare class ServerCertificate extends lumi.NamedResource implements ServerCertificateArgs {
    readonly arn: string;
    readonly certificateBody: string;
    readonly certificateChain?: string;
    readonly serverCertificateName: string;
    readonly namePrefix?: string;
    readonly path?: string;
    readonly privateKey: string;
    constructor(name: string, args: ServerCertificateArgs);
}
export interface ServerCertificateArgs {
    readonly arn?: string;
    readonly certificateBody: string;
    readonly certificateChain?: string;
    readonly serverCertificateName?: string;
    readonly namePrefix?: string;
    readonly path?: string;
    readonly privateKey: string;
}

