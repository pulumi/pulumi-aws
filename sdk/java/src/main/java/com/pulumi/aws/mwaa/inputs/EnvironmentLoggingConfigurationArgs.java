// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.mwaa.inputs;

import com.pulumi.aws.mwaa.inputs.EnvironmentLoggingConfigurationDagProcessingLogsArgs;
import com.pulumi.aws.mwaa.inputs.EnvironmentLoggingConfigurationSchedulerLogsArgs;
import com.pulumi.aws.mwaa.inputs.EnvironmentLoggingConfigurationTaskLogsArgs;
import com.pulumi.aws.mwaa.inputs.EnvironmentLoggingConfigurationWebserverLogsArgs;
import com.pulumi.aws.mwaa.inputs.EnvironmentLoggingConfigurationWorkerLogsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class EnvironmentLoggingConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final EnvironmentLoggingConfigurationArgs Empty = new EnvironmentLoggingConfigurationArgs();

    /**
     * (Optional) Log configuration options for processing DAGs. See Module logging configuration for more information. Disabled by default.
     * 
     */
    @Import(name="dagProcessingLogs")
    private @Nullable Output<EnvironmentLoggingConfigurationDagProcessingLogsArgs> dagProcessingLogs;

    /**
     * @return (Optional) Log configuration options for processing DAGs. See Module logging configuration for more information. Disabled by default.
     * 
     */
    public Optional<Output<EnvironmentLoggingConfigurationDagProcessingLogsArgs>> dagProcessingLogs() {
        return Optional.ofNullable(this.dagProcessingLogs);
    }

    /**
     * Log configuration options for the schedulers. See Module logging configuration for more information. Disabled by default.
     * 
     */
    @Import(name="schedulerLogs")
    private @Nullable Output<EnvironmentLoggingConfigurationSchedulerLogsArgs> schedulerLogs;

    /**
     * @return Log configuration options for the schedulers. See Module logging configuration for more information. Disabled by default.
     * 
     */
    public Optional<Output<EnvironmentLoggingConfigurationSchedulerLogsArgs>> schedulerLogs() {
        return Optional.ofNullable(this.schedulerLogs);
    }

    /**
     * Log configuration options for DAG tasks. See Module logging configuration for more information. Enabled by default with `INFO` log level.
     * 
     */
    @Import(name="taskLogs")
    private @Nullable Output<EnvironmentLoggingConfigurationTaskLogsArgs> taskLogs;

    /**
     * @return Log configuration options for DAG tasks. See Module logging configuration for more information. Enabled by default with `INFO` log level.
     * 
     */
    public Optional<Output<EnvironmentLoggingConfigurationTaskLogsArgs>> taskLogs() {
        return Optional.ofNullable(this.taskLogs);
    }

    /**
     * Log configuration options for the webservers. See Module logging configuration for more information. Disabled by default.
     * 
     */
    @Import(name="webserverLogs")
    private @Nullable Output<EnvironmentLoggingConfigurationWebserverLogsArgs> webserverLogs;

    /**
     * @return Log configuration options for the webservers. See Module logging configuration for more information. Disabled by default.
     * 
     */
    public Optional<Output<EnvironmentLoggingConfigurationWebserverLogsArgs>> webserverLogs() {
        return Optional.ofNullable(this.webserverLogs);
    }

    /**
     * Log configuration options for the workers. See Module logging configuration for more information. Disabled by default.
     * 
     */
    @Import(name="workerLogs")
    private @Nullable Output<EnvironmentLoggingConfigurationWorkerLogsArgs> workerLogs;

    /**
     * @return Log configuration options for the workers. See Module logging configuration for more information. Disabled by default.
     * 
     */
    public Optional<Output<EnvironmentLoggingConfigurationWorkerLogsArgs>> workerLogs() {
        return Optional.ofNullable(this.workerLogs);
    }

    private EnvironmentLoggingConfigurationArgs() {}

    private EnvironmentLoggingConfigurationArgs(EnvironmentLoggingConfigurationArgs $) {
        this.dagProcessingLogs = $.dagProcessingLogs;
        this.schedulerLogs = $.schedulerLogs;
        this.taskLogs = $.taskLogs;
        this.webserverLogs = $.webserverLogs;
        this.workerLogs = $.workerLogs;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(EnvironmentLoggingConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private EnvironmentLoggingConfigurationArgs $;

        public Builder() {
            $ = new EnvironmentLoggingConfigurationArgs();
        }

        public Builder(EnvironmentLoggingConfigurationArgs defaults) {
            $ = new EnvironmentLoggingConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param dagProcessingLogs (Optional) Log configuration options for processing DAGs. See Module logging configuration for more information. Disabled by default.
         * 
         * @return builder
         * 
         */
        public Builder dagProcessingLogs(@Nullable Output<EnvironmentLoggingConfigurationDagProcessingLogsArgs> dagProcessingLogs) {
            $.dagProcessingLogs = dagProcessingLogs;
            return this;
        }

        /**
         * @param dagProcessingLogs (Optional) Log configuration options for processing DAGs. See Module logging configuration for more information. Disabled by default.
         * 
         * @return builder
         * 
         */
        public Builder dagProcessingLogs(EnvironmentLoggingConfigurationDagProcessingLogsArgs dagProcessingLogs) {
            return dagProcessingLogs(Output.of(dagProcessingLogs));
        }

        /**
         * @param schedulerLogs Log configuration options for the schedulers. See Module logging configuration for more information. Disabled by default.
         * 
         * @return builder
         * 
         */
        public Builder schedulerLogs(@Nullable Output<EnvironmentLoggingConfigurationSchedulerLogsArgs> schedulerLogs) {
            $.schedulerLogs = schedulerLogs;
            return this;
        }

        /**
         * @param schedulerLogs Log configuration options for the schedulers. See Module logging configuration for more information. Disabled by default.
         * 
         * @return builder
         * 
         */
        public Builder schedulerLogs(EnvironmentLoggingConfigurationSchedulerLogsArgs schedulerLogs) {
            return schedulerLogs(Output.of(schedulerLogs));
        }

        /**
         * @param taskLogs Log configuration options for DAG tasks. See Module logging configuration for more information. Enabled by default with `INFO` log level.
         * 
         * @return builder
         * 
         */
        public Builder taskLogs(@Nullable Output<EnvironmentLoggingConfigurationTaskLogsArgs> taskLogs) {
            $.taskLogs = taskLogs;
            return this;
        }

        /**
         * @param taskLogs Log configuration options for DAG tasks. See Module logging configuration for more information. Enabled by default with `INFO` log level.
         * 
         * @return builder
         * 
         */
        public Builder taskLogs(EnvironmentLoggingConfigurationTaskLogsArgs taskLogs) {
            return taskLogs(Output.of(taskLogs));
        }

        /**
         * @param webserverLogs Log configuration options for the webservers. See Module logging configuration for more information. Disabled by default.
         * 
         * @return builder
         * 
         */
        public Builder webserverLogs(@Nullable Output<EnvironmentLoggingConfigurationWebserverLogsArgs> webserverLogs) {
            $.webserverLogs = webserverLogs;
            return this;
        }

        /**
         * @param webserverLogs Log configuration options for the webservers. See Module logging configuration for more information. Disabled by default.
         * 
         * @return builder
         * 
         */
        public Builder webserverLogs(EnvironmentLoggingConfigurationWebserverLogsArgs webserverLogs) {
            return webserverLogs(Output.of(webserverLogs));
        }

        /**
         * @param workerLogs Log configuration options for the workers. See Module logging configuration for more information. Disabled by default.
         * 
         * @return builder
         * 
         */
        public Builder workerLogs(@Nullable Output<EnvironmentLoggingConfigurationWorkerLogsArgs> workerLogs) {
            $.workerLogs = workerLogs;
            return this;
        }

        /**
         * @param workerLogs Log configuration options for the workers. See Module logging configuration for more information. Disabled by default.
         * 
         * @return builder
         * 
         */
        public Builder workerLogs(EnvironmentLoggingConfigurationWorkerLogsArgs workerLogs) {
            return workerLogs(Output.of(workerLogs));
        }

        public EnvironmentLoggingConfigurationArgs build() {
            return $;
        }
    }

}
