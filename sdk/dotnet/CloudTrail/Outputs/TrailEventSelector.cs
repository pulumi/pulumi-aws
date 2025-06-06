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
    public sealed class TrailEventSelector
    {
        /// <summary>
        /// Configuration block for data events. See details below.
        /// </summary>
        public readonly ImmutableArray<Outputs.TrailEventSelectorDataResource> DataResources;
        /// <summary>
        /// A set of event sources to exclude. Valid values include: `kms.amazonaws.com` and `rdsdata.amazonaws.com`. `include_management_events` must be set to`true` to allow this.
        /// </summary>
        public readonly ImmutableArray<string> ExcludeManagementEventSources;
        /// <summary>
        /// Whether to include management events for your trail. Defaults to `true`.
        /// </summary>
        public readonly bool? IncludeManagementEvents;
        /// <summary>
        /// Type of events to log. Valid values are `ReadOnly`, `WriteOnly`, `All`. Default value is `All`.
        /// </summary>
        public readonly string? ReadWriteType;

        [OutputConstructor]
        private TrailEventSelector(
            ImmutableArray<Outputs.TrailEventSelectorDataResource> dataResources,

            ImmutableArray<string> excludeManagementEventSources,

            bool? includeManagementEvents,

            string? readWriteType)
        {
            DataResources = dataResources;
            ExcludeManagementEventSources = excludeManagementEventSources;
            IncludeManagementEvents = includeManagementEvents;
            ReadWriteType = readWriteType;
        }
    }
}
