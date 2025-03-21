// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;


public final class GetNetworkInsightsPathFilterArgs extends com.pulumi.resources.ResourceArgs {

    public static final GetNetworkInsightsPathFilterArgs Empty = new GetNetworkInsightsPathFilterArgs();

    /**
     * Name of the filter field. Valid values can be found in the EC2 [`DescribeNetworkInsightsPaths`](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeNetworkInsightsPaths.html) API Reference.
     * 
     */
    @Import(name="name", required=true)
    private Output<String> name;

    /**
     * @return Name of the filter field. Valid values can be found in the EC2 [`DescribeNetworkInsightsPaths`](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeNetworkInsightsPaths.html) API Reference.
     * 
     */
    public Output<String> name() {
        return this.name;
    }

    /**
     * Set of values that are accepted for the given filter field. Results will be selected if any given value matches.
     * 
     */
    @Import(name="values", required=true)
    private Output<List<String>> values;

    /**
     * @return Set of values that are accepted for the given filter field. Results will be selected if any given value matches.
     * 
     */
    public Output<List<String>> values() {
        return this.values;
    }

    private GetNetworkInsightsPathFilterArgs() {}

    private GetNetworkInsightsPathFilterArgs(GetNetworkInsightsPathFilterArgs $) {
        this.name = $.name;
        this.values = $.values;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetNetworkInsightsPathFilterArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetNetworkInsightsPathFilterArgs $;

        public Builder() {
            $ = new GetNetworkInsightsPathFilterArgs();
        }

        public Builder(GetNetworkInsightsPathFilterArgs defaults) {
            $ = new GetNetworkInsightsPathFilterArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param name Name of the filter field. Valid values can be found in the EC2 [`DescribeNetworkInsightsPaths`](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeNetworkInsightsPaths.html) API Reference.
         * 
         * @return builder
         * 
         */
        public Builder name(Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Name of the filter field. Valid values can be found in the EC2 [`DescribeNetworkInsightsPaths`](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeNetworkInsightsPaths.html) API Reference.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param values Set of values that are accepted for the given filter field. Results will be selected if any given value matches.
         * 
         * @return builder
         * 
         */
        public Builder values(Output<List<String>> values) {
            $.values = values;
            return this;
        }

        /**
         * @param values Set of values that are accepted for the given filter field. Results will be selected if any given value matches.
         * 
         * @return builder
         * 
         */
        public Builder values(List<String> values) {
            return values(Output.of(values));
        }

        /**
         * @param values Set of values that are accepted for the given filter field. Results will be selected if any given value matches.
         * 
         * @return builder
         * 
         */
        public Builder values(String... values) {
            return values(List.of(values));
        }

        public GetNetworkInsightsPathFilterArgs build() {
            if ($.name == null) {
                throw new MissingRequiredPropertyException("GetNetworkInsightsPathFilterArgs", "name");
            }
            if ($.values == null) {
                throw new MissingRequiredPropertyException("GetNetworkInsightsPathFilterArgs", "values");
            }
            return $;
        }
    }

}
