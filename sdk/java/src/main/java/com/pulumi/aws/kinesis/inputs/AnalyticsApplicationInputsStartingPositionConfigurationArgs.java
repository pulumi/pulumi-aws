// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.kinesis.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class AnalyticsApplicationInputsStartingPositionConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final AnalyticsApplicationInputsStartingPositionConfigurationArgs Empty = new AnalyticsApplicationInputsStartingPositionConfigurationArgs();

    /**
     * The starting position on the stream. Valid values: `LAST_STOPPED_POINT`, `NOW`, `TRIM_HORIZON`.
     * 
     */
    @Import(name="startingPosition")
    private @Nullable Output<String> startingPosition;

    /**
     * @return The starting position on the stream. Valid values: `LAST_STOPPED_POINT`, `NOW`, `TRIM_HORIZON`.
     * 
     */
    public Optional<Output<String>> startingPosition() {
        return Optional.ofNullable(this.startingPosition);
    }

    private AnalyticsApplicationInputsStartingPositionConfigurationArgs() {}

    private AnalyticsApplicationInputsStartingPositionConfigurationArgs(AnalyticsApplicationInputsStartingPositionConfigurationArgs $) {
        this.startingPosition = $.startingPosition;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AnalyticsApplicationInputsStartingPositionConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AnalyticsApplicationInputsStartingPositionConfigurationArgs $;

        public Builder() {
            $ = new AnalyticsApplicationInputsStartingPositionConfigurationArgs();
        }

        public Builder(AnalyticsApplicationInputsStartingPositionConfigurationArgs defaults) {
            $ = new AnalyticsApplicationInputsStartingPositionConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param startingPosition The starting position on the stream. Valid values: `LAST_STOPPED_POINT`, `NOW`, `TRIM_HORIZON`.
         * 
         * @return builder
         * 
         */
        public Builder startingPosition(@Nullable Output<String> startingPosition) {
            $.startingPosition = startingPosition;
            return this;
        }

        /**
         * @param startingPosition The starting position on the stream. Valid values: `LAST_STOPPED_POINT`, `NOW`, `TRIM_HORIZON`.
         * 
         * @return builder
         * 
         */
        public Builder startingPosition(String startingPosition) {
            return startingPosition(Output.of(startingPosition));
        }

        public AnalyticsApplicationInputsStartingPositionConfigurationArgs build() {
            return $;
        }
    }

}
