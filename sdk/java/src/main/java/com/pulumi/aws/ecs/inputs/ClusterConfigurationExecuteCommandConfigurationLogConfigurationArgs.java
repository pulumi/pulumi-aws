// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ecs.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ClusterConfigurationExecuteCommandConfigurationLogConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final ClusterConfigurationExecuteCommandConfigurationLogConfigurationArgs Empty = new ClusterConfigurationExecuteCommandConfigurationLogConfigurationArgs();

    /**
     * Whether to enable encryption on the CloudWatch logs. If not specified, encryption will be disabled.
     * 
     */
    @Import(name="cloudWatchEncryptionEnabled")
    private @Nullable Output<Boolean> cloudWatchEncryptionEnabled;

    /**
     * @return Whether to enable encryption on the CloudWatch logs. If not specified, encryption will be disabled.
     * 
     */
    public Optional<Output<Boolean>> cloudWatchEncryptionEnabled() {
        return Optional.ofNullable(this.cloudWatchEncryptionEnabled);
    }

    /**
     * The name of the CloudWatch log group to send logs to.
     * 
     */
    @Import(name="cloudWatchLogGroupName")
    private @Nullable Output<String> cloudWatchLogGroupName;

    /**
     * @return The name of the CloudWatch log group to send logs to.
     * 
     */
    public Optional<Output<String>> cloudWatchLogGroupName() {
        return Optional.ofNullable(this.cloudWatchLogGroupName);
    }

    /**
     * Whether to enable encryption on the logs sent to S3. If not specified, encryption will be disabled.
     * 
     */
    @Import(name="s3BucketEncryptionEnabled")
    private @Nullable Output<Boolean> s3BucketEncryptionEnabled;

    /**
     * @return Whether to enable encryption on the logs sent to S3. If not specified, encryption will be disabled.
     * 
     */
    public Optional<Output<Boolean>> s3BucketEncryptionEnabled() {
        return Optional.ofNullable(this.s3BucketEncryptionEnabled);
    }

    /**
     * Name of the S3 bucket to send logs to.
     * 
     */
    @Import(name="s3BucketName")
    private @Nullable Output<String> s3BucketName;

    /**
     * @return Name of the S3 bucket to send logs to.
     * 
     */
    public Optional<Output<String>> s3BucketName() {
        return Optional.ofNullable(this.s3BucketName);
    }

    /**
     * Optional folder in the S3 bucket to place logs in.
     * 
     */
    @Import(name="s3KeyPrefix")
    private @Nullable Output<String> s3KeyPrefix;

    /**
     * @return Optional folder in the S3 bucket to place logs in.
     * 
     */
    public Optional<Output<String>> s3KeyPrefix() {
        return Optional.ofNullable(this.s3KeyPrefix);
    }

    private ClusterConfigurationExecuteCommandConfigurationLogConfigurationArgs() {}

    private ClusterConfigurationExecuteCommandConfigurationLogConfigurationArgs(ClusterConfigurationExecuteCommandConfigurationLogConfigurationArgs $) {
        this.cloudWatchEncryptionEnabled = $.cloudWatchEncryptionEnabled;
        this.cloudWatchLogGroupName = $.cloudWatchLogGroupName;
        this.s3BucketEncryptionEnabled = $.s3BucketEncryptionEnabled;
        this.s3BucketName = $.s3BucketName;
        this.s3KeyPrefix = $.s3KeyPrefix;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ClusterConfigurationExecuteCommandConfigurationLogConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ClusterConfigurationExecuteCommandConfigurationLogConfigurationArgs $;

        public Builder() {
            $ = new ClusterConfigurationExecuteCommandConfigurationLogConfigurationArgs();
        }

        public Builder(ClusterConfigurationExecuteCommandConfigurationLogConfigurationArgs defaults) {
            $ = new ClusterConfigurationExecuteCommandConfigurationLogConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param cloudWatchEncryptionEnabled Whether to enable encryption on the CloudWatch logs. If not specified, encryption will be disabled.
         * 
         * @return builder
         * 
         */
        public Builder cloudWatchEncryptionEnabled(@Nullable Output<Boolean> cloudWatchEncryptionEnabled) {
            $.cloudWatchEncryptionEnabled = cloudWatchEncryptionEnabled;
            return this;
        }

        /**
         * @param cloudWatchEncryptionEnabled Whether to enable encryption on the CloudWatch logs. If not specified, encryption will be disabled.
         * 
         * @return builder
         * 
         */
        public Builder cloudWatchEncryptionEnabled(Boolean cloudWatchEncryptionEnabled) {
            return cloudWatchEncryptionEnabled(Output.of(cloudWatchEncryptionEnabled));
        }

        /**
         * @param cloudWatchLogGroupName The name of the CloudWatch log group to send logs to.
         * 
         * @return builder
         * 
         */
        public Builder cloudWatchLogGroupName(@Nullable Output<String> cloudWatchLogGroupName) {
            $.cloudWatchLogGroupName = cloudWatchLogGroupName;
            return this;
        }

        /**
         * @param cloudWatchLogGroupName The name of the CloudWatch log group to send logs to.
         * 
         * @return builder
         * 
         */
        public Builder cloudWatchLogGroupName(String cloudWatchLogGroupName) {
            return cloudWatchLogGroupName(Output.of(cloudWatchLogGroupName));
        }

        /**
         * @param s3BucketEncryptionEnabled Whether to enable encryption on the logs sent to S3. If not specified, encryption will be disabled.
         * 
         * @return builder
         * 
         */
        public Builder s3BucketEncryptionEnabled(@Nullable Output<Boolean> s3BucketEncryptionEnabled) {
            $.s3BucketEncryptionEnabled = s3BucketEncryptionEnabled;
            return this;
        }

        /**
         * @param s3BucketEncryptionEnabled Whether to enable encryption on the logs sent to S3. If not specified, encryption will be disabled.
         * 
         * @return builder
         * 
         */
        public Builder s3BucketEncryptionEnabled(Boolean s3BucketEncryptionEnabled) {
            return s3BucketEncryptionEnabled(Output.of(s3BucketEncryptionEnabled));
        }

        /**
         * @param s3BucketName Name of the S3 bucket to send logs to.
         * 
         * @return builder
         * 
         */
        public Builder s3BucketName(@Nullable Output<String> s3BucketName) {
            $.s3BucketName = s3BucketName;
            return this;
        }

        /**
         * @param s3BucketName Name of the S3 bucket to send logs to.
         * 
         * @return builder
         * 
         */
        public Builder s3BucketName(String s3BucketName) {
            return s3BucketName(Output.of(s3BucketName));
        }

        /**
         * @param s3KeyPrefix Optional folder in the S3 bucket to place logs in.
         * 
         * @return builder
         * 
         */
        public Builder s3KeyPrefix(@Nullable Output<String> s3KeyPrefix) {
            $.s3KeyPrefix = s3KeyPrefix;
            return this;
        }

        /**
         * @param s3KeyPrefix Optional folder in the S3 bucket to place logs in.
         * 
         * @return builder
         * 
         */
        public Builder s3KeyPrefix(String s3KeyPrefix) {
            return s3KeyPrefix(Output.of(s3KeyPrefix));
        }

        public ClusterConfigurationExecuteCommandConfigurationLogConfigurationArgs build() {
            return $;
        }
    }

}
