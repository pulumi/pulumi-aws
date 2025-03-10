// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Double;
import java.util.Objects;


public final class CustomModelValidationMetricArgs extends com.pulumi.resources.ResourceArgs {

    public static final CustomModelValidationMetricArgs Empty = new CustomModelValidationMetricArgs();

    /**
     * The validation loss associated with the validator.
     * 
     */
    @Import(name="validationLoss", required=true)
    private Output<Double> validationLoss;

    /**
     * @return The validation loss associated with the validator.
     * 
     */
    public Output<Double> validationLoss() {
        return this.validationLoss;
    }

    private CustomModelValidationMetricArgs() {}

    private CustomModelValidationMetricArgs(CustomModelValidationMetricArgs $) {
        this.validationLoss = $.validationLoss;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(CustomModelValidationMetricArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private CustomModelValidationMetricArgs $;

        public Builder() {
            $ = new CustomModelValidationMetricArgs();
        }

        public Builder(CustomModelValidationMetricArgs defaults) {
            $ = new CustomModelValidationMetricArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param validationLoss The validation loss associated with the validator.
         * 
         * @return builder
         * 
         */
        public Builder validationLoss(Output<Double> validationLoss) {
            $.validationLoss = validationLoss;
            return this;
        }

        /**
         * @param validationLoss The validation loss associated with the validator.
         * 
         * @return builder
         * 
         */
        public Builder validationLoss(Double validationLoss) {
            return validationLoss(Output.of(validationLoss));
        }

        public CustomModelValidationMetricArgs build() {
            if ($.validationLoss == null) {
                throw new MissingRequiredPropertyException("CustomModelValidationMetricArgs", "validationLoss");
            }
            return $;
        }
    }

}
