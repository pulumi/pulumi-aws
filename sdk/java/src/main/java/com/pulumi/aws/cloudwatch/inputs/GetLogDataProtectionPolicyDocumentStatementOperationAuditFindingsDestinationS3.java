// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudwatch.inputs;

import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationS3 extends com.pulumi.resources.InvokeArgs {

    public static final GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationS3 Empty = new GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationS3();

    /**
     * Name of the S3 Bucket to send findings to.
     * 
     */
    @Import(name="bucket", required=true)
    private String bucket;

    /**
     * @return Name of the S3 Bucket to send findings to.
     * 
     */
    public String bucket() {
        return this.bucket;
    }

    private GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationS3() {}

    private GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationS3(GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationS3 $) {
        this.bucket = $.bucket;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationS3 defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationS3 $;

        public Builder() {
            $ = new GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationS3();
        }

        public Builder(GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationS3 defaults) {
            $ = new GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationS3(Objects.requireNonNull(defaults));
        }

        /**
         * @param bucket Name of the S3 Bucket to send findings to.
         * 
         * @return builder
         * 
         */
        public Builder bucket(String bucket) {
            $.bucket = bucket;
            return this;
        }

        public GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationS3 build() {
            if ($.bucket == null) {
                throw new MissingRequiredPropertyException("GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationS3", "bucket");
            }
            return $;
        }
    }

}
