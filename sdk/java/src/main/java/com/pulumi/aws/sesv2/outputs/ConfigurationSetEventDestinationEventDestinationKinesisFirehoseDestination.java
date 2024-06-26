// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sesv2.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class ConfigurationSetEventDestinationEventDestinationKinesisFirehoseDestination {
    /**
     * @return The Amazon Resource Name (ARN) of the Amazon Kinesis Data Firehose stream that the Amazon SES API v2 sends email events to.
     * 
     */
    private String deliveryStreamArn;
    /**
     * @return The Amazon Resource Name (ARN) of the IAM role that the Amazon SES API v2 uses to send email events to the Amazon Kinesis Data Firehose stream.
     * 
     */
    private String iamRoleArn;

    private ConfigurationSetEventDestinationEventDestinationKinesisFirehoseDestination() {}
    /**
     * @return The Amazon Resource Name (ARN) of the Amazon Kinesis Data Firehose stream that the Amazon SES API v2 sends email events to.
     * 
     */
    public String deliveryStreamArn() {
        return this.deliveryStreamArn;
    }
    /**
     * @return The Amazon Resource Name (ARN) of the IAM role that the Amazon SES API v2 uses to send email events to the Amazon Kinesis Data Firehose stream.
     * 
     */
    public String iamRoleArn() {
        return this.iamRoleArn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ConfigurationSetEventDestinationEventDestinationKinesisFirehoseDestination defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String deliveryStreamArn;
        private String iamRoleArn;
        public Builder() {}
        public Builder(ConfigurationSetEventDestinationEventDestinationKinesisFirehoseDestination defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.deliveryStreamArn = defaults.deliveryStreamArn;
    	      this.iamRoleArn = defaults.iamRoleArn;
        }

        @CustomType.Setter
        public Builder deliveryStreamArn(String deliveryStreamArn) {
            if (deliveryStreamArn == null) {
              throw new MissingRequiredPropertyException("ConfigurationSetEventDestinationEventDestinationKinesisFirehoseDestination", "deliveryStreamArn");
            }
            this.deliveryStreamArn = deliveryStreamArn;
            return this;
        }
        @CustomType.Setter
        public Builder iamRoleArn(String iamRoleArn) {
            if (iamRoleArn == null) {
              throw new MissingRequiredPropertyException("ConfigurationSetEventDestinationEventDestinationKinesisFirehoseDestination", "iamRoleArn");
            }
            this.iamRoleArn = iamRoleArn;
            return this;
        }
        public ConfigurationSetEventDestinationEventDestinationKinesisFirehoseDestination build() {
            final var _resultValue = new ConfigurationSetEventDestinationEventDestinationKinesisFirehoseDestination();
            _resultValue.deliveryStreamArn = deliveryStreamArn;
            _resultValue.iamRoleArn = iamRoleArn;
            return _resultValue;
        }
    }
}
