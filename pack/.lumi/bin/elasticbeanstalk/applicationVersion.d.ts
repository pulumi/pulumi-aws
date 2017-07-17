import * as lumi from "@lumi/lumi";
export declare class ApplicationVersion extends lumi.NamedResource implements ApplicationVersionArgs {
    readonly application: string;
    readonly bucket: string;
    readonly description?: string;
    readonly forceDelete?: boolean;
    readonly key: string;
    readonly applicationVersionName?: string;
    constructor(name: string, args: ApplicationVersionArgs);
}
export interface ApplicationVersionArgs {
    readonly application: string;
    readonly bucket: string;
    readonly description?: string;
    readonly forceDelete?: boolean;
    readonly key: string;
    readonly applicationVersionName?: string;
}

