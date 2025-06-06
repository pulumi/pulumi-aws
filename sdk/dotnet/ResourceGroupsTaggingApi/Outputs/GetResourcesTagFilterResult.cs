// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ResourceGroupsTaggingApi.Outputs
{

    [OutputType]
    public sealed class GetResourcesTagFilterResult
    {
        /// <summary>
        /// One part of a key-value pair that makes up a tag.
        /// </summary>
        public readonly string Key;
        /// <summary>
        /// Optional part of a key-value pair that make up a tag.
        /// </summary>
        public readonly ImmutableArray<string> Values;

        [OutputConstructor]
        private GetResourcesTagFilterResult(
            string key,

            ImmutableArray<string> values)
        {
            Key = key;
            Values = values;
        }
    }
}
