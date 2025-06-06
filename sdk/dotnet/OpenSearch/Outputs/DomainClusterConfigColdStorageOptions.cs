// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.OpenSearch.Outputs
{

    [OutputType]
    public sealed class DomainClusterConfigColdStorageOptions
    {
        /// <summary>
        /// Boolean to enable cold storage for an OpenSearch domain. Defaults to `false`. Master and ultrawarm nodes must be enabled for cold storage.
        /// </summary>
        public readonly bool? Enabled;

        [OutputConstructor]
        private DomainClusterConfigColdStorageOptions(bool? enabled)
        {
            Enabled = enabled;
        }
    }
}
