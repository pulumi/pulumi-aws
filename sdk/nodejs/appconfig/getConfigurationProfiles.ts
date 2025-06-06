// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides access to all Configuration Properties for an AppConfig Application. This will allow you to pass Configuration
 * Profile IDs to another resource.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.appconfig.getConfigurationProfiles({
 *     applicationId: "a1d3rpe",
 * });
 * const exampleGetConfigurationProfile = example.then(example => .reduce((__obj, [__key, __value]) => ({ ...__obj, [__key]: aws.appconfig.getConfigurationProfile({
 *     configurationProfileId: __value,
 *     applicationId: exampleAwsAppconfigApplication.id,
 * }) })));
 * ```
 */
export function getConfigurationProfiles(args: GetConfigurationProfilesArgs, opts?: pulumi.InvokeOptions): Promise<GetConfigurationProfilesResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:appconfig/getConfigurationProfiles:getConfigurationProfiles", {
        "applicationId": args.applicationId,
    }, opts);
}

/**
 * A collection of arguments for invoking getConfigurationProfiles.
 */
export interface GetConfigurationProfilesArgs {
    /**
     * ID of the AppConfig Application.
     */
    applicationId: string;
}

/**
 * A collection of values returned by getConfigurationProfiles.
 */
export interface GetConfigurationProfilesResult {
    readonly applicationId: string;
    /**
     * Set of Configuration Profile IDs associated with the AppConfig Application.
     */
    readonly configurationProfileIds: string[];
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
}
/**
 * Provides access to all Configuration Properties for an AppConfig Application. This will allow you to pass Configuration
 * Profile IDs to another resource.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.appconfig.getConfigurationProfiles({
 *     applicationId: "a1d3rpe",
 * });
 * const exampleGetConfigurationProfile = example.then(example => .reduce((__obj, [__key, __value]) => ({ ...__obj, [__key]: aws.appconfig.getConfigurationProfile({
 *     configurationProfileId: __value,
 *     applicationId: exampleAwsAppconfigApplication.id,
 * }) })));
 * ```
 */
export function getConfigurationProfilesOutput(args: GetConfigurationProfilesOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetConfigurationProfilesResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:appconfig/getConfigurationProfiles:getConfigurationProfiles", {
        "applicationId": args.applicationId,
    }, opts);
}

/**
 * A collection of arguments for invoking getConfigurationProfiles.
 */
export interface GetConfigurationProfilesOutputArgs {
    /**
     * ID of the AppConfig Application.
     */
    applicationId: pulumi.Input<string>;
}
