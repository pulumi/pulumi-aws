// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.timestreamquery.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class ScheduledQueryNotificationConfigurationSnsConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final ScheduledQueryNotificationConfigurationSnsConfigurationArgs Empty = new ScheduledQueryNotificationConfigurationSnsConfigurationArgs();

    /**
     * SNS topic ARN that the scheduled query status notifications will be sent to.
     * 
     */
    @Import(name="topicArn", required=true)
    private Output<String> topicArn;

    /**
     * @return SNS topic ARN that the scheduled query status notifications will be sent to.
     * 
     */
    public Output<String> topicArn() {
        return this.topicArn;
    }

    private ScheduledQueryNotificationConfigurationSnsConfigurationArgs() {}

    private ScheduledQueryNotificationConfigurationSnsConfigurationArgs(ScheduledQueryNotificationConfigurationSnsConfigurationArgs $) {
        this.topicArn = $.topicArn;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ScheduledQueryNotificationConfigurationSnsConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ScheduledQueryNotificationConfigurationSnsConfigurationArgs $;

        public Builder() {
            $ = new ScheduledQueryNotificationConfigurationSnsConfigurationArgs();
        }

        public Builder(ScheduledQueryNotificationConfigurationSnsConfigurationArgs defaults) {
            $ = new ScheduledQueryNotificationConfigurationSnsConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param topicArn SNS topic ARN that the scheduled query status notifications will be sent to.
         * 
         * @return builder
         * 
         */
        public Builder topicArn(Output<String> topicArn) {
            $.topicArn = topicArn;
            return this;
        }

        /**
         * @param topicArn SNS topic ARN that the scheduled query status notifications will be sent to.
         * 
         * @return builder
         * 
         */
        public Builder topicArn(String topicArn) {
            return topicArn(Output.of(topicArn));
        }

        public ScheduledQueryNotificationConfigurationSnsConfigurationArgs build() {
            if ($.topicArn == null) {
                throw new MissingRequiredPropertyException("ScheduledQueryNotificationConfigurationSnsConfigurationArgs", "topicArn");
            }
            return $;
        }
    }

}
