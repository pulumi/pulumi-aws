// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dms.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetEndpointKinesisSetting {
    private Boolean includeControlDetails;
    private Boolean includeNullAndEmpty;
    private Boolean includePartitionValue;
    private Boolean includeTableAlterOperations;
    private Boolean includeTransactionDetails;
    private String messageFormat;
    private Boolean partitionIncludeSchemaTable;
    private String serviceAccessRoleArn;
    private String streamArn;

    private GetEndpointKinesisSetting() {}
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
    public Boolean partitionIncludeSchemaTable() {
        return this.partitionIncludeSchemaTable;
    }
    public String serviceAccessRoleArn() {
        return this.serviceAccessRoleArn;
    }
    public String streamArn() {
        return this.streamArn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetEndpointKinesisSetting defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Boolean includeControlDetails;
        private Boolean includeNullAndEmpty;
        private Boolean includePartitionValue;
        private Boolean includeTableAlterOperations;
        private Boolean includeTransactionDetails;
        private String messageFormat;
        private Boolean partitionIncludeSchemaTable;
        private String serviceAccessRoleArn;
        private String streamArn;
        public Builder() {}
        public Builder(GetEndpointKinesisSetting defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.includeControlDetails = defaults.includeControlDetails;
    	      this.includeNullAndEmpty = defaults.includeNullAndEmpty;
    	      this.includePartitionValue = defaults.includePartitionValue;
    	      this.includeTableAlterOperations = defaults.includeTableAlterOperations;
    	      this.includeTransactionDetails = defaults.includeTransactionDetails;
    	      this.messageFormat = defaults.messageFormat;
    	      this.partitionIncludeSchemaTable = defaults.partitionIncludeSchemaTable;
    	      this.serviceAccessRoleArn = defaults.serviceAccessRoleArn;
    	      this.streamArn = defaults.streamArn;
        }

        @CustomType.Setter
        public Builder includeControlDetails(Boolean includeControlDetails) {
            this.includeControlDetails = Objects.requireNonNull(includeControlDetails);
            return this;
        }
        @CustomType.Setter
        public Builder includeNullAndEmpty(Boolean includeNullAndEmpty) {
            this.includeNullAndEmpty = Objects.requireNonNull(includeNullAndEmpty);
            return this;
        }
        @CustomType.Setter
        public Builder includePartitionValue(Boolean includePartitionValue) {
            this.includePartitionValue = Objects.requireNonNull(includePartitionValue);
            return this;
        }
        @CustomType.Setter
        public Builder includeTableAlterOperations(Boolean includeTableAlterOperations) {
            this.includeTableAlterOperations = Objects.requireNonNull(includeTableAlterOperations);
            return this;
        }
        @CustomType.Setter
        public Builder includeTransactionDetails(Boolean includeTransactionDetails) {
            this.includeTransactionDetails = Objects.requireNonNull(includeTransactionDetails);
            return this;
        }
        @CustomType.Setter
        public Builder messageFormat(String messageFormat) {
            this.messageFormat = Objects.requireNonNull(messageFormat);
            return this;
        }
        @CustomType.Setter
        public Builder partitionIncludeSchemaTable(Boolean partitionIncludeSchemaTable) {
            this.partitionIncludeSchemaTable = Objects.requireNonNull(partitionIncludeSchemaTable);
            return this;
        }
        @CustomType.Setter
        public Builder serviceAccessRoleArn(String serviceAccessRoleArn) {
            this.serviceAccessRoleArn = Objects.requireNonNull(serviceAccessRoleArn);
            return this;
        }
        @CustomType.Setter
        public Builder streamArn(String streamArn) {
            this.streamArn = Objects.requireNonNull(streamArn);
            return this;
        }
        public GetEndpointKinesisSetting build() {
            final var o = new GetEndpointKinesisSetting();
            o.includeControlDetails = includeControlDetails;
            o.includeNullAndEmpty = includeNullAndEmpty;
            o.includePartitionValue = includePartitionValue;
            o.includeTableAlterOperations = includeTableAlterOperations;
            o.includeTransactionDetails = includeTransactionDetails;
            o.messageFormat = messageFormat;
            o.partitionIncludeSchemaTable = partitionIncludeSchemaTable;
            o.serviceAccessRoleArn = serviceAccessRoleArn;
            o.streamArn = streamArn;
            return o;
        }
    }
}