// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cognito;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.cognito.ManagedUserPoolClientArgs;
import com.pulumi.aws.cognito.inputs.ManagedUserPoolClientState;
import com.pulumi.aws.cognito.outputs.ManagedUserPoolClientAnalyticsConfiguration;
import com.pulumi.aws.cognito.outputs.ManagedUserPoolClientRefreshTokenRotation;
import com.pulumi.aws.cognito.outputs.ManagedUserPoolClientTokenValidityUnits;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Use the `aws.cognito.UserPoolClient` resource to manage a Cognito User Pool Client.
 * 
 * **This resource is advanced** and has special caveats to consider before use. Please read this document completely before using the resource.
 * 
 * Use the `aws.cognito.ManagedUserPoolClient` resource to manage a Cognito User Pool Client that is automatically created by an AWS service. For instance, when [configuring an OpenSearch Domain to use Cognito authentication](https://docs.aws.amazon.com/opensearch-service/latest/developerguide/cognito-auth.html), the OpenSearch service creates the User Pool Client during setup and removes it when it is no longer required. As a result, the `aws.cognito.ManagedUserPoolClient` resource does not create or delete this resource, but instead assumes management of it.
 * 
 * Use the `aws.cognito.UserPoolClient` resource to manage Cognito User Pool Clients for normal use cases.
 * 
 * ## Example Usage
 * 
 * ### Using Name Pattern
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.cognito.ManagedUserPoolClient;
 * import com.pulumi.aws.cognito.ManagedUserPoolClientArgs;
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
 *         var example = new ManagedUserPoolClient("example", ManagedUserPoolClientArgs.builder()
 *             .namePattern("^AmazonOpenSearchService-example-(\\w+)$")
 *             .userPoolId(exampleAwsCognitoUserPool.id())
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
 * Using `pulumi import`, import Cognito User Pool Clients using the `id` of the Cognito User Pool and the `id` of the Cognito User Pool Client. For example:
 * 
 * ```sh
 * $ pulumi import aws:cognito/managedUserPoolClient:ManagedUserPoolClient client us-west-2_abc123/3ho4ek12345678909nh3fmhpko
 * ```
 * 
 */
@ResourceType(type="aws:cognito/managedUserPoolClient:ManagedUserPoolClient")
public class ManagedUserPoolClient extends com.pulumi.resources.CustomResource {
    /**
     * Time limit, between 5 minutes and 1 day, after which the access token is no longer valid and cannot be used. By default, the unit is hours. The unit can be overridden by a value in `token_validity_units.access_token`.
     * 
     */
    @Export(name="accessTokenValidity", refs={Integer.class}, tree="[0]")
    private Output<Integer> accessTokenValidity;

    /**
     * @return Time limit, between 5 minutes and 1 day, after which the access token is no longer valid and cannot be used. By default, the unit is hours. The unit can be overridden by a value in `token_validity_units.access_token`.
     * 
     */
    public Output<Integer> accessTokenValidity() {
        return this.accessTokenValidity;
    }
    /**
     * List of allowed OAuth flows, including `code`, `implicit`, and `client_credentials`. `allowed_oauth_flows_user_pool_client` must be set to `true` before you can configure this option.
     * 
     */
    @Export(name="allowedOauthFlows", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> allowedOauthFlows;

    /**
     * @return List of allowed OAuth flows, including `code`, `implicit`, and `client_credentials`. `allowed_oauth_flows_user_pool_client` must be set to `true` before you can configure this option.
     * 
     */
    public Output<List<String>> allowedOauthFlows() {
        return this.allowedOauthFlows;
    }
    /**
     * Whether the client is allowed to use OAuth 2.0 features. `allowed_oauth_flows_user_pool_client` must be set to `true` before you can configure the following arguments: `callback_urls`, `logout_urls`, `allowed_oauth_scopes` and `allowed_oauth_flows`.
     * 
     */
    @Export(name="allowedOauthFlowsUserPoolClient", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> allowedOauthFlowsUserPoolClient;

    /**
     * @return Whether the client is allowed to use OAuth 2.0 features. `allowed_oauth_flows_user_pool_client` must be set to `true` before you can configure the following arguments: `callback_urls`, `logout_urls`, `allowed_oauth_scopes` and `allowed_oauth_flows`.
     * 
     */
    public Output<Boolean> allowedOauthFlowsUserPoolClient() {
        return this.allowedOauthFlowsUserPoolClient;
    }
    /**
     * List of allowed OAuth scopes, including `phone`, `email`, `openid`, `profile`, and `aws.cognito.signin.user.admin`. `allowed_oauth_flows_user_pool_client` must be set to `true` before you can configure this option.
     * 
     */
    @Export(name="allowedOauthScopes", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> allowedOauthScopes;

    /**
     * @return List of allowed OAuth scopes, including `phone`, `email`, `openid`, `profile`, and `aws.cognito.signin.user.admin`. `allowed_oauth_flows_user_pool_client` must be set to `true` before you can configure this option.
     * 
     */
    public Output<List<String>> allowedOauthScopes() {
        return this.allowedOauthScopes;
    }
    /**
     * Configuration block for Amazon Pinpoint analytics that collects metrics for this user pool. See details below.
     * 
     */
    @Export(name="analyticsConfiguration", refs={ManagedUserPoolClientAnalyticsConfiguration.class}, tree="[0]")
    private Output</* @Nullable */ ManagedUserPoolClientAnalyticsConfiguration> analyticsConfiguration;

    /**
     * @return Configuration block for Amazon Pinpoint analytics that collects metrics for this user pool. See details below.
     * 
     */
    public Output<Optional<ManagedUserPoolClientAnalyticsConfiguration>> analyticsConfiguration() {
        return Codegen.optional(this.analyticsConfiguration);
    }
    /**
     * Duration, in minutes, of the session token created by Amazon Cognito for each API request in an authentication flow. The session token must be responded to by the native user of the user pool before it expires. Valid values for `auth_session_validity` are between `3` and `15`, with a default value of `3`.
     * 
     */
    @Export(name="authSessionValidity", refs={Integer.class}, tree="[0]")
    private Output<Integer> authSessionValidity;

    /**
     * @return Duration, in minutes, of the session token created by Amazon Cognito for each API request in an authentication flow. The session token must be responded to by the native user of the user pool before it expires. Valid values for `auth_session_validity` are between `3` and `15`, with a default value of `3`.
     * 
     */
    public Output<Integer> authSessionValidity() {
        return this.authSessionValidity;
    }
    /**
     * List of allowed callback URLs for the identity providers. `allowed_oauth_flows_user_pool_client` must be set to `true` before you can configure this option.
     * 
     */
    @Export(name="callbackUrls", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> callbackUrls;

    /**
     * @return List of allowed callback URLs for the identity providers. `allowed_oauth_flows_user_pool_client` must be set to `true` before you can configure this option.
     * 
     */
    public Output<List<String>> callbackUrls() {
        return this.callbackUrls;
    }
    /**
     * Client secret of the user pool client.
     * 
     */
    @Export(name="clientSecret", refs={String.class}, tree="[0]")
    private Output<String> clientSecret;

    /**
     * @return Client secret of the user pool client.
     * 
     */
    public Output<String> clientSecret() {
        return this.clientSecret;
    }
    /**
     * Default redirect URI and must be included in the list of callback URLs.
     * 
     */
    @Export(name="defaultRedirectUri", refs={String.class}, tree="[0]")
    private Output<String> defaultRedirectUri;

    /**
     * @return Default redirect URI and must be included in the list of callback URLs.
     * 
     */
    public Output<String> defaultRedirectUri() {
        return this.defaultRedirectUri;
    }
    /**
     * Enables the propagation of additional user context data.
     * 
     */
    @Export(name="enablePropagateAdditionalUserContextData", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> enablePropagateAdditionalUserContextData;

    /**
     * @return Enables the propagation of additional user context data.
     * 
     */
    public Output<Boolean> enablePropagateAdditionalUserContextData() {
        return this.enablePropagateAdditionalUserContextData;
    }
    /**
     * Enables or disables token revocation.
     * 
     */
    @Export(name="enableTokenRevocation", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> enableTokenRevocation;

    /**
     * @return Enables or disables token revocation.
     * 
     */
    public Output<Boolean> enableTokenRevocation() {
        return this.enableTokenRevocation;
    }
    /**
     * List of authentication flows. The available options include ADMIN_NO_SRP_AUTH, CUSTOM_AUTH_FLOW_ONLY, USER_PASSWORD_AUTH, ALLOW_ADMIN_USER_PASSWORD_AUTH, ALLOW_CUSTOM_AUTH, ALLOW_USER_PASSWORD_AUTH, ALLOW_USER_SRP_AUTH, and ALLOW_REFRESH_TOKEN_AUTH.
     * 
     */
    @Export(name="explicitAuthFlows", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> explicitAuthFlows;

    /**
     * @return List of authentication flows. The available options include ADMIN_NO_SRP_AUTH, CUSTOM_AUTH_FLOW_ONLY, USER_PASSWORD_AUTH, ALLOW_ADMIN_USER_PASSWORD_AUTH, ALLOW_CUSTOM_AUTH, ALLOW_USER_PASSWORD_AUTH, ALLOW_USER_SRP_AUTH, and ALLOW_REFRESH_TOKEN_AUTH.
     * 
     */
    public Output<List<String>> explicitAuthFlows() {
        return this.explicitAuthFlows;
    }
    /**
     * Time limit, between 5 minutes and 1 day, after which the ID token is no longer valid and cannot be used. By default, the unit is hours. The unit can be overridden by a value in `token_validity_units.id_token`.
     * 
     */
    @Export(name="idTokenValidity", refs={Integer.class}, tree="[0]")
    private Output<Integer> idTokenValidity;

    /**
     * @return Time limit, between 5 minutes and 1 day, after which the ID token is no longer valid and cannot be used. By default, the unit is hours. The unit can be overridden by a value in `token_validity_units.id_token`.
     * 
     */
    public Output<Integer> idTokenValidity() {
        return this.idTokenValidity;
    }
    /**
     * List of allowed logout URLs for the identity providers. `allowed_oauth_flows_user_pool_client` must be set to `true` before you can configure this option.
     * 
     */
    @Export(name="logoutUrls", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> logoutUrls;

    /**
     * @return List of allowed logout URLs for the identity providers. `allowed_oauth_flows_user_pool_client` must be set to `true` before you can configure this option.
     * 
     */
    public Output<List<String>> logoutUrls() {
        return this.logoutUrls;
    }
    /**
     * Name of the user pool client.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return Name of the user pool client.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * Regular expression that matches the name of the existing User Pool Client to be managed. It must only match one User Pool Client.
     * 
     */
    @Export(name="namePattern", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> namePattern;

    /**
     * @return Regular expression that matches the name of the existing User Pool Client to be managed. It must only match one User Pool Client.
     * 
     */
    public Output<Optional<String>> namePattern() {
        return Codegen.optional(this.namePattern);
    }
    /**
     * String that matches the beginning of the name of the  existing User Pool Client to be managed. It must match only one User Pool Client.
     * 
     * The following arguments are optional:
     * 
     */
    @Export(name="namePrefix", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> namePrefix;

    /**
     * @return String that matches the beginning of the name of the  existing User Pool Client to be managed. It must match only one User Pool Client.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<Optional<String>> namePrefix() {
        return Codegen.optional(this.namePrefix);
    }
    /**
     * Setting determines the errors and responses returned by Cognito APIs when a user does not exist in the user pool during authentication, account confirmation, and password recovery.
     * 
     */
    @Export(name="preventUserExistenceErrors", refs={String.class}, tree="[0]")
    private Output<String> preventUserExistenceErrors;

    /**
     * @return Setting determines the errors and responses returned by Cognito APIs when a user does not exist in the user pool during authentication, account confirmation, and password recovery.
     * 
     */
    public Output<String> preventUserExistenceErrors() {
        return this.preventUserExistenceErrors;
    }
    /**
     * List of user pool attributes that the application client can read from.
     * 
     */
    @Export(name="readAttributes", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> readAttributes;

    /**
     * @return List of user pool attributes that the application client can read from.
     * 
     */
    public Output<List<String>> readAttributes() {
        return this.readAttributes;
    }
    /**
     * A block that specifies the configuration of refresh token rotation. Detailed below.
     * 
     */
    @Export(name="refreshTokenRotation", refs={ManagedUserPoolClientRefreshTokenRotation.class}, tree="[0]")
    private Output</* @Nullable */ ManagedUserPoolClientRefreshTokenRotation> refreshTokenRotation;

    /**
     * @return A block that specifies the configuration of refresh token rotation. Detailed below.
     * 
     */
    public Output<Optional<ManagedUserPoolClientRefreshTokenRotation>> refreshTokenRotation() {
        return Codegen.optional(this.refreshTokenRotation);
    }
    /**
     * Time limit, between 60 minutes and 10 years, after which the refresh token is no longer valid and cannot be used. By default, the unit is days. The unit can be overridden by a value in `token_validity_units.refresh_token`.
     * 
     */
    @Export(name="refreshTokenValidity", refs={Integer.class}, tree="[0]")
    private Output<Integer> refreshTokenValidity;

    /**
     * @return Time limit, between 60 minutes and 10 years, after which the refresh token is no longer valid and cannot be used. By default, the unit is days. The unit can be overridden by a value in `token_validity_units.refresh_token`.
     * 
     */
    public Output<Integer> refreshTokenValidity() {
        return this.refreshTokenValidity;
    }
    /**
     * List of provider names for the identity providers that are supported on this client. It uses the `provider_name` attribute of the `aws.cognito.IdentityProvider` resource(s), or the equivalent string(s).
     * 
     */
    @Export(name="supportedIdentityProviders", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> supportedIdentityProviders;

    /**
     * @return List of provider names for the identity providers that are supported on this client. It uses the `provider_name` attribute of the `aws.cognito.IdentityProvider` resource(s), or the equivalent string(s).
     * 
     */
    public Output<List<String>> supportedIdentityProviders() {
        return this.supportedIdentityProviders;
    }
    /**
     * Configuration block for representing the validity times in units. See details below. Detailed below.
     * 
     */
    @Export(name="tokenValidityUnits", refs={ManagedUserPoolClientTokenValidityUnits.class}, tree="[0]")
    private Output</* @Nullable */ ManagedUserPoolClientTokenValidityUnits> tokenValidityUnits;

    /**
     * @return Configuration block for representing the validity times in units. See details below. Detailed below.
     * 
     */
    public Output<Optional<ManagedUserPoolClientTokenValidityUnits>> tokenValidityUnits() {
        return Codegen.optional(this.tokenValidityUnits);
    }
    /**
     * User pool that the client belongs to.
     * 
     */
    @Export(name="userPoolId", refs={String.class}, tree="[0]")
    private Output<String> userPoolId;

    /**
     * @return User pool that the client belongs to.
     * 
     */
    public Output<String> userPoolId() {
        return this.userPoolId;
    }
    /**
     * List of user pool attributes that the application client can write to.
     * 
     */
    @Export(name="writeAttributes", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> writeAttributes;

    /**
     * @return List of user pool attributes that the application client can write to.
     * 
     */
    public Output<List<String>> writeAttributes() {
        return this.writeAttributes;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public ManagedUserPoolClient(java.lang.String name) {
        this(name, ManagedUserPoolClientArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public ManagedUserPoolClient(java.lang.String name, ManagedUserPoolClientArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public ManagedUserPoolClient(java.lang.String name, ManagedUserPoolClientArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:cognito/managedUserPoolClient:ManagedUserPoolClient", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private ManagedUserPoolClient(java.lang.String name, Output<java.lang.String> id, @Nullable ManagedUserPoolClientState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:cognito/managedUserPoolClient:ManagedUserPoolClient", name, state, makeResourceOptions(options, id), false);
    }

    private static ManagedUserPoolClientArgs makeArgs(ManagedUserPoolClientArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? ManagedUserPoolClientArgs.Empty : args;
    }

    private static com.pulumi.resources.CustomResourceOptions makeResourceOptions(@Nullable com.pulumi.resources.CustomResourceOptions options, @Nullable Output<java.lang.String> id) {
        var defaultOptions = com.pulumi.resources.CustomResourceOptions.builder()
            .version(Utilities.getVersion())
            .additionalSecretOutputs(List.of(
                "clientSecret"
            ))
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
    public static ManagedUserPoolClient get(java.lang.String name, Output<java.lang.String> id, @Nullable ManagedUserPoolClientState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new ManagedUserPoolClient(name, id, state, options);
    }
}
