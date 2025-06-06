// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Resource for managing an AWS Payment Cryptography Control Plane Key.
 *
 * ## Example Usage
 *
 * ## Import
 *
 * Using `pulumi import`, import Payment Cryptography Control Plane Key using the `arn:aws:payment-cryptography:us-east-1:123456789012:key/qtbojf64yshyvyzf`. For example:
 *
 * ```sh
 * $ pulumi import aws:paymentcryptography/key:Key example arn:aws:payment-cryptography:us-east-1:123456789012:key/qtbojf64yshyvyzf
 * ```
 */
export class Key extends pulumi.CustomResource {
    /**
     * Get an existing Key resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: KeyState, opts?: pulumi.CustomResourceOptions): Key {
        return new Key(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:paymentcryptography/key:Key';

    /**
     * Returns true if the given object is an instance of Key.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Key {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Key.__pulumiType;
    }

    /**
     * ARN of the key.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    public readonly deletionWindowInDays!: pulumi.Output<number>;
    /**
     * Whether to enable the key.
     */
    public readonly enabled!: pulumi.Output<boolean>;
    /**
     * Whether the key is exportable from the service.
     */
    public readonly exportable!: pulumi.Output<boolean>;
    /**
     * Role of the key, the algorithm it supports, and the cryptographic operations allowed with the key.
     *
     * The following arguments are optional:
     */
    public readonly keyAttributes!: pulumi.Output<outputs.paymentcryptography.KeyKeyAttributes | undefined>;
    /**
     * Key check value (KCV) is used to check if all parties holding a given key have the same key or to detect that a key has changed.
     */
    public /*out*/ readonly keyCheckValue!: pulumi.Output<string>;
    /**
     * Algorithm that AWS Payment Cryptography uses to calculate the key check value (KCV).
     */
    public readonly keyCheckValueAlgorithm!: pulumi.Output<string>;
    /**
     * Source of the key material.
     */
    public /*out*/ readonly keyOrigin!: pulumi.Output<string>;
    /**
     * State of key that is being created or deleted.
     */
    public /*out*/ readonly keyState!: pulumi.Output<string>;
    /**
     * Map of tags assigned to the WorkSpaces Connection Alias. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    public readonly timeouts!: pulumi.Output<outputs.paymentcryptography.KeyTimeouts | undefined>;

    /**
     * Create a Key resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: KeyArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: KeyArgs | KeyState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as KeyState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["deletionWindowInDays"] = state ? state.deletionWindowInDays : undefined;
            resourceInputs["enabled"] = state ? state.enabled : undefined;
            resourceInputs["exportable"] = state ? state.exportable : undefined;
            resourceInputs["keyAttributes"] = state ? state.keyAttributes : undefined;
            resourceInputs["keyCheckValue"] = state ? state.keyCheckValue : undefined;
            resourceInputs["keyCheckValueAlgorithm"] = state ? state.keyCheckValueAlgorithm : undefined;
            resourceInputs["keyOrigin"] = state ? state.keyOrigin : undefined;
            resourceInputs["keyState"] = state ? state.keyState : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["timeouts"] = state ? state.timeouts : undefined;
        } else {
            const args = argsOrState as KeyArgs | undefined;
            if ((!args || args.exportable === undefined) && !opts.urn) {
                throw new Error("Missing required property 'exportable'");
            }
            resourceInputs["deletionWindowInDays"] = args ? args.deletionWindowInDays : undefined;
            resourceInputs["enabled"] = args ? args.enabled : undefined;
            resourceInputs["exportable"] = args ? args.exportable : undefined;
            resourceInputs["keyAttributes"] = args ? args.keyAttributes : undefined;
            resourceInputs["keyCheckValueAlgorithm"] = args ? args.keyCheckValueAlgorithm : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["timeouts"] = args ? args.timeouts : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["keyCheckValue"] = undefined /*out*/;
            resourceInputs["keyOrigin"] = undefined /*out*/;
            resourceInputs["keyState"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Key.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Key resources.
 */
export interface KeyState {
    /**
     * ARN of the key.
     */
    arn?: pulumi.Input<string>;
    deletionWindowInDays?: pulumi.Input<number>;
    /**
     * Whether to enable the key.
     */
    enabled?: pulumi.Input<boolean>;
    /**
     * Whether the key is exportable from the service.
     */
    exportable?: pulumi.Input<boolean>;
    /**
     * Role of the key, the algorithm it supports, and the cryptographic operations allowed with the key.
     *
     * The following arguments are optional:
     */
    keyAttributes?: pulumi.Input<inputs.paymentcryptography.KeyKeyAttributes>;
    /**
     * Key check value (KCV) is used to check if all parties holding a given key have the same key or to detect that a key has changed.
     */
    keyCheckValue?: pulumi.Input<string>;
    /**
     * Algorithm that AWS Payment Cryptography uses to calculate the key check value (KCV).
     */
    keyCheckValueAlgorithm?: pulumi.Input<string>;
    /**
     * Source of the key material.
     */
    keyOrigin?: pulumi.Input<string>;
    /**
     * State of key that is being created or deleted.
     */
    keyState?: pulumi.Input<string>;
    /**
     * Map of tags assigned to the WorkSpaces Connection Alias. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    timeouts?: pulumi.Input<inputs.paymentcryptography.KeyTimeouts>;
}

/**
 * The set of arguments for constructing a Key resource.
 */
export interface KeyArgs {
    deletionWindowInDays?: pulumi.Input<number>;
    /**
     * Whether to enable the key.
     */
    enabled?: pulumi.Input<boolean>;
    /**
     * Whether the key is exportable from the service.
     */
    exportable: pulumi.Input<boolean>;
    /**
     * Role of the key, the algorithm it supports, and the cryptographic operations allowed with the key.
     *
     * The following arguments are optional:
     */
    keyAttributes?: pulumi.Input<inputs.paymentcryptography.KeyKeyAttributes>;
    /**
     * Algorithm that AWS Payment Cryptography uses to calculate the key check value (KCV).
     */
    keyCheckValueAlgorithm?: pulumi.Input<string>;
    /**
     * Map of tags assigned to the WorkSpaces Connection Alias. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    timeouts?: pulumi.Input<inputs.paymentcryptography.KeyTimeouts>;
}
