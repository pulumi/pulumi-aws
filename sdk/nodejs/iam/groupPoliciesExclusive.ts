// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * ## Import
 *
 * Using `pulumi import`, import exclusive management of inline policy assignments using the `group_name`. For example:
 *
 * ```sh
 * $ pulumi import aws:iam/groupPoliciesExclusive:GroupPoliciesExclusive example MyGroup
 * ```
 */
export class GroupPoliciesExclusive extends pulumi.CustomResource {
    /**
     * Get an existing GroupPoliciesExclusive resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: GroupPoliciesExclusiveState, opts?: pulumi.CustomResourceOptions): GroupPoliciesExclusive {
        return new GroupPoliciesExclusive(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:iam/groupPoliciesExclusive:GroupPoliciesExclusive';

    /**
     * Returns true if the given object is an instance of GroupPoliciesExclusive.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is GroupPoliciesExclusive {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === GroupPoliciesExclusive.__pulumiType;
    }

    /**
     * IAM group name.
     */
    public readonly groupName!: pulumi.Output<string>;
    /**
     * A list of inline policy names to be assigned to the group. Policies attached to this group but not configured in this argument will be removed.
     */
    public readonly policyNames!: pulumi.Output<string[]>;

    /**
     * Create a GroupPoliciesExclusive resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: GroupPoliciesExclusiveArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: GroupPoliciesExclusiveArgs | GroupPoliciesExclusiveState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as GroupPoliciesExclusiveState | undefined;
            resourceInputs["groupName"] = state ? state.groupName : undefined;
            resourceInputs["policyNames"] = state ? state.policyNames : undefined;
        } else {
            const args = argsOrState as GroupPoliciesExclusiveArgs | undefined;
            if ((!args || args.groupName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'groupName'");
            }
            if ((!args || args.policyNames === undefined) && !opts.urn) {
                throw new Error("Missing required property 'policyNames'");
            }
            resourceInputs["groupName"] = args ? args.groupName : undefined;
            resourceInputs["policyNames"] = args ? args.policyNames : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(GroupPoliciesExclusive.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering GroupPoliciesExclusive resources.
 */
export interface GroupPoliciesExclusiveState {
    /**
     * IAM group name.
     */
    groupName?: pulumi.Input<string>;
    /**
     * A list of inline policy names to be assigned to the group. Policies attached to this group but not configured in this argument will be removed.
     */
    policyNames?: pulumi.Input<pulumi.Input<string>[]>;
}

/**
 * The set of arguments for constructing a GroupPoliciesExclusive resource.
 */
export interface GroupPoliciesExclusiveArgs {
    /**
     * IAM group name.
     */
    groupName: pulumi.Input<string>;
    /**
     * A list of inline policy names to be assigned to the group. Policies attached to this group but not configured in this argument will be removed.
     */
    policyNames: pulumi.Input<pulumi.Input<string>[]>;
}
