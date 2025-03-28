// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.rds.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ClusterScalingConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final ClusterScalingConfigurationArgs Empty = new ClusterScalingConfigurationArgs();

    /**
     * Whether to enable automatic pause. A DB cluster can be paused only when it&#39;s idle (it has no connections). If a DB cluster is paused for more than seven days, the DB cluster might be backed up with a snapshot. In this case, the DB cluster is restored when there is a request to connect to it. Defaults to `true`.
     * 
     */
    @Import(name="autoPause")
    private @Nullable Output<Boolean> autoPause;

    /**
     * @return Whether to enable automatic pause. A DB cluster can be paused only when it&#39;s idle (it has no connections). If a DB cluster is paused for more than seven days, the DB cluster might be backed up with a snapshot. In this case, the DB cluster is restored when there is a request to connect to it. Defaults to `true`.
     * 
     */
    public Optional<Output<Boolean>> autoPause() {
        return Optional.ofNullable(this.autoPause);
    }

    /**
     * Maximum capacity for an Aurora DB cluster in `serverless` DB engine mode. The maximum capacity must be greater than or equal to the minimum capacity. Valid Aurora MySQL capacity values are `1`, `2`, `4`, `8`, `16`, `32`, `64`, `128`, `256`. Valid Aurora PostgreSQL capacity values are (`2`, `4`, `8`, `16`, `32`, `64`, `192`, and `384`). Defaults to `16`.
     * 
     */
    @Import(name="maxCapacity")
    private @Nullable Output<Integer> maxCapacity;

    /**
     * @return Maximum capacity for an Aurora DB cluster in `serverless` DB engine mode. The maximum capacity must be greater than or equal to the minimum capacity. Valid Aurora MySQL capacity values are `1`, `2`, `4`, `8`, `16`, `32`, `64`, `128`, `256`. Valid Aurora PostgreSQL capacity values are (`2`, `4`, `8`, `16`, `32`, `64`, `192`, and `384`). Defaults to `16`.
     * 
     */
    public Optional<Output<Integer>> maxCapacity() {
        return Optional.ofNullable(this.maxCapacity);
    }

    /**
     * Minimum capacity for an Aurora DB cluster in `serverless` DB engine mode. The minimum capacity must be lesser than or equal to the maximum capacity. Valid Aurora MySQL capacity values are `1`, `2`, `4`, `8`, `16`, `32`, `64`, `128`, `256`. Valid Aurora PostgreSQL capacity values are (`2`, `4`, `8`, `16`, `32`, `64`, `192`, and `384`). Defaults to `1`.
     * 
     */
    @Import(name="minCapacity")
    private @Nullable Output<Integer> minCapacity;

    /**
     * @return Minimum capacity for an Aurora DB cluster in `serverless` DB engine mode. The minimum capacity must be lesser than or equal to the maximum capacity. Valid Aurora MySQL capacity values are `1`, `2`, `4`, `8`, `16`, `32`, `64`, `128`, `256`. Valid Aurora PostgreSQL capacity values are (`2`, `4`, `8`, `16`, `32`, `64`, `192`, and `384`). Defaults to `1`.
     * 
     */
    public Optional<Output<Integer>> minCapacity() {
        return Optional.ofNullable(this.minCapacity);
    }

    /**
     * Amount of time, in seconds, that Aurora Serverless v1 tries to find a scaling point to perform seamless scaling before enforcing the timeout action. Valid values are `60` through `600`. Defaults to `300`.
     * 
     */
    @Import(name="secondsBeforeTimeout")
    private @Nullable Output<Integer> secondsBeforeTimeout;

    /**
     * @return Amount of time, in seconds, that Aurora Serverless v1 tries to find a scaling point to perform seamless scaling before enforcing the timeout action. Valid values are `60` through `600`. Defaults to `300`.
     * 
     */
    public Optional<Output<Integer>> secondsBeforeTimeout() {
        return Optional.ofNullable(this.secondsBeforeTimeout);
    }

    /**
     * Time, in seconds, before an Aurora DB cluster in serverless mode is paused. Valid values are `300` through `86400`. Defaults to `300`.
     * 
     */
    @Import(name="secondsUntilAutoPause")
    private @Nullable Output<Integer> secondsUntilAutoPause;

    /**
     * @return Time, in seconds, before an Aurora DB cluster in serverless mode is paused. Valid values are `300` through `86400`. Defaults to `300`.
     * 
     */
    public Optional<Output<Integer>> secondsUntilAutoPause() {
        return Optional.ofNullable(this.secondsUntilAutoPause);
    }

    /**
     * Action to take when the timeout is reached. Valid values: `ForceApplyCapacityChange`, `RollbackCapacityChange`. Defaults to `RollbackCapacityChange`. See [documentation](https://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/aurora-serverless-v1.how-it-works.html#aurora-serverless.how-it-works.timeout-action).
     * 
     */
    @Import(name="timeoutAction")
    private @Nullable Output<String> timeoutAction;

    /**
     * @return Action to take when the timeout is reached. Valid values: `ForceApplyCapacityChange`, `RollbackCapacityChange`. Defaults to `RollbackCapacityChange`. See [documentation](https://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/aurora-serverless-v1.how-it-works.html#aurora-serverless.how-it-works.timeout-action).
     * 
     */
    public Optional<Output<String>> timeoutAction() {
        return Optional.ofNullable(this.timeoutAction);
    }

    private ClusterScalingConfigurationArgs() {}

    private ClusterScalingConfigurationArgs(ClusterScalingConfigurationArgs $) {
        this.autoPause = $.autoPause;
        this.maxCapacity = $.maxCapacity;
        this.minCapacity = $.minCapacity;
        this.secondsBeforeTimeout = $.secondsBeforeTimeout;
        this.secondsUntilAutoPause = $.secondsUntilAutoPause;
        this.timeoutAction = $.timeoutAction;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ClusterScalingConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ClusterScalingConfigurationArgs $;

        public Builder() {
            $ = new ClusterScalingConfigurationArgs();
        }

        public Builder(ClusterScalingConfigurationArgs defaults) {
            $ = new ClusterScalingConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param autoPause Whether to enable automatic pause. A DB cluster can be paused only when it&#39;s idle (it has no connections). If a DB cluster is paused for more than seven days, the DB cluster might be backed up with a snapshot. In this case, the DB cluster is restored when there is a request to connect to it. Defaults to `true`.
         * 
         * @return builder
         * 
         */
        public Builder autoPause(@Nullable Output<Boolean> autoPause) {
            $.autoPause = autoPause;
            return this;
        }

        /**
         * @param autoPause Whether to enable automatic pause. A DB cluster can be paused only when it&#39;s idle (it has no connections). If a DB cluster is paused for more than seven days, the DB cluster might be backed up with a snapshot. In this case, the DB cluster is restored when there is a request to connect to it. Defaults to `true`.
         * 
         * @return builder
         * 
         */
        public Builder autoPause(Boolean autoPause) {
            return autoPause(Output.of(autoPause));
        }

        /**
         * @param maxCapacity Maximum capacity for an Aurora DB cluster in `serverless` DB engine mode. The maximum capacity must be greater than or equal to the minimum capacity. Valid Aurora MySQL capacity values are `1`, `2`, `4`, `8`, `16`, `32`, `64`, `128`, `256`. Valid Aurora PostgreSQL capacity values are (`2`, `4`, `8`, `16`, `32`, `64`, `192`, and `384`). Defaults to `16`.
         * 
         * @return builder
         * 
         */
        public Builder maxCapacity(@Nullable Output<Integer> maxCapacity) {
            $.maxCapacity = maxCapacity;
            return this;
        }

        /**
         * @param maxCapacity Maximum capacity for an Aurora DB cluster in `serverless` DB engine mode. The maximum capacity must be greater than or equal to the minimum capacity. Valid Aurora MySQL capacity values are `1`, `2`, `4`, `8`, `16`, `32`, `64`, `128`, `256`. Valid Aurora PostgreSQL capacity values are (`2`, `4`, `8`, `16`, `32`, `64`, `192`, and `384`). Defaults to `16`.
         * 
         * @return builder
         * 
         */
        public Builder maxCapacity(Integer maxCapacity) {
            return maxCapacity(Output.of(maxCapacity));
        }

        /**
         * @param minCapacity Minimum capacity for an Aurora DB cluster in `serverless` DB engine mode. The minimum capacity must be lesser than or equal to the maximum capacity. Valid Aurora MySQL capacity values are `1`, `2`, `4`, `8`, `16`, `32`, `64`, `128`, `256`. Valid Aurora PostgreSQL capacity values are (`2`, `4`, `8`, `16`, `32`, `64`, `192`, and `384`). Defaults to `1`.
         * 
         * @return builder
         * 
         */
        public Builder minCapacity(@Nullable Output<Integer> minCapacity) {
            $.minCapacity = minCapacity;
            return this;
        }

        /**
         * @param minCapacity Minimum capacity for an Aurora DB cluster in `serverless` DB engine mode. The minimum capacity must be lesser than or equal to the maximum capacity. Valid Aurora MySQL capacity values are `1`, `2`, `4`, `8`, `16`, `32`, `64`, `128`, `256`. Valid Aurora PostgreSQL capacity values are (`2`, `4`, `8`, `16`, `32`, `64`, `192`, and `384`). Defaults to `1`.
         * 
         * @return builder
         * 
         */
        public Builder minCapacity(Integer minCapacity) {
            return minCapacity(Output.of(minCapacity));
        }

        /**
         * @param secondsBeforeTimeout Amount of time, in seconds, that Aurora Serverless v1 tries to find a scaling point to perform seamless scaling before enforcing the timeout action. Valid values are `60` through `600`. Defaults to `300`.
         * 
         * @return builder
         * 
         */
        public Builder secondsBeforeTimeout(@Nullable Output<Integer> secondsBeforeTimeout) {
            $.secondsBeforeTimeout = secondsBeforeTimeout;
            return this;
        }

        /**
         * @param secondsBeforeTimeout Amount of time, in seconds, that Aurora Serverless v1 tries to find a scaling point to perform seamless scaling before enforcing the timeout action. Valid values are `60` through `600`. Defaults to `300`.
         * 
         * @return builder
         * 
         */
        public Builder secondsBeforeTimeout(Integer secondsBeforeTimeout) {
            return secondsBeforeTimeout(Output.of(secondsBeforeTimeout));
        }

        /**
         * @param secondsUntilAutoPause Time, in seconds, before an Aurora DB cluster in serverless mode is paused. Valid values are `300` through `86400`. Defaults to `300`.
         * 
         * @return builder
         * 
         */
        public Builder secondsUntilAutoPause(@Nullable Output<Integer> secondsUntilAutoPause) {
            $.secondsUntilAutoPause = secondsUntilAutoPause;
            return this;
        }

        /**
         * @param secondsUntilAutoPause Time, in seconds, before an Aurora DB cluster in serverless mode is paused. Valid values are `300` through `86400`. Defaults to `300`.
         * 
         * @return builder
         * 
         */
        public Builder secondsUntilAutoPause(Integer secondsUntilAutoPause) {
            return secondsUntilAutoPause(Output.of(secondsUntilAutoPause));
        }

        /**
         * @param timeoutAction Action to take when the timeout is reached. Valid values: `ForceApplyCapacityChange`, `RollbackCapacityChange`. Defaults to `RollbackCapacityChange`. See [documentation](https://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/aurora-serverless-v1.how-it-works.html#aurora-serverless.how-it-works.timeout-action).
         * 
         * @return builder
         * 
         */
        public Builder timeoutAction(@Nullable Output<String> timeoutAction) {
            $.timeoutAction = timeoutAction;
            return this;
        }

        /**
         * @param timeoutAction Action to take when the timeout is reached. Valid values: `ForceApplyCapacityChange`, `RollbackCapacityChange`. Defaults to `RollbackCapacityChange`. See [documentation](https://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/aurora-serverless-v1.how-it-works.html#aurora-serverless.how-it-works.timeout-action).
         * 
         * @return builder
         * 
         */
        public Builder timeoutAction(String timeoutAction) {
            return timeoutAction(Output.of(timeoutAction));
        }

        public ClusterScalingConfigurationArgs build() {
            return $;
        }
    }

}
