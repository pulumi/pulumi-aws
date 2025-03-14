// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class InferenceProfileModelSourceArgs extends com.pulumi.resources.ResourceArgs {

    public static final InferenceProfileModelSourceArgs Empty = new InferenceProfileModelSourceArgs();

    /**
     * The Amazon Resource Name (ARN) of the model.
     * 
     */
    @Import(name="copyFrom", required=true)
    private Output<String> copyFrom;

    /**
     * @return The Amazon Resource Name (ARN) of the model.
     * 
     */
    public Output<String> copyFrom() {
        return this.copyFrom;
    }

    private InferenceProfileModelSourceArgs() {}

    private InferenceProfileModelSourceArgs(InferenceProfileModelSourceArgs $) {
        this.copyFrom = $.copyFrom;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(InferenceProfileModelSourceArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private InferenceProfileModelSourceArgs $;

        public Builder() {
            $ = new InferenceProfileModelSourceArgs();
        }

        public Builder(InferenceProfileModelSourceArgs defaults) {
            $ = new InferenceProfileModelSourceArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param copyFrom The Amazon Resource Name (ARN) of the model.
         * 
         * @return builder
         * 
         */
        public Builder copyFrom(Output<String> copyFrom) {
            $.copyFrom = copyFrom;
            return this;
        }

        /**
         * @param copyFrom The Amazon Resource Name (ARN) of the model.
         * 
         * @return builder
         * 
         */
        public Builder copyFrom(String copyFrom) {
            return copyFrom(Output.of(copyFrom));
        }

        public InferenceProfileModelSourceArgs build() {
            if ($.copyFrom == null) {
                throw new MissingRequiredPropertyException("InferenceProfileModelSourceArgs", "copyFrom");
            }
            return $;
        }
    }

}
