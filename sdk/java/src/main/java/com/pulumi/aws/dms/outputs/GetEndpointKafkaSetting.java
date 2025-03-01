// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dms.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetEndpointKafkaSetting {
    private String broker;
    private Boolean includeControlDetails;
    private Boolean includeNullAndEmpty;
    private Boolean includePartitionValue;
    private Boolean includeTableAlterOperations;
    private Boolean includeTransactionDetails;
    private String messageFormat;
    private Integer messageMaxBytes;
    private Boolean noHexPrefix;
    private Boolean partitionIncludeSchemaTable;
    private String saslMechanism;
    private String saslPassword;
    private String saslUsername;
    private String securityProtocol;
    private String sslCaCertificateArn;
    private String sslClientCertificateArn;
    private String sslClientKeyArn;
    private String sslClientKeyPassword;
    private String topic;

    private GetEndpointKafkaSetting() {}
    public String broker() {
        return this.broker;
    }
    public Boolean includeControlDetails() {
        return this.includeControlDetails;
    }
    public Boolean includeNullAndEmpty() {
        return this.includeNullAndEmpty;
    }
    public Boolean includePartitionValue() {
        return this.includePartitionValue;
    }
    public Boolean includeTableAlterOperations() {
        return this.includeTableAlterOperations;
    }
    public Boolean includeTransactionDetails() {
        return this.includeTransactionDetails;
    }
    public String messageFormat() {
        return this.messageFormat;
    }
    public Integer messageMaxBytes() {
        return this.messageMaxBytes;
    }
    public Boolean noHexPrefix() {
        return this.noHexPrefix;
    }
    public Boolean partitionIncludeSchemaTable() {
        return this.partitionIncludeSchemaTable;
    }
    public String saslMechanism() {
        return this.saslMechanism;
    }
    public String saslPassword() {
        return this.saslPassword;
    }
    public String saslUsername() {
        return this.saslUsername;
    }
    public String securityProtocol() {
        return this.securityProtocol;
    }
    public String sslCaCertificateArn() {
        return this.sslCaCertificateArn;
    }
    public String sslClientCertificateArn() {
        return this.sslClientCertificateArn;
    }
    public String sslClientKeyArn() {
        return this.sslClientKeyArn;
    }
    public String sslClientKeyPassword() {
        return this.sslClientKeyPassword;
    }
    public String topic() {
        return this.topic;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetEndpointKafkaSetting defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String broker;
        private Boolean includeControlDetails;
        private Boolean includeNullAndEmpty;
        private Boolean includePartitionValue;
        private Boolean includeTableAlterOperations;
        private Boolean includeTransactionDetails;
        private String messageFormat;
        private Integer messageMaxBytes;
        private Boolean noHexPrefix;
        private Boolean partitionIncludeSchemaTable;
        private String saslMechanism;
        private String saslPassword;
        private String saslUsername;
        private String securityProtocol;
        private String sslCaCertificateArn;
        private String sslClientCertificateArn;
        private String sslClientKeyArn;
        private String sslClientKeyPassword;
        private String topic;
        public Builder() {}
        public Builder(GetEndpointKafkaSetting defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.broker = defaults.broker;
    	      this.includeControlDetails = defaults.includeControlDetails;
    	      this.includeNullAndEmpty = defaults.includeNullAndEmpty;
    	      this.includePartitionValue = defaults.includePartitionValue;
    	      this.includeTableAlterOperations = defaults.includeTableAlterOperations;
    	      this.includeTransactionDetails = defaults.includeTransactionDetails;
    	      this.messageFormat = defaults.messageFormat;
    	      this.messageMaxBytes = defaults.messageMaxBytes;
    	      this.noHexPrefix = defaults.noHexPrefix;
    	      this.partitionIncludeSchemaTable = defaults.partitionIncludeSchemaTable;
    	      this.saslMechanism = defaults.saslMechanism;
    	      this.saslPassword = defaults.saslPassword;
    	      this.saslUsername = defaults.saslUsername;
    	      this.securityProtocol = defaults.securityProtocol;
    	      this.sslCaCertificateArn = defaults.sslCaCertificateArn;
    	      this.sslClientCertificateArn = defaults.sslClientCertificateArn;
    	      this.sslClientKeyArn = defaults.sslClientKeyArn;
    	      this.sslClientKeyPassword = defaults.sslClientKeyPassword;
    	      this.topic = defaults.topic;
        }

        @CustomType.Setter
        public Builder broker(String broker) {
            if (broker == null) {
              throw new MissingRequiredPropertyException("GetEndpointKafkaSetting", "broker");
            }
            this.broker = broker;
            return this;
        }
        @CustomType.Setter
        public Builder includeControlDetails(Boolean includeControlDetails) {
            if (includeControlDetails == null) {
              throw new MissingRequiredPropertyException("GetEndpointKafkaSetting", "includeControlDetails");
            }
            this.includeControlDetails = includeControlDetails;
            return this;
        }
        @CustomType.Setter
        public Builder includeNullAndEmpty(Boolean includeNullAndEmpty) {
            if (includeNullAndEmpty == null) {
              throw new MissingRequiredPropertyException("GetEndpointKafkaSetting", "includeNullAndEmpty");
            }
            this.includeNullAndEmpty = includeNullAndEmpty;
            return this;
        }
        @CustomType.Setter
        public Builder includePartitionValue(Boolean includePartitionValue) {
            if (includePartitionValue == null) {
              throw new MissingRequiredPropertyException("GetEndpointKafkaSetting", "includePartitionValue");
            }
            this.includePartitionValue = includePartitionValue;
            return this;
        }
        @CustomType.Setter
        public Builder includeTableAlterOperations(Boolean includeTableAlterOperations) {
            if (includeTableAlterOperations == null) {
              throw new MissingRequiredPropertyException("GetEndpointKafkaSetting", "includeTableAlterOperations");
            }
            this.includeTableAlterOperations = includeTableAlterOperations;
            return this;
        }
        @CustomType.Setter
        public Builder includeTransactionDetails(Boolean includeTransactionDetails) {
            if (includeTransactionDetails == null) {
              throw new MissingRequiredPropertyException("GetEndpointKafkaSetting", "includeTransactionDetails");
            }
            this.includeTransactionDetails = includeTransactionDetails;
            return this;
        }
        @CustomType.Setter
        public Builder messageFormat(String messageFormat) {
            if (messageFormat == null) {
              throw new MissingRequiredPropertyException("GetEndpointKafkaSetting", "messageFormat");
            }
            this.messageFormat = messageFormat;
            return this;
        }
        @CustomType.Setter
        public Builder messageMaxBytes(Integer messageMaxBytes) {
            if (messageMaxBytes == null) {
              throw new MissingRequiredPropertyException("GetEndpointKafkaSetting", "messageMaxBytes");
            }
            this.messageMaxBytes = messageMaxBytes;
            return this;
        }
        @CustomType.Setter
        public Builder noHexPrefix(Boolean noHexPrefix) {
            if (noHexPrefix == null) {
              throw new MissingRequiredPropertyException("GetEndpointKafkaSetting", "noHexPrefix");
            }
            this.noHexPrefix = noHexPrefix;
            return this;
        }
        @CustomType.Setter
        public Builder partitionIncludeSchemaTable(Boolean partitionIncludeSchemaTable) {
            if (partitionIncludeSchemaTable == null) {
              throw new MissingRequiredPropertyException("GetEndpointKafkaSetting", "partitionIncludeSchemaTable");
            }
            this.partitionIncludeSchemaTable = partitionIncludeSchemaTable;
            return this;
        }
        @CustomType.Setter
        public Builder saslMechanism(String saslMechanism) {
            if (saslMechanism == null) {
              throw new MissingRequiredPropertyException("GetEndpointKafkaSetting", "saslMechanism");
            }
            this.saslMechanism = saslMechanism;
            return this;
        }
        @CustomType.Setter
        public Builder saslPassword(String saslPassword) {
            if (saslPassword == null) {
              throw new MissingRequiredPropertyException("GetEndpointKafkaSetting", "saslPassword");
            }
            this.saslPassword = saslPassword;
            return this;
        }
        @CustomType.Setter
        public Builder saslUsername(String saslUsername) {
            if (saslUsername == null) {
              throw new MissingRequiredPropertyException("GetEndpointKafkaSetting", "saslUsername");
            }
            this.saslUsername = saslUsername;
            return this;
        }
        @CustomType.Setter
        public Builder securityProtocol(String securityProtocol) {
            if (securityProtocol == null) {
              throw new MissingRequiredPropertyException("GetEndpointKafkaSetting", "securityProtocol");
            }
            this.securityProtocol = securityProtocol;
            return this;
        }
        @CustomType.Setter
        public Builder sslCaCertificateArn(String sslCaCertificateArn) {
            if (sslCaCertificateArn == null) {
              throw new MissingRequiredPropertyException("GetEndpointKafkaSetting", "sslCaCertificateArn");
            }
            this.sslCaCertificateArn = sslCaCertificateArn;
            return this;
        }
        @CustomType.Setter
        public Builder sslClientCertificateArn(String sslClientCertificateArn) {
            if (sslClientCertificateArn == null) {
              throw new MissingRequiredPropertyException("GetEndpointKafkaSetting", "sslClientCertificateArn");
            }
            this.sslClientCertificateArn = sslClientCertificateArn;
            return this;
        }
        @CustomType.Setter
        public Builder sslClientKeyArn(String sslClientKeyArn) {
            if (sslClientKeyArn == null) {
              throw new MissingRequiredPropertyException("GetEndpointKafkaSetting", "sslClientKeyArn");
            }
            this.sslClientKeyArn = sslClientKeyArn;
            return this;
        }
        @CustomType.Setter
        public Builder sslClientKeyPassword(String sslClientKeyPassword) {
            if (sslClientKeyPassword == null) {
              throw new MissingRequiredPropertyException("GetEndpointKafkaSetting", "sslClientKeyPassword");
            }
            this.sslClientKeyPassword = sslClientKeyPassword;
            return this;
        }
        @CustomType.Setter
        public Builder topic(String topic) {
            if (topic == null) {
              throw new MissingRequiredPropertyException("GetEndpointKafkaSetting", "topic");
            }
            this.topic = topic;
            return this;
        }
        public GetEndpointKafkaSetting build() {
            final var _resultValue = new GetEndpointKafkaSetting();
            _resultValue.broker = broker;
            _resultValue.includeControlDetails = includeControlDetails;
            _resultValue.includeNullAndEmpty = includeNullAndEmpty;
            _resultValue.includePartitionValue = includePartitionValue;
            _resultValue.includeTableAlterOperations = includeTableAlterOperations;
            _resultValue.includeTransactionDetails = includeTransactionDetails;
            _resultValue.messageFormat = messageFormat;
            _resultValue.messageMaxBytes = messageMaxBytes;
            _resultValue.noHexPrefix = noHexPrefix;
            _resultValue.partitionIncludeSchemaTable = partitionIncludeSchemaTable;
            _resultValue.saslMechanism = saslMechanism;
            _resultValue.saslPassword = saslPassword;
            _resultValue.saslUsername = saslUsername;
            _resultValue.securityProtocol = securityProtocol;
            _resultValue.sslCaCertificateArn = sslCaCertificateArn;
            _resultValue.sslClientCertificateArn = sslClientCertificateArn;
            _resultValue.sslClientKeyArn = sslClientKeyArn;
            _resultValue.sslClientKeyPassword = sslClientKeyPassword;
            _resultValue.topic = topic;
            return _resultValue;
        }
    }
}
