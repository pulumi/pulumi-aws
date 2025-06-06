// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.networkfirewall.outputs;

import com.pulumi.aws.networkfirewall.outputs.GetFirewallPolicyFirewallPolicyStatelessCustomActionActionDefinitionPublishMetricActionDimension;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetFirewallPolicyFirewallPolicyStatelessCustomActionActionDefinitionPublishMetricAction {
    private List<GetFirewallPolicyFirewallPolicyStatelessCustomActionActionDefinitionPublishMetricActionDimension> dimensions;

    private GetFirewallPolicyFirewallPolicyStatelessCustomActionActionDefinitionPublishMetricAction() {}
    public List<GetFirewallPolicyFirewallPolicyStatelessCustomActionActionDefinitionPublishMetricActionDimension> dimensions() {
        return this.dimensions;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetFirewallPolicyFirewallPolicyStatelessCustomActionActionDefinitionPublishMetricAction defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetFirewallPolicyFirewallPolicyStatelessCustomActionActionDefinitionPublishMetricActionDimension> dimensions;
        public Builder() {}
        public Builder(GetFirewallPolicyFirewallPolicyStatelessCustomActionActionDefinitionPublishMetricAction defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.dimensions = defaults.dimensions;
        }

        @CustomType.Setter
        public Builder dimensions(List<GetFirewallPolicyFirewallPolicyStatelessCustomActionActionDefinitionPublishMetricActionDimension> dimensions) {
            if (dimensions == null) {
              throw new MissingRequiredPropertyException("GetFirewallPolicyFirewallPolicyStatelessCustomActionActionDefinitionPublishMetricAction", "dimensions");
            }
            this.dimensions = dimensions;
            return this;
        }
        public Builder dimensions(GetFirewallPolicyFirewallPolicyStatelessCustomActionActionDefinitionPublishMetricActionDimension... dimensions) {
            return dimensions(List.of(dimensions));
        }
        public GetFirewallPolicyFirewallPolicyStatelessCustomActionActionDefinitionPublishMetricAction build() {
            final var _resultValue = new GetFirewallPolicyFirewallPolicyStatelessCustomActionActionDefinitionPublishMetricAction();
            _resultValue.dimensions = dimensions;
            return _resultValue;
        }
    }
}
