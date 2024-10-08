// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.rekognition.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Double;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class StreamProcessorSettingsConnectedHomeArgs extends com.pulumi.resources.ResourceArgs {

    public static final StreamProcessorSettingsConnectedHomeArgs Empty = new StreamProcessorSettingsConnectedHomeArgs();

    /**
     * Specifies what you want to detect in the video, such as people, packages, or pets. The current valid labels you can include in this list are: `PERSON`, `PET`, `PACKAGE`, and `ALL`.
     * 
     */
    @Import(name="labels")
    private @Nullable Output<List<String>> labels;

    /**
     * @return Specifies what you want to detect in the video, such as people, packages, or pets. The current valid labels you can include in this list are: `PERSON`, `PET`, `PACKAGE`, and `ALL`.
     * 
     */
    public Optional<Output<List<String>>> labels() {
        return Optional.ofNullable(this.labels);
    }

    /**
     * Minimum confidence required to label an object in the video.
     * 
     */
    @Import(name="minConfidence")
    private @Nullable Output<Double> minConfidence;

    /**
     * @return Minimum confidence required to label an object in the video.
     * 
     */
    public Optional<Output<Double>> minConfidence() {
        return Optional.ofNullable(this.minConfidence);
    }

    private StreamProcessorSettingsConnectedHomeArgs() {}

    private StreamProcessorSettingsConnectedHomeArgs(StreamProcessorSettingsConnectedHomeArgs $) {
        this.labels = $.labels;
        this.minConfidence = $.minConfidence;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(StreamProcessorSettingsConnectedHomeArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private StreamProcessorSettingsConnectedHomeArgs $;

        public Builder() {
            $ = new StreamProcessorSettingsConnectedHomeArgs();
        }

        public Builder(StreamProcessorSettingsConnectedHomeArgs defaults) {
            $ = new StreamProcessorSettingsConnectedHomeArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param labels Specifies what you want to detect in the video, such as people, packages, or pets. The current valid labels you can include in this list are: `PERSON`, `PET`, `PACKAGE`, and `ALL`.
         * 
         * @return builder
         * 
         */
        public Builder labels(@Nullable Output<List<String>> labels) {
            $.labels = labels;
            return this;
        }

        /**
         * @param labels Specifies what you want to detect in the video, such as people, packages, or pets. The current valid labels you can include in this list are: `PERSON`, `PET`, `PACKAGE`, and `ALL`.
         * 
         * @return builder
         * 
         */
        public Builder labels(List<String> labels) {
            return labels(Output.of(labels));
        }

        /**
         * @param labels Specifies what you want to detect in the video, such as people, packages, or pets. The current valid labels you can include in this list are: `PERSON`, `PET`, `PACKAGE`, and `ALL`.
         * 
         * @return builder
         * 
         */
        public Builder labels(String... labels) {
            return labels(List.of(labels));
        }

        /**
         * @param minConfidence Minimum confidence required to label an object in the video.
         * 
         * @return builder
         * 
         */
        public Builder minConfidence(@Nullable Output<Double> minConfidence) {
            $.minConfidence = minConfidence;
            return this;
        }

        /**
         * @param minConfidence Minimum confidence required to label an object in the video.
         * 
         * @return builder
         * 
         */
        public Builder minConfidence(Double minConfidence) {
            return minConfidence(Output.of(minConfidence));
        }

        public StreamProcessorSettingsConnectedHomeArgs build() {
            return $;
        }
    }

}
