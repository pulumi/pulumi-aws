// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.computeoptimizer.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class RecommendationPreferencesUtilizationPreferenceMetricParametersArgs extends com.pulumi.resources.ResourceArgs {

    public static final RecommendationPreferencesUtilizationPreferenceMetricParametersArgs Empty = new RecommendationPreferencesUtilizationPreferenceMetricParametersArgs();

    /**
     * The headroom value in percentage used for the specified metric parameter. Valid values: `PERCENT_30`, `PERCENT_20`, `PERCENT_10`, `PERCENT_0`.
     * 
     */
    @Import(name="headroom", required=true)
    private Output<String> headroom;

    /**
     * @return The headroom value in percentage used for the specified metric parameter. Valid values: `PERCENT_30`, `PERCENT_20`, `PERCENT_10`, `PERCENT_0`.
     * 
     */
    public Output<String> headroom() {
        return this.headroom;
    }

    /**
     * The threshold value used for the specified metric parameter. You can only specify the threshold value for CPU utilization. Valid values: `P90`, `P95`, `P99_5`.
     * 
     */
    @Import(name="threshold")
    private @Nullable Output<String> threshold;

    /**
     * @return The threshold value used for the specified metric parameter. You can only specify the threshold value for CPU utilization. Valid values: `P90`, `P95`, `P99_5`.
     * 
     */
    public Optional<Output<String>> threshold() {
        return Optional.ofNullable(this.threshold);
    }

    private RecommendationPreferencesUtilizationPreferenceMetricParametersArgs() {}

    private RecommendationPreferencesUtilizationPreferenceMetricParametersArgs(RecommendationPreferencesUtilizationPreferenceMetricParametersArgs $) {
        this.headroom = $.headroom;
        this.threshold = $.threshold;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RecommendationPreferencesUtilizationPreferenceMetricParametersArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RecommendationPreferencesUtilizationPreferenceMetricParametersArgs $;

        public Builder() {
            $ = new RecommendationPreferencesUtilizationPreferenceMetricParametersArgs();
        }

        public Builder(RecommendationPreferencesUtilizationPreferenceMetricParametersArgs defaults) {
            $ = new RecommendationPreferencesUtilizationPreferenceMetricParametersArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param headroom The headroom value in percentage used for the specified metric parameter. Valid values: `PERCENT_30`, `PERCENT_20`, `PERCENT_10`, `PERCENT_0`.
         * 
         * @return builder
         * 
         */
        public Builder headroom(Output<String> headroom) {
            $.headroom = headroom;
            return this;
        }

        /**
         * @param headroom The headroom value in percentage used for the specified metric parameter. Valid values: `PERCENT_30`, `PERCENT_20`, `PERCENT_10`, `PERCENT_0`.
         * 
         * @return builder
         * 
         */
        public Builder headroom(String headroom) {
            return headroom(Output.of(headroom));
        }

        /**
         * @param threshold The threshold value used for the specified metric parameter. You can only specify the threshold value for CPU utilization. Valid values: `P90`, `P95`, `P99_5`.
         * 
         * @return builder
         * 
         */
        public Builder threshold(@Nullable Output<String> threshold) {
            $.threshold = threshold;
            return this;
        }

        /**
         * @param threshold The threshold value used for the specified metric parameter. You can only specify the threshold value for CPU utilization. Valid values: `P90`, `P95`, `P99_5`.
         * 
         * @return builder
         * 
         */
        public Builder threshold(String threshold) {
            return threshold(Output.of(threshold));
        }

        public RecommendationPreferencesUtilizationPreferenceMetricParametersArgs build() {
            if ($.headroom == null) {
                throw new MissingRequiredPropertyException("RecommendationPreferencesUtilizationPreferenceMetricParametersArgs", "headroom");
            }
            return $;
        }
    }

}
