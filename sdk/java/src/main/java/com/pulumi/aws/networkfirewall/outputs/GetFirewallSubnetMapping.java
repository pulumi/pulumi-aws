// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.networkfirewall.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetFirewallSubnetMapping {
    /**
     * @return The unique identifier for the subnet.
     * 
     */
    private String subnetId;

    private GetFirewallSubnetMapping() {}
    /**
     * @return The unique identifier for the subnet.
     * 
     */
    public String subnetId() {
        return this.subnetId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetFirewallSubnetMapping defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String subnetId;
        public Builder() {}
        public Builder(GetFirewallSubnetMapping defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.subnetId = defaults.subnetId;
        }

        @CustomType.Setter
        public Builder subnetId(String subnetId) {
            if (subnetId == null) {
              throw new MissingRequiredPropertyException("GetFirewallSubnetMapping", "subnetId");
            }
            this.subnetId = subnetId;
            return this;
        }
        public GetFirewallSubnetMapping build() {
            final var _resultValue = new GetFirewallSubnetMapping();
            _resultValue.subnetId = subnetId;
            return _resultValue;
        }
    }
}
