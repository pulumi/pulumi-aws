// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2ClientVpn.Outputs
{

    [OutputType]
    public sealed class EndpointConnectionLogOptions
    {
        /// <summary>
        /// The name of the CloudWatch Logs log group.
        /// </summary>
        public readonly string? CloudwatchLogGroup;
        /// <summary>
        /// The name of the CloudWatch Logs log stream to which the connection data is published.
        /// </summary>
        public readonly string? CloudwatchLogStream;
        /// <summary>
        /// Indicates whether connection logging is enabled.
        /// </summary>
        public readonly bool Enabled;

        [OutputConstructor]
        private EndpointConnectionLogOptions(
            string? cloudwatchLogGroup,

            string? cloudwatchLogStream,

            bool enabled)
        {
            CloudwatchLogGroup = cloudwatchLogGroup;
            CloudwatchLogStream = cloudwatchLogStream;
            Enabled = enabled;
        }
    }
}
