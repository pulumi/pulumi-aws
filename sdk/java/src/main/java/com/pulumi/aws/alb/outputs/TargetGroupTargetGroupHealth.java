// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.alb.outputs;

import com.pulumi.aws.alb.outputs.TargetGroupTargetGroupHealthDnsFailover;
import com.pulumi.aws.alb.outputs.TargetGroupTargetGroupHealthUnhealthyStateRouting;
import com.pulumi.core.annotations.CustomType;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class TargetGroupTargetGroupHealth {
    /**
     * @return Block to configure DNS Failover requirements. See DNS Failover below for details on attributes.
     * 
     */
    private @Nullable TargetGroupTargetGroupHealthDnsFailover dnsFailover;
    /**
     * @return Block to configure Unhealthy State Routing requirements. See Unhealthy State Routing below for details on attributes.
     * 
     */
    private @Nullable TargetGroupTargetGroupHealthUnhealthyStateRouting unhealthyStateRouting;

    private TargetGroupTargetGroupHealth() {}
    /**
     * @return Block to configure DNS Failover requirements. See DNS Failover below for details on attributes.
     * 
     */
    public Optional<TargetGroupTargetGroupHealthDnsFailover> dnsFailover() {
        return Optional.ofNullable(this.dnsFailover);
    }
    /**
     * @return Block to configure Unhealthy State Routing requirements. See Unhealthy State Routing below for details on attributes.
     * 
     */
    public Optional<TargetGroupTargetGroupHealthUnhealthyStateRouting> unhealthyStateRouting() {
        return Optional.ofNullable(this.unhealthyStateRouting);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(TargetGroupTargetGroupHealth defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable TargetGroupTargetGroupHealthDnsFailover dnsFailover;
        private @Nullable TargetGroupTargetGroupHealthUnhealthyStateRouting unhealthyStateRouting;
        public Builder() {}
        public Builder(TargetGroupTargetGroupHealth defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.dnsFailover = defaults.dnsFailover;
    	      this.unhealthyStateRouting = defaults.unhealthyStateRouting;
        }

        @CustomType.Setter
        public Builder dnsFailover(@Nullable TargetGroupTargetGroupHealthDnsFailover dnsFailover) {

            this.dnsFailover = dnsFailover;
            return this;
        }
        @CustomType.Setter
        public Builder unhealthyStateRouting(@Nullable TargetGroupTargetGroupHealthUnhealthyStateRouting unhealthyStateRouting) {

            this.unhealthyStateRouting = unhealthyStateRouting;
            return this;
        }
        public TargetGroupTargetGroupHealth build() {
            final var _resultValue = new TargetGroupTargetGroupHealth();
            _resultValue.dnsFailover = dnsFailover;
            _resultValue.unhealthyStateRouting = unhealthyStateRouting;
            return _resultValue;
        }
    }
}
