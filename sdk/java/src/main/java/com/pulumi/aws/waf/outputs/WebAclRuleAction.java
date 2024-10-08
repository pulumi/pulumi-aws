// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.waf.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class WebAclRuleAction {
    /**
     * @return valid values are: `BLOCK`, `ALLOW`, or `COUNT`
     * 
     */
    private String type;

    private WebAclRuleAction() {}
    /**
     * @return valid values are: `BLOCK`, `ALLOW`, or `COUNT`
     * 
     */
    public String type() {
        return this.type;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(WebAclRuleAction defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String type;
        public Builder() {}
        public Builder(WebAclRuleAction defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.type = defaults.type;
        }

        @CustomType.Setter
        public Builder type(String type) {
            if (type == null) {
              throw new MissingRequiredPropertyException("WebAclRuleAction", "type");
            }
            this.type = type;
            return this;
        }
        public WebAclRuleAction build() {
            final var _resultValue = new WebAclRuleAction();
            _resultValue.type = type;
            return _resultValue;
        }
    }
}
