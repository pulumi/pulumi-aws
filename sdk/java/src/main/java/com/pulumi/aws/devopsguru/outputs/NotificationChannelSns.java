// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.devopsguru.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class NotificationChannelSns {
    /**
     * @return Amazon Resource Name (ARN) of an Amazon Simple Notification Service topic.
     * 
     */
    private String topicArn;

    private NotificationChannelSns() {}
    /**
     * @return Amazon Resource Name (ARN) of an Amazon Simple Notification Service topic.
     * 
     */
    public String topicArn() {
        return this.topicArn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(NotificationChannelSns defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String topicArn;
        public Builder() {}
        public Builder(NotificationChannelSns defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.topicArn = defaults.topicArn;
        }

        @CustomType.Setter
        public Builder topicArn(String topicArn) {
            if (topicArn == null) {
              throw new MissingRequiredPropertyException("NotificationChannelSns", "topicArn");
            }
            this.topicArn = topicArn;
            return this;
        }
        public NotificationChannelSns build() {
            final var _resultValue = new NotificationChannelSns();
            _resultValue.topicArn = topicArn;
            return _resultValue;
        }
    }
}
