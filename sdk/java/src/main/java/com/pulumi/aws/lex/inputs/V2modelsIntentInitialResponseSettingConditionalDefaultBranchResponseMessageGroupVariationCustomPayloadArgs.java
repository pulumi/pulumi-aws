// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class V2modelsIntentInitialResponseSettingConditionalDefaultBranchResponseMessageGroupVariationCustomPayloadArgs extends com.pulumi.resources.ResourceArgs {

    public static final V2modelsIntentInitialResponseSettingConditionalDefaultBranchResponseMessageGroupVariationCustomPayloadArgs Empty = new V2modelsIntentInitialResponseSettingConditionalDefaultBranchResponseMessageGroupVariationCustomPayloadArgs();

    /**
     * String that is sent to your application.
     * 
     */
    @Import(name="value", required=true)
    private Output<String> value;

    /**
     * @return String that is sent to your application.
     * 
     */
    public Output<String> value() {
        return this.value;
    }

    private V2modelsIntentInitialResponseSettingConditionalDefaultBranchResponseMessageGroupVariationCustomPayloadArgs() {}

    private V2modelsIntentInitialResponseSettingConditionalDefaultBranchResponseMessageGroupVariationCustomPayloadArgs(V2modelsIntentInitialResponseSettingConditionalDefaultBranchResponseMessageGroupVariationCustomPayloadArgs $) {
        this.value = $.value;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(V2modelsIntentInitialResponseSettingConditionalDefaultBranchResponseMessageGroupVariationCustomPayloadArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private V2modelsIntentInitialResponseSettingConditionalDefaultBranchResponseMessageGroupVariationCustomPayloadArgs $;

        public Builder() {
            $ = new V2modelsIntentInitialResponseSettingConditionalDefaultBranchResponseMessageGroupVariationCustomPayloadArgs();
        }

        public Builder(V2modelsIntentInitialResponseSettingConditionalDefaultBranchResponseMessageGroupVariationCustomPayloadArgs defaults) {
            $ = new V2modelsIntentInitialResponseSettingConditionalDefaultBranchResponseMessageGroupVariationCustomPayloadArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param value String that is sent to your application.
         * 
         * @return builder
         * 
         */
        public Builder value(Output<String> value) {
            $.value = value;
            return this;
        }

        /**
         * @param value String that is sent to your application.
         * 
         * @return builder
         * 
         */
        public Builder value(String value) {
            return value(Output.of(value));
        }

        public V2modelsIntentInitialResponseSettingConditionalDefaultBranchResponseMessageGroupVariationCustomPayloadArgs build() {
            if ($.value == null) {
                throw new MissingRequiredPropertyException("V2modelsIntentInitialResponseSettingConditionalDefaultBranchResponseMessageGroupVariationCustomPayloadArgs", "value");
            }
            return $;
        }
    }

}
