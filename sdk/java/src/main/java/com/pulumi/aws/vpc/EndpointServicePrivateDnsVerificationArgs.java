// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.vpc;

import com.pulumi.aws.vpc.inputs.EndpointServicePrivateDnsVerificationTimeoutsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class EndpointServicePrivateDnsVerificationArgs extends com.pulumi.resources.ResourceArgs {

    public static final EndpointServicePrivateDnsVerificationArgs Empty = new EndpointServicePrivateDnsVerificationArgs();

    /**
     * ID of the endpoint service.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="serviceId", required=true)
    private Output<String> serviceId;

    /**
     * @return ID of the endpoint service.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> serviceId() {
        return this.serviceId;
    }

    @Import(name="timeouts")
    private @Nullable Output<EndpointServicePrivateDnsVerificationTimeoutsArgs> timeouts;

    public Optional<Output<EndpointServicePrivateDnsVerificationTimeoutsArgs>> timeouts() {
        return Optional.ofNullable(this.timeouts);
    }

    /**
     * Whether to wait until the endpoint service returns a `Verified` status for the configured private DNS name.
     * 
     */
    @Import(name="waitForVerification")
    private @Nullable Output<Boolean> waitForVerification;

    /**
     * @return Whether to wait until the endpoint service returns a `Verified` status for the configured private DNS name.
     * 
     */
    public Optional<Output<Boolean>> waitForVerification() {
        return Optional.ofNullable(this.waitForVerification);
    }

    private EndpointServicePrivateDnsVerificationArgs() {}

    private EndpointServicePrivateDnsVerificationArgs(EndpointServicePrivateDnsVerificationArgs $) {
        this.serviceId = $.serviceId;
        this.timeouts = $.timeouts;
        this.waitForVerification = $.waitForVerification;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(EndpointServicePrivateDnsVerificationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private EndpointServicePrivateDnsVerificationArgs $;

        public Builder() {
            $ = new EndpointServicePrivateDnsVerificationArgs();
        }

        public Builder(EndpointServicePrivateDnsVerificationArgs defaults) {
            $ = new EndpointServicePrivateDnsVerificationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param serviceId ID of the endpoint service.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder serviceId(Output<String> serviceId) {
            $.serviceId = serviceId;
            return this;
        }

        /**
         * @param serviceId ID of the endpoint service.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder serviceId(String serviceId) {
            return serviceId(Output.of(serviceId));
        }

        public Builder timeouts(@Nullable Output<EndpointServicePrivateDnsVerificationTimeoutsArgs> timeouts) {
            $.timeouts = timeouts;
            return this;
        }

        public Builder timeouts(EndpointServicePrivateDnsVerificationTimeoutsArgs timeouts) {
            return timeouts(Output.of(timeouts));
        }

        /**
         * @param waitForVerification Whether to wait until the endpoint service returns a `Verified` status for the configured private DNS name.
         * 
         * @return builder
         * 
         */
        public Builder waitForVerification(@Nullable Output<Boolean> waitForVerification) {
            $.waitForVerification = waitForVerification;
            return this;
        }

        /**
         * @param waitForVerification Whether to wait until the endpoint service returns a `Verified` status for the configured private DNS name.
         * 
         * @return builder
         * 
         */
        public Builder waitForVerification(Boolean waitForVerification) {
            return waitForVerification(Output.of(waitForVerification));
        }

        public EndpointServicePrivateDnsVerificationArgs build() {
            if ($.serviceId == null) {
                throw new MissingRequiredPropertyException("EndpointServicePrivateDnsVerificationArgs", "serviceId");
            }
            return $;
        }
    }

}
