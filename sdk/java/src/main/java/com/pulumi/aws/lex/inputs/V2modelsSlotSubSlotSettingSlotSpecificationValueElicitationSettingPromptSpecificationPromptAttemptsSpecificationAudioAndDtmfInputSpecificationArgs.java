// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.inputs;

import com.pulumi.aws.lex.inputs.V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationAudioSpecificationArgs;
import com.pulumi.aws.lex.inputs.V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationDtmfSpecificationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs extends com.pulumi.resources.ResourceArgs {

    public static final V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs Empty = new V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs();

    @Import(name="audioSpecification")
    private @Nullable Output<V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationAudioSpecificationArgs> audioSpecification;

    public Optional<Output<V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationAudioSpecificationArgs>> audioSpecification() {
        return Optional.ofNullable(this.audioSpecification);
    }

    @Import(name="dtmfSpecification")
    private @Nullable Output<V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationDtmfSpecificationArgs> dtmfSpecification;

    public Optional<Output<V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationDtmfSpecificationArgs>> dtmfSpecification() {
        return Optional.ofNullable(this.dtmfSpecification);
    }

    @Import(name="startTimeoutMs", required=true)
    private Output<Integer> startTimeoutMs;

    public Output<Integer> startTimeoutMs() {
        return this.startTimeoutMs;
    }

    private V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs() {}

    private V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs(V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs $) {
        this.audioSpecification = $.audioSpecification;
        this.dtmfSpecification = $.dtmfSpecification;
        this.startTimeoutMs = $.startTimeoutMs;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs $;

        public Builder() {
            $ = new V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs();
        }

        public Builder(V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs defaults) {
            $ = new V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs(Objects.requireNonNull(defaults));
        }

        public Builder audioSpecification(@Nullable Output<V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationAudioSpecificationArgs> audioSpecification) {
            $.audioSpecification = audioSpecification;
            return this;
        }

        public Builder audioSpecification(V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationAudioSpecificationArgs audioSpecification) {
            return audioSpecification(Output.of(audioSpecification));
        }

        public Builder dtmfSpecification(@Nullable Output<V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationDtmfSpecificationArgs> dtmfSpecification) {
            $.dtmfSpecification = dtmfSpecification;
            return this;
        }

        public Builder dtmfSpecification(V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationDtmfSpecificationArgs dtmfSpecification) {
            return dtmfSpecification(Output.of(dtmfSpecification));
        }

        public Builder startTimeoutMs(Output<Integer> startTimeoutMs) {
            $.startTimeoutMs = startTimeoutMs;
            return this;
        }

        public Builder startTimeoutMs(Integer startTimeoutMs) {
            return startTimeoutMs(Output.of(startTimeoutMs));
        }

        public V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs build() {
            if ($.startTimeoutMs == null) {
                throw new MissingRequiredPropertyException("V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs", "startTimeoutMs");
            }
            return $;
        }
    }

}
