// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3tables.outputs;

import com.pulumi.aws.s3tables.outputs.TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemoval;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.Objects;

@CustomType
public final class TableBucketMaintenanceConfiguration {
    /**
     * @return A single Iceberg unreferenced file removal settings object.
     * See `iceberg_unreferenced_file_removal` below.
     * 
     */
    private TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemoval icebergUnreferencedFileRemoval;

    private TableBucketMaintenanceConfiguration() {}
    /**
     * @return A single Iceberg unreferenced file removal settings object.
     * See `iceberg_unreferenced_file_removal` below.
     * 
     */
    public TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemoval icebergUnreferencedFileRemoval() {
        return this.icebergUnreferencedFileRemoval;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(TableBucketMaintenanceConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemoval icebergUnreferencedFileRemoval;
        public Builder() {}
        public Builder(TableBucketMaintenanceConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.icebergUnreferencedFileRemoval = defaults.icebergUnreferencedFileRemoval;
        }

        @CustomType.Setter
        public Builder icebergUnreferencedFileRemoval(TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemoval icebergUnreferencedFileRemoval) {
            if (icebergUnreferencedFileRemoval == null) {
              throw new MissingRequiredPropertyException("TableBucketMaintenanceConfiguration", "icebergUnreferencedFileRemoval");
            }
            this.icebergUnreferencedFileRemoval = icebergUnreferencedFileRemoval;
            return this;
        }
        public TableBucketMaintenanceConfiguration build() {
            final var _resultValue = new TableBucketMaintenanceConfiguration();
            _resultValue.icebergUnreferencedFileRemoval = icebergUnreferencedFileRemoval;
            return _resultValue;
        }
    }
}
