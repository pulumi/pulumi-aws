// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.codebuild.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class WebhookFilterGroupFilter {
    /**
     * @return If set to `true`, the specified filter does *not* trigger a build. Defaults to `false`.
     * 
     */
    private @Nullable Boolean excludeMatchedPattern;
    /**
     * @return For a filter that uses `EVENT` type, a comma-separated string that specifies one event: `PUSH`, `PULL_REQUEST_CREATED`, `PULL_REQUEST_UPDATED`, `PULL_REQUEST_REOPENED`. `PULL_REQUEST_MERGED`, `WORKFLOW_JOB_QUEUED` works with GitHub &amp; GitHub Enterprise only. For a filter that uses any of the other filter types, a regular expression.
     * 
     */
    private String pattern;
    /**
     * @return The webhook filter group&#39;s type. Valid values for this parameter are: `EVENT`, `BASE_REF`, `HEAD_REF`, `ACTOR_ACCOUNT_ID`, `FILE_PATH`, `COMMIT_MESSAGE`, `WORKFLOW_NAME`, `TAG_NAME`, `RELEASE_NAME`. At least one filter group must specify `EVENT` as its type.
     * 
     */
    private String type;

    private WebhookFilterGroupFilter() {}
    /**
     * @return If set to `true`, the specified filter does *not* trigger a build. Defaults to `false`.
     * 
     */
    public Optional<Boolean> excludeMatchedPattern() {
        return Optional.ofNullable(this.excludeMatchedPattern);
    }
    /**
     * @return For a filter that uses `EVENT` type, a comma-separated string that specifies one event: `PUSH`, `PULL_REQUEST_CREATED`, `PULL_REQUEST_UPDATED`, `PULL_REQUEST_REOPENED`. `PULL_REQUEST_MERGED`, `WORKFLOW_JOB_QUEUED` works with GitHub &amp; GitHub Enterprise only. For a filter that uses any of the other filter types, a regular expression.
     * 
     */
    public String pattern() {
        return this.pattern;
    }
    /**
     * @return The webhook filter group&#39;s type. Valid values for this parameter are: `EVENT`, `BASE_REF`, `HEAD_REF`, `ACTOR_ACCOUNT_ID`, `FILE_PATH`, `COMMIT_MESSAGE`, `WORKFLOW_NAME`, `TAG_NAME`, `RELEASE_NAME`. At least one filter group must specify `EVENT` as its type.
     * 
     */
    public String type() {
        return this.type;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(WebhookFilterGroupFilter defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Boolean excludeMatchedPattern;
        private String pattern;
        private String type;
        public Builder() {}
        public Builder(WebhookFilterGroupFilter defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.excludeMatchedPattern = defaults.excludeMatchedPattern;
    	      this.pattern = defaults.pattern;
    	      this.type = defaults.type;
        }

        @CustomType.Setter
        public Builder excludeMatchedPattern(@Nullable Boolean excludeMatchedPattern) {

            this.excludeMatchedPattern = excludeMatchedPattern;
            return this;
        }
        @CustomType.Setter
        public Builder pattern(String pattern) {
            if (pattern == null) {
              throw new MissingRequiredPropertyException("WebhookFilterGroupFilter", "pattern");
            }
            this.pattern = pattern;
            return this;
        }
        @CustomType.Setter
        public Builder type(String type) {
            if (type == null) {
              throw new MissingRequiredPropertyException("WebhookFilterGroupFilter", "type");
            }
            this.type = type;
            return this;
        }
        public WebhookFilterGroupFilter build() {
            final var _resultValue = new WebhookFilterGroupFilter();
            _resultValue.excludeMatchedPattern = excludeMatchedPattern;
            _resultValue.pattern = pattern;
            _resultValue.type = type;
            return _resultValue;
        }
    }
}
