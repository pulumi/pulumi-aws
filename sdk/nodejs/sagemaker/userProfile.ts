// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides a SageMaker AI User Profile resource.
 *
 * ## Example Usage
 *
 * ### Basic usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.sagemaker.UserProfile("example", {
 *     domainId: test.id,
 *     userProfileName: "example",
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import SageMaker AI User Profiles using the `arn`. For example:
 *
 * ```sh
 * $ pulumi import aws:sagemaker/userProfile:UserProfile test_user_profile arn:aws:sagemaker:us-west-2:123456789012:user-profile/domain-id/profile-name
 * ```
 */
export class UserProfile extends pulumi.CustomResource {
    /**
     * Get an existing UserProfile resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: UserProfileState, opts?: pulumi.CustomResourceOptions): UserProfile {
        return new UserProfile(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:sagemaker/userProfile:UserProfile';

    /**
     * Returns true if the given object is an instance of UserProfile.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is UserProfile {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === UserProfile.__pulumiType;
    }

    /**
     * The user profile Amazon Resource Name (ARN).
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * The ID of the associated Domain.
     */
    public readonly domainId!: pulumi.Output<string>;
    /**
     * The ID of the user's profile in the Amazon Elastic File System (EFS) volume.
     */
    public /*out*/ readonly homeEfsFileSystemUid!: pulumi.Output<string>;
    /**
     * A specifier for the type of value specified in `singleSignOnUserValue`. Currently, the only supported value is `UserName`. If the Domain's AuthMode is SSO, this field is required. If the Domain's AuthMode is not SSO, this field cannot be specified.
     */
    public readonly singleSignOnUserIdentifier!: pulumi.Output<string | undefined>;
    /**
     * The username of the associated AWS Single Sign-On User for this User Profile. If the Domain's AuthMode is SSO, this field is required, and must match a valid username of a user in your directory. If the Domain's AuthMode is not SSO, this field cannot be specified.
     */
    public readonly singleSignOnUserValue!: pulumi.Output<string | undefined>;
    /**
     * A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * The name for the User Profile.
     */
    public readonly userProfileName!: pulumi.Output<string>;
    /**
     * The user settings. See User Settings below.
     */
    public readonly userSettings!: pulumi.Output<outputs.sagemaker.UserProfileUserSettings | undefined>;

    /**
     * Create a UserProfile resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: UserProfileArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: UserProfileArgs | UserProfileState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as UserProfileState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["domainId"] = state ? state.domainId : undefined;
            resourceInputs["homeEfsFileSystemUid"] = state ? state.homeEfsFileSystemUid : undefined;
            resourceInputs["singleSignOnUserIdentifier"] = state ? state.singleSignOnUserIdentifier : undefined;
            resourceInputs["singleSignOnUserValue"] = state ? state.singleSignOnUserValue : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["userProfileName"] = state ? state.userProfileName : undefined;
            resourceInputs["userSettings"] = state ? state.userSettings : undefined;
        } else {
            const args = argsOrState as UserProfileArgs | undefined;
            if ((!args || args.domainId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'domainId'");
            }
            if ((!args || args.userProfileName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'userProfileName'");
            }
            resourceInputs["domainId"] = args ? args.domainId : undefined;
            resourceInputs["singleSignOnUserIdentifier"] = args ? args.singleSignOnUserIdentifier : undefined;
            resourceInputs["singleSignOnUserValue"] = args ? args.singleSignOnUserValue : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["userProfileName"] = args ? args.userProfileName : undefined;
            resourceInputs["userSettings"] = args ? args.userSettings : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["homeEfsFileSystemUid"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(UserProfile.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering UserProfile resources.
 */
export interface UserProfileState {
    /**
     * The user profile Amazon Resource Name (ARN).
     */
    arn?: pulumi.Input<string>;
    /**
     * The ID of the associated Domain.
     */
    domainId?: pulumi.Input<string>;
    /**
     * The ID of the user's profile in the Amazon Elastic File System (EFS) volume.
     */
    homeEfsFileSystemUid?: pulumi.Input<string>;
    /**
     * A specifier for the type of value specified in `singleSignOnUserValue`. Currently, the only supported value is `UserName`. If the Domain's AuthMode is SSO, this field is required. If the Domain's AuthMode is not SSO, this field cannot be specified.
     */
    singleSignOnUserIdentifier?: pulumi.Input<string>;
    /**
     * The username of the associated AWS Single Sign-On User for this User Profile. If the Domain's AuthMode is SSO, this field is required, and must match a valid username of a user in your directory. If the Domain's AuthMode is not SSO, this field cannot be specified.
     */
    singleSignOnUserValue?: pulumi.Input<string>;
    /**
     * A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * The name for the User Profile.
     */
    userProfileName?: pulumi.Input<string>;
    /**
     * The user settings. See User Settings below.
     */
    userSettings?: pulumi.Input<inputs.sagemaker.UserProfileUserSettings>;
}

/**
 * The set of arguments for constructing a UserProfile resource.
 */
export interface UserProfileArgs {
    /**
     * The ID of the associated Domain.
     */
    domainId: pulumi.Input<string>;
    /**
     * A specifier for the type of value specified in `singleSignOnUserValue`. Currently, the only supported value is `UserName`. If the Domain's AuthMode is SSO, this field is required. If the Domain's AuthMode is not SSO, this field cannot be specified.
     */
    singleSignOnUserIdentifier?: pulumi.Input<string>;
    /**
     * The username of the associated AWS Single Sign-On User for this User Profile. If the Domain's AuthMode is SSO, this field is required, and must match a valid username of a user in your directory. If the Domain's AuthMode is not SSO, this field cannot be specified.
     */
    singleSignOnUserValue?: pulumi.Input<string>;
    /**
     * A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * The name for the User Profile.
     */
    userProfileName: pulumi.Input<string>;
    /**
     * The user settings. See User Settings below.
     */
    userSettings?: pulumi.Input<inputs.sagemaker.UserProfileUserSettings>;
}
