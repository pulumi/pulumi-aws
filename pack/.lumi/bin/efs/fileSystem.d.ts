import * as lumi from "@lumi/lumi";
export declare class FileSystem extends lumi.NamedResource implements FileSystemArgs {
    readonly creationToken: string;
    readonly performanceMode: string;
    readonly referenceName: string;
    readonly tags?: {
        [key: string]: any;
    };
    constructor(name: string, args: FileSystemArgs);
}
export interface FileSystemArgs {
    readonly creationToken?: string;
    readonly performanceMode?: string;
    readonly referenceName?: string;
    readonly tags?: {
        [key: string]: any;
    };
}

