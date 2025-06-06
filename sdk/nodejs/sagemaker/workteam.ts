// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides a SageMaker AI Workteam resource.
 *
 * ## Example Usage
 *
 * ### Cognito Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.sagemaker.Workteam("example", {
 *     workteamName: "example",
 *     workforceName: exampleAwsSagemakerWorkforce.id,
 *     description: "example",
 *     memberDefinitions: [{
 *         cognitoMemberDefinition: {
 *             clientId: exampleAwsCognitoUserPoolClient.id,
 *             userPool: exampleAwsCognitoUserPoolDomain.userPoolId,
 *             userGroup: exampleAwsCognitoUserGroup.name,
 *         },
 *     }],
 * });
 * ```
 *
 * ### Oidc Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.sagemaker.Workteam("example", {
 *     workteamName: "example",
 *     workforceName: exampleAwsSagemakerWorkforce.id,
 *     description: "example",
 *     memberDefinitions: [{
 *         oidcMemberDefinition: {
 *             groups: ["example"],
 *         },
 *     }],
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import SageMaker AI Workteams using the `workteam_name`. For example:
 *
 * ```sh
 * $ pulumi import aws:sagemaker/workteam:Workteam example example
 * ```
 */
export class Workteam extends pulumi.CustomResource {
    /**
     * Get an existing Workteam resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: WorkteamState, opts?: pulumi.CustomResourceOptions): Workteam {
        return new Workteam(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:sagemaker/workteam:Workteam';

    /**
     * Returns true if the given object is an instance of Workteam.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Workteam {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Workteam.__pulumiType;
    }

    /**
     * The Amazon Resource Name (ARN) assigned by AWS to this Workteam.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * A description of the work team.
     */
    public readonly description!: pulumi.Output<string>;
    /**
     * A list of Member Definitions that contains objects that identify the workers that make up the work team. Workforces can be created using Amazon Cognito or your own OIDC Identity Provider (IdP). For private workforces created using Amazon Cognito use `cognitoMemberDefinition`. For workforces created using your own OIDC identity provider (IdP) use `oidcMemberDefinition`. Do not provide input for both of these parameters in a single request. see Member Definition details below.
     */
    public readonly memberDefinitions!: pulumi.Output<outputs.sagemaker.WorkteamMemberDefinition[]>;
    /**
     * Configures notification of workers regarding available or expiring work items. see Notification Configuration details below.
     */
    public readonly notificationConfiguration!: pulumi.Output<outputs.sagemaker.WorkteamNotificationConfiguration | undefined>;
    /**
     * The subdomain for your OIDC Identity Provider.
     */
    public /*out*/ readonly subdomain!: pulumi.Output<string>;
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
     * Use this optional parameter to constrain access to an Amazon S3 resource based on the IP address using supported IAM global condition keys. The Amazon S3 resource is accessed in the worker portal using a Amazon S3 presigned URL. see Worker Access Configuration details below.
     */
    public readonly workerAccessConfiguration!: pulumi.Output<outputs.sagemaker.WorkteamWorkerAccessConfiguration>;
    /**
     * The name of the workforce.
     */
    public readonly workforceName!: pulumi.Output<string | undefined>;
    /**
     * The name of the Workteam (must be unique).
     */
    public readonly workteamName!: pulumi.Output<string>;

    /**
     * Create a Workteam resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: WorkteamArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: WorkteamArgs | WorkteamState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as WorkteamState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["memberDefinitions"] = state ? state.memberDefinitions : undefined;
            resourceInputs["notificationConfiguration"] = state ? state.notificationConfiguration : undefined;
            resourceInputs["subdomain"] = state ? state.subdomain : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["workerAccessConfiguration"] = state ? state.workerAccessConfiguration : undefined;
            resourceInputs["workforceName"] = state ? state.workforceName : undefined;
            resourceInputs["workteamName"] = state ? state.workteamName : undefined;
        } else {
            const args = argsOrState as WorkteamArgs | undefined;
            if ((!args || args.description === undefined) && !opts.urn) {
                throw new Error("Missing required property 'description'");
            }
            if ((!args || args.memberDefinitions === undefined) && !opts.urn) {
                throw new Error("Missing required property 'memberDefinitions'");
            }
            if ((!args || args.workteamName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'workteamName'");
            }
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["memberDefinitions"] = args ? args.memberDefinitions : undefined;
            resourceInputs["notificationConfiguration"] = args ? args.notificationConfiguration : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["workerAccessConfiguration"] = args ? args.workerAccessConfiguration : undefined;
            resourceInputs["workforceName"] = args ? args.workforceName : undefined;
            resourceInputs["workteamName"] = args ? args.workteamName : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["subdomain"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Workteam.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Workteam resources.
 */
export interface WorkteamState {
    /**
     * The Amazon Resource Name (ARN) assigned by AWS to this Workteam.
     */
    arn?: pulumi.Input<string>;
    /**
     * A description of the work team.
     */
    description?: pulumi.Input<string>;
    /**
     * A list of Member Definitions that contains objects that identify the workers that make up the work team. Workforces can be created using Amazon Cognito or your own OIDC Identity Provider (IdP). For private workforces created using Amazon Cognito use `cognitoMemberDefinition`. For workforces created using your own OIDC identity provider (IdP) use `oidcMemberDefinition`. Do not provide input for both of these parameters in a single request. see Member Definition details below.
     */
    memberDefinitions?: pulumi.Input<pulumi.Input<inputs.sagemaker.WorkteamMemberDefinition>[]>;
    /**
     * Configures notification of workers regarding available or expiring work items. see Notification Configuration details below.
     */
    notificationConfiguration?: pulumi.Input<inputs.sagemaker.WorkteamNotificationConfiguration>;
    /**
     * The subdomain for your OIDC Identity Provider.
     */
    subdomain?: pulumi.Input<string>;
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
    /**
     * Use this optional parameter to constrain access to an Amazon S3 resource based on the IP address using supported IAM global condition keys. The Amazon S3 resource is accessed in the worker portal using a Amazon S3 presigned URL. see Worker Access Configuration details below.
     */
    workerAccessConfiguration?: pulumi.Input<inputs.sagemaker.WorkteamWorkerAccessConfiguration>;
    /**
     * The name of the workforce.
     */
    workforceName?: pulumi.Input<string>;
    /**
     * The name of the Workteam (must be unique).
     */
    workteamName?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a Workteam resource.
 */
export interface WorkteamArgs {
    /**
     * A description of the work team.
     */
    description: pulumi.Input<string>;
    /**
     * A list of Member Definitions that contains objects that identify the workers that make up the work team. Workforces can be created using Amazon Cognito or your own OIDC Identity Provider (IdP). For private workforces created using Amazon Cognito use `cognitoMemberDefinition`. For workforces created using your own OIDC identity provider (IdP) use `oidcMemberDefinition`. Do not provide input for both of these parameters in a single request. see Member Definition details below.
     */
    memberDefinitions: pulumi.Input<pulumi.Input<inputs.sagemaker.WorkteamMemberDefinition>[]>;
    /**
     * Configures notification of workers regarding available or expiring work items. see Notification Configuration details below.
     */
    notificationConfiguration?: pulumi.Input<inputs.sagemaker.WorkteamNotificationConfiguration>;
    /**
     * A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Use this optional parameter to constrain access to an Amazon S3 resource based on the IP address using supported IAM global condition keys. The Amazon S3 resource is accessed in the worker portal using a Amazon S3 presigned URL. see Worker Access Configuration details below.
     */
    workerAccessConfiguration?: pulumi.Input<inputs.sagemaker.WorkteamWorkerAccessConfiguration>;
    /**
     * The name of the workforce.
     */
    workforceName?: pulumi.Input<string>;
    /**
     * The name of the Workteam (must be unique).
     */
    workteamName: pulumi.Input<string>;
}
