// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.workspacesweb.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class BrowserSettingsState extends com.pulumi.resources.ResourceArgs {

    public static final BrowserSettingsState Empty = new BrowserSettingsState();

    /**
     * Additional encryption context for the browser settings.
     * 
     */
    @Import(name="additionalEncryptionContext")
    private @Nullable Output<Map<String,String>> additionalEncryptionContext;

    /**
     * @return Additional encryption context for the browser settings.
     * 
     */
    public Optional<Output<Map<String,String>>> additionalEncryptionContext() {
        return Optional.ofNullable(this.additionalEncryptionContext);
    }

    /**
     * List of web portal ARNs to associate with the browser settings.
     * 
     */
    @Import(name="associatedPortalArns")
    private @Nullable Output<List<String>> associatedPortalArns;

    /**
     * @return List of web portal ARNs to associate with the browser settings.
     * 
     */
    public Optional<Output<List<String>>> associatedPortalArns() {
        return Optional.ofNullable(this.associatedPortalArns);
    }

    /**
     * Browser policy for the browser settings. This is a JSON string that defines the browser settings policy.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="browserPolicy")
    private @Nullable Output<String> browserPolicy;

    /**
     * @return Browser policy for the browser settings. This is a JSON string that defines the browser settings policy.
     * 
     * The following arguments are optional:
     * 
     */
    public Optional<Output<String>> browserPolicy() {
        return Optional.ofNullable(this.browserPolicy);
    }

    /**
     * ARN of the browser settings resource.
     * 
     */
    @Import(name="browserSettingsArn")
    private @Nullable Output<String> browserSettingsArn;

    /**
     * @return ARN of the browser settings resource.
     * 
     */
    public Optional<Output<String>> browserSettingsArn() {
        return Optional.ofNullable(this.browserSettingsArn);
    }

    /**
     * ARN of the customer managed KMS key.
     * 
     */
    @Import(name="customerManagedKey")
    private @Nullable Output<String> customerManagedKey;

    /**
     * @return ARN of the customer managed KMS key.
     * 
     */
    public Optional<Output<String>> customerManagedKey() {
        return Optional.ofNullable(this.customerManagedKey);
    }

    /**
     * Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

    private BrowserSettingsState() {}

    private BrowserSettingsState(BrowserSettingsState $) {
        this.additionalEncryptionContext = $.additionalEncryptionContext;
        this.associatedPortalArns = $.associatedPortalArns;
        this.browserPolicy = $.browserPolicy;
        this.browserSettingsArn = $.browserSettingsArn;
        this.customerManagedKey = $.customerManagedKey;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(BrowserSettingsState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private BrowserSettingsState $;

        public Builder() {
            $ = new BrowserSettingsState();
        }

        public Builder(BrowserSettingsState defaults) {
            $ = new BrowserSettingsState(Objects.requireNonNull(defaults));
        }

        /**
         * @param additionalEncryptionContext Additional encryption context for the browser settings.
         * 
         * @return builder
         * 
         */
        public Builder additionalEncryptionContext(@Nullable Output<Map<String,String>> additionalEncryptionContext) {
            $.additionalEncryptionContext = additionalEncryptionContext;
            return this;
        }

        /**
         * @param additionalEncryptionContext Additional encryption context for the browser settings.
         * 
         * @return builder
         * 
         */
        public Builder additionalEncryptionContext(Map<String,String> additionalEncryptionContext) {
            return additionalEncryptionContext(Output.of(additionalEncryptionContext));
        }

        /**
         * @param associatedPortalArns List of web portal ARNs to associate with the browser settings.
         * 
         * @return builder
         * 
         */
        public Builder associatedPortalArns(@Nullable Output<List<String>> associatedPortalArns) {
            $.associatedPortalArns = associatedPortalArns;
            return this;
        }

        /**
         * @param associatedPortalArns List of web portal ARNs to associate with the browser settings.
         * 
         * @return builder
         * 
         */
        public Builder associatedPortalArns(List<String> associatedPortalArns) {
            return associatedPortalArns(Output.of(associatedPortalArns));
        }

        /**
         * @param associatedPortalArns List of web portal ARNs to associate with the browser settings.
         * 
         * @return builder
         * 
         */
        public Builder associatedPortalArns(String... associatedPortalArns) {
            return associatedPortalArns(List.of(associatedPortalArns));
        }

        /**
         * @param browserPolicy Browser policy for the browser settings. This is a JSON string that defines the browser settings policy.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder browserPolicy(@Nullable Output<String> browserPolicy) {
            $.browserPolicy = browserPolicy;
            return this;
        }

        /**
         * @param browserPolicy Browser policy for the browser settings. This is a JSON string that defines the browser settings policy.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder browserPolicy(String browserPolicy) {
            return browserPolicy(Output.of(browserPolicy));
        }

        /**
         * @param browserSettingsArn ARN of the browser settings resource.
         * 
         * @return builder
         * 
         */
        public Builder browserSettingsArn(@Nullable Output<String> browserSettingsArn) {
            $.browserSettingsArn = browserSettingsArn;
            return this;
        }

        /**
         * @param browserSettingsArn ARN of the browser settings resource.
         * 
         * @return builder
         * 
         */
        public Builder browserSettingsArn(String browserSettingsArn) {
            return browserSettingsArn(Output.of(browserSettingsArn));
        }

        /**
         * @param customerManagedKey ARN of the customer managed KMS key.
         * 
         * @return builder
         * 
         */
        public Builder customerManagedKey(@Nullable Output<String> customerManagedKey) {
            $.customerManagedKey = customerManagedKey;
            return this;
        }

        /**
         * @param customerManagedKey ARN of the customer managed KMS key.
         * 
         * @return builder
         * 
         */
        public Builder customerManagedKey(String customerManagedKey) {
            return customerManagedKey(Output.of(customerManagedKey));
        }

        /**
         * @param tags Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

        public BrowserSettingsState build() {
            return $;
        }
    }

}
