// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

import {PolicyDocument} from "../iam";

/**
 * Provides an Elastic Container Registry Policy.
 *
 * > **NOTE on ECR Registry Policies:** While the AWS Management Console interface may suggest the ability to define multiple policies by creating multiple statements, ECR registry policies are effectively managed as singular entities at the regional level by the AWS APIs. Therefore, the `aws.ecr.RegistryPolicy` resource should be configured only once per region with all necessary statements defined in the same policy. Attempting to define multiple `aws.ecr.RegistryPolicy` resources may result in perpetual differences, with one policy overriding another.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const current = aws.getCallerIdentity({});
 * const currentGetRegion = aws.getRegion({});
 * const currentGetPartition = aws.getPartition({});
 * const example = new aws.ecr.RegistryPolicy("example", {policy: JSON.stringify({
 *     Version: "2012-10-17",
 *     Statement: [{
 *         Sid: "testpolicy",
 *         Effect: "Allow",
 *         Principal: {
 *             AWS: Promise.all([currentGetPartition, current]).then(([currentGetPartition, current]) => `arn:${currentGetPartition.partition}:iam::${current.accountId}:root`),
 *         },
 *         Action: ["ecr:ReplicateImage"],
 *         Resource: [Promise.all([currentGetPartition, currentGetRegion, current]).then(([currentGetPartition, currentGetRegion, current]) => `arn:${currentGetPartition.partition}:ecr:${currentGetRegion.name}:${current.accountId}:repository/*`)],
 *     }],
 * })});
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import ECR Registry Policy using the registry id. For example:
 *
 * ```sh
 * $ pulumi import aws:ecr/registryPolicy:RegistryPolicy example 123456789012
 * ```
 */
export class RegistryPolicy extends pulumi.CustomResource {
    /**
     * Get an existing RegistryPolicy resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: RegistryPolicyState, opts?: pulumi.CustomResourceOptions): RegistryPolicy {
        return new RegistryPolicy(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ecr/registryPolicy:RegistryPolicy';

    /**
     * Returns true if the given object is an instance of RegistryPolicy.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is RegistryPolicy {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === RegistryPolicy.__pulumiType;
    }

    /**
     * The policy document. This is a JSON formatted string.
     */
    public readonly policy!: pulumi.Output<string>;
    /**
     * The registry ID where the registry was created.
     */
    public /*out*/ readonly registryId!: pulumi.Output<string>;

    /**
     * Create a RegistryPolicy resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: RegistryPolicyArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: RegistryPolicyArgs | RegistryPolicyState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as RegistryPolicyState | undefined;
            resourceInputs["policy"] = state ? state.policy : undefined;
            resourceInputs["registryId"] = state ? state.registryId : undefined;
        } else {
            const args = argsOrState as RegistryPolicyArgs | undefined;
            if ((!args || args.policy === undefined) && !opts.urn) {
                throw new Error("Missing required property 'policy'");
            }
            resourceInputs["policy"] = args ? args.policy : undefined;
            resourceInputs["registryId"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(RegistryPolicy.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering RegistryPolicy resources.
 */
export interface RegistryPolicyState {
    /**
     * The policy document. This is a JSON formatted string.
     */
    policy?: pulumi.Input<string | PolicyDocument>;
    /**
     * The registry ID where the registry was created.
     */
    registryId?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a RegistryPolicy resource.
 */
export interface RegistryPolicyArgs {
    /**
     * The policy document. This is a JSON formatted string.
     */
    policy: pulumi.Input<string | PolicyDocument>;
}
