// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.alb.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;


public final class ListenerRuleConditionHostHeaderArgs extends com.pulumi.resources.ResourceArgs {

    public static final ListenerRuleConditionHostHeaderArgs Empty = new ListenerRuleConditionHostHeaderArgs();

    @Import(name="values", required=true)
    private Output<List<String>> values;

    public Output<List<String>> values() {
        return this.values;
    }

    private ListenerRuleConditionHostHeaderArgs() {}

    private ListenerRuleConditionHostHeaderArgs(ListenerRuleConditionHostHeaderArgs $) {
        this.values = $.values;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ListenerRuleConditionHostHeaderArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ListenerRuleConditionHostHeaderArgs $;

        public Builder() {
            $ = new ListenerRuleConditionHostHeaderArgs();
        }

        public Builder(ListenerRuleConditionHostHeaderArgs defaults) {
            $ = new ListenerRuleConditionHostHeaderArgs(Objects.requireNonNull(defaults));
        }

        public Builder values(Output<List<String>> values) {
            $.values = values;
            return this;
        }

        public Builder values(List<String> values) {
            return values(Output.of(values));
        }

        public Builder values(String... values) {
            return values(List.of(values));
        }

        public ListenerRuleConditionHostHeaderArgs build() {
            if ($.values == null) {
                throw new MissingRequiredPropertyException("ListenerRuleConditionHostHeaderArgs", "values");
            }
            return $;
        }
    }

}
