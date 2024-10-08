// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.outputs;

import com.pulumi.aws.ec2.outputs.GetNetworkInsightsAnalysisReturnPathComponentAdditionalDetailComponent;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetNetworkInsightsAnalysisReturnPathComponentAdditionalDetail {
    private String additionalDetailType;
    private List<GetNetworkInsightsAnalysisReturnPathComponentAdditionalDetailComponent> components;

    private GetNetworkInsightsAnalysisReturnPathComponentAdditionalDetail() {}
    public String additionalDetailType() {
        return this.additionalDetailType;
    }
    public List<GetNetworkInsightsAnalysisReturnPathComponentAdditionalDetailComponent> components() {
        return this.components;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetNetworkInsightsAnalysisReturnPathComponentAdditionalDetail defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String additionalDetailType;
        private List<GetNetworkInsightsAnalysisReturnPathComponentAdditionalDetailComponent> components;
        public Builder() {}
        public Builder(GetNetworkInsightsAnalysisReturnPathComponentAdditionalDetail defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.additionalDetailType = defaults.additionalDetailType;
    	      this.components = defaults.components;
        }

        @CustomType.Setter
        public Builder additionalDetailType(String additionalDetailType) {
            if (additionalDetailType == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisReturnPathComponentAdditionalDetail", "additionalDetailType");
            }
            this.additionalDetailType = additionalDetailType;
            return this;
        }
        @CustomType.Setter
        public Builder components(List<GetNetworkInsightsAnalysisReturnPathComponentAdditionalDetailComponent> components) {
            if (components == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisReturnPathComponentAdditionalDetail", "components");
            }
            this.components = components;
            return this;
        }
        public Builder components(GetNetworkInsightsAnalysisReturnPathComponentAdditionalDetailComponent... components) {
            return components(List.of(components));
        }
        public GetNetworkInsightsAnalysisReturnPathComponentAdditionalDetail build() {
            final var _resultValue = new GetNetworkInsightsAnalysisReturnPathComponentAdditionalDetail();
            _resultValue.additionalDetailType = additionalDetailType;
            _resultValue.components = components;
            return _resultValue;
        }
    }
}
