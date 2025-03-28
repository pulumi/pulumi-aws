// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dynamodb.inputs;

import com.pulumi.aws.dynamodb.inputs.TableExportIncrementalExportSpecificationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class TableExportState extends com.pulumi.resources.ResourceArgs {

    public static final TableExportState Empty = new TableExportState();

    /**
     * ARN of the Table Export.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return ARN of the Table Export.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * Billable size of the table export.
     * 
     */
    @Import(name="billedSizeInBytes")
    private @Nullable Output<Integer> billedSizeInBytes;

    /**
     * @return Billable size of the table export.
     * 
     */
    public Optional<Output<Integer>> billedSizeInBytes() {
        return Optional.ofNullable(this.billedSizeInBytes);
    }

    /**
     * Time at which the export task completed.
     * 
     */
    @Import(name="endTime")
    private @Nullable Output<String> endTime;

    /**
     * @return Time at which the export task completed.
     * 
     */
    public Optional<Output<String>> endTime() {
        return Optional.ofNullable(this.endTime);
    }

    /**
     * Format for the exported data. Valid values are: `DYNAMODB_JSON`, `ION`. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport.Output.html#S3DataExport.Output_Data) for more information on these export formats. Default is `DYNAMODB_JSON`.
     * 
     */
    @Import(name="exportFormat")
    private @Nullable Output<String> exportFormat;

    /**
     * @return Format for the exported data. Valid values are: `DYNAMODB_JSON`, `ION`. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport.Output.html#S3DataExport.Output_Data) for more information on these export formats. Default is `DYNAMODB_JSON`.
     * 
     */
    public Optional<Output<String>> exportFormat() {
        return Optional.ofNullable(this.exportFormat);
    }

    /**
     * Status of the export - export can be in one of the following states `IN_PROGRESS`, `COMPLETED`, or `FAILED`.
     * 
     */
    @Import(name="exportStatus")
    private @Nullable Output<String> exportStatus;

    /**
     * @return Status of the export - export can be in one of the following states `IN_PROGRESS`, `COMPLETED`, or `FAILED`.
     * 
     */
    public Optional<Output<String>> exportStatus() {
        return Optional.ofNullable(this.exportStatus);
    }

    /**
     * Time in RFC3339 format from which to export table data. The table export will be a snapshot of the table&#39;s state at this point in time. Omitting this value will result in a snapshot from the current time.
     * 
     */
    @Import(name="exportTime")
    private @Nullable Output<String> exportTime;

    /**
     * @return Time in RFC3339 format from which to export table data. The table export will be a snapshot of the table&#39;s state at this point in time. Omitting this value will result in a snapshot from the current time.
     * 
     */
    public Optional<Output<String>> exportTime() {
        return Optional.ofNullable(this.exportTime);
    }

    /**
     * Whether to execute as a full export or incremental export. Valid values are: `FULL_EXPORT`, `INCREMENTAL_EXPORT`. Defaults to `FULL_EXPORT`. If `INCREMENTAL_EXPORT` is provided, the `incremental_export_specification` argument must also be provided.
     * `incremental_export_specification` - (Optional, Forces new resource) Parameters specific to an incremental export. See `incremental_export_specification` Block for details.
     * 
     */
    @Import(name="exportType")
    private @Nullable Output<String> exportType;

    /**
     * @return Whether to execute as a full export or incremental export. Valid values are: `FULL_EXPORT`, `INCREMENTAL_EXPORT`. Defaults to `FULL_EXPORT`. If `INCREMENTAL_EXPORT` is provided, the `incremental_export_specification` argument must also be provided.
     * `incremental_export_specification` - (Optional, Forces new resource) Parameters specific to an incremental export. See `incremental_export_specification` Block for details.
     * 
     */
    public Optional<Output<String>> exportType() {
        return Optional.ofNullable(this.exportType);
    }

    @Import(name="incrementalExportSpecification")
    private @Nullable Output<TableExportIncrementalExportSpecificationArgs> incrementalExportSpecification;

    public Optional<Output<TableExportIncrementalExportSpecificationArgs>> incrementalExportSpecification() {
        return Optional.ofNullable(this.incrementalExportSpecification);
    }

    /**
     * Number of items exported.
     * 
     */
    @Import(name="itemCount")
    private @Nullable Output<Integer> itemCount;

    /**
     * @return Number of items exported.
     * 
     */
    public Optional<Output<Integer>> itemCount() {
        return Optional.ofNullable(this.itemCount);
    }

    /**
     * Name of the manifest file for the export task. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport.Output.html#S3DataExport.Output_Manifest) for more information on this manifest file.
     * 
     */
    @Import(name="manifestFilesS3Key")
    private @Nullable Output<String> manifestFilesS3Key;

    /**
     * @return Name of the manifest file for the export task. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport.Output.html#S3DataExport.Output_Manifest) for more information on this manifest file.
     * 
     */
    public Optional<Output<String>> manifestFilesS3Key() {
        return Optional.ofNullable(this.manifestFilesS3Key);
    }

    /**
     * Name of the Amazon S3 bucket to export the snapshot to. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport_Requesting.html#S3DataExport_Requesting_Permissions) for information on how configure this S3 bucket.
     * 
     */
    @Import(name="s3Bucket")
    private @Nullable Output<String> s3Bucket;

    /**
     * @return Name of the Amazon S3 bucket to export the snapshot to. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport_Requesting.html#S3DataExport_Requesting_Permissions) for information on how configure this S3 bucket.
     * 
     */
    public Optional<Output<String>> s3Bucket() {
        return Optional.ofNullable(this.s3Bucket);
    }

    /**
     * ID of the AWS account that owns the bucket the export will be stored in.
     * 
     */
    @Import(name="s3BucketOwner")
    private @Nullable Output<String> s3BucketOwner;

    /**
     * @return ID of the AWS account that owns the bucket the export will be stored in.
     * 
     */
    public Optional<Output<String>> s3BucketOwner() {
        return Optional.ofNullable(this.s3BucketOwner);
    }

    /**
     * Amazon S3 bucket prefix to use as the file name and path of the exported snapshot.
     * 
     */
    @Import(name="s3Prefix")
    private @Nullable Output<String> s3Prefix;

    /**
     * @return Amazon S3 bucket prefix to use as the file name and path of the exported snapshot.
     * 
     */
    public Optional<Output<String>> s3Prefix() {
        return Optional.ofNullable(this.s3Prefix);
    }

    /**
     * Type of encryption used on the bucket where export data will be stored. Valid values are: `AES256`, `KMS`.
     * 
     */
    @Import(name="s3SseAlgorithm")
    private @Nullable Output<String> s3SseAlgorithm;

    /**
     * @return Type of encryption used on the bucket where export data will be stored. Valid values are: `AES256`, `KMS`.
     * 
     */
    public Optional<Output<String>> s3SseAlgorithm() {
        return Optional.ofNullable(this.s3SseAlgorithm);
    }

    /**
     * ID of the AWS KMS managed key used to encrypt the S3 bucket where export data will be stored (if applicable).
     * 
     */
    @Import(name="s3SseKmsKeyId")
    private @Nullable Output<String> s3SseKmsKeyId;

    /**
     * @return ID of the AWS KMS managed key used to encrypt the S3 bucket where export data will be stored (if applicable).
     * 
     */
    public Optional<Output<String>> s3SseKmsKeyId() {
        return Optional.ofNullable(this.s3SseKmsKeyId);
    }

    /**
     * Time at which the export task began.
     * 
     */
    @Import(name="startTime")
    private @Nullable Output<String> startTime;

    /**
     * @return Time at which the export task began.
     * 
     */
    public Optional<Output<String>> startTime() {
        return Optional.ofNullable(this.startTime);
    }

    /**
     * ARN associated with the table to export.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="tableArn")
    private @Nullable Output<String> tableArn;

    /**
     * @return ARN associated with the table to export.
     * 
     * The following arguments are optional:
     * 
     */
    public Optional<Output<String>> tableArn() {
        return Optional.ofNullable(this.tableArn);
    }

    private TableExportState() {}

    private TableExportState(TableExportState $) {
        this.arn = $.arn;
        this.billedSizeInBytes = $.billedSizeInBytes;
        this.endTime = $.endTime;
        this.exportFormat = $.exportFormat;
        this.exportStatus = $.exportStatus;
        this.exportTime = $.exportTime;
        this.exportType = $.exportType;
        this.incrementalExportSpecification = $.incrementalExportSpecification;
        this.itemCount = $.itemCount;
        this.manifestFilesS3Key = $.manifestFilesS3Key;
        this.s3Bucket = $.s3Bucket;
        this.s3BucketOwner = $.s3BucketOwner;
        this.s3Prefix = $.s3Prefix;
        this.s3SseAlgorithm = $.s3SseAlgorithm;
        this.s3SseKmsKeyId = $.s3SseKmsKeyId;
        this.startTime = $.startTime;
        this.tableArn = $.tableArn;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(TableExportState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private TableExportState $;

        public Builder() {
            $ = new TableExportState();
        }

        public Builder(TableExportState defaults) {
            $ = new TableExportState(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn ARN of the Table Export.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn ARN of the Table Export.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param billedSizeInBytes Billable size of the table export.
         * 
         * @return builder
         * 
         */
        public Builder billedSizeInBytes(@Nullable Output<Integer> billedSizeInBytes) {
            $.billedSizeInBytes = billedSizeInBytes;
            return this;
        }

        /**
         * @param billedSizeInBytes Billable size of the table export.
         * 
         * @return builder
         * 
         */
        public Builder billedSizeInBytes(Integer billedSizeInBytes) {
            return billedSizeInBytes(Output.of(billedSizeInBytes));
        }

        /**
         * @param endTime Time at which the export task completed.
         * 
         * @return builder
         * 
         */
        public Builder endTime(@Nullable Output<String> endTime) {
            $.endTime = endTime;
            return this;
        }

        /**
         * @param endTime Time at which the export task completed.
         * 
         * @return builder
         * 
         */
        public Builder endTime(String endTime) {
            return endTime(Output.of(endTime));
        }

        /**
         * @param exportFormat Format for the exported data. Valid values are: `DYNAMODB_JSON`, `ION`. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport.Output.html#S3DataExport.Output_Data) for more information on these export formats. Default is `DYNAMODB_JSON`.
         * 
         * @return builder
         * 
         */
        public Builder exportFormat(@Nullable Output<String> exportFormat) {
            $.exportFormat = exportFormat;
            return this;
        }

        /**
         * @param exportFormat Format for the exported data. Valid values are: `DYNAMODB_JSON`, `ION`. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport.Output.html#S3DataExport.Output_Data) for more information on these export formats. Default is `DYNAMODB_JSON`.
         * 
         * @return builder
         * 
         */
        public Builder exportFormat(String exportFormat) {
            return exportFormat(Output.of(exportFormat));
        }

        /**
         * @param exportStatus Status of the export - export can be in one of the following states `IN_PROGRESS`, `COMPLETED`, or `FAILED`.
         * 
         * @return builder
         * 
         */
        public Builder exportStatus(@Nullable Output<String> exportStatus) {
            $.exportStatus = exportStatus;
            return this;
        }

        /**
         * @param exportStatus Status of the export - export can be in one of the following states `IN_PROGRESS`, `COMPLETED`, or `FAILED`.
         * 
         * @return builder
         * 
         */
        public Builder exportStatus(String exportStatus) {
            return exportStatus(Output.of(exportStatus));
        }

        /**
         * @param exportTime Time in RFC3339 format from which to export table data. The table export will be a snapshot of the table&#39;s state at this point in time. Omitting this value will result in a snapshot from the current time.
         * 
         * @return builder
         * 
         */
        public Builder exportTime(@Nullable Output<String> exportTime) {
            $.exportTime = exportTime;
            return this;
        }

        /**
         * @param exportTime Time in RFC3339 format from which to export table data. The table export will be a snapshot of the table&#39;s state at this point in time. Omitting this value will result in a snapshot from the current time.
         * 
         * @return builder
         * 
         */
        public Builder exportTime(String exportTime) {
            return exportTime(Output.of(exportTime));
        }

        /**
         * @param exportType Whether to execute as a full export or incremental export. Valid values are: `FULL_EXPORT`, `INCREMENTAL_EXPORT`. Defaults to `FULL_EXPORT`. If `INCREMENTAL_EXPORT` is provided, the `incremental_export_specification` argument must also be provided.
         * `incremental_export_specification` - (Optional, Forces new resource) Parameters specific to an incremental export. See `incremental_export_specification` Block for details.
         * 
         * @return builder
         * 
         */
        public Builder exportType(@Nullable Output<String> exportType) {
            $.exportType = exportType;
            return this;
        }

        /**
         * @param exportType Whether to execute as a full export or incremental export. Valid values are: `FULL_EXPORT`, `INCREMENTAL_EXPORT`. Defaults to `FULL_EXPORT`. If `INCREMENTAL_EXPORT` is provided, the `incremental_export_specification` argument must also be provided.
         * `incremental_export_specification` - (Optional, Forces new resource) Parameters specific to an incremental export. See `incremental_export_specification` Block for details.
         * 
         * @return builder
         * 
         */
        public Builder exportType(String exportType) {
            return exportType(Output.of(exportType));
        }

        public Builder incrementalExportSpecification(@Nullable Output<TableExportIncrementalExportSpecificationArgs> incrementalExportSpecification) {
            $.incrementalExportSpecification = incrementalExportSpecification;
            return this;
        }

        public Builder incrementalExportSpecification(TableExportIncrementalExportSpecificationArgs incrementalExportSpecification) {
            return incrementalExportSpecification(Output.of(incrementalExportSpecification));
        }

        /**
         * @param itemCount Number of items exported.
         * 
         * @return builder
         * 
         */
        public Builder itemCount(@Nullable Output<Integer> itemCount) {
            $.itemCount = itemCount;
            return this;
        }

        /**
         * @param itemCount Number of items exported.
         * 
         * @return builder
         * 
         */
        public Builder itemCount(Integer itemCount) {
            return itemCount(Output.of(itemCount));
        }

        /**
         * @param manifestFilesS3Key Name of the manifest file for the export task. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport.Output.html#S3DataExport.Output_Manifest) for more information on this manifest file.
         * 
         * @return builder
         * 
         */
        public Builder manifestFilesS3Key(@Nullable Output<String> manifestFilesS3Key) {
            $.manifestFilesS3Key = manifestFilesS3Key;
            return this;
        }

        /**
         * @param manifestFilesS3Key Name of the manifest file for the export task. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport.Output.html#S3DataExport.Output_Manifest) for more information on this manifest file.
         * 
         * @return builder
         * 
         */
        public Builder manifestFilesS3Key(String manifestFilesS3Key) {
            return manifestFilesS3Key(Output.of(manifestFilesS3Key));
        }

        /**
         * @param s3Bucket Name of the Amazon S3 bucket to export the snapshot to. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport_Requesting.html#S3DataExport_Requesting_Permissions) for information on how configure this S3 bucket.
         * 
         * @return builder
         * 
         */
        public Builder s3Bucket(@Nullable Output<String> s3Bucket) {
            $.s3Bucket = s3Bucket;
            return this;
        }

        /**
         * @param s3Bucket Name of the Amazon S3 bucket to export the snapshot to. See the [AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/S3DataExport_Requesting.html#S3DataExport_Requesting_Permissions) for information on how configure this S3 bucket.
         * 
         * @return builder
         * 
         */
        public Builder s3Bucket(String s3Bucket) {
            return s3Bucket(Output.of(s3Bucket));
        }

        /**
         * @param s3BucketOwner ID of the AWS account that owns the bucket the export will be stored in.
         * 
         * @return builder
         * 
         */
        public Builder s3BucketOwner(@Nullable Output<String> s3BucketOwner) {
            $.s3BucketOwner = s3BucketOwner;
            return this;
        }

        /**
         * @param s3BucketOwner ID of the AWS account that owns the bucket the export will be stored in.
         * 
         * @return builder
         * 
         */
        public Builder s3BucketOwner(String s3BucketOwner) {
            return s3BucketOwner(Output.of(s3BucketOwner));
        }

        /**
         * @param s3Prefix Amazon S3 bucket prefix to use as the file name and path of the exported snapshot.
         * 
         * @return builder
         * 
         */
        public Builder s3Prefix(@Nullable Output<String> s3Prefix) {
            $.s3Prefix = s3Prefix;
            return this;
        }

        /**
         * @param s3Prefix Amazon S3 bucket prefix to use as the file name and path of the exported snapshot.
         * 
         * @return builder
         * 
         */
        public Builder s3Prefix(String s3Prefix) {
            return s3Prefix(Output.of(s3Prefix));
        }

        /**
         * @param s3SseAlgorithm Type of encryption used on the bucket where export data will be stored. Valid values are: `AES256`, `KMS`.
         * 
         * @return builder
         * 
         */
        public Builder s3SseAlgorithm(@Nullable Output<String> s3SseAlgorithm) {
            $.s3SseAlgorithm = s3SseAlgorithm;
            return this;
        }

        /**
         * @param s3SseAlgorithm Type of encryption used on the bucket where export data will be stored. Valid values are: `AES256`, `KMS`.
         * 
         * @return builder
         * 
         */
        public Builder s3SseAlgorithm(String s3SseAlgorithm) {
            return s3SseAlgorithm(Output.of(s3SseAlgorithm));
        }

        /**
         * @param s3SseKmsKeyId ID of the AWS KMS managed key used to encrypt the S3 bucket where export data will be stored (if applicable).
         * 
         * @return builder
         * 
         */
        public Builder s3SseKmsKeyId(@Nullable Output<String> s3SseKmsKeyId) {
            $.s3SseKmsKeyId = s3SseKmsKeyId;
            return this;
        }

        /**
         * @param s3SseKmsKeyId ID of the AWS KMS managed key used to encrypt the S3 bucket where export data will be stored (if applicable).
         * 
         * @return builder
         * 
         */
        public Builder s3SseKmsKeyId(String s3SseKmsKeyId) {
            return s3SseKmsKeyId(Output.of(s3SseKmsKeyId));
        }

        /**
         * @param startTime Time at which the export task began.
         * 
         * @return builder
         * 
         */
        public Builder startTime(@Nullable Output<String> startTime) {
            $.startTime = startTime;
            return this;
        }

        /**
         * @param startTime Time at which the export task began.
         * 
         * @return builder
         * 
         */
        public Builder startTime(String startTime) {
            return startTime(Output.of(startTime));
        }

        /**
         * @param tableArn ARN associated with the table to export.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder tableArn(@Nullable Output<String> tableArn) {
            $.tableArn = tableArn;
            return this;
        }

        /**
         * @param tableArn ARN associated with the table to export.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder tableArn(String tableArn) {
            return tableArn(Output.of(tableArn));
        }

        public TableExportState build() {
            return $;
        }
    }

}
