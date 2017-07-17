import * as lumi from "@lumi/lumi";
export declare class IpSet extends lumi.NamedResource implements IpSetArgs {
    readonly ipSetDescriptor?: {
        type: string;
        value: string;
    }[];
    readonly ipSetName?: string;
    constructor(name: string, args: IpSetArgs);
}
export interface IpSetArgs {
    readonly ipSetDescriptor?: {
        type: string;
        value: string;
    }[];
    readonly ipSetName?: string;
}

