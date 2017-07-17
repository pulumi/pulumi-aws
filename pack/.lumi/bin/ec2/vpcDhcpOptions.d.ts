import * as lumi from "@lumi/lumi";
export declare class VpcDhcpOptions extends lumi.NamedResource implements VpcDhcpOptionsArgs {
    readonly domainName?: string;
    readonly domainNameServers?: string[];
    readonly netbiosNameServers?: string[];
    readonly netbiosNodeType?: string;
    readonly ntpServers?: string[];
    readonly tags?: {
        [key: string]: any;
    };
    constructor(name: string, args: VpcDhcpOptionsArgs);
}
export interface VpcDhcpOptionsArgs {
    readonly domainName?: string;
    readonly domainNameServers?: string[];
    readonly netbiosNameServers?: string[];
    readonly netbiosNodeType?: string;
    readonly ntpServers?: string[];
    readonly tags?: {
        [key: string]: any;
    };
}

