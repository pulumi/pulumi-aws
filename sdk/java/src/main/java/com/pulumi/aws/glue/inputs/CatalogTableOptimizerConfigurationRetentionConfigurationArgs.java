// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.glue.inputs;

import com.pulumi.aws.glue.inputs.CatalogTableOptimizerConfigurationRetentionConfigurationIcebergConfigurationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class CatalogTableOptimizerConfigurationRetentionConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final CatalogTableOptimizerConfigurationRetentionConfigurationArgs Empty = new CatalogTableOptimizerConfigurationRetentionConfigurationArgs();

    /**
     * The configuration for an Iceberg snapshot retention optimizer.
     * 
     */
    @Import(name="icebergConfiguration")
    private @Nullable Output<CatalogTableOptimizerConfigurationRetentionConfigurationIcebergConfigurationArgs> icebergConfiguration;

    /**
     * @return The configuration for an Iceberg snapshot retention optimizer.
     * 
     */
    public Optional<Output<CatalogTableOptimizerConfigurationRetentionConfigurationIcebergConfigurationArgs>> icebergConfiguration() {
        return Optional.ofNullable(this.icebergConfiguration);
    }

    private CatalogTableOptimizerConfigurationRetentionConfigurationArgs() {}

    private CatalogTableOptimizerConfigurationRetentionConfigurationArgs(CatalogTableOptimizerConfigurationRetentionConfigurationArgs $) {
        this.icebergConfiguration = $.icebergConfiguration;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(CatalogTableOptimizerConfigurationRetentionConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private CatalogTableOptimizerConfigurationRetentionConfigurationArgs $;

        public Builder() {
            $ = new CatalogTableOptimizerConfigurationRetentionConfigurationArgs();
        }

        public Builder(CatalogTableOptimizerConfigurationRetentionConfigurationArgs defaults) {
            $ = new CatalogTableOptimizerConfigurationRetentionConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param icebergConfiguration The configuration for an Iceberg snapshot retention optimizer.
         * 
         * @return builder
         * 
         */
        public Builder icebergConfiguration(@Nullable Output<CatalogTableOptimizerConfigurationRetentionConfigurationIcebergConfigurationArgs> icebergConfiguration) {
            $.icebergConfiguration = icebergConfiguration;
            return this;
        }

        /**
         * @param icebergConfiguration The configuration for an Iceberg snapshot retention optimizer.
         * 
         * @return builder
         * 
         */
        public Builder icebergConfiguration(CatalogTableOptimizerConfigurationRetentionConfigurationIcebergConfigurationArgs icebergConfiguration) {
            return icebergConfiguration(Output.of(icebergConfiguration));
        }

        public CatalogTableOptimizerConfigurationRetentionConfigurationArgs build() {
            return $;
        }
    }

}
