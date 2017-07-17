import * as lumi from "@lumi/lumi";
export declare class SamlProvider extends lumi.NamedResource implements SamlProviderArgs {
    readonly arn: string;
    readonly samlProviderName?: string;
    readonly samlMetadataDocument: string;
    readonly validUntil: string;
    constructor(name: string, args: SamlProviderArgs);
}
export interface SamlProviderArgs {
    readonly samlProviderName?: string;
    readonly samlMetadataDocument: string;
}

