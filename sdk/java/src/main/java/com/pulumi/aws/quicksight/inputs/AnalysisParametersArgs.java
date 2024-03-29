// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.quicksight.inputs;

import com.pulumi.aws.quicksight.inputs.AnalysisParametersDateTimeParameterArgs;
import com.pulumi.aws.quicksight.inputs.AnalysisParametersDecimalParameterArgs;
import com.pulumi.aws.quicksight.inputs.AnalysisParametersIntegerParameterArgs;
import com.pulumi.aws.quicksight.inputs.AnalysisParametersStringParameterArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class AnalysisParametersArgs extends com.pulumi.resources.ResourceArgs {

    public static final AnalysisParametersArgs Empty = new AnalysisParametersArgs();

    /**
     * A list of parameters that have a data type of date-time. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_DateTimeParameter.html).
     * 
     */
    @Import(name="dateTimeParameters")
    private @Nullable Output<List<AnalysisParametersDateTimeParameterArgs>> dateTimeParameters;

    /**
     * @return A list of parameters that have a data type of date-time. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_DateTimeParameter.html).
     * 
     */
    public Optional<Output<List<AnalysisParametersDateTimeParameterArgs>>> dateTimeParameters() {
        return Optional.ofNullable(this.dateTimeParameters);
    }

    /**
     * A list of parameters that have a data type of decimal. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_DecimalParameter.html).
     * 
     */
    @Import(name="decimalParameters")
    private @Nullable Output<List<AnalysisParametersDecimalParameterArgs>> decimalParameters;

    /**
     * @return A list of parameters that have a data type of decimal. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_DecimalParameter.html).
     * 
     */
    public Optional<Output<List<AnalysisParametersDecimalParameterArgs>>> decimalParameters() {
        return Optional.ofNullable(this.decimalParameters);
    }

    /**
     * A list of parameters that have a data type of integer. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_IntegerParameter.html).
     * 
     */
    @Import(name="integerParameters")
    private @Nullable Output<List<AnalysisParametersIntegerParameterArgs>> integerParameters;

    /**
     * @return A list of parameters that have a data type of integer. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_IntegerParameter.html).
     * 
     */
    public Optional<Output<List<AnalysisParametersIntegerParameterArgs>>> integerParameters() {
        return Optional.ofNullable(this.integerParameters);
    }

    /**
     * A list of parameters that have a data type of string. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_StringParameter.html).
     * 
     */
    @Import(name="stringParameters")
    private @Nullable Output<List<AnalysisParametersStringParameterArgs>> stringParameters;

    /**
     * @return A list of parameters that have a data type of string. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_StringParameter.html).
     * 
     */
    public Optional<Output<List<AnalysisParametersStringParameterArgs>>> stringParameters() {
        return Optional.ofNullable(this.stringParameters);
    }

    private AnalysisParametersArgs() {}

    private AnalysisParametersArgs(AnalysisParametersArgs $) {
        this.dateTimeParameters = $.dateTimeParameters;
        this.decimalParameters = $.decimalParameters;
        this.integerParameters = $.integerParameters;
        this.stringParameters = $.stringParameters;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AnalysisParametersArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AnalysisParametersArgs $;

        public Builder() {
            $ = new AnalysisParametersArgs();
        }

        public Builder(AnalysisParametersArgs defaults) {
            $ = new AnalysisParametersArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param dateTimeParameters A list of parameters that have a data type of date-time. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_DateTimeParameter.html).
         * 
         * @return builder
         * 
         */
        public Builder dateTimeParameters(@Nullable Output<List<AnalysisParametersDateTimeParameterArgs>> dateTimeParameters) {
            $.dateTimeParameters = dateTimeParameters;
            return this;
        }

        /**
         * @param dateTimeParameters A list of parameters that have a data type of date-time. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_DateTimeParameter.html).
         * 
         * @return builder
         * 
         */
        public Builder dateTimeParameters(List<AnalysisParametersDateTimeParameterArgs> dateTimeParameters) {
            return dateTimeParameters(Output.of(dateTimeParameters));
        }

        /**
         * @param dateTimeParameters A list of parameters that have a data type of date-time. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_DateTimeParameter.html).
         * 
         * @return builder
         * 
         */
        public Builder dateTimeParameters(AnalysisParametersDateTimeParameterArgs... dateTimeParameters) {
            return dateTimeParameters(List.of(dateTimeParameters));
        }

        /**
         * @param decimalParameters A list of parameters that have a data type of decimal. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_DecimalParameter.html).
         * 
         * @return builder
         * 
         */
        public Builder decimalParameters(@Nullable Output<List<AnalysisParametersDecimalParameterArgs>> decimalParameters) {
            $.decimalParameters = decimalParameters;
            return this;
        }

        /**
         * @param decimalParameters A list of parameters that have a data type of decimal. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_DecimalParameter.html).
         * 
         * @return builder
         * 
         */
        public Builder decimalParameters(List<AnalysisParametersDecimalParameterArgs> decimalParameters) {
            return decimalParameters(Output.of(decimalParameters));
        }

        /**
         * @param decimalParameters A list of parameters that have a data type of decimal. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_DecimalParameter.html).
         * 
         * @return builder
         * 
         */
        public Builder decimalParameters(AnalysisParametersDecimalParameterArgs... decimalParameters) {
            return decimalParameters(List.of(decimalParameters));
        }

        /**
         * @param integerParameters A list of parameters that have a data type of integer. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_IntegerParameter.html).
         * 
         * @return builder
         * 
         */
        public Builder integerParameters(@Nullable Output<List<AnalysisParametersIntegerParameterArgs>> integerParameters) {
            $.integerParameters = integerParameters;
            return this;
        }

        /**
         * @param integerParameters A list of parameters that have a data type of integer. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_IntegerParameter.html).
         * 
         * @return builder
         * 
         */
        public Builder integerParameters(List<AnalysisParametersIntegerParameterArgs> integerParameters) {
            return integerParameters(Output.of(integerParameters));
        }

        /**
         * @param integerParameters A list of parameters that have a data type of integer. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_IntegerParameter.html).
         * 
         * @return builder
         * 
         */
        public Builder integerParameters(AnalysisParametersIntegerParameterArgs... integerParameters) {
            return integerParameters(List.of(integerParameters));
        }

        /**
         * @param stringParameters A list of parameters that have a data type of string. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_StringParameter.html).
         * 
         * @return builder
         * 
         */
        public Builder stringParameters(@Nullable Output<List<AnalysisParametersStringParameterArgs>> stringParameters) {
            $.stringParameters = stringParameters;
            return this;
        }

        /**
         * @param stringParameters A list of parameters that have a data type of string. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_StringParameter.html).
         * 
         * @return builder
         * 
         */
        public Builder stringParameters(List<AnalysisParametersStringParameterArgs> stringParameters) {
            return stringParameters(Output.of(stringParameters));
        }

        /**
         * @param stringParameters A list of parameters that have a data type of string. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_StringParameter.html).
         * 
         * @return builder
         * 
         */
        public Builder stringParameters(AnalysisParametersStringParameterArgs... stringParameters) {
            return stringParameters(List.of(stringParameters));
        }

        public AnalysisParametersArgs build() {
            return $;
        }
    }

}
