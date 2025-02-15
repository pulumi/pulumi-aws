// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.autoscaling.inputs;

import com.pulumi.aws.autoscaling.inputs.GetAmiIdsFilterArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetAmiIdsArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetAmiIdsArgs Empty = new GetAmiIdsArgs();

    /**
     * Filter used to scope the list e.g., by tags. See [related docs](http://docs.aws.amazon.com/AutoScaling/latest/APIReference/API_Filter.html).
     * 
     */
    @Import(name="filters")
    private @Nullable Output<List<GetAmiIdsFilterArgs>> filters;

    /**
     * @return Filter used to scope the list e.g., by tags. See [related docs](http://docs.aws.amazon.com/AutoScaling/latest/APIReference/API_Filter.html).
     * 
     */
    public Optional<Output<List<GetAmiIdsFilterArgs>>> filters() {
        return Optional.ofNullable(this.filters);
    }

    /**
     * List of autoscaling group names
     * 
     */
    @Import(name="names")
    private @Nullable Output<List<String>> names;

    /**
     * @return List of autoscaling group names
     * 
     */
    public Optional<Output<List<String>>> names() {
        return Optional.ofNullable(this.names);
    }

    private GetAmiIdsArgs() {}

    private GetAmiIdsArgs(GetAmiIdsArgs $) {
        this.filters = $.filters;
        this.names = $.names;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetAmiIdsArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetAmiIdsArgs $;

        public Builder() {
            $ = new GetAmiIdsArgs();
        }

        public Builder(GetAmiIdsArgs defaults) {
            $ = new GetAmiIdsArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param filters Filter used to scope the list e.g., by tags. See [related docs](http://docs.aws.amazon.com/AutoScaling/latest/APIReference/API_Filter.html).
         * 
         * @return builder
         * 
         */
        public Builder filters(@Nullable Output<List<GetAmiIdsFilterArgs>> filters) {
            $.filters = filters;
            return this;
        }

        /**
         * @param filters Filter used to scope the list e.g., by tags. See [related docs](http://docs.aws.amazon.com/AutoScaling/latest/APIReference/API_Filter.html).
         * 
         * @return builder
         * 
         */
        public Builder filters(List<GetAmiIdsFilterArgs> filters) {
            return filters(Output.of(filters));
        }

        /**
         * @param filters Filter used to scope the list e.g., by tags. See [related docs](http://docs.aws.amazon.com/AutoScaling/latest/APIReference/API_Filter.html).
         * 
         * @return builder
         * 
         */
        public Builder filters(GetAmiIdsFilterArgs... filters) {
            return filters(List.of(filters));
        }

        /**
         * @param names List of autoscaling group names
         * 
         * @return builder
         * 
         */
        public Builder names(@Nullable Output<List<String>> names) {
            $.names = names;
            return this;
        }

        /**
         * @param names List of autoscaling group names
         * 
         * @return builder
         * 
         */
        public Builder names(List<String> names) {
            return names(Output.of(names));
        }

        /**
         * @param names List of autoscaling group names
         * 
         * @return builder
         * 
         */
        public Builder names(String... names) {
            return names(List.of(names));
        }

        public GetAmiIdsArgs build() {
            return $;
        }
    }

}
