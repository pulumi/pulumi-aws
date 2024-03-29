// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class V2modelsSlotTypeValueSelectionSettingRegexFilter {
    /**
     * @return Used to validate the value of a slot. Use a standard regular expression. Amazon Lex supports the following characters in the regular expression: A-Z, a-z, 0-9, Unicode characters (&#34;\⁠u&#34;).
     * Represent Unicode characters with four digits, for example &#34;\⁠u0041&#34; or &#34;\⁠u005A&#34;. The following regular expression operators are not supported: Infinite repeaters: *, +, or {x,} with no upper bound, wild card (.)
     * 
     */
    private String pattern;

    private V2modelsSlotTypeValueSelectionSettingRegexFilter() {}
    /**
     * @return Used to validate the value of a slot. Use a standard regular expression. Amazon Lex supports the following characters in the regular expression: A-Z, a-z, 0-9, Unicode characters (&#34;\⁠u&#34;).
     * Represent Unicode characters with four digits, for example &#34;\⁠u0041&#34; or &#34;\⁠u005A&#34;. The following regular expression operators are not supported: Infinite repeaters: *, +, or {x,} with no upper bound, wild card (.)
     * 
     */
    public String pattern() {
        return this.pattern;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(V2modelsSlotTypeValueSelectionSettingRegexFilter defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String pattern;
        public Builder() {}
        public Builder(V2modelsSlotTypeValueSelectionSettingRegexFilter defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.pattern = defaults.pattern;
        }

        @CustomType.Setter
        public Builder pattern(String pattern) {
            if (pattern == null) {
              throw new MissingRequiredPropertyException("V2modelsSlotTypeValueSelectionSettingRegexFilter", "pattern");
            }
            this.pattern = pattern;
            return this;
        }
        public V2modelsSlotTypeValueSelectionSettingRegexFilter build() {
            final var _resultValue = new V2modelsSlotTypeValueSelectionSettingRegexFilter();
            _resultValue.pattern = pattern;
            return _resultValue;
        }
    }
}
