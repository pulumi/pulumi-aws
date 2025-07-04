// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lightsail.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class DistributionCacheBehaviorSettingsForwardedHeadersArgs extends com.pulumi.resources.ResourceArgs {

    public static final DistributionCacheBehaviorSettingsForwardedHeadersArgs Empty = new DistributionCacheBehaviorSettingsForwardedHeadersArgs();

    /**
     * Specific headers to forward to your distribution&#39;s origin.
     * 
     */
    @Import(name="headersAllowLists")
    private @Nullable Output<List<String>> headersAllowLists;

    /**
     * @return Specific headers to forward to your distribution&#39;s origin.
     * 
     */
    public Optional<Output<List<String>>> headersAllowLists() {
        return Optional.ofNullable(this.headersAllowLists);
    }

    /**
     * Headers that you want your distribution to forward to your origin and base caching on. Valid values: `default`, `allow-list`, `all`.
     * 
     */
    @Import(name="option")
    private @Nullable Output<String> option;

    /**
     * @return Headers that you want your distribution to forward to your origin and base caching on. Valid values: `default`, `allow-list`, `all`.
     * 
     */
    public Optional<Output<String>> option() {
        return Optional.ofNullable(this.option);
    }

    private DistributionCacheBehaviorSettingsForwardedHeadersArgs() {}

    private DistributionCacheBehaviorSettingsForwardedHeadersArgs(DistributionCacheBehaviorSettingsForwardedHeadersArgs $) {
        this.headersAllowLists = $.headersAllowLists;
        this.option = $.option;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DistributionCacheBehaviorSettingsForwardedHeadersArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DistributionCacheBehaviorSettingsForwardedHeadersArgs $;

        public Builder() {
            $ = new DistributionCacheBehaviorSettingsForwardedHeadersArgs();
        }

        public Builder(DistributionCacheBehaviorSettingsForwardedHeadersArgs defaults) {
            $ = new DistributionCacheBehaviorSettingsForwardedHeadersArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param headersAllowLists Specific headers to forward to your distribution&#39;s origin.
         * 
         * @return builder
         * 
         */
        public Builder headersAllowLists(@Nullable Output<List<String>> headersAllowLists) {
            $.headersAllowLists = headersAllowLists;
            return this;
        }

        /**
         * @param headersAllowLists Specific headers to forward to your distribution&#39;s origin.
         * 
         * @return builder
         * 
         */
        public Builder headersAllowLists(List<String> headersAllowLists) {
            return headersAllowLists(Output.of(headersAllowLists));
        }

        /**
         * @param headersAllowLists Specific headers to forward to your distribution&#39;s origin.
         * 
         * @return builder
         * 
         */
        public Builder headersAllowLists(String... headersAllowLists) {
            return headersAllowLists(List.of(headersAllowLists));
        }

        /**
         * @param option Headers that you want your distribution to forward to your origin and base caching on. Valid values: `default`, `allow-list`, `all`.
         * 
         * @return builder
         * 
         */
        public Builder option(@Nullable Output<String> option) {
            $.option = option;
            return this;
        }

        /**
         * @param option Headers that you want your distribution to forward to your origin and base caching on. Valid values: `default`, `allow-list`, `all`.
         * 
         * @return builder
         * 
         */
        public Builder option(String option) {
            return option(Output.of(option));
        }

        public DistributionCacheBehaviorSettingsForwardedHeadersArgs build() {
            return $;
        }
    }

}
