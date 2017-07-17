import * as lumi from "@lumi/lumi";
export declare class TopicPolicy extends lumi.NamedResource implements TopicPolicyArgs {
    readonly arn: string;
    readonly policy: string;
    constructor(name: string, args: TopicPolicyArgs);
}
export interface TopicPolicyArgs {
    readonly arn: string;
    readonly policy: string;
}

