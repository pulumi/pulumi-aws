// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lb.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetListenerRuleActionForwardTargetGroup {
    /**
     * @return ARN of the Listener Rule.
     * Either `arn` or `listener_arn` must be set.
     * 
     */
    private String arn;
    /**
     * @return Weight of the target group.
     * 
     */
    private Integer weight;

    private GetListenerRuleActionForwardTargetGroup() {}
    /**
     * @return ARN of the Listener Rule.
     * Either `arn` or `listener_arn` must be set.
     * 
     */
    public String arn() {
        return this.arn;
    }
    /**
     * @return Weight of the target group.
     * 
     */
    public Integer weight() {
        return this.weight;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetListenerRuleActionForwardTargetGroup defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String arn;
        private Integer weight;
        public Builder() {}
        public Builder(GetListenerRuleActionForwardTargetGroup defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arn = defaults.arn;
    	      this.weight = defaults.weight;
        }

        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("GetListenerRuleActionForwardTargetGroup", "arn");
            }
            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder weight(Integer weight) {
            if (weight == null) {
              throw new MissingRequiredPropertyException("GetListenerRuleActionForwardTargetGroup", "weight");
            }
            this.weight = weight;
            return this;
        }
        public GetListenerRuleActionForwardTargetGroup build() {
            final var _resultValue = new GetListenerRuleActionForwardTargetGroup();
            _resultValue.arn = arn;
            _resultValue.weight = weight;
            return _resultValue;
        }
    }
}
