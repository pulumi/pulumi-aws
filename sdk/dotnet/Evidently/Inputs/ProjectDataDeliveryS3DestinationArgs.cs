// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Evidently.Inputs
{

    public sealed class ProjectDataDeliveryS3DestinationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The name of the bucket in which Evidently stores evaluation events.
        /// </summary>
        [Input("bucket")]
        public Input<string>? Bucket { get; set; }

        /// <summary>
        /// The bucket prefix in which Evidently stores evaluation events.
        /// </summary>
        [Input("prefix")]
        public Input<string>? Prefix { get; set; }

        public ProjectDataDeliveryS3DestinationArgs()
        {
        }
        public static new ProjectDataDeliveryS3DestinationArgs Empty => new ProjectDataDeliveryS3DestinationArgs();
    }
}
