// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dlm.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class LifecyclePolicyPolicyDetailsScheduleCreateRuleArgs extends com.pulumi.resources.ResourceArgs {

    public static final LifecyclePolicyPolicyDetailsScheduleCreateRuleArgs Empty = new LifecyclePolicyPolicyDetailsScheduleCreateRuleArgs();

    @Import(name="cronExpression")
    private @Nullable Output<String> cronExpression;

    public Optional<Output<String>> cronExpression() {
        return Optional.ofNullable(this.cronExpression);
    }

    @Import(name="interval")
    private @Nullable Output<Integer> interval;

    public Optional<Output<Integer>> interval() {
        return Optional.ofNullable(this.interval);
    }

    @Import(name="intervalUnit")
    private @Nullable Output<String> intervalUnit;

    public Optional<Output<String>> intervalUnit() {
        return Optional.ofNullable(this.intervalUnit);
    }

    @Import(name="location")
    private @Nullable Output<String> location;

    public Optional<Output<String>> location() {
        return Optional.ofNullable(this.location);
    }

    @Import(name="times")
    private @Nullable Output<String> times;

    public Optional<Output<String>> times() {
        return Optional.ofNullable(this.times);
    }

    private LifecyclePolicyPolicyDetailsScheduleCreateRuleArgs() {}

    private LifecyclePolicyPolicyDetailsScheduleCreateRuleArgs(LifecyclePolicyPolicyDetailsScheduleCreateRuleArgs $) {
        this.cronExpression = $.cronExpression;
        this.interval = $.interval;
        this.intervalUnit = $.intervalUnit;
        this.location = $.location;
        this.times = $.times;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(LifecyclePolicyPolicyDetailsScheduleCreateRuleArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private LifecyclePolicyPolicyDetailsScheduleCreateRuleArgs $;

        public Builder() {
            $ = new LifecyclePolicyPolicyDetailsScheduleCreateRuleArgs();
        }

        public Builder(LifecyclePolicyPolicyDetailsScheduleCreateRuleArgs defaults) {
            $ = new LifecyclePolicyPolicyDetailsScheduleCreateRuleArgs(Objects.requireNonNull(defaults));
        }

        public Builder cronExpression(@Nullable Output<String> cronExpression) {
            $.cronExpression = cronExpression;
            return this;
        }

        public Builder cronExpression(String cronExpression) {
            return cronExpression(Output.of(cronExpression));
        }

        public Builder interval(@Nullable Output<Integer> interval) {
            $.interval = interval;
            return this;
        }

        public Builder interval(Integer interval) {
            return interval(Output.of(interval));
        }

        public Builder intervalUnit(@Nullable Output<String> intervalUnit) {
            $.intervalUnit = intervalUnit;
            return this;
        }

        public Builder intervalUnit(String intervalUnit) {
            return intervalUnit(Output.of(intervalUnit));
        }

        public Builder location(@Nullable Output<String> location) {
            $.location = location;
            return this;
        }

        public Builder location(String location) {
            return location(Output.of(location));
        }

        public Builder times(@Nullable Output<String> times) {
            $.times = times;
            return this;
        }

        public Builder times(String times) {
            return times(Output.of(times));
        }

        public LifecyclePolicyPolicyDetailsScheduleCreateRuleArgs build() {
            return $;
        }
    }

}
