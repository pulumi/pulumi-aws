// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ecs.inputs;

import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetTaskExecutionCapacityProviderStrategy extends com.pulumi.resources.InvokeArgs {

    public static final GetTaskExecutionCapacityProviderStrategy Empty = new GetTaskExecutionCapacityProviderStrategy();

    /**
     * The number of tasks, at a minimum, to run on the specified capacity provider. Only one capacity provider in a capacity provider strategy can have a base defined. Defaults to `0`.
     * 
     */
    @Import(name="base")
    private @Nullable Integer base;

    /**
     * @return The number of tasks, at a minimum, to run on the specified capacity provider. Only one capacity provider in a capacity provider strategy can have a base defined. Defaults to `0`.
     * 
     */
    public Optional<Integer> base() {
        return Optional.ofNullable(this.base);
    }

    /**
     * Name of the capacity provider.
     * 
     */
    @Import(name="capacityProvider", required=true)
    private String capacityProvider;

    /**
     * @return Name of the capacity provider.
     * 
     */
    public String capacityProvider() {
        return this.capacityProvider;
    }

    /**
     * The relative percentage of the total number of launched tasks that should use the specified capacity provider. The `weight` value is taken into consideration after the `base` count of tasks has been satisfied. Defaults to `0`.
     * 
     */
    @Import(name="weight")
    private @Nullable Integer weight;

    /**
     * @return The relative percentage of the total number of launched tasks that should use the specified capacity provider. The `weight` value is taken into consideration after the `base` count of tasks has been satisfied. Defaults to `0`.
     * 
     */
    public Optional<Integer> weight() {
        return Optional.ofNullable(this.weight);
    }

    private GetTaskExecutionCapacityProviderStrategy() {}

    private GetTaskExecutionCapacityProviderStrategy(GetTaskExecutionCapacityProviderStrategy $) {
        this.base = $.base;
        this.capacityProvider = $.capacityProvider;
        this.weight = $.weight;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetTaskExecutionCapacityProviderStrategy defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetTaskExecutionCapacityProviderStrategy $;

        public Builder() {
            $ = new GetTaskExecutionCapacityProviderStrategy();
        }

        public Builder(GetTaskExecutionCapacityProviderStrategy defaults) {
            $ = new GetTaskExecutionCapacityProviderStrategy(Objects.requireNonNull(defaults));
        }

        /**
         * @param base The number of tasks, at a minimum, to run on the specified capacity provider. Only one capacity provider in a capacity provider strategy can have a base defined. Defaults to `0`.
         * 
         * @return builder
         * 
         */
        public Builder base(@Nullable Integer base) {
            $.base = base;
            return this;
        }

        /**
         * @param capacityProvider Name of the capacity provider.
         * 
         * @return builder
         * 
         */
        public Builder capacityProvider(String capacityProvider) {
            $.capacityProvider = capacityProvider;
            return this;
        }

        /**
         * @param weight The relative percentage of the total number of launched tasks that should use the specified capacity provider. The `weight` value is taken into consideration after the `base` count of tasks has been satisfied. Defaults to `0`.
         * 
         * @return builder
         * 
         */
        public Builder weight(@Nullable Integer weight) {
            $.weight = weight;
            return this;
        }

        public GetTaskExecutionCapacityProviderStrategy build() {
            if ($.capacityProvider == null) {
                throw new MissingRequiredPropertyException("GetTaskExecutionCapacityProviderStrategy", "capacityProvider");
            }
            return $;
        }
    }

}
