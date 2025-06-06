// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudTrail.Outputs
{

    [OutputType]
    public sealed class EventDataStoreAdvancedEventSelector
    {
        /// <summary>
        /// Specifies the selector statements in an advanced event selector. Fields documented below.
        /// </summary>
        public readonly ImmutableArray<Outputs.EventDataStoreAdvancedEventSelectorFieldSelector> FieldSelectors;
        /// <summary>
        /// Specifies the name of the advanced event selector.
        /// </summary>
        public readonly string? Name;

        [OutputConstructor]
        private EventDataStoreAdvancedEventSelector(
            ImmutableArray<Outputs.EventDataStoreAdvancedEventSelectorFieldSelector> fieldSelectors,

            string? name)
        {
            FieldSelectors = fieldSelectors;
            Name = name;
        }
    }
}
