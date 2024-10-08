// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.rds.inputs;

import com.pulumi.aws.rds.inputs.ExportTaskTimeoutsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ExportTaskState extends com.pulumi.resources.ResourceArgs {

    public static final ExportTaskState Empty = new ExportTaskState();

    /**
     * Data to be exported from the snapshot. If this parameter is not provided, all the snapshot data is exported. Valid values are documented in the [AWS StartExportTask API documentation](https://docs.aws.amazon.com/AmazonRDS/latest/APIReference/API_StartExportTask.html#API_StartExportTask_RequestParameters).
     * 
     */
    @Import(name="exportOnlies")
    private @Nullable Output<List<String>> exportOnlies;

    /**
     * @return Data to be exported from the snapshot. If this parameter is not provided, all the snapshot data is exported. Valid values are documented in the [AWS StartExportTask API documentation](https://docs.aws.amazon.com/AmazonRDS/latest/APIReference/API_StartExportTask.html#API_StartExportTask_RequestParameters).
     * 
     */
    public Optional<Output<List<String>>> exportOnlies() {
        return Optional.ofNullable(this.exportOnlies);
    }

    /**
     * Unique identifier for the snapshot export task.
     * 
     */
    @Import(name="exportTaskIdentifier")
    private @Nullable Output<String> exportTaskIdentifier;

    /**
     * @return Unique identifier for the snapshot export task.
     * 
     */
    public Optional<Output<String>> exportTaskIdentifier() {
        return Optional.ofNullable(this.exportTaskIdentifier);
    }

    /**
     * Reason the export failed, if it failed.
     * 
     */
    @Import(name="failureCause")
    private @Nullable Output<String> failureCause;

    /**
     * @return Reason the export failed, if it failed.
     * 
     */
    public Optional<Output<String>> failureCause() {
        return Optional.ofNullable(this.failureCause);
    }

    /**
     * ARN of the IAM role to use for writing to the Amazon S3 bucket.
     * 
     */
    @Import(name="iamRoleArn")
    private @Nullable Output<String> iamRoleArn;

    /**
     * @return ARN of the IAM role to use for writing to the Amazon S3 bucket.
     * 
     */
    public Optional<Output<String>> iamRoleArn() {
        return Optional.ofNullable(this.iamRoleArn);
    }

    /**
     * ID of the Amazon Web Services KMS key to use to encrypt the snapshot.
     * 
     */
    @Import(name="kmsKeyId")
    private @Nullable Output<String> kmsKeyId;

    /**
     * @return ID of the Amazon Web Services KMS key to use to encrypt the snapshot.
     * 
     */
    public Optional<Output<String>> kmsKeyId() {
        return Optional.ofNullable(this.kmsKeyId);
    }

    /**
     * Progress of the snapshot export task as a percentage.
     * 
     */
    @Import(name="percentProgress")
    private @Nullable Output<Integer> percentProgress;

    /**
     * @return Progress of the snapshot export task as a percentage.
     * 
     */
    public Optional<Output<Integer>> percentProgress() {
        return Optional.ofNullable(this.percentProgress);
    }

    /**
     * Name of the Amazon S3 bucket to export the snapshot to.
     * 
     */
    @Import(name="s3BucketName")
    private @Nullable Output<String> s3BucketName;

    /**
     * @return Name of the Amazon S3 bucket to export the snapshot to.
     * 
     */
    public Optional<Output<String>> s3BucketName() {
        return Optional.ofNullable(this.s3BucketName);
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
     * Time that the snapshot was created.
     * 
     */
    @Import(name="snapshotTime")
    private @Nullable Output<String> snapshotTime;

    /**
     * @return Time that the snapshot was created.
     * 
     */
    public Optional<Output<String>> snapshotTime() {
        return Optional.ofNullable(this.snapshotTime);
    }

    /**
     * Amazon Resource Name (ARN) of the snapshot to export.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="sourceArn")
    private @Nullable Output<String> sourceArn;

    /**
     * @return Amazon Resource Name (ARN) of the snapshot to export.
     * 
     * The following arguments are optional:
     * 
     */
    public Optional<Output<String>> sourceArn() {
        return Optional.ofNullable(this.sourceArn);
    }

    /**
     * Type of source for the export.
     * 
     */
    @Import(name="sourceType")
    private @Nullable Output<String> sourceType;

    /**
     * @return Type of source for the export.
     * 
     */
    public Optional<Output<String>> sourceType() {
        return Optional.ofNullable(this.sourceType);
    }

    /**
     * Status of the export task.
     * 
     */
    @Import(name="status")
    private @Nullable Output<String> status;

    /**
     * @return Status of the export task.
     * 
     */
    public Optional<Output<String>> status() {
        return Optional.ofNullable(this.status);
    }

    /**
     * Time that the snapshot export task completed.
     * 
     */
    @Import(name="taskEndTime")
    private @Nullable Output<String> taskEndTime;

    /**
     * @return Time that the snapshot export task completed.
     * 
     */
    public Optional<Output<String>> taskEndTime() {
        return Optional.ofNullable(this.taskEndTime);
    }

    /**
     * Time that the snapshot export task started.
     * 
     */
    @Import(name="taskStartTime")
    private @Nullable Output<String> taskStartTime;

    /**
     * @return Time that the snapshot export task started.
     * 
     */
    public Optional<Output<String>> taskStartTime() {
        return Optional.ofNullable(this.taskStartTime);
    }

    @Import(name="timeouts")
    private @Nullable Output<ExportTaskTimeoutsArgs> timeouts;

    public Optional<Output<ExportTaskTimeoutsArgs>> timeouts() {
        return Optional.ofNullable(this.timeouts);
    }

    /**
     * Warning about the snapshot export task, if any.
     * 
     */
    @Import(name="warningMessage")
    private @Nullable Output<String> warningMessage;

    /**
     * @return Warning about the snapshot export task, if any.
     * 
     */
    public Optional<Output<String>> warningMessage() {
        return Optional.ofNullable(this.warningMessage);
    }

    private ExportTaskState() {}

    private ExportTaskState(ExportTaskState $) {
        this.exportOnlies = $.exportOnlies;
        this.exportTaskIdentifier = $.exportTaskIdentifier;
        this.failureCause = $.failureCause;
        this.iamRoleArn = $.iamRoleArn;
        this.kmsKeyId = $.kmsKeyId;
        this.percentProgress = $.percentProgress;
        this.s3BucketName = $.s3BucketName;
        this.s3Prefix = $.s3Prefix;
        this.snapshotTime = $.snapshotTime;
        this.sourceArn = $.sourceArn;
        this.sourceType = $.sourceType;
        this.status = $.status;
        this.taskEndTime = $.taskEndTime;
        this.taskStartTime = $.taskStartTime;
        this.timeouts = $.timeouts;
        this.warningMessage = $.warningMessage;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ExportTaskState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ExportTaskState $;

        public Builder() {
            $ = new ExportTaskState();
        }

        public Builder(ExportTaskState defaults) {
            $ = new ExportTaskState(Objects.requireNonNull(defaults));
        }

        /**
         * @param exportOnlies Data to be exported from the snapshot. If this parameter is not provided, all the snapshot data is exported. Valid values are documented in the [AWS StartExportTask API documentation](https://docs.aws.amazon.com/AmazonRDS/latest/APIReference/API_StartExportTask.html#API_StartExportTask_RequestParameters).
         * 
         * @return builder
         * 
         */
        public Builder exportOnlies(@Nullable Output<List<String>> exportOnlies) {
            $.exportOnlies = exportOnlies;
            return this;
        }

        /**
         * @param exportOnlies Data to be exported from the snapshot. If this parameter is not provided, all the snapshot data is exported. Valid values are documented in the [AWS StartExportTask API documentation](https://docs.aws.amazon.com/AmazonRDS/latest/APIReference/API_StartExportTask.html#API_StartExportTask_RequestParameters).
         * 
         * @return builder
         * 
         */
        public Builder exportOnlies(List<String> exportOnlies) {
            return exportOnlies(Output.of(exportOnlies));
        }

        /**
         * @param exportOnlies Data to be exported from the snapshot. If this parameter is not provided, all the snapshot data is exported. Valid values are documented in the [AWS StartExportTask API documentation](https://docs.aws.amazon.com/AmazonRDS/latest/APIReference/API_StartExportTask.html#API_StartExportTask_RequestParameters).
         * 
         * @return builder
         * 
         */
        public Builder exportOnlies(String... exportOnlies) {
            return exportOnlies(List.of(exportOnlies));
        }

        /**
         * @param exportTaskIdentifier Unique identifier for the snapshot export task.
         * 
         * @return builder
         * 
         */
        public Builder exportTaskIdentifier(@Nullable Output<String> exportTaskIdentifier) {
            $.exportTaskIdentifier = exportTaskIdentifier;
            return this;
        }

        /**
         * @param exportTaskIdentifier Unique identifier for the snapshot export task.
         * 
         * @return builder
         * 
         */
        public Builder exportTaskIdentifier(String exportTaskIdentifier) {
            return exportTaskIdentifier(Output.of(exportTaskIdentifier));
        }

        /**
         * @param failureCause Reason the export failed, if it failed.
         * 
         * @return builder
         * 
         */
        public Builder failureCause(@Nullable Output<String> failureCause) {
            $.failureCause = failureCause;
            return this;
        }

        /**
         * @param failureCause Reason the export failed, if it failed.
         * 
         * @return builder
         * 
         */
        public Builder failureCause(String failureCause) {
            return failureCause(Output.of(failureCause));
        }

        /**
         * @param iamRoleArn ARN of the IAM role to use for writing to the Amazon S3 bucket.
         * 
         * @return builder
         * 
         */
        public Builder iamRoleArn(@Nullable Output<String> iamRoleArn) {
            $.iamRoleArn = iamRoleArn;
            return this;
        }

        /**
         * @param iamRoleArn ARN of the IAM role to use for writing to the Amazon S3 bucket.
         * 
         * @return builder
         * 
         */
        public Builder iamRoleArn(String iamRoleArn) {
            return iamRoleArn(Output.of(iamRoleArn));
        }

        /**
         * @param kmsKeyId ID of the Amazon Web Services KMS key to use to encrypt the snapshot.
         * 
         * @return builder
         * 
         */
        public Builder kmsKeyId(@Nullable Output<String> kmsKeyId) {
            $.kmsKeyId = kmsKeyId;
            return this;
        }

        /**
         * @param kmsKeyId ID of the Amazon Web Services KMS key to use to encrypt the snapshot.
         * 
         * @return builder
         * 
         */
        public Builder kmsKeyId(String kmsKeyId) {
            return kmsKeyId(Output.of(kmsKeyId));
        }

        /**
         * @param percentProgress Progress of the snapshot export task as a percentage.
         * 
         * @return builder
         * 
         */
        public Builder percentProgress(@Nullable Output<Integer> percentProgress) {
            $.percentProgress = percentProgress;
            return this;
        }

        /**
         * @param percentProgress Progress of the snapshot export task as a percentage.
         * 
         * @return builder
         * 
         */
        public Builder percentProgress(Integer percentProgress) {
            return percentProgress(Output.of(percentProgress));
        }

        /**
         * @param s3BucketName Name of the Amazon S3 bucket to export the snapshot to.
         * 
         * @return builder
         * 
         */
        public Builder s3BucketName(@Nullable Output<String> s3BucketName) {
            $.s3BucketName = s3BucketName;
            return this;
        }

        /**
         * @param s3BucketName Name of the Amazon S3 bucket to export the snapshot to.
         * 
         * @return builder
         * 
         */
        public Builder s3BucketName(String s3BucketName) {
            return s3BucketName(Output.of(s3BucketName));
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
         * @param snapshotTime Time that the snapshot was created.
         * 
         * @return builder
         * 
         */
        public Builder snapshotTime(@Nullable Output<String> snapshotTime) {
            $.snapshotTime = snapshotTime;
            return this;
        }

        /**
         * @param snapshotTime Time that the snapshot was created.
         * 
         * @return builder
         * 
         */
        public Builder snapshotTime(String snapshotTime) {
            return snapshotTime(Output.of(snapshotTime));
        }

        /**
         * @param sourceArn Amazon Resource Name (ARN) of the snapshot to export.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder sourceArn(@Nullable Output<String> sourceArn) {
            $.sourceArn = sourceArn;
            return this;
        }

        /**
         * @param sourceArn Amazon Resource Name (ARN) of the snapshot to export.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder sourceArn(String sourceArn) {
            return sourceArn(Output.of(sourceArn));
        }

        /**
         * @param sourceType Type of source for the export.
         * 
         * @return builder
         * 
         */
        public Builder sourceType(@Nullable Output<String> sourceType) {
            $.sourceType = sourceType;
            return this;
        }

        /**
         * @param sourceType Type of source for the export.
         * 
         * @return builder
         * 
         */
        public Builder sourceType(String sourceType) {
            return sourceType(Output.of(sourceType));
        }

        /**
         * @param status Status of the export task.
         * 
         * @return builder
         * 
         */
        public Builder status(@Nullable Output<String> status) {
            $.status = status;
            return this;
        }

        /**
         * @param status Status of the export task.
         * 
         * @return builder
         * 
         */
        public Builder status(String status) {
            return status(Output.of(status));
        }

        /**
         * @param taskEndTime Time that the snapshot export task completed.
         * 
         * @return builder
         * 
         */
        public Builder taskEndTime(@Nullable Output<String> taskEndTime) {
            $.taskEndTime = taskEndTime;
            return this;
        }

        /**
         * @param taskEndTime Time that the snapshot export task completed.
         * 
         * @return builder
         * 
         */
        public Builder taskEndTime(String taskEndTime) {
            return taskEndTime(Output.of(taskEndTime));
        }

        /**
         * @param taskStartTime Time that the snapshot export task started.
         * 
         * @return builder
         * 
         */
        public Builder taskStartTime(@Nullable Output<String> taskStartTime) {
            $.taskStartTime = taskStartTime;
            return this;
        }

        /**
         * @param taskStartTime Time that the snapshot export task started.
         * 
         * @return builder
         * 
         */
        public Builder taskStartTime(String taskStartTime) {
            return taskStartTime(Output.of(taskStartTime));
        }

        public Builder timeouts(@Nullable Output<ExportTaskTimeoutsArgs> timeouts) {
            $.timeouts = timeouts;
            return this;
        }

        public Builder timeouts(ExportTaskTimeoutsArgs timeouts) {
            return timeouts(Output.of(timeouts));
        }

        /**
         * @param warningMessage Warning about the snapshot export task, if any.
         * 
         * @return builder
         * 
         */
        public Builder warningMessage(@Nullable Output<String> warningMessage) {
            $.warningMessage = warningMessage;
            return this;
        }

        /**
         * @param warningMessage Warning about the snapshot export task, if any.
         * 
         * @return builder
         * 
         */
        public Builder warningMessage(String warningMessage) {
            return warningMessage(Output.of(warningMessage));
        }

        public ExportTaskState build() {
            return $;
        }
    }

}
