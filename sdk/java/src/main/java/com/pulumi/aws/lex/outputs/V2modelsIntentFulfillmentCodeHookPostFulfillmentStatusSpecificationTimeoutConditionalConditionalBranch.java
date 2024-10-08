// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.outputs;

import com.pulumi.aws.lex.outputs.V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchCondition;
import com.pulumi.aws.lex.outputs.V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStep;
import com.pulumi.aws.lex.outputs.V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchResponse;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranch {
    /**
     * @return Configuration block for the expression to evaluate. If the condition is true, the branch&#39;s actions are taken. See `condition`.
     * 
     */
    private V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchCondition condition;
    /**
     * @return Name of the branch.
     * 
     */
    private String name;
    /**
     * @return Configuration block for the next step in the conversation. See `next_step`.
     * 
     */
    private V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStep nextStep;
    /**
     * @return Configuration block for a list of message groups that Amazon Lex uses to respond to the user input. See `response`.
     * 
     */
    private @Nullable V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchResponse response;

    private V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranch() {}
    /**
     * @return Configuration block for the expression to evaluate. If the condition is true, the branch&#39;s actions are taken. See `condition`.
     * 
     */
    public V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchCondition condition() {
        return this.condition;
    }
    /**
     * @return Name of the branch.
     * 
     */
    public String name() {
        return this.name;
    }
    /**
     * @return Configuration block for the next step in the conversation. See `next_step`.
     * 
     */
    public V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStep nextStep() {
        return this.nextStep;
    }
    /**
     * @return Configuration block for a list of message groups that Amazon Lex uses to respond to the user input. See `response`.
     * 
     */
    public Optional<V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchResponse> response() {
        return Optional.ofNullable(this.response);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranch defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchCondition condition;
        private String name;
        private V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStep nextStep;
        private @Nullable V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchResponse response;
        public Builder() {}
        public Builder(V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranch defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.condition = defaults.condition;
    	      this.name = defaults.name;
    	      this.nextStep = defaults.nextStep;
    	      this.response = defaults.response;
        }

        @CustomType.Setter
        public Builder condition(V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchCondition condition) {
            if (condition == null) {
              throw new MissingRequiredPropertyException("V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranch", "condition");
            }
            this.condition = condition;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranch", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder nextStep(V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStep nextStep) {
            if (nextStep == null) {
              throw new MissingRequiredPropertyException("V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranch", "nextStep");
            }
            this.nextStep = nextStep;
            return this;
        }
        @CustomType.Setter
        public Builder response(@Nullable V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchResponse response) {

            this.response = response;
            return this;
        }
        public V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranch build() {
            final var _resultValue = new V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranch();
            _resultValue.condition = condition;
            _resultValue.name = name;
            _resultValue.nextStep = nextStep;
            _resultValue.response = response;
            return _resultValue;
        }
    }
}
