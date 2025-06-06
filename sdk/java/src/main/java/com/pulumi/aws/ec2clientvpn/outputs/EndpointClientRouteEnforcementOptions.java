// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2clientvpn.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.Boolean;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class EndpointClientRouteEnforcementOptions {
    /**
     * @return Enable or disable Client Route Enforcement. The default is `false` (not enabled).
     * 
     */
    private @Nullable Boolean enforced;

    private EndpointClientRouteEnforcementOptions() {}
    /**
     * @return Enable or disable Client Route Enforcement. The default is `false` (not enabled).
     * 
     */
    public Optional<Boolean> enforced() {
        return Optional.ofNullable(this.enforced);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(EndpointClientRouteEnforcementOptions defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Boolean enforced;
        public Builder() {}
        public Builder(EndpointClientRouteEnforcementOptions defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.enforced = defaults.enforced;
        }

        @CustomType.Setter
        public Builder enforced(@Nullable Boolean enforced) {

            this.enforced = enforced;
            return this;
        }
        public EndpointClientRouteEnforcementOptions build() {
            final var _resultValue = new EndpointClientRouteEnforcementOptions();
            _resultValue.enforced = enforced;
            return _resultValue;
        }
    }
}
