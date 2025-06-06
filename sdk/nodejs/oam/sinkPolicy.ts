// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Resource for managing an AWS CloudWatch Observability Access Manager Sink Policy.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.oam.Sink("example", {name: "ExampleSink"});
 * const exampleSinkPolicy = new aws.oam.SinkPolicy("example", {
 *     sinkIdentifier: example.arn,
 *     policy: JSON.stringify({
 *         Version: "2012-10-17",
 *         Statement: [{
 *             Action: [
 *                 "oam:CreateLink",
 *                 "oam:UpdateLink",
 *             ],
 *             Effect: "Allow",
 *             Resource: "*",
 *             Principal: {
 *                 AWS: [
 *                     "1111111111111",
 *                     "222222222222",
 *                 ],
 *             },
 *             Condition: {
 *                 "ForAllValues:StringEquals": {
 *                     "oam:ResourceTypes": [
 *                         "AWS::CloudWatch::Metric",
 *                         "AWS::Logs::LogGroup",
 *                     ],
 *                 },
 *             },
 *         }],
 *     }),
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import CloudWatch Observability Access Manager Sink Policy using the `sink_identifier`. For example:
 *
 * ```sh
 * $ pulumi import aws:oam/sinkPolicy:SinkPolicy example arn:aws:oam:us-west-2:123456789012:sink/sink-id
 * ```
 */
export class SinkPolicy extends pulumi.CustomResource {
    /**
     * Get an existing SinkPolicy resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: SinkPolicyState, opts?: pulumi.CustomResourceOptions): SinkPolicy {
        return new SinkPolicy(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:oam/sinkPolicy:SinkPolicy';

    /**
     * Returns true if the given object is an instance of SinkPolicy.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is SinkPolicy {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === SinkPolicy.__pulumiType;
    }

    /**
     * ARN of the Sink.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * JSON policy to use. If you are updating an existing policy, the entire existing policy is replaced by what you specify here.
     */
    public readonly policy!: pulumi.Output<string>;
    /**
     * ID string that AWS generated as part of the sink ARN.
     */
    public /*out*/ readonly sinkId!: pulumi.Output<string>;
    /**
     * ARN of the sink to attach this policy to.
     */
    public readonly sinkIdentifier!: pulumi.Output<string>;

    /**
     * Create a SinkPolicy resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: SinkPolicyArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: SinkPolicyArgs | SinkPolicyState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as SinkPolicyState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["policy"] = state ? state.policy : undefined;
            resourceInputs["sinkId"] = state ? state.sinkId : undefined;
            resourceInputs["sinkIdentifier"] = state ? state.sinkIdentifier : undefined;
        } else {
            const args = argsOrState as SinkPolicyArgs | undefined;
            if ((!args || args.policy === undefined) && !opts.urn) {
                throw new Error("Missing required property 'policy'");
            }
            if ((!args || args.sinkIdentifier === undefined) && !opts.urn) {
                throw new Error("Missing required property 'sinkIdentifier'");
            }
            resourceInputs["policy"] = args ? args.policy : undefined;
            resourceInputs["sinkIdentifier"] = args ? args.sinkIdentifier : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["sinkId"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(SinkPolicy.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering SinkPolicy resources.
 */
export interface SinkPolicyState {
    /**
     * ARN of the Sink.
     */
    arn?: pulumi.Input<string>;
    /**
     * JSON policy to use. If you are updating an existing policy, the entire existing policy is replaced by what you specify here.
     */
    policy?: pulumi.Input<string>;
    /**
     * ID string that AWS generated as part of the sink ARN.
     */
    sinkId?: pulumi.Input<string>;
    /**
     * ARN of the sink to attach this policy to.
     */
    sinkIdentifier?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a SinkPolicy resource.
 */
export interface SinkPolicyArgs {
    /**
     * JSON policy to use. If you are updating an existing policy, the entire existing policy is replaced by what you specify here.
     */
    policy: pulumi.Input<string>;
    /**
     * ARN of the sink to attach this policy to.
     */
    sinkIdentifier: pulumi.Input<string>;
}
