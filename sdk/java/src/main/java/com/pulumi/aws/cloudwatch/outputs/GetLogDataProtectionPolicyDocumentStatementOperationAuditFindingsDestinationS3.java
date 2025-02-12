// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudwatch.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationS3 {
    /**
     * @return Name of the S3 Bucket to send findings to.
     * 
     */
    private String bucket;

    private GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationS3() {}
    /**
     * @return Name of the S3 Bucket to send findings to.
     * 
     */
    public String bucket() {
        return this.bucket;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationS3 defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String bucket;
        public Builder() {}
        public Builder(GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationS3 defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.bucket = defaults.bucket;
        }

        @CustomType.Setter
        public Builder bucket(String bucket) {
            if (bucket == null) {
              throw new MissingRequiredPropertyException("GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationS3", "bucket");
            }
            this.bucket = bucket;
            return this;
        }
        public GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationS3 build() {
            final var _resultValue = new GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationS3();
            _resultValue.bucket = bucket;
            return _resultValue;
        }
    }
}
