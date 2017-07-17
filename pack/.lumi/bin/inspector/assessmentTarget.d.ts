import * as lumi from "@lumi/lumi";
export declare class AssessmentTarget extends lumi.NamedResource implements AssessmentTargetArgs {
    readonly arn: string;
    readonly assessmentTargetName?: string;
    readonly resourceGroupArn: string;
    constructor(name: string, args: AssessmentTargetArgs);
}
export interface AssessmentTargetArgs {
    readonly assessmentTargetName?: string;
    readonly resourceGroupArn: string;
}

