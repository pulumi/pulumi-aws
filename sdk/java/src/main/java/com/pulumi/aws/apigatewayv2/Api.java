// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.apigatewayv2;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.apigatewayv2.ApiArgs;
import com.pulumi.aws.apigatewayv2.inputs.ApiState;
import com.pulumi.aws.apigatewayv2.outputs.ApiCorsConfiguration;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.String;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Manages an Amazon API Gateway Version 2 API.
 * 
 * &gt; **Note:** Amazon API Gateway Version 2 resources are used for creating and deploying WebSocket and HTTP APIs. To create and deploy REST APIs, use Amazon API Gateway Version 1 resources.
 * 
 * ## Example Usage
 * 
 * ### Basic WebSocket API
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
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Basic HTTP API
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
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ## Import
 * 
 * Using `pulumi import`, import `aws_apigatewayv2_api` using the API identifier. For example:
 * 
 * ```sh
 * $ pulumi import aws:apigatewayv2/api:Api example aabbccddee
 * ```
 * 
 */
@ResourceType(type="aws:apigatewayv2/api:Api")
public class Api extends com.pulumi.resources.CustomResource {
    /**
     * URI of the API, of the form `https://{api-id}.execute-api.{region}.amazonaws.com` for HTTP APIs and `wss://{api-id}.execute-api.{region}.amazonaws.com` for WebSocket APIs.
     * 
     */
    @Export(name="apiEndpoint", refs={String.class}, tree="[0]")
    private Output<String> apiEndpoint;

