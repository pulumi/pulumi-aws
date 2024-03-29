// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.securitylake.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class SubscriberSourceCustomLogSourceResourceProvider {
    /**
     * @return The location of the partition in the Amazon S3 bucket for Security Lake.
     * 
     */
    private String location;
    /**
     * @return The ARN of the IAM role to be used by the entity putting logs into your custom source partition.
     * 
     */
    private String roleArn;

    private SubscriberSourceCustomLogSourceResourceProvider() {}
    /**
     * @return The location of the partition in the Amazon S3 bucket for Security Lake.
     * 
     */
    public String location() {
        return this.location;
    }
    /**
     * @return The ARN of the IAM role to be used by the entity putting logs into your custom source partition.
     * 
     */
    public String roleArn() {
        return this.roleArn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(SubscriberSourceCustomLogSourceResourceProvider defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String location;
        private String roleArn;
        public Builder() {}
        public Builder(SubscriberSourceCustomLogSourceResourceProvider defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.location = defaults.location;
    	      this.roleArn = defaults.roleArn;
        }

        @CustomType.Setter
        public Builder location(String location) {
            if (location == null) {
              throw new MissingRequiredPropertyException("SubscriberSourceCustomLogSourceResourceProvider", "location");
            }
            this.location = location;
            return this;
        }
        @CustomType.Setter
        public Builder roleArn(String roleArn) {
            if (roleArn == null) {
              throw new MissingRequiredPropertyException("SubscriberSourceCustomLogSourceResourceProvider", "roleArn");
            }
            this.roleArn = roleArn;
            return this;
        }
        public SubscriberSourceCustomLogSourceResourceProvider build() {
            final var _resultValue = new SubscriberSourceCustomLogSourceResourceProvider();
            _resultValue.location = location;
            _resultValue.roleArn = roleArn;
            return _resultValue;
        }
    }
}
