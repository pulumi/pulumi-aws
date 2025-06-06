// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock.Outputs
{

    [OutputType]
    public sealed class AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorage
    {
        /// <summary>
        /// Configuration block for intermedia S3 storage.
        /// </summary>
        public readonly Outputs.AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageS3Location? S3Location;

        [OutputConstructor]
        private AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorage(Outputs.AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageS3Location? s3Location)
        {
            S3Location = s3Location;
        }
    }
}
