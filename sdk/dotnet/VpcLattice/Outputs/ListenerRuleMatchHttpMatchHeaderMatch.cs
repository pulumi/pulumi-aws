// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VpcLattice.Outputs
{

    [OutputType]
    public sealed class ListenerRuleMatchHttpMatchHeaderMatch
    {
        /// <summary>
        /// Indicates whether the match is case sensitive.
        /// Default is `false`.
        /// </summary>
        public readonly bool? CaseSensitive;
        /// <summary>
        /// The header match type.
        /// See Header Match `match` Block for details.
        /// </summary>
        public readonly Outputs.ListenerRuleMatchHttpMatchHeaderMatchMatch Match;
        /// <summary>
        /// The name of the header.
        /// </summary>
        public readonly string Name;

        [OutputConstructor]
        private ListenerRuleMatchHttpMatchHeaderMatch(
            bool? caseSensitive,

            Outputs.ListenerRuleMatchHttpMatchHeaderMatchMatch match,

            string name)
        {
            CaseSensitive = caseSensitive;
            Match = match;
            Name = name;
        }
    }
}
