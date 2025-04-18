// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.securityhub.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class AutomationRuleCriteriaResourceTagArgs extends com.pulumi.resources.ResourceArgs {

    public static final AutomationRuleCriteriaResourceTagArgs Empty = new AutomationRuleCriteriaResourceTagArgs();

    @Import(name="comparison", required=true)
    private Output<String> comparison;

    public Output<String> comparison() {
        return this.comparison;
    }

    /**
     * The key of the map filter.
     * 
     */
    @Import(name="key", required=true)
    private Output<String> key;

    /**
     * @return The key of the map filter.
     * 
     */
    public Output<String> key() {
        return this.key;
    }

    @Import(name="value", required=true)
    private Output<String> value;

    public Output<String> value() {
        return this.value;
    }

    private AutomationRuleCriteriaResourceTagArgs() {}

    private AutomationRuleCriteriaResourceTagArgs(AutomationRuleCriteriaResourceTagArgs $) {
        this.comparison = $.comparison;
        this.key = $.key;
        this.value = $.value;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AutomationRuleCriteriaResourceTagArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AutomationRuleCriteriaResourceTagArgs $;

        public Builder() {
            $ = new AutomationRuleCriteriaResourceTagArgs();
        }

        public Builder(AutomationRuleCriteriaResourceTagArgs defaults) {
            $ = new AutomationRuleCriteriaResourceTagArgs(Objects.requireNonNull(defaults));
        }

        public Builder comparison(Output<String> comparison) {
            $.comparison = comparison;
            return this;
        }

        public Builder comparison(String comparison) {
            return comparison(Output.of(comparison));
        }

        /**
         * @param key The key of the map filter.
         * 
         * @return builder
         * 
         */
        public Builder key(Output<String> key) {
            $.key = key;
            return this;
        }

        /**
         * @param key The key of the map filter.
         * 
         * @return builder
         * 
         */
        public Builder key(String key) {
            return key(Output.of(key));
        }

        public Builder value(Output<String> value) {
            $.value = value;
            return this;
        }

        public Builder value(String value) {
            return value(Output.of(value));
        }

        public AutomationRuleCriteriaResourceTagArgs build() {
            if ($.comparison == null) {
                throw new MissingRequiredPropertyException("AutomationRuleCriteriaResourceTagArgs", "comparison");
            }
            if ($.key == null) {
                throw new MissingRequiredPropertyException("AutomationRuleCriteriaResourceTagArgs", "key");
            }
            if ($.value == null) {
                throw new MissingRequiredPropertyException("AutomationRuleCriteriaResourceTagArgs", "value");
            }
            return $;
        }
    }

}
