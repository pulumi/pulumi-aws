// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationFailureConditionalConditionalBranchNextStepIntentSlotValueArgs extends com.pulumi.resources.ResourceArgs {

    public static final V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationFailureConditionalConditionalBranchNextStepIntentSlotValueArgs Empty = new V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationFailureConditionalConditionalBranchNextStepIntentSlotValueArgs();

    @Import(name="interpretedValue")
    private @Nullable Output<String> interpretedValue;

    public Optional<Output<String>> interpretedValue() {
        return Optional.ofNullable(this.interpretedValue);
    }

    private V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationFailureConditionalConditionalBranchNextStepIntentSlotValueArgs() {}

    private V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationFailureConditionalConditionalBranchNextStepIntentSlotValueArgs(V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationFailureConditionalConditionalBranchNextStepIntentSlotValueArgs $) {
        this.interpretedValue = $.interpretedValue;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationFailureConditionalConditionalBranchNextStepIntentSlotValueArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationFailureConditionalConditionalBranchNextStepIntentSlotValueArgs $;

        public Builder() {
            $ = new V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationFailureConditionalConditionalBranchNextStepIntentSlotValueArgs();
        }

        public Builder(V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationFailureConditionalConditionalBranchNextStepIntentSlotValueArgs defaults) {
            $ = new V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationFailureConditionalConditionalBranchNextStepIntentSlotValueArgs(Objects.requireNonNull(defaults));
        }

        public Builder interpretedValue(@Nullable Output<String> interpretedValue) {
            $.interpretedValue = interpretedValue;
            return this;
        }

        public Builder interpretedValue(String interpretedValue) {
            return interpretedValue(Output.of(interpretedValue));
        }

        public V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationFailureConditionalConditionalBranchNextStepIntentSlotValueArgs build() {
            return $;
        }
    }

}
