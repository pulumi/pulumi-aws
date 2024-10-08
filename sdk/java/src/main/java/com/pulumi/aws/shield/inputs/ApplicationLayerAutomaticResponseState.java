// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.shield.inputs;

import com.pulumi.aws.shield.inputs.ApplicationLayerAutomaticResponseTimeoutsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ApplicationLayerAutomaticResponseState extends com.pulumi.resources.ResourceArgs {

    public static final ApplicationLayerAutomaticResponseState Empty = new ApplicationLayerAutomaticResponseState();

    /**
     * One of `COUNT` or `BLOCK`
     * 
     */
    @Import(name="action")
    private @Nullable Output<String> action;

    /**
     * @return One of `COUNT` or `BLOCK`
     * 
     */
    public Optional<Output<String>> action() {
        return Optional.ofNullable(this.action);
    }

    /**
     * ARN of the resource to protect (Cloudfront Distributions and ALBs only at this time).
     * 
     */
    @Import(name="resourceArn")
    private @Nullable Output<String> resourceArn;

    /**
     * @return ARN of the resource to protect (Cloudfront Distributions and ALBs only at this time).
     * 
     */
    public Optional<Output<String>> resourceArn() {
        return Optional.ofNullable(this.resourceArn);
    }

    @Import(name="timeouts")
    private @Nullable Output<ApplicationLayerAutomaticResponseTimeoutsArgs> timeouts;

    public Optional<Output<ApplicationLayerAutomaticResponseTimeoutsArgs>> timeouts() {
        return Optional.ofNullable(this.timeouts);
    }

    private ApplicationLayerAutomaticResponseState() {}

    private ApplicationLayerAutomaticResponseState(ApplicationLayerAutomaticResponseState $) {
        this.action = $.action;
        this.resourceArn = $.resourceArn;
        this.timeouts = $.timeouts;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ApplicationLayerAutomaticResponseState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ApplicationLayerAutomaticResponseState $;

        public Builder() {
            $ = new ApplicationLayerAutomaticResponseState();
        }

        public Builder(ApplicationLayerAutomaticResponseState defaults) {
            $ = new ApplicationLayerAutomaticResponseState(Objects.requireNonNull(defaults));
        }

        /**
         * @param action One of `COUNT` or `BLOCK`
         * 
         * @return builder
         * 
         */
        public Builder action(@Nullable Output<String> action) {
            $.action = action;
            return this;
        }

        /**
         * @param action One of `COUNT` or `BLOCK`
         * 
         * @return builder
         * 
         */
        public Builder action(String action) {
            return action(Output.of(action));
        }

        /**
         * @param resourceArn ARN of the resource to protect (Cloudfront Distributions and ALBs only at this time).
         * 
         * @return builder
         * 
         */
        public Builder resourceArn(@Nullable Output<String> resourceArn) {
            $.resourceArn = resourceArn;
            return this;
        }

        /**
         * @param resourceArn ARN of the resource to protect (Cloudfront Distributions and ALBs only at this time).
         * 
         * @return builder
         * 
         */
        public Builder resourceArn(String resourceArn) {
            return resourceArn(Output.of(resourceArn));
        }

        public Builder timeouts(@Nullable Output<ApplicationLayerAutomaticResponseTimeoutsArgs> timeouts) {
            $.timeouts = timeouts;
            return this;
        }

        public Builder timeouts(ApplicationLayerAutomaticResponseTimeoutsArgs timeouts) {
            return timeouts(Output.of(timeouts));
        }

        public ApplicationLayerAutomaticResponseState build() {
            return $;
        }
    }

}
