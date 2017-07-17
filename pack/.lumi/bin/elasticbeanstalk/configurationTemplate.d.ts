import * as lumi from "@lumi/lumi";
export declare class ConfigurationTemplate extends lumi.NamedResource implements ConfigurationTemplateArgs {
    readonly application: string;
    readonly description?: string;
    readonly environmentId?: string;
    readonly configurationTemplateName?: string;
    readonly setting: {
        name: string;
        namespace: string;
        resource?: string;
        value: string;
    }[];
    readonly solutionStackName?: string;
    constructor(name: string, args: ConfigurationTemplateArgs);
}
export interface ConfigurationTemplateArgs {
    readonly application: string;
    readonly description?: string;
    readonly environmentId?: string;
    readonly configurationTemplateName?: string;
    readonly setting?: {
        name: string;
        namespace: string;
        resource?: string;
        value: string;
    }[];
    readonly solutionStackName?: string;
}

