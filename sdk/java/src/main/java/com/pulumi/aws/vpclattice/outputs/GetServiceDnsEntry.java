// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.vpclattice.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetServiceDnsEntry {
    /**
     * @return DNS name for the service.
     * 
     */
    private String domainName;
    /**
     * @return Hosted zone ID where the DNS name is registered.
     * 
     */
    private String hostedZoneId;

    private GetServiceDnsEntry() {}
    /**
     * @return DNS name for the service.
     * 
     */
    public String domainName() {
        return this.domainName;
    }
    /**
     * @return Hosted zone ID where the DNS name is registered.
     * 
     */
    public String hostedZoneId() {
        return this.hostedZoneId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetServiceDnsEntry defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String domainName;
        private String hostedZoneId;
        public Builder() {}
        public Builder(GetServiceDnsEntry defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.domainName = defaults.domainName;
    	      this.hostedZoneId = defaults.hostedZoneId;
        }

        @CustomType.Setter
        public Builder domainName(String domainName) {
            if (domainName == null) {
              throw new MissingRequiredPropertyException("GetServiceDnsEntry", "domainName");
            }
            this.domainName = domainName;
            return this;
        }
        @CustomType.Setter
        public Builder hostedZoneId(String hostedZoneId) {
            if (hostedZoneId == null) {
              throw new MissingRequiredPropertyException("GetServiceDnsEntry", "hostedZoneId");
            }
            this.hostedZoneId = hostedZoneId;
            return this;
        }
        public GetServiceDnsEntry build() {
            final var _resultValue = new GetServiceDnsEntry();
            _resultValue.domainName = domainName;
            _resultValue.hostedZoneId = hostedZoneId;
            return _resultValue;
        }
    }
}
