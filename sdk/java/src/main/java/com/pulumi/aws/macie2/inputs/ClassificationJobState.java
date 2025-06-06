// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.macie2.inputs;

import com.pulumi.aws.macie2.inputs.ClassificationJobS3JobDefinitionArgs;
import com.pulumi.aws.macie2.inputs.ClassificationJobScheduleFrequencyArgs;
import com.pulumi.aws.macie2.inputs.ClassificationJobUserPausedDetailArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ClassificationJobState extends com.pulumi.resources.ResourceArgs {

    public static final ClassificationJobState Empty = new ClassificationJobState();

    /**
     * The date and time, in UTC and extended RFC 3339 format, when the job was created.
     * 
     */
    @Import(name="createdAt")
    private @Nullable Output<String> createdAt;

    /**
     * @return The date and time, in UTC and extended RFC 3339 format, when the job was created.
     * 
     */
    public Optional<Output<String>> createdAt() {
        return Optional.ofNullable(this.createdAt);
    }

    /**
     * The custom data identifiers to use for data analysis and classification.
     * 
     */
    @Import(name="customDataIdentifierIds")
    private @Nullable Output<List<String>> customDataIdentifierIds;

    /**
     * @return The custom data identifiers to use for data analysis and classification.
     * 
     */
    public Optional<Output<List<String>>> customDataIdentifierIds() {
        return Optional.ofNullable(this.customDataIdentifierIds);
    }

    /**
     * A custom description of the job. The description can contain as many as 200 characters.
     * 
     */
    @Import(name="description")
    private @Nullable Output<String> description;

    /**
     * @return A custom description of the job. The description can contain as many as 200 characters.
     * 
     */
    public Optional<Output<String>> description() {
        return Optional.ofNullable(this.description);
    }

    /**
     * Specifies whether to analyze all existing, eligible objects immediately after the job is created.
     * 
     */
    @Import(name="initialRun")
    private @Nullable Output<Boolean> initialRun;

    /**
     * @return Specifies whether to analyze all existing, eligible objects immediately after the job is created.
     * 
     */
    public Optional<Output<Boolean>> initialRun() {
        return Optional.ofNullable(this.initialRun);
    }

    @Import(name="jobArn")
    private @Nullable Output<String> jobArn;

    public Optional<Output<String>> jobArn() {
        return Optional.ofNullable(this.jobArn);
    }

    @Import(name="jobId")
    private @Nullable Output<String> jobId;

    public Optional<Output<String>> jobId() {
        return Optional.ofNullable(this.jobId);
    }

    /**
     * The status for the job. Valid values are: `CANCELLED`, `RUNNING` and `USER_PAUSED`
     * 
     */
    @Import(name="jobStatus")
    private @Nullable Output<String> jobStatus;

    /**
     * @return The status for the job. Valid values are: `CANCELLED`, `RUNNING` and `USER_PAUSED`
     * 
     */
    public Optional<Output<String>> jobStatus() {
        return Optional.ofNullable(this.jobStatus);
    }

    /**
     * The schedule for running the job. Valid values are: `ONE_TIME` - Run the job only once. If you specify this value, don&#39;t specify a value for the `schedule_frequency` property. `SCHEDULED` - Run the job on a daily, weekly, or monthly basis. If you specify this value, use the `schedule_frequency` property to define the recurrence pattern for the job.
     * 
     */
    @Import(name="jobType")
    private @Nullable Output<String> jobType;

    /**
     * @return The schedule for running the job. Valid values are: `ONE_TIME` - Run the job only once. If you specify this value, don&#39;t specify a value for the `schedule_frequency` property. `SCHEDULED` - Run the job on a daily, weekly, or monthly basis. If you specify this value, use the `schedule_frequency` property to define the recurrence pattern for the job.
     * 
     */
    public Optional<Output<String>> jobType() {
        return Optional.ofNullable(this.jobType);
    }

    /**
     * A custom name for the job. The name can contain as many as 500 characters. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return A custom name for the job. The name can contain as many as 500 characters. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Creates a unique name beginning with the specified prefix. Conflicts with `name`.
     * 
     */
    @Import(name="namePrefix")
    private @Nullable Output<String> namePrefix;

    /**
     * @return Creates a unique name beginning with the specified prefix. Conflicts with `name`.
     * 
     */
    public Optional<Output<String>> namePrefix() {
        return Optional.ofNullable(this.namePrefix);
    }

    /**
     * The S3 buckets that contain the objects to analyze, and the scope of that analysis. (documented below)
     * 
     */
    @Import(name="s3JobDefinition")
    private @Nullable Output<ClassificationJobS3JobDefinitionArgs> s3JobDefinition;

    /**
     * @return The S3 buckets that contain the objects to analyze, and the scope of that analysis. (documented below)
     * 
     */
    public Optional<Output<ClassificationJobS3JobDefinitionArgs>> s3JobDefinition() {
        return Optional.ofNullable(this.s3JobDefinition);
    }

    /**
     * The sampling depth, as a percentage, to apply when processing objects. This value determines the percentage of eligible objects that the job analyzes. If this value is less than 100, Amazon Macie selects the objects to analyze at random, up to the specified percentage, and analyzes all the data in those objects.
     * 
     */
    @Import(name="samplingPercentage")
    private @Nullable Output<Integer> samplingPercentage;

    /**
     * @return The sampling depth, as a percentage, to apply when processing objects. This value determines the percentage of eligible objects that the job analyzes. If this value is less than 100, Amazon Macie selects the objects to analyze at random, up to the specified percentage, and analyzes all the data in those objects.
     * 
     */
    public Optional<Output<Integer>> samplingPercentage() {
        return Optional.ofNullable(this.samplingPercentage);
    }

    /**
     * The recurrence pattern for running the job. To run the job only once, don&#39;t specify a value for this property and set the value for the `job_type` property to `ONE_TIME`. (documented below)
     * 
     */
    @Import(name="scheduleFrequency")
    private @Nullable Output<ClassificationJobScheduleFrequencyArgs> scheduleFrequency;

    /**
     * @return The recurrence pattern for running the job. To run the job only once, don&#39;t specify a value for this property and set the value for the `job_type` property to `ONE_TIME`. (documented below)
     * 
     */
    public Optional<Output<ClassificationJobScheduleFrequencyArgs>> scheduleFrequency() {
        return Optional.ofNullable(this.scheduleFrequency);
    }

    /**
     * Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Import(name="tagsAll")
    private @Nullable Output<Map<String,String>> tagsAll;

    /**
     * @return A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    public Optional<Output<Map<String,String>>> tagsAll() {
        return Optional.ofNullable(this.tagsAll);
    }

    /**
     * If the current status of the job is `USER_PAUSED`, specifies when the job was paused and when the job or job run will expire and be canceled if it isn&#39;t resumed. This value is present only if the value for `job-status` is `USER_PAUSED`.
     * 
     */
    @Import(name="userPausedDetails")
    private @Nullable Output<List<ClassificationJobUserPausedDetailArgs>> userPausedDetails;

    /**
     * @return If the current status of the job is `USER_PAUSED`, specifies when the job was paused and when the job or job run will expire and be canceled if it isn&#39;t resumed. This value is present only if the value for `job-status` is `USER_PAUSED`.
     * 
     */
    public Optional<Output<List<ClassificationJobUserPausedDetailArgs>>> userPausedDetails() {
        return Optional.ofNullable(this.userPausedDetails);
    }

    private ClassificationJobState() {}

    private ClassificationJobState(ClassificationJobState $) {
        this.createdAt = $.createdAt;
        this.customDataIdentifierIds = $.customDataIdentifierIds;
        this.description = $.description;
        this.initialRun = $.initialRun;
        this.jobArn = $.jobArn;
        this.jobId = $.jobId;
        this.jobStatus = $.jobStatus;
        this.jobType = $.jobType;
        this.name = $.name;
        this.namePrefix = $.namePrefix;
        this.s3JobDefinition = $.s3JobDefinition;
        this.samplingPercentage = $.samplingPercentage;
        this.scheduleFrequency = $.scheduleFrequency;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
        this.userPausedDetails = $.userPausedDetails;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ClassificationJobState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ClassificationJobState $;

        public Builder() {
            $ = new ClassificationJobState();
        }

        public Builder(ClassificationJobState defaults) {
            $ = new ClassificationJobState(Objects.requireNonNull(defaults));
        }

        /**
         * @param createdAt The date and time, in UTC and extended RFC 3339 format, when the job was created.
         * 
         * @return builder
         * 
         */
        public Builder createdAt(@Nullable Output<String> createdAt) {
            $.createdAt = createdAt;
            return this;
        }

        /**
         * @param createdAt The date and time, in UTC and extended RFC 3339 format, when the job was created.
         * 
         * @return builder
         * 
         */
        public Builder createdAt(String createdAt) {
            return createdAt(Output.of(createdAt));
        }

        /**
         * @param customDataIdentifierIds The custom data identifiers to use for data analysis and classification.
         * 
         * @return builder
         * 
         */
        public Builder customDataIdentifierIds(@Nullable Output<List<String>> customDataIdentifierIds) {
            $.customDataIdentifierIds = customDataIdentifierIds;
            return this;
        }

        /**
         * @param customDataIdentifierIds The custom data identifiers to use for data analysis and classification.
         * 
         * @return builder
         * 
         */
        public Builder customDataIdentifierIds(List<String> customDataIdentifierIds) {
            return customDataIdentifierIds(Output.of(customDataIdentifierIds));
        }

        /**
         * @param customDataIdentifierIds The custom data identifiers to use for data analysis and classification.
         * 
         * @return builder
         * 
         */
        public Builder customDataIdentifierIds(String... customDataIdentifierIds) {
            return customDataIdentifierIds(List.of(customDataIdentifierIds));
        }

        /**
         * @param description A custom description of the job. The description can contain as many as 200 characters.
         * 
         * @return builder
         * 
         */
        public Builder description(@Nullable Output<String> description) {
            $.description = description;
            return this;
        }

        /**
         * @param description A custom description of the job. The description can contain as many as 200 characters.
         * 
         * @return builder
         * 
         */
        public Builder description(String description) {
            return description(Output.of(description));
        }

        /**
         * @param initialRun Specifies whether to analyze all existing, eligible objects immediately after the job is created.
         * 
         * @return builder
         * 
         */
        public Builder initialRun(@Nullable Output<Boolean> initialRun) {
            $.initialRun = initialRun;
            return this;
        }

        /**
         * @param initialRun Specifies whether to analyze all existing, eligible objects immediately after the job is created.
         * 
         * @return builder
         * 
         */
        public Builder initialRun(Boolean initialRun) {
            return initialRun(Output.of(initialRun));
        }

        public Builder jobArn(@Nullable Output<String> jobArn) {
            $.jobArn = jobArn;
            return this;
        }

        public Builder jobArn(String jobArn) {
            return jobArn(Output.of(jobArn));
        }

        public Builder jobId(@Nullable Output<String> jobId) {
            $.jobId = jobId;
            return this;
        }

        public Builder jobId(String jobId) {
            return jobId(Output.of(jobId));
        }

        /**
         * @param jobStatus The status for the job. Valid values are: `CANCELLED`, `RUNNING` and `USER_PAUSED`
         * 
         * @return builder
         * 
         */
        public Builder jobStatus(@Nullable Output<String> jobStatus) {
            $.jobStatus = jobStatus;
            return this;
        }

        /**
         * @param jobStatus The status for the job. Valid values are: `CANCELLED`, `RUNNING` and `USER_PAUSED`
         * 
         * @return builder
         * 
         */
        public Builder jobStatus(String jobStatus) {
            return jobStatus(Output.of(jobStatus));
        }

        /**
         * @param jobType The schedule for running the job. Valid values are: `ONE_TIME` - Run the job only once. If you specify this value, don&#39;t specify a value for the `schedule_frequency` property. `SCHEDULED` - Run the job on a daily, weekly, or monthly basis. If you specify this value, use the `schedule_frequency` property to define the recurrence pattern for the job.
         * 
         * @return builder
         * 
         */
        public Builder jobType(@Nullable Output<String> jobType) {
            $.jobType = jobType;
            return this;
        }

        /**
         * @param jobType The schedule for running the job. Valid values are: `ONE_TIME` - Run the job only once. If you specify this value, don&#39;t specify a value for the `schedule_frequency` property. `SCHEDULED` - Run the job on a daily, weekly, or monthly basis. If you specify this value, use the `schedule_frequency` property to define the recurrence pattern for the job.
         * 
         * @return builder
         * 
         */
        public Builder jobType(String jobType) {
            return jobType(Output.of(jobType));
        }

        /**
         * @param name A custom name for the job. The name can contain as many as 500 characters. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name A custom name for the job. The name can contain as many as 500 characters. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param namePrefix Creates a unique name beginning with the specified prefix. Conflicts with `name`.
         * 
         * @return builder
         * 
         */
        public Builder namePrefix(@Nullable Output<String> namePrefix) {
            $.namePrefix = namePrefix;
            return this;
        }

        /**
         * @param namePrefix Creates a unique name beginning with the specified prefix. Conflicts with `name`.
         * 
         * @return builder
         * 
         */
        public Builder namePrefix(String namePrefix) {
            return namePrefix(Output.of(namePrefix));
        }

        /**
         * @param s3JobDefinition The S3 buckets that contain the objects to analyze, and the scope of that analysis. (documented below)
         * 
         * @return builder
         * 
         */
        public Builder s3JobDefinition(@Nullable Output<ClassificationJobS3JobDefinitionArgs> s3JobDefinition) {
            $.s3JobDefinition = s3JobDefinition;
            return this;
        }

        /**
         * @param s3JobDefinition The S3 buckets that contain the objects to analyze, and the scope of that analysis. (documented below)
         * 
         * @return builder
         * 
         */
        public Builder s3JobDefinition(ClassificationJobS3JobDefinitionArgs s3JobDefinition) {
            return s3JobDefinition(Output.of(s3JobDefinition));
        }

        /**
         * @param samplingPercentage The sampling depth, as a percentage, to apply when processing objects. This value determines the percentage of eligible objects that the job analyzes. If this value is less than 100, Amazon Macie selects the objects to analyze at random, up to the specified percentage, and analyzes all the data in those objects.
         * 
         * @return builder
         * 
         */
        public Builder samplingPercentage(@Nullable Output<Integer> samplingPercentage) {
            $.samplingPercentage = samplingPercentage;
            return this;
        }

        /**
         * @param samplingPercentage The sampling depth, as a percentage, to apply when processing objects. This value determines the percentage of eligible objects that the job analyzes. If this value is less than 100, Amazon Macie selects the objects to analyze at random, up to the specified percentage, and analyzes all the data in those objects.
         * 
         * @return builder
         * 
         */
        public Builder samplingPercentage(Integer samplingPercentage) {
            return samplingPercentage(Output.of(samplingPercentage));
        }

        /**
         * @param scheduleFrequency The recurrence pattern for running the job. To run the job only once, don&#39;t specify a value for this property and set the value for the `job_type` property to `ONE_TIME`. (documented below)
         * 
         * @return builder
         * 
         */
        public Builder scheduleFrequency(@Nullable Output<ClassificationJobScheduleFrequencyArgs> scheduleFrequency) {
            $.scheduleFrequency = scheduleFrequency;
            return this;
        }

        /**
         * @param scheduleFrequency The recurrence pattern for running the job. To run the job only once, don&#39;t specify a value for this property and set the value for the `job_type` property to `ONE_TIME`. (documented below)
         * 
         * @return builder
         * 
         */
        public Builder scheduleFrequency(ClassificationJobScheduleFrequencyArgs scheduleFrequency) {
            return scheduleFrequency(Output.of(scheduleFrequency));
        }

        /**
         * @param tags Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param tagsAll A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(@Nullable Output<Map<String,String>> tagsAll) {
            $.tagsAll = tagsAll;
            return this;
        }

        /**
         * @param tagsAll A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(Map<String,String> tagsAll) {
            return tagsAll(Output.of(tagsAll));
        }

        /**
         * @param userPausedDetails If the current status of the job is `USER_PAUSED`, specifies when the job was paused and when the job or job run will expire and be canceled if it isn&#39;t resumed. This value is present only if the value for `job-status` is `USER_PAUSED`.
         * 
         * @return builder
         * 
         */
        public Builder userPausedDetails(@Nullable Output<List<ClassificationJobUserPausedDetailArgs>> userPausedDetails) {
            $.userPausedDetails = userPausedDetails;
            return this;
        }

        /**
         * @param userPausedDetails If the current status of the job is `USER_PAUSED`, specifies when the job was paused and when the job or job run will expire and be canceled if it isn&#39;t resumed. This value is present only if the value for `job-status` is `USER_PAUSED`.
         * 
         * @return builder
         * 
         */
        public Builder userPausedDetails(List<ClassificationJobUserPausedDetailArgs> userPausedDetails) {
            return userPausedDetails(Output.of(userPausedDetails));
        }

        /**
         * @param userPausedDetails If the current status of the job is `USER_PAUSED`, specifies when the job was paused and when the job or job run will expire and be canceled if it isn&#39;t resumed. This value is present only if the value for `job-status` is `USER_PAUSED`.
         * 
         * @return builder
         * 
         */
        public Builder userPausedDetails(ClassificationJobUserPausedDetailArgs... userPausedDetails) {
            return userPausedDetails(List.of(userPausedDetails));
        }

        public ClassificationJobState build() {
            return $;
        }
    }

}
