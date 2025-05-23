// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.verifiedpermissions.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class PolicyStoreValidationSettingsArgs extends com.pulumi.resources.ResourceArgs {

    public static final PolicyStoreValidationSettingsArgs Empty = new PolicyStoreValidationSettingsArgs();

    /**
     * The mode for the validation settings. Valid values: `OFF`, `STRICT`.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="mode", required=true)
    private Output<String> mode;

    /**
     * @return The mode for the validation settings. Valid values: `OFF`, `STRICT`.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> mode() {
        return this.mode;
    }

    private PolicyStoreValidationSettingsArgs() {}

    private PolicyStoreValidationSettingsArgs(PolicyStoreValidationSettingsArgs $) {
        this.mode = $.mode;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(PolicyStoreValidationSettingsArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private PolicyStoreValidationSettingsArgs $;

        public Builder() {
            $ = new PolicyStoreValidationSettingsArgs();
        }

        public Builder(PolicyStoreValidationSettingsArgs defaults) {
            $ = new PolicyStoreValidationSettingsArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param mode The mode for the validation settings. Valid values: `OFF`, `STRICT`.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder mode(Output<String> mode) {
            $.mode = mode;
            return this;
        }

        /**
         * @param mode The mode for the validation settings. Valid values: `OFF`, `STRICT`.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder mode(String mode) {
            return mode(Output.of(mode));
        }

        public PolicyStoreValidationSettingsArgs build() {
            if ($.mode == null) {
                throw new MissingRequiredPropertyException("PolicyStoreValidationSettingsArgs", "mode");
            }
            return $;
        }
    }

}
