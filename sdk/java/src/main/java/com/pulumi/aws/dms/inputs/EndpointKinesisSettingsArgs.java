// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dms.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class EndpointKinesisSettingsArgs extends com.pulumi.resources.ResourceArgs {

    public static final EndpointKinesisSettingsArgs Empty = new EndpointKinesisSettingsArgs();

    /**
     * Shows detailed control information for table definition, column definition, and table and column changes in the Kinesis message output. Default is `false`.
     * 
     */
    @Import(name="includeControlDetails")
    private @Nullable Output<Boolean> includeControlDetails;

    /**
     * @return Shows detailed control information for table definition, column definition, and table and column changes in the Kinesis message output. Default is `false`.
     * 
     */
    public Optional<Output<Boolean>> includeControlDetails() {
        return Optional.ofNullable(this.includeControlDetails);
    }

    /**
     * Include NULL and empty columns in the target. Default is `false`.
     * 
     */
    @Import(name="includeNullAndEmpty")
    private @Nullable Output<Boolean> includeNullAndEmpty;

    /**
     * @return Include NULL and empty columns in the target. Default is `false`.
     * 
     */
    public Optional<Output<Boolean>> includeNullAndEmpty() {
        return Optional.ofNullable(this.includeNullAndEmpty);
    }

    /**
     * Shows the partition value within the Kinesis message output, unless the partition type is schema-table-type. Default is `false`.
     * 
     */
    @Import(name="includePartitionValue")
    private @Nullable Output<Boolean> includePartitionValue;

    /**
     * @return Shows the partition value within the Kinesis message output, unless the partition type is schema-table-type. Default is `false`.
     * 
     */
    public Optional<Output<Boolean>> includePartitionValue() {
        return Optional.ofNullable(this.includePartitionValue);
    }

    /**
     * Includes any data definition language (DDL) operations that change the table in the control data. Default is `false`.
     * 
     */
    @Import(name="includeTableAlterOperations")
    private @Nullable Output<Boolean> includeTableAlterOperations;

    /**
     * @return Includes any data definition language (DDL) operations that change the table in the control data. Default is `false`.
     * 
     */
    public Optional<Output<Boolean>> includeTableAlterOperations() {
        return Optional.ofNullable(this.includeTableAlterOperations);
    }

    /**
     * Provides detailed transaction information from the source database. Default is `false`.
     * 
     */
    @Import(name="includeTransactionDetails")
    private @Nullable Output<Boolean> includeTransactionDetails;

    /**
     * @return Provides detailed transaction information from the source database. Default is `false`.
     * 
     */
    public Optional<Output<Boolean>> includeTransactionDetails() {
        return Optional.ofNullable(this.includeTransactionDetails);
    }

    /**
     * Output format for the records created. Default is `json`. Valid values are `json` and `json-unformatted` (a single line with no tab).
     * 
     */
    @Import(name="messageFormat")
    private @Nullable Output<String> messageFormat;

    /**
     * @return Output format for the records created. Default is `json`. Valid values are `json` and `json-unformatted` (a single line with no tab).
     * 
     */
    public Optional<Output<String>> messageFormat() {
        return Optional.ofNullable(this.messageFormat);
    }

    /**
     * Prefixes schema and table names to partition values, when the partition type is primary-key-type. Default is `false`.
     * 
     */
    @Import(name="partitionIncludeSchemaTable")
    private @Nullable Output<Boolean> partitionIncludeSchemaTable;

    /**
     * @return Prefixes schema and table names to partition values, when the partition type is primary-key-type. Default is `false`.
     * 
     */
    public Optional<Output<Boolean>> partitionIncludeSchemaTable() {
        return Optional.ofNullable(this.partitionIncludeSchemaTable);
    }

    /**
     * ARN of the IAM Role with permissions to write to the Kinesis data stream.
     * 
     */
    @Import(name="serviceAccessRoleArn")
    private @Nullable Output<String> serviceAccessRoleArn;

    /**
     * @return ARN of the IAM Role with permissions to write to the Kinesis data stream.
     * 
     */
    public Optional<Output<String>> serviceAccessRoleArn() {
        return Optional.ofNullable(this.serviceAccessRoleArn);
    }

    /**
     * ARN of the Kinesis data stream.
     * 
     */
    @Import(name="streamArn")
    private @Nullable Output<String> streamArn;

    /**
     * @return ARN of the Kinesis data stream.
     * 
     */
    public Optional<Output<String>> streamArn() {
        return Optional.ofNullable(this.streamArn);
    }

    /**
     * Use up to 18 digit int instead of casting ints as doubles, available from AWS DMS version 3.5.4. Default is `false`.
     * 
     */
    @Import(name="useLargeIntegerValue")
    private @Nullable Output<Boolean> useLargeIntegerValue;

    /**
     * @return Use up to 18 digit int instead of casting ints as doubles, available from AWS DMS version 3.5.4. Default is `false`.
     * 
     */
    public Optional<Output<Boolean>> useLargeIntegerValue() {
        return Optional.ofNullable(this.useLargeIntegerValue);
    }

    private EndpointKinesisSettingsArgs() {}

    private EndpointKinesisSettingsArgs(EndpointKinesisSettingsArgs $) {
        this.includeControlDetails = $.includeControlDetails;
        this.includeNullAndEmpty = $.includeNullAndEmpty;
        this.includePartitionValue = $.includePartitionValue;
        this.includeTableAlterOperations = $.includeTableAlterOperations;
        this.includeTransactionDetails = $.includeTransactionDetails;
        this.messageFormat = $.messageFormat;
        this.partitionIncludeSchemaTable = $.partitionIncludeSchemaTable;
        this.serviceAccessRoleArn = $.serviceAccessRoleArn;
        this.streamArn = $.streamArn;
        this.useLargeIntegerValue = $.useLargeIntegerValue;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(EndpointKinesisSettingsArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private EndpointKinesisSettingsArgs $;

        public Builder() {
            $ = new EndpointKinesisSettingsArgs();
        }

        public Builder(EndpointKinesisSettingsArgs defaults) {
            $ = new EndpointKinesisSettingsArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param includeControlDetails Shows detailed control information for table definition, column definition, and table and column changes in the Kinesis message output. Default is `false`.
         * 
         * @return builder
         * 
         */
        public Builder includeControlDetails(@Nullable Output<Boolean> includeControlDetails) {
            $.includeControlDetails = includeControlDetails;
            return this;
        }

        /**
         * @param includeControlDetails Shows detailed control information for table definition, column definition, and table and column changes in the Kinesis message output. Default is `false`.
         * 
         * @return builder
         * 
         */
        public Builder includeControlDetails(Boolean includeControlDetails) {
            return includeControlDetails(Output.of(includeControlDetails));
        }

        /**
         * @param includeNullAndEmpty Include NULL and empty columns in the target. Default is `false`.
         * 
         * @return builder
         * 
         */
        public Builder includeNullAndEmpty(@Nullable Output<Boolean> includeNullAndEmpty) {
            $.includeNullAndEmpty = includeNullAndEmpty;
            return this;
        }

        /**
         * @param includeNullAndEmpty Include NULL and empty columns in the target. Default is `false`.
         * 
         * @return builder
         * 
         */
        public Builder includeNullAndEmpty(Boolean includeNullAndEmpty) {
            return includeNullAndEmpty(Output.of(includeNullAndEmpty));
        }

        /**
         * @param includePartitionValue Shows the partition value within the Kinesis message output, unless the partition type is schema-table-type. Default is `false`.
         * 
         * @return builder
         * 
         */
        public Builder includePartitionValue(@Nullable Output<Boolean> includePartitionValue) {
            $.includePartitionValue = includePartitionValue;
            return this;
        }

        /**
         * @param includePartitionValue Shows the partition value within the Kinesis message output, unless the partition type is schema-table-type. Default is `false`.
         * 
         * @return builder
         * 
         */
        public Builder includePartitionValue(Boolean includePartitionValue) {
            return includePartitionValue(Output.of(includePartitionValue));
        }

        /**
         * @param includeTableAlterOperations Includes any data definition language (DDL) operations that change the table in the control data. Default is `false`.
         * 
         * @return builder
         * 
         */
        public Builder includeTableAlterOperations(@Nullable Output<Boolean> includeTableAlterOperations) {
            $.includeTableAlterOperations = includeTableAlterOperations;
            return this;
        }

        /**
         * @param includeTableAlterOperations Includes any data definition language (DDL) operations that change the table in the control data. Default is `false`.
         * 
         * @return builder
         * 
         */
        public Builder includeTableAlterOperations(Boolean includeTableAlterOperations) {
            return includeTableAlterOperations(Output.of(includeTableAlterOperations));
        }

        /**
         * @param includeTransactionDetails Provides detailed transaction information from the source database. Default is `false`.
         * 
         * @return builder
         * 
         */
        public Builder includeTransactionDetails(@Nullable Output<Boolean> includeTransactionDetails) {
            $.includeTransactionDetails = includeTransactionDetails;
            return this;
        }

        /**
         * @param includeTransactionDetails Provides detailed transaction information from the source database. Default is `false`.
         * 
         * @return builder
         * 
         */
        public Builder includeTransactionDetails(Boolean includeTransactionDetails) {
            return includeTransactionDetails(Output.of(includeTransactionDetails));
        }

        /**
         * @param messageFormat Output format for the records created. Default is `json`. Valid values are `json` and `json-unformatted` (a single line with no tab).
         * 
         * @return builder
         * 
         */
        public Builder messageFormat(@Nullable Output<String> messageFormat) {
            $.messageFormat = messageFormat;
            return this;
        }

        /**
         * @param messageFormat Output format for the records created. Default is `json`. Valid values are `json` and `json-unformatted` (a single line with no tab).
         * 
         * @return builder
         * 
         */
        public Builder messageFormat(String messageFormat) {
            return messageFormat(Output.of(messageFormat));
        }

        /**
         * @param partitionIncludeSchemaTable Prefixes schema and table names to partition values, when the partition type is primary-key-type. Default is `false`.
         * 
         * @return builder
         * 
         */
        public Builder partitionIncludeSchemaTable(@Nullable Output<Boolean> partitionIncludeSchemaTable) {
            $.partitionIncludeSchemaTable = partitionIncludeSchemaTable;
            return this;
        }

        /**
         * @param partitionIncludeSchemaTable Prefixes schema and table names to partition values, when the partition type is primary-key-type. Default is `false`.
         * 
         * @return builder
         * 
         */
        public Builder partitionIncludeSchemaTable(Boolean partitionIncludeSchemaTable) {
            return partitionIncludeSchemaTable(Output.of(partitionIncludeSchemaTable));
        }

        /**
         * @param serviceAccessRoleArn ARN of the IAM Role with permissions to write to the Kinesis data stream.
         * 
         * @return builder
         * 
         */
        public Builder serviceAccessRoleArn(@Nullable Output<String> serviceAccessRoleArn) {
            $.serviceAccessRoleArn = serviceAccessRoleArn;
            return this;
        }

        /**
         * @param serviceAccessRoleArn ARN of the IAM Role with permissions to write to the Kinesis data stream.
         * 
         * @return builder
         * 
         */
        public Builder serviceAccessRoleArn(String serviceAccessRoleArn) {
            return serviceAccessRoleArn(Output.of(serviceAccessRoleArn));
        }

        /**
         * @param streamArn ARN of the Kinesis data stream.
         * 
         * @return builder
         * 
         */
        public Builder streamArn(@Nullable Output<String> streamArn) {
            $.streamArn = streamArn;
            return this;
        }

        /**
         * @param streamArn ARN of the Kinesis data stream.
         * 
         * @return builder
         * 
         */
        public Builder streamArn(String streamArn) {
            return streamArn(Output.of(streamArn));
        }

        /**
         * @param useLargeIntegerValue Use up to 18 digit int instead of casting ints as doubles, available from AWS DMS version 3.5.4. Default is `false`.
         * 
         * @return builder
         * 
         */
        public Builder useLargeIntegerValue(@Nullable Output<Boolean> useLargeIntegerValue) {
            $.useLargeIntegerValue = useLargeIntegerValue;
            return this;
        }

        /**
         * @param useLargeIntegerValue Use up to 18 digit int instead of casting ints as doubles, available from AWS DMS version 3.5.4. Default is `false`.
         * 
         * @return builder
         * 
         */
        public Builder useLargeIntegerValue(Boolean useLargeIntegerValue) {
            return useLargeIntegerValue(Output.of(useLargeIntegerValue));
        }

        public EndpointKinesisSettingsArgs build() {
            return $;
        }
    }

}
