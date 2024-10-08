// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class DataQualityJobDefinitionDataQualityJobInputBatchTransformInputDatasetFormatCsvArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Indicates if the CSV data has a header.
        /// </summary>
        [Input("header")]
        public Input<bool>? Header { get; set; }

        public DataQualityJobDefinitionDataQualityJobInputBatchTransformInputDatasetFormatCsvArgs()
        {
        }
        public static new DataQualityJobDefinitionDataQualityJobInputBatchTransformInputDatasetFormatCsvArgs Empty => new DataQualityJobDefinitionDataQualityJobInputBatchTransformInputDatasetFormatCsvArgs();
    }
}
