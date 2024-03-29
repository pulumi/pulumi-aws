// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudfront.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class DistributionDefaultCacheBehaviorFunctionAssociation {
    /**
     * @return Specific event to trigger this function. Valid values: `viewer-request` or `viewer-response`.
     * 
     */
    private String eventType;
    /**
     * @return ARN of the CloudFront function.
     * 
     */
    private String functionArn;

    private DistributionDefaultCacheBehaviorFunctionAssociation() {}
    /**
     * @return Specific event to trigger this function. Valid values: `viewer-request` or `viewer-response`.
     * 
     */
    public String eventType() {
        return this.eventType;
    }
    /**
     * @return ARN of the CloudFront function.
     * 
     */
    public String functionArn() {
        return this.functionArn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(DistributionDefaultCacheBehaviorFunctionAssociation defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String eventType;
        private String functionArn;
        public Builder() {}
        public Builder(DistributionDefaultCacheBehaviorFunctionAssociation defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.eventType = defaults.eventType;
    	      this.functionArn = defaults.functionArn;
        }

        @CustomType.Setter
        public Builder eventType(String eventType) {
            if (eventType == null) {
              throw new MissingRequiredPropertyException("DistributionDefaultCacheBehaviorFunctionAssociation", "eventType");
            }
            this.eventType = eventType;
            return this;
        }
        @CustomType.Setter
        public Builder functionArn(String functionArn) {
            if (functionArn == null) {
              throw new MissingRequiredPropertyException("DistributionDefaultCacheBehaviorFunctionAssociation", "functionArn");
            }
            this.functionArn = functionArn;
            return this;
        }
        public DistributionDefaultCacheBehaviorFunctionAssociation build() {
            final var _resultValue = new DistributionDefaultCacheBehaviorFunctionAssociation();
            _resultValue.eventType = eventType;
            _resultValue.functionArn = functionArn;
            return _resultValue;
        }
    }
}
