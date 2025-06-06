// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LB.Outputs
{

    [OutputType]
    public sealed class GetListenerRuleConditionSourceIpResult
    {
        /// <summary>
        /// Set of `key`-`value` pairs indicating the query string parameters to match.
        /// </summary>
        public readonly ImmutableArray<string> Values;

        [OutputConstructor]
        private GetListenerRuleConditionSourceIpResult(ImmutableArray<string> values)
        {
            Values = values;
        }
    }
}
