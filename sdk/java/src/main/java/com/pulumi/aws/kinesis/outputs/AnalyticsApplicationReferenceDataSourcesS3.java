// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.kinesis.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class AnalyticsApplicationReferenceDataSourcesS3 {
    /**
     * @return The S3 Bucket ARN.
     * 
     */
    private String bucketArn;
    /**
     * @return The File Key name containing reference data.
     * 
     */
    private String fileKey;
    /**
     * @return The IAM Role ARN to read the data.
     * 
     */
    private String roleArn;

    private AnalyticsApplicationReferenceDataSourcesS3() {}
    /**
     * @return The S3 Bucket ARN.
     * 
     */
    public String bucketArn() {
        return this.bucketArn;
    }
    /**
     * @return The File Key name containing reference data.
     * 
     */
    public String fileKey() {
        return this.fileKey;
    }
    /**
     * @return The IAM Role ARN to read the data.
     * 
     */
    public String roleArn() {
        return this.roleArn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(AnalyticsApplicationReferenceDataSourcesS3 defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String bucketArn;
        private String fileKey;
        private String roleArn;
        public Builder() {}
        public Builder(AnalyticsApplicationReferenceDataSourcesS3 defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.bucketArn = defaults.bucketArn;
    	      this.fileKey = defaults.fileKey;
    	      this.roleArn = defaults.roleArn;
        }

        @CustomType.Setter
        public Builder bucketArn(String bucketArn) {
            if (bucketArn == null) {
              throw new MissingRequiredPropertyException("AnalyticsApplicationReferenceDataSourcesS3", "bucketArn");
            }
            this.bucketArn = bucketArn;
            return this;
        }
        @CustomType.Setter
        public Builder fileKey(String fileKey) {
            if (fileKey == null) {
              throw new MissingRequiredPropertyException("AnalyticsApplicationReferenceDataSourcesS3", "fileKey");
            }
            this.fileKey = fileKey;
            return this;
        }
        @CustomType.Setter
        public Builder roleArn(String roleArn) {
            if (roleArn == null) {
              throw new MissingRequiredPropertyException("AnalyticsApplicationReferenceDataSourcesS3", "roleArn");
            }
            this.roleArn = roleArn;
            return this;
        }
        public AnalyticsApplicationReferenceDataSourcesS3 build() {
            final var _resultValue = new AnalyticsApplicationReferenceDataSourcesS3();
            _resultValue.bucketArn = bucketArn;
            _resultValue.fileKey = fileKey;
            _resultValue.roleArn = roleArn;
            return _resultValue;
        }
    }
}
