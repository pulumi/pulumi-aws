// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ses.Outputs
{

    [OutputType]
    public sealed class EventDestinationKinesisDestination
    {
        /// <summary>
        /// The ARN of the role that has permissions to access the Kinesis Stream
        /// </summary>
        public readonly string RoleArn;
        /// <summary>
        /// The ARN of the Kinesis Stream
        /// </summary>
        public readonly string StreamArn;

        [OutputConstructor]
        private EventDestinationKinesisDestination(
            string roleArn,

            string streamArn)
        {
            RoleArn = roleArn;
            StreamArn = streamArn;
        }
    }
}
