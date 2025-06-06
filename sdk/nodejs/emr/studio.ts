// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides an Elastic MapReduce Studio.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.emr.Studio("example", {
 *     authMode: "SSO",
 *     defaultS3Location: `s3://${test.bucket}/test`,
 *     engineSecurityGroupId: testAwsSecurityGroup.id,
 *     name: "example",
 *     serviceRole: testAwsIamRole.arn,
 *     subnetIds: [testAwsSubnet.id],
 *     userRole: testAwsIamRole.arn,
 *     vpcId: testAwsVpc.id,
 *     workspaceSecurityGroupId: testAwsSecurityGroup.id,
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import EMR studios using the `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:emr/studio:Studio studio es-123456ABCDEF
 * ```
 */
export class Studio extends pulumi.CustomResource {
    /**
     * Get an existing Studio resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: StudioState, opts?: pulumi.CustomResourceOptions): Studio {
        return new Studio(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:emr/studio:Studio';

    /**
     * Returns true if the given object is an instance of Studio.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Studio {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Studio.__pulumiType;
    }

    /**
     * ARN of the studio.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * Specifies whether the Studio authenticates users using IAM or Amazon Web Services SSO. Valid values are `SSO` or `IAM`.
     */
    public readonly authMode!: pulumi.Output<string>;
    /**
     * The Amazon S3 location to back up Amazon EMR Studio Workspaces and notebook files.
     */
    public readonly defaultS3Location!: pulumi.Output<string>;
    /**
     * A detailed description of the Amazon EMR Studio.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * The AWS KMS key identifier (ARN) used to encrypt Amazon EMR Studio workspace and notebook files when backed up to Amazon S3.
     */
    public readonly encryptionKeyArn!: pulumi.Output<string | undefined>;
    /**
     * The ID of the Amazon EMR Studio Engine security group. The Engine security group allows inbound network traffic from the Workspace security group, and it must be in the same VPC specified by `vpcId`.
     */
    public readonly engineSecurityGroupId!: pulumi.Output<string>;
    /**
     * The authentication endpoint of your identity provider (IdP). Specify this value when you use IAM authentication and want to let federated users log in to a Studio with the Studio URL and credentials from your IdP. Amazon EMR Studio redirects users to this endpoint to enter credentials.
     */
    public readonly idpAuthUrl!: pulumi.Output<string | undefined>;
    /**
     * The name that your identity provider (IdP) uses for its RelayState parameter. For example, RelayState or TargetSource. Specify this value when you use IAM authentication and want to let federated users log in to a Studio using the Studio URL. The RelayState parameter differs by IdP.
     */
    public readonly idpRelayStateParameterName!: pulumi.Output<string | undefined>;
    /**
     * A descriptive name for the Amazon EMR Studio.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * The IAM role that the Amazon EMR Studio assumes. The service role provides a way for Amazon EMR Studio to interoperate with other Amazon Web Services services.
     */
    public readonly serviceRole!: pulumi.Output<string>;
    /**
     * A list of subnet IDs to associate with the Amazon EMR Studio. A Studio can have a maximum of 5 subnets. The subnets must belong to the VPC specified by `vpcId`. Studio users can create a Workspace in any of the specified subnets.
     */
    public readonly subnetIds!: pulumi.Output<string[]>;
    /**
     * list of tags to apply to the EMR Cluster. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * The unique access URL of the Amazon EMR Studio.
     */
    public /*out*/ readonly url!: pulumi.Output<string>;
    /**
     * The IAM user role that users and groups assume when logged in to an Amazon EMR Studio. Only specify a User Role when you use Amazon Web Services SSO authentication. The permissions attached to the User Role can be scoped down for each user or group using session policies.
     */
    public readonly userRole!: pulumi.Output<string | undefined>;
    /**
     * The ID of the Amazon Virtual Private Cloud (Amazon VPC) to associate with the Studio.
     */
    public readonly vpcId!: pulumi.Output<string>;
    /**
     * The ID of the Amazon EMR Studio Workspace security group. The Workspace security group allows outbound network traffic to resources in the Engine security group, and it must be in the same VPC specified by `vpcId`.
     *
     * The following arguments are optional:
     */
    public readonly workspaceSecurityGroupId!: pulumi.Output<string>;

