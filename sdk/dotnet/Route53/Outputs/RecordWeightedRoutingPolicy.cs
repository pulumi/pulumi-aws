// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Route53.Outputs
{

    [OutputType]
    public sealed class RecordWeightedRoutingPolicy
    {
        /// <summary>
        /// A numeric value indicating the relative weight of the record. See http://docs.aws.amazon.com/Route53/latest/DeveloperGuide/routing-policy.html#routing-policy-weighted.
        /// </summary>
        public readonly int Weight;

        [OutputConstructor]
        private RecordWeightedRoutingPolicy(int weight)
        {
            Weight = weight;
        }
    }
}
