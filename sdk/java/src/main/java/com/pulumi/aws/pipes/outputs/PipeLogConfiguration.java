// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.pipes.outputs;

import com.pulumi.aws.pipes.outputs.PipeLogConfigurationCloudwatchLogsLogDestination;
import com.pulumi.aws.pipes.outputs.PipeLogConfigurationFirehoseLogDestination;
import com.pulumi.aws.pipes.outputs.PipeLogConfigurationS3LogDestination;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class PipeLogConfiguration {
    /**
     * @return Amazon CloudWatch Logs logging configuration settings for the pipe. Detailed below.
     * 
     */
    private @Nullable PipeLogConfigurationCloudwatchLogsLogDestination cloudwatchLogsLogDestination;
    /**
     * @return Amazon Kinesis Data Firehose logging configuration settings for the pipe. Detailed below.
     * 
     */
    private @Nullable PipeLogConfigurationFirehoseLogDestination firehoseLogDestination;
    /**
     * @return String list that specifies whether the execution data (specifically, the `payload`, `awsRequest`, and `awsResponse` fields) is included in the log messages for this pipe. This applies to all log destinations for the pipe. Valid values `ALL`.
     * 
     */
    private @Nullable List<String> includeExecutionDatas;
    /**
     * @return The level of logging detail to include. Valid values `OFF`, `ERROR`, `INFO` and `TRACE`.
     * 
     */
    private String level;
    /**
     * @return Amazon S3 logging configuration settings for the pipe. Detailed below.
     * 
     */
    private @Nullable PipeLogConfigurationS3LogDestination s3LogDestination;

    private PipeLogConfiguration() {}
    /**
     * @return Amazon CloudWatch Logs logging configuration settings for the pipe. Detailed below.
     * 
     */
    public Optional<PipeLogConfigurationCloudwatchLogsLogDestination> cloudwatchLogsLogDestination() {
        return Optional.ofNullable(this.cloudwatchLogsLogDestination);
    }
    /**
     * @return Amazon Kinesis Data Firehose logging configuration settings for the pipe. Detailed below.
     * 
     */
    public Optional<PipeLogConfigurationFirehoseLogDestination> firehoseLogDestination() {
        return Optional.ofNullable(this.firehoseLogDestination);
    }
    /**
     * @return String list that specifies whether the execution data (specifically, the `payload`, `awsRequest`, and `awsResponse` fields) is included in the log messages for this pipe. This applies to all log destinations for the pipe. Valid values `ALL`.
     * 
     */
    public List<String> includeExecutionDatas() {
        return this.includeExecutionDatas == null ? List.of() : this.includeExecutionDatas;
    }
    /**
     * @return The level of logging detail to include. Valid values `OFF`, `ERROR`, `INFO` and `TRACE`.
     * 
     */
    public String level() {
        return this.level;
    }
    /**
     * @return Amazon S3 logging configuration settings for the pipe. Detailed below.
     * 
     */
    public Optional<PipeLogConfigurationS3LogDestination> s3LogDestination() {
        return Optional.ofNullable(this.s3LogDestination);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(PipeLogConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable PipeLogConfigurationCloudwatchLogsLogDestination cloudwatchLogsLogDestination;
        private @Nullable PipeLogConfigurationFirehoseLogDestination firehoseLogDestination;
        private @Nullable List<String> includeExecutionDatas;
        private String level;
        private @Nullable PipeLogConfigurationS3LogDestination s3LogDestination;
        public Builder() {}
        public Builder(PipeLogConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.cloudwatchLogsLogDestination = defaults.cloudwatchLogsLogDestination;
    	      this.firehoseLogDestination = defaults.firehoseLogDestination;
    	      this.includeExecutionDatas = defaults.includeExecutionDatas;
    	      this.level = defaults.level;
    	      this.s3LogDestination = defaults.s3LogDestination;
        }

        @CustomType.Setter
        public Builder cloudwatchLogsLogDestination(@Nullable PipeLogConfigurationCloudwatchLogsLogDestination cloudwatchLogsLogDestination) {

            this.cloudwatchLogsLogDestination = cloudwatchLogsLogDestination;
            return this;
        }
        @CustomType.Setter
        public Builder firehoseLogDestination(@Nullable PipeLogConfigurationFirehoseLogDestination firehoseLogDestination) {

            this.firehoseLogDestination = firehoseLogDestination;
            return this;
        }
        @CustomType.Setter
        public Builder includeExecutionDatas(@Nullable List<String> includeExecutionDatas) {

            this.includeExecutionDatas = includeExecutionDatas;
            return this;
        }
        public Builder includeExecutionDatas(String... includeExecutionDatas) {
            return includeExecutionDatas(List.of(includeExecutionDatas));
        }
        @CustomType.Setter
        public Builder level(String level) {
            if (level == null) {
              throw new MissingRequiredPropertyException("PipeLogConfiguration", "level");
            }
            this.level = level;
            return this;
        }
        @CustomType.Setter
        public Builder s3LogDestination(@Nullable PipeLogConfigurationS3LogDestination s3LogDestination) {

            this.s3LogDestination = s3LogDestination;
            return this;
        }
        public PipeLogConfiguration build() {
            final var _resultValue = new PipeLogConfiguration();
            _resultValue.cloudwatchLogsLogDestination = cloudwatchLogsLogDestination;
            _resultValue.firehoseLogDestination = firehoseLogDestination;
            _resultValue.includeExecutionDatas = includeExecutionDatas;
            _resultValue.level = level;
            _resultValue.s3LogDestination = s3LogDestination;
            return _resultValue;
        }
    }
}
