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
    public sealed class RuleGroupRuleActionAllowCustomRequestHandling
    {
        /// <summary>
        /// The `insert_header` blocks used to define HTTP headers added to the request. See Custom HTTP Header below for details.
        /// </summary>
        public readonly ImmutableArray<Outputs.RuleGroupRuleActionAllowCustomRequestHandlingInsertHeader> InsertHeaders;

        [OutputConstructor]
        private RuleGroupRuleActionAllowCustomRequestHandling(ImmutableArray<Outputs.RuleGroupRuleActionAllowCustomRequestHandlingInsertHeader> insertHeaders)
        {
            InsertHeaders = insertHeaders;
        }
    }
}
