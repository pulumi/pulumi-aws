// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.backup.outputs;

import com.pulumi.aws.backup.outputs.GetPlanRuleCopyActionLifecycle;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetPlanRuleCopyAction {
    private String destinationVaultArn;
    private List<GetPlanRuleCopyActionLifecycle> lifecycles;

    private GetPlanRuleCopyAction() {}
    public String destinationVaultArn() {
        return this.destinationVaultArn;
    }
    public List<GetPlanRuleCopyActionLifecycle> lifecycles() {
        return this.lifecycles;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetPlanRuleCopyAction defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String destinationVaultArn;
        private List<GetPlanRuleCopyActionLifecycle> lifecycles;
        public Builder() {}
        public Builder(GetPlanRuleCopyAction defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.destinationVaultArn = defaults.destinationVaultArn;
    	      this.lifecycles = defaults.lifecycles;
        }

        @CustomType.Setter
        public Builder destinationVaultArn(String destinationVaultArn) {
            if (destinationVaultArn == null) {
              throw new MissingRequiredPropertyException("GetPlanRuleCopyAction", "destinationVaultArn");
            }
            this.destinationVaultArn = destinationVaultArn;
            return this;
        }
        @CustomType.Setter
        public Builder lifecycles(List<GetPlanRuleCopyActionLifecycle> lifecycles) {
            if (lifecycles == null) {
              throw new MissingRequiredPropertyException("GetPlanRuleCopyAction", "lifecycles");
            }
            this.lifecycles = lifecycles;
            return this;
        }
        public Builder lifecycles(GetPlanRuleCopyActionLifecycle... lifecycles) {
            return lifecycles(List.of(lifecycles));
        }
        public GetPlanRuleCopyAction build() {
            final var _resultValue = new GetPlanRuleCopyAction();
            _resultValue.destinationVaultArn = destinationVaultArn;
            _resultValue.lifecycles = lifecycles;
            return _resultValue;
        }
    }
}
