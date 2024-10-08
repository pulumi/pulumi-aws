// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.apprunner.inputs;

import com.pulumi.aws.apprunner.inputs.DeploymentTimeoutsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class DeploymentState extends com.pulumi.resources.ResourceArgs {

    public static final DeploymentState Empty = new DeploymentState();

    /**
     * The unique ID of the operation associated with deployment.
     * 
     */
    @Import(name="operationId")
    private @Nullable Output<String> operationId;

    /**
     * @return The unique ID of the operation associated with deployment.
     * 
     */
    public Optional<Output<String>> operationId() {
        return Optional.ofNullable(this.operationId);
    }

    /**
     * The Amazon Resource Name (ARN) of the App Runner service to start the deployment for.
     * 
     */
    @Import(name="serviceArn")
    private @Nullable Output<String> serviceArn;

    /**
     * @return The Amazon Resource Name (ARN) of the App Runner service to start the deployment for.
     * 
     */
    public Optional<Output<String>> serviceArn() {
        return Optional.ofNullable(this.serviceArn);
    }

    /**
     * The current status of the App Runner service deployment.
     * 
     */
    @Import(name="status")
    private @Nullable Output<String> status;

    /**
     * @return The current status of the App Runner service deployment.
     * 
     */
    public Optional<Output<String>> status() {
        return Optional.ofNullable(this.status);
    }

    @Import(name="timeouts")
    private @Nullable Output<DeploymentTimeoutsArgs> timeouts;

    public Optional<Output<DeploymentTimeoutsArgs>> timeouts() {
        return Optional.ofNullable(this.timeouts);
    }

    private DeploymentState() {}

    private DeploymentState(DeploymentState $) {
        this.operationId = $.operationId;
        this.serviceArn = $.serviceArn;
        this.status = $.status;
        this.timeouts = $.timeouts;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DeploymentState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DeploymentState $;

        public Builder() {
            $ = new DeploymentState();
        }

        public Builder(DeploymentState defaults) {
            $ = new DeploymentState(Objects.requireNonNull(defaults));
        }

        /**
         * @param operationId The unique ID of the operation associated with deployment.
         * 
         * @return builder
         * 
         */
        public Builder operationId(@Nullable Output<String> operationId) {
            $.operationId = operationId;
            return this;
        }

        /**
         * @param operationId The unique ID of the operation associated with deployment.
         * 
         * @return builder
         * 
         */
        public Builder operationId(String operationId) {
            return operationId(Output.of(operationId));
        }

        /**
         * @param serviceArn The Amazon Resource Name (ARN) of the App Runner service to start the deployment for.
         * 
         * @return builder
         * 
         */
        public Builder serviceArn(@Nullable Output<String> serviceArn) {
            $.serviceArn = serviceArn;
            return this;
        }

        /**
         * @param serviceArn The Amazon Resource Name (ARN) of the App Runner service to start the deployment for.
         * 
         * @return builder
         * 
         */
        public Builder serviceArn(String serviceArn) {
            return serviceArn(Output.of(serviceArn));
        }

        /**
         * @param status The current status of the App Runner service deployment.
         * 
         * @return builder
         * 
         */
        public Builder status(@Nullable Output<String> status) {
            $.status = status;
            return this;
        }

        /**
         * @param status The current status of the App Runner service deployment.
         * 
         * @return builder
         * 
         */
        public Builder status(String status) {
            return status(Output.of(status));
        }

        public Builder timeouts(@Nullable Output<DeploymentTimeoutsArgs> timeouts) {
            $.timeouts = timeouts;
            return this;
        }

        public Builder timeouts(DeploymentTimeoutsArgs timeouts) {
            return timeouts(Output.of(timeouts));
        }

        public DeploymentState build() {
            return $;
        }
    }

}
