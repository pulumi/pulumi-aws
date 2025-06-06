// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Manages an Amazon API Gateway Version 2 API mapping.
 * More information can be found in the [Amazon API Gateway Developer Guide](https://docs.aws.amazon.com/apigateway/latest/developerguide/how-to-custom-domains.html).
 *
 * ## Example Usage
 *
 * ### Basic
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.apigatewayv2.ApiMapping("example", {
 *     apiId: exampleAwsApigatewayv2Api.id,
 *     domainName: exampleAwsApigatewayv2DomainName.id,
 *     stage: exampleAwsApigatewayv2Stage.id,
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import `aws_apigatewayv2_api_mapping` using the API mapping identifier and domain name. For example:
 *
 * ```sh
 * $ pulumi import aws:apigatewayv2/apiMapping:ApiMapping example 1122334/ws-api.example.com
 * ```
 */
export class ApiMapping extends pulumi.CustomResource {
    /**
     * Get an existing ApiMapping resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ApiMappingState, opts?: pulumi.CustomResourceOptions): ApiMapping {
        return new ApiMapping(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:apigatewayv2/apiMapping:ApiMapping';

    /**
     * Returns true if the given object is an instance of ApiMapping.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is ApiMapping {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === ApiMapping.__pulumiType;
    }

    /**
     * API identifier.
     */
    public readonly apiId!: pulumi.Output<string>;
    /**
     * The API mapping key. Refer to [REST API](https://docs.aws.amazon.com/apigateway/latest/developerguide/rest-api-mappings.html), [HTTP API](https://docs.aws.amazon.com/apigateway/latest/developerguide/http-api-mappings.html) or [WebSocket API](https://docs.aws.amazon.com/apigateway/latest/developerguide/websocket-api-mappings.html).
     */
    public readonly apiMappingKey!: pulumi.Output<string | undefined>;
    /**
     * Domain name. Use the `aws.apigatewayv2.DomainName` resource to configure a domain name.
     */
    public readonly domainName!: pulumi.Output<string>;
    /**
     * API stage. Use the `aws.apigatewayv2.Stage` resource to configure an API stage.
     */
    public readonly stage!: pulumi.Output<string>;

    /**
     * Create a ApiMapping resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: ApiMappingArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ApiMappingArgs | ApiMappingState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ApiMappingState | undefined;
            resourceInputs["apiId"] = state ? state.apiId : undefined;
            resourceInputs["apiMappingKey"] = state ? state.apiMappingKey : undefined;
            resourceInputs["domainName"] = state ? state.domainName : undefined;
            resourceInputs["stage"] = state ? state.stage : undefined;
        } else {
            const args = argsOrState as ApiMappingArgs | undefined;
            if ((!args || args.apiId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'apiId'");
            }
            if ((!args || args.domainName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'domainName'");
            }
            if ((!args || args.stage === undefined) && !opts.urn) {
                throw new Error("Missing required property 'stage'");
            }
            resourceInputs["apiId"] = args ? args.apiId : undefined;
            resourceInputs["apiMappingKey"] = args ? args.apiMappingKey : undefined;
            resourceInputs["domainName"] = args ? args.domainName : undefined;
            resourceInputs["stage"] = args ? args.stage : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(ApiMapping.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering ApiMapping resources.
 */
export interface ApiMappingState {
    /**
     * API identifier.
     */
    apiId?: pulumi.Input<string>;
    /**
     * The API mapping key. Refer to [REST API](https://docs.aws.amazon.com/apigateway/latest/developerguide/rest-api-mappings.html), [HTTP API](https://docs.aws.amazon.com/apigateway/latest/developerguide/http-api-mappings.html) or [WebSocket API](https://docs.aws.amazon.com/apigateway/latest/developerguide/websocket-api-mappings.html).
     */
    apiMappingKey?: pulumi.Input<string>;
    /**
     * Domain name. Use the `aws.apigatewayv2.DomainName` resource to configure a domain name.
     */
    domainName?: pulumi.Input<string>;
    /**
     * API stage. Use the `aws.apigatewayv2.Stage` resource to configure an API stage.
     */
    stage?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a ApiMapping resource.
 */
export interface ApiMappingArgs {
    /**
     * API identifier.
     */
    apiId: pulumi.Input<string>;
    /**
     * The API mapping key. Refer to [REST API](https://docs.aws.amazon.com/apigateway/latest/developerguide/rest-api-mappings.html), [HTTP API](https://docs.aws.amazon.com/apigateway/latest/developerguide/http-api-mappings.html) or [WebSocket API](https://docs.aws.amazon.com/apigateway/latest/developerguide/websocket-api-mappings.html).
     */
    apiMappingKey?: pulumi.Input<string>;
    /**
     * Domain name. Use the `aws.apigatewayv2.DomainName` resource to configure a domain name.
     */
    domainName: pulumi.Input<string>;
    /**
     * API stage. Use the `aws.apigatewayv2.Stage` resource to configure an API stage.
     */
    stage: pulumi.Input<string>;
}
