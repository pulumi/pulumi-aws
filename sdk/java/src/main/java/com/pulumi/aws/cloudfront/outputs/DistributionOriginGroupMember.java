// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudfront.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class DistributionOriginGroupMember {
    private String originId;

    private DistributionOriginGroupMember() {}
    public String originId() {
        return this.originId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(DistributionOriginGroupMember defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String originId;
        public Builder() {}
        public Builder(DistributionOriginGroupMember defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.originId = defaults.originId;
        }

        @CustomType.Setter
        public Builder originId(String originId) {
            if (originId == null) {
              throw new MissingRequiredPropertyException("DistributionOriginGroupMember", "originId");
            }
            this.originId = originId;
            return this;
        }
        public DistributionOriginGroupMember build() {
            final var _resultValue = new DistributionOriginGroupMember();
            _resultValue.originId = originId;
            return _resultValue;
        }
    }
}
