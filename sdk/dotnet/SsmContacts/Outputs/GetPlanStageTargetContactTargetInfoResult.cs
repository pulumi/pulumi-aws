// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SsmContacts.Outputs
{

    [OutputType]
    public sealed class GetPlanStageTargetContactTargetInfoResult
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) of the contact or escalation plan.
        /// </summary>
        public readonly string ContactId;
        public readonly bool IsEssential;

        [OutputConstructor]
        private GetPlanStageTargetContactTargetInfoResult(
            string contactId,

            bool isEssential)
        {
            ContactId = contactId;
            IsEssential = isEssential;
        }
    }
}
