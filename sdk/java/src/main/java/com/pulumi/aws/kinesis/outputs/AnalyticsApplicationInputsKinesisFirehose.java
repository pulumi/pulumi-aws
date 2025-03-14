// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.kinesis.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class AnalyticsApplicationInputsKinesisFirehose {
    /**
     * @return The ARN of the Kinesis Firehose delivery stream.
     * 
     */
    private String resourceArn;
    /**
     * @return The ARN of the IAM Role used to access the stream.
     * 
     */
    private String roleArn;

    private AnalyticsApplicationInputsKinesisFirehose() {}
    /**
     * @return The ARN of the Kinesis Firehose delivery stream.
     * 
     */
    public String resourceArn() {
        return this.resourceArn;
    }
    /**
     * @return The ARN of the IAM Role used to access the stream.
     * 
     */
    public String roleArn() {
        return this.roleArn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(AnalyticsApplicationInputsKinesisFirehose defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String resourceArn;
        private String roleArn;
        public Builder() {}
        public Builder(AnalyticsApplicationInputsKinesisFirehose defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.resourceArn = defaults.resourceArn;
    	      this.roleArn = defaults.roleArn;
        }

        @CustomType.Setter
        public Builder resourceArn(String resourceArn) {
            if (resourceArn == null) {
              throw new MissingRequiredPropertyException("AnalyticsApplicationInputsKinesisFirehose", "resourceArn");
            }
            this.resourceArn = resourceArn;
            return this;
        }
        @CustomType.Setter
        public Builder roleArn(String roleArn) {
            if (roleArn == null) {
              throw new MissingRequiredPropertyException("AnalyticsApplicationInputsKinesisFirehose", "roleArn");
            }
            this.roleArn = roleArn;
            return this;
        }
        public AnalyticsApplicationInputsKinesisFirehose build() {
            final var _resultValue = new AnalyticsApplicationInputsKinesisFirehose();
            _resultValue.resourceArn = resourceArn;
            _resultValue.roleArn = roleArn;
            return _resultValue;
        }
    }
}
