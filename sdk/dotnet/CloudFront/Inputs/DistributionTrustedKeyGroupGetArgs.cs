// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudFront.Inputs
{

    public sealed class DistributionTrustedKeyGroupGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Whether the distribution is enabled to accept end user requests for content.
        /// </summary>
        [Input("enabled")]
        public Input<bool>? Enabled { get; set; }

        [Input("items")]
        private InputList<Inputs.DistributionTrustedKeyGroupItemGetArgs>? _items;

        /// <summary>
        /// List of nested attributes for each trusted signer
        /// </summary>
        public InputList<Inputs.DistributionTrustedKeyGroupItemGetArgs> Items
        {
            get => _items ?? (_items = new InputList<Inputs.DistributionTrustedKeyGroupItemGetArgs>());
            set => _items = value;
        }

        public DistributionTrustedKeyGroupGetArgs()
        {
        }
        public static new DistributionTrustedKeyGroupGetArgs Empty => new DistributionTrustedKeyGroupGetArgs();
    }
}
