// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.transfer.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class WorkflowOnExceptionStepCopyStepDetailsDestinationFileLocationS3FileLocation {
    /**
     * @return Specifies the S3 bucket for the customer input file.
     * 
     */
    private @Nullable String bucket;
    /**
     * @return The name assigned to the file when it was created in S3. You use the object key to retrieve the object.
     * 
     */
    private @Nullable String key;

    private WorkflowOnExceptionStepCopyStepDetailsDestinationFileLocationS3FileLocation() {}
    /**
     * @return Specifies the S3 bucket for the customer input file.
     * 
     */
    public Optional<String> bucket() {
        return Optional.ofNullable(this.bucket);
    }
    /**
     * @return The name assigned to the file when it was created in S3. You use the object key to retrieve the object.
     * 
     */
    public Optional<String> key() {
        return Optional.ofNullable(this.key);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(WorkflowOnExceptionStepCopyStepDetailsDestinationFileLocationS3FileLocation defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String bucket;
        private @Nullable String key;
        public Builder() {}
        public Builder(WorkflowOnExceptionStepCopyStepDetailsDestinationFileLocationS3FileLocation defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.bucket = defaults.bucket;
    	      this.key = defaults.key;
        }

        @CustomType.Setter
        public Builder bucket(@Nullable String bucket) {

            this.bucket = bucket;
            return this;
        }
        @CustomType.Setter
        public Builder key(@Nullable String key) {

            this.key = key;
            return this;
        }
        public WorkflowOnExceptionStepCopyStepDetailsDestinationFileLocationS3FileLocation build() {
            final var _resultValue = new WorkflowOnExceptionStepCopyStepDetailsDestinationFileLocationS3FileLocation();
            _resultValue.bucket = bucket;
            _resultValue.key = key;
            return _resultValue;
        }
    }
}
