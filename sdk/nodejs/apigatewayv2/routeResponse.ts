// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Manages an Amazon API Gateway Version 2 route response.
 * More information can be found in the [Amazon API Gateway Developer Guide](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api.html).
 *
 * ## Example Usage
 *
 * ### Basic
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.apigatewayv2.RouteResponse("example", {
 *     apiId: exampleAwsApigatewayv2Api.id,
 *     routeId: exampleAwsApigatewayv2Route.id,
 *     routeResponseKey: "$default",
 * });
 * ```
 *
 * ## Enabling Two-Way Communication
 *
 * For websocket routes that require two-way communication enabled, an `aws.apigatewayv2.RouteResponse` needs to be added to the route with `routeResponseKey = "$default"`. More information available  is available in [Amazon API Gateway Developer Guide](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api.html).
 *
 * You can only define the $default route response for WebSocket APIs. You can use an integration response to manipulate the response from a backend service. For more information, see [Overview of integration responses](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-integration-responses.html#apigateway-websocket-api-integration-response-overview).
 *
 * ## Import
 *
 * Using `pulumi import`, import `aws_apigatewayv2_route_response` using the API identifier, route identifier and route response identifier. For example:
 *
 * ```sh
 * $ pulumi import aws:apigatewayv2/routeResponse:RouteResponse example aabbccddee/1122334/998877
 * ```
 */
export class RouteResponse extends pulumi.CustomResource {
    /**
     * Get an existing RouteResponse resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: RouteResponseState, opts?: pulumi.CustomResourceOptions): RouteResponse {
        return new RouteResponse(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:apigatewayv2/routeResponse:RouteResponse';

    /**
     * Returns true if the given object is an instance of RouteResponse.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is RouteResponse {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === RouteResponse.__pulumiType;
    }

    /**
     * API identifier.
     */
    public readonly apiId!: pulumi.Output<string>;
    /**
     * The [model selection expression](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-selection-expressions.html#apigateway-websocket-api-model-selection-expressions) for the route response.
     */
    public readonly modelSelectionExpression!: pulumi.Output<string | undefined>;
    /**
     * Response models for the route response.
     */
    public readonly responseModels!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * Identifier of the `aws.apigatewayv2.Route`.
     */
    public readonly routeId!: pulumi.Output<string>;
    /**
     * Route response key.
     */
    public readonly routeResponseKey!: pulumi.Output<string>;

    /**
     * Create a RouteResponse resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: RouteResponseArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: RouteResponseArgs | RouteResponseState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as RouteResponseState | undefined;
            resourceInputs["apiId"] = state ? state.apiId : undefined;
            resourceInputs["modelSelectionExpression"] = state ? state.modelSelectionExpression : undefined;
            resourceInputs["responseModels"] = state ? state.responseModels : undefined;
            resourceInputs["routeId"] = state ? state.routeId : undefined;
            resourceInputs["routeResponseKey"] = state ? state.routeResponseKey : undefined;
        } else {
            const args = argsOrState as RouteResponseArgs | undefined;
            if ((!args || args.apiId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'apiId'");
            }
            if ((!args || args.routeId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'routeId'");
            }
            if ((!args || args.routeResponseKey === undefined) && !opts.urn) {
                throw new Error("Missing required property 'routeResponseKey'");
            }
            resourceInputs["apiId"] = args ? args.apiId : undefined;
            resourceInputs["modelSelectionExpression"] = args ? args.modelSelectionExpression : undefined;
            resourceInputs["responseModels"] = args ? args.responseModels : undefined;
            resourceInputs["routeId"] = args ? args.routeId : undefined;
            resourceInputs["routeResponseKey"] = args ? args.routeResponseKey : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(RouteResponse.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering RouteResponse resources.
 */
export interface RouteResponseState {
    /**
     * API identifier.
     */
    apiId?: pulumi.Input<string>;
    /**
     * The [model selection expression](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-selection-expressions.html#apigateway-websocket-api-model-selection-expressions) for the route response.
     */
    modelSelectionExpression?: pulumi.Input<string>;
    /**
     * Response models for the route response.
     */
    responseModels?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Identifier of the `aws.apigatewayv2.Route`.
     */
    routeId?: pulumi.Input<string>;
    /**
     * Route response key.
     */
    routeResponseKey?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a RouteResponse resource.
 */
export interface RouteResponseArgs {
    /**
     * API identifier.
     */
    apiId: pulumi.Input<string>;
    /**
     * The [model selection expression](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-selection-expressions.html#apigateway-websocket-api-model-selection-expressions) for the route response.
     */
    modelSelectionExpression?: pulumi.Input<string>;
    /**
     * Response models for the route response.
     */
    responseModels?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Identifier of the `aws.apigatewayv2.Route`.
     */
    routeId: pulumi.Input<string>;
    /**
     * Route response key.
     */
    routeResponseKey: pulumi.Input<string>;
}
