// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class DataQualityJobDefinitionDataQualityBaselineConfigArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The constraints resource for a monitoring job. Fields are documented below.
        /// </summary>
        [Input("constraintsResource")]
        public Input<Inputs.DataQualityJobDefinitionDataQualityBaselineConfigConstraintsResourceArgs>? ConstraintsResource { get; set; }

        /// <summary>
        /// The statistics resource for a monitoring job. Fields are documented below.
        /// </summary>
        [Input("statisticsResource")]
        public Input<Inputs.DataQualityJobDefinitionDataQualityBaselineConfigStatisticsResourceArgs>? StatisticsResource { get; set; }

        public DataQualityJobDefinitionDataQualityBaselineConfigArgs()
        {
        }
        public static new DataQualityJobDefinitionDataQualityBaselineConfigArgs Empty => new DataQualityJobDefinitionDataQualityBaselineConfigArgs();
    }
}
