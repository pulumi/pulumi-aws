// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.outputs;

import com.pulumi.aws.lex.outputs.V2modelsSlotSubSlotSettingSlotSpecification;
import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class V2modelsSlotSubSlotSetting {
    /**
     * @return Expression text for defining the constituent sub slots in the composite slot using logical `AND` and `OR` operators.
     * 
     */
    private @Nullable String expression;
    /**
     * @return Specifications for the constituent sub slots of a composite slot.
     * See the `slot_specification` argument reference below.
     * 
     */
    private @Nullable List<V2modelsSlotSubSlotSettingSlotSpecification> slotSpecifications;

    private V2modelsSlotSubSlotSetting() {}
    /**
     * @return Expression text for defining the constituent sub slots in the composite slot using logical `AND` and `OR` operators.
     * 
     */
    public Optional<String> expression() {
        return Optional.ofNullable(this.expression);
    }
    /**
     * @return Specifications for the constituent sub slots of a composite slot.
     * See the `slot_specification` argument reference below.
     * 
     */
    public List<V2modelsSlotSubSlotSettingSlotSpecification> slotSpecifications() {
        return this.slotSpecifications == null ? List.of() : this.slotSpecifications;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(V2modelsSlotSubSlotSetting defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String expression;
        private @Nullable List<V2modelsSlotSubSlotSettingSlotSpecification> slotSpecifications;
        public Builder() {}
        public Builder(V2modelsSlotSubSlotSetting defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.expression = defaults.expression;
    	      this.slotSpecifications = defaults.slotSpecifications;
        }

        @CustomType.Setter
        public Builder expression(@Nullable String expression) {

            this.expression = expression;
            return this;
        }
        @CustomType.Setter
        public Builder slotSpecifications(@Nullable List<V2modelsSlotSubSlotSettingSlotSpecification> slotSpecifications) {

            this.slotSpecifications = slotSpecifications;
            return this;
        }
        public Builder slotSpecifications(V2modelsSlotSubSlotSettingSlotSpecification... slotSpecifications) {
            return slotSpecifications(List.of(slotSpecifications));
        }
        public V2modelsSlotSubSlotSetting build() {
            final var _resultValue = new V2modelsSlotSubSlotSetting();
            _resultValue.expression = expression;
            _resultValue.slotSpecifications = slotSpecifications;
            return _resultValue;
        }
    }
}
