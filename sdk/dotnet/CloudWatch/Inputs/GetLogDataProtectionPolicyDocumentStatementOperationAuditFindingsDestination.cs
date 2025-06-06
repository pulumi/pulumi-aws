// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudWatch.Inputs
{

    public sealed class GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Configures CloudWatch Logs as a findings destination.
        /// </summary>
        [Input("cloudwatchLogs")]
        public Inputs.GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationCloudwatchLogsArgs? CloudwatchLogs { get; set; }

        /// <summary>
        /// Configures Kinesis Firehose as a findings destination.
        /// </summary>
        [Input("firehose")]
        public Inputs.GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationFirehoseArgs? Firehose { get; set; }

        /// <summary>
        /// Configures S3 as a findings destination.
        /// </summary>
        [Input("s3")]
        public Inputs.GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationS3Args? S3 { get; set; }

        public GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationArgs()
        {
        }
        public static new GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationArgs Empty => new GetLogDataProtectionPolicyDocumentStatementOperationAuditFindingsDestinationArgs();
    }
}
