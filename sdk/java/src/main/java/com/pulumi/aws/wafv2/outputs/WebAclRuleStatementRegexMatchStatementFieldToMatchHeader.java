// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.outputs;

import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementRegexMatchStatementFieldToMatchHeaderMatchPattern;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class WebAclRuleStatementRegexMatchStatementFieldToMatchHeader {
    /**
     * @return The filter to use to identify the subset of headers to inspect in a web request. The `match_pattern` block supports only one of the following arguments:
     * 
     */
    private WebAclRuleStatementRegexMatchStatementFieldToMatchHeaderMatchPattern matchPattern;
    /**
     * @return The parts of the headers to inspect with the rule inspection criteria. If you specify `All`, AWS WAF inspects both keys and values. Valid values include the following: `ALL`, `Key`, `Value`.
     * 
     */
    private String matchScope;
    /**
     * @return Oversize handling tells AWS WAF what to do with a web request when the request component that the rule inspects is over the limits. Valid values include the following: `CONTINUE`, `MATCH`, `NO_MATCH`. See the AWS [documentation](https://docs.aws.amazon.com/waf/latest/developerguide/waf-rule-statement-oversize-handling.html) for more information.
     * 
     */
    private String oversizeHandling;

    private WebAclRuleStatementRegexMatchStatementFieldToMatchHeader() {}
    /**
     * @return The filter to use to identify the subset of headers to inspect in a web request. The `match_pattern` block supports only one of the following arguments:
     * 
     */
    public WebAclRuleStatementRegexMatchStatementFieldToMatchHeaderMatchPattern matchPattern() {
        return this.matchPattern;
    }
    /**
     * @return The parts of the headers to inspect with the rule inspection criteria. If you specify `All`, AWS WAF inspects both keys and values. Valid values include the following: `ALL`, `Key`, `Value`.
     * 
     */
    public String matchScope() {
        return this.matchScope;
    }
    /**
     * @return Oversize handling tells AWS WAF what to do with a web request when the request component that the rule inspects is over the limits. Valid values include the following: `CONTINUE`, `MATCH`, `NO_MATCH`. See the AWS [documentation](https://docs.aws.amazon.com/waf/latest/developerguide/waf-rule-statement-oversize-handling.html) for more information.
     * 
     */
    public String oversizeHandling() {
        return this.oversizeHandling;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(WebAclRuleStatementRegexMatchStatementFieldToMatchHeader defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private WebAclRuleStatementRegexMatchStatementFieldToMatchHeaderMatchPattern matchPattern;
        private String matchScope;
        private String oversizeHandling;
        public Builder() {}
        public Builder(WebAclRuleStatementRegexMatchStatementFieldToMatchHeader defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.matchPattern = defaults.matchPattern;
    	      this.matchScope = defaults.matchScope;
    	      this.oversizeHandling = defaults.oversizeHandling;
        }

        @CustomType.Setter
        public Builder matchPattern(WebAclRuleStatementRegexMatchStatementFieldToMatchHeaderMatchPattern matchPattern) {
            if (matchPattern == null) {
              throw new MissingRequiredPropertyException("WebAclRuleStatementRegexMatchStatementFieldToMatchHeader", "matchPattern");
            }
            this.matchPattern = matchPattern;
            return this;
        }
        @CustomType.Setter
        public Builder matchScope(String matchScope) {
            if (matchScope == null) {
              throw new MissingRequiredPropertyException("WebAclRuleStatementRegexMatchStatementFieldToMatchHeader", "matchScope");
            }
            this.matchScope = matchScope;
            return this;
        }
        @CustomType.Setter
        public Builder oversizeHandling(String oversizeHandling) {
            if (oversizeHandling == null) {
              throw new MissingRequiredPropertyException("WebAclRuleStatementRegexMatchStatementFieldToMatchHeader", "oversizeHandling");
            }
            this.oversizeHandling = oversizeHandling;
            return this;
        }
        public WebAclRuleStatementRegexMatchStatementFieldToMatchHeader build() {
            final var _resultValue = new WebAclRuleStatementRegexMatchStatementFieldToMatchHeader();
            _resultValue.matchPattern = matchPattern;
            _resultValue.matchScope = matchScope;
            _resultValue.oversizeHandling = oversizeHandling;
            return _resultValue;
        }
    }
}
