// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appfabric;

import com.pulumi.aws.appfabric.inputs.AppAuthorizationCredentialArgs;
import com.pulumi.aws.appfabric.inputs.AppAuthorizationTenantArgs;
import com.pulumi.aws.appfabric.inputs.AppAuthorizationTimeoutsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class AppAuthorizationArgs extends com.pulumi.resources.ResourceArgs {

    public static final AppAuthorizationArgs Empty = new AppAuthorizationArgs();

    /**
     * The name of the application for valid values see https://docs.aws.amazon.com/appfabric/latest/api/API_CreateAppAuthorization.html.
     * 
     */
    @Import(name="app", required=true)
    private Output<String> app;

    /**
     * @return The name of the application for valid values see https://docs.aws.amazon.com/appfabric/latest/api/API_CreateAppAuthorization.html.
     * 
     */
    public Output<String> app() {
        return this.app;
    }

    /**
     * The Amazon Resource Name (ARN) of the app bundle to use for the request.
     * 
     */
    @Import(name="appBundleArn", required=true)
    private Output<String> appBundleArn;

    /**
     * @return The Amazon Resource Name (ARN) of the app bundle to use for the request.
     * 
     */
    public Output<String> appBundleArn() {
        return this.appBundleArn;
    }

    /**
     * The authorization type for the app authorization valid values are oauth2 and apiKey.
     * 
     */
    @Import(name="authType", required=true)
    private Output<String> authType;

    /**
     * @return The authorization type for the app authorization valid values are oauth2 and apiKey.
     * 
     */
    public Output<String> authType() {
        return this.authType;
    }

    /**
     * Contains credentials for the application, such as an API key or OAuth2 client ID and secret.
     * Specify credentials that match the authorization type for your request. For example, if the authorization type for your request is OAuth2 (oauth2), then you should provide only the OAuth2 credentials.
     * 
     */
    @Import(name="credential")
    private @Nullable Output<AppAuthorizationCredentialArgs> credential;

    /**
     * @return Contains credentials for the application, such as an API key or OAuth2 client ID and secret.
     * Specify credentials that match the authorization type for your request. For example, if the authorization type for your request is OAuth2 (oauth2), then you should provide only the OAuth2 credentials.
     * 
     */
    public Optional<Output<AppAuthorizationCredentialArgs>> credential() {
        return Optional.ofNullable(this.credential);
    }

    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * Contains information about an application tenant, such as the application display name and identifier.
     * 
     */
    @Import(name="tenants")
    private @Nullable Output<List<AppAuthorizationTenantArgs>> tenants;

    /**
     * @return Contains information about an application tenant, such as the application display name and identifier.
     * 
     */
    public Optional<Output<List<AppAuthorizationTenantArgs>>> tenants() {
        return Optional.ofNullable(this.tenants);
    }

    @Import(name="timeouts")
    private @Nullable Output<AppAuthorizationTimeoutsArgs> timeouts;

    public Optional<Output<AppAuthorizationTimeoutsArgs>> timeouts() {
        return Optional.ofNullable(this.timeouts);
    }

    private AppAuthorizationArgs() {}

    private AppAuthorizationArgs(AppAuthorizationArgs $) {
        this.app = $.app;
        this.appBundleArn = $.appBundleArn;
        this.authType = $.authType;
        this.credential = $.credential;
        this.tags = $.tags;
        this.tenants = $.tenants;
        this.timeouts = $.timeouts;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AppAuthorizationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AppAuthorizationArgs $;

        public Builder() {
            $ = new AppAuthorizationArgs();
        }

        public Builder(AppAuthorizationArgs defaults) {
            $ = new AppAuthorizationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param app The name of the application for valid values see https://docs.aws.amazon.com/appfabric/latest/api/API_CreateAppAuthorization.html.
         * 
         * @return builder
         * 
         */
        public Builder app(Output<String> app) {
            $.app = app;
            return this;
        }

        /**
         * @param app The name of the application for valid values see https://docs.aws.amazon.com/appfabric/latest/api/API_CreateAppAuthorization.html.
         * 
         * @return builder
         * 
         */
        public Builder app(String app) {
            return app(Output.of(app));
        }

        /**
         * @param appBundleArn The Amazon Resource Name (ARN) of the app bundle to use for the request.
         * 
         * @return builder
         * 
         */
        public Builder appBundleArn(Output<String> appBundleArn) {
            $.appBundleArn = appBundleArn;
            return this;
        }

        /**
         * @param appBundleArn The Amazon Resource Name (ARN) of the app bundle to use for the request.
         * 
         * @return builder
         * 
         */
        public Builder appBundleArn(String appBundleArn) {
            return appBundleArn(Output.of(appBundleArn));
        }

        /**
         * @param authType The authorization type for the app authorization valid values are oauth2 and apiKey.
         * 
         * @return builder
         * 
         */
        public Builder authType(Output<String> authType) {
            $.authType = authType;
            return this;
        }

        /**
         * @param authType The authorization type for the app authorization valid values are oauth2 and apiKey.
         * 
         * @return builder
         * 
         */
        public Builder authType(String authType) {
            return authType(Output.of(authType));
        }

        /**
         * @param credential Contains credentials for the application, such as an API key or OAuth2 client ID and secret.
         * Specify credentials that match the authorization type for your request. For example, if the authorization type for your request is OAuth2 (oauth2), then you should provide only the OAuth2 credentials.
         * 
         * @return builder
         * 
         */
        public Builder credential(@Nullable Output<AppAuthorizationCredentialArgs> credential) {
            $.credential = credential;
            return this;
        }

        /**
         * @param credential Contains credentials for the application, such as an API key or OAuth2 client ID and secret.
         * Specify credentials that match the authorization type for your request. For example, if the authorization type for your request is OAuth2 (oauth2), then you should provide only the OAuth2 credentials.
         * 
         * @return builder
         * 
         */
        public Builder credential(AppAuthorizationCredentialArgs credential) {
            return credential(Output.of(credential));
        }

        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param tenants Contains information about an application tenant, such as the application display name and identifier.
         * 
         * @return builder
         * 
         */
        public Builder tenants(@Nullable Output<List<AppAuthorizationTenantArgs>> tenants) {
            $.tenants = tenants;
            return this;
        }

        /**
         * @param tenants Contains information about an application tenant, such as the application display name and identifier.
         * 
         * @return builder
         * 
         */
        public Builder tenants(List<AppAuthorizationTenantArgs> tenants) {
            return tenants(Output.of(tenants));
        }

        /**
         * @param tenants Contains information about an application tenant, such as the application display name and identifier.
         * 
         * @return builder
         * 
         */
        public Builder tenants(AppAuthorizationTenantArgs... tenants) {
            return tenants(List.of(tenants));
        }

        public Builder timeouts(@Nullable Output<AppAuthorizationTimeoutsArgs> timeouts) {
            $.timeouts = timeouts;
            return this;
        }

        public Builder timeouts(AppAuthorizationTimeoutsArgs timeouts) {
            return timeouts(Output.of(timeouts));
        }

        public AppAuthorizationArgs build() {
            if ($.app == null) {
                throw new MissingRequiredPropertyException("AppAuthorizationArgs", "app");
            }
            if ($.appBundleArn == null) {
                throw new MissingRequiredPropertyException("AppAuthorizationArgs", "appBundleArn");
            }
            if ($.authType == null) {
                throw new MissingRequiredPropertyException("AppAuthorizationArgs", "authType");
            }
            return $;
        }
    }

}
