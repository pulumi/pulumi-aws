import * as lumi from "@lumi/lumi";
export declare class Association extends lumi.NamedResource implements AssociationArgs {
    readonly associationId: string;
    readonly instanceId?: string;
    readonly associationName?: string;
    readonly parameters: {
        [key: string]: any;
    };
    readonly targets: {
        key: string;
        values: string[];
    }[];
    constructor(name: string, args: AssociationArgs);
}
export interface AssociationArgs {
    readonly instanceId?: string;
    readonly associationName?: string;
    readonly parameters?: {
        [key: string]: any;
    };
    readonly targets?: {
        key: string;
        values: string[];
    }[];
}

