import * as lumi from "@lumi/lumi";
export declare class Application extends lumi.NamedResource implements ApplicationArgs {
    readonly description?: string;
    readonly applicationName?: string;
    constructor(name: string, args: ApplicationArgs);
}
export interface ApplicationArgs {
    readonly description?: string;
    readonly applicationName?: string;
}

