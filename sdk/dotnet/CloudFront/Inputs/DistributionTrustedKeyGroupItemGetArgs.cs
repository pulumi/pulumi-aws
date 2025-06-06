// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudFront.Inputs
{

    public sealed class DistributionTrustedKeyGroupItemGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ID of the key group that contains the public keys.
        /// </summary>
        [Input("keyGroupId")]
        public Input<string>? KeyGroupId { get; set; }

        [Input("keyPairIds")]
        private InputList<string>? _keyPairIds;

        /// <summary>
        /// Set of active CloudFront key pairs associated with the signer account
        /// </summary>
        public InputList<string> KeyPairIds
        {
            get => _keyPairIds ?? (_keyPairIds = new InputList<string>());
            set => _keyPairIds = value;
        }

        public DistributionTrustedKeyGroupItemGetArgs()
        {
        }
        public static new DistributionTrustedKeyGroupItemGetArgs Empty => new DistributionTrustedKeyGroupItemGetArgs();
    }
}
