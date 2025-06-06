// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Data source for managing an AWS Audit Manager Control.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.auditmanager.getControl({
 *     name: "1. Risk Management",
 *     type: "Standard",
 * });
 * ```
 *
 * ### With Framework Resource
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.auditmanager.getControl({
 *     name: "1. Risk Management",
 *     type: "Standard",
 * });
 * const example2 = aws.auditmanager.getControl({
 *     name: "2. Personnel",
 *     type: "Standard",
 * });
 * const exampleFramework = new aws.auditmanager.Framework("example", {
 *     name: "example",
 *     controlSets: [
 *         {
 *             name: "example",
 *             controls: [{
 *                 id: example.then(example => example.id),
 *             }],
 *         },
 *         {
 *             name: "example2",
 *             controls: [{
 *                 id: example2.then(example2 => example2.id),
 *             }],
 *         },
 *     ],
 * });
 * ```
 */
export function getControl(args: GetControlArgs, opts?: pulumi.InvokeOptions): Promise<GetControlResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:auditmanager/getControl:getControl", {
        "controlMappingSources": args.controlMappingSources,
        "name": args.name,
        "type": args.type,
    }, opts);
}

/**
 * A collection of arguments for invoking getControl.
 */
export interface GetControlArgs {
    controlMappingSources?: inputs.auditmanager.GetControlControlMappingSource[];
    /**
     * Name of the control.
     */
    name: string;
    /**
     * Type of control. Valid values are `Custom` and `Standard`.
     */
    type: string;
}

/**
 * A collection of values returned by getControl.
 */
export interface GetControlResult {
    readonly actionPlanInstructions: string;
    readonly actionPlanTitle: string;
    readonly arn: string;
    readonly controlMappingSources?: outputs.auditmanager.GetControlControlMappingSource[];
    readonly description: string;
    readonly id: string;
    readonly name: string;
    readonly tags: {[key: string]: string};
    readonly testingInformation: string;
    readonly type: string;
}
/**
 * Data source for managing an AWS Audit Manager Control.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.auditmanager.getControl({
 *     name: "1. Risk Management",
 *     type: "Standard",
 * });
 * ```
 *
 * ### With Framework Resource
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.auditmanager.getControl({
 *     name: "1. Risk Management",
 *     type: "Standard",
 * });
 * const example2 = aws.auditmanager.getControl({
 *     name: "2. Personnel",
 *     type: "Standard",
 * });
 * const exampleFramework = new aws.auditmanager.Framework("example", {
 *     name: "example",
 *     controlSets: [
 *         {
 *             name: "example",
 *             controls: [{
 *                 id: example.then(example => example.id),
 *             }],
 *         },
 *         {
 *             name: "example2",
 *             controls: [{
 *                 id: example2.then(example2 => example2.id),
 *             }],
 *         },
 *     ],
 * });
 * ```
 */
export function getControlOutput(args: GetControlOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetControlResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:auditmanager/getControl:getControl", {
        "controlMappingSources": args.controlMappingSources,
        "name": args.name,
        "type": args.type,
    }, opts);
}

/**
 * A collection of arguments for invoking getControl.
 */
export interface GetControlOutputArgs {
    controlMappingSources?: pulumi.Input<pulumi.Input<inputs.auditmanager.GetControlControlMappingSourceArgs>[]>;
    /**
     * Name of the control.
     */
    name: pulumi.Input<string>;
    /**
     * Type of control. Valid values are `Custom` and `Standard`.
     */
    type: pulumi.Input<string>;
}
