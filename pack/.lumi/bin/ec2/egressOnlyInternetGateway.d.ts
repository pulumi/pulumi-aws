import * as lumi from "@lumi/lumi";
export declare class EgressOnlyInternetGateway extends lumi.NamedResource implements EgressOnlyInternetGatewayArgs {
    readonly vpcId: string;
    constructor(name: string, args: EgressOnlyInternetGatewayArgs);
}
export interface EgressOnlyInternetGatewayArgs {
    readonly vpcId: string;
}

