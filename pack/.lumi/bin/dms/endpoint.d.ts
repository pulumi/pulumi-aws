import * as lumi from "@lumi/lumi";
export declare class Endpoint extends lumi.NamedResource implements EndpointArgs {
    readonly certificateArn: string;
    readonly databaseName?: string;
    readonly endpointArn: string;
    readonly endpointId: string;
    readonly endpointType: string;
    readonly engineName: string;
    readonly extraConnectionAttributes: string;
    readonly kmsKeyArn: string;
    readonly password?: string;
    readonly port?: number;
    readonly serverName?: string;
    readonly serviceAccessRole?: string;
    readonly sslMode: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly username?: string;
    constructor(name: string, args: EndpointArgs);
}
export interface EndpointArgs {
    readonly certificateArn?: string;
    readonly databaseName?: string;
    readonly endpointId: string;
    readonly endpointType: string;
    readonly engineName: string;
    readonly extraConnectionAttributes?: string;
    readonly kmsKeyArn?: string;
    readonly password?: string;
    readonly port?: number;
    readonly serverName?: string;
    readonly serviceAccessRole?: string;
    readonly sslMode?: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly username?: string;
}

