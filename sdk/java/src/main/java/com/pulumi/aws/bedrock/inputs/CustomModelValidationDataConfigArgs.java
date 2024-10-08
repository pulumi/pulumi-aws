// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.inputs;

import com.pulumi.aws.bedrock.inputs.CustomModelValidationDataConfigValidatorArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class CustomModelValidationDataConfigArgs extends com.pulumi.resources.ResourceArgs {

    public static final CustomModelValidationDataConfigArgs Empty = new CustomModelValidationDataConfigArgs();

    /**
     * Information about the validators.
     * 
     */
    @Import(name="validators")
    private @Nullable Output<List<CustomModelValidationDataConfigValidatorArgs>> validators;

    /**
     * @return Information about the validators.
     * 
     */
    public Optional<Output<List<CustomModelValidationDataConfigValidatorArgs>>> validators() {
        return Optional.ofNullable(this.validators);
    }

    private CustomModelValidationDataConfigArgs() {}

    private CustomModelValidationDataConfigArgs(CustomModelValidationDataConfigArgs $) {
        this.validators = $.validators;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(CustomModelValidationDataConfigArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private CustomModelValidationDataConfigArgs $;

        public Builder() {
            $ = new CustomModelValidationDataConfigArgs();
        }

        public Builder(CustomModelValidationDataConfigArgs defaults) {
            $ = new CustomModelValidationDataConfigArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param validators Information about the validators.
         * 
         * @return builder
         * 
         */
        public Builder validators(@Nullable Output<List<CustomModelValidationDataConfigValidatorArgs>> validators) {
            $.validators = validators;
            return this;
        }

        /**
         * @param validators Information about the validators.
         * 
         * @return builder
         * 
         */
        public Builder validators(List<CustomModelValidationDataConfigValidatorArgs> validators) {
            return validators(Output.of(validators));
        }

        /**
         * @param validators Information about the validators.
         * 
         * @return builder
         * 
         */
        public Builder validators(CustomModelValidationDataConfigValidatorArgs... validators) {
            return validators(List.of(validators));
        }

        public CustomModelValidationDataConfigArgs build() {
            return $;
        }
    }

}
