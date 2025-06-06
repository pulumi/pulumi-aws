// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2.Outputs
{

    [OutputType]
    public sealed class VpnConnectionTunnel2LogOptions
    {
        /// <summary>
        /// Options for sending VPN tunnel logs to CloudWatch. See CloudWatch Log Options below for more details.
        /// </summary>
        public readonly Outputs.VpnConnectionTunnel2LogOptionsCloudwatchLogOptions? CloudwatchLogOptions;

        [OutputConstructor]
        private VpnConnectionTunnel2LogOptions(Outputs.VpnConnectionTunnel2LogOptionsCloudwatchLogOptions? cloudwatchLogOptions)
        {
            CloudwatchLogOptions = cloudwatchLogOptions;
        }
    }
}
