// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

import {ARN} from "..";
import {Group} from "./index";

/**
 * Attaches a Managed IAM Policy to an IAM group
 *
 * > **NOTE:** The usage of this resource conflicts with the `aws.iam.PolicyAttachment` resource and will permanently show a difference if both are defined.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const group = new aws.iam.Group("group", {name: "test-group"});
 * const policy = new aws.iam.Policy("policy", {
 *     name: "test-policy",
 *     description: "A test policy",
 *     policy: "{ ... policy JSON ... }",
 * });
 * const test_attach = new aws.iam.GroupPolicyAttachment("test-attach", {
 *     group: group.name,
 *     policyArn: policy.arn,
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import IAM group policy attachments using the group name and policy arn separated by `/`. For example:
 *
 * ```sh
 * $ pulumi import aws:iam/groupPolicyAttachment:GroupPolicyAttachment test-attach test-group/arn:aws:iam::xxxxxxxxxxxx:policy/test-policy
 * ```
 */
export class GroupPolicyAttachment extends pulumi.CustomResource {
    /**
     * Get an existing GroupPolicyAttachment resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: GroupPolicyAttachmentState, opts?: pulumi.CustomResourceOptions): GroupPolicyAttachment {
        return new GroupPolicyAttachment(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:iam/groupPolicyAttachment:GroupPolicyAttachment';

    /**
     * Returns true if the given object is an instance of GroupPolicyAttachment.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is GroupPolicyAttachment {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === GroupPolicyAttachment.__pulumiType;
    }

    /**
     * The group the policy should be applied to
     */
    public readonly group!: pulumi.Output<string>;
    /**
     * The ARN of the policy you want to apply
     */
    public readonly policyArn!: pulumi.Output<ARN>;

    /**
     * Create a GroupPolicyAttachment resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: GroupPolicyAttachmentArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: GroupPolicyAttachmentArgs | GroupPolicyAttachmentState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as GroupPolicyAttachmentState | undefined;
            resourceInputs["group"] = state ? state.group : undefined;
            resourceInputs["policyArn"] = state ? state.policyArn : undefined;
        } else {
            const args = argsOrState as GroupPolicyAttachmentArgs | undefined;
            if ((!args || args.group === undefined) && !opts.urn) {
                throw new Error("Missing required property 'group'");
            }
            if ((!args || args.policyArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'policyArn'");
            }
            resourceInputs["group"] = args ? args.group : undefined;
            resourceInputs["policyArn"] = args ? args.policyArn : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(GroupPolicyAttachment.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering GroupPolicyAttachment resources.
 */
export interface GroupPolicyAttachmentState {
    /**
     * The group the policy should be applied to
     */
    group?: pulumi.Input<string | Group>;
    /**
     * The ARN of the policy you want to apply
     */
    policyArn?: pulumi.Input<ARN>;
}

/**
 * The set of arguments for constructing a GroupPolicyAttachment resource.
 */
export interface GroupPolicyAttachmentArgs {
    /**
     * The group the policy should be applied to
     */
    group: pulumi.Input<string | Group>;
    /**
     * The ARN of the policy you want to apply
     */
    policyArn: pulumi.Input<ARN>;
}
