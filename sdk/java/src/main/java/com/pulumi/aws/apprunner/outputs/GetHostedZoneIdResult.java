// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.apprunner.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetHostedZoneIdResult {
    /**
     * @return ID of the AWS App Runner service HostedZoneId in the selected region.
     * 
     */
    private String id;
    private String region;

    private GetHostedZoneIdResult() {}
    /**
     * @return ID of the AWS App Runner service HostedZoneId in the selected region.
     * 
     */
    public String id() {
        return this.id;
    }
    public String region() {
        return this.region;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetHostedZoneIdResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String id;
        private String region;
        public Builder() {}
        public Builder(GetHostedZoneIdResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.id = defaults.id;
    	      this.region = defaults.region;
        }

        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetHostedZoneIdResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder region(String region) {
            if (region == null) {
              throw new MissingRequiredPropertyException("GetHostedZoneIdResult", "region");
            }
            this.region = region;
            return this;
        }
        public GetHostedZoneIdResult build() {
            final var _resultValue = new GetHostedZoneIdResult();
            _resultValue.id = id;
            _resultValue.region = region;
            return _resultValue;
        }
    }
}
