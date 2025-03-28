// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appflow.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.util.Objects;


public final class FlowSourceFlowConfigSourceConnectorPropertiesSapoDataPaginationConfigArgs extends com.pulumi.resources.ResourceArgs {

    public static final FlowSourceFlowConfigSourceConnectorPropertiesSapoDataPaginationConfigArgs Empty = new FlowSourceFlowConfigSourceConnectorPropertiesSapoDataPaginationConfigArgs();

    /**
     * he maximum number of records that Amazon AppFlow receives in each page of the response from your SAP application.
     * 
     */
    @Import(name="maxPageSize", required=true)
    private Output<Integer> maxPageSize;

    /**
     * @return he maximum number of records that Amazon AppFlow receives in each page of the response from your SAP application.
     * 
     */
    public Output<Integer> maxPageSize() {
        return this.maxPageSize;
    }

    private FlowSourceFlowConfigSourceConnectorPropertiesSapoDataPaginationConfigArgs() {}

    private FlowSourceFlowConfigSourceConnectorPropertiesSapoDataPaginationConfigArgs(FlowSourceFlowConfigSourceConnectorPropertiesSapoDataPaginationConfigArgs $) {
        this.maxPageSize = $.maxPageSize;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(FlowSourceFlowConfigSourceConnectorPropertiesSapoDataPaginationConfigArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private FlowSourceFlowConfigSourceConnectorPropertiesSapoDataPaginationConfigArgs $;

        public Builder() {
            $ = new FlowSourceFlowConfigSourceConnectorPropertiesSapoDataPaginationConfigArgs();
        }

        public Builder(FlowSourceFlowConfigSourceConnectorPropertiesSapoDataPaginationConfigArgs defaults) {
            $ = new FlowSourceFlowConfigSourceConnectorPropertiesSapoDataPaginationConfigArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param maxPageSize he maximum number of records that Amazon AppFlow receives in each page of the response from your SAP application.
         * 
         * @return builder
         * 
         */
        public Builder maxPageSize(Output<Integer> maxPageSize) {
            $.maxPageSize = maxPageSize;
            return this;
        }

        /**
         * @param maxPageSize he maximum number of records that Amazon AppFlow receives in each page of the response from your SAP application.
         * 
         * @return builder
         * 
         */
        public Builder maxPageSize(Integer maxPageSize) {
            return maxPageSize(Output.of(maxPageSize));
        }

        public FlowSourceFlowConfigSourceConnectorPropertiesSapoDataPaginationConfigArgs build() {
            if ($.maxPageSize == null) {
                throw new MissingRequiredPropertyException("FlowSourceFlowConfigSourceConnectorPropertiesSapoDataPaginationConfigArgs", "maxPageSize");
            }
            return $;
        }
    }

}
