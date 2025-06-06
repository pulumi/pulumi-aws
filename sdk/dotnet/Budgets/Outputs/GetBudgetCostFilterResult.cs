// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Budgets.Outputs
{

    [OutputType]
    public sealed class GetBudgetCostFilterResult
    {
        /// <summary>
        /// The name of a budget. Unique within accounts.
        /// 
        /// The following arguments are optional:
        /// </summary>
        public readonly string Name;
        public readonly ImmutableArray<string> Values;

        [OutputConstructor]
        private GetBudgetCostFilterResult(
            string name,

            ImmutableArray<string> values)
        {
            Name = name;
            Values = values;
        }
    }
}
