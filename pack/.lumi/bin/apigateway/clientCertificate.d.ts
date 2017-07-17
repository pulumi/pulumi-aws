import * as lumi from "@lumi/lumi";
export declare class ClientCertificate extends lumi.NamedResource implements ClientCertificateArgs {
    readonly createdDate: string;
    readonly description?: string;
    readonly expirationDate: string;
    readonly pemEncodedCertificate: string;
    constructor(name: string, args: ClientCertificateArgs);
}
export interface ClientCertificateArgs {
    readonly description?: string;
}

