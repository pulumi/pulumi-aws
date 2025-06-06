// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lambda.Outputs
{

    [OutputType]
    public sealed class AliasRoutingConfig
    {
        /// <summary>
        /// A map that defines the proportion of events that should be sent to different versions of a lambda function.
        /// </summary>
        public readonly ImmutableDictionary<string, double>? AdditionalVersionWeights;

        [OutputConstructor]
        private AliasRoutingConfig(ImmutableDictionary<string, double>? additionalVersionWeights)
        {
            AdditionalVersionWeights = additionalVersionWeights;
        }
    }
}
