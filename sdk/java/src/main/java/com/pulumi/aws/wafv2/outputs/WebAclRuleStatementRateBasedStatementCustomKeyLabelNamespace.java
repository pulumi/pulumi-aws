// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class WebAclRuleStatementRateBasedStatementCustomKeyLabelNamespace {
    /**
     * @return The namespace to use for aggregation
     * 
     */
    private String namespace;

    private WebAclRuleStatementRateBasedStatementCustomKeyLabelNamespace() {}
    /**
     * @return The namespace to use for aggregation
     * 
     */
    public String namespace() {
        return this.namespace;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(WebAclRuleStatementRateBasedStatementCustomKeyLabelNamespace defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String namespace;
        public Builder() {}
        public Builder(WebAclRuleStatementRateBasedStatementCustomKeyLabelNamespace defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.namespace = defaults.namespace;
        }

        @CustomType.Setter
        public Builder namespace(String namespace) {
            if (namespace == null) {
              throw new MissingRequiredPropertyException("WebAclRuleStatementRateBasedStatementCustomKeyLabelNamespace", "namespace");
            }
            this.namespace = namespace;
            return this;
        }
        public WebAclRuleStatementRateBasedStatementCustomKeyLabelNamespace build() {
            final var _resultValue = new WebAclRuleStatementRateBasedStatementCustomKeyLabelNamespace();
            _resultValue.namespace = namespace;
            return _resultValue;
        }
    }
}
