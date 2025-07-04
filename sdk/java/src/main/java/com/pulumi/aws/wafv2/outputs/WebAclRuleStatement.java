// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.outputs;

import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementAndStatement;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementAsnMatchStatement;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementByteMatchStatement;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementGeoMatchStatement;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementIpSetReferenceStatement;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementLabelMatchStatement;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementManagedRuleGroupStatement;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementNotStatement;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementOrStatement;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementRateBasedStatement;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementRegexMatchStatement;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementRegexPatternSetReferenceStatement;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementRuleGroupReferenceStatement;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementSizeConstraintStatement;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementSqliMatchStatement;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementXssMatchStatement;
import com.pulumi.core.annotations.CustomType;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class WebAclRuleStatement {
    /**
     * @return Logical rule statement used to combine other rule statements with AND logic. See `and_statement` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementAndStatement andStatement;
    /**
     * @return Rule statement that inspects web traffic based on the Autonomous System Number (ASN) associated with the request&#39;s IP address. See `asn_match_statement` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementAsnMatchStatement asnMatchStatement;
    /**
     * @return Rule statement that defines a string match search for AWS WAF to apply to web requests. See `byte_match_statement` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementByteMatchStatement byteMatchStatement;
    /**
     * @return Rule statement used to identify web requests based on country of origin. See `geo_match_statement` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementGeoMatchStatement geoMatchStatement;
    /**
     * @return Rule statement used to detect web requests coming from particular IP addresses or address ranges. See `ip_set_reference_statement` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementIpSetReferenceStatement ipSetReferenceStatement;
    /**
     * @return Rule statement that defines a string match search against labels that have been added to the web request by rules that have already run in the web ACL. See `label_match_statement` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementLabelMatchStatement labelMatchStatement;
    /**
     * @return Rule statement used to run the rules that are defined in a managed rule group.  This statement can not be nested. See `managed_rule_group_statement` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementManagedRuleGroupStatement managedRuleGroupStatement;
    /**
     * @return Logical rule statement used to negate the results of another rule statement. See `not_statement` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementNotStatement notStatement;
    /**
     * @return Logical rule statement used to combine other rule statements with OR logic. See `or_statement` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementOrStatement orStatement;
    /**
     * @return Rate-based rule tracks the rate of requests for each originating `IP address`, and triggers the rule action when the rate exceeds a limit that you specify on the number of requests in any `5-minute` time span. This statement can not be nested. See `rate_based_statement` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementRateBasedStatement rateBasedStatement;
    /**
     * @return Rule statement used to search web request components for a match against a single regular expression. See `regex_match_statement` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementRegexMatchStatement regexMatchStatement;
    /**
     * @return Rule statement used to search web request components for matches with regular expressions. See `regex_pattern_set_reference_statement` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementRegexPatternSetReferenceStatement regexPatternSetReferenceStatement;
    /**
     * @return Rule statement used to run the rules that are defined in an WAFv2 Rule Group. See `rule_group_reference_statement` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementRuleGroupReferenceStatement ruleGroupReferenceStatement;
    /**
     * @return Rule statement that compares a number of bytes against the size of a request component, using a comparison operator, such as greater than (&gt;) or less than (&lt;). See `size_constraint_statement` below for more details.
     * 
     */
    private @Nullable WebAclRuleStatementSizeConstraintStatement sizeConstraintStatement;
    /**
     * @return An SQL injection match condition identifies the part of web requests, such as the URI or the query string, that you want AWS WAF to inspect. See `sqli_match_statement` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementSqliMatchStatement sqliMatchStatement;
    /**
     * @return Rule statement that defines a cross-site scripting (XSS) match search for AWS WAF to apply to web requests. See `xss_match_statement` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementXssMatchStatement xssMatchStatement;

    private WebAclRuleStatement() {}
    /**
     * @return Logical rule statement used to combine other rule statements with AND logic. See `and_statement` below for details.
     * 
     */
    public Optional<WebAclRuleStatementAndStatement> andStatement() {
        return Optional.ofNullable(this.andStatement);
    }
    /**
     * @return Rule statement that inspects web traffic based on the Autonomous System Number (ASN) associated with the request&#39;s IP address. See `asn_match_statement` below for details.
     * 
     */
    public Optional<WebAclRuleStatementAsnMatchStatement> asnMatchStatement() {
        return Optional.ofNullable(this.asnMatchStatement);
    }
    /**
     * @return Rule statement that defines a string match search for AWS WAF to apply to web requests. See `byte_match_statement` below for details.
     * 
     */
    public Optional<WebAclRuleStatementByteMatchStatement> byteMatchStatement() {
        return Optional.ofNullable(this.byteMatchStatement);
    }
    /**
     * @return Rule statement used to identify web requests based on country of origin. See `geo_match_statement` below for details.
     * 
     */
    public Optional<WebAclRuleStatementGeoMatchStatement> geoMatchStatement() {
        return Optional.ofNullable(this.geoMatchStatement);
    }
    /**
     * @return Rule statement used to detect web requests coming from particular IP addresses or address ranges. See `ip_set_reference_statement` below for details.
     * 
     */
    public Optional<WebAclRuleStatementIpSetReferenceStatement> ipSetReferenceStatement() {
        return Optional.ofNullable(this.ipSetReferenceStatement);
    }
    /**
     * @return Rule statement that defines a string match search against labels that have been added to the web request by rules that have already run in the web ACL. See `label_match_statement` below for details.
     * 
     */
    public Optional<WebAclRuleStatementLabelMatchStatement> labelMatchStatement() {
        return Optional.ofNullable(this.labelMatchStatement);
    }
    /**
     * @return Rule statement used to run the rules that are defined in a managed rule group.  This statement can not be nested. See `managed_rule_group_statement` below for details.
     * 
     */
    public Optional<WebAclRuleStatementManagedRuleGroupStatement> managedRuleGroupStatement() {
        return Optional.ofNullable(this.managedRuleGroupStatement);
    }
    /**
     * @return Logical rule statement used to negate the results of another rule statement. See `not_statement` below for details.
     * 
     */
    public Optional<WebAclRuleStatementNotStatement> notStatement() {
        return Optional.ofNullable(this.notStatement);
    }
    /**
     * @return Logical rule statement used to combine other rule statements with OR logic. See `or_statement` below for details.
     * 
     */
    public Optional<WebAclRuleStatementOrStatement> orStatement() {
        return Optional.ofNullable(this.orStatement);
    }
    /**
     * @return Rate-based rule tracks the rate of requests for each originating `IP address`, and triggers the rule action when the rate exceeds a limit that you specify on the number of requests in any `5-minute` time span. This statement can not be nested. See `rate_based_statement` below for details.
     * 
     */
    public Optional<WebAclRuleStatementRateBasedStatement> rateBasedStatement() {
        return Optional.ofNullable(this.rateBasedStatement);
    }
    /**
     * @return Rule statement used to search web request components for a match against a single regular expression. See `regex_match_statement` below for details.
     * 
     */
    public Optional<WebAclRuleStatementRegexMatchStatement> regexMatchStatement() {
        return Optional.ofNullable(this.regexMatchStatement);
    }
    /**
     * @return Rule statement used to search web request components for matches with regular expressions. See `regex_pattern_set_reference_statement` below for details.
     * 
     */
    public Optional<WebAclRuleStatementRegexPatternSetReferenceStatement> regexPatternSetReferenceStatement() {
        return Optional.ofNullable(this.regexPatternSetReferenceStatement);
    }
    /**
     * @return Rule statement used to run the rules that are defined in an WAFv2 Rule Group. See `rule_group_reference_statement` below for details.
     * 
     */
    public Optional<WebAclRuleStatementRuleGroupReferenceStatement> ruleGroupReferenceStatement() {
        return Optional.ofNullable(this.ruleGroupReferenceStatement);
    }
    /**
     * @return Rule statement that compares a number of bytes against the size of a request component, using a comparison operator, such as greater than (&gt;) or less than (&lt;). See `size_constraint_statement` below for more details.
     * 
     */
    public Optional<WebAclRuleStatementSizeConstraintStatement> sizeConstraintStatement() {
        return Optional.ofNullable(this.sizeConstraintStatement);
    }
    /**
     * @return An SQL injection match condition identifies the part of web requests, such as the URI or the query string, that you want AWS WAF to inspect. See `sqli_match_statement` below for details.
     * 
     */
    public Optional<WebAclRuleStatementSqliMatchStatement> sqliMatchStatement() {
        return Optional.ofNullable(this.sqliMatchStatement);
    }
    /**
     * @return Rule statement that defines a cross-site scripting (XSS) match search for AWS WAF to apply to web requests. See `xss_match_statement` below for details.
     * 
     */
    public Optional<WebAclRuleStatementXssMatchStatement> xssMatchStatement() {
        return Optional.ofNullable(this.xssMatchStatement);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(WebAclRuleStatement defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable WebAclRuleStatementAndStatement andStatement;
        private @Nullable WebAclRuleStatementAsnMatchStatement asnMatchStatement;
        private @Nullable WebAclRuleStatementByteMatchStatement byteMatchStatement;
        private @Nullable WebAclRuleStatementGeoMatchStatement geoMatchStatement;
        private @Nullable WebAclRuleStatementIpSetReferenceStatement ipSetReferenceStatement;
        private @Nullable WebAclRuleStatementLabelMatchStatement labelMatchStatement;
        private @Nullable WebAclRuleStatementManagedRuleGroupStatement managedRuleGroupStatement;
        private @Nullable WebAclRuleStatementNotStatement notStatement;
        private @Nullable WebAclRuleStatementOrStatement orStatement;
        private @Nullable WebAclRuleStatementRateBasedStatement rateBasedStatement;
        private @Nullable WebAclRuleStatementRegexMatchStatement regexMatchStatement;
        private @Nullable WebAclRuleStatementRegexPatternSetReferenceStatement regexPatternSetReferenceStatement;
        private @Nullable WebAclRuleStatementRuleGroupReferenceStatement ruleGroupReferenceStatement;
        private @Nullable WebAclRuleStatementSizeConstraintStatement sizeConstraintStatement;
        private @Nullable WebAclRuleStatementSqliMatchStatement sqliMatchStatement;
        private @Nullable WebAclRuleStatementXssMatchStatement xssMatchStatement;
        public Builder() {}
        public Builder(WebAclRuleStatement defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.andStatement = defaults.andStatement;
    	      this.asnMatchStatement = defaults.asnMatchStatement;
    	      this.byteMatchStatement = defaults.byteMatchStatement;
    	      this.geoMatchStatement = defaults.geoMatchStatement;
    	      this.ipSetReferenceStatement = defaults.ipSetReferenceStatement;
    	      this.labelMatchStatement = defaults.labelMatchStatement;
    	      this.managedRuleGroupStatement = defaults.managedRuleGroupStatement;
    	      this.notStatement = defaults.notStatement;
    	      this.orStatement = defaults.orStatement;
    	      this.rateBasedStatement = defaults.rateBasedStatement;
    	      this.regexMatchStatement = defaults.regexMatchStatement;
    	      this.regexPatternSetReferenceStatement = defaults.regexPatternSetReferenceStatement;
    	      this.ruleGroupReferenceStatement = defaults.ruleGroupReferenceStatement;
    	      this.sizeConstraintStatement = defaults.sizeConstraintStatement;
    	      this.sqliMatchStatement = defaults.sqliMatchStatement;
    	      this.xssMatchStatement = defaults.xssMatchStatement;
        }

        @CustomType.Setter
        public Builder andStatement(@Nullable WebAclRuleStatementAndStatement andStatement) {

            this.andStatement = andStatement;
            return this;
        }
        @CustomType.Setter
        public Builder asnMatchStatement(@Nullable WebAclRuleStatementAsnMatchStatement asnMatchStatement) {

            this.asnMatchStatement = asnMatchStatement;
            return this;
        }
        @CustomType.Setter
        public Builder byteMatchStatement(@Nullable WebAclRuleStatementByteMatchStatement byteMatchStatement) {

            this.byteMatchStatement = byteMatchStatement;
            return this;
        }
        @CustomType.Setter
        public Builder geoMatchStatement(@Nullable WebAclRuleStatementGeoMatchStatement geoMatchStatement) {

            this.geoMatchStatement = geoMatchStatement;
            return this;
        }
        @CustomType.Setter
        public Builder ipSetReferenceStatement(@Nullable WebAclRuleStatementIpSetReferenceStatement ipSetReferenceStatement) {

            this.ipSetReferenceStatement = ipSetReferenceStatement;
            return this;
        }
        @CustomType.Setter
        public Builder labelMatchStatement(@Nullable WebAclRuleStatementLabelMatchStatement labelMatchStatement) {

            this.labelMatchStatement = labelMatchStatement;
            return this;
        }
        @CustomType.Setter
        public Builder managedRuleGroupStatement(@Nullable WebAclRuleStatementManagedRuleGroupStatement managedRuleGroupStatement) {

            this.managedRuleGroupStatement = managedRuleGroupStatement;
            return this;
        }
        @CustomType.Setter
        public Builder notStatement(@Nullable WebAclRuleStatementNotStatement notStatement) {

            this.notStatement = notStatement;
            return this;
        }
        @CustomType.Setter
        public Builder orStatement(@Nullable WebAclRuleStatementOrStatement orStatement) {

            this.orStatement = orStatement;
            return this;
        }
        @CustomType.Setter
        public Builder rateBasedStatement(@Nullable WebAclRuleStatementRateBasedStatement rateBasedStatement) {

            this.rateBasedStatement = rateBasedStatement;
            return this;
        }
        @CustomType.Setter
        public Builder regexMatchStatement(@Nullable WebAclRuleStatementRegexMatchStatement regexMatchStatement) {

            this.regexMatchStatement = regexMatchStatement;
            return this;
        }
        @CustomType.Setter
        public Builder regexPatternSetReferenceStatement(@Nullable WebAclRuleStatementRegexPatternSetReferenceStatement regexPatternSetReferenceStatement) {

            this.regexPatternSetReferenceStatement = regexPatternSetReferenceStatement;
            return this;
        }
        @CustomType.Setter
        public Builder ruleGroupReferenceStatement(@Nullable WebAclRuleStatementRuleGroupReferenceStatement ruleGroupReferenceStatement) {

            this.ruleGroupReferenceStatement = ruleGroupReferenceStatement;
            return this;
        }
        @CustomType.Setter
        public Builder sizeConstraintStatement(@Nullable WebAclRuleStatementSizeConstraintStatement sizeConstraintStatement) {

            this.sizeConstraintStatement = sizeConstraintStatement;
            return this;
        }
        @CustomType.Setter
        public Builder sqliMatchStatement(@Nullable WebAclRuleStatementSqliMatchStatement sqliMatchStatement) {

            this.sqliMatchStatement = sqliMatchStatement;
            return this;
        }
        @CustomType.Setter
        public Builder xssMatchStatement(@Nullable WebAclRuleStatementXssMatchStatement xssMatchStatement) {

            this.xssMatchStatement = xssMatchStatement;
            return this;
        }
        public WebAclRuleStatement build() {
            final var _resultValue = new WebAclRuleStatement();
            _resultValue.andStatement = andStatement;
            _resultValue.asnMatchStatement = asnMatchStatement;
            _resultValue.byteMatchStatement = byteMatchStatement;
            _resultValue.geoMatchStatement = geoMatchStatement;
            _resultValue.ipSetReferenceStatement = ipSetReferenceStatement;
            _resultValue.labelMatchStatement = labelMatchStatement;
            _resultValue.managedRuleGroupStatement = managedRuleGroupStatement;
            _resultValue.notStatement = notStatement;
            _resultValue.orStatement = orStatement;
            _resultValue.rateBasedStatement = rateBasedStatement;
            _resultValue.regexMatchStatement = regexMatchStatement;
            _resultValue.regexPatternSetReferenceStatement = regexPatternSetReferenceStatement;
            _resultValue.ruleGroupReferenceStatement = ruleGroupReferenceStatement;
            _resultValue.sizeConstraintStatement = sizeConstraintStatement;
            _resultValue.sqliMatchStatement = sqliMatchStatement;
            _resultValue.xssMatchStatement = xssMatchStatement;
            return _resultValue;
        }
    }
}
