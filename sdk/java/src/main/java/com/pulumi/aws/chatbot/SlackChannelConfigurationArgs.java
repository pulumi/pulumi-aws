// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.chatbot;

import com.pulumi.aws.chatbot.inputs.SlackChannelConfigurationTimeoutsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class SlackChannelConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final SlackChannelConfigurationArgs Empty = new SlackChannelConfigurationArgs();

    /**
     * Name of the Slack channel configuration.
     * 
     */
    @Import(name="configurationName", required=true)
    private Output<String> configurationName;

    /**
     * @return Name of the Slack channel configuration.
     * 
     */
    public Output<String> configurationName() {
        return this.configurationName;
    }

    /**
     * List of IAM policy ARNs that are applied as channel guardrails. The AWS managed `AdministratorAccess` policy is applied by default if this is not set.
     * 
     */
    @Import(name="guardrailPolicyArns")
    private @Nullable Output<List<String>> guardrailPolicyArns;

    /**
     * @return List of IAM policy ARNs that are applied as channel guardrails. The AWS managed `AdministratorAccess` policy is applied by default if this is not set.
     * 
     */
    public Optional<Output<List<String>>> guardrailPolicyArns() {
        return Optional.ofNullable(this.guardrailPolicyArns);
    }

    /**
     * User-defined role that AWS Chatbot assumes. This is not the service-linked role.
     * 
     */
    @Import(name="iamRoleArn", required=true)
    private Output<String> iamRoleArn;

    /**
     * @return User-defined role that AWS Chatbot assumes. This is not the service-linked role.
     * 
     */
    public Output<String> iamRoleArn() {
        return this.iamRoleArn;
    }

    /**
     * Logging levels include `ERROR`, `INFO`, or `NONE`.
     * 
     */
    @Import(name="loggingLevel")
    private @Nullable Output<String> loggingLevel;

    /**
     * @return Logging levels include `ERROR`, `INFO`, or `NONE`.
     * 
     */
    public Optional<Output<String>> loggingLevel() {
        return Optional.ofNullable(this.loggingLevel);
    }

    /**
     * ID of the Slack channel. For example, `C07EZ1ABC23`.
     * 
     */
    @Import(name="slackChannelId", required=true)
    private Output<String> slackChannelId;

    /**
     * @return ID of the Slack channel. For example, `C07EZ1ABC23`.
     * 
     */
    public Output<String> slackChannelId() {
        return this.slackChannelId;
    }

    /**
     * ID of the Slack workspace authorized with AWS Chatbot. For example, `T07EA123LEP`.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="slackTeamId", required=true)
    private Output<String> slackTeamId;

    /**
     * @return ID of the Slack workspace authorized with AWS Chatbot. For example, `T07EA123LEP`.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> slackTeamId() {
        return this.slackTeamId;
    }

    /**
     * ARNs of the SNS topics that deliver notifications to AWS Chatbot.
     * 
     */
    @Import(name="snsTopicArns")
    private @Nullable Output<List<String>> snsTopicArns;

    /**
     * @return ARNs of the SNS topics that deliver notifications to AWS Chatbot.
     * 
     */
    public Optional<Output<List<String>>> snsTopicArns() {
        return Optional.ofNullable(this.snsTopicArns);
    }

    /**
     * Map of tags assigned to the resource.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Map of tags assigned to the resource.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    @Import(name="timeouts")
    private @Nullable Output<SlackChannelConfigurationTimeoutsArgs> timeouts;

    public Optional<Output<SlackChannelConfigurationTimeoutsArgs>> timeouts() {
        return Optional.ofNullable(this.timeouts);
    }

    /**
     * Enables use of a user role requirement in your chat configuration.
     * 
     */
    @Import(name="userAuthorizationRequired")
    private @Nullable Output<Boolean> userAuthorizationRequired;

    /**
     * @return Enables use of a user role requirement in your chat configuration.
     * 
     */
    public Optional<Output<Boolean>> userAuthorizationRequired() {
        return Optional.ofNullable(this.userAuthorizationRequired);
    }

    private SlackChannelConfigurationArgs() {}

    private SlackChannelConfigurationArgs(SlackChannelConfigurationArgs $) {
        this.configurationName = $.configurationName;
        this.guardrailPolicyArns = $.guardrailPolicyArns;
        this.iamRoleArn = $.iamRoleArn;
        this.loggingLevel = $.loggingLevel;
        this.slackChannelId = $.slackChannelId;
        this.slackTeamId = $.slackTeamId;
        this.snsTopicArns = $.snsTopicArns;
        this.tags = $.tags;
        this.timeouts = $.timeouts;
        this.userAuthorizationRequired = $.userAuthorizationRequired;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(SlackChannelConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private SlackChannelConfigurationArgs $;

        public Builder() {
            $ = new SlackChannelConfigurationArgs();
        }

        public Builder(SlackChannelConfigurationArgs defaults) {
            $ = new SlackChannelConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param configurationName Name of the Slack channel configuration.
         * 
         * @return builder
         * 
         */
        public Builder configurationName(Output<String> configurationName) {
            $.configurationName = configurationName;
            return this;
        }

        /**
         * @param configurationName Name of the Slack channel configuration.
         * 
         * @return builder
         * 
         */
        public Builder configurationName(String configurationName) {
            return configurationName(Output.of(configurationName));
        }

        /**
         * @param guardrailPolicyArns List of IAM policy ARNs that are applied as channel guardrails. The AWS managed `AdministratorAccess` policy is applied by default if this is not set.
         * 
         * @return builder
         * 
         */
        public Builder guardrailPolicyArns(@Nullable Output<List<String>> guardrailPolicyArns) {
            $.guardrailPolicyArns = guardrailPolicyArns;
            return this;
        }

        /**
         * @param guardrailPolicyArns List of IAM policy ARNs that are applied as channel guardrails. The AWS managed `AdministratorAccess` policy is applied by default if this is not set.
         * 
         * @return builder
         * 
         */
        public Builder guardrailPolicyArns(List<String> guardrailPolicyArns) {
            return guardrailPolicyArns(Output.of(guardrailPolicyArns));
        }

        /**
         * @param guardrailPolicyArns List of IAM policy ARNs that are applied as channel guardrails. The AWS managed `AdministratorAccess` policy is applied by default if this is not set.
         * 
         * @return builder
         * 
         */
        public Builder guardrailPolicyArns(String... guardrailPolicyArns) {
            return guardrailPolicyArns(List.of(guardrailPolicyArns));
        }

        /**
         * @param iamRoleArn User-defined role that AWS Chatbot assumes. This is not the service-linked role.
         * 
         * @return builder
         * 
         */
        public Builder iamRoleArn(Output<String> iamRoleArn) {
            $.iamRoleArn = iamRoleArn;
            return this;
        }

        /**
         * @param iamRoleArn User-defined role that AWS Chatbot assumes. This is not the service-linked role.
         * 
         * @return builder
         * 
         */
        public Builder iamRoleArn(String iamRoleArn) {
            return iamRoleArn(Output.of(iamRoleArn));
        }

        /**
         * @param loggingLevel Logging levels include `ERROR`, `INFO`, or `NONE`.
         * 
         * @return builder
         * 
         */
        public Builder loggingLevel(@Nullable Output<String> loggingLevel) {
            $.loggingLevel = loggingLevel;
            return this;
        }

        /**
         * @param loggingLevel Logging levels include `ERROR`, `INFO`, or `NONE`.
         * 
         * @return builder
         * 
         */
        public Builder loggingLevel(String loggingLevel) {
            return loggingLevel(Output.of(loggingLevel));
        }

        /**
         * @param slackChannelId ID of the Slack channel. For example, `C07EZ1ABC23`.
         * 
         * @return builder
         * 
         */
        public Builder slackChannelId(Output<String> slackChannelId) {
            $.slackChannelId = slackChannelId;
            return this;
        }

        /**
         * @param slackChannelId ID of the Slack channel. For example, `C07EZ1ABC23`.
         * 
         * @return builder
         * 
         */
        public Builder slackChannelId(String slackChannelId) {
            return slackChannelId(Output.of(slackChannelId));
        }

        /**
         * @param slackTeamId ID of the Slack workspace authorized with AWS Chatbot. For example, `T07EA123LEP`.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder slackTeamId(Output<String> slackTeamId) {
            $.slackTeamId = slackTeamId;
            return this;
        }

        /**
         * @param slackTeamId ID of the Slack workspace authorized with AWS Chatbot. For example, `T07EA123LEP`.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder slackTeamId(String slackTeamId) {
            return slackTeamId(Output.of(slackTeamId));
        }

        /**
         * @param snsTopicArns ARNs of the SNS topics that deliver notifications to AWS Chatbot.
         * 
         * @return builder
         * 
         */
        public Builder snsTopicArns(@Nullable Output<List<String>> snsTopicArns) {
            $.snsTopicArns = snsTopicArns;
            return this;
        }

        /**
         * @param snsTopicArns ARNs of the SNS topics that deliver notifications to AWS Chatbot.
         * 
         * @return builder
         * 
         */
        public Builder snsTopicArns(List<String> snsTopicArns) {
            return snsTopicArns(Output.of(snsTopicArns));
        }

        /**
         * @param snsTopicArns ARNs of the SNS topics that deliver notifications to AWS Chatbot.
         * 
         * @return builder
         * 
         */
        public Builder snsTopicArns(String... snsTopicArns) {
            return snsTopicArns(List.of(snsTopicArns));
        }

        /**
         * @param tags Map of tags assigned to the resource.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Map of tags assigned to the resource.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        public Builder timeouts(@Nullable Output<SlackChannelConfigurationTimeoutsArgs> timeouts) {
            $.timeouts = timeouts;
            return this;
        }

        public Builder timeouts(SlackChannelConfigurationTimeoutsArgs timeouts) {
            return timeouts(Output.of(timeouts));
        }

        /**
         * @param userAuthorizationRequired Enables use of a user role requirement in your chat configuration.
         * 
         * @return builder
         * 
         */
        public Builder userAuthorizationRequired(@Nullable Output<Boolean> userAuthorizationRequired) {
            $.userAuthorizationRequired = userAuthorizationRequired;
            return this;
        }

        /**
         * @param userAuthorizationRequired Enables use of a user role requirement in your chat configuration.
         * 
         * @return builder
         * 
         */
        public Builder userAuthorizationRequired(Boolean userAuthorizationRequired) {
            return userAuthorizationRequired(Output.of(userAuthorizationRequired));
        }

        public SlackChannelConfigurationArgs build() {
            if ($.configurationName == null) {
                throw new MissingRequiredPropertyException("SlackChannelConfigurationArgs", "configurationName");
            }
            if ($.iamRoleArn == null) {
                throw new MissingRequiredPropertyException("SlackChannelConfigurationArgs", "iamRoleArn");
            }
            if ($.slackChannelId == null) {
                throw new MissingRequiredPropertyException("SlackChannelConfigurationArgs", "slackChannelId");
            }
            if ($.slackTeamId == null) {
                throw new MissingRequiredPropertyException("SlackChannelConfigurationArgs", "slackTeamId");
            }
            return $;
        }
    }

}
