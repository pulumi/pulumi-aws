// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sesv2.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetConfigurationSetVdmOptionGuardianOption {
    /**
     * @return Specifies the status of your VDM optimized shared delivery.
     * 
     */
    private String optimizedSharedDelivery;

    private GetConfigurationSetVdmOptionGuardianOption() {}
    /**
     * @return Specifies the status of your VDM optimized shared delivery.
     * 
     */
    public String optimizedSharedDelivery() {
        return this.optimizedSharedDelivery;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetConfigurationSetVdmOptionGuardianOption defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String optimizedSharedDelivery;
        public Builder() {}
        public Builder(GetConfigurationSetVdmOptionGuardianOption defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.optimizedSharedDelivery = defaults.optimizedSharedDelivery;
        }

        @CustomType.Setter
        public Builder optimizedSharedDelivery(String optimizedSharedDelivery) {
            this.optimizedSharedDelivery = Objects.requireNonNull(optimizedSharedDelivery);
            return this;
        }
        public GetConfigurationSetVdmOptionGuardianOption build() {
            final var o = new GetConfigurationSetVdmOptionGuardianOption();
            o.optimizedSharedDelivery = optimizedSharedDelivery;
            return o;
        }
    }
}