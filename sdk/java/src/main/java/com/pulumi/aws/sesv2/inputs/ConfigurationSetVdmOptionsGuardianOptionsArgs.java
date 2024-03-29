// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sesv2.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ConfigurationSetVdmOptionsGuardianOptionsArgs extends com.pulumi.resources.ResourceArgs {

    public static final ConfigurationSetVdmOptionsGuardianOptionsArgs Empty = new ConfigurationSetVdmOptionsGuardianOptionsArgs();

    /**
     * Specifies the status of your VDM optimized shared delivery. Valid values: `ENABLED`, `DISABLED`.
     * 
     */
    @Import(name="optimizedSharedDelivery")
    private @Nullable Output<String> optimizedSharedDelivery;

    /**
     * @return Specifies the status of your VDM optimized shared delivery. Valid values: `ENABLED`, `DISABLED`.
     * 
     */
    public Optional<Output<String>> optimizedSharedDelivery() {
        return Optional.ofNullable(this.optimizedSharedDelivery);
    }

    private ConfigurationSetVdmOptionsGuardianOptionsArgs() {}

    private ConfigurationSetVdmOptionsGuardianOptionsArgs(ConfigurationSetVdmOptionsGuardianOptionsArgs $) {
        this.optimizedSharedDelivery = $.optimizedSharedDelivery;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ConfigurationSetVdmOptionsGuardianOptionsArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ConfigurationSetVdmOptionsGuardianOptionsArgs $;

        public Builder() {
            $ = new ConfigurationSetVdmOptionsGuardianOptionsArgs();
        }

        public Builder(ConfigurationSetVdmOptionsGuardianOptionsArgs defaults) {
            $ = new ConfigurationSetVdmOptionsGuardianOptionsArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param optimizedSharedDelivery Specifies the status of your VDM optimized shared delivery. Valid values: `ENABLED`, `DISABLED`.
         * 
         * @return builder
         * 
         */
        public Builder optimizedSharedDelivery(@Nullable Output<String> optimizedSharedDelivery) {
            $.optimizedSharedDelivery = optimizedSharedDelivery;
            return this;
        }

        /**
         * @param optimizedSharedDelivery Specifies the status of your VDM optimized shared delivery. Valid values: `ENABLED`, `DISABLED`.
         * 
         * @return builder
         * 
         */
        public Builder optimizedSharedDelivery(String optimizedSharedDelivery) {
            return optimizedSharedDelivery(Output.of(optimizedSharedDelivery));
        }

        public ConfigurationSetVdmOptionsGuardianOptionsArgs build() {
            return $;
        }
    }

}
