// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Registers an on-premises server or virtual machine with Amazon EC2 so that it can be managed using Run Command.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const assumeRole = aws.iam.getPolicyDocument({
 *     statements: [{
 *         effect: "Allow",
 *         principals: [{
 *             type: "Service",
 *             identifiers: ["ssm.amazonaws.com"],
 *         }],
 *         actions: ["sts:AssumeRole"],
 *     }],
 * });
 * const testRole = new aws.iam.Role("test_role", {
 *     name: "test_role",
 *     assumeRolePolicy: assumeRole.then(assumeRole => assumeRole.json),
 * });
 * const testAttach = new aws.iam.RolePolicyAttachment("test_attach", {
 *     role: testRole.name,
 *     policyArn: "arn:aws:iam::aws:policy/AmazonSSMManagedInstanceCore",
 * });
 * const foo = new aws.ssm.Activation("foo", {
 *     name: "test_ssm_activation",
 *     description: "Test",
 *     iamRole: testRole.id,
 *     registrationLimit: 5,
 * }, {
 *     dependsOn: [testAttach],
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import AWS SSM Activation using the `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:ssm/activation:Activation example e488f2f6-e686-4afb-8a04-ef6dfEXAMPLE
 * ```
 * -> __Note:__ The `activation_code` attribute cannot be imported.
 */
export class Activation extends pulumi.CustomResource {
    /**
     * Get an existing Activation resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ActivationState, opts?: pulumi.CustomResourceOptions): Activation {
        return new Activation(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ssm/activation:Activation';

    /**
     * Returns true if the given object is an instance of Activation.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Activation {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Activation.__pulumiType;
    }

    /**
     * The code the system generates when it processes the activation.
     */
    public /*out*/ readonly activationCode!: pulumi.Output<string>;
    /**
     * The description of the resource that you want to register.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * UTC timestamp in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) by which this activation request should expire. The default value is 24 hours from resource creation time. This provider will only perform drift detection of its value when present in a configuration.
     */
    public readonly expirationDate!: pulumi.Output<string>;
    /**
     * If the current activation has expired.
     */
    public /*out*/ readonly expired!: pulumi.Output<boolean>;
    /**
     * The IAM Role to attach to the managed instance.
     */
    public readonly iamRole!: pulumi.Output<string>;
    /**
     * The default name of the registered managed instance.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * The number of managed instances that are currently registered using this activation.
     */
    public /*out*/ readonly registrationCount!: pulumi.Output<number>;
    /**
     * The maximum number of managed instances you want to register. The default value is 1 instance.
     */
    public readonly registrationLimit!: pulumi.Output<number | undefined>;
    /**
     * A map of tags to assign to the object. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;

    /**
     * Create a Activation resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: ActivationArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ActivationArgs | ActivationState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ActivationState | undefined;
            resourceInputs["activationCode"] = state ? state.activationCode : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["expirationDate"] = state ? state.expirationDate : undefined;
            resourceInputs["expired"] = state ? state.expired : undefined;
            resourceInputs["iamRole"] = state ? state.iamRole : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["registrationCount"] = state ? state.registrationCount : undefined;
            resourceInputs["registrationLimit"] = state ? state.registrationLimit : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as ActivationArgs | undefined;
            if ((!args || args.iamRole === undefined) && !opts.urn) {
                throw new Error("Missing required property 'iamRole'");
            }
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["expirationDate"] = args ? args.expirationDate : undefined;
            resourceInputs["iamRole"] = args ? args.iamRole : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["registrationLimit"] = args ? args.registrationLimit : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["activationCode"] = undefined /*out*/;
            resourceInputs["expired"] = undefined /*out*/;
            resourceInputs["registrationCount"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Activation.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Activation resources.
 */
export interface ActivationState {
    /**
     * The code the system generates when it processes the activation.
     */
    activationCode?: pulumi.Input<string>;
    /**
     * The description of the resource that you want to register.
     */
    description?: pulumi.Input<string>;
    /**
     * UTC timestamp in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) by which this activation request should expire. The default value is 24 hours from resource creation time. This provider will only perform drift detection of its value when present in a configuration.
     */
    expirationDate?: pulumi.Input<string>;
    /**
     * If the current activation has expired.
     */
    expired?: pulumi.Input<boolean>;
    /**
     * The IAM Role to attach to the managed instance.
     */
    iamRole?: pulumi.Input<string>;
    /**
     * The default name of the registered managed instance.
     */
    name?: pulumi.Input<string>;
    /**
     * The number of managed instances that are currently registered using this activation.
     */
    registrationCount?: pulumi.Input<number>;
    /**
     * The maximum number of managed instances you want to register. The default value is 1 instance.
     */
    registrationLimit?: pulumi.Input<number>;
    /**
     * A map of tags to assign to the object. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
 * The set of arguments for constructing a Activation resource.
 */
export interface ActivationArgs {
    /**
     * The description of the resource that you want to register.
     */
    description?: pulumi.Input<string>;
    /**
     * UTC timestamp in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) by which this activation request should expire. The default value is 24 hours from resource creation time. This provider will only perform drift detection of its value when present in a configuration.
     */
    expirationDate?: pulumi.Input<string>;
    /**
     * The IAM Role to attach to the managed instance.
     */
    iamRole: pulumi.Input<string>;
    /**
     * The default name of the registered managed instance.
     */
    name?: pulumi.Input<string>;
    /**
     * The maximum number of managed instances you want to register. The default value is 1 instance.
     */
    registrationLimit?: pulumi.Input<number>;
    /**
     * A map of tags to assign to the object. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
