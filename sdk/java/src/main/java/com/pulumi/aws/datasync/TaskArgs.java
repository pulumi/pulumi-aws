// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.datasync;

import com.pulumi.aws.datasync.inputs.TaskExcludesArgs;
import com.pulumi.aws.datasync.inputs.TaskIncludesArgs;
import com.pulumi.aws.datasync.inputs.TaskOptionsArgs;
import com.pulumi.aws.datasync.inputs.TaskScheduleArgs;
import com.pulumi.aws.datasync.inputs.TaskTaskReportConfigArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class TaskArgs extends com.pulumi.resources.ResourceArgs {

    public static final TaskArgs Empty = new TaskArgs();

    /**
     * Amazon Resource Name (ARN) of the CloudWatch Log Group that is used to monitor and log events in the sync task.
     * 
     */
    @Import(name="cloudwatchLogGroupArn")
    private @Nullable Output<String> cloudwatchLogGroupArn;

    /**
     * @return Amazon Resource Name (ARN) of the CloudWatch Log Group that is used to monitor and log events in the sync task.
     * 
     */
    public Optional<Output<String>> cloudwatchLogGroupArn() {
        return Optional.ofNullable(this.cloudwatchLogGroupArn);
    }

    /**
     * Amazon Resource Name (ARN) of destination DataSync Location.
     * 
     */
    @Import(name="destinationLocationArn", required=true)
    private Output<String> destinationLocationArn;

    /**
     * @return Amazon Resource Name (ARN) of destination DataSync Location.
     * 
     */
    public Output<String> destinationLocationArn() {
        return this.destinationLocationArn;
    }

    /**
     * Filter rules that determines which files to exclude from a task.
     * 
     */
    @Import(name="excludes")
    private @Nullable Output<TaskExcludesArgs> excludes;

    /**
     * @return Filter rules that determines which files to exclude from a task.
     * 
     */
    public Optional<Output<TaskExcludesArgs>> excludes() {
        return Optional.ofNullable(this.excludes);
    }

    /**
     * Filter rules that determines which files to include in a task.
     * 
     */
    @Import(name="includes")
    private @Nullable Output<TaskIncludesArgs> includes;

    /**
     * @return Filter rules that determines which files to include in a task.
     * 
     */
    public Optional<Output<TaskIncludesArgs>> includes() {
        return Optional.ofNullable(this.includes);
    }

    /**
     * Name of the DataSync Task.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Name of the DataSync Task.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Configuration block containing option that controls the default behavior when you start an execution of this DataSync Task. For each individual task execution, you can override these options by specifying an overriding configuration in those executions.
     * 
     */
    @Import(name="options")
    private @Nullable Output<TaskOptionsArgs> options;

    /**
     * @return Configuration block containing option that controls the default behavior when you start an execution of this DataSync Task. For each individual task execution, you can override these options by specifying an overriding configuration in those executions.
     * 
     */
    public Optional<Output<TaskOptionsArgs>> options() {
        return Optional.ofNullable(this.options);
    }

    /**
     * Specifies a schedule used to periodically transfer files from a source to a destination location.
     * 
     */
    @Import(name="schedule")
    private @Nullable Output<TaskScheduleArgs> schedule;

    /**
     * @return Specifies a schedule used to periodically transfer files from a source to a destination location.
     * 
     */
    public Optional<Output<TaskScheduleArgs>> schedule() {
        return Optional.ofNullable(this.schedule);
    }

    /**
     * Amazon Resource Name (ARN) of source DataSync Location.
     * 
     */
    @Import(name="sourceLocationArn", required=true)
    private Output<String> sourceLocationArn;

    /**
     * @return Amazon Resource Name (ARN) of source DataSync Location.
     * 
     */
    public Output<String> sourceLocationArn() {
        return this.sourceLocationArn;
    }

    /**
     * Key-value pairs of resource tags to assign to the DataSync Task. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Key-value pairs of resource tags to assign to the DataSync Task. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * One of the following task modes for your data transfer:
     * * `BASIC` (default) - Transfer files or objects between Amazon Web Services storage and on-premises, edge, or other cloud storage.
     * * `ENHANCED` - Transfer virtually unlimited numbers of objects with enhanced metrics, more detailed logs, and higher performance than Basic mode. Currently available for transfers between Amazon S3 locations.
     * 
     */
    @Import(name="taskMode")
    private @Nullable Output<String> taskMode;

    /**
     * @return One of the following task modes for your data transfer:
     * * `BASIC` (default) - Transfer files or objects between Amazon Web Services storage and on-premises, edge, or other cloud storage.
     * * `ENHANCED` - Transfer virtually unlimited numbers of objects with enhanced metrics, more detailed logs, and higher performance than Basic mode. Currently available for transfers between Amazon S3 locations.
     * 
     */
    public Optional<Output<String>> taskMode() {
        return Optional.ofNullable(this.taskMode);
    }

    /**
     * Configuration block containing the configuration of a DataSync Task Report. See `task_report_config` below.
     * 
     */
    @Import(name="taskReportConfig")
    private @Nullable Output<TaskTaskReportConfigArgs> taskReportConfig;

    /**
     * @return Configuration block containing the configuration of a DataSync Task Report. See `task_report_config` below.
     * 
     */
    public Optional<Output<TaskTaskReportConfigArgs>> taskReportConfig() {
        return Optional.ofNullable(this.taskReportConfig);
    }

    private TaskArgs() {}

    private TaskArgs(TaskArgs $) {
        this.cloudwatchLogGroupArn = $.cloudwatchLogGroupArn;
        this.destinationLocationArn = $.destinationLocationArn;
        this.excludes = $.excludes;
        this.includes = $.includes;
        this.name = $.name;
        this.options = $.options;
        this.schedule = $.schedule;
        this.sourceLocationArn = $.sourceLocationArn;
        this.tags = $.tags;
        this.taskMode = $.taskMode;
        this.taskReportConfig = $.taskReportConfig;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(TaskArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private TaskArgs $;

        public Builder() {
            $ = new TaskArgs();
        }

        public Builder(TaskArgs defaults) {
            $ = new TaskArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param cloudwatchLogGroupArn Amazon Resource Name (ARN) of the CloudWatch Log Group that is used to monitor and log events in the sync task.
         * 
         * @return builder
         * 
         */
        public Builder cloudwatchLogGroupArn(@Nullable Output<String> cloudwatchLogGroupArn) {
            $.cloudwatchLogGroupArn = cloudwatchLogGroupArn;
            return this;
        }

        /**
         * @param cloudwatchLogGroupArn Amazon Resource Name (ARN) of the CloudWatch Log Group that is used to monitor and log events in the sync task.
         * 
         * @return builder
         * 
         */
        public Builder cloudwatchLogGroupArn(String cloudwatchLogGroupArn) {
            return cloudwatchLogGroupArn(Output.of(cloudwatchLogGroupArn));
        }

        /**
         * @param destinationLocationArn Amazon Resource Name (ARN) of destination DataSync Location.
         * 
         * @return builder
         * 
         */
        public Builder destinationLocationArn(Output<String> destinationLocationArn) {
            $.destinationLocationArn = destinationLocationArn;
            return this;
        }

        /**
         * @param destinationLocationArn Amazon Resource Name (ARN) of destination DataSync Location.
         * 
         * @return builder
         * 
         */
        public Builder destinationLocationArn(String destinationLocationArn) {
            return destinationLocationArn(Output.of(destinationLocationArn));
        }

        /**
         * @param excludes Filter rules that determines which files to exclude from a task.
         * 
         * @return builder
         * 
         */
        public Builder excludes(@Nullable Output<TaskExcludesArgs> excludes) {
            $.excludes = excludes;
            return this;
        }

        /**
         * @param excludes Filter rules that determines which files to exclude from a task.
         * 
         * @return builder
         * 
         */
        public Builder excludes(TaskExcludesArgs excludes) {
            return excludes(Output.of(excludes));
        }

        /**
         * @param includes Filter rules that determines which files to include in a task.
         * 
         * @return builder
         * 
         */
        public Builder includes(@Nullable Output<TaskIncludesArgs> includes) {
            $.includes = includes;
            return this;
        }

        /**
         * @param includes Filter rules that determines which files to include in a task.
         * 
         * @return builder
         * 
         */
        public Builder includes(TaskIncludesArgs includes) {
            return includes(Output.of(includes));
        }

        /**
         * @param name Name of the DataSync Task.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Name of the DataSync Task.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param options Configuration block containing option that controls the default behavior when you start an execution of this DataSync Task. For each individual task execution, you can override these options by specifying an overriding configuration in those executions.
         * 
         * @return builder
         * 
         */
        public Builder options(@Nullable Output<TaskOptionsArgs> options) {
            $.options = options;
            return this;
        }

        /**
         * @param options Configuration block containing option that controls the default behavior when you start an execution of this DataSync Task. For each individual task execution, you can override these options by specifying an overriding configuration in those executions.
         * 
         * @return builder
         * 
         */
        public Builder options(TaskOptionsArgs options) {
            return options(Output.of(options));
        }

        /**
         * @param schedule Specifies a schedule used to periodically transfer files from a source to a destination location.
         * 
         * @return builder
         * 
         */
        public Builder schedule(@Nullable Output<TaskScheduleArgs> schedule) {
            $.schedule = schedule;
            return this;
        }

        /**
         * @param schedule Specifies a schedule used to periodically transfer files from a source to a destination location.
         * 
         * @return builder
         * 
         */
        public Builder schedule(TaskScheduleArgs schedule) {
            return schedule(Output.of(schedule));
        }

        /**
         * @param sourceLocationArn Amazon Resource Name (ARN) of source DataSync Location.
         * 
         * @return builder
         * 
         */
        public Builder sourceLocationArn(Output<String> sourceLocationArn) {
            $.sourceLocationArn = sourceLocationArn;
            return this;
        }

        /**
         * @param sourceLocationArn Amazon Resource Name (ARN) of source DataSync Location.
         * 
         * @return builder
         * 
         */
        public Builder sourceLocationArn(String sourceLocationArn) {
            return sourceLocationArn(Output.of(sourceLocationArn));
        }

        /**
         * @param tags Key-value pairs of resource tags to assign to the DataSync Task. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Key-value pairs of resource tags to assign to the DataSync Task. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param taskMode One of the following task modes for your data transfer:
         * * `BASIC` (default) - Transfer files or objects between Amazon Web Services storage and on-premises, edge, or other cloud storage.
         * * `ENHANCED` - Transfer virtually unlimited numbers of objects with enhanced metrics, more detailed logs, and higher performance than Basic mode. Currently available for transfers between Amazon S3 locations.
         * 
         * @return builder
         * 
         */
        public Builder taskMode(@Nullable Output<String> taskMode) {
            $.taskMode = taskMode;
            return this;
        }

        /**
         * @param taskMode One of the following task modes for your data transfer:
         * * `BASIC` (default) - Transfer files or objects between Amazon Web Services storage and on-premises, edge, or other cloud storage.
         * * `ENHANCED` - Transfer virtually unlimited numbers of objects with enhanced metrics, more detailed logs, and higher performance than Basic mode. Currently available for transfers between Amazon S3 locations.
         * 
         * @return builder
         * 
         */
        public Builder taskMode(String taskMode) {
            return taskMode(Output.of(taskMode));
        }

        /**
         * @param taskReportConfig Configuration block containing the configuration of a DataSync Task Report. See `task_report_config` below.
         * 
         * @return builder
         * 
         */
        public Builder taskReportConfig(@Nullable Output<TaskTaskReportConfigArgs> taskReportConfig) {
            $.taskReportConfig = taskReportConfig;
            return this;
        }

        /**
         * @param taskReportConfig Configuration block containing the configuration of a DataSync Task Report. See `task_report_config` below.
         * 
         * @return builder
         * 
         */
        public Builder taskReportConfig(TaskTaskReportConfigArgs taskReportConfig) {
            return taskReportConfig(Output.of(taskReportConfig));
        }

        public TaskArgs build() {
            if ($.destinationLocationArn == null) {
                throw new MissingRequiredPropertyException("TaskArgs", "destinationLocationArn");
            }
            if ($.sourceLocationArn == null) {
                throw new MissingRequiredPropertyException("TaskArgs", "sourceLocationArn");
            }
            return $;
        }
    }

}
