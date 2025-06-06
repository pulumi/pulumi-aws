// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudTrail.Inputs
{

    public sealed class TrailEventSelectorArgs : global::Pulumi.ResourceArgs
    {
        [Input("dataResources")]
        private InputList<Inputs.TrailEventSelectorDataResourceArgs>? _dataResources;

        /// <summary>
        /// Configuration block for data events. See details below.
        /// </summary>
        public InputList<Inputs.TrailEventSelectorDataResourceArgs> DataResources
        {
            get => _dataResources ?? (_dataResources = new InputList<Inputs.TrailEventSelectorDataResourceArgs>());
            set => _dataResources = value;
        }

        [Input("excludeManagementEventSources")]
        private InputList<string>? _excludeManagementEventSources;

        /// <summary>
        /// A set of event sources to exclude. Valid values include: `kms.amazonaws.com` and `rdsdata.amazonaws.com`. `include_management_events` must be set to`true` to allow this.
        /// </summary>
        public InputList<string> ExcludeManagementEventSources
        {
            get => _excludeManagementEventSources ?? (_excludeManagementEventSources = new InputList<string>());
            set => _excludeManagementEventSources = value;
        }

        /// <summary>
        /// Whether to include management events for your trail. Defaults to `true`.
        /// </summary>
        [Input("includeManagementEvents")]
        public Input<bool>? IncludeManagementEvents { get; set; }

        /// <summary>
        /// Type of events to log. Valid values are `ReadOnly`, `WriteOnly`, `All`. Default value is `All`.
        /// </summary>
        [Input("readWriteType")]
        public Input<string>? ReadWriteType { get; set; }

        public TrailEventSelectorArgs()
        {
        }
        public static new TrailEventSelectorArgs Empty => new TrailEventSelectorArgs();
    }
}
