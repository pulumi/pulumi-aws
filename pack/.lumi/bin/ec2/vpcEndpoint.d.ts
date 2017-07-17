import * as lumi from "@lumi/lumi";
export declare class VpcEndpoint extends lumi.NamedResource implements VpcEndpointArgs {
    readonly cidrBlocks: string[];
    readonly policy: string;
    readonly prefixListId: string;
    readonly routeTableIds: string[];
    readonly serviceName: string;
    readonly vpcId: string;
    constructor(name: string, args: VpcEndpointArgs);
}
export interface VpcEndpointArgs {
    readonly policy?: string;
    readonly routeTableIds?: string[];
    readonly serviceName: string;
    readonly vpcId: string;
}

