// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.glue.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class DataCatalogEncryptionSettingsDataCatalogEncryptionSettingsEncryptionAtRestArgs extends com.pulumi.resources.ResourceArgs {

    public static final DataCatalogEncryptionSettingsDataCatalogEncryptionSettingsEncryptionAtRestArgs Empty = new DataCatalogEncryptionSettingsDataCatalogEncryptionSettingsEncryptionAtRestArgs();

    /**
     * The encryption-at-rest mode for encrypting Data Catalog data. Valid values: `DISABLED`, `SSE-KMS`, `SSE-KMS-WITH-SERVICE-ROLE`.
     * 
     */
    @Import(name="catalogEncryptionMode", required=true)
    private Output<String> catalogEncryptionMode;

    /**
     * @return The encryption-at-rest mode for encrypting Data Catalog data. Valid values: `DISABLED`, `SSE-KMS`, `SSE-KMS-WITH-SERVICE-ROLE`.
     * 
     */
    public Output<String> catalogEncryptionMode() {
        return this.catalogEncryptionMode;
    }

    /**
     * The ARN of the AWS IAM role used for accessing encrypted Data Catalog data.
     * 
     */
    @Import(name="catalogEncryptionServiceRole")
    private @Nullable Output<String> catalogEncryptionServiceRole;

    /**
     * @return The ARN of the AWS IAM role used for accessing encrypted Data Catalog data.
     * 
     */
    public Optional<Output<String>> catalogEncryptionServiceRole() {
        return Optional.ofNullable(this.catalogEncryptionServiceRole);
    }

    /**
     * The ARN of the AWS KMS key to use for encryption at rest.
     * 
     */
    @Import(name="sseAwsKmsKeyId")
    private @Nullable Output<String> sseAwsKmsKeyId;

    /**
     * @return The ARN of the AWS KMS key to use for encryption at rest.
     * 
     */
    public Optional<Output<String>> sseAwsKmsKeyId() {
        return Optional.ofNullable(this.sseAwsKmsKeyId);
    }

    private DataCatalogEncryptionSettingsDataCatalogEncryptionSettingsEncryptionAtRestArgs() {}

    private DataCatalogEncryptionSettingsDataCatalogEncryptionSettingsEncryptionAtRestArgs(DataCatalogEncryptionSettingsDataCatalogEncryptionSettingsEncryptionAtRestArgs $) {
        this.catalogEncryptionMode = $.catalogEncryptionMode;
        this.catalogEncryptionServiceRole = $.catalogEncryptionServiceRole;
        this.sseAwsKmsKeyId = $.sseAwsKmsKeyId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DataCatalogEncryptionSettingsDataCatalogEncryptionSettingsEncryptionAtRestArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DataCatalogEncryptionSettingsDataCatalogEncryptionSettingsEncryptionAtRestArgs $;

        public Builder() {
            $ = new DataCatalogEncryptionSettingsDataCatalogEncryptionSettingsEncryptionAtRestArgs();
        }

        public Builder(DataCatalogEncryptionSettingsDataCatalogEncryptionSettingsEncryptionAtRestArgs defaults) {
            $ = new DataCatalogEncryptionSettingsDataCatalogEncryptionSettingsEncryptionAtRestArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param catalogEncryptionMode The encryption-at-rest mode for encrypting Data Catalog data. Valid values: `DISABLED`, `SSE-KMS`, `SSE-KMS-WITH-SERVICE-ROLE`.
         * 
         * @return builder
         * 
         */
        public Builder catalogEncryptionMode(Output<String> catalogEncryptionMode) {
            $.catalogEncryptionMode = catalogEncryptionMode;
            return this;
        }

        /**
         * @param catalogEncryptionMode The encryption-at-rest mode for encrypting Data Catalog data. Valid values: `DISABLED`, `SSE-KMS`, `SSE-KMS-WITH-SERVICE-ROLE`.
         * 
         * @return builder
         * 
         */
        public Builder catalogEncryptionMode(String catalogEncryptionMode) {
            return catalogEncryptionMode(Output.of(catalogEncryptionMode));
        }

        /**
         * @param catalogEncryptionServiceRole The ARN of the AWS IAM role used for accessing encrypted Data Catalog data.
         * 
         * @return builder
         * 
         */
        public Builder catalogEncryptionServiceRole(@Nullable Output<String> catalogEncryptionServiceRole) {
            $.catalogEncryptionServiceRole = catalogEncryptionServiceRole;
            return this;
        }

        /**
         * @param catalogEncryptionServiceRole The ARN of the AWS IAM role used for accessing encrypted Data Catalog data.
         * 
         * @return builder
         * 
         */
        public Builder catalogEncryptionServiceRole(String catalogEncryptionServiceRole) {
            return catalogEncryptionServiceRole(Output.of(catalogEncryptionServiceRole));
        }

        /**
         * @param sseAwsKmsKeyId The ARN of the AWS KMS key to use for encryption at rest.
         * 
         * @return builder
         * 
         */
        public Builder sseAwsKmsKeyId(@Nullable Output<String> sseAwsKmsKeyId) {
            $.sseAwsKmsKeyId = sseAwsKmsKeyId;
            return this;
        }

        /**
         * @param sseAwsKmsKeyId The ARN of the AWS KMS key to use for encryption at rest.
         * 
         * @return builder
         * 
         */
        public Builder sseAwsKmsKeyId(String sseAwsKmsKeyId) {
            return sseAwsKmsKeyId(Output.of(sseAwsKmsKeyId));
        }

        public DataCatalogEncryptionSettingsDataCatalogEncryptionSettingsEncryptionAtRestArgs build() {
            if ($.catalogEncryptionMode == null) {
                throw new MissingRequiredPropertyException("DataCatalogEncryptionSettingsDataCatalogEncryptionSettingsEncryptionAtRestArgs", "catalogEncryptionMode");
            }
            return $;
        }
    }

}
