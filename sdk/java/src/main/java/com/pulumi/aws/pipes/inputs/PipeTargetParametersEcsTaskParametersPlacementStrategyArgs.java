// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.pipes.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class PipeTargetParametersEcsTaskParametersPlacementStrategyArgs extends com.pulumi.resources.ResourceArgs {

    public static final PipeTargetParametersEcsTaskParametersPlacementStrategyArgs Empty = new PipeTargetParametersEcsTaskParametersPlacementStrategyArgs();

    /**
     * The field to apply the placement strategy against. For the spread placement strategy, valid values are instanceId (or host, which has the same effect), or any platform or custom attribute that is applied to a container instance, such as attribute:ecs.availability-zone. For the binpack placement strategy, valid values are cpu and memory. For the random placement strategy, this field is not used. Maximum length of 255.
     * 
     */
    @Import(name="field")
    private @Nullable Output<String> field;

    /**
     * @return The field to apply the placement strategy against. For the spread placement strategy, valid values are instanceId (or host, which has the same effect), or any platform or custom attribute that is applied to a container instance, such as attribute:ecs.availability-zone. For the binpack placement strategy, valid values are cpu and memory. For the random placement strategy, this field is not used. Maximum length of 255.
     * 
     */
    public Optional<Output<String>> field() {
        return Optional.ofNullable(this.field);
    }

    /**
     * The type of placement strategy. The random placement strategy randomly places tasks on available candidates. The spread placement strategy spreads placement across available candidates evenly based on the field parameter. The binpack strategy places tasks on available candidates that have the least available amount of the resource that is specified with the field parameter. For example, if you binpack on memory, a task is placed on the instance with the least amount of remaining memory (but still enough to run the task). Valid Values: random, spread, binpack.
     * 
     */
    @Import(name="type")
    private @Nullable Output<String> type;

    /**
     * @return The type of placement strategy. The random placement strategy randomly places tasks on available candidates. The spread placement strategy spreads placement across available candidates evenly based on the field parameter. The binpack strategy places tasks on available candidates that have the least available amount of the resource that is specified with the field parameter. For example, if you binpack on memory, a task is placed on the instance with the least amount of remaining memory (but still enough to run the task). Valid Values: random, spread, binpack.
     * 
     */
    public Optional<Output<String>> type() {
        return Optional.ofNullable(this.type);
    }

    private PipeTargetParametersEcsTaskParametersPlacementStrategyArgs() {}

    private PipeTargetParametersEcsTaskParametersPlacementStrategyArgs(PipeTargetParametersEcsTaskParametersPlacementStrategyArgs $) {
        this.field = $.field;
        this.type = $.type;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(PipeTargetParametersEcsTaskParametersPlacementStrategyArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private PipeTargetParametersEcsTaskParametersPlacementStrategyArgs $;

        public Builder() {
            $ = new PipeTargetParametersEcsTaskParametersPlacementStrategyArgs();
        }

        public Builder(PipeTargetParametersEcsTaskParametersPlacementStrategyArgs defaults) {
            $ = new PipeTargetParametersEcsTaskParametersPlacementStrategyArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param field The field to apply the placement strategy against. For the spread placement strategy, valid values are instanceId (or host, which has the same effect), or any platform or custom attribute that is applied to a container instance, such as attribute:ecs.availability-zone. For the binpack placement strategy, valid values are cpu and memory. For the random placement strategy, this field is not used. Maximum length of 255.
         * 
         * @return builder
         * 
         */
        public Builder field(@Nullable Output<String> field) {
            $.field = field;
            return this;
        }

        /**
         * @param field The field to apply the placement strategy against. For the spread placement strategy, valid values are instanceId (or host, which has the same effect), or any platform or custom attribute that is applied to a container instance, such as attribute:ecs.availability-zone. For the binpack placement strategy, valid values are cpu and memory. For the random placement strategy, this field is not used. Maximum length of 255.
         * 
         * @return builder
         * 
         */
        public Builder field(String field) {
            return field(Output.of(field));
        }

        /**
         * @param type The type of placement strategy. The random placement strategy randomly places tasks on available candidates. The spread placement strategy spreads placement across available candidates evenly based on the field parameter. The binpack strategy places tasks on available candidates that have the least available amount of the resource that is specified with the field parameter. For example, if you binpack on memory, a task is placed on the instance with the least amount of remaining memory (but still enough to run the task). Valid Values: random, spread, binpack.
         * 
         * @return builder
         * 
         */
        public Builder type(@Nullable Output<String> type) {
            $.type = type;
            return this;
        }

        /**
         * @param type The type of placement strategy. The random placement strategy randomly places tasks on available candidates. The spread placement strategy spreads placement across available candidates evenly based on the field parameter. The binpack strategy places tasks on available candidates that have the least available amount of the resource that is specified with the field parameter. For example, if you binpack on memory, a task is placed on the instance with the least amount of remaining memory (but still enough to run the task). Valid Values: random, spread, binpack.
         * 
         * @return builder
         * 
         */
        public Builder type(String type) {
            return type(Output.of(type));
        }

        public PipeTargetParametersEcsTaskParametersPlacementStrategyArgs build() {
            return $;
        }
    }

}
