// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kendra.Outputs
{

    [OutputType]
    public sealed class GetQuerySuggestionsBlockListSourceS3PathResult
    {
        /// <summary>
        /// Name of the S3 bucket that contains the file.
        /// </summary>
        public readonly string Bucket;
        /// <summary>
        /// Name of the file.
        /// </summary>
        public readonly string Key;

        [OutputConstructor]
        private GetQuerySuggestionsBlockListSourceS3PathResult(
            string bucket,

            string key)
        {
            Bucket = bucket;
            Key = key;
        }
    }
}
