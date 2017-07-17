import * as lumi from "@lumi/lumi";
export declare class IdentityPool extends lumi.NamedResource implements IdentityPoolArgs {
    readonly allowUnauthenticatedIdentities?: boolean;
    readonly cognitoIdentityProviders?: {
        clientId?: string;
        providerName?: string;
        serverSideTokenCheck?: boolean;
    }[];
    readonly developerProviderName?: string;
    readonly identityPoolName: string;
    readonly openidConnectProviderArns?: string[];
    readonly samlProviderArns?: string[];
    readonly supportedLoginProviders?: {
        [key: string]: string;
    };
    constructor(name: string, args: IdentityPoolArgs);
}
export interface IdentityPoolArgs {
    readonly allowUnauthenticatedIdentities?: boolean;
    readonly cognitoIdentityProviders?: {
        clientId?: string;
        providerName?: string;
        serverSideTokenCheck?: boolean;
    }[];
    readonly developerProviderName?: string;
    readonly identityPoolName: string;
    readonly openidConnectProviderArns?: string[];
    readonly samlProviderArns?: string[];
    readonly supportedLoginProviders?: {
        [key: string]: string;
    };
}

