import * as lumi from "@lumi/lumi";
export declare class Activity extends lumi.NamedResource implements ActivityArgs {
    readonly creationDate: string;
    readonly activityName?: string;
    constructor(name: string, args: ActivityArgs);
}
export interface ActivityArgs {
    readonly activityName?: string;
}

