// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class RuleGroupRuleStatementRegexMatchStatementFieldToMatchBody {
    private @Nullable String oversizeHandling;

    private RuleGroupRuleStatementRegexMatchStatementFieldToMatchBody() {}
    public Optional<String> oversizeHandling() {
        return Optional.ofNullable(this.oversizeHandling);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(RuleGroupRuleStatementRegexMatchStatementFieldToMatchBody defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String oversizeHandling;
        public Builder() {}
        public Builder(RuleGroupRuleStatementRegexMatchStatementFieldToMatchBody defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.oversizeHandling = defaults.oversizeHandling;
        }

        @CustomType.Setter
        public Builder oversizeHandling(@Nullable String oversizeHandling) {

            this.oversizeHandling = oversizeHandling;
            return this;
        }
        public RuleGroupRuleStatementRegexMatchStatementFieldToMatchBody build() {
            final var _resultValue = new RuleGroupRuleStatementRegexMatchStatementFieldToMatchBody();
            _resultValue.oversizeHandling = oversizeHandling;
            return _resultValue;
        }
    }
}
