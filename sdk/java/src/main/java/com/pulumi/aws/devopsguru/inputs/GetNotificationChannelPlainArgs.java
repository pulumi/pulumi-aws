// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.devopsguru.inputs;

import com.pulumi.aws.devopsguru.inputs.GetNotificationChannelFilter;
import com.pulumi.aws.devopsguru.inputs.GetNotificationChannelSn;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetNotificationChannelPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetNotificationChannelPlainArgs Empty = new GetNotificationChannelPlainArgs();

    /**
     * Filter configurations for the Amazon SNS notification topic. See the `filters` attribute reference below.
     * 
     */
    @Import(name="filters")
    private @Nullable List<GetNotificationChannelFilter> filters;

    /**
     * @return Filter configurations for the Amazon SNS notification topic. See the `filters` attribute reference below.
     * 
     */
    public Optional<List<GetNotificationChannelFilter>> filters() {
        return Optional.ofNullable(this.filters);
    }

    /**
     * Unique identifier for the notification channel.
     * 
     */
    @Import(name="id", required=true)
    private String id;

    /**
     * @return Unique identifier for the notification channel.
     * 
     */
    public String id() {
        return this.id;
    }

    /**
     * SNS noficiation channel configurations. See the `sns` attribute reference below.
     * 
     */
    @Import(name="sns")
    private @Nullable List<GetNotificationChannelSn> sns;

    /**
     * @return SNS noficiation channel configurations. See the `sns` attribute reference below.
     * 
     */
    public Optional<List<GetNotificationChannelSn>> sns() {
        return Optional.ofNullable(this.sns);
    }

    private GetNotificationChannelPlainArgs() {}

    private GetNotificationChannelPlainArgs(GetNotificationChannelPlainArgs $) {
        this.filters = $.filters;
        this.id = $.id;
        this.sns = $.sns;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetNotificationChannelPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetNotificationChannelPlainArgs $;

        public Builder() {
            $ = new GetNotificationChannelPlainArgs();
        }

        public Builder(GetNotificationChannelPlainArgs defaults) {
            $ = new GetNotificationChannelPlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param filters Filter configurations for the Amazon SNS notification topic. See the `filters` attribute reference below.
         * 
         * @return builder
         * 
         */
        public Builder filters(@Nullable List<GetNotificationChannelFilter> filters) {
            $.filters = filters;
            return this;
        }

        /**
         * @param filters Filter configurations for the Amazon SNS notification topic. See the `filters` attribute reference below.
         * 
         * @return builder
         * 
         */
        public Builder filters(GetNotificationChannelFilter... filters) {
            return filters(List.of(filters));
        }

        /**
         * @param id Unique identifier for the notification channel.
         * 
         * @return builder
         * 
         */
        public Builder id(String id) {
            $.id = id;
            return this;
        }

        /**
         * @param sns SNS noficiation channel configurations. See the `sns` attribute reference below.
         * 
         * @return builder
         * 
         */
        public Builder sns(@Nullable List<GetNotificationChannelSn> sns) {
            $.sns = sns;
            return this;
        }

        /**
         * @param sns SNS noficiation channel configurations. See the `sns` attribute reference below.
         * 
         * @return builder
         * 
         */
        public Builder sns(GetNotificationChannelSn... sns) {
            return sns(List.of(sns));
        }

        public GetNotificationChannelPlainArgs build() {
            if ($.id == null) {
                throw new MissingRequiredPropertyException("GetNotificationChannelPlainArgs", "id");
            }
            return $;
        }
    }

}
