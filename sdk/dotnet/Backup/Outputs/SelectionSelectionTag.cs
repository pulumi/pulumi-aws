// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Backup.Outputs
{

    [OutputType]
    public sealed class SelectionSelectionTag
    {
        /// <summary>
        /// Key for the filter.
        /// </summary>
        public readonly string Key;
        /// <summary>
        /// An operation, such as `STRINGEQUALS`, that is applied to the key-value pair used to filter resources in a selection.
        /// </summary>
        public readonly string Type;
        /// <summary>
        /// Value for the filter.
        /// </summary>
        public readonly string Value;

        [OutputConstructor]
        private SelectionSelectionTag(
            string key,

            string type,

            string value)
        {
            Key = key;
            Type = type;
            Value = value;
        }
    }
}
