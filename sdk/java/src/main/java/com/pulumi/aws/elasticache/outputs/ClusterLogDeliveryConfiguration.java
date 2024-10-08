// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.elasticache.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class ClusterLogDeliveryConfiguration {
    /**
     * @return Name of either the CloudWatch Logs LogGroup or Kinesis Data Firehose resource.
     * 
     */
    private String destination;
    /**
     * @return For CloudWatch Logs use `cloudwatch-logs` or for Kinesis Data Firehose use `kinesis-firehose`.
     * 
     */
    private String destinationType;
    /**
     * @return Valid values are `json` or `text`
     * 
     */
    private String logFormat;
    /**
     * @return Valid values are  `slow-log` or `engine-log`. Max 1 of each.
     * 
     */
    private String logType;

    private ClusterLogDeliveryConfiguration() {}
    /**
     * @return Name of either the CloudWatch Logs LogGroup or Kinesis Data Firehose resource.
     * 
     */
    public String destination() {
        return this.destination;
    }
    /**
     * @return For CloudWatch Logs use `cloudwatch-logs` or for Kinesis Data Firehose use `kinesis-firehose`.
     * 
     */
    public String destinationType() {
        return this.destinationType;
    }
    /**
     * @return Valid values are `json` or `text`
     * 
     */
    public String logFormat() {
        return this.logFormat;
    }
    /**
     * @return Valid values are  `slow-log` or `engine-log`. Max 1 of each.
     * 
     */
    public String logType() {
        return this.logType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ClusterLogDeliveryConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String destination;
        private String destinationType;
        private String logFormat;
        private String logType;
        public Builder() {}
        public Builder(ClusterLogDeliveryConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.destination = defaults.destination;
    	      this.destinationType = defaults.destinationType;
    	      this.logFormat = defaults.logFormat;
    	      this.logType = defaults.logType;
        }

        @CustomType.Setter
        public Builder destination(String destination) {
            if (destination == null) {
              throw new MissingRequiredPropertyException("ClusterLogDeliveryConfiguration", "destination");
            }
            this.destination = destination;
            return this;
        }
        @CustomType.Setter
        public Builder destinationType(String destinationType) {
            if (destinationType == null) {
              throw new MissingRequiredPropertyException("ClusterLogDeliveryConfiguration", "destinationType");
            }
            this.destinationType = destinationType;
            return this;
        }
        @CustomType.Setter
        public Builder logFormat(String logFormat) {
            if (logFormat == null) {
              throw new MissingRequiredPropertyException("ClusterLogDeliveryConfiguration", "logFormat");
            }
            this.logFormat = logFormat;
            return this;
        }
        @CustomType.Setter
        public Builder logType(String logType) {
            if (logType == null) {
              throw new MissingRequiredPropertyException("ClusterLogDeliveryConfiguration", "logType");
            }
            this.logType = logType;
            return this;
        }
        public ClusterLogDeliveryConfiguration build() {
            final var _resultValue = new ClusterLogDeliveryConfiguration();
            _resultValue.destination = destination;
            _resultValue.destinationType = destinationType;
            _resultValue.logFormat = logFormat;
            _resultValue.logType = logType;
            return _resultValue;
        }
    }
}
