// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.msk.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.Boolean;
import java.lang.Integer;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ClusterBrokerNodeGroupInfoStorageInfoEbsStorageInfoProvisionedThroughput {
    private @Nullable Boolean enabled;
    private @Nullable Integer volumeThroughput;

    private ClusterBrokerNodeGroupInfoStorageInfoEbsStorageInfoProvisionedThroughput() {}
    public Optional<Boolean> enabled() {
        return Optional.ofNullable(this.enabled);
    }
    public Optional<Integer> volumeThroughput() {
        return Optional.ofNullable(this.volumeThroughput);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ClusterBrokerNodeGroupInfoStorageInfoEbsStorageInfoProvisionedThroughput defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Boolean enabled;
        private @Nullable Integer volumeThroughput;
        public Builder() {}
        public Builder(ClusterBrokerNodeGroupInfoStorageInfoEbsStorageInfoProvisionedThroughput defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.enabled = defaults.enabled;
    	      this.volumeThroughput = defaults.volumeThroughput;
        }

        @CustomType.Setter
        public Builder enabled(@Nullable Boolean enabled) {

            this.enabled = enabled;
            return this;
        }
        @CustomType.Setter
        public Builder volumeThroughput(@Nullable Integer volumeThroughput) {

            this.volumeThroughput = volumeThroughput;
            return this;
        }
        public ClusterBrokerNodeGroupInfoStorageInfoEbsStorageInfoProvisionedThroughput build() {
            final var _resultValue = new ClusterBrokerNodeGroupInfoStorageInfoEbsStorageInfoProvisionedThroughput();
            _resultValue.enabled = enabled;
            _resultValue.volumeThroughput = volumeThroughput;
            return _resultValue;
        }
    }
}
