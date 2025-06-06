// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides access to an AppConfig Configuration Profile.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.appconfig.getConfigurationProfile({
 *     applicationId: "b5d5gpj",
 *     configurationProfileId: "qrbb1c1",
 * });
 * ```
 */
export function getConfigurationProfile(args: GetConfigurationProfileArgs, opts?: pulumi.InvokeOptions): Promise<GetConfigurationProfileResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:appconfig/getConfigurationProfile:getConfigurationProfile", {
        "applicationId": args.applicationId,
        "configurationProfileId": args.configurationProfileId,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getConfigurationProfile.
 */
export interface GetConfigurationProfileArgs {
    /**
     * ID of the AppConfig application to which this configuration profile belongs.
     */
    applicationId: string;
    /**
     * ID of the Configuration Profile.
     */
    configurationProfileId: string;
    /**
     * Map of tags for the resource.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getConfigurationProfile.
 */
export interface GetConfigurationProfileResult {
    readonly applicationId: string;
    /**
     * ARN of the Configuration Profile.
     */
    readonly arn: string;
    readonly configurationProfileId: string;
    /**
     * Description of the Configuration Profile.
     */
    readonly description: string;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    readonly kmsKeyIdentifier: string;
    /**
     * Location URI of the Configuration Profile.
     */
    readonly locationUri: string;
    /**
     * Name of the Configuration Profile.
     */
    readonly name: string;
    /**
     * ARN of an IAM role with permission to access the configuration at the specified location_uri.
     */
    readonly retrievalRoleArn: string;
    /**
     * Map of tags for the resource.
     */
    readonly tags: {[key: string]: string};
    /**
     * Type of validator. Valid values: JSON_SCHEMA and LAMBDA.
     */
    readonly type: string;
    /**
     * Nested list of methods for validating the configuration.
     */
    readonly validators: outputs.appconfig.GetConfigurationProfileValidator[];
}
/**
 * Provides access to an AppConfig Configuration Profile.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.appconfig.getConfigurationProfile({
 *     applicationId: "b5d5gpj",
 *     configurationProfileId: "qrbb1c1",
 * });
 * ```
 */
export function getConfigurationProfileOutput(args: GetConfigurationProfileOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetConfigurationProfileResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:appconfig/getConfigurationProfile:getConfigurationProfile", {
        "applicationId": args.applicationId,
        "configurationProfileId": args.configurationProfileId,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getConfigurationProfile.
 */
export interface GetConfigurationProfileOutputArgs {
    /**
     * ID of the AppConfig application to which this configuration profile belongs.
     */
    applicationId: pulumi.Input<string>;
    /**
     * ID of the Configuration Profile.
     */
    configurationProfileId: pulumi.Input<string>;
    /**
     * Map of tags for the resource.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
