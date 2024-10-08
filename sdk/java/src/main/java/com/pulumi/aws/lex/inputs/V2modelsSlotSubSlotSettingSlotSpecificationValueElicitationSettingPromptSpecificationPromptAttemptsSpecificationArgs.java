// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.inputs;

import com.pulumi.aws.lex.inputs.V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAllowedInputTypesArgs;
import com.pulumi.aws.lex.inputs.V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs;
import com.pulumi.aws.lex.inputs.V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecificationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationArgs extends com.pulumi.resources.ResourceArgs {

    public static final V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationArgs Empty = new V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationArgs();

    @Import(name="allowInterrupt")
    private @Nullable Output<Boolean> allowInterrupt;

    public Optional<Output<Boolean>> allowInterrupt() {
        return Optional.ofNullable(this.allowInterrupt);
    }

    @Import(name="allowedInputTypes", required=true)
    private Output<V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAllowedInputTypesArgs> allowedInputTypes;

    public Output<V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAllowedInputTypesArgs> allowedInputTypes() {
        return this.allowedInputTypes;
    }

    @Import(name="audioAndDtmfInputSpecification")
    private @Nullable Output<V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs> audioAndDtmfInputSpecification;

    public Optional<Output<V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs>> audioAndDtmfInputSpecification() {
        return Optional.ofNullable(this.audioAndDtmfInputSpecification);
    }

    @Import(name="mapBlockKey", required=true)
    private Output<String> mapBlockKey;

    public Output<String> mapBlockKey() {
        return this.mapBlockKey;
    }

    @Import(name="textInputSpecification")
    private @Nullable Output<V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecificationArgs> textInputSpecification;

    public Optional<Output<V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecificationArgs>> textInputSpecification() {
        return Optional.ofNullable(this.textInputSpecification);
    }

    private V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationArgs() {}

    private V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationArgs(V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationArgs $) {
        this.allowInterrupt = $.allowInterrupt;
        this.allowedInputTypes = $.allowedInputTypes;
        this.audioAndDtmfInputSpecification = $.audioAndDtmfInputSpecification;
        this.mapBlockKey = $.mapBlockKey;
        this.textInputSpecification = $.textInputSpecification;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationArgs $;

        public Builder() {
            $ = new V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationArgs();
        }

        public Builder(V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationArgs defaults) {
            $ = new V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationArgs(Objects.requireNonNull(defaults));
        }

        public Builder allowInterrupt(@Nullable Output<Boolean> allowInterrupt) {
            $.allowInterrupt = allowInterrupt;
            return this;
        }

        public Builder allowInterrupt(Boolean allowInterrupt) {
            return allowInterrupt(Output.of(allowInterrupt));
        }

        public Builder allowedInputTypes(Output<V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAllowedInputTypesArgs> allowedInputTypes) {
            $.allowedInputTypes = allowedInputTypes;
            return this;
        }

        public Builder allowedInputTypes(V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAllowedInputTypesArgs allowedInputTypes) {
            return allowedInputTypes(Output.of(allowedInputTypes));
        }

        public Builder audioAndDtmfInputSpecification(@Nullable Output<V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs> audioAndDtmfInputSpecification) {
            $.audioAndDtmfInputSpecification = audioAndDtmfInputSpecification;
            return this;
        }

        public Builder audioAndDtmfInputSpecification(V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs audioAndDtmfInputSpecification) {
            return audioAndDtmfInputSpecification(Output.of(audioAndDtmfInputSpecification));
        }

        public Builder mapBlockKey(Output<String> mapBlockKey) {
            $.mapBlockKey = mapBlockKey;
            return this;
        }

        public Builder mapBlockKey(String mapBlockKey) {
            return mapBlockKey(Output.of(mapBlockKey));
        }

        public Builder textInputSpecification(@Nullable Output<V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecificationArgs> textInputSpecification) {
            $.textInputSpecification = textInputSpecification;
            return this;
        }

        public Builder textInputSpecification(V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecificationArgs textInputSpecification) {
            return textInputSpecification(Output.of(textInputSpecification));
        }

        public V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationArgs build() {
            if ($.allowedInputTypes == null) {
                throw new MissingRequiredPropertyException("V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationArgs", "allowedInputTypes");
            }
            if ($.mapBlockKey == null) {
                throw new MissingRequiredPropertyException("V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationArgs", "mapBlockKey");
            }
            return $;
        }
    }

}
