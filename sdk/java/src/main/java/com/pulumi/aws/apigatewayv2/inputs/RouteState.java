// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.apigatewayv2.inputs;

import com.pulumi.aws.apigatewayv2.inputs.RouteRequestParameterArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class RouteState extends com.pulumi.resources.ResourceArgs {

    public static final RouteState Empty = new RouteState();

    /**
     * API identifier.
     * 
     */
    @Import(name="apiId")
    private @Nullable Output<String> apiId;

    /**
     * @return API identifier.
     * 
     */
    public Optional<Output<String>> apiId() {
        return Optional.ofNullable(this.apiId);
    }

    /**
     * Boolean whether an API key is required for the route. Defaults to `false`. Supported only for WebSocket APIs.
     * 
     */
    @Import(name="apiKeyRequired")
    private @Nullable Output<Boolean> apiKeyRequired;

    /**
     * @return Boolean whether an API key is required for the route. Defaults to `false`. Supported only for WebSocket APIs.
     * 
     */
    public Optional<Output<Boolean>> apiKeyRequired() {
        return Optional.ofNullable(this.apiKeyRequired);
    }

    /**
     * Authorization scopes supported by this route. The scopes are used with a JWT authorizer to authorize the method invocation.
     * 
     */
    @Import(name="authorizationScopes")
    private @Nullable Output<List<String>> authorizationScopes;

    /**
     * @return Authorization scopes supported by this route. The scopes are used with a JWT authorizer to authorize the method invocation.
     * 
     */
    public Optional<Output<List<String>>> authorizationScopes() {
        return Optional.ofNullable(this.authorizationScopes);
    }

    /**
     * Authorization type for the route.
     * For WebSocket APIs, valid values are `NONE` for open access, `AWS_IAM` for using AWS IAM permissions, and `CUSTOM` for using a Lambda authorizer.
     * For HTTP APIs, valid values are `NONE` for open access, `JWT` for using JSON Web Tokens, `AWS_IAM` for using AWS IAM permissions, and `CUSTOM` for using a Lambda authorizer.
     * Defaults to `NONE`.
     * 
     */
    @Import(name="authorizationType")
    private @Nullable Output<String> authorizationType;

    /**
     * @return Authorization type for the route.
     * For WebSocket APIs, valid values are `NONE` for open access, `AWS_IAM` for using AWS IAM permissions, and `CUSTOM` for using a Lambda authorizer.
     * For HTTP APIs, valid values are `NONE` for open access, `JWT` for using JSON Web Tokens, `AWS_IAM` for using AWS IAM permissions, and `CUSTOM` for using a Lambda authorizer.
     * Defaults to `NONE`.
     * 
     */
    public Optional<Output<String>> authorizationType() {
        return Optional.ofNullable(this.authorizationType);
    }

    /**
     * Identifier of the `aws.apigatewayv2.Authorizer` resource to be associated with this route.
     * 
     */
    @Import(name="authorizerId")
    private @Nullable Output<String> authorizerId;

    /**
     * @return Identifier of the `aws.apigatewayv2.Authorizer` resource to be associated with this route.
     * 
     */
    public Optional<Output<String>> authorizerId() {
        return Optional.ofNullable(this.authorizerId);
    }

    /**
     * The [model selection expression](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-selection-expressions.html#apigateway-websocket-api-model-selection-expressions) for the route. Supported only for WebSocket APIs.
     * 
     */
    @Import(name="modelSelectionExpression")
    private @Nullable Output<String> modelSelectionExpression;

    /**
     * @return The [model selection expression](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-selection-expressions.html#apigateway-websocket-api-model-selection-expressions) for the route. Supported only for WebSocket APIs.
     * 
     */
    public Optional<Output<String>> modelSelectionExpression() {
        return Optional.ofNullable(this.modelSelectionExpression);
    }

    /**
     * Operation name for the route. Must be between 1 and 64 characters in length.
     * 
     */
    @Import(name="operationName")
    private @Nullable Output<String> operationName;

    /**
     * @return Operation name for the route. Must be between 1 and 64 characters in length.
     * 
     */
    public Optional<Output<String>> operationName() {
        return Optional.ofNullable(this.operationName);
    }

    /**
     * Request models for the route. Supported only for WebSocket APIs.
     * 
     */
    @Import(name="requestModels")
    private @Nullable Output<Map<String,String>> requestModels;

    /**
     * @return Request models for the route. Supported only for WebSocket APIs.
     * 
     */
    public Optional<Output<Map<String,String>>> requestModels() {
        return Optional.ofNullable(this.requestModels);
    }

    /**
     * Request parameters for the route. Supported only for WebSocket APIs.
     * 
     */
    @Import(name="requestParameters")
    private @Nullable Output<List<RouteRequestParameterArgs>> requestParameters;

    /**
     * @return Request parameters for the route. Supported only for WebSocket APIs.
     * 
     */
    public Optional<Output<List<RouteRequestParameterArgs>>> requestParameters() {
        return Optional.ofNullable(this.requestParameters);
    }

    /**
     * Route key for the route. For HTTP APIs, the route key can be either `$default`, or a combination of an HTTP method and resource path, for example, `GET /pets`.
     * 
     */
    @Import(name="routeKey")
    private @Nullable Output<String> routeKey;

    /**
     * @return Route key for the route. For HTTP APIs, the route key can be either `$default`, or a combination of an HTTP method and resource path, for example, `GET /pets`.
     * 
     */
    public Optional<Output<String>> routeKey() {
        return Optional.ofNullable(this.routeKey);
    }

    /**
     * The [route response selection expression](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-selection-expressions.html#apigateway-websocket-api-route-response-selection-expressions) for the route. Supported only for WebSocket APIs.
     * 
     */
    @Import(name="routeResponseSelectionExpression")
    private @Nullable Output<String> routeResponseSelectionExpression;

    /**
     * @return The [route response selection expression](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-selection-expressions.html#apigateway-websocket-api-route-response-selection-expressions) for the route. Supported only for WebSocket APIs.
     * 
     */
    public Optional<Output<String>> routeResponseSelectionExpression() {
        return Optional.ofNullable(this.routeResponseSelectionExpression);
    }

    /**
     * Target for the route, of the form `integrations/`*`IntegrationID`*, where *`IntegrationID`* is the identifier of an `aws.apigatewayv2.Integration` resource.
     * 
     */
    @Import(name="target")
    private @Nullable Output<String> target;

    /**
     * @return Target for the route, of the form `integrations/`*`IntegrationID`*, where *`IntegrationID`* is the identifier of an `aws.apigatewayv2.Integration` resource.
     * 
     */
    public Optional<Output<String>> target() {
        return Optional.ofNullable(this.target);
    }

    private RouteState() {}

    private RouteState(RouteState $) {
        this.apiId = $.apiId;
        this.apiKeyRequired = $.apiKeyRequired;
        this.authorizationScopes = $.authorizationScopes;
        this.authorizationType = $.authorizationType;
        this.authorizerId = $.authorizerId;
        this.modelSelectionExpression = $.modelSelectionExpression;
        this.operationName = $.operationName;
        this.requestModels = $.requestModels;
        this.requestParameters = $.requestParameters;
        this.routeKey = $.routeKey;
        this.routeResponseSelectionExpression = $.routeResponseSelectionExpression;
        this.target = $.target;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RouteState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RouteState $;

        public Builder() {
            $ = new RouteState();
        }

        public Builder(RouteState defaults) {
            $ = new RouteState(Objects.requireNonNull(defaults));
        }

        /**
         * @param apiId API identifier.
         * 
         * @return builder
         * 
         */
        public Builder apiId(@Nullable Output<String> apiId) {
            $.apiId = apiId;
            return this;
        }

        /**
         * @param apiId API identifier.
         * 
         * @return builder
         * 
         */
        public Builder apiId(String apiId) {
            return apiId(Output.of(apiId));
        }

        /**
         * @param apiKeyRequired Boolean whether an API key is required for the route. Defaults to `false`. Supported only for WebSocket APIs.
         * 
         * @return builder
         * 
         */
        public Builder apiKeyRequired(@Nullable Output<Boolean> apiKeyRequired) {
            $.apiKeyRequired = apiKeyRequired;
            return this;
        }

        /**
         * @param apiKeyRequired Boolean whether an API key is required for the route. Defaults to `false`. Supported only for WebSocket APIs.
         * 
         * @return builder
         * 
         */
        public Builder apiKeyRequired(Boolean apiKeyRequired) {
            return apiKeyRequired(Output.of(apiKeyRequired));
        }

        /**
         * @param authorizationScopes Authorization scopes supported by this route. The scopes are used with a JWT authorizer to authorize the method invocation.
         * 
         * @return builder
         * 
         */
        public Builder authorizationScopes(@Nullable Output<List<String>> authorizationScopes) {
            $.authorizationScopes = authorizationScopes;
            return this;
        }

        /**
         * @param authorizationScopes Authorization scopes supported by this route. The scopes are used with a JWT authorizer to authorize the method invocation.
         * 
         * @return builder
         * 
         */
        public Builder authorizationScopes(List<String> authorizationScopes) {
            return authorizationScopes(Output.of(authorizationScopes));
        }

        /**
         * @param authorizationScopes Authorization scopes supported by this route. The scopes are used with a JWT authorizer to authorize the method invocation.
         * 
         * @return builder
         * 
         */
        public Builder authorizationScopes(String... authorizationScopes) {
            return authorizationScopes(List.of(authorizationScopes));
        }

        /**
         * @param authorizationType Authorization type for the route.
         * For WebSocket APIs, valid values are `NONE` for open access, `AWS_IAM` for using AWS IAM permissions, and `CUSTOM` for using a Lambda authorizer.
         * For HTTP APIs, valid values are `NONE` for open access, `JWT` for using JSON Web Tokens, `AWS_IAM` for using AWS IAM permissions, and `CUSTOM` for using a Lambda authorizer.
         * Defaults to `NONE`.
         * 
         * @return builder
         * 
         */
        public Builder authorizationType(@Nullable Output<String> authorizationType) {
            $.authorizationType = authorizationType;
            return this;
        }

        /**
         * @param authorizationType Authorization type for the route.
         * For WebSocket APIs, valid values are `NONE` for open access, `AWS_IAM` for using AWS IAM permissions, and `CUSTOM` for using a Lambda authorizer.
         * For HTTP APIs, valid values are `NONE` for open access, `JWT` for using JSON Web Tokens, `AWS_IAM` for using AWS IAM permissions, and `CUSTOM` for using a Lambda authorizer.
         * Defaults to `NONE`.
         * 
         * @return builder
         * 
         */
        public Builder authorizationType(String authorizationType) {
            return authorizationType(Output.of(authorizationType));
        }

        /**
         * @param authorizerId Identifier of the `aws.apigatewayv2.Authorizer` resource to be associated with this route.
         * 
         * @return builder
         * 
         */
        public Builder authorizerId(@Nullable Output<String> authorizerId) {
            $.authorizerId = authorizerId;
            return this;
        }

        /**
         * @param authorizerId Identifier of the `aws.apigatewayv2.Authorizer` resource to be associated with this route.
         * 
         * @return builder
         * 
         */
        public Builder authorizerId(String authorizerId) {
            return authorizerId(Output.of(authorizerId));
        }

        /**
         * @param modelSelectionExpression The [model selection expression](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-selection-expressions.html#apigateway-websocket-api-model-selection-expressions) for the route. Supported only for WebSocket APIs.
         * 
         * @return builder
         * 
         */
        public Builder modelSelectionExpression(@Nullable Output<String> modelSelectionExpression) {
            $.modelSelectionExpression = modelSelectionExpression;
            return this;
        }

        /**
         * @param modelSelectionExpression The [model selection expression](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-selection-expressions.html#apigateway-websocket-api-model-selection-expressions) for the route. Supported only for WebSocket APIs.
         * 
         * @return builder
         * 
         */
        public Builder modelSelectionExpression(String modelSelectionExpression) {
            return modelSelectionExpression(Output.of(modelSelectionExpression));
        }

        /**
         * @param operationName Operation name for the route. Must be between 1 and 64 characters in length.
         * 
         * @return builder
         * 
         */
        public Builder operationName(@Nullable Output<String> operationName) {
            $.operationName = operationName;
            return this;
        }

        /**
         * @param operationName Operation name for the route. Must be between 1 and 64 characters in length.
         * 
         * @return builder
         * 
         */
        public Builder operationName(String operationName) {
            return operationName(Output.of(operationName));
        }

        /**
         * @param requestModels Request models for the route. Supported only for WebSocket APIs.
         * 
         * @return builder
         * 
         */
        public Builder requestModels(@Nullable Output<Map<String,String>> requestModels) {
            $.requestModels = requestModels;
            return this;
        }

        /**
         * @param requestModels Request models for the route. Supported only for WebSocket APIs.
         * 
         * @return builder
         * 
         */
        public Builder requestModels(Map<String,String> requestModels) {
            return requestModels(Output.of(requestModels));
        }

        /**
         * @param requestParameters Request parameters for the route. Supported only for WebSocket APIs.
         * 
         * @return builder
         * 
         */
        public Builder requestParameters(@Nullable Output<List<RouteRequestParameterArgs>> requestParameters) {
            $.requestParameters = requestParameters;
            return this;
        }

        /**
         * @param requestParameters Request parameters for the route. Supported only for WebSocket APIs.
         * 
         * @return builder
         * 
         */
        public Builder requestParameters(List<RouteRequestParameterArgs> requestParameters) {
            return requestParameters(Output.of(requestParameters));
        }

        /**
         * @param requestParameters Request parameters for the route. Supported only for WebSocket APIs.
         * 
         * @return builder
         * 
         */
        public Builder requestParameters(RouteRequestParameterArgs... requestParameters) {
            return requestParameters(List.of(requestParameters));
        }

        /**
         * @param routeKey Route key for the route. For HTTP APIs, the route key can be either `$default`, or a combination of an HTTP method and resource path, for example, `GET /pets`.
         * 
         * @return builder
         * 
         */
        public Builder routeKey(@Nullable Output<String> routeKey) {
            $.routeKey = routeKey;
            return this;
        }

        /**
         * @param routeKey Route key for the route. For HTTP APIs, the route key can be either `$default`, or a combination of an HTTP method and resource path, for example, `GET /pets`.
         * 
         * @return builder
         * 
         */
        public Builder routeKey(String routeKey) {
            return routeKey(Output.of(routeKey));
        }

        /**
         * @param routeResponseSelectionExpression The [route response selection expression](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-selection-expressions.html#apigateway-websocket-api-route-response-selection-expressions) for the route. Supported only for WebSocket APIs.
         * 
         * @return builder
         * 
         */
        public Builder routeResponseSelectionExpression(@Nullable Output<String> routeResponseSelectionExpression) {
            $.routeResponseSelectionExpression = routeResponseSelectionExpression;
            return this;
        }

        /**
         * @param routeResponseSelectionExpression The [route response selection expression](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-selection-expressions.html#apigateway-websocket-api-route-response-selection-expressions) for the route. Supported only for WebSocket APIs.
         * 
         * @return builder
         * 
         */
        public Builder routeResponseSelectionExpression(String routeResponseSelectionExpression) {
            return routeResponseSelectionExpression(Output.of(routeResponseSelectionExpression));
        }

        /**
         * @param target Target for the route, of the form `integrations/`*`IntegrationID`*, where *`IntegrationID`* is the identifier of an `aws.apigatewayv2.Integration` resource.
         * 
         * @return builder
         * 
         */
        public Builder target(@Nullable Output<String> target) {
            $.target = target;
            return this;
        }

        /**
         * @param target Target for the route, of the form `integrations/`*`IntegrationID`*, where *`IntegrationID`* is the identifier of an `aws.apigatewayv2.Integration` resource.
         * 
         * @return builder
         * 
         */
        public Builder target(String target) {
            return target(Output.of(target));
        }

        public RouteState build() {
            return $;
        }
    }

}
