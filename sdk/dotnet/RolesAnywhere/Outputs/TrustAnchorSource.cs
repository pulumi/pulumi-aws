// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.RolesAnywhere.Outputs
{

    [OutputType]
    public sealed class TrustAnchorSource
    {
        /// <summary>
        /// The data denoting the source of trust, documented below
        /// </summary>
        public readonly Outputs.TrustAnchorSourceSourceData SourceData;
        /// <summary>
        /// The type of the source of trust. Must be either `AWS_ACM_PCA` or `CERTIFICATE_BUNDLE`.
        /// </summary>
        public readonly string SourceType;

        [OutputConstructor]
        private TrustAnchorSource(
            Outputs.TrustAnchorSourceSourceData sourceData,

            string sourceType)
        {
            SourceData = sourceData;
            SourceType = sourceType;
        }
    }
}
