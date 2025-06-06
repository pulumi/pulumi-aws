// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides a resource to manage an [AWS Organizations policy](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_policies.html).
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.iam.getPolicyDocument({
 *     statements: [{
 *         effect: "Allow",
 *         actions: ["*"],
 *         resources: ["*"],
 *     }],
 * });
 * const examplePolicy = new aws.organizations.Policy("example", {
 *     name: "example",
 *     content: example.then(example => example.json),
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import `aws_organizations_policy` using the policy ID. For example:
 *
 * ```sh
 * $ pulumi import aws:organizations/policy:Policy example p-12345678
 * ```
 */
export class Policy extends pulumi.CustomResource {
    /**
     * Get an existing Policy resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: PolicyState, opts?: pulumi.CustomResourceOptions): Policy {
        return new Policy(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:organizations/policy:Policy';

    /**
     * Returns true if the given object is an instance of Policy.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Policy {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Policy.__pulumiType;
    }

    /**
     * Amazon Resource Name (ARN) of the policy.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * The policy content to add to the new policy.
     * For example, if you create a [service control policy (SCP)](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_policies_scp.html), this string must be JSON text that specifies the permissions that admins in attached accounts can delegate to their users, groups, and roles.
     * For more information about the RCP syntax, see the [Resource Control Policy Syntax documentation](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_policies_rcps_syntax.html).
     * For more information about the SCP syntax, see the [Service Control Policy Syntax documentation](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_reference_scp-syntax.html).
     * For more information on the Tag Policy syntax, see the [Tag Policy Syntax documentation](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_policies_example-tag-policies.html).
     */
    public readonly content!: pulumi.Output<string>;
    /**
     * A description to assign to the policy.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * The friendly name to assign to the policy.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * If set to `true`, destroy will **not** delete the policy and instead just remove the resource from state. This can be useful in situations where the policies (and the associated attachment) must be preserved to meet the AWS minimum requirement of 1 attached policy.
     */
    public readonly skipDestroy!: pulumi.Output<boolean | undefined>;
    /**
     * Key-value map of resource tags. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * The type of policy to create. Valid values are `AISERVICES_OPT_OUT_POLICY`, `BACKUP_POLICY`, `RESOURCE_CONTROL_POLICY` (RCP), `SERVICE_CONTROL_POLICY` (SCP), and `TAG_POLICY`. Defaults to `SERVICE_CONTROL_POLICY`.
     */
    public readonly type!: pulumi.Output<string | undefined>;

    /**
     * Create a Policy resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: PolicyArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: PolicyArgs | PolicyState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as PolicyState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["content"] = state ? state.content : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["skipDestroy"] = state ? state.skipDestroy : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["type"] = state ? state.type : undefined;
        } else {
            const args = argsOrState as PolicyArgs | undefined;
            if ((!args || args.content === undefined) && !opts.urn) {
                throw new Error("Missing required property 'content'");
            }
            resourceInputs["content"] = args ? args.content : undefined;
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["skipDestroy"] = args ? args.skipDestroy : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["type"] = args ? args.type : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Policy.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Policy resources.
 */
export interface PolicyState {
    /**
     * Amazon Resource Name (ARN) of the policy.
     */
    arn?: pulumi.Input<string>;
    /**
     * The policy content to add to the new policy.
     * For example, if you create a [service control policy (SCP)](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_policies_scp.html), this string must be JSON text that specifies the permissions that admins in attached accounts can delegate to their users, groups, and roles.
     * For more information about the RCP syntax, see the [Resource Control Policy Syntax documentation](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_policies_rcps_syntax.html).
     * For more information about the SCP syntax, see the [Service Control Policy Syntax documentation](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_reference_scp-syntax.html).
     * For more information on the Tag Policy syntax, see the [Tag Policy Syntax documentation](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_policies_example-tag-policies.html).
     */
    content?: pulumi.Input<string>;
    /**
     * A description to assign to the policy.
     */
    description?: pulumi.Input<string>;
    /**
     * The friendly name to assign to the policy.
     */
    name?: pulumi.Input<string>;
    /**
     * If set to `true`, destroy will **not** delete the policy and instead just remove the resource from state. This can be useful in situations where the policies (and the associated attachment) must be preserved to meet the AWS minimum requirement of 1 attached policy.
     */
    skipDestroy?: pulumi.Input<boolean>;
    /**
     * Key-value map of resource tags. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * The type of policy to create. Valid values are `AISERVICES_OPT_OUT_POLICY`, `BACKUP_POLICY`, `RESOURCE_CONTROL_POLICY` (RCP), `SERVICE_CONTROL_POLICY` (SCP), and `TAG_POLICY`. Defaults to `SERVICE_CONTROL_POLICY`.
     */
    type?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a Policy resource.
 */
export interface PolicyArgs {
    /**
     * The policy content to add to the new policy.
     * For example, if you create a [service control policy (SCP)](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_policies_scp.html), this string must be JSON text that specifies the permissions that admins in attached accounts can delegate to their users, groups, and roles.
     * For more information about the RCP syntax, see the [Resource Control Policy Syntax documentation](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_policies_rcps_syntax.html).
     * For more information about the SCP syntax, see the [Service Control Policy Syntax documentation](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_reference_scp-syntax.html).
     * For more information on the Tag Policy syntax, see the [Tag Policy Syntax documentation](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_policies_example-tag-policies.html).
     */
    content: pulumi.Input<string>;
    /**
     * A description to assign to the policy.
     */
    description?: pulumi.Input<string>;
    /**
     * The friendly name to assign to the policy.
     */
    name?: pulumi.Input<string>;
    /**
     * If set to `true`, destroy will **not** delete the policy and instead just remove the resource from state. This can be useful in situations where the policies (and the associated attachment) must be preserved to meet the AWS minimum requirement of 1 attached policy.
     */
    skipDestroy?: pulumi.Input<boolean>;
    /**
     * Key-value map of resource tags. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * The type of policy to create. Valid values are `AISERVICES_OPT_OUT_POLICY`, `BACKUP_POLICY`, `RESOURCE_CONTROL_POLICY` (RCP), `SERVICE_CONTROL_POLICY` (SCP), and `TAG_POLICY`. Defaults to `SERVICE_CONTROL_POLICY`.
     */
    type?: pulumi.Input<string>;
}
