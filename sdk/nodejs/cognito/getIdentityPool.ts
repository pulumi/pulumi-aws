// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Data source for managing an AWS Cognito Identity Pool.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.cognito.getIdentityPool({
 *     identityPoolName: "test pool",
 * });
 * ```
 */
export function getIdentityPool(args: GetIdentityPoolArgs, opts?: pulumi.InvokeOptions): Promise<GetIdentityPoolResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:cognito/getIdentityPool:getIdentityPool", {
        "identityPoolName": args.identityPoolName,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getIdentityPool.
 */
export interface GetIdentityPoolArgs {
    /**
     * The Cognito Identity Pool name.
     */
    identityPoolName: string;
    /**
     * A map of tags to assigned to the Identity Pool.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getIdentityPool.
 */
export interface GetIdentityPoolResult {
    /**
     * Whether the classic / basic authentication flow is enabled.
     */
    readonly allowClassicFlow: boolean;
    /**
     * Whether the identity pool supports unauthenticated logins or not.
     */
    readonly allowUnauthenticatedIdentities: boolean;
    /**
     * ARN of the Pool.
     */
    readonly arn: string;
    /**
     * An array of Amazon Cognito Identity user pools and their client IDs.
     */
    readonly cognitoIdentityProviders: outputs.cognito.GetIdentityPoolCognitoIdentityProvider[];
    /**
     * The "domain" by which Cognito will refer to your users.
     */
    readonly developerProviderName: string;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    readonly identityPoolName: string;
    /**
     * Set of OpendID Connect provider ARNs.
     */
    readonly openidConnectProviderArns: string[];
    /**
     * An array of Amazon Resource Names (ARNs) of the SAML provider for your identity.
     */
    readonly samlProviderArns: string[];
    /**
     * Key-Value pairs mapping provider names to provider app IDs.
     */
    readonly supportedLoginProviders: {[key: string]: string};
    /**
     * A map of tags to assigned to the Identity Pool.
     */
    readonly tags: {[key: string]: string};
}
/**
 * Data source for managing an AWS Cognito Identity Pool.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.cognito.getIdentityPool({
 *     identityPoolName: "test pool",
 * });
 * ```
 */
export function getIdentityPoolOutput(args: GetIdentityPoolOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetIdentityPoolResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:cognito/getIdentityPool:getIdentityPool", {
        "identityPoolName": args.identityPoolName,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getIdentityPool.
 */
export interface GetIdentityPoolOutputArgs {
    /**
     * The Cognito Identity Pool name.
     */
    identityPoolName: pulumi.Input<string>;
    /**
     * A map of tags to assigned to the Identity Pool.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
