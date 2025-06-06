// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Oam.Inputs
{

    public sealed class LinkLinkConfigurationLogGroupConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Filter string that specifies which log groups are to share their log events with the monitoring account. See [LogGroupConfiguration](https://docs.aws.amazon.com/OAM/latest/APIReference/API_LogGroupConfiguration.html) for details.
        /// </summary>
        [Input("filter", required: true)]
        public Input<string> Filter { get; set; } = null!;

        public LinkLinkConfigurationLogGroupConfigurationGetArgs()
        {
        }
        public static new LinkLinkConfigurationLogGroupConfigurationGetArgs Empty => new LinkLinkConfigurationLogGroupConfigurationGetArgs();
    }
}
