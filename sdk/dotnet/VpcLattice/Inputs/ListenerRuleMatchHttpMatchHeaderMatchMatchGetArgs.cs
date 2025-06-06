// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VpcLattice.Inputs
{

    public sealed class ListenerRuleMatchHttpMatchHeaderMatchMatchGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Specifies a contains type match.
        /// </summary>
        [Input("contains")]
        public Input<string>? Contains { get; set; }

        /// <summary>
        /// Specifies an exact type match.
        /// </summary>
        [Input("exact")]
        public Input<string>? Exact { get; set; }

        /// <summary>
        /// Specifies a prefix type match.
        /// Matches the value with the prefix.
        /// </summary>
        [Input("prefix")]
        public Input<string>? Prefix { get; set; }

        public ListenerRuleMatchHttpMatchHeaderMatchMatchGetArgs()
        {
        }
        public static new ListenerRuleMatchHttpMatchHeaderMatchMatchGetArgs Empty => new ListenerRuleMatchHttpMatchHeaderMatchMatchGetArgs();
    }
}
