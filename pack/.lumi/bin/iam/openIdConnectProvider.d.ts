import * as lumi from "@lumi/lumi";
export declare class OpenIdConnectProvider extends lumi.NamedResource implements OpenIdConnectProviderArgs {
    readonly arn: string;
    readonly clientIdList: string[];
    readonly thumbprintList: string[];
    readonly url: string;
    constructor(name: string, args: OpenIdConnectProviderArgs);
}
export interface OpenIdConnectProviderArgs {
    readonly clientIdList: string[];
    readonly thumbprintList: string[];
    readonly url: string;
}

