// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3.Outputs
{

    [OutputType]
    public sealed class BucketWebsiteConfigurationV2ErrorDocument
    {
        /// <summary>
        /// Object key name to use when a 4XX class error occurs.
        /// </summary>
        public readonly string Key;

        [OutputConstructor]
        private BucketWebsiteConfigurationV2ErrorDocument(string key)
        {
            Key = key;
        }
    }
}
