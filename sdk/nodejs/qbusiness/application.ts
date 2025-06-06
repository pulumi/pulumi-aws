// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides a Q Business Application resource.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.qbusiness.Application("example", {
 *     displayName: "example-app",
 *     iamServiceRoleArn: exampleAwsIamRole.arn,
 *     identityCenterInstanceArn: exampleAwsSsoadminInstances.arns[0],
 *     attachmentsConfiguration: {
 *         attachmentsControlMode: "ENABLED",
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import a Q Business Application using the `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:qbusiness/application:Application example id-12345678
 * ```
 */
export class Application extends pulumi.CustomResource {
    /**
     * Get an existing Application resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ApplicationState, opts?: pulumi.CustomResourceOptions): Application {
        return new Application(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:qbusiness/application:Application';

    /**
     * Returns true if the given object is an instance of Application.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Application {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Application.__pulumiType;
    }

    /**
     * ARN of the Q Business application.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * Information about whether file upload functionality is activated or deactivated for your end user. See `attachmentsConfiguration` below.
     */
    public readonly attachmentsConfiguration!: pulumi.Output<outputs.qbusiness.ApplicationAttachmentsConfiguration | undefined>;
    /**
     * Description of the Amazon Q application.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * Name of the Amazon Q application.
     */
    public readonly displayName!: pulumi.Output<string>;
    /**
     * Information about encryption configuration. See `encryptionConfiguration` below.
     */
    public readonly encryptionConfiguration!: pulumi.Output<outputs.qbusiness.ApplicationEncryptionConfiguration | undefined>;
    /**
     * ARN of an IAM role with permissions to access your Amazon CloudWatch logs and metrics.
     */
    public readonly iamServiceRoleArn!: pulumi.Output<string>;
    /**
     * ARN of the AWS IAM Identity Center application attached to your Amazon Q Business application.
     */
    public /*out*/ readonly identityCenterApplicationArn!: pulumi.Output<string>;
    /**
     * ARN of the IAM Identity Center instance you are either creating for — or connecting to — your Amazon Q Business application.
     *
     * The following arguments are optional:
     */
    public readonly identityCenterInstanceArn!: pulumi.Output<string>;
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    public readonly timeouts!: pulumi.Output<outputs.qbusiness.ApplicationTimeouts | undefined>;

    /**
     * Create a Application resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: ApplicationArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ApplicationArgs | ApplicationState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ApplicationState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["attachmentsConfiguration"] = state ? state.attachmentsConfiguration : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["displayName"] = state ? state.displayName : undefined;
            resourceInputs["encryptionConfiguration"] = state ? state.encryptionConfiguration : undefined;
            resourceInputs["iamServiceRoleArn"] = state ? state.iamServiceRoleArn : undefined;
            resourceInputs["identityCenterApplicationArn"] = state ? state.identityCenterApplicationArn : undefined;
            resourceInputs["identityCenterInstanceArn"] = state ? state.identityCenterInstanceArn : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["timeouts"] = state ? state.timeouts : undefined;
        } else {
            const args = argsOrState as ApplicationArgs | undefined;
            if ((!args || args.displayName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'displayName'");
            }
            if ((!args || args.iamServiceRoleArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'iamServiceRoleArn'");
            }
            if ((!args || args.identityCenterInstanceArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'identityCenterInstanceArn'");
            }
            resourceInputs["attachmentsConfiguration"] = args ? args.attachmentsConfiguration : undefined;
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["displayName"] = args ? args.displayName : undefined;
            resourceInputs["encryptionConfiguration"] = args ? args.encryptionConfiguration : undefined;
            resourceInputs["iamServiceRoleArn"] = args ? args.iamServiceRoleArn : undefined;
            resourceInputs["identityCenterInstanceArn"] = args ? args.identityCenterInstanceArn : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["timeouts"] = args ? args.timeouts : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["identityCenterApplicationArn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Application.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Application resources.
 */
export interface ApplicationState {
    /**
     * ARN of the Q Business application.
     */
    arn?: pulumi.Input<string>;
    /**
     * Information about whether file upload functionality is activated or deactivated for your end user. See `attachmentsConfiguration` below.
     */
    attachmentsConfiguration?: pulumi.Input<inputs.qbusiness.ApplicationAttachmentsConfiguration>;
    /**
     * Description of the Amazon Q application.
     */
    description?: pulumi.Input<string>;
    /**
     * Name of the Amazon Q application.
     */
    displayName?: pulumi.Input<string>;
    /**
     * Information about encryption configuration. See `encryptionConfiguration` below.
     */
    encryptionConfiguration?: pulumi.Input<inputs.qbusiness.ApplicationEncryptionConfiguration>;
    /**
     * ARN of an IAM role with permissions to access your Amazon CloudWatch logs and metrics.
     */
    iamServiceRoleArn?: pulumi.Input<string>;
    /**
     * ARN of the AWS IAM Identity Center application attached to your Amazon Q Business application.
     */
    identityCenterApplicationArn?: pulumi.Input<string>;
    /**
     * ARN of the IAM Identity Center instance you are either creating for — or connecting to — your Amazon Q Business application.
     *
     * The following arguments are optional:
     */
    identityCenterInstanceArn?: pulumi.Input<string>;
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    timeouts?: pulumi.Input<inputs.qbusiness.ApplicationTimeouts>;
}

/**
 * The set of arguments for constructing a Application resource.
 */
export interface ApplicationArgs {
    /**
     * Information about whether file upload functionality is activated or deactivated for your end user. See `attachmentsConfiguration` below.
     */
    attachmentsConfiguration?: pulumi.Input<inputs.qbusiness.ApplicationAttachmentsConfiguration>;
    /**
     * Description of the Amazon Q application.
     */
    description?: pulumi.Input<string>;
    /**
     * Name of the Amazon Q application.
     */
    displayName: pulumi.Input<string>;
    /**
     * Information about encryption configuration. See `encryptionConfiguration` below.
     */
    encryptionConfiguration?: pulumi.Input<inputs.qbusiness.ApplicationEncryptionConfiguration>;
    /**
     * ARN of an IAM role with permissions to access your Amazon CloudWatch logs and metrics.
     */
    iamServiceRoleArn: pulumi.Input<string>;
    /**
     * ARN of the IAM Identity Center instance you are either creating for — or connecting to — your Amazon Q Business application.
     *
     * The following arguments are optional:
     */
    identityCenterInstanceArn: pulumi.Input<string>;
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    timeouts?: pulumi.Input<inputs.qbusiness.ApplicationTimeouts>;
}
