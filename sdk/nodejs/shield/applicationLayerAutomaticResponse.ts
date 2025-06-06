// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Resource for managing an AWS Shield Application Layer Automatic Response for automatic DDoS mitigation.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const current = aws.getRegion({});
 * const currentGetCallerIdentity = aws.getCallerIdentity({});
 * const currentGetPartition = aws.getPartition({});
 * const config = new pulumi.Config();
 * // The Cloudfront Distribution on which to enable the Application Layer Automatic Response.
 * const distributionId = config.require("distributionId");
 * const example = new aws.shield.ApplicationLayerAutomaticResponse("example", {
 *     resourceArn: Promise.all([currentGetPartition, currentGetCallerIdentity]).then(([currentGetPartition, currentGetCallerIdentity]) => `arn:${currentGetPartition.partition}:cloudfront:${currentGetCallerIdentity.accountId}:distribution/${distributionId}`),
 *     action: "COUNT",
 * });
 * ```
 */
export class ApplicationLayerAutomaticResponse extends pulumi.CustomResource {
    /**
     * Get an existing ApplicationLayerAutomaticResponse resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ApplicationLayerAutomaticResponseState, opts?: pulumi.CustomResourceOptions): ApplicationLayerAutomaticResponse {
        return new ApplicationLayerAutomaticResponse(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:shield/applicationLayerAutomaticResponse:ApplicationLayerAutomaticResponse';

    /**
     * Returns true if the given object is an instance of ApplicationLayerAutomaticResponse.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is ApplicationLayerAutomaticResponse {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === ApplicationLayerAutomaticResponse.__pulumiType;
    }

    /**
     * One of `COUNT` or `BLOCK`
     */
    public readonly action!: pulumi.Output<string>;
    /**
     * ARN of the resource to protect (Cloudfront Distributions and ALBs only at this time).
     */
    public readonly resourceArn!: pulumi.Output<string>;
    public readonly timeouts!: pulumi.Output<outputs.shield.ApplicationLayerAutomaticResponseTimeouts | undefined>;

    /**
     * Create a ApplicationLayerAutomaticResponse resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: ApplicationLayerAutomaticResponseArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ApplicationLayerAutomaticResponseArgs | ApplicationLayerAutomaticResponseState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ApplicationLayerAutomaticResponseState | undefined;
            resourceInputs["action"] = state ? state.action : undefined;
            resourceInputs["resourceArn"] = state ? state.resourceArn : undefined;
            resourceInputs["timeouts"] = state ? state.timeouts : undefined;
        } else {
            const args = argsOrState as ApplicationLayerAutomaticResponseArgs | undefined;
            if ((!args || args.action === undefined) && !opts.urn) {
                throw new Error("Missing required property 'action'");
            }
            if ((!args || args.resourceArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'resourceArn'");
            }
            resourceInputs["action"] = args ? args.action : undefined;
            resourceInputs["resourceArn"] = args ? args.resourceArn : undefined;
            resourceInputs["timeouts"] = args ? args.timeouts : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(ApplicationLayerAutomaticResponse.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering ApplicationLayerAutomaticResponse resources.
 */
export interface ApplicationLayerAutomaticResponseState {
    /**
     * One of `COUNT` or `BLOCK`
     */
    action?: pulumi.Input<string>;
    /**
     * ARN of the resource to protect (Cloudfront Distributions and ALBs only at this time).
     */
    resourceArn?: pulumi.Input<string>;
    timeouts?: pulumi.Input<inputs.shield.ApplicationLayerAutomaticResponseTimeouts>;
}

/**
 * The set of arguments for constructing a ApplicationLayerAutomaticResponse resource.
 */
export interface ApplicationLayerAutomaticResponseArgs {
    /**
     * One of `COUNT` or `BLOCK`
     */
    action: pulumi.Input<string>;
    /**
     * ARN of the resource to protect (Cloudfront Distributions and ALBs only at this time).
     */
    resourceArn: pulumi.Input<string>;
    timeouts?: pulumi.Input<inputs.shield.ApplicationLayerAutomaticResponseTimeouts>;
}
