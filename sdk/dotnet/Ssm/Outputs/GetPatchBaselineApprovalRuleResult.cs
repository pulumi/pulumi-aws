// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ssm.Outputs
{

    [OutputType]
    public sealed class GetPatchBaselineApprovalRuleResult
    {
        /// <summary>
        /// Number of days after the release date of each patch matched by the rule the patch is marked as approved in the patch baseline.
        /// </summary>
        public readonly int ApproveAfterDays;
        /// <summary>
        /// Cutoff date for auto approval of released patches. Any patches released on or before this date are installed automatically. Date is formatted as `YYYY-MM-DD`. Conflicts with `approve_after_days`
        /// </summary>
        public readonly string ApproveUntilDate;
        /// <summary>
        /// Compliance level for patches approved by this rule.
        /// </summary>
        public readonly string ComplianceLevel;
        /// <summary>
        /// Boolean enabling the application of non-security updates.
        /// </summary>
        public readonly bool EnableNonSecurity;
        /// <summary>
        /// Patch filter group that defines the criteria for the rule.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetPatchBaselineApprovalRulePatchFilterResult> PatchFilters;

        [OutputConstructor]
        private GetPatchBaselineApprovalRuleResult(
            int approveAfterDays,

            string approveUntilDate,

            string complianceLevel,

            bool enableNonSecurity,

            ImmutableArray<Outputs.GetPatchBaselineApprovalRulePatchFilterResult> patchFilters)
        {
            ApproveAfterDays = approveAfterDays;
            ApproveUntilDate = approveUntilDate;
            ComplianceLevel = complianceLevel;
            EnableNonSecurity = enableNonSecurity;
            PatchFilters = patchFilters;
        }
    }
}
