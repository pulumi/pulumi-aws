// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.datapipeline.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class GetPipelineDefinitionParameterValueArgs extends com.pulumi.resources.ResourceArgs {

    public static final GetPipelineDefinitionParameterValueArgs Empty = new GetPipelineDefinitionParameterValueArgs();

    /**
     * ID of the object.
     * 
     */
    @Import(name="id", required=true)
    private Output<String> id;

    /**
     * @return ID of the object.
     * 
     */
    public Output<String> id() {
        return this.id;
    }

    /**
     * Field value, expressed as a String.
     * 
     */
    @Import(name="stringValue", required=true)
    private Output<String> stringValue;

    /**
     * @return Field value, expressed as a String.
     * 
     */
    public Output<String> stringValue() {
        return this.stringValue;
    }

    private GetPipelineDefinitionParameterValueArgs() {}

    private GetPipelineDefinitionParameterValueArgs(GetPipelineDefinitionParameterValueArgs $) {
        this.id = $.id;
        this.stringValue = $.stringValue;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetPipelineDefinitionParameterValueArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetPipelineDefinitionParameterValueArgs $;

        public Builder() {
            $ = new GetPipelineDefinitionParameterValueArgs();
        }

        public Builder(GetPipelineDefinitionParameterValueArgs defaults) {
            $ = new GetPipelineDefinitionParameterValueArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param id ID of the object.
         * 
         * @return builder
         * 
         */
        public Builder id(Output<String> id) {
            $.id = id;
            return this;
        }

        /**
         * @param id ID of the object.
         * 
         * @return builder
         * 
         */
        public Builder id(String id) {
            return id(Output.of(id));
        }

        /**
         * @param stringValue Field value, expressed as a String.
         * 
         * @return builder
         * 
         */
        public Builder stringValue(Output<String> stringValue) {
            $.stringValue = stringValue;
            return this;
        }

        /**
         * @param stringValue Field value, expressed as a String.
         * 
         * @return builder
         * 
         */
        public Builder stringValue(String stringValue) {
            return stringValue(Output.of(stringValue));
        }

        public GetPipelineDefinitionParameterValueArgs build() {
            if ($.id == null) {
                throw new MissingRequiredPropertyException("GetPipelineDefinitionParameterValueArgs", "id");
            }
            if ($.stringValue == null) {
                throw new MissingRequiredPropertyException("GetPipelineDefinitionParameterValueArgs", "stringValue");
            }
            return $;
        }
    }

}
