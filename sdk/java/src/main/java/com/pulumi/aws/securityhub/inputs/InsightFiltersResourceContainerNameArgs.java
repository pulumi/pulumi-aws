// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.securityhub.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class InsightFiltersResourceContainerNameArgs extends com.pulumi.resources.ResourceArgs {

    public static final InsightFiltersResourceContainerNameArgs Empty = new InsightFiltersResourceContainerNameArgs();

    @Import(name="comparison", required=true)
    private Output<String> comparison;

    public Output<String> comparison() {
        return this.comparison;
    }

    @Import(name="value", required=true)
    private Output<String> value;

    public Output<String> value() {
        return this.value;
    }

    private InsightFiltersResourceContainerNameArgs() {}

    private InsightFiltersResourceContainerNameArgs(InsightFiltersResourceContainerNameArgs $) {
        this.comparison = $.comparison;
        this.value = $.value;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(InsightFiltersResourceContainerNameArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private InsightFiltersResourceContainerNameArgs $;

        public Builder() {
            $ = new InsightFiltersResourceContainerNameArgs();
        }

        public Builder(InsightFiltersResourceContainerNameArgs defaults) {
            $ = new InsightFiltersResourceContainerNameArgs(Objects.requireNonNull(defaults));
        }

        public Builder comparison(Output<String> comparison) {
            $.comparison = comparison;
            return this;
        }

        public Builder comparison(String comparison) {
            return comparison(Output.of(comparison));
        }

        public Builder value(Output<String> value) {
            $.value = value;
            return this;
        }

        public Builder value(String value) {
            return value(Output.of(value));
        }

        public InsightFiltersResourceContainerNameArgs build() {
            if ($.comparison == null) {
                throw new MissingRequiredPropertyException("InsightFiltersResourceContainerNameArgs", "comparison");
            }
            if ($.value == null) {
                throw new MissingRequiredPropertyException("InsightFiltersResourceContainerNameArgs", "value");
            }
            return $;
        }
    }

}
