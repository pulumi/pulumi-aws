import * as lumi from "@lumi/lumi";
export declare class Application extends lumi.NamedResource implements ApplicationArgs {
    readonly appSource: {
        password?: string;
        revision?: string;
        sshKey?: string;
        type: string;
        url?: string;
        username?: string;
    }[];
    readonly autoBundleOnDeploy?: string;
    readonly awsFlowRubySettings?: string;
    readonly dataSourceArn?: string;
    readonly dataSourceDatabaseName?: string;
    readonly dataSourceType?: string;
    readonly description?: string;
    readonly documentRoot?: string;
    readonly domains?: string[];
    readonly enableSsl?: boolean;
    readonly environment?: {
        key: string;
        secure?: boolean;
        value: string;
    }[];
    readonly applicationId: string;
    readonly applicationName?: string;
    readonly railsEnv?: string;
    readonly shortName: string;
    readonly sslConfiguration?: {
        certificate: string;
        chain?: string;
        privateKey: string;
    }[];
    readonly stackId: string;
    readonly type: string;
    constructor(name: string, args: ApplicationArgs);
}
export interface ApplicationArgs {
    readonly appSource?: {
        password?: string;
        revision?: string;
        sshKey?: string;
        type: string;
        url?: string;
        username?: string;
    }[];
    readonly autoBundleOnDeploy?: string;
    readonly awsFlowRubySettings?: string;
    readonly dataSourceArn?: string;
    readonly dataSourceDatabaseName?: string;
    readonly dataSourceType?: string;
    readonly description?: string;
    readonly documentRoot?: string;
    readonly domains?: string[];
    readonly enableSsl?: boolean;
    readonly environment?: {
        key: string;
        secure?: boolean;
        value: string;
    }[];
    readonly applicationName?: string;
    readonly railsEnv?: string;
    readonly shortName?: string;
    readonly sslConfiguration?: {
        certificate: string;
        chain?: string;
        privateKey: string;
    }[];
    readonly stackId: string;
    readonly type: string;
}

