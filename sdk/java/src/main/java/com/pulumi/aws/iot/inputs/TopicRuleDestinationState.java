// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.iot.inputs;

import com.pulumi.aws.iot.inputs.TopicRuleDestinationVpcConfigurationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class TopicRuleDestinationState extends com.pulumi.resources.ResourceArgs {

    public static final TopicRuleDestinationState Empty = new TopicRuleDestinationState();

    /**
     * The ARN of the topic rule destination
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return The ARN of the topic rule destination
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * Whether or not to enable the destination. Default: `true`.
     * 
     */
    @Import(name="enabled")
    private @Nullable Output<Boolean> enabled;

    /**
     * @return Whether or not to enable the destination. Default: `true`.
     * 
     */
    public Optional<Output<Boolean>> enabled() {
        return Optional.ofNullable(this.enabled);
    }

    /**
     * Configuration of the virtual private cloud (VPC) connection. For more info, see the [AWS documentation](https://docs.aws.amazon.com/iot/latest/developerguide/vpc-rule-action.html).
     * 
     */
    @Import(name="vpcConfiguration")
    private @Nullable Output<TopicRuleDestinationVpcConfigurationArgs> vpcConfiguration;

    /**
     * @return Configuration of the virtual private cloud (VPC) connection. For more info, see the [AWS documentation](https://docs.aws.amazon.com/iot/latest/developerguide/vpc-rule-action.html).
     * 
     */
    public Optional<Output<TopicRuleDestinationVpcConfigurationArgs>> vpcConfiguration() {
        return Optional.ofNullable(this.vpcConfiguration);
    }

    private TopicRuleDestinationState() {}

    private TopicRuleDestinationState(TopicRuleDestinationState $) {
        this.arn = $.arn;
        this.enabled = $.enabled;
        this.vpcConfiguration = $.vpcConfiguration;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(TopicRuleDestinationState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private TopicRuleDestinationState $;

        public Builder() {
            $ = new TopicRuleDestinationState();
        }

        public Builder(TopicRuleDestinationState defaults) {
            $ = new TopicRuleDestinationState(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn The ARN of the topic rule destination
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn The ARN of the topic rule destination
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param enabled Whether or not to enable the destination. Default: `true`.
         * 
         * @return builder
         * 
         */
        public Builder enabled(@Nullable Output<Boolean> enabled) {
            $.enabled = enabled;
            return this;
        }

        /**
         * @param enabled Whether or not to enable the destination. Default: `true`.
         * 
         * @return builder
         * 
         */
        public Builder enabled(Boolean enabled) {
            return enabled(Output.of(enabled));
        }

        /**
         * @param vpcConfiguration Configuration of the virtual private cloud (VPC) connection. For more info, see the [AWS documentation](https://docs.aws.amazon.com/iot/latest/developerguide/vpc-rule-action.html).
         * 
         * @return builder
         * 
         */
        public Builder vpcConfiguration(@Nullable Output<TopicRuleDestinationVpcConfigurationArgs> vpcConfiguration) {
            $.vpcConfiguration = vpcConfiguration;
            return this;
        }

        /**
         * @param vpcConfiguration Configuration of the virtual private cloud (VPC) connection. For more info, see the [AWS documentation](https://docs.aws.amazon.com/iot/latest/developerguide/vpc-rule-action.html).
         * 
         * @return builder
         * 
         */
        public Builder vpcConfiguration(TopicRuleDestinationVpcConfigurationArgs vpcConfiguration) {
            return vpcConfiguration(Output.of(vpcConfiguration));
        }

        public TopicRuleDestinationState build() {
            return $;
        }
    }

}
