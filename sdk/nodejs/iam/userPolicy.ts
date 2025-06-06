// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

import {PolicyDocument} from "./index";

/**
 * Provides an IAM policy attached to a user.
 *
 * > **NOTE:** We suggest using explicit JSON encoding or `aws.iam.getPolicyDocument` when assigning a value to `policy`. They seamlessly translate configuration to JSON, enabling you to maintain consistency within your configuration without the need for context switches. Also, you can sidestep potential complications arising from formatting discrepancies, whitespace inconsistencies, and other nuances inherent to JSON.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const lb = new aws.iam.User("lb", {
 *     name: "loadbalancer",
 *     path: "/system/",
 * });
 * const lbRo = new aws.iam.UserPolicy("lb_ro", {
 *     name: "test",
 *     user: lb.name,
 *     policy: JSON.stringify({
 *         Version: "2012-10-17",
 *         Statement: [{
 *             Action: ["ec2:Describe*"],
 *             Effect: "Allow",
 *             Resource: "*",
 *         }],
 *     }),
 * });
 * const lbAccessKey = new aws.iam.AccessKey("lb", {user: lb.name});
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import IAM User Policies using the `user_name:user_policy_name`. For example:
 *
 * ```sh
 * $ pulumi import aws:iam/userPolicy:UserPolicy mypolicy user_of_mypolicy_name:mypolicy_name
 * ```
 */
export class UserPolicy extends pulumi.CustomResource {
    /**
     * Get an existing UserPolicy resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: UserPolicyState, opts?: pulumi.CustomResourceOptions): UserPolicy {
        return new UserPolicy(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:iam/userPolicy:UserPolicy';

    /**
     * Returns true if the given object is an instance of UserPolicy.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is UserPolicy {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === UserPolicy.__pulumiType;
    }

    /**
     * The name of the policy. If omitted, the provider will assign a random, unique name.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * Creates a unique name beginning with the specified prefix. Conflicts with `name`.
     */
    public readonly namePrefix!: pulumi.Output<string>;
    /**
     * The policy document. This is a JSON formatted string.
     */
    public readonly policy!: pulumi.Output<string>;
    /**
     * IAM user to which to attach this policy.
     */
    public readonly user!: pulumi.Output<string>;

    /**
     * Create a UserPolicy resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: UserPolicyArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: UserPolicyArgs | UserPolicyState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as UserPolicyState | undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["namePrefix"] = state ? state.namePrefix : undefined;
            resourceInputs["policy"] = state ? state.policy : undefined;
            resourceInputs["user"] = state ? state.user : undefined;
        } else {
            const args = argsOrState as UserPolicyArgs | undefined;
            if ((!args || args.policy === undefined) && !opts.urn) {
                throw new Error("Missing required property 'policy'");
            }
            if ((!args || args.user === undefined) && !opts.urn) {
                throw new Error("Missing required property 'user'");
            }
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["namePrefix"] = args ? args.namePrefix : undefined;
            resourceInputs["policy"] = args ? args.policy : undefined;
            resourceInputs["user"] = args ? args.user : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(UserPolicy.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering UserPolicy resources.
 */
export interface UserPolicyState {
    /**
     * The name of the policy. If omitted, the provider will assign a random, unique name.
     */
    name?: pulumi.Input<string>;
    /**
     * Creates a unique name beginning with the specified prefix. Conflicts with `name`.
     */
    namePrefix?: pulumi.Input<string>;
    /**
     * The policy document. This is a JSON formatted string.
     */
    policy?: pulumi.Input<string | PolicyDocument>;
    /**
     * IAM user to which to attach this policy.
     */
    user?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a UserPolicy resource.
 */
export interface UserPolicyArgs {
    /**
     * The name of the policy. If omitted, the provider will assign a random, unique name.
     */
    name?: pulumi.Input<string>;
    /**
     * Creates a unique name beginning with the specified prefix. Conflicts with `name`.
     */
    namePrefix?: pulumi.Input<string>;
    /**
     * The policy document. This is a JSON formatted string.
     */
    policy: pulumi.Input<string | PolicyDocument>;
    /**
     * IAM user to which to attach this policy.
     */
    user: pulumi.Input<string>;
}
