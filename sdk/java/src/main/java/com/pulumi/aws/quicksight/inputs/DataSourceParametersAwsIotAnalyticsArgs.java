// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.quicksight.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class DataSourceParametersAwsIotAnalyticsArgs extends com.pulumi.resources.ResourceArgs {

    public static final DataSourceParametersAwsIotAnalyticsArgs Empty = new DataSourceParametersAwsIotAnalyticsArgs();

    /**
     * The name of the data set to which to connect.
     * 
     */
    @Import(name="dataSetName", required=true)
    private Output<String> dataSetName;

    /**
     * @return The name of the data set to which to connect.
     * 
     */
    public Output<String> dataSetName() {
        return this.dataSetName;
    }

    private DataSourceParametersAwsIotAnalyticsArgs() {}

    private DataSourceParametersAwsIotAnalyticsArgs(DataSourceParametersAwsIotAnalyticsArgs $) {
        this.dataSetName = $.dataSetName;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DataSourceParametersAwsIotAnalyticsArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DataSourceParametersAwsIotAnalyticsArgs $;

        public Builder() {
            $ = new DataSourceParametersAwsIotAnalyticsArgs();
        }

        public Builder(DataSourceParametersAwsIotAnalyticsArgs defaults) {
            $ = new DataSourceParametersAwsIotAnalyticsArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param dataSetName The name of the data set to which to connect.
         * 
         * @return builder
         * 
         */
        public Builder dataSetName(Output<String> dataSetName) {
            $.dataSetName = dataSetName;
            return this;
        }

        /**
         * @param dataSetName The name of the data set to which to connect.
         * 
         * @return builder
         * 
         */
        public Builder dataSetName(String dataSetName) {
            return dataSetName(Output.of(dataSetName));
        }

        public DataSourceParametersAwsIotAnalyticsArgs build() {
            if ($.dataSetName == null) {
                throw new MissingRequiredPropertyException("DataSourceParametersAwsIotAnalyticsArgs", "dataSetName");
            }
            return $;
        }
    }

}
