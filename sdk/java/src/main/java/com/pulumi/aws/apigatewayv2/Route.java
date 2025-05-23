// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.apigatewayv2;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.apigatewayv2.RouteArgs;
import com.pulumi.aws.apigatewayv2.inputs.RouteState;
import com.pulumi.aws.apigatewayv2.outputs.RouteRequestParameter;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Manages an Amazon API Gateway Version 2 route.
 * More information can be found in the [Amazon API Gateway Developer Guide](https://docs.aws.amazon.com/apigateway/latest/developerguide/welcome.html) for [WebSocket](https://docs.aws.amazon.com/apigateway/latest/developerguide/websocket-api-develop-routes.html) and [HTTP](https://docs.aws.amazon.com/apigateway/latest/developerguide/http-api-develop-routes.html) APIs.
 * 
 * ## Example Usage
 * 
 * ### Basic
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.apigatewayv2.Api;
 * import com.pulumi.aws.apigatewayv2.ApiArgs;
 * import com.pulumi.aws.apigatewayv2.Route;
 * import com.pulumi.aws.apigatewayv2.RouteArgs;
 * import java.util.List;
 * import java.util.ArrayList;
 * import java.util.Map;
 * import java.io.File;
 * import java.nio.file.Files;
 * import java.nio.file.Paths;
 * 
 * public class App {
 *     public static void main(String[] args) {
 *         Pulumi.run(App::stack);
 *     }
 * 
 *     public static void stack(Context ctx) {
 *         var example = new Api("example", ApiArgs.builder()
 *             .name("example-websocket-api")
 *             .protocolType("WEBSOCKET")
 *             .routeSelectionExpression("$request.body.action")
 *             .build());
 * 
 *         var exampleRoute = new Route("exampleRoute", RouteArgs.builder()
 *             .apiId(example.id())
 *             .routeKey("$default")
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### HTTP Proxy Integration
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.apigatewayv2.Api;
 * import com.pulumi.aws.apigatewayv2.ApiArgs;
 * import com.pulumi.aws.apigatewayv2.Integration;
 * import com.pulumi.aws.apigatewayv2.IntegrationArgs;
 * import com.pulumi.aws.apigatewayv2.Route;
 * import com.pulumi.aws.apigatewayv2.RouteArgs;
 * import java.util.List;
 * import java.util.ArrayList;
 * import java.util.Map;
 * import java.io.File;
 * import java.nio.file.Files;
 * import java.nio.file.Paths;
 * 
 * public class App {
 *     public static void main(String[] args) {
 *         Pulumi.run(App::stack);
 *     }
 * 
 *     public static void stack(Context ctx) {
 *         var example = new Api("example", ApiArgs.builder()
 *             .name("example-http-api")
 *             .protocolType("HTTP")
 *             .build());
 * 
 *         var exampleIntegration = new Integration("exampleIntegration", IntegrationArgs.builder()
 *             .apiId(example.id())
 *             .integrationType("HTTP_PROXY")
 *             .integrationMethod("ANY")
 *             .integrationUri("https://example.com/{proxy}")
 *             .build());
 * 
 *         var exampleRoute = new Route("exampleRoute", RouteArgs.builder()
 *             .apiId(example.id())
 *             .routeKey("ANY /example/{proxy+}")
 *             .target(exampleIntegration.id().applyValue(_id -> String.format("integrations/%s", _id)))
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ## Import
 * 
 * Using `pulumi import`, import `aws_apigatewayv2_route` using the API identifier and route identifier. For example:
 * 
 * ```sh
 * $ pulumi import aws:apigatewayv2/route:Route example aabbccddee/1122334
 * ```
 * -&gt; __Note:__ The API Gateway managed route created as part of [_quick_create_](https://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-basic-concept.html#apigateway-definition-quick-create) cannot be imported.
 * 
 */
@ResourceType(type="aws:apigatewayv2/route:Route")
public class Route extends com.pulumi.resources.CustomResource {
    /**
     * API identifier.
     * 
     */
    @Export(name="apiId", refs={String.class}, tree="[0]")
    private Output<String> apiId;

    /**
     * @return API identifier.
     * 
     */
    public Output<String> apiId() {
        return this.apiId;
    }
    /**
     * Boolean whether an API key is required for the route. Defaults to `false`. Supported only for WebSocket APIs.
     * 
     */
    @Export(name="apiKeyRequired", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> apiKeyRequired;

    /**
     * @return Boolean whether an API key is required for the route. Defaults to `false`. Supported only for WebSocket APIs.
     * 
     */
    public Output<Optional<Boolean>> apiKeyRequired() {
        return Codegen.optional(this.apiKeyRequired);
    }
    /**
     * Authorization scopes supported by this route. The scopes are used with a JWT authorizer to authorize the method invocation.
     * 
     */
    @Export(name="authorizationScopes", refs={List.class,String.class}, tree="[0,1]")
    private Output</* @Nullable */ List<String>> authorizationScopes;

    /**
     * @return Authorization scopes supported by this route. The scopes are used with a JWT authorizer to authorize the method invocation.
     * 
     */
    public Output<Optional<List<String>>> authorizationScopes() {
        return Codegen.optional(this.authorizationScopes);
    }
    /**
     * Authorization type for the route.
     * For WebSocket APIs, valid values are `NONE` for open access, `AWS_IAM` for using AWS IAM permissions, and `CUSTOM` for using a Lambda authorizer.
     * For HTTP APIs, valid values are `NONE` for open access, `JWT` for using JSON Web Tokens, `AWS_IAM` for using AWS IAM permissions, and `CUSTOM` for using a Lambda authorizer.
     * Defaults to `NONE`.
     * 
     */
    @Export(name="authorizationType", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> authorizationType;

    /**
     * @return Authorization type for the route.
     * For WebSocket APIs, valid values are `NONE` for open access, `AWS_IAM` for using AWS IAM permissions, and `CUSTOM` for using a Lambda authorizer.
     * For HTTP APIs, valid values are `NONE` for open access, `JWT` for using JSON Web Tokens, `AWS_IAM` for using AWS IAM permissions, and `CUSTOM` for using a Lambda authorizer.
     * Defaults to `NONE`.
     * 
     */
    public Output<Optional<String>> authorizationType() {
        return Codegen.optional(this.authorizationType);
    }
    /**
     * Identifier of the `aws.apigatewayv2.Authorizer` resource to be associated with this route.
     * 
     */
    @Export(name="authorizerId", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> authorizerId;

    /**
     * @return Identifier of the `aws.apigatewayv2.Authorizer` resource to be associated with this route.
     * 
     */
    public Output<Optional<String>> authorizerId() {
        return Codegen.optional(this.authorizerId);
    }
    /**
     * The [model selection expression](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-selection-expressions.html#apigateway-websocket-api-model-selection-expressions) for the route. Supported only for WebSocket APIs.
     * 
     */
    @Export(name="modelSelectionExpression", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> modelSelectionExpression;

    /**
     * @return The [model selection expression](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-selection-expressions.html#apigateway-websocket-api-model-selection-expressions) for the route. Supported only for WebSocket APIs.
     * 
     */
    public Output<Optional<String>> modelSelectionExpression() {
        return Codegen.optional(this.modelSelectionExpression);
    }
    /**
     * Operation name for the route. Must be between 1 and 64 characters in length.
     * 
     */
    @Export(name="operationName", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> operationName;

    /**
     * @return Operation name for the route. Must be between 1 and 64 characters in length.
     * 
     */
    public Output<Optional<String>> operationName() {
        return Codegen.optional(this.operationName);
    }
    /**
     * Request models for the route. Supported only for WebSocket APIs.
     * 
     */
    @Export(name="requestModels", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> requestModels;

    /**
     * @return Request models for the route. Supported only for WebSocket APIs.
     * 
     */
    public Output<Optional<Map<String,String>>> requestModels() {
        return Codegen.optional(this.requestModels);
    }
    /**
     * Request parameters for the route. Supported only for WebSocket APIs.
     * 
     */
    @Export(name="requestParameters", refs={List.class,RouteRequestParameter.class}, tree="[0,1]")
    private Output</* @Nullable */ List<RouteRequestParameter>> requestParameters;

    /**
     * @return Request parameters for the route. Supported only for WebSocket APIs.
     * 
     */
    public Output<Optional<List<RouteRequestParameter>>> requestParameters() {
        return Codegen.optional(this.requestParameters);
    }
    /**
     * Route key for the route. For HTTP APIs, the route key can be either `$default`, or a combination of an HTTP method and resource path, for example, `GET /pets`.
     * 
     */
    @Export(name="routeKey", refs={String.class}, tree="[0]")
    private Output<String> routeKey;

    /**
     * @return Route key for the route. For HTTP APIs, the route key can be either `$default`, or a combination of an HTTP method and resource path, for example, `GET /pets`.
     * 
     */
    public Output<String> routeKey() {
        return this.routeKey;
    }
    /**
     * The [route response selection expression](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-selection-expressions.html#apigateway-websocket-api-route-response-selection-expressions) for the route. Supported only for WebSocket APIs.
     * 
     */
    @Export(name="routeResponseSelectionExpression", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> routeResponseSelectionExpression;

    /**
     * @return The [route response selection expression](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-selection-expressions.html#apigateway-websocket-api-route-response-selection-expressions) for the route. Supported only for WebSocket APIs.
     * 
     */
    public Output<Optional<String>> routeResponseSelectionExpression() {
        return Codegen.optional(this.routeResponseSelectionExpression);
    }
    /**
     * Target for the route, of the form `integrations/`*`IntegrationID`*, where *`IntegrationID`* is the identifier of an `aws.apigatewayv2.Integration` resource.
     * 
     */
    @Export(name="target", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> target;

    /**
     * @return Target for the route, of the form `integrations/`*`IntegrationID`*, where *`IntegrationID`* is the identifier of an `aws.apigatewayv2.Integration` resource.
     * 
     */
    public Output<Optional<String>> target() {
        return Codegen.optional(this.target);
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public Route(java.lang.String name) {
        this(name, RouteArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Route(java.lang.String name, RouteArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Route(java.lang.String name, RouteArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:apigatewayv2/route:Route", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Route(java.lang.String name, Output<java.lang.String> id, @Nullable RouteState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:apigatewayv2/route:Route", name, state, makeResourceOptions(options, id), false);
    }

    private static RouteArgs makeArgs(RouteArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? RouteArgs.Empty : args;
    }

    private static com.pulumi.resources.CustomResourceOptions makeResourceOptions(@Nullable com.pulumi.resources.CustomResourceOptions options, @Nullable Output<java.lang.String> id) {
        var defaultOptions = com.pulumi.resources.CustomResourceOptions.builder()
            .version(Utilities.getVersion())
            .build();
        return com.pulumi.resources.CustomResourceOptions.merge(defaultOptions, options, id);
    }

    /**
     * Get an existing Host resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state
     * @param options Optional settings to control the behavior of the CustomResource.
     */
    public static Route get(java.lang.String name, Output<java.lang.String> id, @Nullable RouteState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Route(name, id, state, options);
    }
}
