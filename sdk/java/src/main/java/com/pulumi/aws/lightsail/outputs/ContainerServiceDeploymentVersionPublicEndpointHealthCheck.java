// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lightsail.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ContainerServiceDeploymentVersionPublicEndpointHealthCheck {
    /**
     * @return Number of consecutive health check successes required before moving the container to the Healthy state. Defaults to 2.
     * 
     */
    private @Nullable Integer healthyThreshold;
    /**
     * @return Approximate interval, in seconds, between health checks of an individual container. You can specify between 5 and 300 seconds. Defaults to 5.
     * 
     */
    private @Nullable Integer intervalSeconds;
    /**
     * @return Path on the container on which to perform the health check. Defaults to &#34;/&#34;.
     * 
     */
    private @Nullable String path;
    /**
     * @return HTTP codes to use when checking for a successful response from a container. You can specify values between 200 and 499. Defaults to &#34;200-499&#34;.
     * 
     */
    private @Nullable String successCodes;
    /**
     * @return Amount of time, in seconds, during which no response means a failed health check. You can specify between 2 and 60 seconds. Defaults to 2.
     * 
     */
    private @Nullable Integer timeoutSeconds;
    /**
     * @return Number of consecutive health check failures required before moving the container to the Unhealthy state. Defaults to 2.
     * 
     */
    private @Nullable Integer unhealthyThreshold;

    private ContainerServiceDeploymentVersionPublicEndpointHealthCheck() {}
    /**
     * @return Number of consecutive health check successes required before moving the container to the Healthy state. Defaults to 2.
     * 
     */
    public Optional<Integer> healthyThreshold() {
        return Optional.ofNullable(this.healthyThreshold);
    }
    /**
     * @return Approximate interval, in seconds, between health checks of an individual container. You can specify between 5 and 300 seconds. Defaults to 5.
     * 
     */
    public Optional<Integer> intervalSeconds() {
        return Optional.ofNullable(this.intervalSeconds);
    }
    /**
     * @return Path on the container on which to perform the health check. Defaults to &#34;/&#34;.
     * 
     */
    public Optional<String> path() {
        return Optional.ofNullable(this.path);
    }
    /**
     * @return HTTP codes to use when checking for a successful response from a container. You can specify values between 200 and 499. Defaults to &#34;200-499&#34;.
     * 
     */
    public Optional<String> successCodes() {
        return Optional.ofNullable(this.successCodes);
    }
    /**
     * @return Amount of time, in seconds, during which no response means a failed health check. You can specify between 2 and 60 seconds. Defaults to 2.
     * 
     */
    public Optional<Integer> timeoutSeconds() {
        return Optional.ofNullable(this.timeoutSeconds);
    }
    /**
     * @return Number of consecutive health check failures required before moving the container to the Unhealthy state. Defaults to 2.
     * 
     */
    public Optional<Integer> unhealthyThreshold() {
        return Optional.ofNullable(this.unhealthyThreshold);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ContainerServiceDeploymentVersionPublicEndpointHealthCheck defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Integer healthyThreshold;
        private @Nullable Integer intervalSeconds;
        private @Nullable String path;
        private @Nullable String successCodes;
        private @Nullable Integer timeoutSeconds;
        private @Nullable Integer unhealthyThreshold;
        public Builder() {}
        public Builder(ContainerServiceDeploymentVersionPublicEndpointHealthCheck defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.healthyThreshold = defaults.healthyThreshold;
    	      this.intervalSeconds = defaults.intervalSeconds;
    	      this.path = defaults.path;
    	      this.successCodes = defaults.successCodes;
    	      this.timeoutSeconds = defaults.timeoutSeconds;
    	      this.unhealthyThreshold = defaults.unhealthyThreshold;
        }

        @CustomType.Setter
        public Builder healthyThreshold(@Nullable Integer healthyThreshold) {

            this.healthyThreshold = healthyThreshold;
            return this;
        }
        @CustomType.Setter
        public Builder intervalSeconds(@Nullable Integer intervalSeconds) {

            this.intervalSeconds = intervalSeconds;
            return this;
        }
        @CustomType.Setter
        public Builder path(@Nullable String path) {

            this.path = path;
            return this;
        }
        @CustomType.Setter
        public Builder successCodes(@Nullable String successCodes) {

            this.successCodes = successCodes;
            return this;
        }
        @CustomType.Setter
        public Builder timeoutSeconds(@Nullable Integer timeoutSeconds) {

            this.timeoutSeconds = timeoutSeconds;
            return this;
        }
        @CustomType.Setter
        public Builder unhealthyThreshold(@Nullable Integer unhealthyThreshold) {

            this.unhealthyThreshold = unhealthyThreshold;
            return this;
        }
        public ContainerServiceDeploymentVersionPublicEndpointHealthCheck build() {
            final var _resultValue = new ContainerServiceDeploymentVersionPublicEndpointHealthCheck();
            _resultValue.healthyThreshold = healthyThreshold;
            _resultValue.intervalSeconds = intervalSeconds;
            _resultValue.path = path;
            _resultValue.successCodes = successCodes;
            _resultValue.timeoutSeconds = timeoutSeconds;
            _resultValue.unhealthyThreshold = unhealthyThreshold;
            return _resultValue;
        }
    }
}
