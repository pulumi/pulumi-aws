// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.opsworks.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class CustomLayerLoadBasedAutoScalingDownscalingArgs extends com.pulumi.resources.ResourceArgs {

    public static final CustomLayerLoadBasedAutoScalingDownscalingArgs Empty = new CustomLayerLoadBasedAutoScalingDownscalingArgs();

    /**
     * Custom Cloudwatch auto scaling alarms, to be used as thresholds. This parameter takes a list of up to five alarm names, which are case sensitive and must be in the same region as the stack.
     * 
     */
    @Import(name="alarms")
    private @Nullable Output<List<String>> alarms;

    /**
     * @return Custom Cloudwatch auto scaling alarms, to be used as thresholds. This parameter takes a list of up to five alarm names, which are case sensitive and must be in the same region as the stack.
     * 
     */
    public Optional<Output<List<String>>> alarms() {
        return Optional.ofNullable(this.alarms);
    }

    /**
     * The CPU utilization threshold, as a percent of the available CPU. A value of -1 disables the threshold.
     * 
     */
    @Import(name="cpuThreshold")
    private @Nullable Output<Double> cpuThreshold;

    /**
     * @return The CPU utilization threshold, as a percent of the available CPU. A value of -1 disables the threshold.
     * 
     */
    public Optional<Output<Double>> cpuThreshold() {
        return Optional.ofNullable(this.cpuThreshold);
    }

    /**
     * The amount of time (in minutes) after a scaling event occurs that AWS OpsWorks Stacks should ignore metrics and suppress additional scaling events.
     * 
     */
    @Import(name="ignoreMetricsTime")
    private @Nullable Output<Integer> ignoreMetricsTime;

    /**
     * @return The amount of time (in minutes) after a scaling event occurs that AWS OpsWorks Stacks should ignore metrics and suppress additional scaling events.
     * 
     */
    public Optional<Output<Integer>> ignoreMetricsTime() {
        return Optional.ofNullable(this.ignoreMetricsTime);
    }

    /**
     * The number of instances to add or remove when the load exceeds a threshold.
     * 
     */
    @Import(name="instanceCount")
    private @Nullable Output<Integer> instanceCount;

    /**
     * @return The number of instances to add or remove when the load exceeds a threshold.
     * 
     */
    public Optional<Output<Integer>> instanceCount() {
        return Optional.ofNullable(this.instanceCount);
    }

    /**
     * The load threshold. A value of -1 disables the threshold.
     * 
     */
    @Import(name="loadThreshold")
    private @Nullable Output<Double> loadThreshold;

    /**
     * @return The load threshold. A value of -1 disables the threshold.
     * 
     */
    public Optional<Output<Double>> loadThreshold() {
        return Optional.ofNullable(this.loadThreshold);
    }

    /**
     * The memory utilization threshold, as a percent of the available memory. A value of -1 disables the threshold.
     * 
     */
    @Import(name="memoryThreshold")
    private @Nullable Output<Double> memoryThreshold;

    /**
     * @return The memory utilization threshold, as a percent of the available memory. A value of -1 disables the threshold.
     * 
     */
    public Optional<Output<Double>> memoryThreshold() {
        return Optional.ofNullable(this.memoryThreshold);
    }

    /**
     * The amount of time, in minutes, that the load must exceed a threshold before more instances are added or removed.
     * 
     */
    @Import(name="thresholdsWaitTime")
    private @Nullable Output<Integer> thresholdsWaitTime;

    /**
     * @return The amount of time, in minutes, that the load must exceed a threshold before more instances are added or removed.
     * 
     */
    public Optional<Output<Integer>> thresholdsWaitTime() {
        return Optional.ofNullable(this.thresholdsWaitTime);
    }

    private CustomLayerLoadBasedAutoScalingDownscalingArgs() {}

    private CustomLayerLoadBasedAutoScalingDownscalingArgs(CustomLayerLoadBasedAutoScalingDownscalingArgs $) {
        this.alarms = $.alarms;
        this.cpuThreshold = $.cpuThreshold;
        this.ignoreMetricsTime = $.ignoreMetricsTime;
        this.instanceCount = $.instanceCount;
        this.loadThreshold = $.loadThreshold;
        this.memoryThreshold = $.memoryThreshold;
        this.thresholdsWaitTime = $.thresholdsWaitTime;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(CustomLayerLoadBasedAutoScalingDownscalingArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private CustomLayerLoadBasedAutoScalingDownscalingArgs $;

        public Builder() {
            $ = new CustomLayerLoadBasedAutoScalingDownscalingArgs();
        }

        public Builder(CustomLayerLoadBasedAutoScalingDownscalingArgs defaults) {
            $ = new CustomLayerLoadBasedAutoScalingDownscalingArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param alarms Custom Cloudwatch auto scaling alarms, to be used as thresholds. This parameter takes a list of up to five alarm names, which are case sensitive and must be in the same region as the stack.
         * 
         * @return builder
         * 
         */
        public Builder alarms(@Nullable Output<List<String>> alarms) {
            $.alarms = alarms;
            return this;
        }

        /**
         * @param alarms Custom Cloudwatch auto scaling alarms, to be used as thresholds. This parameter takes a list of up to five alarm names, which are case sensitive and must be in the same region as the stack.
         * 
         * @return builder
         * 
         */
        public Builder alarms(List<String> alarms) {
            return alarms(Output.of(alarms));
        }

        /**
         * @param alarms Custom Cloudwatch auto scaling alarms, to be used as thresholds. This parameter takes a list of up to five alarm names, which are case sensitive and must be in the same region as the stack.
         * 
         * @return builder
         * 
         */
        public Builder alarms(String... alarms) {
            return alarms(List.of(alarms));
        }

        /**
         * @param cpuThreshold The CPU utilization threshold, as a percent of the available CPU. A value of -1 disables the threshold.
         * 
         * @return builder
         * 
         */
        public Builder cpuThreshold(@Nullable Output<Double> cpuThreshold) {
            $.cpuThreshold = cpuThreshold;
            return this;
        }

        /**
         * @param cpuThreshold The CPU utilization threshold, as a percent of the available CPU. A value of -1 disables the threshold.
         * 
         * @return builder
         * 
         */
        public Builder cpuThreshold(Double cpuThreshold) {
            return cpuThreshold(Output.of(cpuThreshold));
        }

        /**
         * @param ignoreMetricsTime The amount of time (in minutes) after a scaling event occurs that AWS OpsWorks Stacks should ignore metrics and suppress additional scaling events.
         * 
         * @return builder
         * 
         */
        public Builder ignoreMetricsTime(@Nullable Output<Integer> ignoreMetricsTime) {
            $.ignoreMetricsTime = ignoreMetricsTime;
            return this;
        }

        /**
         * @param ignoreMetricsTime The amount of time (in minutes) after a scaling event occurs that AWS OpsWorks Stacks should ignore metrics and suppress additional scaling events.
         * 
         * @return builder
         * 
         */
        public Builder ignoreMetricsTime(Integer ignoreMetricsTime) {
            return ignoreMetricsTime(Output.of(ignoreMetricsTime));
        }

        /**
         * @param instanceCount The number of instances to add or remove when the load exceeds a threshold.
         * 
         * @return builder
         * 
         */
        public Builder instanceCount(@Nullable Output<Integer> instanceCount) {
            $.instanceCount = instanceCount;
            return this;
        }

        /**
         * @param instanceCount The number of instances to add or remove when the load exceeds a threshold.
         * 
         * @return builder
         * 
         */
        public Builder instanceCount(Integer instanceCount) {
            return instanceCount(Output.of(instanceCount));
        }

        /**
         * @param loadThreshold The load threshold. A value of -1 disables the threshold.
         * 
         * @return builder
         * 
         */
        public Builder loadThreshold(@Nullable Output<Double> loadThreshold) {
            $.loadThreshold = loadThreshold;
            return this;
        }

        /**
         * @param loadThreshold The load threshold. A value of -1 disables the threshold.
         * 
         * @return builder
         * 
         */
        public Builder loadThreshold(Double loadThreshold) {
            return loadThreshold(Output.of(loadThreshold));
        }

        /**
         * @param memoryThreshold The memory utilization threshold, as a percent of the available memory. A value of -1 disables the threshold.
         * 
         * @return builder
         * 
         */
        public Builder memoryThreshold(@Nullable Output<Double> memoryThreshold) {
            $.memoryThreshold = memoryThreshold;
            return this;
        }

        /**
         * @param memoryThreshold The memory utilization threshold, as a percent of the available memory. A value of -1 disables the threshold.
         * 
         * @return builder
         * 
         */
        public Builder memoryThreshold(Double memoryThreshold) {
            return memoryThreshold(Output.of(memoryThreshold));
        }

        /**
         * @param thresholdsWaitTime The amount of time, in minutes, that the load must exceed a threshold before more instances are added or removed.
         * 
         * @return builder
         * 
         */
        public Builder thresholdsWaitTime(@Nullable Output<Integer> thresholdsWaitTime) {
            $.thresholdsWaitTime = thresholdsWaitTime;
            return this;
        }

        /**
         * @param thresholdsWaitTime The amount of time, in minutes, that the load must exceed a threshold before more instances are added or removed.
         * 
         * @return builder
         * 
         */
        public Builder thresholdsWaitTime(Integer thresholdsWaitTime) {
            return thresholdsWaitTime(Output.of(thresholdsWaitTime));
        }

        public CustomLayerLoadBasedAutoScalingDownscalingArgs build() {
            return $;
        }
    }

}
