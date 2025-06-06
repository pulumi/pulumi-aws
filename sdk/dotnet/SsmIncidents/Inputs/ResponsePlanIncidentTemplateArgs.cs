// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SsmIncidents.Inputs
{

    public sealed class ResponsePlanIncidentTemplateArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A string used to stop Incident Manager from creating multiple incident records for the same incident.
        /// </summary>
        [Input("dedupeString")]
        public Input<string>? DedupeString { get; set; }

        /// <summary>
        /// The impact value of a generated incident. The following values are supported:
        /// </summary>
        [Input("impact", required: true)]
        public Input<int> Impact { get; set; } = null!;

        [Input("incidentTags")]
        private InputMap<string>? _incidentTags;

        /// <summary>
        /// The tags assigned to an incident template. When an incident starts, Incident Manager assigns the tags specified in the template to the incident.
        /// </summary>
        public InputMap<string> IncidentTags
        {
            get => _incidentTags ?? (_incidentTags = new InputMap<string>());
            set => _incidentTags = value;
        }

        [Input("notificationTargets")]
        private InputList<Inputs.ResponsePlanIncidentTemplateNotificationTargetArgs>? _notificationTargets;

        /// <summary>
        /// The Amazon Simple Notification Service (Amazon SNS) targets that this incident notifies when it is updated. The `notification_target` configuration block supports the following argument:
        /// </summary>
        public InputList<Inputs.ResponsePlanIncidentTemplateNotificationTargetArgs> NotificationTargets
        {
            get => _notificationTargets ?? (_notificationTargets = new InputList<Inputs.ResponsePlanIncidentTemplateNotificationTargetArgs>());
            set => _notificationTargets = value;
        }

        /// <summary>
        /// The summary of an incident.
        /// </summary>
        [Input("summary")]
        public Input<string>? Summary { get; set; }

        /// <summary>
        /// The title of a generated incident.
        /// </summary>
        [Input("title", required: true)]
        public Input<string> Title { get; set; } = null!;

        public ResponsePlanIncidentTemplateArgs()
        {
        }
        public static new ResponsePlanIncidentTemplateArgs Empty => new ResponsePlanIncidentTemplateArgs();
    }
}
