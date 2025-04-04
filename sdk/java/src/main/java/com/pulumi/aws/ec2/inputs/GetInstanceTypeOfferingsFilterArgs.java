// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;


public final class GetInstanceTypeOfferingsFilterArgs extends com.pulumi.resources.ResourceArgs {

    public static final GetInstanceTypeOfferingsFilterArgs Empty = new GetInstanceTypeOfferingsFilterArgs();

    /**
     * Name of the filter. The `location` filter depends on the top-level `location_type` argument and if not specified, defaults to the current region.
     * 
     */
    @Import(name="name", required=true)
    private Output<String> name;

    /**
     * @return Name of the filter. The `location` filter depends on the top-level `location_type` argument and if not specified, defaults to the current region.
     * 
     */
    public Output<String> name() {
        return this.name;
    }

    /**
     * List of one or more values for the filter.
     * 
     */
    @Import(name="values", required=true)
    private Output<List<String>> values;

    /**
     * @return List of one or more values for the filter.
     * 
     */
    public Output<List<String>> values() {
        return this.values;
    }

    private GetInstanceTypeOfferingsFilterArgs() {}

    private GetInstanceTypeOfferingsFilterArgs(GetInstanceTypeOfferingsFilterArgs $) {
        this.name = $.name;
        this.values = $.values;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetInstanceTypeOfferingsFilterArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetInstanceTypeOfferingsFilterArgs $;

        public Builder() {
            $ = new GetInstanceTypeOfferingsFilterArgs();
        }

        public Builder(GetInstanceTypeOfferingsFilterArgs defaults) {
            $ = new GetInstanceTypeOfferingsFilterArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param name Name of the filter. The `location` filter depends on the top-level `location_type` argument and if not specified, defaults to the current region.
         * 
         * @return builder
         * 
         */
        public Builder name(Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Name of the filter. The `location` filter depends on the top-level `location_type` argument and if not specified, defaults to the current region.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param values List of one or more values for the filter.
         * 
         * @return builder
         * 
         */
        public Builder values(Output<List<String>> values) {
            $.values = values;
            return this;
        }

        /**
         * @param values List of one or more values for the filter.
         * 
         * @return builder
         * 
         */
        public Builder values(List<String> values) {
            return values(Output.of(values));
        }

        /**
         * @param values List of one or more values for the filter.
         * 
         * @return builder
         * 
         */
        public Builder values(String... values) {
            return values(List.of(values));
        }

        public GetInstanceTypeOfferingsFilterArgs build() {
            if ($.name == null) {
                throw new MissingRequiredPropertyException("GetInstanceTypeOfferingsFilterArgs", "name");
            }
            if ($.values == null) {
                throw new MissingRequiredPropertyException("GetInstanceTypeOfferingsFilterArgs", "values");
            }
            return $;
        }
    }

}
