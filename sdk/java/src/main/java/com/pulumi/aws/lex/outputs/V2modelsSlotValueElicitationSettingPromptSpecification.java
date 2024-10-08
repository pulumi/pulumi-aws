// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.outputs;

import com.pulumi.aws.lex.outputs.V2modelsSlotValueElicitationSettingPromptSpecificationMessageGroup;
import com.pulumi.aws.lex.outputs.V2modelsSlotValueElicitationSettingPromptSpecificationPromptAttemptsSpecification;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class V2modelsSlotValueElicitationSettingPromptSpecification {
    private @Nullable Boolean allowInterrupt;
    private Integer maxRetries;
    private @Nullable List<V2modelsSlotValueElicitationSettingPromptSpecificationMessageGroup> messageGroups;
    private @Nullable String messageSelectionStrategy;
    private @Nullable List<V2modelsSlotValueElicitationSettingPromptSpecificationPromptAttemptsSpecification> promptAttemptsSpecifications;

    private V2modelsSlotValueElicitationSettingPromptSpecification() {}
    public Optional<Boolean> allowInterrupt() {
        return Optional.ofNullable(this.allowInterrupt);
    }
    public Integer maxRetries() {
        return this.maxRetries;
    }
    public List<V2modelsSlotValueElicitationSettingPromptSpecificationMessageGroup> messageGroups() {
        return this.messageGroups == null ? List.of() : this.messageGroups;
    }
    public Optional<String> messageSelectionStrategy() {
        return Optional.ofNullable(this.messageSelectionStrategy);
    }
    public List<V2modelsSlotValueElicitationSettingPromptSpecificationPromptAttemptsSpecification> promptAttemptsSpecifications() {
        return this.promptAttemptsSpecifications == null ? List.of() : this.promptAttemptsSpecifications;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(V2modelsSlotValueElicitationSettingPromptSpecification defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Boolean allowInterrupt;
        private Integer maxRetries;
        private @Nullable List<V2modelsSlotValueElicitationSettingPromptSpecificationMessageGroup> messageGroups;
        private @Nullable String messageSelectionStrategy;
        private @Nullable List<V2modelsSlotValueElicitationSettingPromptSpecificationPromptAttemptsSpecification> promptAttemptsSpecifications;
        public Builder() {}
        public Builder(V2modelsSlotValueElicitationSettingPromptSpecification defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.allowInterrupt = defaults.allowInterrupt;
    	      this.maxRetries = defaults.maxRetries;
    	      this.messageGroups = defaults.messageGroups;
    	      this.messageSelectionStrategy = defaults.messageSelectionStrategy;
    	      this.promptAttemptsSpecifications = defaults.promptAttemptsSpecifications;
        }

        @CustomType.Setter
        public Builder allowInterrupt(@Nullable Boolean allowInterrupt) {

            this.allowInterrupt = allowInterrupt;
            return this;
        }
        @CustomType.Setter
        public Builder maxRetries(Integer maxRetries) {
            if (maxRetries == null) {
              throw new MissingRequiredPropertyException("V2modelsSlotValueElicitationSettingPromptSpecification", "maxRetries");
            }
            this.maxRetries = maxRetries;
            return this;
        }
        @CustomType.Setter
        public Builder messageGroups(@Nullable List<V2modelsSlotValueElicitationSettingPromptSpecificationMessageGroup> messageGroups) {

            this.messageGroups = messageGroups;
            return this;
        }
        public Builder messageGroups(V2modelsSlotValueElicitationSettingPromptSpecificationMessageGroup... messageGroups) {
            return messageGroups(List.of(messageGroups));
        }
        @CustomType.Setter
        public Builder messageSelectionStrategy(@Nullable String messageSelectionStrategy) {

            this.messageSelectionStrategy = messageSelectionStrategy;
            return this;
        }
        @CustomType.Setter
        public Builder promptAttemptsSpecifications(@Nullable List<V2modelsSlotValueElicitationSettingPromptSpecificationPromptAttemptsSpecification> promptAttemptsSpecifications) {

            this.promptAttemptsSpecifications = promptAttemptsSpecifications;
            return this;
        }
        public Builder promptAttemptsSpecifications(V2modelsSlotValueElicitationSettingPromptSpecificationPromptAttemptsSpecification... promptAttemptsSpecifications) {
            return promptAttemptsSpecifications(List.of(promptAttemptsSpecifications));
        }
        public V2modelsSlotValueElicitationSettingPromptSpecification build() {
            final var _resultValue = new V2modelsSlotValueElicitationSettingPromptSpecification();
            _resultValue.allowInterrupt = allowInterrupt;
            _resultValue.maxRetries = maxRetries;
            _resultValue.messageGroups = messageGroups;
            _resultValue.messageSelectionStrategy = messageSelectionStrategy;
            _resultValue.promptAttemptsSpecifications = promptAttemptsSpecifications;
            return _resultValue;
        }
    }
}
