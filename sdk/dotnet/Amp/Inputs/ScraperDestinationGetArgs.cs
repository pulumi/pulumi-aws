// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Amp.Inputs
{

    public sealed class ScraperDestinationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Configuration block for an Amazon Managed Prometheus workspace destination. See `amp`.
        /// </summary>
        [Input("amp")]
        public Input<Inputs.ScraperDestinationAmpGetArgs>? Amp { get; set; }

        public ScraperDestinationGetArgs()
        {
        }
        public static new ScraperDestinationGetArgs Empty => new ScraperDestinationGetArgs();
    }
}
