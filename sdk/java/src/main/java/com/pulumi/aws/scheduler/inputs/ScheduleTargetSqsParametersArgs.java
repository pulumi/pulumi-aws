// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.scheduler.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ScheduleTargetSqsParametersArgs extends com.pulumi.resources.ResourceArgs {

    public static final ScheduleTargetSqsParametersArgs Empty = new ScheduleTargetSqsParametersArgs();

    /**
     * FIFO message group ID to use as the target.
     * 
     */
    @Import(name="messageGroupId")
    private @Nullable Output<String> messageGroupId;

    /**
     * @return FIFO message group ID to use as the target.
     * 
     */
    public Optional<Output<String>> messageGroupId() {
        return Optional.ofNullable(this.messageGroupId);
    }

    private ScheduleTargetSqsParametersArgs() {}

    private ScheduleTargetSqsParametersArgs(ScheduleTargetSqsParametersArgs $) {
        this.messageGroupId = $.messageGroupId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ScheduleTargetSqsParametersArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ScheduleTargetSqsParametersArgs $;

        public Builder() {
            $ = new ScheduleTargetSqsParametersArgs();
        }

        public Builder(ScheduleTargetSqsParametersArgs defaults) {
            $ = new ScheduleTargetSqsParametersArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param messageGroupId FIFO message group ID to use as the target.
         * 
         * @return builder
         * 
         */
        public Builder messageGroupId(@Nullable Output<String> messageGroupId) {
            $.messageGroupId = messageGroupId;
            return this;
        }

        /**
         * @param messageGroupId FIFO message group ID to use as the target.
         * 
         * @return builder
         * 
         */
        public Builder messageGroupId(String messageGroupId) {
            return messageGroupId(Output.of(messageGroupId));
        }

        public ScheduleTargetSqsParametersArgs build() {
            return $;
        }
    }

}
