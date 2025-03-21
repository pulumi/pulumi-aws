// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sagemaker.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class DataQualityJobDefinitionDataQualityJobOutputConfigMonitoringOutputsS3Output {
    /**
     * @return The local path to the Amazon S3 storage location where Amazon SageMaker AI saves the results of a monitoring job. LocalPath is an absolute path for the output data. Defaults to `/opt/ml/processing/output`.
     * 
     */
    private @Nullable String localPath;
    /**
     * @return Whether to upload the results of the monitoring job continuously or after the job completes. Valid values are `Continuous` or `EndOfJob`
     * 
     */
    private @Nullable String s3UploadMode;
    /**
     * @return A URI that identifies the Amazon S3 storage location where Amazon SageMaker AI saves the results of a monitoring job.
     * 
     */
    private String s3Uri;

    private DataQualityJobDefinitionDataQualityJobOutputConfigMonitoringOutputsS3Output() {}
    /**
     * @return The local path to the Amazon S3 storage location where Amazon SageMaker AI saves the results of a monitoring job. LocalPath is an absolute path for the output data. Defaults to `/opt/ml/processing/output`.
     * 
     */
    public Optional<String> localPath() {
        return Optional.ofNullable(this.localPath);
    }
    /**
     * @return Whether to upload the results of the monitoring job continuously or after the job completes. Valid values are `Continuous` or `EndOfJob`
     * 
     */
    public Optional<String> s3UploadMode() {
        return Optional.ofNullable(this.s3UploadMode);
    }
    /**
     * @return A URI that identifies the Amazon S3 storage location where Amazon SageMaker AI saves the results of a monitoring job.
     * 
     */
    public String s3Uri() {
        return this.s3Uri;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(DataQualityJobDefinitionDataQualityJobOutputConfigMonitoringOutputsS3Output defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String localPath;
        private @Nullable String s3UploadMode;
        private String s3Uri;
        public Builder() {}
        public Builder(DataQualityJobDefinitionDataQualityJobOutputConfigMonitoringOutputsS3Output defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.localPath = defaults.localPath;
    	      this.s3UploadMode = defaults.s3UploadMode;
    	      this.s3Uri = defaults.s3Uri;
        }

        @CustomType.Setter
        public Builder localPath(@Nullable String localPath) {

            this.localPath = localPath;
            return this;
        }
        @CustomType.Setter
        public Builder s3UploadMode(@Nullable String s3UploadMode) {

            this.s3UploadMode = s3UploadMode;
            return this;
        }
        @CustomType.Setter
        public Builder s3Uri(String s3Uri) {
            if (s3Uri == null) {
              throw new MissingRequiredPropertyException("DataQualityJobDefinitionDataQualityJobOutputConfigMonitoringOutputsS3Output", "s3Uri");
            }
            this.s3Uri = s3Uri;
            return this;
        }
        public DataQualityJobDefinitionDataQualityJobOutputConfigMonitoringOutputsS3Output build() {
            final var _resultValue = new DataQualityJobDefinitionDataQualityJobOutputConfigMonitoringOutputsS3Output();
            _resultValue.localPath = localPath;
            _resultValue.s3UploadMode = s3UploadMode;
            _resultValue.s3Uri = s3Uri;
            return _resultValue;
        }
    }
}
