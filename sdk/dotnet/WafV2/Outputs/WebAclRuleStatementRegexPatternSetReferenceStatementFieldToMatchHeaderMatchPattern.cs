// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafV2.Outputs
{

    [OutputType]
    public sealed class WebAclRuleStatementRegexPatternSetReferenceStatementFieldToMatchHeaderMatchPattern
    {
        /// <summary>
        /// An empty configuration block that is used for inspecting all headers.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRegexPatternSetReferenceStatementFieldToMatchHeaderMatchPatternAll? All;
        /// <summary>
        /// An array of strings that will be used for inspecting headers that do not have a key that matches one of the provided values.
        /// </summary>
        public readonly ImmutableArray<string> ExcludedHeaders;
        /// <summary>
        /// An array of strings that will be used for inspecting headers that have a key that matches one of the provided values.
        /// </summary>
        public readonly ImmutableArray<string> IncludedHeaders;

        [OutputConstructor]
        private WebAclRuleStatementRegexPatternSetReferenceStatementFieldToMatchHeaderMatchPattern(
            Outputs.WebAclRuleStatementRegexPatternSetReferenceStatementFieldToMatchHeaderMatchPatternAll? all,

            ImmutableArray<string> excludedHeaders,

            ImmutableArray<string> includedHeaders)
        {
            All = all;
            ExcludedHeaders = excludedHeaders;
            IncludedHeaders = includedHeaders;
        }
    }
}
