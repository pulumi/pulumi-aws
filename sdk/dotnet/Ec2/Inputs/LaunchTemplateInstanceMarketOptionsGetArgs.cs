// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2.Inputs
{

    public sealed class LaunchTemplateInstanceMarketOptionsGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The market type. Can be `spot`.
        /// </summary>
        [Input("marketType")]
        public Input<string>? MarketType { get; set; }

        /// <summary>
        /// The options for [Spot Instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-spot-instances.html)
        /// </summary>
        [Input("spotOptions")]
        public Input<Inputs.LaunchTemplateInstanceMarketOptionsSpotOptionsGetArgs>? SpotOptions { get; set; }

        public LaunchTemplateInstanceMarketOptionsGetArgs()
        {
        }
        public static new LaunchTemplateInstanceMarketOptionsGetArgs Empty => new LaunchTemplateInstanceMarketOptionsGetArgs();
    }
}
