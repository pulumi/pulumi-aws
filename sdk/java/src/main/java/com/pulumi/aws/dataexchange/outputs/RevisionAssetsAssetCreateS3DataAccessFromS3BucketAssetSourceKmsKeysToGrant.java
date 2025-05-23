// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dataexchange.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceKmsKeysToGrant {
    /**
     * @return The ARN of the KMS key.
     * 
     */
    private String kmsKeyArn;

    private RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceKmsKeysToGrant() {}
    /**
     * @return The ARN of the KMS key.
     * 
     */
    public String kmsKeyArn() {
        return this.kmsKeyArn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceKmsKeysToGrant defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String kmsKeyArn;
        public Builder() {}
        public Builder(RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceKmsKeysToGrant defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.kmsKeyArn = defaults.kmsKeyArn;
        }

        @CustomType.Setter
        public Builder kmsKeyArn(String kmsKeyArn) {
            if (kmsKeyArn == null) {
              throw new MissingRequiredPropertyException("RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceKmsKeysToGrant", "kmsKeyArn");
            }
            this.kmsKeyArn = kmsKeyArn;
            return this;
        }
        public RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceKmsKeysToGrant build() {
            final var _resultValue = new RevisionAssetsAssetCreateS3DataAccessFromS3BucketAssetSourceKmsKeysToGrant();
            _resultValue.kmsKeyArn = kmsKeyArn;
            return _resultValue;
        }
    }
}
