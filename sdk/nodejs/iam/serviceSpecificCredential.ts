// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides an IAM Service Specific Credential.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.iam.User("example", {name: "example"});
 * const exampleServiceSpecificCredential = new aws.iam.ServiceSpecificCredential("example", {
 *     serviceName: "codecommit.amazonaws.com",
 *     userName: example.name,
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import IAM Service Specific Credentials using the `service_name:user_name:service_specific_credential_id`. For example:
 *
 * ```sh
 * $ pulumi import aws:iam/serviceSpecificCredential:ServiceSpecificCredential default `codecommit.amazonaws.com:example:some-id`
 * ```
 */
export class ServiceSpecificCredential extends pulumi.CustomResource {
    /**
     * Get an existing ServiceSpecificCredential resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ServiceSpecificCredentialState, opts?: pulumi.CustomResourceOptions): ServiceSpecificCredential {
        return new ServiceSpecificCredential(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:iam/serviceSpecificCredential:ServiceSpecificCredential';

    /**
     * Returns true if the given object is an instance of ServiceSpecificCredential.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is ServiceSpecificCredential {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === ServiceSpecificCredential.__pulumiType;
    }

    /**
     * The name of the AWS service that is to be associated with the credentials. The service you specify here is the only service that can be accessed using these credentials.
     */
    public readonly serviceName!: pulumi.Output<string>;
    /**
     * The generated password for the service-specific credential.
     */
    public /*out*/ readonly servicePassword!: pulumi.Output<string>;
    /**
     * The unique identifier for the service-specific credential.
     */
    public /*out*/ readonly serviceSpecificCredentialId!: pulumi.Output<string>;
    /**
     * The generated user name for the service-specific credential. This value is generated by combining the IAM user's name combined with the ID number of the AWS account, as in `jane-at-123456789012`, for example.
     */
    public /*out*/ readonly serviceUserName!: pulumi.Output<string>;
    /**
     * The status to be assigned to the service-specific credential. Valid values are `Active` and `Inactive`. Default value is `Active`.
     */
    public readonly status!: pulumi.Output<string | undefined>;
    /**
     * The name of the IAM user that is to be associated with the credentials. The new service-specific credentials have the same permissions as the associated user except that they can be used only to access the specified service.
     */
    public readonly userName!: pulumi.Output<string>;

    /**
     * Create a ServiceSpecificCredential resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: ServiceSpecificCredentialArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ServiceSpecificCredentialArgs | ServiceSpecificCredentialState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ServiceSpecificCredentialState | undefined;
            resourceInputs["serviceName"] = state ? state.serviceName : undefined;
            resourceInputs["servicePassword"] = state ? state.servicePassword : undefined;
            resourceInputs["serviceSpecificCredentialId"] = state ? state.serviceSpecificCredentialId : undefined;
            resourceInputs["serviceUserName"] = state ? state.serviceUserName : undefined;
            resourceInputs["status"] = state ? state.status : undefined;
            resourceInputs["userName"] = state ? state.userName : undefined;
        } else {
            const args = argsOrState as ServiceSpecificCredentialArgs | undefined;
            if ((!args || args.serviceName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'serviceName'");
            }
            if ((!args || args.userName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'userName'");
            }
            resourceInputs["serviceName"] = args ? args.serviceName : undefined;
            resourceInputs["status"] = args ? args.status : undefined;
            resourceInputs["userName"] = args ? args.userName : undefined;
            resourceInputs["servicePassword"] = undefined /*out*/;
            resourceInputs["serviceSpecificCredentialId"] = undefined /*out*/;
            resourceInputs["serviceUserName"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        const secretOpts = { additionalSecretOutputs: ["servicePassword"] };
        opts = pulumi.mergeOptions(opts, secretOpts);
        super(ServiceSpecificCredential.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering ServiceSpecificCredential resources.
 */
export interface ServiceSpecificCredentialState {
    /**
     * The name of the AWS service that is to be associated with the credentials. The service you specify here is the only service that can be accessed using these credentials.
     */
    serviceName?: pulumi.Input<string>;
    /**
     * The generated password for the service-specific credential.
     */
    servicePassword?: pulumi.Input<string>;
    /**
     * The unique identifier for the service-specific credential.
     */
    serviceSpecificCredentialId?: pulumi.Input<string>;
    /**
     * The generated user name for the service-specific credential. This value is generated by combining the IAM user's name combined with the ID number of the AWS account, as in `jane-at-123456789012`, for example.
     */
    serviceUserName?: pulumi.Input<string>;
    /**
     * The status to be assigned to the service-specific credential. Valid values are `Active` and `Inactive`. Default value is `Active`.
     */
    status?: pulumi.Input<string>;
    /**
     * The name of the IAM user that is to be associated with the credentials. The new service-specific credentials have the same permissions as the associated user except that they can be used only to access the specified service.
     */
    userName?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a ServiceSpecificCredential resource.
 */
export interface ServiceSpecificCredentialArgs {
    /**
     * The name of the AWS service that is to be associated with the credentials. The service you specify here is the only service that can be accessed using these credentials.
     */
    serviceName: pulumi.Input<string>;
    /**
     * The status to be assigned to the service-specific credential. Valid values are `Active` and `Inactive`. Default value is `Active`.
     */
    status?: pulumi.Input<string>;
    /**
     * The name of the IAM user that is to be associated with the credentials. The new service-specific credentials have the same permissions as the associated user except that they can be used only to access the specified service.
     */
    userName: pulumi.Input<string>;
}
