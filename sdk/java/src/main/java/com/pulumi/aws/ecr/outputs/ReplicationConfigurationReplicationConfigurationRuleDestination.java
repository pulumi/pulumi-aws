// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ecr.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class ReplicationConfigurationReplicationConfigurationRuleDestination {
    /**
     * @return A Region to replicate to.
     * 
     */
    private String region;
    /**
     * @return The account ID of the destination registry to replicate to.
     * 
     */
    private String registryId;

    private ReplicationConfigurationReplicationConfigurationRuleDestination() {}
    /**
     * @return A Region to replicate to.
     * 
     */
    public String region() {
        return this.region;
    }
    /**
     * @return The account ID of the destination registry to replicate to.
     * 
     */
    public String registryId() {
        return this.registryId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ReplicationConfigurationReplicationConfigurationRuleDestination defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String region;
        private String registryId;
        public Builder() {}
        public Builder(ReplicationConfigurationReplicationConfigurationRuleDestination defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.region = defaults.region;
    	      this.registryId = defaults.registryId;
        }

        @CustomType.Setter
        public Builder region(String region) {
            if (region == null) {
              throw new MissingRequiredPropertyException("ReplicationConfigurationReplicationConfigurationRuleDestination", "region");
            }
            this.region = region;
            return this;
        }
        @CustomType.Setter
        public Builder registryId(String registryId) {
            if (registryId == null) {
              throw new MissingRequiredPropertyException("ReplicationConfigurationReplicationConfigurationRuleDestination", "registryId");
            }
            this.registryId = registryId;
            return this;
        }
        public ReplicationConfigurationReplicationConfigurationRuleDestination build() {
            final var _resultValue = new ReplicationConfigurationReplicationConfigurationRuleDestination();
            _resultValue.region = region;
            _resultValue.registryId = registryId;
            return _resultValue;
        }
    }
}
