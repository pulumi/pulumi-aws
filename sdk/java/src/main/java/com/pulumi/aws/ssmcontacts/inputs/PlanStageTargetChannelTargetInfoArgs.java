// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssmcontacts.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class PlanStageTargetChannelTargetInfoArgs extends com.pulumi.resources.ResourceArgs {

    public static final PlanStageTargetChannelTargetInfoArgs Empty = new PlanStageTargetChannelTargetInfoArgs();

    @Import(name="contactChannelId", required=true)
    private Output<String> contactChannelId;

    public Output<String> contactChannelId() {
        return this.contactChannelId;
    }

    @Import(name="retryIntervalInMinutes")
    private @Nullable Output<Integer> retryIntervalInMinutes;

    public Optional<Output<Integer>> retryIntervalInMinutes() {
        return Optional.ofNullable(this.retryIntervalInMinutes);
    }

    private PlanStageTargetChannelTargetInfoArgs() {}

    private PlanStageTargetChannelTargetInfoArgs(PlanStageTargetChannelTargetInfoArgs $) {
        this.contactChannelId = $.contactChannelId;
        this.retryIntervalInMinutes = $.retryIntervalInMinutes;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(PlanStageTargetChannelTargetInfoArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private PlanStageTargetChannelTargetInfoArgs $;

        public Builder() {
            $ = new PlanStageTargetChannelTargetInfoArgs();
        }

        public Builder(PlanStageTargetChannelTargetInfoArgs defaults) {
            $ = new PlanStageTargetChannelTargetInfoArgs(Objects.requireNonNull(defaults));
        }

        public Builder contactChannelId(Output<String> contactChannelId) {
            $.contactChannelId = contactChannelId;
            return this;
        }

        public Builder contactChannelId(String contactChannelId) {
            return contactChannelId(Output.of(contactChannelId));
        }

        public Builder retryIntervalInMinutes(@Nullable Output<Integer> retryIntervalInMinutes) {
            $.retryIntervalInMinutes = retryIntervalInMinutes;
            return this;
        }

        public Builder retryIntervalInMinutes(Integer retryIntervalInMinutes) {
            return retryIntervalInMinutes(Output.of(retryIntervalInMinutes));
        }

        public PlanStageTargetChannelTargetInfoArgs build() {
            $.contactChannelId = Objects.requireNonNull($.contactChannelId, "expected parameter 'contactChannelId' to be non-null");
            return $;
        }
    }

}