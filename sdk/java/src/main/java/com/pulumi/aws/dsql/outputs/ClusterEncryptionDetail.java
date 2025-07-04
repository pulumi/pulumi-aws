// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dsql.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class ClusterEncryptionDetail {
    /**
     * @return The status of encryption for the DSQL Cluster.
     * 
     */
    private String encryptionStatus;
    /**
     * @return The type of encryption that protects the data on the DSQL Cluster.
     * 
     */
    private String encryptionType;

    private ClusterEncryptionDetail() {}
    /**
     * @return The status of encryption for the DSQL Cluster.
     * 
     */
    public String encryptionStatus() {
        return this.encryptionStatus;
    }
    /**
     * @return The type of encryption that protects the data on the DSQL Cluster.
     * 
     */
    public String encryptionType() {
        return this.encryptionType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ClusterEncryptionDetail defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String encryptionStatus;
        private String encryptionType;
        public Builder() {}
        public Builder(ClusterEncryptionDetail defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.encryptionStatus = defaults.encryptionStatus;
    	      this.encryptionType = defaults.encryptionType;
        }

        @CustomType.Setter
        public Builder encryptionStatus(String encryptionStatus) {
            if (encryptionStatus == null) {
              throw new MissingRequiredPropertyException("ClusterEncryptionDetail", "encryptionStatus");
            }
            this.encryptionStatus = encryptionStatus;
            return this;
        }
        @CustomType.Setter
        public Builder encryptionType(String encryptionType) {
            if (encryptionType == null) {
              throw new MissingRequiredPropertyException("ClusterEncryptionDetail", "encryptionType");
            }
            this.encryptionType = encryptionType;
            return this;
        }
        public ClusterEncryptionDetail build() {
            final var _resultValue = new ClusterEncryptionDetail();
            _resultValue.encryptionStatus = encryptionStatus;
            _resultValue.encryptionType = encryptionType;
            return _resultValue;
        }
    }
}
