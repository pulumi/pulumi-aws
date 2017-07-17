import * as lumi from "@lumi/lumi";
export declare class Stack extends lumi.NamedResource implements StackArgs {
    readonly agentVersion: string;
    readonly berkshelfVersion?: string;
    readonly color?: string;
    readonly configurationManagerName?: string;
    readonly configurationManagerVersion?: string;
    readonly customCookbooksSource: {
        password?: string;
        revision?: string;
        sshKey?: string;
        type: string;
        url: string;
        username?: string;
    }[];
    readonly customJson?: string;
    readonly defaultAvailabilityZone: string;
    readonly defaultInstanceProfileArn: string;
    readonly defaultOs?: string;
    readonly defaultRootDeviceType?: string;
    readonly defaultSshKeyName?: string;
    readonly defaultSubnetId: string;
    readonly hostnameTheme?: string;
    readonly stackId: string;
    readonly manageBerkshelf?: boolean;
    readonly stackName?: string;
    readonly region: string;
    readonly serviceRoleArn: string;
    readonly stackEndpoint: string;
    readonly useCustomCookbooks?: boolean;
    readonly useOpsworksSecurityGroups?: boolean;
    readonly vpcId: string;
    constructor(name: string, args: StackArgs);
}
export interface StackArgs {
    readonly agentVersion?: string;
    readonly berkshelfVersion?: string;
    readonly color?: string;
    readonly configurationManagerName?: string;
    readonly configurationManagerVersion?: string;
    readonly customCookbooksSource?: {
        password?: string;
        revision?: string;
        sshKey?: string;
        type: string;
        url: string;
        username?: string;
    }[];
    readonly customJson?: string;
    readonly defaultAvailabilityZone?: string;
    readonly defaultInstanceProfileArn: string;
    readonly defaultOs?: string;
    readonly defaultRootDeviceType?: string;
    readonly defaultSshKeyName?: string;
    readonly defaultSubnetId?: string;
    readonly hostnameTheme?: string;
    readonly manageBerkshelf?: boolean;
    readonly stackName?: string;
    readonly region: string;
    readonly serviceRoleArn: string;
    readonly useCustomCookbooks?: boolean;
    readonly useOpsworksSecurityGroups?: boolean;
    readonly vpcId?: string;
}

