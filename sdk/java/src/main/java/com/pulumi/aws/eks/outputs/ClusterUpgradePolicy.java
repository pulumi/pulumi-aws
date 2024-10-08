// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.eks.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ClusterUpgradePolicy {
    /**
     * @return Support type to use for the cluster. If the cluster is set to `EXTENDED`, it will enter extended support at the end of standard support. If the cluster is set to `STANDARD`, it will be automatically upgraded at the end of standard support. Valid values are `EXTENDED`, `STANDARD`
     * 
     */
    private @Nullable String supportType;

    private ClusterUpgradePolicy() {}
    /**
     * @return Support type to use for the cluster. If the cluster is set to `EXTENDED`, it will enter extended support at the end of standard support. If the cluster is set to `STANDARD`, it will be automatically upgraded at the end of standard support. Valid values are `EXTENDED`, `STANDARD`
     * 
     */
    public Optional<String> supportType() {
        return Optional.ofNullable(this.supportType);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ClusterUpgradePolicy defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String supportType;
        public Builder() {}
        public Builder(ClusterUpgradePolicy defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.supportType = defaults.supportType;
        }

        @CustomType.Setter
        public Builder supportType(@Nullable String supportType) {

            this.supportType = supportType;
            return this;
        }
        public ClusterUpgradePolicy build() {
            final var _resultValue = new ClusterUpgradePolicy();
            _resultValue.supportType = supportType;
            return _resultValue;
        }
    }
}
