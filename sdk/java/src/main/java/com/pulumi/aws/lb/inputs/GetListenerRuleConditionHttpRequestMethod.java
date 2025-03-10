// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lb.inputs;

import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;


public final class GetListenerRuleConditionHttpRequestMethod extends com.pulumi.resources.InvokeArgs {

    public static final GetListenerRuleConditionHttpRequestMethod Empty = new GetListenerRuleConditionHttpRequestMethod();

    /**
     * Set of `key`-`value` pairs indicating the query string parameters to match.
     * 
     */
    @Import(name="values", required=true)
    private List<String> values;

    /**
     * @return Set of `key`-`value` pairs indicating the query string parameters to match.
     * 
     */
    public List<String> values() {
        return this.values;
    }

    private GetListenerRuleConditionHttpRequestMethod() {}

    private GetListenerRuleConditionHttpRequestMethod(GetListenerRuleConditionHttpRequestMethod $) {
        this.values = $.values;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetListenerRuleConditionHttpRequestMethod defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetListenerRuleConditionHttpRequestMethod $;

        public Builder() {
            $ = new GetListenerRuleConditionHttpRequestMethod();
        }

        public Builder(GetListenerRuleConditionHttpRequestMethod defaults) {
            $ = new GetListenerRuleConditionHttpRequestMethod(Objects.requireNonNull(defaults));
        }

        /**
         * @param values Set of `key`-`value` pairs indicating the query string parameters to match.
         * 
         * @return builder
         * 
         */
        public Builder values(List<String> values) {
            $.values = values;
            return this;
        }

        /**
         * @param values Set of `key`-`value` pairs indicating the query string parameters to match.
         * 
         * @return builder
         * 
         */
        public Builder values(String... values) {
            return values(List.of(values));
        }

        public GetListenerRuleConditionHttpRequestMethod build() {
            if ($.values == null) {
                throw new MissingRequiredPropertyException("GetListenerRuleConditionHttpRequestMethod", "values");
            }
            return $;
        }
    }

}
