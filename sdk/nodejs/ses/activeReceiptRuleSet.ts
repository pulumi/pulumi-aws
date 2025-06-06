// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides a resource to designate the active SES receipt rule set
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const main = new aws.ses.ActiveReceiptRuleSet("main", {ruleSetName: "primary-rules"});
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import active SES receipt rule sets using the rule set name. For example:
 *
 * ```sh
 * $ pulumi import aws:ses/activeReceiptRuleSet:ActiveReceiptRuleSet my_rule_set my_rule_set_name
 * ```
 */
export class ActiveReceiptRuleSet extends pulumi.CustomResource {
    /**
     * Get an existing ActiveReceiptRuleSet resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ActiveReceiptRuleSetState, opts?: pulumi.CustomResourceOptions): ActiveReceiptRuleSet {
        return new ActiveReceiptRuleSet(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ses/activeReceiptRuleSet:ActiveReceiptRuleSet';

    /**
     * Returns true if the given object is an instance of ActiveReceiptRuleSet.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is ActiveReceiptRuleSet {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === ActiveReceiptRuleSet.__pulumiType;
    }

    /**
     * The SES receipt rule set ARN.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * The name of the rule set
     */
    public readonly ruleSetName!: pulumi.Output<string>;

    /**
     * Create a ActiveReceiptRuleSet resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: ActiveReceiptRuleSetArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ActiveReceiptRuleSetArgs | ActiveReceiptRuleSetState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ActiveReceiptRuleSetState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["ruleSetName"] = state ? state.ruleSetName : undefined;
        } else {
            const args = argsOrState as ActiveReceiptRuleSetArgs | undefined;
            if ((!args || args.ruleSetName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'ruleSetName'");
            }
            resourceInputs["ruleSetName"] = args ? args.ruleSetName : undefined;
            resourceInputs["arn"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(ActiveReceiptRuleSet.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering ActiveReceiptRuleSet resources.
 */
export interface ActiveReceiptRuleSetState {
    /**
     * The SES receipt rule set ARN.
     */
    arn?: pulumi.Input<string>;
    /**
     * The name of the rule set
     */
    ruleSetName?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a ActiveReceiptRuleSet resource.
 */
export interface ActiveReceiptRuleSetArgs {
    /**
     * The name of the rule set
     */
    ruleSetName: pulumi.Input<string>;
}
