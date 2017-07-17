import * as lumi from "@lumi/lumi";
export declare class StateMachine extends lumi.NamedResource implements StateMachineArgs {
    readonly creationDate: string;
    readonly definition: string;
    readonly stateMachineName?: string;
    readonly roleArn: string;
    readonly status: string;
    constructor(name: string, args: StateMachineArgs);
}
export interface StateMachineArgs {
    readonly definition: string;
    readonly stateMachineName?: string;
    readonly roleArn: string;
}

