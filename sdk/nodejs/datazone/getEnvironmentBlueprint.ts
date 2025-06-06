// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Data source for managing an AWS DataZone Environment Blueprint.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const exampleDomain = new aws.datazone.Domain("example", {
 *     name: "example_domain",
 *     domainExecutionRole: domainExecutionRole.arn,
 * });
 * const example = aws.datazone.getEnvironmentBlueprintOutput({
 *     domainId: exampleDomain.id,
 *     name: "DefaultDataLake",
 *     managed: true,
 * });
 * ```
 */
export function getEnvironmentBlueprint(args: GetEnvironmentBlueprintArgs, opts?: pulumi.InvokeOptions): Promise<GetEnvironmentBlueprintResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:datazone/getEnvironmentBlueprint:getEnvironmentBlueprint", {
        "domainId": args.domainId,
        "managed": args.managed,
        "name": args.name,
    }, opts);
}

/**
 * A collection of arguments for invoking getEnvironmentBlueprint.
 */
export interface GetEnvironmentBlueprintArgs {
    /**
     * ID of the domain.
     */
    domainId: string;
    /**
     * Whether the blueprint is managed by Amazon DataZone.
     */
    managed: boolean;
    /**
     * Name of the blueprint.
     */
    name: string;
}

/**
 * A collection of values returned by getEnvironmentBlueprint.
 */
export interface GetEnvironmentBlueprintResult {
    /**
     * Provider of the blueprint
     */
    readonly blueprintProvider: string;
    /**
     * Description of the blueprint
     */
    readonly description: string;
    readonly domainId: string;
    /**
     * ID of the environment blueprint
     */
    readonly id: string;
    readonly managed: boolean;
    readonly name: string;
}
/**
 * Data source for managing an AWS DataZone Environment Blueprint.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const exampleDomain = new aws.datazone.Domain("example", {
 *     name: "example_domain",
 *     domainExecutionRole: domainExecutionRole.arn,
 * });
 * const example = aws.datazone.getEnvironmentBlueprintOutput({
 *     domainId: exampleDomain.id,
 *     name: "DefaultDataLake",
 *     managed: true,
 * });
 * ```
 */
export function getEnvironmentBlueprintOutput(args: GetEnvironmentBlueprintOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetEnvironmentBlueprintResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:datazone/getEnvironmentBlueprint:getEnvironmentBlueprint", {
        "domainId": args.domainId,
        "managed": args.managed,
        "name": args.name,
    }, opts);
}

/**
 * A collection of arguments for invoking getEnvironmentBlueprint.
 */
export interface GetEnvironmentBlueprintOutputArgs {
    /**
     * ID of the domain.
     */
    domainId: pulumi.Input<string>;
    /**
     * Whether the blueprint is managed by Amazon DataZone.
     */
    managed: pulumi.Input<boolean>;
    /**
     * Name of the blueprint.
     */
    name: pulumi.Input<string>;
}
