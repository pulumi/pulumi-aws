// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Outputs
{

    [OutputType]
    public sealed class FeatureGroupFeatureDefinitionCollectionConfig
    {
        public readonly Outputs.FeatureGroupFeatureDefinitionCollectionConfigVectorConfig? VectorConfig;

        [OutputConstructor]
        private FeatureGroupFeatureDefinitionCollectionConfig(Outputs.FeatureGroupFeatureDefinitionCollectionConfigVectorConfig? vectorConfig)
        {
            VectorConfig = vectorConfig;
        }
    }
}
