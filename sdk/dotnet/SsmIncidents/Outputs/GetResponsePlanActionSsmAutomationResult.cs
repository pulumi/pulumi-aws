// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SsmIncidents.Outputs
{

    [OutputType]
    public sealed class GetResponsePlanActionSsmAutomationResult
    {
        /// <summary>
        /// The automation document's name.
        /// </summary>
        public readonly string DocumentName;
        /// <summary>
        /// The version of the automation document to use at runtime.
        /// </summary>
        public readonly string DocumentVersion;
        /// <summary>
        /// The key-value pair used to resolve dynamic parameter values when processing a Systems Manager Automation runbook.
        /// </summary>
        public readonly ImmutableDictionary<string, string> DynamicParameters;
        /// <summary>
        /// The key-value pair parameters used when the automation document runs. The following values are supported:
        /// </summary>
        public readonly ImmutableArray<Outputs.GetResponsePlanActionSsmAutomationParameterResult> Parameters;
        /// <summary>
        /// The Amazon Resource Name (ARN) of the role that the automation document assumes when it runs commands.
        /// </summary>
        public readonly string RoleArn;
        /// <summary>
        /// The account that runs the automation document. This can be in either the management account or an application account.
        /// </summary>
        public readonly string TargetAccount;

        [OutputConstructor]
        private GetResponsePlanActionSsmAutomationResult(
            string documentName,

            string documentVersion,

            ImmutableDictionary<string, string> dynamicParameters,

            ImmutableArray<Outputs.GetResponsePlanActionSsmAutomationParameterResult> parameters,

            string roleArn,

            string targetAccount)
        {
            DocumentName = documentName;
            DocumentVersion = documentVersion;
            DynamicParameters = dynamicParameters;
            Parameters = parameters;
            RoleArn = roleArn;
            TargetAccount = targetAccount;
        }
    }
}