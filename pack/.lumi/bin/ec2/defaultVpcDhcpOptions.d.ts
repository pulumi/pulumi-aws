import * as lumi from "@lumi/lumi";
export declare class DefaultVpcDhcpOptions extends lumi.NamedResource implements DefaultVpcDhcpOptionsArgs {
    readonly domainName: string;
    readonly domainNameServers: string;
    readonly netbiosNameServers?: string[];
    readonly netbiosNodeType?: string;
    readonly ntpServers: string;
    readonly tags?: {
        [key: string]: any;
    };
    constructor(name: string, args: DefaultVpcDhcpOptionsArgs);
}
export interface DefaultVpcDhcpOptionsArgs {
    readonly netbiosNameServers?: string[];
    readonly netbiosNodeType?: string;
    readonly tags?: {
        [key: string]: any;
    };
}

