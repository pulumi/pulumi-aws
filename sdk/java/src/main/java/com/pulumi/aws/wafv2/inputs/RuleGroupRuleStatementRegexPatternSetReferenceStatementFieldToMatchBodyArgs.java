// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchBodyArgs extends com.pulumi.resources.ResourceArgs {

    public static final RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchBodyArgs Empty = new RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchBodyArgs();

    @Import(name="oversizeHandling")
    private @Nullable Output<String> oversizeHandling;

    public Optional<Output<String>> oversizeHandling() {
        return Optional.ofNullable(this.oversizeHandling);
    }

    private RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchBodyArgs() {}

    private RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchBodyArgs(RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchBodyArgs $) {
        this.oversizeHandling = $.oversizeHandling;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchBodyArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchBodyArgs $;

        public Builder() {
            $ = new RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchBodyArgs();
        }

        public Builder(RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchBodyArgs defaults) {
            $ = new RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchBodyArgs(Objects.requireNonNull(defaults));
        }

        public Builder oversizeHandling(@Nullable Output<String> oversizeHandling) {
            $.oversizeHandling = oversizeHandling;
            return this;
        }

        public Builder oversizeHandling(String oversizeHandling) {
            return oversizeHandling(Output.of(oversizeHandling));
        }

        public RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchBodyArgs build() {
            return $;
        }
    }

}
