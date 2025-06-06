// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.inputs;

import com.pulumi.aws.wafv2.inputs.RuleGroupRuleStatementRateBasedStatementCustomKeyCookieTextTransformationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;


public final class RuleGroupRuleStatementRateBasedStatementCustomKeyCookieArgs extends com.pulumi.resources.ResourceArgs {

    public static final RuleGroupRuleStatementRateBasedStatementCustomKeyCookieArgs Empty = new RuleGroupRuleStatementRateBasedStatementCustomKeyCookieArgs();

    /**
     * A friendly name of the rule group.
     * 
     */
    @Import(name="name", required=true)
    private Output<String> name;

    /**
     * @return A friendly name of the rule group.
     * 
     */
    public Output<String> name() {
        return this.name;
    }

    /**
     * Text transformations eliminate some of the unusual formatting that attackers use in web requests in an effort to bypass detection. They are used in rate-based rule statements, to transform request components before using them as custom aggregation keys. Atleast one transformation is required. See Text Transformation above for details.
     * 
     */
    @Import(name="textTransformations", required=true)
    private Output<List<RuleGroupRuleStatementRateBasedStatementCustomKeyCookieTextTransformationArgs>> textTransformations;

    /**
     * @return Text transformations eliminate some of the unusual formatting that attackers use in web requests in an effort to bypass detection. They are used in rate-based rule statements, to transform request components before using them as custom aggregation keys. Atleast one transformation is required. See Text Transformation above for details.
     * 
     */
    public Output<List<RuleGroupRuleStatementRateBasedStatementCustomKeyCookieTextTransformationArgs>> textTransformations() {
        return this.textTransformations;
    }

    private RuleGroupRuleStatementRateBasedStatementCustomKeyCookieArgs() {}

    private RuleGroupRuleStatementRateBasedStatementCustomKeyCookieArgs(RuleGroupRuleStatementRateBasedStatementCustomKeyCookieArgs $) {
        this.name = $.name;
        this.textTransformations = $.textTransformations;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RuleGroupRuleStatementRateBasedStatementCustomKeyCookieArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RuleGroupRuleStatementRateBasedStatementCustomKeyCookieArgs $;

        public Builder() {
            $ = new RuleGroupRuleStatementRateBasedStatementCustomKeyCookieArgs();
        }

        public Builder(RuleGroupRuleStatementRateBasedStatementCustomKeyCookieArgs defaults) {
            $ = new RuleGroupRuleStatementRateBasedStatementCustomKeyCookieArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param name A friendly name of the rule group.
         * 
         * @return builder
         * 
         */
        public Builder name(Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name A friendly name of the rule group.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param textTransformations Text transformations eliminate some of the unusual formatting that attackers use in web requests in an effort to bypass detection. They are used in rate-based rule statements, to transform request components before using them as custom aggregation keys. Atleast one transformation is required. See Text Transformation above for details.
         * 
         * @return builder
         * 
         */
        public Builder textTransformations(Output<List<RuleGroupRuleStatementRateBasedStatementCustomKeyCookieTextTransformationArgs>> textTransformations) {
            $.textTransformations = textTransformations;
            return this;
        }

        /**
         * @param textTransformations Text transformations eliminate some of the unusual formatting that attackers use in web requests in an effort to bypass detection. They are used in rate-based rule statements, to transform request components before using them as custom aggregation keys. Atleast one transformation is required. See Text Transformation above for details.
         * 
         * @return builder
         * 
         */
        public Builder textTransformations(List<RuleGroupRuleStatementRateBasedStatementCustomKeyCookieTextTransformationArgs> textTransformations) {
            return textTransformations(Output.of(textTransformations));
        }

        /**
         * @param textTransformations Text transformations eliminate some of the unusual formatting that attackers use in web requests in an effort to bypass detection. They are used in rate-based rule statements, to transform request components before using them as custom aggregation keys. Atleast one transformation is required. See Text Transformation above for details.
         * 
         * @return builder
         * 
         */
        public Builder textTransformations(RuleGroupRuleStatementRateBasedStatementCustomKeyCookieTextTransformationArgs... textTransformations) {
            return textTransformations(List.of(textTransformations));
        }

        public RuleGroupRuleStatementRateBasedStatementCustomKeyCookieArgs build() {
            if ($.name == null) {
                throw new MissingRequiredPropertyException("RuleGroupRuleStatementRateBasedStatementCustomKeyCookieArgs", "name");
            }
            if ($.textTransformations == null) {
                throw new MissingRequiredPropertyException("RuleGroupRuleStatementRateBasedStatementCustomKeyCookieArgs", "textTransformations");
            }
            return $;
        }
    }

}
