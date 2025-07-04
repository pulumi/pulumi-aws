// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Resource for managing an AWS WorkSpaces Web Data Protection Settings resource. Once associated with a web portal, data protection settings control how sensitive information is redacted in streaming sessions.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.workspacesweb.DataProtectionSettings("example", {displayName: "example"});
 * ```
 *
 * ### With Inline Redaction Configuration
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.workspacesweb.DataProtectionSettings("example", {
 *     displayName: "example",
 *     description: "Example data protection settings",
 *     inlineRedactionConfiguration: {
 *         globalConfidenceLevel: 2,
 *         globalEnforcedUrls: ["https://example.com"],
 *         inlineRedactionPatterns: [{
 *             builtInPatternId: "ssn",
 *             confidenceLevel: 3,
 *             redactionPlaceHolders: [{
 *                 redactionPlaceHolderType: "CustomText",
 *                 redactionPlaceHolderText: "REDACTED",
 *             }],
 *         }],
 *     },
 * });
 * ```
 *
 * ### Complete Example
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.kms.Key("example", {
 *     description: "KMS key for WorkSpaces Web Data Protection Settings",
 *     deletionWindowInDays: 7,
 * });
 * const exampleDataProtectionSettings = new aws.workspacesweb.DataProtectionSettings("example", {
 *     displayName: "example-complete",
 *     description: "Complete example data protection settings",
 *     customerManagedKey: example.arn,
 *     additionalEncryptionContext: {
 *         Environment: "Production",
 *     },
 *     inlineRedactionConfiguration: {
 *         globalConfidenceLevel: 2,
 *         globalEnforcedUrls: [
 *             "https://example.com",
 *             "https://test.example.com",
 *         ],
 *         globalExemptUrls: ["https://exempt.example.com"],
 *         inlineRedactionPatterns: [
 *             {
 *                 builtInPatternId: "ssn",
 *                 confidenceLevel: 3,
 *                 enforcedUrls: ["https://pattern1.example.com"],
 *                 exemptUrls: ["https://exempt-pattern1.example.com"],
 *                 redactionPlaceHolders: [{
 *                     redactionPlaceHolderType: "CustomText",
 *                     redactionPlaceHolderText: "REDACTED-SSN",
 *                 }],
 *             },
 *             {
 *                 customPattern: {
 *                     patternName: "CustomPattern",
 *                     patternRegex: "/\\d{3}-\\d{2}-\\d{4}/g",
 *                     keywordRegex: "/SSN|Social Security/gi",
 *                     patternDescription: "Custom SSN pattern",
 *                 },
 *                 redactionPlaceHolders: [{
 *                     redactionPlaceHolderType: "CustomText",
 *                     redactionPlaceHolderText: "REDACTED-CUSTOM",
 *                 }],
 *             },
 *         ],
 *     },
 *     tags: {
 *         Name: "example-data-protection-settings",
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import WorkSpaces Web Data Protection Settings using the `data_protection_settings_arn`. For example:
 *
 * ```sh
 * $ pulumi import aws:workspaces/webDataProtectionSettings:WebDataProtectionSettings example arn:aws:workspaces-web:us-west-2:123456789012:dataprotectionsettings/abcdef12345
 * ```
 *
 * @deprecated aws.workspaces/webdataprotectionsettings.WebDataProtectionSettings has been deprecated in favor of aws.workspacesweb/dataprotectionsettings.DataProtectionSettings
 */
export class WebDataProtectionSettings extends pulumi.CustomResource {
    /**
     * Get an existing WebDataProtectionSettings resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: WebDataProtectionSettingsState, opts?: pulumi.CustomResourceOptions): WebDataProtectionSettings {
        pulumi.log.warn("WebDataProtectionSettings is deprecated: aws.workspaces/webdataprotectionsettings.WebDataProtectionSettings has been deprecated in favor of aws.workspacesweb/dataprotectionsettings.DataProtectionSettings")
        return new WebDataProtectionSettings(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:workspaces/webDataProtectionSettings:WebDataProtectionSettings';

    /**
     * Returns true if the given object is an instance of WebDataProtectionSettings.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is WebDataProtectionSettings {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === WebDataProtectionSettings.__pulumiType;
    }

    /**
     * Additional encryption context for the data protection settings.
     */
    public readonly additionalEncryptionContext!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * List of web portal ARNs that this data protection settings resource is associated with.
     */
    public /*out*/ readonly associatedPortalArns!: pulumi.Output<string[]>;
    /**
     * ARN of the customer managed KMS key.
     */
    public readonly customerManagedKey!: pulumi.Output<string | undefined>;
    /**
     * ARN of the data protection settings resource.
     */
    public /*out*/ readonly dataProtectionSettingsArn!: pulumi.Output<string>;
    /**
     * The description of the data protection settings.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * The display name of the data protection settings.
     *
     * The following arguments are optional:
     */
    public readonly displayName!: pulumi.Output<string>;
    /**
     * The inline redaction configuration of the data protection settings. Detailed below.
     */
    public readonly inlineRedactionConfiguration!: pulumi.Output<outputs.workspaces.WebDataProtectionSettingsInlineRedactionConfiguration | undefined>;
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
     * Create a WebDataProtectionSettings resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    /** @deprecated aws.workspaces/webdataprotectionsettings.WebDataProtectionSettings has been deprecated in favor of aws.workspacesweb/dataprotectionsettings.DataProtectionSettings */
    constructor(name: string, args: WebDataProtectionSettingsArgs, opts?: pulumi.CustomResourceOptions)
    /** @deprecated aws.workspaces/webdataprotectionsettings.WebDataProtectionSettings has been deprecated in favor of aws.workspacesweb/dataprotectionsettings.DataProtectionSettings */
    constructor(name: string, argsOrState?: WebDataProtectionSettingsArgs | WebDataProtectionSettingsState, opts?: pulumi.CustomResourceOptions) {
        pulumi.log.warn("WebDataProtectionSettings is deprecated: aws.workspaces/webdataprotectionsettings.WebDataProtectionSettings has been deprecated in favor of aws.workspacesweb/dataprotectionsettings.DataProtectionSettings")
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as WebDataProtectionSettingsState | undefined;
            resourceInputs["additionalEncryptionContext"] = state ? state.additionalEncryptionContext : undefined;
            resourceInputs["associatedPortalArns"] = state ? state.associatedPortalArns : undefined;
            resourceInputs["customerManagedKey"] = state ? state.customerManagedKey : undefined;
            resourceInputs["dataProtectionSettingsArn"] = state ? state.dataProtectionSettingsArn : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["displayName"] = state ? state.displayName : undefined;
            resourceInputs["inlineRedactionConfiguration"] = state ? state.inlineRedactionConfiguration : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as WebDataProtectionSettingsArgs | undefined;
            if ((!args || args.displayName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'displayName'");
            }
            resourceInputs["additionalEncryptionContext"] = args ? args.additionalEncryptionContext : undefined;
            resourceInputs["customerManagedKey"] = args ? args.customerManagedKey : undefined;
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["displayName"] = args ? args.displayName : undefined;
            resourceInputs["inlineRedactionConfiguration"] = args ? args.inlineRedactionConfiguration : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["associatedPortalArns"] = undefined /*out*/;
            resourceInputs["dataProtectionSettingsArn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(WebDataProtectionSettings.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering WebDataProtectionSettings resources.
 */
export interface WebDataProtectionSettingsState {
    /**
     * Additional encryption context for the data protection settings.
     */
    additionalEncryptionContext?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * List of web portal ARNs that this data protection settings resource is associated with.
     */
    associatedPortalArns?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * ARN of the customer managed KMS key.
     */
    customerManagedKey?: pulumi.Input<string>;
    /**
     * ARN of the data protection settings resource.
     */
    dataProtectionSettingsArn?: pulumi.Input<string>;
    /**
     * The description of the data protection settings.
     */
    description?: pulumi.Input<string>;
    /**
     * The display name of the data protection settings.
     *
     * The following arguments are optional:
     */
    displayName?: pulumi.Input<string>;
    /**
     * The inline redaction configuration of the data protection settings. Detailed below.
     */
    inlineRedactionConfiguration?: pulumi.Input<inputs.workspaces.WebDataProtectionSettingsInlineRedactionConfiguration>;
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
}

/**
 * The set of arguments for constructing a WebDataProtectionSettings resource.
 */
export interface WebDataProtectionSettingsArgs {
    /**
     * Additional encryption context for the data protection settings.
     */
    additionalEncryptionContext?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * ARN of the customer managed KMS key.
     */
    customerManagedKey?: pulumi.Input<string>;
    /**
     * The description of the data protection settings.
     */
    description?: pulumi.Input<string>;
    /**
     * The display name of the data protection settings.
     *
     * The following arguments are optional:
     */
    displayName: pulumi.Input<string>;
    /**
     * The inline redaction configuration of the data protection settings. Detailed below.
     */
    inlineRedactionConfiguration?: pulumi.Input<inputs.workspaces.WebDataProtectionSettingsInlineRedactionConfiguration>;
    /**
     * Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
