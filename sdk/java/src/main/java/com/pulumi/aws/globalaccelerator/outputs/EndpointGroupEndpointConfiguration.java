// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.globalaccelerator.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class EndpointGroupEndpointConfiguration {
    /**
     * @return An ARN of an exposed cross-account attachment. See the [AWS documentation](https://docs.aws.amazon.com/global-accelerator/latest/dg/cross-account-resources.html) for more details.
     * 
     */
    private @Nullable String attachmentArn;
    /**
     * @return Indicates whether client IP address preservation is enabled for an Application Load Balancer endpoint. See the [AWS documentation](https://docs.aws.amazon.com/global-accelerator/latest/dg/preserve-client-ip-address.html) for more details. The default value is `false`.
     * **Note:** When client IP address preservation is enabled, the Global Accelerator service creates an EC2 Security Group in the VPC named `GlobalAccelerator` that must be deleted (potentially outside of the provider) before the VPC will successfully delete. If this EC2 Security Group is not deleted, the provider will retry the VPC deletion for a few minutes before reporting a `DependencyViolation` error. This cannot be resolved by re-running the provider.
     * 
     */
    private @Nullable Boolean clientIpPreservationEnabled;
    /**
     * @return An ID for the endpoint. If the endpoint is a Network Load Balancer or Application Load Balancer, this is the Amazon Resource Name (ARN) of the resource. If the endpoint is an Elastic IP address, this is the Elastic IP address allocation ID.
     * 
     */
    private @Nullable String endpointId;
    /**
     * @return The weight associated with the endpoint. When you add weights to endpoints, you configure AWS Global Accelerator to route traffic based on proportions that you specify.
     * 
     */
    private @Nullable Integer weight;

    private EndpointGroupEndpointConfiguration() {}
    /**
     * @return An ARN of an exposed cross-account attachment. See the [AWS documentation](https://docs.aws.amazon.com/global-accelerator/latest/dg/cross-account-resources.html) for more details.
     * 
     */
    public Optional<String> attachmentArn() {
        return Optional.ofNullable(this.attachmentArn);
    }
    /**
     * @return Indicates whether client IP address preservation is enabled for an Application Load Balancer endpoint. See the [AWS documentation](https://docs.aws.amazon.com/global-accelerator/latest/dg/preserve-client-ip-address.html) for more details. The default value is `false`.
     * **Note:** When client IP address preservation is enabled, the Global Accelerator service creates an EC2 Security Group in the VPC named `GlobalAccelerator` that must be deleted (potentially outside of the provider) before the VPC will successfully delete. If this EC2 Security Group is not deleted, the provider will retry the VPC deletion for a few minutes before reporting a `DependencyViolation` error. This cannot be resolved by re-running the provider.
     * 
     */
    public Optional<Boolean> clientIpPreservationEnabled() {
        return Optional.ofNullable(this.clientIpPreservationEnabled);
    }
    /**
     * @return An ID for the endpoint. If the endpoint is a Network Load Balancer or Application Load Balancer, this is the Amazon Resource Name (ARN) of the resource. If the endpoint is an Elastic IP address, this is the Elastic IP address allocation ID.
     * 
     */
    public Optional<String> endpointId() {
        return Optional.ofNullable(this.endpointId);
    }
    /**
     * @return The weight associated with the endpoint. When you add weights to endpoints, you configure AWS Global Accelerator to route traffic based on proportions that you specify.
     * 
     */
    public Optional<Integer> weight() {
        return Optional.ofNullable(this.weight);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(EndpointGroupEndpointConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String attachmentArn;
        private @Nullable Boolean clientIpPreservationEnabled;
        private @Nullable String endpointId;
        private @Nullable Integer weight;
        public Builder() {}
        public Builder(EndpointGroupEndpointConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.attachmentArn = defaults.attachmentArn;
    	      this.clientIpPreservationEnabled = defaults.clientIpPreservationEnabled;
    	      this.endpointId = defaults.endpointId;
    	      this.weight = defaults.weight;
        }

        @CustomType.Setter
        public Builder attachmentArn(@Nullable String attachmentArn) {

            this.attachmentArn = attachmentArn;
            return this;
        }
        @CustomType.Setter
        public Builder clientIpPreservationEnabled(@Nullable Boolean clientIpPreservationEnabled) {

            this.clientIpPreservationEnabled = clientIpPreservationEnabled;
            return this;
        }
        @CustomType.Setter
        public Builder endpointId(@Nullable String endpointId) {

            this.endpointId = endpointId;
            return this;
        }
        @CustomType.Setter
        public Builder weight(@Nullable Integer weight) {

            this.weight = weight;
            return this;
        }
        public EndpointGroupEndpointConfiguration build() {
            final var _resultValue = new EndpointGroupEndpointConfiguration();
            _resultValue.attachmentArn = attachmentArn;
            _resultValue.clientIpPreservationEnabled = clientIpPreservationEnabled;
            _resultValue.endpointId = endpointId;
            _resultValue.weight = weight;
            return _resultValue;
        }
    }
}
