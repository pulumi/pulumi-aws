// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CustomerProfiles.Outputs
{

    [OutputType]
    public sealed class DomainMatchingAutoMergingConsolidation
    {
        /// <summary>
        /// A list of matching criteria.
        /// </summary>
        public readonly ImmutableArray<ImmutableArray<string>> MatchingAttributesLists;

        [OutputConstructor]
        private DomainMatchingAutoMergingConsolidation(ImmutableArray<ImmutableArray<string>> matchingAttributesLists)
        {
            MatchingAttributesLists = matchingAttributesLists;
        }
    }
}
