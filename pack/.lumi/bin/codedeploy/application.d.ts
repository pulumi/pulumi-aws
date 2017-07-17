import * as lumi from "@lumi/lumi";
export declare class Application extends lumi.NamedResource implements ApplicationArgs {
    readonly applicationName?: string;
    readonly uniqueId: string;
    constructor(name: string, args: ApplicationArgs);
}
export interface ApplicationArgs {
    readonly applicationName?: string;
    readonly uniqueId?: string;
}

