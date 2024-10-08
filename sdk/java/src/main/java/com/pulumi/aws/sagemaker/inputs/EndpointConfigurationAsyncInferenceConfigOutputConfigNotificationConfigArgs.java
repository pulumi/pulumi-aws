// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sagemaker.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class EndpointConfigurationAsyncInferenceConfigOutputConfigNotificationConfigArgs extends com.pulumi.resources.ResourceArgs {

    public static final EndpointConfigurationAsyncInferenceConfigOutputConfigNotificationConfigArgs Empty = new EndpointConfigurationAsyncInferenceConfigOutputConfigNotificationConfigArgs();

    /**
     * Amazon SNS topic to post a notification to when inference fails. If no topic is provided, no notification is sent on failure.
     * 
     */
    @Import(name="errorTopic")
    private @Nullable Output<String> errorTopic;

    /**
     * @return Amazon SNS topic to post a notification to when inference fails. If no topic is provided, no notification is sent on failure.
     * 
     */
    public Optional<Output<String>> errorTopic() {
        return Optional.ofNullable(this.errorTopic);
    }

    /**
     * The Amazon SNS topics where you want the inference response to be included. Valid values are `SUCCESS_NOTIFICATION_TOPIC` and `ERROR_NOTIFICATION_TOPIC`.
     * 
     */
    @Import(name="includeInferenceResponseIns")
    private @Nullable Output<List<String>> includeInferenceResponseIns;

    /**
     * @return The Amazon SNS topics where you want the inference response to be included. Valid values are `SUCCESS_NOTIFICATION_TOPIC` and `ERROR_NOTIFICATION_TOPIC`.
     * 
     */
    public Optional<Output<List<String>>> includeInferenceResponseIns() {
        return Optional.ofNullable(this.includeInferenceResponseIns);
    }

    /**
     * Amazon SNS topic to post a notification to when inference completes successfully. If no topic is provided, no notification is sent on success.
     * 
     */
    @Import(name="successTopic")
    private @Nullable Output<String> successTopic;

    /**
     * @return Amazon SNS topic to post a notification to when inference completes successfully. If no topic is provided, no notification is sent on success.
     * 
     */
    public Optional<Output<String>> successTopic() {
        return Optional.ofNullable(this.successTopic);
    }

    private EndpointConfigurationAsyncInferenceConfigOutputConfigNotificationConfigArgs() {}

    private EndpointConfigurationAsyncInferenceConfigOutputConfigNotificationConfigArgs(EndpointConfigurationAsyncInferenceConfigOutputConfigNotificationConfigArgs $) {
        this.errorTopic = $.errorTopic;
        this.includeInferenceResponseIns = $.includeInferenceResponseIns;
        this.successTopic = $.successTopic;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(EndpointConfigurationAsyncInferenceConfigOutputConfigNotificationConfigArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private EndpointConfigurationAsyncInferenceConfigOutputConfigNotificationConfigArgs $;

        public Builder() {
            $ = new EndpointConfigurationAsyncInferenceConfigOutputConfigNotificationConfigArgs();
        }

        public Builder(EndpointConfigurationAsyncInferenceConfigOutputConfigNotificationConfigArgs defaults) {
            $ = new EndpointConfigurationAsyncInferenceConfigOutputConfigNotificationConfigArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param errorTopic Amazon SNS topic to post a notification to when inference fails. If no topic is provided, no notification is sent on failure.
         * 
         * @return builder
         * 
         */
        public Builder errorTopic(@Nullable Output<String> errorTopic) {
            $.errorTopic = errorTopic;
            return this;
        }

        /**
         * @param errorTopic Amazon SNS topic to post a notification to when inference fails. If no topic is provided, no notification is sent on failure.
         * 
         * @return builder
         * 
         */
        public Builder errorTopic(String errorTopic) {
            return errorTopic(Output.of(errorTopic));
        }

        /**
         * @param includeInferenceResponseIns The Amazon SNS topics where you want the inference response to be included. Valid values are `SUCCESS_NOTIFICATION_TOPIC` and `ERROR_NOTIFICATION_TOPIC`.
         * 
         * @return builder
         * 
         */
        public Builder includeInferenceResponseIns(@Nullable Output<List<String>> includeInferenceResponseIns) {
            $.includeInferenceResponseIns = includeInferenceResponseIns;
            return this;
        }

        /**
         * @param includeInferenceResponseIns The Amazon SNS topics where you want the inference response to be included. Valid values are `SUCCESS_NOTIFICATION_TOPIC` and `ERROR_NOTIFICATION_TOPIC`.
         * 
         * @return builder
         * 
         */
        public Builder includeInferenceResponseIns(List<String> includeInferenceResponseIns) {
            return includeInferenceResponseIns(Output.of(includeInferenceResponseIns));
        }

        /**
         * @param includeInferenceResponseIns The Amazon SNS topics where you want the inference response to be included. Valid values are `SUCCESS_NOTIFICATION_TOPIC` and `ERROR_NOTIFICATION_TOPIC`.
         * 
         * @return builder
         * 
         */
        public Builder includeInferenceResponseIns(String... includeInferenceResponseIns) {
            return includeInferenceResponseIns(List.of(includeInferenceResponseIns));
        }

        /**
         * @param successTopic Amazon SNS topic to post a notification to when inference completes successfully. If no topic is provided, no notification is sent on success.
         * 
         * @return builder
         * 
         */
        public Builder successTopic(@Nullable Output<String> successTopic) {
            $.successTopic = successTopic;
            return this;
        }

        /**
         * @param successTopic Amazon SNS topic to post a notification to when inference completes successfully. If no topic is provided, no notification is sent on success.
         * 
         * @return builder
         * 
         */
        public Builder successTopic(String successTopic) {
            return successTopic(Output.of(successTopic));
        }

        public EndpointConfigurationAsyncInferenceConfigOutputConfigNotificationConfigArgs build() {
            return $;
        }
    }

}
