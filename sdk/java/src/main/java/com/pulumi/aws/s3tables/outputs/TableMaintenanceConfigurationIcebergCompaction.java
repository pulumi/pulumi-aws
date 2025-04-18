// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3tables.outputs;

import com.pulumi.aws.s3tables.outputs.TableMaintenanceConfigurationIcebergCompactionSettings;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class TableMaintenanceConfigurationIcebergCompaction {
    /**
     * @return Settings object for compaction.
     * See `iceberg_compaction.settings` below.
     * 
     */
    private TableMaintenanceConfigurationIcebergCompactionSettings settings;
    /**
     * @return Whether the configuration is enabled.
     * Valid values are `enabled` and `disabled`.
     * 
     */
    private String status;

    private TableMaintenanceConfigurationIcebergCompaction() {}
    /**
     * @return Settings object for compaction.
     * See `iceberg_compaction.settings` below.
     * 
     */
    public TableMaintenanceConfigurationIcebergCompactionSettings settings() {
        return this.settings;
    }
    /**
     * @return Whether the configuration is enabled.
     * Valid values are `enabled` and `disabled`.
     * 
     */
    public String status() {
        return this.status;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(TableMaintenanceConfigurationIcebergCompaction defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private TableMaintenanceConfigurationIcebergCompactionSettings settings;
        private String status;
        public Builder() {}
        public Builder(TableMaintenanceConfigurationIcebergCompaction defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.settings = defaults.settings;
    	      this.status = defaults.status;
        }

        @CustomType.Setter
        public Builder settings(TableMaintenanceConfigurationIcebergCompactionSettings settings) {
            if (settings == null) {
              throw new MissingRequiredPropertyException("TableMaintenanceConfigurationIcebergCompaction", "settings");
            }
            this.settings = settings;
            return this;
        }
        @CustomType.Setter
        public Builder status(String status) {
            if (status == null) {
              throw new MissingRequiredPropertyException("TableMaintenanceConfigurationIcebergCompaction", "status");
            }
            this.status = status;
            return this;
        }
        public TableMaintenanceConfigurationIcebergCompaction build() {
            final var _resultValue = new TableMaintenanceConfigurationIcebergCompaction();
            _resultValue.settings = settings;
            _resultValue.status = status;
            return _resultValue;
        }
    }
}
