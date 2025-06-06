// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock.Inputs
{

    public sealed class AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Configuration block for intermedia S3 storage.
        /// </summary>
        [Input("s3Location")]
        public Input<Inputs.AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageS3LocationArgs>? S3Location { get; set; }

        public AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageArgs()
        {
        }
        public static new AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageArgs Empty => new AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageArgs();
    }
}
