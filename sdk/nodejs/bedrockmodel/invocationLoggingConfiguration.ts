// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Manages Bedrock model invocation logging configuration.
 *
 * > Model invocation logging is configured per AWS region. To avoid overwriting settings, this resource should not be defined in multiple configurations.
 *
 * ## Example Usage
 *
 * ## Import
 *
 * Using `pulumi import`, import Bedrock custom model using the `id` set to the AWS Region. For example:
 *
 * ```sh
 * $ pulumi import aws:bedrockmodel/invocationLoggingConfiguration:InvocationLoggingConfiguration my_config us-east-1
 * ```
 */
export class InvocationLoggingConfiguration extends pulumi.CustomResource {
    /**
     * Get an existing InvocationLoggingConfiguration resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: InvocationLoggingConfigurationState, opts?: pulumi.CustomResourceOptions): InvocationLoggingConfiguration {
        return new InvocationLoggingConfiguration(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:bedrockmodel/invocationLoggingConfiguration:InvocationLoggingConfiguration';

    /**
     * Returns true if the given object is an instance of InvocationLoggingConfiguration.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is InvocationLoggingConfiguration {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === InvocationLoggingConfiguration.__pulumiType;
    }

    /**
     * The logging configuration values to set. See `loggingConfig` Block for details.
     */
    public readonly loggingConfig!: pulumi.Output<outputs.bedrockmodel.InvocationLoggingConfigurationLoggingConfig | undefined>;

    /**
     * Create a InvocationLoggingConfiguration resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args?: InvocationLoggingConfigurationArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: InvocationLoggingConfigurationArgs | InvocationLoggingConfigurationState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as InvocationLoggingConfigurationState | undefined;
            resourceInputs["loggingConfig"] = state ? state.loggingConfig : undefined;
        } else {
            const args = argsOrState as InvocationLoggingConfigurationArgs | undefined;
            resourceInputs["loggingConfig"] = args ? args.loggingConfig : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(InvocationLoggingConfiguration.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering InvocationLoggingConfiguration resources.
 */
export interface InvocationLoggingConfigurationState {
    /**
     * The logging configuration values to set. See `loggingConfig` Block for details.
     */
    loggingConfig?: pulumi.Input<inputs.bedrockmodel.InvocationLoggingConfigurationLoggingConfig>;
}

/**
 * The set of arguments for constructing a InvocationLoggingConfiguration resource.
 */
export interface InvocationLoggingConfigurationArgs {
    /**
     * The logging configuration values to set. See `loggingConfig` Block for details.
     */
    loggingConfig?: pulumi.Input<inputs.bedrockmodel.InvocationLoggingConfigurationLoggingConfig>;
}
