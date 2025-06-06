// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Inspector2.Outputs
{

    [OutputType]
    public sealed class FilterFilterCriteriaResourceTag
    {
        /// <summary>
        /// (Required) The comparison operator. Valid values: `EQUALS`.
        /// </summary>
        public readonly string Comparison;
        /// <summary>
        /// (Required) The key to filter on.
        /// </summary>
        public readonly string Key;
        /// <summary>
        /// (Required) The value to filter on.
        /// </summary>
        public readonly string Value;

        [OutputConstructor]
        private FilterFilterCriteriaResourceTag(
            string comparison,

            string key,

            string value)
        {
            Comparison = comparison;
            Key = key;
            Value = value;
        }
    }
}
