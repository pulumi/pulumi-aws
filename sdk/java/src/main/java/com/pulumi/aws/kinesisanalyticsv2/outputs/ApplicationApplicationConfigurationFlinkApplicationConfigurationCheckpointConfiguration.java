// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.kinesisanalyticsv2.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ApplicationApplicationConfigurationFlinkApplicationConfigurationCheckpointConfiguration {
    /**
     * @return Describes the interval in milliseconds between checkpoint operations.
     * 
     */
    private @Nullable Integer checkpointInterval;
    /**
     * @return Describes whether checkpointing is enabled for a Flink-based Kinesis Data Analytics application.
     * 
     */
    private @Nullable Boolean checkpointingEnabled;
    /**
     * @return Describes whether the application uses Kinesis Data Analytics&#39; default checkpointing behavior. Valid values: `CUSTOM`, `DEFAULT`. Set this attribute to `CUSTOM` in order for any specified `checkpointing_enabled`, `checkpoint_interval`, or `min_pause_between_checkpoints` attribute values to be effective. If this attribute is set to `DEFAULT`, the application will always use the following values:
     * * `checkpointing_enabled = true`
     * * `checkpoint_interval = 60000`
     * * `min_pause_between_checkpoints = 5000`
     * 
     */
    private String configurationType;
    /**
     * @return Describes the minimum time in milliseconds after a checkpoint operation completes that a new checkpoint operation can start.
     * 
     */
    private @Nullable Integer minPauseBetweenCheckpoints;

    private ApplicationApplicationConfigurationFlinkApplicationConfigurationCheckpointConfiguration() {}
    /**
     * @return Describes the interval in milliseconds between checkpoint operations.
     * 
     */
    public Optional<Integer> checkpointInterval() {
        return Optional.ofNullable(this.checkpointInterval);
    }
    /**
     * @return Describes whether checkpointing is enabled for a Flink-based Kinesis Data Analytics application.
     * 
     */
    public Optional<Boolean> checkpointingEnabled() {
        return Optional.ofNullable(this.checkpointingEnabled);
    }
    /**
     * @return Describes whether the application uses Kinesis Data Analytics&#39; default checkpointing behavior. Valid values: `CUSTOM`, `DEFAULT`. Set this attribute to `CUSTOM` in order for any specified `checkpointing_enabled`, `checkpoint_interval`, or `min_pause_between_checkpoints` attribute values to be effective. If this attribute is set to `DEFAULT`, the application will always use the following values:
     * * `checkpointing_enabled = true`
     * * `checkpoint_interval = 60000`
     * * `min_pause_between_checkpoints = 5000`
     * 
     */
    public String configurationType() {
        return this.configurationType;
    }
    /**
     * @return Describes the minimum time in milliseconds after a checkpoint operation completes that a new checkpoint operation can start.
     * 
     */
    public Optional<Integer> minPauseBetweenCheckpoints() {
        return Optional.ofNullable(this.minPauseBetweenCheckpoints);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ApplicationApplicationConfigurationFlinkApplicationConfigurationCheckpointConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Integer checkpointInterval;
        private @Nullable Boolean checkpointingEnabled;
        private String configurationType;
        private @Nullable Integer minPauseBetweenCheckpoints;
        public Builder() {}
        public Builder(ApplicationApplicationConfigurationFlinkApplicationConfigurationCheckpointConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.checkpointInterval = defaults.checkpointInterval;
    	      this.checkpointingEnabled = defaults.checkpointingEnabled;
    	      this.configurationType = defaults.configurationType;
    	      this.minPauseBetweenCheckpoints = defaults.minPauseBetweenCheckpoints;
        }

        @CustomType.Setter
        public Builder checkpointInterval(@Nullable Integer checkpointInterval) {

            this.checkpointInterval = checkpointInterval;
            return this;
        }
        @CustomType.Setter
        public Builder checkpointingEnabled(@Nullable Boolean checkpointingEnabled) {

            this.checkpointingEnabled = checkpointingEnabled;
            return this;
        }
        @CustomType.Setter
        public Builder configurationType(String configurationType) {
            if (configurationType == null) {
              throw new MissingRequiredPropertyException("ApplicationApplicationConfigurationFlinkApplicationConfigurationCheckpointConfiguration", "configurationType");
            }
            this.configurationType = configurationType;
            return this;
        }
        @CustomType.Setter
        public Builder minPauseBetweenCheckpoints(@Nullable Integer minPauseBetweenCheckpoints) {

            this.minPauseBetweenCheckpoints = minPauseBetweenCheckpoints;
            return this;
        }
        public ApplicationApplicationConfigurationFlinkApplicationConfigurationCheckpointConfiguration build() {
            final var _resultValue = new ApplicationApplicationConfigurationFlinkApplicationConfigurationCheckpointConfiguration();
            _resultValue.checkpointInterval = checkpointInterval;
            _resultValue.checkpointingEnabled = checkpointingEnabled;
            _resultValue.configurationType = configurationType;
            _resultValue.minPauseBetweenCheckpoints = minPauseBetweenCheckpoints;
            return _resultValue;
        }
    }
}
