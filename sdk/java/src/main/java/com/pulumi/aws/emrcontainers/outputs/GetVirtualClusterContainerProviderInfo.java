// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.emrcontainers.outputs;

import com.pulumi.aws.emrcontainers.outputs.GetVirtualClusterContainerProviderInfoEksInfo;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetVirtualClusterContainerProviderInfo {
    /**
     * @return Nested list containing EKS-specific information about the cluster where the EMR Containers cluster is running
     * 
     */
    private List<GetVirtualClusterContainerProviderInfoEksInfo> eksInfos;

    private GetVirtualClusterContainerProviderInfo() {}
    /**
     * @return Nested list containing EKS-specific information about the cluster where the EMR Containers cluster is running
     * 
     */
    public List<GetVirtualClusterContainerProviderInfoEksInfo> eksInfos() {
        return this.eksInfos;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetVirtualClusterContainerProviderInfo defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetVirtualClusterContainerProviderInfoEksInfo> eksInfos;
        public Builder() {}
        public Builder(GetVirtualClusterContainerProviderInfo defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.eksInfos = defaults.eksInfos;
        }

        @CustomType.Setter
        public Builder eksInfos(List<GetVirtualClusterContainerProviderInfoEksInfo> eksInfos) {
            if (eksInfos == null) {
              throw new MissingRequiredPropertyException("GetVirtualClusterContainerProviderInfo", "eksInfos");
            }
            this.eksInfos = eksInfos;
            return this;
        }
        public Builder eksInfos(GetVirtualClusterContainerProviderInfoEksInfo... eksInfos) {
            return eksInfos(List.of(eksInfos));
        }
        public GetVirtualClusterContainerProviderInfo build() {
            final var _resultValue = new GetVirtualClusterContainerProviderInfo();
            _resultValue.eksInfos = eksInfos;
            return _resultValue;
        }
    }
}
