// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudWatch.Inputs
{

    public sealed class GetLogDataProtectionPolicyDocumentStatementOperationAuditInputArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Configures destinations to send audit findings to.
        /// </summary>
        [Input("findingsDestination", required: true)]
        public Input<Inputs.GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationInputArgs> FindingsDestination { get; set; } = null!;

        public GetLogDataProtectionPolicyDocumentStatementOperationAuditInputArgs()
        {
        }
        public static new GetLogDataProtectionPolicyDocumentStatementOperationAuditInputArgs Empty => new GetLogDataProtectionPolicyDocumentStatementOperationAuditInputArgs();
    }
}
