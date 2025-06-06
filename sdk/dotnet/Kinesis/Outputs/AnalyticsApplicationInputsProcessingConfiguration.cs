// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kinesis.Outputs
{

    [OutputType]
    public sealed class AnalyticsApplicationInputsProcessingConfiguration
    {
        /// <summary>
        /// The Lambda function configuration. See Lambda below for more details.
        /// </summary>
        public readonly Outputs.AnalyticsApplicationInputsProcessingConfigurationLambda Lambda;

        [OutputConstructor]
        private AnalyticsApplicationInputsProcessingConfiguration(Outputs.AnalyticsApplicationInputsProcessingConfigurationLambda lambda)
        {
            Lambda = lambda;
        }
    }
}
