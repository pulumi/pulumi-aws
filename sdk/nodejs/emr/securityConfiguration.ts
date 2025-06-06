// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides a resource to manage AWS EMR Security Configurations
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const foo = new aws.emr.SecurityConfiguration("foo", {
 *     name: "emrsc_other",
 *     configuration: `{
 *   "EncryptionConfiguration": {
 *     "AtRestEncryptionConfiguration": {
 *       "S3EncryptionConfiguration": {
 *         "EncryptionMode": "SSE-S3"
 *       },
 *       "LocalDiskEncryptionConfiguration": {
 *         "EncryptionKeyProviderType": "AwsKms",
 *         "AwsKmsKey": "arn:aws:kms:us-west-2:187416307283:alias/my_emr_test_key"
 *       }
 *     },
 *     "EnableInTransitEncryption": false,
 *     "EnableAtRestEncryption": true
 *   }
 * }
 * `,
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import EMR Security Configurations using the `name`. For example:
 *
 * ```sh
 * $ pulumi import aws:emr/securityConfiguration:SecurityConfiguration sc example-sc-name
 * ```
 */
export class SecurityConfiguration extends pulumi.CustomResource {
    /**
     * Get an existing SecurityConfiguration resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: SecurityConfigurationState, opts?: pulumi.CustomResourceOptions): SecurityConfiguration {
        return new SecurityConfiguration(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:emr/securityConfiguration:SecurityConfiguration';

    /**
     * Returns true if the given object is an instance of SecurityConfiguration.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is SecurityConfiguration {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === SecurityConfiguration.__pulumiType;
    }

    /**
     * A JSON formatted Security Configuration
     */
    public readonly configuration!: pulumi.Output<string>;
    /**
     * Date the Security Configuration was created
     */
    public /*out*/ readonly creationDate!: pulumi.Output<string>;
    /**
     * The name of the EMR Security Configuration. By default generated by this provider.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * Creates a unique name beginning with the specified
     * prefix. Conflicts with `name`.
     */
    public readonly namePrefix!: pulumi.Output<string>;

    /**
     * Create a SecurityConfiguration resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: SecurityConfigurationArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: SecurityConfigurationArgs | SecurityConfigurationState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as SecurityConfigurationState | undefined;
            resourceInputs["configuration"] = state ? state.configuration : undefined;
            resourceInputs["creationDate"] = state ? state.creationDate : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["namePrefix"] = state ? state.namePrefix : undefined;
        } else {
            const args = argsOrState as SecurityConfigurationArgs | undefined;
            if ((!args || args.configuration === undefined) && !opts.urn) {
                throw new Error("Missing required property 'configuration'");
            }
            resourceInputs["configuration"] = args ? args.configuration : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["namePrefix"] = args ? args.namePrefix : undefined;
            resourceInputs["creationDate"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(SecurityConfiguration.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering SecurityConfiguration resources.
 */
export interface SecurityConfigurationState {
    /**
     * A JSON formatted Security Configuration
     */
    configuration?: pulumi.Input<string>;
    /**
     * Date the Security Configuration was created
     */
    creationDate?: pulumi.Input<string>;
    /**
     * The name of the EMR Security Configuration. By default generated by this provider.
     */
    name?: pulumi.Input<string>;
    /**
     * Creates a unique name beginning with the specified
     * prefix. Conflicts with `name`.
     */
    namePrefix?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a SecurityConfiguration resource.
 */
export interface SecurityConfigurationArgs {
    /**
     * A JSON formatted Security Configuration
     */
    configuration: pulumi.Input<string>;
    /**
     * The name of the EMR Security Configuration. By default generated by this provider.
     */
    name?: pulumi.Input<string>;
    /**
     * Creates a unique name beginning with the specified
     * prefix. Conflicts with `name`.
     */
    namePrefix?: pulumi.Input<string>;
}
