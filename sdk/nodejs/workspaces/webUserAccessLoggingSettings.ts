// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Resource for managing an AWS WorkSpaces Web User Access Logging Settings resource. Once associated with a web portal, user access logging settings control how user access events are logged to Amazon Kinesis.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.kinesis.Stream("example", {
 *     name: "amazon-workspaces-web-example-stream",
 *     shardCount: 1,
 * });
 * const exampleUserAccessLoggingSettings = new aws.workspacesweb.UserAccessLoggingSettings("example", {kinesisStreamArn: example.arn});
 * ```
 *
 * ### With Tags
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.kinesis.Stream("example", {
 *     name: "example-stream",
 *     shardCount: 1,
 * });
 * const exampleUserAccessLoggingSettings = new aws.workspacesweb.UserAccessLoggingSettings("example", {
 *     kinesisStreamArn: example.arn,
 *     tags: {
 *         Name: "example-user-access-logging-settings",
 *         Environment: "Production",
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import WorkSpaces Web User Access Logging Settings using the `user_access_logging_settings_arn`. For example:
 *
 * ```sh
 * $ pulumi import aws:workspaces/webUserAccessLoggingSettings:WebUserAccessLoggingSettings example arn:aws:workspaces-web:us-west-2:123456789012:userAccessLoggingSettings/abcdef12345
 * ```
 *
 * @deprecated aws.workspaces/webuseraccessloggingsettings.WebUserAccessLoggingSettings has been deprecated in favor of aws.workspacesweb/useraccessloggingsettings.UserAccessLoggingSettings
 */
export class WebUserAccessLoggingSettings extends pulumi.CustomResource {
    /**
     * Get an existing WebUserAccessLoggingSettings resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: WebUserAccessLoggingSettingsState, opts?: pulumi.CustomResourceOptions): WebUserAccessLoggingSettings {
        pulumi.log.warn("WebUserAccessLoggingSettings is deprecated: aws.workspaces/webuseraccessloggingsettings.WebUserAccessLoggingSettings has been deprecated in favor of aws.workspacesweb/useraccessloggingsettings.UserAccessLoggingSettings")
        return new WebUserAccessLoggingSettings(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:workspaces/webUserAccessLoggingSettings:WebUserAccessLoggingSettings';

    /**
     * Returns true if the given object is an instance of WebUserAccessLoggingSettings.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is WebUserAccessLoggingSettings {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === WebUserAccessLoggingSettings.__pulumiType;
    }

    /**
     * List of web portal ARNs that this user access logging settings resource is associated with.
     */
    public /*out*/ readonly associatedPortalArns!: pulumi.Output<string[]>;
    /**
     * ARN of the Kinesis stream.
     *
     * The following arguments are optional:
     */
    public readonly kinesisStreamArn!: pulumi.Output<string>;
    /**
     * Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * ARN of the user access logging settings resource.
     */
    public /*out*/ readonly userAccessLoggingSettingsArn!: pulumi.Output<string>;

    /**
     * Create a WebUserAccessLoggingSettings resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    /** @deprecated aws.workspaces/webuseraccessloggingsettings.WebUserAccessLoggingSettings has been deprecated in favor of aws.workspacesweb/useraccessloggingsettings.UserAccessLoggingSettings */
    constructor(name: string, args: WebUserAccessLoggingSettingsArgs, opts?: pulumi.CustomResourceOptions)
    /** @deprecated aws.workspaces/webuseraccessloggingsettings.WebUserAccessLoggingSettings has been deprecated in favor of aws.workspacesweb/useraccessloggingsettings.UserAccessLoggingSettings */
    constructor(name: string, argsOrState?: WebUserAccessLoggingSettingsArgs | WebUserAccessLoggingSettingsState, opts?: pulumi.CustomResourceOptions) {
        pulumi.log.warn("WebUserAccessLoggingSettings is deprecated: aws.workspaces/webuseraccessloggingsettings.WebUserAccessLoggingSettings has been deprecated in favor of aws.workspacesweb/useraccessloggingsettings.UserAccessLoggingSettings")
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as WebUserAccessLoggingSettingsState | undefined;
            resourceInputs["associatedPortalArns"] = state ? state.associatedPortalArns : undefined;
            resourceInputs["kinesisStreamArn"] = state ? state.kinesisStreamArn : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["userAccessLoggingSettingsArn"] = state ? state.userAccessLoggingSettingsArn : undefined;
        } else {
            const args = argsOrState as WebUserAccessLoggingSettingsArgs | undefined;
            if ((!args || args.kinesisStreamArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'kinesisStreamArn'");
            }
            resourceInputs["kinesisStreamArn"] = args ? args.kinesisStreamArn : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["associatedPortalArns"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
            resourceInputs["userAccessLoggingSettingsArn"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(WebUserAccessLoggingSettings.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering WebUserAccessLoggingSettings resources.
 */
export interface WebUserAccessLoggingSettingsState {
    /**
     * List of web portal ARNs that this user access logging settings resource is associated with.
     */
    associatedPortalArns?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * ARN of the Kinesis stream.
     *
     * The following arguments are optional:
     */
    kinesisStreamArn?: pulumi.Input<string>;
    /**
     * Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * ARN of the user access logging settings resource.
     */
    userAccessLoggingSettingsArn?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a WebUserAccessLoggingSettings resource.
 */
export interface WebUserAccessLoggingSettingsArgs {
    /**
     * ARN of the Kinesis stream.
     *
     * The following arguments are optional:
     */
    kinesisStreamArn: pulumi.Input<string>;
    /**
     * Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
