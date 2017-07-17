import * as lumi from "@lumi/lumi";
export declare class Stack extends lumi.NamedResource implements StackArgs {
    readonly capabilities?: string[];
    readonly disableRollback?: boolean;
    readonly iamRoleArn?: string;
    readonly stackName?: string;
    readonly notificationArns?: string[];
    readonly onFailure?: string;
    readonly outputs: {
        [key: string]: any;
    };
    readonly parameters: {
        [key: string]: any;
    };
    readonly policyBody: string;
    readonly policyUrl?: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly templateBody: string;
    readonly templateUrl?: string;
    readonly timeoutInMinutes?: number;
    constructor(name: string, args: StackArgs);
}
export interface StackArgs {
    readonly capabilities?: string[];
    readonly disableRollback?: boolean;
    readonly iamRoleArn?: string;
    readonly stackName?: string;
    readonly notificationArns?: string[];
    readonly onFailure?: string;
    readonly parameters?: {
        [key: string]: any;
    };
    readonly policyBody?: string;
    readonly policyUrl?: string;
    readonly tags?: {
        [key: string]: any;
    };
    readonly templateBody?: string;
    readonly templateUrl?: string;
    readonly timeoutInMinutes?: number;
}

