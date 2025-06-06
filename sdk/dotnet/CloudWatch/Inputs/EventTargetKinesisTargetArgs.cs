// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudWatch.Inputs
{

    public sealed class EventTargetKinesisTargetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The JSON path to be extracted from the event and used as the partition key.
        /// </summary>
        [Input("partitionKeyPath")]
        public Input<string>? PartitionKeyPath { get; set; }

        public EventTargetKinesisTargetArgs()
        {
        }
        public static new EventTargetKinesisTargetArgs Empty => new EventTargetKinesisTargetArgs();
    }
}
