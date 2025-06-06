// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Resource for managing a Roles Anywhere Profile.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const test = new aws.iam.Role("test", {
 *     name: "test",
 *     path: "/",
 *     assumeRolePolicy: JSON.stringify({
 *         Version: "2012-10-17",
 *         Statement: [{
 *             Action: [
 *                 "sts:AssumeRole",
 *                 "sts:TagSession",
 *                 "sts:SetSourceIdentity",
 *             ],
 *             Principal: {
 *                 Service: "rolesanywhere.amazonaws.com",
 *             },
 *             Effect: "Allow",
 *             Sid: "",
 *         }],
 *     }),
 * });
 * const testProfile = new aws.rolesanywhere.Profile("test", {
 *     name: "example",
 *     roleArns: [test.arn],
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import `aws_rolesanywhere_profile` using its `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:rolesanywhere/profile:Profile example db138a85-8925-4f9f-a409-08231233cacf
 * ```
 */
export class Profile extends pulumi.CustomResource {
    /**
     * Get an existing Profile resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ProfileState, opts?: pulumi.CustomResourceOptions): Profile {
        return new Profile(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:rolesanywhere/profile:Profile';

    /**
     * Returns true if the given object is an instance of Profile.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Profile {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Profile.__pulumiType;
    }

    /**
     * Amazon Resource Name (ARN) of the Profile
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * The number of seconds the vended session credentials are valid for. Defaults to 3600.
     */
    public readonly durationSeconds!: pulumi.Output<number>;
    /**
     * Whether or not the Profile is enabled.
     */
    public readonly enabled!: pulumi.Output<boolean | undefined>;
    /**
     * A list of managed policy ARNs that apply to the vended session credentials.
     */
    public readonly managedPolicyArns!: pulumi.Output<string[] | undefined>;
    /**
     * The name of the Profile.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * Specifies whether instance properties are required in [CreateSession](https://docs.aws.amazon.com/rolesanywhere/latest/APIReference/API_CreateSession.html) requests with this profile.
     */
    public readonly requireInstanceProperties!: pulumi.Output<boolean | undefined>;
    /**
     * A list of IAM roles that this profile can assume
     */
    public readonly roleArns!: pulumi.Output<string[] | undefined>;
    /**
     * A session policy that applies to the trust boundary of the vended session credentials.
     */
    public readonly sessionPolicy!: pulumi.Output<string | undefined>;
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
     * Create a Profile resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args?: ProfileArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ProfileArgs | ProfileState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ProfileState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["durationSeconds"] = state ? state.durationSeconds : undefined;
            resourceInputs["enabled"] = state ? state.enabled : undefined;
            resourceInputs["managedPolicyArns"] = state ? state.managedPolicyArns : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["requireInstanceProperties"] = state ? state.requireInstanceProperties : undefined;
            resourceInputs["roleArns"] = state ? state.roleArns : undefined;
            resourceInputs["sessionPolicy"] = state ? state.sessionPolicy : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as ProfileArgs | undefined;
            resourceInputs["durationSeconds"] = args ? args.durationSeconds : undefined;
            resourceInputs["enabled"] = args ? args.enabled : undefined;
            resourceInputs["managedPolicyArns"] = args ? args.managedPolicyArns : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["requireInstanceProperties"] = args ? args.requireInstanceProperties : undefined;
            resourceInputs["roleArns"] = args ? args.roleArns : undefined;
            resourceInputs["sessionPolicy"] = args ? args.sessionPolicy : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Profile.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Profile resources.
 */
export interface ProfileState {
    /**
     * Amazon Resource Name (ARN) of the Profile
     */
    arn?: pulumi.Input<string>;
    /**
     * The number of seconds the vended session credentials are valid for. Defaults to 3600.
     */
    durationSeconds?: pulumi.Input<number>;
    /**
     * Whether or not the Profile is enabled.
     */
    enabled?: pulumi.Input<boolean>;
    /**
     * A list of managed policy ARNs that apply to the vended session credentials.
     */
    managedPolicyArns?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * The name of the Profile.
     */
    name?: pulumi.Input<string>;
    /**
     * Specifies whether instance properties are required in [CreateSession](https://docs.aws.amazon.com/rolesanywhere/latest/APIReference/API_CreateSession.html) requests with this profile.
     */
    requireInstanceProperties?: pulumi.Input<boolean>;
    /**
     * A list of IAM roles that this profile can assume
     */
    roleArns?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * A session policy that applies to the trust boundary of the vended session credentials.
     */
    sessionPolicy?: pulumi.Input<string>;
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
 * The set of arguments for constructing a Profile resource.
 */
export interface ProfileArgs {
    /**
     * The number of seconds the vended session credentials are valid for. Defaults to 3600.
     */
    durationSeconds?: pulumi.Input<number>;
    /**
     * Whether or not the Profile is enabled.
     */
    enabled?: pulumi.Input<boolean>;
    /**
     * A list of managed policy ARNs that apply to the vended session credentials.
     */
    managedPolicyArns?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * The name of the Profile.
     */
    name?: pulumi.Input<string>;
    /**
     * Specifies whether instance properties are required in [CreateSession](https://docs.aws.amazon.com/rolesanywhere/latest/APIReference/API_CreateSession.html) requests with this profile.
     */
    requireInstanceProperties?: pulumi.Input<boolean>;
    /**
     * A list of IAM roles that this profile can assume
     */
    roleArns?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * A session policy that applies to the trust boundary of the vended session credentials.
     */
    sessionPolicy?: pulumi.Input<string>;
    /**
     * A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
