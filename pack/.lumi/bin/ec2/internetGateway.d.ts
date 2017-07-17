import * as lumi from "@lumi/lumi";
export declare class InternetGateway extends lumi.NamedResource implements InternetGatewayArgs {
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcId?: string;
    constructor(name: string, args: InternetGatewayArgs);
}
export interface InternetGatewayArgs {
    readonly tags?: {
        [key: string]: any;
    };
    readonly vpcId?: string;
}

