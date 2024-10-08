// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3control.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.util.Objects;

@CustomType
public final class StorageLensConfigurationStorageLensConfigurationDataExportCloudWatchMetrics {
    /**
     * @return Whether CloudWatch publishing for S3 Storage Lens metrics is enabled.
     * 
     */
    private Boolean enabled;

    private StorageLensConfigurationStorageLensConfigurationDataExportCloudWatchMetrics() {}
    /**
     * @return Whether CloudWatch publishing for S3 Storage Lens metrics is enabled.
     * 
     */
    public Boolean enabled() {
        return this.enabled;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(StorageLensConfigurationStorageLensConfigurationDataExportCloudWatchMetrics defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Boolean enabled;
        public Builder() {}
        public Builder(StorageLensConfigurationStorageLensConfigurationDataExportCloudWatchMetrics defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.enabled = defaults.enabled;
        }

        @CustomType.Setter
        public Builder enabled(Boolean enabled) {
            if (enabled == null) {
              throw new MissingRequiredPropertyException("StorageLensConfigurationStorageLensConfigurationDataExportCloudWatchMetrics", "enabled");
            }
            this.enabled = enabled;
            return this;
        }
        public StorageLensConfigurationStorageLensConfigurationDataExportCloudWatchMetrics build() {
            final var _resultValue = new StorageLensConfigurationStorageLensConfigurationDataExportCloudWatchMetrics();
            _resultValue.enabled = enabled;
            return _resultValue;
        }
    }
}
