import * as lumi from "@lumi/lumi";
export declare class AssessmentTemplate extends lumi.NamedResource implements AssessmentTemplateArgs {
    readonly arn: string;
    readonly duration: number;
    readonly assessmentTemplateName?: string;
    readonly rulesPackageArns: string[];
    readonly targetArn: string;
    constructor(name: string, args: AssessmentTemplateArgs);
}
export interface AssessmentTemplateArgs {
    readonly duration: number;
    readonly assessmentTemplateName?: string;
    readonly rulesPackageArns: string[];
    readonly targetArn: string;
}

