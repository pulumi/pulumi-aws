// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lb.outputs;

import com.pulumi.aws.lb.outputs.GetListenerRuleAction;
import com.pulumi.aws.lb.outputs.GetListenerRuleCondition;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class GetListenerRuleResult {
    /**
     * @return List of actions associated with the rule, sorted by `order`.
     * Detailed below.
     * 
     */
    private @Nullable List<GetListenerRuleAction> actions;
    /**
     * @return ARN of the target group.
     * 
     */
    private String arn;
    /**
     * @return Set of conditions associated with the rule.
     * Detailed below.
     * 
     */
    private @Nullable List<GetListenerRuleCondition> conditions;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    private String listenerArn;
    private Integer priority;
    /**
     * @return Tags assigned to the Listener Rule.
     * 
     */
    private Map<String,String> tags;

    private GetListenerRuleResult() {}
    /**
     * @return List of actions associated with the rule, sorted by `order`.
     * Detailed below.
     * 
     */
    public List<GetListenerRuleAction> actions() {
        return this.actions == null ? List.of() : this.actions;
    }
    /**
     * @return ARN of the target group.
     * 
     */
    public String arn() {
        return this.arn;
    }
    /**
     * @return Set of conditions associated with the rule.
     * Detailed below.
     * 
     */
    public List<GetListenerRuleCondition> conditions() {
        return this.conditions == null ? List.of() : this.conditions;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    public String listenerArn() {
        return this.listenerArn;
    }
    public Integer priority() {
        return this.priority;
    }
    /**
     * @return Tags assigned to the Listener Rule.
     * 
     */
    public Map<String,String> tags() {
        return this.tags;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetListenerRuleResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<GetListenerRuleAction> actions;
        private String arn;
        private @Nullable List<GetListenerRuleCondition> conditions;
        private String id;
        private String listenerArn;
        private Integer priority;
        private Map<String,String> tags;
        public Builder() {}
        public Builder(GetListenerRuleResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.actions = defaults.actions;
    	      this.arn = defaults.arn;
    	      this.conditions = defaults.conditions;
    	      this.id = defaults.id;
    	      this.listenerArn = defaults.listenerArn;
    	      this.priority = defaults.priority;
    	      this.tags = defaults.tags;
        }

        @CustomType.Setter
        public Builder actions(@Nullable List<GetListenerRuleAction> actions) {

            this.actions = actions;
            return this;
        }
        public Builder actions(GetListenerRuleAction... actions) {
            return actions(List.of(actions));
        }
        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("GetListenerRuleResult", "arn");
            }
            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder conditions(@Nullable List<GetListenerRuleCondition> conditions) {

            this.conditions = conditions;
            return this;
        }
        public Builder conditions(GetListenerRuleCondition... conditions) {
            return conditions(List.of(conditions));
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetListenerRuleResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder listenerArn(String listenerArn) {
            if (listenerArn == null) {
              throw new MissingRequiredPropertyException("GetListenerRuleResult", "listenerArn");
            }
            this.listenerArn = listenerArn;
            return this;
        }
        @CustomType.Setter
        public Builder priority(Integer priority) {
            if (priority == null) {
              throw new MissingRequiredPropertyException("GetListenerRuleResult", "priority");
            }
            this.priority = priority;
            return this;
        }
        @CustomType.Setter
        public Builder tags(Map<String,String> tags) {
            if (tags == null) {
              throw new MissingRequiredPropertyException("GetListenerRuleResult", "tags");
            }
            this.tags = tags;
            return this;
        }
        public GetListenerRuleResult build() {
            final var _resultValue = new GetListenerRuleResult();
            _resultValue.actions = actions;
            _resultValue.arn = arn;
            _resultValue.conditions = conditions;
            _resultValue.id = id;
            _resultValue.listenerArn = listenerArn;
            _resultValue.priority = priority;
            _resultValue.tags = tags;
            return _resultValue;
        }
    }
}
