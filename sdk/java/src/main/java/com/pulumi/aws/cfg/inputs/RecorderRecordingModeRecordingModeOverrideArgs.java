// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cfg.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class RecorderRecordingModeRecordingModeOverrideArgs extends com.pulumi.resources.ResourceArgs {

    public static final RecorderRecordingModeRecordingModeOverrideArgs Empty = new RecorderRecordingModeRecordingModeOverrideArgs();

    /**
     * A description you provide of the override.
     * 
     */
    @Import(name="description")
    private @Nullable Output<String> description;

    /**
     * @return A description you provide of the override.
     * 
     */
    public Optional<Output<String>> description() {
        return Optional.ofNullable(this.description);
    }

    /**
     * The recording frequency for the resources in the override block. `CONTINUOUS` or `DAILY`.
     * 
     */
    @Import(name="recordingFrequency", required=true)
    private Output<String> recordingFrequency;

    /**
     * @return The recording frequency for the resources in the override block. `CONTINUOUS` or `DAILY`.
     * 
     */
    public Output<String> recordingFrequency() {
        return this.recordingFrequency;
    }

    /**
     * A list that specifies the types of AWS resources for which the override applies to.  See [restrictions in the AWS Docs](https://docs.aws.amazon.com/config/latest/APIReference/API_RecordingModeOverride.html)
     * 
     */
    @Import(name="resourceTypes", required=true)
    private Output<List<String>> resourceTypes;

    /**
     * @return A list that specifies the types of AWS resources for which the override applies to.  See [restrictions in the AWS Docs](https://docs.aws.amazon.com/config/latest/APIReference/API_RecordingModeOverride.html)
     * 
     */
    public Output<List<String>> resourceTypes() {
        return this.resourceTypes;
    }

    private RecorderRecordingModeRecordingModeOverrideArgs() {}

    private RecorderRecordingModeRecordingModeOverrideArgs(RecorderRecordingModeRecordingModeOverrideArgs $) {
        this.description = $.description;
        this.recordingFrequency = $.recordingFrequency;
        this.resourceTypes = $.resourceTypes;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RecorderRecordingModeRecordingModeOverrideArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RecorderRecordingModeRecordingModeOverrideArgs $;

        public Builder() {
            $ = new RecorderRecordingModeRecordingModeOverrideArgs();
        }

        public Builder(RecorderRecordingModeRecordingModeOverrideArgs defaults) {
            $ = new RecorderRecordingModeRecordingModeOverrideArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param description A description you provide of the override.
         * 
         * @return builder
         * 
         */
        public Builder description(@Nullable Output<String> description) {
            $.description = description;
            return this;
        }

        /**
         * @param description A description you provide of the override.
         * 
         * @return builder
         * 
         */
        public Builder description(String description) {
            return description(Output.of(description));
        }

        /**
         * @param recordingFrequency The recording frequency for the resources in the override block. `CONTINUOUS` or `DAILY`.
         * 
         * @return builder
         * 
         */
        public Builder recordingFrequency(Output<String> recordingFrequency) {
            $.recordingFrequency = recordingFrequency;
            return this;
        }

        /**
         * @param recordingFrequency The recording frequency for the resources in the override block. `CONTINUOUS` or `DAILY`.
         * 
         * @return builder
         * 
         */
        public Builder recordingFrequency(String recordingFrequency) {
            return recordingFrequency(Output.of(recordingFrequency));
        }

        /**
         * @param resourceTypes A list that specifies the types of AWS resources for which the override applies to.  See [restrictions in the AWS Docs](https://docs.aws.amazon.com/config/latest/APIReference/API_RecordingModeOverride.html)
         * 
         * @return builder
         * 
         */
        public Builder resourceTypes(Output<List<String>> resourceTypes) {
            $.resourceTypes = resourceTypes;
            return this;
        }

        /**
         * @param resourceTypes A list that specifies the types of AWS resources for which the override applies to.  See [restrictions in the AWS Docs](https://docs.aws.amazon.com/config/latest/APIReference/API_RecordingModeOverride.html)
         * 
         * @return builder
         * 
         */
        public Builder resourceTypes(List<String> resourceTypes) {
            return resourceTypes(Output.of(resourceTypes));
        }

        /**
         * @param resourceTypes A list that specifies the types of AWS resources for which the override applies to.  See [restrictions in the AWS Docs](https://docs.aws.amazon.com/config/latest/APIReference/API_RecordingModeOverride.html)
         * 
         * @return builder
         * 
         */
        public Builder resourceTypes(String... resourceTypes) {
            return resourceTypes(List.of(resourceTypes));
        }

        public RecorderRecordingModeRecordingModeOverrideArgs build() {
            if ($.recordingFrequency == null) {
                throw new MissingRequiredPropertyException("RecorderRecordingModeRecordingModeOverrideArgs", "recordingFrequency");
            }
            if ($.resourceTypes == null) {
                throw new MissingRequiredPropertyException("RecorderRecordingModeRecordingModeOverrideArgs", "resourceTypes");
            }
            return $;
        }
    }

}
