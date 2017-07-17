import * as lumi from "@lumi/lumi";
export declare class CookieStickinessPolicy extends lumi.NamedResource implements CookieStickinessPolicyArgs {
    readonly cookieExpirationPeriod?: number;
    readonly lbPort: number;
    readonly loadBalancer: string;
    readonly cookieStickinessPolicyName?: string;
    constructor(name: string, args: CookieStickinessPolicyArgs);
}
export interface CookieStickinessPolicyArgs {
    readonly cookieExpirationPeriod?: number;
    readonly lbPort: number;
    readonly loadBalancer: string;
    readonly cookieStickinessPolicyName?: string;
}

