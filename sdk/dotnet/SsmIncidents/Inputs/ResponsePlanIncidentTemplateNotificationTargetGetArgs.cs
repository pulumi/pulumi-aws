// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SsmIncidents.Inputs
{

    public sealed class ResponsePlanIncidentTemplateNotificationTargetGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ARN of the Amazon SNS topic.
        /// </summary>
        [Input("snsTopicArn", required: true)]
        public Input<string> SnsTopicArn { get; set; } = null!;

        public ResponsePlanIncidentTemplateNotificationTargetGetArgs()
        {
        }
        public static new ResponsePlanIncidentTemplateNotificationTargetGetArgs Empty => new ResponsePlanIncidentTemplateNotificationTargetGetArgs();
    }
}
