// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3control.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class StorageLensConfigurationStorageLensConfigurationAccountLevelDetailedStatusCodeMetricsArgs extends com.pulumi.resources.ResourceArgs {

    public static final StorageLensConfigurationStorageLensConfigurationAccountLevelDetailedStatusCodeMetricsArgs Empty = new StorageLensConfigurationStorageLensConfigurationAccountLevelDetailedStatusCodeMetricsArgs();

    /**
     * Whether detailed status code metrics are enabled.
     * 
     */
    @Import(name="enabled")
    private @Nullable Output<Boolean> enabled;

    /**
     * @return Whether detailed status code metrics are enabled.
     * 
     */
    public Optional<Output<Boolean>> enabled() {
        return Optional.ofNullable(this.enabled);
    }

    private StorageLensConfigurationStorageLensConfigurationAccountLevelDetailedStatusCodeMetricsArgs() {}

    private StorageLensConfigurationStorageLensConfigurationAccountLevelDetailedStatusCodeMetricsArgs(StorageLensConfigurationStorageLensConfigurationAccountLevelDetailedStatusCodeMetricsArgs $) {
        this.enabled = $.enabled;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(StorageLensConfigurationStorageLensConfigurationAccountLevelDetailedStatusCodeMetricsArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private StorageLensConfigurationStorageLensConfigurationAccountLevelDetailedStatusCodeMetricsArgs $;

        public Builder() {
            $ = new StorageLensConfigurationStorageLensConfigurationAccountLevelDetailedStatusCodeMetricsArgs();
        }

        public Builder(StorageLensConfigurationStorageLensConfigurationAccountLevelDetailedStatusCodeMetricsArgs defaults) {
            $ = new StorageLensConfigurationStorageLensConfigurationAccountLevelDetailedStatusCodeMetricsArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param enabled Whether detailed status code metrics are enabled.
         * 
         * @return builder
         * 
         */
        public Builder enabled(@Nullable Output<Boolean> enabled) {
            $.enabled = enabled;
            return this;
        }

        /**
         * @param enabled Whether detailed status code metrics are enabled.
         * 
         * @return builder
         * 
         */
        public Builder enabled(Boolean enabled) {
            return enabled(Output.of(enabled));
        }

        public StorageLensConfigurationStorageLensConfigurationAccountLevelDetailedStatusCodeMetricsArgs build() {
            return $;
        }
    }

}
