// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.msk.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.util.Objects;

@CustomType
public final class GetClusterBrokerNodeGroupInfoStorageInfoEbsStorageInfoProvisionedThroughput {
    private Boolean enabled;
    private Integer volumeThroughput;

    private GetClusterBrokerNodeGroupInfoStorageInfoEbsStorageInfoProvisionedThroughput() {}
    public Boolean enabled() {
        return this.enabled;
    }
    public Integer volumeThroughput() {
        return this.volumeThroughput;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetClusterBrokerNodeGroupInfoStorageInfoEbsStorageInfoProvisionedThroughput defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Boolean enabled;
        private Integer volumeThroughput;
        public Builder() {}
        public Builder(GetClusterBrokerNodeGroupInfoStorageInfoEbsStorageInfoProvisionedThroughput defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.enabled = defaults.enabled;
    	      this.volumeThroughput = defaults.volumeThroughput;
        }

        @CustomType.Setter
        public Builder enabled(Boolean enabled) {
            if (enabled == null) {
              throw new MissingRequiredPropertyException("GetClusterBrokerNodeGroupInfoStorageInfoEbsStorageInfoProvisionedThroughput", "enabled");
            }
            this.enabled = enabled;
            return this;
        }
        @CustomType.Setter
        public Builder volumeThroughput(Integer volumeThroughput) {
            if (volumeThroughput == null) {
              throw new MissingRequiredPropertyException("GetClusterBrokerNodeGroupInfoStorageInfoEbsStorageInfoProvisionedThroughput", "volumeThroughput");
            }
            this.volumeThroughput = volumeThroughput;
            return this;
        }
        public GetClusterBrokerNodeGroupInfoStorageInfoEbsStorageInfoProvisionedThroughput build() {
            final var _resultValue = new GetClusterBrokerNodeGroupInfoStorageInfoEbsStorageInfoProvisionedThroughput();
            _resultValue.enabled = enabled;
            _resultValue.volumeThroughput = volumeThroughput;
            return _resultValue;
        }
    }
}
