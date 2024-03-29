// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.kendra.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ExperienceEndpointArgs extends com.pulumi.resources.ResourceArgs {

    public static final ExperienceEndpointArgs Empty = new ExperienceEndpointArgs();

    /**
     * The endpoint of your Amazon Kendra experience.
     * 
     */
    @Import(name="endpoint")
    private @Nullable Output<String> endpoint;

    /**
     * @return The endpoint of your Amazon Kendra experience.
     * 
     */
    public Optional<Output<String>> endpoint() {
        return Optional.ofNullable(this.endpoint);
    }

    /**
     * The type of endpoint for your Amazon Kendra experience.
     * 
     */
    @Import(name="endpointType")
    private @Nullable Output<String> endpointType;

    /**
     * @return The type of endpoint for your Amazon Kendra experience.
     * 
     */
    public Optional<Output<String>> endpointType() {
        return Optional.ofNullable(this.endpointType);
    }

    private ExperienceEndpointArgs() {}

    private ExperienceEndpointArgs(ExperienceEndpointArgs $) {
        this.endpoint = $.endpoint;
        this.endpointType = $.endpointType;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ExperienceEndpointArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ExperienceEndpointArgs $;

        public Builder() {
            $ = new ExperienceEndpointArgs();
        }

        public Builder(ExperienceEndpointArgs defaults) {
            $ = new ExperienceEndpointArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param endpoint The endpoint of your Amazon Kendra experience.
         * 
         * @return builder
         * 
         */
        public Builder endpoint(@Nullable Output<String> endpoint) {
            $.endpoint = endpoint;
            return this;
        }

        /**
         * @param endpoint The endpoint of your Amazon Kendra experience.
         * 
         * @return builder
         * 
         */
        public Builder endpoint(String endpoint) {
            return endpoint(Output.of(endpoint));
        }

        /**
         * @param endpointType The type of endpoint for your Amazon Kendra experience.
         * 
         * @return builder
         * 
         */
        public Builder endpointType(@Nullable Output<String> endpointType) {
            $.endpointType = endpointType;
            return this;
        }

        /**
         * @param endpointType The type of endpoint for your Amazon Kendra experience.
         * 
         * @return builder
         * 
         */
        public Builder endpointType(String endpointType) {
            return endpointType(Output.of(endpointType));
        }

        public ExperienceEndpointArgs build() {
            return $;
        }
    }

}
