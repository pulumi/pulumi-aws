// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.codepipeline.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class PipelineArtifactStoreEncryptionKey {
    /**
     * @return The KMS key ARN or ID
     * 
     */
    private String id;
    /**
     * @return The type of key; currently only `KMS` is supported
     * 
     */
    private String type;

    private PipelineArtifactStoreEncryptionKey() {}
    /**
     * @return The KMS key ARN or ID
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return The type of key; currently only `KMS` is supported
     * 
     */
    public String type() {
        return this.type;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(PipelineArtifactStoreEncryptionKey defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String id;
        private String type;
        public Builder() {}
        public Builder(PipelineArtifactStoreEncryptionKey defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.id = defaults.id;
    	      this.type = defaults.type;
        }

        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("PipelineArtifactStoreEncryptionKey", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder type(String type) {
            if (type == null) {
              throw new MissingRequiredPropertyException("PipelineArtifactStoreEncryptionKey", "type");
            }
            this.type = type;
            return this;
        }
        public PipelineArtifactStoreEncryptionKey build() {
            final var _resultValue = new PipelineArtifactStoreEncryptionKey();
            _resultValue.id = id;
            _resultValue.type = type;
            return _resultValue;
        }
    }
}