    /**
     * Create a Studio resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: StudioArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: StudioArgs | StudioState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as StudioState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["authMode"] = state ? state.authMode : undefined;
            resourceInputs["defaultS3Location"] = state ? state.defaultS3Location : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["encryptionKeyArn"] = state ? state.encryptionKeyArn : undefined;
            resourceInputs["engineSecurityGroupId"] = state ? state.engineSecurityGroupId : undefined;
            resourceInputs["idpAuthUrl"] = state ? state.idpAuthUrl : undefined;
            resourceInputs["idpRelayStateParameterName"] = state ? state.idpRelayStateParameterName : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["serviceRole"] = state ? state.serviceRole : undefined;
            resourceInputs["subnetIds"] = state ? state.subnetIds : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["url"] = state ? state.url : undefined;
            resourceInputs["userRole"] = state ? state.userRole : undefined;
            resourceInputs["vpcId"] = state ? state.vpcId : undefined;
            resourceInputs["workspaceSecurityGroupId"] = state ? state.workspaceSecurityGroupId : undefined;
        } else {
            const args = argsOrState as StudioArgs | undefined;
            if ((!args || args.authMode === undefined) && !opts.urn) {
                throw new Error("Missing required property 'authMode'");
            }
            if ((!args || args.defaultS3Location === undefined) && !opts.urn) {
                throw new Error("Missing required property 'defaultS3Location'");
            }
            if ((!args || args.engineSecurityGroupId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'engineSecurityGroupId'");
            }
            if ((!args || args.serviceRole === undefined) && !opts.urn) {
                throw new Error("Missing required property 'serviceRole'");
            }
            if ((!args || args.subnetIds === undefined) && !opts.urn) {
                throw new Error("Missing required property 'subnetIds'");
            }
            if ((!args || args.vpcId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'vpcId'");
            }
            if ((!args || args.workspaceSecurityGroupId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'workspaceSecurityGroupId'");
            }
            resourceInputs["authMode"] = args ? args.authMode : undefined;
            resourceInputs["defaultS3Location"] = args ? args.defaultS3Location : undefined;
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["encryptionKeyArn"] = args ? args.encryptionKeyArn : undefined;
            resourceInputs["engineSecurityGroupId"] = args ? args.engineSecurityGroupId : undefined;
            resourceInputs["idpAuthUrl"] = args ? args.idpAuthUrl : undefined;
            resourceInputs["idpRelayStateParameterName"] = args ? args.idpRelayStateParameterName : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["serviceRole"] = args ? args.serviceRole : undefined;
            resourceInputs["subnetIds"] = args ? args.subnetIds : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["userRole"] = args ? args.userRole : undefined;
            resourceInputs["vpcId"] = args ? args.vpcId : undefined;
            resourceInputs["workspaceSecurityGroupId"] = args ? args.workspaceSecurityGroupId : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
            resourceInputs["url"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Studio.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Studio resources.
 */
export interface StudioState {
    /**
     * ARN of the studio.
     */
    arn?: pulumi.Input<string>;
    /**
     * Specifies whether the Studio authenticates users using IAM or Amazon Web Services SSO. Valid values are `SSO` or `IAM`.
     */
    authMode?: pulumi.Input<string>;
    /**
     * The Amazon S3 location to back up Amazon EMR Studio Workspaces and notebook files.
     */
    defaultS3Location?: pulumi.Input<string>;
    /**
     * A detailed description of the Amazon EMR Studio.
     */
    description?: pulumi.Input<string>;
    /**
     * The AWS KMS key identifier (ARN) used to encrypt Amazon EMR Studio workspace and notebook files when backed up to Amazon S3.
     */
    encryptionKeyArn?: pulumi.Input<string>;
    /**
     * The ID of the Amazon EMR Studio Engine security group. The Engine security group allows inbound network traffic from the Workspace security group, and it must be in the same VPC specified by `vpcId`.
     */
    engineSecurityGroupId?: pulumi.Input<string>;
    /**
     * The authentication endpoint of your identity provider (IdP). Specify this value when you use IAM authentication and want to let federated users log in to a Studio with the Studio URL and credentials from your IdP. Amazon EMR Studio redirects users to this endpoint to enter credentials.
     */
    idpAuthUrl?: pulumi.Input<string>;
    /**
     * The name that your identity provider (IdP) uses for its RelayState parameter. For example, RelayState or TargetSource. Specify this value when you use IAM authentication and want to let federated users log in to a Studio using the Studio URL. The RelayState parameter differs by IdP.
     */
    idpRelayStateParameterName?: pulumi.Input<string>;
    /**
     * A descriptive name for the Amazon EMR Studio.
     */
    name?: pulumi.Input<string>;
    /**
     * The IAM role that the Amazon EMR Studio assumes. The service role provides a way for Amazon EMR Studio to interoperate with other Amazon Web Services services.
     */
    serviceRole?: pulumi.Input<string>;
    /**
     * A list of subnet IDs to associate with the Amazon EMR Studio. A Studio can have a maximum of 5 subnets. The subnets must belong to the VPC specified by `vpcId`. Studio users can create a Workspace in any of the specified subnets.
     */
    subnetIds?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * list of tags to apply to the EMR Cluster. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * The unique access URL of the Amazon EMR Studio.
     */
    url?: pulumi.Input<string>;
    /**
     * The IAM user role that users and groups assume when logged in to an Amazon EMR Studio. Only specify a User Role when you use Amazon Web Services SSO authentication. The permissions attached to the User Role can be scoped down for each user or group using session policies.
     */
    userRole?: pulumi.Input<string>;
    /**
     * The ID of the Amazon Virtual Private Cloud (Amazon VPC) to associate with the Studio.
     */
    vpcId?: pulumi.Input<string>;
    /**
     * The ID of the Amazon EMR Studio Workspace security group. The Workspace security group allows outbound network traffic to resources in the Engine security group, and it must be in the same VPC specified by `vpcId`.
     *
     * The following arguments are optional:
     */
    workspaceSecurityGroupId?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a Studio resource.
 */
export interface StudioArgs {
    /**
     * Specifies whether the Studio authenticates users using IAM or Amazon Web Services SSO. Valid values are `SSO` or `IAM`.
     */
    authMode: pulumi.Input<string>;
    /**
     * The Amazon S3 location to back up Amazon EMR Studio Workspaces and notebook files.
     */
    defaultS3Location: pulumi.Input<string>;
    /**
     * A detailed description of the Amazon EMR Studio.
     */
    description?: pulumi.Input<string>;
    /**
     * The AWS KMS key identifier (ARN) used to encrypt Amazon EMR Studio workspace and notebook files when backed up to Amazon S3.
     */
    encryptionKeyArn?: pulumi.Input<string>;
    /**
     * The ID of the Amazon EMR Studio Engine security group. The Engine security group allows inbound network traffic from the Workspace security group, and it must be in the same VPC specified by `vpcId`.
     */
    engineSecurityGroupId: pulumi.Input<string>;
    /**
     * The authentication endpoint of your identity provider (IdP). Specify this value when you use IAM authentication and want to let federated users log in to a Studio with the Studio URL and credentials from your IdP. Amazon EMR Studio redirects users to this endpoint to enter credentials.
     */
    idpAuthUrl?: pulumi.Input<string>;
    /**
     * The name that your identity provider (IdP) uses for its RelayState parameter. For example, RelayState or TargetSource. Specify this value when you use IAM authentication and want to let federated users log in to a Studio using the Studio URL. The RelayState parameter differs by IdP.
     */
    idpRelayStateParameterName?: pulumi.Input<string>;
    /**
     * A descriptive name for the Amazon EMR Studio.
     */
    name?: pulumi.Input<string>;
    /**
     * The IAM role that the Amazon EMR Studio assumes. The service role provides a way for Amazon EMR Studio to interoperate with other Amazon Web Services services.
     */
    serviceRole: pulumi.Input<string>;
    /**
     * A list of subnet IDs to associate with the Amazon EMR Studio. A Studio can have a maximum of 5 subnets. The subnets must belong to the VPC specified by `vpcId`. Studio users can create a Workspace in any of the specified subnets.
     */
    subnetIds: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * list of tags to apply to the EMR Cluster. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * The IAM user role that users and groups assume when logged in to an Amazon EMR Studio. Only specify a User Role when you use Amazon Web Services SSO authentication. The permissions attached to the User Role can be scoped down for each user or group using session policies.
     */
    userRole?: pulumi.Input<string>;
    /**
     * The ID of the Amazon Virtual Private Cloud (Amazon VPC) to associate with the Studio.
     */
    vpcId: pulumi.Input<string>;
    /**
     * The ID of the Amazon EMR Studio Workspace security group. The Workspace security group allows outbound network traffic to resources in the Engine security group, and it must be in the same VPC specified by `vpcId`.
     *
     * The following arguments are optional:
     */
    workspaceSecurityGroupId: pulumi.Input<string>;
}
