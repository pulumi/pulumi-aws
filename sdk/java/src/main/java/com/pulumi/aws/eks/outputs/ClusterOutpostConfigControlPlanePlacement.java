// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.eks.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class ClusterOutpostConfigControlPlanePlacement {
    /**
     * @return The name of the placement group for the Kubernetes control plane instances. This setting can&#39;t be changed after cluster creation.
     * 
     */
    private String groupName;

    private ClusterOutpostConfigControlPlanePlacement() {}
    /**
     * @return The name of the placement group for the Kubernetes control plane instances. This setting can&#39;t be changed after cluster creation.
     * 
     */
    public String groupName() {
        return this.groupName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ClusterOutpostConfigControlPlanePlacement defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String groupName;
        public Builder() {}
        public Builder(ClusterOutpostConfigControlPlanePlacement defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.groupName = defaults.groupName;
        }

        @CustomType.Setter
        public Builder groupName(String groupName) {
            if (groupName == null) {
              throw new MissingRequiredPropertyException("ClusterOutpostConfigControlPlanePlacement", "groupName");
            }
            this.groupName = groupName;
            return this;
        }
        public ClusterOutpostConfigControlPlanePlacement build() {
            final var _resultValue = new ClusterOutpostConfigControlPlanePlacement();
            _resultValue.groupName = groupName;
            return _resultValue;
        }
    }
}
