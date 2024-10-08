// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.rekognition.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Double;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class StreamProcessorSettingsFaceSearch {
    /**
     * @return ID of a collection that contains faces that you want to search for.
     * 
     */
    private String collectionId;
    /**
     * @return Minimum face match confidence score that must be met to return a result for a recognized face.
     * 
     */
    private @Nullable Double faceMatchThreshold;

    private StreamProcessorSettingsFaceSearch() {}
    /**
     * @return ID of a collection that contains faces that you want to search for.
     * 
     */
    public String collectionId() {
        return this.collectionId;
    }
    /**
     * @return Minimum face match confidence score that must be met to return a result for a recognized face.
     * 
     */
    public Optional<Double> faceMatchThreshold() {
        return Optional.ofNullable(this.faceMatchThreshold);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(StreamProcessorSettingsFaceSearch defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String collectionId;
        private @Nullable Double faceMatchThreshold;
        public Builder() {}
        public Builder(StreamProcessorSettingsFaceSearch defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.collectionId = defaults.collectionId;
    	      this.faceMatchThreshold = defaults.faceMatchThreshold;
        }

        @CustomType.Setter
        public Builder collectionId(String collectionId) {
            if (collectionId == null) {
              throw new MissingRequiredPropertyException("StreamProcessorSettingsFaceSearch", "collectionId");
            }
            this.collectionId = collectionId;
            return this;
        }
        @CustomType.Setter
        public Builder faceMatchThreshold(@Nullable Double faceMatchThreshold) {

            this.faceMatchThreshold = faceMatchThreshold;
            return this;
        }
        public StreamProcessorSettingsFaceSearch build() {
            final var _resultValue = new StreamProcessorSettingsFaceSearch();
            _resultValue.collectionId = collectionId;
            _resultValue.faceMatchThreshold = faceMatchThreshold;
            return _resultValue;
        }
    }
}
