// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Evidently.Inputs
{

    public sealed class ProjectDataDeliveryArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A block that defines the CloudWatch Log Group that stores the evaluation events. See below.
        /// </summary>
        [Input("cloudwatchLogs")]
        public Input<Inputs.ProjectDataDeliveryCloudwatchLogsArgs>? CloudwatchLogs { get; set; }

        /// <summary>
        /// A block that defines the S3 bucket and prefix that stores the evaluation events. See below.
        /// </summary>
        [Input("s3Destination")]
        public Input<Inputs.ProjectDataDeliveryS3DestinationArgs>? S3Destination { get; set; }

        public ProjectDataDeliveryArgs()
        {
        }
        public static new ProjectDataDeliveryArgs Empty => new ProjectDataDeliveryArgs();
    }
}
