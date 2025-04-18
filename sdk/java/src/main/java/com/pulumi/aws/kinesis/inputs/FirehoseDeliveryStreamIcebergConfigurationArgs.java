// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.kinesis.inputs;

import com.pulumi.aws.kinesis.inputs.FirehoseDeliveryStreamIcebergConfigurationCloudwatchLoggingOptionsArgs;
import com.pulumi.aws.kinesis.inputs.FirehoseDeliveryStreamIcebergConfigurationDestinationTableConfigurationArgs;
import com.pulumi.aws.kinesis.inputs.FirehoseDeliveryStreamIcebergConfigurationProcessingConfigurationArgs;
import com.pulumi.aws.kinesis.inputs.FirehoseDeliveryStreamIcebergConfigurationS3ConfigurationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class FirehoseDeliveryStreamIcebergConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final FirehoseDeliveryStreamIcebergConfigurationArgs Empty = new FirehoseDeliveryStreamIcebergConfigurationArgs();

    /**
     * Buffer incoming data for the specified period of time, in seconds between 0 and 900, before delivering it to the destination. The default value is 300.
     * 
     */
    @Import(name="bufferingInterval")
    private @Nullable Output<Integer> bufferingInterval;

    /**
     * @return Buffer incoming data for the specified period of time, in seconds between 0 and 900, before delivering it to the destination. The default value is 300.
     * 
     */
    public Optional<Output<Integer>> bufferingInterval() {
        return Optional.ofNullable(this.bufferingInterval);
    }

    /**
     * Buffer incoming data to the specified size, in MBs between 1 and 128, before delivering it to the destination. The default value is 5.
     * 
     */
    @Import(name="bufferingSize")
    private @Nullable Output<Integer> bufferingSize;

    /**
     * @return Buffer incoming data to the specified size, in MBs between 1 and 128, before delivering it to the destination. The default value is 5.
     * 
     */
    public Optional<Output<Integer>> bufferingSize() {
        return Optional.ofNullable(this.bufferingSize);
    }

    /**
     * Glue catalog ARN identifier of the destination Apache Iceberg Tables. You must specify the ARN in the format `arn:aws:glue:region:account-id:catalog`
     * 
     */
    @Import(name="catalogArn", required=true)
    private Output<String> catalogArn;

    /**
     * @return Glue catalog ARN identifier of the destination Apache Iceberg Tables. You must specify the ARN in the format `arn:aws:glue:region:account-id:catalog`
     * 
     */
    public Output<String> catalogArn() {
        return this.catalogArn;
    }

    /**
     * The CloudWatch Logging Options for the delivery stream. See `cloudwatch_logging_options` block below for details.
     * 
     */
    @Import(name="cloudwatchLoggingOptions")
    private @Nullable Output<FirehoseDeliveryStreamIcebergConfigurationCloudwatchLoggingOptionsArgs> cloudwatchLoggingOptions;

    /**
     * @return The CloudWatch Logging Options for the delivery stream. See `cloudwatch_logging_options` block below for details.
     * 
     */
    public Optional<Output<FirehoseDeliveryStreamIcebergConfigurationCloudwatchLoggingOptionsArgs>> cloudwatchLoggingOptions() {
        return Optional.ofNullable(this.cloudwatchLoggingOptions);
    }

    /**
     * Destination table configurations which Firehose uses to deliver data to Apache Iceberg Tables. Firehose will write data with insert if table specific configuration is not provided. See `destination_table_configuration` block below for details.
     * 
     */
    @Import(name="destinationTableConfigurations")
    private @Nullable Output<List<FirehoseDeliveryStreamIcebergConfigurationDestinationTableConfigurationArgs>> destinationTableConfigurations;

    /**
     * @return Destination table configurations which Firehose uses to deliver data to Apache Iceberg Tables. Firehose will write data with insert if table specific configuration is not provided. See `destination_table_configuration` block below for details.
     * 
     */
    public Optional<Output<List<FirehoseDeliveryStreamIcebergConfigurationDestinationTableConfigurationArgs>>> destinationTableConfigurations() {
        return Optional.ofNullable(this.destinationTableConfigurations);
    }

    /**
     * The data processing configuration.  See `processing_configuration` block below for details.
     * 
     */
    @Import(name="processingConfiguration")
    private @Nullable Output<FirehoseDeliveryStreamIcebergConfigurationProcessingConfigurationArgs> processingConfiguration;

    /**
     * @return The data processing configuration.  See `processing_configuration` block below for details.
     * 
     */
    public Optional<Output<FirehoseDeliveryStreamIcebergConfigurationProcessingConfigurationArgs>> processingConfiguration() {
        return Optional.ofNullable(this.processingConfiguration);
    }

    /**
     * The period of time, in seconds between 0 to 7200, during which Firehose retries to deliver data to the specified destination.
     * 
     */
    @Import(name="retryDuration")
    private @Nullable Output<Integer> retryDuration;

    /**
     * @return The period of time, in seconds between 0 to 7200, during which Firehose retries to deliver data to the specified destination.
     * 
     */
    public Optional<Output<Integer>> retryDuration() {
        return Optional.ofNullable(this.retryDuration);
    }

    /**
     * The ARN of the IAM role to be assumed by Firehose for calling Apache Iceberg Tables.
     * 
     */
    @Import(name="roleArn", required=true)
    private Output<String> roleArn;

    /**
     * @return The ARN of the IAM role to be assumed by Firehose for calling Apache Iceberg Tables.
     * 
     */
    public Output<String> roleArn() {
        return this.roleArn;
    }

    @Import(name="s3BackupMode")
    private @Nullable Output<String> s3BackupMode;

    public Optional<Output<String>> s3BackupMode() {
        return Optional.ofNullable(this.s3BackupMode);
    }

    /**
     * The S3 Configuration. See `s3_configuration` block below for details.
     * 
     */
    @Import(name="s3Configuration", required=true)
    private Output<FirehoseDeliveryStreamIcebergConfigurationS3ConfigurationArgs> s3Configuration;

    /**
     * @return The S3 Configuration. See `s3_configuration` block below for details.
     * 
     */
    public Output<FirehoseDeliveryStreamIcebergConfigurationS3ConfigurationArgs> s3Configuration() {
        return this.s3Configuration;
    }

    private FirehoseDeliveryStreamIcebergConfigurationArgs() {}

    private FirehoseDeliveryStreamIcebergConfigurationArgs(FirehoseDeliveryStreamIcebergConfigurationArgs $) {
        this.bufferingInterval = $.bufferingInterval;
        this.bufferingSize = $.bufferingSize;
        this.catalogArn = $.catalogArn;
        this.cloudwatchLoggingOptions = $.cloudwatchLoggingOptions;
        this.destinationTableConfigurations = $.destinationTableConfigurations;
        this.processingConfiguration = $.processingConfiguration;
        this.retryDuration = $.retryDuration;
        this.roleArn = $.roleArn;
        this.s3BackupMode = $.s3BackupMode;
        this.s3Configuration = $.s3Configuration;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(FirehoseDeliveryStreamIcebergConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private FirehoseDeliveryStreamIcebergConfigurationArgs $;

        public Builder() {
            $ = new FirehoseDeliveryStreamIcebergConfigurationArgs();
        }

        public Builder(FirehoseDeliveryStreamIcebergConfigurationArgs defaults) {
            $ = new FirehoseDeliveryStreamIcebergConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param bufferingInterval Buffer incoming data for the specified period of time, in seconds between 0 and 900, before delivering it to the destination. The default value is 300.
         * 
         * @return builder
         * 
         */
        public Builder bufferingInterval(@Nullable Output<Integer> bufferingInterval) {
            $.bufferingInterval = bufferingInterval;
            return this;
        }

        /**
         * @param bufferingInterval Buffer incoming data for the specified period of time, in seconds between 0 and 900, before delivering it to the destination. The default value is 300.
         * 
         * @return builder
         * 
         */
        public Builder bufferingInterval(Integer bufferingInterval) {
            return bufferingInterval(Output.of(bufferingInterval));
        }

        /**
         * @param bufferingSize Buffer incoming data to the specified size, in MBs between 1 and 128, before delivering it to the destination. The default value is 5.
         * 
         * @return builder
         * 
         */
        public Builder bufferingSize(@Nullable Output<Integer> bufferingSize) {
            $.bufferingSize = bufferingSize;
            return this;
        }

        /**
         * @param bufferingSize Buffer incoming data to the specified size, in MBs between 1 and 128, before delivering it to the destination. The default value is 5.
         * 
         * @return builder
         * 
         */
        public Builder bufferingSize(Integer bufferingSize) {
            return bufferingSize(Output.of(bufferingSize));
        }

        /**
         * @param catalogArn Glue catalog ARN identifier of the destination Apache Iceberg Tables. You must specify the ARN in the format `arn:aws:glue:region:account-id:catalog`
         * 
         * @return builder
         * 
         */
        public Builder catalogArn(Output<String> catalogArn) {
            $.catalogArn = catalogArn;
            return this;
        }

        /**
         * @param catalogArn Glue catalog ARN identifier of the destination Apache Iceberg Tables. You must specify the ARN in the format `arn:aws:glue:region:account-id:catalog`
         * 
         * @return builder
         * 
         */
        public Builder catalogArn(String catalogArn) {
            return catalogArn(Output.of(catalogArn));
        }

        /**
         * @param cloudwatchLoggingOptions The CloudWatch Logging Options for the delivery stream. See `cloudwatch_logging_options` block below for details.
         * 
         * @return builder
         * 
         */
        public Builder cloudwatchLoggingOptions(@Nullable Output<FirehoseDeliveryStreamIcebergConfigurationCloudwatchLoggingOptionsArgs> cloudwatchLoggingOptions) {
            $.cloudwatchLoggingOptions = cloudwatchLoggingOptions;
            return this;
        }

        /**
         * @param cloudwatchLoggingOptions The CloudWatch Logging Options for the delivery stream. See `cloudwatch_logging_options` block below for details.
         * 
         * @return builder
         * 
         */
        public Builder cloudwatchLoggingOptions(FirehoseDeliveryStreamIcebergConfigurationCloudwatchLoggingOptionsArgs cloudwatchLoggingOptions) {
            return cloudwatchLoggingOptions(Output.of(cloudwatchLoggingOptions));
        }

        /**
         * @param destinationTableConfigurations Destination table configurations which Firehose uses to deliver data to Apache Iceberg Tables. Firehose will write data with insert if table specific configuration is not provided. See `destination_table_configuration` block below for details.
         * 
         * @return builder
         * 
         */
        public Builder destinationTableConfigurations(@Nullable Output<List<FirehoseDeliveryStreamIcebergConfigurationDestinationTableConfigurationArgs>> destinationTableConfigurations) {
            $.destinationTableConfigurations = destinationTableConfigurations;
            return this;
        }

        /**
         * @param destinationTableConfigurations Destination table configurations which Firehose uses to deliver data to Apache Iceberg Tables. Firehose will write data with insert if table specific configuration is not provided. See `destination_table_configuration` block below for details.
         * 
         * @return builder
         * 
         */
        public Builder destinationTableConfigurations(List<FirehoseDeliveryStreamIcebergConfigurationDestinationTableConfigurationArgs> destinationTableConfigurations) {
            return destinationTableConfigurations(Output.of(destinationTableConfigurations));
        }

        /**
         * @param destinationTableConfigurations Destination table configurations which Firehose uses to deliver data to Apache Iceberg Tables. Firehose will write data with insert if table specific configuration is not provided. See `destination_table_configuration` block below for details.
         * 
         * @return builder
         * 
         */
        public Builder destinationTableConfigurations(FirehoseDeliveryStreamIcebergConfigurationDestinationTableConfigurationArgs... destinationTableConfigurations) {
            return destinationTableConfigurations(List.of(destinationTableConfigurations));
        }

        /**
         * @param processingConfiguration The data processing configuration.  See `processing_configuration` block below for details.
         * 
         * @return builder
         * 
         */
        public Builder processingConfiguration(@Nullable Output<FirehoseDeliveryStreamIcebergConfigurationProcessingConfigurationArgs> processingConfiguration) {
            $.processingConfiguration = processingConfiguration;
            return this;
        }

        /**
         * @param processingConfiguration The data processing configuration.  See `processing_configuration` block below for details.
         * 
         * @return builder
         * 
         */
        public Builder processingConfiguration(FirehoseDeliveryStreamIcebergConfigurationProcessingConfigurationArgs processingConfiguration) {
            return processingConfiguration(Output.of(processingConfiguration));
        }

        /**
         * @param retryDuration The period of time, in seconds between 0 to 7200, during which Firehose retries to deliver data to the specified destination.
         * 
         * @return builder
         * 
         */
        public Builder retryDuration(@Nullable Output<Integer> retryDuration) {
            $.retryDuration = retryDuration;
            return this;
        }

        /**
         * @param retryDuration The period of time, in seconds between 0 to 7200, during which Firehose retries to deliver data to the specified destination.
         * 
         * @return builder
         * 
         */
        public Builder retryDuration(Integer retryDuration) {
            return retryDuration(Output.of(retryDuration));
        }

        /**
         * @param roleArn The ARN of the IAM role to be assumed by Firehose for calling Apache Iceberg Tables.
         * 
         * @return builder
         * 
         */
        public Builder roleArn(Output<String> roleArn) {
            $.roleArn = roleArn;
            return this;
        }

        /**
         * @param roleArn The ARN of the IAM role to be assumed by Firehose for calling Apache Iceberg Tables.
         * 
         * @return builder
         * 
         */
        public Builder roleArn(String roleArn) {
            return roleArn(Output.of(roleArn));
        }

        public Builder s3BackupMode(@Nullable Output<String> s3BackupMode) {
            $.s3BackupMode = s3BackupMode;
            return this;
        }

        public Builder s3BackupMode(String s3BackupMode) {
            return s3BackupMode(Output.of(s3BackupMode));
        }

        /**
         * @param s3Configuration The S3 Configuration. See `s3_configuration` block below for details.
         * 
         * @return builder
         * 
         */
        public Builder s3Configuration(Output<FirehoseDeliveryStreamIcebergConfigurationS3ConfigurationArgs> s3Configuration) {
            $.s3Configuration = s3Configuration;
            return this;
        }

        /**
         * @param s3Configuration The S3 Configuration. See `s3_configuration` block below for details.
         * 
         * @return builder
         * 
         */
        public Builder s3Configuration(FirehoseDeliveryStreamIcebergConfigurationS3ConfigurationArgs s3Configuration) {
            return s3Configuration(Output.of(s3Configuration));
        }

        public FirehoseDeliveryStreamIcebergConfigurationArgs build() {
            if ($.catalogArn == null) {
                throw new MissingRequiredPropertyException("FirehoseDeliveryStreamIcebergConfigurationArgs", "catalogArn");
            }
            if ($.roleArn == null) {
                throw new MissingRequiredPropertyException("FirehoseDeliveryStreamIcebergConfigurationArgs", "roleArn");
            }
            if ($.s3Configuration == null) {
                throw new MissingRequiredPropertyException("FirehoseDeliveryStreamIcebergConfigurationArgs", "s3Configuration");
            }
            return $;
        }
    }

}
