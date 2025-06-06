// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Budgets.Inputs
{

    public sealed class BudgetActionDefinitionScpActionDefinitionGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The policy ID attached.
        /// </summary>
        [Input("policyId", required: true)]
        public Input<string> PolicyId { get; set; } = null!;

        [Input("targetIds", required: true)]
        private InputList<string>? _targetIds;

        /// <summary>
        /// A list of target IDs.
        /// </summary>
        public InputList<string> TargetIds
        {
            get => _targetIds ?? (_targetIds = new InputList<string>());
            set => _targetIds = value;
        }

        public BudgetActionDefinitionScpActionDefinitionGetArgs()
        {
        }
        public static new BudgetActionDefinitionScpActionDefinitionGetArgs Empty => new BudgetActionDefinitionScpActionDefinitionGetArgs();
    }
}
