// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3tables.inputs;

import com.pulumi.aws.s3tables.inputs.TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemovalSettingsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemovalArgs extends com.pulumi.resources.ResourceArgs {

    public static final TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemovalArgs Empty = new TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemovalArgs();

    /**
     * Settings object for unreferenced file removal.
     * See `iceberg_unreferenced_file_removal.settings` below.
     * 
     */
    @Import(name="settings", required=true)
    private Output<TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemovalSettingsArgs> settings;

    /**
     * @return Settings object for unreferenced file removal.
     * See `iceberg_unreferenced_file_removal.settings` below.
     * 
     */
    public Output<TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemovalSettingsArgs> settings() {
        return this.settings;
    }

    /**
     * Whether the configuration is enabled.
     * Valid values are `enabled` and `disabled`.
     * 
     */
    @Import(name="status", required=true)
    private Output<String> status;

    /**
     * @return Whether the configuration is enabled.
     * Valid values are `enabled` and `disabled`.
     * 
     */
    public Output<String> status() {
        return this.status;
    }

    private TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemovalArgs() {}

    private TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemovalArgs(TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemovalArgs $) {
        this.settings = $.settings;
        this.status = $.status;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemovalArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemovalArgs $;

        public Builder() {
            $ = new TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemovalArgs();
        }

        public Builder(TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemovalArgs defaults) {
            $ = new TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemovalArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param settings Settings object for unreferenced file removal.
         * See `iceberg_unreferenced_file_removal.settings` below.
         * 
         * @return builder
         * 
         */
        public Builder settings(Output<TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemovalSettingsArgs> settings) {
            $.settings = settings;
            return this;
        }

        /**
         * @param settings Settings object for unreferenced file removal.
         * See `iceberg_unreferenced_file_removal.settings` below.
         * 
         * @return builder
         * 
         */
        public Builder settings(TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemovalSettingsArgs settings) {
            return settings(Output.of(settings));
        }

        /**
         * @param status Whether the configuration is enabled.
         * Valid values are `enabled` and `disabled`.
         * 
         * @return builder
         * 
         */
        public Builder status(Output<String> status) {
            $.status = status;
            return this;
        }

        /**
         * @param status Whether the configuration is enabled.
         * Valid values are `enabled` and `disabled`.
         * 
         * @return builder
         * 
         */
        public Builder status(String status) {
            return status(Output.of(status));
        }

        public TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemovalArgs build() {
            if ($.settings == null) {
                throw new MissingRequiredPropertyException("TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemovalArgs", "settings");
            }
            if ($.status == null) {
                throw new MissingRequiredPropertyException("TableBucketMaintenanceConfigurationIcebergUnreferencedFileRemovalArgs", "status");
            }
            return $;
        }
    }

}
