// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Fsx.Outputs
{

    [OutputType]
    public sealed class GetWindowsFileSystemAuditLogConfigurationResult
    {
        public readonly string AuditLogDestination;
        public readonly string FileAccessAuditLogLevel;
        public readonly string FileShareAccessAuditLogLevel;

        [OutputConstructor]
        private GetWindowsFileSystemAuditLogConfigurationResult(
            string auditLogDestination,

            string fileAccessAuditLogLevel,

            string fileShareAccessAuditLogLevel)
        {
            AuditLogDestination = auditLogDestination;
            FileAccessAuditLogLevel = fileAccessAuditLogLevel;
            FileShareAccessAuditLogLevel = fileShareAccessAuditLogLevel;
        }
    }
}