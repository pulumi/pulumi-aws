// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseMessageGroupMessageCustomPayloadArgs extends com.pulumi.resources.ResourceArgs {

    public static final V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseMessageGroupMessageCustomPayloadArgs Empty = new V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseMessageGroupMessageCustomPayloadArgs();

    @Import(name="value", required=true)
    private Output<String> value;

    public Output<String> value() {
        return this.value;
    }

    private V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseMessageGroupMessageCustomPayloadArgs() {}

    private V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseMessageGroupMessageCustomPayloadArgs(V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseMessageGroupMessageCustomPayloadArgs $) {
        this.value = $.value;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseMessageGroupMessageCustomPayloadArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseMessageGroupMessageCustomPayloadArgs $;

        public Builder() {
            $ = new V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseMessageGroupMessageCustomPayloadArgs();
        }

        public Builder(V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseMessageGroupMessageCustomPayloadArgs defaults) {
            $ = new V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseMessageGroupMessageCustomPayloadArgs(Objects.requireNonNull(defaults));
        }

        public Builder value(Output<String> value) {
            $.value = value;
            return this;
        }

        public Builder value(String value) {
            return value(Output.of(value));
        }

        public V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseMessageGroupMessageCustomPayloadArgs build() {
            if ($.value == null) {
                throw new MissingRequiredPropertyException("V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseMessageGroupMessageCustomPayloadArgs", "value");
            }
            return $;
        }
    }

}
