// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides a resource to manage an API Gateway Documentation Version.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const exampleRestApi = new aws.apigateway.RestApi("example", {name: "example_api"});
 * const exampleDocumentationPart = new aws.apigateway.DocumentationPart("example", {
 *     location: {
 *         type: "API",
 *     },
 *     properties: "{\"description\":\"Example\"}",
 *     restApiId: exampleRestApi.id,
 * });
 * const example = new aws.apigateway.DocumentationVersion("example", {
 *     version: "example_version",
 *     restApiId: exampleRestApi.id,
 *     description: "Example description",
 * }, {
 *     dependsOn: [exampleDocumentationPart],
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import API Gateway documentation versions using `REST-API-ID/VERSION`. For example:
 *
 * ```sh
 * $ pulumi import aws:apigateway/documentationVersion:DocumentationVersion example 5i4e1ko720/example-version
 * ```
 */
export class DocumentationVersion extends pulumi.CustomResource {
    /**
     * Get an existing DocumentationVersion resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: DocumentationVersionState, opts?: pulumi.CustomResourceOptions): DocumentationVersion {
        return new DocumentationVersion(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:apigateway/documentationVersion:DocumentationVersion';

    /**
     * Returns true if the given object is an instance of DocumentationVersion.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is DocumentationVersion {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === DocumentationVersion.__pulumiType;
    }

    /**
     * Description of the API documentation version.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * ID of the associated Rest API
     */
    public readonly restApiId!: pulumi.Output<string>;
    /**
     * Version identifier of the API documentation snapshot.
     */
    public readonly version!: pulumi.Output<string>;

    /**
     * Create a DocumentationVersion resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: DocumentationVersionArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: DocumentationVersionArgs | DocumentationVersionState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as DocumentationVersionState | undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["restApiId"] = state ? state.restApiId : undefined;
            resourceInputs["version"] = state ? state.version : undefined;
        } else {
            const args = argsOrState as DocumentationVersionArgs | undefined;
            if ((!args || args.restApiId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'restApiId'");
            }
            if ((!args || args.version === undefined) && !opts.urn) {
                throw new Error("Missing required property 'version'");
            }
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["restApiId"] = args ? args.restApiId : undefined;
            resourceInputs["version"] = args ? args.version : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(DocumentationVersion.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering DocumentationVersion resources.
 */
export interface DocumentationVersionState {
    /**
     * Description of the API documentation version.
     */
    description?: pulumi.Input<string>;
    /**
     * ID of the associated Rest API
     */
    restApiId?: pulumi.Input<string>;
    /**
     * Version identifier of the API documentation snapshot.
     */
    version?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a DocumentationVersion resource.
 */
export interface DocumentationVersionArgs {
    /**
     * Description of the API documentation version.
     */
    description?: pulumi.Input<string>;
    /**
     * ID of the associated Rest API
     */
    restApiId: pulumi.Input<string>;
    /**
     * Version identifier of the API documentation snapshot.
     */
    version: pulumi.Input<string>;
}
