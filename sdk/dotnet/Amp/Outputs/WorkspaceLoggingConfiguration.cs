// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Amp.Outputs
{

    [OutputType]
    public sealed class WorkspaceLoggingConfiguration
    {
        /// <summary>
        /// The ARN of the CloudWatch log group to which the vended log data will be published. This log group must exist.
        /// </summary>
        public readonly string LogGroupArn;

        [OutputConstructor]
        private WorkspaceLoggingConfiguration(string logGroupArn)
        {
            LogGroupArn = logGroupArn;
        }
    }
}
