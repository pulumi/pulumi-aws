// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.iam.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class OpenIdConnectProviderState extends com.pulumi.resources.ResourceArgs {

    public static final OpenIdConnectProviderState Empty = new OpenIdConnectProviderState();

    /**
     * ARN assigned by AWS for this provider.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return ARN assigned by AWS for this provider.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * List of client IDs (audiences) that identify the application registered with the OpenID Connect provider. This is the value sent as the `client_id` parameter in OAuth requests.
     * 
     */
    @Import(name="clientIdLists")
    private @Nullable Output<List<String>> clientIdLists;

    /**
     * @return List of client IDs (audiences) that identify the application registered with the OpenID Connect provider. This is the value sent as the `client_id` parameter in OAuth requests.
     * 
     */
    public Optional<Output<List<String>>> clientIdLists() {
        return Optional.ofNullable(this.clientIdLists);
    }

    /**
     * Map of resource tags for the IAM OIDC provider. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Map of resource tags for the IAM OIDC provider. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Import(name="tagsAll")
    private @Nullable Output<Map<String,String>> tagsAll;

    /**
     * @return Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    public Optional<Output<Map<String,String>>> tagsAll() {
        return Optional.ofNullable(this.tagsAll);
    }

    @Import(name="thumbprintLists")
    private @Nullable Output<List<String>> thumbprintLists;

    public Optional<Output<List<String>>> thumbprintLists() {
        return Optional.ofNullable(this.thumbprintLists);
    }

    /**
     * URL of the identity provider, corresponding to the `iss` claim.
     * 
     */
    @Import(name="url")
    private @Nullable Output<String> url;

    /**
     * @return URL of the identity provider, corresponding to the `iss` claim.
     * 
     */
    public Optional<Output<String>> url() {
        return Optional.ofNullable(this.url);
    }

    private OpenIdConnectProviderState() {}

    private OpenIdConnectProviderState(OpenIdConnectProviderState $) {
        this.arn = $.arn;
        this.clientIdLists = $.clientIdLists;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
        this.thumbprintLists = $.thumbprintLists;
        this.url = $.url;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(OpenIdConnectProviderState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private OpenIdConnectProviderState $;

        public Builder() {
            $ = new OpenIdConnectProviderState();
        }

        public Builder(OpenIdConnectProviderState defaults) {
            $ = new OpenIdConnectProviderState(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn ARN assigned by AWS for this provider.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn ARN assigned by AWS for this provider.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param clientIdLists List of client IDs (audiences) that identify the application registered with the OpenID Connect provider. This is the value sent as the `client_id` parameter in OAuth requests.
         * 
         * @return builder
         * 
         */
        public Builder clientIdLists(@Nullable Output<List<String>> clientIdLists) {
            $.clientIdLists = clientIdLists;
            return this;
        }

        /**
         * @param clientIdLists List of client IDs (audiences) that identify the application registered with the OpenID Connect provider. This is the value sent as the `client_id` parameter in OAuth requests.
         * 
         * @return builder
         * 
         */
        public Builder clientIdLists(List<String> clientIdLists) {
            return clientIdLists(Output.of(clientIdLists));
        }

        /**
         * @param clientIdLists List of client IDs (audiences) that identify the application registered with the OpenID Connect provider. This is the value sent as the `client_id` parameter in OAuth requests.
         * 
         * @return builder
         * 
         */
        public Builder clientIdLists(String... clientIdLists) {
            return clientIdLists(List.of(clientIdLists));
        }

        /**
         * @param tags Map of resource tags for the IAM OIDC provider. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Map of resource tags for the IAM OIDC provider. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param tagsAll Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(@Nullable Output<Map<String,String>> tagsAll) {
            $.tagsAll = tagsAll;
            return this;
        }

        /**
         * @param tagsAll Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(Map<String,String> tagsAll) {
            return tagsAll(Output.of(tagsAll));
        }

        public Builder thumbprintLists(@Nullable Output<List<String>> thumbprintLists) {
            $.thumbprintLists = thumbprintLists;
            return this;
        }

        public Builder thumbprintLists(List<String> thumbprintLists) {
            return thumbprintLists(Output.of(thumbprintLists));
        }

        public Builder thumbprintLists(String... thumbprintLists) {
            return thumbprintLists(List.of(thumbprintLists));
        }

        /**
         * @param url URL of the identity provider, corresponding to the `iss` claim.
         * 
         * @return builder
         * 
         */
        public Builder url(@Nullable Output<String> url) {
            $.url = url;
            return this;
        }

        /**
         * @param url URL of the identity provider, corresponding to the `iss` claim.
         * 
         * @return builder
         * 
         */
        public Builder url(String url) {
            return url(Output.of(url));
        }

        public OpenIdConnectProviderState build() {
            return $;
        }
    }

}
