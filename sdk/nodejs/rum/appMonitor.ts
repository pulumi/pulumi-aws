// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides a CloudWatch RUM App Monitor resource.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.rum.AppMonitor("example", {
 *     name: "example",
 *     domain: "localhost",
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Cloudwatch RUM App Monitor using the `name`. For example:
 *
 * ```sh
 * $ pulumi import aws:rum/appMonitor:AppMonitor example example
 * ```
 */
export class AppMonitor extends pulumi.CustomResource {
    /**
     * Get an existing AppMonitor resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: AppMonitorState, opts?: pulumi.CustomResourceOptions): AppMonitor {
        return new AppMonitor(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:rum/appMonitor:AppMonitor';

    /**
     * Returns true if the given object is an instance of AppMonitor.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is AppMonitor {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === AppMonitor.__pulumiType;
    }

    /**
     * configuration data for the app monitor. See appMonitorConfiguration below.
     */
    public readonly appMonitorConfiguration!: pulumi.Output<outputs.rum.AppMonitorAppMonitorConfiguration>;
    /**
     * The unique ID of the app monitor. Useful for JS templates.
     */
    public /*out*/ readonly appMonitorId!: pulumi.Output<string>;
    /**
     * The Amazon Resource Name (ARN) specifying the app monitor.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * Specifies whether this app monitor allows the web client to define and send custom events. If you omit this parameter, custom events are `DISABLED`. See customEvents below.
     */
    public readonly customEvents!: pulumi.Output<outputs.rum.AppMonitorCustomEvents>;
    /**
     * Data collected by RUM is kept by RUM for 30 days and then deleted. This parameter specifies whether RUM sends a copy of this telemetry data to Amazon CloudWatch Logs in your account. This enables you to keep the telemetry data for more than 30 days, but it does incur Amazon CloudWatch Logs charges. Default value is `false`.
     */
    public readonly cwLogEnabled!: pulumi.Output<boolean | undefined>;
    /**
     * The name of the log group where the copies are stored.
     */
    public /*out*/ readonly cwLogGroup!: pulumi.Output<string>;
    public readonly domain!: pulumi.Output<string | undefined>;
    public readonly domainLists!: pulumi.Output<string[] | undefined>;
    /**
     * The name of the log stream.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;

    /**
     * Create a AppMonitor resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args?: AppMonitorArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: AppMonitorArgs | AppMonitorState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as AppMonitorState | undefined;
            resourceInputs["appMonitorConfiguration"] = state ? state.appMonitorConfiguration : undefined;
            resourceInputs["appMonitorId"] = state ? state.appMonitorId : undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["customEvents"] = state ? state.customEvents : undefined;
            resourceInputs["cwLogEnabled"] = state ? state.cwLogEnabled : undefined;
            resourceInputs["cwLogGroup"] = state ? state.cwLogGroup : undefined;
            resourceInputs["domain"] = state ? state.domain : undefined;
            resourceInputs["domainLists"] = state ? state.domainLists : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as AppMonitorArgs | undefined;
            resourceInputs["appMonitorConfiguration"] = args ? args.appMonitorConfiguration : undefined;
            resourceInputs["customEvents"] = args ? args.customEvents : undefined;
            resourceInputs["cwLogEnabled"] = args ? args.cwLogEnabled : undefined;
            resourceInputs["domain"] = args ? args.domain : undefined;
            resourceInputs["domainLists"] = args ? args.domainLists : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["appMonitorId"] = undefined /*out*/;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["cwLogGroup"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(AppMonitor.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering AppMonitor resources.
 */
export interface AppMonitorState {
    /**
     * configuration data for the app monitor. See appMonitorConfiguration below.
     */
    appMonitorConfiguration?: pulumi.Input<inputs.rum.AppMonitorAppMonitorConfiguration>;
    /**
     * The unique ID of the app monitor. Useful for JS templates.
     */
    appMonitorId?: pulumi.Input<string>;
    /**
     * The Amazon Resource Name (ARN) specifying the app monitor.
     */
    arn?: pulumi.Input<string>;
    /**
     * Specifies whether this app monitor allows the web client to define and send custom events. If you omit this parameter, custom events are `DISABLED`. See customEvents below.
     */
    customEvents?: pulumi.Input<inputs.rum.AppMonitorCustomEvents>;
    /**
     * Data collected by RUM is kept by RUM for 30 days and then deleted. This parameter specifies whether RUM sends a copy of this telemetry data to Amazon CloudWatch Logs in your account. This enables you to keep the telemetry data for more than 30 days, but it does incur Amazon CloudWatch Logs charges. Default value is `false`.
     */
    cwLogEnabled?: pulumi.Input<boolean>;
    /**
     * The name of the log group where the copies are stored.
     */
    cwLogGroup?: pulumi.Input<string>;
    domain?: pulumi.Input<string>;
    domainLists?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * The name of the log stream.
     */
    name?: pulumi.Input<string>;
    /**
     * A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}

/**
 * The set of arguments for constructing a AppMonitor resource.
 */
export interface AppMonitorArgs {
    /**
     * configuration data for the app monitor. See appMonitorConfiguration below.
     */
    appMonitorConfiguration?: pulumi.Input<inputs.rum.AppMonitorAppMonitorConfiguration>;
    /**
     * Specifies whether this app monitor allows the web client to define and send custom events. If you omit this parameter, custom events are `DISABLED`. See customEvents below.
     */
    customEvents?: pulumi.Input<inputs.rum.AppMonitorCustomEvents>;
    /**
     * Data collected by RUM is kept by RUM for 30 days and then deleted. This parameter specifies whether RUM sends a copy of this telemetry data to Amazon CloudWatch Logs in your account. This enables you to keep the telemetry data for more than 30 days, but it does incur Amazon CloudWatch Logs charges. Default value is `false`.
     */
    cwLogEnabled?: pulumi.Input<boolean>;
    domain?: pulumi.Input<string>;
    domainLists?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * The name of the log stream.
     */
    name?: pulumi.Input<string>;
    /**
     * A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
