// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.vpclattice.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetListenerDefaultActionForwardTargetGroup {
    private String targetGroupIdentifier;
    private Integer weight;

    private GetListenerDefaultActionForwardTargetGroup() {}
    public String targetGroupIdentifier() {
        return this.targetGroupIdentifier;
    }
    public Integer weight() {
        return this.weight;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetListenerDefaultActionForwardTargetGroup defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String targetGroupIdentifier;
        private Integer weight;
        public Builder() {}
        public Builder(GetListenerDefaultActionForwardTargetGroup defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.targetGroupIdentifier = defaults.targetGroupIdentifier;
    	      this.weight = defaults.weight;
        }

        @CustomType.Setter
        public Builder targetGroupIdentifier(String targetGroupIdentifier) {
            this.targetGroupIdentifier = Objects.requireNonNull(targetGroupIdentifier);
            return this;
        }
        @CustomType.Setter
        public Builder weight(Integer weight) {
            this.weight = Objects.requireNonNull(weight);
            return this;
        }
        public GetListenerDefaultActionForwardTargetGroup build() {
            final var o = new GetListenerDefaultActionForwardTargetGroup();
            o.targetGroupIdentifier = targetGroupIdentifier;
            o.weight = weight;
            return o;
        }
    }
}