// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.workspaces.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternRedactionPlaceHolder {
    /**
     * @return The redaction placeholder text that will replace the redacted text in session for the custom text redaction placeholder type.
     * 
     */
    private @Nullable String redactionPlaceHolderText;
    /**
     * @return The redaction placeholder type that will replace the redacted text in session. Currently, only `CustomText` is supported.
     * 
     */
    private String redactionPlaceHolderType;

    private WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternRedactionPlaceHolder() {}
    /**
     * @return The redaction placeholder text that will replace the redacted text in session for the custom text redaction placeholder type.
     * 
     */
    public Optional<String> redactionPlaceHolderText() {
        return Optional.ofNullable(this.redactionPlaceHolderText);
    }
    /**
     * @return The redaction placeholder type that will replace the redacted text in session. Currently, only `CustomText` is supported.
     * 
     */
    public String redactionPlaceHolderType() {
        return this.redactionPlaceHolderType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternRedactionPlaceHolder defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String redactionPlaceHolderText;
        private String redactionPlaceHolderType;
        public Builder() {}
        public Builder(WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternRedactionPlaceHolder defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.redactionPlaceHolderText = defaults.redactionPlaceHolderText;
    	      this.redactionPlaceHolderType = defaults.redactionPlaceHolderType;
        }

        @CustomType.Setter
        public Builder redactionPlaceHolderText(@Nullable String redactionPlaceHolderText) {

            this.redactionPlaceHolderText = redactionPlaceHolderText;
            return this;
        }
        @CustomType.Setter
        public Builder redactionPlaceHolderType(String redactionPlaceHolderType) {
            if (redactionPlaceHolderType == null) {
              throw new MissingRequiredPropertyException("WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternRedactionPlaceHolder", "redactionPlaceHolderType");
            }
            this.redactionPlaceHolderType = redactionPlaceHolderType;
            return this;
        }
        public WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternRedactionPlaceHolder build() {
            final var _resultValue = new WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternRedactionPlaceHolder();
            _resultValue.redactionPlaceHolderText = redactionPlaceHolderText;
            _resultValue.redactionPlaceHolderType = redactionPlaceHolderType;
            return _resultValue;
        }
    }
}