    /**
     * @return URI of the API, of the form `https://{api-id}.execute-api.{region}.amazonaws.com` for HTTP APIs and `wss://{api-id}.execute-api.{region}.amazonaws.com` for WebSocket APIs.
     * 
     */
    public Output<String> apiEndpoint() {
        return this.apiEndpoint;
    }
    /**
     * An [API key selection expression](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-selection-expressions.html#apigateway-websocket-api-apikey-selection-expressions).
     * Valid values: `$context.authorizer.usageIdentifierKey`, `$request.header.x-api-key`. Defaults to `$request.header.x-api-key`.
     * Applicable for WebSocket APIs.
     * 
     */
    @Export(name="apiKeySelectionExpression", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> apiKeySelectionExpression;

    /**
     * @return An [API key selection expression](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-selection-expressions.html#apigateway-websocket-api-apikey-selection-expressions).
     * Valid values: `$context.authorizer.usageIdentifierKey`, `$request.header.x-api-key`. Defaults to `$request.header.x-api-key`.
     * Applicable for WebSocket APIs.
     * 
     */
    public Output<Optional<String>> apiKeySelectionExpression() {
        return Codegen.optional(this.apiKeySelectionExpression);
    }
    /**
     * ARN of the API.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return ARN of the API.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * An OpenAPI specification that defines the set of routes and integrations to create as part of the HTTP APIs. Supported only for HTTP APIs.
     * 
     */
    @Export(name="body", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> body;

    /**
     * @return An OpenAPI specification that defines the set of routes and integrations to create as part of the HTTP APIs. Supported only for HTTP APIs.
     * 
     */
    public Output<Optional<String>> body() {
        return Codegen.optional(this.body);
    }
    /**
     * Cross-origin resource sharing (CORS) [configuration](https://docs.aws.amazon.com/apigateway/latest/developerguide/http-api-cors.html). Applicable for HTTP APIs.
     * 
     */
    @Export(name="corsConfiguration", refs={ApiCorsConfiguration.class}, tree="[0]")
    private Output</* @Nullable */ ApiCorsConfiguration> corsConfiguration;

    /**
     * @return Cross-origin resource sharing (CORS) [configuration](https://docs.aws.amazon.com/apigateway/latest/developerguide/http-api-cors.html). Applicable for HTTP APIs.
     * 
     */
    public Output<Optional<ApiCorsConfiguration>> corsConfiguration() {
        return Codegen.optional(this.corsConfiguration);
    }
    /**
     * Part of _quick create_. Specifies any credentials required for the integration. Applicable for HTTP APIs.
     * 
     */
    @Export(name="credentialsArn", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> credentialsArn;

    /**
     * @return Part of _quick create_. Specifies any credentials required for the integration. Applicable for HTTP APIs.
     * 
     */
    public Output<Optional<String>> credentialsArn() {
        return Codegen.optional(this.credentialsArn);
    }
    /**
     * Description of the API. Must be less than or equal to 1024 characters in length.
     * 
     */
    @Export(name="description", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> description;

    /**
     * @return Description of the API. Must be less than or equal to 1024 characters in length.
     * 
     */
    public Output<Optional<String>> description() {
        return Codegen.optional(this.description);
    }
    /**
     * Whether clients can invoke the API by using the default `execute-api` endpoint.
     * By default, clients can invoke the API with the default `{api_id}.execute-api.{region}.amazonaws.com endpoint`.
     * To require that clients use a custom domain name to invoke the API, disable the default endpoint.
     * 
     */
    @Export(name="disableExecuteApiEndpoint", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> disableExecuteApiEndpoint;

    /**
     * @return Whether clients can invoke the API by using the default `execute-api` endpoint.
     * By default, clients can invoke the API with the default `{api_id}.execute-api.{region}.amazonaws.com endpoint`.
     * To require that clients use a custom domain name to invoke the API, disable the default endpoint.
     * 
     */
    public Output<Optional<Boolean>> disableExecuteApiEndpoint() {
        return Codegen.optional(this.disableExecuteApiEndpoint);
    }
    /**
     * ARN prefix to be used in an `aws.lambda.Permission`&#39;s `source_arn` attribute
     * or in an `aws.iam.Policy` to authorize access to the [`{@literal @}connections` API](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-how-to-call-websocket-api-connections.html).
     * See the [Amazon API Gateway Developer Guide](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-control-access-iam.html) for details.
     * 
     */
    @Export(name="executionArn", refs={String.class}, tree="[0]")
    private Output<String> executionArn;

    /**
     * @return ARN prefix to be used in an `aws.lambda.Permission`&#39;s `source_arn` attribute
     * or in an `aws.iam.Policy` to authorize access to the [`{@literal @}connections` API](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-how-to-call-websocket-api-connections.html).
     * See the [Amazon API Gateway Developer Guide](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-control-access-iam.html) for details.
     * 
     */
    public Output<String> executionArn() {
        return this.executionArn;
    }
    /**
     * Whether warnings should return an error while API Gateway is creating or updating the resource using an OpenAPI specification. Defaults to `false`. Applicable for HTTP APIs.
     * 
     */
    @Export(name="failOnWarnings", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> failOnWarnings;

    /**
     * @return Whether warnings should return an error while API Gateway is creating or updating the resource using an OpenAPI specification. Defaults to `false`. Applicable for HTTP APIs.
     * 
     */
    public Output<Optional<Boolean>> failOnWarnings() {
        return Codegen.optional(this.failOnWarnings);
    }
    /**
     * The IP address types that can invoke the API. Valid values: `ipv4`, `dualstack`. Use `ipv4` to allow only IPv4 addresses to invoke your API, or use `dualstack` to allow both IPv4 and IPv6 addresses to invoke your API. Defaults to `ipv4`.
     * 
     */
    @Export(name="ipAddressType", refs={String.class}, tree="[0]")
    private Output<String> ipAddressType;

    /**
     * @return The IP address types that can invoke the API. Valid values: `ipv4`, `dualstack`. Use `ipv4` to allow only IPv4 addresses to invoke your API, or use `dualstack` to allow both IPv4 and IPv6 addresses to invoke your API. Defaults to `ipv4`.
     * 
     */
    public Output<String> ipAddressType() {
        return this.ipAddressType;
    }
    /**
     * Name of the API. Must be less than or equal to 128 characters in length.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return Name of the API. Must be less than or equal to 128 characters in length.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * API protocol. Valid values: `HTTP`, `WEBSOCKET`.
     * 
     */
    @Export(name="protocolType", refs={String.class}, tree="[0]")
    private Output<String> protocolType;

    /**
     * @return API protocol. Valid values: `HTTP`, `WEBSOCKET`.
     * 
     */
    public Output<String> protocolType() {
        return this.protocolType;
    }
    /**
     * Part of _quick create_. Specifies any [route key](https://docs.aws.amazon.com/apigateway/latest/developerguide/http-api-develop-routes.html). Applicable for HTTP APIs.
     * 
     */
    @Export(name="routeKey", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> routeKey;

    /**
     * @return Part of _quick create_. Specifies any [route key](https://docs.aws.amazon.com/apigateway/latest/developerguide/http-api-develop-routes.html). Applicable for HTTP APIs.
     * 
     */
    public Output<Optional<String>> routeKey() {
        return Codegen.optional(this.routeKey);
    }
    /**
     * The [route selection expression](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-selection-expressions.html#apigateway-websocket-api-route-selection-expressions) for the API.
     * Defaults to `$request.method $request.path`.
     * 
     */
    @Export(name="routeSelectionExpression", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> routeSelectionExpression;

    /**
     * @return The [route selection expression](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-selection-expressions.html#apigateway-websocket-api-route-selection-expressions) for the API.
     * Defaults to `$request.method $request.path`.
     * 
     */
    public Output<Optional<String>> routeSelectionExpression() {
        return Codegen.optional(this.routeSelectionExpression);
    }
    /**
     * Map of tags to assign to the API. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Map of tags to assign to the API. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Output<Optional<Map<String,String>>> tags() {
        return Codegen.optional(this.tags);
    }
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Export(name="tagsAll", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output<Map<String,String>> tagsAll;

    /**
     * @return Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     */
    public Output<Map<String,String>> tagsAll() {
        return this.tagsAll;
    }
    /**
     * Part of _quick create_. Quick create produces an API with an integration, a default catch-all route, and a default stage which is configured to automatically deploy changes.
     * For HTTP integrations, specify a fully qualified URL. For Lambda integrations, specify a function ARN.
     * The type of the integration will be `HTTP_PROXY` or `AWS_PROXY`, respectively. Applicable for HTTP APIs.
     * 
     */
    @Export(name="target", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> target;

    /**
     * @return Part of _quick create_. Quick create produces an API with an integration, a default catch-all route, and a default stage which is configured to automatically deploy changes.
     * For HTTP integrations, specify a fully qualified URL. For Lambda integrations, specify a function ARN.
     * The type of the integration will be `HTTP_PROXY` or `AWS_PROXY`, respectively. Applicable for HTTP APIs.
     * 
     */
    public Output<Optional<String>> target() {
        return Codegen.optional(this.target);
    }
    /**
     * Version identifier for the API. Must be between 1 and 64 characters in length.
     * 
     */
    @Export(name="version", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> version;

    /**
     * @return Version identifier for the API. Must be between 1 and 64 characters in length.
     * 
     */
    public Output<Optional<String>> version() {
        return Codegen.optional(this.version);
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public Api(java.lang.String name) {
        this(name, ApiArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Api(java.lang.String name, ApiArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Api(java.lang.String name, ApiArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:apigatewayv2/api:Api", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Api(java.lang.String name, Output<java.lang.String> id, @Nullable ApiState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:apigatewayv2/api:Api", name, state, makeResourceOptions(options, id), false);
    }

    private static ApiArgs makeArgs(ApiArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? ApiArgs.Empty : args;
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
    public static Api get(java.lang.String name, Output<java.lang.String> id, @Nullable ApiState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Api(name, id, state, options);
    }
}
