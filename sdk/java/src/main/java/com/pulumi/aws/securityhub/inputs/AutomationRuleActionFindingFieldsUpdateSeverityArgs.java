// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.securityhub.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Double;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class AutomationRuleActionFindingFieldsUpdateSeverityArgs extends com.pulumi.resources.ResourceArgs {

    public static final AutomationRuleActionFindingFieldsUpdateSeverityArgs Empty = new AutomationRuleActionFindingFieldsUpdateSeverityArgs();

    /**
     * The severity value of the finding. The allowed values are the following `INFORMATIONAL`, `LOW`, `MEDIUM`, `HIGH` and `CRITICAL`.
     * 
     */
    @Import(name="label")
    private @Nullable Output<String> label;

    /**
     * @return The severity value of the finding. The allowed values are the following `INFORMATIONAL`, `LOW`, `MEDIUM`, `HIGH` and `CRITICAL`.
     * 
     */
    public Optional<Output<String>> label() {
        return Optional.ofNullable(this.label);
    }

    /**
     * The native severity as defined by the AWS service or integrated partner product that generated the finding.
     * 
     */
    @Import(name="product")
    private @Nullable Output<Double> product;

    /**
     * @return The native severity as defined by the AWS service or integrated partner product that generated the finding.
     * 
     */
    public Optional<Output<Double>> product() {
        return Optional.ofNullable(this.product);
    }

    private AutomationRuleActionFindingFieldsUpdateSeverityArgs() {}

    private AutomationRuleActionFindingFieldsUpdateSeverityArgs(AutomationRuleActionFindingFieldsUpdateSeverityArgs $) {
        this.label = $.label;
        this.product = $.product;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AutomationRuleActionFindingFieldsUpdateSeverityArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AutomationRuleActionFindingFieldsUpdateSeverityArgs $;

        public Builder() {
            $ = new AutomationRuleActionFindingFieldsUpdateSeverityArgs();
        }

        public Builder(AutomationRuleActionFindingFieldsUpdateSeverityArgs defaults) {
            $ = new AutomationRuleActionFindingFieldsUpdateSeverityArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param label The severity value of the finding. The allowed values are the following `INFORMATIONAL`, `LOW`, `MEDIUM`, `HIGH` and `CRITICAL`.
         * 
         * @return builder
         * 
         */
        public Builder label(@Nullable Output<String> label) {
            $.label = label;
            return this;
        }

        /**
         * @param label The severity value of the finding. The allowed values are the following `INFORMATIONAL`, `LOW`, `MEDIUM`, `HIGH` and `CRITICAL`.
         * 
         * @return builder
         * 
         */
        public Builder label(String label) {
            return label(Output.of(label));
        }

        /**
         * @param product The native severity as defined by the AWS service or integrated partner product that generated the finding.
         * 
         * @return builder
         * 
         */
        public Builder product(@Nullable Output<Double> product) {
            $.product = product;
            return this;
        }

        /**
         * @param product The native severity as defined by the AWS service or integrated partner product that generated the finding.
         * 
         * @return builder
         * 
         */
        public Builder product(Double product) {
            return product(Output.of(product));
        }

        public AutomationRuleActionFindingFieldsUpdateSeverityArgs build() {
            return $;
        }
    }

}
