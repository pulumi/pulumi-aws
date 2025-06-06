// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Auditmanager.Outputs
{

    [OutputType]
    public sealed class AssessmentScope
    {
        /// <summary>
        /// Amazon Web Services accounts that are in scope for the assessment. See `aws_accounts` below.
        /// </summary>
        public readonly ImmutableArray<Outputs.AssessmentScopeAwsAccount> AwsAccounts;
        /// <summary>
        /// Amazon Web Services services that are included in the scope of the assessment. See `aws_services` below.
        /// </summary>
        public readonly ImmutableArray<Outputs.AssessmentScopeAwsService> AwsServices;

        [OutputConstructor]
        private AssessmentScope(
            ImmutableArray<Outputs.AssessmentScopeAwsAccount> awsAccounts,

            ImmutableArray<Outputs.AssessmentScopeAwsService> awsServices)
        {
            AwsAccounts = awsAccounts;
            AwsServices = awsServices;
        }
    }
}
