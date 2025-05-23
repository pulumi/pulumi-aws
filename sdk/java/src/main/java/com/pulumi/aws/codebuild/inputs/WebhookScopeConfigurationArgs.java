// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.codebuild.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class WebhookScopeConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final WebhookScopeConfigurationArgs Empty = new WebhookScopeConfigurationArgs();

    /**
     * The domain of the GitHub Enterprise organization. Required if your project&#39;s source type is GITHUB_ENTERPRISE.
     * 
     */
    @Import(name="domain")
    private @Nullable Output<String> domain;

    /**
     * @return The domain of the GitHub Enterprise organization. Required if your project&#39;s source type is GITHUB_ENTERPRISE.
     * 
     */
    public Optional<Output<String>> domain() {
        return Optional.ofNullable(this.domain);
    }

    /**
     * The name of either the enterprise or organization.
     * 
     */
    @Import(name="name", required=true)
    private Output<String> name;

    /**
     * @return The name of either the enterprise or organization.
     * 
     */
    public Output<String> name() {
        return this.name;
    }

    /**
     * The type of scope for a GitHub webhook. Valid values for this parameter are: `GITHUB_ORGANIZATION`, `GITHUB_GLOBAL`.
     * 
     */
    @Import(name="scope", required=true)
    private Output<String> scope;

    /**
     * @return The type of scope for a GitHub webhook. Valid values for this parameter are: `GITHUB_ORGANIZATION`, `GITHUB_GLOBAL`.
     * 
     */
    public Output<String> scope() {
        return this.scope;
    }

    private WebhookScopeConfigurationArgs() {}

    private WebhookScopeConfigurationArgs(WebhookScopeConfigurationArgs $) {
        this.domain = $.domain;
        this.name = $.name;
        this.scope = $.scope;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(WebhookScopeConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private WebhookScopeConfigurationArgs $;

        public Builder() {
            $ = new WebhookScopeConfigurationArgs();
        }

        public Builder(WebhookScopeConfigurationArgs defaults) {
            $ = new WebhookScopeConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param domain The domain of the GitHub Enterprise organization. Required if your project&#39;s source type is GITHUB_ENTERPRISE.
         * 
         * @return builder
         * 
         */
        public Builder domain(@Nullable Output<String> domain) {
            $.domain = domain;
            return this;
        }

        /**
         * @param domain The domain of the GitHub Enterprise organization. Required if your project&#39;s source type is GITHUB_ENTERPRISE.
         * 
         * @return builder
         * 
         */
        public Builder domain(String domain) {
            return domain(Output.of(domain));
        }

        /**
         * @param name The name of either the enterprise or organization.
         * 
         * @return builder
         * 
         */
        public Builder name(Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name The name of either the enterprise or organization.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param scope The type of scope for a GitHub webhook. Valid values for this parameter are: `GITHUB_ORGANIZATION`, `GITHUB_GLOBAL`.
         * 
         * @return builder
         * 
         */
        public Builder scope(Output<String> scope) {
            $.scope = scope;
            return this;
        }

        /**
         * @param scope The type of scope for a GitHub webhook. Valid values for this parameter are: `GITHUB_ORGANIZATION`, `GITHUB_GLOBAL`.
         * 
         * @return builder
         * 
         */
        public Builder scope(String scope) {
            return scope(Output.of(scope));
        }

        public WebhookScopeConfigurationArgs build() {
            if ($.name == null) {
                throw new MissingRequiredPropertyException("WebhookScopeConfigurationArgs", "name");
            }
            if ($.scope == null) {
                throw new MissingRequiredPropertyException("WebhookScopeConfigurationArgs", "scope");
            }
            return $;
        }
    }

}
