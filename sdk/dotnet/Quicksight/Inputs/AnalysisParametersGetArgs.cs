// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Quicksight.Inputs
{

    public sealed class AnalysisParametersGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("dateTimeParameters")]
        private InputList<Inputs.AnalysisParametersDateTimeParameterGetArgs>? _dateTimeParameters;

        /// <summary>
        /// A list of parameters that have a data type of date-time. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_DateTimeParameter.html).
        /// </summary>
        public InputList<Inputs.AnalysisParametersDateTimeParameterGetArgs> DateTimeParameters
        {
            get => _dateTimeParameters ?? (_dateTimeParameters = new InputList<Inputs.AnalysisParametersDateTimeParameterGetArgs>());
            set => _dateTimeParameters = value;
        }

        [Input("decimalParameters")]
        private InputList<Inputs.AnalysisParametersDecimalParameterGetArgs>? _decimalParameters;

        /// <summary>
        /// A list of parameters that have a data type of decimal. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_DecimalParameter.html).
        /// </summary>
        public InputList<Inputs.AnalysisParametersDecimalParameterGetArgs> DecimalParameters
        {
            get => _decimalParameters ?? (_decimalParameters = new InputList<Inputs.AnalysisParametersDecimalParameterGetArgs>());
            set => _decimalParameters = value;
        }

        [Input("integerParameters")]
        private InputList<Inputs.AnalysisParametersIntegerParameterGetArgs>? _integerParameters;

        /// <summary>
        /// A list of parameters that have a data type of integer. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_IntegerParameter.html).
        /// </summary>
        public InputList<Inputs.AnalysisParametersIntegerParameterGetArgs> IntegerParameters
        {
            get => _integerParameters ?? (_integerParameters = new InputList<Inputs.AnalysisParametersIntegerParameterGetArgs>());
            set => _integerParameters = value;
        }

        [Input("stringParameters")]
        private InputList<Inputs.AnalysisParametersStringParameterGetArgs>? _stringParameters;

        /// <summary>
        /// A list of parameters that have a data type of string. See [AWS API Documentation for complete description](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_StringParameter.html).
        /// </summary>
        public InputList<Inputs.AnalysisParametersStringParameterGetArgs> StringParameters
        {
            get => _stringParameters ?? (_stringParameters = new InputList<Inputs.AnalysisParametersStringParameterGetArgs>());
            set => _stringParameters = value;
        }

        public AnalysisParametersGetArgs()
        {
        }
        public static new AnalysisParametersGetArgs Empty => new AnalysisParametersGetArgs();
    }
}
